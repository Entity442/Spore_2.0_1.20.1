package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Sieger;
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

public class SiegerModel<T extends Sieger> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "siegermodel"), "main");
	private final ModelPart smolleg;
	private final ModelPart mainbody;
	private final ModelPart mainbody2;
	private final ModelPart tail;
	private final ModelPart RightLegJointY;
	private final ModelPart LeftLegJointY;
	private final ModelPart jaw;
	private final ModelPart BackRightLeg;
	private final ModelPart BackLeftLeg;

	public SiegerModel(ModelPart root) {
		this.smolleg = root.getChild("smolleg");
		this.mainbody = root.getChild("mainbody");
		this.mainbody2 = root.getChild("mainbody2");
		this.tail = root.getChild("tail");
		this.RightLegJointY = root.getChild("RightLegJointY");
		this.LeftLegJointY = root.getChild("LeftLegJointY");
		this.jaw = root.getChild("jaw");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition smolleg = partdefinition.addOrReplaceChild("smolleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -1.0F, 12.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r1 = smolleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(164, 222).addBox(-25.6581F, -20.5F, -8.6931F, 21.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6581F, 2.0F, 6.1931F, 0.0F, 0.0F, -1.5708F));

		PartDefinition cube_r2 = smolleg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(270, 84).addBox(-18.6581F, -9.0F, -8.6931F, 14.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6581F, 2.0F, 6.1931F, 0.0F, 0.0F, -0.5672F));

		PartDefinition mainbody = partdefinition.addOrReplaceChild("mainbody", CubeListBuilder.create().texOffs(0, 52).addBox(-15.0F, -13.0F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.0F))
		.texOffs(199, 0).addBox(-15.0F, -4.0F, 24.0F, 30.0F, 17.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(206, 321).addBox(13.0F, 3.0F, 24.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(320, 320).addBox(13.0F, 0.0F, 34.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(100, 301).addBox(13.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(279, 233).addBox(-16.0F, -14.0F, 11.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(214, 243).addBox(-15.0F, -20.0F, 2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(123, 251).addBox(-13.0F, -20.0F, 10.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(234, 307).addBox(-8.0F, -22.0F, 7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -5.0F));

		PartDefinition cube_r3 = mainbody.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(171, 252).addBox(11.0F, -20.0F, 16.0F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(152, 320).addBox(7.0F, -31.0F, 27.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r4 = mainbody.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 307).addBox(6.0F, -46.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, -0.0436F, 0.0F, -0.3927F));

		PartDefinition cube_r5 = mainbody.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(306, 60).addBox(-16.0F, -29.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0903F, -0.2608F, -0.1542F));

		PartDefinition cube_r6 = mainbody.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(306, 173).addBox(-14.0F, -32.0F, 4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0873F, 0.0F, -0.1309F));

		PartDefinition cube_r7 = mainbody.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(96, 237).addBox(-40.0F, -44.0F, -27.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.1706F, -0.1996F, 0.8555F));

		PartDefinition cube_r8 = mainbody.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(305, 275).addBox(2.0F, -58.0F, -31.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r9 = mainbody.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 237).addBox(-21.0F, -27.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r10 = mainbody.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(314, 242).addBox(12.0F, -46.0F, -27.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 218).addBox(15.0F, -41.0F, -26.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(170, 290).addBox(18.0F, -29.0F, -17.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, -0.2182F, 0.0F, -0.1309F));

		PartDefinition cube_r11 = mainbody.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(314, 256).addBox(14.0F, -39.0F, -12.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0436F, 0.0F, -0.1309F));

		PartDefinition cube_r12 = mainbody.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(194, 300).addBox(17.0F, -32.0F, -14.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r13 = mainbody.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(320, 191).addBox(13.0F, -24.0F, 28.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 5.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r14 = mainbody.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 65).addBox(-5.0F, -10.0F, -10.0F, 9.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 23.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition cube_r15 = mainbody.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(206, 159).addBox(-12.0F, 7.0F, 14.0F, 23.0F, 9.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(132, 117).addBox(-12.0F, 4.0F, -21.0F, 23.0F, 9.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.0F, 13.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r16 = mainbody.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 275).addBox(-7.0F, -7.0F, -5.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -16.0F, -6.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r17 = mainbody.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(36, 277).addBox(-5.0F, 1.0F, 5.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -16.0F, -6.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition cube_r18 = mainbody.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(-14.5F, -3.0F, -29.0F, 29.0F, 13.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 19.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body2 = mainbody.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(310, 93).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(188, 315).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(320, 52).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -24.0F, -29.0F, 1.7773F, 0.1678F, -0.5119F));

		PartDefinition RightArm2 = body2.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(329, 252).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition RightForArm2 = RightArm2.addOrReplaceChild("RightForArm2", CubeListBuilder.create().texOffs(204, 329).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition LeftArm2 = body2.addOrReplaceChild("LeftArm2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -2.9671F, 0.0F, 0.0F));

		PartDefinition LeftForArm2 = LeftArm2.addOrReplaceChild("LeftForArm2", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightLeg2 = body2.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(276, 324).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 11.25F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightForLeg2 = RightLeg2.addOrReplaceChild("rightForLeg2", CubeListBuilder.create().texOffs(324, 205).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg2 = body2.addOrReplaceChild("LeftLeg2", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg2 = LeftLeg2.addOrReplaceChild("leftForLeg2", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body3 = mainbody.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(310, 84).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 315).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(320, 46).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -23.0F, -37.0F, 1.8358F, -0.0134F, 0.2106F));

		PartDefinition RightArm3 = body3.addOrReplaceChild("RightArm3", CubeListBuilder.create().texOffs(318, 328).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.6109F, 0.0F, 1.6581F));

		PartDefinition RightForArm3 = RightArm3.addOrReplaceChild("RightForArm3", CubeListBuilder.create().texOffs(328, 284).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition LeftArm3 = body3.addOrReplaceChild("LeftArm3", CubeListBuilder.create().texOffs(144, 328).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -2.9671F, 0.0F, 0.0F));

		PartDefinition LeftForArm3 = LeftArm3.addOrReplaceChild("LeftForArm3", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r19 = LeftForArm3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(48, 328).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg3 = body3.addOrReplaceChild("RightLeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9F, 11.25F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition rightForLeg3 = RightLeg3.addOrReplaceChild("rightForLeg3", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg3 = body3.addOrReplaceChild("LeftLeg3", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg3 = LeftLeg3.addOrReplaceChild("leftForLeg3", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body4 = mainbody.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(90, 315).addBox(-3.5F, 3.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(11.0F, -29.0F, -16.0F, 0.6981F, 0.0F, 0.4363F));

		PartDefinition cube_r20 = body4.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(309, 305).addBox(-44.0F, -1.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition head2 = body4.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(281, 295).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(254, 316).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(306, 72).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition jaw3 = head2.addOrReplaceChild("jaw3", CubeListBuilder.create().texOffs(320, 40).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm4 = body4.addOrReplaceChild("RightArm4", CubeListBuilder.create().texOffs(328, 0).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.3647F, 0.5576F, 0.1102F));

		PartDefinition RightForArm4 = RightArm4.addOrReplaceChild("RightForArm4", CubeListBuilder.create().texOffs(327, 220).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm4 = body4.addOrReplaceChild("LeftArm4", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition LeftForArm4 = LeftArm4.addOrReplaceChild("LeftForArm4", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition body5 = mainbody.addOrReplaceChild("body5", CubeListBuilder.create().texOffs(282, 309).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 315).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(319, 266).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -5.0F, -6.0F, 1.4313F, -0.2013F, -1.4862F));

		PartDefinition head3 = body5.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(295, 127).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(210, 315).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(246, 185).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw4 = head3.addOrReplaceChild("jaw4", CubeListBuilder.create().texOffs(230, 319).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm5 = body5.addOrReplaceChild("RightArm5", CubeListBuilder.create().texOffs(327, 133).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.4531F, 0.272F, 0.5042F));

		PartDefinition RightForArm5 = RightArm5.addOrReplaceChild("RightForArm5", CubeListBuilder.create().texOffs(327, 114).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg4 = body5.addOrReplaceChild("RightLeg4", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg4 = RightLeg4.addOrReplaceChild("rightForLeg4", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg4 = body5.addOrReplaceChild("LeftLeg4", CubeListBuilder.create().texOffs(178, 324).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition leftForLeg4 = LeftLeg4.addOrReplaceChild("leftForLeg4", CubeListBuilder.create().texOffs(164, 324).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body6 = mainbody.addOrReplaceChild("body6", CubeListBuilder.create().texOffs(258, 307).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(302, 314).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(319, 127).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -15.0F, 8.0F, 0.3054F, 1.309F, 0.0F));

		PartDefinition head4 = body6.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(295, 16).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(313, 9).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(226, 187).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition jaw5 = head4.addOrReplaceChild("jaw5", CubeListBuilder.create().texOffs(319, 108).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm6 = body6.addOrReplaceChild("RightArm6", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.8047F, 0.3152F, 0.1526F));

		PartDefinition RightForArm6 = RightArm6.addOrReplaceChild("RightForArm6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm5 = body6.addOrReplaceChild("LeftArm5", CubeListBuilder.create().texOffs(327, 74).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -0.532F, -0.2071F, -0.3361F));

		PartDefinition LeftForArm5 = LeftArm5.addOrReplaceChild("LeftForArm5", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r21 = LeftForArm5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(327, 21).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body7 = mainbody.addOrReplaceChild("body7", CubeListBuilder.create().texOffs(304, 200).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(166, 314).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(319, 102).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -25.0F, 1.0F, 0.9479F, -0.4F, 0.2727F));

		PartDefinition head5 = body7.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(249, 293).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(312, 185).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(219, 145).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw6 = head5.addOrReplaceChild("jaw6", CubeListBuilder.create().texOffs(40, 319).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm7 = body7.addOrReplaceChild("RightArm7", CubeListBuilder.create().texOffs(234, 325).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition RightForArm7 = RightArm7.addOrReplaceChild("RightForArm7", CubeListBuilder.create().texOffs(222, 325).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition LeftArm6 = body7.addOrReplaceChild("LeftArm6", CubeListBuilder.create().texOffs(192, 325).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition LeftForArm6 = LeftArm6.addOrReplaceChild("LeftForArm6", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r22 = LeftForArm6.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(325, 156).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg5 = body7.addOrReplaceChild("RightLeg5", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg5 = RightLeg5.addOrReplaceChild("rightForLeg5", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg5 = body7.addOrReplaceChild("LeftLeg5", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg5 = LeftLeg5.addOrReplaceChild("leftForLeg5", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body8 = mainbody.addOrReplaceChild("body8", CubeListBuilder.create().texOffs(304, 0).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 313).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(319, 15).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -1.0F, 15.0F, 0.0F, 1.5708F, -0.4363F));

		PartDefinition RightArm8 = body8.addOrReplaceChild("RightArm8", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightForArm8 = RightArm8.addOrReplaceChild("RightForArm8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm7 = body8.addOrReplaceChild("LeftArm7", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition LeftForArm7 = LeftArm7.addOrReplaceChild("LeftForArm7", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightLeg6 = body8.addOrReplaceChild("RightLeg6", CubeListBuilder.create().texOffs(130, 324).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, 10.75F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition rightForLeg6 = RightLeg6.addOrReplaceChild("rightForLeg6", CubeListBuilder.create().texOffs(22, 287).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg6 = body8.addOrReplaceChild("LeftLeg6", CubeListBuilder.create().texOffs(22, 323).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4F, 9.0F, -3.0F, -0.4363F, 0.0F, -0.3054F));

		PartDefinition leftForLeg6 = LeftLeg6.addOrReplaceChild("leftForLeg6", CubeListBuilder.create().texOffs(262, 322).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body9 = mainbody.addOrReplaceChild("body9", CubeListBuilder.create().texOffs(303, 141).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(311, 30).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F))
		.texOffs(274, 318).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -16.0F, 21.0F, 1.0675F, 0.1697F, 0.2056F));

		PartDefinition head6 = body9.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(288, 186).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(312, 150).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(162, 98).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw7 = head6.addOrReplaceChild("jaw7", CubeListBuilder.create().texOffs(134, 318).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm9 = body9.addOrReplaceChild("RightArm9", CubeListBuilder.create().texOffs(108, 325).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.3927F, 0.0F, 0.9163F));

		PartDefinition RightForArm9 = RightArm9.addOrReplaceChild("RightForArm9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r23 = RightForArm9.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(96, 325).addBox(-47.0F, 6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(44.9F, -6.2388F, 1.7425F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm8 = body9.addOrReplaceChild("LeftArm8", CubeListBuilder.create().texOffs(84, 325).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3054F, 0.0F, -1.3526F));

		PartDefinition LeftForArm8 = LeftArm8.addOrReplaceChild("LeftForArm8", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition RightLeg7 = body9.addOrReplaceChild("RightLeg7", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg7 = RightLeg7.addOrReplaceChild("rightForLeg7", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg7 = body9.addOrReplaceChild("LeftLeg7", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg7 = LeftLeg7.addOrReplaceChild("leftForLeg7", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body10 = mainbody.addOrReplaceChild("body10", CubeListBuilder.create().texOffs(98, 262).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(226, 301).addBox(-3.5F, 10.0F, -2.0F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -6.0F, 25.0F, -1.6978F, 1.2191F, -1.6901F));

		PartDefinition head7 = body10.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(287, 261).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(311, 233).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(130, 53).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6346F, 0.678F, -0.4326F));

		PartDefinition jaw8 = head7.addOrReplaceChild("jaw8", CubeListBuilder.create().texOffs(116, 245).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightLeg8 = body10.addOrReplaceChild("RightLeg8", CubeListBuilder.create().texOffs(248, 322).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 15.0F, 0.5F, -0.2618F, 0.0F, 0.3054F));

		PartDefinition rightForLeg8 = RightLeg8.addOrReplaceChild("rightForLeg8", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg8 = body10.addOrReplaceChild("LeftLeg8", CubeListBuilder.create().texOffs(58, 321).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9F, 15.0F, 1.0F, -0.4608F, -0.1393F, -0.2727F));

		PartDefinition leftForLeg8 = LeftLeg8.addOrReplaceChild("leftForLeg8", CubeListBuilder.create().texOffs(292, 320).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body11 = mainbody.addOrReplaceChild("body11", CubeListBuilder.create().texOffs(171, 243).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(310, 291).addBox(-3.5F, 4.5F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-17.0F, 6.0F, -6.0F, 1.4767F, 0.9521F, -1.1082F));

		PartDefinition cube_r24 = body11.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(96, 225).addBox(-43.5F, 7.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition head8 = body11.addOrReplaceChild("head8", CubeListBuilder.create().texOffs(287, 247).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(287, 275).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 85).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jaw9 = head8.addOrReplaceChild("jaw9", CubeListBuilder.create().texOffs(60, 245).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm10 = body11.addOrReplaceChild("RightArm10", CubeListBuilder.create().texOffs(0, 237).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 7.75F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 2.2689F));

		PartDefinition RightForArm10 = RightArm10.addOrReplaceChild("RightForArm10", CubeListBuilder.create().texOffs(170, 275).addBox(-1.9F, 0.4764F, -0.8261F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition LeftArm9 = body11.addOrReplaceChild("LeftArm9", CubeListBuilder.create().texOffs(72, 325).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.5603F, 0.0934F, -1.1948F));

		PartDefinition LeftForArm9 = LeftArm9.addOrReplaceChild("LeftForArm9", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r25 = LeftForArm9.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(36, 325).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg9 = body11.addOrReplaceChild("RightLeg9", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg9 = RightLeg9.addOrReplaceChild("rightForLeg9", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg9 = body11.addOrReplaceChild("LeftLeg9", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg9 = LeftLeg9.addOrReplaceChild("leftForLeg9", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition body12 = mainbody.addOrReplaceChild("body12", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(18.0F, -4.0F, 23.0F, 0.5236F, -1.4399F, 0.0F));

		PartDefinition cube_r26 = body12.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head9 = body12.addOrReplaceChild("head9", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition jaw10 = head9.addOrReplaceChild("jaw10", CubeListBuilder.create().texOffs(196, 216).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition RightArm11 = body12.addOrReplaceChild("RightArm11", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.0106F, -0.1673F, 1.9952F));

		PartDefinition RightForArm11 = RightArm11.addOrReplaceChild("RightForArm11", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm10 = body12.addOrReplaceChild("LeftArm10", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2182F, 0.0F, -0.829F));

		PartDefinition LeftForArm10 = LeftArm10.addOrReplaceChild("LeftForArm10", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r27 = LeftForArm10.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus = mainbody.addOrReplaceChild("bloomingFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -20.0F, -32.0F, 0.7974F, -0.1536F, -0.1555F));

		PartDefinition cube_r28 = bloomingFungus.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r29 = bloomingFungus.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r30 = bloomingFungus.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(228, 143).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r31 = bloomingFungus.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r32 = bloomingFungus.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r33 = bloomingFungus.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition bloomingFungus2 = mainbody.addOrReplaceChild("bloomingFungus2", CubeListBuilder.create(), PartPose.offsetAndRotation(20.0F, -17.0F, 1.0F, -0.7756F, -0.7832F, 0.9493F));

		PartDefinition cube_r34 = bloomingFungus2.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(0, 145).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r35 = bloomingFungus2.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 157).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r36 = bloomingFungus2.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r37 = bloomingFungus2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(108, 173).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r38 = bloomingFungus2.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(116, 133).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(148, 206).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r39 = bloomingFungus2.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(218, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower4 = mainbody.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -20.5F, 16.75F, -3.1182F, -0.1713F, -2.1461F));

		PartDefinition cube_r40 = flower4.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(201, 104).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r41 = flower4.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(205, 119).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r42 = flower4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(92, 123).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r43 = flower4.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(92, 129).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bigFlower2 = mainbody.addOrReplaceChild("bigFlower2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -28.0F, -2.0F, -0.1128F, -0.2368F, -0.2484F));

		PartDefinition cube_r44 = bigFlower2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(116, 189).addBox(0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r45 = bigFlower2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(191, 0).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r46 = bigFlower2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(20, 133).addBox(-5.0F, 0.0F, -8.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r47 = bigFlower2.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(136, 0).addBox(-5.0F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower5 = mainbody.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0F, -21.5F, 7.75F, 0.2111F, -0.2734F, -1.4082F));

		PartDefinition cube_r48 = flower5.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(200, 185).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r49 = flower5.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(201, 98).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r50 = flower5.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(60, 111).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r51 = flower5.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(92, 117).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition mainbody2 = partdefinition.addOrReplaceChild("mainbody2", CubeListBuilder.create().texOffs(0, 115).addBox(-5.0F, -8.0F, -32.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(276, 175).addBox(-5.0F, 0.0F, -32.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(260, 61).addBox(-7.0F, -9.0F, -28.0F, 15.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -17.0F));

		PartDefinition cube_r52 = mainbody2.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 206).addBox(-3.0F, -1.25F, 43.0F, 21.0F, 11.25F, 20.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.0F, -32.1577F, -45.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r53 = mainbody2.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(234, 190).addBox(-2.0F, -1.0F, 7.0F, 19.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -2.6058F, -27.4778F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r54 = mainbody2.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 6).addBox(-13.75F, -23.0F, -24.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 6.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition e_r1 = mainbody2.addOrReplaceChild("e_r1", CubeListBuilder.create().texOffs(0, 83).addBox(-13.75F, -23.0F, -32.0F, 0.0F, 12.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5F, 22.0F, 6.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r55 = mainbody2.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(0, 37).addBox(-29.75F, -24.0F, -8.0F, 0.0F, 13.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, 6.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Head_r1 = mainbody2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(22, 303).addBox(4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(301, 159).addBox(4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -24.0F, 0.0F, -1.3963F, 0.0F));

		PartDefinition Head_r2 = mainbody2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(303, 117).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(202, 301).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -24.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition Head_r3 = mainbody2.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(283, 96).addBox(0.0F, -3.0F, -1.0F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(276, 143).addBox(0.0F, -10.0F, -1.0F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -1.0F, -23.0F, 0.0F, 1.1345F, 0.0F));

		PartDefinition Head_r4 = mainbody2.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(278, 284).addBox(-7.0F, 0.0F, 1.0F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(277, 0).addBox(-7.0F, -7.0F, 1.0F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -1.0F, -23.0F, 0.0F, 0.9599F, 0.0F));

		PartDefinition cube_r56 = mainbody2.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(211, 98).addBox(-15.0F, -11.0F, -17.0F, 30.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition bloomingFungus3 = mainbody2.addOrReplaceChild("bloomingFungus3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -1.0F, 32.0F, -1.212F, -0.7832F, 0.9493F));

		PartDefinition cube_r57 = bloomingFungus3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 119).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r58 = bloomingFungus3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(144, 0).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r59 = bloomingFungus3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(82, 52).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r60 = bloomingFungus3.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(82, 68).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 8.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r61 = bloomingFungus3.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(50, 117).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(116, 117).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r62 = bloomingFungus3.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(50, 133).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower = mainbody2.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(17.0F, 8.0F, 0.0F, 0.1745F, 0.0F, 1.1345F));

		PartDefinition cube_r63 = flower.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(0, 212).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r64 = flower.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(212, 185).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r65 = flower.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(51, 189).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r66 = flower.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(65, 189).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bigFlower = mainbody2.addOrReplaceChild("bigFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(17.0F, 5.0F, 35.0F, -0.2618F, 0.0F, 0.8727F));

		PartDefinition cube_r67 = bigFlower.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(191, 8).addBox(0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r68 = bigFlower.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(116, 197).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r69 = bigFlower.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(20, 141).addBox(-5.0F, 0.0F, -8.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r70 = bigFlower.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(81, 173).addBox(-5.0F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = mainbody2.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(19.0F, 2.5F, 35.75F, -0.5236F, 0.0F, 1.1345F));

		PartDefinition cube_r71 = flower2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r72 = flower2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(0, 206).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r73 = flower2.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(92, 141).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r74 = flower2.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(152, 8).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = mainbody2.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -7.5F, 28.75F, -0.1997F, -0.523F, -0.386F));

		PartDefinition cube_r75 = flower3.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(205, 125).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r76 = flower3.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(205, 131).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r77 = flower3.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(92, 135).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r78 = flower3.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(138, 8).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bigFlower3 = mainbody2.addOrReplaceChild("bigFlower3", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -2.0F, 37.0F, -0.2024F, -0.1671F, 0.1915F));

		PartDefinition cube_r79 = bigFlower3.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(148, 173).addBox(0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r80 = bigFlower3.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(148, 181).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r81 = bigFlower3.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(89, 16).addBox(-5.0F, 0.0F, -8.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r82 = bigFlower3.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(58, 103).addBox(-5.0F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower6 = mainbody2.addOrReplaceChild("flower6", CubeListBuilder.create(), PartPose.offsetAndRotation(11.0F, -17.5F, -10.25F, -0.1997F, -0.523F, -0.386F));

		PartDefinition cube_r83 = flower6.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(200, 159).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r84 = flower6.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(200, 165).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r85 = flower6.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(92, 84).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r86 = flower6.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(106, 84).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition bigFlower4 = mainbody2.addOrReplaceChild("bigFlower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0F, 22.0F, 5.0F, 0.0983F, 0.1213F, -1.551F));

		PartDefinition cube_r87 = bigFlower4.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(22, 115).addBox(0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r88 = bigFlower4.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(99, 173).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r89 = bigFlower4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(89, 0).addBox(-5.0F, 0.0F, -8.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r90 = bigFlower4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(89, 8).addBox(-5.0F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -3.0F, 57.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition tailjoint = tail.addOrReplaceChild("tailjoint", CubeListBuilder.create().texOffs(97, 0).addBox(-5.0F, -4.2201F, 0.137F, 10.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, -17.0F));

		PartDefinition tail2 = tailjoint.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 18.0F, 42.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition tailjoint2 = tail2.addOrReplaceChild("tailjoint2", CubeListBuilder.create().texOffs(119, 206).addBox(-4.5F, -4.9163F, -0.0826F, 9.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.0F, 2.0F));

		PartDefinition tail3 = tailjoint2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 23.0F, 25.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition tailjoint3 = tail3.addOrReplaceChild("tailjoint3", CubeListBuilder.create().texOffs(191, 206).addBox(-4.0F, -4.9388F, 0.2976F, 8.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, 9.0F));

		PartDefinition tail4 = tailjoint3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 21.0F, 18.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tailjoint4 = tail4.addOrReplaceChild("tailjoint4", CubeListBuilder.create().texOffs(55, 225).addBox(-3.5F, -3.6187F, 1.0213F, 7.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -15.0F, 17.0F));

		PartDefinition tumor = tailjoint4.addOrReplaceChild("tumor", CubeListBuilder.create().texOffs(123, 243).addBox(-8.0F, -20.6187F, 25.0213F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -19.6187F, 18.0213F, 12.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 7.0F));

		PartDefinition RightLegJointY = partdefinition.addOrReplaceChild("RightLegJointY", CubeListBuilder.create(), PartPose.offset(16.0F, -11.0F, 0.0F));

		PartDefinition RightLegJointZ = RightLegJointY.addOrReplaceChild("RightLegJointZ", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg = RightLegJointZ.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(162, 77).addBox(-0.6565F, -5.7316F, -5.0F, 44.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition cube_r91 = leg.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(0, 237).addBox(10.0F, 37.0F, -6.5F, 12.0F, 38.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.3435F, -0.7316F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r92 = leg.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(187, 243).addBox(1.0F, -7.0F, -4.5F, 9.0F, 48.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.3435F, -0.7316F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LeftLegJointY = partdefinition.addOrReplaceChild("LeftLegJointY", CubeListBuilder.create(), PartPose.offset(-11.0F, -14.0F, -7.0F));

		PartDefinition LeftLegJointZ = LeftLegJointY.addOrReplaceChild("LeftLegJointZ", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leg2 = LeftLegJointZ.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(162, 53).addBox(-125.7328F, 62.4211F, 9.0F, 44.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(108.0F, 0.0F, -14.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition twitstedleg2 = leg2.addOrReplaceChild("twitstedleg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-40.0F, 0.0F, 12.0F, -0.818F, -0.6085F, 0.4711F));

		PartDefinition cube_r93 = twitstedleg2.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(144, 275).addBox(-78.9013F, 53.3105F, 85.0427F, 8.0F, 38.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition cube_r94 = twitstedleg2.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(223, 243).addBox(-62.6728F, 21.9996F, 83.5427F, 9.0F, 50.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition twitstedleg = leg2.addOrReplaceChild("twitstedleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-40.0F, 0.0F, 12.0F, 0.5859F, 0.4559F, 0.3028F));

		PartDefinition cube_r95 = twitstedleg.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(0, 287).addBox(-98.6601F, 50.5391F, -75.6586F, 6.0F, 38.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition cube_r96 = twitstedleg.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(257, 235).addBox(-82.4416F, 24.6953F, -77.1586F, 7.0F, 50.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -16.0F));

		PartDefinition cube_r97 = jaw.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(260, 35).addBox(-3.0F, 10.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -37.1577F, -46.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition Head_r5 = jaw.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(298, 209).addBox(15.0F, -13.0F, -20.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 277).addBox(15.0F, -7.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -1.2654F, -3.1416F));

		PartDefinition Head_r6 = jaw.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(295, 107).addBox(11.0F, -10.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(170, 300).addBox(11.0F, -16.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -0.7418F, -3.1416F));

		PartDefinition Head_r7 = jaw.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(298, 223).addBox(-13.0F, -8.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(76, 301).addBox(-13.0F, -14.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, 1.2654F, -3.1416F));

		PartDefinition Head_r8 = jaw.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(236, 35).addBox(-4.0F, -10.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(108, 301).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, 0.4363F, -3.1416F));

		PartDefinition cube_r98 = jaw.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(48, 262).addBox(-10.0F, -12.0F, -8.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, -15.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r99 = jaw.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(211, 119).addBox(-11.0F, -21.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 26.0F, 3.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -7.0F, 77.0F, 1.0908F, -0.3491F, 0.0F));

		PartDefinition legback3 = BackRightLeg.addOrReplaceChild("legback3", CubeListBuilder.create().texOffs(136, 0).addBox(-5.0F, -6.0F, -5.0F, 13.0F, 16.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -32.0F, -32.0F));

		PartDefinition BackRightLeg2 = legback3.addOrReplaceChild("BackRightLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 7.0F, 58.0F, -2.2253F, 0.0F, 0.0F));

		PartDefinition legback4 = BackRightLeg2.addOrReplaceChild("legback4", CubeListBuilder.create(), PartPose.offset(2.0F, 24.0F, 10.0F));

		PartDefinition cube_r100 = legback4.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(145, 159).addBox(-15.0F, -19.0F, 39.0F, 14.0F, 14.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -24.0F, -10.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r101 = legback4.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(66, 117).addBox(-3.0F, 23.0F, -7.0F, 10.0F, 10.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -24.0F, -10.0F, 0.5444F, -0.2635F, -0.1564F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, -7.0F, 77.0F, 1.0908F, 0.3491F, 0.0F));

		PartDefinition legback = BackLeftLeg.addOrReplaceChild("legback", CubeListBuilder.create().texOffs(72, 184).addBox(-6.0F, -7.0F, -3.0F, 15.0F, 19.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(91, 58).addBox(-5.0F, -4.0F, 15.0F, 13.0F, 14.0F, 45.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -31.0F, -31.0F));

		PartDefinition BackLeftLeg2 = legback.addOrReplaceChild("BackLeftLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 9.0F, 62.0F, -2.2253F, 0.0F, 0.0F));

		PartDefinition legback2 = BackLeftLeg2.addOrReplaceChild("legback2", CubeListBuilder.create().texOffs(0, 103).addBox(-5.0F, -8.0F, -7.0F, 10.0F, 10.0F, 46.0F, new CubeDeformation(0.1F)), PartPose.offset(3.0F, 7.0F, 0.0F));

		PartDefinition cube_r102 = legback2.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(0, 159).addBox(-1.0F, -21.0F, 25.0F, 10.0F, 10.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.467F, 7.4673F, -0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLegJointY.yRot = Mth.cos(limbSwing * 0.2F) * -1F * limbSwingAmount;
		this.LeftLegJointY.yRot = -Mth.cos(limbSwing * 0.4F) * -0.9F * limbSwingAmount;
		this.BackRightLeg.getChild("legback3").xRot = Mth.cos(limbSwing * 0.4F) * -0.4F * limbSwingAmount;
		this.BackRightLeg.getChild("legback3").getChild("BackRightLeg2").getChild("legback4").xRot = -BackRightLeg.getChild("legback3").xRot;
		this.BackLeftLeg.getChild("legback").xRot = -Mth.cos(limbSwing * 0.3F) * -0.3F * limbSwingAmount;
		this.BackLeftLeg.getChild("legback").getChild("BackLeftLeg2").getChild("legback2").xRot = -BackLeftLeg.getChild("legback").xRot;
		this.smolleg.yRot = Mth.cos(limbSwing * 0.5F) * -0.5F * limbSwingAmount;

		this.jaw.xRot =  Mth.sin(ageInTicks/8)/10;

		this.tail.visible = entity.getTailHp() > 0;
		this.tail.getChild("tailjoint").xRot = Mth.sin(ageInTicks/8)/10;
		this.tail.getChild("tailjoint").getChild("tail2").getChild("tailjoint2").xRot = Mth.sin(ageInTicks/8)/10;
		this.tail.getChild("tailjoint").getChild("tail2").getChild("tailjoint2").getChild("tail3").getChild("tailjoint3").xRot = Mth.sin(ageInTicks/8)/10;
		this.tail.getChild("tailjoint").getChild("tail2").getChild("tailjoint2").getChild("tail3").getChild("tailjoint3").getChild("tail4").getChild("tailjoint4").xRot = Mth.sin(ageInTicks/8)/10;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		smolleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mainbody.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mainbody2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLegJointY.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLegJointY.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}