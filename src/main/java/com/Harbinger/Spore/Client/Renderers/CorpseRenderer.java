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
import net.minecraft.world.phys.Vec3;
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
    public void render(T entity, float entityYaw, float val2, PoseStack stack, MultiBufferSource source, int light) {
        if (partToRender == null || partToRender.id() != entity.getCorpseType()) {
            partToRender = CalamityPartsHandeling.getPart(entity.getCorpseType());
            if (partToRender == null) return;
        }
        int i = entity.getColor();
        float r = (float) (i >> 16 & 255) / 255.0F;
        float g = (float) (i >> 8 & 255) / 255.0F;
        float b = (float) (i & 255) / 255.0F;
        stack.pushPose();
        stack.translate(0,0,0);
        stack.mulPose(Axis.XP.rotationDegrees(180 + partToRender.xRot()));
        stack.mulPose(Axis.YP.rotationDegrees(partToRender.yRot()));
        stack.mulPose(Axis.ZP.rotationDegrees(partToRender.zRot()));
        stack.translate(-partToRender.z(),-partToRender.y(),-partToRender.x());
        VertexConsumer consumer = source.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
        VertexConsumer vertexConsumer = source.getBuffer(RenderType.entityTranslucent(getTextureLocation(entity)));
        for (ModelPart part : partToRender.parts()) {
            part.render(stack, consumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
            if (entity.getColor() != 0){
                part.render(stack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, r,g,b,0.5f);
            }
        }
        stack.popPose();
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - entityYaw));
        stack.popPose();
    }

}
