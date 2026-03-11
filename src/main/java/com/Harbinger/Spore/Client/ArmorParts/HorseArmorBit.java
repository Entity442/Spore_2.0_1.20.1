package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Client.Layers.CustomHorseArmorLayer;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.Item;

public abstract class HorseArmorBit{
    public final Item item;
    public HorseArmorBit(Item item) {
        this.item = item;
    }
    public abstract EntityModel<AbstractHorse> getModel();
    protected VertexConsumer consumer(MultiBufferSource source, CustomModelArmorData data, CustomHorseArmorLayer.HorseHandlerModel<AbstractHorse> model, AbstractHorse livingEntity){
        return ItemRenderer.getFoilBufferDirect(source, model.renderType(data.getTextureLocation()), false, livingEntity.getItemBySlot(EquipmentSlot.CHEST).hasFoil());
    }
    public void tickMovement(AbstractHorse livingEntity, PoseStack poseStack, CustomHorseArmorLayer.HorseHandlerModel<AbstractHorse> model, int light, MultiBufferSource buffer){

    }

    protected void applyTransformEx(PoseStack poseStack, ModelPart origin, float x, float y, float z, float scale, float xSpin, float ySpin, float ZSpin, Runnable render) {
        poseStack.pushPose();
        origin.translateAndRotate(poseStack);
        poseStack.translate(x, y, z);
        poseStack.scale(scale, scale, scale);
        poseStack.mulPose(Axis.XP.rotationDegrees(xSpin));
        poseStack.mulPose(Axis.YP.rotationDegrees(ySpin));
        poseStack.mulPose(Axis.ZP.rotationDegrees(ZSpin));
        render.run();
        poseStack.popPose();
    }

}