package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.LeaperModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Leaper;
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
public class LeaperRenderer <Type extends Leaper> extends MobRenderer<Type , LeaperModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/leaper.png");


    public LeaperRenderer(EntityRendererProvider.Context context) {
        super(context, new LeaperModel<>(context.bakeLayer(LeaperModel.LAYER_LOCATION)), 0.5f);

        this.addLayer(new Eyes<>(this));
    }

    private  class Eyes<Type extends Leaper,M extends LeaperModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/leaper.png"));
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
        return type.isFreazing();
    }
}