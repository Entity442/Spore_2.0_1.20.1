package com.Harbinger.Spore.Client.ArmorParts;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public abstract class ComplexHandModelItem {
    public final InteractionHand slot;
    public final Item item;
    public final EntityModel<LivingEntity> model;
    public final ModelPart part;
    public final float x;
    public final float y;
    public final float z;
    public final float expand;
    public final float Xspin;
    public final float Yspin;
    public final float Zspin;
    protected ComplexHandModelItem(InteractionHand slot, Item item, EntityModel<LivingEntity> model, ModelPart part, float x, float y, float z, float expand, float xspin, float yspin, float zspin) {
        this.slot = slot;
        this.item = item;
        this.model = model;
        this.part = part;
        this.x = x;
        this.y = y;
        this.z = z;
        this.expand = expand;
        this.Xspin = xspin;
        this.Yspin = yspin;
        this.Zspin = zspin;
    }

    public abstract RenderType type(ResourceLocation location);

    public void renderCustomHand(LivingEntity livingEntity, ItemStack stack, float partialTicks, int light, MultiBufferSource bufferSource, PoseStack poseStack, ResourceLocation location) {
        RenderType type = this.type(location);
        int ticks = (int) (livingEntity.tickCount+partialTicks);
        if (type == null){return;}
        VertexConsumer consumer = bufferSource.getBuffer(type);
        float yaw = Mth.lerp(partialTicks, livingEntity.yRotO, livingEntity.getYRot());
        float pitch = Mth.lerp(partialTicks, livingEntity.xRotO, livingEntity.getXRot());
        this.model.setupAnim(livingEntity, 0, 0, ticks, yaw, pitch);
        renderModel(poseStack,consumer,light,bufferSource ,stack);
    }
    protected void renderModel(PoseStack poseStack,VertexConsumer consumer,int light,MultiBufferSource source,ItemStack stack){
        applyTransformEx(poseStack,this.x,this.y,this.z,this.expand,this.Xspin,this.Yspin,this.Zspin,() ->{
            this.part.render(poseStack,consumer,light, OverlayTexture.NO_OVERLAY,1,1,1,1);
        });
    }

    protected static void applyTransformEx(PoseStack poseStack, float x, float y, float z, float scale, float xSpin, float ySpin, float ZSpin, Runnable render) {
        poseStack.pushPose();
        poseStack.translate(x, y, z);
        poseStack.scale(scale, scale, scale);
        poseStack.mulPose(Axis.XP.rotationDegrees(xSpin));
        poseStack.mulPose(Axis.YP.rotationDegrees(ySpin));
        poseStack.mulPose(Axis.ZP.rotationDegrees(ZSpin));
        render.run();
        poseStack.popPose();
    }
}
