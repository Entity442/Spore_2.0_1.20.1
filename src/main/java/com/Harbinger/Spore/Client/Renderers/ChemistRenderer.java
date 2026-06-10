package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Layers.TranslucentLayer;
import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Chemist;
import com.Harbinger.Spore.Sentities.Variants.ChemistVariants;
import com.Harbinger.Spore.Spore;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;

@OnlyIn(Dist.CLIENT)
public class ChemistRenderer extends MobRenderer<Chemist, EntityModel<Chemist>> {

    public static final Map<ChemistVariants, ResourceLocation> TEXTURE =
            Util.make(Maps.newEnumMap(ChemistVariants.class), (p_114874_) -> {
                p_114874_.put(ChemistVariants.DEFAULT,
                       new ResourceLocation(Spore.MODID, "textures/entity/chemist.png"));
                p_114874_.put(ChemistVariants.MECHANIC,
                        new ResourceLocation(Spore.MODID, "textures/entity/chemist_mechanic.png"));
                p_114874_.put(ChemistVariants.FUMING,
                        new ResourceLocation(Spore.MODID, "textures/entity/pyro_chemist.png"));
                p_114874_.put(ChemistVariants.BURST,
                        new ResourceLocation(Spore.MODID, "textures/entity/burst_chemist.png"));
                p_114874_.put(ChemistVariants.SPREADER,
                        new ResourceLocation(Spore.MODID, "textures/entity/spreader_chemist.png"));
            });
    private final EntityModel<Chemist> defaultModel = this.getModel();
    private final EntityModel<Chemist> mechanicModel;
    private final EntityModel<Chemist> fumingModel;
    private final EntityModel<Chemist> burstModel;
    private final EntityModel<Chemist> spreaderModel;
    public ChemistRenderer(EntityRendererProvider.Context context) {
        super(context, new ChemistModel<>(context.bakeLayer(ChemistModel.LAYER_LOCATION)), 0.5f);
        addLayer(new ChemistGlassRenderer(this));
        mechanicModel = new MechanicChemistModel<>(context.bakeLayer(MechanicChemistModel.LAYER_LOCATION));
        fumingModel = new PyroChemistModel<>(context.bakeLayer(PyroChemistModel.LAYER_LOCATION));
        burstModel = new FireChemistModel<>(context.bakeLayer(FireChemistModel.LAYER_LOCATION));
        spreaderModel = new SpreaderChemistModel<>(context.bakeLayer(SpreaderChemistModel.LAYER_LOCATION));
    }
    public EntityModel<Chemist> getVariantModel(ChemistVariants gargoyleVariants){
        switch (gargoyleVariants){
            case MECHANIC -> {
                return mechanicModel;
            }
            case FUMING -> {
                return fumingModel;
            }
            case BURST -> {
                return burstModel;
            }
            case SPREADER -> {
                return spreaderModel;
            }
            case DEFAULT -> {
                return defaultModel;
            }
        }
        return defaultModel;
    }

    @Override
    public void render(Chemist entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        model = getVariantModel(entity.getVariant());
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(Chemist hazmat) {
        return TEXTURE.get(hazmat.getVariant());
    }

    private static class ChemistGlassRenderer extends TranslucentLayer<Chemist>{
        private static final ResourceLocation TEXTURE =new ResourceLocation(Spore.MODID,
                "textures/entity/eyes/chemist.png");
        public ChemistGlassRenderer(RenderLayerParent<Chemist, EntityModel<Chemist>> p_117346_) {
            super(p_117346_);
        }

        @Override
        public ResourceLocation getTexture(Chemist type) {
            return TEXTURE;
        }
    }
}
