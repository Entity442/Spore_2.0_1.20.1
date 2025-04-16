package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.AI.LocHiv.BufferAI;
import com.Harbinger.Spore.Sentities.AI.LocHiv.LocalTargettingGoal;
import com.Harbinger.Spore.Sentities.AI.LocHiv.SearchAreaGoal;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Experiment extends Infected{
    public static final EntityDataAccessor<Boolean> DORMANT = SynchedEntityData.defineId(Experiment.class, EntityDataSerializers.BOOLEAN);
    public Experiment(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    public boolean canStarve() {
        return false;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("dormant",entityData.get(DORMANT));
    }

    public boolean isDormant(){
        return entityData.get(DORMANT);
    }
    public void setDormant(boolean value){
        entityData.set(DORMANT,value);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(DORMANT, tag.getBoolean("dormant"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DORMANT,false);
    }
    @Override
    protected void addRegularGoals() {
        this.goalSelector.addGoal(3,new LocalTargettingGoal(this));
        this.goalSelector.addGoal(4, new SearchAreaGoal(this, 1.2));
        this.goalSelector.addGoal(5,new BufferAI(this));
        this.goalSelector.addGoal(6,new FloatDiveGoal(this));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        setDormant(false);
        return super.hurt(source, amount);
    }

    @Override
    public void setTarget(@Nullable LivingEntity entity) {
        super.setTarget(entity);
        if (entity != null && isDormant()){
            setDormant(false);
        }
    }
    @Override
    public void tick() {
        super.tick();
        if (this.onGround() && isDormant()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
        }
    }

    @Override
    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        float value = blockstate.getDestroySpeed(this.level(),blockpos);
        return this.tickCount % 20 == 0 && value > 0 && value <=getBreaking();
    }
    public int getBreaking(){
        return SConfig.SERVER.experiment_bd.get();
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType spawnType, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        if (spawnType == MobSpawnType.NATURAL){
            setDormant(true);
        }
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, spawnType, p_21437_, p_21438_);
    }
}
