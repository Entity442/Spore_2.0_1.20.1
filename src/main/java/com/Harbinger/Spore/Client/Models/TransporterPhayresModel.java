package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
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

import java.util.List;

public class TransporterPhayresModel<T extends Busser> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "transporterphayresmodel"), "main");
	private final ModelPart busser;
	private final ModelPart Tail;
	private final ModelPart Tendril5;
	private final ModelPart TendrilEnd5;
	private final ModelPart Tendril4;
	private final ModelPart TendrilEnd4;
	private final ModelPart Tail2;
	private final ModelPart Tail3;
	private final ModelPart Tail4;
	private final ModelPart Claw;
	private final ModelPart Tendrils;
	private final ModelPart Tendril;
	private final ModelPart TendrilEnd;
	private final ModelPart Tendril2;
	private final ModelPart TendrilEnd2;
	private final ModelPart Tendril3;
	private final ModelPart TendrilEnd3;
	private final ModelPart claws;
	private final ModelPart claws2;
	private final ModelPart flower5;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart flower2;
	private final ModelPart flower3;
	private final ModelPart flower4;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart RightHand;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart LeftHand;
	private final ModelPart body;
	private final ModelPart Tendril6;
	private final ModelPart TendrilEnd6;
	private final ModelPart spine;
	private final ModelPart back;
	private final ModelPart back2;
	private final ModelPart spine2;
	private final ModelPart back3;
	private final ModelPart back4;
	private final ModelPart flower;
	private final ModelPart Tendril8;
	private final ModelPart TendrilEnd8;
	private final ModelPart Tendril7;
	private final ModelPart TendrilEnd7;
	private final ModelPart Tendril9;
	private final ModelPart TendrilEnd9;
	private final ModelPart Tendril10;
	private final ModelPart TendrilEnd10;
	private final ModelPart Tendril11;
	private final ModelPart TendrilEnd11;
	public final List<ModelPart> tail;

	public TransporterPhayresModel(ModelPart root) {
		this.busser = root.getChild("busser");
		this.Tail = this.busser.getChild("Tail");
		this.Tendril5 = this.Tail.getChild("Tendril5");
		this.TendrilEnd5 = this.Tendril5.getChild("TendrilEnd5");
		this.Tendril4 = this.Tail.getChild("Tendril4");
		this.TendrilEnd4 = this.Tendril4.getChild("TendrilEnd4");
		this.Tail2 = this.Tail.getChild("Tail2");
		this.Tail3 = this.Tail2.getChild("Tail3");
		this.Tail4 = this.Tail3.getChild("Tail4");
		this.Claw = this.Tail4.getChild("Claw");
		this.Tendrils = this.Tail3.getChild("Tendrils");
		this.Tendril = this.Tendrils.getChild("Tendril");
		this.TendrilEnd = this.Tendril.getChild("TendrilEnd");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.TendrilEnd2 = this.Tendril2.getChild("TendrilEnd2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.TendrilEnd3 = this.Tendril3.getChild("TendrilEnd3");
		this.claws = this.Tail.getChild("claws");
		this.claws2 = this.Tail.getChild("claws2");
		this.flower5 = this.Tail.getChild("flower5");
		this.head = this.busser.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.flower2 = this.head.getChild("flower2");
		this.flower3 = this.head.getChild("flower3");
		this.flower4 = this.head.getChild("flower4");
		this.RightArm = this.busser.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.RightHand = this.RightForArm.getChild("RightHand");
		this.LeftArm = this.busser.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.LeftHand = this.LeftForArm.getChild("LeftHand");
		this.body = this.busser.getChild("body");
		this.Tendril6 = this.body.getChild("Tendril6");
		this.TendrilEnd6 = this.Tendril6.getChild("TendrilEnd6");
		this.spine = this.body.getChild("spine");
		this.back = this.spine.getChild("back");
		this.back2 = this.spine.getChild("back2");
		this.spine2 = this.body.getChild("spine2");
		this.back3 = this.spine2.getChild("back3");
		this.back4 = this.spine2.getChild("back4");
		this.flower = this.body.getChild("flower");
		this.Tendril8 = this.body.getChild("Tendril8");
		this.TendrilEnd8 = this.Tendril8.getChild("TendrilEnd8");
		this.Tendril7 = this.body.getChild("Tendril7");
		this.TendrilEnd7 = this.Tendril7.getChild("TendrilEnd7");
		this.Tendril9 = this.body.getChild("Tendril9");
		this.TendrilEnd9 = this.Tendril9.getChild("TendrilEnd9");
		this.Tendril10 = this.body.getChild("Tendril10");
		this.TendrilEnd10 = this.Tendril10.getChild("TendrilEnd10");
		this.Tendril11 = this.body.getChild("Tendril11");
		this.TendrilEnd11 = this.Tendril11.getChild("TendrilEnd11");
		tail = List.of(busser,Tail,Tail2,Tail3,Tail4);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition busser = partdefinition.addOrReplaceChild("busser", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, -4.0F));

		PartDefinition Tail = busser.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(54, 55).addBox(-3.0F, 0.0F, -1.75F, 6.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tendril5 = Tail.addOrReplaceChild("Tendril5", CubeListBuilder.create(), PartPose.offsetAndRotation(2.2F, 1.3416F, 1.6707F, 0.1658F, 0.3704F, -2.1391F));

		PartDefinition cube_r1 = Tendril5.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd5 = Tendril5.addOrReplaceChild("TendrilEnd5", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.4F, -0.5F, 2.3F, -1.0627F, -0.9633F, 1.1489F));

		PartDefinition cube_r2 = TendrilEnd5.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 1.0F, 4.2F, 0.2942F, 0.7353F, 0.4529F));

		PartDefinition cube_r3 = TendrilEnd5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Tendril4 = Tail.addOrReplaceChild("Tendril4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1F, 4.0416F, 1.0707F, -0.9913F, 0.2785F, -0.5271F));

		PartDefinition cube_r4 = Tendril4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd4 = Tendril4.addOrReplaceChild("TendrilEnd4", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, 3.1F));

		PartDefinition cube_r5 = TendrilEnd4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 0.0F, 3.3F, 0.0F, 0.7679F, 0.0F));

		PartDefinition cube_r6 = TendrilEnd4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Tail2 = Tail.addOrReplaceChild("Tail2", CubeListBuilder.create().texOffs(93, 82).addBox(-2.5F, 0.0F, -1.25F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Tail3 = Tail2.addOrReplaceChild("Tail3", CubeListBuilder.create().texOffs(93, 92).addBox(-2.5F, 0.0F, -1.25F, 5.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition Tail4 = Tail3.addOrReplaceChild("Tail4", CubeListBuilder.create().texOffs(0, 96).addBox(-1.5F, 0.0F, -1.25F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 6.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Claw = Tail4.addOrReplaceChild("Claw", CubeListBuilder.create(), PartPose.offset(0.5F, 9.0F, 0.0F));

		PartDefinition cube_r7 = Claw.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(80, 82).addBox(1.0F, -4.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4451F));

		PartDefinition cube_r8 = Claw.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 80).addBox(1.0F, -4.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1134F));

		PartDefinition cube_r9 = Claw.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(15, 80).addBox(-1.0F, -4.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3229F));

		PartDefinition Tendrils = Tail3.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9F, 7.7F, -2.0F, -1.3526F, 0.0F, 0.0F));

		PartDefinition Tendril = Tendrils.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offset(-3.0F, -1.5584F, 0.4707F));

		PartDefinition cube_r10 = Tendril.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd = Tendril.addOrReplaceChild("TendrilEnd", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, 3.1F));

		PartDefinition cube_r11 = TendrilEnd.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 0.0F, 3.3F, 0.0F, 0.7679F, 0.0F));

		PartDefinition cube_r12 = TendrilEnd.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offset(-2.2F, -1.0584F, 3.7707F));

		PartDefinition cube_r13 = Tendril2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(90, 66).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition TendrilEnd2 = Tendril2.addOrReplaceChild("TendrilEnd2", CubeListBuilder.create(), PartPose.offset(-4.3F, 0.0F, 2.0F));

		PartDefinition cube_r14 = TendrilEnd2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(101, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.0F, 1.7F, 0.0F, 2.1468F, 0.0F));

		PartDefinition cube_r15 = TendrilEnd2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 48).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.8151F, 0.0F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(98, 23).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, -1.5584F, 1.0707F, 0.0F, 2.7053F, 0.0F));

		PartDefinition TendrilEnd3 = Tendril3.addOrReplaceChild("TendrilEnd3", CubeListBuilder.create(), PartPose.offset(-5.2F, 0.0F, -0.2F));

		PartDefinition cube_r16 = TendrilEnd3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(102, 34).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, 0.0F, -1.2F, 0.0F, -1.4661F, 0.0F));

		PartDefinition cube_r17 = TendrilEnd3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(98, 31).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0821F, 0.0F));

		PartDefinition claws = Tail.addOrReplaceChild("claws", CubeListBuilder.create().texOffs(50, 73).addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition claws2 = Tail.addOrReplaceChild("claws2", CubeListBuilder.create().texOffs(65, 73).addBox(0.0F, 0.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition flower5 = Tail.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 2.25F, 0.0F, -1.309F, -0.3491F, 0.0F));

		PartDefinition cube_r18 = flower5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(25, 59).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r19 = flower5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r20 = flower5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(25, 45).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flower5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(25, 38).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head = busser.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.01F))
		.texOffs(62, 0).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(73, 28).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -25.0F, -3.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(79, 34).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -5.75F, -3.0F, 0.6981F, 0.0F, 0.4363F));

		PartDefinition cube_r22 = flower2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(25, 66).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r23 = flower2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 66).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r24 = flower2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(46, 20).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = flower2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(46, 13).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.25F, -5.75F, 1.0F, -0.1309F, 0.0F, -0.5672F));

		PartDefinition cube_r26 = flower3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 73).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r27 = flower3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(50, 66).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r28 = flower3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r29 = flower3.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(46, 27).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = head.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offset(1.75F, -6.75F, 0.0F));

		PartDefinition cube_r30 = flower4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(73, 14).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r31 = flower4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(73, 7).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r32 = flower4.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(52, 34).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r33 = flower4.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(27, 52).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RightArm = busser.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(37, 99).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(99, 71).addBox(-1.5F, 2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(75, 55).addBox(-1.0F, -1.0F, 1.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -23.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(41, 80).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.5F, 6.75F, 0.0F));

		PartDefinition cube_r34 = RightForArm.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(60, 89).addBox(0.01F, -5.0F, -0.25F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r35 = RightForArm.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(73, 89).addBox(0.0F, 0.0F, 0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition RightHand = RightForArm.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(103, 50).addBox(0.0F, -0.25F, -0.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(-1.0F, 5.75F, 0.0F));

		PartDefinition cube_r36 = RightHand.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(59, 104).addBox(0.0F, 0.0F, -1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r37 = RightHand.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(5, 106).addBox(0.0F, 0.0F, -0.25F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r38 = RightHand.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 15).addBox(0.5F, -4.0F, -5.0F, 0.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LeftArm = busser.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(73, 99).addBox(-1.0F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(100, 41).addBox(-0.5F, 2.0F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(1.0F, -1.0F, 1.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, -23.0F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.5F, 6.75F, 0.0F));

		PartDefinition cube_r39 = LeftForArm.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(90, 51).addBox(1.01F, -5.0F, -0.25F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.25F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r40 = LeftForArm.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(103, 59).addBox(0.0F, 0.0F, 0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LeftHand = LeftForArm.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(64, 104).addBox(0.0F, -0.25F, -0.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 5.75F, 0.0F));

		PartDefinition cube_r41 = LeftHand.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 106).addBox(0.0F, 0.0F, -1.75F, 1.0F, 7.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r42 = LeftHand.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(10, 106).addBox(0.0F, 0.0F, -0.25F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r43 = LeftHand.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(23, 15).addBox(0.5F, -4.0F, -5.0F, 0.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition body = busser.addOrReplaceChild("body", CubeListBuilder.create().texOffs(87, 0).addBox(-3.0F, 10.0F, -1.75F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, -25.0F, 2.0F));

		PartDefinition cube_r44 = body.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(15, 97).addBox(0.0F, -1.0F, 0.0F, 0.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Tendril6 = body.addOrReplaceChild("Tendril6", CubeListBuilder.create().texOffs(98, 23).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 13.3416F, 1.6707F, -2.396F, 0.9002F, -2.6951F));

		PartDefinition TendrilEnd6 = Tendril6.addOrReplaceChild("TendrilEnd6", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.2F, 0.0F, -0.2F, 0.0945F, 0.4685F, -0.4798F));

		PartDefinition cube_r45 = TendrilEnd6.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(102, 34).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 0.9F, -2.2F, -1.3058F, -1.1413F, 1.5109F));

		PartDefinition cube_r46 = TendrilEnd6.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(98, 31).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.0821F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(80, 71).addBox(-2.0F, -2.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F))
		.texOffs(0, 38).addBox(-3.0F, -4.5F, -5.2F, 6.0F, 3.0F, 6.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back = spine.addOrReplaceChild("back", CubeListBuilder.create().texOffs(24, 97).addBox(0.0F, -4.0F, -2.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back2 = spine.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(98, 7).addBox(-1.0F, -4.0F, -2.25F, 2.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -5.5F, -5.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back3 = spine2.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(81, 41).addBox(0.0F, -4.0F, -2.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back4 = spine2.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(41, 89).addBox(-3.0F, -4.0F, -2.25F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition flower = body.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, 2.25F, 0.0F, -1.1345F, -0.3491F, 0.1309F));

		PartDefinition cube_r47 = flower.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(25, 73).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r48 = flower.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(73, 21).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r49 = flower.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(54, 48).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r50 = flower.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(52, 41).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Tendril8 = body.addOrReplaceChild("Tendril8", CubeListBuilder.create(), PartPose.offsetAndRotation(2.6F, 0.4416F, -1.4293F, 0.6426F, -0.075F, 2.2399F));

		PartDefinition cube_r51 = Tendril8.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(90, 66).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition TendrilEnd8 = Tendril8.addOrReplaceChild("TendrilEnd8", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.6F, -0.7F, 1.5F, -0.798F, 0.2892F, -0.4781F));

		PartDefinition cube_r52 = TendrilEnd8.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(101, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -1.3F, 2.6F, -2.3205F, 0.6472F, -2.7984F));

		PartDefinition cube_r53 = TendrilEnd8.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(0, 48).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.8151F, 0.0F));

		PartDefinition Tendril7 = body.addOrReplaceChild("Tendril7", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3F, 4.4416F, 0.2707F, -0.525F, 0.2021F, -0.3677F));

		PartDefinition cube_r54 = Tendril7.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(90, 66).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition TendrilEnd7 = Tendril7.addOrReplaceChild("TendrilEnd7", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8F, -0.4F, 2.3F, -0.1135F, -0.683F, -0.5332F));

		PartDefinition cube_r55 = TendrilEnd7.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(101, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.0F, 1.7F, 0.0F, 2.1468F, 0.0F));

		PartDefinition cube_r56 = TendrilEnd7.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(0, 48).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.8151F, 0.0F));

		PartDefinition Tendril9 = body.addOrReplaceChild("Tendril9", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3F, 10.5416F, -0.3293F, 1.1847F, -1.2458F, -1.4853F));

		PartDefinition cube_r57 = Tendril9.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd9 = Tendril9.addOrReplaceChild("TendrilEnd9", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8F, -0.3F, 3.1F, 0.2127F, -0.9756F, -1.3177F));

		PartDefinition cube_r58 = TendrilEnd9.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 0.0F, 3.3F, 0.0F, 0.7679F, 0.0F));

		PartDefinition cube_r59 = TendrilEnd9.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Tendril10 = body.addOrReplaceChild("Tendril10", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2F, 8.9416F, -0.1293F, 2.5389F, -0.3458F, -2.4329F));

		PartDefinition cube_r60 = Tendril10.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd10 = Tendril10.addOrReplaceChild("TendrilEnd10", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5F, -0.7F, 2.5F, -1.2595F, -0.142F, -0.8439F));

		PartDefinition cube_r61 = TendrilEnd10.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 0.0F, 3.3F, -0.2896F, 0.6641F, -0.1527F));

		PartDefinition cube_r62 = TendrilEnd10.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Tendril11 = body.addOrReplaceChild("Tendril11", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3F, 3.2416F, -1.5293F, -0.8708F, -1.3285F, -1.5531F));

		PartDefinition cube_r63 = Tendril11.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(98, 18).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5061F, 0.0F));

		PartDefinition TendrilEnd11 = Tendril11.addOrReplaceChild("TendrilEnd11", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4F, -0.2F, 2.4F, -1.0619F, 0.2317F, 0.013F));

		PartDefinition cube_r64 = TendrilEnd11.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(86, 102).addBox(-10.0F, -2.0F, -1.0F, 7.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3F, -2.0F, 2.3F, -2.5976F, 0.6729F, -2.3712F));

		PartDefinition cube_r65 = TendrilEnd11.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(98, 28).addBox(-6.0F, -1.0F, -1.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void ScaleUpArm(ModelPart part){
		part.xScale = 1.65f;
		part.yScale = 1.65f;
		part.zScale = 1.65f;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch / (90F / (float) Math.PI);
		this.jaw.xRot = Mth.sin(ageInTicks / 8) / 6;
		this.ScaleUpArm(RightArm);
		this.ScaleUpArm(LeftArm);
		this.claws.xRot = Mth.sin(ageInTicks/4)/3;
		this.claws2.xRot = Mth.sin(ageInTicks/4)/2;
		if (!entity.getBlockStateOn().isAir()){
			this.Tail.yRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.Tail2.yRot = Tail.yRot;
			this.Tail3.yRot = Tail.yRot;
			this.Tail4.yRot = Tail.yRot;
			this.Tail.xRot = 0.4F;
			this.Tail2.xRot = 0.4F;
			this.Tail3.xRot = 0.4F;
			this.Tail4.xRot = 0.4F;
			this.RightArm.zRot =  Mth.sin(ageInTicks/5)/6;
			this.LeftArm.zRot =  - Mth.sin(ageInTicks/5)/6;
			this.RightForArm.zRot = RightArm.zRot < 0 ? Mth.sin(ageInTicks/3)/7 : 0;
			this.LeftForArm.zRot = LeftArm.zRot < 0 ? Mth.sin(ageInTicks/3)/7 : 0;
		}else{
			this.Tail.yRot = 0;
			this.Tail2.yRot = 0;
			this.Tail3.yRot = 0;
			this.Tail4.yRot = 0;
			this.RightArm.zRot = 1.1f + Mth.sin(ageInTicks/3);
			this.LeftArm.zRot = -1.1f - Mth.sin(ageInTicks/3);
			this.RightForArm.zRot = RightArm.zRot > 0 ? Mth.sin(ageInTicks/3)/2 : 0;
			this.LeftForArm.zRot = LeftArm.zRot > 0 ? Mth.sin(ageInTicks/3)/2 : 0;
			if (entity.isVehicle()){
				this.Tail.xRot = 0;
				this.Tail2.xRot = 0;
				this.Tail3.xRot = 0;
			}else {
				float val = -0.3F + Mth.sin(ageInTicks / 3) / 6;
				this.Tail.xRot = val;
				this.Tail2.xRot = -val;
				this.Tail3.xRot = val;
			}
			this.Tail4.xRot = -0.3F + Mth.sin(ageInTicks / 3) / 6;
		}
		float val1 = Mth.cos(ageInTicks/7)/7;
		float val2 = Mth.sin(ageInTicks/6)/5;
		float val3 = Mth.cos(ageInTicks/5)/6;
		float val4 = Mth.sin(ageInTicks/8)/7;
		float val5 = Mth.cos(ageInTicks/6)/7;
		animateTentacleY(Tendril6,val1);
		animateTentacleY(TendrilEnd6,val1);
		animateTentacleX(Tendril8,val3);
		animateTentacleY(Tendril7,val1);
		animateTentacleY(TendrilEnd7,val4);
		animateTentacleZ(Tendril9,val5);
		animateTentacleZ(TendrilEnd9,val2);
		animateTentacleX(Tendril11,val3);
		animateTentacleZ(Tendril5,val5);
		animateTentacleY(Tendril4,val2);

		animateTentacleY(Tendril,val2);
		animateTentacleY(Tendril2,val3);
		animateTentacleY(Tendril3,val5);
		animateTentacleY(TendrilEnd,val1);
		animateTentacleY(TendrilEnd2,val4);
		animateTentacleY(TendrilEnd3,val5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		busser.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}