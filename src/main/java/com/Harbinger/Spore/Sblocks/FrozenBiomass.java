package com.Harbinger.Spore.Sblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class FrozenBiomass extends FallingBlock {
    public static final BooleanProperty ENABLED = BlockStateProperties.ENABLED;
    public FrozenBiomass() {
        super(BlockBehaviour.Properties.of().strength(2f,2f).sound(SoundType.SLIME_BLOCK).randomTicks());
        this.registerDefaultState(this.stateDefinition.any().setValue(ENABLED, Boolean.TRUE));
    }


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(ENABLED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        super.randomTick(state, serverLevel, pos, randomSource);
        if (Math.random() < 0.1f){
            serverLevel.removeBlock(pos,false);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(ENABLED);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity entity, ItemStack stack) {
        super.setPlacedBy(level, pos, state, entity, stack);
        if (entity != null){
            state.setValue(ENABLED,false);
        }
    }
}
