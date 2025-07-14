package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Sitems.PCI;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class RightPCIArmorPart extends BaseArmorRenderingBit{
    private final ResourceLocation location;
    public RightPCIArmorPart(Supplier<EntityModel<LivingEntity>> model, Supplier<ModelPart> part, ResourceLocation location) {
        super(EquipmentSlot.MAINHAND, Sitems.PCI.get(), model, part, -0.15f, -0.35f, -0.05f, 1f);
        this.location = location;
    }

    @Override
    protected ModelPart getPiece(HumanoidModel<LivingEntity> model) {
        return model.rightArm;
    }

    @Override
    public void tickMovement(LivingEntity livingEntity, PoseStack poseStack, HumanoidModel<LivingEntity> model, int light, MultiBufferSource buffer) {
        ItemStack itemStack = stack(livingEntity);
        if (itemStack.getItem() instanceof CustomModelArmorData armorData && itemStack.getItem().equals(item)){
            VertexConsumer consumer = consumer(buffer,armorData,model,livingEntity);
            applyTransformEx(poseStack,getPiece(model),this.x,this.y,this.z,this.expand,this.Xspin,this.Yspin,this.Zspin,() -> {
                part.get().render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
                VertexConsumer vertexConsumer = glowConsumer(buffer,livingEntity);
                if (vertexConsumer != null){
                    part.get().render(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1f, 1f, 1f, 1f);
                }
            });
        }
    }
    private VertexConsumer glowConsumer(MultiBufferSource bufferSource,LivingEntity livingEntity){
        ItemStack stack = stack(livingEntity);
        if (stack.getItem() instanceof PCI pci && pci.getCharge(stack) > 0){
            return bufferSource.getBuffer(RenderType.eyes(location));
        }
        return null;
    }
}
