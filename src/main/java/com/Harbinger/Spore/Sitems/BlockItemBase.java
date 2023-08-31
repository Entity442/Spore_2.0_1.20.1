package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemBase extends BlockItem {
    public BlockItemBase(Block block, Properties properties) {
        super(block, properties);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
