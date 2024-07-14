package com.Harbinger.Spore.Client.Renderers;
import com.Harbinger.Spore.Client.Models.GastgeberModel;
import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GastGaverRenderer<Type extends GastGeber> extends MobRenderer<Type , GastgeberModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/gast.png");


    public GastGaverRenderer(EntityRendererProvider.Context context) {
        super(context, new GastgeberModel<>(context.bakeLayer(GastgeberModel.LAYER_LOCATION)), 0.6f);
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}