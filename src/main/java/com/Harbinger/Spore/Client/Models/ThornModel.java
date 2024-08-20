package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Thorn;
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

public class ThornModel<T extends Thorn> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "thornmodel"), "main");
	private final ModelPart Torn;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart LeftLegThorns1;
	private final ModelPart LeftLegThorns2;
	private final ModelPart RightLegThorns1;
	private final ModelPart RightLegThorns2;
	private final ModelPart TorsoThorns1;
	private final ModelPart TorsoThorns2;
	private final ModelPart HeadThorns;
	private final ModelPart RightArmThorns1;
	private final ModelPart RightArmThorns2;
	private final ModelPart LeftArmThorns1;

	public ThornModel(ModelPart root) {
		this.Torn = root.getChild("Torn");
		this.Head = Torn.getChild("LowerTorso").getChild("UpperTorso").getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.LeftArm = Torn.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("LeftArmJoint");
		this.RightArm = Torn.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("RightArmJoint");
		this.RightLeg = Torn.getChild("Legs").getChild("RightLeg");
		this.LeftLeg = Torn.getChild("Legs").getChild("LeftLeg");
		this.RightForLeg = RightLeg.getChild("RightFoot");
		this.LeftForLeg = LeftLeg.getChild("LeftFoot");
		this.LeftLegThorns1  = LeftLeg.getChild("LeftLegThornsSeg1");
		this.LeftLegThorns2 = LeftForLeg.getChild("LeftFootThorns");
		this.RightLegThorns1 = RightLeg.getChild("RightLegThornsSeg1");
		this.RightLegThorns2 = RightForLeg.getChild("RightLegThornsSeg2");
		this.TorsoThorns1  = Torn.getChild("LowerTorso").getChild("LowerTorsoThorn");
		this.TorsoThorns2  = Torn.getChild("LowerTorso").getChild("UpperTorso").getChild("UpperTorsoThorn");
		this.HeadThorns = Head.getChild("HeadFlower").getChild("ThornBloom");
		this.RightArmThorns1 = RightArm.getChild("RightArm").getChild("RightArmThornsSeg1");
		this.RightArmThorns2 = RightArm.getChild("RightArm").getChild("RightArmSeg2").getChild("RightArmThornsSeg2");
		this.LeftArmThorns1 = LeftArm.getChild("LeftArm").getChild("LeftArmSeg2").getChild("LeftArmThorns");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Torn = partdefinition.addOrReplaceChild("Torn", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LowerTorso = Torn.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(24, 21).addBox(-4.5F, -6.0F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LowerTorsoFungus = LowerTorso.addOrReplaceChild("LowerTorsoFungus", CubeListBuilder.create(), PartPose.offset(-0.0593F, -2.8392F, -0.3475F));

		PartDefinition Fungus_r1 = LowerTorsoFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(0, 41).addBox(-3.5F, 1.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -4.2108F, -0.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = LowerTorsoFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(0, 34).addBox(-1.5F, 2.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.2108F, -0.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = LowerTorsoFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(0, 34).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 1.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = LowerTorsoFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4595F, 1.2968F, -2.1872F, 0.2692F, -0.2194F, -0.443F));

		PartDefinition LowerTorsoThorn = LowerTorso.addOrReplaceChild("LowerTorsoThorn", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.5F, 0.25F));

		PartDefinition Thorn11 = LowerTorsoThorn.addOrReplaceChild("Thorn11", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6071F, -0.8797F, 1.4668F, 1.0666F, -1.2305F, 0.1897F));

		PartDefinition Plane2_r1 = Thorn11.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = Thorn11.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn12 = LowerTorsoThorn.addOrReplaceChild("Thorn12", CubeListBuilder.create().texOffs(0, 0).addBox(1.8539F, -1.8513F, -1.5443F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3014F, 0.0312F, 3.9695F, 1.4354F, 0.3093F, 0.5109F));

		PartDefinition Plane_r1 = Thorn12.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8539F, 3.1487F, -0.5443F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r2 = Thorn12.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8539F, 3.1487F, -0.5443F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn13 = LowerTorsoThorn.addOrReplaceChild("Thorn13", CubeListBuilder.create().texOffs(0, 0).addBox(3.5211F, 0.8415F, -1.5991F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3412F, 1.4722F, -1.1213F, 2.2943F, -0.2944F, -0.6424F));

		PartDefinition Plane_r3 = Thorn13.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5211F, 5.8415F, -0.5991F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r4 = Thorn13.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5211F, 5.8415F, -0.5991F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn14 = LowerTorsoThorn.addOrReplaceChild("Thorn14", CubeListBuilder.create().texOffs(0, 0).addBox(-1.1317F, -1.2719F, -1.5148F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3458F, -0.0357F, 0.1999F, 1.2373F, 0.8328F, 0.0336F));

		PartDefinition Plane_r5 = Thorn14.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1317F, 3.7281F, -0.5148F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r6 = Thorn14.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1317F, 3.7281F, -0.5148F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn15 = LowerTorsoThorn.addOrReplaceChild("Thorn15", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6753F, -0.2839F, 0.4653F, 2.2655F, -0.4687F, 1.0727F));

		PartDefinition Plane_r7 = Thorn15.addOrReplaceChild("Plane_r7", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, -0.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r8 = Thorn15.addOrReplaceChild("Plane_r8", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.0F, -0.5F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn16 = LowerTorsoThorn.addOrReplaceChild("Thorn16", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7393F, -1.2808F, -1.1729F, -1.2778F, -0.8709F, 0.1479F));

		PartDefinition Plane3_r1 = Thorn16.addOrReplaceChild("Plane3_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r2 = Thorn16.addOrReplaceChild("Plane2_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn17 = LowerTorsoThorn.addOrReplaceChild("Thorn17", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1824F, -1.131F, -1.9673F, -1.2662F, 0.1363F, -0.5345F));

		PartDefinition Plane4_r1 = Thorn17.addOrReplaceChild("Plane4_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r2 = Thorn17.addOrReplaceChild("Plane3_r2", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn18 = LowerTorsoThorn.addOrReplaceChild("Thorn18", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9114F, -0.9903F, -0.9919F, -1.9082F, -0.0273F, 0.4139F));

		PartDefinition Plane5_r1 = Thorn18.addOrReplaceChild("Plane5_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r2 = Thorn18.addOrReplaceChild("Plane4_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn19 = LowerTorsoThorn.addOrReplaceChild("Thorn19", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.672F, 0.1314F, -1.7477F, -1.4177F, 0.6664F, -0.106F));

		PartDefinition Plane6_r1 = Thorn19.addOrReplaceChild("Plane6_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r2 = Thorn19.addOrReplaceChild("Plane5_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn20 = LowerTorsoThorn.addOrReplaceChild("Thorn20", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1109F, -2.5608F, -1.6989F, -2.4645F, 0.2022F, -1.0011F));

		PartDefinition Plane7_r1 = Thorn20.addOrReplaceChild("Plane7_r1", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane6_r2 = Thorn20.addOrReplaceChild("Plane6_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 14).addBox(-4.5F, -6.0F, -3.0F, 9.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r1 = UpperTorso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 18).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Head = UpperTorso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(54, 29).addBox(-4.0F, -2.0F, 2.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(62, 13).addBox(-4.5F, -2.5F, -6.25F, 9.0F, 2.0F, 1.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Jaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(63, 40).addBox(-0.75F, -1.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(3.75F, -1.5F, -3.25F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Teeth_r2 = Jaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(63, 40).mirror().addBox(-0.5F, -1.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(-0.5F)).mirror(false), PartPose.offsetAndRotation(-3.75F, -1.5F, -3.25F, 0.0F, 3.0107F, 0.0F));

		PartDefinition HeadFlower = Head.addOrReplaceChild("HeadFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8724F, -7.4774F, -3.5681F, 0.7253F, 0.5149F, -0.4026F));

		PartDefinition Petal_r1 = HeadFlower.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0874F, -0.0517F, -1.1782F, -0.0306F, 0.1719F, -0.6135F));

		PartDefinition Petal_r2 = HeadFlower.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(0, 41).addBox(-4.0F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6028F, -0.2198F, 0.3625F, -0.2186F, -0.1937F, 0.6378F));

		PartDefinition Petal_r3 = HeadFlower.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, 0.6357F, -3.5922F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Petal_r4 = HeadFlower.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(0, 27).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2423F, -0.3643F, 3.4078F, 0.7152F, -0.2815F, -0.1201F));

		PartDefinition ThornBloom = HeadFlower.addOrReplaceChild("ThornBloom", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Thorn59 = ThornBloom.addOrReplaceChild("Thorn59", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7053F, 1.6014F, 0.1904F, 2.7685F, 0.9894F, -0.9487F));

		PartDefinition Plane5_r3 = Thorn59.addOrReplaceChild("Plane5_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r3 = Thorn59.addOrReplaceChild("Plane4_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn60 = ThornBloom.addOrReplaceChild("Thorn60", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7245F, 1.4394F, 0.0823F, 1.1609F, 1.1674F, -1.9921F));

		PartDefinition Plane6_r3 = Thorn60.addOrReplaceChild("Plane6_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r4 = Thorn60.addOrReplaceChild("Plane5_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn61 = ThornBloom.addOrReplaceChild("Thorn61", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7753F, 1.5015F, -0.685F, -0.6174F, 0.6091F, 2.6389F));

		PartDefinition Plane7_r2 = Thorn61.addOrReplaceChild("Plane7_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane6_r4 = Thorn61.addOrReplaceChild("Plane6_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(4.5F, -4.0F, 0.0F));

		PartDefinition LeftArmJoint = Arms.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, 0.0F));

		PartDefinition LeftArm = LeftArmJoint.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 55).addBox(0.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0472F, 0.0F, -0.0873F));

		PartDefinition ArmFungus = LeftArm.addOrReplaceChild("ArmFungus", CubeListBuilder.create(), PartPose.offset(1.4407F, 2.6608F, -0.3475F));

		PartDefinition Fungus_r5 = ArmFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(0, 41).addBox(-3.5F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 2.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = ArmFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(0, 41).addBox(-1.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = ArmFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(0, 34).addBox(-2.25F, -2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = ArmFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, -1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(35, 48).addBox(-0.5F, -1.5F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArmThorns = LeftArmSeg2.addOrReplaceChild("LeftArmThorns", CubeListBuilder.create(), PartPose.offset(1.0F, 2.0F, 0.25F));

		PartDefinition Thorn21 = LeftArmThorns.addOrReplaceChild("Thorn21", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3009F, 2.3767F, 0.4286F, 1.3149F, -0.7448F, -0.1992F));

		PartDefinition Plane2_r3 = Thorn21.addOrReplaceChild("Plane2_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r2 = Thorn21.addOrReplaceChild("Plane1_r2", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn22 = LeftArmThorns.addOrReplaceChild("Thorn22", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7197F, 0.1008F, 0.2932F, 1.4354F, 0.3093F, 0.5109F));

		PartDefinition Plane3_r3 = Thorn22.addOrReplaceChild("Plane3_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r4 = Thorn22.addOrReplaceChild("Plane2_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn23 = LeftArmThorns.addOrReplaceChild("Thorn23", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.081F, -1.7945F, 1.0466F, 2.2943F, -0.2944F, -0.6424F));

		PartDefinition Plane4_r4 = Thorn23.addOrReplaceChild("Plane4_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r4 = Thorn23.addOrReplaceChild("Plane3_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn24 = LeftArmThorns.addOrReplaceChild("Thorn24", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.492F, 2.3772F, 0.383F, 1.2373F, 0.8328F, 0.0336F));

		PartDefinition Plane5_r5 = Thorn24.addOrReplaceChild("Plane5_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r5 = Thorn24.addOrReplaceChild("Plane4_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn25 = LeftArmThorns.addOrReplaceChild("Thorn25", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6193F, -0.7673F, 1.3567F, 2.7891F, -0.4687F, 1.0727F));

		PartDefinition Plane6_r5 = Thorn25.addOrReplaceChild("Plane6_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r6 = Thorn25.addOrReplaceChild("Plane5_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn26 = LeftArmThorns.addOrReplaceChild("Thorn26", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4807F, 1.9195F, -0.5216F, -1.1332F, -1.1162F, -0.0232F));

		PartDefinition Plane3_r5 = Thorn26.addOrReplaceChild("Plane3_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r5 = Thorn26.addOrReplaceChild("Plane2_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn27 = LeftArmThorns.addOrReplaceChild("Thorn27", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6908F, -0.7883F, -1.3589F, -1.7622F, -0.414F, -0.5551F));

		PartDefinition Plane4_r6 = Thorn27.addOrReplaceChild("Plane4_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r6 = Thorn27.addOrReplaceChild("Plane3_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn28 = LeftArmThorns.addOrReplaceChild("Thorn28", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0512F, -1.8476F, -1.1524F, -2.2278F, -0.678F, 0.6907F));

		PartDefinition Plane5_r7 = Thorn28.addOrReplaceChild("Plane5_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r7 = Thorn28.addOrReplaceChild("Plane4_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn29 = LeftArmThorns.addOrReplaceChild("Thorn29", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2522F, 1.395F, -1.8088F, -1.4177F, 0.6664F, -0.106F));

		PartDefinition Plane6_r6 = Thorn29.addOrReplaceChild("Plane6_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r8 = Thorn29.addOrReplaceChild("Plane5_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn30 = LeftArmThorns.addOrReplaceChild("Thorn30", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4725F, -1.8879F, -0.334F, -2.6074F, 0.4797F, -1.4189F));

		PartDefinition Plane7_r3 = Thorn30.addOrReplaceChild("Plane7_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane6_r7 = Thorn30.addOrReplaceChild("Plane6_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightArmJoint = Arms.addOrReplaceChild("RightArmJoint", CubeListBuilder.create(), PartPose.offset(-9.0F, -0.5F, 0.0F));

		PartDefinition RightArm = RightArmJoint.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(16, 55).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9163F, 0.0F, 0.0873F));

		PartDefinition RightArmThornsSeg1 = RightArm.addOrReplaceChild("RightArmThornsSeg1", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, 0.25F));

		PartDefinition Thorn31 = RightArmThornsSeg1.addOrReplaceChild("Thorn31", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1207F, 2.3403F, 0.598F, 1.3705F, -0.3619F, -0.3029F));

		PartDefinition Plane2_r6 = Thorn31.addOrReplaceChild("Plane2_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r3 = Thorn31.addOrReplaceChild("Plane1_r3", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn32 = RightArmThornsSeg1.addOrReplaceChild("Thorn32", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7197F, 0.1008F, -0.7932F, -1.4354F, -0.3093F, 0.5109F));

		PartDefinition Plane3_r7 = Thorn32.addOrReplaceChild("Plane3_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane2_r7 = Thorn32.addOrReplaceChild("Plane2_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn33 = RightArmThornsSeg1.addOrReplaceChild("Thorn33", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0628F, 1.2614F, -0.3512F, -2.8119F, -0.7063F, -1.1651F));

		PartDefinition Plane4_r8 = Thorn33.addOrReplaceChild("Plane4_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r8 = Thorn33.addOrReplaceChild("Plane3_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn34 = RightArmThornsSeg1.addOrReplaceChild("Thorn34", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1712F, -0.1349F, -0.0031F, 2.864F, 1.1858F, -0.3065F));

		PartDefinition Plane5_r9 = Thorn34.addOrReplaceChild("Plane5_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r9 = Thorn34.addOrReplaceChild("Plane4_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(0, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 4.5F, 0.0F));

		PartDefinition RightArmThornsSeg2 = RightArmSeg2.addOrReplaceChild("RightArmThornsSeg2", CubeListBuilder.create(), PartPose.offset(1.0F, 1.5F, 0.0F));

		PartDefinition Thorn35 = RightArmThornsSeg2.addOrReplaceChild("Thorn35", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1207F, 2.3403F, 0.598F, 1.3705F, 0.3619F, 0.3029F));

		PartDefinition Plane2_r8 = Thorn35.addOrReplaceChild("Plane2_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane1_r4 = Thorn35.addOrReplaceChild("Plane1_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn36 = RightArmThornsSeg2.addOrReplaceChild("Thorn36", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7197F, 0.1008F, -0.7932F, -1.4354F, 0.3093F, -0.5109F));

		PartDefinition Plane3_r9 = Thorn36.addOrReplaceChild("Plane3_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r9 = Thorn36.addOrReplaceChild("Plane2_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn37 = RightArmThornsSeg2.addOrReplaceChild("Thorn37", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0628F, 1.2614F, -0.3512F, -2.8119F, 0.7063F, 1.1651F));

		PartDefinition Plane4_r10 = Thorn37.addOrReplaceChild("Plane4_r10", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane3_r10 = Thorn37.addOrReplaceChild("Plane3_r10", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn38 = RightArmThornsSeg2.addOrReplaceChild("Thorn38", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6944F, 2.0381F, -0.0666F, 0.9441F, -1.1858F, 0.3065F));

		PartDefinition Plane5_r10 = Thorn38.addOrReplaceChild("Plane5_r10", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane4_r11 = Thorn38.addOrReplaceChild("Plane4_r11", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition UpperTorsoThorn = UpperTorso.addOrReplaceChild("UpperTorsoThorn", CubeListBuilder.create(), PartPose.offset(1.0F, -3.5F, 0.0F));

		PartDefinition Thorn1 = UpperTorsoThorn.addOrReplaceChild("Thorn1", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7393F, 1.2808F, -1.1729F, 1.3149F, -0.7448F, -0.1992F));

		PartDefinition Plane2_r10 = Thorn1.addOrReplaceChild("Plane2_r10", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r5 = Thorn1.addOrReplaceChild("Plane1_r5", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn2 = UpperTorsoThorn.addOrReplaceChild("Thorn2", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0154F, -0.4986F, -1.709F, 1.4354F, 0.3093F, 0.5109F));

		PartDefinition Plane3_r11 = Thorn2.addOrReplaceChild("Plane3_r11", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r11 = Thorn2.addOrReplaceChild("Plane2_r11", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn3 = UpperTorsoThorn.addOrReplaceChild("Thorn3", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6518F, 2.1942F, -1.7638F, 2.2943F, -0.2944F, -0.6424F));

		PartDefinition Plane4_r12 = Thorn3.addOrReplaceChild("Plane4_r12", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r12 = Thorn3.addOrReplaceChild("Plane3_r12", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn4 = UpperTorsoThorn.addOrReplaceChild("Thorn4", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.001F, 0.0809F, -1.6795F, 1.2373F, 0.8328F, 0.0336F));

		PartDefinition Plane5_r11 = Thorn4.addOrReplaceChild("Plane5_r11", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r13 = Thorn4.addOrReplaceChild("Plane4_r13", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn5 = UpperTorsoThorn.addOrReplaceChild("Thorn5", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3693F, 1.3527F, -1.6647F, 1.6547F, -0.4687F, 1.0727F));

		PartDefinition Plane6_r8 = Thorn5.addOrReplaceChild("Plane6_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r12 = Thorn5.addOrReplaceChild("Plane5_r12", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn6 = UpperTorsoThorn.addOrReplaceChild("Thorn6", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7393F, 1.2808F, 1.1729F, -1.2778F, -0.8709F, 0.1479F));

		PartDefinition Plane3_r13 = Thorn6.addOrReplaceChild("Plane3_r13", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r12 = Thorn6.addOrReplaceChild("Plane2_r12", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn7 = UpperTorsoThorn.addOrReplaceChild("Thorn7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1861F, 1.3099F, 2.0684F, 1.4858F, -0.0947F, 2.5939F));

		PartDefinition Plane_r9 = Thorn7.addOrReplaceChild("Plane_r9", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r10 = Thorn7.addOrReplaceChild("Plane_r10", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn8 = UpperTorsoThorn.addOrReplaceChild("Thorn8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2471F, 1.9977F, 1.6394F, 1.4343F, -0.2868F, 0.4492F));

		PartDefinition Plane_r11 = Thorn8.addOrReplaceChild("Plane_r11", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r12 = Thorn8.addOrReplaceChild("Plane_r12", CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn9 = UpperTorsoThorn.addOrReplaceChild("Thorn9", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.672F, -0.1314F, 1.7477F, -1.4177F, 0.6664F, -0.106F));

		PartDefinition Plane6_r9 = Thorn9.addOrReplaceChild("Plane6_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r13 = Thorn9.addOrReplaceChild("Plane5_r13", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn10 = UpperTorsoThorn.addOrReplaceChild("Thorn10", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1109F, 2.5608F, 1.6989F, -2.6074F, 0.4797F, -1.4189F));

		PartDefinition Plane7_r4 = Thorn10.addOrReplaceChild("Plane7_r4", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -1.5F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.0F, -0.7854F, -3.1416F));

		PartDefinition Plane6_r10 = Thorn10.addOrReplaceChild("Plane6_r10", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Legs = Torn.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 55).mirror().addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition LeftLegThornsSeg1 = LeftLeg.addOrReplaceChild("LeftLegThornsSeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1739F, 1.5F, 1.2201F, 0.0F, -1.309F, 0.0F));

		PartDefinition Thorn55 = LeftLegThornsSeg1.addOrReplaceChild("Thorn55", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1207F, 2.3403F, -0.598F, -1.3705F, -0.3619F, 0.3029F));

		PartDefinition Plane2_r13 = Thorn55.addOrReplaceChild("Plane2_r13", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r6 = Thorn55.addOrReplaceChild("Plane1_r6", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn56 = LeftLegThornsSeg1.addOrReplaceChild("Thorn56", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9001F, 3.7615F, 0.7671F, 1.3506F, 0.9418F, -0.7314F));

		PartDefinition Plane3_r14 = Thorn56.addOrReplaceChild("Plane3_r14", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane2_r14 = Thorn56.addOrReplaceChild("Plane2_r14", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn57 = LeftLegThornsSeg1.addOrReplaceChild("Thorn57", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0628F, 1.2614F, 0.3512F, 2.8119F, -0.7063F, 1.1651F));

		PartDefinition Plane4_r14 = Thorn57.addOrReplaceChild("Plane4_r14", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r15 = Thorn57.addOrReplaceChild("Plane3_r15", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn58 = LeftLegThornsSeg1.addOrReplaceChild("Thorn58", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6944F, 2.0381F, 0.0666F, -0.9441F, 1.1858F, 0.3065F));

		PartDefinition Plane5_r14 = Thorn58.addOrReplaceChild("Plane5_r14", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r15 = Thorn58.addOrReplaceChild("Plane4_r15", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition LeftFoot = LeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(63, 33).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(32, 8).addBox(-1.0F, 3.0F, 0.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition LeftFootThorns = LeftFoot.addOrReplaceChild("LeftFootThorns", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1566F, 2.5F, 1.1895F, 0.0F, -1.309F, 0.0F));

		PartDefinition Thorn51 = LeftFootThorns.addOrReplaceChild("Thorn51", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2181F, -1.1213F, -0.2339F, -0.4978F, -0.3619F, 0.3029F));

		PartDefinition Plane2_r15 = Thorn51.addOrReplaceChild("Plane2_r15", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r7 = Thorn51.addOrReplaceChild("Plane1_r7", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn52 = LeftFootThorns.addOrReplaceChild("Thorn52", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.164F, -0.8112F, 0.6108F, 0.4319F, -0.3093F, -0.5109F));

		PartDefinition Plane3_r16 = Thorn52.addOrReplaceChild("Plane3_r16", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane2_r16 = Thorn52.addOrReplaceChild("Plane2_r16", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn53 = LeftFootThorns.addOrReplaceChild("Thorn53", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5241F, -0.7505F, -0.4286F, 3.0303F, 0.3908F, 2.6921F));

		PartDefinition Plane4_r16 = Thorn53.addOrReplaceChild("Plane4_r16", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r17 = Thorn53.addOrReplaceChild("Plane3_r17", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn54 = LeftFootThorns.addOrReplaceChild("Thorn54", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0668F, -0.8932F, -0.0493F, -0.2023F, 1.1858F, 0.3065F));

		PartDefinition Plane5_r15 = Thorn54.addOrReplaceChild("Plane5_r15", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r17 = Thorn54.addOrReplaceChild("Plane4_r17", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition RightLegThornsSeg1 = RightLeg.addOrReplaceChild("RightLegThornsSeg1", CubeListBuilder.create(), PartPose.offset(0.5F, 4.5F, 0.0F));

		PartDefinition Thorn43 = RightLegThornsSeg1.addOrReplaceChild("Thorn43", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1207F, -2.3403F, -0.598F, 1.3705F, -0.3619F, -0.3029F));

		PartDefinition Plane2_r17 = Thorn43.addOrReplaceChild("Plane2_r17", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r8 = Thorn43.addOrReplaceChild("Plane1_r8", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn44 = RightLegThornsSeg1.addOrReplaceChild("Thorn44", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7197F, -0.1008F, 0.7932F, -1.4354F, -0.3093F, 0.5109F));

		PartDefinition Plane3_r18 = Thorn44.addOrReplaceChild("Plane3_r18", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane2_r18 = Thorn44.addOrReplaceChild("Plane2_r18", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn45 = RightLegThornsSeg1.addOrReplaceChild("Thorn45", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0628F, -1.2614F, 0.3512F, -1.8782F, 0.5142F, -1.6751F));

		PartDefinition Plane4_r18 = Thorn45.addOrReplaceChild("Plane4_r18", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r19 = Thorn45.addOrReplaceChild("Plane3_r19", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn46 = RightLegThornsSeg1.addOrReplaceChild("Thorn46", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3244F, -0.3359F, -1.3874F, 1.7781F, 0.2438F, 0.2283F));

		PartDefinition Plane5_r16 = Thorn46.addOrReplaceChild("Plane5_r16", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r19 = Thorn46.addOrReplaceChild("Plane4_r19", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, -3.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightFoot = RightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(16, 55).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition RightLegThornsSeg2 = RightFoot.addOrReplaceChild("RightLegThornsSeg2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.5F, 1.0F));

		PartDefinition Thorn47 = RightLegThornsSeg2.addOrReplaceChild("Thorn47", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.772F, 0.4382F, -0.7411F, -1.3705F, -0.3619F, 0.3029F));

		PartDefinition Plane2_r19 = Thorn47.addOrReplaceChild("Plane2_r19", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r9 = Thorn47.addOrReplaceChild("Plane1_r9", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn48 = RightLegThornsSeg2.addOrReplaceChild("Thorn48", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7197F, 0.1008F, 0.7932F, 1.4354F, -0.3093F, -0.5109F));

		PartDefinition Plane3_r20 = Thorn48.addOrReplaceChild("Plane3_r20", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Plane2_r20 = Thorn48.addOrReplaceChild("Plane2_r20", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Thorn49 = RightLegThornsSeg2.addOrReplaceChild("Thorn49", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4141F, 1.1545F, 0.2456F, -2.8604F, -0.7063F, 1.1651F));

		PartDefinition Plane4_r20 = Thorn49.addOrReplaceChild("Plane4_r20", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r21 = Thorn49.addOrReplaceChild("Plane3_r21", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn50 = RightLegThornsSeg2.addOrReplaceChild("Thorn50", CubeListBuilder.create().texOffs(0, 27).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6292F, 0.603F, 0.3027F, -0.9441F, 1.1858F, 0.3065F));

		PartDefinition Plane5_r17 = Thorn50.addOrReplaceChild("Plane5_r17", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r21 = Thorn50.addOrReplaceChild("Plane4_r21", CubeListBuilder.create().texOffs(0, 31).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition RightFootFungus = RightFoot.addOrReplaceChild("RightFootFungus", CubeListBuilder.create(), PartPose.offset(-1.0593F, 4.1608F, 0.6525F));

		PartDefinition Fungus_r9 = RightFootFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, -0.5F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 2.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = RightFootFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(0, 34).addBox(-2.5F, -2.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r11 = RightFootFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(0, 34).addBox(-4.25F, -2.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r12 = RightFootFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateArms(ModelPart part,T entity,float value){
		if (entity.isAggressive()){
			part.xRot = -1.5f + Mth.cos(value/6)/6;
		}else{
			part.xRot = Mth.cos(value/6)/8;
		}
	}
	private void animateSpike(T entity ,ModelPart part,float value){
		part.yScale = entity.hurtTime > 0 ? 2 : 1 + Mth.sin(value/7)/7;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Jaw.xRot = 0.4f + Mth.cos(ageInTicks/6)/6;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.LeftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		animateArms(RightArm,entity,ageInTicks);
		animateArms(LeftArm,entity,ageInTicks);
		animateSpike(entity,LeftLegThorns1.getChild("Thorn55"),-ageInTicks);
		animateSpike(entity,LeftLegThorns1.getChild("Thorn56"),ageInTicks);
		animateSpike(entity,LeftLegThorns1.getChild("Thorn57"),-ageInTicks/2);
		animateSpike(entity,LeftLegThorns1.getChild("Thorn58"),ageInTicks);
		animateSpike(entity,LeftLegThorns2.getChild("Thorn51"),-ageInTicks);
		animateSpike(entity,LeftLegThorns2.getChild("Thorn52"),ageInTicks/2);
		animateSpike(entity,LeftLegThorns2.getChild("Thorn53"),-ageInTicks);
		animateSpike(entity,LeftLegThorns2.getChild("Thorn54"),ageInTicks);
		animateSpike(entity,RightLegThorns1.getChild("Thorn43"),-ageInTicks/2);
		animateSpike(entity,RightLegThorns1.getChild("Thorn44"),ageInTicks);
		animateSpike(entity,RightLegThorns1.getChild("Thorn45"),-ageInTicks);
		animateSpike(entity,RightLegThorns1.getChild("Thorn46"),ageInTicks);
		animateSpike(entity,RightLegThorns2.getChild("Thorn47"),-ageInTicks/2);
		animateSpike(entity,RightLegThorns2.getChild("Thorn48"),-ageInTicks);
		animateSpike(entity,RightLegThorns2.getChild("Thorn49"),ageInTicks);
		animateSpike(entity,RightLegThorns2.getChild("Thorn50"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn11"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn12"),-ageInTicks/2);
		animateSpike(entity,TorsoThorns1.getChild("Thorn13"),ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn14"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn15"),ageInTicks/2);
		animateSpike(entity,TorsoThorns1.getChild("Thorn16"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn17"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn18"),ageInTicks/2);
		animateSpike(entity,TorsoThorns1.getChild("Thorn19"),-ageInTicks);
		animateSpike(entity,TorsoThorns1.getChild("Thorn20"),ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn1"),-ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn2"),ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn3"),-ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn4"),ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn5"),ageInTicks/2);
		animateSpike(entity,TorsoThorns2.getChild("Thorn6"),-ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn7"),ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn8"),ageInTicks/2);
		animateSpike(entity,TorsoThorns2.getChild("Thorn9"),-ageInTicks);
		animateSpike(entity,TorsoThorns2.getChild("Thorn10"),ageInTicks/2);
		animateSpike(entity,HeadThorns.getChild("Thorn59"),ageInTicks);
		animateSpike(entity,HeadThorns.getChild("Thorn60"),-ageInTicks/2);
		animateSpike(entity,HeadThorns.getChild("Thorn61"),-ageInTicks);
		animateSpike(entity,RightArmThorns1.getChild("Thorn31"),-ageInTicks);
		animateSpike(entity,RightArmThorns1.getChild("Thorn32"),ageInTicks);
		animateSpike(entity,RightArmThorns1.getChild("Thorn33"),-ageInTicks);
		animateSpike(entity,RightArmThorns1.getChild("Thorn34"),ageInTicks);
		animateSpike(entity,RightArmThorns2.getChild("Thorn35"),ageInTicks/2);
		animateSpike(entity,RightArmThorns2.getChild("Thorn36"),-ageInTicks);
		animateSpike(entity,RightArmThorns2.getChild("Thorn37"),ageInTicks/2);
		animateSpike(entity,RightArmThorns2.getChild("Thorn38"),-ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn21"),-ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn22"),ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn23"),-ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn24"),ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn25"),-ageInTicks/2);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn26"),-ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn27"),ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn28"),ageInTicks/2);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn29"),-ageInTicks);
		animateSpike(entity,LeftArmThorns1.getChild("Thorn30"),-ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Torn.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}