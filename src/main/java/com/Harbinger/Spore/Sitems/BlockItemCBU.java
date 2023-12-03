package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class BlockItemCBU extends BlockItem {
    public BlockItemCBU(Block block) {
        super(block, new Properties().stacksTo(1));
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
