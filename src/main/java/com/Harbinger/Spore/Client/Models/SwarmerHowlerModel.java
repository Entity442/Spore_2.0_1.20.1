package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Howler;
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

public class SwarmerHowlerModel<T extends Howler> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "swarmerhowlermodel"), "main");
	private final ModelPart Howler;
	private final ModelPart Head;
	private final ModelPart topRightFangs;
	private final ModelPart topLegFangs;
	private final ModelPart flower3;
	private final ModelPart flower2;
	private final ModelPart flower;
	private final ModelPart flower4;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart Stub;
	private final ModelPart Nerves;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart Stub2;
	private final ModelPart Nerves2;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart body;
	private final ModelPart spine;
	private final ModelPart spine2;
	private final ModelPart bottomRightFangs;
	private final ModelPart bottomLeftFangs;
	private final ModelPart Bairn;
	private final ModelPart Torso;
	private final ModelPart ActualTorso;
	private final ModelPart Head2;
	private final ModelPart Arms;
	private final ModelPart LeftArm2;
	private final ModelPart LeftArmLower;
	private final ModelPart RightArm2;
	private final ModelPart RightArmLower;
	private final ModelPart Legs;
	private final ModelPart LeftLeg2;
	private final ModelPart LeftLegLower;
	private final ModelPart RightLeg2;

	public SwarmerHowlerModel(ModelPart root) {
		this.Howler = root.getChild("Howler");
		this.Head = this.Howler.getChild("Head");
		this.topRightFangs = this.Head.getChild("topRightFangs");
		this.topLegFangs = this.Head.getChild("topLegFangs");
		this.flower3 = this.Head.getChild("flower3");
		this.flower2 = this.Head.getChild("flower2");
		this.flower = this.Head.getChild("flower");
		this.flower4 = this.Head.getChild("flower4");
		this.RightArm = this.Howler.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.Stub = this.RightArm.getChild("Stub");
		this.Nerves = this.Stub.getChild("Nerves");
		this.LeftArm = this.Howler.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.Stub2 = this.LeftArm.getChild("Stub2");
		this.Nerves2 = this.Stub2.getChild("Nerves2");
		this.RightLeg = this.Howler.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = this.Howler.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.body = this.Howler.getChild("body");
		this.spine = this.body.getChild("spine");
		this.spine2 = this.body.getChild("spine2");
		this.bottomRightFangs = this.body.getChild("bottomRightFangs");
		this.bottomLeftFangs = this.body.getChild("bottomLeftFangs");
		this.Bairn = this.Howler.getChild("Bairn");
		this.Torso = this.Bairn.getChild("Torso");
		this.ActualTorso = this.Torso.getChild("ActualTorso");
		this.Head2 = this.Torso.getChild("Head2");
		this.Arms = this.Torso.getChild("Arms");
		this.LeftArm2 = this.Arms.getChild("LeftArm2");
		this.LeftArmLower = this.LeftArm2.getChild("LeftArmLower");
		this.RightArm2 = this.Arms.getChild("RightArm2");
		this.RightArmLower = this.RightArm2.getChild("RightArmLower");
		this.Legs = this.Bairn.getChild("Legs");
		this.LeftLeg2 = this.Legs.getChild("LeftLeg2");
		this.LeftLegLower = this.LeftLeg2.getChild("LeftLegLower");
		this.RightLeg2 = this.Legs.getChild("RightLeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Howler = partdefinition.addOrReplaceChild("Howler", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = Howler.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 66).addBox(-4.0F, -3.0F, -1.5F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -4.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(33, 9).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.2F, 19.1F, 4.0F, -0.2199F, -0.0971F, 0.3518F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 17).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 22.1F, -0.7F, -0.2482F, 0.2749F, 0.1014F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(33, 0).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.9F, 3.2F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(29, 26).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 22.1F, 5.1F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -0.1F, 4.2F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -0.2F, 3.2F, -0.1384F, -0.3891F, 0.0286F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(62, 29).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.0F, 1.7F, -0.0978F, 0.2935F, -0.0363F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(62, 18).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 0.1F, -0.9F, 0.1571F, -0.6632F, 0.0F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(21, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.8F, 0.9F, 0.0731F, -0.3595F, -0.2053F));

		PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(66, 11).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -1.9F, -0.2618F, 0.0F, 0.0F));

		PartDefinition topRightFangs = Head.addOrReplaceChild("topRightFangs", CubeListBuilder.create(), PartPose.offset(-2.35F, -2.05F, -3.7F));

		PartDefinition cube_r11 = topRightFangs.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9541F, 2.55F, -0.577F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r12 = topRightFangs.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.054F, -0.5F, -0.477F, 0.0F, -0.2094F, -0.0698F));

		PartDefinition cube_r13 = topRightFangs.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.804F, 1.0F, -0.477F, 0.0F, 0.0524F, -0.0698F));

		PartDefinition topLegFangs = Head.addOrReplaceChild("topLegFangs", CubeListBuilder.create(), PartPose.offset(1.0F, -0.6F, -6.0F));

		PartDefinition cube_r14 = topLegFangs.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 1.6F, -0.8F, 0.1047F, -0.4014F, 0.0F));

		PartDefinition cube_r15 = topLegFangs.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(20, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0215F, -0.1732F, -0.124F));

		PartDefinition flower3 = Head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -10.25F, 3.5F, -0.9784F, -0.1588F, 0.667F));

		PartDefinition cube_r16 = flower3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flower3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r18 = flower3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r19 = flower3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower2 = Head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.25F, -8.05F, -2.7F, 0.8814F, 0.8237F, -0.533F));

		PartDefinition cube_r20 = flower2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flower2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r22 = flower2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r23 = flower2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower = Head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -11.25F, -2.7F, 0.6981F, 0.0F, 0.4363F));

		PartDefinition cube_r24 = flower.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = flower.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r26 = flower.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r27 = flower.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower4 = Head.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.85F, -11.25F, 0.2F, -0.1042F, 0.8419F, -0.4418F));

		PartDefinition cube_r28 = flower4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r29 = flower4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r30 = flower4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r31 = flower4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightArm = Howler.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-6.0F, -22.0F, -1.0F));

		PartDefinition cube_r32 = RightArm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.4F, 2.25F, -0.1017F, -0.5608F, -0.3127F));

		PartDefinition cube_r33 = RightArm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.9F, 1.0F, -0.1155F, 0.5691F, -0.2743F));

		PartDefinition cube_r34 = RightArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.4F, 2.0F, -0.2147F, 0.3179F, 0.1026F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition Stub = RightArm.addOrReplaceChild("Stub", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6612F, -1.0394F, -0.7128F, 0.0F, 0.0F, 0.1047F));

		PartDefinition cube_r35 = Stub.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(33, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.7836F, 0.0205F, 2.5128F, 1.4294F, 0.0393F, 0.0679F));

		PartDefinition Nerves = Stub.addOrReplaceChild("Nerves", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.2164F, 5.7205F, 0.1128F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Nerves_r1 = Nerves.addOrReplaceChild("Nerves_r1", CubeListBuilder.create().texOffs(14, 151).addBox(0.0F, -5.0F, -2.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.0F, 0.0F, 0.0F, -1.0123F, 0.0873F));

		PartDefinition Nerves_r2 = Nerves.addOrReplaceChild("Nerves_r2", CubeListBuilder.create().texOffs(14, 151).addBox(0.0F, -5.0F, -2.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.2967F, 0.0873F));

		PartDefinition LeftArm = Howler.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(42, 93).addBox(-1.0F, -2.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(6.0F, -22.0F, -1.0F));

		PartDefinition cube_r36 = LeftArm.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(29, 35).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.4F, 1.0F, -0.1017F, -0.299F, -0.1818F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition Stub2 = LeftArm.addOrReplaceChild("Stub2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7499F, -0.4685F, -0.2273F, 0.0F, 0.0F, -0.1047F));

		PartDefinition cube_r37 = Stub2.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(33, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.7334F, -0.1856F, 2.3273F, 1.5615F, 0.0382F, -0.1242F));

		PartDefinition Nerves2 = Stub2.addOrReplaceChild("Nerves2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0334F, 6.6144F, 0.1273F, 0.0F, 0.0F, -0.0349F));

		PartDefinition Nerves_r3 = Nerves2.addOrReplaceChild("Nerves_r3", CubeListBuilder.create().texOffs(14, 151).addBox(0.0F, -5.0F, -2.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 0.0F, 0.0F, 3.0194F, -0.733F, -3.0543F));

		PartDefinition Nerves_r4 = Nerves2.addOrReplaceChild("Nerves_r4", CubeListBuilder.create().texOffs(14, 151).addBox(0.0F, -5.0F, -2.5F, 0.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.0F, 0.0F, -0.0175F, -1.3788F, 0.0873F));

		PartDefinition RightLeg = Howler.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 66).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.9F, -16.0F, 2.5F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftLeg = Howler.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(75, 40).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 90).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(1.9F, -16.0F, 2.5F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(15, 77).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition body = Howler.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 18).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(0, 102).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, -25.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, 3.8F, -1.9F, -0.1953F, -0.2F, 0.1065F));

		PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(42, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 2.9F, -2.6F, 0.0467F, 0.2201F, 0.0342F));

		PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 2.1F, -5.5F, 0.0006F, 0.1336F, 1.7555F));

		PartDefinition cube_r41 = body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(33, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.0F, 0.2F, 0.9137F, 0.1587F, -0.1446F));

		PartDefinition cube_r42 = body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 8.9F, 2.2F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r43 = body.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 44).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7F, 33.5F, -3.6F, -0.4967F, -0.3692F, 0.4163F));

		PartDefinition cube_r44 = body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(29, 35).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.5F, 32.4F, 4.0F, -0.2199F, -0.0971F, 0.3518F));

		PartDefinition cube_r45 = body.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 109).addBox(-6.0F, -5.5F, -5.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, -4.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r46 = spine.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(83, 11).addBox(-2.0F, -4.0F, -2.25F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r47 = spine.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(60, 79).addBox(0.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -5.5F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r48 = spine2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(44, 66).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r49 = spine2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(25, 66).addBox(0.0F, -4.0F, -1.75F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition bottomRightFangs = body.addOrReplaceChild("bottomRightFangs", CubeListBuilder.create(), PartPose.offset(-1.2F, 0.6F, -6.25F));

		PartDefinition cube_r50 = bottomRightFangs.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 2.75F, -1.05F, 0.0F, 0.1222F, 0.0F));

		PartDefinition cube_r51 = bottomRightFangs.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(5, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, -0.75F, 0.0F, 0.0873F, -0.2094F));

		PartDefinition bottomLeftFangs = body.addOrReplaceChild("bottomLeftFangs", CubeListBuilder.create(), PartPose.offset(2.0F, 1.1F, -5.95F));

		PartDefinition cube_r52 = bottomLeftFangs.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.0F, 0.0F, -0.1222F, 0.3142F));

		PartDefinition cube_r53 = bottomLeftFangs.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(12, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 2.8F, -0.85F, 0.0875F, -0.0695F, -0.0061F));

		PartDefinition Bairn = Howler.addOrReplaceChild("Bairn", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -34.65F, 10.05F, 0.0F, 0.0873F, 0.3491F));

		PartDefinition Torso = Bairn.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(3.0F, 18.65F, -3.85F));

		PartDefinition ActualTorso = Torso.addOrReplaceChild("ActualTorso", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -3.2F));

		PartDefinition BackTendril2_r1 = ActualTorso.addOrReplaceChild("BackTendril2_r1", CubeListBuilder.create().texOffs(146, 134).addBox(1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -8.4F, 2.7F, -0.7854F, 0.0F, 0.0F));

		PartDefinition BackTendril1_r1 = ActualTorso.addOrReplaceChild("BackTendril1_r1", CubeListBuilder.create().texOffs(122, 145).addBox(1.0F, -4.0F, -3.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -8.4F, 2.7F, -1.0996F, 0.0F, 0.0F));

		PartDefinition TorsoClothes_r1 = ActualTorso.addOrReplaceChild("TorsoClothes_r1", CubeListBuilder.create().texOffs(110, 162).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(110, 121).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.9F, 0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Head2 = Torso.addOrReplaceChild("Head2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1F, -20.6F, -6.2F, 0.1453F, -0.0599F, 0.3883F));

		PartDefinition BackJaw_r1 = Head2.addOrReplaceChild("BackJaw_r1", CubeListBuilder.create().texOffs(146, 110).addBox(-2.0F, -0.3F, 1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.5F, -0.2F, 0.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition BottomJaw_r1 = Head2.addOrReplaceChild("BottomJaw_r1", CubeListBuilder.create().texOffs(130, 121).addBox(-3.0F, -0.5703F, -4.705F, 6.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.9F, 1.4F, -0.0175F, 0.0F, 0.0F));

		PartDefinition HeadMain_r1 = Head2.addOrReplaceChild("HeadMain_r1", CubeListBuilder.create().texOffs(110, 102).addBox(-3.0F, 0.7F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(110, 110).addBox(-3.0F, -4.3F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -3.2F));

		PartDefinition LeftArm2 = Arms.addOrReplaceChild("LeftArm2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3F, -11.05F, -1.1F, -0.296F, -0.0204F, -0.0668F));

		PartDefinition LeftArmTop_r1 = LeftArm2.addOrReplaceChild("LeftArmTop_r1", CubeListBuilder.create().texOffs(130, 127).addBox(-0.1F, -1.2564F, -1.5987F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3F, 0.75F, 0.1F, -0.1745F, 0.0F, 0.0F));

		PartDefinition LeftArmLower = LeftArm2.addOrReplaceChild("LeftArmLower", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, 4.8855F, -0.8389F, 0.1736F, 0.0182F, -0.1031F));

		PartDefinition LeftClaw3_r1 = LeftArmLower.addOrReplaceChild("LeftClaw3_r1", CubeListBuilder.create().texOffs(116, 150).addBox(0.0F, -0.5754F, -2.9277F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 4.2645F, -0.8611F, 0.384F, 0.0F, 0.0F));

		PartDefinition LeftClaw2_r1 = LeftArmLower.addOrReplaceChild("LeftClaw2_r1", CubeListBuilder.create().texOffs(130, 151).addBox(0.0F, -0.5243F, -2.947F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 4.2118F, -0.8463F, 0.5934F, 0.0F, 0.0F));

		PartDefinition LeftClaw1_r1 = LeftArmLower.addOrReplaceChild("LeftClaw1_r1", CubeListBuilder.create().texOffs(110, 150).addBox(0.0F, -0.5243F, -2.947F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 4.2118F, -0.8463F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LeftArmBottom_r1 = LeftArmLower.addOrReplaceChild("LeftArmBottom_r1", CubeListBuilder.create().texOffs(134, 110).addBox(-1.5F, -0.4692F, -1.4297F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.8F, 0.2645F, -0.0611F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm2 = Arms.addOrReplaceChild("RightArm2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.7F, -9.75F, 0.8F, -1.7628F, 0.0F, 0.0F));

		PartDefinition RightArmTop_r1 = RightArm2.addOrReplaceChild("RightArmTop_r1", CubeListBuilder.create().texOffs(110, 133).addBox(-2.8F, -1.1752F, -1.4829F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.6F, 0.85F, -0.1F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArmLower = RightArm2.addOrReplaceChild("RightArmLower", CubeListBuilder.create(), PartPose.offset(3.7F, 10.55F, 1.4F));

		PartDefinition RightClaw3_r1 = RightArmLower.addOrReplaceChild("RightClaw3_r1", CubeListBuilder.create().texOffs(146, 147).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, -0.1F, -0.9F, 2.2166F, 0.0F, 0.0F));

		PartDefinition RightClaw2_r1 = RightArmLower.addOrReplaceChild("RightClaw2_r1", CubeListBuilder.create().texOffs(146, 142).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -0.2F, -0.9F, 2.2166F, 0.0F, 0.0F));

		PartDefinition RightClaw1_r1 = RightArmLower.addOrReplaceChild("RightClaw1_r1", CubeListBuilder.create().texOffs(146, 114).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, -0.1F, -0.9F, 2.1991F, 0.0F, 0.0F));

		PartDefinition RightArmBottom_r1 = RightArmLower.addOrReplaceChild("RightArmBottom_r1", CubeListBuilder.create().texOffs(122, 136).addBox(-1.5F, -0.3831F, -1.5419F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.4F, -5.3F, -2.3F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Legs = Bairn.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 5.65F, -4.35F, -0.8727F, 0.0F, 0.0F));

		PartDefinition LeftLeg2 = Legs.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(134, 144).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.0F, -1.0F, -0.4F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftLegLower = LeftLeg2.addOrReplaceChild("LeftLegLower", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 5.1F, -3.1F, -0.5585F, 0.0F, 0.0F));

		PartDefinition LeftLegBottom_r1 = LeftLegLower.addOrReplaceChild("LeftLegBottom_r1", CubeListBuilder.create().texOffs(110, 142).addBox(-1.5F, -0.7302F, -1.2213F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.5F, 2.2F, 1.1694F, 0.0F, 0.0F));

		PartDefinition RightLeg2 = Legs.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(142, 127).addBox(-3.0F, -6.0F, -2.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.5F, 5.0F, -0.1F));

		PartDefinition RightLegBottom_r1 = RightLeg2.addOrReplaceChild("RightLegBottom_r1", CubeListBuilder.create().texOffs(134, 136).addBox(-1.5F, -0.8367F, -1.4179F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.6F, -0.4F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 175, 175);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		}else {
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.LeftLeg.xRot = Mth.cos(limbSwing ) * limbSwingAmount;
		this.RightLeg.xRot = -LeftLeg.xRot;
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.rightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.topRightFangs.yRot = Mth.sin(ageInTicks/6)/7;
		this.bottomRightFangs.yRot = topRightFangs.yRot;
		this.topLegFangs.yRot = -topRightFangs.yRot;
		this.Bairn.y = this.Bairn.getInitialPose().y + Mth.sin(ageInTicks/8);
		float bairnLegs = Mth.sin(ageInTicks/8)/8;
		animateTentacleX(LeftLeg2,bairnLegs);
		animateTentacleX(RightLeg2,bairnLegs);
		animateTentacleX(Head2,-headPitch /  ( 90F / (float) Math.PI));
		animateTentacleY(Head2,netHeadYaw / (180F / (float) Math.PI));
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Howler.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}