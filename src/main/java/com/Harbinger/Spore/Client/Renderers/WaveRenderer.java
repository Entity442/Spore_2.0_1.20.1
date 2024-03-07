package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Utility.WaveEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class WaveRenderer extends EntityRenderer<WaveEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID, "");

    public WaveRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(WaveEntity entity) {
        return TEXTURE;
    }
}
