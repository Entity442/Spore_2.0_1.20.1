package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.ScavengerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scavenger;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScavengerRenderer<Type extends Scavenger> extends BaseInfectedRenderer<Type , ScavengerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/scavenger.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/scavenger.png");


    public ScavengerRenderer(EntityRendererProvider.Context context) {
        super(context, new ScavengerModel<>(context.bakeLayer(ScavengerModel.LAYER_LOCATION)), 1f);
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
