package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Core.Sitems;
import com.Harbinger.Spore.Sitems.PCI;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class PCIHandModelItem extends ComplexHandModelItem{
    private final ResourceLocation glowLocation;
    public PCIHandModelItem(InteractionHand slot, EntityModel<LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin, ResourceLocation glowLocation) {
        super(slot, Sitems.PCI.get(), model, part, x, y, z, expand, xspin, yspin, zspin);
        this.glowLocation = glowLocation;
    }


    @Override
    public RenderType type(ResourceLocation location) {
        return RenderType.entityCutoutNoCull(location);
    }

    @Override
    protected void renderModel(PoseStack poseStack, VertexConsumer consumer, int light, MultiBufferSource source,ItemStack stack) {
        applyTransformEx(poseStack,this.x,this.y,this.z,this.expand,this.Xspin,this.Yspin,this.Zspin,() ->{
            this.part.render(poseStack,consumer,light, OverlayTexture.NO_OVERLAY,1,1,1,1);
            VertexConsumer vertexConsumer = displayglow(source,stack);
            if (vertexConsumer != null){
                this.part.render(poseStack,vertexConsumer,light, OverlayTexture.NO_OVERLAY,1,1,1,1);
            }
        });
    }

    public VertexConsumer displayglow(MultiBufferSource source,ItemStack stack){
        if (stack.getItem() instanceof PCI pci && pci.getCharge(stack) > 0){
            return source.getBuffer(RenderType.eyes(glowLocation));
        }
        return null;
    }
}
