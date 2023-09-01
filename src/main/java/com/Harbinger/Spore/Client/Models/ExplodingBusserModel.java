package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
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

public class ExplodingBusserModel<T extends Busser> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "explodingbussermodel"), "main");
	private final ModelPart busser;

	public ExplodingBusserModel(ModelPart root) {
		this.busser = root.getChild("busser");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition busser = partdefinition.addOrReplaceChild("busser", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, -4.0F));

		PartDefinition Tail = busser.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, 0.0F, -1.75F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition tailTumor = Tail.addOrReplaceChild("tailTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition TailTumor_r1 = tailTumor.addOrReplaceChild("TailTumor_r1", CubeListBuilder.create().texOffs(5, 68).addBox(0.5F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.2F, 2.5F, 0.1966F, 0.4407F, 0.4369F));

		PartDefinition TailTumor_r2 = tailTumor.addOrReplaceChild("TailTumor_r2", CubeListBuilder.create().texOffs(7, 69).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, -1.0F, -0.5841F, 0.5692F, -0.4181F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(52, 0).addBox(-2.5F, 0.0F, -1.25F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition TailTumor_r3 = Tail2.addOrReplaceChild("TailTumor_r3", CubeListBuilder.create().texOffs(6, 69).addBox(-3.9F, -0.9F, -4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 2.7F, 1.5F, 0.3274F, 0.6801F, 0.1412F));

		PartDefinition Tail3 = Tail2.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(52, 0).addBox(-2.499F, 0.0F, -1.25F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition Tail4 = Tail3.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(52, 0).addBox(-1.5F, 0.0F, -1.25F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Payload = Tail4.addOrReplaceChild("Payload", CubeListBuilder.create(), PartPose.offset(0.5F, 6.0F, 0.0F));

		PartDefinition PayloadTumor_r1 = Payload.addOrReplaceChild("PayloadTumor_r1", CubeListBuilder.create().texOffs(5, 68).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.1461F, -2.9007F, 2.969F, -1.2401F, 0.9768F, -0.2677F));

		PartDefinition PayloadTumor_r2 = Payload.addOrReplaceChild("PayloadTumor_r2", CubeListBuilder.create().texOffs(5, 68).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.9964F, -2.5165F, -1.6017F, -1.4297F, 0.926F, -0.4669F));

		PartDefinition PayloadTumor_r3 = Payload.addOrReplaceChild("PayloadTumor_r3", CubeListBuilder.create().texOffs(5, 67).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.3256F, 0.3451F, 0.9507F, -0.6565F, 0.5975F, -0.0604F));

		PartDefinition PayloadTumor_r4 = Payload.addOrReplaceChild("PayloadTumor_r4", CubeListBuilder.create().texOffs(5, 67).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.2527F, -2.0338F, 1.7426F, -0.8282F, 0.6479F, 0.394F));

		PartDefinition PayloadTumor_r5 = Payload.addOrReplaceChild("PayloadTumor_r5", CubeListBuilder.create().texOffs(5, 67).addBox(-2.1F, -2.3F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.5F, -0.5F, 1.5F, -0.3369F, -0.1841F, -0.2906F));

		PartDefinition claws = Tail.addOrReplaceChild("claws", CubeListBuilder.create().texOffs(96, -6).addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition claws2 = Tail.addOrReplaceChild("claws2", CubeListBuilder.create().texOffs(114, -7).addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower5 = Tail.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 2.25F, 0.0F, -1.309F, -0.3491F, 0.0F));

		PartDefinition cube_r1 = flower5.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(74, 6).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = flower5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(74, 6).addBox(-3.8F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.389F, -2.0719F, 2.0F, 0.0F, -0.4363F, -0.3927F));

		PartDefinition cube_r3 = flower5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.2F, 0.7F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = flower5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head = busser.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.01F))
		.texOffs(18, 35).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(38, 37).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.0F, -3.0F));

		PartDefinition HeadTumor_r1 = head.addOrReplaceChild("HeadTumor_r1", CubeListBuilder.create().texOffs(5, 70).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.159F, -7.1507F, 2.3093F, 0.1276F, -0.5576F, -0.6808F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(40, 26).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -5.75F, -3.0F, 0.6981F, 0.0F, 0.4363F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(74, 6).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(74, 6).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.25F, -5.75F, 1.0F, -0.1309F, 0.0F, -0.5672F));

		PartDefinition cube_r9 = flower3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(74, 6).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r10 = flower3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(74, 6).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = head.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -6.75F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r13 = flower4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(74, 6).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r14 = flower4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(74, 6).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r15 = flower4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RightArm = busser.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(57, 9).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 32).addBox(-1.5F, 2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(-1.0F, -1.0F, 1.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -23.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.5F, 6.75F, 0.0F));

		PartDefinition MiddleRightWing_r1 = RightForArm.addOrReplaceChild("MiddleRightWing_r1", CubeListBuilder.create().texOffs(46, 36).addBox(0.01F, -5.0F, -0.25F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r17 = RightForArm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(22, 14).addBox(0.0F, 0.0F, 0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightHand = RightForArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(34, 60).addBox(0.0F, -0.25F, -0.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(-1.0F, 5.75F, 0.0F));

		PartDefinition cube_r18 = RightHand.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(30, 60).addBox(0.0F, 0.0F, -1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r19 = RightHand.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(8, 53).addBox(0.0F, 0.0F, -0.25F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition BottomRightWing_r1 = RightHand.addOrReplaceChild("BottomRightWing_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.5F, -4.0F, -5.0F, 0.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm = busser.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(59, 40).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 32).addBox(-0.5F, 2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 29).addBox(1.0F, -1.0F, 1.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -23.0F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.5F, 6.75F, 0.0F));

		PartDefinition MiddleLeftWing_r1 = LeftForArm.addOrReplaceChild("MiddleLeftWing_r1", CubeListBuilder.create().texOffs(46, 36).addBox(1.01F, -5.0F, -0.25F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r20 = LeftForArm.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 14).addBox(0.0F, 0.0F, 0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftHand = LeftForArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(34, 60).addBox(0.0F, -0.25F, -0.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 5.75F, 0.0F));

		PartDefinition cube_r21 = LeftHand.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(30, 60).addBox(0.0F, 0.0F, -1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r22 = LeftHand.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(8, 53).addBox(0.0F, 0.0F, -0.25F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition BottomLeftWing_r1 = LeftHand.addOrReplaceChild("BottomLeftWing_r1", CubeListBuilder.create().texOffs(0, 3).addBox(0.5F, -4.0F, -5.0F, 0.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition body = busser.addOrReplaceChild("body", CubeListBuilder.create().texOffs(50, 19).addBox(-3.0F, 10.0F, -1.75F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -25.0F, 2.0F));

		PartDefinition SpineRidge_r1 = body.addOrReplaceChild("SpineRidge_r1", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -1.0F, 0.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(28, 42).addBox(-2.0F, -2.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F))
		.texOffs(22, 26).addBox(-3.0F, -4.5F, -5.2F, 6.0F, 3.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back = spine.addOrReplaceChild("back", CubeListBuilder.create().texOffs(8, 56).addBox(0.0F, -4.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back2 = spine.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(54, 46).addBox(-1.0F, -4.0F, -2.25F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(22, 14).addBox(-4.0F, -5.5F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back3 = spine2.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(44, 10).addBox(0.0F, -4.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back4 = spine2.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(0, 44).addBox(-3.0F, -4.0F, -2.25F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition BodyTumors = body.addOrReplaceChild("BodyTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition Tumor_r1 = BodyTumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(4, 68).addBox(-1.0F, 2.0F, -7.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(2, 66).addBox(-3.0F, -3.0F, -6.6F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.0F, 1.0F, 4.0F, -0.4363F, -0.48F, 0.0F));

		PartDefinition flower = body.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 2.25F, 0.0F, -1.1345F, -0.3491F, 0.1309F));

		PartDefinition cube_r23 = flower.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(74, 6).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r24 = flower.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(74, 6).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r25 = flower.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r26 = flower.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.busser.getChild("RightArm").xScale = 1.65f;
		this.busser.getChild("LeftArm").xScale = 1.65f;
		this.busser.getChild("RightArm").yScale = 1.65f;
		this.busser.getChild("LeftArm").yScale = 1.65f;
		this.busser.getChild("RightArm").zScale = 1.65f;
		this.busser.getChild("LeftArm").zScale = 1.65f;

		if (entity.onGround() || entity.isInFluidType()){
			this.busser.getChild("Tail").yRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.busser.getChild("Tail").getChild("Tail2").yRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").yRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").yRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;

			this.busser.getChild("Tail").xRot = 0.4F;
			this.busser.getChild("Tail").getChild("Tail2").xRot = 0.4F;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").xRot = 0.4F;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").xRot = 0.4F;

			this.busser.getChild("RightArm").zRot =  Mth.sin(ageInTicks/5)/6;
			this.busser.getChild("LeftArm").zRot =  - Mth.sin(ageInTicks/5)/6;
			if (Mth.sin(ageInTicks/3) < 0){
				this.busser.getChild("RightArm").getChild("RightForArm").zRot = Mth.sin(ageInTicks/3)/7;}
			if (Mth.sin(ageInTicks/3) < 0){
				this.busser.getChild("LeftArm").getChild("LeftForArm").zRot = -Mth.sin(ageInTicks/3)/7;}
		}else{
			this.busser.getChild("Tail").yRot = 0;
			this.busser.getChild("Tail").getChild("Tail2").yRot = 0;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").yRot = 0;
			this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").yRot = 0;

			this.busser.getChild("RightArm").zRot = 1.1f + Mth.sin(ageInTicks/3);
			this.busser.getChild("LeftArm").zRot = -1.1f - Mth.sin(ageInTicks/3);
			if (Mth.sin(ageInTicks/3) < 0){
				this.busser.getChild("RightArm").getChild("RightForArm").zRot = Mth.sin(ageInTicks/3)/2;}
			if (Mth.sin(ageInTicks/3) < 0){
				this.busser.getChild("LeftArm").getChild("LeftForArm").zRot = -Mth.sin(ageInTicks/3)/2;}

			if (entity.isVehicle()){
				this.busser.getChild("Tail").xRot = 0;
				this.busser.getChild("Tail").getChild("Tail2").xRot = 0;
				this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").xRot = 0;
				this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
			}else {
				this.busser.getChild("Tail").xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
				this.busser.getChild("Tail").getChild("Tail2").xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
				this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
				this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
			}
		}

		this.busser.getChild("head").xRot = headPitch / (90F / (float) Math.PI);
		this.busser.getChild("head").getChild("jaw").xRot = Mth.sin(ageInTicks / 8) / 10;

		this.busser.getChild("Tail").getChild("claws").xRot = Mth.sin(ageInTicks/4)/3;
		this.busser.getChild("Tail").getChild("claws2").xRot = Mth.sin(ageInTicks/4)/2;

		this.busser.getChild("body").getChild("BodyTumors").xScale = 1 + Mth.sin(ageInTicks / 6) / 5;
		this.busser.getChild("body").getChild("BodyTumors").yScale = 1 - Mth.sin(ageInTicks / 7) / 7;
		this.busser.getChild("body").getChild("BodyTumors").zScale = 1 + Mth.sin(ageInTicks / 6) / 8;

		this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Payload").xScale = 1 + Mth.sin(ageInTicks / 5) / 4;
		this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Payload").yScale = 1 + Mth.sin(ageInTicks / 6) / 7;
		this.busser.getChild("Tail").getChild("Tail2").getChild("Tail3").getChild("Tail4").getChild("Payload").zScale = 1 + Mth.sin(ageInTicks / 6) / 5;

		this.busser.getChild("Tail").getChild("tailTumor").xScale = 1 - Mth.sin(ageInTicks / 6) / 5;
		this.busser.getChild("Tail").getChild("tailTumor").yScale = 1 + Mth.sin(ageInTicks / 6) / 5;
		this.busser.getChild("Tail").getChild("tailTumor").zScale = 1 - Mth.sin(ageInTicks / 6) / 5;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		busser.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}