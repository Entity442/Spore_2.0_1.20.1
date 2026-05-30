package com.Harbinger.Spore.Sentities.Projectile;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Sparticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;

import java.util.function.Predicate;

public class TarBall extends AbstractArrow {
    private static final EntityDataAccessor<Boolean> IGNITED = SynchedEntityData.defineId(TarBall.class, EntityDataSerializers.BOOLEAN);
    private Predicate<LivingEntity> target = livingEntity -> {return true;};
    public TarBall(Level level) {
        super(Sentities.TAR_BALL.get(),level);
    }

    public TarBall(EntityType<TarBall> acidBallEntityType, Level level) {
        super(acidBallEntityType, level);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IGNITED, false);
    }

    public TarBall(LivingEntity entity, Level world,Predicate<LivingEntity> predicate,float damage) {
        super(Sentities.TAR_BALL.get(),entity,world);
        this.target = predicate;
        this.setBaseDamage(damage);
    }

    public ItemStack getItem() {
        return ItemStack.EMPTY;
    }
    public void setIgnited(boolean val){
        entityData.set(IGNITED,val);
    }

    @Override
    public void tick() {
        super.tick();
        makeBile();
        if (entityData.get(IGNITED)){
            makeOre();
        }
    }
    private void makeBile(){
        for (int i = 0; i<8;i++){
            float movement1 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement2 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement3 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            level().addParticle( Sparticles.TAR.get(),this.getX()+movement1,this.getY()+movement2,this.getZ()+movement3,0,0,0);
        }
    }
    private void makeOre(){
        for (int i = 0; i<4;i++){
            float movement1 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement2 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            float movement3 = (this.random.nextFloat() - this.random.nextFloat()) * 0.5f;
            level().addParticle(ParticleTypes.SMALL_FLAME,this.getX()+movement1,this.getY()+movement2,this.getZ()+movement3,0,0,0);
        }
    }

    public void spreadTar(BlockPos blockPos,int range){
        boolean fire = entityData.get(IGNITED);
        for (int x = -range;x<range;x++){
            for (int y = -range;y<range;y++){
                for (int z = -range;z<range;z++){
                    BlockPos pos = blockPos.offset(x,y,z);
                    BlockState state = level().getBlockState(pos);
                    boolean fullBlockBelow = level().getBlockState(pos.below()).isSolidRender(level(),pos.below());
                    if (fullBlockBelow && state.isAir() && Math.random() < 0.75){
                        level().setBlock(pos,fire ? Blocks.FIRE.defaultBlockState() : Sblocks.TAR.get().defaultBlockState(),3);
                    }
                }
            }
        }
        discard();
    }

    protected void onHitBlock(BlockHitResult blockHitResult) {
        spreadTar(blockHitResult.getBlockPos(),2);
        discard();
    }

    @Override
    protected ItemStack getPickupItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult hitResult) {
        if (hitResult.getEntity() instanceof LivingEntity living && target.test(living)){
            spreadTar(living.blockPosition(),2);
            super.onHitEntity(hitResult);
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
