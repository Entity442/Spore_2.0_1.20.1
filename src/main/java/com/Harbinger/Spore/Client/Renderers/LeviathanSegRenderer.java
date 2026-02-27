package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.WaterCalamityCamo;
import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Models.KrakenTentacles.*;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkLeviLeg;
import com.Harbinger.Spore.Sentities.BaseEntities.LeviathanMultipart;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class LeviathanSegRenderer<Type extends LeviathanMultipart> extends LivingEntityRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> mainModel = this.getModel();
    private final EntityModel<Type> middleSeg;
    private final Seg1<Type> tentacleSegmentModel1 = new Seg1<>();
    private final Seg2<Type> tentacleSegmentModel2 = new Seg2<>();
    private final Seg3<Type> tentacleSegmentModel3 = new Seg3<>();
    private final Seg4<Type> tentacleSegmentModel4 = new Seg4<>();
    private final Seg5<Type> tentacleSegmentModel5 = new Seg5<>();
    private final Seg6<Type> tentacleSegmentModel6 = new Seg6<>();
    private final FootSegLevi<Type> foot = new FootSegLevi<>();
    private static final ResourceLocation INNARDS = new ResourceLocation(Spore.MODID,
            "textures/entity/leviathan_insides.png");
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/leviathan_tail.png");
    private static final ResourceLocation TENTACLES = new ResourceLocation(Spore.MODID,
            "textures/entity/kraken/kraken_t1.png");
    public LeviathanSegRenderer(EntityRendererProvider.Context context) {
        super(context, new LeviathanTailModel<>(), 4f);
        middleSeg = new LeviathanMiddleSegment<>();
        this.addLayer(new HohlColors<>(this));
        this.addLayer(new WaterCalamityCamo<>(this));
    }
    public EntityModel<Type> getTentacleModel(int i){
        return switch (i) {
            case 1 -> tentacleSegmentModel2;
            case 2 -> tentacleSegmentModel3;
            case 3 -> tentacleSegmentModel4;
            case 4 -> tentacleSegmentModel5;
            case 5 -> tentacleSegmentModel6;
            default -> tentacleSegmentModel1;
        };
    }
    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public void render(Type type, float val1, float val2, PoseStack stack, MultiBufferSource source, int light) {
        model = type.isTail() ? mainModel : middleSeg;
        Vec3 direction = null;
        ClientLevel level = Minecraft.getInstance().level;
        int i = type.getParentIntId();
        if (level != null && i != -1 && !type.isInvisible()){
            Entity parent = level.getEntity(i);
            if (parent != null){
                renderConnection(type,parent,stack,source,val2);
                direction = parent.getPosition(val2).subtract(type.getPosition(val2));
                direction = direction.normalize();
            }
        }
        stack.pushPose();
        if (direction != null){
            float pitch = (float) -Math.asin(direction.y);
            stack.mulPose(Axis.XP.rotation(pitch));
        }
        super.render(type, val1, val2, stack, source, light);
        stack.popPose();
        Vec3 entityPos = type.getPosition(val2);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            if (!type.isInvisible()){
                for (IkLeviLeg leg : type.getLegs()){
                    renderTentacle(stack,type,light, source, leg.getEntities(),leg.getSegmentVar(), type,val2);

                }
            }
        }
        stack.popPose();
    }

    @Override
    protected void scale(Type livingEntity, PoseStack poseStack, float partialTickTime) {
        float size = livingEntity.isTail() ? 1 : 1.3f;
        poseStack.scale(size,size,size);
        super.scale(livingEntity, poseStack, partialTickTime);
    }

    @Override
    protected boolean shouldShowName(Type p_115333_) {
        return false;
    }

    public class HohlColors<T extends LeviathanMultipart, M extends EntityModel<T>> extends RenderLayer<T, M> {
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
        boolean adapted = parent.isAdapted();
        Vec3 start = parent.getPosition(partialTick).add(0, (parent.getBbHeight() * 0.3f),0);
        Vec3 end = to.getPosition(partialTick).add(0, (to.getBbHeight() * (adapted ? 0.7 : 0.45f)),0);

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
            float inf = 0.3f;
            float startWidth = parent.getBbWidth()*inf;
            float startHeight = parent.getBbHeight()*inf;
            float endWidth = to.getBbWidth()*inf;
            float endHeight = to.getBbHeight()*inf;

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

        // Half dimensions
        float hwStart = startWidth / 2f;
        float hhStart = startHeight / 2f;
        float hwEnd   = endWidth / 2f;
        float hhEnd   = endHeight / 2f;

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
    private void renderTentacle(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments, int[] var, LivingEntity parent, float partial) {
        if (segments == null || segments.length < 2) return;
        float hurtTime = parent.hurtTime - partial;
        float flashIntensity = 0.0F;
        int mutationColor = type.getColor() == 0 ? -1 : type.getColor();
        Vec3 origin = null;
        if (hurtTime > 0) {
            flashIntensity = Math.min(hurtTime / 10.0F, 1.0F);
        }
        float baseR = ((mutationColor >> 16) & 0xFF) / 255f;
        float baseG = ((mutationColor >> 8) & 0xFF) / 255f;
        float baseB = (mutationColor & 0xFF) / 255f;
        float flash = flashIntensity * 0.5f;
        float g = Mth.lerp(flash, baseG, 0.2f);
        float b = Mth.lerp(flash, baseB, 0.2f);

        for (int i = 0; i < segments.length; i++) {
            Vec3 currentPos = segments[i];
            renderConnection(origin, currentPos,type,light, stack, buffer, i,var[i],partial,baseR,g,b,i == segments.length-1);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to,Type parent,int light, PoseStack stack, MultiBufferSource buffer,int index,int var , float partial
            ,float r,float g,float b,boolean last) {
        if (from == null || to == null) return;
        Vec3 direction = to.subtract(from);
        float length = (float) direction.length();
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);
        float size = index % 2 == 0 ? 1.2f : 1;
        stack.pushPose();
        {
            stack.translate(from.x, from.y, from.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            stack.pushPose();
            {
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TENTACLES));
                EntityModel<Type> typeEntityModel = last ? foot : getTentacleModel(var);
                stack.mulPose(Axis.XP.rotationDegrees(90));
                stack.translate(0,-length/2,0);
                stack.scale(size,length*1.05f,size);
                typeEntityModel.setupAnim(parent,0,0,parent.tickCount + partial,0,0);
                typeEntityModel.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY, r,g,b,1);
            }
            stack.popPose();
        }
        stack.popPose();
    }

}
