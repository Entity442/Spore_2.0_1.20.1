package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class ProtoRedesign<T extends Proto> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "protoredesign"), "main");
	private final ModelPart Proto;
	private final ModelPart TumorBase;
	private final ModelPart Body;
	private final ModelPart RightRibs;
	private final ModelPart LeftRibs;
	private final ModelPart Eye;
	private final ModelPart TopEyeLid;
	private final ModelPart BottomEyeLid;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Brain4;
	private final ModelPart Brain5;
	private final ModelPart Brain6;
	private final ModelPart Brain7;
	private final ModelPart Brain8;
	private final ModelPart Brain9;
	private final ModelPart Brain10;
	private final ModelPart Brain11;
	private final ModelPart Brain12;
	private final ModelPart Brain13;
	private final ModelPart Brain14;
	private final ModelPart Brain15;
	private final ModelPart Brain16;
	private final ModelPart Brain17;
	private final ModelPart Brain18;
	private final ModelPart Brain19;
	private final ModelPart Brain20;
	private final ModelPart Brain21;
	private final ModelPart Brain22;
	private final ModelPart Brain23;
	private final ModelPart Brain24;
	private final ModelPart Brain25;
	private final ModelPart Brain26;
	private final ModelPart Brain27;
	private final ModelPart Brain28;
	private final ModelPart Brain29;
	private final ModelPart Brain30;
	private final ModelPart Brain31;
	private final ModelPart Brain32;
	private final ModelPart Brain33;
	private final ModelPart Brain34;
	private final ModelPart Biomass1;
	private final ModelPart Biomass2;
	private final ModelPart Biomass3;
	private final ModelPart Biomass4;
	private final ModelPart Tendril1;
	private final ModelPart Tendril1Seg2;
	private final ModelPart Tendril1Seg3;
	private final ModelPart Tendril1Seg4;
	private final ModelPart Tendril1Seg5;
	private final ModelPart Tendril1Rib1;
	private final ModelPart Tendril1Rib2;
	private final ModelPart Tendril1Rib3;
	private final ModelPart Tendril1Rib4;
	private final ModelPart Tendril1Rib5;
	private final ModelPart Tendril2;
	private final ModelPart Tendril2Seg2;
	private final ModelPart Tendril2Seg3;
	private final ModelPart Tendril2Seg4;
	private final ModelPart Tongue;
	private final ModelPart Tendril3;
	private final ModelPart Tendril3Seg2;
	private final ModelPart Tendril3Seg3;
	private final ModelPart Tendril3Seg4;
	private final ModelPart Tendril3Seg5;
	private final ModelPart Tendril3Rib1;
	private final ModelPart Tendril3Rib2;
	private final ModelPart Tendril3Rib3;
	private final ModelPart Tendril3Rib4;
	private final ModelPart Tendril4;
	private final ModelPart Tendril4Sec2;

	public ProtoRedesign(ModelPart root) {
		this.Proto = root.getChild("Proto");
		this.TumorBase = Proto.getChild("TumorBase");
		this.Body = Proto.getChild("Body");
		this.LeftRibs = Body.getChild("CoolingSystem").getChild("LeftHingeRotation");
		this.RightRibs = Body.getChild("CoolingSystem").getChild("RightHingeRotation");
		this.Eye = Body.getChild("EyeMouth").getChild("Eye").getChild("Pupil");
		this.TopEyeLid = Body.getChild("EyeMouth").getChild("Jaw").getChild("TopJaw");
		this.BottomEyeLid = Body.getChild("EyeMouth").getChild("Jaw").getChild("BottomJaw");
		this.Brain1 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain1");
		this.Brain2 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain2");
		this.Brain3 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain3");
		this.Brain4 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain4");
		this.Brain5 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain5");
		this.Brain6 = Body.getChild("BodyBase").getChild("Brains").getChild("FrontBrains").getChild("Brain11");
		this.Brain7 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain6");
		this.Brain8 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain8");
		this.Brain9 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain9");
		this.Brain10 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain10");
		this.Brain11 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain12");
		this.Brain12 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain14");
		this.Brain13 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain15");
		this.Brain14 = Body.getChild("BodyBase").getChild("Brains").getChild("BackBrains").getChild("Brain16");
		this.Brain15 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain17");
		this.Brain16 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain18");
		this.Brain17 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain19");
		this.Brain18 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain20");
		this.Brain19 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain21");
		this.Brain20 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain22");
		this.Brain21 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain23");
		this.Brain22 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain24");
		this.Brain23 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain25");
		this.Brain24 = Body.getChild("BodyBase").getChild("Brains").getChild("RightBrains").getChild("Brain26");
		this.Brain25 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain27");
		this.Brain26 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain28");
		this.Brain27 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain29");
		this.Brain28 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain30");
		this.Brain29 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain31");
		this.Brain30 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain32");
		this.Brain31 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain33");
		this.Brain32 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain34");
		this.Brain33 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain35");
		this.Brain34 = Body.getChild("BodyBase").getChild("Brains").getChild("LeftBrains").getChild("Brain36");
		this.Biomass1 = Proto.getChild("Tendrils").getChild("Tendril1").getChild("BiomassBase");
		this.Biomass2 = Proto.getChild("Tendrils").getChild("Tendril2").getChild("T2BiomassBase");
		this.Biomass3 = Proto.getChild("Tendrils").getChild("Tendril3").getChild("BiomassBaseT3");
		this.Biomass4 = Proto.getChild("Tendrils").getChild("Tendril4").getChild("BiomassT4");
		this.Tendril1 = Proto.getChild("Tendrils").getChild("Tendril1").getChild("T1Body1");
		this.Tendril1Seg2 = Tendril1.getChild("T1Body2");
		this.Tendril1Seg3 = Tendril1Seg2.getChild("T1Body3");
		this.Tendril1Seg4 = Tendril1Seg3.getChild("T1Body4");
		this.Tendril1Seg5 = Tendril1Seg4.getChild("T1Body5");
		this.Tendril1Rib1 = Tendril1Seg5.getChild("T1Ribs").getChild("T1Rib1");
		this.Tendril1Rib2 = Tendril1Seg5.getChild("T1Ribs").getChild("T1Rib2");
		this.Tendril1Rib3 = Tendril1Seg5.getChild("T1Ribs").getChild("T1Rib3");
		this.Tendril1Rib4 = Tendril1Seg5.getChild("T1Ribs").getChild("T1Rib4");
		this.Tendril1Rib5 = Tendril1Seg5.getChild("T1Ribs").getChild("T1Rib5");
		this.Tendril2 = Proto.getChild("Tendrils").getChild("Tendril2").getChild("T2Body1");
		this.Tendril2Seg2 = Tendril2.getChild("T2Body2");
		this.Tendril2Seg3 = Tendril2Seg2.getChild("T2Body3");
		this.Tendril2Seg4 = Tendril2Seg3.getChild("T2Body4");
		this.Tongue = Tendril2Seg4.getChild("tongue").getChild("tongue2");
		this.Tendril3 = Proto.getChild("Tendrils").getChild("Tendril3").getChild("T3Body1");
		this.Tendril3Seg2 = Tendril3.getChild("T3Body2");
		this.Tendril3Seg3 = Tendril3Seg2.getChild("T3Body3");
		this.Tendril3Seg4 = Tendril3Seg3.getChild("T3Body4");
		this.Tendril3Seg5 = Tendril3Seg4.getChild("T3Body4Head");
		this.Tendril3Rib1 = Tendril3Seg4.getChild("T3Body4Ribs").getChild("T3Rib2");
		this.Tendril3Rib2 = Tendril3Seg4.getChild("T3Body4Ribs").getChild("T3Rib3");
		this.Tendril3Rib3 = Tendril3Seg4.getChild("T3Body4Ribs").getChild("T3Rib4");
		this.Tendril3Rib4 = Tendril3Seg4.getChild("T3Body4Ribs").getChild("T3Rib5");
		this.Tendril4 = Proto.getChild("Tendrils").getChild("Tendril4").getChild("T4Body1");
		this.Tendril4Sec2 = Tendril4.getChild("T4Body2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Proto = partdefinition.addOrReplaceChild("Proto", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TumorBase = Proto.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-1.0F, -3.0F, 0.0F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(76, 91).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -4.0F, -6.0F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r2 = TumorBase.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(86, 98).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7887F, 0.3719F, 11.2916F, 0.2065F, -0.2714F, 1.1548F));

		PartDefinition Tumor_r3 = TumorBase.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(81, 96).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7887F, -0.6281F, 3.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r4 = TumorBase.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(78, 92).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7887F, 0.6281F, -3.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r5 = TumorBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(74, 90).addBox(-10.0F, -10.0F, -5.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 4.0F, 6.0F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Body = Proto.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CoolingSystem = Body.addOrReplaceChild("CoolingSystem", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition LeftHingeRotation = CoolingSystem.addOrReplaceChild("LeftHingeRotation", CubeListBuilder.create(), PartPose.offset(16.0F, -4.0F, 0.0F));

		PartDefinition LeftHinge = LeftHingeRotation.addOrReplaceChild("LeftHinge", CubeListBuilder.create().texOffs(44, 235).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib3Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib3_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib3_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib2_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib2_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftLowerMemebrane = LeftHinge.addOrReplaceChild("LeftLowerMemebrane", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r1 = LeftLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r1", CubeListBuilder.create().texOffs(0, 35).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r1 = LeftLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r1", CubeListBuilder.create().texOffs(0, 94).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r2 = LeftLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r2", CubeListBuilder.create().texOffs(170, 215).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r2 = LeftLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r2", CubeListBuilder.create().texOffs(28, 94).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftMiddleHinge = LeftHinge.addOrReplaceChild("LeftMiddleHinge", CubeListBuilder.create().texOffs(268, 309).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r1 = LeftMiddleHinge.addOrReplaceChild("MiddleRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib2_r1 = LeftMiddleHinge.addOrReplaceChild("MiddleRidgeRib2_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftMiddleMemebrane = LeftMiddleHinge.addOrReplaceChild("LeftMiddleMemebrane", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r1 = LeftMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r1", CubeListBuilder.create().texOffs(110, 20).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r1 = LeftMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembrane_r1", CubeListBuilder.create().texOffs(144, 171).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r1 = LeftMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembrane_r1", CubeListBuilder.create().texOffs(0, 176).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r1 = LeftMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembraneTip_r1", CubeListBuilder.create().texOffs(0, 130).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftTopHinge = LeftMiddleHinge.addOrReplaceChild("LeftTopHinge", CubeListBuilder.create().texOffs(254, 309).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r1 = LeftTopHinge.addOrReplaceChild("TopRidgeRib3Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib3_r1 = LeftTopHinge.addOrReplaceChild("TopRidgeRib3_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r1 = LeftTopHinge.addOrReplaceChild("TopRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib2_r1 = LeftTopHinge.addOrReplaceChild("TopRidgeRib2_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane = LeftTopHinge.addOrReplaceChild("LeftTopMemebrane", CubeListBuilder.create(), PartPose.offset(-4.1021F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r1 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebraneTip_r1", CubeListBuilder.create().texOffs(67, 43).addBox(-1.5F, -43.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r1 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebrane_r1", CubeListBuilder.create().texOffs(96, 168).addBox(-0.5F, -43.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r2 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebraneTip_r2", CubeListBuilder.create().texOffs(0, 70).addBox(-1.5F, -43.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r2 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebrane_r2", CubeListBuilder.create().texOffs(120, 170).addBox(-0.5F, -43.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightHingeRotation = CoolingSystem.addOrReplaceChild("RightHingeRotation", CubeListBuilder.create(), PartPose.offset(-16.0F, -4.0F, 0.0F));

		PartDefinition RightHinge = RightHingeRotation.addOrReplaceChild("RightHinge", CubeListBuilder.create().texOffs(44, 235).addBox(-1.683F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LowerRidgeRib3Tip_r2 = RightHinge.addOrReplaceChild("LowerRidgeRib3Tip_r2", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-0.5F, 4.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6624F, -17.5391F, 15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib3_r2 = RightHinge.addOrReplaceChild("LowerRidgeRib3_r2", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, 5.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.183F, -17.5391F, 1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LowerRidgeRib1Tip_r1 = RightHinge.addOrReplaceChild("LowerRidgeRib1Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6624F, -7.5391F, -15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib1_r1 = RightHinge.addOrReplaceChild("LowerRidgeRib1_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.183F, -7.5391F, -1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightLowerMemebrane = RightHinge.addOrReplaceChild("RightLowerMemebrane", CubeListBuilder.create(), PartPose.offset(4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r3 = RightLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r3", CubeListBuilder.create().texOffs(186, 215).addBox(1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r3 = RightLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r3", CubeListBuilder.create().texOffs(128, 148).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1057F, -0.01F, -14.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r4 = RightLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r4", CubeListBuilder.create().texOffs(202, 216).addBox(1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r4 = RightLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r4", CubeListBuilder.create().texOffs(0, 154).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1057F, -0.01F, -17.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightMiddleHinge = RightHinge.addOrReplaceChild("RightMiddleHinge", CubeListBuilder.create().texOffs(268, 309).addBox(-1.4095F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r2 = RightMiddleHinge.addOrReplaceChild("MiddleRidgeRib2Tip_r2", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8454F, -10.0F, 15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib2_r2 = RightMiddleHinge.addOrReplaceChild("MiddleRidgeRib2_r2", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeRib1Tip_r1 = RightMiddleHinge.addOrReplaceChild("MiddleRidgeRib1Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8454F, -7.0F, -15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r1 = RightMiddleHinge.addOrReplaceChild("MiddleRidgeRib1_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightMiddleMemebrane = RightMiddleHinge.addOrReplaceChild("RightMiddleMemebrane", CubeListBuilder.create(), PartPose.offset(5.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r2 = RightMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r2", CubeListBuilder.create().texOffs(184, 270).addBox(1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r2 = RightMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembrane_r2", CubeListBuilder.create().texOffs(96, 184).addBox(0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1925F, -0.01F, 14.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r2 = RightMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembrane_r2", CubeListBuilder.create().texOffs(182, 75).addBox(0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1925F, -0.01F, 17.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r2 = RightMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembraneTip_r2", CubeListBuilder.create().texOffs(110, 268).addBox(1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, 0.6981F, 0.0F));

		PartDefinition RightTopHinge = RightMiddleHinge.addOrReplaceChild("RightTopHinge", CubeListBuilder.create().texOffs(254, 309).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TopRidgeRib4Tip_r1 = RightTopHinge.addOrReplaceChild("TopRidgeRib4Tip_r1", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-0.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7549F, 18.487F, 15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib4_r1 = RightTopHinge.addOrReplaceChild("TopRidgeRib4_r1", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, 18.487F, 1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition TopRidgeRib3Tip_r2 = RightTopHinge.addOrReplaceChild("TopRidgeRib3Tip_r2", CubeListBuilder.create().texOffs(316, 313).addBox(-0.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(316, 313).addBox(-0.5F, -27.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7549F, 21.487F, -15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib3_r2 = RightTopHinge.addOrReplaceChild("TopRidgeRib3_r2", CubeListBuilder.create().texOffs(18, 223).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(18, 223).addBox(-1.5F, -27.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, 21.487F, -1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightTopMemebrane = RightTopHinge.addOrReplaceChild("RightTopMemebrane", CubeListBuilder.create(), PartPose.offset(5.1021F, 27.497F, -15.6758F));

		PartDefinition RightRidgeTopMemebraneTip_r1 = RightTopMemebrane.addOrReplaceChild("RightRidgeTopMemebraneTip_r1", CubeListBuilder.create().texOffs(42, 264).addBox(1.5F, -43.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition RightRidgeTopMemebrane_r1 = RightTopMemebrane.addOrReplaceChild("RightRidgeTopMemebrane_r1", CubeListBuilder.create().texOffs(168, 180).addBox(0.5F, -43.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1925F, -0.01F, 14.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition RightRidgeTopMemebraneTip_r2 = RightTopMemebrane.addOrReplaceChild("RightRidgeTopMemebraneTip_r2", CubeListBuilder.create().texOffs(26, 264).addBox(1.5F, -43.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, 0.6981F, 0.0F));

		PartDefinition RightRidgeTopMemebrane_r2 = RightTopMemebrane.addOrReplaceChild("RightRidgeTopMemebrane_r2", CubeListBuilder.create().texOffs(24, 178).addBox(0.5F, -43.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1925F, -0.01F, 17.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition EyeMouth = Body.addOrReplaceChild("EyeMouth", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9924F, -15.1743F, -16.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Eye = EyeMouth.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(192, 192).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Pupil = Eye.addOrReplaceChild("Pupil", CubeListBuilder.create().texOffs(222, 95).addBox(-2.5F, -2.5F, 1.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, -4.25F));

		PartDefinition Jaw = EyeMouth.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 4.0F));

		PartDefinition TopJaw = Jaw.addOrReplaceChild("TopJaw", CubeListBuilder.create(), PartPose.offset(0.3838F, -10.8279F, 0.8621F));

		PartDefinition HeadLeftTeeth_r1 = TopJaw.addOrReplaceChild("HeadLeftTeeth_r1", CubeListBuilder.create().texOffs(88, 127).addBox(-2.75F, 3.35F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(202, 35).addBox(-2.75F, -3.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.5847F, 0.1825F, -6.2745F, -0.1372F, -0.0042F, 0.4948F));

		PartDefinition HeadCenter_r1 = TopJaw.addOrReplaceChild("HeadCenter_r1", CubeListBuilder.create().texOffs(207, 178).addBox(-5.5F, -3.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.7894F, -1.0826F, -5.7788F, 0.1309F, 0.0F, 0.0436F));

		PartDefinition HeadRightTeeth_r1 = TopJaw.addOrReplaceChild("HeadRightTeeth_r1", CubeListBuilder.create().texOffs(88, 127).addBox(-4.0F, 0.6F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(226, 206).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.597F, 1.5661F, -7.0181F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition BottomJaw = Jaw.addOrReplaceChild("BottomJaw", CubeListBuilder.create(), PartPose.offset(-0.3838F, 2.8279F, 1.8621F));

		PartDefinition HeadRight_r1 = BottomJaw.addOrReplaceChild("HeadRight_r1", CubeListBuilder.create().texOffs(198, 163).addBox(-5.25F, -3.75F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.5847F, -0.1825F, -6.2745F, -0.0555F, 0.1071F, 0.484F));

		PartDefinition HeadCenter_r2 = BottomJaw.addOrReplaceChild("HeadCenter_r2", CubeListBuilder.create().texOffs(198, 113).addBox(-2.5F, -2.75F, -4.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.7894F, 1.0826F, -5.7788F, -0.1309F, 0.0F, 0.0436F));

		PartDefinition HeadLeftTeeth_r2 = BottomJaw.addOrReplaceChild("HeadLeftTeeth_r2", CubeListBuilder.create().texOffs(88, 132).addBox(-4.0F, -0.85F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(224, 192).addBox(-4.0F, 0.75F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.597F, -1.5661F, -7.0181F, -0.1309F, 0.0F, -0.1309F));

		PartDefinition BodyBase = Body.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(61, 55).addBox(-11.0F, -8.0F, -12.0F, 22.0F, 12.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-13.0F, -24.0F, -14.0F, 26.0F, 16.0F, 27.0F, new CubeDeformation(0.0F))
		.texOffs(8, 4).addBox(-11.0F, -36.0F, -12.0F, 22.0F, 12.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(69, 61).addBox(-9.0F, -45.0F, -10.0F, 18.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -7.0F, 0.0F));

		PartDefinition FrontSegments = BodyBase.addOrReplaceChild("FrontSegments", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, -12.0F));

		PartDefinition Top_r1 = FrontSegments.addOrReplaceChild("Top_r1", CubeListBuilder.create().texOffs(85, 78).addBox(-9.0F, -9.0F, 0.0F, 18.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Middle_r1 = FrontSegments.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(83, 77).addBox(-11.0F, -12.0F, 0.0F, 22.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.1305F, -2.0086F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Bottom_r1 = FrontSegments.addOrReplaceChild("Bottom_r1", CubeListBuilder.create().texOffs(21, 43).addBox(-11.0F, 1.0F, 0.0F, 22.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.878F, -2.1391F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightSegments = BodyBase.addOrReplaceChild("RightSegments", CubeListBuilder.create(), PartPose.offset(-11.0F, -36.0F, -0.5F));

		PartDefinition Top_r2 = RightSegments.addOrReplaceChild("Top_r2", CubeListBuilder.create().texOffs(87, 60).addBox(0.0F, -9.0F, -9.0F, 2.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Middle_r2 = RightSegments.addOrReplaceChild("Middle_r2", CubeListBuilder.create().texOffs(83, 56).addBox(0.0F, -12.0F, -11.0F, 2.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0086F, 12.1305F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Bottom_r2 = RightSegments.addOrReplaceChild("Bottom_r2", CubeListBuilder.create().texOffs(81, 56).addBox(0.0F, 1.0F, -12.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1391F, 26.878F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition LeftSegments = BodyBase.addOrReplaceChild("LeftSegments", CubeListBuilder.create(), PartPose.offset(11.0F, -36.0F, -0.5F));

		PartDefinition Top_r3 = LeftSegments.addOrReplaceChild("Top_r3", CubeListBuilder.create().texOffs(87, 55).addBox(-2.0F, -9.0F, -9.0F, 2.0F, 10.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Middle_r3 = LeftSegments.addOrReplaceChild("Middle_r3", CubeListBuilder.create().texOffs(82, 56).addBox(-2.0F, -12.0F, -11.0F, 2.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0086F, 12.1305F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Bottom_r3 = LeftSegments.addOrReplaceChild("Bottom_r3", CubeListBuilder.create().texOffs(81, 56).addBox(-2.0F, 1.0F, -12.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1391F, 26.878F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition BackSegments = BodyBase.addOrReplaceChild("BackSegments", CubeListBuilder.create(), PartPose.offset(0.0F, -36.0F, 11.0F));

		PartDefinition Top_r4 = BackSegments.addOrReplaceChild("Top_r4", CubeListBuilder.create().texOffs(87, 66).addBox(-9.0F, -9.0F, -2.0F, 18.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Middle_r4 = BackSegments.addOrReplaceChild("Middle_r4", CubeListBuilder.create().texOffs(83, 77).addBox(-11.0F, -12.0F, -1.0F, 22.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.1305F, 2.0086F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Bottom_r4 = BackSegments.addOrReplaceChild("Bottom_r4", CubeListBuilder.create().texOffs(82, 80).addBox(-11.0F, 1.0F, -1.0F, 22.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.878F, 2.1391F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Brains = BodyBase.addOrReplaceChild("Brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FrontBrains = Brains.addOrReplaceChild("FrontBrains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain1 = FrontBrains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(103, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).mirror().addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(131, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.1973F, -28.8588F, -12.564F, 1.3526F, 0.0F, -0.1309F));

		PartDefinition Brain2 = FrontBrains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).mirror().addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.582F, -26.192F, -15.0284F, 1.3413F, 0.088F, 0.0878F));

		PartDefinition Brain11 = FrontBrains.addOrReplaceChild("Brain11", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).mirror().addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.329F, -33.3044F, -12.7588F, 1.4111F, -0.122F, -0.0483F));

		PartDefinition Brain3 = FrontBrains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).mirror().addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(8.9234F, -29.5315F, -13.0562F, 1.4699F, -0.3751F, -0.193F));

		PartDefinition Brain4 = FrontBrains.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.1048F, -40.2714F, -12.0087F, 1.5231F, -0.0299F, 0.1016F));

		PartDefinition Brain5 = FrontBrains.addOrReplaceChild("Brain5", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).mirror().addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false), PartPose.offsetAndRotation(-4.7649F, -39.9808F, -11.7667F, 1.1843F, 0.173F, 0.0156F));

		PartDefinition BackBrains = Brains.addOrReplaceChild("BackBrains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain6 = BackBrains.addOrReplaceChild("Brain6", CubeListBuilder.create().texOffs(103, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.1973F, -28.8588F, 12.564F, -1.3526F, 0.0F, -0.1309F));

		PartDefinition Brain8 = BackBrains.addOrReplaceChild("Brain8", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.7546F, -29.538F, 12.0706F, -1.508F, 0.2493F, 0.2753F));

		PartDefinition Brain9 = BackBrains.addOrReplaceChild("Brain9", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.1048F, -40.2714F, 12.0087F, -1.5231F, 0.0299F, 0.1016F));

		PartDefinition Brain10 = BackBrains.addOrReplaceChild("Brain10", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.7649F, -39.9808F, 11.7667F, -1.1843F, -0.173F, 0.0156F));

		PartDefinition Brain12 = BackBrains.addOrReplaceChild("Brain12", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.7951F, -19.7017F, 13.7805F, -1.6721F, -0.174F, -0.2063F));

		PartDefinition Brain14 = BackBrains.addOrReplaceChild("Brain14", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(6.6607F, -21.2233F, 12.6769F, -1.8126F, -0.012F, -0.1139F));

		PartDefinition Brain15 = BackBrains.addOrReplaceChild("Brain15", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(7.5063F, -11.1428F, 13.139F, -1.4432F, 0.1106F, 0.3509F));

		PartDefinition Brain16 = BackBrains.addOrReplaceChild("Brain16", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.4852F, -11.1534F, 14.1849F, -1.6615F, 0.0895F, -0.1073F));

		PartDefinition RightBrains = Brains.addOrReplaceChild("RightBrains", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Brain17 = RightBrains.addOrReplaceChild("Brain17", CubeListBuilder.create().texOffs(103, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.1973F, -28.8588F, 12.564F, -1.3526F, 0.0F, -0.1309F));

		PartDefinition Brain18 = RightBrains.addOrReplaceChild("Brain18", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.1161F, -31.1207F, 13.8075F, -1.4727F, -0.0872F, 0.012F));

		PartDefinition Brain19 = RightBrains.addOrReplaceChild("Brain19", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(8.7546F, -29.538F, 12.0706F, -1.508F, 0.2493F, 0.2753F));

		PartDefinition Brain20 = RightBrains.addOrReplaceChild("Brain20", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.1048F, -40.2714F, 12.0087F, -1.5231F, 0.0299F, 0.1016F));

		PartDefinition Brain21 = RightBrains.addOrReplaceChild("Brain21", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.7649F, -39.9808F, 11.7667F, -1.1843F, -0.173F, 0.0156F));

		PartDefinition Brain22 = RightBrains.addOrReplaceChild("Brain22", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-6.7951F, -19.7017F, 13.7805F, -1.7137F, -0.1419F, 0.0569F));

		PartDefinition Brain23 = RightBrains.addOrReplaceChild("Brain23", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(8.7964F, -20.6223F, 13.0386F, -1.4615F, 0.1574F, -0.1189F));

		PartDefinition Brain24 = RightBrains.addOrReplaceChild("Brain24", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.6607F, -21.2233F, 12.6769F, -1.8126F, -0.012F, -0.1139F));

		PartDefinition Brain25 = RightBrains.addOrReplaceChild("Brain25", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(7.5063F, -11.1428F, 13.139F, -1.4432F, 0.1106F, 0.3509F));

		PartDefinition Brain26 = RightBrains.addOrReplaceChild("Brain26", CubeListBuilder.create().texOffs(103, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.4852F, -11.1534F, 14.1849F, -1.6615F, 0.0895F, -0.1073F));

		PartDefinition LeftBrains = Brains.addOrReplaceChild("LeftBrains", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Brain27 = LeftBrains.addOrReplaceChild("Brain27", CubeListBuilder.create().texOffs(103, 0).addBox(-3.3333F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(7.1973F, -28.8588F, -12.564F, 1.3526F, 0.0F, 0.1309F));

		PartDefinition Brain28 = LeftBrains.addOrReplaceChild("Brain28", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1161F, -31.1207F, -13.8075F, 1.4727F, -0.0872F, -0.012F));

		PartDefinition Brain29 = LeftBrains.addOrReplaceChild("Brain29", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-8.7546F, -29.538F, -12.0706F, 1.508F, 0.2493F, -0.2753F));

		PartDefinition Brain30 = LeftBrains.addOrReplaceChild("Brain30", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.1048F, -40.2714F, -12.0087F, 1.5231F, 0.0299F, -0.1016F));

		PartDefinition Brain31 = LeftBrains.addOrReplaceChild("Brain31", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.7649F, -39.9808F, -11.7667F, 1.1843F, -0.173F, -0.0156F));

		PartDefinition Brain32 = LeftBrains.addOrReplaceChild("Brain32", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(6.7951F, -19.7017F, -13.7805F, 1.7137F, -0.1419F, -0.0569F));

		PartDefinition Brain33 = LeftBrains.addOrReplaceChild("Brain33", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-8.7964F, -20.6223F, -13.0386F, 1.4615F, 0.1574F, 0.1189F));

		PartDefinition Brain34 = LeftBrains.addOrReplaceChild("Brain34", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.6607F, -21.2233F, -12.6769F, 1.8126F, -0.012F, 0.1139F));

		PartDefinition Brain35 = LeftBrains.addOrReplaceChild("Brain35", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.5063F, -11.1428F, -13.139F, 1.4432F, 0.1106F, -0.3509F));

		PartDefinition Brain36 = LeftBrains.addOrReplaceChild("Brain36", CubeListBuilder.create().texOffs(103, 0).addBox(-3.1667F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(131, 0).addBox(-3.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(131, 0).addBox(0.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.4852F, -11.1534F, -14.1849F, 1.6615F, 0.0895F, 0.1073F));

		PartDefinition FungalBloom = BodyBase.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offset(0.8468F, -48.7802F, 0.0507F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(117, 118).addBox(-11.8501F, -13.8001F, -7.6583F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 5.5803F, -7.8924F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(117, 118).addBox(-0.8501F, -13.8001F, 5.3417F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 5.5803F, -7.8924F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(118, 60).addBox(-16.8501F, -0.8001F, -17.6583F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 5.5803F, -0.3924F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(40, 120).addBox(-16.8501F, -0.8001F, 2.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 5.5803F, -0.3924F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(118, 44).addBox(1.1499F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 5.5803F, -8.3924F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(118, 28).addBox(-17.8501F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4967F, 4.5803F, -8.3924F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Tendrils = Proto.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.4335F, 0.0F, -17.3512F, 0.0F, -0.7854F, 0.0F));

		PartDefinition BiomassBase = Tendril1.addOrReplaceChild("BiomassBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass_r1 = BiomassBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(89, 99).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9926F, -2.3258F, 0.612F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Biomass_r2 = BiomassBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(84, 101).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8902F, -2.4341F, 6.7892F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Biomass_r3 = BiomassBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(81, 97).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2826F, -1.3864F, -0.1536F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Biomass_r4 = BiomassBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(86, 96).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2467F, -2.5148F, 7.8847F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition T1Body1 = Tendril1.addOrReplaceChild("T1Body1", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 4.0F));

		PartDefinition Arm_r1 = T1Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(318, 245).addBox(0.0953F, -1.6721F, -5.8679F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(132, 267).addBox(-0.4047F, -2.4221F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0953F, -8.0779F, -2.6321F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Jaw_r1 = T1Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(260, 152).addBox(-4.8246F, 0.7803F, -1.5825F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0953F, -8.0779F, -2.6321F, 0.1387F, 0.1089F, -1.3052F));

		PartDefinition Head_r1 = T1Body1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(206, 73).addBox(-4.2844F, -7.0707F, -1.7586F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0953F, -8.0779F, -2.6321F, 0.0322F, -0.0295F, -1.0913F));

		PartDefinition T1Body2 = T1Body1.addOrReplaceChild("T1Body2", CubeListBuilder.create().texOffs(109, 304).mirror().addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.9145F, -10.7651F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Arm_r2 = T1Body2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(318, 245).addBox(-2.3473F, -2.0304F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0835F, -7.7973F, 3.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition BodyTop_r1 = T1Body2.addOrReplaceChild("BodyTop_r1", CubeListBuilder.create().texOffs(132, 267).addBox(-2.4641F, -5.7768F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3775F, -4.7477F, 2.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition T1Body2TorsoFungus = T1Body2.addOrReplaceChild("T1Body2TorsoFungus", CubeListBuilder.create(), PartPose.offset(-0.7113F, -6.0741F, 0.0036F));

		PartDefinition Fungus_r1 = T1Body2TorsoFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(153, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -0.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = T1Body2TorsoFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(153, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.2108F, 0.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = T1Body2TorsoFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(139, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 1.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = T1Body2TorsoFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition T1Body3 = T1Body2.addOrReplaceChild("T1Body3", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1385F, -8.7993F, 0.0F, 0.0F, 3.1416F, -0.2618F));

		PartDefinition Jaw_r2 = T1Body3.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(260, 152).addBox(-6.8116F, -1.5319F, -4.3061F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2507F, -2.9427F, 0.1724F, 0.0459F, 0.0164F, 0.7833F));

		PartDefinition Head_r2 = T1Body3.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(206, 73).addBox(-2.0165F, -6.8414F, -4.1892F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3578F, -9.8163F, -0.2513F, -0.186F, 0.1854F, 1.8586F));

		PartDefinition Arm_r3 = T1Body3.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(318, 245).addBox(-2.3473F, -2.0304F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0835F, -2.7973F, 4.5F, 0.3491F, 0.0F, 2.9671F));

		PartDefinition BodyTop_r2 = T1Body3.addOrReplaceChild("BodyTop_r2", CubeListBuilder.create().texOffs(132, 267).addBox(-2.4641F, -5.7768F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3775F, -4.7477F, 2.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition T1Body4 = T1Body3.addOrReplaceChild("T1Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.9193F, -8.4598F, 0.6005F, 0.0F, 3.1416F, -1.5708F));

		PartDefinition BodyTop_r3 = T1Body4.addOrReplaceChild("BodyTop_r3", CubeListBuilder.create().texOffs(132, 267).addBox(-0.8602F, -10.954F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.142F, 0.0463F, -1.0316F, 0.0F, 0.0F, -1.5272F));

		PartDefinition BodyBase_r1 = T1Body4.addOrReplaceChild("BodyBase_r1", CubeListBuilder.create().texOffs(109, 304).addBox(-1.9047F, -5.9221F, -1.3679F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.142F, 0.0463F, -1.0316F, 0.0F, 0.0F, -1.2217F));

		PartDefinition T1Body4TorsoFungus = T1Body4.addOrReplaceChild("T1Body4TorsoFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.6535F, -1.8151F, 0.4031F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Fungus_r5 = T1Body4TorsoFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(153, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -4.2108F, -0.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = T1Body4TorsoFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(166, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.2108F, -0.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = T1Body4TorsoFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(139, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 1.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = T1Body4TorsoFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 1.7892F, -2.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition T1Body5 = T1Body4.addOrReplaceChild("T1Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.8441F, -1.2259F, 1.9006F, 0.0F, -1.5708F, -1.5708F));

		PartDefinition Torso_r1 = T1Body5.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(0, 14).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2415F, -6.9777F, -0.2043F, -0.2618F, 0.0F, 0.0F));

		PartDefinition H5TorsoLeft = T1Body5.addOrReplaceChild("H5TorsoLeft", CubeListBuilder.create(), PartPose.offset(-3.2415F, -5.3389F, 2.0483F));

		PartDefinition H5TorsoLeft_r1 = H5TorsoLeft.addOrReplaceChild("H5TorsoLeft_r1", CubeListBuilder.create().texOffs(12, 16).addBox(-2.0F, -4.9111F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3076F, -1.1168F, 0.1634F));

		PartDefinition H5TorsoRight = T1Body5.addOrReplaceChild("H5TorsoRight", CubeListBuilder.create(), PartPose.offset(3.3626F, -5.4683F, 1.1165F));

		PartDefinition H5TorsoRight_r1 = H5TorsoRight.addOrReplaceChild("H5TorsoRight_r1", CubeListBuilder.create().texOffs(12, 16).mirror().addBox(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5288F, 1.1168F, -0.3453F));

		PartDefinition T1Ribs = T1Body5.addOrReplaceChild("T1Ribs", CubeListBuilder.create(), PartPose.offset(0.0F, -5.25F, 2.0F));

		PartDefinition T1Rib1 = T1Ribs.addOrReplaceChild("T1Rib1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -2.5F, -0.5F, -0.2094F, 0.478F, -0.0983F));

		PartDefinition Rib1Seg1_r1 = T1Rib1.addOrReplaceChild("Rib1Seg1_r1", CubeListBuilder.create().texOffs(112, 215).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0872F, 0.0172F, -0.1627F, 0.0F, 0.5236F, 0.0F));

		PartDefinition T1Rib1Seg2 = T1Rib1.addOrReplaceChild("T1Rib1Seg2", CubeListBuilder.create(), PartPose.offset(2.6372F, 0.0172F, 4.254F));

		PartDefinition Rib1Seg2_r1 = T1Rib1Seg2.addOrReplaceChild("Rib1Seg2_r1", CubeListBuilder.create().texOffs(208, 4).mirror().addBox(-1.0F, -1.01F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition T1Rib1Seg3 = T1Rib1Seg2.addOrReplaceChild("T1Rib1Seg3", CubeListBuilder.create(), PartPose.offset(2.6517F, 0.0F, 2.6517F));

		PartDefinition Rib1Seg3_r1 = T1Rib1Seg3.addOrReplaceChild("Rib1Seg3_r1", CubeListBuilder.create().texOffs(230, 238).addBox(-1.0F, -1.0F, -0.2F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition T1Rib2 = T1Ribs.addOrReplaceChild("T1Rib2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.5F, -0.5F, -0.1508F, 0.1416F, 0.0638F));

		PartDefinition Rib2Seg1_r1 = T1Rib2.addOrReplaceChild("Rib2Seg1_r1", CubeListBuilder.create().texOffs(113, 216).mirror().addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition T1Rib2Seg2 = T1Rib2.addOrReplaceChild("T1Rib2Seg2", CubeListBuilder.create(), PartPose.offset(1.8547F, 0.01F, 3.3533F));

		PartDefinition Rib2Seg2_r1 = T1Rib2Seg2.addOrReplaceChild("Rib2Seg2_r1", CubeListBuilder.create().texOffs(204, 0).mirror().addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2217F, 0.0F));

		PartDefinition T1Rib2Seg3 = T1Rib2Seg2.addOrReplaceChild("T1Rib2Seg3", CubeListBuilder.create(), PartPose.offset(6.8331F, -0.02F, 2.9348F));

		PartDefinition Rib2Seg3_r1 = T1Rib2Seg3.addOrReplaceChild("Rib2Seg3_r1", CubeListBuilder.create().texOffs(230, 238).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition T1Rib3 = T1Ribs.addOrReplaceChild("T1Rib3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -4.0F, -0.5F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition Rib3Seg1_r1 = T1Rib3.addOrReplaceChild("Rib3Seg1_r1", CubeListBuilder.create().texOffs(112, 215).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition T1Rib3Seg2 = T1Rib3.addOrReplaceChild("T1Rib3Seg2", CubeListBuilder.create(), PartPose.offset(-2.55F, 0.0F, 4.4167F));

		PartDefinition Rib3Seg2_r1 = T1Rib3Seg2.addOrReplaceChild("Rib3Seg2_r1", CubeListBuilder.create().texOffs(208, 4).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0124F, 0.1392F, -0.011F));

		PartDefinition T1Rib3Seg3 = T1Rib3Seg2.addOrReplaceChild("T1Rib3Seg3", CubeListBuilder.create(), PartPose.offset(0.6153F, -0.01F, 3.9034F));

		PartDefinition Rib3Seg3_r1 = T1Rib3Seg3.addOrReplaceChild("Rib3Seg3_r1", CubeListBuilder.create().texOffs(230, 238).addBox(-1.0F, -1.0F, -0.35F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition T1Rib4 = T1Ribs.addOrReplaceChild("T1Rib4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -1.5F, -0.5F, -0.1861F, -0.09F, 0.2393F));

		PartDefinition Rib4Seg1_r1 = T1Rib4.addOrReplaceChild("Rib4Seg1_r1", CubeListBuilder.create().texOffs(113, 216).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition T1Rib4Seg2 = T1Rib4.addOrReplaceChild("T1Rib4Seg2", CubeListBuilder.create(), PartPose.offset(-1.8547F, 0.01F, 3.3533F));

		PartDefinition Rib4Seg2_r1 = T1Rib4Seg2.addOrReplaceChild("Rib4Seg2_r1", CubeListBuilder.create().texOffs(204, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));

		PartDefinition T1Rib5 = T1Ribs.addOrReplaceChild("T1Rib5", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4857F, 0.3867F, -1.2194F, -0.109F, -0.1757F, -0.3267F));

		PartDefinition Rib5Seg1_r1 = T1Rib5.addOrReplaceChild("Rib5Seg1_r1", CubeListBuilder.create().texOffs(110, 213).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.3896F, -0.1445F, 0.7888F, 0.0F, -0.5236F, 0.0F));

		PartDefinition T1Rib5Seg2 = T1Rib5.addOrReplaceChild("T1Rib5Seg2", CubeListBuilder.create(), PartPose.offset(-3.7443F, -0.1345F, 6.6421F));

		PartDefinition Rib5Seg2_r1 = T1Rib5Seg2.addOrReplaceChild("Rib5Seg2_r1", CubeListBuilder.create().texOffs(204, 0).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5272F, 0.0F));

		PartDefinition T1Rib5Seg3 = T1Rib5Seg2.addOrReplaceChild("T1Rib5Seg3", CubeListBuilder.create(), PartPose.offset(-7.4228F, -0.02F, -0.0073F));

		PartDefinition Rib5Seg3_r1 = T1Rib5Seg3.addOrReplaceChild("Rib5Seg3_r1", CubeListBuilder.create().texOffs(230, 238).addBox(-3.0F, -1.0F, -2.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5898F, 0.0F, 2.9421F, 0.0F, -0.5672F, 0.0F));

		PartDefinition T1Body5Head = T1Body5.addOrReplaceChild("T1Body5Head", CubeListBuilder.create().texOffs(218, 224).addBox(-4.0F, -6.161F, -2.6148F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.7852F, 1.0787F, 0.48F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = T1Body5Head.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(88, 128).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.839F, 4.3852F, 0.0F, 3.1416F, 0.0F));

		PartDefinition T1Body5HeadCrown1 = T1Body5Head.addOrReplaceChild("T1Body5HeadCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6848F, -2.4317F, 6.3709F, -1.4399F, 0.0F, 0.0F));

		PartDefinition Petal5_r1 = T1Body5HeadCrown1.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0874F, -0.0517F, -1.1782F, -0.0306F, 0.1719F, -0.6135F));

		PartDefinition Petal4_r1 = T1Body5HeadCrown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6028F, -0.2198F, 0.3625F, -0.2186F, -0.1937F, 0.6378F));

		PartDefinition Petal3_r1 = T1Body5HeadCrown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, 0.6357F, -3.5922F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Petal2_r1 = T1Body5HeadCrown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2423F, -0.3643F, 3.4078F, 0.7152F, -0.2815F, -0.1201F));

		PartDefinition T1Body5HeadCrown2 = T1Body5Head.addOrReplaceChild("T1Body5HeadCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2466F, -3.6456F, 5.1226F, -1.5386F, -0.0295F, 0.7413F));

		PartDefinition Petal4_r2 = T1Body5HeadCrown2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = T1Body5HeadCrown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(154, 13).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r2 = T1Body5HeadCrown2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = T1Body5HeadCrown2.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition T1Body5HeadCrown3 = T1Body5Head.addOrReplaceChild("T1Body5HeadCrown3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2466F, -4.6456F, -0.8774F, 0.931F, 0.3013F, 0.3795F));

		PartDefinition Petal5_r2 = T1Body5HeadCrown3.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r3 = T1Body5HeadCrown3.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(154, 13).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal3_r3 = T1Body5HeadCrown3.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r3 = T1Body5HeadCrown3.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Tumors = T1Body5Head.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r6 = Tumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(92, 109).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.6903F, -2.0272F, 5.4778F, 1.4923F, -0.2995F, -1.0681F));

		PartDefinition Tumor_r7 = Tumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(97, 97).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.6903F, -5.0272F, 5.4778F, 1.2278F, -0.3461F, -1.1971F));

		PartDefinition Tumor_r8 = Tumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(95, 99).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -4.0F, 5.0F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(16.7264F, 0.0F, 16.644F, 0.0F, -0.7854F, 0.0F));

		PartDefinition T2BiomassBase = Tendril2.addOrReplaceChild("T2BiomassBase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass_r5 = T2BiomassBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(82, 96).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9926F, -2.3258F, -0.612F, -0.3699F, -0.7124F, 0.2154F));

		PartDefinition Biomass_r6 = T2BiomassBase.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(89, 90).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8902F, -2.4341F, -6.7892F, 0.1987F, 0.4755F, 0.1473F));

		PartDefinition Biomass_r7 = T2BiomassBase.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(85, 99).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2826F, -1.3864F, 0.1536F, 0.0F, -0.5236F, 0.3491F));

		PartDefinition Biomass_r8 = T2BiomassBase.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(78, 98).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2467F, -2.5148F, -7.8847F, 0.1801F, 0.3913F, 0.0164F));

		PartDefinition T2Body1 = Tendril2.addOrReplaceChild("T2Body1", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, -4.0F));

		PartDefinition Arm_r4 = T2Body1.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(318, 245).addBox(-4.0953F, -1.6721F, 1.8679F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(132, 267).addBox(-4.5953F, -2.4221F, -6.1321F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0953F, -8.0779F, 2.6321F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Jaw_r3 = T2Body1.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(260, 152).addBox(-3.1754F, 0.7803F, -6.4175F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0953F, -8.0779F, 2.6321F, -0.0111F, 0.1423F, 0.5795F));

		PartDefinition Head_r3 = T2Body1.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(206, 73).mirror().addBox(-3.7156F, -7.0707F, -6.2414F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0953F, -8.0779F, 2.6321F, 0.0956F, -0.001F, 0.6094F));

		PartDefinition T2Body1HeadCrown = T2Body1.addOrReplaceChild("T2Body1HeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(8.777F, -9.6808F, 0.7072F, -0.4358F, -0.1044F, 1.7787F));

		PartDefinition Petal5_r3 = T2Body1HeadCrown.addOrReplaceChild("Petal5_r3", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, 0.4755F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r4 = T2Body1HeadCrown.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(154, 13).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6315F, 3.4073F, -3.9601F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal3_r4 = T2Body1HeadCrown.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8861F, 1.4755F, -3.9601F, -0.3835F, -0.3994F, 0.1796F));

		PartDefinition Petal2_r4 = T2Body1HeadCrown.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3708F, 0.5356F, -0.595F));

		PartDefinition T2Body2 = T2Body1.addOrReplaceChild("T2Body2", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9145F, -10.7651F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Arm_r5 = T2Body2.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(318, 245).addBox(-1.6527F, -2.0304F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0835F, -7.7973F, -3.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BodyTop_r4 = T2Body2.addOrReplaceChild("BodyTop_r4", CubeListBuilder.create().texOffs(132, 267).addBox(-2.5359F, -5.7768F, -1.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3775F, -4.7477F, -2.5F, 0.0F, 0.0F, 0.6545F));

		PartDefinition T2Body3 = T2Body2.addOrReplaceChild("T2Body3", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1385F, -8.7993F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BodyTop_r5 = T2Body3.addOrReplaceChild("BodyTop_r5", CubeListBuilder.create().texOffs(132, 267).addBox(-2.5359F, -5.7768F, -1.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3775F, -4.7477F, -2.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition T2Body4 = T2Body3.addOrReplaceChild("T2Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.5833F, -8.5189F, 1.6495F, 0.0F, 0.0F, -2.0508F));

		PartDefinition Jaw_r4 = T2Body4.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(260, 152).addBox(-4.3984F, 1.0432F, -4.2372F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.046F, 1.3021F, -1.3492F, -0.1387F, 0.1089F, 1.567F));

		PartDefinition Head_r4 = T2Body4.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(206, 73).mirror().addBox(-4.5019F, -7.7725F, -3.8577F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(11.046F, 1.3021F, -1.3492F, -0.0322F, -0.0295F, 0.5241F));

		PartDefinition BodyTop_r6 = T2Body4.addOrReplaceChild("BodyTop_r6", CubeListBuilder.create().texOffs(318, 245).addBox(-3.2924F, -1.8228F, -0.3777F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0386F, -0.4798F, 3.2945F, 0.1642F, 0.0594F, 1.2266F));

		PartDefinition BodyTop_r7 = T2Body4.addOrReplaceChild("BodyTop_r7", CubeListBuilder.create().texOffs(132, 267).addBox(-4.1398F, -10.954F, -6.1321F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.142F, 0.0463F, 1.0316F, 0.0F, 0.0F, 1.5272F));

		PartDefinition BodyBase_r2 = T2Body4.addOrReplaceChild("BodyBase_r2", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.142F, 0.0463F, 1.0316F, 0.0F, 0.0F, 1.2217F));

		PartDefinition tongue = T2Body4.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(212, 155).addBox(-2.0876F, -0.4919F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.3677F, -0.5819F, -0.3066F, 0.4625F, -1.4733F, 0.5392F));

		PartDefinition tongue2 = tongue.addOrReplaceChild("tongue2", CubeListBuilder.create().texOffs(212, 88).addBox(-1.5876F, -0.4919F, -6.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tongue3 = tongue2.addOrReplaceChild("tongue3", CubeListBuilder.create().texOffs(213, 51).addBox(-1.0876F, -0.4919F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition T2Body4HeadCrown = T2Body4.addOrReplaceChild("T2Body4HeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(14.3073F, -4.5976F, 0.0577F, -0.2427F, -0.3796F, 1.017F));

		PartDefinition Petal5_r4 = T2Body4HeadCrown.addOrReplaceChild("Petal5_r4", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r5 = T2Body4HeadCrown.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(154, 7).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal3_r5 = T2Body4HeadCrown.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r5 = T2Body4HeadCrown.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.1766F, 0.4011F, -1.1421F));

		PartDefinition T2Body3TorsoFungus2 = T2Body3.addOrReplaceChild("T2Body3TorsoFungus2", CubeListBuilder.create(), PartPose.offset(-1.8388F, -4.2749F, 0.0084F));

		PartDefinition Fungus_r9 = T2Body3TorsoFungus2.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = T2Body3TorsoFungus2.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(166, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4407F, -2.2108F, -2.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r11 = T2Body3TorsoFungus2.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(139, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r12 = T2Body3TorsoFungus2.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(17.4335F, 0.0F, -17.3512F, 0.0F, 0.7854F, 0.0F));

		PartDefinition BiomassBaseT3 = Tendril3.addOrReplaceChild("BiomassBaseT3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass_r9 = BiomassBaseT3.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(83, 100).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9926F, -2.3258F, 0.612F, 0.3699F, 0.7124F, 0.2154F));

		PartDefinition Biomass_r10 = BiomassBaseT3.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(91, 104).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8902F, -2.4341F, 6.7892F, -0.1987F, -0.4755F, 0.1473F));

		PartDefinition Biomass_r11 = BiomassBaseT3.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(88, 102).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2826F, -1.3864F, -0.1536F, 0.0F, 0.5236F, 0.3491F));

		PartDefinition Biomass_r12 = BiomassBaseT3.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(82, 94).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2467F, -2.5148F, 7.8847F, -0.1801F, -0.3913F, 0.0164F));

		PartDefinition T3Body1 = Tendril3.addOrReplaceChild("T3Body1", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, 4.0F));

		PartDefinition Arm_r6 = T3Body1.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(318, 245).addBox(-4.0953F, -1.6721F, -5.8679F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(132, 267).addBox(-4.5953F, -2.4221F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0953F, -8.0779F, -2.6321F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Jaw_r5 = T3Body1.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(260, 152).addBox(-3.4871F, 1.7899F, -4.1072F, 8.0F, 1.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.4108F, -6.3807F, 3.7487F, -0.7224F, -0.7792F, 1.1063F));

		PartDefinition Head_r5 = T3Body1.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(206, 73).mirror().addBox(-3.9835F, -5.8414F, -4.1892F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(2.4108F, -6.3807F, 3.7487F, -0.5766F, -0.8209F, 0.7448F));

		PartDefinition T3Body2 = T3Body1.addOrReplaceChild("T3Body2", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9145F, -10.7651F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Arm_r7 = T3Body2.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(318, 245).addBox(-1.6527F, -2.0304F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0835F, -7.7973F, 3.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BodyTop_r8 = T3Body2.addOrReplaceChild("BodyTop_r8", CubeListBuilder.create().texOffs(132, 267).addBox(-2.5359F, -5.7768F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3775F, -4.7477F, 2.5F, 0.0F, 0.0F, 0.6545F));

		PartDefinition T3Body3 = T3Body2.addOrReplaceChild("T3Body3", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1385F, -8.7993F, 0.0F, 0.0F, -3.1416F, 0.3491F));

		PartDefinition Arm_r8 = T3Body3.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(318, 245).addBox(-2.6223F, -0.6831F, -4.1F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0835F, -7.7973F, -4.2977F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Arm_r9 = T3Body3.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(318, 245).addBox(-1.6527F, -2.0304F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0835F, -7.7973F, 3.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BodyTop_r9 = T3Body3.addOrReplaceChild("BodyTop_r9", CubeListBuilder.create().texOffs(132, 267).addBox(-2.5359F, -5.7768F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3775F, -4.7477F, 2.5F, 0.0F, 0.0F, 0.6545F));

		PartDefinition T3Body3TorsoFungus = T3Body3.addOrReplaceChild("T3Body3TorsoFungus", CubeListBuilder.create(), PartPose.offset(0.4541F, -6.2749F, -1.9964F));

		PartDefinition Fungus_r13 = T3Body3TorsoFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r14 = T3Body3TorsoFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r15 = T3Body3TorsoFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(139, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r16 = T3Body3TorsoFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(153, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition T3Body4 = T3Body3.addOrReplaceChild("T3Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(3.2628F, -8.8513F, 0.6005F, 3.1416F, 0.0F, -1.5272F));

		PartDefinition BodyTop_r10 = T3Body4.addOrReplaceChild("BodyTop_r10", CubeListBuilder.create().texOffs(132, 281).addBox(-4.1398F, -10.954F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.142F, 0.0463F, -1.0316F, 0.0F, 0.0F, 1.5272F));

		PartDefinition BodyBase_r3 = T3Body4.addOrReplaceChild("BodyBase_r3", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0953F, -5.9221F, -1.3679F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.142F, 0.0463F, -1.0316F, 0.0F, 0.0F, 1.2217F));

		PartDefinition T3Body4Ribs = T3Body4.addOrReplaceChild("T3Body4Ribs", CubeListBuilder.create(), PartPose.offset(6.0007F, -3.0843F, -0.0994F));

		PartDefinition T3Rib2 = T3Body4Ribs.addOrReplaceChild("T3Rib2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 1.5F, 1.5F, -0.0305F, 0.1934F, 0.2385F));

		PartDefinition Rib2Seg1_r2 = T3Rib2.addOrReplaceChild("Rib2Seg1_r2", CubeListBuilder.create().texOffs(126, 28).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5F, 1.0F, -1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib2Seg2 = T3Rib2.addOrReplaceChild("T3Rib2Seg2", CubeListBuilder.create(), PartPose.offset(-0.51F, 6.9428F, -5.3691F));

		PartDefinition Rib2Seg2_r2 = T3Rib2Seg2.addOrReplaceChild("Rib2Seg2_r2", CubeListBuilder.create().texOffs(152, 112).addBox(-1.01F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.01F, -0.0261F, 0.8191F, -1.2217F, 0.0F, 0.0F));

		PartDefinition T3Rib2Seg3 = T3Rib2Seg2.addOrReplaceChild("T3Rib2Seg3", CubeListBuilder.create(), PartPose.offset(8.7583F, -6.9528F, 12.8138F));

		PartDefinition Rib2Seg3_r2 = T3Rib2Seg3.addOrReplaceChild("Rib2Seg3_r2", CubeListBuilder.create().texOffs(79, 12).addBox(-1.0F, -0.2412F, -1.034F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-8.7383F, 8.7047F, -17.193F, -0.2618F, 0.0F, 0.0F));

		PartDefinition T3Rib3 = T3Body4Ribs.addOrReplaceChild("T3Rib3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6906F, 3.2309F, -1.1039F, -0.2515F, 0.3533F, 0.0094F));

		PartDefinition Rib3Seg1_r2 = T3Rib3.addOrReplaceChild("Rib3Seg1_r2", CubeListBuilder.create().texOffs(126, 28).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.2043F, -0.165F, -0.0699F, -0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib3Seg2 = T3Rib3.addOrReplaceChild("T3Rib3Seg2", CubeListBuilder.create(), PartPose.offset(0.1943F, 3.5564F, -2.6833F));

		PartDefinition Rib3Seg2_r2 = T3Rib3Seg2.addOrReplaceChild("Rib3Seg2_r2", CubeListBuilder.create().texOffs(152, 112).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3681F, 0.7588F, -1.2217F, 0.0F, 0.0F));

		PartDefinition T3Rib3Seg3 = T3Rib3Seg2.addOrReplaceChild("T3Rib3Seg3", CubeListBuilder.create(), PartPose.offset(0.02F, 1.9986F, -6.092F));

		PartDefinition Rib3Seg3_r2 = T3Rib3Seg3.addOrReplaceChild("Rib3Seg3_r2", CubeListBuilder.create().texOffs(79, 12).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.5681F, 0.0176F, -0.2618F, 0.0F, 0.0F));

		PartDefinition T3Rib4 = T3Body4Ribs.addOrReplaceChild("T3Rib4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.898F, 2.5756F, 3.4406F, 0.4317F, -0.2241F, 0.0958F));

		PartDefinition Rib4Seg1_r2 = T3Rib4.addOrReplaceChild("Rib4Seg1_r2", CubeListBuilder.create().texOffs(126, 28).mirror().addBox(-1.0F, -1.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.3155F, -0.4289F, -0.5503F, 0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib4Seg2 = T3Rib4.addOrReplaceChild("T3Rib4Seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2941F, 3.9684F, 1.7223F, 1.0472F, 0.0F, 0.0F));

		PartDefinition Rib4Seg2_r2 = T3Rib4Seg2.addOrReplaceChild("Rib4Seg2_r2", CubeListBuilder.create().texOffs(152, 112).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0214F, 0.0195F, 0.2774F, -0.1392F, -0.011F, 0.0124F));

		PartDefinition T3Rib4Seg3 = T3Rib4Seg2.addOrReplaceChild("T3Rib4Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0314F, 3.8127F, -0.1069F, -0.7418F, 0.0F, 0.0F));

		PartDefinition Rib4Seg3_r1 = T3Rib4Seg3.addOrReplaceChild("Rib4Seg3_r1", CubeListBuilder.create().texOffs(79, 12).addBox(-1.0F, -0.35F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.1101F, -0.231F, 0.0873F, 0.0F, 0.0F));

		PartDefinition T3Rib5 = T3Body4Ribs.addOrReplaceChild("T3Rib5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 2.25F, 5.25F, 0.3999F, -0.1789F, 0.0275F));

		PartDefinition Rib5Seg1_r2 = T3Rib5.addOrReplaceChild("Rib5Seg1_r2", CubeListBuilder.create().texOffs(126, 28).mirror().addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-0.1349F, 0.449F, 0.0811F, 0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib5Seg2 = T3Rib5.addOrReplaceChild("T3Rib5Seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1449F, 3.2682F, 1.9652F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Rib5Seg2_r2 = T3Rib5Seg2.addOrReplaceChild("Rib5Seg2_r2", CubeListBuilder.create().texOffs(152, 112).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.12F, -0.2474F, 1.5272F, 0.0F, 0.0F));

		PartDefinition T3Rib5Seg3 = T3Rib5Seg2.addOrReplaceChild("T3Rib5Seg3", CubeListBuilder.create(), PartPose.offset(0.02F, 0.3861F, 5.4528F));

		PartDefinition Rib5Seg3_r2 = T3Rib5Seg3.addOrReplaceChild("Rib5Seg3_r2", CubeListBuilder.create().texOffs(152, 112).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0304F, -0.3473F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Rib5Seg7 = T3Rib5Seg3.addOrReplaceChild("Rib5Seg7", CubeListBuilder.create(), PartPose.offset(-13.0744F, -4.9653F, -2.9234F));

		PartDefinition Rib5Seg4_r1 = Rib5Seg7.addOrReplaceChild("Rib5Seg4_r1", CubeListBuilder.create().texOffs(79, 12).addBox(-1.01F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(13.0744F, 9.6735F, 3.4009F, -0.5236F, 0.0F, 0.0F));

		PartDefinition T3Body4Head = T3Body4.addOrReplaceChild("T3Body4Head", CubeListBuilder.create(), PartPose.offsetAndRotation(9.046F, -2.6979F, 0.3492F, 0.0F, 0.3054F, -0.7854F));

		PartDefinition Jaw_r6 = T3Body4Head.addOrReplaceChild("Jaw_r6", CubeListBuilder.create().texOffs(260, 152).addBox(-4.3984F, 0.0432F, -3.7628F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.1387F, -0.1089F, 2.047F));

		PartDefinition Head_r6 = T3Body4Head.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(206, 73).mirror().addBox(-4.5019F, -7.7725F, -4.1423F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0322F, 0.0295F, 1.8331F));

		PartDefinition T3Body4HeadCrown = T3Body4Head.addOrReplaceChild("T3Body4HeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(4.7081F, 4.4328F, -0.2473F, 0.0F, 0.0F, 2.2253F));

		PartDefinition Petal5_r5 = T3Body4HeadCrown.addOrReplaceChild("Petal5_r5", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r6 = T3Body4HeadCrown.addOrReplaceChild("Petal4_r6", CubeListBuilder.create().texOffs(154, 7).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal3_r6 = T3Body4HeadCrown.addOrReplaceChild("Petal3_r6", CubeListBuilder.create().texOffs(154, 13).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r6 = T3Body4HeadCrown.addOrReplaceChild("Petal2_r6", CubeListBuilder.create().texOffs(154, 7).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.1766F, 0.4011F, -1.1421F));

		PartDefinition Tendril4 = Tendrils.addOrReplaceChild("Tendril4", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.7264F, 0.0F, 22.3009F, 0.0F, 0.7854F, 0.0F));

		PartDefinition BiomassT4 = Tendril4.addOrReplaceChild("BiomassT4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass_r13 = BiomassT4.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(92, 98).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9926F, -2.3258F, -0.612F, -0.3699F, 0.7124F, -0.2154F));

		PartDefinition Biomass_r14 = BiomassT4.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(79, 105).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8902F, -2.4341F, -6.7892F, 0.1987F, -0.4755F, -0.1473F));

		PartDefinition Biomass_r15 = BiomassT4.addOrReplaceChild("Biomass_r15", CubeListBuilder.create().texOffs(82, 102).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2826F, -1.3864F, 0.1536F, 0.0F, 0.5236F, -0.3491F));

		PartDefinition Biomass_r16 = BiomassT4.addOrReplaceChild("Biomass_r16", CubeListBuilder.create().texOffs(84, 94).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2467F, -2.5148F, -7.8847F, 0.1801F, -0.3913F, -0.0164F));

		PartDefinition T4Body1 = Tendril4.addOrReplaceChild("T4Body1", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, -4.0F));

		PartDefinition Arm_r10 = T4Body1.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(318, 245).addBox(0.0953F, -1.6721F, 1.8679F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(132, 281).mirror().addBox(-0.4047F, -2.4221F, -6.1321F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0953F, -8.0779F, 2.6321F, 0.0F, 0.0F, -0.3054F));

		PartDefinition T4Body1TorsoFungus = T4Body1.addOrReplaceChild("T4Body1TorsoFungus", CubeListBuilder.create(), PartPose.offset(-2.3329F, -5.8392F, 0.3516F));

		PartDefinition Fungus_r17 = T4Body1TorsoFungus.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(166, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 2.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r18 = T4Body1TorsoFungus.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(153, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r19 = T4Body1TorsoFungus.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(139, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r20 = T4Body1TorsoFungus.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(139, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition T4Body2 = T4Body1.addOrReplaceChild("T4Body2", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0F, -6.0F, -3.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3772F, -9.9217F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Arm_r11 = T4Body2.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(318, 245).addBox(-2.3473F, -2.0304F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0835F, -7.7973F, -3.5F, 0.0F, 0.0F, 0.3491F));

		PartDefinition BodyTop_r11 = T4Body2.addOrReplaceChild("BodyTop_r11", CubeListBuilder.create().texOffs(132, 281).mirror().addBox(-2.4641F, -5.7768F, -1.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3775F, -4.7477F, -2.5F, 0.0F, 0.0F, -0.6545F));

		PartDefinition TornEnd = T4Body2.addOrReplaceChild("TornEnd", CubeListBuilder.create().texOffs(27, 232).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1846F, -10.5979F, 0.25F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Tumor_r9 = TornEnd.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(97, 101).addBox(-1.25F, -2.5F, 1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(97, 101).addBox(0.5F, -2.25F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1768F, 0.5744F, -2.7933F, -0.581F, -0.9591F, 1.6302F));

		PartDefinition Tumor_r10 = TornEnd.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(97, 101).addBox(-1.0F, 0.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.2663F, 0.0553F, 0.2067F));

		PartDefinition Tip2_r1 = TornEnd.addOrReplaceChild("Tip2_r1", CubeListBuilder.create().texOffs(27, 233).addBox(-1.0F, -3.5F, -1.4909F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.384F, 0.433F, 0.0F, 0.0F, 0.0F, -0.5236F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	private void AnimateEye(Entity proto,ModelPart part){
		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = proto.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				part.y = 0.0F;
			} else {
				part.y = 1.0F;
			}

			Vec3 vec32 = proto.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			part.x = Mth.sqrt((float)Math.abs(d1)) * 3.0F * (float)Math.signum(d1);
		}
	}
	private void AnimateTumorBase(ModelPart part,float v){
		part.xScale = 1 + Mth.sin(v/8)/8;
		part.yScale = 1 + Mth.sin(v/8)/8;
		part.zScale = 1 + Mth.sin(v/8)/8;
	}
	private void AnimateBrain(ModelPart part , float v){
		part.xScale = 1 + Mth.sin(v/8)/8;
		part.yScale = 1 + Mth.cos(v/8)/7;
		part.zScale = 1 + Mth.sin(v/8)/8;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Body.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.AnimateEye(entity,Eye);
		this.AnimateTumorBase(TumorBase,ageInTicks);
		this.AnimateTumorBase(Biomass1,ageInTicks);
		this.AnimateTumorBase(Biomass2,ageInTicks);
		this.AnimateTumorBase(Biomass3,ageInTicks);
		this.AnimateTumorBase(Biomass4,ageInTicks);
		this.Tendril1.zRot =-0.3f - Mth.sin(ageInTicks/7)/7;
		this.Tendril1Seg2.zRot = Mth.sin(ageInTicks/8)/7;
		this.Tendril1Seg2.yRot = Mth.sin(ageInTicks/8)/8;
		this.Tendril1Seg3.xRot = Mth.sin(ageInTicks/6)/7;
		this.Tendril1Seg4.xRot = Mth.sin(ageInTicks/6)/7;
		this.Tendril1Seg5.xRot = Mth.sin(ageInTicks/6)/7;

		this.Tendril1Rib1.yRot = -Mth.sin(ageInTicks/3)/4;
		this.Tendril1Rib2.yRot = -Mth.sin(ageInTicks/4)/3;
		this.Tendril1Rib3.yRot = Mth.sin(ageInTicks/4)/4;
		this.Tendril1Rib4.yRot = -Mth.sin(ageInTicks/4)/3;
		this.Tendril1Rib5.yRot = Mth.sin(ageInTicks/4)/6;
		this.Tendril1Rib1.getChild("T1Rib1Seg2").yRot = -Mth.sin(ageInTicks/3)/4;
		this.Tendril1Rib2.getChild("T1Rib2Seg2").yRot = -Mth.sin(ageInTicks/4)/3;
		this.Tendril1Rib3.getChild("T1Rib3Seg2").yRot = Mth.sin(ageInTicks/4)/4;
		this.Tendril1Rib4.getChild("T1Rib4Seg2").yRot = -Mth.sin(ageInTicks/4)/3;
		this.Tendril1Rib5.getChild("T1Rib5Seg2").yRot = Mth.sin(ageInTicks/4)/4;

		this.Tendril2.xRot = Mth.sin(ageInTicks/6)/7;
		this.Tendril2Seg2.yRot = Mth.cos(ageInTicks/5)/7;
		this.Tendril2Seg3.xRot = Mth.cos(ageInTicks/5)/6;
		this.Tendril2Seg4.yRot = Mth.sin(ageInTicks/6)/5;
		this.Tongue.yRot = Mth.cos(ageInTicks/6)/2;
		this.Tongue.getChild("tongue3").yRot = Mth.cos(ageInTicks/6)/2;

		this.Tendril3.zRot = 0.4f - Mth.sin(ageInTicks/7)/7;
		this.Tendril3Seg2.zRot = Mth.cos(ageInTicks/6)/7;
		this.Tendril3Seg3.xRot = Mth.sin(ageInTicks/6)/5;
		this.Tendril3Seg4.yRot = Mth.cos(ageInTicks/6)/8;
		this.Tendril3Seg5.xRot = Mth.sin(ageInTicks/7)/4;
		this.Tendril3Rib1.xRot = Mth.cos(ageInTicks/5)/3;
		this.Tendril3Rib2.xRot = Mth.cos(ageInTicks/6)/4;
		this.Tendril3Rib3.xRot = -Mth.cos(ageInTicks/5)/5;
		this.Tendril3Rib4.xRot = -Mth.cos(ageInTicks/4)/3;
		this.Tendril3Rib1.getChild("T3Rib2Seg2").xRot = Mth.cos(ageInTicks/5)/3;
		this.Tendril3Rib2.getChild("T3Rib3Seg2").xRot = Mth.cos(ageInTicks/6)/4;
		this.Tendril3Rib3.getChild("T3Rib4Seg2").xRot = -Mth.cos(ageInTicks/5)/5;
		this.Tendril3Rib4.getChild("T3Rib5Seg2").xRot = -Mth.cos(ageInTicks/4)/3;

		this.Tendril4.xRot = Mth.sin(ageInTicks/4)/5;
		this.Tendril4.zRot = Mth.sin(ageInTicks/4)/5;
		this.Tendril4Sec2.xRot = Mth.sin(ageInTicks/6)/4;

		this.RightRibs.zRot = Mth.cos(ageInTicks/9)/9;
		this.LeftRibs.zRot = -RightRibs.zRot;
		this.BottomEyeLid.xRot = Mth.cos(ageInTicks/5)/6;
		this.TopEyeLid.xRot = -BottomEyeLid.xRot;



		this.AnimateBrain(Brain1,ageInTicks);
		this.AnimateBrain(Brain2,-ageInTicks);
		this.AnimateBrain(Brain3,-ageInTicks);
		this.AnimateBrain(Brain4,ageInTicks);
		this.AnimateBrain(Brain5,-ageInTicks);
		this.AnimateBrain(Brain6,ageInTicks);
		this.AnimateBrain(Brain7,ageInTicks);
		this.AnimateBrain(Brain8,-ageInTicks);
		this.AnimateBrain(Brain9,ageInTicks);
		this.AnimateBrain(Brain10,-ageInTicks);
		this.AnimateBrain(Brain11,ageInTicks);
		this.AnimateBrain(Brain12,-ageInTicks);
		this.AnimateBrain(Brain13,-ageInTicks);
		this.AnimateBrain(Brain14,ageInTicks);
		this.AnimateBrain(Brain15,ageInTicks);
		this.AnimateBrain(Brain16,-ageInTicks);
		this.AnimateBrain(Brain17,ageInTicks);
		this.AnimateBrain(Brain18,-ageInTicks);
		this.AnimateBrain(Brain19,-ageInTicks);
		this.AnimateBrain(Brain20,ageInTicks);
		this.AnimateBrain(Brain21,ageInTicks);
		this.AnimateBrain(Brain22,-ageInTicks);
		this.AnimateBrain(Brain23,-ageInTicks);
		this.AnimateBrain(Brain24,ageInTicks);
		this.AnimateBrain(Brain25,-ageInTicks);
		this.AnimateBrain(Brain26,-ageInTicks);
		this.AnimateBrain(Brain27,ageInTicks);
		this.AnimateBrain(Brain28,ageInTicks);
		this.AnimateBrain(Brain29,-ageInTicks);
		this.AnimateBrain(Brain30,-ageInTicks);
		this.AnimateBrain(Brain31,ageInTicks);
		this.AnimateBrain(Brain32,ageInTicks);
		this.AnimateBrain(Brain33,-ageInTicks);
		this.AnimateBrain(Brain34,ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Proto.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}