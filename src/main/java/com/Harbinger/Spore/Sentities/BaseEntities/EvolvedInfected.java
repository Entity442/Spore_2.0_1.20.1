package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class EvolvedInfected extends Infected {
    public EvolvedInfected(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        return super.blockBreakingParameter(blockstate, blockpos) || biomass().contains(blockstate);
    }

    @Override
    protected boolean canRide(Entity entity) {
        if (entity instanceof Infected || entity instanceof UtilityEntity){
            return super.canRide(entity);
        }
        return false;
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(this.level().getDifficulty() == Difficulty.HARD && amount > getDamageCap()){
            return super.hurt(source, (float) getDamageCap());
        }
        return super.hurt(source, amount);
    }
    public double getDamageCap(){
        return 15;
    }

    @Override
    public boolean canStarve() {
        return false;
    }


    @Override
    public boolean removeWhenFarAway(double p_21542_) {
        return this.getLinked() && !(this instanceof Scamper);
    }
}
