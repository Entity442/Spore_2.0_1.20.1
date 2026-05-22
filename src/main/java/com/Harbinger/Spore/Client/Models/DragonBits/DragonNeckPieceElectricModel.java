package com.Harbinger.Spore.Client.Models.DragonBits;

import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class DragonNeckPieceElectricModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragonneckpieceelectricmodel"), "main");
	private final ModelPart yes;
	private final ModelPart spikes1;
	private final ModelPart spikes2;
	private final ModelPart spikes3;
	private final ModelPart spikes4;
	private final ModelPart Brain1;
	private final ModelPart spike;

	public DragonNeckPieceElectricModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yes = root.getChild("yes");
		this.spikes1 = this.yes.getChild("spikes1");
		this.spikes2 = this.yes.getChild("spikes2");
		this.spikes3 = this.yes.getChild("spikes3");
		this.spikes4 = this.yes.getChild("spikes4");
		this.Brain1 = this.yes.getChild("Brain1");
		this.spike = this.yes.getChild("spike");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yes = partdefinition.addOrReplaceChild("yes", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -16.0F, 2.25F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(0.0F, 24.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone_r1 = yes.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -6.0F, 10.0F, 0.2549F, -0.1586F, 1.1158F));

		PartDefinition bone_r2 = yes.addOrReplaceChild("bone_r2", CubeListBuilder.create().texOffs(50, 79).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, 10.0F, 0.1665F, -0.3082F, -0.5059F));

		PartDefinition cube_r1 = yes.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 50).addBox(-5.0F, -6.0F, -1.0F, 11.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.25F, 0.25F, 0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r2 = yes.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -16.0F, -5.0F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 6.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r3 = yes.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -16.0F, -5.0F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 6.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition spikes1 = yes.addOrReplaceChild("spikes1", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -1.0F, 5.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r4 = spikes1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.25F, -0.5F, -12.75F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r5 = spikes1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(98, 0).addBox(-2.0F, -3.0F, -11.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition spikes2 = yes.addOrReplaceChild("spikes2", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -1.0F, 5.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r6 = spikes2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -2.0F, -11.0F, 2.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, -0.5F, -12.75F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r7 = spikes2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -3.0F, -11.0F, 3.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition spikes3 = yes.addOrReplaceChild("spikes3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -8.0F, 3.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition cube_r8 = spikes3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -0.5F, -8.75F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r9 = spikes3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -3.0F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition spikes4 = yes.addOrReplaceChild("spikes4", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -8.0F, 3.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition cube_r10 = spikes4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(98, 0).addBox(-1.0F, -2.0F, -9.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -0.5F, -8.75F, 0.0F, -0.6981F, 0.0F));

		PartDefinition cube_r11 = spikes4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(98, 0).addBox(-2.0F, -3.0F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition Brain1 = yes.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(0, 64).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 68).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(28, 68).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.8026F, -7.8588F, 1.436F, 1.8762F, 0.0F, 0.2618F));

		PartDefinition spike = yes.addOrReplaceChild("spike", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -4.0F, 8.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition cube_r12 = spike.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 85).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition cube_r13 = spike.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(24, 81).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 1.5F, 12.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r14 = spike.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(74, 79).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 7.0F, 0.1309F, 0.3054F, 0.0F));

		PartDefinition cube_r15 = spike.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(66, 24).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, 0.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		yes.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}