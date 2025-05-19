package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedSpearModel;
import com.Harbinger.Spore.Client.Models.SickleModel;
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
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class SickleRenderer extends EntityRenderer<ThrownSickle> {
    private static final ResourceLocation SICKLE_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/infected_sickle.png");
    private static final ResourceLocation SPINE_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/spine.png");
    private final SickleModel<ThrownSickle> model;

    public SickleRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new SickleModel<>(context.bakeLayer(SickleModel.LAYER_LOCATION));
    }

    @Override
    public void render(ThrownSickle sickle, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        // Render the sickle model (local transform)
        poseStack.pushPose();
        poseStack.translate(0,-1,0);
        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, sickle.yRotO, sickle.getYRot())));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, sickle.xRotO, sickle.getXRot())));
        poseStack.scale(1.8f,1.8f,1.8f);
        VertexConsumer sickleConsumer = ItemRenderer.getFoilBufferDirect(bufferSource, model.renderType(getTextureLocation(sickle)), false, sickle.isFoil());
        model.renderToBuffer(poseStack, sickleConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        poseStack.popPose();

        // Tether: from sickle to player
        Entity owner = sickle.getOwner();
        if (owner != null) {
            renderConnection(sickle,owner,poseStack,bufferSource,partialTicks);
        }

        super.render(sickle, entityYaw, partialTicks, poseStack, bufferSource, light);
    }



    @Override
    public ResourceLocation getTextureLocation(ThrownSickle sickle) {
        return SICKLE_TEXTURE;
    }

    private void renderConnection(ThrownSickle parent , Entity to, PoseStack stack,
                                      MultiBufferSource buffer, float partialTick) {
        Vec3 start = parent.getPosition(partialTick).add(parent.getDeltaMovement().normalize().scale(-0.3));
        Vec3 vec3 = (new Vec3(0.2, 1.35, 0.6)).yRot(-to.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
        Vec3 end = to.getPosition(partialTick).add(vec3.x,vec3.y,vec3.z);

        Vec3 direction = end.subtract(start);
        float length = (float) direction.length();
        length = Math.max(length, 1.5f);
        direction = direction.normalize();

        float yaw = (float)Math.atan2(direction.x, direction.z);
        float pitch = (float)-Math.asin(direction.y);
        stack.pushPose();
        {
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));

            float startWidth = 0.5f;
            float startHeight = 0.5f;
            float endWidth = 0.5f;
            float endHeight = 0.5f;

            VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(SPINE_TEXTURE));
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
    }
}
