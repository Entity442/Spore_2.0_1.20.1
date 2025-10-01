package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Projectile.SyringeProjectile;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class SyringeProjectileModel<T extends SyringeProjectile> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "syringeprojectile"), "main");
	private final ModelPart syringe;
	private final ModelPart color;

	public SyringeProjectileModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.syringe = root.getChild("syringe");
		this.color = this.syringe.getChild("color");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition syringe = partdefinition.addOrReplaceChild("syringe", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -3.88F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F))
		.texOffs(8, 8).addBox(-0.5F, -7.25F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(12, 2).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.3F))
		.texOffs(0, 6).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(8, 0).addBox(-1.0F, 2.98F, -1.0F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition color = syringe.addOrReplaceChild("color", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -3.85F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		syringe.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}