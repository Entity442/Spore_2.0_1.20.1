package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.ToxinBullet;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ToxinBulletRenderer extends EntityRenderer<ToxinBullet> {
    public static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/bile_round.png");
    public ToxinBulletRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
    public ResourceLocation getTextureLocation(ToxinBullet p_116109_) {
        return TEXTURE_LOCATION;
    }
}