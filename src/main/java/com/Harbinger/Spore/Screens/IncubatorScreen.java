package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class IncubatorScreen extends AbstractContainerScreen<IncubatorMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/incubator_gui.png");
    private final List<Item> tagItems;
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    public IncubatorScreen(IncubatorMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 84;
        this.tagItems = Utilities.getItemsFromTag(Spore.MODID, "weapons");
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
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
        if (!tagItems.isEmpty()) {
            ItemStack stack = new ItemStack(tagItems.get(currentItemIndex));
            int damage = stack.getMaxDamage();
            renderFakeDamagedItem(guiGraphics, stack, damage/2,leftPos + 34, topPos + 35);
            renderFakeDamagedItem(guiGraphics, stack, damage/8,leftPos + 133, topPos + 35);
        }
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

    @Override
    protected void containerTick() {
        super.containerTick();
        if (!tagItems.isEmpty()) {
            tickCounter++;
            if (tickCounter % 40 == 0) {
                currentItemIndex = (currentItemIndex + 1) % tagItems.size();
            }
        }
    }
}
