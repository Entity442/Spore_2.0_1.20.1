package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;


public class DragonTailPieceMid1Model<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "dragontailpiecemid1model"), "main");
	private final ModelPart yuri;
	private final ModelPart fungus;

	public DragonTailPieceMid1Model() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yuri = root.getChild("yuri");
		this.fungus = this.yuri.getChild("fungus");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yuri = partdefinition.addOrReplaceChild("yuri", CubeListBuilder.create().texOffs(72, 52).addBox(1.5F, -8.0F, -11.0F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 79).addBox(4.5F, -8.0F, -19.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 16.0F, 3.5F));

		PartDefinition cube_r1 = yuri.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 103).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, -1.0F, -0.001F, 0.0227F, 0.0421F));

		PartDefinition cube_r2 = yuri.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 103).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition cube_r3 = yuri.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 103).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, -0.0437F, 0.0038F, -0.0435F));

		PartDefinition fungus = yuri.addOrReplaceChild("fungus", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = fungus.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -1.0F, -9.0F, -0.0786F, -0.3405F, 1.8025F));

		PartDefinition cube_r5 = fungus.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -4.0F, -6.0F, 0.0F, 0.0F, 1.9635F));

		PartDefinition cube_r6 = fungus.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.0F, 3.0F, -2.6616F, 0.2182F, 1.5708F));

		PartDefinition cube_r7 = fungus.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 0.0F, 3.0F, 0.0F, 0.1745F, 2.0071F));

		PartDefinition cube_r8 = fungus.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -3.0F, 4.0F, 0.0F, 0.2618F, 1.8326F));

		PartDefinition cube_r9 = fungus.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -6.0F, 4.0F, 0.0573F, 0.2106F, 1.8387F));

		PartDefinition cube_r10 = fungus.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 1.0F, -0.035F, 0.2595F, 1.4353F));

		PartDefinition cube_r11 = fungus.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, -6.0F, -0.2182F, 0.0F, 1.309F));

		PartDefinition cube_r12 = fungus.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 74).addBox(0.0F, -3.0F, -3.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, -3.0F, 0.6109F, 0.0F, 1.3526F));

		return LayerDefinition.create(meshdefinition, 153, 153);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		yuri.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}