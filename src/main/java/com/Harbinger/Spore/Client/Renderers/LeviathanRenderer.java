package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.WaterCalamityCamo;
import com.Harbinger.Spore.Client.Models.KrakenTentacles.*;
import com.Harbinger.Spore.Client.Models.LeviathanModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.BaseEntities.IkUtil.IkLeviLeg;
import com.Harbinger.Spore.Sentities.Calamities.Leviathan;
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
public class LeviathanRenderer<Type extends Leviathan> extends CalamityRenderer<Type , LeviathanModel<Type>> {
    private final Seg1<Type> tentacleSegmentModel1 = new Seg1<>();
    private final Seg2<Type> tentacleSegmentModel2 = new Seg2<>();
    private final Seg3<Type> tentacleSegmentModel3 = new Seg3<>();
    private final Seg4<Type> tentacleSegmentModel4 = new Seg4<>();
    private final Seg5<Type> tentacleSegmentModel5 = new Seg5<>();
    private final Seg6<Type> tentacleSegmentModel6 = new Seg6<>();
    private final FootSegLevi<Type> foot = new FootSegLevi<>();
    private final FinPart1Model<Type> flip1 = new FinPart1Model<>();
    private final FinPart2Model<Type> flip2 = new FinPart2Model<>();
    private final FinPart3Model<Type> flip3 = new FinPart3Model<>();
    private final FinPart4Model<Type> flip4 = new FinPart4Model<>();
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/leviathan.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/leviathan.png");
    private static final ResourceLocation TENTACLES = new ResourceLocation(Spore.MODID,
            "textures/entity/kraken/kraken_t1.png");
    private static final ResourceLocation FIN = new ResourceLocation(Spore.MODID,
            "textures/entity/kraken/levi1.png");

    public LeviathanRenderer(EntityRendererProvider.Context context) {
        super(context, new LeviathanModel<>(), 4f);
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
    public EntityModel<Type> getFlipModel(int i){
        return switch (i) {
            case 1 -> flip2;
            case 2 -> flip3;
            case 3 -> flip4;
            default -> flip1;
        };
    }
    @Override
    public ResourceLocation getTextureLocation(Type entity) {return TEXTURE;}
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
                for (IkLeviLeg leg : entity.getLegs()){
                    renderTentacle(stack,entity,light, bufferSource, leg.getEntities(),leg.getSegmentVar(), entity,partialTicks,false,false);
                }
                if (entity.getFins().length > 1){
                    renderTentacle(stack,entity,light, bufferSource, entity.getFins()[0].getEntities(),null, entity,partialTicks,true,true);
                    renderTentacle(stack,entity,light, bufferSource, entity.getFins()[1].getEntities(),null, entity,partialTicks,true,false);
                }
            }
        }
        stack.popPose();
    }

    private void renderTentacle(PoseStack stack, Type type, int light, MultiBufferSource buffer, Vec3[] segments, int[] var, LivingEntity parent, float partial, boolean arm,boolean right) {
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
            int e = var == null ? i : var[i];
            Vec3 currentPos = segments[i];
            renderConnection(origin, currentPos,type,light, stack, buffer, i,e,partial,baseR,g,b,i == segments.length-1, arm,right);
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
        float size =arm ?  index % 2 == 0 ? 1.75f : 1.5f  : index % 2 == 0 ? 1.2f : 1;
        stack.pushPose();
        {
            stack.translate(from.x, from.y, from.z);
            stack.mulPose(Axis.YP.rotation(yaw));
            stack.mulPose(Axis.XP.rotation(pitch));
            if (arm){
                stack.mulPose(Axis.ZP.rotation(right ? 90 : -90));
            }
            stack.pushPose();
            {
                VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutoutNoCull(arm ? FIN : TENTACLES));
                EntityModel<Type> typeEntityModel =arm ? getFlipModel(var) : last ? foot : getTentacleModel(var);
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
