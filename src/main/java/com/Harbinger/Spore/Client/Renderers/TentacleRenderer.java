package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.TentacleSegmentModel;
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
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.List;

public class TentacleRenderer extends OrganoidMobRenderer<Tentacle, EntityModel<Tentacle>>{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle.png");
    private static final ResourceLocation TENTACLE_NOMOD = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle_nom.png");
    private static final ResourceLocation EMPTY = new ResourceLocation(Spore.MODID,
            "textures/entity/empty.png");

    public TentacleRenderer(EntityRendererProvider.Context context) {
        super(context, new TentacleSegmentModel<>(), 0.2f);
    }

    @Override
    public void render(Tentacle type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        super.render(type, value1, value2, stack, bufferSource, value3);
        renderTentacle(stack, bufferSource, type.getSegments(), type.position(),value3);
    }

    private void renderTentacle(PoseStack stack, MultiBufferSource buffer, List<TentaclePart> segments, Vec3 basePosition, int light) {
        if (segments.isEmpty()) return;

        Vec3 prevPos = basePosition;

        // Calculate total current length
        float totalCurrentLength = 0f;
        for (int i = 0; i < segments.size(); i++) {
            TentaclePart currentSeg = segments.get(i);
            Vec3 currentPos = currentSeg.position();
            totalCurrentLength += (float) currentPos.distanceTo(i == 0 ? basePosition : segments.get(i-1).position());
        }

        // Desired total length
        float desiredTotalLength = 5.0f; // Your fixed length here

        for (int i = 0; i < segments.size(); i++) {
            TentaclePart currentSeg = segments.get(i);
            Vec3 currentPos = currentSeg.position();

            // Scale segment length to fit desired total length
            float segmentScale = desiredTotalLength / totalCurrentLength;
            Vec3 scaledDirection = currentPos.subtract(prevPos).scale(segmentScale);
            Vec3 scaledEnd = prevPos.add(scaledDirection);

            float thickness = calculateThickness(i, segments.size());
            renderConnection(prevPos, scaledEnd, basePosition, thickness, stack, buffer,light);

            prevPos = scaledEnd;
        }
    }

    private float calculateThickness(int segmentIndex, int totalSegments) {
        // Taper from base (thicker) to tip (thinner)
        float progress = (float) segmentIndex / totalSegments;
        return 0.3f * (1.0f - progress * 0.5f);
    }

    private void renderConnection(Vec3 from, Vec3 to, Vec3 base, float thickness, PoseStack stack, MultiBufferSource buffer, int light) {
        if (from == null || to == null) return;

        Vec3 relativeStart = from.subtract(base);
        Vec3 relativeEnd = to.subtract(base);

        Vec3 direction = relativeEnd.subtract(relativeStart);
        float length = (float) direction.length();
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);

        stack.pushPose();
        {
            stack.translate(relativeStart.x,relativeStart.y, relativeStart.z);
            ///stack.mulPose(Axis.ZP.rotationDegrees(-180F));
            ///stack.mulPose(Axis.XP.rotationDegrees(90f));
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            ///stack.scale(thickness, length, thickness);

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(TENTACLE_NOMOD));
            ///this.getModel().renderToBuffer(stack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
            PoseStack.Pose pose = stack.last();
            Matrix4f matrix = pose.pose();
            Matrix3f normal = pose.normal();

            // Use consistent thickness for seamless connections
            drawSeamlessConnection(vertexConsumer, matrix, normal,thickness, thickness,length, OverlayTexture.NO_OVERLAY, 15728880,1f, 1f, 1f, 1f);
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
        return EMPTY;
    }
}