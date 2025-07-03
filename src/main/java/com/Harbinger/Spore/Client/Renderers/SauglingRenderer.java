package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SauglingModel;
import com.Harbinger.Spore.Client.Special.BaseExperimentRenderer;
import com.Harbinger.Spore.Sentities.Experiments.Saugling;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SauglingRenderer<Type extends Saugling> extends BaseExperimentRenderer<Type , SauglingModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/saugling.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/saugling.png");

    public SauglingRenderer(EntityRendererProvider.Context context) {
        super(context, new SauglingModel<>(context.bakeLayer(SauglingModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        if (type.isHidden()){
            return;
        }
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}