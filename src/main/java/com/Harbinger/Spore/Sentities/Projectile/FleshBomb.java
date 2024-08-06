package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.function.Predicate;

public class FleshBomb extends AbstractArrow {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> BOMB_TYPE = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> EXPLOSION = SynchedEntityData.defineId(FleshBomb.class, EntityDataSerializers.INT);
    private Predicate<LivingEntity> livingEntityPredicate;
    public FleshBomb(Level level) {
        super(Sentities.STINGER.get(), level);
    }
    public FleshBomb(Level level,LivingEntity entity,float damage,BombType type,int range) {
        super(Sentities.STINGER.get(), level);
        setBombType(type.getValue());
        setExplosion(range);
        setDamage(damage);
        setOwner(entity);
    }


    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DAMAGE, 2f);
        this.entityData.define(BOMB_TYPE, 0);
        this.entityData.define(EXPLOSION, 5);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
        this.setBombType(tag.getInt("bomb_type"));
        this.setExplosion(tag.getInt("explosion"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
        tag.putInt("bomb_type",this.getBombType());
        tag.putInt("explosion",this.getExplosion());
    }

    public float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(float value){entityData.set(DAMAGE,value);}
    public int getBombType(){return entityData.get(BOMB_TYPE);}
    public void setBombType(int value){entityData.set(BOMB_TYPE,value);}
    public int getExplosion(){return entityData.get(EXPLOSION);}
    public void setExplosion(int value){entityData.set(EXPLOSION,value);}

    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity instanceof LivingEntity living && livingEntityPredicate.test(living);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        if (result.getEntity() instanceof LivingEntity living){
            if (level() instanceof ServerLevel serverLevel){
                Utilities.explodeCircle(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(),getDamage(),8,entity -> {return entity instanceof LivingEntity livingEntity && livingEntityPredicate.test(livingEntity);});
                if (getBombType() == 1){
                    living.setSecondsOnFire(20);
                    Utilities.convertBlocks(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(), Blocks.FIRE.defaultBlockState());
                }if (getBombType() == 2){
                    Utilities.convertBlocks(serverLevel,this.getOwner(),result.getEntity().getOnPos(),getExplosion(), Sblocks.BILE.get().defaultBlockState());
                }
            }
        }
        discard();
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.GENERIC_EXPLODE;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        if (level() instanceof ServerLevel serverLevel){
            Utilities.explodeCircle(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(),getDamage(),8,entity -> {return entity instanceof LivingEntity livingEntity && livingEntityPredicate.test(livingEntity);});
            if (getBombType() == 1){
                Utilities.convertBlocks(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(), Blocks.FIRE.defaultBlockState());
            }if (getBombType() == 2){
                Utilities.convertBlocks(serverLevel,this.getOwner(),result.getBlockPos(),getExplosion(), Sblocks.BILE.get().defaultBlockState());
            }
        }
        discard();
    }
    public enum BombType{
        BASIC(0),
        FLAME(1),
        BILE(2);
        private final int value;
        BombType(int value1){
            value = value1;
        }
        public int getValue() {
            return value;
        }
    }
}
