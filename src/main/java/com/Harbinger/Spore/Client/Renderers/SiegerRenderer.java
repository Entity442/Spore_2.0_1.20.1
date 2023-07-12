package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.SiegerModel;
import com.Harbinger.Spore.Sentities.Calamities.Sieger;
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
public class SiegerRenderer<Type extends Sieger> extends MobRenderer<Type , SiegerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/sieger.png");


    public SiegerRenderer(EntityRendererProvider.Context context) {
        super(context, new SiegerModel<>(context.bakeLayer(SiegerModel.LAYER_LOCATION)), 4f);
        this.addLayer(new SiegerRenderer.Eyes<>(this));
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
}
