package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Experiments.Plagued;
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

public class PlaguedModel<T extends Plagued> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "plagued"), "main");
	private final ModelPart covid;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Brain;
	private final ModelPart HeadTumors;
	private final ModelPart Arm;
	private final ModelPart ArmTumor;

	public PlaguedModel(ModelPart root) {
		this.covid = root.getChild("covid");
		this.RightLeg = this.covid.getChild("legs").getChild("RightLeg");
		this.LeftLeg = this.covid.getChild("legs").getChild("LeftLeg");
		this.RightForLeg = this.RightLeg.getChild("RightLegSeg2");
		this.LeftForLeg = this.LeftLeg.getChild("LeftLegSeg2");
		this.Torso = this.covid.getChild("Torso").getChild("TorsoTop");
		this.Head = this.Torso.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.Brain = this.Head.getChild("JuicyBrain");
		this.HeadTumors = this.Head.getChild("Tumors");
		this.Arm = this.Torso.getChild("Arms").getChild("RightLump");
		this.ArmTumor = this.Torso.getChild("Arms").getChild("LeftTumors");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition covid = partdefinition.addOrReplaceChild("covid", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = covid.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(51, 51).addBox(-1.25F, 0.0F, -1.25F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(-2.025F, -12.0F, 0.0F));

		PartDefinition RightLeg_r1 = RightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(12, 54).addBox(-1.225F, 0.0F, -1.25F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -12.0F, 0.25F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create(), PartPose.offset(0.025F, 6.0F, 0.0F));

		PartDefinition LeftLeg_r1 = LeftLegSeg2.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(12, 54).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Torso = covid.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(18, 45).addBox(-3.499F, -6.0F, -1.25F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 14).addBox(-3.499F, -6.0F, -1.25F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.15F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition TorsoBasefungus = Torso.addOrReplaceChild("TorsoBasefungus", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition fungus_r1 = TorsoBasefungus.addOrReplaceChild("fungus_r1", CubeListBuilder.create().texOffs(17, 0).addBox(0.5F, -2.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -15.0F, 1.5F, 0.1367F, 0.3198F, -0.0888F));

		PartDefinition fungus_r2 = TorsoBasefungus.addOrReplaceChild("fungus_r2", CubeListBuilder.create().texOffs(17, 9).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -15.0F, 1.5F, 0.1289F, -0.0227F, 0.1731F));

		PartDefinition TorsoBaseSyringes = Torso.addOrReplaceChild("TorsoBaseSyringes", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition Syringe3 = TorsoBaseSyringes.addOrReplaceChild("Syringe3", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.3667F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F))
		.texOffs(10, 45).addBox(-1.5F, -2.3667F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 9).addBox(-0.5F, 0.7333F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.5F, -16.1333F, -0.5F, 2.8926F, 1.0827F, -2.3866F));

		PartDefinition ThumbPress5 = Syringe3.addOrReplaceChild("ThumbPress5", CubeListBuilder.create().texOffs(48, 0).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 62).addBox(-1.0F, -1.55F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, -2.3667F, 0.0F));

		PartDefinition TorsoTop = Torso.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(24, 30).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 9).addBox(-4.0F, -6.0F, -2.0F, 8.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Head = TorsoTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 54).addBox(-3.0F, -7.0F, -4.0F, 6.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(54, 45).addBox(-3.0F, -6.0F, 3.0F, 6.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 0).addBox(3.0F, -8.0F, -4.0F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-4.0F, -7.0F, -4.0F, 1.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(44, 23).addBox(0.0F, -8.0F, -4.0F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-4.0F, -8.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(10, 40).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(10, 40).addBox(-3.99F, -0.5F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Fang4_r1 = Jaw.addOrReplaceChild("Fang4_r1", CubeListBuilder.create().texOffs(24, 7).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.625F, -1.9435F, -4.3501F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Fang3_r1 = Jaw.addOrReplaceChild("Fang3_r1", CubeListBuilder.create().texOffs(4, 25).addBox(-5.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.875F, -0.175F, -4.7F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Jaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(18, 29).addBox(0.0628F, -1.0528F, -0.4459F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7073F, -1.2831F, -3.315F, -0.102F, -0.1932F, 0.4899F));

		PartDefinition Teeth_r2 = Jaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(19, 28).addBox(0.25F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9666F, -0.7541F, -2.2927F, 0.0573F, -0.2106F, -0.2679F));

		PartDefinition Teeth_r3 = Jaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(18, 26).addBox(0.75F, -0.75F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0334F, -1.2541F, -2.5427F, -1.5879F, 1.2947F, -1.5886F));

		PartDefinition Teeth_r4 = Jaw.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(18, 27).addBox(-0.25F, -1.0F, -1.75F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -0.3F, -1.95F, 0.0411F, 0.3027F, 0.1372F));

		PartDefinition topTeeth = Head.addOrReplaceChild("topTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BigAssToothie_r1 = topTeeth.addOrReplaceChild("BigAssToothie_r1", CubeListBuilder.create().texOffs(18, 32).addBox(-1.75F, -0.25F, 0.5F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, -0.2618F, -0.1745F, 0.0F));

		PartDefinition Toothie_r1 = topTeeth.addOrReplaceChild("Toothie_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 0.0978F, -4.6654F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Toothie_r2 = topTeeth.addOrReplaceChild("Toothie_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.25F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.15F, -1.75F, -3.9F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Toothie_r3 = topTeeth.addOrReplaceChild("Toothie_r3", CubeListBuilder.create().texOffs(26, 7).addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.3478F, -4.5154F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Toothie_r4 = topTeeth.addOrReplaceChild("Toothie_r4", CubeListBuilder.create().texOffs(4, 23).addBox(0.25F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -1.5F, -3.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition JuicyBrain = Head.addOrReplaceChild("JuicyBrain", CubeListBuilder.create().texOffs(0, 29).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -4.0F, 1.0F));

		PartDefinition HeadSyringe = Head.addOrReplaceChild("HeadSyringe", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.3667F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F))
		.texOffs(10, 45).addBox(-1.5F, -2.3667F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 9).addBox(-0.5F, 0.7333F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.0F, -8.1333F, 2.5F, -0.2823F, 0.3786F, -0.1068F));

		PartDefinition ThumbPress4 = HeadSyringe.addOrReplaceChild("ThumbPress4", CubeListBuilder.create().texOffs(48, 0).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 62).addBox(-1.0F, -1.55F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, -2.3667F, 0.0F));

		PartDefinition Tumors = Head.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(3.0F, -8.0F, 0.0F));

		PartDefinition Tumor_r1 = Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(56, 5).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.54F, 0.0099F, 0.7953F, 1.3418F, -0.2467F, -1.0482F));

		PartDefinition Tumor_r2 = Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(56, 5).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.5F, 1.6434F, 0.2952F, 1.318F, 0.0071F, -0.5688F));

		PartDefinition Tumor_r3 = Tumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(56, 5).addBox(-1.5F, -1.5F, -0.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.5F, 0.5F, 0.5208F, 0.3352F, -0.5208F));

		PartDefinition HeadFungus = Head.addOrReplaceChild("HeadFungus", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fungus_r3 = HeadFungus.addOrReplaceChild("fungus_r3", CubeListBuilder.create().texOffs(17, 0).addBox(-3.5F, 1.25F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.784F, -4.089F, 3.4013F, -0.0692F, -0.3066F, -0.0425F));

		PartDefinition fungus_r4 = HeadFungus.addOrReplaceChild("fungus_r4", CubeListBuilder.create().texOffs(17, 9).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7018F, -4.4812F, -4.2523F, -0.3235F, 0.3066F, -0.0425F));

		PartDefinition fungus_r5 = HeadFungus.addOrReplaceChild("fungus_r5", CubeListBuilder.create().texOffs(17, 16).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0438F, -3.2531F, 1.2876F, 0.3765F, 0.3568F, 0.2294F));

		PartDefinition fungus_r6 = HeadFungus.addOrReplaceChild("fungus_r6", CubeListBuilder.create().texOffs(17, 16).addBox(-2.75F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -4.0F, -1.5F, -0.2934F, 0.4623F, -0.1339F));

		PartDefinition Arms = TorsoTop.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLump = Arms.addOrReplaceChild("RightLump", CubeListBuilder.create().texOffs(38, 45).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-3.0F, 2.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -4.0F, 0.0F));

		PartDefinition RightArmSyringe = RightLump.addOrReplaceChild("RightArmSyringe", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.3667F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F))
		.texOffs(10, 45).addBox(-1.5F, -2.3667F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 9).addBox(-0.5F, 0.7333F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-5.0F, -0.1333F, 0.75F, -0.6328F, -1.0191F, -0.8598F));

		PartDefinition ThumbPress3 = RightArmSyringe.addOrReplaceChild("ThumbPress3", CubeListBuilder.create().texOffs(48, 0).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 62).addBox(-1.0F, -1.55F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, -2.3667F, 0.0F));

		PartDefinition LeftTumors = Arms.addOrReplaceChild("LeftTumors", CubeListBuilder.create(), PartPose.offset(4.0F, -4.0F, 0.0F));

		PartDefinition Tumor_r4 = LeftTumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(56, 5).addBox(-1.5F, -1.75F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.6478F, 1.1829F, 0.4605F, 0.8238F, -0.625F, -1.2707F));

		PartDefinition Tumor_r5 = LeftTumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(56, 5).addBox(-2.75F, 0.0F, -0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.7078F, -0.2784F, -0.8331F, 0.1436F, -0.9803F, -0.3689F));

		PartDefinition Tumor_r6 = LeftTumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(56, 5).addBox(-2.0F, -1.5F, -2.25F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 0.5F, 0.7813F, -0.286F, -0.2729F));

		PartDefinition TorsoSyringes = TorsoTop.addOrReplaceChild("TorsoSyringes", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Syringe1 = TorsoSyringes.addOrReplaceChild("Syringe1", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.3667F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F))
		.texOffs(10, 45).addBox(-1.5F, -2.3667F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 9).addBox(-0.5F, 0.7333F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -4.1333F, 3.5F, -1.1345F, 0.0F, 0.0F));

		PartDefinition ThumbPress = Syringe1.addOrReplaceChild("ThumbPress", CubeListBuilder.create().texOffs(48, 0).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 62).addBox(-1.0F, -1.55F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, -2.3667F, 0.0F));

		PartDefinition Syringe2 = TorsoSyringes.addOrReplaceChild("Syringe2", CubeListBuilder.create().texOffs(0, 40).addBox(-1.0F, -2.3667F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.5F))
		.texOffs(10, 45).addBox(-1.5F, -2.3667F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(0, 9).addBox(-0.5F, 0.7333F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.0F, -2.1333F, 3.5F, -1.5567F, -0.1624F, 0.3591F));

		PartDefinition ThumbPress2 = Syringe2.addOrReplaceChild("ThumbPress2", CubeListBuilder.create().texOffs(48, 0).addBox(-0.5F, -1.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 62).addBox(-1.0F, -1.55F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0F, -2.3667F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void animateTumor(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/6)/8;
		part.zScale = 1 + Mth.cos(value/7)/6;
		part.yScale = 1 - Mth.cos(value/6)/7;
	}
	public void animateTumor1(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/8)/8;
		part.zScale = 1 + Mth.cos(value/7)/8;
		part.yScale = 1 - Mth.cos(value/8)/7;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.LeftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Jaw.xRot = 0.9f + Mth.cos(ageInTicks/6)/6;
		this.animateTumor(this.ArmTumor,ageInTicks);
		this.animateTumor1(this.HeadTumors,-ageInTicks);
		this.animateTumor(this.Brain,ageInTicks);
		this.Torso.xRot = 0.3f + Mth.sin(ageInTicks/8)/8;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.Torso.zRot = Mth.sin(ageInTicks/8)/8;
			this.Arm.xRot = -0.5f +  Mth.cos(ageInTicks/6)/6;
		}else{
			this.Torso.zRot = 0;
			this.Arm.xRot = Mth.cos(ageInTicks/7)/8;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		covid.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}