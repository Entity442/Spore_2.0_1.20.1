package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class HiveSpawnBlockEntity extends LivingStructureBlocks {
    public HiveSpawnBlockEntity( BlockPos pos, BlockState state) {
        super(SblockEntities.HIVE_SPAWN.get(), pos, state);
    }

}
