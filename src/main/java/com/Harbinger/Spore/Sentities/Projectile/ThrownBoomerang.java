package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import javax.annotation.Nullable;

public class ThrownBoomerang extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ID_FOIL = SynchedEntityData.defineId(ThrownBoomerang.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(ThrownBoomerang.class, EntityDataSerializers.INT);
    private ItemStack boomerang = new ItemStack(Sitems.BOOMERANG.get());
    private boolean dealtDamage;
    private int returnTick;

    public ThrownBoomerang(Level level, LivingEntity owner, ItemStack stack,int color) {
        super(Sentities.THROWN_BOOMERANG.get(), owner, level);
        this.boomerang = stack.copy();
        this.entityData.set(ID_FOIL, stack.hasFoil());
        this.entityData.set(COLOR, color);
    }
    public int getColor(){return entityData.get(COLOR);}

    public ItemStack getBoomerang(){return boomerang;}
    public ThrownBoomerang(PlayMessages.SpawnEntity spawnEntity, Level level) {
        this(Sentities.THROWN_BOOMERANG.get(), level);
    }

    public ThrownBoomerang(EntityType<ThrownBoomerang> type, Level level) {
        super(type, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_FOIL, false);
        this.entityData.define(COLOR, 0);
    }

    @Override
    public void tick() {
        if (this.inGroundTime > 4 || returnTick++ > 35) {
            this.dealtDamage = true;
        }

        Entity owner = this.getOwner();
        if ((this.dealtDamage || this.isNoPhysics()) && owner != null) {
            if (!isAcceptibleReturnOwner()) {
                if (!this.level().isClientSide && this.pickup == Pickup.ALLOWED) {
                    this.spawnAtLocation(this.getPickupItem(), 0.1F);
                }
                this.discard();
            } else {
                this.setNoPhysics(true);
                Vec3 direction = owner.getEyePosition().subtract(this.position());
                this.setPosRaw(this.getX(), this.getY() + direction.y * 0.045D, this.getZ());
                if (this.level().isClientSide) {
                    this.yOld = this.getY();
                }
                this.setDeltaMovement(this.getDeltaMovement().scale(0.95D).add(direction.normalize().scale(0.15D)));
            }
        }

        super.tick();
    }

    private boolean isAcceptibleReturnOwner() {
        Entity owner = this.getOwner();
        return owner != null && owner.isAlive() && (!(owner instanceof ServerPlayer) || !owner.isSpectator());
    }

    @Override
    protected ItemStack getPickupItem() {
        return this.boomerang.copy();
    }

    public boolean isFoil() {
        return this.entityData.get(ID_FOIL);
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(Vec3 from, Vec3 to) {
        return this.dealtDamage ? null : super.findHitEntity(from, to);
    }

    @Override
    protected void onHitBlock(BlockHitResult p_36755_) {
        this.dealtDamage = true;
        super.onHitBlock(p_36755_);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity target = result.getEntity();
        float baseDamage = SConfig.SERVER.boomerang_damage.get() + (0.5F * EnchantmentHelper.getItemEnchantmentLevel(Enchantments.SHARPNESS, boomerang));

        if (target instanceof LivingEntity livingTarget) {
            baseDamage += EnchantmentHelper.getDamageBonus(boomerang, livingTarget.getMobType());
        }

        Entity owner = this.getOwner();
        DamageSource source = this.damageSources().trident(this, owner == null ? this : owner);
        this.dealtDamage = true;

        if (target.hurt(source, baseDamage)) {
            if (target instanceof LivingEntity living) {
                if (owner instanceof LivingEntity ownerLiving) {
                    EnchantmentHelper.doPostHurtEffects(living, ownerLiving);
                    EnchantmentHelper.doPostDamageEffects(ownerLiving, living);
                    if (boomerang.getItem() instanceof SporeWeaponData data){
                        data.abstractMutationBuffs(living,ownerLiving,boomerang,data);
                    }
                }

                if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, boomerang) > 0) {
                    target.setSecondsOnFire(4 * EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FIRE_ASPECT, boomerang));
                }

                abstractEffects(boomerang, living);
                this.doPostHurtEffects(living);
            }

            this.setDeltaMovement(this.getDeltaMovement().multiply(-0.01D, -0.1D, -0.01D));
            this.playSound(Ssounds.INFECTED_WEAPON_HIT_ENTITY.get(), 1.0F, 1.0F);
        }
    }

    @Override
    protected boolean tryPickup(Player player) {
        return super.tryPickup(player) || (this.isNoPhysics() && this.ownedBy(player) && player.getInventory().add(this.getPickupItem()));
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return Ssounds.INFECTED_WEAPON_HIT_BLOCK.get();
    }

    @Override
    public void playerTouch(Player player) {
        if (this.ownedBy(player) || this.getOwner() == null) {
            super.playerTouch(player);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("Boomerang", 10)) {
            this.boomerang = ItemStack.of(tag.getCompound("Boomerang"));
        }
        this.dealtDamage = tag.getBoolean("DealtDamage");
        this.entityData.set(COLOR, tag.getInt("color"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.put("Boomerang", this.boomerang.save(new CompoundTag()));
        tag.putBoolean("DealtDamage", this.dealtDamage);
        tag.putInt("color",entityData.get(COLOR));
    }

    @Override
    protected float getWaterInertia() {
        return 0.99F;
    }

    @Override
    public boolean shouldRender(double x, double y, double z) {
        return true;
    }

    public static void abstractEffects(ItemStack stack, LivingEntity target) {
        if (stack.getEnchantmentLevel(Senchantments.CORROSIVE_POTENCY.get()) > 0) {
            target.addEffect(new MobEffectInstance(Seffects.CORROSION.get(), 200, 1));
        }
        if (stack.getEnchantmentLevel(Senchantments.GASTRIC_SPEWAGE.get()) > 0) {
            for (MobEffectInstance effect : BileLiquid.bileEffects()) {
                target.addEffect(effect);
            }
        }
        if (stack.getEnchantmentLevel(Senchantments.CRYOGENIC_ASPECT.get()) > 0) {
            target.setTicksFrozen(target.getTicksFrozen() + 300);
        }
    }
}