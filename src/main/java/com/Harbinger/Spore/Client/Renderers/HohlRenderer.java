package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.hohlfresserHeadModel;
import com.Harbinger.Spore.Client.Models.hohlfresserHeadModelAdapted;
import com.Harbinger.Spore.Client.Special.CalamityRenderer;
import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HohlRenderer<Type extends Hohlfresser> extends CalamityRenderer<Type , EntityModel<Type>>{
    private final EntityModel<Type> Defmodel = this.getModel();
    private final EntityModel<Type> adaptedModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/hohl_head.png");
    private static final ResourceLocation TEXTURE_ADAPTED =  new ResourceLocation(Spore.MODID,
            "textures/entity/hohl/hohl_head_adapted.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/hohl_head.png");


    public HohlRenderer(EntityRendererProvider.Context context) {
        super(context, new hohlfresserHeadModel<>(context.bakeLayer(hohlfresserHeadModel.LAYER_LOCATION)), 4f);
        adaptedModel = new hohlfresserHeadModelAdapted<>();
    }

    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.getAdaptation() ? TEXTURE_ADAPTED : TEXTURE;
    }
    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    protected void scale(Type livingEntity, PoseStack poseStack, float partialTickTime) {
        float val = livingEntity.getAdaptation() ? 1.75f : 1;
        poseStack.scale(val,val,val);
        super.scale(livingEntity, poseStack, partialTickTime);
    }

    @Override
    public void render(Type type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int light) {
        this.model = type.getAdaptation() ? adaptedModel : Defmodel;
        super.render(type, value1, value2, stack, bufferSource, light);
    }
}
