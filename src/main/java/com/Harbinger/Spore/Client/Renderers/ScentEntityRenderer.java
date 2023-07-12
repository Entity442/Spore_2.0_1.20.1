package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class ScentEntityRenderer extends EntityRenderer<ScentEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID, "");

    public ScentEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(ScentEntity entity) {
        return TEXTURE;
    }
}
