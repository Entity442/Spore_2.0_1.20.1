package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BrokenIronGolemModel;
import com.Harbinger.Spore.Client.Models.InfestedContructModel;
import com.Harbinger.Spore.Client.Special.BaseInfectedRenderer;
import com.Harbinger.Spore.Sentities.Utility.InfestedConstruct;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InfestedConstructRenderer<Type extends InfestedConstruct> extends BaseInfectedRenderer<Type , EntityModel<Type>> {
    private EntityModel<Type> brokenModel;
    private EntityModel<Type> awakeModel = this.getModel();
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/broken_construct.png");
    private static final ResourceLocation EYES_TEXTURE = new ResourceLocation(Spore.MODID,
            "textures/entity/eyes/broken_construct.png");
    private static final ResourceLocation IRON_GOLEM = new ResourceLocation(
            "minecraft:textures/entity/iron_golem/iron_golem.png");


    public InfestedConstructRenderer(EntityRendererProvider.Context context) {
        super(context, new InfestedContructModel<>(context.bakeLayer(InfestedContructModel.LAYER_LOCATION)), 1f);
        brokenModel = new BrokenIronGolemModel<>(context.bakeLayer(BrokenIronGolemModel.LAYER_LOCATION));
        this.addLayer(new CrackLater<>(this));
    }


    @Override
    public ResourceLocation getTextureLocation(Type entity) {
        return entity.isActive() ? TEXTURE : IRON_GOLEM;
    }

    @Override
    public ResourceLocation eyeLayerTexture() {
        return EYES_TEXTURE;
    }

    @Override
    public void render(Type type, float p_115456_, float p_115457_, PoseStack p_115458_, MultiBufferSource p_115459_, int p_115460_) {
        this.model = type.isActive() ? awakeModel : brokenModel;
        super.render(type, p_115456_, p_115457_, p_115458_, p_115459_, p_115460_);
    }
    private static class CrackLater<T extends InfestedConstruct> extends RenderLayer<T, EntityModel<T>>{
        private static final ResourceLocation BROKEN_LAYER = new ResourceLocation(
                "minecraft:textures/entity/iron_golem/iron_golem_crackiness_high.png");
        public CrackLater(RenderLayerParent<T, EntityModel<T>> p_117346_) {
            super(p_117346_);
        }

        @Override
        public void render(PoseStack stack, MultiBufferSource bufferSource, int value, T type, float v1, float v2, float v3, float v4, float v5, float v6) {
            if (!type.isActive()){
                VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(BROKEN_LAYER));
                this.getParentModel().prepareMobModel(type, v1, v2, v3);
                this.getParentModel().setupAnim(type, v1, v2, v4, v5, v6);
                this.getParentModel().renderToBuffer(stack, vertexconsumer, value, LivingEntityRenderer.getOverlayCoords(type, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}
