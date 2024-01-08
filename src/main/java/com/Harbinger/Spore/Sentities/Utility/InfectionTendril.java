package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.SBlockEntities.BiomassLumpEntity;
import com.Harbinger.Spore.SBlockEntities.HiveSpawnBlockEntity;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class InfectionTendril extends UtilityEntity {
    private static final EntityDataAccessor<BlockPos> SEARCH_AREA = SynchedEntityData.defineId(InfectionTendril.class, EntityDataSerializers.BLOCK_POS);
    private static final EntityDataAccessor<Integer> LIFE = SynchedEntityData.defineId(InfectionTendril.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> MOUND_AGE = SynchedEntityData.defineId(InfectionTendril.class, EntityDataSerializers.INT);
    public InfectionTendril(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
        setPersistenceRequired();
        this.moveControl = new InfectedWallMovementControl(this);
        this.navigation = new WallClimberNavigation(this,level);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    public int getLife() {
        return this.entityData.get(LIFE);
    }

    public void setLife(int s) {
        this.entityData.set(LIFE, s);
    }

    public int getAgeM() {
        return this.entityData.get(MOUND_AGE);
    }

    public void setAgeM(int s) {
        this.entityData.set(MOUND_AGE, s);
    }


    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(MOUND_AGE,2);
        this.entityData.define(LIFE, 4800);
        this.entityData.define(SEARCH_AREA,BlockPos.ZERO);
    }



    public void setSearchArea(BlockPos blockPos) {
        this.entityData.set(SEARCH_AREA, blockPos);
    }

    BlockPos getSearchArea() {
        return this.entityData.get(SEARCH_AREA);
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putInt("mound_age", this.getAgeM());
        tag.putInt("life", this.getLife());
        tag.putInt("AreaX", this.getSearchArea().getX());
        tag.putInt("AreaY", this.getSearchArea().getY());
        tag.putInt("AreaZ", this.getSearchArea().getZ());
        super.addAdditionalSaveData(tag);
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        this.setAgeM(tag.getInt("mound_age"));
        this.setLife(tag.getInt("life"));
        int i = tag.getInt("AreaX");
        int j = tag.getInt("AreaY");
        int k = tag.getInt("AreaZ");
        this.setSearchArea(new BlockPos(i, j, k));
        super.readAdditionalSaveData(tag);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2,new GoToArea(this));
        super.registerGoals();
    }

    static class GoToArea extends Goal {
        InfectionTendril tendril;
        public  int tryTicks;
        public GoToArea(InfectionTendril t){
            this.tendril = t;
        }
        @Override
        public boolean canUse() {
            return this.tendril.getSearchArea() != null;
        }


        protected void moveMobToBlock() {
            this.tendril.getNavigation().moveTo((double)((float)this.tendril.getSearchArea().getX()) + 0.5D, (double)(this.tendril.getSearchArea().getY() + 1), (double)((float)this.tendril.getSearchArea().getZ()) + 0.5D, 1);
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
            if (this.tendril.getSearchArea() != null && shouldRecalculatePath()){
                this.tendril.getNavigation().moveTo(this.tendril.getSearchArea().getX(),this.tendril.getSearchArea().getY(),this.tendril.getSearchArea().getZ(),1);
            }
        }


        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        public boolean shouldRecalculatePath() {
            return this.tryTicks % 40 == 0;
        }
    }


    public void travel(Vec3 p_32858_) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.1F, p_32858_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement());
        } else {
            super.travel(p_32858_);
        }

    }

    @Override
    public boolean isInvulnerable() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive() && this.entityData.get(LIFE)>0){
            this.entityData.set(LIFE, this.entityData.get(LIFE) - 1);
        }
        if (this.getSearchArea() != BlockPos.ZERO && this.random.nextInt(40) == 0){
                if ((Math.abs(this.getSearchArea().getX())  - Math.abs(this.getX()) < 6) && (Math.abs(this.getSearchArea().getZ())  - Math.abs(this.getZ()) < 6)){
                  teleport();
                }
                if (!this.onGround() && this.horizontalCollision && this.verticalCollision){
                    teleportAround();
                }
        }
    }

    @Override
    public void aiStep() {
        if (entityData.get(LIFE) == 0){
            this.discard();
        }
        if (this.random.nextInt(0,10) == 0){
        Spread(this,this.level(),0.3);
        }
        super.aiStep();
    }


    @Override
    public boolean hurt(DamageSource source, float amount) {
        return false;
    }

    protected boolean teleport() {
        if (!this.level().isClientSide() && this.isAlive()) {
            double d0 = this.getSearchArea().getX() + (double)(this.random.nextInt(8));
            double d1 = this.getSearchArea().getY();
            double d2 = this.getSearchArea().getZ() + (double)(this.random.nextInt(8));
            this.Spread(this,this.level(),1.2);
            return this.randomTeleport(d0, d1, d2,false);
        } else {
            return false;
        }
    }

    private void teleportAround(){
        if (!this.level().isClientSide && this.isAlive()){
            int x = (int) Math.abs(Math.abs(this.getSearchArea().getX()) + Math.abs(this.getX()));
            int z = (int) Math.abs(Math.abs(this.getSearchArea().getZ()) + Math.abs(this.getZ()));
            int randomX = this.random.nextInt(-x,x);
            int randomZ = this.random.nextInt(-z,z);
            this.Spread(this,this.level(),1.2);
            this.randomTeleport(randomX, this.getSearchArea().getY(), randomZ,false);
        }
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.15);

    }

    private void Spread(Entity entity , Level level,double value){
        AABB aabb = entity.getBoundingBox().inflate(value);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState nord = level.getBlockState(blockpos.north());
            BlockState south = level.getBlockState(blockpos.south());
            BlockState west = level.getBlockState(blockpos.west());
            BlockState east = level.getBlockState(blockpos.east());
            BlockState above = level.getBlockState(blockpos.above());
            BlockState below = level.getBlockState(blockpos.below());
            boolean nordT = !nord.isSolidRender(level,blockpos.north());
            boolean southT = !south.isSolidRender(level,blockpos.south());
            boolean westT = !west.isSolidRender(level,blockpos.west());
            boolean eastT = !east.isSolidRender(level,blockpos.east());
            boolean aboveT = !above.isSolidRender(level,blockpos.above());
            boolean belowT = !below.isSolidRender(level,blockpos.below());

            BlockState blockstate = level.getBlockState(blockpos);

            if (Math.random() < 0.02 && blockstate.isSolidRender(level,blockpos)
                    && (nordT || southT || westT || eastT || aboveT || belowT)){
                for (String str : SConfig.DATAGEN.block_infection.get()){
                    String[] string = str.split("\\|" );
                    ItemStack stack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0])));
                    if (stack != ItemStack.EMPTY && blockstate.getBlock().asItem() == stack.getItem()){
                        ItemStack itemStack = new ItemStack(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1])));
                        if (itemStack != ItemStack.EMPTY && itemStack.getItem() instanceof BlockItem blockItem){
                            level.setBlock(blockpos,blockItem.getBlock().defaultBlockState(),3);
                        }
                    }
                }
            }
            if (above.isAir() && blockstate.isSolidRender(level ,blockpos) && Math.random() < 0.1){level.setBlock(blockpos.above(),Sblocks.MYCELIUM_VEINS.get().defaultBlockState(),3);}
            BlockEntity blockEntity = this.level().getBlockEntity(blockpos);
            if (blockstate.is(Sblocks.REMAINS.get())){
                Mound mound = new Mound(Sentities.MOUND.get(),level);
                mound.setMaxAge(this.getAgeM());
                mound.tickEmerging();
                mound.setPos(blockpos.getX() + 0.5,blockpos.getY(),blockpos.getZ() + 0.5);
                level.addFreshEntity(mound);
                level.removeBlock(blockpos,false);
                this.discard();
            }else if (blockEntity instanceof Container container && isChestWithFood(container)){
                this.eatTheFood(container);
                Mound mound = new Mound(Sentities.MOUND.get(),level);
                mound.setMaxAge(1);
                mound.tickEmerging();
                mound.setPos(blockpos.getX() + 0.5,blockpos.getY()+1,blockpos.getZ() + 0.5);
                level.addFreshEntity(mound);
                level.removeBlock(blockpos.above(),false);
                this.discard();
            }else if (blockstate.is(Sblocks.HIVE_SPAWN.get()) || blockstate.is(Sblocks.BIOMASS_LUMP.get()) ){
                if (blockEntity instanceof HiveSpawnBlockEntity || blockEntity instanceof BiomassLumpEntity){
                    blockEntity.getPersistentData().putInt("kills",blockEntity.getPersistentData().getInt("kills") + SConfig.SERVER.mound_tendril_feed.get());
                    this.discard();
                }
            }
        }
    }
    public boolean addEffect(MobEffectInstance p_182397_, @Nullable Entity p_182398_) {
        return false;
    }

    private boolean isChestWithFood(Container container){
        return container.hasAnyMatching((ItemStack::isEdible));
    }

    private void eatTheFood(Container container){
        for(int i = 0;i<container.getContainerSize();i++){
            ItemStack stack = container.getItem(i);
            if (stack.isEdible()){
                stack.setCount(0);
            }
        }
    }
}
