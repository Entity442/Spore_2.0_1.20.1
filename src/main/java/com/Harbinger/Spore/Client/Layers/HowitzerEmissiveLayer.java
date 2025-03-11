package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Client.Models.HowitzerModel;
import com.Harbinger.Spore.Sentities.Calamities.Howitzer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class HowitzerEmissiveLayer <T extends Howitzer,M extends HowitzerModel<T>> extends RenderLayer<T, M> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/howitzer.png");
    private static final ResourceLocation RADIOACTIVE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/howitzer_radiation_glow.png");
    public HowitzerEmissiveLayer(RenderLayerParent<T, M> p_117346_) {
        super(p_117346_);
    }

    @Override
    public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!entity.isInvisible()){
            float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.01F);
            VertexConsumer vertexConsumer = buffer.getBuffer(SporeRenderTypes.glowingTranslucent(entity.isRadioactive() ? RADIOACTIVE : TEXTURE));
            getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, 15728640, 1.0F, 1.0F, 1.0F, alpha);
        }
    }

}
