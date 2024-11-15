package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.OgreModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Ogre;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class OgreRenderer<Type extends Ogre> extends BaseInfectedRenderer<Type , OgreModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/ogre.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/ogre.png");


    public OgreRenderer(EntityRendererProvider.Context context) {
        super(context, new OgreModel<>(context.bakeLayer(OgreModel.LAYER_LOCATION)), 1f);
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
    public void render(Type type, float value3, float p_115457_, PoseStack stack, MultiBufferSource p_115459_, int p_115460_) {
        float spinValue = -2.0F + 1.5F * Mth.triangleWave((float)type.getAttackAnimationTick() - value3, 10.0F);
        stack.mulPose(Axis.YP.rotationDegrees(spinValue *2));
        super.render(type, value3, p_115457_, stack, p_115459_, p_115460_);
    }
}
