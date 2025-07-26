package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HohlfresserSeg1Model;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class HohlSegRenderer<Type extends HohlMultipart> extends LivingEntityRenderer<Type , HohlfresserSeg1Model<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hohl_seg1.png");
    private static final ResourceLocation INNARDS = new ResourceLocation(Spore.MODID,
            "textures/entity/worm_innards.png");

    public HohlSegRenderer(EntityRendererProvider.Context context) {
        super(context, new HohlfresserSeg1Model<>(context.bakeLayer(HohlfresserSeg1Model.LAYER_LOCATION)), 4f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(Type type, PoseStack stack, float p_115316_) {
        float size = type.getSize();
        stack.scale(size,size,size);
        super.scale(type, stack, p_115316_);
    }

    @Override
    public void render(Type type, float val1, float val2, PoseStack stack, MultiBufferSource source, int light) {
        super.render(type, val1, val2, stack, source, light);
        ClientLevel level = Minecraft.getInstance().level;
        int i = type.getParentIntId();
        if (level != null && i != -1){
            Entity parent = level.getEntity(i);
            if (parent != null){
                renderConnection(type,parent,stack,source,val2);
            }
        }
    }

    private void renderConnection(Type parent, Entity to, PoseStack stack,
                                  MultiBufferSource buffer, float partialTick) {
        float i = to instanceof HohlMultipart hohlMultipart ? hohlMultipart.getSize() : to instanceof Hohlfresser ? 1.2f : 0f;
        Vec3 start = parent.getPosition(partialTick).add(0, (parent.getBbHeight() * 0.3f * parent.getSize()),0);
        Vec3 end = to.getPosition(partialTick).add(0, (to.getBbHeight() * 0.45f * i),0);

        Vec3 direction = end.subtract(start);
        float length = (float)direction.length();
        direction = direction.normalize();

        float yaw = (float)Math.atan2(direction.x, direction.z);
        float pitch = (float)-Math.asin(direction.y);

        stack.pushPose();
        {
            Vec3 vec3 = parent.position().subtract(parent.position()).scale(-1);
            stack.translate(vec3.x, vec3.y+1, vec3.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            float inf = 0.6f;
            float startWidth = parent.getBbWidth()*inf * parent.getSize();
            float startHeight = parent.getBbHeight()*inf * parent.getSize();
            float endWidth = to.getBbWidth()*inf * i;
            float endHeight = to.getBbHeight()*inf * i;

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(INNARDS));
            PoseStack.Pose pose = stack.last();
            Matrix4f matrix = pose.pose();
            drawTaperedConnection(vertexConsumer, matrix, pose.normal(),
                    startWidth, startHeight,  // Start dimensions
                    endWidth, endHeight,      // End dimensions
                    length,                   // Distance between segments
                    OverlayTexture.NO_OVERLAY, 15728880,
                    1, 1, 1, 1);              // RGBA color
        }
        stack.popPose();
    }

    private void drawTaperedConnection(VertexConsumer vertexConsumer, Matrix4f matrix, Matrix3f normal,
                                       float startWidth, float startHeight,
                                       float endWidth, float endHeight,
                                       float length,
                                       int overlay, int lightmap,
                                       float red, float green, float blue, float alpha) {
        // Half dimensions for start and end
        float hwStart = startWidth / 2f;
        float hhStart = startHeight / 2f;
        float hwEnd = endWidth / 2f;
        float hhEnd = endHeight / 2f;

        // Front face (toward 'from' segment - using start dimensions)
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

        // Back face (toward 'to' segment - using end dimensions)
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

        // Sides - these will taper between the segments
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
}
