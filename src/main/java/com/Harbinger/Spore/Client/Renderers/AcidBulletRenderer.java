package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.AssassinBullet;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AcidBulletRenderer extends EntityRenderer<AssassinBullet> {
    public static final ResourceLocation TEXTURE_LOCATION =new ResourceLocation(Spore.MODID,"textures/entity/acid_round.png");
    private final AcidRound<AssassinBullet> model;
    public AcidBulletRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new AcidRound<>();
    }

    public void render(AssassinBullet spear, float p_116112_, float partial, PoseStack stack, MultiBufferSource bufferSource, int light) {
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partial, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partial, spear.xRotO, spear.getXRot()) + 90.0F));
        int i = spear.getMutationVariant().getColor();
        float r = (float) (i >> 16 & 255) / 255.0F;
        float g = (float) (i >> 8 & 255) / 255.0F;
        float b = (float) (i & 255) / 255.0F;
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.eyes(getTextureLocation(spear)));
        this.model.renderToBuffer(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, r,g,b,1);
        stack.popPose();
        super.render(spear, p_116112_, partial, stack, bufferSource, light);
    }
    public ResourceLocation getTextureLocation(AssassinBullet p_116109_) {
        return TEXTURE_LOCATION;
    }



    public static class AcidRound<T extends AssassinBullet> extends EntityModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "acidround"), "main");
        private final ModelPart AcidRound;

        public AcidRound() {
            ModelPart root = createBodyLayer().bakeRoot();
            this.AcidRound = root.getChild("AcidRound");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition AcidRound = partdefinition.addOrReplaceChild("AcidRound", CubeListBuilder.create().texOffs(4, 2).addBox(-0.44F, -0.6F, -0.49F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.03F))
                    .texOffs(4, 0).addBox(-0.54F, -0.5F, -0.89F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(4, 4).addBox(-0.64F, -0.4F, -1.54F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.04F, 23.5F, 0.39F, -1.5708F, 0.0F, 0.0F));

            PartDefinition acid_drip_r1 = AcidRound.addOrReplaceChild("acid_drip_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.54F, 0.1F, 0.71F, 0.0F, -0.0698F, 0.0F));

            PartDefinition acid_drip_r2 = AcidRound.addOrReplaceChild("acid_drip_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.66F, -0.1F, 0.71F, 0.0F, 0.0698F, 0.0F));

            return LayerDefinition.create(meshdefinition, 16, 16);
        }

        @Override
        public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
            AcidRound.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
        }
    }
}