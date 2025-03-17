package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Recipes.SurgeryRecipe;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.gui.components.Button;

import java.util.ArrayList;
import java.util.List;

public class SurgeryRecipeScreen extends AbstractContainerScreen<SurgeryRecipeMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/surgery_table_recipe_gui.png");
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    private Button leftButton;
    private Button rightButton;
    private final List<SurgeryRecipe> recipes;
    public static final ResourceLocation UID = new ResourceLocation(Spore.MODID, "surgery");
    public SurgeryRecipeScreen(SurgeryRecipeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
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
            if (currentItemIndex == recipes.size() && direction == 1){
                currentItemIndex = 0;
            }else if (currentItemIndex == 0 && direction == -1){
                currentItemIndex = recipes.size();
            }else {
                currentItemIndex = (currentItemIndex + direction);
            }
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
        renderFakeItem(guiGraphics, new ItemStack(Sitems.BIOMASS.get()), leftPos + 106, topPos + 8);
        renderFakeItem(guiGraphics, new ItemStack(Sitems.INCUBATOR.get()), leftPos + 79, topPos + 35);
    }
    private void renderFakeItem(GuiGraphics guiGraphics, ItemStack stack, int x, int y) {
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(this.font, stack, x, y);
    }
    private void renderFakeDamagedItem(GuiGraphics guiGraphics, ItemStack stack,int damage, int x, int y) {
        stack.setDamageValue(damage);
        guiGraphics.renderItem(stack, x, y);
        guiGraphics.renderItemDecorations(this.font, stack, x, y);
    }

}
