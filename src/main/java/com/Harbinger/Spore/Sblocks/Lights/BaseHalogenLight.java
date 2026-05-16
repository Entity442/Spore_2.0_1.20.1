package com.Harbinger.Spore.Sblocks.Lights;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseHalogenLight extends Block {
    public BaseHalogenLight(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        {
            return box(0, 12, 0, 16, 16, 16);
        }
    }
    protected boolean isPoweredVariant(BlockState state) {
        return state.getBlock() instanceof HalogenLightOn;
    }

    protected Block getOnBlock() {
        return Sblocks.HALOGEN_LIGHT_ON.get();
    }

    protected Block getOffBlock() {
        return Sblocks.HALOGEN_LIGHT.get();
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos,
                                Block block, BlockPos fromPos, boolean moving) {

        if (level.isClientSide) return;

        if (state.is(Sblocks.BROKEN_HALOGEN_LIGHT_ON.get()) || state.is(Sblocks.BROKEN_HALOGEN_LIGHT.get())){
            return;
        }

        boolean hasSignal = level.hasNeighborSignal(pos);
        boolean isCurrentlyOn = isPoweredVariant(state);

        if (hasSignal && !isCurrentlyOn) {
            turnOn(level, pos);
        }
        else if (!hasSignal && isCurrentlyOn) {
            turnOff(level, pos);
        }
    }

    private void turnOn(Level level, BlockPos startPos) {
        Block block = getOnBlock();
        level.updateNeighborsAt(startPos, block);
        level.updateNeighborsAt(startPos.below(), block);
        level.setBlock(startPos,block.defaultBlockState(),3);
    }

    private void turnOff(Level level, BlockPos startPos) {
        Block block = getOffBlock();
        level.updateNeighborsAt(startPos, block);
        level.updateNeighborsAt(startPos.below(), block);
        level.setBlock(startPos,block.defaultBlockState(),3);
    }

}
