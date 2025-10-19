package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SegmentBase;
import com.Harbinger.Spore.Client.Models.TentacleSegmentModel;
import com.Harbinger.Spore.Client.Models.TentacleSegmentModel2;
import com.Harbinger.Spore.Client.Models.TentacleSegmentModel3;
import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
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
import net.minecraftforge.entity.PartEntity;

public class TentacleRenderer extends MobRenderer<Tentacle, EntityModel<Tentacle>> {
    private final TentacleSegmentModel<Entity> tentacleModel2;
    private final TentacleSegmentModel2<Entity> tentacleModel1;
    private final TentacleSegmentModel3<Entity> tentacleModel3;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle_base.png");
    private static final ResourceLocation TENTACLE_SEG = new ResourceLocation(Spore.MODID,
            "textures/entity/tentacle.png");

    public TentacleRenderer(EntityRendererProvider.Context context) {
        super(context, new SegmentBase<>(), 0.2f);
        tentacleModel2 = new TentacleSegmentModel<>();
        tentacleModel1 = new TentacleSegmentModel2<>();
        tentacleModel3 = new TentacleSegmentModel3<>();
    }
    public EntityModel<Entity> getProperModel(int val){
        switch (val){
            case 1 -> {
                return tentacleModel1;
            }
            case 2 -> {
                return tentacleModel3;
            }
            default -> {
                return tentacleModel2;
            }
        }
    }

    @Override
    public void render(Tentacle entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource buffer, int packedLight) {
        super.render(entity, entityYaw, partialTicks, stack, buffer, packedLight);
        Vec3 entityPos = entity.getPosition(partialTicks);
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

    private void renderTentacle(PoseStack stack, MultiBufferSource buffer, PartEntity<?>[] segments, LivingEntity parent, float partial) {
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
            renderConnection(entity, currentPos, stack, buffer, i,partial,red,green,blue);

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

    private void renderConnection(Entity from, Entity to, PoseStack stack, MultiBufferSource buffer,int index , float partial
    ,float r,float g, float b) {
        if (from == null || to == null) return;
        Vec3 goingTo =processPosition(from,partial);
        Vec3 direction = processPosition(to,partial).subtract(goingTo);
        float length = (float) direction.length();
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);

        stack.pushPose();
        {
            stack.translate(goingTo.x, goingTo.y, goingTo.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            VertexConsumer consumer = buffer.getBuffer(RenderType.entityTranslucent(TENTACLE_SEG));
            stack.pushPose();
            {
                EntityModel<Entity> model = getProperModel(index);
                stack.mulPose(Axis.XP.rotationDegrees(90));
                stack.translate(0,-length/2,0);
                stack.scale(1,length*1.05f,1);
                model.setupAnim(from,0,0,from.tickCount + partial,0,0);
                model.renderToBuffer(stack,consumer,15728880,OverlayTexture.NO_OVERLAY, r, g, b, 1f);
            }
            stack.popPose();
        }
        stack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(Tentacle tentacle) {
        return TEXTURE;
    }
}