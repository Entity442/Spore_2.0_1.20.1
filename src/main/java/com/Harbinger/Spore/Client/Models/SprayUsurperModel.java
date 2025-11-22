package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Usurper;
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

public class SprayUsurperModel<T extends Usurper> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "sprayusurper"), "main");
	private final ModelPart spitterorganoid;
	private final ModelPart base;
	private final ModelPart FungusCrown4;
	private final ModelPart VillagerHead;
	private final ModelPart Ribs;
	private final ModelPart FrontRibs;
	private final ModelPart ribJoint;
	private final ModelPart Rib1;
	private final ModelPart Rib1Seg2;
	private final ModelPart ribJoint2;
	private final ModelPart Rib2;
	private final ModelPart Rib2Seg2;
	private final ModelPart ribJoint3;
	private final ModelPart Rib3;
	private final ModelPart Rib3Seg2;
	private final ModelPart BackRibs;
	private final ModelPart ribJoint4;
	private final ModelPart Rib4;
	private final ModelPart Rib4Seg2;
	private final ModelPart ribJoint5;
	private final ModelPart Rib5;
	private final ModelPart Rib5Seg2;
	private final ModelPart ribJoint6;
	private final ModelPart Rib6;
	private final ModelPart Rib6Seg2;
	private final ModelPart ribJoint7;
	private final ModelPart Rib7;
	private final ModelPart Rib6Seg3;
	private final ModelPart BaseTumor;
	private final ModelPart OrganoidSeg1;
	private final ModelPart Infected1;
	private final ModelPart FungusCrown3;
	private final ModelPart Infected2;
	private final ModelPart Infected3;
	private final ModelPart OrganoidSeg2;
	private final ModelPart Seg2Head;
	private final ModelPart SEg2HeadTubeTongue;
	private final ModelPart S2HTTJoint2;
	private final ModelPart TipOfTube1;
	private final ModelPart FungusCrown2;
	private final ModelPart OrganoidSeg3;
	private final ModelPart Neck;
	private final ModelPart NeckTumors;
	private final ModelPart HeadJoint;
	private final ModelPart Head;
	private final ModelPart Center;
	private final ModelPart FungusCrown1;
	private final ModelPart CenterJaw;
	private final ModelPart SaggingFlesh;
	private final ModelPart Left;
	private final ModelPart LeftJaw;
	private final ModelPart LeftMandable;
	private final ModelPart LMandSeg2;
	private final ModelPart LMandSplit1;
	private final ModelPart LMandSplit2;
	private final ModelPart Sniffer;
	private final ModelPart Sniffer1;
	private final ModelPart Sniffer2;
	private final ModelPart Sniffer3;
	private final ModelPart Right;
	private final ModelPart RightJaw;
	private final ModelPart RightMandable;
	private final ModelPart RMandSplit1;
	private final ModelPart RMandSplit2;
	private final ModelPart RightHeadTumors;
	private final ModelPart LeTubes;
	private final ModelPart Tube;
	private final ModelPart T1S2;
	private final ModelPart T1S3;
	private final ModelPart T1S4;
	private final ModelPart T1S5;
	private final ModelPart T1Tip;

	public SprayUsurperModel(ModelPart root) {
		this.spitterorganoid = root.getChild("spitterorganoid");
		this.base = this.spitterorganoid.getChild("base");
		this.FungusCrown4 = this.base.getChild("FungusCrown4");
		this.VillagerHead = this.base.getChild("VillagerHead");
		this.Ribs = this.base.getChild("Ribs");
		this.FrontRibs = this.Ribs.getChild("FrontRibs");
		this.ribJoint = this.FrontRibs.getChild("ribJoint");
		this.Rib1 = this.ribJoint.getChild("Rib1");
		this.Rib1Seg2 = this.Rib1.getChild("Rib1Seg2");
		this.ribJoint2 = this.FrontRibs.getChild("ribJoint2");
		this.Rib2 = this.ribJoint2.getChild("Rib2");
		this.Rib2Seg2 = this.Rib2.getChild("Rib2Seg2");
		this.ribJoint3 = this.FrontRibs.getChild("ribJoint3");
		this.Rib3 = this.ribJoint3.getChild("Rib3");
		this.Rib3Seg2 = this.Rib3.getChild("Rib3Seg2");
		this.BackRibs = this.Ribs.getChild("BackRibs");
		this.ribJoint4 = this.BackRibs.getChild("ribJoint4");
		this.Rib4 = this.ribJoint4.getChild("Rib4");
		this.Rib4Seg2 = this.Rib4.getChild("Rib4Seg2");
		this.ribJoint5 = this.BackRibs.getChild("ribJoint5");
		this.Rib5 = this.ribJoint5.getChild("Rib5");
		this.Rib5Seg2 = this.Rib5.getChild("Rib5Seg2");
		this.ribJoint6 = this.BackRibs.getChild("ribJoint6");
		this.Rib6 = this.ribJoint6.getChild("Rib6");
		this.Rib6Seg2 = this.Rib6.getChild("Rib6Seg2");
		this.ribJoint7 = this.BackRibs.getChild("ribJoint7");
		this.Rib7 = this.ribJoint7.getChild("Rib7");
		this.Rib6Seg3 = this.Rib7.getChild("Rib6Seg3");
		this.BaseTumor = this.base.getChild("BaseTumor");
		this.OrganoidSeg1 = this.spitterorganoid.getChild("OrganoidSeg1");
		this.Infected1 = this.OrganoidSeg1.getChild("Infected1");
		this.FungusCrown3 = this.Infected1.getChild("FungusCrown3");
		this.Infected2 = this.OrganoidSeg1.getChild("Infected2");
		this.Infected3 = this.OrganoidSeg1.getChild("Infected3");
		this.OrganoidSeg2 = this.OrganoidSeg1.getChild("OrganoidSeg2");
		this.Seg2Head = this.OrganoidSeg2.getChild("Seg2Head");
		this.SEg2HeadTubeTongue = this.Seg2Head.getChild("SEg2HeadTubeTongue");
		this.S2HTTJoint2 = this.SEg2HeadTubeTongue.getChild("S2HTTJoint2");
		this.TipOfTube1 = this.S2HTTJoint2.getChild("TipOfTube1");
		this.FungusCrown2 = this.Seg2Head.getChild("FungusCrown2");
		this.OrganoidSeg3 = this.OrganoidSeg2.getChild("OrganoidSeg3");
		this.Neck = this.OrganoidSeg3.getChild("Neck");
		this.NeckTumors = this.Neck.getChild("NeckTumors");
		this.HeadJoint = this.Neck.getChild("HeadJoint");
		this.Head = this.HeadJoint.getChild("Head");
		this.Center = this.Head.getChild("Center");
		this.FungusCrown1 = this.Center.getChild("FungusCrown1");
		this.CenterJaw = this.Center.getChild("CenterJaw");
		this.SaggingFlesh = this.CenterJaw.getChild("SaggingFlesh");
		this.Left = this.Head.getChild("Left");
		this.LeftJaw = this.Left.getChild("LeftJaw");
		this.LeftMandable = this.LeftJaw.getChild("LeftMandable");
		this.LMandSeg2 = this.LeftMandable.getChild("LMandSeg2");
		this.LMandSplit1 = this.LMandSeg2.getChild("LMandSplit1");
		this.LMandSplit2 = this.LMandSeg2.getChild("LMandSplit2");
		this.Sniffer = this.Left.getChild("Sniffer");
		this.Sniffer1 = this.Sniffer.getChild("Sniffer1");
		this.Sniffer2 = this.Sniffer.getChild("Sniffer2");
		this.Sniffer3 = this.Sniffer.getChild("Sniffer3");
		this.Right = this.Head.getChild("Right");
		this.RightJaw = this.Right.getChild("RightJaw");
		this.RightMandable = this.RightJaw.getChild("RightMandable");
		this.RMandSplit1 = this.RightMandable.getChild("RMandSplit1");
		this.RMandSplit2 = this.RightMandable.getChild("RMandSplit2");
		this.RightHeadTumors = this.Right.getChild("RightHeadTumors");
		this.LeTubes = this.Head.getChild("LeTubes");
		this.Tube = this.LeTubes.getChild("Tube");
		this.T1S2 = this.Tube.getChild("T1S2");
		this.T1S3 = this.T1S2.getChild("T1S3");
		this.T1S4 = this.T1S3.getChild("T1S4");
		this.T1S5 = this.T1S4.getChild("T1S5");
		this.T1Tip = this.T1S5.getChild("T1Tip");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition spitterorganoid = partdefinition.addOrReplaceChild("spitterorganoid", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition base = spitterorganoid.addOrReplaceChild("base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FungusCrown4 = base.addOrReplaceChild("FungusCrown4", CubeListBuilder.create(), PartPose.offsetAndRotation(3.726F, -1.6158F, -10.5005F, 1.5044F, -0.544F, -0.5323F));

		PartDefinition Crown_r1 = FungusCrown4.addOrReplaceChild("Crown_r1", CubeListBuilder.create().texOffs(41, 72).addBox(-2.25F, 1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.274F, -1.333F, 4.3531F, 0.6759F, 0.5646F, 0.1608F));

		PartDefinition Crown_r2 = FungusCrown4.addOrReplaceChild("Crown_r2", CubeListBuilder.create().texOffs(41, 56).addBox(-1.5F, 0.0F, -2.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5845F, 0.2203F, -3.5994F, -0.4358F, -0.8253F, 0.1114F));

		PartDefinition Crown_r3 = FungusCrown4.addOrReplaceChild("Crown_r3", CubeListBuilder.create().texOffs(29, 0).addBox(-0.75F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.226F, -0.3388F, -2.0472F, -1.8405F, 1.2535F, -1.8539F));

		PartDefinition Crown_r4 = FungusCrown4.addOrReplaceChild("Crown_r4", CubeListBuilder.create().texOffs(41, 56).addBox(-3.5F, 1.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.226F, -0.3388F, 1.9528F, 0.4461F, -0.4802F, -0.2174F));

		PartDefinition VillagerHead = base.addOrReplaceChild("VillagerHead", CubeListBuilder.create().texOffs(34, 40).addBox(-7.408F, -6.3033F, -3.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-9.592F, -8.1967F, 0.75F, 0.0F, -0.2182F, -1.5708F));

		PartDefinition Nose_r1 = VillagerHead.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.6569F, 0.5054F, 0.25F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Jaw_r1 = VillagerHead.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(24, 72).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-3.408F, 3.1967F, 0.25F, 0.2618F, 0.0F, 0.2182F));

		PartDefinition Ribs = base.addOrReplaceChild("Ribs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FrontRibs = Ribs.addOrReplaceChild("FrontRibs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ribJoint = FrontRibs.addOrReplaceChild("ribJoint", CubeListBuilder.create(), PartPose.offset(-0.2113F, -5.2914F, -6.2422F));

		PartDefinition Rib1 = ribJoint.addOrReplaceChild("Rib1", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.2618F, 0.0F));

		PartDefinition Rib1Seg2 = Rib1.addOrReplaceChild("Rib1Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition ribJoint2 = FrontRibs.addOrReplaceChild("ribJoint2", CubeListBuilder.create(), PartPose.offset(-6.0F, -7.0F, -4.0F));

		PartDefinition Rib2 = ribJoint2.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7887F, 1.7086F, -0.2422F, 0.8737F, 0.721F, 0.024F));

		PartDefinition Rib2Seg2 = Rib2.addOrReplaceChild("Rib2Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition ribJoint3 = FrontRibs.addOrReplaceChild("ribJoint3", CubeListBuilder.create(), PartPose.offset(-11.2113F, -5.2914F, -3.2422F));

		PartDefinition Rib3 = ribJoint3.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 1.6382F, 0.7753F, 0.3129F));

		PartDefinition Rib3Seg2 = Rib3.addOrReplaceChild("Rib3Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition BackRibs = Ribs.addOrReplaceChild("BackRibs", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, 2.0F));

		PartDefinition ribJoint4 = BackRibs.addOrReplaceChild("ribJoint4", CubeListBuilder.create(), PartPose.offset(-0.2113F, -5.2914F, 5.7578F));

		PartDefinition Rib4 = ribJoint4.addOrReplaceChild("Rib4", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -1.2796F, 0.5138F, 0.077F));

		PartDefinition Rib4Seg2 = Rib4.addOrReplaceChild("Rib4Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition ribJoint5 = BackRibs.addOrReplaceChild("ribJoint5", CubeListBuilder.create(), PartPose.offset(4.7887F, -5.2914F, 3.7578F));

		PartDefinition Rib5 = ribJoint5.addOrReplaceChild("Rib5", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -0.8737F, 0.721F, -0.024F));

		PartDefinition Rib5Seg2 = Rib5.addOrReplaceChild("Rib5Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition ribJoint6 = BackRibs.addOrReplaceChild("ribJoint6", CubeListBuilder.create(), PartPose.offset(10.7887F, -5.2914F, 2.7578F));

		PartDefinition Rib6 = ribJoint6.addOrReplaceChild("Rib6", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5775F, 0.0F, -0.5157F, -1.6382F, 0.7753F, -0.3129F));

		PartDefinition Rib6Seg2 = Rib6.addOrReplaceChild("Rib6Seg2", CubeListBuilder.create().texOffs(0, 121).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition ribJoint7 = BackRibs.addOrReplaceChild("ribJoint7", CubeListBuilder.create(), PartPose.offset(12.7887F, -5.2914F, -0.2422F));

		PartDefinition Rib7 = ribJoint7.addOrReplaceChild("Rib7", CubeListBuilder.create().texOffs(48, 118).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -1.3531F, 1.0133F, 0.3947F));

		PartDefinition Rib6Seg3 = Rib7.addOrReplaceChild("Rib6Seg3", CubeListBuilder.create().texOffs(0, 121).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0873F, 0.116F, -0.0607F));

		PartDefinition BaseTumor = base.addOrReplaceChild("BaseTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = BaseTumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(1, 2).addBox(-9.5F, -4.5F, -6.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8149F, -2.5F, -6.9441F, 0.3491F, 0.3054F, 0.0F));

		PartDefinition Tumor_r2 = BaseTumor.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(5, 5).addBox(-5.0F, -6.0F, -5.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3149F, -1.0F, 0.5558F, -0.2998F, 0.9269F, -0.3688F));

		PartDefinition Tumor_r3 = BaseTumor.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(4, 4).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 4.0F, 0.2618F, 0.3927F, 0.0F));

		PartDefinition Tumor_r4 = BaseTumor.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -6.0F, 0.0F, -0.3578F, 0.538F, -0.1893F));

		PartDefinition OrganoidSeg1 = spitterorganoid.addOrReplaceChild("OrganoidSeg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Infected1 = OrganoidSeg1.addOrReplaceChild("Infected1", CubeListBuilder.create().texOffs(0, 94).addBox(2.0F, -12.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Nose_r2 = Infected1.addOrReplaceChild("Nose_r2", CubeListBuilder.create().texOffs(49, 93).addBox(-1.9351F, -0.6913F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(8.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition HeadTop_r1 = Infected1.addOrReplaceChild("HeadTop_r1", CubeListBuilder.create().texOffs(0, 38).addBox(-2.5F, -9.5F, -3.75F, 6.0F, 2.0F, 6.0F, new CubeDeformation(-0.25F))
		.texOffs(0, 64).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition Arm_r1 = Infected1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0176F, -1.0681F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4177F, -16.1733F, -5.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition TorsoTop_r1 = Infected1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(0, 80).addBox(-2.5F, -5.25F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, -0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition FungusCrown3 = Infected1.addOrReplaceChild("FungusCrown3", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3773F, -21.3882F, 1.4995F, -0.3927F, 0.0F, 0.48F));

		PartDefinition Crown_r5 = FungusCrown3.addOrReplaceChild("Crown_r5", CubeListBuilder.create().texOffs(41, 56).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8946F, 0.6139F, 2.5846F, 0.5853F, 0.2841F, 0.5853F));

		PartDefinition Crown_r6 = FungusCrown3.addOrReplaceChild("Crown_r6", CubeListBuilder.create().texOffs(29, 0).addBox(-3.0F, 3.0F, -2.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5845F, 0.2203F, -3.5994F, -0.1396F, -0.9008F, -0.2761F));

		PartDefinition Crown_r7 = FungusCrown3.addOrReplaceChild("Crown_r7", CubeListBuilder.create().texOffs(41, 56).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.452F, 4.1521F, -4.4314F, 0.1821F, 0.456F, -0.1553F));

		PartDefinition Crown_r8 = FungusCrown3.addOrReplaceChild("Crown_r8", CubeListBuilder.create().texOffs(41, 72).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.226F, -0.3388F, 1.9529F, 0.6306F, -0.7467F, 0.1385F));

		PartDefinition Infected2 = OrganoidSeg1.addOrReplaceChild("Infected2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.2912F, -11.5867F, 1.5F, 0.0F, -2.3126F, 0.0F));

		PartDefinition TorsoTop_r2 = Infected2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(0, 80).addBox(-2.5F, -5.25F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2912F, -0.4133F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Torso_r1 = Infected2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 94).addBox(-2.0F, -3.0F, -3.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2912F, 2.5867F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Infected3 = OrganoidSeg1.addOrReplaceChild("Infected3", CubeListBuilder.create().texOffs(0, 94).addBox(2.0F, -12.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 2.1817F, 0.0F));

		PartDefinition Arm_r2 = Infected3.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(102, 64).addBox(-1.0176F, -1.0681F, -2.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4177F, -16.1733F, -5.0F, 0.1745F, 0.0F, 0.829F));

		PartDefinition TorsoTop_r3 = Infected3.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(0, 80).addBox(-2.5F, -5.25F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -12.0F, -0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition OrganoidSeg2 = OrganoidSeg1.addOrReplaceChild("OrganoidSeg2", CubeListBuilder.create().texOffs(57, 86).addBox(-2.0F, -5.0F, -3.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, -0.5F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Seg2TorsoTop_r1 = OrganoidSeg2.addOrReplaceChild("Seg2TorsoTop_r1", CubeListBuilder.create().texOffs(56, 72).addBox(-2.5F, -5.5F, -3.75F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -5.0F, -0.25F, 0.0F, -0.1309F, 0.1745F));

		PartDefinition Seg2Head = OrganoidSeg2.addOrReplaceChild("Seg2Head", CubeListBuilder.create().texOffs(24, 56).addBox(-4.0F, -20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 2.0F, 0.0F));

		PartDefinition Nose_r3 = Seg2Head.addOrReplaceChild("Nose_r3", CubeListBuilder.create().texOffs(0, 46).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -13.0F, 0.0F, -0.3442F, -0.0594F, 0.5339F));

		PartDefinition Jaw_r2 = Seg2Head.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(64, 33).addBox(-8.0F, -1.5F, -4.5F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.0F, -11.0F, 0.0F, -0.2956F, -0.0779F, -0.5556F));

		PartDefinition SEg2HeadTubeTongue = Seg2Head.addOrReplaceChild("SEg2HeadTubeTongue", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -11.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition S2TTS2_r1 = SEg2HeadTubeTongue.addOrReplaceChild("S2TTS2_r1", CubeListBuilder.create().texOffs(0, 24).addBox(-2.0F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.6109F));

		PartDefinition S2HTTJoint2 = SEg2HeadTubeTongue.addOrReplaceChild("S2HTTJoint2", CubeListBuilder.create(), PartPose.offset(-4.6411F, 5.2303F, 1.078F));

		PartDefinition S5TTS5_r1 = S2HTTJoint2.addOrReplaceChild("S5TTS5_r1", CubeListBuilder.create().texOffs(18, 29).addBox(-3.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0262F, 0.1047F, -1.0472F));

		PartDefinition S4TTS4_r1 = S2HTTJoint2.addOrReplaceChild("S4TTS4_r1", CubeListBuilder.create().texOffs(36, 116).addBox(-2.5F, -1.5F, -1.4F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9283F, -1.9825F, -0.5293F, 0.0349F, 0.1929F, -1.1345F));

		PartDefinition S3TTS3_r1 = S2HTTJoint2.addOrReplaceChild("S3TTS3_r1", CubeListBuilder.create().texOffs(36, 116).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1789F, -4.1468F, -0.5754F, 0.0349F, 0.0184F, -1.0468F));

		PartDefinition TipOfTube1 = S2HTTJoint2.addOrReplaceChild("TipOfTube1", CubeListBuilder.create(), PartPose.offset(-1.5051F, 2.6489F, 0.435F));

		PartDefinition ToT4_r1 = TipOfTube1.addOrReplaceChild("ToT4_r1", CubeListBuilder.create().texOffs(62, 10).addBox(-3.25F, -1.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 10).addBox(-3.25F, 1.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(62, 10).addBox(-3.25F, -1.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(50, 10).addBox(-3.25F, -2.0F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5051F, -2.6489F, -0.435F, 0.0262F, 0.1047F, -1.0472F));

		PartDefinition FungusCrown2 = Seg2Head.addOrReplaceChild("FungusCrown2", CubeListBuilder.create(), PartPose.offset(-3.0F, -4.9546F, 5.4524F));

		PartDefinition Crown_r9 = FungusCrown2.addOrReplaceChild("Crown_r9", CubeListBuilder.create().texOffs(41, 72).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7271F, -9.4466F, -1.5452F, 0.4641F, 0.1882F, 0.2195F));

		PartDefinition Crown_r10 = FungusCrown2.addOrReplaceChild("Crown_r10", CubeListBuilder.create().texOffs(41, 72).addBox(-5.0F, 2.0F, -4.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3105F, -12.4409F, -9.0523F, 0.7331F, -0.9008F, -0.2761F));

		PartDefinition Crown_r11 = FungusCrown2.addOrReplaceChild("Crown_r11", CubeListBuilder.create().texOffs(29, 0).addBox(-3.5F, 2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.0F, -7.5F, -0.3415F, 0.456F, -0.1553F));

		PartDefinition Crown_r12 = FungusCrown2.addOrReplaceChild("Crown_r12", CubeListBuilder.create().texOffs(41, 56).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.0F, -3.5F, 0.4461F, -0.4802F, -0.2174F));

		PartDefinition OrganoidSeg3 = OrganoidSeg2.addOrReplaceChild("OrganoidSeg3", CubeListBuilder.create().texOffs(57, 86).addBox(-2.0F, -6.0F, -3.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -8.0F, 0.0F, -0.1047F, -0.2967F, 0.9707F));

		PartDefinition Tumor_r5 = OrganoidSeg3.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(20, 11).addBox(-2.5F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -7.5F, -1.5F, 0.5585F, -0.3378F, -0.2042F));

		PartDefinition Tumor_r6 = OrganoidSeg3.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(21, 9).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0255F, -3.5F, -0.8512F, 0.5593F, 0.6484F, 0.8033F));

		PartDefinition Tumor_r7 = OrganoidSeg3.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(19, 10).addBox(-1.5F, -2.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.75F, -7.0F, 2.0F, -0.5672F, 0.5672F, 0.0F));

		PartDefinition Seg3TorsoTop_r1 = OrganoidSeg3.addOrReplaceChild("Seg3TorsoTop_r1", CubeListBuilder.create().texOffs(56, 72).addBox(-1.5F, -5.5F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0668F, 0.6516F, 0.328F));

		PartDefinition Neck = OrganoidSeg3.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(48, 13).addBox(-3.0F, -8.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -6.1262F, -0.5476F, 0.5212F, 0.1351F, -0.2998F));

		PartDefinition NeckTumors = Neck.addOrReplaceChild("NeckTumors", CubeListBuilder.create(), PartPose.offset(-4.2088F, -4.6087F, 1.1771F));

		PartDefinition tumor_r8 = NeckTumors.addOrReplaceChild("tumor_r8", CubeListBuilder.create().texOffs(14, 9).addBox(-2.7408F, -3.9596F, -2.6895F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3382F, -0.3474F, 0.8017F));

		PartDefinition tumor_r9 = NeckTumors.addOrReplaceChild("tumor_r9", CubeListBuilder.create().texOffs(13, 11).addBox(-2.4224F, -2.1084F, 0.637F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.9224F, -0.3916F, -3.137F, -0.6848F, -0.2748F, 0.218F));

		PartDefinition tumor_r10 = NeckTumors.addOrReplaceChild("tumor_r10", CubeListBuilder.create().texOffs(14, 10).addBox(-4.1201F, -2.4167F, -2.4241F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2088F, -0.6339F, -1.1771F, -0.5236F, 0.0F, 0.3054F));

		PartDefinition HeadJoint = Neck.addOrReplaceChild("HeadJoint", CubeListBuilder.create(), PartPose.offset(0.0F, -2.8284F, 0.0F));

		PartDefinition Head = HeadJoint.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Center = Head.addOrReplaceChild("Center", CubeListBuilder.create().texOffs(0, 46).addBox(-3.99F, -10.1716F, -9.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, 33).addBox(-1.0F, -4.0F, -11.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r11 = Center.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(32, 16).addBox(-2.0F, -2.0F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.0F, -4.0F, 0.4215F, 0.3614F, -0.1046F));

		PartDefinition FungusCrown1 = Center.addOrReplaceChild("FungusCrown1", CubeListBuilder.create(), PartPose.offset(-2.0F, 4.0F, 0.0F));

		PartDefinition Crown_r13 = FungusCrown1.addOrReplaceChild("Crown_r13", CubeListBuilder.create().texOffs(41, 72).addBox(-3.5F, 1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -13.9942F, -1.0997F, 0.5025F, 0.4203F, 0.3468F));

		PartDefinition Crown_r14 = FungusCrown1.addOrReplaceChild("Crown_r14", CubeListBuilder.create().texOffs(29, 0).addBox(-3.0F, 0.0F, -2.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3105F, -12.4409F, -9.0523F, -0.1396F, -0.9008F, -0.2761F));

		PartDefinition Crown_r15 = FungusCrown1.addOrReplaceChild("Crown_r15", CubeListBuilder.create().texOffs(41, 56).addBox(-3.5F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.0F, -7.5F, -0.3415F, 0.456F, -0.1553F));

		PartDefinition Crown_r16 = FungusCrown1.addOrReplaceChild("Crown_r16", CubeListBuilder.create().texOffs(41, 72).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.0F, -3.5F, 0.4461F, -0.4802F, -0.2174F));

		PartDefinition CenterJaw = Center.addOrReplaceChild("CenterJaw", CubeListBuilder.create().texOffs(64, 105).addBox(-4.0F, -0.1716F, -0.75F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition SaggingFlesh = CenterJaw.addOrReplaceChild("SaggingFlesh", CubeListBuilder.create().texOffs(56, 65).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.8284F, 0.0F, 0.3897F, 0.05F, -0.121F));

		PartDefinition Left = Head.addOrReplaceChild("Left", CubeListBuilder.create().texOffs(26, 82).addBox(-3.0F, -6.1716F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, -6.0F, 0.19F, 0.0074F, 0.9496F));

		PartDefinition Tumor_r12 = Left.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(19, 11).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -5.5F, 2.5F, 0.0F, -0.5086F, 0.5051F));

		PartDefinition FungalFan_r1 = Left.addOrReplaceChild("FungalFan_r1", CubeListBuilder.create().texOffs(48, 72).addBox(-1.2642F, -3.4635F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.5F, 0.0F, 0.0F, -0.3054F, -0.48F));

		PartDefinition LeftJaw = Left.addOrReplaceChild("LeftJaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition JawBase_r1 = LeftJaw.addOrReplaceChild("JawBase_r1", CubeListBuilder.create().texOffs(46, 109).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.3284F, 0.5F, -0.0163F, 0.0255F, -0.7407F));

		PartDefinition LeftMandable = LeftJaw.addOrReplaceChild("LeftMandable", CubeListBuilder.create().texOffs(66, 0).addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(-2, 9).addBox(-2.0F, 0.0F, -1.75F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 4.0F, 0.0F, 0.0F, -0.6109F, -0.3491F));

		PartDefinition LMandSeg2 = LeftMandable.addOrReplaceChild("LMandSeg2", CubeListBuilder.create().texOffs(56, 0).addBox(-0.5F, -1.0F, -4.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offsetAndRotation(-0.15F, 0.0F, -1.65F, 0.0873F, -0.4363F, 0.0F));

		PartDefinition tooth_r1 = LMandSeg2.addOrReplaceChild("tooth_r1", CubeListBuilder.create().texOffs(-3, 9).addBox(-2.25F, 0.0F, -1.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LMandSplit1 = LMandSeg2.addOrReplaceChild("LMandSplit1", CubeListBuilder.create().texOffs(36, 7).addBox(-0.5F, -0.5F, -3.5F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(-4, 40).addBox(-1.15F, 0.0F, -3.8F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -4.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition LMandSplit2 = LMandSeg2.addOrReplaceChild("LMandSplit2", CubeListBuilder.create().texOffs(15, 94).addBox(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.15F))
		.texOffs(-6, 38).addBox(-1.05F, 0.0F, -5.75F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -4.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Sniffer = Left.addOrReplaceChild("Sniffer", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Sniffer1 = Sniffer.addOrReplaceChild("Sniffer1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -2.75F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Sniffer1Seg2_r1 = Sniffer1.addOrReplaceChild("Sniffer1Seg2_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -0.1173F, -2.0241F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0589F, -1.8851F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Sniffer1Seg1_r1 = Sniffer1.addOrReplaceChild("Sniffer1Seg1_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Sniffer2 = Sniffer.addOrReplaceChild("Sniffer2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -2.75F, 0.1666F, 0.0522F, -0.3011F));

		PartDefinition Sniffer2Seg2_r1 = Sniffer2.addOrReplaceChild("Sniffer2Seg2_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -0.1173F, -2.0241F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0881F, -1.9152F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Sniffer2Seg1_r1 = Sniffer2.addOrReplaceChild("Sniffer2Seg1_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Sniffer3 = Sniffer.addOrReplaceChild("Sniffer3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -1.0F, -2.75F, 0.5614F, -0.045F, -0.258F));

		PartDefinition Sniffer3Seg3_r1 = Sniffer3.addOrReplaceChild("Sniffer3Seg3_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, -0.1173F, -2.0241F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.075F, -2.0651F, -0.9599F, 0.0F, 0.0F));

		PartDefinition Sniffer2Seg2_r2 = Sniffer3.addOrReplaceChild("Sniffer2Seg2_r2", CubeListBuilder.create().texOffs(7, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.25F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Right = Head.addOrReplaceChild("Right", CubeListBuilder.create().texOffs(66, 0).addBox(-4.0F, -6.5F, -3.75F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.0F, -1.1716F, -5.0F, -0.1719F, -0.0302F, -0.9137F));

		PartDefinition FungalFan_r2 = Right.addOrReplaceChild("FungalFan_r2", CubeListBuilder.create().texOffs(48, 56).addBox(-3.5F, -3.5F, 0.75F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, 1.25F, 1.0F, -0.1122F, 0.0834F, 0.6812F));

		PartDefinition Nose_r4 = Right.addOrReplaceChild("Nose_r4", CubeListBuilder.create().texOffs(64, 33).addBox(-1.75F, 0.0F, -5.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition RightJaw = Right.addOrReplaceChild("RightJaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition JawBase_r2 = RightJaw.addOrReplaceChild("JawBase_r2", CubeListBuilder.create().texOffs(37, 95).addBox(-3.0F, -1.0F, -1.5F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 3.0F, -0.0846F, -0.4648F, 0.4365F));

		PartDefinition RightMandable = RightJaw.addOrReplaceChild("RightMandable", CubeListBuilder.create().texOffs(90, 0).addBox(-0.5F, -1.0F, -5.75F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 4.0F, 0.75F, 0.2276F, 0.9323F, 0.6591F));

		PartDefinition tooth_r2 = RightMandable.addOrReplaceChild("tooth_r2", CubeListBuilder.create().texOffs(84, 0).addBox(-0.5F, 0.0F, -3.0F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.75F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RMandSplit1 = RightMandable.addOrReplaceChild("RMandSplit1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -5.75F, 0.2344F, -0.3809F, -0.1079F));

		PartDefinition tooth_r3 = RMandSplit1.addOrReplaceChild("tooth_r3", CubeListBuilder.create().texOffs(-6, 38).addBox(-1.0F, 0.0F, -3.0F, 1.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -2.5F, 0.0F, 0.0873F, -3.1416F));

		PartDefinition RMandSplit1_r1 = RMandSplit1.addOrReplaceChild("RMandSplit1_r1", CubeListBuilder.create().texOffs(15, 94).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.5F, -2.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition RMandSplit2 = RightMandable.addOrReplaceChild("RMandSplit2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, -5.75F, 0.2249F, 0.2576F, 0.0389F));

		PartDefinition tooth_r4 = RMandSplit2.addOrReplaceChild("tooth_r4", CubeListBuilder.create().texOffs(-4, 39).addBox(-1.05F, -0.1F, -2.0F, 1.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.5F, 0.0F, -0.1309F, -3.1416F));

		PartDefinition RMandSplit2_r1 = RMandSplit2.addOrReplaceChild("RMandSplit2_r1", CubeListBuilder.create().texOffs(36, 7).addBox(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.5F, -1.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition RightHeadTumors = Right.addOrReplaceChild("RightHeadTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r13 = RightHeadTumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(18, 12).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -6.0F, 0.0F, 0.0F, 0.5236F, -1.1781F));

		PartDefinition Tumor_r14 = RightHeadTumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(18, 13).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.8676F, -5.5056F, -1.5971F, 1.7388F, 0.0395F, -2.5805F));

		PartDefinition Tumor_r15 = RightHeadTumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, -3.5F, -2.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.0F, -6.0F, 0.0F, 1.3509F, 0.1937F, -0.9205F));

		PartDefinition LeTubes = Head.addOrReplaceChild("LeTubes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tube = LeTubes.addOrReplaceChild("Tube", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5F, 0.5F, -4.5F, 0.1409F, -0.2281F, 0.0844F));

		PartDefinition T1S2 = Tube.addOrReplaceChild("T1S2", CubeListBuilder.create().texOffs(12, 24).addBox(-1.4456F, -1.2136F, -1.0721F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.3054F, 0.0131F, -0.0436F));

		PartDefinition T1S3 = T1S2.addOrReplaceChild("T1S3", CubeListBuilder.create().texOffs(36, 116).addBox(-1.4369F, -1.586F, -2.2278F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.45F, -1.0F, 0.2618F, 0.0349F, -0.0436F));

		PartDefinition T1S4 = T1S3.addOrReplaceChild("T1S4", CubeListBuilder.create().texOffs(23, 35).addBox(-1.5F, -1.5185F, -1.9194F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0631F, -0.086F, -1.9778F, 0.2182F, 0.0F, -0.0175F));

		PartDefinition T1S5 = T1S4.addOrReplaceChild("T1S5", CubeListBuilder.create().texOffs(18, 29).addBox(-1.5F, -1.6546F, -2.2973F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.3925F, -0.0113F, -0.0421F));

		PartDefinition T1Tip = T1S5.addOrReplaceChild("T1Tip", CubeListBuilder.create().texOffs(56, 11).addBox(-1.0F, -2.1546F, -2.7973F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 11).addBox(-1.0F, 0.8454F, -2.7973F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 10).addBox(-2.0F, -1.1546F, -2.7973F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 10).addBox(1.0F, -1.1546F, -2.7973F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void animateTumor(ModelPart part,float value){
		part.xScale =1+ Mth.sin(value/8)/8;
		part.yScale =1+ Mth.cos(value/8)/8;
		part.zScale =1+ Mth.sin(value/8)/8;
	}
	public void animateRibs(ModelPart part,float value){
		animateTentacleX(part,Mth.cos(value/4)/4);
	}
	public void animateRibs(ModelPart part,float value,int i ,int e){
		animateTentacleX(part,Mth.cos(value/i)/e);
	}

	public void animateTubes1(ModelPart part,float val){
		this.animateTentacleX(part,val);
		this.animateTentacleY(part,val);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTumor(this.BaseTumor,ageInTicks);
		this.animateRibs(this.Rib1,ageInTicks);
		this.animateRibs(this.Rib2,ageInTicks,5,6);
		this.animateRibs(this.Rib3,ageInTicks);
		this.animateRibs(this.ribJoint4,-ageInTicks,3,4);
		this.animateRibs(this.ribJoint5,-ageInTicks);
		this.animateRibs(this.ribJoint6,-ageInTicks,5,4);
		this.animateRibs(this.ribJoint7,-ageInTicks,5,5);
		this.animateTumor(this.BaseTumor,-ageInTicks);
		this.OrganoidSeg1.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.OrganoidSeg2.zRot = -0.5f-Mth.sin(ageInTicks/6)/6;
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.animateTentacleX(HeadJoint,headPitch /  ( 90F / (float) Math.PI));
		this.LeftJaw.yRot = Mth.cos(ageInTicks/5)/5;
		this.RightJaw.yRot = Mth.sin(ageInTicks/5)/5;
		this.animateTubes1(Tube,-Mth.cos(ageInTicks/4)/6);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r,float g,float b, float alpha) {
		spitterorganoid.render(poseStack, vertexConsumer, packedLight, packedOverlay, r,g,b,alpha);
	}
}