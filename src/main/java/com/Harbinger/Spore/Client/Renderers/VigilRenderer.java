package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.VigilModel;
import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class VigilRenderer<Type extends Vigil> extends OrganoidMobRenderer<Type , VigilModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/vigil.png");
    private static final ResourceLocation STALKER = new ResourceLocation(Spore.MODID,
            "textures/entity/vigil_stalker.png");


    public VigilRenderer(EntityRendererProvider.Context context) {
        super(context, new VigilModel<>(context.bakeLayer(VigilModel.LAYER_LOCATION)), 1f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.isStalker() ? STALKER : TEXTURE;
    }

    @Override
    protected void scale(Type type, PoseStack stack, float value) {
        if (type.isStalker()){stack.scale(1.2f,1.2f,1.2f);}
        super.scale(type, stack, value);
    }
}