package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Naiad;
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

public class NaiadTritonModel<T extends Naiad> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "naiadtritonmodel"), "main");
	private final ModelPart Naiad;
	private final ModelPart Torso;
	private final ModelPart ActualTorso;
	private final ModelPart UpperChest;
	private final ModelPart Tendrils1;
	private final ModelPart LowerChest;
	private final ModelPart Tendrils2;
	private final ModelPart WaistTumors;
	private final ModelPart WaistTumorGroup1;
	private final ModelPart WaistTumorGroup2;
	private final ModelPart WaistTumorGroup3;
	private final ModelPart WaistTumorGroup4;
	private final ModelPart Head;
	private final ModelPart LowerJaw;
	private final ModelPart Fins;
	private final ModelPart HeadFoliage;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart RightArmTop;
	private final ModelPart Coral;
	private final ModelPart RightArmBottom;
	private final ModelPart Shell2;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmTop;
	private final ModelPart Shell;
	private final ModelPart LeftArmBottom;
	private final ModelPart Trident;
	private final ModelPart Tendons;
	private final ModelPart ArmTumors;
	private final ModelPart Tail;
	private final ModelPart TailTop;
	private final ModelPart TailBase;
	private final ModelPart Tendril3;
	private final ModelPart TailMid;
	private final ModelPart TailTumor2;
	private final ModelPart Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart TailTumor1;
	private final ModelPart TailMid2;
	private final ModelPart TailTumor3;
	private final ModelPart Fin;
	private final ModelPart TailTumorsLeft;
	private final ModelPart TailTumorsRight;
	private final ModelPart TailTumorMid;

	public NaiadTritonModel(ModelPart root) {
		this.Naiad = root.getChild("Naiad");
		this.Torso = this.Naiad.getChild("Torso");
		this.ActualTorso = this.Torso.getChild("ActualTorso");
		this.UpperChest = this.ActualTorso.getChild("UpperChest");
		this.Tendrils1 = this.UpperChest.getChild("Tendrils1");
		this.LowerChest = this.ActualTorso.getChild("LowerChest");
		this.Tendrils2 = this.LowerChest.getChild("Tendrils2");
		this.WaistTumors = this.LowerChest.getChild("WaistTumors");
		this.WaistTumorGroup1 = this.WaistTumors.getChild("WaistTumorGroup1");
		this.WaistTumorGroup2 = this.WaistTumors.getChild("WaistTumorGroup2");
		this.WaistTumorGroup3 = this.WaistTumors.getChild("WaistTumorGroup3");
		this.WaistTumorGroup4 = this.WaistTumors.getChild("WaistTumorGroup4");
		this.Head = this.Torso.getChild("Head");
		this.LowerJaw = this.Head.getChild("LowerJaw");
		this.Fins = this.Head.getChild("Fins");
		this.HeadFoliage = this.Head.getChild("HeadFoliage");
		this.Arms = this.Torso.getChild("Arms");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightArmTop = this.RightArm.getChild("RightArmTop");
		this.Coral = this.RightArmTop.getChild("Coral");
		this.RightArmBottom = this.RightArm.getChild("RightArmBottom");
		this.Shell2 = this.RightArm.getChild("Shell2");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftArmTop = this.LeftArm.getChild("LeftArmTop");
		this.Shell = this.LeftArmTop.getChild("Shell");
		this.LeftArmBottom = this.LeftArm.getChild("LeftArmBottom");
		this.Trident = this.LeftArmBottom.getChild("Trident");
		this.Tendons = this.LeftArmBottom.getChild("Tendons");
		this.ArmTumors = this.LeftArmBottom.getChild("ArmTumors");
		this.Tail = this.Naiad.getChild("Tail");
		this.TailTop = this.Tail.getChild("TailTop");
		this.TailBase = this.TailTop.getChild("TailBase");
		this.Tendril3 = this.TailBase.getChild("Tendril3");
		this.TailMid = this.TailTop.getChild("TailMid");
		this.TailTumor2 = this.TailMid.getChild("TailTumor2");
		this.Tendril1 = this.TailMid.getChild("Tendril1");
		this.Tendril2 = this.TailMid.getChild("Tendril2");
		this.TailTumor1 = this.TailTop.getChild("TailTumor1");
		this.TailMid2 = this.Tail.getChild("TailMid2");
		this.TailTumor3 = this.TailMid2.getChild("TailTumor3");
		this.Fin = this.TailMid2.getChild("Fin");
		this.TailTumorsLeft = this.Fin.getChild("TailTumorsLeft");
		this.TailTumorsRight = this.Fin.getChild("TailTumorsRight");
		this.TailTumorMid = this.Fin.getChild("TailTumorMid");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Naiad = partdefinition.addOrReplaceChild("Naiad", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 17.0F, -4.5F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Torso = Naiad.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition ActualTorso = Torso.addOrReplaceChild("ActualTorso", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -3.0F));

		PartDefinition UpperChest = ActualTorso.addOrReplaceChild("UpperChest", CubeListBuilder.create(), PartPose.offset(-0.0056F, -8.601F, 2.1147F));

		PartDefinition GillFoliage4_r1 = UpperChest.addOrReplaceChild("GillFoliage4_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4056F, 1.801F, -3.2146F, 1.9846F, -0.7941F, 1.5625F));

		PartDefinition GillFoliage1_r1 = UpperChest.addOrReplaceChild("GillFoliage1_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7944F, 1.901F, -3.4147F, 1.3738F, -0.7941F, 1.5625F));

		PartDefinition BackFin1_r1 = UpperChest.addOrReplaceChild("BackFin1_r1", CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, -4.0F, -2.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0056F, -3.099F, 3.8853F, 0.0699F, -0.0348F, -0.0024F));

		PartDefinition UpperChestBra_r1 = UpperChest.addOrReplaceChild("UpperChestBra_r1", CubeListBuilder.create().texOffs(28, 28).addBox(-4.0F, -2.0F, -1.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.1F))
				.texOffs(0, 28).addBox(-4.0F, -2.0F, -1.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, -4.399F, -2.1147F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Tendrils1 = UpperChest.addOrReplaceChild("Tendrils1", CubeListBuilder.create(), PartPose.offset(0.0056F, 21.601F, 3.0854F));

		PartDefinition Tendril5_r1 = Tendrils1.addOrReplaceChild("Tendril5_r1", CubeListBuilder.create().texOffs(62, 23).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -21.0F, 0.9F, 0.3867F, -0.0263F, -0.0873F));

		PartDefinition Tendril4_r1 = Tendrils1.addOrReplaceChild("Tendril4_r1", CubeListBuilder.create().texOffs(82, 20).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -23.3F, 0.9F, 0.6285F, -0.0525F, -0.0226F));

		PartDefinition Tendril2_r1 = Tendrils1.addOrReplaceChild("Tendril2_r1", CubeListBuilder.create().texOffs(82, 12).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -21.3F, 0.9F, 0.5848F, -0.0525F, -0.0226F));

		PartDefinition Tendril1_r1 = Tendrils1.addOrReplaceChild("Tendril1_r1", CubeListBuilder.create().texOffs(82, 20).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4F, -24.7F, 0.4F, 0.4134F, -0.0878F, 0.0574F));

		PartDefinition LowerChest = ActualTorso.addOrReplaceChild("LowerChest", CubeListBuilder.create(), PartPose.offset(0.0598F, -6.1194F, 1.7328F));

		PartDefinition GillFoliage6_r1 = LowerChest.addOrReplaceChild("GillFoliage6_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1402F, 2.5194F, -2.0328F, 1.7207F, -0.4896F, 1.7592F));

		PartDefinition GillFoliage5_r1 = LowerChest.addOrReplaceChild("GillFoliage5_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3402F, 1.1194F, -2.0328F, 1.241F, -0.5574F, 1.6274F));

		PartDefinition GillFoliage3_r1 = LowerChest.addOrReplaceChild("GillFoliage3_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1598F, 2.9194F, -1.4328F, 1.2516F, -0.7941F, 1.5625F));

		PartDefinition GillFoliage2_r1 = LowerChest.addOrReplaceChild("GillFoliage2_r1", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, 0.0F, -2.0F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8598F, 1.2194F, -2.0328F, 1.5832F, -0.7941F, 1.5625F));

		PartDefinition BackFin2_r1 = LowerChest.addOrReplaceChild("BackFin2_r1", CubeListBuilder.create().texOffs(52, 81).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9402F, -0.6806F, 4.2672F, 0.0699F, 0.0348F, 0.0024F));

		PartDefinition LowerChest_r1 = LowerChest.addOrReplaceChild("LowerChest_r1", CubeListBuilder.create().texOffs(34, 10).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0598F, 0.0194F, -1.4328F, 0.2269F, 0.0F, 0.0F));

		PartDefinition Tendrils2 = LowerChest.addOrReplaceChild("Tendrils2", CubeListBuilder.create(), PartPose.offset(-0.0598F, 19.1195F, 3.4672F));

		PartDefinition Tendril7_r1 = Tendrils2.addOrReplaceChild("Tendril7_r1", CubeListBuilder.create().texOffs(82, 12).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -18.5F, 1.9F, 0.8736F, 0.0278F, -0.0899F));

		PartDefinition WaistTumors = LowerChest.addOrReplaceChild("WaistTumors", CubeListBuilder.create(), PartPose.offset(-0.0598F, 19.1195F, 3.4672F));

		PartDefinition WaistTumorGroup1 = WaistTumors.addOrReplaceChild("WaistTumorGroup1", CubeListBuilder.create(), PartPose.offset(2.7F, -16.9F, -3.5F));

		PartDefinition WaistTumor3_r1 = WaistTumorGroup1.addOrReplaceChild("WaistTumor3_r1", CubeListBuilder.create().texOffs(32, 65).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.307F, -0.9792F, 1.7068F));

		PartDefinition WaistTumor2_r1 = WaistTumorGroup1.addOrReplaceChild("WaistTumor2_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-2.3F, 2.0F, 1.1F, 0.5266F, -0.3443F, 0.1354F));

		PartDefinition WaistTumor1_r1 = WaistTumorGroup1.addOrReplaceChild("WaistTumor1_r1", CubeListBuilder.create().texOffs(52, 57).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 1.0F, 0.9309F, -0.4728F, 0.8277F));

		PartDefinition WaistTumorGroup2 = WaistTumors.addOrReplaceChild("WaistTumorGroup2", CubeListBuilder.create(), PartPose.offset(-2.9871F, -15.988F, -3.4395F));

		PartDefinition WaistTumor6_r1 = WaistTumorGroup2.addOrReplaceChild("WaistTumor6_r1", CubeListBuilder.create().texOffs(68, 56).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3165F, -0.6675F, 1.2091F));

		PartDefinition WaistTumor5_r1 = WaistTumorGroup2.addOrReplaceChild("WaistTumor5_r1", CubeListBuilder.create().texOffs(0, 65).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.6871F, -0.712F, 0.3395F, 2.4184F, -0.2076F, 0.5581F));

		PartDefinition WaistTumor4_r1 = WaistTumorGroup2.addOrReplaceChild("WaistTumor4_r1", CubeListBuilder.create().texOffs(16, 72).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(1.3F, 0.0F, -0.4F, 0.6414F, -1.1629F, 0.6922F));

		PartDefinition WaistTumorGroup3 = WaistTumors.addOrReplaceChild("WaistTumorGroup3", CubeListBuilder.create(), PartPose.offset(1.7F, -17.7F, -2.3F));

		PartDefinition WaistTumor9_r1 = WaistTumorGroup3.addOrReplaceChild("WaistTumor9_r1", CubeListBuilder.create().texOffs(16, 64).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(-2.6F, -2.8F, 2.2F, 2.7533F, 0.7354F, -0.2463F));

		PartDefinition WaistTumor8_r1 = WaistTumorGroup3.addOrReplaceChild("WaistTumor8_r1", CubeListBuilder.create().texOffs(58, 18).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 2.0F, 2.8647F, 0.8328F, -0.6617F));

		PartDefinition WaistTumor7_r1 = WaistTumorGroup3.addOrReplaceChild("WaistTumor7_r1", CubeListBuilder.create().texOffs(58, 10).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.0632F, -0.1234F, -0.7572F));

		PartDefinition WaistTumorGroup4 = WaistTumors.addOrReplaceChild("WaistTumorGroup4", CubeListBuilder.create(), PartPose.offset(1.7F, -17.7F, -2.3F));

		PartDefinition WaistTumor12_r1 = WaistTumorGroup4.addOrReplaceChild("WaistTumor12_r1", CubeListBuilder.create().texOffs(64, 65).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-1.7769F, 0.8314F, 2.2395F, 2.5914F, 0.0563F, -0.9983F));

		PartDefinition WaistTumor11_r1 = WaistTumorGroup4.addOrReplaceChild("WaistTumor11_r1", CubeListBuilder.create().texOffs(50, 40).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-3.9768F, 1.4314F, 2.4395F, 2.7886F, 1.1065F, -0.8371F));

		PartDefinition WaistTumor10_r1 = WaistTumorGroup4.addOrReplaceChild("WaistTumor10_r1", CubeListBuilder.create().texOffs(48, 65).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-5.4768F, 0.8314F, 1.0395F, 2.5914F, 0.0563F, -0.9983F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.9F, -6.3F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(4, 110).addBox(-4.0F, -7.9F, -6.3F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.12F))
				.texOffs(20, 48).addBox(-4.0F, -1.9F, -2.3F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.1F, -1.7F, -0.7418F, 0.0F, 0.0F));

		PartDefinition Ear2_r1 = Head.addOrReplaceChild("Ear2_r1", CubeListBuilder.create().texOffs(42, 73).addBox(0.0F, -4.5F, -2.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, -7.4F, 0.8F, 0.2377F, 0.3471F, -0.038F));

		PartDefinition Ear1_r1 = Head.addOrReplaceChild("Ear1_r1", CubeListBuilder.create().texOffs(42, 73).addBox(0.0F, -4.5F, -2.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1F, -7.4F, 0.8F, 0.2377F, -0.3471F, 0.038F));

		PartDefinition LowerJaw = Head.addOrReplaceChild("LowerJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.6278F, -2.1397F, -0.0873F, 0.0F, 0.0F));

		PartDefinition SideTeeth2_r1 = LowerJaw.addOrReplaceChild("SideTeeth2_r1", CubeListBuilder.create().texOffs(36, 55).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8F, -0.3396F, -2.2238F, 1.5708F, 1.501F, 1.5708F));

		PartDefinition SideTeeth1_r1 = LowerJaw.addOrReplaceChild("SideTeeth1_r1", CubeListBuilder.create().texOffs(36, 54).addBox(-2.0F, -0.5F, 0.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -0.4001F, -2.1189F, 1.5708F, -1.501F, -1.5708F));

		PartDefinition FrontTeeth_r1 = LowerJaw.addOrReplaceChild("FrontTeeth_r1", CubeListBuilder.create().texOffs(92, 12).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8173F, -4.3375F, 0.2269F, 0.0F, 0.0F));

		PartDefinition LowerJawMain_r1 = LowerJaw.addOrReplaceChild("LowerJawMain_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-4.0F, -0.0212F, -4.2864F, 8.0F, 1.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.2711F, -0.0865F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Fins = Head.addOrReplaceChild("Fins", CubeListBuilder.create(), PartPose.offset(0.0F, 28.4F, 2.6F));

		PartDefinition HeadFin3_r1 = Fins.addOrReplaceChild("HeadFin3_r1", CubeListBuilder.create().texOffs(56, 28).addBox(-1.0F, -4.0F, -5.0F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -34.1F, -0.5F, -0.6102F, 0.03F, 0.0429F));

		PartDefinition HeadFin2_r1 = Fins.addOrReplaceChild("HeadFin2_r1", CubeListBuilder.create().texOffs(92, 82).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -32.1F, 0.5F, 0.0F, -0.0524F, 0.0F));

		PartDefinition HeadFin1_r1 = Fins.addOrReplaceChild("HeadFin1_r1", CubeListBuilder.create().texOffs(70, 94).addBox(-1.0F, -4.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -36.0F, -4.4F, 0.0F, 0.0F, -0.0349F));

		PartDefinition HeadFoliage = Head.addOrReplaceChild("HeadFoliage", CubeListBuilder.create().texOffs(0, 46).addBox(-1.0F, -36.0F, -9.2F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 28.1F, 2.9F));

		PartDefinition SeaGrass2_r1 = HeadFoliage.addOrReplaceChild("SeaGrass2_r1", CubeListBuilder.create().texOffs(52, 91).addBox(0.0F, -1.5F, -2.5F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2654F, -37.2231F, -4.2182F, -3.1416F, 0.2356F, 3.1067F));

		PartDefinition SeaGrass1_r1 = HeadFoliage.addOrReplaceChild("SeaGrass1_r1", CubeListBuilder.create().texOffs(92, 48).addBox(-1.0F, -3.0F, -3.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, -35.7F, -7.2F, 0.0F, 0.7069F, -0.0349F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, -2.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.6F, 0.1F, 0.1F, -1.309F, 0.0F, 0.0F));

		PartDefinition RightArmTop = RightArm.addOrReplaceChild("RightArmTop", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArmTop_r1 = RightArmTop.addOrReplaceChild("RightArmTop_r1", CubeListBuilder.create().texOffs(80, 43).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 0.9F, -0.2F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Coral = RightArmTop.addOrReplaceChild("Coral", CubeListBuilder.create(), PartPose.offset(4.6F, 26.9F, 4.1F));

		PartDefinition CoralFan4_r1 = Coral.addOrReplaceChild("CoralFan4_r1", CubeListBuilder.create().texOffs(98, 37).addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2922F, -24.7264F, -5.3399F, -2.4607F, 0.2629F, 1.7669F));

		PartDefinition CoralFan3_r1 = Coral.addOrReplaceChild("CoralFan3_r1", CubeListBuilder.create().texOffs(98, 32).addBox(-2.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4982F, -27.2F, -5.41F, -2.4551F, -0.2871F, 1.3313F));

		PartDefinition CoralFan2_r1 = Coral.addOrReplaceChild("CoralFan2_r1", CubeListBuilder.create().texOffs(66, 43).addBox(-2.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0982F, -25.5F, -6.81F, 0.0F, -1.9897F, 0.0F));

		PartDefinition CoralFan1_r1 = Coral.addOrReplaceChild("CoralFan1_r1", CubeListBuilder.create().texOffs(98, 72).addBox(-2.0F, -2.5F, 0.0F, 5.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7982F, -25.5F, -4.11F, 0.0F, 0.2793F, 0.0F));

		PartDefinition RightArmBottom = RightArm.addOrReplaceChild("RightArmBottom", CubeListBuilder.create(), PartPose.offset(-1.8F, 4.9F, 0.2F));

		PartDefinition RightArmFin_r1 = RightArmBottom.addOrReplaceChild("RightArmFin_r1", CubeListBuilder.create().texOffs(92, 62).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, 2.6F, 1.1F, 0.32F, -1.2426F, -0.2154F));

		PartDefinition RightArmBottom_r1 = RightArmBottom.addOrReplaceChild("RightArmBottom_r1", CubeListBuilder.create().texOffs(76, 73).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.6F, 1.8F, -0.4F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Shell2 = RightArm.addOrReplaceChild("Shell2", CubeListBuilder.create().texOffs(28, 80).addBox(-3.2F, -3.0F, -5.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.2F))
				.texOffs(57, 99).addBox(-4.8F, -3.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.1F, -0.1F, 3.0F, 0.412F, -0.5864F, -0.6646F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.6F, 0.1F, 0.1F, -1.2654F, 0.0F, -0.1309F));

		PartDefinition LeftArmTop = LeftArm.addOrReplaceChild("LeftArmTop", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArmTop_r1 = LeftArmTop.addOrReplaceChild("LeftArmTop_r1", CubeListBuilder.create().texOffs(80, 64).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 0.9F, -0.2F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Shell = LeftArmTop.addOrReplaceChild("Shell", CubeListBuilder.create().texOffs(44, 48).addBox(-3.2F, -3.0F, -5.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(-0.2F))
				.texOffs(52, 73).addBox(-4.8F, -3.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(-0.2F))
				.texOffs(77, 9).addBox(-4.8F, -3.0F, -5.0F, 2.0F, 3.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.7F, -0.1F, -1.7F, 2.9979F, -0.0445F, -2.5475F));

		PartDefinition LeftArmBottom = LeftArm.addOrReplaceChild("LeftArmBottom", CubeListBuilder.create(), PartPose.offset(1.8F, 4.9F, 0.2F));

		PartDefinition Trident = LeftArmBottom.addOrReplaceChild("Trident", CubeListBuilder.create().texOffs(1, 104).addBox(-1.0229F, -10.3772F, -0.5F, 1.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 109).addBox(-2.0229F, -6.3772F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 109).addBox(-0.0229F, -6.3772F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 103).addBox(0.9771F, -9.3772F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(7, 103).addBox(-3.0229F, -9.3772F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 1.1F, 0.1F, 3.1416F, 0.0F, -0.0873F));

		PartDefinition Tendons = LeftArmBottom.addOrReplaceChild("Tendons", CubeListBuilder.create(), PartPose.offset(-6.4F, 22.0F, 6.2F));

		PartDefinition Tendons4_r1 = Tendons.addOrReplaceChild("Tendons4_r1", CubeListBuilder.create().texOffs(16, 100).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -20.7F, -6.5F, 1.309F, -1.5359F, -1.6581F));

		PartDefinition Tendons3_r1 = Tendons.addOrReplaceChild("Tendons3_r1", CubeListBuilder.create().texOffs(16, 100).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4F, -20.7F, -6.5F, 1.8326F, -1.5359F, -1.6581F));

		PartDefinition Tendons2_r1 = Tendons.addOrReplaceChild("Tendons2_r1", CubeListBuilder.create().texOffs(15, 104).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -20.5F, -5.3F, -0.1745F, 0.0F, -0.0873F));

		PartDefinition Tendons1_r1 = Tendons.addOrReplaceChild("Tendons1_r1", CubeListBuilder.create().texOffs(15, 104).addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -20.5F, -6.9F, 0.1745F, 0.0F, -0.0873F));

		PartDefinition ArmTumors = LeftArmBottom.addOrReplaceChild("ArmTumors", CubeListBuilder.create(), PartPose.offset(-0.1204F, 0.412F, -0.0061F));

		PartDefinition TridetTumor3_r1 = ArmTumors.addOrReplaceChild("TridetTumor3_r1", CubeListBuilder.create().texOffs(16, 72).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(0.0333F, 0.0F, 0.4667F, -1.252F, -1.0158F, 2.9276F));

		PartDefinition TridetTumor2_r1 = ArmTumors.addOrReplaceChild("TridetTumor2_r1", CubeListBuilder.create().texOffs(16, 72).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.3333F, 0.0F, -0.2333F, -2.4465F, -0.6582F, -2.476F));

		PartDefinition TridetTumor1_r1 = ArmTumors.addOrReplaceChild("TridetTumor1_r1", CubeListBuilder.create().texOffs(16, 72).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(-0.3667F, 0.0F, -0.2333F, 1.7878F, -0.5484F, -0.4378F));

		PartDefinition Tail = Naiad.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition TailTop = Tail.addOrReplaceChild("TailTop", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TailFin2_r1 = TailTop.addOrReplaceChild("TailFin2_r1", CubeListBuilder.create().texOffs(66, 73).addBox(-1.0F, -4.0F, -2.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, 4.3F, 0.9F, 1.2095F, 1.1305F, 1.1719F));

		PartDefinition TailFin1_r1 = TailTop.addOrReplaceChild("TailFin1_r1", CubeListBuilder.create().texOffs(66, 73).addBox(-1.0F, -4.0F, -3.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 3.3F, 2.9F, 1.549F, -1.1606F, -1.5502F));

		PartDefinition TailBase = TailTop.addOrReplaceChild("TailBase", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 2.2F));

		PartDefinition TailBaseFin_r1 = TailBase.addOrReplaceChild("TailBaseFin_r1", CubeListBuilder.create().texOffs(88, 32).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -15.6F, 2.2F, 0.3838F, 0.0025F, -0.0106F));

		PartDefinition TailBase_r1 = TailBase.addOrReplaceChild("TailBase_r1", CubeListBuilder.create().texOffs(26, 40).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -14.2F, -3.4F, 0.3578F, 0.0F, 0.0F));

		PartDefinition Tendril3 = TailBase.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TendrilEnd_r1 = Tendril3.addOrReplaceChild("TendrilEnd_r1", CubeListBuilder.create().texOffs(24, 99).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.4F, -15.8F, 7.1F, 1.7256F, -0.343F, 0.0315F));

		PartDefinition TendrilBase_r1 = Tendril3.addOrReplaceChild("TendrilBase_r1", CubeListBuilder.create().texOffs(92, 90).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.4F, -15.1F, 4.3F, 1.1551F, -0.2518F, 0.0879F));

		PartDefinition TailMid = TailTop.addOrReplaceChild("TailMid", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 2.2F));

		PartDefinition TailTendril1_r1 = TailMid.addOrReplaceChild("TailTendril1_r1", CubeListBuilder.create().texOffs(82, 12).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -11.7F, 4.3F, 1.1521F, -0.0525F, -0.0226F));

		PartDefinition TailMidFin_r1 = TailMid.addOrReplaceChild("TailMidFin_r1", CubeListBuilder.create().texOffs(10, 89).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -12.3F, 3.7F, 0.4896F, 0.0641F, 0.0222F));

		PartDefinition TailBaseMid_r1 = TailMid.addOrReplaceChild("TailBaseMid_r1", CubeListBuilder.create().texOffs(34, 19).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -10.5F, -1.9F, 0.4887F, 0.0F, 0.0F));

		PartDefinition TailTumor2 = TailMid.addOrReplaceChild("TailTumor2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 2.3F));

		PartDefinition TailTumor2_r1 = TailTumor2.addOrReplaceChild("TailTumor2_r1", CubeListBuilder.create().texOffs(0, 73).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-3.1871F, -8.988F, -2.9395F, -2.2598F, -0.1768F, -0.3978F));

		PartDefinition Tendril1 = TailMid.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TendrilEnd_r2 = Tendril1.addOrReplaceChild("TendrilEnd_r2", CubeListBuilder.create().texOffs(52, 99).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.3F, -11.0F, 8.1F, 1.5858F, 0.3027F, 0.0411F));

		PartDefinition TendrilBase_r2 = Tendril1.addOrReplaceChild("TendrilBase_r2", CubeListBuilder.create().texOffs(84, 94).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.5F, -10.8F, 5.4F, 1.116F, 0.276F, -0.1325F));

		PartDefinition Tendril2 = TailMid.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offset(5.3F, -11.0F, 8.1F));

		PartDefinition TendrilEnd_r3 = Tendril2.addOrReplaceChild("TendrilEnd_r3", CubeListBuilder.create().texOffs(70, 85).addBox(-0.5F, -4.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-10.8F, 2.8F, 0.2F, 1.5795F, -0.1877F, 0.0561F));

		PartDefinition TendrilBase_r3 = Tendril2.addOrReplaceChild("TendrilBase_r3", CubeListBuilder.create().texOffs(28, 97).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-10.4F, 3.1F, -2.8F, 0.8852F, -0.3542F, 0.1733F));

		PartDefinition TailTumor1 = TailTop.addOrReplaceChild("TailTumor1", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 4.5F));

		PartDefinition TailTumor1_r1 = TailTumor1.addOrReplaceChild("TailTumor1_r1", CubeListBuilder.create().texOffs(36, 57).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(2.9F, -11.9F, -2.2F, 1.1972F, 0.2605F, -0.4636F));

		PartDefinition TailMid2 = Tail.addOrReplaceChild("TailMid2", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 2.2F));

		PartDefinition TailTendril2_r1 = TailMid2.addOrReplaceChild("TailTendril2_r1", CubeListBuilder.create().texOffs(82, 12).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.9F, 3.8F, 1.0037F, -0.0525F, -0.0226F));

		PartDefinition TailMid2Fin_r1 = TailMid2.addOrReplaceChild("TailMid2Fin_r1", CubeListBuilder.create().texOffs(88, 73).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.6F, 5.7F, 0.7147F, 0.0114F, -0.0237F));

		PartDefinition TailBaseMid2_r1 = TailMid2.addOrReplaceChild("TailBaseMid2_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.5F, -0.2F, 0.6196F, 0.0F, 0.0F));

		PartDefinition TailTumor3 = TailMid2.addOrReplaceChild("TailTumor3", CubeListBuilder.create(), PartPose.offset(1.0F, -1.0F, 2.3F));

		PartDefinition TailTumor3_r1 = TailTumor3.addOrReplaceChild("TailTumor3_r1", CubeListBuilder.create().texOffs(72, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.2129F, -0.288F, 0.6605F, -2.2598F, -0.1768F, -0.3978F));

		PartDefinition Fin = TailMid2.addOrReplaceChild("Fin", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 2.0F));

		PartDefinition TailEndFin2_r1 = Fin.addOrReplaceChild("TailEndFin2_r1", CubeListBuilder.create().texOffs(78, 94).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 0.3F, 10.6F, 1.639F, 0.0331F, -0.0256F));

		PartDefinition TailEndFin1_r1 = Fin.addOrReplaceChild("TailEndFin1_r1", CubeListBuilder.create().texOffs(0, 92).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -2.2F, 6.0F, 1.327F, 0.0283F, 0.0441F));

		PartDefinition TailFrame2_r1 = Fin.addOrReplaceChild("TailFrame2_r1", CubeListBuilder.create().texOffs(66, 39).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.5F, 2.6F, -0.038F, 0.3471F, -0.1114F));

		PartDefinition TailFrame1_r1 = Fin.addOrReplaceChild("TailFrame1_r1", CubeListBuilder.create().texOffs(66, 41).addBox(-5.0F, -1.0F, -1.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.5F, 2.7F, -0.1086F, -0.3465F, 0.1004F));

		PartDefinition TailFinRight_r1 = Fin.addOrReplaceChild("TailFinRight_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-9.0F, 0.0F, -4.0F, 10.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 0.5F, 4.1F, -0.2962F, 0.335F, -0.1F));

		PartDefinition TailFinLeft_r1 = Fin.addOrReplaceChild("TailFinLeft_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-1.0F, 0.0F, -4.0F, 10.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 0.5F, 4.1F, -0.2962F, -0.335F, 0.1F));

		PartDefinition TailBaseEnd_r1 = Fin.addOrReplaceChild("TailBaseEnd_r1", CubeListBuilder.create().texOffs(70, 26).addBox(-3.0F, -2.0F, 1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.5F, 1.9F, 1.3F, 1.3177F, 0.0F, 0.0F));

		PartDefinition TailTumorsLeft = Fin.addOrReplaceChild("TailTumorsLeft", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -2.0F));

		PartDefinition TailTumorLeft4_r1 = TailTumorsLeft.addOrReplaceChild("TailTumorLeft4_r1", CubeListBuilder.create().texOffs(90, 20).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(1.1452F, -5.0229F, 3.4912F, -0.6846F, -0.7034F, 0.026F));

		PartDefinition TailTumorLeft3_r1 = TailTumorsLeft.addOrReplaceChild("TailTumorLeft3_r1", CubeListBuilder.create().texOffs(88, 0).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(2.9F, -4.6F, 1.8F, -0.5707F, -0.0405F, 0.0675F));

		PartDefinition TailTumorLeft2_r1 = TailTumorsLeft.addOrReplaceChild("TailTumorLeft2_r1", CubeListBuilder.create().texOffs(92, 42).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.4F, -3.3F, 4.0F, -0.1678F, 0.4257F, -0.1875F));

		PartDefinition TailTumorLeft1_r1 = TailTumorsLeft.addOrReplaceChild("TailTumorLeft1_r1", CubeListBuilder.create().texOffs(92, 14).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.8F, -4.6F, 2.5F, -0.2127F, 0.0828F, 0.3395F));

		PartDefinition TailTumorsRight = Fin.addOrReplaceChild("TailTumorsRight", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -2.0F));

		PartDefinition TailTumorRight3_r1 = TailTumorsRight.addOrReplaceChild("TailTumorRight3_r1", CubeListBuilder.create().texOffs(90, 26).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.4173F, -4.6268F, 5.0113F, 3.0053F, 1.2925F, 3.0668F));

		PartDefinition TailTumorRight2_r1 = TailTumorsRight.addOrReplaceChild("TailTumorRight2_r1", CubeListBuilder.create().texOffs(92, 56).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-5.3F, -4.6F, 3.4F, -1.1922F, 0.7342F, -0.9209F));

		PartDefinition TailTumorRight1_r1 = TailTumorsRight.addOrReplaceChild("TailTumorRight1_r1", CubeListBuilder.create().texOffs(92, 6).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.5F, -3.7F, 2.0F, -0.4735F, 0.3522F, -0.551F));

		PartDefinition TailTumorMid = Fin.addOrReplaceChild("TailTumorMid", CubeListBuilder.create(), PartPose.offset(-1.3F, -1.2F, 2.9F));

		PartDefinition TailTumorMid_r1 = TailTumorMid.addOrReplaceChild("TailTumorMid_r1", CubeListBuilder.create().texOffs(64, 48).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(0.1F, 0.3F, -0.3F, 0.9309F, -0.4728F, 0.8277F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Naiad.getAllParts().forEach(ModelPart::resetPose);
		float v3 = Mth.sin(ageInTicks/7)/6;
		float v2 = Mth.cos(ageInTicks/6)/7;
		float v4 = Mth.cos(ageInTicks/8)/8;
		float movement = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		animateTentacleY(Head,netHeadYaw / (180F / (float) Math.PI));
		animateTumor(WaistTumorGroup1,-v3);
		animateTumor(WaistTumorGroup2,v2);
		animateTumor(WaistTumorGroup3,v3);
		animateTumor(WaistTumorGroup4,-v2);
		animateTumor(TailTumor1,-v4);
		animateTumor(TailTumor2,v2);
		animateTumor(TailTumor3,v3);
		animateTentacleZ(Tendril1,v2);
		animateTentacleZ(Tendril2,-v2);
		animateTentacleZ(Tendril3,v3);
		animateTentacleX(LowerJaw,v4+0.2f);
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (entity.isInWater()){
				float xRotArm = Mth.clampedLerp(-1.0471976F, -0.2617994F, (Mth.sin(-limbSwing) + 1.0F) / 2.0F);
				float yRotArm = Mth.clampedLerp(-0.7853982F, 0.7853982F, (Mth.sin(-limbSwing + 1.0F) + 1.0F) / 2.0F);
				this.animateTentacleX(RightArm,xRotArm);
				this.animateTentacleX(LeftArm,xRotArm);
				this.animateTentacleY(RightArm,yRotArm);
				this.animateTentacleY(LeftArm,-yRotArm);
				this.animateTentacleX(Tail,movement);
				this.animateTentacleX(TailMid2,movement);
			}else {
				this.animateTentacleX(RightArm,movement);
				this.animateTentacleX(LeftArm,-movement);
				this.animateTentacleZ(Tail,v4);
				this.animateTentacleZ(TailMid2,v4);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Naiad.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}