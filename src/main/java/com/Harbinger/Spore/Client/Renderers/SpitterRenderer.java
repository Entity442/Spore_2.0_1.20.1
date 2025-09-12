package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.DualSpitterModel;
import com.Harbinger.Spore.Client.Models.SniperSpitterModel;
import com.Harbinger.Spore.Client.Models.SpitterModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Spitter;
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
public class SpitterRenderer <Type extends Spitter> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> dualModel;
    private final EntityModel<Type> sniperModel;
    public static final Map<SpitterVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(SpitterVariants.class), (p_114874_) -> {
                p_114874_.put(SpitterVariants.DEFAULT,
                        new ResourceLocation(Spore.MODID, "textures/entity/spitter.png"));
                p_114874_.put(SpitterVariants.EXPLOSIVE,
                        new ResourceLocation(Spore.MODID, "textures/entity/exploding_spitter.png"));
                p_114874_.put(SpitterVariants.BILE,
                        new ResourceLocation(Spore.MODID, "textures/entity/spitter_bile.png"));
                p_114874_.put(SpitterVariants.DUAL,
                        new ResourceLocation(Spore.MODID, "textures/entity/spitter_dual.png"));
                p_114874_.put(SpitterVariants.SNIPER,
                        new ResourceLocation(Spore.MODID, "textures/entity/sniper_spitter.png"));
            });
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/spitter.png");

    public SpitterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterModel<>(context.bakeLayer(SpitterModel.LAYER_LOCATION)), 0.5f);
        dualModel = new DualSpitterModel<>(context.bakeLayer(DualSpitterModel.LAYER_LOCATION));
        sniperModel = new SniperSpitterModel<>(context.bakeLayer(SniperSpitterModel.LAYER_LOCATION));
    }
    protected EntityModel<Type> entityModel(int val){
        return switch (val) {
            case 3 -> dualModel;
            case 4 -> sniperModel;
            default -> defaultModel;
        };
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
        this.model = entityModel(type.getTypeVariant());
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}