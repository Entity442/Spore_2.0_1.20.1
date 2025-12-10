package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Utility.Vanguard;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.InfPillagerSkins;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

import javax.annotation.Nullable;
import java.util.List;

public class InfectedPillager extends Infected implements CrossbowAttackMob , EvolvingInfected, ArmedInfected , VariantKeeper {
    private static final EntityDataAccessor<Boolean> IS_CHARGING_CROSSBOW = SynchedEntityData.defineId(InfectedPillager.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(InfectedPillager.class, EntityDataSerializers.INT);
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
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
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

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
        if (Math.random() < 0.5) {
              this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.CROSSBOW));
             }
        else {
            this.setItemSlot(EquipmentSlot.MAINHAND,  ItemStack.EMPTY);
        }
    }


    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        ItemStack itemstack = this.getProjectile(this.getItemInHand(ProjectileUtil.getWeaponHoldingHand(this, item -> item instanceof net.minecraft.world.item.BowItem)));
        AbstractArrow abstractarrow = this.getArrow(itemstack, distanceFactor);
        if (this.getMainHandItem().getItem() instanceof net.minecraft.world.item.BowItem)
            abstractarrow = ((net.minecraft.world.item.BowItem)this.getMainHandItem().getItem()).customArrow(abstractarrow);
        double d0 = target.getX() - this.getX();
        double d1 = target.getY(0.3333333333333333D) - abstractarrow.getY();
        double d2 = target.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        if(abstractarrow instanceof Arrow arrow){
            arrow.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600));
        }
        abstractarrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        this.playSound(SoundEvents.CROSSBOW_SHOOT, 1.0F, 1.0F / (this.getRandom().nextFloat() * 0.4F + 0.8F));
        this.level().addFreshEntity(abstractarrow);
    }
    protected AbstractArrow getArrow(ItemStack p_32156_, float p_32157_) {
        return ProjectileUtil.getMobArrow(this, p_32156_, p_32157_);
    }


    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        RandomSource randomsource = p_33282_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_33283_);
        this.populateDefaultEquipmentEnchantments(randomsource, p_33283_);
        setVariant(Math.random() < 0.2 ? InfPillagerSkins.CAPTAIN : InfPillagerSkins.DEFAULT);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }



    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_PILLAGER_AMBIENT.get();
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
    @Override
    public void Evolve(Infected livingEntity, List<? extends String> value, ScamperVariants variants) {
        if (this.getLinked() && this.getVariant() == InfPillagerSkins.CAPTAIN){
            Vanguard vanguard = new Vanguard(Sentities.VANGUARD.get(),level());
            vanguard.setKills(this.getKills() + this.getEvoPoints());
            vanguard.setCustomName(this.getCustomName());
            vanguard.moveTo(this.getX(),this.getY(),this.getZ());
            if (level() instanceof ServerLevel serverLevel){
                DifficultyInstance instance = livingEntity.level().getCurrentDifficultyAt(new BlockPos((int) livingEntity.getX(),(int)  livingEntity.getY(),(int)  livingEntity.getZ()));
                vanguard.finalizeSpawn(serverLevel, instance, MobSpawnType.CONVERSION, null,null);
                double x0 = livingEntity.getX() - (random.nextFloat() - 0.1) * 0.1D;
                double y0 = livingEntity.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
                double z0 = livingEntity.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            }
            level().addFreshEntity(vanguard);
            this.discard();
        }else{
            EvolvingInfected.super.Evolve(livingEntity, value, variants);
        }
    }
    private void setVariant(InfPillagerSkins variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    public InfPillagerSkins getVariant() {
        return InfPillagerSkins.byId(this.getTypeVariant() & 255);
    }
    @Override
    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > InfPillagerSkins.values().length || i < 0 ? 0 : i);
    }
    @Override
    public int amountOfMutations() {
        return InfPillagerSkins.values().length;
    }
}
