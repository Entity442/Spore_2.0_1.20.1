package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
@OnlyIn(Dist.CLIENT)
public class ProtoMembraneLayer extends TranslucentLayer<Proto> {
    private static final ResourceLocation SYRINGE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/proto_membrane.png");

    public ProtoMembraneLayer(RenderLayerParent<Proto, EntityModel<Proto>> p_117346_) {
        super(p_117346_);
    }


    @Override
    public ResourceLocation getTexture(Proto type) {
        return SYRINGE;
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, Proto type, float v1, float v2, float v3, float v4, float v5, float v6) {
        if (!type.isNunny())
        super.render(stack, bufferSource, value, type, v1, v2, v3, v4, v5, v6);
    }
}
