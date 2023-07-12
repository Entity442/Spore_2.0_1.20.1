package com.Harbinger.Spore.Sitems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class PlatedLeggings extends PlatedExoskeleton{
    public PlatedLeggings() {
        super(Type.LEGGINGS, new Properties());
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/armor/plated_layer_2.png";
    }
}
