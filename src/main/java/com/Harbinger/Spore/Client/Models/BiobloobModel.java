package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Experiments.Biobloob;
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

public class BiobloobModel<T extends Biobloob> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "biobloobmodel"), "main");
	private final ModelPart bioblobgoonsludge;
	private final ModelPart Tumor1;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Head1;
	private final ModelPart Head2;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart Tentacle1;
	private final ModelPart Tentacle2;
	private final ModelPart Tentacle3;
	private final ModelPart Tentacle4;
	private final ModelPart Tentacle11;
	private final ModelPart Tentacle21;
	private final ModelPart Tentacle31;
	private final ModelPart Tentacle41;
	private final ModelPart Tentacle12;
	private final ModelPart Tentacle22;
	private final ModelPart Tentacle32;
	private final ModelPart Tentacle42;
	private final ModelPart BruteArm;
	private final ModelPart BruteForArm;
	private final ModelPart Tumor5;
	private final ModelPart Tumor6;
	private final ModelPart Tumor7;
	private final ModelPart Tumor8;
	private final ModelPart BigLeg1;
	private final ModelPart BigLeg2;
	private final ModelPart SmallBackLeg1;
	private final ModelPart SmallBackLeg2;
	private final ModelPart SmallBackLeg3;
	private final ModelPart SmallBackLeg4;
	private final ModelPart LowerLeg1;
	private final ModelPart LowerLeg2;
	private final ModelPart LowerLeg3;
	private final ModelPart LowerLeg4;

	public BiobloobModel(ModelPart root) {
		this.bioblobgoonsludge = root.getChild("bioblobgoonsludge");
		this.Tumor1 = bioblobgoonsludge.getChild("Body").getChild("BodyMass").getChild("BodyTumors").getChild("Tumors4");
		this.Tumor2 = bioblobgoonsludge.getChild("Body").getChild("BodyMass").getChild("BodyTumors").getChild("Tumors5");
		this.Tumor3 = bioblobgoonsludge.getChild("Body").getChild("BodyMass").getChild("BodyTumors").getChild("Tumors6");
		this.Tumor4 = bioblobgoonsludge.getChild("Body").getChild("BodyMass").getChild("BodyTumors").getChild("Tumors7");
		this.Head1 = bioblobgoonsludge.getChild("Body").getChild("Heads").getChild("BileHead");
		this.Head2 = bioblobgoonsludge.getChild("Body").getChild("Heads").getChild("AcidHead");
		this.Jaw1 = Head1.getChild("Jaw2");
		this.Jaw2 = Head2.getChild("Jaw3");
		this.Tentacle1 = bioblobgoonsludge.getChild("Body").getChild("BackTendrils").getChild("BackTendril");
		this.Tentacle2 = bioblobgoonsludge.getChild("Body").getChild("BackTendrils").getChild("BackTendril2");
		this.Tentacle3 = bioblobgoonsludge.getChild("Body").getChild("BackTendrils").getChild("BackTendril3");
		this.Tentacle4 = bioblobgoonsludge.getChild("Body").getChild("BackTendrils").getChild("BackTendril4");
		this.Tentacle11 = Tentacle1.getChild("Seg2Tendril1");
		this.Tentacle21 = Tentacle2.getChild("Seg2Tendril2");
		this.Tentacle31 = Tentacle3.getChild("Seg2Tendril3");
		this.Tentacle41 = Tentacle4.getChild("Seg2Tendril4");
		this.Tentacle12 = Tentacle11.getChild("Seg3Tendril1");
		this.Tentacle22 = Tentacle21.getChild("Seg3Tendril2");
		this.Tentacle32 = Tentacle31.getChild("Seg3Tendril3");
		this.Tentacle42 = Tentacle41.getChild("Seg3Tendril4");
		this.BruteArm = bioblobgoonsludge.getChild("Body").getChild("BruteArm");
		this.BruteForArm = BruteArm.getChild("BruteArmStart").getChild("BruteArmMiddle");
		this.Tumor5 = BruteArm.getChild("BruteArmStart").getChild("BruteArmTumorsStart");
		this.Tumor6 = BruteForArm.getChild("ArmTumors").getChild("Tumors");
		this.Tumor7 = BruteForArm.getChild("ArmTumors").getChild("Tumors2");
		this.Tumor8 = BruteForArm.getChild("ArmTumors").getChild("Tumors3");
		this.BigLeg1 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LargeFrontLeg");
		this.BigLeg2 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LargeMiddleLeg");
		this.SmallBackLeg1 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("SmallHindLeg");
		this.SmallBackLeg2 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("SmallHindLeg2");
		this.SmallBackLeg3 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("SmallHindLeg3");
		this.SmallBackLeg4 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("SmallHindLeg4");
		this.LowerLeg1 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LowerLegs").getChild("LowerLeg");
		this.LowerLeg2 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LowerLegs").getChild("LowerLeg2");
		this.LowerLeg3 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LowerLegs").getChild("LowerLeg3");
		this.LowerLeg4 = bioblobgoonsludge.getChild("Body").getChild("Legs").getChild("LowerLegs").getChild("LowerLeg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bioblobgoonsludge = partdefinition.addOrReplaceChild("bioblobgoonsludge", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Body = bioblobgoonsludge.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BodyMass = Body.addOrReplaceChild("BodyMass", CubeListBuilder.create(), PartPose.offset(6.5F, -7.4F, -2.0F));

		PartDefinition MeltedMass_r1 = BodyMass.addOrReplaceChild("MeltedMass_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5F, -15.0F, -8.4F, 16.0F, 15.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2967F, -0.5236F, 0.0F));

		PartDefinition MeltedMass_r2 = BodyMass.addOrReplaceChild("MeltedMass_r2", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -13.0F, -15.0F, 13.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.5F, 0.0F, 5.6F, -0.2488F, 0.2575F, -0.0175F));

		PartDefinition MeltedMass_r3 = BodyMass.addOrReplaceChild("MeltedMass_r3", CubeListBuilder.create().texOffs(51, 51).addBox(-4.0F, -14.0F, -15.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 3.6F, 16.6F, -0.1571F, -0.1571F, 0.0F));

		PartDefinition MeltedMass_r4 = BodyMass.addOrReplaceChild("MeltedMass_r4", CubeListBuilder.create().texOffs(73, 17).addBox(-8.0F, -9.0F, -1.0F, 9.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.6F, 0.2F, 4.8F, 0.0F, 0.1396F, 0.0873F));

		PartDefinition MeltedMass_r5 = BodyMass.addOrReplaceChild("MeltedMass_r5", CubeListBuilder.create().texOffs(0, 77).addBox(-3.0F, -7.0F, -15.0F, 8.0F, 7.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.7F, 4.9F, 24.6F, -0.5236F, 0.0F, 0.0F));

		PartDefinition CalciumGrowths = BodyMass.addOrReplaceChild("CalciumGrowths", CubeListBuilder.create(), PartPose.offset(-1.5F, -12.1F, 11.1F));

		PartDefinition CalciumGrowth_r1 = CalciumGrowths.addOrReplaceChild("CalciumGrowth_r1", CubeListBuilder.create().texOffs(134, 165).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2475F, -0.1182F, 0.1439F));

		PartDefinition CalciumGrowth_r2 = CalciumGrowths.addOrReplaceChild("CalciumGrowth_r2", CubeListBuilder.create().texOffs(158, 72).addBox(-4.0F, -5.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.5F, -8.6F, 1.168F, -0.6365F, 0.3154F));

		PartDefinition CalciumGrowth_r3 = CalciumGrowths.addOrReplaceChild("CalciumGrowth_r3", CubeListBuilder.create().texOffs(49, 165).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8F, -0.9F, -7.7F, 1.1961F, -0.2163F, 0.0574F));

		PartDefinition CalciumGrowth_r4 = CalciumGrowths.addOrReplaceChild("CalciumGrowth_r4", CubeListBuilder.create().texOffs(142, 156).addBox(-4.0F, -5.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6F, -2.6F, -10.7F, 1.2043F, -0.0698F, 0.0F));

		PartDefinition BodyTumors = BodyMass.addOrReplaceChild("BodyTumors", CubeListBuilder.create(), PartPose.offset(-6.5F, 7.4F, 2.0F));

		PartDefinition Tumors7 = BodyTumors.addOrReplaceChild("Tumors7", CubeListBuilder.create(), PartPose.offset(-1.7F, -17.6F, 8.1F));

		PartDefinition Tumor_r1 = Tumors7.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(100, 158).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1158F, 0.29F, -0.2187F));

		PartDefinition Tumor_r2 = Tumors7.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(149, 165).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.4F, -0.2603F, -0.4036F, -0.1378F));

		PartDefinition Tumors6 = BodyTumors.addOrReplaceChild("Tumors6", CubeListBuilder.create(), PartPose.offset(1.7F, -10.4F, 12.8F));

		PartDefinition Tumor_r3 = Tumors6.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(164, 165).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2603F, -0.4036F, -0.1378F));

		PartDefinition Tumor_r4 = Tumors6.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(76, 161).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.2F, 1.1F, -0.1158F, 0.29F, -0.2187F));

		PartDefinition Tumors5 = BodyTumors.addOrReplaceChild("Tumors5", CubeListBuilder.create(), PartPose.offset(10.3F, -14.5F, 3.6F));

		PartDefinition Tumor_r5 = Tumors5.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(93, 167).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.6201F, -0.7687F, 2.4592F));

		PartDefinition Tumor_r6 = Tumors5.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(117, 158).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -1.8F, -0.8F, -0.0149F, 0.0931F, -0.0901F));

		PartDefinition Tumors4 = BodyTumors.addOrReplaceChild("Tumors4", CubeListBuilder.create(), PartPose.offset(-5.3F, -18.4F, -11.7F));

		PartDefinition Tumor_r7 = Tumors4.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(159, 156).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0507F, 0.1866F, 0.0241F));

		PartDefinition Tumor_r8 = Tumors4.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(167, 98).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -1.0F, 0.0F, -0.2603F, -0.4036F, -0.1378F));

		PartDefinition Heads = Body.addOrReplaceChild("Heads", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BileHead = Heads.addOrReplaceChild("BileHead", CubeListBuilder.create(), PartPose.offset(0.0F, -15.2F, -9.4F));

		PartDefinition BileHead_r1 = BileHead.addOrReplaceChild("BileHead_r1", CubeListBuilder.create().texOffs(78, 91).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.2F, -3.9F, 0.0F, 0.0F, -0.0349F));

		PartDefinition Jaw2 = BileHead.addOrReplaceChild("Jaw2", CubeListBuilder.create(), PartPose.offset(-1.0F, 1.2F, 1.1F));

		PartDefinition BileJaw_r1 = Jaw2.addOrReplaceChild("BileJaw_r1", CubeListBuilder.create().texOffs(111, 88).addBox(-4.0F, 0.2F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.2F, -1.1F, 0.3127F, -0.0291F, 0.1096F));

		PartDefinition BileGrowth = Jaw2.addOrReplaceChild("BileGrowth", CubeListBuilder.create(), PartPose.offset(-1.3F, 4.2F, -6.4F));

		PartDefinition BileGrowth_r1 = BileGrowth.addOrReplaceChild("BileGrowth_r1", CubeListBuilder.create().texOffs(133, 72).addBox(-1.0F, -2.0F, -1.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2793F, 0.0F, 0.0F));

		PartDefinition AcidHead = Heads.addOrReplaceChild("AcidHead", CubeListBuilder.create(), PartPose.offset(2.6F, -17.7F, -7.1F));

		PartDefinition Head_r1 = AcidHead.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 97).addBox(-4.0F, -32.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 26.2F, -3.9F, -0.0244F, -0.6104F, 0.0426F));

		PartDefinition Jaw3 = AcidHead.addOrReplaceChild("Jaw3", CubeListBuilder.create().texOffs(100, 55).addBox(-4.0F, 0.2F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, -0.6109F, 0.0F));

		PartDefinition AcidGrowth = Jaw3.addOrReplaceChild("AcidGrowth", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1F, 2.65F, -5.6F, -0.2618F, 0.0F, 0.0F));

		PartDefinition BileGrowth_r2 = AcidGrowth.addOrReplaceChild("BileGrowth_r2", CubeListBuilder.create().texOffs(177, 69).addBox(-1.0F, -2.0F, -1.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, -0.5F, 0.2793F, 0.0F, 0.0F));

		PartDefinition BodyRoots = Body.addOrReplaceChild("BodyRoots", CubeListBuilder.create(), PartPose.offset(-6.6F, -6.8F, 8.0F));

		PartDefinition HangingRoots_r1 = BodyRoots.addOrReplaceChild("HangingRoots_r1", CubeListBuilder.create().texOffs(172, 16).addBox(-1.0F, -2.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition HangingRoots_r2 = BodyRoots.addOrReplaceChild("HangingRoots_r2", CubeListBuilder.create().texOffs(170, 143).addBox(-1.0F, -2.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6F, 1.4F, -2.3F, 0.0F, -0.3927F, 0.0F));

		PartDefinition HangingRoots_r3 = BodyRoots.addOrReplaceChild("HangingRoots_r3", CubeListBuilder.create().texOffs(77, 170).addBox(-1.0F, -2.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.0F, -13.4F, 0.0F, -0.5236F, 0.0F));

		PartDefinition HangingRoots_r4 = BodyRoots.addOrReplaceChild("HangingRoots_r4", CubeListBuilder.create().texOffs(123, 167).addBox(-1.0F, -2.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6F, 1.6F, -10.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Flowers = Body.addOrReplaceChild("Flowers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Flower = Flowers.addOrReplaceChild("Flower", CubeListBuilder.create(), PartPose.offset(9.3F, -24.5F, -4.4F));

		PartDefinition Petal_r1 = Flower.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(144, 84).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r2 = Flower.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(118, 8).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7468F, -0.0494F, 2.1983F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Petal_r3 = Flower.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(118, 0).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1468F, 0.4506F, -1.8017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r4 = Flower.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(87, 143).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5708F, 0.7825F, -3.5017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower2 = Flowers.addOrReplaceChild("Flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.9F, -33.7F, 9.7F, -0.121F, -0.017F, -0.1386F));

		PartDefinition Petal_r5 = Flower2.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(144, 91).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9F, 14.5F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r6 = Flower2.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(118, 32).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6468F, 14.4507F, -0.3017F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Petal_r7 = Flower2.addOrReplaceChild("Petal_r7", CubeListBuilder.create().texOffs(118, 24).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0468F, 14.9507F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r8 = Flower2.addOrReplaceChild("Petal_r8", CubeListBuilder.create().texOffs(118, 16).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.3292F, 15.2825F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower3 = Flowers.addOrReplaceChild("Flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.3F, -16.4F, -6.4F, 0.986F, 0.1878F, 0.2749F));

		PartDefinition Petal_r9 = Flower3.addOrReplaceChild("Petal_r9", CubeListBuilder.create().texOffs(147, 18).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -3.6F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r10 = Flower3.addOrReplaceChild("Petal_r10", CubeListBuilder.create().texOffs(0, 128).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6468F, -4.4494F, -0.3017F, 0.4316F, -0.0662F, 0.1426F));

		PartDefinition Petal_r11 = Flower3.addOrReplaceChild("Petal_r11", CubeListBuilder.create().texOffs(110, 127).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3468F, -3.1494F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r12 = Flower3.addOrReplaceChild("Petal_r12", CubeListBuilder.create().texOffs(81, 125).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3708F, -2.8175F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower4 = Flowers.addOrReplaceChild("Flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(12.5F, -15.0F, -7.5F, 1.2392F, -0.7854F, 0.0F));

		PartDefinition Petal_r13 = Flower4.addOrReplaceChild("Petal_r13", CubeListBuilder.create().texOffs(147, 25).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.4F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r14 = Flower4.addOrReplaceChild("Petal_r14", CubeListBuilder.create().texOffs(133, 48).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2468F, -0.4494F, -0.3017F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Petal_r15 = Flower4.addOrReplaceChild("Petal_r15", CubeListBuilder.create().texOffs(133, 40).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6468F, 0.0506F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r16 = Flower4.addOrReplaceChild("Petal_r16", CubeListBuilder.create().texOffs(29, 131).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0708F, 0.3825F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower5 = Flowers.addOrReplaceChild("Flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6F, -14.5F, 22.3F, -0.9009F, -0.1312F, 0.1637F));

		PartDefinition Petal_r17 = Flower5.addOrReplaceChild("Petal_r17", CubeListBuilder.create().texOffs(29, 147).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 1.5F, 1.8F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r18 = Flower5.addOrReplaceChild("Petal_r18", CubeListBuilder.create().texOffs(133, 64).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0532F, 1.4506F, 3.9983F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Petal_r19 = Flower5.addOrReplaceChild("Petal_r19", CubeListBuilder.create().texOffs(58, 133).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3468F, 1.9506F, -0.0017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r20 = Flower5.addOrReplaceChild("Petal_r20", CubeListBuilder.create().texOffs(133, 56).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3708F, 2.2825F, -1.7017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower8 = Flowers.addOrReplaceChild("Flower8", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.2F, -22.9F, -5.8F, -1.7928F, 0.351F, -2.5051F));

		PartDefinition Petal_r21 = Flower8.addOrReplaceChild("Petal_r21", CubeListBuilder.create().texOffs(54, 149).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -3.6F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r22 = Flower8.addOrReplaceChild("Petal_r22", CubeListBuilder.create().texOffs(58, 141).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6468F, -4.4494F, -0.3017F, 0.4316F, -0.0662F, 0.1426F));

		PartDefinition Petal_r23 = Flower8.addOrReplaceChild("Petal_r23", CubeListBuilder.create().texOffs(139, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3468F, -3.1494F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r24 = Flower8.addOrReplaceChild("Petal_r24", CubeListBuilder.create().texOffs(29, 139).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3708F, -2.8175F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower9 = Flowers.addOrReplaceChild("Flower9", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.7F, -12.2F, 5.4F, 0.0F, -0.2793F, -1.6406F));

		PartDefinition Petal_r25 = Flower9.addOrReplaceChild("Petal_r25", CubeListBuilder.create().texOffs(145, 149).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r26 = Flower9.addOrReplaceChild("Petal_r26", CubeListBuilder.create().texOffs(0, 144).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7468F, -0.0494F, 2.1983F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Petal_r27 = Flower9.addOrReplaceChild("Petal_r27", CubeListBuilder.create().texOffs(81, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1468F, 0.4506F, -1.8017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r28 = Flower9.addOrReplaceChild("Petal_r28", CubeListBuilder.create().texOffs(116, 143).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5708F, 0.7825F, -3.5017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition BackTendrils = Body.addOrReplaceChild("BackTendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackTendril = BackTendrils.addOrReplaceChild("BackTendril", CubeListBuilder.create().texOffs(191, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3837F, -17.9057F, 9.9892F, -0.0257F, 0.5567F, 0.3306F));

		PartDefinition Seg2Tendril1 = BackTendril.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(204, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0137F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(241, 8).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition BackTendril2 = BackTendrils.addOrReplaceChild("BackTendril2", CubeListBuilder.create().texOffs(191, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7163F, -16.3057F, 9.1892F, 2.993F, 0.2598F, 2.946F));

		PartDefinition Seg2Tendril2 = BackTendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(204, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0137F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(241, 8).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition BackTendril3 = BackTendrils.addOrReplaceChild("BackTendril3", CubeListBuilder.create().texOffs(191, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8163F, -17.9057F, 2.8892F, 0.1478F, 1.0801F, -0.0214F));

		PartDefinition Seg2Tendril3 = BackTendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(204, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(241, 8).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition BackTendril4 = BackTendrils.addOrReplaceChild("BackTendril4", CubeListBuilder.create().texOffs(191, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3163F, -15.2057F, 11.5892F, -2.4625F, -0.2259F, 2.2159F));

		PartDefinition Seg2Tendril4 = BackTendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(204, 20).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0137F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(241, 8).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition BruteArm = Body.addOrReplaceChild("BruteArm", CubeListBuilder.create(), PartPose.offset(-12.0F, -19.0F, -1.0F));

		PartDefinition BruteArmStart = BruteArm.addOrReplaceChild("BruteArmStart", CubeListBuilder.create(), PartPose.offset(1.9F, -2.9F, -1.9F));

		PartDefinition BruteArmBeginning_r1 = BruteArmStart.addOrReplaceChild("BruteArmBeginning_r1", CubeListBuilder.create().texOffs(51, 76).addBox(-4.0F, -7.0F, -6.0F, 17.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.4F, 1.2F, -0.1F, -0.1805F, -0.2797F, 0.584F));

		PartDefinition BruteArmTumorsStart = BruteArmStart.addOrReplaceChild("BruteArmTumorsStart", CubeListBuilder.create(), PartPose.offset(-5.2F, 0.0F, 1.1F));

		PartDefinition Tumor_r9 = BruteArmTumorsStart.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(0, 159).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1158F, 0.29F, -0.2187F));

		PartDefinition Tumor_r10 = BruteArmTumorsStart.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(164, 0).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 0.0F, -1.1F, -0.2603F, -0.4036F, -0.1378F));

		PartDefinition BruteArmMiddle = BruteArmStart.addOrReplaceChild("BruteArmMiddle", CubeListBuilder.create(), PartPose.offset(-12.9F, -5.3F, -4.2F));

		PartDefinition BruteArmMiddle_r1 = BruteArmMiddle.addOrReplaceChild("BruteArmMiddle_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-20.0F, -8.0F, -7.0F, 27.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 3.3F, 3.2F, 0.1567F, -0.0109F, -1.5018F));

		PartDefinition HangingArms = BruteArmMiddle.addOrReplaceChild("HangingArms", CubeListBuilder.create(), PartPose.offset(-2.1F, 7.4F, 3.0F));

		PartDefinition HangingArm_r1 = HangingArms.addOrReplaceChild("HangingArm_r1", CubeListBuilder.create().texOffs(27, 114).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.62F, 0.7323F, 2.9725F));

		PartDefinition HangingArm_r2 = HangingArms.addOrReplaceChild("HangingArm_r2", CubeListBuilder.create().texOffs(0, 112).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 10.9F, -4.9F, 0.4887F, 0.6283F, 0.0F));

		PartDefinition HangingArm_r3 = HangingArms.addOrReplaceChild("HangingArm_r3", CubeListBuilder.create().texOffs(54, 117).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, 7.1F, -2.2F, -2.6859F, -0.9193F, -2.9387F));

		PartDefinition ArmCalciumGrowths = BruteArmMiddle.addOrReplaceChild("ArmCalciumGrowths", CubeListBuilder.create().texOffs(42, 156).addBox(0.9F, 3.4F, -4.6F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.9F, 2.8F, -1.8F));

		PartDefinition CalciumGrowth_r5 = ArmCalciumGrowths.addOrReplaceChild("CalciumGrowth_r5", CubeListBuilder.create().texOffs(59, 156).addBox(-4.0F, -5.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.952F, 1.2475F, -0.9266F));

		PartDefinition CalciumGrowth_r6 = ArmCalciumGrowths.addOrReplaceChild("CalciumGrowth_r6", CubeListBuilder.create().texOffs(34, 165).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 5.7F, -0.3F, -0.5272F, 1.3559F, -0.4871F));

		PartDefinition CalciumGrowth_r7 = ArmCalciumGrowths.addOrReplaceChild("CalciumGrowth_r7", CubeListBuilder.create().texOffs(164, 8).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, 14.1F, -3.2F, 0.0F, 0.0F, 0.1571F));

		PartDefinition ArmHead = BruteArmMiddle.addOrReplaceChild("ArmHead", CubeListBuilder.create(), PartPose.offset(23.0F, 27.2F, 7.1F));

		PartDefinition Head = ArmHead.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(-23.8F, -36.3F, -2.0F));

		PartDefinition ArmHead_r1 = Head.addOrReplaceChild("ArmHead_r1", CubeListBuilder.create().texOffs(100, 40).addBox(-4.6949F, -5.9729F, -1.0764F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.2772F, -0.6146F, 0.0409F));

		PartDefinition Jaw = ArmHead.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(-21.0F, -30.2F, -9.1F));

		PartDefinition ArmJaw_r1 = Jaw.addOrReplaceChild("ArmJaw_r1", CubeListBuilder.create().texOffs(100, 66).addBox(-4.0F, 0.2F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, 2.0F, -0.3858F, 0.6655F, -0.8726F));

		PartDefinition ArmTumors = BruteArmMiddle.addOrReplaceChild("ArmTumors", CubeListBuilder.create(), PartPose.offset(-2.0F, -0.8F, -0.9F));

		PartDefinition Tumors3 = ArmTumors.addOrReplaceChild("Tumors3", CubeListBuilder.create(), PartPose.offset(-4.8F, 20.8F, -1.2F));

		PartDefinition Tumor_r11 = Tumors3.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(162, 39).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.149F, 0.4262F, -0.2304F));

		PartDefinition Tumor_r12 = Tumors3.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(108, 167).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 0.0F, 1.4F, -0.2802F, -0.2652F, -0.1313F));

		PartDefinition Tumors2 = ArmTumors.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offset(1.1F, 3.2F, -4.1F));

		PartDefinition Tumor_r13 = Tumors2.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(167, 106).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4081F, -0.7217F, -0.026F));

		PartDefinition Tumor_r14 = Tumors2.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(17, 161).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.3F, -0.7F, -0.1158F, 0.29F, -0.2187F));

		PartDefinition Tumors = ArmTumors.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(4.4F, -1.8F, 2.6F));

		PartDefinition Tumor_r15 = Tumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(162, 48).addBox(-3.0F, -4.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, -0.1571F, 0.0F));

		PartDefinition Tumor_r16 = Tumors.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(79, 151).addBox(-4.0F, -4.0F, -4.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -0.2F, -0.2F, -0.0361F, 0.2241F, -0.1611F));

		PartDefinition BruteArmEnd = BruteArmMiddle.addOrReplaceChild("BruteArmEnd", CubeListBuilder.create(), PartPose.offset(2.0F, 27.2F, -5.9F));

		PartDefinition ArmRoots_r1 = BruteArmEnd.addOrReplaceChild("ArmRoots_r1", CubeListBuilder.create().texOffs(65, 0).addBox(-4.0F, 0.0F, -1.0F, 10.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 10.9F, 0.9435F, -0.2136F, 0.1525F));

		PartDefinition BruteArmBottom_r1 = BruteArmEnd.addOrReplaceChild("BruteArmBottom_r1", CubeListBuilder.create().texOffs(41, 91).addBox(-34.0F, -9.0F, -8.0F, 7.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3F, 28.3F, 8.3F, -0.1047F, 0.0F, 1.5882F));

		PartDefinition BruteArmHangingArmsEnd = BruteArmEnd.addOrReplaceChild("BruteArmHangingArmsEnd", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HangingArm_r4 = BruteArmHangingArmsEnd.addOrReplaceChild("HangingArm_r4", CubeListBuilder.create().texOffs(111, 99).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, -0.8901F, 0.0F));

		PartDefinition HangingArm_r5 = BruteArmHangingArmsEnd.addOrReplaceChild("HangingArm_r5", CubeListBuilder.create().texOffs(111, 113).addBox(0.0F, -4.0F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.1F, 0.0F, 8.5F, -2.8362F, 1.3614F, 3.1416F));

		PartDefinition Flower6 = BruteArmMiddle.addOrReplaceChild("Flower6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4F, 10.8F, -0.4F, 1.0535F, 0.8585F, 0.0119F));

		PartDefinition Petal_r29 = Flower6.addOrReplaceChild("Petal_r29", CubeListBuilder.create().texOffs(73, 40).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -3.6F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r30 = Flower6.addOrReplaceChild("Petal_r30", CubeListBuilder.create().texOffs(0, 136).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6468F, -4.4494F, -0.3017F, 0.4316F, -0.0662F, 0.1426F));

		PartDefinition Petal_r31 = Flower6.addOrReplaceChild("Petal_r31", CubeListBuilder.create().texOffs(116, 135).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3468F, -3.1494F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r32 = Flower6.addOrReplaceChild("Petal_r32", CubeListBuilder.create().texOffs(87, 135).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3708F, -2.8175F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Flower7 = BruteArmStart.addOrReplaceChild("Flower7", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.1F, -4.3F, 0.5F, 0.9259F, -0.4034F, 0.0383F));

		PartDefinition Petal_r33 = Flower7.addOrReplaceChild("Petal_r33", CubeListBuilder.create().texOffs(147, 32).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -3.6F, -2.5F, -0.0618F, 0.2828F, 0.3069F));

		PartDefinition Petal_r34 = Flower7.addOrReplaceChild("Petal_r34", CubeListBuilder.create().texOffs(138, 115).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6468F, -4.4493F, -0.3017F, 0.4316F, -0.0662F, 0.1426F));

		PartDefinition Petal_r35 = Flower7.addOrReplaceChild("Petal_r35", CubeListBuilder.create().texOffs(138, 107).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3468F, -3.1494F, -4.3017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal_r36 = Flower7.addOrReplaceChild("Petal_r36", CubeListBuilder.create().texOffs(138, 99).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3708F, -2.8175F, -6.0017F, -0.0338F, 0.1603F, 0.1693F));

		PartDefinition Legs = Body.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LowerLegs = Legs.addOrReplaceChild("LowerLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LowerLeg = LowerLegs.addOrReplaceChild("LowerLeg", CubeListBuilder.create(), PartPose.offset(8.6F, -7.4F, -1.6F));

		PartDefinition FleshLeg_r1 = LowerLeg.addOrReplaceChild("FleshLeg_r1", CubeListBuilder.create().texOffs(0, 168).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3665F));

		PartDefinition FleshLeg_r2 = LowerLeg.addOrReplaceChild("FleshLeg_r2", CubeListBuilder.create().texOffs(44, 173).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 7.4F, -0.4F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LowerLeg2 = LowerLegs.addOrReplaceChild("LowerLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.2F, -7.4F, -7.1F, 0.0F, -0.1047F, 0.0F));

		PartDefinition FleshLeg_r3 = LowerLeg2.addOrReplaceChild("FleshLeg_r3", CubeListBuilder.create().texOffs(168, 114).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1134F));

		PartDefinition FleshLeg_r4 = LowerLeg2.addOrReplaceChild("FleshLeg_r4", CubeListBuilder.create().texOffs(53, 173).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 7.4F, -0.4F, 0.0F, 0.0F, 0.2182F));

		PartDefinition LowerLeg3 = LowerLegs.addOrReplaceChild("LowerLeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4F, -7.4F, 19.4F, -0.0187F, 0.2611F, -0.0723F));

		PartDefinition FleshLeg_r5 = LowerLeg3.addOrReplaceChild("FleshLeg_r5", CubeListBuilder.create().texOffs(169, 81).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3665F));

		PartDefinition FleshLeg_r6 = LowerLeg3.addOrReplaceChild("FleshLeg_r6", CubeListBuilder.create().texOffs(134, 173).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 7.4F, -0.4F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LowerLeg4 = LowerLegs.addOrReplaceChild("LowerLeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.4F, -7.4F, -0.2F, 0.0F, 0.9076F, 0.0F));

		PartDefinition FleshLeg_r7 = LowerLeg4.addOrReplaceChild("FleshLeg_r7", CubeListBuilder.create().texOffs(13, 170).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3665F));

		PartDefinition FleshLeg_r8 = LowerLeg4.addOrReplaceChild("FleshLeg_r8", CubeListBuilder.create().texOffs(143, 173).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 7.4F, -0.4F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LargeFrontLeg = Legs.addOrReplaceChild("LargeFrontLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(8.1F, -16.0F, 0.1F, -0.0436F, 0.0F, 0.0F));

		PartDefinition FleshLeg_r9 = LargeFrontLeg.addOrReplaceChild("FleshLeg_r9", CubeListBuilder.create().texOffs(162, 57).addBox(-1.0F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 16.0F, -6.0F, -0.1692F, 0.3068F, -0.5149F));

		PartDefinition FleshLeg_r10 = LargeFrontLeg.addOrReplaceChild("FleshLeg_r10", CubeListBuilder.create().texOffs(145, 131).addBox(-1.0F, -13.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.4F, 11.4F, -5.4F, -0.1859F, 0.6038F, -0.3198F));

		PartDefinition FleshLeg_r11 = LargeFrontLeg.addOrReplaceChild("FleshLeg_r11", CubeListBuilder.create().texOffs(78, 106).addBox(-1.0F, -5.0F, -1.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 1.6F, -1.9F, 0.0692F, 0.2527F, 0.2706F));

		PartDefinition LargeMiddleLeg = Legs.addOrReplaceChild("LargeMiddleLeg", CubeListBuilder.create(), PartPose.offset(17.8F, 0.0F, 15.7F));

		PartDefinition FleshLeg_r12 = LargeMiddleLeg.addOrReplaceChild("FleshLeg_r12", CubeListBuilder.create().texOffs(162, 131).addBox(-1.0F, -8.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2819F, -0.0678F, -0.6825F));

		PartDefinition FleshLeg_r13 = LargeMiddleLeg.addOrReplaceChild("FleshLeg_r13", CubeListBuilder.create().texOffs(147, 0).addBox(-1.0F, -13.0F, -1.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1F, -3.8F, -3.1F, 0.1499F, -0.7561F, -0.2167F));

		PartDefinition FleshLeg_r14 = LargeMiddleLeg.addOrReplaceChild("FleshLeg_r14", CubeListBuilder.create().texOffs(100, 77).addBox(-1.0F, -5.0F, -1.0F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.2F, -12.8F, -10.6F, -0.1216F, -0.6536F, 0.1983F));

		PartDefinition SmallHindLeg4 = Legs.addOrReplaceChild("SmallHindLeg4", CubeListBuilder.create().texOffs(26, 173).addBox(5.0F, 2.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.9F, -9.0F, 17.9F));

		PartDefinition FleshLeg_r15 = SmallHindLeg4.addOrReplaceChild("FleshLeg_r15", CubeListBuilder.create().texOffs(21, 154).addBox(-6.0F, -3.0F, -2.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 3.0F, 1.0F, 0.0978F, 0.262F, 0.362F));

		PartDefinition SmallHindLeg3 = Legs.addOrReplaceChild("SmallHindLeg3", CubeListBuilder.create().texOffs(172, 25).addBox(-6.0F, 0.0F, 0.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.8F, -7.0F, 19.0F));

		PartDefinition FleshLeg_r16 = SmallHindLeg3.addOrReplaceChild("FleshLeg_r16", CubeListBuilder.create().texOffs(100, 151).addBox(-6.0F, -3.0F, -2.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 1.0F, -0.1F, -0.025F, 0.2782F, -0.0908F));

		PartDefinition SmallHindLeg2 = Legs.addOrReplaceChild("SmallHindLeg2", CubeListBuilder.create().texOffs(35, 173).addBox(-7.0F, 1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.2F, -8.0F, 15.4F));

		PartDefinition FleshLeg_r17 = SmallHindLeg2.addOrReplaceChild("FleshLeg_r17", CubeListBuilder.create().texOffs(0, 152).addBox(-6.0F, -3.0F, -2.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 0.7F, 0.1F, -0.0234F, 0.1199F, -0.1934F));

		PartDefinition SmallHindLeg = Legs.addOrReplaceChild("SmallHindLeg", CubeListBuilder.create().texOffs(41, 77).addBox(-5.0F, 1.0F, -3.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.2F, -9.0F, 11.9F));

		PartDefinition FleshLeg_r18 = SmallHindLeg.addOrReplaceChild("FleshLeg_r18", CubeListBuilder.create().texOffs(121, 151).addBox(-6.0F, -3.0F, -2.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 1.2F, 1.0F, 0.0772F, -0.4121F, -0.1907F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTentacleX(Head1,headPitch /  ( 90F / (float) Math.PI));
		this.animateTentacleX(Head2,headPitch /  ( 90F / (float) Math.PI));
		this.animateTentacleZ(Head2,netHeadYaw / (180F / (float) Math.PI));
		this.animateTentacleX(Jaw1, Mth.sin(ageInTicks/6)/7);
		this.animateTentacleX(Jaw2, Mth.sin(ageInTicks/7)/6);
		this.animateTumor(Tumor1,Mth.cos(ageInTicks/8)/7);
		this.animateTumor(Tumor2,-Mth.sin(ageInTicks/7)/7);
		this.animateTumor(Tumor3,Mth.cos(ageInTicks/8)/8);
		this.animateTumor(Tumor4,Mth.sin(ageInTicks/8)/7);
		this.animateTumor(Tumor5,-Mth.cos(ageInTicks/8)/6);
		this.animateTumor(Tumor6,Mth.sin(ageInTicks/6)/7);
		this.animateTumor(Tumor7,Mth.sin(ageInTicks/6)/7);
		this.animateTumor(Tumor8,-Mth.cos(ageInTicks/8)/7);
		this.animateTentacleZ(Tentacle1,Mth.sin(ageInTicks/6)/6);
		this.animateTentacleZ(Tentacle11,Mth.sin(ageInTicks/5)/6);
		this.animateTentacleZ(Tentacle12,Mth.sin(ageInTicks/4)/6);
		this.animateTentacleZ(Tentacle2,-Mth.sin(ageInTicks/6)/8);
		this.animateTentacleZ(Tentacle21,-Mth.sin(ageInTicks/5)/8);
		this.animateTentacleZ(Tentacle22,-Mth.sin(ageInTicks/4)/8);
		this.animateTentacleZ(Tentacle3,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleZ(Tentacle31,Mth.cos(ageInTicks/5)/6);
		this.animateTentacleZ(Tentacle32,Mth.cos(ageInTicks/4)/6);
		this.animateTentacleZ(Tentacle4,-Mth.cos(ageInTicks/6)/7);
		this.animateTentacleZ(Tentacle41,-Mth.cos(ageInTicks/5)/7);
		this.animateTentacleZ(Tentacle42,-Mth.cos(ageInTicks/4)/7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bioblobgoonsludge.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}