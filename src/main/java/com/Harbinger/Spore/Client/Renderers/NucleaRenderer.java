package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.NucleaChestplateLayer;
import com.Harbinger.Spore.Client.Models.NuckelaveModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Nuclealave;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class NucleaRenderer<Type extends Nuclealave> extends BaseInfectedRenderer<Type , NuckelaveModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/nuckelave.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/nuckelave.png");


    public NucleaRenderer(EntityRendererProvider.Context context) {
        super(context, new NuckelaveModel<>(context.bakeLayer(NuckelaveModel.LAYER_LOCATION),false), 1f);
        this.addLayer(new NucleaChestplateLayer<>(this,context.getModelSet(),context.getModelManager()));
        this.addLayer(new NucleaItemLayer<>(this, context.getItemInHandRenderer()));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }


    class NucleaItemLayer<T extends Nuclealave, M extends NuckelaveModel<T> & ArmedModel> extends ItemInHandLayer<T,M>{
        public NucleaItemLayer(RenderLayerParent renderLayerParent, ItemInHandRenderer item) {
            super(renderLayerParent, item);
        }

        @Override
        public void render(PoseStack stack, MultiBufferSource bufferSource, int light, T type, float p_117208_, float p_117209_, float p_117210_, float p_117211_, float p_117212_, float p_117213_) {
            stack.pushPose();
            stack.translate(0,-0.55,-0.65);
            super.render(stack, bufferSource, light, type, p_117208_, p_117209_, p_117210_, p_117211_, p_117212_, p_117213_);
            stack.popPose();
        }
    }
}
