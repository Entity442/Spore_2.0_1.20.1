package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BusserModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
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
public class BusserRenderer<Type extends Busser> extends MobRenderer<Type , BusserModel<Type>> {
    public static final Map<BusserVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(BusserVariants.class), (p_114874_) -> {
                p_114874_.put(BusserVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/busser.png"));
                p_114874_.put(BusserVariants.ENHANCED,
                        new ResourceLocation(Spore.MODID, "textures/entity/busser_aggressive.png"));
            });


    public BusserRenderer(EntityRendererProvider.Context context) {
        super(context, new BusserModel<>(context.bakeLayer(BusserModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
    }

    private static class Eyes<Type extends Busser,M extends BusserModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/busser.png"));
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
    protected void scale(Type type, PoseStack stack, float value) {
        if (type.getVariant() == BusserVariants.ENHANCED){
            float size = 1.4f;
            stack.scale(size,size,size);
        }
        super.scale(type, stack, value);
    }

    @Override
    protected boolean isShaking(Type type) {
        return type.isFreazing();
    }
}
