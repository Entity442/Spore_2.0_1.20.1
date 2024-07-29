package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.HowitzerModel;
import com.Harbinger.Spore.Sentities.Calamities.Howitzer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class HowitzerEmissiveLayer <T extends Howitzer,M extends HowitzerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/howitzer.png");
    public HowitzerEmissiveLayer(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, T entity, float value1, float value2, float value3, float value4, float value5, float value6) {
        if (!entity.isInvisible()){
            VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.eyes(TEXTURE));
            this.getParentModel().renderToBuffer(stack, vertexconsumer, value, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1f);
        }
    }
}
