package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.ColdEndurance;
import com.Harbinger.Spore.Sentities.Projectile.AcidBall;
import com.Harbinger.Spore.Sentities.Projectile.TarBall;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.ChemistVariants;
import com.Harbinger.Spore.Core.*;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Chemist extends EvolvedInfected implements VariantKeeper {
    private int attackAnimationTick;
    private static final EntityDataAccessor<Integer> BLOW_TIME = SynchedEntityData.defineId(Chemist.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Chemist.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Float> CHAR_SWELL = SynchedEntityData.defineId(Chemist.class, EntityDataSerializers.FLOAT);
    public Chemist(EntityType<? extends EvolvedInfected> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        super.registerGoals();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.chemist_loot.get();
    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.knight_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.chemist_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.chemist_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.chemist_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32);

    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
            if (level().isClientSide) {
                Vec3 forward = this.getLookAngle().normalize().scale(1);
                double px = this.getX() + forward.x;
                double py = this.getEyeY()-0.25;
                double pz = this.getZ() + forward.z;
                SimpleParticleType type = getVariant() == ChemistVariants.MECHANIC ? Sparticles.TAR.get() : ParticleTypes.FLAME;
                for (int i = 0; i < 8; i++) {
                    level().addParticle(
                            type,
                            px+random.nextDouble() - random.nextDouble(),
                            py,
                            pz+random.nextDouble() - random.nextDouble(),
                            0,
                            0.05d,
                            0
                    );
                }
            }
        } else {
            super.handleEntityEvent(value);
        }
    }



    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(BLOW_TIME, 0);
        entityData.define(DATA_ID_TYPE_VARIANT,0);
        entityData.define(CHAR_SWELL, 0f);
    }
    public void handleChar(){
        float val = entityData.get(CHAR_SWELL);
        if (isAggressive()){
            if (val < 40){
                entityData.set(CHAR_SWELL,val+0.2f);
            }
        }else {
            if (val > 0){
                entityData.set(CHAR_SWELL,val-0.1f);
            }
        }
        float range = (val/4);
        if (range < 1.5){
            return;
        }
        for (int i = 0;i<10;i++){
            float randomX = (float) (position().x + (random.nextFloat() -random.nextFloat()) * range);
            float randomY = (float) (position().y + 1 + (random.nextFloat() -random.nextFloat()) * range);
            float randomZ = (float) (position().z + (random.nextFloat() -random.nextFloat()) * range);
            this.level().addParticle(ParticleTypes.SMALL_FLAME,randomX,randomY,randomZ,0,0,0);
        }
        if (tickCount % 20 == 0){
            AABB aabb = this.getBoundingBox().inflate(1 + range);
            List<Entity> entities = level().getEntities(this,aabb);
            for (Entity entity : entities){
                if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                    living.setRemainingFireTicks(40);
                }
            }
        }
    }
    public void handleNetherGas(){
        for (int i = 0;i<30;i++){
            float randomX = (float) (position().x + (random.nextFloat() -random.nextFloat()) * 5);
            float randomY = (float) (position().y + 1 + (random.nextFloat() -random.nextFloat()) * 5);
            float randomZ = (float) (position().z + (random.nextFloat() -random.nextFloat()) * 5);
            this.level().addParticle(Math.random() < 0.33 ? ParticleTypes.SOUL : Math.random() < 0.33 ? ParticleTypes.MYCELIUM : Sparticles.SPORE_PARTICLE.get(),randomX,randomY,randomZ,0,0,0);
        }
        AABB aabb = this.getBoundingBox().inflate(8);
        List<Entity> entities = level().getEntities(this,aabb);
        for (Entity entity : entities){
            if (entity instanceof LivingEntity living){
                if ((entity instanceof UtilityEntity || entity instanceof Infected)){
                    living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,600,0));
                }else {
                    if (Utilities.TARGET_SELECTOR.Test(living) && !Utilities.helmetList().contains(living.getItemBySlot(EquipmentSlot.HEAD).getItem())){
                        living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),400,1));
                        living.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,600,0));
                    }
                }
            }
        }
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        if (getVariant() == ChemistVariants.DEFAULT){
            entity.setRemainingFireTicks(200);
            this.playSound(SoundEvents.FLINTANDSTEEL_USE);
        }
        if (getVariant() == ChemistVariants.BURST){
            return super.doHurtTarget(entity);
        }
        if (getVariant() == ChemistVariants.MECHANIC){
            if (Math.random() > 0.3){
                entity.setRemainingFireTicks(100);
                this.playSound(SoundEvents.FLINTANDSTEEL_USE);
            }
        }
        return super.doHurtTarget(entity);
    }
    @Override
    public void tick() {
        super.tick();
        if (getBlowTime() > 0){
            this.level().addParticle(ParticleTypes.SMOKE,this.getX(),this.getY()+1,this.getZ(),0,0.1,0);
            tickExplosion();
        }
        if (getBlowTime() > 60){
            explodeChemist();
        }
        if (tickCount % 20 == 0){
            LivingEntity living = getTarget();
            if ((this.getVariant() == ChemistVariants.MECHANIC || this.getVariant() == ChemistVariants.FUMING) && living != null && this.hasLineOfSight(living)){
                shootTar(living,this.getVariant() == ChemistVariants.FUMING);
                if (Math.random() < 0.5f && this.getVariant() == ChemistVariants.FUMING){
                    shootAcid(living);
                }
            }
        }
        if (tickCount % 100 == 0){
            extinguishTeammates();
        }
        if (getTypeVariant() == 3){
            handleChar();
        }
    }
    public void extinguishTeammates(){
        AABB aabb = getBoundingBox().inflate(8,4,8);
        List<Entity> entities = level().getEntities(this,aabb);
        for (Entity entity : entities){
            if ((entity instanceof UtilityEntity || entity instanceof Infected) && entity.isOnFire()){
                entity.extinguishFire();
            }
        }
    }
    public void shootTar(LivingEntity livingEntity ,boolean ignited){
        TarBall projectile = new TarBall(this, level(), TARGET_SELECTOR,1f,1);
        double dx = livingEntity.getX() - this.getX();
        double dy = livingEntity.getY() + livingEntity.getEyeHeight() - 1;
        double dz = livingEntity.getZ() - this.getZ();
        projectile.setIgnited(ignited);
        projectile.moveTo(this.getX(),this.getY()+1.5,this.getZ());
        projectile.shoot(dx, dy - projectile.getY() + Math.hypot(dx, dz) * 0.05F, dz, 1f * 2, 12.0F);
        level().addFreshEntity(projectile);
    }
    public void shootAcid(LivingEntity livingEntity){
        AcidBall.shoot(this, livingEntity, 1);
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.attackAnimationTick > 0) {
            --this.attackAnimationTick;
        }
    }

    @Override
    public ColdEndurance getEndurance() {
        return ColdEndurance.HYPER;
    }

    @Override
    public boolean fireImmune() {
        return super.fireImmune() || getVariant() == ChemistVariants.FUMING;
    }

    public void explodeChemist(){
        if (this.level() instanceof ServerLevel serverLevel){
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && SConfig.SERVER.chemist_explosion_on.get() ?
                    Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            serverLevel.explode(this, this.getX(), this.getY(), this.getZ(), (float) (SConfig.SERVER.chemist_explosion.get() * 1f), explosion$blockinteraction);
            Utilities.convertBlocks(serverLevel,this,this.getOnPos(),7, Blocks.FIRE.defaultBlockState());
            this.discard();
        }
    }
    @Override
    public boolean addEffect(MobEffectInstance effectInstance, @Nullable Entity entity) {
        if (effectInstance.getEffect().isBeneficial()){
            return super.addEffect(effectInstance, entity);
        }
        return false;
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (getVariant() == ChemistVariants.SPREADER){
            handleNetherGas();
        }else {
            if (source.getEntity() != null && Math.random() < 0.2){
                tickExplosion();
            }
        }
        return super.hurt(source, amount);
    }

    public void setBlowTime(int i){
        this.entityData.set(BLOW_TIME,i);
    }
    public int getBlowTime(){
        return this.entityData.get(BLOW_TIME);
    }

    private void tickExplosion(){
        if (level().isClientSide){
            return;
        }
        this.setBlowTime(this.getBlowTime()+1);
        if (getBlowTime() == 1){
            this.playSound(Ssounds.CHEMIST_FUSE.get());
        }
    }

    public int getAttackAnimationTick(){
        return attackAnimationTick;
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.SCIENTIST_AMBIENT.get();
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

    public ChemistVariants getVariant() {
        return ChemistVariants.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > ChemistVariants.values().length || i < 0 ? 0 : i);
    }

    @Override
    public int amountOfMutations() {
        return ChemistVariants.values().length;
    }

    private void setVariant(ChemistVariants variant) {
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
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        ChemistVariants variant = Util.getRandom(ChemistVariants.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }
}
