package com.Harbinger.Spore.Client.Special;

import com.Harbinger.Spore.Client.Layers.ExperimentDormantLayer;
import com.Harbinger.Spore.Sentities.BaseEntities.Experiment;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public abstract class BaseExperimentRenderer<T extends Experiment,M extends EntityModel<T>> extends BaseInfectedRenderer<T, M> {
    public BaseExperimentRenderer(EntityRendererProvider.Context context, M model, float shadow) {
        super(context, model, shadow);
        addLayer(new ExperimentDormantLayer<>(this));
    }
    public abstract ResourceLocation eyeLayerTexture();
}
