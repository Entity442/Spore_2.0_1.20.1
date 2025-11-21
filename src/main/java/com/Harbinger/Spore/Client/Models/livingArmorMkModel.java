package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class livingArmorMkModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "livingarmormkmodel"), "main");
	public final ModelPart headwear;
	private final ModelPart pupil;
	private final ModelPart breathing_aparatus;
	private final ModelPart breathing_aparatus2;
	private final ModelPart brain;
	private final ModelPart lob1;
	private final ModelPart lob2;
	public final ModelPart body;
	private final ModelPart spine;
	private final ModelPart heart;
	private final ModelPart leftJoint;
	private final ModelPart left_wing;
	private final ModelPart left_for_wing;
	private final ModelPart rightJoint;
	private final ModelPart right_wing;
	private final ModelPart right_for_wing;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart pelvis;
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;

	public livingArmorMkModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.headwear = root.getChild("headwear");
		this.pupil = this.headwear.getChild("pupil");
		this.breathing_aparatus = this.headwear.getChild("breathing_aparatus");
		this.breathing_aparatus2 = this.headwear.getChild("breathing_aparatus2");
		this.brain = this.headwear.getChild("brain");
		this.lob1 = this.brain.getChild("lob1");
		this.lob2 = this.brain.getChild("lob2");
		this.body = root.getChild("body");
		this.spine = this.body.getChild("spine");
		this.heart = this.body.getChild("heart");
		this.leftJoint = this.body.getChild("leftJoint");
		this.left_wing = this.leftJoint.getChild("left_wing");
		this.left_for_wing = this.left_wing.getChild("left_for_wing");
		this.rightJoint = this.body.getChild("rightJoint");
		this.right_wing = this.rightJoint.getChild("right_wing");
		this.right_for_wing = this.right_wing.getChild("right_for_wing");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.pelvis = root.getChild("pelvis");
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.2F))
				.texOffs(96, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F))
				.texOffs(32, 6).addBox(-1.0F, -9.0F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(1.0F))
				.texOffs(27, -12).addBox(0.0F, -12.0F, -6.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(64, -8).addBox(-3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(64, -8).addBox(3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(110, 57).addBox(-4.0F, -8.0F, -6.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition pupil = headwear.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(101, 58).addBox(-1.5F, -1.5F, -0.55F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, -3.0F, -6.0F));

		PartDefinition breathing_aparatus = headwear.addOrReplaceChild("breathing_aparatus", CubeListBuilder.create().texOffs(84, 51).addBox(-2.25F, -3.75F, 1.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, -5.0F));

		PartDefinition Plane_r1 = breathing_aparatus.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(88, 57).addBox(-4.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, -3.3567F, 4.776F, -1.4193F, 0.0869F, -0.517F));

		PartDefinition cube_r1 = breathing_aparatus.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(85, 52).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.25F, -2.75F, 4.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = breathing_aparatus.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(84, 46).addBox(-1.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -1.5F, -0.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r3 = breathing_aparatus.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(91, 46).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -0.75F, 0.25F, 0.0F, 0.0F, -0.8727F));

		PartDefinition breathing_aparatus2 = headwear.addOrReplaceChild("breathing_aparatus2", CubeListBuilder.create().texOffs(84, 51).mirror().addBox(0.25F, -3.75F, 1.25F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 0.0F, -5.0F));

		PartDefinition Plane_r2 = breathing_aparatus2.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(88, 57).mirror().addBox(0.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.75F, -3.3567F, 4.776F, -1.4193F, -0.0869F, 0.517F));

		PartDefinition cube_r4 = breathing_aparatus2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(85, 52).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(1.25F, -2.75F, 4.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r5 = breathing_aparatus2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(84, 46).mirror().addBox(0.0F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.75F, -1.5F, -0.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r6 = breathing_aparatus2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(91, 46).mirror().addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, -0.75F, 0.25F, 0.0F, 0.0F, 0.8727F));

		PartDefinition brain = headwear.addOrReplaceChild("brain", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition cube_r7 = brain.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(77, 2).mirror().addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r8 = brain.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(77, 2).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.75F, 0.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r9 = brain.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(77, 2).mirror().addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.5F, -7.0F, 2.0F, 1.7453F, 0.0F, -1.0472F));

		PartDefinition cube_r10 = brain.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(77, 2).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -7.0F, 2.0F, 1.7453F, 0.0F, 1.0472F));

		PartDefinition cube_r11 = brain.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(77, 2).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r12 = brain.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(73, 0).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition lob1 = brain.addOrReplaceChild("lob1", CubeListBuilder.create(), PartPose.offset(3.0F, -6.0F, 0.0F));

		PartDefinition cube_r13 = lob1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(83, 0).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.75F, 2.0F, -1.25F, -0.0814F, 0.2947F, -0.2739F));

		PartDefinition lob2 = brain.addOrReplaceChild("lob2", CubeListBuilder.create(), PartPose.offset(-3.0F, -6.0F, 0.0F));

		PartDefinition cube_r14 = lob2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(83, 0).mirror().addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 2.0F, -1.25F, -0.0814F, -0.2947F, 0.2739F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.15F))
				.texOffs(104, 22).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(110, 43).mirror().addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.25F, 1.0F, 3.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(120, 43).addBox(-2.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 1.0F, 3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, -1.2F, 0.0F));

		PartDefinition cube_r17 = spine.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(62, 38).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 9.166F, 3.3F, -1.3852F, 0.0095F, 0.0174F));

		PartDefinition cube_r18 = spine.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(60, 19).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 8.032F, 3.0F, -1.7279F, 0.0F, 0.0F));

		PartDefinition cube_r19 = spine.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.2294F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 11.536F, 2.4F, -1.8326F, 0.0F, 0.0F));

		PartDefinition cube_r20 = spine.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(62, 44).addBox(-1.0F, -0.6287F, -1.5094F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 3.418F, 2.85F, -1.3788F, 0.0F, 0.0F));

		PartDefinition cube_r21 = spine.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(62, 41).addBox(-1.0F, 0.4781F, -2.8277F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 3.218F, 4.0F, -1.3439F, 0.0F, 0.0F));

		PartDefinition cube_r22 = spine.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(52, 39).addBox(-1.0F, -2.06F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 6.584F, 1.65F, -1.4835F, 0.0F, 0.0F));

		PartDefinition heart = body.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 3.8F, -2.55F, -0.1572F, -0.0832F, 0.3065F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(118, 40).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.0752F, -0.8348F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(122, 38).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r3 = heart.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(112, 38).addBox(-2.1619F, -2.9413F, -1.05F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-0.8252F, 0.4152F, -1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition leftJoint = body.addOrReplaceChild("leftJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -3.0F, 3.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition left_wing = leftJoint.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 78).addBox(-7.25F, -1.0F, -1.0F, 17.0F, 14.0F, 1.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(6.75F, 2.0F, -0.25F, -3.1416F, 0.0F, -2.7925F));

		PartDefinition left_for_wing = left_wing.addOrReplaceChild("left_for_wing", CubeListBuilder.create().texOffs(35, 108).addBox(-12.25F, -7.0F, 0.01F, 17.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, -1.0F));

		PartDefinition rightJoint = body.addOrReplaceChild("rightJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -3.0F, 3.5F, 0.0436F, 0.0F, 0.0F));

		PartDefinition right_wing = rightJoint.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 93).addBox(-9.75F, -1.0F, -0.95F, 17.0F, 14.0F, 1.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-6.75F, 2.0F, -0.25F, -3.1416F, 0.0F, 2.7925F));

		PartDefinition right_for_wing = right_wing.addOrReplaceChild("right_for_wing", CubeListBuilder.create().texOffs(0, 108).addBox(-4.25F, -7.0F, 0.06F, 17.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 12.0F, -1.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.11F))
				.texOffs(88, 22).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r23 = rightArm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(30, 62).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 10.0F, 0.8F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition cube_r24 = rightArm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(62, 30).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 10.0F, -1.2F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition right_arm_r1 = rightArm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(14, 50).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 1.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r2 = rightArm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(58, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.6F, 2.3F, 0.0F, 0.0F, -0.3752F));

		PartDefinition right_arm_r3 = rightArm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(50, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.0F, 1.4F, 0.0F, 0.0F, 0.0262F));

		PartDefinition right_arm_r4 = rightArm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(32, 43).addBox(-4.0F, -12.0F, -1.0F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, 1.2F, -0.8F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r5 = rightArm.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -11.0F, -1.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 3.0F, 0.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.11F))
				.texOffs(72, 22).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r25 = leftArm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(24, 56).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 10.0F, -1.2F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition cube_r26 = leftArm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(62, 5).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, 10.0F, 0.8F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition left_arm_r1 = leftArm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(16, 32).addBox(0.2F, 0.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(4.8F, -2.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition left_arm_r2 = leftArm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(40, 15).addBox(-1.8F, -4.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(88, 35).mirror().addBox(-2.1F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false)
				.texOffs(72, 46).mirror().addBox(-1.5F, -2.0F, -3.0F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r27 = leftLeg.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(72, 46).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.25F, 2.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r28 = leftLeg.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(72, 45).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.75F, 0.25F, 2.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r29 = leftLeg.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 64).mirror().addBox(-0.15F, -2.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, -4.25F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r30 = leftLeg.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(40, 60).mirror().addBox(-3.9F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.61F)).mirror(false), PartPose.offsetAndRotation(1.75F, 0.5F, -3.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r31 = leftLeg.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(52, 6).mirror().addBox(-4.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.6F)).mirror(false), PartPose.offsetAndRotation(2.0F, -0.5F, 4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r32 = leftLeg.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(16, 43).mirror().addBox(0.9F, 2.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.6F, 1.0F, -0.5F, 0.0F, 0.0436F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(88, 35).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F))
				.texOffs(72, 46).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r33 = rightLeg.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(72, 46).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.75F, 0.25F, 2.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r34 = rightLeg.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(72, 45).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, 0.25F, 2.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r35 = rightLeg.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(0, 64).addBox(0.15F, -2.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -4.25F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r36 = rightLeg.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(60, 14).addBox(-0.1F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-1.75F, 0.5F, -3.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r37 = rightLeg.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 4.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r38 = rightLeg.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(16, 43).addBox(-0.9F, 2.0F, -2.0F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 1.0F, -0.5F, 0.0F, -0.0436F, 0.0F));

		PartDefinition pelvis = partdefinition.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(104, 32).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(46, 43).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.11F))
				.texOffs(112, 48).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r39 = leftBoot.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(92, 63).addBox(0.0F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.75F, 9.0F, 0.5F, -0.2153F, -0.8008F, 0.0554F));

		PartDefinition cube_r40 = leftBoot.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(92, 68).addBox(0.0F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.75F, 11.0F, 0.5F, -0.8249F, -1.0228F, 0.7459F));

		PartDefinition cube_r41 = leftBoot.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(72, 57).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 9.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r42 = leftBoot.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(56, 49).addBox(0.0F, -5.0F, -1.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r43 = leftBoot.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(30, 52).addBox(-0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r44 = leftBoot.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(46, 50).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(40, 22).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.12F))
				.texOffs(96, 48).addBox(-1.8F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.99F)), PartPose.offset(-2.1F, 12.0F, 0.0F));

		PartDefinition cube_r45 = rightBoot.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(72, 57).mirror().addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.8F, 9.0F, 1.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r46 = rightBoot.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(92, 68).mirror().addBox(-3.0F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.55F, 11.0F, 0.5F, -0.8249F, 1.0228F, -0.7459F));

		PartDefinition cube_r47 = rightBoot.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(92, 63).mirror().addBox(-3.0F, -4.0F, 0.0F, 3.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.55F, 9.0F, 0.5F, -0.2153F, 0.8008F, -0.0554F));

		PartDefinition cube_r48 = rightBoot.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(56, 19).addBox(0.0F, -5.0F, -1.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r49 = rightBoot.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(14, 54).addBox(-0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r50 = rightBoot.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(52, 29).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void animatedElytra(T entity,ModelPart rightWing,ModelPart leftWing){
		float f = 0.2617994F;
		float f1 = -0.2617994F;
		float f2 = 0.0F;
		float f3 = 0.0F;
		if (entity.isFallFlying()) {
			float f4 = 1.0F;
			Vec3 vec3 = entity.getDeltaMovement();
			if (vec3.y < 0.0D) {
				Vec3 vec31 = vec3.normalize();
				f4 = 1.0F - (float)Math.pow(-vec31.y, 1.5D);
			}

			f = f4 * 0.34906584F + (1.0F - f4) * f;
			f1 = f4 * (-(float)Math.PI / 2F) + (1.0F - f4) * f1;
		} else if (entity.isCrouching()) {
			f = 0.6981317F;
			f1 = (-(float)Math.PI / 4F);
			f2 = 3.0F;
			f3 = 0.08726646F;
		}

		leftWing.y = f2;
		if (entity instanceof AbstractClientPlayer abstractclientplayer) {
			abstractclientplayer.elytraRotX += (f - abstractclientplayer.elytraRotX) * 0.1F;
			abstractclientplayer.elytraRotY += (f3 - abstractclientplayer.elytraRotY) * 0.1F;
			abstractclientplayer.elytraRotZ += (f1 - abstractclientplayer.elytraRotZ) * 0.1F;
			leftWing.xRot = abstractclientplayer.elytraRotX;
			leftWing.yRot = abstractclientplayer.elytraRotY;
			leftWing.zRot = abstractclientplayer.elytraRotZ;
		} else {
			leftWing.xRot = f;
			leftWing.zRot = f1;
			leftWing.yRot = f3;
		}

		rightWing.yRot = -leftWing.yRot;
		rightWing.y = leftWing.y;
		rightWing.xRot = leftWing.xRot;
		rightWing.zRot = -leftWing.zRot;
	}
    private void animateHeart(float age){
        float val = Mth.sin(age/6)/6;
        this.heart.xScale = 1 + val;
        this.heart.zScale = 1 + val;
        this.heart.yScale = 1 - val;
    }
	private void animatePupil(T living){
		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = living.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
            this.pupil.y = d0 > 0.0D ? this.pupil.getInitialPose().y -1 : this.pupil.getInitialPose().y;
			Vec3 vec32 = living.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			this.pupil.x =this.pupil.getInitialPose().x +0.35f+ Mth.sqrt((float)Math.abs(d1)) * 1.5F * (float)Math.signum(d1);
		}
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(lob1, Mth.sin(ageInTicks/8)/10);
		animateTumor(lob2, Mth.cos(ageInTicks/8)/10);
		this.animatedElytra(entity,leftJoint,rightJoint);
		this.right_for_wing.zRot = rightJoint.zRot/2;
		this.left_for_wing.zRot = leftJoint.zRot/2;
		animatePupil(entity);
        animateHeart(ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pelvis.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}