package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.ZoaholicModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.ZoaholicBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ZoaholicRenderer extends BaseBlockEntityRenderer<ZoaholicBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/zoaholic/zoaholic.png");
    private static final ResourceLocation GLASS = new ResourceLocation(Spore.MODID,"textures/block/zoaholic/zoaholic_glass.png");
    private static final ResourceLocation BUTTONS = new ResourceLocation(Spore.MODID,"textures/block/zoaholic/zoaholic_buttons.png");
    public ZoaholicRenderer() {
        super(new ZoaholicModel<>());
    }
    @Override
    public int getTicks(ZoaholicBlockEntity entity) {
        return entity.getTicks();
    }
    @Override
    public ResourceLocation getTexture() {
        return TEXTURE;
    }

    @Override
    public void render(@NotNull ZoaholicBlockEntity blockEntity, float partialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        super.render(blockEntity, partialTicks, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        if (unRenderBlock(blockEntity)){
            renderGlassTransparency(blockEntity,pPoseStack,pBuffer,pPackedLight,pPackedOverlay);
            renderActiveButtons(blockEntity,pPoseStack,pBuffer,pPackedLight,pPackedOverlay);
        }
    }

    public void renderGlassTransparency(ZoaholicBlockEntity blockEntity,PoseStack stack,MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay){
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(GLASS));
        this.setModelScale(stack,blockEntity);
        this.getModel().renderToBuffer(stack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
    }
    public void renderActiveButtons(ZoaholicBlockEntity zoaholicBlockEntity,PoseStack stack,MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay){
        VertexConsumer vertexConsumer = bufferSource.getBuffer(zoaholicBlockEntity.isActive() ? RenderType.eyes(BUTTONS) : RenderType.entityCutout(BUTTONS));
        this.getModel().renderToBuffer(stack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
    }

    @Override
    public void setModelScale(PoseStack pPoseStack, ZoaholicBlockEntity block) {
        int e = block.getSide();
        setModelScale(pPoseStack,block,e);
    }
}
