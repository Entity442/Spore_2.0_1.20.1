package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.ExtremelySusThings.SporeSavedData;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class Specter extends UtilityEntity implements Enemy {
    public static final EntityDataAccessor<Boolean> ON_CEILING = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> INVISIBLE = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> BIOMASS = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Float> STOMACH = SynchedEntityData.defineId(Specter.class, EntityDataSerializers.FLOAT);
    @Nullable
    private BlockPos Targetpos;
    public Specter(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
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



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.gastgeber_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.gastgeber_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.gastgeber_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 20)
                .add(Attributes.ATTACK_KNOCKBACK, 3);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2,new SearchAroundGoal(this));
        this.goalSelector.addGoal(3,new RandomStrollGoal(this,1));
        super.registerGoals();
    }


    public void setOnCeiling(boolean value){
        entityData.set(ON_CEILING,value);
    }
    public boolean isOnCeiling(){
        return entityData.get(ON_CEILING);
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
    public void setStomach(float value){
        entityData.set(STOMACH,value);
    }
    public float getStomach(){
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
        entityData.define(ON_CEILING,false);
        entityData.define(INVISIBLE,false);
        entityData.define(STOMACH,0f);
        entityData.define(BIOMASS,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setInvisible(tag.getBoolean("invisible"));
        setOnCeiling(tag.getBoolean("ceiling"));
        setBiomass(tag.getInt("biomass"));
        setStomach(tag.getFloat("food"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("invisible",isInvisible());
        tag.putBoolean("ceiling",isOnCeiling());
        tag.putInt("biomass",getBiomass());
        tag.putFloat("food",getStomach());
    }
    private List<Block> targetBlocks(){
        return new ArrayList<>(){{add(Blocks.TORCH);add(Blocks.REDSTONE_TORCH);add(Blocks.LANTERN);}};
    }
    private boolean food(Container container){
        return container.hasAnyMatching((ItemStack::isEdible));
    }

    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(32,4,32);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            Block block = level().getBlockState(blockpos).getBlock();
            BlockEntity blockEntity = this.level().getBlockEntity(blockpos);
            if (targetBlocks().contains(block) || (blockEntity instanceof Container container && food(container))){
                if (hasLineOfSightBlocks(blockpos) && this.random.nextFloat() < 0.5f){
                    setTargetPos(blockpos);
                    break;
                }
            }
        }
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
            setStomach(getStomach()-10f);
        }
        }
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        return super.hasLineOfSight(entity);
    }

    public boolean interractWithBlock(BlockPos pos){
        if (level().getBlockEntity(pos) instanceof Container container && food(container)){
            for (int i = 0; i < container.getContainerSize();i++){
                ItemStack stack = container.getItem(i);
                FoodProperties properties = stack.getFoodProperties(this);
                if (stack.isEdible() && properties != null){
                    this.setStomach(this.getStomach()+properties.getNutrition() + properties.getSaturationModifier());
                    this.playSound(SoundEvents.GENERIC_EAT);
                    if (stack.getCount() > 1){
                        stack.shrink(this.random.nextInt(stack.getCount()));
                    }else{
                        stack.shrink(stack.getCount());
                    }
                }
            }
        }else{
            level().destroyBlock(pos,true,this);
        }
        return true;
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
                specter.searchBlocks();
                openChest(pos);
                specter.setTargetPos((BlockPos) null);
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
}
