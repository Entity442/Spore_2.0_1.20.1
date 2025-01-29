package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.HyperClawAnimations;
import com.Harbinger.Spore.Sentities.Utility.HyperClaw;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class DetasheHyperClaw<T extends HyperClaw> extends HierarchicalModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "detashehyperclaw"), "main");
	private final ModelPart RightArm;
	private final ModelPart RMClaw1;
	private final ModelPart RMJoint1;
	private final ModelPart RMPlane1;
	private final ModelPart RAClaw3;
	private final ModelPart RAJoint3;
	private final ModelPart RAPlane3;
	private final ModelPart RAClaw4;
	private final ModelPart RAJoint4;
	private final ModelPart RAPlane4;
	private final ModelPart RightArm2;
	private final ModelPart RAClaw2;
	private final ModelPart RAJoint2;
	private final ModelPart RAPlane2;
	private final ModelPart RAClaw5;
	private final ModelPart RAJoint5;
	private final ModelPart RAPlane5;
	private final ModelPart RightArm3;
	private final ModelPart RightArmSplit1;
	private final ModelPart RASplit1Claw;
	private final ModelPart RASplit1Joint;
	private final ModelPart RASplit1Plane;
	private final ModelPart RASplit1Claw2;
	private final ModelPart RASplit1Joint2;
	private final ModelPart RASplit1Plane2;
	private final ModelPart RightArmSplit2;
	private final ModelPart RightArmSplit2Seg1;
	private final ModelPart RASplit2Claw1;
	private final ModelPart RASplit2Joint1;
	private final ModelPart RASplit2Plane1;
	private final ModelPart RASplit2Claw2;
	private final ModelPart RASplit2Joint2;
	private final ModelPart RASplit2Plane2;

	public DetasheHyperClaw(ModelPart root) {
		this.RightArm = root.getChild("RightArm");
		this.RMClaw1 = this.RightArm.getChild("RMClaw1");
		this.RMJoint1 = this.RMClaw1.getChild("RMJoint1");
		this.RMPlane1 = this.RMJoint1.getChild("RMPlane1");
		this.RAClaw3 = this.RMClaw1.getChild("RAClaw3");
		this.RAJoint3 = this.RAClaw3.getChild("RAJoint3");
		this.RAPlane3 = this.RAJoint3.getChild("RAPlane3");
		this.RAClaw4 = this.RMClaw1.getChild("RAClaw4");
		this.RAJoint4 = this.RAClaw4.getChild("RAJoint4");
		this.RAPlane4 = this.RAJoint4.getChild("RAPlane4");
		this.RightArm2 = this.RightArm.getChild("RightArm2");
		this.RAClaw2 = this.RightArm2.getChild("RAClaw2");
		this.RAJoint2 = this.RAClaw2.getChild("RAJoint2");
		this.RAPlane2 = this.RAJoint2.getChild("RAPlane2");
		this.RAClaw5 = this.RightArm2.getChild("RAClaw5");
		this.RAJoint5 = this.RAClaw5.getChild("RAJoint5");
		this.RAPlane5 = this.RAJoint5.getChild("RAPlane5");
		this.RightArm3 = this.RightArm2.getChild("RightArm3");
		this.RightArmSplit1 = this.RightArm3.getChild("RightArmSplit1");
		this.RASplit1Claw = this.RightArmSplit1.getChild("RASplit1Claw");
		this.RASplit1Joint = this.RASplit1Claw.getChild("RASplit1Joint");
		this.RASplit1Plane = this.RASplit1Joint.getChild("RASplit1Plane");
		this.RASplit1Claw2 = this.RightArmSplit1.getChild("RASplit1Claw2");
		this.RASplit1Joint2 = this.RASplit1Claw2.getChild("RASplit1Joint2");
		this.RASplit1Plane2 = this.RASplit1Joint2.getChild("RASplit1Plane2");
		this.RightArmSplit2 = this.RightArm3.getChild("RightArmSplit2");
		this.RightArmSplit2Seg1 = this.RightArmSplit2.getChild("RightArmSplit2Seg1");
		this.RASplit2Claw1 = this.RightArmSplit2Seg1.getChild("RASplit2Claw1");
		this.RASplit2Joint1 = this.RASplit2Claw1.getChild("RASplit2Joint1");
		this.RASplit2Plane1 = this.RASplit2Joint1.getChild("RASplit2Plane1");
		this.RASplit2Claw2 = this.RightArmSplit2Seg1.getChild("RASplit2Claw2");
		this.RASplit2Joint2 = this.RASplit2Claw2.getChild("RASplit2Joint2");
		this.RASplit2Plane2 = this.RASplit2Joint2.getChild("RASplit2Plane2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(64, 24).addBox(-0.25F, -2.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.03F, 4.8496F, 15.0217F, -1.2216F, 0.886F, -1.2959F));

		PartDefinition RMClaw1 = RightArm.addOrReplaceChild("RMClaw1", CubeListBuilder.create().texOffs(38, 94).addBox(-2.0F, -10.0F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.415F, 1.9809F, 1.4353F, 0.8902F, -1.3508F, 0.4417F));

		PartDefinition RMJoint1 = RMClaw1.addOrReplaceChild("RMJoint1", CubeListBuilder.create().texOffs(0, 104).addBox(-2.0F, -11.0F, -1.0F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RMPlane1 = RMJoint1.addOrReplaceChild("RMPlane1", CubeListBuilder.create().texOffs(48, -6).addBox(0.0F, -9.5F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -8.8488F, 0.1753F, 0.3063F, 0.0231F, -0.0059F));

		PartDefinition RAClaw3 = RMClaw1.addOrReplaceChild("RAClaw3", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0525F, -2.5986F, 0.0887F, 0.1469F, -0.6239F, -1.3614F));

		PartDefinition RAJoint3 = RAClaw3.addOrReplaceChild("RAJoint3", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane3 = RAJoint3.addOrReplaceChild("RAPlane3", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RAClaw4 = RMClaw1.addOrReplaceChild("RAClaw4", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4136F, -3.3521F, 0.6696F, 0.3571F, 0.3301F, 1.1785F));

		PartDefinition RAJoint4 = RAClaw4.addOrReplaceChild("RAJoint4", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane4 = RAJoint4.addOrReplaceChild("RAPlane4", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightArm2 = RightArm.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(92, 57).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 5.0F, 0.0F, 0.1615F, 0.0665F, -0.6491F));

		PartDefinition RAClaw2 = RightArm2.addOrReplaceChild("RAClaw2", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4262F, 2.9298F, -1.9353F, 1.7824F, 0.868F, 1.1388F));

		PartDefinition RAJoint2 = RAClaw2.addOrReplaceChild("RAJoint2", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane2 = RAJoint2.addOrReplaceChild("RAPlane2", CubeListBuilder.create().texOffs(49, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RAClaw5 = RightArm2.addOrReplaceChild("RAClaw5", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, -10.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.3805F, 0.9865F, 1.1291F, -1.2186F, 0.3823F, -1.8505F));

		PartDefinition RAJoint5 = RAClaw5.addOrReplaceChild("RAJoint5", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RAPlane5 = RAJoint5.addOrReplaceChild("RAPlane5", CubeListBuilder.create().texOffs(38, -5).addBox(0.0F, -8.5F, -2.0F, 0.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.2642F, 0.0365F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightArm3 = RightArm2.addOrReplaceChild("RightArm3", CubeListBuilder.create().texOffs(94, 45).addBox(-1.5F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 7.0F, -0.25F, -0.3491F, 0.0F, -0.3054F));

		PartDefinition RightArmSplit1 = RightArm3.addOrReplaceChild("RightArmSplit1", CubeListBuilder.create().texOffs(56, 117).addBox(-1.0F, 0.0F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3581F, 5.7537F, -0.3996F, -0.7294F, -0.9863F, 1.2794F));

		PartDefinition RASplit1Claw = RightArmSplit1.addOrReplaceChild("RASplit1Claw", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.3312F, 6.8287F, -0.5515F, 2.647F, 0.0323F, 0.7571F));

		PartDefinition RASplit1Joint = RASplit1Claw.addOrReplaceChild("RASplit1Joint", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit1Plane = RASplit1Joint.addOrReplaceChild("RASplit1Plane", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = RASplit1Plane.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -3.5F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit1Claw2 = RightArmSplit1.addOrReplaceChild("RASplit1Claw2", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0952F, 4.0477F, -0.092F, -0.0112F, 0.6892F, 2.5703F));

		PartDefinition RASplit1Joint2 = RASplit1Claw2.addOrReplaceChild("RASplit1Joint2", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit1Plane2 = RASplit1Joint2.addOrReplaceChild("RASplit1Plane2", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RightArmSplit2 = RightArm3.addOrReplaceChild("RightArmSplit2", CubeListBuilder.create().texOffs(114, 99).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4035F, 4.2047F, 0.8685F, 0.9614F, -0.5907F, 0.0965F));

		PartDefinition RightArmSplit2Seg1 = RightArmSplit2.addOrReplaceChild("RightArmSplit2Seg1", CubeListBuilder.create().texOffs(104, 117).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1471F, 6.3773F, 0.171F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw1 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw1", CubeListBuilder.create().texOffs(118, 31).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.177F, 1.5284F, 0.003F, -1.8914F, -1.0724F, 1.5044F));

		PartDefinition RASplit2Joint1 = RASplit2Claw1.addOrReplaceChild("RASplit2Joint1", CubeListBuilder.create().texOffs(114, 117).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane1 = RASplit2Joint1.addOrReplaceChild("RASplit2Plane1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r2 = RASplit2Plane1.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(60, -4).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit2Claw2 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw2", CubeListBuilder.create().texOffs(50, 129).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.2485F, 5.0629F, -0.1709F, -1.9428F, 1.0657F, 0.1813F));

		PartDefinition RASplit2Joint2 = RASplit2Claw2.addOrReplaceChild("RASplit2Joint2", CubeListBuilder.create().texOffs(44, 129).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane2 = RASplit2Joint2.addOrReplaceChild("RASplit2Plane2", CubeListBuilder.create().texOffs(38, 7).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return RightArm;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateTentacleY(RMClaw1, netHeadYaw / (180F / (float) Math.PI));
		this.animateTentacleX(RMJoint1,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleZ(RAClaw3,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleZ(RAClaw4,-Mth.cos(ageInTicks/6)/6);
		this.animateTentacleX(RAJoint3,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleX(RAJoint4,-Mth.cos(ageInTicks/6)/6);
		this.animateWalk(HyperClawAnimations.RUN,limbSwing,limbSwingAmount,2,3f);
	}
}