package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Senchantments.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;

public class Senchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Spore.MODID);
    public static void register(IEventBus eventBus) {
        ENCHANTMENTS.register(eventBus);
    }

    public static final EnchantmentCategory FUNGAL_ITEMS =
            EnchantmentCategory.create("fungal_items", Item::canBeDepleted);


    public static final RegistryObject<Enchantment> SYMBIOTIC_RECONSTITUTION = ENCHANTMENTS.register("symbiotic_reconstitution", SymbioticReconstitution::new);
    public static final RegistryObject<Enchantment> CRYOGENIC_ASPECT = ENCHANTMENTS.register("cryogenic_aspect", CryogenicAspect::new);
    public static final RegistryObject<Enchantment> GASTRIC_SPEWAGE = ENCHANTMENTS.register("gastric_spewage", GastricSpewage::new);
    public static final RegistryObject<Enchantment> CORROSIVE_POTENCY = ENCHANTMENTS.register("corrosive_potency", CorrosivePotency::new);

    public static final RegistryObject<Enchantment> UNWAVERING_NATURE = ENCHANTMENTS.register("unwavering_nature", UnwaveringNature::new);
    public static final RegistryObject<Enchantment> MUTAGENIC_REACTANT = ENCHANTMENTS.register("mutagenic_reactant", MutagenicReactant::new);

}
