package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BraionmilModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Braionmil;
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
public class BraioRenderer<Type extends Braionmil> extends MobRenderer<Type , BraionmilModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/baio.png");


    public BraioRenderer(EntityRendererProvider.Context context) {
        super(context, new BraionmilModel<>(context.bakeLayer(BraionmilModel.LAYER_LOCATION)), 0.5f);

        this.addLayer(new Eyes<>(this));
    }

    private  class Eyes<Type extends Braionmil,M extends BraionmilModel<Type>> extends EyesLayer<Type,M>{
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/baio.png"));
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
