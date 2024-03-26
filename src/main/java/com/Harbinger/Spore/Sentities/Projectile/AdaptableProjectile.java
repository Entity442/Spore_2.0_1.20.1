package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import com.Harbinger.Spore.Sentities.Variants.BulletParameters;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

public class AdaptableProjectile extends Projectile {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(AdaptableProjectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> TYPE = SynchedEntityData.defineId(AdaptableProjectile.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> PARTICLES = SynchedEntityData.defineId(AdaptableProjectile.class, EntityDataSerializers.INT);
    public AdaptableProjectile(Level level) {
        super(Sentities.SPIT.get(), level);
    }
    public AdaptableProjectile(BulletParameters parameters, Level level, LivingEntity livingEntity) {
        super(Sentities.SPIT.get(), level);
        this.setOwner(livingEntity);
        this.setType(parameters.getId());
        this.setDamage(parameters.getDamage());

    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(DAMAGE,0f);
        this.entityData.define(TYPE,0);
        this.entityData.define(PARTICLES,0);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.entityData.set(DAMAGE,tag.getFloat("damage"));
        this.entityData.set(TYPE,tag.getInt("type"));
        this.entityData.set(PARTICLES,tag.getInt("particles"));
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.entityData.get(DAMAGE));
        tag.putInt("type",this.entityData.get(TYPE));
        tag.putInt("particles",this.entityData.get(PARTICLES));
    }
    public void setType(int i){
        this.entityData.set(TYPE,i);
    }
    public void setDamage(float i){
        this.entityData.set(DAMAGE,i);
    }
    public void setParticles(int i){
        this.entityData.set(PARTICLES,i);
    }

    public int getParticles(){
        return this.entityData.get(PARTICLES);
    }

    @Override
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity != getOwner();
    }
    @Override
    public void tick() {
        super.tick();
        if (this.tickCount >= 300) {
            this.remove(RemovalReason.DISCARDED);
        }
        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.setPos(d0, d1, d2);

        if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult)) {
            this.onHit(hitresult);
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level().isClientSide()) {
            Entity entity = entityHitResult.getEntity();
            if (entity instanceof LivingEntity livingEntity){
                if (livingEntity instanceof Infected || livingEntity instanceof UtilityEntity || SConfig.SERVER.blacklist.get().contains(livingEntity.getEncodeId())){
                    return;
                }else{
                    int type = entityData.get(TYPE);
                    livingEntity.hurt(this.level().damageSources().mobProjectile(this,(LivingEntity) this.getOwner()),this.entityData.get(DAMAGE));
                    if (type == 0){
                        livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),400,3));
                    }else if (type == 1){
                        livingEntity.level().explode(this.getOwner(),livingEntity.getX(),livingEntity.getY(),livingEntity.getZ(),1, Level.ExplosionInteraction.NONE);
                    }else if (type == 2){
                        livingEntity.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),600,1));
                    }else if (type == 3){
                        livingEntity.setSecondsOnFire(6);
                    }
                    this.discard();
                }
            }
        }else{
            super.onHitEntity(entityHitResult);
        }
    }
    @Override
    protected void onHitBlock(BlockHitResult blockHitResult) {
        if (!this.level().isClientSide){
            int type = entityData.get(TYPE);
            Level level = this.level();
            if (type == 3 && level.getBlockState(blockHitResult.getBlockPos()).isFlammable(level,blockHitResult.getBlockPos(),blockHitResult.getDirection())){
                this.level().setBlock(blockHitResult.getBlockPos().relative(blockHitResult.getDirection()), Blocks.FIRE.defaultBlockState(),3);
            }
            discard();
        }
        super.onHitBlock(blockHitResult);
    }
}
