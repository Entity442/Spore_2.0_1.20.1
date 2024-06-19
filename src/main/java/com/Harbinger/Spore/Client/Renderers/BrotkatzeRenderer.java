package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BrotkatzeModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Brot;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BrotkatzeRenderer<Type extends Brot> extends BaseInfectedRenderer<Type , BrotkatzeModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/brotkatze.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/brotkatze.png");


    public BrotkatzeRenderer(EntityRendererProvider.Context context) {
        super(context, new BrotkatzeModel<>(context.bakeLayer(BrotkatzeModel.LAYER_LOCATION)), 1f);
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
