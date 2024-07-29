package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.HowitzerEmissiveLayer;
import com.Harbinger.Spore.Client.Models.HowitzerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Howitzer;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HowitzerRenderer<Type extends Howitzer> extends BaseInfectedRenderer<Type , HowitzerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/howitzer.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/howitzer_eyes.png");


    public HowitzerRenderer(EntityRendererProvider.Context context) {
        super(context, new HowitzerModel<>(context.bakeLayer(HowitzerModel.LAYER_LOCATION)), 4f);
        this.addLayer(new HowitzerEmissiveLayer<>(this));
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
