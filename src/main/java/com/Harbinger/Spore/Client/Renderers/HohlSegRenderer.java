package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HohlfresserSeg1Model;
import com.Harbinger.Spore.Client.Models.HohlfresserSeg2Model;
import com.Harbinger.Spore.Client.Models.hohlfresserTailModel;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Sentities.Variants.BraureiVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class HohlSegRenderer<Type extends HohlMultipart> extends LivingEntityRenderer<Type , EntityModel<Type>> {
    public static final Map<HohlMultipart.SegmentVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(HohlMultipart.SegmentVariants.class), (p_114874_) -> {
                p_114874_.put(HohlMultipart.SegmentVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/hohl_seg1.png"));
                p_114874_.put(HohlMultipart.SegmentVariants.MELEE,
                        new ResourceLocation(Spore.MODID, "textures/entity/hohl_seg2.png"));
                p_114874_.put(HohlMultipart.SegmentVariants.ORGAN,
                        new ResourceLocation(Spore.MODID, "textures/entity/hohl_seg2.png"));
            });
    private static final ResourceLocation INNARDS = new ResourceLocation(Spore.MODID,
            "textures/entity/worm_innards.png");

    private final EntityModel<Type> mainSegment = this.getModel();
    private final EntityModel<Type> meleeSegment;
    private final EntityModel<Type> organSegment;
    private final EntityModel<Type> tailModel;

    public HohlSegRenderer(EntityRendererProvider.Context context) {
        super(context, new HohlfresserSeg1Model<>(context.bakeLayer(HohlfresserSeg1Model.LAYER_LOCATION)), 4f);
        meleeSegment = new HohlfresserSeg2Model<>(context.bakeLayer(HohlfresserSeg2Model.LAYER_LOCATION));
        organSegment = new HohlfresserSeg2Model<>(context.bakeLayer(HohlfresserSeg2Model.LAYER_LOCATION));
        tailModel = new hohlfresserTailModel<>(context.bakeLayer(hohlfresserTailModel.LAYER_LOCATION));
        this.addLayer(new HohlColors<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getSegmentVariant());
    }

    @Override
    protected void scale(Type type, PoseStack stack, float p_115316_) {
        float size = type.getSize();
        stack.scale(size,size,size);
        super.scale(type, stack, p_115316_);
    }
    public EntityModel<Type> getSegmentModel(Type type){
        switch (type.getSegmentVariant()){
            case MELEE -> {
                return meleeSegment;
            }
            case ORGAN -> {
                return organSegment;
            }
        }
        return mainSegment;
    }

    @Override
    public void render(Type type, float val1, float val2, PoseStack stack, MultiBufferSource source, int light) {
        model = type.isTail() ? tailModel : getSegmentModel(type);
        super.render(type, val1, val2, stack, source, light);
        if (type.isInvisible()){
            return;
        }
        ClientLevel level = Minecraft.getInstance().level;
        int i = type.getParentIntId();
        if (level != null && i != -1){
            Entity parent = level.getEntity(i);
            if (parent != null){
                renderConnection(type,parent,stack,source,val2);
            }
        }
    }

    @Override
    protected boolean shouldShowName(Type p_115333_) {
        return false;
    }

    public class HohlColors<T extends HohlMultipart, M extends EntityModel<T>> extends RenderLayer<T, M> {
        public HohlColors(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int val, T type, float v, float v1, float v2, float v3, float v4, float v5) {
            if (!type.isInvisible()){
                if (type.getColor() == 0){return;}
                int i = type.getColor();
                float r = (float) (i >> 16 & 255) / 255.0F;
                float g = (float) (i >> 8 & 255) / 255.0F;
                float b = (float) (i & 255) / 255.0F;
                VertexConsumer consumer = multiBufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(type)));
                getParentModel().renderToBuffer(poseStack,consumer,val, OverlayTexture.NO_OVERLAY,r,g,b,0.5f);
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
        int color = parent.getColor();
        float r;
        float g;
        float b;
        if (color == 0){
            r = 1f;
            g = 1f;
            b = 1f;
        }else {
            r = (float) (color >> 16 & 255) / 255.0F;
            g = (float) (color >> 8 & 255) / 255.0F;
            b = (float) (color & 255) / 255.0F;
        }

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
                    r, g, b, 1);              // RGBA color
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
