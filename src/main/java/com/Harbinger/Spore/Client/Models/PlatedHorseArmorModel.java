package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
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

public class PlatedHorseArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "platedhorsearmormodel"), "main");
	public final ModelPart Body;
	public final ModelPart Neck;
	private final ModelPart Head;
	public final ModelPart BackLeftLeg;
	public final ModelPart BackRightLeg;
	public final ModelPart FrontLeftLeg;
	public final ModelPart FrontRightLeg;

	public PlatedHorseArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Body = root.getChild("Body");
		this.Neck = root.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(5.0F, -6.0F, -13.0F, 3.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(36, 32).addBox(5.0F, -7.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(36, 32).addBox(5.0F, -5.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(36, 48).addBox(-8.0F, -6.0F, -13.0F, 3.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-7.0F, -7.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-7.0F, -5.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 9.0F));

		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(92, 17).addBox(-3.0F, -11.0F, 2.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(90, 17).addBox(0.0F, -11.0F, 2.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(64, 19).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(44, 15).addBox(-2.0F, -6.0F, -6.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(86, 0).addBox(-1.0F, -7.0F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(86, 0).addBox(1.0F, -7.0F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(42, -5).addBox(0.0F, -8.0F, -6.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(46, 3).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 3.0F));

		PartDefinition UMouth_r1 = Head.addOrReplaceChild("UMouth_r1", CubeListBuilder.create().texOffs(0, -9).addBox(0.0F, -9.0038F, -7.9128F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -10.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 9.0F));

		PartDefinition Leg1A_r1 = BackLeftLeg.addOrReplaceChild("Leg1A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg1A_r2 = BackLeftLeg.addOrReplaceChild("Leg1A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -7.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, 0.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 9.0F));

		PartDefinition Leg2A_r1 = BackRightLeg.addOrReplaceChild("Leg2A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, 0.0087F));

		PartDefinition Leg2A_r2 = BackRightLeg.addOrReplaceChild("Leg2A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -9.0F));

		PartDefinition Leg3A_r1 = FrontLeftLeg.addOrReplaceChild("Leg3A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg3A_r2 = FrontLeftLeg.addOrReplaceChild("Leg3A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 50).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -9.0F));

		PartDefinition Leg4A_r1 = FrontRightLeg.addOrReplaceChild("Leg4A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -5.9F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg4A_r2 = FrontRightLeg.addOrReplaceChild("Leg4A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -5.9F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,   alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,   alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}