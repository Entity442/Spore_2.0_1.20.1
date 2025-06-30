package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import com.Harbinger.Spore.Sentities.Projectile.ThrownTumor;
import com.Harbinger.Spore.Sentities.Projectile.Vomit;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.SpitterVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.List;

public class Spitter extends EvolvedInfected implements RangedAttackMob, VariantKeeper {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Spitter.class, EntityDataSerializers.INT);
    public Spitter(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new RangedAttackGoal(this,1.1, getShootingPerVariant() , 16){
            @Override
            public boolean canUse() {
                if (Spitter.this.getTypeVariant() == 0 && !switchy()){
                    return false;
                }
                return super.canUse();
            }});

        this.goalSelector.addGoal(3, new RangedAttackGoal(this,1.1, 5 , 5){
            @Override
            public boolean canUse() {
                return super.canUse() && Spitter.this.getTypeVariant() == 0;
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));


        super.registerGoals();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_spitter_loot.get();
    }
    private boolean switchy() {
        if (this.getTarget() != null){
            double ze = this.distanceToSqr(this.getTarget());
            return !(ze < 32.0D);
        }
        return true ;
    }
    private int getShootingPerVariant(){
        if (getVariant() == SpitterVariants.BILE){
            return 50;
        }if (getVariant() == SpitterVariants.EXPLOSIVE){
            return 60;
        }
        return 40;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.spit_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ARMOR, SConfig.SERVER.spit_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }




    @Override
    public void performRangedAttack(LivingEntity livingEntity, float f) {
        if (!level().isClientSide){
            if (this.getTypeVariant() == 1){
                ThrownTumor tumor = new ThrownTumor(level(), this);
                double dx = livingEntity.getX() - this.getX();
                double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
                double dz = livingEntity.getZ() - this.getZ();
                tumor.setMobEffect(Seffects.CORROSION.get());
                tumor.setExplode(Level.ExplosionInteraction.NONE);
                tumor.moveTo(this.getX(),this.getY()+1.5,this.getZ());
                tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
                level().addFreshEntity(tumor);
            }else if (this.getTypeVariant() == 2){
                BileProjectile bileProjectile = new BileProjectile(level(),this,TARGET_SELECTOR);
                double dx = livingEntity.getX() - this.getX();
                double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
                double dz = livingEntity.getZ() - this.getZ();
                bileProjectile.setDamage((float) (SConfig.SERVER.spit_damage_l.get()*1f));
                bileProjectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
                bileProjectile.shoot(dx, dy - bileProjectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
                level().addFreshEntity(bileProjectile);
            }else {
                double ze = this.distanceToSqr(livingEntity);
                if (ze < 32.0D) {
                    Vomit.shoot(this, livingEntity,(float) (SConfig.SERVER.spit_damage_c.get() * SConfig.SERVER.global_damage.get()));
                } else {
                    AcidBall.shoot(this, livingEntity,(float) (SConfig.SERVER.spit_damage_l.get() * SConfig.SERVER.global_damage.get()));
                    this.playSound(SoundEvents.SLIME_JUMP, 1, 0.5f);
                }
            }
        }
    }

    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
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


    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        SpitterVariants variant = Util.getRandom(SpitterVariants.values(),random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public SpitterVariants getVariant() {
        return SpitterVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        if (i > SpitterVariants.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return SpitterVariants.values().length;
    }

    private void setVariant(SpitterVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }

    @Override
    public String getMutation() {
        if (getTypeVariant() != 0){
            return this.getVariant().getName();
        }
        return super.getMutation();
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        if (entity.isInFluidType()){
            return false;
        }
        return super.hasLineOfSight(entity);
    }
}
