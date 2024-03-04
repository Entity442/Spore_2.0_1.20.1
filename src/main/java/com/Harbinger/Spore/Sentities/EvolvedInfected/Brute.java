package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.TransportInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.Carrier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class Brute extends EvolvedInfected implements Carrier, RangedAttackMob {
    private static final EntityDataAccessor<Optional<BlockState>> DATA_CARRY_STATE = SynchedEntityData.defineId(Brute.class, EntityDataSerializers.OPTIONAL_BLOCK_STATE);
    public Brute(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_brute_loot.get();
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1,new TransportInfected<>(this,Mob.class, 1.1, entity -> {
            return SConfig.SERVER.ranged.get().contains(entity.getEncodeId());
        }));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this,1.3,80,48){
            @Override
            public boolean canUse() {
                return super.canUse() && Brute.this.getCarriedBlock() != null && Brute.this.getTarget() != null && Brute.this.distanceToSqr(Brute.this.getTarget()) > 400.0D;
            }
        });
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.3, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 3.0 + entity.getBbWidth() * entity.getBbWidth();
            }
        });

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        super.registerGoals();
    }
    public void setCarriedBlock(@Nullable BlockState state) {

        this.entityData.set(DATA_CARRY_STATE, Optional.ofNullable(state));
    }

    @Nullable
    public BlockState getCarriedBlock() {
        return this.entityData.get(DATA_CARRY_STATE).orElse((BlockState)null);
    }


    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        BlockState blockstate = this.getCarriedBlock();
        if (blockstate != null) {
            tag.put("carriedBlockState", NbtUtils.writeBlockState(blockstate));
        }
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        BlockState blockstate = null;
        if (tag.contains("carriedBlockState", 10)) {
            blockstate = NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), tag.getCompound("carriedBlockState"));
            if (blockstate.isAir()) {
                blockstate = null;
            }
        }
        this.setCarriedBlock(blockstate);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_CARRY_STATE, Optional.empty());
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> dataAccessor) {
        if (DATA_CARRY_STATE.equals(dataAccessor)){
            if (getCarriedBlock() != null){
                this.setItemSlot(EquipmentSlot.MAINHAND ,new ItemStack(getCarriedBlock().getBlock().asItem()));
            }else{
                this.setItemSlot(EquipmentSlot.MAINHAND,ItemStack.EMPTY);
            }
        }
        super.onSyncedDataUpdated(dataAccessor);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.brute_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.brute_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.brute_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 64)
                .add(Attributes.ATTACK_KNOCKBACK, 1)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Override
    public void tick() {
        if (this.isAlive() && this.getTarget() != null && this.getRandom().nextInt(0,6) == 3 && checkForInfected(this) && switchy()){performRangedAttack(this);}
        super.tick();

        if (getCarriedBlock() == null && this.random.nextInt(250) == 0){
            this.setCarriedBlock(blocky());
        }

    }
    private boolean switchy() {
        if (this.getTarget() != null){
            double ze = this.distanceToSqr(this.getTarget());
            return (ze > 60.0D && ze < 400);
        }
        return false;
    }

    boolean checkForInfected(Entity entity){
        AABB boundingBox = entity.getBoundingBox().inflate(1.2);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox);

        for (Entity en : entities) {
            if (SConfig.SERVER.can_be_carried.get().contains(en.getEncodeId())){
                return true;
            }
        }
        return false;
    }

    public void performRangedAttack(LivingEntity entity) {
        Vec3 vec3 = entity.getDeltaMovement();
        double d0 = entity.getX() + vec3.x - this.getTarget().getX();
        double d1 = entity.getEyeY() - (double)1.1F - this.getY();
        double d2 = entity.getZ() + vec3.z - this.getTarget().getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        AABB boundingBox = entity.getBoundingBox().inflate(1.2);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox);

        for (Entity en : entities) {
            if (en instanceof Mob && SConfig.SERVER.can_be_carried.get().contains(en.getEncodeId())){
                en.setDeltaMovement(d0 * -0.2D, (d1 + d3) * 0.02D, d2 * -0.2D);
                ((Mob) en).addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING , 200,0));
            }
        }

    }
    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_VILLAGER_GROWL.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_VILLAGER_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_VILLAGER_DEATH.get();
    }


    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }

    @Override
    public void performRangedAttack(LivingEntity livingEntity, float p_33318_) {
        if(!level().isClientSide && this.getCarriedBlock() != null) {
            double dx = livingEntity.getX() - this.getX();
            double dy = livingEntity.getY() + livingEntity.getEyeHeight();
            double dz = livingEntity.getZ() - this.getZ();
            FallingBlockEntity blockEntity = FallingBlockEntity.fall(level(), new BlockPos((int) this.getX(),(int) this.getY(),(int) this.getZ()), getCarriedBlock());
            blockEntity.setDeltaMovement(dx * 0.025F, dy - blockEntity.getY() + Math.hypot(dx, dz) * 0.02F, dz * 0.025F);
            blockEntity.setHurtsEntities(2f,30);
            level().addFreshEntity(blockEntity);
            this.setCarriedBlock(null);
        }
    }

    public BlockState blocky(){
        AABB aabb = this.getBoundingBox().inflate(0.2);
        for (BlockPos blockpos : BlockPos.betweenClosed(Mth.floor(aabb.minX), Mth.floor(aabb.minY), Mth.floor(aabb.minZ), Mth.floor(aabb.maxX), Mth.floor(aabb.maxY), Mth.floor(aabb.maxZ))) {
            BlockState blockstate = this.level().getBlockState(blockpos);
            if (blockstate.getDestroySpeed(level(), blockpos) < 5 && blockstate.getDestroySpeed(level(), blockpos) >= 0) {
                level().destroyBlock(blockpos,false);
                return blockstate;
            }
        }
        return null;
    }

}
