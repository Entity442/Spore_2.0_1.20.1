package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Client.Models.BrainTentacleModel;
import com.Harbinger.Spore.Client.Models.brainMatterModel;
import com.Harbinger.Spore.Client.Special.BaseBlockEntityRenderer;
import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
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
public class BrainRemnantsRenderer extends BaseBlockEntityRenderer<BrainRemnantBlockEntity> {
    private BlockEntityModel<BrainRemnantBlockEntity> brainModel;
    private static final ResourceLocation TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/brain_bits.png");
    private static final ResourceLocation ROASTED_TEXTURE = new ResourceLocation(Spore.MODID,"textures/block/roasted_brain_bits.png");
    private static final ResourceLocation TENTACLE = new ResourceLocation(Spore.MODID,"textures/block/tentacle_brain.png");
    public BrainRemnantsRenderer() {
        super(new brainMatterModel<>());
        brainModel = new BrainTentacleModel<>();
    }

    @Override
    public ResourceLocation getTexture(BrainRemnantBlockEntity block) {
        return block.isOnFire() ? ROASTED_TEXTURE : TEXTURE;
    }

    @Override
    public void render(@NotNull BrainRemnantBlockEntity blockEntity, float partialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        super.render(blockEntity, partialTicks, pPoseStack, pBuffer, pPackedLight, pPackedOverlay);
        if (blockEntity.isOnFire()){
            renderTentacles(blockEntity,pPoseStack,partialTicks,pBuffer,pPackedLight,pPackedOverlay);
        }
    }
    public void renderTentacles(@NotNull BrainRemnantBlockEntity blockEntity,PoseStack pPoseStack,float partialTicks,MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay){
        pPoseStack.pushPose();
        float f = ((float)blockEntity.getTicks() + partialTicks);
        VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.entityCutout(TENTACLE));
        setModelScale(pPoseStack,blockEntity);
        this.brainModel.setupAnim(blockEntity,f);
        this.brainModel.renderToBuffer(pPoseStack,vertexConsumer,pPackedLight, pPackedOverlay,1,1,1,1);
        pPoseStack.popPose();
    }
}
