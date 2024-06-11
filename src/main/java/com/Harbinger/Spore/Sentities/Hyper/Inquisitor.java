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
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class Inquisitor extends Hyper {
   public static final EntityDataAccessor<Integer> DAMAGE_BONUS = SynchedEntityData.defineId(Inquisitor.class, EntityDataSerializers.INT);
    public Inquisitor(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("bonus_damage",this.getBonusDamage());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setBonusDamage(tag.getInt("bonus_damage"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE_BONUS, 0);
    }
    public void setBonusDamage(int value){
        entityData.set(DAMAGE_BONUS,value);
    }
    public int getBonusDamage(){
        return entityData.get(DAMAGE_BONUS);
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        this.setBonusDamage(this.getBonusDamage()+1);
    }
    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.2,true, 1.2 ,3, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.4F));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));

    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.wendigo_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.wendigo_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.wendigo_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.tickCount % 10 == 0){
            AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
            AttributeInstance damage = this.getAttribute(Attributes.ATTACK_DAMAGE);
            if (armor != null && this.getHealth() < this.getMaxHealth()){
                double new_armor = (this.getMaxHealth()-this.getHealth()) + (SConfig.SERVER.wendigo_armor.get() * SConfig.SERVER.global_armor.get());
                armor.setBaseValue(new_armor);
            }
            if (damage != null){
                double new_damage = (SConfig.SERVER.wendigo_damage.get()*SConfig.SERVER.global_damage.get()) + (this.getBonusDamage()*0.5);
                damage.setBaseValue(new_damage);
                if (new_damage > (SConfig.SERVER.wendigo_damage.get()*3*SConfig.SERVER.global_damage.get())){
                    this.setBonusDamage(this.getBonusDamage()-1);
                }
            }
        }
    }

}
