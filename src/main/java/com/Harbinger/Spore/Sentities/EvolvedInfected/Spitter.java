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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
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
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(Spitter.class, EntityDataSerializers.INT);

    public Spitter(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.1, getShootingPerVariant(), getRangePerVariant()) {
            @Override
            public boolean canUse() {
                return switchyFar() && super.canUse();
            }
        });

        this.goalSelector.addGoal(3, new RangedAttackGoal(this, 1.1, 5, 5) {
            @Override
            public boolean canUse() {
                return switchyClose() && super.canUse();
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

    private boolean switchyFar() {
        if (this.getTarget() != null && (getTypeVariant() == 0 || getTypeVariant() == 3)){
            double ze = this.distanceToSqr(this.getTarget());
            return (ze > 32.0D);
        }
        return true;
    }
    private boolean switchyClose() {
        if (this.getTarget() != null  && (getTypeVariant() == 0 || getTypeVariant() == 3)){
            double ze = this.distanceToSqr(this.getTarget());
            return (ze < 32.0D);
        }
        return false;
    }

    private int getShootingPerVariant() {
        return switch (getVariant()) {
            case BILE -> 50;
            case EXPLOSIVE -> 60;
            default -> 40;
        };
    }

    private int getRangePerVariant() {
        return getVariant() == SpitterVariants.SNIPER ? 32 : 16;
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
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (accessor.equals(DATA_ID_TYPE_VARIANT)) {
            AttributeInstance instance = this.getAttribute(Attributes.FOLLOW_RANGE);
            if (instance != null) instance.setBaseValue(this.getTypeVariant() == 4 ? 64 : 32);
        }
    }

    @Override
    public void performRangedAttack(LivingEntity target, float f) {
        if (level().isClientSide) return;

        double dx = target.getX() - this.getX();
        double dy = target.getY() + target.getEyeHeight() - 1;
        double dz = target.getZ() - this.getZ();
        double dist = this.distanceToSqr(target);

        switch (this.getTypeVariant()) {
            case 1 -> shootTumor(dx, dy, dz);
            case 2 -> shootBile(dx, dy, dz);
            case 3 -> shootCloseOrFar(target, dist, true);
            case 4 -> AcidBall.shoot(this, target,
                    (float) (SConfig.SERVER.spit_damage_l.get() * SConfig.SERVER.global_damage.get()) * 2);
            default -> shootCloseOrFar(target, dist, false);
        }
    }

    private void shootTumor(double dx, double dy, double dz) {
        ThrownTumor tumor = new ThrownTumor(level(), this);
        tumor.setMobEffect(Seffects.CORROSION.get());
        tumor.setExplode(Level.ExplosionInteraction.NONE);
        tumor.moveTo(this.getX(), this.getY() + 1.5, this.getZ());
        tumor.shoot(dx, dy - tumor.getY() + Math.hypot(dx, dz) * 0.05F, dz, 2f, 12.0F);
        level().addFreshEntity(tumor);
    }

    private void shootBile(double dx, double dy, double dz) {
        BileProjectile bile = new BileProjectile(level(), this, TARGET_SELECTOR);
        bile.setDamage((float) (SConfig.SERVER.spit_damage_l.get() * SConfig.SERVER.global_damage.get()));
        bile.moveTo(this.getX(), this.getY() + 1.5, this.getZ());
        bile.shoot(dx, dy - bile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 2f, 12.0F);
        level().addFreshEntity(bile);
    }

    private void shootCloseOrFar(LivingEntity target, double dist, boolean doubleShot) {
        if (dist < 32.0D) {
            float dmg = (float) (SConfig.SERVER.spit_damage_c.get() * SConfig.SERVER.global_damage.get());
            Vomit.shoot(this, target, dmg);
            if (doubleShot) Vomit.shoot(this, target, dmg);
        } else {
            float dmg = (float) (SConfig.SERVER.spit_damage_l.get() * SConfig.SERVER.global_damage.get());
            AcidBall.shoot(this, target, dmg);
            if (doubleShot) AcidBall.shoot(this, target, dmg);
            this.playSound(SoundEvents.SLIME_JUMP, 1, 0.5f);
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

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty,
                                        MobSpawnType type, @Nullable SpawnGroupData group,
                                        @Nullable CompoundTag tag) {
        setVariant(Util.getRandom(SpitterVariants.values(), random));
        return super.finalizeSpawn(level, difficulty, type, group, tag);
    }

    public SpitterVariants getVariant() {
        return SpitterVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,
                (i >= 0 && i < SpitterVariants.values().length) ? i : 0);
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
        return getTypeVariant() != 0 ? this.getVariant().getName() : super.getMutation();
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        return !entity.isInFluidType() && super.hasLineOfSight(entity);
    }
}
