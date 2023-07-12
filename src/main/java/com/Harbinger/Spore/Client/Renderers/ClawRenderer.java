package com.Harbinger.Spore.Client.Renderers;
import com.Harbinger.Spore.Client.Models.InfEvoClawModel;
import com.Harbinger.Spore.Sentities.Utility.InfEvoClaw;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClawRenderer <Type extends InfEvoClaw> extends MobRenderer<Type , InfEvoClawModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/claw.png");


    public ClawRenderer(EntityRendererProvider.Context context) {
        super(context, new InfEvoClawModel<>(context.bakeLayer(InfEvoClawModel.LAYER_LOCATION)), 0.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}