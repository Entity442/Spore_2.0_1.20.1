package com.Harbinger.Spore.Client.ArmorParts;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class BodyArmorPart extends BaseArmorRenderingBit{

    public BodyArmorPart(Item item, Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand) {
        super(EquipmentSlot.CHEST, item, model, part, x, y, z, expand);
    }

    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.body;
    }
}
