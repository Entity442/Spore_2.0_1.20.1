package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.List;

public class Stalker extends EvolvedInfected implements EvolvingInfected {
    public static final EntityDataAccessor<Integer> CAMO = SynchedEntityData.defineId(Stalker.class, EntityDataSerializers.INT);
    private int camo;
    public Stalker(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.navigation = new WallClimberNavigation(this,level);
        this.moveControl = new InfectedWallMovementControl(this);
    }
    public void customServerAiStep() {
        this.setSprinting(isAggressive() && this.getTarget() != null && (this.getTarget().isSprinting() || this.getTarget().getHealth() < this.getTarget().getMaxHealth()/2));
        this.spawnSprintParticle();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_stalker_loot.get();
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LeapAtTargetGoal(this,0.3F));
        this.goalSelector.addGoal(1, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}});


        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        super.registerGoals();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.stalker_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.stalker_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.stalker_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_GROWL.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_VILLAGER_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_VILLAGER_DEATH.get();
    }


    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("camo", entityData.get(CAMO));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(CAMO, tag.getInt("camo"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(CAMO, 0);
    }

    public int getCamo(){
        return entityData.get(CAMO);
    }
    public void setCamo(int i){
        entityData.set(CAMO,i);
    }

    public int getBiomeTint(){
        int i = Mth.floor(this.getX());
        int j = Mth.floor(this.getY());
        int k = Mth.floor(this.getZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        Biome biome = this.level().getBiome(blockpos).value();
        return biome.getFoliageColor();
    }

    @Override
    public void tick() {
        super.tick();
        this.tickHyperEvolution(this);
        if (this.camo <=1200){
            this.camo++;
        }else{
            this.camo = 0;
            this.setCamo(getBiomeTint());
        }
    }

    @Override
    public void HyperEvolve() {
        Wendigo wendigo = new Wendigo(Sentities.WENDIGO.get(),this.level());
        Collection<MobEffectInstance> collection = this.getActiveEffects();
        for(MobEffectInstance mobeffectinstance : collection) {
            wendigo.addEffect(new MobEffectInstance(mobeffectinstance));
        }
        wendigo.setKills(this.getKills());
        wendigo.setEvoPoints(this.getEvoPoints()-SConfig.SERVER.min_kills_hyper.get());
        wendigo.setCustomName(this.getCustomName());
        wendigo.setPos(this.getX(),this.getY(),this.getZ());
        if (this.level() instanceof ServerLevel serverLevel)
        wendigo.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()), MobSpawnType.CONVERSION,null,null);
        this.level().addFreshEntity(wendigo);
        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
        }
        this.discard();
    }
}
