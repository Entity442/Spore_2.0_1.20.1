package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

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
public class hohlfresserTailModel<T extends HohlMultipart> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hohlfressertailmodel"), "main");
	public final ModelPart tail;
	private final ModelPart SegBase;
	private final ModelPart Tumors;
	private final ModelPart SpineSide;
	private final ModelPart SpineTop;
	private final ModelPart rib2;
	private final ModelPart rib3;
	private final ModelPart Bodies;
	private final ModelPart Body30;
	private final ModelPart Body31;
	private final ModelPart Body32;
	private final ModelPart Body33;
	private final ModelPart Body34;
	private final ModelPart Body35;
	private final ModelPart Body36;
	private final ModelPart Body37;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Body5;
	private final ModelPart Body6;
	private final ModelPart Body7;
	private final ModelPart Body8;
	private final ModelPart Tendrils;
	private final ModelPart Root1;
	private final ModelPart R1Seg2;
	private final ModelPart R1Seg3;
	private final ModelPart R1Seg4;
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
	private final ModelPart Bloom;
	private final ModelPart Tumors2;
	private final ModelPart Tumors3;
	private final ModelPart EndRoot;
	private final ModelPart ESeg1;
	private final ModelPart ESeg2;
	private final ModelPart ESeg3;
	private final ModelPart EndRoot2;
	private final ModelPart ESeg4;
	private final ModelPart ESeg5;
	private final ModelPart ESeg6;
	private final ModelPart EndRoot3;
	private final ModelPart ESeg7;
	private final ModelPart ESeg8;
	private final ModelPart ESeg9;
	private final ModelPart EndRoot4;
	private final ModelPart ESeg10;
	private final ModelPart ESeg11;
	private final ModelPart ESeg12;
	private final ModelPart Bloom2;

	public hohlfresserTailModel(ModelPart root) {
		this.tail = root.getChild("tail");
		this.SegBase = this.tail.getChild("SegBase");
		this.Tumors = this.tail.getChild("Tumors");
		this.SpineSide = this.tail.getChild("SpineSide");
		this.SpineTop = this.tail.getChild("SpineTop");
		this.rib2 = this.SpineTop.getChild("rib2");
		this.rib3 = this.SpineTop.getChild("rib3");
		this.Bodies = this.tail.getChild("Bodies");
		this.Body30 = this.Bodies.getChild("Body30");
		this.Body31 = this.Bodies.getChild("Body31");
		this.Body32 = this.Bodies.getChild("Body32");
		this.Body33 = this.Bodies.getChild("Body33");
		this.Body34 = this.Bodies.getChild("Body34");
		this.Body35 = this.Bodies.getChild("Body35");
		this.Body36 = this.Bodies.getChild("Body36");
		this.Body37 = this.Bodies.getChild("Body37");
		this.Body2 = this.Bodies.getChild("Body2");
		this.Body3 = this.Bodies.getChild("Body3");
		this.Body4 = this.Bodies.getChild("Body4");
		this.Body5 = this.Bodies.getChild("Body5");
		this.Body6 = this.Bodies.getChild("Body6");
		this.Body7 = this.Bodies.getChild("Body7");
		this.Body8 = this.Bodies.getChild("Body8");
		this.Tendrils = this.tail.getChild("Tendrils");
		this.Root1 = this.Tendrils.getChild("Root1");
		this.R1Seg2 = this.Root1.getChild("R1Seg2");
		this.R1Seg3 = this.R1Seg2.getChild("R1Seg3");
		this.R1Seg4 = this.R1Seg3.getChild("R1Seg4");
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
		this.Bloom = this.tail.getChild("Bloom");
		this.Tumors2 = this.tail.getChild("Tumors2");
		this.Tumors3 = this.tail.getChild("Tumors3");
		this.EndRoot = this.tail.getChild("EndRoot");
		this.ESeg1 = this.EndRoot.getChild("ESeg1");
		this.ESeg2 = this.ESeg1.getChild("ESeg2");
		this.ESeg3 = this.ESeg2.getChild("ESeg3");
		this.EndRoot2 = this.tail.getChild("EndRoot2");
		this.ESeg4 = this.EndRoot2.getChild("ESeg4");
		this.ESeg5 = this.ESeg4.getChild("ESeg5");
		this.ESeg6 = this.ESeg5.getChild("ESeg6");
		this.EndRoot3 = this.tail.getChild("EndRoot3");
		this.ESeg7 = this.EndRoot3.getChild("ESeg7");
		this.ESeg8 = this.ESeg7.getChild("ESeg8");
		this.ESeg9 = this.ESeg8.getChild("ESeg9");
		this.EndRoot4 = this.tail.getChild("EndRoot4");
		this.ESeg10 = this.EndRoot4.getChild("ESeg10");
		this.ESeg11 = this.ESeg10.getChild("ESeg11");
		this.ESeg12 = this.ESeg11.getChild("ESeg12");
		this.Bloom2 = this.tail.getChild("Bloom2");
	}
	public hohlfresserTailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.tail = root.getChild("tail");
		this.SegBase = this.tail.getChild("SegBase");
		this.Tumors = this.tail.getChild("Tumors");
		this.SpineSide = this.tail.getChild("SpineSide");
		this.SpineTop = this.tail.getChild("SpineTop");
		this.rib2 = this.SpineTop.getChild("rib2");
		this.rib3 = this.SpineTop.getChild("rib3");
		this.Bodies = this.tail.getChild("Bodies");
		this.Body30 = this.Bodies.getChild("Body30");
		this.Body31 = this.Bodies.getChild("Body31");
		this.Body32 = this.Bodies.getChild("Body32");
		this.Body33 = this.Bodies.getChild("Body33");
		this.Body34 = this.Bodies.getChild("Body34");
		this.Body35 = this.Bodies.getChild("Body35");
		this.Body36 = this.Bodies.getChild("Body36");
		this.Body37 = this.Bodies.getChild("Body37");
		this.Body2 = this.Bodies.getChild("Body2");
		this.Body3 = this.Bodies.getChild("Body3");
		this.Body4 = this.Bodies.getChild("Body4");
		this.Body5 = this.Bodies.getChild("Body5");
		this.Body6 = this.Bodies.getChild("Body6");
		this.Body7 = this.Bodies.getChild("Body7");
		this.Body8 = this.Bodies.getChild("Body8");
		this.Tendrils = this.tail.getChild("Tendrils");
		this.Root1 = this.Tendrils.getChild("Root1");
		this.R1Seg2 = this.Root1.getChild("R1Seg2");
		this.R1Seg3 = this.R1Seg2.getChild("R1Seg3");
		this.R1Seg4 = this.R1Seg3.getChild("R1Seg4");
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
		this.Bloom = this.tail.getChild("Bloom");
		this.Tumors2 = this.tail.getChild("Tumors2");
		this.Tumors3 = this.tail.getChild("Tumors3");
		this.EndRoot = this.tail.getChild("EndRoot");
		this.ESeg1 = this.EndRoot.getChild("ESeg1");
		this.ESeg2 = this.ESeg1.getChild("ESeg2");
		this.ESeg3 = this.ESeg2.getChild("ESeg3");
		this.EndRoot2 = this.tail.getChild("EndRoot2");
		this.ESeg4 = this.EndRoot2.getChild("ESeg4");
		this.ESeg5 = this.ESeg4.getChild("ESeg5");
		this.ESeg6 = this.ESeg5.getChild("ESeg6");
		this.EndRoot3 = this.tail.getChild("EndRoot3");
		this.ESeg7 = this.EndRoot3.getChild("ESeg7");
		this.ESeg8 = this.ESeg7.getChild("ESeg8");
		this.ESeg9 = this.ESeg8.getChild("ESeg9");
		this.EndRoot4 = this.tail.getChild("EndRoot4");
		this.ESeg10 = this.EndRoot4.getChild("ESeg10");
		this.ESeg11 = this.ESeg10.getChild("ESeg11");
		this.ESeg12 = this.ESeg11.getChild("ESeg12");
		this.Bloom2 = this.tail.getChild("Bloom2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(-3.0F, -5.0F, -27.0F));

		PartDefinition SegBase = tail.addOrReplaceChild("SegBase", CubeListBuilder.create(), PartPose.offset(-5.0F, -31.0F, 29.0F));

		PartDefinition front_r1 = SegBase.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(110, 266).addBox(26.0F, 11.0F, -0.75F, 6.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 9.25F, 24.5F, 0.0381F, 0.1704F, 0.2214F));

		PartDefinition front_r2 = SegBase.addOrReplaceChild("front_r2", CubeListBuilder.create().texOffs(8, 274).addBox(-14.3247F, -14.5156F, -1.6631F, 33.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 29.25F, 56.5F, -0.0057F, 0.1268F, 0.2634F));

		PartDefinition front_r3 = SegBase.addOrReplaceChild("front_r3", CubeListBuilder.create().texOffs(324, 30).addBox(-14.25F, -2.5F, -2.0F, 33.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3665F, 45.8611F, 25.25F, 0.259F, 0.1261F, 0.2445F));

		PartDefinition front_r4 = SegBase.addOrReplaceChild("front_r4", CubeListBuilder.create().texOffs(64, 306).addBox(26.0F, 8.0F, -1.25F, 9.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -27.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition front_r5 = SegBase.addOrReplaceChild("front_r5", CubeListBuilder.create().texOffs(318, 168).addBox(-18.0F, -2.5F, 0.75F, 36.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1165F, 47.6111F, -27.75F, 0.1752F, 0.0859F, 0.2334F));

		PartDefinition front_r6 = SegBase.addOrReplaceChild("front_r6", CubeListBuilder.create().texOffs(1, 266).addBox(-14.0F, -1.0F, -1.0F, 40.0F, 38.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -27.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition s_r1 = SegBase.addOrReplaceChild("s_r1", CubeListBuilder.create().texOffs(14, 76).addBox(-14.9882F, -6.9506F, -7.3352F, 28.0F, 8.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.8959F, 44.9464F, 22.2526F, 0.1745F, 0.0814F, 0.7441F));

		PartDefinition s_r2 = SegBase.addOrReplaceChild("s_r2", CubeListBuilder.create().texOffs(0, 62).addBox(-26.0F, -4.0F, -28.0F, 30.0F, 8.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8959F, 58.9464F, -0.7474F, 0.0341F, 0.1264F, 0.264F));

		PartDefinition s_r3 = SegBase.addOrReplaceChild("s_r3", CubeListBuilder.create().texOffs(128, 190).addBox(-25.4864F, 19.0421F, -30.847F, 8.0F, 15.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9817F, 32.2622F, -0.9557F, 0.1696F, 0.1543F, 0.3544F));

		PartDefinition s_r4 = SegBase.addOrReplaceChild("s_r4", CubeListBuilder.create().texOffs(17, 205).addBox(-4.0F, -20.0F, -8.0F, 8.0F, 22.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3894F, 26.9845F, 29.7862F, -0.2182F, 0.0F, 0.0F));

		PartDefinition s_r5 = SegBase.addOrReplaceChild("s_r5", CubeListBuilder.create().texOffs(0, 188).addBox(-4.0F, -20.0F, -28.0F, 8.0F, 22.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.3894F, 42.9845F, 2.7862F, 0.162F, 0.1184F, 0.6163F));

		PartDefinition s_r6 = SegBase.addOrReplaceChild("s_r6", CubeListBuilder.create().texOffs(162, 126).addBox(-21.0F, -4.0F, -28.0F, 22.0F, 8.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.9653F, 11.7965F, -0.0603F, -0.1403F, 0.0365F, -1.6198F));

		PartDefinition s_r7 = SegBase.addOrReplaceChild("s_r7", CubeListBuilder.create().texOffs(176, 0).addBox(-10.0F, 0.0F, -54.0F, 20.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7795F, 1.7294F, 26.2072F, 0.0574F, 0.0769F, -0.6597F));

		PartDefinition s_r8 = SegBase.addOrReplaceChild("s_r8", CubeListBuilder.create().texOffs(350, 464).addBox(-16.1878F, -3.0389F, -2.9181F, 34.0F, 8.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9817F, 7.2622F, 27.0443F, -0.1958F, 0.0418F, 0.1702F));

		PartDefinition s_r9 = SegBase.addOrReplaceChild("s_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5114F, -30.7797F, -25.923F, 34.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 32.2622F, -0.9557F, 0.066F, 0.0418F, 0.1702F));

		PartDefinition s2_r1 = SegBase.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(256, 190).addBox(-16.5F, 0.0F, 0.0F, 28.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.4901F, 25.9404F, 24.4399F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s2_r2 = SegBase.addOrReplaceChild("s2_r2", CubeListBuilder.create().texOffs(256, 190).addBox(-16.5F, 0.0F, 0.0F, 33.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.4901F, 19.9404F, -6.5601F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s1_r1 = SegBase.addOrReplaceChild("s1_r1", CubeListBuilder.create().texOffs(256, 228).addBox(-16.5F, -4.0F, -2.0F, 33.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.9209F, 22.5215F, -28.1892F, 0.209F, 0.0442F, 1.1759F));

		PartDefinition s_r10 = SegBase.addOrReplaceChild("s_r10", CubeListBuilder.create().texOffs(194, 84).addBox(-11.7831F, -3.2346F, -4.97F, 24.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9817F, 45.2622F, 27.0443F, 0.0859F, 0.123F, -0.3518F));

		PartDefinition s_r11 = SegBase.addOrReplaceChild("s_r11", CubeListBuilder.create().texOffs(172, 62).addBox(-15.5525F, 20.9337F, -25.5293F, 24.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9817F, 32.2622F, -0.9557F, -0.045F, 0.123F, -0.3518F));

		PartDefinition s_r12 = SegBase.addOrReplaceChild("s_r12", CubeListBuilder.create().texOffs(0, 126).addBox(-3.6818F, 21.2121F, -25.5293F, 27.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 32.2622F, -0.9557F, -0.0887F, 0.0964F, -0.746F));

		PartDefinition Tumors = tail.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, 29.0F));

		PartDefinition Tumor_r1 = Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(183, 313).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.6645F, -34.2731F, 21.0378F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition Tumor_r2 = Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(180, 311).addBox(4.6586F, -0.5605F, -17.3304F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.3355F, -21.2731F, 32.0378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition Tumor_r3 = Tumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(179, 308).addBox(-14.5457F, 5.1259F, -4.2879F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.3222F, 6.9279F, 31.9074F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r4 = Tumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(179, 308).addBox(-7.5F, 0.5F, -0.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.1501F, 1.473F, 35.7564F, -0.4531F, -1.5514F, 0.272F));

		PartDefinition Tumor_r5 = Tumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(179, 308).addBox(-9.0F, -4.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.0F, 30.5F, -0.3927F, 0.0F, 0.4363F));

		PartDefinition Tumor_r6 = Tumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(179, 308).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7269F, 2.3355F, 31.0378F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Tumor_r7 = Tumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(179, 308).addBox(-3.5F, -7.5F, 1.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.2398F, -25.5732F, 23.5827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r8 = Tumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(179, 308).addBox(-8.6843F, -1.5229F, -4.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6645F, -32.2731F, 27.7878F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r9 = Tumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(170, 301).addBox(-20.0F, -37.0F, -1.0F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 51.0F, 19.5F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition Tumor_r10 = Tumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(185, 315).addBox(-33.5F, -48.5F, -2.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(38.5852F, -0.6645F, 33.1306F, -0.3819F, -0.7073F, -0.4891F));

		PartDefinition Tumor_r11 = Tumors.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(182, 312).addBox(-10.5F, -7.5F, -3.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5852F, 17.3355F, 24.1306F, -0.7418F, 0.0F, 0.5236F));

		PartDefinition Tumor_r12 = Tumors.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(179, 308).addBox(17.0F, -27.0F, -16.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 47.0F, 29.5F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r13 = Tumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(179, 308).addBox(-2.0F, -15.0F, -6.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -4.0F, 26.5F, 0.0F, 0.6545F, 0.5236F));

		PartDefinition Tumor_r14 = Tumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(174, 306).addBox(-10.0F, -10.0F, -5.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.7269F, 7.9509F, 25.5755F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition Tumor_r15 = Tumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(178, 306).addBox(11.0F, -2.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.0F, -1.0F, 28.5F, 1.2897F, 0.6247F, -0.2097F));

		PartDefinition SpineSide = tail.addOrReplaceChild("SpineSide", CubeListBuilder.create(), PartPose.offsetAndRotation(0.505F, 10.4888F, 4.809F, -0.029F, 0.2199F, -1.5365F));

		PartDefinition plane_r1 = SpineSide.addOrReplaceChild("plane_r1", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -28.7217F, 76.4721F, -0.3054F, -0.2182F, 0.0F));

		PartDefinition plane_r2 = SpineSide.addOrReplaceChild("plane_r2", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -32.7217F, 50.4721F, -0.48F, 0.0F, -0.1309F));

		PartDefinition Ridge_r1 = SpineSide.addOrReplaceChild("Ridge_r1", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -27.7217F, 78.4721F, -0.2182F, -0.1745F, 0.0F));

		PartDefinition Ridge_r2 = SpineSide.addOrReplaceChild("Ridge_r2", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, -0.1309F));

		PartDefinition plane_r3 = SpineSide.addOrReplaceChild("plane_r3", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -36.2217F, 28.4721F, -0.3491F, 0.0F, 0.1745F));

		PartDefinition Ridge_r3 = SpineSide.addOrReplaceChild("Ridge_r3", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, 0.1745F));

		PartDefinition plane_r4 = SpineSide.addOrReplaceChild("plane_r4", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -31.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r4 = SpineSide.addOrReplaceChild("Ridge_r4", CubeListBuilder.create().texOffs(216, 382).addBox(4.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(304, 262).addBox(0.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r1 = SpineSide.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -27.2033F, 53.8776F, -0.1309F, -0.2182F, 0.0F));

		PartDefinition Base_r2 = SpineSide.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition SpineTop = tail.addOrReplaceChild("SpineTop", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 0.0F, 2.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition plane_r5 = SpineTop.addOrReplaceChild("plane_r5", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -22.7217F, 79.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition plane_r6 = SpineTop.addOrReplaceChild("plane_r6", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -33.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r5 = SpineTop.addOrReplaceChild("Ridge_r5", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -20.7217F, 80.4721F, -0.4363F, 0.0F, 0.1309F));

		PartDefinition Ridge_r6 = SpineTop.addOrReplaceChild("Ridge_r6", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r7 = SpineTop.addOrReplaceChild("plane_r7", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -35.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r7 = SpineTop.addOrReplaceChild("Ridge_r7", CubeListBuilder.create().texOffs(216, 382).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r8 = SpineTop.addOrReplaceChild("plane_r8", CubeListBuilder.create().texOffs(86, 266).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -33.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r8 = SpineTop.addOrReplaceChild("Ridge_r8", CubeListBuilder.create().texOffs(216, 382).addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(304, 262).addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r3 = SpineTop.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -27.2033F, 54.8776F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Base_r4 = SpineTop.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(128, 261).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition rib2 = SpineTop.addOrReplaceChild("rib2", CubeListBuilder.create(), PartPose.offset(-3.5F, -28.0F, 30.0F));

		PartDefinition rBase_r1 = rib2.addOrReplaceChild("rBase_r1", CubeListBuilder.create().texOffs(318, 156).addBox(11.2985F, -25.3138F, 0.4881F, 32.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7367F, 2.2172F, 0.9356F, -0.0501F, 0.023F, 1.2324F));

		PartDefinition rBase_r2 = rib2.addOrReplaceChild("rBase_r2", CubeListBuilder.create().texOffs(44, 374).addBox(16.1701F, -11.2582F, -2.6268F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7367F, 2.2172F, 0.9356F, 0.0725F, -0.1932F, 0.5335F));

		PartDefinition rBase_r3 = rib2.addOrReplaceChild("rBase_r3", CubeListBuilder.create().texOffs(328, 108).addBox(-4.6811F, -3.1677F, -4.4897F, 24.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7367F, 2.2172F, 0.9356F, -0.0097F, -0.218F, 0.0883F));

		PartDefinition rib3 = SpineTop.addOrReplaceChild("rib3", CubeListBuilder.create(), PartPose.offset(-3.5F, -19.0F, 73.0F));

		PartDefinition rBase_r4 = rib3.addOrReplaceChild("rBase_r4", CubeListBuilder.create().texOffs(318, 156).addBox(-1.0042F, -5.1889F, -0.7888F, 32.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.4867F, 4.2172F, 2.9356F, -0.0191F, 0.2455F, 1.356F));

		PartDefinition rBase_r5 = rib3.addOrReplaceChild("rBase_r5", CubeListBuilder.create().texOffs(44, 374).addBox(-7.8299F, -1.2582F, -2.6268F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.7367F, 33.7172F, -3.0644F, -0.0436F, 0.0F, -0.4363F));

		PartDefinition rBase_r6 = rib3.addOrReplaceChild("rBase_r6", CubeListBuilder.create().texOffs(328, 108).addBox(-4.6811F, -3.1677F, -4.4897F, 24.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7367F, 2.2172F, 0.9356F, -0.2457F, -0.1975F, 0.175F));

		PartDefinition Bodies = tail.addOrReplaceChild("Bodies", CubeListBuilder.create(), PartPose.offset(27.0F, 29.0F, 120.0F));

		PartDefinition Body30 = Bodies.addOrReplaceChild("Body30", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.7374F, -58.6415F, -112.8988F, -0.0684F, -0.2462F, -0.0041F));

		PartDefinition Leg_r1 = Body30.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(0, 506).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.018F));

		PartDefinition Arm_r1 = Body30.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 506).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -1.2271F, 2.7196F, -0.0232F, -0.8265F, 0.733F));

		PartDefinition Arm_r2 = Body30.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(0, 506).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, 1.3726F, -6.7458F, -0.2001F, 0.1744F, -0.0891F));

		PartDefinition TorsoBase_r1 = Body30.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(0, 502).addBox(-3.25F, 0.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.2494F, -0.4119F, 0.2485F));

		PartDefinition TorsoTop_r1 = Body30.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(0, 500).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 496).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 3.6966F, 0.4933F, -0.0177F, -0.4775F, 0.724F));

		PartDefinition Jaw_r1 = Body30.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 496).addBox(-2.002F, -6.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, 1.6169F, -2.47F, -0.1237F, -0.3749F, 0.9561F));

		PartDefinition Body31 = Bodies.addOrReplaceChild("Body31", CubeListBuilder.create().texOffs(0, 499).addBox(-2.4218F, -0.7079F, -3.1266F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3396F, -54.7733F, -87.2496F, 0.851F, 0.1401F, 2.2813F));

		PartDefinition Leg_r2 = Body31.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(0, 501).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5814F, 4.771F, -1.197F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r3 = Body31.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(0, 503).addBox(0.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9505F, 4.9908F, 2.3734F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r3 = Body31.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(0, 502).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8068F, -6.4923F, -2.9503F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r1 = Body31.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7451F, -8.6476F, 3.1328F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r2 = Body31.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(0, 497).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4218F, -0.7079F, 0.6234F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Body32 = Bodies.addOrReplaceChild("Body32", CubeListBuilder.create(), PartPose.offsetAndRotation(-51.7511F, -40.4717F, -91.6298F, -1.9121F, -0.4642F, -2.215F));

		PartDefinition Leg_r4 = Body32.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(0, 499).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, -2.3674F, 1.5033F, -2.5447F, -0.613F, 1.6654F));

		PartDefinition TorsoBase_r2 = Body32.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(0, 503).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9599F, -1.6167F, -3.4316F, -0.9443F, -0.4081F, -0.0114F));

		PartDefinition Arm_r4 = Body32.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(0, 501).addBox(-1.919F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, 2.1134F, 1.0678F, -0.4749F, 0.0861F, 0.0821F));

		PartDefinition Arm_r5 = Body32.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(0, 501).addBox(-1.9496F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, 3.3228F, 3.853F, -0.6895F, -0.5305F, -0.4982F));

		PartDefinition TorsoBottom_r1 = Body32.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(0, 502).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, 1.1196F, 0.8638F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r2 = Body32.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 497).addBox(-3.7022F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.13F, 4.0992F, 2.9916F, -2.6335F, -0.6629F, 0.1841F));

		PartDefinition Body33 = Bodies.addOrReplaceChild("Body33", CubeListBuilder.create().texOffs(0, 503).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1475F, -6.9152F, -88.6265F, -2.8514F, 1.5427F, 2.4313F));

		PartDefinition Leg_r5 = Body33.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(0, 506).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r3 = Body33.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r6 = Body33.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(0, 500).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7824F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r3 = Body33.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(0, 502).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Body34 = Bodies.addOrReplaceChild("Body34", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.3625F, 3.4351F, -87.7641F, 0.0148F, 0.338F, -2.7357F));

		PartDefinition TorsoBase_r3 = Body34.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(0, 501).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r4 = Body34.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(0, 506).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r5 = Body34.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(0, 499).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r4 = Body34.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 496).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body35 = Bodies.addOrReplaceChild("Body35", CubeListBuilder.create(), PartPose.offsetAndRotation(-65.4238F, -0.4209F, -100.7732F, -1.5681F, 1.3131F, -1.6225F));

		PartDefinition Leg_r6 = Body35.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(0, 499).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8803F, -6.5243F, -1.2902F, -2.0106F, 0.5964F, -0.4842F));

		PartDefinition TorsoBase_r4 = Body35.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(0, 503).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4499F, -0.7882F, -0.449F, -1.4198F, 0.213F, 0.1614F));

		PartDefinition Arm_r7 = Body35.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(0, 501).addBox(-1.081F, -1.1698F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r8 = Body35.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(0, 503).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4173F, 4.1598F, 0.1325F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r2 = Body35.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(0, 502).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body36 = Bodies.addOrReplaceChild("Body36", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.5951F, 2.5305F, -104.8718F, 1.8204F, 1.0398F, -1.1003F));

		PartDefinition TorsoBase_r5 = Body36.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(0, 503).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r9 = Body36.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(0, 501).addBox(-1.081F, -2.3302F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r10 = Body36.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(0, 501).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r6 = Body36.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(0, 502).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r5 = Body36.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(0, 497).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition Body37 = Bodies.addOrReplaceChild("Body37", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9738F, -26.2909F, -110.5991F, 1.1845F, -1.4654F, 1.4465F));

		PartDefinition Arm_r11 = Body37.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(0, 501).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.6609F, 0.5587F, -1.5066F));

		PartDefinition TorsoBase_r6 = Body37.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(0, 503).addBox(-3.5F, -0.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, 2.2954F, -1.5655F, -0.1556F, -0.0458F));

		PartDefinition TorsoTop_r7 = Body37.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(0, 502).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r6 = Body37.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(0, 496).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Body2 = Bodies.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(0, 503).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.1475F, -47.9152F, -36.6265F, -1.6079F, 0.8878F, -1.7272F));

		PartDefinition Leg_r7 = Body2.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(0, 506).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r7 = Body2.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r12 = Body2.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(0, 500).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7824F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r8 = Body2.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(0, 502).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Body3 = Bodies.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.5951F, -52.4695F, -50.8718F, -2.3241F, -1.2471F, 2.2102F));

		PartDefinition TorsoBase_r7 = Body3.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(0, 503).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r13 = Body3.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(0, 501).addBox(-1.081F, -2.3302F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r14 = Body3.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(0, 501).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r9 = Body3.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(0, 502).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r8 = Body3.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(0, 497).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition Body4 = Bodies.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(0, 503).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1475F, -35.9152F, -52.6265F, -2.0224F, 1.4118F, 2.4313F));

		PartDefinition Leg_r8 = Body4.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(0, 506).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r9 = Body4.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r15 = Body4.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(0, 500).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7824F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r10 = Body4.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(0, 502).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Body5 = Bodies.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.3625F, -7.5649F, -50.7641F, 0.0148F, 0.338F, -2.7357F));

		PartDefinition TorsoBase_r8 = Body5.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(0, 501).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r11 = Body5.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(0, 506).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r12 = Body5.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(0, 499).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r10 = Body5.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(0, 496).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body6 = Bodies.addOrReplaceChild("Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.3625F, -12.5649F, -42.7641F, 0.0148F, -0.0547F, -2.8229F));

		PartDefinition TorsoBase_r9 = Body6.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(0, 501).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r13 = Body6.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(0, 506).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r14 = Body6.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(0, 499).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r11 = Body6.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(0, 496).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body7 = Bodies.addOrReplaceChild("Body7", CubeListBuilder.create().texOffs(0, 503).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.1475F, -47.9152F, -36.6265F, -0.9098F, 0.8878F, -1.7272F));

		PartDefinition Leg_r9 = Body7.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(0, 506).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r12 = Body7.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r16 = Body7.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(0, 500).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7824F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r15 = Body7.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(0, 502).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Body8 = Bodies.addOrReplaceChild("Body8", CubeListBuilder.create().texOffs(0, 503).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-40.1475F, -52.9152F, -47.6265F, 0.3037F, -0.8971F, -1.3607F));

		PartDefinition Leg_r10 = Body8.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(0, 506).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r13 = Body8.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(0, 497).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r17 = Body8.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(0, 500).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7824F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r16 = Body8.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(0, 502).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -2.5F, 6.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Tendrils = tail.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(-5.0F, 29.0F, 128.0F));

		PartDefinition Root1 = Tendrils.addOrReplaceChild("Root1", CubeListBuilder.create().texOffs(298, 353).addBox(-1.0F, -3.5F, -3.5F, 20.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.7386F, -22.6373F, -101.7566F, 1.356F, -0.5045F, 0.8281F));

		PartDefinition R1Seg2 = Root1.addOrReplaceChild("R1Seg2", CubeListBuilder.create().texOffs(44, 363).mirror().addBox(-2.0F, -2.5F, -101.5F, 22.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(19.0F, 0.0F, 99.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition R1Seg3 = R1Seg2.addOrReplaceChild("R1Seg3", CubeListBuilder.create().texOffs(86, 294).addBox(-2.0F, -1.5F, -100.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition R1Seg4 = R1Seg3.addOrReplaceChild("R1Seg4", CubeListBuilder.create(), PartPose.offsetAndRotation(11.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition RootSeg_r1 = R1Seg4.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(328, 120).addBox(-6.5F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, -99.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(382, 120).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.2768F, -53.2889F, -114.6486F, 3.0193F, -0.8787F, 1.9188F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril1 = Seg3Tendril1.addOrReplaceChild("Seg4Tendril1", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7342F, 0.1911F, -85.2006F, 0.0809F, -0.8643F, -0.8192F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r1 = Seg2Tendril2.addOrReplaceChild("TendrilSeg_r1", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1409F, -0.072F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition TendrilSeg_r2 = Seg3Tendril2.addOrReplaceChild("TendrilSeg_r2", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(382, 120).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9482F, -53.9074F, -102.2502F, -2.8934F, 0.719F, -2.2464F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(0, 386).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, 0.6364F, 0.1646F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(392, 66).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, -0.3272F, -0.1238F));

		PartDefinition Seg4Tendril2 = Seg3Tendril3.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(108, 392).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, -0.5194F, 0.2391F));

		PartDefinition Bloom = tail.addOrReplaceChild("Bloom", CubeListBuilder.create().texOffs(0, 459).addBox(-4.0F, -2.0324F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.2894F, 32.6244F, 30.6938F, -0.069F, -0.7553F, -2.6609F));

		PartDefinition NPetal_r1 = Bloom.addOrReplaceChild("NPetal_r1", CubeListBuilder.create().texOffs(-16, 412).addBox(0.0F, 0.0F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.9676F, 0.0F, -0.3924F, -0.0167F, -0.0403F));

		PartDefinition SPetal_r1 = Bloom.addOrReplaceChild("SPetal_r1", CubeListBuilder.create().texOffs(-16, 399).addBox(-8.0F, 0.0F, -2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0621F, 1.5133F, 4.3565F, 0.6005F, -0.1084F, 0.1897F));

		PartDefinition WPetal_r1 = Bloom.addOrReplaceChild("WPetal_r1", CubeListBuilder.create().texOffs(-16, 427).addBox(-16.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7716F, 2.8196F, 0.0F, 0.2618F, 0.0F, 0.6109F));

		PartDefinition EPetal_r1 = Bloom.addOrReplaceChild("EPetal_r1", CubeListBuilder.create().texOffs(-16, 443).addBox(3.0F, -0.5F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Tumors2 = tail.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, -27.0F));

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

		PartDefinition Tumors3 = tail.addOrReplaceChild("Tumors3", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, 54.0F));

		PartDefinition Tumor_r31 = Tumors3.addOrReplaceChild("Tumor_r31", CubeListBuilder.create().texOffs(180, 311).addBox(4.6586F, -0.5605F, -17.3304F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.3355F, -21.2731F, 32.0378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition Tumor_r32 = Tumors3.addOrReplaceChild("Tumor_r32", CubeListBuilder.create().texOffs(179, 308).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.2731F, -2.6645F, 37.0378F, 0.7854F, -1.0036F, 0.0F));

		PartDefinition Tumor_r33 = Tumors3.addOrReplaceChild("Tumor_r33", CubeListBuilder.create().texOffs(179, 308).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7269F, -2.6645F, 33.0378F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Tumor_r34 = Tumors3.addOrReplaceChild("Tumor_r34", CubeListBuilder.create().texOffs(179, 308).addBox(-3.5F, -7.5F, 1.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.2398F, -17.5732F, 36.5827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r35 = Tumors3.addOrReplaceChild("Tumor_r35", CubeListBuilder.create().texOffs(179, 308).addBox(-8.6843F, -1.5229F, -4.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.6645F, -19.2731F, 34.7878F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r36 = Tumors3.addOrReplaceChild("Tumor_r36", CubeListBuilder.create().texOffs(185, 315).addBox(-33.5F, -48.5F, -2.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(38.5852F, -0.6645F, 33.1306F, -0.3819F, -0.7073F, -0.4891F));

		PartDefinition Tumor_r37 = Tumors3.addOrReplaceChild("Tumor_r37", CubeListBuilder.create().texOffs(182, 312).addBox(-10.5F, -7.5F, -3.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5852F, 11.3355F, 24.1306F, -0.7418F, 0.0F, 0.5236F));

		PartDefinition Tumor_r38 = Tumors3.addOrReplaceChild("Tumor_r38", CubeListBuilder.create().texOffs(179, 308).addBox(17.0F, -27.0F, -16.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 36.0F, 29.5F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition Tumor_r39 = Tumors3.addOrReplaceChild("Tumor_r39", CubeListBuilder.create().texOffs(179, 308).addBox(-2.0F, -15.0F, -6.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, -4.0F, 34.5F, 0.0F, 0.6545F, 0.5236F));

		PartDefinition Tumor_r40 = Tumors3.addOrReplaceChild("Tumor_r40", CubeListBuilder.create().texOffs(174, 306).addBox(-10.0F, -10.0F, -5.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.7269F, 3.9509F, 25.5755F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition Tumor_r41 = Tumors3.addOrReplaceChild("Tumor_r41", CubeListBuilder.create().texOffs(178, 306).addBox(11.0F, -2.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.5F, 9.0F, 39.5F, 1.2024F, 0.7992F, -0.2097F));

		PartDefinition EndRoot = tail.addOrReplaceChild("EndRoot", CubeListBuilder.create().texOffs(358, 234).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0399F, -4.9719F, 66.1348F, 1.7134F, 0.881F, 2.9598F));

		PartDefinition ESeg1 = EndRoot.addOrReplaceChild("ESeg1", CubeListBuilder.create().texOffs(364, 183).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.4363F));

		PartDefinition ESeg2 = ESeg1.addOrReplaceChild("ESeg2", CubeListBuilder.create().texOffs(414, 316).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.3491F, -0.4363F));

		PartDefinition ESeg3 = ESeg2.addOrReplaceChild("ESeg3", CubeListBuilder.create().texOffs(276, 139).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition EndRoot2 = tail.addOrReplaceChild("EndRoot2", CubeListBuilder.create().texOffs(358, 234).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.9601F, 1.0281F, 75.1348F, 2.2331F, 0.8675F, 0.2664F));

		PartDefinition ESeg4 = EndRoot2.addOrReplaceChild("ESeg4", CubeListBuilder.create().texOffs(364, 183).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, -0.1745F, -0.5672F));

		PartDefinition ESeg5 = ESeg4.addOrReplaceChild("ESeg5", CubeListBuilder.create().texOffs(414, 316).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, -0.2182F, -0.1745F, -0.4363F));

		PartDefinition ESeg6 = ESeg5.addOrReplaceChild("ESeg6", CubeListBuilder.create().texOffs(276, 139).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition EndRoot3 = tail.addOrReplaceChild("EndRoot3", CubeListBuilder.create().texOffs(358, 234).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0398F, 15.0281F, 78.1348F, 0.9665F, 1.3589F, -2.1948F));

		PartDefinition ESeg7 = EndRoot3.addOrReplaceChild("ESeg7", CubeListBuilder.create().texOffs(364, 183).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition ESeg8 = ESeg7.addOrReplaceChild("ESeg8", CubeListBuilder.create().texOffs(414, 316).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition ESeg9 = ESeg8.addOrReplaceChild("ESeg9", CubeListBuilder.create().texOffs(276, 139).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition EndRoot4 = tail.addOrReplaceChild("EndRoot4", CubeListBuilder.create().texOffs(358, 234).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0398F, -10.9719F, 84.1348F, 1.8539F, 1.2535F, 1.8405F));

		PartDefinition ESeg10 = EndRoot4.addOrReplaceChild("ESeg10", CubeListBuilder.create().texOffs(364, 183).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition ESeg11 = ESeg10.addOrReplaceChild("ESeg11", CubeListBuilder.create().texOffs(414, 316).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition ESeg12 = ESeg11.addOrReplaceChild("ESeg12", CubeListBuilder.create().texOffs(276, 139).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.48F));

		PartDefinition Bloom2 = tail.addOrReplaceChild("Bloom2", CubeListBuilder.create().texOffs(0, 459).addBox(-4.0F, -2.0324F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.7106F, -26.3756F, 79.6938F, -0.4987F, -0.5743F, 0.515F));

		PartDefinition NPetal_r2 = Bloom2.addOrReplaceChild("NPetal_r2", CubeListBuilder.create().texOffs(-16, 412).addBox(0.0F, 0.0F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 3.9676F, 0.0F, -0.3924F, -0.0167F, -0.0403F));

		PartDefinition SPetal_r2 = Bloom2.addOrReplaceChild("SPetal_r2", CubeListBuilder.create().texOffs(-16, 399).addBox(-8.0F, 0.0F, -2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0621F, 1.5133F, 4.3565F, 0.6005F, -0.1084F, 0.1897F));

		PartDefinition WPetal_r2 = Bloom2.addOrReplaceChild("WPetal_r2", CubeListBuilder.create().texOffs(-16, 427).addBox(-16.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7716F, 2.8196F, 0.0F, 0.2618F, 0.0F, 0.6109F));

		PartDefinition EPetal_r2 = Bloom2.addOrReplaceChild("EPetal_r2", CubeListBuilder.create().texOffs(-16, 443).addBox(3.0F, -0.5F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float moveSeg1 = Mth.cos(ageInTicks/6)/7;
		float moveSeg2 = Mth.sin(ageInTicks/8)/5;
		float moveSeg3 = Mth.cos(ageInTicks/6)/6;
		float moveSeg4 = Mth.cos(ageInTicks/5)/5;
		float backTentacle = Mth.sin(ageInTicks/6)/6;
		float backTentacle2 = Mth.sin(ageInTicks/7)/6;
		float backTentacle3 = Mth.cos(ageInTicks/6)/7;
		float backTentacle4 = Mth.cos(ageInTicks/8)/6;
		this.animateTentacleZ(Root1,moveSeg1);
		this.animateTentacleZ(R1Seg2,moveSeg1);
		this.animateTentacleZ(R1Seg3,moveSeg1);
		this.animateTentacleZ(R1Seg4,moveSeg1);
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
		tail.zRot = entity.getSpin();
		this.animateTentacleZ(this.EndRoot,backTentacle);
		this.animateTentacleZ(this.ESeg1,backTentacle);
		this.animateTentacleZ(this.ESeg2,backTentacle);
		this.animateTentacleZ(this.ESeg3,backTentacle);
		this.animateTentacleX(this.EndRoot2,backTentacle2);
		this.animateTentacleY(this.ESeg4,backTentacle2);
		this.animateTentacleY(this.ESeg5,backTentacle2);
		this.animateTentacleY(this.ESeg6,backTentacle2);
		this.animateTentacleY(this.EndRoot3,backTentacle3);
		this.animateTentacleY(this.ESeg7,backTentacle3);
		this.animateTentacleY(this.ESeg8,backTentacle3);
		this.animateTentacleY(this.ESeg9,backTentacle3);
		this.animateTentacleZ(this.EndRoot4,backTentacle4);
		this.animateTentacleZ(this.ESeg10,backTentacle4);
		this.animateTentacleZ(this.ESeg11,backTentacle4);
		this.animateTentacleZ(this.ESeg12,backTentacle4);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}