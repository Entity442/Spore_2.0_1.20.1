package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SiegerTailModel;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SiegerTailRenderer<Type extends SiegerTail> extends MobRenderer<Type , SiegerTailModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/sieger.png");
    private static final ResourceLocation WAR = new ResourceLocation(Spore.MODID,
            "textures/entity/war_sieger.png");


    public SiegerTailRenderer(EntityRendererProvider.Context context) {
        super(context, new SiegerTailModel<>(context.bakeLayer(SiegerTailModel.LAYER_LOCATION)), 1.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getWar() ? WAR:TEXTURE;
    }

}