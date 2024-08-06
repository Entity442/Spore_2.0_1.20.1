package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Projectile.BileProjectile;
import com.Harbinger.Spore.Sentities.Projectile.FleshBomb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BileRound<T extends FleshBomb> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bileround"), "main");
	private final ModelPart BileMissile;
	private final ModelPart Tumor;
	private final ModelPart Tendrils;

	public BileRound() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BileMissile = root.getChild("BileMissile");
		this.Tumor = BileMissile.getChild("Tail").getChild("Biomass");
		this.Tendrils = BileMissile.getChild("Tail").getChild("Tendrils");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BileMissile = partdefinition.addOrReplaceChild("BileMissile", CubeListBuilder.create().texOffs(0, 0).addBox(-5.7859F, -7.8591F, -5.8501F, 12.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2141F, 15.8591F, -0.1499F));

		PartDefinition Bile_r1 = BileMissile.addOrReplaceChild("Bile_r1", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9698F, -2.0944F, 3.4616F, 0.2877F, -0.5467F, -0.5175F));

		PartDefinition Bile_r2 = BileMissile.addOrReplaceChild("Bile_r2", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -1.0F, -7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7859F, 0.1409F, 0.1499F, -0.2877F, -0.5467F, 0.5175F));

		PartDefinition Tail = BileMissile.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.2141F, -7.8591F, 0.1499F));

		PartDefinition Biomass = Tail.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(1.4335F, 3.0F, -3.3512F));

		PartDefinition Biomass_r1 = Biomass.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(0, 28).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9926F, -2.3258F, 0.612F, 0.3699F, 0.7124F, 0.2154F));

		PartDefinition Biomass_r2 = Biomass.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(2, 30).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8902F, -2.4341F, 6.7892F, -0.1987F, -0.4755F, 0.1473F));

		PartDefinition Biomass_r3 = Biomass.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(1, 29).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2826F, -1.3864F, -0.1536F, 0.0F, 0.5236F, 0.3491F));

		PartDefinition Biomass_r4 = Biomass.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(0, 28).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2467F, -2.5148F, 7.8847F, -0.1801F, -0.3913F, 0.0164F));

		PartDefinition Tendrils = Tail.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition root_3 = Tendrils.addOrReplaceChild("root_3", CubeListBuilder.create().texOffs(28, 28).addBox(-1.0F, -8.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8403F, 0.6943F, 1.558F, 0.0F, -0.5672F, 0.0F));

		PartDefinition r3seg2 = root_3.addOrReplaceChild("r3seg2", CubeListBuilder.create().texOffs(36, 28).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.4634F, -0.0145F, 0.0F, 0.0F, 0.0F));

		PartDefinition r3seg3 = r3seg2.addOrReplaceChild("r3seg3", CubeListBuilder.create().texOffs(44, 28).addBox(-0.5F, -9.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0815F, -8.5697F, -0.0142F));

		PartDefinition root_2 = Tendrils.addOrReplaceChild("root_2", CubeListBuilder.create().texOffs(28, 28).addBox(-1.0F, -10.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0041F, 0.6943F, -1.4346F, 0.0F, 0.5672F, 0.0F));

		PartDefinition r2seg2 = root_2.addOrReplaceChild("r2seg2", CubeListBuilder.create().texOffs(36, 28).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -10.4634F, -0.0145F, 0.0F, 0.0F, 0.0F));

		PartDefinition r2seg3 = r2seg2.addOrReplaceChild("r2seg3", CubeListBuilder.create().texOffs(44, 28).addBox(-0.5F, -11.0F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0815F, -10.5697F, -0.0142F));

		PartDefinition root_1 = Tendrils.addOrReplaceChild("root_1", CubeListBuilder.create().texOffs(28, 28).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9959F, 0.6943F, 1.5654F));

		PartDefinition r1seg2 = root_1.addOrReplaceChild("r1seg2", CubeListBuilder.create().texOffs(36, 28).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -6.4634F, -0.0145F, 0.0F, 0.0F, 0.0F));

		PartDefinition r1seg3 = r1seg2.addOrReplaceChild("r1seg3", CubeListBuilder.create().texOffs(44, 28).addBox(-0.5F, -7.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0815F, -6.5697F, -0.0142F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		BileMissile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}