package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class CorruptedRecord extends RecordItem {
    public CorruptedRecord() {
        super(0, Ssounds.CORRUPTED_RECORD, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 1680);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
