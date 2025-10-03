package com.Harbinger.Spore.Screens;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Recipes.InjectionRecipe;
import com.Harbinger.Spore.Sentities.VariantKeeper;
import com.Harbinger.Spore.Sitems.Agents.ArmorSyringe;
import com.Harbinger.Spore.Sitems.Agents.WeaponSyringe;
import com.Harbinger.Spore.Sitems.BaseWeapons.*;
import com.Harbinger.Spore.Sitems.BiologicalReagent;
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
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
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
    private int getCurrentItemIndex = 0;
    private int getCurrentReagentIndex = 0;
    private final List<Item> weaponItems;
    private final List<Item> armorItems;
    private final List<Item> allItems;
    private final List<Item> reagents;
    ClientLevel level = Minecraft.getInstance().level;
    public InjectionRecipeScreen(InjectionRecipeMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
        this.weaponItems = Utilities.getItemsFromTag(Spore.MODID, "enchantable_weapon_items");
        this.armorItems = Utilities.getItemsFromTag(Spore.MODID, "enchantable_armor_items");
        this.allItems = Utilities.getItemsFromTag(Spore.MODID, "enchantable_items");
        this.reagents = Utilities.getItemsFromTag(Spore.MODID, "reagents");
        this.imageWidth = 176;
        this.imageHeight = 166;
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
        renderName(guiGraphics,stack.getHoverName(),90,15);
        ItemStack weapon = new ItemStack(this.weaponItems.get(getCurrentWeaponIndex));
        ItemStack armor = new ItemStack(this.armorItems.get(getCurrentArmorIndex));
        ItemStack allItems = new ItemStack(this.allItems.get(getCurrentItemIndex));
        ItemStack reagent = new ItemStack(this.reagents.get(getCurrentReagentIndex));
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

        renderName(guiGraphics,reagent.getHoverName(),75,85);
        renderFakeItem(font,guiGraphics,reagent.copy(), leftPos +43, topPos +89);
        ItemStack compatTool = getCurrentReagentItem(reagent,weapon,armor,allItems);
        renderFakeItem(font,guiGraphics,compatTool.copy(), leftPos +43, topPos +125);
        ItemStack enchantedItem = getEnchantedType(reagent,compatTool);
        renderFakeItem(font,guiGraphics,enchantedItem.copy(), leftPos +79, topPos +125);
        Enchantment enchantment = this.Enchantment(reagent.copy());
        renderName(guiGraphics,enchantment.getFullname(1),90,155);
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
            if (weapon.getItem() instanceof SporeWeaponData sporeToolsBaseItem){
                sporeToolsBaseItem.setVariant(mutations,weapon);
                return weapon.copy();
            }
        }
        if (stack.getItem() instanceof ArmorSyringe syringe){
            SporeArmorMutations mutations = syringe.getMutations();
            if (armor.getItem() instanceof SporeArmorData sporeToolsBaseItem){
                sporeToolsBaseItem.setVariant(mutations,armor);
                return armor.copy();
            }
        }
        return ItemStack.EMPTY;
    }
    public ItemStack getCurrentReagentItem(ItemStack stack,ItemStack weapon,ItemStack armor,ItemStack both){
        if (stack.getItem() instanceof BiologicalReagent biologicalReagent){
           if (biologicalReagent.getType() == BiologicalReagent.AcceptedTypes.ALL_TYPES){
             return both.copy();
           }else if (biologicalReagent.getType() == BiologicalReagent.AcceptedTypes.WEAPON_TYPES){
               return weapon.copy();
           }else if (biologicalReagent.getType() == BiologicalReagent.AcceptedTypes.ARMOR_TYPES){
               return armor.copy();
           }
        }
        return ItemStack.EMPTY;
    }
    public ItemStack getEnchantedType(ItemStack stack,ItemStack tool){
        if (stack.getItem() instanceof BiologicalReagent biologicalReagent){
            tool.enchant(biologicalReagent.getAppliedEnchantment(),1);
            return tool;
        }
        return ItemStack.EMPTY;
    }
    public Enchantment Enchantment(ItemStack stack){
        if (stack.getItem() instanceof BiologicalReagent biologicalReagent){
            return biologicalReagent.getAppliedEnchantment();
        }
        return Enchantments.SHARPNESS;
    }
    private void renderName(GuiGraphics guiGraphics,Component name,int x,int y){
        int iconX = this.leftPos + x;
        int iconY = this.topPos + y;
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
                getCurrentWeaponIndex = (getCurrentWeaponIndex + 1) % weaponItems.size();
                getCurrentArmorIndex = (getCurrentArmorIndex + 1) % armorItems.size();
                getCurrentItemIndex = (getCurrentItemIndex + 1) % allItems.size();
            }
            if (tickCounter % 100 == 0){
                getCurrentReagentIndex = (getCurrentReagentIndex + 1) % reagents.size();
            }
        }
    }
}
