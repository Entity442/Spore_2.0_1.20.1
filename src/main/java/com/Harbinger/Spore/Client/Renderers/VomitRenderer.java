package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.VomitHohlBall;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VomitRenderer<T extends VomitHohlBall>extends EntityRenderer<T> {
    public static final ResourceLocation LOCATION = new ResourceLocation(Spore.MODID,"");
    public VomitRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return LOCATION;
    }
}
