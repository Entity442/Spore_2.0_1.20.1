package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
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
public class SculkHowlerModel<T extends Howler> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "sculkhowlermodel"), "main");
	private final ModelPart Howler;
	private final ModelPart Head;
	private final ModelPart flower3;
	private final ModelPart flower2;
	private final ModelPart flower;
	private final ModelPart flower4;
	private final ModelPart sculktendril;
	private final ModelPart topRightFangs;
	private final ModelPart topLegFangs;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart body;
	private final ModelPart spine;
	private final ModelPart spine2;
	private final ModelPart tendril;
	private final ModelPart bottomRightFangs;
	private final ModelPart bottomLeftFangs;

	public SculkHowlerModel(ModelPart root) {
		this.Howler = root.getChild("Howler");
		this.Head = this.Howler.getChild("Head");
		this.flower3 = this.Head.getChild("flower3");
		this.flower2 = this.Head.getChild("flower2");
		this.flower = this.Head.getChild("flower");
		this.flower4 = this.Head.getChild("flower4");
		this.sculktendril = this.Head.getChild("sculktendril");
		this.topRightFangs = this.Head.getChild("topRightFangs");
		this.topLegFangs = this.Head.getChild("topLegFangs");
		this.RightArm = this.Howler.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.LeftArm = this.Howler.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.RightLeg = this.Howler.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = this.Howler.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.body = this.Howler.getChild("body");
		this.spine = this.body.getChild("spine");
		this.spine2 = this.body.getChild("spine2");
		this.tendril = this.body.getChild("tendril");
		this.bottomRightFangs = this.body.getChild("bottomRightFangs");
		this.bottomLeftFangs = this.body.getChild("bottomLeftFangs");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Howler = partdefinition.addOrReplaceChild("Howler", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Head = Howler.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 66).addBox(-4.0F, -3.0F, -1.5F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, -4.0F));

		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(82, 105).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.2F, 19.1F, 4.0F, -0.2199F, -0.0971F, 0.3518F));

		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(82, 105).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 22.1F, -0.7F, -0.2482F, 0.2749F, 0.1014F));

		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 105).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.9F, 3.2F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(82, 105).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 22.1F, 5.1F, -0.2618F, 0.0F, -0.2618F));

		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(63, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -0.1F, 4.2F, 0.0385F, 0.0455F, 0.191F));

		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -0.2F, 3.2F, -0.1384F, -0.3891F, 0.0286F));

		PartDefinition cube_r7 = Head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(62, 29).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 1.0F, 1.7F, -0.0978F, 0.2935F, -0.0363F));

		PartDefinition cube_r8 = Head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(62, 18).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 0.1F, -0.9F, 0.1571F, -0.6632F, 0.0F));

		PartDefinition cube_r9 = Head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(21, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.8F, 0.9F, 0.0731F, -0.3595F, -0.2053F));

		PartDefinition cube_r10 = Head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(66, 11).addBox(-1.0F, -4.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.7F, -1.9F, -0.2618F, 0.0F, 0.0F));

		PartDefinition flower3 = Head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -10.25F, 3.5F, -0.9784F, -0.1588F, 0.667F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = flower3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = flower3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower2 = Head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.25F, -8.05F, -2.7F, 0.8814F, 0.8237F, -0.533F));

		PartDefinition cube_r15 = flower2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flower2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r18 = flower2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower = Head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -11.25F, -2.7F, 0.6981F, 0.0F, 0.4363F));

		PartDefinition cube_r19 = flower.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flower.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flower.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r22 = flower.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower4 = Head.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.85F, -11.25F, 0.2F, -0.1042F, 0.8419F, -0.4418F));

		PartDefinition cube_r23 = flower4.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(76, 113).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r24 = flower4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(59, 103).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = flower4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(85, 106).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r26 = flower4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(86, 99).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition sculktendril = Head.addOrReplaceChild("sculktendril", CubeListBuilder.create().texOffs(84, 0).addBox(0.0F, -9.0F, 0.0F, 8.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -8.0F, 0.0F));

		PartDefinition topRightFangs = Head.addOrReplaceChild("topRightFangs", CubeListBuilder.create(), PartPose.offset(-2.35F, -2.05F, -3.7F));

		PartDefinition cube_r27 = topRightFangs.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9541F, 2.55F, -0.577F, 0.0F, 0.3054F, 0.0F));

		PartDefinition cube_r28 = topRightFangs.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.054F, -0.5F, -0.477F, 0.0F, -0.2094F, -0.0698F));

		PartDefinition cube_r29 = topRightFangs.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(10, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.804F, 1.0F, -0.477F, 0.0F, 0.0524F, -0.0698F));

		PartDefinition topLegFangs = Head.addOrReplaceChild("topLegFangs", CubeListBuilder.create(), PartPose.offset(1.0F, -0.6F, -6.0F));

		PartDefinition cube_r30 = topLegFangs.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 1.6F, -0.8F, 0.1047F, -0.4014F, 0.0F));

		PartDefinition cube_r31 = topLegFangs.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(20, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0215F, -0.1732F, -0.124F));

		PartDefinition RightArm = Howler.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(78, 66).addBox(-2.0F, -2.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -22.0F, -1.0F));

		PartDefinition cube_r32 = RightArm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(48, 103).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.4F, 2.25F, -0.1017F, -0.5608F, -0.3127F));

		PartDefinition cube_r33 = RightArm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(84, 98).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.9F, 1.0F, -0.1155F, 0.5691F, -0.2743F));

		PartDefinition cube_r34 = RightArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(56, 103).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.4F, 2.0F, -0.2147F, 0.3179F, 0.1026F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(30, 77).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition LeftArm = Howler.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(78, 77).addBox(-1.0F, -2.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(42, 93).addBox(-1.0F, -2.0F, -2.5F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(6.0F, -22.0F, -1.0F));

		PartDefinition cube_r35 = LeftArm.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(82, 105).addBox(-3.6621F, -1.6826F, -5.7872F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.4F, 1.0F, -0.1017F, -0.299F, -0.1818F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(45, 77).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 4.0F, -0.5F));

		PartDefinition RightLeg = Howler.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(63, 66).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-1.9F, -16.0F, 2.5F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftLeg = Howler.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(75, 40).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(14, 90).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(1.9F, -16.0F, 2.5F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(15, 77).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition body = Howler.addOrReplaceChild("body", CubeListBuilder.create().texOffs(33, 18).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(0, 102).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(0.0F, -25.0F, -1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r36 = body.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, 3.8F, -1.9F, -0.1953F, -0.2F, 0.1065F));

		PartDefinition cube_r37 = body.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(42, 55).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 2.9F, -2.6F, 0.0467F, 0.2201F, 0.0342F));

		PartDefinition cube_r38 = body.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 2.1F, -5.5F, 0.0006F, 0.1336F, 1.7555F));

		PartDefinition cube_r39 = body.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(33, 44).addBox(-4.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, 3.0F, 0.2F, 0.9137F, 0.1587F, -0.1446F));

		PartDefinition cube_r40 = body.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(83, 55).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3792F, 6.2056F, 0.6749F, -0.7008F, 1.5112F, 2.6309F));

		PartDefinition cube_r41 = body.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(82, 105).addBox(1.0F, -29.0F, -13.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.5F, 32.4F, 4.0F, -0.2199F, -0.0971F, 0.3518F));

		PartDefinition cube_r42 = body.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 109).addBox(-6.0F, -5.5F, -5.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(66, 0).addBox(-2.0F, -4.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r43 = spine.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(83, 11).addBox(-2.0F, -4.0F, -2.25F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r44 = spine.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(60, 79).addBox(0.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -5.5F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r45 = spine2.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(44, 66).addBox(-3.0F, -4.0F, -2.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition cube_r46 = spine2.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(25, 66).addBox(0.0F, -4.0F, -1.75F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition tendril = body.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(82, 9).addBox(0.0F, -9.0F, -2.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 7.0F, 3.0F, -0.1745F, -0.5672F, 0.0F));

		PartDefinition bottomRightFangs = body.addOrReplaceChild("bottomRightFangs", CubeListBuilder.create(), PartPose.offset(-1.2F, 0.6F, -6.25F));

		PartDefinition cube_r47 = bottomRightFangs.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 2.75F, -1.05F, 0.0F, 0.1222F, 0.0F));

		PartDefinition cube_r48 = bottomRightFangs.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(5, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.5F, -0.75F, 0.0F, 0.0873F, -0.2094F));

		PartDefinition bottomLeftFangs = body.addOrReplaceChild("bottomLeftFangs", CubeListBuilder.create(), PartPose.offset(2.0F, 1.1F, -5.95F));

		PartDefinition cube_r49 = bottomLeftFangs.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(0, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.0F, 0.0F, -0.1222F, 0.3142F));

		PartDefinition cube_r50 = bottomLeftFangs.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(12, 39).addBox(1.0F, -2.0F, -1.0F, 0.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, 2.8F, -0.85F, 0.0875F, -0.0695F, -0.0061F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.swinging){
			this.RightArm.xRot = -90F;
			this.LeftArm.xRot = -90F;
		}else if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
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
		this.bottomLeftFangs.yRot = topLegFangs.yRot;
		this.sculktendril.zRot = Mth.cos(ageInTicks/6)/7;
		this.tendril.zRot = Mth.cos(ageInTicks/5)/4;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Howler.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}