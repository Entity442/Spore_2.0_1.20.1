package com.Harbinger.Spore.Sentities.Experiments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import com.Harbinger.Spore.Sentities.MovementControls.InfectedWallMovementControl;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;
import java.util.List;

public class Saugling extends Experiment {
    public static final EntityDataAccessor<Boolean> IS_HIDDEN = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<BlockPos> CHEST_POS = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BLOCK_POS);
    public static final EntityDataAccessor<Boolean> PRIMED = SynchedEntityData.defineId(Saugling.class, EntityDataSerializers.BOOLEAN);
    private int setTicksOut = 0;
    public Saugling(EntityType<? extends Monster> type, Level level) {
        super(type, level);
        this.navigation = new WallClimberNavigation(this,level);
        this.moveControl = new InfectedWallMovementControl(this);
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
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.saugling_loot.get();
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
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.sau_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.sau_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.sau_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    public int getSetTicksOut() {
        return setTicksOut;
    }

    public void setSetTicksOut(int setTicksOut) {
        this.setTicksOut = setTicksOut;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new HideInChestGoal(this));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this,0.4F));
        this.goalSelector.addGoal(4, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 2.0 + entity.getBbWidth() * entity.getBbWidth();}
        });
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.8));
    }

    @Override
    public boolean isNoAi() {
        return isHidden();
    }

    private void leapAtTarget(LivingEntity target){
        Vec3 $$0 = this.getDeltaMovement();
        Vec3 $$1 = new Vec3(target.getX() - this.getX(), target.getY() - this.getY(), getZ() - this.getZ());
        if ($$1.lengthSqr() > 1.0E-7) {
            $$1 = $$1.normalize().scale(0.4).add($$0.scale(0.2));
        }
        this.setDeltaMovement($$1.x, $$1.y, $$1.z);
    }
    private BlockPos findNearbyChest() {
        BlockPos mobPos = this.blockPosition();
        for (BlockPos pos : BlockPos.betweenClosed(mobPos.offset(-8, -2, -8), mobPos.offset(8, 2, 8))) {
            if (this.level().getBlockState(pos).is(Blocks.CHEST)) {
                return pos.immutable();
            }
        }
        return BlockPos.ZERO;
    }
    @Override
    public void aiStep() {
        super.aiStep();
        if (tickCount % 60 == 0){
            setChestPos(findNearbyChest());
        }
        if (setTicksOut > 0){
            --setTicksOut;
        }
        if (isHidden() && tickCount % 20 == 0) {
            if (!isPrimed()) {
                AABB aabb = this.getBoundingBox().inflate(3);
                List<LivingEntity> livingEntities = this.level().getEntitiesOfClass(LivingEntity.class, aabb,
                        entity -> entity.isAlive() && TARGET_SELECTOR.test(entity) && !(entity instanceof Player player && player.getAbilities().instabuild));

                if (!livingEntities.isEmpty()) {
                    setPrimed(true);
                    this.setTarget(livingEntities.get(random.nextInt(livingEntities.size())));
                }
            } else {
                setIsHidden(false);
                setPrimed(false);
                openChest(getChestPos());
                setSetTicksOut(100);
                LivingEntity target = this.getTarget();
                if (target != null){
                    leapAtTarget(target);
                }
            }
        }
    }
    public static class HideInChestGoal extends Goal {
        private final Saugling mob;

        public HideInChestGoal(Saugling mob) {
            this.mob = mob;
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
        }

        @Override
        public boolean canUse() {
            if (mob.isHidden() || mob.getTarget() != null) return false;
            return mob.getChestPos() != BlockPos.ZERO && mob.getSetTicksOut() <= 0;
        }

        @Override
        public void start() {
            if (mob.getChestPos() != null && mob.getChestPos() != BlockPos.ZERO) {
                mob.setChestPos(mob.getChestPos());
                mob.getNavigation().moveTo(mob.getChestPos().getX(), mob.getChestPos().getY(), mob.getChestPos().getZ(), 1.0);
            }

        }

        @Override
        public void tick() {
            if (mob.getChestPos() != null && mob.getChestPos() != BlockPos.ZERO) {
                if (mob.position().distanceToSqr(Vec3.atCenterOf(mob.getChestPos())) < 1.5) {
                    mob.hideInChest();
                }
            }
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

    @Override
    public boolean isDormant() {
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

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
}
