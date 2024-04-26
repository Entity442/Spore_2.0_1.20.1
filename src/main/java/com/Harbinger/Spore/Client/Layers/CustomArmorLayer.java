package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sitems.CustomModelArmor;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class CustomArmorLayer<E extends LivingEntity, M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    public CustomArmorLayer(RenderLayerParent<E, M> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource source, int value, E entity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof CustomModelArmor armor){
            this.renderArmorParts(stack,source,value,entity,armor.getModel(),1,1,1,armor.getCustomArmorTexture(),pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.HEAD);
        }
        if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof CustomModelArmor armor){
            this.renderArmorParts(stack,source,value,entity,armor.getModel(),1,1,1,armor.getCustomArmorTexture(),pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.CHEST);
        }
        if (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof CustomModelArmor armor){
            this.renderArmorParts(stack,source,value,entity,armor.getModel(),1,1,1,armor.getCustomArmorTexture(),pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.LEGS);
        }
        if (entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof CustomModelArmor armor){
            this.renderArmorParts(stack,source,value,entity,armor.getModel(),1,1,1,armor.getCustomArmorTexture(),pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.FEET);
        }
    }

    private void renderArmorParts(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, E pLivingEntity, EntityModel<LivingEntity> pModel, float pRed, float pGreen, float pBlue, ResourceLocation armorResource
            , float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, EquipmentSlot slot){
        ItemStack itemstack = pLivingEntity.getItemBySlot(slot);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, pModel.renderType(armorResource), false, itemstack.hasFoil());
        pModel.setupAnim(pLivingEntity,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch);
        pModel.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, pRed, pGreen, pBlue, 1.0F);
    }
}