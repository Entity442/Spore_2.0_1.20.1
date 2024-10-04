package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Variants.IllusionVariants;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Illusion extends UtilityEntity implements ArmorPersentageBypass, Enemy {
    private static final EntityDataAccessor<Boolean> SEE_ABLE = SynchedEntityData.defineId(Illusion.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<String> BODY = SynchedEntityData.defineId(Illusion.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(Illusion.class, EntityDataSerializers.INT);
    public Illusion(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(SEE_ABLE,true);
        entityData.define(TYPE,0);
        entityData.define(BODY,"spore:knight");
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt("type",entityData.get(TYPE));
        tag.putBoolean("see_able",entityData.get(SEE_ABLE));
        tag.putString("body",entityData.get(BODY));
        super.addAdditionalSaveData(tag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        entityData.set(SEE_ABLE,tag.getBoolean("see_able"));
        entityData.set(TYPE,tag.getInt("type"));
        entityData.set(BODY,tag.getString("body"));
        super.readAdditionalSaveData(tag);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_DAMAGE, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    @Override
    public boolean canBeSeenByAnyone() {
        return entityData.get(SEE_ABLE);
    }


    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {
                    return Illusion.this.getSeeAble() && TARGET_SELECTOR.test(livingEntity);}));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, LivingEntity.class,  true,livingEntity -> {
                    return livingEntity.hasEffect(Seffects.MADNESS.get());}));
        this.goalSelector.addGoal(3,new CustomMeleeAttackGoal(this,1.3,true));
    }

    public void setTypeVariant(IllusionVariants variant){
        this.entityData.set(TYPE, variant.getVariant() & 255);
    }
    public int getTypeVariant(){
        return this.entityData.get(TYPE);
    }

    public void setBody(String i){
        this.entityData.set(BODY,i);
    }
    public String getBody(){
        return this.entityData.get(BODY);
    }
    public void setSeeAble(boolean value){
        this.entityData.set(SEE_ABLE,value);
    }
    public boolean getSeeAble(){
        return this.entityData.get(SEE_ABLE);
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        if (Math.random() < 0.3){
            this.discard();
        }
        return false;
    }

    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        return this.getSeeAble() ? super.getCustomDamage(entity) : SdamageTypes.mental_damage(entity);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 800 == 0 && !this.getSeeAble()){
            this.discard();
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            if (this.getSeeAble()){
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),400,2));
            }else{
                livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION,200,0));
            }
        }
        this.discard();
        return super.doHurtTarget(entity);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return Ssounds.MADNESS.get();
    }

    @Override
    public int getAmbientSoundInterval() {
        return 200;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @javax.annotation.Nullable SpawnGroupData p_146749_,
                                        @javax.annotation.Nullable CompoundTag p_146750_) {
        IllusionVariants variant = Util.getRandom(IllusionVariants.values(), this.random);
        setTypeVariant(variant);
        setBody(variant.getEntityValue());
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public IllusionVariants getVariant() {
        return IllusionVariants.byId(this.getTypeVariant() & 255);
    }

    @Override
    public float amountOfDamage(float value) {
        return this.getSeeAble() ? 0 : (float) (SConfig.SERVER.halucinations_damage.get() * 1f);
    }
}
