package com.Harbinger.Spore.Sentities.MovementControls.PathFinders;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.phys.Vec3;

public class CachedFlyingNavigation extends FlyingPathNavigation {

    private static final int REPATH_INTERVAL = 20;

    private int ticksSinceLastRepath = 0;
    private Vec3 cachedTargetVec = null;
    private double cachedSpeed = 1.0;

    public CachedFlyingNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    @Override
    protected PathFinder createPathFinder(int maxVisitedNodes) {
        this.nodeEvaluator = new CachedFlyNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        return new PathFinder(this.nodeEvaluator, maxVisitedNodes);
    }

    @Override
    public boolean moveTo(double x, double y, double z, double speed) {
        this.cachedTargetVec = new Vec3(x, y, z);
        this.cachedSpeed = speed;
        return super.moveTo(x, y, z, speed);
    }

    @Override
    public boolean moveTo(Entity entity, double speed) {
        this.cachedTargetVec = entity.position();
        this.cachedSpeed = speed;
        return super.moveTo(entity, speed);
    }

    @Override
    public boolean moveTo(Path path, double speed) {
        this.cachedSpeed = speed;
        return super.moveTo(path, speed);
    }


    @Override
    public void tick() {
        super.tick();

        if (cachedTargetVec == null) return;

        ticksSinceLastRepath++;

        boolean shouldRepath = this.isDone();

        if (ticksSinceLastRepath >= REPATH_INTERVAL) {
            shouldRepath = true;
        }

        if (this.path != null && !this.path.isDone()) {
            Vec3 end = this.path.getTarget().getCenter();
            if (end.distanceToSqr(this.mob.position()) < 2.0) {
                shouldRepath = true;
            }
        }

        if (shouldRepath) {
            ticksSinceLastRepath = 0;

            Path newPath = this.createPath(
                    BlockPos.containing(cachedTargetVec),
                    1
            );

            if (newPath != null) {
                this.moveTo(newPath, cachedSpeed);
            }
        }
    }

    @Override
    protected boolean canUpdatePath() {
        return true;
    }
}