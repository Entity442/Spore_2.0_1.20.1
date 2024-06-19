package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Hyper.Brot;
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

public class BrotkatzeModel<T extends Brot> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hyperbraio"), "main");
	private final ModelPart Brotkatze;
	private final ModelPart Tumor;
	private final ModelPart BackLeftLeg;
	private final ModelPart BackRightLeg;
	private final ModelPart FrontRightLeg;
	private final ModelPart FrontLeftLeg;
	private final ModelPart Lung1;
	private final ModelPart Lung2;
	private final ModelPart Lung3;
	private final ModelPart Lung4;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Neck3;
	private final ModelPart Mandible1;
	private final ModelPart Mandible2;
	private final ModelPart Mandible3;
	private final ModelPart Mandible4;
	private final ModelPart Mandible5;
	private final ModelPart Mandible6;
	private final ModelPart MainTongue;
	private final ModelPart MainTongue1;
	private final ModelPart MainTongue2;
	private final ModelPart SecondHead;
	private final ModelPart SecondTongue;
	private final ModelPart SecondTongue1;
	private final ModelPart SecondTongue2;
	public BrotkatzeModel(ModelPart root) {
		this.Brotkatze = root.getChild("Brotkatze");
		this.Tumor = Brotkatze.getChild("TorsoBottom").getChild("Tumors");
		this.BackLeftLeg = Brotkatze.getChild("TorsoBottom").getChild("BackLimbs").getChild("LeftBackJoint");
		this.BackRightLeg = Brotkatze.getChild("TorsoBottom").getChild("BackLimbs").getChild("RightBackJoint");
		this.FrontRightLeg = Brotkatze.getChild("TorsoTop").getChild("FrontLimbs").getChild("RightFrontJoint");
		this.FrontLeftLeg = Brotkatze.getChild("TorsoTop").getChild("FrontLimbs").getChild("LeftFrontJoint");
		this.Lung1 = Brotkatze.getChild("TorsoTop").getChild("Body").getChild("BodyLung1");
		this.Lung2 = Brotkatze.getChild("TorsoTop").getChild("Body").getChild("BodyLung2");
		this.Lung3 = Brotkatze.getChild("TorsoTop").getChild("Lungs").getChild("lung1");
		this.Lung4 = Brotkatze.getChild("TorsoTop").getChild("Lungs").getChild("lung2");
		this.Neck1 = Brotkatze.getChild("TorsoTop").getChild("Neck1");
		this.Neck2 = Neck1.getChild("Neck2");
		this.Neck3 = Neck2.getChild("Neck3");
		this.SecondHead = Brotkatze.getChild("TorsoTop").getChild("Body").getChild("BodyHead");
		this.Mandible1 = SecondHead.getChild("BodyLeftFang");
		this.Mandible2 = SecondHead.getChild("BodyRightFang");
		this.Mandible3 = Neck3.getChild("Head").getChild("Jaw").getChild("LeftFang1");
		this.Mandible4 = Neck3.getChild("Head").getChild("Jaw").getChild("RightFang1");
		this.Mandible5 = Neck3.getChild("Head").getChild("Jaw").getChild("LeftFang2");
		this.Mandible6 = Neck3.getChild("Head").getChild("Jaw").getChild("RightFang2");
		this.MainTongue = Neck3.getChild("Head").getChild("Tongue");
		this.MainTongue1 = MainTongue.getChild("TongueSeg2").getChild("TongueSeg3");
		this.MainTongue2 = MainTongue1.getChild("TongueSeg4").getChild("TongueSeg5");
		this.SecondTongue = SecondHead.getChild("BodyTongue");
		this.SecondTongue1 = SecondTongue.getChild("BTongue2");
		this.SecondTongue2 = SecondTongue1.getChild("BTongue3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Brotkatze = partdefinition.addOrReplaceChild("Brotkatze", CubeListBuilder.create().texOffs(2, 36).mirror().addBox(-6.0F, -22.0F, 2.0F, 12.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TorsoTop = Brotkatze.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -5.0F, -9.0F, 14.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.25F, 5.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Neck1 = TorsoTop.addOrReplaceChild("Neck1", CubeListBuilder.create().texOffs(88, 0).addBox(-3.0F, -3.0F, -8.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-1.0F, -4.2071F, -9.1213F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(33, 20).addBox(0.0F, -6.2071F, -10.1213F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -7.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck1.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(88, 0).mirror().addBox(-2.99F, -3.5355F, -8.2929F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(92, 0).addBox(-0.99F, -5.5355F, -8.2929F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(33, 21).mirror().addBox(0.01F, -7.5355F, -8.2929F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.8284F, -5.8284F, 0.48F, 0.0F, 0.0F));

		PartDefinition Neck2Fungus = Neck2.addOrReplaceChild("Neck2Fungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0593F, -0.4176F, -3.2691F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Fungus_r1 = Neck2Fungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = Neck2Fungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4407F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r3 = Neck2Fungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.678F, 0.6324F, 2.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = Neck2Fungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition Neck3 = Neck2.addOrReplaceChild("Neck3", CubeListBuilder.create().texOffs(88, 0).addBox(-3.0F, -2.4432F, -7.0777F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(92, 0).addBox(-1.0F, -3.8275F, -5.6083F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(34, 21).addBox(0.0F, -5.8275F, -5.6083F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9585F, -7.87F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Head = Neck3.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(34, 62).addBox(-4.8931F, -6.2445F, -8.1883F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4556F, 1.4051F, -7.567F, -0.48F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(116, 7).addBox(-4.2361F, -3.2038F, 1.7895F, 10.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.647F, 4.9594F, -1.9779F));

		PartDefinition LeftFang1 = Jaw.addOrReplaceChild("LeftFang1", CubeListBuilder.create().texOffs(41, 49).addBox(-0.6206F, -1.4659F, -4.2968F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(27, 25).addBox(0.3794F, 1.5341F, -4.2968F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4594F, -3.3837F, 1.9674F, 0.5976F, -0.4309F, -0.4254F));

		PartDefinition FangBlade_r1 = LeftFang1.addOrReplaceChild("FangBlade_r1", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3794F, 0.0341F, -7.7968F, 0.0F, 0.0F, -3.1416F));

		PartDefinition LeftFang2 = Jaw.addOrReplaceChild("LeftFang2", CubeListBuilder.create().texOffs(41, 49).addBox(-1.0F, -1.1667F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 4).addBox(0.0F, -1.1667F, -9.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4397F, -4.6288F, -6.0168F, 0.7854F, -0.3491F, 0.0F));

		PartDefinition FangDetail_r1 = LeftFang2.addOrReplaceChild("FangDetail_r1", CubeListBuilder.create().texOffs(27, 24).addBox(0.0F, -1.0F, -2.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.1667F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RightFang1 = Jaw.addOrReplaceChild("RightFang1", CubeListBuilder.create().texOffs(41, 49).addBox(-2.7342F, -2.8943F, -1.3016F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.7342F, -2.8943F, -8.3016F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(27, 25).addBox(-1.7342F, 0.1057F, -1.3016F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6494F, -0.5533F, -0.1181F, 0.5976F, 0.4309F, 0.4254F));

		PartDefinition RightFang2 = Jaw.addOrReplaceChild("RightFang2", CubeListBuilder.create().texOffs(41, 49).addBox(-1.0F, -1.1667F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(27, 24).addBox(0.0F, -3.1667F, -2.5F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9319F, -3.6288F, -6.0168F, 0.7854F, 0.4363F, 0.0F));

		PartDefinition FangBlade_r2 = RightFang2.addOrReplaceChild("FangBlade_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3333F, -6.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Flesh = Jaw.addOrReplaceChild("Flesh", CubeListBuilder.create().texOffs(118, 96).addBox(-5.0F, 0.0F, 0.0F, 10.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7639F, -0.3043F, 2.7524F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tongue = Head.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(14, 106).addBox(-2.5F, -0.5F, -7.0F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.353F, 2.3452F, 0.3044F, 0.6545F, 0.0F, 0.0F));

		PartDefinition TongueSeg2 = Tongue.addOrReplaceChild("TongueSeg2", CubeListBuilder.create().texOffs(120, 12).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition TongueSeg3 = TongueSeg2.addOrReplaceChild("TongueSeg3", CubeListBuilder.create().texOffs(117, 23).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition TongueSeg4 = TongueSeg3.addOrReplaceChild("TongueSeg4", CubeListBuilder.create().texOffs(122, 0).addBox(-1.5F, -0.5F, -5.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition TongueSeg5 = TongueSeg4.addOrReplaceChild("TongueSeg5", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition crown1 = Head.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0992F, -5.9969F, -4.0465F, 0.2618F, -0.1309F, -0.5236F));

		PartDefinition Petal4_r1 = crown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 68).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = crown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 54).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = crown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.0F, 0.0F, -5.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition crown2 = Head.addOrReplaceChild("crown2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.8939F, -5.9969F, -6.0465F, 0.5094F, 0.0224F, 0.9023F));

		PartDefinition Petal4_r2 = crown2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(-7, 61).addBox(-2.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r2 = crown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 54).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, 0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r2 = crown2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(-7, 68).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = crown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(-7, 54).addBox(-4.0F, 0.0F, -5.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 4.0399F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition FrontLimbs = TorsoTop.addOrReplaceChild("FrontLimbs", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -6.0F));

		PartDefinition LeftFrontJoint = FrontLimbs.addOrReplaceChild("LeftFrontJoint", CubeListBuilder.create(), PartPose.offset(5.7605F, -0.0903F, -1.0927F));

		PartDefinition LeftFront = LeftFrontJoint.addOrReplaceChild("LeftFront", CubeListBuilder.create().texOffs(33, 1).addBox(-2.0F, -2.0F, -12.5F, 4.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.9599F, -0.3491F));

		PartDefinition LeftFrontSeg2 = LeftFront.addOrReplaceChild("LeftFrontSeg2", CubeListBuilder.create().texOffs(0, 113).addBox(-1.5F, -1.75F, -3.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -12.5F));

		PartDefinition LeftFrontSeg2Fungus = LeftFrontSeg2.addOrReplaceChild("LeftFrontSeg2Fungus", CubeListBuilder.create(), PartPose.offset(-1.8198F, 7.5011F, -0.7549F));

		PartDefinition Fungus_r5 = LeftFrontSeg2Fungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -4.2108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = LeftFrontSeg2Fungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r7 = LeftFrontSeg2Fungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.322F, 0.6324F, 0.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = LeftFrontSeg2Fungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -2.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition LeftFrontSeg3 = LeftFrontSeg2.addOrReplaceChild("LeftFrontSeg3", CubeListBuilder.create().texOffs(38, 106).addBox(-1.4905F, -1.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.25F, -1.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightFrontJoint = FrontLimbs.addOrReplaceChild("RightFrontJoint", CubeListBuilder.create(), PartPose.offset(-5.7605F, -0.0903F, -1.0927F));

		PartDefinition RightFront = RightFrontJoint.addOrReplaceChild("RightFront", CubeListBuilder.create().texOffs(33, 1).addBox(-2.0F, -2.0F, -12.5F, 4.0F, 4.0F, 17.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.9599F, 0.3491F));

		PartDefinition RightFrontSeg1 = RightFront.addOrReplaceChild("RightFrontSeg1", CubeListBuilder.create().texOffs(0, 113).addBox(-1.5F, -1.75F, -3.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, -12.5F));

		PartDefinition RightFrontSeg2 = RightFrontSeg1.addOrReplaceChild("RightFrontSeg2", CubeListBuilder.create().texOffs(38, 106).addBox(-1.5095F, -1.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 13.25F, -1.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightFrontSeg2Fungus = RightFrontSeg2.addOrReplaceChild("RightFrontSeg2Fungus", CubeListBuilder.create(), PartPose.offset(-2.2988F, 8.2511F, 0.7451F));

		PartDefinition Fungus_r9 = RightFrontSeg2Fungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5593F, -5.2108F, 0.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = RightFrontSeg2Fungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r11 = RightFrontSeg2Fungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.678F, 0.6324F, 1.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r12 = RightFrontSeg2Fungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -2.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition Lungs = TorsoTop.addOrReplaceChild("Lungs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lung1 = Lungs.addOrReplaceChild("lung1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -1.5F, -4.5F, 9.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(58, 0).addBox(-3.5F, -4.0F, -4.0F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.7696F, -5.9179F, -3.7173F, 0.0553F, -0.0557F, 0.43F));

		PartDefinition lung2 = Lungs.addOrReplaceChild("lung2", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -0.5F, -8.0F, 9.0F, 3.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(58, 0).addBox(-4.0F, -3.0F, -7.5F, 8.0F, 3.0F, 14.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.8039F, -5.5245F, -1.9637F, -0.0502F, -0.0603F, -0.5173F));

		PartDefinition Body = TorsoTop.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r1 = Body.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 89).addBox(-4.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 5.25F, -6.0F, 0.9653F, -0.3255F, 0.2421F));

		PartDefinition Arm_r2 = Body.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(0, 89).addBox(0.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.25F, -6.0F, 0.6981F, 0.2618F, 0.0F));

		PartDefinition TorsoBottom_r1 = Body.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(3, 39).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.7002F, -1.4471F, 0.48F, 0.0F, 0.0F));

		PartDefinition Torso_r1 = Body.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(15, 39).addBox(-3.99F, -2.5F, -2.25F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -5.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition BodyHead = Body.addOrReplaceChild("BodyHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.2135F, -6.4874F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Head_r1 = BodyHead.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(64, 82).addBox(-4.0F, -4.4551F, -7.962F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8281F, 1.2173F, 0.3927F, 0.0F, 0.0F));

		PartDefinition BodyLeftFang = BodyHead.addOrReplaceChild("BodyLeftFang", CubeListBuilder.create().texOffs(41, 49).addBox(-0.9747F, -1.4992F, -4.6975F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(0.0253F, -3.4992F, -4.6975F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4563F, -0.2456F, -3.205F, -0.2485F, -0.4309F, 0.4254F));

		PartDefinition FangBlade_r3 = BodyLeftFang.addOrReplaceChild("FangBlade_r3", CubeListBuilder.create().texOffs(0, 4).addBox(0.0F, -1.5F, -3.5F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0253F, 0.0008F, -8.1975F, 0.0F, 0.0F, -3.1416F));

		PartDefinition BodyRightFang = BodyHead.addOrReplaceChild("BodyRightFang", CubeListBuilder.create().texOffs(41, 49).addBox(-0.9335F, -1.7656F, -4.1538F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(0.0665F, -1.7656F, -11.1538F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 5).addBox(0.0665F, -3.7656F, -4.1538F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7063F, 0.0044F, -3.705F, -0.2485F, 0.4309F, -0.4254F));

		PartDefinition BodyTongue = BodyHead.addOrReplaceChild("BodyTongue", CubeListBuilder.create().texOffs(16, 107).addBox(-2.0F, -0.5F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7223F, -2.7337F, -0.0873F, 0.0F, 0.0F));

		PartDefinition BTongue2 = BodyTongue.addOrReplaceChild("BTongue2", CubeListBuilder.create().texOffs(17, 107).addBox(-1.5F, -0.5F, -6.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition BTongue3 = BTongue2.addOrReplaceChild("BTongue3", CubeListBuilder.create().texOffs(18, 107).addBox(-1.0F, -0.5F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition BodyLung1 = Body.addOrReplaceChild("BodyLung1", CubeListBuilder.create().texOffs(6, 3).addBox(-3.0F, -1.875F, -6.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 3).addBox(-2.5F, -0.125F, -5.5F, 5.0F, 2.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.8869F, 7.231F, -2.3178F, 0.3655F, 0.147F, -0.3655F));

		PartDefinition BodyLung2 = Body.addOrReplaceChild("BodyLung2", CubeListBuilder.create().texOffs(6, 3).addBox(-3.0F, -1.875F, -6.0F, 6.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 3).addBox(-2.5F, -0.125F, -5.5F, 5.0F, 2.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.8869F, 7.1353F, -2.0868F, 0.3614F, 0.0162F, 0.4276F));

		PartDefinition TorsoBottom = Brotkatze.addOrReplaceChild("TorsoBottom", CubeListBuilder.create().texOffs(64, 52).addBox(-6.5F, -4.5F, -0.5F, 13.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 11.25F, -0.1745F, 0.0F, 0.0F));

		PartDefinition BackLimbs = TorsoBottom.addOrReplaceChild("BackLimbs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.5693F, 7.3904F));

		PartDefinition LeftBackJoint = BackLimbs.addOrReplaceChild("LeftBackJoint", CubeListBuilder.create(), PartPose.offset(5.0263F, 0.3506F, -1.7043F));

		PartDefinition LeftBack = LeftBackJoint.addOrReplaceChild("LeftBack", CubeListBuilder.create().texOffs(35, 3).addBox(-2.0F, -2.0F, -4.5F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9419F, 0.8785F, 0.2164F));

		PartDefinition LeftBackFungus = LeftBack.addOrReplaceChild("LeftBackFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0856F, 0.2409F, 3.7164F, -1.6144F, 0.0F, 0.0F));

		PartDefinition Fungus_r13 = LeftBackFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -4.2108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r14 = LeftBackFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r15 = LeftBackFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(-7, 68).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.322F, 0.6324F, 0.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r16 = LeftBackFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -2.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition LeftBackForLegJoint = LeftBack.addOrReplaceChild("LeftBackForLegJoint", CubeListBuilder.create(), PartPose.offset(0.0F, 0.1359F, 9.5577F));

		PartDefinition LeftFrontSeg = LeftBackForLegJoint.addOrReplaceChild("LeftFrontSeg", CubeListBuilder.create().texOffs(0, 113).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7925F, 0.0F, 0.0F));

		PartDefinition LeftBackSeg3 = LeftFrontSeg.addOrReplaceChild("LeftBackSeg3", CubeListBuilder.create().texOffs(38, 106).addBox(-1.4905F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 13.5F, -1.0F, -1.4399F, 0.0F, 0.0F));

		PartDefinition RightBackJoint = BackLimbs.addOrReplaceChild("RightBackJoint", CubeListBuilder.create(), PartPose.offset(-5.0263F, 0.3506F, -1.7043F));

		PartDefinition RightBack = RightBackJoint.addOrReplaceChild("RightBack", CubeListBuilder.create().texOffs(35, 3).addBox(-2.0F, -2.0F, -4.5F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9419F, -0.8785F, -0.2164F));

		PartDefinition RightBackForLegJoint = RightBack.addOrReplaceChild("RightBackForLegJoint", CubeListBuilder.create(), PartPose.offset(0.0F, 0.1359F, 9.5577F));

		PartDefinition RightFrontSeg3 = RightBackForLegJoint.addOrReplaceChild("RightFrontSeg3", CubeListBuilder.create().texOffs(0, 113).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7925F, 0.0F, 0.0F));

		PartDefinition RightBackSeg3 = RightFrontSeg3.addOrReplaceChild("RightBackSeg3", CubeListBuilder.create().texOffs(38, 106).addBox(-1.5095F, -1.0F, -2.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 13.5F, -1.0F, -1.4399F, 0.0F, 0.0F));

		PartDefinition Tumors = TorsoBottom.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(45, 98).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1655F, 2.7021F, 5.9614F, 0.6822F, 0.0642F, -0.1213F));

		PartDefinition Tumor_r2 = Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(41, 95).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.4236F, 2.3909F, 6.5147F, 0.3312F, 0.6681F, -0.7794F));

		PartDefinition Tumor_r3 = Tumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(43, 96).addBox(-2.0F, -2.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 5.0F, 0.6052F, 0.3031F, 0.413F));

		PartDefinition Tumor_r4 = Tumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(40, 94).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 5.0F, 0.9163F, 0.5236F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	private void animateTumor(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/8)/8;
		part.yScale = 1 + Mth.cos(value/8)/8;
		part.zScale = 1 + Mth.cos(value/8)/8;
	}
	private void animateLungs(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/7)/6;
		part.yScale = 1 - Mth.cos(value/7)/6;
		part.zScale = 1 + Mth.cos(value/7)/6;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTumor(Tumor,ageInTicks);
		this.animateLungs(Lung1,ageInTicks);
		this.animateLungs(Lung2,ageInTicks);
		this.animateLungs(Lung3,ageInTicks);
		this.animateLungs(Lung4,ageInTicks);
		this.Neck1.yRot = netHeadYaw / (360F / (float) Math.PI);
		this.Neck2.yRot = netHeadYaw / (360F / (float) Math.PI);
		this.Neck3.yRot = netHeadYaw / (360F / (float) Math.PI);
		this.Mandible1.xRot = -0.5f + Mth.sin(ageInTicks/5)/3;
		this.Mandible2.xRot = -0.5f + Mth.sin(ageInTicks/6)/4;
		this.Mandible3.xRot = 0.6f + Mth.sin(ageInTicks/5)/3;
		this.Mandible4.xRot = 0.6f + Mth.sin(ageInTicks/6)/5;
		this.Mandible5.xRot = 0.8f - Mth.sin(ageInTicks/5)/4;
		this.Mandible6.xRot = 0.8f - Mth.sin(ageInTicks/6)/3;
		this.MainTongue.xRot = 0.8f + Mth.sin(ageInTicks/5)/4;
		this.MainTongue1.xRot = -0.3f - Mth.sin(ageInTicks/4)/6;
		this.MainTongue2.xRot = -0.4f + Mth.sin(ageInTicks/5)/4;
		this.MainTongue.zRot = Mth.sin(ageInTicks/6)/6;
		this.MainTongue1.zRot = Mth.sin(ageInTicks/6)/6;
		this.SecondHead.zRot = Mth.sin(ageInTicks/7)/7;
		this.SecondTongue.yRot = Mth.sin(ageInTicks/6)/6;
		this.SecondTongue1.yRot = Mth.sin(ageInTicks/6)/6;
		this.SecondTongue2.yRot = Mth.sin(ageInTicks/6)/6;

		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			float moveValue  = Mth.cos(limbSwing * 0.3F) * 0.8F * limbSwingAmount;
			BackRightLeg.yRot = moveValue * 0.6f;
			BackLeftLeg.yRot = moveValue * 0.6f;
			FrontLeftLeg.yRot = moveValue;
			FrontRightLeg.yRot = moveValue;
			FrontRightLeg.zRot = moveValue > 0 ? moveValue : 0;
			FrontLeftLeg.zRot = moveValue < 0 ? moveValue : 0;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Brotkatze.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}