package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.DelusionerModel;
import com.Harbinger.Spore.Sentities.Organoids.Delusionare;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DelusionareRenderer<Type extends Delusionare> extends OrganoidMobRenderer<Type , DelusionerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/delusioner.png");


    public DelusionareRenderer(EntityRendererProvider.Context context) {
        super(context, new DelusionerModel<>(context.bakeLayer(DelusionerModel.LAYER_LOCATION)), 1f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}