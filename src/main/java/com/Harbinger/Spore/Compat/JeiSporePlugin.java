package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Recipes.GraftingRecipe;
import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Screens.InjectionScreen;
import com.Harbinger.Spore.Screens.SurgeryScreen;
import com.Harbinger.Spore.Spore;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;

import java.util.List;

@JeiPlugin
public class JeiSporePlugin implements IModPlugin {  @Override
public ResourceLocation getPluginUid() {
    return new ResourceLocation(Spore.MODID, "jei_plugin");
}

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new SurgeryCraftingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new InjectionCraftingCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new GraftingCraftingCategory(registration.getJeiHelpers().getGuiHelper()));
}

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Level level = Minecraft.getInstance().level;
        if (level != null){
            RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
            List<SurgeryRecipe> surgeryRecipes = recipeManager.getAllRecipesFor(SurgeryRecipe.SurgeryRecipeType.INSTANCE);
            List<InjectionRecipe> injectionRecipes = recipeManager.getAllRecipesFor(InjectionRecipe.InjectionRecipeType.INSTANCE);
            List<GraftingRecipe> grafting = recipeManager.getAllRecipesFor(GraftingRecipe.GraftingRecipeType.INSTANCE);
            registration.addRecipes(SurgeryCraftingCategory.SURGERY_TYPE, surgeryRecipes);
            registration.addRecipes(InjectionCraftingCategory.INJECTION_TYPE, injectionRecipes);
            registration.addRecipes(GraftingCraftingCategory.GRAFTING_TYPE, grafting);
        }
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SurgeryScreen.class, 88, 62, 20, 20,
                SurgeryCraftingCategory.SURGERY_TYPE);
        registration.addRecipeClickArea(InjectionScreen.class, 88, 62, 20, 20,
                InjectionCraftingCategory.INJECTION_TYPE);
    }
}
