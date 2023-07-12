package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.InfectedEvokerModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.InfectedEvoker;
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
public class InfectedEvokerRenderer<Type extends InfectedEvoker> extends MobRenderer<Type , InfectedEvokerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_evoker.png");

    public InfectedEvokerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedEvokerModel<>(context.bakeLayer(InfectedEvokerModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    private static class Eyes<Type extends InfectedEvoker, M extends InfectedEvokerModel<Type>> extends EyesLayer<Type, M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID, "textures/entity/eyes/inf_evoker.png"));

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