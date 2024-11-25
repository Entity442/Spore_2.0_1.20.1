package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ProtoChritsmasHat<T extends Proto> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "protochritsmashat"), "main");
	private final ModelPart Hat;
	private final ModelPart bell;
	private final ModelPart bell2;

	public ProtoChritsmasHat(ModelPart root) {
		this.Hat = root.getChild("Hat");
		this.bell = root.getChild("bell");
		this.bell2 = root.getChild("bell2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hat = partdefinition.addOrReplaceChild("Hat", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -2.0F, -15.0F, 28.0F, 5.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -29.0F, 0.0F));

		PartDefinition cube_r1 = Hat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 103).addBox(2.0F, -9.0F, -11.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offsetAndRotation(-6.5F, -26.0F, 26.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r2 = Hat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(84, 100).addBox(2.0F, -9.0F, -11.0F, 9.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -23.0F, 20.0F, -1.1345F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Hat.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(100, 35).addBox(1.0F, -12.0F, -15.0F, 10.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -16.0F, 14.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r4 = Hat.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(84, 71).addBox(-4.0F, -8.0F, -15.0F, 18.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -13.0F, 9.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Hat.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 71).addBox(-6.0F, -8.0F, -16.0F, 20.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -7.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Hat.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 35).addBox(-10.0F, -8.0F, -16.0F, 24.0F, 10.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 3.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition bell = partdefinition.addOrReplaceChild("bell", CubeListBuilder.create().texOffs(116, 0).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(34, 103).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -25.0F, 0.0F, 3.1416F, 0.0F, 0.2618F));

		PartDefinition bell2 = partdefinition.addOrReplaceChild("bell2", CubeListBuilder.create().texOffs(116, 13).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(34, 113).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -25.0F, 0.0F, 3.1416F, 0.0F, -0.2618F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Hat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bell2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}