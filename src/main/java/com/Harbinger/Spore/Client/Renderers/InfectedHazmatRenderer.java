package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.InfectedHazmatModel;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedHazmat;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfectedHazmatRenderer<Type extends InfectedHazmat> extends MobRenderer<Type , InfectedHazmatModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_hazmat.png");
    public InfectedHazmatRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedHazmatModel<>(context.bakeLayer(InfectedHazmatModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
            return TEXTURE;
    }

}
