package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.BasicInfected.InfectedHazmat;
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

public class InfectedHazmatWithTank<T extends InfectedHazmat> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infectedhazmatwithtank"), "main");
	private final ModelPart TorsoBase;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart Tank;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart FrontFungi1;
	private final ModelPart FrontFungi2;
	private final ModelPart FrontFungi3;
	private final ModelPart FrontFungi4;

	public InfectedHazmatWithTank(ModelPart root) {
		this.TorsoBase = root.getChild("TorsoBase");
		this.LeftLeg = root.getChild("LeftLeg");
		this.RightLeg = root.getChild("RightLeg");
		this.Tank = root.getChild("Tank");
		this.RightForLeg = RightLeg.getChild("RlegBase").getChild("RlegEnd");
		this.LeftForLeg = LeftLeg.getChild("LlegBase").getChild("LlegEnd");
		this.Head = TorsoBase.getChild("TorsoTop").getChild("Head");
		this.RightArm = TorsoBase.getChild("TorsoTop").getChild("arms").getChild("Rarm");
		this.LeftArm = TorsoBase.getChild("TorsoTop").getChild("arms").getChild("Larm");
		this.FrontFungi1 = Head.getChild("funnyfungus").getChild("Tendril1");
		this.FrontFungi2 = Head.getChild("funnyfungus").getChild("Tendril2");
		this.FrontFungi3 = Head.getChild("funnyfungus").getChild("Tendril3");
		this.FrontFungi4 = Head.getChild("funnyfungus").getChild("Smolltendies");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition TorsoBase = partdefinition.addOrReplaceChild("TorsoBase", CubeListBuilder.create().texOffs(0, 32).addBox(-3.5F, -4.0F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(24, 26).addBox(-4.0F, -3.25F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 11.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition TorsoTop = TorsoBase.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(29, 12).addBox(-3.5F, -4.5F, -2.5F, 7.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TorsoTopFluff = TorsoTop.addOrReplaceChild("TorsoTopFluff", CubeListBuilder.create().texOffs(34, 0).addBox(-4.375F, -2.24F, -2.375F, 3.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(53, 16).addBox(-1.375F, -0.25F, -2.375F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(34, 37).addBox(-1.375F, -2.24F, -2.375F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 37).addBox(1.625F, -2.24F, -2.375F, 2.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.375F, -2.25F, -0.625F));

		PartDefinition Head = TorsoTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 17).addBox(-4.0F, -8.0F, -2.75F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, -0.25F, -0.4363F, 0.0F, 0.0F));

		PartDefinition GasMask = Head.addOrReplaceChild("GasMask", CubeListBuilder.create(), PartPose.offset(0.05F, -1.0F, 0.25F));

		PartDefinition Basefilter = GasMask.addOrReplaceChild("Basefilter", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base2 = Basefilter.addOrReplaceChild("Base2", CubeListBuilder.create().texOffs(46, 0).addBox(-12.0F, -10.24F, 2.74F, 8.0F, 4.0F, 2.0F, new CubeDeformation(-0.75F))
		.texOffs(52, 42).addBox(-6.0F, -9.0F, 3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-4.0F, -10.0F, 4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(60, 8).addBox(-13.0F, -9.0F, 3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(41, 64).addBox(-13.0F, -10.0F, 4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 8.0F, -8.0F));

		PartDefinition baseLeftSmoohside_r1 = Base2.addOrReplaceChild("baseLeftSmoohside_r1", CubeListBuilder.create().texOffs(65, 61).addBox(5.55F, -0.75F, 0.0F, 2.9F, 1.5F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(66, 52).addBox(-1.45F, -0.75F, 0.0F, 2.9F, 1.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -9.5F, 3.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Filter = Basefilter.addOrReplaceChild("Filter", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Filter1 = Filter.addOrReplaceChild("Filter1", CubeListBuilder.create(), PartPose.offset(-4.5196F, -1.55F, -5.8483F));

		PartDefinition FilterStrands = Filter1.addOrReplaceChild("FilterStrands", CubeListBuilder.create(), PartPose.offset(1.25F, 2.25F, 1.575F));

		PartDefinition Stringy_r1 = FilterStrands.addOrReplaceChild("Stringy_r1", CubeListBuilder.create().texOffs(12, 42).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.25F, 0.75F, 0.375F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Stringy_r2 = FilterStrands.addOrReplaceChild("Stringy_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.25F, 0.75F, -0.375F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Filter1end = FilterStrands.addOrReplaceChild("Filter1end", CubeListBuilder.create().texOffs(41, 22).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2196F, 3.55F, -0.2767F));

		PartDefinition Filter1Cap_r1 = Filter1end.addOrReplaceChild("Filter1Cap_r1", CubeListBuilder.create().texOffs(29, 64).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 0.0F, 0.2182F, 0.0F, 0.2182F));

		PartDefinition Filter2 = Filter.addOrReplaceChild("Filter2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4196F, 0.45F, -3.8483F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Filter1Cap_r2 = Filter2.addOrReplaceChild("Filter1Cap_r2", CubeListBuilder.create().texOffs(65, 57).addBox(-0.6981F, 0.8819F, -1.9782F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(55, 66).addBox(-0.1981F, 1.3819F, -0.9782F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0196F, -2.8995F, -1.5659F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Helmet = Head.addOrReplaceChild("Helmet", CubeListBuilder.create(), PartPose.offset(-0.5F, 24.5F, 0.25F));

		PartDefinition HelmetBase = Helmet.addOrReplaceChild("HelmetBase", CubeListBuilder.create().texOffs(0, 0).addBox(-11.0F, -35.0F, 5.01F, 9.0F, 9.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(23, 22).addBox(-11.0F, -35.0F, 4.01F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 22).addBox(-11.0F, -27.0F, 4.01F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 66).addBox(-11.0F, -34.0F, 4.01F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 66).addBox(-3.0F, -34.0F, 4.01F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 2.0F, -8.0F));

		PartDefinition Glass = Helmet.addOrReplaceChild("Glass", CubeListBuilder.create().texOffs(0, 17).addBox(-4.75F, -1.5F, 0.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(0.25F, -1.5F, 0.0F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-0.75F, -1.5F, 0.0F, 1.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.75F, -30.5F, -3.74F));

		PartDefinition Glass_r1 = Glass.addOrReplaceChild("Glass_r1", CubeListBuilder.create().texOffs(19, 32).addBox(-1.0F, -2.0F, 0.001F, 2.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0436F, -0.3491F));

		PartDefinition Glass_r2 = Glass.addOrReplaceChild("Glass_r2", CubeListBuilder.create().texOffs(0, 6).addBox(-1.5F, -1.0F, 0.0F, 3.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 3.5F, 0.0F, 0.1304F, 0.0114F, -0.4356F));

		PartDefinition Glass_r3 = Glass.addOrReplaceChild("Glass_r3", CubeListBuilder.create().texOffs(35, 0).addBox(-1.0F, -2.0F, 0.001F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.15F, 2.5F, 0.0F, 0.0F, -0.0873F, -0.4363F));

		PartDefinition Glass_r4 = Glass.addOrReplaceChild("Glass_r4", CubeListBuilder.create().texOffs(5, 0).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.25F, -1.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition funnyfungus = Head.addOrReplaceChild("funnyfungus", CubeListBuilder.create(), PartPose.offset(0.0F, 22.0F, 0.25F));

		PartDefinition Tendril1 = funnyfungus.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2552F, -27.8653F, -3.3662F, -0.5236F, 0.0F, 0.0F));

		PartDefinition tendril1Base_r1 = Tendril1.addOrReplaceChild("tendril1Base_r1", CubeListBuilder.create().texOffs(64, 8).addBox(-1.0F, -1.0173F, -3.0306F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0052F, -0.2508F, 0.9998F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril1Seg1 = Tendril1.addOrReplaceChild("tendril1Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.4747F, -1.4546F));

		PartDefinition tendril1Seg1_r1 = tendril1Seg1.addOrReplaceChild("tendril1Seg1_r1", CubeListBuilder.create().texOffs(62, 2).addBox(-0.9753F, -1.0782F, -3.2721F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0116F, 0.0779F, -0.2956F));

		PartDefinition Tendril2 = funnyfungus.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.208F, -26.4991F, -3.21F, -0.2666F, -0.1509F, 1.0675F));

		PartDefinition tendril2Base_r1 = Tendril2.addOrReplaceChild("tendril2Base_r1", CubeListBuilder.create().texOffs(49, 64).addBox(-0.5F, -0.7673F, -2.0306F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0804F, 0.1089F, 0.5785F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril2Seg1 = Tendril2.addOrReplaceChild("tendril2Seg1", CubeListBuilder.create(), PartPose.offset(0.0132F, 0.0763F, -0.644F));

		PartDefinition tendril2Seg1_r1 = tendril2Seg1.addOrReplaceChild("tendril2Seg1_r1", CubeListBuilder.create().texOffs(64, 37).addBox(-0.5074F, -0.5212F, -3.0093F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.021F, 0.2018F, -0.2099F, -0.0116F, 0.0779F, -0.2956F));

		PartDefinition Tendril3 = funnyfungus.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.708F, -25.4991F, -3.21F, -0.2666F, -0.1509F, 1.0675F));

		PartDefinition tendril3Base_r1 = Tendril3.addOrReplaceChild("tendril3Base_r1", CubeListBuilder.create().texOffs(42, 45).addBox(-0.5F, -0.8673F, -2.0306F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0804F, 0.1089F, 0.5785F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition tendril3Seg1 = Tendril3.addOrReplaceChild("tendril3Seg1", CubeListBuilder.create(), PartPose.offset(0.0752F, 0.3344F, -1.3758F));

		PartDefinition tendril3Seg1_r1 = tendril3Seg1.addOrReplaceChild("tendril3Seg1_r1", CubeListBuilder.create().texOffs(66, 48).addBox(-0.5463F, -0.527F, -2.5109F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.083F, -0.0563F, 0.022F, 0.2938F, 0.0779F, -0.2956F));

		PartDefinition Smolltendies = funnyfungus.addOrReplaceChild("Smolltendies", CubeListBuilder.create().texOffs(23, 17).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offset(0.0F, -27.0F, -3.0F));

		PartDefinition arms = TorsoTop.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -5.5F, 0.0F));

		PartDefinition Larm = arms.addOrReplaceChild("Larm", CubeListBuilder.create().texOffs(60, 29).addBox(-0.5F, -1.3312F, -2.3806F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 33).addBox(-1.0F, -1.8312F, -2.8806F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 3.5789F, 0.4837F, -0.4363F, 0.0F, 0.0F));

		PartDefinition LarmEnd = Larm.addOrReplaceChild("LarmEnd", CubeListBuilder.create().texOffs(26, 0).addBox(-1.49F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(62, 24).addBox(-1.5F, 2.75F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(0, 53).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 3.6688F, -0.8806F));

		PartDefinition Rarm = arms.addOrReplaceChild("Rarm", CubeListBuilder.create().texOffs(0, 60).addBox(-2.5F, -1.25F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(12, 48).addBox(-3.0F, -1.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, 3.5789F, 0.4837F, -0.4363F, 0.0F, 0.0F));

		PartDefinition RarmEnd = Rarm.addOrReplaceChild("RarmEnd", CubeListBuilder.create().texOffs(58, 16).addBox(-1.49F, 0.0F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 7).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 3.75F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition LlegBase = LeftLeg.addOrReplaceChild("LlegBase", CubeListBuilder.create().texOffs(13, 57).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 45).addBox(-1.99F, -0.5F, -2.01F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LlegEnd = LlegBase.addOrReplaceChild("LlegEnd", CubeListBuilder.create().texOffs(49, 55).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(46, 22).addBox(-2.0F, 0.25F, -2.01F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition RlegBase = RightLeg.addOrReplaceChild("RlegBase", CubeListBuilder.create().texOffs(37, 55).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(30, 45).addBox(-2.01F, -0.5F, -2.01F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RlegEnd = RlegBase.addOrReplaceChild("RlegEnd", CubeListBuilder.create().texOffs(25, 55).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-2.0F, 0.25F, -2.01F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Tank = partdefinition.addOrReplaceChild("Tank", CubeListBuilder.create().texOffs(108, 1).addBox(-2.5F, -7.0F, -1.0F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(116, 20).addBox(-1.5F, -8.0F, 0.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 10.0F, 3.0F, 0.1309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = -90F - (Mth.sin(ageInTicks/4)/7);
			this.LeftArm.xRot = -90F + (Mth.sin(ageInTicks/4)/7);
		} else {
			this.RightArm.xRot =-0.7f + Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot =-0.7f  -Mth.sin(ageInTicks/8)/10;
		}
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		if (LeftLeg.xRot < 0){
			this.LeftForLeg.xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.RightForLeg.xRot = -RightLeg.xRot;}


		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.FrontFungi1.yRot = -Mth.sin(ageInTicks/5)/6;
		this.FrontFungi2.yRot = 0.4f+Mth.sin(ageInTicks/6)/8;
		this.FrontFungi3.yRot = 0.3f-Mth.sin(ageInTicks/4)/6;
		this.FrontFungi4.yRot = Mth.sin(ageInTicks/8)/6;
		this.FrontFungi1.getChild("tendril1Seg1").xRot = -Mth.sin(ageInTicks/5)/6;
		this.FrontFungi3.getChild("tendril3Seg1").xRot = -Mth.sin(ageInTicks/4)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		TorsoBase.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Tank.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}