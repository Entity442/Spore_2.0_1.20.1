package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DrakeMembraneLayer<Type extends Verfalldrachen> extends TranslucentLayer<Type> {
    private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/dragon/verfalldrache_membrane.png");

    public DrakeMembraneLayer(RenderLayerParent<Type, EntityModel<Type>> p_117346_) {
        super(p_117346_);
    }


    @Override
    public ResourceLocation getTexture(Verfalldrachen type) {
        return TEXTURE;
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, Type type, float v1, float v2, float v3, float v4, float v5, float v6) {
        if (!type.isInvisible()){
            stack.pushPose();
            stack.scale(1.15f,1.15f,1.15f);
            stack.translate(0,0.25,0.2);
            VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTexture(type)));
            this.getParentModel().prepareMobModel(type, v1, v2, v3);
            this.getParentModel().setupAnim(type, v1, v2, v4, v5, v6);
            this.getParentModel().renderToBuffer(stack, vertexconsumer, value, LivingEntityRenderer.getOverlayCoords(type, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
            stack.popPose();
        }
    }
}
