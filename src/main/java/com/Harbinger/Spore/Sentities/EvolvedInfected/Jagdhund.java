package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LeapAtTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class Jagdhund extends EvolvedInfected {
    private static final EntityDataAccessor<Boolean> UNDERGROUND = SynchedEntityData.defineId(Jagdhund.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Integer> BORROW = SynchedEntityData.defineId(Jagdhund.class, EntityDataSerializers.INT);
    public static final EntityDataAccessor<Integer> EMERGE = SynchedEntityData.defineId(Jagdhund.class, EntityDataSerializers.INT);
    public Jagdhund(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.jagd_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.jagd_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.jagd_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 46)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.jagd_loot.get();
    }


    public void setUnderground(boolean value){
        entityData.set(UNDERGROUND,value);
    }
    public boolean isUnderground(){
        return entityData.get(UNDERGROUND);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("underground",entityData.get(UNDERGROUND));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(UNDERGROUND, tag.getBoolean("underground"));
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(UNDERGROUND,false);
        this.entityData.define(BORROW, 0);
        this.entityData.define(EMERGE, 0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(2,new LeapAtTargetGoal(this,0.4f){
            @Override
            public boolean canUse() {
                return super.canUse() && !isUnderground();
            }
        });
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected void checkAndPerformAttack(LivingEntity entity, double at) {
                if (!isUnderground() || isEmerging()){
                    super.checkAndPerformAttack(entity, at);
                }
            }
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    @Override
    public void tick() {
        super.tick();
        Entity target = this.getTarget();
        if (this.tickCount % 20 == 0){
            if ((!isSoftEnough(getOnPos()) || isInFluidType()) && isUnderground() && !isEmerging()){
                tickEmerging();
            }
        }
        if (this.tickCount % 10 == 0 && target != null){
            if (target.distanceToSqr(this) > 100 && !isUnderground() && !isBurrowing() && isSoftEnough(getOnPos())){
                tickBurrowing();
            }
            if (target.distanceToSqr(this) < 50 && isUnderground() && !isEmerging()){
                tickEmerging();
            }
        }
        if (isEmerging() || isBurrowing()){
            SummonParticles(getOnPos());
        }
        if (this.navigation.isInProgress() && isUnderground()){
            SummonParticles(getOnPos());
        }
        if (this.isEmerging()){
            this.tickEmerging();
        } else if (this.isBurrowing()){
            this.tickBurrowing();
        }
    }
    private void SummonParticles(BlockPos pos){
        for (int l = 0 ;l<this.random.nextInt(3,6);l++){
            if (level() instanceof ServerLevel serverLevel) {
                int xi = random.nextInt(-1,1);
                int zi = random.nextInt(-1,1);
                if (level().getBlockState(pos).getBlock().asItem() != ItemStack.EMPTY.getItem()) {
                    serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM, new ItemStack((level().getBlockState(pos)).getBlock())), getX() + xi, getY() - 0.1D, getZ() + zi, 3,
                            ((double) random.nextFloat() - 1D) * 0.08D, ((double) random.nextFloat() - 1D) * 0.08D, ((double) random.nextFloat() - 1D) * 0.08D, 0.15F);
                }
            }
        }
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return super.canDrownInFluidType(type) && !isUnderground();
    }

    private boolean isSoftEnough(BlockPos pos){
        return level().getBlockState(pos).getDestroySpeed(level(),pos) < 4;
    }

    public boolean isEmerging(){
        return this.entityData.get(EMERGE) > 0;
    }
    public void tickEmerging(){
        int emerging = this.entityData.get(EMERGE);
        if (emerging > getEmerge_tick()){
            this.setUnderground(false);
            emerging = -1;
        }
        this.entityData.set(EMERGE, emerging + 1);
    }
    public boolean isBurrowing(){
        return this.entityData.get(BORROW) > 0;
    }
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > getBorrow_tick()) {
            this.setUnderground(true);
            burrowing = -1;
        }
        this.entityData.set(BORROW, burrowing + 1);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.HUNGER,1200,0));
        }
        return super.doHurtTarget(entity);
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.is(DamageTypes.IN_FIRE) || source.is(DamageTypes.ON_FIRE) || source.is(DamageTypes.EXPLOSION)){
            return super.hurt(source, amount);
        }
        if (isUnderground() || isEmerging() || isBurrowing()){
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    public double getMyRidingOffset() {
        return -1;
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> accessor) {
        super.onSyncedDataUpdated(accessor);
        if (UNDERGROUND.equals(accessor)){
            refreshDimensions();
        }
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        if (this.isUnderground()){
            return new EntityDimensions(1.2f,0.1f,false);
        }
        return super.getDimensions(pose);
    }

    public int getEmerge(){return entityData.get(EMERGE);}
    public int getBorrow(){return entityData.get(BORROW);}

    public int getBorrow_tick() {
        return 60;
    }

    public int getEmerge_tick() {
        return 60;
    }

    protected SoundEvent getAmbientSound() {
        return isUnderground() ? null : Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
        if (isUnderground()){
            this.playSound(state.getSoundType(level(),pos,this).getBreakSound(), 0.15F, 0.5F);
        }else
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }
}
