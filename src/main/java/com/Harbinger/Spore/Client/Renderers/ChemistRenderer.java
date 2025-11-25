package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.TranslucentLayer;
import com.Harbinger.Spore.Client.Models.ChemistModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Chemist;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ChemistRenderer extends MobRenderer<Chemist, EntityModel<Chemist>> {

    public static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID, "textures/entity/chemist.png");

    public ChemistRenderer(EntityRendererProvider.Context context) {
        super(context, new ChemistModel<>(context.bakeLayer(ChemistModel.LAYER_LOCATION)), 0.5f);
        addLayer(new ChemistGlassRenderer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Chemist hazmat) {
        return TEXTURE;
    }

    private static class ChemistGlassRenderer extends TranslucentLayer<Chemist>{
        private static final ResourceLocation TEXTURE = new  ResourceLocation(Spore.MODID,
                "textures/entity/eyes/chemist.png");
        public ChemistGlassRenderer(RenderLayerParent<Chemist, EntityModel<Chemist>> p_117346_) {
            super(p_117346_);
        }

        @Override
        public ResourceLocation getTexture(Chemist type) {
            return TEXTURE;
        }
    }
}
