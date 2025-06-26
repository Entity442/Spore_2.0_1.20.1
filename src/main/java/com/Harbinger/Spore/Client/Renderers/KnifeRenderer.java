package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedSpearModel;
import com.Harbinger.Spore.Sentities.Projectile.ThrownKnife;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class KnifeRenderer extends EntityRenderer<ThrownKnife> {
    public static final ResourceLocation Spear_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/infected_knife.png");
    private final InfectedSpearModel<ThrownKnife> model;

    public KnifeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new InfectedSpearModel<>(context.bakeLayer(InfectedSpearModel.LAYER_LOCATION));
    }

    public void render(ThrownKnife knife, float p_116112_, float p_116113_, PoseStack stack, MultiBufferSource p_116115_, int p_116116_) {
        int color = knife.getColor();
        float r = (float) (color >> 16 & 255) / 255.0F;;
        float g = (float) (color >> 8 & 255) / 255.0F;;
        float b = (float) (color & 255) / 255.0F;;
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(p_116113_, knife.yRotO, knife.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(p_116113_, knife.xRotO, knife.getXRot()) + 90.0F));
        stack.scale(0.4f,0.4f,0.4f);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, this.model.renderType(this.getTextureLocation(knife)), false, knife.isFoil());
        this.model.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
        stack.popPose();
        super.render(knife, p_116112_, p_116113_, stack, p_116115_, p_116116_);
    }

    public @NotNull ResourceLocation getTextureLocation(ThrownKnife p_116109_) {
        return Spear_LOCATION;
    }
}