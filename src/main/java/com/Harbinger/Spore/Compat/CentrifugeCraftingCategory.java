package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Recipes.CentrifugeRecipe;
import com.Harbinger.Spore.Spore;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;


public class CentrifugeCraftingCategory implements IRecipeCategory<CentrifugeRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "centrifuge");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/gui/centrifuge_gui.png");
    public static final RecipeType<CentrifugeRecipe> CENTRIFUGE_TYPE =
            new RecipeType<>(UID, CentrifugeRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CentrifugeCraftingCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 176, 82).setTextureSize(176,166).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Sblocks.CENTRIFUGE.get()));
    }

    @Override
    public RecipeType<CentrifugeRecipe> getRecipeType() {
        return CENTRIFUGE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.spore.centrifuge");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CentrifugeRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT,  7, 8).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT , 7, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 8).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 26).addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 106, 44).addItemStack(recipe.getResultItem(null));
    }

}