package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.CDUBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class CDUModel<T extends CDUBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "cdumodel"), "main");
	private final ModelPart cdu;
	private final ModelPart ventWall;
	private final ModelPart ventfan;
	private final ModelPart antenna;
	private final ModelPart canister;
	private final ModelPart CanisterPump;
	private final ModelPart pipe;
	private final ModelPart lesser;
	private final ModelPart AC;

	public CDUModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.cdu = root.getChild("cdu");
		this.ventWall = this.cdu.getChild("ventWall");
		this.ventfan = this.ventWall.getChild("ventfan");
		this.antenna = this.ventWall.getChild("antenna");
		this.canister = this.cdu.getChild("canister");
		this.CanisterPump = this.canister.getChild("CanisterPump");
		this.pipe = this.canister.getChild("pipe");
		this.lesser = this.pipe.getChild("lesser");
		this.AC = this.cdu.getChild("AC");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cdu = partdefinition.addOrReplaceChild("cdu", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 6.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition bolt_r1 = cdu.addOrReplaceChild("bolt_r1", CubeListBuilder.create().texOffs(76, 31).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5F, 5.5F, -6.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition ventWall = cdu.addOrReplaceChild("ventWall", CubeListBuilder.create().texOffs(40, 34).addBox(-1.8056F, -6.5F, -6.5F, 2.0F, 13.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(46, 18).addBox(0.1944F, -6.5F, -6.5F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(0.1944F, 3.5F, -6.5F, 2.0F, 3.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(70, 39).addBox(0.1944F, -3.5F, -6.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(70, 49).addBox(0.1944F, -3.5F, 3.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.8056F, -0.5F, 1.5F));

		PartDefinition bolt_r2 = ventWall.addOrReplaceChild("bolt_r2", CubeListBuilder.create().texOffs(80, 47).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1944F, -7.0F, -5.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition bolt_r3 = ventWall.addOrReplaceChild("bolt_r3", CubeListBuilder.create().texOffs(80, 44).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1944F, -7.0F, 5.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition ventfan = ventWall.addOrReplaceChild("ventfan", CubeListBuilder.create().texOffs(80, 14).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 69).addBox(0.25F, -3.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4444F, 0.0F, 0.0F));

		PartDefinition antenna = ventWall.addOrReplaceChild("antenna", CubeListBuilder.create().texOffs(66, 78).addBox(5.5F, -17.0F, 6.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(2.5F, -16.5F, -1.5F, 7.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.8056F, 0.5F, -1.5F));

		PartDefinition canister = cdu.addOrReplaceChild("canister", CubeListBuilder.create().texOffs(60, 60).addBox(-8.0F, 5.0F, -8.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(64, 0).addBox(-7.0F, -3.0F, -7.0F, 5.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(70, 34).addBox(-6.5F, -4.0F, -6.5F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(34, 76).addBox(-2.0F, -3.0F, -5.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 76).addBox(-8.0F, -3.0F, -5.5F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CanisterPump = canister.addOrReplaceChild("CanisterPump", CubeListBuilder.create().texOffs(30, 60).addBox(-4.0F, -0.5F, -3.5F, 8.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -1.5F, -4.5F));

		PartDefinition pipe = canister.addOrReplaceChild("pipe", CubeListBuilder.create().texOffs(80, 39).addBox(-5.5F, -8.0F, -5.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 14).addBox(-3.5F, -8.0F, -5.5F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(54, 68).addBox(0.5F, -8.0F, -3.5F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 76).addBox(0.0F, -8.5F, 3.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(50, 78).addBox(-3.5F, -8.5F, -6.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 78).addBox(-0.5F, -8.5F, -6.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 53).addBox(-2.5F, -8.5F, -6.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ACPipeBolt_r1 = pipe.addOrReplaceChild("ACPipeBolt_r1", CubeListBuilder.create().texOffs(76, 18).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, -6.0F, 4.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition boltup_r1 = pipe.addOrReplaceChild("boltup_r1", CubeListBuilder.create().texOffs(76, 27).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(76, 23).addBox(-1.5F, 0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -5.5F, -4.5F, 0.0F, 0.7854F, 0.0F));

		PartDefinition lesser = pipe.addOrReplaceChild("lesser", CubeListBuilder.create().texOffs(70, 78).addBox(1.0F, -6.0F, -5.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(74, 68).addBox(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition AC = cdu.addOrReplaceChild("AC", CubeListBuilder.create().texOffs(0, 34).addBox(-8.0F, -5.0F, 0.0F, 12.0F, 11.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(30, 68).addBox(-8.0F, -7.0F, 2.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(74, 74).addBox(1.0F, 3.0F, -4.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(80, 50).addBox(3.0F, 3.0F, -4.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(14, 69).addBox(-8.1F, -3.0F, 0.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		cdu.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {

	}
}