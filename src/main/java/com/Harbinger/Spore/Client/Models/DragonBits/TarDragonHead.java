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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class TarDragonHead<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "tardragonhead"), "main");
	private final ModelPart head;
	private final ModelPart topJaw;
	private final ModelPart tarSacks;
	private final ModelPart tarSacks2;
	private final ModelPart rightJaw;
	private final ModelPart heads;
	private final ModelPart heads2;
	private final ModelPart heads3;
	private final ModelPart RightJaw;
	private final ModelPart heads4;
	private final ModelPart heads5;
	private final ModelPart heads6;
	private final ModelPart Pipe;
	private final ModelPart C3C3Top;
	private final ModelPart Teeth9;

	public TarDragonHead() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.head = root.getChild("head");
		this.topJaw = this.head.getChild("topJaw");
		this.tarSacks = this.topJaw.getChild("tarSacks");
		this.tarSacks2 = this.topJaw.getChild("tarSacks2");
		this.rightJaw = this.head.getChild("rightJaw");
		this.heads = this.rightJaw.getChild("heads");
		this.heads2 = this.rightJaw.getChild("heads2");
		this.heads3 = this.rightJaw.getChild("heads3");
		this.RightJaw = this.head.getChild("RightJaw");
		this.heads4 = this.RightJaw.getChild("heads4");
		this.heads5 = this.RightJaw.getChild("heads5");
		this.heads6 = this.RightJaw.getChild("heads6");
		this.Pipe = this.head.getChild("Pipe");
		this.C3C3Top = this.Pipe.getChild("C3C3Top");
		this.Teeth9 = this.C3C3Top.getChild("Teeth9");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 60).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-10.0F, -1.5F, -10.0F, 20.0F, 9.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(90, 120).addBox(-5.0F, -8.0F, -34.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(82, 20).addBox(-5.0F, 0.0F, -34.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(80, 79).addBox(-7.0F, -9.0F, -30.0F, 15.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 3.0F, -1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.25F, 43.0F, 21.0F, 11.25F, 20.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.0F, -32.1577F, -47.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = topJaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(80, 52).addBox(-2.0F, -1.0F, 7.0F, 19.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -2.6058F, -29.4778F, 0.48F, 0.0F, 0.0F));

		PartDefinition Head_r1 = topJaw.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(158, 17).addBox(4.0F, 0.0F, -3.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 139).addBox(4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -26.0F, 0.0F, -1.3963F, 0.0F));

		PartDefinition Head_r2 = topJaw.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(150, 66).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(48, 88).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -26.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition Head_r3 = topJaw.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(122, 20).addBox(-7.0F, 0.0F, 1.0F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(130, 119).addBox(-7.0F, -7.0F, 1.0F, 9.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -1.0F, -25.0F, 0.0F, 0.9599F, 0.0F));

		PartDefinition Head_r4 = topJaw.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 121).addBox(-5.0F, -9.0F, -9.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, -13.0F, -0.1745F, -0.5236F, 0.0F));

		PartDefinition Head_r5 = topJaw.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(90, 102).addBox(-5.0F, -9.0F, -9.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.0F, -13.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r3 = topJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(80, 31).addBox(-15.0F, -11.0F, -17.0F, 30.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tarSacks = topJaw.addOrReplaceChild("tarSacks", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -5.0F, 0.0F, -0.0346F, -0.0266F, -0.654F));

		PartDefinition cube_r4 = tarSacks.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 122).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -1.2F, -1.4F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r5 = tarSacks.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(82, 0).addBox(-2.8F, -8.2F, -7.2F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.8F, 0.6F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition tarSacks2 = topJaw.addOrReplaceChild("tarSacks2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -11.0F, -9.0F, -2.6273F, -1.5028F, -2.9563F));

		PartDefinition cube_r6 = tarSacks2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(130, 102).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1374F, 2.6266F, -4.6177F, 2.786F, -1.0717F, -2.2155F));

		PartDefinition cube_r7 = tarSacks2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(124, 0).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1374F, 2.6266F, -4.6177F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r8 = tarSacks2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(48, 102).addBox(-2.8F, -8.2F, -7.2F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8626F, 4.6266F, -2.6177F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition rightJaw = head.addOrReplaceChild("rightJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -6.0F, -6.0F, 0.3491F, 0.0F, -0.5236F));

		PartDefinition cube_r9 = rightJaw.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(98, 157).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0F, 3.0F, 0.7979F, -0.7294F, -0.672F));

		PartDefinition cube_r10 = rightJaw.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(90, 157).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -3.0F, 1.0F, 0.5314F, -0.3663F, -0.3136F));

		PartDefinition cube_r11 = rightJaw.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(64, 139).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -2.0F, -2.0F, 0.4363F, 0.0F, -0.1745F));

		PartDefinition cube_r12 = rightJaw.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(140, 154).addBox(-1.0F, -9.0F, -4.0F, 7.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -5.0F, 0.48F, 0.0F, 0.0436F));

		PartDefinition cube_r13 = rightJaw.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(130, 135).addBox(-2.0F, -9.0F, -5.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, -0.3054F));

		PartDefinition heads = rightJaw.addOrReplaceChild("heads", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.75F, -3.0F, -1.9333F, -0.5214F, 1.6647F));

		PartDefinition Head_r6 = heads.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(32, 139).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r7 = heads.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(142, 93).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads2 = rightJaw.addOrReplaceChild("heads2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -15.0F, -9.25F, -2.2106F, -0.2007F, 2.3203F));

		PartDefinition Head_r8 = heads2.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(142, 79).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r9 = heads2.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(160, 135).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads3 = rightJaw.addOrReplaceChild("heads3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -7.0F, -1.8024F, -0.5214F, 1.7956F));

		PartDefinition Head_r10 = heads3.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(150, 52).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r11 = heads3.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(160, 144).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition RightJaw = head.addOrReplaceChild("RightJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -6.0F, -6.0F, 0.3491F, 0.0F, 0.5236F));

		PartDefinition cube_r14 = RightJaw.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(16, 167).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0F, 3.0F, 0.7979F, 0.7294F, 0.672F));

		PartDefinition cube_r15 = RightJaw.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(8, 167).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -3.0F, 1.0F, 0.5314F, 0.3663F, 0.3136F));

		PartDefinition cube_r16 = RightJaw.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 167).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -2.0F, -2.0F, 0.4363F, 0.0F, 0.1745F));

		PartDefinition cube_r17 = RightJaw.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(64, 157).addBox(-6.0F, -9.0F, -4.0F, 7.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -5.0F, 0.48F, 0.0F, -0.0436F));

		PartDefinition cube_r18 = RightJaw.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(78, 138).addBox(-6.0F, -9.0F, -5.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.3054F));

		PartDefinition heads4 = RightJaw.addOrReplaceChild("heads4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.75F, -3.0F, -1.9333F, 0.5214F, -1.6647F));

		PartDefinition Head_r12 = heads4.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(0, 153).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r13 = heads4.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(162, 0).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition heads5 = RightJaw.addOrReplaceChild("heads5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -15.0F, -9.25F, -2.2106F, 0.2007F, -2.3203F));

		PartDefinition Head_r14 = heads5.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(32, 153).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r15 = heads5.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(164, 27).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition heads6 = RightJaw.addOrReplaceChild("heads6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -7.0F, -1.8024F, 0.5214F, -1.7956F));

		PartDefinition Head_r16 = heads6.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(108, 154).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r17 = heads6.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(164, 36).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Pipe = head.addOrReplaceChild("Pipe", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3166F, -4.8746F, 1.5496F, 1.0908F, 0.0F, 0.0F));

		PartDefinition Top_r1 = Pipe.addOrReplaceChild("Top_r1", CubeListBuilder.create().texOffs(0, 88).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition C3C3Top = Pipe.addOrReplaceChild("C3C3Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.6267F, 8.9715F, -0.4363F, 0.0F, 0.0F));

		PartDefinition West_r1 = C3C3Top.addOrReplaceChild("West_r1", CubeListBuilder.create().texOffs(162, 9).addBox(-6.486F, -4.0743F, -8.1922F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r1 = C3C3Top.addOrReplaceChild("East_r1", CubeListBuilder.create().texOffs(166, 119).addBox(-5.9114F, -7.2091F, 5.801F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r1 = C3C3Top.addOrReplaceChild("South_r1", CubeListBuilder.create().texOffs(166, 162).addBox(-5.6405F, -5.2632F, -2.3617F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r1 = C3C3Top.addOrReplaceChild("North_r1", CubeListBuilder.create().texOffs(166, 153).addBox(-6.1312F, -4.8316F, -0.4703F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth9 = C3C3Top.addOrReplaceChild("Teeth9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Teeth9.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(82, 129).addBox(-4.4703F, -8.8316F, 3.1313F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 129).addBox(-4.4703F, -8.8316F, -3.8687F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r2 = Teeth9.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(86, 128).addBox(1.6383F, -9.2632F, -4.3595F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(86, 122).addBox(1.6383F, -9.2632F, 3.6405F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r3 = Teeth9.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(112, 138).addBox(2.2239F, -6.96F, -6.486F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(108, 138).addBox(2.2239F, -6.96F, 0.514F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r4 = Teeth9.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(82, 122).addBox(-3.8327F, -10.0949F, 5.0886F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(78, 122).addBox(-3.8327F, -10.0949F, -1.9114F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.6545F));

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