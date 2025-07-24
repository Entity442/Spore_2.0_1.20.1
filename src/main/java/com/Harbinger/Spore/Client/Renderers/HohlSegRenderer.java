package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HohlfresserSeg1Model;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HohlSegRenderer<Type extends HohlMultipart> extends LivingEntityRenderer<Type , HohlfresserSeg1Model<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hohl_seg1.png");


    public HohlSegRenderer(EntityRendererProvider.Context context) {
        super(context, new HohlfresserSeg1Model<>(context.bakeLayer(HohlfresserSeg1Model.LAYER_LOCATION)), 4f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(Type type, PoseStack stack, float p_115316_) {
        float size = type.getSize();
        stack.scale(size,size,size);
        super.scale(type, stack, p_115316_);
    }
}
