package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.WendigoOuterLayer;
import com.Harbinger.Spore.Client.Models.WendigoModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WendigoRenderer<Type extends Wendigo> extends BaseInfectedRenderer<Type , WendigoModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/wendigo.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/wendigo.png");


    public WendigoRenderer(EntityRendererProvider.Context context) {
        super(context, new WendigoModel<>(context.bakeLayer(WendigoModel.LAYER_LOCATION)), 0.7f);
        this.addLayer(new WendigoOuterLayer<>(this));
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
