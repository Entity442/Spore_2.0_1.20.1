package com.Harbinger.Spore.Sentities.Projectile.GunProjectiles;

import com.Harbinger.Spore.Sentities.Projectile.AbstractGunProjectile;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import java.util.ArrayList;
import java.util.List;

public class ToxinBullet extends AbstractGunProjectile {

    public ToxinBullet(EntityType<? extends AbstractArrow> entityType, Level level) {
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
        return 32;
    }

    @Override
    public float getProDamage() {
        return 0.05f;
    }


    @Override
    public void doHitAfterEffects(LivingEntity living, LivingEntity owner) {
        AABB aabb = this.getBoundingBox().inflate(8);
        List<Entity> entityList = level().getEntities(this,aabb,entity -> {return entity != getOwner() && entity instanceof LivingEntity;});
        SporeToolsMutations mutations = this.getMutationVariant();
        for (Entity entity : entityList){
            if (entity instanceof LivingEntity livingEntity){
                livingEntity.addEffect(mutations == SporeToolsMutations.ROTTEN ? new MobEffectInstance(MobEffects.POISON,200,3) : new MobEffectInstance(MobEffects.POISON,100,1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,100,1));
                if (mutations == SporeToolsMutations.ROTTEN){
                    livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON,100,1));
                }
            }
        }
        if (level().isClientSide){
            int i = this.getMutationVariant().getColor();
            float r = (float) (i >> 16 & 255) / 255.0F;
            float g = (float) (i >> 8 & 255) / 255.0F;
            float b = (float) (i & 255) / 255.0F;
            int tries = random.nextInt(10,25);
            for (int u = 0; u<tries; u++){
                float x = (random.nextFloat()-random.nextFloat()) * 4;
                float z = (random.nextFloat()-random.nextFloat()) * 4;
                level().addParticle(getParticle(),this.getX()+x,this.getY(),this.getZ()+z,r,g,b);
            }
        }
    }


    @Override
    public ParticleOptions getParticle() {
        return Sparticles.TOXIN_BULLET.get();
    }
}
