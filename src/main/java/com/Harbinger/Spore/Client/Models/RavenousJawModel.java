package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Spore;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class RavenousJawModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "ravanousjawmodel"), "main");
	public final ModelPart jaw;
	private final ModelPart rightFangTop;
	private final ModelPart leftFangTop;
	private final ModelPart extendedJaw;

	public RavenousJawModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.jaw = root.getChild("jaw");
		this.rightFangTop = this.jaw.getChild("rightFangTop");
		this.leftFangTop = this.jaw.getChild("leftFangTop");
		this.extendedJaw = this.jaw.getChild("extendedJaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition jaw = partdefinition.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightFangTop = jaw.addOrReplaceChild("rightFangTop", CubeListBuilder.create().texOffs(0, 10).addBox(-0.7759F, -0.9047F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.5F, -3.0F, -5.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition cube_r1 = rightFangTop.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 5).addBox(0.0F, -1.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2759F, 0.5953F, -2.75F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r2 = rightFangTop.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 10).addBox(-1.0F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2241F, 0.0953F, -1.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition leftFangTop = jaw.addOrReplaceChild("leftFangTop", CubeListBuilder.create().texOffs(12, 5).addBox(-0.2241F, -0.9047F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.5F, -3.0F, -5.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r3 = leftFangTop.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(6, 5).addBox(0.0F, -1.0F, -3.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2759F, 0.5953F, -2.75F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r4 = leftFangTop.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 9).addBox(0.0F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2241F, 0.0953F, -1.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition extendedJaw = jaw.addOrReplaceChild("extendedJaw", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -0.5F, -2.5F, 11.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(10, 14).addBox(-2.0F, -2.75F, -3.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 13).addBox(1.0F, -2.75F, -3.5F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.5F));

		PartDefinition fang_r1 = extendedJaw.addOrReplaceChild("fang_r1", CubeListBuilder.create().texOffs(4, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 14).addBox(2.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.0F, -2.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition fang_r2 = extendedJaw.addOrReplaceChild("fang_r2", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(12, 13).addBox(-7.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.0F, -2.5F, 0.6545F, 0.0F, 0.0F));

		PartDefinition fang_r3 = extendedJaw.addOrReplaceChild("fang_r3", CubeListBuilder.create().texOffs(8, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.25F, 0.0F, -2.25F, 0.7854F, -0.9599F, 0.0F));

		PartDefinition fang_r4 = extendedJaw.addOrReplaceChild("fang_r4", CubeListBuilder.create().texOffs(6, 14).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.25F, 0.0F, -2.25F, 0.7854F, 0.9599F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val = Mth.sin(ageInTicks/8)/8;
		animateTentacleX(leftFangTop,val);
		animateTentacleX(rightFangTop,val);
		animateTentacleX(extendedJaw,-val);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		jaw.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}