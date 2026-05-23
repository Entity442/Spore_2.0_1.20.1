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


public class DragonTailPieceStartModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragontailpiecestartmodel"), "main");
	private final ModelPart yuri;
	private final ModelPart calcium;

	public DragonTailPieceStartModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yuri = root.getChild("yuri");
		this.calcium = this.yuri.getChild("calcium");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yuri = partdefinition.addOrReplaceChild("yuri", CubeListBuilder.create().texOffs(72, 52).addBox(-2.4167F, -8.0F, -7.4167F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 79).addBox(0.5833F, -8.0F, -15.4167F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5833F, 16.0F, 0.4167F));

		PartDefinition cube_r1 = yuri.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 25).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9167F, 0.0F, 2.0833F, -0.2182F, 0.0F, -0.1745F));

		PartDefinition cube_r2 = yuri.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(36, 0).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0833F, 0.0F, 2.0833F, -0.1289F, 0.0227F, 0.1731F));

		PartDefinition cube_r3 = yuri.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0833F, 0.0F, -1.9167F, 0.2182F, 0.0F, 0.1745F));

		PartDefinition cube_r4 = yuri.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9167F, 0.0F, -1.9167F, 0.0852F, 0.0189F, -0.2174F));

		PartDefinition calcium = yuri.addOrReplaceChild("calcium", CubeListBuilder.create(), PartPose.offset(-2.9167F, 0.0F, 3.0833F));

		PartDefinition cube_r5 = calcium.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 65).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1949F, -2.0241F, 3.5048F, -1.5776F, 1.3591F, -1.001F));

		PartDefinition cube_r6 = calcium.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 65).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8051F, -5.0241F, -7.4952F, 0.2001F, -0.2624F, 0.1914F));

		PartDefinition cube_r7 = calcium.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 65).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1949F, -8.0241F, -4.4952F, 0.2F, -0.1139F, 1.3355F));

		PartDefinition cube_r8 = calcium.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(48, 50).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1949F, -8.0241F, -4.4952F, 0.1641F, -0.1616F, 1.5955F));

		PartDefinition cube_r9 = calcium.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(24, 50).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1949F, -7.0241F, 2.5048F, -1.3631F, 0.0025F, 1.7393F));

		PartDefinition cube_r10 = calcium.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 50).addBox(-1.5F, -3.0F, -4.5F, 3.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1949F, -8.0241F, -1.4952F, -1.5377F, 0.0066F, 1.3895F));

		PartDefinition cube_r11 = calcium.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(72, 0).addBox(-1.5F, -2.0F, -4.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -3.0F, -0.5F, -1.6106F, -0.0896F, 0.1699F));

		PartDefinition cube_r12 = calcium.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(72, 39).addBox(-1.5F, -2.0F, -4.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -3.0F, -8.5F, -1.5951F, 0.2538F, -0.0136F));

		PartDefinition cube_r13 = calcium.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(72, 26).addBox(-1.5F, -2.0F, -4.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -5.0F, 1.5F, -0.0225F, -0.18F, 0.0342F));

		PartDefinition cube_r14 = calcium.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(72, 13).addBox(-1.5F, -2.0F, -4.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -8.0F, -7.5F, -0.4378F, 0.0791F, -1.7823F));

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