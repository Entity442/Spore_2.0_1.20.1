package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

public class VomitHohlBall extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> ORES = SynchedEntityData.defineId(VomitHohlBall.class, EntityDataSerializers.BOOLEAN);
    public VomitHohlBall(Level level) {
        super(Sentities.VOMIT_BALL.get(),level);
    }

    public VomitHohlBall(EntityType<VomitHohlBall> acidBallEntityType, Level level) {
        super(acidBallEntityType, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ORES, false);
    }

    public VomitHohlBall(EntityType<VomitHohlBall> acidBallEntityType, LivingEntity entity, Level world) {
        super(acidBallEntityType,entity,world);
    }

    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }
    public void setOres(boolean val){
        entityData.set(ORES,val);
    }

    @Override
    public void tick() {
        super.tick();
        makeBile();
        if (entityData.get(ORES)){
            makeOre(new ItemStack(Math.random() < 0.5f ? Items.IRON_ORE : Items.COAL_ORE));
        }
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
    private void makeOre(ItemStack stack){
        for (int i = 0; i<4;i++){
            float movement1 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement2 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement3 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            ItemParticleOption option = new ItemParticleOption(ParticleTypes.ITEM,stack);
            level().addParticle(option,this.getX()+movement1,this.getY()+movement2,this.getZ()+movement3,0,0,0);
        }
    }


    public static VomitHohlBall shoot(Level world, LivingEntity entity, float power, double damage, int knockback,boolean ore) {
        VomitHohlBall entityarrow = new VomitHohlBall(Sentities.VOMIT_BALL.get(), entity, world);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        entityarrow.setOres(ore);
        world.addFreshEntity(entityarrow);
        return entityarrow;
    }

    public static VomitHohlBall shoot(LivingEntity entity, LivingEntity target, float damage) {
        VomitHohlBall entityarrow = new VomitHohlBall(Sentities.VOMIT_BALL.get(), entity, entity.level());
        double dx = target.getX() - entity.getX();
        double dy = target.getY() + target.getEyeHeight() - 2;
        double dz = target.getZ() - entity.getZ();
        entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 2, 4.0F);
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
        if (hitResult.getEntity() instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)){
            super.onHitEntity(hitResult);
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
