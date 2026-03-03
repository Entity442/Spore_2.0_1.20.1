package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Leaper;
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

public class LeaperModel<T extends Leaper> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "leapermodel"), "main");
	private final ModelPart Leaper;
	private final ModelPart hips;
	private final ModelPart waist;
	private final ModelPart upper_torso;
	private final ModelPart left_arm;
	private final ModelPart left_forearm;
	private final ModelPart left_claws;
	private final ModelPart right_arm;
	private final ModelPart right_forearm;
	private final ModelPart right_claws;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart flower;
	private final ModelPart flower2;
	private final ModelPart fungus;
	private final ModelPart legs;
	private final ModelPart left_leg;
	private final ModelPart left_foot;
	private final ModelPart right_leg;
	private final ModelPart right_foot;

	public LeaperModel(ModelPart root) {
		this.Leaper = root.getChild("Leaper");
		this.hips = this.Leaper.getChild("hips");
		this.waist = this.hips.getChild("waist");
		this.upper_torso = this.waist.getChild("upper_torso");
		this.left_arm = this.upper_torso.getChild("left_arm");
		this.left_forearm = this.left_arm.getChild("left_forearm");
		this.left_claws = this.left_forearm.getChild("left_claws");
		this.right_arm = this.upper_torso.getChild("right_arm");
		this.right_forearm = this.right_arm.getChild("right_forearm");
		this.right_claws = this.right_forearm.getChild("right_claws");
		this.head = this.upper_torso.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.flower = this.head.getChild("flower");
		this.flower2 = this.flower.getChild("flower2");
		this.fungus = this.head.getChild("fungus");
		this.legs = this.hips.getChild("legs");
		this.left_leg = this.legs.getChild("left_leg");
		this.left_foot = this.left_leg.getChild("left_foot");
		this.right_leg = this.legs.getChild("right_leg");
		this.right_foot = this.right_leg.getChild("right_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Leaper = partdefinition.addOrReplaceChild("Leaper", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition hips = Leaper.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(32, 17).addBox(-5.0F, 0.0F, -3.5F, 10.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, 1.0F));

		PartDefinition cube_r1 = hips.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 25).addBox(-3.0F, 0.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7F, -3.4F, -0.3046F, 0.0022F, 0.0904F));

		PartDefinition waist = hips.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(22, 36).addBox(-4.5F, -6.0F, -4.0F, 9.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 91).addBox(-1.5F, -6.0F, -4.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = waist.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(92, 37).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition upper_torso = waist.addOrReplaceChild("upper_torso", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -7.0F, -5.0F, 10.0F, 7.0F, 6.0F, new CubeDeformation(0.5F))
		.texOffs(48, 84).addBox(2.75F, -4.0F, 0.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 89).addBox(1.25F, -2.0F, 0.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r3 = upper_torso.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(104, 100).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4862F, -0.6654F, 0.8868F, -2.5659F, -0.0699F, 3.0399F));

		PartDefinition cube_r4 = upper_torso.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(110, 116).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0007F, -4.9203F, 2.8423F, -2.0109F, -0.927F, 2.0465F));

		PartDefinition cube_r5 = upper_torso.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(110, 116).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0007F, 0.0797F, -5.7577F, 2.006F, -1.2248F, -2.279F));

		PartDefinition cube_r6 = upper_torso.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(110, 116).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9993F, -4.9203F, -6.2577F, 0.2979F, 0.4929F, 0.364F));

		PartDefinition cube_r7 = upper_torso.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(78, 75).addBox(0.5F, 0.0F, -4.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, -4.0F, 0.3905F, 0.0545F, -0.4934F));

		PartDefinition cube_r8 = upper_torso.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 88).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 3.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r9 = upper_torso.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 93).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r10 = upper_torso.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(84, 87).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.6109F, -0.48F, 0.0F));

		PartDefinition cube_r11 = upper_torso.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(78, 6).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 1.0F, 0.6109F, -0.48F, 0.0F));

		PartDefinition cube_r12 = upper_torso.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(84, 0).addBox(-2.5F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0F, 0.5F, 0.2883F, 0.1298F, -0.132F));

		PartDefinition cube_r13 = upper_torso.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(72, 87).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.0F, 1.5F, 0.2883F, 0.1298F, -0.132F));

		PartDefinition cube_r14 = upper_torso.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 63).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 1.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r15 = upper_torso.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(16, 87).addBox(-3.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(4.25F, -3.5F, -4.5F, -0.104F, -0.0663F, -0.1313F));

		PartDefinition cube_r16 = upper_torso.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(32, 84).addBox(-1.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.25F, -3.5F, -4.5F, -0.104F, 0.0663F, 0.1313F));

		PartDefinition cube_r17 = upper_torso.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(3, 20).addBox(-3.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-5.0F, -6.0F, -1.5F, 0.0F, 0.0F, -0.0873F));

		PartDefinition cube_r18 = upper_torso.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(3, 20).addBox(-3.5F, -1.5F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(5.0F, -6.0F, -1.5F, 0.0F, 0.0F, 0.0873F));

		PartDefinition left_arm = upper_torso.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(0, 63).addBox(0.125F, -0.75F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 79).addBox(0.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.125F, -5.25F, -2.25F, -0.48F, 0.0F, -0.1309F));

		PartDefinition cube_r19 = left_arm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(104, 100).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9813F, 5.2417F, 0.0271F, 0.3054F, -0.6545F, -0.2182F));

		PartDefinition cube_r20 = left_arm.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(104, 100).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7813F, 6.8417F, 0.0271F, 0.3054F, 0.0F, 0.3054F));

		PartDefinition left_forearm = left_arm.addOrReplaceChild("left_forearm", CubeListBuilder.create().texOffs(0, 77).addBox(-1.875F, 0.25F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(2.0F, 8.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition left_claws = left_forearm.addOrReplaceChild("left_claws", CubeListBuilder.create().texOffs(6, 88).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 88).addBox(-2.5F, -1.0F, 1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(2.375F, 6.75F, 0.0F));

		PartDefinition right_arm = upper_torso.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 63).addBox(-4.125F, -0.75F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(-0.25F))
		.texOffs(78, 79).addBox(-4.125F, -0.75F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.125F, -5.25F, -2.25F, -0.4363F, 0.0F, 0.1309F));

		PartDefinition right_forearm = right_arm.addOrReplaceChild("right_forearm", CubeListBuilder.create().texOffs(0, 77).addBox(-2.125F, 0.25F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.0F, 8.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition right_claws = right_forearm.addOrReplaceChild("right_claws", CubeListBuilder.create().texOffs(56, 89).addBox(-2.5F, -1.0F, 1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(56, 89).addBox(-2.5F, -1.0F, -1.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.375F, 6.75F, 0.0F));

		PartDefinition head = upper_torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(48, 45).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(40, 91).addBox(-1.0F, -3.0F, -9.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -1.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(40, 64).addBox(-3.5F, 0.0F, -6.5F, 7.0F, 1.0F, 5.0F, new CubeDeformation(0.25F))
		.texOffs(76, 52).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 38).addBox(-4.0F, 1.0F, -7.0F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -6.0F, -4.75F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r21 = flower.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(110, 116).addBox(-6.6073F, -2.8145F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r22 = flower.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(108, 122).addBox(-3.484F, -2.617F, -7.084F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r23 = flower.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(108, 122).addBox(-3.484F, -2.617F, 1.084F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = flower.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.0F, 2.0F, 0.2182F, 0.0F, -0.3927F));

		PartDefinition cube_r24 = flower2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(104, 100).addBox(2.3057F, -1.6184F, -3.4729F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r25 = flower2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(104, 100).addBox(-7.514F, -2.7747F, -3.4729F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r26 = flower2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(102, 108).addBox(-3.4892F, -2.3983F, -8.4229F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r27 = flower2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(110, 116).addBox(2.3057F, -1.6184F, -2.4729F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r28 = flower2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(102, 108).addBox(-3.4892F, -1.9949F, 1.3968F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition fungus = head.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(110, 116).addBox(-6.0F, -34.7F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 28.0F, 2.25F));

		PartDefinition cube_r29 = fungus.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(110, 116).addBox(5.75F, -30.75F, -3.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.228F, 0.1298F, -0.3342F));

		PartDefinition cube_r30 = fungus.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(110, 116).addBox(-4.0F, -34.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.2618F, 0.0F, 0.1745F));

		PartDefinition cube_r31 = fungus.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(110, 116).addBox(-4.0F, -32.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r32 = fungus.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(110, 116).addBox(-6.0F, -35.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition legs = hips.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -1.0F));

		PartDefinition left_leg = legs.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 46).addBox(-2.9F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-0.25F))
		.texOffs(24, 46).addBox(-3.25F, -2.75F, -2.65F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.1F, 1.0F, 0.0F, -0.2164F, -0.052F, -0.0332F));

		PartDefinition left_foot = left_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(24, 29).addBox(-2.9F, -2.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition right_leg = legs.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(32, 0).addBox(-3.1F, -1.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(-0.25F))
		.texOffs(48, 25).addBox(-2.75F, -2.75F, -2.65F, 6.0F, 7.0F, 6.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-3.1F, 1.0F, 0.0F, -0.2164F, 0.052F, 0.0332F));

		PartDefinition right_foot = right_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 29).addBox(-3.1F, -2.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r33 = right_foot.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(110, 116).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9007F, 4.0796F, -3.1577F, 2.4249F, -1.2248F, -2.279F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			float armMov = -90F + Mth.sin(ageInTicks/10)/10;
			animateTentacleX(right_arm,armMov);
			animateTentacleX(left_arm,armMov);
			if (entity.swinging){
				float f = 0;
				f++;
				animateTentacleX(right_arm,-89.5F + f);
				animateTentacleX(left_arm,-89.5F + f);

			}
		}else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			float armMov = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			animateTentacleX(right_arm,armMov);
			animateTentacleX(left_arm,-armMov);
		}else {
			float armMov = Mth.sin(ageInTicks/8)/10;
			animateTentacleX(right_arm,armMov);
			animateTentacleX(left_arm,-armMov);
		}
		float legMoV = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		animateTentacleX(left_leg,legMoV);
		animateTentacleX(right_leg,-legMoV);
		animateTentacleX(jaw,Mth.sin(ageInTicks/8)/10);
		animateTentacleX(head,headPitch /  ( 90F / (float) Math.PI));
		animateTentacleY(head,netHeadYaw / (180F / (float) Math.PI));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Leaper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}