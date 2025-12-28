package com.Harbinger.Spore.Client.Layers;

import com.Harbinger.Spore.Sentities.BasicInfected.Bairn;
import com.Harbinger.Spore.Sentities.Variants.BairnSkins;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import java.util.Map;

public class BairnEyeLayer<T extends Bairn, M extends EntityModel<T>> extends RenderLayer<T, M> {
    public BairnEyeLayer(RenderLayerParent<T, M> layerParent) {
        super(layerParent);
    }
    public static final Map<BairnSkins, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(BairnSkins.class), (p_114874_) -> {
                p_114874_.put(BairnSkins.ZOMBIE,
                       new ResourceLocation(Spore.MODID, "textures/entity/eyes/bairn/bairn_human.png"));
                p_114874_.put(BairnSkins.VILLAGER,
                        new ResourceLocation(Spore.MODID, "textures/entity/eyes/bairn/bairn_villager.png"));
                p_114874_.put(BairnSkins.DROWNED,
                        new ResourceLocation(Spore.MODID, "textures/entity/eyes/bairn/bairn_drowned.png"));
                p_114874_.put(BairnSkins.HUSK,
                        new ResourceLocation(Spore.MODID, "textures/entity/eyes/bairn/bairn_husk.png"));
                p_114874_.put(BairnSkins.ZOMBIE_VILLAGER,
                        new ResourceLocation(Spore.MODID, "textures/entity/eyes/bairn/bairn_zombie_villager.png"));
            });

    public void render(PoseStack p_116983_, MultiBufferSource p_116984_, int p_116985_, T type, float p_116987_, float p_116988_, float p_116989_, float p_116990_, float p_116991_, float p_116992_) {
        VertexConsumer vertexconsumer = p_116984_.getBuffer(RenderType.eyes(TEXTURE.get(type.getVariant())));
        this.getParentModel().renderToBuffer(p_116983_, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY,1,1,1,1);
    }

}