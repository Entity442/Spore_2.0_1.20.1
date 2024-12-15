package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.NucleaChestplateLayer;
import com.Harbinger.Spore.Client.Models.NuckelaveModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Nuclealave;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NucleaRenderer<Type extends Nuclealave> extends BaseInfectedRenderer<Type , NuckelaveModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/nuckelave.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/nuckelave.png");


    public NucleaRenderer(EntityRendererProvider.Context context) {
        super(context, new NuckelaveModel<>(context.bakeLayer(NuckelaveModel.LAYER_LOCATION),false), 1f);
        this.addLayer(new NucleaChestplateLayer<>(this,context.getModelSet(),context.getModelManager()));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

}
