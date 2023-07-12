package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class ProtoHivemindModel<T extends Proto> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "protohivemindmodel"), "main");
	private final ModelPart base;
	private final ModelPart body;

	public ProtoHivemindModel(ModelPart root) {
		this.base = root.getChild("base");
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r1 = base.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition roots = base.addOrReplaceChild("roots", CubeListBuilder.create().texOffs(193, 192).addBox(-13.984F, -10.6729F, -2.0F, 8.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition roots2 = roots.addOrReplaceChild("roots2", CubeListBuilder.create().texOffs(60, 0).addBox(-5.016F, -4.0271F, -1.0F, 5.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.484F, 6.3271F, -0.5F, 0.0F, 0.0F, 0.9163F));

		PartDefinition cube_r2 = roots2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(40, 93).addBox(-0.016F, -0.0271F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-5.0F, 7.0F, 1.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition roots3 = base.addOrReplaceChild("roots3", CubeListBuilder.create().texOffs(24, 189).addBox(-2.0F, -10.6729F, 5.984F, 4.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition roots4 = roots3.addOrReplaceChild("roots4", CubeListBuilder.create().texOffs(0, 52).addBox(-1.016F, -4.0271F, 0.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.484F, 6.3271F, 9.5F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r3 = roots4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 75).addBox(-2.0F, -0.0271F, -2.984F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.984F, 7.0F, 4.984F, -0.9599F, 0.0F, 0.0F));

		PartDefinition roots5 = base.addOrReplaceChild("roots5", CubeListBuilder.create().texOffs(144, 188).addBox(-2.0F, -10.6729F, -13.984F, 4.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition roots6 = roots5.addOrReplaceChild("roots6", CubeListBuilder.create().texOffs(0, 0).addBox(-2.016F, -4.0271F, -5.0F, 3.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.516F, 6.3271F, -9.5F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r4 = roots6.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(76, 0).addBox(-1.0F, -0.0271F, -0.016F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-1.016F, 7.0F, -4.984F, 0.9163F, 0.0F, 0.0F));

		PartDefinition roots7 = base.addOrReplaceChild("roots7", CubeListBuilder.create().texOffs(192, 117).addBox(5.984F, -10.6729F, -2.0F, 8.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition roots8 = roots7.addOrReplaceChild("roots8", CubeListBuilder.create().texOffs(48, 52).addBox(-0.016F, -4.0271F, -1.0F, 5.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.516F, 6.3271F, -0.5F, 0.0F, 0.0F, -0.9163F));

		PartDefinition cube_r5 = roots8.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(64, 52).addBox(-2.984F, -0.0271F, -1.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(4.9681F, 7.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-10.0F, -32.0F, -10.0F, 20.0F, 32.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(64, 52).addBox(-6.0F, -43.0F, -6.0F, 12.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition sides = body.addOrReplaceChild("sides", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r6 = sides.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(120, 24).addBox(12.0F, -40.0F, -4.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r7 = sides.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(114, 108).addBox(5.0F, -30.0F, -4.5F, 10.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r8 = sides.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 84).addBox(5.0F, -16.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition sides2 = body.addOrReplaceChild("sides2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r9 = sides2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(120, 0).addBox(12.0F, -40.0F, -4.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r10 = sides2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(103, 66).addBox(5.0F, -30.0F, -4.5F, 10.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r11 = sides2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(80, 26).addBox(5.0F, -16.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition sides3 = body.addOrReplaceChild("sides3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition cube_r12 = sides3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 118).addBox(12.0F, -40.0F, -4.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r13 = sides3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(31, 101).addBox(5.0F, -30.0F, -4.5F, 10.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r14 = sides3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(80, 0).addBox(5.0F, -16.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition sides4 = body.addOrReplaceChild("sides4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition cube_r15 = sides4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(69, 117).addBox(12.0F, -40.0F, -4.0F, 10.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r16 = sides4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(85, 92).addBox(5.0F, -30.0F, -4.5F, 10.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r17 = sides4.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(54, 75).addBox(5.0F, -16.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition eye = body.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(30, 84).addBox(-4.0F, -4.0F, -3.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(117, 49).addBox(-5.0F, -5.0F, -2.0F, 10.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -10.0F));

		PartDefinition pupil = eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(11, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition brains = body.addOrReplaceChild("brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition brain3 = brains.addOrReplaceChild("brain3", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -26.0F, 5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition brain2 = brains.addOrReplaceChild("brain2", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -19.0F, 6.0F));

		PartDefinition brain = brains.addOrReplaceChild("brain", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, 5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition brains2 = body.addOrReplaceChild("brains2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition brain4 = brains2.addOrReplaceChild("brain4", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -26.0F, 5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition brain5 = brains2.addOrReplaceChild("brain5", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -19.0F, 6.0F));

		PartDefinition brain6 = brains2.addOrReplaceChild("brain6", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, 5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition brains3 = body.addOrReplaceChild("brains3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition brain7 = brains3.addOrReplaceChild("brain7", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -26.0F, 5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition brain8 = brains3.addOrReplaceChild("brain8", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -19.0F, 6.0F));

		PartDefinition brain9 = brains3.addOrReplaceChild("brain9", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, 5.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition brains4 = body.addOrReplaceChild("brains4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition brain10 = brains4.addOrReplaceChild("brain10", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, -26.0F, 5.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition brain11 = brains4.addOrReplaceChild("brain11", CubeListBuilder.create().texOffs(224, 240).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -19.0F, 6.0F));

		PartDefinition tentacleBase = body.addOrReplaceChild("tentacleBase", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, 0.0F, -9.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tentacle = tentacleBase.addOrReplaceChild("tentacle", CubeListBuilder.create().texOffs(23, 146).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tentacle2 = tentacle.addOrReplaceChild("tentacle2", CubeListBuilder.create().texOffs(82, 145).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tentacle3 = tentacle2.addOrReplaceChild("tentacle3", CubeListBuilder.create().texOffs(143, 95).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tentacle4 = tentacle3.addOrReplaceChild("tentacle4", CubeListBuilder.create().texOffs(155, 33).addBox(-1.5F, -1.5F, -15.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tentacleBase2 = body.addOrReplaceChild("tentacleBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 0.0F, -9.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition tentacle5 = tentacleBase2.addOrReplaceChild("tentacle5", CubeListBuilder.create().texOffs(0, 142).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tentacle6 = tentacle5.addOrReplaceChild("tentacle6", CubeListBuilder.create().texOffs(59, 141).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tentacle7 = tentacle6.addOrReplaceChild("tentacle7", CubeListBuilder.create().texOffs(136, 137).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tentacle8 = tentacle7.addOrReplaceChild("tentacle8", CubeListBuilder.create().texOffs(105, 152).addBox(-1.5F, -1.5F, -15.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tentacleBase3 = body.addOrReplaceChild("tentacleBase3", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, 0.0F, 9.0F, 0.0F, -2.3562F, 0.0F));

		PartDefinition tentacle9 = tentacleBase3.addOrReplaceChild("tentacle9", CubeListBuilder.create().texOffs(137, 118).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tentacle10 = tentacle9.addOrReplaceChild("tentacle10", CubeListBuilder.create().texOffs(113, 133).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tentacle11 = tentacle10.addOrReplaceChild("tentacle11", CubeListBuilder.create().texOffs(132, 48).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tentacle12 = tentacle11.addOrReplaceChild("tentacle12", CubeListBuilder.create().texOffs(149, 67).addBox(-1.5F, -1.5F, -15.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tentacleBase4 = body.addOrReplaceChild("tentacleBase4", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, 1.0F, 9.0F, 0.0F, 2.3562F, 0.0F));

		PartDefinition tentacle13 = tentacleBase4.addOrReplaceChild("tentacle13", CubeListBuilder.create().texOffs(90, 126).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tentacle14 = tentacle13.addOrReplaceChild("tentacle14", CubeListBuilder.create().texOffs(126, 76).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -12.75F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tentacle15 = tentacle14.addOrReplaceChild("tentacle15", CubeListBuilder.create().texOffs(36, 126).addBox(-2.0F, -2.0F, -15.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tentacle16 = tentacle15.addOrReplaceChild("tentacle16", CubeListBuilder.create().texOffs(148, 9).addBox(-1.5F, -1.5F, -15.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -14.75F, 0.7854F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Proto proto, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.yRot = netHeadYaw / (180F / (float) Math.PI);

		this.body.getChild("tentacleBase").xRot = Mth.sin(ageInTicks/8)/10;
		this.body.getChild("tentacleBase2").xRot = -Mth.sin(ageInTicks/8)/10;
		this.body.getChild("tentacleBase3").xRot = Mth.sin(ageInTicks/8)/10;
		this.body.getChild("tentacleBase4").xRot = -Mth.sin(ageInTicks/8)/10;

		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = proto.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				this.body.getChild("eye").getChild("pupil").y = 0.0F;
			} else {
				this.body.getChild("eye").getChild("pupil").y = 1.0F;
			}

			Vec3 vec32 = proto.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			this.body.getChild("eye").getChild("pupil").x = Mth.sqrt((float)Math.abs(d1)) * 3.0F * (float)Math.signum(d1);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}