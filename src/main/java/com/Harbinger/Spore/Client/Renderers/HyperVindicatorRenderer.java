package com.Harbinger.Spore.Client.Renderers;
import com.Harbinger.Spore.Client.Models.hVindicatorModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Hvindicator;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HyperVindicatorRenderer<Type extends Hvindicator> extends BaseInfectedRenderer<Type , hVindicatorModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hindicator.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/hindicator.png");
    public HyperVindicatorRenderer(EntityRendererProvider.Context context) {
        super(context, new hVindicatorModel<>(context.bakeLayer(hVindicatorModel.LAYER_LOCATION)), 0.5f);
        addLayer(new AxeLayer<>(this,context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }


    static class AxeLayer <T extends Hvindicator, M extends hVindicatorModel<T>> extends RenderLayer<T, M> {
        private final ItemInHandRenderer itemInHandRenderer;
        public AxeLayer(RenderLayerParent<T, M> parent, ItemInHandRenderer itemInHandRenderer) {
            super(parent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.hasAxe()){
                ItemStack stack = new ItemStack(Items.IRON_AXE);
                poseStack.pushPose();
                moveItemAround(getParentModel(),poseStack);
                poseStack.translate( 0,0.5,-0.15);
                poseStack.scale(1.4f,1.4f,1.4f);
                poseStack.mulPose(Axis.XP.rotationDegrees(-25.0F));
                itemInHandRenderer.renderItem(t,stack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND,true,poseStack,multiBufferSource,i);
                poseStack.popPose();
            }
        }
        void moveItemAround(M model,PoseStack stack){
            model.getHand().translateAndRotate(stack);
        }
    }
}