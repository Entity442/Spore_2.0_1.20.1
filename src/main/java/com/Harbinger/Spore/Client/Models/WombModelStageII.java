package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Organoids.BiomassReformator;
import com.Harbinger.Spore.Spore;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class WombModelStageII<T extends BiomassReformator> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "wombmodelstageii"), "main");
	private final ModelPart Womb;

	public WombModelStageII(ModelPart root) {
		this.Womb = root.getChild("Womb");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Womb = partdefinition.addOrReplaceChild("Womb", CubeListBuilder.create(), PartPose.offset(2.0F, 19.0F, 0.0F));

		PartDefinition TumorBase = Womb.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-15.0F, -12.0F, 3.0F));

		PartDefinition group1 = TumorBase.addOrReplaceChild("group1", CubeListBuilder.create(), PartPose.offset(26.3195F, 8.5828F, -20.0F));

		PartDefinition tumor_r1 = group1.addOrReplaceChild("tumor_r1", CubeListBuilder.create().texOffs(22, 17).addBox(-7.61F, -3.9503F, -5.7662F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.0951F, -0.9829F, -0.6062F));

		PartDefinition tumor_r2 = group1.addOrReplaceChild("tumor_r2", CubeListBuilder.create().texOffs(23, 18).addBox(3.7416F, -10.9028F, 11.2904F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.6485F, 1.2494F, 16.0827F, -0.3477F, -0.6765F, -0.4172F));

		PartDefinition tumor_r3 = group1.addOrReplaceChild("tumor_r3", CubeListBuilder.create().texOffs(23, 18).addBox(0.134F, -10.8163F, -26.4235F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-50.6485F, 1.2494F, 18.0827F, 1.5918F, -1.3797F, -1.2929F));

		PartDefinition tumor_r4 = group1.addOrReplaceChild("tumor_r4", CubeListBuilder.create().texOffs(23, 18).addBox(-30.0229F, 8.0238F, -15.6942F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.6485F, 1.2494F, 39.0827F, -0.4021F, -0.4852F, 0.4572F));

		PartDefinition group2 = TumorBase.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offset(41.3166F, 3.4417F, -7.7639F));

		PartDefinition tumor_r5 = group2.addOrReplaceChild("tumor_r5", CubeListBuilder.create().texOffs(23, 18).addBox(-12.4002F, -6.7957F, -7.0475F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 1.0472F, -0.2182F, 0.0F));

		PartDefinition tumor_r6 = group2.addOrReplaceChild("tumor_r6", CubeListBuilder.create().texOffs(16, 24).addBox(-5.4559F, -3.4726F, -5.6063F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 8.0F, 3.0F, -0.4146F, -0.1754F, 0.4146F));

		PartDefinition tumor_r7 = group2.addOrReplaceChild("tumor_r7", CubeListBuilder.create().texOffs(23, 18).addBox(-13.0F, 1.0F, 1.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.3558F, -2.4417F, 22.7639F, -0.48F, -0.3927F, -0.3491F));

		PartDefinition tumor_r8 = group2.addOrReplaceChild("tumor_r8", CubeListBuilder.create().texOffs(23, 18).addBox(-14.0128F, 0.3301F, -0.8276F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.9971F, 8.1411F, 1.7639F, -1.1081F, -0.5553F, 0.6291F));

		PartDefinition group3 = TumorBase.addOrReplaceChild("group3", CubeListBuilder.create(), PartPose.offset(34.3558F, 2.5583F, -3.2361F));

		PartDefinition tumor_r9 = group3.addOrReplaceChild("tumor_r9", CubeListBuilder.create().texOffs(23, 18).addBox(-0.8415F, -2.6637F, -4.81F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.7574F, 1.1698F, 0.487F));

		PartDefinition tumor_r10 = group3.addOrReplaceChild("tumor_r10", CubeListBuilder.create().texOffs(31, 22).addBox(-9.0F, -9.0F, -11.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.3558F, 17.4417F, -10.7639F, -0.48F, 0.3927F, 0.3491F));

		PartDefinition tumor_r11 = group3.addOrReplaceChild("tumor_r11", CubeListBuilder.create().texOffs(23, 18).addBox(-12.4002F, 0.7957F, 1.0475F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -2.0F, 1.0472F, 0.2182F, 0.0F));

		PartDefinition tumor_r12 = group3.addOrReplaceChild("tumor_r12", CubeListBuilder.create().texOffs(23, 18).addBox(-13.0F, 1.0F, -11.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.395F, -0.5583F, 8.2361F, 0.48F, 0.3927F, -0.3491F));

		PartDefinition group4 = TumorBase.addOrReplaceChild("group4", CubeListBuilder.create(), PartPose.offset(4.7103F, 0.1678F, -24.0827F));

		PartDefinition tumor_r13 = group4.addOrReplaceChild("tumor_r13", CubeListBuilder.create().texOffs(23, 18).addBox(-29.0229F, -16.0238F, 7.6942F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -0.4021F, 0.4852F, -0.4572F));

		PartDefinition tumor_r14 = group4.addOrReplaceChild("tumor_r14", CubeListBuilder.create().texOffs(23, 18).addBox(0.134F, -1.1837F, 14.4235F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, 9.0F, 19.0F, 1.5918F, 1.3797F, 1.2929F));

		PartDefinition tumor_r15 = group4.addOrReplaceChild("tumor_r15", CubeListBuilder.create().texOffs(22, 17).addBox(-7.61F, -6.0497F, -4.2338F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.6485F, 2.2494F, 32.0827F, -0.0951F, 0.9829F, 0.6062F));

		PartDefinition tumor_r16 = group4.addOrReplaceChild("tumor_r16", CubeListBuilder.create().texOffs(14, 8).addBox(-32.7869F, 0.7216F, -7.7728F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6485F, 6.2494F, 27.0827F, 0.6953F, 0.2268F, 0.3303F));

		PartDefinition WatchingTendril1 = Womb.addOrReplaceChild("WatchingTendril1", CubeListBuilder.create().texOffs(174, 277).mirror().addBox(-2.0F, -19.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.9632F, -11.8697F, 0.4619F, 2.49F, -1.2784F, -2.1271F));

		PartDefinition BodyW2 = WatchingTendril1.addOrReplaceChild("BodyW2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.19F, -2.6555F, 4.1262F, 1.8212F, 1.2114F, -2.9066F));

		PartDefinition Arm_r1 = BodyW2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(18, 78).mirror().addBox(-7.4781F, -0.4371F, -1.2876F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.2366F, -0.5182F, -2.8999F, -0.037F, 1.1318F, -0.3131F));

		PartDefinition TorsoTop_r1 = BodyW2.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(86, 56).mirror().addBox(0.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.06F, -0.5945F, -5.1262F, -0.0839F, 0.3706F, 0.4731F));

		PartDefinition Brain3 = BodyW2.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(7.8093F, -2.4635F, -11.388F, -1.9906F, -0.8481F, -0.2294F));

		PartDefinition Seg1WatchingTendril2 = WatchingTendril1.addOrReplaceChild("Seg1WatchingTendril2", CubeListBuilder.create().texOffs(188, 314).mirror().addBox(-1.5F, -20.0F, -1.5F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, -0.9839F, -0.0261F, 0.1563F));

		PartDefinition BodyW21 = Seg1WatchingTendril2.addOrReplaceChild("BodyW21", CubeListBuilder.create().texOffs(24, 67).mirror().addBox(-2.6813F, -2.5107F, -0.7827F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1217F, -11.835F, 1.2827F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Arm_r2 = BodyW21.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(50, 68).mirror().addBox(-2.0F, -1.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.1813F, -4.5107F, 0.2173F, -0.3361F, -0.2071F, -0.532F));

		PartDefinition Leg_r1 = BodyW21.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(48, 67).mirror().addBox(-2.0F, 0.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8187F, 1.4893F, 1.2173F, -0.7764F, 0.5189F, -0.312F));

		PartDefinition TorsoTop_r2 = BodyW21.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(64, 52).mirror().addBox(-4.25F, -6.0F, -2.5F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3187F, -1.5107F, 1.2173F, 0.3054F, 0.0F, 0.0F));

		PartDefinition HeadW2 = BodyW21.addOrReplaceChild("HeadW2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3187F, -7.5107F, 0.2173F, 1.3811F, 0.1084F, 0.5133F));

		PartDefinition Eye = HeadW2.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(238, 244).mirror().addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offsetAndRotation(3.1359F, 3.1977F, 1.0846F, -2.4115F, -0.1498F, -3.0101F));

		PartDefinition pupil = Eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(346, 323).mirror().addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)).mirror(false), PartPose.offset(0.0171F, 0.0058F, -3.378F));

		PartDefinition TumorsW3 = BodyW21.addOrReplaceChild("TumorsW3", CubeListBuilder.create(), PartPose.offset(-0.1813F, -3.5107F, -2.7827F));

		PartDefinition Tumor5_r1 = TumorsW3.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(33, 0).mirror().addBox(-2.5F, -1.5F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.576F, -2.7394F, 1.2357F, 0.0523F, -0.1219F, 0.6044F));

		PartDefinition Tumor4_r1 = TumorsW3.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(41, 25).mirror().addBox(-0.172F, -0.5697F, -1.1501F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1032F, 1.7896F, 0.1791F, 0.0523F, -0.1219F, 0.6044F));

		PartDefinition Tumor3_r1 = TumorsW3.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(44, 0).mirror().addBox(-1.359F, -3.7504F, -2.4644F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1032F, 1.7896F, 0.1791F, 0.0909F, -0.0967F, 0.2541F));

		PartDefinition Tumor2_r1 = TumorsW3.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(84, 35).mirror().addBox(-2.8459F, -4.1761F, -2.7412F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1032F, 1.7896F, 0.1791F, 0.4203F, 0.4928F, -0.2831F));

		PartDefinition Tendril = Womb.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7731F, -11.0995F, 25.254F, 0.0F, 0.7854F, 0.0F));

		PartDefinition RootSeg_r1 = Tendril.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(156, 292).addBox(-1.5F, -6.0F, -1.75F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril = Tendril.addOrReplaceChild("Seg2Tendril", CubeListBuilder.create().texOffs(2, 297).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, -0.3442F, -0.0594F, -0.1642F));

		PartDefinition Seg3Tendril = Seg2Tendril.addOrReplaceChild("Seg3Tendril", CubeListBuilder.create().texOffs(27, 329).addBox(-0.5F, -15.0F, -0.5F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, 0.4549F, -0.1586F, 0.3123F));

		PartDefinition Tendril2 = Womb.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.8761F, -0.8674F, -10.1583F, 0.807F, 0.8465F, 0.3972F));

		PartDefinition RootSeg_r2 = Tendril2.addOrReplaceChild("RootSeg_r2", CubeListBuilder.create().texOffs(134, 291).addBox(-1.5F, -6.0F, -2.25F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(176, 229).addBox(-1.0F, -14.0F, -2.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.75F, -0.5033F, 0.0714F, 0.317F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(28, 329).addBox(0.0F, -14.0F, -1.0F, 1.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.4106F, -0.1274F, -0.2783F));

		PartDefinition Tendril3 = Womb.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(11.3908F, 0.0F, -3.4218F, 1.1928F, -0.4767F, -0.4817F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9368F, -10.3773F, -3.0805F, -0.1745F, 0.0F, 0.5236F));

		PartDefinition RootSeg_r3 = Seg2Tendril3.addOrReplaceChild("RootSeg_r3", CubeListBuilder.create().texOffs(172, 302).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril3Fungus = Seg2Tendril3.addOrReplaceChild("Seg2Tendril3Fungus", CubeListBuilder.create(), PartPose.offset(0.1429F, -9.9999F, 0.8043F));

		PartDefinition Tumor_r17 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(69, 23).addBox(0.25F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7837F, -3.5501F, 1.1675F, -2.2198F, -0.3183F, 0.7016F));

		PartDefinition Tumor_r18 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(69, 23).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.9752F, -2.6447F, 0.7136F, -1.7131F, 0.0729F, 1.1776F));

		PartDefinition Tumor_r19 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(69, 23).addBox(-3.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8578F, -1.6395F, -0.1184F, -2.4069F, -0.1222F, 1.0027F));

		PartDefinition Fungus_r1 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 7.9499F, -0.8325F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Fungus_r2 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 7.9499F, -0.8325F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r3 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 1.9499F, -0.9325F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r4 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, -2.0501F, -1.8325F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r5 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, -2.0501F, -1.8325F, -0.7227F, -0.2399F, 0.1871F));

		PartDefinition Fungus_r6 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 3.9499F, 0.0675F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(26, 328).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.3655F, -0.147F, 0.3655F));

		PartDefinition Seg4Tendril3 = Seg3Tendril3.addOrReplaceChild("Seg4Tendril3", CubeListBuilder.create().texOffs(38, 346).addBox(-0.5F, -13.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -14.5F, 0.0F, 0.546F, -0.1623F, 0.2599F));

		PartDefinition Maw = Womb.addOrReplaceChild("Maw", CubeListBuilder.create().texOffs(8, 108).addBox(-10.9571F, 1.2514F, -13.5653F, 27.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -10.0F, 4.0F, 0.2736F, 0.5648F, 0.1034F));

		PartDefinition BackMaw = Maw.addOrReplaceChild("BackMaw", CubeListBuilder.create().texOffs(196, 226).mirror().addBox(-7.0F, -12.0F, -2.0F, 14.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9641F, 0.0F, 11.2058F, -0.5416F, -0.0376F, -0.1605F));

		PartDefinition Teeth_r1 = BackMaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.7791F, -5.467F, -4.8761F, -0.2365F, -0.1422F, 0.2657F));

		PartDefinition Teeth_r2 = BackMaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.4637F, -4.4295F, -7.2351F, 0.0857F, -0.7702F, -0.1198F));

		PartDefinition Teeth_r3 = BackMaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -3.0F, -1.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.7571F, -6.6464F, -5.6111F, 0.3458F, 0.5257F, 0.7231F));

		PartDefinition Teeth_r4 = BackMaw.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(4, -2).mirror().addBox(0.0F, -7.5F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.4024F, -3.5905F, -3.8889F, -0.1848F, 1.1264F, -0.2041F));

		PartDefinition Teeth_r5 = BackMaw.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -5.5F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, -10.0F, -2.5F, 0.0F, -0.4363F, 0.7854F));

		PartDefinition Teeth_r6 = BackMaw.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(4, -2).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, -8.0F, -3.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Teeth_r7 = BackMaw.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -8.0F, -3.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition left_r1 = BackMaw.addOrReplaceChild("left_r1", CubeListBuilder.create().texOffs(244, 52).mirror().addBox(1.0F, 2.0F, -4.0F, 10.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0718F, -15.25F, 2.0F, 0.3084F, 0.7245F, 0.5775F));

		PartDefinition right_r1 = BackMaw.addOrReplaceChild("right_r1", CubeListBuilder.create().texOffs(92, 228).mirror().addBox(-14.0F, 4.0F, -4.0F, 14.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, -16.0F, 2.0F, 0.1553F, -0.456F, -0.3415F));

		PartDefinition BackMiddleMaw = BackMaw.addOrReplaceChild("BackMiddleMaw", CubeListBuilder.create().texOffs(192, 88).mirror().addBox(-11.0F, -15.0F, -1.0F, 17.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -10.0F, -0.5F, 0.7145F, -0.1064F, -0.1636F));

		PartDefinition HeadLeft_r1 = BackMiddleMaw.addOrReplaceChild("HeadLeft_r1", CubeListBuilder.create().texOffs(57, 82).mirror().addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-10.6682F, -15.4751F, 0.0869F, 0.1202F, 0.0101F, -0.6905F));

		PartDefinition HeadRightTeeth_r1 = BackMiddleMaw.addOrReplaceChild("HeadRightTeeth_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, 0.8F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-4.9326F, -14.7795F, -0.4092F, -0.4759F, 0.0749F, 0.1074F));

		PartDefinition HeadRight_r1 = BackMiddleMaw.addOrReplaceChild("HeadRight_r1", CubeListBuilder.create().texOffs(83, 68).addBox(-4.0F, -4.8F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.9326F, -14.7795F, -0.4092F, -0.4759F, 0.0749F, 0.1074F));

		PartDefinition Teeth_r8 = BackMiddleMaw.addOrReplaceChild("Teeth_r8", CubeListBuilder.create().texOffs(0, -1).mirror().addBox(1.0F, -9.0F, -1.25F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.9283F, -7.1819F, -1.1798F, -0.0331F, 0.2395F, 0.4995F));

		PartDefinition Teeth_r9 = BackMiddleMaw.addOrReplaceChild("Teeth_r9", CubeListBuilder.create().texOffs(4, -2).mirror().addBox(0.0F, -7.0F, -1.5F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.9283F, -7.1819F, -1.1798F, 0.0018F, 0.3607F, -0.3622F));

		PartDefinition Teeth_r10 = BackMiddleMaw.addOrReplaceChild("Teeth_r10", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -4.5F, -1.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.7399F, -8.6351F, -1.9897F, -0.0555F, 0.3961F, -0.9728F));

		PartDefinition BackMiddleBody1 = BackMiddleMaw.addOrReplaceChild("BackMiddleBody1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1936F, -5.5983F, -0.1471F, -1.4046F, 0.3499F, -0.234F));

		PartDefinition BackMiddleJaw = BackMiddleMaw.addOrReplaceChild("BackMiddleJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(8.2552F, -10.2661F, -2.3141F, 0.2058F, 0.284F, 0.6404F));

		PartDefinition HeadLeftTeeth_r1 = BackMiddleJaw.addOrReplaceChild("HeadLeftTeeth_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, 0.8F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(83, 68).mirror().addBox(-4.0F, -4.8F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-13.3639F, 16.4178F, -6.0504F, -0.8156F, -0.8354F, -1.3671F));

		PartDefinition HeadRight_r2 = BackMiddleJaw.addOrReplaceChild("HeadRight_r2", CubeListBuilder.create().texOffs(32, 53).mirror().addBox(-4.0F, -2.5F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-7.9345F, 0.2951F, 0.1994F, -1.0142F, -0.195F, -0.1943F));

		PartDefinition HeadCenter_r1 = BackMiddleJaw.addOrReplaceChild("HeadCenter_r1", CubeListBuilder.create().texOffs(83, 68).mirror().addBox(-2.5F, -4.25F, -4.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-2.9922F, -0.6961F, 0.9824F, -0.2161F, 0.149F, 0.551F));

		PartDefinition BackMiddleJawFoliage1 = BackMiddleJaw.addOrReplaceChild("BackMiddleJawFoliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.563F, -2.839F, -0.0256F, -0.6707F, 0.445F, 2.4606F));

		PartDefinition Petal2_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 109).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.8639F, 0.5245F, -2.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1361F, 0.5245F, 3.0399F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition BackTopJawFoliage2 = BackMiddleMaw.addOrReplaceChild("BackTopJawFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1785F, -18.4313F, 2.0856F, 0.3337F, 0.9372F, -2.575F));

		PartDefinition Petal4_r1 = BackTopJawFoliage2.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.589F, -0.0485F, -0.4225F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = BackTopJawFoliage2.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9286F, 0.0196F, -0.4225F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal2_r2 = BackTopJawFoliage2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(5, 117).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.411F, -0.0485F, -4.4225F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = BackTopJawFoliage2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(-7, 109).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.411F, -0.0485F, 3.5775F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition BackTopJawFoliage3 = BackMiddleMaw.addOrReplaceChild("BackTopJawFoliage3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.9356F, -15.8228F, -3.2602F, -0.6368F, 0.6604F, 2.46F));

		PartDefinition Petal4_r2 = BackTopJawFoliage3.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(5, 117).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1361F, -0.2255F, -0.4601F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = BackTopJawFoliage3.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 109).mirror().addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.3815F, -1.1573F, -0.4601F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal2_r3 = BackTopJawFoliage3.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1361F, 0.7745F, -2.4601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = BackTopJawFoliage3.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(-7, 109).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1361F, 0.7745F, 3.5399F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition RightMaw = Maw.addOrReplaceChild("RightMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.865F, -1.2269F, -13.0761F, 0.0F, 0.2182F, 0.0F));

		PartDefinition Teeth_r11 = RightMaw.addOrReplaceChild("Teeth_r11", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, 0.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.2378F, -5.24F, 3.8413F, -3.097F, -0.3319F, 2.2763F));

		PartDefinition Teeth_r12 = RightMaw.addOrReplaceChild("Teeth_r12", CubeListBuilder.create().texOffs(4, -2).addBox(3.0F, -9.5F, -3.25F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7847F, -3.3635F, 1.1861F, 2.5879F, 0.5934F, 2.1912F));

		PartDefinition Teeth_r13 = RightMaw.addOrReplaceChild("Teeth_r13", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.5F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2022F, -8.6595F, -1.3912F, 2.6072F, -0.4655F, -2.3585F));

		PartDefinition Teeth_r14 = RightMaw.addOrReplaceChild("Teeth_r14", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.5F, 0.25F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1407F, -6.3635F, 1.2496F, 2.9388F, -0.0308F, 3.0485F));

		PartDefinition Teeth_r15 = RightMaw.addOrReplaceChild("Teeth_r15", CubeListBuilder.create().texOffs(0, -2).addBox(-12.0F, -11.0F, 5.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.4442F, -7.7731F, 11.3536F, 2.9485F, -0.2926F, -2.764F));

		PartDefinition BaseRight_r1 = RightMaw.addOrReplaceChild("BaseRight_r1", CubeListBuilder.create().texOffs(238, 226).addBox(-11.5F, -4.5F, 5.0F, 17.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.106F, -7.2731F, -8.511F, 0.2618F, 0.3054F, 0.0F));

		PartDefinition BaseLeft_r1 = RightMaw.addOrReplaceChild("BaseLeft_r1", CubeListBuilder.create().texOffs(255, 3).addBox(-4.0F, -3.0F, -1.0F, 9.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5199F, -5.7731F, -1.8521F, 0.0F, -0.48F, 0.0F));

		PartDefinition RightHeads = RightMaw.addOrReplaceChild("RightHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(3.546F, -14.0738F, -3.4307F, 0.534F, -0.1886F, -0.1104F));

		PartDefinition HeadRightTeeth_r2 = RightHeads.addOrReplaceChild("HeadRightTeeth_r2", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-6.2692F, -1.4694F, 3.8778F, 2.8266F, -0.1264F, -2.1838F));

		PartDefinition HeadRight_r3 = RightHeads.addOrReplaceChild("HeadRight_r3", CubeListBuilder.create().texOffs(83, 69).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.3565F, -3.3533F, 0.4134F, 2.8266F, -0.1264F, -2.1838F));

		PartDefinition RightMiddleMaw = RightMaw.addOrReplaceChild("RightMiddleMaw", CubeListBuilder.create().texOffs(248, 207).addBox(-3.0F, -11.0F, -1.0F, 9.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4687F, -11.4255F, -2.3929F, 0.7524F, 0.173F, 0.3443F));

		PartDefinition Teeth_r16 = RightMiddleMaw.addOrReplaceChild("Teeth_r16", CubeListBuilder.create().texOffs(4, -2).addBox(0.7514F, -2.8059F, -0.4294F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3019F, -6.6327F, 1.7782F, 3.0806F, 0.6082F, 3.0352F));

		PartDefinition Teeth_r17 = RightMiddleMaw.addOrReplaceChild("Teeth_r17", CubeListBuilder.create().texOffs(0, -2).addBox(1.4118F, -3.1658F, 0.5956F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3019F, -6.6327F, 1.7782F, 3.0173F, -0.51F, -2.891F));

		PartDefinition FrontTopHeads = RightMiddleMaw.addOrReplaceChild("FrontTopHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.986F, -7.2725F, 2.4645F, 0.5917F, 0.0992F, -0.3806F));

		PartDefinition HeadLeftTeeth_r2 = FrontTopHeads.addOrReplaceChild("HeadLeftTeeth_r2", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.3424F, 0.4963F, 1.5031F, -3.0107F, 0.0F, 3.0107F));

		PartDefinition HeadLeft_r2 = FrontTopHeads.addOrReplaceChild("HeadLeft_r2", CubeListBuilder.create().texOffs(83, 68).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.8339F, -3.3659F, -0.5056F, -3.0107F, 0.0F, 3.0107F));

		PartDefinition FrontTopJawFoliage4 = FrontTopHeads.addOrReplaceChild("FrontTopJawFoliage4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1532F, -6.2184F, 1.4807F, 0.6707F, 0.445F, -2.4606F));

		PartDefinition Petal4_r3 = FrontTopJawFoliage4.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, 0.5245F, -0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r3 = FrontTopJawFoliage4.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3815F, -1.4073F, -0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r4 = FrontTopJawFoliage4.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8639F, 0.5245F, 2.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r4 = FrontTopJawFoliage4.addOrReplaceChild("Petal1_r4", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.5245F, -3.0399F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition LeftMaw = Maw.addOrReplaceChild("LeftMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(20.1903F, -1.7488F, -4.7152F, -1.5385F, 0.2806F, -0.3F));

		PartDefinition HeadRight_r4 = LeftMaw.addOrReplaceChild("HeadRight_r4", CubeListBuilder.create().texOffs(32, 52).addBox(2.061F, -8.6473F, 0.8101F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2372F, -1.0913F, -3.882F, 0.2728F, 0.4908F, 2.2174F));

		PartDefinition HeadLeftTeeth_r3 = LeftMaw.addOrReplaceChild("HeadLeftTeeth_r3", CubeListBuilder.create().texOffs(0, 19).addBox(-1.7753F, -0.3618F, -3.4523F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2372F, -1.0913F, -3.882F, -0.1309F, 0.0F, 1.9199F));

		PartDefinition HeadLeft_r3 = LeftMaw.addOrReplaceChild("HeadLeft_r3", CubeListBuilder.create().texOffs(81, 89).addBox(-1.7753F, -6.3618F, -3.4523F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2372F, -1.0913F, -3.882F, -0.1309F, 0.0F, 1.9199F));

		PartDefinition HeadLeftTeeth_r4 = LeftMaw.addOrReplaceChild("HeadLeftTeeth_r4", CubeListBuilder.create().texOffs(3, 19).addBox(-5.0743F, -1.8312F, -1.8985F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(57, 82).addBox(-5.0743F, -8.4312F, -1.8985F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2372F, -1.0913F, -3.882F, 0.275F, 0.3751F, 1.2098F));

		PartDefinition HeadRightTeeth_r3 = LeftMaw.addOrReplaceChild("HeadRightTeeth_r3", CubeListBuilder.create().texOffs(0, 19).addBox(-10.1965F, -3.7201F, -3.8252F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(83, 68).addBox(-10.1965F, -9.3201F, -3.8252F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2372F, -1.0913F, -3.882F, 0.1148F, 0.4411F, 0.9696F));

		PartDefinition RightJawFoliage = LeftMaw.addOrReplaceChild("RightJawFoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(3.2318F, -8.6525F, -5.5231F, -0.5672F, 0.0F, -0.6545F));

		PartDefinition Petal4_r4 = RightJawFoliage.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r4 = RightJawFoliage.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r5 = RightJawFoliage.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -3.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r5 = RightJawFoliage.addOrReplaceChild("Petal1_r5", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition RightJawFoliage6 = LeftMaw.addOrReplaceChild("RightJawFoliage6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.6163F, 8.5464F, -3.8261F, 1.1042F, -0.5071F, -1.5154F));

		PartDefinition Petal4_r5 = RightJawFoliage6.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1016F, -0.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r5 = RightJawFoliage6.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r6 = RightJawFoliage6.addOrReplaceChild("Petal2_r6", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -3.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r6 = RightJawFoliage6.addOrReplaceChild("Petal1_r6", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition IncompleteCalamity = Womb.addOrReplaceChild("IncompleteCalamity", CubeListBuilder.create().texOffs(135, 4).mirror().addBox(-5.9469F, -5.0517F, -7.1046F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9738F, -15.7566F, 0.8858F, 0.0975F, 0.0661F, 0.2583F));

		PartDefinition Teeth_r18 = IncompleteCalamity.addOrReplaceChild("Teeth_r18", CubeListBuilder.create().texOffs(4, -2).mirror().addBox(0.0F, -3.5F, 0.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.5242F, 0.9652F, -4.4851F, 1.344F, 0.8707F, -1.9431F));

		PartDefinition Teeth_r19 = IncompleteCalamity.addOrReplaceChild("Teeth_r19", CubeListBuilder.create().texOffs(4, -2).mirror().addBox(0.0F, -5.5F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.8815F, -5.6934F, -0.9538F, 1.3481F, -0.4359F, -2.6413F));

		PartDefinition Teeth_r20 = IncompleteCalamity.addOrReplaceChild("Teeth_r20", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -6.0F, -0.25F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.7087F, 2.2284F, 8.4968F, -2.8609F, -0.0852F, 2.9226F));

		PartDefinition tumor_r20 = IncompleteCalamity.addOrReplaceChild("tumor_r20", CubeListBuilder.create().texOffs(149, 14).mirror().addBox(-0.5F, -6.5F, -21.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.4547F, 5.7521F, 7.9998F, 0.3596F, -0.4257F, -0.6019F));

		PartDefinition tumor_r21 = IncompleteCalamity.addOrReplaceChild("tumor_r21", CubeListBuilder.create().texOffs(146, 15).mirror().addBox(-2.5F, -3.5F, -4.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.4547F, 5.7521F, 6.9998F, 0.3596F, -0.4257F, -0.6019F));

		PartDefinition tumor_r22 = IncompleteCalamity.addOrReplaceChild("tumor_r22", CubeListBuilder.create().texOffs(148, 16).mirror().addBox(2.0F, 3.0F, 6.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(141, 10).mirror().addBox(7.0F, 7.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.2424F, 0.6824F, -3.191F, 0.6773F, 0.1099F, -0.4105F));

		PartDefinition tumor_r23 = IncompleteCalamity.addOrReplaceChild("tumor_r23", CubeListBuilder.create().texOffs(144, 14).mirror().addBox(13.0F, -4.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.2424F, 2.6824F, -3.191F, 0.6773F, 0.1099F, -0.4105F));

		PartDefinition tumor_r24 = IncompleteCalamity.addOrReplaceChild("tumor_r24", CubeListBuilder.create().texOffs(136, 5).mirror().addBox(10.4002F, -19.2043F, 4.0475F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.1692F, 12.5218F, 1.3373F, 1.0472F, -0.2182F, 0.0F));

		PartDefinition CalamityBody = IncompleteCalamity.addOrReplaceChild("CalamityBody", CubeListBuilder.create(), PartPose.offsetAndRotation(5.1723F, -1.3085F, 5.5291F, -1.7353F, 1.0146F, -1.2367F));

		PartDefinition Arm_r3 = CalamityBody.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(0, 90).mirror().addBox(-8.4781F, -1.4371F, -1.2876F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.7693F, -3.2271F, 2.7196F, -0.8604F, 0.255F, -1.1657F));

		PartDefinition TorsoBase_r1 = CalamityBody.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(1, 99).mirror().addBox(-2.75F, -0.25F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.376F, 1.0111F, 1.8956F, -0.3988F, 0.2706F, -1.2547F));

		PartDefinition TorsoTop_r3 = CalamityBody.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(104, 36).mirror().addBox(0.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4072F, 1.6966F, 0.4934F, -0.0177F, 0.4775F, -0.2877F));

		PartDefinition CcalamityBodyHeadGroup = IncompleteCalamity.addOrReplaceChild("CcalamityBodyHeadGroup", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.9492F, -2.3562F, -1.0224F, -2.5477F, -1.2871F, 0.5738F));

		PartDefinition HeadRightTeeth_r4 = CcalamityBodyHeadGroup.addOrReplaceChild("HeadRightTeeth_r4", CubeListBuilder.create().texOffs(0, 19).addBox(-5.25F, 3.35F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(81, 89).mirror().addBox(-5.25F, -3.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-5.5847F, -3.8175F, -2.2745F, -0.127F, 0.1191F, -0.9494F));

		PartDefinition HeadLeftTeeth_r5 = CcalamityBodyHeadGroup.addOrReplaceChild("HeadLeftTeeth_r5", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, 0.8F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(83, 68).mirror().addBox(-4.0F, -4.8F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(3.6648F, -1.6202F, -2.0442F, -0.2992F, -0.3027F, 0.3079F));

		PartDefinition Foliage1 = CcalamityBodyHeadGroup.addOrReplaceChild("Foliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.2941F, -4.139F, -2.454F, 0.1745F, 0.0F, 0.6545F));

		PartDefinition Petal4_r6 = Foliage1.addOrReplaceChild("Petal4_r6", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.339F, -0.4515F, -0.9225F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r6 = Foliage1.addOrReplaceChild("Petal3_r6", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.1786F, 1.4804F, -0.9225F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r7 = Foliage1.addOrReplaceChild("Petal2_r7", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.339F, -0.4515F, -2.9225F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r7 = Foliage1.addOrReplaceChild("Petal1_r7", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.339F, -0.4515F, 3.0775F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition Foliage2 = CcalamityBodyHeadGroup.addOrReplaceChild("Foliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.381F, -1.3176F, -1.9318F, 0.7479F, 0.5522F, -0.6593F));

		PartDefinition Petal4_r7 = Foliage2.addOrReplaceChild("Petal4_r7", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r7 = Foliage2.addOrReplaceChild("Petal3_r7", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.416F, 0.0992F, -1.161F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r8 = Foliage2.addOrReplaceChild("Petal2_r8", CubeListBuilder.create().texOffs(5, 117).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8984F, -1.8326F, -2.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r8 = Foliage2.addOrReplaceChild("Petal1_r8", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8984F, -1.8326F, 2.839F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition Chef = Womb.addOrReplaceChild("Chef", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.4946F, 3.0F, 2.4564F, 3.0107F, -1.309F, 3.1416F));

		PartDefinition BiomassBase = Chef.addOrReplaceChild("BiomassBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition Biomass_r1 = BiomassBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(44, 27).mirror().addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.1551F, -1.9228F, 0.582F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r2 = BiomassBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(44, 27).mirror().addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.038F, -1.586F, 8.47F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r3 = BiomassBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(44, 27).mirror().addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.3366F, -2.6455F, -0.5176F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Biomass_r4 = BiomassBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(44, 27).mirror().addBox(-1.0F, 6.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.1706F, 0.1996F, -0.7153F));

		PartDefinition Body1 = Chef.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-4.9198F, -5.1943F, -2.2372F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.9198F, -0.7679F, 5.3403F, -0.4331F, 0.0552F, 0.1188F));

		PartDefinition Arm_r4 = Body1.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(48, 67).mirror().addBox(-0.2091F, 0.5332F, 52.3101F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0802F, -2.1651F, -53.4788F, 0.1739F, 0.0151F, -0.0859F));

		PartDefinition TorsoTop_r4 = Body1.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(22, 67).mirror().addBox(-4.0F, -22.5388F, 49.9544F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4198F, 1.9847F, -54.7667F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Body1Head = Body1.addOrReplaceChild("Body1Head", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(-4.0829F, -8.1097F, -2.6771F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3369F, -9.3126F, 1.3381F, 0.455F, -0.19F, 0.7676F));

		PartDefinition B2HFungus2 = Body1Head.addOrReplaceChild("B2HFungus2", CubeListBuilder.create(), PartPose.offset(-0.0926F, -7.2169F, 3.9611F));

		PartDefinition Plane_r1 = B2HFungus2.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(-7, 123).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8183F, -0.266F, -5.8336F, 0.7933F, 0.8795F, 0.2608F));

		PartDefinition Plane_r2 = B2HFungus2.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-5.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -0.5F, -0.2747F, 0.158F, 0.4422F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4231F, -9.7068F, -0.1365F, -0.0564F, 0.2748F, -0.2639F));

		PartDefinition TorsoTop_r5 = Body2.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(22, 67).mirror().addBox(-4.0F, -10.8006F, 50.6644F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0033F, -9.2486F, -55.0688F, -0.1745F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r2 = Body2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-4.0F, 15.0476F, 49.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5033F, -0.2486F, -55.0688F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body2Head = Body2.addOrReplaceChild("Body2Head", CubeListBuilder.create().texOffs(0, 52).mirror().addBox(47.5634F, -24.058F, 3.3813F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-3.0064F, -8.8227F, -55.5642F, -1.2064F, -1.2308F, 0.8812F));

		PartDefinition Head2Jaw = Body2Head.addOrReplaceChild("Head2Jaw", CubeListBuilder.create().texOffs(33, 79).mirror().addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(51.5634F, -17.3587F, 3.4276F, -0.4144F, -0.1153F, -0.3762F));

		PartDefinition B2HFungus = Body2Head.addOrReplaceChild("B2HFungus", CubeListBuilder.create(), PartPose.offset(51.0F, -22.0F, 9.0F));

		PartDefinition Plane_r3 = B2HFungus.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(-7, 123).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8183F, -0.266F, -5.8336F, 0.7933F, 0.8795F, 0.2608F));

		PartDefinition Plane_r4 = B2HFungus.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(-7, 116).mirror().addBox(-2.75F, 0.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0395F, -0.3111F, 1.1942F, -0.315F, 0.0878F, -0.032F));

		PartDefinition Plane_r5 = B2HFungus.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(-7, 123).mirror().addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.3265F, -0.81F, -2.8293F, -0.6841F, 0.2209F, -0.1827F));

		PartDefinition Plane_r6 = B2HFungus.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(-7, 123).mirror().addBox(-5.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, -0.5F, -0.2747F, 0.158F, 0.4422F));

		PartDefinition OBrain5 = Body2Head.addOrReplaceChild("OBrain5", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(48.7892F, -21.47F, 9.5191F, -1.5392F, -0.4623F, -0.1339F));

		PartDefinition OBrain6 = Body2Head.addOrReplaceChild("OBrain6", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(55.2278F, -22.6115F, 8.2744F, -0.5236F, 0.0F, 1.0036F));

		PartDefinition OBrain7 = Body2Head.addOrReplaceChild("OBrain7", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(50.4209F, -24.1588F, 5.1622F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Body3 = Body2.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(48, 67).mirror().addBox(2.5025F, -9.8855F, -6.6117F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5008F, -9.3261F, -1.1432F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition TorsoTop_r6 = Body3.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(22, 67).mirror().addBox(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4975F, -6.95F, -3.7835F, 0.7418F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r3 = Body3.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-4.0F, 18.0476F, 45.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.9975F, -3.9225F, -52.9256F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3105F, -10.7891F, -7.9901F, 0.5528F, 0.82F, 0.4184F));

		PartDefinition Arm_r5 = Body4.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(48, 67).mirror().addBox(-2.0F, -1.0F, -3.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1958F, -1.5128F, -3.0F, -0.0451F, 0.0227F, -0.1289F));

		PartDefinition TorsoBase_r4 = Body4.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(0, 76).mirror().addBox(-4.0F, -7.0F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 4.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition OBrain4 = Body4.addOrReplaceChild("OBrain4", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(3.2243F, 0.3724F, -0.6566F, 0.3037F, 0.6878F, 1.6803F));

		PartDefinition MassOfBrains = Body4.addOrReplaceChild("MassOfBrains", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition MBrain1 = MassOfBrains.addOrReplaceChild("MBrain1", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-3.531F, 0.2879F, -2.1566F, 0.0F, -0.5236F, -0.829F));

		PartDefinition MBrain2 = MassOfBrains.addOrReplaceChild("MBrain2", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-2.5808F, 2.844F, 4.0313F, -0.3301F, -0.2441F, -0.6259F));

		PartDefinition MBrain3 = MassOfBrains.addOrReplaceChild("MBrain3", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1008F, -2.7215F, -2.7665F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6008F, -2.7215F, -2.7665F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8992F, -2.7215F, -2.7665F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.6624F, 0.0582F, 2.7194F, -0.1437F, 0.7076F, 0.2843F));

		PartDefinition MBrain4 = MassOfBrains.addOrReplaceChild("MBrain4", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-0.3232F, -0.3655F, -6.757F, 0.8744F, 0.0726F, -0.2132F));

		PartDefinition MBrain5 = MassOfBrains.addOrReplaceChild("MBrain5", CubeListBuilder.create().texOffs(78, 0).mirror().addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).mirror().addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(0.3506F, -3.4693F, -2.4563F, 0.3054F, 0.0F, 0.3491F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Womb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}