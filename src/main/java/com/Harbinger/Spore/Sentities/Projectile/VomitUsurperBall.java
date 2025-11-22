package com.Harbinger.Spore.Sentities.Projectile;


import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;

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

public class VomitUsurperBall extends AbstractArrow {
    public VomitUsurperBall(Level level) {
        super(Sentities.USURPER_VOMIT_BALL.get(),level);
    }

    public VomitUsurperBall(EntityType<VomitUsurperBall> acidBallEntityType, Level level) {
        super(acidBallEntityType, level);
    }

    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }
    @Override
    public void tick() {
        super.tick();
        makeBile();
        if (this.inGround || this.isInFluidType())
            this.discard();
    }
    private void makeBile(){
        for (int i = 0; i<8;i++){
            float movement1 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement2 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement3 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            level().addParticle(Sparticles.VOMIT.get(),this.getX()+movement1,this.getY()+movement2,this.getZ()+movement3,0,0,0);
        }
    }


    public static VomitUsurperBall shoot(Level world, LivingEntity entity, float power, double damage) {
        VomitUsurperBall entityarrow = new VomitUsurperBall(Sentities.USURPER_VOMIT_BALL.get(), world);
        entityarrow.setOwner(entity);
        entityarrow.moveTo(entity.getX(), entity.getY()+1.2D ,entity.getZ());
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setBaseDamage(damage);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static VomitUsurperBall shoot(LivingEntity entity, LivingEntity target, float damage) {
        VomitUsurperBall entityarrow = new VomitUsurperBall(Sentities.USURPER_VOMIT_BALL.get(), entity.level());
        entityarrow.setOwner(entity);
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 2;
        double dz = target.getZ() - entity.getZ();
        entityarrow.moveTo(entity.getX(), entity.getY()+1.2D ,entity.getZ());
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2, 4.0F);
        entityarrow.setBaseDamage(damage);
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
        if (hitResult.getEntity() instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
            super.onHitEntity(hitResult);
            living.hurtTime = 0;
            living.invulnerableTime = 0;
            addStuff(living);
        }
    }
    void addStuff(LivingEntity living){
        MobEffectInstance instance = living.getEffect(Seffects.CORROSION.get());
        int amplifier = instance == null ? 0 : instance.getAmplifier()+1;
        living.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),200,amplifier));
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
