package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.StalkerModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Stalker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StalkerRenderer<Type extends Stalker> extends MobRenderer<Type , StalkerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/stalker/stalker.png");



    public StalkerRenderer(EntityRendererProvider.Context context) {
        super(context, new StalkerModel<>(context.bakeLayer(StalkerModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new StalkerOuterLayer<>(this,context.getModelSet()));
        this.addLayer(new Eyes<>(this));
    }

    private static class Eyes<Type extends Stalker,M extends StalkerModel<Type>> extends EyesLayer<Type,M>{
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/stalker.png"));
        public Eyes(RenderLayerParent layer) {
            super(layer);
        }
        public RenderType renderType() {
            return EYES;
        }
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    private static class StalkerOuterLayer<T extends Stalker> extends RenderLayer<T, StalkerModel<T>> {
        private final StalkerModel<T> model;

        public StalkerOuterLayer(RenderLayerParent<T, StalkerModel<T>> p_174490_, EntityModelSet set) {
            super(p_174490_);
            this.model = new StalkerModel<>(set.bakeLayer(StalkerModel.LAYER_LOCATION));
        }
        public void render(PoseStack p_116924_, MultiBufferSource p_116925_, int p_116926_, T entity, float p_116928_, float p_116929_, float p_116930_, float p_116931_, float p_116932_, float p_116933_) {
            ResourceLocation STALKER_LAYER_LOCATION;
            if (entity.getCamo() == 1){
                STALKER_LAYER_LOCATION = new ResourceLocation(Spore.MODID,
                        "textures/entity/stalker/stalker_moss_layer.png");
            }else if (entity.getCamo() == 2){
                STALKER_LAYER_LOCATION = new ResourceLocation(Spore.MODID,
                        "textures/entity/stalker/stalker_snow_layer.png");
            }else if (entity.getCamo() == 3){
                STALKER_LAYER_LOCATION = new ResourceLocation(Spore.MODID,
                        "textures/entity/stalker/stalker_sand_layer.png");
            }else{
                STALKER_LAYER_LOCATION = new ResourceLocation(Spore.MODID,
                        "textures/entity/empty.png");
            }
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, STALKER_LAYER_LOCATION, p_116924_, p_116925_, p_116926_, entity, p_116928_, p_116929_, p_116931_, p_116932_, p_116933_, p_116930_, 1.0F, 1.0F, 1.0F);
        }
    }

    @Override
    protected boolean isShaking(Type type) {
        return type.isFreazing();
    }
}
