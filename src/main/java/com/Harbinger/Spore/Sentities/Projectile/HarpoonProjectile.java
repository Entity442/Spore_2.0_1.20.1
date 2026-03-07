package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class HarpoonProjectile extends AbstractArrow {
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(HarpoonProjectile.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> ID = SynchedEntityData.defineId(HarpoonProjectile.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> VICTIM_ID = SynchedEntityData.defineId(HarpoonProjectile.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> SHOT = SynchedEntityData.defineId(HarpoonProjectile.class, EntityDataSerializers.BOOLEAN);
    public HarpoonProjectile(Level level) {
        super(Sentities.HARPOON.get(), level);
    }
    public HarpoonProjectile(Level level, LivingEntity living, float damage){
        super(Sentities.HARPOON.get(), level);
        this.entityData.set(ID,living.getId());
        this.setDamage(damage);
    }
    public Float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(Float value){entityData.set(DAMAGE,value);}

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DAMAGE, 0f);
        entityData.define(ID, -1);
        entityData.define(VICTIM_ID, -1);
        entityData.define(SHOT, false);
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    public Entity getOwnerById(){
        int i = entityData.get(ID);
        if (i == -1){
            return null;
        }else {
            return level().getEntity(i);
        }
    }
    public int getOwnerId(){
        return entityData.get(ID);
    }
    public Entity getVictimById(){
        int i = entityData.get(VICTIM_ID);
        if (i == -1){
            return null;
        }else {
            return level().getEntity(i);
        }
    }
    public void setHarpoonBackInPlace(){
        Entity entity = getOwnerById();
        if (entity instanceof Grakensenker grakensenker){
            if (this.distanceTo(grakensenker) < 10){
                grakensenker.shootHook(true);
                this.discard();
            }
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
        entityData.set(SHOT,tag.getBoolean("shot"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
        tag.putBoolean("shot",entityData.get(SHOT));
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        if (target instanceof LivingEntity living) {

            living.hurt(level().damageSources().mobProjectile(this,(LivingEntity)this.getOwner()), getDamage());
            living.setArrowCount(living.getArrowCount() - 1);
            entityData.set(VICTIM_ID, living.getId());
            this.setDeltaMovement(Vec3.ZERO);
            this.setNoGravity(true);
        }
        entityData.set(SHOT,true);
        playSound(SoundEvents.ANVIL_HIT);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        SoundType soundtype = state.getSoundType(this.level(), pos, this);
        this.playSound(SoundEvents.CHAIN_STEP, soundtype.getVolume() * 0.15F, soundtype.getPitch());
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        entityData.set(SHOT,true);
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.ANVIL_HIT;
    }

    @Override
    protected boolean canHitEntity(Entity entity) {
        return entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living);
    }



    @Override
    public void tick() {
        super.tick();

        Entity owner = getOwnerById();
        Entity victim = getVictimById();
        if (victim == null){
            AABB aabb = this.getBoundingBox();
            List<Entity> entities = level().getEntities(this,aabb);
            for(Entity entity : entities){
                if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                    entityData.set(VICTIM_ID,living.getId());
                    break;
                }
            }
        }

        if (owner == null) return;
        if (entityData.get(SHOT)){
            Vec3 ownerPos = owner.position();
            Vec3 direction = ownerPos.subtract(this.position());
            double distance = direction.length();
            if (distance > 1) {
                Vec3 motion = direction.normalize().scale(0.5);
                this.setDeltaMovement(motion);
                if (victim instanceof LivingEntity living) {
                    living.hurtMarked = true;
                    living.setDeltaMovement(motion);
                    this.moveTo(living.getX(),living.getY()+(living.getBbHeight()/2),living.getZ());
                }else {
                    this.moveTo(
                            getX() + motion.x,
                            getY() + motion.y,
                            getZ() + motion.z
                    );
                }
                setHarpoonBackInPlace();
            }
        }
    }

    protected float getWaterInertia() {
        return 0.99F;
    }
}
