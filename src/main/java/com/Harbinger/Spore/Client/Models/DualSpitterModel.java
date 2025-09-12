package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Spitter;
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

public class DualSpitterModel<T extends Spitter> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dualspittermodel"), "main");
	private final ModelPart thisdoesntmakesense;
	private final ModelPart body;
	private final ModelPart bodywear;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart neck;
	private final ModelPart neckJoint;
	private final ModelPart neck2;
	private final ModelPart neckJoint2;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart RightMandible;
	private final ModelPart RMJ;
	private final ModelPart RightMandible2;
	private final ModelPart RMJ2;
	private final ModelPart LeftMandible;
	private final ModelPart LMJ;
	private final ModelPart LeftMandible2;
	private final ModelPart LMJ2;
	private final ModelPart RightMandible3;
	private final ModelPart RMJ3;
	private final ModelPart RightMandible4;
	private final ModelPart RMJ4;
	private final ModelPart LeftMandible3;
	private final ModelPart LMJ3;
	private final ModelPart LeftMandible4;
	private final ModelPart LMJ4;
	private final ModelPart right_mutated_tube;
	private final ModelPart right_mutated_tube2;
	private final ModelPart right_mutated_tube3;
	private final ModelPart right_mutated_tube4;
	private final ModelPart right_mutated_tube5;
	private final ModelPart left_mutated_tube;
	private final ModelPart left_mutated_tube2;
	private final ModelPart left_mutated_tube3;
	private final ModelPart left_mutated_tube4;
	private final ModelPart left_mutated_tube5;

	public DualSpitterModel(ModelPart root) {
		this.thisdoesntmakesense = root.getChild("thisdoesntmakesense");
		this.body = this.thisdoesntmakesense.getChild("body");
		this.bodywear = this.thisdoesntmakesense.getChild("bodywear");
		this.RightArm = this.thisdoesntmakesense.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.LeftArm = this.thisdoesntmakesense.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.RightLeg = this.thisdoesntmakesense.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = this.thisdoesntmakesense.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.neck = this.thisdoesntmakesense.getChild("neck");
		this.neckJoint = this.neck.getChild("neckJoint");
		this.neck2 = this.neckJoint.getChild("neck2");
		this.neckJoint2 = this.neck2.getChild("neckJoint2");
		this.head = this.neckJoint2.getChild("head");
		this.nose = this.head.getChild("nose");
		this.RightMandible = this.neck2.getChild("RightMandible");
		this.RMJ = this.RightMandible.getChild("RMJ");
		this.RightMandible2 = this.RMJ.getChild("RightMandible2");
		this.RMJ2 = this.RightMandible2.getChild("RMJ2");
		this.LeftMandible = this.neck2.getChild("LeftMandible");
		this.LMJ = this.LeftMandible.getChild("LMJ");
		this.LeftMandible2 = this.LMJ.getChild("LeftMandible2");
		this.LMJ2 = this.LeftMandible2.getChild("LMJ2");
		this.RightMandible3 = this.neck2.getChild("RightMandible3");
		this.RMJ3 = this.RightMandible3.getChild("RMJ3");
		this.RightMandible4 = this.RMJ3.getChild("RightMandible4");
		this.RMJ4 = this.RightMandible4.getChild("RMJ4");
		this.LeftMandible3 = this.neck2.getChild("LeftMandible3");
		this.LMJ3 = this.LeftMandible3.getChild("LMJ3");
		this.LeftMandible4 = this.LMJ3.getChild("LeftMandible4");
		this.LMJ4 = this.LeftMandible4.getChild("LMJ4");
		this.right_mutated_tube = this.neck.getChild("right_mutated_tube");
		this.right_mutated_tube2 = this.right_mutated_tube.getChild("right_mutated_tube2");
		this.right_mutated_tube3 = this.right_mutated_tube2.getChild("right_mutated_tube3");
		this.right_mutated_tube4 = this.right_mutated_tube3.getChild("right_mutated_tube4");
		this.right_mutated_tube5 = this.right_mutated_tube4.getChild("right_mutated_tube5");
		this.left_mutated_tube = this.neck.getChild("left_mutated_tube");
		this.left_mutated_tube2 = this.left_mutated_tube.getChild("left_mutated_tube2");
		this.left_mutated_tube3 = this.left_mutated_tube2.getChild("left_mutated_tube3");
		this.left_mutated_tube4 = this.left_mutated_tube3.getChild("left_mutated_tube4");
		this.left_mutated_tube5 = this.left_mutated_tube4.getChild("left_mutated_tube5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition thisdoesntmakesense = partdefinition.addOrReplaceChild("thisdoesntmakesense", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = thisdoesntmakesense.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, 9.0F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, 25).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(0.0F, -7.0F, 3.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.25F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 10).addBox(-4.0F, -2.5F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(-0.15F))
		.texOffs(0, 0).addBox(0.0F, -2.5F, 2.75F, 0.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(72, 0).addBox(-6.0F, -22.0F, -7.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(74, 1).addBox(-1.0F, -19.0F, -4.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.1687F, -0.045F, -0.258F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(74, 1).addBox(-5.0F, -22.0F, -2.0F, 6.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0495F, 0.045F, 0.258F));

		PartDefinition bodywear = thisdoesntmakesense.addOrReplaceChild("bodywear", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 9.0F, -3.25F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -24.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm = thisdoesntmakesense.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(44, 51).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -20.0F, -3.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(55, 19).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r6 = RightForArm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(18, 53).addBox(0.0F, -2.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r7 = RightForArm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(48, 5).addBox(0.0F, 0.0F, -1.5F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition LeftArm = thisdoesntmakesense.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 51).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -20.0F, -3.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(55, 19).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r8 = LeftForArm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 29).addBox(0.5F, -2.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r9 = LeftForArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 13).addBox(0.5F, 0.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition RightLeg = thisdoesntmakesense.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(16, 45).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(44, 19).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = thisdoesntmakesense.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 41).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -12.0F, 0.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(38, 40).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition neck = thisdoesntmakesense.addOrReplaceChild("neck", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, -3.0F));

		PartDefinition neckJoint = neck.addOrReplaceChild("neckJoint", CubeListBuilder.create().texOffs(23, 38).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition neck2 = neckJoint.addOrReplaceChild("neck2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, 0.0F));

		PartDefinition neckJoint2 = neck2.addOrReplaceChild("neckJoint2", CubeListBuilder.create().texOffs(24, 0).addBox(-2.5F, -2.0F, -3.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition head = neckJoint2.addOrReplaceChild("head", CubeListBuilder.create().texOffs(52, 36).addBox(-3.5F, -2.0F, -4.5F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -9.8F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F))
		.texOffs(62, 0).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 7.75F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 19).addBox(-4.0F, -2.0F, 1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 2).addBox(3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.25F, -2.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r10 = head.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(72, 0).addBox(-6.0F, -34.0F, -12.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, 5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r11 = head.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(72, 0).addBox(-8.0F, -31.0F, -4.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, 5.0F, 0.0495F, 0.045F, 0.258F));

		PartDefinition cube_r12 = head.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(25, 61).addBox(-1.0F, -31.0F, -7.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, 5.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition cube_r13 = head.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(25, 61).addBox(-6.0F, -34.0F, -15.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 27.0F, 5.0F, -0.2597F, 0.0338F, 0.1265F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create(), PartPose.offset(0.0F, -3.25F, -4.5F));

		PartDefinition cube_r14 = nose.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r15 = nose.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(2, 0).addBox(-0.5F, -1.0F, -3.75F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r16 = nose.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(4, 0).addBox(0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r17 = nose.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 2).addBox(0.0F, -0.75F, -3.85F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r18 = nose.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(2, 2).addBox(-0.5F, 0.0F, -2.0F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r19 = nose.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-0.5F, 0.1207F, -2.0141F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -0.25F, -2.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition RightMandible = neck2.addOrReplaceChild("RightMandible", CubeListBuilder.create(), PartPose.offset(-3.0F, -0.25F, -1.5F));

		PartDefinition RMJ = RightMandible.addOrReplaceChild("RMJ", CubeListBuilder.create().texOffs(11, 37).addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 7).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.4363F, 0.0F));

		PartDefinition RightMandible2 = RMJ.addOrReplaceChild("RightMandible2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition RMJ2 = RightMandible2.addOrReplaceChild("RMJ2", CubeListBuilder.create().texOffs(11, 35).addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, -0.3927F, 0.0F));

		PartDefinition LeftMandible = neck2.addOrReplaceChild("LeftMandible", CubeListBuilder.create(), PartPose.offset(3.0F, -0.25F, -1.5F));

		PartDefinition LMJ = LeftMandible.addOrReplaceChild("LMJ", CubeListBuilder.create().texOffs(32, 2).mirror().addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 32).mirror().addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, -0.4363F, 0.0F));

		PartDefinition LeftMandible2 = LMJ.addOrReplaceChild("LeftMandible2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition LMJ2 = LeftMandible2.addOrReplaceChild("LMJ2", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 1).mirror().addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2182F, 0.3927F, 0.0F));

		PartDefinition RightMandible3 = neck2.addOrReplaceChild("RightMandible3", CubeListBuilder.create(), PartPose.offset(-3.0F, -2.25F, 0.5F));

		PartDefinition RMJ3 = RightMandible3.addOrReplaceChild("RMJ3", CubeListBuilder.create().texOffs(11, 37).addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 7).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.3491F, 1.7453F));

		PartDefinition RightMandible4 = RMJ3.addOrReplaceChild("RightMandible4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition RMJ4 = RightMandible4.addOrReplaceChild("RMJ4", CubeListBuilder.create().texOffs(11, 35).addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0436F));

		PartDefinition LeftMandible3 = neck2.addOrReplaceChild("LeftMandible3", CubeListBuilder.create(), PartPose.offset(3.0F, -0.25F, -1.5F));

		PartDefinition LMJ3 = LeftMandible3.addOrReplaceChild("LMJ3", CubeListBuilder.create().texOffs(32, 2).mirror().addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(44, 32).mirror().addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 2.0F, 1.0472F, -0.3491F, -1.7453F));

		PartDefinition LeftMandible4 = LMJ3.addOrReplaceChild("LeftMandible4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -6.0F));

		PartDefinition LMJ4 = LeftMandible4.addOrReplaceChild("LMJ4", CubeListBuilder.create().texOffs(28, 17).mirror().addBox(0.0F, -2.5F, -6.0F, 0.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(38, 1).mirror().addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, -0.0436F));

		PartDefinition right_mutated_tube = neck.addOrReplaceChild("right_mutated_tube", CubeListBuilder.create().texOffs(54, 0).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -3.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition right_mutated_tube2 = right_mutated_tube.addOrReplaceChild("right_mutated_tube2", CubeListBuilder.create().texOffs(8, 54).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition right_mutated_tube3 = right_mutated_tube2.addOrReplaceChild("right_mutated_tube3", CubeListBuilder.create().texOffs(53, 48).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition right_mutated_tube4 = right_mutated_tube3.addOrReplaceChild("right_mutated_tube4", CubeListBuilder.create().texOffs(27, 45).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition right_mutated_tube5 = right_mutated_tube4.addOrReplaceChild("right_mutated_tube5", CubeListBuilder.create().texOffs(52, 30).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(49, 39).addBox(-3.0F, -3.0F, -2.55F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition left_mutated_tube = neck.addOrReplaceChild("left_mutated_tube", CubeListBuilder.create().texOffs(54, 0).addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -3.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition left_mutated_tube2 = left_mutated_tube.addOrReplaceChild("left_mutated_tube2", CubeListBuilder.create().texOffs(8, 54).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition left_mutated_tube3 = left_mutated_tube2.addOrReplaceChild("left_mutated_tube3", CubeListBuilder.create().texOffs(53, 48).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition left_mutated_tube4 = left_mutated_tube3.addOrReplaceChild("left_mutated_tube4", CubeListBuilder.create().texOffs(27, 45).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition left_mutated_tube5 = left_mutated_tube4.addOrReplaceChild("left_mutated_tube5", CubeListBuilder.create().texOffs(52, 30).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(49, 39).addBox(-3.0F, -3.0F, -2.55F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		} else {
			this.RightArm.zRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.zRot = -Mth.sin(ageInTicks/8)/10;
		}

		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		if (LeftLeg.xRot < 0){
			this.leftForLeg.xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.rightForLeg.xRot = -RightLeg.xRot;}

		this.neck.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.neck.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.neck2.xRot = Mth.sin(ageInTicks/8)/8;
		this.left_mutated_tube.xRot = Mth.sin(ageInTicks/8)/10;
		this.right_mutated_tube.xRot = Mth.sin(ageInTicks/8)/10;
		this.RightMandible.xRot = Mth.sin(ageInTicks/5)/4;
		this.LeftMandible.xRot = Mth.sin(ageInTicks/5)/6;
		this.RightMandible.zRot = Mth.sin(ageInTicks/5)/4;
		this.LeftMandible.zRot = -Mth.sin(ageInTicks/4)/5;
		this.RightMandible2.xRot = Mth.sin(ageInTicks/6)/5;
		this.LeftMandible2.xRot = Mth.sin(ageInTicks/5)/6;
		this.RightMandible2.zRot = Mth.sin(ageInTicks/5)/6;
		this.LeftMandible2.zRot = -Mth.sin(ageInTicks/6)/5;
		this.nose.xRot =1 + Mth.sin(ageInTicks/8)/8;
		this.RightMandible3.yRot = Mth.sin(ageInTicks/5)/6;
		this.LeftMandible3.yRot = -Mth.sin(ageInTicks/6)/5;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		thisdoesntmakesense.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}