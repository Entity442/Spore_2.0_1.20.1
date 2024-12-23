package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.EvolvedInfected.Scamper;
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

public class DrownedScamperModel<T extends Scamper> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "drownedscampermodel"), "main");
	private final ModelPart body;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart Fin;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftArm;
	private final ModelPart RightArm;
	private final ModelPart head;
	private final ModelPart mound1;
	private final ModelPart mound2;
	private final ModelPart mound3;

	public DrownedScamperModel(ModelPart root) {
		this.body = root.getChild("body");
		this.LeftLeg = root.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.Fin = root.getChild("Fin");
		this.RightLeg = root.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftArm = root.getChild("LeftArm");
		this.RightArm = root.getChild("RightArm");
		this.head = root.getChild("head");
		this.mound1 = root.getChild("mound1");
		this.mound2 = root.getChild("mound2");
		this.mound3 = root.getChild("mound3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 42).addBox(-4.0F, 8.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(31, 12).addBox(-1.0F, 4.0F, 0.0F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 2.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(57, 61).addBox(-4.0F, -16.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 13).addBox(2.0F, -17.0F, 1.0F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(31, 13).addBox(-2.0F, -23.0F, 6.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 22.0F, -2.0F, 0.2233F, -0.2129F, -0.0479F));

		PartDefinition spine = body.addOrReplaceChild("spine", CubeListBuilder.create().texOffs(42, 20).addBox(-2.0F, -4.5F, -4.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 8.0F, 2.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition back2 = spine.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(62, 0).addBox(-1.0F, -4.0F, -2.25F, 2.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(0, 23).addBox(-4.0F, -5.5F, -4.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 4.0F, 1.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition back3 = spine2.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(58, 16).addBox(0.0F, -4.0F, -1.75F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition back4 = spine2.addOrReplaceChild("back4", CubeListBuilder.create().texOffs(48, 12).addBox(-2.0F, -4.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(12, 53).addBox(-1.25F, 0.0F, -1.75F, 3.0F, 6.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 12.0F, 2.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(48, 49).addBox(-1.25F, 0.0F, -1.75F, 3.0F, 6.0F, 3.5F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Fin = partdefinition.addOrReplaceChild("Fin", CubeListBuilder.create(), PartPose.offset(0.0F, 11.7351F, 3.045F));

		PartDefinition Fin_r1 = Fin.addOrReplaceChild("Fin_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-0.01F, -3.6955F, -9.5307F, 0.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 8.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(26, 53).addBox(-1.75F, -2.0F, -1.75F, 3.0F, 6.0F, 3.5F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, 14.0F, 2.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(52, 39).addBox(-1.75F, 0.0F, -1.75F, 3.0F, 6.0F, 3.5F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(60, 24).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.0F, 4.0F, 0.0F));

		PartDefinition Plane_r1 = LeftArm.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(4, 88).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 1.25F, 4.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r4 = LeftForArm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 59).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(60, 24).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, 4.0F, 0.0F));

		PartDefinition Plane_r2 = RightArm.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(4, 88).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 1.25F, 4.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(42, 6).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 1).addBox(-4.0F, -1.92F, -4.0F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.04F))
		.texOffs(23, -1).addBox(-4.25F, -3.0F, -4.25F, 8.5F, 1.0F, 4.25F, new CubeDeformation(0.04F)), PartPose.offset(0.0F, 4.5F, -2.5F));

		PartDefinition cube_r5 = head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(57, 61).addBox(-6.0475F, -1.0863F, -1.3418F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.5F, 2.5F, 0.0436F, -0.3491F, -0.2618F));

		PartDefinition cube_r6 = head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(58, 61).addBox(-4.0F, -24.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.5F, 2.5F, -0.0873F, 1.0036F, 0.1309F));

		PartDefinition cube_r7 = head.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(31, 12).addBox(-1.0F, -26.0F, 2.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.5F, 2.5F, 0.0436F, 0.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -6.5F, -0.5F, 0.238F, -0.3148F, -0.0403F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(35, 68).addBox(-4.0406F, 0.0F, 0.0F, 7.0711F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r9 = flower2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(35, 68).addBox(0.0F, 0.0F, -3.0305F, 6.061F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5051F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r10 = flower2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(35, 68).addBox(-4.0406F, 0.0F, -6.061F, 7.0711F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = flower2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(35, 68).addBox(-6.061F, 0.0F, -3.0305F, 6.061F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5051F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -6.0F, 0.5F, 0.6655F, -0.2266F, 0.3196F));

		PartDefinition cube_r12 = flower.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(56, 61).addBox(-5.52F, 0.0F, 0.0F, 9.66F, 0.0F, 8.28F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = flower.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(56, 61).addBox(0.0F, 0.0F, -4.14F, 8.28F, 0.0F, 8.28F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r14 = flower.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(56, 61).addBox(-5.52F, 0.0F, -8.28F, 9.66F, 0.0F, 8.28F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r15 = flower.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(56, 61).addBox(-8.28F, 0.0F, -4.14F, 8.28F, 0.0F, 8.28F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition flower3 = head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5F, -6.5F, 0.5F, -0.9553F, -0.2449F, 0.2404F));

		PartDefinition cube_r16 = flower3.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(35, 68).addBox(-4.0406F, 0.0F, 0.0F, 7.0711F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flower3.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(35, 68).addBox(0.0F, 0.0F, -3.0305F, 6.061F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5051F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r18 = flower3.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(35, 68).addBox(-4.0406F, 0.0F, -6.061F, 7.0711F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r19 = flower3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(35, 68).addBox(-6.061F, 0.0F, -3.0305F, 6.061F, 0.0F, 6.061F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5051F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition mound1 = partdefinition.addOrReplaceChild("mound1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 6.0F, 2.0F, -0.3491F, 0.0F, 0.3491F));

		PartDefinition body2 = mound1.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, -6.0F, -15.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-1.5F, -7.0F, -14.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition cube_r20 = body2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(12, 80).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound2 = partdefinition.addOrReplaceChild("mound2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 9.0F, 2.0F, -0.4363F, 0.0F, -0.48F));

		PartDefinition body3 = mound2.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, -6.0F, -15.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-1.5F, -7.0F, -14.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition cube_r21 = body3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(12, 80).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound3 = partdefinition.addOrReplaceChild("mound3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.25F, 2.0F, 0.9599F, 0.48F, 0.0F));

		PartDefinition body4 = mound3.addOrReplaceChild("body4", CubeListBuilder.create().texOffs(0, 74).addBox(-2.0F, -6.0F, -15.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-1.5F, -7.0F, -14.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 13.0F));

		PartDefinition cube_r22 = body4.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(12, 80).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void animateMound(ModelPart part,float value){
		part.xScale = 1 + value;
		part.zScale = 1 + value;
		part.yScale = 1 - value;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isAggressive()) {
			if (entity.swinging){
				this.RightArm.xRot = -89.5F;
				this.LeftArm.xRot = -89.5F;
			}else{
				this.RightArm.xRot = -90F - (Mth.sin(ageInTicks / 4) / 7);
				this.LeftArm.xRot = -90F + (Mth.sin(ageInTicks / 4) / 7);
			}
		}else if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RightArm.zRot = 0;
			this.LeftArm.zRot = 0;
		}else {
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}


		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);

		this.LeftLeg.xRot = Mth.cos(limbSwing ) * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing ) * -limbSwingAmount;

		if (LeftLeg.xRot < 0){
			this.leftForLeg.xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.rightForLeg.xRot = -RightLeg.xRot;}

		animateMound(mound1,Mth.sin(ageInTicks/8)/9);
		animateMound(mound2,Mth.sin(ageInTicks/8)/8);
		animateMound(mound3,Mth.sin(ageInTicks/8)/7);
		if (entity.isInFluidType()){
			this.Fin.yRot = Mth.sin(ageInTicks/6)/6;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Fin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mound1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mound2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		mound3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}