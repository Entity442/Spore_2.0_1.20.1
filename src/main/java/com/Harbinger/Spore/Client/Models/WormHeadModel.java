package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
public class WormHeadModel<T extends Hohlfresser> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "custommodel"), "main");
	private final ModelPart body;
	private final ModelPart jaw;
	private final ModelPart jaw2;
	private final ModelPart jaw3;

	public WormHeadModel(ModelPart root) {
		this.body = root.getChild("body");
		this.jaw = this.body.getChild("jaw");
		this.jaw2 = this.body.getChild("jaw2");
		this.jaw3 = this.body.getChild("jaw3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -32.0F, -1.0F, 32.0F, 32.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition jaw = body.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 57).addBox(-15.0F, -2.0F, -12.0F, 30.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -31.0F, -1.0F));

		PartDefinition cube_r1 = jaw.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 102).addBox(-12.0F, -2.0F, -12.0F, 24.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -24.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r2 = jaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(86, 72).addBox(-14.0F, -2.0F, -12.0F, 28.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition jaw2 = body.addOrReplaceChild("jaw2", CubeListBuilder.create().texOffs(0, 72).addBox(-15.0F, -2.0F, -12.0F, 30.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -4.0F, -1.0F, 0.0F, 0.0F, -2.2689F));

		PartDefinition cube_r3 = jaw2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(74, 102).addBox(-12.0F, -2.0F, -12.0F, 24.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -24.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r4 = jaw2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 87).addBox(-14.0F, -2.0F, -12.0F, 28.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition jaw3 = body.addOrReplaceChild("jaw3", CubeListBuilder.create().texOffs(86, 57).addBox(-15.0F, -2.0F, -12.0F, 30.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -4.0F, -1.0F, 0.0F, 0.0F, 2.2689F));

		PartDefinition cube_r5 = jaw3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(114, 0).addBox(-12.0F, -2.0F, -12.0F, 24.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, -24.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r6 = jaw3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(82, 87).addBox(-14.0F, -2.0F, -12.0F, 28.0F, 2.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.3491F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}