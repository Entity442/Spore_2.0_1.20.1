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
public class livingArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "livingarmormodel"), "main");
	public final ModelPart headwear;
	private final ModelPart tendril;
	public final ModelPart body;
	private final ModelPart heart;
	public final ModelPart rightArm;
	public final ModelPart leftArm;
	public final ModelPart rightLeg;
	public final ModelPart leftLeg;
	public final ModelPart pelvis;
	public final ModelPart leftBoot;
	public final ModelPart rightBoot;

	public livingArmorModel() {
		ModelPart root =createBodyLayer().bakeRoot();
		this.headwear = root.getChild("headwear");
		this.tendril = this.headwear.getChild("tendril");
		this.body = root.getChild("body");
		this.heart = this.body.getChild("heart");
		this.rightArm = root.getChild("rightArm");
		this.leftArm = root.getChild("leftArm");
		this.rightLeg = root.getChild("rightLeg");
		this.leftLeg = root.getChild("leftLeg");
		this.pelvis = root.getChild("pelvis");
		this.leftBoot = root.getChild("leftBoot");
		this.rightBoot = root.getChild("rightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition headwear = partdefinition.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.2F))
		.texOffs(96, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.0F))
		.texOffs(32, 6).addBox(-1.0F, -9.0F, -4.0F, 2.0F, 1.0F, 8.0F, new CubeDeformation(1.0F))
		.texOffs(27, -12).addBox(0.0F, -12.0F, -6.0F, 0.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, -8).addBox(-3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, -8).addBox(3.0F, -10.0F, -4.0F, 0.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition brain_r1 = headwear.addOrReplaceChild("brain_r1", CubeListBuilder.create().texOffs(82, 9).addBox(-3.0F, -4.0F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 3.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition tendril = headwear.addOrReplaceChild("tendril", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.0F, 7.0F));

		PartDefinition cube_r1 = tendril.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(96, 9).addBox(1.0F, -1.9281F, -1.611F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.6F, 0.0F, 0.3927F, 0.4363F, 0.0F));

		PartDefinition cube_r2 = tendril.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(96, 9).addBox(1.0F, -1.9281F, -1.611F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.6F, -1.0F, 0.3927F, -0.4363F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.15F))
		.texOffs(104, 22).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(110, 43).mirror().addBox(-1.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.25F, 1.0F, 3.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(120, 43).addBox(-2.0F, -2.0F, 0.0F, 3.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, 1.0F, 3.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create(), PartPose.offset(0.0F, -1.2F, 0.0F));

		PartDefinition cube_r5 = spine.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(62, 38).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 9.166F, 3.3F, -1.3852F, 0.0095F, 0.0174F));

		PartDefinition cube_r6 = spine.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(60, 19).addBox(-1.0F, -0.2294F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 8.032F, 3.0F, -1.7279F, 0.0F, 0.0F));

		PartDefinition cube_r7 = spine.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(56, 0).addBox(-1.0F, -0.2294F, -3.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 11.536F, 2.4F, -1.8326F, 0.0F, 0.0F));

		PartDefinition cube_r8 = spine.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(62, 44).addBox(-1.0F, -0.6287F, -1.5094F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.23F)), PartPose.offsetAndRotation(0.0F, 3.418F, 2.85F, -1.3788F, 0.0F, 0.0F));

		PartDefinition cube_r9 = spine.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(62, 41).addBox(-1.0F, 0.4781F, -2.8277F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 3.218F, 4.0F, -1.3439F, 0.0F, 0.0F));

		PartDefinition cube_r10 = spine.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(52, 39).addBox(-1.0F, -2.06F, -3.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.24F)), PartPose.offsetAndRotation(0.0F, 6.584F, 1.65F, -1.4835F, 0.0F, 0.0F));

		PartDefinition heart = body.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 3.8F, -2.55F, -0.1572F, -0.0832F, 0.3065F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(118, 40).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.0752F, -0.8348F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(122, 38).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r3 = heart.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(112, 38).addBox(-2.1619F, -2.9413F, -1.05F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.8F)), PartPose.offsetAndRotation(-0.8252F, 0.4152F, -1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition rightArm = partdefinition.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(24, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.11F))
		.texOffs(88, 22).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition cube_r11 = rightArm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(30, 62).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.0F, 0.8F, 0.0F, 1.5708F, -3.1416F));

		PartDefinition cube_r12 = rightArm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(62, 30).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.0F, -1.2F, 0.0F, 1.5708F, -3.1416F));

		PartDefinition right_arm_r1 = rightArm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(14, 50).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 1.0F, 0.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r2 = rightArm.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(58, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.6F, 2.3F, 0.0F, 0.0F, -0.3752F));

		PartDefinition right_arm_r3 = rightArm.addOrReplaceChild("right_arm_r3", CubeListBuilder.create().texOffs(50, 60).addBox(-4.0F, -11.0F, -1.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 3.0F, 1.4F, 0.0F, 0.0F, 0.0262F));

		PartDefinition right_arm_r4 = rightArm.addOrReplaceChild("right_arm_r4", CubeListBuilder.create().texOffs(32, 43).addBox(-4.0F, -12.0F, -1.0F, 7.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, 1.2F, -0.8F, 0.0F, 0.0F, -0.48F));

		PartDefinition right_arm_r5 = rightArm.addOrReplaceChild("right_arm_r5", CubeListBuilder.create().texOffs(0, 48).addBox(-4.0F, -11.0F, -1.0F, 7.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 3.0F, 0.5F, 0.0F, 0.0F, -0.48F));

		PartDefinition leftArm = partdefinition.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(0, 32).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.11F))
		.texOffs(72, 22).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition cube_r13 = leftArm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 56).addBox(0.0F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 9.0F, -1.2F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition cube_r14 = leftArm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(62, 5).addBox(0.1F, -5.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9F, 9.0F, 0.8F, 0.0F, -1.5708F, -3.1416F));

		PartDefinition left_arm_r1 = leftArm.addOrReplaceChild("left_arm_r1", CubeListBuilder.create().texOffs(16, 32).addBox(0.2F, 0.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(4.8F, -2.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition left_arm_r2 = leftArm.addOrReplaceChild("left_arm_r2", CubeListBuilder.create().texOffs(40, 15).addBox(-1.8F, -4.0F, -3.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition rightLeg = partdefinition.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(16, 39).addBox(-2.1F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.6F))
		.texOffs(88, 35).addBox(-1.9F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition cube_r15 = rightLeg.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 64).addBox(0.0F, -2.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r16 = rightLeg.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(60, 14).addBox(0.0F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r17 = rightLeg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 57).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition leftLeg = partdefinition.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(36, 32).addBox(-1.9F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.61F))
		.texOffs(72, 35).addBox(-2.1F, 0.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition cube_r18 = leftLeg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 64).addBox(0.0F, -2.0F, -1.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r19 = leftLeg.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(52, 6).addBox(0.0F, -0.25F, -1.0F, 4.0F, 7.0F, 1.0F, new CubeDeformation(0.61F)), PartPose.offsetAndRotation(-2.0F, -0.5F, 3.25F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r20 = leftLeg.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(40, 60).addBox(0.0F, 1.75F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.61F)), PartPose.offsetAndRotation(-2.0F, 0.5F, -1.75F, 0.0436F, 0.0F, 0.0F));

		PartDefinition pelvis = partdefinition.addOrReplaceChild("pelvis", CubeListBuilder.create().texOffs(104, 32).addBox(-4.0F, -2.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition leftBoot = partdefinition.addOrReplaceChild("leftBoot", CubeListBuilder.create().texOffs(46, 43).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.11F))
		.texOffs(112, 48).addBox(-2.0F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition cube_r21 = leftBoot.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(56, 52).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r22 = leftBoot.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(30, 54).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r23 = leftBoot.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(46, 52).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		PartDefinition rightBoot = partdefinition.addOrReplaceChild("rightBoot", CubeListBuilder.create().texOffs(40, 22).addBox(-1.9F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.12F))
		.texOffs(96, 48).addBox(-1.8F, 7.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(1.01F)), PartPose.offset(-2.1F, 12.0F, 0.0F));

		PartDefinition cube_r24 = rightBoot.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(56, 22).addBox(0.0F, -2.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.0F, 3.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r25 = rightBoot.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(14, 56).addBox(-0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 13.0F, -6.0F, 0.1745F, -0.2618F, 0.0F));

		PartDefinition cube_r26 = rightBoot.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(52, 31).addBox(0.1F, -3.0F, -1.0F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 13.0F, -6.0F, 0.1745F, 0.2618F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateHeart(float age){
		float val = Mth.sin(age/6)/6;
		this.heart.xScale = 1 + val;
		this.heart.zScale = 1 + val;
		this.heart.yScale = 1 - val;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateHeart(ageInTicks);
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
		pelvis.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightBoot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}