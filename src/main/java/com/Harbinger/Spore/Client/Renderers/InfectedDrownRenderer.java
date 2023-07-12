package com.Harbinger.Spore.Client.Renderers;
import com.Harbinger.Spore.Client.Models.InfectedDrownModel;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedDrowned;
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
public class InfectedDrownRenderer<Type extends InfectedDrowned> extends MobRenderer<Type , InfectedDrownModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_drowned.png");
    public InfectedDrownRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedDrownModel<>(context.bakeLayer(InfectedDrownModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new Eyes<>(this));
    }

    private static class Eyes<Type extends InfectedDrowned,M extends InfectedDrownModel<Type>> extends EyesLayer<Type,M> {
        private static final RenderType EYES = RenderType.eyes(new ResourceLocation(Spore.MODID,"textures/entity/eyes/infected.png"));
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

}