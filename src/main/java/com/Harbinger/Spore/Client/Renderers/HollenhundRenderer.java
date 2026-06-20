package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HollenSpike;
import com.Harbinger.Spore.Client.Models.HollenhundModel;
import com.Harbinger.Spore.Client.Models.HollenhundRangedModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Hollenhund;
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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class HollenhundRenderer<Type extends Hollenhund> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = getModel();
    private final EntityModel<Type> rangedMode;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hollenhund.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/hollenhund.png");
    private static final ResourceLocation SPIKE = new ResourceLocation(Spore.MODID,
            "textures/entity/hollenclaw.png");
    private final HollenSpike<Type> spike = new HollenSpike<>();
    public HollenhundRenderer(EntityRendererProvider.Context context) {
        super(context, new HollenhundModel<>(context.bakeLayer(HollenhundModel.LAYER_LOCATION)), 0.5f);
        rangedMode = new HollenhundRangedModel<>(context.bakeLayer(HollenhundRangedModel.LAYER_LOCATION));
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
    public void render(Type type, float p_115456_, float p_115457_, PoseStack stack, MultiBufferSource bufferSource, int light) {
        model = type.isRanged() ? rangedMode : defaultModel;
        shadowRadius = type.isUnderground() ? 0f : 0.5f;
        stack.pushPose();
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight() * 2;
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / type.getBorrow_tick()) * type.getBorrow();
            }else if (type.isEmerging()){
                b =-0.5f-a + ((a / type.getEmerge_tick()) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        if (type.isEmerging() || type.isBurrowing() || !type.isUnderground()){
            super.render(type, p_115456_, p_115457_, stack, bufferSource, light);
        }
        stack.popPose();
        List<Hollenhund.spikeClaw> claws = type.getClaws();
        if (claws.isEmpty() || type.isEmerging()){
            return;
        }
        stack.pushPose();
        {
            stack.translate(0, 3, 0);
            stack.mulPose(Axis.ZP.rotationDegrees(-180F));
            stack.pushPose();
            for (Hollenhund.spikeClaw claw : claws){
                stack.pushPose();
                {
                    float b =(3.5f / (claw.getMaxLife() - claw.getLife()));
                    stack.mulPose(Axis.ZP.rotationDegrees(claw.getZspin()));
                    stack.mulPose(Axis.YP.rotationDegrees(claw.getYspin()));
                    stack.translate(claw.getOffset().x(), b, claw.getOffset().z());
                    stack.scale(2f, 2f, 2f);
                    VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityCutout(SPIKE));
                    spike.renderToBuffer(stack, consumer, light, OverlayTexture.NO_OVERLAY, 1,1,1,1);
                }
                stack.popPose();
            }
            stack.popPose();
        }
        stack.popPose();
    }

    @Override
    protected boolean isShaking(Type type) {
        return super.isShaking(type) || type.isBurrowing() || type.isEmerging();
    }


}