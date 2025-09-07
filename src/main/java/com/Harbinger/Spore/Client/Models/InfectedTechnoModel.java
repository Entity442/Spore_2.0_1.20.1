package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class InfectedTechnoModel<T extends InfectedPlayer> extends HumanoidModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infectedtechnomodel"), "main");
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart halo;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart hat;

	public InfectedTechnoModel(ModelPart root) {
		super(root);
		this.head = root.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.halo = this.head.getChild("halo");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.hat = root.getChild("hat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(19, 19).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 34).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(64, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(58, 26).addBox(-2.0F, -4.0F, -5.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.25F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -0.25F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -1.75F, -1.0F));

		PartDefinition halo = head.addOrReplaceChild("halo", CubeListBuilder.create().texOffs(59, 15).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 48).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.1F))
				.texOffs(0, 24).addBox(-3.5F, 6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.05F))
				.texOffs(24, 48).addBox(-3.5F, 6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(45, 13).addBox(-1.0F, -2.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 3).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.15F))
				.texOffs(0, 38).addBox(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(34, 43).addBox(-3.0F, -2.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(48, 42).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.15F))
				.texOffs(18, 37).addBox(-3.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 5).addBox(-1.9F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.1F))
				.texOffs(34, 33).addBox(-1.9F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(41, 22).addBox(-2.1F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(22, 26).addBox(-2.1F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(64, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T p_102866_, float p_102867_, float p_102868_, float ageInTicks, float p_102870_, float p_102871_) {
		super.setupAnim(p_102866_, p_102867_, p_102868_, ageInTicks, p_102870_, p_102871_);
		this.hat.visible = false;
		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
		this.halo.y = this.halo.getInitialPose().y + Mth.sin(ageInTicks/6)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}