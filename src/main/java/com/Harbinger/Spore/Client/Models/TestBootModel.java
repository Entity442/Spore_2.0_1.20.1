package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class TestBootModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "testbootmodel"), "main");
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart pelvis;
	public final ModelPart body;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart headwear;
	public final ModelPart theenfunganizing;
	public final ModelPart flowers;
	public final ModelPart flower2;
	public final ModelPart flower3;
	public final ModelPart flower4;

	public TestBootModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.pelvis = root.getChild("pelvis");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.headwear = root.getChild("headwear");
		this.theenfunganizing = this.headwear.getChild("theenfunganizing");
		this.flowers = this.theenfunganizing.getChild("flowers");
		this.flower2 = this.flowers.getChild("flower2");
		this.flower3 = this.flowers.getChild("flower3");
		this.flower4 = this.flowers.getChild("flower4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(24, 60).addBox(-1.9F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r1 = leftBoot.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 50).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.25F, -3.0F, -0.3491F, 0.7854F, -0.2618F));

		PartDefinition cube_r2 = leftBoot.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.25F, -3.75F, -0.3491F, 0.7854F, -0.2618F));

		PartDefinition cube_r3 = leftBoot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 67).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.25F, -2.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(24, 60).addBox(-1.9F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offset(-2.1F, 12.0F, 0.0F));

		PartDefinition cube_r4 = rightBoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(36, 50).addBox(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.25F, -3.0F, -0.3491F, 0.7854F, -0.2618F));

		PartDefinition cube_r5 = rightBoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(24, 50).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.25F, -3.75F, -0.3491F, 0.7854F, -0.2618F));

		PartDefinition cube_r6 = rightBoot.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 67).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.25F, -2.75F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(24, 60).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(64, 35).addBox(2.0F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(24, 60).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(64, 35).addBox(-3.0F, 0.0F, -2.0F, 1.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition pelvis = partdefinition.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 70).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 70).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r9 = rightArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(64, 10).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, -0.3932F, -0.2753F, 1.4773F));

		PartDefinition cube_r10 = rightArm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(64, 10).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, 0.4236F, -0.573F, 0.1789F));

		PartDefinition cube_r11 = rightArm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(67, 10).addBox(-3.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 1.0F, 0.0F, -0.6981F, 0.8727F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(24, 16).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r12 = leftArm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(64, 10).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 1.0F, -0.3932F, 0.2753F, -1.4773F));

		PartDefinition cube_r13 = leftArm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(64, 10).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 1.0F, 0.4236F, 0.573F, -0.1789F));

		PartDefinition cube_r14 = leftArm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(64, 10).addBox(-1.0F, 0.0F, -4.0F, 4.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 1.0F, 0.0F, 0.6981F, -0.8727F));

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition theenfunganizing = headwear.addOrReplaceChild("theenfunganizing", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -3.0F));

		PartDefinition cube_r15 = theenfunganizing.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 4.0F, -0.3491F, -0.2182F, 0.2618F));

		PartDefinition cube_r16 = theenfunganizing.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(56, 6).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, 2.0F, 0.3054F, 0.0F, -0.3054F));

		PartDefinition cube_r17 = theenfunganizing.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 5.0F, 0.0873F, 0.4363F, 0.3927F));

		PartDefinition flowers = theenfunganizing.addOrReplaceChild("flowers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition flower2 = flowers.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -3.0F, 1.0F, 0.5672F, 0.5672F, -0.6981F));

		PartDefinition cube_r18 = flower2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(40, 12).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r19 = flower2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(40, 12).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r20 = flower2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r21 = flower2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = flowers.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -3.0F, 0.0F, 0.6545F, 0.4363F, 1.0472F));

		PartDefinition cube_r22 = flower3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(40, 12).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r23 = flower3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(40, 12).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r24 = flower3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r25 = flower3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = flowers.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, 6.0F, -0.7854F, 0.3927F, -0.2182F));

		PartDefinition cube_r26 = flower4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(40, 12).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition cube_r27 = flower4.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(40, 12).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r28 = flower4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r29 = flower4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(40, 12).addBox(-3.0F, 0.0F, -6.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		leftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pelvis.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}