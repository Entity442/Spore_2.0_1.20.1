package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Spore;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Srecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Spore.MODID);

    public static final RegistryObject<RecipeSerializer<SurgeryRecipe>> SURGERY_SERIALIZER =
            SERIALIZERS.register("surgery", () -> SurgeryRecipe.SurgeryRecipeSerializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<InjectionRecipe>> INJECTION_SERIALIZER =
            SERIALIZERS.register("injection", () -> InjectionRecipe.InjectionRecipeSerializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
