package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.DelusionerEnchanterModel;
import com.Harbinger.Spore.Client.Models.DelusionerModel;
import com.Harbinger.Spore.Sentities.Organoids.Delusionare;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DelusionareRenderer<Type extends Delusionare> extends OrganoidMobRenderer<Type , EntityModel<Type>> {
    private final EntityModel<Type> defaultModel = this.getModel();
    private final EntityModel<Type> mage;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/delusioner.png");
    private static final ResourceLocation TEXTURE_MAGE =  new ResourceLocation(Spore.MODID,
            "textures/entity/delusioner_mage.png");

    public DelusionareRenderer(EntityRendererProvider.Context context) {
        super(context, new DelusionerModel<>(context.bakeLayer(DelusionerModel.LAYER_LOCATION)), 1f);
        this.mage = new DelusionerEnchanterModel<>(context.bakeLayer(DelusionerEnchanterModel.LAYER_LOCATION));
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getTypeVariant() == 0 ? TEXTURE : TEXTURE_MAGE;
    }
    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        model = type.getTypeVariant() == 0 ? defaultModel : mage;
        super.render(type, value1, value2, stack, bufferSource, value3);
    }
}