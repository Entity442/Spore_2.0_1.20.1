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
import net.minecraft.world.item.Items;

import java.util.List;

public class ZoaholicScreen extends AbstractContainerScreen<ZoaholicMenu> implements TutorialMenuMethods{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/zoaholic_gui.png");
    public ZoaholicScreen(ZoaholicMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 84;
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
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.BIOMASS.get()), leftPos + 34, topPos + 17);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.ZOAHOLIC.get()), leftPos + 79, topPos + 17);
        renderFakeItem(font,guiGraphics, new ItemStack(Items.PAPER), leftPos + 124, topPos + 17);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.CEREBRUM.get()), leftPos + 34, topPos + 62);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.INNARDS.get()), leftPos + 61, topPos + 62);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.INNARDS.get()), leftPos + 97, topPos + 62);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.MUTATED_HEART.get()), leftPos + 124, topPos + 62);
    }
}
