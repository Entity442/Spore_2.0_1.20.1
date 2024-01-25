package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;

public abstract class OrganoidMobRenderer<T extends Organoid, M extends EntityModel<T>> extends MobRenderer<T, M> {
    public OrganoidMobRenderer(EntityRendererProvider.Context context, M model, float shadow) {
        super(context, model, shadow);
    }
    @Override
    public void render(T type, float value1, float value2, PoseStack stack, MultiBufferSource bufferSource, int value3) {
        if (type.isBurrowing() || type.isEmerging()){
            float a = type.getBbHeight();
            float b = 0.0f;
            if (type.isBurrowing()){
                b =0 - (a / type.getBorrow_tick()) * type.getBorrow();
            }else if (type.isEmerging()){
                b = -a + ((a / type.getEmerge_tick()) * type.getEmerge());
            }
            stack.translate(0.0,b,0.0);
        }
        super.render(type, value1, value2, stack, bufferSource, value3);
    }

    @Override
    protected boolean isShaking(T type) {
        return type.isBurrowing() || type.isEmerging();
    }
}
