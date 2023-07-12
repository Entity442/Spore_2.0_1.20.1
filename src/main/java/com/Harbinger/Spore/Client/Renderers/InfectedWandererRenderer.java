package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.InfectedWandererModel;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedWanderingTrader;
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
public class InfectedWandererRenderer<Type extends InfectedWanderingTrader> extends MobRenderer<Type , InfectedWandererModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_wanderer.png");
    public InfectedWandererRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedWandererModel<>(context.bakeLayer(InfectedWandererModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }


    private  class Eyes<Type extends InfectedWanderingTrader,M extends InfectedWandererModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/in_villager.png"));
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
