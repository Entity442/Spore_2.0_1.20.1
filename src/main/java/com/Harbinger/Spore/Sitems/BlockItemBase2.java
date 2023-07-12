package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemBase2 extends BlockItem {
    public BlockItemBase2(Block block, Properties properties) {
        super(block, properties);
        Sitems.BIOLOGICAL_BLOCKS.add(this);
    }
}
