package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.WendigoModel;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public  class WendigoOuterLayer<T extends Wendigo> extends RenderLayer<T, WendigoModel<T>> {
    public WendigoOuterLayer(RenderLayerParent<T, WendigoModel<T>> p_174490_) {
        super(p_174490_);
    }
    private static final ResourceLocation CAMO = new ResourceLocation(Spore.MODID,
            "textures/entity/wendigo_camo.png");
    public void render(PoseStack p_116924_, MultiBufferSource p_116925_, int p_116926_, T entity, float p_116928_, float p_116929_, float p_116930_, float p_116931_, float p_116932_, float p_116933_) {
        if (entity.getCamo() != 0){
            int i = entity.getCamo();
            float r = (float) (i >> 16 & 255) / 255.0F;
            float g = (float) (i >> 8 & 255) / 255.0F;
            float b = (float) (i & 255) / 255.0F;
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.getParentModel(), CAMO, p_116924_, p_116925_, p_116926_, entity,
                    p_116928_, p_116929_, p_116931_, p_116932_, p_116933_, p_116930_, r, g, b);
        }
    }

}