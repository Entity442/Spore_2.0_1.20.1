package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;

public class ReturnToWater extends MoveToBlockGoal {
    private static final int GIVE_UP_TICKS = 1200;
    private final PathfinderMob mob;

    public ReturnToWater(PathfinderMob mob, double speed) {
        super(mob ,speed, 24);
        this.mob = mob;
        this.verticalSearchStart = -1;
    }

    public boolean canContinueToUse() {
        return !this.mob.isInWater() && this.tryTicks <= 1200 && this.isValidTarget(this.mob.level(), this.blockPos);
    }

    public boolean canUse() {
            return (!this.mob.isInWater() && this.mob.getAirSupply() < this.mob.getMaxAirSupply()/2);
    }

    public boolean shouldRecalculatePath() {
        return this.tryTicks % 160 == 0;
    }

    protected boolean isValidTarget(LevelReader p_30270_, BlockPos p_30271_) {
        return p_30270_.getBlockState(p_30271_).is(Blocks.WATER);
    }
}