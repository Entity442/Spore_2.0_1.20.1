package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Spore;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.NodeEvaluator;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class UndergroundPathNavigation extends PathNavigation {
    public UndergroundPathNavigation(PathfinderMob mob, Level level) {
        super(mob, level);
    }

    @Override
    protected @NotNull PathFinder createPathFinder(int maxNodes) {
        NodeEvaluator evaluator = new HohlfresserNodeEvaluator();
        evaluator.setCanPassDoors(true);
        return new PathFinder(evaluator, maxNodes);
    }

    @Override
    protected @NotNull Vec3 getTempMobPos() {
        return mob.position().add(0.0D, mob.getBbHeight() * 0.5D, 0.0D);
    }

    @Override
    protected boolean canUpdatePath() {
        return this.mob.getTarget() != null || this.mob.getNavigation().isInProgress();
    }

    @Override
    protected boolean canMoveDirectly(Vec3 from, Vec3 to) {
        return true;
    }

    @Override
    public boolean isStableDestination(BlockPos pos) {
        return !level.getBlockState(pos).isAir() || level.getBlockState(pos).isSolidRender(level, pos);
    }

    public static class HohlfresserNodeEvaluator extends WalkNodeEvaluator {
        public static final TagKey<Block> BURROWABLE = BlockTags.create(new ResourceLocation( "spore:burrowable"));
        @Override
        public BlockPathTypes getBlockPathType(BlockGetter level, int x, int y, int z) {
            BlockPos pos = new BlockPos(x, y, z);
            BlockState state = level.getBlockState(pos);

            float hardness = state.getDestroySpeed(level, pos);
            if (hardness > SConfig.SERVER.calamity_bd.get() || hardness < 0 || !state.is(BURROWABLE)){
                return BlockPathTypes.BLOCKED;
            }
            return super.getBlockPathType(level, x, y, z);
        }
    }
}
