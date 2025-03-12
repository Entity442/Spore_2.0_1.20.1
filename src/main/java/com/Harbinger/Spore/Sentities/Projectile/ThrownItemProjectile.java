package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.function.Predicate;

public class ThrownItemProjectile extends AbstractArrow {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(ThrownItemProjectile.class, EntityDataSerializers.FLOAT);
    private final ItemStack stack;
    private Predicate<LivingEntity> livingEntityPredicate = (entity) -> {return true;};
    public ThrownItemProjectile(Level level) {
        super(Sentities.THROWN_TOOL.get(), level);
        stack = new ItemStack(Items.IRON_AXE);
    }
    public ThrownItemProjectile(Level level, LivingEntity living, float damage,ItemStack stack){
        super(Sentities.THROWN_TOOL.get(), level);
        this.setOwner(living);
        this.moveTo(living.getX(),living.getY()+1.2f,living.getZ());
        this.setDamage(damage);
        this.stack = stack;
    }
    public void setLivingEntityPredicate(Predicate<LivingEntity> value){
        livingEntityPredicate = value;
    }
    public Float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(Float value){entityData.set(DAMAGE,value);}
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, 0f);
    }
    public ItemStack getItem(){return stack;}

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (result.getEntity() instanceof LivingEntity living){
            living.setArrowCount(living.getArrowCount() - 1);
        }
        this.discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        super.onHitBlock(p_36755_);
        this.discard();
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity instanceof LivingEntity living && livingEntityPredicate.test(living);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 200 == 0)
            this.discard();
    }

    protected float getWaterInertia() {
        return 0.99F;
    }
}
