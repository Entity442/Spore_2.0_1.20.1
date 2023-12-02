package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Sieger;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SantaModel<T extends Sieger> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "santamodel"), "main");
	private final ModelPart SantaHat;

	public SantaModel(ModelPart root) {
		this.SantaHat = root.getChild("SantaHat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SantaHat = partdefinition.addOrReplaceChild("SantaHat", CubeListBuilder.create().texOffs(416, 0).addBox(-12.0F, -4.25F, -10.0F, 24.0F, 6.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.0F, -37.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition HatSeg1 = SantaHat.addOrReplaceChild("HatSeg1", CubeListBuilder.create().texOffs(432, 30).addBox(-10.0F, -7.75F, -10.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 2.0F));

		PartDefinition HatSeg2 = HatSeg1.addOrReplaceChild("HatSeg2", CubeListBuilder.create().texOffs(448, 56).addBox(-8.0F, -3.0F, -8.0F, 16.0F, 9.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -10.4952F, -0.3267F, 0.0F, 0.0F, 0.2618F));

		PartDefinition HatSeg3 = HatSeg2.addOrReplaceChild("HatSeg3", CubeListBuilder.create().texOffs(456, 81).addBox(-6.25F, -4.5F, -7.0F, 14.0F, 9.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5561F, -5.1783F, -0.1622F, 0.0F, 0.0F, 0.1745F));

		PartDefinition HatSeg4 = HatSeg3.addOrReplaceChild("HatSeg4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2112F, -4.973F, -1.2327F, 0.0F, 0.0F, 0.1745F));

		PartDefinition HatSeg4_r1 = HatSeg4.addOrReplaceChild("HatSeg4_r1", CubeListBuilder.create().texOffs(400, 0).addBox(-5.0F, -4.5F, -3.25F, 10.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0469F, 0.0F));

		PartDefinition HatSeg5 = HatSeg4.addOrReplaceChild("HatSeg5", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition HatSeg5_r1 = HatSeg5.addOrReplaceChild("HatSeg5_r1", CubeListBuilder.create().texOffs(392, 22).addBox(-4.0F, -0.5F, -2.25F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0469F, 0.0F));

		PartDefinition HatKnob = HatSeg5.addOrReplaceChild("HatKnob", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Puff_r1 = HatKnob.addOrReplaceChild("Puff_r1", CubeListBuilder.create().texOffs(392, 37).addBox(-5.0F, -10.5F, -3.5F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0469F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		SantaHat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}