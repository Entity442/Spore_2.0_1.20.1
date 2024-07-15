package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.FoliageSpread;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class GastGeber extends EvolvedInfected implements FoliageSpread {
    public static final EntityDataAccessor<BlockPos> SPREAD_POINT = SynchedEntityData.defineId(GastGeber.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<Integer> TIME_ROOTED = SynchedEntityData.defineId(GastGeber.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> AGGRESSION = SynchedEntityData.defineId(GastGeber.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> SPREAD_INTERVAL = SynchedEntityData.defineId(GastGeber.class, EntityDataSerializers.INT);
    private final static int maxCounter = SConfig.SERVER.mound_cooldown.get();
    public final  int maxRootTime = 300;
    public GastGeber(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    @Override
    public boolean removeWhenFarAway(double p_21542_) {
        if (this.level() instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            return data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get();
        }
        return false;
    }
    @Override
    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        float value = blockstate.getDestroySpeed(this.level(),blockpos);
        return this.tickCount % 20 == 0 && value > 0 && value <=getBreaking();
    }
    public int getBreaking(){
        return SConfig.SERVER.experiment_bd.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.knight_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.knight_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.knight_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    @Override
    public boolean canStarve() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
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

    @Override
    protected void addRegularGoals() {
        this.goalSelector.addGoal(3,new MeleeAttackGoal(this ,1.1,true){
            @Override
            public boolean canUse() {
                return super.canUse() && GastGeber.this.getAggression() > 0;
            }
        });
        this.goalSelector.addGoal(3,new FindPlaceToInfect(this));
        this.goalSelector.addGoal(4,new RandomStrollGoal(this,1));
    }

    public boolean isRooted(){
        return getTimeRooted() > 0;
    }
    public BlockPos getRootPoint(){
        return entityData.get(SPREAD_POINT);
    }
    public void setRootPoint(BlockPos pos){
        entityData.set(SPREAD_POINT,pos);
    }
    public int getTimeRooted(){
        return entityData.get(TIME_ROOTED);
    }
    public void setTimeRooted(int value){
        entityData.set(TIME_ROOTED,value);
    }
    public int getAggression(){
        return entityData.get(AGGRESSION);
    }
    public void setAggression(int value){
        entityData.set(AGGRESSION,value);
    }
    public int getSpreadInterval(){
        return entityData.get(SPREAD_INTERVAL);
    }
    public void setSpreadInterval(int value){
        entityData.set(SPREAD_INTERVAL,value);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(SPREAD_POINT,BlockPos.ZERO);
        entityData.define(TIME_ROOTED,0);
        entityData.define(AGGRESSION,0);
        entityData.define(SPREAD_INTERVAL,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        int x = tag.getInt("spreadX");
        int y = tag.getInt("spreadY");
        int z = tag.getInt("spreadZ");
        setRootPoint(new BlockPos(x,y,z));
        setTimeRooted(tag.getInt("root"));
        setAggression(tag.getInt("anger"));
        setSpreadInterval(tag.getInt("spread"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("spreadX",getRootPoint().getX());
        tag.putInt("spreadY",getRootPoint().getY());
        tag.putInt("spreadZ",getRootPoint().getZ());
        tag.putInt("root",getTimeRooted());
        tag.putInt("anger",getAggression());
        tag.putInt("spread",getSpreadInterval());
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() instanceof LivingEntity){
            setAggression(30);
            setTimeRooted(0);
        }
        return super.hurt(source, amount);
    }

    @Override
    public void tick() {
        super.tick();
        if (isRooted() && this.onGround()){
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
        }
        if (this.tickCount % 20 == 0 && isAlive()){
            if (getAggression() > 0){
                setAggression(getAggression()-1);
            }
            if (isRooted()){
                setTimeRooted(getTimeRooted()-1);
                if (this.getSpreadInterval() < maxCounter){
                    setSpreadInterval(this.getSpreadInterval()+1);
                }else{
                    SpreadInfection(level(),25,getOnPos());
                    setSpreadInterval(0);
                }
                if (getHealth() < getMaxHealth()){
                    setHealth(getHealth()+1);
                }
            }
        }
        if (this.tickCount % 1200 == 0 && !isRooted() && getAggression() <= 0){
            findNewPos();
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (level() instanceof ServerLevel serverLevel && getSpreadInterval() > maxCounter-3){
            double x0 = this.getX() - (random.nextFloat() - 0.2) * 0.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.5) * 0.5D * 10;
            double z0 = this.getZ() + (random.nextFloat() - 0.2) * 0.2D;
            serverLevel.sendParticles(Sparticles.SPORE_PARTICLE.get(), x0, y0, z0, 9,0, 0, 0,1);
        }
    }
    public void findNewPos(){
        BlockPos pos = this.getOnPos();
        int x = random.nextInt(-32,32);
        int z = random.nextInt(-32,32);
        int y = random.nextInt(-6,6);
        BlockPos repos = new BlockPos(pos.getX()+x,pos.getY()+y,pos.getZ()+z);
        this.setRootPoint(repos);
    }
    private static class FindPlaceToInfect extends Goal{
        private final GastGeber geber;
        public int tryTicks;

        public FindPlaceToInfect(GastGeber geber1){
            geber = geber1;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }
        @Override
        public boolean canUse() {
            if (geber.isRooted() || geber.getAggression() >0){
                return false;
            }
            if (geber.level().getBlockState(geber.getRootPoint().above()) != Blocks.AIR.defaultBlockState()){
                geber.findNewPos();
                return false;
            }
            return geber.getRootPoint() != BlockPos.ZERO;
        }

        protected void moveMobToBlock() {
            this.geber.getNavigation().moveTo((double)(this.geber.getRootPoint().getX()) + 0.5D, (double)(this.geber.getRootPoint().getY()), (double)(this.geber.getRootPoint().getZ()) + 0.5D, 1);
        }
        @Override
        public void start() {
            this.moveMobToBlock();
            this.tryTicks = 0;
            super.start();
        }
        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            if (this.geber.getRootPoint() != BlockPos.ZERO && shouldRecalculatePath()){
                this.geber.getNavigation().moveTo(this.geber.getRootPoint().getX(),this.geber.getRootPoint().getY(),this.geber.getRootPoint().getZ(),1);
            }
            if (this.geber.getRootPoint() != BlockPos.ZERO && this.geber.getRootPoint().closerToCenterThan(this.geber.position(),9.0)){
                geber.setTimeRooted(geber.maxRootTime);
            }
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (TIME_ROOTED.equals(dataAccessor)){
            if (getTimeRooted() == 0){
                findNewPos();
            }
        }
        super.onSyncedDataUpdated(dataAccessor);
    }
}
