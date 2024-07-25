package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.IncubatorModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.IncubatorBlockEntity;
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
public class IncubatorRenderer extends BaseBlockEntityRenderer<IncubatorBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/incubator/incubator.png");
    private static final ResourceLocation GLASS = new ResourceLocation(Spore.MODID,"textures/block/incubator/incubator_glass.png");
    private static final ResourceLocation BUTTONS = new ResourceLocation(Spore.MODID,"textures/block/incubator/incubator_buttons.png");
    public IncubatorRenderer() {
        super(new IncubatorModel<>());
    }
    @Override
    public int getTicks(IncubatorBlockEntity entity) {
        return entity.getTick();
    }
    @Override
    public ResourceLocation getTexture() {
        return TEXTURE;
    }
    @Override
    public void render(@NotNull IncubatorBlockEntity blockEntity, float partialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        super.render(blockEntity, partialTicks, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        if (unRenderBlock(blockEntity)){
            renderGlassTransparency(blockEntity,pPoseStack,pBuffer,pPackedLight,pPackedOverlay);
            renderActiveButtons(blockEntity,pPoseStack,pBuffer,pPackedLight,pPackedOverlay);
        }
    }

    public void renderGlassTransparency(IncubatorBlockEntity blockEntity, PoseStack stack, MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay){
        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(GLASS));
        this.setModelScale(stack,blockEntity);
        this.getModel().renderToBuffer(stack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
    }
    public void renderActiveButtons(IncubatorBlockEntity blockEntity, PoseStack stack, MultiBufferSource bufferSource, int pPackedLight, int pPackedOverlay){
        VertexConsumer vertexConsumer = bufferSource.getBuffer(blockEntity.isActive() ? RenderType.eyes(BUTTONS) : RenderType.entityCutout(BUTTONS));
        this.getModel().renderToBuffer(stack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
    }

    @Override
    public void setModelScale(PoseStack pPoseStack, IncubatorBlockEntity block) {
        int e = block.getSide();
        setModelScale(pPoseStack,block,e);
    }
}
