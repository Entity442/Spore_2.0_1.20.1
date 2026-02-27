package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;

import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class DrownedFleshBomb extends AbstractArrow {
    public DrownedFleshBomb(Level level) {
        super(Sentities.DROWNED_FLESH_BOMB.get(),level);
    }
    private static final EntityDataAccessor<Float> DAMAGE = SynchedEntityData.defineId(DrownedFleshBomb.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> BOMB_TIME = SynchedEntityData.defineId(DrownedFleshBomb.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<String> EFFECT = SynchedEntityData.defineId(DrownedFleshBomb.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Boolean> FLOAT = SynchedEntityData.defineId(DrownedFleshBomb.class, EntityDataSerializers.BOOLEAN);
    public DrownedFleshBomb(EntityType<DrownedFleshBomb> vomitEntityType, Level level) {
        super(vomitEntityType,level);
    }

    @Override
    public void tick() {
        super.tick();
        if (isInWater() && entityData.get(FLOAT)){
            this.setDeltaMovement(getDeltaMovement().add(0,0.1,0));
        }
        if (getBombTime() < 80){
            setBombTime(getBombTime()+1);
        }else {
            explodeBomb();
            discard();
        }
    }
    public void explodeBomb(){
        if (level() instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER,this.getX(),this.getY(),this.getZ(),3,0,0,0,1);
            this.playSound(Ssounds.FUNGAL_BOOM.get());
            AABB aabb = this.getBoundingBox().inflate(3);
            List<Entity> entityList = level().getEntities(this,aabb);
            if (entityList.isEmpty()){
                return;
            }
            for (Entity entity : entityList){
                if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(getEffect()));
                    if (effect == null) {
                        effect = Seffects.MYCELIUM.get();
                    }
                    living.addEffect(new MobEffectInstance(effect, 200, 0));
                }
            }
        }
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }


    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.SLIME_JUMP_SMALL;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(DAMAGE, 2f);
        entityData.define(BOMB_TIME, 0);
        entityData.define(EFFECT, "spore:mycelium_ef");
        entityData.define(FLOAT, Math.random() <= 0.5);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        this.setDamage(tag.getFloat("damage"));
        this.setBombTime(tag.getInt("bomb_time"));
        this.setEffect(tag.getString("effect"));
        this.entityData.set(FLOAT,tag.getBoolean("float"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putFloat("damage",this.getDamage());
        tag.putInt("bomb_time",this.getBombTime());
        tag.putString("effect",getEffect());
        tag.putBoolean("float",entityData.get(FLOAT));
    }
    public float getDamage(){return entityData.get(DAMAGE);}
    public void setDamage(float value){entityData.set(DAMAGE,value);}
    public int getBombTime(){return entityData.get(BOMB_TIME);}
    public void setBombTime(int value){entityData.set(BOMB_TIME,value);}
    public String getEffect(){return entityData.get(EFFECT);}
    public void setEffect(String value){entityData.set(EFFECT,value);}

    @Override
    protected boolean canHitEntity(Entity target) {
        return false;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
    }
}
