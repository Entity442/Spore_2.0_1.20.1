package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
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

public class ScrewerSlasherModel<T extends Slasher> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "screwerslashermodel"), "main");
	private final ModelPart Acupuncturer;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_foot;
	private final ModelPart right_leg;
	private final ModelPart right_foot;
	private final ModelPart waist;
	private final ModelPart upper_torso;
	private final ModelPart arms;
	private final ModelPart right_shoulder;
	private final ModelPart right_arm;
	private final ModelPart right_forearm;
	private final ModelPart right_MARM;
	private final ModelPart right_foreMARM;
	private final ModelPart right_cork;
	private final ModelPart spike4;
	private final ModelPart spike5;
	private final ModelPart spike7;
	private final ModelPart spike8;
	private final ModelPart left_shoulder;
	private final ModelPart left_arm;
	private final ModelPart left_forearm;
	private final ModelPart left_MARM;
	private final ModelPart left_foreMARM;
	private final ModelPart left_cork;
	private final ModelPart spike;
	private final ModelPart spike2;
	private final ModelPart spike3;
	private final ModelPart spike6;
	private final ModelPart head;
	private final ModelPart jaw;

	public ScrewerSlasherModel(ModelPart root) {
		this.Acupuncturer = root.getChild("Acupuncturer");
		this.legs = this.Acupuncturer.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_foot = this.left_leg.getChild("left_foot");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_foot = this.right_leg.getChild("right_foot");
		this.waist = this.Acupuncturer.getChild("waist");
		this.upper_torso = this.waist.getChild("upper_torso");
		this.arms = this.upper_torso.getChild("arms");
		this.right_shoulder = this.arms.getChild("right_shoulder");
		this.right_arm = this.right_shoulder.getChild("right_arm");
		this.right_forearm = this.right_arm.getChild("right_forearm");
		this.right_MARM = this.right_shoulder.getChild("right_MARM");
		this.right_foreMARM = this.right_MARM.getChild("right_foreMARM");
		this.right_cork = this.right_foreMARM.getChild("right_cork");
		this.spike4 = this.right_shoulder.getChild("spike4");
		this.spike5 = this.right_shoulder.getChild("spike5");
		this.spike7 = this.right_shoulder.getChild("spike7");
		this.spike8 = this.right_shoulder.getChild("spike8");
		this.left_shoulder = this.arms.getChild("left_shoulder");
		this.left_arm = this.left_shoulder.getChild("left_arm");
		this.left_forearm = this.left_arm.getChild("left_forearm");
		this.left_MARM = this.left_shoulder.getChild("left_MARM");
		this.left_foreMARM = this.left_MARM.getChild("left_foreMARM");
		this.left_cork = this.left_foreMARM.getChild("left_cork");
		this.spike = this.left_shoulder.getChild("spike");
		this.spike2 = this.left_shoulder.getChild("spike2");
		this.spike3 = this.left_shoulder.getChild("spike3");
		this.spike6 = this.left_shoulder.getChild("spike6");
		this.head = this.upper_torso.getChild("head");
		this.jaw = this.head.getChild("jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Acupuncturer = partdefinition.addOrReplaceChild("Acupuncturer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = Acupuncturer.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(22, 82).addBox(-2.0F, -0.125F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -11.625F, 0.0F, -0.0872F, -0.0046F, -0.0346F));

		PartDefinition left_foot = left_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(68, 47).addBox(-2.0F, -0.5F, 0.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 5.125F, -2.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(36, 82).addBox(-1.0F, -0.125F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -11.625F, 0.0F, -0.1308F, 0.0046F, 0.0346F));

		PartDefinition right_foot = right_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(8, 73).addBox(-0.9886F, 0.23F, -2.095F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 4.125F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition waist = Acupuncturer.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(0, 67).addBox(-3.5F, -1.3333F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.25F))
		.texOffs(22, 49).addBox(-3.5F, -1.3333F, -2.0F, 7.0F, 10.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(76, 58).addBox(-3.0F, -4.0833F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.25F))
		.texOffs(80, 41).addBox(-3.0F, -4.0833F, -1.6F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -11.9167F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition upper_torso = waist.addOrReplaceChild("upper_torso", CubeListBuilder.create().texOffs(44, 49).addBox(-4.0F, -6.9167F, -3.6524F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.1667F, 1.6524F));

		PartDefinition cube_r1 = upper_torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(26, 16).addBox(-4.5F, -4.0F, -2.0F, 9.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.0F, -2.0F, 0.2637F, 0.177F, 0.183F));

		PartDefinition cube_r2 = upper_torso.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 84).addBox(-2.0F, 2.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.6667F, 0.0976F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition cube_r3 = upper_torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 31).addBox(0.0F, -5.0F, 0.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.6667F, -0.4024F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition cube_r4 = upper_torso.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 42).addBox(-2.0F, -4.0F, -2.0F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.9167F, -2.9024F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition cube_r5 = upper_torso.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 0).addBox(-2.5F, -3.5F, -2.0F, 5.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.4167F, -2.9024F, 0.2182F, -0.1745F, 0.2182F));

		PartDefinition arms = upper_torso.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.9167F, -1.6524F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_shoulder = arms.addOrReplaceChild("right_shoulder", CubeListBuilder.create(), PartPose.offset(-0.5F, 21.0F, 0.0F));

		PartDefinition cube_r6 = right_shoulder.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 56).addBox(-3.0F, -3.0F, -2.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -21.0F, -1.5F, 0.2182F, 0.1309F, 0.0F));

		PartDefinition cube_r7 = right_shoulder.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(58, 23).addBox(-5.0F, -3.5F, -2.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, -21.5F, 1.25F, -0.1787F, -0.2148F, 0.0385F));

		PartDefinition right_arm = right_shoulder.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(76, 82).addBox(-1.25F, -1.25F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.75F, -20.25F, 0.0F, 0.2617F, -0.0038F, 0.0435F));

		PartDefinition right_forearm = right_arm.addOrReplaceChild("right_forearm", CubeListBuilder.create().texOffs(50, 82).addBox(-1.5F, 0.0F, -2.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.25F, 4.65F, 1.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition right_MARM = right_shoulder.addOrReplaceChild("right_MARM", CubeListBuilder.create().texOffs(76, 64).addBox(-2.0F, -1.6667F, -2.4167F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 63).addBox(-1.5F, -17.6667F, -1.9167F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -24.3333F, -0.5833F, 0.6011F, 0.1001F, -0.1942F));

		PartDefinition right_foreMARM = right_MARM.addOrReplaceChild("right_foreMARM", CubeListBuilder.create().texOffs(44, 60).addBox(-1.0F, -18.0F, -1.75F, 2.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.6667F, -0.1667F, 2.0508F, 0.0F, 0.0F));

		PartDefinition right_cork = right_foreMARM.addOrReplaceChild("right_cork", CubeListBuilder.create().texOffs(76, 72).addBox(-1.5F, -4.5F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, -0.25F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r8 = right_cork.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(98, 97).addBox(0.0F, -8.0F, -14.0F, 0.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition spike4 = right_shoulder.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(88, 31).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(62, 82).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -24.0F, -1.5F, -1.4622F, -1.0218F, 1.4214F));

		PartDefinition cube_r9 = spike4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(62, 82).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike5 = right_shoulder.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(88, 36).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 88).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -23.0F, 0.5F, -2.4658F, -1.0218F, 1.4214F));

		PartDefinition cube_r10 = spike5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(74, 88).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike7 = right_shoulder.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(62, 88).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 82).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -22.0F, 1.5F, -2.3842F, -0.7891F, 0.723F));

		PartDefinition cube_r11 = spike7.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(88, 82).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike8 = right_shoulder.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(66, 88).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 90).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -21.0F, -2.5F, 2.0679F, -0.8125F, 2.0014F));

		PartDefinition cube_r12 = spike8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(8, 90).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition left_shoulder = arms.addOrReplaceChild("left_shoulder", CubeListBuilder.create(), PartPose.offset(0.0F, 21.0F, 0.0F));

		PartDefinition cube_r13 = left_shoulder.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(32, 34).addBox(-2.0F, -4.5F, -4.0F, 6.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -21.25F, 1.0F, -0.2706F, 0.1615F, -0.0541F));

		PartDefinition cube_r14 = left_shoulder.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, -3.5F, -2.5F, 6.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -20.5F, -0.5F, 0.2575F, 0.1691F, -0.2865F));

		PartDefinition left_arm = left_shoulder.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(64, 79).addBox(-1.75F, -1.25F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.25F, -20.25F, 0.0F, 0.2616F, 0.0113F, -0.0421F));

		PartDefinition left_forearm = left_arm.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(82, 47).addBox(-1.5F, 0.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.25F, 4.75F, 1.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition left_MARM = left_shoulder.addOrReplaceChild("left_MARM", CubeListBuilder.create().texOffs(76, 64).addBox(-2.0F, -1.6667F, -2.4167F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 63).addBox(-1.5F, -17.6667F, -1.9167F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -24.3333F, -0.5833F, 0.8193F, -0.1001F, 0.1942F));

		PartDefinition left_foreMARM = left_MARM.addOrReplaceChild("left_foreMARM", CubeListBuilder.create().texOffs(44, 60).addBox(-1.0F, -18.0F, -1.75F, 2.0F, 19.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.6667F, -0.1667F, 1.5272F, 0.0F, 0.0F));

		PartDefinition left_cork = left_foreMARM.addOrReplaceChild("left_cork", CubeListBuilder.create().texOffs(76, 72).addBox(-1.5F, -4.5F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, -0.25F, 1.4399F, 0.0F, 0.0F));

		PartDefinition cube_r15 = left_cork.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(98, 97).addBox(0.0F, -8.0F, -14.5F, 0.0F, 16.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.5F, -1.5708F, 0.0F, 0.0F));

		PartDefinition spike = left_shoulder.addOrReplaceChild("spike", CubeListBuilder.create().texOffs(20, 30).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(56, 23).addBox(-0.5F, -6.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -21.0F, 0.5F, -0.6545F, 0.0F, 1.5708F));

		PartDefinition cube_r16 = spike.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(56, 23).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike2 = left_shoulder.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(70, 88).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 30).addBox(-0.5F, -6.5F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -20.0F, -1.5F, 0.1186F, -0.1284F, 1.9559F));

		PartDefinition cube_r17 = spike2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(24, 30).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike3 = left_shoulder.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(84, 15).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 67).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -23.0F, 1.5F, -0.5307F, -0.1064F, 1.1073F));

		PartDefinition cube_r18 = spike3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(42, 67).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition spike6 = left_shoulder.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(88, 15).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(42, 71).addBox(-0.5F, -7.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -25.0F, -1.5F, -1.2877F, -1.0218F, 1.4214F));

		PartDefinition cube_r19 = spike6.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(42, 71).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition head = upper_torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.989F, -8.6612F, -7.7671F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(22, 42).addBox(0.011F, -1.6612F, -9.7671F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(56, 34).addBox(-2.989F, -0.6612F, -7.7671F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -9.0F, -2.0F));

		PartDefinition cube_r20 = head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(26, 26).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.989F, -6.6612F, -7.7671F, -0.3491F, 0.0F, 0.2618F));

		PartDefinition cube_r21 = head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(64, 11).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.011F, -5.6612F, 0.7329F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r22 = head.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(64, 11).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.011F, -4.6612F, 0.7329F, -0.0433F, -0.0057F, -0.1308F));

		PartDefinition cube_r23 = head.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.989F, -8.6612F, -1.7671F, -0.2586F, 0.155F, 0.6499F));

		PartDefinition cube_r24 = head.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.989F, -8.6612F, -1.7671F, -0.2618F, 0.0F, 0.9163F));

		PartDefinition cube_r25 = head.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(26, 26).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.989F, -4.6612F, -7.7671F, 0.1278F, 0.0283F, -0.2164F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(56, 16).addBox(-4.0F, 1.0F, -8.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F))
		.texOffs(100, 0).addBox(-4.0F, 0.0F, -8.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F))
		.texOffs(0, 30).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(1.011F, -1.6612F, 0.2329F, 0.3054F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val1 = Mth.sin(ageInTicks/8)/10;
		float val2 = Mth.sin(ageInTicks/6)/8;
		if (entity.attackAnim > 0) {
			float f1 = -1.0F + Mth.abs(10 - 2 * entity.attackAnim) / 6.5F;
			animateTentacleX(left_MARM,Mth.sin(f1) * 2.0F);
			animateTentacleX(left_foreMARM,-Mth.sin(f1) *3.0F);
			animateTentacleX(right_MARM,Mth.sin(f1) * 2.0F);
			animateTentacleX(right_foreMARM,-Mth.sin(f1) * 3.0F);
		}
		else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.right_arm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.right_arm.zRot = 0;
			animateTentacleX(right_MARM,val1);
			animateTentacleX(right_foreMARM,-val1);
			animateTentacleX(right_cork,-val2);

			this.left_arm.xRot = Mth.sin(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.left_arm.zRot = 0;
			animateTentacleX(left_MARM,val1);
			animateTentacleX(left_foreMARM,-val1);
			animateTentacleX(left_cork,-val2);
		}
		else {
			animateTentacleX(left_cork,val2);
			animateTentacleX(left_foreMARM,-val1);
			animateTentacleX(left_MARM,-val2);
			this.left_arm.zRot = -val1;

			animateTentacleX(right_cork,-val2);
			animateTentacleX(right_foreMARM,val1);
			animateTentacleX(right_MARM,val2);
			this.right_arm.zRot = val1;
		}

		this.left_leg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.left_foot.xRot = left_leg.xRot < 0 ? -left_leg.xRot : 0;
		this.right_foot.xRot = right_leg.xRot < 0 ? -right_leg.xRot : 0;
		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
		animateSpike(entity,spike,ageInTicks,6);
		animateSpike(entity,spike2,-ageInTicks,7);
		animateSpike(entity,spike3,ageInTicks,8);
		animateSpike(entity,spike4,-ageInTicks,9);
		animateSpike(entity,spike5,ageInTicks,5);
		animateSpike(entity,spike6,-ageInTicks,6);
		animateSpike(entity,spike7,ageInTicks,7);
		animateSpike(entity,spike8,-ageInTicks,8);
	}
	private void animateSpike(T entity ,ModelPart part,float value,int val){
		part.yScale = entity.hurtTime > 0 ? 2 : 1 + Mth.sin(value/7)/val;
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Acupuncturer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}