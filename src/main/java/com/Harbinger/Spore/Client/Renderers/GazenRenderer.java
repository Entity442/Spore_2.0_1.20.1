package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GazenbrecherModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GazenRenderer<Type extends Gazenbrecher> extends CalamityRenderer<Type , GazenbrecherModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/gazen.png");
    private static final ResourceLocation ADAPTED_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/burned_gazen.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/gazen.png");


    public GazenRenderer(EntityRendererProvider.Context context) {
        super(context, new GazenbrecherModel<>(context.bakeLayer(GazenbrecherModel.LAYER_LOCATION)), 4f);

    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        if (entity.isAdaptedToFire()){
            return ADAPTED_TEXTURE;
        }else
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYE_TEXTURE;
    }
}
