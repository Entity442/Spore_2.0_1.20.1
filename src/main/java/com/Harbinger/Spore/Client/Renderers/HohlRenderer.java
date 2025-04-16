package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.WormHeadModel;
import com.Harbinger.Spore.Client.Models.WormSegmentModel;
import com.Harbinger.Spore.Client.Models.WormTailModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
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
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class HohlRenderer<Type extends Hohlfresser> extends CalamityRenderer<Type , EntityModel<Type>>{
    private final WormSegmentModel<Type> segments;
    private final WormTailModel<Type> tail;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/blank.png");
    private static final ResourceLocation INNARDS = new ResourceLocation(Spore.MODID,
            "textures/entity/worm_innards.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/sieger.png");


    public HohlRenderer(EntityRendererProvider.Context context) {
        super(context, new WormHeadModel<>(context.bakeLayer(WormHeadModel.LAYER_LOCATION)), 4f);
        segments = new WormSegmentModel<>(context.bakeLayer(WormSegmentModel.LAYER_LOCATION));
        tail = new WormTailModel<>(context.bakeLayer(WormTailModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        super.render(type, value1, value2, stack, bufferSource, light);
        float i = type.getYHeadRot();
        HohlMultipart previous = null;
        for (int e = 0; e<type.getSubEntities().size();e++){
            HohlMultipart segment = type.getSubEntities().get(e);
            renderSegment(type, segment,previous, stack, bufferSource, light, i,value2,e == type.getSubEntities().size()-1);
            previous = segment;
        }
        if (!type.getSubEntities().isEmpty()){
            renderConnectionHead(type, type.getSubEntities().get(0), stack, bufferSource,value2);
        }
    }

    private void renderSegment(Type parent ,HohlMultipart entity,HohlMultipart previous, PoseStack stack, MultiBufferSource bufferSource,
                               int packedLight,float y,float age,boolean isLast) {
        EntityModel<Type> proper_model = isLast ? tail : segments;
        float limbSwing = parent.walkAnimation.position();
        float limbSwingAmount = parent.walkAnimation.speed();
        VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutout(TEXTURE));
        Vec3 vec3 = parent.position().subtract(entity.position()).scale(-1.5);
        stack.pushPose();
        stack.scale(entity.getInflation(),entity.getInflation(),entity.getInflation());
        stack.translate(vec3.x,vec3.y,vec3.z);
        stack.mulPose(Axis.YP.rotationDegrees(180.0F - y));
        stack.mulPose(Axis.ZP.rotationDegrees(180.0F));
        stack.translate(0,-1.5,0);
        proper_model.setupAnim(parent, limbSwing, limbSwingAmount, age, parent.getYRot(), parent.getXRot());
        proper_model.renderToBuffer(stack,consumer,packedLight, OverlayTexture.NO_OVERLAY,1,1,1,1);
        stack.popPose();
        if (previous != null) {
            renderConnection(parent,previous, entity, stack, bufferSource,age);
        }
    }

    public ResourceLocation GET_TEXTURE(Entity entity) {
        return INNARDS;
    }
    private void renderConnection(Type parent ,HohlMultipart from, HohlMultipart to, PoseStack stack,
                                  MultiBufferSource buffer, float partialTick) {
        Vec3 start = from.getPosition(partialTick);
        Vec3 end = to.getPosition(partialTick);

        Vec3 direction = end.subtract(start);
        float length = (float)direction.length();
        direction = direction.normalize();

        float yaw = (float)Math.atan2(direction.x, direction.z);
        float pitch = (float)-Math.asin(direction.y);

        stack.pushPose();
        {
            Vec3 vec3 = parent.position().subtract(from.position()).scale(-1);
            stack.translate(vec3.x, vec3.y+1, vec3.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));

            float startWidth = (from.getBbWidth() * from.getInflation())*0.5f;
            float startHeight = (from.getBbHeight() * from.getInflation())*0.5f;
            float endWidth = (to.getBbWidth() * to.getInflation())*0.5f;
            float endHeight = (to.getBbHeight() * to.getInflation())*0.5f;

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(GET_TEXTURE(parent)));
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
    private void renderConnectionHead(Type parent , HohlMultipart to, PoseStack stack,
                                  MultiBufferSource buffer, float partialTick) {
        // Get interpolated positions
        Vec3 start = parent.getPosition(partialTick);
        Vec3 end = to.getPosition(partialTick);

        // Calculate direction between segments
        Vec3 direction = end.subtract(start);
        float length = (float)direction.length();
        direction = direction.normalize();

        // Calculate rotation angles
        float yaw = (float)Math.atan2(direction.x, direction.z);
        float pitch = (float)-Math.asin(direction.y);

        stack.pushPose();
        {
            Vec3 vec3 = parent.position().subtract(to.position()).scale(-0.3);
            stack.translate(vec3.x, vec3.y+1, vec3.z);
            // Rotate to face the direction between segments
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));

            // Get dimensions from both segments
            float startWidth = (parent.getBbWidth())*0.6f;
            float startHeight = (parent.getBbHeight())*0.6f;
            float endWidth = (to.getBbWidth() * to.getInflation())*0.6f;
            float endHeight = (to.getBbHeight() * to.getInflation())*0.6f;

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(GET_TEXTURE(parent)));
            PoseStack.Pose pose = stack.last();
            Matrix4f matrix = pose.pose();
            // Draw tapered connection between segments
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
