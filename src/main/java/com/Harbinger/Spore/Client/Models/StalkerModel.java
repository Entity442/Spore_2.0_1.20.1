package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Stalker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class StalkerModel<T extends Stalker> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "stalkermodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;

	public StalkerModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 21).addBox(-3.4608F, -1.7037F, -4.9741F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-3.9608F, -9.7037F, -4.9741F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 10).addBox(-2.0F, -9.7F, -5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(4, 23).addBox(-3.0F, -10.7F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(61, 48).addBox(-3.9608F, -1.7037F, 1.0259F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 17).addBox(-3.9608F, -1.7037F, -4.9741F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 19).addBox(4.0392F, -1.7037F, -3.9741F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, -0.75F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 8).addBox(-6.5F, -33.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.3F, 4.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(11, 7).addBox(-4.0F, -37.0F, -5.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.3F, 4.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition fungus = head.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.0F, -32.7F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 26.0F, 4.0F));

		PartDefinition cube_r3 = fungus.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-6, 75).addBox(5.75F, -30.75F, -3.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.228F, 0.1298F, -0.3342F));

		PartDefinition cube_r4 = fungus.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-6, 75).addBox(-4.0F, -34.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition cube_r5 = fungus.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-6, 75).addBox(-4.0F, -32.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r6 = fungus.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.0F, -35.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 15).addBox(-0.9608F, -0.7037F, -5.9741F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 15).addBox(-3.9608F, -0.7037F, -5.9741F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -7.0F, -3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r7 = flower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 93).addBox(-5.8388F, 0.253F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r8 = flower.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(14, 85).addBox(-3.9479F, 0.273F, -5.8869F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r9 = flower.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(15, 78).addBox(-3.9479F, 0.273F, -0.1131F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = flower.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.0F, 2.0F, 0.2182F, 0.0F, -0.3927F));

		PartDefinition cube_r10 = flower2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(70, 15).addBox(-0.2096F, 0.2061F, -4.06F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r11 = flower2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(88, 15).addBox(-8.0025F, 0.2939F, -4.06F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r12 = flower2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(88, 24).addBox(-5.1148F, 0.273F, -7.9519F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = flower2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(18, 71).addBox(-0.2096F, 0.2061F, -3.06F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = flower2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(70, 23).addBox(-5.1148F, 0.227F, -0.159F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(29, 42).addBox(-4.25F, 10.05F, -1.5F, 8.5F, 3.0F, 4.75F, new CubeDeformation(0.0F))
		.texOffs(27, 25).addBox(-4.0F, 4.8F, -1.5F, 8.0F, 6.0F, 4.75F, new CubeDeformation(-0.1F))
		.texOffs(-6, 75).addBox(-3.0F, 8.3F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(26, 8).addBox(-7.0F, -25.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.3F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.0F, -1.7F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 75).addBox(-1.0F, 0.3F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 75).addBox(-6.0F, 2.3F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 75).addBox(-3.0F, -3.7F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(-6, 75).addBox(-1.0F, 3.3F, -2.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 4.75F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r16 = spine2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 2.75F, -9.25F, 10.0F, 8.0F, 7.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -8.7F, -2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = spine2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(4, 18).addBox(-3.0F, -19.0F, -20.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r18 = spine2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.25F, -15.75F, 5.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, 0.5663F, -0.0226F, 0.2588F));

		PartDefinition cube_r19 = spine2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(-6, 75).addBox(1.75F, -21.75F, -1.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, 0.228F, 0.1298F, -0.3342F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 38).addBox(-2.0F, -1.7F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.75F, -2.0F, 0.25F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(39, 2).addBox(-2.0F, 0.3F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(1, 66).addBox(-4.0F, 4.0F, 1.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(1, 66).addBox(-4.0F, 4.0F, -1.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(28, 38).addBox(-1.0F, -1.7F, -2.5F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.75F, -2.0F, 0.75F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(46, 39).addBox(-1.0F, 0.3F, -2.75F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(46, 63).addBox(-1.0F, 4.0F, -1.5F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(46, 63).addBox(-1.0F, 4.0F, 0.5F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(28, 37).addBox(-2.75F, -0.7F, -1.75F, 3.75F, 7.0F, 3.75F, new CubeDeformation(0.0F)), PartPose.offset(-1.4F, 11.75F, 0.75F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(1, 43).addBox(-2.75F, 0.3F, -1.75F, 3.75F, 6.0F, 3.75F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(46, 37).addBox(-1.0F, -0.7F, -1.75F, 3.75F, 7.0F, 3.75F, new CubeDeformation(0.0F)), PartPose.offset(1.4F, 11.75F, 0.75F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(60, 22).addBox(-1.0F, 0.3F, -1.75F, 3.75F, 6.0F, 3.75F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.swinging){
			this.RightArm.xRot = -89.5f + (headPitch /  ( 90F / (float) Math.PI));
			this.LeftArm.xRot = this.RightArm.xRot;
		}
		else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

			if (RightArm.xRot < 0) {
				this.RightArm.getChild("RightForArm").xRot = RightArm.xRot;
			}
			if (LeftArm.xRot < 0) {
				this.LeftArm.getChild("LeftForArm").xRot = LeftArm.xRot;
			}

		} else {
			this.RightArm.xRot = Mth.sin(ageInTicks / 8) / 10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks / 8) / 10;
		}
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * -limbSwingAmount;
		if (RightLeg.xRot < 0) {
			this.RightLeg.getChild("rightForLeg").xRot = -RightLeg.xRot;
		}
		if (LeftLeg.xRot < 0) {
			this.LeftLeg.getChild("leftForLeg").xRot = -LeftLeg.xRot;
		}

		this.head.getChild("jaw").xRot = Mth.sin(ageInTicks / 8) / 10;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (90F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}