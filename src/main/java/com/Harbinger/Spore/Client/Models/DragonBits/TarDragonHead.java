package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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

public class TarDragonHead<T extends LivingEntity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "tardragonhead"), "main");
	private final ModelPart head;
	private final ModelPart topJaw;
	private final ModelPart tarSacks;
	private final ModelPart tarSacks2;
	private final ModelPart head2;
	private final ModelPart head3;
	private final ModelPart head4;
	private final ModelPart head5;
	private final ModelPart head6;
	private final ModelPart FusedBody;
	private final ModelPart ToungeHead;
	private final ModelPart RightArm;
	private final ModelPart RightArmSeg2;
	private final ModelPart head7;
	private final ModelPart tarSacks3;
	private final ModelPart horns;
	private final ModelPart right_horn;
	private final ModelPart FungalBloom;
	private final ModelPart left_horn;
	private final ModelPart LeftJaw;
	private final ModelPart heads;
	private final ModelPart heads2;
	private final ModelPart heads3;
	private final ModelPart RightJaw;
	private final ModelPart heads4;
	private final ModelPart heads5;
	private final ModelPart heads6;
	private final ModelPart Pipe;
	private final ModelPart FS2Body1;
	private final ModelPart FS2Body2;
	private final ModelPart FS2Body3;

	public TarDragonHead() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.head = root.getChild("head");
		this.topJaw = this.head.getChild("topJaw");
		this.tarSacks = this.topJaw.getChild("tarSacks");
		this.tarSacks2 = this.topJaw.getChild("tarSacks2");
		this.head2 = this.topJaw.getChild("head2");
		this.head3 = this.topJaw.getChild("head3");
		this.head4 = this.topJaw.getChild("head4");
		this.head5 = this.topJaw.getChild("head5");
		this.head6 = this.topJaw.getChild("head6");
		this.FusedBody = this.topJaw.getChild("FusedBody");
		this.ToungeHead = this.FusedBody.getChild("ToungeHead");
		this.RightArm = this.FusedBody.getChild("RightArm");
		this.RightArmSeg2 = this.RightArm.getChild("RightArmSeg2");
		this.head7 = this.topJaw.getChild("head7");
		this.tarSacks3 = this.topJaw.getChild("tarSacks3");
		this.horns = this.topJaw.getChild("horns");
		this.right_horn = this.horns.getChild("right_horn");
		this.FungalBloom = this.right_horn.getChild("FungalBloom");
		this.left_horn = this.horns.getChild("left_horn");
		this.LeftJaw = this.head.getChild("LeftJaw");
		this.heads = this.LeftJaw.getChild("heads");
		this.heads2 = this.LeftJaw.getChild("heads2");
		this.heads3 = this.LeftJaw.getChild("heads3");
		this.RightJaw = this.head.getChild("RightJaw");
		this.heads4 = this.RightJaw.getChild("heads4");
		this.heads5 = this.RightJaw.getChild("heads5");
		this.heads6 = this.RightJaw.getChild("heads6");
		this.Pipe = this.head.getChild("Pipe");
		this.FS2Body1 = this.head.getChild("FS2Body1");
		this.FS2Body2 = this.head.getChild("FS2Body2");
		this.FS2Body3 = this.head.getChild("FS2Body3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 60).addBox(-10.0F, -8.0F, -10.0F, 20.0F, 8.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(0, 31).addBox(-10.0F, -1.5F, -10.0F, 20.0F, 9.0F, 20.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition big_teeth_r1 = head.addOrReplaceChild("big_teeth_r1", CubeListBuilder.create().texOffs(0, 123).addBox(-1.0F, -20.0F, -8.0F, 0.0F, 18.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -25.0F, 3.0F, 0.4352F, 0.017F, -0.1298F));

		PartDefinition big_teeth_r2 = head.addOrReplaceChild("big_teeth_r2", CubeListBuilder.create().texOffs(2, 110).addBox(-1.0F, -20.0F, -6.0F, 0.0F, 32.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -20.0F, 1.0F, 0.1309F, 0.0F, 0.1309F));

		PartDefinition big_teeth_r3 = head.addOrReplaceChild("big_teeth_r3", CubeListBuilder.create().texOffs(0, 108).addBox(-1.0F, -20.0F, -8.0F, 0.0F, 32.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -20.0F, 0.0F, 0.1298F, 0.017F, -0.1298F));

		PartDefinition topJaw = head.addOrReplaceChild("topJaw", CubeListBuilder.create().texOffs(80, 79).addBox(-7.0F, -6.5F, -30.0F, 15.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 3.0F, -1.3963F, 0.0F, 0.0F));

		PartDefinition cube_r1 = topJaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -1.25F, 43.0F, 21.0F, 11.25F, 20.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-7.0F, -32.1577F, -47.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition cube_r2 = topJaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(80, 52).addBox(-2.0F, -1.0F, 7.0F, 19.0F, 11.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.6058F, -29.4778F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r3 = topJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(82, 0).addBox(-6.0F, -4.0F, -16.0F, 14.0F, 7.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.25F, -27.25F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r4 = topJaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(80, 31).addBox(-15.0F, -11.0F, -17.0F, 30.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -2.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition tarSacks = topJaw.addOrReplaceChild("tarSacks", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -5.0F, 0.0F, -0.0346F, -0.0266F, -0.654F));

		PartDefinition cube_r5 = tarSacks.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(18, 122).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -1.2F, -1.4F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r6 = tarSacks.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(42, 102).addBox(-2.8F, -8.2F, -7.2F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.8F, 0.6F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition tarSacks2 = topJaw.addOrReplaceChild("tarSacks2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -11.0F, -9.0F, -2.6273F, -1.5028F, -2.9563F));

		PartDefinition cube_r7 = tarSacks2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(94, 122).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1374F, 2.6266F, -4.6177F, 2.786F, -1.0717F, -2.2155F));

		PartDefinition cube_r8 = tarSacks2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(56, 122).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1374F, 2.6266F, -4.6177F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r9 = tarSacks2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 102).addBox(-2.8F, -8.2F, -7.2F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8626F, 4.6266F, -2.6177F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition head2 = topJaw.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(152, 157).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(62, 182).addBox(-4.0F, 4.0F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 3.0F, -37.0F, 0.6127F, -0.3644F, -0.2455F));

		PartDefinition head3 = topJaw.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(32, 158).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(62, 182).addBox(-4.0F, 4.0F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.0F, -37.0F, 0.6229F, 0.4F, 0.2727F));

		PartDefinition head4 = topJaw.addOrReplaceChild("head4", CubeListBuilder.create().texOffs(164, 28).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(62, 182).addBox(-4.0F, 4.0F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -37.0F, 0.089F, -0.0736F, -0.047F));

		PartDefinition head5 = topJaw.addOrReplaceChild("head5", CubeListBuilder.create().texOffs(164, 93).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -5.0F, -18.0F, 0.117F, 0.7081F, 0.0359F));

		PartDefinition head6 = topJaw.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(164, 136).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(62, 182).addBox(-4.0F, 4.0F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -22.0F, 0.2094F, -0.5159F, 2.0281F));

		PartDefinition FusedBody = topJaw.addOrReplaceChild("FusedBody", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0214F, -5.6757F, -15.9144F, 0.3494F, -0.6543F, 0.257F));

		PartDefinition TorsoTop_r1 = FusedBody.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(26, 187).addBox(-3.751F, -2.2061F, -7.0018F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1646F, -0.2037F, 0.4476F, -0.2182F, 0.0F, -0.5236F));

		PartDefinition ToungeHead = FusedBody.addOrReplaceChild("ToungeHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadBase_r1 = ToungeHead.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(82, 23).addBox(-3.5264F, 2.3034F, -3.1802F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -1.6955F, -6.2221F, 0.0F, 0.0F, -0.5236F));

		PartDefinition HeadTop_r1 = ToungeHead.addOrReplaceChild("HeadTop_r1", CubeListBuilder.create().texOffs(62, 182).addBox(-3.5264F, 1.3034F, -7.1802F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -0.6955F, -8.2221F, 0.0F, -0.7418F, -0.0436F));

		PartDefinition HeadTop_r2 = ToungeHead.addOrReplaceChild("HeadTop_r2", CubeListBuilder.create().texOffs(170, 121).addBox(-3.5264F, -3.6966F, -7.1802F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -1.6955F, -8.2221F, 0.0F, -0.7418F, -0.0436F));

		PartDefinition teeth_r1 = ToungeHead.addOrReplaceChild("teeth_r1", CubeListBuilder.create().texOffs(62, 182).addBox(-3.5264F, 0.3034F, -7.1802F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1047F, 0.0545F, -6.2221F, 0.0F, 0.48F, -0.5236F));

		PartDefinition HeadTop_r3 = ToungeHead.addOrReplaceChild("HeadTop_r3", CubeListBuilder.create().texOffs(170, 107).addBox(-3.5264F, -3.6966F, -7.1802F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -1.6955F, -6.2221F, 0.0F, 0.48F, -0.5236F));

		PartDefinition RightArm = FusedBody.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(130, 23).addBox(-1.0359F, -0.7439F, -1.0697F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5848F, -2.6479F, -4.2234F, 0.0F, 0.0F, -0.7767F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create(), PartPose.offset(0.4624F, 4.1404F, 0.4303F));

		PartDefinition RightArmSeg2_r1 = RightArmSeg2.addOrReplaceChild("RightArmSeg2_r1", CubeListBuilder.create().texOffs(196, 44).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0018F, -0.1343F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition head7 = topJaw.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(64, 168).addBox(-4.0F, -2.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, -12.0F, 0.3214F, 0.5347F, 0.0123F));

		PartDefinition tarSacks3 = topJaw.addOrReplaceChild("tarSacks3", CubeListBuilder.create(), PartPose.offsetAndRotation(11.0F, 1.0F, 1.0F, -1.4492F, -1.5028F, -2.9563F));

		PartDefinition cube_r10 = tarSacks3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(132, 119).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0414F, 1.6296F, -1.154F, 2.786F, -1.0717F, -2.2155F));

		PartDefinition cube_r11 = tarSacks3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(126, 102).addBox(-2.8F, -7.2F, -2.2F, 10.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0414F, 1.6296F, -1.154F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r12 = tarSacks3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 88).addBox(-2.8F, -8.2F, -7.2F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9586F, 3.6296F, 0.846F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition horns = topJaw.addOrReplaceChild("horns", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_horn = horns.addOrReplaceChild("right_horn", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6584F, -7.421F, -12.7F, 0.0F, 0.3491F, -0.3927F));

		PartDefinition cube_r13 = right_horn.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(25, 238).addBox(-3.5F, -15.5F, 0.5F, 13.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.586F, -14.6807F, -1.4F, 0.1047F, 0.0F, 0.48F));

		PartDefinition cube_r14 = right_horn.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(1, 236).addBox(-2.5F, -4.5F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.586F, -14.6807F, -0.8F, 0.1222F, 0.0F, 0.48F));

		PartDefinition cube_r15 = right_horn.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 235).addBox(-3.0F, -7.5F, -3.0F, 6.0F, 15.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7978F, -4.4889F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition FungalBloom = right_horn.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.2948F, -10.0591F, -0.4493F, 0.4509F, -0.0813F, -1.6668F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(228, 180).addBox(-11.8501F, -13.8001F, -7.6583F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 1.5803F, -7.8924F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(228, 180).mirror().addBox(-0.8501F, -13.8001F, 5.3417F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.2533F, 1.5803F, -7.8924F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(164, 195).addBox(-16.8501F, -0.8001F, -17.6583F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 1.5803F, -0.3924F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(164, 180).addBox(-16.8501F, -0.8001F, 2.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 1.5803F, -0.3924F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(163, 226).addBox(1.1499F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 1.5803F, -8.3924F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(164, 210).addBox(-17.8501F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 1.5803F, -8.3924F, 0.0F, 0.0F, 0.3927F));

		PartDefinition left_horn = horns.addOrReplaceChild("left_horn", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0001F, -9.0518F, -19.8F, 0.0F, -0.3491F, 0.1745F));

		PartDefinition cube_r16 = left_horn.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(222, 237).addBox(-3.5F, -9.5F, 0.0F, 7.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0566F, -31.3841F, -1.4F, 0.1396F, 0.0F, -0.4363F));

		PartDefinition cube_r17 = left_horn.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6196F, -19.0712F, 1.8161F, -0.0039F, -0.2788F, -1.6134F));

		PartDefinition cube_r18 = left_horn.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8196F, -9.3712F, 2.8161F, 0.264F, -0.3285F, -1.5294F));

		PartDefinition cube_r19 = left_horn.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3196F, -4.8712F, -2.7839F, 0.0F, 0.2007F, -1.8326F));

		PartDefinition cube_r20 = left_horn.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1196F, -7.4712F, -2.7839F, 0.0822F, 0.22F, -1.165F));

		PartDefinition cube_r21 = left_horn.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8196F, -11.1712F, -2.7839F, -0.0031F, 0.2006F, -1.8767F));

		PartDefinition cube_r22 = left_horn.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1196F, -21.4712F, -2.7839F, -0.0062F, 0.2004F, -1.9209F));

		PartDefinition cube_r23 = left_horn.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(244, 217).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5196F, -28.0712F, -2.7839F, 0.0353F, 0.1976F, -1.6546F));

		PartDefinition cube_r24 = left_horn.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(238, 231).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4567F, -22.7677F, -0.6F, 0.0698F, 0.0F, -0.2618F));

		PartDefinition cube_r25 = left_horn.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(236, 230).addBox(-2.5F, -10.5F, -2.5F, 5.0F, 21.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0999F, -5.8482F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition LeftJaw = head.addOrReplaceChild("LeftJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -6.0F, -6.0F, 0.3491F, 0.0F, -0.5236F));

		PartDefinition cube_r26 = LeftJaw.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(140, 197).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0F, 3.0F, 0.7979F, -0.7294F, -0.672F));

		PartDefinition cube_r27 = LeftJaw.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(140, 197).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -3.0F, 1.0F, 0.5314F, -0.3663F, -0.3136F));

		PartDefinition cube_r28 = LeftJaw.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(140, 197).addBox(-1.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -2.0F, -2.0F, 0.4363F, 0.0F, -0.1745F));

		PartDefinition cube_r29 = LeftJaw.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(96, 168).addBox(-1.0F, -9.0F, -4.0F, 7.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -5.0F, 0.48F, 0.0F, 0.0436F));

		PartDefinition cube_r30 = LeftJaw.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(32, 139).addBox(-2.0F, -9.0F, -5.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, -0.3054F));

		PartDefinition heads = LeftJaw.addOrReplaceChild("heads", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.75F, -3.0F, -1.9333F, -0.5214F, 1.6647F));

		PartDefinition Head_r1 = heads.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(42, 88).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r2 = heads.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(47, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads2 = LeftJaw.addOrReplaceChild("heads2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -15.0F, -9.25F, -2.2106F, -0.2007F, 2.3203F));

		PartDefinition Head_r3 = heads2.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(142, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r4 = heads2.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(47, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition heads3 = LeftJaw.addOrReplaceChild("heads3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -7.0F, -1.8024F, -0.5214F, 1.7956F));

		PartDefinition Head_r5 = heads3.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(142, 14).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Head_r6 = heads3.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(47, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition RightJaw = head.addOrReplaceChild("RightJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -6.0F, -6.0F, 0.3491F, 0.0F, 0.5236F));

		PartDefinition cube_r31 = RightJaw.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(144, 197).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.0F, 3.0F, 0.7979F, 0.7294F, 0.672F));

		PartDefinition cube_r32 = RightJaw.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(145, 197).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -3.0F, 1.0F, 0.5314F, 0.3663F, 0.3136F));

		PartDefinition cube_r33 = RightJaw.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(145, 197).addBox(-3.0F, -17.0F, -1.0F, 4.0F, 17.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -2.0F, -2.0F, 0.4363F, 0.0F, 0.1745F));

		PartDefinition cube_r34 = RightJaw.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(174, 0).addBox(-6.0F, -9.0F, -4.0F, 7.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -5.0F, 0.48F, 0.0F, -0.0436F));

		PartDefinition cube_r35 = RightJaw.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(62, 139).addBox(-6.0F, -9.0F, -5.0F, 8.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.3054F));

		PartDefinition heads4 = RightJaw.addOrReplaceChild("heads4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.75F, -3.0F, -1.9333F, 0.5214F, -1.6647F));

		PartDefinition Head_r7 = heads4.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(142, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r8 = heads4.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(48, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition heads5 = RightJaw.addOrReplaceChild("heads5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -15.0F, -9.25F, -2.2106F, 0.2007F, -2.3203F));

		PartDefinition Head_r9 = heads5.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(142, 0).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r10 = heads5.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(48, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition heads6 = RightJaw.addOrReplaceChild("heads6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.0F, -7.0F, -1.8024F, 0.5214F, -1.7956F));

		PartDefinition Head_r11 = heads6.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(142, 14).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Head_r12 = heads6.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(48, 182).addBox(-4.0F, 1.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 3.1416F));

		PartDefinition Pipe = head.addOrReplaceChild("Pipe", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3166F, -4.8746F, 1.5496F, 1.0908F, 0.0F, 0.0F));

		PartDefinition Top_r1 = Pipe.addOrReplaceChild("Top_r1", CubeListBuilder.create().texOffs(122, 175).addBox(-2.0F, -7.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -22.5F, 10.75F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Top_r2 = Pipe.addOrReplaceChild("Top_r2", CubeListBuilder.create().texOffs(124, 157).addBox(-3.0F, -21.0F, -4.0F, 7.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, -0.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Top_r3 = Pipe.addOrReplaceChild("Top_r3", CubeListBuilder.create().texOffs(132, 136).addBox(-4.0F, -11.0F, -4.0F, 8.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition FS2Body1 = head.addOrReplaceChild("FS2Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3428F, -34.6606F, 6.8538F, -0.7612F, 0.0243F, -0.313F));

		PartDefinition Leg_r1 = FS2Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(224, 7).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.6028F, -0.5244F, 1.2983F));

		PartDefinition Arm_r1 = FS2Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(224, 7).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -2.0022F, -1.0335F, 2.2304F));

		PartDefinition Arm_r2 = FS2Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(224, 7).addBox(-0.6482F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0174F, 0.4387F, 0.2722F));

		PartDefinition TorsoBase_r1 = FS2Body1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(224, 7).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r2 = FS2Body1.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(224, 7).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(224, 7).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = FS2Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(224, 7).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7146F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition FS2Body2 = head.addOrReplaceChild("FS2Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.75F, -35.25F, 2.0F, 0.0F, 0.4363F, 0.9163F));

		PartDefinition Leg_r2 = FS2Body2.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(224, 7).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4096F, -3.5211F, -3.0704F, -2.3921F, 0.6278F, -1.2404F));

		PartDefinition Leg_r3 = FS2Body2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(224, 7).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5286F, -3.3013F, 1.75F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r3 = FS2Body2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(224, 7).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, -3.5737F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r13 = FS2Body2.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(224, 7).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.167F, -18.9397F, -4.4906F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r3 = FS2Body2.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(224, 7).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition TorsoBase_r2 = FS2Body2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(224, 7).addBox(-2.5F, -4.0F, -3.25F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition FS2Body3 = head.addOrReplaceChild("FS2Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0788F, -26.1376F, 13.1762F, 1.9682F, -0.218F, 1.8855F));

		PartDefinition Leg_r4 = FS2Body3.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(224, 7).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r3 = FS2Body3.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(224, 7).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r4 = FS2Body3.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(224, 7).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -1.1731F, -0.0861F, -0.0821F));

		PartDefinition Arm_r5 = FS2Body3.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(224, 7).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, 0.8377F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r1 = FS2Body3.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(224, 7).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r14 = FS2Body3.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(224, 7).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.13F, -0.9008F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float value = Mth.cos(ageInTicks/7)/8;
		float value1 = Mth.cos(ageInTicks/7)/6;
		float value2 = Mth.sin(ageInTicks/6)/6;

		animateTentacleX(topJaw,value);
		animateTentacleX(LeftJaw,-value);
		animateTentacleX(RightJaw,-value);
		animateTentacleZ(LeftJaw,value1);
		animateTentacleZ(RightJaw,-value1);
		animateTentacleX(Pipe,value2);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}