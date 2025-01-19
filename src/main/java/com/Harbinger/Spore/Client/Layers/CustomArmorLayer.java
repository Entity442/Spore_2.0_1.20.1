package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.ArmorModelList;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.antlr.v4.runtime.misc.Triple;

public class CustomArmorLayer<E extends LivingEntity, M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    public CustomArmorLayer(RenderLayerParent<E, M> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource source, int value, E entity, float pLimbSwing, float pLimbSwingAmount, float pPartialTick, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {
        for (Triple<EntityModel<LivingEntity>, Item, ResourceLocation> tripple : ArmorModelList.modelItemMap()){
            if (entity.getItemBySlot(EquipmentSlot.HEAD).getItem() == tripple.b){
                renderArmorParts(stack,source,value,entity,tripple.a,1,1,1,tripple.c,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.HEAD);
            }
            if (entity.getItemBySlot(EquipmentSlot.CHEST).getItem() == tripple.b){
                renderArmorParts(stack,source,value,entity,tripple.a,1,1,1,tripple.c,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.CHEST);
            }
            if (entity.getItemBySlot(EquipmentSlot.LEGS).getItem() == tripple.b){
                renderArmorParts(stack,source,value,entity,tripple.a,1,1,1,tripple.c,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.LEGS);
            }
            if (entity.getItemBySlot(EquipmentSlot.FEET).getItem() == tripple.b){
                renderArmorParts(stack,source,value,entity,tripple.a,1,1,1,tripple.c,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch, EquipmentSlot.FEET);
            }
        }
    }

    private void renderArmorParts(PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, E pLivingEntity, EntityModel<LivingEntity> pModel, float pRed, float pGreen, float pBlue, ResourceLocation armorResource
            , float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch, EquipmentSlot slot){
        ItemStack itemstack = pLivingEntity.getItemBySlot(slot);
        float red = pRed;
        float green = pGreen;
        float blue = pBlue;
        if (itemstack.getItem() instanceof SporeArmorData data){
            int value = data.getVariant(itemstack).getColor();
            red = (float) (value >> 16 & 255) / 255.0F;
            green = (float) (value >> 8 & 255) / 255.0F;
            blue = (float) (value & 255) / 255.0F;
        }
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(pBuffer, pModel.renderType(armorResource), false, itemstack.hasFoil());
        pModel.setupAnim(pLivingEntity,pLimbSwing,pLimbSwingAmount,pAgeInTicks,pNetHeadYaw,pHeadPitch);
        pModel.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, red, green, blue, 1.0F);
    }
}