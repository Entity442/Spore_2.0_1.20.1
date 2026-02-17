package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.HiveTumorMembraneLayer;
import com.Harbinger.Spore.Client.Models.HivetumorModel;
import com.Harbinger.Spore.Sentities.Organoids.HiveTumor;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HiveTumorRenderer extends OrganoidMobRenderer<HiveTumor, EntityModel<HiveTumor>> {
    private static final ResourceLocation TEXTURE = new  ResourceLocation(Spore.MODID,
            "textures/entity/hivetumor.png");

    public HiveTumorRenderer(EntityRendererProvider.Context context) {
        super(context, new HivetumorModel<>(context.bakeLayer(HivetumorModel.LAYER_LOCATION)), 1.5f);
        this.addLayer(new HiveTumorMembraneLayer(this));
    }

    @Override
    protected boolean isShaking(HiveTumor type) {
        return super.isShaking(type) || type.isScared();
    }

    @Override
    public ResourceLocation getTextureLocation(HiveTumor proto) {
        return  TEXTURE;
    }

}
