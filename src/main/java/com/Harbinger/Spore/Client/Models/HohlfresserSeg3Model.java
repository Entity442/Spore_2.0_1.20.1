package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Sentities.BaseEntities.HohlMultipart;
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
public class HohlfresserSeg3Model<T extends HohlMultipart> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hohlfresserseg3model"), "main");
	private final ModelPart hohl_seg;
	private final ModelPart SegBase;
	private final ModelPart Tumors;
	private final ModelPart SpineSide;
	private final ModelPart SpineSide2;
	private final ModelPart SpineTop;
	private final ModelPart SpineBottom;
	private final ModelPart Tendrils;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Seg3Tendril1;
	private final ModelPart Seg4Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Seg3Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;
	private final ModelPart Seg3Tendril3;
	private final ModelPart Seg4Tendril2;
	private final ModelPart Tumors2;
	private final ModelPart BileTumor;
	private final ModelPart BileTumor2;
	private final ModelPart BileTumor3;
	private final ModelPart veins;
	private final ModelPart tumorHeart;
	private final ModelPart veins2;
	private final ModelPart tumorHeart2;
	private final ModelPart bodies;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Body5;

	public HohlfresserSeg3Model(ModelPart root) {
		this.hohl_seg = root.getChild("hohl_seg");
		this.SegBase = this.hohl_seg.getChild("SegBase");
		this.Tumors = this.hohl_seg.getChild("Tumors");
		this.SpineSide = this.hohl_seg.getChild("SpineSide");
		this.SpineSide2 = this.hohl_seg.getChild("SpineSide2");
		this.SpineTop = this.hohl_seg.getChild("SpineTop");
		this.SpineBottom = this.hohl_seg.getChild("SpineBottom");
		this.Tendrils = this.hohl_seg.getChild("Tendrils");
		this.Tendril1 = this.Tendrils.getChild("Tendril1");
		this.Seg2Tendril1 = this.Tendril1.getChild("Seg2Tendril1");
		this.Seg3Tendril1 = this.Seg2Tendril1.getChild("Seg3Tendril1");
		this.Seg4Tendril1 = this.Seg3Tendril1.getChild("Seg4Tendril1");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Seg3Tendril2 = this.Seg2Tendril2.getChild("Seg3Tendril2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.Seg2Tendril3 = this.Tendril3.getChild("Seg2Tendril3");
		this.Seg3Tendril3 = this.Seg2Tendril3.getChild("Seg3Tendril3");
		this.Seg4Tendril2 = this.Seg3Tendril3.getChild("Seg4Tendril2");
		this.Tumors2 = this.hohl_seg.getChild("Tumors2");
		this.BileTumor = this.hohl_seg.getChild("BileTumor");
		this.BileTumor2 = this.hohl_seg.getChild("BileTumor2");
		this.BileTumor3 = this.hohl_seg.getChild("BileTumor3");
		this.veins = this.hohl_seg.getChild("veins");
		this.tumorHeart = this.veins.getChild("tumorHeart");
		this.veins2 = this.hohl_seg.getChild("veins2");
		this.tumorHeart2 = this.veins2.getChild("tumorHeart2");
		this.bodies = this.hohl_seg.getChild("bodies");
		this.Body1 = this.bodies.getChild("Body1");
		this.Body2 = this.bodies.getChild("Body2");
		this.Body3 = this.bodies.getChild("Body3");
		this.Body4 = this.bodies.getChild("Body4");
		this.Body5 = this.bodies.getChild("Body5");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hohl_seg = partdefinition.addOrReplaceChild("hohl_seg", CubeListBuilder.create(), PartPose.offset(-3.0F, -5.0F, -27.0F));

		PartDefinition SegBase = hohl_seg.addOrReplaceChild("SegBase", CubeListBuilder.create(), PartPose.offset(-5.0F, -31.0F, 29.0F));

		PartDefinition front_r1 = SegBase.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(110, 266).addBox(26.0F, 11.0F, -0.75F, 6.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 9.25F, 24.5F, 0.0381F, 0.1704F, 0.2214F));

		PartDefinition front_r2 = SegBase.addOrReplaceChild("front_r2", CubeListBuilder.create().texOffs(1, 266).addBox(-14.0F, -1.0F, -1.0F, 40.0F, 38.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 9.25F, 24.5F, -0.0057F, 0.1268F, 0.2197F));

		PartDefinition front_r3 = SegBase.addOrReplaceChild("front_r3", CubeListBuilder.create().texOffs(324, 30).addBox(-14.25F, -2.5F, -2.0F, 33.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3665F, 45.8611F, 25.25F, 0.259F, 0.1261F, 0.2445F));

		PartDefinition front_r4 = SegBase.addOrReplaceChild("front_r4", CubeListBuilder.create().texOffs(64, 306).addBox(26.0F, 8.0F, -1.25F, 9.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -27.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition front_r5 = SegBase.addOrReplaceChild("front_r5", CubeListBuilder.create().texOffs(318, 168).addBox(-18.0F, -2.5F, 0.75F, 36.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1165F, 47.6111F, -27.75F, 0.1752F, 0.0859F, 0.2334F));

		PartDefinition front_r6 = SegBase.addOrReplaceChild("front_r6", CubeListBuilder.create().texOffs(1, 266).addBox(-14.0F, -1.0F, -1.0F, 40.0F, 38.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -27.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition s_r1 = SegBase.addOrReplaceChild("s_r1", CubeListBuilder.create().texOffs(0, 62).addBox(-26.0F, -4.0F, -28.0F, 30.0F, 8.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8959F, 58.9464F, -0.7474F, 0.0341F, 0.1264F, 0.264F));

		PartDefinition s_r2 = SegBase.addOrReplaceChild("s_r2", CubeListBuilder.create().texOffs(128, 190).addBox(-25.4864F, 19.0421F, -30.847F, 8.0F, 15.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9817F, 32.2622F, -0.9557F, 0.1696F, 0.1543F, 0.3544F));

		PartDefinition s_r3 = SegBase.addOrReplaceChild("s_r3", CubeListBuilder.create().texOffs(0, 188).addBox(-4.0F, -20.0F, -28.0F, 8.0F, 22.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.3894F, 42.9845F, 2.7862F, 0.162F, 0.1184F, 0.6163F));

		PartDefinition s_r4 = SegBase.addOrReplaceChild("s_r4", CubeListBuilder.create().texOffs(162, 126).addBox(-21.0F, -4.0F, -28.0F, 22.0F, 8.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9653F, 11.7965F, -0.0603F, -0.1403F, 0.0365F, -1.6198F));

		PartDefinition s_r5 = SegBase.addOrReplaceChild("s_r5", CubeListBuilder.create().texOffs(176, 0).addBox(-10.0F, 0.0F, -54.0F, 20.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7795F, 1.7294F, 26.2072F, 0.0574F, 0.0769F, -0.6597F));

		PartDefinition s_r6 = SegBase.addOrReplaceChild("s_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5114F, -30.7797F, -25.923F, 34.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 32.2622F, -0.9557F, 0.066F, 0.0418F, 0.1702F));

		PartDefinition s2_r1 = SegBase.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(256, 190).addBox(-16.5F, 0.0F, 0.0F, 33.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.4901F, 19.9404F, -6.5601F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s1_r1 = SegBase.addOrReplaceChild("s1_r1", CubeListBuilder.create().texOffs(256, 228).addBox(-16.5F, -4.0F, -2.0F, 33.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.9209F, 22.5215F, -28.1892F, 0.209F, 0.0442F, 1.1759F));

		PartDefinition s_r7 = SegBase.addOrReplaceChild("s_r7", CubeListBuilder.create().texOffs(172, 62).addBox(-15.5525F, 20.9337F, -25.5293F, 24.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9817F, 32.2622F, -0.9557F, -0.045F, 0.123F, -0.3518F));

		PartDefinition s_r8 = SegBase.addOrReplaceChild("s_r8", CubeListBuilder.create().texOffs(0, 126).addBox(-3.6818F, 21.2121F, -25.5293F, 27.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 32.2622F, -0.9557F, -0.0887F, 0.0964F, -0.746F));

		PartDefinition Tumors = hohl_seg.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, 29.0F));

		PartDefinition Tumor_r1 = Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(183, 313).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.6645F, -37.2731F, 21.0378F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition Tumor_r2 = Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(180, 311).addBox(4.6586F, -0.5605F, -17.3304F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.3355F, -21.2731F, 32.0378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition Tumor_r3 = Tumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(179, 308).addBox(-14.5457F, 5.1259F, -4.2879F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.3222F, 6.9279F, 28.9074F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r4 = Tumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(179, 308).addBox(-7.5F, 0.5F, -0.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.1501F, 7.473F, 29.7564F, -0.4531F, -1.5514F, 0.272F));

		PartDefinition Tumor_r5 = Tumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(179, 308).addBox(-9.0F, -4.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 17.0F, 30.5F, -0.3927F, 0.0F, 0.4363F));

		PartDefinition Tumor_r6 = Tumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(179, 308).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7269F, 5.3355F, 31.0378F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Tumor_r7 = Tumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(179, 308).addBox(-3.5F, -7.5F, 1.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.2398F, -25.5732F, 23.5827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r8 = Tumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(179, 308).addBox(-8.6843F, -1.5229F, -4.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6645F, -36.2731F, 27.7878F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r9 = Tumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(170, 301).addBox(-20.0F, -37.0F, -1.0F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 51.0F, 19.5F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition Tumor_r10 = Tumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(185, 315).addBox(-33.5F, -48.5F, -2.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(38.5852F, -0.6645F, 33.1306F, -0.3819F, -0.7073F, -0.4891F));

		PartDefinition Tumor_r11 = Tumors.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(182, 312).addBox(-10.5F, -7.5F, -3.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5852F, 17.3355F, 24.1306F, -0.7418F, 0.0F, 0.5236F));

		PartDefinition Tumor_r12 = Tumors.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(179, 308).addBox(17.0F, -27.0F, -16.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 50.0F, 27.5F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r13 = Tumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(179, 308).addBox(-2.0F, -15.0F, -6.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -4.0F, 29.5F, 0.0F, 0.6545F, 0.5236F));

		PartDefinition Tumor_r14 = Tumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(174, 306).addBox(-10.0F, -10.0F, -5.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.7269F, 7.9509F, 25.5755F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition Tumor_r15 = Tumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(178, 306).addBox(11.0F, -2.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.0F, -1.0F, 28.5F, 1.2897F, 0.6247F, -0.2097F));

		PartDefinition SpineSide = hohl_seg.addOrReplaceChild("SpineSide", CubeListBuilder.create(), PartPose.offsetAndRotation(0.505F, 10.4888F, 4.809F, -0.029F, 0.2199F, -1.5365F));

		PartDefinition plane_r1 = SpineSide.addOrReplaceChild("plane_r1", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -32.7217F, 50.4721F, -0.48F, 0.0F, -0.1309F));

		PartDefinition Ridge_r1 = SpineSide.addOrReplaceChild("Ridge_r1", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, -0.1309F));

		PartDefinition plane_r2 = SpineSide.addOrReplaceChild("plane_r2", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -36.2217F, 28.4721F, -0.3491F, 0.0F, 0.1745F));

		PartDefinition Ridge_r2 = SpineSide.addOrReplaceChild("Ridge_r2", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition plane_r3 = SpineSide.addOrReplaceChild("plane_r3", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -31.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r3 = SpineSide.addOrReplaceChild("Ridge_r3", CubeListBuilder.create().texOffs(216, 382).addBox(4.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(304, 262).addBox(0.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r1 = SpineSide.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition SpineSide2 = hohl_seg.addOrReplaceChild("SpineSide2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.495F, 10.4888F, 3.809F, 0.1899F, -0.0018F, 1.5303F));

		PartDefinition plane_r4 = SpineSide2.addOrReplaceChild("plane_r4", CubeListBuilder.create().texOffs(86, 266).mirror().addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r4 = SpineSide2.addOrReplaceChild("Ridge_r4", CubeListBuilder.create().texOffs(216, 382).mirror().addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r5 = SpineSide2.addOrReplaceChild("plane_r5", CubeListBuilder.create().texOffs(86, 266).mirror().addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -36.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r5 = SpineSide2.addOrReplaceChild("Ridge_r5", CubeListBuilder.create().texOffs(216, 382).mirror().addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r6 = SpineSide2.addOrReplaceChild("plane_r6", CubeListBuilder.create().texOffs(86, 266).mirror().addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -31.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r6 = SpineSide2.addOrReplaceChild("Ridge_r6", CubeListBuilder.create().texOffs(216, 382).mirror().addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(304, 262).mirror().addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r2 = SpineSide2.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(128, 261).mirror().addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition SpineTop = hohl_seg.addOrReplaceChild("SpineTop", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition plane_r7 = SpineTop.addOrReplaceChild("plane_r7", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -33.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r7 = SpineTop.addOrReplaceChild("Ridge_r7", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r8 = SpineTop.addOrReplaceChild("plane_r8", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -35.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r8 = SpineTop.addOrReplaceChild("Ridge_r8", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r9 = SpineTop.addOrReplaceChild("plane_r9", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -33.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r9 = SpineTop.addOrReplaceChild("Ridge_r9", CubeListBuilder.create().texOffs(216, 382).addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(304, 262).addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r3 = SpineTop.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition SpineBottom = hohl_seg.addOrReplaceChild("SpineBottom", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, 6.0F, 2.0F, -0.0873F, 0.0F, -3.1416F));

		PartDefinition plane_r10 = SpineBottom.addOrReplaceChild("plane_r10", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -35.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r10 = SpineBottom.addOrReplaceChild("Ridge_r10", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -35.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r11 = SpineBottom.addOrReplaceChild("plane_r11", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -35.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r11 = SpineBottom.addOrReplaceChild("Ridge_r11", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r12 = SpineBottom.addOrReplaceChild("plane_r12", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -31.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r12 = SpineBottom.addOrReplaceChild("Ridge_r12", CubeListBuilder.create().texOffs(216, 382).addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r4 = SpineBottom.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.2033F, 21.8776F, -0.0436F, 0.0F, 0.0F));

		PartDefinition Base_r5 = SpineBottom.addOrReplaceChild("Base_r5", CubeListBuilder.create().texOffs(304, 262).addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tendrils = hohl_seg.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(-5.0F, 29.0F, 128.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(382, 120).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(33.2768F, -36.2889F, -107.6486F, -2.8772F, -0.5457F, 2.0594F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril1 = Seg3Tendril1.addOrReplaceChild("Seg4Tendril1", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.7342F, -7.8088F, -103.2006F, 0.0809F, -0.8643F, -0.8192F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r1 = Seg2Tendril2.addOrReplaceChild("TendrilSeg_r1", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1409F, -0.072F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition TendrilSeg_r2 = Seg3Tendril2.addOrReplaceChild("TendrilSeg_r2", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(382, 120).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.9482F, -39.9074F, -114.2502F, -2.8934F, 0.719F, -2.2464F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, 0.6364F, 0.1646F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, -0.3272F, -0.1238F));

		PartDefinition Seg4Tendril2 = Seg3Tendril3.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, -0.5194F, 0.2391F));

		PartDefinition Tumors2 = hohl_seg.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, -27.0F));

		PartDefinition Tumor_r16 = Tumors2.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(183, 313).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.6645F, -37.2731F, 21.0378F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition Tumor_r17 = Tumors2.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(180, 311).addBox(4.6585F, -0.5605F, -17.3304F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.3355F, -25.2731F, 32.0378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition Tumor_r18 = Tumors2.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(179, 308).addBox(-14.5457F, 5.1259F, -4.2879F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.3222F, 6.9279F, 28.9074F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r19 = Tumors2.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(179, 308).addBox(-7.5F, 0.5F, -0.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.1501F, 7.473F, 29.7564F, -0.4531F, -1.5514F, 0.272F));

		PartDefinition Tumor_r20 = Tumors2.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(179, 308).addBox(-9.0F, -4.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 17.0F, 30.5F, -0.3927F, 0.0F, 0.4363F));

		PartDefinition Tumor_r21 = Tumors2.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(179, 308).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7269F, 2.3355F, 31.0378F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Tumor_r22 = Tumors2.addOrReplaceChild("Tumor_r22", CubeListBuilder.create().texOffs(179, 308).addBox(-3.5F, -7.5F, 1.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.2398F, -25.5732F, 23.5827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r23 = Tumors2.addOrReplaceChild("Tumor_r23", CubeListBuilder.create().texOffs(179, 308).addBox(-8.6843F, -1.5229F, -4.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6645F, -33.2731F, 27.7878F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r24 = Tumors2.addOrReplaceChild("Tumor_r24", CubeListBuilder.create().texOffs(170, 301).addBox(-20.0F, -37.0F, -1.0F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 51.0F, 19.5F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition Tumor_r25 = Tumors2.addOrReplaceChild("Tumor_r25", CubeListBuilder.create().texOffs(185, 315).addBox(-33.5F, -48.5F, -2.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(32.5852F, -0.6645F, 33.1306F, -0.3819F, -0.7073F, -0.4891F));

		PartDefinition Tumor_r26 = Tumors2.addOrReplaceChild("Tumor_r26", CubeListBuilder.create().texOffs(182, 312).addBox(-10.5F, -7.5F, -3.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5852F, 17.3355F, 24.1306F, -0.7418F, 0.0F, 0.5236F));

		PartDefinition Tumor_r27 = Tumors2.addOrReplaceChild("Tumor_r27", CubeListBuilder.create().texOffs(179, 308).addBox(17.0F, -27.0F, -16.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 50.0F, 27.5F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r28 = Tumors2.addOrReplaceChild("Tumor_r28", CubeListBuilder.create().texOffs(179, 308).addBox(-2.0F, -15.0F, -6.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, -4.0F, 29.5F, 0.0F, 0.6545F, 0.5236F));

		PartDefinition Tumor_r29 = Tumors2.addOrReplaceChild("Tumor_r29", CubeListBuilder.create().texOffs(174, 306).addBox(-10.0F, -10.0F, -5.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.7269F, 7.9509F, 25.5755F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition Tumor_r30 = Tumors2.addOrReplaceChild("Tumor_r30", CubeListBuilder.create().texOffs(178, 306).addBox(11.0F, -2.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.0F, 1.0F, 28.5F, 1.2897F, 0.6247F, -0.2097F));

		PartDefinition BileTumor = hohl_seg.addOrReplaceChild("BileTumor", CubeListBuilder.create().texOffs(458, 10).addBox(-2.5328F, -5.0559F, -4.7206F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -24.0F, 17.0F, 0.2827F, 0.1029F, -1.3273F));

		PartDefinition cube_r1 = BileTumor.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(469, 17).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 8.9441F, 2.2794F, 0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = BileTumor.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(462, 14).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 0.9441F, -4.7206F, -0.4363F, 0.0F, 0.0F));

		PartDefinition BileTumor2 = hohl_seg.addOrReplaceChild("BileTumor2", CubeListBuilder.create().texOffs(458, 10).addBox(-2.5328F, -5.0559F, -4.7206F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.0F, 12.0F, 39.0F, 0.6806F, 0.0243F, -3.0186F));

		PartDefinition cube_r3 = BileTumor2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(469, 17).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4672F, 8.9441F, -1.7206F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r4 = BileTumor2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(462, 14).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4672F, 3.9441F, 5.2794F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r5 = BileTumor2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(462, 14).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 0.9441F, -4.7206F, -0.1309F, 0.0F, 0.0F));

		PartDefinition BileTumor3 = hohl_seg.addOrReplaceChild("BileTumor3", CubeListBuilder.create().texOffs(458, 10).addBox(-0.5328F, -5.0559F, -4.7206F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 25.0F, 39.0F, 0.2724F, -0.0214F, 2.0696F));

		PartDefinition cube_r6 = BileTumor3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(462, 14).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4672F, 3.9441F, 4.2794F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r7 = BileTumor3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(462, 14).addBox(-7.0F, -8.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4672F, 0.9441F, -4.7206F, -0.4363F, 0.0F, 0.0F));

		PartDefinition veins = hohl_seg.addOrReplaceChild("veins", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r8 = veins.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(475, 73).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.75F, -19.5F, 10.0F, 2.991F, -0.0389F, 2.5065F));

		PartDefinition cube_r9 = veins.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(448, 91).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -24.25F, 16.0F, 0.413F, 1.1879F, -0.2549F));

		PartDefinition cube_r10 = veins.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(440, 60).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -23.25F, 18.0F, 2.958F, 0.6072F, 2.3951F));

		PartDefinition cube_r11 = veins.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(473, 84).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -23.0F, 22.0F, 3.0543F, -0.4363F, 2.4871F));

		PartDefinition cube_r12 = veins.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(464, 67).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -23.0F, 32.0F, 0.0F, -0.2182F, -0.6545F));

		PartDefinition cube_r13 = veins.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.25F, -24.75F, 39.5F, -0.9872F, -0.3898F, -0.5698F));

		PartDefinition cube_r14 = veins.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -19.75F, 32.75F, -0.0828F, 0.6549F, -0.6473F));

		PartDefinition cube_r15 = veins.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -28.0F, 32.75F, -0.1005F, -0.0826F, -0.5618F));

		PartDefinition cube_r16 = veins.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -28.0F, 34.75F, -0.1309F, 0.6981F, -0.6545F));

		PartDefinition cube_r17 = veins.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(470, 69).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -26.0F, 31.0F, 0.0F, 0.6981F, -0.6545F));

		PartDefinition tumorHeart = veins.addOrReplaceChild("tumorHeart", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, -23.0F, 25.0F, 0.0F, 0.3054F, 1.2654F));

		PartDefinition Tumor_r31 = tumorHeart.addOrReplaceChild("Tumor_r31", CubeListBuilder.create().texOffs(461, 78).addBox(-5.0277F, 7.8296F, -7.3988F, 10.0F, 10.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6645F, -9.2731F, -10.9622F, 1.7678F, 0.4149F, 2.6215F));

		PartDefinition Tumor_r32 = tumorHeart.addOrReplaceChild("Tumor_r32", CubeListBuilder.create().texOffs(472, 80).addBox(3.9723F, 10.8296F, -9.3988F, 5.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-8.3355F, -11.2731F, -5.9622F, 1.0855F, -0.2336F, -0.157F));

		PartDefinition Tumor_r33 = tumorHeart.addOrReplaceChild("Tumor_r33", CubeListBuilder.create().texOffs(462, 76).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-8.3355F, -11.2731F, -5.9622F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition veins2 = hohl_seg.addOrReplaceChild("veins2", CubeListBuilder.create(), PartPose.offsetAndRotation(13.0F, 19.0F, 23.0F, -0.0381F, 0.1704F, -0.2214F));

		PartDefinition cube_r18 = veins2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(475, 73).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 7.5F, -13.0F, 3.1219F, -0.0389F, 2.5065F));

		PartDefinition cube_r19 = veins2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(448, 91).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 2.25F, -7.75F, 0.413F, 1.1879F, -0.2549F));

		PartDefinition cube_r20 = veins2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(440, 60).addBox(0.0F, -1.0F, -1.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.75F, -5.0F, -3.0634F, 0.6072F, 2.3951F));

		PartDefinition cube_r21 = veins2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(473, 84).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, -1.0F, -3.098F, -0.4363F, 2.4871F));

		PartDefinition cube_r22 = veins2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(464, 67).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 5.0F, 9.0F, 0.1745F, -0.2182F, -0.6545F));

		PartDefinition cube_r23 = veins2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 5.25F, 17.5F, 0.1036F, -0.3898F, -0.5698F));

		PartDefinition cube_r24 = veins2.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 8.25F, 9.75F, 0.1354F, 0.6549F, -0.6473F));

		PartDefinition cube_r25 = veins2.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 0.0F, 9.75F, -0.1005F, -0.0826F, -0.5618F));

		PartDefinition cube_r26 = veins2.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(479, 77).addBox(-3.0387F, -5.0438F, 4.4502F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 11.75F, -0.1309F, 0.6981F, -0.6545F));

		PartDefinition cube_r27 = veins2.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(470, 69).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 2.0F, 8.0F, 0.0F, 0.6981F, -0.6545F));

		PartDefinition tumorHeart2 = veins2.addOrReplaceChild("tumorHeart2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 5.0F, 2.0F, 0.0F, 0.3054F, 1.2654F));

		PartDefinition Tumor_r34 = tumorHeart2.addOrReplaceChild("Tumor_r34", CubeListBuilder.create().texOffs(461, 78).addBox(-5.0277F, 7.8296F, -7.3988F, 10.0F, 10.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6645F, -9.2731F, -10.9622F, 1.9423F, 0.4149F, 2.6215F));

		PartDefinition Tumor_r35 = tumorHeart2.addOrReplaceChild("Tumor_r35", CubeListBuilder.create().texOffs(472, 80).addBox(3.9723F, 10.8296F, -9.3988F, 5.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-8.3355F, -13.2731F, -3.9622F, 1.0855F, -0.2336F, -0.157F));

		PartDefinition Tumor_r36 = tumorHeart2.addOrReplaceChild("Tumor_r36", CubeListBuilder.create().texOffs(462, 76).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-7.3355F, -11.2731F, -5.9622F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition bodies = hohl_seg.addOrReplaceChild("bodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body1 = bodies.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(67, 164).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(59, 142).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-42.15F, 19.0F, 22.0F));

		PartDefinition Leg_r1 = Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(84, 146).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, 2.0F, 0.6109F, 0.0F, -1.3526F));

		PartDefinition Leg_r2 = Body1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(67, 146).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.0411F, -0.3027F, -1.4336F));

		PartDefinition Arm_r1 = Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(70, 173).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r1 = Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(67, 131).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0049F, -0.206F, 0.1888F));

		PartDefinition Head_r1 = Body1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(67, 146).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Body2 = bodies.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(67, 164).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(59, 142).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.15F, 25.0F, 5.0F, 2.7117F, -0.5287F, 0.1058F));

		PartDefinition Leg_r3 = Body2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(84, 146).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, 2.0F, 0.6814F, -0.3292F, -0.208F));

		PartDefinition Leg_r4 = Body2.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(67, 146).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.0814F, -0.2947F, -1.2969F));

		PartDefinition Arm_r2 = Body2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(70, 173).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -0.6313F, -0.8761F, -1.0943F));

		PartDefinition Jaw_r2 = Body2.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(67, 131).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0049F, -0.206F, 0.1888F));

		PartDefinition Head_r2 = Body2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(67, 146).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Body3 = bodies.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(67, 164).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(59, 142).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.15F, 35.0F, 19.0F, -2.2515F, -0.1035F, -1.2235F));

		PartDefinition Arm_r3 = Body3.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(70, 173).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -0.6313F, -0.8761F, -1.0943F));

		PartDefinition Jaw_r3 = Body3.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(67, 131).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0049F, -0.206F, 0.1888F));

		PartDefinition Head_r3 = Body3.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(67, 146).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Body4 = bodies.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(67, 164).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(59, 142).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.85F, -30.0F, 37.0F, 0.6265F, -0.0221F, 2.0414F));

		PartDefinition Leg_r5 = Body4.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(84, 146).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, 2.0F, 0.6814F, -0.3292F, -0.208F));

		PartDefinition Leg_r6 = Body4.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(67, 146).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.0814F, -0.2947F, -1.2969F));

		PartDefinition Arm_r4 = Body4.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(70, 173).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -0.6313F, -0.8761F, -1.0943F));

		PartDefinition Jaw_r4 = Body4.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(67, 131).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0049F, -0.206F, 0.1888F));

		PartDefinition Head_r4 = Body4.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(67, 146).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Body5 = bodies.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(67, 164).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(59, 142).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.85F, 34.0F, 29.0F, 1.1378F, 0.1072F, -2.1944F));

		PartDefinition Leg_r7 = Body5.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(84, 146).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 8.0F, 2.0F, 0.6814F, -0.3292F, -0.208F));

		PartDefinition Leg_r8 = Body5.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(67, 146).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.0814F, -0.2947F, -1.2969F));

		PartDefinition Arm_r5 = Body5.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(70, 173).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -0.6313F, -0.8761F, -1.0943F));

		PartDefinition Jaw_r5 = Body5.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(67, 131).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0049F, -0.206F, 0.1888F));

		PartDefinition Head_r5 = Body5.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(67, 146).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	void animateHeart(ModelPart part,float val){
		part.xScale = 1 + val;
		part.yScale = 1 - val;
		part.zScale = 1 + val;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		hohl_seg.zRot = entity.getSpin();
		float moveSeg2 = Mth.sin(ageInTicks/8)/5;
		float moveSeg3 = Mth.cos(ageInTicks/6)/6;
		float moveSeg4 = Mth.cos(ageInTicks/5)/5;
		this.animateTentacleZ(Tendril1,moveSeg2);
		this.animateTentacleX(Seg2Tendril1,moveSeg2);
		this.animateTentacleX(Seg3Tendril1,moveSeg2);
		this.animateTentacleX(Seg4Tendril1,moveSeg2);
		this.animateTentacleY(Tendril2,moveSeg3);
		this.animateTentacleY(Seg2Tendril2,moveSeg3);
		this.animateTentacleY(Seg3Tendril2,moveSeg3);
		this.animateTentacleX(Tendril3,moveSeg4);
		this.animateTentacleX(Seg2Tendril3,moveSeg4);
		this.animateTentacleX(Seg3Tendril3,moveSeg4);
		this.animateTentacleX(Seg3Tendril3,moveSeg4);
		animateTumor(BileTumor,Mth.sin(ageInTicks/6)/7);
		animateTumor(BileTumor2,Mth.cos(ageInTicks/8)/7);
		animateTumor(BileTumor3,Mth.sin(ageInTicks/6)/5);
		animateHeart(tumorHeart,Mth.sin(ageInTicks/4)/7);
		animateHeart(tumorHeart2,Mth.cos(ageInTicks/4)/7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hohl_seg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}