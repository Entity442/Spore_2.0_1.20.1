package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.WombModel;
import com.Harbinger.Spore.Client.Models.WombModelStageII;
import com.Harbinger.Spore.Client.Models.WombModelStageIII;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.Organoids.Womb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BiomassReconfiguratorRenderer extends OrganoidMobRenderer<Womb, EntityModel<Womb>> {
    private final EntityModel<Womb> smallModel;
    private final EntityModel<Womb> mediumModel;
    private final EntityModel<Womb> largeModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/womb.png");
    private static final ResourceLocation TEXTURE_LARGE = new ResourceLocation(Spore.MODID,
            "textures/entity/womb_large.png");
    public BiomassReconfiguratorRenderer(EntityRendererProvider.Context context) {
        super(context, new WombModel<>(context.bakeLayer(WombModel.LAYER_LOCATION)), 0.5f);
        smallModel = this.getModel();
        mediumModel = new WombModelStageII<>(context.bakeLayer(WombModelStageII.LAYER_LOCATION));
        largeModel = new WombModelStageIII<>(context.bakeLayer(WombModelStageIII.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Womb reformator) {
        if (reformator.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/4)){
            return TEXTURE_LARGE;
        }
        return TEXTURE;
    }

    @Override
    public void render(Womb type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        if (type.getBiomass() > (SConfig.SERVER.reconstructor_biomass.get()/4) && type.getBiomass() < (SConfig.SERVER.reconstructor_biomass.get()/2)){
            model = mediumModel;
        }else if (type.getBiomass() >= (SConfig.SERVER.reconstructor_biomass.get()/2)){
            model = largeModel;
        }else{
            model = smallModel;
        }
        super.render(type, value1, value2, stack, bufferSource, value3);
    }
}
