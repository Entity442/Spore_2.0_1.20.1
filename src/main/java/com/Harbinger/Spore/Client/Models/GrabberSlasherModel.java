package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Slasher;
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

import java.util.ArrayList;
import java.util.List;

public class GrabberSlasherModel<T extends Slasher> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "grabberslashermodel"), "main");
	private final ModelPart yoink;
	private final ModelPart body;
	private final ModelPart cube_r7;
	private final ModelPart body_r2;
	private final ModelPart bodywear;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;
	private final ModelPart HeadJoint;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart jaw;
	private final ModelPart flower2;
	private final ModelPart flower;
	private final ModelPart Marm;
	private final ModelPart MarmJoint;
	private final ModelPart MArm2;
	private final ModelPart MarmJoint2;
	private final ModelPart midclaw;
	private final ModelPart leftclaw;
	private final ModelPart rightclaw;
	private final ModelPart thumbclaw;

	public GrabberSlasherModel(ModelPart root) {
		this.yoink = root.getChild("yoink");
		this.body = this.yoink.getChild("body");
		this.cube_r7 = this.body.getChild("cube_r7");
		this.body_r2 = this.body.getChild("body_r2");
		this.bodywear = this.yoink.getChild("bodywear");
		this.LeftArm = this.yoink.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.RightLeg = this.yoink.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = this.yoink.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
		this.HeadJoint = this.yoink.getChild("HeadJoint");
		this.head = this.HeadJoint.getChild("head");
		this.nose = this.head.getChild("nose");
		this.jaw = this.head.getChild("jaw");
		this.flower2 = this.HeadJoint.getChild("flower2");
		this.flower = this.HeadJoint.getChild("flower");
		this.Marm = this.yoink.getChild("Marm");
		this.MarmJoint = this.Marm.getChild("MarmJoint");
		this.MArm2 = this.MarmJoint.getChild("MArm2");
		this.MarmJoint2 = this.MArm2.getChild("MarmJoint2");
		this.midclaw = this.MarmJoint2.getChild("midclaw");
		this.leftclaw = this.MarmJoint2.getChild("leftclaw");
		this.rightclaw = this.MarmJoint2.getChild("rightclaw");
		this.thumbclaw = this.MarmJoint2.getChild("thumbclaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yoink = partdefinition.addOrReplaceChild("yoink", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = yoink.addOrReplaceChild("body", CubeListBuilder.create().texOffs(36, 21).addBox(-4.0F, 9.0F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(59, 41).addBox(-0.5F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 75).addBox(-3.0F, -9.0F, -5.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(36, 12).addBox(-4.0F, -2.5F, -3.0F, 8.0F, 3.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(18, 66).addBox(-16.0F, -32.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 87).addBox(-5.0F, -24.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 87).addBox(-2.0F, -22.0F, 7.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.6109F, 0.0F, -0.1309F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-7, 87).addBox(-3.0F, -29.0F, -6.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.1631F, 0.0227F, 0.1289F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-7, 87).addBox(-1.0F, -33.0F, -12.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-7, 87).addBox(-4.0F, -32.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(28, 47).addBox(-1.5F, 6.5F, -3.25F, 5.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-4.5F, -1.0F, -4.0F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition body_r2 = body.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(0, 34).addBox(-6.0F, -11.0F, -3.0F, 6.0F, 7.0F, 6.0F, new CubeDeformation(0.1F))
		.texOffs(28, 34).addBox(-4.0F, -7.0F, -3.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition bodywear = yoink.addOrReplaceChild("bodywear", CubeListBuilder.create().texOffs(75, 0).addBox(-4.0F, 0.0F, -3.25F, 8.0F, 18.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -24.0F, -0.25F, 0.0436F, 0.0F, 0.0F));

		PartDefinition LeftArm = yoink.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(62, 50).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -22.0F, 0.0F));

		PartDefinition cube_r9 = LeftArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-7, 87).addBox(-0.8709F, 0.2037F, -5.4591F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1766F, -0.4011F, -0.1669F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r10 = LeftForArm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(61, 18).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition RightLeg = yoink.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 56).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.9F, -12.0F, 0.0F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(56, 30).addBox(-1.75F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = yoink.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 55).addBox(-1.25F, 0.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, -12.0F, 0.0F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(0, 55).addBox(-1.25F, 1.0F, -2.5F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition HeadJoint = yoink.addOrReplaceChild("HeadJoint", CubeListBuilder.create(), PartPose.offset(3.0F, -27.0F, 0.0F));

		PartDefinition head = HeadJoint.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 0).addBox(-3.5F, -2.0F, -4.5F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(55, 0).addBox(-4.0F, -2.0F, 1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 1).addBox(-3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 0).addBox(3.5F, -2.0F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -0.5F, 0.1733F, -0.0298F, 0.3438F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 47).addBox(-4.0F, -1.0F, -6.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition flower2 = HeadJoint.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -6.5F, -4.25F, 0.7039F, -0.1949F, -0.1078F));

		PartDefinition cube_r11 = flower2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-8, 87).addBox(-5.0F, 0.0F, -8.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-8, 87).addBox(-5.0F, 0.0F, 0.0F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = flower2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-8, 87).addBox(-8.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r14 = flower2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-8, 87).addBox(0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition flower = HeadJoint.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -9.0F, -2.0F, 0.1608F, 0.1468F, -0.7298F));

		PartDefinition cube_r15 = flower.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-6, 87).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-6, 87).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r17 = flower.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-6, 87).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Marm = yoink.addOrReplaceChild("Marm", CubeListBuilder.create(), PartPose.offset(-6.0F, -28.0F, -2.0F));

		PartDefinition MarmJoint = Marm.addOrReplaceChild("MarmJoint", CubeListBuilder.create().texOffs(58, 8).addBox(-2.0F, -3.0F, -1.75F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(52, 47).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition MArm2 = MarmJoint.addOrReplaceChild("MArm2", CubeListBuilder.create(), PartPose.offset(0.0F, -14.0F, 1.0F));

		PartDefinition MarmJoint2 = MArm2.addOrReplaceChild("MarmJoint2", CubeListBuilder.create().texOffs(19, 19).addBox(-1.0F, -1.0F, -13.0F, 2.0F, 2.0F, 13.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition midclaw = MarmJoint2.addOrReplaceChild("midclaw", CubeListBuilder.create().texOffs(0, 0).addBox(0.1F, -9.0F, -16.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -13.0F));

		PartDefinition leftclaw = MarmJoint2.addOrReplaceChild("leftclaw", CubeListBuilder.create().texOffs(0, 0).addBox(0.1F, -9.0F, -16.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rightclaw = MarmJoint2.addOrReplaceChild("rightclaw", CubeListBuilder.create().texOffs(0, 0).addBox(0.1F, -9.0F, -16.0F, 0.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -13.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition thumbclaw = MarmJoint2.addOrReplaceChild("thumbclaw", CubeListBuilder.create().texOffs(14, 58).addBox(0.1F, 1.0F, -16.0F, 0.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -13.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.attackAnim > 0) {
			float f1 = -1.0F + Mth.abs(10 - 2 * entity.attackAnim) / 6.5F;
			this.Marm.xRot = Mth.sin(f1) * 2.0F;
			this.MArm2.xRot = -Mth.sin(f1) * 3.0F;
		}
		else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.LeftArm.zRot = 0;
			this.Marm.xRot = Mth.sin(ageInTicks/8)/10;
			this.MArm2.xRot = -Mth.sin(ageInTicks/8)/10;
			this.MarmJoint2.xRot = -Mth.sin(ageInTicks/6)/8;

		}
		else {
			this.Marm.xRot = Mth.sin(ageInTicks/6)/8;
			this.MArm2.xRot = -Mth.sin(ageInTicks/8)/10;
			this.MarmJoint2.xRot = -this.Marm.xRot;
			this.LeftArm.zRot = -this.Marm.xRot;
		}
		this.midclaw.xRot = Mth.cos(ageInTicks/6)/6;
		this.leftclaw.xRot = this.midclaw.xRot;
		this.rightclaw.xRot = this.midclaw.xRot;
		this.thumbclaw.xRot = -this.midclaw.xRot;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.rightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.jaw.xRot = Mth.sin(ageInTicks/8)/10;
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		yoink.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}