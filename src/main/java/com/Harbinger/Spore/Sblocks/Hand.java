package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HangingRootsBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Hand extends HangingRootsBlock {
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public Hand() {
        super(Properties.of().strength(4f, 2f).noCollission().noOcclusion().sound(SoundType.SLIME_BLOCK).randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(ENABLED, Boolean.FALSE).setValue(BlockStateProperties.WATERLOGGED, Boolean.FALSE));
    }
    protected static final VoxelShape SHAPE = Block.box(2.0D, 4.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    public VoxelShape getShape(BlockState p_153342_, BlockGetter p_153343_, BlockPos p_153344_, CollisionContext p_153345_) {
        return SHAPE;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(ENABLED);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ENABLED).add(BlockStateProperties.WATERLOGGED);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if (!state.getValue(ENABLED)){
            level.setBlock(pos, Sblocks.HAND.get().defaultBlockState().setValue(ENABLED,true).setValue(ENABLED,true).setValue(BlockStateProperties.WATERLOGGED,false),3);
        }else {
            if (entity instanceof LivingEntity living && Utilities.TARGET_SELECTOR.Test(living)) {
                entity.makeStuckInBlock(state, new Vec3((double)0.4F, 0D, (double)0.4F));
            }
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        super.randomTick(state, serverLevel, pos, randomSource);
        if (Math.random() < 0.5f){
            serverLevel.setBlock(pos, Sblocks.HAND.get().defaultBlockState().setValue(ENABLED,false).setValue(BlockStateProperties.WATERLOGGED,false),3);
        }
    }
}
