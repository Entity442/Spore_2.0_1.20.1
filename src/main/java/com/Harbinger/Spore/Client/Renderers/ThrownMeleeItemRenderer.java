package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.ThrownItemProjectile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ThrownMeleeItemRenderer<T extends ThrownItemProjectile>extends EntityRenderer<T> {
    private final ItemRenderer itemRenderer;

    public ThrownMeleeItemRenderer(EntityRendererProvider.Context context) {
        super(context);
        itemRenderer = context.getItemRenderer();
    }

    public void render(T entity, float value1, float value2, PoseStack stack, MultiBufferSource source, int lightValue) {
        if (!(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25)){
            stack.pushPose();
            stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(value2, entity.yRotO, entity.getYRot()) - 270.0F));
            stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(value2, entity.xRotO, entity.getXRot()) + 90.0F));
            stack.scale(1.2f,1.2f,1.2f);
            this.itemRenderer.renderStatic(entity.getItem(), ItemDisplayContext.GROUND, lightValue, OverlayTexture.NO_OVERLAY, stack, source, entity.level(), entity.getId());
            stack.popPose();
        }
        super.render(entity, value1, value2, stack, source, lightValue);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return TextureAtlas.LOCATION_BLOCKS;
    }
}