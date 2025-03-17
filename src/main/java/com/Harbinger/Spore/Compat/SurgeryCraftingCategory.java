package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Core.Sblocks;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
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
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;


public class SurgeryCraftingCategory implements IRecipeCategory<SurgeryRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "surgery");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/gui/surgery_table_gui.png");
    public final TagKey<Item> stringLikeItem = ItemTags.create(new ResourceLocation("spore:stitches"));
    public Ingredient stiches = Ingredient.of(new ItemStack(ForgeRegistries.ITEMS.tags().getTag(stringLikeItem).getRandomElement(RandomSource.create()).orElse(Items.STRING)));

    public static final RecipeType<SurgeryRecipe> SURGERY_TYPE =
            new RecipeType<>(UID, SurgeryRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public SurgeryCraftingCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 176, 82).setTextureSize(176,166).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Sblocks.SURGERY_TABLE.get()));
    }

    @Override
    public RecipeType<SurgeryRecipe> getRecipeType() {
        return SURGERY_TYPE;
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
    public void setRecipe(IRecipeLayoutBuilder builder, SurgeryRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 8).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT , 7, 26).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 44).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 7, 62).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 8).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 26).addIngredients(recipe.getIngredients().get(5));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 44).addIngredients(recipe.getIngredients().get(6));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 62).addIngredients(recipe.getIngredients().get(7));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 8).addIngredients(recipe.getIngredients().get(8));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 26).addIngredients(recipe.getIngredients().get(9));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 44).addIngredients(recipe.getIngredients().get(10));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 62).addIngredients(recipe.getIngredients().get(11));
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 8).addIngredients(recipe.getIngredients().get(12));
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 26).addIngredients(recipe.getIngredients().get(13));
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 44).addIngredients(recipe.getIngredients().get(14));
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 62).addIngredients(recipe.getIngredients().get(15));
        builder.addSlot(RecipeIngredientRole.CATALYST, 97, 8).addIngredients(stiches);
        ItemStack stack = recipe.getResultItem(null);
        if (stack.getItem() instanceof SporeWeaponData || stack.getItem() instanceof SporeArmorData){
            builder.addSlot(RecipeIngredientRole.CATALYST, 115, 8).addIngredients(Math.random() < 0.5f ? Ingredient.EMPTY : Ingredient.of(Sitems.HARDENING_AGENT.get()));
            builder.addSlot(RecipeIngredientRole.CATALYST, 133, 8).addIngredients(Math.random() < 0.5f ? Ingredient.EMPTY : Ingredient.of(Sitems.SHARPENING_AGENT.get()));
            builder.addSlot(RecipeIngredientRole.CATALYST, 151, 8).addIngredients(Math.random() < 0.5f ? Ingredient.EMPTY : Ingredient.of(Sitems.INTEGRATING_AGENT.get()));
        }
        builder.addSlot(RecipeIngredientRole.OUTPUT, 124, 53).addItemStack(stack);
    }

}