package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
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
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;

public class ThrownSickle extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownTrident.class, EntityDataSerializers.BOOLEAN);
    private ItemStack spearItem = new ItemStack(Sitems.SICKLE.get());
    private boolean dealtDamage;
    private LivingEntity shooter;


    public ThrownSickle(Level level, LivingEntity livingEntity, ItemStack stack) {
        super(Sentities.THROWN_KNIFE.get(), livingEntity, level);
        this.shooter = livingEntity;
        this.spearItem = stack.copy();
        this.entityData.set(ID_FOIL, stack.hasFoil());
    }

    public ThrownSickle(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(Sentities.THROWN_SPEAR.get(),level);
    }

    public ThrownSickle(EntityType<ThrownSickle> thrownSpearEntityType, Level level) {
        super(thrownSpearEntityType,level);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_FOIL, false);
    }

    public void tick() {
        if (this.inGroundTime > 4) {
            this.dealtDamage = true;
        }
        super.tick();
    }


    protected ItemStack getPickupItem() {
        return this.spearItem.copy();
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    @Nullable
    protected EntityHitResult findHitEntity(Vec3 p_37575_, Vec3 p_37576_) {
        return this.dealtDamage ? null : super.findHitEntity(p_37575_, p_37576_);
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
        SoundEvent soundevent = SoundEvents.TRIDENT_HIT;
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

        this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
        float f1 = 1.0F;
        this.playSound(soundevent, f1, 1.0F);
    }


    protected boolean tryPickup(Player p_150196_) {
        return super.tryPickup(p_150196_) || this.isNoPhysics() && this.ownedBy(p_150196_) && p_150196_.getInventory().add(this.getPickupItem());
    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    public void playerTouch(Player p_37580_) {
        if (this.ownedBy(p_37580_) || this.getOwner() == null) {
            super.playerTouch(p_37580_);
        }

    }

    public void readAdditionalSaveData(CompoundTag p_37578_) {
        super.readAdditionalSaveData(p_37578_);
        if (p_37578_.contains("Trident", 10)) {
            this.spearItem = ItemStack.of(p_37578_.getCompound("Trident"));
        }

        this.dealtDamage = p_37578_.getBoolean("DealtDamage");
    }

    public void addAdditionalSaveData(CompoundTag p_37582_) {
        super.addAdditionalSaveData(p_37582_);
        p_37582_.put("Trident", this.spearItem.save(new CompoundTag()));
        p_37582_.putBoolean("DealtDamage", this.dealtDamage);
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
}
