package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BraionmilBabe;
import com.Harbinger.Spore.Client.Models.BraionmilModel;
import com.Harbinger.Spore.Client.Models.ExplodingBusserModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Braionmil;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class BraioRenderer extends BaseInfectedRenderer<Braionmil , EntityModel<Braionmil>> {
    private final EntityModel<Braionmil> normalBraio = this.getModel();
    private final EntityModel<Braionmil> babeBraio;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/baio.png");
    private static final ResourceLocation BABE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/braio_babe.png");
    private static final ResourceLocation EYE_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/baio.png");


    public BraioRenderer(EntityRendererProvider.Context context) {
        super(context, new BraionmilModel<>(context.bakeLayer(BraionmilModel.LAYER_LOCATION)), 0.5f);
        babeBraio = new BraionmilBabe<>(context.bakeLayer(BraionmilBabe.LAYER_LOCATION));
    }

    protected boolean isBabe(Braionmil braionmil){
        return Objects.equals(braionmil.getCustomName(), Component.literal("Babe"));
    }


    @Override
    public ResourceLocation getTextureLocation(Braionmil entity) {
        return isBabe(entity) ? BABE_TEXTURE : TEXTURE;
    }


    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYE_TEXTURE;
    }

    @Override
    public void render(Braionmil braionmil, float p_115456_, float p_115457_, PoseStack stack, MultiBufferSource bufferSource, int p_115460_) {
        this.model = isBabe(braionmil) ? babeBraio : normalBraio;
        super.render(braionmil, p_115456_, p_115457_, stack, bufferSource, p_115460_);
    }
}
