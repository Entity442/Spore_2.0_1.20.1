package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.EvolvedInfected.Howler;
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

public class bansheeHowlerModel<T extends Howler> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bansheehowlermodel"), "main");
	private final ModelPart Howler;
	private final ModelPart Head;
	private final ModelPart flower3;
	private final ModelPart flower5;
	private final ModelPart flower2;
	private final ModelPart flower;
	private final ModelPart flower4;
	private final ModelPart topRightFangs;
	private final ModelPart topRightFangs2;
	private final ModelPart topRightFangs3;
	private final ModelPart topLegFangs;
	private final ModelPart topLegFangs2;
	private final ModelPart topLegFangs3;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmSplit1;
	private final ModelPart LASplit1Claw;
	private final ModelPart LASplit1Joint;
	private final ModelPart LASplit1Plane;
	private final ModelPart LeftArmSplit2;
	private final ModelPart LASplit2Claw;
	private final ModelPart LASplit2Plane;
	private final ModelPart RightArm;
	private final ModelPart LeftArmSplit4;
	private final ModelPart LASplit1Claw2;
	private final ModelPart LASplit1Joint2;
	private final ModelPart LASplit1Plane2;
	private final ModelPart LeftArmSplit3;
	private final ModelPart LASplit2Claw2;
	private final ModelPart LASplit2Joint2;
	private final ModelPart LASplit2Plane2;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart body;
	private final ModelPart spine;
	private final ModelPart spine2;
	private final ModelPart bone;
	private final ModelPart bone2;

	public bansheeHowlerModel(ModelPart root) {
		this.Howler = root.getChild("Howler");
		this.Head = this.Howler.getChild("Head");
		this.flower3 = this.Head.getChild("flower3");
		this.flower5 = this.Head.getChild("flower5");
		this.flower2 = this.Head.getChild("flower2");
		this.flower = this.Head.getChild("flower");
		this.flower4 = this.Head.getChild("flower4");
		this.topRightFangs = this.Head.getChild("topRightFangs");
		this.topRightFangs2 = this.Head.getChild("topRightFangs2");
		this.topRightFangs3 = this.Head.getChild("topRightFangs3");
		this.topLegFangs = this.Head.getChild("topLegFangs");
		this.topLegFangs2 = this.Head.getChild("topLegFangs2");
		this.topLegFangs3 = this.Head.getChild("topLegFangs3");
		this.LeftArm = this.Howler.getChild("LeftArm");
		this.LeftArmSplit1 = this.LeftArm.getChild("LeftArmSplit1");
		this.LASplit1Claw = this.LeftArmSplit1.getChild("LASplit1Claw");
		this.LASplit1Joint = this.LASplit1Claw.getChild("LASplit1Joint");
		this.LASplit1Plane = this.LASplit1Joint.getChild("LASplit1Plane");
		this.LeftArmSplit2 = this.LeftArm.getChild("LeftArmSplit2");
		this.LASplit2Claw = this.LeftArmSplit2.getChild("LASplit2Claw");
		this.LASplit2Plane = this.LASplit2Claw.getChild("LASplit2Plane");
		this.RightArm = this.Howler.getChild("RightArm");
		this.LeftArmSplit4 = this.RightArm.getChild("LeftArmSplit4");
		this.LASplit1Claw2 = this.LeftArmSplit4.getChild("LASplit1Claw2");
		this.LASplit1Joint2 = this.LASplit1Claw2.getChild("LASplit1Joint2");
		this.LASplit1Plane2 = this.LASplit1Joint2.getChild("LASplit1Plane2");
		this.LeftArmSplit3 = this.RightArm.getChild("LeftArmSplit3");
		this.LASplit2Claw2 = this.LeftArmSplit3.getChild("LASplit2Claw2");
		this.LASplit2Joint2 = this.LASplit2Claw2.getChild("LASplit2Joint2");
		this.LASplit2Plane2 = this.LASplit2Joint2.getChild("LASplit2Plane2");
		this.RightLeg = this.Howler.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = this.Howler.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.body = this.Howler.getChild("body");
		this.spine = this.body.getChild("spine");
		this.spine2 = this.body.getChild("spine2");
		this.bone = this.body.getChild("bone");
		this.bone2 = this.body.getChild("bone2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Howler = partdefinition.addOrReplaceChild("Howler", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = Howler.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 66).addBox(-4.0F, -3.0F, -1.5F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -4.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 9).addBox(11.4592F, -0.8347F, -7.7493F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5F, -13.5F, 6.1F, -0.2322F, 0.1211F, 0.4443F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-0.5037F, 1.2016F, -6.7665F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6F, -9.3F, 1.2F, -0.2615F, 0.0135F, 0.4869F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-0.5037F, 1.2016F, -6.7665F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8F, -8.3F, 2.8F, 0.0876F, 0.0135F, 0.4869F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(33, 0).addBox(-7.4963F, 1.2016F, -6.7665F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -8.3F, 2.1F, 0.0876F, -0.0135F, -0.4869F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(33, 0).addBox(-7.4963F, 1.2016F, -6.7665F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -6.1F, 5.1F, -0.2615F, -0.0135F, -0.4869F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(29, 26).addBox(-7.0234F, -0.0766F, -5.25F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -6.1F, 5.1F, -0.2618F, 0.0F, -0.4363F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(33, 0).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 23.0F, 3.2F, -0.2615F, -0.0135F, -0.3124F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(29, 26).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 22.1F, 5.1F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -0.1F, 6.0F, 0.1056F, 0.0264F, 0.1931F));

		PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(54, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -0.2F, 3.2F, -0.1384F, -0.3891F, 0.0286F));

		PartDefinition cube_r11 = Head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(62, 29).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.0F, 1.7F, -0.0978F, 0.2935F, -0.0363F));

		PartDefinition cube_r12 = Head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(62, 18).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 0.1F, -0.9F, 0.1571F, -0.6632F, 0.0F));

		PartDefinition cube_r13 = Head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(21, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.8F, 0.9F, 0.0731F, -0.3595F, -0.2053F));

		PartDefinition cube_r14 = Head.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(66, 11).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -1.9F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower3 = Head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.35F, -9.45F, 2.1F, -0.2112F, -0.5515F, 1.5093F));

		PartDefinition cube_r15 = flower3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flower3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r18 = flower3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower5 = Head.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -10.25F, 3.5F, -0.9784F, -0.1588F, 0.667F));

		PartDefinition cube_r19 = flower5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flower5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flower5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r22 = flower5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower2 = Head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.25F, -8.05F, -2.7F, 0.8814F, 0.8237F, -0.533F));

		PartDefinition cube_r23 = flower2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r24 = flower2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = flower2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r26 = flower2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower = Head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -10.95F, -3.3F, 1.0472F, 0.0F, 0.4363F));

		PartDefinition cube_r27 = flower.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.0262F, 0.0F, 0.0F));

		PartDefinition cube_r28 = flower.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r29 = flower.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2705F));

		PartDefinition cube_r30 = flower.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower4 = Head.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.85F, -11.25F, 0.2F, -0.1042F, 0.8419F, -0.4418F));

		PartDefinition cube_r31 = flower4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r32 = flower4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r33 = flower4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r34 = flower4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition topRightFangs = Head.addOrReplaceChild("topRightFangs", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.35F, 2.7F, -3.2F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r35 = topRightFangs.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9541F, 2.55F, -0.577F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r36 = topRightFangs.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.054F, -0.5F, -0.477F, 0.0F, -0.2094F, -0.0698F));

		PartDefinition cube_r37 = topRightFangs.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.804F, 1.0F, -0.477F, 0.0F, 0.0524F, -0.0698F));

		PartDefinition topRightFangs2 = Head.addOrReplaceChild("topRightFangs2", CubeListBuilder.create(), PartPose.offset(-2.35F, -2.05F, -3.7F));

		PartDefinition cube_r38 = topRightFangs2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9541F, 2.55F, -0.577F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r39 = topRightFangs2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.054F, -0.5F, -0.477F, 0.0F, -0.2094F, -0.0698F));

		PartDefinition cube_r40 = topRightFangs2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.804F, 1.0F, -0.477F, 0.0F, 0.0524F, -0.0698F));

		PartDefinition topRightFangs3 = Head.addOrReplaceChild("topRightFangs3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6F, 6.2F, -0.7F, 0.6167F, 0.2351F, -0.3175F));

		PartDefinition cube_r41 = topRightFangs3.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.054F, -0.5F, -0.477F, 0.0F, -0.2094F, -0.0698F));

		PartDefinition cube_r42 = topRightFangs3.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.804F, 1.0F, -0.477F, 0.0F, 0.0524F, -0.0698F));

		PartDefinition topLegFangs = Head.addOrReplaceChild("topLegFangs", CubeListBuilder.create(), PartPose.offset(1.75F, -0.6F, -6.0F));

		PartDefinition cube_r43 = topLegFangs.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.55F, 1.6F, -0.8F, 0.1047F, -0.4014F, 0.0F));

		PartDefinition cube_r44 = topLegFangs.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(20, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, -1.0F, 0.0215F, -0.1732F, -0.124F));

		PartDefinition topLegFangs2 = Head.addOrReplaceChild("topLegFangs2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 2.9F, -3.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r45 = topLegFangs2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.55F, 1.6F, -0.8F, 0.1047F, -0.4014F, 0.0F));

		PartDefinition cube_r46 = topLegFangs2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(20, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, -1.0F, 0.0215F, -0.1732F, -0.124F));

		PartDefinition topLegFangs3 = Head.addOrReplaceChild("topLegFangs3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, 6.15F, -1.0F, 0.4122F, 0.2995F, 0.4705F));

		PartDefinition cube_r47 = topLegFangs3.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 1.6F, -0.8F, 0.1047F, -0.4014F, 0.0F));

		PartDefinition cube_r48 = topLegFangs3.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(20, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, -1.0F, 0.0215F, -0.1732F, -0.124F));

		PartDefinition LeftArm = Howler.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(110, 0).mirror().addBox(0.0F, -2.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offset(5.3883F, -23.6386F, -2.4783F));

		PartDefinition cube_r49 = LeftArm.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(29, 35).mirror().addBox(-4.3379F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1117F, 2.0386F, 2.4783F, -0.0631F, 0.3435F, -0.1855F));

		PartDefinition LeftArmSplit1 = LeftArm.addOrReplaceChild("LeftArmSplit1", CubeListBuilder.create().texOffs(101, 22).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.1993F, 3.0463F, 1.0F, 0.0F, -0.5236F, -0.6545F));

		PartDefinition LASplit1Claw = LeftArmSplit1.addOrReplaceChild("LASplit1Claw", CubeListBuilder.create().texOffs(101, 32).mirror().addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
		.texOffs(63, 93).mirror().addBox(-0.5F, -4.5F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.0338F, 5.5856F, -0.1049F, 2.7067F, -0.9739F, -0.0364F));

		PartDefinition LASplit1Joint = LASplit1Claw.addOrReplaceChild("LASplit1Joint", CubeListBuilder.create().texOffs(100, 12).mirror().addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition LASplit1Plane = LASplit1Joint.addOrReplaceChild("LASplit1Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = LASplit1Plane.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(106, 6).mirror().addBox(0.0F, -6.5F, -1.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.5F, -0.5F, 0.0F, -3.1416F, 0.0F));

		PartDefinition LeftArmSplit2 = LeftArm.addOrReplaceChild("LeftArmSplit2", CubeListBuilder.create().texOffs(116, 40).mirror().addBox(-2.25F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(2.1993F, 3.0463F, -2.0083F, -0.3491F, 0.5236F, -0.3054F));

		PartDefinition LASplit2Claw = LeftArmSplit2.addOrReplaceChild("LASplit2Claw", CubeListBuilder.create().texOffs(109, 31).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
		.texOffs(71, 92).addBox(-1.0798F, -0.3483F, -1.6135F, 2.0F, 4.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.5953F, 7.3483F, 0.1218F, 2.189F, -1.5138F, -2.9258F));

		PartDefinition LASplit2Plane = LASplit2Claw.addOrReplaceChild("LASplit2Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.1506F, -0.1404F, 0.48F, 0.0F, 0.0F));

		PartDefinition Plane_r2 = LASplit2Plane.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(118, 6).mirror().addBox(0.0F, -5.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.5F, 0.25F, 0.0F, -3.1416F, 0.0F));

		PartDefinition RightArm = Howler.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(110, 0).addBox(-4.0F, -2.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(-0.01F))
		.texOffs(41, 93).addBox(-4.0F, -2.0F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offset(-5.3883F, -23.6386F, -2.4783F));

		PartDefinition cube_r50 = RightArm.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1117F, 1.0386F, 1.4783F, -0.1807F, -0.5381F, 0.1258F));

		PartDefinition cube_r51 = RightArm.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1117F, 2.0386F, 2.4783F, -0.0631F, 0.0492F, -0.1199F));

		PartDefinition LeftArmSplit4 = RightArm.addOrReplaceChild("LeftArmSplit4", CubeListBuilder.create().texOffs(101, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(71, 92).addBox(-1.5F, 3.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.1993F, 3.0463F, 1.0F, 0.1483F, 0.8531F, 0.6055F));

		PartDefinition LASplit1Claw2 = LeftArmSplit4.addOrReplaceChild("LASplit1Claw2", CubeListBuilder.create().texOffs(101, 32).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0338F, 5.5856F, -0.1049F, 2.7067F, 0.9739F, 0.0364F));

		PartDefinition LASplit1Joint2 = LASplit1Claw2.addOrReplaceChild("LASplit1Joint2", CubeListBuilder.create().texOffs(100, 12).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition LASplit1Plane2 = LASplit1Joint2.addOrReplaceChild("LASplit1Plane2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Plane_r3 = LASplit1Plane2.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(106, 5).addBox(0.0F, -6.5F, -4.5F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -1.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition LeftArmSplit3 = RightArm.addOrReplaceChild("LeftArmSplit3", CubeListBuilder.create().texOffs(116, 40).addBox(-0.75F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.1993F, 3.0463F, -2.0083F, -0.48F, -0.5236F, 0.5236F));

		PartDefinition LASplit2Claw2 = LeftArmSplit3.addOrReplaceChild("LASplit2Claw2", CubeListBuilder.create().texOffs(109, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(62, 93).addBox(-1.0F, 2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5953F, 7.3483F, 0.1218F, 2.4945F, 1.5138F, 2.9258F));

		PartDefinition LASplit2Joint2 = LASplit2Claw2.addOrReplaceChild("LASplit2Joint2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition ClawBase_r1 = LASplit2Joint2.addOrReplaceChild("ClawBase_r1", CubeListBuilder.create().texOffs(119, 31).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition LASplit2Plane2 = LASplit2Joint2.addOrReplaceChild("LASplit2Plane2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r4 = LASplit2Plane2.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(118, 6).addBox(0.0F, -4.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RightLeg = Howler.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 66).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.9F, -16.0F, 2.5F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftLeg = Howler.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(75, 40).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 90).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(1.9F, -16.0F, 2.5F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(15, 77).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition body = Howler.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 18).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(0, 102).addBox(-4.0F, 8.0F, -2.2F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offsetAndRotation(0.0F, -25.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r52 = body.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, 3.8F, -2.5F, -0.1953F, -0.2F, 0.1065F));

		PartDefinition cube_r53 = body.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(42, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 2.9F, -3.2F, 0.0467F, 0.2201F, 0.0342F));

		PartDefinition cube_r54 = body.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 2.1F, -5.5F, 0.0006F, 0.1336F, 1.7555F));

		PartDefinition cube_r55 = body.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(33, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.0F, 0.2F, 0.9137F, 0.1587F, -0.1446F));

		PartDefinition cube_r56 = body.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(63, 55).mirror().addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.6F, 5.6F, 2.2F, 0.0385F, -0.0455F, -0.191F));

		PartDefinition cube_r57 = body.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, 5.6F, 2.2F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r58 = body.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.4F, 5.4F, 3.3F, -0.3106F, 0.0455F, 0.191F));

		PartDefinition cube_r59 = body.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 8.3F, 3.3F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r60 = body.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 8.9F, 2.2F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r61 = body.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(0, 44).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7F, 33.5F, -3.6F, -0.4967F, -0.3692F, 0.4163F));

		PartDefinition cube_r62 = body.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(29, 35).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.5F, 32.4F, 4.0F, -0.2199F, -0.0971F, 0.3518F));

		PartDefinition cube_r63 = body.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 109).addBox(-6.0F, -5.5F, -5.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, -4.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r64 = spine.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(83, 11).addBox(-2.0F, -4.0F, -2.25F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r65 = spine.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(60, 79).addBox(0.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -5.5F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r66 = spine2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(44, 66).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r67 = spine2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(25, 66).addBox(0.0F, -4.0F, -1.75F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.18F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.8F, 4.6F, -3.3F, 0.041F, -0.1517F, -0.2649F));

		PartDefinition cube_r68 = bone.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(42, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 2.1F, 0.7F, 0.0467F, 0.2201F, 0.0342F));

		PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.8F, 4.6F, -3.3F, 0.041F, 0.1517F, 0.2649F));

		PartDefinition cube_r69 = bone2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(42, 55).mirror().addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3F, 2.1F, 0.7F, 0.0467F, -0.2201F, -0.0342F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			float val = Mth.sin(ageInTicks/4)/4;
			this.RightArm.xRot = -89.5F +val;
			this.LeftArm.xRot = -89.5F -val;
		}else if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.4F * limbSwingAmount;
			this.LeftArm.xRot = -this.RightArm.xRot;
			this.RightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		}else {
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}
		this.LeftLeg.xRot = Mth.cos(limbSwing ) * limbSwingAmount;
		this.RightLeg.xRot = -LeftLeg.xRot;
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.rightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.topRightFangs.yRot = Mth.sin(ageInTicks/6)/7;
		this.topLegFangs.yRot = -topRightFangs.yRot;
		this.topRightFangs2.yRot = this.topRightFangs.yRot;
		this.topRightFangs3.yRot = this.topRightFangs.yRot;
		this.topLegFangs2.yRot = -topRightFangs.yRot;
		this.topLegFangs3.yRot = -topRightFangs.yRot;
		float armMov = Mth.cos(ageInTicks/6)/7;
		float armMov2 = Mth.sin(ageInTicks/6)/7;
		float forArmMoV = Mth.cos(ageInTicks/7)/6;
		float forArmMoV2 = Mth.sin(ageInTicks/7)/6;
		float clawMov = Mth.sin(ageInTicks/6)/6;
		float clawMov2 = Mth.cos(ageInTicks/6)/6;
		animateTentacleZ(LeftArmSplit1,armMov);
		animateTentacleZ(LeftArmSplit2,armMov2);
		animateTentacleZ(LeftArmSplit4,-armMov2);
		animateTentacleZ(LeftArmSplit3,-armMov);
		animateTentacleX(LASplit1Claw,forArmMoV2);
		animateTentacleX(LASplit2Claw,forArmMoV);
		animateTentacleY(LASplit2Claw,-forArmMoV);
		animateTentacleX(LASplit1Joint,clawMov);
		animateTentacleX(LASplit1Claw2,-clawMov2);
		animateTentacleX(LASplit1Joint2,clawMov2);
		animateTentacleX(LASplit2Claw2,-clawMov);
		animateTentacleX(LASplit2Joint2,clawMov);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Howler.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}