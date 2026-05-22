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

import java.lang.reflect.Type;

public class ElectricalDragonHeadModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "electricaldragonheadmodel"), "main");
	private final ModelPart head;
	private final ModelPart topJaw;
	private final ModelPart spikes;
	private final ModelPart spikes2;
	private final ModelPart spikes3;
	private final ModelPart spikes4;
	private final ModelPart spikes5;
	private final ModelPart spikes6;
	private final ModelPart spike;
	private final ModelPart spike2;
	private final ModelPart spike3;
	private final ModelPart spike4;
	private final ModelPart spike5;
	private final ModelPart BackBaseCorpseDetails;
	private final ModelPart BBBody1;
	private final ModelPart BBBody2;
	private final ModelPart FS1Body1;
	private final ModelPart bloomingFungus;
	private final ModelPart brains;
	private final ModelPart Brain5;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Brain4;

	public ElectricalDragonHeadModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.head = root.getChild("head");
		this.topJaw = this.head.getChild("topJaw");
		this.spikes = this.head.getChild("spikes");
		this.spikes2 = this.head.getChild("spikes2");
		this.spikes3 = this.head.getChild("spikes3");
		this.spikes4 = this.head.getChild("spikes4");
		this.spikes5 = this.head.getChild("spikes5");
		this.spikes6 = this.head.getChild("spikes6");
		this.spike = this.head.getChild("spike");
		this.spike2 = this.head.getChild("spike2");
		this.spike3 = this.head.getChild("spike3");
		this.spike4 = this.head.getChild("spike4");
		this.spike5 = this.head.getChild("spike5");
		this.BackBaseCorpseDetails = this.head.getChild("BackBaseCorpseDetails");
		this.BBBody1 = this.BackBaseCorpseDetails.getChild("BBBody1");
		this.BBBody2 = this.BackBaseCorpseDetails.getChild("BBBody2");
		this.FS1Body1 = this.head.getChild("FS1Body1");
		this.bloomingFungus = this.head.getChild("bloomingFungus");
		this.brains = this.head.getChild("brains");
		this.Brain5 = this.brains.getChild("Brain5");
		this.Brain1 = this.brains.getChild("Brain1");
		this.Brain2 = this.brains.getChild("Brain2");
		this.Brain3 = this.brains.getChild("Brain3");
		this.Brain4 = this.brains.getChild("Brain4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 60).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-10.0F, -1.5F, -10.0F, 20.0F, 9.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(122, 17).addBox(-3.0F, -8.0F, -26.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(126, 132).addBox(-3.0F, -2.0F, -26.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 3.0F, -1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.25F, 43.0F, 21.0F, 11.25F, 20.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.0F, -32.1577F, -47.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = topJaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(80, 52).addBox(-2.0F, -1.0F, 7.0F, 19.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -2.6058F, -29.4778F, 0.48F, 0.0F, 0.0F));

		PartDefinition Head_r1 = topJaw.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(34, 138).addBox(4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(34, 124).addBox(4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -26.0F, 0.0F, -1.3963F, 0.0F));

		PartDefinition Head_r2 = topJaw.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(82, 18).addBox(-7.0F, 0.0F, 1.0F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(72, 115).addBox(-7.0F, -7.0F, 1.0F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -1.0F, -25.0F, 0.0F, 0.9599F, 0.0F));

		PartDefinition Head_r3 = topJaw.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(82, 0).addBox(-5.0F, -9.0F, -9.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, -13.0F, -0.1745F, -0.5236F, 0.0F));

		PartDefinition Head_r4 = topJaw.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(80, 79).addBox(-5.0F, -9.0F, -9.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -13.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r3 = topJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 31).addBox(-15.0F, -11.0F, -17.0F, 30.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition spikes = head.addOrReplaceChild("spikes", CubeListBuilder.create(), PartPose.offset(-9.0F, -4.0F, 4.0F));

		PartDefinition cube_r4 = spikes.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 115).addBox(-1.0F, -2.0F, -14.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.75F, -0.5F, -15.75F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r5 = spikes.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 88).addBox(-2.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition spikes2 = head.addOrReplaceChild("spikes2", CubeListBuilder.create(), PartPose.offset(9.0F, -4.0F, 3.0F));

		PartDefinition cube_r6 = spikes2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(120, 79).addBox(-1.0F, -2.0F, -14.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, -0.5F, -15.75F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r7 = spikes2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(36, 88).addBox(-1.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition spikes3 = head.addOrReplaceChild("spikes3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -13.0F, 8.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r8 = spikes3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(122, 0).addBox(-1.0F, -2.0F, -14.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.75F, -0.5F, -15.75F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r9 = spikes3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(72, 97).addBox(-2.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition spikes4 = head.addOrReplaceChild("spikes4", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -13.0F, 8.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r10 = spikes4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 124).addBox(-1.0F, -2.0F, -14.0F, 2.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, -0.5F, -15.75F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r11 = spikes4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 106).addBox(-1.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition spikes5 = head.addOrReplaceChild("spikes5", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -22.0F, 8.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r12 = spikes5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 141).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, -0.5F, -15.75F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r13 = spikes5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(36, 106).addBox(-1.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition spikes6 = head.addOrReplaceChild("spikes6", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -22.0F, 8.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r14 = spikes6.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(142, 115).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.75F, -0.5F, -15.75F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r15 = spikes6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(108, 97).addBox(-2.0F, -3.0F, -14.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition spike = head.addOrReplaceChild("spike", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 0.0F, 8.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r16 = spike.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(104, 182).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r17 = spike.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(104, 180).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r18 = spike.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(68, 173).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, 0.1309F, 0.3054F, 0.0F));

		PartDefinition cube_r19 = spike.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(154, 76).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike2 = head.addOrReplaceChild("spike2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -15.0F, 10.0F, 0.2182F, -0.3054F, 0.0F));

		PartDefinition cube_r20 = spike2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(104, 182).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 7.5F, 10.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r21 = spike2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(104, 180).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 7.5F, 10.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r22 = spike2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(86, 173).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, -0.8727F, 0.3054F, 0.0F));

		PartDefinition cube_r23 = spike2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(154, 142).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike3 = head.addOrReplaceChild("spike3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -23.0F, 10.0F, 0.5889F, 0.2564F, 0.1678F));

		PartDefinition cube_r24 = spike3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(104, 182).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r25 = spike3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(104, 180).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r26 = spike3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(22, 174).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, 0.1309F, 0.3054F, 0.0F));

		PartDefinition cube_r27 = spike3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(154, 154).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike4 = head.addOrReplaceChild("spike4", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -8.0F, 10.0F, -0.2618F, 0.0F, -1.6144F));

		PartDefinition cube_r28 = spike4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(104, 180).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r29 = spike4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(104, 182).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r30 = spike4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(178, 48).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, 0.1309F, 0.3054F, 0.0F));

		PartDefinition cube_r31 = spike4.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 155).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition spike5 = head.addOrReplaceChild("spike5", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -5.0F, 10.0F, 1.0971F, 0.0803F, -1.4593F));

		PartDefinition cube_r32 = spike5.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(104, 182).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r33 = spike5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(104, 180).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r34 = spike5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(178, 57).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, 0.1309F, 0.3054F, 0.0F));

		PartDefinition cube_r35 = spike5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(122, 155).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition BackBaseCorpseDetails = head.addOrReplaceChild("BackBaseCorpseDetails", CubeListBuilder.create(), PartPose.offset(-7.75F, -16.25F, 12.5F));

		PartDefinition BBBody1 = BackBaseCorpseDetails.addOrReplaceChild("BBBody1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4685F, -0.571F, -1.1371F));

		PartDefinition TorsoBase_r1 = BBBody1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(203, 2).addBox(-9.761F, -0.3912F, -3.9959F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(203, 2).addBox(-3.7609F, -1.1412F, -4.4959F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6977F, 0.1321F, -0.6429F));

		PartDefinition Jaw_r1 = BBBody1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(203, 2).addBox(0.0412F, -4.0001F, -1.4987F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.85F, -2.3F, 1.4305F, -0.0998F, 0.3135F));

		PartDefinition Head_r5 = BBBody1.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(203, 2).addBox(0.0412F, -4.0001F, -0.4987F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.85F, -2.3F, 0.6014F, -0.0998F, 0.3135F));

		PartDefinition BBBody2 = BackBaseCorpseDetails.addOrReplaceChild("BBBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(17.0F, 0.6887F, 1.8421F, -1.764F, 0.6277F, 1.2834F));

		PartDefinition Arm_r1 = BBBody2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(203, 2).addBox(-7.0379F, -1.9918F, -0.722F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8245F, -2.6276F, 4.2411F, 0.4494F, 0.3479F, -0.6066F));

		PartDefinition TorsoBase_r2 = BBBody2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(203, 2).addBox(-9.7609F, -0.3912F, -3.9958F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.7216F, -0.2689F, -0.9827F));

		PartDefinition TorsoTop_r1 = BBBody2.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(203, 2).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6982F, -0.1364F, -0.8666F));

		PartDefinition FS1Body1 = head.addOrReplaceChild("FS1Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(9.81F, -11.6555F, 10.8738F, 1.1781F, 0.0F, -1.3963F));

		PartDefinition Leg_r1 = FS1Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(202, 7).addBox(-1.1031F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1597F, 1.7237F, 0.5852F));

		PartDefinition Arm_r2 = FS1Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(202, 7).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2365F, -5.5182F, 2.9F, 0.0232F, 0.8265F, 0.2967F));

		PartDefinition Arm_r3 = FS1Body1.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(202, 7).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -2.9185F, 12.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r3 = FS1Body1.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(202, 7).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r2 = FS1Body1.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(202, 7).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(202, 7).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r2 = FS1Body1.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(202, 7).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition bloomingFungus = head.addOrReplaceChild("bloomingFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -27.0F, 16.0F, -0.7919F, -0.0324F, -0.8373F));

		PartDefinition cube_r36 = bloomingFungus.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(206, 53).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -7.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r37 = bloomingFungus.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(206, 53).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -7.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r38 = bloomingFungus.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(208, 96).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r39 = bloomingFungus.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(208, 80).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r40 = bloomingFungus.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(208, 112).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r41 = bloomingFungus.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(208, 128).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition brains = head.addOrReplaceChild("brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain5 = brains.addOrReplaceChild("Brain5", CubeListBuilder.create().texOffs(0, 215).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 197).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.8027F, -3.8588F, -6.564F, 1.3009F, 0.0368F, -0.5658F));

		PartDefinition Brain1 = brains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(0, 215).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 197).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.8026F, -9.8588F, 0.436F, 1.3526F, 0.0F, -0.1309F));

		PartDefinition Brain2 = brains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(0, 215).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 197).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.1974F, -17.8588F, 0.436F, 1.3766F, 0.1001F, 0.3393F));

		PartDefinition Brain3 = brains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(0, 215).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 197).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.1974F, -7.8588F, -0.564F, 0.745F, -0.0376F, -0.3014F));

		PartDefinition Brain4 = brains.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(0, 215).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 197).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 197).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.8026F, -24.8588F, 1.436F, 1.6581F, 0.0F, -0.1309F));

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