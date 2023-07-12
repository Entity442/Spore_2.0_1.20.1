package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.Item;

public class BaseItem extends Item {
    public BaseItem(Properties properties) {
        super(properties);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }
}
