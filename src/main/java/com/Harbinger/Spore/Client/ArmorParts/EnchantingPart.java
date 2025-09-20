package com.Harbinger.Spore.Client.ArmorParts;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;

public interface EnchantingPart {
    Enchantment getEnchantment();
    ResourceLocation getTexture();
    List<Item> blacklistedItems();
}
