package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BasicInfected.Bairn;
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

public class BairnModel<T extends Bairn> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bairnmodel"), "main");
	private final ModelPart Bairn;
	private final ModelPart Torso;
	private final ModelPart ActualTorso;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Arms;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmLower;
	private final ModelPart RightArm;
	private final ModelPart RightArmLower;
	private final ModelPart Legs;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegLower;
	private final ModelPart RightLeg;

	public BairnModel(ModelPart root) {
		this.Bairn = root.getChild("Bairn");
		this.Torso = this.Bairn.getChild("Torso");
		this.ActualTorso = this.Torso.getChild("ActualTorso");
		this.Head = this.Torso.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.Arms = this.Torso.getChild("Arms");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftArmLower = this.LeftArm.getChild("LeftArmLower");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightArmLower = this.RightArm.getChild("RightArmLower");
		this.Legs = this.Bairn.getChild("Legs");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftLegLower = this.LeftLeg.getChild("LeftLegLower");
		this.RightLeg = this.Legs.getChild("RightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Bairn = partdefinition.addOrReplaceChild("Bairn", CubeListBuilder.create(), PartPose.offset(-3.0F, 13.35F, 7.05F));

		PartDefinition Torso = Bairn.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(3.0F, 18.65F, -3.85F));

		PartDefinition ActualTorso = Torso.addOrReplaceChild("ActualTorso", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -3.2F));

		PartDefinition BackTendril3Drowned_r1 = ActualTorso.addOrReplaceChild("BackTendril3Drowned_r1", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -9.2F, 4.3F, -0.7437F, 0.0643F, -0.059F));

		PartDefinition BackTendril2_r1 = ActualTorso.addOrReplaceChild("BackTendril2_r1", CubeListBuilder.create().texOffs(36, 24).addBox(1.0F, -3.8586F, -2.5757F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -8.8F, 2.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition BackTendril1_r1 = ActualTorso.addOrReplaceChild("BackTendril1_r1", CubeListBuilder.create().texOffs(12, 35).addBox(1.0F, -3.9293F, -2.505F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -8.8F, 2.4F, -0.7854F, 0.0F, 0.0F));

		PartDefinition TorsoClothes_r1 = ActualTorso.addOrReplaceChild("TorsoClothes_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.2F))
				.texOffs(0, 11).addBox(-3.0F, -4.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -7.9F, 0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -19.0F, -3.8F, 0.1571F, 0.0F, 0.0F));

		PartDefinition HeadExtensionVillager_r1 = Head.addOrReplaceChild("HeadExtensionVillager_r1", CubeListBuilder.create().texOffs(38, 18).addBox(-3.0F, -6.3F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(40, 57).addBox(-3.0F, 0.7F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-3.0F, -4.3F, -3.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9557F, -2.1202F, -0.3142F, 0.0F, 0.0F));

		PartDefinition NoseVillager_r1 = Head.addOrReplaceChild("NoseVillager_r1", CubeListBuilder.create().texOffs(43, 4).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.1F, -1.4557F, -5.9202F, -0.2007F, 0.0F, 0.0F));

		PartDefinition Ear2Drowned_r1 = Head.addOrReplaceChild("Ear2Drowned_r1", CubeListBuilder.create().texOffs(58, -3).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(58, -3).addBox(-6.1F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1F, -5.9064F, 1.1087F, -0.3316F, 0.0F, 0.0F));

		PartDefinition BackJaw_r1 = Head.addOrReplaceChild("BackJaw_r1", CubeListBuilder.create().texOffs(36, 0).addBox(-2.0F, -0.3F, 1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.5F, -2.1557F, -2.1202F, -0.3142F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -0.0557F, -0.7202F));

		PartDefinition BottomJaw_r1 = Jaw.addOrReplaceChild("BottomJaw_r1", CubeListBuilder.create().texOffs(20, 11).addBox(-3.0F, -0.5703F, -4.705F, 6.0F, 1.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0175F, 0.0F, 0.0F));

		PartDefinition Arms = Torso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -8.0F, -3.2F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(3.2F, -10.45F, -1.4F));

		PartDefinition LeftArmTop_r1 = LeftArm.addOrReplaceChild("LeftArmTop_r1", CubeListBuilder.create().texOffs(20, 17).addBox(-0.1F, -1.2564F, -1.5987F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.2F, 0.85F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition LeftArmLower = LeftArm.addOrReplaceChild("LeftArmLower", CubeListBuilder.create(), PartPose.offset(1.2F, 5.2855F, -1.0389F));

		PartDefinition LeftClaw3_r1 = LeftArmLower.addOrReplaceChild("LeftClaw3_r1", CubeListBuilder.create().texOffs(6, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(20, 41).addBox(1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(0, 40).addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.4645F, -1.5611F, 0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArmBottom_r1 = LeftArmLower.addOrReplaceChild("LeftArmBottom_r1", CubeListBuilder.create().texOffs(24, 0).addBox(-1.5F, -0.4692F, -1.4297F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.0355F, 0.0389F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-3.2F, -10.45F, -1.4F));

		PartDefinition RightArmTop_r1 = RightArm.addOrReplaceChild("RightArmTop_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-2.8F, -1.1753F, -1.4829F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.1F, 0.75F, -0.1F, -0.1745F, 0.0F, 0.0F));

		PartDefinition RightArmLower = RightArm.addOrReplaceChild("RightArmLower", CubeListBuilder.create(), PartPose.offset(-1.2F, 5.2855F, -1.0389F));

		PartDefinition RightClaw3_r1 = RightArmLower.addOrReplaceChild("RightClaw3_r1", CubeListBuilder.create().texOffs(36, 37).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(36, 32).addBox(-3.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(36, 4).addBox(-2.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.4645F, -1.5611F, 0.0873F, 0.0F, 0.0F));

		PartDefinition RightArmBottom_r1 = RightArmLower.addOrReplaceChild("RightArmBottom_r1", CubeListBuilder.create().texOffs(12, 26).addBox(-1.5F, -0.3831F, -1.5419F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.1355F, 0.1389F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Legs = Bairn.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(3.0F, 10.65F, -7.05F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(24, 34).addBox(-1.5F, -0.1F, -1.55F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(2.0F, -5.9F, 2.35F));

		PartDefinition LeftLegLower = LeftLeg.addOrReplaceChild("LeftLegLower", CubeListBuilder.create(), PartPose.offset(-0.05F, 2.2434F, 0.4048F));

		PartDefinition LeftLegTendrilDrowned_r1 = LeftLegLower.addOrReplaceChild("LeftLegTendrilDrowned_r1", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -2.0F, -2.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.05F, 0.4566F, 3.9452F, -0.6594F, -0.1028F, 0.0947F));

		PartDefinition LeftLegBottom_r1 = LeftLegLower.addOrReplaceChild("LeftLegBottom_r1", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.7302F, -1.2213F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, 1.1566F, -0.5548F, 0.9599F, 0.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(32, 17).addBox(-1.5F, -0.1434F, -1.5548F, 3.0F, 4.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(-2.0F, -5.8566F, 2.1548F));

		PartDefinition RightLegBottom_r1 = RightLeg.addOrReplaceChild("RightLegBottom_r1", CubeListBuilder.create().texOffs(24, 26).addBox(-1.5F, -0.5337F, -2.5647F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1434F, 0.4548F, 0.9599F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float moveValue  = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		RightArm.xRot = moveValue;
		LeftArm.xRot = -moveValue;
		RightLeg.xRot = moveValue * 0.8f;
		LeftLeg.xRot = -moveValue * 0.8f;
		Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		Jaw.xRot = Mth.sin(ageInTicks/7)/7;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Bairn.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}