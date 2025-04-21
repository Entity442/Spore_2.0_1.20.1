package com.Harbinger.Spore.Client.Special;

import com.Harbinger.Spore.Client.Layers.CalamityRoots;
import com.Harbinger.Spore.Client.Layers.CalamityVeins;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public abstract class CalamityRenderer<T extends Calamity, M extends EntityModel<T>> extends BaseInfectedRenderer<T, M> {
    public CalamityRenderer(EntityRendererProvider.Context context, M model, float shadow) {
        super(context, model, shadow);
        this.addLayer(new CalamityRoots(this,context.getModelSet()));
        this.addLayer(new CalamityVeins<>(this));
    }
}
