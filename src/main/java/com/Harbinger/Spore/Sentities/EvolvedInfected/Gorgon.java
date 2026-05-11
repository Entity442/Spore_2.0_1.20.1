package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;

import java.util.EnumSet;
import java.util.List;

public class Gorgon extends EvolvedInfected {
    private static final EntityDataAccessor<Integer> TARGET = SynchedEntityData.defineId(Gorgon.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> SPORES = SynchedEntityData.defineId(Gorgon.class, EntityDataSerializers.FLOAT);
    private int attackAnimationTick;
    private int mouthAnimationTick;
    private int mouthAnimationTimer;
    public Gorgon(EntityType<? extends EvolvedInfected> type, Level level) {
        super(type, level);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new GorgonHybridAttackGoal(this, 1.3, true) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_gorgon_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.gorgon_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.gorgon_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.gorgon_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TARGET, -1);
        this.entityData.define(SPORES, 0f);
    }

    public void setTargetId(int e){
        entityData.set(TARGET,e);
    }
    public int getTargetId(){
        return entityData.get(TARGET);
    }

    public void setSpores(float spores){
        entityData.set(SPORES,spores);
    }
    public float getSpores(){
        return entityData.get(SPORES);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WITCH_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }else if (value == 5) {
            this.mouthAnimationTimer = 10;
        } else {
            super.handleEntityEvent(value);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 5 == 0 && getSpores() <= 10){
            setSpores(getSpores()+0.1f);
        }
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity.isInWater()){
            return false;
        }
        return super.hasLineOfSight(entity);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (this.mouthAnimationTimer > 0) {
            --this.mouthAnimationTimer;
        }
        if (mouthAnimationTimer > 0){
            if (mouthAnimationTick < 10){
                mouthAnimationTick++;
            }
        }else{
            if (mouthAnimationTick > 0){
                mouthAnimationTick--;
            }
        }
    }
    public int getMouthAnimationTick(){
        return mouthAnimationTick;
    }
    public int getAttackAnimationTick(){
        return attackAnimationTick;
    }
    public void activateMouth(){
        mouthAnimationTimer = 10;
    }

    private static class GorgonHybridAttackGoal extends Goal {
        private final Gorgon gorgon;
        private final double meleeSpeedModifier;
        private final boolean followingTargetEvenIfNotSeen;
        private Path path;
        private double pathedTargetX;
        private double pathedTargetY;
        private double pathedTargetZ;
        private int ticksUntilNextPathRecalculation;
        private int ticksUntilNextAttack;
        private int ticksUntilNextRangedAttack;
        private static final int ATTACK_INTERVAL = 20;
        private static final int RANGED_ATTACK_INTERVAL = 20;
        private long lastCanUseCheck;
        private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 20L;
        private int failedPathFindingPenalty = 0;
        private boolean canPenalize = false;
        private static final double RANGED_ATTACK_RANGE = 25.0;
        private boolean canShoot;

        public GorgonHybridAttackGoal(Gorgon gorgon, double meleeSpeedModifier, boolean followingTargetEvenIfNotSeen) {
            this.gorgon = gorgon;
            this.meleeSpeedModifier = meleeSpeedModifier;
            this.followingTargetEvenIfNotSeen = followingTargetEvenIfNotSeen;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE, Goal.Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            long i = this.gorgon.level().getGameTime();
            if (i - this.lastCanUseCheck < 20L) {
                return false;
            } else {
                this.lastCanUseCheck = i;
                LivingEntity target = this.gorgon.getTarget();
                if (target == null) {
                    return false;
                } else if (!target.isAlive()) {
                    return false;
                } else {
                    // Can use if we have ranged attack charged OR we can melee
                    if (gorgon.getSpores() > 6 && canRangedAttack(target)) {
                        return true;
                    }

                    // Check for melee pathfinding
                    if (canPenalize) {
                        if (--this.ticksUntilNextPathRecalculation <= 0) {
                            this.path = this.gorgon.getNavigation().createPath(target, 0);
                            this.ticksUntilNextPathRecalculation = 4 + this.gorgon.getRandom().nextInt(7);
                            return this.path != null;
                        } else {
                            return true;
                        }
                    }
                    this.path = this.gorgon.getNavigation().createPath(target, 0);
                    if (this.path != null) {
                        return true;
                    } else {
                        return this.getAttackReachSqr(target) >= this.gorgon.distanceToSqr(target.getX(), target.getY(), target.getZ());
                    }
                }
            }
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = this.gorgon.getTarget();
            if (target == null) {
                return false;
            } else if (!target.isAlive()) {
                return false;
            } else if (!this.followingTargetEvenIfNotSeen) {
                return !this.gorgon.getNavigation().isDone();
            } else if (!this.gorgon.isWithinRestriction(target.blockPosition())) {
                return false;
            } else {
                return !(target instanceof Player) || !target.isSpectator() && !((Player)target).isCreative();
            }
        }

        @Override
        public void start() {
            this.gorgon.getNavigation().moveTo(this.path, this.meleeSpeedModifier);
            this.gorgon.setAggressive(true);
            this.ticksUntilNextPathRecalculation = 0;
            this.ticksUntilNextAttack = 0;
            this.ticksUntilNextRangedAttack = 0;
        }

        @Override
        public void stop() {
            LivingEntity target = this.gorgon.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(target)) {
                this.gorgon.setTarget(null);
            }
            this.gorgon.setAggressive(false);
            this.gorgon.getNavigation().stop();
            this.gorgon.setTargetId(-1);
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            LivingEntity target = this.gorgon.getTarget();
            if (target == null) return;

            this.gorgon.getLookControl().setLookAt(target, 30.0F, 30.0F);
            double distanceToTarget = this.gorgon.distanceToSqr(target.getX(), target.getY(), target.getZ());
            double distance = Math.sqrt(distanceToTarget);

            if (!canShoot && gorgon.getSpores() > 6){
                gorgon.playSound(Ssounds.GORGON_SPEW.get());
                canShoot = true;
            }
            if (canShoot && gorgon.getSpores() <= 0){
                canShoot = false;
            }
            boolean shouldUseRanged = canShoot && distance <= RANGED_ATTACK_RANGE && hasLineOfSight(target);

            if (shouldUseRanged) {
                this.ticksUntilNextRangedAttack = Math.max(this.ticksUntilNextRangedAttack - 1, 0);
                this.gorgon.level().broadcastEntityEvent(gorgon, (byte)5);
                this.gorgon.activateMouth();
                gorgon.setSpores(gorgon.getSpores()-0.1f);
                if (this.ticksUntilNextRangedAttack == 0) {
                    performRangedAttack(target);
                    this.ticksUntilNextRangedAttack = this.adjustedTickDelay(RANGED_ATTACK_INTERVAL);
                }

                // Stop moving during ranged attack
                this.gorgon.getNavigation().stop();
            } else {
                this.gorgon.setTargetId(-1);
                this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);

                // Pathfinding logic for melee
                this.ticksUntilNextPathRecalculation = Math.max(this.ticksUntilNextPathRecalculation - 1, 0);
                if ((this.followingTargetEvenIfNotSeen || this.gorgon.getSensing().hasLineOfSight(target))
                        && this.ticksUntilNextPathRecalculation <= 0
                        && (this.pathedTargetX == 0.0D && this.pathedTargetY == 0.0D && this.pathedTargetZ == 0.0D
                        || target.distanceToSqr(this.pathedTargetX, this.pathedTargetY, this.pathedTargetZ) >= 1.0D
                        || this.gorgon.getRandom().nextFloat() < 0.05F)) {

                    this.pathedTargetX = target.getX();
                    this.pathedTargetY = target.getY();
                    this.pathedTargetZ = target.getZ();
                    this.ticksUntilNextPathRecalculation = 4 + this.gorgon.getRandom().nextInt(7);

                    if (this.canPenalize) {
                        this.ticksUntilNextPathRecalculation += failedPathFindingPenalty;
                        if (this.gorgon.getNavigation().getPath() != null) {
                            net.minecraft.world.level.pathfinder.Node finalPathPoint = this.gorgon.getNavigation().getPath().getEndNode();
                            if (finalPathPoint != null && target.distanceToSqr(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                                failedPathFindingPenalty = 0;
                            else
                                failedPathFindingPenalty += 10;
                        } else {
                            failedPathFindingPenalty += 10;
                        }
                    }

                    if (distanceToTarget > 1024.0D) {
                        this.ticksUntilNextPathRecalculation += 10;
                    } else if (distanceToTarget > 256.0D) {
                        this.ticksUntilNextPathRecalculation += 5;
                    }

                    if (!this.gorgon.getNavigation().moveTo(target, this.meleeSpeedModifier)) {
                        this.ticksUntilNextPathRecalculation += 15;
                    }

                    this.ticksUntilNextPathRecalculation = this.adjustedTickDelay(this.ticksUntilNextPathRecalculation);
                }

                // Perform melee attack if in range
                double attackReach = this.getAttackReachSqr(target);
                if (distanceToTarget <= attackReach && this.ticksUntilNextAttack <= 0 && hasLineOfSight(target)) {
                    this.resetAttackCooldown(ATTACK_INTERVAL);
                    this.gorgon.swing(InteractionHand.MAIN_HAND);
                    this.gorgon.doHurtTarget(target);
                }
            }
        }

        private void performRangedAttack(LivingEntity target) {
            if (hasLineOfSight(target)) {
                this.gorgon.setTargetId(target.getId());
                if (!target.isBlocking()) {
                    target.hurt(this.gorgon.level().damageSources().mobAttack(gorgon),
                            (float)(SConfig.SERVER.gorgon_ranged_damage.get() * 1f));
                    tryToApply(target, MobEffects.MOVEMENT_SLOWDOWN, 400, 2);
                    tryToApply(target, Seffects.MYCELIUM.get(), 400, 1);
                    tryToApply(target, MobEffects.BLINDNESS, 80, 0);
                }
            }
        }

        private boolean hasLineOfSight(LivingEntity target) {
            return target != null && this.gorgon.hasLineOfSight(target);
        }

        private boolean canRangedAttack(LivingEntity target) {
            return hasLineOfSight(target);
        }

        private void tryToApply(LivingEntity living, MobEffect effect, int duration, int amp) {
            if (!living.hasEffect(effect)) {
                living.addEffect(new MobEffectInstance(effect, duration, amp));
            }
        }

        protected void resetAttackCooldown(int value) {
            this.ticksUntilNextAttack = this.adjustedTickDelay(value);
        }

        protected double getAttackReachSqr(LivingEntity target) {
            return (double)(this.gorgon.getBbWidth() * 2.0F * this.gorgon.getBbWidth() * 2.0F + target.getBbWidth());
        }
    }
}
