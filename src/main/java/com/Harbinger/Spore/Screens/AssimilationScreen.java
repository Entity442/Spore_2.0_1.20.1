package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Recipes.WombRecipe;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

public class AssimilationScreen extends AbstractContainerScreen<AssimilationMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/assimilation_gui.png");
    private final List<WombRecipe> recipes;
    private List<WombRecipe.Pair> mobPairs;
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    private Button leftButton;
    private Button rightButton;
    private int currentEntityIndex = 0;
    ClientLevel level = Minecraft.getInstance().level;
    public AssimilationScreen(AssimilationMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.imageWidth = 176;
        this.imageHeight = 166;
        if (level == null){
            this.recipes = new ArrayList<>();
        }else {
            this.recipes = level.getRecipeManager().getAllRecipesFor(WombRecipe.WombRecipeType.INSTANCE);
        }
    }
    private void changeRecipe(int direction) {
        if (!recipes.isEmpty()) {
            currentItemIndex = (currentItemIndex + direction) % recipes.size();
            currentEntityIndex = 0;
            if (currentItemIndex < 0) {
                currentItemIndex += recipes.size();
            }
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
        int x = this.leftPos+34;
        int y = this.topPos+70;
        renderTooltip(guiGraphics, mouseX, mouseY);
        WombRecipe recipe = recipes.get(currentItemIndex);
        if (recipe == null){return;}
        this.mobPairs = recipe.getEntityPairs();
        if (level != null){
            WombRecipe.Pair pairs = mobPairs.get(currentEntityIndex);
            int variant = pairs.type();
            ResourceLocation location = new ResourceLocation(pairs.entityId());
            Entity entity = ForgeRegistries.ENTITY_TYPES.getValue(location).create(level);
            if (entity instanceof LivingEntity living){
                if (living instanceof VariantKeeper keeper){
                    keeper.setVariant(variant);
                    renderEntityInInventoryFollowsAngle(guiGraphics,x,y,20,0f,0f,living);
                }else{
                    renderEntityInInventoryFollowsAngle(guiGraphics,x,y,20,0f,0f,living);
                }
            }
        }
        renderIcon(guiGraphics,recipe.getIcon());
        renderName(guiGraphics,recipe.getAttribute());
    }
    private void renderIcon(GuiGraphics guiGraphics,ResourceLocation iconLocation){
        RenderSystem.setShaderTexture(0, iconLocation);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.enableBlend();
        int iconX = this.leftPos + 100;
        int iconY = this.topPos + 30;
        int iconWidth = 32;
        int iconHeight = 32;
        guiGraphics.blit(iconLocation, iconX, iconY, 0, 0, iconWidth, iconHeight, iconWidth, iconHeight);
        RenderSystem.disableBlend();
    }
    private void renderName(GuiGraphics guiGraphics,String attributeName){
        String[] strings = attributeName.split(":");
        Component name = Component.translatable("attribute.name.spore."+strings[1]);
        int iconX = this.leftPos + 100;
        int iconY = this.topPos + 25;
        int iconWidth = 32;
        int textX = iconX + (iconWidth / 2) - (font.width(name) / 2);
        int textY = iconY - 10;
        guiGraphics.drawString(this.font, name, textX, textY, 0xFFFFFF, true);
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

    @Override
    protected void containerTick() {
        super.containerTick();
        if (!recipes.isEmpty()) {
            tickCounter++;
            if (tickCounter % 40 == 0) {
                currentEntityIndex = (currentEntityIndex + 1) % mobPairs.size();
            }
        }
    }
}
