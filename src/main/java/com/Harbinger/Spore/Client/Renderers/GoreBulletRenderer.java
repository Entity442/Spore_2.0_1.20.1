package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.GoreBullet;
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
public class GoreBulletRenderer extends EntityRenderer<GoreBullet> {
    public static final ResourceLocation TEXTURE_LOCATION =new ResourceLocation(Spore.MODID,"textures/entity/gore_round.png");
    private final GoreRound<GoreBullet> model;
    public GoreBulletRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new GoreRound<>();
    }

    public void render(GoreBullet spear, float p_116112_, float partial, PoseStack stack, MultiBufferSource bufferSource, int light) {
        stack.pushPose();
        stack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partial, spear.yRotO, spear.getYRot()) - 90.0F));
        stack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partial, spear.xRotO, spear.getXRot()) + 90.0F));
        int i = spear.getMutationVariant().getColor();
        float r = (float) (i >> 16 & 255) / 255.0F;
        float g = (float) (i >> 8 & 255) / 255.0F;
        float b = (float) (i & 255) / 255.0F;
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(getTextureLocation(spear)));
        this.model.renderToBuffer(stack, vertexconsumer, light, OverlayTexture.NO_OVERLAY, r,g,b,1);
        stack.popPose();
        super.render(spear, p_116112_, partial, stack, bufferSource, light);
    }
    public ResourceLocation getTextureLocation(GoreBullet p_116109_) {
        return TEXTURE_LOCATION;
    }



    public static class GoreRound<T extends GoreBullet> extends EntityModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "goreround"), "main");
        private final ModelPart GoreRound;

        public GoreRound() {
            ModelPart root = createBodyLayer().bakeRoot();
            this.GoreRound = root.getChild("GoreRound");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition GoreRound = partdefinition.addOrReplaceChild("GoreRound", CubeListBuilder.create().texOffs(6, 0).addBox(-1.2125F, 0.2375F, 0.5125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(6, 2).addBox(-0.3125F, -0.3625F, -1.8875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                    .texOffs(6, 4).addBox(0.0875F, -0.7625F, -0.2875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.1F))
                    .texOffs(6, 6).addBox(-1.0125F, -0.4625F, -0.7875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0125F, 22.7625F, 0.1875F));

            PartDefinition BoneBit_r1 = GoreRound.addOrReplaceChild("BoneBit_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.0125F, -0.3625F, 0.6125F, 3.0994F, 0.3656F, 0.771F));

            PartDefinition BoneBit_r2 = GoreRound.addOrReplaceChild("BoneBit_r2", CubeListBuilder.create().texOffs(0, 4).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.9125F, 0.5375F, 1.0125F, -2.7757F, 0.0394F, 2.3569F));

            PartDefinition BoneBit_r3 = GoreRound.addOrReplaceChild("BoneBit_r3", CubeListBuilder.create().texOffs(0, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.2875F, -0.1625F, -1.3875F, -1.933F, 0.7519F, -2.2778F));

            PartDefinition BoneBit_r4 = GoreRound.addOrReplaceChild("BoneBit_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.0875F, -0.6625F, 0.2125F, 0.0F, -0.3142F, -0.4538F));

            return LayerDefinition.create(meshdefinition, 16, 16);
        }

        @Override
        public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
            GoreRound.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
        }
    }
}