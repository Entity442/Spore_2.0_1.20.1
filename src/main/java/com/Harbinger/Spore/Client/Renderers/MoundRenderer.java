package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.MoundModel;
import com.Harbinger.Spore.Sentities.Organoids.Mound;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MoundRenderer<Type extends Mound> extends MobRenderer<Type , MoundModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/mound.png");
    private static final ResourceLocation TEXTURE_LARGE = new ResourceLocation(Spore.MODID,
            "textures/entity/mound_large.png");
    public MoundRenderer(EntityRendererProvider.Context context) {
        super(context, new MoundModel<>(context.bakeLayer(MoundModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    protected void scale(Mound mound, PoseStack poseStack, float p_115316_) {
        int scale = Math.max(mound.getAge(), 1);
        poseStack.scale((float) scale,(float)scale,(float)scale);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        if (entity.getAge() >= 3){
            return TEXTURE_LARGE;
        }else {
            return TEXTURE;
        }
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
