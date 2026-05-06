package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.AI.NeuralProcessing.Experimental.ExpPathFinder;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Objects;

public class CalamityPathNavigation extends GroundPathNavigation {
    static final float EPSILON = 1.0E-8F;
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

    protected boolean canMoveDirectly(Vec3 vec3, Vec3 vec31) {
        return isClearForMovementBetween(this.mob, vec3, vec31, true);
    }

    public void tick() {
        if (!this.isDone()) {
            super.tick();
            BlockPos vec3 = this.getTargetPos();
            if (vec3 != null){
                this.mob.getLookControl()
                        .setLookAt(vec3.getX(), vec3.getY(), vec3.getZ());
            }
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
        if (this.mob instanceof WaterInfected){
            this.nodeEvaluator = new WaterCalamityNodeEvaluator();
            this.nodeEvaluator.setCanPassDoors(true);
            return new ExpPathFinder(this.nodeEvaluator,value) {
                protected float distance(Node node, Node node1) {
                    return node.distanceManhattan(node1);
                }
            };
        }else if (this.mob instanceof FlyingInfected){
            this.nodeEvaluator = new AirCalamityNodeEvaluator();
            this.nodeEvaluator.setCanPassDoors(true);
            return new ExpPathFinder(this.nodeEvaluator,value) {
                protected float distance(Node node, Node node1) {
                    return node.distanceManhattan(node1);
                }
            };
        }else{
            this.nodeEvaluator = new CalamityNodeEvaluator();
            this.nodeEvaluator.setCanPassDoors(true);
            this.nodeEvaluator.canFloat();
            return new ExpPathFinder(this.nodeEvaluator, value) {
                protected float distance(Node node, Node node1) {
                    return node.distanceManhattan(node1);
                }
            };
        }
    }


    protected static class CalamityNodeEvaluator extends WalkNodeEvaluator{
        protected BlockPathTypes evaluateBlockPathType(BlockGetter getter, BlockPos pos, BlockPathTypes pathTypes) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(mob.level(), mob)){
                return pathTypes == BlockPathTypes.OPEN ? BlockPathTypes.BLOCKED : super.evaluateBlockPathType(getter, pos, pathTypes);
            }
            return BlockPathTypes.OPEN;
        }
    }

    protected static class AirCalamityNodeEvaluator extends FlyNodeEvaluator{
        protected BlockPathTypes evaluateBlockPathType(BlockGetter getter, BlockPos pos, BlockPathTypes pathTypes) {
            if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(mob.level(), mob)){
                return pathTypes == BlockPathTypes.OPEN ? BlockPathTypes.BLOCKED : super.evaluateBlockPathType(getter, pos, pathTypes);
            }
            return BlockPathTypes.OPEN;
        }
    }

    protected static class WaterCalamityNodeEvaluator extends SwimNodeEvaluator{
        public WaterCalamityNodeEvaluator() {
            super(true);
        }

        @Override
        public BlockPathTypes getBlockPathType(BlockGetter getter, int value, int value2, int value3) {
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockState blockstate1 = getter.getBlockState(blockpos$mutableblockpos);
            if (blockstate1.isPathfindable(getter,blockpos$mutableblockpos,PathComputationType.WATER)){
                return BlockPathTypes.WATER;
            }else if (blockstate1.isPathfindable(getter,blockpos$mutableblockpos,PathComputationType.LAND)){
                return BlockPathTypes.OPEN;
            }else {
                if (net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(mob.level(), mob)){
                    return BlockPathTypes.BLOCKED;
                }
            }
            return super.getBlockPathType(getter, value, value2, value3);
        }
    }

    @Override
    public boolean isStuck() {
        this.recomputePath();
        return super.isStuck();
    }

    @Deprecated
    public void hardStop() {
        this.path = null;
    }

    @Override
    protected void followThePath() {
        Path path = Objects.requireNonNull(this.path);
        Vec3 entityPos = this.getTempMobPos();
        int pathLength = path.getNodeCount();
        for (int i = path.getNextNodeIndex(); i < path.getNodeCount(); i++) {
            if (path.getNode(i).y != Math.floor(entityPos.y)) {
                pathLength = i;
                break;
            }
        }
        final Vec3 base = entityPos.add(-this.mob.getBbWidth() * 0.5F, 0.0F, -this.mob.getBbWidth() * 0.5F);
        final Vec3 max = base.add(this.mob.getBbWidth(), this.mob.getBbHeight(), this.mob.getBbWidth());
        if (
                this.tryShortcut(path, new Vec3(this.mob.getX(), this.mob.getY(), this.mob.getZ()), pathLength, base, max)
        ) {
            if (
                    this.isAt(path, 0.5F) || this.atElevationChange(path) && this.isAt(path, this.mob.getBbWidth() * 0.5F)
            ) {
                path.setNextNodeIndex(path.getNextNodeIndex() + 1);
            }
        }
        this.doStuckDetection(entityPos);
    }


    private boolean isAt(Path path, float threshold) {
        final Vec3 pathPos = path.getNextEntityPos(this.mob);
        return Mth.abs((float) (this.mob.getX() - pathPos.x)) < threshold && Mth.abs(
                (float) (this.mob.getZ() - pathPos.z)
        ) < threshold && Math.abs(this.mob.getY() - pathPos.y) < 1.0D;
    }

    private boolean atElevationChange(Path path) {
        final int curr = path.getNextNodeIndex();
        final int end = Math.min(path.getNodeCount(), curr + Mth.ceil(this.mob.getBbWidth() * 0.5F) + 1);
        final int currY = path.getNode(curr).y;
        for (int i = curr + 1; i < end; i++) {
            if (path.getNode(i).y != currY) {
                return true;
            }
        }
        return false;
    }

    private boolean tryShortcut(Path path, Vec3 entityPos, int pathLength, Vec3 base, Vec3 max) {
        for (int i = pathLength; --i > path.getNextNodeIndex();) {
            final Vec3 vec = path.getEntityPosAtNode(this.mob, i).subtract(entityPos);
            if (this.sweep(vec, base, max)) {
                path.setNextNodeIndex(i);
                return false;
            }
        }
        return true;
    }

    private boolean sweep(Vec3 vec, Vec3 base, Vec3 max) {
        float t = 0.0F;
        float max_t = (float) vec.length();
        if (max_t < EPSILON)
            return true;
        final float[] tr = new float[3];
        final int[] ldi = new int[3];
        final int[] tri = new int[3];
        final int[] step = new int[3];
        final float[] tDelta = new float[3];
        final float[] tNext = new float[3];
        final float[] normed = new float[3];
        for (int i = 0; i < 3; i++) {
            float value = element(vec, i);
            boolean dir = value >= 0.0F;
            step[i] = dir ? 1 : -1;
            float lead = element(dir ? max : base, i);
            tr[i] = element(dir ? base : max, i);
            ldi[i] = leadEdgeToInt(lead, step[i]);
            tri[i] = trailEdgeToInt(tr[i], step[i]);
            normed[i] = value / max_t;
            tDelta[i] = Mth.abs(max_t / value);
            float dist = dir ? (ldi[i] + 1 - lead) : (lead - ldi[i]);
            tNext[i] = tDelta[i] < Float.POSITIVE_INFINITY ? tDelta[i] * dist : Float.POSITIVE_INFINITY;
        }
        final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        do {
            // stepForward
            int axis = (tNext[0] < tNext[1]) ? ((tNext[0] < tNext[2]) ? 0 : 2) : ((tNext[1] < tNext[2]) ? 1 : 2);
            float dt = tNext[axis] - t;
            t = tNext[axis];
            ldi[axis] += step[axis];
            tNext[axis] += tDelta[axis];
            for (int i = 0; i < 3; i++) {
                tr[i] += dt * normed[i];
                tri[i] = trailEdgeToInt(tr[i], step[i]);
            }
            // checkCollision
            int stepx = step[0];
            int x0 = (axis == 0) ? ldi[0] : tri[0];
            int x1 = ldi[0] + stepx;
            int stepy = step[1];
            int y0 = (axis == 1) ? ldi[1] : tri[1];
            int y1 = ldi[1] + stepy;
            int stepz = step[2];
            int z0 = (axis == 2) ? ldi[2] : tri[2];
            int z1 = ldi[2] + stepz;
            for (int x = x0; x != x1; x += stepx) {
                for (int z = z0; z != z1; z += stepz) {
                    for (int y = y0; y != y1; y += stepy) {
                        BlockState block = this.level.getBlockState(pos.set(x, y, z));
                        if (!block.isPathfindable(level,new BlockPos(x,y,z),PathComputationType.AIR))
                            return false;
                    }
                    BlockPathTypes in = this.nodeEvaluator.getBlockPathType(level, x, y0, z);
                    float priority = this.mob.getPathfindingMalus(in);
                    if (priority < 0.0F || priority >= 8.0F)
                        return false;
                }
            }
        } while (t <= max_t);
        return true;
    }

    static int leadEdgeToInt(float coord, int step) {
        return Mth.floor(coord - step * EPSILON);
    }

    static int trailEdgeToInt(float coord, int step) {
        return Mth.floor(coord + step * EPSILON);
    }

    static float element(Vec3 v, int i) {
        return switch (i) {
            case 0 -> (float) v.x;
            case 1 -> (float) v.y;
            case 2 -> (float) v.z;
            default -> 0.0F;
        };
    }
}
