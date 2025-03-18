package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class ForsakenRecord extends RecordItem {
    public ForsakenRecord() {
        super(0, Ssounds.FORSAKEN_FUTURE, new Properties().stacksTo(1).rarity(Rarity.EPIC), 1200);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
