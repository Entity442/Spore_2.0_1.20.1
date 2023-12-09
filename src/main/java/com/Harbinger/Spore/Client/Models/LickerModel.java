package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.FallenMultipart.Licker;
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

public class LickerModel<T extends Licker> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "lickermodel"), "main");
	private final ModelPart Licker;
	private final ModelPart Tumors;
	private final ModelPart Licker1;
	private final ModelPart Licker2;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart Tendrils;

	public LickerModel(ModelPart root) {
		this.Licker = root.getChild("Licker");
		this.Tumors = Licker.getChild("Tumors");
		this.Licker1 = Licker.getChild("LickerSeg2");
		this.Licker2 = Licker1.getChild("LickerSeg3");
		this.Head = Licker2.getChild("ToungeHead");
		this.RightArm = Licker2.getChild("RightArm");
		this.LeftArm = Licker2.getChild("LeftArm");
		this.Tendrils = Licker.getChild("tendrils");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Licker = partdefinition.addOrReplaceChild("Licker", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7284F, 20.3504F, 7.5193F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Tumors = Licker.addOrReplaceChild("Tumors", CubeListBuilder.create().texOffs(361, 269).addBox(-2.4835F, -1.0167F, -2.0773F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4835F, -1.9833F, -2.9227F));

		PartDefinition TumorBase3_r1 = Tumors.addOrReplaceChild("TumorBase3_r1", CubeListBuilder.create().texOffs(364, 272).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.467F, -2.4666F, -1.3454F, 1.2452F, 1.3339F, -0.4916F));

		PartDefinition TumorBase1_r1 = Tumors.addOrReplaceChild("TumorBase1_r1", CubeListBuilder.create().texOffs(359, 269).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9835F, -0.5167F, -0.5773F, 0.7209F, 0.544F, -0.5323F));

		PartDefinition LickerSeg2 = Licker.addOrReplaceChild("LickerSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3531F, -0.8512F, -6.663F, 0.5236F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r1 = LickerSeg2.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(236, 192).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2371F, 0.171F, 0.4551F, -0.3054F, 0.0F, -0.5236F));

		PartDefinition LickerSeg3 = LickerSeg2.addOrReplaceChild("LickerSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0601F, -1.175F, -4.7707F, -0.3906F, 0.0338F, 0.1701F));

		PartDefinition TorsoTop_r1 = LickerSeg3.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(356, 424).addBox(-3.7511F, -2.2061F, -7.0017F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1646F, -0.2037F, 0.4476F, -0.2182F, 0.0F, -0.5236F));

		PartDefinition Tumor1 = LickerSeg3.addOrReplaceChild("Tumor1", CubeListBuilder.create().texOffs(371, 277).addBox(-1.2623F, -1.7544F, -0.4467F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2972F, -2.654F, -1.7743F));

		PartDefinition ToungeHead = LickerSeg3.addOrReplaceChild("ToungeHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadBase_r1 = ToungeHead.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(355, 315).addBox(-3.5265F, 2.3034F, -3.1802F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(386, 261).addBox(-3.5265F, -3.6966F, -7.1802F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -1.6955F, -6.2221F, 0.0F, 0.0F, -0.5236F));

		PartDefinition JawRight = ToungeHead.addOrReplaceChild("JawRight", CubeListBuilder.create(), PartPose.offset(2.6647F, -0.0268F, -8.7908F));

		PartDefinition JawRight_r1 = JawRight.addOrReplaceChild("JawRight_r1", CubeListBuilder.create().texOffs(160, 20).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8908F, 0.5407F, -0.4599F, 0.4566F, 0.1556F, -0.9945F));

		PartDefinition JawLeft = ToungeHead.addOrReplaceChild("JawLeft", CubeListBuilder.create(), PartPose.offset(-0.0763F, 0.9327F, -8.2995F));

		PartDefinition JawLeft_r1 = JawLeft.addOrReplaceChild("JawLeft_r1", CubeListBuilder.create().texOffs(304, 433).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4893F, 0.9959F, -1.1028F, 0.5543F, -0.2071F, 0.0084F));

		PartDefinition ToungeCorpseHeadTumor = ToungeHead.addOrReplaceChild("ToungeCorpseHeadTumor", CubeListBuilder.create(), PartPose.offset(-0.8953F, -1.6955F, -11.2221F));

		PartDefinition ToungeCorpseHeadTumor_r1 = ToungeCorpseHeadTumor.addOrReplaceChild("ToungeCorpseHeadTumor_r1", CubeListBuilder.create().texOffs(372, 274).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4393F, 0.0074F, -1.227F, 0.2856F, 0.5973F, -1.0896F));

		PartDefinition ToungeCorpseHeadTumor_r2 = ToungeCorpseHeadTumor.addOrReplaceChild("ToungeCorpseHeadTumor_r2", CubeListBuilder.create().texOffs(368, 269).addBox(-2.75F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -2.0F, 0.5976F, 0.2849F, -0.3917F));

		PartDefinition LeftArm = LickerSeg3.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 279).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4854F, 0.8039F, -3.7358F, -0.7418F, 0.0F, -0.3054F));

		PartDefinition RightArm = LickerSeg3.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(162, 323).addBox(-1.0359F, -0.7439F, -1.0697F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5848F, -2.6479F, -4.2234F, -0.5236F, 0.0F, -0.9948F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create(), PartPose.offset(0.4624F, 4.1404F, 0.4303F));

		PartDefinition RightArmSeg2_r1 = RightArmSeg2.addOrReplaceChild("RightArmSeg2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0018F, -0.1343F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition tendrils = Licker.addOrReplaceChild("tendrils", CubeListBuilder.create(), PartPose.offset(3.0F, -3.0F, 0.0F));

		PartDefinition cube_r1 = tendrils.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(365, 272).addBox(-3.0F, -3.0F, -1.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(369, 271).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(366, 273).addBox(-3.0F, 1.0F, -1.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(361, 270).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(366, 273).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0436F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Tumors.xScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tumors.zScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tumors.yScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Licker1.yRot = Mth.sin(ageInTicks/7)/8;
		this.Licker2.xRot = Mth.sin(ageInTicks/9)/8;
		this.RightArm.xRot = Mth.cos(ageInTicks/5)/6;
		this.LeftArm.xRot = -Mth.cos(ageInTicks/6)/5;

		this.Head.zRot = Mth.sin(ageInTicks/8)/8;
		this.Tendrils.xScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tendrils.yScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tendrils.zScale = 1f + Mth.sin(ageInTicks/8)/4;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Licker.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}