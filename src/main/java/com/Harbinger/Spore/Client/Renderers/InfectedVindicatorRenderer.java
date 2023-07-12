package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedVindicatorModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.InfectedVendicator;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfectedVindicatorRenderer <Type extends InfectedVendicator> extends MobRenderer<Type , InfectedVindicatorModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_vindicator.png");
    public InfectedVindicatorRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedVindicatorModel<>(context.bakeLayer(InfectedVindicatorModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    private static class Eyes<Type extends InfectedVendicator,M extends InfectedVindicatorModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/inf_vindicator.png"));
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

