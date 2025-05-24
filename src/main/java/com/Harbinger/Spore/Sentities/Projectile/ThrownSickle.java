package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sitems.InfectedSickle;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;
import java.util.UUID;

public class ThrownSickle extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.BOOLEAN);
    private ItemStack spearItem = new ItemStack(Sitems.SICKLE.get());
    private boolean dealtDamage;
    private SickelState state = SickelState.FLYING;
    private Entity hookedEntity = null;
    private Vec3 hookedBlockPos = null;

    public ThrownSickle(Level level, LivingEntity livingEntity, ItemStack stack) {
        super(Sentities.THROWN_SICKEL.get(), livingEntity, level);
        this.setOwner(livingEntity);
        this.spearItem = stack.copy();
        this.entityData.set(ID_FOIL, stack.hasFoil());
    }
    public ThrownSickle(Level level) {
        super(Sentities.THROWN_SICKEL.get(), level);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_FOIL, false);
    }

    public void tick() {
        if (this.state == SickelState.HOOKED_IN_ENTITY && hookedEntity != null && hookedEntity.isAlive()) {
            this.setPos(hookedEntity.getX(), hookedEntity.getY() + (hookedEntity.getBbHeight() * 0.5), hookedEntity.getZ());
        }
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        Entity owner = this.getOwner();
        if (owner instanceof LivingEntity living){
            ItemStack stack = living.getMainHandItem();
            if (this.distanceTo(living) > 30.0f || !(stack.getItem() instanceof InfectedSickle)){
                if (stack.getItem() instanceof InfectedSickle sickle){
                    sickle.setThrownSickle(stack,false);
                }
                this.discard();
            }
        }else {
            this.discard();
        }
        super.tick();
    }


    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 vec3, Vec3 vec31) {
        return this.dealtDamage ? null : super.findHitEntity(vec3, vec31);
    }

    protected void onHitEntity(EntityHitResult hit) {
        Entity entity = hit.getEntity();
        float f = SConfig.SERVER.sickle_damage.get() + (0.5F * EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS , this.spearItem));
        if (entity instanceof LivingEntity livingentity) {
            f += EnchantmentHelper.getDamageBonus(this.spearItem, livingentity.getMobType());
        }
        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().trident(this, entity1 == null ? this : entity1);
        this.dealtDamage = true;
        SoundEvent soundevent = Ssounds.INFECTED_WEAPON_HIT_ENTITY.get();
        if (entity.hurt(damagesource, f)) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }
            if (entity instanceof LivingEntity livingEntity) {
                if (entity1 instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(livingEntity, entity1);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)entity1, livingEntity);
                }
                if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT , this.spearItem) > 0) {
                    int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, this.spearItem);
                    entity.setSecondsOnFire(4 * j);
                }
                abstractEffects(this.spearItem,livingEntity);

                this.doPostHurtEffects(livingEntity);
            }
        }
        this.hookedEntity = entity;
        this.state = SickelState.HOOKED_IN_ENTITY;
        this.playSound(soundevent, 1.0F, 1.0F);
    }

    @Override
    protected boolean tryPickup(Player p_150121_) {
        return false;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        this.hookedBlockPos = result.getLocation();
        this.state = SickelState.HOOKED_BLOCK;
    }
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return Ssounds.INFECTED_WEAPON_HIT_BLOCK.get();
    }

    public SickelState getHookState() {
        return this.state;
    }

    public Entity getHookedEntity() {
        return this.hookedEntity;
    }

    public Vec3 getHookedBlockPos() {
        return this.hookedBlockPos;
    }

    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Sickle", 10)) {
            this.spearItem = ItemStack.of(tag.getCompound("Sickle"));
        }

        this.dealtDamage = tag.getBoolean("DealtDamage");
        if (this.getOwner() != null) {
            tag.putUUID("OwnerUUID", this.getOwner().getUUID());
        }
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("Sickle", this.spearItem.save(new CompoundTag()));
        tag.putBoolean("DealtDamage", this.dealtDamage);
    }
    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        Entity entity = this.getOwner();
        if (entity != null){
            UUID uuid1 = entity.getUUID();
            if (!this.level().isClientSide) {
                Entity entity1 = ((ServerLevel)this.level()).getEntity(uuid1);
                if (entity1 instanceof LivingEntity livingEntity) {
                    this.setOwner(livingEntity);
                }
            }
        }
    }
    public void tickDespawn() {
        if (this.pickup != Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    protected float getWaterInertia() {
        return 0.99F;
    }

    public boolean shouldRender(double p_37588_, double p_37589_, double p_37590_) {
        return true;
    }

    public static void abstractEffects(ItemStack stack, LivingEntity livingEntity){
        if (stack.getEnchantmentLevel(Senchantments.CORROSIVE_POTENCY.get())>0){
            livingEntity.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,1));
        }
        if (stack.getEnchantmentLevel(Senchantments.GASTRIC_SPEWAGE.get())>0){
            for (MobEffectInstance instance : BileLiquid.bileEffects())
                livingEntity.addEffect(instance);
        }
        if (stack.getEnchantmentLevel(Senchantments.CRYOGENIC_ASPECT.get())>0){
            livingEntity.setTicksFrozen(livingEntity.getTicksFrozen()+300);
        }
    }


    public enum SickelState {
        FLYING,
        HOOKED_IN_ENTITY,
        HOOKED_BLOCK;
        private SickelState() {
        }
    }
}
