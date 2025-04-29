package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sitems.BaseWeapons.LootModifierWeapon;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class InfectedKnife extends SporeSwordBase implements LootModifierWeapon {
    public InfectedKnife() {
        super(SConfig.SERVER.knife_damage.get(), 0, -1, SConfig.SERVER.knife_durability.get());
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        if (ModList.get().isLoaded("farmersdelight")){
            Enchantment enchantment1 = ForgeRegistries.ENCHANTMENTS.getValue(new ResourceLocation("farmersdelight:backstabbing"));
            if (enchantment1 != null){
            return (super.canApplyAtEnchantingTable(stack, enchantment) || ImmutableSet.of(enchantment1).contains(enchantment))
                    && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);}
        }
        return (super.canApplyAtEnchantingTable(stack, enchantment)) && !ImmutableSet.of(Enchantments.MOB_LOOTING).contains(enchantment);
    }

    @Override
    public int getLootingLevel() {
        return 1;
    }
}
