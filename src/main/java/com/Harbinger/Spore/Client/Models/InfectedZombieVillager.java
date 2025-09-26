package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BasicInfected.InfectedVillager;
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

public class InfectedZombieVillager<T extends InfectedVillager> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infectedzombievillager"), "main");
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart jaw;
	private final ModelPart body;
	private final ModelPart body_r1;
	private final ModelPart body_r2;
	private final ModelPart tendril;
	private final ModelPart tendril2;
	private final ModelPart bodywear;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart cube_r1;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;

	public InfectedZombieVillager(ModelPart root) {
		this.head = root.getChild("head");
		this.nose = this.head.getChild("nose");
		this.jaw = this.head.getChild("jaw");
		this.body = root.getChild("body");
		this.body_r1 = this.body.getChild("body_r1");
		this.body_r2 = this.body.getChild("body_r2");
		this.tendril = this.body.getChild("tendril");
		this.tendril2 = this.body.getChild("tendril2");
		this.bodywear = root.getChild("bodywear");
		this.RightArm = root.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.cube_r1 = this.LeftForArm.getChild("cube_r1");
		this.RightLeg = root.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(20, 16).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 24).addBox(-4.0F, -2.0F, 1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(28, 13).addBox(-3.5F, -2.0F, -4.5F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(-3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(52, 0).addBox(3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(22, 32).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 41).addBox(-4.0F, -1.0F, -5.95F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 32).addBox(-4.0F, 9.0F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body_r1 = body.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-4.0F, -2.5F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(28, 0).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition tendril = body.addOrReplaceChild("tendril", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 9.0F));

		PartDefinition cube_r2 = tendril.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(2, 64).addBox(1.0F, -8.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, -16.0F, -5.4F, 0.0698F, 0.0F, 0.0F));

		PartDefinition tendril2 = body.addOrReplaceChild("tendril2", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 9.0F));

		PartDefinition cube_r3 = tendril2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 64).addBox(1.0F, -8.0F, -1.0F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9F, -16.0F, -5.4F, 0.0698F, 0.0F, 0.0F));

		PartDefinition bodywear = partdefinition.addOrReplaceChild("bodywear", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, 0.0F, -3.25F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 52).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(28, 52).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(50, 29).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r1 = LeftForArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 49).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 49).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 12.0F, 0.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(44, 41).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(44, 13).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 0.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(28, 41).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
			this.RightArm.xRot = -90F - (Mth.sin(ageInTicks/4)/7);
			this.LeftArm.xRot = -90F + (Mth.sin(ageInTicks/4)/7);

			if (entity.swinging){
				float j = 0;
				j = j + 0.5F;
				this.RightArm.xRot = -90F + j;
				this.LeftArm.xRot = -90F + j;
			}
		}
		else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
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
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot: 0;
		this.rightForLeg.xRot =RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bodywear.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}