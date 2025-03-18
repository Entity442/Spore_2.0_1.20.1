package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class CDUScreen extends AbstractContainerScreen<CDUMenu> implements TutorialMenuMethods{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/cdu_gui.png");
    private final List<StoreDouble> blockMap;
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    public CDUScreen(CDUMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 84;
        this.blockMap = fabricateBlocks();
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
    }

    private List<StoreDouble> fabricateBlocks(){
        List<StoreDouble> blocks = new ArrayList<>();
        for (String str : SConfig.DATAGEN.block_cleaning.get()){
            String[] string = str.split("\\|" );
            Block blockCon1 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[0]));
            Block blockCon2 = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(string[1]));
            if (blockCon1 != null && blockCon2 != null){
                blocks.add(new StoreDouble(blockCon1,blockCon2));
            }
        }
        return blocks;
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
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.CDU.get()), leftPos + 79, topPos + 44);
        renderFakeItem(font,guiGraphics, new ItemStack(Sitems.ICE_CANISTER.get()), leftPos + 61, topPos + 62);
        if (!blockMap.isEmpty()) {
            renderFakeItem(font,guiGraphics, new ItemStack(blockMap.get(currentItemIndex).value1),leftPos + 34, topPos + 44);
            renderFakeItem(font,guiGraphics, new ItemStack(blockMap.get(currentItemIndex).value2), leftPos + 124, topPos + 44);
        }
    }
    @Override
    protected void containerTick() {
        super.containerTick();
        if (!blockMap.isEmpty()) {
            tickCounter++;
            if (tickCounter % 40 == 0) {
                currentItemIndex = (currentItemIndex + 1) % blockMap.size();
            }
        }
    }

    record StoreDouble(Block value1, Block value2){}
}
