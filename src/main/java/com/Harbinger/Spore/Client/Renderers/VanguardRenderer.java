package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.VanguardModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Utility.Vanguard;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VanguardRenderer<Type extends Vanguard> extends BaseInfectedRenderer<Type , VanguardModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/vanguard.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/vanguard.png");


    public VanguardRenderer(EntityRendererProvider.Context context) {
        super(context, new VanguardModel<>(context.bakeLayer(VanguardModel.LAYER_LOCATION)), 0.5f);
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
