package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.ThrownBoomerang;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;

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
        poseStack.translate(0.0D, 0.15D, 0.0D);
        poseStack.scale(2.5f,2.5f,2.5f);
        poseStack.mulPose(com.mojang.math.Axis.YP.rotationDegrees(ageInTicks * 20));
        poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(90));
        this.itemRenderer.renderStatic(entity.getBoomerang().copy(), ItemDisplayContext.GROUND, packedLight, 0, poseStack, buffer, entity.level(), entity.getId());
        poseStack.popPose();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBoomerang entity) {
        return null;
    }
}