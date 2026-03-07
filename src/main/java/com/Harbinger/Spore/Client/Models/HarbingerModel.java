package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.BasicInfected.InfectedPlayer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class HarbingerModel<T extends InfectedPlayer> extends HumanoidModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "harbingermodel"), "main");
	private final ModelPart eye;
	private final ModelPart pupil;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart hat;

	public HarbingerModel(ModelPart root) {
		super(root);
		this.eye = root.getChild("eye");
		this.pupil = this.eye.getChild("pupil");
		this.head = root.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.body = root.getChild("body");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
		this.hat = root.getChild("hat");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition eye = partdefinition.addOrReplaceChild("eye", CubeListBuilder.create().texOffs(96, 48).addBox(-3.1924F, -6.0115F, -3.9335F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.7727F, -2.1243F, 0.1062F, -0.0087F, 0.0F, 0.0F));

		PartDefinition pupil = eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(104, 39).addBox(-2.5F, -1.5086F, -1.3695F, 5.0F, 5.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.7905F, -2.9971F, -3.436F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(19, 19).addBox(-4.0F, -2.0F, -1.0F, 8.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(64, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 0.0F, 0.25F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 0).addBox(-4.0F, -0.25F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(0.0F, -1.75F, -1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(0, 24).addBox(-3.5F, 6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.05F))
		.texOffs(24, 52).addBox(-3.5F, 6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(45, 13).addBox(-1.0F, -2.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 3).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.15F))
		.texOffs(0, 38).addBox(-1.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(34, 43).addBox(-3.0F, -2.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 42).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.15F))
		.texOffs(18, 37).addBox(-3.0F, 4.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(32, 5).addBox(-1.9F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(34, 33).addBox(-1.9F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(41, 22).addBox(-2.1F, 6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(22, 26).addBox(-2.1F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition hat = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(64, 1).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.3F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}
	private void AnimateEye(Entity proto, ModelPart part){
		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = proto.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				part.y = part.getInitialPose().y + 0.0F;
			} else {
				part.y =part.getInitialPose().y + 1.0F;
			}

			Vec3 vec32 = proto.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			part.x =part.getInitialPose().x + Mth.sqrt((float)Math.abs(d1))  * (float)Math.signum(d1);
		}
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		AnimateEye(entity, pupil);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		eye.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		hat.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}