package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.TumoralNukeModel;
import com.Harbinger.Spore.Sentities.Utility.TumoroidNuke;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class TumoroidNukeRenderer<Type extends TumoroidNuke> extends MobRenderer<Type , TumoralNukeModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/tumor_bomb.png");


    public TumoroidNukeRenderer(EntityRendererProvider.Context context) {
        super(context, new TumoralNukeModel<>(context.bakeLayer(TumoralNukeModel.LAYER_LOCATION)), 0.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}