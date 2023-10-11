package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class TendrilOverlay<E extends LivingEntity, M extends EntityModel<E>> extends RenderLayer<E, M> {
    ResourceLocation TEXTURE;

    public TendrilOverlay(RenderLayerParent<E, M> parent) {
        super(parent);
    }

    @Override
    public void render(PoseStack stack, MultiBufferSource bufferSource, int value, E entity, float value1, float value2, float value3, float value4, float value5, float value6) {
        if (entity.hasEffect(Seffects.MYCELIUM.get()) && entity.getHealth() < entity.getMaxHealth()){
            if (entity.getHealth() < entity.getMaxHealth()/4){
                TEXTURE = new ResourceLocation(Spore.MODID, "textures/tendril_overlay/tendril4.png");
            }else if (entity.getHealth() < entity.getMaxHealth()/3){
                TEXTURE = new ResourceLocation(Spore.MODID, "textures/tendril_overlay/tendril3.png");
            }else if (entity.getHealth() < entity.getMaxHealth()/2){
                TEXTURE = new ResourceLocation(Spore.MODID, "textures/tendril_overlay/tendril2.png");
            }else{
                TEXTURE = new ResourceLocation(Spore.MODID, "textures/tendril_overlay/tendril1.png");
            }
            coloredCutoutModelCopyLayerRender(this.getParentModel(), this.getParentModel(), TEXTURE, stack, bufferSource, value, entity,
                    value1, value2, value4, value5, value6, value3, 1, 1, 1);
        }
    }
}
