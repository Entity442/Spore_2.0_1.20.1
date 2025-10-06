package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InquisitorModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InquisitorRenderer<Type extends Inquisitor> extends BaseInfectedRenderer<Type , InquisitorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inquisitor.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inquisitor.png");


    public InquisitorRenderer(EntityRendererProvider.Context context) {
        super(context, new InquisitorModel<>(context.bakeLayer(InquisitorModel.LAYER_LOCATION)), 0.7f);
        this.addLayer(new InquisitorBlood<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYE_TEXTURE;
    }

    static class InquisitorBlood <T extends Inquisitor,M extends InquisitorModel<T>> extends RenderLayer<T, M> {
        private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
                "textures/entity/inquisitor_blood.png");
        public InquisitorBlood(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!entity.isInvisible() && entity.getBonusDamage() > 10){
                VertexConsumer vertexConsumer = buffer.getBuffer(RenderType.entityTranslucent(TEXTURE));
                getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f);
            }
        }
    }
}
