package com.Harbinger.Spore.SBlockEntities;

import com.Harbinger.Spore.Core.SblockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HiveSpawnBlockEntity extends LivingStructureBlocks implements AnimatedEntity{
    public int ticks;

    public HiveSpawnBlockEntity(BlockPos pos, BlockState state) {
        super(SblockEntities.HIVE_SPAWN.get(), pos, state);
    }

    public static <E extends HiveSpawnBlockEntity> void clientTick(Level level, BlockPos pos, BlockState state, E e) {
        if (e.ticks <= 720){
            e.ticks++;
        }else{
            e.ticks = 0;
        }
    }
    @Override
    public int getTicks() {
        return ticks;
    }
}
