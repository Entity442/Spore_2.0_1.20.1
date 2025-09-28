package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Core.Sitems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

public class SyringeGunArmorPartLeft extends BaseArmorRenderingBit{
    public SyringeGunArmorPartLeft(Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand) {
        super(EquipmentSlot.OFFHAND, Sitems.SYRINGE_GUN.get(), model, part, x, y, z, expand);
    }

    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.leftArm;
    }
}
