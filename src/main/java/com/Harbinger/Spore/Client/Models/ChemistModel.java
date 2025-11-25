package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Chemist;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ChemistModel<T extends Chemist> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "chemistmodel"), "main");
	private final ModelPart ChemistFull;
	private final ModelPart Chemist;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart GasMask;
	private final ModelPart FilterBase;
	private final ModelPart FilterBaseRight;
	private final ModelPart FilterBaseLeft;
	private final ModelPart Filters;
	private final ModelPart Filter1;
	private final ModelPart Filter1end;
	private final ModelPart Filter2;
	private final ModelPart Helmet;
	private final ModelPart HelmetBase;
	private final ModelPart Glass;
	private final ModelPart IntakeTubeRight;
	private final ModelPart IntakeTubeLeft;
	private final ModelPart HeadTendrils;
	private final ModelPart HeadTendril1;
	private final ModelPart tendril1Seg1;
	private final ModelPart FlintEnd1;
	private final ModelPart HeadTendril2;
	private final ModelPart tendril2Seg1;
	private final ModelPart HeadTendril3;
	private final ModelPart tendril3Seg1;
	private final ModelPart FlintEnd2;
	private final ModelPart HeadSmallTendril;
	private final ModelPart HeadTumors1;
	private final ModelPart HeadTumors2;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tendrils;
	private final ModelPart Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart ActualTorso;
	private final ModelPart LeakingGuts;
	private final ModelPart StomachTumors;
	private final ModelPart Tank;
	private final ModelPart BackTendril1;
	private final ModelPart r3seg2;
	private final ModelPart r3seg3;
	private final ModelPart BackTendril2;
	private final ModelPart r3seg4;
	private final ModelPart r3seg5;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart LeftForLeg;

	public ChemistModel(ModelPart root) {
		this.ChemistFull = root.getChild("ChemistFull");
		this.Chemist = this.ChemistFull.getChild("Chemist");
		this.Torso = this.Chemist.getChild("Torso");
		this.Head = this.Torso.getChild("Head");
		this.GasMask = this.Head.getChild("GasMask");
		this.FilterBase = this.GasMask.getChild("FilterBase");
		this.FilterBaseRight = this.FilterBase.getChild("FilterBaseRight");
		this.FilterBaseLeft = this.FilterBase.getChild("FilterBaseLeft");
		this.Filters = this.GasMask.getChild("Filters");
		this.Filter1 = this.Filters.getChild("Filter1");
		this.Filter1end = this.Filter1.getChild("Filter1end");
		this.Filter2 = this.Filters.getChild("Filter2");
		this.Helmet = this.Head.getChild("Helmet");
		this.HelmetBase = this.Helmet.getChild("HelmetBase");
		this.Glass = this.Helmet.getChild("Glass");
		this.IntakeTubeRight = this.Head.getChild("IntakeTubeRight");
		this.IntakeTubeLeft = this.Head.getChild("IntakeTubeLeft");
		this.HeadTendrils = this.Head.getChild("HeadTendrils");
		this.HeadTendril1 = this.HeadTendrils.getChild("HeadTendril1");
		this.tendril1Seg1 = this.HeadTendril1.getChild("tendril1Seg1");
		this.FlintEnd1 = this.tendril1Seg1.getChild("FlintEnd1");
		this.HeadTendril2 = this.HeadTendrils.getChild("HeadTendril2");
		this.tendril2Seg1 = this.HeadTendril2.getChild("tendril2Seg1");
		this.HeadTendril3 = this.HeadTendrils.getChild("HeadTendril3");
		this.tendril3Seg1 = this.HeadTendril3.getChild("tendril3Seg1");
		this.FlintEnd2 = this.tendril3Seg1.getChild("FlintEnd2");
		this.HeadSmallTendril = this.HeadTendrils.getChild("HeadSmallTendril");
		this.HeadTumors1 = this.Head.getChild("HeadTumors1");
		this.HeadTumors2 = this.Head.getChild("HeadTumors2");
		this.Arms = this.Torso.getChild("Arms");
		this.RightArm = this.Arms.getChild("RightArm");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.Tendrils = this.LeftArm.getChild("Tendrils");
		this.Tendril1 = this.Tendrils.getChild("Tendril1");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.ActualTorso = this.Torso.getChild("ActualTorso");
		this.LeakingGuts = this.ActualTorso.getChild("LeakingGuts");
		this.StomachTumors = this.LeakingGuts.getChild("StomachTumors");
		this.Tank = this.ActualTorso.getChild("Tank");
		this.BackTendril1 = this.Torso.getChild("BackTendril1");
		this.r3seg2 = this.BackTendril1.getChild("r3seg2");
		this.r3seg3 = this.r3seg2.getChild("r3seg3");
		this.BackTendril2 = this.Torso.getChild("BackTendril2");
		this.r3seg4 = this.BackTendril2.getChild("r3seg4");
		this.r3seg5 = this.r3seg4.getChild("r3seg5");
		this.Legs = this.Chemist.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightForLeg = this.RightLeg.getChild("RightForLeg");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftForLeg = this.LeftLeg.getChild("LeftForLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ChemistFull = partdefinition.addOrReplaceChild("ChemistFull", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Chemist = ChemistFull.addOrReplaceChild("Chemist", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Torso = Chemist.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -8.0F, -2.75F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(94, 0).addBox(-4.5F, -8.5F, -2.74F, 9.0F, 9.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -21.5F, -2.75F));

		PartDefinition Foliage7_r1 = Head.addOrReplaceChild("Foliage7_r1", CubeListBuilder.create().texOffs(-7, 92).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, 7.25F, -2.6472F, -0.3392F, 2.8684F));

		PartDefinition Foliage6_r1 = Head.addOrReplaceChild("Foliage6_r1", CubeListBuilder.create().texOffs(-7, 92).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3F, -6.0F, 0.95F, 2.9031F, -0.5902F, 2.9876F));

		PartDefinition GasMask = Head.addOrReplaceChild("GasMask", CubeListBuilder.create(), PartPose.offset(0.05F, -1.0F, 0.25F));

		PartDefinition FilterBase = GasMask.addOrReplaceChild("FilterBase", CubeListBuilder.create().texOffs(32, 49).addBox(-12.0F, -10.24F, 2.74F, 8.0F, 4.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offset(8.0F, 8.0F, -8.0F));

		PartDefinition FilterBaseRight = FilterBase.addOrReplaceChild("FilterBaseRight", CubeListBuilder.create().texOffs(78, 33).addBox(-4.95F, -23.5F, -2.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.05F, 14.5F, 5.0F));

		PartDefinition FilterRightSmoothTop_r1 = FilterBaseRight.addOrReplaceChild("FilterRightSmoothTop_r1", CubeListBuilder.create().texOffs(78, 43).addBox(-1.45F, -0.75F, 0.0F, 2.9F, 1.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.45F, -24.0F, -1.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition FilterBaseLeft = FilterBase.addOrReplaceChild("FilterBaseLeft", CubeListBuilder.create().texOffs(16, 46).addBox(-6.0F, -9.0F, 3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(28, 70).addBox(-4.0F, -10.0F, 4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Filters = GasMask.addOrReplaceChild("Filters", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Filter1 = Filters.addOrReplaceChild("Filter1", CubeListBuilder.create(), PartPose.offset(-4.5195F, -1.55F, -5.8483F));

		PartDefinition String_r1 = Filter1.addOrReplaceChild("String_r1", CubeListBuilder.create().texOffs(0, 79).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.5F, 3.0F, 1.2F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Filter1end = Filter1.addOrReplaceChild("Filter1end", CubeListBuilder.create().texOffs(76, 46).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4695F, 6.8F, 1.2983F));

		PartDefinition Filter1Cap_r1 = Filter1end.addOrReplaceChild("Filter1Cap_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 0.0F, 0.2182F, 0.0F, 0.2182F));

		PartDefinition Filter2 = Filters.addOrReplaceChild("Filter2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4196F, 0.45F, -3.3483F, 0.8203F, 0.0F, 0.0F));

		PartDefinition Blood_r1 = Filter2.addOrReplaceChild("Blood_r1", CubeListBuilder.create().texOffs(70, 36).addBox(-3.0F, -1.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2305F, 0.35F, -3.2375F, -0.841F, -0.3333F, 0.3397F));

		PartDefinition Filter2Cap_r1 = Filter2.addOrReplaceChild("Filter2Cap_r1", CubeListBuilder.create().texOffs(24, 76).addBox(-0.6981F, 0.8819F, -1.9782F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 73).addBox(-0.1981F, 1.3819F, -0.9782F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0195F, -2.8995F, -1.5659F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Helmet = Head.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(-0.5F, 24.5F, 0.25F));

		PartDefinition HelmetBase = Helmet.addOrReplaceChild("HelmetBase", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -35.0F, 5.01F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(34, 15).addBox(-11.0F, -35.0F, 4.01F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 55).addBox(-11.0F, -27.0F, 4.01F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 71).addBox(-11.0F, -34.0F, 4.01F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 74).addBox(-3.0F, -34.0F, 4.01F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 2.0F, -8.0F));

		PartDefinition Glass = Helmet.addOrReplaceChild("Glass", CubeListBuilder.create().texOffs(36, 78).addBox(-4.75F, -1.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 69).addBox(0.25F, -1.5F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(28, 32).addBox(-0.75F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -30.5F, -3.74F));

		PartDefinition Glass_r1 = Glass.addOrReplaceChild("Glass_r1", CubeListBuilder.create().texOffs(4, 79).addBox(-1.0F, -2.0F, 0.001F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, -0.3491F));

		PartDefinition Glass_r2 = Glass.addOrReplaceChild("Glass_r2", CubeListBuilder.create().texOffs(60, 47).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 3.5F, 0.0F, 0.1304F, 0.0114F, -0.4356F));

		PartDefinition Glass_r3 = Glass.addOrReplaceChild("Glass_r3", CubeListBuilder.create().texOffs(24, 46).addBox(-1.0F, -2.0F, 0.001F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, 2.5F, 0.0F, 0.0F, -0.0873F, -0.4363F));

		PartDefinition Glass_r4 = Glass.addOrReplaceChild("Glass_r4", CubeListBuilder.create().texOffs(28, 35).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -1.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition IntakeTubeRight = Head.addOrReplaceChild("IntakeTubeRight", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.1808F, -3.0987F, 1.5556F, -0.0436F, 0.2531F, 0.0F));

		PartDefinition Vein8_r1 = IntakeTubeRight.addOrReplaceChild("Vein8_r1", CubeListBuilder.create().texOffs(48, 80).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6816F, 1.7831F, -4.7401F, -0.2834F, 0.0313F, -1.3245F));

		PartDefinition Vein7_r1 = IntakeTubeRight.addOrReplaceChild("Vein7_r1", CubeListBuilder.create().texOffs(28, 80).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8816F, 0.9831F, -4.7401F, -0.2834F, 0.0313F, -1.3245F));

		PartDefinition Vein6_r1 = IntakeTubeRight.addOrReplaceChild("Vein6_r1", CubeListBuilder.create().texOffs(44, 79).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1572F, 0.991F, -4.3257F, -0.0026F, 0.2484F, 0.2542F));

		PartDefinition Vein5_r1 = IntakeTubeRight.addOrReplaceChild("Vein5_r1", CubeListBuilder.create().texOffs(24, 80).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9572F, 0.891F, -4.3257F, -0.0725F, 0.2484F, 0.2542F));

		PartDefinition Vein4_r1 = IntakeTubeRight.addOrReplaceChild("Vein4_r1", CubeListBuilder.create().texOffs(16, 79).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2428F, -0.709F, -4.3257F, 0.0323F, 0.2484F, 0.2542F));

		PartDefinition Vein3_r1 = IntakeTubeRight.addOrReplaceChild("Vein3_r1", CubeListBuilder.create().texOffs(12, 79).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5572F, -0.909F, -4.3257F, 0.0323F, 0.2484F, 0.2542F));

		PartDefinition Vein2_r1 = IntakeTubeRight.addOrReplaceChild("Vein2_r1", CubeListBuilder.create().texOffs(8, 79).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1184F, 0.4831F, -4.2401F, -0.0915F, 0.0313F, -1.3245F));

		PartDefinition Vein1_r1 = IntakeTubeRight.addOrReplaceChild("Vein1_r1", CubeListBuilder.create().texOffs(66, 36).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3184F, 1.2831F, -4.2401F, -0.0915F, 0.0313F, -1.3245F));

		PartDefinition Fang_r1 = IntakeTubeRight.addOrReplaceChild("Fang_r1", CubeListBuilder.create().texOffs(30, 62).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8163F, 0.3488F, -0.9882F, -0.5415F, 0.3724F, -1.8113F));

		PartDefinition IntakeTube_r1 = IntakeTubeRight.addOrReplaceChild("IntakeTube_r1", CubeListBuilder.create().texOffs(68, 54).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0816F, 0.0831F, -2.54F, 1.6509F, -1.3258F, 0.146F));

		PartDefinition ConnectingTumorBase7_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase7_r1", CubeListBuilder.create().texOffs(70, 41).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.8184F, -0.2169F, 0.2599F, 1.5331F, 0.1788F, 0.3017F));

		PartDefinition ConnectingTumorBase6_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase6_r1", CubeListBuilder.create().texOffs(74, 77).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.6184F, -0.0169F, -2.2401F, 1.4729F, 0.4394F, 0.2759F));

		PartDefinition ConnectingTumorBase5_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase5_r1", CubeListBuilder.create().texOffs(66, 77).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1816F, -0.8169F, -2.2401F, 1.8388F, 0.5328F, -0.0222F));

		PartDefinition ConnectingTumorBase4_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase4_r1", CubeListBuilder.create().texOffs(58, 77).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.8816F, -1.1169F, -0.8401F, 1.2242F, 0.4966F, 0.1119F));

		PartDefinition ConnectingTumorBase3_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase3_r1", CubeListBuilder.create().texOffs(78, 24).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.5816F, 0.1831F, 0.3599F, 0.8557F, -0.0278F, -0.5932F));

		PartDefinition ConnectingTumorBase2_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase2_r1", CubeListBuilder.create().texOffs(76, 50).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4816F, 0.9831F, 0.0599F, 0.4371F, -0.6952F, 0.1247F));

		PartDefinition ConnectingTumorBase1_r1 = IntakeTubeRight.addOrReplaceChild("ConnectingTumorBase1_r1", CubeListBuilder.create().texOffs(50, 76).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.6816F, 1.6831F, -0.8401F, -0.3269F, -1.0581F, 0.6593F));

		PartDefinition IntakeTubeTumorBase_r1 = IntakeTubeRight.addOrReplaceChild("IntakeTubeTumorBase_r1", CubeListBuilder.create().texOffs(60, 58).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5816F, 0.6831F, -1.4401F, 1.6509F, -1.3258F, 0.146F));

		PartDefinition IntakeTubeLeft = Head.addOrReplaceChild("IntakeTubeLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0192F, -3.1987F, 2.1556F, 0.2475F, -0.5451F, -0.4535F));

		PartDefinition Vein9_r1 = IntakeTubeLeft.addOrReplaceChild("Vein9_r1", CubeListBuilder.create().texOffs(76, 81).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8561F, 1.2797F, -4.4637F, -0.2834F, 0.0313F, -1.3245F));

		PartDefinition Vein8_r2 = IntakeTubeLeft.addOrReplaceChild("Vein8_r2", CubeListBuilder.create().texOffs(72, 81).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6561F, 0.4797F, -4.4637F, -0.2834F, 0.0313F, -1.3245F));

		PartDefinition Vein7_r2 = IntakeTubeLeft.addOrReplaceChild("Vein7_r2", CubeListBuilder.create().texOffs(68, 81).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6949F, 0.4876F, -4.0493F, -0.0026F, 0.2484F, 0.2542F));

		PartDefinition Vein6_r2 = IntakeTubeLeft.addOrReplaceChild("Vein6_r2", CubeListBuilder.create().texOffs(64, 81).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4949F, 0.3876F, -4.0493F, -0.0725F, 0.2484F, 0.2542F));

		PartDefinition Vein5_r2 = IntakeTubeLeft.addOrReplaceChild("Vein5_r2", CubeListBuilder.create().texOffs(60, 81).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2949F, -1.2124F, -4.0493F, 0.0323F, 0.2484F, 0.2542F));

		PartDefinition Vein4_r2 = IntakeTubeLeft.addOrReplaceChild("Vein4_r2", CubeListBuilder.create().texOffs(56, 81).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0949F, -1.4124F, -4.0493F, 0.0323F, 0.2484F, 0.2542F));

		PartDefinition Vein3_r2 = IntakeTubeLeft.addOrReplaceChild("Vein3_r2", CubeListBuilder.create().texOffs(80, 57).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6561F, -0.0203F, -3.9637F, -0.0915F, 0.0313F, -1.3245F));

		PartDefinition Vein2_r2 = IntakeTubeLeft.addOrReplaceChild("Vein2_r2", CubeListBuilder.create().texOffs(52, 80).addBox(1.0F, -1.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8561F, 0.7797F, -3.9637F, -0.0915F, 0.0313F, -1.3245F));

		PartDefinition Fang_r2 = IntakeTubeLeft.addOrReplaceChild("Fang_r2", CubeListBuilder.create().texOffs(52, 64).addBox(1.0F, -3.0F, -4.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4439F, 2.0797F, -0.2637F, 0.0245F, 0.5502F, -1.0503F));

		PartDefinition IntakeTube_r2 = IntakeTubeLeft.addOrReplaceChild("IntakeTube_r2", CubeListBuilder.create().texOffs(36, 70).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.4561F, -0.4203F, -2.2637F, 1.6509F, -1.3258F, 0.146F));

		PartDefinition ConnectingTumorBase7_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase7_r2", CubeListBuilder.create().texOffs(78, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.0561F, 0.3797F, -1.8637F, 0.0492F, -0.9842F, 0.7483F));

		PartDefinition ConnectingTumorBase6_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase6_r2", CubeListBuilder.create().texOffs(78, 16).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5561F, -0.9203F, -1.9637F, 0.8511F, -0.7888F, -0.7261F));

		PartDefinition ConnectingTumorBase5_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase5_r2", CubeListBuilder.create().texOffs(70, 64).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5439F, 0.0797F, -0.1637F, 1.5987F, 0.2389F, 0.2807F));

		PartDefinition ConnectingTumorBase4_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase4_r2", CubeListBuilder.create().texOffs(78, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.7561F, -1.6203F, -1.1637F, -1.7761F, 0.4018F, 2.8042F));

		PartDefinition ConnectingTumorBase3_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase3_r2", CubeListBuilder.create().texOffs(78, 8).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.9561F, -1.7203F, 1.0363F, 0.8421F, -0.0522F, -0.1866F));

		PartDefinition ConnectingTumorBase2_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase2_r2", CubeListBuilder.create().texOffs(78, 4).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.1561F, -0.1203F, 0.9363F, -0.2924F, -0.0522F, -0.1866F));

		PartDefinition ConnectingTumorBase1_r2 = IntakeTubeLeft.addOrReplaceChild("ConnectingTumorBase1_r2", CubeListBuilder.create().texOffs(78, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.0561F, 0.8797F, -0.1637F, 0.8511F, -0.7888F, -0.7261F));

		PartDefinition IntakeTubeTumorBase_r2 = IntakeTubeLeft.addOrReplaceChild("IntakeTubeTumorBase_r2", CubeListBuilder.create().texOffs(40, 64).addBox(-1.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.9561F, 0.1797F, -1.1637F, 1.6509F, -1.3258F, 0.146F));

		PartDefinition HeadTendrils = Head.addOrReplaceChild("HeadTendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.25F));

		PartDefinition HeadTendril1 = HeadTendrils.addOrReplaceChild("HeadTendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2552F, -27.8652F, -3.3662F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tendril1Base_r1 = HeadTendril1.addOrReplaceChild("tendril1Base_r1", CubeListBuilder.create().texOffs(16, 40).addBox(-1.0F, -1.0173F, -3.0306F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0052F, -0.2508F, 0.9998F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril1Seg1 = HeadTendril1.addOrReplaceChild("tendril1Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.4747F, -1.4546F));

		PartDefinition tendril1Seg1_r1 = tendril1Seg1.addOrReplaceChild("tendril1Seg1_r1", CubeListBuilder.create().texOffs(48, 58).addBox(-0.9753F, -1.0782F, -3.2721F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0116F, 0.0779F, -0.2956F));

		PartDefinition FlintEnd1 = tendril1Seg1.addOrReplaceChild("FlintEnd1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1448F, -0.0094F, -2.6792F, 0.6106F, -0.0229F, -0.0586F));

		PartDefinition FlintEnd2_r1 = FlintEnd1.addOrReplaceChild("FlintEnd2_r1", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0573F, -0.5956F, -1.8247F));

		PartDefinition FlintEnd1_r1 = FlintEnd1.addOrReplaceChild("FlintEnd1_r1", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5964F, -0.0474F, -0.2217F));

		PartDefinition HeadTendril2 = HeadTendrils.addOrReplaceChild("HeadTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.208F, -26.4991F, -3.21F, -0.2666F, -0.1509F, 1.0675F));

		PartDefinition tendril2Base_r1 = HeadTendril2.addOrReplaceChild("tendril2Base_r1", CubeListBuilder.create().texOffs(36, 74).addBox(-0.5F, -0.7673F, -2.0306F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0804F, 0.1089F, 0.5785F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril2Seg1 = HeadTendril2.addOrReplaceChild("tendril2Seg1", CubeListBuilder.create(), PartPose.offset(0.0132F, 0.0763F, -0.644F));

		PartDefinition tendril2Seg1_r1 = tendril2Seg1.addOrReplaceChild("tendril2Seg1_r1", CubeListBuilder.create().texOffs(74, 73).addBox(-0.5074F, -0.5212F, -3.0093F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.021F, 0.2018F, -0.2099F, -0.0116F, 0.0779F, -0.2956F));

		PartDefinition HeadTendril3 = HeadTendrils.addOrReplaceChild("HeadTendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.708F, -25.4991F, -3.21F, -0.2666F, -0.1509F, 1.0675F));

		PartDefinition tendril3Base_r1 = HeadTendril3.addOrReplaceChild("tendril3Base_r1", CubeListBuilder.create().texOffs(0, 75).addBox(-0.5F, -0.8673F, -2.0306F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0804F, 0.1089F, 0.5785F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril3Seg1 = HeadTendril3.addOrReplaceChild("tendril3Seg1", CubeListBuilder.create(), PartPose.offset(0.0752F, 0.3344F, -1.3758F));

		PartDefinition tendril3Seg1_r1 = tendril3Seg1.addOrReplaceChild("tendril3Seg1_r1", CubeListBuilder.create().texOffs(12, 75).addBox(-0.5463F, -0.527F, -2.5109F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.083F, -0.0563F, 0.022F, 0.2938F, 0.0779F, -0.2956F));

		PartDefinition FlintEnd2 = tendril3Seg1.addOrReplaceChild("FlintEnd2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1832F, 0.8647F, -2.9142F, 0.9073F, -0.0229F, -0.0586F));

		PartDefinition FlintEnd4_r1 = FlintEnd2.addOrReplaceChild("FlintEnd4_r1", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0573F, -0.5956F, -1.8247F));

		PartDefinition FlintEnd3_r1 = FlintEnd2.addOrReplaceChild("FlintEnd3_r1", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5964F, -0.0474F, -0.2217F));

		PartDefinition HeadSmallTendril = HeadTendrils.addOrReplaceChild("HeadSmallTendril", CubeListBuilder.create().texOffs(78, 54).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offset(0.0F, -27.0F, -3.0F));

		PartDefinition HeadTumors1 = Head.addOrReplaceChild("HeadTumors1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0553F, -7.5507F, 3.657F, -0.3054F, -0.6981F, 0.0F));

		PartDefinition Tumor3_r1 = HeadTumors1.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(2, 84).addBox(-1.75F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.6818F, 1.5202F, -0.4372F, 0.6553F, -0.142F, 1.0024F));

		PartDefinition Tumor2_r1 = HeadTumors1.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(2, 84).addBox(-1.75F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.4182F, 0.0202F, -1.0372F, 0.6625F, 0.0949F, 0.6994F));

		PartDefinition Tumor1_r1 = HeadTumors1.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.4276F, -1.2424F, 1.5284F, 0.9163F, 0.5236F, 0.0F));

		PartDefinition HeadTumors2 = Head.addOrReplaceChild("HeadTumors2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.9447F, -6.5507F, 2.657F, -0.3054F, -0.6981F, 0.0F));

		PartDefinition Tumor5_r1 = HeadTumors2.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(2, 84).addBox(-1.75F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.7069F, 0.7227F, -0.9334F, 1.1651F, -0.2569F, 1.1594F));

		PartDefinition Tumor4_r1 = HeadTumors2.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-0.3527F, -0.3399F, 0.9322F, 0.0982F, 0.0574F, -0.7634F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 50).addBox(-1.0F, -2.0F, -2.1F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 17).addBox(-1.0F, -2.0F, -2.1F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(52, 49).addBox(-1.0F, 4.0F, -2.1F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 24).addBox(-0.5F, 3.0F, -1.6F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 1.0F));

		PartDefinition Foliage1_r1 = RightArm.addOrReplaceChild("Foliage1_r1", CubeListBuilder.create().texOffs(-7, 99).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8F, 0.6F, -0.9F, -0.3142F, 0.0F, 0.3142F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(54, 0).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 17).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(54, 9).addBox(-2.0F, 4.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 28).addBox(-1.5F, 3.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(32, 57).addBox(-2.0F, 7.4F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(-6.0F, 1.5F, 0.9F));

		PartDefinition Foliage3_r1 = LeftArm.addOrReplaceChild("Foliage3_r1", CubeListBuilder.create().texOffs(-7, 99).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 4.1F, -2.3F, 0.1571F, 0.0698F, -0.2967F));

		PartDefinition Tendrils = LeftArm.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition HandTendrilEnd_r1 = Tendril1.addOrReplaceChild("HandTendrilEnd_r1", CubeListBuilder.create().texOffs(40, 78).addBox(0.0F, -4.5F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 8.5F, 0.5F, -0.2337F, 0.0278F, 0.1369F));

		PartDefinition HandTendrilBase_r1 = Tendril1.addOrReplaceChild("HandTendrilBase_r1", CubeListBuilder.create().texOffs(68, 47).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.2F, 0.6F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6317F, -0.1556F, 0.1157F, 0.0F, -1.0821F, 0.0F));

		PartDefinition HandTendrilEnd_r2 = Tendril2.addOrReplaceChild("HandTendrilEnd_r2", CubeListBuilder.create().texOffs(40, 78).addBox(0.0F, -4.5F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2378F, 8.2556F, -0.1328F, -0.4432F, 0.0278F, 0.1369F));

		PartDefinition HandTendrilBase_r2 = Tendril2.addOrReplaceChild("HandTendrilBase_r2", CubeListBuilder.create().texOffs(68, 47).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.6378F, 2.3556F, 0.7672F, 0.1671F, -0.0508F, 0.2925F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1683F, -0.1556F, -1.6843F, 3.1235F, -0.0674F, -2.8792F));

		PartDefinition HandTendrilEnd_r3 = Tendril3.addOrReplaceChild("HandTendrilEnd_r3", CubeListBuilder.create().texOffs(40, 78).addBox(0.0F, -4.5F, -1.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4989F, 8.3434F, -0.746F, -0.3444F, -0.3557F, 0.299F));

		PartDefinition HandTendrilBase_r3 = Tendril3.addOrReplaceChild("HandTendrilBase_r3", CubeListBuilder.create().texOffs(68, 47).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.4989F, 2.4434F, -0.0459F, 0.1671F, -0.0508F, 0.2925F));

		PartDefinition ActualTorso = Torso.addOrReplaceChild("ActualTorso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition Foliage5_r1 = ActualTorso.addOrReplaceChild("Foliage5_r1", CubeListBuilder.create().texOffs(-7, 92).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, -17.6F, 3.9F, -0.6426F, -0.1634F, -0.0921F));

		PartDefinition TorsoBottom_r1 = ActualTorso.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(30, 17).addBox(-4.0F, -0.5398F, -3.2598F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.9F, -0.1745F, 0.0F, 0.0F));

		PartDefinition HazmatSkeletonTorso_r1 = ActualTorso.addOrReplaceChild("HazmatSkeletonTorso_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, -16.5812F, 0.7592F, -0.2007F, 0.0F, 0.0F));

		PartDefinition TorsoTopInterior_r1 = ActualTorso.addOrReplaceChild("TorsoTopInterior_r1", CubeListBuilder.create().texOffs(100, 26).addBox(-7.0F, -5.0F, -1.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.2F))
		.texOffs(30, 28).addBox(-7.0F, -5.0F, -1.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -17.2F, -1.2F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeakingGuts = ActualTorso.addOrReplaceChild("LeakingGuts", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Intestines2_r1 = LeakingGuts.addOrReplaceChild("Intestines2_r1", CubeListBuilder.create().texOffs(78, 28).addBox(-2.0F, -1.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -12.9F, 3.0F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Intestines1_r1 = LeakingGuts.addOrReplaceChild("Intestines1_r1", CubeListBuilder.create().texOffs(20, 67).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -14.2F, 3.2F, -0.0349F, 0.0F, 0.0F));

		PartDefinition StomachTumors = LeakingGuts.addOrReplaceChild("StomachTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition StomachTumor5_r1 = StomachTumors.addOrReplaceChild("StomachTumor5_r1", CubeListBuilder.create().texOffs(58, 73).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.7F, -16.0F, 3.5F, -1.602F, -0.8985F, -2.8935F));

		PartDefinition StomachTumor4_r1 = StomachTumors.addOrReplaceChild("StomachTumor4_r1", CubeListBuilder.create().texOffs(72, 58).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.5F, -14.7F, 3.0F, -0.6568F, -0.2122F, 1.7459F));

		PartDefinition StomachTumor3_r1 = StomachTumors.addOrReplaceChild("StomachTumor3_r1", CubeListBuilder.create().texOffs(50, 72).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.6F, -13.6F, 3.0F, -0.8785F, -0.7557F, 1.342F));

		PartDefinition StomachTumor2_r1 = StomachTumors.addOrReplaceChild("StomachTumor2_r1", CubeListBuilder.create().texOffs(0, 71).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.3F, -13.3F, 3.0F, -0.5886F, -0.7649F, 0.2685F));

		PartDefinition StomachTumor1_r1 = StomachTumors.addOrReplaceChild("StomachTumor1_r1", CubeListBuilder.create().texOffs(70, 69).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(1.8F, -14.8F, 3.4F, 0.3049F, 0.079F, -0.2993F));

		PartDefinition Tank = ActualTorso.addOrReplaceChild("Tank", CubeListBuilder.create().texOffs(34, 0).addBox(-2.5F, -8.0F, -1.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.5F, -6.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Foliage8_r1 = Tank.addOrReplaceChild("Foliage8_r1", CubeListBuilder.create().texOffs(-7, 99).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, -6.3F, 0.0F, 0.192F, 0.0F, -0.192F));

		PartDefinition TankTop_r1 = Tank.addOrReplaceChild("TankTop_r1", CubeListBuilder.create().texOffs(66, 32).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 1.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition BackTendril1 = Torso.addOrReplaceChild("BackTendril1", CubeListBuilder.create().texOffs(12, 67).addBox(-1.0069F, -0.0183F, -0.9928F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2831F, -17.3699F, 6.7538F, -1.5703F, -0.2271F, 3.0092F));

		PartDefinition r3seg2 = BackTendril1.addOrReplaceChild("r3seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0069F, -2.9817F, -0.0072F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg4_r1 = r3seg2.addOrReplaceChild("Seg4_r1", CubeListBuilder.create().texOffs(58, 28).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.9F, 0.8F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition r3seg3 = r3seg2.addOrReplaceChild("r3seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition Seg5_r1 = r3seg3.addOrReplaceChild("Seg5_r1", CubeListBuilder.create().texOffs(46, 70).addBox(0.0F, -6.0F, 0.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.7F, -3.15F, -1.1F, 0.4014F, 0.0F, 1.4835F));

		PartDefinition BackTendril2 = Torso.addOrReplaceChild("BackTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9169F, -17.9699F, 7.3538F, -1.3898F, 0.1378F, 0.7964F));

		PartDefinition Seg4_r2 = BackTendril2.addOrReplaceChild("Seg4_r2", CubeListBuilder.create().texOffs(62, 64).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2931F, 4.1817F, -0.4928F, 0.0693F, 0.0529F, -0.482F));

		PartDefinition r3seg4 = BackTendril2.addOrReplaceChild("r3seg4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0069F, -2.9817F, -0.0073F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg5_r2 = r3seg4.addOrReplaceChild("Seg5_r2", CubeListBuilder.create().texOffs(58, 16).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.8F, 1.4F, 0.3F, -0.4887F, 0.0F, 0.5236F));

		PartDefinition r3seg5 = r3seg4.addOrReplaceChild("r3seg5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0816F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition Seg6_r1 = r3seg5.addOrReplaceChild("Seg6_r1", CubeListBuilder.create().texOffs(78, 36).addBox(0.0F, -4.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5F, -2.95F, 3.5F, 0.0F, 0.6109F, 1.4835F));

		PartDefinition Legs = Chemist.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(44, 39).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(96, 37).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(66, 16).addBox(-1.5F, 5.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition RightForLeg = RightLeg.addOrReplaceChild("RightForLeg", CubeListBuilder.create().texOffs(28, 39).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Foliag4_r1 = RightForLeg.addOrReplaceChild("Foliag4_r1", CubeListBuilder.create().texOffs(-7, 92).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.5F, -1.9F, -0.2269F, 0.1047F, -0.6545F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(112, 37).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(16, 49).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(112, 37).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(2.0F, -12.0F, 0.0F));

		PartDefinition Foliage2_r1 = LeftLeg.addOrReplaceChild("Foliage2_r1", CubeListBuilder.create().texOffs(-7, 99).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 3.1F, -1.3F, 0.558F, 0.0121F, 0.2452F));

		PartDefinition LeftForLeg = LeftLeg.addOrReplaceChild("LeftForLeg", CubeListBuilder.create().texOffs(0, 40).addBox(-2.0F, 1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(66, 20).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void animateBackTentacle(ModelPart part,float age){
		float v2 = Mth.sin(age/8)/10;
		part.xScale = 1 + v2;
		part.yScale = 1 + v2;
		part.zScale = 1 + v2;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float v1 = Mth.sin(ageInTicks/4)/7;
		float v2 = Mth.sin(ageInTicks/8)/10;
		float v3 = Mth.sin(ageInTicks/6)/6;
		if (entity.getAttackAnimationTick() <= 0){
			this.RightArm.xRot =  !(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) ? 90F + v1 : 0.7f + v2;
			this.LeftArm.xRot =  !(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) ? 90F - v1 : 0.7f - v2;
			this.RightArm.yRot = 0;
			this.LeftArm.yRot = 0;
		}
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.LeftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.RightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch * ((float) Math.PI / 180F);
		this.animateTentacleX(IntakeTubeRight,v3);
		this.animateTentacleX(IntakeTubeLeft,-v3);
		this.animateTumor(this.HeadTumors1,v2);
		this.animateTumor(this.HeadTumors2,v1);
		this.animateTentacleX(HeadTendril1,-Mth.cos(ageInTicks/7)/6);
		this.animateTentacleY(HeadTendril2,Mth.sin(ageInTicks/6)/7);
		this.animateTentacleX(HeadTendril3,Mth.cos(ageInTicks/5)/6);
		this.animateTentacleY(HeadSmallTendril,-Mth.sin(ageInTicks/6)/5);
		animateBackTentacle(BackTendril1,ageInTicks);
		animateBackTentacle(BackTendril2,-ageInTicks);
		this.animateTentacleY(Tendrils,v3);
		this.animateTentacleY(Tendril1,v3 * 1.5f);
		this.animateTentacleZ(Tendril1,-v3);
		this.animateTentacleX(Tendril1,v3 * 1.25f);
	}
	@Override
	public void prepareMobModel(T entity, float value1, float value2, float value3) {
		super.prepareMobModel(entity, value1, value2, value3);
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			this.LeftArm.yRot = -1.5F + 3F * Mth.triangleWave((float)attackAnimationTick - value3, 20.0F);
			this.RightArm.yRot = 1.5F - 3F * Mth.triangleWave((float)attackAnimationTick - value3, 20.0F);
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r,float g,float b, float alpha) {
		ChemistFull.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}