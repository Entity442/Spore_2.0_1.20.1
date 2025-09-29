package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Models.SyringeGunModel;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class SyringeGunPart extends ComplexHandModelItem{
    private final SyringeGunModel<LivingEntity> parentModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun_juice.png");
    public SyringeGunPart(InteractionHand slot, SyringeGunModel<LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin) {
        super(slot, Sitems.SYRINGE_GUN.get(), model, part, x, y, z, expand, xspin, yspin, zspin);
        parentModel = model;
    }

    @Override
    public RenderType type(ResourceLocation location) {
        return RenderType.entityTranslucent(location);
    }

    @Override
    public void renderCustomHand(LivingEntity livingEntity, ItemStack stack, float partialTicks, int light, MultiBufferSource bufferSource, PoseStack poseStack, ResourceLocation location) {
        super.renderCustomHand(livingEntity, stack, partialTicks, light, bufferSource, poseStack, location);
        handleColorRendering(parentModel.syringe, SporeToolsMutations.TOXIC.getColor(), poseStack,bufferSource,light,location);
        handleColorRendering(parentModel.syringe2, SporeToolsMutations.CALCIFIED.getColor(), poseStack,bufferSource,light,location);
        handleColorRendering(parentModel.syringe3, SporeToolsMutations.VAMPIRIC.getColor(), poseStack,bufferSource,light,location);
        handleColorRendering(parentModel.syringe4, SporeToolsMutations.DEFAULT.getColor(), poseStack,bufferSource,light,location);
    }

    public void handleColorRendering(ModelPart syringe,int color,PoseStack stack,MultiBufferSource source,int light,ResourceLocation additionalTexture){
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        VertexConsumer consumer = source.getBuffer(RenderType.entityCutout(TEXTURE));
        VertexConsumer consumerS = source.getBuffer(type(additionalTexture));
        stack.pushPose();
        parentModel.syringeGun.translateAndRotate(stack);
        parentModel.magazine.translateAndRotate(stack);
        if (color != -1){
            syringe.render(stack,consumer,light, OverlayTexture.NO_OVERLAY,r,g,b,1);
        }
        syringe.render(stack,consumerS,light, OverlayTexture.NO_OVERLAY);
        stack.popPose();
    }
}
