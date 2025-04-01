package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.TentacleSegmentModel;
import com.Harbinger.Spore.Client.TentacleSegment;
import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import java.util.List;

public class TentacleRenderer extends OrganoidMobRenderer<Tentacle, EntityModel<Tentacle>>{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/blank.png");
    public TentacleRenderer(EntityRendererProvider.Context context) {
        super(context, new TentacleSegmentModel<>(), 0.2f);
    }

    @Override
    public void render(Tentacle type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        super.render(type, value1, value2, stack, bufferSource, value3);
        renderTentacle(stack,bufferSource,type.getSegments(),type.position());
    }
    public void renderTentacle(PoseStack stack, MultiBufferSource buffer, List<TentacleSegment> segments,Vec3 basePosition) {
        VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
        PoseStack.Pose pose = stack.last();
        Matrix4f matrix = pose.pose();
        for (TentacleSegment segment : segments) {
            Vec3 pos = segment.position.subtract(basePosition);
            float size = 0.5f;

            float x1 = (float) (pos.x - size);
            float x2 = (float) (pos.x + size);
            float y1 = (float) (pos.y - size);
            float y2 = (float) (pos.y + size);
            float z1 = (float) (pos.z - size);
            float z2 = (float) (pos.z + size);
            drawFace(vertexConsumer, matrix, stack.last(), x1, y1, z1, x2, y1, z1, x2, y2, z1, x1, y2, z1, 0, 240, 1, 1, 1, 1, 0, 0, -1); // Front
            drawFace(vertexConsumer, matrix, stack.last(), x1, y1, z2, x2, y1, z2, x2, y2, z2, x1, y2, z2, 0, 240, 1, 1, 1, 1, 0, 0, 1);  // Back
            drawFace(vertexConsumer, matrix, stack.last(), x1, y1, z1, x1, y1, z2, x1, y2, z2, x1, y2, z1, 0, 240, 1, 1, 1, 1, -1, 0, 0); // Left
            drawFace(vertexConsumer, matrix, stack.last(), x2, y1, z1, x2, y1, z2, x2, y2, z2, x2, y2, z1, 0, 240, 1, 1, 1, 1, 1, 0, 0);  // Right
            drawFace(vertexConsumer, matrix, stack.last(), x1, y2, z1, x2, y2, z1, x2, y2, z2, x1, y2, z2, 0, 240, 1, 1, 1, 1, 0, 1, 0);  // Top
            drawFace(vertexConsumer, matrix, stack.last(), x1, y1, z1, x2, y1, z1, x2, y1, z2, x1, y1, z2, 0, 240, 1, 1, 1, 1, 0, -1, 0); // Bottom

        }
    }

    private void drawFace(VertexConsumer vertexConsumer, Matrix4f matrix, PoseStack.Pose pose,
                          float x1, float y1, float z1, float x2, float y2, float z2,
                          float x3, float y3, float z3, float x4, float y4, float z4,
                          int overlay, int lightmap, float red, float green, float blue, float alpha,
                          float normalX, float normalY, float normalZ) {

        // First vertex (bottom left)
        vertexConsumer.vertex(matrix, x1, y1, z1)
                .color(red, green, blue, alpha)
                .uv(0, 1)
                .overlayCoords(overlay)
                .uv2(lightmap)
                .normal(pose.normal(), normalX, normalY, normalZ)
                .endVertex();

        // Second vertex (bottom right)
        vertexConsumer.vertex(matrix, x2, y2, z2)
                .color(red, green, blue, alpha)
                .uv(1, 1)
                .overlayCoords(overlay)
                .uv2(lightmap)
                .normal(pose.normal(), normalX, normalY, normalZ)
                .endVertex();

        // Third vertex (top right)
        vertexConsumer.vertex(matrix, x3, y3, z3)
                .color(red, green, blue, alpha)
                .uv(1, 0)
                .overlayCoords(overlay)
                .uv2(lightmap)
                .normal(pose.normal(), normalX, normalY, normalZ)
                .endVertex();

        // Fourth vertex (top left)
        vertexConsumer.vertex(matrix, x4, y4, z4)
                .color(red, green, blue, alpha)
                .uv(0, 0)
                .overlayCoords(overlay)
                .uv2(lightmap)
                .normal(pose.normal(), normalX, normalY, normalZ)
                .endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(Tentacle tentacle) {
        return TEXTURE;
    }
}
