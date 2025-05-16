package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedSpearModel;
import com.Harbinger.Spore.Sentities.Projectile.ThrownSickle;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class SickleRenderer extends EntityRenderer<ThrownSickle> {
    private static final ResourceLocation SICKLE_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/infected_sickle.png");
    private static final ResourceLocation SPINE_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/spine.png");
    private final InfectedSpearModel<ThrownSickle> model;

    public SickleRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new InfectedSpearModel<>(context.bakeLayer(InfectedSpearModel.LAYER_LOCATION));
    }

    @Override
    public void render(ThrownSickle sickle, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, sickle.yRotO, sickle.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, sickle.xRotO, sickle.getXRot()) + 90.0F));
        VertexConsumer sickleConsumer = ItemRenderer.getFoilBufferDirect(bufferSource, model.renderType(getTextureLocation(sickle)), false, sickle.isFoil());
        model.renderToBuffer(poseStack, sickleConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();

        super.render(sickle, entityYaw, partialTicks, poseStack, bufferSource, light);
        Entity entity = sickle.getOwner();
        if (entity != null) {
            Vec3 start = sickle.position();
            Vec3 end = entity.getEyePosition(partialTicks);

            VertexConsumer line = bufferSource.getBuffer(RenderType.entityCutout(SPINE_TEXTURE));
            poseStack.pushPose();
            Matrix4f matrix = poseStack.last().pose();
            
            drawQuad(line, matrix, start, end, light);
            poseStack.popPose();
        }
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownSickle sickle) {
        return SICKLE_TEXTURE;
    }

    private void drawQuad(VertexConsumer vertexConsumer, Matrix4f matrix, Vec3 start, Vec3 end, int light) {
        float width = 0.05F;
        float r = 1F, g = 1F, b = 1F, a = 1F;

        Vec3 dir = end.subtract(start).normalize();
        Vec3 side = dir.cross(new Vec3(0, 1, 0)).normalize().scale(width); // Perpendicular vector for thickness

        Vec3 p1 = start.add(side);
        Vec3 p2 = start.subtract(side);
        Vec3 p3 = end.subtract(side);
        Vec3 p4 = end.add(side);

        vertexConsumer.vertex(matrix, (float) p1.x, (float) p1.y, (float) p1.z)
                .color(r, g, b, a).uv(0, 1)
                .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light)
                .normal(0, 1, 0).endVertex();

        vertexConsumer.vertex(matrix, (float) p2.x, (float) p2.y, (float) p2.z)
                .color(r, g, b, a).uv(1, 1)
                .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light)
                .normal(0, 1, 0).endVertex();

        vertexConsumer.vertex(matrix, (float) p3.x, (float) p3.y, (float) p3.z)
                .color(r, g, b, a).uv(1, 0)
                .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light)
                .normal(0, 1, 0).endVertex();

        vertexConsumer.vertex(matrix, (float) p4.x, (float) p4.y, (float) p4.z)
                .color(r, g, b, a).uv(0, 0)
                .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(light)
                .normal(0, 1, 0).endVertex();
    }
}
