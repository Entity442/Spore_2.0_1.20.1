package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.NaiadModel;
import com.Harbinger.Spore.Client.Models.NaiadTritonModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Naiad;
import com.Harbinger.Spore.Sentities.Variants.NaiadVariants;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
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
}
