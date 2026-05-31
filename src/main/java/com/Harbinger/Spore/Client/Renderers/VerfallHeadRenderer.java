package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.DragonBits.*;
import com.Harbinger.Spore.Sentities.AmbientSparks;
import com.Harbinger.Spore.Sentities.FallenMultipart.DragonHead;
import com.Harbinger.Spore.Sentities.Variants.DragonHeadVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class VerfallHeadRenderer<Type extends DragonHead> extends MobRenderer<Type , EntityModel<Type>> {
    private static final ResourceLocation ELECTRICAL_HEAD = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_elec_head.png");
    private static final ResourceLocation ELECTRICAL_NECK = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_elec_seg_start.png");
    private static final ResourceLocation SONIC_HEAD = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/sonic_dragon_head.png");
    private static final ResourceLocation SONIC_NECK = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_sonic_seg.png");
    private static final ResourceLocation TAR_HEAD = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/tar_dragon_head.png");
    private static final ResourceLocation TAR_NECK = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_tar_seg.png");
    private static final ResourceLocation POWER_LOCATION =new ResourceLocation("textures/entity/creeper/creeper_armor.png");


    private static final ResourceLocation TAR_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/tar_dragon_eyes.png");
    private static final ResourceLocation SONIC_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/sonic_dragon_eyes.png");
    private static final ResourceLocation ELEC_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/elec_dragon_eyes.png");
    private final EntityModel<Type> bolt = new ConductorRenderer.BoltBit<>();
    public static final Map<DragonHeadVariants,LIMB> ASSETS = Util.make(Maps.newEnumMap(DragonHeadVariants.class), (UwU) -> {
        UwU.put(DragonHeadVariants.TAR,LIMB.TAR);
        UwU.put(DragonHeadVariants.ELECTRIC,LIMB.ELECTRICAL);
        UwU.put(DragonHeadVariants.SONIC,LIMB.SOUND);
    });


    public VerfallHeadRenderer(EntityRendererProvider.Context context) {
        super(context, new TarDragonHead<>(), 0.5f);
        this.addLayer(new VerfallHeadFallenEyes<>(this));
    }

    @Override
    public void render(Type type, float yaw, float partial, PoseStack stack, MultiBufferSource bufferSource, int light) {
        model = (EntityModel<Type>) ASSETS.get(type.getVariant()).type;
        stack.pushPose();
        stack.mulPose(Axis.XP.rotationDegrees(60));
        stack.translate(0,0,-0.75);
        stack.scale(0.75f,0.75f,0.75f);
        super.render(type, yaw, partial, stack, bufferSource, light);
        stack.popPose();
        Vec3 entityPos = type.getPosition(partial);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            if (!type.isInvisible()){
                renderTentacle(stack,type,light, bufferSource, type.getNeck().getEntities(), type,partial, ASSETS.get(type.getVariant()));
            }
            if (type.getCharge() > 0){
                for (AmbientSparks sparks : type.getSparks()){
                    renderChain(sparks.getConnections(),stack,light,bufferSource,true);
                }
            }
            stack.popPose();
        }
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return ASSETS.get(entity.getVariant()).headTexture;
    }


    public enum LIMB{
        TAR(new TarDragonHead<>(),new DragonNeckPieceTarModel<>(),new DragonNeckPieceTarMidModel<>(),TAR_HEAD,TAR_NECK,TAR_EYES),
        SOUND(new SonicDragonHeadModel<>(),new DragonNeckPieceSonicModel<>(),new DragonNeckPieceSonicMidModel<>(),SONIC_HEAD,SONIC_NECK,SONIC_EYES),
        ELECTRICAL(new ElectricalDragonHeadModel<>(),new DragonNeckPieceElectricModel<>(),new DragonNeckPieceElectricMidModel<>(),ELECTRICAL_HEAD,ELECTRICAL_NECK,ELEC_EYES);
        public final EntityModel<?> type;
        public final EntityModel<?> neckStartSegment;
        public final EntityModel<?> neckMiddleSegment;
        public final ResourceLocation headTexture;
        public final ResourceLocation segmentTexture;
        public final ResourceLocation eyesTexture;

        LIMB(EntityModel<?> type, EntityModel<?> neckStartSegment, EntityModel<?> neckMiddleSegment, ResourceLocation headTexture, ResourceLocation segmentTexture, ResourceLocation eyesTexture) {
            this.type = type;
            this.neckStartSegment = neckStartSegment;
            this.neckMiddleSegment = neckMiddleSegment;
            this.headTexture = headTexture;
            this.segmentTexture = segmentTexture;
            this.eyesTexture = eyesTexture;
        }
    }

    public class VerfallHeadFallenEyes<T extends DragonHead, M extends EntityModel<T>> extends RenderLayer<T, M> {

        public VerfallHeadFallenEyes(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.eyes(VerfallHeadRenderer.ASSETS.get(t.getVariant()).eyesTexture));
            this.getParentModel().renderToBuffer(poseStack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY,1,1,1,1);
        }
    }

    private void renderTentacle(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments, LivingEntity parent, float partial, LIMB limb) {
        if (segments == null || segments.length < 2) return;
        float hurtTime = parent.hurtTime - partial;
        float flashIntensity = 0.0F;
        Vec3 origin = null;
        if (hurtTime > 0) {
            flashIntensity = Math.min(hurtTime / 10.0F, 1.0F);
        }
        float baseG = 1;
        float baseB = 1;
        float flash = flashIntensity * 0.5f;
        float g = Mth.lerp(flash, baseG, 0.2f);
        float b = Mth.lerp(flash, baseB, 0.2f);

        for (int i = 0; i < segments.length; i++) {
            Vec3 currentPos = segments[i];
            renderConnection(origin, currentPos,type,light, stack, buffer, i,partial,1,g,b,i == segments.length-1,limb);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to, Type parent, int light, PoseStack stack, MultiBufferSource buffer, int index, float partial
            , float r, float g, float b, boolean last, LIMB limb) {
        if (from == null || to == null) return;
        Vec3 direction = to.subtract(from);
        float length = (float) direction.length();
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);
        float size = index % 2 == 0 ? 0.85f : 0.75f;
        stack.pushPose();
        {
            stack.translate(from.x, from.y, from.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            stack.pushPose();
            {
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(limb.segmentTexture));
                EntityModel<Type> typeEntityModel = last ? (EntityModel<Type>) limb.neckStartSegment : (EntityModel<Type>) limb.neckMiddleSegment;
                stack.mulPose(Axis.XP.rotationDegrees( 90));
                stack.translate(0,-length/2,0);
                stack.scale(size,length*1.05f,size);
                typeEntityModel.setupAnim(parent,0,0,parent.tickCount + partial,0,0);
                typeEntityModel.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY, r,g,b,1);
                boolean electric = limb == LIMB.ELECTRICAL && parent.getCharge() > 0;
                if (electric){
                    renderCharge(typeEntityModel,parent,buffer,stack,light,partial);
                }
            }
            stack.popPose();
        }
        stack.popPose();
    }
    private void renderCharge(EntityModel<Type> brain, Type livingEntity,MultiBufferSource buffer,PoseStack stack, int packedLight,float partialTicks){
        if (brain instanceof ElectricalBrain electricalBrain){
            stack.pushPose();
            for(ModelPart part : electricalBrain.positionList()){
                part.translateAndRotate(stack);
            }
            float f = ((float)livingEntity.tickCount + partialTicks);
            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.energySwirl(POWER_LOCATION, livingEntity.tickCount * 0.01F % 1.0F, f * 0.01F % 1.0F));
            electricalBrain.getBrain().render(stack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, -8355712,1,1,1);
            stack.popPose();
        }
    }
    private void renderChain(List<Vec3> entities, PoseStack stack, int light, MultiBufferSource buffer, boolean extra) {
        if (entities == null || entities.size() < 2) return;
        Vec3 origin = null;

        for (Vec3 currentPos : entities) {
            renderConnection(origin, currentPos, light, stack, buffer,extra);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to,int light, PoseStack stack, MultiBufferSource buffer,boolean extra) {
        if (from == null || to == null) return;
        Vec3 direction = to.subtract(from);
        float length = (float) direction.length();
        if (length < 0.0001f) return;
        float thickness = extra ? 2 : 1;
        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);
        stack.pushPose();
        {
            stack.translate(from.x, from.y, from.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            stack.pushPose();
            {
                stack.mulPose(Axis.XP.rotationDegrees(90));
                stack.translate(0,-length/2,0);
                stack.scale(thickness,length*1.05f,thickness);
                VertexConsumer consumer = buffer.getBuffer(RenderType.lightning());
                renderBit(stack,light,consumer);
            }
            stack.popPose();
        }
        stack.popPose();
    }
    public void renderBit(PoseStack stack,int light,VertexConsumer consumer){
        bolt.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY, 1,1,1,1);
    }
}