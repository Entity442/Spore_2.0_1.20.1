package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SpitterModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Spitter;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SpitterRenderer <Type extends Spitter> extends MobRenderer<Type , SpitterModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/spitter.png");
    public SpitterRenderer(EntityRendererProvider.Context context) {
        super(context, new SpitterModel<>(context.bakeLayer(SpitterModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    private  class Eyes<Type extends Spitter,M extends SpitterModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/spitter.png"));
        public Eyes(RenderLayerParent layer) {
            super(layer);
        }
        public RenderType renderType() {
            return EYES;
        }
    }
    @Override
    protected boolean isShaking(Type type) {
        return type.isFreazing();
    }
}