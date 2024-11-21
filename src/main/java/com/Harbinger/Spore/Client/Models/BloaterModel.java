package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Bloater;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.util.Mth;

public class BloaterModel<T extends Bloater> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bloatemodelr"), "main");
	private final ModelPart bloater;
	private final ModelPart rightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart leftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart torso;
	private final ModelPart sea1;
	private final ModelPart sea2;
	private final ModelPart tumor1;
	private final ModelPart tumor2;
	private final ModelPart tumor3;
	private final ModelPart tumor4;
	public BloaterModel(ModelPart root) {
		this.bloater = root.getChild("bloater");
		this.rightLeg = bloater.getChild("Legs").getChild("RightLeg");
		this.rightForLeg = rightLeg.getChild("RightLeg2");
		this.leftLeg = bloater.getChild("Legs").getChild("LeftLeg");
		this.leftForLeg = leftLeg.getChild("LeftLeg2");
		this.sea1 = bloater.getChild("LowerTorso").getChild("TorsoDetails").getChild("BottomSeaPickles");
		this.tumor1 = bloater.getChild("LowerTorso").getChild("TorsoDetails").getChild("LowerTorsoTumor").getChild("TumorClump1");
		this.tumor2 = bloater.getChild("LowerTorso").getChild("TorsoDetails").getChild("LowerTorsoTumor").getChild("TumorClump2");
		this.torso = bloater.getChild("LowerTorso").getChild("UpperTorso");
		this.tumor3 = torso.getChild("UpperTorsoDetails").getChild("MiddleTorsoTumor").getChild("TumorClump3");
		this.tumor4 = torso.getChild("UpperTorsoDetails").getChild("MiddleTorsoTumor").getChild("TumorClump4");
		this.sea2 = torso.getChild("UpperTorsoDetails").getChild("TopSeaPickles");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bloater = partdefinition.addOrReplaceChild("bloater", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

		PartDefinition LowerTorso = bloater.addOrReplaceChild("LowerTorso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.75F, -1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LowerTorsoBase = LowerTorso.addOrReplaceChild("LowerTorsoBase", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -2.5F, -4.5F, 11.0F, 8.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 17).addBox(-5.5F, -0.5F, -4.5F, 11.0F, 6.0F, 9.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -5.5F, 1.0F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 32).addBox(-5.0F, -6.0F, -3.0F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(18, 48).addBox(0.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, 1.0F, 0.0F, -0.5699F, -0.0689F, -0.0422F));

		PartDefinition LeftArm2 = LeftArm.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(68, 0).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 7.0F, 0.0F));

		PartDefinition LowerLeftArmFin = LeftArm2.addOrReplaceChild("LowerLeftArmFin", CubeListBuilder.create(), PartPose.offset(-1.5F, 1.0F, 0.0F));

		PartDefinition Plane_r1 = LowerLeftArmFin.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(85, 113).addBox(-1.5F, -3.5F, 0.0F, 3.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4644F, 2.2404F, 1.6121F, -2.7856F, -0.2079F, -0.0666F));

		PartDefinition Plane_r2 = LowerLeftArmFin.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(84, 113).addBox(0.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.1433F, -0.224F, -0.2449F, 0.4677F, -0.1122F));

		PartDefinition LowerLeftCoral = LeftArm2.addOrReplaceChild("LowerLeftCoral", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0793F, 3.25F, -3.1998F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Plane_r3 = LowerLeftCoral.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(0, 110).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5597F, 0.0F, 0.0F, -0.3927F, 0.0F, -1.5708F));

		PartDefinition Plane_r4 = LowerLeftCoral.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(0, 110).addBox(-3.0F, -1.059F, 0.5969F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 1.5708F));

		PartDefinition Plane_r5 = LowerLeftCoral.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(0, 110).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.9567F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Plane_r6 = LowerLeftCoral.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(0, 110).addBox(-3.0F, -2.5F, 0.0F, 6.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5597F, 0.0F, -0.3927F, 0.0F, -3.1416F));

		PartDefinition LeftArmFin = LeftArm.addOrReplaceChild("LeftArmFin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plane_r7 = LeftArmFin.addOrReplaceChild("Plane_r7", CubeListBuilder.create().texOffs(36, 110).addBox(0.0F, -4.0F, 0.0F, 4.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, 0.0F, 0.0F, 0.3054F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(68, 13).addBox(-4.5F, -1.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.0F, 0.0F, -0.5669F, 0.0923F, 0.0791F));

		PartDefinition UpperRightArmFin = RightArm.addOrReplaceChild("UpperRightArmFin", CubeListBuilder.create(), PartPose.offset(-0.25F, 5.5F, 0.0F));

		PartDefinition Plane_r8 = UpperRightArmFin.addOrReplaceChild("Plane_r8", CubeListBuilder.create().texOffs(84, 113).mirror().addBox(-4.0F, -7.0F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.0F, 0.25F, -0.2317F, 0.3405F, -0.0786F));

		PartDefinition Plane_r9 = UpperRightArmFin.addOrReplaceChild("Plane_r9", CubeListBuilder.create().texOffs(44, 114).mirror().addBox(-4.0F, -8.0F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 1.25F, -1.25F, 0.2506F, -0.51F, -0.1243F));

		PartDefinition RightArm2 = RightArm.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(0, 101).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 7.0F, 0.0F));

		PartDefinition RightArmFin = RightArm2.addOrReplaceChild("RightArmFin", CubeListBuilder.create(), PartPose.offset(-3.75F, 2.5F, 0.0F));

		PartDefinition Plane_r10 = RightArmFin.addOrReplaceChild("Plane_r10", CubeListBuilder.create().texOffs(45, 116).mirror().addBox(-2.0F, -2.5F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.4349F, -0.0368F, 0.0791F));

		PartDefinition Shell = RightArm.addOrReplaceChild("Shell", CubeListBuilder.create(), PartPose.offset(-3.1501F, -0.4544F, -1.7125F));

		PartDefinition Shell_r1 = Shell.addOrReplaceChild("Shell_r1", CubeListBuilder.create().texOffs(108, 0).addBox(-1.25F, 0.5F, -2.75F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(88, 40).addBox(-1.25F, -3.5F, -2.75F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.8151F, -0.4345F, 1.261F));

		PartDefinition Head = UpperTorso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(36, 32).addBox(-4.0F, -5.8839F, -6.5399F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.9973F, -1.1632F, -0.9121F, 0.1037F, 0.08F));

		PartDefinition Alge = Head.addOrReplaceChild("Alge", CubeListBuilder.create().texOffs(90, 60).addBox(-4.0F, -5.8839F, -6.5399F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plane_r11 = Alge.addOrReplaceChild("Plane_r11", CubeListBuilder.create().texOffs(108, 22).addBox(0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.199F, -1.6839F, -6.7399F, 0.3052F, -0.0131F, 0.0416F));

		PartDefinition Base_r1 = Alge.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(48, 28).addBox(0.0F, 0.0F, 0.0F, 3.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -1.6839F, -6.7399F, 0.0865F, 0.0114F, -0.1304F));

		PartDefinition HeadFin = Head.addOrReplaceChild("HeadFin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Fin_r1 = HeadFin.addOrReplaceChild("Fin_r1", CubeListBuilder.create().texOffs(16, 98).addBox(0.0F, -5.0F, -3.5F, 0.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -4.0F, -2.5F, -0.1134F, 0.2334F, 1.5842F));

		PartDefinition Fin_r2 = HeadFin.addOrReplaceChild("Fin_r2", CubeListBuilder.create().texOffs(84, 92).mirror().addBox(0.0F, -3.0F, -3.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.6422F, -6.9892F, -2.7104F, 3.0713F, -0.0638F, -3.0896F));

		PartDefinition Fin_r3 = HeadFin.addOrReplaceChild("Fin_r3", CubeListBuilder.create().texOffs(70, 92).addBox(0.0F, -6.0F, -3.5F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, -2.5F, 0.173F, -0.002F, 0.6335F));

		PartDefinition JawSeagrass = Head.addOrReplaceChild("JawSeagrass", CubeListBuilder.create(), PartPose.offset(-0.9444F, 0.138F, -3.4681F));

		PartDefinition Plane_r12 = JawSeagrass.addOrReplaceChild("Plane_r12", CubeListBuilder.create().texOffs(37, 90).addBox(0.0F, -0.75F, 0.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9444F, -0.138F, -2.7819F, 0.413F, -0.023F, -0.1445F));

		PartDefinition Plane_r13 = JawSeagrass.addOrReplaceChild("Plane_r13", CubeListBuilder.create().texOffs(36, 88).addBox(0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0556F, -0.138F, -2.7819F, 0.3931F, 0.0861F, -0.1137F));

		PartDefinition Plane_r14 = JawSeagrass.addOrReplaceChild("Plane_r14", CubeListBuilder.create().texOffs(108, 17).addBox(0.0F, 0.0F, -0.25F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0556F, -0.138F, -2.7819F, 0.2618F, 0.0F, -0.1309F));

		PartDefinition HarpoonPoint = UpperTorso.addOrReplaceChild("HarpoonPoint", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -5.4762F, -1.1759F, 1.0908F, 0.0F, 0.0F));

		PartDefinition Harpoon = HarpoonPoint.addOrReplaceChild("Harpoon", CubeListBuilder.create().texOffs(62, 107).addBox(-0.5F, -11.0F, -0.5F, 1.0F, 11.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plane_r15 = Harpoon.addOrReplaceChild("Plane_r15", CubeListBuilder.create().texOffs(108, 57).addBox(0.0F, -3.0F, -1.75F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane_r16 = Harpoon.addOrReplaceChild("Plane_r16", CubeListBuilder.create().texOffs(108, 51).addBox(0.0F, -5.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition UpperTorsoDetails = UpperTorso.addOrReplaceChild("UpperTorsoDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition UpperTorsoFins = UpperTorsoDetails.addOrReplaceChild("UpperTorsoFins", CubeListBuilder.create().texOffs(50, 72).addBox(0.01F, -3.6647F, -0.3095F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.8501F, 5.3545F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Fin_r4 = UpperTorsoFins.addOrReplaceChild("Fin_r4", CubeListBuilder.create().texOffs(66, 70).addBox(0.0F, -8.0F, -8.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.6647F, 7.6905F, 0.829F, 0.0F, 0.0F));

		PartDefinition Fin_r5 = UpperTorsoFins.addOrReplaceChild("Fin_r5", CubeListBuilder.create().texOffs(0, 86).addBox(-0.01F, 0.0F, -8.0F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.3353F, 7.6905F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MiddleTorsoTumor = UpperTorsoDetails.addOrReplaceChild("MiddleTorsoTumor", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3534F, -0.4322F, 6.0178F, 1.0908F, 0.0F, 0.0F));

		PartDefinition TumorClump3 = MiddleTorsoTumor.addOrReplaceChild("TumorClump3", CubeListBuilder.create(), PartPose.offset(-1.9343F, -1.4898F, 0.0104F));

		PartDefinition Tumor_r1 = TumorClump3.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(46, 18).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2909F, 2.8557F, -2.004F, -1.3008F, -0.2365F, 0.5037F));

		PartDefinition Tumor_r2 = TumorClump3.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(46, 4).addBox(-1.0F, -1.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7122F, -2.328F, -4.0283F, 0.0F, 0.4363F, 0.3927F));

		PartDefinition Tumor_r3 = TumorClump3.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(41, 16).addBox(-3.5F, -3.5F, -2.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9141F, 1.2043F, -0.1373F, 0.5797F, -0.6921F, 1.2857F));

		PartDefinition AlgePlane_r1 = TumorClump3.addOrReplaceChild("AlgePlane_r1", CubeListBuilder.create().texOffs(108, 31).addBox(0.25F, -4.0F, -5.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3139F, 2.8638F, 5.868F, 0.1355F, 0.2595F, -1.0122F));

		PartDefinition AlgePlane_r2 = TumorClump3.addOrReplaceChild("AlgePlane_r2", CubeListBuilder.create().texOffs(40, 28).addBox(-4.0F, -3.0F, 0.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9256F, -3.7236F, 5.6435F, 0.7164F, 0.1814F, -1.2959F));

		PartDefinition Alge_r1 = TumorClump3.addOrReplaceChild("Alge_r1", CubeListBuilder.create().texOffs(92, 62).addBox(-2.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.3703F, -0.8626F, 5.7561F, -2.4435F, 0.0F, -1.0472F));

		PartDefinition Tumor_r4 = TumorClump3.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(36, 46).addBox(-1.0F, -1.0F, 0.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7122F, 0.672F, -1.0283F, 0.6981F, 0.0F, -1.0472F));

		PartDefinition TumorClump4 = MiddleTorsoTumor.addOrReplaceChild("TumorClump4", CubeListBuilder.create(), PartPose.offset(4.7147F, -0.4954F, 0.727F));

		PartDefinition Tumor_r5 = TumorClump4.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(48, 3).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0253F, 0.6523F, -0.0771F, 0.1691F, -0.108F, 0.3931F));

		PartDefinition Tumor_r6 = TumorClump4.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(46, 17).addBox(-0.455F, -4.1425F, -1.5293F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1565F, -0.0043F, 0.4333F, 0.3927F, 0.4363F, 0.0F));

		PartDefinition Tumor_r7 = TumorClump4.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(40, 0).addBox(-4.6894F, -4.6125F, -0.9F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1565F, -0.0043F, 0.4333F, 0.6545F, 0.5236F, 0.0F));

		PartDefinition Tumor_r8 = TumorClump4.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(45, 18).addBox(-2.6576F, -2.0822F, -4.3946F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8435F, -0.0043F, -1.5667F, 0.3927F, -0.4363F, 0.0F));

		PartDefinition TopSeaPickles = UpperTorsoDetails.addOrReplaceChild("TopSeaPickles", CubeListBuilder.create(), PartPose.offsetAndRotation(4.064F, -2.9128F, 4.0F, 0.3054F, 0.0F, 0.3054F));

		PartDefinition SeaPickle1 = TopSeaPickles.addOrReplaceChild("SeaPickle1", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9919F, -1.6573F, -1.1373F, -0.7373F, 0.1205F, 0.3923F));

		PartDefinition Tip2_r1 = SeaPickle1.addOrReplaceChild("Tip2_r1", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip1_r1 = SeaPickle1.addOrReplaceChild("Tip1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition SeaPickle2 = TopSeaPickles.addOrReplaceChild("SeaPickle2", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5764F, 1.4314F, -1.1149F, -0.8504F, -0.1027F, 1.0883F));

		PartDefinition Tip3_r1 = SeaPickle2.addOrReplaceChild("Tip3_r1", CubeListBuilder.create().texOffs(0, 5).mirror().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip2_r2 = SeaPickle2.addOrReplaceChild("Tip2_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition SeaPickle3 = TopSeaPickles.addOrReplaceChild("SeaPickle3", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6595F, 0.669F, -0.6192F, -1.9102F, -0.6225F, 1.9122F));

		PartDefinition Tip4_r1 = SeaPickle3.addOrReplaceChild("Tip4_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip3_r2 = SeaPickle3.addOrReplaceChild("Tip3_r2", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition TorsoDetails = LowerTorso.addOrReplaceChild("TorsoDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LowerTorsoTumor = TorsoDetails.addOrReplaceChild("LowerTorsoTumor", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3534F, -5.0678F, 7.0178F, -1.0908F, 0.0F, 0.0F));

		PartDefinition TumorClump1 = LowerTorsoTumor.addOrReplaceChild("TumorClump1", CubeListBuilder.create(), PartPose.offset(2.202F, 2.3386F, -0.1108F));

		PartDefinition Tumor_r9 = TumorClump1.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(43, 16).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1946F, 3.4792F, -4.907F, -0.4531F, 0.272F, 1.5514F));

		PartDefinition Tumor_r10 = TumorClump1.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(40, 14).addBox(-4.0F, -4.0F, -3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3757F, 0.8924F, 2.3195F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition Tumor_r11 = TumorClump1.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(43, 2).addBox(-5.0F, -5.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4446F, 1.9792F, -1.907F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition Tumor_r12 = TumorClump1.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(41, 2).addBox(-4.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.9768F, -1.9545F, 0.1173F, 1.3008F, 0.2365F, 0.5037F));

		PartDefinition TumorClump2 = LowerTorsoTumor.addOrReplaceChild("TumorClump2", CubeListBuilder.create(), PartPose.offset(-4.7147F, 1.9954F, -0.023F));

		PartDefinition Tumor_r13 = TumorClump2.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(56, 8).addBox(-3.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3612F, 0.3224F, -2.9948F, 0.5672F, 0.48F, 0.0F));

		PartDefinition Tumor_r14 = TumorClump2.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(44, 20).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3612F, 0.8224F, -2.9948F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition Tumor_r15 = TumorClump2.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(43, 2).addBox(-6.0F, -6.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3612F, 1.8224F, 0.0052F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition Tumor_r16 = TumorClump2.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(44, 6).addBox(-4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6388F, 1.8224F, -1.9948F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition TorsoFins = TorsoDetails.addOrReplaceChild("TorsoFins", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -5.0F, 5.5F, 0.0F, 0.0F, 0.0F));

		PartDefinition LowerTorsoFin_r1 = TorsoFins.addOrReplaceChild("LowerTorsoFin_r1", CubeListBuilder.create().texOffs(0, 68).addBox(1.0F, -5.5F, 0.0F, 0.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.2744F, -0.1553F, -0.2989F));

		PartDefinition LowerTorsoFin_r2 = TorsoFins.addOrReplaceChild("LowerTorsoFin_r2", CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, -5.5F, 0.0F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.5F, 0.2391F, 0.5194F, 0.4565F));

		PartDefinition TorsoTendrils = TorsoDetails.addOrReplaceChild("TorsoTendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril1 = TorsoTendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1468F, -1.5432F, -2.4424F, -1.5062F, -0.049F, 1.192F));

		PartDefinition TendrilSegment_r1 = Tendril1.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(66, 113).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(118, 69).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril2 = TorsoTendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.8951F, -1.6125F, -2.4457F, -1.6023F, 0.5412F, 2.1026F));

		PartDefinition TendrilSegment_r2 = Tendril2.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(66, 113).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(118, 69).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0815F, 5.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Tendril3 = TorsoTendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7383F, -6.0607F, -3.3893F, -1.5219F, -0.1606F, 2.4966F));

		PartDefinition TendrilSegment_r3 = Tendril3.addOrReplaceChild("TendrilSegment_r3", CubeListBuilder.create().texOffs(66, 113).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(118, 69).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 2.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		PartDefinition BottomSeaPickles = TorsoDetails.addOrReplaceChild("BottomSeaPickles", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7624F, -3.3531F, 4.7467F, -0.3571F, 0.0831F, -1.0026F));

		PartDefinition SeaPickle4 = BottomSeaPickles.addOrReplaceChild("SeaPickle4", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9919F, -1.6573F, -1.1373F, -0.7052F, 0.2649F, 0.559F));

		PartDefinition Tip2_r3 = SeaPickle4.addOrReplaceChild("Tip2_r3", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip1_r2 = SeaPickle4.addOrReplaceChild("Tip1_r2", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition SeaPickle5 = BottomSeaPickles.addOrReplaceChild("SeaPickle5", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5764F, 1.4314F, -1.1149F, -1.0685F, -0.1027F, 1.0883F));

		PartDefinition Tip3_r3 = SeaPickle5.addOrReplaceChild("Tip3_r3", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip2_r4 = SeaPickle5.addOrReplaceChild("Tip2_r4", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition SeaPickle6 = BottomSeaPickles.addOrReplaceChild("SeaPickle6", CubeListBuilder.create().texOffs(30, 101).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 115).addBox(-2.0F, -5.0F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, -2.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 120).addBox(-1.0F, -5.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9855F, -0.4708F, -1.317F, -2.3919F, -0.4331F, 2.0603F));

		PartDefinition Tip4_r2 = SeaPickle6.addOrReplaceChild("Tip4_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Tip3_r4 = SeaPickle6.addOrReplaceChild("Tip3_r4", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Shell2 = TorsoDetails.addOrReplaceChild("Shell2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.6112F, -5.2779F, 2.6779F, 1.1208F, 0.6587F, 0.2267F));

		PartDefinition Shell_r2 = Shell2.addOrReplaceChild("Shell_r2", CubeListBuilder.create().texOffs(108, 0).mirror().addBox(-1.5F, -1.0F, -2.5F, 3.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.4216F, -1.2033F, 0.8287F, 2.5166F, -0.6966F, 0.9118F));

		PartDefinition Shell_r3 = Shell2.addOrReplaceChild("Shell_r3", CubeListBuilder.create().texOffs(88, 40).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4216F, 1.2033F, -0.8287F, 2.5166F, -0.6966F, 0.9118F));

		PartDefinition Legs = bloater.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(82, 81).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(68, 26).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offset(2.5F, -12.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(82, 70).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftFootFin = LeftLeg.addOrReplaceChild("LeftFootFin", CubeListBuilder.create().texOffs(36, 110).addBox(0.0F, -3.0F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 8.25F, -1.0F, 0.0F, -0.6545F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(50, 97).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -12.0F, 0.0F));

		PartDefinition RightLegFin = RightLeg.addOrReplaceChild("RightLegFin", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.75F, 1.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Plane_r17 = RightLegFin.addOrReplaceChild("Plane_r17", CubeListBuilder.create().texOffs(84, 110).addBox(0.0F, -3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RightLeg2 = RightLeg.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(50, 86).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightFootFin2 = RightLeg2.addOrReplaceChild("RightFootFin2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 2.25F, 0.0F, 0.0F, 0.5672F, 0.0F));

		PartDefinition Plane_r18 = RightFootFin2.addOrReplaceChild("Plane_r18", CubeListBuilder.create().texOffs(84, 113).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void renderTumor(T entity,ModelPart part,float value,int count){
		if (entity.getAmountOfTumors() >= count){
			part.visible = true;
			animateTumor(part,value);
		}else {
			part.visible = false;
		}
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		renderTumor(entity,tumor1,Mth.cos(ageInTicks/7)/8,1);
		renderTumor(entity,tumor2,Mth.sin(ageInTicks/8)/7,2);
		renderTumor(entity,tumor3,-Mth.sin(ageInTicks/7)/7,3);
		renderTumor(entity,tumor4,Mth.cos(ageInTicks/8)/7,4);
		this.sea1.visible = entity.getAmountOfTumors() <= 0;
		this.sea2.visible = entity.getAmountOfTumors() <= 3;
		this.leftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.rightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.leftForLeg.xRot = this.leftLeg.xRot < 0 ? -this.leftLeg.xRot : 0;
		this.rightForLeg.xRot = this.rightLeg.xRot < 0 ? -this.rightLeg.xRot : 0;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bloater.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}