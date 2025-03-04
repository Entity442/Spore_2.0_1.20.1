package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Ssounds;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.RecordItem;

public class ForgottenRecord extends RecordItem {
    public ForgottenRecord() {
        super(0, Ssounds.FORGOTTEN_PATIENT, new Properties().stacksTo(1).rarity(Rarity.EPIC), 1100);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
