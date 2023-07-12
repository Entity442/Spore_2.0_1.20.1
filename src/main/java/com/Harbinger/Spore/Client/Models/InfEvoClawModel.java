package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.InfEvoClaw;
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

public class InfEvoClawModel<T extends InfEvoClaw> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infevoclawmodel"), "main");
	private final ModelPart base;

	public InfEvoClawModel(ModelPart root) {
		this.base = root.getChild("base");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition base = partdefinition.addOrReplaceChild("base", CubeListBuilder.create().texOffs(0, 15).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition cube_r1 = base.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(10, 9).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition middleF = base.addOrReplaceChild("middleF", CubeListBuilder.create().texOffs(10, 0).addBox(-1.5F, -5.75F, -1.25F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 1.0F));

		PartDefinition middleF2 = middleF.addOrReplaceChild("middleF2", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition cube_r2 = middleF2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 18).addBox(-1.0F, -5.75F, -1.25F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition middleF3 = middleF2.addOrReplaceChild("middleF3", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -2.0F));

		PartDefinition cube_r3 = middleF3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 20).addBox(0.0F, -5.75F, -1.25F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition fingerT = base.addOrReplaceChild("fingerT", CubeListBuilder.create(), PartPose.offset(1.25F, -7.0F, 0.0F));

		PartDefinition jointT = fingerT.addOrReplaceChild("jointT", CubeListBuilder.create().texOffs(32, 9).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition fingerG = jointT.addOrReplaceChild("fingerG", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG = fingerG.addOrReplaceChild("jointG", CubeListBuilder.create().texOffs(0, 31).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw = jointG.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(8, 25).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT2 = base.addOrReplaceChild("fingerT2", CubeListBuilder.create(), PartPose.offset(1.25F, -11.0F, 1.0F));

		PartDefinition jointT2 = fingerT2.addOrReplaceChild("jointT2", CubeListBuilder.create().texOffs(30, 0).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition fingerG2 = jointT2.addOrReplaceChild("fingerG2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG2 = fingerG2.addOrReplaceChild("jointG2", CubeListBuilder.create().texOffs(28, 25).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw2 = jointG2.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(22, 22).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT3 = base.addOrReplaceChild("fingerT3", CubeListBuilder.create(), PartPose.offset(-0.75F, -10.75F, 1.0F));

		PartDefinition jointT3 = fingerT3.addOrReplaceChild("jointT3", CubeListBuilder.create().texOffs(28, 16).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition fingerG3 = jointT3.addOrReplaceChild("fingerG3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG3 = fingerG3.addOrReplaceChild("jointG3", CubeListBuilder.create().texOffs(14, 28).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw3 = jointG3.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(22, 15).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT4 = base.addOrReplaceChild("fingerT4", CubeListBuilder.create(), PartPose.offset(-0.75F, -5.75F, 0.0F));

		PartDefinition jointT4 = fingerT4.addOrReplaceChild("jointT4", CubeListBuilder.create().texOffs(22, 9).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition fingerG4 = jointT4.addOrReplaceChild("fingerG4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG4 = fingerG4.addOrReplaceChild("jointG4", CubeListBuilder.create().texOffs(22, 0).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw4 = jointG4.addOrReplaceChild("claw4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.0F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.base.getChild("middleF").xRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("middleF").getChild("middleF2").xRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("middleF").getChild("middleF2").getChild("middleF3").xRot = Mth.sin(ageInTicks/8)/6;

		this.base.getChild("fingerT").yRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT2").yRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT3").yRot = -Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT4").yRot = -Mth.sin(ageInTicks/8)/6;

		this.base.getChild("fingerT").zRot = -Mth.sin(ageInTicks/8)/8;
		this.base.getChild("fingerT2").zRot = -Mth.sin(ageInTicks/8)/7;
		this.base.getChild("fingerT3").zRot = Mth.sin(ageInTicks/8)/9;
		this.base.getChild("fingerT4").zRot = -Mth.sin(ageInTicks/8)/6;

		this.base.getChild("fingerT").getChild("jointT").getChild("fingerG").yRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT2").getChild("jointT2").getChild("fingerG2").yRot = Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT3").getChild("jointT3").getChild("fingerG3").yRot = -Mth.sin(ageInTicks/8)/6;
		this.base.getChild("fingerT4").getChild("jointT4").getChild("fingerG4").yRot = -Mth.sin(ageInTicks/8)/6;

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		base.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}