package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.PathNavigationRegion;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UndergroundPathNavigation extends GroundPathNavigation {

    public UndergroundPathNavigation(PathfinderMob mob, Level level) {
        super(mob, level);
    }

    @Override
    protected PathFinder createPathFinder(int maxNodes) {
        if (this.mob instanceof Hohlfresser hohlfresser && hohlfresser.canGoUnderground()){
            NodeEvaluator evaluator = new HohlfresserNodeEvaluator();
            evaluator.setCanPassDoors(true);
        }
        return super.createPathFinder(maxNodes);
    }

    @Override
    protected @NotNull Vec3 getTempMobPos() {
        return mob.position().add(0.0D, mob.getBbHeight() * 0.5D, 0.0D);
    }

    @Override
    protected boolean canUpdatePath() {
        if (mob.getTarget() == null) return false;
        BlockPos targetPos = mob.getTarget().blockPosition();
        return mob.distanceToSqr(targetPos.getX(), targetPos.getY(), targetPos.getZ()) > 4.0;
    }

    @Override
    protected boolean canMoveDirectly(Vec3 from, Vec3 to) {
        // If not underground, use default behavior
        if (!(this.mob instanceof Hohlfresser hohl) || !hohl.canGoUnderground()) {
            return super.canMoveDirectly(from, to);
        }

        // Raycast to check the path
        BlockHitResult hit = level.clip(new ClipContext(from, to, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, mob));
        BlockState state = level.getBlockState(hit.getBlockPos());

        // Only allow no-clip if the block is passable
        return !hohl.isColliding(hit.getBlockPos(), state);
    }

    @Override
    public boolean isStableDestination(BlockPos pos) {
        if (this.mob instanceof Hohlfresser hohlfresser && hohlfresser.canGoUnderground()){
            return hohlfresser.isColliding(pos,level.getBlockState(pos));
        }
        return super.isStableDestination(pos);
    }

    public static class HohlfresserNodeEvaluator extends NodeEvaluator {
        @Override
        public void prepare(PathNavigationRegion region, Mob mob) {
            super.prepare(region, mob);
        }

        @Override
        public void done() {
            // Clean up if needed
        }

        @Override
        public BlockPathTypes getBlockPathType(BlockGetter level, int x, int y, int z) {
            BlockPos pos = new BlockPos(x, y, z);
            BlockState state = level.getBlockState(pos);
            float hardness = state.getDestroySpeed(level, pos);

            // Allow tunneling through soft materials
            if (state.isAir() || (hardness >= 0 && hardness <= 3 &&
                    (state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_SHOVEL)))) {
                return BlockPathTypes.OPEN;
            }

            return BlockPathTypes.BLOCKED;
        }

        @Override
        public Node getStart() {
            BlockPos pos = this.mob.blockPosition();
            return getNode(pos.getX(), pos.getY(), pos.getZ());
        }

        @Override
        public Target getGoal(double x, double y, double z) {
            Node node = getNode((int) x,(int)y,(int)z);
            return new Target(node.x,node.y,node.z);
        }


        @Override
        public int getNeighbors(Node[] nodes, Node node) {
            return 0;
        }

        @Override
        public BlockPathTypes getBlockPathType(BlockGetter blockGetter, int x, int y, int z, Mob mob) {
            BlockPos pos = new BlockPos(x, y, z);
            BlockState state = level.getBlockState(pos);
            float hardness = state.getDestroySpeed(level, pos);

            if (state.isAir() || (
                    hardness >= 0 && hardness <= 3 &&
                            (state.is(BlockTags.MINEABLE_WITH_SHOVEL) || state.is(BlockTags.MINEABLE_WITH_PICKAXE)))) {
                return BlockPathTypes.OPEN;
            }
            return BlockPathTypes.BLOCKED;
        }

    }

}
