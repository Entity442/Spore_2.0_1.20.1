package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.verwahrungModel;
import com.Harbinger.Spore.Sentities.Organoids.Verwa;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class VerdaMobLayer<T extends Verwa> extends RenderLayer<T, verwahrungModel<T>> {
    private final EntityRenderDispatcher entityRenderer;
    public VerdaMobLayer(RenderLayerParent<T, verwahrungModel<T>> context, EntityRenderDispatcher entityRenderer) {
        super(context);
        this.entityRenderer = entityRenderer;
    }
    protected float getBob(T p_115305_, float p_115306_) {
        return (float)p_115305_.tickCount + p_115306_;
    }
    @Override
    public void render(PoseStack stack, MultiBufferSource source, int value3, T type, float p_117353_, float value2, float asf, float p_117356_, float p_117357_, float p_117358_) {
        Entity entity = type.getStoredEntity();
        float f7 = this.getBob(type, value2);
        if (!type.isBurrowing() && entity != null){
            stack.pushPose();
            stack.mulPose(Axis.YP.rotationDegrees(-type.yBodyRot));
            stack.scale(0.9f,0.9f,0.9f);
            if (entityRenderer.getRenderer(entity) instanceof MobRenderer renderer){
                EntityModel model = renderer.getModel();
                ResourceLocation texture = renderer.getTextureLocation(entity);
                VertexConsumer consumer = source.getBuffer(RenderType.entityCutoutNoCull(texture));
                model.prepareMobModel(entity, 0, 0, value2);
                model.setupAnim(entity, 0, 0, f7, 0, 0);
                model.renderToBuffer(stack,consumer,value3, OverlayTexture.NO_OVERLAY,1,1,1,1);
            }
            stack.popPose();
        }
    }
}
