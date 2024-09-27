package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GrieferModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Griefer;
import com.Harbinger.Spore.Sentities.Variants.GrieferVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class GrieferRenderer  <Type extends Griefer> extends BaseInfectedRenderer<Type , GrieferModel<Type>> {
    public static final Map<GrieferVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(GrieferVariants.class), (p_114874_) -> {
                p_114874_.put(GrieferVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer.png"));
                p_114874_.put(GrieferVariants.TOXIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer_toxic.png"));
                p_114874_.put(GrieferVariants.RADIOACTIVE,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer_radioactive.png"));
                p_114874_.put(GrieferVariants.BILE,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer_bile.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/griefer.png");

    public GrieferRenderer(EntityRendererProvider.Context context) {
        super(context, new GrieferModel<>(context.bakeLayer(GrieferModel.LAYER_LOCATION)), 0.5f);

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
