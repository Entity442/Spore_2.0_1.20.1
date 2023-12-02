package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GrieferModel;
import com.Harbinger.Spore.Client.Models.StalkerModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Griefer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Stalker;
import com.Harbinger.Spore.Sentities.Variants.GrieferVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.Util;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class GrieferRenderer  <Type extends Griefer> extends MobRenderer<Type , GrieferModel<Type>> {
    public static final Map<GrieferVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(GrieferVariants.class), (p_114874_) -> {
                p_114874_.put(GrieferVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer.png"));
                p_114874_.put(GrieferVariants.TOXIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer_toxic.png"));
                p_114874_.put(GrieferVariants.RADIOACTIVE,
                        new ResourceLocation(Spore.MODID, "textures/entity/griefer_radioactive.png"));
            });

    public GrieferRenderer(EntityRendererProvider.Context context) {
        super(context, new GrieferModel<>(context.bakeLayer(GrieferModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
    }

    private static class Eyes<Type extends Griefer,M extends GrieferModel<Type>> extends EyesLayer<Type,M> {
        private final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID, "textures/entity/eyes/griefer.png"));
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
        return type.isFreazing() || type.grieferExplosion();
    }

}
