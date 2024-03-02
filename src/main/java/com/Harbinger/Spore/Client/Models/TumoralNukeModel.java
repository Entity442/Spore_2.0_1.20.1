package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.TumoroidNuke;
import com.Harbinger.Spore.Spore;
import com.ibm.icu.text.Normalizer2;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TumoralNukeModel<T extends TumoroidNuke> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "tumoral_nuke"), "main");
	private final ModelPart TheFuckingNuke;
	private final ModelPart Tumor;

	public TumoralNukeModel(ModelPart root) {
		this.TheFuckingNuke = root.getChild("TheFuckingNuke");
		this.Tumor = this.TheFuckingNuke.getChild("TumorCoating");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TheFuckingNuke = partdefinition.addOrReplaceChild("TheFuckingNuke", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Base = TheFuckingNuke.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(59, 134).addBox(30.0F, -29.0F, 8.0F, 7.0F, 21.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(59, 134).addBox(-37.0F, -29.0F, 8.0F, 7.0F, 21.0F, 21.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-30.0F, -36.0F, 9.0F, 60.0F, 5.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-30.0F, -6.0F, 9.0F, 60.0F, 5.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-30.0F, -28.5F, 1.0F, 60.0F, 19.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-30.0F, -28.5F, 31.0F, 60.0F, 19.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -18.5F));

		PartDefinition TumorCoating = TheFuckingNuke.addOrReplaceChild("TumorCoating", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition Top = TumorCoating.addOrReplaceChild("Top", CubeListBuilder.create(), PartPose.offset(-11.3355F, -21.5378F, 2.7269F));

		PartDefinition TopTumor_r1 = Top.addOrReplaceChild("TopTumor_r1", CubeListBuilder.create().texOffs(6, 366).addBox(-2.0277F, 2.3988F, 6.8296F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7073F, 0.4891F, -0.3819F));

		PartDefinition TopTumor_r2 = Top.addOrReplaceChild("TopTumor_r2", CubeListBuilder.create().texOffs(86, 339).addBox(-5.3414F, -6.6696F, 6.4395F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 1.0F, 0.0F, -0.5236F, -0.7418F));

		PartDefinition TopTumor_r3 = Top.addOrReplaceChild("TopTumor_r3", CubeListBuilder.create().texOffs(24, 361).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.0981F, -5.7409F, 4.2318F, 0.5672F, 0.48F, 0.0F));

		PartDefinition TopTumor_r4 = Top.addOrReplaceChild("TopTumor_r4", CubeListBuilder.create().texOffs(47, 370).addBox(2.9404F, 0.6287F, -1.4693F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.6577F, -8.8696F, -5.799F, -0.6545F, 0.5236F, 0.0F));

		PartDefinition TopTumor_r5 = Top.addOrReplaceChild("TopTumor_r5", CubeListBuilder.create().texOffs(15, 330).addBox(-4.4543F, -6.7121F, 5.1259F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.6577F, -4.8696F, -2.799F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition TopTumor_r6 = Top.addOrReplaceChild("TopTumor_r6", CubeListBuilder.create().texOffs(63, 368).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.4856F, -5.7186F, -2.2538F, -0.4531F, 0.272F, 1.5514F));

		PartDefinition TopTumor_r7 = Top.addOrReplaceChild("TopTumor_r7", CubeListBuilder.create().texOffs(8, 349).addBox(-5.4096F, -6.762F, -3.0845F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 1.0F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition TopTumor_r8 = Top.addOrReplaceChild("TopTumor_r8", CubeListBuilder.create().texOffs(44, 364).addBox(0.0833F, -4.0867F, -7.8666F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 1.0F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition TopTumor_r9 = Top.addOrReplaceChild("TopTumor_r9", CubeListBuilder.create().texOffs(36, 336).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.3355F, -6.4622F, 7.2731F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition TopTumor_r10 = Top.addOrReplaceChild("TopTumor_r10", CubeListBuilder.create().texOffs(0, 366).addBox(-4.0F, -4.0F, -6.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.2865F, -3.5378F, -13.0F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition TopTumor_r11 = Top.addOrReplaceChild("TopTumor_r11", CubeListBuilder.create().texOffs(37, 350).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.2404F, -4.3359F, -11.5929F, 1.0472F, 0.0F, 0.6981F));

		PartDefinition TopTumor_r12 = Top.addOrReplaceChild("TopTumor_r12", CubeListBuilder.create().texOffs(68, 344).addBox(-3.5F, -3.5F, -5.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5753F, -4.5449F, 10.6999F, -0.6981F, 0.0F, 1.0472F));

		PartDefinition TopTumor_r13 = Top.addOrReplaceChild("TopTumor_r13", CubeListBuilder.create().texOffs(45, 356).addBox(-8.6843F, -6.4165F, 2.4771F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -7.0F, 1.0F, -0.6981F, 0.0F, 1.0472F));

		PartDefinition TopTumor_r14 = Top.addOrReplaceChild("TopTumor_r14", CubeListBuilder.create().texOffs(60, 336).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9156F, -5.4845F, -10.4259F, -1.2043F, 0.2094F, 1.2217F));

		PartDefinition TopTumor_r15 = Top.addOrReplaceChild("TopTumor_r15", CubeListBuilder.create().texOffs(46, 350).addBox(-9.0F, -2.0F, -5.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.3355F, -10.4622F, 5.2731F, 0.0F, -0.5236F, -0.6545F));

		PartDefinition TopTumor_r16 = Top.addOrReplaceChild("TopTumor_r16", CubeListBuilder.create().texOffs(0, 333).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.7503F, -8.0928F, 4.9376F, 0.3819F, 0.4891F, 0.7073F));

		PartDefinition TopTumor_r17 = Top.addOrReplaceChild("TopTumor_r17", CubeListBuilder.create().texOffs(28, 352).addBox(-7.0F, -7.0F, -4.0F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.3355F, -6.4622F, -4.7269F, 0.0F, -0.4363F, -0.3927F));

		PartDefinition TopTumor_r18 = Top.addOrReplaceChild("TopTumor_r18", CubeListBuilder.create().texOffs(84, 346).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-15.2497F, -8.0928F, -10.3913F, -0.3819F, -0.4891F, 0.7073F));

		PartDefinition TopTumor_r19 = Top.addOrReplaceChild("TopTumor_r19", CubeListBuilder.create().texOffs(28, 361).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.2497F, -3.5928F, 7.6087F, -0.7418F, 0.5236F, 0.0F));

		PartDefinition TopTumor_r20 = Top.addOrReplaceChild("TopTumor_r20", CubeListBuilder.create().texOffs(11, 349).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.3355F, -8.4622F, -0.7269F, 0.48F, -0.3491F, -0.3927F));

		PartDefinition TopTumor_r21 = Top.addOrReplaceChild("TopTumor_r21", CubeListBuilder.create().texOffs(54, 339).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6645F, -9.4622F, -3.7269F, 0.0F, 0.4363F, -0.3927F));

		PartDefinition TopTumor_r22 = Top.addOrReplaceChild("TopTumor_r22", CubeListBuilder.create().texOffs(53, 355).addBox(-10.0F, -3.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6645F, -8.4622F, -13.7269F, 0.0F, 0.5236F, -0.6545F));

		PartDefinition TopTumor_r23 = Top.addOrReplaceChild("TopTumor_r23", CubeListBuilder.create().texOffs(10, 360).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.3913F, -4.5378F, -1.776F, 1.0472F, 0.0F, -0.6981F));

		PartDefinition TopTumor_r24 = Top.addOrReplaceChild("TopTumor_r24", CubeListBuilder.create().texOffs(55, 339).addBox(-17.0F, -10.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.3355F, -9.4622F, -6.7269F, 1.2897F, -0.2097F, -0.6247F));

		PartDefinition Bottom = TumorCoating.addOrReplaceChild("Bottom", CubeListBuilder.create(), PartPose.offset(-11.3355F, -4.4622F, -2.7269F));

		PartDefinition BottomTumor_r1 = Bottom.addOrReplaceChild("BottomTumor_r1", CubeListBuilder.create().texOffs(77, 355).addBox(-2.0277F, -9.3988F, -13.8296F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7073F, -0.4891F, 0.3819F));

		PartDefinition BottomTumor_r2 = Bottom.addOrReplaceChild("BottomTumor_r2", CubeListBuilder.create().texOffs(2, 355).addBox(-5.3414F, -0.3304F, -13.4395F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 7.0F, -1.0F, 0.0F, 0.5236F, 0.7418F));

		PartDefinition BottomTumor_r3 = Bottom.addOrReplaceChild("BottomTumor_r3", CubeListBuilder.create().texOffs(30, 355).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.0981F, 5.7409F, -4.2318F, 0.5672F, -0.48F, 0.0F));

		PartDefinition BottomTumor_r4 = Bottom.addOrReplaceChild("BottomTumor_r4", CubeListBuilder.create().texOffs(92, 355).addBox(2.9404F, -6.6287F, -4.5307F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.6577F, 8.8696F, 5.799F, -0.6545F, -0.5236F, 0.0F));

		PartDefinition BottomTumor_r5 = Bottom.addOrReplaceChild("BottomTumor_r5", CubeListBuilder.create().texOffs(73, 340).addBox(-4.4543F, -1.2879F, -13.1259F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.6577F, 4.8696F, 2.799F, 0.0F, 0.4363F, -0.3927F));

		PartDefinition BottomTumor_r6 = Bottom.addOrReplaceChild("BottomTumor_r6", CubeListBuilder.create().texOffs(54, 355).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.4856F, 5.7186F, 2.2538F, -0.4531F, -0.272F, -1.5514F));

		PartDefinition BottomTumor_r7 = Bottom.addOrReplaceChild("BottomTumor_r7", CubeListBuilder.create().texOffs(73, 340).addBox(-5.4096F, -1.238F, -4.9155F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 7.0F, -1.0F, -0.3927F, 0.4363F, 0.0F));

		PartDefinition BottomTumor_r8 = Bottom.addOrReplaceChild("BottomTumor_r8", CubeListBuilder.create().texOffs(19, 340).addBox(0.0833F, -5.9133F, -2.1334F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 7.0F, -1.0F, -0.6545F, 0.5236F, 0.0F));

		PartDefinition BottomTumor_r9 = Bottom.addOrReplaceChild("BottomTumor_r9", CubeListBuilder.create().texOffs(55, 355).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.3355F, 6.4622F, -7.2731F, -0.3927F, -0.4363F, 0.0F));

		PartDefinition BottomTumor_r10 = Bottom.addOrReplaceChild("BottomTumor_r10", CubeListBuilder.create().texOffs(31, 340).addBox(-4.0F, -6.0F, -4.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.2865F, 3.5378F, 13.0F, -0.6981F, 0.0F, 1.0472F));

		PartDefinition BottomTumor_r11 = Bottom.addOrReplaceChild("BottomTumor_r11", CubeListBuilder.create().texOffs(0, 355).addBox(2.4771F, -4.5835F, -8.6843F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.0624F, 7.0F, 12.3913F, 1.0472F, 0.0F, -0.6981F));

		PartDefinition BottomTumor_r12 = Bottom.addOrReplaceChild("BottomTumor_r12", CubeListBuilder.create().texOffs(53, 340).addBox(-3.5F, -5.5F, -3.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.5753F, 4.5449F, -10.6999F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition BottomTumor_r13 = Bottom.addOrReplaceChild("BottomTumor_r13", CubeListBuilder.create().texOffs(71, 355).addBox(-8.6843F, -4.5835F, -13.4771F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 6.0F, -1.0F, -0.6981F, 0.0F, -1.0472F));

		PartDefinition BottomTumor_r14 = Bottom.addOrReplaceChild("BottomTumor_r14", CubeListBuilder.create().texOffs(44, 355).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.9156F, 5.4845F, 10.4259F, -1.2043F, -0.2094F, -1.2217F));

		PartDefinition BottomTumor_r15 = Bottom.addOrReplaceChild("BottomTumor_r15", CubeListBuilder.create().texOffs(39, 340).addBox(-9.0F, -7.0F, -4.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.3355F, 10.4622F, -5.2731F, 0.0F, 0.5236F, 0.6545F));

		PartDefinition BottomTumor_r16 = Bottom.addOrReplaceChild("BottomTumor_r16", CubeListBuilder.create().texOffs(30, 340).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.7503F, 8.0928F, -4.9376F, 0.3819F, -0.4891F, -0.7073F));

		PartDefinition BottomTumor_r17 = Bottom.addOrReplaceChild("BottomTumor_r17", CubeListBuilder.create().texOffs(40, 355).addBox(-7.0F, -4.0F, -7.0F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.3355F, 6.4622F, 4.7269F, 0.0F, 0.4363F, 0.3927F));

		PartDefinition BottomTumor_r18 = Bottom.addOrReplaceChild("BottomTumor_r18", CubeListBuilder.create().texOffs(58, 340).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-15.2497F, 8.0928F, 10.3913F, -0.3819F, 0.4891F, -0.7073F));

		PartDefinition BottomTumor_r19 = Bottom.addOrReplaceChild("BottomTumor_r19", CubeListBuilder.create().texOffs(86, 340).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.2497F, 3.0928F, -8.6087F, -0.7418F, -0.5236F, 0.0F));

		PartDefinition BottomTumor_r20 = Bottom.addOrReplaceChild("BottomTumor_r20", CubeListBuilder.create().texOffs(79, 340).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.3355F, 8.4622F, 0.7269F, 0.48F, 0.3491F, 0.3927F));

		PartDefinition BottomTumor_r21 = Bottom.addOrReplaceChild("BottomTumor_r21", CubeListBuilder.create().texOffs(16, 340).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6645F, 9.4622F, 3.7269F, 0.0F, -0.4363F, 0.3927F));

		PartDefinition BottomTumor_r22 = Bottom.addOrReplaceChild("BottomTumor_r22", CubeListBuilder.create().texOffs(0, 355).addBox(-10.0F, -7.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6645F, 8.4622F, 13.7269F, 0.0F, -0.5236F, 0.6545F));

		PartDefinition BottomTumor_r23 = Bottom.addOrReplaceChild("BottomTumor_r23", CubeListBuilder.create().texOffs(49, 355).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.3913F, 4.5378F, 1.776F, 1.0472F, 0.0F, 0.6981F));

		PartDefinition BottomTumor_r24 = Bottom.addOrReplaceChild("BottomTumor_r24", CubeListBuilder.create().texOffs(0, 355).addBox(-17.0F, -2.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.3355F, 9.4622F, 6.7269F, 1.2897F, 0.2097F, 0.6247F));

		PartDefinition Left = TumorCoating.addOrReplaceChild("Left", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition LeftTumor_r1 = Left.addOrReplaceChild("LeftTumor_r1", CubeListBuilder.create().texOffs(37, 361).addBox(-2.0277F, 6.8296F, -9.3988F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-11.3355F, 2.7269F, 8.5378F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition LeftTumor_r2 = Left.addOrReplaceChild("LeftTumor_r2", CubeListBuilder.create().texOffs(2, 330).addBox(-5.3414F, 6.4395F, -0.3304F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3355F, 3.7269F, 15.5378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition LeftTumor_r3 = Left.addOrReplaceChild("LeftTumor_r3", CubeListBuilder.create().texOffs(32, 367).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.7625F, 6.9587F, 14.2787F, 0.5672F, 0.0F, -0.48F));

		PartDefinition LeftTumor_r4 = Left.addOrReplaceChild("LeftTumor_r4", CubeListBuilder.create().texOffs(58, 357).addBox(2.9404F, -1.4693F, -6.6287F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.3222F, -3.0721F, 17.4074F, -0.6545F, 0.0F, -0.5236F));

		PartDefinition LeftTumor_r5 = Left.addOrReplaceChild("LeftTumor_r5", CubeListBuilder.create().texOffs(59, 356).addBox(-4.4543F, 5.1259F, -1.2879F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.3222F, -0.0721F, 13.4074F, 0.0F, 0.3927F, 0.4363F));

		PartDefinition LeftTumor_r6 = Left.addOrReplaceChild("LeftTumor_r6", CubeListBuilder.create().texOffs(18, 343).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.1501F, 0.473F, 14.2564F, -0.4531F, 1.5514F, -0.272F));

		PartDefinition LeftTumor_r7 = Left.addOrReplaceChild("LeftTumor_r7", CubeListBuilder.create().texOffs(76, 352).addBox(-5.4096F, -3.0845F, -1.238F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3355F, 3.7269F, 15.5378F, -0.3927F, 0.0F, 0.4363F));

		PartDefinition LeftTumor_r8 = Left.addOrReplaceChild("LeftTumor_r8", CubeListBuilder.create().texOffs(22, 346).addBox(0.0833F, -7.8666F, -5.9133F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3355F, 3.7269F, 15.5378F, -0.6545F, 0.0F, 0.5236F));

		PartDefinition LeftTumor_r9 = Left.addOrReplaceChild("LeftTumor_r9", CubeListBuilder.create().texOffs(15, 348).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.0F, 10.0F, 15.0F, -0.3927F, 0.0F, -0.4363F));

		PartDefinition LeftTumor_r10 = Left.addOrReplaceChild("LeftTumor_r10", CubeListBuilder.create().texOffs(36, 335).addBox(2.4771F, -2.3157F, -4.5835F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.7269F, -9.6645F, 15.5378F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition LeftTumor_r11 = Left.addOrReplaceChild("LeftTumor_r11", CubeListBuilder.create().texOffs(82, 332).addBox(-3.5F, -5.5F, -5.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2397F, 13.4268F, 13.0827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition LeftTumor_r12 = Left.addOrReplaceChild("LeftTumor_r12", CubeListBuilder.create().texOffs(36, 363).addBox(-8.6843F, 2.4771F, -4.5835F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3355F, 3.7269F, 15.5378F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition LeftTumor_r13 = Left.addOrReplaceChild("LeftTumor_r13", CubeListBuilder.create().texOffs(36, 348).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5801F, -7.6991F, 14.0223F, -1.2043F, 1.2217F, -0.2094F));

		PartDefinition LeftTumor_r14 = Left.addOrReplaceChild("LeftTumor_r14", CubeListBuilder.create().texOffs(46, 374).addBox(-9.0F, -5.0F, -7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 8.0F, 19.0F, 0.0F, -0.6545F, 0.5236F));

		PartDefinition LeftTumor_r15 = Left.addOrReplaceChild("LeftTumor_r15", CubeListBuilder.create().texOffs(67, 331).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.4148F, 7.6645F, 16.6306F, 0.3819F, 0.7073F, -0.4891F));

		PartDefinition LeftTumor_r16 = Left.addOrReplaceChild("LeftTumor_r16", CubeListBuilder.create().texOffs(56, 345).addBox(-7.0F, -4.0F, -4.0F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -2.0F, 15.0F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition LeftTumor_r17 = Left.addOrReplaceChild("LeftTumor_r17", CubeListBuilder.create().texOffs(6, 349).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-26.5852F, -7.6645F, 16.6306F, -0.3819F, 0.7073F, 0.4891F));

		PartDefinition LeftTumor_r18 = Left.addOrReplaceChild("LeftTumor_r18", CubeListBuilder.create().texOffs(44, 341).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.5852F, 11.3355F, 11.6306F, -0.7418F, 0.0F, -0.5236F));

		PartDefinition LeftTumor_r19 = Left.addOrReplaceChild("LeftTumor_r19", CubeListBuilder.create().texOffs(0, 358).addBox(-16.0F, -16.0F, -4.0F, 20.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.0F, 3.0F, 17.0F, 0.48F, -0.3927F, 0.3491F));

		PartDefinition LeftTumor_r20 = Left.addOrReplaceChild("LeftTumor_r20", CubeListBuilder.create().texOffs(0, 355).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -1.0F, 18.0F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition LeftTumor_r21 = Left.addOrReplaceChild("LeftTumor_r21", CubeListBuilder.create().texOffs(0, 355).addBox(-10.0F, -5.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -11.0F, 17.0F, 0.0F, -0.6545F, -0.5236F));

		PartDefinition LeftTumor_r22 = Left.addOrReplaceChild("LeftTumor_r22", CubeListBuilder.create().texOffs(47, 335).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.7269F, 0.9509F, 13.0755F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition LeftTumor_r23 = Left.addOrReplaceChild("LeftTumor_r23", CubeListBuilder.create().texOffs(0, 355).addBox(-17.0F, -6.0F, -2.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 18.0F, 1.2897F, -0.6247F, 0.2097F));

		PartDefinition Right = TumorCoating.addOrReplaceChild("Right", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition RightTumor_r1 = Right.addOrReplaceChild("RightTumor_r1", CubeListBuilder.create().texOffs(16, 336).addBox(-4.9723F, 6.8296F, 2.3988F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(11.3355F, 2.7269F, -8.5378F, -0.7073F, -0.3819F, 0.4891F));

		PartDefinition RightTumor_r2 = Right.addOrReplaceChild("RightTumor_r2", CubeListBuilder.create().texOffs(31, 344).addBox(-1.6586F, 6.4395F, -6.6696F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3355F, 3.7269F, -15.5378F, 0.0F, -0.7418F, -0.5236F));

		PartDefinition RightTumor_r3 = Right.addOrReplaceChild("RightTumor_r3", CubeListBuilder.create().texOffs(31, 344).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.7625F, 6.9587F, -14.2787F, -0.5672F, 0.0F, 0.48F));

		PartDefinition RightTumor_r4 = Right.addOrReplaceChild("RightTumor_r4", CubeListBuilder.create().texOffs(31, 344).addBox(-8.9404F, -1.4693F, 0.6287F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.3222F, -3.0721F, -17.4074F, 0.6545F, 0.0F, 0.5236F));

		PartDefinition RightTumor_r5 = Right.addOrReplaceChild("RightTumor_r5", CubeListBuilder.create().texOffs(31, 344).addBox(-3.5457F, 5.1259F, -6.7121F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.3222F, -0.0721F, -13.4074F, 0.0F, 0.3927F, -0.4363F));

		PartDefinition RightTumor_r6 = Right.addOrReplaceChild("RightTumor_r6", CubeListBuilder.create().texOffs(31, 344).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.1501F, 0.473F, -14.2564F, 0.4531F, 1.5514F, 0.272F));

		PartDefinition RightTumor_r7 = Right.addOrReplaceChild("RightTumor_r7", CubeListBuilder.create().texOffs(31, 344).addBox(-2.5904F, -3.0845F, -6.762F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3355F, 3.7269F, -15.5378F, 0.3927F, 0.0F, -0.4363F));

		PartDefinition RightTumor_r8 = Right.addOrReplaceChild("RightTumor_r8", CubeListBuilder.create().texOffs(31, 344).addBox(-10.0833F, -7.8666F, -4.0867F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3355F, 3.7269F, -15.5378F, 0.6545F, 0.0F, -0.5236F));

		PartDefinition RightTumor_r9 = Right.addOrReplaceChild("RightTumor_r9", CubeListBuilder.create().texOffs(31, 344).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 10.0F, -15.0F, 0.3927F, 0.0F, 0.4363F));

		PartDefinition RightTumor_r10 = Right.addOrReplaceChild("RightTumor_r10", CubeListBuilder.create().texOffs(31, 344).addBox(-13.4771F, -2.3157F, -6.4165F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7269F, -9.6645F, -15.5378F, -1.0472F, 0.6981F, 0.0F));

		PartDefinition RightTumor_r11 = Right.addOrReplaceChild("RightTumor_r11", CubeListBuilder.create().texOffs(31, 344).addBox(-5.5F, -5.5F, -3.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2397F, 13.4268F, -13.0827F, 0.6981F, 1.0472F, 0.0F));

		PartDefinition RightTumor_r12 = Right.addOrReplaceChild("RightTumor_r12", CubeListBuilder.create().texOffs(31, 344).addBox(-2.3157F, 2.4771F, -6.4165F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3355F, 3.7269F, -15.2878F, 0.6981F, 1.0472F, 0.0F));

		PartDefinition RightTumor_r13 = Right.addOrReplaceChild("RightTumor_r13", CubeListBuilder.create().texOffs(31, 344).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.4148F, 7.6645F, -16.6306F, -0.3819F, 0.7073F, 0.4891F));

		PartDefinition RightTumor_r14 = Right.addOrReplaceChild("RightTumor_r14", CubeListBuilder.create().texOffs(31, 344).addBox(-12.0F, -12.0F, -11.0F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -2.0F, -15.0F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition RightTumor_r15 = Right.addOrReplaceChild("RightTumor_r15", CubeListBuilder.create().texOffs(31, 344).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(26.5852F, -7.6645F, -16.6306F, 0.3819F, 0.7073F, -0.4891F));

		PartDefinition RightTumor_r16 = Right.addOrReplaceChild("RightTumor_r16", CubeListBuilder.create().texOffs(31, 344).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5852F, 10.3355F, -11.6306F, 0.7418F, 0.0F, 0.5236F));

		PartDefinition RightTumor_r17 = Right.addOrReplaceChild("RightTumor_r17", CubeListBuilder.create().texOffs(31, 344).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, -1.0F, -18.0F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition RightTumor_r18 = Right.addOrReplaceChild("RightTumor_r18", CubeListBuilder.create().texOffs(31, 344).addBox(0.0F, -5.0F, -3.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -11.0F, -17.0F, 0.0F, -0.6545F, 0.5236F));

		PartDefinition RightTumor_r19 = Right.addOrReplaceChild("RightTumor_r19", CubeListBuilder.create().texOffs(31, 344).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.7269F, 0.9509F, -13.0755F, -1.0472F, -0.6981F, 0.0F));

		PartDefinition RightTumor_r20 = Right.addOrReplaceChild("RightTumor_r20", CubeListBuilder.create().texOffs(31, 344).addBox(5.0F, -6.0F, -10.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -18.0F, -1.2897F, -0.6247F, -0.2097F));

		PartDefinition Front = TumorCoating.addOrReplaceChild("Front", CubeListBuilder.create(), PartPose.offset(-23.0F, 0.0F, 0.0F));

		PartDefinition FrontTumor_r1 = Front.addOrReplaceChild("FrontTumor_r1", CubeListBuilder.create().texOffs(54, 350).addBox(-13.4771F, -2.3157F, -6.4165F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7269F, -21.6645F, -6.5378F, -1.0472F, 0.6981F, 0.0F));

		PartDefinition FrontTumor_r2 = Front.addOrReplaceChild("FrontTumor_r2", CubeListBuilder.create().texOffs(0, 355).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.5852F, -4.6306F, 7.3355F, -0.7418F, 0.5236F, 0.0F));

		PartDefinition FrontTumor_r3 = Front.addOrReplaceChild("FrontTumor_r3", CubeListBuilder.create().texOffs(0, 355).addBox(-17.0F, -6.0F, -2.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 11.0F, 1.2897F, -0.6247F, 0.2097F));

		PartDefinition FrontTumor_r4 = Front.addOrReplaceChild("FrontTumor_r4", CubeListBuilder.create().texOffs(0, 355).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.7269F, -8.0491F, -5.9245F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Back = TumorCoating.addOrReplaceChild("Back", CubeListBuilder.create(), PartPose.offset(23.0F, 0.0F, 0.0F));

		PartDefinition BackTumor_r1 = Back.addOrReplaceChild("BackTumor_r1", CubeListBuilder.create().texOffs(48, 326).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.5852F, -21.6306F, -8.6645F, -0.7418F, -0.5236F, 0.0F));

		PartDefinition BackTumor_r2 = Back.addOrReplaceChild("BackTumor_r2", CubeListBuilder.create().texOffs(48, 326).addBox(5.0F, -6.0F, -2.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 11.0F, 1.2897F, 0.6247F, -0.2097F));

		PartDefinition BackTumor_r3 = Back.addOrReplaceChild("BackTumor_r3", CubeListBuilder.create().texOffs(48, 326).addBox(-11.0F, -6.0F, -6.0F, 17.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7269F, -8.0491F, -5.9245F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition RibCover = TheFuckingNuke.addOrReplaceChild("RibCover", CubeListBuilder.create(), PartPose.offset(0.0F, -41.0F, 0.0F));

		PartDefinition SpineSeg5_r1 = RibCover.addOrReplaceChild("SpineSeg5_r1", CubeListBuilder.create().texOffs(196, 159).addBox(-21.5F, -2.25F, -2.4797F, 23.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.5156F, -1.395F, -1.8203F, 0.1047F, -0.1396F, -0.5236F));

		PartDefinition SpineSeg4_r1 = RibCover.addOrReplaceChild("SpineSeg4_r1", CubeListBuilder.create().texOffs(195, 158).addBox(-22.5F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-2.9323F, 0.4933F, 2.0F, 0.0F, -0.1745F, 0.0873F));

		PartDefinition SpineSeg3_r1 = RibCover.addOrReplaceChild("SpineSeg3_r1", CubeListBuilder.create().texOffs(195, 158).addBox(-21.5F, -3.0F, -2.99F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.7335F, -3.327F, 1.99F, 0.0F, 0.0F, -0.1745F));

		PartDefinition SpineSeg2_r1 = RibCover.addOrReplaceChild("SpineSeg2_r1", CubeListBuilder.create().texOffs(195, 158).addBox(-21.1857F, -2.7752F, -3.01F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.1857F, 6.0252F, 2.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition SpineSeg1_r1 = RibCover.addOrReplaceChild("SpineSeg1_r1", CubeListBuilder.create().texOffs(146, 275).addBox(-3.0F, -7.0F, -3.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.0F, 12.0F, 2.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition SS1Details = RibCover.addOrReplaceChild("SS1Details", CubeListBuilder.create(), PartPose.offset(39.0F, 12.0F, 2.0F));

		PartDefinition Spike_r1 = SS1Details.addOrReplaceChild("Spike_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2786F, -3.2557F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7858F, -2.0504F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition Spike_r2 = SS1Details.addOrReplaceChild("Spike_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7704F, 4.0405F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition SS2Details = RibCover.addOrReplaceChild("SS2Details", CubeListBuilder.create(), PartPose.offsetAndRotation(30.0F, 3.0F, 2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Spike_r3 = SS2Details.addOrReplaceChild("Spike_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2786F, -3.2557F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7858F, -2.0504F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition Spike_r4 = SS2Details.addOrReplaceChild("Spike_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -17.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7704F, 4.0405F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition RibOffshoot1 = RibCover.addOrReplaceChild("RibOffshoot1", CubeListBuilder.create(), PartPose.offset(37.1857F, 6.0252F, 2.0F));

		PartDefinition RO3Seg3_r1 = RibOffshoot1.addOrReplaceChild("RO3Seg3_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-2.0F, -0.75F, -12.75F, 4.0F, 4.0F, 14.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-10.7397F, 8.8344F, -23.2026F, 1.5946F, -0.1616F, 0.2557F));

		PartDefinition RO2Seg2_r1 = RibOffshoot1.addOrReplaceChild("RO2Seg2_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-1.5F, -1.75F, -13.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-11.8409F, -1.4259F, -15.2763F, 0.8839F, -0.1245F, 0.0385F));

		PartDefinition RO1Seg1_r1 = RibOffshoot1.addOrReplaceChild("RO1Seg1_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-4.0F, -2.0F, -12.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -5.0F, -4.0F, 0.3491F, 0.0F, 0.2182F));

		PartDefinition RibOffshoot2 = RibCover.addOrReplaceChild("RibOffshoot2", CubeListBuilder.create(), PartPose.offset(31.1857F, 2.7752F, 1.0F));

		PartDefinition RO4Seg4_r1 = RibOffshoot2.addOrReplaceChild("RO4Seg4_r1", CubeListBuilder.create().texOffs(0, 202).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 21.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(-19.2114F, 17.5552F, 30.1317F, -2.5562F, -0.3051F, 0.2558F));

		PartDefinition RO3Seg3_r2 = RibOffshoot2.addOrReplaceChild("RO3Seg3_r2", CubeListBuilder.create().texOffs(0, 202).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 21.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-12.251F, 0.4237F, 22.5119F, -1.1599F, -0.3051F, 0.2558F));

		PartDefinition RO2Seg2_r2 = RibOffshoot2.addOrReplaceChild("RO2Seg2_r2", CubeListBuilder.create().texOffs(12, 214).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-11.743F, -1.8678F, 14.6067F, -0.0436F, 0.0F, 0.2182F));

		PartDefinition RO2Seg1_r1 = RibOffshoot2.addOrReplaceChild("RO2Seg1_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -5.0F, 4.0F, -0.5236F, 0.0F, 0.2182F));

		PartDefinition SS3Details = RibCover.addOrReplaceChild("SS3Details", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -1.0F, 2.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition Spike_r5 = SS3Details.addOrReplaceChild("Spike_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2786F, -3.2557F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7858F, -2.0504F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition Spike_r6 = SS3Details.addOrReplaceChild("Spike_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -17.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7704F, 4.0405F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition RibOffshoot3 = RibCover.addOrReplaceChild("RibOffshoot3", CubeListBuilder.create(), PartPose.offset(5.7335F, -2.327F, 1.99F));

		PartDefinition RO4Seg5_r1 = RibOffshoot3.addOrReplaceChild("RO4Seg5_r1", CubeListBuilder.create().texOffs(10, 212).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1437F, 36.6732F, 15.6184F, -2.4678F, -0.0664F, -0.1149F));

		PartDefinition RO3Seg4_r1 = RibOffshoot3.addOrReplaceChild("RO3Seg4_r1", CubeListBuilder.create().texOffs(10, 212).addBox(-2.0F, -2.0F, 0.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7316F, 27.6094F, 17.6988F, -1.7636F, -0.1621F, -0.5436F));

		PartDefinition RO3Seg3_r3 = RibOffshoot3.addOrReplaceChild("RO3Seg3_r3", CubeListBuilder.create().texOffs(6, 208).addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4205F, 15.4994F, 20.6551F, -1.8399F, -0.5447F, -0.1537F));

		PartDefinition RO3Seg2_r1 = RibOffshoot3.addOrReplaceChild("RO3Seg2_r1", CubeListBuilder.create().texOffs(8, 210).addBox(-2.75F, -2.75F, -0.5F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5137F, 8.1997F, 13.1087F, -0.8354F, -0.4215F, 0.216F));

		PartDefinition RO3Seg1_r1 = RibOffshoot3.addOrReplaceChild("RO3Seg1_r1", CubeListBuilder.create().texOffs(6, 208).addBox(-2.0F, -1.75F, -2.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 3.0F, -0.4555F, -0.298F, -0.2284F));

		PartDefinition SS4Details = RibCover.addOrReplaceChild("SS4Details", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, 0.0F, 1.0F, 0.1739F, -0.0151F, -1.1358F));

		PartDefinition Spike_r7 = SS4Details.addOrReplaceChild("Spike_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2786F, -3.2557F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7858F, -2.0504F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition Spike_r8 = SS4Details.addOrReplaceChild("Spike_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -17.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7704F, 4.0405F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition RibOffshoot4 = RibCover.addOrReplaceChild("RibOffshoot4", CubeListBuilder.create(), PartPose.offset(-5.9323F, 0.4933F, 2.0F));

		PartDefinition RO4Split2Seg2_r1 = RibOffshoot4.addOrReplaceChild("RO4Split2Seg2_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-2.25F, -1.5F, -12.75F, 4.0F, 4.0F, 14.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.6071F, 30.5034F, -23.1469F, 2.4005F, -0.459F, -0.2696F));

		PartDefinition RO4Split2_r1 = RibOffshoot4.addOrReplaceChild("RO4Split2_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-2.0F, -2.0F, -13.0F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5909F, 19.0719F, -27.6962F, 1.9413F, -0.2597F, -0.4514F));

		PartDefinition RO4Split1_r1 = RibOffshoot4.addOrReplaceChild("RO4Split1_r1", CubeListBuilder.create().texOffs(0, 202).addBox(-2.0F, -3.0F, -20.0F, 4.0F, 4.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6164F, 23.6951F, -30.1377F, 2.4338F, -0.6053F, 1.3646F));

		PartDefinition RO4Seg3_r1 = RibOffshoot4.addOrReplaceChild("RO4Seg3_r1", CubeListBuilder.create().texOffs(7, 209).addBox(-2.0F, -2.0F, -14.5F, 4.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2324F, 14.3735F, -26.0079F, 1.2586F, 0.0898F, 0.7304F));

		PartDefinition RO4Seg2_r1 = RibOffshoot4.addOrReplaceChild("RO4Seg2_r1", CubeListBuilder.create().texOffs(3, 205).addBox(-2.75F, -2.0F, -14.75F, 5.0F, 5.0F, 17.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.3978F, 5.4316F, -16.4565F, 0.7285F, -0.0617F, 0.2746F));

		PartDefinition RO4Seg1_r1 = RibOffshoot4.addOrReplaceChild("RO4Seg1_r1", CubeListBuilder.create().texOffs(4, 206).addBox(-2.5F, -2.5F, -15.5F, 5.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -3.0F, 0.3927F, -0.3491F, 0.0F));

		PartDefinition SS5Details = RibCover.addOrReplaceChild("SS5Details", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.0F, 5.0F, -4.0F, 0.1727F, -0.0497F, -1.743F));

		PartDefinition Spike_r9 = SS5Details.addOrReplaceChild("Spike_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.2786F, -3.2557F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7858F, -2.0504F, 0.0F, 0.0F, 0.1745F, -0.3491F));

		PartDefinition Spike_r10 = SS5Details.addOrReplaceChild("Spike_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.0F, 0.0F, 5.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7704F, 4.0405F, 0.0F, 0.0F, -0.2182F, -0.3491F));

		PartDefinition RibOffshoot5 = RibCover.addOrReplaceChild("RibOffshoot5", CubeListBuilder.create(), PartPose.offset(-24.5156F, -1.395F, -1.8203F));

		PartDefinition RO5Seg5_r1 = RibOffshoot5.addOrReplaceChild("RO5Seg5_r1", CubeListBuilder.create().texOffs(4, 206).addBox(-2.0F, -2.0F, -1.5F, 4.0F, 4.0F, 17.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.0628F, 42.5614F, 9.5583F, -3.0748F, 0.3457F, -0.0999F));

		PartDefinition RO5Seg4_r1 = RibOffshoot5.addOrReplaceChild("RO5Seg4_r1", CubeListBuilder.create().texOffs(6, 208).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(2.0564F, 34.6887F, 20.105F, -2.4768F, -0.1216F, -0.2113F));

		PartDefinition RO5Seg3_r1 = RibOffshoot5.addOrReplaceChild("RO5Seg3_r1", CubeListBuilder.create().texOffs(6, 208).addBox(-2.0F, -2.0F, 0.5F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0868F, 20.1826F, 23.2641F, -1.783F, -0.0087F, -0.1448F));

		PartDefinition RO5Seg2_r1 = RibOffshoot5.addOrReplaceChild("RO5Seg2_r1", CubeListBuilder.create().texOffs(6, 208).addBox(-2.0F, -2.0F, -0.5F, 4.0F, 4.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1384F, 9.1607F, 14.6347F, -0.9055F, 0.0554F, 0.0638F));

		PartDefinition RO5Seg1_r1 = RibOffshoot5.addOrReplaceChild("RO5Seg1_r1", CubeListBuilder.create().texOffs(4, 206).addBox(-2.0F, -0.75F, -2.0F, 4.0F, 4.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 3.0F, -0.534F, 0.1886F, -0.1104F));

		PartDefinition ContrortedHead = RibCover.addOrReplaceChild("ContrortedHead", CubeListBuilder.create().texOffs(29, 136).addBox(-11.8956F, -4.158F, -5.7172F, 12.0F, 7.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(33, 139).addBox(-8.8956F, -6.158F, -2.7172F, 9.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-39.9882F, 6.022F, -5.0578F, 0.1047F, -0.1396F, -0.5236F));

		PartDefinition SmolHead = ContrortedHead.addOrReplaceChild("SmolHead", CubeListBuilder.create(), PartPose.offset(-4.2275F, 2.7082F, -5.6292F));

		PartDefinition SmolHead_r1 = SmolHead.addOrReplaceChild("SmolHead_r1", CubeListBuilder.create().texOffs(24, 185).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3319F, -3.8662F, -1.088F, -0.5236F, 0.3491F, 0.0F));

		PartDefinition SmolJaw_r1 = SmolHead.addOrReplaceChild("SmolJaw_r1", CubeListBuilder.create().texOffs(0, 193).addBox(-4.0F, -0.5F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9182F, 1.1649F, 0.5227F, -0.2623F, 0.3179F, -0.1346F));

		PartDefinition Jaw = ContrortedHead.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(-5.0185F, 3.3285F, -0.9934F));

		PartDefinition Jaw2_r1 = Jaw.addOrReplaceChild("Jaw2_r1", CubeListBuilder.create().texOffs(0, 184).addBox(-6.5F, -1.0F, -3.15F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3771F, 0.5135F, 2.4262F, 0.0995F, -0.2924F, -0.5013F));

		PartDefinition Jaw1_r1 = Jaw.addOrReplaceChild("Jaw1_r1", CubeListBuilder.create().texOffs(0, 175).addBox(-6.5F, -1.0F, -1.15F, 9.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3771F, 0.5135F, 2.4262F, 0.2618F, 0.0F, -0.3054F));

		PartDefinition Jaw3_r1 = Jaw.addOrReplaceChild("Jaw3_r1", CubeListBuilder.create().texOffs(0, 187).addBox(-9.0F, -2.0F, -2.0F, 9.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1229F, 0.5135F, -2.7238F, -0.5309F, -0.2909F, -0.117F));

		PartDefinition TumoralGrowths = ContrortedHead.addOrReplaceChild("TumoralGrowths", CubeListBuilder.create(), PartPose.offset(-4.6772F, 4.2232F, 0.2758F));

		PartDefinition Tumor3_r1 = TumoralGrowths.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(70, 369).addBox(0.0F, -2.0F, 12.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(46, 353).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.0F, -7.0F, 0.2546F, 0.4114F, 0.577F));

		PartDefinition Tumor1_r1 = TumoralGrowths.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(58, 334).addBox(-3.25F, -4.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, 6.0F, 0.48F, 0.3054F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Tumor.yScale = 1 + Mth.sin(ageInTicks/6)/10;
		this.Tumor.xScale = 1 + Mth.sin(ageInTicks/6)/10;
		this.Tumor.zScale = 1 + Mth.sin(ageInTicks/6)/10;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		TheFuckingNuke.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}