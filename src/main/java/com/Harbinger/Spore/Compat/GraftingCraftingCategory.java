package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Recipes.GraftingRecipe;
import com.Harbinger.Spore.SBlockEntities.SurgeryTableBlockEntity;
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
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class GraftingCraftingCategory implements IRecipeCategory<GraftingRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "surgery");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/gui/grafting_gui.png");
    public static final RecipeType<GraftingRecipe> GRAFTING_TYPE =
            new RecipeType<>(UID, GraftingRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public GraftingCraftingCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 176, 82).setTextureSize(176,166).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Sblocks.SURGERY_TABLE.get()));
    }

    @Override
    public RecipeType<GraftingRecipe> getRecipeType() {
        return GRAFTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.spore.surgery_table");
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
    public void setRecipe(IRecipeLayoutBuilder builder, GraftingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 8).addIngredients(recipe.getIngredients().get(SurgeryTableBlockEntity.GRATING_ITEM_ONE));
        builder.addSlot(RecipeIngredientRole.INPUT , 25, 35).addIngredients(recipe.getIngredients().get(SurgeryTableBlockEntity.GRATING_INGREDIENT));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 62).addIngredients(recipe.getIngredients().get(SurgeryTableBlockEntity.GRATING_ITEM_TWO));
        ItemStack stack = recipe.getResultItem(null);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 88, 35).addItemStack(stack);
    }

}