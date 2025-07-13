package com.Harbinger.Spore.Client.ArmorParts;

import com.Harbinger.Spore.Sitems.BaseWeapons.SporeArmorData;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeWeaponData;
import com.Harbinger.Spore.Sitems.CustomModelArmorData;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
public abstract class BaseArmorRenderingBit {
    public final EquipmentSlot slot;
    public final Item item;
    public final Supplier<EntityModel<LivingEntity>> model;
    public final Supplier<ModelPart> part;
    public final float x;
    public final float y;
    public final float z;
    public final float expand;
    public final float Xspin;
    public final float Yspin;
    public final float Zspin;

    public BaseArmorRenderingBit(
            EquipmentSlot slot,
            Item item,
            Supplier<EntityModel<LivingEntity>> model,
            Supplier<ModelPart> part,
            float x, float y, float z, float expand,
            float xspin, float yspin, float zspin) {

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

    public BaseArmorRenderingBit(
            EquipmentSlot slot, Item item,
            Supplier<EntityModel<LivingEntity>> model,
            Supplier<ModelPart> part,
            float x, float y, float z, float expand) {

        this(slot, item, model, part, x, y, z, expand, 0f, 0f, 0f);
    }

    public ItemStack stack(LivingEntity livingEntity) {
        return livingEntity.getItemBySlot(slot);
    }
    protected VertexConsumer consumer(MultiBufferSource source,CustomModelArmorData data, HumanoidModel<LivingEntity> model,LivingEntity livingEntity){
        return ItemRenderer.getFoilBufferDirect(source, model.renderType(data.getTextureLocation()), false, stack(livingEntity).hasFoil());
    }

    public void tickMovement(LivingEntity livingEntity,PoseStack poseStack, HumanoidModel<LivingEntity> model,int light, MultiBufferSource buffer){
        ItemStack itemStack = stack(livingEntity);
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
            applyTransformEx(poseStack,getPiece(model),this.x,this.y,this.z,this.expand,this.Xspin,this.Yspin,this.Zspin,() -> {
                part.get().render(poseStack, consumer, light, OverlayTexture.NO_OVERLAY, red, green, blue, 1f);
            });
        }
    }
    protected abstract ModelPart getPiece(HumanoidModel<LivingEntity> model);

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
