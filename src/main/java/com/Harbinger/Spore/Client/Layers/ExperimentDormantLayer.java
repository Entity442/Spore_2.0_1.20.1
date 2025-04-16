package com.Harbinger.Spore.Client.Layers;


import com.Harbinger.Spore.Client.Models.ExperimentDormantLayerModel;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class ExperimentDormantLayer<T extends Experiment,M extends EntityModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation HAT_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/experiment_layer.png");
    private final ExperimentDormantLayerModel<T> model;

    public ExperimentDormantLayer(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
        this.model = new ExperimentDormantLayerModel<>();
    }


    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int p_117351_, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
        if (type.isDormant()){
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, HAT_LOCATION, stack, bufferSource, p_117351_, type, p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_, 1, 1, 1);

        }
    }
}
