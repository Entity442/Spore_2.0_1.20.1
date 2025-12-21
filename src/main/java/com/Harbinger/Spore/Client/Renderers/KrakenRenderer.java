package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.GrakenMembraneLayer;
import com.Harbinger.Spore.Client.Layers.WaterCalamityCamo;
import com.Harbinger.Spore.Client.Models.GrakensenkerModel;
import com.Harbinger.Spore.Client.Models.KrakenTentacles.*;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Client.SpecialEffects;
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

@OnlyIn(Dist.CLIENT)
public class KrakenRenderer<Type extends Grakensenker> extends CalamityRenderer<Type , EntityModel<Type>> {
    private final Seg1<Type> tentacleSegmentModel1 = new Seg1<>();
    private final Seg2<Type> tentacleSegmentModel2 = new Seg2<>();
    private final Seg3<Type> tentacleSegmentModel3 = new Seg3<>();
    private final Seg4<Type> tentacleSegmentModel4 = new Seg4<>();
    private final Seg5<Type> tentacleSegmentModel5 = new Seg5<>();
    private final Seg6<Type> tentacleSegmentModel6 = new Seg6<>();
    private final Seg7<Type> tentacleSegmentModel7 = new Seg7<>();
    private final Seg8<Type> tentacleSegmentModel8 = new Seg8<>();
    private final Seg9<Type> tentacleSegmentModel9 = new Seg9<>();
    private final Seg10<Type> tentacleSegmentModel10 = new Seg10<>();
    private final Seg11<Type> tentacleSegmentModel11 = new Seg11<>();
    private final Seg12<Type> tentacleSegmentModel12 = new Seg12<>();
    private final FootSeg<Type> foot = new FootSeg<>();
    private final HandSeg1<Type> armModel1 = new HandSeg1<>();
    private final HandSeg2<Type> armModel2 = new HandSeg2<>();
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/graken.png");
    private static final ResourceLocation TENTACLES = new ResourceLocation(Spore.MODID,
            "textures/entity/kraken/kraken_t1.png");
    private static final ResourceLocation KRAKEN_HAND = new ResourceLocation(Spore.MODID,
            "textures/entity/kraken/hand.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/graken.png");
    private static final ResourceLocation WATER = new ResourceLocation(Spore.MODID,
            "textures/entity/vortex/water_vortex.png");
    private static final ResourceLocation WATER_RIPTIDE = new ResourceLocation(Spore.MODID,
            "textures/entity/vortex/vortex_riptide.png");

    public KrakenRenderer(EntityRendererProvider.Context context) {
        super(context, new GrakensenkerModel<>(), 4f);
        this.addLayer(new GrakenMembraneLayer<>(this));
        this.addLayer(new WaterCalamityCamo<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
    public EntityModel<Type> getTentacleModel(int i){
        return switch (i) {
            case 0 -> tentacleSegmentModel1;
            case 1 -> tentacleSegmentModel2;
            case 2 -> tentacleSegmentModel3;
            case 3 -> tentacleSegmentModel4;
            case 4 -> tentacleSegmentModel5;
            case 5 -> tentacleSegmentModel6;
            case 6 -> tentacleSegmentModel7;
            case 7 -> tentacleSegmentModel8;
            case 8 -> tentacleSegmentModel9;
            case 9 -> tentacleSegmentModel10;
            case 10 -> tentacleSegmentModel11;
            default -> tentacleSegmentModel12;
        };
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferSource, int light) {
        int color = entity.level().getBiome(entity.getOnPos()).value().getWaterColor();
        int packedColor = color | 0xFF000000;
        Entity camera = Minecraft.getInstance().getCameraEntity();
        float time = (entity.tickCount + partialTicks) * -0.25f;
        float time2 = (entity.tickCount + partialTicks) * -0.35f;
        stack.pushPose();
        stack.translate(0,entity.getExtendedHeight(),0);
        stack.mulPose(Axis.YP.rotationDegrees(entity.getWaterTicks()));
        super.render(entity, entityYaw, partialTicks, stack, bufferSource, light);
        stack.popPose();
        Vec3 entityPos = entity.getPosition(partialTicks);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            if (!entity.isInvisible()){
                renderTentacle(stack,entity,light, bufferSource, entity.getBackRightTentacle().getEntities(),entity.getBackRightTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getBackLeftTentacle().getEntities(),entity.getBackLeftTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getMiddleLeftTentacle().getEntities(),entity.getMiddleLeftTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getMiddleRightTentacle().getEntities(),entity.getMiddleRightTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getFrontLeftTentacle().getEntities(),entity.getFrontLeftTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getFrontRightTentacle().getEntities(),entity.getFrontRightTentacle().getSegmentVar(), entity,partialTicks,false,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getRightArmTentacle().getEntities(),entity.getRightArmTentacle().getSegmentVar(), entity,partialTicks,true,false);
                renderTentacle(stack,entity,light, bufferSource, entity.getLeftArmTentacle().getEntities(),entity.getLeftArmTentacle().getSegmentVar(), entity, partialTicks,true,true);

            }
            if (entity.hasVortex() && entity.getVortexTimeOut() <= 0){
                if (camera != null && camera.isEyeInFluidType(Fluids.WATER.getFluidType())){
                    PoseStack.Pose pose = stack.last();
                    Matrix4f matrix4f = pose.pose();
                    Matrix3f matrix3f = pose.normal();
                    SpecialEffects.renderFunnel(matrix4f,matrix3f,light, bufferSource, entity.getVortexFunnel().getEntities(),time,packedColor,1f,WATER);
                    SpecialEffects.renderFunnel(matrix4f,matrix3f,light, bufferSource, entity.getVortexFunnel().getEntities(),time,-1,1.1f,WATER_RIPTIDE);
                    SpecialEffects.renderFunnel(matrix4f,matrix3f,light, bufferSource, entity.getVortexFunnel().getEntities(),time2,packedColor,0.9f,WATER);
                }
            }
        }
        stack.popPose();
    }

    private void renderTentacle(PoseStack stack,Type type,int light, MultiBufferSource buffer, Vec3[] segments,int[] var, LivingEntity parent, float partial,boolean arm,boolean right) {
        if (segments == null || segments.length < 2) return;
        float hurtTime = parent.hurtTime - partial;
        float flashIntensity = 0.0F;
        int mutationColor = type.getMutationColor() == 0 ? -1 : type.getMutationColor();
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
            renderConnection(origin, currentPos,type,light, stack, buffer, i,var[i],partial,baseR,g,b,i == segments.length-1, arm,right);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to,Type parent,int light, PoseStack stack, MultiBufferSource buffer,int index,int var , float partial
            ,float r,float g,float b,boolean last,boolean arm,boolean right) {
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
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(arm ? KRAKEN_HAND : TENTACLES));
                EntityModel<Type> typeEntityModel = last ? arm ? right ? armModel1 : armModel2 : foot : getTentacleModel(var);
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
