package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedSpearModel;
import com.Harbinger.Spore.ExtremelySusThings.Utilities;
import com.Harbinger.Spore.Sentities.Projectile.ThrownSpear;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
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

@OnlyIn(Dist.CLIENT)
public class SpearRenderer extends EntityRenderer<ThrownSpear> {
    public static final ResourceLocation Spear_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/infected_spear.png");
    private final InfectedSpearModel<ThrownSpear> model;

    public SpearRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new InfectedSpearModel<>(context.bakeLayer(InfectedSpearModel.LAYER_LOCATION));
    }

    public void render(ThrownSpear spear, float p_116112_, float p_116113_, PoseStack stack, MultiBufferSource p_116115_, int p_116116_) {
        int color = spear.getColor();
        float r = (float) (color >> 16 & 255) / 255.0F;;
        float g = (float) (color >> 8 & 255) / 255.0F;;
        float b = (float) (color & 255) / 255.0F;;
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(p_116113_, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(p_116113_, spear.xRotO, spear.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(p_116115_, this.model.renderType(this.getTextureLocation(spear)), false, spear.isFoil());
        this.model.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, r, g, b, 1.0F);
        stack.popPose();
        super.render(spear, p_116112_, p_116113_, stack, p_116115_, p_116116_);
    }

    public ResourceLocation getTextureLocation(ThrownSpear p_116109_) {
        return Spear_LOCATION;
    }
}