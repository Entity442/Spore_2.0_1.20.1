package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.NaiadModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Naiad;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NaiadRenderer<Type extends Naiad> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/naiad.png");
    private static final ResourceLocation EYES_TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/naiad.png");


    public NaiadRenderer(EntityRendererProvider.Context context) {
        super(context, new NaiadModel<>(context.bakeLayer(NaiadModel.LAYER_LOCATION)), 1f);
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
