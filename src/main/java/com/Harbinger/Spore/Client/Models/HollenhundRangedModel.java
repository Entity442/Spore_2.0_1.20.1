package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Hyper.Hollenhund;
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

public class HollenhundRangedModel<T extends Hollenhund> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hollenhundrangedmodel"), "main");
	private final ModelPart worm;
	private final ModelPart body;
	private final ModelPart tail;
	private final ModelPart spine4;
	private final ModelPart vestigialleg;
	private final ModelPart knee;
	private final ModelPart crown1;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart splittail;
	private final ModelPart splittail2;
	private final ModelPart spine5;
	private final ModelPart body2;
	private final ModelPart upperbody;
	private final ModelPart spine3;
	private final ModelPart head;
	private final ModelPart rightjaw;
	private final ModelPart leftjaw;
	private final ModelPart midjaw;
	private final ModelPart jaw;
	private final ModelPart rightsidejaw;
	private final ModelPart leftsidejaw;
	private final ModelPart tongue;
	private final ModelPart tongue2;
	private final ModelPart tongue3;
	private final ModelPart crown2;
	private final ModelPart rightarm;
	private final ModelPart rightelbow;
	private final ModelPart righthand;
	private final ModelPart rightfinger;
	private final ModelPart rightfinger2;
	private final ModelPart rightfinger3;
	private final ModelPart rightelbowclaw2;
	private final ModelPart leftarm;
	private final ModelPart leftelbow;
	private final ModelPart lefthand;
	private final ModelPart leftfinger3;
	private final ModelPart leftfinger;
	private final ModelPart leftfinger2;
	private final ModelPart armfoliage;
	private final ModelPart leftelbowclaw;
	private final ModelPart rightgrabarm;
	private final ModelPart rightgrabelbow;
	private final ModelPart rightgrabhand;
	private final ModelPart rightgrabber;
	private final ModelPart leftgrabarm;
	private final ModelPart leftgrabelbow;
	private final ModelPart leftgrabhand;
	private final ModelPart leftgrabber;
	private final ModelPart tumors;
	private final ModelPart spine2;
	private final ModelPart crown3;
	private final ModelPart foliage2;
	private final ModelPart spine;
	private final ModelPart foliage;

	public HollenhundRangedModel(ModelPart root) {
		this.worm = root.getChild("worm");
		this.body = this.worm.getChild("body");
		this.tail = this.body.getChild("tail");
		this.spine4 = this.tail.getChild("spine4");
		this.vestigialleg = this.tail.getChild("vestigialleg");
		this.knee = this.vestigialleg.getChild("knee");
		this.crown1 = this.tail.getChild("crown1");
		this.tail2 = this.tail.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.splittail = this.tail3.getChild("splittail");
		this.splittail2 = this.tail3.getChild("splittail2");
		this.spine5 = this.tail2.getChild("spine5");
		this.body2 = this.body.getChild("body2");
		this.upperbody = this.body2.getChild("upperbody");
		this.spine3 = this.upperbody.getChild("spine3");
		this.head = this.upperbody.getChild("head");
		this.rightjaw = this.head.getChild("rightjaw");
		this.leftjaw = this.head.getChild("leftjaw");
		this.midjaw = this.head.getChild("midjaw");
		this.jaw = this.head.getChild("jaw");
		this.rightsidejaw = this.head.getChild("rightsidejaw");
		this.leftsidejaw = this.head.getChild("leftsidejaw");
		this.tongue = this.head.getChild("tongue");
		this.tongue2 = this.tongue.getChild("tongue2");
		this.tongue3 = this.tongue2.getChild("tongue3");
		this.crown2 = this.head.getChild("crown2");
		this.rightarm = this.upperbody.getChild("rightarm");
		this.rightelbow = this.rightarm.getChild("rightelbow");
		this.righthand = this.rightelbow.getChild("righthand");
		this.rightfinger = this.righthand.getChild("rightfinger");
		this.rightfinger2 = this.righthand.getChild("rightfinger2");
		this.rightfinger3 = this.righthand.getChild("rightfinger3");
		this.rightelbowclaw2 = this.rightarm.getChild("rightelbowclaw2");
		this.leftarm = this.upperbody.getChild("leftarm");
		this.leftelbow = this.leftarm.getChild("leftelbow");
		this.lefthand = this.leftelbow.getChild("lefthand");
		this.leftfinger3 = this.lefthand.getChild("leftfinger3");
		this.leftfinger = this.lefthand.getChild("leftfinger");
		this.leftfinger2 = this.lefthand.getChild("leftfinger2");
		this.armfoliage = this.leftelbow.getChild("armfoliage");
		this.leftelbowclaw = this.leftarm.getChild("leftelbowclaw");
		this.rightgrabarm = this.upperbody.getChild("rightgrabarm");
		this.rightgrabelbow = this.rightgrabarm.getChild("rightgrabelbow");
		this.rightgrabhand = this.rightgrabelbow.getChild("rightgrabhand");
		this.rightgrabber = this.rightgrabhand.getChild("rightgrabber");
		this.leftgrabarm = this.upperbody.getChild("leftgrabarm");
		this.leftgrabelbow = this.leftgrabarm.getChild("leftgrabelbow");
		this.leftgrabhand = this.leftgrabelbow.getChild("leftgrabhand");
		this.leftgrabber = this.leftgrabhand.getChild("leftgrabber");
		this.tumors = this.upperbody.getChild("tumors");
		this.spine2 = this.body2.getChild("spine2");
		this.crown3 = this.body2.getChild("crown3");
		this.foliage2 = this.body2.getChild("foliage2");
		this.spine = this.body.getChild("spine");
		this.foliage = this.body.getChild("foliage");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition worm = partdefinition.addOrReplaceChild("worm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, -5.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition body = worm.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 34).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 8.0F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(36, 18).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition spine4 = tail.addOrReplaceChild("spine4", CubeListBuilder.create(), PartPose.offset(-0.5F, -3.0F, 0.0F));

		PartDefinition cube_r1 = spine4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 74).addBox(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition vestigialleg = tail.addOrReplaceChild("vestigialleg", CubeListBuilder.create().texOffs(32, 99).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, 7.0F, -0.3054F, 0.3927F, 0.0F));

		PartDefinition knee = vestigialleg.addOrReplaceChild("knee", CubeListBuilder.create().texOffs(100, 26).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition crown1 = tail.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offset(0.8899F, 0.1674F, 1.2539F));

		PartDefinition Petal4_r1 = crown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(71, 31).addBox(-3.75F, -4.0F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, 0.0399F, 0.5245F, 0.1745F, -0.4363F, 0.0F));

		PartDefinition Petal3_r1 = crown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4625F, 0.3603F, 0.6159F, 0.3031F, 0.5483F, -0.0492F));

		PartDefinition Petal2_r1 = crown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(71, 31).addBox(-3.0F, -4.0F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -3.9601F, 0.5245F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(71, 31).addBox(-4.25F, -2.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3191F, 2.7861F, -0.336F, 0.9596F, 0.0395F, 0.0184F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(7, 49).addBox(-3.0F, -2.0F, 0.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(47, 59).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition splittail = tail3.addOrReplaceChild("splittail", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -0.25F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.25F)), PartPose.offset(1.0F, 0.0F, 4.0F));

		PartDefinition splittail2 = tail3.addOrReplaceChild("splittail2", CubeListBuilder.create().texOffs(59, 51).addBox(-1.0F, -1.0F, -0.25F, 2.0F, 2.0F, 9.0F, new CubeDeformation(-0.25F)), PartPose.offset(-1.0F, 0.0F, 4.0F));

		PartDefinition spine5 = tail2.addOrReplaceChild("spine5", CubeListBuilder.create().texOffs(104, 107).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -2.0F, 0.0F, 0.0F, -0.0436F, 0.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -4.5F, -9.0F, 11.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition upperbody = body2.addOrReplaceChild("upperbody", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r2 = upperbody.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-5.0F, -0.5257F, -7.5255F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition spine3 = upperbody.addOrReplaceChild("spine3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -5.25F, -2.5F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r3 = spine3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(100, 107).addBox(-1.4587F, 2.9743F, -0.0274F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.025F))
		.texOffs(44, 85).addBox(-1.4587F, 2.9743F, -8.0274F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.025F))
		.texOffs(0, 40).addBox(0.0413F, -3.0257F, -7.5274F, 0.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 65).addBox(-1.4587F, 2.9743F, -7.5274F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r4 = spine3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 53).addBox(-0.6512F, 2.9456F, 0.1332F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8173F, 7.9848F, -0.6843F, -0.0527F, 0.2614F, -0.0085F));

		PartDefinition cube_r5 = spine3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(72, 103).addBox(-0.3908F, 2.9489F, 0.1237F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4393F, 0.0F, -0.3674F, -0.0398F, 0.0891F, 0.0438F));

		PartDefinition cube_r6 = spine3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(100, 103).addBox(-0.4413F, 3.006F, -0.4766F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-4.7939F, 7.7789F, -3.2329F, 0.1299F, 0.0422F, 0.0227F));

		PartDefinition cube_r7 = spine3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(96, 103).addBox(-0.4381F, 3.006F, -0.4871F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6576F, -0.1527F, -4.2682F, 0.1309F, -0.1309F, 0.0F));

		PartDefinition cube_r8 = spine3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(108, 89).addBox(-0.1365F, 2.9674F, -0.1247F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-5.0293F, 7.8194F, -6.8498F, -0.0085F, -0.4798F, 0.0469F));

		PartDefinition cube_r9 = spine3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(32, 104).addBox(-0.3291F, 2.9674F, -0.0062F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6856F, -0.173F, -6.7892F, -0.0076F, -0.0435F, 0.0433F));

		PartDefinition cube_r10 = spine3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(108, 87).addBox(-3.8291F, 2.9674F, -0.0062F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6931F, 0.0F, -6.6154F, -0.0076F, -0.0435F, 0.0433F));

		PartDefinition cube_r11 = spine3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(108, 61).addBox(-3.7661F, 2.9674F, -0.0328F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2141F, 0.0F, -3.661F, -0.0077F, -0.1744F, 0.0443F));

		PartDefinition cube_r12 = spine3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(58, 16).addBox(-3.0414F, 2.9743F, -0.0274F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4507F, 0.0F, -0.6288F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r13 = spine3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(108, 57).addBox(-3.5115F, 2.9536F, 0.3569F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9663F, 7.9924F, -2.4614F, -0.0356F, -0.174F, -0.0274F));

		PartDefinition cube_r14 = spine3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(76, 103).addBox(-0.6037F, 2.9743F, -0.0371F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0421F, 0.0F, -2.1211F, 0.0F, 0.2201F, 0.0F));

		PartDefinition cube_r15 = spine3.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(84, 103).addBox(-4.7372F, 2.9437F, 0.1168F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1932F, 7.9924F, -5.0603F, -0.0465F, 0.085F, -0.0569F));

		PartDefinition cube_r16 = spine3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(80, 103).addBox(-0.3973F, 2.9508F, 0.1143F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1177F, 0.0F, -4.7196F, -0.0436F, -0.2182F, 0.0F));

		PartDefinition cube_r17 = spine3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(108, 59).addBox(-0.3788F, 2.9743F, 0.0438F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(1.7F, 0.0F, -5.5598F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r18 = spine3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(108, 55).addBox(-0.1027F, 2.9743F, -0.0368F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.625F, 0.0F, -1.3636F, 0.0F, 0.2182F, 0.0F));

		PartDefinition head = upperbody.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 34).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(74, 0).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -8.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition rightjaw = head.addOrReplaceChild("rightjaw", CubeListBuilder.create().texOffs(98, 49).addBox(-2.0F, -6.0F, -0.25F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 1.0F, 0.2618F, 0.0F, -0.7854F));

		PartDefinition cube_r19 = rightjaw.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(18, 106).addBox(-2.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-2.0F, -3.0F, 0.25F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r20 = rightjaw.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(12, 106).addBox(0.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(2.0F, -3.0F, 0.25F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r21 = rightjaw.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(106, 8).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r22 = rightjaw.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(100, 105).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.3491F, 0.0F, 0.3054F));

		PartDefinition cube_r23 = rightjaw.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(106, 6).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.25F, 0.3054F, 0.0F, -0.1745F));

		PartDefinition cube_r24 = rightjaw.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(84, 105).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -0.25F, 0.3491F, 0.0F, 0.1745F));

		PartDefinition leftjaw = head.addOrReplaceChild("leftjaw", CubeListBuilder.create().texOffs(98, 56).addBox(-2.0F, -6.0F, -0.25F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, 1.0F, 0.2182F, 0.0F, 0.7854F));

		PartDefinition cube_r25 = leftjaw.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(36, 106).addBox(0.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(2.0F, -3.0F, 0.25F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r26 = leftjaw.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(106, 31).addBox(-2.0F, -3.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-2.0F, -3.0F, 0.25F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r27 = leftjaw.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(104, 17).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.25F, 0.3491F, 0.0F, 0.1745F));

		PartDefinition cube_r28 = leftjaw.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(104, 15).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.48F, 0.0F, 0.4363F));

		PartDefinition cube_r29 = leftjaw.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(36, 104).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.25F, 0.4363F, 0.0F, -0.6109F));

		PartDefinition cube_r30 = leftjaw.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(104, 13).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -0.25F, 0.5672F, 0.0F, -0.3491F));

		PartDefinition cube_r31 = leftjaw.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(106, 19).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition midjaw = head.addOrReplaceChild("midjaw", CubeListBuilder.create().texOffs(20, 69).addBox(-1.5F, -5.0F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r32 = midjaw.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(108, 107).addBox(0.0F, -2.5F, -2.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8536F, -2.5F, -1.0607F, -0.2292F, 0.3602F, -0.3014F));

		PartDefinition cube_r33 = midjaw.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(24, 107).addBox(0.0F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(1.5F, -3.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r34 = midjaw.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(42, 106).addBox(-2.0F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-1.5F, -3.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r35 = midjaw.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(110, 0).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 2.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r36 = midjaw.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(108, 99).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.5F, -0.5F, 0.3054F, 0.0F, 0.5236F));

		PartDefinition cube_r37 = midjaw.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(108, 97).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, -0.5F, 0.3491F, 0.0F, -0.2618F));

		PartDefinition cube_r38 = midjaw.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(108, 95).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.5F, 0.5672F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 83).addBox(-3.5F, -5.0F, -0.5F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r39 = jaw.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(90, 107).addBox(-2.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-3.5F, -2.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r40 = jaw.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(52, 68).addBox(0.0F, -2.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -2.5F, 1.4142F, 0.2132F, -0.762F, -0.3038F));

		PartDefinition cube_r41 = jaw.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(84, 107).addBox(0.0F, -2.5F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(3.5F, -2.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r42 = jaw.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(74, 13).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r43 = jaw.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(94, 4).addBox(-3.5F, 1.0F, -0.5F, 7.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, -0.3054F, 0.0F, 0.1309F));

		PartDefinition cube_r44 = jaw.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(68, 46).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r45 = jaw.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(88, 79).addBox(-3.5F, -1.0F, -0.5F, 7.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r46 = jaw.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(40, 16).addBox(-3.5F, 0.0F, 0.0F, 7.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.5F, -0.2618F, 0.0F, 0.3491F));

		PartDefinition rightsidejaw = head.addOrReplaceChild("rightsidejaw", CubeListBuilder.create().texOffs(66, 24).addBox(-2.0F, -0.5F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, 0.0806F, 1.0396F, 0.5008F));

		PartDefinition cube_r47 = rightsidejaw.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(100, 81).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r48 = rightsidejaw.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(86, 95).addBox(0.0F, -1.5F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.4142F, -3.0F, 0.0F, 0.2182F, 0.7854F));

		PartDefinition cube_r49 = rightsidejaw.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(78, 65).addBox(-2.0F, -0.5F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r50 = rightsidejaw.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(76, 6).addBox(0.0F, -0.5F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(2.0F, 0.0F, -3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r51 = rightsidejaw.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(110, 101).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -4.0F, -0.5236F, 0.2182F, 0.0F));

		PartDefinition cube_r52 = rightsidejaw.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(110, 69).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -5.0F, -0.48F, -0.7418F, 0.0F));

		PartDefinition cube_r53 = rightsidejaw.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(110, 67).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition leftsidejaw = head.addOrReplaceChild("leftsidejaw", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, -0.5F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, 0.0806F, -1.0396F, -0.5008F));

		PartDefinition cube_r54 = leftsidejaw.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(100, 84).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r55 = leftsidejaw.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(52, 82).addBox(0.0F, -0.5F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(2.0F, 0.0F, -3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r56 = leftsidejaw.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(74, 95).addBox(0.0F, -2.0F, -3.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3536F, -1.0607F, -3.0F, 0.0F, 0.1745F, 0.7854F));

		PartDefinition cube_r57 = leftsidejaw.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(70, 81).addBox(-2.0F, -0.5F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r58 = leftsidejaw.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(110, 63).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition cube_r59 = leftsidejaw.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(110, 28).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4329F, -1.0F, -4.9526F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r60 = leftsidejaw.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(110, 65).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.75F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r61 = leftsidejaw.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(110, 26).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition tongue = head.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(18, 76).addBox(-2.0F, -7.0F, -0.5F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition tongue2 = tongue.addOrReplaceChild("tongue2", CubeListBuilder.create().texOffs(24, 99).addBox(-1.5F, -7.0F, -0.5F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tongue3 = tongue2.addOrReplaceChild("tongue3", CubeListBuilder.create().texOffs(106, 38).addBox(-1.0F, -6.0F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition crown2 = head.addOrReplaceChild("crown2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8899F, 5.1674F, -2.7461F, -1.7453F, -0.3927F, 0.0F));

		PartDefinition Petal4_r2 = crown2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(71, 31).addBox(-3.75F, -4.0F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, 0.0399F, 0.5245F, 0.1745F, -0.4363F, 0.0F));

		PartDefinition Petal3_r2 = crown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4625F, 0.3603F, 0.6159F, 0.3031F, 0.5483F, -0.0492F));

		PartDefinition Petal2_r2 = crown2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(71, 31).addBox(-3.0F, -4.0F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -3.9601F, 0.5245F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = crown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(71, 31).addBox(-4.25F, -2.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3191F, 2.7861F, -0.336F, 0.9596F, 0.0395F, 0.0184F));

		PartDefinition rightarm = upperbody.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(40, 0).addBox(-14.0F, -1.5F, -1.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -5.0F, 0.6645F, -0.0351F, 0.3751F));

		PartDefinition rightelbow = rightarm.addOrReplaceChild("rightelbow", CubeListBuilder.create().texOffs(40, 6).addBox(-16.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0071F));

		PartDefinition righthand = rightelbow.addOrReplaceChild("righthand", CubeListBuilder.create(), PartPose.offset(-16.0F, 0.0F, 0.0F));

		PartDefinition rightfinger = righthand.addOrReplaceChild("rightfinger", CubeListBuilder.create().texOffs(90, 20).addBox(-7.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightfinger2 = righthand.addOrReplaceChild("rightfinger2", CubeListBuilder.create().texOffs(92, 45).addBox(-7.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0944F, 0.0F, 0.0F));

		PartDefinition rightfinger3 = righthand.addOrReplaceChild("rightfinger3", CubeListBuilder.create().texOffs(94, 0).addBox(-7.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition rightelbowclaw2 = rightarm.addOrReplaceChild("rightelbowclaw2", CubeListBuilder.create().texOffs(14, 99).addBox(-4.0F, -7.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition leftarm = upperbody.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(40, 10).addBox(0.0F, -1.5F, -1.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, -5.0F, 0.7846F, 0.0592F, -0.475F));

		PartDefinition leftelbow = leftarm.addOrReplaceChild("leftelbow", CubeListBuilder.create().texOffs(32, 47).addBox(0.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0071F));

		PartDefinition lefthand = leftelbow.addOrReplaceChild("lefthand", CubeListBuilder.create(), PartPose.offset(16.0F, 0.0F, 0.0F));

		PartDefinition leftfinger3 = lefthand.addOrReplaceChild("leftfinger3", CubeListBuilder.create().texOffs(94, 63).addBox(-1.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.0944F, 0.0F, 0.0F));

		PartDefinition leftfinger = lefthand.addOrReplaceChild("leftfinger", CubeListBuilder.create().texOffs(94, 67).addBox(-1.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftfinger2 = lefthand.addOrReplaceChild("leftfinger2", CubeListBuilder.create().texOffs(58, 95).addBox(-1.0F, -4.0F, 0.0F, 8.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.0944F, 0.0F, 0.0F));

		PartDefinition armfoliage = leftelbow.addOrReplaceChild("armfoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(11.9407F, -1.8392F, 1.6525F, 0.0F, 0.0F, 1.5708F));

		PartDefinition Fungus_r1 = armfoliage.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(64, 31).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = armfoliage.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(64, 31).addBox(-3.5F, 6.0F, -8.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = armfoliage.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(64, 31).addBox(-1.5F, -1.0F, -6.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = armfoliage.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(64, 31).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition leftelbowclaw = leftarm.addOrReplaceChild("leftelbowclaw", CubeListBuilder.create().texOffs(98, 94).addBox(-1.0F, -7.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition rightgrabarm = upperbody.addOrReplaceChild("rightgrabarm", CubeListBuilder.create().texOffs(66, 16).addBox(-10.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 4.0F, -2.0F, 1.1272F, -0.1585F, -0.5063F));

		PartDefinition rightgrabelbow = rightgrabarm.addOrReplaceChild("rightgrabelbow", CubeListBuilder.create().texOffs(64, 38).addBox(-12.0F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 0.0F, 0.0F, -0.9599F, 0.0F));

		PartDefinition rightgrabhand = rightgrabelbow.addOrReplaceChild("rightgrabhand", CubeListBuilder.create().texOffs(36, 31).addBox(-13.0F, -1.0F, -0.5F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.1345F));

		PartDefinition rightgrabber = rightgrabhand.addOrReplaceChild("rightgrabber", CubeListBuilder.create().texOffs(28, 68).addBox(-4.0F, 0.0F, 0.0F, 6.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition leftgrabarm = upperbody.addOrReplaceChild("leftgrabarm", CubeListBuilder.create().texOffs(66, 20).addBox(0.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -2.0F, 1.368F, 0.0605F, 0.5035F));

		PartDefinition leftgrabelbow = leftgrabarm.addOrReplaceChild("leftgrabelbow", CubeListBuilder.create().texOffs(64, 42).addBox(0.0F, -1.0F, -1.0F, 12.0F, 2.0F, 2.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(10.0F, 0.0F, 0.0F, 0.0F, 0.9599F, 0.0F));

		PartDefinition leftgrabhand = leftgrabelbow.addOrReplaceChild("leftgrabhand", CubeListBuilder.create().texOffs(28, 65).addBox(0.0F, -1.0F, -0.5F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1345F));

		PartDefinition leftgrabber = leftgrabhand.addOrReplaceChild("leftgrabber", CubeListBuilder.create().texOffs(40, 68).addBox(-2.0F, 0.0F, 0.0F, 6.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition tumors = upperbody.addOrReplaceChild("tumors", CubeListBuilder.create(), PartPose.offset(-5.0F, -3.25F, -1.0F));

		PartDefinition cube_r62 = tumors.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(96, 88).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.5F, 0.0F, 0.4363F, -0.4363F, -0.3054F));

		PartDefinition cube_r63 = tumors.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(42, 96).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -0.5F, 1.0F, 0.9163F, 0.5236F, 0.3491F));

		PartDefinition cube_r64 = tumors.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(108, 91).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.5672F, -0.6981F, -0.3927F));

		PartDefinition spine2 = body2.addOrReplaceChild("spine2", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -4.0F));

		PartDefinition cube_r65 = spine2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(58, 89).addBox(-1.5F, -1.0F, -5.5F, 3.0F, 4.0F, 2.0F, new CubeDeformation(-0.05F))
		.texOffs(0, 45).addBox(0.0F, -7.0F, -5.0F, 0.0F, 6.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 76).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

		PartDefinition cube_r66 = spine2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(68, 49).addBox(-5.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4948F, 8.5F, 2.8466F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r67 = spine2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(68, 99).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(5.4948F, -0.5F, 2.8466F, 0.0F, -0.0436F, 0.0F));

		PartDefinition cube_r68 = spine2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(108, 51).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7656F, 8.423F, -0.7223F, -0.031F, 0.1392F, 0.0478F));

		PartDefinition cube_r69 = spine2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(4, 101).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5616F, -0.5F, 0.4346F, -0.1289F, -0.0015F, -0.0227F));

		PartDefinition cube_r70 = spine2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(54, 99).addBox(-5.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2774F, 8.4919F, -2.5517F, 0.0433F, -0.0001F, 0.0057F));

		PartDefinition cube_r71 = spine2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(8, 101).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3258F, 0.0F, -2.9193F, 0.0436F, -0.1309F, 0.0F));

		PartDefinition cube_r72 = spine2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(102, 77).addBox(-0.25F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3321F, -0.5F, -4.3729F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r73 = spine2.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(102, 75).addBox(0.0F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.13F, -0.5F, -0.3468F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r74 = spine2.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(106, 79).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9982F, -0.5F, 2.694F, 0.0F, -0.0436F, 0.0F));

		PartDefinition cube_r75 = spine2.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(108, 49).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-5.607F, 8.3633F, 1.3574F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r76 = spine2.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(0, 101).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(-5.5388F, -0.5F, 2.9188F, -0.1745F, 0.0436F, 0.0F));

		PartDefinition cube_r77 = spine2.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(100, 24).addBox(-0.5F, -0.5F, -0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4257F, 8.6522F, -1.8608F, 0.0236F, -0.1264F, -0.0281F));

		PartDefinition cube_r78 = spine2.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(54, 101).addBox(-0.6573F, -0.5376F, 0.0915F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9189F, -0.3F, -2.4097F, 0.0074F, -0.3889F, 0.0125F));

		PartDefinition cube_r79 = spine2.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(98, 101).addBox(-4.7042F, -0.3568F, -0.5878F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4665F, -0.5264F, -0.1957F, -0.1053F, -0.3995F, -0.0342F));

		PartDefinition cube_r80 = spine2.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(102, 73).addBox(-5.0F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0431F, -0.5F, 2.7225F, -0.1309F, 0.0436F, 0.0F));

		PartDefinition cube_r81 = spine2.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(0, 96).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition crown3 = body2.addOrReplaceChild("crown3", CubeListBuilder.create(), PartPose.offsetAndRotation(4.8899F, -4.8326F, -7.7461F, 2.0003F, -0.3093F, 0.5865F));

		PartDefinition Petal4_r3 = crown3.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(71, 31).addBox(-3.75F, -4.0F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, 0.0399F, 0.5245F, 0.1745F, -0.4363F, 0.0F));

		PartDefinition Petal3_r3 = crown3.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4624F, 0.3603F, 0.6159F, 0.3031F, 0.5483F, -0.0492F));

		PartDefinition Petal2_r3 = crown3.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(71, 31).addBox(-3.0F, -4.0F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -3.9601F, 0.5245F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = crown3.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(71, 31).addBox(-4.25F, -2.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3192F, 2.7861F, -0.336F, 0.9596F, 0.0395F, 0.0184F));

		PartDefinition foliage2 = body2.addOrReplaceChild("foliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0593F, -4.8392F, -3.6525F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Fungus_r5 = foliage2.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(64, 31).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4084F, -1.1675F, 2.8042F, 0.0288F, -0.519F, -0.1485F));

		PartDefinition Fungus_r6 = foliage2.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(64, 31).addBox(-5.0F, 1.0F, 1.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 2.7892F, -2.8975F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r7 = foliage2.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(64, 31).addBox(0.75F, -4.0F, -1.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, -2.8975F, -0.0333F, -0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = foliage2.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(64, 31).addBox(-3.5F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, 3.1025F, -0.1783F, 0.2977F, -0.0909F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -2.0F));

		PartDefinition cube_r82 = spine.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(108, 45).addBox(-1.5F, -0.5F, 1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.025F))
		.texOffs(0, 58).addBox(0.0F, -4.5F, -4.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(70, 74).addBox(-1.5F, -0.5F, -4.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r83 = spine.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(106, 22).addBox(-3.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8318F, 7.9924F, -0.1664F, -0.0057F, 0.0001F, 0.0433F));

		PartDefinition cube_r84 = spine.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(58, 101).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(-0.025F)), PartPose.offsetAndRotation(5.1778F, 0.0F, -0.1209F, -0.0057F, -0.1308F, 0.044F));

		PartDefinition cube_r85 = spine.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(84, 63).addBox(-0.5F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.957F, 7.9261F, -0.1817F, 0.0767F, -0.1719F, 0.0304F));

		PartDefinition cube_r86 = spine.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(48, 104).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6316F, 0.4546F, -0.7479F, 0.0871F, -0.5198F, 0.0002F));

		PartDefinition cube_r87 = spine.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(102, 71).addBox(-0.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0847F, 8.2454F, -2.4193F, -0.0276F, 0.1274F, -0.0769F));

		PartDefinition cube_r88 = spine.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(62, 101).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.979F, 0.2471F, -2.2899F, -0.0162F, -0.0452F, 0.0139F));

		PartDefinition cube_r89 = spine.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(42, 102).addBox(-4.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.985F, 0.1283F, -2.1067F, 0.0731F, -0.0458F, -0.0297F));

		PartDefinition cube_r90 = spine.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(78, 72).addBox(-3.9829F, -0.5F, -0.2389F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5106F, 0.0F, 0.7526F, 0.0752F, -0.5187F, -0.1509F));

		PartDefinition cube_r91 = spine.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(106, 11).addBox(0.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7077F, 0.0F, -0.5777F, 0.0F, -0.1309F, 0.0F));

		PartDefinition foliage = body.addOrReplaceChild("foliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r92 = foliage.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, -3.0F, -0.1309F, -0.2618F, 0.4363F));

		PartDefinition cube_r93 = foliage.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.0F, -2.0F, 0.2618F, -0.1309F, 0.3491F));

		PartDefinition cube_r94 = foliage.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, -3.0F, -0.3054F, -0.1745F, -0.4363F));

		PartDefinition cube_r95 = foliage.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, -3.0F, 0.3054F, 0.0F, 0.2618F));

		PartDefinition cube_r96 = foliage.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(71, 31).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, -1.0F, -0.2182F, -0.3927F, -0.7418F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float r1 = Mth.sin(ageInTicks/6)/8;
		float r2 = Mth.cos(ageInTicks/7)/6;
		float r3 = Mth.sin(ageInTicks/8)/5;
		float r4 = Mth.cos(ageInTicks/8)/6;
		float r5 = Mth.sin(ageInTicks/7)/7;
		animateTentacleZ(rightarm,r4);
		animateTentacleZ(leftarm,r5);
		animateTentacleX(tongue,r1);
		animateTentacleX(tongue2,r1);
		animateTentacleX(tongue3,r1);
		animateTentacleX(jaw,r2);
		animateTentacleX(rightsidejaw,-r2);
		animateTentacleX(leftsidejaw,r2);
		animateTentacleX(leftjaw,-r2);
		animateTentacleX(rightjaw,-r2);
		animateTentacleX(midjaw,-r2);
		animateTentacleZ(leftgrabelbow,r1);
		animateTentacleZ(rightgrabelbow,r3);
		animateTentacleZ(leftgrabhand,-r1);
		animateTentacleZ(rightgrabhand,-r2);
		animateTentacleZ(leftgrabber,r3);
		animateTentacleZ(rightgrabber,r2);
		animateTumor(tumors,r3);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r,float g,float b,float alpha) {
		worm.render(poseStack, vertexConsumer, packedLight, packedOverlay, r,g,b, alpha);
	}
}