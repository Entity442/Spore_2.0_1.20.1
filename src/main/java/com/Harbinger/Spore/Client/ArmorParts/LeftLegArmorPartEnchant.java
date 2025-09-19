package com.Harbinger.Spore.Client.ArmorParts;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.function.Supplier;

public class LeftLegArmorPartEnchant extends BaseArmorRenderingBit implements EnchantingPart{
    private final Enchantment enchantment;
    private final ResourceLocation location;
    public LeftLegArmorPartEnchant(Item item, Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand, Enchantment enchantment, ResourceLocation location) {
        super(EquipmentSlot.LEGS, item, model, part, x, y, z, expand);
        this.enchantment = enchantment;
        this.location = location;
    }

    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.leftLeg;
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }

    @Override
    public ResourceLocation getTexture() {
        return location;
    }
}
