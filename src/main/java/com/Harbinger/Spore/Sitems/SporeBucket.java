package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.level.material.Fluid;

import java.util.function.Supplier;

public class SporeBucket extends BucketItem {
    public SporeBucket(Supplier<? extends Fluid> supplier, Properties builder) {
        super(supplier, builder);
        Sitems.TECHNOLOGICAL_ITEMS.add(this);
    }
}
