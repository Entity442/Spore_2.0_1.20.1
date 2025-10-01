package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SyringeProjectileModel;
import com.Harbinger.Spore.Sentities.Projectile.SyringeProjectile;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
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
public class SyringeRenderer extends EntityRenderer<SyringeProjectile> {
    public static final ResourceLocation LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/syringe.png");
    private final SyringeProjectileModel<SyringeProjectile> model;

    public SyringeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SyringeProjectileModel<>();
    }

    public void render(SyringeProjectile spear, float p_116112_, float p_116113_, PoseStack stack, MultiBufferSource source, int p_116116_) {
        stack.pushPose();
        stack.translate(0,-1,0);
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(p_116113_, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(p_116113_, spear.xRotO, spear.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = source.getBuffer(RenderType.entityTranslucent(getTextureLocation(spear)));
        this.model.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        stack.popPose();
        super.render(spear, p_116112_, p_116113_, stack, source, p_116116_);
    }

    public ResourceLocation getTextureLocation(SyringeProjectile p_116109_) {
        return LOCATION;
    }
}