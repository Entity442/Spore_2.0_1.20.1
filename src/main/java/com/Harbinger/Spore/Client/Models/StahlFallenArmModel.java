package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.FallenMultipart.StalhArm;
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

public class StahlFallenArmModel<T extends StalhArm> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "stahlfallenarmmodel"), "main");
	private final ModelPart Evilshoulder;
	private final ModelPart Leftarmmain;
	private final ModelPart bloom2;
	private final ModelPart Leftarm;
	private final ModelPart Root3;
	private final ModelPart R3Seg1;
	private final ModelPart R3Seg2;
	private final ModelPart R3Seg3;
	private final ModelPart RootSeg;
	private final ModelPart Root4;
	private final ModelPart R3Seg13;
	private final ModelPart R3Seg14;
	private final ModelPart R3Seg15;
	private final ModelPart RootSeg2;
	private final ModelPart Root5;
	private final ModelPart R3Seg16;
	private final ModelPart R3Seg17;
	private final ModelPart R3Seg18;
	private final ModelPart RootSeg3;
	private final ModelPart Lowersegleftarm;
	private final ModelPart Infectedarm37;
	private final ModelPart Infectedarm38;
	private final ModelPart Infectedarm39;
	private final ModelPart Infectedarm40;
	private final ModelPart bloom3;
	private final ModelPart Infectedarm33;
	private final ModelPart Infectedarm34;
	private final ModelPart Infectedarm36;
	private final ModelPart Infectedarm35;
	private final ModelPart bloom4;
	private final ModelPart Infectedarm41;
	private final ModelPart Infectedarm42;
	private final ModelPart Infectedarm43;
	private final ModelPart Infectedarm44;
	private final ModelPart BladeArmTumor;
	private final ModelPart Evilhand;
	private final ModelPart Bigahhblade;
	private final ModelPart Spitter;
	private final ModelPart Spitterneck;
	private final ModelPart Infectedbody87;
	private final ModelPart Infectedbody88;
	private final ModelPart Infectedbody89;
	private final ModelPart Infectedbody90;
	private final ModelPart Infectedbody91;
	private final ModelPart Spitterhead;
	private final ModelPart Spitterjawright;
	private final ModelPart Lowerspitterjawrigth;
	private final ModelPart Spitterjawleft;
	private final ModelPart Lowerspitterjawleft;
	private final ModelPart Spitterarmleft;
	private final ModelPart Spitterarmright;
	private final ModelPart Spitter2;
	private final ModelPart Spitterneck2;
	private final ModelPart Infectedbody67;
	private final ModelPart Infectedbody69;
	private final ModelPart Infectedbody101;
	private final ModelPart Infectedbody102;
	private final ModelPart Infectedbody103;
	private final ModelPart Spitterhead2;
	private final ModelPart Spitterjawright2;
	private final ModelPart Lowerspitterjawrigth2;
	private final ModelPart Spitterjawleft2;
	private final ModelPart Lowerspitterjawleft2;
	private final ModelPart Spitterarmleft2;
	private final ModelPart Spitterarmright2;
	private final ModelPart Infectedbody109;

	public StahlFallenArmModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Evilshoulder = root.getChild("Evilshoulder");
		this.Leftarmmain = this.Evilshoulder.getChild("Leftarmmain");
		this.bloom2 = this.Leftarmmain.getChild("bloom2");
		this.Leftarm = this.Leftarmmain.getChild("Leftarm");
		this.Root3 = this.Leftarm.getChild("Root3");
		this.R3Seg1 = this.Root3.getChild("R3Seg1");
		this.R3Seg2 = this.R3Seg1.getChild("R3Seg2");
		this.R3Seg3 = this.R3Seg2.getChild("R3Seg3");
		this.RootSeg = this.R3Seg3.getChild("RootSeg");
		this.Root4 = this.Leftarm.getChild("Root4");
		this.R3Seg13 = this.Root4.getChild("R3Seg13");
		this.R3Seg14 = this.R3Seg13.getChild("R3Seg14");
		this.R3Seg15 = this.R3Seg14.getChild("R3Seg15");
		this.RootSeg2 = this.R3Seg15.getChild("RootSeg2");
		this.Root5 = this.Leftarm.getChild("Root5");
		this.R3Seg16 = this.Root5.getChild("R3Seg16");
		this.R3Seg17 = this.R3Seg16.getChild("R3Seg17");
		this.R3Seg18 = this.R3Seg17.getChild("R3Seg18");
		this.RootSeg3 = this.R3Seg18.getChild("RootSeg3");
		this.Lowersegleftarm = this.Leftarm.getChild("Lowersegleftarm");
		this.Infectedarm37 = this.Lowersegleftarm.getChild("Infectedarm37");
		this.Infectedarm38 = this.Infectedarm37.getChild("Infectedarm38");
		this.Infectedarm39 = this.Infectedarm38.getChild("Infectedarm39");
		this.Infectedarm40 = this.Infectedarm38.getChild("Infectedarm40");
		this.bloom3 = this.Lowersegleftarm.getChild("bloom3");
		this.Infectedarm33 = this.Lowersegleftarm.getChild("Infectedarm33");
		this.Infectedarm34 = this.Infectedarm33.getChild("Infectedarm34");
		this.Infectedarm36 = this.Infectedarm34.getChild("Infectedarm36");
		this.Infectedarm35 = this.Infectedarm34.getChild("Infectedarm35");
		this.bloom4 = this.Lowersegleftarm.getChild("bloom4");
		this.Infectedarm41 = this.Lowersegleftarm.getChild("Infectedarm41");
		this.Infectedarm42 = this.Infectedarm41.getChild("Infectedarm42");
		this.Infectedarm43 = this.Infectedarm42.getChild("Infectedarm43");
		this.Infectedarm44 = this.Infectedarm42.getChild("Infectedarm44");
		this.BladeArmTumor = this.Lowersegleftarm.getChild("BladeArmTumor");
		this.Evilhand = this.Lowersegleftarm.getChild("Evilhand");
		this.Bigahhblade = this.Evilhand.getChild("Bigahhblade");
		this.Spitter = this.Bigahhblade.getChild("Spitter");
		this.Spitterneck = this.Spitter.getChild("Spitterneck");
		this.Infectedbody87 = this.Spitterneck.getChild("Infectedbody87");
		this.Infectedbody88 = this.Infectedbody87.getChild("Infectedbody88");
		this.Infectedbody89 = this.Infectedbody88.getChild("Infectedbody89");
		this.Infectedbody90 = this.Infectedbody87.getChild("Infectedbody90");
		this.Infectedbody91 = this.Infectedbody90.getChild("Infectedbody91");
		this.Spitterhead = this.Spitterneck.getChild("Spitterhead");
		this.Spitterjawright = this.Spitterhead.getChild("Spitterjawright");
		this.Lowerspitterjawrigth = this.Spitterjawright.getChild("Lowerspitterjawrigth");
		this.Spitterjawleft = this.Spitterhead.getChild("Spitterjawleft");
		this.Lowerspitterjawleft = this.Spitterjawleft.getChild("Lowerspitterjawleft");
		this.Spitterarmleft = this.Spitter.getChild("Spitterarmleft");
		this.Spitterarmright = this.Spitter.getChild("Spitterarmright");
		this.Spitter2 = this.Bigahhblade.getChild("Spitter2");
		this.Spitterneck2 = this.Spitter2.getChild("Spitterneck2");
		this.Infectedbody67 = this.Spitterneck2.getChild("Infectedbody67");
		this.Infectedbody69 = this.Infectedbody67.getChild("Infectedbody69");
		this.Infectedbody101 = this.Infectedbody69.getChild("Infectedbody101");
		this.Infectedbody102 = this.Infectedbody67.getChild("Infectedbody102");
		this.Infectedbody103 = this.Infectedbody102.getChild("Infectedbody103");
		this.Spitterhead2 = this.Spitterneck2.getChild("Spitterhead2");
		this.Spitterjawright2 = this.Spitterhead2.getChild("Spitterjawright2");
		this.Lowerspitterjawrigth2 = this.Spitterjawright2.getChild("Lowerspitterjawrigth2");
		this.Spitterjawleft2 = this.Spitterhead2.getChild("Spitterjawleft2");
		this.Lowerspitterjawleft2 = this.Spitterjawleft2.getChild("Lowerspitterjawleft2");
		this.Spitterarmleft2 = this.Spitter2.getChild("Spitterarmleft2");
		this.Spitterarmright2 = this.Spitter2.getChild("Spitterarmright2");
		this.Infectedbody109 = this.Evilshoulder.getChild("Infectedbody109");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Evilshoulder = partdefinition.addOrReplaceChild("Evilshoulder", CubeListBuilder.create(), PartPose.offsetAndRotation(-41.0F, 16.0F, 7.0F, -1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Evilshoulder.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(88, 130).addBox(-10.364F, -27.8088F, -8.7859F, 18.0F, 31.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = Evilshoulder.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1518F, -30.6552F, -3.3691F, 1.8467F, 0.1763F, 1.1818F));

		PartDefinition cube_r3 = Evilshoulder.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(438, 12).mirror().addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.1518F, -31.4052F, -1.3691F, 1.2776F, 0.1451F, -0.9586F));

		PartDefinition cube_r4 = Evilshoulder.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1518F, -31.4052F, -3.3691F, 1.2984F, 0.1817F, -0.8312F));

		PartDefinition Leftarmmain = Evilshoulder.addOrReplaceChild("Leftarmmain", CubeListBuilder.create().texOffs(0, 167).addBox(-7.4F, -3.4F, -9.6F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -24.0F, 1.0F, 0.0423F, -0.2224F, -0.5879F));

		PartDefinition cube_r5 = Leftarmmain.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 205).addBox(0.4123F, -12.2379F, -13.5933F, 13.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.2817F, 0.4218F, 0.0621F));

		PartDefinition cube_r6 = Leftarmmain.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(162, 127).addBox(-4.5216F, -14.1399F, -6.7749F, 19.0F, 24.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.3556F, -0.263F, 0.0665F));

		PartDefinition cube_r7 = Leftarmmain.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(108, 45).addBox(-15.1646F, -10.8395F, -8.0167F, 21.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.0824F, 0.363F, 0.1389F));

		PartDefinition cube_r8 = Leftarmmain.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(211, 60).addBox(-7.5F, -4.5F, -10.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1F, 4.1F, -1.1F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cube_r9 = Leftarmmain.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(196, 44).addBox(-6.5F, -4.5F, -9.5F, 11.0F, 11.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 4.1F, -1.1F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cube_r10 = Leftarmmain.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(435, 12).addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.4018F, -15.4052F, 6.1309F, -0.2598F, -0.5328F, 0.1298F));

		PartDefinition cube_r11 = Leftarmmain.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(435, 12).addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4018F, -14.6552F, 7.1309F, -0.2391F, -0.3636F, 0.082F));

		PartDefinition cube_r12 = Leftarmmain.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(435, 12).mirror().addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.4018F, -13.4052F, 11.1309F, -0.228F, 0.0419F, -0.1036F));

		PartDefinition cube_r13 = Leftarmmain.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1518F, -10.4052F, -12.7691F, 1.154F, 0.1855F, -0.41F));

		PartDefinition cube_r14 = Leftarmmain.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1518F, -9.6552F, -12.7691F, 1.7352F, 0.4251F, 1.1485F));

		PartDefinition bloom2 = Leftarmmain.addOrReplaceChild("bloom2", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, -5.0F, -1.0F, 1.3035F, -0.6559F, -0.434F));

		PartDefinition cube_r15 = bloom2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r16 = bloom2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r17 = bloom2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(264, 0).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r18 = bloom2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bloom2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r20 = bloom2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Leftarm = Leftarmmain.addOrReplaceChild("Leftarm", CubeListBuilder.create().texOffs(230, 96).addBox(-7.0F, -8.0F, -7.0F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 239).addBox(5.0F, -4.0F, -2.0F, 22.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, 4.0F, 0.0203F, 0.4359F, 0.6154F));

		PartDefinition cube_r21 = Leftarm.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(328, 0).addBox(20.0F, -4.0F, -14.0F, 8.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(232, 272).addBox(3.0F, -6.0F, -15.0F, 17.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.0F, 3.0F, 1.024F, -0.1218F, 0.006F));

		PartDefinition cube_r22 = Leftarm.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(62, 216).addBox(-7.0F, -18.0F, 2.0F, 37.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.25F, -1.0F, 0.5986F, -0.2469F, -0.0273F));

		PartDefinition cube_r23 = Leftarm.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(328, 354).addBox(1.0F, -13.0F, 2.0F, 10.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 4.0F, 0.7928F, -0.1657F, 0.0839F));

		PartDefinition cube_r24 = Leftarm.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(192, 45).addBox(-7.0F, -10.0F, -10.0F, 18.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 0.0F, 0.8319F, -0.3161F, -0.079F));

		PartDefinition cube_r25 = Leftarm.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(296, 354).addBox(14.0F, -11.0F, -2.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(288, 272).mirror().addBox(-9.0F, -26.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(298, 193).addBox(1.0F, -13.0F, -4.0F, 14.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 4.0F, -0.0547F, 0.3006F, 0.1662F));

		PartDefinition cube_r26 = Leftarm.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(288, 272).addBox(-15.0F, 4.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.75F, 27.5F, -1.5628F, -0.3299F, 2.9318F));

		PartDefinition cube_r27 = Leftarm.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(288, 272).addBox(-12.0F, -11.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.7866F, -0.0621F, -3.7606F, 1.1231F, 0.1582F, 2.7962F));

		PartDefinition cube_r28 = Leftarm.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(288, 272).mirror().addBox(-15.0F, -26.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 6.25F, 6.25F, -0.6033F, -0.0627F, 0.2067F));

		PartDefinition cube_r29 = Leftarm.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(196, 0).addBox(-4.0F, -11.0F, -8.0F, 17.0F, 16.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 4.0F, 0.0F, -0.2618F, 0.3491F));

		PartDefinition Root3 = Leftarm.addOrReplaceChild("Root3", CubeListBuilder.create(), PartPose.offsetAndRotation(12.6297F, 5.5944F, -2.0F, -0.2132F, 0.3799F, 0.9216F));

		PartDefinition R3Seg1 = Root3.addOrReplaceChild("R3Seg1", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.4334F, 0.3528F, -0.4797F));

		PartDefinition RootSeg_r1 = R3Seg1.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg2 = R3Seg1.addOrReplaceChild("R3Seg2", CubeListBuilder.create().texOffs(298, 253).addBox(-1.125F, -0.625F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition R3Seg3 = R3Seg2.addOrReplaceChild("R3Seg3", CubeListBuilder.create().texOffs(164, 322).addBox(-0.125F, -0.625F, -0.375F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg = R3Seg3.addOrReplaceChild("RootSeg", CubeListBuilder.create().texOffs(164, 324).addBox(0.125F, -0.4806F, -0.125F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Root4 = Leftarm.addOrReplaceChild("Root4", CubeListBuilder.create().texOffs(402, 60).addBox(0.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6297F, 5.5944F, -2.0F, 0.6158F, 0.3799F, 0.9216F));

		PartDefinition R3Seg13 = Root4.addOrReplaceChild("R3Seg13", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, -0.6271F, 0.537F, -0.2089F));

		PartDefinition RootSeg_r2 = R3Seg13.addOrReplaceChild("RootSeg_r2", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -3.1067F, -0.0217F, -3.1273F));

		PartDefinition R3Seg14 = R3Seg13.addOrReplaceChild("R3Seg14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition RootSeg_r3 = R3Seg14.addOrReplaceChild("RootSeg_r3", CubeListBuilder.create().texOffs(298, 253).addBox(-1.625F, -1.125F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.5F, 0.5F, 0.0F, -0.041F, -0.0022F, 0.0147F));

		PartDefinition R3Seg15 = R3Seg14.addOrReplaceChild("R3Seg15", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg_r4 = R3Seg15.addOrReplaceChild("RootSeg_r4", CubeListBuilder.create().texOffs(164, 322).addBox(0.125F, 0.125F, -0.125F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.75F, -0.25F, -0.0366F, 0.0186F, 0.0144F));

		PartDefinition RootSeg2 = R3Seg15.addOrReplaceChild("RootSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Root5 = Leftarm.addOrReplaceChild("Root5", CubeListBuilder.create().texOffs(402, 60).addBox(0.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1297F, 5.5944F, 8.0F, -1.27F, -0.1712F, -0.0025F));

		PartDefinition R3Seg16 = Root5.addOrReplaceChild("R3Seg16", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.4334F, 0.3528F, -0.4797F));

		PartDefinition RootSeg_r5 = R3Seg16.addOrReplaceChild("RootSeg_r5", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg17 = R3Seg16.addOrReplaceChild("R3Seg17", CubeListBuilder.create().texOffs(298, 253).addBox(-1.125F, -0.625F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition R3Seg18 = R3Seg17.addOrReplaceChild("R3Seg18", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg3 = R3Seg18.addOrReplaceChild("RootSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Lowersegleftarm = Leftarm.addOrReplaceChild("Lowersegleftarm", CubeListBuilder.create().texOffs(290, 206).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.829F));

		PartDefinition cube_r30 = Lowersegleftarm.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(190, 360).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r31 = Lowersegleftarm.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(286, 96).addBox(22.0F, -5.0F, -2.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 6.0F, -0.1276F, 0.1096F, 0.1206F));

		PartDefinition cube_r32 = Lowersegleftarm.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(230, 75).addBox(-22.0F, -7.0F, -5.0F, 23.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 3.0F, 0.0F, 0.7933F, -0.2241F, -0.1629F));

		PartDefinition cube_r33 = Lowersegleftarm.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(264, 57).addBox(-20.0F, -4.0F, -7.0F, 21.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 0.0F, 0.0F, -0.4557F, -0.2173F, 0.0894F));

		PartDefinition Infectedarm37 = Lowersegleftarm.addOrReplaceChild("Infectedarm37", CubeListBuilder.create().texOffs(410, 291).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -6.0F, -7.0F, -1.0007F, -0.6178F, -1.7502F));

		PartDefinition Infectedarm38 = Infectedarm37.addOrReplaceChild("Infectedarm38", CubeListBuilder.create().texOffs(80, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm39 = Infectedarm38.addOrReplaceChild("Infectedarm39", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm40 = Infectedarm38.addOrReplaceChild("Infectedarm40", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1074F, 0.0749F, 0.6068F));

		PartDefinition bloom3 = Lowersegleftarm.addOrReplaceChild("bloom3", CubeListBuilder.create(), PartPose.offsetAndRotation(39.0F, 6.0F, -4.0F, 0.7418F, 0.0F, 2.9234F));

		PartDefinition cube_r34 = bloom3.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r35 = bloom3.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r36 = bloom3.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(264, 0).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r37 = bloom3.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(64, 262).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r38 = bloom3.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r39 = bloom3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 258).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm33 = Lowersegleftarm.addOrReplaceChild("Infectedarm33", CubeListBuilder.create().texOffs(410, 255).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, 5.0F, -11.0F, -0.8771F, 0.573F, -0.5364F));

		PartDefinition Infectedarm34 = Infectedarm33.addOrReplaceChild("Infectedarm34", CubeListBuilder.create().texOffs(64, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5144F, 0.2507F, -0.4137F));

		PartDefinition Infectedarm36 = Infectedarm34.addOrReplaceChild("Infectedarm36", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm35 = Infectedarm34.addOrReplaceChild("Infectedarm35", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1005F, -0.084F, -0.6939F));

		PartDefinition bloom4 = Lowersegleftarm.addOrReplaceChild("bloom4", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, -7.0F, 6.0F, -0.4702F, 0.1001F, 0.1942F));

		PartDefinition cube_r40 = bloom4.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r41 = bloom4.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r42 = bloom4.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(252, 256).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r43 = bloom4.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r44 = bloom4.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r45 = bloom4.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm41 = Lowersegleftarm.addOrReplaceChild("Infectedarm41", CubeListBuilder.create().texOffs(410, 301).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 3.0F, 8.0F, 1.0649F, 0.3082F, -1.1264F));

		PartDefinition Infectedarm42 = Infectedarm41.addOrReplaceChild("Infectedarm42", CubeListBuilder.create().texOffs(96, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition Infectedarm43 = Infectedarm42.addOrReplaceChild("Infectedarm43", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Infectedarm44 = Infectedarm42.addOrReplaceChild("Infectedarm44", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition BladeArmTumor = Lowersegleftarm.addOrReplaceChild("BladeArmTumor", CubeListBuilder.create().texOffs(146, 206).addBox(2.0F, -5.0F, -6.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 1.0F));

		PartDefinition cube_r46 = BladeArmTumor.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(238, 169).addBox(9.0F, -9.0F, -6.0F, 18.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -2.0F, 3.0F, -0.1268F, 0.023F, 0.1317F));

		PartDefinition cube_r47 = BladeArmTumor.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(62, 236).addBox(-1.9806F, -6.0397F, -3.6195F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.8698F, -0.0974F, 0.5018F));

		PartDefinition cube_r48 = BladeArmTumor.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -6.9052F, 6.1309F, -2.2528F, 0.3503F, 2.9732F));

		PartDefinition cube_r49 = BladeArmTumor.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3482F, -7.6552F, -0.8691F, 2.7144F, -0.1681F, 2.8989F));

		PartDefinition cube_r50 = BladeArmTumor.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -6.6552F, 2.1309F, -0.3145F, 1.1099F, -0.5027F));

		PartDefinition cube_r51 = BladeArmTumor.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -7.4052F, 2.1309F, -0.147F, -0.3503F, -0.1684F));

		PartDefinition cube_r52 = BladeArmTumor.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(50, 278).addBox(1.0F, -5.0F, -7.0F, 13.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -1.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r53 = BladeArmTumor.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(266, 222).addBox(-1.0F, -6.0F, -7.0F, 15.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, -0.147F, -0.3503F, -0.1684F));

		PartDefinition Evilhand = Lowersegleftarm.addOrReplaceChild("Evilhand", CubeListBuilder.create(), PartPose.offsetAndRotation(41.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition cube_r54 = Evilhand.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(320, 231).addBox(-2.0621F, -1.9472F, -7.0F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.1309F));

		PartDefinition cube_r55 = Evilhand.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(294, 169).addBox(-2.0621F, -5.9472F, -6.0F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.1F))
		.texOffs(300, 112).addBox(8.9379F, -4.9472F, -4.0F, 16.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Bigahhblade = Evilhand.addOrReplaceChild("Bigahhblade", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, -1.0F, -1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r56 = Bigahhblade.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(32, 358).addBox(8.9379F, -4.9472F, -2.0F, 6.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 56.0F, 1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r57 = Bigahhblade.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(0, 0).addBox(-18.0621F, -31.9472F, 0.0F, 54.0F, 98.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 318).addBox(8.9379F, -4.9472F, -2.0F, 10.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 39.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r58 = Bigahhblade.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(238, 193).addBox(0.9379F, -6.9472F, -2.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 20.0F, 1.0F, 0.0F, 0.0F, 1.7017F));

		PartDefinition cube_r59 = Bigahhblade.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(108, 87).addBox(15.0235F, -2.642F, -3.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(296, 74).addBox(-0.9765F, -3.642F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -6.0F, 0.0F, 0.0F, 0.0F, -1.7453F));

		PartDefinition cube_r60 = Bigahhblade.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(358, 208).addBox(-8.6418F, -3.9479F, -4.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 1.0F, 0.0F, 0.0F, 2.0071F));

		PartDefinition cube_r61 = Bigahhblade.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(236, 33).addBox(14.9379F, -6.9472F, -3.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition cube_r62 = Bigahhblade.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 98).addBox(-41.355F, -36.7225F, 0.0F, 75.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, -0.0436F, 1.309F));

		PartDefinition cube_r63 = Bigahhblade.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(316, 16).addBox(-1.355F, -5.7225F, -2.0F, 17.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition Spitter = Bigahhblade.addOrReplaceChild("Spitter", CubeListBuilder.create().texOffs(362, 30).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 10.0F, 0.0F, 0.1539F, -1.5148F, 2.641F));

		PartDefinition Infectedbody_r1 = Spitter.addOrReplaceChild("Infectedbody_r1", CubeListBuilder.create().texOffs(362, 44).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Spitterneck = Spitter.addOrReplaceChild("Spitterneck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r2 = Spitterneck.addOrReplaceChild("Infectedbody_r2", CubeListBuilder.create().texOffs(48, 369).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r3 = Spitterneck.addOrReplaceChild("Infectedbody_r3", CubeListBuilder.create().texOffs(410, 148).addBox(-2.0F, -8.0F, 1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody87 = Spitterneck.addOrReplaceChild("Infectedbody87", CubeListBuilder.create().texOffs(210, 401).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Infectedbody88 = Infectedbody87.addOrReplaceChild("Infectedbody88", CubeListBuilder.create().texOffs(410, 216).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -5.0F, 0.3867F, 0.3189F, 0.2333F));

		PartDefinition Infectedbody89 = Infectedbody88.addOrReplaceChild("Infectedbody89", CubeListBuilder.create().texOffs(306, 245).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, 0.2549F, -0.2411F));

		PartDefinition Infectedbody90 = Infectedbody87.addOrReplaceChild("Infectedbody90", CubeListBuilder.create().texOffs(220, 410).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, 0.0F, -5.0F, 0.3867F, -0.3189F, -0.2333F));

		PartDefinition Infectedbody91 = Infectedbody90.addOrReplaceChild("Infectedbody91", CubeListBuilder.create().texOffs(316, 34).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, -0.2549F, 0.2411F));

		PartDefinition Spitterhead = Spitterneck.addOrReplaceChild("Spitterhead", CubeListBuilder.create().texOffs(344, 184).addBox(-4.0F, -9.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(100, 258).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Spitterjawright = Spitterhead.addOrReplaceChild("Spitterjawright", CubeListBuilder.create().texOffs(132, 236).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(158, 340).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, 0.4363F));

		PartDefinition Lowerspitterjawrigth = Spitterjawright.addOrReplaceChild("Lowerspitterjawrigth", CubeListBuilder.create().texOffs(124, 278).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(138, 410).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, -0.1468F, -0.162F));

		PartDefinition Spitterjawleft = Spitterhead.addOrReplaceChild("Spitterjawleft", CubeListBuilder.create().texOffs(280, 309).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(302, 411).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, -0.4363F));

		PartDefinition Lowerspitterjawleft = Spitterjawleft.addOrReplaceChild("Lowerspitterjawleft", CubeListBuilder.create().texOffs(60, 342).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(182, 412).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, 0.1468F, 0.162F));

		PartDefinition Spitterarmleft = Spitter.addOrReplaceChild("Spitterarmleft", CubeListBuilder.create().texOffs(412, 10).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(180, 262).addBox(1.0F, 5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -12.0F, 2.0F, -1.8762F, 0.0F, 0.0F));

		PartDefinition Spitterarmright = Spitter.addOrReplaceChild("Spitterarmright", CubeListBuilder.create().texOffs(412, 130).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(124, 236).addBox(-1.0F, 3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -12.0F, 2.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition Spitter2 = Bigahhblade.addOrReplaceChild("Spitter2", CubeListBuilder.create().texOffs(362, 30).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 17.0F, 0.0F, 0.0754F, 1.5457F, -2.3237F));

		PartDefinition Infectedbody_r4 = Spitter2.addOrReplaceChild("Infectedbody_r4", CubeListBuilder.create().texOffs(362, 44).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Spitterneck2 = Spitter2.addOrReplaceChild("Spitterneck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r5 = Spitterneck2.addOrReplaceChild("Infectedbody_r5", CubeListBuilder.create().texOffs(48, 369).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r6 = Spitterneck2.addOrReplaceChild("Infectedbody_r6", CubeListBuilder.create().texOffs(410, 148).addBox(-2.0F, -8.0F, 1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody67 = Spitterneck2.addOrReplaceChild("Infectedbody67", CubeListBuilder.create().texOffs(210, 401).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Infectedbody69 = Infectedbody67.addOrReplaceChild("Infectedbody69", CubeListBuilder.create().texOffs(410, 216).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -5.0F, 0.3867F, 0.3189F, 0.2333F));

		PartDefinition Infectedbody101 = Infectedbody69.addOrReplaceChild("Infectedbody101", CubeListBuilder.create().texOffs(306, 245).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, 0.2549F, -0.2411F));

		PartDefinition Infectedbody102 = Infectedbody67.addOrReplaceChild("Infectedbody102", CubeListBuilder.create().texOffs(220, 410).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, 0.0F, -5.0F, 0.3867F, -0.3189F, -0.2333F));

		PartDefinition Infectedbody103 = Infectedbody102.addOrReplaceChild("Infectedbody103", CubeListBuilder.create().texOffs(316, 34).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, -0.2549F, 0.2411F));

		PartDefinition Spitterhead2 = Spitterneck2.addOrReplaceChild("Spitterhead2", CubeListBuilder.create().texOffs(344, 184).addBox(-4.0F, -9.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(100, 258).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Spitterjawright2 = Spitterhead2.addOrReplaceChild("Spitterjawright2", CubeListBuilder.create().texOffs(132, 236).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(158, 340).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, 0.4363F));

		PartDefinition Lowerspitterjawrigth2 = Spitterjawright2.addOrReplaceChild("Lowerspitterjawrigth2", CubeListBuilder.create().texOffs(124, 278).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(138, 410).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, -0.1468F, -0.162F));

		PartDefinition Spitterjawleft2 = Spitterhead2.addOrReplaceChild("Spitterjawleft2", CubeListBuilder.create().texOffs(280, 309).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(302, 411).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, -0.4363F));

		PartDefinition Lowerspitterjawleft2 = Spitterjawleft2.addOrReplaceChild("Lowerspitterjawleft2", CubeListBuilder.create().texOffs(60, 342).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(182, 412).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, 0.1468F, 0.162F));

		PartDefinition Spitterarmleft2 = Spitter2.addOrReplaceChild("Spitterarmleft2", CubeListBuilder.create().texOffs(412, 10).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(180, 262).addBox(1.0F, 5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -12.0F, 2.0F, -1.8762F, 0.0F, 0.0F));

		PartDefinition Spitterarmright2 = Spitter2.addOrReplaceChild("Spitterarmright2", CubeListBuilder.create().texOffs(412, 130).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(124, 236).addBox(-1.0F, 3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -12.0F, 2.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition Infectedbody109 = Evilshoulder.addOrReplaceChild("Infectedbody109", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -7.0F, -9.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Infectedbody_r7 = Infectedbody109.addOrReplaceChild("Infectedbody_r7", CubeListBuilder.create().texOffs(92, 410).mirror().addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -12.0F, 0.5F, -0.3527F, -0.2624F, -0.4149F));

		PartDefinition Infectedbody_r8 = Infectedbody109.addOrReplaceChild("Infectedbody_r8", CubeListBuilder.create().texOffs(220, 363).mirror().addBox(-4.0F, -5.0F, -2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.5305F, -0.3408F, 0.1556F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float tendril1Val = Mth.cos(ageInTicks/7)/6;
		float tendril2Val = Mth.sin(ageInTicks/5)/6;
		float tendril3Val = -Mth.cos(ageInTicks/5)/6;
		float tendril4Val = Mth.sin(ageInTicks/5)/5;
		animateTentacleY(R3Seg1,tendril2Val);
		animateTentacleY(R3Seg2,tendril2Val);
		animateTentacleY(R3Seg3,tendril2Val);
		animateTentacleZ(R3Seg13,tendril3Val);
		animateTentacleZ(R3Seg14,tendril3Val);
		animateTentacleZ(R3Seg15,tendril3Val);
		animateTentacleX(Root5,tendril4Val);
		animateTentacleX(R3Seg16,tendril4Val);
		animateTentacleX(R3Seg17,tendril4Val);
		animateTentacleY(Evilhand,tendril1Val);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r,float g,float b,float alpha) {
		Evilshoulder.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}