package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Layers.CustomHorseArmorLayer;
import com.Harbinger.Spore.Client.Models.LivingHorseArmorModel;
import com.Harbinger.Spore.Client.Models.PlatedHorseArmorModel;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class LivingHorseArmorBit extends HorseArmorBit{
    private  final LivingHorseArmorModel<AbstractHorse> platedHorseArmorModel = new LivingHorseArmorModel<>();
    public LivingHorseArmorBit(Item item) {
        super(item);
    }

    public EntityModel<AbstractHorse> getModel(){
        return platedHorseArmorModel;
    }
    public void tickMovement(AbstractHorse livingEntity, PoseStack poseStack, CustomHorseArmorLayer.HorseHandlerModel<AbstractHorse> model, int light, MultiBufferSource buffer){
        ItemStack itemStack = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
        if (itemStack.isEmpty()) {
            return;
        }
        float red;
        float green;
        float blue;
        if (itemStack.getItem() instanceof SporeArmorData armorData){
            int color = armorData.getVariant(itemStack).getColor();
            red = (color >> 16 & 255) / 255.0F;
            green = (color >> 8 & 255) / 255.0F;
            blue = (color & 255) / 255.0F;
        } else {
            red = 1f;
            blue = 1f;
            green = 1f;
        }
        if (itemStack.getItem() instanceof CustomModelArmorData armorData && itemStack.getItem().equals(item)){
            VertexConsumer consumer = consumer(buffer,armorData,model,livingEntity);
            ModelPart head = platedHorseArmorModel.Neck;
            ModelPart body = platedHorseArmorModel.Body;
            ModelPart rightFront = platedHorseArmorModel.FrontRightLeg;
            ModelPart leftFront = platedHorseArmorModel.FrontLeftLeg;
            ModelPart rightBack = platedHorseArmorModel.BackRightLeg;
            ModelPart leftBack = platedHorseArmorModel.BackLeftLeg;
            applyTransformEx(poseStack,model.getHead(),0,-0.1f,0.64f,1.15f,0,0,0,() -> {
                head.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
            applyTransformEx(poseStack,model.getBody(),0,-0.71f,-0.35f,1.05f,0,0,0,() -> {
                body.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
            applyTransformEx(poseStack,model.getRightFrontLeg(),0.275f,-1f,0.625f,1.1f,0,0,0,() -> {
                rightFront.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
            applyTransformEx(poseStack,model.getLeftFrontLeg(),-0.275f,-1f,0.625f,1.1f,0,0,0,() -> {
                leftFront.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
            applyTransformEx(poseStack,model.getRightHindLeg(),0.275f,-1f,-0.55f,1.1f,0,0,0,() -> {
                rightBack.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
            applyTransformEx(poseStack,model.getLeftHindLeg(),-0.275f,-1f,-0.55f,1.1f,0,0,0,() -> {
                leftBack.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red,green,blue,1);
            });
        }
    }

}