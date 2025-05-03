package com.Harbinger.Spore.Sentities.Experiments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;

import java.util.List;

public class Biobloob extends Experiment implements RangedAttackMob {
    public static final EntityDataAccessor<Float> SCALE = SynchedEntityData.defineId(Biobloob.class, EntityDataSerializers.FLOAT);
    private final float maxScale = 2.0f;
    private final float minScale = 0.5f;
    private static double health = SConfig.SERVER.biobloob_hp.get() * SConfig.SERVER.global_health.get();
    private static double damage = SConfig.SERVER.biobloob_damage.get() * SConfig.SERVER.global_damage.get();
    private static double armor = SConfig.SERVER.biobloob_armor.get() * SConfig.SERVER.global_armor.get();
    public Biobloob(EntityType<? extends Monster> type, Level level) {
        super(type, level);

    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("scale",entityData.get(SCALE));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(SCALE, tag.getFloat("scale"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SCALE,1f);
    }
    public float getScale(){return entityData.get(SCALE);}
    public void setScale(float value){this.entityData.set(SCALE,value);}
    @Override
    public boolean hurt(DamageSource source, float amount) {
        boolean result = super.hurt(source, amount);
        if (result) {
            shrink(amount);
        }
        return result;
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        super.awardKillScore(entity, i, damageSource);
        grow();
    }
    private void grow() {
        if (getScale() < maxScale) {
            setScale(getScale()+0.1f);
            applyScaleEffects();
        }
    }

    private void shrink(float damageTaken) {
        setScale(getScale()-damageTaken * 0.01f);
        if (getScale() < minScale) {
            setScale(minScale);
        }
        applyScaleEffects();
    }
    private void applyScaleEffects() {
        this.refreshDimensions();
        computeAttribute(Attributes.MAX_HEALTH,health * getScale());
        computeAttribute(Attributes.ATTACK_DAMAGE,damage * getScale());
        computeAttribute(Attributes.ARMOR,armor * getScale());
        computeAttribute(Attributes.MOVEMENT_SPEED,0.3 * (1.0f / getScale()));
        if (this.getHealth() > this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return super.getDimensions(pose).scale(getScale());
    }

    private void computeAttribute(Attribute attributes, double value){
        AttributeInstance instance = this.getAttribute(attributes);
        if (instance != null){instance.setBaseValue(value);}
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.FLYING_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, damage)
                .add(Attributes.ARMOR, armor)
                .add(Attributes.FOLLOW_RANGE, 30)
                .add(Attributes.ATTACK_KNOCKBACK, 1);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.bioblob_loot.get();
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity livingEntity) {
                return super.getAttackReachSqr(livingEntity);
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }
    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        if (!level().isClientSide){
            if (Math.random() <= 0.5){
                BileProjectile bileProjectile = new BileProjectile(level(),this,TARGET_SELECTOR);
                double dx = livingEntity.getX() - this.getX();
                double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
                double dz = livingEntity.getZ() - this.getZ();
                bileProjectile.setDamage((float) (SConfig.SERVER.biobloob__ranged_damage.get() * SConfig.SERVER.global_damage.get()));
                bileProjectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
                bileProjectile.shoot(dx, dy - bileProjectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
                level().addFreshEntity(bileProjectile);
            }else {
                AcidBall.shoot(this, livingEntity,(float) (SConfig.SERVER.biobloob__ranged_damage.get() * SConfig.SERVER.global_damage.get()));
                this.playSound(SoundEvents.SLIME_JUMP, 1, 0.5f);
            }
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 60 == 0){
            LivingEntity living = getTarget();
            if (living != null){
                performRangedAttack(living,0);
            }
        }
    }
    @Override
    public void aiStep() {
        super.aiStep();
    }

}
