package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedVillagerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedVillager;
import com.Harbinger.Spore.Sentities.Variants.InfPlayerSkins;
import com.Harbinger.Spore.Sentities.Variants.InfVillagerSkins;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class InfectedVillagerRenderer <Type extends InfectedVillager> extends BaseInfectedRenderer<Type , InfectedVillagerModel<Type>> {
    public static final Map<InfVillagerSkins, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(InfVillagerSkins.class), (p_114874_) -> {
                p_114874_.put(InfVillagerSkins.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/in_villager.png"));
                p_114874_.put(InfVillagerSkins.DESERT,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_desert.png"));
                p_114874_.put(InfVillagerSkins.JUNGLE,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_jungle.png"));
                p_114874_.put(InfVillagerSkins.SAVANNA,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_savanna.png"));
                p_114874_.put(InfVillagerSkins.SWAMP,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_swamp.png"));
                p_114874_.put(InfVillagerSkins.TAIGA,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_taiga.png"));
                p_114874_.put(InfVillagerSkins.TUNDRA,
                        new ResourceLocation(Spore.MODID, "textures/entity/villager/inf_villager_tundra.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/in_villager.png");
    public InfectedVillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedVillagerModel<>(context.bakeLayer(InfectedVillagerModel.LAYER_LOCATION)), 0.5f);
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
