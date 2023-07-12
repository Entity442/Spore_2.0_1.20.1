package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.BiomassReformator;
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

public class BiomassReconstructorModel<T extends BiomassReformator> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "biomassreconstructor"), "main");
	private final ModelPart tumor;
	private final ModelPart jaw;
	private final ModelPart jaw2;
	private final ModelPart jaw3;
	private final ModelPart jaw4;
	private final ModelPart bb_main;

	public BiomassReconstructorModel(ModelPart root) {
		this.tumor = root.getChild("tumor");
		this.jaw = root.getChild("jaw");
		this.jaw2 = root.getChild("jaw2");
		this.jaw3 = root.getChild("jaw3");
		this.jaw4 = root.getChild("jaw4");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tumor = partdefinition.addOrReplaceChild("tumor", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(73, 70).addBox(-2.0F, -10.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = tumor.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r2 = tumor.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 68).addBox(0.0F, -13.25F, -1.75F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = tumor.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(66, 32).addBox(-2.25F, -14.25F, -0.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = tumor.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 69).addBox(-4.0F, -14.0F, -1.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r5 = tumor.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(44, 73).addBox(-2.5F, -13.0F, -3.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r6 = tumor.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(16, 66).addBox(-3.0F, -15.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0873F));

		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(43, 44).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 5.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r7 = jaw.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(52, 80).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r8 = jaw.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(56, 80).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint = jaw.addOrReplaceChild("joint", CubeListBuilder.create().texOffs(0, 57).addBox(-4.5F, -11.0F, -0.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r9 = joint.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(44, 80).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.0F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r10 = joint.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 80).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint2 = joint.addOrReplaceChild("joint2", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition cube_r11 = joint2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(59, 65).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 78).addBox(-3.5F, -3.5F, -0.05F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition flower = jaw.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -13.75F, -1.0F, -1.0472F, -0.2182F, 0.0F));

		PartDefinition cube_r12 = flower.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r13 = flower.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = flower.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r15 = flower.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = jaw.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.25F, -21.5F, -5.25F, -1.0472F, -0.2182F, 0.3054F));

		PartDefinition cube_r16 = flower3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r17 = flower3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r18 = flower3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = flower3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition jaw2 = partdefinition.addOrReplaceChild("jaw2", CubeListBuilder.create().texOffs(44, 32).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 24.0F, 0.0F, -0.5236F, -1.5708F, 0.0F));

		PartDefinition cube_r20 = jaw2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(72, 77).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition cube_r21 = jaw2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(76, 77).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition joint3 = jaw2.addOrReplaceChild("joint3", CubeListBuilder.create().texOffs(39, 56).addBox(-4.5F, -11.0F, -0.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r22 = joint3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(36, 75).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition cube_r23 = joint3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(40, 75).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.0F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition joint4 = joint3.addOrReplaceChild("joint4", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition cube_r24 = joint4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(65, 42).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(77, 59).addBox(-3.5F, -3.5F, -0.05F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition flower4 = jaw2.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -9.75F, 0.75F, -1.309F, -0.1745F, 0.48F));

		PartDefinition cube_r25 = flower4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r26 = flower4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r27 = flower4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r28 = flower4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower6 = jaw2.addOrReplaceChild("flower6", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.25F, -19.75F, -4.25F, -1.0472F, -0.0436F, -0.3054F));

		PartDefinition cube_r29 = flower6.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r30 = flower6.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r31 = flower6.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r32 = flower6.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition jaw3 = partdefinition.addOrReplaceChild("jaw3", CubeListBuilder.create().texOffs(22, 33).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 24.0F, 0.0F, -0.5236F, 1.5708F, 0.0F));

		PartDefinition cube_r33 = jaw3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(68, 72).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r34 = jaw3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(32, 75).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint5 = jaw3.addOrReplaceChild("joint5", CubeListBuilder.create().texOffs(20, 45).addBox(-4.5F, -11.0F, -0.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r35 = joint5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(60, 72).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.0F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r36 = joint5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(64, 72).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint6 = joint5.addOrReplaceChild("joint6", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition cube_r37 = joint6.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(59, 56).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(77, 51).addBox(-3.5F, -3.5F, -0.05F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition flower5 = jaw3.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.25F, -11.75F, 0.75F, -0.7418F, -0.4363F, 0.3927F));

		PartDefinition cube_r38 = flower5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r39 = flower5.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r40 = flower5.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r41 = flower5.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition jaw4 = partdefinition.addOrReplaceChild("jaw4", CubeListBuilder.create().texOffs(0, 33).addBox(-5.0F, -11.0F, 0.0F, 10.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, -5.0F, -0.5236F, 3.1416F, 0.0F));

		PartDefinition cube_r42 = jaw4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(24, 0).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r43 = jaw4.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(28, 0).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint7 = jaw4.addOrReplaceChild("joint7", CubeListBuilder.create().texOffs(0, 45).addBox(-4.5F, -11.0F, -0.5F, 9.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r44 = joint7.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(0, 19).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 0.0F, -0.5F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r45 = joint7.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(4, 19).addBox(0.0F, -11.0F, -2.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, -0.5F, 0.0F, 0.4363F, 0.0F));

		PartDefinition joint8 = joint7.addOrReplaceChild("joint8", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition cube_r46 = joint8.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(20, 57).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(16, 75).addBox(-3.5F, -3.5F, -0.05F, 7.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition flower2 = jaw4.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -12.75F, 0.0F, -0.7854F, 0.0F, 0.5236F));

		PartDefinition cube_r47 = flower2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(-5, 105).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r48 = flower2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(-5, 105).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r49 = flower2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(-5, 97).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r50 = flower2.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(-5, 89).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -0.01F, -16.0F, 32.0F, 0.0F, 32.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.tumor.xScale =1+ Mth.cos(ageInTicks/9)/6;
		this.tumor.zScale =1+ Mth.cos(ageInTicks/9)/6;
		this.tumor.yScale =1 -Mth.cos(ageInTicks/9)/6;
		
			this.jaw.xRot = -0.4f + Mth.cos(ageInTicks/8)/8;
			this.jaw4.xRot = -0.4f + Mth.cos(ageInTicks/8)/8;
			this.jaw2.xRot = -0.4f - Mth.cos(ageInTicks/8)/8;
			this.jaw3.xRot = -0.4f - Mth.cos(ageInTicks/8)/8;


	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tumor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}