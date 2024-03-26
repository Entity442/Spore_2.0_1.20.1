package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CalamitiesAI.ScatterShotRangedGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.Projectile.AdaptableProjectile;
import com.Harbinger.Spore.Sentities.Variants.BulletParameters;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

public class Usurper extends Organoid implements RangedAttackMob {
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Usurper.class, EntityDataSerializers.INT);
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
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER,0);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(2,new ScatterShotRangedGoal(this,0,40,32,1,4));
        this.goalSelector.addGoal(3 ,new RandomLookAroundGoal(this));
        super.registerGoals();
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
        }
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
    protected SoundEvent getAmbientSound() {
        return Ssounds.USURPER_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }


}
