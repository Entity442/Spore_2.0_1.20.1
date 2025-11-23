package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.Projectile.AdaptableProjectile;
import com.Harbinger.Spore.Sentities.Projectile.VomitUsurperBall;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.BulletParameters;
import com.Harbinger.Spore.Sentities.Variants.UsurperVariants;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Usurper extends Organoid implements RangedAttackMob , VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Usurper.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Usurper.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BURST_CONTROL = SynchedEntityData.defineId(Usurper.class, EntityDataSerializers.INT);
    public Usurper(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    public int getEmerge_tick(){
        return 60;
    }
    @Override
    public int getBorrow_tick() {
        return 100;
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.usurper_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.usurper_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timer",entityData.get(TIMER));
        tag.putInt("Variant",this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER,0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(BURST_CONTROL, 0);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(1,new RangedAttackGoal(this,0,5,5,1.5f){
            @Override
            public boolean canUse() {
                return super.canUse() && getVariant() == UsurperVariants.SPRAY;
            }
        });
        this.goalSelector.addGoal(2,new ScatterShotRangedGoal(this,0,40,32,1,4){
            @Override
            public boolean canUse() {
                return super.canUse() && getVariant() == UsurperVariants.DEFAULT;
            }
        });
        this.goalSelector.addGoal(3 ,new RandomLookAroundGoal(this));
        super.registerGoals();
    }
    public void setBurstControl(int value){
        entityData.set(BURST_CONTROL,value);
    }
    public int getBurstControl(){
        return entityData.get(BURST_CONTROL);
    }
    public void countDownBurstControl(){
        setBurstControl(getBurstControl()-1);
    }

    public void tickBurstShotController(){
        LivingEntity target = this.getTarget();
        if (target == null){
            return;
        }
        this.getLookControl().setLookAt(target, 30.0F, 30.0F);
        if (getBurstControl() > -5){
            countDownBurstControl();
        }else {
            if (this.hasLineOfSight(target)){
                setBurstControl(random.nextInt(3,7));
            }
        }
        if (getBurstControl() > 0){
            performRangedAttack(target,0);
        }
    }
    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide){
            if (this.getTarget() == null && this.entityData.get(TIMER) < 1200){
                this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
            }else if (this.entityData.get(TIMER) >= 1200){
                tickBurrowing();
            }
            if (tickCount % 20 == 0 && getVariant() == UsurperVariants.BURST){
                tickBurstShotController();
            }
        }
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.usurper_loot.get();
    }

    @Override
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > this.getBorrow_tick()) {
            this.discard();
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }
    @Override
    public boolean hurt(DamageSource source, float value) {
        if (this.isEmerging()){
            return false;
        }
        return super.hurt(source, value);
    }
    @Override
    public boolean isNoAi() {
        return this.isBurrowing() || this.isEmerging();
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if (this.getVariant() == UsurperVariants.SPRAY){
            VomitUsurperBall.shoot(this,livingEntity,(float) (1 * SConfig.SERVER.global_damage.get()));
        }else {
            BulletParameters parameters = Util.getRandom(BulletParameters.values(),this.random);
            AdaptableProjectile projectile = new AdaptableProjectile(parameters,this.level(),this);
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight();
            double dz = livingEntity.getZ() - this.getZ();
            projectile.moveTo(this.getX(), this.getY()+1.2D ,this.getZ());
            projectile.shoot(dx, dy - projectile.getY() + Math.hypot(dx, dz) * 0.001F, dz, 1.5f, 3.0F);
            this.playSound(Ssounds.SPIT.get());
            level().addFreshEntity(projectile);
        }
    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.USURPER_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33282_, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        UsurperVariants variant = Util.getRandom(UsurperVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_33282_, p_33283_, p_33284_, p_33285_, p_33286_);
    }

    public UsurperVariants getVariant() {
        return UsurperVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > UsurperVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return UsurperVariants.values().length;
    }

    private void setVariant(UsurperVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }

    @Override
    public void onSyncedDataUpdated(@NotNull EntityDataAccessor<?> dataValues) {
        super.onSyncedDataUpdated(dataValues);
        if (DATA_ID_TYPE_VARIANT.equals(dataValues)){
            AttributeInstance range = this.getAttribute(Attributes.FOLLOW_RANGE);
            if (range != null){
                if (getVariant() == UsurperVariants.SPRAY){
                    range.setBaseValue(8);
                }else {
                    range.setBaseValue(64);
                }
            }
        }
    }
}
