package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Brute;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class BruteModel<T extends Brute> extends EntityModel<T> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "brutemodel"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart tail;
	private final ModelPart RightArmA;
	private final ModelPart LeftArmA;

	public BruteModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.tail = root.getChild("tail");
		this.RightArmA = root.getChild("RightArmA");
		this.LeftArmA = root.getChild("LeftArmA");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(44, 39).addBox(-3.5F, 2.0F, -7.5F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 23).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(27, 19).addBox(-4.0F, 2.0F, -2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(40, 5).addBox(-3.5F, 2.0F, -7.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(16, 39).addBox(3.5F, 2.0F, -7.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, -5.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(70, 33).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(34, 11).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, 3.0F, -2.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -6.75F, -2.0F, -0.6545F, 0.0F, -0.48F));

		PartDefinition cube_r1 = flower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = flower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = flower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r4 = flower.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -4.75F, -8.0F, 0.2182F, 0.0F, 0.4363F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -4.75F, -9.0F, 0.3491F, 0.1309F, -0.4363F));

		PartDefinition cube_r9 = flower3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r10 = flower3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower8 = head.addOrReplaceChild("flower8", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -0.75F, -7.0F, 0.829F, -0.0436F, -0.4363F));

		PartDefinition cube_r13 = flower8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = flower8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r15 = flower8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r16 = flower8.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(30, 0).addBox(-3.5F, 9.0F, -3.0F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 17).addBox(-4.5F, -5.0F, -7.0F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 31).addBox(-4.0F, -4.5F, -3.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -7.0F, -4.0F, 10.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.25F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = body.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 1.25F, 4.0F, -1.1781F, -0.48F, 0.1309F));

		PartDefinition cube_r18 = flower4.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r19 = flower4.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flower4.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r21 = flower4.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower5 = body.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -2.75F, 0.0F, -0.6545F, 0.0F, -0.48F));

		PartDefinition cube_r22 = flower5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r23 = flower5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r24 = flower5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r25 = flower5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower6 = body.addOrReplaceChild("flower6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 4.25F, 4.0F, -1.4399F, -0.1309F, 0.0873F));

		PartDefinition cube_r26 = flower6.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r27 = flower6.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r28 = flower6.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r29 = flower6.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower7 = body.addOrReplaceChild("flower7", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 5.25F, 4.0F, -0.6545F, 0.0F, -0.48F));

		PartDefinition cube_r30 = flower7.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(87, 13).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0008F, -0.2654F, 16.75F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r31 = flower7.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, -7.1286F, 18.4679F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r32 = flower7.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(80, 7).addBox(-8.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 16.75F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r33 = flower7.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(81, 7).addBox(-1.0F, 0.0F, -19.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2492F, 4.7346F, 12.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(32, 50).addBox(-2.0F, -4.0F, -1.5F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightArm_r1 = RightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(10, 65).addBox(0.0F, -1.0F, -4.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.0F, -3.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r34 = RightForArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(60, 49).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r35 = RightForArm.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(56, 63).addBox(-2.0F, 0.25F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition cube_r36 = RightForArm.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(24, 65).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(18, 50).addBox(-1.0F, -4.0F, -1.5F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition RightArm_r2 = LeftArm.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(58, 35).addBox(0.0F, -1.0F, -4.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r37 = LeftForArm.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(46, 53).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r38 = LeftForArm.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 54).addBox(-1.0F, 0.25F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r39 = LeftForArm.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(58, 0).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(26, 39).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 7.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 44).addBox(-2.25F, -2.0F, 0.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.25F, 5.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(52, 19).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -0.5F, 6.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(44, 44).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition RightArmA = partdefinition.addOrReplaceChild("RightArmA", CubeListBuilder.create().texOffs(46, 67).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.0F, 7.0F, 5.0F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition RightForArm2 = RightArmA.addOrReplaceChild("RightForArm2", CubeListBuilder.create().texOffs(70, 12).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition RightHand = RightForArm2.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition Claw = RightForArm2.addOrReplaceChild("Claw", CubeListBuilder.create().texOffs(70, 60).addBox(-0.75F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(66, 25).addBox(0.5F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 1.0F));

		PartDefinition Claw2 = RightForArm2.addOrReplaceChild("Claw2", CubeListBuilder.create().texOffs(60, 25).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -1.0F));

		PartDefinition LeftArmA = partdefinition.addOrReplaceChild("LeftArmA", CubeListBuilder.create().texOffs(38, 65).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.0F, 7.0F, 5.0F, -0.2618F, 0.0F, 0.2618F));

		PartDefinition LeftForArm2 = LeftArmA.addOrReplaceChild("LeftForArm2", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition LeftHand = LeftForArm2.addOrReplaceChild("LeftHand", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition Claw3 = LeftForArm2.addOrReplaceChild("Claw3", CubeListBuilder.create().texOffs(0, 28).addBox(-0.75F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 14).addBox(0.5F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 1.0F));

		PartDefinition Claw4 = LeftForArm2.addOrReplaceChild("Claw4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
			this.tail.yRot = Mth.cos(limbSwing * 0.1f);
			this.tail.getChild("tail2").yRot = Mth.cos(limbSwing * 0.1f);
			this.tail.getChild("tail2").getChild("tail3").yRot = Mth.cos(limbSwing * 0.1f);
			this.tail.getChild("tail2").getChild("tail3").getChild("tail4").yRot = Mth.cos(limbSwing * 0.1f);
		}
		this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		if (RightArm.xRot > 0) {
			this.RightArm.getChild("RightForArm").xRot = -RightArm.xRot;
		}
		if (LeftArm.xRot > 0) {
			this.LeftArm.getChild("LeftForArm").xRot = -LeftArm.xRot;
		}

		this.tail.yRot = Mth.cos(ageInTicks/6)/6;
		this.tail.getChild("tail2").yRot = Mth.cos(ageInTicks/6)/6;
		this.tail.getChild("tail2").getChild("tail3").yRot = Mth.cos(ageInTicks/6)/6;
		this.tail.getChild("tail2").getChild("tail3").getChild("tail4").yRot = Mth.cos(ageInTicks/6)/6;
		this.head.getChild("jaw").xRot = Mth.sin(ageInTicks/8)/10;

		this.LeftArmA.xRot = 0.2f + Mth.sin(ageInTicks/6)/6;
		this.RightArmA.xRot = 0.2f - Mth.sin(ageInTicks/6)/6;
		this.LeftArmA.getChild("LeftForArm2").getChild("Claw3").xRot = -0.3f + Mth.sin(ageInTicks/6)/6;
		this.LeftArmA.getChild("LeftForArm2").getChild("Claw4").xRot = 0.3f + Mth.sin(ageInTicks/6)/6;
		this.RightArmA.getChild("RightForArm2").getChild("Claw").xRot = -0.3f + Mth.sin(ageInTicks/6)/6;
		this.RightArmA.getChild("RightForArm2").getChild("Claw2").xRot = 0.3f + Mth.sin(ageInTicks/6)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArmA.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArmA.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void translateToHand(HumanoidArm arm, PoseStack stack) {
		this.getArm(arm).translateAndRotate(stack);
	}

	private ModelPart getArm(HumanoidArm arm) {
		return arm == HumanoidArm.LEFT ? this.LeftArmA.getChild("LeftForArm2").getChild("LeftHand") : this.RightArmA.getChild("RightForArm2").getChild("RightHand");
	}
}