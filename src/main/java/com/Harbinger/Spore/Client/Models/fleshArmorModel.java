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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class fleshArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "flesharmormodel"), "main");
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;
	public final ModelPart leftLeg;
	public final ModelPart rightLeg;
	public final ModelPart pelvis;
	public final ModelPart body;
	public final ModelPart heart;
	public final ModelPart rightLung;
	public final ModelPart leftLung;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart headwear;

	public fleshArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
		this.leftLeg = root.getChild("leftLeg");
		this.rightLeg = root.getChild("rightLeg");
		this.pelvis = root.getChild("pelvis");
		this.body = root.getChild("body");
		this.heart = this.body.getChild("heart");
		this.rightLung = this.body.getChild("rightLung");
		this.leftLung = this.body.getChild("leftLung");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.headwear = root.getChild("headwear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r1 = leftBoot.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 58).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 12.0F, 3.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r2 = leftBoot.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 59).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 13.0F, -4.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r3 = leftBoot.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 59).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 13.0F, -4.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r4 = leftBoot.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 50).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 6.0F, 2.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r5 = leftBoot.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(44, 32).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 6.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(16, 50).addBox(-2.0F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r6 = rightBoot.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(48, 58).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 12.0F, 3.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = rightBoot.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 59).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 13.0F, -4.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r8 = rightBoot.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 59).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 13.0F, -4.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition cube_r9 = rightBoot.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 6.0F, 2.5F, 0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r10 = rightBoot.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(44, 50).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 6.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(20, 40).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r11 = leftLeg.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(52, 40).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r12 = leftLeg.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(56, 55).addBox(0.0F, -0.25F, -1.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(36, 40).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r13 = rightLeg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(56, 32).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r14 = rightLeg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(56, 48).addBox(0.0F, -0.25F, -1.0F, 4.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition pelvis = partdefinition.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(24, 16).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.3F))
				.texOffs(32, 10).addBox(-3.5F, 6.5F, -2.45F, 7.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(56, 55).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.71F)), PartPose.offsetAndRotation(2.5F, 4.0F, 3.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(32, 58).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(-2.3F, 4.0F, 3.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition heart = body.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 3.8F, -1.75F, 0.0F, -0.0873F, 0.0F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(18, 60).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.3F))
				.texOffs(40, 58).addBox(-0.1619F, -0.9413F, -1.05F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.1748F, -0.5848F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(60, 20).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition rightLung = body.addOrReplaceChild("rightLung", CubeListBuilder.create().texOffs(6, 59).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
				.texOffs(12, 60).addBox(-1.5F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-2.0F, 2.5F, -3.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition leftLung = body.addOrReplaceChild("leftLung", CubeListBuilder.create().texOffs(12, 60).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.2F))
				.texOffs(6, 59).addBox(-0.5F, 0.0F, 0.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(2.15F, 2.5F, -3.0F, 0.0F, -0.1745F, -0.1745F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(0, 41).addBox(-3.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F))
				.texOffs(48, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(44, 22).addBox(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.35F))
				.texOffs(48, 10).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.001F))
				.texOffs(24, 22).addBox(-4.0F, -8.6F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(24, 31).addBox(2.0F, -8.6F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(69, 33).addBox(2.0F, -13.4F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(-1.0F))
				.texOffs(69, 33).addBox(-1.0F, -13.4F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(-1.0F))
				.texOffs(69, 33).addBox(-4.0F, -13.4F, -4.0F, 2.0F, 6.0F, 8.0F, new CubeDeformation(-1.0F))
				.texOffs(0, 32).addBox(-1.0F, -8.6F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateHeart(float age){
		float val = Mth.sin(age/6)/6;
		this.heart.xScale = 1 + val;
		this.heart.zScale = 1 + val;
		this.heart.yScale = 1 - val;
	}
	private void animateLung(ModelPart part,float age){
		float val = Mth.sin(age/8)/4;
		part.xScale = 1 + val;
		part.yScale = 1 - val;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateHeart(ageInTicks);
		animateLung(leftLung,ageInTicks);
		animateLung(rightLung,ageInTicks);
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