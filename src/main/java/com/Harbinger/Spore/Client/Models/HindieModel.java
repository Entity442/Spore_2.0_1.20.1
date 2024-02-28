package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
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

public class HindieModel<T extends Hinderburg> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hindie"), "main");
	private final ModelPart Hindie;
	private final ModelPart LeftLip;
	private final ModelPart RightLip;
	private final ModelPart LeftNsplit;
	private final ModelPart LeftNsplit2;
	private final ModelPart LeftSsplit;
	private final ModelPart RightNsplit;
	private final ModelPart RightSsplit;
	private final ModelPart RightCannon;
	private final ModelPart RightTumor;
	private final ModelPart LeftCannon;
	private final ModelPart LeftTumor;
	private final ModelPart FrontTendril1;
	private final ModelPart FrontTendril2;
	private final ModelPart FrontTendril3;
	private final ModelPart FrontTendril4;
	private final ModelPart BackTendrils1;
	private final ModelPart BackTendrils2;
	private final ModelPart BackTendrils3;
	private final ModelPart BackTendrils4;
	private final ModelPart BackTendrils5;

	public HindieModel(ModelPart root) {
		this.Hindie = root.getChild("Hindie");
		this.LeftLip = this.Hindie.getChild("Center").getChild("CavnerousMaw").getChild("LeftLip");
		this.RightLip = this.Hindie.getChild("Center").getChild("CavnerousMaw").getChild("RightLip");
		this.LeftNsplit = this.LeftLip.getChild("NorthJawSplit");
		this.LeftNsplit2 = this.LeftNsplit.getChild("LNJSBase");
		this.LeftSsplit = this.LeftLip.getChild("SouthJawSplit");
		this.RightNsplit = this.RightLip.getChild("RightNorthJawSplit");
		this.RightSsplit = this.RightLip.getChild("RightSouthJawSplit");
		this.RightCannon = this.Hindie.getChild("Center").getChild("CenterTendrils").getChild("RightCannon");
		this.LeftCannon = this.Hindie.getChild("Center").getChild("CenterTendrils").getChild("LeftCannon");
		this.RightTumor = this.RightCannon.getChild("Tumors");
		this.LeftTumor = this.LeftCannon.getChild("LeftTumors");
		this.FrontTendril1 = this.Hindie.getChild("Center").getChild("Front1").getChild("Front1Bottom").getChild("Front1Tendrils").getChild("F1Tendril1");
		this.FrontTendril2 = this.Hindie.getChild("Center").getChild("Front1").getChild("Front1Bottom").getChild("Front1Tendrils").getChild("F1Tendril2");
		this.FrontTendril3 = this.Hindie.getChild("Center").getChild("Front1").getChild("Front1Bottom").getChild("Front1Tendrils").getChild("F1Tendril3");
		this.FrontTendril4 = this.Hindie.getChild("Center").getChild("Front1").getChild("Front2").getChild("Front2Bottom").getChild("Front2Tendrils").getChild("F2Tendril1");
		this.BackTendrils1 = this.Hindie.getChild("Center").getChild("Back1").getChild("Back1Bottom").getChild("B1Tendrils").getChild("B1Tendril1");
		this.BackTendrils2 = this.Hindie.getChild("Center").getChild("Back1").getChild("Back1Bottom").getChild("B1Tendrils").getChild("B1Tendril2");
		this.BackTendrils3 = this.Hindie.getChild("Center").getChild("Back1").getChild("Back1Bottom").getChild("B1Tendrils").getChild("B1Tendril3");
		this.BackTendrils4 = this.Hindie.getChild("Center").getChild("Back1").getChild("Back1Bottom").getChild("B1Tendrils").getChild("B1Tendril4");
		this.BackTendrils5 = this.Hindie.getChild("Center").getChild("Back1").getChild("Back1Bottom").getChild("B1Tendrils").getChild("B1Tendril4");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hindie = partdefinition.addOrReplaceChild("Hindie", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 0.0F));

		PartDefinition Center = Hindie.addOrReplaceChild("Center", CubeListBuilder.create().texOffs(0, 72).addBox(-35.0F, -146.4F, -34.988F, 70.0F, 2.0F, 70.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-35.0F, -75.4F, -34.988F, 70.0F, 2.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 101.4F, -0.012F));

		PartDefinition CenterUpperLeft_r1 = Center.addOrReplaceChild("CenterUpperLeft_r1", CubeListBuilder.create().texOffs(351, 327).addBox(9.5F, -26.0F, -35.0F, 2.0F, 52.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0488F, -118.1603F, 0.002F, 0.0F, 0.0F, -0.5236F));

		PartDefinition CenterBottomLeft_r1 = Center.addOrReplaceChild("CenterBottomLeft_r1", CubeListBuilder.create().texOffs(207, 327).addBox(9.5F, -26.0F, -35.0F, 2.0F, 52.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.0488F, -84.6397F, -0.008F, 0.0F, 0.0F, 0.5236F));

		PartDefinition CenterBottomRight_r1 = Center.addOrReplaceChild("CenterBottomRight_r1", CubeListBuilder.create().texOffs(0, 355).addBox(-11.5F, -26.0F, -35.0F, 2.0F, 52.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.0488F, -84.6397F, -0.008F, 0.0F, 0.0F, -0.5236F));

		PartDefinition CenterUpperRight_r1 = Center.addOrReplaceChild("CenterUpperRight_r1", CubeListBuilder.create().texOffs(387, 174).addBox(-11.5F, -26.0F, -35.0F, 2.0F, 52.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.0488F, -118.1603F, 0.002F, 0.0F, 0.0F, 0.5236F));

		PartDefinition CenterStretchedBodies = Center.addOrReplaceChild("CenterStretchedBodies", CubeListBuilder.create(), PartPose.offset(0.0F, -27.4F, 0.012F));

		PartDefinition CSBody1 = CenterStretchedBodies.addOrReplaceChild("CSBody1", CubeListBuilder.create(), PartPose.offsetAndRotation(-46.0F, -99.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Arm_r1 = CSBody1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(205, 356).addBox(0.9F, -3.0F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 9.0F, 0.8452F, -0.3326F, -0.3527F));

		PartDefinition Jaw_r1 = CSBody1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(199, 356).addBox(-4.1907F, -1.5483F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0941F, 0.3807F, 3.0F, -0.2153F, -0.1002F, -0.7812F));

		PartDefinition Head_r1 = CSBody1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -4.01F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition CSBody2 = CenterStretchedBodies.addOrReplaceChild("CSBody2", CubeListBuilder.create(), PartPose.offset(44.0F, -103.0F, 7.0F));

		PartDefinition Leg_r1 = CSBody2.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(187, 356).addBox(-3.854F, -0.458F, -2.1293F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8571F, 13.7032F, -0.1254F, -0.5232F, 0.0305F, -0.4064F));

		PartDefinition TorsoLower_r1 = CSBody2.addOrReplaceChild("TorsoLower_r1", CubeListBuilder.create().texOffs(204, 355).addBox(-2.5F, -3.0F, -3.5F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1283F, 11.6879F, 1.0631F, 0.0434F, -0.0131F, -0.482F));

		PartDefinition Torso_r1 = CSBody2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(196, 360).addBox(-2.5046F, -0.6122F, -0.8738F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8441F, 2.3163F, 4.0995F, 0.8191F, -0.1204F, -0.2635F));

		PartDefinition Torso_r2 = CSBody2.addOrReplaceChild("Torso_r2", CubeListBuilder.create().texOffs(201, 364).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5825F, 6.1692F, 0.0F, 0.2921F, -0.0905F, -0.2315F));

		PartDefinition Head_r2 = CSBody2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(388, 517).addBox(-1.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition CSBody3 = CenterStretchedBodies.addOrReplaceChild("CSBody3", CubeListBuilder.create().texOffs(198, 355).addBox(-2.0F, 0.0F, -1.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-51.0F, -89.0F, -17.0F, -0.6545F, 0.0F, 0.5236F));

		PartDefinition Arm_r2 = CSBody3.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(212, 350).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 9.0F, -0.3491F, -0.2182F, 0.0F));

		PartDefinition Jaw_r2 = CSBody3.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(202, 352).addBox(-4.1907F, -1.5483F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0941F, 0.3807F, 3.0F, -0.253F, -0.3616F, -0.1748F));

		PartDefinition Head_r3 = CSBody3.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -4.01F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 3.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition CSBody4 = CenterStretchedBodies.addOrReplaceChild("CSBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-42.0F, -43.0F, 17.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = CSBody4.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(191, 324).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 1.0F, -0.1851F, 0.0472F, -2.6513F));

		PartDefinition Tumor_r2 = CSBody4.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(191, 324).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6603F, 9.1783F, -0.7716F, -2.0152F, 0.3611F, -1.5404F));

		PartDefinition Tumor_r3 = CSBody4.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(190, 324).addBox(-2.5F, -3.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8775F, 10.4249F, 1.5F, -0.6109F, 0.8727F, -0.3927F));

		PartDefinition Tumor_r4 = CSBody4.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(191, 324).addBox(-1.0F, -0.9F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8357F, 4.841F, -2.3681F, -0.6596F, -0.1122F, -1.6555F));

		PartDefinition Torso_r3 = CSBody4.addOrReplaceChild("Torso_r3", CubeListBuilder.create().texOffs(198, 358).addBox(-2.0F, -4.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Jaw_r3 = CSBody4.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(193, 358).addBox(-6.0F, 3.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.349F, 0.0023F, -0.8874F));

		PartDefinition Head_r4 = CSBody4.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 326).addBox(-6.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.3491F));

		PartDefinition CSClump1 = CenterStretchedBodies.addOrReplaceChild("CSClump1", CubeListBuilder.create(), PartPose.offset(40.0F, -38.0F, 16.0F));

		PartDefinition Tumor4_r1 = CSClump1.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(192, 327).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4873F, 1.9233F, -4.6629F, -1.4318F, -0.9966F, -2.0102F));

		PartDefinition Tumor3_r1 = CSClump1.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(189, 324).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0743F, 0.7144F, 4.1897F, 1.0606F, -0.1356F, 2.2316F));

		PartDefinition Tumor2_r1 = CSClump1.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(190, 322).addBox(-1.5F, -2.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4814F, -4.8321F, 1.1149F, 2.024F, 0.6835F, 2.7597F));

		PartDefinition Tumor1_r1 = CSClump1.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(187, 322).addBox(-3.0F, -3.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.273F, 0.5512F, 0.4563F));

		PartDefinition CentralBlooms = Center.addOrReplaceChild("CentralBlooms", CubeListBuilder.create(), PartPose.offset(37.0F, -146.0F, 0.0F));

		PartDefinition FungalBloom1 = CentralBlooms.addOrReplaceChild("FungalBloom1", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1349F, -2.9342F, -0.4987F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Plane2_r1 = FungalBloom1.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom1.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom1.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom1.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom1.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom1.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition FungalBloom2 = CentralBlooms.addOrReplaceChild("FungalBloom2", CubeListBuilder.create(), PartPose.offsetAndRotation(-92.1349F, 27.0658F, 13.5013F, 0.0F, -0.5236F, -1.0036F));

		PartDefinition Plane3_r1 = FungalBloom2.addOrReplaceChild("Plane3_r1", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r2 = FungalBloom2.addOrReplaceChild("Plane2_r2", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r2 = FungalBloom2.addOrReplaceChild("Npetal_r2", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r2 = FungalBloom2.addOrReplaceChild("Spetal_r2", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r2 = FungalBloom2.addOrReplaceChild("Wpetal_r2", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r2 = FungalBloom2.addOrReplaceChild("Epetal_r2", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition CenterRidges = Center.addOrReplaceChild("CenterRidges", CubeListBuilder.create(), PartPose.offset(0.0F, -27.4F, 0.012F));

		PartDefinition LeftRidges = CenterRidges.addOrReplaceChild("LeftRidges", CubeListBuilder.create().texOffs(305, 0).addBox(9.5098F, 19.9333F, -65.01F, 5.0F, 8.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offset(49.4902F, -97.9433F, 30.01F));

		PartDefinition LeftBackBottomRidgeTip3_r1 = LeftRidges.addOrReplaceChild("LeftBackBottomRidgeTip3_r1", CubeListBuilder.create().texOffs(277, 69).addBox(-2.0F, 17.5F, -2.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(279, 70).addBox(-2.0F, 12.5F, 1.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(275, 68).addBox(-2.0F, 12.5F, -4.0F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(493, 569).addBox(-2.0F, -25.5F, -4.0F, 4.0F, 38.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(100, 175).addBox(-2.0F, -25.5F, -64.02F, 4.0F, 29.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 47.8865F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition LeftFrontBottomRidgeTip_r1 = LeftRidges.addOrReplaceChild("LeftFrontBottomRidgeTip_r1", CubeListBuilder.create().texOffs(0, 144).addBox(-2.7F, -4.6F, -3.99F, 3.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.183F, 54.1317F, -60.02F, 0.0F, 0.0F, 0.8727F));

		PartDefinition LeftBackTopRidge_r1 = LeftRidges.addOrReplaceChild("LeftBackTopRidge_r1", CubeListBuilder.create().texOffs(493, 568).addBox(-2.0F, -26.5F, -4.0F, 4.0F, 52.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition LeftFrontTopRidge_r1 = LeftRidges.addOrReplaceChild("LeftFrontTopRidge_r1", CubeListBuilder.create().texOffs(493, 568).addBox(-2.0F, -26.0F, -4.0F, 4.0F, 52.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.433F, -60.02F, 3.1416F, 0.0F, -0.5236F));

		PartDefinition RightRidges = CenterRidges.addOrReplaceChild("RightRidges", CubeListBuilder.create().texOffs(305, 0).addBox(-64.0F, -125.01F, -35.0F, 5.0F, 6.0F, 70.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 48.0F, 0.0F));

		PartDefinition RightFrontBottomRidge_r1 = RightRidges.addOrReplaceChild("RightFrontBottomRidge_r1", CubeListBuilder.create().texOffs(493, 568).addBox(-2.0F, -21.5F, -4.0F, 4.0F, 43.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-51.4902F, -101.5208F, -30.01F, 0.0F, 3.1416F, -0.5236F));

		PartDefinition RightBackBottomRidge_r1 = RightRidges.addOrReplaceChild("RightBackBottomRidge_r1", CubeListBuilder.create().texOffs(423, 174).addBox(-2.0F, -25.5F, -5.0F, 4.0F, 51.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-49.4902F, -98.0567F, 30.01F, 0.0F, 0.0F, -0.5236F));

		PartDefinition RightBackTopRidge_r1 = RightRidges.addOrReplaceChild("RightBackTopRidge_r1", CubeListBuilder.create().texOffs(493, 568).addBox(-2.0F, -26.5F, -4.0F, 4.0F, 52.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(166, 571).addBox(-2.0F, -26.5F, -63.02F, 4.0F, 52.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-49.4902F, -145.9433F, 30.01F, 0.0F, 0.0F, 0.5236F));

		PartDefinition TopRidge = CenterRidges.addOrReplaceChild("TopRidge", CubeListBuilder.create().texOffs(65, 327).addBox(10.0F, -3.25F, 19.0F, 2.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(68, 327).addBox(14.0F, -2.25F, 19.0F, 2.0F, 3.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(416, 455).addBox(-38.0F, -2.0F, -7.0F, 35.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -119.75F, -27.0F));

		PartDefinition Ridge_r1 = TopRidge.addOrReplaceChild("Ridge_r1", CubeListBuilder.create().texOffs(416, 455).addBox(-17.5F, -1.5F, -4.0F, 35.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -0.5F, 57.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Ridge_r2 = TopRidge.addOrReplaceChild("Ridge_r2", CubeListBuilder.create().texOffs(416, 455).addBox(-17.5F, -1.5F, -4.0F, 35.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, -0.5F, -3.0F, 3.1416F, 3.1416F, 0.0F));

		PartDefinition Ridge_r3 = TopRidge.addOrReplaceChild("Ridge_r3", CubeListBuilder.create().texOffs(416, 455).addBox(-17.5F, -1.5F, -4.0F, 35.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, -0.5F, 57.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Ridge1_r1 = TopRidge.addOrReplaceChild("Ridge1_r1", CubeListBuilder.create().texOffs(62, 327).addBox(-4.0F, -2.5F, -10.0F, 8.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge2_r1 = TopRidge.addOrReplaceChild("Ridge2_r1", CubeListBuilder.create().texOffs(65, 327).addBox(-3.0F, -2.01F, 0.0F, 5.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.25F, 8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Ridge3_r1 = TopRidge.addOrReplaceChild("Ridge3_r1", CubeListBuilder.create().texOffs(62, 327).addBox(-3.0F, -1.5F, -10.0F, 6.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0711F, -0.76F, 15.0711F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Ridge6_r1 = TopRidge.addOrReplaceChild("Ridge6_r1", CubeListBuilder.create().texOffs(62, 327).addBox(-7.25F, -2.49F, -8.5F, 6.0F, 4.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(83, 272).addBox(-5.25F, -1.49F, 11.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(85, 279).addBox(-7.25F, -0.49F, 11.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(85, 348).addBox(-6.25F, 0.51F, 14.5F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0711F, -0.76F, 30.0711F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Ridge7_r1 = TopRidge.addOrReplaceChild("Ridge7_r1", CubeListBuilder.create().texOffs(66, 327).addBox(0.0F, -2.01F, -16.0F, 5.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.25F, 46.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Ridge8_r1 = TopRidge.addOrReplaceChild("Ridge8_r1", CubeListBuilder.create().texOffs(67, 332).addBox(-4.0F, -2.5F, -5.0F, 8.0F, 5.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 54.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge9_r1 = TopRidge.addOrReplaceChild("Ridge9_r1", CubeListBuilder.create().texOffs(57, 322).addBox(-1.5F, 0.0F, 1.5F, 3.0F, 2.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0104F, -1.26F, 43.5251F, 0.0F, -2.0944F, 0.0F));

		PartDefinition TopRidgeCorpses = TopRidge.addOrReplaceChild("TopRidgeCorpses", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TRBody1 = TopRidgeCorpses.addOrReplaceChild("TRBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 21.0F));

		PartDefinition ARm_r3 = TRBody1.addOrReplaceChild("ARm_r3", CubeListBuilder.create().texOffs(195, 364).addBox(-5.2135F, -2.2711F, -0.4016F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8074F, -0.2672F, -2.1288F, 0.6452F, -0.8362F, -0.37F));

		PartDefinition Leg_r2 = TRBody1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(193, 359).addBox(-1.7544F, -0.4431F, -0.1505F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 5.5F, -0.5248F, 0.3467F, -0.0564F));

		PartDefinition Torso_r4 = TRBody1.addOrReplaceChild("Torso_r4", CubeListBuilder.create().texOffs(204, 359).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.438F, -0.2672F, 1.5251F, -0.0873F, -0.3054F, 0.0F));

		PartDefinition Jaw_r4 = TRBody1.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(203, 355).addBox(-4.9779F, -7.6106F, -1.5159F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.171F, 1.7756F, -1.6348F, -0.8727F, -0.6545F, 0.0F));

		PartDefinition Head_r5 = TRBody1.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(180, 350).addBox(-4.0F, -8.0F, -3.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5331F, 0.0F, -5.0163F, -0.5672F, -0.6545F, 0.0F));

		PartDefinition CenterTumorDetails = Center.addOrReplaceChild("CenterTumorDetails", CubeListBuilder.create(), PartPose.offset(0.0F, -101.4F, 0.012F));

		PartDefinition CT1 = CenterTumorDetails.addOrReplaceChild("CT1", CubeListBuilder.create().texOffs(187, 323).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -45.0F, 13.0F, 0.829F, -0.5236F, -0.5236F));

		PartDefinition CT2 = CenterTumorDetails.addOrReplaceChild("CT2", CubeListBuilder.create().texOffs(192, 322).addBox(-2.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.6F, -44.9F, 5.0F, -0.6544F, -0.2176F, 0.4366F));

		PartDefinition CT3 = CenterTumorDetails.addOrReplaceChild("CT3", CubeListBuilder.create().texOffs(187, 320).addBox(-3.0F, -4.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -44.9F, -15.0F, 0.1205F, -0.6721F, -0.6353F));

		PartDefinition CT4 = CenterTumorDetails.addOrReplaceChild("CT4", CubeListBuilder.create().texOffs(190, 321).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, -44.9F, 23.0F, 0.186F, -0.4709F, 0.4486F));

		PartDefinition CTClump1 = CenterTumorDetails.addOrReplaceChild("CTClump1", CubeListBuilder.create(), PartPose.offset(48.0F, -21.0F, -22.0F));

		PartDefinition CTC1T3_r1 = CTClump1.addOrReplaceChild("CTC1T3_r1", CubeListBuilder.create().texOffs(186, 321).addBox(-3.0F, -3.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1834F, -1.9261F, -0.0802F, 2.8353F, 0.1281F, -1.0073F));

		PartDefinition CTC1T2_r1 = CTClump1.addOrReplaceChild("CTC1T2_r1", CubeListBuilder.create().texOffs(190, 323).addBox(-3.5F, -3.5F, -2.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4038F, -0.6815F, 3.5075F, 1.5109F, -0.2759F, -0.5872F));

		PartDefinition CTC1T1_r1 = CTClump1.addOrReplaceChild("CTC1T1_r1", CubeListBuilder.create().texOffs(187, 321).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4038F, 1.0185F, -0.0925F, 0.4894F, -0.1913F, 0.0354F));

		PartDefinition CavnerousMaw = Center.addOrReplaceChild("CavnerousMaw", CubeListBuilder.create(), PartPose.offset(0.0F, -27.4F, 0.012F));

		PartDefinition LeftLip = CavnerousMaw.addOrReplaceChild("LeftLip", CubeListBuilder.create().texOffs(332, 449).addBox(-8.0F, -4.5F, -29.0F, 13.0F, 10.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.85F, -34.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition NorthJawSplit = LeftLip.addOrReplaceChild("NorthJawSplit", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, 15.5F, -19.0F, -0.0153F, -0.1296F, -0.1296F));

		PartDefinition Tooth_r1 = NorthJawSplit.addOrReplaceChild("Tooth_r1", CubeListBuilder.create().texOffs(18, 38).addBox(0.0F, -3.5F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6955F, -6.4624F, 11.3837F, -0.1293F, 0.1176F, 0.3414F));

		PartDefinition Tooth_r2 = NorthJawSplit.addOrReplaceChild("Tooth_r2", CubeListBuilder.create().texOffs(0, 62).addBox(-5.5F, 0.0F, -2.0F, 11.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2728F, -5.2451F, -10.6221F, 0.2199F, -0.0018F, -0.3041F));

		PartDefinition Tooth_r3 = NorthJawSplit.addOrReplaceChild("Tooth_r3", CubeListBuilder.create().texOffs(18, 42).addBox(0.0F, -4.0F, -1.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.9317F, 11.3837F, -0.0436F, 0.0F, -0.3927F));

		PartDefinition Tooth_r4 = NorthJawSplit.addOrReplaceChild("Tooth_r4", CubeListBuilder.create().texOffs(44, 0).addBox(-2.0F, 0.0F, -6.0F, 3.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -4.9317F, 8.3837F, 1.8387F, -0.2106F, -0.0573F));

		PartDefinition Tooth_r5 = NorthJawSplit.addOrReplaceChild("Tooth_r5", CubeListBuilder.create().texOffs(38, 0).addBox(-1.0F, 0.0F, -8.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -6.8296F, -1.2941F, 2.3521F, -0.286F, -0.2729F));

		PartDefinition Tooth_r6 = NorthJawSplit.addOrReplaceChild("Tooth_r6", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, 0.0F, -8.0F, 3.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -3.9319F, -0.5176F, 0.2559F, -0.056F, 0.211F));

		PartDefinition LeftMuncherNorthSegment_r1 = NorthJawSplit.addOrReplaceChild("LeftMuncherNorthSegment_r1", CubeListBuilder.create().texOffs(305, 0).addBox(-5.49F, -7.0F, -12.0F, 12.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 2.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LNJSBase = NorthJawSplit.addOrReplaceChild("LNJSBase", CubeListBuilder.create().texOffs(281, 327).addBox(-5.0F, -11.0F, -10.0F, 9.0F, 21.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.5F, 2.0F));

		PartDefinition Tooth_r7 = LNJSBase.addOrReplaceChild("Tooth_r7", CubeListBuilder.create().texOffs(18, 41).addBox(0.0F, -5.5F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 5.0F, 1.0F, -0.2387F, 0.1699F, 0.1369F));

		PartDefinition Tooth_r8 = LNJSBase.addOrReplaceChild("Tooth_r8", CubeListBuilder.create().texOffs(32, 0).addBox(-1.5F, 0.0F, -8.0F, 4.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7944F, 4.0139F, -1.6854F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Tooth_r9 = LNJSBase.addOrReplaceChild("Tooth_r9", CubeListBuilder.create().texOffs(18, 45).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.0F, -7.0F, 0.2295F, -0.2457F, -0.0914F));

		PartDefinition Tumor_r5 = LNJSBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(599, 408).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, 0.0F, -0.3693F, 0.3214F, 0.2498F));

		PartDefinition Split_r1 = LNJSBase.addOrReplaceChild("Split_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-1.0F, -2.0F, -0.5F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -10.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LNJSSeg2 = LNJSBase.addOrReplaceChild("LNJSSeg2", CubeListBuilder.create().texOffs(141, 180).addBox(-1.5F, -1.5F, -7.0F, 6.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 9.5F, -2.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Tooth_r10 = LNJSSeg2.addOrReplaceChild("Tooth_r10", CubeListBuilder.create().texOffs(18, 42).addBox(-0.75F, -4.0F, -3.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.0F, 0.0F, -0.3957F, 0.1209F, -0.0503F));

		PartDefinition Tumor_r6 = LNJSSeg2.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(29, 580).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 8.0F, 0.5044F, 0.8582F, 0.4779F));

		PartDefinition tumor_r7 = LNJSSeg2.addOrReplaceChild("tumor_r7", CubeListBuilder.create().texOffs(601, 410).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5114F, 6.6607F, -3.7673F, 0.4119F, -0.3491F, 0.0419F));

		PartDefinition LNJS2S1 = LNJSSeg2.addOrReplaceChild("LNJS2S1", CubeListBuilder.create().texOffs(100, 144).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 13.25F, -4.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition LNJS2S1Base_r1 = LNJS2S1.addOrReplaceChild("LNJS2S1Base_r1", CubeListBuilder.create().texOffs(18, 53).addBox(-0.5F, -3.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 3.25F, 0.5F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LNJS2S1Seg2 = LNJS2S1.addOrReplaceChild("LNJS2S1Seg2", CubeListBuilder.create(), PartPose.offset(0.0F, 7.5F, 1.0F));

		PartDefinition LNJS2S1Seg2_r1 = LNJS2S1Seg2.addOrReplaceChild("LNJS2S1Seg2_r1", CubeListBuilder.create().texOffs(258, 366).addBox(-1.5F, -0.5F, -3.0F, 3.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.1745F, 0.0F, 0.5236F));

		PartDefinition LNJS2S2 = LNJSSeg2.addOrReplaceChild("LNJS2S2", CubeListBuilder.create().texOffs(167, 180).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 49).addBox(-1.0F, 6.75F, -0.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.75F, 13.25F, 3.5F, 0.211F, -0.056F, 0.2559F));

		PartDefinition SouthJawSplit = LeftLip.addOrReplaceChild("SouthJawSplit", CubeListBuilder.create().texOffs(385, 0).addBox(-6.5F, -10.5F, -14.0F, 11.0F, 11.0F, 25.0F, new CubeDeformation(0.0F))
		.texOffs(21, 40).addBox(-7.5F, -9.0F, -4.0F, 1.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 17.0F));

		PartDefinition Tooth_r11 = SouthJawSplit.addOrReplaceChild("Tooth_r11", CubeListBuilder.create().texOffs(47, 19).addBox(-1.25F, 0.0F, -8.5F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -4.0F, -0.5F, 0.3414F, 0.0741F, -0.2054F));

		PartDefinition Tooth_r12 = SouthJawSplit.addOrReplaceChild("Tooth_r12", CubeListBuilder.create().texOffs(56, 0).addBox(-2.0F, -4.5F, 0.0F, 3.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, -4.5F, -10.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Tooth_r13 = SouthJawSplit.addOrReplaceChild("Tooth_r13", CubeListBuilder.create().texOffs(18, 51).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, -3.0F, 3.0F, -0.354F, -0.1639F, 0.0602F));

		PartDefinition LSJSBase = SouthJawSplit.addOrReplaceChild("LSJSBase", CubeListBuilder.create().texOffs(112, 571).addBox(-4.0F, -1.0F, -10.0F, 8.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tooth_r14 = LSJSBase.addOrReplaceChild("Tooth_r14", CubeListBuilder.create().texOffs(38, 0).addBox(-2.0F, 0.0F, -7.5F, 3.0F, 0.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 4.0F, -0.5F, 0.3381F, 0.0886F, -0.2467F));

		PartDefinition LSJSSeg2 = LSJSBase.addOrReplaceChild("LSJSSeg2", CubeListBuilder.create().texOffs(41, 144).addBox(-3.0F, 0.0F, -7.0F, 6.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LSJSCorseDetails = LSJSSeg2.addOrReplaceChild("LSJSCorseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition Tumor_r8 = LSJSCorseDetails.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(599, 408).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 7.0F, -0.2391F, -0.5194F, 0.4565F));

		PartDefinition Body1 = LSJSCorseDetails.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Torso_r5 = Body1.addOrReplaceChild("Torso_r5", CubeListBuilder.create().texOffs(536, 0).addBox(0.0F, -2.0F, -3.99F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Arm_r4 = Body1.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(76, 609).addBox(-2.0F, 0.0963F, -1.5307F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.6263F, 4.9587F, 0.1888F, -0.2241F, -0.2567F));

		PartDefinition Arm_r5 = Body1.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(76, 609).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Jaw_r5 = Body1.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(273, 45).addBox(0.0F, -0.25F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.25F, 0.0F, 0.0F, 0.3054F, -0.0436F));

		PartDefinition Head_r6 = Body1.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(482, 86).addBox(-7.0F, -0.25F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.25F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body2 = LSJSCorseDetails.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(536, 14).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 477).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg_r3 = Body2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(221, 450).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Leg_r4 = Body2.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(221, 450).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Arm_r6 = Body2.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(315, 327).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r6 = Body2.addOrReplaceChild("Jaw_r6", CubeListBuilder.create().texOffs(483, 34).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1358F, -0.206F, 0.6251F));

		PartDefinition Head_r7 = Body2.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(585, 513).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition RightLip = CavnerousMaw.addOrReplaceChild("RightLip", CubeListBuilder.create().texOffs(332, 449).addBox(-5.0F, -4.5F, -29.0F, 13.0F, 10.0F, 58.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, -34.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition RightNorthJawSplit = RightLip.addOrReplaceChild("RightNorthJawSplit", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 13.5F, -14.0F, -0.0153F, 0.1296F, 0.1296F));

		PartDefinition Tumor_r9 = RightNorthJawSplit.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(570, 288).addBox(-0.25F, -1.0F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 14.0F, 0.5813F, 0.4001F, 0.5813F));

		PartDefinition HTOOT_r1 = RightNorthJawSplit.addOrReplaceChild("HTOOT_r1", CubeListBuilder.create().texOffs(6, 46).addBox(-1.25F, 0.0F, -7.0F, 2.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -3.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition RightMuncherNorthSegment_r1 = RightNorthJawSplit.addOrReplaceChild("RightMuncherNorthSegment_r1", CubeListBuilder.create().texOffs(345, 327).addBox(-7.01F, -7.0F, -7.0F, 12.0F, 12.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RNJSBase1 = RightNorthJawSplit.addOrReplaceChild("RNJSBase1", CubeListBuilder.create().texOffs(207, 144).addBox(-2.0F, -5.0F, -10.0F, 7.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 2.5F, 2.0F));

		PartDefinition Tumor_r10 = RNJSBase1.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(570, 288).addBox(-2.25F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -3.0F, 0.4461F, -0.4802F, 0.1316F));

		PartDefinition Teeth_r1 = RNJSBase1.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(20, 53).addBox(0.0F, -3.75F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, -11.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Teeth_r2 = RNJSBase1.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(20, 46).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.0F, -11.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Teeth_r3 = RNJSBase1.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(18, 48).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.3054F, -5.0304F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Teeth_r4 = RNJSBase1.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(18, 40).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.8264F, -7.9848F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Teeth_r5 = RNJSBase1.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(20, 48).addBox(0.0F, -5.0F, 0.0F, 2.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 3.0F, -7.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RNJS1Seg1 = RNJSBase1.addOrReplaceChild("RNJS1Seg1", CubeListBuilder.create().texOffs(293, 174).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 10.0F, -6.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Tooth_r15 = RNJS1Seg1.addOrReplaceChild("Tooth_r15", CubeListBuilder.create().texOffs(20, 48).addBox(-1.25F, -1.35F, 0.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 0.0F, -0.653F, 0.1289F, 0.0229F));

		PartDefinition Tooth_r16 = RNJS1Seg1.addOrReplaceChild("Tooth_r16", CubeListBuilder.create().texOffs(20, 51).addBox(-1.25F, -5.25F, 1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 0.0F, 0.176F, 0.1289F, 0.0229F));

		PartDefinition Tooth_r17 = RNJS1Seg1.addOrReplaceChild("Tooth_r17", CubeListBuilder.create().texOffs(65, 26).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.0F, 0.0436F, -0.3054F));

		PartDefinition RNJSBase2 = RightNorthJawSplit.addOrReplaceChild("RNJSBase2", CubeListBuilder.create(), PartPose.offset(-2.25F, 2.0F, 5.5F));

		PartDefinition RNJSBase2_r1 = RNJSBase2.addOrReplaceChild("RNJSBase2_r1", CubeListBuilder.create().texOffs(35, 115).addBox(-2.75F, -4.5F, -4.5F, 8.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition RNJSBase2CorpseDetails = RNJSBase2.addOrReplaceChild("RNJSBase2CorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition MouthTumor_r1 = RNJSBase2CorpseDetails.addOrReplaceChild("MouthTumor_r1", CubeListBuilder.create().texOffs(585, 528).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, 2.0F, 0.6318F, 0.5194F, 0.4565F));

		PartDefinition MouthTumor_r2 = RNJSBase2CorpseDetails.addOrReplaceChild("MouthTumor_r2", CubeListBuilder.create().texOffs(586, 529).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.3265F, 2.5F, -1.6272F, -0.706F, -0.3922F, -0.1043F));

		PartDefinition MouthTumor_r3 = RNJSBase2CorpseDetails.addOrReplaceChild("MouthTumor_r3", CubeListBuilder.create().texOffs(587, 529).addBox(-1.0F, -1.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition Jaw_r7 = RNJSBase2CorpseDetails.addOrReplaceChild("Jaw_r7", CubeListBuilder.create().texOffs(245, 45).addBox(-1.0F, -3.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.228F, 0.1298F, 0.6257F));

		PartDefinition hEAD_r8 = RNJSBase2CorpseDetails.addOrReplaceChild("hEAD_r8", CubeListBuilder.create().texOffs(0, 355).addBox(0.0F, -3.0F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition RightSouthJawSplit = RightLip.addOrReplaceChild("RightSouthJawSplit", CubeListBuilder.create(), PartPose.offset(0.0F, 15.0F, 17.0F));

		PartDefinition Tooth_r18 = RightSouthJawSplit.addOrReplaceChild("Tooth_r18", CubeListBuilder.create().texOffs(20, 40).addBox(0.0F, -6.5F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3684F, -3.0891F, -14.5F, -0.043F, 0.0076F, -0.7856F));

		PartDefinition Tooth_r19 = RightSouthJawSplit.addOrReplaceChild("Tooth_r19", CubeListBuilder.create().texOffs(18, 43).addBox(0.0F, -5.0F, -1.0F, 0.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5736F, -4.9575F, 11.75F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Tumor_r11 = RightSouthJawSplit.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(570, 288).addBox(-2.4566F, -1.7025F, -2.5153F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 12.0F, -0.5236F, -0.6545F, -0.6545F));

		PartDefinition Tooth_r20 = RightSouthJawSplit.addOrReplaceChild("Tooth_r20", CubeListBuilder.create().texOffs(0, 40).addBox(-1.25F, 0.0F, -10.0F, 2.0F, 0.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.25F, -4.0F, 0.0F, 0.22F, 0.1278F, 0.0285F));

		PartDefinition RightMuncherSouthSegment_r1 = RightSouthJawSplit.addOrReplaceChild("RightMuncherSouthSegment_r1", CubeListBuilder.create().texOffs(198, 189).addBox(-6.0F, -6.0F, -14.0F, 11.0F, 11.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 0.0F, 0.0057F, 0.0869F, 0.1313F));

		PartDefinition RSJSBase = RightSouthJawSplit.addOrReplaceChild("RSJSBase", CubeListBuilder.create().texOffs(541, 568).addBox(-4.0F, -4.0F, -10.0F, 8.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition LeTumor_r1 = RSJSBase.addOrReplaceChild("LeTumor_r1", CubeListBuilder.create().texOffs(570, 288).addBox(-2.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 10.0F, 0.4674F, 0.3542F, 0.8278F));

		PartDefinition Tooth_r21 = RSJSBase.addOrReplaceChild("Tooth_r21", CubeListBuilder.create().texOffs(46, 19).addBox(-1.5F, 0.0F, -9.0F, 3.0F, 0.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 1.0F, 0.0F, 0.1719F, -0.0302F, 0.1719F));

		PartDefinition BloodyDetail = RSJSBase.addOrReplaceChild("BloodyDetail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeBon_r1 = BloodyDetail.addOrReplaceChild("LeBon_r1", CubeListBuilder.create().texOffs(48, 310).addBox(-0.5F, -1.0F, -8.0F, 1.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3945F, 12.3794F, 2.3254F, -1.0472F, 0.0F, 0.5236F));

		PartDefinition Giblet_r1 = BloodyDetail.addOrReplaceChild("Giblet_r1", CubeListBuilder.create().texOffs(78, 180).addBox(-0.5071F, 0.2367F, -0.0321F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2524F, 8.6692F, -6.0F, 0.2183F, 0.0076F, 0.5666F));

		PartDefinition Giblet_r2 = BloodyDetail.addOrReplaceChild("Giblet_r2", CubeListBuilder.create().texOffs(124, 195).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2524F, 8.6692F, -6.0F, -0.1744F, 0.0076F, 0.5666F));

		PartDefinition Clump_r1 = BloodyDetail.addOrReplaceChild("Clump_r1", CubeListBuilder.create().texOffs(275, 27).addBox(-2.6681F, -2.5362F, -1.4841F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2878F, 6.1812F, -0.4317F, 0.6243F, -0.1561F, -0.3045F));

		PartDefinition Clump_r2 = BloodyDetail.addOrReplaceChild("Clump_r2", CubeListBuilder.create().texOffs(316, 120).addBox(-2.0F, -2.5F, -4.0F, 4.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4566F, 6.5F, 0.831F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition Clump_r3 = BloodyDetail.addOrReplaceChild("Clump_r3", CubeListBuilder.create().texOffs(595, 406).addBox(-4.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, -6.0F, -0.1745F, 0.48F, 0.3054F));

		PartDefinition BloodPlane_r1 = BloodyDetail.addOrReplaceChild("BloodPlane_r1", CubeListBuilder.create().texOffs(32, 21).addBox(0.0F, -2.0F, -10.0F, 0.0F, 17.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition FrontLip = CavnerousMaw.addOrReplaceChild("FrontLip", CubeListBuilder.create().texOffs(521, 154).addBox(-19.0F, -5.0F, -13.4F, 38.0F, 10.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.0F, -26.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition FrontTeeth = FrontLip.addOrReplaceChild("FrontTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ToothPlane_r1 = FrontTeeth.addOrReplaceChild("ToothPlane_r1", CubeListBuilder.create().texOffs(377, 237).addBox(-9.4F, -2.5F, -3.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9112F, 4.772F, -3.2992F, -3.0929F, 1.0894F, -3.0141F));

		PartDefinition ToothPlane_r2 = FrontTeeth.addOrReplaceChild("ToothPlane_r2", CubeListBuilder.create().texOffs(210, 72).addBox(-12.0F, -2.5F, 0.0F, 24.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2614F, 4.7606F, -6.2279F, -0.0226F, 0.0446F, 0.0833F));

		PartDefinition ToothPlane_r3 = FrontTeeth.addOrReplaceChild("ToothPlane_r3", CubeListBuilder.create().texOffs(238, 171).addBox(-12.0F, -2.5F, -5.0F, 24.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3703F, 7.5F, -0.4056F, 0.0F, 0.3491F, 0.0F));

		PartDefinition ToothPlane_r4 = FrontTeeth.addOrReplaceChild("ToothPlane_r4", CubeListBuilder.create().texOffs(210, 72).addBox(-20.0F, 0.0F, 0.0F, 24.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 5.0F, 2.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition BackLip = CavnerousMaw.addOrReplaceChild("BackLip", CubeListBuilder.create().texOffs(386, 86).addBox(-19.0F, -5.0F, -6.6F, 38.0F, 10.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.0F, 26.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition BackTeeth = BackLip.addOrReplaceChild("BackTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ToothPlane_r5 = BackTeeth.addOrReplaceChild("ToothPlane_r5", CubeListBuilder.create().texOffs(239, 171).addBox(-8.3F, -1.5F, 0.0F, 20.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.8396F, 4.5439F, 2.4435F, 0.0276F, -0.6116F, 0.0685F));

		PartDefinition ToothPlane_r6 = BackTeeth.addOrReplaceChild("ToothPlane_r6", CubeListBuilder.create().texOffs(141, 175).addBox(-9.4F, -2.5F, 0.0F, 34.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2614F, 4.7606F, 6.2279F, 0.0226F, -0.0446F, 0.0833F));

		PartDefinition ToothPlane_r7 = BackTeeth.addOrReplaceChild("ToothPlane_r7", CubeListBuilder.create().texOffs(374, 237).addBox(-14.8F, -2.5F, -2.6F, 24.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6602F, 7.5F, 5.1041F, 0.0F, 0.2618F, 0.0F));

		PartDefinition ToothPlane_r8 = BackTeeth.addOrReplaceChild("ToothPlane_r8", CubeListBuilder.create().texOffs(210, 72).addBox(-12.0F, -2.5F, 0.0F, 24.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3703F, 7.5F, 0.4056F, 0.0F, -0.3054F, 0.0F));

		PartDefinition MawHoleFillers = CavnerousMaw.addOrReplaceChild("MawHoleFillers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FrontFiller = MawHoleFillers.addOrReplaceChild("FrontFiller", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, -32.0F));

		PartDefinition FFLeft = FrontFiller.addOrReplaceChild("FFLeft", CubeListBuilder.create(), PartPose.offset(25.0F, 0.0F, 0.0F));

		PartDefinition Tumor2_r2 = FFLeft.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(141, 307).addBox(-3.0F, -4.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8979F, -1.4214F, -0.799F, 0.1047F, -0.576F, 0.6109F));

		PartDefinition Tumor1_r2 = FFLeft.addOrReplaceChild("Tumor1_r2", CubeListBuilder.create().texOffs(140, 306).addBox(0.0F, -3.0F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.0F, 0.0F, -0.829F, 0.0F, 0.6109F));

		PartDefinition FFRight = FrontFiller.addOrReplaceChild("FFRight", CubeListBuilder.create(), PartPose.offset(-25.0F, -1.0F, 0.0F));

		PartDefinition Tumor3_r2 = FFRight.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(143, 309).mirror().addBox(-3.5F, -5.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5849F, 2.0447F, 0.662F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tumor2_r3 = FFRight.addOrReplaceChild("Tumor2_r3", CubeListBuilder.create().texOffs(141, 307).mirror().addBox(-4.0F, -4.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-5.8979F, -1.4214F, -0.799F, 0.1047F, 0.576F, -0.6109F));

		PartDefinition Tumor1_r3 = FFRight.addOrReplaceChild("Tumor1_r3", CubeListBuilder.create().texOffs(140, 306).mirror().addBox(-8.0F, -3.0F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)).mirror(false), PartPose.offsetAndRotation(4.0F, -5.0F, 0.0F, -0.829F, 0.0F, -0.6109F));

		PartDefinition BackFiller = MawHoleFillers.addOrReplaceChild("BackFiller", CubeListBuilder.create(), PartPose.offset(0.0F, -30.0F, 32.0F));

		PartDefinition BFLeft = BackFiller.addOrReplaceChild("BFLeft", CubeListBuilder.create(), PartPose.offset(-25.0F, 0.0F, 0.0F));

		PartDefinition Tumor2_r4 = BFLeft.addOrReplaceChild("Tumor2_r4", CubeListBuilder.create().texOffs(141, 307).mirror().addBox(-4.0F, -4.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.8979F, -1.4214F, 0.799F, -0.1047F, -0.576F, -0.6109F));

		PartDefinition Tumor1_r4 = BFLeft.addOrReplaceChild("Tumor1_r4", CubeListBuilder.create().texOffs(140, 306).mirror().addBox(-8.0F, -3.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -5.0F, 0.0F, 0.829F, 0.0F, -0.6109F));

		PartDefinition BFRight = BackFiller.addOrReplaceChild("BFRight", CubeListBuilder.create(), PartPose.offset(25.0F, -1.0F, 0.0F));

		PartDefinition Tumor3_r3 = BFRight.addOrReplaceChild("Tumor3_r3", CubeListBuilder.create().texOffs(143, 309).addBox(-1.5F, -5.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5849F, 2.0447F, -0.662F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tumor2_r5 = BFRight.addOrReplaceChild("Tumor2_r5", CubeListBuilder.create().texOffs(141, 307).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.8979F, -1.4214F, 0.799F, -0.1047F, 0.576F, 0.6109F));

		PartDefinition Tumor1_r5 = BFRight.addOrReplaceChild("Tumor1_r5", CubeListBuilder.create().texOffs(140, 306).addBox(0.0F, -3.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-4.0F, -5.0F, 0.0F, 0.829F, 0.0F, 0.6109F));

		PartDefinition CenterTendrils = Center.addOrReplaceChild("CenterTendrils", CubeListBuilder.create(), PartPose.offset(-46.0F, -74.4F, 0.012F));

		PartDefinition RightCannon = CenterTendrils.addOrReplaceChild("RightCannon", CubeListBuilder.create(), PartPose.offset(3.0F, -5.5F, 0.0F));

		PartDefinition Tumors = RightCannon.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RCannonTumor1 = Tumors.addOrReplaceChild("RCannonTumor1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RCannonTumor1_r1 = RCannonTumor1.addOrReplaceChild("RCannonTumor1_r1", CubeListBuilder.create().texOffs(139, 305).addBox(-8.0F, -8.0F, -1.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 3.0F, -0.7109F, -0.2332F, -0.2622F));

		PartDefinition RCannonTumor2 = Tumors.addOrReplaceChild("RCannonTumor2", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, -11.0F));

		PartDefinition RCannonTumor2_r1 = RCannonTumor2.addOrReplaceChild("RCannonTumor2_r1", CubeListBuilder.create().texOffs(138, 304).addBox(-5.5F, -5.5F, -4.5F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.486F, 3.8223F, 10.9937F, 0.7734F, -0.4549F, 0.4229F));

		PartDefinition RCannonTumor3 = Tumors.addOrReplaceChild("RCannonTumor3", CubeListBuilder.create(), PartPose.offset(7.0F, 7.0F, -5.0F));

		PartDefinition RCannonTumor3_r1 = RCannonTumor3.addOrReplaceChild("RCannonTumor3_r1", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1088F, 0.4917F, 11.2817F, 0.6109F, 0.0F, -0.7854F));

		PartDefinition RCannonTumor4 = Tumors.addOrReplaceChild("RCannonTumor4", CubeListBuilder.create(), PartPose.offset(0.8912F, 11.4917F, 3.2817F));

		PartDefinition RCannonTumor4_r1 = RCannonTumor4.addOrReplaceChild("RCannonTumor4_r1", CubeListBuilder.create().texOffs(144, 310).addBox(-1.5F, -1.5F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.6F, 0.0F, 1.1188F, -0.3172F, 0.3665F));

		PartDefinition RCannonTumor5 = Tumors.addOrReplaceChild("RCannonTumor5", CubeListBuilder.create(), PartPose.offset(6.5535F, 4.0F, -17.7387F));

		PartDefinition RCannonTumor5_r1 = RCannonTumor5.addOrReplaceChild("RCannonTumor5_r1", CubeListBuilder.create().texOffs(139, 305).addBox(-6.5F, -3.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.486F, -0.1777F, 6.9937F, 0.4229F, -0.2368F, 0.1128F));

		PartDefinition RCannonTumor6 = Tumors.addOrReplaceChild("RCannonTumor6", CubeListBuilder.create(), PartPose.offset(1.445F, 13.4917F, -4.512F));

		PartDefinition RCannonTumor6_r1 = RCannonTumor6.addOrReplaceChild("RCannonTumor6_r1", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1392F, -0.346F, -0.7379F));

		PartDefinition RCannonTumor7 = Tumors.addOrReplaceChild("RCannonTumor7", CubeListBuilder.create(), PartPose.offset(1.445F, 9.4917F, -11.512F));

		PartDefinition RCannonTumor7_r1 = RCannonTumor7.addOrReplaceChild("RCannonTumor7_r1", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2393F, -0.4703F, 0.4939F));

		PartDefinition RCannonTumor8 = Tumors.addOrReplaceChild("RCannonTumor8", CubeListBuilder.create().texOffs(139, 305).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.555F, -1.5083F, -11.512F, -0.4235F, 0.233F, -0.0939F));

		PartDefinition RightCannonBase = RightCannon.addOrReplaceChild("RightCannonBase", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.5F, -8.0F, 16.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6109F, 0.0F, 0.829F));

		PartDefinition LaTumoral_r1 = RightCannonBase.addOrReplaceChild("LaTumoral_r1", CubeListBuilder.create().texOffs(146, 311).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 22.5F, -6.5F, 0.251F, 0.5918F, -0.251F));

		PartDefinition LaTumoral_r2 = RightCannonBase.addOrReplaceChild("LaTumoral_r2", CubeListBuilder.create().texOffs(145, 310).addBox(-4.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -6.0F, -0.3289F, -0.3736F, -0.5306F));

		PartDefinition RightCannonSegment1 = RightCannonBase.addOrReplaceChild("RightCannonSegment1", CubeListBuilder.create().texOffs(461, 174).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition CannonTip = RightCannonSegment1.addOrReplaceChild("CannonTip", CubeListBuilder.create().texOffs(12, 16).addBox(-5.0F, 28.5F, -5.0F, 2.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 16).addBox(3.0F, 28.5F, -5.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(12, 16).addBox(-3.0F, 28.5F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition CannonTipRightSegment_r1 = CannonTip.addOrReplaceChild("CannonTipRightSegment_r1", CubeListBuilder.create().texOffs(12, 16).addBox(-3.0F, -4.5F, -1.0F, 6.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 33.0F, -4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition TopHeadDetail = CannonTip.addOrReplaceChild("TopHeadDetail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r7 = TopHeadDetail.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(473, 186).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2407F, 29.2022F, -4.9739F, -0.1794F, -0.4537F, 0.1175F));

		PartDefinition Head_r9 = TopHeadDetail.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(270, 587).addBox(-6.5F, -2.0F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 33.0F, 0.0F, 0.0F, 0.3491F, 0.2618F));

		PartDefinition CannonTumorClog = CannonTip.addOrReplaceChild("CannonTumorClog", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r12 = CannonTumorClog.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(148, 311).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6131F, 30.7441F, 1.4727F, -0.9887F, 0.0368F, 0.8498F));

		PartDefinition Tumor_r13 = CannonTumorClog.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(148, 311).addBox(-3.0F, -3.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.0F, 0.0F, -0.3956F, -0.7493F, 0.7682F));

		PartDefinition RCS1BodyConnector = RightCannonSegment1.addOrReplaceChild("RCS1BodyConnector", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Jaw_r8 = RCS1BodyConnector.addOrReplaceChild("Jaw_r8", CubeListBuilder.create().texOffs(584, 296).addBox(-4.0F, -0.5F, -1.5F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5142F, -4.5342F, 8.4093F, -0.3477F, 0.2192F, -0.008F));

		PartDefinition Head_r10 = RCS1BodyConnector.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(583, 293).addBox(-4.0F, -3.5F, -1.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 8.5F, -3.1184F, -0.2166F, 3.0077F));

		PartDefinition TorsoTop_r1 = RCS1BodyConnector.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(16, 4).addBox(-3.5F, -2.5F, -1.5F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3423F, -1.728F, 7.48F, -0.2148F, -0.005F, 0.3107F));

		PartDefinition Torso_r6 = RCS1BodyConnector.addOrReplaceChild("Torso_r6", CubeListBuilder.create().texOffs(33, 21).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 8.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition SmallExaust = RightCannonBase.addOrReplaceChild("SmallExaust", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.9151F, 14.607F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Tumor_r14 = SmallExaust.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(152, 314).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 6.0F, 1.0F, 1.0908F, -0.4363F, 0.0F));

		PartDefinition Tumor_r15 = SmallExaust.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(150, 314).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.5F, -2.5F, -3.0543F, 0.4014F, 0.3665F));

		PartDefinition Tumor_r16 = SmallExaust.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(150, 314).addBox(-1.5F, -1.0F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition TipBottom_r1 = SmallExaust.addOrReplaceChild("TipBottom_r1", CubeListBuilder.create().texOffs(0, 178).addBox(-7.0F, 1.0F, -1.0F, 7.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 178).addBox(-5.0F, -2.0F, -1.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(239, 176).addBox(-7.0F, -2.0F, -2.0F, 7.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(239, 176).addBox(-6.0F, -2.0F, 1.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(113, 571).addBox(0.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0849F, 1.393F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition LeftCannon = CenterTendrils.addOrReplaceChild("LeftCannon", CubeListBuilder.create(), PartPose.offset(94.0F, -15.5F, 13.0F));

		PartDefinition LeftTumors = LeftCannon.addOrReplaceChild("LeftTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LCannonTumor1 = LeftTumors.addOrReplaceChild("LCannonTumor1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition LCannonTumor1_r1 = LCannonTumor1.addOrReplaceChild("LCannonTumor1_r1", CubeListBuilder.create().texOffs(139, 305).addBox(-4.5F, -4.5F, -6.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.486F, 1.8223F, 6.9937F, -0.4234F, -0.0624F, -0.4234F));

		PartDefinition LCannonTumor2 = LeftTumors.addOrReplaceChild("LCannonTumor2", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, -21.0F));

		PartDefinition LCannonTumor2_r1 = LCannonTumor2.addOrReplaceChild("LCannonTumor2_r1", CubeListBuilder.create().texOffs(142, 308).addBox(-0.5F, -2.5F, -3.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.486F, 5.8223F, 10.9937F, 0.7734F, 0.4549F, -0.4229F));

		PartDefinition LCannonTumor3 = LeftTumors.addOrReplaceChild("LCannonTumor3", CubeListBuilder.create(), PartPose.offset(-7.0F, 7.0F, -5.0F));

		PartDefinition LCannonTumor3_r1 = LCannonTumor3.addOrReplaceChild("LCannonTumor3_r1", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1088F, 0.4917F, 11.2817F, 0.6109F, 0.0F, 0.7854F));

		PartDefinition LCannonTumor4 = LeftTumors.addOrReplaceChild("LCannonTumor4", CubeListBuilder.create(), PartPose.offset(-0.8912F, 11.4917F, 3.2817F));

		PartDefinition LCannonTumor4_r1 = LCannonTumor4.addOrReplaceChild("LCannonTumor4_r1", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0623F, 0.3645F, -2.3222F, 1.7369F, 0.9411F, -0.3994F));

		PartDefinition LCannonTumor5 = LeftTumors.addOrReplaceChild("LCannonTumor5", CubeListBuilder.create().texOffs(139, 305).addBox(1.986F, -4.6777F, 2.4937F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 4.0F, -22.0F));

		PartDefinition LCannonTumor6 = LeftTumors.addOrReplaceChild("LCannonTumor6", CubeListBuilder.create(), PartPose.offset(-0.8912F, 13.4917F, -8.7183F));

		PartDefinition LCannonTumor6_r1 = LCannonTumor6.addOrReplaceChild("LCannonTumor6_r1", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1392F, 0.346F, 0.7379F));

		PartDefinition LeftCannonBase = LeftCannon.addOrReplaceChild("LeftCannonBase", CubeListBuilder.create().texOffs(0, 72).addBox(-3.5763F, -9.5412F, -7.8676F, 15.0F, 28.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, -0.6109F, 0.0F, -0.829F));

		PartDefinition WeeLilExausts = LeftCannonBase.addOrReplaceChild("WeeLilExausts", CubeListBuilder.create().texOffs(170, 517).addBox(-1.0F, 11.0F, 6.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offset(4.4237F, -0.0412F, 0.1324F));

		PartDefinition Tumor_r17 = WeeLilExausts.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(172, 522).addBox(-1.0F, -1.5F, -0.75F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 14.75F, 7.0F, 0.0F, -0.3491F, 0.6109F));

		PartDefinition Tumor_r18 = WeeLilExausts.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(145, 311).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 15.25F, 7.5F, 0.6346F, -0.678F, -0.3017F));

		PartDefinition Tube4_r1 = WeeLilExausts.addOrReplaceChild("Tube4_r1", CubeListBuilder.create().texOffs(174, 519).addBox(-2.75F, -1.5F, -1.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(3.5F, 12.5F, 6.5F, -0.4291F, 0.4029F, 0.287F));

		PartDefinition Tube3_r1 = WeeLilExausts.addOrReplaceChild("Tube3_r1", CubeListBuilder.create().texOffs(176, 520).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.5F, 12.5F, 7.0F, 0.1122F, -0.4677F, -0.2449F));

		PartDefinition Tube2_r1 = WeeLilExausts.addOrReplaceChild("Tube2_r1", CubeListBuilder.create().texOffs(174, 519).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, 9.5F, 6.5F, 0.4369F, 0.4407F, 0.1966F));

		PartDefinition LeftCannonSegment1 = LeftCannonBase.addOrReplaceChild("LeftCannonSegment1", CubeListBuilder.create().texOffs(293, 138).addBox(-6.0F, -1.5F, -6.0F, 12.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4237F, 17.9588F, 0.1324F));

		PartDefinition LeftCannonTip = LeftCannonSegment1.addOrReplaceChild("LeftCannonTip", CubeListBuilder.create().texOffs(397, 365).addBox(3.0F, 28.5F, -5.0F, 2.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(397, 365).addBox(-5.0F, 28.5F, -5.0F, 2.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(405, 373).addBox(-3.0F, 28.5F, 3.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(405, 373).addBox(-3.0F, 28.5F, -5.0F, 6.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition LeftCannonTumorClog = LeftCannonTip.addOrReplaceChild("LeftCannonTumorClog", CubeListBuilder.create(), PartPose.offset(0.7F, -2.0F, 0.0F));

		PartDefinition Tumor_r19 = LeftCannonTumorClog.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1169F, 31.2808F, 1.0082F, -1.8542F, -0.5001F, -1.1931F));

		PartDefinition LCannonSeg1CorpseDetail = LeftCannonSegment1.addOrReplaceChild("LCannonSeg1CorpseDetail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Torso_r7 = LCannonSeg1CorpseDetail.addOrReplaceChild("Torso_r7", CubeListBuilder.create().texOffs(19, 84).addBox(-3.5F, -2.0F, -2.5F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6796F, 0.393F, 7.0688F, -0.5123F, 0.3994F, -0.1867F));

		PartDefinition Jaw_r9 = LCannonSeg1CorpseDetail.addOrReplaceChild("Jaw_r9", CubeListBuilder.create().texOffs(578, 288).addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1752F, 3.7482F, 6.185F, 0.3166F, -0.3504F, 2.7748F));

		PartDefinition Head_r11 = LCannonSeg1CorpseDetail.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(578, 288).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9053F, 7.6543F, 4.7968F, -2.5656F, -0.8727F, 2.7925F));

		PartDefinition Front1 = Center.addOrReplaceChild("Front1", CubeListBuilder.create(), PartPose.offset(0.0F, -101.4F, -36.488F));

		PartDefinition Front1Right = Front1.addOrReplaceChild("Front1Right", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, 36.5F));

		PartDefinition Ridge_r4 = Front1Right.addOrReplaceChild("Ridge_r4", CubeListBuilder.create().texOffs(281, 327).addBox(-2.0F, -4.0F, -49.0F, 7.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-60.0F, -74.0F, -35.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Front1LowerRight = Front1Right.addOrReplaceChild("Front1LowerRight", CubeListBuilder.create(), PartPose.offset(-35.8347F, -60.4048F, -56.01F));

		PartDefinition Front1LowerRightSeg2_r1 = Front1LowerRight.addOrReplaceChild("Front1LowerRightSeg2_r1", CubeListBuilder.create().texOffs(536, 0).addBox(-9.0F, -20.5F, -2.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(110, 482).addBox(-9.0F, -15.5F, -25.0F, 5.0F, 39.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, -0.5236F));

		PartDefinition Front1UpperRight = Front1Right.addOrReplaceChild("Front1UpperRight", CubeListBuilder.create(), PartPose.offset(-35.8347F, -87.5952F, -56.01F));

		PartDefinition Front2LowerRightSeg2_r1 = Front1UpperRight.addOrReplaceChild("Front2LowerRightSeg2_r1", CubeListBuilder.create().texOffs(531, 251).addBox(-9.0F, 15.5F, -2.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(0, 477).addBox(-9.0F, -23.5F, -25.0F, 5.0F, 39.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition Front1Left = Front1.addOrReplaceChild("Front1Left", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, 36.5F));

		PartDefinition Ridge_r5 = Front1Left.addOrReplaceChild("Ridge_r5", CubeListBuilder.create().texOffs(283, 327).addBox(-5.0F, -4.0F, -49.0F, 6.0F, 8.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(60.0F, -74.0F, -35.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Front1LowerLeft = Front1Left.addOrReplaceChild("Front1LowerLeft", CubeListBuilder.create(), PartPose.offset(35.8347F, -60.4048F, -56.01F));

		PartDefinition Front1LowerLeftSeg2_r1 = Front1LowerLeft.addOrReplaceChild("Front1LowerLeftSeg2_r1", CubeListBuilder.create().texOffs(357, 517).addBox(7.0F, -20.5F, -2.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(424, 467).addBox(4.0F, -15.5F, -25.0F, 5.0F, 39.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F));

		PartDefinition FungalBloom7 = Front1LowerLeft.addOrReplaceChild("FungalBloom7", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0304F, 1.8706F, 2.4993F, 0.3478F, -0.0298F, 2.0019F));

		PartDefinition Plane2_r3 = FungalBloom7.addOrReplaceChild("Plane2_r3", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r2 = FungalBloom7.addOrReplaceChild("Plane1_r2", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r3 = FungalBloom7.addOrReplaceChild("Npetal_r3", CubeListBuilder.create().texOffs(616, 0).addBox(-15.6867F, -1.0689F, -18.9788F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r3 = FungalBloom7.addOrReplaceChild("Spetal_r3", CubeListBuilder.create().texOffs(616, 16).addBox(-15.3362F, 0.0691F, 1.7494F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Wpetal_r3 = FungalBloom7.addOrReplaceChild("Wpetal_r3", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r3 = FungalBloom7.addOrReplaceChild("Epetal_r3", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Front1UpperLeft = Front1Left.addOrReplaceChild("Front1UpperLeft", CubeListBuilder.create(), PartPose.offset(34.8347F, -86.5952F, -56.01F));

		PartDefinition Front1UpperLeftSeg2_r1 = Front1UpperLeft.addOrReplaceChild("Front1UpperLeftSeg2_r1", CubeListBuilder.create().texOffs(0, 566).addBox(8.0F, 15.5F, -2.0F, 1.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(461, 154).addBox(4.0F, -23.5F, -25.0F, 5.0F, 39.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F));

		PartDefinition Front1Top = Front1.addOrReplaceChild("Front1Top", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, -33.5F));

		PartDefinition Front1TopMiddle_r1 = Front1Top.addOrReplaceChild("Front1TopMiddle_r1", CubeListBuilder.create().texOffs(192, 449).addBox(-27.0F, -1.0F, -21.5F, 54.0F, 2.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -112.0F, 12.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RidgeSeg4_r1 = Front1Top.addOrReplaceChild("RidgeSeg4_r1", CubeListBuilder.create().texOffs(74, 339).addBox(-4.0F, -3.5F, -9.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(563, 257).addBox(-4.0F, -2.5F, -1.0F, 3.0F, 4.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(563, 257).addBox(1.0F, -3.5F, -1.0F, 3.0F, 5.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(71, 336).addBox(-3.99F, -3.5F, 25.0F, 8.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -111.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Front1TopRight = Front1Top.addOrReplaceChild("Front1TopRight", CubeListBuilder.create(), PartPose.offset(-30.5977F, -110.1936F, 22.3015F));

		PartDefinition Front1TopRightSeg4_r1 = Front1TopRight.addOrReplaceChild("Front1TopRightSeg4_r1", CubeListBuilder.create().texOffs(74, 401).addBox(2.5F, -3.25F, -19.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(449, 296).addBox(-3.5F, -3.25F, 6.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(400, 556).addBox(-1.5F, -3.25F, -8.5F, 6.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2095F, 0.1582F, -0.6378F));

		PartDefinition Front1TopRightSeg1_r1 = Front1TopRight.addOrReplaceChild("Front1TopRightSeg1_r1", CubeListBuilder.create().texOffs(0, 265).addBox(-29.0F, -1.0F, -13.5F, 2.0F, 8.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.5977F, -1.8064F, -9.8015F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Front1TopLeft = Front1Top.addOrReplaceChild("Front1TopLeft", CubeListBuilder.create(), PartPose.offset(30.5977F, -110.1936F, 22.3015F));

		PartDefinition Front1TopLeftSeg4_r1 = Front1TopLeft.addOrReplaceChild("Front1TopLeftSeg4_r1", CubeListBuilder.create().texOffs(74, 401).addBox(-4.5F, -3.25F, -19.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(449, 296).addBox(1.5F, -3.25F, 6.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(400, 556).addBox(-4.5F, -3.25F, -8.5F, 6.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2095F, -0.1582F, 0.6378F));

		PartDefinition Front1TopLeftSeg1_r1 = Front1TopLeft.addOrReplaceChild("Front1TopLeftSeg1_r1", CubeListBuilder.create().texOffs(0, 265).addBox(27.0F, -1.0F, -13.5F, 2.0F, 8.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.5977F, -1.8064F, -9.8015F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TumorFlowerTop = Front1Top.addOrReplaceChild("TumorFlowerTop", CubeListBuilder.create().texOffs(140, 306).addBox(1.0F, -3.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -115.0F, 26.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TumorBase = TumorFlowerTop.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(5.0F, -1.0F, 0.0F));

		PartDefinition Tumor_r20 = TumorBase.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -0.5F, -4.5F, 0.189F, 0.3463F, 0.5131F));

		PartDefinition Tumor_r21 = TumorBase.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(142, 308).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -7.0F, -0.5113F, 0.2171F, -0.5714F));

		PartDefinition Tumor_r22 = TumorBase.addOrReplaceChild("Tumor_r22", CubeListBuilder.create().texOffs(139, 305).addBox(-3.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -0.5F, -5.5F, -0.4363F, -0.5672F, 0.0F));

		PartDefinition Tumor_r23 = TumorBase.addOrReplaceChild("Tumor_r23", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -0.5F, 5.5F, -0.6545F, 0.3491F, 0.0F));

		PartDefinition Tumor_r24 = TumorBase.addOrReplaceChild("Tumor_r24", CubeListBuilder.create().texOffs(140, 306).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 6.0F, -0.5236F, 0.0F, -0.3927F));

		PartDefinition SouthTendril = TumorBase.addOrReplaceChild("SouthTendril", CubeListBuilder.create(), PartPose.offset(0.5F, -0.5F, 2.0F));

		PartDefinition STendieSeg1_r1 = SouthTendril.addOrReplaceChild("STendieSeg1_r1", CubeListBuilder.create().texOffs(186, 319).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		PartDefinition STendieSeg2 = SouthTendril.addOrReplaceChild("STendieSeg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition STendieSeg2_r1 = STendieSeg2.addOrReplaceChild("STendieSeg2_r1", CubeListBuilder.create().texOffs(190, 320).addBox(-1.6946F, -1.6529F, -0.9886F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8802F, -1.453F, 6.6629F, 0.371F, 0.3788F, 0.0798F));

		PartDefinition WestTendril = TumorBase.addOrReplaceChild("WestTendril", CubeListBuilder.create().texOffs(191, 326).addBox(-1.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5F, -2.0F, 2.0F, 0.0F, 0.0873F, -0.1745F));

		PartDefinition WTendieSeg2 = WestTendril.addOrReplaceChild("WTendieSeg2", CubeListBuilder.create().texOffs(194, 325).addBox(-0.05F, -0.5F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -0.5F, 0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition EastTendril = TumorBase.addOrReplaceChild("EastTendril", CubeListBuilder.create().texOffs(192, 327).addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, -0.5F, 0.0097F, 0.218F, 0.0447F));

		PartDefinition ETendieSeg2 = EastTendril.addOrReplaceChild("ETendieSeg2", CubeListBuilder.create(), PartPose.offset(-7.0F, -1.0F, 0.0F));

		PartDefinition ETendieSeg2_r1 = ETendieSeg2.addOrReplaceChild("ETendieSeg2_r1", CubeListBuilder.create().texOffs(192, 327).addBox(-4.75F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Maw = TumorFlowerTop.addOrReplaceChild("Maw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SouthMaw = Maw.addOrReplaceChild("SouthMaw", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.8061F, -0.7458F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.25F, 3.5F, -0.8262F, -0.1527F, 0.0374F));

		PartDefinition Tooth_r22 = SouthMaw.addOrReplaceChild("Tooth_r22", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.5F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Tooth_r23 = SouthMaw.addOrReplaceChild("Tooth_r23", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition SMawSeg2 = SouthMaw.addOrReplaceChild("SMawSeg2", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.0736F, 0.8192F, 9.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -7.4256F, -0.7373F, -0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r24 = SMawSeg2.addOrReplaceChild("Tooth_r24", CubeListBuilder.create().texOffs(117, 142).addBox(4.25F, -2.0F, -3.25F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, -0.3054F, -0.1309F));

		PartDefinition Tooth_r25 = SMawSeg2.addOrReplaceChild("Tooth_r25", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.0F, -2.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, 0.3054F, 0.1309F));

		PartDefinition SMawSeg3 = SMawSeg2.addOrReplaceChild("SMawSeg3", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -4.5F, -1.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.5F, -4.5736F, 1.8192F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r26 = SMawSeg3.addOrReplaceChild("Tooth_r26", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.25F, -0.75F, -0.2182F, -0.3491F, -0.2182F));

		PartDefinition Tooth_r27 = SMawSeg3.addOrReplaceChild("Tooth_r27", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.25F, -0.75F, 0.0F, -0.2182F, 0.2182F));

		PartDefinition NWMaw = Maw.addOrReplaceChild("NWMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, -2.0F, 0.6109F, -0.9163F, 0.0F));

		PartDefinition Tooth_r28 = NWMaw.addOrReplaceChild("Tooth_r28", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition NWMawSeg1_r1 = NWMaw.addOrReplaceChild("NWMawSeg1_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -3.5F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NWMawSeg2 = NWMaw.addOrReplaceChild("NWMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tooth_r29 = NWMawSeg2.addOrReplaceChild("Tooth_r29", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7208F, -2.8231F, 0.794F, 0.0F, -0.1745F, 0.3927F));

		PartDefinition Tooth_r30 = NWMawSeg2.addOrReplaceChild("Tooth_r30", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2792F, -3.3231F, 1.794F, 0.0535F, -0.2825F, -0.8119F));

		PartDefinition NWMawSeg2_r1 = NWMawSeg2.addOrReplaceChild("NWMawSeg2_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMaw = Maw.addOrReplaceChild("NSMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.8727F, 1.1345F, 0.0F));

		PartDefinition Tooth_r31 = NSMaw.addOrReplaceChild("Tooth_r31", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 1.0F, 0.0475F, -0.346F, -0.1392F));

		PartDefinition Tooth_r32 = NSMaw.addOrReplaceChild("Tooth_r32", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition NSMawSeg1_r1 = NSMaw.addOrReplaceChild("NSMawSeg1_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-4.0F, -3.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg2 = NSMaw.addOrReplaceChild("NSMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -7.4768F, -1.1485F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Tooth_r33 = NSMawSeg2.addOrReplaceChild("Tooth_r33", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition NSMawSeg2_r1 = NSMawSeg2.addOrReplaceChild("NSMawSeg2_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg3 = NSMawSeg2.addOrReplaceChild("NSMawSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -2.25F, 0.25F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r34 = NSMawSeg3.addOrReplaceChild("Tooth_r34", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.2182F));

		PartDefinition Tooth_r35 = NSMawSeg3.addOrReplaceChild("Tooth_r35", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition NSMawSeg3_r1 = NSMawSeg3.addOrReplaceChild("NSMawSeg3_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -0.1015F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Front1Bottom = Front1.addOrReplaceChild("Front1Bottom", CubeListBuilder.create(), PartPose.offset(0.0F, -74.0F, -33.5F));

		PartDefinition RidgeSeg3_r1 = Front1Bottom.addOrReplaceChild("RidgeSeg3_r1", CubeListBuilder.create().texOffs(454, 116).addBox(-0.2199F, -3.343F, -2.7695F, 5.0F, 5.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6691F, 115.943F, 17.1352F, -0.0853F, 0.778F, -0.1284F));

		PartDefinition RidgeSeg2_r1 = Front1Bottom.addOrReplaceChild("RidgeSeg2_r1", CubeListBuilder.create().texOffs(459, 121).addBox(-2.7801F, -2.143F, -0.7695F, 5.0F, 5.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6691F, 115.943F, 17.1352F, 0.0204F, -0.4299F, 0.0963F));

		PartDefinition RidgeSeg1_r1 = Front1Bottom.addOrReplaceChild("RidgeSeg1_r1", CubeListBuilder.create().texOffs(4, 193).addBox(-3.99F, -90.5F, -33.0F, 8.0F, 5.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 203.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Front1BottomMiddle_r1 = Front1Bottom.addOrReplaceChild("Front1BottomMiddle_r1", CubeListBuilder.create().texOffs(425, 296).addBox(-27.0F, -9.0F, -21.51F, 54.0F, 10.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 112.0F, 12.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition FungalBloom5 = Front1Bottom.addOrReplaceChild("FungalBloom5", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.1349F, 113.4658F, 1.4893F, 0.4184F, 0.3708F, -2.9656F));

		PartDefinition Plane2_r4 = FungalBloom5.addOrReplaceChild("Plane2_r4", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r3 = FungalBloom5.addOrReplaceChild("Plane1_r3", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r4 = FungalBloom5.addOrReplaceChild("Npetal_r4", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -18.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r4 = FungalBloom5.addOrReplaceChild("Spetal_r4", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r4 = FungalBloom5.addOrReplaceChild("Wpetal_r4", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.5F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r4 = FungalBloom5.addOrReplaceChild("Epetal_r4", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Front1BottomRight = Front1Bottom.addOrReplaceChild("Front1BottomRight", CubeListBuilder.create(), PartPose.offset(-30.5977F, 110.1936F, 22.3015F));

		PartDefinition Front1BottomRightSeg5_r1 = Front1BottomRight.addOrReplaceChild("Front1BottomRightSeg5_r1", CubeListBuilder.create().texOffs(0, 390).addBox(2.5F, -4.75F, -19.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(184, 393).addBox(-3.5F, -4.75F, 6.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(550, 513).addBox(-1.5F, -4.75F, -8.5015F, 6.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2095F, 0.1582F, 0.6378F));

		PartDefinition FrontBottomRightSeg2_r1 = Front1BottomRight.addOrReplaceChild("FrontBottomRightSeg2_r1", CubeListBuilder.create().texOffs(100, 175).addBox(-29.0F, -7.0F, -13.5F, 2.0F, 8.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.5977F, 1.8064F, -9.8015F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Front1BottomLeft = Front1Bottom.addOrReplaceChild("Front1BottomLeft", CubeListBuilder.create(), PartPose.offset(30.5977F, 110.1936F, 22.3015F));

		PartDefinition Front1BottomLeftSeg5_r1 = Front1BottomLeft.addOrReplaceChild("Front1BottomLeftSeg5_r1", CubeListBuilder.create().texOffs(0, 390).addBox(-4.5F, -4.75F, -19.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(184, 393).addBox(1.5F, -4.75F, 6.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(550, 513).addBox(-4.5F, -4.75F, -8.5015F, 6.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2095F, -0.1582F, -0.6378F));

		PartDefinition FrontBottomLeftSeg2_r1 = Front1BottomLeft.addOrReplaceChild("FrontBottomLeftSeg2_r1", CubeListBuilder.create().texOffs(100, 175).addBox(27.0F, -7.0F, -13.5F, 2.0F, 8.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.5977F, 1.8064F, -9.8015F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Front1Tendrils = Front1Bottom.addOrReplaceChild("Front1Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition F1Tendril1 = Front1Tendrils.addOrReplaceChild("F1Tendril1", CubeListBuilder.create().texOffs(257, 4).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.5F, 113.0F, 19.5F));

		PartDefinition Tumor3_r4 = F1Tendril1.addOrReplaceChild("Tumor3_r4", CubeListBuilder.create().texOffs(155, 312).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1651F, 2.3916F, 1.0289F, -0.4842F, -0.6882F, -1.0092F));

		PartDefinition Tumor2_r6 = F1Tendril1.addOrReplaceChild("Tumor2_r6", CubeListBuilder.create().texOffs(153, 309).addBox(-3.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.5F, 1.75F, -0.7418F, 0.0F, -0.7418F));

		PartDefinition Tumor1_r6 = F1Tendril1.addOrReplaceChild("Tumor1_r6", CubeListBuilder.create().texOffs(142, 308).addBox(-3.0F, -3.0F, -2.75F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.1286F, 0.833F, -0.2992F));

		PartDefinition F1Tendril1Seg2 = F1Tendril1.addOrReplaceChild("F1Tendril1Seg2", CubeListBuilder.create().texOffs(6, 192).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition F1Tendril1Seg3 = F1Tendril1Seg2.addOrReplaceChild("F1Tendril1Seg3", CubeListBuilder.create().texOffs(351, 329).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition F1Tendril2 = Front1Tendrils.addOrReplaceChild("F1Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, 110.0F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tendril2Seg1_r1 = F1Tendril2.addOrReplaceChild("Tendril2Seg1_r1", CubeListBuilder.create().texOffs(255, 2).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition F1Tendril2Seg2 = F1Tendril2.addOrReplaceChild("F1Tendril2Seg2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril2Seg2_r1 = F1Tendril2Seg2.addOrReplaceChild("Tendril2Seg2_r1", CubeListBuilder.create().texOffs(4, 191).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 2.7925F, 0.0F, 3.1416F));

		PartDefinition F1Tendril2Seg3 = F1Tendril2Seg2.addOrReplaceChild("F1Tendril2Seg3", CubeListBuilder.create(), PartPose.offset(0.0F, 22.216F, 4.4463F));

		PartDefinition Tendril2Seg3_r1 = F1Tendril2Seg3.addOrReplaceChild("Tendril2Seg3_r1", CubeListBuilder.create().texOffs(349, 329).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.8035F, -0.0886F, 2.8949F));

		PartDefinition F1Tendril2Seg4 = F1Tendril2Seg3.addOrReplaceChild("F1Tendril2Seg4", CubeListBuilder.create(), PartPose.offset(1.6823F, 5.8999F, 2.1474F));

		PartDefinition Tendril2Seg4_r1 = F1Tendril2Seg4.addOrReplaceChild("Tendril2Seg4_r1", CubeListBuilder.create().texOffs(1, 1).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9223F, 1.1434F, 1.1542F));

		PartDefinition F1Tendril3 = Front1Tendrils.addOrReplaceChild("F1Tendril3", CubeListBuilder.create().texOffs(251, 0).addBox(-5.0F, -3.5F, -5.0F, 10.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 114.5F, 20.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition F1Tendril3Seg2 = F1Tendril3.addOrReplaceChild("F1Tendril3Seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Arm_r8 = F1Tendril3Seg2.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(151, 199).addBox(-5.0F, -2.0F, -1.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6047F, 4.7721F, -6.0F, -0.3735F, -0.8582F, 1.0015F));

		PartDefinition Arm_r9 = F1Tendril3Seg2.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(144, 197).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3953F, 3.7721F, -6.0F, -0.1634F, 0.5457F, -0.3076F));

		PartDefinition Jaw_r10 = F1Tendril3Seg2.addOrReplaceChild("Jaw_r10", CubeListBuilder.create().texOffs(578, 288).addBox(-4.0F, -1.0F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, -2.0F, 0.7819F, -0.0603F, -3.0253F));

		PartDefinition Head_r12 = F1Tendril3Seg2.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(578, 288).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tendril3Seg2_r1 = F1Tendril3Seg2.addOrReplaceChild("Tendril3Seg2_r1", CubeListBuilder.create().texOffs(0, 189).addBox(-4.0F, -1.5F, -4.0F, 8.0F, 17.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition F1Tendril3Seg3 = F1Tendril3Seg2.addOrReplaceChild("F1Tendril3Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.6047F, 13.7721F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Tendril3Seg3_r1 = F1Tendril3Seg3.addOrReplaceChild("Tendril3Seg3_r1", CubeListBuilder.create().texOffs(345, 327).addBox(-3.0F, -1.5F, -3.0F, 6.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition F1Tendril3Seg4 = F1Tendril3Seg3.addOrReplaceChild("F1Tendril3Seg4", CubeListBuilder.create(), PartPose.offset(1.0023F, 11.4562F, 0.0F));

		PartDefinition Tendril4Seg4_r1 = F1Tendril3Seg4.addOrReplaceChild("Tendril4Seg4_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Front2 = Front1.addOrReplaceChild("Front2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -39.5F));

		PartDefinition Front1Right2 = Front2.addOrReplaceChild("Front1Right2", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.8224F, -1.0F, -27.1734F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Ridge_r6 = Front1Right2.addOrReplaceChild("Ridge_r6", CubeListBuilder.create().texOffs(531, 196).addBox(-2.0F, -4.01F, -41.0F, 6.0F, 8.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1776F, 0.0F, 22.9234F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Front1LowerRight2 = Front1Right2.addOrReplaceChild("Front1LowerRight2", CubeListBuilder.create(), PartPose.offset(16.9877F, 13.5952F, 1.9134F));

		PartDefinition Front1LowerRightSeg5_r1 = Front1LowerRight2.addOrReplaceChild("Front1LowerRightSeg5_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -23.5F, 26.0F, 2.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
		.texOffs(160, 420).addBox(-9.0F, -20.5F, -3.0F, 2.0F, 5.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(310, 517).addBox(-9.0F, -15.5F, -17.0F, 2.0F, 32.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, -0.5236F));

		PartDefinition Front1UpperRight2 = Front1Right2.addOrReplaceChild("Front1UpperRight2", CubeListBuilder.create(), PartPose.offset(16.9877F, -13.5952F, 1.9134F));

		PartDefinition Front2LowerRightSeg5_r1 = Front1UpperRight2.addOrReplaceChild("Front2LowerRightSeg5_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 22.5F, 26.0F, 2.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 355).addBox(-9.0F, 15.5F, -3.0F, 2.0F, 5.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(483, 0).addBox(-9.0F, -16.5F, -17.0F, 5.0F, 32.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition FungalBloom4 = Front1UpperRight2.addOrReplaceChild("FungalBloom4", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.5501F, -6.189F, 1.7493F, 0.217F, -0.254F, -1.0422F));

		PartDefinition Plane2_r5 = FungalBloom4.addOrReplaceChild("Plane2_r5", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r4 = FungalBloom4.addOrReplaceChild("Plane1_r4", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r5 = FungalBloom4.addOrReplaceChild("Npetal_r5", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r5 = FungalBloom4.addOrReplaceChild("Spetal_r5", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r5 = FungalBloom4.addOrReplaceChild("Wpetal_r5", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r5 = FungalBloom4.addOrReplaceChild("Epetal_r5", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Front1Left3 = Front2.addOrReplaceChild("Front1Left3", CubeListBuilder.create(), PartPose.offsetAndRotation(27.8224F, -1.0F, -27.1734F, 0.0F, 0.4363F, 0.0F));

		PartDefinition Ridge_r7 = Front1Left3.addOrReplaceChild("Ridge_r7", CubeListBuilder.create().texOffs(531, 196).addBox(-5.0F, -4.01F, -41.0F, 6.0F, 8.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1776F, 0.0F, 22.9234F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Front1LowerLeft3 = Front1Left3.addOrReplaceChild("Front1LowerLeft3", CubeListBuilder.create(), PartPose.offset(-16.9877F, 13.5952F, 1.9134F));

		PartDefinition Front1LowerLeftSeg6_r1 = Front1LowerLeft3.addOrReplaceChild("Front1LowerLeftSeg6_r1", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -23.5F, 26.0F, 2.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
		.texOffs(306, 34).addBox(7.0F, -20.5F, -3.0F, 2.0F, 5.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(505, 351).addBox(7.0F, -15.5F, -17.0F, 2.0F, 32.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F));

		PartDefinition TumorFlowerfront1 = Front1LowerLeft3.addOrReplaceChild("TumorFlowerfront1", CubeListBuilder.create().texOffs(140, 306).addBox(1.0F, -3.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1653F, 3.4048F, -6.74F, 2.5008F, -1.4385F, -0.4505F));

		PartDefinition TumorBase3 = TumorFlowerfront1.addOrReplaceChild("TumorBase3", CubeListBuilder.create(), PartPose.offset(5.0F, -1.0F, 0.0F));

		PartDefinition Tumor_r25 = TumorBase3.addOrReplaceChild("Tumor_r25", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -0.5F, -4.5F, 0.189F, 0.3463F, 0.5131F));

		PartDefinition Tumor_r26 = TumorBase3.addOrReplaceChild("Tumor_r26", CubeListBuilder.create().texOffs(142, 308).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -7.0F, -0.5113F, 0.2171F, -0.5714F));

		PartDefinition Tumor_r27 = TumorBase3.addOrReplaceChild("Tumor_r27", CubeListBuilder.create().texOffs(139, 305).addBox(-3.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -0.5F, -5.5F, -0.4363F, -0.5672F, 0.0F));

		PartDefinition Tumor_r28 = TumorBase3.addOrReplaceChild("Tumor_r28", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -0.5F, 5.5F, -0.6545F, 0.3491F, 0.0F));

		PartDefinition Tumor_r29 = TumorBase3.addOrReplaceChild("Tumor_r29", CubeListBuilder.create().texOffs(140, 306).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 6.0F, -0.5236F, 0.0F, -0.3927F));

		PartDefinition SouthTendril3 = TumorBase3.addOrReplaceChild("SouthTendril3", CubeListBuilder.create(), PartPose.offset(0.5F, -0.5F, 2.0F));

		PartDefinition STendieSeg2_r2 = SouthTendril3.addOrReplaceChild("STendieSeg2_r2", CubeListBuilder.create().texOffs(190, 320).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		PartDefinition STendieSeg4 = SouthTendril3.addOrReplaceChild("STendieSeg4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition STendieSeg3_r1 = STendieSeg4.addOrReplaceChild("STendieSeg3_r1", CubeListBuilder.create().texOffs(186, 319).addBox(-1.6946F, -1.6529F, -0.9886F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8802F, -1.453F, 6.6629F, 0.371F, 0.3788F, 0.0798F));

		PartDefinition WestTendril3 = TumorBase3.addOrReplaceChild("WestTendril3", CubeListBuilder.create().texOffs(189, 327).addBox(-1.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5F, -2.0F, 2.0F, 0.0F, 0.0873F, -0.1745F));

		PartDefinition WTendieSeg4 = WestTendril3.addOrReplaceChild("WTendieSeg4", CubeListBuilder.create().texOffs(192, 328).addBox(-0.05F, -0.5F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -0.5F, 0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition EastTendril3 = TumorBase3.addOrReplaceChild("EastTendril3", CubeListBuilder.create().texOffs(192, 327).addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, -0.5F, 0.0097F, 0.218F, 0.0447F));

		PartDefinition ETendieSeg4 = EastTendril3.addOrReplaceChild("ETendieSeg4", CubeListBuilder.create(), PartPose.offset(-7.0F, -1.0F, 0.0F));

		PartDefinition ETendieSeg3_r1 = ETendieSeg4.addOrReplaceChild("ETendieSeg3_r1", CubeListBuilder.create().texOffs(192, 327).addBox(-4.75F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Maw3 = TumorFlowerfront1.addOrReplaceChild("Maw3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SouthMaw3 = Maw3.addOrReplaceChild("SouthMaw3", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.8061F, -0.7458F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.25F, 3.5F, -0.8262F, -0.1527F, 0.0374F));

		PartDefinition Tooth_r36 = SouthMaw3.addOrReplaceChild("Tooth_r36", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.5F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Tooth_r37 = SouthMaw3.addOrReplaceChild("Tooth_r37", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition SMawSeg6 = SouthMaw3.addOrReplaceChild("SMawSeg6", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.0736F, 0.8192F, 9.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -7.4256F, -0.7373F, -0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r38 = SMawSeg6.addOrReplaceChild("Tooth_r38", CubeListBuilder.create().texOffs(117, 142).addBox(4.25F, -2.0F, -3.25F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, -0.3054F, -0.1309F));

		PartDefinition Tooth_r39 = SMawSeg6.addOrReplaceChild("Tooth_r39", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.0F, -2.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, 0.3054F, 0.1309F));

		PartDefinition SMawSeg7 = SMawSeg6.addOrReplaceChild("SMawSeg7", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -4.5F, -1.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.5F, -4.5736F, 1.8192F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r40 = SMawSeg7.addOrReplaceChild("Tooth_r40", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.25F, -0.75F, -0.2182F, -0.3491F, -0.2182F));

		PartDefinition Tooth_r41 = SMawSeg7.addOrReplaceChild("Tooth_r41", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.25F, -0.75F, 0.0F, -0.2182F, 0.2182F));

		PartDefinition NWMaw3 = Maw3.addOrReplaceChild("NWMaw3", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, -2.0F, 0.6109F, -0.9163F, 0.0F));

		PartDefinition Tooth_r42 = NWMaw3.addOrReplaceChild("Tooth_r42", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition NWMawSeg2_r2 = NWMaw3.addOrReplaceChild("NWMawSeg2_r2", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -7.0F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NWMawSeg4 = NWMaw3.addOrReplaceChild("NWMawSeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tooth_r43 = NWMawSeg4.addOrReplaceChild("Tooth_r43", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7208F, -2.8231F, 0.794F, 0.0F, -0.1745F, 0.3927F));

		PartDefinition Tooth_r44 = NWMawSeg4.addOrReplaceChild("Tooth_r44", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2792F, -3.3231F, 1.794F, 0.0535F, -0.2825F, -0.8119F));

		PartDefinition NWMawSeg3_r1 = NWMawSeg4.addOrReplaceChild("NWMawSeg3_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMaw3 = Maw3.addOrReplaceChild("NSMaw3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.8727F, 1.1345F, 0.0F));

		PartDefinition Tooth_r45 = NSMaw3.addOrReplaceChild("Tooth_r45", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 1.0F, 0.0475F, -0.346F, -0.1392F));

		PartDefinition Tooth_r46 = NSMaw3.addOrReplaceChild("Tooth_r46", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition NSMawSeg2_r2 = NSMaw3.addOrReplaceChild("NSMawSeg2_r2", CubeListBuilder.create().texOffs(136, 522).addBox(-4.0F, -3.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg6 = NSMaw3.addOrReplaceChild("NSMawSeg6", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -7.4768F, -1.1485F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Tooth_r47 = NSMawSeg6.addOrReplaceChild("Tooth_r47", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition NSMawSeg3_r2 = NSMawSeg6.addOrReplaceChild("NSMawSeg3_r2", CubeListBuilder.create().texOffs(136, 522).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg7 = NSMawSeg6.addOrReplaceChild("NSMawSeg7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -2.25F, 0.25F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r48 = NSMawSeg7.addOrReplaceChild("Tooth_r48", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.2182F));

		PartDefinition Tooth_r49 = NSMawSeg7.addOrReplaceChild("Tooth_r49", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition NSMawSeg4_r1 = NSMawSeg7.addOrReplaceChild("NSMawSeg4_r1", CubeListBuilder.create().texOffs(136, 522).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -0.1015F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Front1UpperLeft3 = Front1Left3.addOrReplaceChild("Front1UpperLeft3", CubeListBuilder.create(), PartPose.offset(-16.9877F, -13.5952F, 1.9134F));

		PartDefinition FrontLowerLeftSeg6_r1 = Front1UpperLeft3.addOrReplaceChild("FrontLowerLeftSeg6_r1", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, 22.5F, 26.0F, 2.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
		.texOffs(305, 33).addBox(7.0F, 15.5F, -3.0F, 2.0F, 5.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(220, 496).addBox(7.0F, -16.5F, -17.0F, 2.0F, 32.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F));

		PartDefinition Front2Top = Front2.addOrReplaceChild("Front2Top", CubeListBuilder.create().texOffs(425, 351).addBox(-9.0F, -2.639F, -23.2424F, 18.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(138, 324).addBox(-16.0F, -2.639F, -13.6424F, 7.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(567, 16).addBox(-21.0F, -2.639F, -6.6424F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(567, 16).addBox(16.0F, -2.639F, -6.6424F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(138, 324).addBox(9.0F, -2.639F, -13.6424F, 7.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(50, 315).addBox(-4.0F, -7.5F, -31.0F, 8.0F, 5.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -31.361F, -2.7576F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Front2Bottom = Front2.addOrReplaceChild("Front2Bottom", CubeListBuilder.create().texOffs(74, 355).addBox(-9.0F, 0.639F, -23.2424F, 18.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(192, 454).addBox(-16.0F, 0.639F, -13.6424F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 517).addBox(-21.0F, 0.639F, -6.6424F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 517).addBox(16.0F, 0.639F, -6.6424F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 454).addBox(9.0F, 0.639F, -13.6424F, 7.0F, 2.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 189).addBox(-4.0F, 2.5F, -31.0F, 8.0F, 5.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 29.361F, -2.7576F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Front2Tendrils = Front2Bottom.addOrReplaceChild("Front2Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition F2Tendril1 = Front2Tendrils.addOrReplaceChild("F2Tendril1", CubeListBuilder.create().texOffs(487, 116).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 3.0F, -9.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition F2Tendril1Seg2 = F2Tendril1.addOrReplaceChild("F2Tendril1Seg2", CubeListBuilder.create().texOffs(66, 310).addBox(-2.0F, -2.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition F2Tendril1Seg3 = F2Tendril1Seg2.addOrReplaceChild("F2Tendril1Seg3", CubeListBuilder.create().texOffs(28, 149).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition F2HoleFiller = Front2Bottom.addOrReplaceChild("F2HoleFiller", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Clump1 = F2HoleFiller.addOrReplaceChild("Clump1", CubeListBuilder.create(), PartPose.offset(7.0F, 4.0F, -16.0F));

		PartDefinition Tumor_r30 = Clump1.addOrReplaceChild("Tumor_r30", CubeListBuilder.create().texOffs(146, 311).addBox(-1.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.5F, -1.5F, 8.5F, -0.4326F, -0.678F, -2.507F));

		PartDefinition Tumor_r31 = Clump1.addOrReplaceChild("Tumor_r31", CubeListBuilder.create().texOffs(144, 309).addBox(-2.5F, -5.5F, -4.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.5F, 0.5F, 1.5F, 0.0F, -0.9599F, -0.7854F));

		PartDefinition Tumor_r32 = Clump1.addOrReplaceChild("Tumor_r32", CubeListBuilder.create().texOffs(143, 308).addBox(-4.0F, -4.0F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, -0.5672F));

		PartDefinition Clump2 = F2HoleFiller.addOrReplaceChild("Clump2", CubeListBuilder.create(), PartPose.offset(-7.0F, 4.0F, -16.0F));

		PartDefinition Tumor_r33 = Clump2.addOrReplaceChild("Tumor_r33", CubeListBuilder.create().texOffs(146, 311).mirror().addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.15F)).mirror(false), PartPose.offsetAndRotation(-9.8728F, -1.9617F, 9.1272F, -0.3491F, 0.4363F, 1.7453F));

		PartDefinition Tumor_r34 = Clump2.addOrReplaceChild("Tumor_r34", CubeListBuilder.create().texOffs(144, 309).mirror().addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(-2.0706F, -1.899F, 1.7456F, -0.4891F, 1.0934F, -0.6389F));

		PartDefinition Tumor_r35 = Clump2.addOrReplaceChild("Tumor_r35", CubeListBuilder.create().texOffs(143, 308).mirror().addBox(-4.0F, -5.0F, -9.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.5672F));

		PartDefinition Front3 = Front2.addOrReplaceChild("Front3", CubeListBuilder.create().texOffs(496, 601).addBox(-4.3136F, -4.0516F, -7.1627F, 9.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0636F, -0.9484F, -36.8373F));

		PartDefinition BottomSegMiddle_r1 = Front3.addOrReplaceChild("BottomSegMiddle_r1", CubeListBuilder.create().texOffs(210, 0).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1952F, 4.1919F, -2.4349F, 0.3054F, 0.0F, 0.0F));

		PartDefinition BottomSegLeft_r1 = Front3.addOrReplaceChild("BottomSegLeft_r1", CubeListBuilder.create().texOffs(345, 363).addBox(-8.5F, -2.0F, -1.0F, 23.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6606F, 10.5419F, -0.3207F, 0.2318F, 0.27F, -1.0712F));

		PartDefinition BottomSegRight_r1 = Front3.addOrReplaceChild("BottomSegRight_r1", CubeListBuilder.create().texOffs(345, 363).addBox(-14.5F, -2.0F, -1.0F, 23.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7878F, 10.5419F, -0.3207F, 0.2318F, -0.27F, 1.0712F));

		PartDefinition TopSegMiddle_r1 = Front3.addOrReplaceChild("TopSegMiddle_r1", CubeListBuilder.create().texOffs(0, 144).addBox(-4.7588F, -27.0F, -4.0F, 9.0F, 29.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1952F, -4.295F, -2.4349F, -0.3054F, 0.0F, 0.0F));

		PartDefinition TopSegLeft_r1 = Front3.addOrReplaceChild("TopSegLeft_r1", CubeListBuilder.create().texOffs(170, 482).addBox(-8.5F, -8.0F, -1.0F, 23.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6606F, -10.645F, -0.3207F, -0.2318F, 0.27F, 1.0712F));

		PartDefinition TopSegRight_r1 = Front3.addOrReplaceChild("TopSegRight_r1", CubeListBuilder.create().texOffs(170, 482).addBox(-14.5F, -8.0F, -1.0F, 23.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7878F, -10.645F, -0.3207F, -0.2318F, -0.27F, -1.0712F));

		PartDefinition Connector_r1 = Front3.addOrReplaceChild("Connector_r1", CubeListBuilder.create().texOffs(60, 482).addBox(-20.0F, -4.0F, -3.0F, 38.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0636F, -0.0516F, -3.1627F, 0.0F, 0.0873F, 0.0F));

		PartDefinition F2SBodies = Front2.addOrReplaceChild("F2SBodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition F2SBody1 = F2SBodies.addOrReplaceChild("F2SBody1", CubeListBuilder.create(), PartPose.offset(0.0F, -33.0F, -27.0F));

		PartDefinition Leg_r5 = F2SBody1.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(565, 596).addBox(-2.1895F, -1.5633F, -0.7177F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6301F, -0.1722F, 17.4843F, 0.1591F, -0.6505F, -0.0628F));

		PartDefinition TorsoLower_r2 = F2SBody1.addOrReplaceChild("TorsoLower_r2", CubeListBuilder.create().texOffs(192, 366).addBox(-3.5F, -0.8F, -3.4F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5529F, -1.5F, 14.7956F, -0.1745F, -0.2618F, 0.0F));

		PartDefinition Torso_r8 = F2SBody1.addOrReplaceChild("Torso_r8", CubeListBuilder.create().texOffs(190, 359).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.0F, 9.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Arm_r10 = F2SBody1.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(212, 359).addBox(-2.1077F, -1.3413F, -6.1341F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6954F, -3.9189F, 7.994F, 0.4024F, -0.5103F, 0.0893F));

		PartDefinition Jaw_r11 = F2SBody1.addOrReplaceChild("Jaw_r11", CubeListBuilder.create().texOffs(190, 359).addBox(-4.5176F, -1.0582F, -6.1025F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.972F, 0.4881F, 4.8955F, -0.128F, -0.2577F, -0.4424F));

		PartDefinition Head_r13 = F2SBody1.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(576, 568).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 3.0F, -0.2182F, -0.2618F, -0.2618F));

		PartDefinition F2Clump1 = F2SBodies.addOrReplaceChild("F2Clump1", CubeListBuilder.create(), PartPose.offset(20.0F, -10.0F, -25.0F));

		PartDefinition Tumor3_r5 = F2Clump1.addOrReplaceChild("Tumor3_r5", CubeListBuilder.create().texOffs(138, 314).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.332F, -5.3264F, -4.5959F, -0.0223F, 0.2177F, -1.6134F));

		PartDefinition Tumor2_r7 = F2Clump1.addOrReplaceChild("Tumor2_r7", CubeListBuilder.create().texOffs(144, 308).addBox(-4.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.5F, 0.5F, 0.4821F, 0.2129F, -0.3838F));

		PartDefinition Tumor1_r7 = F2Clump1.addOrReplaceChild("Tumor1_r7", CubeListBuilder.create().texOffs(145, 309).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.0F, -0.2618F, -0.9599F));

		PartDefinition F2SBody2 = F2SBodies.addOrReplaceChild("F2SBody2", CubeListBuilder.create(), PartPose.offset(-7.0F, -6.0F, -37.0F));

		PartDefinition TorsoLower_r3 = F2SBody2.addOrReplaceChild("TorsoLower_r3", CubeListBuilder.create().texOffs(203, 361).addBox(-2.0F, -3.5F, -3.0F, 4.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7764F, -8.0256F, 7.141F, -0.214F, -0.7362F, 0.5941F));

		PartDefinition Arm_r11 = F2SBody2.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(197, 354).addBox(-2.2241F, -4.4019F, -0.9399F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -10.0F, 0.0F, 0.3375F, 0.0673F, 0.6411F));

		PartDefinition Torso_r9 = F2SBody2.addOrReplaceChild("Torso_r9", CubeListBuilder.create().texOffs(200, 358).addBox(-2.0F, -4.0F, -1.0F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -7.0F, 0.0F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition Jaw_r12 = F2SBody2.addOrReplaceChild("Jaw_r12", CubeListBuilder.create().texOffs(48, 212).addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8493F, -2.5255F, -2.4916F, 0.3433F, 0.0667F, -1.2521F));

		PartDefinition Head_r14 = F2SBody2.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(505, 379).addBox(-3.0F, -4.0F, -2.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -3.0F, -0.3927F, 0.0F, -0.9599F));

		PartDefinition F2SBody3 = F2SBodies.addOrReplaceChild("F2SBody3", CubeListBuilder.create(), PartPose.offset(-7.0F, 16.0F, -34.0F));

		PartDefinition Leg_r6 = F2SBody3.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(201, 367).addBox(-1.3244F, -0.0333F, -1.1385F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3168F, -2.7277F, -0.1014F, 1.0135F, -0.7254F, 1.2791F));

		PartDefinition TorsoLower_r4 = F2SBody3.addOrReplaceChild("TorsoLower_r4", CubeListBuilder.create().texOffs(199, 353).addBox(-3.3149F, -0.916F, -0.378F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5656F, -2.7837F, -4.9134F, 1.0472F, 0.0F, 0.7418F));

		PartDefinition Torso_r10 = F2SBody3.addOrReplaceChild("Torso_r10", CubeListBuilder.create().texOffs(186, 364).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5656F, -5.7837F, -4.9134F, 0.3927F, 0.0F, 0.7418F));

		PartDefinition F1SBodies = Front1.addOrReplaceChild("F1SBodies", CubeListBuilder.create(), PartPose.offset(-42.0F, 14.0F, -34.0F));

		PartDefinition F1SBody1 = F1SBodies.addOrReplaceChild("F1SBody1", CubeListBuilder.create(), PartPose.offset(2.4549F, 10.9041F, 7.7361F));

		PartDefinition Leg_r7 = F1SBody1.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(202, 367).addBox(-2.0298F, 0.9958F, -6.1464F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.178F, -0.2536F, -0.5148F));

		PartDefinition Leg_r8 = F1SBody1.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(208, 353).addBox(-2.0298F, 0.9958F, -2.1464F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0029F, -0.1218F, -0.5227F));

		PartDefinition TorsoBottom_r1 = F1SBody1.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(198, 360).addBox(-1.5F, -4.0F, -3.5F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.5477F, -0.2681F, -0.4257F));

		PartDefinition Arm_r12 = F1SBody1.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(197, 353).addBox(-1.8843F, -1.7001F, -4.3868F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3116F, -5.2285F, -8.1372F, 0.1025F, -0.4155F, -0.1413F));

		PartDefinition Torso_r11 = F1SBody1.addOrReplaceChild("Torso_r11", CubeListBuilder.create().texOffs(197, 358).addBox(-2.0F, -3.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0726F, -5.3005F, -5.0008F, 0.4515F, -0.4155F, -0.1413F));

		PartDefinition Head_r15 = F1SBody1.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(0, 326).addBox(-3.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4549F, -11.9041F, -7.7361F, 0.3914F, -0.0334F, 0.0807F));

		PartDefinition F1Clump1 = F1SBodies.addOrReplaceChild("F1Clump1", CubeListBuilder.create(), PartPose.offset(-4.0F, -32.0F, 25.0F));

		PartDefinition Tumor2_r8 = F1Clump1.addOrReplaceChild("Tumor2_r8", CubeListBuilder.create().texOffs(189, 321).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.1284F, -5.1423F, -0.4249F, -0.7335F, 1.3436F));

		PartDefinition Tumor1_r8 = F1Clump1.addOrReplaceChild("Tumor1_r8", CubeListBuilder.create().texOffs(186, 319).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.387F, -0.8036F, 1.0556F));

		PartDefinition F1Clump2 = F1SBodies.addOrReplaceChild("F1Clump2", CubeListBuilder.create(), PartPose.offset(42.0F, -56.0F, 11.0F));

		PartDefinition Tumor2_r9 = F1Clump2.addOrReplaceChild("Tumor2_r9", CubeListBuilder.create().texOffs(193, 324).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4441F, -2.0311F, 9.5767F, -1.5961F, -1.1945F, 0.934F));

		PartDefinition Tumor1_r9 = F1Clump2.addOrReplaceChild("Tumor1_r9", CubeListBuilder.create().texOffs(189, 321).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5979F, 1.8096F, 1.5979F, -0.3054F, -0.7854F, 0.0F));

		PartDefinition F1SBody2 = F1SBodies.addOrReplaceChild("F1SBody2", CubeListBuilder.create(), PartPose.offset(88.0F, -26.0F, 18.0F));

		PartDefinition TorsoBottom_r2 = F1SBody2.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(213, 367).addBox(-3.2544F, -0.1081F, -3.7605F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9202F, 0.6067F, -0.7753F, -0.1288F, 0.1761F, -0.2583F));

		PartDefinition ARm_r13 = F1SBody2.addOrReplaceChild("ARm_r13", CubeListBuilder.create().texOffs(196, 361).addBox(-1.2143F, -1.8997F, -3.9929F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3401F, -2.9436F, -5.0766F, -0.9646F, 0.4094F, -0.5827F));

		PartDefinition Torso_r12 = F1SBody2.addOrReplaceChild("Torso_r12", CubeListBuilder.create().texOffs(203, 362).addBox(-2.634F, -2.634F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0981F, -2.4378F, -1.0F, 0.0456F, 0.1685F, -0.2579F));

		PartDefinition Head_r16 = F1SBody2.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(122, 506).addBox(-3.2349F, -6.5981F, -2.6941F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3914F, -4.6193F, -1.6122F, 0.0F, 0.5672F, -0.5236F));

		PartDefinition F1SBody3 = F1SBodies.addOrReplaceChild("F1SBody3", CubeListBuilder.create(), PartPose.offset(83.0F, 10.0F, 16.0F));

		PartDefinition Arm_r14 = F1SBody3.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(201, 363).addBox(-2.0F, -2.2F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -8.0F, 13.0F, 0.2266F, 0.4061F, -0.2215F));

		PartDefinition Arm_r15 = F1SBody3.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(199, 353).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.3887F, 0.4242F, 0.0026F));

		PartDefinition Back1 = Center.addOrReplaceChild("Back1", CubeListBuilder.create(), PartPose.offset(0.0F, -101.4F, 32.512F));

		PartDefinition Back1Right = Back1.addOrReplaceChild("Back1Right", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, -32.5F));

		PartDefinition Ridge_r8 = Back1Right.addOrReplaceChild("Ridge_r8", CubeListBuilder.create().texOffs(1, 266).addBox(-3.0F, -4.0F, -1.0F, 8.0F, 8.0F, 81.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-60.0F, -74.0F, 35.0F, 0.0F, 0.3054F, 0.0F));

		PartDefinition Back1LowerRight = Back1Right.addOrReplaceChild("Back1LowerRight", CubeListBuilder.create(), PartPose.offset(-35.8347F, -60.4048F, 56.01F));

		PartDefinition Ridge_r9 = Back1LowerRight.addOrReplaceChild("Ridge_r9", CubeListBuilder.create().texOffs(250, 571).addBox(-3.0F, -8.0F, -2.0F, 5.0F, 32.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3634F, -2.0965F, 55.6581F, 0.0F, 0.2618F, -0.5236F));

		PartDefinition Back1LowerRightSeg3_r1 = Back1LowerRight.addOrReplaceChild("Back1LowerRightSeg3_r1", CubeListBuilder.create().texOffs(267, 507).addBox(-9.0F, -20.5F, -25.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(210, 0).addBox(-9.0F, -15.5F, -25.0F, 7.0F, 39.0F, 81.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, -0.5236F));

		PartDefinition FungalBloom8 = Back1LowerRight.addOrReplaceChild("FungalBloom8", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.3001F, 10.8706F, 21.4793F, -0.3161F, 0.405F, -2.2043F));

		PartDefinition Plane2_r6 = FungalBloom8.addOrReplaceChild("Plane2_r6", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r5 = FungalBloom8.addOrReplaceChild("Plane1_r5", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r6 = FungalBloom8.addOrReplaceChild("Npetal_r6", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r6 = FungalBloom8.addOrReplaceChild("Spetal_r6", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r6 = FungalBloom8.addOrReplaceChild("Wpetal_r6", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r6 = FungalBloom8.addOrReplaceChild("Epetal_r6", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Back1UpperRight = Back1Right.addOrReplaceChild("Back1UpperRight", CubeListBuilder.create(), PartPose.offset(-35.8347F, -87.5952F, 56.01F));

		PartDefinition Ridge_r10 = Back1UpperRight.addOrReplaceChild("Ridge_r10", CubeListBuilder.create().texOffs(186, 571).addBox(-2.9852F, -2.3785F, -1.7143F, 5.0F, 48.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.095F, -17.7624F, 55.7646F, -0.0216F, 0.2457F, 0.1632F));

		PartDefinition Back3LowerRightSeg3_r1 = Back1UpperRight.addOrReplaceChild("Back3LowerRightSeg3_r1", CubeListBuilder.create().texOffs(267, 507).addBox(-9.0F, 15.5F, -25.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(103, 184).addBox(-9.0F, -23.5F, -25.0F, 7.0F, 39.0F, 81.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.5236F));

		PartDefinition B1RRTumors = Back1Right.addOrReplaceChild("B1RRTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor3_r6 = B1RRTumors.addOrReplaceChild("Tumor3_r6", CubeListBuilder.create().texOffs(192, 323).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.1253F, -70.0397F, 110.2392F, 2.7905F, 1.0229F, 2.1498F));

		PartDefinition Tumor2_r10 = B1RRTumors.addOrReplaceChild("Tumor2_r10", CubeListBuilder.create().texOffs(186, 319).addBox(-2.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-30.2577F, -76.4354F, 113.607F, -0.4594F, 0.9949F, -0.1019F));

		PartDefinition Tumor1_r10 = B1RRTumors.addOrReplaceChild("Tumor1_r10", CubeListBuilder.create().texOffs(186, 319).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, -81.0F, 112.0F, 0.3491F, 0.3491F, 0.3927F));

		PartDefinition Back1Left = Back1.addOrReplaceChild("Back1Left", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, -32.5F));

		PartDefinition Ridge_r11 = Back1Left.addOrReplaceChild("Ridge_r11", CubeListBuilder.create().texOffs(0, 265).addBox(-5.0F, -4.0F, -1.0F, 8.0F, 8.0F, 82.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(60.0F, -74.0F, 35.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition Back1LowerLeft = Back1Left.addOrReplaceChild("Back1LowerLeft", CubeListBuilder.create(), PartPose.offset(35.8347F, -60.4048F, 56.01F));

		PartDefinition Ridge_r12 = Back1LowerLeft.addOrReplaceChild("Ridge_r12", CubeListBuilder.create().texOffs(250, 571).addBox(-2.0F, -15.0F, -2.0F, 5.0F, 39.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3634F, -2.0965F, 55.6581F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition Back1LowerLeftSeg3_r1 = Back1LowerLeft.addOrReplaceChild("Back1LowerLeftSeg3_r1", CubeListBuilder.create().texOffs(74, 393).addBox(7.0F, -20.5F, -25.0F, 2.0F, 5.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(103, 184).addBox(2.0F, -15.5F, -25.0F, 7.0F, 39.0F, 81.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.5236F));

		PartDefinition TumorFlower = Back1LowerLeft.addOrReplaceChild("TumorFlower", CubeListBuilder.create().texOffs(140, 306).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1653F, 7.9048F, 16.99F, -0.258F, 0.045F, 2.2631F));

		PartDefinition TumorBase2 = TumorFlower.addOrReplaceChild("TumorBase2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.5F, 0.0F));

		PartDefinition Tumor_r36 = TumorBase2.addOrReplaceChild("Tumor_r36", CubeListBuilder.create().texOffs(143, 309).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -0.5F, -4.5F, 0.189F, 0.3463F, 0.5131F));

		PartDefinition Tumor_r37 = TumorBase2.addOrReplaceChild("Tumor_r37", CubeListBuilder.create().texOffs(142, 308).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -7.0F, -0.5113F, 0.2171F, -0.5714F));

		PartDefinition Tumor_r38 = TumorBase2.addOrReplaceChild("Tumor_r38", CubeListBuilder.create().texOffs(139, 305).addBox(-3.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -0.5F, -5.5F, -0.4363F, -0.5672F, 0.0F));

		PartDefinition Tumor_r39 = TumorBase2.addOrReplaceChild("Tumor_r39", CubeListBuilder.create().texOffs(141, 307).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -0.5F, 5.5F, -0.6545F, 0.3491F, 0.0F));

		PartDefinition Tumor_r40 = TumorBase2.addOrReplaceChild("Tumor_r40", CubeListBuilder.create().texOffs(140, 306).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 6.0F, -0.5236F, 0.0F, -0.3927F));

		PartDefinition SouthTendril2 = TumorBase2.addOrReplaceChild("SouthTendril2", CubeListBuilder.create(), PartPose.offset(0.5F, -0.5F, 2.0F));

		PartDefinition STendieSeg2_r3 = SouthTendril2.addOrReplaceChild("STendieSeg2_r3", CubeListBuilder.create().texOffs(191, 320).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		PartDefinition STendieSeg3 = SouthTendril2.addOrReplaceChild("STendieSeg3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition STendieSeg3_r2 = STendieSeg3.addOrReplaceChild("STendieSeg3_r2", CubeListBuilder.create().texOffs(186, 319).addBox(-1.6946F, -1.6529F, -0.9886F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8802F, -1.453F, 6.6629F, 0.371F, 0.3788F, 0.0798F));

		PartDefinition WestTendril2 = TumorBase2.addOrReplaceChild("WestTendril2", CubeListBuilder.create().texOffs(186, 326).addBox(-1.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5F, -2.0F, 2.0F, 0.0F, 0.0873F, -0.1745F));

		PartDefinition WTendieSeg3 = WestTendril2.addOrReplaceChild("WTendieSeg3", CubeListBuilder.create().texOffs(194, 327).addBox(-0.05F, -0.5F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -0.5F, 0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition EastTendril2 = TumorBase2.addOrReplaceChild("EastTendril2", CubeListBuilder.create().texOffs(192, 327).addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, -0.5F, 0.0097F, 0.218F, 0.0447F));

		PartDefinition ETendieSeg3 = EastTendril2.addOrReplaceChild("ETendieSeg3", CubeListBuilder.create(), PartPose.offset(-7.0F, -1.0F, 0.0F));

		PartDefinition ETendieSeg3_r2 = ETendieSeg3.addOrReplaceChild("ETendieSeg3_r2", CubeListBuilder.create().texOffs(192, 327).addBox(-4.75F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Maw2 = TumorFlower.addOrReplaceChild("Maw2", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.5F, 0.0F));

		PartDefinition SouthMaw2 = Maw2.addOrReplaceChild("SouthMaw2", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.8061F, -0.7458F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.25F, 3.5F, -0.8262F, -0.1527F, 0.0374F));

		PartDefinition Tooth_r50 = SouthMaw2.addOrReplaceChild("Tooth_r50", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.5F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Tooth_r51 = SouthMaw2.addOrReplaceChild("Tooth_r51", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition SMawSeg4 = SouthMaw2.addOrReplaceChild("SMawSeg4", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -5.0736F, 0.8192F, 9.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -7.4256F, -0.7373F, -0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r52 = SMawSeg4.addOrReplaceChild("Tooth_r52", CubeListBuilder.create().texOffs(117, 142).addBox(4.25F, -2.0F, -3.25F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, -0.3054F, -0.1309F));

		PartDefinition Tooth_r53 = SMawSeg4.addOrReplaceChild("Tooth_r53", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -3.0F, -2.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.25F, 0.0F, 0.3054F, 0.1309F));

		PartDefinition SMawSeg5 = SMawSeg4.addOrReplaceChild("SMawSeg5", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -4.5F, -1.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.5F, -4.5736F, 1.8192F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r54 = SMawSeg5.addOrReplaceChild("Tooth_r54", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.25F, -0.75F, -0.2182F, -0.3491F, -0.2182F));

		PartDefinition Tooth_r55 = SMawSeg5.addOrReplaceChild("Tooth_r55", CubeListBuilder.create().texOffs(117, 142).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.25F, -0.75F, 0.0F, -0.2182F, 0.2182F));

		PartDefinition NWMaw2 = Maw2.addOrReplaceChild("NWMaw2", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, -2.0F, 0.6109F, -0.9163F, 0.0F));

		PartDefinition Tooth_r56 = NWMaw2.addOrReplaceChild("Tooth_r56", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition NWMawSeg2_r3 = NWMaw2.addOrReplaceChild("NWMawSeg2_r3", CubeListBuilder.create().texOffs(136, 522).addBox(-5.0F, -3.5F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NWMawSeg3 = NWMaw2.addOrReplaceChild("NWMawSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tooth_r57 = NWMawSeg3.addOrReplaceChild("Tooth_r57", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7208F, -2.8231F, 0.794F, 0.0F, -0.1745F, 0.3927F));

		PartDefinition Tooth_r58 = NWMawSeg3.addOrReplaceChild("Tooth_r58", CubeListBuilder.create().texOffs(119, 142).addBox(-1.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2792F, -3.3231F, 1.794F, 0.0535F, -0.2825F, -0.8119F));

		PartDefinition NWMawSeg3_r2 = NWMawSeg3.addOrReplaceChild("NWMawSeg3_r2", CubeListBuilder.create().texOffs(136, 522).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMaw2 = Maw2.addOrReplaceChild("NSMaw2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.8727F, 1.1345F, 0.0F));

		PartDefinition Tooth_r59 = NSMaw2.addOrReplaceChild("Tooth_r59", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 1.0F, 0.0475F, -0.346F, -0.1392F));

		PartDefinition Tooth_r60 = NSMaw2.addOrReplaceChild("Tooth_r60", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition NSMawSeg2_r3 = NSMaw2.addOrReplaceChild("NSMawSeg2_r3", CubeListBuilder.create().texOffs(136, 522).addBox(-4.0F, -3.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg4 = NSMaw2.addOrReplaceChild("NSMawSeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -7.4768F, -1.1485F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Tooth_r61 = NSMawSeg4.addOrReplaceChild("Tooth_r61", CubeListBuilder.create().texOffs(119, 142).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition NSMawSeg3_r3 = NSMawSeg4.addOrReplaceChild("NSMawSeg3_r3", CubeListBuilder.create().texOffs(136, 522).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg5 = NSMawSeg4.addOrReplaceChild("NSMawSeg5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -2.25F, 0.25F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r62 = NSMawSeg5.addOrReplaceChild("Tooth_r62", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.2182F));

		PartDefinition Tooth_r63 = NSMawSeg5.addOrReplaceChild("Tooth_r63", CubeListBuilder.create().texOffs(119, 142).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition NSMawSeg4_r2 = NSMawSeg5.addOrReplaceChild("NSMawSeg4_r2", CubeListBuilder.create().texOffs(136, 522).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -0.1015F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Back1UpperLeft = Back1Left.addOrReplaceChild("Back1UpperLeft", CubeListBuilder.create(), PartPose.offset(35.8347F, -87.5952F, 56.01F));

		PartDefinition Ridge_r13 = Back1UpperLeft.addOrReplaceChild("Ridge_r13", CubeListBuilder.create().texOffs(250, 571).addBox(-2.0F, -24.0F, -2.0F, 5.0F, 39.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3634F, 2.0965F, 55.6581F, 0.0F, -0.2618F, -0.5236F));

		PartDefinition Back1UpperLeftSeg3_r1 = Back1UpperLeft.addOrReplaceChild("Back1UpperLeftSeg3_r1", CubeListBuilder.create().texOffs(98, 304).addBox(0.1F, -2.5F, -13.5F, 2.0F, 7.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0229F, 7.7382F, -10.338F, 0.1309F, -0.3054F, -0.5236F));

		PartDefinition BackUpperLeftSeg2_r1 = Back1UpperLeft.addOrReplaceChild("BackUpperLeftSeg2_r1", CubeListBuilder.create().texOffs(0, 144).addBox(3.0F, -21.5F, -28.0F, 8.0F, 37.0F, 84.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.5236F));

		PartDefinition Back1Top = Back1.addOrReplaceChild("Back1Top", CubeListBuilder.create(), PartPose.offset(0.0F, 74.0F, 37.5F));

		PartDefinition Back1TopMiddle_r1 = Back1Top.addOrReplaceChild("Back1TopMiddle_r1", CubeListBuilder.create().texOffs(293, 174).addBox(-21.0F, -1.0F, 29.5F, 42.0F, 1.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(293, 120).addBox(-27.0F, -1.0F, -23.5F, 54.0F, 1.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -112.0F, -12.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RidgeSeg3_r2 = Back1Top.addOrReplaceChild("RidgeSeg3_r2", CubeListBuilder.create().texOffs(5, 270).addBox(-3.99F, -3.5F, -36.0F, 8.0F, 5.0F, 77.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -111.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Back1TopRight = Back1Top.addOrReplaceChild("Back1TopRight", CubeListBuilder.create(), PartPose.offset(-30.5977F, -110.1936F, -22.3015F));

		PartDefinition Back1TopRightSeg5_r1 = Back1TopRight.addOrReplaceChild("Back1TopRightSeg5_r1", CubeListBuilder.create().texOffs(74, 382).addBox(2.5F, -3.25F, 8.5F, 2.0F, 8.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(134, 355).addBox(-3.5F, -3.25F, -14.5F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(546, 455).addBox(-1.5F, -3.25F, -14.5F, 6.0F, 8.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2095F, -0.1582F, -0.6378F));

		PartDefinition BackTopRightSeg2_r1 = Back1TopRight.addOrReplaceChild("BackTopRightSeg2_r1", CubeListBuilder.create().texOffs(0, 144).addBox(-29.0F, -1.0F, -23.49F, 2.0F, 8.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.5977F, -1.8064F, 9.8015F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Back1TopLeft = Back1Top.addOrReplaceChild("Back1TopLeft", CubeListBuilder.create(), PartPose.offset(30.5977F, -110.1936F, -22.3015F));

		PartDefinition Back1TopLeftSeg5_r1 = Back1TopLeft.addOrReplaceChild("Back1TopLeftSeg5_r1", CubeListBuilder.create().texOffs(538, 94).addBox(-4.5F, -3.25F, -14.5F, 4.0F, 8.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2095F, 0.1582F, 0.6378F));

		PartDefinition BackTopLeftSeg2_r1 = Back1TopLeft.addOrReplaceChild("BackTopLeftSeg2_r1", CubeListBuilder.create().texOffs(538, 40).addBox(27.0F, -1.0F, -23.5F, 2.0F, 8.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.5977F, -1.8064F, 9.8015F, -0.2618F, 0.0F, 0.0F));

		PartDefinition B1TLTumoralClump = Back1TopLeft.addOrReplaceChild("B1TLTumoralClump", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor5_r1 = B1TLTumoralClump.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(158, 315).addBox(-1.5F, -1.5F, -3.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2674F, -0.8594F, 10.0512F, -0.6545F, 0.0F, 1.0734F));

		PartDefinition Tumor4_r2 = B1TLTumoralClump.addOrReplaceChild("Tumor4_r2", CubeListBuilder.create().texOffs(147, 312).addBox(-4.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5771F, -1.5604F, 6.5942F, 2.9322F, -0.8988F, 1.117F));

		PartDefinition Tumor3_r7 = B1TLTumoralClump.addOrReplaceChild("Tumor3_r7", CubeListBuilder.create().texOffs(143, 312).addBox(-3.5F, -2.5F, -3.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9784F, -3.551F, -1.154F, 2.4707F, -0.3252F, 0.8777F));

		PartDefinition Tumor2_r11 = B1TLTumoralClump.addOrReplaceChild("Tumor2_r11", CubeListBuilder.create().texOffs(144, 308).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3806F, -3.5517F, -2.251F, -0.2097F, 0.4464F, 0.3022F));

		PartDefinition Tumor1_r11 = B1TLTumoralClump.addOrReplaceChild("Tumor1_r11", CubeListBuilder.create().texOffs(138, 304).addBox(-4.0F, -6.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -6.0F, -10.0F, 0.4013F, 0.2013F, 0.7391F));

		PartDefinition FungalBloom = Back1Top.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.1349F, -113.5342F, -6.5107F, -0.3193F, -0.2909F, 0.0945F));

		PartDefinition Plane2_r7 = FungalBloom.addOrReplaceChild("Plane2_r7", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r6 = FungalBloom.addOrReplaceChild("Plane1_r6", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r7 = FungalBloom.addOrReplaceChild("Npetal_r7", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r7 = FungalBloom.addOrReplaceChild("Spetal_r7", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r7 = FungalBloom.addOrReplaceChild("Wpetal_r7", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r7 = FungalBloom.addOrReplaceChild("Epetal_r7", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Back1Bottom = Back1.addOrReplaceChild("Back1Bottom", CubeListBuilder.create(), PartPose.offset(0.0F, -74.0F, 37.5F));

		PartDefinition Back1BottomMiddle_r1 = Back1Bottom.addOrReplaceChild("Back1BottomMiddle_r1", CubeListBuilder.create().texOffs(100, 144).addBox(-21.0F, -7.0F, 29.5F, 42.0F, 8.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(226, 264).addBox(-27.0F, -9.0F, -23.49F, 54.0F, 10.0F, 53.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 112.0F, -12.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Back1BottomRight = Back1Bottom.addOrReplaceChild("Back1BottomRight", CubeListBuilder.create(), PartPose.offset(-30.5977F, 110.1936F, -22.3015F));

		PartDefinition Back1BottomRightSeg6_r1 = Back1BottomRight.addOrReplaceChild("Back1BottomRightSeg6_r1", CubeListBuilder.create().texOffs(0, 49).addBox(2.5F, 1.25F, 8.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(98, 566).addBox(-3.5F, 1.25F, -14.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-1.5F, 1.25F, -14.4985F, 6.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2095F, -0.1582F, 0.6378F));

		PartDefinition BackBottomRightSeg3_r1 = Back1BottomRight.addOrReplaceChild("BackBottomRightSeg3_r1", CubeListBuilder.create().texOffs(374, 198).addBox(-29.0F, -1.0F, -23.5F, 2.0F, 2.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.5977F, 1.8064F, 9.8015F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Back1BottomLeft = Back1Bottom.addOrReplaceChild("Back1BottomLeft", CubeListBuilder.create(), PartPose.offset(30.5977F, 110.1936F, -22.3015F));

		PartDefinition Back1BottomLeftSeg6_r1 = Back1BottomLeft.addOrReplaceChild("Back1BottomLeftSeg6_r1", CubeListBuilder.create().texOffs(0, 49).addBox(-4.5F, 1.25F, 8.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(98, 566).addBox(1.5F, 1.25F, -14.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-4.5F, 1.25F, -14.4985F, 6.0F, 2.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2095F, 0.1582F, -0.6378F));

		PartDefinition BackBottomLeftSeg3_r1 = Back1BottomLeft.addOrReplaceChild("BackBottomLeftSeg3_r1", CubeListBuilder.create().texOffs(374, 198).addBox(27.0F, -1.0F, -23.5F, 2.0F, 2.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.5977F, 1.8064F, 9.8015F, 0.2618F, 0.0F, 0.0F));

		PartDefinition B1Tendrils = Back1Bottom.addOrReplaceChild("B1Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition B1Tendril1 = B1Tendrils.addOrReplaceChild("B1Tendril1", CubeListBuilder.create().texOffs(56, 566).addBox(-7.0F, -4.0F, -4.0F, 14.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 116.0F, -25.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition FungalBloom6 = B1Tendril1.addOrReplaceChild("FungalBloom6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3857F, 7.8123F, 13.6763F, -1.3226F, -0.0533F, 2.5738F));

		PartDefinition Plane2_r8 = FungalBloom6.addOrReplaceChild("Plane2_r8", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r7 = FungalBloom6.addOrReplaceChild("Plane1_r7", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r8 = FungalBloom6.addOrReplaceChild("Npetal_r8", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r8 = FungalBloom6.addOrReplaceChild("Spetal_r8", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Wpetal_r8 = FungalBloom6.addOrReplaceChild("Wpetal_r8", CubeListBuilder.create().texOffs(584, 16).addBox(1.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r8 = FungalBloom6.addOrReplaceChild("Epetal_r8", CubeListBuilder.create().texOffs(568, 0).addBox(-17.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 5.3343F, -7.831F, 0.0F, 0.0F, 0.3927F));

		PartDefinition B1Tendril1Seg2 = B1Tendril1.addOrReplaceChild("B1Tendril1Seg2", CubeListBuilder.create().texOffs(239, 144).addBox(-5.0F, -1.75F, -5.0F, 10.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.75F, 3.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Tumor_r41 = B1Tendril1Seg2.addOrReplaceChild("Tumor_r41", CubeListBuilder.create().texOffs(435, 565).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.0F, -4.0F, -0.1211F, -0.6474F, -0.3455F));

		PartDefinition B1TendrilSplit1 = B1Tendril1Seg2.addOrReplaceChild("B1TendrilSplit1", CubeListBuilder.create().texOffs(447, 466).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 15.0F, 0.0F, 0.2597F, -0.0338F, -0.1353F));

		PartDefinition B1TendrilSplit1Seg2 = B1TendrilSplit1.addOrReplaceChild("B1TendrilSplit1Seg2", CubeListBuilder.create().texOffs(48, 310).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition B1TendrilSplit1Seg3 = B1TendrilSplit1Seg2.addOrReplaceChild("B1TendrilSplit1Seg3", CubeListBuilder.create().texOffs(14, 115).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.5F, 0.0F, -0.1745F, 0.0F, 0.0873F));

		PartDefinition B1TendrilSplit2 = B1Tendril1Seg2.addOrReplaceChild("B1TendrilSplit2", CubeListBuilder.create().texOffs(20, 291).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 15.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition B1TendrilSplit2Seg2 = B1TendrilSplit2.addOrReplaceChild("B1TendrilSplit2Seg2", CubeListBuilder.create(), PartPose.offset(0.0F, 4.5F, 0.0F));

		PartDefinition B1TendrilSplit2Seg2_r1 = B1TendrilSplit2Seg2.addOrReplaceChild("B1TendrilSplit2Seg2_r1", CubeListBuilder.create().texOffs(234, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition B1Tendril2 = B1Tendrils.addOrReplaceChild("B1Tendril2", CubeListBuilder.create().texOffs(72, 574).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 115.0F, -18.0F));

		PartDefinition B1Tendril2Seg2 = B1Tendril2.addOrReplaceChild("B1Tendril2Seg2", CubeListBuilder.create().texOffs(251, 150).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.0436F, 0.0F, -0.2182F));

		PartDefinition B1Tendril2Seg3 = B1Tendril2Seg2.addOrReplaceChild("B1Tendril2Seg3", CubeListBuilder.create().texOffs(245, 158).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition B1Tendril3 = B1Tendrils.addOrReplaceChild("B1Tendril3", CubeListBuilder.create().texOffs(72, 574).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(23.0F, 111.0F, -5.0F));

		PartDefinition EmergingBody = B1Tendril3.addOrReplaceChild("EmergingBody", CubeListBuilder.create().texOffs(76, 580).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TorsoBottom_r3 = EmergingBody.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(64, 574).addBox(-3.5F, -1.5F, -5.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Torso_r13 = EmergingBody.addOrReplaceChild("Torso_r13", CubeListBuilder.create().texOffs(67, 580).addBox(-4.0F, -2.0F, -7.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, 3.0F, -0.1745F, 0.4363F, 0.0F));

		PartDefinition Jaw_r13 = EmergingBody.addOrReplaceChild("Jaw_r13", CubeListBuilder.create().texOffs(71, 581).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, 0.4835F, 0.116F, 0.0607F));

		PartDefinition Head_r17 = EmergingBody.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(69, 573).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 5.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition B1Tendril3Seg2 = B1Tendril3.addOrReplaceChild("B1Tendril3Seg2", CubeListBuilder.create().texOffs(251, 150).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition B1Tendril3Seg3 = B1Tendril3Seg2.addOrReplaceChild("B1Tendril3Seg3", CubeListBuilder.create().texOffs(453, 469).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition B1Tendril4 = B1Tendrils.addOrReplaceChild("B1Tendril4", CubeListBuilder.create().texOffs(62, 570).addBox(-6.0F, -4.0F, -5.0F, 11.0F, 14.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 110.0F, 0.0F));

		PartDefinition B1Tendril4Seg2 = B1Tendril4.addOrReplaceChild("B1Tendril4Seg2", CubeListBuilder.create().texOffs(71, 574).addBox(-5.0F, -2.0F, -4.0F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition ARm_r16 = B1Tendril4Seg2.addOrReplaceChild("ARm_r16", CubeListBuilder.create().texOffs(396, 590).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 8.0F, 0.0F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition B1Tendril4Seg3 = B1Tendril4Seg2.addOrReplaceChild("B1Tendril4Seg3", CubeListBuilder.create().texOffs(248, 147).addBox(-4.0F, -2.0F, -3.0F, 7.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Jaw_r14 = B1Tendril4Seg3.addOrReplaceChild("Jaw_r14", CubeListBuilder.create().texOffs(399, 593).addBox(-4.0F, -1.0F, 1.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -3.5F, -0.3011F, -0.0522F, -0.1666F));

		PartDefinition Head_r18 = B1Tendril4Seg3.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(393, 587).addBox(-4.0F, 0.0F, -3.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 2.5F, 0.6646F, 0.2494F, 0.0804F));

		PartDefinition B1Tendril4Seg4 = B1Tendril4Seg3.addOrReplaceChild("B1Tendril4Seg4", CubeListBuilder.create().texOffs(448, 467).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition B1Tendril4Seg5 = B1Tendril4Seg4.addOrReplaceChild("B1Tendril4Seg5", CubeListBuilder.create().texOffs(450, 469).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition B1Tendril5 = B1Tendrils.addOrReplaceChild("B1Tendril5", CubeListBuilder.create().texOffs(61, 580).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 106.0F, 15.0F));

		PartDefinition B1Tendril5Seg2 = B1Tendril5.addOrReplaceChild("B1Tendril5Seg2", CubeListBuilder.create().texOffs(247, 148).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition B1Tendril5Seg3 = B1Tendril5Seg2.addOrReplaceChild("B1Tendril5Seg3", CubeListBuilder.create().texOffs(452, 468).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition B1Tendril5Seg4 = B1Tendril5Seg3.addOrReplaceChild("B1Tendril5Seg4", CubeListBuilder.create().texOffs(264, 155).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Back2Tip = Back1.addOrReplaceChild("Back2Tip", CubeListBuilder.create().texOffs(293, 198).addBox(-27.5F, -11.0F, 0.0F, 58.0F, 24.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(210, 120).addBox(-26.0F, -19.0F, 0.0F, 52.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(505, 426).addBox(-21.0F, -27.0F, 0.0F, 42.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(505, 426).addBox(-21.0F, 21.0F, 0.0F, 42.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(210, 120).addBox(-26.0F, 13.0F, 0.0F, 52.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(281, 385).addBox(-20.5F, -32.0F, 0.0F, 41.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 77.5F));

		PartDefinition BottomRidge_r1 = Back2Tip.addOrReplaceChild("BottomRidge_r1", CubeListBuilder.create().texOffs(323, 385).addBox(0.0F, -2.5F, -2.5F, 20.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.5F, 30.5F, 2.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition BottomRidge_r2 = Back2Tip.addOrReplaceChild("BottomRidge_r2", CubeListBuilder.create().texOffs(281, 385).addBox(-26.0F, -2.5F, -2.49F, 26.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, 30.5F, 2.5F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Back2Details = Back2Tip.addOrReplaceChild("Back2Details", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackBodyClump1 = Back2Details.addOrReplaceChild("BackBodyClump1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.25F, 4.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition TorsoLower_r5 = BackBodyClump1.addOrReplaceChild("TorsoLower_r5", CubeListBuilder.create().texOffs(377, 205).addBox(-3.5F, -0.1762F, -3.6041F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 5.7553F, -6.259F, -0.8727F, 0.0F, 0.0F));

		PartDefinition Torso_r14 = BackBodyClump1.addOrReplaceChild("Torso_r14", CubeListBuilder.create().texOffs(370, 209).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 0.9636F, -2.6135F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Arm_r17 = BackBodyClump1.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(380, 201).addBox(-5.0F, -1.1716F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.01F, 1.792F, -3.442F, -0.6331F, -0.3517F, 0.1327F));

		PartDefinition Arm_r18 = BackBodyClump1.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(376, 210).addBox(1.0F, -1.1716F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.01F, 1.792F, -3.442F, -0.7121F, 0.0206F, -0.5477F));

		PartDefinition Jaw_r15 = BackBodyClump1.addOrReplaceChild("Jaw_r15", CubeListBuilder.create().texOffs(375, 206).addBox(-4.0F, 2.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, -4.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Head_r19 = BackBodyClump1.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(362, 204).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, -1.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition BackBodyClump2 = Back2Details.addOrReplaceChild("BackBodyClump2", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -0.25F, 4.0F, 0.4415F, -0.2828F, -2.6213F));

		PartDefinition TorsoLower_r6 = BackBodyClump2.addOrReplaceChild("TorsoLower_r6", CubeListBuilder.create().texOffs(380, 207).addBox(-3.5F, -0.1762F, -3.6041F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 5.7553F, -6.259F, -0.8727F, 0.0F, 0.0F));

		PartDefinition Torso_r15 = BackBodyClump2.addOrReplaceChild("Torso_r15", CubeListBuilder.create().texOffs(374, 210).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.01F, 0.9636F, -2.6135F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Jaw_r16 = BackBodyClump2.addOrReplaceChild("Jaw_r16", CubeListBuilder.create().texOffs(362, 203).addBox(-4.0F, 2.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, -4.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Head_r20 = BackBodyClump2.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(365, 202).addBox(-4.0F, -5.0F, -1.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, -4.0F, 0.0F, 0.5672F, 0.0F));

		PartDefinition BackBodyClump3 = Back2Details.addOrReplaceChild("BackBodyClump3", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.548F, 7.2435F, 0.8018F, 0.0F, 0.0F, -0.5236F));

		PartDefinition TorsoLower_r7 = BackBodyClump3.addOrReplaceChild("TorsoLower_r7", CubeListBuilder.create().texOffs(368, 208).addBox(-3.5F, -1.0F, -5.5F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.558F, 3.4856F, 2.5851F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Torso_r16 = BackBodyClump3.addOrReplaceChild("Torso_r16", CubeListBuilder.create().texOffs(382, 209).addBox(-4.0F, -1.0F, -13.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.558F, -1.5299F, 9.5846F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Jaw_r17 = BackBodyClump3.addOrReplaceChild("Jaw_r17", CubeListBuilder.create().texOffs(366, 202).addBox(-4.0F, -0.5F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.548F, -0.7435F, 1.1982F, 1.3297F, 0.2549F, 0.798F));

		PartDefinition Head_r21 = BackBodyClump3.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(372, 205).addBox(-4.0F, -6.5F, -7.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.548F, -1.7435F, 1.1982F, -0.6981F, 0.0F, 0.0F));

		PartDefinition BackBodyClump4 = Back2Details.addOrReplaceChild("BackBodyClump4", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.548F, 7.2435F, 0.8018F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Tumor3_r8 = BackBodyClump4.addOrReplaceChild("Tumor3_r8", CubeListBuilder.create().texOffs(144, 309).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.593F, 24.3998F, 0.0101F, 1.2286F, -0.1865F, 2.174F));

		PartDefinition Tumor2_r12 = BackBodyClump4.addOrReplaceChild("Tumor2_r12", CubeListBuilder.create().texOffs(143, 306).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.782F, 23.0707F, 0.6563F, 2.014F, 0.1865F, 1.4292F));

		PartDefinition Tumor1_r12 = BackBodyClump4.addOrReplaceChild("Tumor1_r12", CubeListBuilder.create().texOffs(138, 304).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, 27.0F, 1.0F, 0.9843F, 0.3093F, 0.4295F));

		PartDefinition FungalBloom3 = Back2Tip.addOrReplaceChild("FungalBloom3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1349F, 2.4658F, 4.4893F, -1.5708F, 0.0F, 0.3054F));

		PartDefinition Plane2_r9 = FungalBloom3.addOrReplaceChild("Plane2_r9", CubeListBuilder.create().texOffs(600, 18).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r8 = FungalBloom3.addOrReplaceChild("Plane1_r8", CubeListBuilder.create().texOffs(600, 18).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, -7.831F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r9 = FungalBloom3.addOrReplaceChild("Npetal_r9", CubeListBuilder.create().texOffs(616, 0).addBox(-16.0F, -1.75F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r9 = FungalBloom3.addOrReplaceChild("Spetal_r9", CubeListBuilder.create().texOffs(616, 16).addBox(-16.0F, -1.75F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 5.3343F, 0.169F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r9 = FungalBloom3.addOrReplaceChild("Wpetal_r9", CubeListBuilder.create().texOffs(584, 16).addBox(-3.3806F, 1.9134F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9172F, 0.9663F, 0.169F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r9 = FungalBloom3.addOrReplaceChild("Epetal_r9", CubeListBuilder.create().texOffs(568, 0).addBox(-12.6194F, 1.9134F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9472F, 0.9663F, 0.169F, 0.0F, 0.0F, 0.7854F));

		PartDefinition B1SBodies = Back1.addOrReplaceChild("B1SBodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition B1SBody1 = B1SBodies.addOrReplaceChild("B1SBody1", CubeListBuilder.create(), PartPose.offset(43.0F, 27.0F, 11.0F));

		PartDefinition Head_r22 = B1SBody1.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5729F, -4.5947F, 3.0F, -3.1416F, 0.0F, -2.7053F));

		PartDefinition B1SBody2 = B1SBodies.addOrReplaceChild("B1SBody2", CubeListBuilder.create(), PartPose.offset(34.0F, 18.0F, 57.0F));

		PartDefinition TorsoBottom_r4 = B1SBody2.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(190, 363).addBox(-3.0F, -3.5F, -1.0F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7692F, -3.4558F, 6.7977F, -0.5106F, -0.6486F, 0.8193F));

		PartDefinition Arm_r19 = B1SBody2.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(198, 356).addBox(-1.535F, -4.3692F, -0.6577F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4821F, -7.1733F, 3.6172F, 0.259F, -0.5872F, 0.4723F));

		PartDefinition Torso_r17 = B1SBody2.addOrReplaceChild("Torso_r17", CubeListBuilder.create().texOffs(187, 354).addBox(-4.8126F, -4.899F, -0.0157F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7939F, -2.9241F, 1.6085F, -0.4144F, -0.2564F, 0.6041F));

		PartDefinition JAW_r18 = B1SBody2.addOrReplaceChild("JAW_r18", CubeListBuilder.create().texOffs(209, 360).addBox(-4.0F, -4.0F, -1.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3737F, -1.245F, 1.9099F, -0.2613F, -0.0114F, 0.3498F));

		PartDefinition Head_r23 = B1SBody2.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(193, 359).addBox(-4.0F, -4.0F, -8.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3615F, -4.1415F, 2.5F, -0.5672F, 0.0F, 0.4363F));

		PartDefinition B1SBody3 = B1SBodies.addOrReplaceChild("B1SBody3", CubeListBuilder.create(), PartPose.offset(51.0F, -15.0F, 16.0F));

		PartDefinition Arm_r20 = B1SBody3.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(196, 361).addBox(-1.5774F, -1.4836F, 0.0687F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0523F, 1.1095F, 11.6444F, -0.9163F, 0.0F, -0.4363F));

		PartDefinition TorsoBottom_r5 = B1SBody3.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(198, 354).addBox(-6.15F, -3.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.3549F, -7.7872F, 42.3273F, -0.7317F, -0.2009F, -0.3643F));

		PartDefinition Torso_r18 = B1SBody3.addOrReplaceChild("Torso_r18", CubeListBuilder.create().texOffs(198, 360).addBox(-2.0F, -4.0F, -4.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.4644F, -9.9449F, 31.7021F, -0.2618F, 0.0F, -0.4363F));

		PartDefinition Head_r24 = B1SBody3.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(195, 357).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 3.0F, 0.3491F, 0.0F, -0.4363F));

		PartDefinition B1SBody4 = B1SBodies.addOrReplaceChild("B1SBody4", CubeListBuilder.create(), PartPose.offset(6.0F, -32.0F, 63.0F));

		PartDefinition Leg_r9 = B1SBody4.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(193, 364).addBox(-3.5F, -3.0F, -10.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9948F, 4.9567F, 7.6761F, -0.3424F, 0.3861F, -0.1544F));

		PartDefinition TorsoBottom_r6 = B1SBody4.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(205, 362).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9948F, 4.9567F, 7.6761F, 0.4536F, -0.1758F, -0.195F));

		PartDefinition Arm_r21 = B1SBody4.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(190, 361).addBox(-3.2385F, -2.8533F, -1.6851F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -0.342F, 12.9397F, -0.0062F, -0.609F, -0.2567F));

		PartDefinition Arm_r22 = B1SBody4.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(199, 355).addBox(0.0F, -2.8533F, -0.4969F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.342F, 12.9397F, 0.3604F, 0.2457F, 0.0914F));

		PartDefinition Torso_r19 = B1SBody4.addOrReplaceChild("Torso_r19", CubeListBuilder.create().texOffs(193, 358).addBox(-3.0F, -1.9136F, -4.8389F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 12.0F, 0.8463F, -0.1758F, -0.195F));

		PartDefinition Teeth_r6 = B1SBody4.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(0, 133).addBox(-4.0F, 2.0F, 2.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 15.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Head_r25 = B1SBody4.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.7516F, 15.4267F, 1.5708F, 1.2217F, 1.5708F));

		PartDefinition B1SBody5 = B1SBodies.addOrReplaceChild("B1SBody5", CubeListBuilder.create(), PartPose.offsetAndRotation(17.0F, -42.0F, 34.0F, -1.4037F, -1.3055F, 1.4094F));

		PartDefinition Leg_r10 = B1SBody5.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(194, 355).addBox(1.5F, -3.0F, -9.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9948F, 4.9567F, 7.6761F, 0.0066F, 0.3861F, -0.1544F));

		PartDefinition TorsoBottom_r7 = B1SBody5.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(199, 360).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9948F, 4.9567F, 7.6761F, 0.4507F, 0.1388F, -0.0431F));

		PartDefinition Arm_r23 = B1SBody5.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(201, 357).addBox(0.0F, -2.8533F, -0.4969F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -0.342F, 12.9397F, -0.4842F, 0.8561F, 0.0631F));

		PartDefinition Torso_r20 = B1SBody5.addOrReplaceChild("Torso_r20", CubeListBuilder.create().texOffs(197, 359).addBox(-3.0F, -1.9136F, -4.8389F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 12.0F, 0.8463F, -0.1758F, -0.195F));

		PartDefinition Teeth_r7 = B1SBody5.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(200, 363).addBox(-4.0F, 2.0F, -3.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 15.0F, 0.2072F, -0.0886F, 0.2467F));

		PartDefinition Head_r26 = B1SBody5.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.7516F, 15.4267F, 1.5708F, 1.2217F, 1.5708F));

		PartDefinition B1SBody6 = B1SBodies.addOrReplaceChild("B1SBody6", CubeListBuilder.create(), PartPose.offsetAndRotation(-48.9835F, 12.7253F, 19.3237F, -0.8335F, 0.2975F, 0.2602F));

		PartDefinition Leg_r11 = B1SBody6.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(196, 359).addBox(-0.7702F, -1.5203F, 0.8627F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7527F, -1.1812F, 6.474F, 0.0664F, 0.8228F, -0.8049F));

		PartDefinition TorsoBottom_r8 = B1SBody6.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(204, 363).addBox(-2.0F, -3.5F, -1.0F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7527F, -0.1812F, 3.474F, -0.5106F, 0.6486F, -0.8193F));

		PartDefinition Torso_r21 = B1SBody6.addOrReplaceChild("Torso_r21", CubeListBuilder.create().texOffs(196, 359).addBox(-1.1874F, -4.899F, -0.0157F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8104F, 0.3505F, -1.7152F, -0.4144F, 0.2564F, -0.6041F));

		PartDefinition Head_r27 = B1SBody6.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(0, 326).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3999F, -3.0582F, -4.619F, 0.8166F, 0.2415F, -0.5385F));

		PartDefinition B1TumoralClump1 = B1SBodies.addOrReplaceChild("B1TumoralClump1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor3_r9 = B1TumoralClump1.addOrReplaceChild("Tumor3_r9", CubeListBuilder.create().texOffs(148, 311).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.1311F, 18.5737F, 66.521F, -1.3844F, 0.592F, 0.115F));

		PartDefinition Tumor2_r13 = B1TumoralClump1.addOrReplaceChild("Tumor2_r13", CubeListBuilder.create().texOffs(149, 312).addBox(-2.5F, -1.5F, -0.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-33.02F, 13.466F, 63.6373F, -0.6924F, 0.8056F, 0.1729F));

		PartDefinition Tumor1_r13 = B1TumoralClump1.addOrReplaceChild("Tumor1_r13", CubeListBuilder.create().texOffs(147, 310).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.0F, 18.0F, 63.0F, -0.3999F, 0.6956F, -0.583F));

		PartDefinition B1SBody7 = B1SBodies.addOrReplaceChild("B1SBody7", CubeListBuilder.create(), PartPose.offset(-48.0F, -14.0F, 16.0F));

		PartDefinition Arm_r24 = B1SBody7.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(190, 359).addBox(-1.0F, -2.0F, -4.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.561F, -3.4388F, 51.8251F, -1.5263F, 0.5351F, 0.9086F));

		PartDefinition Arm_r25 = B1SBody7.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(194, 361).addBox(-5.4226F, 6.5164F, -6.9313F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0523F, 1.1095F, 11.6444F, -0.9163F, 0.0F, 0.4363F));

		PartDefinition TorsoBottom_r9 = B1SBody7.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(198, 363).addBox(1.15F, -3.0F, -3.0F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3549F, -7.7872F, 22.3273F, -0.7317F, 0.2009F, 0.3643F));

		PartDefinition Torso_r22 = B1SBody7.addOrReplaceChild("Torso_r22", CubeListBuilder.create().texOffs(204, 361).addBox(-4.0F, -4.0F, -4.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.4644F, -9.9449F, 11.7021F, -0.2618F, 0.0F, 0.4363F));

		PartDefinition Head_r28 = B1SBody7.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(191, 358).addBox(4.0F, 0.0F, 28.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition B1TumoralClump = B1SBodies.addOrReplaceChild("B1TumoralClump", CubeListBuilder.create(), PartPose.offset(-12.0F, 30.0F, 56.0F));

		PartDefinition Tumor3_r10 = B1TumoralClump.addOrReplaceChild("Tumor3_r10", CubeListBuilder.create().texOffs(143, 310).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0156F, 1.1642F, -3.2754F, 1.0592F, 0.0327F, 0.9572F));

		PartDefinition Tumor2_r14 = B1TumoralClump.addOrReplaceChild("Tumor2_r14", CubeListBuilder.create().texOffs(143, 309).addBox(-4.0F, -3.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6143F, -2.1156F, 4.523F, 1.1269F, -0.4703F, 0.3683F));

		PartDefinition Tumor1_r14 = B1TumoralClump.addOrReplaceChild("Tumor1_r14", CubeListBuilder.create().texOffs(142, 307).addBox(-4.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.5672F, 0.0F, 0.6981F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLip.zRot = 0.3f + Mth.sin(ageInTicks/10)/8;
		this.RightLip.zRot = -0.3f - Mth.sin(ageInTicks/10)/8;
		this.LeftNsplit.zRot = Mth.sin(ageInTicks/8)/6;
		this.LeftSsplit.zRot = Mth.sin(ageInTicks/8)/6;
		this.LeftNsplit2.zRot = Mth.sin(ageInTicks/8)/5;
		this.RightNsplit.zRot = -Mth.sin(ageInTicks/8)/6;
		this.RightSsplit.zRot = -Mth.sin(ageInTicks/8)/5;
		this.RightNsplit.getChild("RNJSBase1").xRot = Mth.sin(ageInTicks/10)/8;
		this.RightNsplit.getChild("RNJSBase2").xRot = -Mth.sin(ageInTicks/10)/8;
		this.LeftNsplit2.getChild("LNJSSeg2").zRot = Mth.sin(ageInTicks/6)/6;

		this.RightTumor.xScale = 1 + Mth.sin(ageInTicks/6)/8;
		this.RightTumor.yScale = 1 + Mth.sin(ageInTicks/7)/6;
		this.RightTumor.zScale = 1 + Mth.sin(ageInTicks/6)/7;
		this.LeftTumor.xScale = 1 + Mth.sin(ageInTicks/6)/7;
		this.LeftTumor.yScale = 1 + Mth.sin(ageInTicks/6)/6;
		this.LeftTumor.zScale = 1 + Mth.sin(ageInTicks/7)/6;

		this.RightCannon.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.LeftCannon.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.FrontTendril1.xRot = Mth.sin(ageInTicks/5)/4;
		this.FrontTendril2.xRot = Mth.cos(ageInTicks/6)/4;
		this.FrontTendril3.xRot = Mth.sin(ageInTicks/6)/3;
		this.FrontTendril3.zRot = Mth.sin(ageInTicks/7)/6;
		this.FrontTendril4.xRot = Mth.sin(ageInTicks/5)/4;

		this.BackTendrils1.xRot = Mth.sin(ageInTicks/5)/5;
		this.BackTendrils2.xRot = Mth.sin(ageInTicks/6)/5;
		this.BackTendrils3.getChild("B1Tendril3Seg2").xRot = Mth.sin(ageInTicks/7)/5;
		this.BackTendrils4.xRot = Mth.sin(ageInTicks/6)/4;
		this.BackTendrils4.zRot = -Mth.sin(ageInTicks/6)/8;
		this.BackTendrils5.xRot = Mth.sin(ageInTicks/7)/5;
		this.BackTendrils5.zRot = Mth.sin(ageInTicks/7)/7;
		this.BackTendrils1.getChild("B1Tendril1Seg2").xRot = Mth.sin(ageInTicks/5)/5;
		this.BackTendrils1.getChild("B1Tendril1Seg2").getChild("B1TendrilSplit1").xRot = Mth.sin(ageInTicks/6)/5;
		this.BackTendrils1.getChild("B1Tendril1Seg2").getChild("B1TendrilSplit2").xRot = -Mth.sin(ageInTicks/6)/5;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hindie.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}