package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class FallenAcidSack extends ThrowableItemProjectile {
    public FallenAcidSack(EntityType<? extends FallenAcidSack> type, Level level) {
        super(type, level);
    }

    public FallenAcidSack(Level level, LivingEntity entity) {
        super(Sentities.FALLEN_ACID_BULB.get(), entity, level);
    }

    public FallenAcidSack(Level level) {
        super(Sentities.FALLEN_ACID_BULB.get(), level);
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (level() instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(ParticleTypes.EXPLOSION_EMITTER,this.getX(),this.getY(),this.getZ(),3,0,0,0,1);
            AABB aabb = this.getBoundingBox().inflate(3);
            List<Entity> entities = level().getEntities(this,aabb);
            poisonTargets(entities);
        }
        playSound(Ssounds.FUNGAL_BOOM.get());
        discard();
    }

    public void poisonTargets(List<Entity> entityList){
        for (Entity entity : entityList){
            if (entity instanceof LivingEntity livingEntity && Utilities.TARGET_SELECTOR.Test(livingEntity)){
                livingEntity.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,1));
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON,200,1));
            }
        }
    }

    @Override
    protected boolean canHitEntity(Entity target) {
        return false;
    }

    @Override
    protected Item getDefaultItem() {
        return Sitems.ACID_BALL.get();
    }

}
