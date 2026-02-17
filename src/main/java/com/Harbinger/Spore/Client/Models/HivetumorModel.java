package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.Organoids.HiveTumor;
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

public class HivetumorModel<T extends HiveTumor> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "hivetumor"), "main");
	private final ModelPart Hivetumor;
	private final ModelPart HivetumorBody;
	private final ModelPart MainBodyBase;
	private final ModelPart BodyBase;
	private final ModelPart DetailSegments;
	private final ModelPart BiomassClumps;
	private final ModelPart BiomassClump1;
	private final ModelPart BiomassClump2;
	private final ModelPart BiomassClump3;
	private final ModelPart BiomassClump4;
	private final ModelPart BiomassClump5;
	private final ModelPart BiomassClump6;
	private final ModelPart BiomassClump7;
	private final ModelPart BiomassClump8;
	private final ModelPart Brains;
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
	private final ModelPart ExtraHeads;
	private final ModelPart ClawingBody;
	private final ModelPart ClawingMainBody;
	private final ModelPart ClawingBiomass;
	private final ModelPart SearchingBody;
	private final ModelPart SearchingMainBody;
	private final ModelPart Tongue;
	private final ModelPart Tongue2;
	private final ModelPart Tongue3;
	private final ModelPart SearchingBiomass;
	private final ModelPart PetalCrown3;
	private final ModelPart Foliage;
	private final ModelPart PetalCrowns;
	private final ModelPart PetalCrown1;
	private final ModelPart PetalCrown2;
	private final ModelPart SparseFoliage;
	private final ModelPart FungalBloom;
	private final ModelPart TumorStick;
	private final ModelPart StickEnd;
	private final ModelPart Tumors;
	private final ModelPart Face;
	private final ModelPart Eye;
	private final ModelPart Pupil;
	private final ModelPart Jaws;
	private final ModelPart UpperJaw;
	private final ModelPart UpperRightHead;
	private final ModelPart LowerJaw;
	private final ModelPart BrokenCoolingSystem;
	private final ModelPart UpperHinge;
	private final ModelPart MiddleHinge;
	private final ModelPart Roots;
	private final ModelPart Root1;
	private final ModelPart Root1Mid;
	private final ModelPart Root1End;
	private final ModelPart Root2;
	private final ModelPart Root2Mid;
	private final ModelPart Root2End;
	private final ModelPart Root3;
	private final ModelPart Root3Mid;
	private final ModelPart Root3End;
	private final ModelPart Root4;
	private final ModelPart Root4Mid;
	private final ModelPart Root4End;
	private final ModelPart TumorBase;
	private final ModelPart TumorGroup1;
	private final ModelPart TumorGroup2;
	private final ModelPart TumorGroup3;
	private final ModelPart TumorGroup4;
	private final ModelPart TumorGroup5;
	private final ModelPart Ribs;
	private final ModelPart FrontRibs;
	private final ModelPart ribJoint;
	private final ModelPart Rib1;
	private final ModelPart Rib1Seg2;
	private final ModelPart ribJoint2;
	private final ModelPart Rib2;
	private final ModelPart Rib2Seg2;
	private final ModelPart ribJoint3;
	private final ModelPart Rib3;
	private final ModelPart Rib3Seg2;
	private final ModelPart BackRibs;
	private final ModelPart ribJoint4;
	private final ModelPart Rib4;
	private final ModelPart Rib4Seg2;
	private final ModelPart ribJoint5;
	private final ModelPart Rib5;
	private final ModelPart Rib5Seg2;
	private final ModelPart ribJoint6;
	private final ModelPart Rib6;
	private final ModelPart Rib6Seg2;
	private final ModelPart LeftRibs;
	private final ModelPart ribJoint7;
	private final ModelPart Rib7;
	private final ModelPart Rib6Seg3;
	private final ModelPart ribJoint8;
	private final ModelPart Rib8;
	private final ModelPart Rib6Seg4;
	private final ModelPart RightRibs;
	private final ModelPart ribJoint10;
	private final ModelPart Rib10;
	private final ModelPart Rib6Seg6;
	private final ModelPart MainTendril;
	private final ModelPart BiomassBaseT3;
	private final ModelPart T3Body1;
	private final ModelPart T3Body2;
	private final ModelPart T3Body3;
	private final ModelPart T3Body3TorsoFungus;
	private final ModelPart T3Body4;
	private final ModelPart T3Body4Ribs;
	private final ModelPart T3Rib2;
	private final ModelPart T3Rib3;
	private final ModelPart T3Rib3Seg2;
	private final ModelPart T3Rib3Seg3;
	private final ModelPart T3Rib4;
	private final ModelPart T3Rib5;
	private final ModelPart T3Rib5Seg2;
	private final ModelPart T3Rib5Seg3;
	private final ModelPart T3Body4Head;
	private final ModelPart T3Body4HeadCrown;

	public HivetumorModel(ModelPart root) {
		this.Hivetumor = root.getChild("Hivetumor");
		this.HivetumorBody = this.Hivetumor.getChild("HivetumorBody");
		this.MainBodyBase = this.HivetumorBody.getChild("MainBodyBase");
		this.BodyBase = this.MainBodyBase.getChild("BodyBase");
		this.DetailSegments = this.MainBodyBase.getChild("DetailSegments");
		this.BiomassClumps = this.MainBodyBase.getChild("BiomassClumps");
		this.BiomassClump1 = this.BiomassClumps.getChild("BiomassClump1");
		this.BiomassClump2 = this.BiomassClumps.getChild("BiomassClump2");
		this.BiomassClump3 = this.BiomassClumps.getChild("BiomassClump3");
		this.BiomassClump4 = this.BiomassClumps.getChild("BiomassClump4");
		this.BiomassClump5 = this.BiomassClumps.getChild("BiomassClump5");
		this.BiomassClump6 = this.BiomassClumps.getChild("BiomassClump6");
		this.BiomassClump7 = this.BiomassClumps.getChild("BiomassClump7");
		this.BiomassClump8 = this.BiomassClumps.getChild("BiomassClump8");
		this.Brains = this.MainBodyBase.getChild("Brains");
		this.Brain1 = this.Brains.getChild("Brain1");
		this.Brain2 = this.Brains.getChild("Brain2");
		this.Brain3 = this.Brains.getChild("Brain3");
		this.Brain4 = this.Brains.getChild("Brain4");
		this.Brain5 = this.Brains.getChild("Brain5");
		this.Brain6 = this.Brains.getChild("Brain6");
		this.Brain7 = this.Brains.getChild("Brain7");
		this.Brain8 = this.Brains.getChild("Brain8");
		this.Brain9 = this.Brains.getChild("Brain9");
		this.Brain10 = this.Brains.getChild("Brain10");
		this.ExtraHeads = this.MainBodyBase.getChild("ExtraHeads");
		this.ClawingBody = this.MainBodyBase.getChild("ClawingBody");
		this.ClawingMainBody = this.ClawingBody.getChild("ClawingMainBody");
		this.ClawingBiomass = this.ClawingBody.getChild("ClawingBiomass");
		this.SearchingBody = this.MainBodyBase.getChild("SearchingBody");
		this.SearchingMainBody = this.SearchingBody.getChild("SearchingMainBody");
		this.Tongue = this.SearchingMainBody.getChild("Tongue");
		this.Tongue2 = this.Tongue.getChild("Tongue2");
		this.Tongue3 = this.Tongue2.getChild("Tongue3");
		this.SearchingBiomass = this.SearchingBody.getChild("SearchingBiomass");
		this.PetalCrown3 = this.SearchingBody.getChild("PetalCrown3");
		this.Foliage = this.HivetumorBody.getChild("Foliage");
		this.PetalCrowns = this.Foliage.getChild("PetalCrowns");
		this.PetalCrown1 = this.PetalCrowns.getChild("PetalCrown1");
		this.PetalCrown2 = this.PetalCrowns.getChild("PetalCrown2");
		this.SparseFoliage = this.Foliage.getChild("SparseFoliage");
		this.FungalBloom = this.Foliage.getChild("FungalBloom");
		this.TumorStick = this.HivetumorBody.getChild("TumorStick");
		this.StickEnd = this.TumorStick.getChild("StickEnd");
		this.Tumors = this.StickEnd.getChild("Tumors");
		this.Face = this.HivetumorBody.getChild("Face");
		this.Eye = this.Face.getChild("Eye");
		this.Pupil = this.Eye.getChild("Pupil");
		this.Jaws = this.Face.getChild("Jaws");
		this.UpperJaw = this.Jaws.getChild("UpperJaw");
		this.UpperRightHead = this.UpperJaw.getChild("UpperRightHead");
		this.LowerJaw = this.Jaws.getChild("LowerJaw");
		this.BrokenCoolingSystem = this.HivetumorBody.getChild("BrokenCoolingSystem");
		this.UpperHinge = this.BrokenCoolingSystem.getChild("UpperHinge");
		this.MiddleHinge = this.BrokenCoolingSystem.getChild("MiddleHinge");
		this.Roots = this.HivetumorBody.getChild("Roots");
		this.Root1 = this.Roots.getChild("Root1");
		this.Root1Mid = this.Root1.getChild("Root1Mid");
		this.Root1End = this.Root1Mid.getChild("Root1End");
		this.Root2 = this.Roots.getChild("Root2");
		this.Root2Mid = this.Root2.getChild("Root2Mid");
		this.Root2End = this.Root2Mid.getChild("Root2End");
		this.Root3 = this.Roots.getChild("Root3");
		this.Root3Mid = this.Root3.getChild("Root3Mid");
		this.Root3End = this.Root3Mid.getChild("Root3End");
		this.Root4 = this.Roots.getChild("Root4");
		this.Root4Mid = this.Root4.getChild("Root4Mid");
		this.Root4End = this.Root4Mid.getChild("Root4End");
		this.TumorBase = this.Hivetumor.getChild("TumorBase");
		this.TumorGroup1 = this.TumorBase.getChild("TumorGroup1");
		this.TumorGroup2 = this.TumorBase.getChild("TumorGroup2");
		this.TumorGroup3 = this.TumorBase.getChild("TumorGroup3");
		this.TumorGroup4 = this.TumorBase.getChild("TumorGroup4");
		this.TumorGroup5 = this.TumorBase.getChild("TumorGroup5");
		this.Ribs = this.TumorBase.getChild("Ribs");
		this.FrontRibs = this.Ribs.getChild("FrontRibs");
		this.ribJoint = this.FrontRibs.getChild("ribJoint");
		this.Rib1 = this.ribJoint.getChild("Rib1");
		this.Rib1Seg2 = this.Rib1.getChild("Rib1Seg2");
		this.ribJoint2 = this.FrontRibs.getChild("ribJoint2");
		this.Rib2 = this.ribJoint2.getChild("Rib2");
		this.Rib2Seg2 = this.Rib2.getChild("Rib2Seg2");
		this.ribJoint3 = this.FrontRibs.getChild("ribJoint3");
		this.Rib3 = this.ribJoint3.getChild("Rib3");
		this.Rib3Seg2 = this.Rib3.getChild("Rib3Seg2");
		this.BackRibs = this.Ribs.getChild("BackRibs");
		this.ribJoint4 = this.BackRibs.getChild("ribJoint4");
		this.Rib4 = this.ribJoint4.getChild("Rib4");
		this.Rib4Seg2 = this.Rib4.getChild("Rib4Seg2");
		this.ribJoint5 = this.BackRibs.getChild("ribJoint5");
		this.Rib5 = this.ribJoint5.getChild("Rib5");
		this.Rib5Seg2 = this.Rib5.getChild("Rib5Seg2");
		this.ribJoint6 = this.BackRibs.getChild("ribJoint6");
		this.Rib6 = this.ribJoint6.getChild("Rib6");
		this.Rib6Seg2 = this.Rib6.getChild("Rib6Seg2");
		this.LeftRibs = this.Ribs.getChild("LeftRibs");
		this.ribJoint7 = this.LeftRibs.getChild("ribJoint7");
		this.Rib7 = this.ribJoint7.getChild("Rib7");
		this.Rib6Seg3 = this.Rib7.getChild("Rib6Seg3");
		this.ribJoint8 = this.LeftRibs.getChild("ribJoint8");
		this.Rib8 = this.ribJoint8.getChild("Rib8");
		this.Rib6Seg4 = this.Rib8.getChild("Rib6Seg4");
		this.RightRibs = this.Ribs.getChild("RightRibs");
		this.ribJoint10 = this.RightRibs.getChild("ribJoint10");
		this.Rib10 = this.ribJoint10.getChild("Rib10");
		this.Rib6Seg6 = this.Rib10.getChild("Rib6Seg6");
		this.MainTendril = this.Hivetumor.getChild("MainTendril");
		this.BiomassBaseT3 = this.MainTendril.getChild("BiomassBaseT3");
		this.T3Body1 = this.MainTendril.getChild("T3Body1");
		this.T3Body2 = this.T3Body1.getChild("T3Body2");
		this.T3Body3 = this.T3Body2.getChild("T3Body3");
		this.T3Body3TorsoFungus = this.T3Body3.getChild("T3Body3TorsoFungus");
		this.T3Body4 = this.T3Body3.getChild("T3Body4");
		this.T3Body4Ribs = this.T3Body4.getChild("T3Body4Ribs");
		this.T3Rib2 = this.T3Body4Ribs.getChild("T3Rib2");
		this.T3Rib3 = this.T3Body4Ribs.getChild("T3Rib3");
		this.T3Rib3Seg2 = this.T3Rib3.getChild("T3Rib3Seg2");
		this.T3Rib3Seg3 = this.T3Rib3Seg2.getChild("T3Rib3Seg3");
		this.T3Rib4 = this.T3Body4Ribs.getChild("T3Rib4");
		this.T3Rib5 = this.T3Body4Ribs.getChild("T3Rib5");
		this.T3Rib5Seg2 = this.T3Rib5.getChild("T3Rib5Seg2");
		this.T3Rib5Seg3 = this.T3Rib5Seg2.getChild("T3Rib5Seg3");
		this.T3Body4Head = this.T3Body4.getChild("T3Body4Head");
		this.T3Body4HeadCrown = this.T3Body4Head.getChild("T3Body4HeadCrown");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Hivetumor = partdefinition.addOrReplaceChild("Hivetumor", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition HivetumorBody = Hivetumor.addOrReplaceChild("HivetumorBody", CubeListBuilder.create(), PartPose.offset(-14.1391F, -16.122F, -0.5F));

		PartDefinition MainBodyBase = HivetumorBody.addOrReplaceChild("MainBodyBase", CubeListBuilder.create(), PartPose.offset(14.1391F, 16.122F, 0.5F));

		PartDefinition BodyBase = MainBodyBase.addOrReplaceChild("BodyBase", CubeListBuilder.create().texOffs(0, 80).addBox(-12.0F, -15.0F, -12.0F, 22.0F, 12.0F, 23.0F, new CubeDeformation(0.0F))
				.texOffs(6, 50).addBox(-12.0F, -43.0F, -12.0F, 22.0F, 12.0F, 17.0F, new CubeDeformation(0.0F))
				.texOffs(7, 7).addBox(-14.0F, -31.0F, -14.0F, 26.0F, 16.0F, 20.0F, new CubeDeformation(0.0F))
				.texOffs(16, 60).addBox(-12.0F, -43.0F, 5.0F, 17.0F, 12.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(20, 20).addBox(-14.0F, -31.0F, 6.0F, 16.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition DetailSegments = MainBodyBase.addOrReplaceChild("DetailSegments", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BottomRight_r1 = DetailSegments.addOrReplaceChild("BottomRight_r1", CubeListBuilder.create().texOffs(107, 0).addBox(0.0F, 1.0F, -12.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.1391F, -16.122F, -0.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition BottomLeft_r1 = DetailSegments.addOrReplaceChild("BottomLeft_r1", CubeListBuilder.create().texOffs(91, 75).addBox(-2.0F, 1.0F, -12.0F, 2.0F, 8.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.1391F, -16.122F, -0.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition BottomBack_r1 = DetailSegments.addOrReplaceChild("BottomBack_r1", CubeListBuilder.create().texOffs(168, 190).addBox(-11.0F, 1.0F, -1.0F, 22.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -16.122F, 12.1391F, -0.1309F, 0.0F, 0.0F));

		PartDefinition BottomFront_r1 = DetailSegments.addOrReplaceChild("BottomFront_r1", CubeListBuilder.create().texOffs(190, 176).addBox(-11.0F, 1.0F, 0.0F, 22.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -16.122F, -14.1391F, 0.1309F, 0.0F, 0.0F));

		PartDefinition TopRight_r1 = DetailSegments.addOrReplaceChild("TopRight_r1", CubeListBuilder.create().texOffs(49, 137).addBox(0.0F, -12.0F, -11.0F, 2.0F, 12.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0086F, -30.8695F, -0.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition TopLeft_r1 = DetailSegments.addOrReplaceChild("TopLeft_r1", CubeListBuilder.create().texOffs(5, 121).addBox(-2.0F, -12.0F, -11.0F, 2.0F, 12.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0086F, -30.8695F, -0.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition TopBack_r1 = DetailSegments.addOrReplaceChild("TopBack_r1", CubeListBuilder.create().texOffs(161, 17).addBox(-10.0F, -12.0F, -1.0F, 12.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -30.8695F, 13.0086F, 0.1309F, 0.0F, 0.0F));

		PartDefinition TopFront_r1 = DetailSegments.addOrReplaceChild("TopFront_r1", CubeListBuilder.create().texOffs(144, 176).addBox(-10.0F, -12.0F, 0.0F, 20.0F, 12.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -30.8695F, -14.0086F, -0.1309F, 0.0F, 0.0F));

		PartDefinition BiomassClumps = MainBodyBase.addOrReplaceChild("BiomassClumps", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BiomassClump1 = BiomassClumps.addOrReplaceChild("BiomassClump1", CubeListBuilder.create(), PartPose.offset(9.0F, -34.0F, -10.0F));

		PartDefinition BiomassTumor3_r1 = BiomassClump1.addOrReplaceChild("BiomassTumor3_r1", CubeListBuilder.create().texOffs(38, 58).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -4.0F, -1.4F, -2.1209F, -0.3751F, 2.235F));

		PartDefinition BiomassTumor2_r1 = BiomassClump1.addOrReplaceChild("BiomassTumor2_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -1.0F, -1.1F, 0.084F, 0.0741F, -0.465F));

		PartDefinition BiomassTumor1_r1 = BiomassClump1.addOrReplaceChild("BiomassTumor1_r1", CubeListBuilder.create().texOffs(38, 58).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 3.0F, -2.4F, 0.2132F, -0.0469F, 0.2132F));

		PartDefinition BiomassClump2 = BiomassClumps.addOrReplaceChild("BiomassClump2", CubeListBuilder.create(), PartPose.offset(4.162F, -15.2294F, -16.6697F));

		PartDefinition BiomassTumor6_r1 = BiomassClump2.addOrReplaceChild("BiomassTumor6_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.662F, -1.8707F, 3.2697F, 2.8183F, -0.3751F, 2.235F));

		PartDefinition BiomassTumor5_r1 = BiomassClump2.addOrReplaceChild("BiomassTumor5_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.638F, -0.7706F, 2.5697F, 0.0403F, 0.091F, -0.7798F));

		PartDefinition BiomassTumor4_r1 = BiomassClump2.addOrReplaceChild("BiomassTumor4_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.438F, 0.2294F, 2.2697F, 0.0882F, -0.1998F, 1.1518F));

		PartDefinition BiomassClump3 = BiomassClumps.addOrReplaceChild("BiomassClump3", CubeListBuilder.create(), PartPose.offset(3.7143F, -15.262F, 7.1256F));

		PartDefinition BiomassTumor10_r1 = BiomassClump3.addOrReplaceChild("BiomassTumor10_r1", CubeListBuilder.create().texOffs(42, 60).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6857F, 0.262F, 0.1744F, -2.87F, -0.2257F, -2.9436F));

		PartDefinition BiomassTumor9_r1 = BiomassClump3.addOrReplaceChild("BiomassTumor9_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9143F, -1.238F, 1.7744F, 2.7213F, -0.26F, 2.543F));

		PartDefinition BiomassTumor8_r1 = BiomassClump3.addOrReplaceChild("BiomassTumor8_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0857F, 0.862F, -1.7256F, -0.0141F, 0.5002F, -1.3289F));

		PartDefinition BiomassTumor7_r1 = BiomassClump3.addOrReplaceChild("BiomassTumor7_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0143F, 0.062F, -0.5256F, 0.0882F, -0.1998F, 1.1518F));

		PartDefinition BiomassClump4 = BiomassClumps.addOrReplaceChild("BiomassClump4", CubeListBuilder.create(), PartPose.offset(4.0143F, -31.262F, 7.1256F));

		PartDefinition BiomassTumor12_r1 = BiomassClump4.addOrReplaceChild("BiomassTumor12_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4143F, 1.562F, 0.8744F, -0.0138F, -0.4597F, -1.316F));

		PartDefinition BiomassTumor11_r1 = BiomassClump4.addOrReplaceChild("BiomassTumor11_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6143F, 0.062F, -0.9256F, -0.22F, -0.1856F, 2.1313F));

		PartDefinition BiomassClump5 = BiomassClumps.addOrReplaceChild("BiomassClump5", CubeListBuilder.create(), PartPose.offset(6.7143F, -38.262F, 6.1256F));

		PartDefinition BiomassTumor15_r1 = BiomassClump5.addOrReplaceChild("BiomassTumor15_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9143F, -3.238F, -0.2256F, 1.7116F, 0.7991F, 1.9719F));

		PartDefinition BiomassTumor14_r1 = BiomassClump5.addOrReplaceChild("BiomassTumor14_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9143F, -0.138F, 0.2744F, 0.8422F, 0.8727F, 0.9513F));

		PartDefinition BiomassTumor13_r1 = BiomassClump5.addOrReplaceChild("BiomassTumor13_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0143F, 2.062F, -1.5256F, 0.3273F, 0.5491F, -0.0829F));

		PartDefinition BiomassClump6 = BiomassClumps.addOrReplaceChild("BiomassClump6", CubeListBuilder.create(), PartPose.offset(10.7143F, -27.362F, 0.3256F));

		PartDefinition BiomassTumor18_r1 = BiomassClump6.addOrReplaceChild("BiomassTumor18_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1857F, -2.538F, -0.2256F, 1.6699F, 0.1489F, 1.8854F));

		PartDefinition BiomassTumor17_r1 = BiomassClump6.addOrReplaceChild("BiomassTumor17_r1", CubeListBuilder.create().texOffs(41, 59).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0857F, 0.862F, 2.2744F, 0.8422F, 0.8727F, 0.9513F));

		PartDefinition BiomassTumor16_r1 = BiomassClump6.addOrReplaceChild("BiomassTumor16_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9857F, 2.062F, -0.5256F, 0.3273F, 0.5491F, -0.0829F));

		PartDefinition BiomassClump7 = BiomassClumps.addOrReplaceChild("BiomassClump7", CubeListBuilder.create(), PartPose.offset(1.0143F, -33.462F, 12.1256F));

		PartDefinition BiomassTumor20_r1 = BiomassClump7.addOrReplaceChild("BiomassTumor20_r1", CubeListBuilder.create().texOffs(42, 60).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0857F, -0.438F, -0.1256F, 0.6813F, -0.2838F, -1.4063F));

		PartDefinition BiomassTumor19_r1 = BiomassClump7.addOrReplaceChild("BiomassTumor19_r1", CubeListBuilder.create().texOffs(40, 59).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2857F, 1.562F, 0.0744F, -0.1647F, -0.236F, 1.8685F));

		PartDefinition BiomassClump8 = BiomassClumps.addOrReplaceChild("BiomassClump8", CubeListBuilder.create(), PartPose.offset(-13.9857F, -26.462F, 1.1256F));

		PartDefinition BiomassTumor22_r1 = BiomassClump8.addOrReplaceChild("BiomassTumor22_r1", CubeListBuilder.create().texOffs(38, 58).addBox(-3.0F, -3.0F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8857F, -1.238F, 0.9744F, 0.4596F, -0.5697F, -1.183F));

		PartDefinition BiomassTumor21_r1 = BiomassClump8.addOrReplaceChild("BiomassTumor21_r1", CubeListBuilder.create().texOffs(36, 57).addBox(-4.0F, -4.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0143F, 2.462F, -2.2256F, -0.3384F, -0.631F, 1.948F));

		PartDefinition Brains = MainBodyBase.addOrReplaceChild("Brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain1 = Brains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(209, 231).addBox(-2.6667F, -4.6F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(180, 241).addBox(0.8333F, -4.6F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-6.4973F, -35.8588F, -12.564F, 1.3526F, 0.0F, -0.1309F));

		PartDefinition Right_r1 = Brain1.addOrReplaceChild("Right_r1", CubeListBuilder.create().texOffs(151, 242).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.6667F, 0.4F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Brain2 = Brains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(29, 237).addBox(-2.6667F, -4.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1026F, -23.8588F, -12.564F, 1.3729F, -0.2129F, -0.2108F));

		PartDefinition Right_r2 = Brain2.addOrReplaceChild("Right_r2", CubeListBuilder.create().texOffs(249, 115).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.6667F, -1.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Brain3 = Brains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(87, 238).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(104, 252).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(81, 252).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-10.6974F, -35.8588F, -2.564F, 1.7336F, 1.1788F, 0.1984F));

		PartDefinition Brain4 = Brains.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(238, 231).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(127, 254).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(150, 256).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-11.9974F, -24.2588F, 7.836F, -2.561F, -0.8516F, 1.0887F));

		PartDefinition Brain5 = Brains.addOrReplaceChild("Brain5", CubeListBuilder.create().texOffs(255, 201).addBox(-3.6667F, -4.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-12.1974F, -21.5588F, -9.164F, 1.3409F, 1.1682F, -0.2883F));

		PartDefinition Brain6 = Brains.addOrReplaceChild("Brain6", CubeListBuilder.create(), PartPose.offsetAndRotation(8.9026F, -35.8588F, -0.064F, 0.6086F, -1.1081F, 0.5363F));

		PartDefinition Right_r3 = Brain6.addOrReplaceChild("Right_r3", CubeListBuilder.create().texOffs(240, 15).addBox(-1.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.6667F, -1.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Left_r1 = Brain6.addOrReplaceChild("Left_r1", CubeListBuilder.create().texOffs(119, 194).addBox(0.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.8333F, -1.0F, 0.0F, 0.0F, 0.0F, 0.4538F));

		PartDefinition Brain7 = Brains.addOrReplaceChild("Brain7", CubeListBuilder.create().texOffs(249, 245).addBox(-3.6667F, -4.6F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(9.8026F, -18.7588F, -5.964F, -0.6564F, -1.1653F, 2.2405F));

		PartDefinition Left_r2 = Brain7.addOrReplaceChild("Left_r2", CubeListBuilder.create().texOffs(29, 251).addBox(0.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.1667F, -1.0F, 1.4F, 0.0F, 0.6109F, 0.0F));

		PartDefinition Brain8 = Brains.addOrReplaceChild("Brain8", CubeListBuilder.create().texOffs(58, 238).addBox(-2.6667F, -7.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.1974F, -17.9588F, 16.236F, 1.3526F, 0.0F, -0.1309F));

		PartDefinition Brain9 = Brains.addOrReplaceChild("Brain9", CubeListBuilder.create().texOffs(0, 233).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(246, 93).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(245, 147).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-6.8974F, -41.9588F, 1.736F, 0.186F, -0.1716F, -0.163F));

		PartDefinition Brain10 = Brains.addOrReplaceChild("Brain10", CubeListBuilder.create(), PartPose.offset(0.6018F, -42.5808F, -6.2333F));

		PartDefinition Left_r3 = Brain10.addOrReplaceChild("Left_r3", CubeListBuilder.create().texOffs(203, 245).addBox(0.0F, -3.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4538F, -0.3142F, 0.0F));

		PartDefinition Center_r1 = Brain10.addOrReplaceChild("Center_r1", CubeListBuilder.create().texOffs(237, 172).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.4538F, -0.3142F, 0.0F));

		PartDefinition ExtraHeads = MainBodyBase.addOrReplaceChild("ExtraHeads", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head2_r1 = ExtraHeads.addOrReplaceChild("Head2_r1", CubeListBuilder.create().texOffs(217, 49).addBox(-2.0165F, -6.8414F, -4.1892F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5443F, -39.2807F, 12.7976F, 0.9659F, 0.1854F, 1.8586F));

		PartDefinition Head1_r1 = ExtraHeads.addOrReplaceChild("Head1_r1", CubeListBuilder.create().texOffs(217, 33).addBox(-2.0165F, -6.8414F, -4.1892F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.4443F, -34.3807F, -12.8024F, -0.3288F, -0.9729F, 2.1681F));

		PartDefinition ClawingBody = MainBodyBase.addOrReplaceChild("ClawingBody", CubeListBuilder.create(), PartPose.offsetAndRotation(7.4809F, -23.6282F, 11.1724F, -2.3041F, 0.639F, -2.0638F));

		PartDefinition ClawingMainBody = ClawingBody.addOrReplaceChild("ClawingMainBody", CubeListBuilder.create(), PartPose.offset(-0.4809F, 7.6282F, -0.1724F));

		PartDefinition Jaw_r1 = ClawingMainBody.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(41, 8).addBox(-6.3584F, 0.3423F, 0.0931F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0316F, -8.5623F, -4.0511F, 0.0459F, 0.0164F, 0.7833F));

		PartDefinition Head_r1 = ClawingMainBody.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(127, 288).addBox(-7.7766F, -6.0189F, -4.5692F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7557F, -8.1807F, 0.6976F, -0.063F, 0.0747F, 1.1675F));

		PartDefinition RightArm_r1 = ClawingMainBody.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(25, 26).addBox(-1.9858F, -1.0665F, -0.6835F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2299F, -5.8616F, 4.3489F, 0.218F, 0.2748F, 2.081F));

		PartDefinition LeftArm_r1 = ClawingMainBody.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(72, 29).addBox(-2.0924F, -0.9669F, -2.2032F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1316F, -7.1623F, -3.5511F, -0.9906F, -0.2071F, -0.7065F));

		PartDefinition BodyMain_r1 = ClawingMainBody.addOrReplaceChild("BodyMain_r1", CubeListBuilder.create().texOffs(24, 25).addBox(-2.4641F, -5.7768F, -3.9F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0295F, -3.5128F, 0.0488F, 0.0F, 0.0F, -0.6545F));

		PartDefinition BodyBase_r1 = ClawingMainBody.addOrReplaceChild("BodyBase_r1", CubeListBuilder.create().texOffs(56, 22).mirror().addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.252F, 2.2349F, 0.6488F, 0.0F, 0.0F, -0.3054F));

		PartDefinition ClawingBiomass = ClawingBody.addOrReplaceChild("ClawingBiomass", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BiomassStrands5_r1 = ClawingBiomass.addOrReplaceChild("BiomassStrands5_r1", CubeListBuilder.create().texOffs(72, 320).addBox(0.0F, -2.5F, -4.0F, 0.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2954F, -5.0964F, -0.0924F, -1.5025F, 0.0538F, 1.0295F));

		PartDefinition BiomassStrands4_r1 = ClawingBiomass.addOrReplaceChild("BiomassStrands4_r1", CubeListBuilder.create().texOffs(70, 318).addBox(0.0F, -2.5F, -5.0F, 0.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7045F, -3.0964F, 5.7076F, -3.0695F, 1.1888F, 0.9573F));

		PartDefinition BiomassStrands3_r1 = ClawingBiomass.addOrReplaceChild("BiomassStrands3_r1", CubeListBuilder.create().texOffs(68, 316).addBox(0.0F, -2.0F, -3.5F, 0.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7347F, -5.0583F, 2.7491F, 1.3569F, -1.0458F, 1.9858F));

		PartDefinition BiomassStrands2_r1 = ClawingBiomass.addOrReplaceChild("BiomassStrands2_r1", CubeListBuilder.create().texOffs(68, 316).addBox(0.0F, -2.0F, -3.5F, 0.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5347F, -6.5583F, 0.7491F, -0.8511F, 1.4087F, -0.6284F));

		PartDefinition BiomassStrands1_r1 = ClawingBiomass.addOrReplaceChild("BiomassStrands1_r1", CubeListBuilder.create().texOffs(58, 325).addBox(0.0F, -2.0F, -3.5F, 0.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9653F, 4.4417F, 5.7491F, -2.3589F, 1.2767F, -1.8286F));

		PartDefinition SearchingBody = MainBodyBase.addOrReplaceChild("SearchingBody", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.119F, -42.6282F, 5.0724F, -2.3041F, 0.6826F, -2.0638F));

		PartDefinition SearchingMainBody = SearchingBody.addOrReplaceChild("SearchingMainBody", CubeListBuilder.create(), PartPose.offset(0.4445F, 1.1688F, -0.7911F));

		PartDefinition Jaw_r2 = SearchingMainBody.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(167, 303).addBox(-6.8116F, -1.532F, -4.3061F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6627F, -8.2071F, -0.7787F, 0.5306F, 0.161F, 0.5433F));

		PartDefinition Head_r2 = SearchingMainBody.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(164, 288).addBox(-7.488F, -5.8778F, -4.92F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4557F, -9.7807F, -1.6024F, 0.3035F, 0.0747F, 1.1675F));

		PartDefinition RightArm_r2 = SearchingMainBody.addOrReplaceChild("RightArm_r2", CubeListBuilder.create().texOffs(94, 321).addBox(-1.7135F, -0.426F, 0.3872F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5299F, -8.7616F, 2.6489F, 0.0756F, -0.1991F, 1.5867F));

		PartDefinition LeftArm_r2 = SearchingMainBody.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(112, 321).addBox(-0.9782F, -0.4368F, -2.3825F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6684F, -7.5624F, -4.3511F, -1.3766F, 1.3374F, -0.7729F));

		PartDefinition BodyMain_r2 = SearchingMainBody.addOrReplaceChild("BodyMain_r2", CubeListBuilder.create().texOffs(137, 307).addBox(-2.5072F, -5.2535F, -4.1444F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6295F, -5.1128F, 0.2489F, 0.2236F, 0.0391F, 0.2662F));

		PartDefinition BodyBase_r2 = SearchingMainBody.addOrReplaceChild("BodyBase_r2", CubeListBuilder.create().texOffs(56, 22).mirror().addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.348F, -0.3651F, 0.6489F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Tongue = SearchingMainBody.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(132, 323).addBox(-2.7152F, -0.8841F, -5.0212F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8654F, -10.5843F, -0.9487F, -1.9708F, -1.2004F, -0.4425F));

		PartDefinition Tongue2 = Tongue.addOrReplaceChild("Tongue2", CubeListBuilder.create().texOffs(163, 318).addBox(-1.5876F, -0.4918F, -6.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6276F, -0.3923F, -5.0212F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tongue3 = Tongue2.addOrReplaceChild("Tongue3", CubeListBuilder.create().texOffs(185, 317).addBox(-1.0876F, -0.4918F, -5.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition SearchingBiomass = SearchingBody.addOrReplaceChild("SearchingBiomass", CubeListBuilder.create(), PartPose.offset(1.9254F, -16.4593F, -0.6187F));

		PartDefinition BiomassStrands6_r1 = SearchingBiomass.addOrReplaceChild("BiomassStrands6_r1", CubeListBuilder.create().texOffs(-4, -4).addBox(0.0F, -4.0F, -3.0F, 0.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5479F, 11.525F, 4.8683F, 1.763F, -1.3699F, -1.0877F));

		PartDefinition PetalCrown3 = SearchingBody.addOrReplaceChild("PetalCrown3", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5495F, -17.2445F, 1.2992F, -0.1451F, 0.0972F, 0.5688F));

		PartDefinition Petal5_r1 = PetalCrown3.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(258, 8).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, 0.0436F, 0.0F, -0.4363F));

		PartDefinition Petal4_r1 = PetalCrown3.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(267, 238).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6176F, 0.7318F, -2.4F, 0.004F, -0.0924F, 0.2518F));

		PartDefinition Petal3_r1 = PetalCrown3.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(102, 266).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.9F, -6.6F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r1 = PetalCrown3.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(25, 265).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.436F, 0.0184F, -0.0395F));

		PartDefinition Foliage = HivetumorBody.addOrReplaceChild("Foliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition PetalCrowns = Foliage.addOrReplaceChild("PetalCrowns", CubeListBuilder.create(), PartPose.offset(14.1391F, 16.122F, 0.5F));

		PartDefinition PetalCrown1 = PetalCrowns.addOrReplaceChild("PetalCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.495F, -44.4134F, 11.2903F, -0.1745F, -0.003F, -0.0348F));

		PartDefinition Petal4_r2 = PetalCrown1.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(258, 8).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, 0.0436F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = PetalCrown1.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(267, 238).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6176F, 0.7319F, -2.4F, 0.004F, -0.0924F, 0.2518F));

		PartDefinition Petal2_r2 = PetalCrown1.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(102, 266).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.9F, -6.6F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = PetalCrown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(25, 265).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.436F, 0.0184F, -0.0395F));

		PartDefinition PetalCrown2 = PetalCrowns.addOrReplaceChild("PetalCrown2", CubeListBuilder.create(), PartPose.offset(7.605F, -43.6134F, -8.8097F));

		PartDefinition Petal4_r3 = PetalCrown2.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(173, 263).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, 0.7F, -3.0F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r3 = PetalCrown2.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(267, 231).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7176F, 1.3319F, -3.0F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r3 = PetalCrown2.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(263, 15).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 0.6F, -4.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = PetalCrown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(267, 65).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition SparseFoliage = Foliage.addOrReplaceChild("SparseFoliage", CubeListBuilder.create(), PartPose.offset(0.0391F, -1.228F, -15.45F));

		PartDefinition Foliage10_r1 = SparseFoliage.addOrReplaceChild("Foliage10_r1", CubeListBuilder.create().texOffs(255, 223).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, 0.0F, 1.2F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage9_r1 = SparseFoliage.addOrReplaceChild("Foliage9_r1", CubeListBuilder.create().texOffs(255, 215).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -0.8F, 15.1F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage8_r1 = SparseFoliage.addOrReplaceChild("Foliage8_r1", CubeListBuilder.create().texOffs(250, 57).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.7F, -9.2F, -0.1F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage7_r1 = SparseFoliage.addOrReplaceChild("Foliage7_r1", CubeListBuilder.create().texOffs(0, 247).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -3.2F, 11.1F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage6_r1 = SparseFoliage.addOrReplaceChild("Foliage6_r1", CubeListBuilder.create().texOffs(0, 255).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -15.7F, 23.1F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage5_r1 = SparseFoliage.addOrReplaceChild("Foliage5_r1", CubeListBuilder.create().texOffs(249, 107).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2F, -15.5F, 29.1F, -0.0649F, -0.11F, -0.145F));

		PartDefinition Foliage4_r1 = SparseFoliage.addOrReplaceChild("Foliage4_r1", CubeListBuilder.create().texOffs(52, 252).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.1F, -12.3F, 7.0F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Foliage3_r1 = SparseFoliage.addOrReplaceChild("Foliage3_r1", CubeListBuilder.create().texOffs(152, 67).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.3F, -24.5F, 13.8F, -2.219F, -1.3003F, -2.0183F));

		PartDefinition Foliage2_r1 = SparseFoliage.addOrReplaceChild("Foliage2_r1", CubeListBuilder.create().texOffs(181, 67).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.9F, -23.7F, 27.7F, -0.4366F, -0.6812F, -2.5711F));

		PartDefinition Foliage1_r1 = SparseFoliage.addOrReplaceChild("Foliage1_r1", CubeListBuilder.create().texOffs(245, 161).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.8F, -26.7F, 7.9F, 2.2163F, -1.2993F, -0.1348F));

		PartDefinition FungalBloom = Foliage.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(4.9859F, -30.3582F, -9.7493F, 0.1653F, -0.1366F, -0.1752F));

		PartDefinition BloomFoliage2_r1 = FungalBloom.addOrReplaceChild("BloomFoliage2_r1", CubeListBuilder.create().texOffs(90, 194).addBox(-11.8501F, -13.8001F, -7.6583F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7533F, 5.5803F, -5.5924F, 0.0F, 0.7854F, 0.0F));

		PartDefinition BloomFoliage1_r1 = FungalBloom.addOrReplaceChild("BloomFoliage1_r1", CubeListBuilder.create().texOffs(168, 200).addBox(-0.8501F, -13.8001F, 5.3417F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7533F, 5.5803F, -5.5924F, 0.0F, -0.7854F, 0.0F));

		PartDefinition WestPetal_r1 = FungalBloom.addOrReplaceChild("WestPetal_r1", CubeListBuilder.create().texOffs(148, 109).addBox(1.1499F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0033F, 5.5803F, -6.0924F, 0.0F, 0.0F, -0.3927F));

		PartDefinition EastPetal_r1 = FungalBloom.addOrReplaceChild("EastPetal_r1", CubeListBuilder.create().texOffs(148, 92).addBox(-17.8501F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9967F, 4.5803F, -6.0924F, 0.0F, 0.0F, 0.3927F));

		PartDefinition SouthPetal_r1 = FungalBloom.addOrReplaceChild("SouthPetal_r1", CubeListBuilder.create().texOffs(152, 33).addBox(-16.8501F, -0.8001F, 2.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0033F, 5.5803F, 1.9076F, 0.3927F, 0.0F, 0.0F));

		PartDefinition NorthPetal_r1 = FungalBloom.addOrReplaceChild("NorthPetal_r1", CubeListBuilder.create().texOffs(152, 50).addBox(-16.8501F, -0.8001F, -17.6583F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0033F, 5.5803F, 1.9076F, -0.3927F, 0.0F, 0.0F));

		PartDefinition TumorStick = HivetumorBody.addOrReplaceChild("TumorStick", CubeListBuilder.create(), PartPose.offset(21.4249F, -15.8557F, -5.5F));

		PartDefinition StickBase_r1 = TumorStick.addOrReplaceChild("StickBase_r1", CubeListBuilder.create().texOffs(74, 195).addBox(-2.0F, -20.0F, -1.0F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3155F, 0.3318F, 0.7863F));

		PartDefinition StickEnd = TumorStick.addOrReplaceChild("StickEnd", CubeListBuilder.create(), PartPose.offsetAndRotation(22.7032F, -1.5104F, -3.6791F, 0.0F, -1.0036F, 0.0F));

		PartDefinition StickEnd_r1 = StickEnd.addOrReplaceChild("StickEnd_r1", CubeListBuilder.create().texOffs(218, 259).addBox(-2.0F, -16.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-8.7032F, -14.2896F, 8.3791F, 0.4952F, -0.2277F, 2.4206F));

		PartDefinition Tumors = StickEnd.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(-2.3F, 0.0F, 0.7F));

		PartDefinition Tumor6_r1 = Tumors.addOrReplaceChild("Tumor6_r1", CubeListBuilder.create().texOffs(127, 268).addBox(-2.641F, -3.7505F, -1.5356F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0033F, 0.1795F, -0.2698F));

		PartDefinition Tumor5_r1 = Tumors.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(161, 270).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4727F, -4.529F, -0.0566F, -0.065F, 0.1674F, -0.624F));

		PartDefinition Tumor4_r1 = Tumors.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(231, 266).addBox(-2.1541F, -4.1761F, -2.2588F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1447F, 0.6696F, 0.4163F));

		PartDefinition Tumor3_r1 = Tumors.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(136, 33).addBox(-2.828F, -0.5697F, -1.8499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, 1.8F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor2_r1 = Tumors.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(116, 238).addBox(-2.641F, -3.7505F, -1.5356F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, 1.8F, -0.0909F, -0.0967F, -0.2541F));

		PartDefinition Tumor1_r1 = Tumors.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(50, 267).addBox(-2.1541F, -4.1761F, -2.2588F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.2F, 1.8F, -0.4203F, 0.4928F, 0.2831F));

		PartDefinition Face = HivetumorBody.addOrReplaceChild("Face", CubeListBuilder.create(), PartPose.offset(14.1391F, 16.122F, 0.5F));

		PartDefinition Eye = Face.addOrReplaceChild("Eye", CubeListBuilder.create(), PartPose.offset(-4.7924F, -11.9743F, -16.0F));

		PartDefinition EyeMain_r1 = Eye.addOrReplaceChild("EyeMain_r1", CubeListBuilder.create().texOffs(216, 130).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0509F, 0.4511F, -0.1164F));

		PartDefinition Pupil = Eye.addOrReplaceChild("Pupil", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -2.0F));

		PartDefinition Pupil_r1 = Pupil.addOrReplaceChild("Pupil_r1", CubeListBuilder.create().texOffs(278, 199).addBox(-2.5F, -6.5F, -2.75F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, -0.0509F, 0.4511F, -0.1164F));

		PartDefinition Jaws = Face.addOrReplaceChild("Jaws", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition UpperJaw = Jaws.addOrReplaceChild("UpperJaw", CubeListBuilder.create(), PartPose.offset(-4.4192F, -24.5848F, -16.9167F));

		PartDefinition UpperCenterHead_r1 = UpperJaw.addOrReplaceChild("UpperCenterHead_r1", CubeListBuilder.create().texOffs(225, 0).addBox(-5.5F, -3.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.0087F));

		PartDefinition UpperRightHead = UpperJaw.addOrReplaceChild("UpperRightHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition UpperRightHeadTeeth_r1 = UpperRightHead.addOrReplaceChild("UpperRightHeadTeeth_r1", CubeListBuilder.create().texOffs(216, 147).addBox(-4.0F, 0.6F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
				.texOffs(226, 186).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-7.3865F, 2.6487F, -1.2393F, 0.1309F, 0.0F, -0.384F));

		PartDefinition LowerJaw = Jaws.addOrReplaceChild("LowerJaw", CubeListBuilder.create(), PartPose.offset(-4.4192F, -6.9848F, -16.9167F));

		PartDefinition LowerCenterHead_r1 = LowerJaw.addOrReplaceChild("LowerCenterHead_r1", CubeListBuilder.create().texOffs(33, 222).addBox(-5.5F, -3.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.6F, -0.1833F, 0.0F, 0.0087F));

		PartDefinition BrokenCoolingSystem = HivetumorBody.addOrReplaceChild("BrokenCoolingSystem", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.8441F, -9.0068F, 2.7558F, -0.0448F, 0.2826F, -0.5177F));

		PartDefinition LowerRidge_r1 = BrokenCoolingSystem.addOrReplaceChild("LowerRidge_r1", CubeListBuilder.create().texOffs(136, 225).addBox(-1.5F, -6.5F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1129F, 17.3074F, -0.1671F, 0.0F, 0.0F, -0.48F));

		PartDefinition UpperHinge = BrokenCoolingSystem.addOrReplaceChild("UpperHinge", CubeListBuilder.create(), PartPose.offset(0.8928F, -6.2178F, -7.377F));

		PartDefinition UpperMembrane_r1 = UpperHinge.addOrReplaceChild("UpperMembrane_r1", CubeListBuilder.create().texOffs(213, 67).addBox(0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5127F, 5.4622F, 5.4098F, -0.1281F, -0.3112F, 0.048F));

		PartDefinition UpperRightRidgeTip_r1 = UpperHinge.addOrReplaceChild("UpperRightRidgeTip_r1", CubeListBuilder.create().texOffs(259, 186).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7327F, -1.8378F, -7.3647F, 0.0F, -0.6981F, 0.0F));

		PartDefinition UpperRightRidge_r1 = UpperHinge.addOrReplaceChild("UpperRightRidge_r1", CubeListBuilder.create().texOffs(105, 221).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3127F, -1.8378F, 6.2098F, 0.0F, -0.3491F, 0.0F));

		PartDefinition UpperRidge_r1 = UpperHinge.addOrReplaceChild("UpperRidge_r1", CubeListBuilder.create().texOffs(203, 259).addBox(-2.0F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.7222F, 6.6752F, 7.2098F, 0.0F, 0.0F, 0.2967F));

		PartDefinition MiddleHinge = BrokenCoolingSystem.addOrReplaceChild("MiddleHinge", CubeListBuilder.create(), PartPose.offset(23.9832F, 26.1288F, -2.2558F));

		PartDefinition MiddleMembrane_r1 = MiddleHinge.addOrReplaceChild("MiddleMembrane_r1", CubeListBuilder.create().texOffs(143, 190).addBox(0.0F, -11.0F, 0.0F, 0.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.9031F, -13.4843F, 4.0887F, 0.0298F, 0.431F, -0.1844F));

		PartDefinition MiddleLeftRidgeTip_r1 = MiddleHinge.addOrReplaceChild("MiddleLeftRidgeTip_r1", CubeListBuilder.create().texOffs(119, 208).addBox(-0.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.3577F, -24.1843F, 17.1633F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleLeftRidge_r1 = MiddleHinge.addOrReplaceChild("MiddleLeftRidge_r1", CubeListBuilder.create().texOffs(74, 221).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.2031F, -24.1843F, 3.5887F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidge_r1 = MiddleHinge.addOrReplaceChild("MiddleRidge_r1", CubeListBuilder.create().texOffs(136, 225).addBox(-1.5F, -6.0F, -2.0F, 3.0F, 13.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-28.139F, -20.4505F, 2.0887F, 0.0F, 0.0F, -0.0175F));

		PartDefinition Roots = HivetumorBody.addOrReplaceChild("Roots", CubeListBuilder.create(), PartPose.offset(14.1391F, 16.122F, 0.5F));

		PartDefinition Root1 = Roots.addOrReplaceChild("Root1", CubeListBuilder.create(), PartPose.offset(1.479F, -34.5387F, -11.3395F));

		PartDefinition Root1Base_r1 = Root1.addOrReplaceChild("Root1Base_r1", CubeListBuilder.create().texOffs(273, 41).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2047F, -1.567F, -1.4713F, 0.2793F, -0.3665F, 0.0F));

		PartDefinition Root1Mid = Root1.addOrReplaceChild("Root1Mid", CubeListBuilder.create(), PartPose.offset(1.0F, -8.0F, -3.0F));

		PartDefinition Root1MidPart_r1 = Root1Mid.addOrReplaceChild("Root1MidPart_r1", CubeListBuilder.create().texOffs(272, 128).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5185F, -1.1303F, -1.1858F, 0.7854F, -0.576F, 0.0F));

		PartDefinition Root1End = Root1Mid.addOrReplaceChild("Root1End", CubeListBuilder.create(), PartPose.offset(3.5F, -7.0F, -5.75F));

		PartDefinition Root1EndPart_r1 = Root1End.addOrReplaceChild("Root1EndPart_r1", CubeListBuilder.create().texOffs(37, 197).addBox(0.0F, -8.0F, 0.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -0.25F, -0.384F, -0.6807F, 0.0F));

		PartDefinition Root2 = Roots.addOrReplaceChild("Root2", CubeListBuilder.create(), PartPose.offset(11.479F, -11.5387F, 5.0605F));

		PartDefinition Root2Base_r1 = Root2.addOrReplaceChild("Root2Base_r1", CubeListBuilder.create().texOffs(272, 245).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0953F, -1.2669F, -0.7713F, 0.6458F, -0.0698F, 0.6807F));

		PartDefinition Root2Mid = Root2.addOrReplaceChild("Root2Mid", CubeListBuilder.create(), PartPose.offset(3.25F, -5.0F, -4.25F));

		PartDefinition Root2MidPart_r1 = Root2Mid.addOrReplaceChild("Root2MidPart_r1", CubeListBuilder.create().texOffs(272, 115).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.3685F, 0.0697F, -0.5358F, 0.2232F, -0.3654F, 1.5163F));

		PartDefinition Root2End = Root2Mid.addOrReplaceChild("Root2End", CubeListBuilder.create(), PartPose.offset(9.0F, 0.25F, -2.5F));

		PartDefinition Root2EndPart_r1 = Root2End.addOrReplaceChild("Root2EndPart_r1", CubeListBuilder.create().texOffs(37, 209).addBox(0.0F, -8.0F, 0.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.75F, -0.75F, 0.3853F, -0.0809F, 2.3758F));

		PartDefinition Root3 = Roots.addOrReplaceChild("Root3", CubeListBuilder.create(), PartPose.offset(-5.321F, -25.6387F, 13.1605F));

		PartDefinition Root3Base_r1 = Root3.addOrReplaceChild("Root3Base_r1", CubeListBuilder.create().texOffs(71, 273).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1953F, 0.233F, -0.3713F, -0.7918F, 0.1501F, 0.1466F));

		PartDefinition Root3Mid = Root3.addOrReplaceChild("Root3Mid", CubeListBuilder.create(), PartPose.offset(1.0F, -4.0F, 4.0F));

		PartDefinition Root3MidPart_r1 = Root3Mid.addOrReplaceChild("Root3MidPart_r1", CubeListBuilder.create().texOffs(215, 186).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.9185F, -1.0303F, 1.2142F, -0.7761F, 0.1353F, 0.4682F));

		PartDefinition Root3End = Root3Mid.addOrReplaceChild("Root3End", CubeListBuilder.create(), PartPose.offset(4.0F, -5.0F, 6.0F));

		PartDefinition Root3EndPart_r1 = Root3End.addOrReplaceChild("Root3EndPart_r1", CubeListBuilder.create().texOffs(90, 172).addBox(0.0F, -8.0F, 0.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.5238F, -0.5624F, 0.4901F));

		PartDefinition Root4 = Roots.addOrReplaceChild("Root4", CubeListBuilder.create(), PartPose.offset(-17.971F, -38.7387F, 1.9605F));

		PartDefinition Root4Base_r1 = Root4.addOrReplaceChild("Root4Base_r1", CubeListBuilder.create().texOffs(273, 29).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9547F, 4.733F, 0.4287F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Root4Mid = Root4.addOrReplaceChild("Root4Mid", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.25F));

		PartDefinition Root4MidPart_r1 = Root4Mid.addOrReplaceChild("Root4MidPart_r1", CubeListBuilder.create().texOffs(34, 272).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.1315F, -0.0303F, 0.0642F, 0.0F, 0.0F, -1.4312F));

		PartDefinition Root4End = Root4Mid.addOrReplaceChild("Root4End", CubeListBuilder.create(), PartPose.offset(-8.75F, -1.0F, 0.25F));

		PartDefinition Root4EndPart_r1 = Root4End.addOrReplaceChild("Root4EndPart_r1", CubeListBuilder.create().texOffs(86, 116).addBox(0.0F, -8.0F, 0.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -1.0F, -0.5F, 0.0F, 0.0F, -0.733F));

		PartDefinition TumorBase = Hivetumor.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-21.595F, -7.8134F, -14.8097F));

		PartDefinition TumorGroup1 = TumorBase.addOrReplaceChild("TumorGroup1", CubeListBuilder.create(), PartPose.offset(23.0F, 8.0F, 15.0F));

		PartDefinition Tumor4_r2 = TumorGroup1.addOrReplaceChild("Tumor4_r2", CubeListBuilder.create().texOffs(0, 151).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3253F, -2.7014F, 10.0691F, 0.1801F, 0.3913F, 0.0164F));

		PartDefinition Tumor3_r2 = TumorGroup1.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(98, 171).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3836F, -3.8147F, 3.1013F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor2_r2 = TumorGroup1.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(163, 126).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.1937F, -2.5585F, -3.4818F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor1_r2 = TumorGroup1.addOrReplaceChild("Tumor1_r2", CubeListBuilder.create().texOffs(91, 108).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.595F, -7.1866F, -6.1903F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition TumorGroup2 = TumorBase.addOrReplaceChild("TumorGroup2", CubeListBuilder.create(), PartPose.offset(13.0F, 9.0F, 6.0F));

		PartDefinition Tumor8_r1 = TumorGroup2.addOrReplaceChild("Tumor8_r1", CubeListBuilder.create().texOffs(216, 113).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7212F, -2.573F, -6.6951F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Tumor7_r1 = TumorGroup2.addOrReplaceChild("Tumor7_r1", CubeListBuilder.create().texOffs(208, 153).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.254F, -3.5124F, -4.2295F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Tumor6_r2 = TumorGroup2.addOrReplaceChild("Tumor6_r2", CubeListBuilder.create().texOffs(226, 216).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.3288F, -3.6207F, -0.7522F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Tumor5_r2 = TumorGroup2.addOrReplaceChild("Tumor5_r2", CubeListBuilder.create().texOffs(0, 174).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1919F, -3.7014F, 0.3433F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition TumorGroup3 = TumorBase.addOrReplaceChild("TumorGroup3", CubeListBuilder.create(), PartPose.offset(40.0F, 0.0F, 12.0F));

		PartDefinition Tumor13_r1 = TumorGroup3.addOrReplaceChild("Tumor13_r1", CubeListBuilder.create().texOffs(151, 227).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.9288F, 5.3793F, 1.9478F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Tumor12_r1 = TumorGroup3.addOrReplaceChild("Tumor12_r1", CubeListBuilder.create().texOffs(213, 96).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.3212F, 6.427F, -4.9951F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Tumor11_r1 = TumorGroup3.addOrReplaceChild("Tumor11_r1", CubeListBuilder.create().texOffs(163, 153).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7919F, 5.2986F, 3.0433F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition Tumor10_r1 = TumorGroup3.addOrReplaceChild("Tumor10_r1", CubeListBuilder.create().texOffs(49, 116).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.046F, 5.4876F, -4.2295F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Tumor9_r1 = TumorGroup3.addOrReplaceChild("Tumor9_r1", CubeListBuilder.create().texOffs(207, 17).addBox(-2.5F, -2.75F, -4.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-19.8706F, -0.3505F, -10.407F, -0.1299F, 0.0159F, 0.1648F));

		PartDefinition TumorGroup4 = TumorBase.addOrReplaceChild("TumorGroup4", CubeListBuilder.create(), PartPose.offset(20.0F, 0.0F, 28.0F));

		PartDefinition Tumor16_r1 = TumorGroup4.addOrReplaceChild("Tumor16_r1", CubeListBuilder.create().texOffs(0, 216).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.204F, 6.427F, 5.1074F, 0.0F, -0.5236F, 0.3491F));

		PartDefinition Tumor15_r1 = TumorGroup4.addOrReplaceChild("Tumor15_r1", CubeListBuilder.create().texOffs(0, 197).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0712F, 5.4876F, 4.3418F, -0.3699F, -0.7124F, 0.2154F));

		PartDefinition Tumor14_r1 = TumorGroup4.addOrReplaceChild("Tumor14_r1", CubeListBuilder.create().texOffs(91, 44).addBox(-10.0F, -10.0F, -5.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.405F, 8.8134F, -7.1903F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition TumorGroup5 = TumorBase.addOrReplaceChild("TumorGroup5", CubeListBuilder.create(), PartPose.offset(24.8116F, 5.3793F, 26.1645F));

		PartDefinition Tumor18_r1 = TumorGroup5.addOrReplaceChild("Tumor18_r1", CubeListBuilder.create().texOffs(178, 132).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1987F, 0.4755F, 0.1473F));

		PartDefinition Tumor17_r1 = TumorGroup5.addOrReplaceChild("Tumor17_r1", CubeListBuilder.create().texOffs(45, 172).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.572F, -0.194F, -0.0633F, 0.2065F, -0.2714F, 1.1548F));

		PartDefinition Ribs = TumorBase.addOrReplaceChild("Ribs", CubeListBuilder.create(), PartPose.offset(78.595F, 7.8134F, 50.8097F));

		PartDefinition FrontRibs = Ribs.addOrReplaceChild("FrontRibs", CubeListBuilder.create(), PartPose.offsetAndRotation(-44.0F, 0.0F, -60.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition ribJoint = FrontRibs.addOrReplaceChild("ribJoint", CubeListBuilder.create(), PartPose.offset(-0.2113F, -3.2914F, 2.7578F));

		PartDefinition Rib1 = ribJoint.addOrReplaceChild("Rib1", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.2618F, 0.0F));

		PartDefinition Rib1Seg2 = Rib1.addOrReplaceChild("Rib1Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition ribJoint2 = FrontRibs.addOrReplaceChild("ribJoint2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -6.0F, 11.0F, 0.0873F, -0.1309F, 0.0F));

		PartDefinition Rib2 = ribJoint2.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7887F, 1.7086F, -0.2422F, 0.8737F, 0.721F, 0.024F));

		PartDefinition Rib2Seg2 = Rib2.addOrReplaceChild("Rib2Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition ribJoint3 = FrontRibs.addOrReplaceChild("ribJoint3", CubeListBuilder.create(), PartPose.offset(-22.2113F, -3.2914F, 17.7578F));

		PartDefinition Rib3 = ribJoint3.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 1.0F, 1.6382F, 0.7753F, 0.3129F));

		PartDefinition Rib3Seg2 = Rib3.addOrReplaceChild("Rib3Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-0.9987F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition BackRibs = Ribs.addOrReplaceChild("BackRibs", CubeListBuilder.create(), PartPose.offset(-72.0F, 0.0F, -7.0F));

		PartDefinition ribJoint4 = BackRibs.addOrReplaceChild("ribJoint4", CubeListBuilder.create(), PartPose.offsetAndRotation(5.7887F, -5.2914F, -14.2422F, 0.3054F, -0.9163F, 0.0F));

		PartDefinition Rib4 = ribJoint4.addOrReplaceChild("Rib4", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -1.2796F, 0.5138F, 0.077F));

		PartDefinition Rib4Seg2 = Rib4.addOrReplaceChild("Rib4Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition ribJoint5 = BackRibs.addOrReplaceChild("ribJoint5", CubeListBuilder.create(), PartPose.offsetAndRotation(12.7887F, -3.2914F, -11.2422F, 0.0F, -0.6545F, 0.0F));

		PartDefinition Rib5 = ribJoint5.addOrReplaceChild("Rib5", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -0.8737F, 0.721F, -0.024F));

		PartDefinition Rib5Seg2 = Rib5.addOrReplaceChild("Rib5Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition ribJoint6 = BackRibs.addOrReplaceChild("ribJoint6", CubeListBuilder.create(), PartPose.offset(19.7887F, -4.2914F, -14.2422F));

		PartDefinition Rib6 = ribJoint6.addOrReplaceChild("Rib6", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5775F, 0.0F, -0.5157F, -1.6382F, 0.7753F, -0.3129F));

		PartDefinition Rib6Seg2 = Rib6.addOrReplaceChild("Rib6Seg2", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.8727F, 0.0F, 0.0F));

		PartDefinition LeftRibs = Ribs.addOrReplaceChild("LeftRibs", CubeListBuilder.create(), PartPose.offset(-57.0F, 0.0F, -36.0F));

		PartDefinition ribJoint7 = LeftRibs.addOrReplaceChild("ribJoint7", CubeListBuilder.create(), PartPose.offset(20.2887F, -5.6914F, 1.7578F));

		PartDefinition Rib7 = ribJoint7.addOrReplaceChild("Rib7", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -1.3531F, 1.0133F, 0.3947F));

		PartDefinition Rib6Seg3 = Rib7.addOrReplaceChild("Rib6Seg3", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0873F, 0.116F, -0.0607F));

		PartDefinition ribJoint8 = LeftRibs.addOrReplaceChild("ribJoint8", CubeListBuilder.create(), PartPose.offsetAndRotation(17.8887F, -4.6914F, -10.4422F, -0.7143F, 1.014F, -0.7213F));

		PartDefinition Rib8 = ribJoint8.addOrReplaceChild("Rib8", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4225F, 0.0F, 0.4843F, -1.3531F, 1.0133F, 0.3947F));

		PartDefinition Rib6Seg4 = Rib8.addOrReplaceChild("Rib6Seg4", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0873F, 0.116F, -0.0607F));

		PartDefinition RightRibs = Ribs.addOrReplaceChild("RightRibs", CubeListBuilder.create(), PartPose.offset(-106.0F, 0.0F, -36.0F));

		PartDefinition ribJoint10 = RightRibs.addOrReplaceChild("ribJoint10", CubeListBuilder.create(), PartPose.offsetAndRotation(31.4701F, -4.91F, -10.6075F, 3.1336F, -0.4375F, -2.6012F));

		PartDefinition Rib10 = ribJoint10.addOrReplaceChild("Rib10", CubeListBuilder.create().texOffs(67, 341).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.3531F, 1.0133F, 0.3947F));

		PartDefinition Rib6Seg6 = Rib10.addOrReplaceChild("Rib6Seg6", CubeListBuilder.create().texOffs(19, 344).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 1.0873F, 0.116F, -0.0607F));

		PartDefinition MainTendril = Hivetumor.addOrReplaceChild("MainTendril", CubeListBuilder.create(), PartPose.offsetAndRotation(11.4336F, 0.0F, -19.3512F, 0.0F, 0.7854F, 0.0F));

		PartDefinition BiomassBaseT3 = MainTendril.addOrReplaceChild("BiomassBaseT3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass_r1 = BiomassBaseT3.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(5, 155).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9926F, -2.3258F, 0.612F, 0.3699F, 0.7124F, 0.2154F));

		PartDefinition Biomass_r2 = BiomassBaseT3.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(107, 120).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8902F, -2.4341F, 6.7892F, -0.1987F, -0.4755F, 0.1473F));

		PartDefinition Biomass_r3 = BiomassBaseT3.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(104, 117).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2826F, -1.3864F, -0.1536F, 0.0F, 0.5236F, 0.3491F));

		PartDefinition Biomass_r4 = BiomassBaseT3.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(167, 128).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2467F, -2.5148F, 7.8847F, -0.1801F, -0.3913F, 0.0164F));

		PartDefinition T3Body1 = MainTendril.addOrReplaceChild("T3Body1", CubeListBuilder.create().texOffs(0, 286).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -5.0F, 4.0F));

		PartDefinition Arm_r1 = T3Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 301).addBox(-4.0953F, -1.6721F, -5.8679F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 318).addBox(-4.5953F, -2.4221F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0953F, -8.0779F, -2.6321F, 0.0F, 0.0F, 0.3054F));

		PartDefinition T3Body2 = T3Body1.addOrReplaceChild("T3Body2", CubeListBuilder.create().texOffs(21, 295).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9145F, -9.7651F, 0.0F, -0.1739F, -0.1594F, 0.6532F));

		PartDefinition Arm_r2 = T3Body2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(0, 301).addBox(-1.6527F, -2.0304F, 0.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0835F, -7.7973F, 3.5F, 0.0F, 0.0F, 0.1745F));

		PartDefinition BodyTop_r1 = T3Body2.addOrReplaceChild("BodyTop_r1", CubeListBuilder.create().texOffs(28, 309).addBox(-2.5359F, -5.7768F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3775F, -4.7477F, 2.5F, 0.0F, 0.0F, 0.6545F));

		PartDefinition T3Body3 = T3Body2.addOrReplaceChild("T3Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.1385F, -8.7993F, 0.0F, -3.1416F, 0.0F, -2.3998F));

		PartDefinition T3Body3TorsoFungus = T3Body3.addOrReplaceChild("T3Body3TorsoFungus", CubeListBuilder.create(), PartPose.offset(0.4541F, -6.2749F, -1.9964F));

		PartDefinition T3Body4 = T3Body3.addOrReplaceChild("T3Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5203F, -2.6136F, -0.0122F, 3.1416F, 0.0F, -0.7418F));

		PartDefinition BodyTop_r2 = T3Body4.addOrReplaceChild("BodyTop_r2", CubeListBuilder.create().texOffs(81, 288).addBox(-4.1398F, -10.954F, -1.8679F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3377F, 2.2372F, -1.6443F, 0.0F, 0.0F, 1.5272F));

		PartDefinition BodyBase_r3 = T3Body4.addOrReplaceChild("BodyBase_r3", CubeListBuilder.create().texOffs(109, 304).addBox(-2.0953F, -5.9221F, -1.3679F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3377F, 2.2372F, -1.6443F, 0.0F, 0.0F, 1.2217F));

		PartDefinition T3Body4Ribs = T3Body4.addOrReplaceChild("T3Body4Ribs", CubeListBuilder.create(), PartPose.offset(-0.479F, -0.8934F, -0.7121F));

		PartDefinition T3Rib2 = T3Body4Ribs.addOrReplaceChild("T3Rib2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 1.5F, 1.5F, -0.0742F, 0.1934F, 0.2385F));

		PartDefinition Rib2Seg1_r1 = T3Rib2.addOrReplaceChild("Rib2Seg1_r1", CubeListBuilder.create().texOffs(0, 336).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5F, 1.0F, -1.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib3 = T3Body4Ribs.addOrReplaceChild("T3Rib3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6906F, 3.2309F, -1.1039F, -0.3824F, 0.3533F, 0.0094F));

		PartDefinition Rib3Seg1_r1 = T3Rib3.addOrReplaceChild("Rib3Seg1_r1", CubeListBuilder.create().texOffs(0, 340).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.2043F, -0.165F, -0.0699F, -0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib3Seg2 = T3Rib3.addOrReplaceChild("T3Rib3Seg2", CubeListBuilder.create(), PartPose.offset(0.1943F, 3.5564F, -2.6833F));

		PartDefinition Rib3Seg2_r1 = T3Rib3Seg2.addOrReplaceChild("Rib3Seg2_r1", CubeListBuilder.create().texOffs(0, 337).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.3681F, 0.7588F, -1.2217F, 0.0F, 0.0F));

		PartDefinition T3Rib3Seg3 = T3Rib3Seg2.addOrReplaceChild("T3Rib3Seg3", CubeListBuilder.create(), PartPose.offset(0.02F, 1.9986F, -6.092F));

		PartDefinition T3Rib4 = T3Body4Ribs.addOrReplaceChild("T3Rib4", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.898F, 2.5756F, 3.4406F, 0.3881F, -0.2241F, 0.0958F));

		PartDefinition Rib4Seg1_r1 = T3Rib4.addOrReplaceChild("Rib4Seg1_r1", CubeListBuilder.create().texOffs(0, 336).mirror().addBox(-1.0F, -1.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.3155F, -0.4289F, -0.5503F, 0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib5 = T3Body4Ribs.addOrReplaceChild("T3Rib5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 2.25F, 5.25F, 0.3999F, -0.1789F, 0.0275F));

		PartDefinition Rib5Seg1_r1 = T3Rib5.addOrReplaceChild("Rib5Seg1_r1", CubeListBuilder.create().texOffs(0, 340).mirror().addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-0.1349F, 0.449F, 0.0811F, 0.5236F, 0.0F, 0.0F));

		PartDefinition T3Rib5Seg2 = T3Rib5.addOrReplaceChild("T3Rib5Seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1449F, 3.2682F, 1.9652F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Rib5Seg2_r1 = T3Rib5Seg2.addOrReplaceChild("Rib5Seg2_r1", CubeListBuilder.create().texOffs(0, 338).addBox(-1.0F, -0.25F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -0.1199F, -0.2474F, 1.5272F, 0.0F, 0.0F));

		PartDefinition T3Rib5Seg3 = T3Rib5Seg2.addOrReplaceChild("T3Rib5Seg3", CubeListBuilder.create(), PartPose.offset(0.02F, 0.3861F, 5.4528F));

		PartDefinition Rib5Seg3_r1 = T3Rib5Seg3.addOrReplaceChild("Rib5Seg3_r1", CubeListBuilder.create().texOffs(0, 339).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0304F, -0.3473F, 0.1745F, 0.0F, 0.0F));

		PartDefinition T3Body4Head = T3Body4.addOrReplaceChild("T3Body4Head", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5663F, -0.5069F, -0.2635F, 0.0F, 0.6109F, -0.7854F));

		PartDefinition Jaw_r3 = T3Body4Head.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(49, 292).addBox(-4.3984F, 0.0432F, -3.7628F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.1119F, -0.1363F, 2.2651F));

		PartDefinition Head_r3 = T3Body4Head.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(60, 308).mirror().addBox(-4.5019F, -7.7725F, -4.1423F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 3.0F, 0.0F, 0.0322F, 0.0295F, 1.8331F));

		PartDefinition T3Body4HeadCrown = T3Body4Head.addOrReplaceChild("T3Body4HeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(4.7081F, 4.4328F, -0.2473F, 0.0F, 0.0F, 2.2253F));

		PartDefinition Petal5_r2 = T3Body4HeadCrown.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(152, 2).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r4 = T3Body4HeadCrown.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(105, 10).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal3_r4 = T3Body4HeadCrown.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(153, 10).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r4 = T3Body4HeadCrown.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(139, 15).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.1766F, 0.4011F, -1.1421F));

		return LayerDefinition.create(meshdefinition, 350, 370);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.isScared()){
			ageInTicks = ageInTicks * 1.2f;
		}
		float tendril1Val = Mth.cos(ageInTicks/7)/6;
		float tendril2Val = Mth.sin(ageInTicks/5)/6;
		float tendril3Val = -Mth.cos(ageInTicks/5)/6;
		float tendril4Val = Mth.sin(ageInTicks/5)/5;
		float tendril5Val = Mth.cos(ageInTicks/7)/4;
		float tendril6Val = Mth.sin(ageInTicks/6)/5;
		float tendril7Val = Mth.cos(ageInTicks/6)/2;
		float mawValue = Mth.sin(ageInTicks/6)/8;

		animateTumor(TumorGroup1,tendril1Val);
		animateTumor(TumorGroup2,tendril4Val);
		animateTumor(TumorGroup3,tendril6Val);
		animateTumor(TumorGroup4,mawValue);
		animateTumor(TumorGroup5,tendril3Val);
		animateTentacleX(ribJoint,tendril7Val);
		animateTentacleX(ribJoint2,tendril5Val);
		animateTentacleX(ribJoint3,tendril2Val);
		animateTentacleX(ribJoint4,tendril7Val);
		animateTentacleX(ribJoint5,tendril4Val);
		animateTentacleX(ribJoint6,tendril1Val);
		animateTentacleZ(ribJoint7,tendril7Val);
		animateTentacleZ(ribJoint8,tendril6Val);
		animateTentacleZ(ribJoint10,tendril3Val);
		animateTumor(BiomassBaseT3,tendril6Val);
		animateTentacleY(T3Body1,tendril3Val);
		animateTentacleY(T3Body2,tendril5Val);
		animateTentacleY(T3Body3,tendril4Val);
		animateTentacleX(T3Rib2,tendril2Val);
		animateTentacleX(T3Rib3,mawValue);
		animateTentacleX(T3Rib4,tendril3Val);
		animateTentacleX(T3Rib5,tendril4Val);
		animateTentacleX(T3Body4Head,tendril7Val);
		animateTentacleY(BrokenCoolingSystem,tendril5Val);
		animateTentacleZ(TumorStick,tendril3Val);
		animateTentacleX(UpperJaw,mawValue);
		animateTentacleX(LowerJaw,-mawValue);
		AnimateEye(entity,Pupil);
		animateTentacleX(Root1,tendril4Val);
		animateTentacleX(Root1Mid,tendril4Val);
		animateTentacleX(Root1End,tendril4Val);
		animateTentacleY(Root2,tendril1Val);
		animateTentacleY(Root2Mid,tendril1Val);
		animateTentacleY(Root2End,tendril1Val);
		animateTentacleZ(Root3,tendril3Val);
		animateTentacleZ(Root3Mid,tendril3Val);
		animateTentacleZ(Root3End,tendril3Val);
		animateTentacleY(Root4,tendril3Val);
		animateTentacleY(Root4Mid,tendril3Val);
		animateTentacleY(Root4End,tendril3Val);
		animateTentacleY(SearchingBody,tendril5Val);
		animateTentacleX(Tongue,-mawValue);
		animateTentacleX(Tongue2,-mawValue);
		animateTentacleX(Tongue3,-mawValue);
		animateTentacleY(ClawingMainBody,tendril6Val);

		animateTumor(Brain1,tendril1Val);
		animateTumor(Brain2,tendril4Val);
		animateTumor(Brain3,tendril6Val);
		animateTumor(Brain4,tendril1Val);
		animateTumor(Brain5,tendril4Val);
		animateTumor(Brain6,tendril6Val);
		animateTumor(Brain7,tendril1Val);
		animateTumor(Brain8,tendril4Val);
		animateTumor(Brain9,tendril6Val);
		animateTumor(Brain10,tendril1Val);

		animateTumor(BiomassClump1,tendril1Val);
		animateTumor(BiomassClump2,tendril2Val);
		animateTumor(BiomassClump3,tendril3Val);
		animateTumor(BiomassClump4,tendril4Val);
		animateTumor(BiomassClump5,tendril5Val);
		animateTumor(BiomassClump6,tendril6Val);
		animateTumor(BiomassClump7,tendril7Val);
		animateTumor(BiomassClump8,tendril1Val);
	}
	private void AnimateEye(T proto, ModelPart part){
		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (proto.isScared()){
			part.xScale = 0.75f;
			part.yScale = 0.75f;
			part.zScale = 1.2f;
		}else {
			part.resetPose();
		}
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = proto.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				part.y = part.getInitialPose().y + 0.0F;
			} else {
				part.y = part.getInitialPose().y + 1.0F;
			}

			Vec3 vec32 = proto.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			part.x = part.getInitialPose().x + Mth.sqrt((float)Math.abs(d1)) * 1.5F * (float)Math.signum(d1);
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Hivetumor.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}