package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SpitterModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Spitter;
import com.Harbinger.Spore.Sentities.Variants.SpitterVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class SpitterRenderer <Type extends Spitter> extends BaseInfectedRenderer<Type , SpitterModel<Type>> {
    public static final Map<SpitterVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(SpitterVariants.class), (p_114874_) -> {
                p_114874_.put(SpitterVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/spitter.png"));
                p_114874_.put(SpitterVariants.EXPLOSIVE,
                        new ResourceLocation(Spore.MODID, "textures/entity/exploding_spitter.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/spitter.png");

    public SpitterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterModel<>(context.bakeLayer(SpitterModel.LAYER_LOCATION)), 0.5f);
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