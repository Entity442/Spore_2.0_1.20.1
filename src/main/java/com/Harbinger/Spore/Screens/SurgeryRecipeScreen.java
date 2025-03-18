package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class SurgeryRecipeScreen extends AbstractContainerScreen<SurgeryRecipeMenu> implements TutorialMenuMethods{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/surgery_table_recipe_gui.png");
    private final List<Item> tagItems;
    private int currentTagIndex = 0;
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    private Button leftButton;
    private Button rightButton;
    private final List<SurgeryRecipe> recipes;
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "surgery");
    public SurgeryRecipeScreen(SurgeryRecipeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.tagItems = Utilities.getItemsFromTag(Spore.MODID, "stitches");
        this.imageWidth = 176;
        this.imageHeight = 84;
        ClientLevel level = Minecraft.getInstance().level;
        if (level == null){
            this.recipes = new ArrayList<>();
        }else {
            this.recipes = level.getRecipeManager().getAllRecipesFor(SurgeryRecipe.SurgeryRecipeType.INSTANCE);
        }
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
        int buttonY = topPos-20;
        int buttonX = leftPos+88;
        this.leftButton = addRenderableWidget(Button.builder(Component.literal("<"), button -> changeRecipe(-1))
                .bounds(buttonX-10, buttonY, 20, 20)
                .build()
        );

        this.rightButton = addRenderableWidget(Button.builder(Component.literal(">"), button -> changeRecipe(1))
                .bounds(buttonX+10, buttonY, 20, 20)
                .build()
        );
    }
    private void changeRecipe(int direction) {
        if (!recipes.isEmpty()) {
            currentItemIndex = (currentItemIndex + direction) % recipes.size();
        }
    }
    @Override
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShaderColor(1, 1, 1, 1);
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.setShaderTexture(0, TEXTURE);
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
        RenderSystem.disableBlend();
    }
    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, delta);
        renderTooltip(guiGraphics, mouseX, mouseY);
        SurgeryRecipe recipe = recipes.get(currentItemIndex);
        if (recipe == null){return;}
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(0)), 7, 8);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(1)), 7, 26);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(2)),7, 44);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(3)),7, 62);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(4)), 25, 8);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(5)), 25, 26);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(6)), 25, 44);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(7)), 25, 62);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(8)), 43, 8);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(9)), 43, 26);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(10)), 43, 44);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(11)), 43, 62);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(12)), 61, 8);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(13)), 61, 26);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(14)), 61, 44);
        renderFakeItem(font,guiGraphics,getItemStackFromIngredient(recipe.getIngredients().get(15)), 61, 62);

        renderFakeItem(font,guiGraphics,new ItemStack(tagItems.get(currentTagIndex)),  97, 8);
        ItemStack stack = recipe.getResultItem(null);
        if (stack.getItem() instanceof SporeWeaponData || stack.getItem() instanceof SporeArmorData){
            renderFakeItem(font,guiGraphics,currentTagIndex % 2 == 0 ? ItemStack.EMPTY : new ItemStack(Sitems.HARDENING_AGENT.get()), 115, 8);
            renderFakeItem(font,guiGraphics,currentTagIndex % 2 == 0 ? ItemStack.EMPTY : new ItemStack(Sitems.SHARPENING_AGENT.get()), 133, 8);
            renderFakeItem(font,guiGraphics,currentTagIndex % 2 == 0 ? ItemStack.EMPTY : new ItemStack(Sitems.INTEGRATING_AGENT.get()), 151, 8);
        }
        renderFakeItem(font,guiGraphics,stack, 124, 53);
    }

    private ItemStack getItemStackFromIngredient(Ingredient ingredient){
        ItemStack[] itemStacks = ingredient.getItems();
        return itemStacks.length > 0 ? itemStacks[0] : ItemStack.EMPTY;
    }

    @Override
    protected void containerTick() {
        super.containerTick();
        if (!tagItems.isEmpty()) {
            tickCounter++;
            if (tickCounter % 40 == 0) {
                currentTagIndex = (currentTagIndex + 1) % tagItems.size();
            }
        }
    }
}
