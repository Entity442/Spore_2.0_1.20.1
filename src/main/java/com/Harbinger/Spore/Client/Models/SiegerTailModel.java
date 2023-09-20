package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
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

public class SiegerTailModel<T extends SiegerTail> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "siegertailmodel"), "main");
	private final ModelPart tail;
	private final ModelPart gore;

	public SiegerTailModel(ModelPart root) {
		this.tail = root.getChild("tail");
		this.gore = root.getChild("gore");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail = partdefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, 20.0F, -13.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition tailjoint = tail.addOrReplaceChild("tailjoint", CubeListBuilder.create().texOffs(97, 0).addBox(-5.0F, -4.2201F, 0.137F, 10.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.7799F, -0.137F));

		PartDefinition tail2 = tailjoint.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 27.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition tailjoint2 = tail2.addOrReplaceChild("tailjoint2", CubeListBuilder.create().texOffs(119, 206).addBox(-4.5F, -4.9163F, -0.0826F, 9.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition tail3 = tailjoint2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 26.5F, 1.3526F, 0.0F, 0.0F));

		PartDefinition tailjoint3 = tail3.addOrReplaceChild("tailjoint3", CubeListBuilder.create().texOffs(191, 206).addBox(-4.0F, -4.9388F, 0.2976F, 8.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail4 = tailjoint3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 27.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition tailjoint4 = tail4.addOrReplaceChild("tailjoint4", CubeListBuilder.create().texOffs(55, 225).addBox(-3.5F, -3.6187F, 0.0213F, 7.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition tumor = tailjoint4.addOrReplaceChild("tumor", CubeListBuilder.create().texOffs(123, 243).addBox(-8.0F, -6.6187F, 6.0213F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -5.6187F, -0.9787F, 12.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 25.0F, 1.3526F, 0.2618F, -0.3054F));

		PartDefinition gore = partdefinition.addOrReplaceChild("gore", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-4.0F, -3.0F, -14.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(11, 3).addBox(-1.0F, -5.0F, -13.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 6).addBox(-3.0F, -5.0F, -12.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 4).addBox(-5.0F, -2.0F, -13.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 21.0F, -7.0F, 0.3054F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.gore.xScale = 1 + Mth.cos(ageInTicks/10)/11;
		this.gore.yScale = 1 - Mth.cos(ageInTicks/12)/11;
		this.gore.zScale = 1 + Mth.cos(ageInTicks/11)/10;
		this.tail.getChild("tailjoint").getChild("tail2").getChild("tailjoint2").xRot = Mth.sin(ageInTicks/15)/15;
		this.tail.getChild("tailjoint").getChild("tail2").getChild("tailjoint2").getChild("tail3").getChild("tailjoint3").xRot = Mth.sin(ageInTicks/15)/15;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		gore.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}