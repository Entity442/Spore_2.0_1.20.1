package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Brauerei;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BraureiModel<T extends Brauerei> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "augeo2"), "main");
	private final ModelPart Augeo;

	public BraureiModel(ModelPart root) {
		this.Augeo = root.getChild("Augeo");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Augeo = partdefinition.addOrReplaceChild("Augeo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -9.0F));

		PartDefinition TumorBase = Augeo.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(55, 55).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9764F, -5.2495F, 0.6612F, 1.0115F, -0.0632F, 0.5549F));

		PartDefinition Tumor_r2 = TumorBase.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(48, 67).addBox(4.0F, 28.0F, 3.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(34.3457F, -7.2517F, -16.1809F, 0.9972F, -0.6684F, 0.3193F));

		PartDefinition Tumor_r3 = TumorBase.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(58, 58).addBox(3.5F, 6.5F, -9.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.9307F, -3.8388F, -22.6853F, 1.8171F, -0.733F, -0.3368F));

		PartDefinition Tumor_r4 = TumorBase.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(62, 55).addBox(10.5F, 0.5F, -9.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0693F, -3.8388F, -28.6853F, -2.449F, -1.2567F, -2.2228F));

		PartDefinition Tumor_r5 = TumorBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(68, 63).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.631F, 1.0226F, 2.3293F, 2.0714F, -1.1377F, -0.6057F));

		PartDefinition Tumor_r6 = TumorBase.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(49, 50).addBox(-7.5F, -13.5F, -20.5F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.2404F, -4.5549F, 7.9732F, 0.5053F, -0.1742F, 0.5632F));

		PartDefinition Tumor_r7 = TumorBase.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(55, 63).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.5966F, -5.2553F, 3.4215F, -2.1622F, -0.7201F, 0.7744F));

		PartDefinition Tumor_r8 = TumorBase.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(53, 52).addBox(-8.0F, -7.0F, -4.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.3457F, -7.2517F, 8.1809F, -1.2438F, 0.1733F, -0.2528F));

		PartDefinition Tumor_r9 = TumorBase.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(50, 50).addBox(-4.5F, -6.5F, -7.5F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7596F, -4.5549F, 17.9732F, 1.1091F, 0.6551F, 0.7249F));

		PartDefinition Tumor_r10 = TumorBase.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(48, 49).addBox(-6.0F, -3.0F, -15.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 25.0F, -1.0942F, 0.3979F, -0.6439F));

		PartDefinition Tumor_r11 = TumorBase.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(62, 57).addBox(-3.5F, -5.5F, -2.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0693F, -3.8388F, 24.6853F, -1.5597F, 0.1074F, 0.2496F));

		PartDefinition Tumor_r12 = TumorBase.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(61, 58).addBox(-3.5F, -4.5F, -7.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0693F, -3.8388F, -22.6853F, 1.5597F, 0.1074F, -0.2496F));

		PartDefinition Tumor_r13 = TumorBase.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(50, 50).addBox(-7.5F, -9.5F, -8.5F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7596F, -4.5549F, -15.9732F, 1.1091F, 0.6551F, -0.7249F));

		PartDefinition Tumor_r14 = TumorBase.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(54, 52).addBox(-16.0F, -7.0F, -13.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.3457F, -7.2517F, -16.1809F, 1.2438F, 0.1733F, 0.2528F));

		PartDefinition Tumor_r15 = TumorBase.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(48, 49).addBox(-5.0F, -6.0F, 7.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -23.0F, 1.0942F, 0.3979F, 0.6439F));

		PartDefinition Vat = Augeo.addOrReplaceChild("Vat", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -5.0F, -16.0F, 32.0F, 1.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Rim = Vat.addOrReplaceChild("Rim", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition FrontRidge = Rim.addOrReplaceChild("FrontRidge", CubeListBuilder.create().texOffs(239, 117).addBox(-3.0F, -13.0F, -2.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, -12.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition FleshLining_r1 = FrontRidge.addOrReplaceChild("FleshLining_r1", CubeListBuilder.create().texOffs(134, 109).addBox(-14.5F, -22.0F, -2.0F, 29.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 2.75F, 0.1309F, 0.0F, 0.0F));

		PartDefinition FrontRidgeSeg2 = FrontRidge.addOrReplaceChild("FrontRidgeSeg2", CubeListBuilder.create().texOffs(223, 78).addBox(-2.99F, -15.7767F, -2.4929F, 6.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(134, 61).addBox(-14.49F, -10.5F, -2.0F, 29.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.25F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Head = FrontRidgeSeg2.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadBase_r1 = Head.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 198).addBox(-5.4062F, -2.5192F, -3.34F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.5F, 0.0F, -0.3244F, -0.1313F, -0.3712F));

		PartDefinition LeftRidge = Rim.addOrReplaceChild("LeftRidge", CubeListBuilder.create().texOffs(181, 232).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, -23.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition FleshLining_r2 = LeftRidge.addOrReplaceChild("FleshLining_r2", CubeListBuilder.create().texOffs(134, 109).addBox(-14.5F, -22.0F, -1.0F, 29.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.5F, -0.5F, 0.0F, 1.5708F, 0.1309F));

		PartDefinition LeftRidgeSeg2 = LeftRidge.addOrReplaceChild("LeftRidgeSeg2", CubeListBuilder.create().texOffs(180, 205).addBox(-1.5F, -15.0F, -3.26F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.25F, 0.0F, 0.0F, -0.4363F));

		PartDefinition FleshLining_r3 = LeftRidgeSeg2.addOrReplaceChild("FleshLining_r3", CubeListBuilder.create().texOffs(134, 61).addBox(-12.24F, -11.2823F, 1.9426F, 29.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.7823F, 1.5574F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Corpse = LeftRidgeSeg2.addOrReplaceChild("Corpse", CubeListBuilder.create().texOffs(227, 22).addBox(-6.0F, -14.0F, 0.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(226, 21).addBox(-7.0F, -20.0F, -0.5F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 10.0F, 3.75F));

		PartDefinition Jaw_r1 = Corpse.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(218, 12).addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3755F, -18.6573F, 3.5F, 0.0F, 0.1745F, 0.5672F));

		PartDefinition Head_r1 = Corpse.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(194, 13).addBox(-8.5F, -0.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2561F, -24.7682F, 3.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Arm_r1 = Corpse.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(246, 154).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -18.0F, 8.5F, 0.6109F, 0.0F, -1.0472F));

		PartDefinition HeadFugus = Corpse.addOrReplaceChild("HeadFugus", CubeListBuilder.create(), PartPose.offset(-0.7593F, -22.3094F, 4.2561F));

		PartDefinition Plane_r1 = HeadFugus.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(89, 0).mirror().addBox(-3.5F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0151F, 1.0458F, -2.5116F, 0.0804F, 0.2494F, 0.6646F));

		PartDefinition Plane_r2 = HeadFugus.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(89, 7).addBox(-3.5F, -3.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.09F, -1.4585F, -2.4676F, 0.1081F, -0.4774F, 0.5224F));

		PartDefinition Plane_r3 = HeadFugus.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(89, 14).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7407F, -2.6906F, 1.4939F, -0.3695F, 0.3272F, -0.1238F));

		PartDefinition RightRidge = Rim.addOrReplaceChild("RightRidge", CubeListBuilder.create().texOffs(181, 232).addBox(-2.0F, -13.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -23.0F, 0.0F, 0.0F, 0.0F, -0.8727F));

		PartDefinition FleshLining_r4 = RightRidge.addOrReplaceChild("FleshLining_r4", CubeListBuilder.create().texOffs(134, 109).addBox(-14.5F, -22.0F, -1.0F, 29.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.5F, -0.5F, 0.0F, -1.5708F, -0.1309F));

		PartDefinition RightRidgeSeg2 = RightRidge.addOrReplaceChild("RightRidgeSeg2", CubeListBuilder.create().texOffs(180, 205).addBox(-2.5F, -15.0F, -3.26F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.25F, 0.0F, 0.0F, 0.4363F));

		PartDefinition FleshLining_r5 = RightRidgeSeg2.addOrReplaceChild("FleshLining_r5", CubeListBuilder.create().texOffs(134, 61).addBox(-16.76F, -11.2823F, 1.9426F, 29.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.7823F, 1.5574F, 0.0F, -1.5708F, 0.0F));

		PartDefinition FungalPetals = RightRidgeSeg2.addOrReplaceChild("FungalPetals", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plane_r4 = FungalPetals.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(89, 0).addBox(-4.0F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -10.5168F, -1.18F, 0.035F, 0.2595F, 0.4845F));

		PartDefinition Plane_r5 = FungalPetals.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(89, 7).addBox(-5.0F, 6.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -13.0F, -2.0F, 0.3695F, -0.3272F, -0.1238F));

		PartDefinition Plane_r6 = FungalPetals.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(89, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -13.0F, 1.5F, -0.3695F, 0.3272F, -0.1238F));

		PartDefinition BackRidge = Rim.addOrReplaceChild("BackRidge", CubeListBuilder.create().texOffs(239, 117).addBox(-3.0F, -13.0F, -2.0F, 6.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, 12.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition FleshLining_r6 = BackRidge.addOrReplaceChild("FleshLining_r6", CubeListBuilder.create().texOffs(134, 109).addBox(-14.5F, -22.0F, -1.0F, 29.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, -2.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition BackRidgeSeg2 = BackRidge.addOrReplaceChild("BackRidgeSeg2", CubeListBuilder.create().texOffs(223, 78).addBox(-2.99F, -16.0F, -1.5F, 6.0F, 18.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(134, 61).addBox(-14.49F, -10.5F, -1.0F, 29.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -0.25F, 0.4363F, 0.0F, 0.0F));

		PartDefinition CornerRidges = Rim.addOrReplaceChild("CornerRidges", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition NWRidge = CornerRidges.addOrReplaceChild("NWRidge", CubeListBuilder.create().texOffs(222, 222).addBox(-2.99F, -27.5468F, -17.9613F, 6.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition FleshLining_r7 = NWRidge.addOrReplaceChild("FleshLining_r7", CubeListBuilder.create().texOffs(39, 111).addBox(-23.0F, -14.0F, -32.5F, 2.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.0F, -12.0F, 5.25F, 0.0F, -1.5708F, 0.0F));

		PartDefinition SWRidge = CornerRidges.addOrReplaceChild("SWRidge", CubeListBuilder.create().texOffs(32, 205).addBox(-2.1245F, -13.981F, -2.945F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(39, 111).addBox(-0.2972F, -11.8873F, -10.685F, 2.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.768F, -28.4866F, -0.065F, 0.0F, 0.0F, 0.4363F));

		PartDefinition NERidge = CornerRidges.addOrReplaceChild("NERidge", CubeListBuilder.create().texOffs(32, 205).addBox(-3.7113F, -14.5468F, -3.01F, 4.0F, 18.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(39, 111).addBox(-2.75F, -11.0F, -10.25F, 2.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.3658F, -29.9824F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition SERidge = CornerRidges.addOrReplaceChild("SERidge", CubeListBuilder.create().texOffs(222, 222).addBox(-2.62F, -15.7143F, -1.4961F, 6.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.37F, -27.7646F, 19.5284F, -0.4363F, 0.0F, 0.0F));

		PartDefinition FleshLining_r8 = SERidge.addOrReplaceChild("FleshLining_r8", CubeListBuilder.create().texOffs(39, 111).addBox(-22.5F, -13.0F, -33.25F, 2.0F, 12.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.37F, 0.3794F, -20.4188F, 0.0F, 1.5708F, 0.0F));

		PartDefinition SERidgeSeg2 = SERidge.addOrReplaceChild("SERidgeSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.37F, 0.3794F, 0.0812F, 0.4363F, 0.0F, 0.0F));

		PartDefinition FallingCorpse = SERidge.addOrReplaceChild("FallingCorpse", CubeListBuilder.create().texOffs(238, 240).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(234, 0).addBox(-4.0F, 3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -10.0F, -2.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Leg_r1 = FallingCorpse.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(0, 245).addBox(-5.25F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -3.0F, 0.0F, -0.6077F, -0.2602F, -0.3543F));

		PartDefinition Leg_r2 = FallingCorpse.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(0, 245).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -3.0F, 0.0F, -1.3347F, 0.4205F, -0.1201F));

		PartDefinition VatJuice = Rim.addOrReplaceChild("VatJuice", CubeListBuilder.create().texOffs(-46, 258).addBox(-14.0F, -1.0F, -23.0F, 28.0F, 0.0F, 46.0F, new CubeDeformation(0.0F))
		.texOffs(-13, 258).addBox(-18.0F, -1.0F, -21.0F, 4.0F, 0.0F, 37.0F, new CubeDeformation(0.0F))
		.texOffs(-5, 258).addBox(-22.0F, -1.0F, -14.75F, 4.0F, 0.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(3, 258).addBox(-24.0F, -1.0F, -12.75F, 2.0F, 0.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(-15, 258).mirror().addBox(14.0F, -1.0F, -21.0F, 4.0F, 0.0F, 39.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-7, 268).mirror().addBox(18.0F, -1.0F, -15.75F, 4.0F, 0.0F, 31.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(-1, 258).mirror().addBox(22.0F, -1.0F, -13.75F, 2.0F, 0.0F, 27.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -34.0F, 0.0F));

		PartDefinition Shelf1 = Vat.addOrReplaceChild("Shelf1", CubeListBuilder.create().texOffs(48, 33).addBox(-9.0F, -1.0F, -9.0F, 18.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(58, 38).addBox(-7.0F, -1.0F, -14.0F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, -7.0F, -19.75F, -0.2852F, -0.5364F, -0.1032F));

		PartDefinition ShelfWall5_r1 = Shelf1.addOrReplaceChild("ShelfWall5_r1", CubeListBuilder.create().texOffs(231, 132).addBox(-6.0F, -6.5F, -1.0F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2685F, 0.4841F, -13.8205F, 0.6109F, 0.0F, 0.0F));

		PartDefinition ShelfWall4_r1 = Shelf1.addOrReplaceChild("ShelfWall4_r1", CubeListBuilder.create().texOffs(93, 208).addBox(-1.0F, -3.5F, -5.0F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9657F, -1.5618F, -11.5514F, 0.5236F, -0.4363F, -0.6545F));

		PartDefinition ShelfWall3_r1 = Shelf1.addOrReplaceChild("ShelfWall3_r1", CubeListBuilder.create().texOffs(93, 208).addBox(0.25F, -3.5F, -5.0F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4815F, -2.5159F, -9.8205F, 0.5236F, 0.4363F, 0.6545F));

		PartDefinition ShelfWall2_r1 = Shelf1.addOrReplaceChild("ShelfWall2_r1", CubeListBuilder.create().texOffs(92, 208).addBox(30.5F, -33.5F, -5.01F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-33.5F, 1.5F, -4.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition ShelfWall1_r1 = Shelf1.addOrReplaceChild("ShelfWall1_r1", CubeListBuilder.create().texOffs(92, 208).addBox(1.5F, -6.5F, -5.01F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.5F, 1.5F, -4.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition ShelfJuice = Shelf1.addOrReplaceChild("ShelfJuice", CubeListBuilder.create().texOffs(3, 258).addBox(-10.0F, -4.9F, -10.0F, 19.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(10, 260).addBox(-6.75F, -4.9F, -14.0F, 14.0F, 0.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 260).addBox(-2.0F, -4.9F, -4.0F, 11.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -1.0F, 0.0F, 0.2852F, 0.0F, 0.1047F));

		PartDefinition Shelf2 = Vat.addOrReplaceChild("Shelf2", CubeListBuilder.create().texOffs(51, 36).addBox(-9.4124F, 0.4126F, -6.7088F, 18.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(56, 36).addBox(-7.4124F, 0.4126F, 0.2912F, 14.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7638F, -5.372F, 22.347F, -0.2783F, -0.4945F, -0.1171F));

		PartDefinition ShelfWall5_r2 = Shelf2.addOrReplaceChild("ShelfWall5_r2", CubeListBuilder.create().texOffs(231, 132).addBox(-6.0F, -6.5F, -1.0F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.856F, 1.8967F, 5.1118F, -0.6109F, 0.0F, 0.0F));

		PartDefinition ShelfWall4_r2 = Shelf2.addOrReplaceChild("ShelfWall4_r2", CubeListBuilder.create().texOffs(93, 208).addBox(29.75F, 12.5F, 23.0F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-51.894F, -1.1033F, 1.1118F, -0.5236F, 0.4363F, -0.6545F));

		PartDefinition ShelfWall3_r2 = Shelf2.addOrReplaceChild("ShelfWall3_r2", CubeListBuilder.create().texOffs(93, 208).addBox(0.25F, -3.5F, -5.0F, 2.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0691F, -1.1033F, 1.1118F, -0.5236F, -0.4363F, 0.6545F));

		PartDefinition ShelfWall2_r2 = Shelf2.addOrReplaceChild("ShelfWall2_r2", CubeListBuilder.create().texOffs(97, 213).addBox(30.5F, -33.5F, 0.01F, 3.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-33.9124F, 2.9126F, -4.7088F, 0.0F, 0.0F, 0.6545F));

		PartDefinition ShelfWall1_r2 = Shelf2.addOrReplaceChild("ShelfWall1_r2", CubeListBuilder.create().texOffs(92, 208).addBox(1.5F, -6.5F, -4.99F, 3.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.9124F, 2.9126F, -4.7088F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Shelf2Juice = Shelf2.addOrReplaceChild("Shelf2Juice", CubeListBuilder.create().texOffs(6, 258).addBox(-2.8184F, 0.235F, -4.4003F, 11.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(15, 260).addBox(-4.3184F, 0.234F, -5.4003F, 2.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(18, 270).addBox(-6.3184F, 0.234F, -5.4003F, 2.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1118F, -0.7016F, 1.5909F, 0.2783F, 0.0F, 0.1222F));

		PartDefinition Chef = Augeo.addOrReplaceChild("Chef", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -2.0F, 23.0F, 0.0F, 0.2182F, 0.0F));

		PartDefinition BiomassBase = Chef.addOrReplaceChild("BiomassBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition Biomass_r1 = BiomassBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(60, 57).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1551F, -1.9228F, 0.582F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = BiomassBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(66, 55).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.038F, -1.586F, 8.47F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = BiomassBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(64, 54).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5798F, -0.1648F, -4.638F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = BiomassBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(64, 58).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3366F, -2.6455F, -0.5176F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r5 = BiomassBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(56, 55).addBox(-11.0F, 6.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.1706F, -0.1996F, 0.7153F));

		PartDefinition Body1 = Chef.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(42, 240).addBox(-2.0802F, -5.1943F, -2.2372F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9198F, -0.7679F, 5.3403F, -0.6109F, 0.0F, 0.0F));

		PartDefinition Arm_r2 = Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(0, 245).addBox(-3.7909F, 0.5332F, 52.3101F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0802F, -2.1651F, -53.4788F, 0.1739F, -0.0151F, 0.0859F));

		PartDefinition Robe_r1 = Body1.addOrReplaceChild("Robe_r1", CubeListBuilder.create().texOffs(87, 225).addBox(-4.0F, -22.5388F, 49.9544F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.1F))
		.texOffs(46, 229).addBox(-4.0F, -22.5388F, 49.9544F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4198F, 1.9847F, -54.7667F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Body1Head = Body1.addOrReplaceChild("Body1Head", CubeListBuilder.create().texOffs(174, 189).addBox(-3.9171F, -10.1097F, -2.6771F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3369F, -9.3126F, 1.3381F, 0.455F, 0.19F, -0.7676F));

		PartDefinition Jaw_r2 = Body1Head.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(216, 209).addBox(-1.2505F, -46.0534F, 30.4267F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0829F, 34.2436F, -43.8095F, -0.2628F, -0.0843F, 0.0226F));

		PartDefinition LilWart_r1 = Body1Head.addOrReplaceChild("LilWart_r1", CubeListBuilder.create().texOffs(28, 6).addBox(2.6895F, -26.2647F, 49.4314F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(123, 94).addBox(2.5895F, -28.2647F, 47.6314F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0829F, 32.2436F, -36.8095F, 0.1731F, 0.0227F, -0.1289F));

		PartDefinition Hat = Body1Head.addOrReplaceChild("Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-5.0F, -37.3533F, 37.1324F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0829F, 25.2436F, -40.8095F));

		PartDefinition Seg4_r1 = Hat.addOrReplaceChild("Seg4_r1", CubeListBuilder.create().texOffs(188, 55).addBox(-1.5F, -55.464F, 19.2853F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.6313F, -1.1216F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Seg3_r1 = Hat.addOrReplaceChild("Seg3_r1", CubeListBuilder.create().texOffs(59, 245).addBox(-2.5F, -50.0365F, 27.0515F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.25F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Seg2_r1 = Hat.addOrReplaceChild("Seg2_r1", CubeListBuilder.create().texOffs(148, 204).addBox(-4.0F, -42.3909F, 34.8909F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition B2HFungus2 = Body1Head.addOrReplaceChild("B2HFungus2", CubeListBuilder.create(), PartPose.offset(0.0926F, -7.2169F, 3.9611F));

		PartDefinition Plane_r7 = B2HFungus2.addOrReplaceChild("Plane_r7", CubeListBuilder.create().texOffs(89, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8183F, -0.266F, -5.8336F, 0.7933F, -0.8795F, -0.2608F));

		PartDefinition Plane_r8 = B2HFungus2.addOrReplaceChild("Plane_r8", CubeListBuilder.create().texOffs(89, 7).addBox(-1.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8456F, -6.858F, -3.2662F, 0.1147F, -0.4108F, -0.2878F));

		PartDefinition Plane_r9 = B2HFungus2.addOrReplaceChild("Plane_r9", CubeListBuilder.create().texOffs(89, 0).addBox(-1.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, -0.2747F, -0.158F, -0.4422F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4231F, -9.7068F, -0.1365F, 0.0F, 0.0F, 0.0F));

		PartDefinition Robe_r2 = Body2.addOrReplaceChild("Robe_r2", CubeListBuilder.create().texOffs(87, 225).addBox(-4.0F, -3.5F, -2.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0067F, -7.2064F, -1.4443F, -0.1745F, 0.0F, 0.0F));

		PartDefinition TorsoTop_r1 = Body2.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(46, 229).addBox(-4.0F, -10.8006F, 50.6644F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0033F, -9.2486F, -55.0688F, -0.1745F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r1 = Body2.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(42, 240).addBox(-3.0F, 15.0476F, 49.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5033F, -0.2486F, -55.0688F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body2Head = Body2.addOrReplaceChild("Body2Head", CubeListBuilder.create().texOffs(174, 189).addBox(-7.5634F, -8.058F, 1.3813F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F))
		.texOffs(28, 6).addBox(-4.4634F, -0.058F, 11.1813F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(123, 94).addBox(-4.5634F, -2.058F, 9.3813F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offset(4.0064F, -14.8227F, -2.5642F));

		PartDefinition Body2Hat = Body2Head.addOrReplaceChild("Body2Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-56.8516F, -11.256F, 2.6581F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offset(48.2882F, 1.698F, -2.2768F));

		PartDefinition Seg4_r2 = Body2Hat.addOrReplaceChild("Seg4_r2", CubeListBuilder.create().texOffs(188, 55).addBox(-53.3516F, -21.6405F, -2.4337F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Seg3_r2 = Body2Hat.addOrReplaceChild("Seg3_r2", CubeListBuilder.create().texOffs(59, 245).addBox(-54.3516F, -21.9597F, -1.4193F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.3813F, 1.1216F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Seg2_r2 = Body2Hat.addOrReplaceChild("Seg2_r2", CubeListBuilder.create().texOffs(148, 204).addBox(-55.8516F, -21.1418F, 1.018F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 6.1313F, 1.1216F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head2Jaw = Body2Head.addOrReplaceChild("Head2Jaw", CubeListBuilder.create().texOffs(216, 209).addBox(-55.8516F, -19.3097F, 0.0807F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(48.2882F, 18.0793F, -4.1552F, -0.3054F, 0.0F, 0.0F));

		PartDefinition B2HFungus = Body2Head.addOrReplaceChild("B2HFungus", CubeListBuilder.create(), PartPose.offset(-3.0F, -4.0F, 7.0F));

		PartDefinition Plane_r10 = B2HFungus.addOrReplaceChild("Plane_r10", CubeListBuilder.create().texOffs(89, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8183F, -0.266F, -5.8336F, 0.7933F, -0.8795F, -0.2608F));

		PartDefinition Plane_r11 = B2HFungus.addOrReplaceChild("Plane_r11", CubeListBuilder.create().texOffs(89, 7).addBox(-4.25F, 0.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0395F, -0.3111F, 1.1942F, -0.315F, -0.0878F, 0.032F));

		PartDefinition Plane_r12 = B2HFungus.addOrReplaceChild("Plane_r12", CubeListBuilder.create().texOffs(89, 0).addBox(-1.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8456F, -6.858F, -3.2662F, 0.1147F, -0.4108F, -0.2878F));

		PartDefinition Plane_r13 = B2HFungus.addOrReplaceChild("Plane_r13", CubeListBuilder.create().texOffs(89, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3265F, -0.81F, -2.8293F, -0.6841F, -0.2209F, 0.1827F));

		PartDefinition Plane_r14 = B2HFungus.addOrReplaceChild("Plane_r14", CubeListBuilder.create().texOffs(89, 14).addBox(-1.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, -0.2747F, -0.158F, -0.4422F));

		PartDefinition Body3 = Body2.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(0, 245).addBox(-6.5025F, -9.8855F, -6.6117F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5008F, -9.3261F, -1.1432F));

		PartDefinition Robe_r3 = Body3.addOrReplaceChild("Robe_r3", CubeListBuilder.create().texOffs(87, 225).addBox(-4.0F, -4.5F, -2.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5075F, -6.8441F, -3.7701F, 2.3998F, 0.0F, 3.1416F));

		PartDefinition TorsoTop_r2 = Body3.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(46, 229).addBox(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4975F, -6.95F, -3.7835F, 0.7418F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r2 = Body3.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(42, 240).addBox(-3.0F, 18.0476F, 45.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9975F, -3.9225F, -52.9256F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9975F, -12.4493F, -9.0606F, 0.5672F, 0.0873F, -0.1309F));

		PartDefinition Body4_1 = Body4.addOrReplaceChild("Body4_1", CubeListBuilder.create().texOffs(237, 65).mirror().addBox(-2.0F, -5.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 4.0F, 1.0F));

		PartDefinition TorsoTop_r3 = Body4_1.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(226, 35).addBox(-2.5F, -4.75F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.5F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Body4_2Head = Body4_1.addOrReplaceChild("Body4_2Head", CubeListBuilder.create().texOffs(100, 192).addBox(-4.0833F, -9.6577F, -5.2695F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 6).addBox(-0.3333F, -2.5577F, -7.5195F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 0).addBox(-1.0833F, -4.5577F, -6.8695F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.7408F, -6.4251F, -0.6123F, 3.1416F, 1.1781F, 3.0543F));

		PartDefinition FungalPlane_r1 = Body4_2Head.addOrReplaceChild("FungalPlane_r1", CubeListBuilder.create().texOffs(89, 7).addBox(-1.5F, 0.0F, 0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -5.0F, -6.5F, -0.1309F, 0.4363F, -0.3054F));

		PartDefinition Body4_2Hat = Body4_2Head.addOrReplaceChild("Body4_2Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-55.4636F, 9.7793F, -26.2163F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offset(50.6806F, -20.6888F, 19.6879F));

		PartDefinition Seg4_r3 = Body4_2Hat.addOrReplaceChild("Seg4_r3", CubeListBuilder.create().texOffs(188, 55).addBox(-52.634F, 15.3546F, 21.3391F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6704F, -0.0507F, -51.0264F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Seg3_r3 = Body4_2Hat.addOrReplaceChild("Seg3_r3", CubeListBuilder.create().texOffs(59, 245).addBox(-53.634F, 9.4173F, 25.8127F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6704F, 3.3305F, -52.148F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Seg2_r3 = Body4_2Hat.addOrReplaceChild("Seg2_r3", CubeListBuilder.create().texOffs(148, 204).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-50.4636F, 8.535F, -21.3471F, -0.0873F, 3.1416F, 0.0F));

		PartDefinition Head4_2Jaw = Body4_2Head.addOrReplaceChild("Head4_2Jaw", CubeListBuilder.create().texOffs(216, 209).addBox(-3.3296F, -1.0507F, -7.4919F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.7537F, -1.0069F, 2.2224F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Tumor_r16 = Head4_2Jaw.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(36, 69).addBox(-2.5F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0779F, -1.7744F, -5.63F, -0.842F, 0.5621F, -0.8909F));

		PartDefinition Tumor_r17 = Head4_2Jaw.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(36, 75).addBox(1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.5209F, -1.5574F, -3.2648F, -0.5744F, 0.1796F, 0.0508F));

		PartDefinition Tumor_r18 = Head4_2Jaw.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(32, 65).addBox(-1.5F, -2.5F, 0.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.5F, -5.5F, -0.4363F, 0.0F, -0.3491F));

		PartDefinition Body4_2 = Body4.addOrReplaceChild("Body4_2", CubeListBuilder.create().texOffs(237, 65).addBox(-2.0F, -5.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 4.0F, 1.0F));

		PartDefinition Arm_r3 = Body4_2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(0, 245).addBox(-2.0F, -1.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 245).addBox(-2.0F, -0.5F, -13.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, 4.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition TorsoTop_r4 = Body4_2.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(226, 35).mirror().addBox(-2.5F, -4.75F, -3.99F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -5.0F, -0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition Body4_1Head = Body4_2.addOrReplaceChild("Body4_1Head", CubeListBuilder.create().texOffs(174, 189).addBox(-3.8667F, -8.8333F, -0.7667F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 6).addBox(-0.7667F, -0.8333F, 8.4333F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 0).addBox(-0.8667F, -2.8333F, 6.8333F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4484F, -9.6828F, 0.692F, 0.0F, 1.5708F, 1.0908F));

		PartDefinition Body4_1Hat = Body4_1Head.addOrReplaceChild("Body4_1Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-56.8516F, -11.256F, 2.6581F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offset(51.9849F, 0.9227F, -4.4248F));

		PartDefinition Seg4_r4 = Body4_1Hat.addOrReplaceChild("Seg4_r4", CubeListBuilder.create().texOffs(188, 55).addBox(-53.3516F, -21.6405F, -2.4337F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Seg3_r4 = Body4_1Hat.addOrReplaceChild("Seg3_r4", CubeListBuilder.create().texOffs(59, 245).addBox(-54.3516F, -21.9597F, -1.4193F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.3813F, 1.1216F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Seg2_r4 = Body4_1Hat.addOrReplaceChild("Seg2_r4", CubeListBuilder.create().texOffs(148, 204).addBox(-55.8516F, -21.1418F, 1.018F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 6.1313F, 1.1216F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Head4_1Jaw = Body4_1Head.addOrReplaceChild("Head4_1Jaw", CubeListBuilder.create().texOffs(216, 209).addBox(-4.0F, 0.0053F, -0.8374F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.1333F, -1.2812F, 0.0945F, -0.0436F, 0.0F, 0.0F));

		PartDefinition B4_1HeadFungus = Body4_1Head.addOrReplaceChild("B4_1HeadFungus", CubeListBuilder.create(), PartPose.offset(-0.4484F, -4.8172F, 2.808F));

		PartDefinition Plane_r15 = B4_1HeadFungus.addOrReplaceChild("Plane_r15", CubeListBuilder.create().texOffs(89, 14).addBox(-4.5F, 0.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7586F, -0.0708F, 0.5294F, 0.1809F, -0.7803F, -0.2266F));

		PartDefinition Plane_r16 = B4_1HeadFungus.addOrReplaceChild("Plane_r16", CubeListBuilder.create().texOffs(89, 0).addBox(-5.5F, 2.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7435F, -0.1183F, 0.6834F, 0.3074F, 0.4585F, -0.1806F));

		PartDefinition Plane_r17 = B4_1HeadFungus.addOrReplaceChild("Plane_r17", CubeListBuilder.create().texOffs(89, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1281F, -1.9025F, 3.051F, 0.228F, 0.5498F, 0.1008F));

		PartDefinition Body5 = Body4.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(42, 240).addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition Robe_r4 = Body5.addOrReplaceChild("Robe_r4", CubeListBuilder.create().texOffs(87, 225).addBox(-4.0F, -4.5F, -2.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -6.4387F, -0.3438F, 2.618F, 0.0F, 3.1416F));

		PartDefinition TorsoTop_r5 = Body5.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(46, 229).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Body6 = Body5.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(42, 240).addBox(-3.8659F, -5.0472F, -2.6809F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1104F, -9.6658F, -2.0729F, 1.2217F, 0.0F, -0.2618F));

		PartDefinition Arm_r4 = Body6.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(0, 245).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3387F, -5.1019F, -0.9469F, -1.3011F, -0.1735F, 0.0101F));

		PartDefinition Robe_r5 = Body6.addOrReplaceChild("Robe_r5", CubeListBuilder.create().texOffs(87, 225).addBox(-4.0F, -4.5F, -2.5F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.616F, -6.5972F, 0.3156F, -2.8362F, 0.0F, 3.1416F));

		PartDefinition TorsoTop_r6 = Body6.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(46, 229).addBox(-1.0167F, -7.1827F, -2.8839F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3492F, -3.8644F, -0.297F, -0.3054F, 0.0F, 0.0F));

		PartDefinition TorsoBaseRobe_r1 = Body6.addOrReplaceChild("TorsoBaseRobe_r1", CubeListBuilder.create().texOffs(89, 229).mirror().addBox(-3.5F, -3.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-0.3659F, -2.0472F, -0.6809F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Body6Heads = Body6.addOrReplaceChild("Body6Heads", CubeListBuilder.create(), PartPose.offsetAndRotation(1.8896F, -9.8342F, -1.9271F, -1.2217F, 0.0F, 0.0F));

		PartDefinition Body6Head1 = Body6Heads.addOrReplaceChild("Body6Head1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -1.0F, 0.5F, 0.0F, -0.2182F, 0.6981F));

		PartDefinition HeadBase_r2 = Body6Head1.addOrReplaceChild("HeadBase_r2", CubeListBuilder.create().texOffs(174, 189).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, -4.5F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Body3Head1Hat = Body6Head1.addOrReplaceChild("Body3Head1Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-4.7979F, 5.876F, -5.7722F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.7979F, -15.876F, 0.2722F));

		PartDefinition Seg4_r5 = Body3Head1Hat.addOrReplaceChild("Seg4_r5", CubeListBuilder.create().texOffs(188, 55).addBox(-0.5479F, -2.624F, -2.0222F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Seg3_r5 = Body3Head1Hat.addOrReplaceChild("Seg3_r5", CubeListBuilder.create().texOffs(59, 245).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6454F, 2.0065F, -0.7722F, 0.0F, 3.1416F, 0.3054F));

		PartDefinition Seg2_r5 = Body3Head1Hat.addOrReplaceChild("Seg2_r5", CubeListBuilder.create().texOffs(148, 204).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.3107F, 4.8984F, -0.7722F, 0.0F, 3.1416F, 0.0873F));

		PartDefinition Body3Head1Nose = Body6Head1.addOrReplaceChild("Body3Head1Nose", CubeListBuilder.create().texOffs(0, 0).addBox(-0.7979F, -1.4053F, -1.2506F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 6).addBox(0.0021F, 0.4947F, -1.8506F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.7979F, -0.9947F, -4.8494F, 0.0F, 0.0F, -0.6109F));

		PartDefinition B6H1HeadFungus = Body6Head1.addOrReplaceChild("B6H1HeadFungus", CubeListBuilder.create(), PartPose.offset(2.0F, -5.0F, 0.0F));

		PartDefinition Plane_r18 = B6H1HeadFungus.addOrReplaceChild("Plane_r18", CubeListBuilder.create().texOffs(89, 14).addBox(-4.5F, 0.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7586F, -0.0708F, 0.5294F, -0.0927F, -0.6196F, 0.2394F));

		PartDefinition Plane_r19 = B6H1HeadFungus.addOrReplaceChild("Plane_r19", CubeListBuilder.create().texOffs(89, 0).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7435F, -0.1183F, -0.3166F, 0.3074F, 0.4585F, -0.1806F));

		PartDefinition Plane_r20 = B6H1HeadFungus.addOrReplaceChild("Plane_r20", CubeListBuilder.create().texOffs(89, 7).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3844F, 0.0F, 3.612F, 0.3257F, 0.5019F, 0.295F));

		PartDefinition Body6Head2 = Body6Heads.addOrReplaceChild("Body6Head2", CubeListBuilder.create().texOffs(100, 192).addBox(-3.0F, -8.5F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F))
		.texOffs(4, 6).addBox(0.8F, -1.0F, -6.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 0).addBox(0.0F, -2.9F, -6.1F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.0F, 1.0F, -2.5F, 0.2182F, 0.0F, -0.2618F));

		PartDefinition Body6Head2Hat = Body6Head2.addOrReplaceChild("Body6Head2Hat", CubeListBuilder.create().texOffs(176, 158).addBox(-4.7979F, 5.876F, -5.7722F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.7979F, -15.876F, 0.2722F));

		PartDefinition Seg3_r6 = Body6Head2Hat.addOrReplaceChild("Seg3_r6", CubeListBuilder.create().texOffs(188, 55).addBox(-1.2979F, -3.124F, -3.0222F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Seg2_r6 = Body6Head2Hat.addOrReplaceChild("Seg2_r6", CubeListBuilder.create().texOffs(59, 245).mirror().addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.2021F, 1.8406F, -1.241F, -0.3054F, 3.1416F, 0.0F));

		PartDefinition Seg1_r1 = Body6Head2Hat.addOrReplaceChild("Seg1_r1", CubeListBuilder.create().texOffs(148, 204).addBox(-3.7979F, -3.2553F, -3.6506F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 6.1313F, -1.1216F, 0.0873F, 0.0F, 0.0F));

		PartDefinition B6H2HeadFungus = Body6Head2.addOrReplaceChild("B6H2HeadFungus", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition Plane_r21 = B6H2HeadFungus.addOrReplaceChild("Plane_r21", CubeListBuilder.create().texOffs(89, 14).addBox(-4.5F, 0.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7586F, -0.0708F, 0.5294F, -0.0927F, -0.6196F, 0.2394F));

		PartDefinition Plane_r22 = B6H2HeadFungus.addOrReplaceChild("Plane_r22", CubeListBuilder.create().texOffs(89, 7).addBox(-9.5F, 0.0F, -9.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7435F, -0.1183F, -0.3166F, 0.3074F, 0.4585F, -0.1806F));

		PartDefinition Plane_r23 = B6H2HeadFungus.addOrReplaceChild("Plane_r23", CubeListBuilder.create().texOffs(89, 0).addBox(-2.5F, -8.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3844F, 0.0F, 3.612F, 0.3257F, 0.5019F, 0.295F));

		PartDefinition FusedJaw = Body6Heads.addOrReplaceChild("FusedJaw", CubeListBuilder.create(), PartPose.offset(-0.5F, 1.037F, 0.3139F));

		PartDefinition BackofMouth_r1 = FusedJaw.addOrReplaceChild("BackofMouth_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -2.0F, -1.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.25F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Head2Jaw2 = FusedJaw.addOrReplaceChild("Head2Jaw2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.2979F, -2.0318F, 2.3367F, 0.5873F, -0.2182F, 0.1745F));

		PartDefinition Jaw_r3 = Head2Jaw2.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(0, 213).addBox(-3.7979F, -0.9053F, -6.6506F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, -0.3491F));

		PartDefinition Head2Jaw3 = FusedJaw.addOrReplaceChild("Head2Jaw3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7021F, -0.0318F, -0.6633F, 0.2182F, 0.0F, -0.2618F));

		PartDefinition JawSeg2_r1 = Head2Jaw3.addOrReplaceChild("JawSeg2_r1", CubeListBuilder.create().texOffs(224, 158).addBox(-2.0479F, 0.0947F, -6.6506F, 6.0F, 1.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.744F, -0.4073F, 0.1446F));

		PartDefinition Jaw_r4 = Head2Jaw3.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(222, 148).addBox(-4.7979F, -0.9053F, -6.6506F, 6.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.798F, -0.2549F, 0.5029F));

		PartDefinition tongue = FusedJaw.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(248, 191).addBox(-2.0876F, -0.4919F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4124F, -1.5452F, -0.3139F, 0.6981F, -0.0873F, 0.2618F));

		PartDefinition tongue2 = tongue.addOrReplaceChild("tongue2", CubeListBuilder.create().texOffs(108, 208).addBox(-1.5876F, -0.4919F, -6.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tongue3 = tongue2.addOrReplaceChild("tongue3", CubeListBuilder.create().texOffs(0, 65).addBox(-1.0876F, -0.4919F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition PotionHead = Body6Heads.addOrReplaceChild("PotionHead", CubeListBuilder.create().texOffs(142, 184).addBox(-7.5499F, -7.471F, -3.8727F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.4501F, -0.529F, -0.1273F, -0.1309F, 0.0F, -0.3491F));

		PartDefinition LilWart_r2 = PotionHead.addOrReplaceChild("LilWart_r2", CubeListBuilder.create().texOffs(0, 6).addBox(-1.287F, -0.7414F, -0.6909F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(24, 16).addBox(-0.713F, -2.7586F, -0.8091F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-8.637F, 0.7876F, -0.0636F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Jaw = PotionHead.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(215, 122).addBox(-7.0F, -1.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5499F, 1.129F, 0.1273F, -0.1163F, -0.0603F, -0.7383F));

		PartDefinition Potion = Jaw.addOrReplaceChild("Potion", CubeListBuilder.create().texOffs(16, 126).addBox(-2.0F, 5.6563F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(242, 219).addBox(-2.5F, 1.6563F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 264).addBox(-2.0F, 1.6563F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(16, 126).mirror().addBox(-2.0F, 0.6563F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(19, 127).addBox(-1.5F, -0.3438F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 128).addBox(-1.0F, -1.5938F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F))
		.texOffs(18, 127).addBox(-1.5F, -2.8438F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(16, 126).addBox(-2.0F, -3.8438F, -2.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(97, 123).addBox(-1.5F, -5.3437F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.0F, -2.6801F, 0.3691F, 1.6479F, 0.0576F, 0.4613F));

		PartDefinition PotionHeadHat = PotionHead.addOrReplaceChild("PotionHeadHat", CubeListBuilder.create().texOffs(176, 158).addBox(-5.0F, -1.2573F, -4.4424F, 10.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.0736F, -5.7984F, -0.0711F, -1.309F, 1.3526F, -1.5708F));

		PartDefinition Seg4_r6 = PotionHeadHat.addOrReplaceChild("Seg4_r6", CubeListBuilder.create().texOffs(188, 55).addBox(-52.634F, 15.3546F, 21.3391F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(51.134F, -11.0873F, -29.2525F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Seg3_r7 = PotionHeadHat.addOrReplaceChild("Seg3_r7", CubeListBuilder.create().texOffs(59, 245).addBox(-53.634F, 9.4173F, 25.8127F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(51.134F, -7.706F, -30.3741F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Seg2_r7 = PotionHeadHat.addOrReplaceChild("Seg2_r7", CubeListBuilder.create().texOffs(148, 204).mirror().addBox(-4.0F, -2.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.5016F, 0.4269F, -0.0873F, 3.1416F, 0.0F));

		PartDefinition PotionHeadTumorClump = PotionHead.addOrReplaceChild("PotionHeadTumorClump", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FungalPlane_r2 = PotionHeadTumorClump.addOrReplaceChild("FungalPlane_r2", CubeListBuilder.create().texOffs(89, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, -3.0F, -2.5F, -0.1201F, 0.4205F, -0.2875F));

		PartDefinition Tumor_r19 = PotionHeadTumorClump.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(51, 59).addBox(-1.5F, -1.5F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.9811F, -4.3339F, -2.9025F, -0.3271F, 0.237F, -0.3741F));

		PartDefinition Tumor_r20 = PotionHeadTumorClump.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(51, 59).addBox(0.0F, -1.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6765F, -3.587F, -3.8654F, -0.5212F, 0.3994F, 0.4859F));

		PartDefinition Tumor_r21 = PotionHeadTumorClump.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(48, 57).addBox(-2.0F, -2.0F, -0.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -5.0F, -0.3604F, 0.2457F, -0.0914F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Augeo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}