package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.AnimationTrackers.AssassinShootAnimationTracker;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class AcidicAssasinArmModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "acidicassasinmodel"), "main");
	public final ModelPart Caspian;
	private final ModelPart barrel;
	private final ModelPart barrelPiece1;
	private final ModelPart body;
	private final ModelPart grip;
	private final ModelPart trigger;
	private final ModelPart head;
	private final ModelPart jaw;

	public AcidicAssasinArmModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Caspian = root.getChild("Caspian");
		this.barrel = this.Caspian.getChild("barrel");
		this.barrelPiece1 = this.barrel.getChild("barrelPiece1");
		this.body = this.Caspian.getChild("body");
		this.grip = this.Caspian.getChild("grip");
		this.trigger = this.grip.getChild("trigger");
		this.head = this.grip.getChild("head");
		this.jaw = this.head.getChild("jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Caspian = partdefinition.addOrReplaceChild("Caspian", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 25.0F, -4.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition barrel = Caspian.addOrReplaceChild("barrel", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = barrel.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(56, 133).addBox(-4.0F, -1.0F, 1.0F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, -3.0F, -15.5F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r2 = barrel.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(106, 16).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -15.0F, 1.2217F, 0.0F, 0.0F));

		PartDefinition cube_r3 = barrel.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(36, 83).addBox(-5.0F, -1.0F, -5.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.5F, -11.25F, -1.4399F, 0.0F, 0.0F));

		PartDefinition cube_r4 = barrel.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 133).addBox(-6.0F, -1.0F, -6.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0F, -10.25F, -1.4399F, 0.0F, 0.0F));

		PartDefinition cube_r5 = barrel.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(106, 48).addBox(-0.5F, -1.5F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, -18.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r6 = barrel.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(106, 98).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, -22.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r7 = barrel.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(116, 48).addBox(-2.0F, -2.0F, -8.0F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -12.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition barrelPiece1 = barrel.addOrReplaceChild("barrelPiece1", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -16.0F));

		PartDefinition cube_r8 = barrelPiece1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(106, 32).addBox(-2.0F, -2.0F, -8.0F, 3.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-2.0F, -2.0F, 9.0F, 3.0F, 3.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -34.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r9 = barrelPiece1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 120).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, -20.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition body = Caspian.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(36, 97).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 13.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(60, 81).addBox(-4.5F, -4.5F, -4.0F, 7.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -6.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(122, 79).addBox(-4.5F, -4.5F, -4.0F, 6.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -6.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(98, 124).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, -4.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, -10.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(98, 124).addBox(-1.0F, -1.0F, -16.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 8.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 53).addBox(-3.0F, -1.0F, -7.5F, 4.0F, 4.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, -2.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition grip = Caspian.addOrReplaceChild("grip", CubeListBuilder.create().texOffs(60, 53).addBox(-2.0F, -8.0F, -18.0F, 4.0F, 4.0F, 24.0F, new CubeDeformation(0.0F))
				.texOffs(0, 103).addBox(-2.0F, -8.5F, 7.0F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(71, 103).addBox(-2.5F, -8.0F, 8.0F, 5.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(36, 102).addBox(-2.0F, -3.45F, 24.85F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
				.texOffs(0, 83).addBox(-1.5F, -2.45F, 25.35F, 3.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(106, 0).addBox(-2.5F, -2.95F, 25.1F, 5.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(28, 120).addBox(-1.0F, -0.75F, 12.9F, 2.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r15 = grip.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(74, 133).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 11.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r16 = grip.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(116, 63).addBox(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -5.8F, 19.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r17 = grip.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(70, 118).addBox(-2.0F, -2.0F, -1.0F, 4.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -6.3F, 19.5F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r18 = grip.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(56, 120).addBox(-2.0F, -6.0F, -1.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 6.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition trigger = grip.addOrReplaceChild("trigger", CubeListBuilder.create().texOffs(44, 97).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.75F, 18.0F, 1.0472F, 0.0F, 0.0F));

		PartDefinition cube_r19 = trigger.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(52, 97).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.25F, -0.75F, -0.9599F, 0.0F, 0.0F));

		PartDefinition head = grip.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, 29.75F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r20 = head.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(126, 128).addBox(-3.0F, -7.0F, -1.0F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r21 = head.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(106, 114).addBox(-4.0F, -6.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.8443F, -2.5712F, 1.1781F, 0.0F, 0.0F));

		PartDefinition cube_r22 = jaw.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(36, 90).addBox(-2.0F, -0.718F, 0.2393F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0943F, 0.5712F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r23 = jaw.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(98, 128).addBox(-3.0F, -1.718F, 0.2393F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.4057F, -0.4288F, 0.48F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Caspian.getAllParts().forEach(ModelPart::resetPose);
		animateTentacleX(jaw, Mth.sin(ageInTicks/6)/8);
		if (entity instanceof Player player){
			float anim = AssassinShootAnimationTracker.getProgress(player, 0);
			this.barrelPiece1.z = barrelPiece1.z + (anim * 7);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Caspian.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}