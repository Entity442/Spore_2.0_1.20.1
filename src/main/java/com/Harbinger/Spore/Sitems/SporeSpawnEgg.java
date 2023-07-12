package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class SporeSpawnEgg extends ForgeSpawnEggItem {

    public SporeSpawnEgg(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, Properties props) {
        super(type, backgroundColor, -1, props);
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }

}
