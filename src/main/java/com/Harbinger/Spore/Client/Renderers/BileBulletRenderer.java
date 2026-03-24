package com.Harbinger.Spore.Client.Renderers;

import com.Harbinger.Spore.Sentities.Projectile.GunProjectiles.BileBullet;
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
public class BileBulletRenderer extends EntityRenderer<BileBullet> {
    public static final ResourceLocation TEXTURE_LOCATION =new ResourceLocation(Spore.MODID,"textures/entity/bile_round.png");
    private final BileRound<GoreBullet> model;
    public BileBulletRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BileRound<>();
    }

    public void render(BileBullet spear, float p_116112_, float partial, PoseStack stack, MultiBufferSource bufferSource, int light) {
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
    public ResourceLocation getTextureLocation(BileBullet p_116109_) {
        return TEXTURE_LOCATION;
    }



    public static class BileRound<T extends GoreBullet> extends EntityModel<T> {
        // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bileround"), "main");
        private final ModelPart BileRound;

        public BileRound() {
            ModelPart root = createBodyLayer().bakeRoot();
            this.BileRound = root.getChild("BileRound");
        }

        public static LayerDefinition createBodyLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            PartDefinition BileRound = partdefinition.addOrReplaceChild("BileRound", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8429F, -0.6857F, -1.2429F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 4).addBox(-1.1429F, -1.1857F, -1.0429F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                    .texOffs(0, 8).addBox(-0.6429F, 0.1143F, -0.5429F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1571F, 22.6857F, -0.1571F));

            PartDefinition bile_drip_r1 = BileRound.addOrReplaceChild("bile_drip_r1", CubeListBuilder.create().texOffs(0, 11).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1429F, -0.1857F, -1.2429F, -1.5708F, -1.2741F, 1.5708F));

            PartDefinition bile_drip_r2 = BileRound.addOrReplaceChild("bile_drip_r2", CubeListBuilder.create().texOffs(8, 8).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1429F, -0.1857F, 1.1571F, 1.5708F, -1.3439F, -1.5708F));

            PartDefinition bile_drip_r3 = BileRound.addOrReplaceChild("bile_drip_r3", CubeListBuilder.create().texOffs(8, 4).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1571F, -0.1857F, -0.0429F, 0.0F, 0.0F, -0.3491F));

            PartDefinition bile_drip_r4 = BileRound.addOrReplaceChild("bile_drip_r4", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, -1.0F, -1.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2429F, -0.1857F, -0.0429F, 0.0F, 0.0F, 0.1222F));

            return LayerDefinition.create(meshdefinition, 16, 16);
        }

        @Override
        public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
            BileRound.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
        }
    }
}