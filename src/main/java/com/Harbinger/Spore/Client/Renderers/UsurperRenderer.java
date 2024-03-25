package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.UsurperModel;
import com.Harbinger.Spore.Sentities.Organoids.Usurper;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UsurperRenderer<Type extends Usurper> extends OrganoidMobRenderer<Type , UsurperModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/usurper.png");


    public UsurperRenderer(EntityRendererProvider.Context context) {
        super(context, new UsurperModel<>(context.bakeLayer(UsurperModel.LAYER_LOCATION)), 1f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}