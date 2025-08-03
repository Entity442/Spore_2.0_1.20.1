package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class VomitHohlBall extends AbstractArrow {

    public VomitHohlBall(Level level) {
        super(Sentities.VOMIT_BALL.get(),level);
    }

    public VomitHohlBall(EntityType<VomitHohlBall> acidBallEntityType, Level level) {
        super(acidBallEntityType, level);
    }

    public VomitHohlBall(EntityType<VomitHohlBall> acidBallEntityType, LivingEntity entity, Level world) {
        super(acidBallEntityType,entity,world);
    }

    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }


    @Override
    public void tick() {
        super.tick();
        if (this.inGround || this.isInFluidType())
            this.discard();
    }


    public static VomitHohlBall shoot(Level world, LivingEntity entity, float power, double damage, int knockback) {
        VomitHohlBall entityarrow = new VomitHohlBall(Sentities.VOMIT_BALL.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static VomitHohlBall shoot(LivingEntity entity, LivingEntity target, float damage) {
        VomitHohlBall entityarrow = new VomitHohlBall(Sentities.VOMIT_BALL.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 2;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 4, 16.0F);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(1);
        entity.level().addFreshEntity(entityarrow);

        return entityarrow;
    }

    protected void onHitBlock(BlockHitResult blockHitResult) {
        discard();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        super.onHitEntity(hitResult);
        if (hitResult.getEntity() instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
         addStuff(living);
        }
    }
    void addStuff(LivingEntity living){
        if (Math.random() < 0.1){living.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),100,1));}
        if (Math.random() < 0.1){for (MobEffectInstance instance : BileLiquid.bileEffects()){living.addEffect(instance);}}
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
