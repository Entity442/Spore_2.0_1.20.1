package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BileProjectile extends Projectile implements ItemSupplier {
    private float setBaseDamage;
    private Predicate<LivingEntity> target = livingEntity -> {return true;};
    public BileProjectile( Level level) {
        super(Sentities.BILE.get(), level);
    }

    public BileProjectile(Level level,LivingEntity livingEntity,Predicate<LivingEntity> predicate) {
        super(Sentities.BILE.get(), level);
        this.setOwner(livingEntity);
        this.target = predicate;
    }

    @Override
    protected void defineSynchedData() {

    }


    public float getDamage(){
        return this.setBaseDamage;
    }
    public void setDamage(float value){
        this.setBaseDamage = value;
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
    protected void onHitEntity(EntityHitResult entityHitResult) {
        if (!this.level().isClientSide()) {
            Entity entity = entityHitResult.getEntity();
            if (entity instanceof LivingEntity livingEntity && target.test(livingEntity)){
                entity.hurt(this.level().damageSources().mobProjectile(this,(LivingEntity) this.getOwner()),this.getDamage());
                for (MobEffectInstance instance : BileLiquid.bileEffects()){
                    livingEntity.addEffect(instance);
                }
            }
            if (entity instanceof Boat boat){
                boat.setDamage(50);
            }
        }else{
            super.onHitEntity(entityHitResult);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult p_37258_) {
        super.onHitBlock(p_37258_);
        discard();
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
    public ItemStack getItem() {
        return new ItemStack(Sitems.BILE.get());
    }
}
