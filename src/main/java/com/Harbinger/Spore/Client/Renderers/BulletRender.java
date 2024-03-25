package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BulletModel;
import com.Harbinger.Spore.Sentities.Projectile.AdaptableProjectile;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class BulletRender extends EntityRenderer<AdaptableProjectile> {
    BulletModel<AdaptableProjectile> model;

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/noise.png");

    public BulletRender(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BulletModel<>(context.bakeLayer(BulletModel.LAYER_LOCATION));
    }

    @Override
    public void render(AdaptableProjectile adaptableProjectile, float p_114486_, float p_114487_, PoseStack stack, MultiBufferSource bufferSource, int value) {
        super.render(adaptableProjectile, p_114486_, p_114487_, stack, bufferSource, value);
        int i = adaptableProjectile.getParticles();
        float r = (float) (i >> 16 & 255) / 255.0F;
        float g = (float) (i >> 8 & 255) / 255.0F;
        float b = (float) (i & 255) / 255.0F;
        stack.pushPose();
        stack.translate(0f,-1f,0f);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityCutout(this.getTextureLocation(adaptableProjectile)));
        this.model.renderToBuffer(stack, vertexconsumer, value, OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
        stack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(AdaptableProjectile entity) {
        return TEXTURE;
    }
}
