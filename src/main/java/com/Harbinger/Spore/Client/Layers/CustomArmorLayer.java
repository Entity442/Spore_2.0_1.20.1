package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.ArmorModelList;
import com.Harbinger.Spore.Client.ArmorParts.BaseArmorRenderingBit;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class CustomArmorLayer<E extends  LivingEntity,M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    private final HumanoidModel<E> origin;
    public CustomArmorLayer(RenderLayerParent<E, M> p_117346_) {
        super(p_117346_);
        origin = this.getParentModel();
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int light, E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float v5) {
        List<BaseArmorRenderingBit> parts = ArmorModelList.ARMOR_RENDERING_BITS;
        if (parts.isEmpty()){
            return;
        }
        for (BaseArmorRenderingBit bit : parts){
            bit.tickMovement(entity,poseStack,(HumanoidModel<LivingEntity>)origin,light,buffer);
            bit.model.get().setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks+entity.tickCount, netHeadYaw, headPitch);
        }
    }
}