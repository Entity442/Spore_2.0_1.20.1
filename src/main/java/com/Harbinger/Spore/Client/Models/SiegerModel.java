package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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

public class SiegerModel<T extends Sieger> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "siegermodel"), "main");
	private final ModelPart smolleg;
	private final ModelPart mainbody;
	private final ModelPart mainbody2;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart tailTumor1;
	private final ModelPart tailTumor2;
	private final ModelPart tailTumor3;
	private final ModelPart RightLegJointY;
	private final ModelPart RightLegForLeg;
	private final ModelPart LeftLegJointY;
	private final ModelPart LeftLegForleg1;
	private final ModelPart LeftLegForleg2;
	private final ModelPart jaw;
	private final ModelPart BackRightLeg;
	private final ModelPart BackRightForLeg;
	private final ModelPart BackRightForLeg2;
	private final ModelPart BackLeftLeg;
	private final ModelPart BackLeftForLeg;
	private final ModelPart BackLeftForLeg2;
	public SiegerModel(ModelPart root) {
		this.smolleg = root.getChild("smolleg");
		this.mainbody = root.getChild("mainbody");
		this.mainbody2 = root.getChild("mainbody2");
		this.tail = root.getChild("tail");
		this.tail2 = tail.getChild("tail2");
		this.tail3 = tail2.getChild("tail3");
		this.tail4 = tail3.getChild("tail4");
		this.tailTumor1 = tail3.getChild("TumorBase3");
		this.tailTumor2 = tail4.getChild("tumor").getChild("TumorBase2");
		this.tailTumor3 = tail4.getChild("tumor").getChild("TumorBase");
		this.RightLegJointY = root.getChild("RightLegJointY");
		this.RightLegForLeg = RightLegJointY.getChild("RightLeg").getChild("RightForleg");
		this.LeftLegJointY = root.getChild("LeftLegJointY");
		this.LeftLegForleg1 = LeftLegJointY.getChild("LeftLeg").getChild("leg2").getChild("twitstedleg");
		this.LeftLegForleg2 = LeftLegJointY.getChild("LeftLeg").getChild("leg2").getChild("twitstedleg2");
		this.jaw = root.getChild("jaw");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightForLeg = BackRightLeg.getChild("legback3");
		this.BackRightForLeg2 = BackRightForLeg.getChild("BackRightLeg2").getChild("legback4");
		this.BackLeftForLeg = BackLeftLeg.getChild("legback");
		this.BackLeftForLeg2 = BackLeftForLeg.getChild("BackLeftLeg2").getChild("legback2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition smolleg = partdefinition.addOrReplaceChild("smolleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -1.0F, 12.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r1 = smolleg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(164, 222).addBox(-25.6581F, -20.5F, -8.6931F, 21.0F, 5.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(7.6581F, 2.0F, 6.1931F, 0.0F, 0.0F, -1.5708F));

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

		PartDefinition cube_r17 = mainbody.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(36, 277).addBox(-5.0F, 1.0F, 5.0F, 12.0F, 14.0F, 12.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(8.0F, -16.0F, -6.0F, 0.0F, 0.0F, -0.6109F));

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

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(97, 0).addBox(-5.0F, -5.2627F, -1.3244F, 10.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 34.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(119, 206).addBox(-4.5F, -3.9592F, -0.5441F, 9.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0426F, 24.5386F, 0.829F, 0.0F, 0.0F));

		PartDefinition flower27 = tail2.addOrReplaceChild("flower27", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -11.5429F, -4.7115F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r91 = flower27.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(191, 206).addBox(-4.0F, -5.2655F, 1.7732F, 8.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.9571F, 24.5385F, 0.3491F, 0.0F, 0.0F));

		PartDefinition TumorBase3 = tail3.addOrReplaceChild("TumorBase3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8438F, -3.1188F, 5.6637F, 0.0F, 0.0F, 2.9671F));

		PartDefinition Biomass_r1 = TumorBase3.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9444F, -0.6516F, -4.1062F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = TumorBase3.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8273F, -0.3149F, 3.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = TumorBase3.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6309F, 1.1063F, 6.6738F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = TumorBase3.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5473F, -4.3744F, -11.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(55, 225).addBox(-3.5F, -5.7982F, 0.2271F, 7.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.6732F, 28.4756F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tumor = tail4.addOrReplaceChild("tumor", CubeListBuilder.create().texOffs(123, 243).addBox(-8.0F, -8.6187F, 5.0213F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -7.6187F, -1.9787F, 12.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.1795F, 26.2058F));

		PartDefinition TumorBase = tumor.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(2.1562F, 7.2079F, 8.1882F));

		PartDefinition Biomass_r5 = TumorBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = TumorBase.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = TumorBase.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = TumorBase.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r9 = TumorBase.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(132, 249).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7285F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition TumorBase2 = tumor.addOrReplaceChild("TumorBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.1562F, -3.7921F, 5.1882F, 0.0F, 0.0F, 2.9671F));

		PartDefinition Biomass_r10 = TumorBase2.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r11 = TumorBase2.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r12 = TumorBase2.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r13 = TumorBase2.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r14 = TumorBase2.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(132, 249).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7285F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition flower28 = tail3.addOrReplaceChild("flower28", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.8268F, 11.2256F, 1.3326F, -0.1096F, -0.4232F));

		PartDefinition cube_r92 = flower28.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower29 = tail3.addOrReplaceChild("flower29", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.1732F, 16.2256F, 1.3326F, -0.1096F, -0.4232F));

		PartDefinition cube_r93 = flower29.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition RightLegJointY = partdefinition.addOrReplaceChild("RightLegJointY", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -11.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition RightLeg = RightLegJointY.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(64, 349).addBox(-6.0F, -9.0F, -7.0F, 10.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r94 = RightLeg.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(83, 347).addBox(-12.0F, -4.0F, -4.0F, 16.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -27.0F, -0.5F, 0.0F, 0.0F, -0.829F));

		PartDefinition cube_r95 = RightLeg.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(81, 367).addBox(-11.0F, -5.0F, -6.0F, 15.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -16.0F, 0.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r96 = RightLeg.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(81, 364).addBox(-10.0F, -6.0F, -7.0F, 14.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -7.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition RightForleg = RightLeg.addOrReplaceChild("RightForleg", CubeListBuilder.create().texOffs(0, 237).addBox(6.3435F, 33.2684F, -2.5F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 351).addBox(4.3435F, 53.2684F, -4.5F, 16.0F, 18.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -29.0F, 0.0F));

		PartDefinition cube_r97 = RightForleg.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(187, 243).addBox(1.0F, -4.0F, -4.5F, 9.0F, 29.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(6.3435F, 21.2684F, -14.0F, 0.8548F, -0.1274F, -0.158F));

		PartDefinition cube_r98 = RightForleg.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(187, 243).addBox(1.0F, -7.0F, -4.5F, 9.0F, 32.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6565F, 4.2684F, -1.0F, -0.5672F, 0.0F, -0.4363F));

		PartDefinition body17 = RightForleg.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(8.0F, 15.0F, -19.0F, 1.0472F, 0.0F, -3.098F));

		PartDefinition cube_r99 = body17.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(196, 206).addBox(-43.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(40.0F, 5.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r100 = body17.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head12 = body17.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm16 = body17.addOrReplaceChild("RightArm16", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightForArm16 = RightArm16.addOrReplaceChild("RightForArm16", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition LeftArm15 = body17.addOrReplaceChild("LeftArm15", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2616F, 0.0113F, -0.0421F));

		PartDefinition LeftForArm15 = LeftArm15.addOrReplaceChild("LeftForArm15", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r101 = LeftForArm15.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body14 = RightForleg.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(20.5F, 65.0F, -3.5F, 3.1063F, -0.8743F, -0.146F));

		PartDefinition cube_r102 = body14.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head11 = body14.addOrReplaceChild("head11", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm13 = body14.addOrReplaceChild("RightArm13", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.2875F, -0.2909F, 1.3581F));

		PartDefinition RightForArm13 = RightArm13.addOrReplaceChild("RightForArm13", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm12 = body14.addOrReplaceChild("LeftArm12", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition LeftForArm12 = LeftArm12.addOrReplaceChild("LeftForArm12", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r103 = LeftForArm12.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body15 = RightForleg.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(3.0F, 67.0F, 3.0F, 2.1763F, -1.2636F, 1.2282F));

		PartDefinition cube_r104 = body15.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm14 = body15.addOrReplaceChild("RightArm14", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -2.4042F, 0.2975F, 0.2602F));

		PartDefinition RightForArm14 = RightArm14.addOrReplaceChild("RightForArm14", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition LeftArm13 = body15.addOrReplaceChild("LeftArm13", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, -2.1281F, -0.7261F, 0.6583F));

		PartDefinition LeftForArm13 = LeftArm13.addOrReplaceChild("LeftForArm13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r105 = LeftForArm13.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body16 = RightForleg.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(17.0F, 61.0F, 9.0F, 0.5161F, 0.4924F, 0.0083F));

		PartDefinition cube_r106 = body16.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head13 = body16.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm15 = body16.addOrReplaceChild("RightArm15", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition RightForArm15 = RightArm15.addOrReplaceChild("RightForArm15", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm14 = body16.addOrReplaceChild("LeftArm14", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3244F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm14 = LeftArm14.addOrReplaceChild("LeftForArm14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r107 = LeftForArm14.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus5 = RightForleg.addOrReplaceChild("bloomingFungus5", CubeListBuilder.create(), PartPose.offsetAndRotation(17.75F, 35.0F, 3.0F, 0.0F, -0.3927F, 1.3526F));

		PartDefinition cube_r108 = bloomingFungus5.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r109 = bloomingFungus5.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r110 = bloomingFungus5.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r111 = bloomingFungus5.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r112 = bloomingFungus5.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r113 = bloomingFungus5.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower7 = RightForleg.addOrReplaceChild("flower7", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 43.5F, -3.25F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r114 = flower7.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower9 = RightForleg.addOrReplaceChild("flower9", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 42.5F, 10.75F, 0.0F, 2.7053F, 0.0F));

		PartDefinition cube_r115 = flower9.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower8 = RightForleg.addOrReplaceChild("flower8", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 36.5F, 3.75F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r116 = flower8.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition body13 = RightLeg.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(19.0F, -19.0F, -5.0F, 0.3927F, -0.3927F, 0.0F));

		PartDefinition cube_r117 = body13.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head10 = body13.addOrReplaceChild("head10", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm12 = body13.addOrReplaceChild("RightArm12", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.0472F, 0.0F, 1.0908F));

		PartDefinition RightForArm12 = RightArm12.addOrReplaceChild("RightForArm12", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0791F, -0.0368F, -0.4349F));

		PartDefinition LeftArm11 = body13.addOrReplaceChild("LeftArm11", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition LeftForArm11 = LeftArm11.addOrReplaceChild("LeftForArm11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition cube_r118 = LeftForArm11.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body18 = RightLeg.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(28.0F, -33.0F, -1.0F, 2.3126F, 1.5272F, -3.1416F));

		PartDefinition cube_r119 = body18.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head14 = body18.addOrReplaceChild("head14", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm17 = body18.addOrReplaceChild("RightArm17", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition RightForArm17 = RightArm17.addOrReplaceChild("RightForArm17", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm16 = body18.addOrReplaceChild("LeftArm16", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition LeftForArm16 = LeftArm16.addOrReplaceChild("LeftForArm16", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r120 = LeftForArm16.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head15 = body18.addOrReplaceChild("head15", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.0F, 2.25F, -1.1389F, 0.3419F, -0.2766F));

		PartDefinition body19 = RightLeg.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(5.0F, -7.0F, -6.0F, 0.1745F, 0.0F, 0.8727F));

		PartDefinition cube_r121 = body19.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head16 = body19.addOrReplaceChild("head16", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm18 = body19.addOrReplaceChild("RightArm18", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.1345F, 0.0F, 0.829F));

		PartDefinition RightForArm18 = RightArm18.addOrReplaceChild("RightForArm18", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition LeftArm17 = body19.addOrReplaceChild("LeftArm17", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition LeftForArm17 = LeftArm17.addOrReplaceChild("LeftForArm17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r122 = LeftForArm17.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus4 = RightLeg.addOrReplaceChild("bloomingFungus4", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, -19.0F, 3.0F, -0.829F, 0.0F, -0.4363F));

		PartDefinition cube_r123 = bloomingFungus4.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r124 = bloomingFungus4.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r125 = bloomingFungus4.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r126 = bloomingFungus4.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r127 = bloomingFungus4.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r128 = bloomingFungus4.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition LeftLegJointY = partdefinition.addOrReplaceChild("LeftLegJointY", CubeListBuilder.create(), PartPose.offset(-11.0F, -14.0F, -7.0F));

		PartDefinition LeftLeg = LeftLegJointY.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r129 = LeftLeg.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(184, 53).addBox(-21.7328F, -7.5789F, -5.0F, 22.0F, 14.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r130 = LeftLeg.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(162, 53).addBox(-23.7626F, -8.671F, -5.0F, 22.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.5F, -10.75F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition body22 = LeftLeg.addOrReplaceChild("body22", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-36.0F, -28.0F, 1.0F, -2.5744F, -1.3963F, 3.1416F));

		PartDefinition cube_r131 = body22.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head19 = body22.addOrReplaceChild("head19", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.9163F, 0.0F, 0.0F));

		PartDefinition RightArm21 = body22.addOrReplaceChild("RightArm21", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.4618F, -0.4122F, 2.324F));

		PartDefinition RightForArm21 = RightArm21.addOrReplaceChild("RightForArm21", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm20 = body22.addOrReplaceChild("LeftArm20", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -0.6858F, 0.202F, -2.3762F));

		PartDefinition LeftForArm20 = LeftArm20.addOrReplaceChild("LeftForArm20", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r132 = LeftForArm20.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body26 = LeftLeg.addOrReplaceChild("body26", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-13.0F, -15.0F, -5.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r133 = body26.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head23 = body26.addOrReplaceChild("head23", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightArm25 = body26.addOrReplaceChild("RightArm25", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.1604F, 1.5111F, 2.5044F));

		PartDefinition RightForArm25 = RightArm25.addOrReplaceChild("RightForArm25", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm24 = body26.addOrReplaceChild("LeftArm24", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 1.908F, -0.5358F, 1.131F));

		PartDefinition LeftForArm24 = LeftArm24.addOrReplaceChild("LeftForArm24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r134 = LeftForArm24.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition leg2 = LeftLeg.addOrReplaceChild("leg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, -21.0F, -14.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition twitstedleg2 = leg2.addOrReplaceChild("twitstedleg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.4478F, 9.8101F, 12.0F, -0.986F, -0.3036F, 0.8361F));

		PartDefinition cube_r135 = twitstedleg2.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(223, 243).addBox(-62.6728F, 21.9996F, 83.5427F, 9.0F, 50.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.1961F, -48.2831F, -87.4382F, 0.0F, 0.0F, -0.4363F));

		PartDefinition body28 = twitstedleg2.addOrReplaceChild("body28", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(8.4478F, 14.1899F, 5.0F, -0.4196F, 0.801F, -0.6176F));

		PartDefinition cube_r136 = body28.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head25 = body28.addOrReplaceChild("head25", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, -0.75F));

		PartDefinition RightArm27 = body28.addOrReplaceChild("RightArm27", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.7063F, -0.5543F, 1.9093F));

		PartDefinition RightForArm27 = RightArm27.addOrReplaceChild("RightForArm27", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm26 = body28.addOrReplaceChild("LeftArm26", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.7555F, 0.5162F, -1.9834F));

		PartDefinition LeftForArm26 = LeftArm26.addOrReplaceChild("LeftForArm26", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r137 = LeftForArm26.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition twistedleg2J = twitstedleg2.addOrReplaceChild("twistedleg2J", CubeListBuilder.create(), PartPose.offset(12.1961F, 40.7169F, -0.4382F));

		PartDefinition cube_r138 = twistedleg2J.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(144, 275).addBox(-4.5938F, 2.0916F, -7.9573F, 8.0F, 38.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 6.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition body23 = twitstedleg2.addOrReplaceChild("body23", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(14.4478F, 45.1899F, 0.0F, -2.5297F, -1.513F, 1.2464F));

		PartDefinition cube_r139 = body23.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head20 = body23.addOrReplaceChild("head20", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.9163F, 0.0F, 0.0F));

		PartDefinition RightArm22 = body23.addOrReplaceChild("RightArm22", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.7063F, -0.5543F, 1.9093F));

		PartDefinition RightForArm22 = RightArm22.addOrReplaceChild("RightForArm22", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm21 = body23.addOrReplaceChild("LeftArm21", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.7555F, 0.5162F, -1.9834F));

		PartDefinition LeftForArm21 = LeftArm21.addOrReplaceChild("LeftForArm21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r140 = LeftForArm21.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body24 = twitstedleg2.addOrReplaceChild("body24", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(25.4478F, 49.1899F, 3.0F, -0.0406F, -0.6142F, -1.2607F));

		PartDefinition cube_r141 = body24.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head21 = body24.addOrReplaceChild("head21", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.0F, -0.6981F, 0.0F));

		PartDefinition RightArm23 = body24.addOrReplaceChild("RightArm23", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.7063F, -0.5543F, 1.9093F));

		PartDefinition RightForArm23 = RightArm23.addOrReplaceChild("RightForArm23", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm22 = body24.addOrReplaceChild("LeftArm22", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.7555F, 0.5162F, -1.9834F));

		PartDefinition LeftForArm22 = LeftArm22.addOrReplaceChild("LeftForArm22", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r142 = LeftForArm22.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body25 = twitstedleg2.addOrReplaceChild("body25", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(41.4478F, 56.1899F, 0.0F, -2.291F, 1.499F, -0.4307F));

		PartDefinition cube_r143 = body25.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head22 = body25.addOrReplaceChild("head22", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.9163F, 0.0F, 0.0F));

		PartDefinition RightArm24 = body25.addOrReplaceChild("RightArm24", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.4552F, 1.0347F, -2.4682F));

		PartDefinition RightForArm24 = RightArm24.addOrReplaceChild("RightForArm24", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm23 = body25.addOrReplaceChild("LeftArm23", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 1.123F, -0.9808F, 2.8745F));

		PartDefinition LeftForArm23 = LeftArm23.addOrReplaceChild("LeftForArm23", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r144 = LeftForArm23.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition flower13 = twitstedleg2.addOrReplaceChild("flower13", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5522F, 13.6899F, -3.25F, 0.0F, 1.2654F, -0.5672F));

		PartDefinition cube_r145 = flower13.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower14 = twitstedleg2.addOrReplaceChild("flower14", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4478F, 28.6899F, 0.75F, 3.1416F, 1.4399F, 2.5744F));

		PartDefinition cube_r146 = flower14.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower15 = twitstedleg2.addOrReplaceChild("flower15", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.4478F, 28.6899F, -2.25F, 3.1416F, 0.7854F, 2.5744F));

		PartDefinition cube_r147 = flower15.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition twitstedleg = leg2.addOrReplaceChild("twitstedleg", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.4478F, 2.8101F, 16.0F, 0.9516F, 0.2464F, 0.7319F));

		PartDefinition cube_r148 = twitstedleg.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(257, 235).addBox(-82.4416F, 24.6953F, -77.1587F, 7.0F, 50.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(62.611F, -56.3665F, 71.8928F, 0.0F, 0.0F, -0.4363F));

		PartDefinition twistedLegJ = twitstedleg.addOrReplaceChild("twistedLegJ", CubeListBuilder.create(), PartPose.offsetAndRotation(10.8937F, 44.9473F, 13.6416F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r149 = twistedLegJ.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(0, 287).addBox(-98.6601F, 50.5391F, -75.6587F, 6.0F, 38.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.7173F, -101.3139F, 58.2512F, 0.0F, 0.0F, -0.6981F));

		PartDefinition body20 = twistedLegJ.addOrReplaceChild("body20", CubeListBuilder.create().texOffs(196, 206).addBox(5.6047F, 2.0347F, -17.3041F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(18.0F, 25.0F, -29.0F, 3.0342F, -0.0749F, -0.6068F));

		PartDefinition cube_r150 = body20.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.1047F, -2.4653F, -14.8041F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head17 = body20.addOrReplaceChild("head17", CubeListBuilder.create().texOffs(287, 233).addBox(5.1047F, -10.4653F, -18.8041F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(5.1047F, -4.4653F, -14.8041F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(5.1047F, -4.4653F, -18.8041F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 5.0F, 1.25F, -0.2061F, 0.5576F, -0.1102F));

		PartDefinition RightArm19 = body20.addOrReplaceChild("RightArm19", CubeListBuilder.create().texOffs(306, 324).addBox(7.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -9.0F, -2.1359F, 1.0663F, -0.0704F));

		PartDefinition RightForArm19 = RightArm19.addOrReplaceChild("RightForArm19", CubeListBuilder.create().texOffs(323, 272).addBox(7.1047F, -2.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm18 = body20.addOrReplaceChild("LeftArm18", CubeListBuilder.create().texOffs(84, 287).addBox(8.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 13.0F, -19.0F, -0.9891F, -1.2772F, -1.3562F));

		PartDefinition LeftForArm18 = LeftArm18.addOrReplaceChild("LeftForArm18", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r151 = LeftForArm18.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(44.1047F, -8.4653F, -14.8041F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body21 = twistedLegJ.addOrReplaceChild("body21", CubeListBuilder.create().texOffs(196, 206).addBox(5.6047F, 2.0347F, -17.3041F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(27.0F, 4.0F, 0.0F, -0.3287F, -0.0986F, 2.516F));

		PartDefinition cube_r152 = body21.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(48.1047F, -2.4653F, -14.8041F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head18 = body21.addOrReplaceChild("head18", CubeListBuilder.create().texOffs(287, 233).addBox(5.1047F, -10.4653F, -18.8041F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(5.1047F, -4.4653F, -18.8041F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r153 = head18.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(118, 225).addBox(-44.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.1047F, -2.4653F, -14.8041F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightArm20 = body21.addOrReplaceChild("RightArm20", CubeListBuilder.create().texOffs(306, 324).addBox(7.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.0F, -19.0F, 1.2537F, -1.2191F, -1.2614F));

		PartDefinition RightForArm20 = RightArm20.addOrReplaceChild("RightForArm20", CubeListBuilder.create().texOffs(323, 272).addBox(7.1047F, -2.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm19 = body21.addOrReplaceChild("LeftArm19", CubeListBuilder.create().texOffs(84, 287).addBox(8.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 7.0F, 0.0F, 1.884F, 1.3653F, 1.7632F));

		PartDefinition LeftForArm19 = LeftArm19.addOrReplaceChild("LeftForArm19", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r154 = LeftForArm19.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(44.1047F, -8.4653F, -14.8041F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body27 = twitstedleg.addOrReplaceChild("body27", CubeListBuilder.create(), PartPose.offset(13.3414F, 46.1372F, 10.6416F));

		PartDefinition cube_r155 = body27.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(196, 206).addBox(-43.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(57.0F, -9.0F, -20.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r156 = body27.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(49.1047F, -2.4653F, -14.8041F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head24 = body27.addOrReplaceChild("head24", CubeListBuilder.create().texOffs(287, 233).addBox(5.1047F, -10.4653F, -18.8041F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(5.1047F, -4.4653F, -14.8041F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(5.1047F, -4.4653F, -18.8041F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightArm26 = body27.addOrReplaceChild("RightArm26", CubeListBuilder.create().texOffs(306, 324).addBox(7.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.1604F, 1.5111F, 2.5044F));

		PartDefinition RightForArm26 = RightArm26.addOrReplaceChild("RightForArm26", CubeListBuilder.create().texOffs(323, 272).addBox(7.1047F, -2.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm25 = body27.addOrReplaceChild("LeftArm25", CubeListBuilder.create().texOffs(84, 287).addBox(8.1047F, -4.4653F, -16.3041F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -16.0F, -19.0F, 1.908F, -0.5358F, 1.131F));

		PartDefinition LeftForArm25 = LeftArm25.addOrReplaceChild("LeftForArm25", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r157 = LeftForArm25.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(44.1047F, -8.4653F, -14.8041F, -0.0873F, 0.0F, 0.0F));

		PartDefinition flower16 = twitstedleg.addOrReplaceChild("flower16", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.4478F, 35.6899F, -3.25F, 0.0F, 1.3526F, -0.5672F));

		PartDefinition cube_r158 = flower16.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower17 = twitstedleg.addOrReplaceChild("flower17", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.4478F, 20.6899F, -3.25F, 0.0F, 0.6981F, -0.5672F));

		PartDefinition cube_r159 = flower17.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower18 = twitstedleg.addOrReplaceChild("flower18", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.4478F, 24.6899F, 3.75F, 0.0F, -3.098F, -0.5672F));

		PartDefinition cube_r160 = flower18.addOrReplaceChild("cube_r160", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower10 = LeftLeg.addOrReplaceChild("flower10", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -2.5F, -6.25F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r161 = flower10.addOrReplaceChild("cube_r161", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower11 = LeftLeg.addOrReplaceChild("flower11", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, -21.5F, 5.75F, 0.0F, 0.0F, -1.2654F));

		PartDefinition cube_r162 = flower11.addOrReplaceChild("cube_r162", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower12 = LeftLeg.addOrReplaceChild("flower12", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.5F, 5.75F, 0.0F, 0.0F, -0.9599F));

		PartDefinition cube_r163 = flower12.addOrReplaceChild("cube_r163", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, -16.0F));

		PartDefinition cube_r164 = jaw.addOrReplaceChild("cube_r164", CubeListBuilder.create().texOffs(260, 35).addBox(-3.0F, 10.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -37.1577F, -46.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition Head_r5 = jaw.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(298, 209).addBox(15.0F, -13.0F, -20.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(72, 277).addBox(15.0F, -7.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -1.2654F, -3.1416F));

		PartDefinition Head_r6 = jaw.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(295, 107).addBox(11.0F, -10.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(170, 300).addBox(11.0F, -16.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -0.7418F, -3.1416F));

		PartDefinition Head_r7 = jaw.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(298, 223).addBox(-13.0F, -8.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(76, 301).addBox(-13.0F, -14.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, 1.2654F, -3.1416F));

		PartDefinition Head_r8 = jaw.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(236, 35).addBox(-4.0F, -10.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(108, 301).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, 0.4363F, -3.1416F));

		PartDefinition cube_r165 = jaw.addOrReplaceChild("cube_r165", CubeListBuilder.create().texOffs(48, 262).addBox(-10.0F, -12.0F, -8.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, -15.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r166 = jaw.addOrReplaceChild("cube_r166", CubeListBuilder.create().texOffs(211, 119).addBox(-11.0F, -21.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 26.0F, 3.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.0F, -7.0F, 77.0F, 1.0908F, -0.3491F, 0.0F));

		PartDefinition legback3 = BackRightLeg.addOrReplaceChild("legback3", CubeListBuilder.create().texOffs(136, 0).addBox(-5.0F, -6.0F, -5.0F, 13.0F, 16.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offset(-9.0F, -32.0F, -32.0F));

		PartDefinition bloomingFungus8 = legback3.addOrReplaceChild("bloomingFungus8", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 0.0F, 21.0F, 0.3054F, 0.0F, -1.5708F));

		PartDefinition cube_r167 = bloomingFungus8.addOrReplaceChild("cube_r167", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r168 = bloomingFungus8.addOrReplaceChild("cube_r168", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r169 = bloomingFungus8.addOrReplaceChild("cube_r169", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r170 = bloomingFungus8.addOrReplaceChild("cube_r170", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r171 = bloomingFungus8.addOrReplaceChild("cube_r171", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r172 = bloomingFungus8.addOrReplaceChild("cube_r172", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition BackRightLeg2 = legback3.addOrReplaceChild("BackRightLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 7.0F, 58.0F, -2.2253F, 0.0F, 0.0F));

		PartDefinition legback4 = BackRightLeg2.addOrReplaceChild("legback4", CubeListBuilder.create(), PartPose.offset(2.0F, 24.0F, 10.0F));

		PartDefinition cube_r173 = legback4.addOrReplaceChild("cube_r173", CubeListBuilder.create().texOffs(145, 159).addBox(-15.0F, -19.0F, 39.0F, 14.0F, 14.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -24.0F, -10.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r174 = legback4.addOrReplaceChild("cube_r174", CubeListBuilder.create().texOffs(66, 117).addBox(-3.0F, 23.0F, -7.0F, 10.0F, 10.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -24.0F, -10.0F, 0.5444F, -0.2635F, -0.1564F));

		PartDefinition body35 = legback4.addOrReplaceChild("body35", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-9.5F, -14.0F, 59.0F, -1.5298F, -0.0439F, -3.1285F));

		PartDefinition cube_r175 = body35.addOrReplaceChild("cube_r175", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head32 = body35.addOrReplaceChild("head32", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm34 = body35.addOrReplaceChild("RightArm34", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition RightForArm34 = RightArm34.addOrReplaceChild("RightForArm34", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm33 = body35.addOrReplaceChild("LeftArm33", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3244F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm33 = LeftArm33.addOrReplaceChild("LeftForArm33", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r176 = LeftForArm33.addOrReplaceChild("cube_r176", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body36 = legback4.addOrReplaceChild("body36", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-16.5F, -6.0F, 56.0F, -1.5332F, 0.442F, 1.3819F));

		PartDefinition cube_r177 = body36.addOrReplaceChild("cube_r177", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head33 = body36.addOrReplaceChild("head33", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm35 = body36.addOrReplaceChild("RightArm35", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.5236F, 0.0F, 0.4363F));

		PartDefinition RightForArm35 = RightArm35.addOrReplaceChild("RightForArm35", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm34 = body36.addOrReplaceChild("LeftArm34", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2406F, 0.6432F, -0.2507F));

		PartDefinition LeftForArm34 = LeftArm34.addOrReplaceChild("LeftForArm34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r178 = LeftForArm34.addOrReplaceChild("cube_r178", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body37 = legback4.addOrReplaceChild("body37", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5F, -6.0F, 55.0F, -1.9314F, -0.3638F, -1.5328F));

		PartDefinition cube_r179 = body37.addOrReplaceChild("cube_r179", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head34 = body37.addOrReplaceChild("head34", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm36 = body37.addOrReplaceChild("RightArm36", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.9F, -0.3446F, 0.8388F));

		PartDefinition RightForArm36 = RightArm36.addOrReplaceChild("RightForArm36", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm35 = body37.addOrReplaceChild("LeftArm35", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -2.9035F, -0.4605F, 0.9355F));

		PartDefinition LeftForArm35 = LeftArm35.addOrReplaceChild("LeftForArm35", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r180 = LeftForArm35.addOrReplaceChild("cube_r180", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body38 = legback4.addOrReplaceChild("body38", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-9.5F, -23.0F, 31.0F, -2.1843F, -0.0439F, -3.1285F));

		PartDefinition cube_r181 = body38.addOrReplaceChild("cube_r181", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head35 = body38.addOrReplaceChild("head35", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm37 = body38.addOrReplaceChild("RightArm37", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.6545F, 0.0F, 0.4363F));

		PartDefinition RightForArm37 = RightArm37.addOrReplaceChild("RightForArm37", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm36 = body38.addOrReplaceChild("LeftArm36", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -0.6355F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm36 = LeftArm36.addOrReplaceChild("LeftForArm36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r182 = LeftForArm36.addOrReplaceChild("cube_r182", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body39 = legback4.addOrReplaceChild("body39", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.5F, 2.0F, -4.0F, 2.404F, 0.0796F, 0.0383F));

		PartDefinition cube_r183 = body39.addOrReplaceChild("cube_r183", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head36 = body39.addOrReplaceChild("head36", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.9599F, 0.0F, 0.0F));

		PartDefinition RightArm38 = body39.addOrReplaceChild("RightArm38", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.6545F, 0.0F, 0.4363F));

		PartDefinition RightForArm38 = RightArm38.addOrReplaceChild("RightForArm38", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm37 = body39.addOrReplaceChild("LeftArm37", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -0.6306F, -0.1563F, -0.7569F));

		PartDefinition LeftForArm37 = LeftArm37.addOrReplaceChild("LeftForArm37", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r184 = LeftForArm37.addOrReplaceChild("cube_r184", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body40 = legback4.addOrReplaceChild("body40", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5F, -9.0F, 11.0F, -1.9987F, 0.1315F, -2.8778F));

		PartDefinition cube_r185 = body40.addOrReplaceChild("cube_r185", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head37 = body40.addOrReplaceChild("head37", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm39 = body40.addOrReplaceChild("RightArm39", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, 0.0F, 0.4363F));

		PartDefinition RightForArm39 = RightArm39.addOrReplaceChild("RightForArm39", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm38 = body40.addOrReplaceChild("LeftArm38", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.3337F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm38 = LeftArm38.addOrReplaceChild("LeftForArm38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r186 = LeftForArm38.addOrReplaceChild("cube_r186", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition flower25 = legback4.addOrReplaceChild("flower25", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -15.5F, 38.75F, -1.1803F, 0.6599F, 1.818F));

		PartDefinition cube_r187 = flower25.addOrReplaceChild("cube_r187", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower26 = legback4.addOrReplaceChild("flower26", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.5F, -15.5F, 38.75F, -1.1735F, 0.7435F, 1.8236F));

		PartDefinition cube_r188 = flower26.addOrReplaceChild("cube_r188", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower23 = legback3.addOrReplaceChild("flower23", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.5F, 9.75F, -1.2471F, -0.3323F, 1.4618F));

		PartDefinition cube_r189 = flower23.addOrReplaceChild("cube_r189", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower24 = legback3.addOrReplaceChild("flower24", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 7.5F, 23.75F, -1.2471F, -0.3323F, 1.4618F));

		PartDefinition cube_r190 = flower24.addOrReplaceChild("cube_r190", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, -7.0F, 77.0F, 1.0908F, 0.3491F, 0.0F));

		PartDefinition legback = BackLeftLeg.addOrReplaceChild("legback", CubeListBuilder.create().texOffs(72, 184).addBox(-6.0F, -7.0F, -3.0F, 15.0F, 19.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, -31.0F, -31.0F));

		PartDefinition cube_r191 = legback.addOrReplaceChild("cube_r191", CubeListBuilder.create().texOffs(118, 85).addBox(-5.0F, -5.0F, 3.0F, 13.0F, 14.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 39.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r192 = legback.addOrReplaceChild("cube_r192", CubeListBuilder.create().texOffs(109, 76).addBox(-5.0F, -5.0F, 0.0F, 13.0F, 14.0F, 27.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 1.0F, 17.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition body33 = legback.addOrReplaceChild("body33", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.0F, -5.0F, 57.0F, 0.6939F, 0.0964F, -0.0887F));

		PartDefinition cube_r193 = body33.addOrReplaceChild("cube_r193", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head30 = body33.addOrReplaceChild("head30", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.3535F, 0.0338F, 0.2597F));

		PartDefinition RightArm32 = body33.addOrReplaceChild("RightArm32", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.0547F, -0.0227F, 0.9581F));

		PartDefinition RightForArm32 = RightArm32.addOrReplaceChild("RightForArm32", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm31 = body33.addOrReplaceChild("LeftArm31", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.1059F, 0.5983F, -2.1513F));

		PartDefinition LeftForArm31 = LeftArm31.addOrReplaceChild("LeftForArm31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r194 = LeftForArm31.addOrReplaceChild("cube_r194", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body34 = legback.addOrReplaceChild("body34", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(9.0F, -5.0F, 32.0F, 1.0925F, 0.7713F, 0.7628F));

		PartDefinition cube_r195 = body34.addOrReplaceChild("cube_r195", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head31 = body34.addOrReplaceChild("head31", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.3535F, 0.0338F, 0.2597F));

		PartDefinition RightArm33 = body34.addOrReplaceChild("RightArm33", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.0547F, -0.0227F, 0.9581F));

		PartDefinition RightForArm33 = RightArm33.addOrReplaceChild("RightForArm33", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm32 = body34.addOrReplaceChild("LeftArm32", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.1059F, 0.5983F, -2.1513F));

		PartDefinition LeftForArm32 = LeftArm32.addOrReplaceChild("LeftForArm32", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r196 = LeftForArm32.addOrReplaceChild("cube_r196", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition BackLeftLeg2 = legback.addOrReplaceChild("BackLeftLeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 9.0F, 62.0F, -2.2253F, 0.0F, 0.0F));

		PartDefinition legback2 = BackLeftLeg2.addOrReplaceChild("legback2", CubeListBuilder.create(), PartPose.offset(3.0F, 7.0F, 0.0F));

		PartDefinition cube_r197 = legback2.addOrReplaceChild("cube_r197", CubeListBuilder.create().texOffs(0, 159).addBox(-1.0F, -21.0F, 25.0F, 10.0F, 10.0F, 37.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.0F, -1.533F, 5.4673F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r198 = legback2.addOrReplaceChild("cube_r198", CubeListBuilder.create().texOffs(25, 128).addBox(-2.0F, -1.0F, -7.0F, 10.0F, 10.0F, 21.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.0F, -7.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r199 = legback2.addOrReplaceChild("cube_r199", CubeListBuilder.create().texOffs(21, 124).addBox(-2.0F, -1.0F, 14.0F, 10.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -16.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition body29 = legback2.addOrReplaceChild("body29", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5F, 2.0F, 62.0F, 0.8248F, 0.0964F, -0.0887F));

		PartDefinition cube_r200 = body29.addOrReplaceChild("cube_r200", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head26 = body29.addOrReplaceChild("head26", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.1265F, 0.0338F, 0.2597F));

		PartDefinition RightArm28 = body29.addOrReplaceChild("RightArm28", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.1184F, -0.9902F, -0.0733F));

		PartDefinition RightForArm28 = RightArm28.addOrReplaceChild("RightForArm28", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm27 = body29.addOrReplaceChild("LeftArm27", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.8555F, 0.9705F, 0.093F));

		PartDefinition LeftForArm27 = LeftArm27.addOrReplaceChild("LeftForArm27", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r201 = LeftForArm27.addOrReplaceChild("cube_r201", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body30 = legback2.addOrReplaceChild("body30", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5F, 10.0F, 57.0F, 2.2253F, 0.0F, -3.1416F));

		PartDefinition cube_r202 = body30.addOrReplaceChild("cube_r202", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head27 = body30.addOrReplaceChild("head27", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6378F, -0.1582F, -0.2095F));

		PartDefinition RightArm29 = body30.addOrReplaceChild("RightArm29", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition RightForArm29 = RightArm29.addOrReplaceChild("RightForArm29", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm28 = body30.addOrReplaceChild("LeftArm28", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3244F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm28 = LeftArm28.addOrReplaceChild("LeftForArm28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r203 = LeftForArm28.addOrReplaceChild("cube_r203", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body31 = legback2.addOrReplaceChild("body31", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(3.5F, -6.0F, 41.0F, 0.8939F, 0.3548F, 0.2157F));

		PartDefinition cube_r204 = body31.addOrReplaceChild("cube_r204", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head28 = body31.addOrReplaceChild("head28", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.1265F, 0.0338F, 0.2597F));

		PartDefinition RightArm30 = body31.addOrReplaceChild("RightArm30", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.8261F, -1.2092F, 0.2523F));

		PartDefinition RightForArm30 = RightArm30.addOrReplaceChild("RightForArm30", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm29 = body31.addOrReplaceChild("LeftArm29", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.9649F, 0.24F, -2.3289F));

		PartDefinition LeftForArm29 = LeftArm29.addOrReplaceChild("LeftForArm29", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r205 = LeftForArm29.addOrReplaceChild("cube_r205", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body32 = legback2.addOrReplaceChild("body32", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-7.5F, -13.0F, 22.0F, 1.5609F, -0.751F, -1.7488F));

		PartDefinition cube_r206 = body32.addOrReplaceChild("cube_r206", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head29 = body32.addOrReplaceChild("head29", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, 0.6589F, 0.0338F, 0.2597F));

		PartDefinition RightArm31 = body32.addOrReplaceChild("RightArm31", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -0.2615F, 0.1668F, 1.0666F));

		PartDefinition RightForArm31 = RightArm31.addOrReplaceChild("RightForArm31", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm30 = body32.addOrReplaceChild("LeftArm30", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.8003F, 0.7139F, -2.0738F));

		PartDefinition LeftForArm30 = LeftArm30.addOrReplaceChild("LeftForArm30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r207 = LeftForArm30.addOrReplaceChild("cube_r207", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus7 = BackLeftLeg2.addOrReplaceChild("bloomingFungus7", CubeListBuilder.create(), PartPose.offsetAndRotation(7.25F, -4.0F, 13.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r208 = bloomingFungus7.addOrReplaceChild("cube_r208", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r209 = bloomingFungus7.addOrReplaceChild("cube_r209", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r210 = bloomingFungus7.addOrReplaceChild("cube_r210", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r211 = bloomingFungus7.addOrReplaceChild("cube_r211", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r212 = bloomingFungus7.addOrReplaceChild("cube_r212", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r213 = bloomingFungus7.addOrReplaceChild("cube_r213", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition bloomingFungus6 = legback.addOrReplaceChild("bloomingFungus6", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.25F, 5.0F, 39.0F, -0.1239F, 0.3736F, -2.1178F));

		PartDefinition cube_r214 = bloomingFungus6.addOrReplaceChild("cube_r214", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r215 = bloomingFungus6.addOrReplaceChild("cube_r215", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r216 = bloomingFungus6.addOrReplaceChild("cube_r216", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r217 = bloomingFungus6.addOrReplaceChild("cube_r217", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r218 = bloomingFungus6.addOrReplaceChild("cube_r218", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r219 = bloomingFungus6.addOrReplaceChild("cube_r219", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower19 = legback.addOrReplaceChild("flower19", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 5.5F, 7.75F, -1.5708F, 0.1309F, -1.5708F));

		PartDefinition cube_r220 = flower19.addOrReplaceChild("cube_r220", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower20 = legback.addOrReplaceChild("flower20", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.5F, 21.75F, -1.5708F, 0.1309F, -1.5708F));

		PartDefinition cube_r221 = flower20.addOrReplaceChild("cube_r221", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower21 = legback.addOrReplaceChild("flower21", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 5.5F, 15.75F, -1.5708F, 0.1309F, -1.5708F));

		PartDefinition cube_r222 = flower21.addOrReplaceChild("cube_r222", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower22 = legback.addOrReplaceChild("flower22", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -0.5F, 47.75F, -1.5708F, 0.1309F, -1.5708F));

		PartDefinition cube_r223 = flower22.addOrReplaceChild("cube_r223", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTentacleY(RightLegJointY,Mth.cos(limbSwing * 0.2F) * 0.5F * limbSwingAmount);
		animateTentacleY(LeftLegJointY,Mth.cos(limbSwing * 0.4F) * -0.5F * limbSwingAmount);
		animateTentacleX(RightLegForLeg,RightLegJointY.yRot*1.5f);
		animateTentacleZ(LeftLegForleg1,-LeftLegJointY.yRot);
		animateTentacleZ(LeftLegForleg2,LeftLegJointY.yRot);
		animateTentacleX(BackRightForLeg,Mth.cos(limbSwing * 0.4F) * -0.4F * limbSwingAmount);
		animateTentacleX(BackRightForLeg2,-BackRightForLeg.xRot);
		animateTentacleX(BackLeftForLeg,-Mth.cos(limbSwing * 0.3F) * -0.3F * limbSwingAmount);
		animateTentacleX(BackLeftForLeg2,-BackRightForLeg.xRot);
		animateTentacleY(smolleg,Mth.sin(limbSwing * 0.5F) * -0.5F * limbSwingAmount);
		animateTentacleX(jaw,Mth.sin(ageInTicks/8)/10);
		if (entity.getTailHp() > 0){
			this.tail.visible = true;
			float value = Mth.sin(ageInTicks/8)/10;
			animateTentacleX(tail,value);
			animateTentacleX(tail2,value);
			animateTentacleX(tail3,value);
			animateTentacleX(tail4,value);
			animateTumor(tailTumor1,Mth.sin(ageInTicks/7)/6);
			animateTumor(tailTumor2,Mth.cos(ageInTicks/6)/9);
			animateTumor(tailTumor3,-Mth.sin(ageInTicks/7)/8);
		}else {
			this.tail.visible = false;
		}
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