package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.ZoaholicBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class ZoaholicModel<T extends ZoaholicBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "zoaholic"), "main");
	private final ModelPart Base;
	private final ModelPart Blood;
	private final ModelPart Brain;
	private final ModelPart Heart;
	private final ModelPart InnardsTop;
	private final ModelPart InnardsDown;

	public ZoaholicModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Base = root.getChild("Base");
		this.Blood = Base.getChild("GutBox").getChild("Blood");
		this.Brain = Base.getChild("Top").getChild("FrankenstineBrain").getChild("BrainLarge");
		this.Heart = Base.getChild("GutBox").getChild("Heart");
		this.InnardsTop = Base.getChild("GutBox").getChild("Innards").getChild("HookedInnards");
		this.InnardsDown = Base.getChild("GutBox").getChild("Innards").getChild("LyingInnards");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Base = partdefinition.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition GutBox = Base.addOrReplaceChild("GutBox", CubeListBuilder.create().texOffs(14, 59).addBox(-8.0F, -9.0F, -8.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 59).addBox(6.0F, -9.0F, -8.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 59).addBox(-8.0F, -9.0F, 6.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 59).addBox(6.0F, -9.0F, 6.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Glass = GutBox.addOrReplaceChild("Glass", CubeListBuilder.create().texOffs(0, 51).addBox(-6.0F, -10.0F, -7.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 51).addBox(-6.0F, -10.0F, 7.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition WestPane_r1 = Glass.addOrReplaceChild("WestPane_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-6.0F, -4.0F, -7.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 51).addBox(-6.0F, -4.0F, 7.0F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition FleshHook = GutBox.addOrReplaceChild("FleshHook", CubeListBuilder.create().texOffs(29, 0).addBox(-0.5F, -0.25F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(37, 0).addBox(-1.0F, 0.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(39, 0).addBox(-1.0F, 2.25F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(27, 0).addBox(0.0F, 1.75F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, -9.0F, -2.0F));

		PartDefinition Blood = GutBox.addOrReplaceChild("Blood", CubeListBuilder.create().texOffs(0, 36).addBox(-7.0F, -0.9F, -7.0F, 14.0F, 1.0F, 14.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Innards = GutBox.addOrReplaceChild("Innards", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition HookedInnards = Innards.addOrReplaceChild("HookedInnards", CubeListBuilder.create(), PartPose.offset(1.4984F, -3.2709F, 1.9307F));

		PartDefinition Seg_3_r1 = HookedInnards.addOrReplaceChild("Seg_3_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5834F, 0.6174F, -0.4139F));

		PartDefinition Seg_4_r1 = HookedInnards.addOrReplaceChild("Seg_4_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.3278F, 0.62F, 1.361F, 0.0284F, 1.0183F, 0.087F));

		PartDefinition Seg_5_r1 = HookedInnards.addOrReplaceChild("Seg_5_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(3.0281F, 0.7113F, 2.4102F, 2.9551F, 0.8874F, 2.9774F));

		PartDefinition Seg_2_r1 = HookedInnards.addOrReplaceChild("Seg_2_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5825F, -1.9026F, -0.2022F, -1.4581F, 0.4523F, -0.2477F));

		PartDefinition Seg_1_r1 = HookedInnards.addOrReplaceChild("Seg_1_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.9984F, -3.4002F, -1.4609F, -0.8548F, 0.2878F, -0.0288F));

		PartDefinition Seg2_r1 = HookedInnards.addOrReplaceChild("Seg2_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, 0.0F, -1.75F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.9984F, -2.3057F, -4.4679F, 1.3303F, -0.18F, 0.3691F));

		PartDefinition Seg3_r1 = HookedInnards.addOrReplaceChild("Seg3_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.6348F, -0.9948F, -3.8053F, 2.0343F, -0.0762F, -0.013F));

		PartDefinition Seg1_r1 = HookedInnards.addOrReplaceChild("Seg1_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.9984F, -3.2291F, -1.9307F, 0.3123F, -0.1586F, 0.4549F));

		PartDefinition Seg11_r1 = HookedInnards.addOrReplaceChild("Seg11_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.6869F, 0.6542F, -0.6377F, -0.1374F, 1.357F, 3.0113F));

		PartDefinition Seg10_r1 = HookedInnards.addOrReplaceChild("Seg10_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0F, -0.991F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.6155F, 0.6618F, -1.1673F, -3.0323F, 1.3012F, 0.1094F));

		PartDefinition Seg9_r1 = HookedInnards.addOrReplaceChild("Seg9_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-5.7728F, 0.6098F, 0.4631F, -0.0356F, 0.6169F, 3.125F));

		PartDefinition Seg8_r1 = HookedInnards.addOrReplaceChild("Seg8_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-1.75F, -1.0F, -2.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-6.0405F, 0.7577F, 2.112F, 0.0812F, -0.2964F, 3.046F));

		PartDefinition Seg7_r1 = HookedInnards.addOrReplaceChild("Seg7_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -0.9929F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-3.0584F, 0.7238F, 2.4371F, 1.3463F, -1.0624F, 1.7563F));

		PartDefinition Seg6_r1 = HookedInnards.addOrReplaceChild("Seg6_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.9811F, -0.1354F, 0.9875F, 2.5619F, -0.523F, 0.2459F));

		PartDefinition Seg5_r1 = HookedInnards.addOrReplaceChild("Seg5_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -0.5F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.8307F, 0.062F, -1.059F, 2.9948F, -0.0702F, -0.0323F));

		PartDefinition Seg4_r1 = HookedInnards.addOrReplaceChild("Seg4_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.6797F, 0.7949F, -2.9137F, -2.5029F, -0.0702F, -0.0323F));

		PartDefinition LyingInnards = Innards.addOrReplaceChild("LyingInnards", CubeListBuilder.create(), PartPose.offset(0.5016F, -3.2709F, -1.9307F));

		PartDefinition Seg_4_r2 = LyingInnards.addOrReplaceChild("Seg_4_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-0.9801F, -0.9947F, -2.2964F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.7793F, 0.4447F, 9.6709F, 0.905F, -1.2386F, 2.3447F));

		PartDefinition Seg_5_r2 = LyingInnards.addOrReplaceChild("Seg_5_r2", CubeListBuilder.create().texOffs(0, 72).addBox(-0.5934F, -0.4887F, -4.1735F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-2.6793F, 0.3447F, 9.6709F, 0.7518F, -0.7288F, 2.148F));

		PartDefinition Seg_6_r1 = LyingInnards.addOrReplaceChild("Seg_6_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-6.1084F, 0.3287F, 8.2006F, 0.0125F, -0.1431F, 2.4887F));

		PartDefinition Seg_3_r2 = LyingInnards.addOrReplaceChild("Seg_3_r2", CubeListBuilder.create().texOffs(0, 77).addBox(-0.9962F, -1.2445F, -2.1286F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.9187F, 0.4077F, 9.4251F, 2.4675F, -1.2925F, 0.839F));

		PartDefinition Seg_2_r2 = LyingInnards.addOrReplaceChild("Seg_2_r2", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0631F, -0.8006F, -2.3564F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.9901F, 0.8019F, 8.6715F, 2.5044F, -1.1263F, 0.6803F));

		PartDefinition Seg3_r2 = LyingInnards.addOrReplaceChild("Seg3_r2", CubeListBuilder.create().texOffs(0, 77).addBox(-0.6236F, -1.5019F, -2.5307F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.4235F, -1.1442F, 4.8427F, 2.4573F, -0.0911F, 0.3991F));

		PartDefinition Seg4_r2 = LyingInnards.addOrReplaceChild("Seg4_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0589F, -0.3669F, -1.6928F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.6735F, 0.8558F, 3.8427F, -2.5152F, -0.0616F, 0.0467F));

		PartDefinition Seg2_r2 = LyingInnards.addOrReplaceChild("Seg2_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.1758F, -0.8696F, -2.3369F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.0941F, 0.787F, 6.7679F, 3.0641F, 0.0403F, 0.4784F));

		PartDefinition Seg12_r1 = LyingInnards.addOrReplaceChild("Seg12_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(2.4369F, 0.5042F, 0.8877F, 0.1374F, 1.357F, -3.0113F));

		PartDefinition Seg11_r2 = LyingInnards.addOrReplaceChild("Seg11_r2", CubeListBuilder.create().texOffs(0, 72).addBox(-1.0F, -0.991F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.3655F, 0.5118F, 1.4173F, 3.0323F, 1.3012F, -0.1094F));

		PartDefinition Seg10_r2 = LyingInnards.addOrReplaceChild("Seg10_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(5.5228F, 0.4598F, -0.2131F, 0.0356F, 0.6169F, -3.125F));

		PartDefinition Seg9_r2 = LyingInnards.addOrReplaceChild("Seg9_r2", CubeListBuilder.create().texOffs(0, 72).addBox(-0.25F, -1.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(5.7905F, 0.6077F, -1.862F, -0.0812F, -0.2964F, -3.046F));

		PartDefinition Seg8_r2 = LyingInnards.addOrReplaceChild("Seg8_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -0.9929F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(2.8084F, 0.5738F, -2.1871F, -1.3463F, -1.0624F, -1.7563F));

		PartDefinition Seg7_r2 = LyingInnards.addOrReplaceChild("Seg7_r2", CubeListBuilder.create().texOffs(0, 77).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.9811F, -0.1354F, -0.9875F, -2.5619F, -0.523F, -0.2459F));

		PartDefinition Seg6_r2 = LyingInnards.addOrReplaceChild("Seg6_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.8307F, 0.062F, 1.059F, -2.9948F, -0.0702F, 0.0323F));

		PartDefinition Seg5_r2 = LyingInnards.addOrReplaceChild("Seg5_r2", CubeListBuilder.create().texOffs(0, 67).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.6797F, 0.7949F, 2.9137F, 2.5029F, -0.0702F, 0.0323F));

		PartDefinition Heart = GutBox.addOrReplaceChild("Heart", CubeListBuilder.create().texOffs(16, 18).addBox(-2.0686F, 1.3444F, -1.2546F, 4.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.6212F, -9.1045F, -3.6818F, -0.0042F, -0.6541F, 0.0072F));

		PartDefinition FunnyLump_r1 = Heart.addOrReplaceChild("FunnyLump_r1", CubeListBuilder.create().texOffs(21, 21).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.1969F, 2.6233F, 0.2454F, -0.829F, -0.7418F, 0.0F));

		PartDefinition FunnyLump_r2 = Heart.addOrReplaceChild("FunnyLump_r2", CubeListBuilder.create().texOffs(22, 20).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.234F, 2.8733F, 0.2454F, 0.829F, -0.7418F, 0.0F));

		PartDefinition FunnyLump_r3 = Heart.addOrReplaceChild("FunnyLump_r3", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.334F, 2.8733F, -0.3546F, -0.829F, 0.7418F, 0.0F));

		PartDefinition FunnyLump_r4 = Heart.addOrReplaceChild("FunnyLump_r4", CubeListBuilder.create().texOffs(20, 21).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.034F, 3.1233F, 0.7454F, -0.829F, 0.7418F, 0.0F));

		PartDefinition TopRight_r1 = Heart.addOrReplaceChild("TopRight_r1", CubeListBuilder.create().texOffs(18, 18).addBox(-1.0F, -2.5F, -1.51F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.8186F, 2.5944F, 0.2454F, 0.0F, 0.0F, 0.9163F));

		PartDefinition BottomLeft_r1 = Heart.addOrReplaceChild("BottomLeft_r1", CubeListBuilder.create().texOffs(16, 18).addBox(-2.0F, -1.5F, -1.49F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.6814F, 3.5944F, 0.2454F, 0.0F, 0.0F, 0.9163F));

		PartDefinition Left_r1 = Heart.addOrReplaceChild("Left_r1", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.4314F, 3.4444F, -0.0046F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Right_r1 = Heart.addOrReplaceChild("Right_r1", CubeListBuilder.create().texOffs(16, 18).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.3186F, 3.0944F, 0.2454F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Top = Base.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -12.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition ControlPanel = Top.addOrReplaceChild("ControlPanel", CubeListBuilder.create().texOffs(16, 0).addBox(-6.5F, -3.0F, 3.0F, 13.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-6.5F, -2.0F, 1.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-6.5F, -3.0F, 2.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(17, 0).addBox(-6.5F, -1.0F, 0.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, -7.0F));

		PartDefinition Face = ControlPanel.addOrReplaceChild("Face", CubeListBuilder.create().texOffs(13, 12).addBox(-6.5F, -0.5F, 0.0F, 14.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0303F, -0.5303F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Button = Face.addOrReplaceChild("Button", CubeListBuilder.create().texOffs(35, 65).addBox(-1.0F, -0.75F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 0.0F, 3.0F));

		PartDefinition ButtonFace = Button.addOrReplaceChild("ButtonFace", CubeListBuilder.create().texOffs(76, 50).addBox(-0.5F, -1.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -0.5F));

		PartDefinition Display = Face.addOrReplaceChild("Display", CubeListBuilder.create().texOffs(4, 12).addBox(-4.0F, -6.5F, -3.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(79, 12).addBox(-2.0F, -6.7F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(78, 77).addBox(-4.0F, -6.7F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(78, 70).addBox(-4.001F, -6.701F, -2.999F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(48, 51).addBox(-4.001F, -6.701F, -0.999F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offset(8.5F, 5.4697F, 3.0303F));

		PartDefinition Needle = Display.addOrReplaceChild("Needle", CubeListBuilder.create().texOffs(9, 27).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(-2.5F, -6.09F, -2.35F));

		PartDefinition SmallButtons = Face.addOrReplaceChild("SmallButtons", CubeListBuilder.create().texOffs(48, 8).addBox(-1.625F, -0.5F, 0.625F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(48, 8).addBox(-0.625F, -0.5F, 0.625F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(48, 8).addBox(0.375F, -0.5F, 0.625F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 59).addBox(-1.625F, -0.5F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 59).addBox(-0.625F, -0.5F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 59).addBox(0.375F, -0.5F, -0.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(38, 61).addBox(-1.625F, -0.5F, -1.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(38, 61).addBox(-0.625F, -0.5F, -1.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(38, 61).addBox(0.375F, -0.5F, -1.375F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(-0.875F, -0.4874F, 3.1553F));

		PartDefinition Lever = Face.addOrReplaceChild("Lever", CubeListBuilder.create(), PartPose.offset(-2.5F, 5.4697F, 2.5303F));

		PartDefinition Lever_r1 = Lever.addOrReplaceChild("Lever_r1", CubeListBuilder.create().texOffs(0, 9).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, -5.8F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition LeverBase = Lever.addOrReplaceChild("LeverBase", CubeListBuilder.create().texOffs(30, 13).addBox(-2.0F, -14.5F, 6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 13).addBox(-4.0F, -14.5F, 6.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(30, 13).addBox(-3.0F, -14.5F, 6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(30, 13).addBox(-3.0F, -14.5F, 9.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 8.0F, -8.0F));

		PartDefinition Jar = Top.addOrReplaceChild("Jar", CubeListBuilder.create().texOffs(6, 51).addBox(-3.9F, -4.6F, -2.1F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 51).addBox(-3.9F, -4.6F, 3.9F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(50, 47).addBox(-3.9F, -5.6F, -2.1F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.1F))
		.texOffs(42, 39).addBox(-0.4F, -6.6F, -1.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F))
		.texOffs(11, 9).addBox(1.1F, -6.85F, -1.1F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.09F)), PartPose.offset(-3.6F, -10.9F, 3.6F));

		PartDefinition GlassWest_r1 = Jar.addOrReplaceChild("GlassWest_r1", CubeListBuilder.create().texOffs(6, 51).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(6, 51).addBox(-3.0F, -2.0F, 3.0F, 6.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -2.6F, 0.9F, 0.0F, -1.5708F, 0.0F));

		PartDefinition BrainSmall = Jar.addOrReplaceChild("BrainSmall", CubeListBuilder.create().texOffs(1, 19).addBox(-2.8027F, -2.1412F, -1.436F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.2F))
		.texOffs(1, 19).addBox(0.1973F, -2.1412F, -1.436F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.2F))
		.texOffs(1, 1).addBox(-1.3027F, -2.1412F, -1.436F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5973F, -1.2088F, -0.164F, 0.0F, 0.0F, 0.0F));

		PartDefinition Formaldehyde = Jar.addOrReplaceChild("Formaldehyde", CubeListBuilder.create().texOffs(48, 4).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.9F, -0.5F, 0.9F));

		PartDefinition JarToControlWires = Top.addOrReplaceChild("JarToControlWires", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Wire1 = JarToControlWires.addOrReplaceChild("Wire1", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -0.75F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 59).addBox(-4.0F, -0.75F, 2.0F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 18).addBox(-4.0F, -4.75F, 2.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-4.0F, -4.75F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, -2.0F));

		PartDefinition Wire2 = JarToControlWires.addOrReplaceChild("Wire2", CubeListBuilder.create().texOffs(78, 72).addBox(-0.25F, -0.5F, -0.1F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
		.texOffs(10, 0).addBox(-0.25F, -3.5F, 2.7F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 2).addBox(-0.25F, -3.5F, 3.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.1F))
		.texOffs(48, 4).addBox(-2.05F, -3.5F, 4.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offset(-0.25F, -14.25F, -2.0F));

		PartDefinition FrankenstineBrain = Top.addOrReplaceChild("FrankenstineBrain", CubeListBuilder.create(), PartPose.offset(5.75F, -15.75F, -2.5F));

		PartDefinition MetalRod3Top_r1 = FrankenstineBrain.addOrReplaceChild("MetalRod3Top_r1", CubeListBuilder.create().texOffs(77, 58).addBox(-1.0023F, -3.7672F, 6.0306F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F))
		.texOffs(12, 30).addBox(-0.5023F, -3.2672F, 6.5306F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2597F, 0.0338F, 0.1265F));

		PartDefinition MetalRod2Top_r1 = FrankenstineBrain.addOrReplaceChild("MetalRod2Top_r1", CubeListBuilder.create().texOffs(77, 58).addBox(-1.0023F, -1.7672F, -2.0306F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F))
		.texOffs(12, 30).addBox(-0.5023F, -1.5172F, -1.5306F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.2597F, -0.0338F, 0.1265F));

		PartDefinition MetalRod1Top_r1 = FrankenstineBrain.addOrReplaceChild("MetalRod1Top_r1", CubeListBuilder.create().texOffs(77, 58).addBox(-1.0F, -3.75F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F))
		.texOffs(12, 30).addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.7F, 6.0F, 0.1745F, 0.0F, -0.3491F));

		PartDefinition BrainLarge = FrankenstineBrain.addOrReplaceChild("BrainLarge", CubeListBuilder.create().texOffs(0, 18).addBox(-2.75F, -1.5F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.2F))
		.texOffs(0, 18).addBox(0.75F, -1.5F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.2F))
		.texOffs(0, 0).addBox(-1.0F, -1.5F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 2.5F, 5.5F, 0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void animateHeart(boolean isActive, boolean hasHeart, ModelPart heart, float value){
		if (hasHeart){
			heart.visible = true;
			if (isActive){
				heart.xScale =1+ Mth.sin(value/4)/6;
				heart.zScale =1+ Mth.sin(value/4)/6;
				heart.yScale =1+ Mth.cos(value/4)/6;
			}
		}else{
			heart.visible = false;
		}
	}
	private void animateBrain(boolean isActive,boolean hasBrain,ModelPart brain,float value){
		if (hasBrain){
			brain.visible = true;
			if (isActive){
				brain.xScale =1+ Mth.sin(value/6)/6;
				brain.zScale =1+ Mth.sin(value/6)/6;
				brain.yScale =1+ Mth.sin(value/6)/6;
			}
		}else{
			brain.visible = false;
		}
	}
	private void animateBlood(boolean isActive,boolean biomass,ModelPart blood,float value){
		if (biomass){
			blood.visible = true;
			if (isActive){
				blood.yScale =1+ Mth.sin(value/5)/2;
			}
		}else{
			blood.visible = false;
		}
	}
	private void animateInnards(boolean isActive,boolean innard,ModelPart innards,float value){
		if (innard){
			innards.visible = true;
			if (isActive){
				innards.xScale =1+ Mth.sin(value/7)/10;
				innards.zScale =1+ Mth.sin(value/8)/10;
				innards.yScale =1+ Mth.sin(value/6)/10;
			}
		}else{
			innards.visible = false;
		}
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		animateBrain(entity.isActive(),entity.HasBrain(),Brain,ageInTicks);
		animateBlood(entity.isActive(),entity.getBiomass()>0,Blood,ageInTicks);
		animateHeart(entity.isActive(), entity.HasHeart(), Heart,ageInTicks);
		animateInnards(entity.isActive(),entity.getAmountOfInnards()>0,InnardsTop,ageInTicks);
		animateInnards(entity.isActive(),entity.getAmountOfInnards()>1,InnardsDown,-ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}