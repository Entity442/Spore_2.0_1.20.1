package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Utility.Vanguard;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class VanguardModel<T extends Vanguard> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "vanguardmodel"), "main");
	private final ModelPart Vanguard;
	private final ModelPart TorsoPivot;
	private final ModelPart Head;
	private final ModelPart UpperHead;
	private final ModelPart EyeTendrils;
	private final ModelPart LT1;
	private final ModelPart LT1Seg2;
	private final ModelPart LT2;
	private final ModelPart LT2Seg2;
	private final ModelPart LT3;
	private final ModelPart LT3Seg2;
	private final ModelPart Banner;
	private final ModelPart HeadFoliage;
	private final ModelPart HeadPetalCrowns;
	private final ModelPart HeadCrown1;
	private final ModelPart HeadCrown2;
	private final ModelPart HeadCrown3;
	private final ModelPart HeadSparseFoliage;
	private final ModelPart HeadTumors;
	private final ModelPart HeadTumorCluster1;
	private final ModelPart HeadTumorCluster2;
	private final ModelPart LowerJaw;
	private final ModelPart Torso;
	private final ModelPart Chest;
	private final ModelPart ChestFoliage;
	private final ModelPart ChestPetalCrown;
	private final ModelPart ChestSparseFoliage;
	private final ModelPart Stomach;
	private final ModelPart StomachFoliage;
	private final ModelPart TorsoBase;
	private final ModelPart TorsoBaseFoliage;
	private final ModelPart TorsoBaseTumor;
	private final ModelPart BackDetails;
	private final ModelPart BackTendrils;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Seg3Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Seg3Tendril2;
	private final ModelPart Tendril3Pouch;
	private final ModelPart Seg2Tendril3;
	private final ModelPart Seg3Tendril3;
	private final ModelPart FireworkPouch;
	private final ModelPart Pouch;
	private final ModelPart Fireworks;
	private final ModelPart Tendril4Eye;
	private final ModelPart Seg2Tendril4;
	private final ModelPart Seg3Tendril4;
	private final ModelPart Eye;
	private final ModelPart EyeTumors;
	private final ModelPart VigilEye;
	private final ModelPart pupil;
	private final ModelPart BackTumors;
	private final ModelPart BackTumorCluster1;
	private final ModelPart BackTumorCluster2;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart RightArmTop;
	private final ModelPart RightArmTopFoliage;
	private final ModelPart RightArmBottom;
	private final ModelPart RightArmBottomFoliage;
	private final ModelPart LeftBladeArm;
	private final ModelPart LeftArmTop;
	private final ModelPart LeftArmTopBloatage;
	private final ModelPart LeftArmTopBottomTumors;
	private final ModelPart LeftArmTopBottomOvergrownTumors;
	private final ModelPart LeftArmTopFoliage;
	private final ModelPart Blade;
	private final ModelPart BladeSpikes;
	private final ModelPart BladeRibs;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart RightLegTop;
	private final ModelPart RightLegBottom;
	private final ModelPart RightLegPetalCrown;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegTop;
	private final ModelPart LeftLegTopFoliage;
	private final ModelPart LeftLegBottom;
	private final ModelPart LeftLegBloatage;
	private final ModelPart LeftLegBottomTumors;
	private final ModelPart LeftLegBottomOvergrownTumors;
	private final ModelPart LeftLegBottomFoliage;
	public final List<ModelPart> partList;
	public final List<ModelPart> pouchPartList;
	public final List<ModelPart> torsoPartList;

	public VanguardModel(ModelPart root) {
		this.Vanguard = root.getChild("Vanguard");
		this.TorsoPivot = this.Vanguard.getChild("TorsoPivot");
		this.Head = this.TorsoPivot.getChild("Head");
		this.UpperHead = this.Head.getChild("UpperHead");
		this.EyeTendrils = this.UpperHead.getChild("EyeTendrils");
		this.LT1 = this.EyeTendrils.getChild("LT1");
		this.LT1Seg2 = this.LT1.getChild("LT1Seg2");
		this.LT2 = this.EyeTendrils.getChild("LT2");
		this.LT2Seg2 = this.LT2.getChild("LT2Seg2");
		this.LT3 = this.EyeTendrils.getChild("LT3");
		this.LT3Seg2 = this.LT3.getChild("LT3Seg2");
		this.Banner = this.UpperHead.getChild("Banner");
		this.HeadFoliage = this.UpperHead.getChild("HeadFoliage");
		this.HeadPetalCrowns = this.HeadFoliage.getChild("HeadPetalCrowns");
		this.HeadCrown1 = this.HeadPetalCrowns.getChild("HeadCrown1");
		this.HeadCrown2 = this.HeadPetalCrowns.getChild("HeadCrown2");
		this.HeadCrown3 = this.HeadPetalCrowns.getChild("HeadCrown3");
		this.HeadSparseFoliage = this.HeadFoliage.getChild("HeadSparseFoliage");
		this.HeadTumors = this.UpperHead.getChild("HeadTumors");
		this.HeadTumorCluster1 = this.HeadTumors.getChild("HeadTumorCluster1");
		this.HeadTumorCluster2 = this.HeadTumors.getChild("HeadTumorCluster2");
		this.LowerJaw = this.Head.getChild("LowerJaw");
		this.Torso = this.TorsoPivot.getChild("Torso");
		this.Chest = this.Torso.getChild("Chest");
		this.ChestFoliage = this.Chest.getChild("ChestFoliage");
		this.ChestPetalCrown = this.ChestFoliage.getChild("ChestPetalCrown");
		this.ChestSparseFoliage = this.ChestFoliage.getChild("ChestSparseFoliage");
		this.Stomach = this.Torso.getChild("Stomach");
		this.StomachFoliage = this.Stomach.getChild("StomachFoliage");
		this.TorsoBase = this.Torso.getChild("TorsoBase");
		this.TorsoBaseFoliage = this.TorsoBase.getChild("TorsoBaseFoliage");
		this.TorsoBaseTumor = this.TorsoBase.getChild("TorsoBaseTumor");
		this.BackDetails = this.Torso.getChild("BackDetails");
		this.BackTendrils = this.BackDetails.getChild("BackTendrils");
		this.Tendril1 = this.BackTendrils.getChild("Tendril1");
		this.Seg2Tendril1 = this.Tendril1.getChild("Seg2Tendril1");
		this.Seg3Tendril1 = this.Seg2Tendril1.getChild("Seg3Tendril1");
		this.Tendril2 = this.BackTendrils.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Seg3Tendril2 = this.Seg2Tendril2.getChild("Seg3Tendril2");
		this.Tendril3Pouch = this.BackTendrils.getChild("Tendril3Pouch");
		this.Seg2Tendril3 = this.Tendril3Pouch.getChild("Seg2Tendril3");
		this.Seg3Tendril3 = this.Seg2Tendril3.getChild("Seg3Tendril3");
		this.FireworkPouch = this.Seg3Tendril3.getChild("FireworkPouch");
		this.Pouch = this.FireworkPouch.getChild("Pouch");
		this.Fireworks = this.FireworkPouch.getChild("Fireworks");
		this.Tendril4Eye = this.BackTendrils.getChild("Tendril4Eye");
		this.Seg2Tendril4 = this.Tendril4Eye.getChild("Seg2Tendril4");
		this.Seg3Tendril4 = this.Seg2Tendril4.getChild("Seg3Tendril4");
		this.Eye = this.Seg3Tendril4.getChild("Eye");
		this.EyeTumors = this.Eye.getChild("EyeTumors");
		this.VigilEye = this.Eye.getChild("VigilEye");
		this.pupil = this.VigilEye.getChild("pupil");
		this.BackTumors = this.BackDetails.getChild("BackTumors");
		this.BackTumorCluster1 = this.BackTumors.getChild("BackTumorCluster1");
		this.BackTumorCluster2 = this.BackTumors.getChild("BackTumorCluster2");
		this.Arms = this.TorsoPivot.getChild("Arms");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightArmTop = this.RightArm.getChild("RightArmTop");
		this.RightArmTopFoliage = this.RightArmTop.getChild("RightArmTopFoliage");
		this.RightArmBottom = this.RightArm.getChild("RightArmBottom");
		this.RightArmBottomFoliage = this.RightArmBottom.getChild("RightArmBottomFoliage");
		this.LeftBladeArm = this.Arms.getChild("LeftBladeArm");
		this.LeftArmTop = this.LeftBladeArm.getChild("LeftArmTop");
		this.LeftArmTopBloatage = this.LeftArmTop.getChild("LeftArmTopBloatage");
		this.LeftArmTopBottomTumors = this.LeftArmTopBloatage.getChild("LeftArmTopBottomTumors");
		this.LeftArmTopBottomOvergrownTumors = this.LeftArmTopBloatage.getChild("LeftArmTopBottomOvergrownTumors");
		this.LeftArmTopFoliage = this.LeftArmTop.getChild("LeftArmTopFoliage");
		this.Blade = this.LeftBladeArm.getChild("Blade");
		this.BladeSpikes = this.Blade.getChild("BladeSpikes");
		this.BladeRibs = this.Blade.getChild("BladeRibs");
		this.Legs = this.Vanguard.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightLegTop = this.RightLeg.getChild("RightLegTop");
		this.RightLegBottom = this.RightLeg.getChild("RightLegBottom");
		this.RightLegPetalCrown = this.RightLegBottom.getChild("RightLegPetalCrown");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftLegTop = this.LeftLeg.getChild("LeftLegTop");
		this.LeftLegTopFoliage = this.LeftLegTop.getChild("LeftLegTopFoliage");
		this.LeftLegBottom = this.LeftLeg.getChild("LeftLegBottom");
		this.LeftLegBloatage = this.LeftLegBottom.getChild("LeftLegBloatage");
		this.LeftLegBottomTumors = this.LeftLegBloatage.getChild("LeftLegBottomTumors");
		this.LeftLegBottomOvergrownTumors = this.LeftLegBloatage.getChild("LeftLegBottomOvergrownTumors");
		this.LeftLegBottomFoliage = this.LeftLegBottom.getChild("LeftLegBottomFoliage");
		partList = List.of(Vanguard,TorsoPivot,Arms,RightArm,RightArmBottom);
		pouchPartList = List.of(Vanguard,TorsoPivot,Torso,BackDetails,BackTendrils,Tendril3Pouch,Seg2Tendril3,Seg3Tendril3,FireworkPouch);
		torsoPartList = List.of(Vanguard,TorsoPivot,Torso,TorsoBase);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Vanguard = partdefinition.addOrReplaceChild("Vanguard", CubeListBuilder.create(), PartPose.offset(0.0F, 23.9F, -0.5F));

		PartDefinition TorsoPivot = Vanguard.addOrReplaceChild("TorsoPivot", CubeListBuilder.create(), PartPose.offset(0.0F, -17.9724F, -0.4447F));

		PartDefinition Head = TorsoPivot.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(82, 14).addBox(-4.1693F, -0.8699F, -2.4694F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1693F, -15.6576F, -1.6859F));

		PartDefinition UpperHead = Head.addOrReplaceChild("UpperHead", CubeListBuilder.create().texOffs(36, 36).addBox(-4.1693F, -8.8699F, -6.4694F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(106, 0).addBox(-1.1693F, -2.8699F, -8.4694F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(82, 70).addBox(-4.1693F, -0.8699F, -6.4694F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition EyeTendrils = UpperHead.addOrReplaceChild("EyeTendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5841F, -3.2804F, -6.0171F, 1.6144F, 0.0F, 0.0F));

		PartDefinition LT1 = EyeTendrils.addOrReplaceChild("LT1", CubeListBuilder.create().texOffs(52, 103).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0816F, 1.2335F, -0.2848F, -0.1745F, -0.3054F, 0.0F));

		PartDefinition LT1Seg2 = LT1.addOrReplaceChild("LT1Seg2", CubeListBuilder.create().texOffs(60, 103).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.5236F, -0.3054F, 0.0F));

		PartDefinition LT2 = EyeTendrils.addOrReplaceChild("LT2", CubeListBuilder.create().texOffs(52, 103).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.1997F, 1.2933F, -0.1967F, -2.8324F, -0.7976F, 3.0438F));

		PartDefinition LT2Seg2 = LT2.addOrReplaceChild("LT2Seg2", CubeListBuilder.create().texOffs(60, 103).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.5236F, -0.2618F, 0.0873F));

		PartDefinition LT3 = EyeTendrils.addOrReplaceChild("LT3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2397F, 0.8012F, 0.9481F, -2.8979F, -1.0862F, -3.118F));

		PartDefinition LT3Seg1_r1 = LT3.addOrReplaceChild("LT3Seg1_r1", CubeListBuilder.create().texOffs(52, 103).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LT3Seg2 = LT3.addOrReplaceChild("LT3Seg2", CubeListBuilder.create().texOffs(60, 103).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.4363F, -0.6545F, 0.5236F));

		PartDefinition Banner = UpperHead.addOrReplaceChild("Banner", CubeListBuilder.create().texOffs(0, 53).addBox(-0.9906F, -31.8091F, -0.8223F, 2.0F, 35.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.3693F, -6.5699F, 1.564F, -0.0698F, 0.0F, 0.192F));

		PartDefinition Fabric_r1 = Banner.addOrReplaceChild("Fabric_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.6F, -10.0F, -0.5F, 40.0F, 20.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0094F, -32.6091F, -0.6223F, 0.0F, 0.0F, 1.5708F));

		PartDefinition PoleTop_r1 = Banner.addOrReplaceChild("PoleTop_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -20.0F, -1.0F, 2.0F, 20.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-9.9906F, -32.2091F, 0.1777F, 0.0F, 0.0F, 1.5708F));

		PartDefinition HeadFoliage = UpperHead.addOrReplaceChild("HeadFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadPetalCrowns = HeadFoliage.addOrReplaceChild("HeadPetalCrowns", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadCrown1 = HeadPetalCrowns.addOrReplaceChild("HeadCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1557F, -7.6199F, -4.2444F, 0.2079F, -0.0916F, 0.4093F));

		PartDefinition HeadCrown3Petal4_r1 = HeadCrown1.addOrReplaceChild("HeadCrown3Petal4_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, -0.55F, 2.475F, 1.5987F, -0.809F, -1.4656F));

		PartDefinition HeadCrown3Petal3_r1 = HeadCrown1.addOrReplaceChild("HeadCrown3Petal3_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.525F, -0.85F, -0.125F, 3.1206F, 0.0406F, -2.4075F));

		PartDefinition HeadCrown2Petal2_r1 = HeadCrown1.addOrReplaceChild("HeadCrown2Petal2_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, 0.25F, -3.125F, -1.3678F, 1.0218F, -1.0041F));

		PartDefinition HeadCrown1Petal1_r1 = HeadCrown1.addOrReplaceChild("HeadCrown1Petal1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.575F, 0.85F, 0.175F, 0.2223F, -0.2149F, -0.4082F));

		PartDefinition HeadCrown2 = HeadPetalCrowns.addOrReplaceChild("HeadCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.9443F, -8.5199F, -4.2444F, 0.0826F, 0.0903F, -0.4449F));

		PartDefinition HeadCrown2Petal4_r1 = HeadCrown2.addOrReplaceChild("HeadCrown2Petal4_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, -0.55F, 2.475F, 1.5987F, -0.809F, -1.4656F));

		PartDefinition HeadCrown2Petal3_r1 = HeadCrown2.addOrReplaceChild("HeadCrown2Petal3_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.525F, -0.85F, -0.125F, 3.1206F, 0.0406F, -2.4075F));

		PartDefinition HeadCrown2Petal2_r2 = HeadCrown2.addOrReplaceChild("HeadCrown2Petal2_r2", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, 0.25F, -3.125F, -1.3678F, 1.0218F, -1.0041F));

		PartDefinition HeadCrown2Petal1_r1 = HeadCrown2.addOrReplaceChild("HeadCrown2Petal1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.575F, 0.85F, 0.175F, 0.2223F, -0.2149F, -0.4082F));

		PartDefinition HeadCrown3 = HeadPetalCrowns.addOrReplaceChild("HeadCrown3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9557F, -5.5199F, 2.9556F, -1.7145F, 0.004F, -0.4323F));

		PartDefinition HeadCrown3Petal4_r2 = HeadCrown3.addOrReplaceChild("HeadCrown3Petal4_r2", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, -0.55F, 2.475F, 1.5987F, -0.809F, -1.4656F));

		PartDefinition HeadCrown3Petal3_r2 = HeadCrown3.addOrReplaceChild("HeadCrown3Petal3_r2", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.525F, -0.85F, -0.125F, 3.1206F, 0.0406F, -2.4075F));

		PartDefinition HeadCrown3Petal2_r1 = HeadCrown3.addOrReplaceChild("HeadCrown3Petal2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, 0.25F, -3.125F, -1.3678F, 1.0218F, -1.0041F));

		PartDefinition HeadCrown3Petal1_r1 = HeadCrown3.addOrReplaceChild("HeadCrown3Petal1_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.575F, 0.85F, 0.175F, 0.2223F, -0.2149F, -0.4082F));

		PartDefinition HeadSparseFoliage = HeadFoliage.addOrReplaceChild("HeadSparseFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadSparseFoliage3_r1 = HeadSparseFoliage.addOrReplaceChild("HeadSparseFoliage3_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1693F, -4.0699F, -2.1694F, 0.346F, -0.6226F, -0.3787F));

		PartDefinition HeadSparseFoliage2_r1 = HeadSparseFoliage.addOrReplaceChild("HeadSparseFoliage2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3693F, -6.6699F, -5.6694F, 0.3054F, 0.4126F, -0.0457F));

		PartDefinition HeadSparseFoliage1_r1 = HeadSparseFoliage.addOrReplaceChild("HeadSparseFoliage1_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4307F, -1.6699F, -6.7694F, 0.2315F, -0.1243F, -0.1383F));

		PartDefinition HeadTumors = UpperHead.addOrReplaceChild("HeadTumors", CubeListBuilder.create(), PartPose.offset(4.0F, -4.0F, -1.0F));

		PartDefinition HeadTumorCluster1 = HeadTumors.addOrReplaceChild("HeadTumorCluster1", CubeListBuilder.create(), PartPose.offset(-4.7693F, -0.3699F, 2.5306F));

		PartDefinition HeadTumor2_r1 = HeadTumorCluster1.addOrReplaceChild("HeadTumor2_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.4F, 0.9F, 0.0F, -2.7338F, -0.1147F, 0.4246F));

		PartDefinition HeadTumor1_r1 = HeadTumorCluster1.addOrReplaceChild("HeadTumor1_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.4F, -0.9F, 0.0F, -2.0432F, -0.6191F, 0.1636F));

		PartDefinition HeadTumorCluster2 = HeadTumors.addOrReplaceChild("HeadTumorCluster2", CubeListBuilder.create(), PartPose.offset(-0.0026F, -0.0699F, 0.264F));

		PartDefinition HeadTumor5_r1 = HeadTumorCluster2.addOrReplaceChild("HeadTumor5_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(0.1333F, 0.6F, -0.7333F, -1.8437F, -0.1147F, 0.4246F));

		PartDefinition HeadTumor4_r1 = HeadTumorCluster2.addOrReplaceChild("HeadTumor4_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.1333F, 0.6F, 1.1667F, -2.7338F, -0.1147F, 0.4246F));

		PartDefinition HeadTumor3_r1 = HeadTumorCluster2.addOrReplaceChild("HeadTumor3_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.2667F, -1.2F, -0.4333F, -2.0432F, -0.6191F, 0.1636F));

		PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw", CubeListBuilder.create(), PartPose.offset(-0.3392F, -0.4276F, -2.8397F));

		PartDefinition LowerTeeth4_r1 = LowerJaw.addOrReplaceChild("LowerTeeth4_r1", CubeListBuilder.create().texOffs(112, 69).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6159F, 1.7698F, -1.9485F, 0.6442F, -0.0699F, -0.0016F));

		PartDefinition LowerTeeth3_r1 = LowerJaw.addOrReplaceChild("LowerTeeth3_r1", CubeListBuilder.create().texOffs(99, 69).addBox(-1.5F, -1.0F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5841F, 1.1698F, -1.9485F, 1.4322F, 0.4519F, 1.5158F));

		PartDefinition LowerTeeth2_r1 = LowerJaw.addOrReplaceChild("LowerTeeth2_r1", CubeListBuilder.create().texOffs(97, 69).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2159F, 2.3698F, -2.3485F, 1.2675F, 0.3664F, 1.1071F));

		PartDefinition LowerTeeth1_r1 = LowerJaw.addOrReplaceChild("LowerTeeth1_r1", CubeListBuilder.create().texOffs(97, 69).addBox(-3.5F, -1.0F, 0.0F, 7.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3159F, 4.0698F, -3.1485F, 0.9163F, -0.0053F, -0.0069F));

		PartDefinition LowerJaw_r1 = LowerJaw.addOrReplaceChild("LowerJaw_r1", CubeListBuilder.create().texOffs(72, 21).addBox(-4.0F, -0.5F, -3.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3699F, 2.1577F, -0.9297F, 1.209F, -0.0858F, -0.1103F));

		PartDefinition Torso = TorsoPivot.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, -8.1874F, -0.5729F));

		PartDefinition Chest = Torso.addOrReplaceChild("Chest", CubeListBuilder.create(), PartPose.offset(-1.1426F, -3.94F, -0.4924F));

		PartDefinition Vest_r1 = Chest.addOrReplaceChild("Vest_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-5.5F, -4.5F, -3.5F, 11.0F, 9.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.1426F, 0.6997F, 0.21F, 0.0524F, 0.0F, 0.0F));

		PartDefinition LeftShoulder_r1 = Chest.addOrReplaceChild("LeftShoulder_r1", CubeListBuilder.create().texOffs(68, 36).addBox(-2.5F, -4.5F, -3.5F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(6.5426F, 0.5997F, 0.71F, 0.2625F, 0.2446F, 0.0093F));

		PartDefinition RightShoulderPad_r1 = Chest.addOrReplaceChild("RightShoulderPad_r1", CubeListBuilder.create().texOffs(0, 114).addBox(-3.5F, -4.5F, -3.5F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.4F))
				.texOffs(34, 65).addBox(-3.5F, -4.5F, -3.5F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-4.2574F, 0.5997F, 0.71F, 0.2625F, -0.2446F, -0.0093F));

		PartDefinition Chest_r1 = Chest.addOrReplaceChild("Chest_r1", CubeListBuilder.create().texOffs(36, 21).addBox(-5.5F, -4.5F, -3.5F, 11.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1426F, 0.5997F, 0.21F, 0.0524F, 0.0F, 0.0F));

		PartDefinition ChestFoliage = Chest.addOrReplaceChild("ChestFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ChestPetalCrown = ChestFoliage.addOrReplaceChild("ChestPetalCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.7324F, -2.8503F, 4.235F, -2.0226F, 0.2472F, -3.099F));

		PartDefinition ChestCrownPetal4_r1 = ChestPetalCrown.addOrReplaceChild("ChestCrownPetal4_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, -0.55F, 2.475F, 1.5987F, -0.809F, -1.4656F));

		PartDefinition ChestCrownPetal3_r1 = ChestPetalCrown.addOrReplaceChild("ChestCrownPetal3_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.525F, -0.85F, -0.125F, 3.1206F, 0.0406F, -2.4075F));

		PartDefinition ChestCrownPetal2_r1 = ChestPetalCrown.addOrReplaceChild("ChestCrownPetal2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, 0.25F, -3.125F, -1.3678F, 1.0218F, -1.0041F));

		PartDefinition ChestCrownPetal1_r1 = ChestPetalCrown.addOrReplaceChild("ChestCrownPetal1_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, 0.65F, 0.175F, 0.2223F, -0.2149F, -0.4082F));

		PartDefinition ChestSparseFoliage = ChestFoliage.addOrReplaceChild("ChestSparseFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ChestSparseFoliage2_r1 = ChestSparseFoliage.addOrReplaceChild("ChestSparseFoliage2_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2574F, 3.4997F, -2.59F, 0.7018F, 0.2094F, -0.0643F));

		PartDefinition ChestSparseFoliage1_r1 = ChestSparseFoliage.addOrReplaceChild("ChestSparseFoliage1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2426F, 1.7997F, -2.59F, 0.3562F, -0.25F, -0.2325F));

		PartDefinition Stomach = Torso.addOrReplaceChild("Stomach", CubeListBuilder.create(), PartPose.offset(0.0F, 1.8045F, 0.2026F));

		PartDefinition StomachLeftSide_r1 = Stomach.addOrReplaceChild("StomachLeftSide_r1", CubeListBuilder.create().texOffs(58, 70).addBox(-2.5F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.5F, -0.4984F, -0.0495F, 0.1577F, 0.0862F, 0.0137F));

		PartDefinition StomachRightSide_r1 = Stomach.addOrReplaceChild("StomachRightSide_r1", CubeListBuilder.create().texOffs(8, 53).addBox(-3.5F, -2.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-2.5F, -0.4984F, -0.0495F, 0.1577F, -0.0862F, -0.0137F));

		PartDefinition Stomach_r1 = Stomach.addOrReplaceChild("Stomach_r1", CubeListBuilder.create().texOffs(8, 65).addBox(-3.5F, -2.0F, -3.0F, 7.0F, 5.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -0.4984F, -0.0495F, 0.1571F, 0.0F, 0.0F));

		PartDefinition StomachFoliage = Stomach.addOrReplaceChild("StomachFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition StomachFoliage1_r1 = StomachFoliage.addOrReplaceChild("StomachFoliage1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, 1.0553F, -1.785F, 0.3498F, -0.1681F, -0.2016F));

		PartDefinition TorsoBase = Torso.addOrReplaceChild("TorsoBase", CubeListBuilder.create(), PartPose.offset(0.0F, 6.4023F, 0.9281F));

		PartDefinition VestEnd_r1 = TorsoBase.addOrReplaceChild("VestEnd_r1", CubeListBuilder.create().texOffs(32, 52).addBox(-5.5F, -3.0F, -2.5F, 11.0F, 8.0F, 5.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, -0.6426F, -0.2105F, 0.2443F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r1 = TorsoBase.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(64, 52).addBox(-5.5F, -3.0F, -2.5F, 11.0F, 5.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.2574F, 0.0895F, 0.2443F, 0.0F, 0.0F));

		PartDefinition TorsoBaseFoliage = TorsoBase.addOrReplaceChild("TorsoBaseFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TorsoBaseFoliage1_r1 = TorsoBaseFoliage.addOrReplaceChild("TorsoBaseFoliage1_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, -1.1426F, 2.4895F, -0.392F, -0.1681F, -0.2016F));

		PartDefinition TorsoBaseTumor = TorsoBase.addOrReplaceChild("TorsoBaseTumor", CubeListBuilder.create(), PartPose.offset(0.0F, -4.715F, -0.7552F));

		PartDefinition TorsoBaseTumor1_r1 = TorsoBaseTumor.addOrReplaceChild("TorsoBaseTumor1_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.3F, 6.6724F, 2.9447F, -1.2197F, 0.3021F, -0.1387F));

		PartDefinition BackDetails = Torso.addOrReplaceChild("BackDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 1.6874F, 0.1729F));

		PartDefinition BackTendrils = BackDetails.addOrReplaceChild("BackTendrils", CubeListBuilder.create(), PartPose.offset(0.5F, 1.3224F, 4.8447F));

		PartDefinition Tendril1 = BackTendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(99, 117).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4837F, -0.4557F, -2.7108F, -1.0225F, 0.5741F, 0.3272F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(90, 116).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(85, 105).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, -0.1196F, 0.9161F));

		PartDefinition Tendril2 = BackTendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.6837F, -1.7443F, -2.4108F, 1.2613F, 0.8563F, 2.7799F));

		PartDefinition TendrilSegment_r1 = Tendril2.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(99, 120).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 5.9634F, -0.0145F, 0.0F, 0.0F, 0.829F));

		PartDefinition TendrilSegment_r2 = Seg2Tendril2.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(99, 117).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(92, 119).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0816F, 6.3197F, -0.0142F, 0.0F, 0.0F, -0.9163F));

		PartDefinition Tendril3Pouch = BackTendrils.addOrReplaceChild("Tendril3Pouch", CubeListBuilder.create().texOffs(99, 117).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3837F, -4.4557F, -3.1108F, -0.8323F, 0.5328F, -0.2034F));

		PartDefinition Seg2Tendril3 = Tendril3Pouch.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(90, 116).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0137F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(85, 117).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0816F, -8.3197F, -0.0142F, -0.0421F, -0.0113F, -0.7415F));

		PartDefinition FireworkPouch = Seg3Tendril3.addOrReplaceChild("FireworkPouch", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.721F, -7.4613F, 0.3895F, -0.0436F, 0.0F, -0.2618F));

		PartDefinition Pouch = FireworkPouch.addOrReplaceChild("Pouch", CubeListBuilder.create().texOffs(72, 115).addBox(-2.0F, -6.75F, -0.25F, 4.0F, 11.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(63, 123).addBox(-1.5F, -0.75F, -1.25F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 9.25F, 7.0F));

		PartDefinition Strap2_r1 = Pouch.addOrReplaceChild("Strap2_r1", CubeListBuilder.create().texOffs(58, 115).addBox(0.0F, -5.0F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, -6.95F, -4.15F, 0.9223F, -0.4337F, 0.2777F));

		PartDefinition Strap1_r1 = Pouch.addOrReplaceChild("Strap1_r1", CubeListBuilder.create().texOffs(58, 114).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, -5.85F, -3.15F, 0.8041F, -0.2268F, 0.0522F));

		PartDefinition Fireworks = FireworkPouch.addOrReplaceChild("Fireworks", CubeListBuilder.create(), PartPose.offset(-3.0F, 9.25F, 7.0F));

		PartDefinition Tendril4Eye = BackTendrils.addOrReplaceChild("Tendril4Eye", CubeListBuilder.create().texOffs(99, 117).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4163F, -4.5557F, -2.7108F, -1.5302F, 0.89F, -2.0243F));

		PartDefinition Seg2Tendril4 = Tendril4Eye.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(90, 116).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0137F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(85, 105).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, -0.076F, 0.9161F));

		PartDefinition Eye = Seg3Tendril4.addOrReplaceChild("Eye", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition EyeTumor7_r1 = Eye.addOrReplaceChild("EyeTumor7_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.021F, -0.3113F, -0.1605F, 2.5292F, -1.0105F, 1.7016F));

		PartDefinition EyeTumors = Eye.addOrReplaceChild("EyeTumors", CubeListBuilder.create(), PartPose.offset(0.7352F, -5.5113F, -0.5891F));

		PartDefinition EyeTumor6_r1 = EyeTumors.addOrReplaceChild("EyeTumor6_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.8143F, -1.0F, -0.6714F, -2.3544F, -0.9188F, 0.9408F));

		PartDefinition EyeTumor5_r1 = EyeTumors.addOrReplaceChild("EyeTumor5_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.3857F, -1.8F, -1.9714F, 0.5412F, -1.2325F, -3.1249F));

		PartDefinition EyeTumor4_r1 = EyeTumors.addOrReplaceChild("EyeTumor4_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.2143F, -2.9F, 0.5286F, 0.5448F, -0.6242F, 3.0387F));

		PartDefinition EyeTumor3_r1 = EyeTumors.addOrReplaceChild("EyeTumor3_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.3857F, 0.4F, 1.0286F, -2.334F, -0.6115F, 0.9459F));

		PartDefinition EyeTumor2_r1 = EyeTumors.addOrReplaceChild("EyeTumor2_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3857F, 0.6F, -0.6714F, -2.2726F, 0.8455F, -0.2931F));

		PartDefinition EyeTumor1_r1 = EyeTumors.addOrReplaceChild("EyeTumor1_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4143F, -0.5F, 1.3286F, -2.0863F, -0.5335F, 1.9163F));

		PartDefinition VigilEye = Eye.addOrReplaceChild("VigilEye", CubeListBuilder.create().texOffs(0, 37).addBox(-4.0768F, -4.159F, -6.2317F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.657F, -6.2404F, -0.1375F, 1.8112F, -1.4215F, -2.4297F));

		PartDefinition pupil = VigilEye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(98, 83).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)), PartPose.offset(-0.094F, -0.1531F, -5.6037F));

		PartDefinition BackTumors = BackDetails.addOrReplaceChild("BackTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackTumorCluster1 = BackTumors.addOrReplaceChild("BackTumorCluster1", CubeListBuilder.create(), PartPose.offset(-0.4667F, 0.4058F, 3.3114F));

		PartDefinition BackTumor4_r1 = BackTumorCluster1.addOrReplaceChild("BackTumor4_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.0333F, -2.9333F, 1.0333F, -2.2425F, 0.6337F, 0.1043F));

		PartDefinition BackTumor3_r1 = BackTumorCluster1.addOrReplaceChild("BackTumor3_r1", CubeListBuilder.create().texOffs(72, 28).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.3333F, -0.7333F, -0.6667F, 2.1996F, 1.1464F, -3.0495F));

		PartDefinition BackTumor2_r1 = BackTumorCluster1.addOrReplaceChild("BackTumor2_r1", CubeListBuilder.create().texOffs(52, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.5333F, 0.3667F, 0.3333F, -2.0863F, -0.5335F, 1.9163F));

		PartDefinition BackTumor1_r1 = BackTumorCluster1.addOrReplaceChild("BackTumor1_r1", CubeListBuilder.create().texOffs(98, 75).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.8667F, 0.3667F, 0.3333F, -0.1358F, 0.5169F, 0.0791F));

		PartDefinition BackTumorCluster2 = BackTumors.addOrReplaceChild("BackTumorCluster2", CubeListBuilder.create(), PartPose.offset(-0.225F, -3.5276F, 2.7697F));

		PartDefinition BackTumor8_r1 = BackTumorCluster2.addOrReplaceChild("BackTumor8_r1", CubeListBuilder.create().texOffs(96, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-3.275F, 1.0F, -0.425F, -2.4755F, 0.0256F, 1.3491F));

		PartDefinition BackTumor7_r1 = BackTumorCluster2.addOrReplaceChild("BackTumor7_r1", CubeListBuilder.create().texOffs(84, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.175F, -1.6F, 0.175F, -2.6626F, 0.7858F, 0.5402F));

		PartDefinition BackTumor6_r1 = BackTumorCluster2.addOrReplaceChild("BackTumor6_r1", CubeListBuilder.create().texOffs(96, 51).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.225F, -1.1F, -0.125F, -1.8792F, 0.0809F, -0.6048F));

		PartDefinition BackTumor5_r1 = BackTumorCluster2.addOrReplaceChild("BackTumor5_r1", CubeListBuilder.create().texOffs(68, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.225F, 1.7F, 0.375F, 2.6207F, 0.6004F, -1.9086F));

		PartDefinition Arms = TorsoPivot.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-8.0F, -14.4276F, -1.9553F));

		PartDefinition RightArmTop = RightArm.addOrReplaceChild("RightArmTop", CubeListBuilder.create().texOffs(8, 91).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(13, 109).addBox(-3.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArmTopFoliage = RightArmTop.addOrReplaceChild("RightArmTopFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArmTopFoliage2_r1 = RightArmTopFoliage.addOrReplaceChild("RightArmTopFoliage2_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 7.3F, -1.4F, 0.4129F, 0.3201F, -0.1346F));

		PartDefinition RightArmTopFoliage1_r1 = RightArmTopFoliage.addOrReplaceChild("RightArmTopFoliage1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 5.3F, 0.9F, -0.3491F, 0.0F, -0.1571F));

		PartDefinition RightArmBottom = RightArm.addOrReplaceChild("RightArmBottom", CubeListBuilder.create(), PartPose.offset(-1.0326F, 8.9497F, 0.0F));

		PartDefinition RightArmBottom_r1 = RightArmBottom.addOrReplaceChild("RightArmBottom_r1", CubeListBuilder.create().texOffs(92, 28).addBox(-2.0641F, 0.2006F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0675F, -0.1503F, 0.0F, 0.0F, 0.0F, -0.0349F));

		PartDefinition RightArmBottomFoliage = RightArmBottom.addOrReplaceChild("RightArmBottomFoliage", CubeListBuilder.create(), PartPose.offset(1.0326F, -8.9497F, 0.0F));

		PartDefinition RightArmBottomFoliage2_r1 = RightArmBottomFoliage.addOrReplaceChild("RightArmBottomFoliage2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 13.7F, -1.9F, 0.323F, -0.9259F, -0.4185F));

		PartDefinition RightArmBottomFoliage1_r1 = RightArmBottomFoliage.addOrReplaceChild("RightArmBottomFoliage1_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 11.3F, -0.1F, 0.6601F, 1.2544F, 0.4786F));

		PartDefinition LeftBladeArm = Arms.addOrReplaceChild("LeftBladeArm", CubeListBuilder.create(), PartPose.offsetAndRotation(7.094F, -13.6596F, -2.0381F, 0.0F, 0.0F, 0.0524F));

		PartDefinition LeftArmTop = LeftBladeArm.addOrReplaceChild("LeftArmTop", CubeListBuilder.create(), PartPose.offset(-0.0186F, 0.0087F, 0.0666F));

		PartDefinition CalcificationClump_r1 = LeftArmTop.addOrReplaceChild("CalcificationClump_r1", CubeListBuilder.create().texOffs(100, 19).addBox(0.0F, -3.5F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6246F, 9.6234F, -0.0838F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition LeftArmEnd_r1 = LeftArmTop.addOrReplaceChild("LeftArmEnd_r1", CubeListBuilder.create().texOffs(36, 95).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2247F, 8.2234F, 2.0162F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition LeftArmTop_r1 = LeftArmTop.addOrReplaceChild("LeftArmTop_r1", CubeListBuilder.create().texOffs(92, 41).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.9246F, 3.2234F, 2.0162F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition LeftArmTopBloatage = LeftArmTop.addOrReplaceChild("LeftArmTopBloatage", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9045F, 1.1984F, -1.8775F, 0.1647F, 0.3621F, 2.8212F));

		PartDefinition LeftArmTopBottomTumors = LeftArmTopBloatage.addOrReplaceChild("LeftArmTopBottomTumors", CubeListBuilder.create(), PartPose.offset(-0.725F, -0.775F, 1.7F));

		PartDefinition LeftArmTopTumor4_r1 = LeftArmTopBottomTumors.addOrReplaceChild("LeftArmTopTumor4_r1", CubeListBuilder.create().texOffs(90, 107).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-2.35F, 1.7F, 0.25F, -1.8263F, 1.2313F, -2.1396F));

		PartDefinition LeftArmTopTumor3_r1 = LeftArmTopBottomTumors.addOrReplaceChild("LeftArmTopTumor3_r1", CubeListBuilder.create().texOffs(90, 107).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.05F, 1.0F, 2.45F, -2.9491F, 1.0782F, -2.5657F));

		PartDefinition LeftArmTopTumor2_r1 = LeftArmTopBottomTumors.addOrReplaceChild("LeftArmTopTumor2_r1", CubeListBuilder.create().texOffs(90, 107).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.25F, -2.9F, -1.35F, 1.2442F, 1.1786F, 0.4503F));

		PartDefinition LeftArmTopTumor1_r1 = LeftArmTopBottomTumors.addOrReplaceChild("LeftArmTopTumor1_r1", CubeListBuilder.create().texOffs(90, 107).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.05F, 0.2F, -1.35F, 0.2918F, 0.1426F, 0.5729F));

		PartDefinition LeftArmTopBottomOvergrownTumors = LeftArmTopBloatage.addOrReplaceChild("LeftArmTopBottomOvergrownTumors", CubeListBuilder.create(), PartPose.offset(-1.5063F, -0.1613F, 1.169F));

		PartDefinition LeftArmTopOvergrownTumor2_r1 = LeftArmTopBottomOvergrownTumors.addOrReplaceChild("LeftArmTopOvergrownTumor2_r1", CubeListBuilder.create().texOffs(108, 107).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1687F, -3.1137F, 1.681F, -0.1718F, -0.282F, -0.2607F));

		PartDefinition LeftArmTopOvergrownTumor2Calcification_r1 = LeftArmTopBottomOvergrownTumors.addOrReplaceChild("LeftArmTopOvergrownTumor2Calcification_r1", CubeListBuilder.create().texOffs(100, 22).addBox(-2.5F, -0.5F, -2.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
				.texOffs(108, 107).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9313F, 1.1863F, -0.119F, 0.0523F, 0.0018F, 0.2095F));

		PartDefinition LeftArmTopFoliage = LeftArmTop.addOrReplaceChild("LeftArmTopFoliage", CubeListBuilder.create(), PartPose.offset(-7.0754F, 31.7234F, 2.9162F));

		PartDefinition LeftArmTopFoliage2_r1 = LeftArmTopFoliage.addOrReplaceChild("LeftArmTopFoliage2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3F, -25.5F, -0.9F, -2.1613F, 1.2072F, -2.4119F));

		PartDefinition LeftArmTopFoliage1_r1 = LeftArmTopFoliage.addOrReplaceChild("LeftArmTopFoliage1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.2F, -29.8F, -2.1F, 0.6601F, 1.2544F, 0.4786F));

		PartDefinition Blade = LeftBladeArm.addOrReplaceChild("Blade", CubeListBuilder.create(), PartPose.offsetAndRotation(3.594F, 9.2404F, -0.9381F, 1.6314F, 1.5559F, 1.5102F));

		PartDefinition Blade_r1 = Blade.addOrReplaceChild("Blade_r1", CubeListBuilder.create().texOffs(110, 24).addBox(-7.0F, -8.5F, -1.0F, 9.0F, 15.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.288F, 8.8917F, 1.3209F, 0.0345F, -0.0055F, -0.0175F));

		PartDefinition BladeInnerRide_r1 = Blade.addOrReplaceChild("BladeInnerRide_r1", CubeListBuilder.create().texOffs(68, 103).addBox(1.0F, -3.5F, -2.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.288F, 4.6917F, 1.3209F, 0.0348F, -0.0024F, -0.1048F));

		PartDefinition BladeOuterRidge_r1 = Blade.addOrReplaceChild("BladeOuterRidge_r1", CubeListBuilder.create().texOffs(100, 0).addBox(1.0F, -3.5F, -2.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.488F, 8.8917F, 1.3209F, 0.0345F, -0.0055F, -0.0175F));

		PartDefinition BladePlateLeft_r1 = Blade.addOrReplaceChild("BladePlateLeft_r1", CubeListBuilder.create().texOffs(100, 19).addBox(0.0F, -2.5F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.888F, 2.8917F, 1.9209F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition BladePlateRight_r1 = Blade.addOrReplaceChild("BladePlateRight_r1", CubeListBuilder.create().texOffs(100, 19).addBox(0.0F, -2.5F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.588F, 3.8917F, 0.4209F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition BladePlateBack_r1 = Blade.addOrReplaceChild("BladePlateBack_r1", CubeListBuilder.create().texOffs(100, 19).addBox(0.0F, -2.5F, -2.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.788F, 1.3917F, 1.0209F, 0.0337F, -0.009F, 0.0871F));

		PartDefinition BladePlateFront_r1 = Blade.addOrReplaceChild("BladePlateFront_r1", CubeListBuilder.create().texOffs(100, 19).addBox(0.0F, -3.5F, -2.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.488F, 3.5917F, 1.1209F, 0.0349F, 0.0F, -0.1745F));

		PartDefinition BladeSpikes = Blade.addOrReplaceChild("BladeSpikes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Spike7_r1 = BladeSpikes.addOrReplaceChild("Spike7_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4363F, 2.062F, -2.2188F, 1.2015F, -1.5034F, -1.2262F));

		PartDefinition Spike6_r1 = BladeSpikes.addOrReplaceChild("Spike6_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4363F, 6.662F, -1.9188F, 1.4678F, -1.3322F, -1.4946F));

		PartDefinition Spike5_r1 = BladeSpikes.addOrReplaceChild("Spike5_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0363F, 4.862F, 2.0812F, -1.3015F, 1.3099F, -1.3102F));

		PartDefinition Spike4_r1 = BladeSpikes.addOrReplaceChild("Spike4_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1637F, 13.962F, 0.4812F, 3.0882F, 0.0064F, -2.9051F));

		PartDefinition Spike3_r1 = BladeSpikes.addOrReplaceChild("Spike3_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2637F, 9.562F, 0.4812F, 3.089F, -0.0113F, 3.0469F));

		PartDefinition Spike2_r1 = BladeSpikes.addOrReplaceChild("Spike2_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5637F, 5.662F, 0.2812F, 3.0918F, -0.0202F, 2.8726F));

		PartDefinition Spike1_r1 = BladeSpikes.addOrReplaceChild("Spike1_r1", CubeListBuilder.create().texOffs(26, 94).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6189F, 1.9198F, -0.0094F, 3.0966F, -0.0294F, 2.6808F));

		PartDefinition BladeRibs = Blade.addOrReplaceChild("BladeRibs", CubeListBuilder.create(), PartPose.offset(-0.362F, 11.6271F, 0.4251F));

		PartDefinition BladeRib3_r1 = BladeRibs.addOrReplaceChild("BladeRib3_r1", CubeListBuilder.create().texOffs(26, 76).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.3291F, 1.5708F, 0.0023F, 0.0321F, -0.0136F, 0.2267F));

		PartDefinition BladeRib2_r1 = BladeRibs.addOrReplaceChild("BladeRib2_r1", CubeListBuilder.create().texOffs(44, 78).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0709F, -0.0292F, 0.0023F, 0.0321F, -0.0136F, 0.2267F));

		PartDefinition BladeRib1_r1 = BladeRibs.addOrReplaceChild("BladeRib1_r1", CubeListBuilder.create().texOffs(68, 49).addBox(-2.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2291F, -1.6292F, 0.0023F, 0.0321F, -0.0136F, 0.2267F));

		PartDefinition Legs = Vanguard.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -8.65F, 0.5F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1F, -8.0F, -0.1F, 0.0349F, -0.0012F, 0.0349F));

		PartDefinition RightLegTop = RightLeg.addOrReplaceChild("RightLegTop", CubeListBuilder.create().texOffs(62, 81).addBox(-2.0F, -1.15F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(82, 0).addBox(-2.0F, -1.15F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition RightLegBottom = RightLeg.addOrReplaceChild("RightLegBottom", CubeListBuilder.create().texOffs(8, 76).addBox(-2.0125F, 0.475F, -2.5125F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.2F))
				.texOffs(40, 115).addBox(-2.0125F, 4.475F, -2.5125F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0125F, 6.175F, 0.0125F, 0.0349F, -0.0012F, 0.0349F));

		PartDefinition RightLegPetalCrown = RightLegBottom.addOrReplaceChild("RightLegPetalCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2125F, 3.125F, 0.0125F, 2.9271F, 0.2305F, -3.0291F));

		PartDefinition RightLegCrownPetal4_r1 = RightLegPetalCrown.addOrReplaceChild("RightLegCrownPetal4_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, -0.55F, 2.475F, 1.5987F, -0.809F, -1.4656F));

		PartDefinition RightLegCrownPetal3_r1 = RightLegPetalCrown.addOrReplaceChild("RightLegCrownPetal3_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.525F, -0.85F, -0.125F, 3.1206F, 0.0406F, -2.4075F));

		PartDefinition RightLegCrownPetal2_r1 = RightLegPetalCrown.addOrReplaceChild("RightLegCrownPetal2_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.675F, 0.25F, -3.125F, -1.3678F, 1.0218F, -1.0041F));

		PartDefinition RightLegCrownPetal1_r1 = RightLegPetalCrown.addOrReplaceChild("RightLegCrownPetal1_r1", CubeListBuilder.create().texOffs(107, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.375F, 0.65F, 0.175F, 0.2223F, -0.2149F, -0.4082F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1F, -8.0F, -0.1F, 0.0349F, 0.0F, -0.0349F));

		PartDefinition LeftLegTop = LeftLeg.addOrReplaceChild("LeftLegTop", CubeListBuilder.create().texOffs(80, 81).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(44, 81).addBox(-2.0F, -1.0F, -2.5F, 4.0F, 9.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, -1.15F, 0.0F));

		PartDefinition LeftLegTopFoliage = LeftLegTop.addOrReplaceChild("LeftLegTopFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLegTopPetal1_r1 = LeftLegTopFoliage.addOrReplaceChild("LeftLegTopPetal1_r1", CubeListBuilder.create().texOffs(107, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.65F, 6.65F, -1.6F, 0.4822F, 1.2487F, 0.4708F));

		PartDefinition LeftLegBottom = LeftLeg.addOrReplaceChild("LeftLegBottom", CubeListBuilder.create().texOffs(26, 78).addBox(-2.0F, 0.5F, -2.5F, 4.0F, 10.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 6.15F, 0.0F, 0.0349F, 0.0012F, -0.0349F));

		PartDefinition LeftLegBloatage = LeftLegBottom.addOrReplaceChild("LeftLegBloatage", CubeListBuilder.create(), PartPose.offset(1.775F, 7.475F, -1.95F));

		PartDefinition LeftLegBottomTumors = LeftLegBloatage.addOrReplaceChild("LeftLegBottomTumors", CubeListBuilder.create(), PartPose.offset(1.125F, 1.125F, -1.95F));

		PartDefinition LeftLegTumor4_r1 = LeftLegBottomTumors.addOrReplaceChild("LeftLegTumor4_r1", CubeListBuilder.create().texOffs(100, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.2F, 0.9F, 2.7F, -1.8263F, 1.2313F, -2.1396F));

		PartDefinition LeftLegTumor3_r1 = LeftLegBottomTumors.addOrReplaceChild("LeftLegTumor3_r1", CubeListBuilder.create().texOffs(100, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.2F, -1.2F, 5.7F, -2.9491F, 1.0782F, -2.5657F));

		PartDefinition LeftLegTumor2_r1 = LeftLegBottomTumors.addOrReplaceChild("LeftLegTumor2_r1", CubeListBuilder.create().texOffs(100, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-1.0F, -5.4F, 2.0F, 1.2442F, 1.1786F, 0.4503F));

		PartDefinition LeftLegTumor1_r1 = LeftLegBottomTumors.addOrReplaceChild("LeftLegTumor1_r1", CubeListBuilder.create().texOffs(100, 95).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-1.2F, -3.6F, 2.0F, 0.2918F, 0.1426F, 0.5729F));

		PartDefinition LeftLegBottomOvergrownTumors = LeftLegBloatage.addOrReplaceChild("LeftLegBottomOvergrownTumors", CubeListBuilder.create(), PartPose.offset(-1.125F, -1.125F, 1.95F));

		PartDefinition LeftLegOvergrownTumor2_r1 = LeftLegBottomOvergrownTumors.addOrReplaceChild("LeftLegOvergrownTumor2_r1", CubeListBuilder.create().texOffs(108, 118).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.55F, -2.15F, 0.9F, -0.165F, 0.0277F, -0.3135F));

		PartDefinition LeftLegOvergrownTumor1_r1 = LeftLegBottomOvergrownTumors.addOrReplaceChild("LeftLegOvergrownTumor1_r1", CubeListBuilder.create().texOffs(108, 118).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.55F, 2.15F, -0.9F, 0.0523F, 0.0018F, 0.2095F));

		PartDefinition LeftLegBottomFoliage = LeftLegBottom.addOrReplaceChild("LeftLegBottomFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLegBottomPetal1_r1 = LeftLegBottomFoliage.addOrReplaceChild("LeftLegBottomPetal1_r1", CubeListBuilder.create().texOffs(107, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.35F, 4.25F, 2.7F, -1.4149F, 1.1082F, -0.9782F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Vanguard.getAllParts().forEach(ModelPart::resetPose);
		float val1 = Mth.cos(ageInTicks/7)/8;
		float val2 = Mth.sin(ageInTicks/6)/6;
		float val3 = -Mth.cos(ageInTicks/6)/7;
		float val4 = -Mth.sin(ageInTicks/6)/7;
		float val5 = Mth.sin(ageInTicks/5)/8;
		float val6 = Mth.cos(ageInTicks/5)/5;
		float val7 = -Mth.sin(ageInTicks/6)/5;
		Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.animateTentacleZ(Banner,Mth.sin(ageInTicks/10)/10);
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.LeftLegBottom.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightLegBottom.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		this.LowerJaw.xRot = Mth.sin(ageInTicks/6)/10;
		this.LowerJaw.yRot = Mth.cos(ageInTicks/7)/7;
		this.RightArm.xRot =entity.isChargingCrossbow() ?  -0.75f + (headPitch /  ( 90F / (float) Math.PI)) : val1;
		this.RightArmBottom.xRot = this.RightArm.xRot < 0 ? this.RightArm.xRot : 0;
		this.RightArmBottom.yRot = entity.isChargingCrossbow() ? -0.5f : 0;
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			float swing = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick, 20.0F);
			this.animateTentacleX(LeftBladeArm,swing);
		}else {
			this.LeftBladeArm.xRot = val3;
		}
		animateTentacleX(LT1,val2);
		animateTentacleZ(LT1Seg2,val5);
		animateTentacleZ(LT2,val3);
		animateTentacleX(LT2Seg2,val5);
		animateTentacleY(LT3,val4);
		animateTentacleX(LT3Seg2,val5);
		this.animateTumor(BackTumorCluster1,val3);
		this.animateTumor(BackTumorCluster2,val1);
		animateTentacleY(Tendril1,val4);
		animateTentacleZ(Seg2Tendril1,val3);
		animateTentacleX(Seg2Tendril1,val1);
		animateTentacleZ(Seg3Tendril1,val6);
		animateTentacleY(Tendril2,val3);
		animateTentacleZ(Seg2Tendril2,val4);
		animateTentacleZ(Seg3Tendril2,val6);
		animateTentacleZ(Tendril4Eye,val3);
		animateTentacleY(Seg2Tendril4,val4);
		animateTentacleX(Seg2Tendril4,-val4);
		animateTentacleY(Seg3Tendril4,val6);
		this.animateTumor(EyeTumors,val6);
		animateTentacleY(VigilEye,val3);
		animateTentacleZ(Tendril3Pouch,val3);
		animateTentacleZ(Seg2Tendril3,val2);
		animateTentacleZ(Seg3Tendril3,val7);
		float pounch = Tendril3Pouch.zRot + Seg2Tendril3.zRot + Seg3Tendril3.zRot;
		animateTentacleZ(FireworkPouch,-pounch * 1.5f);
		this.animateTumor(HeadTumorCluster1,val4);
		this.animateTumor(HeadTumorCluster2,-val7);
		this.animateTumor(LeftLegBloatage,val7);
		animatePupil(entity,Minecraft.getInstance().cameraEntity,pupil);
	}
	private void animatePupil(T block, Entity entity, ModelPart part){
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = new Vec3(block.getX(),block.getY()+1.75,block.getZ());
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				part.y = part.getInitialPose().y -0.5F;
			} else {
				part.y =part.getInitialPose().y + 0.5F;
			}
			Vec3 vec32 = vec31;
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			part.x =part.getInitialPose().x + Mth.sqrt((float)Math.abs(d1)) * 0.01F * (float)Math.signum(d1);
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r,float g,float b,float alpha) {
		Vanguard.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}