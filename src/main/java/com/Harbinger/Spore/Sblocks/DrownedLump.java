package com.Harbinger.Spore.Sblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class DrownedLump extends GenericFoliageBlock{
    public static final BooleanProperty SHORT = BlockStateProperties.SHORT;
    public DrownedLump() {
        super(Properties.of().sound(SoundType.CROP)
                .strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK).randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(SHORT, Boolean.TRUE).setValue(SHORT, Boolean.TRUE));
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(WATERLOGGED).add(SHORT);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(SHORT);
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluid = context.getLevel().getFluidState(context.getClickedPos());

        if (fluid.getType() == Fluids.WATER) {
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, true)
                    .setValue(SHORT, true);
        }

        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        FluidState fluid = level.getFluidState(pos);
        return fluid.getType() == Fluids.WATER;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {

        BlockPos above = pos.above();
        FluidState fluidAbove = level.getFluidState(above);

        boolean hasWaterAbove = fluidAbove.getType() == Fluids.WATER;

        if (hasWaterAbove && state.getValue(SHORT)) {
            level.setBlock(pos, state.setValue(SHORT, false), 2);
        } else if (!hasWaterAbove && !state.getValue(SHORT)) {
            level.setBlock(pos, state.setValue(SHORT, true), 2);
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }
}
