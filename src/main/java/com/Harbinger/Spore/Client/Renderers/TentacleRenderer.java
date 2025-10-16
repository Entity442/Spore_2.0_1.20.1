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

    @Override
    public void render(Tentacle type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        super.render(type, value1, value2, stack, bufferSource, value3);
        renderTentacle(stack, bufferSource, type.getRightSegments(), type.position());
        renderTentacle(stack, bufferSource, type.getLeftSegments(), type.position());
        renderTentacle(stack, bufferSource, type.getRightBackSegments(), type.position());
        renderTentacle(stack, bufferSource, type.getLeftBackSegments(), type.position());
    }

    private void renderTentacle(PoseStack stack, MultiBufferSource buffer, TentaclePart[] segments, Vec3 basePosition) {
        if (segments == null) return;

        Vec3 prevPos = basePosition;

        float totalCurrentLength = 0f;
        for (int i = 0; i < segments.length; i++) {
            TentaclePart currentSeg = segments[i];
            Vec3 currentPos = currentSeg.position();
            totalCurrentLength += (float) currentPos.distanceTo(i == 0 ? basePosition : segments[i-1].position());
        }

        float desiredTotalLength = 5.0f;

        for (int i = 0; i < segments.length; i++) {
            TentaclePart currentSeg = segments[i];
            Vec3 currentPos = currentSeg.position();
            float segmentScale = desiredTotalLength / totalCurrentLength;
            Vec3 scaledDirection = currentPos.subtract(prevPos).scale(segmentScale);
            Vec3 scaledEnd = prevPos.add(scaledDirection);

            float thickness = calculateThickness(i, segments.length);
            renderConnection(prevPos, scaledEnd, basePosition, thickness, stack, buffer,i);

            prevPos = scaledEnd;
        }
    }

    private float calculateThickness(int segmentIndex, int totalSegments) {
        float progress = (float) segmentIndex / totalSegments;
        return 0.3f * (1.0f - progress * 0.5f);
    }

    private void renderConnection(Vec3 from, Vec3 to, Vec3 base, float thickness, PoseStack stack, MultiBufferSource buffer, int val) {
        if (from == null || to == null) return;

        Vec3 relativeStart = from.subtract(base);
        Vec3 relativeEnd = to.subtract(base);

        Vec3 direction = relativeEnd.subtract(relativeStart);
        float length = (float) direction.length() + (0.05f * val);
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);

        stack.pushPose();
        {
            stack.translate(relativeStart.x+0.25,relativeStart.y, relativeStart.z+0.25);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(TENTACLE_NOMOD));
            PoseStack.Pose pose = stack.last();
            Matrix4f matrix = pose.pose();
            Matrix3f normal = pose.normal();
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
        return TEXTURE;
    }
}