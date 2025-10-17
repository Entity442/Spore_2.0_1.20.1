package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SegmentBase;
import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
import com.Harbinger.Spore.Sentities.Organoids.TentaclePart;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public class TentacleRenderer extends MobRenderer<Tentacle, EntityModel<Tentacle>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle_base.png");
    private static final ResourceLocation TENTACLE_NOMOD = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle_nom.png");

    public TentacleRenderer(EntityRendererProvider.Context context) {
        super(context, new SegmentBase<>(), 0.2f);
    }

    private float calculateThickness(int segmentIndex, int totalSegments) {
        float progress = (float) segmentIndex / totalSegments;
        return 0.3f * (1.0f - progress * 0.5f);
    }
    @Override
    public void render(Tentacle entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);
        Vec3 entityPos = entity.position();
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            renderTentacle(stack, buffer, entity.getRightSegments(), entity,partialTicks);
            renderTentacle(stack, buffer, entity.getLeftSegments(), entity,partialTicks);
            renderTentacle(stack, buffer, entity.getRightBackSegments(), entity,partialTicks);
            renderTentacle(stack, buffer, entity.getLeftBackSegments(), entity,partialTicks);
        }
        stack.popPose();
    }

    private void renderTentacle(PoseStack stack, MultiBufferSource buffer, TentaclePart[] segments, LivingEntity parent, float partial) {
        if (segments == null || segments.length < 2) return;
        Entity entity = parent;
        float hurtTime = parent.hurtTime - partial;
        float flashIntensity = 0.0F;

        if (hurtTime > 0) {
            flashIntensity = Math.min(hurtTime / 10.0F, 1.0F);
        }
        float red = 1.0F;
        float green = 1.0F - flashIntensity * 0.5F;
        float blue = 1.0F - flashIntensity * 0.5F;

        for (int i = 0; i < segments.length; i++) {
            Entity currentPos = segments[i];
            float thickness = calculateThickness(i, segments.length);
            renderConnection(entity, currentPos, thickness, stack, buffer, i,partial,red,green,blue);

            entity = currentPos;
        }
    }
    public Vec3 processPosition(Entity entity, float partialTicks) {
        Vec3 interpolatedPos = entity.getPosition(partialTicks);
        double centerX = interpolatedPos.x;
        double centerY = interpolatedPos.y + (entity.getBbHeight() / 2);
        double centerZ = interpolatedPos.z;

        return new Vec3(centerX, centerY, centerZ);
    }

    private void renderConnection(Entity from, Entity to, float thickness, PoseStack stack, MultiBufferSource buffer,int index , float partial
    ,float r,float g, float b) {
        if (from == null || to == null) return;
        Vec3 goingTo =processPosition(from,partial);
        Vec3 direction = processPosition(to,partial).subtract(goingTo);
        float length = (float) direction.length() + (0.05f * index);
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);

        stack.pushPose();
        {
            stack.translate(goingTo.x, goingTo.y, goingTo.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(TENTACLE_NOMOD));
            PoseStack.Pose pose = stack.last();
            Matrix4f matrix = pose.pose();
            Matrix3f normal = pose.normal();
            drawSeamlessConnection(vertexConsumer, matrix, normal, thickness, thickness, length, OverlayTexture.NO_OVERLAY, 15728880, r, g, b, 1f);
        }
        stack.popPose();
    }

    private void drawSeamlessConnection(VertexConsumer vertexConsumer, Matrix4f matrix, Matrix3f normal,
                                        float startWidth, float startHeight,
                                        float length,
                                        int overlay, int lightmap,
                                        float red, float green, float blue, float alpha) {
        // Half dimensions for consistent sizing
        float hwStart = startWidth / 2f;
        float hhStart = startHeight / 2f;

        // Use same dimensions for end to ensure seamless connections
        float hwEnd = hwStart;
        float hhEnd = hhStart;

        // Front face (at start position)
        vertexConsumer.vertex(matrix, -hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix, hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix, hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, -1).endVertex();
        vertexConsumer.vertex(matrix, -hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, -1).endVertex();

        // Back face (at end position)
        vertexConsumer.vertex(matrix, -hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, 1).endVertex();
        vertexConsumer.vertex(matrix, -hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 0, 1).endVertex();

        // Sides - all using consistent dimensions for seamless connection
        // Top side
        vertexConsumer.vertex(matrix, -hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix, hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 1, 0).endVertex();
        vertexConsumer.vertex(matrix, -hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, 1, 0).endVertex();

        // Bottom side
        vertexConsumer.vertex(matrix, -hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix, hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, -1, 0).endVertex();
        vertexConsumer.vertex(matrix, -hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 0, -1, 0).endVertex();

        // Left side
        vertexConsumer.vertex(matrix, -hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, -1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, -hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, -1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, -hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, -1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, -hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, -1, 0, 0).endVertex();

        // Right side
        vertexConsumer.vertex(matrix, hwStart, -hhStart, 0)
                .color(red, green, blue, alpha).uv(0, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, hwStart, hhStart, 0)
                .color(red, green, blue, alpha).uv(1, 0)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, hhEnd, length)
                .color(red, green, blue, alpha).uv(1, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 1, 0, 0).endVertex();
        vertexConsumer.vertex(matrix, hwEnd, -hhEnd, length)
                .color(red, green, blue, alpha).uv(0, 1)
                .overlayCoords(overlay).uv2(lightmap)
                .normal(normal, 1, 0, 0).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(Tentacle tentacle) {
        return TEXTURE;
    }
}