package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.hohlfresserHeadModel;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HohlRenderer<Type extends Hohlfresser> extends CalamityRenderer<Type , EntityModel<Type>>{
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hohl_head.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/hohl_head.png");


    public HohlRenderer(EntityRendererProvider.Context context) {
        super(context, new hohlfresserHeadModel<>(context.bakeLayer(hohlfresserHeadModel.LAYER_LOCATION)), 4f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }
    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}
