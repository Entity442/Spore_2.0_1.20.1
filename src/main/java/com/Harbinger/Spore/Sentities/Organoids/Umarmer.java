package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Griefer;
import com.Harbinger.Spore.Sentities.Utility.WaveEntity;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Sentities.Variants.HazmatVariant;
import com.Harbinger.Spore.Sentities.Variants.UmarmerVariants;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;

public class Umarmer extends Organoid {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> ATTACKING = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> HARD_ATTACK = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> PINNED = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> SHIELDING = SynchedEntityData.defineId(Umarmer.class, EntityDataSerializers.BOOLEAN);
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState pin_start = new AnimationState();
    public AnimationState pin_end = new AnimationState();
    public AnimationState pin_idle = new AnimationState();
    public AnimationState shield_idle = new AnimationState();
    public AnimationState shield_start = new AnimationState();
    public AnimationState shield_end = new AnimationState();
    public AnimationState squeeze_idle = new AnimationState();
    private int attackAnimationTimeout = 0;
    private int SlamAttackAnimationTimeout = 0;
    private int SlamAttackAnimationEndTimeout = 0;
    private int idlePinTimeout = 0;
    private int idleShieldTimeout = 0;
    private int startShieldTimeout = 0;
    private int endShieldTimeout = 0;
    private int squeezeTimeout = 0;
    private int chargeWave = 0;

    private boolean start_shield = false;
    private boolean end_shield = false;
    private boolean end_pin = false;
    public Umarmer(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.umarmer_loot.get();
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
        tag.putBoolean("pinned",entityData.get(PINNED));
        tag.putBoolean("shielded",entityData.get(SHIELDING));
        tag.putInt("Variant",this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(PINNED, tag.getBoolean("pinned"));
        entityData.set(SHIELDING, tag.getBoolean("shielded"));
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
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
        if (!this.level().isClientSide){
            if (this.getTarget() != null && this.chargeWave < 61){
                this.chargeWave++;
            }
            if (this.getTarget() == null && this.entityData.get(TIMER) < 2400){
                this.entityData.set(TIMER,this.entityData.get(TIMER) + 1);
            }else if (this.entityData.get(TIMER) >= 2400){
                tickBurrowing();
            }
        }
        if (!this.isVehicle() && this.isPinned()){
            this.setPinned(false);
        }
    }

    private void setupAnimationStates() {
        if (this.isPinned() && this.idlePinTimeout <= 0) {
            this.idlePinTimeout = 40;
            this.pin_idle.start(this.tickCount);
        } else {
            --this.idlePinTimeout;
        }
        if (this.start_shield && this.startShieldTimeout <= 0){
            this.startShieldTimeout = 30;
            this.shield_start.start(this.tickCount);
        }else  {
            --this.startShieldTimeout;
            this.start_shield = false;
        }
        if (this.end_pin && this.SlamAttackAnimationEndTimeout <= 0){
            this.SlamAttackAnimationEndTimeout = 40;
            this.pin_end.start(this.tickCount);
        }else  {
            --this.SlamAttackAnimationEndTimeout;
            this.end_pin = false;
        }
        if (this.end_shield && this.endShieldTimeout <= 0){
            this.endShieldTimeout = 30;
            this.shield_end.start(this.tickCount);
        }else {
            --this.endShieldTimeout;
            this.end_shield = false;
        }
        if (this.isVehicle() && !this.isPinned() && this.squeezeTimeout <= 0){
            this.squeezeTimeout = 40;
            this.squeeze_idle.start(this.tickCount);
        }else {
            --this.squeezeTimeout;
        }
        if (this.isShielding() && this.idleShieldTimeout <= 0) {
            this.idleShieldTimeout = 30;
            this.shield_idle.start(this.tickCount);
        } else {
            --this.idleShieldTimeout;
        }
        if (this.startShieldTimeout <= 0){
            this.shield_start.stop();
        }
        if (this.endShieldTimeout <= 0){
            this.shield_end.stop();
        }
        if (this.IsAttacking() && this.attackAnimationTimeout <= 0){
            this.attackAnimationTimeout = 20;
            attackAnimationState.start(this.tickCount);
        }else{
            --this.attackAnimationTimeout;
        }
        if (this.IsHardAttacking() && this.SlamAttackAnimationTimeout <= 0){
            this.SlamAttackAnimationTimeout = 60;
            pin_start.start(this.tickCount);
        }else{
            --this.SlamAttackAnimationTimeout;
        }
        if (!this.IsHardAttacking()){
            pin_start.stop();
        }
        if (!this.IsAttacking()){
            attackAnimationState.stop();
        }
        if (!this.isPinned()){
            pin_idle.stop();
        }
        if (!this.isVehicle()){
            squeeze_idle.stop();
        }
        if (!this.isShielding()){
            shield_idle.stop();
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
        this.goalSelector.addGoal(3,new GrabTarget(this));
        this.goalSelector.addGoal(4, new UmarmedMeleeAttack(this, 0, false));
        this.goalSelector.addGoal(4, new PinAttack(this, 0, false));
        this.goalSelector.addGoal(6,new RandomLookAroundGoal(this){
            @Override
            public boolean canUse() {
                return super.canUse() && !Umarmer.this.isVehicle();
            }
        });
        super.registerGoals();
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ATTACKING,false);
        this.entityData.define(HARD_ATTACK,false);
        this.entityData.define(PINNED,false);
        this.entityData.define(SHIELDING,false);
        this.entityData.define(TIMER,0);
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public void SetAttacking(boolean value){
        entityData.set(ATTACKING,value);
    }
    public boolean IsAttacking(){
        return entityData.get(ATTACKING);
    }
    public void setPinned(boolean value){entityData.set(PINNED,value);}
    public boolean isPinned(){return entityData.get(PINNED);}
    public void SetHardAttacking(boolean value){
        entityData.set(HARD_ATTACK,value);
    }
    public boolean IsHardAttacking(){
        return entityData.get(HARD_ATTACK);
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
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean isVehicle() {
        if (this.getFirstPassenger() != null){
            Entity entity = this.getFirstPassenger();
            if (entity instanceof LivingEntity livingEntity){
                if (this.isPinned()){
                    this.getLookControl().setLookAt(entity.getX(), entity.getEyeY(), entity.getZ());
                    livingEntity.setPose(Pose.SWIMMING);
                }
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,2),this);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,400,1),this);
            }
        }
        return super.isVehicle();
    }

    @Override
    protected void positionRider(Entity entity, MoveFunction p_19958_) {
        super.positionRider(entity, p_19958_);
        Vec3 vec3;
        double y;
        if (this.isPinned()){
            vec3 = (new Vec3(2.0D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            y = -0.1;
        }else{
            vec3 = (new Vec3(0.4D, 0.0D, 0.0D)).yRot(-this.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
            y = 1.2;
        }
        entity.setPos(this.getX() + vec3.x, this.getY() + y,this.getZ()+ vec3.z);
    }

    @Override
    public boolean fireImmune() {
        return this.getVariant() == UmarmerVariants.CHARRED;
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            if (this.getVariant() == UmarmerVariants.CHARRED){
                livingEntity.setSecondsOnFire(10);
            }
            livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,1));
            livingEntity.knockback(1.2F, -Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), Mth.cos(this.getYRot() * ((float) Math.PI / 180F)));
        }
        return super.doHurtTarget(entity);
    }

    static class UmarmedMeleeAttack extends CustomMeleeAttackGoal{
        private final Umarmer mob;
        private final int attackDelay = 10;
        private int ticksUntilNextAttack = 10;
        private boolean shouldCountTillNextAttack = false;
        public UmarmedMeleeAttack(Umarmer umarmer, double p_25553_, boolean p_25554_) {
            super(umarmer, p_25553_, p_25554_);
            this.mob = umarmer;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = this.mob.getTarget();
            if (this.mob.isPinned()){
                return false;
            }
            if (this.mob.isVehicle()){
                return false;
            }
            if (target != null && this.mob.distanceToSqr(target) > getAttackReachSqr(target)){
                return false;
            }
            return super.canUse();
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
    static class PinAttack extends CustomMeleeAttackGoal{
        private final Umarmer mob;
        private final int attackDelay = 55;
        private int ticksUntilNextAttack = 110;
        private boolean shouldCountTillNextAttack = false;
        public PinAttack(Umarmer umarmer, double p_25553_, boolean p_25554_) {
            super(umarmer, p_25553_, p_25554_);
            this.mob = umarmer;
        }

        @Override
        public boolean canUse() {
            if (this.mob.isPinned()){
                return false;
            }
            if (this.mob.isVehicle()){
                return false;
            }if (mob.chargeWave >= 60){
                return true;
            }
            return super.canUse();
        }

        @Override
        protected double getAttackReachSqr(LivingEntity entity) {
            return 8.0 + entity.getBbWidth() * entity.getBbWidth();}


        @Override
        protected void checkAndPerformAttack(LivingEntity entity, double at) {
            if (isEnemyWithinAttackDistance(entity, at)) {
                shouldCountTillNextAttack = true;

                if(isTimeToStartAttackAnimation()) {
                    mob.SetHardAttacking(true);
                    mob.setShielding(false);
                }

                if(isTimeToAttack()) {
                    this.mob.getLookControl().setLookAt(entity.getX(), entity.getEyeY(), entity.getZ());
                    performAttack(entity);
                }
            } else if(!isEnemyWithinAttackDistance(entity, at) && this.mob.chargeWave >= 60){
                shouldCountTillNextAttack = true;
                if(isTimeToStartAttackAnimation()) {
                    mob.SetHardAttacking(true);
                    mob.setShielding(false);
                    if(isTimeToAttack()) {
                    WaveEntity waveEntity = new WaveEntity(this.mob.level(), this.mob);
                    this.mob.level().addFreshEntity(waveEntity);
                    this.mob.chargeWave = 0;
                    }
                }
            }else {
                resetAttackCooldown();
                shouldCountTillNextAttack = false;
                mob.SetHardAttacking(false);
                mob.attackAnimationTimeout = 0;
            }

        }

        @Override
        public boolean canContinueToUse() {
            if (this.mob.isPinned()){
                return false;
            }
            return super.canContinueToUse();
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
            this.mob.setPinned(true);
            pEnemy.startRiding(this.mob);
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
            mob.SetHardAttacking(false);
            super.stop();
        }
    }

    static class GrabTarget extends Goal{
        Umarmer umarmer;
        int damage;
        public GrabTarget(Umarmer umarmer1){
            umarmer = umarmer1;
        }

        @Override
        public boolean canUse() {
            if (this.umarmer.isVehicle() && !this.umarmer.isPinned()){
                return true;
            }
            return umarmer.getTarget() != null && umarmer.random.nextInt(15) == 0;
        }

        @Override
        public void start() {
            super.start();
            if (umarmer.getTarget() != null && !this.umarmer.isVehicle()){
                if (this.umarmer.distanceToSqr(this.umarmer.getTarget()) < 5.0D){
                    this.umarmer.getTarget().startRiding(umarmer);
                }
            }
        }

        @Override
        public void tick() {
            super.tick();
            Entity target = this.umarmer.getTarget();
            if (target != null && this.umarmer.getFirstPassenger() == target){
                if (this.damage >= 10){
                    umarmer.doHurtTarget(target);
                    this.damage = 0;
                }else{
                    this.damage++;
                }
            }
        }
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.UMARMER_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        UmarmerVariants variant = Util.getRandom(UmarmerVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public UmarmerVariants getVariant() {
        return UmarmerVariants.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(UmarmerVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (PINNED.equals(dataAccessor)){
            if (!this.isPinned()){
                end_pin = true;
            }
            this.refreshDimensions();
        }
        if (SHIELDING.equals(dataAccessor)){
            if (isShielding()){
                this.start_shield = true;
            }else{
                this.end_shield = true;
            }
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isPinned()){
            return super.getDimensions(pose).scale(2.75F,0.35F);
        }
        return super.getDimensions(pose);
    }
}
