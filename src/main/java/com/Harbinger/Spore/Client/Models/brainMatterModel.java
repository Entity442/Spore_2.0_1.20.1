package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.BrainRemnantBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class brainMatterModel<T extends BrainRemnantBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "brainmattermodel"), "main");
	private final ModelPart lobes;
	private final ModelPart lobes2;
	private final ModelPart lobes3;
	private final ModelPart lobes4;
	private final ModelPart lobes5;
	private final ModelPart lobes6;
	private final ModelPart lobes7;
	private final ModelPart lobes8;

	public brainMatterModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.lobes = root.getChild("lobes");
		this.lobes2 = root.getChild("lobes2");
		this.lobes3 = root.getChild("lobes3");
		this.lobes4 = root.getChild("lobes4");
		this.lobes5 = root.getChild("lobes5");
		this.lobes6 = root.getChild("lobes6");
		this.lobes7 = root.getChild("lobes7");
		this.lobes8 = root.getChild("lobes8");
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		this.lobes.yScale = 1 + Mth.cos(ageInTicks/9)/11;
		this.lobes.xScale = 1 - Mth.cos(ageInTicks/9)/11;
		this.lobes.zScale = 1 + Mth.cos(ageInTicks/9)/11;
		this.lobes2.yScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes2.xScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes2.zScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes3.yScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes3.xScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes3.zScale = 1 - Mth.cos(ageInTicks/11)/9;
		this.lobes4.yScale = 1 + Mth.cos(ageInTicks/11)/8;
		this.lobes4.xScale = 1 - Mth.cos(ageInTicks/11)/8;
		this.lobes4.zScale = 1 + Mth.cos(ageInTicks/11)/8;
		this.lobes5.yScale = 1 + Mth.cos(ageInTicks/9)/11;
		this.lobes5.xScale = 1 + Mth.cos(ageInTicks/9)/11;
		this.lobes5.zScale = 1 - Mth.cos(ageInTicks/9)/11;
		this.lobes6.yScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes6.xScale = 1 - Mth.cos(ageInTicks/8)/9;
		this.lobes6.zScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes7.yScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes7.xScale = 1 + Mth.cos(ageInTicks/8)/9;
		this.lobes7.zScale = 1 - Mth.cos(ageInTicks/11)/9;
		this.lobes8.yScale = 1 + Mth.cos(ageInTicks/11)/8;
		this.lobes8.xScale = 1 - Mth.cos(ageInTicks/11)/8;
		this.lobes8.zScale = 1 + Mth.cos(ageInTicks/11)/8;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition lobes = partdefinition.addOrReplaceChild("lobes", CubeListBuilder.create().texOffs(48, 0).addBox(-8.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes2 = partdefinition.addOrReplaceChild("lobes2", CubeListBuilder.create().texOffs(0, 48).addBox(0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes3 = partdefinition.addOrReplaceChild("lobes3", CubeListBuilder.create().texOffs(24, 40).addBox(-8.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes4 = partdefinition.addOrReplaceChild("lobes4", CubeListBuilder.create().texOffs(0, 32).addBox(0.0F, 0.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes5 = partdefinition.addOrReplaceChild("lobes5", CubeListBuilder.create().texOffs(24, 24).addBox(0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes6 = partdefinition.addOrReplaceChild("lobes6", CubeListBuilder.create().texOffs(24, 8).addBox(-8.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes7 = partdefinition.addOrReplaceChild("lobes7", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition lobes8 = partdefinition.addOrReplaceChild("lobes8", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -8.0F, 0.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		lobes.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lobes8.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}