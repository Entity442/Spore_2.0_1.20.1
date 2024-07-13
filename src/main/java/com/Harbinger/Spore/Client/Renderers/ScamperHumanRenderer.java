package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.ScamperModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ScamperHumanRenderer<Type extends Scamper> extends MobRenderer<Type , ScamperModel<Type>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/scamper.png");
    private static final ResourceLocation LINKED = new ResourceLocation(Spore.MODID,
            "textures/entity/scamper_linked.png");
    public ScamperHumanRenderer(EntityRendererProvider.Context context) {
        super(context, new ScamperModel<>(context.bakeLayer(ScamperModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getLinked() ? LINKED : TEXTURE;
    }

    @Override
    protected boolean isShaking(Type type) {
        return  type.isFreazing();
    }
}
