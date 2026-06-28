package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Projectile.StingerProjectile;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.ThornVariants;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.Util;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class Thorn extends EvolvedInfected implements VariantKeeper {
    public static final int SPIKE_AMOUNT = 57;
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Thorn.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SPIKES = SynchedEntityData.defineId(Thorn.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> ROLLING = SynchedEntityData.defineId(Thorn.class, EntityDataSerializers.BOOLEAN);
    public Thorn(EntityType<? extends Infected> type, Level level) {
        super(type, level);
    }

    @Override
    protected void addRegularGoals() {
        super.addRegularGoals();
        this.goalSelector.addGoal(2, new RollingChargeGoal(this, 2D));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            public boolean canUse() {
                if (getRolling()){
                    return false;
                }
                return super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                if (getRolling()){
                    return false;
                }
                return super.canContinueToUse();
            }

            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_TYPE_VARIANT, 0);
        entityData.define(SPIKES, SPIKE_AMOUNT);
        entityData.define(ROLLING, false);
    }
    public void setSpikeAmount(int val){
        entityData.set(SPIKES,val);
    }
    public int getSpikeAmount(){
        return entityData.get(SPIKES);
    }
    public void setRolling(boolean val){
        entityData.set(ROLLING,val);
    }
    public boolean getRolling(){
        return entityData.get(ROLLING);
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
        tag.putInt("Spikes", this.getSpikeAmount());
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 20 == 0 && getSpikeAmount() < SPIKE_AMOUNT){
            setSpikeAmount(getSpikeAmount()+1);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
        this.entityData.set(SPIKES, tag.getInt("Spikes"));
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.thorn_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.thorn_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.thorn_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (getRolling() && getVariant() == ThornVariants.ROLLER){
            amount = amount/2;
        }
        if (this.getVariant() == ThornVariants.SKEWER){
            if (getSpikeAmount() > 0){
                int o = getSpikeAmount() > 10 ? random.nextInt(15) : getSpikeAmount();
                shootRandomArrows(o,2,4);
            }
            return super.hurt(source, amount);
        }
        if (source.getDirectEntity() instanceof LivingEntity livingEntity && livingEntity.distanceToSqr(this)<100D && !source.is(DamageTypes.THORNS)){
           if (this.getVariant() == ThornVariants.TOXIC){
               livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON,200,0));
               livingEntity.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,0));
           }
            boolean cactus = this.getVariant() == ThornVariants.CACTUS;
            float damage = cactus ? amount : amount * 0.4f;
            if(cactus && livingEntity instanceof Player player){
                player.getCooldowns().addCooldown(player.getItemInHand(InteractionHand.MAIN_HAND).getItem(),40);
            }
           livingEntity.hurt(this.level().damageSources().thorns(this),damage);
        }
        return super.hurt(source, amount);
    }

    private void shootRandomArrows(int count, float speed, float spread) {
        Level level = this.level();
        if (level.isClientSide()) return;
        this.setSpikeAmount(getSpikeAmount()-count);
        for (int i = 0; i < count; i++) {
            StingerProjectile stinger = new StingerProjectile(level, this,5);
            float yaw = this.random.nextFloat() * 360.0F;
            float pitch = (this.random.nextFloat() - 0.5F) * spread * 2;
            float radYaw = (float)Math.toRadians(yaw);
            float radPitch = (float)Math.toRadians(pitch);
            double x = Math.cos(radPitch) * Math.cos(radYaw);
            double y = Math.sin(radPitch);
            double z = Math.cos(radPitch) * Math.sin(radYaw);
            stinger.moveTo(this.getX(),this.getY()+1.25,this.getZ());
            Vec3 direction = new Vec3(x, y, z).normalize().scale(speed);
            stinger.setPoison(false);
            stinger.shoot(direction.x, direction.y, direction.z, speed, 1.0F);
            level.addFreshEntity(stinger);
        }
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.HUNGER,1200,0));
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ThornVariants variant = Util.getRandom(ThornVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.HUSK_AMBIENT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.thorn_loot.get();
    }

    private void setVariant(ThornVariants variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    public ThornVariants getVariant() {
        return ThornVariants.byId(this.getTypeVariant() & 255);
    }
    @Override
    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > ThornVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public String getMutation() {
        return getTypeVariant() != 0 ? this.getVariant().getName() : super.getMutation();
    }

    @Override
    public int amountOfMutations() {
        return ThornVariants.values().length;
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (ROLLING.equals(dataAccessor)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return getRolling() ? super.getDimensions(pose).scale(1,0.65f) : super.getDimensions(pose);
    }

    public static class RollingChargeGoal extends Goal {
        private final Thorn entity;
        private LivingEntity target;
        private int chargeTimer;
        private int hitCooldown;
        private final double speed;
        private final int maxChargeTime;

        public RollingChargeGoal(Thorn entity, double speed) {
            this.entity = entity;
            this.speed = speed;
            this.maxChargeTime = 100;
            this.hitCooldown = 0;
        }

        @Override
        public boolean canUse() {
            if (entity.getVariant() != ThornVariants.ROLLER){
                return false;
            }
            LivingEntity potentialTarget = this.entity.getTarget();

            if (potentialTarget == null || !potentialTarget.isAlive()) {
                return false;
            }
            double distance = this.entity.distanceToSqr(potentialTarget);
            if (distance < 100.0) {
                return false;
            }
            if (potentialTarget.getY() > this.entity.getY()) {
                return false;
            }

            this.target = potentialTarget;
            return true;
        }

        @Override
        public boolean canContinueToUse() {
            if (target == null || target.distanceToSqr(entity.position()) < 4){
                return false;
            }
            return this.chargeTimer < this.maxChargeTime;
        }

        @Override
        public void start() {
            this.chargeTimer = 0;
            this.hitCooldown = 0;
            this.entity.setRolling(true);
        }

        @Override
        public void stop() {
            this.target = null;
            this.chargeTimer = 0;
            this.hitCooldown = 0;
            this.entity.setRolling(false);
        }

        @Override
        public void tick() {
            if (this.target == null) return;

            this.chargeTimer++;
            this.hitCooldown = Math.max(0, this.hitCooldown - 1);

            if (entity.tickCount % 10 == 0){
                entity.navigation.moveTo(target,speed);
            }
            this.entity.lookAt(this.target, 30.0F, 30.0F);

            if (this.chargeTimer % 10 == 0 && this.hitCooldown == 0) {
                damageNearbyEntities();
                this.hitCooldown = 10;
            }

            spawnRollingParticles();
        }

        private void damageNearbyEntities() {
            AABB damageBox = this.entity.getBoundingBox().inflate(2.5, 1.5, 2.5);
            List<LivingEntity> nearbyEntities = this.entity.level().getEntitiesOfClass(
                    LivingEntity.class,
                    damageBox,
                    e -> e != this.entity
            );

            for (LivingEntity living : nearbyEntities) {
                if (Utilities.TARGET_SELECTOR.Test(living)){
                    float damage = (float) (SConfig.SERVER.thorn_damage.get() * 0.5f);
                    living.hurt(this.entity.damageSources().mobAttack(this.entity), damage);

                    Vec3 knockbackDirection = living.position().subtract(this.entity.position()).normalize();
                    living.setDeltaMovement(
                            living.getDeltaMovement().add(knockbackDirection.scale(1.5))
                    );

                    living.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1));
                    spawnHitParticles(living);
                }
            }
        }

        private void spawnRollingParticles() {
            Level level = this.entity.level();
            if (level.isClientSide()) {
                for (int i = 0; i < 3; i++) {
                    double x = this.entity.getX() + (this.entity.getRandom().nextDouble() - 0.5) * 2.0;
                    double z = this.entity.getZ() + (this.entity.getRandom().nextDouble() - 0.5) * 2.0;
                    level.addParticle(
                            ParticleTypes.CLOUD,
                            x,
                            this.entity.getY() + 0.1,
                            z,
                            0.0, 0.0, 0.0
                    );
                }
            }
        }

        private void spawnHitParticles(LivingEntity hitEntity) {
            Level level = this.entity.level();
            if (level.isClientSide()) {
                for (int i = 0; i < 10; i++) {
                    level.addParticle(
                            ParticleTypes.CRIT,
                            hitEntity.getX() + (hitEntity.getRandom().nextDouble() - 0.5),
                            hitEntity.getY() + hitEntity.getRandom().nextDouble() * 2.0,
                            hitEntity.getZ() + (hitEntity.getRandom().nextDouble() - 0.5),
                            (hitEntity.getRandom().nextDouble() - 0.5) * 0.5,
                            hitEntity.getRandom().nextDouble() * 0.5,
                            (hitEntity.getRandom().nextDouble() - 0.5) * 0.5
                    );
                }
            }
        }
    }
}
