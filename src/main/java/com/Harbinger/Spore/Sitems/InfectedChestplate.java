package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.Models.LivingChestplateModel;
import com.Harbinger.Spore.Client.Models.WingedChestplate;
import com.Harbinger.Spore.Spore;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class InfectedChestplate extends InfectedExoskeleton implements CustomModelArmor{
    public InfectedChestplate() {
        super(Type.CHESTPLATE, new Item.Properties());
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/armor/infected_wing.png";
    }
    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            @OnlyIn(Dist.CLIENT)
            public HumanoidModel getHumanoidArmorModel(LivingEntity living, ItemStack stack, EquipmentSlot slot, HumanoidModel defaultModel) {
                HumanoidModel armorModel = new HumanoidModel<>(new ModelPart(Collections.emptyList(), Map.of("body",
                        new LivingChestplateModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LivingChestplateModel.LAYER_LOCATION),true).body,
                        "left_arm",
                        new LivingChestplateModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LivingChestplateModel.LAYER_LOCATION),true).left_arm,
                        "right_arm",
                        new LivingChestplateModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LivingChestplateModel.LAYER_LOCATION),true).right_arm,
                        "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "hat",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()), "right_leg",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
                        new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
                armorModel.crouching = living.isShiftKeyDown();
                armorModel.riding = defaultModel.riding;
                armorModel.young = living.isBaby();
                return armorModel;
            }
        });
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if (Screen.hasShiftDown()){
            components.add(Component.translatable("item.armor.shift").withStyle(ChatFormatting.DARK_RED));
        } else {
            components.add(Component.translatable("item.armor.normal").withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }


    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        super.onArmorTick(stack, level, player);
        if (player.horizontalCollision && player.isCrouching()) {
            Vec3 initialVec = player.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            player.setDeltaMovement(climbVec.x * 0.91D,
                    climbVec.y * 0.98D, climbVec.z * 0.91D);
        }
    }

    @Override
    public EntityModel<LivingEntity> getModel() {
        return new LivingChestplateModel<>();
    }

    @Override
    public ResourceLocation getCustomArmorTexture() {
        return new ResourceLocation(Spore.MODID,"textures/armor/infected_wing.png");
    }

    @Override
    public boolean isFoil() {
        return false;
    }
}