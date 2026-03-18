package com.Harbinger.Spore.Sentities.Hyper;


import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.LeapGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class Grober extends Hyper implements ArmorPersentageBypass {
    public static final EntityDataAccessor<Integer> ATTACK_TYPE = SynchedEntityData.defineId(Grober.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RAVAGE_COOLDOWN = SynchedEntityData.defineId(Grober.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> RAVAGE_TIME = SynchedEntityData.defineId(Grober.class, EntityDataSerializers.INT);
    public Grober(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new WallClimberNavigation(this,level);
    }
    private int attackAnimationTick;
    public AnimationState kickAnimation = new AnimationState();
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.grober_loot.get();
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ATTACK_TYPE, 0);
        entityData.define(RAVAGE_COOLDOWN, 0);
        entityData.define(RAVAGE_TIME, 0);
    }
    public void setRavageTime(int val){
        entityData.set(RAVAGE_TIME,val);
    }
    public void addRavageTime(){
        entityData.set(RAVAGE_TIME,entityData.get(RAVAGE_TIME)+1);
    }
    public int getRavageTime(){
        return entityData.get(RAVAGE_TIME);
    }

    @Override
    protected int calculateFallDamage(float v1, float v2) {
        if (v1 >= 8){
            damageStomp(level(),this.getOnPos(),7,true);
        }
        return 0;
    }
    public int getAttackAnimationTick(){
        return attackAnimationTick;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("ravage",this.entityData.get(RAVAGE_COOLDOWN));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(RAVAGE_COOLDOWN,tag.getInt("ravage"));
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            if (getMeleeState() == MELEE_STATES.SMASH){
                damageStomp(level(),entity.getOnPos(),3,false);
            }
            if (getMeleeState() == MELEE_STATES.KICK){
                living.hurtMarked = true;
                living.knockback((3f),  Mth.sin(this.getYRot() * ((float) Math.PI / 180F)), (double) (-Mth.cos(this.getYRot() * ((float) Math.PI / 180F))));
                this.playSound(Ssounds.GROBER_KICK.get());
            }
            if (getMeleeState() == MELEE_STATES.RIGHT_SLAP || getMeleeState() == MELEE_STATES.LEFT_SLAP){
                living.addEffect(new MobEffectInstance(MobEffects.CONFUSION,200));
                living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,100));
                this.playSound(Ssounds.GROBER_SLAP.get());
            }
         }
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new Ravage(this));
        this.goalSelector.addGoal(2, new LeapGoal(this,0.8F){
            @Override
            public void start() {
                triggerAnimation(MELEE_STATES.SMASH.value);
                super.start();
                mob.level().broadcastEntityEvent(mob, (byte)4);
            }
        });
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}){
            protected void checkAndPerformAttack(LivingEntity entity, double val) {
                double d0 = this.getAttackReachSqr(entity);
                if (val <= d0 && this.ticksUntilNextAttack <= 0 && mob.hasLineOfSight(entity)) {
                    triggerAnimation(Util.getRandom(MELEE_STATES.values(), mob.getRandom()).getValue());
                    this.resetAttackCooldown();
                    this.mob.swing(InteractionHand.MAIN_HAND);
                    this.mob.doHurtTarget(entity);
                    AABB hitbox = entity.getBoundingBox().inflate(box);
                    List<LivingEntity> targets = entity.level().getEntitiesOfClass(LivingEntity.class , hitbox,victims);
                    for (LivingEntity en : targets) {
                        mob.doHurtTarget(en);
                    }
                }

            }
        });
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F){
            @Override
            public boolean canUse() {
                return super.canUse() && tickCount % 20 == 0;
            }
        });
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.grober_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.grober_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.grober_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (getRavageTime() > 0){
            amount = amount * 0.5f;
        }
        return super.hurt(source, amount);
    }

    @Override
    public void tick() {
        super.tick();

        if (level().isClientSide) {
            if (attackAnimationTick > 0
                    && getMeleeState() == MELEE_STATES.KICK
                    && !kickAnimation.isStarted()) {

                kickAnimation.start(this.tickCount);
            }
            if (attackAnimationTick <= 0 && kickAnimation.isStarted()){
                kickAnimation.stop();
            }
        }

        if (attackAnimationTick > 0){
            attackAnimationTick--;
        }
        if (entityData.get(RAVAGE_COOLDOWN) > 0){
            entityData.set(RAVAGE_COOLDOWN,entityData.get(RAVAGE_COOLDOWN) -1);
        }
    }
    public boolean isOmniMan(){
        return Objects.equals(this.getCustomName(), Component.literal("Omni-Man")) || Objects.equals(this.getCustomName(), Component.literal("Nolan"));
    }
    protected SoundEvent getAmbientSound() {
        return isOmniMan() ? Ssounds.OMNI_AMBIENT.get() : Ssounds.GROBER_AMBIENT.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void damageStomp(Level level, BlockPos pos, double range,boolean fall){
        if (level instanceof ServerLevel serverLevel){
        for(int i = 0; i <= 2*range; ++i) {
            for(int j = 0; j <= 2*range; ++j) {
                for(int k = 0; k <= 2*range; ++k) {
                    double distance = Mth.sqrt((float) ((i-range)*(i-range) + (j-range)*(j-range) + (k-range)*(k-range)));
                    if (Math.abs(i) != 2 || Math.abs(j) != 2 || Math.abs(k) != 2) {
                        if (distance<range+(0.5)){
                            BlockPos blockpos = pos.offset( i-(int)range,j-(int)range,k-(int)range);
                            BlockState state = level.getBlockState(blockpos);
                            boolean airBelow = level.getBlockState(blockpos.below()).isAir();
                            double breakSpeed = state.getDestroySpeed(level,pos);
                            if (airBelow && state.getDestroySpeed(level,pos) >= 0 && breakSpeed <= getBreaking() && Math.random() < 0.3){
                                FallingBlockEntity.fall(serverLevel,blockpos,state);
                                serverLevel.removeBlock(blockpos,false);
                            }
                        }}}}}}
        this.playSound(fall ? Ssounds.LANDING.get() : Ssounds.GROBER_SMASH.get());
    }
    public MELEE_STATES getMeleeState() {
        return MELEE_STATES.byId(this.entityData.get(ATTACK_TYPE) & 255);
    }
    public void triggerAnimation(int states){
        entityData.set(ATTACK_TYPE,states);
    }

    @Override
    public float amountOfDamage(float value) {
        return getMeleeState() == MELEE_STATES.KICK ? value/2 : 0;
    }

    public enum MELEE_STATES{
        SMASH(0),
        KICK(1),
        RIGHT_SLAP(2),
        LEFT_SLAP(3);
        private final int value;
        MELEE_STATES(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }
        private static final MELEE_STATES[] BY_ID = Arrays.stream(values()).sorted(Comparator.
                comparingInt(MELEE_STATES::getValue)).toArray(MELEE_STATES[]::new);
        public static MELEE_STATES byId(int id) {
            return BY_ID[id % BY_ID.length];
        }
    }


    public static class Ravage extends Goal {

        private final Grober mob;
        private LivingEntity target;
        private static final int MAX_CHARGE_TIME = 20; // ~1 second
        private static final double CHARGE_SPEED = 1.6;
        private static final double RANGE = 6.0;

        public Ravage(Grober mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (mob.entityData.get(Grober.RAVAGE_COOLDOWN) > 0)
                return false;

            target = mob.getTarget();
            if (target == null || !target.isAlive())
                return false;

            double distance = mob.distanceTo(target);
            return distance > 3 && distance <= RANGE;
        }

        @Override
        public void start() {
            mob.playSound(Ssounds.GROBER_CHARGE.get());
            mob.setRavageTime(0);
            mob.entityData.set(Grober.RAVAGE_COOLDOWN, 200);
        }

        @Override
        public boolean canContinueToUse() {
            return mob.getRavageTime() < MAX_CHARGE_TIME && target != null && target.isAlive();
        }

        @Override
        public void tick() {
            mob.addRavageTime();
            if (target == null) return;
            mob.getLookControl().setLookAt(target, 30F, 30F);

            Vec3 direction = new Vec3(
                    target.getX() - mob.getX(),
                    0,
                    target.getZ() - mob.getZ()
            ).normalize();

            mob.setDeltaMovement(direction.scale(CHARGE_SPEED));

            AABB hitbox = mob.getBoundingBox().inflate(1.0);
            List<LivingEntity> victims = mob.level().getEntitiesOfClass(
                    LivingEntity.class,
                    hitbox,
                    e -> Utilities.TARGET_SELECTOR.Test(e)
            );

            float damage = (float) mob.getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.25F;

            for (LivingEntity living : victims) {
                mob.playSound(Ssounds.GROBER_CHOKE.get());
                living.hurt(mob.damageSources().mobAttack(mob), damage);
                living.knockback(1.2F,
                        Mth.sin(mob.getYRot() * ((float)Math.PI / 180F)),
                        -Mth.cos(mob.getYRot() * ((float)Math.PI / 180F)));
            }
        }

        @Override
        public void stop() {
            mob.setRavageTime(0);
            mob.setDeltaMovement(Vec3.ZERO);
        }
    }
}
