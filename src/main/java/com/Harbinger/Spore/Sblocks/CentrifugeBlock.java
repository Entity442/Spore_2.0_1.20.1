package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.SblockEntities;
import com.Harbinger.Spore.SBlockEntities.CentrifugeBlockEntity;
import com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class CentrifugeBlock extends BaseEntityBlock implements SimpleWaterloggedBlock{
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final VoxelShape SHAPE = Block.box(0.1, 0, 0.1, 15.9, 16, 15.9);
    public CentrifugeBlock() {
        super(Properties.of().sound(SoundType.STONE).strength(6f, 20f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new CentrifugeBlockEntity(blockPos,blockState);
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof CentrifugeBlockEntity centrifugeBlockEntity) {
                Containers.dropContents(pLevel, pPos, centrifugeBlockEntity);
                pLevel.updateNeighbourForOutputSignal(pPos, this);
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof CentrifugeBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (CentrifugeBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState p_153274_, BlockEntityType<T> type) {
        return createSurgeryTicker(level, type, SblockEntities.CENTRIFUGE_ENTITY.get());
    }

    @javax.annotation.Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createSurgeryTicker(Level level, BlockEntityType<T> type, BlockEntityType<? extends CentrifugeBlockEntity> p_151990_) {
        return level.isClientSide ? createTickerHelper(type, p_151990_, CentrifugeBlockEntity::clientTick) : createTickerHelper(type, p_151990_, CentrifugeBlockEntity::serverTick);
    }

    public BlockState rotate(BlockState p_54360_, Rotation p_54361_) {
        return p_54360_.setValue(FACING, p_54361_.rotate(p_54360_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_54357_, Mirror p_54358_) {
        return p_54357_.rotate(p_54358_.getRotation(p_54357_.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        super.createBlockStateDefinition(stateBuilder);
        stateBuilder.add(FACING,WATERLOGGED);
    }
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
}
