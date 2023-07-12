package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.InfectedPillagerModel;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPillager;
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
public class InfectedPillagerRenderer <Type extends InfectedPillager> extends MobRenderer<Type , InfectedPillagerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_pillager.png");

    public InfectedPillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedPillagerModel<>(context.bakeLayer(InfectedPillagerModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    private class Eyes<Type extends InfectedPillager, M extends InfectedPillagerModel<Type>> extends EyesLayer<Type, M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID, "textures/entity/eyes/inf_pillager.png"));

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