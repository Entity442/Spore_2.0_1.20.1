package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Delusionare;
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

public class DelusionerModel<T extends Delusionare> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "delusioner"), "main");
	private final ModelPart Deli;
	private final ModelPart TumorBase;
	private final ModelPart HeadBase;
	private final ModelPart MainBody;
	private final ModelPart Torso;
	private final ModelPart TopTorso;
	private final ModelPart Head;
	private final ModelPart Tumors;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftForArm;
	private final ModelPart Finger1;
	private final ModelPart Finger2;
	private final ModelPart Finger3;
	private final ModelPart Finger4;
	private final ModelPart Finger5;
	private final ModelPart Finger6;


	public DelusionerModel(ModelPart root) {
		this.Deli = root.getChild("Deli");
		this.TumorBase = Deli.getChild("TumorBase");
		this.HeadBase = Deli.getChild("BodyBase").getChild("BodyBaseHead");
		this.MainBody = Deli.getChild("BodyBase").getChild("BodyToTorso");
		this.Torso = MainBody.getChild("DelusionerTorso");
		this.TopTorso = Torso.getChild("TorsoToUpper");
		this.Head = TopTorso.getChild("DelusionerUpperTorso").getChild("UpperToHead");
		this.Tumors = Head.getChild("Head").getChild("HeadTumors");
		this.Jaw = Head.getChild("Head").getChild("Jaw");
		this.RightArm = TopTorso.getChild("DelusionerUpperTorso").getChild("Arms").getChild("UpperToRightArm");
		this.LeftArm = TopTorso.getChild("DelusionerUpperTorso").getChild("Arms").getChild("UpperToLeftArm");
		this.RightForArm = RightArm.getChild("RightArmSeg1").getChild("RightArmToRightHand");
		this.LeftForArm = LeftArm.getChild("LeftArmSeg1").getChild("LeftArmToLeftHand");
		this.Finger1 = RightForArm.getChild("RightArmSeg2").getChild("Tendrils2").getChild("LT4");
		this.Finger2 = RightForArm.getChild("RightArmSeg2").getChild("Tendrils2").getChild("LT5");
		this.Finger3 = RightForArm.getChild("RightArmSeg2").getChild("Tendrils2").getChild("LT6");
		this.Finger4 = LeftForArm.getChild("LeftArmSeg2").getChild("Tendrils").getChild("LT1");
		this.Finger5 = LeftForArm.getChild("LeftArmSeg2").getChild("Tendrils").getChild("LT2");
		this.Finger6 = LeftForArm.getChild("LeftArmSeg2").getChild("Tendrils").getChild("LT3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Deli = partdefinition.addOrReplaceChild("Deli", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TumorBase = Deli.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-2.3513F, -2.3449F, -0.4248F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(4, 4).addBox(-3.5F, -4.5F, -3.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5978F, -0.385F, 0.1898F, -1.291F, -1.2821F, 1.2467F));

		PartDefinition Tumor_r2 = TumorBase.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(7, 4).addBox(-3.5F, -2.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1306F, -1.7723F, 7.1606F, 0.259F, 0.8158F, 0.246F));

		PartDefinition Tumor_r3 = TumorBase.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(6, 6).addBox(-11.0F, -7.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7728F, 1.1853F, -5.9321F, 0.0F, 0.5236F, -0.3491F));

		PartDefinition Tumor_r4 = TumorBase.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(3, 5).addBox(-7.0F, 4.5F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3563F, -5.828F, -4.8651F, 0.0F, -0.5236F, 0.3491F));

		PartDefinition Tumor_r5 = TumorBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-4.4731F, -5.8371F, -17.1586F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1755F, -2.818F, 12.5834F, 0.1801F, 0.3913F, 0.0164F));

		PartDefinition BodyBase = Deli.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(55, 42).addBox(-5.5F, -10.75F, 0.5F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg_r1 = BodyBase.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(16, 64).addBox(-1.0F, 1.25F, -4.5F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -8.0F, -9.0F, 0.6545F, -0.6981F, 0.0F));

		PartDefinition Leg_r2 = BodyBase.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(16, 64).addBox(0.4479F, -2.5838F, -8.4347F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5863F, -5.8213F, -3.0109F, 0.48F, 0.6981F, 0.0F));

		PartDefinition Arm_r1 = BodyBase.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(16, 64).addBox(-5.0F, 0.0F, -8.5F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -8.0F, 5.0F, -0.6545F, 0.6981F, 0.0F));

		PartDefinition Arm_r2 = BodyBase.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(16, 64).addBox(0.0F, -2.0F, -6.5F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -8.0F, 5.0F, 0.6545F, -0.6981F, 0.0F));

		PartDefinition Torso_r1 = BodyBase.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(40, 64).addBox(-3.0F, -1.0F, -5.5F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -9.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition BodyCrown = BodyBase.addOrReplaceChild("BodyCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4966F, -10.6808F, -1.6487F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Petal5_r1 = BodyCrown.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r1 = BodyCrown.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.2945F, 0.0878F, 0.4229F));

		PartDefinition Petal3_r1 = BodyCrown.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r1 = BodyCrown.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.5658F, 0.0368F, -0.0791F));

		PartDefinition BodyTumors = BodyBase.addOrReplaceChild("BodyTumors", CubeListBuilder.create(), PartPose.offset(-2.1292F, -9.9885F, 0.0821F));

		PartDefinition Tumor_r6 = BodyTumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(14, 14).addBox(-0.5F, -0.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5696F, 1.1761F, -0.2886F, -1.4923F, 0.2995F, -1.0681F));

		PartDefinition Tumor_r7 = BodyTumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(14, 14).addBox(-3.5F, -2.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5696F, -1.8239F, -0.2886F, -1.2278F, 0.3461F, -1.1971F));

		PartDefinition Tumor_r8 = BodyTumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(14, 14).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1208F, -0.7967F, 0.1892F, 0.2978F, 0.1848F, -0.5394F));

		PartDefinition BodyBaseHead = BodyBase.addOrReplaceChild("BodyBaseHead", CubeListBuilder.create().texOffs(27, 31).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -9.0F, 6.5F, -0.5516F, -0.1395F, -0.2223F));

		PartDefinition Nose_r1 = BodyBaseHead.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(94, 94).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 2.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition Jaw_r1 = BodyBaseHead.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(92, 61).addBox(-4.0F, -7.0F, -0.5F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.5F, 0.215F, 0.0376F, -0.1705F));

		PartDefinition BodyHeadCrown = BodyBaseHead.addOrReplaceChild("BodyHeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0652F, -2.5453F, 7.944F, -0.829F, 0.0F, 0.0F));

		PartDefinition Petal5_r2 = BodyHeadCrown.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0874F, -0.0517F, -1.1782F, -0.0306F, 0.1719F, -0.6135F));

		PartDefinition Petal4_r2 = BodyHeadCrown.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6028F, -0.2198F, 0.3625F, -0.2186F, -0.1937F, 0.6378F));

		PartDefinition Petal3_r2 = BodyHeadCrown.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, 0.6357F, -3.5922F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Petal2_r2 = BodyHeadCrown.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2423F, -0.3643F, 3.4078F, 0.7152F, -0.2815F, -0.1201F));

		PartDefinition BodyToTorso = BodyBase.addOrReplaceChild("BodyToTorso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition BtTT1 = BodyToTorso.addOrReplaceChild("BtTT1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition B_T_T1S2_r1 = BtTT1.addOrReplaceChild("B_T_T1S2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.2997F, -7.6116F, -1.0654F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7353F, -7.2215F, -1.4255F, -0.0873F, -0.3054F, 0.0F));

		PartDefinition B_T_T1_r1 = BtTT1.addOrReplaceChild("B_T_T1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -7.75F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.25F, 0.0F, 0.2182F, -0.3054F, 0.0F));

		PartDefinition BtTT2 = BodyToTorso.addOrReplaceChild("BtTT2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5303F, 0.0F, -0.5303F, -3.098F, 0.7854F, 3.1416F));

		PartDefinition B_T_T2S2_r1 = BtTT2.addOrReplaceChild("B_T_T2S2_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.2997F, -8.6116F, -0.0654F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2647F, -7.2215F, -1.4255F, -0.3054F, -0.3054F, 0.0F));

		PartDefinition B_T_T2_r1 = BtTT2.addOrReplaceChild("B_T_T2_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.0F, -7.75F, 0.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 0.0F, 0.2182F, -0.3054F, 0.0F));

		PartDefinition BtTT3 = BodyToTorso.addOrReplaceChild("BtTT3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1053F, -0.2864F, -0.4497F, 0.0316F, 0.2185F, -0.024F));

		PartDefinition B_T_T3S2_r1 = BtTT3.addOrReplaceChild("B_T_T3S2_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.2997F, -8.6116F, -0.9346F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1099F, -6.9491F, 1.4415F, 0.3054F, 0.3054F, 0.0F));

		PartDefinition B_T_T3_r1 = BtTT3.addOrReplaceChild("B_T_T3_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.0F, -7.75F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3452F, 0.5224F, 0.016F, -0.2182F, 0.3054F, 0.0F));

		PartDefinition BtTT4 = BodyToTorso.addOrReplaceChild("BtTT4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9409F, -14.5865F, -2.5829F, 0.6106F, -1.517F, -0.6408F));

		PartDefinition B_T_T4S2_r1 = BtTT4.addOrReplaceChild("B_T_T4S2_r1", CubeListBuilder.create().texOffs(2, 0).addBox(0.0F, -0.25F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3452F, -0.5224F, -0.016F, -0.2182F, 0.3054F, 0.0F));

		PartDefinition B_T_T4_r1 = BtTT4.addOrReplaceChild("B_T_T4_r1", CubeListBuilder.create().texOffs(2, 0).addBox(0.2997F, -0.3884F, -0.0654F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1099F, 6.9491F, -1.4415F, 0.3054F, 0.3054F, 0.0F));

		PartDefinition DelusionerTorso = BodyToTorso.addOrReplaceChild("DelusionerTorso", CubeListBuilder.create().texOffs(36, 74).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 94).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 13.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.75F, -14.75F, -1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition LowerTorsoFungus = DelusionerTorso.addOrReplaceChild("LowerTorsoFungus", CubeListBuilder.create(), PartPose.offset(0.6907F, -0.0892F, -0.3475F));

		PartDefinition Fungus_r1 = LowerTorsoFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 31).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 2.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = LowerTorsoFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 38).addBox(-5.5F, 0.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = LowerTorsoFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.25F, -2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = LowerTorsoFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.5F, -1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition TorsoToUpper = DelusionerTorso.addOrReplaceChild("TorsoToUpper", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.25F, -4.25F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition TtUT1 = TorsoToUpper.addOrReplaceChild("TtUT1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TtU_T1_r1 = TtUT1.addOrReplaceChild("TtU_T1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.75F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, 0.0F, -0.2182F, -0.3054F, 0.0F));

		PartDefinition TtUT2 = TorsoToUpper.addOrReplaceChild("TtUT2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5303F, 0.0F, 0.5303F, 3.098F, 0.7854F, -3.1416F));

		PartDefinition TtU_T2_r1 = TtUT2.addOrReplaceChild("TtU_T2_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-0.0098F, -4.4748F, -1.1926F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.25F, 0.0F, -0.2182F, -0.3054F, 0.0F));

		PartDefinition TtUT3 = TorsoToUpper.addOrReplaceChild("TtUT3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1053F, -0.2864F, 0.4497F, -0.0316F, 0.2185F, 0.024F));

		PartDefinition TtU_T3_r1 = TtUT3.addOrReplaceChild("TtU_T3_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-0.0085F, -4.4884F, 0.1313F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3452F, 0.5224F, -0.016F, 0.2182F, 0.3054F, 0.0F));

		PartDefinition TtUT4 = TorsoToUpper.addOrReplaceChild("TtUT4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9409F, -14.5865F, 2.5829F, -0.6106F, -1.517F, 0.6408F));

		PartDefinition TtU_T4_r1 = TtUT4.addOrReplaceChild("TtU_T4_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.7997F, 4.1116F, -0.9346F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1099F, 6.9491F, 1.4415F, -0.3054F, 0.3054F, 0.0F));

		PartDefinition DelusionerUpperTorso = TorsoToUpper.addOrReplaceChild("DelusionerUpperTorso", CubeListBuilder.create().texOffs(56, 53).addBox(-4.0F, -6.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -2.7667F, 0.2282F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Robe_r1 = DelusionerUpperTorso.addOrReplaceChild("Robe_r1", CubeListBuilder.create().texOffs(74, 105).mirror().addBox(-4.0F, -3.25F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.3F)).mirror(false), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition UpperTorsoFungus = DelusionerUpperTorso.addOrReplaceChild("UpperTorsoFungus", CubeListBuilder.create(), PartPose.offset(-2.3093F, -3.0725F, 0.4243F));

		PartDefinition Fungus_r5 = UpperTorsoFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 45).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = UpperTorsoFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 31).addBox(-3.5F, -2.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = UpperTorsoFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 31).addBox(-1.25F, -5.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = UpperTorsoFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 38).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition UpperToHead = DelusionerUpperTorso.addOrReplaceChild("UpperToHead", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.75F, -5.0077F, 0.4871F, -0.3054F, 0.0F, 0.0F));

		PartDefinition UtHT1 = UpperToHead.addOrReplaceChild("UtHT1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition UtHT1_r1 = UtHT1.addOrReplaceChild("UtHT1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.75F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.5F, 0.0F, 0.2182F, 0.3054F, 0.0F));

		PartDefinition UtHT2 = UpperToHead.addOrReplaceChild("UtHT2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5303F, 0.0F, -0.5303F, -3.098F, -0.7854F, -3.1416F));

		PartDefinition TtU_T3_r2 = UtHT2.addOrReplaceChild("TtU_T3_r2", CubeListBuilder.create().texOffs(2, 0).addBox(-0.5098F, -5.4748F, 0.1926F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.25F, 0.0F, 0.2182F, 0.3054F, 0.0F));

		PartDefinition UtHT3 = UpperToHead.addOrReplaceChild("UtHT3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.298F, 0.4997F, -1.4023F, 0.5116F, -0.2185F, 0.024F));

		PartDefinition UtHT3_r1 = UtHT3.addOrReplaceChild("UtHT3_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-0.0085F, -5.4884F, -0.1313F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3452F, 0.5224F, 0.016F, -0.2182F, -0.3054F, 0.0F));

		PartDefinition UtHT4 = UpperToHead.addOrReplaceChild("UtHT4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9409F, -14.5865F, -2.5829F, 0.6106F, 1.517F, 0.6408F));

		PartDefinition UtHT4_r1 = UtHT4.addOrReplaceChild("UtHT4_r1", CubeListBuilder.create().texOffs(2, 0).addBox(-1.7997F, 3.1116F, 0.4346F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1099F, 6.9491F, -1.4415F, 0.3054F, -0.3054F, 0.0F));

		PartDefinition Head = UpperToHead.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 96).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 11.0F, 8.0F, new CubeDeformation(0.1F))
		.texOffs(54, 80).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -3.0F, -3.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(54, 80).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6545F, 0.0F, -0.2618F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(96, 25).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

		PartDefinition HeadCrown1 = Head.addOrReplaceChild("HeadCrown1", CubeListBuilder.create(), PartPose.offset(0.1848F, -10.6924F, -0.1157F));

		PartDefinition Petal5_r3 = HeadCrown1.addOrReplaceChild("Petal5_r3", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0874F, -0.0517F, -1.1782F, -0.0306F, 0.1719F, -0.6135F));

		PartDefinition Petal4_r3 = HeadCrown1.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6028F, -0.2198F, 0.3625F, -0.2186F, -0.1937F, 0.6378F));

		PartDefinition Petal3_r3 = HeadCrown1.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, 0.6357F, -3.5922F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Petal2_r3 = HeadCrown1.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2423F, -0.3643F, 3.4078F, 0.7152F, -0.2815F, -0.1201F));

		PartDefinition HeadCrown2 = Head.addOrReplaceChild("HeadCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5126F, -8.9063F, 0.2788F, 0.0F, -0.8727F, 0.0F));

		PartDefinition Petal4_r4 = HeadCrown2.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(-7, 45).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r4 = HeadCrown2.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(-7, 45).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r4 = HeadCrown2.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = HeadCrown2.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition HeadTumors = Head.addOrReplaceChild("HeadTumors", CubeListBuilder.create(), PartPose.offset(0.5F, -7.2607F, -5.4866F));

		PartDefinition Tumor_r9 = HeadTumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(14, 14).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.6903F, -2.0272F, 5.4778F, 1.4923F, -0.2995F, -1.0681F));

		PartDefinition Tumor_r10 = HeadTumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(14, 14).addBox(-3.5F, -2.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6903F, -5.0272F, 5.4778F, 1.2278F, -0.3461F, -1.1971F));

		PartDefinition Tumor_r11 = HeadTumors.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(14, 14).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, 5.0F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Arms = DelusionerUpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-0.25F, -3.2333F, -0.2282F));

		PartDefinition UpperToRightArm = Arms.addOrReplaceChild("UpperToRightArm", CubeListBuilder.create(), PartPose.offset(-4.0F, -0.75F, 0.0F));

		PartDefinition UtRT1 = UpperToRightArm.addOrReplaceChild("UtRT1", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition UtRT1_r1 = UtRT1.addOrReplaceChild("UtRT1_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-5.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, -0.2048F, 0.0757F));

		PartDefinition UtRT2 = UpperToRightArm.addOrReplaceChild("UtRT2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3839F, 1.2479F, -0.9268F, 0.3927F, 0.3927F, 0.0F));

		PartDefinition UtRT2_r1 = UtRT2.addOrReplaceChild("UtRT2_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-5.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, -0.2048F, 0.0757F));

		PartDefinition RightArmSeg1 = UpperToRightArm.addOrReplaceChild("RightArmSeg1", CubeListBuilder.create().texOffs(91, 37).addBox(-6.0F, -2.25F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(78, 90).addBox(-6.0F, -2.25F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.7911F, 0.076F, 0.2629F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightArmToRightHand = RightArmSeg1.addOrReplaceChild("RightArmToRightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.852F, -0.4594F, -0.6027F, -0.2877F, -0.5155F, 0.0644F));

		PartDefinition RtHT1 = RightArmToRightHand.addOrReplaceChild("RtHT1", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition RtHT1_r1 = RtHT1.addOrReplaceChild("RtHT1_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-5.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, -0.2048F, 0.0757F));

		PartDefinition RtHT2 = RightArmToRightHand.addOrReplaceChild("RtHT2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3839F, 1.2479F, -0.9268F, 0.3927F, 0.3927F, 0.0F));

		PartDefinition RtHT2_r1 = RtHT2.addOrReplaceChild("RtHT2_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-5.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, -0.2048F, 0.0757F));

		PartDefinition RightArmSeg2 = RightArmToRightHand.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(14, 88).addBox(-6.0F, -2.0F, -1.5F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 76).addBox(-6.0F, -2.0F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -0.25F, 0.1219F, -0.1872F, 0.2105F));

		PartDefinition SleeveEnd_r1 = RightArmSeg2.addOrReplaceChild("SleeveEnd_r1", CubeListBuilder.create().texOffs(30, 92).addBox(-2.9918F, -2.0F, -1.9973F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.1562F, -0.1488F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Tendrils2 = RightArmSeg2.addOrReplaceChild("Tendrils2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.1939F, 2.0602F, 0.1806F, 0.0F, 0.0F, -2.0944F));

		PartDefinition LT4 = Tendrils2.addOrReplaceChild("LT4", CubeListBuilder.create(), PartPose.offset(0.0815F, 1.2335F, -0.2848F));

		PartDefinition LT1_r1 = LT4.addOrReplaceChild("LT1_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg3 = LT4.addOrReplaceChild("LT1Seg3", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.2182F, 0.4363F, 0.0F));

		PartDefinition LT5 = Tendrils2.addOrReplaceChild("LT5", CubeListBuilder.create(), PartPose.offset(1.4497F, 1.2933F, 0.3033F));

		PartDefinition LT2Seg1_r1 = LT5.addOrReplaceChild("LT2Seg1_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg3 = LT5.addOrReplaceChild("LT2Seg3", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.2618F, -0.2182F, 0.0F));

		PartDefinition LT6 = Tendrils2.addOrReplaceChild("LT6", CubeListBuilder.create(), PartPose.offset(-0.2397F, 0.8012F, 1.448F));

		PartDefinition LT3Seg1_r1 = LT6.addOrReplaceChild("LT3Seg1_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg3 = LT6.addOrReplaceChild("LT3Seg3", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.3491F, 0.0F, 0.0F));

		PartDefinition UpperToLeftArm = Arms.addOrReplaceChild("UpperToLeftArm", CubeListBuilder.create(), PartPose.offset(4.4153F, -1.0873F, -0.1897F));

		PartDefinition UtLT1 = UpperToLeftArm.addOrReplaceChild("UtLT1", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition UtLT1_r1 = UtLT1.addOrReplaceChild("UtLT1_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-2.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, 0.2048F, -0.0757F));

		PartDefinition UtLT2 = UpperToLeftArm.addOrReplaceChild("UtLT2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3839F, 1.2479F, -0.9268F, 0.3927F, -0.3927F, 0.0F));

		PartDefinition UtLT2_r1 = UtLT2.addOrReplaceChild("UtLT2_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-2.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, 0.2048F, -0.0757F));

		PartDefinition LeftArmSeg1 = UpperToLeftArm.addOrReplaceChild("LeftArmSeg1", CubeListBuilder.create().texOffs(62, 86).addBox(0.0F, -2.25F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.0F, 0.0F, -0.25F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftArmTumor = LeftArmSeg1.addOrReplaceChild("LeftArmTumor", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.25F));

		PartDefinition Tumor_r12 = LeftArmTumor.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(14, 14).addBox(-0.5F, -2.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.5F, -0.5F, 0.5F, 0.7594F, 1.0902F, -0.4747F));

		PartDefinition Tumor_r13 = LeftArmTumor.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(14, 14).addBox(-2.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -0.5F, 0.5F, 0.6981F, 0.6545F, 0.0F));

		PartDefinition LeftArmToLeftHand = LeftArmSeg1.addOrReplaceChild("LeftArmToLeftHand", CubeListBuilder.create(), PartPose.offsetAndRotation(5.852F, -0.4594F, -0.6027F, -0.2877F, 0.5155F, -0.0644F));

		PartDefinition LtHT1 = LeftArmToLeftHand.addOrReplaceChild("LtHT1", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition LtHT1_r1 = LtHT1.addOrReplaceChild("LtHT1_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-2.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, 0.2048F, -0.0757F));

		PartDefinition LtHT2 = LeftArmToLeftHand.addOrReplaceChild("LtHT2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3839F, 1.2479F, -0.9268F, 0.3927F, -0.3927F, 0.0F));

		PartDefinition LtHT2_r1 = LtHT2.addOrReplaceChild("LtHT2_r1", CubeListBuilder.create().texOffs(60, 20).addBox(-2.0F, -1.0F, 0.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3568F, 0.2048F, -0.0757F));

		PartDefinition LeftArmSeg2 = LeftArmToLeftHand.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(42, 86).addBox(0.0F, -2.0F, -1.5F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 76).mirror().addBox(-1.0F, -2.0F, -1.5F, 7.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(3.7691F, 0.0F, -0.6935F, -0.0678F, 0.4755F, -0.1473F));

		PartDefinition SleeveEnd_r2 = LeftArmSeg2.addOrReplaceChild("SleeveEnd_r2", CubeListBuilder.create().texOffs(30, 92).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(6.558F, 0.3614F, 0.5027F, 3.1416F, 0.0F, -2.7925F));

		PartDefinition Tendrils = LeftArmSeg2.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(7.1266F, 0.4736F, 0.3267F, 0.2712F, -0.389F, 1.6894F));

		PartDefinition LT1 = Tendrils.addOrReplaceChild("LT1", CubeListBuilder.create(), PartPose.offset(0.0815F, 1.2335F, -0.2848F));

		PartDefinition LT1_r2 = LT1.addOrReplaceChild("LT1_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg2 = LT1.addOrReplaceChild("LT1Seg2", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LT2 = Tendrils.addOrReplaceChild("LT2", CubeListBuilder.create(), PartPose.offset(1.1997F, 1.2933F, -0.1967F));

		PartDefinition LT2Seg1_r2 = LT2.addOrReplaceChild("LT2Seg1_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg2 = LT2.addOrReplaceChild("LT2Seg2", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LT3 = Tendrils.addOrReplaceChild("LT3", CubeListBuilder.create(), PartPose.offset(-0.2397F, 0.8012F, 0.948F));

		PartDefinition LT3Seg1_r2 = LT3.addOrReplaceChild("LT3Seg1_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg2 = LT3.addOrReplaceChild("LT3Seg2", CubeListBuilder.create().texOffs(0, 56).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.1745F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateTumor(ModelPart part,float value){
		part.xScale = 1+ Mth.cos(value/8)/8;
		part.yScale = 1+ Mth.cos(value/8)/8;
		part.zScale = 1+ Mth.cos(value/8)/8;
	}
	private void animateFinger(ModelPart part,float value){
		part.xRot = Mth.sin(value/6)/6;
		part.zRot = part.xRot;
	}
	private void animateFinger1(ModelPart part,float value){
		part.xRot = Mth.cos(value/6)/6;
		part.zRot = part.xRot;
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTumor(this.TumorBase,ageInTicks);
		this.animateTumor(this.Tumors,-ageInTicks);
		this.HeadBase.yRot = Mth.cos(ageInTicks/6)/5;
		this.MainBody.zRot = Mth.cos(ageInTicks/10)/10;
		this.Torso.yRot = Mth.sin(ageInTicks/7)/7;
		this.TopTorso.zRot = Mth.sin(ageInTicks/6)/6;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Jaw.yRot = Mth.cos(ageInTicks/6)/5;
		this.RightArm.zRot = -0.7f-Mth.cos(ageInTicks/7)/7;
		this.LeftArm.zRot = -RightArm.zRot;
		this.RightForArm.yRot = Mth.cos(ageInTicks/6)/6;
		this.LeftForArm.yRot = -RightForArm.yRot;
		if (entity.isCasting()){
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/8;
			this.LeftArm.xRot = Mth.cos(ageInTicks/8)/8;
		}else{
			this.RightArm.xRot = 1.3f;
			this.LeftArm.xRot = 1.3f;
		}
		animateFinger(this.Finger1,-ageInTicks);
		animateFinger1(this.Finger2,ageInTicks);
		animateFinger(this.Finger3,ageInTicks);
		animateFinger1(this.Finger4,-ageInTicks);
		animateFinger1(this.Finger5,ageInTicks);
		animateFinger(this.Finger6,-ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Deli.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}