package com.Harbinger.Spore.Sentities.Projectile.GunProjectiles;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.ArmorPersentageBypass;
import com.Harbinger.Spore.Sentities.Projectile.AbstractGunProjectile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class AssassinBullet extends AbstractGunProjectile implements ArmorPersentageBypass {
    public AssassinBullet(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public SoundEvent blockImpactSound() {
        return Ssounds.ASSASSIN_BULLET_BLOCK.get();
    }

    @Override
    public SoundEvent entityImpactSound() {
        return Ssounds.ASSASSIN_BULLET_ENTITY.get();
    }

    @Override
    public float getMaxBlockRange() {
        return 200;
    }

    @Override
    public float getProDamage() {
        return 0.2f;
    }

    @Override
    public void doHitAfterEffects(LivingEntity living, LivingEntity owner) {
        living.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,1));
    }

    @Override
    public ParticleOptions getParticle() {
        return Sparticles.ACID_BULLET.get();
    }

    @Override
    public float amountOfDamage(float value) {
        return value * 0.5f;
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (level().isClientSide){
            return;
        }else {
            BlockPos pos = result.getBlockPos().above();
            if (level().getBlockState(pos).isAir()){
                level().setBlock(pos, Sblocks.ACID.get().defaultBlockState(),3);
            }
        }
    }
}
