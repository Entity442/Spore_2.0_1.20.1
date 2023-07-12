package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.Vec3;

public class SwimToBlockGoal extends MoveToBlockGoal {
    public SwimToBlockGoal(PathfinderMob mob, double speed, int range) {
        super(mob, speed, range);
    }
    public boolean requiresUpdateEveryTick() {
        return true;
    }


    @Override
    public boolean canUse() {
        return this.mob.isInFluidType() && !(this.mob instanceof WaterInfected);
    }

    @Override
    public boolean canContinueToUse() {
        return this.mob.isInWater() && this.tryTicks <= 600 && this.isValidTarget(this.mob.level() , this.blockPos);
    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 160 == 0;
    }

    @Override
    protected boolean isValidTarget(LevelReader reader, BlockPos pos) {
        return reader.isEmptyBlock(pos.above()) && reader.getBlockState(pos).canOcclude();
    }

}
