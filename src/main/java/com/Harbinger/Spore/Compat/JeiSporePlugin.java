package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Recipes.SurgeryRecipe;
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
}

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        Level level = Minecraft.getInstance().level;
        if (level != null){
            RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
            List<SurgeryRecipe> surgeryRecipes = recipeManager.getAllRecipesFor(SurgeryRecipe.SurgeryRecipeType.INSTANCE);
            registration.addRecipes(SurgeryCraftingCategory.SURGERY_TYPE, surgeryRecipes);
        }
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(SurgeryScreen.class, 88, 62, 20, 30,
                SurgeryCraftingCategory.SURGERY_TYPE);
    }
}
