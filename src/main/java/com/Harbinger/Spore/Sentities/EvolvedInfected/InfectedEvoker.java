package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Hyper.Hevoker;
import com.Harbinger.Spore.Sentities.Utility.InfEvoClaw;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class InfectedEvoker extends EvolvedInfected implements InventoryCarrier, EvolvingInfected {
    private static final EntityDataAccessor<Boolean> HAS_ARM = SynchedEntityData.defineId(InfectedEvoker.class, EntityDataSerializers.BOOLEAN);
    public InfectedEvoker(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    private final SimpleContainer inventory = new SimpleContainer(5);

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_evo_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_evo_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_evo_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_evoker_loot.get();
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(HAS_ARM, true);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.getEntityData().get(HAS_ARM) && (Objects.requireNonNull(this.getAttribute(Attributes.ATTACK_DAMAGE)).getBaseValue() == SConfig.SERVER.inf_evo_damage.get() * SConfig.SERVER.global_damage.get())){
            AttributeInstance attackDamage = this.getAttribute(Attributes.ATTACK_DAMAGE);
            assert attackDamage != null;
            attackDamage.setBaseValue((SConfig.SERVER.inf_evo_damage.get()/2) * SConfig.SERVER.global_damage.get());
        }
        this.tickHyperEvolution(this);
    }
    public boolean hasArm(){
        return entityData.get(HAS_ARM);
    }
    public void setArm(boolean b){
        entityData.set(HAS_ARM,b);
    }


    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("arm",entityData.get(HAS_ARM));
        ListTag listtag = new ListTag();

        for(int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                listtag.add(itemstack.save(new CompoundTag()));
            }
        }

        tag.put("Inventory", listtag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(HAS_ARM ,tag.getBoolean("arm"));
        ListTag listtag = tag.getList("Inventory", 10);

        for(int i = 0; i < listtag.size(); ++i) {
            ItemStack itemstack = ItemStack.of(listtag.getCompound(i));
            if (!itemstack.isEmpty()) {
                this.inventory.addItem(itemstack);
            }
        }

        this.setCanPickUpLoot(false);
    }

    @Override
    public SimpleContainer getInventory() {
        return this.inventory;
    }
    protected void populateDefaultEquipmentSlots(RandomSource p_219059_, DifficultyInstance p_219060_) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
    }
    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        RandomSource randomsource = p_33282_.getRandom();
        this.populateDefaultEquipmentSlots(randomsource, p_33283_);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public SlotAccess getSlot(int p_149743_) {
        int i = p_149743_ - 300;
        return i >= 0 && i < this.inventory.getContainerSize() ? SlotAccess.forContainer(this.inventory, i) : super.getSlot(p_149743_);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_EVOKER_GROWL.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_EVOKER_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_EVOKER_DEATH.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2 , new CustomMeleeAttackGoal(this ,1.4,true){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                if (entityData.get(HAS_ARM)){
                    return 6.0 + entity.getBbWidth() * entity.getBbWidth();}
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}});


        this.goalSelector.addGoal(1, new PullGoal(this, 32, 8){
            @Override
            public boolean canUse() {
                return switchy();
            }
        });


        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));

    }

    private boolean switchy() {
        if (this.getTarget() != null){
            double ze = this.distanceToSqr(this.getTarget());
            return (ze > 200.0D) && (ze < 600.0D) && entityData.get(HAS_ARM);
        }
        return false;
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (Math.random() < 0.3){
        SummonArm(this.level(), this.getX(), this.getY(), this.getZ(), this);
        }
        return super.hurt(source, amount);
    }

    private void SummonArm(LevelAccessor levelAccessor ,double x, double y, double z, Entity entity){
        if (levelAccessor instanceof ServerLevel _level && entityData.get(HAS_ARM)) {
                Mob entityToSpawn = new InfEvoClaw(Sentities.CLAW.get(), _level);
                entityToSpawn.moveTo(x, y, z, levelAccessor.getRandom().nextFloat() * 360F, 0);
                entityToSpawn.finalizeSpawn(_level, levelAccessor.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null,
                        null);
                levelAccessor.addFreshEntity(entityToSpawn);
            this.entityData.set(HAS_ARM, false);
        }
    }

    @Override
    public void HyperEvolve(LivingEntity living) {
        Hevoker brot = new Hevoker(Sentities.HEVOKER.get(),this.level());
        Collection<MobEffectInstance> collection = this.getActiveEffects();
        for(MobEffectInstance mobeffectinstance : collection) {
            brot.addEffect(new MobEffectInstance(mobeffectinstance));
        }
        brot.setKills(this.getKills());
        brot.setEvoPoints(this.getEvoPoints()-SConfig.SERVER.min_kills_hyper.get());
        brot.setCustomName(this.getCustomName());
        brot.setPos(this.getX(),this.getY(),this.getZ());
        if (this.level() instanceof ServerLevel serverLevel)
            brot.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()), MobSpawnType.CONVERSION,null,null);
        this.level().addFreshEntity(brot);
        this.discard();
        EvolvingInfected.super.HyperEvolve(living);
    }

    @Override
    public String origin() {
        return "minecraft:evoker";
    }
}
