package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.UmarmerModel;
import com.Harbinger.Spore.Sentities.Organoids.Umarmer;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UmarmedRenderer<Type extends Umarmer> extends OrganoidMobRenderer<Type , UmarmerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/umarmer.png");
    public UmarmedRenderer(EntityRendererProvider.Context context) {
        super(context, new UmarmerModel<>(context.bakeLayer(UmarmerModel.LAYER_LOCATION)), 1.2f);
    }


    @Override
    protected boolean isShaking(Type type) {
        return type.isBurrowing() || type.isEmerging();
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
            return TEXTURE;
    }

}
