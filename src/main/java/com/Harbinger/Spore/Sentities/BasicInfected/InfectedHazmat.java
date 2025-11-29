package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Inebriator;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.HazmatVariant;
import com.Harbinger.Spore.Sentities.Variants.ScamperVariants;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
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
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class InfectedHazmat extends Infected implements VariantKeeper , EvolvingInfected {
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(InfectedHazmat.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BLOW_TIME = SynchedEntityData.defineId(InfectedHazmat.class, EntityDataSerializers.INT);
    public InfectedHazmat(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.SCIENTIST_AMBIENT.get();
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

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_hazmat_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_hazmat_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_hazmat_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3);

    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(BLOW_TIME, 0);
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
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @javax.annotation.Nullable SpawnGroupData p_146749_,
                                        @javax.annotation.Nullable CompoundTag p_146750_) {
        HazmatVariant variant = Util.getRandom(HazmatVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    public void setBlowTime(int i){
        this.entityData.set(BLOW_TIME,i);
    }
    public int getBlowTime(){
        return this.entityData.get(BLOW_TIME);
    }

    private void tickExplosion(){
        this.setBlowTime(this.getBlowTime()+1);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.getVariant() == HazmatVariant.TANK && Math.random() < 0.5){
            this.tickExplosion();
        }
        return super.hurt(source, amount);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getVariant() == HazmatVariant.TANK){
            if(this.getBlowTime() == 1){
                this.playSound(Ssounds.SCIENTIST_FUSE.get());
            }
            if (this.getBlowTime() > 0){
                this.level().addParticle(ParticleTypes.SMOKE,this.getX(),this.getY()+1,this.getZ(),0,0.1,0);
                tickExplosion();
            }
            if (this.getBlowTime() >= 60){
                explodeTank();
            }
        }
        if (this.getVariant() == HazmatVariant.COAT){
            tickEvolution(this,null, ScamperVariants.DEFAULT);
        }
    }

    @Override
    public void Evolve(Infected livingEntity, List<? extends String> value, ScamperVariants variants) {
        if (level() instanceof ServerLevel world){
            if (this.getVariant() == HazmatVariant.COAT){
                Inebriator inebriator = new Inebriator(Sentities.INEBRIATER.get(),world);
                Collection<MobEffectInstance> collection = livingEntity.getActiveEffects();
                for(MobEffectInstance mobeffectinstance : collection) {
                    inebriator.addEffect(new MobEffectInstance(mobeffectinstance));
                }
                inebriator.setKills(livingEntity.getKills());
                inebriator.setEvoPoints(livingEntity.getEvoPoints());
                inebriator.setSearchPos(livingEntity.getSearchPos());
                inebriator.setLinked(livingEntity.getLinked());
                inebriator.setPos(livingEntity.getX(), livingEntity.getY() + 0.5D, livingEntity.getZ());
                inebriator.setCustomName(livingEntity.getCustomName());
                inebriator.finalizeSpawn(world, livingEntity.level().getCurrentDifficultyAt(new BlockPos((int) livingEntity.getX(),(int)  livingEntity.getY(),(int)  livingEntity.getZ())), MobSpawnType.NATURAL, null, null);
                world.addFreshEntity(inebriator);
                livingEntity.discard();
            }
            double x0 = livingEntity.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = livingEntity.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
            double z0 = livingEntity.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            world.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
        }
    }

    private void explodeTank(){
        if (!this.level().isClientSide){
            this.level().explode(this,this.getX(),this.getY(),this.getZ(),SConfig.SERVER.gastank_explosion.get(), Level.ExplosionInteraction.NONE);
            this.discard();
        }
    }

    public HazmatVariant getVariant() {
        return HazmatVariant.byId(this.getTypeVariant() & 255);
    }

    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        if (i > HazmatVariant.values().length || i < 0){
            this.entityData.set(DATA_ID_TYPE_VARIANT, 0);
        }else {
            this.entityData.set(DATA_ID_TYPE_VARIANT, i);
        }
    }

    @Override
    public int amountOfMutations() {
        return HazmatVariant.values().length;
    }

    private void setVariant(HazmatVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    public boolean addEffect(MobEffectInstance effectInstance, @Nullable Entity entity) {
        if (effectInstance.getEffect().isBeneficial() || this.getTypeVariant() == 2){
            return super.addEffect(effectInstance, entity);
        }
        return false;
    }
}
