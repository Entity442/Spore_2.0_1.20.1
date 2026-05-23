package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;


public class DragonNeckPieceTarModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "dragonneckpiecetarmiddlemodel"), "main");
	private final ModelPart yes;
	private final ModelPart Pipe2;
	private final ModelPart Pipe3;
	private final ModelPart FS2Body1;
	private final ModelPart tarSacks1;
	private final ModelPart tarSacks2;

	public DragonNeckPieceTarModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yes = root.getChild("yes");
		this.Pipe2 = this.yes.getChild("Pipe2");
		this.Pipe3 = this.yes.getChild("Pipe3");
		this.FS2Body1 = this.yes.getChild("FS2Body1");
		this.tarSacks1 = this.yes.getChild("tarSacks1");
		this.tarSacks2 = this.yes.getChild("tarSacks2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yes = partdefinition.addOrReplaceChild("yes", CubeListBuilder.create().texOffs(36, 0).addBox(-3.0F, -16.0F, 2.25F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.15F)), PartPose.offsetAndRotation(0.0F, 24.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition bone_r1 = yes.addOrReplaceChild("bone_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, 10.0F, 0.1223F, 0.1855F, 0.8791F));

		PartDefinition bone_r2 = yes.addOrReplaceChild("bone_r2", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.0F, 10.0F, 0.2233F, 0.201F, -0.1502F));

		PartDefinition bone_r3 = yes.addOrReplaceChild("bone_r3", CubeListBuilder.create().texOffs(0, 77).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -6.0F, 10.0F, 0.255F, -0.1586F, 1.1158F));

		PartDefinition bone_r4 = yes.addOrReplaceChild("bone_r4", CubeListBuilder.create().texOffs(50, 79).addBox(-8.0F, -4.0F, -2.0F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, 10.0F, 0.1665F, -0.3082F, -0.5059F));

		PartDefinition cube_r1 = yes.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 25).addBox(-8.0F, -16.0F, -5.0F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 6.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r2 = yes.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -16.0F, -5.0F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 6.0F, 0.0F, 0.3927F, 0.0F));

		PartDefinition Pipe2 = yes.addOrReplaceChild("Pipe2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3166F, -5.8746F, -4.4504F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Top_r1 = Pipe2.addOrReplaceChild("Top_r1", CubeListBuilder.create().texOffs(97, 1).addBox(-4.0F, -11.0F, -3.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.1F))
		.texOffs(96, 25).addBox(-4.0F, -11.0F, -3.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.5F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Pipe3 = yes.addOrReplaceChild("Pipe3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3166F, -14.8746F, -3.9504F, 0.0436F, 0.0F, 0.0F));

		PartDefinition Top_r2 = Pipe3.addOrReplaceChild("Top_r2", CubeListBuilder.create().texOffs(97, 1).addBox(-4.0F, -11.0F, -3.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.1F))
		.texOffs(96, 25).addBox(-4.0F, -11.0F, -3.0F, 7.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.5F, 2.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition FS2Body1 = yes.addOrReplaceChild("FS2Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3428F, -16.6606F, 6.8538F, -0.7612F, 0.0243F, -0.313F));

		PartDefinition Leg_r1 = FS2Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-1.1031F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.6028F, -0.5244F, 1.2983F));

		PartDefinition Arm_r1 = FS2Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -2.3175F, -0.332F, 2.4869F));

		PartDefinition TorsoBase_r1 = FS2Body1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r1 = FS2Body1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = FS2Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7146F, -0.3831F, -2.47F, 0.082F, -0.2592F, -0.2639F));

		PartDefinition Head_r1 = FS2Body1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 112).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, 0.2573F, -0.4072F, -0.3372F));

		PartDefinition tarSacks1 = yes.addOrReplaceChild("tarSacks1", CubeListBuilder.create(), PartPose.offset(9.0F, -13.0F, 3.0F));

		PartDefinition cube_r3 = tarSacks1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(103, 30).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8626F, -0.3734F, 0.3823F, -2.7106F, 0.432F, 0.3317F));

		PartDefinition cube_r4 = tarSacks1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(110, 34).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8626F, -0.3734F, 0.3823F, -1.1811F, -0.05F, 0.121F));

		PartDefinition cube_r5 = tarSacks1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(98, 33).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8626F, -2.3734F, -2.6177F, 0.0F, -0.1309F, 0.0F));

		PartDefinition tarSacks2 = yes.addOrReplaceChild("tarSacks2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -5.0F, 0.0F, 3.0375F, 0.3865F, 3.0135F));

		PartDefinition cube_r6 = tarSacks2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(103, 30).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8626F, -0.3734F, 0.3823F, -2.7106F, 0.432F, 0.3317F));

		PartDefinition cube_r7 = tarSacks2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(101, 29).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8626F, -0.3734F, 0.3823F, -1.1811F, -0.05F, 0.121F));

		PartDefinition cube_r8 = tarSacks2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(98, 33).addBox(4.2F, -1.2F, -1.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8626F, -2.3734F, -2.6177F, 0.0F, -0.1309F, 0.0F));

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