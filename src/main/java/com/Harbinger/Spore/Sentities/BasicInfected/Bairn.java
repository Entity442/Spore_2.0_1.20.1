package com.Harbinger.Spore.Sentities.BasicInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.*;
import com.Harbinger.Spore.Sentities.AI.LocHiv.BufferAI;
import com.Harbinger.Spore.Sentities.AI.LocHiv.FollowOthersGoal;
import com.Harbinger.Spore.Sentities.AI.LocHiv.LocalTargettingGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.MovementControls.WaterXlandMovement;
import com.Harbinger.Spore.Sentities.Utility.HyperClaw;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sentities.Variants.*;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;
import java.util.List;

public class Bairn extends Infected implements VariantKeeper {
    @Nullable
    private BlockPos Targetpos;
    public Bairn(EntityType<? extends Infected> type, Level level) {
        super(type, level);
        this.moveControl = new WaterXlandMovement(this);
        this.navigation = new HybridPathNavigation(this,this.level());
    }
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(Bairn.class, EntityDataSerializers.INT);

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(2,new SearchAroundGoal(this));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 1.5 + entity.getBbWidth() * entity.getBbWidth();
            }
        });
        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    protected void addRegularGoals() {
        this.goalSelector.addGoal(3,new LocalTargettingGoal(this));
        this.goalSelector.addGoal(4 , new BufferAI(this ));
        this.goalSelector.addGoal(3, new OpenDoorGoal(this, true) {
            @Override
            public boolean canUse() {
                return super.canUse() && getVariant() == BairnSkins.VILLAGER;
            }
            @Override
            public void start() {
                this.mob.swing(InteractionHand.MAIN_HAND);
                super.start();
            }
        });
        this.goalSelector.addGoal(5,new FollowOthersGoal(this, HyperClaw.class, entity ->{
            return getVehicle() == null;
        }){
            @Override
            public boolean canUse() {
                return getVehicle() == null && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                LivingEntity living = getFollowPartner();
                return living != null && living.distanceTo(Bairn.this) > 36;
            }

            @Override
            public void stop() {
                super.stop();
                LivingEntity living = getFollowPartner();
                if (living != null){
                    Bairn.this.startRiding(living);
                }
            }
        });
        this.goalSelector.addGoal(5 , new InfectedPanicGoal(this , 1.5));
        this.goalSelector.addGoal(6,new FloatDiveGoal(this){
            @Override
            public boolean canUse() {
                return super.canUse() && getVariant() != BairnSkins.DROWNED;
            }
        });
        this.goalSelector.addGoal(7, new InfectedConsumeFromRemains(this));
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return getVariant() != BairnSkins.DROWNED && super.canDrownInFluidType(type);
    }

    public void travel(Vec3 input) {
        if (this.isEffectiveAi() && this.isInFluidType() && this.getVariant() == BairnSkins.DROWNED) {
            this.moveRelative(0.1F, input);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale( 0.85D));
        } else {
            super.travel(input);
        }
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DATA_ID_TYPE_VARIANT, 0);
    }
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.bairn_loot.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.bairn_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.22)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.bairn_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.bairn_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 0.3);

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

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    private void setVariant(BairnSkins variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    public BairnSkins getVariant() {
        return BairnSkins.byId(this.getTypeVariant() & 255);
    }
    @Override
    public int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void setVariant(int i) {
        this.entityData.set(DATA_ID_TYPE_VARIANT,i > BairnSkins.values().length || i < 0 ? 0 : i);
    }
    @Override
    public int amountOfMutations() {
        return BairnSkins.values().length;
    }
    @Nullable
    public BlockPos getTargetPos() {
        return Targetpos;
    }
    public void setTargetPos(@Nullable BlockPos pos) {
        this.Targetpos = pos;
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_21435_, MobSpawnType p_21436_, @Nullable SpawnGroupData p_21437_, @Nullable CompoundTag p_21438_) {
        BairnSkins variant = Util.getRandom(BairnSkins.values(), this.random);
        this.setVariant(variant);
        return super.finalizeSpawn(serverLevelAccessor, p_21435_, p_21436_, p_21437_, p_21438_);
    }

    public static class SearchAroundGoal extends Goal {
        private final Bairn specter;
        public int tryTicks;

        public SearchAroundGoal(Bairn specter){
            this.specter = specter;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            return specter.getTargetPos() != null && this.specter.getTarget() == null;
        }

        protected void moveToBlock(BlockPos pos){
            Path path = specter.navigation.createPath(pos, 1);
            if (path != null){
                specter.getNavigation().moveTo(path, 1);
            }
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
                specter.setTargetPos(null);
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
    public void searchBlocks(){
        AABB aabb = this.getBoundingBox().inflate(20,4,20);
        for(BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockEntity blockEntity = this.level().getBlockEntity(blockpos);
            if (blockEntity instanceof Container container && food(container)){
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
    private boolean food(Container container){
        return container.hasAnyMatching(item -> (
                item.getFoodProperties(this) != null
        ));
    }
    public boolean interractWithBlock(BlockPos pos){
        if (level().getBlockEntity(pos) instanceof Container container && food(container)){
            for (int i = 0; i < container.getContainerSize();i++){
                ItemStack stack = container.getItem(i);
                FoodProperties properties = stack.getFoodProperties(this);
                if (properties != null){
                    int amount = stack.getCount() > 1 ? this.random.nextInt(stack.getCount()) : stack.getCount();
                    this.playSound(SoundEvents.GENERIC_EAT);
                    stack.shrink(amount);
                    this.setKills(this.getKills()+(int)(properties.getNutrition() + properties.getSaturationModifier())*amount);
                }
            }
        }else{
            level().destroyBlock(pos,true,this);
        }
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (tickCount % 100 == 0){
            searchBlocks();
        }
    }
}
