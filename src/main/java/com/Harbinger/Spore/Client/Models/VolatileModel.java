package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Volatile;
import com.Harbinger.Spore.Sentities.Variants.SlasherVariants;
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

public class VolatileModel<T extends Volatile> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "volatilemodel"), "main");
	private final ModelPart body;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart head;
	private final ModelPart tumor1;
	private final ModelPart tumor3;

	public VolatileModel(ModelPart root) {
		this.body = root.getChild("body");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.head = root.getChild("head");
		this.tumor1 = root.getChild("tumor1");
		this.tumor3 = root.getChild("tumor3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(32, 35).addBox(-4.0F, 10.0F, -2.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -5.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 27).addBox(-5.0F, -4.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.0F, 1.0F, 0.2182F, 0.48F, -0.3927F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(53, 8).addBox(-6.0F, 4.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.0F, 1.0F, 0.3054F, 0.1309F, 0.1745F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(54, 35).addBox(-1.0F, -1.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.0F, 1.0F, 0.3054F, 0.3491F, -0.2182F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 86).addBox(2.0F, -3.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.2182F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 86).addBox(-7.0F, -3.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, -0.2182F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(32, 20).addBox(-3.5F, -7.5F, -2.5F, 8.0F, 9.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -6.25F, 1.0F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition dress = body.addOrReplaceChild("dress", CubeListBuilder.create(), PartPose.offset(0.0F, 11.0F, 0.0F));

		PartDefinition cube_r8 = dress.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 67).addBox(0.0365F, -1.0F, -4.0461F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 4.75F, 0.2182F, 1.1781F, 0.2618F));

		PartDefinition cube_r9 = dress.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(42, 72).addBox(-0.0365F, -1.0F, -4.0461F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 4.75F, 0.2182F, -1.1781F, -0.2618F));

		PartDefinition cube_r10 = dress.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(24, 46).addBox(-5.0F, 0.0F, -5.0F, 0.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.2182F));

		PartDefinition cube_r11 = dress.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(42, 46).addBox(5.0F, 0.0F, -5.0F, 0.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, -0.2182F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(76, 12).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.5F, -4.0F, -0.25F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(92, 13).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(-0.5F, 10.0F, 0.0F));

		PartDefinition finger = RightForArm.addOrReplaceChild("finger", CubeListBuilder.create().texOffs(32, 38).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(-3.0F, 0.0F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -0.5F));

		PartDefinition finger2 = RightForArm.addOrReplaceChild("finger2", CubeListBuilder.create().texOffs(32, 35).addBox(-2.0F, -1.0F, 1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 54).addBox(-3.0F, 0.0F, 2.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -1.0F));

		PartDefinition finger3 = RightForArm.addOrReplaceChild("finger3", CubeListBuilder.create().texOffs(30, 5).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 9.0F, -1.0F));

		PartDefinition tumor2 = RightForArm.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-1.0F, 3.0F, 1.25F));

		PartDefinition cube_r12 = tumor2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(72, 94).addBox(-11.0F, -26.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r13 = tumor2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(43, 95).addBox(2.0F, -19.0F, -25.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(74, 75).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(8.5F, -4.0F, -0.25F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(88, 0).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.5F, 10.0F, 0.0F));

		PartDefinition finger4 = LeftForArm.addOrReplaceChild("finger4", CubeListBuilder.create().texOffs(0, 15).addBox(0.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-1.0F, 0.0F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 9.0F, -0.5F));

		PartDefinition finger5 = LeftForArm.addOrReplaceChild("finger5", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, -1.0F, 1.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 26).addBox(-1.0F, 0.0F, 2.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 9.0F, -1.0F));

		PartDefinition finger6 = LeftForArm.addOrReplaceChild("finger6", CubeListBuilder.create().texOffs(0, 6).addBox(-1.0F, -1.0F, 0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -1.0F));

		PartDefinition tumor4 = LeftArm.addOrReplaceChild("tumor4", CubeListBuilder.create(), PartPose.offset(3.5F, -1.0F, 1.25F));

		PartDefinition cube_r14 = tumor4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(72, 62).addBox(-14.0F, -25.0F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(88, 34).addBox(-12.0F, -26.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r15 = tumor4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(89, 44).addBox(1.0F, -19.0F, -25.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(29, 87).addBox(-2.75F, -1.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.65F, 12.0F, 0.75F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(87, 67).addBox(-2.75F, 0.0F, -2.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(85, 86).addBox(-1.25F, -1.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.65F, 12.0F, 0.75F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(87, 54).addBox(-1.25F, 0.0F, -2.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(14, 80).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-4.0F, -14.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-4.0F, -6.25F, -6.75F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -9.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(6, 0).addBox(0.0F, -3.0F, -9.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(76, 28).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.05F, -3.0F, -0.4363F, 0.0F, 0.5236F));

		PartDefinition hat2 = headwear.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(60, 48).addBox(-0.1047F, -3.8361F, -3.2052F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -1.0F, 2.0F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(0, 96).addBox(-0.3053F, -3.4694F, -3.5875F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(6, 6).addBox(-0.6663F, -2.5979F, -4.2198F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -7.0F, 0.6979F, -0.0094F, -0.4374F));

		PartDefinition cube_r16 = flower.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r17 = flower.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 66).addBox(-7.68F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r18 = flower.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(18, 47).addBox(-5.12F, 0.0F, -7.68F, 8.96F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = flower.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(36, 47).addBox(-5.12F, 0.0F, 0.0F, 8.96F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -10.0F, -7.0F, -0.262F, -0.3149F, 0.4789F));

		PartDefinition cube_r20 = flower2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 58).addBox(0.0F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r21 = flower2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(52, 59).addBox(-7.68F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r22 = flower2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 42).addBox(-5.12F, 0.0F, -7.68F, 8.96F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r23 = flower2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(46, 0).addBox(-4.16F, 0.0F, 0.0F, 8.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tumor1 = partdefinition.addOrReplaceChild("tumor1", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 3.0F));

		PartDefinition cube_r24 = tumor1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(33, 5).addBox(-12.0F, -27.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r25 = tumor1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 50).addBox(-2.0F, -29.0F, -3.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.1745F, -0.6109F, -0.0436F));

		PartDefinition cube_r26 = tumor1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(52, 19).addBox(-4.0F, -26.0F, -3.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.1745F, 0.3927F, 0.0873F));

		PartDefinition cube_r27 = tumor1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(54, 67).addBox(-1.0F, -21.0F, -25.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition tumor3 = partdefinition.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(1.0F, 5.0F, -1.0F));

		PartDefinition cube_r28 = tumor3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(18, 68).addBox(-4.0F, -24.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, 0.2597F, -0.0338F, 0.1265F));

		PartDefinition cube_r29 = tumor3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(90, 78).addBox(2.0F, -19.0F, -9.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, -0.2618F, 0.0F, -0.3491F));

		PartDefinition cube_r30 = tumor3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(73, 38).addBox(1.0F, -25.0F, -9.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, -0.1309F, 0.0F, -0.2182F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {


		if (entity.isAggressive()){
			if (entity.swinging){
				this.RightArm.xRot = -89F;
				this.LeftArm.xRot = -89F;
			}else{
				this.RightArm.xRot = -89.5F + Mth.sin(ageInTicks / 7) / 8;
				this.LeftArm.xRot = -89.5F - Mth.sin(ageInTicks / 7) / 8;
			}

		}else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		} else{

			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
			this.LeftLeg.xRot = 0;
			this.RightLeg.xRot = 0;
		}

		this.tumor1.xScale = 1 + Mth.sin(ageInTicks / 8) / 10;
		this.tumor1.yScale = 1 - Mth.sin(ageInTicks / 7) / 7;
		this.tumor1.zScale = 1 + Mth.sin(ageInTicks / 7) / 8;

		this.tumor3.xScale = 1 + Mth.sin(ageInTicks / 9) / 6;
		this.tumor3.yScale = 1 - Mth.sin(ageInTicks / 7) / 8;
		this.tumor3.zScale = 1 + Mth.sin(ageInTicks / 7) / 9;

		this.LeftArm.getChild("tumor4").xScale = 1 + Mth.sin(ageInTicks / 9) / 6;
		this.LeftArm.getChild("tumor4").yScale = 1 - Mth.sin(ageInTicks / 8) / 6;
		this.LeftArm.getChild("tumor4").zScale = 1 + Mth.sin(ageInTicks / 9) / 8;

		this.RightArm.getChild("RightForArm").getChild("tumor2").xScale = 1 + Mth.sin(ageInTicks / 12) / 11;
		this.RightArm.getChild("RightForArm").getChild("tumor2").yScale = 1 - Mth.sin(ageInTicks / 11) / 12;
		this.RightArm.getChild("RightForArm").getChild("tumor2").zScale = 1 + Mth.sin(ageInTicks / 11) / 12;

		this.head.xRot = headPitch / (90F / (float) Math.PI);
		this.head.getChild("jaw").xRot = Mth.sin(ageInTicks / 8) / 10;

		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		if (LeftLeg.xRot < 0){
			this.LeftLeg.getChild("leftForLeg").xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.RightLeg.getChild("rightForLeg").xRot = -RightLeg.xRot;}

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}