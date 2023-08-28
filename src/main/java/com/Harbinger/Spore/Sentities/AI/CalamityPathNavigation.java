package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.*;
import net.minecraftforge.event.entity.EntityMobGriefingEvent;

import javax.annotation.Nullable;

public class CalamityPathNavigation extends GroundPathNavigation {
    protected final Calamity calamity;
    @Nullable
    private BlockPos pathToPosition;
    public CalamityPathNavigation(Calamity calamity, Level level) {
        super(calamity, level);
        this.calamity = calamity;
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


    @Override
    protected PathFinder createPathFinder(int value) {
        this.nodeEvaluator = new CalamityNodeEvaluator();
        this.nodeEvaluator.setCanPassDoors(true);
        this.nodeEvaluator.canFloat();
        return new PathFinder(this.nodeEvaluator, value) {
            protected float distance(Node node, Node node1) {
                return node.distanceManhattan(node1);
            }
        };
    }


    protected static class CalamityNodeEvaluator extends WalkNodeEvaluator{
        protected BlockPathTypes evaluateBlockPathType(BlockGetter getter, BlockPos pos, BlockPathTypes pathTypes) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(mob.level(), mob)){
                return pathTypes == BlockPathTypes.OPEN ? BlockPathTypes.BLOCKED : super.evaluateBlockPathType(getter, pos, pathTypes);
            }
            return BlockPathTypes.OPEN;
        }
    }

    @Override
    public boolean isStuck() {
        this.recomputePath();
        return super.isStuck();
    }
}
