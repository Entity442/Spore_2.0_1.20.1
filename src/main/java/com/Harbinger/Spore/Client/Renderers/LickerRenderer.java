package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.LickerModel;
import com.Harbinger.Spore.Client.Models.SiegerTailModel;
import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class LickerRenderer<Type extends Licker> extends MobRenderer<Type , LickerModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/gazen.png");


    public LickerRenderer(EntityRendererProvider.Context context) {
        super(context, new LickerModel<>(context.bakeLayer(LickerModel.LAYER_LOCATION)), 0.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}