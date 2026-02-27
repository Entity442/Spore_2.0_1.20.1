package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Calamities.Leviathan;
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

public class LeviathanModel<T extends Leviathan> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "leviathanmodel"), "main");
	private int open = 0;
	private final ModelPart Leviathan;
	public final ModelPart RightJaw;
	private final ModelPart FrontBase;
	private final ModelPart FrontTopMouthCorpseDetails;
	private final ModelPart MouthTopCenterpiece;
	private final ModelPart MTCPLimbs;
	private final ModelPart MTCPHead;
	private final ModelPart OutsideExtras;
	private final ModelPart Body1;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Body11;
	private final ModelPart Body12;
	private final ModelPart Body13;
	private final ModelPart Body14;
	private final ModelPart BackPart;
	private final ModelPart RightTusk;
	private final ModelPart tuskbody;
	private final ModelPart tuskbody2;
	private final ModelPart rtusk2;
	private final ModelPart tuskbody7;
	private final ModelPart tuskbody8;
	private final ModelPart tuskbody3;
	private final ModelPart tuskbody5;
	private final ModelPart tuskbody18;
	private final ModelPart tuskbody19;
	private final ModelPart tuskbody20;
	private final ModelPart rightTurskJoint;
	private final ModelPart rtusk3;
	private final ModelPart tuskbody6;
	private final ModelPart tuskbody4;
	private final ModelPart tuskbody17;
	public final ModelPart LeftJaw;
	private final ModelPart FrontBase2;
	private final ModelPart FrontTopMouthCorpseDetails2;
	private final ModelPart MouthTopCenterpiece2;
	private final ModelPart MTCPLimbs2;
	private final ModelPart MTCPHead2;
	private final ModelPart OutsideExtras2;
	private final ModelPart Body5;
	private final ModelPart Body6;
	private final ModelPart Body7;
	private final ModelPart Body8;
	private final ModelPart OutsideExtras3;
	private final ModelPart Body15;
	private final ModelPart Body16;
	private final ModelPart Body17;
	private final ModelPart Body18;
	private final ModelPart OutsideExtras4;
	private final ModelPart Body19;
	private final ModelPart Body20;
	private final ModelPart Body21;
	private final ModelPart Body22;
	private final ModelPart BackPart2;
	private final ModelPart LeftTusk;
	private final ModelPart tuskbody9;
	private final ModelPart tuskbody10;
	private final ModelPart rtusk4;
	private final ModelPart tuskbody11;
	private final ModelPart tuskbody12;
	private final ModelPart tuskbody13;
	private final ModelPart tuskbody15;
	private final ModelPart tuskbody23;
	private final ModelPart tuskbody24;
	private final ModelPart leftTurskJoint;
	private final ModelPart tuskbody22;
	private final ModelPart rtusk5;
	private final ModelPart tuskbody16;
	private final ModelPart tuskbody14;
	private final ModelPart tuskbody21;
	private final ModelPart Head;
	private final ModelPart DownJaw;
	private final ModelPart TopJaw;
	private final ModelPart Body10;
	private final ModelPart Body9;
	private final ModelPart AcidCannon;
	private final ModelPart Flower;
	private final ModelPart TumorBase;
	private final ModelPart FlowerMaw;
	private final ModelPart SouthMaw;
	private final ModelPart SMawSeg2;
	private final ModelPart SMawSeg3;
	private final ModelPart NWMaw;
	private final ModelPart NWMawSeg2;
	private final ModelPart NSMaw;
	private final ModelPart NSMawSeg2;
	private final ModelPart NSMawSeg3;
	public final ModelPart Base;
	public final ModelPart details;
	private final ModelPart fin;
	private final ModelPart fin2;
	private final ModelPart fin3;
	private final ModelPart fin4;
	private final ModelPart fin5;
	private final ModelPart RightSidefin;
	private final ModelPart LeftSidefin;
	private final ModelPart CenterCorpseDetails;
	private final ModelPart CenterBody1;
	private final ModelPart CenterBody2;
	private final ModelPart CenterBody3;
	private final ModelPart CenterBody4;
	private final ModelPart CenterCorpseDetails2;
	private final ModelPart CenterBody5;
	private final ModelPart CenterBody6;
	private final ModelPart CenterBody7;
	private final ModelPart CenterBody8;
	private final ModelPart CenterBody29;
	private final ModelPart CenterCorpseDetails3;
	private final ModelPart CenterBody9;
	private final ModelPart CenterBody10;
	private final ModelPart CenterBody11;
	private final ModelPart CenterBody12;
	private final ModelPart CenterCorpseDetails4;
	private final ModelPart CenterBody13;
	private final ModelPart CenterBody14;
	private final ModelPart CenterBody15;
	private final ModelPart CenterBody16;
	private final ModelPart CenterCorpseDetails5;
	private final ModelPart CenterBody17;
	private final ModelPart CenterBody18;
	private final ModelPart CenterBody19;
	private final ModelPart CenterBody20;
	private final ModelPart CenterCorpseDetails6;
	private final ModelPart CenterBody21;
	private final ModelPart CenterBody22;
	private final ModelPart CenterBody23;
	private final ModelPart CenterBody24;
	private final ModelPart CenterCorpseDetails7;
	private final ModelPart CenterBody25;
	private final ModelPart CenterBody26;
	private final ModelPart CenterBody27;
	private final ModelPart CenterBody28;
	public final ModelPart Tumors2;
	public final ModelPart Tumors;
	private final ModelPart Tumor;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Tumor5;
	private final ModelPart Tumor6;
	private final ModelPart Tumor7;
	private final ModelPart Tumor8;
	private final ModelPart Tumor9;
	private final ModelPart Tumor10;
	private final ModelPart Tumor11;
	public final ModelPart acidSacks;
	private final ModelPart rightSack;
	private final ModelPart leftSack;
	private final ModelPart leftSack2;

	public LeviathanModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Leviathan = root.getChild("Leviathan");
		this.RightJaw = this.Leviathan.getChild("RightJaw");
		this.FrontBase = this.RightJaw.getChild("FrontBase");
		this.FrontTopMouthCorpseDetails = this.FrontBase.getChild("FrontTopMouthCorpseDetails");
		this.MouthTopCenterpiece = this.FrontTopMouthCorpseDetails.getChild("MouthTopCenterpiece");
		this.MTCPLimbs = this.MouthTopCenterpiece.getChild("MTCPLimbs");
		this.MTCPHead = this.MouthTopCenterpiece.getChild("MTCPHead");
		this.OutsideExtras = this.FrontTopMouthCorpseDetails.getChild("OutsideExtras");
		this.Body1 = this.OutsideExtras.getChild("Body1");
		this.Body2 = this.OutsideExtras.getChild("Body2");
		this.Body3 = this.OutsideExtras.getChild("Body3");
		this.Body4 = this.OutsideExtras.getChild("Body4");
		this.Body11 = this.OutsideExtras.getChild("Body11");
		this.Body12 = this.OutsideExtras.getChild("Body12");
		this.Body13 = this.OutsideExtras.getChild("Body13");
		this.Body14 = this.OutsideExtras.getChild("Body14");
		this.BackPart = this.RightJaw.getChild("BackPart");
		this.RightTusk = this.RightJaw.getChild("RightTusk");
		this.tuskbody = this.RightTusk.getChild("tuskbody");
		this.tuskbody2 = this.RightTusk.getChild("tuskbody2");
		this.rtusk2 = this.RightTusk.getChild("rtusk2");
		this.tuskbody7 = this.rtusk2.getChild("tuskbody7");
		this.tuskbody8 = this.rtusk2.getChild("tuskbody8");
		this.tuskbody3 = this.rtusk2.getChild("tuskbody3");
		this.tuskbody5 = this.rtusk2.getChild("tuskbody5");
		this.tuskbody18 = this.rtusk2.getChild("tuskbody18");
		this.tuskbody19 = this.rtusk2.getChild("tuskbody19");
		this.tuskbody20 = this.rtusk2.getChild("tuskbody20");
		this.rightTurskJoint = this.rtusk2.getChild("rightTurskJoint");
		this.rtusk3 = this.rightTurskJoint.getChild("rtusk3");
		this.tuskbody6 = this.rtusk3.getChild("tuskbody6");
		this.tuskbody4 = this.rightTurskJoint.getChild("tuskbody4");
		this.tuskbody17 = this.rightTurskJoint.getChild("tuskbody17");
		this.LeftJaw = this.Leviathan.getChild("LeftJaw");
		this.FrontBase2 = this.LeftJaw.getChild("FrontBase2");
		this.FrontTopMouthCorpseDetails2 = this.FrontBase2.getChild("FrontTopMouthCorpseDetails2");
		this.MouthTopCenterpiece2 = this.FrontTopMouthCorpseDetails2.getChild("MouthTopCenterpiece2");
		this.MTCPLimbs2 = this.MouthTopCenterpiece2.getChild("MTCPLimbs2");
		this.MTCPHead2 = this.MouthTopCenterpiece2.getChild("MTCPHead2");
		this.OutsideExtras2 = this.FrontTopMouthCorpseDetails2.getChild("OutsideExtras2");
		this.Body5 = this.OutsideExtras2.getChild("Body5");
		this.Body6 = this.OutsideExtras2.getChild("Body6");
		this.Body7 = this.OutsideExtras2.getChild("Body7");
		this.Body8 = this.OutsideExtras2.getChild("Body8");
		this.OutsideExtras3 = this.FrontTopMouthCorpseDetails2.getChild("OutsideExtras3");
		this.Body15 = this.OutsideExtras3.getChild("Body15");
		this.Body16 = this.OutsideExtras3.getChild("Body16");
		this.Body17 = this.OutsideExtras3.getChild("Body17");
		this.Body18 = this.OutsideExtras3.getChild("Body18");
		this.OutsideExtras4 = this.FrontTopMouthCorpseDetails2.getChild("OutsideExtras4");
		this.Body19 = this.OutsideExtras4.getChild("Body19");
		this.Body20 = this.OutsideExtras4.getChild("Body20");
		this.Body21 = this.OutsideExtras4.getChild("Body21");
		this.Body22 = this.OutsideExtras4.getChild("Body22");
		this.BackPart2 = this.LeftJaw.getChild("BackPart2");
		this.LeftTusk = this.LeftJaw.getChild("LeftTusk");
		this.tuskbody9 = this.LeftTusk.getChild("tuskbody9");
		this.tuskbody10 = this.LeftTusk.getChild("tuskbody10");
		this.rtusk4 = this.LeftTusk.getChild("rtusk4");
		this.tuskbody11 = this.rtusk4.getChild("tuskbody11");
		this.tuskbody12 = this.rtusk4.getChild("tuskbody12");
		this.tuskbody13 = this.rtusk4.getChild("tuskbody13");
		this.tuskbody15 = this.rtusk4.getChild("tuskbody15");
		this.tuskbody23 = this.rtusk4.getChild("tuskbody23");
		this.tuskbody24 = this.rtusk4.getChild("tuskbody24");
		this.leftTurskJoint = this.rtusk4.getChild("leftTurskJoint");
		this.tuskbody22 = this.leftTurskJoint.getChild("tuskbody22");
		this.rtusk5 = this.leftTurskJoint.getChild("rtusk5");
		this.tuskbody16 = this.rtusk5.getChild("tuskbody16");
		this.tuskbody14 = this.leftTurskJoint.getChild("tuskbody14");
		this.tuskbody21 = this.leftTurskJoint.getChild("tuskbody21");
		this.Head = this.Leviathan.getChild("Head");
		this.DownJaw = this.Head.getChild("DownJaw");
		this.TopJaw = this.Head.getChild("TopJaw");
		this.Body10 = this.TopJaw.getChild("Body10");
		this.Body9 = this.TopJaw.getChild("Body9");
		this.AcidCannon = this.Head.getChild("AcidCannon");
		this.Flower = this.AcidCannon.getChild("Flower");
		this.TumorBase = this.Flower.getChild("TumorBase");
		this.FlowerMaw = this.Flower.getChild("FlowerMaw");
		this.SouthMaw = this.FlowerMaw.getChild("SouthMaw");
		this.SMawSeg2 = this.SouthMaw.getChild("SMawSeg2");
		this.SMawSeg3 = this.SMawSeg2.getChild("SMawSeg3");
		this.NWMaw = this.FlowerMaw.getChild("NWMaw");
		this.NWMawSeg2 = this.NWMaw.getChild("NWMawSeg2");
		this.NSMaw = this.FlowerMaw.getChild("NSMaw");
		this.NSMawSeg2 = this.NSMaw.getChild("NSMawSeg2");
		this.NSMawSeg3 = this.NSMawSeg2.getChild("NSMawSeg3");
		this.Base = this.Leviathan.getChild("Base");
		this.details = this.Leviathan.getChild("details");
		this.fin = this.details.getChild("fin");
		this.fin2 = this.details.getChild("fin2");
		this.fin3 = this.details.getChild("fin3");
		this.fin4 = this.details.getChild("fin4");
		this.fin5 = this.details.getChild("fin5");
		this.RightSidefin = this.details.getChild("RightSidefin");
		this.LeftSidefin = this.details.getChild("LeftSidefin");
		this.CenterCorpseDetails = this.details.getChild("CenterCorpseDetails");
		this.CenterBody1 = this.CenterCorpseDetails.getChild("CenterBody1");
		this.CenterBody2 = this.CenterCorpseDetails.getChild("CenterBody2");
		this.CenterBody3 = this.CenterCorpseDetails.getChild("CenterBody3");
		this.CenterBody4 = this.CenterCorpseDetails.getChild("CenterBody4");
		this.CenterCorpseDetails2 = this.details.getChild("CenterCorpseDetails2");
		this.CenterBody5 = this.CenterCorpseDetails2.getChild("CenterBody5");
		this.CenterBody6 = this.CenterCorpseDetails2.getChild("CenterBody6");
		this.CenterBody7 = this.CenterCorpseDetails2.getChild("CenterBody7");
		this.CenterBody8 = this.CenterCorpseDetails2.getChild("CenterBody8");
		this.CenterBody29 = this.CenterCorpseDetails2.getChild("CenterBody29");
		this.CenterCorpseDetails3 = this.details.getChild("CenterCorpseDetails3");
		this.CenterBody9 = this.CenterCorpseDetails3.getChild("CenterBody9");
		this.CenterBody10 = this.CenterCorpseDetails3.getChild("CenterBody10");
		this.CenterBody11 = this.CenterCorpseDetails3.getChild("CenterBody11");
		this.CenterBody12 = this.CenterCorpseDetails3.getChild("CenterBody12");
		this.CenterCorpseDetails4 = this.details.getChild("CenterCorpseDetails4");
		this.CenterBody13 = this.CenterCorpseDetails4.getChild("CenterBody13");
		this.CenterBody14 = this.CenterCorpseDetails4.getChild("CenterBody14");
		this.CenterBody15 = this.CenterCorpseDetails4.getChild("CenterBody15");
		this.CenterBody16 = this.CenterCorpseDetails4.getChild("CenterBody16");
		this.CenterCorpseDetails5 = this.details.getChild("CenterCorpseDetails5");
		this.CenterBody17 = this.CenterCorpseDetails5.getChild("CenterBody17");
		this.CenterBody18 = this.CenterCorpseDetails5.getChild("CenterBody18");
		this.CenterBody19 = this.CenterCorpseDetails5.getChild("CenterBody19");
		this.CenterBody20 = this.CenterCorpseDetails5.getChild("CenterBody20");
		this.CenterCorpseDetails6 = this.details.getChild("CenterCorpseDetails6");
		this.CenterBody21 = this.CenterCorpseDetails6.getChild("CenterBody21");
		this.CenterBody22 = this.CenterCorpseDetails6.getChild("CenterBody22");
		this.CenterBody23 = this.CenterCorpseDetails6.getChild("CenterBody23");
		this.CenterBody24 = this.CenterCorpseDetails6.getChild("CenterBody24");
		this.CenterCorpseDetails7 = this.details.getChild("CenterCorpseDetails7");
		this.CenterBody25 = this.CenterCorpseDetails7.getChild("CenterBody25");
		this.CenterBody26 = this.CenterCorpseDetails7.getChild("CenterBody26");
		this.CenterBody27 = this.CenterCorpseDetails7.getChild("CenterBody27");
		this.CenterBody28 = this.CenterCorpseDetails7.getChild("CenterBody28");
		this.Tumors2 = this.details.getChild("Tumors2");
		this.Tumors = this.Leviathan.getChild("Tumors");
		this.Tumor = this.Tumors.getChild("Tumor");
		this.Tumor2 = this.Tumors.getChild("Tumor2");
		this.Tumor3 = this.Tumors.getChild("Tumor3");
		this.Tumor4 = this.Tumors.getChild("Tumor4");
		this.Tumor5 = this.Tumors.getChild("Tumor5");
		this.Tumor6 = this.Tumors.getChild("Tumor6");
		this.Tumor7 = this.Tumors.getChild("Tumor7");
		this.Tumor8 = this.Tumors.getChild("Tumor8");
		this.Tumor9 = this.Tumors.getChild("Tumor9");
		this.Tumor10 = this.Tumors.getChild("Tumor10");
		this.Tumor11 = this.Tumors.getChild("Tumor11");
		this.acidSacks = this.Leviathan.getChild("acidSacks");
		this.rightSack = this.acidSacks.getChild("rightSack");
		this.leftSack = this.acidSacks.getChild("leftSack");
		this.leftSack2 = this.acidSacks.getChild("leftSack2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Leviathan = partdefinition.addOrReplaceChild("Leviathan", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -38.0F));

		PartDefinition RightJaw = Leviathan.addOrReplaceChild("RightJaw", CubeListBuilder.create().texOffs(310, 91).addBox(-5.3333F, -21.7414F, -36.4933F, 11.0F, 5.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.9167F, -25.7586F, 11.7433F, 0.4363F, 0.0F, -1.5708F));

		PartDefinition topJawLeft_r1 = RightJaw.addOrReplaceChild("topJawLeft_r1", CubeListBuilder.create().texOffs(210, 307).addBox(-8.0F, -2.0F, -13.5F, 20.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0249F, -17.0043F, -27.0033F, -3.1416F, 0.3054F, 2.7053F));

		PartDefinition topJawRight_r1 = RightJaw.addOrReplaceChild("topJawRight_r1", CubeListBuilder.create().texOffs(210, 276).addBox(-7.25F, -8.5F, -5.51F, 19.0F, 5.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6667F, -11.4914F, -32.9933F, 0.0F, 0.3054F, 0.4363F));

		PartDefinition FrontBase = RightJaw.addOrReplaceChild("FrontBase", CubeListBuilder.create().texOffs(0, 372).addBox(-5.3333F, -3.7414F, -18.4933F, 11.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -35.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topJawLeft_r2 = FrontBase.addOrReplaceChild("topJawLeft_r2", CubeListBuilder.create().texOffs(324, 376).addBox(-5.0F, -1.5F, -9.5F, 12.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.2361F, 0.5425F, -9.0033F, 0.0F, -0.2618F, -0.4363F));

		PartDefinition topJawRight_r2 = FrontBase.addOrReplaceChild("topJawRight_r2", CubeListBuilder.create().texOffs(0, 395).addBox(-8.25F, -8.5F, 1.49F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, 0.4363F));

		PartDefinition FrontTopMouthCorpseDetails = FrontBase.addOrReplaceChild("FrontTopMouthCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadOuterLeft_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterLeft_r1", CubeListBuilder.create().texOffs(642, 126).addBox(-3.25F, -2.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.6667F, 0.5F, -14.3301F, -0.4356F, 0.4802F, -0.4461F));

		PartDefinition HeadInnerLeft_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadInnerLeft_r1", CubeListBuilder.create().texOffs(631, 43).addBox(-4.75F, -1.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8365F, -2.5F, -14.2321F, -0.5236F, -0.131F, -0.4799F));

		PartDefinition HeadInnerRight_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadInnerRight_r1", CubeListBuilder.create().texOffs(642, 126).addBox(-4.0F, -1.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6699F, -2.5F, -14.2321F, -0.3808F, -0.1035F, 0.3236F));

		PartDefinition HeadOuterRightTeeth_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterRightTeeth_r1", CubeListBuilder.create().texOffs(631, 158).addBox(-4.0F, 4.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -3.25F, -14.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition HeadOuterRightTeeth_r2 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterRightTeeth_r2", CubeListBuilder.create().texOffs(631, 158).addBox(-4.0F, 4.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(642, 126).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 3.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition HeadOuterRightTeeth_r3 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterRightTeeth_r3", CubeListBuilder.create().texOffs(631, 158).addBox(-4.0F, 4.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(642, 126).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, -10.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition MouthTopCenterpiece = FrontTopMouthCorpseDetails.addOrReplaceChild("MouthTopCenterpiece", CubeListBuilder.create(), PartPose.offset(6.6699F, -1.7346F, -12.3843F));

		PartDefinition CenterTorsoTop_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoTop_r1", CubeListBuilder.create().texOffs(637, 36).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.9197F, -1.6236F, 0.6545F, 0.0F, 0.0F));

		PartDefinition CenterTorsoBack_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoBack_r1", CubeListBuilder.create().texOffs(637, 36).addBox(-10.5F, -4.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MTCPLimbs = MouthTopCenterpiece.addOrReplaceChild("MTCPLimbs", CubeListBuilder.create(), PartPose.offset(-7.0F, -3.9197F, -1.6236F));

		PartDefinition Leg_r1 = MTCPLimbs.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(637, 36).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 6.0F, -0.0499F, 0.3027F, -0.0411F));

		PartDefinition RArm_r1 = MTCPLimbs.addOrReplaceChild("RArm_r1", CubeListBuilder.create().texOffs(637, 36).addBox(-1.0F, -0.9742F, -7.9043F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.3107F, -2.0349F, 0.5672F, -0.6109F, 0.0F));

		PartDefinition MTCPHead = MouthTopCenterpiece.addOrReplaceChild("MTCPHead", CubeListBuilder.create(), PartPose.offset(-6.9992F, -0.7425F, -4.9086F));

		PartDefinition MTCPHead_r1 = MTCPHead.addOrReplaceChild("MTCPHead_r1", CubeListBuilder.create().texOffs(637, 36).addBox(-3.9992F, -5.6417F, -7.7822F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0008F, -0.4155F, -0.0812F, 1.0036F, 0.0F, 0.0F));

		PartDefinition OutsideExtras = FrontTopMouthCorpseDetails.addOrReplaceChild("OutsideExtras", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body1 = OutsideExtras.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offset(-10.4048F, -1.1299F, -8.5F));

		PartDefinition Arm2_r1 = Body1.addOrReplaceChild("Arm2_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4526F, -1.2485F, 9.6142F, -2.6802F, 1.029F, 2.882F));

		PartDefinition Arm1_r1 = Body1.addOrReplaceChild("Arm1_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.7854F));

		PartDefinition TorsoTop1_r1 = Body1.addOrReplaceChild("TorsoTop1_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom1_r1 = Body1.addOrReplaceChild("TorsoBottom1_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body2 = OutsideExtras.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(629, 42).addBox(-3.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 0.0F, 2.0F));

		PartDefinition Torso_r1 = Body2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Arm_r1 = Body2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-8.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 4.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Body3 = OutsideExtras.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.1618F, 2.5895F, 15.0738F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r2 = Body3.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-1.1649F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5289F, 1.0321F, 3.0404F, -0.2404F, -0.2686F, 0.7273F));

		PartDefinition Arm_r3 = Body3.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(629, 42).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0763F, 0.2806F, -3.5738F, 0.0F, 0.0436F, 0.7854F));

		PartDefinition TorsoTop_r1 = Body3.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom_r1 = Body3.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body4 = OutsideExtras.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition Limb_r1 = Body4.addOrReplaceChild("Limb_r1", CubeListBuilder.create().texOffs(629, 42).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.342F, -0.9397F, -0.6264F, -0.2865F, 0.1074F));

		PartDefinition Body11 = OutsideExtras.addOrReplaceChild("Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(10.1618F, 17.5895F, 26.0738F, -1.6401F, -0.6501F, 1.7316F));

		PartDefinition Arm_r4 = Body11.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(629, 42).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0763F, 0.2806F, -3.5738F, 0.9733F, 0.8227F, 1.8936F));

		PartDefinition TorsoTop_r2 = Body11.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom_r2 = Body11.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body12 = OutsideExtras.addOrReplaceChild("Body12", CubeListBuilder.create().texOffs(629, 42).addBox(-3.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 9.0F, 27.0F, -1.5958F, 0.0004F, 1.6065F));

		PartDefinition Torso_r2 = Body12.addOrReplaceChild("Torso_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Arm_r5 = Body12.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(629, 42).addBox(-8.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Body13 = OutsideExtras.addOrReplaceChild("Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.4048F, 13.8701F, 23.5F, -1.1345F, 0.0F, 0.0F));

		PartDefinition Arm2_r2 = Body13.addOrReplaceChild("Arm2_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4526F, -1.2485F, 9.6142F, -2.6802F, 1.029F, 2.882F));

		PartDefinition Arm1_r2 = Body13.addOrReplaceChild("Arm1_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1822F, -0.7936F, -0.2363F));

		PartDefinition TorsoTop1_r2 = Body13.addOrReplaceChild("TorsoTop1_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom1_r2 = Body13.addOrReplaceChild("TorsoBottom1_r2", CubeListBuilder.create().texOffs(629, 42).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body14 = OutsideExtras.addOrReplaceChild("Body14", CubeListBuilder.create(), PartPose.offsetAndRotation(13.1618F, -0.4105F, -3.9262F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r6 = Body14.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(629, 42).addBox(-1.1649F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5289F, 1.0321F, 3.0404F, -0.2404F, -0.2686F, 0.7273F));

		PartDefinition Arm_r7 = Body14.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(629, 42).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0763F, 0.2806F, -3.5738F, 0.0113F, 0.0421F, 1.0474F));

		PartDefinition TorsoTop_r3 = Body14.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(629, 42).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom_r3 = Body14.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(629, 42).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, 0.1309F));

		PartDefinition BackPart = RightJaw.addOrReplaceChild("BackPart", CubeListBuilder.create().texOffs(72, 335).addBox(-5.3333F, -3.7414F, -20.4933F, 11.0F, 5.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition topJawRight_r3 = BackPart.addOrReplaceChild("topJawRight_r3", CubeListBuilder.create().texOffs(300, 276).addBox(-8.25F, -8.5F, -5.51F, 24.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, 0.4363F));

		PartDefinition topJawLeft_r3 = BackPart.addOrReplaceChild("topJawLeft_r3", CubeListBuilder.create().texOffs(304, 0).addBox(-7.0F, -3.0F, -9.5F, 22.0F, 6.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0249F, 0.9957F, -9.0033F, 0.0F, 3.1416F, -0.4363F));

		PartDefinition RightTusk = RightJaw.addOrReplaceChild("RightTusk", CubeListBuilder.create().texOffs(0, 661).addBox(-5.0F, -10.0F, -25.5F, 10.0F, 10.0F, 29.0F, new CubeDeformation(0.0F))
		.texOffs(642, 662).addBox(0.0F, -16.0F, -25.5F, 0.0F, 9.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -13.0F, -13.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tuskbody = RightTusk.addOrReplaceChild("tuskbody", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0563F, -10.5624F, -8.5254F, 0.6528F, 0.0895F, -0.3015F));

		PartDefinition TorsoBase_r1 = tuskbody.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r8 = tuskbody.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r9 = tuskbody.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r4 = tuskbody.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r1 = tuskbody.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition tuskbody2 = RightTusk.addOrReplaceChild("tuskbody2", CubeListBuilder.create(), PartPose.offsetAndRotation(8.9437F, -7.5624F, -16.5254F, -2.4357F, -0.0353F, -2.4462F));

		PartDefinition TorsoBase_r2 = tuskbody2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1958F, 3.1988F, 2.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r10 = tuskbody2.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition TorsoTop_r5 = tuskbody2.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r2 = tuskbody2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition rtusk2 = RightTusk.addOrReplaceChild("rtusk2", CubeListBuilder.create().texOffs(80, 660).addBox(-3.0F, -3.0F, -33.0F, 6.0F, 6.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -24.5F, -0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r1 = rtusk2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 610).addBox(1.0F, -7.0F, -73.0F, 0.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -19.0F, 40.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition tuskbody7 = rtusk2.addOrReplaceChild("tuskbody7", CubeListBuilder.create(), PartPose.offsetAndRotation(2.1437F, 3.5376F, -3.0254F, -0.4287F, 1.1829F, 1.6772F));

		PartDefinition TorsoBase_r3 = tuskbody7.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0042F, 2.3988F, 2.1066F, -0.8669F, -0.1775F, 0.2265F));

		PartDefinition Arm_r11 = tuskbody7.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r12 = tuskbody7.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r6 = tuskbody7.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r3 = tuskbody7.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -1.2697F, -6.66F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition tuskbody8 = rtusk2.addOrReplaceChild("tuskbody8", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6563F, -5.6624F, -5.1254F, -2.726F, 1.1546F, 2.3537F));

		PartDefinition TorsoBase_r4 = tuskbody8.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6042F, 2.9988F, 1.0066F, -1.5999F, -0.1775F, 0.2265F));

		PartDefinition Arm_r13 = tuskbody8.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r14 = tuskbody8.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r7 = tuskbody8.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r4 = tuskbody8.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -1.2697F, -6.6599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition tuskbody3 = rtusk2.addOrReplaceChild("tuskbody3", CubeListBuilder.create(), PartPose.offsetAndRotation(4.9437F, 1.4376F, -14.0254F, 0.1831F, 0.4019F, 1.2362F));

		PartDefinition TorsoBase_r5 = tuskbody3.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2042F, 0.3988F, 3.3066F, -0.3434F, -0.3985F, 0.4407F));

		PartDefinition Arm_r15 = tuskbody3.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -2.0202F, 0.6176F, 0.5882F));

		PartDefinition Arm_r16 = tuskbody3.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -1.8797F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r8 = tuskbody3.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.5912F, -0.3892F, 0.3817F));

		PartDefinition Head_r5 = tuskbody3.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -1.2697F, -8.66F, -1.9955F, 0.0972F, 0.2852F));

		PartDefinition tuskbody5 = rtusk2.addOrReplaceChild("tuskbody5", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.9563F, 1.7376F, -16.5254F, 0.7028F, 0.9087F, -1.4018F));

		PartDefinition TorsoBase_r6 = tuskbody5.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3958F, 1.5988F, 0.1066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r17 = tuskbody5.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2431F, 1.8062F, -1.104F, -0.5601F, 0.2854F, -0.2112F));

		PartDefinition TorsoTop_r9 = tuskbody5.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1F, -2.0F, -0.0657F, -0.559F, -0.8483F));

		PartDefinition tuskbody18 = rtusk2.addOrReplaceChild("tuskbody18", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0437F, -0.45F, -27.1584F, -0.5582F, 0.1468F, -2.3799F));

		PartDefinition TorsoBase_r7 = tuskbody18.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1958F, 3.1988F, 2.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r18 = tuskbody18.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition TorsoTop_r10 = tuskbody18.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition tuskbody19 = rtusk2.addOrReplaceChild("tuskbody19", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.9563F, -6.45F, -13.1584F, 0.4363F, 0.3471F, -1.8336F));

		PartDefinition TorsoBase_r8 = tuskbody19.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3958F, 1.5988F, 0.1066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r19 = tuskbody19.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2431F, 1.8062F, -1.104F, -0.5601F, 0.2854F, -0.2112F));

		PartDefinition TorsoTop_r11 = tuskbody19.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1F, -2.0F, -0.0657F, -0.559F, -0.8483F));

		PartDefinition tuskbody20 = rtusk2.addOrReplaceChild("tuskbody20", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9563F, -2.45F, -20.1584F, -0.2124F, 0.5118F, 3.0944F));

		PartDefinition TorsoBase_r9 = tuskbody20.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3958F, 1.5988F, 0.1066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r20 = tuskbody20.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2431F, 1.8062F, -1.104F, -0.5601F, 0.2854F, -0.2112F));

		PartDefinition TorsoTop_r12 = tuskbody20.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.1F, -2.0F, -0.0657F, -0.559F, -0.8483F));

		PartDefinition rightTurskJoint = rtusk2.addOrReplaceChild("rightTurskJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -30.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition rtusk3 = rightTurskJoint.addOrReplaceChild("rtusk3", CubeListBuilder.create().texOffs(85, 664).addBox(-2.0F, -2.0F, -29.0F, 4.0F, 4.0F, 30.0F, new CubeDeformation(0.0F))
		.texOffs(160, 644).addBox(0.0F, -12.0F, -39.0F, 0.0F, 20.0F, 36.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition tuskbody6 = rtusk3.addOrReplaceChild("tuskbody6", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9437F, -2.5624F, -17.0254F, 0.6528F, 0.0895F, -0.3015F));

		PartDefinition TorsoBase_r10 = tuskbody6.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r21 = tuskbody6.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.457F, -0.1938F, -3.704F, -1.6936F, 0.8402F, 0.9812F));

		PartDefinition Arm_r22 = tuskbody6.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r13 = tuskbody6.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r6 = tuskbody6.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition tuskbody4 = rightTurskJoint.addOrReplaceChild("tuskbody4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0437F, 1.7376F, -0.5254F, -0.7375F, 0.6775F, -2.8066F));

		PartDefinition TorsoBase_r11 = tuskbody4.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1958F, 3.1988F, 2.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r23 = tuskbody4.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition TorsoTop_r14 = tuskbody4.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition tuskbody17 = rightTurskJoint.addOrReplaceChild("tuskbody17", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9437F, 7.25F, -4.6584F, -0.1639F, -0.2495F, 2.3417F));

		PartDefinition TorsoBase_r12 = tuskbody17.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2042F, 0.3988F, 3.3066F, -0.3434F, -0.3985F, 0.4407F));

		PartDefinition Arm_r24 = tuskbody17.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -2.0202F, 0.6176F, 0.5882F));

		PartDefinition Arm_r25 = tuskbody17.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -1.8797F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r15 = tuskbody17.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.5912F, -0.3892F, 0.3817F));

		PartDefinition Head_r7 = tuskbody17.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -1.2697F, -8.66F, -1.9955F, 0.0972F, 0.2852F));

		PartDefinition LeftJaw = Leviathan.addOrReplaceChild("LeftJaw", CubeListBuilder.create().texOffs(310, 91).addBox(-5.6667F, -21.7414F, -36.4933F, 11.0F, 5.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.9167F, -24.7586F, 9.7433F, 0.4363F, 0.0F, 1.5708F));

		PartDefinition topJawRight_r4 = LeftJaw.addOrReplaceChild("topJawRight_r4", CubeListBuilder.create().texOffs(210, 307).addBox(-12.0F, -2.0F, -13.5F, 20.0F, 4.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0249F, -17.0043F, -27.0033F, -3.1416F, -0.3054F, -2.7053F));

		PartDefinition topJawLeft_r4 = LeftJaw.addOrReplaceChild("topJawLeft_r4", CubeListBuilder.create().texOffs(210, 276).addBox(-11.75F, -8.5F, -5.51F, 19.0F, 5.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6667F, -11.4914F, -32.9933F, 0.0F, -0.3054F, -0.4363F));

		PartDefinition FrontBase2 = LeftJaw.addOrReplaceChild("FrontBase2", CubeListBuilder.create().texOffs(0, 372).addBox(-5.6667F, -3.7414F, -18.4933F, 11.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -35.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topJawRight_r5 = FrontBase2.addOrReplaceChild("topJawRight_r5", CubeListBuilder.create().texOffs(224, 283).addBox(-7.0F, -1.5F, -9.5F, 12.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2361F, 0.5425F, -9.0033F, 0.0F, 0.2618F, 0.4363F));

		PartDefinition topJawLeft_r5 = FrontBase2.addOrReplaceChild("topJawLeft_r5", CubeListBuilder.create().texOffs(0, 395).addBox(-2.75F, -8.5F, 1.49F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, -0.4363F));

		PartDefinition FrontTopMouthCorpseDetails2 = FrontBase2.addOrReplaceChild("FrontTopMouthCorpseDetails2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadOuterRight_r1 = FrontTopMouthCorpseDetails2.addOrReplaceChild("HeadOuterRight_r1", CubeListBuilder.create().texOffs(665, 41).addBox(-4.75F, -2.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6667F, 0.5F, -14.3301F, -0.4356F, -0.4802F, 0.4461F));

		PartDefinition HeadInnerRight_r2 = FrontTopMouthCorpseDetails2.addOrReplaceChild("HeadInnerRight_r2", CubeListBuilder.create().texOffs(665, 41).addBox(-3.25F, -1.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8365F, -2.5F, -14.2321F, -0.5236F, 0.131F, 0.4799F));

		PartDefinition HeadInnerLeft_r2 = FrontTopMouthCorpseDetails2.addOrReplaceChild("HeadInnerLeft_r2", CubeListBuilder.create().texOffs(615, 44).addBox(-4.0F, -1.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6699F, -2.5F, -14.2321F, -0.3808F, 0.1035F, -0.3236F));

		PartDefinition HeadOuterLeft_r2 = FrontTopMouthCorpseDetails2.addOrReplaceChild("HeadOuterLeft_r2", CubeListBuilder.create().texOffs(615, 44).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 0.0F, -10.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition MouthTopCenterpiece2 = FrontTopMouthCorpseDetails2.addOrReplaceChild("MouthTopCenterpiece2", CubeListBuilder.create(), PartPose.offset(-6.6699F, -1.7346F, -12.3843F));

		PartDefinition CenterTorsoTop_r2 = MouthTopCenterpiece2.addOrReplaceChild("CenterTorsoTop_r2", CubeListBuilder.create().texOffs(659, 41).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -3.9197F, -1.6236F, 0.6545F, 0.0F, 0.0F));

		PartDefinition CenterTorsoBack_r2 = MouthTopCenterpiece2.addOrReplaceChild("CenterTorsoBack_r2", CubeListBuilder.create().texOffs(659, 41).addBox(3.5F, -4.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MTCPLimbs2 = MouthTopCenterpiece2.addOrReplaceChild("MTCPLimbs2", CubeListBuilder.create(), PartPose.offset(7.0F, -3.9197F, -1.6236F));

		PartDefinition Leg_r2 = MTCPLimbs2.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(659, 41).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 6.0F, -0.0499F, -0.3027F, 0.0411F));

		PartDefinition RArm_r2 = MTCPLimbs2.addOrReplaceChild("RArm_r2", CubeListBuilder.create().texOffs(659, 41).addBox(-3.0F, -0.9742F, -7.9043F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -0.3107F, -2.0349F, 0.5672F, 0.6109F, 0.0F));

		PartDefinition MTCPHead2 = MouthTopCenterpiece2.addOrReplaceChild("MTCPHead2", CubeListBuilder.create(), PartPose.offset(6.9992F, -0.7425F, -4.9086F));

		PartDefinition MTCPHead_r2 = MTCPHead2.addOrReplaceChild("MTCPHead_r2", CubeListBuilder.create().texOffs(659, 41).addBox(-4.0008F, -5.6417F, -7.7822F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0008F, -0.4155F, -0.0812F, 1.0036F, 0.0F, 0.0F));

		PartDefinition OutsideExtras2 = FrontTopMouthCorpseDetails2.addOrReplaceChild("OutsideExtras2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body5 = OutsideExtras2.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offset(10.4048F, -1.1299F, -8.5F));

		PartDefinition Arm2_r3 = Body5.addOrReplaceChild("Arm2_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4526F, -1.2485F, 9.6142F, -2.6802F, -1.029F, -2.882F));

		PartDefinition Arm1_r3 = Body5.addOrReplaceChild("Arm1_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.7854F));

		PartDefinition TorsoTop1_r3 = Body5.addOrReplaceChild("TorsoTop1_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom1_r3 = Body5.addOrReplaceChild("TorsoBottom1_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body6 = OutsideExtras2.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 2.0F));

		PartDefinition Torso_r3 = Body6.addOrReplaceChild("Torso_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r26 = Body6.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(658, 38).addBox(0.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -7.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition Body7 = OutsideExtras2.addOrReplaceChild("Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.1618F, 2.5895F, 15.0738F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r27 = Body7.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(658, 38).addBox(-6.8351F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5289F, 1.0321F, 3.0404F, -0.2404F, 0.2686F, -0.7273F));

		PartDefinition Arm_r28 = Body7.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(658, 38).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0763F, 0.2806F, -3.5738F, 0.0F, -0.0436F, -0.7854F));

		PartDefinition TorsoTop_r16 = Body7.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(658, 38).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom_r4 = Body7.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body8 = OutsideExtras2.addOrReplaceChild("Body8", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition Limb_r2 = Body8.addOrReplaceChild("Limb_r2", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.342F, -0.9397F, -0.6264F, 0.2865F, -0.1074F));

		PartDefinition OutsideExtras3 = FrontTopMouthCorpseDetails2.addOrReplaceChild("OutsideExtras3", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 10.0F, 19.0F, -2.3584F, -0.5567F, 2.2604F));

		PartDefinition Body15 = OutsideExtras3.addOrReplaceChild("Body15", CubeListBuilder.create(), PartPose.offset(10.4048F, -1.1299F, -8.5F));

		PartDefinition Arm2_r4 = Body15.addOrReplaceChild("Arm2_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4526F, -1.2485F, 9.6142F, -2.6802F, -1.029F, -2.882F));

		PartDefinition Arm1_r4 = Body15.addOrReplaceChild("Arm1_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.7854F));

		PartDefinition TorsoTop1_r4 = Body15.addOrReplaceChild("TorsoTop1_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom1_r4 = Body15.addOrReplaceChild("TorsoBottom1_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body16 = OutsideExtras3.addOrReplaceChild("Body16", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 2.0F));

		PartDefinition Torso_r4 = Body16.addOrReplaceChild("Torso_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r29 = Body16.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(658, 38).addBox(0.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition Body17 = OutsideExtras3.addOrReplaceChild("Body17", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.1618F, 2.5895F, 15.0738F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r30 = Body17.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(658, 38).addBox(-6.8351F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5289F, 1.0321F, 3.0404F, -0.2404F, 0.2686F, -0.7273F));

		PartDefinition Arm_r31 = Body17.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(658, 38).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0763F, 0.2806F, -3.5738F, 0.0F, -0.0436F, -0.7854F));

		PartDefinition TorsoTop_r17 = Body17.addOrReplaceChild("TorsoTop_r17", CubeListBuilder.create().texOffs(658, 38).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom_r5 = Body17.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body18 = OutsideExtras3.addOrReplaceChild("Body18", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition Limb_r3 = Body18.addOrReplaceChild("Limb_r3", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.342F, -0.9397F, -0.6264F, 0.2865F, -0.1074F));

		PartDefinition OutsideExtras4 = FrontTopMouthCorpseDetails2.addOrReplaceChild("OutsideExtras4", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, 9.0F, 18.0F, -0.8165F, 0.2443F, -0.2519F));

		PartDefinition Body19 = OutsideExtras4.addOrReplaceChild("Body19", CubeListBuilder.create(), PartPose.offset(10.4048F, -1.1299F, -8.5F));

		PartDefinition Arm2_r5 = Body19.addOrReplaceChild("Arm2_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4526F, -1.2485F, 9.6142F, -2.6802F, -1.029F, -2.882F));

		PartDefinition Arm1_r5 = Body19.addOrReplaceChild("Arm1_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3054F, 0.7854F));

		PartDefinition TorsoTop1_r5 = Body19.addOrReplaceChild("TorsoTop1_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom1_r5 = Body19.addOrReplaceChild("TorsoBottom1_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body20 = OutsideExtras4.addOrReplaceChild("Body20", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 2.0F));

		PartDefinition Torso_r5 = Body20.addOrReplaceChild("Torso_r5", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r32 = Body20.addOrReplaceChild("Arm_r32", CubeListBuilder.create().texOffs(658, 38).addBox(0.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.2654F));

		PartDefinition Body21 = OutsideExtras4.addOrReplaceChild("Body21", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.1618F, 2.5895F, 15.0738F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r33 = Body21.addOrReplaceChild("Arm_r33", CubeListBuilder.create().texOffs(658, 38).addBox(-6.8351F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5289F, 1.0321F, 3.0404F, -0.2404F, 0.2686F, -0.7273F));

		PartDefinition Arm_r34 = Body21.addOrReplaceChild("Arm_r34", CubeListBuilder.create().texOffs(658, 38).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0763F, -1.7194F, -3.5738F, 0.0F, -0.0436F, -0.7854F));

		PartDefinition TorsoTop_r18 = Body21.addOrReplaceChild("TorsoTop_r18", CubeListBuilder.create().texOffs(658, 38).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom_r6 = Body21.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(658, 38).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body22 = OutsideExtras4.addOrReplaceChild("Body22", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition Limb_r4 = Body22.addOrReplaceChild("Limb_r4", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.342F, -0.9397F, -0.6264F, 0.2865F, -0.1074F));

		PartDefinition BackPart2 = LeftJaw.addOrReplaceChild("BackPart2", CubeListBuilder.create().texOffs(72, 335).addBox(-5.6667F, -3.7414F, -20.4933F, 11.0F, 5.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition topJawLeft_r6 = BackPart2.addOrReplaceChild("topJawLeft_r6", CubeListBuilder.create().texOffs(300, 276).addBox(-15.75F, -8.5F, -5.51F, 24.0F, 6.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, -0.4363F));

		PartDefinition topJawRight_r6 = BackPart2.addOrReplaceChild("topJawRight_r6", CubeListBuilder.create().texOffs(304, 0).addBox(-15.0F, -3.0F, -9.5F, 22.0F, 6.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0249F, 0.9957F, -9.0033F, 0.0F, -3.1416F, 0.4363F));

		PartDefinition LeftTusk = LeftJaw.addOrReplaceChild("LeftTusk", CubeListBuilder.create().texOffs(0, 661).mirror().addBox(-5.0F, -10.0F, -25.5F, 10.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(642, 662).mirror().addBox(0.0F, -16.0F, -25.5F, 0.0F, 9.0F, 29.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -14.0F, -11.5F, -0.0873F, 0.0F, 0.0F));

		PartDefinition tuskbody9 = LeftTusk.addOrReplaceChild("tuskbody9", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0563F, -10.5624F, -8.5254F, 0.6528F, -0.0895F, 0.3015F));

		PartDefinition TorsoBase_r13 = tuskbody9.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r35 = tuskbody9.addOrReplaceChild("Arm_r35", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r36 = tuskbody9.addOrReplaceChild("Arm_r36", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r19 = tuskbody9.addOrReplaceChild("TorsoTop_r19", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r8 = tuskbody9.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition tuskbody10 = LeftTusk.addOrReplaceChild("tuskbody10", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.9437F, -7.5624F, -16.5254F, -2.4357F, 0.0353F, 2.4462F));

		PartDefinition TorsoBase_r14 = tuskbody10.addOrReplaceChild("TorsoBase_r14", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1958F, 3.1988F, 2.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r37 = tuskbody10.addOrReplaceChild("Arm_r37", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition TorsoTop_r20 = tuskbody10.addOrReplaceChild("TorsoTop_r20", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r9 = tuskbody10.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition rtusk4 = LeftTusk.addOrReplaceChild("rtusk4", CubeListBuilder.create().texOffs(80, 660).mirror().addBox(-3.0F, -3.0F, -33.0F, 6.0F, 6.0F, 34.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 610).mirror().addBox(0.0F, -12.0F, -33.0F, 0.0F, 9.0F, 34.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -5.0F, -24.5F, -0.9163F, 0.0F, 0.0F));

		PartDefinition tuskbody11 = rtusk4.addOrReplaceChild("tuskbody11", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.1437F, 3.5376F, -3.0254F, -0.4287F, -1.1829F, -1.6772F));

		PartDefinition TorsoBase_r15 = tuskbody11.addOrReplaceChild("TorsoBase_r15", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0042F, 2.3988F, 2.1066F, -0.8669F, 0.1775F, -0.2265F));

		PartDefinition Arm_r38 = tuskbody11.addOrReplaceChild("Arm_r38", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r39 = tuskbody11.addOrReplaceChild("Arm_r39", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r21 = tuskbody11.addOrReplaceChild("TorsoTop_r21", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r10 = tuskbody11.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -1.2697F, -6.66F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition tuskbody12 = rtusk4.addOrReplaceChild("tuskbody12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6563F, -5.6624F, -5.1254F, -2.726F, -1.1546F, -2.3537F));

		PartDefinition TorsoBase_r16 = tuskbody12.addOrReplaceChild("TorsoBase_r16", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6042F, 2.9988F, 1.0066F, -1.5999F, 0.1775F, -0.2265F));

		PartDefinition Arm_r40 = tuskbody12.addOrReplaceChild("Arm_r40", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r41 = tuskbody12.addOrReplaceChild("Arm_r41", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r22 = tuskbody12.addOrReplaceChild("TorsoTop_r22", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r11 = tuskbody12.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -1.2697F, -6.6599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition tuskbody13 = rtusk4.addOrReplaceChild("tuskbody13", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.9437F, 1.4376F, -14.0254F, 0.1831F, -0.4019F, -1.2362F));

		PartDefinition TorsoBase_r17 = tuskbody13.addOrReplaceChild("TorsoBase_r17", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.2042F, 0.3988F, 3.3066F, -0.3434F, 0.3985F, -0.4407F));

		PartDefinition Arm_r42 = tuskbody13.addOrReplaceChild("Arm_r42", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -2.0202F, -0.6176F, -0.5882F));

		PartDefinition Arm_r43 = tuskbody13.addOrReplaceChild("Arm_r43", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -1.8797F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r23 = tuskbody13.addOrReplaceChild("TorsoTop_r23", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.5912F, 0.3892F, -0.3817F));

		PartDefinition Head_r12 = tuskbody13.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -1.2697F, -8.66F, -1.9955F, -0.0972F, -0.2852F));

		PartDefinition tuskbody15 = rtusk4.addOrReplaceChild("tuskbody15", CubeListBuilder.create(), PartPose.offsetAndRotation(4.9563F, 1.7376F, -16.5254F, 0.7028F, -0.9087F, 1.4018F));

		PartDefinition TorsoBase_r18 = tuskbody15.addOrReplaceChild("TorsoBase_r18", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3958F, 1.5988F, 0.1066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r44 = tuskbody15.addOrReplaceChild("Arm_r44", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2431F, 1.8062F, -1.104F, -0.5601F, -0.2854F, 0.2112F));

		PartDefinition TorsoTop_r24 = tuskbody15.addOrReplaceChild("TorsoTop_r24", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.1F, -2.0F, -0.0657F, 0.559F, 0.8483F));

		PartDefinition tuskbody23 = rtusk4.addOrReplaceChild("tuskbody23", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0437F, -2.6223F, -28.1683F, 1.0695F, 0.219F, 0.5337F));

		PartDefinition TorsoBase_r19 = tuskbody23.addOrReplaceChild("TorsoBase_r19", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.3958F, 1.5988F, 0.1066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r45 = tuskbody23.addOrReplaceChild("Arm_r45", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2431F, 1.8062F, -1.104F, -0.5601F, -0.2854F, 0.2112F));

		PartDefinition TorsoTop_r25 = tuskbody23.addOrReplaceChild("TorsoTop_r25", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.1F, -2.0F, -0.0657F, 0.559F, 0.8483F));

		PartDefinition tuskbody24 = rtusk4.addOrReplaceChild("tuskbody24", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.3437F, -7.0223F, -14.7683F, 1.978F, -0.3654F, -0.4862F));

		PartDefinition TorsoBase_r20 = tuskbody24.addOrReplaceChild("TorsoBase_r20", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.6042F, 2.9988F, 1.0066F, -1.5999F, 0.1775F, -0.2265F));

		PartDefinition Arm_r46 = tuskbody24.addOrReplaceChild("Arm_r46", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r47 = tuskbody24.addOrReplaceChild("Arm_r47", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r26 = tuskbody24.addOrReplaceChild("TorsoTop_r26", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r13 = tuskbody24.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -1.2697F, -6.6599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition leftTurskJoint = rtusk4.addOrReplaceChild("leftTurskJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition tuskbody22 = leftTurskJoint.addOrReplaceChild("tuskbody22", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0437F, 6.3777F, -17.1683F, 0.7129F, -0.7039F, 0.9115F));

		PartDefinition TorsoBase_r21 = tuskbody22.addOrReplaceChild("TorsoBase_r21", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1958F, 3.1988F, 2.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r48 = tuskbody22.addOrReplaceChild("Arm_r48", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition TorsoTop_r27 = tuskbody22.addOrReplaceChild("TorsoTop_r27", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition rtusk5 = leftTurskJoint.addOrReplaceChild("rtusk5", CubeListBuilder.create().texOffs(85, 664).mirror().addBox(-2.0F, -2.0F, -29.0F, 4.0F, 4.0F, 30.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(160, 644).mirror().addBox(0.0F, -10.0F, -39.0F, 0.0F, 20.0F, 36.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition tuskbody16 = rtusk5.addOrReplaceChild("tuskbody16", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9437F, -2.5624F, -17.0254F, 0.6528F, -0.0895F, 0.3015F));

		PartDefinition TorsoBase_r22 = tuskbody16.addOrReplaceChild("TorsoBase_r22", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r49 = tuskbody16.addOrReplaceChild("Arm_r49", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.457F, -0.1938F, -3.704F, -1.6936F, -0.8402F, -0.9812F));

		PartDefinition Arm_r50 = tuskbody16.addOrReplaceChild("Arm_r50", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r28 = tuskbody16.addOrReplaceChild("TorsoTop_r28", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r14 = tuskbody16.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.3049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition tuskbody14 = leftTurskJoint.addOrReplaceChild("tuskbody14", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0437F, 1.7376F, 0.4746F, -0.7375F, -0.6775F, 2.8066F));

		PartDefinition TorsoBase_r23 = tuskbody14.addOrReplaceChild("TorsoBase_r23", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1958F, 3.1988F, 2.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r51 = tuskbody14.addOrReplaceChild("Arm_r51", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition TorsoTop_r29 = tuskbody14.addOrReplaceChild("TorsoTop_r29", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition tuskbody21 = leftTurskJoint.addOrReplaceChild("tuskbody21", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9437F, 8.0777F, -0.6683F, -0.2302F, -0.0128F, -0.9081F));

		PartDefinition TorsoBase_r24 = tuskbody21.addOrReplaceChild("TorsoBase_r24", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.2042F, 0.3988F, 3.3066F, -0.3434F, 0.3985F, -0.4407F));

		PartDefinition Arm_r52 = tuskbody21.addOrReplaceChild("Arm_r52", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -2.0202F, -0.6176F, -0.5882F));

		PartDefinition Arm_r53 = tuskbody21.addOrReplaceChild("Arm_r53", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -1.8797F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r30 = tuskbody21.addOrReplaceChild("TorsoTop_r30", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.5912F, 0.3892F, -0.3817F));

		PartDefinition Head_r15 = tuskbody21.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(629, 36).mirror().addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.1049F, -1.2697F, -8.66F, -1.9955F, -0.0972F, -0.2852F));

		PartDefinition Head = Leviathan.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0F, 14.0F));

		PartDefinition DownJaw = Head.addOrReplaceChild("DownJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 6.0F, -4.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r2 = DownJaw.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(102, 361).addBox(-3.0F, 10.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -37.1577F, -48.2909F, -0.48F, 0.0F, 0.0F));

		PartDefinition Head_r16 = DownJaw.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(640, 141).addBox(15.0F, -13.0F, -20.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(671, 160).addBox(15.0F, -7.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -29.0F, 0.0F, -1.2654F, -3.1416F));

		PartDefinition Head_r17 = DownJaw.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(673, 160).addBox(11.0F, -10.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(640, 141).addBox(11.0F, -16.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -29.0F, 0.0F, -0.7418F, -3.1416F));

		PartDefinition Head_r18 = DownJaw.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(671, 160).addBox(-13.0F, -8.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(640, 141).addBox(-13.0F, -14.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -29.0F, 0.0F, 1.2654F, -3.1416F));

		PartDefinition Head_r19 = DownJaw.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(671, 160).addBox(-4.0F, -10.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(640, 141).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -29.0F, 0.0F, 0.4363F, -3.1416F));

		PartDefinition cube_r3 = DownJaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(382, 101).addBox(-10.0F, -12.0F, -8.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, -17.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r4 = DownJaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 249).addBox(-11.0F, -21.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 26.0F, 1.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition TopJaw = Head.addOrReplaceChild("TopJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -21.0F, -5.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r5 = TopJaw.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(102, 361).addBox(-3.0F, -26.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 37.1577F, -48.2909F, 0.48F, 0.0F, 0.0F));

		PartDefinition Head_r20 = TopJaw.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(640, 141).addBox(-5.0192F, -5.0F, -6.39F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -11.0F, -16.25F, -0.1375F, 1.2624F, -0.1442F));

		PartDefinition Head_r21 = TopJaw.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(671, 159).addBox(15.0F, 5.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -29.0F, 0.0F, -1.2654F, 3.1416F));

		PartDefinition Head_r22 = TopJaw.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(671, 159).addBox(11.0F, 8.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -29.0F, 0.0F, -0.7418F, 3.1416F));

		PartDefinition Head_r23 = TopJaw.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(640, 141).addBox(-4.6913F, -1.4514F, -6.5466F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -17.5F, -24.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition Head_r24 = TopJaw.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(671, 159).addBox(-13.0F, 6.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -29.0F, 0.0F, 1.2654F, 3.1416F));

		PartDefinition Head_r25 = TopJaw.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(671, 160).addBox(-4.0F, 9.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -29.0F, 0.0F, 0.4363F, 3.1416F));

		PartDefinition Head_r26 = TopJaw.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(640, 141).addBox(-4.4681F, -4.0F, -0.5445F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.75F, -12.75F, -20.0F, 0.1375F, -1.2624F, -0.1442F));

		PartDefinition Head_r27 = TopJaw.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(640, 141).addBox(-4.0F, -4.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -15.0F, -29.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r6 = TopJaw.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(322, 129).addBox(-10.0F, 7.0F, -8.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, -17.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r7 = TopJaw.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(312, 121).addBox(-11.0F, 15.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -26.0F, 1.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition Body10 = TopJaw.addOrReplaceChild("Body10", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0833F, -19.7586F, -14.2567F, -2.372F, 0.8452F, -2.5144F));

		PartDefinition Torso_r6 = Body10.addOrReplaceChild("Torso_r6", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r54 = Body10.addOrReplaceChild("Arm_r54", CubeListBuilder.create().texOffs(658, 38).addBox(0.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Body9 = TopJaw.addOrReplaceChild("Body9", CubeListBuilder.create().texOffs(658, 38).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0833F, -15.7586F, -9.2567F, -0.48F, 0.0F, 0.0F));

		PartDefinition Torso_r7 = Body9.addOrReplaceChild("Torso_r7", CubeListBuilder.create().texOffs(658, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r55 = Body9.addOrReplaceChild("Arm_r55", CubeListBuilder.create().texOffs(658, 38).addBox(0.0948F, -1.1343F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition AcidCannon = Head.addOrReplaceChild("AcidCannon", CubeListBuilder.create().texOffs(549, 87).addBox(-6.0F, -32.75F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2299F, -2.8908F, 15.6228F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Flower = AcidCannon.addOrReplaceChild("Flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.6265F, -29.1357F, 0.6361F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition TumorBase = Flower.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(546, 100).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 4.0F, -1.0F, -0.5236F, 0.0F, -0.3927F));

		PartDefinition FlowerMaw = Flower.addOrReplaceChild("FlowerMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 3.0F, -0.4078F, 1.0117F, -0.2083F));

		PartDefinition SouthMaw = FlowerMaw.addOrReplaceChild("SouthMaw", CubeListBuilder.create().texOffs(534, 100).addBox(-5.0F, -5.8061F, -0.7458F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.25F, 3.5F, -0.9009F, -0.0035F, -0.1224F));

		PartDefinition Tooth_r1 = SouthMaw.addOrReplaceChild("Tooth_r1", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -3.5F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4226F, -1.5F, -1.4063F, 3.1416F, -0.4363F, 0.0F));

		PartDefinition Tooth_r2 = SouthMaw.addOrReplaceChild("Tooth_r2", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4226F, -3.0F, -1.4063F, 3.1416F, 0.4363F, 0.0F));

		PartDefinition SMawSeg2 = SouthMaw.addOrReplaceChild("SMawSeg2", CubeListBuilder.create().texOffs(534, 100).addBox(-5.0F, -6.0584F, 0.6455F, 9.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -5.0256F, -1.3373F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Tooth_r3 = SMawSeg2.addOrReplaceChild("Tooth_r3", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8199F, -2.6107F, 0.2085F, 3.1416F, -0.3054F, -0.1309F));

		PartDefinition Tooth_r4 = SMawSeg2.addOrReplaceChild("Tooth_r4", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2981F, -3.0241F, 0.1226F, 3.1416F, 0.3054F, 0.1309F));

		PartDefinition SMawSeg3 = SMawSeg2.addOrReplaceChild("SMawSeg3", CubeListBuilder.create().texOffs(534, 100).addBox(-4.5F, -4.5F, -1.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.5F, -5.5584F, 1.6455F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tooth_r5 = SMawSeg3.addOrReplaceChild("Tooth_r5", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.25F, -0.75F, 3.1416F, -0.3491F, -0.2182F));

		PartDefinition NWMaw = FlowerMaw.addOrReplaceChild("NWMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, -3.0F, 0.3047F, -1.0009F, 0.2668F));

		PartDefinition Tooth_r6 = NWMaw.addOrReplaceChild("Tooth_r6", CubeListBuilder.create().texOffs(663, 177).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition NWMawSeg1_r1 = NWMaw.addOrReplaceChild("NWMawSeg1_r1", CubeListBuilder.create().texOffs(534, 100).addBox(-5.0F, -3.5F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NWMawSeg2 = NWMaw.addOrReplaceChild("NWMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Tooth_r7 = NWMawSeg2.addOrReplaceChild("Tooth_r7", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7208F, -2.8231F, 0.794F, 0.0F, -0.1745F, 0.3927F));

		PartDefinition Tooth_r8 = NWMawSeg2.addOrReplaceChild("Tooth_r8", CubeListBuilder.create().texOffs(663, 173).addBox(-1.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2792F, -3.3231F, 1.794F, 0.0535F, -0.2825F, -0.8119F));

		PartDefinition NWMawSeg2_r1 = NWMawSeg2.addOrReplaceChild("NWMawSeg2_r1", CubeListBuilder.create().texOffs(534, 100).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMaw = FlowerMaw.addOrReplaceChild("NSMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.3156F, 0.9359F, -0.3408F));

		PartDefinition Tooth_r9 = NSMaw.addOrReplaceChild("Tooth_r9", CubeListBuilder.create().texOffs(663, 176).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 1.0F, 0.0475F, -0.346F, -0.1392F));

		PartDefinition Tooth_r10 = NSMaw.addOrReplaceChild("Tooth_r10", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition NSMawSeg1_r1 = NSMaw.addOrReplaceChild("NSMawSeg1_r1", CubeListBuilder.create().texOffs(534, 100).addBox(-4.0F, -3.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg2 = NSMaw.addOrReplaceChild("NSMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -7.4768F, 0.8515F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Tooth_r11 = NSMawSeg2.addOrReplaceChild("Tooth_r11", CubeListBuilder.create().texOffs(663, 173).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition NSMawSeg2_r1 = NSMawSeg2.addOrReplaceChild("NSMawSeg2_r1", CubeListBuilder.create().texOffs(534, 100).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg3 = NSMawSeg2.addOrReplaceChild("NSMawSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -2.25F, 0.25F, -0.6109F, 0.0F, 0.0F));

		PartDefinition Tooth_r12 = NSMawSeg3.addOrReplaceChild("Tooth_r12", CubeListBuilder.create().texOffs(663, 173).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.2182F));

		PartDefinition Tooth_r13 = NSMawSeg3.addOrReplaceChild("Tooth_r13", CubeListBuilder.create().texOffs(663, 173).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition NSMawSeg3_r1 = NSMawSeg3.addOrReplaceChild("NSMawSeg3_r1", CubeListBuilder.create().texOffs(534, 100).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -0.1015F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Base = Leviathan.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(-8.0F, -60.0F, 33.0F));

		PartDefinition front_r1 = Base.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(138, 412).addBox(26.0F, 11.0F, -0.75F, 6.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 9.25F, 24.5F, 0.0381F, 0.1704F, 0.2214F));

		PartDefinition front_r2 = Base.addOrReplaceChild("front_r2", CubeListBuilder.create().texOffs(312, 145).addBox(-14.3247F, -14.5156F, -1.6631F, 33.0F, 26.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.75F, 29.25F, 56.5F, -0.0057F, 0.1268F, 0.2634F));

		PartDefinition front_r3 = Base.addOrReplaceChild("front_r3", CubeListBuilder.create().texOffs(252, 472).addBox(26.0F, 8.0F, -1.25F, 9.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.0F, -27.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition front_r4 = Base.addOrReplaceChild("front_r4", CubeListBuilder.create().texOffs(310, 56).addBox(-7.0F, 4.0F, -1.0F, 33.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 12.3F, -27.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition s_r1 = Base.addOrReplaceChild("s_r1", CubeListBuilder.create().texOffs(156, 186).addBox(-14.9882F, -6.9506F, -7.3352F, 28.0F, 8.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8959F, 43.9464F, 23.2526F, 0.1835F, 0.058F, 0.8732F));

		PartDefinition s_r2 = Base.addOrReplaceChild("s_r2", CubeListBuilder.create().texOffs(0, 188).addBox(-4.0F, -20.0F, -8.0F, 8.0F, 22.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3894F, 26.9845F, 29.7862F, -0.2182F, 0.0F, 0.0F));

		PartDefinition s_r3 = Base.addOrReplaceChild("s_r3", CubeListBuilder.create().texOffs(176, 0).addBox(-4.0F, -20.0F, -28.0F, 8.0F, 22.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.3894F, 48.9845F, -1.2138F, 0.0811F, 0.1835F, 0.0905F));

		PartDefinition s_r4 = Base.addOrReplaceChild("s_r4", CubeListBuilder.create().texOffs(0, 124).addBox(-21.0F, -4.0F, -28.0F, 22.0F, 8.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9653F, 11.7965F, -0.0603F, -0.1262F, 0.0715F, -1.36F));

		PartDefinition s_r5 = Base.addOrReplaceChild("s_r5", CubeListBuilder.create().texOffs(162, 78).addBox(-16.1878F, -0.0389F, -2.9181F, 34.0F, 5.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9817F, 7.2622F, 27.0443F, -0.1958F, 0.0418F, 0.1702F));

		PartDefinition s_r6 = Base.addOrReplaceChild("s_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-10.5114F, -30.7797F, -25.923F, 34.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0183F, 37.2622F, -0.9557F, 0.066F, 0.0418F, 0.1702F));

		PartDefinition s2_r1 = Base.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(94, 236).addBox(-16.5F, 0.0F, 0.0F, 28.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.4901F, 25.9404F, 24.4399F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s2_r2 = Base.addOrReplaceChild("s2_r2", CubeListBuilder.create().texOffs(0, 274).addBox(-10.5F, 0.0F, 0.0F, 27.0F, 8.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(32.4901F, 19.9404F, -4.5601F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s1_r1 = Base.addOrReplaceChild("s1_r1", CubeListBuilder.create().texOffs(114, 274).addBox(-5.5F, -4.0F, -2.0F, 22.0F, 8.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.9209F, 20.5215F, -28.1892F, 0.209F, 0.0442F, 1.1759F));

		PartDefinition s_r7 = Base.addOrReplaceChild("s_r7", CubeListBuilder.create().texOffs(210, 236).addBox(-11.7831F, -3.2346F, -4.97F, 24.0F, 8.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9817F, 45.2622F, 27.0443F, 0.0859F, 0.123F, -0.3518F));

		PartDefinition s_r8 = Base.addOrReplaceChild("s_r8", CubeListBuilder.create().texOffs(156, 124).addBox(-15.5525F, 20.9337F, -25.5293F, 24.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9817F, 24.2622F, -0.9557F, 0.0057F, 0.1308F, 0.044F));

		PartDefinition s_r9 = Base.addOrReplaceChild("s_r9", CubeListBuilder.create().texOffs(0, 62).addBox(-3.6818F, 21.2121F, -25.5293F, 27.0F, 8.0F, 54.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 32.2622F, -0.9557F, -0.0887F, 0.0964F, -0.746F));

		PartDefinition details = Leviathan.addOrReplaceChild("details", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin = details.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offset(-0.25F, -29.25F, 28.0F));

		PartDefinition FinMembrane1_r1 = fin.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(94, 188).addBox(-0.01F, -18.0F, -2.0F, 0.0F, 25.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -24.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = fin.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(563, 40).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -27.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition fin2 = details.addOrReplaceChild("fin2", CubeListBuilder.create().texOffs(360, 330).addBox(0.0F, -23.0F, -3.0F, 0.0F, 25.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -49.75F, 21.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition FinSupport_r2 = fin2.addOrReplaceChild("FinSupport_r2", CubeListBuilder.create().texOffs(561, 34).addBox(-2.0F, -25.0F, -1.0F, 4.0F, 25.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition fin3 = details.addOrReplaceChild("fin3", CubeListBuilder.create().texOffs(60, 361).addBox(-0.1F, -23.0F, -5.0F, 0.0F, 25.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -54.75F, 41.0F));

		PartDefinition FinSupport_r3 = fin3.addOrReplaceChild("FinSupport_r3", CubeListBuilder.create().texOffs(545, 33).addBox(-2.0F, -27.0F, -3.0F, 4.0F, 27.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition fin4 = details.addOrReplaceChild("fin4", CubeListBuilder.create().texOffs(160, 366).addBox(0.0F, -19.0F, -9.0F, 0.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -54.75F, 61.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition FinSupport_r4 = fin4.addOrReplaceChild("FinSupport_r4", CubeListBuilder.create().texOffs(554, 37).addBox(-2.0F, -24.0F, -2.0F, 4.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition fin5 = details.addOrReplaceChild("fin5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -50.75F, 80.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition FinMemebrane2_r1 = fin5.addOrReplaceChild("FinMemebrane2_r1", CubeListBuilder.create().texOffs(386, 179).addBox(-0.1F, -15.0F, -2.0F, 0.0F, 17.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition FinSupport_r5 = fin5.addOrReplaceChild("FinSupport_r5", CubeListBuilder.create().texOffs(552, 39).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 12.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition FinSupport_r6 = fin5.addOrReplaceChild("FinSupport_r6", CubeListBuilder.create().texOffs(552, 41).addBox(-2.0F, -20.0F, -2.0F, 4.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -6.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition RightSidefin = details.addOrReplaceChild("RightSidefin", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.25F, -39.25F, 39.0F, 1.6174F, -1.3505F, -1.0251F));

		PartDefinition RFinmemebrane_r1 = RightSidefin.addOrReplaceChild("RFinmemebrane_r1", CubeListBuilder.create().texOffs(322, 217).addBox(-19.6851F, -23.7192F, 0.8549F, 37.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.4296F, 0.625F, 1.3428F));

		PartDefinition RfinBottom_r1 = RightSidefin.addOrReplaceChild("RfinBottom_r1", CubeListBuilder.create().texOffs(552, 37).addBox(1.3149F, -23.7192F, -0.1451F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1958F, 0.7203F, 2.2992F));

		PartDefinition RfinTop_r1 = RightSidefin.addOrReplaceChild("RfinTop_r1", CubeListBuilder.create().texOffs(546, 33).addBox(-1.0F, -19.0F, -0.25F, 2.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.7298F, 0.1468F, 0.5984F));

		PartDefinition LeftSidefin = details.addOrReplaceChild("LeftSidefin", CubeListBuilder.create(), PartPose.offsetAndRotation(23.75F, -39.25F, 21.0F, 0.7842F, -0.3983F, -0.3893F));

		PartDefinition RFinmemebrane_r2 = LeftSidefin.addOrReplaceChild("RFinmemebrane_r2", CubeListBuilder.create().texOffs(322, 241).addBox(-19.6851F, -23.7192F, 0.8549F, 37.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.4296F, 0.625F, 1.3428F));

		PartDefinition RfinBottom_r2 = LeftSidefin.addOrReplaceChild("RfinBottom_r2", CubeListBuilder.create().texOffs(563, 36).addBox(1.3149F, -23.7192F, -0.1451F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1958F, 0.7203F, 2.2992F));

		PartDefinition RfinTop_r2 = LeftSidefin.addOrReplaceChild("RfinTop_r2", CubeListBuilder.create().texOffs(563, 32).addBox(-1.0F, -28.0F, -0.25F, 2.0F, 29.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.7298F, 0.1468F, 0.5984F));

		PartDefinition CenterCorpseDetails = details.addOrReplaceChild("CenterCorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3273F, -48.25F, 81.2967F, 0.0652F, 0.1485F, -1.2605F));

		PartDefinition CenterBody1 = CenterCorpseDetails.addOrReplaceChild("CenterBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r56 = CenterBody1.addOrReplaceChild("Arm_r56", CubeListBuilder.create().texOffs(629, 46).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r28 = CenterBody1.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(629, 46).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r31 = CenterBody1.addOrReplaceChild("TorsoTop_r31", CubeListBuilder.create().texOffs(629, 46).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody2 = CenterCorpseDetails.addOrReplaceChild("CenterBody2", CubeListBuilder.create(), PartPose.offset(-24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r57 = CenterBody2.addOrReplaceChild("Arm_r57", CubeListBuilder.create().texOffs(629, 46).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r58 = CenterBody2.addOrReplaceChild("Arm_r58", CubeListBuilder.create().texOffs(629, 46).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r7 = CenterBody2.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(629, 46).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r8 = CenterBody2.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(629, 46).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r32 = CenterBody2.addOrReplaceChild("TorsoTop_r32", CubeListBuilder.create().texOffs(629, 46).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody3 = CenterCorpseDetails.addOrReplaceChild("CenterBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.5056F, -4.3398F, -3.3136F, 0.2154F, 0.6018F, 0.2843F));

		PartDefinition Leg_r3 = CenterBody3.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(629, 46).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4032F, 4.788F, 2.3728F, -0.0397F, -0.0241F, -0.177F));

		PartDefinition Leg_r4 = CenterBody3.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(629, 46).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.773F, 5.0385F, -2.4364F, -0.2132F, -0.0469F, -0.2132F));

		PartDefinition Arm_r59 = CenterBody3.addOrReplaceChild("Arm_r59", CubeListBuilder.create().texOffs(629, 46).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2343F, -6.4446F, 2.8873F, 2.007F, 0.9774F, 0.5593F));

		PartDefinition TorsoTop_r33 = CenterBody3.addOrReplaceChild("TorsoTop_r33", CubeListBuilder.create().texOffs(629, 46).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0056F, -0.6602F, -0.6864F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r25 = CenterBody3.addOrReplaceChild("TorsoBase_r25", CubeListBuilder.create().texOffs(629, 46).addBox(-1.75F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, 3.3398F, -0.1864F, 0.0411F, -0.3027F, 0.2555F));

		PartDefinition CenterBody4 = CenterCorpseDetails.addOrReplaceChild("CenterBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r26 = CenterBody4.addOrReplaceChild("TorsoBase_r26", CubeListBuilder.create().texOffs(629, 46).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r60 = CenterBody4.addOrReplaceChild("Arm_r60", CubeListBuilder.create().texOffs(629, 46).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r61 = CenterBody4.addOrReplaceChild("Arm_r61", CubeListBuilder.create().texOffs(629, 46).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r34 = CenterBody4.addOrReplaceChild("TorsoTop_r34", CubeListBuilder.create().texOffs(629, 46).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r29 = CenterBody4.addOrReplaceChild("Head_r29", CubeListBuilder.create().texOffs(629, 46).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails2 = details.addOrReplaceChild("CenterCorpseDetails2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3273F, -42.25F, 81.2967F, 0.003F, -0.162F, 1.6578F));

		PartDefinition CenterBody5 = CenterCorpseDetails2.addOrReplaceChild("CenterBody5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r62 = CenterBody5.addOrReplaceChild("Arm_r62", CubeListBuilder.create().texOffs(635, 36).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r30 = CenterBody5.addOrReplaceChild("Head_r30", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r35 = CenterBody5.addOrReplaceChild("TorsoTop_r35", CubeListBuilder.create().texOffs(635, 36).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody6 = CenterCorpseDetails2.addOrReplaceChild("CenterBody6", CubeListBuilder.create(), PartPose.offset(24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r63 = CenterBody6.addOrReplaceChild("Arm_r63", CubeListBuilder.create().texOffs(635, 36).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r64 = CenterBody6.addOrReplaceChild("Arm_r64", CubeListBuilder.create().texOffs(635, 36).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r9 = CenterBody6.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(635, 36).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r10 = CenterBody6.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(635, 36).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r36 = CenterBody6.addOrReplaceChild("TorsoTop_r36", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody7 = CenterCorpseDetails2.addOrReplaceChild("CenterBody7", CubeListBuilder.create(), PartPose.offsetAndRotation(32.5056F, -4.3398F, -3.3136F, 0.2154F, -0.6018F, -0.2843F));

		PartDefinition Leg_r5 = CenterBody7.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(635, 36).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r6 = CenterBody7.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(635, 36).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r65 = CenterBody7.addOrReplaceChild("Arm_r65", CubeListBuilder.create().texOffs(635, 36).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r37 = CenterBody7.addOrReplaceChild("TorsoTop_r37", CubeListBuilder.create().texOffs(635, 36).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r27 = CenterBody7.addOrReplaceChild("TorsoBase_r27", CubeListBuilder.create().texOffs(635, 36).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody8 = CenterCorpseDetails2.addOrReplaceChild("CenterBody8", CubeListBuilder.create(), PartPose.offsetAndRotation(12.75F, -19.1707F, -4.6424F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r28 = CenterBody8.addOrReplaceChild("TorsoBase_r28", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r66 = CenterBody8.addOrReplaceChild("Arm_r66", CubeListBuilder.create().texOffs(635, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r67 = CenterBody8.addOrReplaceChild("Arm_r67", CubeListBuilder.create().texOffs(635, 36).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r38 = CenterBody8.addOrReplaceChild("TorsoTop_r38", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r31 = CenterBody8.addOrReplaceChild("Head_r31", CubeListBuilder.create().texOffs(635, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterBody29 = CenterCorpseDetails2.addOrReplaceChild("CenterBody29", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -15.1707F, -12.6424F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r29 = CenterBody29.addOrReplaceChild("TorsoBase_r29", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r68 = CenterBody29.addOrReplaceChild("Arm_r68", CubeListBuilder.create().texOffs(635, 36).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r69 = CenterBody29.addOrReplaceChild("Arm_r69", CubeListBuilder.create().texOffs(635, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r39 = CenterBody29.addOrReplaceChild("TorsoTop_r39", CubeListBuilder.create().texOffs(635, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r32 = CenterBody29.addOrReplaceChild("Head_r32", CubeListBuilder.create().texOffs(635, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails3 = details.addOrReplaceChild("CenterCorpseDetails3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.3273F, -53.25F, 58.2967F, -1.4976F, -1.471F, 1.6288F));

		PartDefinition CenterBody9 = CenterCorpseDetails3.addOrReplaceChild("CenterBody9", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r70 = CenterBody9.addOrReplaceChild("Arm_r70", CubeListBuilder.create().texOffs(658, 40).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r33 = CenterBody9.addOrReplaceChild("Head_r33", CubeListBuilder.create().texOffs(658, 40).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r40 = CenterBody9.addOrReplaceChild("TorsoTop_r40", CubeListBuilder.create().texOffs(658, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody10 = CenterCorpseDetails3.addOrReplaceChild("CenterBody10", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4969F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r71 = CenterBody10.addOrReplaceChild("Arm_r71", CubeListBuilder.create().texOffs(658, 40).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r72 = CenterBody10.addOrReplaceChild("Arm_r72", CubeListBuilder.create().texOffs(658, 40).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r11 = CenterBody10.addOrReplaceChild("TorsoBottom_r11", CubeListBuilder.create().texOffs(658, 40).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r12 = CenterBody10.addOrReplaceChild("TorsoBottom_r12", CubeListBuilder.create().texOffs(658, 40).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r41 = CenterBody10.addOrReplaceChild("TorsoTop_r41", CubeListBuilder.create().texOffs(658, 40).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody11 = CenterCorpseDetails3.addOrReplaceChild("CenterBody11", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, 2.1633F, -0.731F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r7 = CenterBody11.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(658, 40).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r8 = CenterBody11.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(658, 40).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r73 = CenterBody11.addOrReplaceChild("Arm_r73", CubeListBuilder.create().texOffs(658, 40).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r42 = CenterBody11.addOrReplaceChild("TorsoTop_r42", CubeListBuilder.create().texOffs(658, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r30 = CenterBody11.addOrReplaceChild("TorsoBase_r30", CubeListBuilder.create().texOffs(658, 40).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody12 = CenterCorpseDetails3.addOrReplaceChild("CenterBody12", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3325F, -2.0598F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r31 = CenterBody12.addOrReplaceChild("TorsoBase_r31", CubeListBuilder.create().texOffs(658, 40).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r74 = CenterBody12.addOrReplaceChild("Arm_r74", CubeListBuilder.create().texOffs(658, 40).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r75 = CenterBody12.addOrReplaceChild("Arm_r75", CubeListBuilder.create().texOffs(658, 40).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r43 = CenterBody12.addOrReplaceChild("TorsoTop_r43", CubeListBuilder.create().texOffs(658, 40).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r34 = CenterBody12.addOrReplaceChild("Head_r34", CubeListBuilder.create().texOffs(658, 40).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails4 = details.addOrReplaceChild("CenterCorpseDetails4", CubeListBuilder.create(), PartPose.offsetAndRotation(10.3273F, -53.25F, 20.2967F, -0.5045F, -1.3637F, 0.627F));

		PartDefinition CenterBody13 = CenterCorpseDetails4.addOrReplaceChild("CenterBody13", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r76 = CenterBody13.addOrReplaceChild("Arm_r76", CubeListBuilder.create().texOffs(644, 40).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r35 = CenterBody13.addOrReplaceChild("Head_r35", CubeListBuilder.create().texOffs(644, 40).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r44 = CenterBody13.addOrReplaceChild("TorsoTop_r44", CubeListBuilder.create().texOffs(644, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody14 = CenterCorpseDetails4.addOrReplaceChild("CenterBody14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4969F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r77 = CenterBody14.addOrReplaceChild("Arm_r77", CubeListBuilder.create().texOffs(644, 40).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r78 = CenterBody14.addOrReplaceChild("Arm_r78", CubeListBuilder.create().texOffs(644, 40).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r13 = CenterBody14.addOrReplaceChild("TorsoBottom_r13", CubeListBuilder.create().texOffs(644, 40).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r14 = CenterBody14.addOrReplaceChild("TorsoBottom_r14", CubeListBuilder.create().texOffs(644, 40).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r45 = CenterBody14.addOrReplaceChild("TorsoTop_r45", CubeListBuilder.create().texOffs(644, 40).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody15 = CenterCorpseDetails4.addOrReplaceChild("CenterBody15", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, 2.1633F, -0.731F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r9 = CenterBody15.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(644, 40).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r10 = CenterBody15.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(644, 40).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r79 = CenterBody15.addOrReplaceChild("Arm_r79", CubeListBuilder.create().texOffs(644, 40).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r46 = CenterBody15.addOrReplaceChild("TorsoTop_r46", CubeListBuilder.create().texOffs(644, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r32 = CenterBody15.addOrReplaceChild("TorsoBase_r32", CubeListBuilder.create().texOffs(644, 40).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody16 = CenterCorpseDetails4.addOrReplaceChild("CenterBody16", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3325F, -2.0598F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r33 = CenterBody16.addOrReplaceChild("TorsoBase_r33", CubeListBuilder.create().texOffs(644, 40).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r80 = CenterBody16.addOrReplaceChild("Arm_r80", CubeListBuilder.create().texOffs(644, 40).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r81 = CenterBody16.addOrReplaceChild("Arm_r81", CubeListBuilder.create().texOffs(644, 40).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r47 = CenterBody16.addOrReplaceChild("TorsoTop_r47", CubeListBuilder.create().texOffs(644, 40).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r36 = CenterBody16.addOrReplaceChild("Head_r36", CubeListBuilder.create().texOffs(644, 40).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails5 = details.addOrReplaceChild("CenterCorpseDetails5", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6727F, -53.25F, 26.2967F, -0.4639F, 1.3007F, -0.8021F));

		PartDefinition CenterBody17 = CenterCorpseDetails5.addOrReplaceChild("CenterBody17", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0502F, -2.9004F, 3.0636F, 0.0F, 0.0F, 1.0472F));

		PartDefinition Arm_r82 = CenterBody17.addOrReplaceChild("Arm_r82", CubeListBuilder.create().texOffs(629, 36).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r37 = CenterBody17.addOrReplaceChild("Head_r37", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r48 = CenterBody17.addOrReplaceChild("TorsoTop_r48", CubeListBuilder.create().texOffs(629, 36).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody18 = CenterCorpseDetails5.addOrReplaceChild("CenterBody18", CubeListBuilder.create(), PartPose.offset(1.9498F, -3.9004F, 3.0636F));

		PartDefinition Arm_r83 = CenterBody18.addOrReplaceChild("Arm_r83", CubeListBuilder.create().texOffs(629, 36).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r84 = CenterBody18.addOrReplaceChild("Arm_r84", CubeListBuilder.create().texOffs(629, 36).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0544F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r15 = CenterBody18.addOrReplaceChild("TorsoBottom_r15", CubeListBuilder.create().texOffs(629, 36).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r16 = CenterBody18.addOrReplaceChild("TorsoBottom_r16", CubeListBuilder.create().texOffs(629, 36).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r49 = CenterBody18.addOrReplaceChild("TorsoTop_r49", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody19 = CenterCorpseDetails5.addOrReplaceChild("CenterBody19", CubeListBuilder.create(), PartPose.offsetAndRotation(12.4554F, 3.7598F, -0.25F, 0.4785F, -0.4343F, -0.8047F));

		PartDefinition Leg_r11 = CenterBody19.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(629, 36).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r12 = CenterBody19.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(629, 36).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r85 = CenterBody19.addOrReplaceChild("Arm_r85", CubeListBuilder.create().texOffs(629, 36).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r50 = CenterBody19.addOrReplaceChild("TorsoTop_r50", CubeListBuilder.create().texOffs(629, 36).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r34 = CenterBody19.addOrReplaceChild("TorsoBase_r34", CubeListBuilder.create().texOffs(629, 36).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody20 = CenterCorpseDetails5.addOrReplaceChild("CenterBody20", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.3002F, -7.071F, -1.5788F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r35 = CenterBody20.addOrReplaceChild("TorsoBase_r35", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r86 = CenterBody20.addOrReplaceChild("Arm_r86", CubeListBuilder.create().texOffs(629, 36).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r87 = CenterBody20.addOrReplaceChild("Arm_r87", CubeListBuilder.create().texOffs(629, 36).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r51 = CenterBody20.addOrReplaceChild("TorsoTop_r51", CubeListBuilder.create().texOffs(629, 36).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r38 = CenterBody20.addOrReplaceChild("Head_r38", CubeListBuilder.create().texOffs(629, 36).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails6 = details.addOrReplaceChild("CenterCorpseDetails6", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.6727F, -9.25F, 26.2967F, -2.7496F, 0.9847F, 0.6584F));

		PartDefinition CenterBody21 = CenterCorpseDetails6.addOrReplaceChild("CenterBody21", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0502F, -2.9003F, 3.0636F, 0.0F, 0.0F, 1.0472F));

		PartDefinition Arm_r88 = CenterBody21.addOrReplaceChild("Arm_r88", CubeListBuilder.create().texOffs(654, 38).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r39 = CenterBody21.addOrReplaceChild("Head_r39", CubeListBuilder.create().texOffs(654, 38).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r52 = CenterBody21.addOrReplaceChild("TorsoTop_r52", CubeListBuilder.create().texOffs(654, 38).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody22 = CenterCorpseDetails6.addOrReplaceChild("CenterBody22", CubeListBuilder.create(), PartPose.offset(1.9498F, -3.9003F, 3.0636F));

		PartDefinition Arm_r89 = CenterBody22.addOrReplaceChild("Arm_r89", CubeListBuilder.create().texOffs(654, 38).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r90 = CenterBody22.addOrReplaceChild("Arm_r90", CubeListBuilder.create().texOffs(654, 38).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r17 = CenterBody22.addOrReplaceChild("TorsoBottom_r17", CubeListBuilder.create().texOffs(654, 38).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r18 = CenterBody22.addOrReplaceChild("TorsoBottom_r18", CubeListBuilder.create().texOffs(654, 38).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r53 = CenterBody22.addOrReplaceChild("TorsoTop_r53", CubeListBuilder.create().texOffs(654, 38).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody23 = CenterCorpseDetails6.addOrReplaceChild("CenterBody23", CubeListBuilder.create(), PartPose.offsetAndRotation(12.4554F, 3.7598F, -0.25F, 0.4785F, -0.4343F, -0.8047F));

		PartDefinition Leg_r13 = CenterBody23.addOrReplaceChild("Leg_r13", CubeListBuilder.create().texOffs(654, 38).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r14 = CenterBody23.addOrReplaceChild("Leg_r14", CubeListBuilder.create().texOffs(654, 38).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r91 = CenterBody23.addOrReplaceChild("Arm_r91", CubeListBuilder.create().texOffs(654, 38).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r54 = CenterBody23.addOrReplaceChild("TorsoTop_r54", CubeListBuilder.create().texOffs(654, 38).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r36 = CenterBody23.addOrReplaceChild("TorsoBase_r36", CubeListBuilder.create().texOffs(654, 38).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody24 = CenterCorpseDetails6.addOrReplaceChild("CenterBody24", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.3002F, -7.071F, -1.5788F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r37 = CenterBody24.addOrReplaceChild("TorsoBase_r37", CubeListBuilder.create().texOffs(654, 38).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r92 = CenterBody24.addOrReplaceChild("Arm_r92", CubeListBuilder.create().texOffs(654, 38).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r93 = CenterBody24.addOrReplaceChild("Arm_r93", CubeListBuilder.create().texOffs(654, 38).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r55 = CenterBody24.addOrReplaceChild("TorsoTop_r55", CubeListBuilder.create().texOffs(654, 38).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r40 = CenterBody24.addOrReplaceChild("Head_r40", CubeListBuilder.create().texOffs(654, 38).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails7 = details.addOrReplaceChild("CenterCorpseDetails7", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3273F, -7.25F, 44.2967F, -2.2696F, 0.9847F, 0.6584F));

		PartDefinition CenterBody25 = CenterCorpseDetails7.addOrReplaceChild("CenterBody25", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.0502F, -2.9003F, 3.0636F, 0.0F, 0.0F, 1.0472F));

		PartDefinition Arm_r94 = CenterBody25.addOrReplaceChild("Arm_r94", CubeListBuilder.create().texOffs(639, 40).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r41 = CenterBody25.addOrReplaceChild("Head_r41", CubeListBuilder.create().texOffs(639, 40).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r56 = CenterBody25.addOrReplaceChild("TorsoTop_r56", CubeListBuilder.create().texOffs(639, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody26 = CenterCorpseDetails7.addOrReplaceChild("CenterBody26", CubeListBuilder.create(), PartPose.offset(1.9498F, -3.9003F, 3.0636F));

		PartDefinition Arm_r95 = CenterBody26.addOrReplaceChild("Arm_r95", CubeListBuilder.create().texOffs(639, 40).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r96 = CenterBody26.addOrReplaceChild("Arm_r96", CubeListBuilder.create().texOffs(639, 40).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r19 = CenterBody26.addOrReplaceChild("TorsoBottom_r19", CubeListBuilder.create().texOffs(639, 40).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r20 = CenterBody26.addOrReplaceChild("TorsoBottom_r20", CubeListBuilder.create().texOffs(639, 40).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r57 = CenterBody26.addOrReplaceChild("TorsoTop_r57", CubeListBuilder.create().texOffs(639, 40).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody27 = CenterCorpseDetails7.addOrReplaceChild("CenterBody27", CubeListBuilder.create(), PartPose.offsetAndRotation(12.4554F, 3.7598F, -0.25F, 0.4785F, -0.4343F, -0.8047F));

		PartDefinition Leg_r15 = CenterBody27.addOrReplaceChild("Leg_r15", CubeListBuilder.create().texOffs(639, 40).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r16 = CenterBody27.addOrReplaceChild("Leg_r16", CubeListBuilder.create().texOffs(639, 40).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r97 = CenterBody27.addOrReplaceChild("Arm_r97", CubeListBuilder.create().texOffs(639, 40).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r58 = CenterBody27.addOrReplaceChild("TorsoTop_r58", CubeListBuilder.create().texOffs(639, 40).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r38 = CenterBody27.addOrReplaceChild("TorsoBase_r38", CubeListBuilder.create().texOffs(639, 40).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody28 = CenterCorpseDetails7.addOrReplaceChild("CenterBody28", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.3002F, -7.071F, -1.5788F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r39 = CenterBody28.addOrReplaceChild("TorsoBase_r39", CubeListBuilder.create().texOffs(639, 40).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r98 = CenterBody28.addOrReplaceChild("Arm_r98", CubeListBuilder.create().texOffs(639, 40).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r99 = CenterBody28.addOrReplaceChild("Arm_r99", CubeListBuilder.create().texOffs(639, 40).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r59 = CenterBody28.addOrReplaceChild("TorsoTop_r59", CubeListBuilder.create().texOffs(639, 40).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r42 = CenterBody28.addOrReplaceChild("Head_r42", CubeListBuilder.create().texOffs(639, 40).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Tumors2 = details.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offset(-8.0F, -26.0F, 69.0F));

		PartDefinition Tumor_r2 = Tumors2.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(634, 0).addBox(-2.0277F, 6.8296F, -9.3988F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.6645F, -23.2731F, 19.0378F, 0.7073F, -0.3819F, -0.4891F));

		PartDefinition Tumor_r3 = Tumors2.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(634, 0).addBox(4.6585F, -0.5605F, -17.3304F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3355F, -25.2731F, 30.0378F, 0.0F, -0.7418F, 0.5236F));

		PartDefinition Tumor_r4 = Tumors2.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(634, 0).addBox(-9.0F, -4.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 5.0F, 21.5F, -0.3927F, 0.0F, 0.4363F));

		PartDefinition Tumor_r5 = Tumors2.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(634, 0).addBox(-12.4771F, -6.3158F, -3.5835F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2731F, 2.3355F, 26.0378F, 1.0472F, -0.6981F, 0.0F));

		PartDefinition Tumor_r6 = Tumors2.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(634, 0).addBox(-3.5F, -7.5F, 1.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.2398F, -9.5732F, 23.5827F, -0.6981F, 1.0472F, 0.0F));

		PartDefinition Tumor_r7 = Tumors2.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(634, 0).addBox(-33.5F, -48.5F, -2.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(40.5852F, 7.3355F, 33.1306F, -0.3819F, -0.7073F, -0.4891F));

		PartDefinition Tumor_r8 = Tumors2.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(634, 0).addBox(-2.0F, -15.0F, -6.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 4.0F, 21.5F, 0.0F, 0.6545F, 0.5236F));

		PartDefinition Tumor_r9 = Tumors2.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(634, 0).addBox(-10.0F, -10.0F, -5.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.7269F, 7.9509F, 15.5755F, 1.0472F, 0.6981F, 0.0F));

		PartDefinition Tumor_r10 = Tumors2.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(634, 0).addBox(11.0F, -2.0F, 16.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 13.0F, 28.5F, 1.2897F, 0.6247F, -0.2097F));

		PartDefinition Tumors = Leviathan.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor = Tumors.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(-15.0F, -24.0F, 57.0F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor2 = Tumors.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.0F, -18.0F, 38.0F, -0.7002F, 0.5724F, -2.5267F));

		PartDefinition Biomass_r5 = Tumor2.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = Tumor2.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = Tumor2.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = Tumor2.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor3 = Tumors.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offset(-22.0F, -17.0F, 19.0F));

		PartDefinition Biomass_r9 = Tumor3.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r10 = Tumor3.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r11 = Tumor3.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r12 = Tumor3.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor4 = Tumors.addOrReplaceChild("Tumor4", CubeListBuilder.create(), PartPose.offset(17.0F, -20.0F, 36.0F));

		PartDefinition Biomass_r13 = Tumor4.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r14 = Tumor4.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r15 = Tumor4.addOrReplaceChild("Biomass_r15", CubeListBuilder.create().texOffs(612, 0).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r16 = Tumor4.addOrReplaceChild("Biomass_r16", CubeListBuilder.create().texOffs(612, 0).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor5 = Tumors.addOrReplaceChild("Tumor5", CubeListBuilder.create(), PartPose.offsetAndRotation(26.0F, -18.0F, 53.0F, 0.0F, -0.8727F, 1.5272F));

		PartDefinition Biomass_r17 = Tumor5.addOrReplaceChild("Biomass_r17", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r18 = Tumor5.addOrReplaceChild("Biomass_r18", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r19 = Tumor5.addOrReplaceChild("Biomass_r19", CubeListBuilder.create().texOffs(612, 0).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r20 = Tumor5.addOrReplaceChild("Biomass_r20", CubeListBuilder.create().texOffs(612, 0).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor6 = Tumors.addOrReplaceChild("Tumor6", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, -19.0F, 15.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Biomass_r21 = Tumor6.addOrReplaceChild("Biomass_r21", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r22 = Tumor6.addOrReplaceChild("Biomass_r22", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r23 = Tumor6.addOrReplaceChild("Biomass_r23", CubeListBuilder.create().texOffs(612, 0).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r24 = Tumor6.addOrReplaceChild("Biomass_r24", CubeListBuilder.create().texOffs(612, 0).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor7 = Tumors.addOrReplaceChild("Tumor7", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -18.0F, 71.0F, -0.0859F, -0.0151F, -0.1739F));

		PartDefinition Biomass_r25 = Tumor7.addOrReplaceChild("Biomass_r25", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r26 = Tumor7.addOrReplaceChild("Biomass_r26", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r27 = Tumor7.addOrReplaceChild("Biomass_r27", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r28 = Tumor7.addOrReplaceChild("Biomass_r28", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor8 = Tumors.addOrReplaceChild("Tumor8", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0F, -30.0F, 19.0F, 2.7348F, -0.1624F, -2.5408F));

		PartDefinition Biomass_r29 = Tumor8.addOrReplaceChild("Biomass_r29", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r30 = Tumor8.addOrReplaceChild("Biomass_r30", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r31 = Tumor8.addOrReplaceChild("Biomass_r31", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r32 = Tumor8.addOrReplaceChild("Biomass_r32", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor9 = Tumors.addOrReplaceChild("Tumor9", CubeListBuilder.create(), PartPose.offset(-27.0F, -34.0F, 44.0F));

		PartDefinition Biomass_r33 = Tumor9.addOrReplaceChild("Biomass_r33", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r34 = Tumor9.addOrReplaceChild("Biomass_r34", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r35 = Tumor9.addOrReplaceChild("Biomass_r35", CubeListBuilder.create().texOffs(612, 0).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r36 = Tumor9.addOrReplaceChild("Biomass_r36", CubeListBuilder.create().texOffs(612, 0).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor10 = Tumors.addOrReplaceChild("Tumor10", CubeListBuilder.create(), PartPose.offset(20.0F, -27.0F, 68.0F));

		PartDefinition Biomass_r37 = Tumor10.addOrReplaceChild("Biomass_r37", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r38 = Tumor10.addOrReplaceChild("Biomass_r38", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r39 = Tumor10.addOrReplaceChild("Biomass_r39", CubeListBuilder.create().texOffs(612, 0).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r40 = Tumor10.addOrReplaceChild("Biomass_r40", CubeListBuilder.create().texOffs(612, 0).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor11 = Tumors.addOrReplaceChild("Tumor11", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -50.0F, 59.0F, 1.8796F, -0.3156F, 0.5654F));

		PartDefinition Biomass_r41 = Tumor11.addOrReplaceChild("Biomass_r41", CubeListBuilder.create().texOffs(612, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r42 = Tumor11.addOrReplaceChild("Biomass_r42", CubeListBuilder.create().texOffs(612, 0).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r43 = Tumor11.addOrReplaceChild("Biomass_r43", CubeListBuilder.create().texOffs(612, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r44 = Tumor11.addOrReplaceChild("Biomass_r44", CubeListBuilder.create().texOffs(612, 0).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition acidSacks = Leviathan.addOrReplaceChild("acidSacks", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition rightSack = acidSacks.addOrReplaceChild("rightSack", CubeListBuilder.create(), PartPose.offset(-21.0F, -40.0F, 20.0F));

		PartDefinition cube_r8 = rightSack.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(613, 91).addBox(-5.0F, 0.0F, -10.0F, 8.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 5.0F, 0.7418F, 0.0F, 0.3054F));

		PartDefinition cube_r9 = rightSack.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(613, 91).addBox(-5.0F, 0.0F, -10.0F, 8.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 7.0F, 0.0F, -0.3491F, 0.0F, 0.3054F));

		PartDefinition cube_r10 = rightSack.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(613, 91).addBox(-5.0F, -7.0F, -10.0F, 6.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.3054F));

		PartDefinition leftSack = acidSacks.addOrReplaceChild("leftSack", CubeListBuilder.create(), PartPose.offset(21.0F, -43.0F, 19.0F));

		PartDefinition cube_r11 = leftSack.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(612, 63).addBox(-3.0F, 0.0F, -10.0F, 8.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 7.0F, 0.0F, -0.3491F, 0.0F, -0.3054F));

		PartDefinition cube_r12 = leftSack.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(612, 63).addBox(-1.0F, -5.0F, -10.0F, 6.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, -0.3054F));

		PartDefinition leftSack2 = acidSacks.addOrReplaceChild("leftSack2", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, -40.0F, 47.0F, 1.052F, -0.4636F, -0.2913F));

		PartDefinition cube_r13 = leftSack2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(653, 74).addBox(-3.0F, 0.0F, -10.0F, 8.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, -0.3491F, 0.0F, -0.3054F));

		PartDefinition cube_r14 = leftSack2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(653, 74).addBox(-3.0F, -5.0F, -10.0F, 8.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -6.0F, 0.215F, 0.0376F, -0.4759F));

		PartDefinition cube_r15 = leftSack2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(653, 74).addBox(-1.0F, -5.0F, -10.0F, 6.0F, 15.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, -0.1745F, 0.0F, -0.3054F));

		return LayerDefinition.create(meshdefinition, 700, 700);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float tumorVal1 = Mth.sin(ageInTicks/6)/6;
		float tumorVal2 = Mth.cos(ageInTicks/6)/7;
		float tumorVal3 = Mth.sin(ageInTicks/6)/8;
		float tumorVal4 = Mth.cos(ageInTicks/7)/6;
		float tumorVal5 = Mth.sin(ageInTicks/8)/6;
		float tumorVal6 = Mth.cos(ageInTicks/7)/7;
		animateTumor(Tumor,tumorVal1);
		animateTumor(Tumor2,tumorVal3);
		animateTumor(Tumor3,tumorVal2);
		animateTumor(Tumor4,tumorVal1);
		animateTumor(Tumor5,tumorVal4);
		animateTumor(Tumor6,tumorVal1);
		animateTumor(Tumor7,tumorVal5);
		animateTumor(Tumor8,tumorVal1);
		animateTumor(Tumor9,tumorVal6);
		animateTumor(Tumor10,tumorVal1);
		animateTumor(Tumor11,tumorVal4);
		animateTumor(rightSack,tumorVal5);
		animateTumor(leftSack,tumorVal6);
		animateTumor(leftSack2,tumorVal3);
		boolean rangedAt = entity.getRangeAttackAnimationTick() > 0;
		if (!rangedAt && open > 0){
			open--;
		}
		if (rangedAt && open < 40){
			open++;
		}
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick <= 0 && open <= 0){
			animateTentacleX(RightJaw,tumorVal6);
			animateTentacleX(LeftJaw,tumorVal6);
			animateTentacleX(DownJaw,tumorVal4);
			animateTentacleX(TopJaw,tumorVal4);
		}else {
			if (attackAnimationTick > 0){
				float swing = -1.0F + 0.75F * Mth.triangleWave((float)attackAnimationTick, 20.0F);
				animateTentacleX(RightJaw,swing);
				animateTentacleX(LeftJaw,swing);
				animateTentacleX(DownJaw,swing);
				animateTentacleX(TopJaw,swing);
			}else {
				float rotationValue = open * -0.015f;
				animateTentacleX(RightJaw,rotationValue);
				animateTentacleX(LeftJaw,rotationValue);
				animateTentacleX(DownJaw,-rotationValue);
				animateTentacleX(TopJaw,rotationValue);
			}
		}
		animateTentacleY(AcidCannon,tumorVal3);
		if (entity.isInWater()){
			animateTentacleY(RightSidefin,tumorVal3);
			animateTentacleY(LeftSidefin,tumorVal4);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r, float g, float b, float alpha) {
		Leviathan.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}