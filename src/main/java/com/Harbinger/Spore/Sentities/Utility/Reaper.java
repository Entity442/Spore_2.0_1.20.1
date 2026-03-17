package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import com.Harbinger.Spore.Sentities.Projectile.VomitUsurperBall;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
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
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Reaper extends UtilityEntity implements Enemy, ArmorPersentageBypass, RangedAttackMob {
    public static final List<BlockState> states = new ArrayList<>(){{add(Blocks.HAY_BLOCK.defaultBlockState());add(Blocks.SUGAR_CANE.defaultBlockState());add(Blocks.PUMPKIN.defaultBlockState());add(Blocks.CARVED_PUMPKIN.defaultBlockState());add(Blocks.MELON.defaultBlockState());add(Blocks.SWEET_BERRY_BUSH.defaultBlockState());}};
    private int attackAnimationTick;
    private int rangedAttackAnimationTick;
    @Nullable
    private BlockPos Targetpos;
    public static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(Reaper.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STOMACH = SynchedEntityData.defineId(Reaper.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Boolean> COMPOSTER = SynchedEntityData.defineId(Reaper.class, EntityDataSerializers.BOOLEAN);
    public Reaper(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new HybridPathNavigation(this,this.level());
        setMaxUpStep(1);
    }
    public void travel(Vec3 vec) {
        if (this.isEffectiveAi() && this.isInFluidType()) {
            this.moveRelative(0.1F, vec);
            this.move(MoverType.SELF, this.getDeltaMovement());
            Vec3 vec3 = this.moveControl.getWantedY() > this.getY() ? new Vec3(0,0.01,0) : new Vec3(0,-0.01,0);
            this.setDeltaMovement(this.getDeltaMovement().scale(0.75D).add(vec3));
            if (this.navigation.canFloat() && this.getRandom().nextFloat() < 0.4F){
                this.getJumpControl().jump();
            }
        } else {
            super.travel(vec);
        }
    }

    @Override
    public boolean removeWhenFarAway(double value) {
        if (this.level() instanceof ServerLevel serverLevel){
            SporeSavedData data = SporeSavedData.getDataLocation(serverLevel);
            return data != null && data.getAmountOfHiveminds() >= SConfig.SERVER.proto_spawn_world_mod.get() && value > 256;
        }
        return false;
    }
    @Override
    protected int calculateFallDamage(float p_21237_, float p_21238_) {
        return super.calculateFallDamage(p_21237_, p_21238_) - 15;
    }
    public int getAttackAnimationTick(){
        return attackAnimationTick;
    }
    public int getRangedAttackAnimationTick(){return rangedAttackAnimationTick;}
    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(3, new AOEMeleeAttackGoal(this ,1.25,true, 1.2 ,5, livingEntity -> {return TARGET_SELECTOR.test(livingEntity);}));
        this.goalSelector.addGoal(4,new SearchAroundGoal(this));
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.POISON,200,0));
            living.addEffect(new MobEffectInstance(MobEffects.CONFUSION,200,0));
            living.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),200,1));
        }
        playSound(Ssounds.REAPER_ATTACK.get());
        this.attackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(entity);
    }
    public void handleEntityEvent(byte value) {
        if (value == 4) {
            this.attackAnimationTick = 10;
        }else if (value == 5) {
            this.rangedAttackAnimationTick = 10;
        }else {
            super.handleEntityEvent(value);
        }
    }
    @Override
    public float amountOfDamage(float value) {
        return (float) ((SConfig.SERVER.reaper_damage.get() * SConfig.SERVER.global_damage.get())/4f);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.IN_FIRE)){
            amount = amount/2;
        }
        return super.hurt(source, amount);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.reaper_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.reaper_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.reaper_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 2);

    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.reaper_loot.get();
    }

    private void buffAI(){
        if (this.getHealth() < this.getMaxHealth() && !hasEffect(MobEffects.REGENERATION)){
            addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,this.getHealth() < this.getMaxHealth()/2 ? 1:0));
            this.setBiomass(this.getBiomass()-1);
        }
    }
    public void setBiomass(int value){
        entityData.set(BIOMASS,value);
    }
    public int getBiomass(){
        return entityData.get(BIOMASS);
    }
    public void setStomach(int value){
        entityData.set(STOMACH,value);
    }
    public int getStomach(){
        return entityData.get(STOMACH);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(STOMACH,0);
        entityData.define(BIOMASS,0);
        entityData.define(COMPOSTER,false);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setBiomass(tag.getInt("biomass"));
        setStomach(tag.getInt("stomach"));
        setComposter(tag.getBoolean("composter"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("biomass",getBiomass());
        tag.putInt("stomach",getStomach());
        tag.putBoolean("composter",getComposter());
    }
    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
    public void setComposter(boolean value){
        entityData.set(COMPOSTER,value);
    }
    public boolean getComposter(){
        return entityData.get(COMPOSTER);
    }
    private boolean searchComposter(BlockState block){
        return !getComposter() && block.getBlock().equals(Blocks.COMPOSTER);
    }
    @Override
    public void awardKillScore(Entity p_19953_, int p_19954_, DamageSource p_19955_) {
        this.setBiomass(this.getBiomass()+1);
        super.awardKillScore(p_19953_, p_19954_, p_19955_);
    }
    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        float value = blockstate.getDestroySpeed(this.level(),blockpos);
        return this.tickCount % 20 == 0 && value > 0 && value <=getBreaking();
    }
    public int getBreaking(){
        return SConfig.SERVER.hyper_bd.get();
    }

    public boolean hasLineOfSightBlocks(BlockPos pos) {
        BlockHitResult raytraceresult = this.level().clip(new ClipContext(this.getEyePosition(1.0F), new Vec3(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, this));
        BlockPos position = raytraceresult.getBlockPos();
        return pos.equals(position) || this.level().isEmptyBlock(pos) || this.level().getBlockEntity(pos) == this.level().getBlockEntity(position);
    }
    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState block = level().getBlockState(blockpos);
            if (states.contains(block) || block.getBlock() instanceof CropBlock || block.getBlock() instanceof StemBlock || block.getBlock() instanceof SaplingBlock || searchComposter(block)){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
    }
    @Nullable
    public BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }
    @Override
    public void tick() {
        super.tick();
        if (tickCount % 200 == 0){
            searchBlocks();
            if (getStomach() > 25f){
                int val = getComposter() ? 2 : 5;
                setBiomass(getBiomass()+1);
                setStomach(getStomach()-val);
                if (getComposter()){
                    playSound(Ssounds.REAPER_COMPOST.get());
                }
            }
            if (getBiomass() > 10){
                FeedNearbyInfected();
            }
        }
        if (tickCount % 100 == 0 && getStomach() > 0){
            LivingEntity living = this.getTarget();
            if (living != null && hasLineOfSight(living)){
                performRangedAttack(living,0);
            }
        }
        if (attackAnimationTick > 0){
            attackAnimationTick--;
        }
        if (rangedAttackAnimationTick > 0){
            rangedAttackAnimationTick--;
        }
        if (tickCount % 20 == 0 && getBiomass() > 0){
            this.buffAI();
        }
        if (tickCount % 40 == 0 && horizontalCollision && net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this)){
            griefBlocks(this.getTarget());
        }

    }
    private void griefBlocks(LivingEntity livingEntity){
        AABB aabb = (livingEntity != null && livingEntity.getY() > this.getY()) ? this.getBoundingBox().inflate(-0.2D,0.5D,-0.2D).move(0,0.5,0) : this.getBoundingBox().inflate(0.5D).move(0,0.5,0);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockBreakingParameter(blockstate,blockpos)) {
                interactBlock(blockpos,this.level());
            }
        }
    }
    public void FeedNearbyInfected(){
        AABB aabb = this.getBoundingBox().inflate(getComposter() ? 24 : 16);
        List<Infected> entities = level().getEntitiesOfClass(Infected.class,aabb);
        for (Infected infected : entities){
            if (infected.getEvoPoints() < SConfig.SERVER.min_kills.get() && infected instanceof EvolvingInfected && !(infected instanceof EvolvedInfected)){
                int charge = SConfig.SERVER.min_kills.get() - infected.getEvoPoints();
                infected.setEvoPoints(infected.getEvoPoints() + charge);
                infected.setKills(infected.getKills() + charge);
                infected.addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,0));
                this.setBiomass(getBiomass()-charge);
                break;
            }
        }
    }
    public boolean interactBlock(BlockPos blockPos, Level level) {
        BlockState state = level.getBlockState(blockPos);
        if (state.is(Utilities.biomass)){
            return level.setBlock(blockPos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3);
        }
        return level.destroyBlock(blockPos, false, this);
    }
    public boolean interractWithBlock(BlockPos blockPos,Level level){
        BlockState state = level.getBlockState(blockPos);
        if ((state.getBlock() instanceof CropBlock || state.getBlock() instanceof StemBlock) && Math.random() < 0.3){
            return level.setBlock(blockPos, Sblocks.ROTTEN_CROPS.get().defaultBlockState(), 3);
        }
        if ((state.getBlock() instanceof SaplingBlock || state.getBlock() instanceof SweetBerryBushBlock) && Math.random() < 0.3){
            return level.setBlock(blockPos, Sblocks.ROTTEN_BUSH.get().defaultBlockState(), 3);
        }
        int compostMod = getComposter() ? 8 : 4;
        this.setStomach(getStomach() + random.nextInt(compostMod));
        this.attackAnimationTick = 10;
        if (state.getBlock().equals(Blocks.COMPOSTER)){
            playSound(SoundEvents.WOOD_BREAK);
            setComposter(true);
        }else {
            if (Math.random() < 0.2){
                this.playSound(SoundEvents.GENERIC_EAT);
            }else {
                playSound(Ssounds.REAPER_HARVEST.get());
            }
        }
        this.level().broadcastEntityEvent(this, (byte)4);
        return level.destroyBlock(blockPos, false, this);
    }
    protected SoundEvent getAmbientSound() {
        return isInvisible() ? null : Ssounds.REAPER_AMBIENT.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.EVOLVE_HURT.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }
    @Override
    public void performRangedAttack(LivingEntity livingEntity, float v) {
        VomitUsurperBall.shoot(this,livingEntity,(float) (SConfig.SERVER.reaper_ranged_damage.get() * SConfig.SERVER.global_damage.get()));
        this.setStomach(getStomach()-1);
        this.rangedAttackAnimationTick = 10;
        this.level().broadcastEntityEvent(this, (byte)5);
        playSound(Ssounds.REAPER_SPIT.get());
    }

    public static class SearchAroundGoal extends Goal {
        private final Reaper specter;
        public int tryTicks;

        public SearchAroundGoal(Reaper specter){
            this.specter = specter;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return specter.getTargetPos() != null && this.specter.getTarget() == null;
        }

        protected void moveToBlock(BlockPos pos){
            if (pos != null)
                specter.navigation.moveTo(pos.getX()+0.5D,pos.getY()+1D,pos.getZ()+0.5D,1);
        }
        @Override
        public void start() {
            this.moveToBlock(specter.getTargetPos());
            this.tryTicks = 0;
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            specter.navigation.stop();
        }

        @Override
        public boolean canContinueToUse() {
            return specter.getTarget() == null && specter.getTargetPos() != null ;
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            super.tick();
            ++this.tryTicks;
            BlockPos pos = specter.getTargetPos();
            if (pos != null && shouldRecalculatePath()){
                moveToBlock(pos);
            }
            if (pos != null && pos.closerToCenterThan(this.specter.position(),3.5f)){
                specter.interractWithBlock(pos,specter.level());
                specter.setTargetPos((BlockPos) null);
                specter.searchBlocks();
                specter.navigation.stop();
            }
        }
    }
}
