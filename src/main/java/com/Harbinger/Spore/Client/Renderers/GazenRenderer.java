package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GazenbrecherModel;
import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
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
public class GazenRenderer<Type extends Gazenbrecher> extends MobRenderer<Type , GazenbrecherModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/blank.png");


    public GazenRenderer(EntityRendererProvider.Context context) {
        super(context, new GazenbrecherModel<>(context.bakeLayer(GazenbrecherModel.LAYER_LOCATION)), 4f);
        this.addLayer(new GazenRenderer.Eyes<>(this));
    }
    private static class Eyes<Type extends Gazenbrecher,M extends GazenbrecherModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/blank.png"));
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
