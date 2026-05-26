package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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

public class InfectedDrownModel<T extends InfectedDrowned> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infecteddrownmodel"), "main");
	private final ModelPart Body;
	private final ModelPart spine;
	private final ModelPart back;
	private final ModelPart back2;
	private final ModelPart spine2;
	private final ModelPart back3;
	private final ModelPart back4;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart tendril6;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart tendril5;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart ear;
	private final ModelPart ear2;
	private final ModelPart tendril;
	private final ModelPart tendril2;
	private final ModelPart tendril3;
	private final ModelPart tendril4;
	private int angle;

	public InfectedDrownModel(ModelPart root) {
		this.Body = root.getChild("Body");
		this.spine = this.Body.getChild("spine");
		this.back = this.spine.getChild("back");
		this.back2 = this.spine.getChild("back2");
		this.spine2 = this.Body.getChild("spine2");
		this.back3 = this.spine2.getChild("back3");
		this.back4 = this.spine2.getChild("back4");
		this.LeftLeg = this.Body.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.tendril6 = this.LeftLeg.getChild("tendril6");
		this.RightLeg = this.Body.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.tendril5 = this.RightLeg.getChild("tendril5");
		this.LeftArm = this.Body.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.RightArm = this.Body.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.head = this.Body.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.ear = this.head.getChild("ear");
		this.ear2 = this.head.getChild("ear2");
		this.tendril = this.Body.getChild("tendril");
		this.tendril2 = this.Body.getChild("tendril2");
		this.tendril3 = this.Body.getChild("tendril3");
		this.tendril4 = this.Body.getChild("tendril4");
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
		.texOffs(48, 66).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.15F))
		.texOffs(24, 0).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(33, 57).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(26, 14).addBox(-3.5F, 0.0F, -3.75F, 7.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition ear = head.addOrReplaceChild("ear", CubeListBuilder.create().texOffs(37, 44).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -6.0F, 2.0F));

		PartDefinition ear2 = head.addOrReplaceChild("ear2", CubeListBuilder.create().texOffs(12, 42).addBox(0.0F, -5.0F, -2.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -6.0F, 2.0F));

		PartDefinition tendril = Body.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(28, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 1.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition tendril2 = Body.addOrReplaceChild("tendril2", CubeListBuilder.create().texOffs(20, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition tendril3 = Body.addOrReplaceChild("tendril3", CubeListBuilder.create().texOffs(0, 50).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition tendril4 = Body.addOrReplaceChild("tendril4", CubeListBuilder.create().texOffs(12, 48).addBox(0.0F, 0.0F, -1.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 5.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 80, 80);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float walk = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		float bodyAngle = angle * 0.025f;
		float val = Mth.sin(ageInTicks/5)/6;
		float val1 = Mth.cos(ageInTicks/8)/7;
		float val2 = Mth.sin(ageInTicks/8)/7;
		float val3 = Mth.cos(ageInTicks/6)/6;
		float val4 = Mth.sin(ageInTicks/7)/7;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F) && entity.isInWater()){
			if (angle < 40){
				angle++;
			}
		}else {
			this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
			if (angle > 0){
				angle--;
			}
		}
		animateTentacleX(Body,bodyAngle);
		float aggressive = entity.isAggressive() ? -90 : 0;
		animateTentacleX(RightArm,-bodyAngle + val1+aggressive);
		animateTentacleX(LeftArm,-bodyAngle + val2+aggressive);
		this.head.xRot = (headPitch /  ( 90F / (float) Math.PI)) -bodyAngle;
		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
		this.ear.xRot = Mth.sin(ageInTicks/6)/8;
		this.ear2.xRot = -ear.xRot;
		this.LeftLeg.xRot = walk;
		this.RightLeg.xRot = -walk;
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.rightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		animateTentacleY(tendril,val);
		animateTentacleY(tendril2,val1);
		animateTentacleY(tendril3,val2);
		animateTentacleY(tendril4,val3);
		animateTentacleY(tendril5,val4);
		animateTentacleY(tendril6,val);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}