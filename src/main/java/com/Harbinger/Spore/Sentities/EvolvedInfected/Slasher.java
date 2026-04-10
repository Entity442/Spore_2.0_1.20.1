package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
import com.Harbinger.Spore.Sentities.Variants.ThornVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.WeakHashMap;

public class Slasher extends EvolvedInfected implements ArmorPersentageBypass, VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Slasher.class, EntityDataSerializers.INT);
    private final WeakHashMap<LivingEntity,Double> screwMap = new WeakHashMap<>();
    public Slasher(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sla_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.22)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sla_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sla_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.ATTACK_KNOCKBACK, 0);

    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (this.getVariant() == SlasherVariants.PIERCER){
            return SdamageTypes.slasher_piercing_damage(entity);
        }
        if (Math.random() < 0.3){
            return SdamageTypes.slasher_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_slasher_loot.get();
    }
    @Override
    public boolean canDisableShield() {
        if (this.getVariant() == SlasherVariants.PIERCER){
            return true;
        }
        return super.canDisableShield();
    }
    public double getRanges(){return getVariant() == SlasherVariants.GRABBER ? 1.5 : 1;}
    public boolean pull(){
        if (getVariant() == SlasherVariants.PIERCER || getVariant() == SlasherVariants.SMASHER){
            return false;
        }
        LivingEntity living = this.getTarget();
        return living != null && this.distanceToSqr(living) < 32 * getRanges() && this.distanceToSqr(living) > 16 * getRanges() && hasLineOfSight(living);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3,livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(1, new PullGoal(this, 32, 16){
            @Override
            public boolean canUse() {
                return pull();
            }

            @Override
            public void start() {
                super.start();
                mob.playSound(Ssounds.SLASHER_PULL.get());
                mob.level().broadcastEntityEvent(mob, (byte)4);
            }
        });
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true) {
            @Override
            public boolean canUse() {
                return super.canUse() && SConfig.SERVER.higher_thinking.get();
            }
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }
    protected void customServerAiStep() {
        if (!this.isNoAi() && GoalUtils.hasGroundPathNavigation(this) && SConfig.SERVER.higher_thinking.get()) {
            ((GroundPathNavigation)this.getNavigation()).setCanOpenDoors(true);
        }
        super.customServerAiStep();
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof ServerPlayer player && this.getVariant() == SlasherVariants.PIERCER && !player.isBlocking()){
            player.getInventory().hurtArmor(SdamageTypes.slasher_piercing_damage(this),35.0f, Inventory.ALL_ARMOR_SLOTS);
        }
        if (this.getVariant() == SlasherVariants.SMASHER && entity instanceof LivingEntity livingEntity){
            livingEntity.hurtMarked = true;
            livingEntity.knockback((2f),  Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (double) (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
        }
        if (this.getVariant() == SlasherVariants.GRABBER && entity instanceof LivingEntity livingEntity){
            if (!level().isClientSide && Math.random() <0.15){
                if (Math.random() < 0.5){
                    dropItems(livingEntity,InteractionHand.MAIN_HAND,livingEntity.getOnPos());
                }else {
                    dropItems(livingEntity,InteractionHand.OFF_HAND,livingEntity.getOnPos());
                }
            }
        }
        if (this.getVariant() == SlasherVariants.SCREW){
            double defaultDamage = SConfig.SERVER.sla_damage.get() * SConfig.SERVER.global_damage.get();
            double damageMod = 1;
            if (entity instanceof LivingEntity living){
                if (screwMap.containsKey(living)){
                    damageMod = screwMap.get(living);
                    double newMod = Math.min(2.5, damageMod + 0.5);
                    screwMap.put(living, newMod);
                    damageMod = newMod;
                } else {
                    screwMap.put(living, 1.0);
                }
            }
            AttributeInstance instance = getAttribute(Attributes.ATTACK_DAMAGE);
            if (instance != null){
                instance.setBaseValue(defaultDamage * damageMod);
            }
        }
        this.playSound(Ssounds.SLASHER_STAB.get());
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getDirectEntity() instanceof LivingEntity livingEntity && livingEntity.distanceToSqr(this)<100D && !source.is(DamageTypes.THORNS) && getVariant() == SlasherVariants.SCREW){
            livingEntity.hurt(this.level().damageSources().thorns(this),5);
        }
        return super.hurt(source, amount);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        if (entity instanceof LivingEntity living){
            screwMap.remove(living);
        }
    }

    private void dropItems(LivingEntity living, InteractionHand hand, BlockPos pos){
        ItemStack stack = living.getItemInHand(hand);
        if (stack == ItemStack.EMPTY){
            return;
        }
        ItemEntity entity = new ItemEntity(level(),pos.getX(),pos.getY(),pos.getZ(),stack);
        level().addFreshEntity(entity);
        living.setItemInHand(hand,ItemStack.EMPTY);
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_VILLAGER_DEATH.get();
    }


    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        SlasherVariants variant = Util.getRandom(SlasherVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public SlasherVariants getVariant() {
        return SlasherVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        if (i > SlasherVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return SlasherVariants.values().length;
    }

    private void setVariant(SlasherVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public float amountOfDamage(float value) {
        return this.getVariant() == SlasherVariants.PIERCER ? (float) (SConfig.SERVER.sla_damage.get() * SConfig.SERVER.global_damage.get() / 2) : 0;
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }
}
