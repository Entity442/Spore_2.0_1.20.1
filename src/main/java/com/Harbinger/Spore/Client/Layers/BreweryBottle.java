package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.BraureiModel;
import com.Harbinger.Spore.Sentities.Organoids.Brauerei;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BreweryBottle<T extends Brauerei> extends RenderLayer<T, BraureiModel<T>> {
    private static final ResourceLocation SYRINGE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/brewery_glass.png");
    public BreweryBottle(RenderLayerParent<T, BraureiModel<T>> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, T type, float v1, float v2, float v3, float v4, float v5, float v6) {
        if (!type.isInvisible()){
            VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(SYRINGE));
            this.getParentModel().prepareMobModel(type, v1, v2, v3);
            this.getParentModel().setupAnim(type, v1, v2, v4, v5, v6);
            this.getParentModel().renderToBuffer(stack, vertexconsumer, value, LivingEntityRenderer.getOverlayCoords(type, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
