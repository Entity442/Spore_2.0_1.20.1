package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Mound;
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

public class MoundModel<T extends Mound> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "moundmodel"), "main");
	private final ModelPart body;
	private final ModelPart tendrils;
	private final ModelPart small_tendrils;
	private final ModelPart bb_main;

	public MoundModel(ModelPart root) {
		this.body = root.getChild("body");
		this.tendrils = root.getChild("tendrils");
		this.small_tendrils = root.getChild("small_tendrils");
		this.bb_main = root.getChild("bb_main");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 8).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 14).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tendrils = partdefinition.addOrReplaceChild("tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition tendril = tendrils.addOrReplaceChild("tendril", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = tendril.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(50, 0).addBox(-6.0F, -13.0F, 0.0F, 7.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition tendril2 = tendrils.addOrReplaceChild("tendril2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition cube_r3 = tendril2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(50, 6).addBox(0.0F, -13.0F, -7.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tendril3 = tendrils.addOrReplaceChild("tendril3", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = tendril3.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 26).addBox(-1.0F, -13.0F, 0.0F, 7.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition tendril4 = tendrils.addOrReplaceChild("tendril4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition cube_r5 = tendril4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(50, 32).addBox(0.0F, -13.0F, -0.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition small_tendrils = partdefinition.addOrReplaceChild("small_tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition tendril5 = small_tendrils.addOrReplaceChild("tendril5", CubeListBuilder.create(), PartPose.offset(-3.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = tendril5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(36, 0).addBox(-6.0F, -13.0F, 0.0F, 7.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition tendril6 = small_tendrils.addOrReplaceChild("tendril6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -1.5F));

		PartDefinition cube_r7 = tendril6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(36, 6).addBox(0.0F, -13.0F, -7.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tendril7 = small_tendrils.addOrReplaceChild("tendril7", CubeListBuilder.create(), PartPose.offset(3.0F, 0.0F, 0.0F));

		PartDefinition cube_r8 = tendril7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(36, 26).addBox(-1.0F, -13.0F, 0.0F, 7.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition tendril8 = small_tendrils.addOrReplaceChild("tendril8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.0F));

		PartDefinition cube_r9 = tendril8.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(36, 32).addBox(0.0F, -13.0F, -0.5F, 0.0F, 13.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, -6.0F, 12.0F, 0.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.body.xScale =1+ Mth.cos(ageInTicks/9)/6;
		this.body.zScale =1+ Mth.cos(ageInTicks/9)/6;
		this.body.yScale =1 -Mth.cos(ageInTicks/9)/6;
		this.small_tendrils.visible = entity.getAge() >= 3;
		this.tendrils.visible = entity.getAge() >= 4;

		if (this.small_tendrils.visible){
			this.small_tendrils.getChild("tendril5").zRot = -Mth.cos(ageInTicks/9)/6;
			this.small_tendrils.getChild("tendril7").zRot = Mth.cos(ageInTicks/9)/6;
			this.small_tendrils.getChild("tendril6").xRot = Mth.cos(ageInTicks/9)/6;
			this.small_tendrils.getChild("tendril8").xRot = -Mth.cos(ageInTicks/9)/6;
		}
		if (this.tendrils.visible){
			this.tendrils.getChild("tendril").zRot = -Mth.cos(ageInTicks/9)/6;
			this.tendrils.getChild("tendril3").zRot = Mth.cos(ageInTicks/9)/6;
			this.tendrils.getChild("tendril2").xRot = Mth.cos(ageInTicks/9)/6;
			this.tendrils.getChild("tendril4").xRot = -Mth.cos(ageInTicks/9)/6;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		small_tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}