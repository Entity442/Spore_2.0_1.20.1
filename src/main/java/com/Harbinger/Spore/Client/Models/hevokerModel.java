package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Hyper.Hevoker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class hevokerModel<T extends Hevoker> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hevokermodel"), "main");
	private final ModelPart hevoker;
	public hevokerModel(ModelPart root) {
		this.hevoker = root.getChild("hevoker");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hevoker = partdefinition.addOrReplaceChild("hevoker", CubeListBuilder.create(), PartPose.offset(-1.0F, 24.0F, 0.0F));

		PartDefinition LowerTorso = hevoker.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(32, 17).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(20, 156).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 12.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.2178F, -21.347F, 1.2354F, 0.3054F, 0.1745F, 0.0F));

		PartDefinition LowerChestFungus = LowerTorso.addOrReplaceChild("LowerChestFungus", CubeListBuilder.create(), PartPose.offset(-1.1585F, -6.4922F, -0.5829F));

		PartDefinition Fungus_r1 = LowerChestFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 54).addBox(-7.5F, 2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4407F, -1.7108F, -1.1025F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r2 = LowerChestFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 47).addBox(0.5F, 1.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4407F, 0.7892F, 2.8975F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r3 = LowerChestFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 61).addBox(-1.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3702F, 2.2607F, -2.0283F, 0.038F, -0.7157F, 0.187F));

		PartDefinition Fungus_r4 = LowerChestFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 47).addBox(-3.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1492F, 3.8413F, 3.0514F, -0.3676F, 0.1954F, 0.5288F));

		PartDefinition Fungus_r5 = LowerChestFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 54).addBox(-0.5F, 2.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4407F, 1.7892F, -3.1025F, 0.1783F, 0.2977F, 0.0909F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-5.25F, -10.0F, -4.0F, 12.0F, 10.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 137).addBox(-5.25F, -10.0F, -4.0F, 12.0F, 12.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.2479F, -7.8034F, -0.2137F, -0.5633F, 0.0702F, 0.1106F));

		PartDefinition UpperChestFungus = UpperTorso.addOrReplaceChild("UpperChestFungus", CubeListBuilder.create(), PartPose.offset(-0.0293F, -7.6888F, 5.6308F));

		PartDefinition Fungus_r6 = UpperChestFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5916F, -0.6675F, -1.8042F, 0.4105F, 0.6399F, -0.2816F));

		PartDefinition Fungus_r7 = UpperChestFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5963F, 1.4276F, -0.7344F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r8 = UpperChestFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 2.2607F, -2.0283F, -0.0908F, 0.6872F, -0.5863F));

		PartDefinition Fungus_r9 = UpperChestFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 0.0F, -5.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4107F, 5.8196F, -8.8257F, 0.1243F, 0.1776F, -0.321F));

		PartDefinition Fungus_r10 = UpperChestFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.5F, 5.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Head = UpperTorso.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -10.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(36, 36).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(56, 66).addBox(-1.0F, -4.0F, -8.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2019F, -10.8646F, -0.8695F, 0.3024F, 0.0F, -0.1167F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(36, 36).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(83, 125).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0455F, -0.3084F, -1.9395F, 0.218F, -0.0076F, 0.043F));

		PartDefinition HeadFungus = Head.addOrReplaceChild("HeadFungus", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Fungus_r11 = HeadFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 61).addBox(-5.5F, -22.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5427F, 12.4366F, -0.5281F, 0.038F, 0.7157F, -0.187F));

		PartDefinition Fungus_r12 = HeadFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 61).addBox(-8.5F, -20.0F, 6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7319F, 15.465F, 1.3978F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition flower = HeadFungus.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(2.8205F, -8.0727F, -2.2797F, 0.9599F, 0.0F, 1.0036F));

		PartDefinition cube_r1 = flower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-7, 47).addBox(0.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r2 = flower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-7, 47).addBox(-7.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r3 = flower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 47).addBox(-3.16F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = flower.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 47).addBox(-3.16F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = HeadFungus.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.8205F, -8.0727F, -2.2797F, 1.0704F, -0.5597F, 0.1547F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-7, 61).addBox(0.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-7, 54).addBox(-7.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-7, 47).addBox(-3.16F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-7, 54).addBox(-3.16F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition BackClaws = UpperTorso.addOrReplaceChild("BackClaws", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackClaw1 = BackClaws.addOrReplaceChild("BackClaw1", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.8349F, -3.482F, 2.0035F, -0.829F, 0.0F, -0.5672F));

		PartDefinition BCJoint1 = BackClaw1.addOrReplaceChild("BCJoint1", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition BCPlane1 = BCJoint1.addOrReplaceChild("BCPlane1", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition BackClaw2 = BackClaws.addOrReplaceChild("BackClaw2", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.8438F, -4.8751F, 1.4513F, -0.6981F, 0.0F, 0.5672F));

		PartDefinition BCJoint2 = BackClaw2.addOrReplaceChild("BCJoint2", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition BCPlane2 = BCJoint2.addOrReplaceChild("BCPlane2", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition BackClaw3 = BackClaws.addOrReplaceChild("BackClaw3", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.8744F, -2.2252F, -0.0086F, -1.0126F, -0.3532F, 1.7191F));

		PartDefinition BCJoint3 = BackClaw3.addOrReplaceChild("BCJoint3", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition BCPlane3 = BCJoint3.addOrReplaceChild("BCPlane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.1512F, -0.4253F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = BCPlane3.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -4.5F, -2.5F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -1.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(88, 31).addBox(-5.0F, -1.5F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 156).addBox(-5.0F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.25F, -0.5F, 0.5F, 0.2174F, 0.0189F, 0.0893F));

		PartDefinition LeftArm2 = LeftArm.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(20, 94).addBox(-2.0F, 0.0F, -2.5F, 4.0F, 6.0F, 5.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-3.1082F, 7.0119F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition LAClaw2 = LeftArm2.addOrReplaceChild("LAClaw2", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.427F, 2.6611F, -0.2101F, -1.6484F, -1.0923F, 2.5916F));

		PartDefinition LAJoint2 = LAClaw2.addOrReplaceChild("LAJoint2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition ClawBase_r1 = LAJoint2.addOrReplaceChild("ClawBase_r1", CubeListBuilder.create().texOffs(114, 119).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition LAPlane2 = LAJoint2.addOrReplaceChild("LAPlane2", CubeListBuilder.create().texOffs(60, -4).addBox(0.0F, -0.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.1506F, 0.3904F, -0.4363F, 0.0F, 0.0F));

		PartDefinition LeftArmSplit1 = LeftArm2.addOrReplaceChild("LeftArmSplit1", CubeListBuilder.create().texOffs(116, 22).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1993F, 5.0463F, 1.0F, 0.0F, 0.5236F, 0.3054F));

		PartDefinition LASplit1Claw = LeftArmSplit1.addOrReplaceChild("LASplit1Claw", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0338F, 5.5857F, -0.1049F, 2.7067F, 0.9739F, 0.0364F));

		PartDefinition LASplit1Joint = LASplit1Claw.addOrReplaceChild("LASplit1Joint", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition LASplit1Plane = LASplit1Joint.addOrReplaceChild("LASplit1Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Plane_r2 = LASplit1Plane.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -3.5F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition LeftArmSplit2 = LeftArm2.addOrReplaceChild("LeftArmSplit2", CubeListBuilder.create().texOffs(108, 45).addBox(-0.75F, -1.0F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.1993F, 5.0463F, -2.0083F, -0.3491F, -0.5236F, 0.3054F));

		PartDefinition LASplit2Claw = LeftArmSplit2.addOrReplaceChild("LASplit2Claw", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.5953F, 7.3483F, 0.1218F, 2.4945F, 1.5138F, 2.9258F));

		PartDefinition LASplit2Joint = LASplit2Claw.addOrReplaceChild("LASplit2Joint", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition ClawBase_r2 = LASplit2Joint.addOrReplaceChild("ClawBase_r2", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition LASplit2Plane = LASplit2Joint.addOrReplaceChild("LASplit2Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r3 = LASplit2Plane.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(61, -4).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition LAClaw1 = LeftArm.addOrReplaceChild("LAClaw1", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.539F, 0.8738F, 0.4958F, 0.0F, 1.5708F, -1.0472F));

		PartDefinition LAJoint1 = LAClaw1.addOrReplaceChild("LAJoint1", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition LAPlane1 = LAJoint1.addOrReplaceChild("LAPlane1", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.0F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightArmFungus = LeftArm.addOrReplaceChild("RightArmFungus", CubeListBuilder.create(), PartPose.offset(-7.7793F, 1.8112F, 0.1308F));

		PartDefinition Fungus_r13 = RightArmFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 54).addBox(-0.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r14 = RightArmFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 61).addBox(-1.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r15 = RightArmFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(-7, 61).addBox(-2.25F, -4.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r16 = RightArmFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(-7, 54).addBox(-1.5F, 3.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(64, 24).addBox(-0.25F, -2.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.258F, 0.045F, -0.1687F));

		PartDefinition RMClaw1 = RightArm.addOrReplaceChild("RMClaw1", CubeListBuilder.create().texOffs(38, 94).addBox(-2.0F, -10.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.415F, 1.9809F, 1.4353F, -1.2074F, -1.0587F, -2.8371F));

		PartDefinition RMJoint1 = RMClaw1.addOrReplaceChild("RMJoint1", CubeListBuilder.create().texOffs(0, 104).addBox(-2.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RMPlane1 = RMJoint1.addOrReplaceChild("RMPlane1", CubeListBuilder.create().texOffs(48, -6).addBox(0.0F, -9.5F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -8.8488F, 0.1753F, 0.3063F, 0.0231F, -0.0059F));

		PartDefinition RAClaw3 = RMClaw1.addOrReplaceChild("RAClaw3", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0525F, -2.5986F, 0.0887F, -0.1203F, -0.2172F, -0.6975F));

		PartDefinition RAJoint3 = RAClaw3.addOrReplaceChild("RAJoint3", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane3 = RAJoint3.addOrReplaceChild("RAPlane3", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RAClaw4 = RMClaw1.addOrReplaceChild("RAClaw4", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4136F, -3.3521F, 0.6696F, 0.3357F, 0.4025F, 0.527F));

		PartDefinition RAJoint4 = RAClaw4.addOrReplaceChild("RAJoint4", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane4 = RAJoint4.addOrReplaceChild("RAPlane4", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightArm2 = RightArm.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(92, 57).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.1745F, 0.0F, -0.2618F));

		PartDefinition RAClaw2 = RightArm2.addOrReplaceChild("RAClaw2", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4262F, 2.9298F, -1.9353F, 1.9525F, -0.8533F, 0.2862F));

		PartDefinition RAJoint2 = RAClaw2.addOrReplaceChild("RAJoint2", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane2 = RAJoint2.addOrReplaceChild("RAPlane2", CubeListBuilder.create().texOffs(49, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RAClaw5 = RightArm2.addOrReplaceChild("RAClaw5", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.3805F, 0.9865F, 1.1291F, 1.2182F, 1.3936F, -1.3904F));

		PartDefinition RAJoint5 = RAClaw5.addOrReplaceChild("RAJoint5", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane5 = RAJoint5.addOrReplaceChild("RAPlane5", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightArm3 = RightArm2.addOrReplaceChild("RightArm3", CubeListBuilder.create().texOffs(94, 45).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -0.25F, -0.3054F, 0.0F, -0.3054F));

		PartDefinition RightArmSplit1 = RightArm3.addOrReplaceChild("RightArmSplit1", CubeListBuilder.create().texOffs(56, 117).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3581F, 5.7537F, -0.3996F, -0.4585F, 0.5816F, 0.2168F));

		PartDefinition RASplit1Claw = RightArmSplit1.addOrReplaceChild("RASplit1Claw", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.3312F, 6.8287F, -0.5515F, 3.1128F, 1.0357F, 0.5147F));

		PartDefinition RASplit1Joint = RASplit1Claw.addOrReplaceChild("RASplit1Joint", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit1Plane = RASplit1Joint.addOrReplaceChild("RASplit1Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Plane_r4 = RASplit1Plane.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -3.5F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit1Claw2 = RightArmSplit1.addOrReplaceChild("RASplit1Claw2", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0952F, 4.0477F, -0.092F, -0.9259F, 0.9971F, 1.426F));

		PartDefinition RASplit1Joint2 = RASplit1Claw2.addOrReplaceChild("RASplit1Joint2", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit1Plane2 = RASplit1Joint2.addOrReplaceChild("RASplit1Plane2", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightArmSplit2 = RightArm3.addOrReplaceChild("RightArmSplit2", CubeListBuilder.create().texOffs(114, 99).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4035F, 4.2047F, 0.8685F, 0.6123F, -0.3289F, 0.0965F));

		PartDefinition RightArmSplit2Seg1 = RightArmSplit2.addOrReplaceChild("RightArmSplit2Seg1", CubeListBuilder.create().texOffs(104, 117).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1471F, 6.3773F, 0.171F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw1 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw1", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.177F, 1.5284F, 0.003F, -2.2405F, -1.0724F, 1.5044F));

		PartDefinition RASplit2Joint1 = RASplit2Claw1.addOrReplaceChild("RASplit2Joint1", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane1 = RASplit2Joint1.addOrReplaceChild("RASplit2Plane1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r5 = RASplit2Plane1.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(60, -4).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit2Claw2 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw2", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.2485F, 5.0629F, -0.1709F, -2.03F, 1.0657F, 0.1813F));

		PartDefinition RASplit2Joint2 = RASplit2Claw2.addOrReplaceChild("RASplit2Joint2", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane2 = RASplit2Joint2.addOrReplaceChild("RASplit2Plane2", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition TorsoTumors = UpperTorso.addOrReplaceChild("TorsoTumors", CubeListBuilder.create(), PartPose.offsetAndRotation(0.03F, -2.1916F, -3.082F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightTumros = TorsoTumors.addOrReplaceChild("RightTumros", CubeListBuilder.create(), PartPose.offset(-1.7207F, 0.3361F, 5.2377F));

		PartDefinition Tumor_r1 = RightTumros.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(4, 77).addBox(-10.0F, -7.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1422F, 4.5043F, -8.5947F, 0.0F, 0.5236F, -0.3491F));

		PartDefinition Tumor_r2 = RightTumros.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(0, 33).addBox(-0.4731F, -8.8371F, -17.1586F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1939F, 0.501F, 9.9209F, 0.1801F, 0.3913F, 0.0164F));

		PartDefinition LeftTumors = TorsoTumors.addOrReplaceChild("LeftTumors", CubeListBuilder.create(), PartPose.offset(3.1978F, -0.7073F, 4.7467F));

		PartDefinition Tumor_r3 = LeftTumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(3, 35).addBox(2.5F, -9.5F, -9.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5815F, 2.5901F, 4.9891F, 0.259F, 0.8158F, 0.246F));

		PartDefinition Tumor_r4 = LeftTumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(3, 35).addBox(-9.0F, 5.5F, 2.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8072F, -1.4656F, -7.0366F, 0.0F, -0.5236F, 0.3491F));

		PartDefinition Tumor_r5 = LeftTumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(3, 35).addBox(-7.5F, -6.5F, 3.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0487F, 3.9773F, -1.9817F, -1.291F, -1.2821F, 1.2467F));

		PartDefinition Legs = hevoker.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(86, 93).addBox(-2.5F, 0.0F, -2.0F, 5.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -22.3193F, 3.6179F, -0.2164F, -0.0283F, -0.1278F));

		PartDefinition LeftLegClaw4 = LeftLeg.addOrReplaceChild("LeftLegClaw4", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -4.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0093F, 5.9026F, -0.3099F, 1.1791F, -0.722F, 0.2315F));

		PartDefinition LLClawJoint5 = LeftLegClaw4.addOrReplaceChild("LLClawJoint5", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -5.0F, -1.0F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition LLClawPlane5 = LLClawJoint5.addOrReplaceChild("LLClawPlane5", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(56, 93).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 172).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 11.1429F, -0.7835F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LeftLegTumors = LeftLeg2.addOrReplaceChild("LeftLegTumors", CubeListBuilder.create(), PartPose.offset(5.0F, 22.0F, -1.0F));

		PartDefinition Tumor_r6 = LeftLegTumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(7, 75).addBox(0.0F, 1.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -14.8236F, 4.1656F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition Tumor_r7 = LeftLegTumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(5, 76).addBox(1.0F, 1.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -19.8236F, 2.1656F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition Tumor_r8 = LeftLegTumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(5, 78).addBox(1.0F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -16.8236F, 2.1656F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition Tumor_r9 = LeftLegTumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(3, 77).addBox(1.0F, 1.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -18.8236F, 4.1656F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(89, 94).addBox(-1.5F, -2.5F, -1.5F, 4.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(38, 145).mirror().addBox(-1.5F, -2.5F, -1.5F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.0711F, -20.0953F, 3.7866F, 0.0852F, -0.0189F, 0.2174F));

		PartDefinition RightLegTumors = RightLeg.addOrReplaceChild("RightLegTumors", CubeListBuilder.create(), PartPose.offset(4.0711F, 18.9189F, -0.9522F));

		PartDefinition Tumor_r10 = RightLegTumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(7, 76).addBox(1.0F, 1.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -19.8236F, 2.1656F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition Tumor_r11 = RightLegTumors.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(6, 79).addBox(1.0F, 1.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -18.8236F, 4.1656F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition RightLeg2 = RightLeg.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(76, 116).addBox(-1.5F, -2.0F, -1.5F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 7.6429F, -0.0335F, -0.5236F, 0.0F, 0.0F));

		PartDefinition RightLeg3 = RightLeg2.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(56, 93).addBox(-2.0F, -3.5F, -2.0F, 5.0F, 11.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 6.5F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RightLegFungus = RightLeg3.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(-2.9882F, 0.1132F, 0.8994F));

		PartDefinition Fungus_r17 = RightLegFungus.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(-7, 61).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r18 = RightLegFungus.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(-7, 47).addBox(-3.5F, 0.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r19 = RightLegFungus.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(-7, 47).addBox(-2.25F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r20 = RightLegFungus.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(-7, 61).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hevoker.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}