package com.Harbinger.Spore.Compat;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Spore;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Quaternionf;


public class InjectionCraftingCategory implements IRecipeCategory<InjectionRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "injection");
    public static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/gui/injection_gui.png");
    public static final RecipeType<InjectionRecipe> INJECTION_TYPE =
            new RecipeType<>(UID, InjectionRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public InjectionCraftingCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, 176, 82).setTextureSize(176,166).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Sitems.SYRINGE.get()));
    }

    @Override
    public RecipeType<InjectionRecipe> getRecipeType() {
        return INJECTION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("item.spore.syringe");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, InjectionRecipe injectionRecipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 97, 17).addIngredients(Ingredient.of(Sitems.SYRINGE.get()));
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 97, 53).addIngredients(Ingredient.of(injectionRecipe.getResultItem(null)));
    }

    @Override
    public void draw(InjectionRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        IRecipeCategory.super.draw(recipe, recipeSlotsView, guiGraphics, mouseX, mouseY);
        ClientLevel level = Minecraft.getInstance().level;
        if (level != null){
            ResourceLocation location = new ResourceLocation(recipe.getEntityId());
            Entity entity = ForgeRegistries.ENTITY_TYPES.getValue(location).create(level);
            if (entity instanceof LivingEntity living){
                if (living instanceof VariantKeeper keeper){
                    keeper.setVariant(recipe.getEntityType());
                    renderEntityInInventoryFollowsAngle(guiGraphics,34,70,20,0f,0f,living);
                }else{
                    renderEntityInInventoryFollowsAngle(guiGraphics,34,70,20,0f,0f,living);
                }
            }
        }
    }

    private void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
        Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
        Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
        pose.mul(cameraOrientation);
        float f2 = entity.yBodyRot;
        float f3 = entity.getYRot();
        float f4 = entity.getXRot();
        float f5 = entity.yHeadRotO;
        float f6 = entity.yHeadRot;
        entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
        entity.setYRot(180.0F + angleXComponent * 40.0F);
        entity.setXRot(-angleYComponent * 20.0F);
        entity.yHeadRot = entity.getYRot();
        entity.yHeadRotO = entity.getYRot();
        InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, pose, cameraOrientation, entity);
        entity.yBodyRot = f2;
        entity.setYRot(f3);
        entity.setXRot(f4);
        entity.yHeadRotO = f5;
        entity.yHeadRot = f6;
    }


}