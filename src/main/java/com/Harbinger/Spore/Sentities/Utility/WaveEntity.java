package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.AI.AOEMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class WaveEntity extends UtilityEntity {
    public PathfinderMob owner;
    private int life;
    public WaveEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    public WaveEntity(Level level,PathfinderMob entity){
        super(Sentities.WAVE.get(),level);
        this.owner = entity;
        this.life = 160;
        this.moveTo(owner.getX(),owner.getY(),owner.getZ());
        this.setTarget(owner.getTarget());
        this.setMaxUpStep(1);
    }


    @Override
    public void tick() {
        super.tick();
        if(life <= 0 || this.owner == null || this.getTarget() == null){
            this.discard();
        }else{
            life--;
        }
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AOEMeleeAttackGoal(this, 1.1,false,2,1));
        super.registerGoals();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 1)
                .add(Attributes.MOVEMENT_SPEED, 0.35)
                .add(Attributes.ATTACK_DAMAGE, 10)
                .add(Attributes.FOLLOW_RANGE, 16);
    }

    @Override
    public boolean hurt(DamageSource p_21016_, float p_21017_) {
        return false;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        BlockState block = level().getBlockState(this.getOnPos());
        Item item = block.getBlock().asItem();
        double x =this.getX() + this.random.nextInt(-2,2);
        double z =this.getZ() + this.random.nextInt(-2,2);
        if (item != ItemStack.EMPTY.getItem()  && this.level() instanceof ServerLevel serverLevel){
            serverLevel.sendParticles(new ItemParticleOption(ParticleTypes.ITEM,new ItemStack(item)),x,this.getY(),z,3,
                    ((double) this.random.nextFloat() - 1D) * 0.08D, ((double) this.random.nextFloat() - 1D) * 0.08D, ((double) this.random.nextFloat() - 1D) * 0.08D, 0.15F);
        }
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        entity.setDeltaMovement(entity.getDeltaMovement().add(0,0.1,0));
        this.discard();
        return super.doHurtTarget(entity);
    }
}
