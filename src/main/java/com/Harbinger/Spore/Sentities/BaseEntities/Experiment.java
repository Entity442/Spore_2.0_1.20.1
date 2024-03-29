package com.Harbinger.Spore.Sentities.BaseEntities;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class Experiment extends Infected{
    public Experiment(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean canStarve() {
        return false;
    }

    @Override
    protected void addRegularGoals() {

    }

    @Override
    public boolean blockBreakingParameter(BlockState blockstate, BlockPos blockpos) {
        float value = blockstate.getDestroySpeed(this.level(),blockpos);
        return this.tickCount % 20 == 0 && value > 0 && value <=1;
    }
}
