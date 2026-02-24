package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Organoids.Tentacle;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

public class SiegerLeg<T extends Tentacle> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "siegerleg"), "main");
	private final ModelPart RightLegJointY;
	private final ModelPart RightLeg;
	private final ModelPart RightForleg;
	private final ModelPart body17;
	private final ModelPart head12;
	private final ModelPart RightArm16;
	private final ModelPart RightForArm16;
	private final ModelPart LeftArm15;
	private final ModelPart LeftForArm15;
	private final ModelPart body14;
	private final ModelPart head11;
	private final ModelPart RightArm13;
	private final ModelPart RightForArm13;
	private final ModelPart LeftArm12;
	private final ModelPart LeftForArm12;
	private final ModelPart body15;
	private final ModelPart RightArm14;
	private final ModelPart RightForArm14;
	private final ModelPart LeftArm13;
	private final ModelPart LeftForArm13;
	private final ModelPart body16;
	private final ModelPart head13;
	private final ModelPart RightArm15;
	private final ModelPart RightForArm15;
	private final ModelPart LeftArm14;
	private final ModelPart LeftForArm14;
	private final ModelPart bloomingFungus5;
	private final ModelPart flower7;
	private final ModelPart flower9;
	private final ModelPart flower8;
	private final ModelPart body13;
	private final ModelPart head10;
	private final ModelPart RightArm12;
	private final ModelPart RightForArm12;
	private final ModelPart LeftArm11;
	private final ModelPart LeftForArm11;
	private final ModelPart body18;
	private final ModelPart head14;
	private final ModelPart RightArm17;
	private final ModelPart RightForArm17;
	private final ModelPart LeftArm16;
	private final ModelPart LeftForArm16;
	private final ModelPart head15;
	private final ModelPart body19;
	private final ModelPart head16;
	private final ModelPart RightArm18;
	private final ModelPart RightForArm18;
	private final ModelPart LeftArm17;
	private final ModelPart LeftForArm17;
	private final ModelPart bloomingFungus4;
	private final ModelPart[] LegJoints;
	private final float[] LegSize;
	private final InnerClassIkLeg leg;
	public SiegerLeg() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.RightLegJointY = root.getChild("RightLegJointY");
		this.RightLeg = this.RightLegJointY.getChild("RightLeg");
		this.RightForleg = this.RightLeg.getChild("RightForleg");
		this.body17 = this.RightForleg.getChild("body17");
		this.head12 = this.body17.getChild("head12");
		this.RightArm16 = this.body17.getChild("RightArm16");
		this.RightForArm16 = this.RightArm16.getChild("RightForArm16");
		this.LeftArm15 = this.body17.getChild("LeftArm15");
		this.LeftForArm15 = this.LeftArm15.getChild("LeftForArm15");
		this.body14 = this.RightForleg.getChild("body14");
		this.head11 = this.body14.getChild("head11");
		this.RightArm13 = this.body14.getChild("RightArm13");
		this.RightForArm13 = this.RightArm13.getChild("RightForArm13");
		this.LeftArm12 = this.body14.getChild("LeftArm12");
		this.LeftForArm12 = this.LeftArm12.getChild("LeftForArm12");
		this.body15 = this.RightForleg.getChild("body15");
		this.RightArm14 = this.body15.getChild("RightArm14");
		this.RightForArm14 = this.RightArm14.getChild("RightForArm14");
		this.LeftArm13 = this.body15.getChild("LeftArm13");
		this.LeftForArm13 = this.LeftArm13.getChild("LeftForArm13");
		this.body16 = this.RightForleg.getChild("body16");
		this.head13 = this.body16.getChild("head13");
		this.RightArm15 = this.body16.getChild("RightArm15");
		this.RightForArm15 = this.RightArm15.getChild("RightForArm15");
		this.LeftArm14 = this.body16.getChild("LeftArm14");
		this.LeftForArm14 = this.LeftArm14.getChild("LeftForArm14");
		this.bloomingFungus5 = this.RightForleg.getChild("bloomingFungus5");
		this.flower7 = this.RightForleg.getChild("flower7");
		this.flower9 = this.RightForleg.getChild("flower9");
		this.flower8 = this.RightForleg.getChild("flower8");
		this.body13 = this.RightLeg.getChild("body13");
		this.head10 = this.body13.getChild("head10");
		this.RightArm12 = this.body13.getChild("RightArm12");
		this.RightForArm12 = this.RightArm12.getChild("RightForArm12");
		this.LeftArm11 = this.body13.getChild("LeftArm11");
		this.LeftForArm11 = this.LeftArm11.getChild("LeftForArm11");
		this.body18 = this.RightLeg.getChild("body18");
		this.head14 = this.body18.getChild("head14");
		this.RightArm17 = this.body18.getChild("RightArm17");
		this.RightForArm17 = this.RightArm17.getChild("RightForArm17");
		this.LeftArm16 = this.body18.getChild("LeftArm16");
		this.LeftForArm16 = this.LeftArm16.getChild("LeftForArm16");
		this.head15 = this.body18.getChild("head15");
		this.body19 = this.RightLeg.getChild("body19");
		this.head16 = this.body19.getChild("head16");
		this.RightArm18 = this.body19.getChild("RightArm18");
		this.RightForArm18 = this.RightArm18.getChild("RightForArm18");
		this.LeftArm17 = this.body19.getChild("LeftArm17");
		this.LeftForArm17 = this.LeftArm17.getChild("LeftForArm17");
		this.bloomingFungus4 = this.RightLeg.getChild("bloomingFungus4");
		LegJoints = new ModelPart[]{RightLeg,RightForleg,};
		LegSize = new float[]{3f,4.75f};
		leg = new InnerClassIkLeg(3,LegJoints,LegSize,new Vec3(0,2,-1),new Vec3(0,0,-5),4,2,4);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightLegJointY = partdefinition.addOrReplaceChild("RightLegJointY", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -11.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition RightLeg = RightLegJointY.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(64, 349).addBox(-6.0F, -9.0F, -7.0F, 10.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = RightLeg.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(83, 347).addBox(-12.0F, -4.0F, -4.0F, 16.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, -27.0F, -0.5F, 0.0F, 0.0F, -0.829F));

		PartDefinition cube_r2 = RightLeg.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(81, 367).addBox(-11.0F, -5.0F, -6.0F, 15.0F, 13.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -16.0F, 0.5F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r3 = RightLeg.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(81, 364).addBox(-10.0F, -6.0F, -7.0F, 14.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -7.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition RightForleg = RightLeg.addOrReplaceChild("RightForleg", CubeListBuilder.create().texOffs(0, 237).addBox(6.3435F, 33.2684F, -2.5F, 12.0F, 20.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 351).addBox(4.3435F, 53.2684F, -4.5F, 16.0F, 18.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -29.0F, 0.0F));

		PartDefinition cube_r4 = RightForleg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(187, 243).addBox(1.0F, -4.0F, -4.5F, 9.0F, 29.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(6.3435F, 21.2684F, -14.0F, 0.8548F, -0.1274F, -0.158F));

		PartDefinition cube_r5 = RightForleg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(187, 243).addBox(1.0F, -7.0F, -4.5F, 9.0F, 32.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6565F, 4.2684F, -1.0F, -0.5672F, 0.0F, -0.4363F));

		PartDefinition body17 = RightForleg.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(8.0F, 15.0F, -19.0F, 1.0472F, 0.0F, -3.098F));

		PartDefinition cube_r6 = body17.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(196, 206).addBox(-43.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(40.0F, 5.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body17.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head12 = body17.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm16 = body17.addOrReplaceChild("RightArm16", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightForArm16 = RightArm16.addOrReplaceChild("RightForArm16", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition LeftArm15 = body17.addOrReplaceChild("LeftArm15", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2616F, 0.0113F, -0.0421F));

		PartDefinition LeftForArm15 = LeftArm15.addOrReplaceChild("LeftForArm15", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r8 = LeftForArm15.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body14 = RightForleg.addOrReplaceChild("body14", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(20.5F, 65.0F, -3.5F, 3.1063F, -0.8743F, -0.146F));

		PartDefinition cube_r9 = body14.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head11 = body14.addOrReplaceChild("head11", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm13 = body14.addOrReplaceChild("RightArm13", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.2875F, -0.2909F, 1.3581F));

		PartDefinition RightForArm13 = RightArm13.addOrReplaceChild("RightForArm13", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm12 = body14.addOrReplaceChild("LeftArm12", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition LeftForArm12 = LeftArm12.addOrReplaceChild("LeftForArm12", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r10 = LeftForArm12.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body15 = RightForleg.addOrReplaceChild("body15", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(3.0F, 67.0F, 3.0F, 2.1763F, -1.2636F, 1.2282F));

		PartDefinition cube_r11 = body15.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm14 = body15.addOrReplaceChild("RightArm14", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -2.4042F, 0.2975F, 0.2602F));

		PartDefinition RightForArm14 = RightArm14.addOrReplaceChild("RightForArm14", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition LeftArm13 = body15.addOrReplaceChild("LeftArm13", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, -2.1281F, -0.7261F, 0.6583F));

		PartDefinition LeftForArm13 = LeftArm13.addOrReplaceChild("LeftForArm13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r12 = LeftForArm13.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body16 = RightForleg.addOrReplaceChild("body16", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(17.0F, 61.0F, 9.0F, 0.5161F, 0.4924F, 0.0083F));

		PartDefinition cube_r13 = body16.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head13 = body16.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm15 = body16.addOrReplaceChild("RightArm15", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.3491F, 0.0F, 0.4363F));

		PartDefinition RightForArm15 = RightArm15.addOrReplaceChild("RightForArm15", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm14 = body16.addOrReplaceChild("LeftArm14", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.3244F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm14 = LeftArm14.addOrReplaceChild("LeftForArm14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r14 = LeftForArm14.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus5 = RightForleg.addOrReplaceChild("bloomingFungus5", CubeListBuilder.create(), PartPose.offsetAndRotation(17.75F, 35.0F, 3.0F, 0.0F, -0.3927F, 1.3526F));

		PartDefinition cube_r15 = bloomingFungus5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r16 = bloomingFungus5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r17 = bloomingFungus5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r18 = bloomingFungus5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bloomingFungus5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r20 = bloomingFungus5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower7 = RightForleg.addOrReplaceChild("flower7", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 43.5F, -3.25F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r21 = flower7.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower9 = RightForleg.addOrReplaceChild("flower9", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 42.5F, 10.75F, 0.0F, 2.7053F, 0.0F));

		PartDefinition cube_r22 = flower9.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower8 = RightForleg.addOrReplaceChild("flower8", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 36.5F, 3.75F, 0.0F, 1.5708F, 0.0F));

		PartDefinition cube_r23 = flower8.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition body13 = RightLeg.addOrReplaceChild("body13", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(19.0F, -19.0F, -5.0F, 0.3927F, -0.3927F, 0.0F));

		PartDefinition cube_r24 = body13.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head10 = body13.addOrReplaceChild("head10", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm12 = body13.addOrReplaceChild("RightArm12", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.0472F, 0.0F, 1.0908F));

		PartDefinition RightForArm12 = RightArm12.addOrReplaceChild("RightForArm12", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0791F, -0.0368F, -0.4349F));

		PartDefinition LeftArm11 = body13.addOrReplaceChild("LeftArm11", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition LeftForArm11 = LeftArm11.addOrReplaceChild("LeftForArm11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 1.3526F, 0.0F, 0.0F));

		PartDefinition cube_r25 = LeftForArm11.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition body18 = RightLeg.addOrReplaceChild("body18", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(28.0F, -33.0F, -1.0F, 2.3126F, 1.5272F, -3.1416F));

		PartDefinition cube_r26 = body18.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head14 = body18.addOrReplaceChild("head14", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm17 = body18.addOrReplaceChild("RightArm17", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition RightForArm17 = RightArm17.addOrReplaceChild("RightForArm17", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm16 = body18.addOrReplaceChild("LeftArm16", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition LeftForArm16 = LeftArm16.addOrReplaceChild("LeftForArm16", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r27 = LeftForArm16.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head15 = body18.addOrReplaceChild("head15", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 1.0F, 2.25F, -1.1389F, 0.3419F, -0.2766F));

		PartDefinition body19 = RightLeg.addOrReplaceChild("body19", CubeListBuilder.create().texOffs(196, 206).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(5.0F, -7.0F, -6.0F, 0.1745F, 0.0F, 0.8727F));

		PartDefinition cube_r28 = body19.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(236, 44).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head16 = body19.addOrReplaceChild("head16", CubeListBuilder.create().texOffs(287, 233).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(118, 225).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition RightArm18 = body19.addOrReplaceChild("RightArm18", CubeListBuilder.create().texOffs(306, 324).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 1.1345F, 0.0F, 0.829F));

		PartDefinition RightForArm18 = RightArm18.addOrReplaceChild("RightForArm18", CubeListBuilder.create().texOffs(323, 272).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition LeftArm17 = body19.addOrReplaceChild("LeftArm17", CubeListBuilder.create().texOffs(84, 287).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition LeftForArm17 = LeftArm17.addOrReplaceChild("LeftForArm17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r29 = LeftForArm17.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(132, 275).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition bloomingFungus4 = RightLeg.addOrReplaceChild("bloomingFungus4", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, -19.0F, 3.0F, -0.829F, 0.0F, -0.4363F));

		PartDefinition cube_r30 = bloomingFungus4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 169).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r31 = bloomingFungus4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(36, 223).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r32 = bloomingFungus4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(41, 173).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r33 = bloomingFungus4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(250, 217).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r34 = bloomingFungus4.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(253, 159).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r35 = bloomingFungus4.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(255, 119).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		leg.applyIK(entity);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightLegJointY.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}