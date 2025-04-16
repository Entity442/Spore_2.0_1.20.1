package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.PlaguedSiringeLayer;
import com.Harbinger.Spore.Client.Models.PlaguedModel;
import com.Harbinger.Spore.Client.Special.BaseExperimentRenderer;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Experiments.Plagued;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PlaguedRenderer<Type extends Plagued> extends BaseExperimentRenderer<Type , PlaguedModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/plagued.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/plagued.png");

    public PlaguedRenderer(EntityRendererProvider.Context context) {
        super(context, new PlaguedModel<>(context.bakeLayer(PlaguedModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new PlaguedSiringeLayer(this));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    protected boolean isShaking(Type type) {
        return true;
    }
}