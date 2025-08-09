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
    public void render(T entity, float val1, float val2, PoseStack stack, MultiBufferSource source, int light) {
        if (partToRender == null || partToRender.id() != entity.getCorpseType()) {
            partToRender = CalamityPartsHandeling.getPart(entity.getCorpseType());
            if (partToRender == null) return; // prevent crash
        }
        stack.pushPose();
        stack.translate(partToRender.z(),partToRender.y(),partToRender.x());

        stack.mulPose(Axis.XP.rotationDegrees(180 + partToRender.xRot()));
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(val2, entity.yRotO, entity.getYRot()) + partToRender.yRot()));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(val2, entity.xRotO, entity.getXRot()) + partToRender.zRot()));
        VertexConsumer consumer = source.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
        for (ModelPart part : partToRender.parts()) {
            part.render(stack, consumer, light, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        }
        stack.popPose();
    }

}
