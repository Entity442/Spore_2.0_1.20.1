package com.Harbinger.Spore.Client.Special;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public abstract class BaseBlockEntityRenderer<T extends BlockEntity> implements BlockEntityRenderer<T> {
    private final BlockEntityModel<T> model;
    protected BaseBlockEntityRenderer(BlockEntityModel<T> model) {
        this.model = model;
    }
    public abstract int getTicks(T entity);
    public abstract ResourceLocation getTexture();

    @Override
    public void render(T blockEntity, float partialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        float f = (float)getTicks(blockEntity) + partialTicks;
        VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityCutout(getTexture()));
        pPoseStack.pushPose();
        pPoseStack.translate(0.5,1.5,0.5);
        pPoseStack.scale(0.99f,0.99f,0.99f);
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(-180F));
        this.model.setupAnim(blockEntity,f);
        this.model.renderToBuffer(pPoseStack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
        pPoseStack.popPose();
    }
}
