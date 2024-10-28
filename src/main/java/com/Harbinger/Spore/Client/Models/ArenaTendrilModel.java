package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.ArenaEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.util.Mth;

public class ArenaTendrilModel<T extends ArenaEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "arena_tendril"), "main");
	private final ModelPart Tendril;
	private final ModelPart TendrilSeg1;
	private final ModelPart TendrilSeg2;
	private final ModelPart S2Body;
	private final ModelPart Jaw2;
	private final ModelPart S2BEye1;
	private final ModelPart pupil2;
	private final ModelPart S2BEye2;
	private final ModelPart pupil3;
	private final ModelPart S2BEye3;
	private final ModelPart pupil4;
	private final ModelPart T2Tumors;
	private final ModelPart TendrilSeg3;
	private final ModelPart S3Body;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Eye;
	private final ModelPart pupil;
	private final ModelPart Tumors;
	private final ModelPart TumorBase;

	public ArenaTendrilModel(ModelPart root) {
		this.Tendril = root.getChild("Tendril");
		this.TendrilSeg1 = this.Tendril.getChild("TendrilSeg1");
		this.TendrilSeg2 = this.TendrilSeg1.getChild("TendrilSeg2");
		this.S2Body = this.TendrilSeg2.getChild("S2Body");
		this.Jaw2 = this.S2Body.getChild("Jaw2");
		this.S2BEye1 = this.S2Body.getChild("S2BEye1");
		this.pupil2 = this.S2BEye1.getChild("pupil2");
		this.S2BEye2 = this.S2Body.getChild("S2BEye2");
		this.pupil3 = this.S2BEye2.getChild("pupil3");
		this.S2BEye3 = this.S2Body.getChild("S2BEye3");
		this.pupil4 = this.S2BEye3.getChild("pupil4");
		this.T2Tumors = this.TendrilSeg2.getChild("T2Tumors");
		this.TendrilSeg3 = this.TendrilSeg2.getChild("TendrilSeg3");
		this.S3Body = this.TendrilSeg3.getChild("S3Body");
		this.Head = this.S3Body.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.Eye = this.Head.getChild("Eye");
		this.pupil = this.Eye.getChild("pupil");
		this.Tumors = this.S3Body.getChild("Tumors");
		this.TumorBase = this.Tendril.getChild("TumorBase");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tendril = partdefinition.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TendrilSeg1 = Tendril.addOrReplaceChild("TendrilSeg1", CubeListBuilder.create().texOffs(64, 58).addBox(-2.5F, -16.0F, -2.5F, 5.0F, 16.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TendrilSeg2 = TendrilSeg1.addOrReplaceChild("TendrilSeg2", CubeListBuilder.create().texOffs(32, 70).addBox(-2.0F, -20.0F, -2.0F, 4.0F, 20.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition S2Body = TendrilSeg2.addOrReplaceChild("S2Body", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.19F, -4.6555F, -4.1262F, -1.8212F, 1.2114F, 2.9066F));

		PartDefinition Leg_r1 = S2Body.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(24, 94).addBox(-1.1032F, -1.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 3.0F, 0.8091F, 0.0688F, 2.3514F));

		PartDefinition Arm_r1 = S2Body.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(24, 94).addBox(-0.5219F, -0.4371F, -1.7124F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2366F, -0.5182F, 2.8999F, 0.037F, 1.1318F, 0.3131F));

		PartDefinition Arm_r2 = S2Body.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(26, 94).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -1.9185F, 9.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r1 = S2Body.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(72, 0).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5912F, -0.28F, 3.724F, 0.3018F, 0.3762F, 0.9521F));

		PartDefinition TorsoTop_r1 = S2Body.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(0, 72).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0839F, 0.3706F, -0.4731F));

		PartDefinition Head_r1 = S2Body.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(64, 32).addBox(-5.7273F, -3.9945F, -3.9972F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.6913F, 3.8735F, 8.9017F, 0.0177F, 0.4775F, -1.9376F));

		PartDefinition Jaw2 = S2Body.addOrReplaceChild("Jaw2", CubeListBuilder.create(), PartPose.offset(-9.6913F, 3.8735F, 8.9017F));

		PartDefinition Jaw_r1 = Jaw2.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(84, 58).addBox(1.4654F, -4.935F, -4.4731F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1692F, 0.2135F, -1.5004F));

		PartDefinition S2BEye1 = S2Body.addOrReplaceChild("S2BEye1", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-8.8654F, -0.0115F, 8.4655F, -1.8006F, -0.2651F, -0.8419F));

		PartDefinition pupil2 = S2BEye1.addOrReplaceChild("pupil2", CubeListBuilder.create().texOffs(0, 96).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)), PartPose.offset(-0.0171F, 0.0058F, -4.372F));

		PartDefinition S2BEye2 = S2Body.addOrReplaceChild("S2BEye2", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-2.0F)), PartPose.offsetAndRotation(-6.2588F, -2.5802F, 4.8005F, 0.3054F, -1.1285F, -1.9616F));

		PartDefinition pupil3 = S2BEye2.addOrReplaceChild("pupil3", CubeListBuilder.create().texOffs(94, 32).addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(-1.5F)), PartPose.offset(-0.0171F, 0.0058F, -1.872F));

		PartDefinition S2BEye3 = S2Body.addOrReplaceChild("S2BEye3", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.5F)), PartPose.offsetAndRotation(-9.7443F, -0.5509F, 5.0106F, -0.8373F, -0.2994F, -1.1975F));

		PartDefinition pupil4 = S2BEye3.addOrReplaceChild("pupil4", CubeListBuilder.create().texOffs(0, 96).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.25F)), PartPose.offset(-0.0171F, 0.0058F, -2.872F));

		PartDefinition T2Tumors = TendrilSeg2.addOrReplaceChild("T2Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, -21.0F, 0.0F));

		PartDefinition Tumor_r1 = T2Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(11, 7).addBox(-3.0F, -2.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.2133F, -0.5419F, 0.364F));

		PartDefinition Tumor_r2 = T2Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(11, 7).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.4363F, -0.7418F));

		PartDefinition TendrilSeg3 = TendrilSeg2.addOrReplaceChild("TendrilSeg3", CubeListBuilder.create().texOffs(48, 70).addBox(-2.0F, -24.0F, -1.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -20.0F, -0.5F, 1.3526F, 0.0F, 0.0F));

		PartDefinition S3Body = TendrilSeg3.addOrReplaceChild("S3Body", CubeListBuilder.create().texOffs(60, 91).addBox(-3.5F, -20.0F, -4.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r3 = S3Body.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(16, 100).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -23.0F, -1.0F, 0.3361F, -0.2071F, 0.532F));

		PartDefinition Leg_r2 = S3Body.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(16, 100).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -17.0F, -2.0F, 0.809F, 0.4567F, 0.3813F));

		PartDefinition TorsoTop_r2 = S3Body.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(72, 22).addBox(-3.5F, -5.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -20.0F, -2.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Head = S3Body.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 56).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -26.0F, -1.0F, -1.3526F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(64, 48).addBox(-4.0F, -1.0F, -8.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.8995F, 0.2068F, -0.1617F));

		PartDefinition Eye = Head.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(40, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-0.8329F, -0.0762F, -0.4545F, 0.67F, 0.3266F, 0.2978F));

		PartDefinition pupil = Eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(0, 96).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)), PartPose.offset(-0.0171F, 0.0058F, -3.372F));

		PartDefinition Tumors = S3Body.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, -22.0F, 2.0F));

		PartDefinition Tumor4_r1 = Tumors.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(13, 9).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.576F, -2.7394F, -1.2357F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor3_r1 = Tumors.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(13, 9).addBox(-2.828F, -0.5697F, -1.8499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor2_r1 = Tumors.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(13, 9).addBox(-2.641F, -3.7504F, -1.5356F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0909F, -0.0967F, -0.2541F));

		PartDefinition Tumor1_r1 = Tumors.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(13, 9).addBox(-2.1541F, -4.1761F, -2.2588F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.4203F, 0.4928F, 0.2831F));

		PartDefinition TumorBase = Tendril.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SmallTumor4_r1 = TumorBase.addOrReplaceChild("SmallTumor4_r1", CubeListBuilder.create().texOffs(10, 8).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.753F, -7.4215F, 2.7383F, -0.1417F, 0.484F, 0.0763F));

		PartDefinition SmallTumor3_r1 = TumorBase.addOrReplaceChild("SmallTumor3_r1", CubeListBuilder.create().texOffs(10, 8).addBox(-2.25F, -5.25F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2601F, -10.6429F, 0.6574F, 0.4273F, -0.0631F, 0.0946F));

		PartDefinition SmallTumor2_r1 = TumorBase.addOrReplaceChild("SmallTumor2_r1", CubeListBuilder.create().texOffs(10, 8).addBox(-1.0F, -5.5F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 0.0F, 0.0998F, -0.0112F, -0.4707F));

		PartDefinition SmallTumor1_r1 = TumorBase.addOrReplaceChild("SmallTumor1_r1", CubeListBuilder.create().texOffs(10, 8).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 0.0F, -0.3463F, -0.0447F, -0.1231F));

		PartDefinition Tumor5_r1 = TumorBase.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(6, 4).addBox(-2.0F, -5.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5403F, 0.9305F, -2.5105F, -0.091F, -0.8041F, -0.7118F));

		PartDefinition Tumor4_r2 = TumorBase.addOrReplaceChild("Tumor4_r2", CubeListBuilder.create().texOffs(6, 4).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5403F, 0.9305F, -2.5105F, -0.091F, 0.8041F, 0.7118F));

		PartDefinition Tumor3_r2 = TumorBase.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -3.25F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3767F, -1.0F, 3.8812F, -0.4363F, 0.6109F, 0.0F));

		PartDefinition Tumor2_r2 = TumorBase.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -6.25F, 2.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, -0.2282F, -0.3594F, -0.2391F));

		PartDefinition Tumor1_r2 = TumorBase.addOrReplaceChild("Tumor1_r2", CubeListBuilder.create().texOffs(6, 4).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -3.0F, 0.3054F, 0.4363F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void animateEye(ModelPart part,float value){
		animateTentacleX(part,value);
		animateTentacleY(part,value);
		animateTentacleZ(part,value);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(TumorBase, Mth.sin(ageInTicks/6)/6);
		TendrilSeg1.yRot = netHeadYaw / (180F / (float) Math.PI);
		animateTentacleX(TendrilSeg2,Mth.sin(ageInTicks/8)/3);
		animateTentacleX(TendrilSeg3,-Mth.sin(ageInTicks/8)/3);
		animateTumor(T2Tumors,Mth.cos(ageInTicks/5)/4);
		Jaw2.yRot = Mth.cos(ageInTicks/7)/7;
		animateEye(S2BEye1,Mth.cos(ageInTicks/3)/5);
		animateEye(S2BEye2,Mth.sin(ageInTicks/5)/6);
		animateEye(S2BEye3,Mth.cos(ageInTicks/6)/7);
		animateTumor(Tumors,Mth.cos(ageInTicks/3)/8);
		Head.yRot = headPitch /  ( 90F / (float) Math.PI);
		animateEye(Eye,Mth.sin(ageInTicks/4)/3);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tendril.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}