package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.*;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.network.PlayMessages;

import java.util.Random;

public class Vomit extends AbstractArrow implements ItemSupplier {

    public Vomit(PlayMessages.SpawnEntity spawnEntity, Level level) {
        super(Sentities.ACID.get(),level);
    }

    public Vomit(EntityType<Vomit> vomitEntityType, Level level) {
        super(vomitEntityType,level);
    }

    public Vomit(EntityType<Vomit> vomitEntityType, LivingEntity entity, Level world) {
        super(vomitEntityType,entity,world);
    }

    public ItemStack getItem() {
        return new ItemStack(Sitems.ACID.get());
    }


    @Override
    public void tick() {
        super.tick();
        if (this.inGround || this.isInFluidType())
            this.discard();
    }

    public static Vomit shoot(Level world, LivingEntity entity, Random random, float power, double damage, int knockback) {
        Vomit entityarrow = new Vomit(Sentities.ACID.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 0.1f, 0);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static Vomit shoot(LivingEntity entity, LivingEntity target) {
        Vomit entityarrow = new Vomit(Sentities.ACID.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 2;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.1F, dz, 1f * 2, 12.0F);
        entityarrow.setBaseDamage(SConfig.SERVER.spit_damage_c.get() * SConfig.SERVER.global_damage.get());
        entityarrow.setKnockback(0);
        entity.level().addFreshEntity(entityarrow);

        return entityarrow;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        levels(hitResult.getEntity());
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    private void levels(Entity entity) {

        if (entity instanceof LivingEntity _livEnt) {
            _livEnt.addEffect(new MobEffectInstance(Seffects.CORROSION.get(), 300, 1 +
                    (_livEnt.hasEffect(Seffects.CORROSION.get())
                    ? _livEnt.getEffect(Seffects.CORROSION.get()).getAmplifier() : 0)));
        }

    }

    protected SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.SLIME_JUMP_SMALL;
    }

    @Override
    protected void doPostHurtEffects(LivingEntity entity) {
        super.doPostHurtEffects(entity);
        entity.setArrowCount(entity.getArrowCount() - 1);
    }

}
