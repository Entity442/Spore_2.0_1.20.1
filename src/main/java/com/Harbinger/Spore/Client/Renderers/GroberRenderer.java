package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.GroberfubModel;
import com.Harbinger.Spore.Client.Models.GroberfubOmniModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Hyper.Grober;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Objects;

@OnlyIn(Dist.CLIENT)
public class GroberRenderer<Type extends Grober> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    protected final EntityModel<Type> defaultModel = this.getModel();
    protected final EntityModel<Type> omniModel = new GroberfubOmniModel<>();
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/grober.png");
    private static final ResourceLocation OMNI = new ResourceLocation(Spore.MODID,
            "textures/entity/omniman.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/grober.png");

    public GroberRenderer(EntityRendererProvider.Context context) {
        super(context, new GroberfubModel<>(context.bakeLayer(GroberfubModel.LAYER_LOCATION)), 0.5f);
    }

    public boolean isOmniMan(Type entity){
        return Objects.equals(entity.getCustomName(), Component.literal("Omni-Man"));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return isOmniMan(entity) ? OMNI : TEXTURE;
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = isOmniMan(type) ? omniModel : defaultModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}