package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
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

public class InquisitorModel<T extends Inquisitor> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "inquisitor"), "main");
	private final ModelPart KnightHyper;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart Arm;
	private final ModelPart ForArm;
	private final ModelPart Claw1;
	private final ModelPart Claw2;
	private final ModelPart Claw3;
	private final ModelPart Claw4;

	public InquisitorModel(ModelPart root) {
		this.KnightHyper = root.getChild("KnightHyper");
		this.LeftLeg = KnightHyper.getChild("Legs").getChild("LeftLeg");
		this.RightLeg = KnightHyper.getChild("Legs").getChild("RightLeg");
		this.RightForLeg = RightLeg.getChild("RightLegSeg2");
		this.LeftForLeg = LeftLeg.getChild("LeftLegSeg2");
		this.Arm = KnightHyper.getChild("Torso").getChild("UpperTorso").getChild("RightArm");
		this.ForArm = Arm.getChild("RightArmSeg2");
		this.Claw1 = ForArm.getChild("RightArmClaw").getChild("Claw1");
		this.Claw2 = ForArm.getChild("RightArmClaw").getChild("Claw2");
		this.Claw3 = ForArm.getChild("RightArmClaw").getChild("Claw3");
		this.Claw4 = ForArm.getChild("RightArmClaw").getChild("Claw4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition KnightHyper = partdefinition.addOrReplaceChild("KnightHyper", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = KnightHyper.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(31, 8).addBox(-5.5F, -5.5F, -2.5F, 11.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, -17.5F, 0.0F));

		PartDefinition LowerTorsoGrowth = Torso.addOrReplaceChild("LowerTorsoGrowth", CubeListBuilder.create().texOffs(26, 39).addBox(1.0F, -10.0F, -3.0F, 6.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(49, 48).addBox(3.0F, -2.0F, -2.85F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(54, 54).addBox(-3.0F, -6.0F, 2.95F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 54).addBox(-7.0F, -4.0F, 3.15F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 54).addBox(-6.5F, -6.5F, 2.65F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 57).addBox(-3.25F, -6.5F, -2.45F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 1.5F, -0.5F));

		PartDefinition GrowthSeg7_r1 = LowerTorsoGrowth.addOrReplaceChild("GrowthSeg7_r1", CubeListBuilder.create().texOffs(50, 57).addBox(-3.0F, -2.0F, -0.5F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -2.5F, -1.85F, 0.0F, 0.0F, 0.1309F));

		PartDefinition GrowthSeg1_r1 = LowerTorsoGrowth.addOrReplaceChild("GrowthSeg1_r1", CubeListBuilder.create().texOffs(46, 48).addBox(-1.0F, -8.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerTorsoGrowthFungus = LowerTorsoGrowth.addOrReplaceChild("LowerTorsoGrowthFungus", CubeListBuilder.create(), PartPose.offset(-11.25F, 16.0F, 0.5F));

		PartDefinition FungalPlanes_r1 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r1", CubeListBuilder.create().texOffs(-7, 63).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9934F, -21.1492F, -3.0F, 0.0F, -0.3491F, -0.2182F));

		PartDefinition FungalPlanes_r2 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r2", CubeListBuilder.create().texOffs(-7, 63).addBox(-3.0F, -25.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.2182F));

		PartDefinition FungalPlanes_r3 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r3", CubeListBuilder.create().texOffs(-7, 49).addBox(-2.0F, -21.0F, -6.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(-7, 63).addBox(-6.0F, -18.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.2182F));

		PartDefinition FungalPlanes_r4 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r4", CubeListBuilder.create().texOffs(-7, 56).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9394F, -20.9556F, 4.0847F, -0.257F, 0.5522F, 0.0811F));

		PartDefinition FungalPlanes_r5 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r5", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.444F, -23.2317F, 2.8091F, -0.2284F, -0.298F, 0.2863F));

		PartDefinition FungalPlanes_r6 = LowerTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r6", CubeListBuilder.create().texOffs(-7, 56).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.1467F, -15.6184F, -2.0F, 0.0F, 0.3054F, -0.2182F));

		PartDefinition LowerTGrowthFungalPlate = LowerTorsoGrowth.addOrReplaceChild("LowerTGrowthFungalPlate", CubeListBuilder.create().texOffs(22, 57).mirror().addBox(-0.2469F, -1.6942F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(28, 44).mirror().addBox(7.1531F, -1.1942F, -5.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(34, 51).mirror().addBox(-0.2469F, -1.2042F, -6.4F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false)
		.texOffs(34, 51).mirror().addBox(-0.2469F, -1.2042F, 2.4F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(3.2826F, -4.9988F, 1.5267F, 0.2618F, 0.0F, 0.2618F));

		PartDefinition UpperTorso = Torso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -7.0F, -3.0F, 12.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.5F, 0.0F));

		PartDefinition UpperTorsoGrowth = UpperTorso.addOrReplaceChild("UpperTorsoGrowth", CubeListBuilder.create().texOffs(48, 48).addBox(11.4389F, -7.7352F, -4.251F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -1.0F, 0.0F));

		PartDefinition GrowthSeg4_r1 = UpperTorsoGrowth.addOrReplaceChild("GrowthSeg4_r1", CubeListBuilder.create().texOffs(27, 22).addBox(-1.5F, -7.5F, -3.5F, 3.0F, 9.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5F, -8.5F, -0.75F, 0.0F, 0.0F, -0.4363F));

		PartDefinition GrowthSeg3_r1 = UpperTorsoGrowth.addOrReplaceChild("GrowthSeg3_r1", CubeListBuilder.create().texOffs(47, 48).addBox(-2.5F, -3.5F, -3.5F, 4.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -8.5F, -0.75F, 0.0F, 0.2618F, 0.0F));

		PartDefinition GrowthSeg2_r1 = UpperTorsoGrowth.addOrReplaceChild("GrowthSeg2_r1", CubeListBuilder.create().texOffs(46, 48).addBox(-4.0F, -3.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition GrowthSeg1_r2 = UpperTorsoGrowth.addOrReplaceChild("GrowthSeg1_r2", CubeListBuilder.create().texOffs(24, 21).addBox(-4.0F, -6.0F, -4.0F, 5.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -1.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition UpperTorsoGrowthFungus = UpperTorsoGrowth.addOrReplaceChild("UpperTorsoGrowthFungus", CubeListBuilder.create(), PartPose.offset(10.25F, 24.0F, 0.0F));

		PartDefinition FungalPlanes_r7 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r7", CubeListBuilder.create().texOffs(-7, 63).addBox(4.0F, -20.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition FungalPlanes_r8 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r8", CubeListBuilder.create().texOffs(-7, 49).addBox(-4.5F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9114F, -32.3546F, 2.4821F, -0.202F, -0.0829F, -0.1661F));

		PartDefinition FungalPlanes_r9 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r9", CubeListBuilder.create().texOffs(-7, 56).addBox(-3.5F, 0.0F, -5.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0425F, -28.3255F, -1.6163F, 0.2449F, 0.4677F, 0.3304F));

		PartDefinition FungalPlanes_r10 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r10", CubeListBuilder.create().texOffs(-7, 63).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4097F, -25.9092F, -2.9196F, -0.1309F, 0.0F, 0.2182F));

		PartDefinition FungalPlanes_r11 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r11", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7107F, -36.5075F, -2.1551F, 0.2449F, 0.4677F, 0.3304F));

		PartDefinition FungalPlanes_r12 = UpperTorsoGrowthFungus.addOrReplaceChild("FungalPlanes_r12", CubeListBuilder.create().texOffs(-7, 56).addBox(-2.75F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1467F, -23.6184F, 2.0F, 0.0F, -0.7854F, -0.2182F));

		PartDefinition UpperTGrowthFungalPlate = UpperTorsoGrowth.addOrReplaceChild("UpperTGrowthFungalPlate", CubeListBuilder.create().texOffs(22, 57).mirror().addBox(-0.2469F, -1.6942F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(28, 44).mirror().addBox(7.3531F, -1.1942F, -5.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 51).mirror().addBox(-0.2469F, -1.2042F, -6.6F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(34, 51).mirror().addBox(-0.2469F, -1.2042F, 2.6F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(10.9685F, -2.5551F, 0.3096F, -0.3491F, 0.0F, -0.2618F));

		PartDefinition RightArm = UpperTorso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 75).addBox(-4.75F, -2.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.25F, -5.0F, 0.0F));

		PartDefinition ShoulderPad = RightArm.addOrReplaceChild("ShoulderPad", CubeListBuilder.create().texOffs(50, 53).addBox(-2.0F, 1.75F, -3.51F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.75F, -2.0F, 0.5F));

		PartDefinition Fungus_r1 = ShoulderPad.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.183F, 4.5485F, -1.3507F, -0.3563F, -0.3651F, 0.2993F));

		PartDefinition PadBack_r1 = ShoulderPad.addOrReplaceChild("PadBack_r1", CubeListBuilder.create().texOffs(53, 48).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.75F, 1.76F, -0.0873F, 0.0F, 0.0F));

		PartDefinition PadFront_r1 = ShoulderPad.addOrReplaceChild("PadFront_r1", CubeListBuilder.create().texOffs(52, 51).addBox(-1.5F, -3.0F, -0.5F, 3.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 3.75F, -2.76F, -0.0436F, 0.0F, 0.0F));

		PartDefinition PadCenter_r1 = ShoulderPad.addOrReplaceChild("PadCenter_r1", CubeListBuilder.create().texOffs(47, 48).addBox(-2.25F, -1.0F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.75F, -0.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(82, 87).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(84, 46).addBox(-2.5F, -0.01F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, 6.0F, 0.0F));

		PartDefinition RightArmClaw = RightArmSeg2.addOrReplaceChild("RightArmClaw", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Claw1 = RightArmClaw.addOrReplaceChild("Claw1", CubeListBuilder.create().texOffs(44, 93).addBox(-4.75F, -3.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition Claw2 = RightArmClaw.addOrReplaceChild("Claw2", CubeListBuilder.create().texOffs(44, 93).addBox(-5.25F, -2.5F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, -1.0F));

		PartDefinition Claw3 = RightArmClaw.addOrReplaceChild("Claw3", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, -1.0F));

		PartDefinition Claw3_r1 = Claw3.addOrReplaceChild("Claw3_r1", CubeListBuilder.create().texOffs(44, 87).mirror().addBox(1.5F, -2.0F, -2.0F, 0.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 0.0F, -1.25F, -2.8362F, 0.0F, 3.1416F));

		PartDefinition Claw4 = RightArmClaw.addOrReplaceChild("Claw4", CubeListBuilder.create(), PartPose.offset(1.0F, -2.0F, 0.0F));

		PartDefinition Claw4_r1 = Claw4.addOrReplaceChild("Claw4_r1", CubeListBuilder.create().texOffs(44, 87).addBox(0.0F, -2.0F, -4.0F, 0.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.25F, 0.3927F, 0.0F, 0.0873F));

		PartDefinition Head = UpperTorso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -7.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition Helmet = Head.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition HelmTopCenter_r1 = Helmet.addOrReplaceChild("HelmTopCenter_r1", CubeListBuilder.create().texOffs(1, 39).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.75F, 0.249F, 0.0F, -0.0873F, -0.1309F));

		PartDefinition HelmTopRight_r1 = Helmet.addOrReplaceChild("HelmTopRight_r1", CubeListBuilder.create().texOffs(2, 33).addBox(-1.0F, -0.5F, -3.75F, 4.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition HelmBackRightTorsoConnection_r1 = Helmet.addOrReplaceChild("HelmBackRightTorsoConnection_r1", CubeListBuilder.create().texOffs(3, 44).addBox(-3.4847F, -1.5046F, -0.9859F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0153F, 7.1046F, 2.8859F, -0.5236F, 0.0F, 0.1309F));

		PartDefinition HelmBackRight_r1 = Helmet.addOrReplaceChild("HelmBackRight_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, -7.0F, -5.0F, 7.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0237F, 3.4033F, 3.5019F, 0.0F, 0.0F, 0.1309F));

		PartDefinition HelmBackUpperLeft_r1 = Helmet.addOrReplaceChild("HelmBackUpperLeft_r1", CubeListBuilder.create().texOffs(9, 39).addBox(-2.0F, -6.0F, 0.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7737F, 1.4033F, 3.0019F, 0.0F, 0.4363F, 0.0F));

		PartDefinition HelmBackLowerLeft_r1 = Helmet.addOrReplaceChild("HelmBackLowerLeft_r1", CubeListBuilder.create().texOffs(0, 39).addBox(-3.0F, -2.0F, -1.0F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0237F, 3.4033F, 3.5019F, 0.0F, 0.2182F, -0.48F));

		PartDefinition HelmRightEyepatch_r1 = Helmet.addOrReplaceChild("HelmRightEyepatch_r1", CubeListBuilder.create().texOffs(61, 34).addBox(-1.0571F, -1.1944F, -0.9F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(1, 44).addBox(-2.0571F, -4.1944F, -0.9F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1429F, -0.0556F, -3.2F, 0.0F, 0.0F, 0.0F));

		PartDefinition HelmRightBase_r1 = Helmet.addOrReplaceChild("HelmRightBase_r1", CubeListBuilder.create().texOffs(3, 36).addBox(-1.0F, -3.5F, -1.5F, 2.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2737F, -0.0967F, -1.9981F, 0.0F, 0.0F, 0.0F));

		PartDefinition HelmFrontMiddleRight_r1 = Helmet.addOrReplaceChild("HelmFrontMiddleRight_r1", CubeListBuilder.create().texOffs(12, 35).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2737F, 0.4033F, -3.4981F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HelmJawRight_r1 = Helmet.addOrReplaceChild("HelmJawRight_r1", CubeListBuilder.create().texOffs(89, 34).mirror().addBox(-4.0F, -2.0434F, -1.2462F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4429F, 3.6944F, -3.1F, 0.1745F, 0.0F, 0.48F));

		PartDefinition HelmJawLeft_r1 = Helmet.addOrReplaceChild("HelmJawLeft_r1", CubeListBuilder.create().texOffs(89, 34).addBox(-4.0F, -1.0F, -0.5F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9733F, 2.2864F, -4.0F, 0.0F, 0.0873F, -0.48F));

		PartDefinition HelmCrest = Helmet.addOrReplaceChild("HelmCrest", CubeListBuilder.create().texOffs(0, 81).addBox(0.0436F, -6.4981F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2678F, -5.0444F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition RightFungus_r1 = HelmCrest.addOrReplaceChild("RightFungus_r1", CubeListBuilder.create().texOffs(0, 81).addBox(-2.0F, -4.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0382F, -1.6531F, -0.0436F, 0.0F, -0.1309F, -0.3491F));

		PartDefinition LeftFungus_r1 = HelmCrest.addOrReplaceChild("LeftFungus_r1", CubeListBuilder.create().texOffs(0, 81).mirror().addBox(-0.75F, -3.75F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0841F, -1.6531F, -0.0436F, -3.1416F, -0.1309F, -2.7925F));

		PartDefinition HelmExtraDetails = Helmet.addOrReplaceChild("HelmExtraDetails", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition FungalPlate1 = HelmExtraDetails.addOrReplaceChild("FungalPlate1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3034F, -2.9293F, 0.8665F, 0.0F, 0.2618F, 0.0436F));

		PartDefinition FungalRidgeEdge_r1 = FungalPlate1.addOrReplaceChild("FungalRidgeEdge_r1", CubeListBuilder.create().texOffs(34, 51).addBox(-5.0F, -1.51F, 2.75F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(34, 51).addBox(-5.0F, -1.51F, -6.75F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(28, 44).addBox(-5.75F, -1.5F, -5.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.25F))
		.texOffs(22, 57).addBox(-4.0F, -1.5F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7531F, 0.3058F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition FungalPlate2 = HelmExtraDetails.addOrReplaceChild("FungalPlate2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1402F, -1.2328F, 0.9948F, 0.0F, 0.5672F, -0.2618F));

		PartDefinition FungalRidgeEdge_r2 = FungalPlate2.addOrReplaceChild("FungalRidgeEdge_r2", CubeListBuilder.create().texOffs(34, 51).addBox(-5.0F, -1.51F, 2.5F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(34, 51).addBox(-5.0F, -1.51F, -6.5F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(28, 44).addBox(-5.5F, -1.5F, -5.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.25F))
		.texOffs(22, 57).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-3.7531F, 0.3058F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition FungalPlate3 = HelmExtraDetails.addOrReplaceChild("FungalPlate3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0655F, 0.876F, 2.5103F, 0.0F, -0.3491F, -0.5236F));

		PartDefinition FungalRidgeEdge_r3 = FungalPlate3.addOrReplaceChild("FungalRidgeEdge_r3", CubeListBuilder.create().texOffs(34, 51).addBox(-5.0F, -1.51F, 2.8F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(34, 51).addBox(-5.0F, -1.51F, -6.8F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(28, 44).addBox(-5.8F, -1.5F, -5.5F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.2F))
		.texOffs(22, 57).addBox(-4.0F, -1.5F, -5.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7531F, 0.3058F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition FungalPlate4 = HelmExtraDetails.addOrReplaceChild("FungalPlate4", CubeListBuilder.create().texOffs(22, 57).addBox(-5.0F, -1.1942F, -0.2469F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(27, 46).addBox(-5.5F, -1.1942F, 7.4531F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F))
		.texOffs(29, 57).addBox(-6.7F, -1.2042F, -0.2469F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.3F))
		.texOffs(30, 57).addBox(2.7F, -1.2042F, -0.2469F, 2.0F, 1.0F, 9.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.5757F, 0.9283F, 1.2508F, 0.2182F, 0.3491F, -0.2618F));

		PartDefinition UpperTorsoFungalPlate = UpperTorso.addOrReplaceChild("UpperTorsoFungalPlate", CubeListBuilder.create().texOffs(22, 57).mirror().addBox(-3.0F, -1.6942F, -0.2469F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 46).mirror().addBox(-3.5F, -1.1942F, 7.7531F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 57).mirror().addBox(5.0F, -1.2042F, -0.2469F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(30, 57).mirror().addBox(-5.0F, -1.2042F, -0.2469F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.2336F, -0.3932F, 1.1873F, 0.3054F, -0.48F, 0.0F));

		PartDefinition Legs = KnightHyper.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(10, 91).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(36, 82).addBox(-3.5F, -1.01F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -14.0F, 0.0F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(77, 2).addBox(-3.5F, 1.01F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition RightLegSeg2_r1 = RightLegSeg2.addOrReplaceChild("RightLegSeg2_r1", CubeListBuilder.create().texOffs(10, 91).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(75, 74).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -14.0F, 0.0F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create().texOffs(75, 21).addBox(-2.0F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition LeftLegFungus = LeftLegSeg2.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offset(12.75F, 20.0527F, -2.4006F));

		PartDefinition Fungus_r2 = LeftLegFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -20.05F, 0.55F, 0.0392F, 0.5172F, 0.2531F));

		PartDefinition Fungus_r3 = LeftLegFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -17.05F, 2.45F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r4 = LeftLegFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 56).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -13.05F, 1.55F, 0.0333F, 0.6219F, 0.3593F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.LeftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.RightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.Arm.xRot = -0.5f +  Mth.cos(ageInTicks/6)/6;
			this.ForArm.xRot = -0.5f +  Mth.cos(ageInTicks/8)/8;
		}else{
			this.Arm.xRot = Mth.cos(ageInTicks/8)/8;
			this.ForArm.xRot = Arm.xRot < 0 ? Arm.xRot : 0;
		}
		if (entity.attackAnim > 0) {
			float f1 = 1.0F - Mth.abs(10 - 2 * entity.attackAnim) / 6.5F;
			this.Arm.xRot =-0.5f + Mth.sin(f1) * 3.0F;
		}
		this.Claw1.zRot  = Mth.cos(ageInTicks/7)/8;
		this.Claw2.zRot = Mth.sin(ageInTicks/7)/7;
		this.Claw3.xRot = Mth.cos(ageInTicks/7)/6;
		this.Claw4.xRot = -Mth.cos(ageInTicks/7)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		KnightHyper.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}