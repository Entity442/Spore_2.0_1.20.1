package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.world.entity.LivingEntity;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
public class ElytrumModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "elytrummodel"), "main");
	public final ModelPart body;
	private final ModelPart leftJoint;
	private final ModelPart left_wing;
	private final ModelPart left_for_wing;
	private final ModelPart rightJoint;
	private final ModelPart right_wing;
	private final ModelPart right_for_wing;

	public ElytrumModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.body = root.getChild("body");
		this.leftJoint = this.body.getChild("leftJoint");
		this.left_wing = this.leftJoint.getChild("left_wing");
		this.left_for_wing = this.left_wing.getChild("left_for_wing");
		this.rightJoint = this.body.getChild("rightJoint");
		this.right_wing = this.rightJoint.getChild("right_wing");
		this.right_for_wing = this.right_wing.getChild("right_for_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftJoint = body.addOrReplaceChild("leftJoint", CubeListBuilder.create(), PartPose.offset(-5.0F, -3.0F, 3.0F));

		PartDefinition left_wing = leftJoint.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(28, 0).addBox(-7.25F, -1.0F, -1.0F, 17.0F, 14.0F, 1.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(6.75F, 2.0F, -0.25F, -3.1416F, 0.0F, -2.7925F));

		PartDefinition left_for_wing = left_wing.addOrReplaceChild("left_for_wing", CubeListBuilder.create().texOffs(18, 44).addBox(-12.25F, -7.0F, 0.01F, 17.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 12.0F, -1.0F));

		PartDefinition rightJoint = body.addOrReplaceChild("rightJoint", CubeListBuilder.create(), PartPose.offset(5.0F, -3.0F, 3.0F));

		PartDefinition right_wing = rightJoint.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(28, 23).addBox(-9.75F, -1.0F, -0.95F, 17.0F, 14.0F, 1.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-6.75F, 2.0F, -0.25F, -3.1416F, 0.0F, 2.7925F));

		PartDefinition right_for_wing = right_wing.addOrReplaceChild("right_for_wing", CubeListBuilder.create().texOffs(1, 44).addBox(-4.25F, -7.0F, 0.06F, 17.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 12.0F, -1.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	public void animatedElytra(T entity,ModelPart rightWing,ModelPart leftWing){
		float f = 0.2617994F;
		float f1 = -0.2617994F;
		float f2 = 0.0F;
		float f3 = 0.0F;
		if (entity.isFallFlying()) {
			float f4 = 1.0F;
			Vec3 vec3 = entity.getDeltaMovement();
			if (vec3.y < 0.0D) {
				Vec3 vec31 = vec3.normalize();
				f4 = 1.0F - (float)Math.pow(-vec31.y, 1.5D);
			}

			f = f4 * 0.34906584F + (1.0F - f4) * f;
			f1 = f4 * (-(float)Math.PI / 2F) + (1.0F - f4) * f1;
		} else if (entity.isCrouching()) {
			f = 0.6981317F;
			f1 = (-(float)Math.PI / 4F);
			f2 = 3.0F;
			f3 = 0.08726646F;
		}

		leftWing.y = f2;
		if (entity instanceof AbstractClientPlayer abstractclientplayer) {
			abstractclientplayer.elytraRotX += (f - abstractclientplayer.elytraRotX) * 0.1F;
			abstractclientplayer.elytraRotY += (f3 - abstractclientplayer.elytraRotY) * 0.1F;
			abstractclientplayer.elytraRotZ += (f1 - abstractclientplayer.elytraRotZ) * 0.1F;
			leftWing.xRot = abstractclientplayer.elytraRotX;
			leftWing.yRot = abstractclientplayer.elytraRotY;
			leftWing.zRot = abstractclientplayer.elytraRotZ;
		} else {
			leftWing.xRot = f;
			leftWing.zRot = f1;
			leftWing.yRot = f3;
		}

		rightWing.yRot = -leftWing.yRot;
		rightWing.y = leftWing.y;
		rightWing.xRot = leftWing.xRot;
		rightWing.zRot = -leftWing.zRot;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animatedElytra(entity,leftJoint,rightJoint);
		this.right_for_wing.zRot = rightJoint.zRot/2;
		this.left_for_wing.zRot = leftJoint.zRot/2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}