package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InquisitorModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InquisitorRenderer<Type extends Inquisitor> extends BaseInfectedRenderer<Type , InquisitorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inquisitor.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inquisitor.png");


    public InquisitorRenderer(EntityRendererProvider.Context context) {
        super(context, new InquisitorModel<>(context.bakeLayer(InquisitorModel.LAYER_LOCATION)), 0.7f);
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
