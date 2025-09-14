package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.ThornModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Thorn;
import com.Harbinger.Spore.Sentities.Variants.InfPlayerSkins;
import com.Harbinger.Spore.Sentities.Variants.ThornVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ThornRenderer<Type extends Thorn> extends BaseInfectedRenderer<Type , ThornModel<Type>> {
    public static final Map<ThornVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(ThornVariants.class), (p_114874_) -> {
                p_114874_.put(ThornVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/vervathorn.png"));
                p_114874_.put(ThornVariants.TOXIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/toxic_vervathorn.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/vervathorn.png");


    public ThornRenderer(EntityRendererProvider.Context context) {
        super(context, new ThornModel<>(context.bakeLayer(ThornModel.LAYER_LOCATION)), 0.5f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getVariant());
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}
