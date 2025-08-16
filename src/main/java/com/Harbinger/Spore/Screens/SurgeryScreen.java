package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.ExtremelySusThings.Package.OpenGraftingScreenPacket;
import com.Harbinger.Spore.ExtremelySusThings.SporePacketHandler;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;

public class SurgeryScreen extends AbstractContainerScreen<SurgeryMenu> {
    private InvisibleButton invisibleButton;
    private InvisibleButton invisibleButton2;
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/surgery_table_gui.png");

    public SurgeryScreen(SurgeryMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void init() {
        super.init();
        this.inventoryLabelY = 10000;
        this.titleLabelY = 10000;
        int buttonX = this.width / 2 - 50;
        int buttonY = this.height / 2 - 20;
        if (!ModList.get().isLoaded("jei")){
            this.invisibleButton = addRenderableWidget(new InvisibleButton(
                    buttonX + 50, buttonY, 20, 20, Component.literal(""),
                    button -> {
                        if (Minecraft.getInstance().cameraEntity instanceof Player player) {
                            SurgeryRecipeMenu menu1 = new SurgeryRecipeMenu(1, player.getInventory());
                            Minecraft.getInstance().setScreen(new SurgeryRecipeScreen(menu1, player.getInventory(),
                                    Component.translatable("block.spore.surgery_table")));}

                    },(btn) -> Component.literal("Go To Recipes")));
        }
        this.invisibleButton = addRenderableWidget(new InvisibleButton(
                buttonX + 142, buttonY, 20, 20, Component.literal(""),
                button -> {
                    if (Minecraft.getInstance().cameraEntity instanceof Player player) {
                        BlockPos pos = menu.blockEntity.getBlockPos();
                        SporePacketHandler.sendToServer(new OpenGraftingScreenPacket(pos,player.getId()));
                    }

                },(btn) -> Component.literal("Go To Recipes")));
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
    }
}
