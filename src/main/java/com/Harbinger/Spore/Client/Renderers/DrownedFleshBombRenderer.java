package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.EDBiomassModel;
import com.Harbinger.Spore.Sentities.Projectile.DrownedFleshBomb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DrownedFleshBombRenderer<T extends DrownedFleshBomb>extends EntityRenderer<T> {
    public static final ResourceLocation BASIC_ROUND = new ResourceLocation(Spore.MODID,"textures/entity/db_texture.png");
     private final EDBiomassModel<T> model;

    public DrownedFleshBombRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new EDBiomassModel<>();
    }

    public void render(T entity, float value2, float value, PoseStack stack, MultiBufferSource source, int p_116116_) {
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(value, entity.yRotO, entity.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(value, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(source, this.model.renderType(this.getTextureLocation(entity)), false, false);
        model.setupAnim(entity,0,0,entity.tickCount,0,0);
        model.renderToBuffer(stack, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY, 1,1,1,1);
        stack.popPose();
        super.render(entity, value2, value, stack, source, p_116116_);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return BASIC_ROUND;
    }


}