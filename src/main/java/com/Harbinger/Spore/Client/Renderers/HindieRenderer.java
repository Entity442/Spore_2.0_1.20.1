package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HindieModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HindieRenderer<Type extends Hinderburg> extends BaseInfectedRenderer<Type , HindieModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hindie.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/gazen.png");


    public HindieRenderer(EntityRendererProvider.Context context) {
        super(context, new HindieModel<>(context.bakeLayer(HindieModel.LAYER_LOCATION)), 4f);

    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYE_TEXTURE;
    }
}
