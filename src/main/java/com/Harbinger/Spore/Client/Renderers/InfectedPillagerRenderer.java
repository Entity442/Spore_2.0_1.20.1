package com.Harbinger.Spore.Client.Renderers;


import com.Harbinger.Spore.Client.Models.InfectedPillagerCaptainModel;
import com.Harbinger.Spore.Client.Models.InfectedPillagerModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPillager;
import com.Harbinger.Spore.Sentities.Variants.InfPillagerSkins;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfectedPillagerRenderer <Type extends InfectedPillager> extends BaseInfectedRenderer<Type , InfectedPillagerModel<Type>> {
    private final InfectedPillagerModel<Type> defaultModel = this.getModel();
    private final InfectedPillagerCaptainModel<Type> captainModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/inf_pillager.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/inf_pillager.png");
    private static final ResourceLocation CAPTAIN =  new ResourceLocation(Spore.MODID,
            "textures/entity/inf_pillager_captain.png");
    public InfectedPillagerRenderer(EntityRendererProvider.Context context) {
        super(context, new InfectedPillagerModel<>(context.bakeLayer(InfectedPillagerModel.LAYER_LOCATION)), 0.5f);
        captainModel = new InfectedPillagerCaptainModel<>(context.bakeLayer(InfectedPillagerCaptainModel.LAYER_LOCATION));
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getVariant() == InfPillagerSkins.CAPTAIN ? CAPTAIN : TEXTURE;
    }
    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        model = type.getVariant() == InfPillagerSkins.CAPTAIN ? captainModel : defaultModel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }
    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }
}