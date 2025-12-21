package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
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

public class GrakensenkerModel<T extends Grakensenker> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "grakensenkermodel"), "main");
	private final ModelPart Kraken;
	private final ModelPart body;
	private final ModelPart Innerteeth;
	public final ModelPart body2;
	private final ModelPart CenterCorpseDetails;
	private final ModelPart CenterBody1;
	private final ModelPart CenterBody2;
	private final ModelPart CenterBody3;
	private final ModelPart CenterBody4;
	private final ModelPart CenterCorpseDetails2;
	private final ModelPart CenterBody5;
	private final ModelPart CenterBody6;
	private final ModelPart CenterBody8;
	public final ModelPart CenterCorpseDetails3;
	private final ModelPart CenterBody7;
	private final ModelPart CenterBody9;
	private final ModelPart CenterBody10;
	private final ModelPart CenterCorpseDetails4;
	private final ModelPart CenterBody11;
	private final ModelPart CenterBody12;
	private final ModelPart CenterBody13;
	private final ModelPart CenterBody14;
	private final ModelPart CenterCorpseDetails5;
	private final ModelPart CenterBody15;
	private final ModelPart CenterBody16;
	private final ModelPart CenterBody17;
	public final ModelPart CenterCorpseDetails6;
	private final ModelPart CenterBody18;
	private final ModelPart CenterBody19;
	private final ModelPart CenterBody20;
	private final ModelPart FrontSeg1CorpseDetails;
	private final ModelPart FS1Body1;
	private final ModelPart FS1Body2;
	private final ModelPart FS1Body3;
	private final ModelPart FS1Body4;
	private final ModelPart FS1Body5;
	private final ModelPart FS1Body6;
	private final ModelPart FS1Body7;
	private final ModelPart FS1Body8;
	private final ModelPart FS1Body9;
	public final ModelPart FrontSeg2CorpseDetails;
	private final ModelPart FS2Body1;
	private final ModelPart FS2Body2;
	private final ModelPart FS2Body3;
	private final ModelPart FS2Body4;
	private final ModelPart FS2Body5;
	private final ModelPart FS2Body6;
	private final ModelPart FS2Body7;
	private final ModelPart FS2Body8;
	private final ModelPart FS2Body9;
	private final ModelPart FS2Body10;
	private final ModelPart FS2Body11;
	private final ModelPart FS2Body12;
	private final ModelPart FS2Body13;
	private final ModelPart FungalBloom;
	private final ModelPart FungalBloom2;
	private final ModelPart LeftArmConnectPoint;
	private final ModelPart RightArmConnectPoint;
	private final ModelPart Tumors;
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
	public final ModelPart BackJaw;
	private final ModelPart Outer;
	private final ModelPart OuterRingBase;
	private final ModelPart Internal;
	private final ModelPart OuterRingDetails;
	private final ModelPart Teeth;
	public final ModelPart BackBodyMouthProtection;
	private final ModelPart HindeRotation;
	public final ModelPart Hinge1;
	private final ModelPart LeftHinge;
	private final ModelPart HingeLowerMemebrane;
	private final ModelPart HingeMiddleHinge;
	private final ModelPart HingeMiddleMemebrane;
	private final ModelPart HingeTopHinge;
	private final ModelPart LeftTopMemebrane;
	private final ModelPart HindeRotation2;
	public final ModelPart Hinge2;
	private final ModelPart LeftHinge2;
	private final ModelPart HingeLowerMemebrane2;
	private final ModelPart HingeMiddleHinge2;
	private final ModelPart HingeMiddleMemebrane2;
	private final ModelPart HingeTopHinge2;
	private final ModelPart LeftTopMemebrane2;
	private final ModelPart HindeRotation3;
	public final ModelPart Hinge3;
	private final ModelPart LeftHinge3;
	private final ModelPart HingeLowerMemebrane3;
	private final ModelPart HingeMiddleHinge3;
	private final ModelPart HingeMiddleMemebrane3;
	private final ModelPart HingeTopHinge3;
	private final ModelPart LeftTopMemebrane3;
	private final ModelPart HindeRotation4;
	public final ModelPart Hinge4;
	private final ModelPart LeftHinge4;
	private final ModelPart HingeLowerMemebrane4;
	private final ModelPart HingeMiddleHinge4;
	private final ModelPart HingeMiddleMemebrane4;
	private final ModelPart HingeTopHinge4;
	private final ModelPart LeftTopMemebrane4;
	private final ModelPart HindeRotation5;
	public final ModelPart Hinge5;
	private final ModelPart LeftHinge5;
	private final ModelPart HingeLowerMemebrane5;
	private final ModelPart HingeMiddleHinge5;
	private final ModelPart HingeMiddleMemebrane5;
	private final ModelPart HingeTopHinge5;
	private final ModelPart LeftTopMemebrane5;
	public final ModelPart FrontJaw;
	private final ModelPart jawBottom;
	private final ModelPart head1;
	private final ModelPart head2;
	private final ModelPart head4;
	private final ModelPart head5;
	private final ModelPart head3;
	private final ModelPart head6;
	private final ModelPart head7;
	private final ModelPart RMouthBody2;
	private final ModelPart RMouthBody3;
	private final ModelPart jawTop;
	private final ModelPart head8;
	private final ModelPart head9;
	private final ModelPart head10;
	private final ModelPart head11;
	private final ModelPart head12;
	private final ModelPart head13;
	private final ModelPart head14;
	private final ModelPart MouthTopCenterpiece;
	private final ModelPart MTCPLimbs;
	private final ModelPart MTCPHead;
	private final ModelPart MTCPJaw;
	private final ModelPart MouthTopCenterpiece2;
	private final ModelPart MTCPLimbs2;
	private final ModelPart MTCPHead2;
	private final ModelPart MTCPJaw2;
	private final ModelPart rightJaw;
	private final ModelPart head15;
	private final ModelPart head17;
	private final ModelPart head19;
	private final ModelPart leftJaw;
	private final ModelPart head16;
	private final ModelPart head18;
	private final ModelPart head20;
	public final ModelPart head;
	private final ModelPart bodyDetails;
	private final ModelPart fin;
	private final ModelPart growth;
	private final ModelPart bodies;

	public GrakensenkerModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Kraken = root.getChild("Kraken");
		this.body = this.Kraken.getChild("body");
		this.Innerteeth = this.body.getChild("Innerteeth");
		this.body2 = this.body.getChild("body2");
		this.CenterCorpseDetails = this.body.getChild("CenterCorpseDetails");
		this.CenterBody1 = this.CenterCorpseDetails.getChild("CenterBody1");
		this.CenterBody2 = this.CenterCorpseDetails.getChild("CenterBody2");
		this.CenterBody3 = this.CenterCorpseDetails.getChild("CenterBody3");
		this.CenterBody4 = this.CenterCorpseDetails.getChild("CenterBody4");
		this.CenterCorpseDetails2 = this.body.getChild("CenterCorpseDetails2");
		this.CenterBody5 = this.CenterCorpseDetails2.getChild("CenterBody5");
		this.CenterBody6 = this.CenterCorpseDetails2.getChild("CenterBody6");
		this.CenterBody8 = this.CenterCorpseDetails2.getChild("CenterBody8");
		this.CenterCorpseDetails3 = this.body.getChild("CenterCorpseDetails3");
		this.CenterBody7 = this.CenterCorpseDetails3.getChild("CenterBody7");
		this.CenterBody9 = this.CenterCorpseDetails3.getChild("CenterBody9");
		this.CenterBody10 = this.CenterCorpseDetails3.getChild("CenterBody10");
		this.CenterCorpseDetails4 = this.body.getChild("CenterCorpseDetails4");
		this.CenterBody11 = this.CenterCorpseDetails4.getChild("CenterBody11");
		this.CenterBody12 = this.CenterCorpseDetails4.getChild("CenterBody12");
		this.CenterBody13 = this.CenterCorpseDetails4.getChild("CenterBody13");
		this.CenterBody14 = this.CenterCorpseDetails4.getChild("CenterBody14");
		this.CenterCorpseDetails5 = this.body.getChild("CenterCorpseDetails5");
		this.CenterBody15 = this.CenterCorpseDetails5.getChild("CenterBody15");
		this.CenterBody16 = this.CenterCorpseDetails5.getChild("CenterBody16");
		this.CenterBody17 = this.CenterCorpseDetails5.getChild("CenterBody17");
		this.CenterCorpseDetails6 = this.body.getChild("CenterCorpseDetails6");
		this.CenterBody18 = this.CenterCorpseDetails6.getChild("CenterBody18");
		this.CenterBody19 = this.CenterCorpseDetails6.getChild("CenterBody19");
		this.CenterBody20 = this.CenterCorpseDetails6.getChild("CenterBody20");
		this.FrontSeg1CorpseDetails = this.body.getChild("FrontSeg1CorpseDetails");
		this.FS1Body1 = this.FrontSeg1CorpseDetails.getChild("FS1Body1");
		this.FS1Body2 = this.FrontSeg1CorpseDetails.getChild("FS1Body2");
		this.FS1Body3 = this.FrontSeg1CorpseDetails.getChild("FS1Body3");
		this.FS1Body4 = this.FrontSeg1CorpseDetails.getChild("FS1Body4");
		this.FS1Body5 = this.FrontSeg1CorpseDetails.getChild("FS1Body5");
		this.FS1Body6 = this.FrontSeg1CorpseDetails.getChild("FS1Body6");
		this.FS1Body7 = this.FrontSeg1CorpseDetails.getChild("FS1Body7");
		this.FS1Body8 = this.FrontSeg1CorpseDetails.getChild("FS1Body8");
		this.FS1Body9 = this.FrontSeg1CorpseDetails.getChild("FS1Body9");
		this.FrontSeg2CorpseDetails = this.body.getChild("FrontSeg2CorpseDetails");
		this.FS2Body1 = this.FrontSeg2CorpseDetails.getChild("FS2Body1");
		this.FS2Body2 = this.FrontSeg2CorpseDetails.getChild("FS2Body2");
		this.FS2Body3 = this.FrontSeg2CorpseDetails.getChild("FS2Body3");
		this.FS2Body4 = this.FrontSeg2CorpseDetails.getChild("FS2Body4");
		this.FS2Body5 = this.FrontSeg2CorpseDetails.getChild("FS2Body5");
		this.FS2Body6 = this.FrontSeg2CorpseDetails.getChild("FS2Body6");
		this.FS2Body7 = this.FrontSeg2CorpseDetails.getChild("FS2Body7");
		this.FS2Body8 = this.FrontSeg2CorpseDetails.getChild("FS2Body8");
		this.FS2Body9 = this.FrontSeg2CorpseDetails.getChild("FS2Body9");
		this.FS2Body10 = this.FrontSeg2CorpseDetails.getChild("FS2Body10");
		this.FS2Body11 = this.FrontSeg2CorpseDetails.getChild("FS2Body11");
		this.FS2Body12 = this.FrontSeg2CorpseDetails.getChild("FS2Body12");
		this.FS2Body13 = this.FrontSeg2CorpseDetails.getChild("FS2Body13");
		this.FungalBloom = this.body.getChild("FungalBloom");
		this.FungalBloom2 = this.body.getChild("FungalBloom2");
		this.LeftArmConnectPoint = this.Kraken.getChild("LeftArmConnectPoint");
		this.RightArmConnectPoint = this.Kraken.getChild("RightArmConnectPoint");
		this.Tumors = this.Kraken.getChild("Tumors");
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
		this.BackJaw = this.Kraken.getChild("BackJaw");
		this.Outer = this.BackJaw.getChild("Outer");
		this.OuterRingBase = this.Outer.getChild("OuterRingBase");
		this.Internal = this.OuterRingBase.getChild("Internal");
		this.OuterRingDetails = this.Outer.getChild("OuterRingDetails");
		this.Teeth = this.OuterRingDetails.getChild("Teeth");
		this.BackBodyMouthProtection = this.Kraken.getChild("BackBodyMouthProtection");
		this.HindeRotation = this.BackBodyMouthProtection.getChild("HindeRotation");
		this.Hinge1 = this.HindeRotation.getChild("Hinge1");
		this.LeftHinge = this.Hinge1.getChild("LeftHinge");
		this.HingeLowerMemebrane = this.LeftHinge.getChild("HingeLowerMemebrane");
		this.HingeMiddleHinge = this.LeftHinge.getChild("HingeMiddleHinge");
		this.HingeMiddleMemebrane = this.HingeMiddleHinge.getChild("HingeMiddleMemebrane");
		this.HingeTopHinge = this.HingeMiddleHinge.getChild("HingeTopHinge");
		this.LeftTopMemebrane = this.HingeTopHinge.getChild("LeftTopMemebrane");
		this.HindeRotation2 = this.BackBodyMouthProtection.getChild("HindeRotation2");
		this.Hinge2 = this.HindeRotation2.getChild("Hinge2");
		this.LeftHinge2 = this.Hinge2.getChild("LeftHinge2");
		this.HingeLowerMemebrane2 = this.LeftHinge2.getChild("HingeLowerMemebrane2");
		this.HingeMiddleHinge2 = this.LeftHinge2.getChild("HingeMiddleHinge2");
		this.HingeMiddleMemebrane2 = this.HingeMiddleHinge2.getChild("HingeMiddleMemebrane2");
		this.HingeTopHinge2 = this.HingeMiddleHinge2.getChild("HingeTopHinge2");
		this.LeftTopMemebrane2 = this.HingeTopHinge2.getChild("LeftTopMemebrane2");
		this.HindeRotation3 = this.BackBodyMouthProtection.getChild("HindeRotation3");
		this.Hinge3 = this.HindeRotation3.getChild("Hinge3");
		this.LeftHinge3 = this.Hinge3.getChild("LeftHinge3");
		this.HingeLowerMemebrane3 = this.LeftHinge3.getChild("HingeLowerMemebrane3");
		this.HingeMiddleHinge3 = this.LeftHinge3.getChild("HingeMiddleHinge3");
		this.HingeMiddleMemebrane3 = this.HingeMiddleHinge3.getChild("HingeMiddleMemebrane3");
		this.HingeTopHinge3 = this.HingeMiddleHinge3.getChild("HingeTopHinge3");
		this.LeftTopMemebrane3 = this.HingeTopHinge3.getChild("LeftTopMemebrane3");
		this.HindeRotation4 = this.BackBodyMouthProtection.getChild("HindeRotation4");
		this.Hinge4 = this.HindeRotation4.getChild("Hinge4");
		this.LeftHinge4 = this.Hinge4.getChild("LeftHinge4");
		this.HingeLowerMemebrane4 = this.LeftHinge4.getChild("HingeLowerMemebrane4");
		this.HingeMiddleHinge4 = this.LeftHinge4.getChild("HingeMiddleHinge4");
		this.HingeMiddleMemebrane4 = this.HingeMiddleHinge4.getChild("HingeMiddleMemebrane4");
		this.HingeTopHinge4 = this.HingeMiddleHinge4.getChild("HingeTopHinge4");
		this.LeftTopMemebrane4 = this.HingeTopHinge4.getChild("LeftTopMemebrane4");
		this.HindeRotation5 = this.BackBodyMouthProtection.getChild("HindeRotation5");
		this.Hinge5 = this.HindeRotation5.getChild("Hinge5");
		this.LeftHinge5 = this.Hinge5.getChild("LeftHinge5");
		this.HingeLowerMemebrane5 = this.LeftHinge5.getChild("HingeLowerMemebrane5");
		this.HingeMiddleHinge5 = this.LeftHinge5.getChild("HingeMiddleHinge5");
		this.HingeMiddleMemebrane5 = this.HingeMiddleHinge5.getChild("HingeMiddleMemebrane5");
		this.HingeTopHinge5 = this.HingeMiddleHinge5.getChild("HingeTopHinge5");
		this.LeftTopMemebrane5 = this.HingeTopHinge5.getChild("LeftTopMemebrane5");
		this.FrontJaw = this.Kraken.getChild("FrontJaw");
		this.jawBottom = this.FrontJaw.getChild("jawBottom");
		this.head1 = this.jawBottom.getChild("head1");
		this.head2 = this.jawBottom.getChild("head2");
		this.head4 = this.jawBottom.getChild("head4");
		this.head5 = this.jawBottom.getChild("head5");
		this.head3 = this.jawBottom.getChild("head3");
		this.head6 = this.jawBottom.getChild("head6");
		this.head7 = this.jawBottom.getChild("head7");
		this.RMouthBody2 = this.jawBottom.getChild("RMouthBody2");
		this.RMouthBody3 = this.jawBottom.getChild("RMouthBody3");
		this.jawTop = this.FrontJaw.getChild("jawTop");
		this.head8 = this.jawTop.getChild("head8");
		this.head9 = this.jawTop.getChild("head9");
		this.head10 = this.jawTop.getChild("head10");
		this.head11 = this.jawTop.getChild("head11");
		this.head12 = this.jawTop.getChild("head12");
		this.head13 = this.jawTop.getChild("head13");
		this.head14 = this.jawTop.getChild("head14");
		this.MouthTopCenterpiece = this.jawTop.getChild("MouthTopCenterpiece");
		this.MTCPLimbs = this.MouthTopCenterpiece.getChild("MTCPLimbs");
		this.MTCPHead = this.MouthTopCenterpiece.getChild("MTCPHead");
		this.MTCPJaw = this.MTCPHead.getChild("MTCPJaw");
		this.MouthTopCenterpiece2 = this.jawTop.getChild("MouthTopCenterpiece2");
		this.MTCPLimbs2 = this.MouthTopCenterpiece2.getChild("MTCPLimbs2");
		this.MTCPHead2 = this.MouthTopCenterpiece2.getChild("MTCPHead2");
		this.MTCPJaw2 = this.MTCPHead2.getChild("MTCPJaw2");
		this.rightJaw = this.FrontJaw.getChild("rightJaw");
		this.head15 = this.rightJaw.getChild("head15");
		this.head17 = this.rightJaw.getChild("head17");
		this.head19 = this.rightJaw.getChild("head19");
		this.leftJaw = this.FrontJaw.getChild("leftJaw");
		this.head16 = this.leftJaw.getChild("head16");
		this.head18 = this.leftJaw.getChild("head18");
		this.head20 = this.leftJaw.getChild("head20");
		this.head = this.Kraken.getChild("head");
		this.bodyDetails = this.Kraken.getChild("bodyDetails");
		this.fin = this.bodyDetails.getChild("fin");
		this.growth = this.bodyDetails.getChild("growth");
		this.bodies = this.bodyDetails.getChild("bodies");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Kraken = partdefinition.addOrReplaceChild("Kraken", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = Kraken.addOrReplaceChild("body", CubeListBuilder.create().texOffs(146, 176).addBox(-15.0F, -13.1F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(-0.1F))
		.texOffs(0, 229).addBox(-15.0F, 23.0F, -13.55F, 30.0F, 13.0F, 38.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -38.0F, -5.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(136, 227).addBox(-15.0F, 0.0F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 16.0F, 0.25F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 178).addBox(-15.0F, 0.0F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 16.0F, 0.25F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(272, 227).addBox(-15.0F, -13.0F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 7.0F, 1.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(136, 278).addBox(-15.0F, -13.0F, -14.0F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 7.0F, 1.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Innerteeth = body.addOrReplaceChild("Innerteeth", CubeListBuilder.create().texOffs(372, 159).addBox(-19.0F, -2.0F, -11.0F, 34.0F, 26.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(376, 329).addBox(-19.0F, -2.0F, -2.0F, 34.0F, 26.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(172, 394).addBox(-19.0F, -2.0F, 10.0F, 34.0F, 26.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(92, 395).addBox(-19.0F, -2.0F, 19.0F, 34.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition body2 = body.addOrReplaceChild("body2", CubeListBuilder.create().texOffs(0, 0).addBox(-15.0F, -27.0F, 0.0F, 30.0F, 13.0F, 50.0F, new CubeDeformation(0.0F))
		.texOffs(272, 278).addBox(-15.0F, 9.0F, -0.75F, 30.0F, 13.0F, 38.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 16.0F, 18.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bile_r1 = body2.addOrReplaceChild("bile_r1", CubeListBuilder.create().texOffs(2, 669).addBox(-17.5F, -14.5F, 0.0F, 35.0F, 29.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.2596F, 26.1623F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r5 = body2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(172, 363).addBox(-15.0F, 3.0F, 5.0F, 30.0F, 10.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 2.0F, 38.25F, -0.3524F, 0.1186F, 0.9916F));

		PartDefinition cube_r6 = body2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(152, 63).addBox(-15.0F, 0.0F, -14.0F, 30.0F, 13.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 2.0F, 14.25F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r7 = body2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(282, 185).addBox(-15.0F, 5.0F, 0.0F, 30.0F, 8.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 2.0F, 39.25F, -0.2618F, -0.2618F, -0.9599F));

		PartDefinition cube_r8 = body2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(146, 122).addBox(-15.0F, 0.0F, -14.0F, 30.0F, 13.0F, 41.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 2.0F, 14.25F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r9 = body2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(294, 0).addBox(-15.0F, 6.0F, 1.0F, 30.0F, 7.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 36.25F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r10 = body2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(274, 329).addBox(-15.0F, -13.0F, 11.0F, 30.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -4.75F, 36.0F, 0.3043F, 0.0262F, 0.964F));

		PartDefinition cube_r11 = body2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 63).addBox(-15.0F, -13.0F, -14.0F, 30.0F, 13.0F, 46.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -7.0F, 15.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r12 = body2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(372, 125).addBox(3.0F, -15.0F, 6.0F, 16.0F, 11.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -7.0F, 40.0F, 0.2391F, -0.0745F, -0.7409F));

		PartDefinition cube_r13 = body2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(292, 56).addBox(-17.0F, -13.0F, 6.0F, 32.0F, 10.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -7.0F, 36.0F, 0.2502F, 0.0779F, -1.0374F));

		PartDefinition cube_r14 = body2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 122).addBox(-15.0F, -13.0F, -14.0F, 30.0F, 13.0F, 43.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -7.0F, 15.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition cube_r15 = body2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(172, 329).addBox(-15.0F, -13.0F, 6.0F, 30.0F, 13.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.75F, 42.25F, 0.3054F, 0.0F, 0.2182F));

		PartDefinition CenterCorpseDetails = body.addOrReplaceChild("CenterCorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.3273F, -7.25F, 10.2967F, 0.7899F, 0.192F, -0.8117F));

		PartDefinition CenterBody1 = CenterCorpseDetails.addOrReplaceChild("CenterBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r1 = CenterBody1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(288, 539).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r1 = CenterBody1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(522, 64).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r1 = CenterBody1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(578, 140).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody2 = CenterCorpseDetails.addOrReplaceChild("CenterBody2", CubeListBuilder.create(), PartPose.offset(-24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r2 = CenterBody2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(142, 625).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r3 = CenterBody2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(472, 343).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r1 = CenterBody2.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(556, 625).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r2 = CenterBody2.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(602, 213).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r2 = CenterBody2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(586, 558).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody3 = CenterCorpseDetails.addOrReplaceChild("CenterBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.5056F, -4.3398F, -3.3136F, 0.2154F, 0.6018F, 0.2843F));

		PartDefinition Leg_r1 = CenterBody3.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(212, 435).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4032F, 4.788F, 2.3728F, -0.0397F, -0.0241F, -0.177F));

		PartDefinition Leg_r2 = CenterBody3.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(276, 56).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.773F, 5.0385F, -2.4364F, -0.2132F, -0.0469F, -0.2132F));

		PartDefinition Arm_r4 = CenterBody3.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(168, 545).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2343F, -6.4446F, 2.8873F, 2.007F, 0.9774F, 0.5593F));

		PartDefinition TorsoTop_r3 = CenterBody3.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(288, 580).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0056F, -0.6602F, -0.6864F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r1 = CenterBody3.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(578, 625).addBox(-1.75F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, 3.3398F, -0.1864F, 0.0411F, -0.3027F, 0.2555F));

		PartDefinition CenterBody4 = CenterCorpseDetails.addOrReplaceChild("CenterBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r2 = CenterBody4.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(602, 222).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r5 = CenterBody4.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(0, 626).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r6 = CenterBody4.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(446, 44).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r4 = CenterBody4.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(588, 386).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = CenterBody4.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(508, 415).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails2 = body.addOrReplaceChild("CenterCorpseDetails2", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.3273F, -7.25F, 34.2967F, 0.659F, 0.192F, -0.8117F));

		PartDefinition CenterBody5 = CenterCorpseDetails2.addOrReplaceChild("CenterBody5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r7 = CenterBody5.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(548, 156).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r3 = CenterBody5.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(522, 79).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r5 = CenterBody5.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(574, 460).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody6 = CenterCorpseDetails2.addOrReplaceChild("CenterBody6", CubeListBuilder.create(), PartPose.offset(-24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r8 = CenterBody6.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(182, 625).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, -0.7842F, -0.6937F, -0.6672F));

		PartDefinition Arm_r9 = CenterBody6.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(626, 0).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r3 = CenterBody6.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(44, 626).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, -0.6702F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r4 = CenterBody6.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(602, 231).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r6 = CenterBody6.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(588, 516).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody8 = CenterCorpseDetails2.addOrReplaceChild("CenterBody8", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r3 = CenterBody8.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(602, 240).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r10 = CenterBody8.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(626, 97).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r11 = CenterBody8.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(614, 526).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r7 = CenterBody8.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(590, 155).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r4 = CenterBody8.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(512, 462).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -9.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails3 = body.addOrReplaceChild("CenterCorpseDetails3", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.3273F, -7.25F, 45.2967F, 0.7094F, 0.3954F, -0.6391F));

		PartDefinition CenterBody7 = CenterCorpseDetails3.addOrReplaceChild("CenterBody7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r12 = CenterBody7.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(426, 582).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r5 = CenterBody7.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(522, 94).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r8 = CenterBody7.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(580, 315).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody9 = CenterCorpseDetails3.addOrReplaceChild("CenterBody9", CubeListBuilder.create(), PartPose.offset(-24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r13 = CenterBody9.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(470, 625).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, -0.7842F, -0.6937F, -0.6672F));

		PartDefinition Arm_r14 = CenterBody9.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(24, 465).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r5 = CenterBody9.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(626, 108).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, -0.6702F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r6 = CenterBody9.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(602, 249).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r9 = CenterBody9.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(590, 165).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody10 = CenterCorpseDetails3.addOrReplaceChild("CenterBody10", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r4 = CenterBody10.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(602, 278).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r15 = CenterBody10.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(626, 258).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r16 = CenterBody10.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(632, 526).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r10 = CenterBody10.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(590, 175).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r6 = CenterBody10.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(512, 478).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -0.9697F, -4.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails4 = body.addOrReplaceChild("CenterCorpseDetails4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3273F, -7.25F, 10.2967F, 0.7899F, -0.192F, 0.8117F));

		PartDefinition CenterBody11 = CenterCorpseDetails4.addOrReplaceChild("CenterBody11", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r17 = CenterBody11.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(92, 591).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r7 = CenterBody11.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(522, 109).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r11 = CenterBody11.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(580, 330).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody12 = CenterCorpseDetails4.addOrReplaceChild("CenterBody12", CubeListBuilder.create(), PartPose.offset(24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r18 = CenterBody12.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(492, 625).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r19 = CenterBody12.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(630, 361).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r7 = CenterBody12.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(626, 296).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r8 = CenterBody12.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(602, 287).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r12 = CenterBody12.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(590, 396).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody13 = CenterCorpseDetails4.addOrReplaceChild("CenterBody13", CubeListBuilder.create(), PartPose.offsetAndRotation(32.5056F, -4.3398F, -3.3136F, 0.2154F, -0.6018F, -0.2843F));

		PartDefinition Leg_r3 = CenterBody13.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(496, 462).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r4 = CenterBody13.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(394, 355).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r20 = CenterBody13.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(190, 636).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r13 = CenterBody13.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(580, 345).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r5 = CenterBody13.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(324, 626).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody14 = CenterCorpseDetails4.addOrReplaceChild("CenterBody14", CubeListBuilder.create(), PartPose.offsetAndRotation(12.75F, -19.1707F, -4.6424F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r6 = CenterBody14.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(604, 312).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r21 = CenterBody14.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(344, 626).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r22 = CenterBody14.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(634, 494).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r14 = CenterBody14.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(140, 591).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r8 = CenterBody14.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(514, 16).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails5 = body.addOrReplaceChild("CenterCorpseDetails5", CubeListBuilder.create(), PartPose.offsetAndRotation(6.3273F, -8.25F, 36.2967F, 0.659F, -0.192F, 0.8117F));

		PartDefinition CenterBody15 = CenterCorpseDetails5.addOrReplaceChild("CenterBody15", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r23 = CenterBody15.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(636, 387).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r9 = CenterBody15.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(412, 522).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r15 = CenterBody15.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(574, 475).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody16 = CenterCorpseDetails5.addOrReplaceChild("CenterBody16", CubeListBuilder.create(), PartPose.offset(24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r24 = CenterBody16.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(534, 625).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, -0.7842F, 0.6937F, 0.6672F));

		PartDefinition Arm_r25 = CenterBody16.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(632, 86).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r9 = CenterBody16.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(382, 626).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, -0.6702F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r10 = CenterBody16.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(604, 321).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r16 = CenterBody16.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(592, 33).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody17 = CenterCorpseDetails5.addOrReplaceChild("CenterBody17", CubeListBuilder.create(), PartPose.offsetAndRotation(12.75F, -19.1707F, -4.6424F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r7 = CenterBody17.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(604, 330).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r26 = CenterBody17.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(626, 403).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r27 = CenterBody17.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(634, 503).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r17 = CenterBody17.addOrReplaceChild("TorsoTop_r17", CubeListBuilder.create().texOffs(592, 43).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r10 = CenterBody17.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(516, 151).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -9.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails6 = body.addOrReplaceChild("CenterCorpseDetails6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3273F, -19.25F, 55.2967F, 0.659F, -0.192F, 0.8117F));

		PartDefinition CenterBody18 = CenterCorpseDetails6.addOrReplaceChild("CenterBody18", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r28 = CenterBody18.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(446, 636).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r11 = CenterBody18.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(444, 522).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.0739F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r18 = CenterBody18.addOrReplaceChild("TorsoTop_r18", CubeListBuilder.create().texOffs(350, 580).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody19 = CenterCorpseDetails6.addOrReplaceChild("CenterBody19", CubeListBuilder.create(), PartPose.offset(24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r29 = CenterBody19.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(626, 434).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, -0.7842F, 0.6937F, 0.6672F));

		PartDefinition Arm_r30 = CenterBody19.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(634, 119).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r11 = CenterBody19.addOrReplaceChild("TorsoBottom_r11", CubeListBuilder.create().texOffs(404, 626).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, -0.6702F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r12 = CenterBody19.addOrReplaceChild("TorsoBottom_r12", CubeListBuilder.create().texOffs(604, 339).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r19 = CenterBody19.addOrReplaceChild("TorsoTop_r19", CubeListBuilder.create().texOffs(592, 185).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.4473F));

		PartDefinition CenterBody20 = CenterCorpseDetails6.addOrReplaceChild("CenterBody20", CubeListBuilder.create(), PartPose.offsetAndRotation(12.75F, -19.1707F, -4.6424F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r8 = CenterBody20.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(604, 348).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r31 = CenterBody20.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(626, 445).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r32 = CenterBody20.addOrReplaceChild("Arm_r32", CubeListBuilder.create().texOffs(634, 535).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r20 = CenterBody20.addOrReplaceChild("TorsoTop_r20", CubeListBuilder.create().texOffs(572, 594).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r12 = CenterBody20.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(518, 32).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -9.4599F, -1.2101F, -0.2083F, 0.2852F));

		PartDefinition FrontSeg1CorpseDetails = body.addOrReplaceChild("FrontSeg1CorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -29.25F, 43.0F, -1.946F, -1.2863F, -0.8337F));

		PartDefinition FS1Body1 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body1", CubeListBuilder.create(), PartPose.offset(0.06F, -1.4055F, -5.1262F));

		PartDefinition Leg_r5 = FS1Body1.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(326, 220).addBox(-1.1032F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6662F, 0.4348F, -0.7224F));

		PartDefinition Arm_r33 = FS1Body1.addOrReplaceChild("Arm_r33", CubeListBuilder.create().texOffs(160, 56).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2365F, -5.5182F, 2.9F, -0.6655F, 0.5335F, -0.7309F));

		PartDefinition Arm_r34 = FS1Body1.addOrReplaceChild("Arm_r34", CubeListBuilder.create().texOffs(270, 116).addBox(-0.6482F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -2.9185F, 12.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r9 = FS1Body1.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(600, 0).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r21 = FS1Body1.addOrReplaceChild("TorsoTop_r21", CubeListBuilder.create().texOffs(570, 412).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(242, 555).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = FS1Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(618, 387).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition FS1Body2 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(17.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1781F));

		PartDefinition Leg_r6 = FS1Body2.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(528, 195).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4096F, -3.5211F, 3.0704F, 0.2978F, -0.1848F, 0.5394F));

		PartDefinition Leg_r7 = FS1Body2.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(72, 614).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5286F, -3.3013F, -1.75F, -0.211F, 0.056F, 0.2559F));

		PartDefinition Arm_r35 = FS1Body2.addOrReplaceChild("Arm_r35", CubeListBuilder.create().texOffs(458, 636).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r13 = FS1Body2.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(24, 523).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.167F, -16.9397F, -2.5094F, -1.8953F, -1.1912F, 2.0859F));

		PartDefinition TorsoTop_r22 = FS1Body2.addOrReplaceChild("TorsoTop_r22", CubeListBuilder.create().texOffs(580, 360).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r10 = FS1Body2.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(626, 456).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition FS1Body3 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(15.3288F, 2.3876F, 0.8238F, 0.7406F, -1.1572F, 0.0281F));

		PartDefinition Leg_r8 = FS1Body3.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(572, 581).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, 5.4967F, -1.5847F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r11 = FS1Body3.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(604, 357).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 0.6167F, 4.4316F, -0.2898F, 0.4081F, 0.0114F));

		PartDefinition Arm_r36 = FS1Body3.addOrReplaceChild("Arm_r36", CubeListBuilder.create().texOffs(626, 469).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r37 = FS1Body3.addOrReplaceChild("Arm_r37", CubeListBuilder.create().texOffs(624, 601).addBox(-1.9496F, -0.9033F, -7.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoTop_r23 = FS1Body3.addOrReplaceChild("TorsoTop_r23", CubeListBuilder.create().texOffs(284, 595).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8747F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r14 = FS1Body3.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(560, 156).addBox(-3.7022F, -0.41F, -3.6521F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.13F, -4.0992F, -2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition FS1Body4 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body4", CubeListBuilder.create().texOffs(604, 366).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.75F, -3.0F, 1.0F, -1.8012F, -1.223F, 1.5377F));

		PartDefinition Leg_r9 = FS1Body4.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(232, 56).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r15 = FS1Body4.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(308, 520).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1254F, -0.0554F, 0.4373F));

		PartDefinition Arm_r38 = FS1Body4.addOrReplaceChild("Arm_r38", CubeListBuilder.create().texOffs(0, 526).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r24 = FS1Body4.addOrReplaceChild("TorsoTop_r24", CubeListBuilder.create().texOffs(350, 595).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition FS1Body5 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.75F, 3.0F, 11.0F, 1.1222F, -1.223F, 1.5377F));

		PartDefinition TorsoBase_r12 = FS1Body5.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(520, 140).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8836F, 8.6026F, 3.8552F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r25 = FS1Body5.addOrReplaceChild("TorsoTop_r25", CubeListBuilder.create().texOffs(176, 116).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1991F, 4.1416F, 6.3927F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r26 = FS1Body5.addOrReplaceChild("TorsoTop_r26", CubeListBuilder.create().texOffs(570, 258).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(518, 48).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition FS1Body6 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.75F, -2.3293F, 3.3576F, -0.3295F, 1.1755F, -2.4139F));

		PartDefinition Leg_r10 = FS1Body6.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(582, 124).addBox(-2.664F, -1.8936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -2.5592F, 4.5018F, 0.8843F, 0.9235F, -0.0354F));

		PartDefinition TorsoBase_r13 = FS1Body6.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(588, 526).addBox(-3.0F, -4.0F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -0.1988F, 4.3066F, 0.4485F, 0.4285F, -0.1972F));

		PartDefinition Arm_r39 = FS1Body6.addOrReplaceChild("Arm_r39", CubeListBuilder.create().texOffs(626, 559).addBox(-1.919F, -1.1698F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, 0.9938F, -2.204F, -2.3868F, 0.3569F, -1.7879F));

		PartDefinition Arm_r40 = FS1Body6.addOrReplaceChild("Arm_r40", CubeListBuilder.create().texOffs(66, 635).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r13 = FS1Body6.addOrReplaceChild("TorsoBottom_r13", CubeListBuilder.create().texOffs(378, 595).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition FS1Body7 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(-43.75F, -0.1707F, 10.3576F, -2.3546F, -0.9863F, -2.8423F));

		PartDefinition Leg_r11 = FS1Body7.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(400, 582).addBox(-2.664F, -8.6064F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.234F, -0.5178F, -1.4767F));

		PartDefinition Leg_r12 = FS1Body7.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(374, 582).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.4744F, -0.2937F, -1.281F));

		PartDefinition TorsoBase_r14 = FS1Body7.addOrReplaceChild("TorsoBase_r14", CubeListBuilder.create().texOffs(572, 604).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r41 = FS1Body7.addOrReplaceChild("Arm_r41", CubeListBuilder.create().texOffs(204, 627).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r42 = FS1Body7.addOrReplaceChild("Arm_r42", CubeListBuilder.create().texOffs(22, 627).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r27 = FS1Body7.addOrReplaceChild("TorsoTop_r27", CubeListBuilder.create().texOffs(406, 595).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r16 = FS1Body7.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(560, 171).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition FS1Body8 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.06F, 3.5945F, 5.8738F, 0.3981F, 0.1611F, 0.0674F));

		PartDefinition Leg_r13 = FS1Body8.addOrReplaceChild("Leg_r13", CubeListBuilder.create().texOffs(248, 116).addBox(-1.1032F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.6662F, 0.4348F, -0.7224F));

		PartDefinition Arm_r43 = FS1Body8.addOrReplaceChild("Arm_r43", CubeListBuilder.create().texOffs(184, 56).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2365F, -5.5182F, 2.9F, -0.6655F, 0.5335F, -0.7309F));

		PartDefinition Arm_r44 = FS1Body8.addOrReplaceChild("Arm_r44", CubeListBuilder.create().texOffs(370, 220).addBox(-0.6482F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -2.9185F, 12.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r15 = FS1Body8.addOrReplaceChild("TorsoBase_r15", CubeListBuilder.create().texOffs(92, 601).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r28 = FS1Body8.addOrReplaceChild("TorsoTop_r28", CubeListBuilder.create().texOffs(232, 571).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(556, 509).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r2 = FS1Body8.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(620, 30).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition FS1Body9 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body9", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.94F, -7.4055F, -8.1262F, 2.3825F, 1.0816F, 0.1515F));

		PartDefinition Leg_r14 = FS1Body9.addOrReplaceChild("Leg_r14", CubeListBuilder.create().texOffs(304, 220).addBox(-1.1031F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6415F, 0.4735F, 1.3791F));

		PartDefinition Arm_r45 = FS1Body9.addOrReplaceChild("Arm_r45", CubeListBuilder.create().texOffs(200, 116).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2366F, -5.5182F, 2.9F, -0.6655F, 0.5335F, -0.7309F));

		PartDefinition TorsoBase_r16 = FS1Body9.addOrReplaceChild("TorsoBase_r16", CubeListBuilder.create().texOffs(602, 137).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r29 = FS1Body9.addOrReplaceChild("TorsoTop_r29", CubeListBuilder.create().texOffs(260, 571).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(556, 552).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r3 = FS1Body9.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(164, 622).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition FrontSeg2CorpseDetails = body.addOrReplaceChild("FrontSeg2CorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.75F, -11.25F, 59.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition FS2Body1 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(26.0928F, -19.4106F, 11.8538F, -0.1652F, 0.4447F, 0.041F));

		PartDefinition Leg_r15 = FS2Body1.addOrReplaceChild("Leg_r15", CubeListBuilder.create().texOffs(254, 56).addBox(-1.1031F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4673F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.5852F));

		PartDefinition Arm_r46 = FS2Body1.addOrReplaceChild("Arm_r46", CubeListBuilder.create().texOffs(208, 56).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r47 = FS2Body1.addOrReplaceChild("Arm_r47", CubeListBuilder.create().texOffs(376, 355).addBox(-0.6482F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7457F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r17 = FS2Body1.addOrReplaceChild("TorsoBase_r17", CubeListBuilder.create().texOffs(118, 601).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r30 = FS2Body1.addOrReplaceChild("TorsoTop_r30", CubeListBuilder.create().texOffs(352, 523).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(524, 494).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6967F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r4 = FS2Body1.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(608, 434).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7146F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition FS2Body2 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Leg_r16 = FS2Body2.addOrReplaceChild("Leg_r16", CubeListBuilder.create().texOffs(516, 167).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4096F, -3.5211F, -3.0704F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r17 = FS2Body2.addOrReplaceChild("Leg_r17", CubeListBuilder.create().texOffs(508, 559).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5286F, -3.3013F, 1.75F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r48 = FS2Body2.addOrReplaceChild("Arm_r48", CubeListBuilder.create().texOffs(470, 636).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, -3.5737F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r17 = FS2Body2.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(56, 523).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.167F, -16.9397F, 2.5094F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r31 = FS2Body2.addOrReplaceChild("TorsoTop_r31", CubeListBuilder.create().texOffs(582, 424).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition TorsoBase_r18 = FS2Body2.addOrReplaceChild("TorsoBase_r18", CubeListBuilder.create().texOffs(426, 627).addBox(-2.5F, -4.0F, -3.25F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition FS2Body3 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.3288F, -8.8876F, 1.1762F, -3.0991F, -1.1572F, 0.0281F));

		PartDefinition Leg_r18 = FS2Body3.addOrReplaceChild("Leg_r18", CubeListBuilder.create().texOffs(582, 439).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r19 = FS2Body3.addOrReplaceChild("TorsoBase_r19", CubeListBuilder.create().texOffs(598, 604).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r49 = FS2Body3.addOrReplaceChild("Arm_r49", CubeListBuilder.create().texOffs(628, 195).addBox(-1.081F, -0.6698F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r50 = FS2Body3.addOrReplaceChild("Arm_r50", CubeListBuilder.create().texOffs(628, 132).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r14 = FS2Body3.addOrReplaceChild("TorsoBottom_r14", CubeListBuilder.create().texOffs(596, 10).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8747F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r18 = FS2Body3.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(110, 563).addBox(-4.2978F, -7.59F, -3.3479F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition FS2Body4 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body4", CubeListBuilder.create().texOffs(284, 605).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.75F, -11.0F, -1.0F, 2.1939F, -1.223F, -1.5377F));

		PartDefinition Leg_r19 = FS2Body4.addOrReplaceChild("Leg_r19", CubeListBuilder.create().texOffs(282, 220).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r19 = FS2Body4.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(88, 523).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r51 = FS2Body4.addOrReplaceChild("Arm_r51", CubeListBuilder.create().texOffs(60, 602).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r32 = FS2Body4.addOrReplaceChild("TorsoTop_r32", CubeListBuilder.create().texOffs(596, 20).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition FS2Body5 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(32.6375F, -12.4168F, 1.6328F, -0.6309F, -0.2664F, 0.9212F));

		PartDefinition TorsoBase_r20 = FS2Body5.addOrReplaceChild("TorsoBase_r20", CubeListBuilder.create().texOffs(580, 375).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r33 = FS2Body5.addOrReplaceChild("TorsoTop_r33", CubeListBuilder.create().texOffs(152, 116).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r34 = FS2Body5.addOrReplaceChild("TorsoTop_r34", CubeListBuilder.create().texOffs(570, 302).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r20 = FS2Body5.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(518, 350).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition FS2Body6 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(45.75F, 6.6707F, -3.3576F, -1.5904F, 1.1755F, 2.4139F));

		PartDefinition Leg_r20 = FS2Body6.addOrReplaceChild("Leg_r20", CubeListBuilder.create().texOffs(232, 583).addBox(-0.336F, -1.8936F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, -2.5592F, -4.5018F, -0.8843F, 0.9235F, 0.0354F));

		PartDefinition TorsoBase_r21 = FS2Body6.addOrReplaceChild("TorsoBase_r21", CubeListBuilder.create().texOffs(602, 195).addBox(-4.0F, -4.0F, -2.75F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, -0.1988F, -4.3066F, -0.4485F, 0.4285F, 0.1972F));

		PartDefinition Arm_r52 = FS2Body6.addOrReplaceChild("Arm_r52", CubeListBuilder.create().texOffs(628, 206).addBox(-1.081F, -1.1698F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r53 = FS2Body6.addOrReplaceChild("Arm_r53", CubeListBuilder.create().texOffs(84, 635).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4172F, 4.1598F, -0.8274F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r15 = FS2Body6.addOrReplaceChild("TorsoBottom_r15", CubeListBuilder.create().texOffs(32, 596).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition FS2Body7 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(43.75F, 18.8293F, -1.3576F, 2.2614F, 0.2005F, -1.0474F));

		PartDefinition Leg_r21 = FS2Body7.addOrReplaceChild("Leg_r21", CubeListBuilder.create().texOffs(584, 60).addBox(-0.336F, -8.6064F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, 4.5592F, -3.5018F, 0.234F, -0.5178F, 1.4767F));

		PartDefinition Leg_r22 = FS2Body7.addOrReplaceChild("Leg_r22", CubeListBuilder.create().texOffs(258, 583).addBox(-0.336F, 0.3936F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, 4.5592F, -3.5018F, 1.4744F, -0.2937F, 1.281F));

		PartDefinition TorsoBase_r22 = FS2Body7.addOrReplaceChild("TorsoBase_r22", CubeListBuilder.create().texOffs(336, 605).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r54 = FS2Body7.addOrReplaceChild("Arm_r54", CubeListBuilder.create().texOffs(628, 228).addBox(-1.081F, -2.3302F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r55 = FS2Body7.addOrReplaceChild("Arm_r55", CubeListBuilder.create().texOffs(628, 217).addBox(-3.0019F, -1.0747F, -6.8878F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r35 = FS2Body7.addOrReplaceChild("TorsoTop_r35", CubeListBuilder.create().texOffs(232, 596).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r21 = FS2Body7.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(288, 565).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.4599F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition FS2Body8 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body8", CubeListBuilder.create(), PartPose.offsetAndRotation(37.75F, 26.8293F, 3.6424F, -0.1281F, -0.1579F, 1.7716F));

		PartDefinition Arm_r56 = FS2Body8.addOrReplaceChild("Arm_r56", CubeListBuilder.create().texOffs(628, 239).addBox(-1.081F, -2.3302F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, 2.204F, 1.6609F, -0.5587F, -1.5066F));

		PartDefinition TorsoBase_r23 = FS2Body8.addOrReplaceChild("TorsoBase_r23", CubeListBuilder.create().texOffs(362, 605).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.4741F, 0.461F, -0.0476F));

		PartDefinition TorsoTop_r36 = FS2Body8.addOrReplaceChild("TorsoTop_r36", CubeListBuilder.create().texOffs(598, 258).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r22 = FS2Body8.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(520, 124).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.4599F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition FS2Body9 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body9", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.25F, 4.8293F, 9.3576F, -2.669F, -1.3022F, 1.7271F));

		PartDefinition Leg_r23 = FS2Body9.addOrReplaceChild("Leg_r23", CubeListBuilder.create().texOffs(584, 86).addBox(-2.664F, -8.6064F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.234F, -0.5178F, -1.4767F));

		PartDefinition Leg_r24 = FS2Body9.addOrReplaceChild("Leg_r24", CubeListBuilder.create().texOffs(584, 73).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.4744F, -0.2937F, -1.281F));

		PartDefinition TorsoBase_r24 = FS2Body9.addOrReplaceChild("TorsoBase_r24", CubeListBuilder.create().texOffs(608, 123).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r57 = FS2Body9.addOrReplaceChild("Arm_r57", CubeListBuilder.create().texOffs(624, 590).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r58 = FS2Body9.addOrReplaceChild("Arm_r58", CubeListBuilder.create().texOffs(628, 269).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r37 = FS2Body9.addOrReplaceChild("TorsoTop_r37", CubeListBuilder.create().texOffs(598, 268).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r23 = FS2Body9.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(350, 565).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition FS2Body10 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body10", CubeListBuilder.create(), PartPose.offsetAndRotation(46.8288F, 12.3876F, 9.8238F, -2.5309F, -0.7515F, -0.9886F));

		PartDefinition Leg_r25 = FS2Body10.addOrReplaceChild("Leg_r25", CubeListBuilder.create().texOffs(572, 568).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r25 = FS2Body10.addOrReplaceChild("TorsoBase_r25", CubeListBuilder.create().texOffs(602, 204).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r59 = FS2Body10.addOrReplaceChild("Arm_r59", CubeListBuilder.create().texOffs(248, 629).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r60 = FS2Body10.addOrReplaceChild("Arm_r60", CubeListBuilder.create().texOffs(628, 280).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.9353F, 0.8543F, -0.1475F));

		PartDefinition TorsoTop_r38 = FS2Body10.addOrReplaceChild("TorsoTop_r38", CubeListBuilder.create().texOffs(586, 548).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8747F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition FS2Body11 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.25F, -6.9455F, -8.2449F, 1.3069F, -0.9271F, -1.474F));

		PartDefinition Leg_r26 = FS2Body11.addOrReplaceChild("Leg_r26", CubeListBuilder.create().texOffs(584, 490).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r26 = FS2Body11.addOrReplaceChild("TorsoBase_r26", CubeListBuilder.create().texOffs(388, 605).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r61 = FS2Body11.addOrReplaceChild("Arm_r61", CubeListBuilder.create().texOffs(630, 307).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.2041F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r39 = FS2Body11.addOrReplaceChild("TorsoTop_r39", CubeListBuilder.create().texOffs(598, 302).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition FS2Body12 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body12", CubeListBuilder.create(), PartPose.offsetAndRotation(19.6375F, 37.2279F, -5.5091F, 1.6725F, -0.8994F, -1.5799F));

		PartDefinition TorsoBase_r27 = FS2Body12.addOrReplaceChild("TorsoBase_r27", CubeListBuilder.create().texOffs(584, 99).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.274F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r16 = FS2Body12.addOrReplaceChild("TorsoBottom_r16", CubeListBuilder.create().texOffs(224, 116).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r17 = FS2Body12.addOrReplaceChild("TorsoBottom_r17", CubeListBuilder.create().texOffs(570, 271).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r24 = FS2Body12.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(518, 334).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition FS2Body13 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(4.75F, 37.9055F, -3.052F, 2.5638F, -0.446F, -3.1412F));

		PartDefinition Leg_r27 = FS2Body13.addOrReplaceChild("Leg_r27", CubeListBuilder.create().texOffs(586, 110).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r28 = FS2Body13.addOrReplaceChild("TorsoBase_r28", CubeListBuilder.create().texOffs(414, 605).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7364F, 2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r62 = FS2Body13.addOrReplaceChild("Arm_r62", CubeListBuilder.create().texOffs(630, 318).addBox(-1.919F, -0.6698F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r18 = FS2Body13.addOrReplaceChild("TorsoBottom_r18", CubeListBuilder.create().texOffs(598, 406).addBox(-3.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition FungalBloom = body.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.3349F, -29.0409F, 48.7433F, 0.4442F, -0.2504F, -0.5157F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(492, 125).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(486, 16).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(408, 240).addBox(-16.0F, -1.0F, -18.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(408, 224).addBox(-16.0F, -1.0F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(406, 69).addBox(2.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(406, 53).addBox(-18.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, 0.3927F));

		PartDefinition FungalBloom2 = body.addOrReplaceChild("FungalBloom2", CubeListBuilder.create(), PartPose.offsetAndRotation(33.8651F, 5.1591F, 45.6433F, 0.1547F, -0.6016F, 1.013F));

		PartDefinition Plane3_r1 = FungalBloom2.addOrReplaceChild("Plane3_r1", CubeListBuilder.create().texOffs(492, 125).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r2 = FungalBloom2.addOrReplaceChild("Plane2_r2", CubeListBuilder.create().texOffs(486, 16).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r2 = FungalBloom2.addOrReplaceChild("Npetal_r2", CubeListBuilder.create().texOffs(408, 240).addBox(-16.0F, -1.0F, -18.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r2 = FungalBloom2.addOrReplaceChild("Spetal_r2", CubeListBuilder.create().texOffs(408, 224).addBox(-16.0F, -1.0F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r2 = FungalBloom2.addOrReplaceChild("Wpetal_r2", CubeListBuilder.create().texOffs(406, 69).addBox(2.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r2 = FungalBloom2.addOrReplaceChild("Epetal_r2", CubeListBuilder.create().texOffs(406, 53).addBox(-18.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, 0.3927F));

		PartDefinition LeftArmConnectPoint = Kraken.addOrReplaceChild("LeftArmConnectPoint", CubeListBuilder.create(), PartPose.offset(21.0F, -55.0F, 5.0F));

		PartDefinition Biomass_r1 = LeftArmConnectPoint.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(426, 355).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1007F, 9.144F, -0.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = LeftArmConnectPoint.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(446, 24).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 0.4807F, 2.5226F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = LeftArmConnectPoint.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(60, 397).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5253F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = LeftArmConnectPoint.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(472, 217).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.609F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition RightArmConnectPoint = Kraken.addOrReplaceChild("RightArmConnectPoint", CubeListBuilder.create(), PartPose.offset(-17.0F, -55.0F, 5.0F));

		PartDefinition Biomass_r5 = RightArmConnectPoint.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(426, 377).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = RightArmConnectPoint.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(450, 125).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = RightArmConnectPoint.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(494, 399).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = RightArmConnectPoint.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(472, 235).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.609F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumors = Kraken.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor = Tumors.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(-20.0F, -49.0F, 36.0F));

		PartDefinition Biomass_r9 = Tumor.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(312, 436).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r10 = Tumor.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(458, 105).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r11 = Tumor.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(504, 0).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r12 = Tumor.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(472, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor2 = Tumors.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, -24.0F, 33.0F, 0.0F, 0.8727F, -1.5272F));

		PartDefinition Biomass_r13 = Tumor2.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(412, 436).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r14 = Tumor2.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(124, 457).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r15 = Tumor2.addOrReplaceChild("Biomass_r15", CubeListBuilder.create().texOffs(508, 206).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r16 = Tumor2.addOrReplaceChild("Biomass_r16", CubeListBuilder.create().texOffs(472, 271).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor3 = Tumors.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offset(-16.0F, -17.0F, 15.0F));

		PartDefinition Biomass_r17 = Tumor3.addOrReplaceChild("Biomass_r17", CubeListBuilder.create().texOffs(426, 399).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r18 = Tumor3.addOrReplaceChild("Biomass_r18", CubeListBuilder.create().texOffs(212, 450).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r19 = Tumor3.addOrReplaceChild("Biomass_r19", CubeListBuilder.create().texOffs(508, 222).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r20 = Tumor3.addOrReplaceChild("Biomass_r20", CubeListBuilder.create().texOffs(472, 289).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor4 = Tumors.addOrReplaceChild("Tumor4", CubeListBuilder.create(), PartPose.offset(22.0F, -49.0F, 36.0F));

		PartDefinition Biomass_r21 = Tumor4.addOrReplaceChild("Biomass_r21", CubeListBuilder.create().texOffs(356, 439).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r22 = Tumor4.addOrReplaceChild("Biomass_r22", CubeListBuilder.create().texOffs(252, 458).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r23 = Tumor4.addOrReplaceChild("Biomass_r23", CubeListBuilder.create().texOffs(508, 238).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r24 = Tumor4.addOrReplaceChild("Biomass_r24", CubeListBuilder.create().texOffs(472, 307).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor5 = Tumors.addOrReplaceChild("Tumor5", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -27.0F, 33.0F, 0.0F, -0.8727F, 1.5272F));

		PartDefinition Biomass_r25 = Tumor5.addOrReplaceChild("Biomass_r25", CubeListBuilder.create().texOffs(440, 159).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r26 = Tumor5.addOrReplaceChild("Biomass_r26", CubeListBuilder.create().texOffs(458, 85).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r27 = Tumor5.addOrReplaceChild("Biomass_r27", CubeListBuilder.create().texOffs(508, 254).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r28 = Tumor5.addOrReplaceChild("Biomass_r28", CubeListBuilder.create().texOffs(472, 325).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor6 = Tumors.addOrReplaceChild("Tumor6", CubeListBuilder.create(), PartPose.offset(16.0F, -17.0F, 15.0F));

		PartDefinition Biomass_r29 = Tumor6.addOrReplaceChild("Biomass_r29", CubeListBuilder.create().texOffs(224, 428).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r30 = Tumor6.addOrReplaceChild("Biomass_r30", CubeListBuilder.create().texOffs(456, 181).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r31 = Tumor6.addOrReplaceChild("Biomass_r31", CubeListBuilder.create().texOffs(508, 270).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r32 = Tumor6.addOrReplaceChild("Biomass_r32", CubeListBuilder.create().texOffs(448, 476).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor7 = Tumors.addOrReplaceChild("Tumor7", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, -31.0F, 29.0F, -0.0859F, -0.0151F, -0.1739F));

		PartDefinition Biomass_r33 = Tumor7.addOrReplaceChild("Biomass_r33", CubeListBuilder.create().texOffs(54, 435).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r34 = Tumor7.addOrReplaceChild("Biomass_r34", CubeListBuilder.create().texOffs(456, 436).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r35 = Tumor7.addOrReplaceChild("Biomass_r35", CubeListBuilder.create().texOffs(518, 366).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r36 = Tumor7.addOrReplaceChild("Biomass_r36", CubeListBuilder.create().texOffs(24, 477).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor8 = Tumors.addOrReplaceChild("Tumor8", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -17.0F, 15.0F, 2.7111F, 0.0735F, -2.0232F));

		PartDefinition Biomass_r37 = Tumor8.addOrReplaceChild("Biomass_r37", CubeListBuilder.create().texOffs(98, 435).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r38 = Tumor8.addOrReplaceChild("Biomass_r38", CubeListBuilder.create().texOffs(456, 456).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r39 = Tumor8.addOrReplaceChild("Biomass_r39", CubeListBuilder.create().texOffs(508, 286).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r40 = Tumor8.addOrReplaceChild("Biomass_r40", CubeListBuilder.create().texOffs(60, 477).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor9 = Tumors.addOrReplaceChild("Tumor9", CubeListBuilder.create(), PartPose.offset(16.0F, -29.0F, 27.0F));

		PartDefinition Biomass_r41 = Tumor9.addOrReplaceChild("Biomass_r41", CubeListBuilder.create().texOffs(142, 435).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r42 = Tumor9.addOrReplaceChild("Biomass_r42", CubeListBuilder.create().texOffs(44, 457).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r43 = Tumor9.addOrReplaceChild("Biomass_r43", CubeListBuilder.create().texOffs(518, 382).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r44 = Tumor9.addOrReplaceChild("Biomass_r44", CubeListBuilder.create().texOffs(96, 477).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor10 = Tumors.addOrReplaceChild("Tumor10", CubeListBuilder.create(), PartPose.offset(13.0F, -37.0F, 44.0F));

		PartDefinition Biomass_r45 = Tumor10.addOrReplaceChild("Biomass_r45", CubeListBuilder.create().texOffs(268, 436).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -6.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r46 = Tumor10.addOrReplaceChild("Biomass_r46", CubeListBuilder.create().texOffs(84, 457).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9835F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r47 = Tumor10.addOrReplaceChild("Biomass_r47", CubeListBuilder.create().texOffs(508, 302).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 5.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r48 = Tumor10.addOrReplaceChild("Biomass_r48", CubeListBuilder.create().texOffs(236, 478).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor11 = Tumors.addOrReplaceChild("Tumor11", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -35.0F, 37.0F, 2.0084F, -0.0151F, -0.1739F));

		PartDefinition Biomass_r49 = Tumor11.addOrReplaceChild("Biomass_r49", CubeListBuilder.create().texOffs(0, 443).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r50 = Tumor11.addOrReplaceChild("Biomass_r50", CubeListBuilder.create().texOffs(292, 458).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r51 = Tumor11.addOrReplaceChild("Biomass_r51", CubeListBuilder.create().texOffs(508, 318).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r52 = Tumor11.addOrReplaceChild("Biomass_r52", CubeListBuilder.create().texOffs(272, 478).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition BackJaw = Kraken.addOrReplaceChild("BackJaw", CubeListBuilder.create().texOffs(274, 363).addBox(-23.0F, -24.25F, 20.0F, 43.0F, 41.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -84.0F, 60.0F, -2.5037F, -0.3159F, 0.2742F));

		PartDefinition cube_r16 = BackJaw.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 353).addBox(-26.0F, -25.0F, 1.0F, 46.0F, 44.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -9.0F, 10.0F, 0.0F, 0.0F, -1.7453F));

		PartDefinition Outer = BackJaw.addOrReplaceChild("Outer", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition OuterRingBase = Outer.addOrReplaceChild("OuterRingBase", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition Internal = OuterRingBase.addOrReplaceChild("Internal", CubeListBuilder.create(), PartPose.offset(-17.3889F, -10.5693F, 0.2138F));

		PartDefinition In_r1 = Internal.addOrReplaceChild("In_r1", CubeListBuilder.create().texOffs(360, 422).addBox(-8.5F, -1.0F, 0.0F, 11.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1278F, -13.2359F, 2.8005F, -1.2813F, -0.044F, -1.2561F));

		PartDefinition In_r2 = Internal.addOrReplaceChild("In_r2", CubeListBuilder.create().texOffs(372, 32).addBox(-9.5F, -5.0F, -2.5F, 21.0F, 5.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9759F, 2.5706F, -0.4779F, -1.0525F, -0.0008F, -1.0912F));

		PartDefinition In_r3 = Internal.addOrReplaceChild("In_r3", CubeListBuilder.create().texOffs(444, 320).addBox(-3.0F, -11.0F, 0.0F, 3.0F, 22.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8206F, 18.9982F, -1.0294F, -0.0068F, 0.8756F, -0.3546F));

		PartDefinition In_r4 = Internal.addOrReplaceChild("In_r4", CubeListBuilder.create().texOffs(412, 422).addBox(-15.0F, -1.0F, -0.75F, 17.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0235F, 32.4363F, -0.1189F, 0.7549F, -0.1543F, 0.2614F));

		PartDefinition In_r5 = Internal.addOrReplaceChild("In_r5", CubeListBuilder.create().texOffs(160, 420).addBox(-12.0F, 0.0F, 0.0F, 22.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.8346F, 32.2659F, -1.1743F, 0.6653F, 0.2264F, 0.1636F));

		PartDefinition In_r6 = Internal.addOrReplaceChild("In_r6", CubeListBuilder.create().texOffs(94, 280).addBox(0.0F, -11.25F, 0.0F, 4.0F, 24.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.8053F, 24.2715F, -1.2138F, 0.0F, -1.0472F, 0.6981F));

		PartDefinition In_r7 = Internal.addOrReplaceChild("In_r7", CubeListBuilder.create().texOffs(186, 435).addBox(0.0F, -8.0F, -1.0F, 3.0F, 27.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.3632F, -2.8223F, -0.2138F, 0.0F, -0.5672F, -0.1309F));

		PartDefinition In_r8 = Internal.addOrReplaceChild("In_r8", CubeListBuilder.create().texOffs(396, 210).addBox(-1.0F, -3.0F, -1.0F, 24.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(17.3889F, -18.4307F, -0.2138F, -0.7854F, 0.0F, 0.3491F));

		PartDefinition In_r9 = Internal.addOrReplaceChild("In_r9", CubeListBuilder.create().texOffs(60, 421).addBox(-4.0F, -2.0F, -2.0F, 21.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.521F, -9.9773F, 0.0163F, -0.6475F, -0.1293F, -0.392F));

		PartDefinition OuterRingDetails = Outer.addOrReplaceChild("OuterRingDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth = OuterRingDetails.addOrReplaceChild("Teeth", CubeListBuilder.create(), PartPose.offset(-17.0523F, -6.3894F, 2.3538F));

		PartDefinition t_r1 = Teeth.addOrReplaceChild("t_r1", CubeListBuilder.create().texOffs(182, 636).addBox(2.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0941F, -18.3761F, -1.664F, 0.7264F, -1.2636F, 0.4739F));

		PartDefinition t_r2 = Teeth.addOrReplaceChild("t_r2", CubeListBuilder.create().texOffs(448, 458).addBox(0.0F, -6.0F, -2.0F, 0.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.312F, -13.9163F, 0.78F, 0.5253F, 0.5993F, -1.5362F));

		PartDefinition t_r3 = Teeth.addOrReplaceChild("t_r3", CubeListBuilder.create().texOffs(150, 636).addBox(1.0F, -6.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1966F, -9.8531F, 1.7807F, 0.3416F, 0.7103F, -1.836F));

		PartDefinition t_r4 = Teeth.addOrReplaceChild("t_r4", CubeListBuilder.create().texOffs(294, 634).addBox(0.0F, -7.5F, -2.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1734F, -9.8606F, 3.8521F, -0.0483F, 0.1629F, -2.6431F));

		PartDefinition t_r5 = Teeth.addOrReplaceChild("t_r5", CubeListBuilder.create().texOffs(332, 535).addBox(3.0153F, -0.994F, -3.5092F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.2843F, 4.4467F, -3.2326F, 0.0282F, -1.391F, 3.084F));

		PartDefinition t_r6 = Teeth.addOrReplaceChild("t_r6", CubeListBuilder.create().texOffs(102, 635).addBox(0.5047F, -6.2786F, -3.0491F, 0.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.4971F, -15.0265F, 0.3015F, -0.2253F, -0.5651F, 2.1665F));

		PartDefinition t_r7 = Teeth.addOrReplaceChild("t_r7", CubeListBuilder.create().texOffs(136, 178).addBox(0.0F, -9.5F, -2.0F, 0.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.3905F, -15.0528F, 1.5427F, -0.0125F, -1.1606F, 1.7558F));

		PartDefinition t_r8 = Teeth.addOrReplaceChild("t_r8", CubeListBuilder.create().texOffs(142, 636).addBox(0.0F, -9.0F, -4.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.0178F, 12.6029F, 0.3954F, -0.2979F, -0.9583F, -2.2563F));

		PartDefinition t_r9 = Teeth.addOrReplaceChild("t_r9", CubeListBuilder.create().texOffs(180, 506).addBox(2.585F, -8.0883F, -3.9685F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.3906F, 12.8665F, 0.1298F, 0.4809F, -0.9945F, -3.0232F));

		PartDefinition t_r10 = Teeth.addOrReplaceChild("t_r10", CubeListBuilder.create().texOffs(132, 631).addBox(1.0F, -12.5F, -3.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.9907F, 14.6601F, -1.1661F, 0.6668F, -1.1623F, 3.1378F));

		PartDefinition t_r11 = Teeth.addOrReplaceChild("t_r11", CubeListBuilder.create().texOffs(482, 636).addBox(-1.2832F, 1.6868F, 0.3516F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 18.5957F, -0.9501F, 0.5084F, -1.2142F, -1.9009F));

		PartDefinition t_r12 = Teeth.addOrReplaceChild("t_r12", CubeListBuilder.create().texOffs(136, 201).addBox(-1.4437F, -2.127F, 0.9602F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 20.5957F, -0.9501F, -0.2115F, -1.4282F, -1.1357F));

		PartDefinition t_r13 = Teeth.addOrReplaceChild("t_r13", CubeListBuilder.create().texOffs(496, 179).addBox(3.3546F, -2.5132F, -1.3209F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0928F, 19.5957F, -0.9501F, 0.0282F, -1.391F, -1.4539F));

		PartDefinition t_r14 = Teeth.addOrReplaceChild("t_r14", CubeListBuilder.create().texOffs(234, 635).addBox(0.1506F, -6.8775F, -1.7368F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0037F, 21.1406F, -0.0792F, 1.0115F, -0.9532F, -2.5209F));

		PartDefinition t_r15 = Teeth.addOrReplaceChild("t_r15", CubeListBuilder.create().texOffs(366, 634).addBox(-3.0F, -5.5F, -1.5F, 0.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1931F, 20.7673F, -2.0586F, 0.5422F, -0.5946F, -1.8354F));

		PartDefinition t_r16 = Teeth.addOrReplaceChild("t_r16", CubeListBuilder.create().texOffs(140, 547).addBox(0.0F, -5.0F, -2.75F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, 12.5348F, 2.0547F, -2.3755F, -1.4575F, 2.0867F));

		PartDefinition t_r17 = Teeth.addOrReplaceChild("t_r17", CubeListBuilder.create().texOffs(44, 443).addBox(-0.8494F, -3.8775F, -1.7368F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9963F, 12.1406F, -0.0792F, 0.5084F, -1.2142F, -0.8537F));

		PartDefinition t_r18 = Teeth.addOrReplaceChild("t_r18", CubeListBuilder.create().texOffs(484, 158).addBox(1.25F, -7.0F, -3.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9446F, -1.3693F, -0.7078F, -0.1205F, -1.2586F, 0.5948F));

		PartDefinition t_r19 = Teeth.addOrReplaceChild("t_r19", CubeListBuilder.create().texOffs(454, 567).addBox(0.0F, -6.5F, -4.5F, 0.0F, 15.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8788F, -2.8637F, -1.1866F, 0.3296F, -0.9814F, -0.0968F));

		PartDefinition t_r20 = Teeth.addOrReplaceChild("t_r20", CubeListBuilder.create().texOffs(226, 627).addBox(0.0F, -10.25F, -3.0F, 0.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0593F, 3.2013F, 2.1114F, -0.1942F, -0.9634F, 0.7791F));

		PartDefinition BackBodyMouthProtection = Kraken.addOrReplaceChild("BackBodyMouthProtection", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HindeRotation = BackBodyMouthProtection.addOrReplaceChild("HindeRotation", CubeListBuilder.create(), PartPose.offsetAndRotation(29.0F, -91.0F, 48.75F, -0.7813F, 0.286F, -0.2729F));

		PartDefinition Hinge1 = HindeRotation.addOrReplaceChild("Hinge1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHinge = Hinge1.addOrReplaceChild("LeftHinge", CubeListBuilder.create().texOffs(140, 563).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib3Tip_r1", CubeListBuilder.create().texOffs(624, 46).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 10).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib3_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib3_r1", CubeListBuilder.create().texOffs(212, 539).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 538).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(164, 457).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib2_r1 = LeftHinge.addOrReplaceChild("LowerRidgeRib2_r1", CubeListBuilder.create().texOffs(524, 538).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeLowerMemebrane = LeftHinge.addOrReplaceChild("HingeLowerMemebrane", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r1 = HingeLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r1", CubeListBuilder.create().texOffs(508, 529).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r1 = HingeLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r1", CubeListBuilder.create().texOffs(400, 458).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r2 = HingeLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembraneTip_r2", CubeListBuilder.create().texOffs(380, 461).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r2 = HingeLowerMemebrane.addOrReplaceChild("LowerRidgeFrontMembrane_r2", CubeListBuilder.create().texOffs(332, 458).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleHinge = LeftHinge.addOrReplaceChild("HingeMiddleHinge", CubeListBuilder.create().texOffs(610, 53).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r1 = HingeMiddleHinge.addOrReplaceChild("MiddleRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(610, 85).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(610, 73).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib2_r1 = HingeMiddleHinge.addOrReplaceChild("MiddleRidgeRib2_r1", CubeListBuilder.create().texOffs(540, 195).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(242, 539).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleMemebrane = HingeMiddleHinge.addOrReplaceChild("HingeMiddleMemebrane", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r1 = HingeMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r1", CubeListBuilder.create().texOffs(168, 587).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r1 = HingeMiddleMemebrane.addOrReplaceChild("MiddleRidgeFrontMembrane_r1", CubeListBuilder.create().texOffs(308, 478).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r1 = HingeMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembrane_r1", CubeListBuilder.create().texOffs(188, 472).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r1 = HingeMiddleMemebrane.addOrReplaceChild("MiddleRidgeBackMembraneTip_r1", CubeListBuilder.create().texOffs(454, 589).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HingeTopHinge = HingeMiddleHinge.addOrReplaceChild("HingeTopHinge", CubeListBuilder.create().texOffs(440, 595).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(610, 482).addBox(-1.5F, -31.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(308, 506).addBox(-1.9095F, -23.513F, -10.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r1 = HingeTopHinge.addOrReplaceChild("TopRidgeRib3Tip_r1", CubeListBuilder.create().texOffs(624, 58).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 482).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib3_r1 = HingeTopHinge.addOrReplaceChild("TopRidgeRib3_r1", CubeListBuilder.create().texOffs(540, 243).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(540, 211).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r1 = HingeTopHinge.addOrReplaceChild("TopRidgeRib2Tip_r1", CubeListBuilder.create().texOffs(168, 610).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib2_r1 = HingeTopHinge.addOrReplaceChild("TopRidgeRib2_r1", CubeListBuilder.create().texOffs(540, 227).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane = HingeTopHinge.addOrReplaceChild("LeftTopMemebrane", CubeListBuilder.create(), PartPose.offset(-4.1021F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r1 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebraneTip_r1", CubeListBuilder.create().texOffs(306, 633).addBox(-1.5F, -36.01F, -5.25F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(184, 587).addBox(-1.5F, -28.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r1 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebrane_r1", CubeListBuilder.create().texOffs(498, 70).addBox(-0.5F, -42.0F, -12.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(332, 492).addBox(-0.5F, -27.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r2 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebraneTip_r2", CubeListBuilder.create().texOffs(514, 633).addBox(-1.5F, -36.01F, -2.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(470, 589).addBox(-1.5F, -28.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r2 = LeftTopMemebrane.addOrReplaceChild("LeftRidgeTopMemebrane_r2", CubeListBuilder.create().texOffs(498, 97).addBox(-0.5F, -42.0F, 0.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(492, 151).addBox(-0.5F, -27.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition HindeRotation2 = BackBodyMouthProtection.addOrReplaceChild("HindeRotation2", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -107.0F, 35.75F, -1.8053F, 0.7486F, -1.8947F));

		PartDefinition Hinge2 = HindeRotation2.addOrReplaceChild("Hinge2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHinge2 = Hinge2.addOrReplaceChild("LeftHinge2", CubeListBuilder.create().texOffs(140, 563).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r2 = LeftHinge2.addOrReplaceChild("LowerRidgeRib3Tip_r2", CubeListBuilder.create().texOffs(624, 46).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 10).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib4_r1 = LeftHinge2.addOrReplaceChild("LowerRidgeRib4_r1", CubeListBuilder.create().texOffs(212, 539).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 538).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r2 = LeftHinge2.addOrReplaceChild("LowerRidgeRib2Tip_r2", CubeListBuilder.create().texOffs(164, 457).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib3_r2 = LeftHinge2.addOrReplaceChild("LowerRidgeRib3_r2", CubeListBuilder.create().texOffs(524, 538).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeLowerMemebrane2 = LeftHinge2.addOrReplaceChild("HingeLowerMemebrane2", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r3 = HingeLowerMemebrane2.addOrReplaceChild("LowerRidgeFrontMembraneTip_r3", CubeListBuilder.create().texOffs(508, 529).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r3 = HingeLowerMemebrane2.addOrReplaceChild("LowerRidgeFrontMembrane_r3", CubeListBuilder.create().texOffs(400, 458).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r4 = HingeLowerMemebrane2.addOrReplaceChild("LowerRidgeFrontMembraneTip_r4", CubeListBuilder.create().texOffs(380, 461).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r4 = HingeLowerMemebrane2.addOrReplaceChild("LowerRidgeFrontMembrane_r4", CubeListBuilder.create().texOffs(332, 458).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleHinge2 = LeftHinge2.addOrReplaceChild("HingeMiddleHinge2", CubeListBuilder.create().texOffs(610, 53).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r2 = HingeMiddleHinge2.addOrReplaceChild("MiddleRidgeRib2Tip_r2", CubeListBuilder.create().texOffs(610, 85).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(610, 73).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib3_r1 = HingeMiddleHinge2.addOrReplaceChild("MiddleRidgeRib3_r1", CubeListBuilder.create().texOffs(540, 195).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(242, 539).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleMemebrane2 = HingeMiddleHinge2.addOrReplaceChild("HingeMiddleMemebrane2", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r2 = HingeMiddleMemebrane2.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r2", CubeListBuilder.create().texOffs(168, 587).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r2 = HingeMiddleMemebrane2.addOrReplaceChild("MiddleRidgeFrontMembrane_r2", CubeListBuilder.create().texOffs(308, 478).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r2 = HingeMiddleMemebrane2.addOrReplaceChild("MiddleRidgeBackMembrane_r2", CubeListBuilder.create().texOffs(188, 472).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r2 = HingeMiddleMemebrane2.addOrReplaceChild("MiddleRidgeBackMembraneTip_r2", CubeListBuilder.create().texOffs(454, 589).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HingeTopHinge2 = HingeMiddleHinge2.addOrReplaceChild("HingeTopHinge2", CubeListBuilder.create().texOffs(440, 595).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(610, 482).addBox(-1.5F, -31.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(308, 506).addBox(-1.9095F, -23.513F, -10.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r2 = HingeTopHinge2.addOrReplaceChild("TopRidgeRib3Tip_r2", CubeListBuilder.create().texOffs(624, 58).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 482).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib4_r1 = HingeTopHinge2.addOrReplaceChild("TopRidgeRib4_r1", CubeListBuilder.create().texOffs(540, 243).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(540, 211).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r2 = HingeTopHinge2.addOrReplaceChild("TopRidgeRib2Tip_r2", CubeListBuilder.create().texOffs(168, 610).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib3_r2 = HingeTopHinge2.addOrReplaceChild("TopRidgeRib3_r2", CubeListBuilder.create().texOffs(540, 227).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane2 = HingeTopHinge2.addOrReplaceChild("LeftTopMemebrane2", CubeListBuilder.create(), PartPose.offset(-4.102F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r3 = LeftTopMemebrane2.addOrReplaceChild("LeftRidgeTopMemebraneTip_r3", CubeListBuilder.create().texOffs(306, 633).addBox(-1.5F, -36.01F, -5.25F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(184, 587).addBox(-1.5F, -28.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r3 = LeftTopMemebrane2.addOrReplaceChild("LeftRidgeTopMemebrane_r3", CubeListBuilder.create().texOffs(498, 70).addBox(-0.5F, -42.0F, -12.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(332, 492).addBox(-0.5F, -27.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r4 = LeftTopMemebrane2.addOrReplaceChild("LeftRidgeTopMemebraneTip_r4", CubeListBuilder.create().texOffs(514, 633).addBox(-1.5F, -36.01F, -2.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(470, 589).addBox(-1.5F, -28.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r4 = LeftTopMemebrane2.addOrReplaceChild("LeftRidgeTopMemebrane_r4", CubeListBuilder.create().texOffs(498, 97).addBox(-0.5F, -42.0F, 0.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(492, 151).addBox(-0.5F, -27.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition HindeRotation3 = BackBodyMouthProtection.addOrReplaceChild("HindeRotation3", CubeListBuilder.create(), PartPose.offsetAndRotation(-34.4F, -84.5F, 56.25F, -2.4068F, -0.1204F, -3.074F));

		PartDefinition Hinge3 = HindeRotation3.addOrReplaceChild("Hinge3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHinge3 = Hinge3.addOrReplaceChild("LeftHinge3", CubeListBuilder.create().texOffs(140, 563).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r3 = LeftHinge3.addOrReplaceChild("LowerRidgeRib3Tip_r3", CubeListBuilder.create().texOffs(624, 46).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 10).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib5_r1 = LeftHinge3.addOrReplaceChild("LowerRidgeRib5_r1", CubeListBuilder.create().texOffs(212, 539).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 538).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r3 = LeftHinge3.addOrReplaceChild("LowerRidgeRib2Tip_r3", CubeListBuilder.create().texOffs(164, 457).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib4_r2 = LeftHinge3.addOrReplaceChild("LowerRidgeRib4_r2", CubeListBuilder.create().texOffs(524, 538).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeLowerMemebrane3 = LeftHinge3.addOrReplaceChild("HingeLowerMemebrane3", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r5 = HingeLowerMemebrane3.addOrReplaceChild("LowerRidgeFrontMembraneTip_r5", CubeListBuilder.create().texOffs(508, 529).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r5 = HingeLowerMemebrane3.addOrReplaceChild("LowerRidgeFrontMembrane_r5", CubeListBuilder.create().texOffs(400, 458).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r6 = HingeLowerMemebrane3.addOrReplaceChild("LowerRidgeFrontMembraneTip_r6", CubeListBuilder.create().texOffs(380, 461).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r6 = HingeLowerMemebrane3.addOrReplaceChild("LowerRidgeFrontMembrane_r6", CubeListBuilder.create().texOffs(332, 458).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleHinge3 = LeftHinge3.addOrReplaceChild("HingeMiddleHinge3", CubeListBuilder.create().texOffs(610, 53).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r3 = HingeMiddleHinge3.addOrReplaceChild("MiddleRidgeRib2Tip_r3", CubeListBuilder.create().texOffs(610, 85).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(610, 73).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib4_r1 = HingeMiddleHinge3.addOrReplaceChild("MiddleRidgeRib4_r1", CubeListBuilder.create().texOffs(540, 195).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(242, 539).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleMemebrane3 = HingeMiddleHinge3.addOrReplaceChild("HingeMiddleMemebrane3", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r3 = HingeMiddleMemebrane3.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r3", CubeListBuilder.create().texOffs(168, 587).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r3 = HingeMiddleMemebrane3.addOrReplaceChild("MiddleRidgeFrontMembrane_r3", CubeListBuilder.create().texOffs(308, 478).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r3 = HingeMiddleMemebrane3.addOrReplaceChild("MiddleRidgeBackMembrane_r3", CubeListBuilder.create().texOffs(188, 472).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r3 = HingeMiddleMemebrane3.addOrReplaceChild("MiddleRidgeBackMembraneTip_r3", CubeListBuilder.create().texOffs(454, 589).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HingeTopHinge3 = HingeMiddleHinge3.addOrReplaceChild("HingeTopHinge3", CubeListBuilder.create().texOffs(440, 595).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(610, 482).addBox(-1.5F, -31.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(308, 506).addBox(-1.9095F, -23.513F, -10.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r3 = HingeTopHinge3.addOrReplaceChild("TopRidgeRib3Tip_r3", CubeListBuilder.create().texOffs(624, 58).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 482).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib5_r1 = HingeTopHinge3.addOrReplaceChild("TopRidgeRib5_r1", CubeListBuilder.create().texOffs(540, 243).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(540, 211).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r3 = HingeTopHinge3.addOrReplaceChild("TopRidgeRib2Tip_r3", CubeListBuilder.create().texOffs(168, 610).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib4_r2 = HingeTopHinge3.addOrReplaceChild("TopRidgeRib4_r2", CubeListBuilder.create().texOffs(540, 227).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane3 = HingeTopHinge3.addOrReplaceChild("LeftTopMemebrane3", CubeListBuilder.create(), PartPose.offset(-4.102F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r5 = LeftTopMemebrane3.addOrReplaceChild("LeftRidgeTopMemebraneTip_r5", CubeListBuilder.create().texOffs(306, 633).addBox(-1.5F, -36.01F, -5.25F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(184, 587).addBox(-1.5F, -28.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r5 = LeftTopMemebrane3.addOrReplaceChild("LeftRidgeTopMemebrane_r5", CubeListBuilder.create().texOffs(498, 70).addBox(-0.5F, -42.0F, -12.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(332, 492).addBox(-0.5F, -27.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r6 = LeftTopMemebrane3.addOrReplaceChild("LeftRidgeTopMemebraneTip_r6", CubeListBuilder.create().texOffs(514, 633).addBox(-1.5F, -36.01F, -2.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(470, 589).addBox(-1.5F, -28.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r6 = LeftTopMemebrane3.addOrReplaceChild("LeftRidgeTopMemebrane_r6", CubeListBuilder.create().texOffs(498, 97).addBox(-0.5F, -42.0F, 0.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(492, 151).addBox(-0.5F, -27.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition HindeRotation4 = BackBodyMouthProtection.addOrReplaceChild("HindeRotation4", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.7F, -62.0F, 76.95F, -1.7852F, -0.7322F, 2.0344F));

		PartDefinition Hinge4 = HindeRotation4.addOrReplaceChild("Hinge4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHinge4 = Hinge4.addOrReplaceChild("LeftHinge4", CubeListBuilder.create().texOffs(140, 563).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r4 = LeftHinge4.addOrReplaceChild("LowerRidgeRib3Tip_r4", CubeListBuilder.create().texOffs(624, 46).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 10).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib6_r1 = LeftHinge4.addOrReplaceChild("LowerRidgeRib6_r1", CubeListBuilder.create().texOffs(212, 539).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 538).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r4 = LeftHinge4.addOrReplaceChild("LowerRidgeRib2Tip_r4", CubeListBuilder.create().texOffs(164, 457).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib5_r2 = LeftHinge4.addOrReplaceChild("LowerRidgeRib5_r2", CubeListBuilder.create().texOffs(524, 538).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeLowerMemebrane4 = LeftHinge4.addOrReplaceChild("HingeLowerMemebrane4", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r7 = HingeLowerMemebrane4.addOrReplaceChild("LowerRidgeFrontMembraneTip_r7", CubeListBuilder.create().texOffs(508, 529).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r7 = HingeLowerMemebrane4.addOrReplaceChild("LowerRidgeFrontMembrane_r7", CubeListBuilder.create().texOffs(400, 458).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r8 = HingeLowerMemebrane4.addOrReplaceChild("LowerRidgeFrontMembraneTip_r8", CubeListBuilder.create().texOffs(380, 461).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r8 = HingeLowerMemebrane4.addOrReplaceChild("LowerRidgeFrontMembrane_r8", CubeListBuilder.create().texOffs(332, 458).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleHinge4 = LeftHinge4.addOrReplaceChild("HingeMiddleHinge4", CubeListBuilder.create().texOffs(610, 53).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r4 = HingeMiddleHinge4.addOrReplaceChild("MiddleRidgeRib2Tip_r4", CubeListBuilder.create().texOffs(610, 85).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(610, 73).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib5_r1 = HingeMiddleHinge4.addOrReplaceChild("MiddleRidgeRib5_r1", CubeListBuilder.create().texOffs(540, 195).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(242, 539).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleMemebrane4 = HingeMiddleHinge4.addOrReplaceChild("HingeMiddleMemebrane4", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r4 = HingeMiddleMemebrane4.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r4", CubeListBuilder.create().texOffs(168, 587).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r4 = HingeMiddleMemebrane4.addOrReplaceChild("MiddleRidgeFrontMembrane_r4", CubeListBuilder.create().texOffs(308, 478).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r4 = HingeMiddleMemebrane4.addOrReplaceChild("MiddleRidgeBackMembrane_r4", CubeListBuilder.create().texOffs(188, 472).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r4 = HingeMiddleMemebrane4.addOrReplaceChild("MiddleRidgeBackMembraneTip_r4", CubeListBuilder.create().texOffs(454, 589).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HingeTopHinge4 = HingeMiddleHinge4.addOrReplaceChild("HingeTopHinge4", CubeListBuilder.create().texOffs(440, 595).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(610, 482).addBox(-1.5F, -31.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(308, 506).addBox(-1.9095F, -23.513F, -10.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r4 = HingeTopHinge4.addOrReplaceChild("TopRidgeRib3Tip_r4", CubeListBuilder.create().texOffs(624, 58).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 482).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib6_r1 = HingeTopHinge4.addOrReplaceChild("TopRidgeRib6_r1", CubeListBuilder.create().texOffs(540, 243).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(540, 211).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r4 = HingeTopHinge4.addOrReplaceChild("TopRidgeRib2Tip_r4", CubeListBuilder.create().texOffs(168, 610).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib5_r2 = HingeTopHinge4.addOrReplaceChild("TopRidgeRib5_r2", CubeListBuilder.create().texOffs(540, 227).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane4 = HingeTopHinge4.addOrReplaceChild("LeftTopMemebrane4", CubeListBuilder.create(), PartPose.offset(-4.1021F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r7 = LeftTopMemebrane4.addOrReplaceChild("LeftRidgeTopMemebraneTip_r7", CubeListBuilder.create().texOffs(306, 633).addBox(-1.5F, -36.01F, -5.25F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(184, 587).addBox(-1.5F, -28.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r7 = LeftTopMemebrane4.addOrReplaceChild("LeftRidgeTopMemebrane_r7", CubeListBuilder.create().texOffs(498, 70).addBox(-0.5F, -42.0F, -12.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(332, 492).addBox(-0.5F, -27.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r8 = LeftTopMemebrane4.addOrReplaceChild("LeftRidgeTopMemebraneTip_r8", CubeListBuilder.create().texOffs(514, 633).addBox(-1.5F, -36.01F, -2.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(470, 589).addBox(-1.5F, -28.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r8 = LeftTopMemebrane4.addOrReplaceChild("LeftRidgeTopMemebrane_r8", CubeListBuilder.create().texOffs(498, 97).addBox(-0.5F, -42.0F, 0.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(492, 151).addBox(-0.5F, -27.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition HindeRotation5 = BackBodyMouthProtection.addOrReplaceChild("HindeRotation5", CubeListBuilder.create(), PartPose.offsetAndRotation(21.4F, -64.5F, 71.45F, -0.9223F, -0.4679F, 0.6467F));

		PartDefinition Hinge5 = HindeRotation5.addOrReplaceChild("Hinge5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHinge5 = Hinge5.addOrReplaceChild("LeftHinge5", CubeListBuilder.create().texOffs(140, 563).addBox(-1.317F, -19.5391F, -2.0F, 3.0F, 24.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LowerRidgeRib3Tip_r5 = LeftHinge5.addOrReplaceChild("LowerRidgeRib3Tip_r5", CubeListBuilder.create().texOffs(624, 46).addBox(-2.5F, -2.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 10).addBox(-2.5F, 7.99F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -17.5391F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeRib7_r1 = LeftHinge5.addOrReplaceChild("LowerRidgeRib7_r1", CubeListBuilder.create().texOffs(212, 539).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(64, 538).addBox(-1.5F, 8.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -17.5391F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeRib2Tip_r5 = LeftHinge5.addOrReplaceChild("LowerRidgeRib2Tip_r5", CubeListBuilder.create().texOffs(164, 457).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6624F, -10.5391F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeRib6_r2 = LeftHinge5.addOrReplaceChild("LowerRidgeRib6_r2", CubeListBuilder.create().texOffs(524, 538).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -10.5391F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeLowerMemebrane5 = LeftHinge5.addOrReplaceChild("HingeLowerMemebrane5", CubeListBuilder.create(), PartPose.offset(-4.9227F, -7.5291F, 15.5254F));

		PartDefinition LowerRidgeFrontMembraneTip_r9 = HingeLowerMemebrane5.addOrReplaceChild("LowerRidgeFrontMembraneTip_r9", CubeListBuilder.create().texOffs(508, 529).addBox(-1.0F, -11.01F, -2.75F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r9 = HingeLowerMemebrane5.addOrReplaceChild("LowerRidgeFrontMembrane_r9", CubeListBuilder.create().texOffs(400, 458).addBox(0.0F, -11.0F, 0.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -14.0254F, 0.0F, -0.3491F, 0.0F));

		PartDefinition LowerRidgeFrontMembraneTip_r10 = HingeLowerMemebrane5.addOrReplaceChild("LowerRidgeFrontMembraneTip_r10", CubeListBuilder.create().texOffs(380, 461).addBox(-1.0F, -11.01F, -5.25F, 0.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -31.0508F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LowerRidgeFrontMembrane_r10 = HingeLowerMemebrane5.addOrReplaceChild("LowerRidgeFrontMembrane_r10", CubeListBuilder.create().texOffs(332, 458).addBox(0.0F, -11.0F, -12.0F, 0.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1057F, -0.01F, -17.0254F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleHinge5 = LeftHinge5.addOrReplaceChild("HingeMiddleHinge5", CubeListBuilder.create().texOffs(610, 53).addBox(-1.5905F, -15.487F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.183F, -19.5391F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition MiddleRidgeRib2Tip_r5 = HingeMiddleHinge5.addOrReplaceChild("MiddleRidgeRib2Tip_r5", CubeListBuilder.create().texOffs(610, 85).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(610, 73).addBox(-2.5F, 5.99F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8454F, -13.0F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib6_r1 = HingeMiddleHinge5.addOrReplaceChild("MiddleRidgeRib6_r1", CubeListBuilder.create().texOffs(540, 195).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(242, 539).addBox(-1.5F, 6.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition HingeMiddleMemebrane5 = HingeMiddleHinge5.addOrReplaceChild("HingeMiddleMemebrane5", CubeListBuilder.create(), PartPose.offset(-4.1925F, -6.99F, -15.6758F));

		PartDefinition MiddleRidgeFrontMembraneTip_r5 = HingeMiddleMemebrane5.addOrReplaceChild("MiddleRidgeFrontMembraneTip_r5", CubeListBuilder.create().texOffs(168, 587).addBox(-1.5F, -8.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeFrontMembrane_r5 = HingeMiddleMemebrane5.addOrReplaceChild("MiddleRidgeFrontMembrane_r5", CubeListBuilder.create().texOffs(308, 478).addBox(-0.5F, -8.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembrane_r5 = HingeMiddleMemebrane5.addOrReplaceChild("MiddleRidgeBackMembrane_r5", CubeListBuilder.create().texOffs(188, 472).addBox(-0.5F, -8.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -0.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MiddleRidgeBackMembraneTip_r5 = HingeMiddleMemebrane5.addOrReplaceChild("MiddleRidgeBackMembraneTip_r5", CubeListBuilder.create().texOffs(454, 589).addBox(-1.5F, -8.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition HingeTopHinge5 = HingeMiddleHinge5.addOrReplaceChild("HingeTopHinge5", CubeListBuilder.create().texOffs(440, 595).addBox(-1.5F, -16.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(610, 482).addBox(-1.5F, -31.0F, -2.0F, 3.0F, 16.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(308, 506).addBox(-1.9095F, -23.513F, -10.5F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0905F, -15.487F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition TopRidgeRib3Tip_r5 = HingeTopHinge5.addOrReplaceChild("TopRidgeRib3Tip_r5", CubeListBuilder.create().texOffs(624, 58).addBox(-2.5F, -33.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(624, 482).addBox(-2.5F, -23.01F, -2.75F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 17.487F, 15.0746F, 0.0F, -0.6981F, 0.0F));

		PartDefinition TopRidgeRib7_r1 = HingeTopHinge5.addOrReplaceChild("TopRidgeRib7_r1", CubeListBuilder.create().texOffs(540, 243).addBox(-1.5F, -33.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(540, 211).addBox(-1.5F, -23.0F, 0.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 17.487F, 1.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition TopRidgeRib2Tip_r5 = HingeTopHinge5.addOrReplaceChild("TopRidgeRib2Tip_r5", CubeListBuilder.create().texOffs(168, 610).addBox(-2.5F, -33.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7549F, 24.487F, -15.0746F, 0.0F, 0.6981F, 0.0F));

		PartDefinition TopRidgeRib6_r2 = HingeTopHinge5.addOrReplaceChild("TopRidgeRib6_r2", CubeListBuilder.create().texOffs(540, 227).addBox(-1.5F, -33.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0905F, 24.487F, -1.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftTopMemebrane5 = HingeTopHinge5.addOrReplaceChild("LeftTopMemebrane5", CubeListBuilder.create(), PartPose.offset(-4.102F, 27.497F, -15.6758F));

		PartDefinition LeftRidgeTopMemebraneTip_r9 = LeftTopMemebrane5.addOrReplaceChild("LeftRidgeTopMemebraneTip_r9", CubeListBuilder.create().texOffs(306, 633).addBox(-1.5F, -36.01F, -5.25F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(184, 587).addBox(-1.5F, -28.01F, -5.25F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r9 = LeftTopMemebrane5.addOrReplaceChild("LeftRidgeTopMemebrane_r9", CubeListBuilder.create().texOffs(498, 70).addBox(-0.5F, -42.0F, -12.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(332, 492).addBox(-0.5F, -27.0F, -12.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 14.1758F, 0.0F, 0.3491F, 0.0F));

		PartDefinition LeftRidgeTopMemebraneTip_r10 = LeftTopMemebrane5.addOrReplaceChild("LeftRidgeTopMemebraneTip_r10", CubeListBuilder.create().texOffs(514, 633).addBox(-1.5F, -36.01F, -2.75F, 0.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(470, 589).addBox(-1.5F, -28.01F, -2.75F, 0.0F, 15.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, 31.3516F, 0.0F, -0.6981F, 0.0F));

		PartDefinition LeftRidgeTopMemebrane_r10 = LeftTopMemebrane5.addOrReplaceChild("LeftRidgeTopMemebrane_r10", CubeListBuilder.create().texOffs(498, 97).addBox(-0.5F, -42.0F, 0.0F, 0.0F, 15.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(492, 151).addBox(-0.5F, -27.0F, 0.0F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1925F, -16.01F, 17.1758F, 0.0F, -0.3491F, 0.0F));

		PartDefinition FrontJaw = Kraken.addOrReplaceChild("FrontJaw", CubeListBuilder.create(), PartPose.offset(0.0F, -23.0F, -9.0F));

		PartDefinition jawBottom = FrontJaw.addOrReplaceChild("jawBottom", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 16.0F, 4.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r17 = jawBottom.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(396, 185).addBox(-3.0F, 10.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -37.1577F, -47.2909F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r18 = jawBottom.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(450, 145).addBox(-7.0F, -12.0F, -8.0F, 13.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, -21.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r19 = jawBottom.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(300, 404).addBox(-10.0F, -13.0F, -8.0F, 20.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 26.0F, -15.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r20 = jawBottom.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(292, 91).addBox(-11.0F, -21.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 26.0F, 3.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition head1 = jawBottom.addOrReplaceChild("head1", CubeListBuilder.create(), PartPose.offset(9.0F, 10.0F, -27.0F));

		PartDefinition teeth_r1 = head1.addOrReplaceChild("teeth_r1", CubeListBuilder.create().texOffs(560, 186).addBox(-4.0F, -10.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(524, 524).addBox(-4.0F, -16.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, 0.4363F, -3.1416F));

		PartDefinition head2 = jawBottom.addOrReplaceChild("head2", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 9.75F, -16.25F, 0.48F, -0.2618F, 0.0F));

		PartDefinition Head_r25 = head2.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(526, 398).addBox(-13.0F, -14.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(556, 525).addBox(-13.0F, -8.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -8.0F, -9.0F, 0.0F, 1.2654F, -3.1416F));

		PartDefinition head4 = jawBottom.addOrReplaceChild("head4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition teeth_r2 = head4.addOrReplaceChild("teeth_r2", CubeListBuilder.create().texOffs(558, 402).addBox(11.0F, -10.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(180, 527).addBox(11.0F, -16.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -0.7418F, -3.1416F));

		PartDefinition head5 = jawBottom.addOrReplaceChild("head5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r26 = head5.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(528, 167).addBox(15.0F, -13.0F, -20.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 568).addBox(15.0F, -7.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.0F, -27.0F, 0.0F, -1.2654F, -3.1416F));

		PartDefinition head3 = jawBottom.addOrReplaceChild("head3", CubeListBuilder.create().texOffs(528, 181).addBox(-4.25F, -8.0F, -28.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(408, 320).addBox(-4.25F, -9.0F, -28.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 20.0F, -7.0F));

		PartDefinition head6 = jawBottom.addOrReplaceChild("head6", CubeListBuilder.create().texOffs(476, 529).addBox(-3.25F, -1.0F, -6.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(200, 569).addBox(-3.25F, -2.0F, -6.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, 1.0F, -6.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition head7 = jawBottom.addOrReplaceChild("head7", CubeListBuilder.create().texOffs(120, 533).addBox(-3.25F, -1.0F, -6.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(318, 569).addBox(-3.25F, -2.0F, -6.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 1.0F, -6.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition RMouthBody2 = jawBottom.addOrReplaceChild("RMouthBody2", CubeListBuilder.create().texOffs(598, 472).addBox(-4.0F, -1.25F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0438F, 20.8213F, -15.5784F, 1.8457F, -0.886F, 1.2216F));

		PartDefinition Arm_r63 = RMouthBody2.addOrReplaceChild("Arm_r63", CubeListBuilder.create().texOffs(486, 601).addBox(-0.523F, -0.7803F, 0.0654F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3529F, 0.538F, 1.3928F, 2.05F, 1.2446F, -2.9678F));

		PartDefinition Arm_r64 = RMouthBody2.addOrReplaceChild("Arm_r64", CubeListBuilder.create().texOffs(312, 601).addBox(1.0F, -1.5F, -4.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0874F, -2.2563F, 9.3882F, -1.0368F, -1.4509F, 1.7805F));

		PartDefinition TorsoBase_r29 = RMouthBody2.addOrReplaceChild("TorsoBase_r29", CubeListBuilder.create().texOffs(606, 416).addBox(-4.5F, -0.75F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, 8.0F, 0.3005F, -0.1639F, 0.0602F));

		PartDefinition Head_r27 = RMouthBody2.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(380, 567).addBox(-2.0F, -3.25F, -10.25F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7855F, 0.1719F, 0.4971F));

		PartDefinition RMouthBody3 = jawBottom.addOrReplaceChild("RMouthBody3", CubeListBuilder.create().texOffs(598, 568).addBox(-4.0F, -1.25F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9562F, 13.8213F, -2.5784F, -1.8674F, 0.3357F, 1.2346F));

		PartDefinition Arm_r65 = RMouthBody3.addOrReplaceChild("Arm_r65", CubeListBuilder.create().texOffs(534, 601).addBox(-0.523F, -0.7803F, 0.0654F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3529F, 0.538F, 1.3929F, 2.05F, 1.2446F, -2.9678F));

		PartDefinition Arm_r66 = RMouthBody3.addOrReplaceChild("Arm_r66", CubeListBuilder.create().texOffs(510, 601).addBox(1.0F, -1.5F, -4.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0874F, -0.2563F, 9.3882F, -1.6913F, -1.4509F, 1.7805F));

		PartDefinition TorsoBase_r30 = RMouthBody3.addOrReplaceChild("TorsoBase_r30", CubeListBuilder.create().texOffs(606, 425).addBox(-4.5F, -0.75F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.75F, 8.0F, 0.3005F, -0.1639F, 0.0602F));

		PartDefinition Head_r28 = RMouthBody3.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(410, 567).addBox(-2.0F, -3.25F, -10.25F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7855F, 0.1719F, 0.4971F));

		PartDefinition jawTop = FrontJaw.addOrReplaceChild("jawTop", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -11.0F, -7.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition cube_r21 = jawTop.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 397).addBox(-3.0F, -26.0F, 54.0F, 21.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 37.1577F, -47.2909F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r22 = jawTop.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(466, 421).addBox(-7.0F, 7.0F, -8.0F, 13.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, -21.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r23 = jawTop.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(300, 420).addBox(-10.0F, 7.0F, -8.0F, 20.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, -15.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r24 = jawTop.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(294, 32).addBox(-11.0F, 15.0F, -5.0F, 21.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -26.0F, 3.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition head8 = jawTop.addOrReplaceChild("head8", CubeListBuilder.create(), PartPose.offset(9.0F, -10.0F, -27.0F));

		PartDefinition teeth_r3 = head8.addOrReplaceChild("teeth_r3", CubeListBuilder.create().texOffs(60, 570).addBox(-4.0F, 9.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(300, 535).addBox(-4.0F, 10.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.4363F, 3.1416F));

		PartDefinition head9 = jawTop.addOrReplaceChild("head9", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -9.75F, -16.25F, -0.48F, -0.2618F, 0.0F));

		PartDefinition Head_r29 = head9.addOrReplaceChild("Head_r29", CubeListBuilder.create().texOffs(352, 535).addBox(-13.0F, 8.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(568, 0).addBox(-13.0F, 6.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -9.0F, 0.0F, 1.2654F, 3.1416F));

		PartDefinition head10 = jawTop.addOrReplaceChild("head10", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition teeth_r4 = head10.addOrReplaceChild("teeth_r4", CubeListBuilder.create().texOffs(508, 568).addBox(11.0F, 8.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(536, 0).addBox(11.0F, 10.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -27.0F, 0.0F, -0.7418F, 3.1416F));

		PartDefinition head11 = jawTop.addOrReplaceChild("head11", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head_r30 = head11.addOrReplaceChild("Head_r30", CubeListBuilder.create().texOffs(384, 537).addBox(15.0F, 7.0F, -20.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(540, 568).addBox(15.0F, 5.0F, -20.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -27.0F, 0.0F, -1.2654F, 3.1416F));

		PartDefinition head12 = jawTop.addOrReplaceChild("head12", CubeListBuilder.create().texOffs(416, 537).addBox(-4.25F, 2.0F, -28.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 195).addBox(-4.25F, 8.0F, -28.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -20.0F, -7.0F));

		PartDefinition head13 = jawTop.addOrReplaceChild("head13", CubeListBuilder.create().texOffs(0, 538).addBox(-3.25F, -5.0F, -6.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 204).addBox(-3.25F, 1.0F, -6.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -1.0F, -6.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition head14 = jawTop.addOrReplaceChild("head14", CubeListBuilder.create().texOffs(32, 538).addBox(-3.25F, -5.0F, -6.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 213).addBox(-3.25F, 1.0F, -6.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -1.0F, -6.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition MouthTopCenterpiece = jawTop.addOrReplaceChild("MouthTopCenterpiece", CubeListBuilder.create(), PartPose.offsetAndRotation(8.7532F, -15.4933F, -16.641F, -0.6545F, 0.3927F, 0.0F));

		PartDefinition CenterTorsoTop_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoTop_r1", CubeListBuilder.create().texOffs(598, 452).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.9197F, -1.6236F, 0.6545F, 0.0F, 0.0F));

		PartDefinition CenterTorsoBack_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoBack_r1", CubeListBuilder.create().texOffs(24, 606).addBox(-10.5F, -4.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MTCPLimbs = MouthTopCenterpiece.addOrReplaceChild("MTCPLimbs", CubeListBuilder.create(), PartPose.offset(-7.0F, -3.9197F, -1.6236F));

		PartDefinition Leg_r28 = MTCPLimbs.addOrReplaceChild("Leg_r28", CubeListBuilder.create().texOffs(144, 601).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 6.0F, -0.0499F, 0.3027F, -0.0411F));

		PartDefinition RArm_r1 = MTCPLimbs.addOrReplaceChild("RArm_r1", CubeListBuilder.create().texOffs(586, 503).addBox(-1.0F, -0.9742F, -7.9043F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.3107F, -2.0349F, 0.5672F, -0.6109F, 0.0F));

		PartDefinition MTCPHead = MouthTopCenterpiece.addOrReplaceChild("MTCPHead", CubeListBuilder.create(), PartPose.offset(-6.9992F, -0.7425F, -4.9086F));

		PartDefinition MTCPHead_r1 = MTCPHead.addOrReplaceChild("MTCPHead_r1", CubeListBuilder.create().texOffs(236, 524).addBox(-3.9992F, -5.6417F, -7.7822F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0008F, -0.4155F, -0.0812F, 1.0036F, 0.0F, 0.0F));

		PartDefinition MTCPJaw = MTCPHead.addOrReplaceChild("MTCPJaw", CubeListBuilder.create(), PartPose.offset(-0.0008F, 0.2542F, 1.5355F));

		PartDefinition MTCPJaw_r1 = MTCPJaw.addOrReplaceChild("MTCPJaw_r1", CubeListBuilder.create().texOffs(570, 284).addBox(-4.0F, -0.3651F, -8.0861F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition MouthTopCenterpiece2 = jawTop.addOrReplaceChild("MouthTopCenterpiece2", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.2468F, -19.4933F, -16.641F, -2.3286F, 0.6851F, -2.2666F));

		PartDefinition CenterTorsoTop_r2 = MouthTopCenterpiece2.addOrReplaceChild("CenterTorsoTop_r2", CubeListBuilder.create().texOffs(598, 462).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.9197F, -1.6236F, 0.6545F, 0.0F, 0.0F));

		PartDefinition CenterTorsoBack_r2 = MouthTopCenterpiece2.addOrReplaceChild("CenterTorsoBack_r2", CubeListBuilder.create().texOffs(224, 606).addBox(-10.5F, -4.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition MTCPLimbs2 = MouthTopCenterpiece2.addOrReplaceChild("MTCPLimbs2", CubeListBuilder.create(), PartPose.offset(-7.0F, -3.9197F, -1.6236F));

		PartDefinition Leg_r29 = MTCPLimbs2.addOrReplaceChild("Leg_r29", CubeListBuilder.create().texOffs(200, 601).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 6.0F, -0.0499F, 0.3027F, -0.0411F));

		PartDefinition RArm_r2 = MTCPLimbs2.addOrReplaceChild("RArm_r2", CubeListBuilder.create().texOffs(586, 535).addBox(-1.0F, -0.9742F, -7.9043F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.3107F, -2.0349F, 0.5672F, -0.6109F, 0.0F));

		PartDefinition MTCPHead2 = MouthTopCenterpiece2.addOrReplaceChild("MTCPHead2", CubeListBuilder.create(), PartPose.offset(-6.9992F, -0.7425F, -4.9086F));

		PartDefinition MTCPHead_r2 = MTCPHead2.addOrReplaceChild("MTCPHead_r2", CubeListBuilder.create().texOffs(268, 524).addBox(-3.9992F, -5.6417F, -7.7822F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0008F, -0.4155F, -0.0812F, 1.0036F, 0.0F, 0.0F));

		PartDefinition MTCPJaw2 = MTCPHead2.addOrReplaceChild("MTCPJaw2", CubeListBuilder.create(), PartPose.offset(-0.0008F, 0.2542F, 1.5355F));

		PartDefinition MTCPJaw_r2 = MTCPJaw2.addOrReplaceChild("MTCPJaw_r2", CubeListBuilder.create().texOffs(570, 293).addBox(-4.0F, -0.3651F, -8.0861F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition rightJaw = FrontJaw.addOrReplaceChild("rightJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.0F, 0.0F, 3.0F, 0.3031F, 0.2725F, -1.6984F));

		PartDefinition cube_r25 = rightJaw.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(464, 0).addBox(-5.0F, 7.0F, -8.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7985F, -19.5391F, -11.0509F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r26 = rightJaw.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(404, 0).addBox(-6.0F, 15.0F, -5.0F, 12.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.7985F, -18.5391F, 5.9491F, -0.9163F, 0.0F, 0.0F));

		PartDefinition head15 = rightJaw.addOrReplaceChild("head15", CubeListBuilder.create(), PartPose.offset(8.7986F, -2.5391F, -17.0509F));

		PartDefinition teeth_r5 = head15.addOrReplaceChild("teeth_r5", CubeListBuilder.create().texOffs(570, 222).addBox(-4.0F, 9.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(554, 110).addBox(-4.0F, 10.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, 0.4363F, 3.1416F));

		PartDefinition head17 = rightJaw.addOrReplaceChild("head17", CubeListBuilder.create(), PartPose.offset(2.7985F, 7.4609F, 9.9491F));

		PartDefinition teeth_r6 = head17.addOrReplaceChild("teeth_r6", CubeListBuilder.create().texOffs(94, 318).addBox(11.0F, 8.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(124, 421).addBox(11.0F, 10.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -3.0F, -27.0F, 0.0F, -0.7418F, 3.1416F));

		PartDefinition head19 = rightJaw.addOrReplaceChild("head19", CubeListBuilder.create().texOffs(524, 554).addBox(-4.25F, 2.0F, -28.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 231).addBox(-4.25F, 8.0F, -28.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.7985F, -12.5391F, 2.9491F));

		PartDefinition leftJaw = FrontJaw.addOrReplaceChild("leftJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, 2.0F, 3.0F, 0.3031F, -0.2725F, 1.6984F));

		PartDefinition cube_r27 = leftJaw.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(464, 201).addBox(-5.0F, 7.0F, -8.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7985F, -19.5391F, -11.0509F, -0.0873F, 0.0F, 0.0F));

		PartDefinition cube_r28 = leftJaw.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(240, 404).addBox(-6.0F, 15.0F, -5.0F, 12.0F, 6.0F, 18.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.7985F, -18.5391F, 5.9491F, -0.9163F, 0.0F, 0.0F));

		PartDefinition head16 = leftJaw.addOrReplaceChild("head16", CubeListBuilder.create(), PartPose.offset(-8.7986F, -2.5391F, -17.0509F));

		PartDefinition teeth_r7 = head16.addOrReplaceChild("teeth_r7", CubeListBuilder.create().texOffs(570, 240).addBox(-4.0F, 9.0F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(554, 538).addBox(-4.0F, 10.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, 0.0F, -0.4363F, -3.1416F));

		PartDefinition head18 = leftJaw.addOrReplaceChild("head18", CubeListBuilder.create(), PartPose.offset(-2.7985F, 7.4609F, 9.9491F));

		PartDefinition teeth_r8 = head18.addOrReplaceChild("teeth_r8", CubeListBuilder.create().texOffs(240, 394).addBox(-19.0F, 8.0F, -13.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(524, 510).addBox(-19.0F, 10.0F, -13.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -3.0F, -27.0F, 0.0F, 0.7418F, -3.1416F));

		PartDefinition head20 = leftJaw.addOrReplaceChild("head20", CubeListBuilder.create().texOffs(210, 555).addBox(-3.75F, 2.0F, -28.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 249).addBox(-3.75F, 8.0F, -28.25F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.7985F, -12.5391F, 2.9491F));

		PartDefinition head = Kraken.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 422).addBox(-7.9167F, -1.7586F, -4.2567F, 15.0F, 9.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(520, 431).addBox(-5.8333F, -0.2586F, -12.5868F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -48.0F, -19.0F));

		PartDefinition teeth_r9 = head.addOrReplaceChild("teeth_r9", CubeListBuilder.create().texOffs(348, 220).addBox(-4.2546F, 3.776F, -8.1133F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(558, 387).addBox(-4.2546F, -4.224F, -8.1133F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7604F, 3.4147F, -4.059F, 1.0516F, 0.1067F, 2.6274F));

		PartDefinition HeadInnerLeft_r1 = head.addOrReplaceChild("HeadInnerLeft_r1", CubeListBuilder.create().texOffs(318, 555).addBox(-4.75F, -1.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5468F, -4.1586F, -4.6887F, 0.6781F, 1.4345F, 0.4574F));

		PartDefinition HeadOuterRight_r1 = head.addOrReplaceChild("HeadOuterRight_r1", CubeListBuilder.create().texOffs(520, 446).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.9167F, 3.2414F, -1.2567F, 0.0F, 0.5236F, 0.0F));

		PartDefinition HeadOuterRight_r2 = head.addOrReplaceChild("HeadOuterRight_r2", CubeListBuilder.create().texOffs(380, 520).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0833F, 3.2414F, -1.2567F, 0.0F, -0.5236F, 0.0F));

		PartDefinition bodyDetails = Kraken.addOrReplaceChild("bodyDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin = bodyDetails.addOrReplaceChild("fin", CubeListBuilder.create().texOffs(360, 363).addBox(0.0F, -26.0F, -14.0F, 0.0F, 26.0F, 33.0F, new CubeDeformation(0.0F))
		.texOffs(560, 578).addBox(-1.5773F, -22.25F, -15.7033F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(168, 506).addBox(-1.5773F, -34.25F, 40.2967F, 3.0F, 36.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(614, 633).addBox(-1.5773F, 50.75F, 12.2967F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -51.0F, -5.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r1 = fin.addOrReplaceChild("FinsupportFront_r1", CubeListBuilder.create().texOffs(496, 543).addBox(-1.25F, -29.0F, -2.0F, 3.0F, 30.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 0.75F, 1.2967F, -0.1745F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r2 = fin.addOrReplaceChild("FinsupportFront_r2", CubeListBuilder.create().texOffs(282, 634).addBox(-1.25F, 1.0F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 45.75F, -3.7033F, -0.3054F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r3 = fin.addOrReplaceChild("FinsupportFront_r3", CubeListBuilder.create().texOffs(270, 634).addBox(-1.25F, 1.0F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 41.75F, -20.7033F, -0.4363F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r4 = fin.addOrReplaceChild("FinsupportFront_r4", CubeListBuilder.create().texOffs(400, 439).addBox(-1.25F, 1.0F, -2.0F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 45.75F, 30.2967F, 0.0873F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r5 = fin.addOrReplaceChild("FinsupportFront_r5", CubeListBuilder.create().texOffs(160, 395).addBox(-1.25F, -2.0F, -2.0F, 3.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 41.75F, 47.2967F, 0.3054F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r6 = fin.addOrReplaceChild("FinsupportFront_r6", CubeListBuilder.create().texOffs(340, 520).addBox(-1.25F, -31.0F, -2.0F, 3.0F, 32.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, -1.25F, 54.2967F, -0.2182F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r7 = fin.addOrReplaceChild("FinsupportFront_r7", CubeListBuilder.create().texOffs(580, 33).addBox(-1.25F, -23.0F, -2.0F, 3.0F, 24.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3273F, 0.75F, 17.2967F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r29 = fin.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(288, 116).addBox(-0.15F, -33.0F, -18.0F, 0.0F, 25.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 68.0F, -11.75F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r30 = fin.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(96, 331).addBox(-0.25F, -35.0F, -18.0F, 0.0F, 27.0F, 37.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 69.0F, 33.25F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r31 = fin.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 280).addBox(-0.15F, -26.0F, -14.0F, 0.0F, 26.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -2.0F, 33.25F, 0.1745F, 0.0F, 0.0F));

		PartDefinition growth = bodyDetails.addOrReplaceChild("growth", CubeListBuilder.create(), PartPose.offset(0.0F, -55.0F, 0.0F));

		PartDefinition cube_r32 = growth.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(160, 0).addBox(-8.0F, -6.0F, -27.0F, 17.0F, 6.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -17.0F, 18.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r33 = growth.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(372, 91).addBox(-7.0F, -6.0F, -27.0F, 15.0F, 6.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition bodies = bodyDetails.addOrReplaceChild("bodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 700, 700);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float value = Mth.sin(ageInTicks/6)/6;
		float value1 = Mth.sin(ageInTicks/7)/6;
		float value2 = Mth.cos(ageInTicks/6)/7;
		float value3 = Mth.sin(ageInTicks/6)/8;
		float value4 = Mth.cos(ageInTicks/8)/6;
		float value5 = Mth.sin(ageInTicks/8)/7;
		float value6 = Mth.cos(ageInTicks/7)/6;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.animateTentacleX(jawTop,value);
		this.animateTentacleX(jawBottom,-value * 1.25f);
		this.animateTentacleX(rightJaw,value * 1.5f);
		this.animateTentacleX(leftJaw,value * 1.5f);
		animateTumor(LeftArmConnectPoint,value2);
		animateTumor(RightArmConnectPoint,value3);
		animateTumor(Tumor,value4);
		animateTumor(Tumor2,value5);
		animateTumor(Tumor3,-value6);
		animateTumor(Tumor4,value6);
		animateTumor(Tumor5,value1);
		animateTumor(Tumor6,value6);
		animateTumor(Tumor7,-value3);
		animateTumor(Tumor8,value6);
		animateTumor(Tumor9,-value4);
		animateTumor(Tumor10,value6);
		animateTumor(Tumor11,value5);
		animateTentacleZ(Hinge1,value);
		animateTentacleZ(Hinge2,value);
		animateTentacleZ(Hinge3,value);
		animateTentacleZ(Hinge4,value);
		animateTentacleZ(Hinge5,value);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Kraken.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}