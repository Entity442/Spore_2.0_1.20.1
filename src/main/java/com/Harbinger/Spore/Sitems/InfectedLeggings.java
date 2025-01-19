package com.Harbinger.Spore.Sitems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class InfectedLeggings extends InfectedExoskeleton{
    public InfectedLeggings() {
        super(Type.LEGGINGS);
    }
    @Override
    public @Nullable String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return GET_LOCATION_2.get(getVariant(stack));
    }
}
