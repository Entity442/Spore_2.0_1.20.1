package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HowlerModel;
import com.Harbinger.Spore.Client.Models.bansheeHowlerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Howler;
import com.Harbinger.Spore.Sentities.Variants.HowlerVariants;
import com.Harbinger.Spore.Sentities.Variants.SpitterVariants;
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
public class HowlerRenderer<Type extends Howler> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> banshee;
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/howler.png");
    public static final Map<HowlerVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(HowlerVariants.class), (p_114874_) -> {
                p_114874_.put(HowlerVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/howler.png"));
                p_114874_.put(HowlerVariants.BANSHEE,
                        new ResourceLocation(Spore.MODID, "textures/entity/freaky_howler.png"));
            });

    public HowlerRenderer(EntityRendererProvider.Context context) {
        super(context, new HowlerModel<>(context.bakeLayer(HowlerModel.LAYER_LOCATION)), 0.5f);
        banshee = new bansheeHowlerModel<>(context.bakeLayer(bansheeHowlerModel.LAYER_LOCATION));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getVariant());
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = type.getVariant() == HowlerVariants.BANSHEE ? banshee : defaultModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}
