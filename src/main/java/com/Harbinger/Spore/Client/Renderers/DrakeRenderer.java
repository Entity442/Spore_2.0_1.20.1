package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.DrakeMembraneLayer;
import com.Harbinger.Spore.Client.Models.Cube;
import com.Harbinger.Spore.Client.Models.DragonBits.*;
import com.Harbinger.Spore.Client.Models.FungalDragonBodyModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DrakeRenderer<Type extends Verfalldrachen> extends CalamityRenderer<Type , EntityModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/verfalldrache.png");
    private static final ResourceLocation WHITE = new ResourceLocation(Spore.MODID,
            "textures/entity/blank.png");
    private static final ResourceLocation ELECTRICAL_HEAD = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_elec_head.png");
    private static final ResourceLocation ELECTRICAL_NECK = new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfa_elec_seg_start.png");

    public DrakeRenderer(EntityRendererProvider.Context context) {
        super(context, new FungalDragonBodyModel<>(), 5f);
        this.addLayer(new DrakeMembraneLayer<>(this));
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
    public void render(Type entity, float entityYaw, float partialTicks, PoseStack stack, MultiBufferSource bufferSource, int light) {
        super.render(entity, entityYaw, partialTicks, stack, bufferSource, light);
        Vec3 entityPos = entity.getPosition(partialTicks);
        stack.pushPose();
        {
            stack.translate(-entityPos.x, -entityPos.y, -entityPos.z);
            if (!entity.isInvisible()){
                renderTentacle(stack,entity,light, bufferSource, entity.getIkLightningHead().getEntities(), entity,partialTicks,LIMB.ELECTRICAL);
                renderTentacle(stack,entity,light, bufferSource, entity.getIkSoundHead().getEntities(), entity,partialTicks,LIMB.SOUND);
                renderTentacle(stack,entity,light, bufferSource, entity.getIkTarHead().getEntities(), entity,partialTicks,LIMB.TAR);
                renderTentacle(stack,entity,light, bufferSource, entity.getTail().getEntities(), entity,partialTicks,LIMB.TAIL);
            }
        }
        stack.popPose();
    }

    private void renderTentacle(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments, LivingEntity parent, float partial,LIMB limb) {
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
        float size = index % 2 == 0 ? 1.1f : 1;
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
                if (last){
                    EntityModel<Type> head = (EntityModel<Type>) limb.type;
                    stack.pushPose();
                    VertexConsumer ends = buffer.getBuffer(RenderType.entityCutoutNoCull(limb.headTexture));
                    stack.scale(0.85f,0.85f,0.85f);
                    stack.mulPose(Axis.XP.rotationDegrees(180));
                    stack.translate(0,-length-2,0);
                    head.setupAnim(parent,0,0,parent.tickCount + partial,0,0);
                    head.renderToBuffer(stack,ends,light, OverlayTexture.NO_OVERLAY, r,g,b,1);
                    stack.popPose();
                }
            }
            stack.popPose();
        }
        stack.popPose();
    }
    private enum LIMB{
        TAR(new TarDragonHead<>(),new Cube<>(),new Cube<>(),WHITE,WHITE),
        SOUND(new SonicDragonHeadModel<>(),new Cube<>(),new Cube<>(),WHITE,WHITE),
        ELECTRICAL(new ElectricalDragonHeadModel<>(),new DragonNeckPieceElectricModel<>(),new DragonNeckPieceElectricMidModel<>(),ELECTRICAL_HEAD,ELECTRICAL_NECK),
        TAIL(new Cube<>(),new Cube<>(),new Cube<>(),WHITE,WHITE);
        public final EntityModel<?> type;
        public final EntityModel<?> neckStartSegment;
        public final EntityModel<?> neckMiddleSegment;
        public final ResourceLocation headTexture;
        public final ResourceLocation segmentTexture;

        LIMB(EntityModel<?> type, EntityModel<?> neckStartSegment, EntityModel<?> neckMiddleSegment, ResourceLocation headTexture, ResourceLocation segmentTexture) {
            this.type = type;
            this.neckStartSegment = neckStartSegment;
            this.neckMiddleSegment = neckMiddleSegment;
            this.headTexture = headTexture;
            this.segmentTexture = segmentTexture;
        }
    }
}
