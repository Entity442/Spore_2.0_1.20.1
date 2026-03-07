package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Projectile.HarpoonProjectile;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class HarpoonModel<T extends HarpoonProjectile> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "harpoonmodel"), "main");
	private final ModelPart harpoon;

	public HarpoonModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.harpoon = root.getChild("harpoon");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition harpoon = partdefinition.addOrReplaceChild("harpoon", CubeListBuilder.create().texOffs(975, 345).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(1009, 378).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(1010, 364).addBox(0.0F, -4.0F, -7.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 364).addBox(-4.0F, 0.0F, -7.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 364).mirror().addBox(0.0F, 0.0F, -7.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition cube_r1 = harpoon.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1006, 422).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(1000, 377).addBox(-2.0F, 0.0F, -18.5F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r2 = harpoon.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(1006, 422).addBox(-1.5F, 0.0F, -1.0F, 3.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(1012, 377).addBox(-2.0F, 0.0F, -18.5F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition backPlane_r1 = harpoon.addOrReplaceChild("backPlane_r1", CubeListBuilder.create().texOffs(1010, 364).addBox(0.0F, -2.0F, -4.5F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -2.5F, 0.0F, 0.0F, -3.1416F));

		return LayerDefinition.create(meshdefinition, 1028, 1028);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		harpoon.y = harpoon.getInitialPose().y-4f;
		harpoon.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}