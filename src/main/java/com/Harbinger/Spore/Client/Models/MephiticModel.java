package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Mephetic;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.util.Mth;

import java.util.List;

public class MephiticModel<T extends Mephetic> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "mephiticmodel"), "main");
	private final ModelPart Mephitic;
	private final ModelPart Torso;
	private final ModelPart Tumor18Group;
	private final ModelPart tumor;
	private final ModelPart TorsoClothingUpper;
	private final ModelPart TorsoClothingLower;
	private final ModelPart TorsoFoliage;
	private final ModelPart BackFoliage;
	private final ModelPart Arms;
	private final ModelPart LeftArm;
	private final ModelPart LeftClaws;
	private final ModelPart LeftArmFoliage;
	private final ModelPart LeftArmClothing;
	private final ModelPart RightArm;
	private final ModelPart RightArmTumors;
	private final ModelPart Tumor13Group;
	private final ModelPart tumor3;
	private final ModelPart tumor4;
	private final ModelPart RightClaws;
	private final ModelPart RightArmEnhanced;
	private final ModelPart RightArmFoliage;
	private final ModelPart Legs;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegFoliage;
	private final ModelPart LeftLegClothing;
	private final ModelPart leftForLeg;
	private final ModelPart RightLeg;
	private final ModelPart RightLegClothing;
	private final ModelPart rightForLeg;
	private final ModelPart RightLegFoliage;
	private final ModelPart Head;
	private final ModelPart LowerJaw;
	private final ModelPart Tumor5Group;
	private final ModelPart LowerFangs;
	private final ModelPart LeftLowerFang;
	private final ModelPart RightLowerFang;
	private final ModelPart Potion;
	private final ModelPart HeadIntermediate;
	private final ModelPart UpperHead;
	private final ModelPart TopFangs;
	private final ModelPart LeftTopFang;
	private final ModelPart RightTopFang;
	private final ModelPart WitchHat;
	private final ModelPart HatTopHalf;
	private final ModelPart HatTop;
	private final ModelPart HatTopBit;
	private final ModelPart Nose;
	private final ModelPart Tumors;
	private final ModelPart tumor1;
	private final ModelPart tumor2;
	private final ModelPart HeadFoliage;
	public final List<ModelPart> armParts;
	public final List<ModelPart> OffarmParts;
	public MephiticModel(ModelPart root) {
		this.Mephitic = root.getChild("Mephitic");
		this.Torso = this.Mephitic.getChild("Torso");
		this.Tumor18Group = this.Torso.getChild("Tumor18Group");
		this.tumor = this.Torso.getChild("tumor");
		this.TorsoClothingUpper = this.Torso.getChild("TorsoClothingUpper");
		this.TorsoClothingLower = this.Torso.getChild("TorsoClothingLower");
		this.TorsoFoliage = this.Torso.getChild("TorsoFoliage");
		this.BackFoliage = this.Torso.getChild("BackFoliage");
		this.Arms = this.Mephitic.getChild("Arms");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftClaws = this.LeftArm.getChild("LeftClaws");
		this.LeftArmFoliage = this.LeftArm.getChild("LeftArmFoliage");
		this.LeftArmClothing = this.LeftArm.getChild("LeftArmClothing");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightArmTumors = this.RightArm.getChild("RightArmTumors");
		this.Tumor13Group = this.RightArmTumors.getChild("Tumor13Group");
		this.tumor3 = this.RightArmTumors.getChild("tumor3");
		this.tumor4 = this.RightArmTumors.getChild("tumor4");
		this.RightClaws = this.RightArm.getChild("RightClaws");
		this.RightArmEnhanced = this.RightArm.getChild("RightArmEnhanced");
		this.RightArmFoliage = this.RightArm.getChild("RightArmFoliage");
		this.Legs = this.Mephitic.getChild("Legs");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftLegFoliage = this.LeftLeg.getChild("LeftLegFoliage");
		this.LeftLegClothing = this.LeftLeg.getChild("LeftLegClothing");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightLegClothing = this.RightLeg.getChild("RightLegClothing");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.RightLegFoliage = this.rightForLeg.getChild("RightLegFoliage");
		this.Head = this.Mephitic.getChild("Head");
		this.LowerJaw = this.Head.getChild("LowerJaw");
		this.Tumor5Group = this.LowerJaw.getChild("Tumor5Group");
		this.LowerFangs = this.LowerJaw.getChild("LowerFangs");
		this.LeftLowerFang = this.LowerFangs.getChild("LeftLowerFang");
		this.RightLowerFang = this.LowerFangs.getChild("RightLowerFang");
		this.Potion = this.LowerJaw.getChild("Potion");
		this.HeadIntermediate = this.Head.getChild("HeadIntermediate");
		this.UpperHead = this.HeadIntermediate.getChild("UpperHead");
		this.TopFangs = this.UpperHead.getChild("TopFangs");
		this.LeftTopFang = this.TopFangs.getChild("LeftTopFang");
		this.RightTopFang = this.TopFangs.getChild("RightTopFang");
		this.WitchHat = this.UpperHead.getChild("WitchHat");
		this.HatTopHalf = this.WitchHat.getChild("HatTopHalf");
		this.HatTop = this.HatTopHalf.getChild("HatTop");
		this.HatTopBit = this.HatTop.getChild("HatTopBit");
		this.Nose = this.UpperHead.getChild("Nose");
		this.Tumors = this.UpperHead.getChild("Tumors");
		this.tumor1 = this.Tumors.getChild("tumor1");
		this.tumor2 = this.Tumors.getChild("tumor2");
		this.HeadFoliage = this.UpperHead.getChild("HeadFoliage");
		armParts = List.of(Mephitic,Arms,RightArm);
		OffarmParts = List.of(Mephitic,Arms,LeftArm);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Mephitic = partdefinition.addOrReplaceChild("Mephitic", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = Mephitic.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(32, 19).addBox(-4.7552F, 1.9024F, -1.0499F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7552F, -19.0024F, -1.5501F));

		PartDefinition UpperTorso_r1 = Torso.addOrReplaceChild("UpperTorso_r1", CubeListBuilder.create().texOffs(0, 28).addBox(-4.3F, -7.0F, -2.4F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9552F, -2.7976F, 0.6501F, 0.1484F, 0.0F, 0.0F));

		PartDefinition MiddleTorso_r1 = Torso.addOrReplaceChild("MiddleTorso_r1", CubeListBuilder.create().texOffs(28, 39).addBox(-4.0F, -6.0048F, -2.2181F, 7.0F, 7.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2552F, 1.9024F, 1.1502F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Tumor18Group = Torso.addOrReplaceChild("Tumor18Group", CubeListBuilder.create(), PartPose.offset(3.0876F, 0.082F, -0.8153F));

		PartDefinition Drip1_r1 = Tumor18Group.addOrReplaceChild("Drip1_r1", CubeListBuilder.create().texOffs(32, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5055F, 1.7204F, -0.1621F, 0.0F, -0.0524F, 0.0F));

		PartDefinition Faucet1_r1 = Tumor18Group.addOrReplaceChild("Faucet1_r1", CubeListBuilder.create().texOffs(96, 60).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.4574F, 0.3378F, -0.1345F, 0.0F, 0.0F, -1.6057F));

		PartDefinition Tumor18_r1 = Tumor18Group.addOrReplaceChild("Tumor18_r1", CubeListBuilder.create().texOffs(24, 73).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9629F, -2.0582F, 0.2966F, 2.3468F, -1.2105F, -2.4298F));

		PartDefinition tumor = Torso.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 3.0F));

		PartDefinition Tumor19_r1 = tumor.addOrReplaceChild("Tumor19_r1", CubeListBuilder.create().texOffs(58, 74).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.665F, 1.959F, -3.2142F, 0.645F, -1.139F, -0.6493F));

		PartDefinition Tumor20_r1 = tumor.addOrReplaceChild("Tumor20_r1", CubeListBuilder.create().texOffs(74, 62).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.3323F, 2.7569F, -2.3448F, 0.2781F, 0.0725F, 0.1957F));

		PartDefinition Tumor26_r1 = tumor.addOrReplaceChild("Tumor26_r1", CubeListBuilder.create().texOffs(78, 38).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-1.5199F, -2.2301F, 0.1381F, -2.5427F, -1.2048F, 2.0631F));

		PartDefinition Tumor27_r1 = tumor.addOrReplaceChild("Tumor27_r1", CubeListBuilder.create().texOffs(0, 79).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.4034F, -0.3768F, -0.7152F, -0.4119F, -0.9277F, 0.4971F));

		PartDefinition Tumor28_r1 = tumor.addOrReplaceChild("Tumor28_r1", CubeListBuilder.create().texOffs(24, 79).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.2544F, 3.3252F, -0.6545F, 0.5415F, -0.8747F, -0.6674F));

		PartDefinition TorsoClothingUpper = Torso.addOrReplaceChild("TorsoClothingUpper", CubeListBuilder.create(), PartPose.offset(-0.7552F, 19.0024F, 1.5501F));

		PartDefinition TorsoCloth6_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth6_r1", CubeListBuilder.create().texOffs(50, 94).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8278F, -23.1055F, 1.9661F, 2.8175F, 0.4847F, 3.0649F));

		PartDefinition TorsoCloth5_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth5_r1", CubeListBuilder.create().texOffs(94, 32).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6296F, -24.0374F, 1.5504F, 2.8557F, 0.0344F, -3.0731F));

		PartDefinition TorsoCloth4_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth4_r1", CubeListBuilder.create().texOffs(60, 85).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0849F, -23.1855F, -1.1815F, -0.3406F, 1.4828F, -0.1054F));

		PartDefinition TorsoCloth3_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth3_r1", CubeListBuilder.create().texOffs(90, 38).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.031F, -23.6716F, -1.1668F, 1.122F, -1.4693F, -1.4027F));

		PartDefinition TorsoCloth2_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth2_r1", CubeListBuilder.create().texOffs(20, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2307F, -23.6739F, -3.6495F, 0.1101F, -0.0491F, 0.2366F));

		PartDefinition TorsoCloth1_r1 = TorsoClothingUpper.addOrReplaceChild("TorsoCloth1_r1", CubeListBuilder.create().texOffs(84, 24).addBox(-2.5F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9045F, -22.6816F, -3.5413F, 0.1259F, 0.0244F, -0.0619F));

		PartDefinition TorsoClothingLower = Torso.addOrReplaceChild("TorsoClothingLower", CubeListBuilder.create(), PartPose.offset(-0.7552F, 19.0024F, 1.5501F));

		PartDefinition TorsoCloth12_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth12_r1", CubeListBuilder.create().texOffs(66, 94).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2478F, -15.6775F, -0.6449F, 1.5197F, 1.4377F, 1.7053F));

		PartDefinition TorsoCloth11_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth11_r1", CubeListBuilder.create().texOffs(58, 94).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3522F, -15.6775F, -0.6449F, 0.6786F, -1.3814F, -1.0114F));

		PartDefinition TorsoCloth10_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth10_r1", CubeListBuilder.create().texOffs(92, 87).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8478F, -15.6775F, 1.6551F, 2.9838F, 0.0679F, 3.0951F));

		PartDefinition TorsoCloth9_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth9_r1", CubeListBuilder.create().texOffs(40, 95).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1497F, -16.1573F, 1.7146F, 2.85F, -0.2122F, -3.0837F));

		PartDefinition TorsoCloth8_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth8_r1", CubeListBuilder.create().texOffs(94, 68).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1522F, -15.8775F, -2.7449F, -0.1931F, 0.0522F, 0.0311F));

		PartDefinition TorsoCloth7_r1 = TorsoClothingLower.addOrReplaceChild("TorsoCloth7_r1", CubeListBuilder.create().texOffs(32, 95).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8246F, -16.372F, -2.6747F, -0.1415F, -0.1019F, 0.0613F));

		PartDefinition TorsoFoliage = Torso.addOrReplaceChild("TorsoFoliage", CubeListBuilder.create(), PartPose.offset(-0.7552F, 19.0024F, 1.5501F));

		PartDefinition TorsoFoliage4_r1 = TorsoFoliage.addOrReplaceChild("TorsoFoliage4_r1", CubeListBuilder.create().texOffs(74, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0151F, -14.8065F, -2.7388F, -0.7736F, 0.2304F, 0.1789F));

		PartDefinition TorsoFoliage3_r1 = TorsoFoliage.addOrReplaceChild("TorsoFoliage3_r1", CubeListBuilder.create().texOffs(64, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5227F, -18.4893F, -2.8371F, -1.0938F, -0.1552F, -0.2033F));

		PartDefinition TorsoFoliage2_r1 = TorsoFoliage.addOrReplaceChild("TorsoFoliage2_r1", CubeListBuilder.create().texOffs(82, 68).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3637F, -23.6554F, -3.7648F, -0.7705F, 0.2426F, 0.1918F));

		PartDefinition TorsoFoliage1_r1 = TorsoFoliage.addOrReplaceChild("TorsoFoliage1_r1", CubeListBuilder.create().texOffs(82, 30).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6363F, -25.6554F, -3.7648F, -0.842F, -0.1471F, -0.0391F));

		PartDefinition BackFoliage = Torso.addOrReplaceChild("BackFoliage", CubeListBuilder.create(), PartPose.offset(-0.7552F, 19.0024F, 1.5501F));

		PartDefinition BackFoliage3_r1 = BackFoliage.addOrReplaceChild("BackFoliage3_r1", CubeListBuilder.create().texOffs(92, 52).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5227F, -26.0893F, 1.0629F, 1.95F, -0.2944F, -3.131F));

		PartDefinition BackFoliage2_r1 = BackFoliage.addOrReplaceChild("BackFoliage2_r1", CubeListBuilder.create().texOffs(92, 83).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0773F, -17.0893F, 1.6629F, 2.1447F, 0.2949F, 3.001F));

		PartDefinition BackFoliage1_r1 = BackFoliage.addOrReplaceChild("BackFoliage1_r1", CubeListBuilder.create().texOffs(10, 92).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2227F, -19.2893F, 1.6629F, 1.871F, 0.1117F, 2.942F));

		PartDefinition Arms = Mephitic.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(4.3F, -28.0F, -1.5F));

		PartDefinition Tumor23_r1 = LeftArm.addOrReplaceChild("Tumor23_r1", CubeListBuilder.create().texOffs(76, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.6983F, 3.7272F, 0.1026F, -0.2883F, -1.3579F, 0.2082F));

		PartDefinition LeftArmSeg3_r1 = LeftArm.addOrReplaceChild("LeftArmSeg3_r1", CubeListBuilder.create().texOffs(16, 40).addBox(-1.538F, -0.2577F, -1.3F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 10.1F, -0.3F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LeftArmSeg2_r1 = LeftArm.addOrReplaceChild("LeftArmSeg2_r1", CubeListBuilder.create().texOffs(48, 50).addBox(-2.1517F, -0.5317F, -1.9F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.1F, 4.7F, -0.2F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftArmSeg1_r1 = LeftArm.addOrReplaceChild("LeftArmSeg1_r1", CubeListBuilder.create().texOffs(50, 39).addBox(-0.3445F, -0.6426F, -2.1F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftClaws = LeftArm.addOrReplaceChild("LeftClaws", CubeListBuilder.create(), PartPose.offset(-4.3F, 27.1F, 1.5F));

		PartDefinition Claw4_r1 = LeftClaws.addOrReplaceChild("Claw4_r1", CubeListBuilder.create().texOffs(94, 77).addBox(0.0F, -1.0038F, -0.9128F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1F, -11.0F, -1.2F, 0.0F, -1.5708F, -0.0873F));

		PartDefinition Claw3_r1 = LeftClaws.addOrReplaceChild("Claw3_r1", CubeListBuilder.create().texOffs(74, 94).addBox(0.0F, -1.0038F, -1.0872F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, -11.0F, -0.6F, 0.0F, -1.5708F, 0.0873F));

		PartDefinition Claw2_r1 = LeftClaws.addOrReplaceChild("Claw2_r1", CubeListBuilder.create().texOffs(94, 71).addBox(0.0F, -1.0038F, -1.0872F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, -11.0F, -1.6F, 0.0F, -1.5708F, 0.0873F));

		PartDefinition Claw1_r1 = LeftClaws.addOrReplaceChild("Claw1_r1", CubeListBuilder.create().texOffs(78, 94).addBox(0.0F, -1.0038F, -1.0872F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, -11.0F, -2.5F, 0.0F, -1.5708F, 0.0873F));

		PartDefinition LeftArmFoliage = LeftArm.addOrReplaceChild("LeftArmFoliage", CubeListBuilder.create(), PartPose.offset(-4.3F, 27.1F, 1.5F));

		PartDefinition LeftArmFoliage4_r1 = LeftArmFoliage.addOrReplaceChild("LeftArmFoliage4_r1", CubeListBuilder.create().texOffs(88, 44).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6139F, -17.7549F, 0.4757F, 2.0036F, -0.0938F, -3.0774F));

		PartDefinition LeftArmFoliage3_r1 = LeftArmFoliage.addOrReplaceChild("LeftArmFoliage3_r1", CubeListBuilder.create().texOffs(92, 56).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9972F, -14.5114F, -2.8389F, -1.0221F, -0.2825F, -0.159F));

		PartDefinition LeftArmFoliage2_r1 = LeftArmFoliage.addOrReplaceChild("LeftArmFoliage2_r1", CubeListBuilder.create().texOffs(80, 55).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2301F, -21.3488F, -2.5092F, -1.0336F, 0.2066F, 0.1314F));

		PartDefinition LeftArmFoliage1_r1 = LeftArmFoliage.addOrReplaceChild("LeftArmFoliage1_r1", CubeListBuilder.create().texOffs(76, 50).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3637F, -19.6554F, -2.7648F, -1.1751F, -0.1919F, -0.1217F));

		PartDefinition LeftArmClothing = LeftArm.addOrReplaceChild("LeftArmClothing", CubeListBuilder.create(), PartPose.offset(-4.3F, 27.1F, 1.5F));

		PartDefinition ArmCloth4_r1 = LeftArmClothing.addOrReplaceChild("ArmCloth4_r1", CubeListBuilder.create().texOffs(94, 24).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0234F, -28.4545F, -1.4227F, 1.5854F, 0.0536F, 2.9794F));

		PartDefinition ArmCloth3_r1 = LeftArmClothing.addOrReplaceChild("ArmCloth3_r1", CubeListBuilder.create().texOffs(20, 94).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0234F, -26.5545F, 0.6773F, 2.8944F, 0.0536F, 2.9794F));

		PartDefinition ArmCloth2_r1 = LeftArmClothing.addOrReplaceChild("ArmCloth2_r1", CubeListBuilder.create().texOffs(94, 13).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5187F, -26.7669F, -1.8407F, -1.8601F, -1.3821F, 1.4425F));

		PartDefinition ArmCloth1_r1 = LeftArmClothing.addOrReplaceChild("ArmCloth1_r1", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -2.5F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5516F, -26.1638F, -3.9512F, -0.1767F, -0.0277F, -0.0365F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(56, 0).addBox(-4.9F, 3.6F, -1.6F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(-4.5F, -27.5F, -1.9F));

		PartDefinition LeftArmSeg4_r1 = RightArm.addOrReplaceChild("LeftArmSeg4_r1", CubeListBuilder.create().texOffs(60, 10).addBox(-1.3781F, -0.4452F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.6F, 0.4F, 0.0F, 0.0F, -0.0611F));

		PartDefinition LeftArmSeg2_r2 = RightArm.addOrReplaceChild("LeftArmSeg2_r2", CubeListBuilder.create().texOffs(0, 51).addBox(-4.1505F, -1.1483F, -1.6F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition RightArmTumors = RightArm.addOrReplaceChild("RightArmTumors", CubeListBuilder.create(), PartPose.offset(4.5F, 26.6F, 1.9F));

		PartDefinition Tumor13Group = RightArmTumors.addOrReplaceChild("Tumor13Group", CubeListBuilder.create(), PartPose.offset(-8.0F, -26.0F, -2.0F));

		PartDefinition Drip2_r1 = Tumor13Group.addOrReplaceChild("Drip2_r1", CubeListBuilder.create().texOffs(34, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9483F, 2.8F, -2.5275F, 0.0F, -0.0524F, 0.0F));

		PartDefinition Faucet2_r1 = Tumor13Group.addOrReplaceChild("Faucet2_r1", CubeListBuilder.create().texOffs(96, 62).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.9003F, 1.5175F, -2.5F, 0.0F, 0.0F, -1.6057F));

		PartDefinition Tumor13_r1 = Tumor13Group.addOrReplaceChild("Tumor13_r1", CubeListBuilder.create().texOffs(72, 6).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0496F, -0.1923F, -1.9899F, -2.9103F, -0.5694F, 2.7705F));

		PartDefinition tumor3 = RightArmTumors.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(-7.0F, -27.0F, -2.0F));

		PartDefinition Tumor11_r1 = tumor3.addOrReplaceChild("Tumor11_r1", CubeListBuilder.create().texOffs(70, 68).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(0.8122F, -2.1998F, 0.5062F, -2.5805F, -1.3251F, 2.4621F));

		PartDefinition Tumor10_r1 = tumor3.addOrReplaceChild("Tumor10_r1", CubeListBuilder.create().texOffs(70, 32).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0796F, -1.0348F, -1.4349F, -0.4195F, -1.2475F, 0.268F));

		PartDefinition Tumor9_r1 = tumor3.addOrReplaceChild("Tumor9_r1", CubeListBuilder.create().texOffs(12, 70).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.0124F, -0.4584F, 1.7571F, -0.1442F, 0.45F, -0.1951F));

		PartDefinition Tumor8_r1 = tumor3.addOrReplaceChild("Tumor8_r1", CubeListBuilder.create().texOffs(58, 68).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5482F, -0.9455F, 0.6162F, -0.131F, -0.1382F, -0.1139F));

		PartDefinition tumor4 = RightArmTumors.addOrReplaceChild("tumor4", CubeListBuilder.create(), PartPose.offset(-9.0F, -23.0F, -1.0F));

		PartDefinition Tumor17_r1 = tumor4.addOrReplaceChild("Tumor17_r1", CubeListBuilder.create().texOffs(0, 73).addBox(-1.6401F, -0.5664F, -5.1206F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(1.1559F, -3.258F, 0.2217F, -3.0267F, -1.2403F, -2.5403F));

		PartDefinition Tumor16_r1 = tumor4.addOrReplaceChild("Tumor16_r1", CubeListBuilder.create().texOffs(46, 72).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.931F, 2.6792F, -1.9605F, 2.8926F, -1.3698F, -2.6153F));

		PartDefinition Tumor15_r1 = tumor4.addOrReplaceChild("Tumor15_r1", CubeListBuilder.create().texOffs(72, 24).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1247F, 1.8357F, 1.0524F, 0.1637F, -1.3916F, -0.4463F));

		PartDefinition Tumor14_r1 = tumor4.addOrReplaceChild("Tumor14_r1", CubeListBuilder.create().texOffs(72, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5414F, -0.1138F, -2.0827F, -2.7735F, -1.0045F, 2.5821F));

		PartDefinition Tumor12_r1 = tumor4.addOrReplaceChild("Tumor12_r1", CubeListBuilder.create().texOffs(72, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.4897F, -2.7407F, 0.4385F, -2.1086F, -1.1733F, 2.0015F));

		PartDefinition RightClaws = RightArm.addOrReplaceChild("RightClaws", CubeListBuilder.create(), PartPose.offset(8.2F, 27.4F, 1.9F));

		PartDefinition Claw8_r1 = RightClaws.addOrReplaceChild("Claw8_r1", CubeListBuilder.create().texOffs(94, 90).addBox(0.0F, -1.0038F, -1.0872F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -12.3F, -1.1F, 0.0F, -1.5708F, 0.0873F));

		PartDefinition Claw7_r1 = RightClaws.addOrReplaceChild("Claw7_r1", CubeListBuilder.create().texOffs(90, 94).addBox(0.0F, -1.0038F, -0.9128F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -12.3F, -0.6F, 0.0F, -1.5708F, -0.0873F));

		PartDefinition Claw6_r1 = RightClaws.addOrReplaceChild("Claw6_r1", CubeListBuilder.create().texOffs(86, 94).addBox(0.0F, -1.0038F, -0.9128F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -12.3F, -1.6F, 0.0F, -1.5708F, -0.0873F));

		PartDefinition Claw5_r1 = RightClaws.addOrReplaceChild("Claw5_r1", CubeListBuilder.create().texOffs(82, 94).addBox(0.0F, -1.0038F, -0.9128F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -12.3F, -2.4F, 0.0F, -1.5708F, -0.0873F));

		PartDefinition RightArmEnhanced = RightArm.addOrReplaceChild("RightArmEnhanced", CubeListBuilder.create().texOffs(80, 85).addBox(-10.7F, -17.0F, -1.5F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 26.6F, 1.9F));

		PartDefinition BoneSpike3_r1 = RightArmEnhanced.addOrReplaceChild("BoneSpike3_r1", CubeListBuilder.create().texOffs(94, 96).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.521F, -25.1171F, -1.5F, 0.0F, 0.0F, 0.192F));

		PartDefinition BoneSpike2_r1 = RightArmEnhanced.addOrReplaceChild("BoneSpike2_r1", CubeListBuilder.create().texOffs(28, 95).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8302F, -20.0988F, -1.5F, 0.0F, 0.0F, 0.0349F));

		PartDefinition Bone5_r1 = RightArmEnhanced.addOrReplaceChild("Bone5_r1", CubeListBuilder.create().texOffs(96, 21).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.4F, -23.1F, -1.0F, 0.0F, 0.0F, -0.384F));

		PartDefinition Bone4_r1 = RightArmEnhanced.addOrReplaceChild("Bone4_r1", CubeListBuilder.create().texOffs(96, 19).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.704F, -21.3891F, -1.5F, 0.0F, 0.0F, -0.4712F));

		PartDefinition Bone3_r1 = RightArmEnhanced.addOrReplaceChild("Bone3_r1", CubeListBuilder.create().texOffs(96, 17).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.704F, -18.2891F, -1.5F, 0.0F, 0.0F, -0.4712F));

		PartDefinition Bone2_r1 = RightArmEnhanced.addOrReplaceChild("Bone2_r1", CubeListBuilder.create().texOffs(54, 86).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.504F, -16.4891F, -1.5F, 0.0F, 0.0F, -0.4538F));

		PartDefinition Bone1_r1 = RightArmEnhanced.addOrReplaceChild("Bone1_r1", CubeListBuilder.create().texOffs(14, 96).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.504F, -13.7891F, -1.5F, 0.0F, 0.0F, -0.4712F));

		PartDefinition DenseMuscle3_r1 = RightArmEnhanced.addOrReplaceChild("DenseMuscle3_r1", CubeListBuilder.create().texOffs(36, 84).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.03F)), PartPose.offsetAndRotation(-8.2948F, -14.7001F, -1.5F, 0.0F, 0.0F, -0.0524F));

		PartDefinition DenseMuscle2_r1 = RightArmEnhanced.addOrReplaceChild("DenseMuscle2_r1", CubeListBuilder.create().texOffs(84, 5).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-8.6052F, -20.0F, -1.5F, 0.0F, 0.0F, 0.0087F));

		PartDefinition DenseMuscle1_r1 = RightArmEnhanced.addOrReplaceChild("DenseMuscle1_r1", CubeListBuilder.create().texOffs(84, 83).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5918F, -23.8881F, -1.5F, 0.0F, 0.0F, 0.2182F));

		PartDefinition RightArmFoliage = RightArm.addOrReplaceChild("RightArmFoliage", CubeListBuilder.create(), PartPose.offset(4.5F, 26.6F, 1.9F));

		PartDefinition RightArmFoliage3_r1 = RightArmFoliage.addOrReplaceChild("RightArmFoliage3_r1", CubeListBuilder.create().texOffs(12, 82).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.1363F, -24.6554F, -1.4648F, 1.6614F, 1.3474F, 2.8368F));

		PartDefinition RightArmFoliage2_r1 = RightArmFoliage.addOrReplaceChild("RightArmFoliage2_r1", CubeListBuilder.create().texOffs(72, 80).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.4363F, -26.5554F, -3.6648F, -0.7363F, 0.9853F, 0.2442F));

		PartDefinition RightArmFoliage1_r1 = RightArmFoliage.addOrReplaceChild("RightArmFoliage1_r1", CubeListBuilder.create().texOffs(54, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0608F, -14.9638F, -2.851F, -1.2927F, -0.137F, -0.2208F));

		PartDefinition Legs = Mephitic.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(32, 50).addBox(-2.0F, -0.2F, -1.8F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(2.0F, -14.1F, -0.8F));

		PartDefinition Tumor29_r1 = LeftLeg.addOrReplaceChild("Tumor29_r1", CubeListBuilder.create().texOffs(48, 80).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.0328F, 5.7803F, 1.7564F, 0.4524F, 0.104F, -0.5756F));

		PartDefinition LeftLegFoliage = LeftLeg.addOrReplaceChild("LeftLegFoliage", CubeListBuilder.create(), PartPose.offset(-2.0F, 13.2F, 0.8F));

		PartDefinition LeftLegFoliage1_r1 = LeftLegFoliage.addOrReplaceChild("LeftLegFoliage1_r1", CubeListBuilder.create().texOffs(40, 91).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1849F, -8.9065F, -2.1388F, -0.894F, -0.5839F, -0.1485F));

		PartDefinition LeftLegClothing = LeftLeg.addOrReplaceChild("LeftLegClothing", CubeListBuilder.create(), PartPose.offset(-2.0F, 13.2F, 0.8F));

		PartDefinition PantCloth3_r1 = LeftLegClothing.addOrReplaceChild("PantCloth3_r1", CubeListBuilder.create().texOffs(94, 28).addBox(-2.5F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5964F, -11.9133F, 0.2926F, 1.7224F, -1.3775F, -2.0146F));

		PartDefinition PantCloth2_r1 = LeftLegClothing.addOrReplaceChild("PantCloth2_r1", CubeListBuilder.create().texOffs(24, 85).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5711F, -11.9833F, 1.7391F, 2.9607F, -0.0437F, 3.073F));

		PartDefinition PantCloth1_r1 = LeftLegClothing.addOrReplaceChild("PantCloth1_r1", CubeListBuilder.create().texOffs(88, 48).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4107F, -11.9842F, -2.9479F, -0.1971F, -0.173F, 0.0631F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, -1.0F));

		PartDefinition PantCloth7_r1 = leftForLeg.addOrReplaceChild("PantCloth7_r1", CubeListBuilder.create().texOffs(90, 42).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1452F, 0.5388F, 1.1954F, 1.0496F, 1.4899F, 1.191F));

		PartDefinition PantCloth6_r1 = leftForLeg.addOrReplaceChild("PantCloth6_r1", CubeListBuilder.create().texOffs(48, 78).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0297F, 0.5357F, 3.271F, 3.003F, 0.0448F, 3.0509F));

		PartDefinition PantCloth5_r1 = leftForLeg.addOrReplaceChild("PantCloth5_r1", CubeListBuilder.create().texOffs(86, 65).addBox(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1382F, 1.1248F, 1.6124F, -1.855F, -1.4447F, 1.7106F));

		PartDefinition LeftLegFoliage2_r1 = leftForLeg.addOrReplaceChild("LeftLegFoliage2_r1", CubeListBuilder.create().texOffs(92, 5).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7849F, 4.2934F, -0.3388F, -1.207F, 0.2797F, 0.2817F));

		PartDefinition PantCloth4_r1 = leftForLeg.addOrReplaceChild("PantCloth4_r1", CubeListBuilder.create().texOffs(84, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0107F, 1.2158F, -1.1479F, -0.1946F, -0.0703F, 0.0426F));

		PartDefinition LeftLegSeg1_r1 = leftForLeg.addOrReplaceChild("LeftLegSeg1_r1", CubeListBuilder.create().texOffs(16, 50).addBox(-2.0F, -0.5028F, -2.1309F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.053F, 1.3483F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-1.8F, -13.5F, -0.9F));

		PartDefinition Tumor21_r1 = RightLeg.addOrReplaceChild("Tumor21_r1", CubeListBuilder.create().texOffs(70, 74).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.4671F, 5.1803F, -1.1436F, -0.165F, 0.3082F, 0.2016F));

		PartDefinition RightLegSeg2_r1 = RightLeg.addOrReplaceChild("RightLegSeg2_r1", CubeListBuilder.create().texOffs(40, 0).addBox(-2.0F, -0.5029F, -1.8691F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.3F, -0.2359F, 0.1535F, -0.0436F, 0.0F, 0.0F));

		PartDefinition RightLegClothing = RightLeg.addOrReplaceChild("RightLegClothing", CubeListBuilder.create(), PartPose.offset(1.8F, 12.6F, 0.9F));

		PartDefinition PantCloth10_r1 = RightLegClothing.addOrReplaceChild("PantCloth10_r1", CubeListBuilder.create().texOffs(24, 70).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6152F, -11.5469F, -0.3349F, 2.268F, 1.3375F, 2.4356F));

		PartDefinition PantCloth9_r1 = RightLegClothing.addOrReplaceChild("PantCloth9_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3551F, -12.0857F, 1.7852F, 2.963F, 0.0657F, -2.9994F));

		PartDefinition PantCloth8_r1 = RightLegClothing.addOrReplaceChild("PantCloth8_r1", CubeListBuilder.create().texOffs(0, 85).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4689F, -11.9716F, -3.0668F, -0.2908F, 0.1438F, -0.0359F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.4F, -0.2F, -1.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition Tumor22_r1 = rightForLeg.addOrReplaceChild("Tumor22_r1", CubeListBuilder.create().texOffs(12, 76).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.057F, 0.4428F, -0.6444F, 0.3627F, 0.0405F, 0.3337F));

		PartDefinition RightLegFoliage = rightForLeg.addOrReplaceChild("RightLegFoliage", CubeListBuilder.create(), PartPose.offset(1.8F, 6.6F, 1.9F));

		PartDefinition RightLegFoliage2_r1 = RightLegFoliage.addOrReplaceChild("RightLegFoliage2_r1", CubeListBuilder.create().texOffs(92, 9).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4151F, -3.5065F, 0.8612F, 1.6929F, -0.424F, -2.9082F));

		PartDefinition RightLegFoliage1_r1 = RightLegFoliage.addOrReplaceChild("RightLegFoliage1_r1", CubeListBuilder.create().texOffs(30, 91).addBox(-2.5F, -2.0F, 0.0F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6151F, -5.5065F, -2.7388F, -0.8929F, 0.1566F, 0.1031F));

		PartDefinition Head = Mephitic.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -29.1F, -1.8F));

		PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw", CubeListBuilder.create().texOffs(32, 12).addBox(-4.0F, 0.0F, -4.2F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(64, 55).addBox(-4.0F, -2.0F, -4.1F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor7_r1 = LowerJaw.addOrReplaceChild("Tumor7_r1", CubeListBuilder.create().texOffs(34, 67).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.7467F, 2.0659F, 2.8347F, -0.2481F, -0.0844F, -0.1029F));

		PartDefinition Tumor6_r1 = LowerJaw.addOrReplaceChild("Tumor6_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7588F, 0.7965F, 3.0824F, -0.2258F, -0.1337F, -0.3077F));

		PartDefinition PotionDribble_r1 = LowerJaw.addOrReplaceChild("PotionDribble_r1", CubeListBuilder.create().texOffs(64, 57).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.1F, -4.3F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tumor5Group = LowerJaw.addOrReplaceChild("Tumor5Group", CubeListBuilder.create(), PartPose.offset(0.0F, -0.9F, 1.8F));

		PartDefinition Drip3_r1 = Tumor5Group.addOrReplaceChild("Drip3_r1", CubeListBuilder.create().texOffs(36, 27).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0516F, 5.1F, 1.8725F, 0.0F, -0.0524F, 0.0F));

		PartDefinition Faucet3_r1 = Tumor5Group.addOrReplaceChild("Faucet3_r1", CubeListBuilder.create().texOffs(96, 64).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0997F, 3.8175F, 1.9F, 0.0F, 0.0F, -1.6057F));

		PartDefinition Tumor5_r1 = Tumor5Group.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(34, 61).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3263F, 1.72F, 1.3712F, -0.2618F, 0.0F, 0.2182F));

		PartDefinition LowerFangs = LowerJaw.addOrReplaceChild("LowerFangs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLowerFang = LowerFangs.addOrReplaceChild("LeftLowerFang", CubeListBuilder.create(), PartPose.offset(3.3F, 1.9F, -2.6F));

		PartDefinition FangTooth3_r1 = LeftLowerFang.addOrReplaceChild("FangTooth3_r1", CubeListBuilder.create().texOffs(96, 2).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3067F, 0.2535F, -3.1408F, 2.4224F, -1.0294F, -2.3732F));

		PartDefinition FangBase3_r1 = LeftLowerFang.addOrReplaceChild("FangBase3_r1", CubeListBuilder.create().texOffs(36, 73).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4189F, -0.3927F, 0.0F));

		PartDefinition RightLowerFang = LowerFangs.addOrReplaceChild("RightLowerFang", CubeListBuilder.create(), PartPose.offset(-3.5F, 1.9F, -2.6F));

		PartDefinition FangTooth4_r1 = RightLowerFang.addOrReplaceChild("FangTooth4_r1", CubeListBuilder.create().texOffs(8, 96).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9277F, -0.0229F, -3.0766F, 0.9704F, -1.1829F, -0.986F));

		PartDefinition FangBase4_r1 = RightLowerFang.addOrReplaceChild("FangBase4_r1", CubeListBuilder.create().texOffs(84, 78).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3252F, 0.2793F, -0.0543F));

		PartDefinition Potion = LowerJaw.addOrReplaceChild("Potion", CubeListBuilder.create().texOffs(1, 100).addBox(-1.9925F, 3.5943F, -1.1567F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 106).addBox(-2.4925F, 0.5943F, -1.6567F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(5, 102).addBox(-0.9925F, -0.6557F, -0.1567F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
				.texOffs(1, 100).addBox(-1.9925F, -1.9057F, -1.1567F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(18, 100).addBox(-1.4925F, -3.4057F, -0.6567F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0599F, -0.2342F, -1.2032F, 0.8465F, 0.0249F, -0.0139F));

		PartDefinition HeadIntermediate = Head.addOrReplaceChild("HeadIntermediate", CubeListBuilder.create().texOffs(14, 61).addBox(3.6F, -3.9F, -3.8F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(24, 61).addBox(-4.0F, -3.9F, -3.8F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Neck_r1 = HeadIntermediate.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(56, 19).addBox(-4.25F, -3.261F, 0.9829F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.2F, -0.1309F, 0.0F, 0.0F));

		PartDefinition UpperHead = HeadIntermediate.addOrReplaceChild("UpperHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r1 = UpperHead.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -6.1053F, 1.2471F, -0.3142F, 0.0F, 0.0F));

		PartDefinition TopTeeth_r1 = UpperHead.addOrReplaceChild("TopTeeth_r1", CubeListBuilder.create().texOffs(62, 60).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5247F, -4.0071F, -0.2618F, 0.0F, 0.0F));

		PartDefinition TopFangs = UpperHead.addOrReplaceChild("TopFangs", CubeListBuilder.create(), PartPose.offset(0.0F, -3.9F, -3.2F));

		PartDefinition LeftTopFang = TopFangs.addOrReplaceChild("LeftTopFang", CubeListBuilder.create(), PartPose.offset(3.3F, 0.9F, 0.0F));

		PartDefinition FangTooth1_r1 = LeftTopFang.addOrReplaceChild("FangTooth1_r1", CubeListBuilder.create().texOffs(54, 88).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1111F, -1.6038F, -2.5682F, -2.8078F, -1.1479F, 2.7504F));

		PartDefinition FangBase1_r1 = LeftTopFang.addOrReplaceChild("FangBase1_r1", CubeListBuilder.create().texOffs(66, 44).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, -0.3927F, 0.0F));

		PartDefinition RightTopFang = TopFangs.addOrReplaceChild("RightTopFang", CubeListBuilder.create(), PartPose.offset(-3.4F, 0.9F, 0.0F));

		PartDefinition FangTooth2_r1 = RightTopFang.addOrReplaceChild("FangTooth2_r1", CubeListBuilder.create().texOffs(96, 0).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7005F, -1.5156F, -2.5814F, -0.351F, -1.2351F, 0.4249F));

		PartDefinition FangBase2_r1 = RightTopFang.addOrReplaceChild("FangBase2_r1", CubeListBuilder.create().texOffs(84, 13).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1525F, 0.3083F, 0.0552F));

		PartDefinition WitchHat = UpperHead.addOrReplaceChild("WitchHat", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2796F, -5.1351F, 10.2088F, -2.5661F, 0.0656F, 0.4162F));

		PartDefinition HatTopHalf = WitchHat.addOrReplaceChild("HatTopHalf", CubeListBuilder.create().texOffs(28, 28).addBox(-0.1047F, -3.8361F, -3.2052F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -1.0F, 2.0F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition HatTop = HatTopHalf.addOrReplaceChild("HatTop", CubeListBuilder.create().texOffs(56, 24).addBox(-0.3053F, -3.4694F, -3.5875F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition HatTopBit = HatTop.addOrReplaceChild("HatTopBit", CubeListBuilder.create().texOffs(20, 87).addBox(-0.6663F, -2.5979F, -4.2198F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition Nose = UpperHead.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(88, 18).addBox(-1.35F, -1.85F, -0.375F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(56, 10).addBox(-0.35F, 0.15F, -1.125F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.25F, -4.086F, -5.2219F, -0.2705F, 0.0F, 0.0F));

		PartDefinition Tumors = UpperHead.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(2.0F, -9.0F, 3.8F));

		PartDefinition ConnectiveTissue4_r1 = Tumors.addOrReplaceChild("ConnectiveTissue4_r1", CubeListBuilder.create().texOffs(78, 60).addBox(-2.0F, -1.0F, -1.0F, 4.3F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 5.0F, 2.6F, -1.8082F, -0.9412F, 1.698F));

		PartDefinition ConnectiveTissue3_r1 = Tumors.addOrReplaceChild("ConnectiveTissue3_r1", CubeListBuilder.create().texOffs(82, 35).addBox(-2.95F, -1.5F, 0.0F, 5.9F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.653F, 2.3682F, 4.7885F, -1.4006F, -1.4359F, 1.4903F));

		PartDefinition ConnectiveTissue2_r1 = Tumors.addOrReplaceChild("ConnectiveTissue2_r1", CubeListBuilder.create().texOffs(94, 36).addBox(-2.15F, -1.0F, 0.0F, 4.3F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.702F, 2.3354F, 4.3492F, -1.5751F, -1.4359F, 1.4903F));

		PartDefinition ConnectiveTissue1_r1 = Tumors.addOrReplaceChild("ConnectiveTissue1_r1", CubeListBuilder.create().texOffs(72, 30).addBox(-2.65F, -1.0F, 0.0F, 5.3F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.795F, 3.0287F, 5.2763F, -2.3709F, -1.3765F, 2.2955F));

		PartDefinition tumor1 = Tumors.addOrReplaceChild("tumor1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -4.0F));

		PartDefinition Tumor4_r1 = tumor1.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(66, 38).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.8094F, -0.2205F, 3.3353F, -0.6696F, -0.6508F, 0.4845F));

		PartDefinition Tumor25_r1 = tumor1.addOrReplaceChild("Tumor25_r1", CubeListBuilder.create().texOffs(36, 78).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.7343F, -1.8452F, -1.2589F, -0.1066F, -1.1138F, 0.4315F));

		PartDefinition Tumor24_r1 = tumor1.addOrReplaceChild("Tumor24_r1", CubeListBuilder.create().texOffs(76, 44).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.3278F, -1.0975F, -0.6441F, -2.6262F, -1.408F, 2.918F));

		PartDefinition tumor2 = Tumors.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-3.0F, 3.0F, 2.0F));

		PartDefinition Tumor1_r1 = tumor2.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(46, 66).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8128F, -0.3562F, -0.2F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Tumor2_r1 = tumor2.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(62, 62).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5087F, -1.5186F, 0.5129F, -0.5183F, -0.0783F, 0.0819F));

		PartDefinition Tumor3_r1 = tumor2.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(64, 49).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8457F, -2.5948F, 0.0359F, -0.5723F, -0.4229F, 0.2957F));

		PartDefinition HeadFoliage = UpperHead.addOrReplaceChild("HeadFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 29.1F, 1.8F));

		PartDefinition HeadFoliage9_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage9_r1", CubeListBuilder.create().texOffs(56, 32).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4821F, -33.3713F, 1.6687F, -1.9848F, -0.2479F, 0.3475F));

		PartDefinition HeadFoliage8_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage8_r1", CubeListBuilder.create().texOffs(10, 87).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.63F, -39.4151F, 3.909F, 0.0882F, -1.2453F, -1.5318F));

		PartDefinition HeadFoliage7_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage7_r1", CubeListBuilder.create().texOffs(86, 60).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7061F, -40.5366F, -2.1859F, 2.9278F, -0.8598F, 1.7864F));

		PartDefinition HeadFoliage6_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage6_r1", CubeListBuilder.create().texOffs(44, 86).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1941F, -39.8839F, 0.4299F, 1.8208F, 0.0106F, 2.7914F));

		PartDefinition HeadFoliage5_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage5_r1", CubeListBuilder.create().texOffs(70, 85).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8654F, -39.6012F, 1.0677F, -1.808F, 0.1354F, 0.3165F));

		PartDefinition HeadFoliage4_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage4_r1", CubeListBuilder.create().texOffs(0, 61).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4545F, -34.7003F, -0.7088F, -2.5495F, 0.7849F, -1.366F));

		PartDefinition HeadFoliage3_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage3_r1", CubeListBuilder.create().texOffs(84, 0).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6363F, -36.1554F, -2.7648F, -0.8305F, 0.9355F, 0.4832F));

		PartDefinition HeadFoliage2_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage2_r1", CubeListBuilder.create().texOffs(82, 73).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2363F, -39.0554F, -4.1648F, -1.3238F, -0.3942F, -0.1293F));

		PartDefinition HeadFoliage1_r1 = HeadFoliage.addOrReplaceChild("HeadFoliage1_r1", CubeListBuilder.create().texOffs(48, 60).addBox(-3.5F, -3.0F, 0.0F, 7.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5642F, -37.5108F, -4.3125F, -1.2466F, 0.0514F, 0.028F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.leftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.rightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.LowerJaw.xRot = Mth.sin(ageInTicks / 8) / 10;
		this.HeadIntermediate.xRot = -this.LowerJaw.xRot;
		animateTumor(tumor,Mth.sin(ageInTicks/8)/8);
		animateTumor(Tumor18Group,-Mth.sin(ageInTicks/8)/8);
		animateTumor(tumor1,-Mth.sin(-ageInTicks/7)/6);
		animateTumor(tumor2,Mth.cos(ageInTicks/6)/7);
		animateTumor(tumor3,Mth.sin(ageInTicks/7)/8);
		animateTumor(tumor4,Mth.cos(ageInTicks/7)/9);
		animateTumor(Tumor5Group,Mth.cos(ageInTicks/7)/7);
		float armAn = Mth.sin(ageInTicks/6)/6;
		if (entity.getAttackAnimationTick() <= 0){
			this.animateTentacleX(this.LeftArm, entity.isAggressive()? -1.5f + armAn : armAn);
		}else{
			int attackAnimationTick = entity.getAttackAnimationTick();
			if (attackAnimationTick > 0) {
                this.LeftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick, 20.0F);
			}
		}
		if (entity.getThrowAnimationTick() <= 0){
			this.animateTentacleX(this.RightArm, entity.isAggressive()? -1.5f - armAn : armAn);
		}else{
			int throwAnimationTick = entity.getThrowAnimationTick();
			if (throwAnimationTick > 0) {
                RightArm.xRot = 2.0F - 1.5F * Mth.triangleWave((float)throwAnimationTick, 20.0F);
			}
		}
		if (entity.getMouthAnimationTick() <= 0){
			this.animateTentacleX(this.HeadIntermediate,-this.LowerJaw.xRot);
		}else{
			int throwAnimationTick = entity.getMouthAnimationTick();
			if (throwAnimationTick > 0) {
				HeadIntermediate.xRot = 1.5F * Mth.triangleWave((float)throwAnimationTick, 20.0F);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Mephitic.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}