package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BurstUsurperModel;
import com.Harbinger.Spore.Client.Models.SprayUsurperModel;
import com.Harbinger.Spore.Client.Models.UsurperModel;
import com.Harbinger.Spore.Sentities.Organoids.Usurper;
import com.Harbinger.Spore.Sentities.Variants.UsurperVariants;
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
public class UsurperRenderer<Type extends Usurper> extends OrganoidMobRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> base = this.getModel();
    private final EntityModel<Type> burst;
    private final EntityModel<Type> spray;
    public static final Map<UsurperVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(UsurperVariants.class), (p_114874_) -> {
                p_114874_.put(UsurperVariants.DEFAULT,
                       new ResourceLocation(Spore.MODID, "textures/entity/usurper.png"));
                p_114874_.put(UsurperVariants.BURST,
                        new ResourceLocation(Spore.MODID, "textures/entity/burst_usurper.png"));
                p_114874_.put(UsurperVariants.SPRAY,
                        new ResourceLocation(Spore.MODID, "textures/entity/spray_usurper.png"));
            });


    public UsurperRenderer(EntityRendererProvider.Context context) {
        super(context, new UsurperModel<>(context.bakeLayer(UsurperModel.LAYER_LOCATION)), 1f);
        this.burst = new BurstUsurperModel<>(context.bakeLayer(BurstUsurperModel.LAYER_LOCATION));
        this.spray = new SprayUsurperModel<>(context.bakeLayer(SprayUsurperModel.LAYER_LOCATION));
    }

    protected EntityModel<Type> getUsurperModel(Type entity){
        switch (entity.getVariant()){
            case BURST -> {
                return burst;
            }
            case SPRAY -> {
                return spray;
            }
            default -> {
                return base;
            }
        }
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE.get(entity.getVariant());
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        this.model = getUsurperModel(type);
        super.render(type, value1, value2, stack, bufferSource, value3);
    }
}