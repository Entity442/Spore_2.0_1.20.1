package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Senchantments.SymbioticReconstitution;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Senchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

    public static final EnchantmentCategory FUNGAL_ITEMS =
            EnchantmentCategory.create("fungal_items",item -> {return Sitems.BIOLOGICAL_ITEMS.contains(item.asItem()) && item.canBeDepleted();});
    public static final RegistryObject<Enchantment> SYMBIOTIC_RECONSTITUTION = ENCHANTMENTS.register("symbiotic_reconstitution", SymbioticReconstitution::new);

}
