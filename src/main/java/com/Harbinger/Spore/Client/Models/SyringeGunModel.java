package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
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

public class SyringeGunModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "syringe_gun"), "main");
	public final ModelPart syringeGun;
	private final ModelPart power;
	private final ModelPart devil_trigger;
	private final ModelPart magazine;

	public SyringeGunModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.syringeGun = root.getChild("syringeGun");
		this.power = this.syringeGun.getChild("power");
		this.devil_trigger = this.syringeGun.getChild("devil_trigger");
		this.magazine = this.syringeGun.getChild("magazine");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition syringeGun = partdefinition.addOrReplaceChild("syringeGun", CubeListBuilder.create().texOffs(90, 90).addBox(-2.0F, -11.0F, 5.0F, 4.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(72, 57).addBox(-2.0F, -13.0F, 14.0F, 4.0F, 5.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 74).addBox(-2.5F, -12.5F, 14.5F, 5.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(34, 74).addBox(-2.0F, -13.0F, -17.0F, 4.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(78, 14).addBox(-2.1F, -8.5F, -19.25F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(62, 90).addBox(-2.6F, -8.0F, -18.75F, 5.0F, 3.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(32, 89).addBox(-1.1F, -6.0F, -16.25F, 2.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(72, 38).addBox(-1.1F, -8.5F, -29.0F, 2.0F, 3.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(68, 75).addBox(-1.0F, -6.0F, 1.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(94, 28).addBox(-1.0F, -5.0F, 15.0F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(90, 102).addBox(-1.0F, -8.0F, 19.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(28, 90).addBox(-1.0F, -8.0F, 14.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(78, 35).addBox(-1.0F, -8.0F, 8.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -14.0F, -13.0F, 2.0F, 1.0F, 37.0F, new CubeDeformation(0.0F))
		.texOffs(78, 28).addBox(-1.0F, -12.0F, 8.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = syringeGun.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(76, 102).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.75F, 21.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = syringeGun.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 102).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -3.0F, 21.25F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r3 = syringeGun.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 38).addBox(-1.5F, -1.5F, -29.0F, 3.0F, 3.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, -11.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r4 = syringeGun.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(98, 75).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.5F, 20.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition power = syringeGun.addOrReplaceChild("power", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.5F, -2.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 6.0F));

		PartDefinition devil_trigger = syringeGun.addOrReplaceChild("devil_trigger", CubeListBuilder.create().texOffs(28, 95).addBox(0.0F, -1.0F, -2.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 18.5F));

		PartDefinition magazine = syringeGun.addOrReplaceChild("magazine", CubeListBuilder.create().texOffs(78, 0).addBox(-5.0F, -5.0F, -2.0F, 10.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 90).addBox(-5.5F, -5.5F, -1.5F, 11.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -0.25F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		syringeGun.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}