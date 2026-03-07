package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HarpoonModel;
import com.Harbinger.Spore.Client.Models.KrakenTentacles.ChainModel;
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import com.Harbinger.Spore.Sentities.Projectile.HarpoonProjectile;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class HarpoonRenderer extends EntityRenderer<HarpoonProjectile> {
    public static final ResourceLocation TEXTURE_LOCATION =new ResourceLocation(Spore.MODID,"textures/entity/graken_ship.png");
    public static final ResourceLocation CHAIN_LOCATION =new ResourceLocation(Spore.MODID,"textures/entity/chains.png");
    private final EntityModel<HarpoonProjectile> chains = new ChainModel<>();
    private final HarpoonModel<HarpoonProjectile> model;
    protected List<Vec3> entities = new ArrayList<>();
    public HarpoonRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new HarpoonModel<>();
    }

    public void render(HarpoonProjectile spear, float p_116112_, float partial, PoseStack stack, MultiBufferSource bufferSource, int light) {
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partial, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partial, spear.xRotO, spear.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(spear)));
        this.model.renderToBuffer(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1,1,1,1);
        stack.popPose();
        super.render(spear, p_116112_, partial, stack, bufferSource, light);
        Entity entity = spear.level().getEntity(spear.getOwnerId());
        if (entity == null){
            return;
        }
        Vec3 vec3;
        if (entity instanceof Grakensenker grakensenker){
            float yawRad = grakensenker.getYRot() * Mth.DEG_TO_RAD;
            float spinRad = grakensenker.getWaterTicks() * 0.05f;
            Vec3 offset = new Vec3(3,4.75+grakensenker.getExtendedHeight(),0.65);
            vec3 = grakensenker.getPosition(partial).add(offset.yRot(-yawRad - Mth.HALF_PI + spinRad));
        }else {
            vec3 = entity.getPosition(partial);
        }
        Vec3 entityPos = spear.getPosition(partial);
        applyIK(partial,spear,vec3);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            renderChain(stack,light,bufferSource);
        }
        stack.popPose();
    }
    public ResourceLocation getTextureLocation(HarpoonProjectile p_116109_) {
        return TEXTURE_LOCATION;
    }

    protected void moveSegmentTowards(int index, Vec3 target,boolean far) {
        Vec3 currentPos = entities.get(index);
        Vec3 newPos = currentPos.lerp(target, 0.35f);
        entities.set(index,(far ? target : newPos));
    }
    public void applyIK(float partial, HarpoonProjectile t,Vec3 camera) {
        Vec3 basePos = t.getPosition(partial);
        rebuildChain(basePos, camera);
        if (entities == null || entities.size() < 3) return;
        moveSegmentTowards(entities.size()-1, camera,true);
        for (int i = entities.size() - 2; i >= 0; i--) {
            Vec3 nextPos = entities.get(i + 1);
            Vec3 dir = entities.get(i).subtract(nextPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = nextPos.add(dir);
            moveSegmentTowards(i, solvedPos, entities.get(i + 1).distanceTo(entities.get(i)) > 10);
        }
        entities.set(0,basePos);

        for (int i = 1; i < entities.size(); i++) {
            Vec3 prevPos = entities.get(i - 1);
            Vec3 dir = entities.get(i).subtract(prevPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(i, solvedPos, entities.get(i-1).distanceTo(entities.get(i)) > 10);
        }
    }
    private void rebuildChain(Vec3 start, Vec3 end){

        double distance = start.distanceTo(end);

        int desiredSegments = Mth.clamp((int)(distance * 1.1), 4, 40);

        if(desiredSegments == entities.size()) return;

        entities.clear();

        for(int i = 0; i < desiredSegments; i++){

            double t = (double)i/(desiredSegments-1);

            entities.add(new Vec3(
                    Mth.lerp(t,start.x,end.x),
                    Mth.lerp(t,start.y,end.y),
                    Mth.lerp(t,start.z,end.z)
            ));
        }
    }
    private void renderChain(PoseStack stack, int light, MultiBufferSource buffer) {
        if (entities == null || entities.size() < 2) return;
        Vec3 origin = null;

        for (int i = 0; i < entities.size(); i++) {
            Vec3 currentPos = entities.get(i);
            renderConnection(origin, currentPos,light, stack, buffer, i);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to,int light, PoseStack stack, MultiBufferSource buffer,int index) {
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
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(CHAIN_LOCATION));
                stack.mulPose(Axis.XP.rotationDegrees(90));
                stack.translate(0,-length/2,0);
                stack.scale(size,length*1.05f,size);
                chains.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY, 1,1,1,1);
            }
            stack.popPose();
        }
        stack.popPose();
    }
}