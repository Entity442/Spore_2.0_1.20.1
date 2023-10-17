package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Random;

public class BiomassReformator extends Organoid {
    private static final EntityDataAccessor<Integer> COUNTER = SynchedEntityData.defineId(BiomassReformator.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(BiomassReformator.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> STATE = SynchedEntityData.defineId(BiomassReformator.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockPos> LOCATION = SynchedEntityData.defineId(BiomassReformator.class, EntityDataSerializers.BLOCK_POS);
    private int breakCounter;

    public BiomassReformator(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    private int eatingTicks = 0;


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(COUNTER, 0);
        this.entityData.define(BIOMASS, 0);
        this.entityData.define(STATE, 0);
        this.entityData.define(LOCATION, BlockPos.ZERO);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WOMB_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    @Override
    public void tick() {
        super.tick();
        if (this.entityData.get(BIOMASS) >= SConfig.SERVER.reconstructor_biomass.get()){
            this.Summon(this,false);
        }
        if (this.entityData.get(COUNTER) < (SConfig.SERVER.recontructor_clock.get() * 20)){
            this.entityData.set(COUNTER , this.entityData.get(COUNTER) + 1);
        }else{
            this.entityData.set(COUNTER,0);
            this.entityData.set(BIOMASS , this.entityData.get(BIOMASS) + 1);
        }
        if (this.random.nextInt(100) == 0){
            this.CallNearbyInfected();
        }
        if (this.random.nextInt(40) == 0){
            this.AssimilateNearbyInfected();
        }
        if (this.random.nextInt(20) == 0 && isEating()){
            this.playSound(SoundEvents.GENERIC_EAT);
        }
        if (this.eatingTicks > 0){
            --eatingTicks;
        }
    }

    public void setBiomass(int biomass){
        entityData.set(BIOMASS,biomass);
    }
    public int getBiomass(){
        return entityData.get(BIOMASS);
    }

    public void setState(int state){
        entityData.set(STATE,state);
    }
    public int getState(){
        return entityData.get(STATE);
    }
    public void setLocation(BlockPos pos){
        entityData.set(LOCATION,pos);
    }
    public BlockPos getLocation(){
        return entityData.get(LOCATION);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Counter", entityData.get(COUNTER));
        tag.putInt("Biomass", entityData.get(BIOMASS));
        tag.putInt("State", entityData.get(STATE));
        tag.putInt("LocationX", this.getLocation().getX());
        tag.putInt("LocationY", this.getLocation().getY());
        tag.putInt("LocationZ", this.getLocation().getZ());
    }

    public boolean isEating(){
        return eatingTicks > 0;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(COUNTER, tag.getInt("Counter"));
        entityData.set(BIOMASS, tag.getInt("Biomass"));
        entityData.set(STATE, tag.getInt("State"));
        int i = tag.getInt("LocationX");
        int j = tag.getInt("LocationY");
        int k = tag.getInt("LocationZ");
        this.setLocation(new BlockPos(i, j, k));
    }
    private void CallNearbyInfected(){
        if (!this.level().isClientSide) {
        AABB hitbox = this.getBoundingBox().inflate(50);
        List<Entity> entities = this.level().getEntities(this, hitbox ,EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        for (Entity en : entities){
            if (en instanceof Infected infected){
                infected.setSearchPos(new BlockPos((int) this.getX(),(int)this.getY(),(int)this.getZ()));
            }
         }
        }
    }

    private void AssimilateNearbyInfected(){
        if (!this.level().isClientSide) {
            AABB hitbox = this.getBoundingBox().inflate(0.1);
            List<Entity> entities = this.level().getEntities(this, hitbox, EntitySelector.NO_CREATIVE_OR_SPECTATOR);
            for (Entity en : entities) {
                if (en instanceof Infected infected) {
                    this.setBiomass(this.getBiomass() + SConfig.SERVER.reconstructor_assimilation.get() + infected.getKills());
                    infected.discard();
                    if (this.level() instanceof ServerLevel serverLevel) {
                        double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
                        double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.25D * 5;
                        double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
                        serverLevel.sendParticles(Sparticles.BLOOD_PARTICLE.get(), x0, y0, z0, 8, 0, 0, 0, 1);
                    }
                    this.playSound(SoundEvents.GENERIC_EAT);
                    this.eatingTicks = this.eatingTicks + 80;
                    break;
                }
            }
        }
    }


    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (BIOMASS.equals(dataAccessor)){
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        int age = 1;
        if (this.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/4) && this.getBiomass() < (SConfig.SERVER.reconstructor_biomass.get()/2)){
            age = 2;
        }else if (this.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/2)){
            age = 3;
        }
        return super.getDimensions(pose).scale(age);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.reconstructor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.reconstructor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }


    @Override
    public void aiStep() {
        super.aiStep();
        if (breakCounter < 40){
            breakCounter++;
        }else{
            if (this.getLastDamageSource() == this.damageSources().inWall() && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)){
                AABB aabb = this.getBoundingBox().inflate(0.2,0,0.2);
                boolean flag = false;
                for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (blockstate.getDestroySpeed(level() ,blockpos) < 10 && blockstate.getDestroySpeed(level() ,blockpos) > 0) {
                        flag =  this.level().destroyBlock(blockpos, true, this) || flag;
                        breakCounter = 0;
                    }
                }
            }
        }
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        if (this.getHealth() < this.getMaxHealth() && !this.hasEffect(MobEffects.REGENERATION)){
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200,0));
        }
        if (getBiomass() > 1){
            int age = 1;
            if (this.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/4) && this.getBiomass() < (SConfig.SERVER.reconstructor_biomass.get()/2)){
                age = 2;
            }else if (this.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/2)){
                age = 3;
            }
            if (age > 1){
                AttributeInstance health = this.getAttribute(Attributes.MAX_HEALTH);
                assert health != null;
                health.setBaseValue(SConfig.SERVER.mound_hp.get() * age * SConfig.SERVER.global_health.get());
                AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
                assert armor != null;
                armor.setBaseValue(SConfig.SERVER.mound_armor.get() * age * SConfig.SERVER.global_armor.get());
            }
        }
    }

    private void Summon(Entity entity ,boolean value){
        List<? extends String> ev;
        if (entityData.get(STATE) == 1){
            ev = SConfig.SERVER.reconstructor_water.get();
        }else if (entityData.get(STATE) >=2){
            ev = SConfig.SERVER.reconstructor_air.get();
        }else {
            ev = SConfig.SERVER.reconstructor_terrain.get();
        }
        Random rand = new Random();
            int randomIndex = rand.nextInt(ev.size());
            ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
            EntityType<?> randomElement = ForgeRegistries.ENTITY_TYPES.getValue(randomElement1);
            assert randomElement != null;
            Mob waveentity = (Mob) randomElement.create(level());
            waveentity.setPos(entity.getX(), entity.getY(), entity.getZ());
            if (waveentity instanceof Calamity calamity){
                calamity.setSearchArea(this.getLocation());
                if (value){
                    calamity.setSecondsOnFire(3);
                    calamity.setHealth(calamity.getMaxHealth() / 2);}
            }

            if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 0.1D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 0.15D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 0.1D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 2, 0, 0, 0, 1);
            }
            this.discard();
        level().addFreshEntity(waveentity);
    }

    @Override
    public void die(DamageSource p_21014_) {
        if (this.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/2)){
            Summon(this,true);
        }
        super.die(p_21014_);
    }

    @Override
    public int getEmerge_tick() {
        return 60;
    }
}
