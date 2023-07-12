package com.Harbinger.Spore.Srecipes;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Core.Spotion;
import com.Harbinger.Spore.ExtremelySusThings.QualityBrewingRecipe;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Recipes {
    @SubscribeEvent
    public static void create(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            BrewingRecipeRegistry.addRecipe(new QualityBrewingRecipe(Potions.WATER , Sitems.MUTATED_FIBER.get(), Spotion.MYCELIUM_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new QualityBrewingRecipe(Potions.WATER , Sitems.ALVEOLIC_SACK.get(), Spotion.MARKER_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new QualityBrewingRecipe(Potions.POISON , Sitems.CORROSIVE_SACK.get(), Spotion.CORROSION_POTION.get()));
            BrewingRecipeRegistry.addRecipe(new QualityBrewingRecipe(Spotion.CORROSION_POTION.get() , Sitems.INNARDS.get(), Spotion.CORROSION_POTION_STRONG.get()));
        });

    }

}


