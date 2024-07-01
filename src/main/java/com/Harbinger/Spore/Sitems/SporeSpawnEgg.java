package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeSpawnEggItem;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class SporeSpawnEgg extends ForgeSpawnEggItem {
    private final SpawnEggType type;

    public SporeSpawnEgg(Supplier<? extends EntityType<? extends Mob>> type, int backgroundColor, SpawnEggType type1) {
        super(type, backgroundColor, -1, new Item.Properties());
        this.type = type1;
        Sitems.BIOLOGICAL_ITEMS.add(this);
    }


    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(type.getName());
        super.appendHoverText(stack, level, components, flag);
    }
}
