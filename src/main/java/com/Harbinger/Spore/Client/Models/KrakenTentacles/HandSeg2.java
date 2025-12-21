package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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
import net.minecraft.world.entity.Entity;

public class HandSeg2<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "handseg2"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Fingers;
	private final ModelPart Finger1;
	private final ModelPart RightArmSplit2Seg1;
	private final ModelPart RASplit2Claw1;
	private final ModelPart RASplit2Joint1;
	private final ModelPart RASplit2Plane1;
	private final ModelPart RASplit2Claw2;
	private final ModelPart RASplit2Joint2;
	private final ModelPart RASplit2Plane2;
	private final ModelPart RASplit2Claw3;
	private final ModelPart RASplit2Joint3;
	private final ModelPart RASplit2Plane3;
	private final ModelPart Finger2;
	private final ModelPart RightArmSplit2Seg2;
	private final ModelPart RASplit2Claw5;
	private final ModelPart RASplit2Joint5;
	private final ModelPart RASplit2Plane5;
	private final ModelPart RASplit2Claw4;
	private final ModelPart RASplit2Joint4;
	private final ModelPart RASplit2Plane4;
	private final ModelPart Finger3;
	private final ModelPart RightArmSplit2Seg3;
	private final ModelPart RASplit2Claw6;
	private final ModelPart RASplit2Joint6;
	private final ModelPart RASplit2Plane6;
	private final ModelPart RASplit2Claw7;
	private final ModelPart RASplit2Joint7;
	private final ModelPart RASplit2Plane7;
	private final ModelPart Tumor;

	public HandSeg2() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Fingers = root.getChild("Fingers");
		this.Finger1 = this.Fingers.getChild("Finger1");
		this.RightArmSplit2Seg1 = this.Finger1.getChild("RightArmSplit2Seg1");
		this.RASplit2Claw1 = this.RightArmSplit2Seg1.getChild("RASplit2Claw1");
		this.RASplit2Joint1 = this.RASplit2Claw1.getChild("RASplit2Joint1");
		this.RASplit2Plane1 = this.RASplit2Joint1.getChild("RASplit2Plane1");
		this.RASplit2Claw2 = this.RightArmSplit2Seg1.getChild("RASplit2Claw2");
		this.RASplit2Joint2 = this.RASplit2Claw2.getChild("RASplit2Joint2");
		this.RASplit2Plane2 = this.RASplit2Joint2.getChild("RASplit2Plane2");
		this.RASplit2Claw3 = this.RightArmSplit2Seg1.getChild("RASplit2Claw3");
		this.RASplit2Joint3 = this.RASplit2Claw3.getChild("RASplit2Joint3");
		this.RASplit2Plane3 = this.RASplit2Joint3.getChild("RASplit2Plane3");
		this.Finger2 = this.Fingers.getChild("Finger2");
		this.RightArmSplit2Seg2 = this.Finger2.getChild("RightArmSplit2Seg2");
		this.RASplit2Claw5 = this.RightArmSplit2Seg2.getChild("RASplit2Claw5");
		this.RASplit2Joint5 = this.RASplit2Claw5.getChild("RASplit2Joint5");
		this.RASplit2Plane5 = this.RASplit2Joint5.getChild("RASplit2Plane5");
		this.RASplit2Claw4 = this.RightArmSplit2Seg2.getChild("RASplit2Claw4");
		this.RASplit2Joint4 = this.RASplit2Claw4.getChild("RASplit2Joint4");
		this.RASplit2Plane4 = this.RASplit2Joint4.getChild("RASplit2Plane4");
		this.Finger3 = this.Fingers.getChild("Finger3");
		this.RightArmSplit2Seg3 = this.Finger3.getChild("RightArmSplit2Seg3");
		this.RASplit2Claw6 = this.RightArmSplit2Seg3.getChild("RASplit2Claw6");
		this.RASplit2Joint6 = this.RASplit2Claw6.getChild("RASplit2Joint6");
		this.RASplit2Plane6 = this.RASplit2Joint6.getChild("RASplit2Plane6");
		this.RASplit2Claw7 = this.RightArmSplit2Seg3.getChild("RASplit2Claw7");
		this.RASplit2Joint7 = this.RASplit2Claw7.getChild("RASplit2Joint7");
		this.RASplit2Plane7 = this.RASplit2Joint7.getChild("RASplit2Plane7");
		this.Tumor = root.getChild("Tumor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Fingers = partdefinition.addOrReplaceChild("Fingers", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Finger1 = Fingers.addOrReplaceChild("Finger1", CubeListBuilder.create().texOffs(10, 13).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7265F, -5.9457F, 0.6402F, -3.072F, 0.0785F, -2.9963F));

		PartDefinition RightArmSplit2Seg1 = Finger1.addOrReplaceChild("RightArmSplit2Seg1", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1471F, 6.3773F, 0.171F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw1 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw1", CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.177F, 1.5284F, 0.003F, -2.415F, -1.0724F, 1.5044F));

		PartDefinition RASplit2Joint1 = RASplit2Claw1.addOrReplaceChild("RASplit2Joint1", CubeListBuilder.create().texOffs(8, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane1 = RASplit2Joint1.addOrReplaceChild("RASplit2Plane1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = RASplit2Plane1.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(120, 70).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition RASplit2Claw2 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw2", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.2485F, 5.0629F, -0.1709F, -1.9428F, 1.0657F, 0.1813F));

		PartDefinition RASplit2Joint2 = RASplit2Claw2.addOrReplaceChild("RASplit2Joint2", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane2 = RASplit2Joint2.addOrReplaceChild("RASplit2Plane2", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw3 = RightArmSplit2Seg1.addOrReplaceChild("RASplit2Claw3", CubeListBuilder.create().texOffs(2, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.823F, -2.4716F, 0.003F, 2.2841F, -1.2599F, 2.7241F));

		PartDefinition RASplit2Joint3 = RASplit2Claw3.addOrReplaceChild("RASplit2Joint3", CubeListBuilder.create().texOffs(8, 14).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane3 = RASplit2Joint3.addOrReplaceChild("RASplit2Plane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.1506F, -0.3904F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Plane_r2 = RASplit2Plane3.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(120, 70).mirror().addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Finger2 = Fingers.addOrReplaceChild("Finger2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2735F, -3.9457F, -3.3598F, -1.1709F, 0.5439F, -1.1911F));

		PartDefinition RightArmSplit2Seg2 = Finger2.addOrReplaceChild("RightArmSplit2Seg2", CubeListBuilder.create().texOffs(21, 12).addBox(-1.0F, -0.25F, -1.5F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2873F, 0.3111F, 0.0592F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RASplit2Claw5 = RightArmSplit2Seg2.addOrReplaceChild("RASplit2Claw5", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.1515F, 5.0629F, 0.4291F, -1.9895F, 0.0747F, 0.2111F));

		PartDefinition RASplit2Joint5 = RASplit2Claw5.addOrReplaceChild("RASplit2Joint5", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane5 = RASplit2Joint5.addOrReplaceChild("RASplit2Plane5", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw4 = RightArmSplit2Seg2.addOrReplaceChild("RASplit2Claw4", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.0515F, 4.5629F, -0.7709F, 0.9884F, -0.0863F, -2.8196F));

		PartDefinition RASplit2Joint4 = RASplit2Claw4.addOrReplaceChild("RASplit2Joint4", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane4 = RASplit2Joint4.addOrReplaceChild("RASplit2Plane4", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition Finger3 = Fingers.addOrReplaceChild("Finger3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3735F, -3.9457F, 4.2402F, 1.6636F, -1.0976F, -1.725F));

		PartDefinition RightArmSplit2Seg3 = Finger3.addOrReplaceChild("RightArmSplit2Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2873F, 0.3111F, 0.0592F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition RightArm_r1 = RightArmSplit2Seg3.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(21, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, 0.75F, -1.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition RASplit2Claw6 = RightArmSplit2Seg3.addOrReplaceChild("RASplit2Claw6", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4485F, 5.0629F, 0.4291F, -2.0956F, 0.8248F, 0.2879F));

		PartDefinition RASplit2Joint6 = RASplit2Claw6.addOrReplaceChild("RASplit2Joint6", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane6 = RASplit2Joint6.addOrReplaceChild("RASplit2Plane6", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition RASplit2Claw7 = RightArmSplit2Seg3.addOrReplaceChild("RASplit2Claw7", CubeListBuilder.create().texOffs(14, 13).addBox(-0.5F, -6.5F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.4485F, 4.5629F, -0.7709F, 1.0957F, 0.8955F, -2.5212F));

		PartDefinition RASplit2Joint7 = RASplit2Claw7.addOrReplaceChild("RASplit2Joint7", CubeListBuilder.create().texOffs(25, 13).addBox(-0.5F, -7.0F, -1.0F, 1.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RASplit2Plane7 = RASplit2Joint7.addOrReplaceChild("RASplit2Plane7", CubeListBuilder.create().texOffs(122, 78).addBox(0.0F, -6.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition Tumor = partdefinition.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(-0.3125F, 11.4F, -0.125F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1875F, 2.6F, 2.625F, -0.3537F, -0.5236F, -0.6155F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1875F, 3.6F, -3.375F, 0.7808F, -0.5236F, -0.6155F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1875F, -2.4F, -3.375F, 0.0873F, 0.0F, -0.1309F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8125F, 1.1F, 4.625F, -0.1893F, 0.4067F, -0.3388F));

		PartDefinition Biomass_r5 = Tumor.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4125F, -1.9F, 2.025F, -1.0089F, -0.7023F, -0.3863F));

		PartDefinition Biomass_r6 = Tumor.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8125F, -2.9F, -3.375F, 1.2217F, 0.0F, 0.3927F));

		PartDefinition Biomass_r7 = Tumor.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8125F, 1.8F, -2.775F, 0.8463F, 0.1758F, 0.195F));

		PartDefinition Biomass_r8 = Tumor.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2875F, -1.9F, 3.625F, -0.1289F, 0.0227F, 0.1731F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Tumor,Mth.sin(ageInTicks/8)/8);
		float v1 = Mth.sin(ageInTicks/6)/7;
		float v2 = Mth.cos(ageInTicks/6)/8;
		float v3 = Mth.cos(ageInTicks/7)/6;
		float v4 = Mth.sin(ageInTicks/8)/6;
		animateTentacleX(Finger1,v1);
		animateTentacleY(Finger2,v2);
		animateTentacleY(Finger3,v4);
		animateTentacleX(RASplit2Claw7,v3);
		animateTentacleX(RASplit2Claw6,v4);
		animateTentacleX(RASplit2Claw5,v3);
		animateTentacleZ(RightArmSplit2Seg1,v1);
		animateTentacleX(RASplit2Claw4,v2);
		animateTentacleX(RASplit2Claw1,-v3);
		animateTentacleX(RASplit2Claw2,-v2);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Fingers.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,alpha);
		Tumor.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}