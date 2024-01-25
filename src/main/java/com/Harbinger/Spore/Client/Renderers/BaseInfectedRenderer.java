package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.EyeLayer;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public abstract class BaseInfectedRenderer<T extends Mob, M extends EntityModel<T>> extends MobRenderer<T, M> {
    public BaseInfectedRenderer(EntityRendererProvider.Context context, M model, float shadow) {
        super(context, model, shadow);
        this.addLayer(new EyeLayer<>(this,eyeLayerTexture()));
    }

    public abstract ResourceLocation eyeLayerTexture();

    @Override
    protected boolean isShaking(T type) {
        if (type instanceof Infected infected){
            return infected.isFreazing();
        }
        if (type instanceof Calamity calamity){
            return calamity.isStunned();
        }
        return false;
    }
}
