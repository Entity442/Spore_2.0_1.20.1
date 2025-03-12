package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.level.Level;

public class Hvindicator extends Hyper implements RangedAttackMob {
    private static final EntityDataAccessor<Boolean> RIGHT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIME_AXE = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.INT);
    private int attackAnimationTick;
    private int rangedAnimationTick;
    private int blockTime = 0;
    public AnimationState block_attack = new AnimationState();
    public Hvindicator(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inquisitor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inquisitor_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inquisitor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("left_skull",this.entityData.get(LEFT_SKULL));
        tag.putBoolean("right_skull",this.entityData.get(RIGHT_SKULL));
        tag.putInt("time_axe",this.entityData.get(TIME_AXE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(LEFT_SKULL,tag.getBoolean("left_skull"));
        this.entityData.set(RIGHT_SKULL,tag.getBoolean("right_skull"));
        this.entityData.set(TIME_AXE,tag.getInt("time_axe"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT_SKULL, false);
        this.entityData.define(LEFT_SKULL, false);
        this.entityData.define(TIME_AXE, 600);
    }

    public boolean hasRightSkull(){return entityData.get(RIGHT_SKULL);}
    public boolean hasLeftSkull(){return entityData.get(LEFT_SKULL);}
    public boolean hasAxe(){return entityData.get(TIME_AXE) >= 600;}
    private void tickAxe(){
        if (hasAxe()){
            return;
        }else {
            entityData.set(TIME_AXE,entityData.get(TIME_AXE)+1);
        }
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        } else if (value == 5) {
            this.block_attack.start(this.tickCount);
            blockTime = 10;
        }else if (value == 6) {
            rangedAnimationTick = 10;
        }else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        if (entity instanceof Player player){
            player.disableShield(true);
            this.block_attack.start(this.tickCount);
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public void tick() {
        super.tick();
        tickAxe();
        this.setupAnimationStates();
    }

    private void setupAnimationStates() {
        if (this.blockTime > 0){
            if (blockTime == 1){
                this.block_attack.stop();
            }
            --blockTime;
        }
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(4,new RangedAttackGoal(this,1,20,32){
            @Override
            public boolean canUse() {
                if (!hasAxe()){
                 return false;
                }else{
                    return super.canUse();
                }
            }
        });
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public boolean canDisableShield() {
        super.canDisableShield();
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        float reduction = 1.0f;
        reduction = hasLeftSkull() ? reduction - 0.1f : reduction;
        reduction = hasRightSkull() ? reduction - 0.1f : reduction;
        if (source.is(DamageTypeTags.IS_PROJECTILE) && Math.random() < 0.75f) {
            if (!this.level().isClientSide()) {
                this.playSound(SoundEvents.SHIELD_BLOCK);
                this.level().broadcastEntityEvent(this, (byte) 5);
            }
            return false;
        }
        if (source.getEntity() != null && Math.random() < 0.3f) {
            if (!this.level().isClientSide()) {
                this.level().broadcastEntityEvent(this, (byte) 5);
            }
            return false;
        }
        return super.hurt(source, amount * reduction);
    }
    public void awardSkull(LivingEntity entity){
        if ((entity instanceof Villager || entity instanceof AbstractIllager || entity instanceof Witch) && !hasLeftSkull()){
            this.entityData.set(LEFT_SKULL, true);
        }
        if ((entity instanceof Zombie || entity instanceof Player) && !hasRightSkull()){
            this.entityData.set(RIGHT_SKULL, true);
        }
    }

    public int getAttackAnimationTick() {
        return attackAnimationTick;
    }
    public int getRangedAttackAnimationTick() {
        return rangedAnimationTick;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
        if (this.rangedAnimationTick > 0) {
            --this.rangedAnimationTick;
        }
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        rangedAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte) 6);
        Arrow arrow = new Arrow(EntityType.ARROW,this.level());
        double d0 = livingEntity.getX() - arrow.getX();
        double d1 = livingEntity.getY(0.3333333333333333D) - arrow.getY();
        double d2 = livingEntity.getZ() - arrow.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        arrow.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level().getDifficulty().getId() * 4));
        level().addFreshEntity(arrow);
    }
}
