package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.GrabberSlasherModel;
import com.Harbinger.Spore.Client.Models.SlasherModel;
import com.Harbinger.Spore.Client.Models.SmasherSlasherModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
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
public class SlasherRenderer <Type extends Slasher> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.model;
    private final EntityModel<Type> smasher;
    private final GrabberSlasherModel<Type> grabber;
    public static final Map<SlasherVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(SlasherVariants.class), (p_114874_) -> {
                p_114874_.put(SlasherVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/slasher.png"));
                p_114874_.put(SlasherVariants.PIERCER,
                        new ResourceLocation(Spore.MODID, "textures/entity/piercer.png"));
                p_114874_.put(SlasherVariants.SMASHER,
                        new ResourceLocation(Spore.MODID, "textures/entity/smasher_slasher.png"));
                p_114874_.put(SlasherVariants.GRABBER,
                        new ResourceLocation(Spore.MODID, "textures/entity/grabber.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/slasher.png");

    public SlasherRenderer(EntityRendererProvider.Context context) {
        super(context, new SlasherModel<>(context.bakeLayer(SlasherModel.LAYER_LOCATION)), 0.5f);
        smasher = new SmasherSlasherModel<>(context.bakeLayer(SmasherSlasherModel.LAYER_LOCATION));
        grabber = new GrabberSlasherModel<>(context.bakeLayer(GrabberSlasherModel.LAYER_LOCATION));
    }
    private EntityModel<Type> getDefaultModel(int i){
        return switch (i) {
            case 2 -> smasher;
            case 3 -> grabber;
            default -> defaultModel;
        };
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = getDefaultModel(type.getTypeVariant());
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