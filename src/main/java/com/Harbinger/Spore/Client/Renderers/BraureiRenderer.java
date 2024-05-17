package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.BreweryBottle;
import com.Harbinger.Spore.Client.Layers.BreweryLiquid;
import com.Harbinger.Spore.Client.Models.BraureiModel;
import com.Harbinger.Spore.Sentities.Organoids.Brauerei;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BraureiRenderer<Type extends Brauerei> extends OrganoidMobRenderer<Type , BraureiModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/brewery.png");


    public BraureiRenderer(EntityRendererProvider.Context context) {
        super(context, new BraureiModel<>(context.bakeLayer(BraureiModel.LAYER_LOCATION)), 3f);
        this.addLayer(new BreweryLiquid<>(this));
        this.addLayer(new BreweryBottle<>(this));
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


}