package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.JagdhundModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Jagdhund;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JagdhundRenderer<Type extends Jagdhund> extends BaseInfectedRenderer<Type , JagdhundModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/jagdhund.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/jagdhund.png");

    public JagdhundRenderer(EntityRendererProvider.Context context) {
        super(context, new JagdhundModel<>(context.bakeLayer(JagdhundModel.LAYER_LOCATION)), 0.5f);
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
    public void render(Type type, float p_115456_, float p_115457_, PoseStack stack, MultiBufferSource bufferSource, int p_115460_) {
        shadowRadius = type.isUnderground() ? 0f : 0.5f;
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight() * 2;
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / type.getBorrow_tick()) * type.getBorrow();
            }else if (type.isEmerging()){
                b = -a + ((a / type.getEmerge_tick()) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        if (!type.isUnderground() || type.isEmerging() || type.isBurrowing()){
            super.render(type, p_115456_, p_115457_, stack, bufferSource, p_115460_);
        }
    }

    @Override
    protected boolean isShaking(Type type) {
        return super.isShaking(type) || type.isBurrowing() || type.isEmerging();
    }

}