package com.Harbinger.Spore.Sentities.Experiments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class Saugling extends Experiment {
    public static final EntityDataAccessor<Boolean> IS_HIDDEN = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<BlockPos> CHEST_POS = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<Boolean> PRIMED = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BOOLEAN);
    public Saugling(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public boolean isHidden(){
        return entityData.get(IS_HIDDEN);
    }
    public void setIsHidden(boolean val){
        entityData.set(IS_HIDDEN,val);
    }
    public boolean isPrimed(){
        return entityData.get(PRIMED);
    }
    public void setPrimed(boolean val){
        entityData.set(PRIMED,val);
    }
    public BlockPos getChestPos(){
        return entityData.get(CHEST_POS);
    }
    public void setChestPos(BlockPos val){
        entityData.set(CHEST_POS,val);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (isHidden()){
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_HIDDEN, false);
        this.entityData.define(CHEST_POS, BlockPos.ZERO);
        this.entityData.define(PRIMED, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("hidden",entityData.get(IS_HIDDEN));
        tag.putBoolean("primed",entityData.get(PRIMED));
        tag.putInt("chestPosX",entityData.get(CHEST_POS).getX());
        tag.putInt("chestPosY",entityData.get(CHEST_POS).getY());
        tag.putInt("chestPosZ",entityData.get(CHEST_POS).getZ());
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(IS_HIDDEN, tag.getBoolean("hidden"));
        entityData.set(PRIMED, tag.getBoolean("primed"));
        int x = tag.getInt("chestPosX");
        int y = tag.getInt("chestPosY");
        int z = tag.getInt("chestPosZ");
        entityData.set(CHEST_POS,new BlockPos(x,y,z));
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
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2.0 + entity.getBbWidth() * entity.getBbWidth();}
        });
        this.goalSelector.addGoal(3, new HideInChestGoal(this));
    }

    @Override
    public boolean isNoAi() {
        return super.isNoAi() || isHidden();
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (isHidden() && tickCount % 20 == 0) {
            if (!isPrimed()) {
                AABB aabb = this.getBoundingBox().inflate(3);
                boolean playerNearby = !this.level().getEntitiesOfClass(LivingEntity.class, aabb,
                        entity -> entity.isAlive() && entity instanceof Player player && !player.getAbilities().instabuild).isEmpty();

                if (playerNearby) {
                    setPrimed(true);
                }
            } else {
                setIsHidden(false);
                setPrimed(false);
                openChest(getChestPos());
            }
        }
    }
    public static class HideInChestGoal extends Goal {
        private final Saugling mob;
        private BlockPos targetChest;

        public HideInChestGoal(Saugling mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (mob.isHidden() || mob.getTarget() != null) return false;
            targetChest = findNearbyChest();
            return targetChest != null;
        }

        @Override
        public void start() {
            if (targetChest != null && targetChest != BlockPos.ZERO) {
                mob.setChestPos(targetChest);
                mob.getNavigation().moveTo(targetChest.getX(), targetChest.getY(), targetChest.getZ(), 1.0);
            }

        }

        @Override
        public void tick() {
            if (targetChest != null && targetChest != BlockPos.ZERO) {
                if (mob.position().distanceToSqr(Vec3.atCenterOf(targetChest)) < 1.5) {
                    mob.hideInChest();
                }
            }
        }

        private BlockPos findNearbyChest() {
            BlockPos mobPos = mob.blockPosition();
            for (BlockPos pos : BlockPos.betweenClosed(mobPos.offset(-8, -2, -8), mobPos.offset(8, 2, 8))) {
                if (mob.level().getBlockState(pos).is(Blocks.CHEST)) {
                    return pos.immutable();
                }
            }
            return BlockPos.ZERO;
        }

    }
    public void hideInChest() {
        setIsHidden(true);
        setPrimed(false);
        openChest(getChestPos());
        if (level().getBlockState(getChestPos().above()).isAir()){
            this.teleportTo(getChestPos().getX()+0.5,getChestPos().getY()+1,getChestPos().getZ()+0.5);
        }
    }
    public void openChest(BlockPos pos) {
        BlockEntity entity = this.level().getBlockEntity(pos);
        if (entity instanceof ChestBlockEntity chestBlock) {
            this.playSound(SoundEvents.CHEST_OPEN);
            this.level().blockEvent(pos, chestBlock.getBlockState().getBlock(), 1, 1);
            this.level().updateNeighborsAt(pos, chestBlock.getBlockState().getBlock());
            this.level().updateNeighborsAt(pos.below(), chestBlock.getBlockState().getBlock());
        }
    }
}
