package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.SlasherModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class SlasherRenderer <Type extends Slasher> extends MobRenderer<Type , SlasherModel<Type>> {
    public static final Map<SlasherVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(SlasherVariants.class), (p_114874_) -> {
                p_114874_.put(SlasherVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/slasher.png"));
                p_114874_.put(SlasherVariants.PIERCER,
                        new ResourceLocation(Spore.MODID, "textures/entity/piercer.png"));
            });


    public SlasherRenderer(EntityRendererProvider.Context context) {
        super(context, new SlasherModel<>(context.bakeLayer(SlasherModel.LAYER_LOCATION)), 0.5f);

        this.addLayer(new Eyes<>(this));
    }

    private static class Eyes<Type extends Slasher,M extends SlasherModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/slasher.png"));
        public Eyes(RenderLayerParent layer) {
            super(layer);
        }
        public RenderType renderType() {
            return EYES;
        }
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getVariant());
    }


    @Override
    protected boolean isShaking(Type type) {
        return type.isFreazing();
    }
}