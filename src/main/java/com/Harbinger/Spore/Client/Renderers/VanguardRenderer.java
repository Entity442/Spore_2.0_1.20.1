package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.VanguardArrowLayerModel;
import com.Harbinger.Spore.Client.Models.VanguardModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Utility.Vanguard;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VanguardRenderer<Type extends Vanguard> extends BaseInfectedRenderer<Type , VanguardModel<Type>> {
    private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/vanguard.png");
    private static final ResourceLocation EYES_TEXTURE =new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/vanguard.png");


    public VanguardRenderer(EntityRendererProvider.Context context) {
        super(context, new VanguardModel<>(context.bakeLayer(VanguardModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new VanguardCrossbowHold<>(this,context.getItemInHandRenderer()));
        this.addLayer(new VanguardArrowLayer<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    private static class VanguardCrossbowHold<T extends Vanguard, M extends VanguardModel<T>> extends RenderLayer<T, M> {
        private final ItemInHandRenderer itemInHandRenderer;
        private static final ItemStack itemStack = new ItemStack(Items.FIREWORK_ROCKET);
        public VanguardCrossbowHold(RenderLayerParent<T, M> renderLayerParent, ItemInHandRenderer itemInHandRenderer) {
            super(renderLayerParent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.isInvisible()){
                return;
            }
            ItemStack stack = t.getItemInHand(InteractionHand.MAIN_HAND);
            poseStack.pushPose();
            for(ModelPart part : getParentModel().partList){
                part.translateAndRotate(poseStack);
            }
            poseStack.translate(-0.15f, 0.4F, 0.1F);
            poseStack.scale(1.25f, 1.25f, 1.25f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(-180.0F));
            poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
            poseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
            itemInHandRenderer.renderItem(t,stack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,true,poseStack,multiBufferSource,i);
            poseStack.popPose();
            ItemStack leftStack = t.getItemInHand(InteractionHand.OFF_HAND);
            poseStack.pushPose();
            for(ModelPart part : getParentModel().partList){
                part.translateAndRotate(poseStack);
            }
            poseStack.translate(0.05f, 0.55F, 0.1F);
            poseStack.scale(1.25f, 1.25f, 1.25f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-90.0F));
            itemInHandRenderer.renderItem(t,leftStack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,true,poseStack,multiBufferSource,i);
            poseStack.popPose();
            poseStack.pushPose();
            for(ModelPart part : getParentModel().pouchPartList){
                part.translateAndRotate(poseStack);
            }
            poseStack.translate(-0.2, 0.35, 0.55);
            poseStack.scale(1.25f, 1.25f, 1.25f);
            poseStack.mulPose(Axis.ZP.rotationDegrees(180.0F));
            poseStack.mulPose(Axis.YP.rotationDegrees(180.0F));
            itemInHandRenderer.renderItem(t,itemStack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,true,poseStack,multiBufferSource,i);
            poseStack.popPose();
        }
    }
    private static class VanguardArrowLayer<T extends Vanguard, M extends VanguardModel<T>> extends RenderLayer<T, M>{
        private final VanguardArrowLayerModel<T> model;
        private static final ResourceLocation ARROW_LOCATION =new ResourceLocation("minecraft:textures/entity/projectiles/arrow.png");
        public VanguardArrowLayer(RenderLayerParent<T, M> renderer) {
            super(renderer);
            model = new VanguardArrowLayerModel<>();
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.isInvisible()){
                return;
            }
            VertexConsumer vertexconsumer = multiBufferSource.getBuffer(RenderType.entityCutoutNoCull(ARROW_LOCATION));
            model.renderToBuffer(poseStack,vertexconsumer,i, LivingEntityRenderer.getOverlayCoords(t, 0.0F),1,1,1,1);
        }
    }
}
