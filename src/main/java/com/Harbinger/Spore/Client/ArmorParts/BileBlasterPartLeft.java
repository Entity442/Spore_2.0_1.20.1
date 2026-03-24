package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Core.Sitems;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

import java.util.function.Supplier;

public class BileBlasterPartLeft extends BaseArmorRenderingBit {
    public BileBlasterPartLeft(Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand) {
        super(EquipmentSlot.OFFHAND, Sitems.BILE_BLASTER.get(), model, part, x, y, z, expand);
    }

    @Override
    protected VertexConsumer consumer(MultiBufferSource source, CustomModelArmorData data, HumanoidModel<LivingEntity> model, LivingEntity livingEntity) {
        return ItemRenderer.getFoilBufferDirect(source, RenderType.entityCutoutNoCull(data.getTextureLocation()), false, stack(livingEntity).hasFoil());
    }

    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.leftArm;
    }
}
