package com.Harbinger.Spore.Client.Layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;

public interface BodySynModel {
    void animateHead(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
    void animateBody(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
    void animateRightArm(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
    void animateLeftArm(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
    void animateRightLeg(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
    void animateLeftLeg(PoseStack stack, ModelPart part, MultiBufferSource buffer, int packedLight);
}
