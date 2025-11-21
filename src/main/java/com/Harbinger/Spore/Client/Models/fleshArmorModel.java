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
	public final ModelPart headwear;
	public final ModelPart tendril;
	public final ModelPart body;
	public final ModelPart heart;
	public final ModelPart rightLung;
	public final ModelPart leftLung;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;
	public final ModelPart pelvis;

	public fleshArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.headwear = root.getChild("headwear");
		this.tendril = this.headwear.getChild("tendril");
		this.body = root.getChild("body");
		this.heart = this.body.getChild("heart");
		this.rightLung = this.body.getChild("rightLung");
		this.leftLung = this.body.getChild("leftLung");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
		this.pelvis = root.getChild("pelvis");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition brain_r1 = headwear.addOrReplaceChild("brain_r1", CubeListBuilder.create().texOffs(50, 0).addBox(-3.0F, -4.0F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tendril = headwear.addOrReplaceChild("tendril", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, 7.0F));

		PartDefinition cube_r1 = tendril.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(50, 36).addBox(1.0F, -1.9281F, -1.611F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.6F, 0.0F, 0.3927F, 0.4363F, 0.0F));

		PartDefinition cube_r2 = tendril.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(50, 36).addBox(1.0F, -1.9281F, -1.611F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.6F, -1.0F, 0.3927F, -0.4363F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F))
				.texOffs(0, 31).addBox(0.0F, -1.0F, 2.75F, 0.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 20).mirror().addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.25F, 1.0F, 3.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 20).addBox(-2.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 1.0F, 3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition heart = body.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 3.8F, -2.05F, -0.0263F, -0.0832F, 0.3065F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(18, 60).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.0752F, -0.8348F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(57, 20).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r3 = heart.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(36, 56).addBox(-2.1619F, -2.9413F, -1.05F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-0.8252F, 0.4152F, -1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition rightLung = body.addOrReplaceChild("rightLung", CubeListBuilder.create().texOffs(6, 58).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F))
				.texOffs(12, 59).addBox(-1.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 3.5F, -3.0F, 0.0F, 0.1745F, 0.1745F));

		PartDefinition leftLung = body.addOrReplaceChild("leftLung", CubeListBuilder.create().texOffs(12, 59).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F))
				.texOffs(6, 58).addBox(-0.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, 3.5F, -3.0F, 0.0F, -0.1745F, -0.1745F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(32, 0).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r5 = rightArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(60, 55).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, -2.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r6 = rightArm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(60, 55).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(16, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F))
				.texOffs(60, 55).addBox(3.0F, -4.0F, -1.5F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(60, 55).addBox(3.0F, -4.0F, 1.5F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(32, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F))
				.texOffs(24, 25).addBox(-0.2F, 1.0F, -3.25F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(40, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F))
				.texOffs(24, 25).addBox(0.0F, 1.0F, -3.25F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(32, 43).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(0, 48).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition pelvis = partdefinition.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	private void animateHeart(float age){
		float val = Mth.sin(age/6)/6;
		this.heart.xScale = 1 + val;
		this.heart.zScale = 1 + val;
		this.heart.yScale = 1 - val;
	}
	private void animateLung(ModelPart part, float age){
		float val = Mth.sin(age/8)/4;
		part.xScale = 1 + val;
		part.yScale = 1 - val;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateHeart(ageInTicks);
		animateLung(leftLung,ageInTicks);
		animateLung(rightLung,ageInTicks);
		this.tendril.xRot = Mth.cos(ageInTicks/6)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		headwear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		pelvis.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}