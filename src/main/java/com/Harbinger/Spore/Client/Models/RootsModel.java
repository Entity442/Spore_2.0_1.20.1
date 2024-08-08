package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class RootsModel<T extends Calamity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "rootsmodel"), "main");
	private final ModelPart roots;

	public RootsModel(ModelPart root) {
		this.roots = root.getChild("roots");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition roots = partdefinition.addOrReplaceChild("roots", CubeListBuilder.create().texOffs(0, 0).addBox(-24.0F, -0.25F, -24.0F, 48.0F, 0.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition plants = roots.addOrReplaceChild("plants", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.25F, 11.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition cube_r1 = plants.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition plants2 = roots.addOrReplaceChild("plants2", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -0.25F, -8.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition cube_r2 = plants2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition plants3 = roots.addOrReplaceChild("plants3", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -0.25F, -6.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r3 = plants3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, -16).addBox(0.0F, -6.0F, -8.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	public void extendRoots(T entity){
		roots.xScale = 1+entity.getBbWidth();
		roots.yScale = 1+entity.getBbWidth();
		roots.zScale = 1+entity.getBbWidth();
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		roots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}