package com.Harbinger.Spore.Sentities.Projectile.GunProjectiles;

import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Fluids.BileLiquid;
import com.Harbinger.Spore.Sentities.Projectile.AbstractGunProjectile;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;

public class BileBullet extends AbstractGunProjectile {

    public BileBullet(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SoundEvent blockImpactSound() {
        return Ssounds.BILE_BLASTER_BULLET_BLOCK.get();
    }

    @Override
    public SoundEvent entityImpactSound() {
        return Ssounds.BILE_BLASTER_BULLET_ENTITY.get();
    }

    @Override
    public float getMaxBlockRange() {
        return 16;
    }

    @Override
    public float getProDamage() {
        return 0.1f;
    }


    @Override
    public void doHitAfterEffects(LivingEntity living, LivingEntity owner) {
        for (MobEffectInstance instance : BileLiquid.bileEffects()){
            living.addEffect(instance);
        }
    }

    @Override
    public ParticleOptions getParticle() {
        return Sparticles.BILE_BULLET.get();
    }
}
