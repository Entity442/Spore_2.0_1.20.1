package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

public class TumoroidNuke extends UtilityEntity{
    public static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> OVERCLOCKED = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> BUSTER = SynchedEntityData.defineId(Hinderburg.class, EntityDataSerializers.BOOLEAN);
    private Hinderburg hinderburg;

    public TumoroidNuke(Level level,Hinderburg hinderburg){
        super(Sentities.TUMOROID_NUKE.get(),level);
        this.hinderburg = hinderburg;
        this.moveTo(hinderburg.getX(),hinderburg.getY(),hinderburg.getZ());
        this.setYBodyRot(hinderburg.getYRot());
        this.setTimer(80);
    }

    public TumoroidNuke(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER, 0);
        this.entityData.define(OVERCLOCKED, false);
        this.entityData.define(BUSTER, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timer", entityData.get(TIMER));
        tag.putBoolean("overclocked", entityData.get(OVERCLOCKED));
        tag.putBoolean("buster", entityData.get(BUSTER));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(OVERCLOCKED, tag.getBoolean("overclocked"));
        entityData.set(BUSTER, tag.getBoolean("buster"));
    }


    public int getTimer(){
        return this.entityData.get(TIMER);
    }
    public void setTimer(int e){
        this.entityData.set(TIMER,e);
    }
    private void tickTimer(){
        this.setTimer(this.getTimer()-1);
    }
    public void setOverclocked(boolean value){this.entityData.set(OVERCLOCKED,value);}
    public void setBuster(boolean value){this.entityData.set(BUSTER,value);}
    @Override
    public void tick() {
        super.tick();
        this.tickTimer();
        if (getTimer() <= 0)
            if (entityData.get(BUSTER)){
                this.explodeNuke(new BlockPos(0,0,0),entityData.get(OVERCLOCKED), SConfig.SERVER.hinden_explosion.get()/2);
                this.explodeNuke(new BlockPos(0,-5,0),entityData.get(OVERCLOCKED),SConfig.SERVER.hinden_explosion.get()/2);
                this.explodeNuke(new BlockPos(0,-10,0),entityData.get(OVERCLOCKED),SConfig.SERVER.hinden_explosion.get()/2);
            }else {
                this.explodeNuke(new BlockPos(0,0,0),entityData.get(OVERCLOCKED),SConfig.SERVER.hinden_explosion.get());
            }
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.WOMB_AMBIENT.get();
    }

    @Override
    protected int calculateFallDamage(float value1, float value2) {
        if (!this.level().isClientSide && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) && fallDistance > 4){
            AABB aabb = this.getBoundingBox().inflate(1);
            for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                BlockState blockstate = this.level().getBlockState(blockpos);
                if (blockstate.getDestroySpeed(level(), blockpos) < 3 && blockstate.getDestroySpeed(level(), blockpos) >= 0) {
                    this.level().destroyBlock(blockpos, false, this);
                }
            }
        }
        return super.calculateFallDamage(value1, value2);
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        return false;
    }

    public void explodeNuke(BlockPos offset,boolean fire,int value){
        if (!this.level().isClientSide){
            Entity entity = this.hinderburg != null ? this.hinderburg : this;
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) ? Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            this.level().explode(entity,this.getX() + offset.getX(),this.getY()+ offset.getY(),this.getZ()+ offset.getZ(),value, explosion$blockinteraction);
            if (fire && this.level() instanceof ServerLevel serverLevel){
                Utilities.convertBlocks(serverLevel,this,this.getOnPos(),14, Blocks.FIRE.defaultBlockState());
            }
            level().playSound(this,blockPosition(),Ssounds.TUMOROID_EXPLOSION.get(), SoundSource.MASTER,1f,1f);
            this.discard();
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10)
                .add(Attributes.FOLLOW_RANGE, 4);
    }


}
