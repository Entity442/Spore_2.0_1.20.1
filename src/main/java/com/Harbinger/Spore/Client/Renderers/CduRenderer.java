package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.CDUModel;
import com.Harbinger.Spore.Client.Models.CDUModelInfested;
import com.Harbinger.Spore.Client.Models.ZoaholicModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
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
public class CduRenderer extends BaseBlockEntityRenderer<CDUBlockEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/cdu.png");
    private static final ResourceLocation TEXTURE2 = new ResourceLocation(Spore.MODID,"textures/block/infested_cdu.png");
    private final CDUModelInfested<CDUBlockEntity> infestedCDU = new CDUModelInfested<>();
    public CduRenderer() {
        super(new CDUModel<>());
    }
    @Override
    public ResourceLocation getTexture(CDUBlockEntity block) {
        return block.infested() ? TEXTURE2 : TEXTURE;
    }

    @Override
    public void render(@NotNull CDUBlockEntity blockEntity, float partialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        if (!unRenderBlock(blockEntity)){
            return;
        }
        pPoseStack.pushPose();
        float f = ((float)blockEntity.getTicks() + partialTicks);
        VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityCutout(getTexture(blockEntity)));
        setModelScale(pPoseStack,blockEntity);
        if (blockEntity.infested()){
            this.infestedCDU.setupAnim(blockEntity,f);
            this.infestedCDU.renderToBuffer(pPoseStack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
        }else {
            this.model.setupAnim(blockEntity,f);
            this.model.renderToBuffer(pPoseStack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
        }
        pPoseStack.popPose();
    }


    @Override
    public void setModelScale(PoseStack pPoseStack, CDUBlockEntity block) {
        int e = block.getSide();
        setModelScale(pPoseStack,block,e);
    }
}
