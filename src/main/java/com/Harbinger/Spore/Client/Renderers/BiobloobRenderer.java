package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BiobloobModel;
import com.Harbinger.Spore.Client.Special.BaseExperimentRenderer;
import com.Harbinger.Spore.Sentities.Experiments.Biobloob;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BiobloobRenderer<Type extends Biobloob> extends BaseExperimentRenderer<Type , BiobloobModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/biobloob.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/biobloob.png");

    public BiobloobRenderer(EntityRendererProvider.Context context) {
        super(context, new BiobloobModel<>(context.bakeLayer(BiobloobModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

}