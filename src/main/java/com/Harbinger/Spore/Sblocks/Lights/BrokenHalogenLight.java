package com.Harbinger.Spore.Sblocks.Lights;

import com.Harbinger.Spore.Core.Sblocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class BrokenHalogenLight extends BaseHalogenLight{
    public BrokenHalogenLight() {
        super(Properties.of().strength(6, 4).randomTicks().sound(SoundType.GLASS));
    }


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }


    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        Block block = Sblocks.BROKEN_HALOGEN_LIGHT_ON.get();
        level.setBlock(pos, block.defaultBlockState(),3);
        level.updateNeighborsAt(pos, block);
        level.updateNeighborsAt(pos.below(), block);
        level.scheduleTick(pos, block, 20);

    }

}
