package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
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
	private final ModelPart Leaper;
	private final ModelPart hips;
	private final ModelPart waist;
	private final ModelPart upper_torso;
	private final ModelPart left_arm;
	private final ModelPart left_forearm;
	private final ModelPart left_claws;
	private final ModelPart right_arm;
	private final ModelPart right_forearm;
	private final ModelPart right_claws;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_foot;
	private final ModelPart right_leg;
	private final ModelPart right_foot;

	public LeaperModel(ModelPart root) {
		this.Leaper = root.getChild("Leaper");
		this.hips = this.Leaper.getChild("hips");
		this.waist = this.hips.getChild("waist");
		this.upper_torso = this.waist.getChild("upper_torso");
		this.left_arm = this.upper_torso.getChild("left_arm");
		this.left_forearm = this.left_arm.getChild("left_forearm");
		this.left_claws = this.left_forearm.getChild("left_claws");
		this.right_arm = this.upper_torso.getChild("right_arm");
		this.right_forearm = this.right_arm.getChild("right_forearm");
		this.right_claws = this.right_forearm.getChild("right_claws");
		this.head = this.upper_torso.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.legs = this.hips.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_foot = this.left_leg.getChild("left_foot");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_foot = this.right_leg.getChild("right_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Leaper = partdefinition.addOrReplaceChild("Leaper", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition hips = Leaper.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(32, 17).addBox(-5.0F, 0.0F, -3.5F, 10.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, 1.0F));

		PartDefinition cube_r1 = hips.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 25).addBox(-3.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -3.5F, -0.2174F, 0.0189F, 0.0852F));

		PartDefinition waist = hips.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(56, 6).addBox(-3.5F, -6.0F, -4.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 91).addBox(-1.5F, -6.0F, -4.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition cube_r2 = waist.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(92, 37).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition upper_torso = waist.addOrReplaceChild("upper_torso", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(0, 100).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.65F))
		.texOffs(48, 84).addBox(2.75F, -4.0F, 0.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 89).addBox(1.25F, -2.0F, 0.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition cube_r3 = upper_torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 70).addBox(1.5F, 0.0F, -4.0F, 5.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -4.0F, -4.0F, 0.4286F, 0.0311F, -0.6223F));

		PartDefinition cube_r4 = upper_torso.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(78, 75).addBox(0.5F, 0.0F, -4.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -4.0F, 0.3905F, 0.0545F, -0.4934F));

		PartDefinition cube_r5 = upper_torso.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(76, 48).addBox(-0.5F, 0.0F, -4.0F, 7.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.0F, -4.0F, 0.399F, 0.077F, -0.3642F));

		PartDefinition cube_r6 = upper_torso.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 88).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r7 = upper_torso.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(84, 93).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r8 = upper_torso.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(84, 87).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.6109F, -0.48F, 0.0F));

		PartDefinition cube_r9 = upper_torso.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(78, 6).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 1.0F, 0.6109F, -0.48F, 0.0F));

		PartDefinition cube_r10 = upper_torso.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(84, 0).addBox(-2.5F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0F, 0.5F, 0.2883F, 0.1298F, -0.132F));

		PartDefinition cube_r11 = upper_torso.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(72, 87).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.0F, 1.5F, 0.2883F, 0.1298F, -0.132F));

		PartDefinition cube_r12 = upper_torso.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 63).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r13 = upper_torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(16, 87).addBox(-3.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(4.25F, -3.5F, -4.5F, -0.104F, -0.0663F, -0.1313F));

		PartDefinition cube_r14 = upper_torso.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(32, 84).addBox(-1.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.25F, -3.5F, -4.5F, -0.104F, 0.0663F, 0.1313F));

		PartDefinition left_arm = upper_torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 63).addBox(0.125F, -0.75F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 79).addBox(0.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(112, 36).addBox(0.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(5.125F, -5.75F, -2.0F));

		PartDefinition cube_r15 = left_arm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 73).addBox(-0.5F, 0.0F, -3.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.5F, 0.5F, -0.1488F, -0.3866F, 0.7097F));

		PartDefinition cube_r16 = left_arm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 73).addBox(-0.5F, 0.0F, -3.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.25F, 0.5F, -0.0382F, -0.4112F, 0.4267F));

		PartDefinition cube_r17 = left_arm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(16, 73).addBox(-0.5F, 0.0F, -3.5F, 5.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.0F, 0.5F, 0.0945F, -0.4025F, 0.0941F));

		PartDefinition left_forearm = left_arm.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(0, 77).addBox(-1.875F, 0.25F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(2.0F, 9.0F, 0.0F));

		PartDefinition left_claws = left_forearm.addOrReplaceChild("left_claws", CubeListBuilder.create().texOffs(6, 88).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 88).addBox(-2.5F, -1.0F, 1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.375F, 6.75F, 0.0F));

		PartDefinition right_arm = upper_torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 63).addBox(-4.125F, -0.75F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 79).addBox(-4.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(62, 79).addBox(-4.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.125F, -5.75F, -2.0F));

		PartDefinition right_forearm = right_arm.addOrReplaceChild("right_forearm", CubeListBuilder.create().texOffs(0, 77).addBox(-2.125F, 0.25F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(-2.0F, 9.0F, 0.0F));

		PartDefinition right_claws = right_forearm.addOrReplaceChild("right_claws", CubeListBuilder.create().texOffs(56, 89).addBox(-2.5F, -1.0F, 1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(56, 89).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.375F, 6.75F, 0.0F));

		PartDefinition head = upper_torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 45).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 91).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -1.0F));

		PartDefinition cube_r18 = head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 16).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, -1.0F, 1.1364F, 1.4475F, 0.7835F));

		PartDefinition cube_r19 = head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(48, 58).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, -1.0F, -1.4835F, 1.4835F, -1.5708F));

		PartDefinition cube_r20 = head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(72, 27).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -9.0F, -5.0F, 1.5708F, 1.3963F, 2.0508F));

		PartDefinition cube_r21 = head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(56, 0).addBox(-5.0F, 0.0F, -4.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -5.75F, 1.0F, -0.6554F, 0.416F, -0.3877F));

		PartDefinition cube_r22 = head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(48, 52).addBox(-5.0F, 0.0F, -4.0F, 8.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -9.75F, 3.0F, -0.1298F, -0.017F, -0.3916F));

		PartDefinition cube_r23 = head.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(64, 64).addBox(-4.0F, 0.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.25F, -5.0F, -0.1728F, -0.1666F, -0.1925F));

		PartDefinition cube_r24 = head.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(72, 32).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.5F, -6.0F, 0.1442F, 0.197F, -0.1612F));

		PartDefinition cube_r25 = head.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(72, 22).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -6.0F, -0.2264F, 0.404F, -0.4027F));

		PartDefinition cube_r26 = head.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(56, 70).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -7.0F, -0.3873F, -0.0665F, -0.1615F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(40, 64).addBox(-3.5F, 0.0F, -6.5F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.25F))
		.texOffs(76, 52).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 38).addBox(-4.0F, 1.0F, -7.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition legs = hips.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -1.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 46).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-0.25F))
		.texOffs(24, 46).addBox(-3.25F, -2.75F, -2.65F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(3.0F, 1.0F, 0.0F));

		PartDefinition left_foot = left_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(24, 29).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-0.25F))
		.texOffs(48, 25).addBox(-2.75F, -2.75F, -2.65F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offset(-3.0F, 1.0F, 0.0F));

		PartDefinition right_foot = right_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 29).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 9.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			this.right_arm.xRot = -90F + Mth.sin(ageInTicks/10)/10;
			this.left_arm.xRot = -90F + Mth.cos(ageInTicks/10)/10;
			if (entity.swinging){
				float f = 0;
				f = f + 1F;
				this.right_arm.xRot = -89.5F + f;
				this.left_arm.xRot = -89.5F + f;

			}
		}else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.right_arm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.left_arm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		}else {
			this.right_arm.xRot = Mth.sin(ageInTicks/8)/10;
			this.left_arm.xRot = -Mth.sin(ageInTicks/8)/10;
		}

		this.left_leg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.right_leg.xRot = -this.left_leg.xRot;

		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Leaper.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}