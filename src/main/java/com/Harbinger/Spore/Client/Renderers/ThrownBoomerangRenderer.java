package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.TintedBufferSource;
import com.Harbinger.Spore.Sentities.Projectile.ThrownBoomerang;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownBoomerangRenderer extends EntityRenderer<ThrownBoomerang> {
    private final ItemRenderer itemRenderer;

    public ThrownBoomerangRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ThrownBoomerang entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();
        float ageInTicks = entity.tickCount + partialTicks;
        int color = entity.getColor();
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        poseStack.translate(0.0D, 0.15D, 0.0D);
        poseStack.scale(2.5f,2.5f,2.5f);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(ageInTicks * 20));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(90));
        MultiBufferSource wrappedBuffer = new TintedBufferSource(buffer, r, g, b, 1.0f);
        this.itemRenderer.renderStatic(entity.getBoomerang().copy(), ItemDisplayContext.GROUND, packedLight, 0, poseStack, wrappedBuffer, entity.level(), entity.getId());
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBoomerang entity) {
        return null;
    }
}