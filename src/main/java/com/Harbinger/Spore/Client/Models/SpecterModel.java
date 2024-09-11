package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.Specter;
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

public class SpecterModel<T extends Specter> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "specter"), "main");
	private final ModelPart MrToucher;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftFoot;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart Tentacle1Seg1;
	private final ModelPart Tentacle1Seg2;
	private final ModelPart Tentacle1Seg3;
	private final ModelPart Tentacle2Seg1;
	private final ModelPart Tentacle2Seg2;
	private final ModelPart Tentacle2Seg3;
	private final ModelPart Tentacle3Seg1;
	private final ModelPart Tentacle3Seg2;
	private final ModelPart Tentacle3Seg3;
	private final ModelPart Tentacle4Seg1;
	private final ModelPart Tentacle4Seg2;
	private final ModelPart Tentacle4Seg3;
	private final ModelPart Tentacle5Seg1;
	private final ModelPart Tentacle5Seg2;
	private final ModelPart Tentacle5Seg3;
	private final ModelPart Tentacle6Seg1;
	private final ModelPart Tentacle6Seg2;
	private final ModelPart Tentacle6Seg3;
	private final ModelPart Tentacle7Seg1;
	private final ModelPart Tentacle7Seg2;
	private final ModelPart Tentacle7Seg3;
	private final ModelPart Tentacle8Seg1;
	private final ModelPart Tentacle8Seg2;
	private final ModelPart Tentacle8Seg3;
	private final ModelPart Tentacle9Seg1;
	private final ModelPart Tentacle9Seg2;
	private final ModelPart Tentacle9Seg3;
	private final ModelPart Tumor1;
	private final ModelPart Tumor2;

	public SpecterModel(ModelPart root) {
		this.MrToucher = root.getChild("MrToucher");
		this.Torso = MrToucher.getChild("LowerTorso").getChild("MiddleTorso");
		this.RightLeg = MrToucher.getChild("Legs").getChild("RightLegJoint");
		this.LeftLeg = MrToucher.getChild("Legs").getChild("LeftLegJoint");
		this.RightFoot = RightLeg.getChild("RightLeg").getChild("RightLegSeg2");
		this.LeftFoot = LeftLeg.getChild("LeftLeg").getChild("LeftLegSeg2");
		this.Head = Torso.getChild("TopTorso").getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.LeftArm = Torso.getChild("LeftArmJoint");
		this.LeftForArm = LeftArm.getChild("LeftArm").getChild("LeftArmSeg2Joint");
		this.RightArm = Torso.getChild("TopTorso").getChild("RightArmJoint");
		this.RightForArm = RightArm.getChild("RightArm").getChild("RightArmJoint2Seg");
		this.Tentacle1Seg1 = MrToucher.getChild("LowerTorso").getChild("LowerTorsoTendrils").getChild("Tendril1");
		this.Tentacle1Seg2 = Tentacle1Seg1.getChild("Seg2Tendril1");
		this.Tentacle1Seg3 = Tentacle1Seg2.getChild("Seg3Tendril1");
		this.Tentacle2Seg1 = MrToucher.getChild("LowerTorso").getChild("LowerTorsoTendrils").getChild("Tendril2");
		this.Tentacle2Seg2 = Tentacle2Seg1.getChild("Seg2Tendril2");
		this.Tentacle2Seg3 = Tentacle2Seg2.getChild("Seg3Tendril2");
		this.Tentacle3Seg1 = MrToucher.getChild("LowerTorso").getChild("LowerTorsoTendrils").getChild("Tendril3");
		this.Tentacle3Seg2 = Tentacle3Seg1.getChild("Seg2Tendril3");
		this.Tentacle3Seg3 = Tentacle3Seg2.getChild("Seg3Tendril3");
		this.Tentacle4Seg1 = MrToucher.getChild("LowerTorso").getChild("LowerTorsoTendrils").getChild("Tendril4");
		this.Tentacle4Seg2 = Tentacle4Seg1.getChild("Seg2Tendril4");
		this.Tentacle4Seg3 = Tentacle4Seg2.getChild("Seg3Tendril4");
		this.Tentacle5Seg1 = Torso.getChild("MiddleTorsoTendrils").getChild("Tendril5");
		this.Tentacle5Seg2 = Tentacle5Seg1.getChild("Seg2Tendril5");
		this.Tentacle5Seg3 = Tentacle5Seg2.getChild("Seg3Tendril5");
		this.Tentacle6Seg1 = Torso.getChild("MiddleTorsoTendrils").getChild("Tendril6");
		this.Tentacle6Seg2 = Tentacle6Seg1.getChild("Seg2Tendril6");
		this.Tentacle6Seg3 = Tentacle6Seg2.getChild("Seg3Tendril6");
		this.Tentacle7Seg1 = Torso.getChild("MiddleTorsoTendrils").getChild("Tendril7");
		this.Tentacle7Seg2 = Tentacle7Seg1.getChild("Seg2Tendril7");
		this.Tentacle7Seg3 = Tentacle7Seg2.getChild("Seg3Tendril7");
		this.Tentacle8Seg1 = Torso.getChild("MiddleTorsoTendrils").getChild("Tendril8");
		this.Tentacle8Seg2 = Tentacle8Seg1.getChild("Seg2Tendril8");
		this.Tentacle8Seg3 = Tentacle8Seg2.getChild("Seg3Tendril8");
		this.Tentacle9Seg1 = Torso.getChild("MiddleTorsoTendrils").getChild("Tendril9");
		this.Tentacle9Seg2 = Tentacle9Seg1.getChild("Seg2Tendril9");
		this.Tentacle9Seg3 = Tentacle9Seg2.getChild("Seg3Tendril9");
		this.Tumor1 = MrToucher.getChild("LowerTorso").getChild("LowerTorsoTumor");
		this.Tumor2 = Torso.getChild("MiddleTorsoTumor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MrToucher = partdefinition.addOrReplaceChild("MrToucher", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Legs = MrToucher.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 4.0F));

		PartDefinition LeftLegJoint = Legs.addOrReplaceChild("LeftLegJoint", CubeListBuilder.create(), PartPose.offset(4.0F, -1.0F, 0.0F));

		PartDefinition LeftLeg = LeftLegJoint.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(51, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(35, 71).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, -0.2618F, 0.0F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create().texOffs(0, 76).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition LeftLegSeg3 = LeftLegSeg2.addOrReplaceChild("LeftLegSeg3", CubeListBuilder.create().texOffs(16, 97).addBox(-1.0F, -1.0F, 0.0F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 2.0F, 7.0F));

		PartDefinition LeftLegFungus = LeftLegSeg2.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0593F, 1.1608F, 1.6525F, 1.8762F, 0.0F, 0.0F));

		PartDefinition Fungus_r1 = LeftLegFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 121).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.1475F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r2 = LeftLegFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5593F, -0.2108F, -2.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightLegJoint = Legs.addOrReplaceChild("RightLegJoint", CubeListBuilder.create(), PartPose.offset(-3.0F, -1.0F, 2.0F));

		PartDefinition RightLeg = RightLegJoint.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(51, 77).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(35, 71).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.3054F, 0.0F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(0, 76).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition RightLegSeg3 = RightLegSeg2.addOrReplaceChild("RightLegSeg3", CubeListBuilder.create().texOffs(16, 97).mirror().addBox(-2.0F, -1.0F, 0.0F, 3.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 2.0F, 7.0F));

		PartDefinition RightLegFungus = RightLeg.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(-2.0593F, 7.1608F, 0.6525F));

		PartDefinition Fungus_r3 = RightLegFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 107).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r4 = RightLegFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r5 = RightLegFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 121).addBox(-2.25F, -5.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r6 = RightLegFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LowerTorso = MrToucher.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(36, 0).addBox(-5.5F, -4.0F, -3.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.01F))
		.texOffs(0, 27).addBox(-5.5F, -4.0F, -3.0F, 10.0F, 10.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, -23.25F, 3.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LowerChestFungus = LowerTorso.addOrReplaceChild("LowerChestFungus", CubeListBuilder.create(), PartPose.offset(0.5593F, 0.4108F, -0.8475F));

		PartDefinition Fungus_r7 = LowerChestFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 121).addBox(-5.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4407F, -1.7108F, -1.1025F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r8 = LowerChestFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4407F, 0.7892F, 2.8975F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r9 = LowerChestFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3702F, 2.2607F, -2.0283F, 0.038F, -0.7157F, 0.187F));

		PartDefinition Fungus_r10 = LowerChestFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 107).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4407F, 1.7892F, -3.1025F, 0.1783F, 0.2977F, 0.0909F));

		PartDefinition MiddleTorso = LowerTorso.addOrReplaceChild("MiddleTorso", CubeListBuilder.create().texOffs(0, 14).addBox(-6.0F, -5.0F, -3.5F, 11.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -5.0F, -3.5F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition MiddleTorsoTendrils = MiddleTorso.addOrReplaceChild("MiddleTorsoTendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, -0.5F));

		PartDefinition Tendril5 = MiddleTorsoTendrils.addOrReplaceChild("Tendril5", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8837F, -1.5557F, 2.2892F, -0.7846F, 0.1154F, -0.9707F));

		PartDefinition Seg2Tendril5 = Tendril5.addOrReplaceChild("Seg2Tendril5", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Seg3Tendril5 = Seg2Tendril5.addOrReplaceChild("Seg3Tendril5", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, -8.3197F, -0.0142F, -0.0076F, 0.043F, 0.7416F));

		PartDefinition Tendril6 = MiddleTorsoTendrils.addOrReplaceChild("Tendril6", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8837F, -3.5557F, 2.2892F, -0.7579F, 0.2539F, 1.3449F));

		PartDefinition Seg2Tendril6 = Tendril6.addOrReplaceChild("Seg2Tendril6", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Seg3Tendril6 = Seg2Tendril6.addOrReplaceChild("Seg3Tendril6", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Tendril7 = MiddleTorsoTendrils.addOrReplaceChild("Tendril7", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8837F, -1.9443F, 2.7892F, 1.0349F, -0.2284F, -0.9036F));

		PartDefinition Seg2Tendril7 = Tendril7.addOrReplaceChild("Seg2Tendril7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0138F, 3.9634F, -0.0145F, 0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r1 = Seg2Tendril7.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg3Tendril7 = Seg2Tendril7.addOrReplaceChild("Seg3Tendril7", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, 4.3197F, -0.0142F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Tendril8 = MiddleTorsoTendrils.addOrReplaceChild("Tendril8", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3042F, -4.4491F, 2.8877F, 1.5145F, -0.2508F, 0.9302F));

		PartDefinition TendrilSegment_r2 = Tendril8.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril8 = Tendril8.addOrReplaceChild("Seg2Tendril8", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 6.9634F, -0.0145F, 0.0F, 0.0F, 0.7854F));

		PartDefinition TendrilSegment_r3 = Seg2Tendril8.addOrReplaceChild("TendrilSegment_r3", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril8 = Seg2Tendril8.addOrReplaceChild("Seg3Tendril8", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 4.3197F, -0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril9 = MiddleTorsoTendrils.addOrReplaceChild("Tendril9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6958F, -2.4491F, -2.8877F, -2.0937F, -0.3843F, 0.8259F));

		PartDefinition TendrilSegment_r4 = Tendril9.addOrReplaceChild("TendrilSegment_r4", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril9 = Tendril9.addOrReplaceChild("Seg2Tendril9", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 6.9634F, 0.0145F, 0.0F, 0.0F, 0.7854F));

		PartDefinition TendrilSegment_r5 = Seg2Tendril9.addOrReplaceChild("TendrilSegment_r5", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril9 = Seg2Tendril9.addOrReplaceChild("Seg3Tendril9", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition TopTorso = MiddleTorso.addOrReplaceChild("TopTorso", CubeListBuilder.create().texOffs(0, 46).addBox(-4.5F, -6.0F, -3.0F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, 1.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Head = TopTorso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 19).addBox(-4.0F, -6.9641F, -1.134F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 35).addBox(-4.0F, -6.9641F, -1.134F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -6.9641F, 0.3301F, 0.5236F, 0.0F, 0.0F));

		PartDefinition UpperJawTeeth = Head.addOrReplaceChild("UpperJawTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, -5.2141F, -1.5263F));

		PartDefinition Plane_r1 = UpperJawTeeth.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(5, 43).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1656F, 1.7869F, -0.3267F, 2.6986F, -0.1209F, -1.1751F));

		PartDefinition Plane_r2 = UpperJawTeeth.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(5, 43).addBox(-2.5F, 0.0F, -1.0F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8424F, 1.5847F, -0.8659F, 2.9604F, 0.1209F, 1.1751F));

		PartDefinition Plane_r3 = UpperJawTeeth.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(0, 43).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.126F, -0.7941F, -0.3707F, -3.0138F, -0.0283F, -2.9252F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(38, 51).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(78, 19).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(82, 0).addBox(-4.0F, -5.0F, -5.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0359F, -1.134F));

		PartDefinition LowerJawTeeth = Jaw.addOrReplaceChild("LowerJawTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, -3.5F, -3.0F));

		PartDefinition Plane_r4 = LowerJawTeeth.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(4, 43).addBox(-3.8638F, -1.7791F, -1.125F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.4464F, 0.625F, 0.0381F, 0.1704F, -1.3494F));

		PartDefinition Plane_r5 = LowerJawTeeth.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(4, 43).mirror().addBox(-0.9823F, -1.3655F, -1.125F, 5.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.25F, 0.9464F, 0.875F, 0.1186F, -0.1284F, 0.8214F));

		PartDefinition Plane_r6 = LowerJawTeeth.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(0, 43).addBox(-3.8357F, -0.932F, -1.375F, 8.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4464F, 1.125F, 0.1719F, 0.0302F, -0.1719F));

		PartDefinition HeadFlower = Head.addOrReplaceChild("HeadFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0827F, -1.5832F, 5.1164F, -1.715F, -0.4323F, 0.0608F));

		PartDefinition cube_r1 = HeadFlower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-7, 107).addBox(-3.14F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = HeadFlower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-7, 121).addBox(-7.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r3 = HeadFlower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.14F, 0.0F, -8.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = HeadFlower.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 107).addBox(1.0F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition RightArmJoint = TopTorso.addOrReplaceChild("RightArmJoint", CubeListBuilder.create(), PartPose.offset(-3.5F, -4.5F, -0.5F));

		PartDefinition RightArm = RightArmJoint.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(51, 71).addBox(-10.5F, -1.0F, -1.0F, 11.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.829F, 0.0F));

		PartDefinition RightArmJoint2Seg = RightArm.addOrReplaceChild("RightArmJoint2Seg", CubeListBuilder.create(), PartPose.offset(-10.5F, 0.5F, 0.5F));

		PartDefinition RightArmSeg2 = RightArmJoint2Seg.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(74, 14).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2351F, -0.5692F, -0.4181F));

		PartDefinition RightClaw = RightArmSeg2.addOrReplaceChild("RightClaw", CubeListBuilder.create(), PartPose.offset(-11.0F, 0.0F, 0.0F));

		PartDefinition RightClawPlane1 = RightClaw.addOrReplaceChild("RightClawPlane1", CubeListBuilder.create().texOffs(99, 18).addBox(-6.0F, -3.0F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, -0.3035F, 0.3185F));

		PartDefinition RightClawPlane2 = RightClaw.addOrReplaceChild("RightClawPlane2", CubeListBuilder.create().texOffs(99, 18).addBox(-6.0F, -3.0F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7363F, 0.3035F, 0.3185F));

		PartDefinition RightClawPlane3 = RightClaw.addOrReplaceChild("RightClawPlane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7363F, -0.3035F, -0.3185F));

		PartDefinition ClawPlane_r1 = RightClawPlane3.addOrReplaceChild("ClawPlane_r1", CubeListBuilder.create().texOffs(99, 18).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition RightClawPlane4 = RightClaw.addOrReplaceChild("RightClawPlane4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, 0.3035F, -0.3185F));

		PartDefinition ClawPlane_r2 = RightClawPlane4.addOrReplaceChild("ClawPlane_r2", CubeListBuilder.create().texOffs(99, 18).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition LeftArmJoint = MiddleTorso.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create(), PartPose.offset(3.5F, -4.0F, 0.0F));

		PartDefinition LeftArm = LeftArmJoint.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(53, 71).mirror().addBox(-0.5F, -1.0F, -1.0F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3253F, 0.8731F, 0.4146F));

		PartDefinition LeftArmSeg2Joint = LeftArm.addOrReplaceChild("LeftArmSeg2Joint", CubeListBuilder.create(), PartPose.offset(8.5F, 0.5F, 0.5F));

		PartDefinition LeftArmSeg2 = LeftArmSeg2Joint.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(77, 14).addBox(0.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3295F, 0.7268F, 0.4754F));

		PartDefinition LeftClaw = LeftArmSeg2.addOrReplaceChild("LeftClaw", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, 0.0F));

		PartDefinition LeftClawPlane1 = LeftClaw.addOrReplaceChild("LeftClawPlane1", CubeListBuilder.create().texOffs(99, 18).mirror().addBox(-1.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, 0.3035F, -0.3185F));

		PartDefinition LeftClawPlane2 = LeftClaw.addOrReplaceChild("LeftClawPlane2", CubeListBuilder.create().texOffs(99, 18).mirror().addBox(-1.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7363F, -0.3035F, -0.3185F));

		PartDefinition LeftClawPlane3 = LeftClaw.addOrReplaceChild("LeftClawPlane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7363F, 0.3035F, 0.3185F));

		PartDefinition ClawPlane_r3 = LeftClawPlane3.addOrReplaceChild("ClawPlane_r3", CubeListBuilder.create().texOffs(99, 18).mirror().addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition LeftClawPlane4 = LeftClaw.addOrReplaceChild("LeftClawPlane4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, -0.3035F, 0.3185F));

		PartDefinition ClawPlane_r4 = LeftClawPlane4.addOrReplaceChild("ClawPlane_r4", CubeListBuilder.create().texOffs(99, 18).mirror().addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition MiddleTorsoTumor = MiddleTorso.addOrReplaceChild("MiddleTorsoTumor", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.8534F, 0.0678F, -0.5178F, -1.0908F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(3, 61).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2252F, 0.3659F, 1.2435F, 1.3008F, 0.2365F, 0.5037F));

		PartDefinition Tumor_r2 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(0, 63).addBox(0.0F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3534F, -2.3178F, 2.0178F, 0.5672F, 0.48F, 0.0F));

		PartDefinition Tumor_r3 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(3, 61).addBox(0.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6466F, -6.8178F, 1.0178F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition Tumor_r4 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(3, 59).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0202F, 0.7146F, 0.1269F, -0.5797F, 0.6921F, 1.2857F));

		PartDefinition Tumor_r5 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(3, 61).addBox(0.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3534F, -2.8178F, 2.0178F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition Tumor_r6 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6466F, -3.8178F, 0.0178F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition Tumor_r7 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(3, 61).addBox(0.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3534F, -0.8178F, 2.0178F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition Tumor_r8 = MiddleTorsoTumor.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6466F, -0.8178F, 2.0178F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition MiddleChestFungus = MiddleTorso.addOrReplaceChild("MiddleChestFungus", CubeListBuilder.create(), PartPose.offset(-1.5593F, -2.5892F, -1.8475F));

		PartDefinition Fungus_r11 = MiddleChestFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 107).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.7108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r12 = MiddleChestFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 107).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4407F, 0.7892F, 2.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r13 = MiddleChestFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 114).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 2.2607F, -2.0283F, 0.038F, 0.7157F, -0.187F));

		PartDefinition Fungus_r14 = MiddleChestFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 107).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LowerTorsoTumor = LowerTorso.addOrReplaceChild("LowerTorsoTumor", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8534F, -2.5678F, 3.5178F, -1.0908F, 0.0F, 0.0F));

		PartDefinition Tumor_r9 = LowerTorsoTumor.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(3, 60).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.2252F, -0.3659F, -1.2435F, 1.3008F, 0.2365F, 0.5037F));

		PartDefinition Tumor_r10 = LowerTorsoTumor.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(3, 60).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3534F, 2.3178F, -2.0178F, 0.5672F, 0.48F, 0.0F));

		PartDefinition Tumor_r11 = LowerTorsoTumor.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(3, 60).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6466F, 3.8178F, -1.0178F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition Tumor_r12 = LowerTorsoTumor.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(2, 59).addBox(-5.0F, -5.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3966F, 5.8178F, -4.0178F, -0.4531F, 0.272F, 1.5514F));

		PartDefinition Tumor_r13 = LowerTorsoTumor.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(3, 60).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3534F, 2.8178F, -2.0178F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition Tumor_r14 = LowerTorsoTumor.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(0, 57).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6466F, 3.8178F, -0.0178F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition Tumor_r15 = LowerTorsoTumor.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(3, 60).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3534F, 3.8178F, -2.0178F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition Tumor_r16 = LowerTorsoTumor.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(0, 57).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1737F, 3.231F, 2.2087F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition LowerTorsoTendrils = LowerTorso.addOrReplaceChild("LowerTorsoTendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril1 = LowerTorsoTendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8837F, -1.5557F, 2.2892F, -1.0225F, 0.6614F, 0.3272F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition Tendril2 = LowerTorsoTendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8837F, -0.9443F, 2.2892F, 1.2613F, 1.0309F, 2.7799F));

		PartDefinition TendrilSegment_r6 = Tendril2.addOrReplaceChild("TendrilSegment_r6", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 5.9634F, -0.0145F, 0.0F, 0.0F, 0.829F));

		PartDefinition TendrilSegment_r7 = Seg2Tendril2.addOrReplaceChild("TendrilSegment_r7", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 6.3197F, -0.0142F, 0.0F, 0.0F, -0.9163F));

		PartDefinition Tendril3 = LowerTorsoTendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.8837F, -0.9443F, -2.2892F, -1.0234F, 0.2993F, 1.2151F));

		PartDefinition TendrilSegment_r8 = Tendril3.addOrReplaceChild("TendrilSegment_r8", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 3.9634F, 0.0145F, -0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r9 = Seg2Tendril3.addOrReplaceChild("TendrilSegment_r9", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril4 = LowerTorsoTendrils.addOrReplaceChild("Tendril4", CubeListBuilder.create().texOffs(56, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8837F, -1.5557F, 1.7892F, -0.8323F, 0.5328F, -0.2034F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(64, 12).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(106, 0).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, -8.3197F, -0.0142F, -0.0421F, -0.0113F, -0.9161F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float headRot = netHeadYaw / (180F / (float) Math.PI);
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * -0.6F * limbSwingAmount;
		this.LeftLeg.xRot = -this.RightLeg.xRot;
		this.RightFoot.xRot = RightLeg.xRot * 0.6f;
		this.LeftFoot.xRot = LeftLeg.xRot * 0.6f;
		this.Torso.yRot = headRot*0.35f;
		this.Head.yRot = headRot*0.8f;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			float armM = Mth.sin(limbSwing * 0.4F) * 0.4F * limbSwingAmount;
			this.RightArm.xRot = armM * 0.5f;
			this.RightArm.yRot = armM;
			this.RightForArm.yRot = armM*0.6f;
			this.LeftArm.xRot = -armM * 0.7f;
			this.LeftArm.yRot = armM * 0.8f;
			this.LeftForArm.yRot = LeftArm.yRot * 0.6f;
		}else{
			float value = Mth.sin(ageInTicks/6)/5;
			this.RightArm.yRot = value;
			this.RightForArm.yRot = RightArm.yRot*0.6f;
			this.LeftArm.yRot = -value * 0.8f;
			this.LeftForArm.yRot = LeftArm.yRot * 0.6f;
		}
		this.Jaw.xRot = Mth.sin(ageInTicks/8)/6;
		this.Jaw.yRot = Mth.sin(ageInTicks/8)/8;
		this.animateTentacleY(Tentacle1Seg1,Mth.sin(ageInTicks/6)/6);
		this.animateTentacleX(Tentacle1Seg1,Mth.sin(ageInTicks/5)/4);
		this.animateTentacleZ(Tentacle1Seg2,Mth.sin(ageInTicks/6)/5);
		this.animateTentacleZ(Tentacle1Seg3,Mth.sin(ageInTicks/5)/4);
		this.animateTentacleX(Tentacle2Seg1,Mth.sin(ageInTicks/6)/6);
		this.animateTentacleY(Tentacle2Seg1,Mth.cos(ageInTicks/5)/3);
		this.animateTentacleZ(Tentacle2Seg2,Mth.sin(ageInTicks/7)/5);
		this.animateTentacleZ(Tentacle2Seg3,Mth.cos(ageInTicks/4)/4);
		this.animateTentacleY(Tentacle3Seg1,Mth.cos(ageInTicks/5)/4);
		this.animateTentacleZ(Tentacle3Seg2,Mth.cos(ageInTicks/5)/3);
		this.animateTentacleZ(Tentacle3Seg3,Mth.cos(ageInTicks/5)/3);
		this.animateTentacleY(Tentacle4Seg1,Mth.sin(ageInTicks/8)/3);
		this.animateTentacleZ(Tentacle4Seg2,Mth.sin(ageInTicks/7)/2);
		this.animateTentacleZ(Tentacle4Seg3,Mth.cos(ageInTicks/6)/3);
		this.animateTentacleZ(Tentacle5Seg1,Mth.cos(ageInTicks/5)/3);
		this.animateTentacleZ(Tentacle5Seg2,Mth.sin(ageInTicks/6)/4);
		this.animateTentacleZ(Tentacle5Seg3,Mth.sin(ageInTicks/6)/3);
		this.animateTentacleZ(Tentacle6Seg1,Mth.cos(ageInTicks/8)/4);
		this.animateTentacleZ(Tentacle6Seg2,Mth.cos(ageInTicks/8)/4);
		this.animateTentacleZ(Tentacle6Seg3,Mth.cos(ageInTicks/8)/4);
		this.animateTentacleX(Tentacle7Seg1,Mth.cos(ageInTicks/6)/4);
		this.animateTentacleZ(Tentacle7Seg2,Mth.cos(ageInTicks/5)/4);
		this.animateTentacleZ(Tentacle7Seg3,Mth.cos(ageInTicks/5)/4);
		this.animateTentacleX(Tentacle8Seg1,Mth.cos(ageInTicks/6)/3);
		this.animateTentacleX(Tentacle8Seg2,Mth.cos(ageInTicks/5)/5);
		this.animateTentacleX(Tentacle8Seg3,Mth.cos(ageInTicks/7)/4);
		this.animateTentacleX(Tentacle9Seg1,Mth.sin(ageInTicks/6)/3);
		this.animateTentacleZ(Tentacle9Seg2,Mth.cos(ageInTicks/5)/5);
		this.animateTentacleZ(Tentacle9Seg3,Mth.cos(ageInTicks/7)/4);
		animateTumor(Tumor1,Mth.cos(ageInTicks/8)/4);
		animateTumor(Tumor1,Mth.sin(ageInTicks/7)/5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MrToucher.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}