package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.ThrownBlockProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class ThrownBlockRenderer extends EntityRenderer<ThrownBlockProjectile> {
    public ThrownBlockRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownBlockProjectile thrownBlockProjectile) {
        return new ResourceLocation("");
    }

    @Override
    public void render(ThrownBlockProjectile thrownBlockProjectile, float value, float p_114487_, PoseStack stack, MultiBufferSource source, int p_114490_) {
        ItemStack itemStack = new ItemStack(thrownBlockProjectile.state().getBlock().asItem());
        if (!itemStack.equals(ItemStack.EMPTY)) {
            renderItem(stack,itemStack,source,value,thrownBlockProjectile.level(),thrownBlockProjectile.blockPosition());
        }
    }
    public void renderItem(PoseStack stack, ItemStack itemStack, MultiBufferSource source, float value, Level level, BlockPos pos){
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        stack.pushPose();
        stack.scale(1.5f,1.5f,1.5f);
        stack.mulPose(Axis.YP.rotationDegrees(value));
        itemRenderer.renderStatic(itemStack, ItemDisplayContext.FIXED,getLight(level,pos), OverlayTexture.NO_OVERLAY,stack,source,level,1);
        stack.popPose();
    }

    private int getLight(Level level, BlockPos pos){
        int a = level.getBrightness(LightLayer.BLOCK,pos);
        int b = level.getBrightness(LightLayer.SKY,pos);
        return LightTexture.pack(a,b);
    }
}
