package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Volatile;
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

public class VolatileModel<T extends Volatile> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "volatilemodel"), "main");
	private final ModelPart CuntyVolatile;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftForArm;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Tumor1;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Tumor5;

	public VolatileModel(ModelPart root) {
		this.CuntyVolatile = root.getChild("CuntyVolatile");
		this.RightLeg = CuntyVolatile.getChild("Legs").getChild("RightLeg");
		this.LeftLeg = CuntyVolatile.getChild("Legs").getChild("LeftLeg");
		this.RightForLeg = RightLeg.getChild("rightForLeg");
		this.LeftForLeg = LeftLeg.getChild("leftForLeg");
		this.RightArm = CuntyVolatile.getChild("hips").getChild("LowerTorso").getChild("UpperTorso").getChild("RightArm");
		this.LeftArm = CuntyVolatile.getChild("hips").getChild("LowerTorso").getChild("UpperTorso").getChild("LeftArm");
		this.RightForArm = RightArm.getChild("RightForArm");
		this.LeftForArm = LeftArm.getChild("LeftForArm");
		this.Head = CuntyVolatile.getChild("hips").getChild("LowerTorso").getChild("UpperTorso").getChild("head");
		this.Jaw = Head.getChild("jaw");
		this.Tumor1 = CuntyVolatile.getChild("hips").getChild("LowerTorso").getChild("tumor5");
		this.Tumor2 = CuntyVolatile.getChild("hips").getChild("LowerTorso").getChild("UpperTorso").getChild("Backtumors");
		this.Tumor3 = RightForArm.getChild("tumor2");
		this.Tumor4 = LeftArm.getChild("tumor4");
		this.Tumor5 = LeftForArm.getChild("tumor3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition CuntyVolatile = partdefinition.addOrReplaceChild("CuntyVolatile", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 2.0F));

		PartDefinition Legs = CuntyVolatile.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, -1.25F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(98, 24).addBox(-2.75F, 0.0F, -2.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, -15.25F, 0.75F, -0.1331F, 0.0057F, 0.0432F));

		PartDefinition RightLegClothes_r1 = RightLeg.addOrReplaceChild("RightLegClothes_r1", CubeListBuilder.create().texOffs(72, 95).mirror().addBox(-2.5F, -4.5F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.25F, 4.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition rightlegfungus = RightLeg.addOrReplaceChild("rightlegfungus", CubeListBuilder.create(), PartPose.offset(-2.9093F, 4.4108F, 1.1525F));

		PartDefinition Fungus_r1 = rightlegfungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-8, 120).addBox(-2.5F, 1.0F, -3.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = rightlegfungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-8, 120).addBox(-3.25F, -5.0F, -4.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r3 = rightlegfungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.5F, 1.0F, -2.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(52, 91).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.25F, 6.0F, 0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Fungus_r4 = rightForLeg.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.5F, 1.0F, -7.5F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1F, 2.2F, 4.55F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(100, 0).addBox(-2.25F, 0.0F, -2.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(72, 95).addBox(-2.25F, 0.0F, -2.0F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(2.15F, -15.25F, 0.75F, -0.1331F, -0.0057F, -0.0432F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(24, 95).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 9.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.25F, 6.0F, 0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition hips = CuntyVolatile.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(32, 28).addBox(-5.0F, -6.0F, -3.5F, 10.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.25F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LowerTorso = hips.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(40, 16).addBox(-4.5F, -6.0F, -3.0F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-6.5F, -8.0F, -4.0F, 13.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -0.25F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftShoulder_r1 = UpperTorso.addOrReplaceChild("LeftShoulder_r1", CubeListBuilder.create().texOffs(0, 91).mirror().addBox(2.0F, -3.5F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5F, -6.5F, 2.0F, -1.0472F, 0.0F, 0.2182F));

		PartDefinition RightShoulder_r1 = UpperTorso.addOrReplaceChild("RightShoulder_r1", CubeListBuilder.create().texOffs(0, 91).addBox(-8.0F, -3.5F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.5F, 2.0F, -1.0472F, 0.0F, -0.2182F));

		PartDefinition RightArm = UpperTorso.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(32, 71).addBox(-4.0F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.5F, -6.5F, 0.75F, -0.3914F, 0.0334F, 0.0807F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(44, 105).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.0F, 10.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition finger = RightForArm.addOrReplaceChild("finger", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).addBox(-3.0F, 0.0F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -0.5F));

		PartDefinition finger2 = RightForArm.addOrReplaceChild("finger2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, 1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).addBox(-3.0F, 0.0F, 2.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -1.0F));

		PartDefinition finger3 = RightForArm.addOrReplaceChild("finger3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).mirror().addBox(-2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, -1.0F));

		PartDefinition tumor2 = RightForArm.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-1.0F, 3.0F, 1.25F));

		PartDefinition cube_r1 = tumor2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(20, 109).addBox(-11.0F, -26.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, 0.0F, 0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = tumor2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(20, 109).addBox(2.0F, -19.0F, 21.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, 0.0F, 0.9581F, 0.0283F, -0.1278F));

		PartDefinition LeftArm = UpperTorso.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(52, 74).addBox(-2.0F, -2.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -6.5F, 0.75F, -0.3914F, -0.0334F, -0.0807F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(58, 105).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition finger4 = LeftForArm.addOrReplaceChild("finger4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).mirror().addBox(-1.0F, 0.0F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, -0.5F));

		PartDefinition finger5 = LeftForArm.addOrReplaceChild("finger5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.0F, 1.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).mirror().addBox(-1.0F, 0.0F, 2.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.0F, 9.0F, -1.0F));

		PartDefinition finger6 = LeftForArm.addOrReplaceChild("finger6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, 0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 79).addBox(-2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 9.0F, -1.0F));

		PartDefinition tumor3 = LeftForArm.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(1.0F, 3.0F, 1.25F));

		PartDefinition cube_r3 = tumor3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(88, 113).addBox(7.0F, -26.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 28.0F, -2.0F, -0.0873F, 0.0F, -0.3927F));

		PartDefinition cube_r4 = tumor3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(88, 113).addBox(-6.0F, -19.0F, -25.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 28.0F, -2.0F, -0.9581F, 0.0283F, 0.1278F));

		PartDefinition tumor4 = LeftArm.addOrReplaceChild("tumor4", CubeListBuilder.create(), PartPose.offset(4.5F, 1.0F, 0.25F));

		PartDefinition cube_r5 = tumor4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(100, 81).addBox(-14.0F, -25.0F, -5.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(103, 82).addBox(-12.0F, -26.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = tumor4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(103, 82).addBox(1.0F, -19.0F, -25.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition head = UpperTorso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(66, 57).addBox(-4.0F, -2.0833F, -0.0833F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-4.0F, -10.0833F, -4.0833F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(66, 36).addBox(-4.0F, -2.3333F, -3.8333F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -7.4167F, -2.9167F, -0.3491F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(118, 43).addBox(-1.0F, -5.0F, -9.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(70, 24).addBox(0.0F, -3.0F, -9.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 1.9167F, 2.9167F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(92, 68).addBox(-4.0F, -3.0F, -7.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F))
		.texOffs(92, 52).addBox(-4.0F, -3.9F, -7.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, 1.9167F, 2.9167F));

		PartDefinition headwear = head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 16).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7204F, -9.2184F, -1.3745F, -0.2965F, -0.0809F, 0.3213F));

		PartDefinition hat2 = headwear.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(64, 63).addBox(-0.1047F, -3.8361F, -3.2052F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -1.0F, 2.0F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(116, 56).addBox(-0.3053F, -3.4694F, -3.5875F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(60, 52).addBox(-0.6663F, -2.5979F, -4.2198F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0833F, -3.0833F, 0.6979F, -0.0094F, -0.4374F));

		PartDefinition cube_r7 = flower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-8, 120).addBox(-0.32F, 0.0F, -3.84F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r8 = flower.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-8, 120).addBox(-8.0F, 0.0F, -3.84F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r9 = flower.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.16F, 0.0F, -7.68F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r10 = flower.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.16F, 0.0F, 0.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -6.0833F, -4.0833F, -0.262F, -0.3149F, 0.4789F));

		PartDefinition cube_r11 = flower2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-8, 120).addBox(-0.32F, 0.0F, -3.84F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r12 = flower2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-8, 120).addBox(-8.0F, 0.0F, -3.84F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r13 = flower2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.16F, 0.0F, -7.68F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r14 = flower2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.16F, 0.0F, 0.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Backtumors = UpperTorso.addOrReplaceChild("Backtumors", CubeListBuilder.create(), PartPose.offset(0.0F, -4.5F, 3.0F));

		PartDefinition cube_r15 = Backtumors.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(32, 41).addBox(-12.0F, -27.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r16 = Backtumors.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-8, 120).addBox(-2.0F, -29.0F, -3.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.1745F, -0.6109F, -0.0436F));

		PartDefinition cube_r17 = Backtumors.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-8, 120).addBox(-4.0F, -26.0F, -3.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.1745F, 0.3927F, 0.0873F));

		PartDefinition cube_r18 = Backtumors.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(35, 43).addBox(-1.0F, -21.0F, -25.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition tumor5 = LowerTorso.addOrReplaceChild("tumor5", CubeListBuilder.create(), PartPose.offset(1.0F, 0.5F, -4.25F));

		PartDefinition cube_r19 = tumor5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 79).mirror().addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.8739F, -7.9401F, -0.519F, -0.035F, 0.2595F, -1.7063F));

		PartDefinition cube_r20 = tumor5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 79).addBox(-4.5F, -29.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 17.75F, 3.0F, 0.2597F, -0.0338F, 0.1265F));

		PartDefinition cube_r21 = tumor5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(2, 81).addBox(2.0F, -20.0F, -9.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, -0.2618F, 0.0F, -0.3491F));

		PartDefinition cube_r22 = tumor5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(2, 81).addBox(1.0F, -23.0F, -8.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, -0.1309F, 0.0F, -0.2182F));

		PartDefinition LowerTorsoTumor = LowerTorso.addOrReplaceChild("LowerTorsoTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fungus_r5 = LowerTorsoTumor.addOrReplaceChild("fungus_r5", CubeListBuilder.create().texOffs(-8, 120).addBox(-5.0F, -4.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.5F, -1.25F, 0.2182F, 0.48F, -0.3927F));

		PartDefinition fungus_r6 = LowerTorsoTumor.addOrReplaceChild("fungus_r6", CubeListBuilder.create().texOffs(-8, 120).addBox(-6.0F, 4.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.5F, -1.25F, 0.3054F, 0.1309F, 0.1745F));

		PartDefinition fungus_r7 = LowerTorsoTumor.addOrReplaceChild("fungus_r7", CubeListBuilder.create().texOffs(-8, 120).addBox(-1.0F, -1.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.5F, -1.25F, 0.3054F, 0.3491F, -0.2182F));

		PartDefinition skirt = hips.addOrReplaceChild("skirt", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition SkirtSeg_r1 = skirt.addOrReplaceChild("SkirtSeg_r1", CubeListBuilder.create().texOffs(104, 12).mirror().addBox(-3.0F, -1.0F, 0.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.75F, -1.0F, 3.5F, 0.1993F, -0.2015F, 0.0886F));

		PartDefinition SkirtSeg_r2 = skirt.addOrReplaceChild("SkirtSeg_r2", CubeListBuilder.create().texOffs(102, 74).addBox(-4.0F, -1.0F, 0.0F, 10.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -1.0F, 4.0F, 0.1321F, 0.2094F, 0.0434F));

		PartDefinition SkirtSeg_r3 = skirt.addOrReplaceChild("SkirtSeg_r3", CubeListBuilder.create().texOffs(94, 97).addBox(0.0F, -4.0F, -4.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.2853F, 2.0832F, 2.4894F, 0.0732F, 0.0715F, 0.2319F));

		PartDefinition SkirtSeg_r4 = skirt.addOrReplaceChild("SkirtSeg_r4", CubeListBuilder.create().texOffs(73, 111).addBox(0.0F, -1.0F, -3.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5553F, -1.7591F, -0.7117F, -0.1029F, -0.1889F, 0.2586F));

		PartDefinition SkirtSeg_r5 = skirt.addOrReplaceChild("SkirtSeg_r5", CubeListBuilder.create().texOffs(92, 95).addBox(0.0F, -1.0F, -4.5F, 0.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5553F, -0.5091F, 0.2117F, -0.0705F, 0.0722F, -0.2771F));

		PartDefinition SkirtSeg_r6 = skirt.addOrReplaceChild("SkirtSeg_r6", CubeListBuilder.create().texOffs(93, 103).addBox(-4.0F, -1.0F, 0.0F, 7.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, -3.75F, -0.1993F, -0.2015F, -0.0886F));

		PartDefinition SkirtSeg_r7 = skirt.addOrReplaceChild("SkirtSeg_r7", CubeListBuilder.create().texOffs(102, 12).addBox(-5.0F, -1.0F, 0.0F, 9.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.25F, -0.2162F, 0.1242F, -0.0242F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			float value = Mth.sin(ageInTicks / 7) / 8;
			this.animateTentacleX(this.RightArm, -0.9f + value);
			this.animateTentacleX(this.LeftArm, -0.9f - value);
		} else{
			this.animateTentacleX(this.RightArm,Mth.sin(ageInTicks/8)/10);
			this.animateTentacleX(this.LeftArm, -Mth.sin(ageInTicks/8)/10);
		}
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.LeftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Jaw.xRot = Mth.sin(ageInTicks / 8) / 10;
		this.animateTumor(Tumor1,Mth.cos(ageInTicks/8)/10);
		this.animateTumor(Tumor2,-Mth.cos(ageInTicks/8)/8);
		this.animateTumor(Tumor3,Mth.sin(ageInTicks/7)/8);
		this.animateTumor(Tumor4,-Mth.sin(ageInTicks/8)/8);
		this.animateTumor(Tumor5,Mth.cos(ageInTicks/8)/7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		CuntyVolatile.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}