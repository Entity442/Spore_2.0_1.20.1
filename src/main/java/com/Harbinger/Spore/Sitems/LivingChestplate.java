package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Client.Models.CoreModel;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class LivingChestplate extends LivingExoskeleton implements CustomModelArmor{
    public LivingChestplate() {
        super(Type.CHESTPLATE, new Properties());
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return "spore:textures/armor/flesh_layer_1.png";
    }

    @Override
    public EntityModel<LivingEntity> getModel() {
        return new CoreModel<>();
    }

    @Override
    public ResourceLocation getCustomArmorTexture() {
        return new ResourceLocation(Spore.MODID,"textures/armor/infected_wing.png");
    }

}