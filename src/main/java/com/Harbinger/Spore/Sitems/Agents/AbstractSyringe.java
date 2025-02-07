package com.Harbinger.Spore.Sitems.Agents;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseItem2;
import net.minecraft.world.item.Item;

public abstract class AbstractSyringe extends BaseItem2 {
    public AbstractSyringe() {
        super(new Item.Properties().stacksTo(16));
        Sitems.TINTABLE_ITEMS.add(this);
    }

    public abstract int getColor();

}
