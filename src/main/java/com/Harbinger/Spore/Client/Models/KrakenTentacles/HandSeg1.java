package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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
import net.minecraft.world.entity.Entity;

public class HandSeg1<T extends Entity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "handseg1"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart CalcifiedCorpses;
	private final ModelPart CalcifiedCorpse1;
	private final ModelPart CalcifiedThorns;
	private final ModelPart CalcifiedThorn1;
	private final ModelPart CalcifiedThorn2;
	private final ModelPart CalcifiedThorn3;
	private final ModelPart CalcifiedThorn4;
	private final ModelPart Fingers;
	private final ModelPart Finger1;
	private final ModelPart RightArmSplit2Seg1;
	private final ModelPart RASplit2Claw1;
	private final ModelPart RASplit2Joint1;
	private final ModelPart RASplit2Plane1;
	private final ModelPart RASplit2Claw2;
	private final ModelPart RASplit2Joint2;
	private final ModelPart RASplit2Plane2;
	private final ModelPart RASplit2Claw3;
	private final ModelPart RASplit2Joint3;
	private final ModelPart RASplit2Plane3;
	private final ModelPart Finger2;
	private final ModelPart RightArmSplit2Seg2;
	private final ModelPart RASplit2Claw5;
	private final ModelPart RASplit2Joint5;
	private final ModelPart RASplit2Plane5;
	private final ModelPart RASplit2Claw4;
	private final ModelPart RASplit2Joint4;
	private final ModelPart RASplit2Plane4;
	private final ModelPart Finger3;
	private final ModelPart RightArmSplit2Seg3;
	private final ModelPart RASplit2Claw6;
	private final ModelPart RASplit2Joint6;
	private final ModelPart RASplit2Plane6;
	private final ModelPart RASplit2Claw7;
	private final ModelPart RASplit2Joint7;
	private final ModelPart RASplit2Plane7;

	public HandSeg1() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.CalcifiedCorpses = root.getChild("CalcifiedCorpses");
		this.CalcifiedCorpse1 = this.CalcifiedCorpses.getChild("CalcifiedCorpse1");
		this.CalcifiedThorns = root.getChild("CalcifiedThorns");
		this.CalcifiedThorn1 = this.CalcifiedThorns.getChild("CalcifiedThorn1");
		this.CalcifiedThorn2 = this.CalcifiedThorns.getChild("CalcifiedThorn2");
		this.CalcifiedThorn3 = this.CalcifiedThorns.getChild("CalcifiedThorn3");
		this.CalcifiedThorn4 = this.CalcifiedThorns.getChild("CalcifiedThorn4");
		this.Fingers = root.getChild("Fingers");
		this.Finger1 = this.Fingers.getChild("Finger1");
		this.RightArmSplit2Seg1 = this.Finger1.getChild("RightArmSplit2Seg1");
		this.RASplit2Claw1 = this.RightArmSplit2Seg1.getChild("RASplit2Claw1");
		this.RASplit2Joint1 = this.RASplit2Claw1.getChild("RASplit2Joint1");
		this.RASplit2Plane1 = this.RASplit2Joint1.getChild("RASplit2Plane1");
		this.RASplit2Claw2 = this.RightArmSplit2Seg1.getChild("RASplit2Claw2");
		this.RASplit2Joint2 = this.RASplit2Claw2.getChild("RASplit2Joint2");
		this.RASplit2Plane2 = this.RASplit2Joint2.getChild("RASplit2Plane2");
		this.RASplit2Claw3 = this.RightArmSplit2Seg1.getChild("RASplit2Claw3");
		this.RASplit2Joint3 = this.RASplit2Claw3.getChild("RASplit2Joint3");
		this.RASplit2Plane3 = this.RASplit2Joint3.getChild("RASplit2Plane3");
		this.Finger2 = this.Fingers.getChild("Finger2");
		this.RightArmSplit2Seg2 = this.Finger2.getChild("RightArmSplit2Seg2");
		this.RASplit2Claw5 = this.RightArmSplit2Seg2.getChild("RASplit2Claw5");
		this.RASplit2Joint5 = this.RASplit2Claw5.getChild("RASplit2Joint5");
		this.RASplit2Plane5 = this.RASplit2Joint5.getChild("RASplit2Plane5");
		this.RASplit2Claw4 = this.RightArmSplit2Seg2.getChild("RASplit2Claw4");
		this.RASplit2Joint4 = this.RASplit2Claw4.getChild("RASplit2Joint4");
		this.RASplit2Plane4 = this.RASplit2Joint4.getChild("RASplit2Plane4");
		this.Finger3 = this.Fingers.getChild("Finger3");
		this.RightArmSplit2Seg3 = this.Finger3.getChild("RightArmSplit2Seg3");
		this.RASplit2Claw6 = this.RightArmSplit2Seg3.getChild("RASplit2Claw6");
		this.RASplit2Joint6 = this.RASplit2Claw6.getChild("RASplit2Joint6");
		this.RASplit2Plane6 = this.RASplit2Joint6.getChild("RASplit2Plane6");
		this.RASplit2Claw7 = this.RightArmSplit2Seg3.getChild("RASplit2Claw7");
		this.RASplit2Joint7 = this.RASplit2Claw7.getChild("RASplit2Joint7");
		this.RASplit2Plane7 = this.RASplit2Joint7.getChild("RASplit2Plane7");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpses = partdefinition.addOrReplaceChild("CalcifiedCorpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpse1 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse1", CubeListBuilder.create(), PartPose.offset(-5.0F, -13.2857F, 22.9286F));

		PartDefinition Leg_r1 = CalcifiedCorpse1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.2857F, -24.9286F, -0.1249F, -0.24F, -0.0933F));

		PartDefinition Leg_r2 = CalcifiedCorpse1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 0.2857F, -19.2286F, -0.0699F, -0.0348F, -0.0674F));

		PartDefinition Arm_r1 = CalcifiedCorpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, -3.7143F, -26.8286F, -0.1304F, 0.185F, -0.2871F));

		PartDefinition Arm_r2 = CalcifiedCorpse1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(40, 51).addBox(0.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, 3.2857F, -17.9286F, -0.5672F, 0.0F, -1.0908F));

		PartDefinition TorsoBase_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.3143F, -19.3286F, 2.8501F, 1.0725F, 2.9598F));

		PartDefinition TorsoTop_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5143F, -21.4286F, 0.2054F, 0.0741F, 1.2294F));

		PartDefinition Head_r1 = CalcifiedCorpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, -2.0143F, -23.9286F, 0.1069F, 0.0403F, 1.5252F));

		PartDefinition CalcifiedThorns = partdefinition.addOrReplaceChild("CalcifiedThorns", CubeListBuilder.create(), PartPose.offset(-3.2484F, 23.5056F, 16.1064F));

		PartDefinition CalcifiedThorn1 = CalcifiedThorns.addOrReplaceChild("CalcifiedThorn1", CubeListBuilder.create().texOffs(43, 49).addBox(-0.9423F, -0.3335F, -0.9959F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, -14.0F, -11.9F, 0.4815F, -0.0142F, -0.0044F));

		PartDefinition Plane2_r1 = CalcifiedThorn1.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3423F, 6.6665F, -0.2959F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = CalcifiedThorn1.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3577F, 6.6665F, -0.2959F, 0.0F, -0.7854F, 0.0F));

		PartDefinition CalcifiedThorn2 = CalcifiedThorns.addOrReplaceChild("CalcifiedThorn2", CubeListBuilder.create().texOffs(48, 48).addBox(-0.9423F, -0.3335F, -0.9958F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -13.1F, -17.1F, -3.0863F, -1.3078F, -2.7947F));

		PartDefinition Plane3_r1 = CalcifiedThorn2.addOrReplaceChild("Plane3_r1", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3423F, 6.6665F, -0.2958F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r2 = CalcifiedThorn2.addOrReplaceChild("Plane2_r2", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3577F, 6.6665F, -0.2958F, 0.0F, -0.7854F, 0.0F));

		PartDefinition CalcifiedThorn3 = CalcifiedThorns.addOrReplaceChild("CalcifiedThorn3", CubeListBuilder.create().texOffs(50, 48).addBox(-0.9423F, -0.3335F, -0.9959F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8F, -13.1F, -18.1F, 0.4158F, -1.203F, -0.8402F));

		PartDefinition Plane4_r1 = CalcifiedThorn3.addOrReplaceChild("Plane4_r1", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3423F, 6.6665F, -0.2958F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r2 = CalcifiedThorn3.addOrReplaceChild("Plane3_r2", CubeListBuilder.create().texOffs(62, 57).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3577F, 6.6665F, -0.2958F, 0.0F, -0.7854F, 0.0F));

		PartDefinition CalcifiedThorn4 = CalcifiedThorns.addOrReplaceChild("CalcifiedThorn4", CubeListBuilder.create().texOffs(33, 55).addBox(-0.9423F, -0.3335F, -0.9959F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -13.1F, -20.9F, -1.5833F, -1.1368F, 1.4906F));

		PartDefinition Plane5_r1 = CalcifiedThorn4.addOrReplaceChild("Plane5_r1", CubeListBuilder.create().texOffs(62, 47).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3423F, 6.6665F, -0.2959F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r2 = CalcifiedThorn4.addOrReplaceChild("Plane4_r2", CubeListBuilder.create().texOffs(62, 51).addBox(0.0F, -2.0F, -0.5F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3577F, 6.6665F, -0.2959F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Fingers = partdefinition.addOrReplaceChild("Fingers", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Finger1 = Fingers.addOrReplaceChild("Finger1", CubeListBuilder.create().texOffs(10, 13).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7265F, -5.9457F, 0.6402F, -3.072F, 0.0785F, -2.9963F));

		PartDefinition RightArmSplit2Seg1 = Finger1.addOrReplaceChild("RightArmSplit2Seg1", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1471F, 6.3773F, 0.171F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw1 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw1", CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.177F, 1.5284F, 0.003F, -2.415F, -1.0724F, 1.5044F));

		PartDefinition RASplit2Joint1 = RASplit2Claw1.addOrReplaceChild("RASplit2Joint1", CubeListBuilder.create().texOffs(8, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane1 = RASplit2Joint1.addOrReplaceChild("RASplit2Plane1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = RASplit2Plane1.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(120, 70).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit2Claw2 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw2", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.2485F, 5.0629F, -0.1709F, -1.9428F, 1.0657F, 0.1813F));

		PartDefinition RASplit2Joint2 = RASplit2Claw2.addOrReplaceChild("RASplit2Joint2", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane2 = RASplit2Joint2.addOrReplaceChild("RASplit2Plane2", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw3 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw3", CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.823F, -2.4716F, 0.003F, 2.2841F, -1.2599F, 2.7241F));

		PartDefinition RASplit2Joint3 = RASplit2Claw3.addOrReplaceChild("RASplit2Joint3", CubeListBuilder.create().texOffs(8, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane3 = RASplit2Joint3.addOrReplaceChild("RASplit2Plane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r2 = RASplit2Plane3.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(120, 70).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Finger2 = Fingers.addOrReplaceChild("Finger2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2735F, -3.9457F, -3.3598F, -1.1709F, 0.5439F, -1.1911F));

		PartDefinition RightArmSplit2Seg2 = Finger2.addOrReplaceChild("RightArmSplit2Seg2", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2873F, 0.3111F, 0.0592F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw5 = RightArmSplit2Seg2.addOrReplaceChild("RASplit2Claw5", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.1515F, 5.0629F, 0.4291F, -1.9895F, 0.0747F, 0.2111F));

		PartDefinition RASplit2Joint5 = RASplit2Claw5.addOrReplaceChild("RASplit2Joint5", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane5 = RASplit2Joint5.addOrReplaceChild("RASplit2Plane5", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw4 = RightArmSplit2Seg2.addOrReplaceChild("RASplit2Claw4", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0515F, 4.5629F, -0.7709F, 0.9884F, -0.0863F, -2.8196F));

		PartDefinition RASplit2Joint4 = RASplit2Claw4.addOrReplaceChild("RASplit2Joint4", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane4 = RASplit2Joint4.addOrReplaceChild("RASplit2Plane4", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition Finger3 = Fingers.addOrReplaceChild("Finger3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3735F, -3.9457F, 4.2402F, 1.6636F, -1.0976F, -1.725F));

		PartDefinition RightArmSplit2Seg3 = Finger3.addOrReplaceChild("RightArmSplit2Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2873F, 0.3111F, 0.0592F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RightArm_r1 = RightArmSplit2Seg3.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(21, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.75F, -1.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition RASplit2Claw6 = RightArmSplit2Seg3.addOrReplaceChild("RASplit2Claw6", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4485F, 5.0629F, 0.4291F, -2.0956F, 0.8248F, 0.2879F));

		PartDefinition RASplit2Joint6 = RASplit2Claw6.addOrReplaceChild("RASplit2Joint6", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane6 = RASplit2Joint6.addOrReplaceChild("RASplit2Plane6", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw7 = RightArmSplit2Seg3.addOrReplaceChild("RASplit2Claw7", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4485F, 4.5629F, -0.7709F, 1.0957F, 0.8955F, -2.5212F));

		PartDefinition RASplit2Joint7 = RASplit2Claw7.addOrReplaceChild("RASplit2Joint7", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane7 = RASplit2Joint7.addOrReplaceChild("RASplit2Plane7", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float v1 = Mth.sin(ageInTicks/6)/7;
		float v2 = Mth.cos(ageInTicks/6)/8;
		float v3 = Mth.cos(ageInTicks/7)/6;
		float v4 = Mth.sin(ageInTicks/8)/6;
		animateTentacleX(Finger1,v1);
		animateTentacleY(Finger2,v2);
		animateTentacleY(Finger3,v4);
		animateTentacleX(RASplit2Claw7,v3);
		animateTentacleX(RASplit2Claw6,v4);
		animateTentacleX(RASplit2Claw5,v3);
		animateTentacleZ(RightArmSplit2Seg1,v1);
		animateTentacleX(RASplit2Claw4,v2);
		animateTentacleX(RASplit2Claw1,-v3);
		animateTentacleX(RASplit2Claw2,-v2);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		CalcifiedCorpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		CalcifiedThorns.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Fingers.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}