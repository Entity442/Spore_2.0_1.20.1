package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.SiegerArrowModel;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class SiegerArrowLayer<T extends Sieger> extends RenderLayer<T, SiegerArrowModel<T>> {
    private static final ResourceLocation ARROW_LOCATION = new ResourceLocation("minecraft:textures/entity/arrow.png");
    private final SiegerArrowModel<T> model;

    public SiegerArrowLayer(RenderLayerParent<T, SiegerArrowModel<T>> p_117346_, EntityModelSet set) {
        super(p_117346_);
        this.model = new SiegerArrowModel<>(set.bakeLayer(SiegerArrowModel.LAYER_LOCATION));
    }


    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int p_117351_, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (type.isAdapted()){
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, ARROW_LOCATION, stack, bufferSource, p_117351_, type, p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_, 1, 1, 1);
        }
    }
}
