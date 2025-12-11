package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.BairnModel;
import com.Harbinger.Spore.Sentities.BasicInfected.Bairn;
import com.Harbinger.Spore.Sentities.Variants.BairnSkins;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class BairnRenderer extends MobRenderer<Bairn, EntityModel<Bairn>> {
    public static final Map<BairnSkins, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(BairnSkins.class), (p_114874_) -> {
                p_114874_.put(BairnSkins.ZOMBIE,
                        new ResourceLocation(Spore.MODID, "textures/entity/bairn/bairn_human.png"));
                p_114874_.put(BairnSkins.VILLAGER,
                        new ResourceLocation(Spore.MODID, "textures/entity/bairn/bairn_villager.png"));
                p_114874_.put(BairnSkins.DROWNED,
                        new ResourceLocation(Spore.MODID, "textures/entity/bairn/bairn_drowned.png"));
                p_114874_.put(BairnSkins.HUSK,
                        new ResourceLocation(Spore.MODID, "textures/entity/bairn/bairn_husk.png"));
                p_114874_.put(BairnSkins.ZOMBIE_VILLAGER,
                        new ResourceLocation(Spore.MODID, "textures/entity/bairn/bairn_zombie_villager.png"));
            });

    public BairnRenderer(EntityRendererProvider.Context context) {
        super(context, new BairnModel<>(context.bakeLayer(BairnModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Bairn hazmat) {
        return TEXTURE.get(hazmat.getVariant());
    }

}
