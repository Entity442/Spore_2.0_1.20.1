package com.Harbinger.Spore.Sentities.Hyper;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Hyper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Hvindicator extends Hyper {
    private static final EntityDataAccessor<Boolean> RIGHT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LEFT_SKULL = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIME_AXE = SynchedEntityData.defineId(Hvindicator.class, EntityDataSerializers.INT);
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

    @Override
    public void tick() {
        super.tick();
        tickAxe();
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
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
}
