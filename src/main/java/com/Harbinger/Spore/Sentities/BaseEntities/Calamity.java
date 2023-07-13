package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Sentities.AI.CalamityPathNavigation;
import com.Harbinger.Spore.Sentities.AI.FloatDiveGoal;
import com.Harbinger.Spore.Sentities.AI.HurtTargetGoal;
import com.Harbinger.Spore.Sentities.Utility.InfectionTendril;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.network.NetworkHooks;

import java.util.EnumSet;

public class Calamity extends UtilityEntity implements Enemy {
    public static final EntityDataAccessor<Integer> KILLS = SynchedEntityData.defineId(Calamity.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<BlockPos> SEARCH_AREA = SynchedEntityData.defineId(InfectionTendril.class, EntityDataSerializers.BLOCK_POS);
    private int breakCounter;
    private int stun = 0;

    public Calamity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, 16.0F);
        this.setPathfindingMalus(BlockPathTypes.DANGER_POWDER_SNOW, -1.0F);
        this.navigation = new CalamityPathNavigation(this,level);
        this.xpReward = 50;
    }

    protected int calculateFallDamage(float p_149389_, float p_149390_) {
        return super.calculateFallDamage(p_149389_, p_149390_) - 25;
    }

    public void setStun(int i) {
        stun = i;
    }

    public boolean isStunned() {
        return stun > 0;
    }

    public boolean doHurtTarget(Entity entity) {
        if (super.doHurtTarget(entity)) {
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(), 600, 1), this);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void awardKillScore(Entity entity, int i, DamageSource damageSource) {
        this.entityData.set(KILLS, entityData.get(KILLS) + 1);
        super.awardKillScore(entity, i, damageSource);
    }

    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.7D));
            if (this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_32858_);
        }

    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("kills", entityData.get(KILLS));
        tag.putInt("AreaX", this.getSearchArea().getX());
        tag.putInt("AreaY", this.getSearchArea().getY());
        tag.putInt("AreaZ", this.getSearchArea().getZ());
    }


    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean isPushedByFluid(FluidType type) {
        return false;
    }

    public void setSearchArea(BlockPos blockPos) {
        this.entityData.set(SEARCH_AREA, blockPos);
    }

    public BlockPos getSearchArea() {
        return this.entityData.get(SEARCH_AREA);
    }

    public void setKills(Integer count) {
        entityData.set(KILLS, count);
    }

    public int getKills() {
        return entityData.get(KILLS);
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(KILLS, tag.getInt("kills"));
        int i = tag.getInt("AreaX");
        int j = tag.getInt("AreaY");
        int k = tag.getInt("AreaZ");
        this.setSearchArea(new BlockPos(i, j, k));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(KILLS, 0);
        this.entityData.define(SEARCH_AREA, BlockPos.ZERO);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }


    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new GoToLocation(this, 1.1));
        this.goalSelector.addGoal(2, new HurtTargetGoal(this ,(en -> {return !SConfig.SERVER.blacklist.get().contains(en.getEncodeId());}), Infected.class).setAlertOthers(Infected.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>
                (this, Player.class,  true));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return SConfig.SERVER.whitelist.get().contains(en.getEncodeId()) || (en.hasEffect(Seffects.MARKER.get()) && !(en instanceof Infected || en instanceof UtilityEntity));
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, true, (en) -> {
            return (!this.likedFellows(en) || this.otherWorld(en) || this.SkulkLove(en)) && SConfig.SERVER.at_mob.get();
        }));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Animal.class, 5, false, true, (en) -> {
            return !SConfig.SERVER.blacklist.get().contains(en.getEncodeId()) && SConfig.SERVER.at_an.get();
        }));

        this.goalSelector.addGoal(6, new FloatDiveGoal(this));


    }

    public boolean otherWorld(Entity entity){
        return ModList.get().isLoaded("fromanotherworld") && SConfig.SERVER.faw_target.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("fromanotherworld:things")));
    }

    public boolean SkulkLove(Entity entity){
        return (ModList.get().isLoaded("sculkhorde") && SConfig.SERVER.skulk_target.get() && entity.getType().is(TagKey.create(Registries.ENTITY_TYPE,
                new ResourceLocation("sculkhorde:sculk_entity"))));
    }

    public boolean likedFellows(Entity en){
        return en instanceof Animal || en instanceof AbstractFish || en instanceof Infected || en instanceof UtilityEntity;
    }


    public  boolean tryToDigDown(){
        if (this.getSearchArea() != BlockPos.ZERO && this.verticalCollisionBelow){
            return this.getSearchArea().getY() < this.getY() && (Math.abs(this.getSearchArea().getX())  - Math.abs(this.getX()) < 6) && (Math.abs(this.getSearchArea().getZ()) - Math.abs(this.getZ()) < 6);
        }
        return false;
    }

    public void relocateExitPoint(){
        RandomSource randomSource = RandomSource.create();
        if (this.getSearchArea().getY() > this.getY()){
            if ((Math.abs(this.getSearchArea().getX())  - Math.abs(this.getX()) < 6) && (Math.abs(this.getSearchArea().getZ()) - Math.abs(this.getZ()) < 6) && (Math.abs(this.getSearchArea().getY()) - Math.abs(this.getY()) > 4)){
                int f = (int) Math.abs(Math.abs(this.getSearchArea().getY()) - Math.abs(this.getY()));
                int x = randomSource.nextInt(-f,f);
                int z = randomSource.nextInt(-f,f);
               this.setSearchArea(new BlockPos(this.getSearchArea().getX() + x,this.getSearchArea().getY(),this.getSearchArea().getZ() + z));
            }
        }

    }

    public AABB getMiningHitbox(){
        if (this.getSearchArea() != BlockPos.ZERO && !this.isAggressive()){
            if (this.getSearchArea().getY() < this.getY()){
                return this.getBoundingBox().inflate(1.5,0.0,1.5).move(0.0,-1.0,0.0);
            }else if (this.getSearchArea().getY() > this.getY()){
                return this.getBoundingBox().inflate(1.5,0.0,1.5).move(0.0,1.0,0.0);
            }else{
                return this.getBoundingBox().inflate(1.5,0.0,1.5);
            }
        }
        return this.getBoundingBox().inflate(1.5,0.0,1.5).move(0.0,1.0,0.0);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getRandom().nextInt(300) == 0 && this.getSearchArea() != BlockPos.ZERO){
            relocateExitPoint();
        }
        if (breakCounter < 80) {
            breakCounter++;
        } else {
            if ((this.getLastDamageSource() == this.damageSources().cactus() || this.getLastDamageSource() == this.damageSources().inWall() || this.horizontalCollision || tryToDigDown()) && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                AABB aabb = getMiningHitbox();
                boolean flag = false;
                for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
                    BlockState blockstate = this.level().getBlockState(blockpos);
                    if (blockstate.getDestroySpeed(level(), blockpos) < getDestroySpeed() && blockstate.getDestroySpeed(level(), blockpos) >= 0) {
                        flag = this.level().destroyBlock(blockpos, false, this) || flag;
                        breakCounter = 0;
                    }
                }
            }
        }
        if (stun > 0 && this.onGround() && this.level() instanceof ServerLevel serverLevel) {
            --stun;
            this.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0, 1, 0));
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 1.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 1.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 1.2D;
            serverLevel.sendParticles(Sparticles.BLOOD_PARTICLE.get(), x0, y0, z0, 4, 0, 0, 0, 1);
        }
    }

    public int getDestroySpeed(){
        return 5;
    }

    static class GoToLocation extends Goal {
        public final Calamity infected;
        public final double speed;
        public int tryTicks;

        public GoToLocation(Calamity infected1, double speed) {
            this.infected = infected1;
            this.speed = speed;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        protected void moveMobToBlock() {
            this.infected.getNavigation().moveTo((double) ((float) this.infected.getSearchArea().getX()) + 0.5D, (double) (this.infected.getSearchArea().getY() + 1), (double) ((float) this.infected.getSearchArea().getZ()) + 0.5D, 1);
        }

        @Override
        public boolean canUse() {
            if (this.infected.getSearchArea() != BlockPos.ZERO && this.infected.getSearchArea() != null && infected.getTarget() == null) {
                return this.infected.getSearchArea().distToCenterSqr(this.infected.position()) > 4.0;
            }
            return false;
        }

        @Override
        public void start() {
            this.moveMobToBlock();
            this.tryTicks = 0;
            super.start();
        }

        @Override
        public boolean canContinueToUse() {
            return infected.getTarget() == null;
        }


        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            if (this.infected.getSearchArea() != BlockPos.ZERO && shouldRecalculatePath()) {
                this.infected.getNavigation().moveTo(this.infected.getSearchArea().getX(), this.infected.getSearchArea().getY(), this.infected.getSearchArea().getZ(), 1);
            }
            if (this.infected.getSearchArea() != BlockPos.ZERO && this.infected.getSearchArea().distToCenterSqr(this.infected.position()) < 20.0) {
                infected.setSearchArea(BlockPos.ZERO);
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
    public void die(DamageSource source) {

        if (this.level() instanceof ServerLevel serverLevel){
            double x0 = this.getX() - (random.nextFloat() - 0.1) * 1.2D;
            double y0 = this.getY() + (random.nextFloat() - 0.25) * 1.25D * 5;
            double z0 = this.getZ() + (random.nextFloat() - 0.1) * 1.2D;
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER, x0, y0, z0, 4, 0, 0, 0, 1);
        }

        this.discard();
        AABB aabb = this.getBoundingBox().inflate(2.5);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockState = level().getBlockState(blockpos);
            BlockState above = level().getBlockState(blockpos.above());
            if (!level().isClientSide() && blockState.isSolidRender(level(), blockpos) && !above.isSolidRender(level(), blockpos)) {
                if (Math.random() < 0.9) {
                    if (Math.random() < 0.7) {
                        level().setBlock(blockpos.above(), Sblocks.MYCELIUM_VEINS.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.1) {
                        level().setBlock(blockpos.above(), Sblocks.BIOMASS_BLOCK.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.1) {
                        level().setBlock(blockpos.above(), Sblocks.ROOTED_BIOMASS.get().defaultBlockState(), 2);
                    }
                    if (Math.random() < 0.1) {
                        level().setBlock(blockpos.above(), Sblocks.REMAINS.get().defaultBlockState(), 2);
                    }
                }
            }
        }
        super.die(source);
    }

}