package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.HevokerModel;
import com.Harbinger.Spore.Client.Models.HevokerModelDead;
import com.Harbinger.Spore.Client.Models.VolatileModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Volatile;
import com.Harbinger.Spore.Sentities.Hyper.Hevoker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HevokerRenderer extends BaseInfectedRenderer<Hevoker, EntityModel<Hevoker>> {
    private final EntityModel<Hevoker> normalBraio = this.getModel();
    private final EntityModel<Hevoker> deadHevoker;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hyper_evoker.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/hyper_evoker.png");


    public HevokerRenderer(EntityRendererProvider.Context context) {
        super(context, new HevokerModel<>(context.bakeLayer(HevokerModel.LAYER_LOCATION)), 1f);
        deadHevoker = new HevokerModelDead<>(context.bakeLayer(HevokerModelDead.LAYER_LOCATION));
        addLayer(new TotemLayer<>(this,context.getItemInHandRenderer()));
        addLayer(new VolatileGlowingLayers<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Hevoker hevoker) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    protected boolean isShaking(Hevoker type) {
        return super.isShaking(type) || type.isFakeDead();
    }

    @Override
    public void render(Hevoker hevoker, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        this.model = hevoker.isFakeDead() ? deadHevoker : normalBraio;
        super.render(hevoker, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }

    private static class TotemLayer <T extends Hevoker, M extends EntityModel<T>> extends RenderLayer<T, M>{
        private final ItemInHandRenderer itemInHandRenderer;
        public TotemLayer(RenderLayerParent<T, M> parent, ItemInHandRenderer itemInHandRenderer) {
            super(parent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.isFakeDead()){
                ItemStack stack = new ItemStack(Items.TOTEM_OF_UNDYING);
                poseStack.pushPose();
                poseStack.translate(0, 1F, 0.3F);
                poseStack.scale(0.5F, 0.5F, 0.5F);
                poseStack.mulPose(Axis.XP.rotationDegrees(180.0F));
                poseStack.mulPose(Axis.YP.rotationDegrees(30.0F));
                itemInHandRenderer.renderItem(t,stack, ItemDisplayContext.FIXED,true,poseStack,multiBufferSource,i);
                poseStack.popPose();
            }
        }
    }

    static class VolatileGlowingLayers <T extends Hevoker,M extends EntityModel<T>> extends RenderLayer<T, M>{
        private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
                "textures/entity/hyper_evoker_glow.png");
        public VolatileGlowingLayers(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!entity.isInvisible() && !entity.isFakeDead()){
                float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.1F);
                VertexConsumer vertexConsumer = buffer.getBuffer(SporeRenderTypes.glowingTranslucent(TEXTURE));
                getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, 15728640, 1.0F, 1.0F, 1.0F, alpha);
            }
        }
    }
}
