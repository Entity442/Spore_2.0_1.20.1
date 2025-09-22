package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.MepheticBottle;
import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.MephiticModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Mephetic;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MephticRenderer<Type extends Mephetic> extends BaseInfectedRenderer<Type , MephiticModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/mephitic.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/mephitic.png");


    public MephticRenderer(EntityRendererProvider.Context context) {
        super(context, new MephiticModel<>(context.bakeLayer(MephiticModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new MepheticBottle(this));
        this.addLayer(new VolatileGlowingLayers<>(this));
        this.addLayer(new PotionLayer<>(this,context.getItemInHandRenderer()));
        this.addLayer(new HeldDrink<>(this,context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    static class VolatileGlowingLayers <T extends Mephetic,M extends MephiticModel<T>> extends RenderLayer<T, M>{
        private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
                "textures/entity/eyes/mephitic_glow.png");
        public VolatileGlowingLayers(RenderLayerParent<T, M> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack matrixStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            if (!entity.isInvisible()){
                float alpha = 0.5F + 0.5F * Mth.sin(ageInTicks * 0.1F);
                VertexConsumer vertexConsumer = buffer.getBuffer(SporeRenderTypes.glowingTranslucent(TEXTURE));
                getParentModel().renderToBuffer(matrixStack, vertexConsumer, packedLight, 15728640, 1.0F, 1.0F, 1.0F, alpha);
            }
        }
    }
    static class PotionLayer <T extends Mephetic, M extends MephiticModel<T>> extends RenderLayer<T, M>{
        private final ItemInHandRenderer itemInHandRenderer;
        public PotionLayer(RenderLayerParent<T, M> parent, ItemInHandRenderer itemInHandRenderer) {
            super(parent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.getPotions().isEmpty() || t.getPotions().size() < 3){
                return;
            }
            renderItem(poseStack,t,multiBufferSource,i,t.getPotions().get(0),-0.05f,0.05f);
            renderItem(poseStack,t,multiBufferSource,i,t.getPotions().get(1),0f,0f);
            renderItem(poseStack,t,multiBufferSource,i,t.getPotions().get(2),0.05f,-0.05f);
        }

        private void renderItem(PoseStack poseStack,T entity,MultiBufferSource source,int light,ItemStack stack,float x,float y){
            poseStack.pushPose();
            this.getParentModel().armParts.forEach(part -> {part.translateAndRotate(poseStack);});
            poseStack.translate(-0.15+x,1+y,0);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
            itemInHandRenderer.renderItem(entity,stack, ItemDisplayContext.FIXED,true,poseStack,source,light);
            poseStack.popPose();
        }
    }
    static class HeldDrink <T extends Mephetic, M extends MephiticModel<T>> extends RenderLayer<T, M>{
        private final ItemInHandRenderer itemInHandRenderer;
        public HeldDrink(RenderLayerParent<T, M> parent, ItemInHandRenderer itemInHandRenderer) {
            super(parent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            renderItem(poseStack,t,multiBufferSource,i,t.getMainHandItem(),0);
            renderItem(poseStack,t,multiBufferSource,i,t.getOffhandItem(),0.1f);
        }

        private void renderItem(PoseStack poseStack,T entity,MultiBufferSource source,int light,ItemStack stack,float offset){
            poseStack.pushPose();
            this.getParentModel().OffarmParts.forEach(part -> {part.translateAndRotate(poseStack);});
            poseStack.translate(0.2+offset,1.1,0);
            poseStack.scale(0.5F, 0.5F, 0.5F);
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            poseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
            itemInHandRenderer.renderItem(entity,stack, ItemDisplayContext.FIXED,true,poseStack,source,light);
            poseStack.popPose();
        }
    }
}
