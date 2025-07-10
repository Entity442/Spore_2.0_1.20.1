package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.5
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
import net.minecraft.world.entity.LivingEntity;

public class platedArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "platedarmormodel"), "main");
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart body;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart headwear;

	public platedArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.body = root.getChild("body");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.headwear = root.getChild("headwear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(46, 43).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r1 = leftBoot.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 52).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r2 = leftBoot.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(30, 54).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r3 = leftBoot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 52).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(40, 22).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(-2.1F, 12.0F, 0.0F));

		PartDefinition cube_r4 = rightBoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 22).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r5 = rightBoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(14, 56).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r6 = rightBoot.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(52, 31).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(36, 32).addBox(-1.9F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r7 = leftLeg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(52, 6).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r8 = leftLeg.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(40, 60).addBox(0.0F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(16, 39).addBox(-2.1F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.6F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r9 = rightLeg.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(60, 14).addBox(0.0F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r10 = rightLeg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.02F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, -1.2F, 0.0F));

		PartDefinition cube_r11 = spine.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(62, 38).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 9.166F, 3.3F, -1.3852F, 0.0095F, 0.0174F));

		PartDefinition cube_r12 = spine.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(60, 19).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 8.032F, 3.0F, -1.7279F, 0.0F, 0.0F));

		PartDefinition cube_r13 = spine.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.2294F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 11.536F, 2.4F, -1.8326F, 0.0F, 0.0F));

		PartDefinition cube_r14 = spine.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(62, 44).addBox(-1.0F, -0.6287F, -1.5094F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 3.418F, 2.85F, -1.3788F, 0.0F, 0.0F));

		PartDefinition cube_r15 = spine.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(62, 41).addBox(-1.0F, 0.4781F, -2.8277F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 3.218F, 4.0F, -1.3439F, 0.0F, 0.0F));

		PartDefinition cube_r16 = spine.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(52, 39).addBox(-1.0F, -2.06F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 6.584F, 1.65F, -1.4835F, 0.0F, 0.0F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition right_arm_r1 = rightArm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(14, 50).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 1.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r2 = rightArm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(58, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.6F, 2.3F, 0.0F, 0.0F, -0.3752F));

		PartDefinition right_arm_r3 = rightArm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(50, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.0F, 1.4F, 0.0F, 0.0F, 0.0262F));

		PartDefinition right_arm_r4 = rightArm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(32, 43).addBox(-4.0F, -12.0F, -1.0F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, 1.2F, -0.8F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r5 = rightArm.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -11.0F, -1.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 3.0F, 0.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition cube_r17 = rightArm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(30, 62).addBox(-0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 10.0F, -2.2F, 2.5831F, -0.1582F, -0.2095F));

		PartDefinition cube_r18 = rightArm.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 30).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 10.0F, -2.2F, 2.5831F, 0.1582F, 0.2095F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition left_arm_r1 = leftArm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(16, 32).addBox(0.2F, 0.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(4.8F, -2.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition left_arm_r2 = leftArm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(40, 15).addBox(-1.8F, -4.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r19 = leftArm.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(24, 56).addBox(-0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, 10.0F, -2.2F, 2.5831F, -0.1582F, -0.2095F));

		PartDefinition cube_r20 = leftArm.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(62, 5).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 10.0F, -2.2F, 2.5831F, 0.1582F, 0.2095F));

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.01F))
		.texOffs(32, 6).addBox(-1.0F, -9.0F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(1.0F))
		.texOffs(27, -12).addBox(0.0F, -12.0F, -6.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, -8).addBox(-3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, -8).addBox(3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

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
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}