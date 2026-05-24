package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;


public class SonicDragonHeadModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "sonicdragonheadmodel"), "main");
	private final ModelPart head;
	private final ModelPart segment;
	private final ModelPart flower3;
	private final ModelPart flower2;
	private final ModelPart heads7;
	private final ModelPart heads6;
	private final ModelPart heads5;
	private final ModelPart heads4;
	private final ModelPart heads3;
	private final ModelPart heads;
	private final ModelPart heads2;
	private final ModelPart flower;
	private final ModelPart segment2;
	private final ModelPart segment3;
	private final ModelPart sculkBits;
	private final ModelPart tendril;
	private final ModelPart tendril2;
	private final ModelPart sculkBits2;
	private final ModelPart tendril3;
	private final ModelPart sculkBits3;
	private final ModelPart tendril4;
	private final ModelPart shrieker;

	public SonicDragonHeadModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.head = root.getChild("head");
		this.segment = this.head.getChild("segment");
		this.flower3 = this.segment.getChild("flower3");
		this.flower2 = this.segment.getChild("flower2");
		this.heads7 = this.segment.getChild("heads7");
		this.heads6 = this.segment.getChild("heads6");
		this.heads5 = this.segment.getChild("heads5");
		this.heads4 = this.segment.getChild("heads4");
		this.heads3 = this.segment.getChild("heads3");
		this.heads = this.segment.getChild("heads");
		this.heads2 = this.segment.getChild("heads2");
		this.flower = this.segment.getChild("flower");
		this.segment2 = this.head.getChild("segment2");
		this.segment3 = this.head.getChild("segment3");
		this.sculkBits = this.segment3.getChild("sculkBits");
		this.tendril = this.sculkBits.getChild("tendril");
		this.tendril2 = this.sculkBits.getChild("tendril2");
		this.sculkBits2 = this.segment3.getChild("sculkBits2");
		this.tendril3 = this.sculkBits2.getChild("tendril3");
		this.sculkBits3 = this.segment3.getChild("sculkBits3");
		this.tendril4 = this.sculkBits3.getChild("tendril4");
		this.shrieker = this.head.getChild("shrieker");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 29).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-10.0F, -1.5F, -10.0F, 20.0F, 9.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition segment = head.addOrReplaceChild("segment", CubeListBuilder.create().texOffs(36, 79).addBox(-5.0F, 0.0F, -13.0F, 11.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(94, 148).addBox(-12.0F, 0.0F, -4.0F, 2.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition petal_r1 = segment.addOrReplaceChild("petal_r1", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -4.0F, 16.0F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition petal_r2 = segment.addOrReplaceChild("petal_r2", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -4.0F, 10.0F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition petal_r3 = segment.addOrReplaceChild("petal_r3", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, 14.0F, -0.0873F, 0.0F, 0.0436F));

		PartDefinition cube_r1 = segment.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(30, 141).addBox(-8.0F, -2.0F, -1.0F, 13.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.25F, 9.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition teeth_r1 = segment.addOrReplaceChild("teeth_r1", CubeListBuilder.create().texOffs(150, 76).addBox(-16.0F, -3.0F, -1.0F, 16.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, -11.0F, -2.9671F, 1.2654F, -2.9671F));

		PartDefinition cube_r2 = segment.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 135).addBox(-14.0F, -7.0F, -1.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -11.0F, 3.1416F, 1.2654F, -2.9671F));

		PartDefinition teeth_r2 = segment.addOrReplaceChild("teeth_r2", CubeListBuilder.create().texOffs(151, 79).addBox(-14.0F, -4.0F, -2.0F, 14.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 11.0F, -2.9671F, -1.2654F, -2.9671F));

		PartDefinition cube_r3 = segment.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(146, 42).addBox(-11.0F, -7.0F, -2.0F, 11.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 11.0F, -3.1416F, -1.2654F, -2.9671F));

		PartDefinition cube_r4 = segment.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(80, 43).addBox(-1.0F, -7.0F, 0.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, -11.0F, 0.2182F, 0.4363F, 0.0F));

		PartDefinition cube_r5 = segment.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(96, 134).addBox(-1.0F, -7.0F, -1.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -15.0F, 0.2618F, -0.5236F, 0.0F));

		PartDefinition teeth_r3 = segment.addOrReplaceChild("teeth_r3", CubeListBuilder.create().texOffs(151, 76).addBox(-1.0F, -4.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 1.0F, -11.0F, 2.8719F, -1.2535F, -3.033F));

		PartDefinition cube_r6 = segment.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 79).addBox(-1.0F, -7.0F, -1.0F, 15.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, -11.0F, 3.1416F, -1.2654F, 2.9671F));

		PartDefinition cube_r7 = segment.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(128, 133).addBox(-1.0F, -7.0F, -2.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, 11.0F, -3.1416F, 1.2654F, 2.9671F));

		PartDefinition teeth_r4 = segment.addOrReplaceChild("teeth_r4", CubeListBuilder.create().texOffs(153, 77).addBox(-1.0F, -1.0F, -2.0F, 14.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -3.0F, 9.0F, -0.3054F, -0.4363F, -0.1309F));

		PartDefinition teeth_r5 = segment.addOrReplaceChild("teeth_r5", CubeListBuilder.create().texOffs(153, 77).addBox(-1.0F, -1.0F, -2.0F, 14.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.0F, 9.0F, 0.0873F, -0.4363F, 0.1309F));

		PartDefinition cube_r8 = segment.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(64, 127).addBox(-1.0F, -7.0F, -2.0F, 14.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, 11.0F, -0.2182F, -0.4363F, 0.0F));

		PartDefinition cube_r9 = segment.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(132, 97).addBox(-1.0F, -7.0F, -2.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, -0.2618F, 0.5236F, 0.0F));

		PartDefinition flower3 = segment.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.25F, 6.75F, 14.3F, -1.4863F, -0.3487F, -1.4677F));

		PartDefinition cube_r10 = flower3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(169, 84).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(170, 84).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(170, 84).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r13 = flower3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(164, 84).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower2 = segment.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.75F, -0.25F, -15.7F, 1.8326F, 0.0F, -1.4835F));

		PartDefinition cube_r14 = flower2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(169, 84).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r15 = flower2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(170, 84).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(170, 84).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r17 = flower2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(170, 84).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition heads7 = segment.addOrReplaceChild("heads7", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 4.25F, -14.0F, -1.7067F, 0.6252F, -1.4171F));

		PartDefinition Head_r1 = heads7.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, 0.0F, -0.1745F, 1.0472F, -3.1416F));

		PartDefinition heads6 = segment.addOrReplaceChild("heads6", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 4.25F, -12.0F, -0.2476F, -0.6055F, -0.3067F));

		PartDefinition Head_r2 = heads6.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads5 = segment.addOrReplaceChild("heads5", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, 4.25F, 5.0F, 0.0077F, -0.1744F, -0.3061F));

		PartDefinition Head_r3 = heads5.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, -3.1416F, 1.5272F, 0.0F));

		PartDefinition heads4 = segment.addOrReplaceChild("heads4", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 5.75F, 14.75F, 2.4301F, 0.2275F, 3.0078F));

		PartDefinition Head_r4 = heads4.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads3 = segment.addOrReplaceChild("heads3", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 4.25F, 16.0F, 2.0466F, -0.0434F, 2.7942F));

		PartDefinition Head_r5 = heads3.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads = segment.addOrReplaceChild("heads", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.0F, 4.25F, -6.0F, 0.0188F, 1.1338F, 0.82F));

		PartDefinition Head_r6 = heads.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads2 = segment.addOrReplaceChild("heads2", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.0F, 4.25F, 8.0F, 1.0869F, 1.002F, 2.0343F));

		PartDefinition Head_r7 = heads2.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(224, 53).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition flower = segment.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.25F, 6.75F, -6.7F, 0.0F, 0.0F, -1.4835F));

		PartDefinition cube_r18 = flower.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(170, 84).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = flower.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(170, 84).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flower.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(170, 84).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r21 = flower.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(170, 84).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition segment2 = head.addOrReplaceChild("segment2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, 0.0F, -1.8326F, 0.0F));

		PartDefinition petal_r4 = segment2.addOrReplaceChild("petal_r4", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 1.0F, 9.0F, 0.0F, 1.0036F, -0.1745F));

		PartDefinition petal_r5 = segment2.addOrReplaceChild("petal_r5", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -3.0F, 12.0F, -0.1304F, -0.0114F, -0.0865F));

		PartDefinition petal_r6 = segment2.addOrReplaceChild("petal_r6", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 18.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition petal_r7 = segment2.addOrReplaceChild("petal_r7", CubeListBuilder.create().texOffs(238, 250).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.0F, 18.0F, -1.7297F, -1.4402F, 1.9071F));

		PartDefinition teeth_r6 = segment2.addOrReplaceChild("teeth_r6", CubeListBuilder.create().texOffs(151, 76).addBox(-16.0F, -3.0F, -1.0F, 16.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, 0.0F, -11.0F, -2.9671F, 1.2654F, -2.9671F));

		PartDefinition cube_r22 = segment2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(98, 106).addBox(-14.0F, -7.0F, -1.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.7F, 0.0F, -11.0F, 3.1416F, 1.2654F, -2.9671F));

		PartDefinition teeth_r7 = segment2.addOrReplaceChild("teeth_r7", CubeListBuilder.create().texOffs(152, 79).addBox(-14.0F, -4.0F, -2.0F, 14.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 12.0F, -2.9671F, -1.2654F, -2.9671F));

		PartDefinition cube_r23 = segment2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(126, 147).addBox(-11.0F, -7.0F, -2.0F, 11.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 12.0F, -3.1416F, -1.2654F, -2.9671F));

		PartDefinition cube_r24 = segment2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(80, 28).addBox(-1.0F, -7.0F, 0.0F, 14.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, -12.5F, 0.2182F, 0.4363F, 0.0F));

		PartDefinition cube_r25 = segment2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(114, 28).addBox(-1.0F, -7.0F, -1.0F, 13.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -15.0F, 0.2618F, -0.3927F, 0.0F));

		PartDefinition teeth_r8 = segment2.addOrReplaceChild("teeth_r8", CubeListBuilder.create().texOffs(151, 76).addBox(-1.0F, -4.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 1.0F, -11.0F, 2.8719F, -1.2535F, -3.033F));

		PartDefinition cube_r26 = segment2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(80, 0).addBox(-1.0F, -7.0F, -1.0F, 15.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, -11.0F, 3.1416F, -1.2654F, 2.9671F));

		PartDefinition cube_r27 = segment2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(64, 140).addBox(-1.0F, -7.0F, -2.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.25F, 11.0F, -3.1416F, 1.2654F, 2.9671F));

		PartDefinition teeth_r9 = segment2.addOrReplaceChild("teeth_r9", CubeListBuilder.create().texOffs(153, 77).addBox(-1.0F, -1.0F, -2.0F, 14.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -3.0F, 10.5F, -0.3054F, -0.4363F, -0.1309F));

		PartDefinition teeth_r10 = segment2.addOrReplaceChild("teeth_r10", CubeListBuilder.create().texOffs(153, 77).addBox(-1.0F, -1.0F, -2.0F, 14.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -2.0F, 11.25F, 0.0873F, -0.4363F, 0.1309F));

		PartDefinition cube_r28 = segment2.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(128, 120).addBox(-1.0F, -7.0F, -2.0F, 14.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, 0.0F, 12.0F, -0.2182F, -0.4363F, 0.0F));

		PartDefinition cube_r29 = segment2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(98, 92).addBox(-3.0F, -7.0F, -2.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 0.0F, 15.5F, -0.3054F, 0.3491F, 0.0F));

		PartDefinition segment3 = head.addOrReplaceChild("segment3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -30.0F, 0.0F, 0.0F, -2.4871F, 0.0F));

		PartDefinition teeth_r11 = segment3.addOrReplaceChild("teeth_r11", CubeListBuilder.create().texOffs(151, 76).addBox(-16.0F, 3.0F, -1.0F, 16.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5F, 0.0F, -11.0F, 2.9671F, 1.2654F, 2.9671F));

		PartDefinition cube_r30 = segment3.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(62, 113).addBox(-14.0F, -4.0F, -1.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.7F, 0.0F, -11.0F, -3.1416F, 1.2654F, 2.9671F));

		PartDefinition teeth_r12 = segment3.addOrReplaceChild("teeth_r12", CubeListBuilder.create().texOffs(152, 79).addBox(-14.0F, 4.0F, -2.0F, 14.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 12.0F, 2.9671F, -1.2654F, 2.9671F));

		PartDefinition cube_r31 = segment3.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(148, 0).addBox(-11.0F, -4.0F, -2.0F, 11.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 12.0F, 3.1416F, -1.2654F, 2.9671F));

		PartDefinition cube_r32 = segment3.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(36, 92).addBox(-1.0F, -5.0F, 0.0F, 14.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, -12.5F, -0.2182F, 0.4363F, 0.0F));

		PartDefinition cube_r33 = segment3.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(32, 127).addBox(-1.0F, -4.0F, -1.0F, 13.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -15.0F, -0.2618F, -0.3927F, 0.0F));

		PartDefinition teeth_r13 = segment3.addOrReplaceChild("teeth_r13", CubeListBuilder.create().texOffs(151, 76).addBox(-1.0F, 4.0F, -1.0F, 15.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -1.0F, -11.0F, -2.8719F, -1.2535F, 3.033F));

		PartDefinition cube_r34 = segment3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(80, 14).addBox(-1.0F, -4.0F, -1.0F, 15.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 0.0F, -11.0F, -3.1416F, -1.2654F, -2.9671F));

		PartDefinition cube_r35 = segment3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(146, 28).addBox(-1.0F, -4.0F, -2.0F, 12.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -0.25F, 11.0F, 3.1416F, 1.2654F, -2.9671F));

		PartDefinition teeth_r14 = segment3.addOrReplaceChild("teeth_r14", CubeListBuilder.create().texOffs(153, 77).addBox(-1.0F, 1.0F, -2.0F, 14.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 2.0F, 11.25F, -0.0873F, -0.4363F, -0.1309F));

		PartDefinition cube_r36 = segment3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(132, 84).addBox(-1.0F, -4.0F, -2.0F, 14.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, 0.0F, 12.0F, 0.2182F, -0.4363F, 0.0F));

		PartDefinition cube_r37 = segment3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(28, 107).addBox(-3.0F, -4.0F, -2.0F, 14.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 0.0F, 15.5F, 0.3054F, 0.3491F, 0.0F));

		PartDefinition sculkBits = segment3.addOrReplaceChild("sculkBits", CubeListBuilder.create(), PartPose.offset(-12.0F, 7.0F, 11.0F));

		PartDefinition cube_r38 = sculkBits.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(235, 0).addBox(-3.0F, -5.0F, -1.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r39 = sculkBits.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(235, 0).addBox(-3.0F, -5.0F, -1.0F, 2.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.0F, 1.0036F, 0.0F));

		PartDefinition cube_r40 = sculkBits.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(235, 0).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition tendril = sculkBits.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(0, 149).addBox(-0.5F, -4.0F, 0.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, 1.0F));

		PartDefinition tendril2 = sculkBits.addOrReplaceChild("tendril2", CubeListBuilder.create(), PartPose.offset(-2.0F, -2.0F, 1.0F));

		PartDefinition tendril_r1 = tendril2.addOrReplaceChild("tendril_r1", CubeListBuilder.create().texOffs(20, 151).addBox(0.0F, -9.0F, -1.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 4.0F, 1.0F, 2.8798F, -1.4835F, 3.1416F));

		PartDefinition sculkBits2 = segment3.addOrReplaceChild("sculkBits2", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.0F, 7.0F, -13.0F, 3.0856F, -0.3617F, 0.0036F));

		PartDefinition cube_r41 = sculkBits2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(234, 21).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r42 = sculkBits2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(235, 0).addBox(-4.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.0F, 1.0036F, 0.0F));

		PartDefinition cube_r43 = sculkBits2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(235, 0).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition tendril3 = sculkBits2.addOrReplaceChild("tendril3", CubeListBuilder.create().texOffs(40, 151).addBox(-0.5F, -4.0F, 0.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -2.0F, 1.0F));

		PartDefinition sculkBits3 = segment3.addOrReplaceChild("sculkBits3", CubeListBuilder.create(), PartPose.offsetAndRotation(18.0F, 10.0F, 1.0F, 2.745F, 0.0982F, 1.6775F));

		PartDefinition cube_r44 = sculkBits3.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(230, 16).addBox(-3.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition cube_r45 = sculkBits3.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(235, 0).addBox(-4.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, 0.0F, 1.0036F, 0.0F));

		PartDefinition cube_r46 = sculkBits3.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(235, 0).addBox(-3.0F, -5.0F, -1.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition tendril4 = sculkBits3.addOrReplaceChild("tendril4", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 1.0F));

		PartDefinition tendril_r2 = tendril4.addOrReplaceChild("tendril_r2", CubeListBuilder.create().texOffs(152, 56).addBox(0.0F, -9.0F, -1.0F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 0.0F, 0.0F, 0.0F, 0.9599F, 1.4399F));

		PartDefinition shrieker = head.addOrReplaceChild("shrieker", CubeListBuilder.create().texOffs(0, 57).addBox(-8.0F, -1.0F, -8.0F, 16.0F, 6.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(64, 57).addBox(-7.0F, -7.0F, -7.0F, 14.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}