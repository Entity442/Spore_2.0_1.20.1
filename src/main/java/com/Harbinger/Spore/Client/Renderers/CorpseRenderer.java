package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Utility.CorpseEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CorpseRenderer<T extends CorpseEntity> extends EntityRenderer<T> {
    private final EntityRenderDispatcher entityRenderer;
    public CorpseRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.entityRenderer = context.getEntityRenderDispatcher();
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return new ResourceLocation("minecraft", "textures/entity/steve.png");
    }

    @Override
    public void render(T entity, float val1, float val2, PoseStack stack, MultiBufferSource source, int light) {
        super.render(entity, val1, val2, stack, source, light);
    }
}
