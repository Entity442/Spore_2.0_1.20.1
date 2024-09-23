package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class Jagdhund extends EvolvedInfected {
    private static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Jagdhund.class, EntityDataSerializers.BOOLEAN);
    public Jagdhund(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    public AnimationState dig_in = new AnimationState();
    public AnimationState dig_out = new AnimationState();
    private int digInTimeOut = 0;
    private int digOutTimeOut = 0;

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.knight_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.knight_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.knight_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }
    public void tickDigIn(){
        if (digInTimeOut <= 0){
            dig_in.start(tickCount);
            digInTimeOut = 40;
        }else{
            --digInTimeOut;
        }
    }
    public void tickDigOut(){
        if (digOutTimeOut <= 0){
            dig_out.start(tickCount);
            digOutTimeOut = 50;
        }else{
            --digOutTimeOut;
        }
    }

    public boolean isDigging(){
      return digInTimeOut > 0 || digOutTimeOut > 0;
    }

    public void setUnderground(boolean value){
        if (value){
            tickDigIn();
            dig_out.stop();
        }else {
            tickDigOut();
            dig_in.stop();
        }
        entityData.set(UNDERGROUND,value);
    }
    public boolean isUnderground(){
        return entityData.get(UNDERGROUND);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("underground",entityData.get(UNDERGROUND));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(UNDERGROUND, tag.getBoolean("underground"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(UNDERGROUND,false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected void checkAndPerformAttack(LivingEntity entity, double at) {
                if (!isUnderground()){
                    super.checkAndPerformAttack(entity, at);
                }
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
        Entity target = this.getTarget();
        if (target != null && !isDigging()){
            if (target.distanceToSqr(this) > 100 && !isUnderground()){
                setUnderground(true);
            }
            if (target.distanceToSqr(this) < 50 && isUnderground()){
                setUnderground(false);
            }
        }
        if (isDigging()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(),new Vec3(0,1,0));
        }
        if (digInTimeOut > 0){tickDigIn();}
        if (digOutTimeOut > 0){tickDigOut();}

    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.EXPLOSION)){
            return super.hurt(source, amount);
        }
        if (isUnderground() || isDigging()){
            return false;
        }
        return super.hurt(source, amount);
    }


    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (UNDERGROUND.equals(accessor)){
            refreshDimensions();
        }
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isUnderground()){
            return new EntityDimensions(1.2f,0.1f,false);
        }
        return super.getDimensions(pose);
    }
}
