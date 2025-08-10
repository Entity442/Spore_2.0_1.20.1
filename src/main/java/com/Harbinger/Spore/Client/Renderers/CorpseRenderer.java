package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.CalamityPartsHandeling;
import com.Harbinger.Spore.Sentities.Utility.CorpseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CorpseRenderer<T extends CorpseEntity> extends EntityRenderer<T> {
    public CalamityPartsHandeling.Part  partToRender;
    public CorpseRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return partToRender == null ? new ResourceLocation("") : t.getOwnerAda() ? partToRender.adapted_location() : partToRender.location();
    }

    @Override
    public void render(T entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource source, int light) {
        if (partToRender == null || partToRender.id() != entity.getCorpseType()) {
            partToRender = CalamityPartsHandeling.getPart(entity.getCorpseType());
            if (partToRender == null) return;
        }

        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot())));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

        stack.pushPose();
        stack.mulPose(Axis.XP.rotationDegrees(180 + partToRender.xRot()));
        stack.mulPose(Axis.YP.rotationDegrees(partToRender.yRot()));
        stack.mulPose(Axis.ZP.rotationDegrees(partToRender.zRot()));
        stack.translate(-partToRender.z(), -partToRender.y(), -partToRender.x());

        renderPart(entity, stack, source, light);
        stack.popPose();
        stack.popPose();
    }

    private void renderPart(T entity, PoseStack stack, MultiBufferSource source, int light) {
        int color = entity.getColor();
        float r = (color >> 16 & 255) / 255.0F;
        float g = (color >> 8 & 255) / 255.0F;
        float b = (color & 255) / 255.0F;

        VertexConsumer consumer = source.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
        VertexConsumer translucent = source.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));

        for (ModelPart part : partToRender.parts()) {
            part.render(stack, consumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            if (color != 0) {
                part.render(stack, translucent, light, OverlayTexture.NO_OVERLAY, r, g, b, 0.5f);
            }
        }
    }


}
