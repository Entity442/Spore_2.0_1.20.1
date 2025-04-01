package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;

public class InfectedPillager extends Infected implements CrossbowAttackMob , InventoryCarrier , EvolvingInfected, ArmedInfected {
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(InfectedPillager.class, EntityDataSerializers.BOOLEAN);
    private static final int INVENTORY_SIZE = 5;
    private static final int SLOT_OFFSET = 300;
    private final SimpleContainer inventory = new SimpleContainer(5);

    public InfectedPillager(EntityType<? extends Infected> type, Level level) {
        super(type, level);
    }

    public boolean canFireProjectileWeapon(ProjectileWeaponItem p_33280_) {
        return p_33280_ == Items.CROSSBOW;
    }

    public boolean isChargingCrossbow() {
        return this.entityData.get(IS_CHARGING_CROSSBOW);
    }

    public void setChargingCrossbow(boolean p_33302_) {
        this.entityData.set(IS_CHARGING_CROSSBOW, p_33302_);
    }

    public void shootCrossbowProjectile(LivingEntity entity, ItemStack itemStack, Projectile projectile, float f) {
        if (projectile instanceof Arrow){
            ((Arrow) projectile).addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 120));
        }
        this.shootCrossbowProjectile(this, entity, projectile, f, (float) (SConfig.SERVER.inf_pil_range_damage.get() * 1f));
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CHARGING_CROSSBOW, false);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_pillager_loot.get();
    }
    @Override
    public boolean startRiding(Entity entity) {
        if (!this.getMainHandItem().equals(new ItemStack(Items.CROSSBOW))){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
        }
        return super.startRiding(entity);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new RangedCrossbowAttackGoal<>(this, 1.0D, 8.0F));
        this.goalSelector.addGoal(2 , new CustomMeleeAttackGoal(this ,1.4,true){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
            return 3.0 + entity.getBbWidth() * entity.getBbWidth();
        }});
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_pil_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_pil_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_pil_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public void onCrossbowAttackPerformed() {
        this.noActionTime = 0;
    }

    public void addAdditionalSaveData(CompoundTag p_33300_) {
        super.addAdditionalSaveData(p_33300_);
        ListTag listtag = new ListTag();

        for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                listtag.add(itemstack.save(new CompoundTag()));
            }
        }

        p_33300_.put("Inventory", listtag);
    }

    public void readAdditionalSaveData(CompoundTag p_33291_) {
        super.readAdditionalSaveData(p_33291_);
        ListTag listtag = p_33291_.getList("Inventory", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            ItemStack itemstack = ItemStack.of(listtag.getCompound(i));
            if (!itemstack.isEmpty()) {
                this.inventory.addItem(itemstack);
            }
        }

        this.setCanPickUpLoot(true);
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        if (Math.random() < 0.5) {
              this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
             }
        else {
            this.setItemSlot(EquipmentSlot.MAINHAND,  ItemStack.EMPTY);
        }
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }


    public void performRangedAttack(LivingEntity p_33272_, float p_33273_) {
        this.performCrossbowAttack(this, 1.6F);
    }


    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        RandomSource randomsource = p_33282_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_33283_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_33283_);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }


    public SlotAccess getSlot(int p_149743_) {
        int i = p_149743_ - 300;
        return i >= 0 && i < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, i) : super.getSlot(p_149743_);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getHurtSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound() {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    @Override
    public void baseTick() {
        super.baseTick();
        tickEvolution(this,SConfig.SERVER.pil_ev.get(), ScamperVariants.VILLAGER);
    }

    @Override
    public String origin() {
        return "minecraft:pillager";
    }
}
