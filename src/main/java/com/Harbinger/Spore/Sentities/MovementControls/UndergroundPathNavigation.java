package com.Harbinger.Spore.Sentities.MovementControls;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class UndergroundPathNavigation extends GroundPathNavigation {
    @Nullable
    private BlockPos pathToPosition;
    public UndergroundPathNavigation(PathfinderMob mob, Level level) {
        super(mob, level);
    }

    @Override
    protected @NotNull PathFinder createPathFinder(int maxNodes) {
        NodeEvaluator evaluator = new HohlfresserNodeEvaluator();
        evaluator.setCanPassDoors(true);
        evaluator.canFloat();
        return new PathFinder(evaluator, maxNodes);
    }
    public Path createPath(BlockPos pos, int value) {
        this.pathToPosition = pos;
        return super.createPath(pos, value);
    }

    public Path createPath(Entity entity, int value) {
        this.pathToPosition = entity.blockPosition();
        return super.createPath(entity, value);
    }

    public boolean moveTo(Entity entity, double value) {
        Path path = this.createPath(entity, 0);
        if (path != null) {
            return this.moveTo(path, value);
        } else {
            this.pathToPosition = entity.blockPosition();
            this.speedModifier = value;
            return true;
        }
    }
    @Override
    protected @NotNull Vec3 getTempMobPos() {
        return mob.position().add(0.0D, mob.getBbHeight() * 0.5D, 0.0D);
    }

    @Override
    protected boolean canUpdatePath() {
        return this.mob.getTarget() != null && this.mob.getNavigation().isInProgress();
    }

    @Override
    public boolean isStableDestination(BlockPos pos) {
        if (this.mob instanceof Hohlfresser hohlfresser && hohlfresser.canGoUnderground()) {
            return hohlfresser.isColliding(pos, level.getBlockState(pos));
        }
        return super.isStableDestination(pos);
    }
    public void tick() {
        if (!this.isDone()) {
            super.tick();
        } else {
            if (this.pathToPosition != null) {
                if (!this.pathToPosition.closerToCenterThan(this.mob.position(), Math.max(this.mob.getBbWidth(), 1.0D)) && (!(this.mob.getY() > (double)this.pathToPosition.getY()) || !(new BlockPos(this.pathToPosition.getX(),(int) this.mob.getY(), this.pathToPosition.getZ())).closerToCenterThan(this.mob.position(), Math.max(this.mob.getBbWidth(), 1.0D)))) {
                    this.mob.getMoveControl().setWantedPosition(this.pathToPosition.getX(), this.pathToPosition.getY(), this.pathToPosition.getZ(), this.speedModifier);
                } else {
                    this.pathToPosition = null;
                }
            }

        }
    }
    public static class HohlfresserNodeEvaluator extends SwimNodeEvaluator {
        public HohlfresserNodeEvaluator() {
            super(true);
        }

        @Override
        public BlockPathTypes getBlockPathType(BlockGetter level, int x, int y, int z) {
            return BlockPathTypes.OPEN;
        }

        @Override
        public BlockPathTypes getBlockPathType(BlockGetter blockGetter, int x, int y, int z, Mob mob) {
            return getBlockPathType(blockGetter, x, y, z);
        }
    }
}
