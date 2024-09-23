package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.JagdhundModel;
import com.Harbinger.Spore.Client.Models.LeaperModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Jagdhund;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Leaper;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JagdhundRenderer<Type extends Jagdhund> extends BaseInfectedRenderer<Type , JagdhundModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/jagdhund.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/jagdhund.png");

    public JagdhundRenderer(EntityRendererProvider.Context context) {
        super(context, new JagdhundModel<>(context.bakeLayer(JagdhundModel.LAYER_LOCATION)), 0.5f);
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