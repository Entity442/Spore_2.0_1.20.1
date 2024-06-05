package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.verwahrungModel;
import com.Harbinger.Spore.Sentities.Organoids.Verwa;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VervaRenderer<Type extends Verwa> extends OrganoidMobRenderer<Type , verwahrungModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/verwahrung.png");


    public VervaRenderer(EntityRendererProvider.Context context) {
        super(context, new verwahrungModel<>(context.bakeLayer(verwahrungModel.LAYER_LOCATION)), 1f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}