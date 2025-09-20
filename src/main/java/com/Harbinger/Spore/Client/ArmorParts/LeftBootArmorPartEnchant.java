package com.Harbinger.Spore.Client.ArmorParts;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.List;
import java.util.function.Supplier;

public class LeftBootArmorPartEnchant extends BaseArmorRenderingBit implements EnchantingPart{
    private final Enchantment enchantment;
    private final ResourceLocation location;
    private final List<Item> blacklist;
    public LeftBootArmorPartEnchant(Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand, Enchantment enchantment, ResourceLocation location, List<Item> blacklist) {
        super(EquipmentSlot.FEET, null, model, part, x, y, z, expand);
        this.enchantment = enchantment;
        this.location = location;
        this.blacklist = blacklist;
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

    @Override
    public List<Item> blacklistedItems() {
        return blacklist;
    }
}
