package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Leaper;
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

public class LeaperModel<T extends Leaper> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "leapermodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart armor;

	public LeaperModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.armor = root.getChild("armor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(13, 44).addBox(-3.5F, -2.0F, -5.0F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(69, 24).addBox(-4.0F, -2.0F, 1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(13, 36).addBox(-4.0F, -2.0F, -5.0F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(13, 38).addBox(4.0F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(67, 64).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 40).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -5.5F, -3.75F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r1 = flower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(18, 31).addBox(-6.6073F, -2.8145F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = flower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 16).addBox(-3.484F, -2.617F, -7.084F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = flower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 40).addBox(-3.484F, -2.617F, 1.084F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = flower.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.0F, 2.0F, 0.2182F, 0.0F, -0.3927F));

		PartDefinition cube_r4 = flower2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(30, 0).addBox(2.3057F, -1.6184F, -3.4729F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(34, 8).addBox(-7.514F, -2.7747F, -3.4729F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 15).addBox(-3.4892F, -2.3983F, -8.4229F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(63, 18).addBox(2.3057F, -1.6184F, -2.4729F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(24, 23).addBox(-3.4892F, -1.9949F, 1.3968F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition fungus = head.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(12, 62).addBox(-6.0F, -34.7F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 27.5F, 3.25F));

		PartDefinition cube_r9 = fungus.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(59, 58).addBox(5.75F, -30.75F, -3.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.228F, 0.1298F, -0.3342F));

		PartDefinition cube_r10 = fungus.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(60, 0).addBox(-4.0F, -34.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition cube_r11 = fungus.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(43, 60).addBox(-4.0F, -32.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r12 = fungus.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(62, 31).addBox(-6.0F, -35.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(30, 31).addBox(-5.0F, 9.0F, -3.0F, 10.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-4.5F, 4.5F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(-0.1F))
		.texOffs(48, 0).addBox(0.75F, 10.05F, -6.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(21, 7).addBox(-3.0F, -19.0F, -20.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 25.8F, 2.5F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(50, 31).addBox(0.75F, 7.25F, -10.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.8F, 6.5F, -0.3054F, 0.2618F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(52, 6).addBox(0.75F, 7.25F, -11.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.8F, 6.5F, -0.6109F, -0.2618F, 0.1309F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(54, 40).addBox(0.75F, 7.25F, -5.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.8F, 6.5F, 0.0F, 0.3491F, 0.2618F));

		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(58, 12).addBox(-1.25F, -2.75F, -4.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.8F, 6.5F, 0.4363F, -0.2182F, 0.2182F));

		PartDefinition cube_r18 = body.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(59, 46).addBox(3.75F, -8.75F, -3.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.8F, 6.5F, -0.2182F, 0.2618F, 0.0F));

		PartDefinition cube_r19 = body.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(59, 52).addBox(-4.25F, -6.75F, -5.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.8F, 6.5F, -0.3054F, -0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -5.5F, -6.5F, 12.0F, 8.0F, 7.0F, new CubeDeformation(-0.3F)), PartPose.offset(0.0F, 3.0F, 3.25F));

		PartDefinition back3 = spine2.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(12, 68).addBox(0.0F, -4.0F, -2.75F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -1.0F, -3.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition back4 = spine2.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(55, 64).addBox(-2.0F, -4.0F, -4.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -1.0F, -2.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(51, 17).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -1.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(68, 71).addBox(-2.0F, 0.0F, -2.25F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.1F))
		.texOffs(76, 6).addBox(-4.0F, 4.0F, -1.5F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 69).addBox(-4.0F, 4.0F, 2.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -0.25F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(18, 48).addBox(-2.0F, -3.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 0.0F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(30, 70).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.1F))
		.texOffs(36, 48).addBox(0.0F, 4.0F, 1.75F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(0.0F, 4.0F, -1.75F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.9F, 10.0F, 0.0F));

		PartDefinition RL = RightLeg.addOrReplaceChild("RL", CubeListBuilder.create().texOffs(31, 57).addBox(-1.75F, -1.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightForLeg = RL.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(47, 46).addBox(-1.75F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.9F, 10.0F, 0.0F));

		PartDefinition LJ = LeftLeg.addOrReplaceChild("LJ", CubeListBuilder.create().texOffs(0, 56).addBox(-2.25F, -1.0F, -2.5F, 4.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition leftForLeg = LJ.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(0, 42).addBox(-2.25F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition armor = partdefinition.addOrReplaceChild("armor", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -3.0F));

		PartDefinition cube_r20 = armor.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(72, 37).addBox(0.0F, -2.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition cube_r21 = armor.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(75, 62).addBox(-6.0F, -2.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1309F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			this.RightArm.xRot = -90F + Mth.sin(ageInTicks/10)/10;
			this.LeftArm.xRot = -90F + Mth.cos(ageInTicks/10)/10;
			if (entity.swinging){
				float f = 0;
				f = f + 1F;
				this.RightArm.xRot = -89.5F + f;
				this.LeftArm.xRot = -89.5F + f;

			}
		}else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		}else {
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}

		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		this.head.getChild("jaw").xRot = Mth.sin(ageInTicks/8)/10;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		armor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}