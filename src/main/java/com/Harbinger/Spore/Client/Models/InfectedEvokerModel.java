package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.4.3
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.InfectedEvoker;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

public class InfectedEvokerModel<T extends InfectedEvoker> extends EntityModel<T> implements ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infectedevoker"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart RightArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart LeftArm;
	private final ModelPart bodywear;

	public InfectedEvokerModel(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.RightArm = root.getChild("RightArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.LeftArm = root.getChild("LeftArm");
		this.bodywear = root.getChild("bodywear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 14).addBox(-3.5F, -2.0F, -4.5F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(20, 16).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(50, 0).addBox(-4.0F, -2.0F, 1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 8).addBox(-3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(22, 0).addBox(3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 14).addBox(0.0F, -3.0F, -6.0F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -10.0F, 0.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 21).addBox(0.0F, -3.0F, -3.0F, 0.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -3.0F, 0.0F, -0.2182F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(64, 31).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 41).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 35).addBox(-4.0F, 9.0F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(14, 32).addBox(-4.0F, -2.5F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(28, 0).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(52, 52).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(52, 24).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition item = RightForArm.addOrReplaceChild("item", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 49).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(39, 44).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(23, 44).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(44, 13).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(4.0F, 2.0F, 0.0F));

		PartDefinition base = LeftArm.addOrReplaceChild("base", CubeListBuilder.create().texOffs(56, 4).addBox(-1.5F, -4.0F, -0.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.4363F, -1.5708F, -3.1416F));

		PartDefinition cube_r3 = base.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(38, 55).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition middleF = base.addOrReplaceChild("middleF", CubeListBuilder.create().texOffs(26, 55).addBox(-1.5F, -5.75F, -1.25F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 2.0F));

		PartDefinition middleF2 = middleF.addOrReplaceChild("middleF2", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, 0.0F));

		PartDefinition cube_r4 = middleF2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 60).addBox(-1.0F, -5.75F, -1.25F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition middleF3 = middleF2.addOrReplaceChild("middleF3", CubeListBuilder.create(), PartPose.offset(0.0F, -6.0F, -2.0F));

		PartDefinition cube_r5 = middleF3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(55, 40).addBox(0.0F, -5.75F, -1.25F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition fingerT = base.addOrReplaceChild("fingerT", CubeListBuilder.create(), PartPose.offset(1.25F, -5.0F, 1.0F));

		PartDefinition jointT = fingerT.addOrReplaceChild("jointT", CubeListBuilder.create().texOffs(28, 64).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition fingerG = jointT.addOrReplaceChild("fingerG", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG = fingerG.addOrReplaceChild("jointG", CubeListBuilder.create().texOffs(64, 22).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw = jointG.addOrReplaceChild("claw", CubeListBuilder.create().texOffs(58, 30).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT2 = base.addOrReplaceChild("fingerT2", CubeListBuilder.create(), PartPose.offset(1.25F, -9.0F, 2.0F));

		PartDefinition jointT2 = fingerT2.addOrReplaceChild("jointT2", CubeListBuilder.create().texOffs(22, 64).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition fingerG2 = jointT2.addOrReplaceChild("fingerG2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG2 = fingerG2.addOrReplaceChild("jointG2", CubeListBuilder.create().texOffs(16, 64).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw2 = jointG2.addOrReplaceChild("claw2", CubeListBuilder.create().texOffs(10, 57).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT3 = base.addOrReplaceChild("fingerT3", CubeListBuilder.create(), PartPose.offset(-0.75F, -8.75F, 2.0F));

		PartDefinition jointT3 = fingerT3.addOrReplaceChild("jointT3", CubeListBuilder.create().texOffs(63, 42).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition fingerG3 = jointT3.addOrReplaceChild("fingerG3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG3 = fingerG3.addOrReplaceChild("jointG3", CubeListBuilder.create().texOffs(58, 61).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw3 = jointG3.addOrReplaceChild("claw3", CubeListBuilder.create().texOffs(0, 35).addBox(0.0F, -6.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition fingerT4 = base.addOrReplaceChild("fingerT4", CubeListBuilder.create(), PartPose.offset(-0.75F, -3.75F, 1.0F));

		PartDefinition jointT4 = fingerT4.addOrReplaceChild("jointT4", CubeListBuilder.create().texOffs(50, 61).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition fingerG4 = jointT4.addOrReplaceChild("fingerG4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition jointG4 = fingerG4.addOrReplaceChild("jointG4", CubeListBuilder.create().texOffs(60, 13).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition claw4 = jointG4.addOrReplaceChild("claw4", CubeListBuilder.create().texOffs(16, 50).addBox(0.0F, -7.0F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition bodywear = partdefinition.addOrReplaceChild("bodywear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -3.25F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.attackAnim > 0) {
			float f1 = 1.0F - Mth.abs(10 - 2 * entity.attackAnim) / 10.0F;
			this.RightArm.xRot = -140f;
			this.LeftArm.xRot = -140f;
			this.RightArm.yRot = Mth.sin(ageInTicks/6)/8 + Mth.sin(f1) * 2.0F;
			this.LeftArm.yRot = -Mth.sin(ageInTicks/6)/8 + Mth.sin(f1) * 2.0F;
		}
		
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		} else {
			this.RightArm.zRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.zRot = -Mth.sin(ageInTicks/8)/10;
		}

		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		if (LeftLeg.xRot < 0){
			this.LeftLeg.getChild("leftForLeg").xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.RightLeg.getChild("rightForLeg").xRot = -RightLeg.xRot;}



		this.LeftArm.visible = entity.hasArm();

		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);

		this.LeftArm.getChild("base").getChild("middleF").xRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("middleF").getChild("middleF2").xRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("middleF").getChild("middleF2").getChild("middleF3").xRot = Mth.sin(ageInTicks/8)/6;

		this.LeftArm.getChild("base").getChild("fingerT").yRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT2").yRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT3").yRot = -Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT4").yRot = -Mth.sin(ageInTicks/8)/6;

		this.LeftArm.getChild("base").getChild("fingerT").zRot = -Mth.sin(ageInTicks/8)/8;
		this.LeftArm.getChild("base").getChild("fingerT2").zRot = -Mth.sin(ageInTicks/8)/7;
		this.LeftArm.getChild("base").getChild("fingerT3").zRot = Mth.sin(ageInTicks/8)/9;
		this.LeftArm.getChild("base").getChild("fingerT4").zRot = Mth.sin(ageInTicks/8)/6;

		this.LeftArm.getChild("base").getChild("fingerT").getChild("jointT").getChild("fingerG").yRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT2").getChild("jointT2").getChild("fingerG2").yRot = Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT3").getChild("jointT3").getChild("fingerG3").yRot = -Mth.sin(ageInTicks/8)/6;
		this.LeftArm.getChild("base").getChild("fingerT4").getChild("jointT4").getChild("fingerG4").yRot = -Mth.sin(ageInTicks/8)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodywear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}


	private ModelPart getArm(HumanoidArm p_102923_) {
		return p_102923_ == HumanoidArm.LEFT ? this.LeftArm : this.RightArm;
	}
	@Override
	public void translateToHand(HumanoidArm arm, PoseStack stack) {
		this.getArm(arm).translateAndRotate(stack);
	}

}