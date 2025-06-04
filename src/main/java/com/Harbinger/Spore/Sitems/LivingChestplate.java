package com.Harbinger.Spore.Sitems;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class LivingChestplate extends LivingExoskeleton implements CustomModelArmorData {
    private final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/armor/test.png");
    public LivingChestplate() {
        super(Type.CHESTPLATE);
    }
    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/entity/empty.png";
    }

    @Override
    public ResourceLocation getTextureLocation() {
        return TEXTURE;
    }
}