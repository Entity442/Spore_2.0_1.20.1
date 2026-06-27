package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Thorn;
import com.Harbinger.Spore.Sentities.Variants.ThornVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ThornRenderer<Type extends Thorn> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = getModel();
    private final EntityModel<Type> cactusModel;
    private final EntityModel<Type> spikyModel;
    private final EntityModel<Type> roller;
    private final EntityModel<Type> rollingRoller;
    public static final Map<ThornVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(ThornVariants.class), (p_114874_) -> {
                p_114874_.put(ThornVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/vervathorn.png"));
                p_114874_.put(ThornVariants.TOXIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/toxic_vervathorn.png"));
                p_114874_.put(ThornVariants.CACTUS,
                        new ResourceLocation(Spore.MODID, "textures/entity/cactus_verva.png"));
                p_114874_.put(ThornVariants.SKEWER,
                        new ResourceLocation(Spore.MODID, "textures/entity/verdathorn_skewerer.png"));
                p_114874_.put(ThornVariants.ROLLER,
                        new ResourceLocation(Spore.MODID, "textures/entity/roller_verva.png"));
            });
    private static final ResourceLocation EYES_TEXTURE =  new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/vervathorn.png");

    private EntityModel<Type> switchModels(Type entity){
        if (entity.getVariant() == ThornVariants.CACTUS){
            return cactusModel;
        }
        if (entity.getVariant() == ThornVariants.SKEWER){
            return spikyModel;
        }
        if (entity.getVariant() == ThornVariants.ROLLER){
            return entity.getRolling() ? rollingRoller : roller;
        }
        return defaultModel;
    }

    public ThornRenderer(EntityRendererProvider.Context context) {
        super(context, new ThornModel<>(context.bakeLayer(ThornModel.LAYER_LOCATION)), 0.5f);
        cactusModel = new CactusVervaModel<>(context.bakeLayer(CactusVervaModel.LAYER_LOCATION));
        spikyModel = new SpikyThornModel<>(context.bakeLayer(SpikyThornModel.LAYER_LOCATION));
        roller = new RollerVervaModel<>(context.bakeLayer(RollerVervaModel.LAYER_LOCATION));
        rollingRoller = new RollerRollingVervaModel<>(context.bakeLayer(RollerRollingVervaModel.LAYER_LOCATION));
    }


    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        model = switchModels(type);
        super.render(type, value1, value2, stack, bufferSource, light);
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
