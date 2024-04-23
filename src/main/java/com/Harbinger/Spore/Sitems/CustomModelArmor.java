package com.Harbinger.Spore.Sitems;

import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public interface CustomModelArmor {
    EntityModel<LivingEntity> getModel();
    ResourceLocation getCustomArmorTexture();
    boolean isFoil();
}
