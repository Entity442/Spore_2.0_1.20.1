package com.Harbinger.Spore.Client.Renderers;
import com.Harbinger.Spore.Client.Models.DetasheHyperClaw;
import com.Harbinger.Spore.Sentities.Utility.HyperClaw;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HyperClawRenderer<Type extends HyperClaw> extends MobRenderer<Type , DetasheHyperClaw<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hyper_evoker.png");


    public HyperClawRenderer(EntityRendererProvider.Context context) {
        super(context, new DetasheHyperClaw<>(context.bakeLayer(DetasheHyperClaw.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return TEXTURE;
    }

}