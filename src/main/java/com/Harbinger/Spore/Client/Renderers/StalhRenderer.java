package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.StahlmorderModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Stahlmorder;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StalhRenderer<Type extends Stahlmorder> extends CalamityRenderer<Type , StahlmorderModel<Type>> {
    private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/stalh.png");
    private static final ResourceLocation EYE_TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/stalh.png");


    public StalhRenderer(EntityRendererProvider.Context context) {
        super(context, new StahlmorderModel<>(), 4f);
        this.addLayer(new StalhSwordLight<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYE_TEXTURE;
    }

    public static class StalhSwordLight<T extends Stahlmorder,M extends StahlmorderModel<T>>  extends RenderLayer<T, M>{
        private static final ResourceLocation BLADE =new  ResourceLocation(Spore.MODID,
                "textures/entity/eyes/stalh_blade.png");
        public StalhSwordLight(RenderLayerParent<T, M> renderer) {
            super(renderer);
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (t.isInvisible()){
                return;
            }
            float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.01F);
            VertexConsumer vertexConsumer = multiBufferSource.getBuffer(SporeRenderTypes.glowingTranslucent(BLADE));
            getParentModel().renderToBuffer(poseStack, vertexConsumer, i, OverlayTexture.NO_OVERLAY, 1f,1f,1f,alpha);
        }
    }
}
