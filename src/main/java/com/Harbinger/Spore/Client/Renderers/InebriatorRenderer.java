package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.InebriaterModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Inebriator;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InebriatorRenderer<Type extends Inebriator> extends BaseInfectedRenderer<Type , InebriaterModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inebriater.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inebriater.png");


    public InebriatorRenderer(EntityRendererProvider.Context context) {
        super(context, new InebriaterModel<>(context.bakeLayer(InebriaterModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new InebriatorGlow<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    static class InebriatorGlow<T extends Inebriator,M extends InebriaterModel<T>> extends RenderLayer<T, M> {
        private static final ResourceLocation TOXIN_TEXTURE = new ResourceLocation(Spore.MODID,
                "textures/entity/eyes/inebriater_ef.png");
        public InebriatorGlow(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }
        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!entity.isInvisible()){
                float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.1F);
                VertexConsumer vertexConsumer = buffer.getBuffer(SporeRenderTypes.glowingTranslucent(TOXIN_TEXTURE));
                getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, 15728640, 1.0F, 1.0F, 1.0F, alpha);
            }
        }
    }
}