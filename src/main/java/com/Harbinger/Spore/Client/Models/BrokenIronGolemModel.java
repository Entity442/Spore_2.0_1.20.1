package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.InfestedConstruct;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BrokenIronGolemModel<T extends InfestedConstruct> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "broken_iron_golem"), "main");
	private final ModelPart Destoryedgolem;
	public BrokenIronGolemModel(ModelPart root) {
		this.Destoryedgolem = root.getChild("Destoryedgolem");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Destoryedgolem = partdefinition.addOrReplaceChild("Destoryedgolem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -7.0F));

		PartDefinition body = Destoryedgolem.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 40).addBox(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, 1.5002F, -0.1448F, 0.0056F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-4.5F, -0.5F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 10.5F, -1.25F, -0.3927F, 0.0F, 0.0F));

		PartDefinition head = Destoryedgolem.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.0F, -1.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -10.0F, -1.3259F, 0.4677F, 0.1122F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.75F, 0.3762F, 0.1153F, -0.2835F));

		PartDefinition right_arm = Destoryedgolem.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(60, 21).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -2.5F, 0.0F, -1.3863F, -0.0127F, 1.5981F));

		PartDefinition left_arm = Destoryedgolem.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(60, 58).addBox(-2.0F, -15.0F, -3.0F, 4.0F, 30.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -8.5F, 5.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition right_leg = Destoryedgolem.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(37, 0).addBox(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -3.0F, 16.0F, 1.4832F, 0.0869F, -0.0076F));

		PartDefinition left_leg = Destoryedgolem.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, -4.0F, 14.0F, 0.9717F, 1.0084F, -0.5238F));

		PartDefinition left_leg_r1 = left_leg.addOrReplaceChild("left_leg_r1", CubeListBuilder.create().texOffs(60, 0).addBox(-3.0F, -8.0F, -2.5F, 6.0F, 16.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6552F, 5.2347F, -1.5571F, 0.1329F, 0.173F, 0.023F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Destoryedgolem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}