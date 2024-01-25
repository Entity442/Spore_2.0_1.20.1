package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedHuskModel;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedHusk;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfectedHuskRenderer<Type extends InfectedHusk> extends BaseInfectedRenderer<Type , InfectedHuskModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_husk.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inf_husk.png");
    public InfectedHuskRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedHuskModel<>(context.bakeLayer(InfectedHuskModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(Type p_115314_, PoseStack poseStack, float p_115316_) {
        double size = 1.2d;
        poseStack.scale((float) size,(float)size,(float)size);
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}