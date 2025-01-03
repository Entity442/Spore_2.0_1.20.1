package com.Harbinger.Spore.Core;

import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Spore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Srecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Spore.MODID);

    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, Spore.MODID);

    public static final RegistryObject<RecipeSerializer<SurgeryRecipe>> SURGERY =
            SERIALIZERS.register("surgery", () -> SurgeryRecipe.SurgeryRecipeSerializer.INSTANCE);

    public static final RegistryObject<RecipeType<SurgeryRecipe>> SURGERY_TYPE =
            RECIPE_TYPES.register("surgery", () -> new RecipeType<>() {
                @Override
                public String toString() {
                    return new ResourceLocation(Spore.MODID, "surgery").toString();
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
}
