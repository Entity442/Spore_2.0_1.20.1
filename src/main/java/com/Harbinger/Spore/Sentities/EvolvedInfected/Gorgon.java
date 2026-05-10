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
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

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
        this.goalSelector.addGoal(2,new GorgonSporeSpewGoal(this));
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1.3, false) {
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

    private static class GorgonSporeSpewGoal extends Goal{
        private final Gorgon gorgon;

        private GorgonSporeSpewGoal(Gorgon gorgon) {
            this.gorgon = gorgon;
        }

        @Override
        public boolean canUse() {
            LivingEntity target = gorgon.getTarget();
            return gorgon.getSpores() > 6 && target != null;
        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity target = gorgon.getTarget();
            return gorgon.getSpores() > 0 && canAttack(target);
        }

        boolean canAttack(LivingEntity target){
            return target != null && gorgon.hasLineOfSight(target);
        }

        @Override
        public void stop() {
            super.stop();
            gorgon.setTargetId(-1);
        }

        @Override
        public void tick() {
            super.tick();
            gorgon.level().broadcastEntityEvent(gorgon, (byte)5);
            gorgon.activateMouth();
            LivingEntity target = gorgon.getTarget();
            if (canAttack(target)){
                double d0 = target.distanceTo(gorgon);
                if (gorgon.tickCount % 20 == 0 && d0 < 25){
                    gorgon.setTargetId(target.getId());
                    if (target.isBlocking()){
                        return;
                    }
                    target.hurt(gorgon.level().damageSources().mobAttack(gorgon),(float)(SConfig.SERVER.gorgon_ranged_damage.get() * 1f));
                    tryToApply(target,MobEffects.MOVEMENT_SLOWDOWN,400,2);
                    tryToApply(target,Seffects.MYCELIUM.get(),400,1);
                    tryToApply(target,MobEffects.BLINDNESS,80,0);
                }
            }else {
                gorgon.setTargetId(-1);
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
        public void tryToApply(LivingEntity living, MobEffect effect, int duration, int amp){
            if(!living.hasEffect(effect)){
                living.addEffect(new MobEffectInstance(effect,duration,amp));
            }
        }
    }
}
