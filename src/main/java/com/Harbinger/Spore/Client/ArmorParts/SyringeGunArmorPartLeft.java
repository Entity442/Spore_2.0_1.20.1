package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Models.SyringeGunModelArm;
import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeToolsMutations;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class SyringeGunArmorPartLeft extends BaseArmorRenderingBit{
    private final SyringeGunModelArm<LivingEntity> parentModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation("spore:textures/item/syringe_gun_juice.png");
    private static final ResourceLocation TEXTURET = new ResourceLocation("spore:textures/item/syringe_gun.png");
    public SyringeGunArmorPartLeft(SyringeGunModelArm<LivingEntity> parentModel,Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, float x, float y, float z, float expand) {
        super(EquipmentSlot.OFFHAND, Sitems.SYRINGE_GUN.get(), model, part, x, y, z, expand);
        this.parentModel = parentModel;
    }
    @Override
    protected VertexConsumer consumer(MultiBufferSource source, CustomModelArmorData data, HumanoidModel<LivingEntity> model, LivingEntity livingEntity) {
        return ItemRenderer.getFoilBufferDirect(source, RenderType.entityTranslucent(data.getTextureLocation()), false, stack(livingEntity).hasFoil());
    }
    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.leftArm;
    }

    @Override
    public void tickMovement(LivingEntity livingEntity, PoseStack poseStack, HumanoidModel<LivingEntity> model, int light, MultiBufferSource buffer) {
        super.tickMovement(livingEntity, poseStack, model, light, buffer);
        ItemStack itemStack = stack(livingEntity);
        if (itemStack.getItem().equals(item)){
            applyTransformEx(poseStack,getPiece(model),this.x,this.y,this.z,this.expand,this.Xspin,this.Yspin,this.Zspin,() -> {
                handleColorRendering(parentModel.syringe, SporeToolsMutations.TOXIC.getColor(), poseStack,buffer,light,TEXTURET);
                handleColorRendering(parentModel.syringe2, SporeToolsMutations.CALCIFIED.getColor(), poseStack,buffer,light,TEXTURET);
                handleColorRendering(parentModel.syringe3, SporeToolsMutations.VAMPIRIC.getColor(), poseStack,buffer,light,TEXTURET);
                handleColorRendering(parentModel.syringe4, SporeToolsMutations.DEFAULT.getColor(), poseStack,buffer,light,TEXTURET);
            });
        }
    }

    public void handleColorRendering(ModelPart syringe, int color, PoseStack stack, MultiBufferSource source, int light, ResourceLocation additionalTexture){
        float r = (float) (color >> 16 & 255) / 255.0F;
        float g = (float) (color >> 8 & 255) / 255.0F;
        float b = (float) (color & 255) / 255.0F;
        VertexConsumer consumer = source.getBuffer(RenderType.entityCutout(TEXTURE));
        VertexConsumer consumerS = source.getBuffer(RenderType.entityTranslucent(additionalTexture));
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
