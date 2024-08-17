package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.LaceratorVisorLayer;
import com.Harbinger.Spore.Client.Models.LaceratorModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Experiments.Lacerator;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LaceratorRenderer<Type extends Lacerator> extends BaseInfectedRenderer<Type , LaceratorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/lacerator.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/lacerator.png");

    public LaceratorRenderer(EntityRendererProvider.Context context) {
        super(context, new LaceratorModel<>(context.bakeLayer(LaceratorModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new LaceratorVisorLayer(this));
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