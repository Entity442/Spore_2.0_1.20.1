
package com.Harbinger.Spore.Sitems;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlatedChestplate extends PlatedExoskeleton {
    public PlatedChestplate() {
        super(Type.CHESTPLATE);
    }
    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/entity/empty.png";
    }
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player entity) {
        if (entity.horizontalCollision && entity.isCrouching()) {
            Vec3 initialVec = entity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
            entity.setDeltaMovement(climbVec.x * 0.91D,
                    climbVec.y * 0.98D, climbVec.z * 0.91D);
        }
        super.onArmorTick(stack, level, entity);
    }
    @Override
    public void appendHoverText(ItemStack itemStack, @org.jetbrains.annotations.Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {

        if (Screen.hasShiftDown()){
            components.add(Component.translatable("item.armor.shift").withStyle(ChatFormatting.DARK_RED));
        } else {
            components.add(Component.translatable("item.armor.normal").withStyle(ChatFormatting.GOLD));
        }
        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }
}
