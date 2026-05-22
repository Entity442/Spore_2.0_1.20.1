package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Gorgon;
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

public class GorgonSpookyModel<T extends Gorgon> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "gorgonspookymodel"), "main");
	private final ModelPart GorgonModel;
	private final ModelPart Gorgon;
	private final ModelPart Head;
	private final ModelPart Tumours3;
	private final ModelPart Tendrils;
	private final ModelPart Tendril3;
	private final ModelPart Tendril4;
	private final ModelPart Tendril5;
	private final ModelPart Tendril6;
	private final ModelPart Tendril;
	private final ModelPart Tendril2;
	private final ModelPart Tendril7;
	private final ModelPart Tendril8;
	private final ModelPart Tendril9;
	private final ModelPart Tendril10;
	private final ModelPart Tumours2;
	private final ModelPart Tumour;
	private final ModelPart WitchHat;
	private final ModelPart FullSkull;
	private final ModelPart Skull;
	private final ModelPart BrokenJaw;
	private final ModelPart Torso;
	private final ModelPart GasSacks;
	private final ModelPart BackFollicles;
	private final ModelPart Sack;
	private final ModelPart Sack2;
	private final ModelPart MiniGasSack;
	private final ModelPart WaistTumours;
	private final ModelPart Tumours;
	private final ModelPart RuinedRightArm;
	private final ModelPart ArmTumour;
	private final ModelPart ArmTumours;
	private final ModelPart Legs;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart LeftArm;

	public GorgonSpookyModel(ModelPart root) {
		this.GorgonModel = root.getChild("GorgonModel");
		this.Gorgon = this.GorgonModel.getChild("Gorgon");
		this.Head = this.Gorgon.getChild("Head");
		this.Tumours3 = this.Head.getChild("Tumours3");
		this.Tendrils = this.Head.getChild("Tendrils");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.Tendril4 = this.Tendril3.getChild("Tendril4");
		this.Tendril5 = this.Tendrils.getChild("Tendril5");
		this.Tendril6 = this.Tendril5.getChild("Tendril6");
		this.Tendril = this.Tendrils.getChild("Tendril");
		this.Tendril2 = this.Tendril.getChild("Tendril2");
		this.Tendril7 = this.Tendrils.getChild("Tendril7");
		this.Tendril8 = this.Tendril7.getChild("Tendril8");
		this.Tendril9 = this.Tendrils.getChild("Tendril9");
		this.Tendril10 = this.Tendril9.getChild("Tendril10");
		this.Tumours2 = this.Head.getChild("Tumours2");
		this.Tumour = this.Head.getChild("Tumour");
		this.WitchHat = this.Head.getChild("WitchHat");
		this.FullSkull = this.Head.getChild("FullSkull");
		this.Skull = this.FullSkull.getChild("Skull");
		this.BrokenJaw = this.FullSkull.getChild("BrokenJaw");
		this.Torso = this.Gorgon.getChild("Torso");
		this.GasSacks = this.Torso.getChild("GasSacks");
		this.BackFollicles = this.GasSacks.getChild("BackFollicles");
		this.Sack = this.GasSacks.getChild("Sack");
		this.Sack2 = this.GasSacks.getChild("Sack2");
		this.MiniGasSack = this.Torso.getChild("MiniGasSack");
		this.WaistTumours = this.Torso.getChild("WaistTumours");
		this.Tumours = this.Torso.getChild("Tumours");
		this.RuinedRightArm = this.Gorgon.getChild("RuinedRightArm");
		this.ArmTumour = this.RuinedRightArm.getChild("ArmTumour");
		this.ArmTumours = this.RuinedRightArm.getChild("ArmTumours");
		this.Legs = this.Gorgon.getChild("Legs");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.LeftArm = this.Gorgon.getChild("LeftArm");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition GorgonModel = partdefinition.addOrReplaceChild("GorgonModel", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Gorgon = GorgonModel.addOrReplaceChild("Gorgon", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head = Gorgon.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -2.8F, -0.2F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -28.5F, -7.4F, 0.1001F, 0.2307F, -0.1657F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, 0.9F, -0.4F, -0.1843F, -0.0271F, 1.1068F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 6.0F, -0.2F, -0.0594F, 0.0354F, -3.0466F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 5.2F, -0.2F, -0.6716F, -0.7028F, 2.9537F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 5.7F, -0.2F, -0.8751F, 0.1266F, -2.9131F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 3.9F, 0.7F, -0.6627F, 0.1354F, -1.21F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.9F, -0.3F, -0.6988F, -0.148F, -1.8224F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(77, 7).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, -5.1F, 4.8F, -0.2221F, 0.0721F, 0.6116F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(77, 14).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 1.5F, 4.9F, 0.1063F, 0.4715F, 0.356F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(17, 76).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, -2.1F, 7.8F, -0.0511F, -0.2495F, 0.4764F));

		PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(76, 73).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4F, 5.7F, 6.3F, 0.1571F, 0.1047F, 0.0F));

		PartDefinition cube_r11 = Head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(81, 35).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7F, 0.8F, 8.3F, 0.0028F, 0.037F, -0.1509F));

		PartDefinition cube_r12 = Head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(81, 28).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6F, 0.4F, 3.2F, 0.1571F, 0.1047F, 0.0F));

		PartDefinition cube_r13 = Head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(117, 93).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.4F, -1.5F, 2.5F, -0.319F, 0.0476F, 0.2681F));

		PartDefinition cube_r14 = Head.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(9, 109).addBox(-1.0F, -5.0F, -3.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6F, 3.6F, -1.0F, -0.0706F, -0.3596F, 0.3307F));

		PartDefinition cube_r15 = Head.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(117, 86).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.2F, 4.5F, 3.1F, -0.3017F, 0.2122F, 0.1428F));

		PartDefinition cube_r16 = Head.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(55, 98).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, -1.5F, 2.0F, -0.2579F, 0.5246F, 0.0259F));

		PartDefinition cube_r17 = Head.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(113, 112).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-4.6F, 1.5F, 3.1F, -0.005F, 0.2122F, 0.1428F));

		PartDefinition cube_r18 = Head.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(70, 101).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.2F, 7.9F, 1.8F, 0.377F, 0.2236F, 0.2509F));

		PartDefinition cube_r19 = Head.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(100, 87).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.9F, 3.2F, 1.6F, 0.1792F, -0.6642F, -0.0257F));

		PartDefinition Tumours3 = Head.addOrReplaceChild("Tumours3", CubeListBuilder.create(), PartPose.offset(-2.9F, 3.2F, 1.6F));

		PartDefinition cube_r20 = Tumours3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(23, 47).addBox(-1.0F, -5.0F, -3.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -1.1F, -4.4F, 0.088F, 0.2601F, -0.0121F));

		PartDefinition cube_r21 = Tumours3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 109).addBox(-1.0F, -5.0F, -3.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -1.6F, -4.2F, 0.0F, 0.6283F, 0.0F));

		PartDefinition cube_r22 = Tumours3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(101, 65).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.0F, -2.9F, 0.0F, 0.1641F, -0.0948F, -0.2331F));

		PartDefinition cube_r23 = Tumours3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(100, 96).addBox(-2.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2169F, 0.2093F, 0.0357F));

		PartDefinition Tendrils = Head.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(1.8F, -1.5F, -0.6F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(106, 25).addBox(-6.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, 1.7F, 3.3F, -2.8362F, -1.4835F, 2.9234F));

		PartDefinition Tendril4 = Tendril3.addOrReplaceChild("Tendril4", CubeListBuilder.create().texOffs(101, 83).addBox(-7.5F, -1.0F, -0.75F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.15F, 0.3F, 0.25F, 0.0F, -0.9599F, 0.0F));

		PartDefinition Tendril5 = Tendrils.addOrReplaceChild("Tendril5", CubeListBuilder.create().texOffs(100, 49).addBox(-5.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2F, -1.6F, -0.1F, 0.0F, -1.3526F, 0.6109F));

		PartDefinition Tendril6 = Tendril5.addOrReplaceChild("Tendril6", CubeListBuilder.create().texOffs(36, 106).addBox(-8.0F, -0.5F, -0.5F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, 0.05F, 0.0F, 0.0F, -0.9599F, 0.0F));

		PartDefinition Tendril = Tendrils.addOrReplaceChild("Tendril", CubeListBuilder.create().texOffs(102, 20).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 6.4F, 1.4F, 0.0F, -1.7017F, 0.0F));

		PartDefinition Tendril2 = Tendril.addOrReplaceChild("Tendril2", CubeListBuilder.create().texOffs(106, 36).addBox(-8.0F, -1.0F, -1.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -0.45F, 0.35F, 0.0F, -1.1345F, -0.0436F));

		PartDefinition Tendril7 = Tendrils.addOrReplaceChild("Tendril7", CubeListBuilder.create().texOffs(19, 106).addBox(1.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.4F, 1.1F, 0.0F, 0.6981F, 0.0F));

		PartDefinition Tendril8 = Tendril7.addOrReplaceChild("Tendril8", CubeListBuilder.create().texOffs(106, 33).addBox(-0.0031F, -0.4071F, -0.4565F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6F, -1.05F, -0.15F, 0.0F, 2.0071F, 0.0F));

		PartDefinition Tendril9 = Tendrils.addOrReplaceChild("Tendril9", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4F, 8.2F, 1.6F, 0.0F, 1.3526F, 0.829F));

		PartDefinition cube_r24 = Tendril9.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(83, 49).addBox(0.5F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1901F, -0.4684F, -0.5241F));

		PartDefinition Tendril10 = Tendril9.addOrReplaceChild("Tendril10", CubeListBuilder.create().texOffs(106, 30).addBox(-0.3532F, -0.2847F, -0.5446F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.45F, -3.8F, 2.6F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Tumours2 = Head.addOrReplaceChild("Tumours2", CubeListBuilder.create(), PartPose.offset(-2.1F, 5.3F, 5.3F));

		PartDefinition cube_r25 = Tumours2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(53, 97).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 3.3F, 0.4F, -0.1249F, -0.2079F, -0.1661F));

		PartDefinition cube_r26 = Tumours2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(101, 74).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 2.4F, 0.8F, -0.238F, 0.2557F, 0.2014F));

		PartDefinition cube_r27 = Tumours2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(19, 97).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2852F, -0.2012F, 0.1632F));

		PartDefinition Tumour = Head.addOrReplaceChild("Tumour", CubeListBuilder.create(), PartPose.offset(4.0F, 7.7F, 5.7F));

		PartDefinition cube_r28 = Tumour.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(36, 97).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0215F, 0.1732F, 0.124F));

		PartDefinition WitchHat = Head.addOrReplaceChild("WitchHat", CubeListBuilder.create().texOffs(0, 0).addBox(-5.7F, -2.05F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.6F, 3.8F, -0.2449F, -0.0677F, -0.1576F));

		PartDefinition hat4_r1 = WitchHat.addOrReplaceChild("hat4_r1", CubeListBuilder.create().texOffs(45, 60).addBox(0.25F, -5.8581F, -0.5064F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F))
				.texOffs(102, 0).addBox(-1.5F, -3.8581F, -2.5064F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -3.7F, 0.6F, -0.5236F, 0.0F, 0.0F));

		PartDefinition hat2_r1 = WitchHat.addOrReplaceChild("hat2_r1", CubeListBuilder.create().texOffs(41, 0).addBox(-3.25F, -4.15F, -3.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -0.9F, -0.9F, -0.2443F, 0.0F, 0.0F));

		PartDefinition FullSkull = Head.addOrReplaceChild("FullSkull", CubeListBuilder.create(), PartPose.offset(1.8F, 28.5F, 7.4F));

		PartDefinition Skull = FullSkull.addOrReplaceChild("Skull", CubeListBuilder.create().texOffs(42, 60).addBox(-1.4F, -1.8F, -2.7F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.6F, -29.7F, -8.2F));

		PartDefinition cube_r29 = Skull.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(31, 116).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3F, 0.6F, -0.1F, 0.0F, -0.5236F, 0.2618F));

		PartDefinition cube_r30 = Skull.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, 1.3F, -1.7F, -0.2146F, -0.8567F, 0.3001F));

		PartDefinition cube_r31 = Skull.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(53, 60).addBox(-0.2F, -0.9F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 1.6F, -1.7F, -0.4525F, -0.0682F, 0.4162F));

		PartDefinition cube_r32 = Skull.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(50, 60).addBox(0.1F, -0.5F, -1.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -1.5F, -1.7F, -0.0594F, 0.0354F, 0.2695F));

		PartDefinition cube_r33 = Skull.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(94, 115).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -1.7F, -2.0F, 0.0647F, 0.4847F, -0.0189F));

		PartDefinition head_r1 = Skull.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -4.3F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.5934F));

		PartDefinition BrokenJaw = FullSkull.addOrReplaceChild("BrokenJaw", CubeListBuilder.create(), PartPose.offset(-2.6F, -22.7F, -7.3F));

		PartDefinition head_r2 = BrokenJaw.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(56, 44).addBox(-1.0F, 1.7F, -4.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.5F, -1.4F, -2.7F, 0.7807F, -0.1853F, -0.7609F));

		PartDefinition cube_r34 = BrokenJaw.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(81, 62).addBox(-1.0F, 0.0F, -1.0F, 10.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9F, 1.1F, -1.3F, 1.0255F, 0.122F, -0.1694F));

		PartDefinition head_r3 = BrokenJaw.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(56, 55).addBox(-4.0F, 1.7F, -4.0F, 4.0F, 2.0F, 8.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 1.1883F, 0.0791F, 0.6827F));

		PartDefinition Torso = Gorgon.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(33, 13).addBox(-3.5F, -6.0F, -2.6F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.5F, -1.7F, 0.4189F, 0.0F, 0.0F));

		PartDefinition Fungus_r1 = Torso.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(50, 90).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1F, 4.6F, 0.0F, 0.1384F, -0.1141F, -0.2968F));

		PartDefinition Fungus_r2 = Torso.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 5.0F, 0.2F, 0.1434F, 0.2346F, 0.0864F));

		PartDefinition Fungus_r3 = Torso.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(75, 87).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -1.9F, -1.3F, 0.2106F, 0.1355F, 0.1181F));

		PartDefinition Fungus_r4 = Torso.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1F, -4.7F, -1.9F, 0.227F, -0.051F, -0.0211F));

		PartDefinition Fungus_r5 = Torso.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(25, 90).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.1F, -1.7F, 0.2618F, -0.1396F, 0.0349F));

		PartDefinition Fungus_r6 = Torso.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(50, 83).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.5F, -1.9F, 0.0958F, -0.0693F, -0.1225F));

		PartDefinition Tumour_r1 = Torso.addOrReplaceChild("Tumour_r1", CubeListBuilder.create().texOffs(49, 113).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -1.8F, -2.0F, 0.1396F, 0.2793F, -0.0873F));

		PartDefinition cube_r35 = Torso.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(83, 42).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8F, 0.1F, -1.1F, 0.1571F, 0.1047F, 0.0F));

		PartDefinition Spine_r1 = Torso.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(102, 9).addBox(-1.0F, -11.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 4.8F, 4.6F, 0.5384F, 0.6551F, 0.3317F));

		PartDefinition Spine_r2 = Torso.addOrReplaceChild("Spine_r2", CubeListBuilder.create().texOffs(100, 105).addBox(-1.0F, -6.0F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 4.9F, 0.4F, -0.5535F, 0.6368F, -0.3695F));

		PartDefinition GasSacks = Torso.addOrReplaceChild("GasSacks", CubeListBuilder.create(), PartPose.offset(0.6F, 3.4F, 0.9F));

		PartDefinition BackFollicles = GasSacks.addOrReplaceChild("BackFollicles", CubeListBuilder.create().texOffs(33, 31).addBox(-8.5F, -6.3F, -7.2F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offset(3.9F, -3.1F, 3.3F));

		PartDefinition cube_r36 = BackFollicles.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(23, 60).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8F, 0.0F, 0.0F, 0.3665F, -0.1222F, 0.0F));

		PartDefinition cube_r37 = BackFollicles.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(62, 28).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, 2.4F, 0.0F, 0.4538F, 0.0F, 0.1047F));

		PartDefinition cube_r38 = BackFollicles.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(58, 12).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2094F, 0.0698F, -0.0024F));

		PartDefinition Sack = GasSacks.addOrReplaceChild("Sack", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition Fungus_r7 = Sack.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(81, 55).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.1F, 6.2F, -0.1249F, 0.24F, 0.0933F));

		PartDefinition Fungus_r8 = Sack.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(77, 21).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 3.7F, 4.7F, -0.0814F, 0.0047F, 0.2278F));

		PartDefinition cube_r39 = Sack.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 47).addBox(-1.0F, -10.0F, -1.0F, 6.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.0F, 0.0F, -0.0213F, 0.296F, -0.073F));

		PartDefinition Sack2 = GasSacks.addOrReplaceChild("Sack2", CubeListBuilder.create(), PartPose.offset(-3.0F, -6.0F, 2.0F));

		PartDefinition Fungus_r9 = Sack2.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(25, 83).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.2F, 3.1F, -0.1538F, -0.4318F, -0.0574F));

		PartDefinition cube_r40 = Sack2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(33, 44).addBox(-1.0F, -10.0F, -1.0F, 6.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 5.7F, -3.0F, -0.0213F, -0.296F, 0.073F));

		PartDefinition MiniGasSack = Torso.addOrReplaceChild("MiniGasSack", CubeListBuilder.create(), PartPose.offset(2.9F, 1.4F, -2.1F));

		PartDefinition cube_r41 = MiniGasSack.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 97).addBox(-1.0F, -6.0F, -1.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 3.0F, 2.7498F, 0.9397F, -3.1361F));

		PartDefinition WaistTumours = Torso.addOrReplaceChild("WaistTumours", CubeListBuilder.create(), PartPose.offset(-0.1F, 3.0F, -3.0F));

		PartDefinition Tumour_r2 = WaistTumours.addOrReplaceChild("Tumour_r2", CubeListBuilder.create().texOffs(18, 111).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0F, 3.5F, 1.0F, 0.1807F, 0.0043F, 0.1862F));

		PartDefinition Tumour_r3 = WaistTumours.addOrReplaceChild("Tumour_r3", CubeListBuilder.create().texOffs(68, 110).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.0F, 1.0F, 0.0487F, 0.1006F, -0.2214F));

		PartDefinition Tumour_r4 = WaistTumours.addOrReplaceChild("Tumour_r4", CubeListBuilder.create().texOffs(62, 117).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.8F, 0.7F, 0.4F, 0.3222F, -0.2524F, 0.1257F));

		PartDefinition Tumour_r5 = WaistTumours.addOrReplaceChild("Tumour_r5", CubeListBuilder.create().texOffs(81, 114).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 1.0F, 0.1534F, -0.1565F, -0.0883F));

		PartDefinition Tumours = Torso.addOrReplaceChild("Tumours", CubeListBuilder.create(), PartPose.offset(2.6F, -4.0F, -1.7F));

		PartDefinition Tumour_r6 = Tumours.addOrReplaceChild("Tumour_r6", CubeListBuilder.create().texOffs(113, 105).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4F, 0.5F, -1.0F, 0.1819F, 0.1045F, 0.0702F));

		PartDefinition Tumour_r7 = Tumours.addOrReplaceChild("Tumour_r7", CubeListBuilder.create().texOffs(106, 54).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -1.0F, 0.2257F, -0.1783F, -0.2492F));

		PartDefinition RuinedRightArm = Gorgon.addOrReplaceChild("RuinedRightArm", CubeListBuilder.create().texOffs(59, 66).addBox(-2.2007F, -0.7728F, -1.8908F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -21.1F, -4.2F, 0.0136F, 0.0506F, 0.297F));

		PartDefinition Tumour_r8 = RuinedRightArm.addOrReplaceChild("Tumour_r8", CubeListBuilder.create().texOffs(36, 109).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.0007F, 1.5272F, 1.7092F, -0.1745F, 0.1571F, -0.1222F));

		PartDefinition Fungus_r10 = RuinedRightArm.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(70, 0).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2993F, -0.1728F, 1.6092F, 0.2137F, -0.0722F, -0.248F));

		PartDefinition Fungus_r11 = RuinedRightArm.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(76, 80).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4993F, 1.7272F, 2.7092F, -0.0873F, 0.0F, -0.1222F));

		PartDefinition Fungus_r12 = RuinedRightArm.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(75, 94).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3993F, 6.0272F, 0.7092F, 0.2374F, 0.1375F, -0.1762F));

		PartDefinition Fungus_r13 = RuinedRightArm.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(76, 66).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9993F, 4.8272F, 3.3092F, -0.2443F, 0.2793F, -0.1222F));

		PartDefinition ArmTumour = RuinedRightArm.addOrReplaceChild("ArmTumour", CubeListBuilder.create(), PartPose.offset(-1.5007F, 10.3272F, 1.4092F));

		PartDefinition Tumour_r9 = ArmTumour.addOrReplaceChild("Tumour_r9", CubeListBuilder.create().texOffs(115, 9).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.375F, 0.201F, -0.1171F));

		PartDefinition ArmTumours = RuinedRightArm.addOrReplaceChild("ArmTumours", CubeListBuilder.create(), PartPose.offset(-1.7007F, 7.0272F, -1.0908F));

		PartDefinition Tumour_r10 = ArmTumours.addOrReplaceChild("Tumour_r10", CubeListBuilder.create().texOffs(108, 39).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.1F, -2.5F, 0.6F, -0.0873F, -0.2618F, -0.0698F));

		PartDefinition Tumour_r11 = ArmTumours.addOrReplaceChild("Tumour_r11", CubeListBuilder.create().texOffs(117, 46).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0352F, -0.1395F, -0.162F));

		PartDefinition Legs = Gorgon.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -11.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(42, 66).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -11.0F, 0.0F));

		PartDefinition LeftArm = Gorgon.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, -22.0F, -3.0F));

		PartDefinition signofgooner_r1 = LeftArm.addOrReplaceChild("signofgooner_r1", CubeListBuilder.create().texOffs(87, 101).addBox(-0.7F, 0.4F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -0.9F, -0.4F, 0.1378F, 0.3008F, -0.1378F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val1 = Mth.cos(ageInTicks/5)/9;
		float val2 = Mth.sin(ageInTicks/6)/11;
		float val3 = Mth.cos(ageInTicks/8)/12;
		float val4 = Mth.sin(ageInTicks/7)/10;
		float val5 = Mth.cos(ageInTicks/8)/13;
		int attackAN = entity.getAttackAnimationTick();
		int vomitAN = entity.getMouthAnimationTick();
		if (vomitAN > 0){
			this.RuinedRightArm.xRot = 0.75F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			this.LeftArm.xRot = 0.75F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			this.RuinedRightArm.zRot = 0.2f;
			this.LeftArm.zRot = -0.2f;
		}else if (attackAN > 0){
			this.RuinedRightArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAN, 20.0F);
			this.LeftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAN, 20.0F);
		} else if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
			this.RuinedRightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RuinedRightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		}else {
			this.RuinedRightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}

		this.LeftLeg.xRot = Mth.cos(limbSwing ) * limbSwingAmount;
		this.RightLeg.xRot = -LeftLeg.xRot;
		if(vomitAN > 0){
			float val  = 1F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			animateTentacleY(Tendril,val);
			animateTentacleY(Tendril2,val);
			animateTentacleY(Tendril3,val);
			animateTentacleY(Tendril4,val);
			animateTentacleY(Tendril5,val);
			animateTentacleY(Tendril6,val);
			animateTentacleY(Tendril7,-val);
			animateTentacleY(Tendril8,-val);
			animateTentacleY(Tendril9,-val);
			animateTentacleY(Tendril10,-val);
		}else {
			animateTentacleY(Tendril,val1);
			animateTentacleY(Tendril2,val1);
			animateTentacleY(Tendril3,val3);
			animateTentacleY(Tendril4,val3);
			animateTentacleY(Tendril5,val4);
			animateTentacleY(Tendril6,val4);
			animateTentacleY(Tendril7,val5);
			animateTentacleY(Tendril8,val5);
			animateTentacleY(Tendril9,-val1);
			animateTentacleY(Tendril10,-val1);
		}
		float val = 0.75f + (entity.getSpores() * 0.05f);
		tumor(Sack,val);
		tumor(Sack2,val);
		animateTumor(Tumour,val3);
		animateTumor(Tumours2,val2);
		animateTumor(Tumours3,val3);
		animateTumor(ArmTumour,val4);
		animateTumor(ArmTumours,val5);
		animateTentacleZ(BrokenJaw,val5);
	}
	public void tumor(ModelPart part,float val){
		part.xScale = val;
		part.yScale = val;
		part.zScale = val;
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		GorgonModel.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}