package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;

public class Umarmer extends Organoid {
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> SHIELDING = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    private int attackAnimationTimeout = 0;
    public Umarmer(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }


    public int getNumberOfParticles(){
        return 6;
    }


    @Override
    public int getEmerge_tick(){
        return 80;
    }

    @Override
    public int getBorrow_tick() {
        return 100;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.umarmed_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.umarmed_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.umarmed_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timer",entityData.get(TIMER));
        tag.putBoolean("shielded",entityData.get(SHIELDING));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(SHIELDING, tag.getBoolean("shielded"));
    }
    public int getTimer(){
        return entityData.get(TIMER);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
        if (this.getTarget() == null && this.entityData.get(TIMER) < 2400){
            this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
        }else if (this.entityData.get(TIMER) >= 2400){
            tickBurrowing();
        }
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 120;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
        if (this.IsAttacking() && this.attackAnimationTimeout <= 0){
            this.attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }
    }


    @Override
    public boolean isNoAi() {
        return this.isBurrowing() || this.isEmerging();
    }

    @Override
    public boolean hurt(DamageSource source, float value) {
        if (source.is(DamageTypeTags.IS_PROJECTILE)){
            if (this.isShielding()){
                return super.hurt(source,value/4);
            }else{
                this.setShielding(true);
            }
        }
        if (this.isEmerging()){
            return false;
        }
        return super.hurt(source, value);
    }

    @Override
    protected void registerGoals() {
        this.addTargettingGoals();
        this.goalSelector.addGoal(3, new PullGoal(this, 64, 32));
        this.goalSelector.addGoal(3, new UmarmedMeleeAttack(this, 0, false));
        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
        this.entityData.define(SHIELDING,false);
        this.entityData.define(TIMER,0);
    }

    public void SetAttacking(boolean value){
        entityData.set(ATTACKING,value);
    }
    public boolean IsAttacking(){
        return entityData.get(ATTACKING);
    }
    public void setShielding(boolean value){
        entityData.set(SHIELDING,value);
    }
    public boolean isShielding(){return entityData.get(SHIELDING);}

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
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,1));
            livingEntity.knockback(1.2F, -Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), Mth.cos(this.getYRot() * ((float) Math.PI / 180F)));
        }
        return super.doHurtTarget(entity);
    }

    static class UmarmedMeleeAttack extends CustomMeleeAttackGoal{
        private final Umarmer mob;
        private final int attackDelay = 10;
        private int ticksUntilNextAttack = 20;
        private boolean shouldCountTillNextAttack = false;
        public UmarmedMeleeAttack(Umarmer umarmer, double p_25553_, boolean p_25554_) {
            super(umarmer, p_25553_, p_25554_);
            this.mob = umarmer;
        }

        @Override
        protected double getAttackReachSqr(LivingEntity entity) {
            return 16.0 + entity.getBbWidth() * entity.getBbWidth();}


        @Override
        protected void checkAndPerformAttack(LivingEntity entity, double at) {
            if (isEnemyWithinAttackDistance(entity, at)) {
                shouldCountTillNextAttack = true;

                if(isTimeToStartAttackAnimation()) {
                    mob.SetAttacking(true);
                    mob.setShielding(false);
                }

                if(isTimeToAttack()) {
                    this.mob.getLookControl().setLookAt(entity.getX(), entity.getEyeY(), entity.getZ());
                    performAttack(entity);
                }
            } else {
                resetAttackCooldown();
                shouldCountTillNextAttack = false;
                mob.SetAttacking(false);
                mob.attackAnimationTimeout = 0;
            }

        }


        private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy, double pDistToEnemySqr) {
            return pDistToEnemySqr <= this.getAttackReachSqr(pEnemy);
        }

        protected void resetAttackCooldown() {
            this.ticksUntilNextAttack = this.adjustedTickDelay(attackDelay * 2);
        }

        protected boolean isTimeToAttack() {
            return this.ticksUntilNextAttack <= 0;
        }

        protected boolean isTimeToStartAttackAnimation() {
            return this.ticksUntilNextAttack <= attackDelay;
        }

        protected int getTicksUntilNextAttack() {
            return this.ticksUntilNextAttack;
        }


        protected void performAttack(LivingEntity pEnemy) {
            this.resetAttackCooldown();
            this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.doHurtTarget(pEnemy);
        }

        @Override
        public void tick() {
            super.tick();
            if(shouldCountTillNextAttack) {
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
            }
        }

        @Override
        public void stop() {
            mob.SetAttacking(false);
            super.stop();
        }
    }
}
