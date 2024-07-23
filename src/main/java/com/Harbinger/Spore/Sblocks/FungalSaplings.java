package com.Harbinger.Spore.Sblocks;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class FungalSaplings extends GenericFoliageBlock {


    public FungalSaplings() {
        super(BlockBehaviour.Properties.of().sound(SoundType.CROP)
                .strength(0f, 0f).noCollission().noOcclusion().sound(SoundType.CROP).randomTicks());
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (state.is(Sblocks.FUNGAL_STEM_SAPLING.get())){
            int f = randomSource.nextInt(2,5);
            for (int i = 0; i < f; ++i){
                BlockState blockState = level.getBlockState(pos.above(i));
                if (blockState.isAir() || blockState.is(Sblocks.FUNGAL_STEM_SAPLING.get())){
                    BlockPos blockPos = new BlockPos(pos.getX(),pos.getY() + i,pos.getZ());
                    level.setBlock(blockPos,Sblocks.FUNGAL_STEM.get().defaultBlockState(),3);
                }
            }
            for (int i = 0; i < f + 1; ++i){
                BlockState blockState = level.getBlockState(pos.above(i));
                BlockState blockState1 = level.getBlockState(pos.above(i+1));
                if (blockState.is(Sblocks.FUNGAL_STEM.get()) && !blockState1.is(Sblocks.FUNGAL_STEM.get()) ){
                    level.setBlock(pos.above(i),Sblocks.FUNGAL_STEM_TOP.get().defaultBlockState(),3);
                }
            }
        }
    }

}
