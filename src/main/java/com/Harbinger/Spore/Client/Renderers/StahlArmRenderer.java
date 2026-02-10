package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.StahlFallenArmModel;
import com.Harbinger.Spore.Sentities.FallenMultipart.StalhArm;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StahlArmRenderer<Type extends StalhArm> extends MobRenderer<Type , StahlFallenArmModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/stalh.png");


    public StahlArmRenderer(EntityRendererProvider.Context context) {
        super(context, new StahlFallenArmModel<>(), 1.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}