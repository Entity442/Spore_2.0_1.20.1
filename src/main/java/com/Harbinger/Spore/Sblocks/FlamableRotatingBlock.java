package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

public class FlamableRotatingBlock extends RotatedPillarBlock {
    public FlamableRotatingBlock(Properties p_55926_) {
        super(p_55926_);
    }


    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 5;
    }


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.is(Sblocks.ROTTEN_LOG.get());
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.2f && state.is(Sblocks.ROTTEN_LOG.get())) {
            tryPlaceLadderOnRandomFace(level, pos, random);
        }
    }

    private void tryPlaceLadderOnRandomFace( ServerLevel level, BlockPos pos, RandomSource random) {
        Direction[] directions = Direction.values();
        Direction randomDirection = directions[random.nextInt(directions.length)];
        if (randomDirection.equals(Direction.DOWN) || randomDirection.equals(Direction.UP)){
            return;
        }
        BlockPos targetPos = pos.relative(randomDirection);

        if (canPlaceFoliage(level, targetPos, randomDirection.getOpposite())) {
            Block block = BLOCKS.get(random.nextInt(BLOCKS.size()));
            BlockState ladderState = block.defaultBlockState()
                    .setValue(WallFolliage.FACING, randomDirection);
            level.setBlock(targetPos, ladderState, 3);
        }
    }
    private final List<Block> BLOCKS = List.of(Sblocks.WALL_GROWTHS.get(),Sblocks.WALL_GROWTHS_BIG.get(),Sblocks.WALL_GROWTHS_FLESHY.get());

    private boolean canPlaceFoliage(ServerLevel level, BlockPos pos, Direction attachedFace) {
        BlockState targetState = level.getBlockState(pos);
        if (!targetState.isAir() && !targetState.canBeReplaced()) {
            return false;
        }
        BlockPos attachedPos = pos.relative(attachedFace);
        BlockState attachedState = level.getBlockState(attachedPos);

        return attachedState.isFaceSturdy(level, attachedPos, attachedFace.getOpposite());
    }
}
