package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.DrakeMembraneLayer;
import com.Harbinger.Spore.Client.Models.DragonBits.*;
import com.Harbinger.Spore.Client.Models.FungalDragonBodyModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.AmbientSparks;
import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class DrakeRenderer<Type extends Verfalldrachen> extends CalamityRenderer<Type , EntityModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache.png");
    private static final ResourceLocation NO_WINGS = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache_wings_down.png");
    private static final ResourceLocation NO_RIGHT_WING = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache_right_wing.png");
    private static final ResourceLocation NO_LEFT_WING = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache_left_wing.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/verfalldrache.png");
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

    private static final ResourceLocation TAR_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/tar_dragon_eyes.png");
    private static final ResourceLocation SONIC_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/sonic_dragon_eyes.png");
    private static final ResourceLocation ELEC_EYES = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/eyes/elec_dragon_eyes.png");

    private static final ResourceLocation TAIL = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_tail_seg.png");

    private final EntityModel<Type> bolt = new ConductorRenderer.BoltBit<>();
    private static final ResourceLocation POWER_LOCATION =new ResourceLocation("textures/entity/creeper/creeper_armor.png");


    private final DragonTailPieceStartModel<Type> tailStart = new DragonTailPieceStartModel<>();
    private final DragonTailPieceMid1Model<Type> tailMidSec1 = new DragonTailPieceMid1Model<>();
    private final DragonTailPieceTransitionModel<Type> tailMiddle = new DragonTailPieceTransitionModel<>();
    private final DragonTailPieceMid2Model<Type> tailMidSec2 = new DragonTailPieceMid2Model<>();
    private final DragonTailPieceEndModel<Type> tailEnd = new DragonTailPieceEndModel<>();
    public DrakeRenderer(EntityRendererProvider.Context context) {
        super(context, new FungalDragonBodyModel<>(), 5f);
        this.addLayer(new DrakeMembraneLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        int i = entity.getWingData();
        return i == 3 ? NO_WINGS : i == 2 ? NO_RIGHT_WING : i == 1 ? NO_LEFT_WING : TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }


    @Override
    public void render(Type entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferSource, int light) {
        super.render(entity, entityYaw, partialTicks, stack, bufferSource, light);
        Vec3 entityPos = entity.getPosition(partialTicks);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            if (!entity.isInvisible()){
                renderTentacle(stack,entity,light, bufferSource, entity.getIkLightningHead().getEntities(),entity.getElectricalHeadSegment(), entity,partialTicks,LIMB.ELECTRICAL);
                renderTentacle(stack,entity,light, bufferSource, entity.getIkSoundHead().getEntities(),entity.getSonicHeadSegment(), entity,partialTicks,LIMB.SOUND);
                renderTentacle(stack,entity,light, bufferSource, entity.getIkTarHead().getEntities(),entity.getTarHeadSegment(), entity,partialTicks,LIMB.TAR);
                renderTail(stack,entity,light, bufferSource, entity.getTail().getEntities(), entity,partialTicks);
            }
            if (entity.getCharge() > 0 && entity.getElectricalHead() > 0){
                for (AmbientSparks sparks : entity.getSparks()){
                    renderChain(sparks.getConnections(),stack,light,bufferSource,false);
                }
            }
        }
        stack.popPose();
    }

    private void renderTentacle(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments,int segment, LivingEntity parent, float partial,LIMB limb) {
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
            if (i > segment){
                break;
            }
            Vec3 currentPos = segments[i];
            renderConnection(origin, currentPos,type,light, stack, buffer, i,partial,baseR,g,b,i == 1,i == segments.length-1,limb);
            origin = currentPos;
        }
    }
    private void renderConnection(Vec3 from, Vec3 to,Type parent,int light, PoseStack stack, MultiBufferSource buffer,int index, float partial
            ,float r,float g,float b,boolean first,boolean last,LIMB limb) {
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
                EntityModel<Type> typeEntityModel = first ? (EntityModel<Type>) limb.neckStartSegment : (EntityModel<Type>) limb.neckMiddleSegment;
                stack.mulPose(Axis.XP.rotationDegrees(90));
                stack.translate(0,-length/2,0);
                stack.scale(size,length*1.05f,size);
                typeEntityModel.setupAnim(parent,0,0,parent.tickCount + partial,0,0);
                typeEntityModel.renderToBuffer(stack,consumer,light, OverlayTexture.NO_OVERLAY, r,g,b,1);
                boolean electric = limb == LIMB.ELECTRICAL && parent.getCharge() > 0;
                if (electric){
                    renderCharge(typeEntityModel,parent,buffer,stack,light,partial);
                }
                if (last){
                    EntityModel<Type> head = (EntityModel<Type>) limb.type;
                    stack.pushPose();
                    VertexConsumer ends = buffer.getBuffer(RenderType.entityCutoutNoCull(limb.headTexture));
                    stack.scale(0.85f,0.85f,0.85f);
                    stack.mulPose(Axis.XP.rotationDegrees(180));
                    stack.translate(0,-length-2,0);
                    head.setupAnim(parent,0,0,parent.tickCount + partial,0,0);
                    head.renderToBuffer(stack,ends,light, OverlayTexture.NO_OVERLAY, r,g,b,1);
                    renderEyes(head,limb.eyesTexture,buffer,stack);
                    if (electric){
                        renderCharge(head,parent,buffer,stack,light,partial);
                    }
                    stack.popPose();
                }
            }
            stack.popPose();
        }
        stack.popPose();
    }
    private void renderEyes(EntityModel<Type> head,ResourceLocation location,MultiBufferSource buffer,PoseStack stack){
        VertexConsumer eyes = buffer.getBuffer(RenderType.eyes(location));
        head.renderToBuffer(stack,eyes,15728640, OverlayTexture.NO_OVERLAY, 1,1,1,1);
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

    private enum LIMB{
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

    private void renderTail(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments, LivingEntity parent, float partial) {
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
            renderConnectionTail(origin, currentPos,type,light, stack, buffer, i,partial,baseR,g,b,i == 1,i == segments.length-1,i==segments.length/2,i<segments.length/2);
            origin = currentPos;
        }
    }
    private void renderConnectionTail(Vec3 from, Vec3 to,Type parent,int light, PoseStack stack, MultiBufferSource buffer,int index, float partial
            ,float r,float g,float b,boolean first,boolean last,boolean middle,boolean belowMiddle) {
        if (from == null || to == null) return;
        Vec3 direction = to.subtract(from);
        float length = (float) direction.length();
        if (length < 0.0001f) return;

        direction = direction.normalize();

        float yaw = (float) Math.atan2(direction.x, direction.z);
        float pitch = (float) -Math.asin(direction.y);
        float size = index % 2 == 0 ? 1.1f : 1;
        stack.pushPose();
        {
            stack.translate(from.x, from.y, from.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            stack.pushPose();
            {
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TAIL));
                EntityModel<Type> typeEntityModel = first ? tailStart : middle ? tailMiddle : belowMiddle ? tailMidSec1 : last ? tailEnd : tailMidSec2;
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
