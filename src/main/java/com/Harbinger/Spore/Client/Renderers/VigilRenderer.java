package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.VigilModel;
import com.Harbinger.Spore.Client.Models.VigilSignModel;
import com.Harbinger.Spore.Sentities.Hyper.Hevoker;
import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import com.Harbinger.Spore.Sentities.Variants.VigilVariants;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
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
public class VigilRenderer<Type extends Vigil> extends OrganoidMobRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> alterModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/vigil.png");
    private static final ResourceLocation STALKER = new ResourceLocation(Spore.MODID,
            "textures/entity/vigil_stalker.png");


    public VigilRenderer(EntityRendererProvider.Context context) {
        super(context, new VigilModel<>(context.bakeLayer(VigilModel.LAYER_LOCATION)), 1f);
        this.alterModel = new VigilSignModel<>(context.bakeLayer(VigilSignModel.LAYER_LOCATION));
        this.addLayer(new SignModel<>(this,context.getItemInHandRenderer()));
    }


    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        this.model = type.getVariant() == VigilVariants.TROLL ? alterModel : defaultModel;
        super.render(type, value1, value2, stack, bufferSource, value3);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.isStalker() ? STALKER : TEXTURE;
    }

    @Override
    protected void scale(Type type, PoseStack stack, float value) {
        if (type.isStalker()){stack.scale(1.2f,1.2f,1.2f);}
        super.scale(type, stack, value);
    }

    private static class SignModel<T extends Vigil, M extends EntityModel<T>> extends RenderLayer<T, M>{
        private final ItemInHandRenderer itemInHandRenderer;
        public SignModel(RenderLayerParent<T, M> renderLayerParent, ItemInHandRenderer itemInHandRenderer) {
            super(renderLayerParent);
            this.itemInHandRenderer = itemInHandRenderer;
        }

        @Override
        public void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, T t, float v, float v1, float v2, float v3, float v4, float v5) {
            if (t.getVariant() == VigilVariants.TROLL && getParentModel() instanceof VigilSignModel<?> signModel){
                ItemStack stack = new ItemStack(Items.OAK_SIGN);
                poseStack.pushPose();
                for (ModelPart part : signModel.getArms()){
                    part.translateAndRotate(poseStack);
                }
                poseStack.translate(0.3f, 0.1F, -0.4F);
                poseStack.scale(2.25F, 2.25F, 2.25F);
                poseStack.mulPose(Axis.ZP.rotationDegrees(-180.0F));
                poseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
                itemInHandRenderer.renderItem(t,stack, ItemDisplayContext.THIRD_PERSON_LEFT_HAND,true,poseStack,multiBufferSource,i);
                poseStack.popPose();
            }
        }
    }

}