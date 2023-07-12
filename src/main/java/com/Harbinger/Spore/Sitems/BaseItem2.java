package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.Item;

public class BaseItem2 extends Item {
    public BaseItem2(Properties properties) {
        super(properties);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
