package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.NaiadModel;
import com.Harbinger.Spore.Client.Models.NaiadTritonModel;
import com.Harbinger.Spore.Client.Models.TridentNaiadCharge;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Naiad;
import com.Harbinger.Spore.Sentities.Variants.NaiadVariants;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
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
public class NaiadRenderer<Type extends Naiad> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> triton;
    private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/naiad.png");
    private static final ResourceLocation NAIAD_TRITON =new ResourceLocation(Spore.MODID,
            "textures/entity/naiad_triton.png");
    private static final ResourceLocation EYES_TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/naiad.png");


    public NaiadRenderer(EntityRendererProvider.Context context) {
        super(context, new NaiadModel<>(context.bakeLayer(NaiadModel.LAYER_LOCATION)), 1f);
        triton = new NaiadTritonModel<>(context.bakeLayer(NaiadTritonModel.LAYER_LOCATION));
        addLayer(new NaiadChargeRenderer<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getVariant() == NaiadVariants.TRITON ? NAIAD_TRITON : TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = type.getVariant() == NaiadVariants.TRITON ? triton : defaultModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }

    public class NaiadChargeRenderer<T extends Naiad> extends RenderLayer<T,EntityModel<T>> {
        private final TridentNaiadCharge<T> model;
        public static final ResourceLocation TEXTURE = new ResourceLocation("minecraft:textures/entity/trident_riptide.png");
        public NaiadChargeRenderer(RenderLayerParent<T, EntityModel<T>> renderer) {
            super(renderer);
            model = new TridentNaiadCharge<>();
        }

        @Override
        public void render(PoseStack stack, MultiBufferSource multiBufferSource, int value, T type, float v1, float v2, float v3, float v4, float v5, float v6) {
            if (type.isCharging() && type.getVariant() == NaiadVariants.TRITON){
                stack.pushPose();
                stack.translate(0,0.5,0);
                VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
                this.model.prepareMobModel(type, v1, v2, v3);
                this.model.setupAnim(type, v1, v2, v4, v5, v6);
                this.model.renderToBuffer(stack, vertexconsumer, value, OverlayTexture.NO_OVERLAY, 1,1,1,1);
                stack.popPose();
            }
        }
    }
}
