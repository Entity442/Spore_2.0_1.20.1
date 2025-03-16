package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Layers.SporeRenderTypes;
import com.Harbinger.Spore.Client.Models.NukeParts.BombFunnelModel;
import com.Harbinger.Spore.Client.Models.NukeParts.FireDiskModel;
import com.Harbinger.Spore.Client.Models.NukeParts.MushroomExplosionTop;
import com.Harbinger.Spore.Sentities.Utility.NukeEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class NuclearBombRenderer<T extends NukeEntity> extends EntityRenderer<T> {
    private static final ResourceLocation TOP_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/bomb/top.png");
    private static final ResourceLocation FUNNEL_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/bomb/funnel.png");
    private static final ResourceLocation RING_TEXTURE = new ResourceLocation(Spore.MODID, "textures/entity/bomb/fire_disk.png");
    private final BombFunnelModel<T> funnelModel;
    private final FireDiskModel<T> fireDiskModel;
    private final MushroomExplosionTop<T> mushroomExplosionTop;
    public NuclearBombRenderer(EntityRendererProvider.Context context) {
        super(context);
        funnelModel = new BombFunnelModel<>();
        fireDiskModel = new FireDiskModel<>();
        mushroomExplosionTop = new MushroomExplosionTop<>();
    }

    @Override
    public ResourceLocation getTextureLocation(T t) {
        return null;
    }
    public void renderTop(T bomb,PoseStack stack, MultiBufferSource bufferSource) {
        stack.pushPose();
        stack.scale(0.95f,1.05f,0.95f);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.eyes(TOP_TEXTURE));
        this.mushroomExplosionTop.renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        stack.popPose();
    }
    public void renderRing(T bomb,float ticks,PoseStack stack, MultiBufferSource bufferSource) {
        stack.pushPose();
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.eyes(RING_TEXTURE));
        this.fireDiskModel.renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        this.fireDiskModel.setupAnim(bomb,0,0,ticks,0,0);
        stack.popPose();
    }
    public void renderFire(T bomb,float ticks,PoseStack stack, MultiBufferSource bufferSource) {
        stack.pushPose();
        float uOffset = (ticks * 0.01f) % 1.0F;
        float vOffset = (ticks * 0.01f * 2) % 1.0F;
        RenderType renderType = SporeRenderTypes.energySwirlStatic(FUNNEL_TEXTURE, uOffset, vOffset);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(renderType);
        this.funnelModel.renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        stack.popPose();
    }
    public void renderTopFire(T bomb,float ticks,PoseStack stack, MultiBufferSource bufferSource) {
        stack.pushPose();
        float uOffset = (ticks * 0.01f) % 1.0F;
        float vOffset = (ticks * 0.01f * 2) % 1.0F;
        RenderType renderType = SporeRenderTypes.energySwirlStatic(FUNNEL_TEXTURE, -uOffset, -vOffset);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(renderType);
        this.mushroomExplosionTop.renderToBuffer(stack, vertexconsumer, 15728640, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        stack.popPose();
    }
    @Override
    public void render(T bomb, float entityYaw, float partialTick, PoseStack stack, MultiBufferSource bufferSource, int value) {
        float ticks = ((float) bomb.tickCount + partialTick);

        stack.pushPose();
        float scale = inflate(bomb);
        float yOffset = 1.5F * (1 / scale);
        stack.translate(0, yOffset, 0);
        stack.mulPose(Axis.ZP.rotationDegrees(-180F));
        stack.translate(0, -(bomb.getInitRange() / 1.2), 0);
        stack.scale(scale, scale, scale);
        renderTopFire(bomb, ticks, stack, bufferSource);
        renderFire(bomb, ticks, stack, bufferSource);
        renderTop(bomb, stack, bufferSource);
        renderRing(bomb, ticks, stack, bufferSource);

        stack.popPose();
        super.render(bomb, entityYaw, partialTick, stack, bufferSource, value);
    }

    public float inflate(T bomb) {
        return Math.max(bomb.getInitRange(), 1); // Ensures scale is at least 1
    }
}
