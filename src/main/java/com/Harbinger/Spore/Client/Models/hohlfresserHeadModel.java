package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
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

public class hohlfresserHeadModel<T extends Hohlfresser> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hohlfresserheadmodel"), "main");
	private final ModelPart hohl_head;
	private final ModelPart TrueHead;
	private final ModelPart Inner;
	private final ModelPart InnerRingBase;
	private final ModelPart InnerRim;
	private final ModelPart InnerRaise;
	private final ModelPart InnerRingDetail;
	private final ModelPart LargeTongue;
	private final ModelPart LargeTongueS2;
	private final ModelPart LargeTongueS3;
	private final ModelPart LargeTongueS4;
	private final ModelPart LargeTongue2;
	private final ModelPart LargeTongueS5;
	private final ModelPart LargeTongueS6;
	private final ModelPart LargeTongueS7;
	private final ModelPart LargeTongue3;
	private final ModelPart LargeTongueS8;
	private final ModelPart LargeTongueS9;
	private final ModelPart LargeTongueS10;
	private final ModelPart Outer;
	private final ModelPart OuterRingBase;
	private final ModelPart Rim;
	private final ModelPart Raised;
	private final ModelPart Internal;
	private final ModelPart OuterRingDetails;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Body5;
	private final ModelPart Body6;
	private final ModelPart Body7;
	private final ModelPart Body8;
	private final ModelPart Body9;
	private final ModelPart Body10;
	private final ModelPart Body11;
	private final ModelPart Body12;
	private final ModelPart Body13;
	private final ModelPart Body14;
	private final ModelPart Body15;
	private final ModelPart Body16;
	private final ModelPart Biomass;
	private final ModelPart FungalBloom;
	private final ModelPart Teeth;
	private final ModelPart Tongue;
	private final ModelPart TongueSeg2;
	private final ModelPart TongueSeg3;
	private final ModelPart TongueSeg4;
	private final ModelPart TongueSeg5;
	private final ModelPart Body;
	private final ModelPart Front;
	private final ModelPart Middle;
	private final ModelPart MiddleDetails;
	private final ModelPart RidgeBodies;
	private final ModelPart Body17;
	private final ModelPart Body18;
	private final ModelPart Body19;
	private final ModelPart Body20;
	private final ModelPart Body21;
	private final ModelPart Body22;
	private final ModelPart Body23;
	private final ModelPart Body24;
	private final ModelPart Body25;
	private final ModelPart Body26;
	private final ModelPart Body27;
	private final ModelPart Body28;
	private final ModelPart Body29;
	private final ModelPart ArmoredTumors2;
	private final ModelPart armor;
	private final ModelPart ArmoredTumors3;
	private final ModelPart armor2;
	private final ModelPart ArmoredTumors4;
	private final ModelPart armor3;
	private final ModelPart Bloom;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Seg3Tendril1;
	private final ModelPart Seg4Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Seg3Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;
	private final ModelPart Seg3Tendril3;
	private final ModelPart Seg4Tendril2;
	private final ModelPart Tendril4;
	private final ModelPart Seg2Tendril4;
	private final ModelPart Seg3Tendril4;
	private final ModelPart Seg4Tendril3;
	private final ModelPart Tendril5;
	private final ModelPart Seg2Tendril5;
	private final ModelPart Seg3Tendril5;
	private final ModelPart Tendril6;
	private final ModelPart Seg2Tendril6;
	private final ModelPart Seg3Tendril6;
	private final ModelPart Tendril7;
	private final ModelPart Seg2Tendril7;
	private final ModelPart Seg3Tendril7;
	private final ModelPart Seg4Tendril7;
	private final ModelPart TopSpine;
	private final ModelPart rib1;
	private final ModelPart TopSpine2;
	private final ModelPart Back;
	private final ModelPart BackDetails;
	private final ModelPart ArmoredTumors1;
	private final ModelPart FungalArmor;
	private final ModelPart BackTumors;
	private final ModelPart Root1;
	private final ModelPart R1Seg2;
	private final ModelPart R1Seg3;
	private final ModelPart R1Seg4;
	private final ModelPart EndTumors;
	private final ModelPart EndRoot;
	private final ModelPart ESeg1;
	private final ModelPart ESeg2;
	private final ModelPart ESeg3;

	public hohlfresserHeadModel(ModelPart root) {
		this.hohl_head = root.getChild("hohl_head");
		this.TrueHead = this.hohl_head.getChild("TrueHead");
		this.Inner = this.TrueHead.getChild("Inner");
		this.InnerRingBase = this.Inner.getChild("InnerRingBase");
		this.InnerRim = this.InnerRingBase.getChild("InnerRim");
		this.InnerRaise = this.InnerRingBase.getChild("InnerRaise");
		this.InnerRingDetail = this.InnerRaise.getChild("InnerRingDetail");
		this.LargeTongue = this.InnerRaise.getChild("LargeTongue");
		this.LargeTongueS2 = this.LargeTongue.getChild("LargeTongueS2");
		this.LargeTongueS3 = this.LargeTongueS2.getChild("LargeTongueS3");
		this.LargeTongueS4 = this.LargeTongueS3.getChild("LargeTongueS4");
		this.LargeTongue2 = this.InnerRaise.getChild("LargeTongue2");
		this.LargeTongueS5 = this.LargeTongue2.getChild("LargeTongueS5");
		this.LargeTongueS6 = this.LargeTongueS5.getChild("LargeTongueS6");
		this.LargeTongueS7 = this.LargeTongueS6.getChild("LargeTongueS7");
		this.LargeTongue3 = this.InnerRaise.getChild("LargeTongue3");
		this.LargeTongueS8 = this.LargeTongue3.getChild("LargeTongueS8");
		this.LargeTongueS9 = this.LargeTongueS8.getChild("LargeTongueS9");
		this.LargeTongueS10 = this.LargeTongueS9.getChild("LargeTongueS10");
		this.Outer = this.TrueHead.getChild("Outer");
		this.OuterRingBase = this.Outer.getChild("OuterRingBase");
		this.Rim = this.OuterRingBase.getChild("Rim");
		this.Raised = this.OuterRingBase.getChild("Raised");
		this.Internal = this.OuterRingBase.getChild("Internal");
		this.OuterRingDetails = this.Outer.getChild("OuterRingDetails");
		this.Body1 = this.OuterRingDetails.getChild("Body1");
		this.Body2 = this.OuterRingDetails.getChild("Body2");
		this.Body3 = this.OuterRingDetails.getChild("Body3");
		this.Body4 = this.OuterRingDetails.getChild("Body4");
		this.Body5 = this.OuterRingDetails.getChild("Body5");
		this.Body6 = this.OuterRingDetails.getChild("Body6");
		this.Body7 = this.OuterRingDetails.getChild("Body7");
		this.Body8 = this.OuterRingDetails.getChild("Body8");
		this.Body9 = this.OuterRingDetails.getChild("Body9");
		this.Body10 = this.OuterRingDetails.getChild("Body10");
		this.Body11 = this.OuterRingDetails.getChild("Body11");
		this.Body12 = this.OuterRingDetails.getChild("Body12");
		this.Body13 = this.OuterRingDetails.getChild("Body13");
		this.Body14 = this.OuterRingDetails.getChild("Body14");
		this.Body15 = this.OuterRingDetails.getChild("Body15");
		this.Body16 = this.OuterRingDetails.getChild("Body16");
		this.Biomass = this.OuterRingDetails.getChild("Biomass");
		this.FungalBloom = this.OuterRingDetails.getChild("FungalBloom");
		this.Teeth = this.OuterRingDetails.getChild("Teeth");
		this.Tongue = this.OuterRingDetails.getChild("Tongue");
		this.TongueSeg2 = this.Tongue.getChild("TongueSeg2");
		this.TongueSeg3 = this.TongueSeg2.getChild("TongueSeg3");
		this.TongueSeg4 = this.TongueSeg3.getChild("TongueSeg4");
		this.TongueSeg5 = this.TongueSeg4.getChild("TongueSeg5");
		this.Body = this.hohl_head.getChild("Body");
		this.Front = this.Body.getChild("Front");
		this.Middle = this.Body.getChild("Middle");
		this.MiddleDetails = this.Middle.getChild("MiddleDetails");
		this.RidgeBodies = this.MiddleDetails.getChild("RidgeBodies");
		this.Body17 = this.RidgeBodies.getChild("Body17");
		this.Body18 = this.RidgeBodies.getChild("Body18");
		this.Body19 = this.RidgeBodies.getChild("Body19");
		this.Body20 = this.RidgeBodies.getChild("Body20");
		this.Body21 = this.RidgeBodies.getChild("Body21");
		this.Body22 = this.RidgeBodies.getChild("Body22");
		this.Body23 = this.RidgeBodies.getChild("Body23");
		this.Body24 = this.RidgeBodies.getChild("Body24");
		this.Body25 = this.RidgeBodies.getChild("Body25");
		this.Body26 = this.RidgeBodies.getChild("Body26");
		this.Body27 = this.RidgeBodies.getChild("Body27");
		this.Body28 = this.RidgeBodies.getChild("Body28");
		this.Body29 = this.RidgeBodies.getChild("Body29");
		this.ArmoredTumors2 = this.MiddleDetails.getChild("ArmoredTumors2");
		this.armor = this.ArmoredTumors2.getChild("armor");
		this.ArmoredTumors3 = this.MiddleDetails.getChild("ArmoredTumors3");
		this.armor2 = this.ArmoredTumors3.getChild("armor2");
		this.ArmoredTumors4 = this.MiddleDetails.getChild("ArmoredTumors4");
		this.armor3 = this.ArmoredTumors4.getChild("armor3");
		this.Bloom = this.MiddleDetails.getChild("Bloom");
		this.Tendril1 = this.MiddleDetails.getChild("Tendril1");
		this.Seg2Tendril1 = this.Tendril1.getChild("Seg2Tendril1");
		this.Seg3Tendril1 = this.Seg2Tendril1.getChild("Seg3Tendril1");
		this.Seg4Tendril1 = this.Seg3Tendril1.getChild("Seg4Tendril1");
		this.Tendril2 = this.MiddleDetails.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Seg3Tendril2 = this.Seg2Tendril2.getChild("Seg3Tendril2");
		this.Tendril3 = this.MiddleDetails.getChild("Tendril3");
		this.Seg2Tendril3 = this.Tendril3.getChild("Seg2Tendril3");
		this.Seg3Tendril3 = this.Seg2Tendril3.getChild("Seg3Tendril3");
		this.Seg4Tendril2 = this.Seg3Tendril3.getChild("Seg4Tendril2");
		this.Tendril4 = this.MiddleDetails.getChild("Tendril4");
		this.Seg2Tendril4 = this.Tendril4.getChild("Seg2Tendril4");
		this.Seg3Tendril4 = this.Seg2Tendril4.getChild("Seg3Tendril4");
		this.Seg4Tendril3 = this.Seg3Tendril4.getChild("Seg4Tendril3");
		this.Tendril5 = this.MiddleDetails.getChild("Tendril5");
		this.Seg2Tendril5 = this.Tendril5.getChild("Seg2Tendril5");
		this.Seg3Tendril5 = this.Seg2Tendril5.getChild("Seg3Tendril5");
		this.Tendril6 = this.MiddleDetails.getChild("Tendril6");
		this.Seg2Tendril6 = this.Tendril6.getChild("Seg2Tendril6");
		this.Seg3Tendril6 = this.Seg2Tendril6.getChild("Seg3Tendril6");
		this.Tendril7 = this.MiddleDetails.getChild("Tendril7");
		this.Seg2Tendril7 = this.Tendril7.getChild("Seg2Tendril7");
		this.Seg3Tendril7 = this.Seg2Tendril7.getChild("Seg3Tendril7");
		this.Seg4Tendril7 = this.Seg3Tendril7.getChild("Seg4Tendril7");
		this.TopSpine = this.Middle.getChild("TopSpine");
		this.rib1 = this.TopSpine.getChild("rib1");
		this.TopSpine2 = this.Middle.getChild("TopSpine2");
		this.Back = this.Body.getChild("Back");
		this.BackDetails = this.Back.getChild("BackDetails");
		this.ArmoredTumors1 = this.BackDetails.getChild("ArmoredTumors1");
		this.FungalArmor = this.ArmoredTumors1.getChild("FungalArmor");
		this.BackTumors = this.BackDetails.getChild("BackTumors");
		this.Root1 = this.BackDetails.getChild("Root1");
		this.R1Seg2 = this.Root1.getChild("R1Seg2");
		this.R1Seg3 = this.R1Seg2.getChild("R1Seg3");
		this.R1Seg4 = this.R1Seg3.getChild("R1Seg4");
		this.EndTumors = this.Back.getChild("EndTumors");
		this.EndRoot = this.Back.getChild("EndRoot");
		this.ESeg1 = this.EndRoot.getChild("ESeg1");
		this.ESeg2 = this.ESeg1.getChild("ESeg2");
		this.ESeg3 = this.ESeg2.getChild("ESeg3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hohl_head = partdefinition.addOrReplaceChild("hohl_head", CubeListBuilder.create(), PartPose.offset(-9.0F, -5.0F, 41.0F));

		PartDefinition TrueHead = hohl_head.addOrReplaceChild("TrueHead", CubeListBuilder.create(), PartPose.offset(9.0F, 5.0F, -70.0F));

		PartDefinition Inner = TrueHead.addOrReplaceChild("Inner", CubeListBuilder.create(), PartPose.offset(1.5F, -5.5F, 6.0F));

		PartDefinition InnerRingBase = Inner.addOrReplaceChild("InnerRingBase", CubeListBuilder.create().texOffs(364, 66).addBox(-10.0F, -12.0F, 8.0F, 22.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition InnerRim = InnerRingBase.addOrReplaceChild("InnerRim", CubeListBuilder.create().texOffs(314, 183).addBox(-9.6968F, 10.8386F, -1.0F, 19.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.8017F, -0.0676F, 0.0F));

		PartDefinition teeth_r1 = InnerRim.addOrReplaceChild("teeth_r1", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.5F, -0.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5478F, -11.2428F, -0.0041F, 0.347F, 1.213F, -0.9978F));

		PartDefinition teeth_r2 = InnerRim.addOrReplaceChild("teeth_r2", CubeListBuilder.create().texOffs(1, -3).addBox(1.3127F, -6.4486F, -3.2219F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.1228F, 8.2613F, 2.1279F, -0.347F, 1.213F, 1.8704F));

		PartDefinition teeth_r3 = InnerRim.addOrReplaceChild("teeth_r3", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.5F, -0.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2022F, 9.3779F, -0.2541F, -0.347F, 1.213F, 1.3032F));

		PartDefinition Base_r1 = InnerRim.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(114, 183).addBox(-4.0F, -12.25F, -1.0F, 3.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Base_r2 = InnerRim.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(446, 236).addBox(-10.0F, -1.25F, -1.0F, 11.0F, 2.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-8.4468F, 11.5886F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Base_r3 = InnerRim.addOrReplaceChild("Base_r3", CubeListBuilder.create().texOffs(318, 469).addBox(-1.0F, -1.25F, -1.0F, 2.0F, 14.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(15.6083F, 2.5684F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Base_r4 = InnerRim.addOrReplaceChild("Base_r4", CubeListBuilder.create().texOffs(234, 362).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 14.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(13.9115F, -10.3204F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Base_r5 = InnerRim.addOrReplaceChild("Base_r5", CubeListBuilder.create().texOffs(364, 195).addBox(-6.0F, -1.0F, -1.0F, 24.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3017F, -15.4324F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Base_r6 = InnerRim.addOrReplaceChild("Base_r6", CubeListBuilder.create().texOffs(28, 472).addBox(0.0F, -13.25F, -1.0F, 2.0F, 14.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-11.3937F, -5.1241F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition InnerRaise = InnerRingBase.addOrReplaceChild("InnerRaise", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Raised_r1 = InnerRaise.addOrReplaceChild("Raised_r1", CubeListBuilder.create().texOffs(162, 431).addBox(-2.0F, -6.0F, 0.0F, 2.0F, 15.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-7.0426F, -10.7111F, 1.0F, 0.0F, 0.6109F, 0.2618F));

		PartDefinition Raised_r2 = InnerRaise.addOrReplaceChild("Raised_r2", CubeListBuilder.create().texOffs(256, 430).addBox(-3.0F, -6.5F, 0.0F, 3.0F, 13.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7194F, 1.6487F, 1.0F, 0.0F, 0.5672F, 0.6109F));

		PartDefinition Raised_r3 = InnerRaise.addOrReplaceChild("Raised_r3", CubeListBuilder.create().texOffs(404, 127).addBox(-5.5F, 0.0F, 0.0F, 11.0F, 2.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-10.6143F, 7.916F, 1.0F, 0.48F, 0.0F, 0.6109F));

		PartDefinition Raised_r4 = InnerRaise.addOrReplaceChild("Raised_r4", CubeListBuilder.create().texOffs(364, 289).addBox(-9.5F, 0.0F, 0.0F, 19.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6049F, 10.771F, 1.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Raised_r5 = InnerRaise.addOrReplaceChild("Raised_r5", CubeListBuilder.create().texOffs(0, 442).addBox(0.0F, -7.0F, 0.0F, 2.0F, 14.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(12.1163F, 6.4538F, 1.0F, 0.0F, -0.5236F, 0.6545F));

		PartDefinition Raised_r6 = InnerRaise.addOrReplaceChild("Raised_r6", CubeListBuilder.create().texOffs(104, 438).addBox(0.0F, -7.0F, 0.0F, 2.0F, 14.0F, 9.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(14.6028F, -3.5652F, 1.0F, 0.0F, -0.6545F, -0.1309F));

		PartDefinition Raised_r7 = InnerRaise.addOrReplaceChild("Raised_r7", CubeListBuilder.create().texOffs(350, 13).addBox(-12.0F, -2.0F, 0.0F, 24.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9216F, -12.742F, 1.0F, -0.6545F, 0.0F, 0.3054F));

		PartDefinition InnerRingDetail = InnerRaise.addOrReplaceChild("InnerRingDetail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition teeth_r4 = InnerRingDetail.addOrReplaceChild("teeth_r4", CubeListBuilder.create().texOffs(0, -3).addBox(0.0F, -4.5F, -1.5F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.9128F, 2.7951F, 5.9183F, 1.9518F, 1.2985F, -0.75F));

		PartDefinition teeth_r5 = InnerRingDetail.addOrReplaceChild("teeth_r5", CubeListBuilder.create().texOffs(0, -3).addBox(0.9899F, -4.0282F, -3.501F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.3096F, 1.1729F, 4.9221F, -0.347F, 1.213F, -2.711F));

		PartDefinition teeth_r6 = InnerRingDetail.addOrReplaceChild("teeth_r6", CubeListBuilder.create().texOffs(0, -3).addBox(-1.7125F, -5.7434F, -0.4112F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5711F, 6.1937F, 1.3779F, 1.7336F, 1.2985F, -2.4517F));

		PartDefinition teeth_r7 = InnerRingDetail.addOrReplaceChild("teeth_r7", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.5F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8368F, 8.5165F, 2.9307F, 1.5591F, 1.2985F, -3.0189F));

		PartDefinition teeth_r8 = InnerRingDetail.addOrReplaceChild("teeth_r8", CubeListBuilder.create().texOffs(1, -3).addBox(2.0F, -6.5F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0369F, 6.9712F, 7.7765F, -1.8669F, 1.4396F, -0.3712F));

		PartDefinition teeth_r9 = InnerRingDetail.addOrReplaceChild("teeth_r9", CubeListBuilder.create().texOffs(0, -3).addBox(1.0F, -6.0F, -0.25F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0173F, 5.2495F, 1.0744F, 0.55F, -1.2252F, -2.9284F));

		PartDefinition teeth_r10 = InnerRingDetail.addOrReplaceChild("teeth_r10", CubeListBuilder.create().texOffs(0, -3).addBox(-1.0F, -6.5F, -2.25F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.57F, -2.9472F, 2.1761F, 2.7599F, -1.3663F, 0.3153F));

		PartDefinition teeth_r11 = InnerRingDetail.addOrReplaceChild("teeth_r11", CubeListBuilder.create().texOffs(0, -3).addBox(-0.25F, -6.0F, -1.75F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -3.0F, 5.0F, 0.4732F, -1.1677F, 2.5546F));

		PartDefinition teeth_r12 = InnerRingDetail.addOrReplaceChild("teeth_r12", CubeListBuilder.create().texOffs(1, -3).addBox(2.0F, -6.5F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7869F, -8.2212F, 7.7765F, 1.8669F, 1.4396F, 0.6766F));

		PartDefinition teeth_r13 = InnerRingDetail.addOrReplaceChild("teeth_r13", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.5F, -1.5F, 0.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9132F, -8.2665F, 4.9307F, -1.7336F, 1.2985F, -2.9589F));

		PartDefinition teeth_r14 = InnerRingDetail.addOrReplaceChild("teeth_r14", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -7.0F, 5.0F, 0.4732F, 1.1677F, -2.5546F));

		PartDefinition teeth_r15 = InnerRingDetail.addOrReplaceChild("teeth_r15", CubeListBuilder.create().texOffs(1, -3).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.25F, -9.0F, 2.0F, -0.0151F, 1.1865F, -2.8938F));

		PartDefinition LargeTongue = InnerRaise.addOrReplaceChild("LargeTongue", CubeListBuilder.create().texOffs(391, 346).addBox(-5.0F, -1.5F, -7.0F, 7.0F, 2.0F, 9.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(4.0058F, 3.4446F, 8.8412F, 0.2608F, -0.0226F, -0.3084F));

		PartDefinition LargeTongueS2 = LargeTongue.addOrReplaceChild("LargeTongueS2", CubeListBuilder.create().texOffs(393, 348).addBox(-4.0F, -1.0F, -6.0F, 6.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -7.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition LargeTongueS3 = LargeTongueS2.addOrReplaceChild("LargeTongueS3", CubeListBuilder.create().texOffs(394, 348).addBox(-3.5F, -1.0F, -6.0F, 5.0F, 2.0F, 7.0F, new CubeDeformation(-0.24F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LargeTongueS4 = LargeTongueS3.addOrReplaceChild("LargeTongueS4", CubeListBuilder.create().texOffs(394, 348).addBox(-2.0F, -0.5F, -6.5F, 3.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0647F, -5.7585F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LargeTongue2 = InnerRaise.addOrReplaceChild("LargeTongue2", CubeListBuilder.create().texOffs(388, 344).addBox(-5.0F, -2.0F, -9.0F, 10.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1722F, -1.1647F, 11.6858F, 0.3719F, -0.0037F, 1.8845F));

		PartDefinition LargeTongueS5 = LargeTongue2.addOrReplaceChild("LargeTongueS5", CubeListBuilder.create().texOffs(391, 346).addBox(-3.5F, -1.0F, -8.0F, 8.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -9.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition LargeTongueS6 = LargeTongueS5.addOrReplaceChild("LargeTongueS6", CubeListBuilder.create().texOffs(391, 346).addBox(-2.5F, -1.0F, -8.0F, 6.0F, 2.0F, 9.0F, new CubeDeformation(-0.24F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition LargeTongueS7 = LargeTongueS6.addOrReplaceChild("LargeTongueS7", CubeListBuilder.create().texOffs(393, 346).addBox(-1.0F, -0.5F, -8.5F, 3.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.0647F, -7.7585F, 0.3491F, 0.0F, 0.0F));

		PartDefinition LargeTongue3 = InnerRaise.addOrReplaceChild("LargeTongue3", CubeListBuilder.create().texOffs(386, 342).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8278F, -2.1647F, 11.6858F, 0.1825F, -0.2405F, -2.2731F));

		PartDefinition LargeTongueS8 = LargeTongue3.addOrReplaceChild("LargeTongueS8", CubeListBuilder.create().texOffs(389, 344).addBox(-3.5F, -1.0F, -10.0F, 8.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -11.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LargeTongueS9 = LargeTongueS8.addOrReplaceChild("LargeTongueS9", CubeListBuilder.create().texOffs(390, 344).addBox(-2.5F, -1.0F, -10.0F, 6.0F, 2.0F, 11.0F, new CubeDeformation(-0.24F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LargeTongueS10 = LargeTongueS9.addOrReplaceChild("LargeTongueS10", CubeListBuilder.create().texOffs(392, 344).addBox(-1.0F, -0.5F, -10.5F, 3.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 0.0647F, -9.7585F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Outer = TrueHead.addOrReplaceChild("Outer", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition OuterRingBase = Outer.addOrReplaceChild("OuterRingBase", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition Rim = OuterRingBase.addOrReplaceChild("Rim", CubeListBuilder.create(), PartPose.offset(-17.3889F, -10.5693F, 0.2138F));

		PartDefinition Base_r7 = Rim.addOrReplaceChild("Base_r7", CubeListBuilder.create().texOffs(238, 58).addBox(5.0F, -5.0F, -1.0F, 9.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0046F, -0.0027F, -1.4838F));

		PartDefinition Base_r8 = Rim.addOrReplaceChild("Base_r8", CubeListBuilder.create().texOffs(350, 358).addBox(-2.0F, -8.0F, -1.0F, 19.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1119F, 11.9945F, -0.0151F, -0.0053F, -0.0008F, -1.0912F));

		PartDefinition Base_r9 = Rim.addOrReplaceChild("Base_r9", CubeListBuilder.create().texOffs(138, 402).addBox(-6.0F, -21.0F, -1.0F, 2.0F, 22.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3652F, 27.0277F, -0.0853F, -0.0044F, 0.003F, -0.3494F));

		PartDefinition Base_r10 = Rim.addOrReplaceChild("Base_r10", CubeListBuilder.create().texOffs(380, 165).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0235F, 24.4363F, -0.1189F, -0.0041F, 0.0034F, -0.2621F));

		PartDefinition Base_r11 = Rim.addOrReplaceChild("Base_r11", CubeListBuilder.create().texOffs(124, 327).addBox(-19.0F, -3.0F, -1.0F, 24.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.917F, 32.9445F, -0.2138F, -0.001F, 0.0052F, 0.436F));

		PartDefinition Base_r12 = Rim.addOrReplaceChild("Base_r12", CubeListBuilder.create().texOffs(232, 404).addBox(2.0F, -4.0F, -1.0F, 2.0F, 20.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.13F, 18.3896F, -0.2138F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Base_r13 = Rim.addOrReplaceChild("Base_r13", CubeListBuilder.create().texOffs(322, 382).addBox(3.0F, -8.0F, -1.0F, 2.0F, 29.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.3889F, -2.4307F, -0.2138F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Base_r14 = Rim.addOrReplaceChild("Base_r14", CubeListBuilder.create().texOffs(258, 330).addBox(-1.0F, -1.0F, -1.0F, 24.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.3889F, -18.4307F, -0.2138F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Base_r15 = Rim.addOrReplaceChild("Base_r15", CubeListBuilder.create().texOffs(352, 312).addBox(-4.0F, -1.0F, -1.0F, 21.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.521F, -14.9773F, 0.0163F, -0.004F, 0.0035F, -0.2185F));

		PartDefinition Raised = OuterRingBase.addOrReplaceChild("Raised", CubeListBuilder.create(), PartPose.offset(-19.5569F, -20.297F, -0.7467F));

		PartDefinition Raised_r8 = Raised.addOrReplaceChild("Raised_r8", CubeListBuilder.create().texOffs(376, 250).addBox(-4.5F, -2.0F, 0.0F, 10.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3933F, 0.1587F, -1.4172F));

		PartDefinition Raised_r9 = Raised.addOrReplaceChild("Raised_r9", CubeListBuilder.create().texOffs(308, 255).addBox(-9.5F, -2.0F, 0.0F, 19.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8101F, 12.2967F, -0.0173F, 0.4311F, -0.0008F, -1.0912F));

		PartDefinition Raised_r10 = Raised.addOrReplaceChild("Raised_r10", CubeListBuilder.create().texOffs(52, 356).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 22.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6526F, 28.7259F, -0.0689F, -0.0047F, -0.3897F, -0.3476F));

		PartDefinition Raised_r11 = Raised.addOrReplaceChild("Raised_r11", CubeListBuilder.create().texOffs(192, 345).addBox(-8.0F, 0.0F, 0.0F, 16.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1672F, 35.009F, -0.1307F, -0.3095F, 0.0034F, -0.2621F));

		PartDefinition Raised_r12 = Raised.addOrReplaceChild("Raised_r12", CubeListBuilder.create().texOffs(276, 89).addBox(-12.0F, 0.0F, 0.0F, 24.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.0026F, 36.9935F, -0.2138F, -0.4373F, 0.0052F, 0.436F));

		PartDefinition Raised_r13 = Raised.addOrReplaceChild("Raised_r13", CubeListBuilder.create().texOffs(168, 362).addBox(0.0F, -11.0F, 0.0F, 2.0F, 21.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.9733F, 33.9991F, -0.2533F, 0.0F, 0.2618F, 0.6981F));

		PartDefinition Raised_r14 = Raised.addOrReplaceChild("Raised_r14", CubeListBuilder.create().texOffs(80, 157).addBox(0.0F, -14.5F, 0.0F, 2.0F, 31.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(41.3796F, 13.3498F, -0.2533F, 0.0F, 0.3927F, -0.1309F));

		PartDefinition Raised_r15 = Raised.addOrReplaceChild("Raised_r15", CubeListBuilder.create().texOffs(286, 191).addBox(-12.0F, -2.0F, 0.0F, 24.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.5515F, -4.0011F, -0.2533F, 0.3927F, 0.0F, 0.3491F));

		PartDefinition Raised_r16 = Raised.addOrReplaceChild("Raised_r16", CubeListBuilder.create().texOffs(286, 238).addBox(-10.5177F, -2.0198F, -0.0001F, 21.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2684F, -5.67F, -0.0502F, 0.3887F, 0.0035F, -0.2185F));

		PartDefinition Internal = OuterRingBase.addOrReplaceChild("Internal", CubeListBuilder.create(), PartPose.offset(-17.3889F, -10.5693F, 0.2138F));

		PartDefinition In_r1 = Internal.addOrReplaceChild("In_r1", CubeListBuilder.create().texOffs(364, 272).addBox(-8.5F, -1.0F, 0.0F, 11.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1278F, -13.2359F, 2.8005F, -1.2813F, -0.044F, -1.2561F));

		PartDefinition In_r2 = Internal.addOrReplaceChild("In_r2", CubeListBuilder.create().texOffs(314, 167).addBox(-9.5F, -2.0F, -0.5F, 19.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9759F, 2.5706F, -0.4779F, -1.0525F, -0.0008F, -1.0912F));

		PartDefinition In_r3 = Internal.addOrReplaceChild("In_r3", CubeListBuilder.create().texOffs(494, 324).addBox(-0.5F, -5.0F, -0.5F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(66, 493).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(476, 491).addBox(-0.5F, 2.0F, 0.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8269F, 16.2467F, 6.3999F, -0.0344F, 1.4428F, -0.3835F));

		PartDefinition In_r4 = Internal.addOrReplaceChild("In_r4", CubeListBuilder.create().texOffs(164, 398).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8206F, 18.9982F, -1.0294F, -0.0068F, 0.8756F, -0.3546F));

		PartDefinition In_r5 = Internal.addOrReplaceChild("In_r5", CubeListBuilder.create().texOffs(492, 482).addBox(0.0F, 0.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0244F, 20.4233F, 1.8543F, 0.7863F, -0.2817F, 0.0116F));

		PartDefinition In_r6 = Internal.addOrReplaceChild("In_r6", CubeListBuilder.create().texOffs(370, 153).addBox(-15.0F, -1.0F, -0.75F, 17.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0235F, 24.4363F, -0.1189F, 0.8249F, 0.0034F, -0.2621F));

		PartDefinition In_r7 = Internal.addOrReplaceChild("In_r7", CubeListBuilder.create().texOffs(112, 229).addBox(-9.0F, 0.0F, 0.0F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(358, 250).addBox(-4.0F, 0.0F, 0.0F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5823F, 21.4631F, 6.4924F, 1.5262F, 0.0052F, 0.436F));

		PartDefinition In_r8 = Internal.addOrReplaceChild("In_r8", CubeListBuilder.create().texOffs(350, 0).addBox(-12.0F, 0.0F, 0.0F, 22.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.8346F, 27.2659F, -1.1743F, 0.6971F, 0.0052F, 0.436F));

		PartDefinition In_r9 = Internal.addOrReplaceChild("In_r9", CubeListBuilder.create().texOffs(202, 362).addBox(0.0F, -11.25F, 0.0F, 2.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.8053F, 24.2715F, -1.2138F, 0.0F, -1.0472F, 0.6981F));

		PartDefinition In_r10 = Internal.addOrReplaceChild("In_r10", CubeListBuilder.create().texOffs(74, 396).addBox(0.0F, -8.0F, -1.0F, 2.0F, 27.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.3632F, -2.8223F, -0.2138F, 0.0F, -0.5672F, -0.1309F));

		PartDefinition In_r11 = Internal.addOrReplaceChild("In_r11", CubeListBuilder.create().texOffs(326, 330).addBox(-1.0F, -1.0F, -1.0F, 24.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.3889F, -18.4307F, -0.2138F, -0.7854F, 0.0F, 0.3491F));

		PartDefinition In_r12 = Internal.addOrReplaceChild("In_r12", CubeListBuilder.create().texOffs(354, 89).addBox(-4.0F, -1.0F, -1.0F, 21.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.521F, -14.9773F, 0.0163F, -0.6585F, 0.0035F, -0.2185F));

		PartDefinition OuterRingDetails = Outer.addOrReplaceChild("OuterRingDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body1 = OuterRingDetails.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offset(0.0F, -28.0F, 0.0F));

		PartDefinition Arm_r1 = Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(1, 1009).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -3.0F, 2.0F, 0.4516F, -0.0542F, -0.232F));

		PartDefinition Arm_r2 = Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, 2.0F, 0.3715F, -0.3215F, -0.1384F));

		PartDefinition LowerTorso_r1 = Body1.addOrReplaceChild("LowerTorso_r1", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.5F, -2.0F, -1.25F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0822F, -6.063F, 5.9241F, 0.054F, 0.2846F, 0.0982F));

		PartDefinition Torso_r1 = Body1.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.5F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r16 = Body1.addOrReplaceChild("Teeth_r16", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 983).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body2 = OuterRingDetails.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.7466F, -4.4881F, 2.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Head_r1 = Body2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(64, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5303F, -2.6517F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body3 = OuterRingDetails.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Arm_r3 = Body3.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -25.0F, 2.0F, 0.2851F, -0.6819F, -0.3183F));

		PartDefinition Torso_r2 = Body3.addOrReplaceChild("Torso_r2", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, 1.5F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r17 = Body3.addOrReplaceChild("Teeth_r17", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 984).mirror().addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.5303F, -2.6517F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body4 = OuterRingDetails.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0302F, -5.7214F, 2.9014F, 0.0873F, 0.0F, 0.9599F));

		PartDefinition Arm_r4 = Body4.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(1, 1009).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -26.0F, 2.0F, 0.0507F, 0.7822F, 0.2963F));

		PartDefinition Arm_r5 = Body4.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -26.0F, 2.0F, 0.3715F, -0.3215F, -0.1384F));

		PartDefinition LowerTorso_r2 = Body4.addOrReplaceChild("LowerTorso_r2", CubeListBuilder.create().texOffs(1, 1009).addBox(-5.5F, -2.0F, 0.75F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.052F, -28.3416F, 3.0227F, 0.054F, 0.2846F, 0.0982F));

		PartDefinition Torso_r3 = Body4.addOrReplaceChild("Torso_r3", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, 1.5F, 0.405F, -0.237F, 0.0942F));

		PartDefinition Teeth_r18 = Body4.addOrReplaceChild("Teeth_r18", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 984).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, 0.0F, 0.0387F, -0.0201F, 0.4796F));

		PartDefinition Body5 = OuterRingDetails.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0302F, -5.7214F, 2.9014F, 0.0693F, -0.0531F, 1.6126F));

		PartDefinition Torso_r4 = Body5.addOrReplaceChild("Torso_r4", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -1.5F, -2.75F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, 1.5F, 0.405F, -0.237F, 0.0942F));

		PartDefinition Teeth_r19 = Body5.addOrReplaceChild("Teeth_r19", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -1.5F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 984).mirror().addBox(-4.0F, -7.5F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -23.0F, 0.0F, 1.0907F, -0.0038F, 0.0872F));

		PartDefinition Body6 = OuterRingDetails.addOrReplaceChild("Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.6252F, -4.3095F, 0.0F, 0.0F, 0.0F, 2.0071F));

		PartDefinition Arm_r6 = Body6.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -25.0F, 2.0F, 0.1841F, 0.1294F, -0.1413F));

		PartDefinition Torso_r5 = Body6.addOrReplaceChild("Torso_r5", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, 1.5F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r20 = Body6.addOrReplaceChild("Teeth_r20", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5303F, -2.6517F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body7 = OuterRingDetails.addOrReplaceChild("Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(2.2735F, -1.5604F, 0.0F, 0.0F, 0.0F, 2.3126F));

		PartDefinition Arm_r7 = Body7.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(1, 1009).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -26.0F, 2.0F, 0.6616F, 0.7822F, 0.2963F));

		PartDefinition Arm_r8 = Body7.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -26.0F, 2.0F, 0.3563F, -0.1583F, -0.0745F));

		PartDefinition LowerTorso_r3 = Body7.addOrReplaceChild("LowerTorso_r3", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.5F, -2.0F, -1.25F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0822F, -29.063F, 5.9241F, 0.054F, 0.2846F, 0.0982F));

		PartDefinition Torso_r6 = Body7.addOrReplaceChild("Torso_r6", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, 1.5F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r21 = Body7.addOrReplaceChild("Teeth_r21", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 968).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body8 = OuterRingDetails.addOrReplaceChild("Body8", CubeListBuilder.create(), PartPose.offsetAndRotation(5.2941F, -2.7266F, 2.0F, 0.0F, 0.0F, 2.8362F));

		PartDefinition Head_r2 = Body8.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(64, 984).mirror().addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -22.5303F, -2.6517F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body9 = OuterRingDetails.addOrReplaceChild("Body9", CubeListBuilder.create(), PartPose.offsetAndRotation(6.1772F, 19.8742F, 1.712F, -0.48F, 0.0F, -2.7925F));

		PartDefinition Arm_r9 = Body9.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3459F, -4.5694F, -0.2766F, 0.4543F, -1.0499F, -0.5363F));

		PartDefinition Torso_r7 = Body9.addOrReplaceChild("Torso_r7", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, -5.5694F, -0.7766F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r22 = Body9.addOrReplaceChild("Teeth_r22", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, 1.9003F, -2.9282F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body10 = OuterRingDetails.addOrReplaceChild("Body10", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.3484F, 17.678F, 2.4245F, -0.3381F, 0.0886F, -2.5459F));

		PartDefinition Arm_r10 = Body10.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3459F, -0.5694F, 1.7234F, 0.2851F, -0.6819F, -0.3183F));

		PartDefinition Torso_r8 = Body10.addOrReplaceChild("Torso_r8", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, -1.5694F, 1.2234F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r23 = Body10.addOrReplaceChild("Teeth_r23", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, 1.9003F, -2.9282F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body11 = OuterRingDetails.addOrReplaceChild("Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.7176F, -11.9968F, 60.017F, 0.0F, 0.0F, -2.9234F));

		PartDefinition Arm_r11 = Body11.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.558F, -30.0397F, -57.017F, 0.1841F, 0.1294F, -0.1413F));

		PartDefinition Torso_r9 = Body11.addOrReplaceChild("Torso_r9", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.558F, -31.0397F, -57.517F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r24 = Body11.addOrReplaceChild("Teeth_r24", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.558F, -27.5701F, -61.6687F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body12 = OuterRingDetails.addOrReplaceChild("Body12", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.895F, 14.9246F, 1.0414F, -0.7418F, 0.0F, -2.618F));

		PartDefinition Torso_r10 = Body12.addOrReplaceChild("Torso_r10", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -7.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1443F, -2.1891F, 2.1075F, 1.0565F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r25 = Body12.addOrReplaceChild("Teeth_r25", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 968).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1443F, 1.8109F, 0.6075F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body13 = OuterRingDetails.addOrReplaceChild("Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.6238F, 11.703F, -0.5608F, 0.0F, 0.0F, -1.8762F));

		PartDefinition Teeth_r26 = Body13.addOrReplaceChild("Teeth_r26", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(64, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5952F, 3.0741F, -0.0908F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body14 = OuterRingDetails.addOrReplaceChild("Body14", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.7509F, -5.1903F, 2.5616F, 0.0F, 0.0F, -1.8326F));

		PartDefinition Arm_r12 = Body14.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(1, 1009).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0553F, -27.3404F, -0.5616F, 0.5768F, -0.0507F, 0.6083F));

		PartDefinition Arm_r13 = Body14.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(1, 1009).addBox(-3.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9447F, -27.3404F, -0.5616F, 0.3715F, -0.3215F, -0.1384F));

		PartDefinition Torso_r11 = Body14.addOrReplaceChild("Torso_r11", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0553F, -28.3404F, -1.0616F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r27 = Body14.addOrReplaceChild("Teeth_r27", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 983).mirror().addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0553F, -24.3404F, -2.5616F, 0.7854F, 0.0F, 0.0F));

		PartDefinition Body15 = OuterRingDetails.addOrReplaceChild("Body15", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.9756F, -6.5537F, 2.5616F, 0.0F, 0.0F, -1.309F));

		PartDefinition Arm_r14 = Body15.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(1, 1009).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7199F, -22.977F, 1.4384F, 0.5768F, -0.0507F, 0.6083F));

		PartDefinition Torso_r12 = Body15.addOrReplaceChild("Torso_r12", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -2.5F, -1.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7199F, -23.977F, 0.9384F, 0.4456F, 0.1974F, 0.0934F));

		PartDefinition Teeth_r28 = Body15.addOrReplaceChild("Teeth_r28", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 968).mirror().addBox(-4.0F, -6.75F, -2.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0375F, -18.5914F, -3.2132F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Body16 = OuterRingDetails.addOrReplaceChild("Body16", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.3412F, -13.7876F, 0.4313F, -0.5672F, 0.0F, -1.1781F));

		PartDefinition Torso_r13 = Body16.addOrReplaceChild("Torso_r13", CubeListBuilder.create().texOffs(1, 1009).addBox(-4.0F, -4.5F, 0.5F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, -1.5694F, 1.2234F, 1.1707F, 0.2638F, 0.3998F));

		PartDefinition Teeth_r29 = Body16.addOrReplaceChild("Teeth_r29", CubeListBuilder.create().texOffs(0, 1004).addBox(-4.0F, 0.25F, -2.5F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 984).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6541F, 1.9003F, -2.9282F, 0.4702F, 0.1001F, -0.1942F));

		PartDefinition Biomass = OuterRingDetails.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(-15.0797F, -27.0207F, 4.0841F));

		PartDefinition Biomass_r1 = Biomass.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(252, 276).addBox(-5.8526F, -5.3196F, -6.9215F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, -2.0F, 1.4107F, 0.6301F, 1.0617F));

		PartDefinition Biomass_r2 = Biomass.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(252, 276).addBox(-0.8893F, -4.7428F, -3.5661F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -2.0F, 0.6318F, -0.3548F, 0.5031F));

		PartDefinition FungalBloom = OuterRingDetails.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.8168F, -31.6174F, 3.4362F, 0.6485F, -0.3189F, -0.5387F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(0, 558).addBox(-11.8501F, -13.8001F, -7.6583F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 5.5803F, -7.8924F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(0, 557).addBox(-0.8501F, -13.8001F, 5.3417F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 5.5803F, -7.8924F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(-16, 524).addBox(-16.8501F, -0.8001F, -17.6583F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 5.5803F, -0.3924F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(-16, 511).addBox(-16.8501F, -0.8001F, 2.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 5.5803F, -0.3924F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(-16, 555).addBox(1.1499F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 5.5803F, -8.3924F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(-16, 539).addBox(-17.8501F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4967F, 4.5803F, -8.3924F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Teeth = OuterRingDetails.addOrReplaceChild("Teeth", CubeListBuilder.create(), PartPose.offset(-17.0523F, -6.3894F, 2.3538F));

		PartDefinition t_r1 = Teeth.addOrReplaceChild("t_r1", CubeListBuilder.create().texOffs(0, -4).addBox(2.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0941F, -18.3761F, -1.664F, 0.7264F, -1.2636F, 0.4739F));

		PartDefinition t_r2 = Teeth.addOrReplaceChild("t_r2", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, -6.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.312F, -13.9163F, 0.78F, 0.5253F, 0.5993F, -1.5362F));

		PartDefinition t_r3 = Teeth.addOrReplaceChild("t_r3", CubeListBuilder.create().texOffs(0, -2).addBox(1.0F, -6.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1966F, -9.8531F, 1.7807F, 0.3416F, 0.7103F, -1.836F));

		PartDefinition t_r4 = Teeth.addOrReplaceChild("t_r4", CubeListBuilder.create().texOffs(23, -5).addBox(0.0F, -7.5F, -2.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1734F, -9.8606F, 3.8521F, -0.0483F, 0.1629F, -2.6431F));

		PartDefinition t_r5 = Teeth.addOrReplaceChild("t_r5", CubeListBuilder.create().texOffs(0, -4).addBox(3.0153F, -0.994F, -3.5092F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.2843F, 4.4467F, -3.2326F, 0.0282F, -1.391F, 3.084F));

		PartDefinition t_r6 = Teeth.addOrReplaceChild("t_r6", CubeListBuilder.create().texOffs(23, -5).addBox(0.5047F, -6.2786F, -3.0491F, 0.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.4971F, -15.0265F, 0.3015F, -0.2253F, -0.5651F, 2.1665F));

		PartDefinition t_r7 = Teeth.addOrReplaceChild("t_r7", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -9.5F, -2.0F, 0.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.3905F, -15.0528F, 1.5427F, -0.0125F, -1.1606F, 1.7558F));

		PartDefinition t_r8 = Teeth.addOrReplaceChild("t_r8", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -9.0F, -4.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0178F, 12.6029F, 0.3954F, -0.2979F, -0.9583F, -2.2563F));

		PartDefinition t_r9 = Teeth.addOrReplaceChild("t_r9", CubeListBuilder.create().texOffs(0, -4).addBox(2.585F, -8.0883F, -3.9685F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.3906F, 12.8665F, 0.1298F, 0.4809F, -0.9945F, -3.0232F));

		PartDefinition t_r10 = Teeth.addOrReplaceChild("t_r10", CubeListBuilder.create().texOffs(23, -5).addBox(1.0F, -12.5F, -3.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.9907F, 14.6601F, -1.1661F, 0.6668F, -1.1623F, 3.1378F));

		PartDefinition t_r11 = Teeth.addOrReplaceChild("t_r11", CubeListBuilder.create().texOffs(0, -4).addBox(-1.2832F, 1.6868F, 0.3516F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 15.5957F, -0.9501F, 0.5084F, -1.2142F, -1.9009F));

		PartDefinition t_r12 = Teeth.addOrReplaceChild("t_r12", CubeListBuilder.create().texOffs(23, -5).addBox(-1.4437F, -2.127F, 0.9602F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 15.5957F, -0.9501F, -0.2115F, -1.4282F, -1.1357F));

		PartDefinition t_r13 = Teeth.addOrReplaceChild("t_r13", CubeListBuilder.create().texOffs(0, -2).addBox(3.3546F, -2.5132F, -1.3209F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 15.5957F, -0.9501F, 0.0282F, -1.391F, -1.4539F));

		PartDefinition t_r14 = Teeth.addOrReplaceChild("t_r14", CubeListBuilder.create().texOffs(0, -2).addBox(0.1506F, -6.8775F, -1.7368F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0037F, 15.1406F, -0.0792F, 0.6698F, -1.0401F, -2.8918F));

		PartDefinition t_r15 = Teeth.addOrReplaceChild("t_r15", CubeListBuilder.create().texOffs(23, -5).addBox(-3.0F, -5.5F, -1.5F, 0.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1931F, 15.7673F, -2.0586F, -0.1123F, -0.5946F, -1.8354F));

		PartDefinition t_r16 = Teeth.addOrReplaceChild("t_r16", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -5.0F, -2.75F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, 12.5348F, 2.0547F, -2.3755F, -1.4575F, 2.0867F));

		PartDefinition t_r17 = Teeth.addOrReplaceChild("t_r17", CubeListBuilder.create().texOffs(0, -1).addBox(-0.8494F, -3.8775F, -1.7368F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9963F, 12.1406F, -0.0792F, 0.5084F, -1.2142F, -0.8537F));

		PartDefinition t_r18 = Teeth.addOrReplaceChild("t_r18", CubeListBuilder.create().texOffs(23, -5).addBox(0.0F, -7.5F, -2.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8069F, 12.7673F, -2.0586F, -0.2115F, -1.4282F, -0.0885F));

		PartDefinition t_r19 = Teeth.addOrReplaceChild("t_r19", CubeListBuilder.create().texOffs(0, 0).addBox(1.25F, -7.0F, -3.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9446F, -1.3693F, -0.7078F, -0.1205F, -1.2586F, 0.5948F));

		PartDefinition t_r20 = Teeth.addOrReplaceChild("t_r20", CubeListBuilder.create().texOffs(23, -5).addBox(0.0F, -6.5F, -4.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8788F, -2.8637F, -1.1866F, 0.3296F, -0.9814F, -0.0968F));

		PartDefinition t_r21 = Teeth.addOrReplaceChild("t_r21", CubeListBuilder.create().texOffs(0, -4).addBox(0.0F, -10.25F, -3.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0593F, 3.2013F, 2.1114F, -0.1942F, -0.9634F, 0.7791F));

		PartDefinition Tongue = OuterRingDetails.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(394, 349).addBox(-2.5F, -0.5F, -7.0F, 5.0F, 1.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-12.1914F, 5.3702F, 6.789F, 0.0845F, 0.1704F, 0.736F));

		PartDefinition TongueSeg2 = Tongue.addOrReplaceChild("TongueSeg2", CubeListBuilder.create().texOffs(397, 350).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.75F, -0.4363F, 0.0F, 0.0F));

		PartDefinition TongueSeg3 = TongueSeg2.addOrReplaceChild("TongueSeg3", CubeListBuilder.create().texOffs(396, 350).addBox(-2.0F, -0.5F, -5.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.5F, 0.5236F, 0.0F, 0.0F));

		PartDefinition TongueSeg4 = TongueSeg3.addOrReplaceChild("TongueSeg4", CubeListBuilder.create().texOffs(397, 350).addBox(-1.5F, -0.5F, -5.0F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition TongueSeg5 = TongueSeg4.addOrReplaceChild("TongueSeg5", CubeListBuilder.create().texOffs(397, 350).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Body = hohl_head.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(9.0F, -3.0F, -54.0F));

		PartDefinition Front = Body.addOrReplaceChild("Front", CubeListBuilder.create(), PartPose.offset(-35.55F, 1.1285F, -2.9615F));

		PartDefinition Front_r1 = Front.addOrReplaceChild("Front_r1", CubeListBuilder.create().texOffs(0, 376).addBox(-0.5F, -27.5F, -5.5F, 4.0F, 27.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0334F, -0.3556F, 0.4522F));

		PartDefinition Front_r2 = Front.addOrReplaceChild("Front_r2", CubeListBuilder.create().texOffs(352, 24).addBox(-1.0F, -29.5F, -5.5F, 6.0F, 31.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2466F, 28.6742F, -1.004F, -0.0379F, -0.3797F, -0.1158F));

		PartDefinition Front_r3 = Front.addOrReplaceChild("Front_r3", CubeListBuilder.create().texOffs(158, 40).addBox(-40.0F, -5.0F, -5.5F, 41.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.134F, 35.8874F, 0.0661F, -0.5228F, -0.0189F, 0.1766F));

		PartDefinition Front_r4 = Front.addOrReplaceChild("Front_r4", CubeListBuilder.create().texOffs(414, 223).addBox(-2.5F, -1.25F, -5.5F, 5.0F, 10.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(52.634F, 33.1374F, 0.0661F, -0.0819F, 0.1334F, 1.0436F));

		PartDefinition Front_r5 = Front.addOrReplaceChild("Front_r5", CubeListBuilder.create().texOffs(350, 370).addBox(-2.5F, -0.5F, -5.5F, 5.0F, 27.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(66.6385F, 11.5074F, 3.5326F, -0.1342F, 0.0806F, 0.5637F));

		PartDefinition Front_r6 = Front.addOrReplaceChild("Front_r6", CubeListBuilder.create().texOffs(88, 356).addBox(-4.0F, 0.0F, -5.5F, 5.0F, 29.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(64.05F, -15.3212F, 3.7017F, 0.0F, 0.1309F, -0.1309F));

		PartDefinition Front_r7 = Front.addOrReplaceChild("Front_r7", CubeListBuilder.create().texOffs(192, 330).addBox(0.0F, 0.0F, 0.0F, 22.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(47.55F, -28.3212F, -1.7983F, 0.1409F, 0.107F, 0.7303F));

		PartDefinition Front_r8 = Front.addOrReplaceChild("Front_r8", CubeListBuilder.create().texOffs(276, 72).addBox(-22.0F, -1.0F, -1.0F, 33.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(36.55F, -27.1285F, -1.0385F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Middle = Body.addOrReplaceChild("Middle", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Middle_r1 = Middle.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(0, 228).addBox(-4.0F, -23.0F, -1.0F, 8.0F, 25.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.0489F, -13.3752F, -1.9858F, -0.2881F, -0.0653F, 1.0509F));

		PartDefinition Middle_r2 = Middle.addOrReplaceChild("Middle_r2", CubeListBuilder.create().texOffs(212, 191).addBox(-6.0F, -15.0F, -7.0F, 8.0F, 42.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-33.0489F, 1.6248F, 4.0142F, 0.0F, -0.3054F, 0.0F));

		PartDefinition Middle_r3 = Middle.addOrReplaceChild("Middle_r3", CubeListBuilder.create().texOffs(134, 145).addBox(-0.5F, -1.0F, -1.0F, 6.0F, 54.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.6105F, 40.9546F, -3.6401F, -0.0275F, -0.0437F, 1.9267F));

		PartDefinition Middle_r4 = Middle.addOrReplaceChild("Middle_r4", CubeListBuilder.create().texOffs(144, 70).addBox(0.0F, -0.5F, 0.0F, 33.0F, 7.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.6592F, 17.1755F, -1.8515F, 0.0024F, 0.0914F, 2.2298F));

		PartDefinition Middle_r5 = Middle.addOrReplaceChild("Middle_r5", CubeListBuilder.create().texOffs(0, 110).addBox(0.0F, -0.5F, 0.0F, 27.0F, 7.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.8613F, -8.9463F, 3.0095F, -0.103F, 0.181F, 1.3891F));

		PartDefinition Middle_r6 = Middle.addOrReplaceChild("Middle_r6", CubeListBuilder.create().texOffs(154, 0).addBox(-2.0F, -0.5F, 0.0F, 21.0F, 7.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0881F, -25.6554F, 5.2093F, -0.0607F, 0.116F, 1.0873F));

		PartDefinition Middle_r7 = Middle.addOrReplaceChild("Middle_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-22.0F, -3.0F, -1.0F, 44.0F, 8.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 6.0F, 0.0001F, 0.0057F, 0.0433F));

		PartDefinition MiddleDetails = Middle.addOrReplaceChild("MiddleDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RidgeBodies = MiddleDetails.addOrReplaceChild("RidgeBodies", CubeListBuilder.create(), PartPose.offset(0.0F, 32.0F, 13.0F));

		PartDefinition Body17 = RidgeBodies.addOrReplaceChild("Body17", CubeListBuilder.create(), PartPose.offsetAndRotation(2.553F, -59.854F, 26.0477F, -0.195F, -0.4891F, 0.1361F));

		PartDefinition Leg_r1 = Body17.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(0, 1018).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.018F));

		PartDefinition Arm_r15 = Body17.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(0, 1018).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -1.2271F, 2.7196F, -0.0232F, -0.8265F, 0.733F));

		PartDefinition Arm_r16 = Body17.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(0, 1018).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, 1.3726F, -6.7458F, -0.2001F, 0.1744F, -0.0891F));

		PartDefinition TorsoBase_r1 = Body17.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(0, 1014).addBox(-3.25F, 0.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.2494F, -0.4119F, 0.2485F));

		PartDefinition TorsoTop_r1 = Body17.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(0, 1012).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1008).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 3.6966F, 0.4933F, -0.0177F, -0.4775F, 0.724F));

		PartDefinition Jaw_r1 = Body17.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 1008).addBox(-2.002F, -6.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, 1.6169F, -2.47F, -0.1237F, -0.3749F, 0.9561F));

		PartDefinition Body18 = RidgeBodies.addOrReplaceChild("Body18", CubeListBuilder.create().texOffs(0, 1011).addBox(-2.4218F, -0.7079F, -3.1266F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.9657F, -57.7848F, 26.4765F, 0.2138F, 0.9005F, 1.3737F));

		PartDefinition Leg_r2 = Body18.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5814F, 4.771F, -1.197F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r3 = Body18.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(0, 1015).addBox(0.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9505F, 4.9908F, 2.3734F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r17 = Body18.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(0, 1014).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8068F, -6.4923F, -2.9503F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r3 = Body18.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(0, 1009).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7451F, -8.6475F, 3.1328F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r2 = Body18.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(0, 1009).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4218F, -0.7079F, 0.6234F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Body19 = RidgeBodies.addOrReplaceChild("Body19", CubeListBuilder.create(), PartPose.offsetAndRotation(22.3847F, -44.327F, 28.1902F, -0.9298F, 0.5454F, -0.5668F));

		PartDefinition Leg_r4 = Body19.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(0, 1011).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r2 = Body19.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9599F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r18 = Body19.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r19 = Body19.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r1 = Body19.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r4 = Body19.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(0, 1009).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition Body20 = RidgeBodies.addOrReplaceChild("Body20", CubeListBuilder.create().texOffs(0, 1015).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.6017F, -22.8754F, 29.2786F, 2.185F, 1.4135F, 0.2664F));

		PartDefinition Leg_r5 = Body20.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(0, 1018).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r5 = Body20.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(0, 1009).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r20 = Body20.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(0, 1012).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r3 = Body20.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(0, 1014).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition Body21 = RidgeBodies.addOrReplaceChild("Body21", CubeListBuilder.create(), PartPose.offsetAndRotation(28.7644F, -13.0768F, 26.452F, 0.0F, 0.6109F, 2.3126F));

		PartDefinition TorsoBase_r3 = Body21.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(0, 1013).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r4 = Body21.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(0, 1018).addBox(-8.8585F, -2.3037F, -4.0214F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r5 = Body21.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(0, 1011).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r6 = Body21.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(0, 1008).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body22 = RidgeBodies.addOrReplaceChild("Body22", CubeListBuilder.create(), PartPose.offsetAndRotation(23.8647F, 2.4207F, 16.249F, -2.9278F, 0.1899F, 2.5014F));

		PartDefinition Leg_r6 = Body22.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(0, 1011).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8803F, -6.5243F, -1.2902F, -1.5761F, 0.989F, -0.4866F));

		PartDefinition TorsoBase_r4 = Body22.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4499F, -0.7882F, -0.449F, -1.4198F, 0.213F, 0.1614F));

		PartDefinition Arm_r21 = Body22.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.081F, -1.1697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r22 = Body22.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(0, 1015).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4173F, 4.1598F, 0.1325F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r2 = Body22.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body23 = RidgeBodies.addOrReplaceChild("Body23", CubeListBuilder.create(), PartPose.offsetAndRotation(11.5363F, 7.495F, 17.3077F, -1.6402F, 0.5268F, 1.9038F));

		PartDefinition TorsoBase_r5 = Body23.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r23 = Body23.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r24 = Body23.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(0, 1013).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r6 = Body23.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r7 = Body23.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(0, 1009).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.4599F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition Body24 = RidgeBodies.addOrReplaceChild("Body24", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6325F, 5.5335F, 10.1647F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Arm_r25 = Body24.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.6609F, 0.5587F, -1.5066F));

		PartDefinition TorsoBase_r6 = Body24.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -0.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, 2.2954F, -1.5655F, -0.1556F, -0.0458F));

		PartDefinition TorsoTop_r7 = Body24.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r8 = Body24.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(0, 1008).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Body25 = RidgeBodies.addOrReplaceChild("Body25", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -1.0551F, 4.5164F, 1.7453F, 0.0F, 0.0F));

		PartDefinition Leg_r7 = Body25.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(0, 1011).addBox(-4.5F, -1.5F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2102F, -6.6181F, 3.1711F, -1.3444F, -1.2748F, 2.6415F));

		PartDefinition Leg_r8 = Body25.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(0, 1011).addBox(-2.664F, -8.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -4.5592F, 3.5018F, 1.6627F, -0.395F, 1.2947F));

		PartDefinition TorsoBase_r7 = Body25.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -3.7363F, 1.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r26 = Body25.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.919F, -2.6698F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, 0.9938F, -2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r27 = Body25.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(0, 1013).addBox(1.0019F, -2.9253F, -1.1122F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoBottom_r3 = Body25.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r9 = Body25.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(0, 1009).addBox(-3.5F, -3.25F, 0.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition Body26 = RidgeBodies.addOrReplaceChild("Body26", CubeListBuilder.create(), PartPose.offsetAndRotation(-38.3842F, -4.1732F, -0.0048F, 1.9167F, -0.9835F, 2.4813F));

		PartDefinition Leg_r9 = Body26.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(0, 1011).addBox(-1.5F, -5.0F, -2.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -1.1484F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r8 = Body26.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9599F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r28 = Body26.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r29 = Body26.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(0, 1013).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.3921F, 0.7708F, -0.0005F));

		PartDefinition TorsoTop_r8 = Body26.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8747F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body27 = RidgeBodies.addOrReplaceChild("Body27", CubeListBuilder.create(), PartPose.offsetAndRotation(-43.9258F, -12.9791F, 9.3991F, 1.39F, 0.833F, 1.9657F));

		PartDefinition Leg_r10 = Body27.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(0, 1011).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2885F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r9 = Body27.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r30 = Body27.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r9 = Body27.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(0, 1014).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition Body28 = RidgeBodies.addOrReplaceChild("Body28", CubeListBuilder.create(), PartPose.offsetAndRotation(-40.8657F, -29.6568F, 11.4909F, 0.1745F, 0.0F, 1.1345F));

		PartDefinition TorsoBase_r10 = Body28.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(0, 1013).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.2739F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r4 = Body28.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(0, 1018).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r5 = Body28.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(0, 1011).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r10 = Body28.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(0, 1008).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition Body29 = RidgeBodies.addOrReplaceChild("Body29", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.3903F, -44.8416F, 17.3401F, -2.7162F, -0.4724F, 0.4029F));

		PartDefinition Leg_r11 = Body29.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(0, 1011).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r11 = Body29.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(0, 1015).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7363F, 2.2954F, 0.9905F, 0.1921F, 0.1438F));

		PartDefinition Arm_r31 = Body29.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(0, 1013).addBox(-1.919F, -0.6698F, 1.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r6 = Body29.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(0, 1014).addBox(-4.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition ArmoredTumors2 = MiddleDetails.addOrReplaceChild("ArmoredTumors2", CubeListBuilder.create(), PartPose.offset(43.0F, 0.0F, 0.0F));

		PartDefinition tumor_r1 = ArmoredTumors2.addOrReplaceChild("tumor_r1", CubeListBuilder.create().texOffs(261, 274).addBox(-4.0F, -4.0F, -15.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.1962F, -3.2598F, 20.3071F, 0.1949F, 0.0264F, -0.2729F));

		PartDefinition tumor_r2 = ArmoredTumors2.addOrReplaceChild("tumor_r2", CubeListBuilder.create().texOffs(261, 274).addBox(-6.5F, -3.5F, 6.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.8097F, -11.5F, 13.4567F, -0.5414F, -0.4388F, -0.6304F));

		PartDefinition tumor_r3 = ArmoredTumors2.addOrReplaceChild("tumor_r3", CubeListBuilder.create().texOffs(261, 274).addBox(-5.5F, -4.5F, -4.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.8097F, -11.5F, 13.4567F, 0.0799F, 0.1914F, -0.6178F));

		PartDefinition tumor_r4 = ArmoredTumors2.addOrReplaceChild("tumor_r4", CubeListBuilder.create().texOffs(261, 274).addBox(-7.0F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5F, -4.5F, 12.5F, 0.0F, 0.3927F, 0.0F));

		PartDefinition armor = ArmoredTumors2.addOrReplaceChild("armor", CubeListBuilder.create().texOffs(0, 936).addBox(-4.222F, -7.6143F, -14.1814F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 938).addBox(-0.972F, -6.1143F, -9.6814F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 938).addBox(-4.972F, -5.6143F, -14.6814F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3874F, -2.8349F, 17.6116F, 0.0F, 0.4363F, 0.0F));

		PartDefinition plate_r1 = armor.addOrReplaceChild("plate_r1", CubeListBuilder.create().texOffs(0, 944).addBox(-3.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.722F, -6.8643F, -3.1814F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Plate_r2 = armor.addOrReplaceChild("Plate_r2", CubeListBuilder.create().texOffs(0, 943).addBox(-1.3274F, -4.4321F, 0.2526F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3482F, -0.1431F, -0.6716F));

		PartDefinition Plate_r3 = armor.addOrReplaceChild("Plate_r3", CubeListBuilder.create().texOffs(0, 942).addBox(-1.2012F, -0.1088F, -2.4572F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3744F, -0.5704F, -0.6475F));

		PartDefinition Plate_r4 = armor.addOrReplaceChild("Plate_r4", CubeListBuilder.create().texOffs(0, 938).addBox(-2.5816F, -1.8307F, -0.4974F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3195F, -0.2005F, -0.5042F));

		PartDefinition ArmoredTumors3 = MiddleDetails.addOrReplaceChild("ArmoredTumors3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.8813F, 42.0181F, 11.0158F, 0.0F, 0.0F, 2.138F));

		PartDefinition tumor_r5 = ArmoredTumors3.addOrReplaceChild("tumor_r5", CubeListBuilder.create().texOffs(247, 280).addBox(-4.0F, -4.0F, -15.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1936F, 1.7109F, 6.2913F, 0.1949F, 0.0264F, -0.2729F));

		PartDefinition tumor_r6 = ArmoredTumors3.addOrReplaceChild("tumor_r6", CubeListBuilder.create().texOffs(247, 280).addBox(-6.5F, -5.5F, 2.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1929F, -6.5293F, -0.559F, -0.5414F, -0.4388F, -0.6304F));

		PartDefinition tumor_r7 = ArmoredTumors3.addOrReplaceChild("tumor_r7", CubeListBuilder.create().texOffs(247, 280).addBox(-5.5F, -4.5F, -4.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1929F, -6.5293F, -0.559F, 0.0799F, 0.1914F, -0.6178F));

		PartDefinition tumor_r8 = ArmoredTumors3.addOrReplaceChild("tumor_r8", CubeListBuilder.create().texOffs(247, 280).addBox(-8.0F, -4.5F, -4.5F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5026F, 0.4707F, -1.5157F, 0.0F, 0.3927F, 0.0F));

		PartDefinition armor2 = ArmoredTumors3.addOrReplaceChild("armor2", CubeListBuilder.create().texOffs(0, 938).addBox(-1.472F, 0.8857F, -9.6814F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 938).addBox(-4.972F, -4.6143F, -4.6814F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6151F, 2.1357F, 3.5958F, 0.0F, 0.4363F, 0.0F));

		PartDefinition plate_r5 = armor2.addOrReplaceChild("plate_r5", CubeListBuilder.create().texOffs(0, 944).addBox(-3.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.722F, -6.8643F, -3.1814F, 0.0F, 0.0F, -0.0436F));

		PartDefinition plate_r6 = armor2.addOrReplaceChild("plate_r6", CubeListBuilder.create().texOffs(0, 936).addBox(-2.0F, 3.0F, -5.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.222F, -6.6143F, -9.1814F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Plate_r7 = armor2.addOrReplaceChild("Plate_r7", CubeListBuilder.create().texOffs(0, 943).addBox(-1.3274F, -4.4321F, 0.2526F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3482F, -0.1431F, -0.6716F));

		PartDefinition Plate_r8 = armor2.addOrReplaceChild("Plate_r8", CubeListBuilder.create().texOffs(0, 940).addBox(-2.2012F, -0.1088F, -2.4572F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3744F, -0.5704F, -0.6475F));

		PartDefinition Plate_r9 = armor2.addOrReplaceChild("Plate_r9", CubeListBuilder.create().texOffs(0, 938).addBox(-2.5816F, -1.8307F, -0.4974F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5009F, -10.0972F, -6.556F, 0.3195F, -0.2005F, -0.5042F));

		PartDefinition ArmoredTumors4 = MiddleDetails.addOrReplaceChild("ArmoredTumors4", CubeListBuilder.create(), PartPose.offsetAndRotation(-39.746F, 5.9707F, 8.2814F, 0.0F, -0.1745F, 0.0F));

		PartDefinition tumor_r9 = ArmoredTumors4.addOrReplaceChild("tumor_r9", CubeListBuilder.create().texOffs(267, 282).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1936F, -1.7109F, -6.2913F, 0.1949F, 0.0264F, -0.2729F));

		PartDefinition tumor_r10 = ArmoredTumors4.addOrReplaceChild("tumor_r10", CubeListBuilder.create().texOffs(267, 282).addBox(4.5F, -9.5F, -8.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1929F, 6.5293F, 0.559F, -0.5414F, -0.4388F, -0.6304F));

		PartDefinition tumor_r11 = ArmoredTumors4.addOrReplaceChild("tumor_r11", CubeListBuilder.create().texOffs(267, 282).addBox(-1.4403F, -3.1423F, -1.8102F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.907F, 7.2183F, 3.0045F, 0.6329F, 0.2969F, -0.0303F));

		PartDefinition tumor_r12 = ArmoredTumors4.addOrReplaceChild("tumor_r12", CubeListBuilder.create().texOffs(267, 282).addBox(-2.0F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5026F, -0.4707F, 1.5157F, 0.0F, 0.3927F, 0.0F));

		PartDefinition armor3 = ArmoredTumors4.addOrReplaceChild("armor3", CubeListBuilder.create().texOffs(0, 936).addBox(0.222F, -4.2842F, 2.1975F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 938).addBox(-1.028F, 4.1144F, 1.6814F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 938).addBox(-0.028F, -2.2842F, 1.6975F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6151F, -2.1358F, -3.5958F, 0.0F, 0.4363F, 0.0F));

		PartDefinition plate_r10 = armor3.addOrReplaceChild("plate_r10", CubeListBuilder.create().texOffs(0, 944).addBox(-1.5021F, 4.1009F, -2.7481F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5016F, 1.7683F, 4.9295F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Plate_r11 = armor3.addOrReplaceChild("Plate_r11", CubeListBuilder.create().texOffs(0, 943).addBox(-2.7825F, 0.727F, -2.1803F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1965F, 9.354F, 9.2396F, 0.5845F, 0.1016F, -0.1037F));

		PartDefinition Plate_r12 = armor3.addOrReplaceChild("Plate_r12", CubeListBuilder.create().texOffs(0, 942).addBox(-2.8941F, -4.3929F, 0.9892F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1965F, 9.354F, 9.2396F, 0.6283F, -0.3186F, -0.1852F));

		PartDefinition Plate_r13 = armor3.addOrReplaceChild("Plate_r13", CubeListBuilder.create().texOffs(0, 938).addBox(-2.6339F, -5.6709F, -2.4303F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1965F, 9.354F, 9.2396F, 0.5922F, 0.0046F, 0.0416F));

		PartDefinition Bloom = MiddleDetails.addOrReplaceChild("Bloom", CubeListBuilder.create().texOffs(0, 584).addBox(-4.0F, -2.0324F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.4086F, 33.6943F, 8.0F, 0.0F, 0.3054F, 2.2689F));

		PartDefinition NPetal_r2 = Bloom.addOrReplaceChild("NPetal_r2", CubeListBuilder.create().texOffs(-16, 524).addBox(-16.0F, 0.0F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.9676F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition SPetal_r2 = Bloom.addOrReplaceChild("SPetal_r2", CubeListBuilder.create().texOffs(-16, 511).addBox(-16.0F, 0.0F, 3.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.9676F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition WPetal_r2 = Bloom.addOrReplaceChild("WPetal_r2", CubeListBuilder.create().texOffs(-16, 555).addBox(3.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition EPetal_r2 = Bloom.addOrReplaceChild("EPetal_r2", CubeListBuilder.create().texOffs(-16, 539).addBox(-19.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Tendril1 = MiddleDetails.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(444, 352).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.181F, -25.8201F, 7.9183F, 2.6737F, -1.1803F, 2.0154F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(470, 435).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(482, 270).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril1 = Seg3Tendril1.addOrReplaceChild("Seg4Tendril1", CubeListBuilder.create().texOffs(490, 12).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril2 = MiddleDetails.addOrReplaceChild("Tendril2", CubeListBuilder.create().texOffs(470, 435).addBox(-1.5F, -1.5F, 0.5F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6825F, -25.4254F, 15.8152F, 0.7013F, -0.2602F, -0.3543F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r1 = Seg2Tendril2.addOrReplaceChild("TendrilSeg_r1", CubeListBuilder.create().texOffs(482, 270).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1409F, -0.072F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition TendrilSeg_r2 = Seg3Tendril2.addOrReplaceChild("TendrilSeg_r2", CubeListBuilder.create().texOffs(490, 12).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tendril3 = MiddleDetails.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(444, 352).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.2904F, -19.6133F, 13.4319F, -2.6752F, -0.719F, 2.2464F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(470, 435).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(482, 270).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril2 = Seg3Tendril3.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(490, 12).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril4 = MiddleDetails.addOrReplaceChild("Tendril4", CubeListBuilder.create().texOffs(444, 352).addBox(-2.0F, -2.0F, -9.5F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.1814F, 17.4403F, 26.6835F, -2.6991F, -0.4268F, 2.8927F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(470, 435).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.25F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(482, 270).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril3 = Seg3Tendril4.addOrReplaceChild("Seg4Tendril3", CubeListBuilder.create().texOffs(490, 12).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril5 = MiddleDetails.addOrReplaceChild("Tendril5", CubeListBuilder.create(), PartPose.offsetAndRotation(16.4887F, 41.0213F, 16.332F, -0.4375F, -0.5086F, -1.0657F));

		PartDefinition TendrilSeg_r3 = Tendril5.addOrReplaceChild("TendrilSeg_r3", CubeListBuilder.create().texOffs(444, 352).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril5 = Tendril5.addOrReplaceChild("Seg2Tendril5", CubeListBuilder.create().texOffs(471, 435).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition Seg3Tendril5 = Seg2Tendril5.addOrReplaceChild("Seg3Tendril5", CubeListBuilder.create().texOffs(482, 270).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.072F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition Tendril6 = MiddleDetails.addOrReplaceChild("Tendril6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.8579F, 40.5797F, 16.9174F, -0.6503F, 0.1092F, 0.4026F));

		PartDefinition TendrilSeg_r4 = Tendril6.addOrReplaceChild("TendrilSeg_r4", CubeListBuilder.create().texOffs(444, 352).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition Seg2Tendril6 = Tendril6.addOrReplaceChild("Seg2Tendril6", CubeListBuilder.create().texOffs(471, 435).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0489F, -0.0111F, 10.2547F, -0.2725F, -0.6364F, 0.1646F));

		PartDefinition Seg3Tendril6 = Seg2Tendril6.addOrReplaceChild("Seg3Tendril6", CubeListBuilder.create().texOffs(482, 270).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1408F, -0.0721F, 8.3902F, -0.3695F, 0.3272F, -0.1238F));

		PartDefinition Tendril7 = MiddleDetails.addOrReplaceChild("Tendril7", CubeListBuilder.create(), PartPose.offsetAndRotation(-35.2204F, -11.4372F, 1.5685F, 1.5708F, 0.48F, 0.5236F));

		PartDefinition RootSeg_r1 = Tendril7.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(368, 236).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition Seg2Tendril7 = Tendril7.addOrReplaceChild("Seg2Tendril7", CubeListBuilder.create().texOffs(374, 185).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Seg3Tendril7 = Seg2Tendril7.addOrReplaceChild("Seg3Tendril7", CubeListBuilder.create().texOffs(416, 318).addBox(-14.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Seg4Tendril7 = Seg3Tendril7.addOrReplaceChild("Seg4Tendril7", CubeListBuilder.create().texOffs(280, 142).addBox(-13.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition TopSpine = Middle.addOrReplaceChild("TopSpine", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition plane_r1 = TopSpine.addOrReplaceChild("plane_r1", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -33.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r1 = TopSpine.addOrReplaceChild("Ridge_r1", CubeListBuilder.create().texOffs(448, 0).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r2 = TopSpine.addOrReplaceChild("plane_r2", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -35.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r2 = TopSpine.addOrReplaceChild("Ridge_r2", CubeListBuilder.create().texOffs(448, 0).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r3 = TopSpine.addOrReplaceChild("plane_r3", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -33.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r3 = TopSpine.addOrReplaceChild("Ridge_r3", CubeListBuilder.create().texOffs(448, 0).addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(276, 39).addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r16 = TopSpine.addOrReplaceChild("Base_r16", CubeListBuilder.create().texOffs(262, 0).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition rib1 = TopSpine.addOrReplaceChild("rib1", CubeListBuilder.create(), PartPose.offset(-0.5F, -29.0F, 13.0F));

		PartDefinition rBase_r1 = rib1.addOrReplaceChild("rBase_r1", CubeListBuilder.create().texOffs(158, 58).addBox(0.0F, 0.0F, -8.0F, 32.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.7095F, 3.6391F, 17.1767F, -0.2933F, -0.0744F, 1.1951F));

		PartDefinition rBase_r2 = rib1.addOrReplaceChild("rBase_r2", CubeListBuilder.create().texOffs(416, 87).addBox(0.0F, -1.0F, -8.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.3581F, -0.1048F, 13.025F, -0.0614F, -0.422F, 0.5307F));

		PartDefinition rBase_r3 = rib1.addOrReplaceChild("rBase_r3", CubeListBuilder.create().texOffs(352, 300).addBox(-3.5F, -1.0F, -4.0F, 24.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0227F, -0.4795F, 0.0492F));

		PartDefinition TopSpine2 = Middle.addOrReplaceChild("TopSpine2", CubeListBuilder.create(), PartPose.offsetAndRotation(6.495F, 10.4888F, -2.191F, -0.0289F, 0.2163F, 1.524F));

		PartDefinition plane_r4 = TopSpine2.addOrReplaceChild("plane_r4", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.48F, 0.0F, 0.1309F));

		PartDefinition Ridge_r4 = TopSpine2.addOrReplaceChild("Ridge_r4", CubeListBuilder.create().texOffs(448, 0).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -32.7217F, 50.4721F, -0.2182F, 0.0F, 0.1309F));

		PartDefinition plane_r5 = TopSpine2.addOrReplaceChild("plane_r5", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -36.2217F, 28.4721F, -0.3491F, 0.0F, -0.1745F));

		PartDefinition Ridge_r5 = TopSpine2.addOrReplaceChild("Ridge_r5", CubeListBuilder.create().texOffs(448, 0).addBox(-2.0F, 2.0868F, -6.9792F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -37.2217F, 28.4721F, -0.0873F, 0.0F, -0.1745F));

		PartDefinition plane_r6 = TopSpine2.addOrReplaceChild("plane_r6", CubeListBuilder.create().texOffs(0, 414).addBox(0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -31.0535F, -0.1833F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Ridge_r6 = TopSpine2.addOrReplaceChild("Ridge_r6", CubeListBuilder.create().texOffs(448, 0).addBox(-8.0F, -10.0F, 1.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(276, 39).addBox(-12.0F, -7.0F, -1.0F, 12.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Base_r17 = TopSpine2.addOrReplaceChild("Base_r17", CubeListBuilder.create().texOffs(262, 0).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 7.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -34.2033F, 23.8776F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Back = Body.addOrReplaceChild("Back", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 16.0F));

		PartDefinition EndRight_r1 = Back.addOrReplaceChild("EndRight_r1", CubeListBuilder.create().texOffs(114, 157).addBox(-55.0F, -25.0F, -1.0F, 7.0F, 24.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(212, 145).addBox(-48.0F, -38.0F, -1.0F, 49.0F, 44.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 16.0F, 34.0F, -0.0435F, 0.0038F, -0.2182F));

		PartDefinition Back_r1 = Back.addOrReplaceChild("Back_r1", CubeListBuilder.create().texOffs(170, 262).addBox(-3.5F, -1.5F, -13.0F, 8.0F, 42.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.6213F, -19.2006F, 26.6025F, -0.0933F, -0.1555F, -0.3134F));

		PartDefinition Back_r2 = Back.addOrReplaceChild("Back_r2", CubeListBuilder.create().texOffs(0, 41).addBox(-6.0F, -5.0F, -8.0F, 56.0F, 6.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.8109F, -12.2439F, 21.2386F, -0.1064F, -0.0074F, -0.1527F));

		PartDefinition Back_r3 = Back.addOrReplaceChild("Back_r3", CubeListBuilder.create().texOffs(0, 157).addBox(-0.75F, -34.0F, -18.0F, 7.0F, 38.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-41.3184F, 19.7891F, 21.4676F, 0.0F, 0.0436F, 0.1309F));

		PartDefinition Back_r4 = Back.addOrReplaceChild("Back_r4", CubeListBuilder.create().texOffs(0, 70).addBox(-17.0F, -3.0F, -6.0F, 38.0F, 6.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.8184F, 32.7891F, 9.4676F, 0.1104F, -0.274F, 0.3095F));

		PartDefinition Back_r5 = Back.addOrReplaceChild("Back_r5", CubeListBuilder.create().texOffs(134, 110).addBox(-11.0F, -1.0F, -14.0F, 42.0F, 6.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 32.0F, 22.0F, 0.3927F, 0.0F, -0.4363F));

		PartDefinition BackDetails = Back.addOrReplaceChild("BackDetails", CubeListBuilder.create(), PartPose.offset(-8.0F, 7.0F, 26.75F));

		PartDefinition ArmoredTumors1 = BackDetails.addOrReplaceChild("ArmoredTumors1", CubeListBuilder.create(), PartPose.offset(-15.0F, -27.0F, -4.0F));

		PartDefinition Tumors_r1 = ArmoredTumors1.addOrReplaceChild("Tumors_r1", CubeListBuilder.create().texOffs(248, 277).addBox(-3.5F, -1.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3039F, 0.0774F, -1.7428F, 0.2985F, 0.2079F, -0.0666F));

		PartDefinition Tumors_r2 = ArmoredTumors1.addOrReplaceChild("Tumors_r2", CubeListBuilder.create().texOffs(248, 277).addBox(-4.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1961F, 0.0F, 3.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Tumors_r3 = ArmoredTumors1.addOrReplaceChild("Tumors_r3", CubeListBuilder.create().texOffs(244, 269).addBox(-10.0F, -10.0F, -17.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.2758F, -0.3413F, -0.0595F));

		PartDefinition Tumors_r4 = ArmoredTumors1.addOrReplaceChild("Tumors_r4", CubeListBuilder.create().texOffs(248, 277).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition FungalArmor = ArmoredTumors1.addOrReplaceChild("FungalArmor", CubeListBuilder.create().texOffs(0, 938).addBox(-1.0F, -4.0F, -12.0F, 4.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 940).addBox(3.0F, -3.75F, -8.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 940).addBox(-1.75F, -2.0F, -12.5F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -9.1993F, -8.9537F, 0.3054F, 0.0F, 0.0F));

		PartDefinition plate_r14 = FungalArmor.addOrReplaceChild("plate_r14", CubeListBuilder.create().texOffs(0, 946).addBox(-3.5F, -1.0F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -3.25F, -1.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Plate_r15 = FungalArmor.addOrReplaceChild("Plate_r15", CubeListBuilder.create().texOffs(0, 945).addBox(-0.9709F, -4.5443F, -0.169F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.25F, 10.7024F, 12.6227F, 0.0164F, -0.6161F, -0.1522F));

		PartDefinition Plate_r16 = FungalArmor.addOrReplaceChild("Plate_r16", CubeListBuilder.create().texOffs(0, 944).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5555F, 13.3143F, 10.9602F, -0.1614F, -0.9976F, 0.136F));

		PartDefinition Plate_r17 = FungalArmor.addOrReplaceChild("Plate_r17", CubeListBuilder.create().texOffs(0, 940).addBox(-2.25F, -2.0031F, -0.919F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.25F, 10.7024F, 12.6227F, -0.1064F, -0.6082F, 0.061F));

		PartDefinition CalciumArmor_r1 = FungalArmor.addOrReplaceChild("CalciumArmor_r1", CubeListBuilder.create().texOffs(0, 943).addBox(-3.1091F, -3.816F, -1.2947F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9693F, 0.6865F, 5.069F, -0.3233F, 0.0516F, -0.1748F));

		PartDefinition CalciumArmor_r2 = FungalArmor.addOrReplaceChild("CalciumArmor_r2", CubeListBuilder.create().texOffs(0, 943).addBox(-2.398F, -2.5363F, -3.5589F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9693F, 0.6865F, 5.069F, 0.0873F, 0.0698F, 1.3439F));

		PartDefinition CalciumArmor_r3 = FungalArmor.addOrReplaceChild("CalciumArmor_r3", CubeListBuilder.create().texOffs(0, 943).addBox(-3.9232F, -2.0074F, -0.9679F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9693F, 0.6865F, 5.069F, -0.291F, 0.4577F, -0.1036F));

		PartDefinition CalciumArmor_r4 = FungalArmor.addOrReplaceChild("CalciumArmor_r4", CubeListBuilder.create().texOffs(0, 943).addBox(-3.2358F, 0.2735F, -0.8099F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9693F, 0.6865F, 5.069F, -0.0897F, 0.5546F, 0.1217F));

		PartDefinition plane_r7 = FungalArmor.addOrReplaceChild("plane_r7", CubeListBuilder.create().texOffs(0, 974).addBox(-1.25F, -7.5F, 1.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.5F, -2.5F, 0.0742F, 0.0563F, -0.7299F));

		PartDefinition plane_r8 = FungalArmor.addOrReplaceChild("plane_r8", CubeListBuilder.create().texOffs(0, 974).addBox(-2.25F, -7.5F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.5F, 2.0F, -0.0479F, 0.2129F, -0.616F));

		PartDefinition plane_r9 = FungalArmor.addOrReplaceChild("plane_r9", CubeListBuilder.create().texOffs(0, 974).addBox(-3.0F, -7.5F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.5F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition plate_r18 = FungalArmor.addOrReplaceChild("plate_r18", CubeListBuilder.create().texOffs(0, 945).addBox(-0.5F, 1.5F, -1.9776F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 939).addBox(-1.5F, -3.5F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1144F, 1.52F, -1.9224F, -0.2182F, -0.5236F, 0.1745F));

		PartDefinition plate_r19 = FungalArmor.addOrReplaceChild("plate_r19", CubeListBuilder.create().texOffs(0, 942).addBox(-1.0F, 0.0F, -0.75F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 937).addBox(0.0F, -3.0F, -3.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8891F, -1.6351F, 1.5776F, 0.0F, 0.2182F, -0.829F));

		PartDefinition plate_r20 = FungalArmor.addOrReplaceChild("plate_r20", CubeListBuilder.create().texOffs(0, 936).addBox(2.0F, -6.5F, -2.5F, 2.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5898F, 3.9535F, 1.5776F, 0.0F, 0.0F, 0.1745F));

		PartDefinition plate_r21 = FungalArmor.addOrReplaceChild("plate_r21", CubeListBuilder.create().texOffs(0, 942).addBox(-1.0F, 0.0F, -3.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5898F, 3.4535F, 4.3276F, -0.2494F, -0.0098F, -0.0779F));

		PartDefinition plate_r22 = FungalArmor.addOrReplaceChild("plate_r22", CubeListBuilder.create().texOffs(0, 942).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.25F, 0.5F, 3.25F, 0.0436F, -0.3054F, 0.0F));

		PartDefinition plate_r23 = FungalArmor.addOrReplaceChild("plate_r23", CubeListBuilder.create().texOffs(0, 944).addBox(-1.75F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.1491F, 1.8347F, -0.0961F, 0.2527F, -0.0692F));

		PartDefinition plate_r24 = FungalArmor.addOrReplaceChild("plate_r24", CubeListBuilder.create().texOffs(0, 939).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition BackTumors = BackDetails.addOrReplaceChild("BackTumors", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.9023F, 31.4761F, -0.8148F, 0.2357F, -0.4206F, 0.0809F));

		PartDefinition Tumor_r13 = BackTumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(244, 276).addBox(0.9415F, -4.1703F, -11.13F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5942F, -34.1672F, 21.6677F, -1.7147F, 0.9854F, -0.5813F));

		PartDefinition Tumor_r14 = BackTumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(244, 281).addBox(-5.5771F, -1.2191F, 2.9419F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5942F, -34.1672F, 21.6677F, -1.2806F, 0.8413F, -0.4193F));

		PartDefinition Tumor_r15 = BackTumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(244, 270).addBox(-2.6842F, -5.1837F, -1.139F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5942F, -34.1672F, 21.6677F, 1.0233F, -0.1655F, 0.2454F));

		PartDefinition Tumor_r16 = BackTumors.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(244, 270).addBox(-8.2489F, -9.1012F, -14.1506F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5942F, -34.1672F, 21.6677F, 0.6826F, -0.2865F, 0.1074F));

		PartDefinition Tumor_r17 = BackTumors.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(244, 270).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9023F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r18 = BackTumors.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(244, 270).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.691F, -0.1042F, 4.3564F, 0.2065F, -0.2714F, 1.1548F));

		PartDefinition Tumor_r19 = BackTumors.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(244, 270).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.691F, -1.1042F, 1.3564F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r20 = BackTumors.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(244, 270).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8864F, 0.152F, -5.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r21 = BackTumors.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(244, 270).addBox(-10.0F, -10.0F, -5.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0977F, 2.5239F, 2.0648F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Root1 = BackDetails.addOrReplaceChild("Root1", CubeListBuilder.create().texOffs(359, 235).addBox(-18.0F, -3.5F, -3.5F, 20.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.3249F, -9.0299F, -3.4447F, 1.309F, 0.5585F, -0.1191F));

		PartDefinition R1Seg2 = Root1.addOrReplaceChild("R1Seg2", CubeListBuilder.create().texOffs(367, 184).addBox(-20.0F, -2.5F, -2.5F, 22.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition R1Seg3 = R1Seg2.addOrReplaceChild("R1Seg3", CubeListBuilder.create().texOffs(417, 317).addBox(-12.0F, -1.5F, -1.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition R1Seg4 = R1Seg3.addOrReplaceChild("R1Seg4", CubeListBuilder.create().texOffs(280, 140).addBox(-13.5F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition EndTumors = Back.addOrReplaceChild("EndTumors", CubeListBuilder.create(), PartPose.offset(-6.0F, 0.0F, 55.0F));

		PartDefinition RightTumor_r1 = EndTumors.addOrReplaceChild("RightTumor_r1", CubeListBuilder.create().texOffs(244, 272).addBox(-8.9723F, 6.8296F, -1.6012F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(11.3355F, 15.7269F, -11.5378F, -0.7073F, -0.3819F, 0.4891F));

		PartDefinition RightTumor_r2 = EndTumors.addOrReplaceChild("RightTumor_r2", CubeListBuilder.create().texOffs(244, 272).addBox(-5.6585F, 2.4395F, -10.6696F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.3355F, 16.7269F, -18.5378F, 0.0F, -0.7418F, -0.5236F));

		PartDefinition RightTumor_r3 = EndTumors.addOrReplaceChild("RightTumor_r3", CubeListBuilder.create().texOffs(244, 272).addBox(-12.9404F, -5.4693F, -3.3713F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.3222F, 9.9279F, -20.4074F, 0.6545F, 0.0F, 0.5236F));

		PartDefinition RightTumor_r4 = EndTumors.addOrReplaceChild("RightTumor_r4", CubeListBuilder.create().texOffs(244, 272).addBox(-7.5457F, 1.1259F, -10.7121F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.3222F, 12.9279F, -16.4074F, 0.0F, 0.3927F, -0.4363F));

		PartDefinition RightTumor_r5 = EndTumors.addOrReplaceChild("RightTumor_r5", CubeListBuilder.create().texOffs(244, 272).addBox(-7.5F, -8.5F, -8.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.1501F, 13.473F, -17.2564F, 0.4531F, 1.5514F, 0.272F));

		PartDefinition RightTumor_r6 = EndTumors.addOrReplaceChild("RightTumor_r6", CubeListBuilder.create().texOffs(244, 272).addBox(-8.0F, -8.0F, -8.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 23.0F, -18.0F, 0.3927F, 0.0F, 0.4363F));

		PartDefinition RightTumor_r7 = EndTumors.addOrReplaceChild("RightTumor_r7", CubeListBuilder.create().texOffs(240, 267).addBox(-17.4771F, -6.3158F, -18.4165F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.7269F, 3.3355F, -18.5378F, -1.0472F, 0.6981F, 0.0F));

		PartDefinition RightTumor_r8 = EndTumors.addOrReplaceChild("RightTumor_r8", CubeListBuilder.create().texOffs(244, 272).addBox(-9.5F, -9.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2398F, 26.4268F, -16.0827F, 0.6981F, 1.0472F, 0.0F));

		PartDefinition RightTumor_r9 = EndTumors.addOrReplaceChild("RightTumor_r9", CubeListBuilder.create().texOffs(240, 267).addBox(-6.3157F, -1.5229F, -10.4165F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3355F, 16.7269F, -18.2878F, 0.6981F, 1.0472F, 0.0F));

		PartDefinition RightTumor_r10 = EndTumors.addOrReplaceChild("RightTumor_r10", CubeListBuilder.create().texOffs(232, 262).addBox(1.0F, -30.0F, -20.0F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 11.0F, -18.0F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition RightTumor_r11 = EndTumors.addOrReplaceChild("RightTumor_r11", CubeListBuilder.create().texOffs(244, 272).addBox(-29.5F, -48.5F, -9.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(26.5852F, 5.3355F, -19.6306F, 0.3819F, 0.7073F, -0.4891F));

		PartDefinition RightTumor_r12 = EndTumors.addOrReplaceChild("RightTumor_r12", CubeListBuilder.create().texOffs(244, 272).addBox(-10.5F, -7.5F, -7.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.5852F, 23.3355F, -14.6306F, 0.7418F, 0.0F, 0.5236F));

		PartDefinition RightTumor_r13 = EndTumors.addOrReplaceChild("RightTumor_r13", CubeListBuilder.create().texOffs(244, 272).addBox(-29.0F, -27.0F, 4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.0F, 12.0F, -21.0F, 0.0F, -0.3927F, 0.4363F));

		PartDefinition RightTumor_r14 = EndTumors.addOrReplaceChild("RightTumor_r14", CubeListBuilder.create().texOffs(240, 267).addBox(-2.0F, -15.0F, -8.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 2.0F, -20.0F, 0.0F, -0.6545F, 0.5236F));

		PartDefinition RightTumor_r15 = EndTumors.addOrReplaceChild("RightTumor_r15", CubeListBuilder.create().texOffs(240, 267).addBox(-10.0F, -10.0F, -11.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.7269F, 13.9509F, -16.0755F, -1.0472F, -0.6981F, 0.0F));

		PartDefinition RightTumor_r16 = EndTumors.addOrReplaceChild("RightTumor_r16", CubeListBuilder.create().texOffs(240, 267).addBox(11.0F, -1.0F, -32.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -21.0F, -1.2897F, -0.6247F, -0.2097F));

		PartDefinition EndRoot = Back.addOrReplaceChild("EndRoot", CubeListBuilder.create().texOffs(358, 234).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0398F, -1.9719F, 36.1348F, 1.7134F, 0.881F, 2.9598F));

		PartDefinition ESeg1 = EndRoot.addOrReplaceChild("ESeg1", CubeListBuilder.create().texOffs(364, 183).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition ESeg2 = ESeg1.addOrReplaceChild("ESeg2", CubeListBuilder.create().texOffs(414, 316).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition ESeg3 = ESeg2.addOrReplaceChild("ESeg3", CubeListBuilder.create().texOffs(276, 139).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.6981F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}
	public void animatedTongues(float ageInTicks){
		float tongue1Rot = Mth.sin(ageInTicks/6)/6;
		float tongue2Rot = Mth.cos(ageInTicks/5)/7;
		float tongue3Rot = Mth.sin(ageInTicks/4)/8;
		float tongue4Rot = Mth.cos(ageInTicks/8)/5;
		this.animateTentacleX(LargeTongue,tongue1Rot);
		this.animateTentacleX(LargeTongueS2,tongue1Rot);
		this.animateTentacleX(LargeTongueS3,tongue1Rot);
		this.animateTentacleX(LargeTongueS4,tongue1Rot);
		this.animateTentacleX(LargeTongue2,tongue2Rot);
		this.animateTentacleX(LargeTongueS5,tongue2Rot);
		this.animateTentacleX(LargeTongueS6,tongue2Rot);
		this.animateTentacleX(LargeTongueS7,tongue2Rot);
		this.animateTentacleX(LargeTongue3,tongue3Rot);
		this.animateTentacleX(LargeTongueS8,tongue3Rot);
		this.animateTentacleX(LargeTongueS9,tongue3Rot);
		this.animateTentacleX(LargeTongueS10,tongue3Rot);
		this.animateTentacleX(Tongue,tongue4Rot);
		this.animateTentacleX(TongueSeg2,tongue4Rot);
		this.animateTentacleX(TongueSeg3,tongue4Rot);
		this.animateTentacleX(TongueSeg4,tongue4Rot);
		this.animateTentacleX(TongueSeg5,tongue4Rot);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.InnerRaise.zRot = Mth.cos(ageInTicks/8)/4;
		this.InnerRim.zRot = Mth.sin(ageInTicks/6)/6;
		animatedTongues(ageInTicks);
		float backTentacle = Mth.cos(ageInTicks/6)/6;
		float backTentacle2 = Mth.sin(ageInTicks/6)/6;
		float frontTentacle1 = Mth.cos(ageInTicks/5)/6;
		float frontTentacle2 = Mth.sin(ageInTicks/5)/5;
		float frontTentacle3 = Mth.cos(ageInTicks/6)/6;
		float frontTentacle4 = Mth.sin(ageInTicks/4)/7;
		float frontTentacle5 = Mth.cos(ageInTicks/5)/6;
		float frontTentacle6 = Mth.sin(ageInTicks/5)/5;
		this.animateTentacleZ(this.EndRoot,backTentacle);
		this.animateTentacleZ(this.ESeg1,backTentacle);
		this.animateTentacleZ(this.ESeg2,backTentacle);
		this.animateTentacleZ(this.ESeg3,backTentacle);
		this.animateTentacleZ(this.Root1,backTentacle2);
		this.animateTentacleZ(this.R1Seg2,backTentacle2);
		this.animateTentacleZ(this.R1Seg3,backTentacle2);
		this.animateTentacleZ(this.R1Seg4,backTentacle2);
		this.animateTentacleX(this.Tendril1,frontTentacle1);
		this.animateTentacleX(this.Seg2Tendril1,frontTentacle1);
		this.animateTentacleX(this.Seg3Tendril1,frontTentacle1);
		this.animateTentacleX(this.Seg4Tendril1,frontTentacle1);
		this.animateTentacleX(this.Tendril2,frontTentacle2);
		this.animateTentacleX(this.Seg2Tendril2,frontTentacle2);
		this.animateTentacleX(this.Seg3Tendril2,frontTentacle2);
		this.animateTentacleX(this.Seg4Tendril2,frontTentacle2);
		this.animateTentacleX(this.Tendril3,frontTentacle3);
		this.animateTentacleX(this.Seg2Tendril3,frontTentacle3);
		this.animateTentacleX(this.Seg3Tendril3,frontTentacle3);
		this.animateTentacleX(this.Seg4Tendril3,frontTentacle3);
		this.animateTentacleX(this.Tendril4,frontTentacle4);
		this.animateTentacleX(this.Seg2Tendril4,frontTentacle4);
		this.animateTentacleX(this.Seg3Tendril4,frontTentacle4);
		this.animateTentacleX(this.Tendril5,frontTentacle5);
		this.animateTentacleX(this.Seg2Tendril5,frontTentacle5);
		this.animateTentacleX(this.Seg3Tendril5,frontTentacle5);
		this.animateTentacleX(this.Tendril6,frontTentacle6);
		this.animateTentacleX(this.Seg2Tendril6,frontTentacle6);
		this.animateTentacleX(this.Seg3Tendril6,frontTentacle6);

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hohl_head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}