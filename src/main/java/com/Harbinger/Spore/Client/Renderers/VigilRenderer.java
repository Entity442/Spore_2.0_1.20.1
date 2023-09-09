package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.VigilModel;
import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VigilRenderer<Type extends Vigil> extends MobRenderer<Type , VigilModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/vigil.png");


    public VigilRenderer(EntityRendererProvider.Context context) {
        super(context, new VigilModel<>(context.bakeLayer(VigilModel.LAYER_LOCATION)), 1f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    @Override
    protected boolean isShaking(Type type) {
        return type.isBurrowing() || type.isEmerging();
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight();
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / type.getBorrow_tick()) * type.getBorrow();
            }else if (type.isEmerging()){
                b = -a + ((a / type.getEmerge_tick()) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        super.render(type, value1, value2, stack, bufferSource, value3);
    }
}