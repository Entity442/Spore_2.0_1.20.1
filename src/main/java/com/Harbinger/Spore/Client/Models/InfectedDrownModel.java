package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.6.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BasicInfected.InfectedDrowned;
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

public class InfectedDrownModel<T extends InfectedDrowned> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infecteddrownmodel"), "main");
	private final ModelPart Body;

	public InfectedDrownModel(ModelPart root) {
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(22, 21).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition spine = Body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(0, 25).addBox(-2.0F, -4.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back = spine.addOrReplaceChild("back", CubeListBuilder.create().texOffs(42, 23).addBox(0.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back2 = spine.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(38, 41).addBox(-2.0F, -4.0F, -2.25F, 3.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition spine2 = Body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -5.5F, -4.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back3 = spine2.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(28, 37).addBox(0.0F, -4.0F, -1.75F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back4 = spine2.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(32, 6).addBox(-2.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition LeftLeg = Body.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 35).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 10.0F, 0.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(18, 27).addBox(-1.25F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition tendril6 = LeftLeg.addOrReplaceChild("tendril6", CubeListBuilder.create().texOffs(47, 45).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 2.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition RightLeg = Body.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(14, 37).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 10.0F, 0.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(32, 27).addBox(-1.75F, 0.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition tendril5 = RightLeg.addOrReplaceChild("tendril5", CubeListBuilder.create().texOffs(48, 8).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 2.0F, 1.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LeftArm = Body.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(46, 3).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 2.0F, -2.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r1 = LeftForArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightArm = Body.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(46, 31).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 2.0F, -2.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(25, 45).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head = Body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.01F))
		.texOffs(24, 0).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 57).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(26, 14).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition ear = head.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(37, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -6.0F, 2.0F));

		PartDefinition ear2 = head.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(12, 42).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 2.0F));

		PartDefinition tendril = Body.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(28, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tendril2 = Body.addOrReplaceChild("tendril2", CubeListBuilder.create().texOffs(20, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition tendril3 = Body.addOrReplaceChild("tendril3", CubeListBuilder.create().texOffs(0, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tendril4 = Body.addOrReplaceChild("tendril4", CubeListBuilder.create().texOffs(12, 48).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()){
				this.Body.getChild("RightArm").xRot = -89.5F - (Mth.sin(ageInTicks/4)/7);
				this.Body.getChild("LeftArm").xRot = -89.5F + (Mth.sin(ageInTicks/4)/7);

		}else {
			this.Body.getChild("RightArm").zRot = Mth.sin(ageInTicks/8)/10;
			this.Body.getChild("LeftArm").zRot = -Mth.sin(ageInTicks/8)/10;
			this.Body.getChild("RightArm").xRot = 0;
			this.Body.getChild("LeftArm").xRot = 0;
		}
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) && entity.onGround()){
			this.Body.getChild("RightArm").xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.Body.getChild("LeftArm").xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.Body.getChild("RightArm").zRot = 0;
			this.Body.getChild("LeftArm").zRot = 0;
		}
		else {
			this.Body.getChild("RightArm").zRot = Mth.sin(ageInTicks/8)/10;
			this.Body.getChild("LeftArm").zRot = -Mth.sin(ageInTicks/8)/10;
		}

		if (entity.isInWater() && !(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (entity.isSwimming() && entity.getXRot() < 5){
				this.Body.xRot = -headPitch /  ( 90F / (float) Math.PI);
			}
		}else {
			this.Body.xRot = 0F;
		}
		this.Body.getChild("LeftLeg").xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.Body.getChild("RightLeg").xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		if (Body.getChild("LeftLeg").xRot < 0){
			this.Body.getChild("LeftLeg").getChild("leftForLeg").xRot = -Body.getChild("LeftLeg").xRot;}
		if (Body.getChild("RightLeg").xRot < 0){
			this.Body.getChild("RightLeg").getChild("rightForLeg").xRot = -Body.getChild("RightLeg").xRot;}

		this.Body.getChild("head").yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Body.getChild("head").xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Body.getChild("head").getChild("jaw").xRot = Mth.sin(ageInTicks/8)/10;

		this.Body.getChild("tendril").yRot = -Mth.sin(ageInTicks/8)/5;
		this.Body.getChild("tendril2").yRot = Mth.sin(ageInTicks/5)/7;
		this.Body.getChild("tendril3").yRot = -Mth.sin(ageInTicks/6)/8;
		this.Body.getChild("tendril4").yRot = Mth.sin(ageInTicks/9)/6;

		this.Body.getChild("RightLeg").getChild("tendril5").yRot = Mth.sin(ageInTicks/9)/6;
		this.Body.getChild("LeftLeg").getChild("tendril6").yRot = -Mth.sin(ageInTicks/9)/6;

		this.Body.getChild("head").getChild("ear").xRot = Mth.sin(ageInTicks/6)/8;
		this.Body.getChild("head").getChild("ear2").xRot = -Mth.sin(ageInTicks/6)/8;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}