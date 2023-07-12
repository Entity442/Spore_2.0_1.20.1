package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.HostModel;
import com.Harbinger.Spore.Sentities.Host;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HostRenderer<Type extends Host> extends MobRenderer<Type , HostModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/claw.png");


    public HostRenderer(EntityRendererProvider.Context context) {
        super(context, new HostModel<>(context.bakeLayer(HostModel.LAYER_LOCATION)), 0.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}