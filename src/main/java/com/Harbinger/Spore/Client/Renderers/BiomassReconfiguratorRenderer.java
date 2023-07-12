package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.BiomassReconstructorModel;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.Organoids.BiomassReformator;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BiomassReconfiguratorRenderer<Type extends BiomassReformator> extends MobRenderer<Type , BiomassReconstructorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/womb.png");
    public BiomassReconfiguratorRenderer(EntityRendererProvider.Context context) {
        super(context, new BiomassReconstructorModel<>(context.bakeLayer(BiomassReconstructorModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    protected void scale(BiomassReformator reformator, PoseStack poseStack, float p_115316_) {
        int age = 1;
        if (reformator.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/4) && reformator.getBiomass() < (SConfig.SERVER.reconstructor_biomass.get()/2)){
            age = 2;
        }else if (reformator.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/2)){
            age = 3;
        }

        poseStack.scale((float) age,(float)age,(float)age);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
            return TEXTURE;
    }

}
