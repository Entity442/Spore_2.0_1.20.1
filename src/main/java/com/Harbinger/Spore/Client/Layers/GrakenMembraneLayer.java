package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GrakenMembraneLayer<Type extends Grakensenker> extends TranslucentLayer<Type> {
    private static final ResourceLocation SYRINGE =new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/graken_membrane.png");

    public GrakenMembraneLayer(RenderLayerParent<Type, EntityModel<Type>> p_117346_) {
        super(p_117346_);
    }


    @Override
    public ResourceLocation getTexture(Grakensenker type) {
        return SYRINGE;
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, Type type, float v1, float v2, float v3, float v4, float v5, float v6) {
        super.render(stack, bufferSource, value, type, v1, v2, v3, v4, v5, v6);
    }
}
