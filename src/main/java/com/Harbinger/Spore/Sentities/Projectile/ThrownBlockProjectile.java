package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.function.Predicate;

public class ThrownBlockProjectile extends Projectile {
    private Predicate<LivingEntity> victim = livingEntity -> {return true;};
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(ThrownBlockProjectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<BlockState> STATE = SynchedEntityData.defineId(ThrownBlockProjectile.class, EntityDataSerializers.BLOCK_STATE);

    public ThrownBlockProjectile(Level level) {
        super(Sentities.THROWN_BLOCK.get(), level);
        entityData.set(STATE,Blocks.GRASS_BLOCK.defaultBlockState());
    }
    public ThrownBlockProjectile(Level level,LivingEntity livingEntity,Float damage,BlockState state,Predicate<LivingEntity> livingEntityPredicate) {
        super(Sentities.THROWN_BLOCK.get(), level);
        setOwner(livingEntity);
        entityData.set(DAMAGE,damage);
        entityData.set(STATE,state);
        victim = livingEntityPredicate;
    }
    public BlockState state(){
        return entityData.get(STATE);
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE,5f);
        this.entityData.define(STATE,Blocks.GRASS_BLOCK.defaultBlockState());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DAMAGE,tag.getFloat("damage"));
        this.entityData.set(STATE,NbtUtils.readBlockState(this.level().holderLookup(Registries.BLOCK), tag.getCompound("state")));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.entityData.get(DAMAGE));
        tag.put("state", NbtUtils.writeBlockState(this.entityData.get(STATE)));
    }
    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity != getOwner() || (entity instanceof LivingEntity livingEntity && victim.test(livingEntity));
    }
    @Override
    public void tick() {
        super.tick();
        if (this.tickCount >= 300) {
            this.remove(RemovalReason.DISCARDED);
            FallingBlockEntity.fall(level(),new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ()),entityData.get(STATE));
        }
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        Vec3 vec3 = this.getDeltaMovement().add(0,-0.1,0);
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.setPos(d0, d1, d2);

        if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
            this.onHit(hitresult);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!level().isClientSide && result.getEntity() instanceof LivingEntity livingEntity){
            BlockPos pos = new BlockPos((int) this.getX(), (int) this.getY(), (int) this.getZ());
            livingEntity.hurt(level().damageSources().mobProjectile(this,this.getOwner() instanceof LivingEntity livingEntity1 ? livingEntity1 : null),
                    entityData.get(DAMAGE)*entityData.get(STATE).getDestroySpeed(level(),pos));
            FallingBlockEntity.fall(level(),pos,entityData.get(STATE));
            this.discard();
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        BlockPos pos = result.getBlockPos().relative(result.getDirection()).above();
        FallingBlockEntity.fall(level(),pos,entityData.get(STATE));
        this.discard();
    }
}
