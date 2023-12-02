package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SantaModel;
import com.Harbinger.Spore.Client.Models.SiegerModel;
import com.Harbinger.Spore.Client.Models.StalkerModel;
import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
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

import java.time.LocalDate;
import java.time.temporal.ChronoField;

@OnlyIn(Dist.CLIENT)
public class SiegerRenderer<Type extends Sieger> extends MobRenderer<Type , SiegerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/sieger.png");


    public SiegerRenderer(EntityRendererProvider.Context context) {
        super(context, new SiegerModel<>(context.bakeLayer(SiegerModel.LAYER_LOCATION)), 4f);
        this.addLayer(new SiegerRenderer.Eyes<>(this));
        this.addLayer(new SiegerHatLayer<>(this,context.getModelSet()));
    }
    private static class Eyes<Type extends Sieger,M extends SiegerModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/sieger.png"));
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


    @Override
    protected boolean isShaking(Type type) {
        return type.isStunned();
    }



    static class SiegerHatLayer<T extends Sieger> extends RenderLayer<T, SiegerModel<T>>{
        private static final ResourceLocation HAT_LOCATION = new ResourceLocation(Spore.MODID,"textures/entity/santa_hat.png");
        private final SantaModel<T> model;

        public SiegerHatLayer(RenderLayerParent<T, SiegerModel<T>> p_117346_,EntityModelSet set) {
            super(p_117346_);
            this.model = new SantaModel<>(set.bakeLayer(SantaModel.LAYER_LOCATION));
        }


        @Override
        public void render(PoseStack stack, MultiBufferSource bufferSource, int p_117351_, T type, float p_117353_, float p_117354_, float p_117355_, float p_117356_, float p_117357_, float p_117358_) {
            if (SConfig.SERVER.costumes.get()){
                LocalDate localdate = LocalDate.now();
                int j = localdate.get(ChronoField.MONTH_OF_YEAR);
                if (j == 12){
                    coloredCutoutModelCopyLayerRender(this.getParentModel(), this.model, HAT_LOCATION, stack, bufferSource, p_117351_, type, p_117353_, p_117354_, p_117355_, p_117356_, p_117357_, p_117358_, 1, 1, 1);
                }
            }
        }
    }
}
