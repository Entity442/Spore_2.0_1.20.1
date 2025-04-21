package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;

public class CalamityVeins<T extends Calamity, M extends EntityModel<T>> extends RenderLayer<T, M> {
    public CalamityVeins(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (!type.isInvisible()){
            if (type.getMutationColor() == 0){return;}
            int i = type.getMutationColor();
            float r = (float) (i >> 16 & 255) / 255.0F;
            float g = (float) (i >> 8 & 255) / 255.0F;
            float b = (float) (i & 255) / 255.0F;
            VertexConsumer consumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(type)));
            getParentModel().renderToBuffer(stack,consumer,value, OverlayTexture.NO_OVERLAY,r,g,b,0.5f);
        }
    }
}
