package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.ArmorModelList;
import com.Harbinger.Spore.Client.Models.TestBootModel;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class CustomArmorLayer<E extends  LivingEntity,M extends HumanoidModel<E>> extends RenderLayer<E, M> {
    private final HumanoidModel<E> origin;
    public CustomArmorLayer(RenderLayerParent<E, M> p_117346_) {
        super(p_117346_);
        origin = this.getParentModel();
    }
    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int light, E entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float v5) {
        for (ArmorModelList.Quad quad : ArmorModelList.modelItemMap((HumanoidModel<LivingEntity>) origin)) {
            ItemStack stack = entity.getItemBySlot(quad.slot());
            if (stack.isEmpty() || stack.getItem() != quad.item()) continue;
            float red;
            float green;
            float blue;
            if (stack.getItem() instanceof SporeArmorData data){
                int color = data.getVariant(stack).getColor();
                red = (color >> 16 & 255) / 255.0F;
                green = (color >> 8 & 255) / 255.0F;
                blue = (color & 255) / 255.0F;
            } else {
                blue = 1;
                green = 1;
                red = 1;
            }
            if (stack.getItem() instanceof CustomModelArmorData armorData) {
                VertexConsumer consumer = ItemRenderer.getFoilBufferDirect(buffer, origin.renderType(armorData.getTextureLocation()), false, stack.hasFoil());
                EntityModel<E> model = (EntityModel<E>) quad.model();
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                applyTransform(poseStack, quad.origin(), quad.x(), quad.y(), quad.z(), quad.expand(), () -> {
                    quad.part().render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red, green, blue, 1f);
                });
            }
        }
        for (ArmorModelList.Quader quad : ArmorModelList.complexModelItemMap((HumanoidModel<LivingEntity>) origin,entity)) {
            ItemStack stack = entity.getItemBySlot(quad.slot);
            if (stack.isEmpty() || stack.getItem() != quad.item) continue;
            float red;
            float green;
            float blue;
            if (stack.getItem() instanceof SporeArmorData data){
                int color = data.getVariant(stack).getColor();
                red = (color >> 16 & 255) / 255.0F;
                green = (color >> 8 & 255) / 255.0F;
                blue = (color & 255) / 255.0F;
            } else {
                blue = 1;
                green = 1;
                red = 1;
            }
            if (stack.getItem() instanceof CustomModelArmorData armorData) {
                RenderType type = quad.type(armorData.getTextureLocation());
                if (type == null){return;}
                VertexConsumer consumer = buffer.getBuffer(type);
                EntityModel<E> model = (EntityModel<E>) quad.model;
                model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
                applyTransformEx(poseStack, quad.origin, quad.x, quad.y, quad.z, quad.expand, quad.Xspin, quad.Yspin, quad.Zspin,() -> {
                    quad.part.render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red, green, blue, 1f);
                });
            }
        }
    }
    private void applyTransform(PoseStack poseStack, ModelPart origin, float x, float y, float z, float scale, Runnable render) {
        poseStack.pushPose();
        origin.translateAndRotate(poseStack);
        poseStack.translate(x, y, z);
        poseStack.scale(scale, scale, scale);
        render.run();
        poseStack.popPose();
    }
    private void applyTransformEx(PoseStack poseStack, ModelPart origin, float x, float y, float z, float scale,float xSpin,float ySpin,float ZSpin, Runnable render) {
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