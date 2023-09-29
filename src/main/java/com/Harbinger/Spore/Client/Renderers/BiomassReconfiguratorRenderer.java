package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.BiomassReconstructorModel;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.Organoids.BiomassReformator;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
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

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight();
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / type.getBorrow_tick()) * type.getBorrow();
            }else if (type.isEmerging()){
                b = -a + ((a / type.getEmerge_tick()) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        super.render(type, value1, value2, stack, bufferSource, value3);
    }
}
