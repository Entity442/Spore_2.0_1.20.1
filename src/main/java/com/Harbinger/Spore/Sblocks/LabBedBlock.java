package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Collections;
import java.util.List;

public class LabBedBlock extends HorizontalDirectionalBlock {
    public static final EnumProperty<TablePart> PART = EnumProperty.create("part", TablePart.class);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public LabBedBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.STONE).strength(6f, 20f));
        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(PART, TablePart.BOTTOM));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return Shapes.or(box(0.1D, 0.1D, 0.1D, 15.9D, 15.9D, 15.9D));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction facing = context.getHorizontalDirection();
        BlockPos pos = context.getClickedPos();
        Level level = context.getLevel();

        BlockPos offsetPos = pos.relative(facing);

        if (!level.getBlockState(offsetPos).canBeReplaced(context)) {
            return null; // Cancel placement if space is not clear
        }

        return this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(PART, TablePart.BOTTOM);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        Direction facing = state.getValue(FACING);
        BlockPos otherPos = pos.relative(facing);

        BlockState otherState = this.defaultBlockState()
                .setValue(FACING, facing)
                .setValue(PART, TablePart.TOP);

        level.setBlock(otherPos, otherState, 3);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TablePart part = state.getValue(PART);
            Direction facing = state.getValue(FACING);
            BlockPos otherPartPos = (part == TablePart.BOTTOM)
                    ? pos.relative(facing)
                    : pos.relative(facing.getOpposite());

            if (level.getBlockState(otherPartPos).getBlock() == this) {
                level.destroyBlock(otherPartPos, false);
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING,PART);
    }

    public enum TablePart implements StringRepresentable {
        TOP("top"),
        BOTTOM("bottom");

        private final String name;

        TablePart(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        if (state.getValue(PART) == TablePart.BOTTOM) {
            return super.getDrops(state, builder);
        }
        return Collections.emptyList();
    }
}
