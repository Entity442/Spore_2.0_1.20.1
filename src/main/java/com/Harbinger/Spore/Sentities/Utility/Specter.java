package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.HybridPathNavigation;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Specter extends UtilityEntity implements Enemy {
    public static final EntityDataAccessor<Boolean> INVISIBLE = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> STOMACH = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.INT);
    public static final List<BlockState> states = new ArrayList<>(){{add(Blocks.TORCH.defaultBlockState());add(Blocks.REDSTONE_TORCH.defaultBlockState());add(Blocks.TNT.defaultBlockState());add(Sblocks.CDU.get().defaultBlockState());}};
    @Nullable
    private BlockPos Targetpos;
    public Specter(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new HybridPathNavigation(this,this.level());
        this.setMaxUpStep(1F);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.gastgaber_loot.get();
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
    public boolean dampensVibrations() {
        return isInvisible();
    }


    @Override
    public boolean canBeSeenByAnyone() {
        return !isInvisible();
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.specter_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.specter_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.specter_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 48)
                .add(Attributes.ATTACK_KNOCKBACK, 3);

    }

    private void buffAI(){
        if (this.getHealth() < this.getMaxHealth() && !hasEffect(MobEffects.REGENERATION)){
            addEffect(new MobEffectInstance(MobEffects.REGENERATION,400,this.getHealth() < this.getMaxHealth()/2 ? 1:0));
            this.setBiomass(this.getBiomass()-1);
        }if (this.isOnFire()&& !hasEffect(MobEffects.FIRE_RESISTANCE)){
            addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,200,0));
            this.setBiomass(this.getBiomass()-1);
        }
    }

    @Override
    protected void registerGoals() {
        addTargettingGoals();
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.2, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 4.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(4,new SearchAroundGoal(this));
        this.goalSelector.addGoal(5,new RandomStrollGoal(this,1));
        super.registerGoals();
    }

    public void setInvisible(boolean value){
        entityData.set(INVISIBLE,value);
    }
    public boolean isInvisible(){
        return entityData.get(INVISIBLE);
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
    @Nullable
    public BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(INVISIBLE,false);
        entityData.define(STOMACH,0);
        entityData.define(BIOMASS,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setInvisible(tag.getBoolean("invisible"));
        setBiomass(tag.getInt("biomass"));
        setStomach(tag.getInt("stomach"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("invisible",isInvisible());
        tag.putInt("biomass",getBiomass());
        tag.putInt("stomach",getStomach());
    }
    private boolean food(Container container){
        return container.hasAnyMatching((ItemStack::isEdible));
    }

    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState block = level().getBlockState(blockpos);
            BlockEntity blockEntity = this.level().getBlockEntity(blockpos);
            if (states.contains(block) || (blockEntity instanceof Container container && food(container))){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),200,1));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS,100,0));
        }
        return super.doHurtTarget(entity);
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
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

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 200 == 0){
            searchBlocks();
        if (getStomach() > 10f){
            setBiomass(getBiomass()+1);
            setStomach(getStomach()-10);
        }
        }
        if (tickCount % 20 == 0 && getBiomass() > 0){
            this.buffAI();
        }
        if (tickCount % 40 == 0 && horizontalCollision){
            griefBlocks(this.getTarget());
        }
    }

    @Override
    public void setTarget(@Nullable LivingEntity entity) {
        super.setTarget(entity);
        this.setInvisible(entity != null && entity.distanceToSqr(this) > 50D);
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

    protected SoundEvent getAmbientSound() {
        return isInvisible() ? null : Ssounds.SPECTER_AMBIENT.get();
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
    public boolean hasLineOfSight(Entity entity) {
        if (entity instanceof LivingEntity livingEntity && livingEntity.hasEffect(Seffects.MARKER.get())){
            return true;
        }
        if (entity instanceof InventoryCarrier carrier && carrier.getInventory().hasAnyMatching(ItemStack::isEdible)){
            return true;
        }
        return super.hasLineOfSight(entity);
    }

    public boolean interractWithBlock(BlockPos pos){
        if (level().getBlockEntity(pos) instanceof Container container && food(container)){
            for (int i = 0; i < container.getContainerSize();i++){
                ItemStack stack = container.getItem(i);
                FoodProperties properties = stack.getFoodProperties(this);
                if (stack.isEdible() && properties != null){
                    int amount = stack.getCount() > 1 ? this.random.nextInt(stack.getCount()) : stack.getCount();
                    this.playSound(SoundEvents.GENERIC_EAT);
                    stack.shrink(amount);
                    this.setStomach(this.getStomach()+(int)(properties.getNutrition() + properties.getSaturationModifier())*amount);
                }
            }
        }else{
            level().destroyBlock(pos,true,this);
        }
        return true;
    }

    @Override
    public boolean hurt(DamageSource source, float p_21017_) {
        if (source.getEntity() != null && random.nextFloat() < 0.1f){
            ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),level());
            scent.moveTo(this.getX(),this.getY(),this.getZ());
            level().addFreshEntity(scent);
        }
        return super.hurt(source, p_21017_);
    }

    @Override
    protected int calculateFallDamage(float p_21237_, float p_21238_) {
        return super.calculateFallDamage(p_21237_, p_21238_) - 15;
    }

    public static class SearchAroundGoal extends Goal{
        private final Specter specter;
        public int tryTicks;

        public SearchAroundGoal(Specter specter){
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
        public boolean canContinueToUse() {
            return specter.getTarget() == null;
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
                specter.interractWithBlock(pos);
                openChest(pos);
                specter.setTargetPos((BlockPos) null);
                specter.searchBlocks();
            }
        }
        public void openChest(BlockPos pos) {
            BlockEntity entity = this.specter.level().getBlockEntity(pos);
            if (entity instanceof ChestBlockEntity chestBlock) {
                this.specter.playSound(SoundEvents.CHEST_OPEN);
                this.specter.level().blockEvent(pos, chestBlock.getBlockState().getBlock(), 1, 1);
                this.specter.level().updateNeighborsAt(pos, chestBlock.getBlockState().getBlock());
                this.specter.level().updateNeighborsAt(pos.below(), chestBlock.getBlockState().getBlock());
            }
        }
    }

    protected List<BlockState> biomass(){
        List<BlockState> states = new ArrayList<>();
        states.add(Sblocks.BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.SICKEN_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.CALCIFIED_BIOMASS_BLOCK.get().defaultBlockState());
        states.add(Sblocks.MEMBRANE_BLOCK.get().defaultBlockState());
        states.add(Sblocks.ROOTED_BIOMASS.get().defaultBlockState());
        states.add(Sblocks.ROOTED_MYCELIUM.get().defaultBlockState());
        states.add(Sblocks.GASTRIC_BIOMASS.get().defaultBlockState());
        return states;
    }

    public boolean interactBlock(BlockPos blockPos, Level level) {
        BlockState state = level.getBlockState(blockPos);
        if (biomass().contains(state)){
            return level.setBlock(blockPos, Sblocks.MEMBRANE_BLOCK.get().defaultBlockState(), 3);
        }
        return level.destroyBlock(blockPos, false, this);
    }
}
