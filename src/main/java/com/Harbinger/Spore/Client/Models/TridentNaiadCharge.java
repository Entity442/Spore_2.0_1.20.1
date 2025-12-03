package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Naiad;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class TridentNaiadCharge<T extends Naiad> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "tridentnaiadcharge"), "main");
	private final ModelPart bodySpin;
	private final ModelPart chargeBody;

	public TridentNaiadCharge() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.bodySpin = root.getChild("bodySpin");
		this.chargeBody = this.bodySpin.getChild("chargeBody");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bodySpin = partdefinition.addOrReplaceChild("bodySpin", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.5F, 0.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition chargeBody = bodySpin.addOrReplaceChild("chargeBody", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -10.5F, -10.0F, 16.0F, 31.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -4.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		chargeBody.yRot = (ageInTicks * 0.1f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		bodySpin.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}