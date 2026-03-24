package com.Harbinger.Spore.Sentities.Projectile.GunProjectiles;

import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.Projectile.AbstractGunProjectile;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;

public class GoreBullet extends AbstractGunProjectile {
    public GoreBullet(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SoundEvent blockImpactSound() {
        return Ssounds.MISTMAKER_BULLET_BLOCK.get();
    }

    @Override
    public SoundEvent entityImpactSound() {
        return Ssounds.MISTMAKER_BULLET_ENTITY.get();
    }

    @Override
    public float getMaxBlockRange() {
        return 8;
    }

    @Override
    public float getProDamage() {
        return 0.05f;
    }

    @Override
    public void doHitAfterEffects(LivingEntity living, LivingEntity owner) {
        living.hurtTime = 0;
        living.invulnerableTime = 0;
    }

    @Override
    public ParticleOptions getParticle() {
        return Sparticles.GORE_BULLET.get();
    }
}
