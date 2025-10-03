package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sitems.Agents.ArmorSyringe;
import com.Harbinger.Spore.Sitems.Agents.WeaponSyringe;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorMutations;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeBaseArmor;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsBaseItem;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.joml.Quaternionf;

import java.util.ArrayList;
import java.util.List;

public class InjectionRecipeScreen extends AbstractContainerScreen<InjectionRecipeMenu> implements TutorialMenuMethods{
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Spore.MODID, "textures/gui/injection_recipe_gui.png");
    private final List<InjectionRecipe> recipes;
    private int tickCounter = 0;
    private int currentItemIndex = 0;
    private Button leftButton;
    private Button rightButton;
    private int getCurrentWeaponIndex = 0;
    private int getCurrentArmorIndex = 0;
    private final List<Item> weaponItems;
    private final List<Item> armorItems;
    ClientLevel level = Minecraft.getInstance().level;
    public InjectionRecipeScreen(InjectionRecipeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.weaponItems = Utilities.getItemsFromTag(Spore.MODID, "enchantable_weapon_items");
        this.armorItems = Utilities.getItemsFromTag(Spore.MODID, "enchantable_armor_items");
        this.imageWidth = 176;
        this.imageHeight = 84;
        if (level == null){
            this.recipes = new ArrayList<>();
        }else {
            this.recipes = level.getRecipeManager().getAllRecipesFor(InjectionRecipe.InjectionRecipeType.INSTANCE);
        }
    }
    private void changeRecipe(int direction) {
        if (!recipes.isEmpty()) {
            currentItemIndex = (currentItemIndex + direction) % recipes.size();
            getCurrentWeaponIndex = 0;
            getCurrentArmorIndex = 0;
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
        InjectionRecipe recipe = recipes.get(currentItemIndex);
        if (recipe == null){return;}
        ItemStack stack = recipe.getResultItem(null);
        renderFakeItem(font,guiGraphics,new ItemStack(Sitems.SYRINGE.get()), leftPos +97, topPos +17);
        renderFakeItem(font,guiGraphics,stack.copy(), leftPos +97, topPos +53);
        ItemStack weapon = new ItemStack(weaponItems.get(getCurrentWeaponIndex));
        ItemStack armor = new ItemStack(weaponItems.get(getCurrentWeaponIndex));
        ItemStack mutatedTool = getCurrentMutantConstruct(stack.copy(),weapon.copy(),armor.copy());
        if (!mutatedTool.equals(ItemStack.EMPTY)){
            renderFakeItem(font,guiGraphics,mutatedTool.copy(), leftPos +133, topPos +53);
        }
        if (stack.getItem() instanceof WeaponSyringe){
            renderFakeItem(font,guiGraphics,weapon.copy(), leftPos +133, topPos +17);
        }
        if (stack.getItem() instanceof ArmorSyringe){
            renderFakeItem(font,guiGraphics,armor.copy(), leftPos +133, topPos +17);
        }

        if (level != null){
            int variant = recipe.getEntityType();
            ResourceLocation location = new ResourceLocation(recipe.getEntityId());
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
    }
    public ItemStack getCurrentMutantConstruct(ItemStack stack,ItemStack weapon,ItemStack armor){
        if (stack.getItem() instanceof WeaponSyringe syringe){
            SporeToolsMutations mutations = syringe.getMutations();
            if (weapon.getItem() instanceof SporeToolsBaseItem sporeToolsBaseItem){
                sporeToolsBaseItem.setVariant(mutations,weapon);
                return weapon.copy();
            }
        }
        if (stack.getItem() instanceof ArmorSyringe syringe){
            SporeArmorMutations mutations = syringe.getMutations();
            if (armor.getItem() instanceof SporeBaseArmor sporeToolsBaseItem){
                sporeToolsBaseItem.setVariant(mutations,armor);
                return armor.copy();
            }
        }
        return ItemStack.EMPTY;
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
                getCurrentWeaponIndex = (getCurrentWeaponIndex + 1) % weaponItems.size();
                getCurrentArmorIndex = (getCurrentArmorIndex + 1) % armorItems.size();
            }
        }
    }
}
