package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GrieferModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Griefer;
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
public class GrieferRenderer  <Type extends Griefer> extends MobRenderer<Type , GrieferModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/griefer.png");
    public GrieferRenderer(EntityRendererProvider.Context context) {
        super(context, new GrieferModel<>(context.bakeLayer(GrieferModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
    }

    private  class Eyes<Type extends Griefer,M extends GrieferModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/griefer.png"));
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
        return type.isFreazing() || type.grieferExplosion();
    }
}
