package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Spore.MODID, value = Dist.CLIENT)
public class SpecificClientEvents {

    @SubscribeEvent
    public static void onRenderHand(RenderHandEvent event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;
        if (player == null || mc.level == null) return;
        for (ArmorModelList.HandDisplay handDisplay : ArmorModelList.itemDisplay()){
            ItemStack stack = player.getItemInHand(handDisplay.slot);
            if (stack.getItem() instanceof CustomModelArmorData armorData){
                renderCustomHand(player,event.getPartialTick(),event.getPackedLight(),event.getMultiBufferSource(),event.getPoseStack(),armorData.getTextureLocation(),handDisplay);
            }
        }

    }
    private static void renderCustomHand(LivingEntity livingEntity, float partialTicks, int light, MultiBufferSource bufferSource, PoseStack poseStack, ResourceLocation location, ArmorModelList.HandDisplay display) {
        RenderType type = display.type(location);
        int ticks = (int) (livingEntity.tickCount+partialTicks);
        if (type == null){return;}
        VertexConsumer consumer = bufferSource.getBuffer(type);
        EntityModel<LivingEntity> model = (EntityModel<LivingEntity>) display.model;
        float yaw = Mth.lerp(partialTicks, livingEntity.yRotO, livingEntity.getYRot());
        float pitch = Mth.lerp(partialTicks, livingEntity.xRotO, livingEntity.getXRot());
        model.setupAnim(livingEntity, 0, 0, ticks, yaw, pitch);
        applyTransformEx(poseStack,display.x,display.y,display.z,display.expand,display.Xspin,display.Yspin,display.Zspin,() ->{
            display.part.render(poseStack,consumer,light, OverlayTexture.NO_OVERLAY,1,1,1,1);
        });
    }
    private static void applyTransformEx(PoseStack poseStack, float x, float y, float z, float scale,float xSpin,float ySpin,float ZSpin, Runnable render) {
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
