package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.UmarmerModel;
import com.Harbinger.Spore.Sentities.Organoids.Umarmer;
import com.Harbinger.Spore.Sentities.Variants.UmarmerVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class UmarmedRenderer<Type extends Umarmer> extends OrganoidMobRenderer<Type , UmarmerModel<Type>> {
    public static final Map<UmarmerVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(UmarmerVariants.class), (p_114874_) -> {
                p_114874_.put(UmarmerVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/umarmer.png"));
                p_114874_.put(UmarmerVariants.CHARRED,
                        new ResourceLocation(Spore.MODID, "textures/entity/umarmer_crispy.png"));
            });
    public UmarmedRenderer(EntityRendererProvider.Context context) {
        super(context, new UmarmerModel<>(context.bakeLayer(UmarmerModel.LAYER_LOCATION)), 1.2f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
            return TEXTURE.get(entity.getVariant());
    }

}
