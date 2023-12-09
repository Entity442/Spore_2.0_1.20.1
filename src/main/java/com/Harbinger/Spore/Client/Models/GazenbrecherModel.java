package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
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

public class GazenbrecherModel<T extends Gazenbrecher> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "gazen"), "main");
	private final ModelPart Gazenbreacher;
	private final ModelPart Segment2;
	private final ModelPart Segment3;
	private final ModelPart Segment4;
	private final ModelPart TopJaw;
	private final ModelPart RightJaw;
	private final ModelPart LeftJaw;
	private final ModelPart LeftLeg;
	private final ModelPart RightLeg;
	private final ModelPart SmolL1;
	private final ModelPart SmolL2;
	private final ModelPart SmolL3;
	private final ModelPart RightFin;
	private final ModelPart LeftFin;
	private final ModelPart BackRightFin;
	private final ModelPart BackLeftFin;
	private final ModelPart Tumors;
	private final ModelPart Licker1;
	private final ModelPart Licker2;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;

	public GazenbrecherModel(ModelPart root) {
		this.Gazenbreacher = root.getChild("Gazenbreacher");
		this.Segment2 = Gazenbreacher.getChild("FrontSeg1").getChild("CenterBaseGroup");
		this.Segment3 = Segment2.getChild("BackSeg1");
		this.Segment4 = Segment3.getChild("BackSeg2");

		this.TopJaw = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("Head").getChild("Jaw").getChild("TopJaw");
		this.RightJaw = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("Head").getChild("Jaw").getChild("RightJaw");
		this.LeftJaw = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("Head").getChild("Jaw").getChild("LeftJaw");

		this.LeftLeg = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("Limbs").getChild("LeftLimb");
		this.RightLeg = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("Limbs").getChild("RightLimb");
		this.SmolL1 = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("Limbs").getChild("Smoll1");
		this.SmolL2 = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("Limbs").getChild("Smoll2");
		this.SmolL3 = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("Limbs").getChild("Smoll3");

		this.LeftFin = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("FrontSeg2BaseGroup").getChild("BackSegFin").getChild("LeftFin");
		this.RightFin = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg1BaseGroup").getChild("FrontSeg1Fin").getChild("RightSidefin");

		this.BackRightFin = Segment4.getChild("BackSeg3").getChild("Tail").getChild("RightTail");
		this.BackLeftFin = Segment4.getChild("BackSeg3").getChild("Tail").getChild("LeftTail");

		this.Tumors = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("Head").getChild("Jaw").getChild("Licker").getChild("Tumors");
		this.Licker1 = Gazenbreacher.getChild("FrontSeg1").getChild("FrontSeg2").getChild("Head").getChild("Jaw").getChild("Licker").getChild("LickerSeg2");
		this.Licker2 = Licker1.getChild("LickerSeg3");
		this.Head = Licker2.getChild("ToungeHead");
		this.RightArm = Licker2.getChild("RightArm");
		this.LeftArm = Licker2.getChild("LeftArm");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gazenbreacher = partdefinition.addOrReplaceChild("Gazenbreacher", CubeListBuilder.create(), PartPose.offsetAndRotation(14.75F, -2.25F, 8.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition FrontSeg1 = Gazenbreacher.addOrReplaceChild("FrontSeg1", CubeListBuilder.create(), PartPose.offset(-15.0F, 0.0F, -16.0F));

		PartDefinition FrontSeg1BaseGroup = FrontSeg1.addOrReplaceChild("FrontSeg1BaseGroup", CubeListBuilder.create().texOffs(0, 66).addBox(-29.75F, -17.75F, -9.0F, 30.0F, 36.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, 4.0F, -10.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition LeftTopRidge_r1 = FrontSeg1BaseGroup.addOrReplaceChild("LeftTopRidge_r1", CubeListBuilder.create().texOffs(186, 207).addBox(-10.0F, -5.5F, -12.0F, 20.0F, 11.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.3524F, -17.348F, 6.49F, 0.0F, 0.0F, 2.7053F));

		PartDefinition RightTopRidge_r1 = FrontSeg1BaseGroup.addOrReplaceChild("RightTopRidge_r1", CubeListBuilder.create().texOffs(186, 207).addBox(-10.0F, -5.5F, -12.0F, 20.0F, 11.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0476F, -17.348F, 6.5F, 0.0F, 3.1416F, 0.4363F));

		PartDefinition LeftBottomBase_r1 = FrontSeg1BaseGroup.addOrReplaceChild("LeftBottomBase_r1", CubeListBuilder.create().texOffs(49, 209).addBox(-1.1022F, -0.2235F, -8.99F, 8.0F, 20.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-36.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftTopBase_r1 = FrontSeg1BaseGroup.addOrReplaceChild("LeftTopBase_r1", CubeListBuilder.create().texOffs(49, 209).addBox(-4.0F, -10.0F, -13.5F, 8.0F, 20.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.4294F, -8.1811F, 4.7907F, 0.0F, 3.1416F, 0.2618F));

		PartDefinition RightBottomBase_r1 = FrontSeg1BaseGroup.addOrReplaceChild("RightBottomBase_r1", CubeListBuilder.create().texOffs(0, 232).addBox(-4.0F, -10.0F, -13.5F, 8.0F, 20.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6706F, 8.6933F, 4.51F, 0.0F, 3.1416F, 0.2618F));

		PartDefinition RightTopBase_r1 = FrontSeg1BaseGroup.addOrReplaceChild("RightTopBase_r1", CubeListBuilder.create().texOffs(0, 232).addBox(-6.6509F, -19.6977F, -8.7093F, 8.0F, 20.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition FrontSeg1Connectors = FrontSeg1BaseGroup.addOrReplaceChild("FrontSeg1Connectors", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0F, -18.1366F, 16.1011F, -0.3054F, 0.0F, 0.0F));

		PartDefinition TopConnector_r1 = FrontSeg1Connectors.addOrReplaceChild("TopConnector_r1", CubeListBuilder.create().texOffs(180, 192).addBox(-11.5F, -1.3992F, -8.0443F, 23.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 2.5188F, 5.5367F, -0.6545F, 0.0F, 0.0F));

		PartDefinition FrontSeg1Fin = FrontSeg1BaseGroup.addOrReplaceChild("FrontSeg1Fin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TopFin = FrontSeg1Fin.addOrReplaceChild("TopFin", CubeListBuilder.create().texOffs(282, 221).addBox(-2.0F, -0.5F, -16.5F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.75F, -37.5F, 20.5F));

		PartDefinition finMemebrane3_r1 = TopFin.addOrReplaceChild("finMemebrane3_r1", CubeListBuilder.create().texOffs(162, 68).addBox(-0.01F, -9.5F, -15.5F, 0.0F, 30.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition TopFinBody = TopFin.addOrReplaceChild("TopFinBody", CubeListBuilder.create().texOffs(269, 9).addBox(-16.75F, -44.0F, 2.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 66).addBox(-17.25F, -50.0F, 2.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(14.75F, 37.5F, -20.5F));

		PartDefinition TFHead = TopFinBody.addOrReplaceChild("TFHead", CubeListBuilder.create().texOffs(374, 244).addBox(-2.0F, -7.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.75F, -49.5F, 6.0F, 0.2618F, 0.0F, 0.3054F));

		PartDefinition TFJaw = TFHead.addOrReplaceChild("TFJaw", CubeListBuilder.create().texOffs(259, 0).addBox(-1.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.2533F, -0.067F, 0.2969F));

		PartDefinition NLimb = TopFinBody.addOrReplaceChild("NLimb", CubeListBuilder.create(), PartPose.offset(-13.75F, -47.4396F, 1.6442F));

		PartDefinition NLimb_r1 = NLimb.addOrReplaceChild("NLimb_r1", CubeListBuilder.create().texOffs(17, 0).addBox(-1.5F, -1.0F, -2.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.4396F, -0.1442F, -0.3054F, 0.0F, 0.0F));

		PartDefinition SLimb = TopFinBody.addOrReplaceChild("SLimb", CubeListBuilder.create(), PartPose.offset(-15.3835F, -48.7593F, 9.7525F));

		PartDefinition SLimb_r1 = SLimb.addOrReplaceChild("SLimb_r1", CubeListBuilder.create().texOffs(336, 339).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3665F, 0.2593F, 0.7475F, 0.1309F, 0.0F, 0.3491F));

		PartDefinition RightSidefin = FrontSeg1Fin.addOrReplaceChild("RightSidefin", CubeListBuilder.create(), PartPose.offset(6.0F, -8.0F, 8.0F));

		PartDefinition RFinmemebrane_r1 = RightSidefin.addOrReplaceChild("RFinmemebrane_r1", CubeListBuilder.create().texOffs(162, 275).addBox(-19.6851F, -23.7192F, 0.8549F, 37.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.4296F, 0.625F, 1.3428F));

		PartDefinition RfinBottom_r1 = RightSidefin.addOrReplaceChild("RfinBottom_r1", CubeListBuilder.create().texOffs(284, 117).addBox(1.3149F, -23.7192F, -0.1451F, 2.0F, 23.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.1958F, 0.7203F, 2.2992F));

		PartDefinition RfinTop_r1 = RightSidefin.addOrReplaceChild("RfinTop_r1", CubeListBuilder.create().texOffs(276, 114).addBox(-1.0F, -28.0F, -0.25F, 2.0F, 29.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.7298F, 0.1468F, 0.5984F));

		PartDefinition FrontSeg1CorpseDetails = FrontSeg1BaseGroup.addOrReplaceChild("FrontSeg1CorpseDetails", CubeListBuilder.create(), PartPose.offset(-2.0F, -19.0F, 8.0F));

		PartDefinition FS1Body1 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body1", CubeListBuilder.create(), PartPose.offset(3.06F, -0.4055F, -5.1262F));

		PartDefinition Leg_r1 = FS1Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(114, 381).addBox(-1.1032F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1597F, 0.7638F, 0.5852F));

		PartDefinition Arm_r1 = FS1Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(337, 299).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2366F, -5.5182F, 2.8999F, 0.0232F, 0.8265F, 0.2967F));

		PartDefinition Arm_r2 = FS1Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(337, 299).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -2.9185F, 12.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r1 = FS1Body1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(203, 429).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r1 = FS1Body1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(403, 29).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(363, 224).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = FS1Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(296, 245).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition FS1Body2 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body2", CubeListBuilder.create(), PartPose.offset(9.0F, 22.0F, 0.0F));

		PartDefinition Leg_r2 = FS1Body2.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(343, 162).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4096F, -3.5211F, 3.0704F, 0.2978F, -0.1848F, 0.5394F));

		PartDefinition Leg_r3 = FS1Body2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(237, 406).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5286F, -3.3013F, -1.75F, -0.211F, 0.056F, 0.2559F));

		PartDefinition Arm_r3 = FS1Body2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(329, 22).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r1 = FS1Body2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(90, 381).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.167F, -16.9397F, -2.5094F, -1.8953F, -1.1912F, 2.0859F));

		PartDefinition TorsoTop_r2 = FS1Body2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(250, 209).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r2 = FS1Body2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(284, 448).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition FS1Body3 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(7.3288F, 27.3876F, 0.8238F, 2.5732F, -1.1572F, 0.0281F));

		PartDefinition Leg_r4 = FS1Body3.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(321, 410).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r3 = FS1Body3.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(434, 71).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r4 = FS1Body3.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(412, 287).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r5 = FS1Body3.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(97, 419).addBox(-1.9496F, -0.9033F, -7.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoTop_r3 = FS1Body3.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(385, 419).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = FS1Body3.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(223, 391).addBox(-3.7022F, -0.41F, -3.6522F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.13F, -4.0992F, -2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition FS1Body4 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body4", CubeListBuilder.create().texOffs(386, 419).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.75F, -3.0F, 1.0F, -1.8012F, -1.223F, 1.5377F));

		PartDefinition Leg_r5 = FS1Body4.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(359, 346).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r3 = FS1Body4.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(245, 376).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r6 = FS1Body4.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(411, 286).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r4 = FS1Body4.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(182, 424).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition FS1Body5 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.75F, -3.0F, 11.0F, -1.8012F, -1.223F, 1.5377F));

		PartDefinition TorsoBase_r4 = FS1Body5.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(410, 184).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8836F, 8.6026F, 3.8552F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r5 = FS1Body5.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(250, 217).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1991F, 4.1416F, 6.3927F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r6 = FS1Body5.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(398, 310).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(362, 224).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition FS1Body6 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.75F, 6.6707F, 3.3576F, 1.5904F, 1.1755F, -2.4139F));

		PartDefinition Leg_r6 = FS1Body6.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(120, 410).addBox(-2.664F, -1.8936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -2.5592F, 4.5018F, 0.8843F, 0.9235F, -0.0354F));

		PartDefinition TorsoBase_r5 = FS1Body6.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(392, 441).addBox(-3.0F, -4.0F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -0.1988F, 4.3066F, 0.4485F, 0.4285F, -0.1972F));

		PartDefinition Arm_r7 = FS1Body6.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(262, 445).addBox(-1.919F, -1.1697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, -2.3868F, 0.3569F, -1.7879F));

		PartDefinition Arm_r8 = FS1Body6.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(284, 74).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r1 = FS1Body6.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(182, 424).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition FS1Body7 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(-36.75F, 18.8293F, 1.3576F, -2.5273F, -0.2143F, 1.6131F));

		PartDefinition Leg_r7 = FS1Body7.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(0, 410).addBox(-2.664F, -8.6064F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.234F, -0.5178F, -1.4767F));

		PartDefinition Leg_r8 = FS1Body7.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(0, 410).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.4744F, -0.2937F, -1.281F));

		PartDefinition TorsoBase_r6 = FS1Body7.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(430, 183).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r9 = FS1Body7.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(0, 445).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r10 = FS1Body7.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(97, 419).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r7 = FS1Body7.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(418, 304).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r4 = FS1Body7.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(389, 78).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition FS1Body8 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body8", CubeListBuilder.create(), PartPose.offsetAndRotation(-33.75F, 31.8293F, 1.3576F, 0.259F, -0.1579F, -1.7716F));

		PartDefinition Arm_r11 = FS1Body8.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(436, 444).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.6609F, -0.5587F, 1.5066F));

		PartDefinition TorsoBase_r7 = FS1Body8.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(284, 439).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.4741F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r8 = FS1Body8.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(418, 118).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r5 = FS1Body8.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(359, 330).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition FS1Body9 = FrontSeg1CorpseDetails.addOrReplaceChild("FS1Body9", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.7294F, 37.6545F, -4.0355F, -0.2268F, -0.6194F, 0.3783F));

		PartDefinition Leg_r9 = FS1Body9.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(284, 90).addBox(-1.1032F, -2.2452F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, -2.2911F, -5.6196F, 0.1372F, 0.7673F, -0.1601F));

		PartDefinition Arm_r12 = FS1Body9.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(284, 90).addBox(-0.5219F, -2.5629F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, 3.2271F, -2.7196F, -0.0232F, 0.8265F, -0.2967F));

		PartDefinition Arm_r13 = FS1Body9.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(307, 12).addBox(-0.6481F, -1.6532F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, 0.6274F, 6.7458F, -0.0163F, -0.2642F, -0.2753F));

		PartDefinition TorsoBase_r8 = FS1Body9.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(425, 346).addBox(-3.25F, -2.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, -1.0111F, -1.8956F, -0.1286F, 0.4614F, -0.5318F));

		PartDefinition TorsoBottom_r2 = FS1Body9.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(237, 347).addBox(-6.0F, -0.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(385, 54).addBox(-14.0F, -2.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, -1.6966F, -0.4934F, -0.0177F, 0.4775F, -0.2877F));

		PartDefinition Jaw_r2 = FS1Body9.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(90, 0).addBox(-0.752F, -3.0389F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, 0.3831F, 2.47F, -0.1692F, 0.2135F, -0.7249F));

		PartDefinition FrontSeg2 = FrontSeg1.addOrReplaceChild("FrontSeg2", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -21.0F));

		PartDefinition FrontSeg2BaseGroup = FrontSeg2.addOrReplaceChild("FrontSeg2BaseGroup", CubeListBuilder.create().texOffs(0, 0).addBox(-29.75F, -17.75F, -9.0F, 30.0F, 36.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offset(15.0F, 4.0F, -10.0F));

		PartDefinition LeftTopRidge_r2 = FrontSeg2BaseGroup.addOrReplaceChild("LeftTopRidge_r2", CubeListBuilder.create().texOffs(156, 0).addBox(-9.75F, -3.5F, -11.51F, 21.0F, 12.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.5F, -19.75F, 3.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition RightTopRidge_r2 = FrontSeg2BaseGroup.addOrReplaceChild("RightTopRidge_r2", CubeListBuilder.create().texOffs(156, 0).addBox(-11.25F, -3.5F, -11.5F, 21.0F, 12.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -19.75F, 3.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LeftBottomBase_r2 = FrontSeg2BaseGroup.addOrReplaceChild("LeftBottomBase_r2", CubeListBuilder.create().texOffs(134, 181).addBox(-4.0F, -10.0F, -15.0F, 8.0F, 20.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.6329F, 8.9603F, 6.01F, 0.0F, 0.0F, 2.9322F));

		PartDefinition LeftTopBase_r2 = FrontSeg2BaseGroup.addOrReplaceChild("LeftTopBase_r2", CubeListBuilder.create().texOffs(134, 181).addBox(-1.3491F, -19.6977F, -8.7093F, 8.0F, 20.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-36.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition RightBottomBase_r2 = FrontSeg2BaseGroup.addOrReplaceChild("RightBottomBase_r2", CubeListBuilder.create().texOffs(0, 182).addBox(-6.8978F, -0.2235F, -8.99F, 8.0F, 20.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2094F));

		PartDefinition RightTopBase_r2 = FrontSeg2BaseGroup.addOrReplaceChild("RightTopBase_r2", CubeListBuilder.create().texOffs(0, 182).addBox(-6.6509F, -19.6977F, -8.7093F, 8.0F, 20.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.2094F));

		PartDefinition Limbs = FrontSeg2BaseGroup.addOrReplaceChild("Limbs", CubeListBuilder.create(), PartPose.offset(-15.0F, -4.0F, 10.0F));

		PartDefinition RightLimb = Limbs.addOrReplaceChild("RightLimb", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3538F, -3.5765F, 2.7663F, -0.2733F, -0.1448F, -2.0134F));

		PartDefinition RLimbSeg1_r1 = RightLimb.addOrReplaceChild("RLimbSeg1_r1", CubeListBuilder.create().texOffs(0, 279).addBox(-1.0336F, -21.3458F, 0.5055F, 12.0F, 32.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.3792F, 8.223F, -12.9767F, -0.3781F, 0.1031F, 0.6381F));

		PartDefinition CalciumCorpse = RightLimb.addOrReplaceChild("CalciumCorpse", CubeListBuilder.create(), PartPose.offset(-13.1401F, 16.856F, -2.485F));

		PartDefinition Jaw_r3 = CalciumCorpse.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(300, 163).addBox(-0.4113F, -4.4425F, -2.3292F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6781F, -7.4791F, 5.4635F, -0.2245F, -0.519F, -0.7629F));

		PartDefinition HeadBase_r1 = CalciumCorpse.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(386, 216).addBox(-2.0F, -3.0F, -3.5F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6413F, -10.0375F, 7.6279F, -0.2283F, 0.2127F, -0.8899F));

		PartDefinition TorsoBottom_r3 = CalciumCorpse.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(165, 231).addBox(-1.75F, -3.5F, -3.5F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(89, 443).addBox(4.25F, -4.0F, -4.0F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, -0.2231F, -0.6768F, -0.8409F));

		PartDefinition Arm2_r1 = CalciumCorpse.addOrReplaceChild("Arm2_r1", CubeListBuilder.create().texOffs(284, 351).addBox(-7.3902F, -0.6987F, -1.5699F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0341F, -8.8319F, 4.3578F, 0.0F, -1.3963F, 0.0F));

		PartDefinition Arm1_r1 = CalciumCorpse.addOrReplaceChild("Arm1_r1", CubeListBuilder.create().texOffs(284, 351).addBox(-7.2686F, -0.636F, -2.0922F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0019F, -4.5889F, 4.534F, 0.1874F, 0.3065F, 0.0667F));

		PartDefinition RLimbSeg2 = RightLimb.addOrReplaceChild("RLimbSeg2", CubeListBuilder.create().texOffs(365, 371).addBox(-0.6223F, 2.9159F, -10.3419F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.3295F, 15.39F, -8.6426F, 0.0F, 0.0F, 0.9163F));

		PartDefinition Limb_r1 = RLimbSeg2.addOrReplaceChild("Limb_r1", CubeListBuilder.create().texOffs(138, 303).addBox(-1.9985F, -0.926F, -1.7191F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3987F, 12.7672F, -4.9586F, -0.6167F, 0.2351F, 0.3175F));

		PartDefinition RLimbSeg2_r1 = RLimbSeg2.addOrReplaceChild("RLimbSeg2_r1", CubeListBuilder.create().texOffs(337, 356).addBox(-0.6864F, 3.2257F, -1.8553F, 9.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0036F, 1.5F, 3.0F, -0.9228F, 0.6321F, -0.0845F));

		PartDefinition RLimbSeg2Seg2 = RLimbSeg2.addOrReplaceChild("RLimbSeg2Seg2", CubeListBuilder.create(), PartPose.offset(-2.9792F, 14.1075F, -9.1736F));

		PartDefinition RLimbSeg2Seg2_r1 = RLimbSeg2Seg2.addOrReplaceChild("RLimbSeg2Seg2_r1", CubeListBuilder.create().texOffs(0, 182).addBox(0.3136F, 17.2257F, -0.8553F, 7.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0245F, -12.6075F, 12.1736F, -0.9228F, 0.6321F, -0.0845F));

		PartDefinition RLimbSeg3 = RLimbSeg2Seg2.addOrReplaceChild("RLimbSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.4704F, 8.301F, -7.6848F, 0.0322F, -0.4573F, 0.1627F));

		PartDefinition Arm_r14 = RLimbSeg3.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(307, 0).addBox(-2.1777F, -0.2936F, -1.9698F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5581F, 5.6904F, -0.9F, 0.0F, 0.0F, 0.1309F));

		PartDefinition RLimbSeg3Torso_r1 = RLimbSeg3.addOrReplaceChild("RLimbSeg3Torso_r1", CubeListBuilder.create().texOffs(342, 94).addBox(1.3961F, -9.0599F, -3.5049F, 7.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.74F, 2.2474F, 0.6179F, 0.0F, 0.0F, 0.829F));

		PartDefinition RLimbHeadJoint = RLimbSeg3.addOrReplaceChild("RLimbHeadJoint", CubeListBuilder.create().texOffs(382, 154).addBox(-4.0727F, -3.464F, -7.9992F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7698F, 6.2004F, -1.9173F, 0.3491F, 0.0F, 0.829F));

		PartDefinition FleshDetailJoint = RLimbHeadJoint.addOrReplaceChild("FleshDetailJoint", CubeListBuilder.create().texOffs(348, 269).addBox(-3.9252F, 0.0094F, 0.0258F, 8.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1882F, 3.6072F, -6.9613F));

		PartDefinition LeftLimb = Limbs.addOrReplaceChild("LeftLimb", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.3342F, 5.7001F, 7.6536F, -0.2733F, 0.1448F, 2.0134F));

		PartDefinition LLimbSeg1_r1 = LeftLimb.addOrReplaceChild("LLimbSeg1_r1", CubeListBuilder.create().texOffs(36, 321).addBox(-10.9664F, -21.3458F, 0.5055F, 12.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9039F, 9.8807F, -13.3639F, -0.3781F, -0.1031F, -0.6381F));

		PartDefinition LLimbSeg2 = LeftLimb.addOrReplaceChild("LLimbSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(9.9803F, 13.3007F, -7.1461F, 0.0F, 0.0F, -0.9163F));

		PartDefinition Head_r6 = LLimbSeg2.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(66, 371).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6858F, 2.7248F, -6.2636F, 0.0F, -0.1745F, -0.6109F));

		PartDefinition LLimbSeg2_r1 = LLimbSeg2.addOrReplaceChild("LLimbSeg2_r1", CubeListBuilder.create().texOffs(301, 351).addBox(-8.3136F, 3.2257F, -1.8553F, 9.0F, 20.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3179F, -3.7752F, 3.7364F, -0.9228F, -0.6321F, 0.0845F));

		PartDefinition LLimbSeg3 = LLimbSeg2.addOrReplaceChild("LLimbSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(9.1415F, 11.5972F, -12.7934F, 0.0322F, 0.4573F, -0.1627F));

		PartDefinition LLimbSeg3Torso2Seg2_r1 = LLimbSeg3.addOrReplaceChild("LLimbSeg3Torso2Seg2_r1", CubeListBuilder.create().texOffs(424, 252).addBox(-2.6421F, 4.43F, -2.6092F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(37, 455).addBox(-2.1421F, -1.57F, -2.1092F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7874F, 0.1064F, -1.2103F, 0.0F, 0.6109F, -1.0472F));

		PartDefinition Head1_r1 = LLimbSeg3.addOrReplaceChild("Head1_r1", CubeListBuilder.create().texOffs(161, 384).addBox(-8.7087F, -7.327F, -2.7458F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Torso1Arm_r1 = LLimbSeg3.addOrReplaceChild("Torso1Arm_r1", CubeListBuilder.create().texOffs(350, 0).addBox(-1.2087F, -1.327F, -3.2456F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -3.2103F, 0.3491F, 0.0F, -0.48F));

		PartDefinition LLimbSeg3Torso1_r1 = LLimbSeg3.addOrReplaceChild("LLimbSeg3Torso1_r1", CubeListBuilder.create().texOffs(0, 232).addBox(-1.7087F, -1.327F, -2.2558F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, 0.0F, 0.0F, -0.8727F));

		PartDefinition patty = LLimbSeg3.addOrReplaceChild("patty", CubeListBuilder.create(), PartPose.offset(2.7348F, 6.5929F, 0.2866F));

		PartDefinition LLimbSeg3Torso1Seg2_r1 = patty.addOrReplaceChild("LLimbSeg3Torso1Seg2_r1", CubeListBuilder.create().texOffs(250, 196).addBox(-3.0F, -5.0F, -4.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1387F, 3.1F, 0.2574F, 0.3491F, 0.0F, -0.8727F));

		PartDefinition LLimbJawJoint = LLimbSeg3.addOrReplaceChild("LLimbJawJoint", CubeListBuilder.create().texOffs(138, 323).addBox(-8.7087F, -0.327F, -2.2456F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, -0.2598F, 0.0506F, -0.8034F));

		PartDefinition CalciumCorpseLLimb = LeftLimb.addOrReplaceChild("CalciumCorpseLLimb", CubeListBuilder.create(), PartPose.offset(5.7924F, 12.712F, -0.1819F));

		PartDefinition Head_r7 = CalciumCorpseLLimb.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(371, 135).addBox(-4.0F, -4.5F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5057F, 5.7465F, 1.818F, 0.4331F, -0.0552F, 2.9113F));

		PartDefinition Arm_r15 = CalciumCorpseLLimb.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(199, 323).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4798F, 1.904F, -2.682F, 0.6429F, -0.1321F, 2.9666F));

		PartDefinition TorsoBottom_r4 = CalciumCorpseLLimb.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(276, 196).addBox(-3.5F, 3.0F, -1.75F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(262, 424).addBox(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1115F, -0.8313F, 1.318F, 0.0F, 0.0F, 2.7925F));

		PartDefinition Smoll1 = Limbs.addOrReplaceChild("Smoll1", CubeListBuilder.create().texOffs(193, 384).addBox(-2.7496F, -1.6358F, -5.9341F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.501F, 19.5F, -20.0F, 0.7217F, 0.5129F, 0.1525F));

		PartDefinition Jaw_r4 = Smoll1.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(106, 303).addBox(-4.0F, -0.5F, -7.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, 3.0F, 0.3478F, -0.0298F, 0.082F));

		PartDefinition Head_r8 = Smoll1.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(386, 0).addBox(-4.0F, -4.5F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 4.0F, -0.5603F, -0.0934F, -0.1476F));

		PartDefinition Smoll1Seg2 = Smoll1.addOrReplaceChild("Smoll1Seg2", CubeListBuilder.create().texOffs(117, 434).addBox(-2.0F, -1.6308F, -6.8042F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2496F, 0.6905F, -5.8141F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Smoll2 = Limbs.addOrReplaceChild("Smoll2", CubeListBuilder.create().texOffs(199, 325).addBox(-2.0F, -1.9896F, -11.5976F, 4.0F, 4.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.499F, 17.5F, -21.0F, 0.4195F, -0.278F, -0.0166F));

		PartDefinition Smoll2Seg2 = Smoll2.addOrReplaceChild("Smoll2Seg2", CubeListBuilder.create().texOffs(174, 434).addBox(-1.4987F, -1.2996F, -8.2264F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2396F, -11.0976F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Smoll3 = Limbs.addOrReplaceChild("Smoll3", CubeListBuilder.create().texOffs(225, 0).addBox(-2.0F, -3.9896F, -3.5976F, 11.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(18.499F, 17.5F, -16.0F, 0.0F, 0.3927F, 0.5672F));

		PartDefinition Smoll3Seg2 = Smoll3.addOrReplaceChild("Smoll3Seg2", CubeListBuilder.create(), PartPose.offset(8.2513F, -0.8654F, -0.704F));

		PartDefinition Smoll3Seg3_r1 = Smoll3Seg2.addOrReplaceChild("Smoll3Seg3_r1", CubeListBuilder.create().texOffs(0, 204).addBox(-1.75F, -2.0F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition BackSegFin = FrontSeg2BaseGroup.addOrReplaceChild("BackSegFin", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.75F, -26.5F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition TopFinBackSeg = BackSegFin.addOrReplaceChild("TopFinBackSeg", CubeListBuilder.create().texOffs(218, 299).addBox(-2.0F, -20.0F, -1.0F, 4.0F, 20.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(226, 38).addBox(0.0F, -23.0F, -3.0F, 0.0F, 25.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftFin = BackSegFin.addOrReplaceChild("LeftFin", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0F, 14.0F, 2.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition LFinWingMemebrane_r1 = LeftFin.addOrReplaceChild("LFinWingMemebrane_r1", CubeListBuilder.create().texOffs(154, 299).addBox(-15.0F, -23.0F, -0.01F, 32.0F, 24.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.2217F));

		PartDefinition LFinBottomSeg_r1 = LeftFin.addOrReplaceChild("LFinBottomSeg_r1", CubeListBuilder.create().texOffs(218, 96).addBox(-1.0F, -23.0F, -1.01F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.8762F));

		PartDefinition LFinTopSeg_r1 = LeftFin.addOrReplaceChild("LFinTopSeg_r1", CubeListBuilder.create().texOffs(236, 275).addBox(-1.0F, -23.0F, -1.0F, 2.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition FrontSeg2CorpseDetails = FrontSeg2BaseGroup.addOrReplaceChild("FrontSeg2CorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(-27.5F, -21.0F, 7.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition FS2Body1 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0928F, -3.4105F, -0.1462F, 0.6485F, 0.3189F, 0.2333F));

		PartDefinition Leg_r10 = FS2Body1.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(309, 380).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.5852F));

		PartDefinition Arm_r16 = FS2Body1.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(284, 90).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r17 = FS2Body1.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(287, 90).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r9 = FS2Body1.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(203, 429).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r9 = FS2Body1.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(303, 402).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(385, 110).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r5 = FS2Body1.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(90, 0).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition FS2Body2 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body2", CubeListBuilder.create(), PartPose.offset(-9.0F, 22.0F, 0.0F));

		PartDefinition Leg_r11 = FS2Body2.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(329, 22).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4096F, -3.5211F, -3.0704F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r12 = FS2Body2.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(343, 162).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5286F, -3.3013F, 1.75F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r18 = FS2Body2.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(88, 359).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, -3.5737F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r9 = FS2Body2.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(359, 330).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.167F, -16.9397F, 2.5094F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r10 = FS2Body2.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(250, 209).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition TorsoBase_r10 = FS2Body2.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(252, 378).addBox(-2.5F, -4.0F, -3.25F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition FS2Body3 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3288F, -0.8876F, 1.1762F, -2.7937F, -1.1572F, 0.0281F));

		PartDefinition Leg_r13 = FS2Body3.addOrReplaceChild("Leg_r13", CubeListBuilder.create().texOffs(120, 410).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r11 = FS2Body3.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(423, 229).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r19 = FS2Body3.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(0, 445).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r20 = FS2Body3.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(444, 339).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r5 = FS2Body3.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(182, 424).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r10 = FS2Body3.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(388, 280).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition FS2Body4 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body4", CubeListBuilder.create().texOffs(93, 420).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.75F, -3.0F, -1.0F, 1.8012F, -1.223F, -1.5377F));

		PartDefinition Leg_r14 = FS2Body4.addOrReplaceChild("Leg_r14", CubeListBuilder.create().texOffs(237, 359).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r11 = FS2Body4.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(359, 330).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r21 = FS2Body4.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(121, 411).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r11 = FS2Body4.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(418, 0).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition FS2Body5 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(19.6375F, 2.5832F, -13.3672F, 0.1109F, -0.2664F, 0.9212F));

		PartDefinition TorsoBase_r12 = FS2Body5.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(102, 409).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r12 = FS2Body5.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(337, 299).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r13 = FS2Body5.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(398, 310).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r12 = FS2Body5.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(164, 345).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition FS2Body6 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body6", CubeListBuilder.create(), PartPose.offsetAndRotation(33.75F, 6.6707F, -3.3576F, -1.5904F, 1.1755F, 2.4139F));

		PartDefinition Leg_r15 = FS2Body6.addOrReplaceChild("Leg_r15", CubeListBuilder.create().texOffs(410, 285).addBox(-0.336F, -1.8936F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, -2.5592F, -4.5018F, -0.8843F, 0.9235F, 0.0354F));

		PartDefinition TorsoBase_r13 = FS2Body6.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(392, 441).addBox(-4.0F, -4.0F, -2.75F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, -0.1988F, -4.3066F, -0.4485F, 0.4285F, 0.1972F));

		PartDefinition Arm_r22 = FS2Body6.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(342, 444).addBox(-1.081F, -1.1697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r23 = FS2Body6.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(253, 213).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4172F, 4.1598F, -0.8274F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r6 = FS2Body6.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(415, 195).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition FS2Body7 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(36.75F, 18.8293F, -1.3576F, 2.5273F, -0.2143F, -1.6131F));

		PartDefinition Leg_r16 = FS2Body7.addOrReplaceChild("Leg_r16", CubeListBuilder.create().texOffs(407, 105).addBox(-0.336F, -8.6064F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, 4.5592F, -3.5018F, 0.234F, -0.5178F, 1.4767F));

		PartDefinition Leg_r17 = FS2Body7.addOrReplaceChild("Leg_r17", CubeListBuilder.create().texOffs(408, 206).addBox(-0.336F, 0.3936F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, 4.5592F, -3.5018F, 1.4744F, -0.2937F, 1.281F));

		PartDefinition TorsoBase_r14 = FS2Body7.addOrReplaceChild("TorsoBase_r14", CubeListBuilder.create().texOffs(386, 419).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r24 = FS2Body7.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(444, 339).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r25 = FS2Body7.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(409, 107).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r14 = FS2Body7.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(421, 51).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r13 = FS2Body7.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(354, 387).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition FS2Body8 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body8", CubeListBuilder.create(), PartPose.offsetAndRotation(33.75F, 26.8293F, 9.6424F, -0.259F, -0.1579F, 1.7716F));

		PartDefinition Arm_r26 = FS2Body8.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(444, 319).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 1.6609F, -0.5587F, -1.5066F));

		PartDefinition TorsoBase_r15 = FS2Body8.addOrReplaceChild("TorsoBase_r15", CubeListBuilder.create().texOffs(430, 183).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.4741F, 0.461F, -0.0476F));

		PartDefinition TorsoTop_r15 = FS2Body8.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(385, 419).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r14 = FS2Body8.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(328, 244).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition FS2Body9 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body9", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.25F, 4.8293F, 9.3576F, -2.669F, -1.3022F, 1.7271F));

		PartDefinition Leg_r18 = FS2Body9.addOrReplaceChild("Leg_r18", CubeListBuilder.create().texOffs(400, 406).addBox(-2.664F, -8.6064F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.234F, -0.5178F, -1.4767F));

		PartDefinition Leg_r19 = FS2Body9.addOrReplaceChild("Leg_r19", CubeListBuilder.create().texOffs(0, 410).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.4744F, -0.2937F, -1.281F));

		PartDefinition TorsoBase_r16 = FS2Body9.addOrReplaceChild("TorsoBase_r16", CubeListBuilder.create().texOffs(264, 436).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r27 = FS2Body9.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(410, 208).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r28 = FS2Body9.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(262, 445).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r16 = FS2Body9.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(421, 229).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r15 = FS2Body9.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(354, 387).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition FS2Body10 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body10", CubeListBuilder.create(), PartPose.offsetAndRotation(32.8288F, 17.3876F, 21.8238F, -2.5309F, -0.7515F, -0.9886F));

		PartDefinition Leg_r20 = FS2Body10.addOrReplaceChild("Leg_r20", CubeListBuilder.create().texOffs(120, 410).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r17 = FS2Body10.addOrReplaceChild("TorsoBase_r17", CubeListBuilder.create().texOffs(386, 419).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r29 = FS2Body10.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(97, 419).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r30 = FS2Body10.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(446, 166).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.9353F, 0.8543F, -0.1475F));

		PartDefinition TorsoTop_r17 = FS2Body10.addOrReplaceChild("TorsoTop_r17", CubeListBuilder.create().texOffs(415, 195).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition FS2Body11 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(4.75F, 1.0545F, -11.2449F, 1.8305F, -0.9271F, -1.474F));

		PartDefinition Leg_r21 = FS2Body11.addOrReplaceChild("Leg_r21", CubeListBuilder.create().texOffs(136, 90).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r18 = FS2Body11.addOrReplaceChild("TorsoBase_r18", CubeListBuilder.create().texOffs(348, 435).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r31 = FS2Body11.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(409, 107).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r18 = FS2Body11.addOrReplaceChild("TorsoTop_r18", CubeListBuilder.create().texOffs(289, 414).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition FS2Body12 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body12", CubeListBuilder.create(), PartPose.offsetAndRotation(19.6375F, 32.2278F, 24.4909F, 1.2471F, -0.2815F, -1.1018F));

		PartDefinition TorsoBase_r19 = FS2Body12.addOrReplaceChild("TorsoBase_r19", CubeListBuilder.create().texOffs(21, 358).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.274F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r7 = FS2Body12.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(284, 90).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r8 = FS2Body12.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(275, 398).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r16 = FS2Body12.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(46, 182).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition FS2Body13 = FrontSeg2CorpseDetails.addOrReplaceChild("FS2Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(4.75F, 34.9055F, 17.948F, 1.7785F, -0.446F, -3.1412F));

		PartDefinition Leg_r22 = FS2Body13.addOrReplaceChild("Leg_r22", CubeListBuilder.create().texOffs(407, 105).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r20 = FS2Body13.addOrReplaceChild("TorsoBase_r20", CubeListBuilder.create().texOffs(386, 419).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7363F, 2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r32 = FS2Body13.addOrReplaceChild("Arm_r32", CubeListBuilder.create().texOffs(262, 445).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r9 = FS2Body13.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(415, 195).addBox(-3.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition Head = FrontSeg2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(162, 242).addBox(-18.0F, -11.0F, -23.0F, 37.0F, 29.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.5F, -13.0F, -34.5F));

		PartDefinition TopJaw = Jaw.addOrReplaceChild("TopJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 14.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition BackBase = TopJaw.addOrReplaceChild("BackBase", CubeListBuilder.create().texOffs(90, 0).addBox(-1.5F, -12.0F, -3.5F, 19.0F, 7.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, 5.0F, -14.0F));

		PartDefinition topJawLeft_r1 = BackBase.addOrReplaceChild("topJawLeft_r1", CubeListBuilder.create().texOffs(271, 282).addBox(-7.0F, -3.0F, -9.5F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1915F, -5.513F, 5.99F, 0.0F, 3.1416F, -0.4363F));

		PartDefinition topJawRight_r1 = BackBase.addOrReplaceChild("topJawRight_r1", CubeListBuilder.create().texOffs(271, 282).addBox(-8.25F, -8.5F, -3.51F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition LeftTopRidge_r3 = BackBase.addOrReplaceChild("LeftTopRidge_r3", CubeListBuilder.create().texOffs(282, 221).addBox(-13.8566F, -8.9641F, -9.005F, 18.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, -9.8012F, 12.995F, 0.6931F, 0.2895F, -0.3311F));

		PartDefinition RightTopRidge_r3 = BackBase.addOrReplaceChild("RightTopRidge_r3", CubeListBuilder.create().texOffs(282, 221).addBox(-4.1434F, -8.9641F, -8.995F, 18.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, -9.8012F, 12.995F, 0.6931F, -0.2895F, 0.3311F));

		PartDefinition BackBaseCorpseDetails = BackBase.addOrReplaceChild("BackBaseCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, -15.0F, 8.0F));

		PartDefinition BBBody1 = BackBaseCorpseDetails.addOrReplaceChild("BBBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r21 = BBBody1.addOrReplaceChild("TorsoBase_r21", CubeListBuilder.create().texOffs(426, 281).addBox(-9.761F, -0.3912F, -3.9958F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(402, 93).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6977F, 0.1321F, -0.6429F));

		PartDefinition Jaw_r6 = BBBody1.addOrReplaceChild("Jaw_r6", CubeListBuilder.create().texOffs(330, 141).addBox(0.0412F, -4.0001F, -1.4988F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.85F, -2.3F, 1.4305F, -0.0998F, 0.3135F));

		PartDefinition Head_r17 = BBBody1.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(57, 387).addBox(0.0412F, -4.0001F, -0.4988F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -2.85F, -2.3F, 0.6014F, -0.0998F, 0.3135F));

		PartDefinition BBBody2 = BackBaseCorpseDetails.addOrReplaceChild("BBBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, 0.6887F, 1.8421F, 0.2805F, 0.0928F, 1.6299F));

		PartDefinition Arm_r33 = BBBody2.addOrReplaceChild("Arm_r33", CubeListBuilder.create().texOffs(370, 110).addBox(-7.0379F, -1.9918F, -0.722F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8245F, -2.6276F, 4.2411F, 0.4494F, 0.3479F, -0.6066F));

		PartDefinition TorsoBase_r22 = BBBody2.addOrReplaceChild("TorsoBase_r22", CubeListBuilder.create().texOffs(142, 426).addBox(-9.761F, -0.3912F, -3.9958F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.7216F, -0.2689F, -0.9827F));

		PartDefinition TorsoTop_r19 = BBBody2.addOrReplaceChild("TorsoTop_r19", CubeListBuilder.create().texOffs(201, 399).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6982F, -0.1364F, -0.8666F));

		PartDefinition MiddleBase = BackBase.addOrReplaceChild("MiddleBase", CubeListBuilder.create().texOffs(308, 117).addBox(-5.3333F, -3.7414F, -18.4933F, 11.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8333F, -8.5086F, -1.7567F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topJawLeft_r2 = MiddleBase.addOrReplaceChild("topJawLeft_r2", CubeListBuilder.create().texOffs(282, 196).addBox(-7.0F, -3.0F, -9.5F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0248F, 0.9957F, -9.0033F, 0.0F, 3.1416F, -0.4363F));

		PartDefinition topJawRight_r2 = MiddleBase.addOrReplaceChild("topJawRight_r2", CubeListBuilder.create().texOffs(282, 196).addBox(-8.25F, -8.5F, -3.51F, 14.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, 0.4363F));

		PartDefinition FrontBase = MiddleBase.addOrReplaceChild("FrontBase", CubeListBuilder.create().texOffs(314, 307).addBox(-5.3333F, -3.7414F, -18.4933F, 11.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -17.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topJawLeft_r3 = FrontBase.addOrReplaceChild("topJawLeft_r3", CubeListBuilder.create().texOffs(307, 0).addBox(-5.0F, -1.5F, -9.5F, 12.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.2362F, 0.5425F, -9.0033F, 0.0F, -0.2618F, -0.4363F));

		PartDefinition topJawRight_r3 = FrontBase.addOrReplaceChild("topJawRight_r3", CubeListBuilder.create().texOffs(343, 44).addBox(-8.25F, -8.5F, 1.49F, 11.0F, 4.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6667F, 6.5086F, -14.9933F, 0.0F, 0.0F, 0.4363F));

		PartDefinition FrontTopMouthCorpseDetails = FrontBase.addOrReplaceChild("FrontTopMouthCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadOuterLeft_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterLeft_r1", CubeListBuilder.create().texOffs(129, 379).addBox(-3.25F, -2.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.6667F, 0.5F, -14.3301F, -0.4356F, 0.4802F, -0.4461F));

		PartDefinition HeadInnerLeft_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadInnerLeft_r1", CubeListBuilder.create().texOffs(324, 44).addBox(-4.75F, -1.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8365F, -2.5F, -14.2321F, -0.5236F, -0.131F, -0.4799F));

		PartDefinition HeadInnerRight_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadInnerRight_r1", CubeListBuilder.create().texOffs(122, 348).addBox(-4.0F, -1.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6699F, -2.5F, -14.2321F, -0.3808F, -0.1035F, 0.3236F));

		PartDefinition HeadOuterRightTeeth_r1 = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterRightTeeth_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, 4.0F, -6.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(329, 379).addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 0.0F, -10.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition MouthTopCenterpiece = FrontTopMouthCorpseDetails.addOrReplaceChild("MouthTopCenterpiece", CubeListBuilder.create(), PartPose.offset(6.6699F, -1.7346F, -12.3843F));

		PartDefinition CenterTorsoTop_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoTop_r1", CubeListBuilder.create().texOffs(424, 173).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.9197F, -1.6236F, 0.6545F, 0.0F, 0.0F));

		PartDefinition CenterTorsoBack_r1 = MouthTopCenterpiece.addOrReplaceChild("CenterTorsoBack_r1", CubeListBuilder.create().texOffs(440, 435).addBox(-10.5F, -4.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MTCPLimbs = MouthTopCenterpiece.addOrReplaceChild("MTCPLimbs", CubeListBuilder.create(), PartPose.offset(-7.0F, -3.9197F, -1.6236F));

		PartDefinition Leg_r23 = MTCPLimbs.addOrReplaceChild("Leg_r23", CubeListBuilder.create().texOffs(0, 433).addBox(-2.0F, -1.75F, 0.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 6.0F, -0.0499F, 0.3027F, -0.0411F));

		PartDefinition RArm_r1 = MTCPLimbs.addOrReplaceChild("RArm_r1", CubeListBuilder.create().texOffs(263, 411).addBox(-1.0F, -0.9742F, -7.9043F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -0.3108F, -2.0349F, 0.5672F, -0.6109F, 0.0F));

		PartDefinition MTCPHead = MouthTopCenterpiece.addOrReplaceChild("MTCPHead", CubeListBuilder.create(), PartPose.offset(-6.9992F, -0.7425F, -4.9086F));

		PartDefinition MTCPHead_r1 = MTCPHead.addOrReplaceChild("MTCPHead_r1", CubeListBuilder.create().texOffs(379, 36).addBox(-3.9992F, -5.6417F, -7.7822F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0008F, -0.4155F, -0.0812F, 1.0036F, 0.0F, 0.0F));

		PartDefinition MTCPJaw = MTCPHead.addOrReplaceChild("MTCPJaw", CubeListBuilder.create(), PartPose.offset(-0.0008F, 0.2542F, 1.5355F));

		PartDefinition MTCPJaw_r1 = MTCPJaw.addOrReplaceChild("MTCPJaw_r1", CubeListBuilder.create().texOffs(268, 65).addBox(-4.0F, -0.3651F, -8.0861F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition HeadOuterLeftFlesh = FrontTopMouthCorpseDetails.addOrReplaceChild("HeadOuterLeftFlesh", CubeListBuilder.create().texOffs(184, 126).addBox(-3.8419F, 0.1029F, 0.1125F, 8.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.8812F, 4.0682F, -18.939F, -0.4356F, 0.4802F, -0.4461F));

		PartDefinition FungalBloom = FrontTopMouthCorpseDetails.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(7.7818F, -4.4822F, 4.8999F, -0.1725F, -0.0893F, 0.2794F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(120, 12).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, -7.985F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(98, 84).addBox(-16.0F, -1.0F, -18.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(131, 0).addBox(-16.0F, -1.0F, 2.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.985F, 4.041F, 0.015F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(140, 39).addBox(2.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(172, 39).addBox(-18.0F, -1.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.015F, 4.041F, -7.985F, 0.0F, 0.0F, 0.3927F));

		PartDefinition OutsideExtras = FrontTopMouthCorpseDetails.addOrReplaceChild("OutsideExtras", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body1 = OutsideExtras.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offset(-10.4048F, -1.1299F, -8.5F));

		PartDefinition Arm2_r2 = Body1.addOrReplaceChild("Arm2_r2", CubeListBuilder.create().texOffs(178, 413).addBox(-4.0F, -0.55F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4526F, -1.2485F, 9.6142F, -2.6802F, 1.029F, 2.882F));

		PartDefinition Arm1_r2 = Body1.addOrReplaceChild("Arm1_r2", CubeListBuilder.create().texOffs(444, 330).addBox(-7.8149F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.7854F));

		PartDefinition TorsoTop1_r1 = Body1.addOrReplaceChild("TorsoTop1_r1", CubeListBuilder.create().texOffs(405, 353).addBox(-1.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5952F, 1.1299F, 2.5F, 0.0F, 0.0F, -0.3054F));

		PartDefinition TorsoBottom1_r1 = Body1.addOrReplaceChild("TorsoBottom1_r1", CubeListBuilder.create().texOffs(432, 61).addBox(-3.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8842F, -1.7526F, 3.5F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Body2 = OutsideExtras.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(370, 94).addBox(-3.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, 0.0F, 2.0F));

		PartDefinition Torso_r1 = Body2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(114, 424).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Arm_r34 = Body2.addOrReplaceChild("Arm_r34", CubeListBuilder.create().texOffs(178, 413).addBox(-8.0948F, -1.1342F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Body3 = OutsideExtras.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.1618F, 2.5895F, 15.0738F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Arm_r35 = Body3.addOrReplaceChild("Arm_r35", CubeListBuilder.create().texOffs(88, 411).addBox(-1.1649F, -2.7738F, -0.8808F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5289F, 1.0321F, 3.0404F, -0.2404F, -0.2686F, 0.7273F));

		PartDefinition Arm_r36 = Body3.addOrReplaceChild("Arm_r36", CubeListBuilder.create().texOffs(88, 411).addBox(-0.1851F, -2.7028F, -2.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0763F, 0.2806F, -3.5738F, 0.0F, 0.0436F, 0.7854F));

		PartDefinition TorsoTop_r20 = Body3.addOrReplaceChild("TorsoTop_r20", CubeListBuilder.create().texOffs(54, 403).addBox(-5.0F, -3.0F, -3.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6716F, 1.4105F, -1.0738F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBottom_r10 = Body3.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(430, 95).addBox(-2.5F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8078F, -1.472F, -0.0738F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body4 = OutsideExtras.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 14.0F));

		PartDefinition Limb_r2 = Body4.addOrReplaceChild("Limb_r2", CubeListBuilder.create().texOffs(16, 323).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.342F, -0.9397F, -0.6264F, -0.2865F, 0.1074F));

		PartDefinition RightJaw = Jaw.addOrReplaceChild("RightJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 22.5F, 12.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition RBackBase = RightJaw.addOrReplaceChild("RBackBase", CubeListBuilder.create().texOffs(330, 141).addBox(-5.3333F, 0.8291F, -16.9933F, 11.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8333F, 2.6232F, -2.0168F, 0.2618F, 0.0F, 0.0F));

		PartDefinition bottomJawLeft_r1 = RBackBase.addOrReplaceChild("bottomJawLeft_r1", CubeListBuilder.create().texOffs(324, 22).addBox(-5.5F, -1.5F, -9.5F, 11.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2993F, -0.9145F, -6.7533F, 0.0F, 3.1416F, 0.4363F));

		PartDefinition bottomJawRight_r1 = RBackBase.addOrReplaceChild("bottomJawRight_r1", CubeListBuilder.create().texOffs(324, 22).addBox(-5.5F, -1.5F, -9.5F, 11.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.1326F, -0.9145F, -6.7533F, 0.0F, 0.0F, -0.4363F));

		PartDefinition RBackBaseMouthDetails = RBackBase.addOrReplaceChild("RBackBaseMouthDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TumoralDetails = RBackBaseMouthDetails.addOrReplaceChild("TumoralDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TumorGroup1 = TumoralDetails.addOrReplaceChild("TumorGroup1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TumorTeeHee_r1 = TumorGroup1.addOrReplaceChild("TumorTeeHee_r1", CubeListBuilder.create().texOffs(234, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0384F, -2.3591F, -8.7627F, 0.3817F, 0.9801F, 1.1459F));

		PartDefinition TumorTeeHee_r2 = TumorGroup1.addOrReplaceChild("TumorTeeHee_r2", CubeListBuilder.create().texOffs(230, 16).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -7.0F, -0.6156F, 0.3397F, -0.5651F));

		PartDefinition TumorGroup2 = TumoralDetails.addOrReplaceChild("TumorGroup2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5192F, -2.6796F, -12.8814F, 1.0908F, 0.0F, -1.309F));

		PartDefinition TumorTeeHee_r3 = TumorGroup2.addOrReplaceChild("TumorTeeHee_r3", CubeListBuilder.create().texOffs(227, 13).addBox(-1.5F, 5.5F, 4.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5192F, 0.3204F, -0.8814F, 0.3817F, 0.9801F, 1.1459F));

		PartDefinition TumorTeeHee_r4 = TumorGroup2.addOrReplaceChild("TumorTeeHee_r4", CubeListBuilder.create().texOffs(225, 12).addBox(-2.0F, -3.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5192F, -0.3204F, 0.8814F, -0.6156F, 0.3397F, -0.5651F));

		PartDefinition Corpse = RBackBaseMouthDetails.addOrReplaceChild("Corpse", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RBackBody1 = Corpse.addOrReplaceChild("RBackBody1", CubeListBuilder.create().texOffs(423, 105).addBox(-4.0F, -2.0F, -11.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r37 = RBackBody1.addOrReplaceChild("Arm_r37", CubeListBuilder.create().texOffs(416, 453).addBox(0.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.5F, -6.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition TorsoBack_r1 = RBackBody1.addOrReplaceChild("TorsoBack_r1", CubeListBuilder.create().texOffs(440, 266).addBox(-3.5F, -0.75F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5031F, 0.0F, -12.5021F, 0.2182F, 0.3927F, 0.0F));

		PartDefinition Jaw_r7 = RBackBody1.addOrReplaceChild("Jaw_r7", CubeListBuilder.create().texOffs(328, 187).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 1.0957F, 0.5575F, 0.0236F));

		PartDefinition Head_r18 = RBackBody1.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(115, 394).addBox(-4.0F, -5.0F, 1.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.5782F, 0.1836F, 0.1186F));

		PartDefinition RBackBody2 = Corpse.addOrReplaceChild("RBackBody2", CubeListBuilder.create().texOffs(28, 423).addBox(-4.0F, -2.0F, -11.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -3.0F, 0.0F, 0.0F, -0.7418F, 0.0F));

		PartDefinition Limb_r3 = RBackBody2.addOrReplaceChild("Limb_r3", CubeListBuilder.create().texOffs(406, 247).addBox(-2.5815F, 0.2367F, -5.3559F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.5509F, -1.9505F, -24.5901F, 0.0F, 0.7418F, 0.0F));

		PartDefinition Arm_r38 = RBackBody2.addOrReplaceChild("Arm_r38", CubeListBuilder.create().texOffs(452, 201).addBox(0.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.5F, -6.0F, -1.7804F, 0.0166F, 0.7384F));

		PartDefinition TorsoBack_r2 = RBackBody2.addOrReplaceChild("TorsoBack_r2", CubeListBuilder.create().texOffs(442, 4).addBox(-2.5F, -0.75F, -5.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5031F, 0.0F, -12.5021F, 0.2252F, -0.4611F, -0.1862F));

		PartDefinition Teeth_r1 = RBackBody2.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(290, 277).addBox(-3.0F, -5.0F, -2.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(46, 198).addBox(-3.0F, -5.0F, 0.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.5782F, 0.1836F, 0.1186F));

		PartDefinition RBackBody3 = Corpse.addOrReplaceChild("RBackBody3", CubeListBuilder.create().texOffs(407, 336).addBox(-4.0F, -2.0F, -11.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.248F, 3.2631F, 0.8915F, 0.0F, 0.0F, 3.098F));

		PartDefinition Arm_r39 = RBackBody3.addOrReplaceChild("Arm_r39", CubeListBuilder.create().texOffs(370, 195).addBox(0.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.5F, -6.0F, -2.2335F, -1.2687F, 2.4563F));

		PartDefinition Leg_r24 = RBackBody3.addOrReplaceChild("Leg_r24", CubeListBuilder.create().texOffs(405, 393).addBox(-2.6022F, -1.8667F, -8.3841F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7182F, 0.7713F, -14.5016F, -2.4619F, 1.1544F, 0.8708F));

		PartDefinition Leg_r25 = RBackBody3.addOrReplaceChild("Leg_r25", CubeListBuilder.create().texOffs(406, 61).addBox(-3.5F, -2.5F, -8.0F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7832F, 1.598F, -15.1947F, 2.1601F, 1.2601F, 1.5633F));

		PartDefinition TorsoBack_r3 = RBackBody3.addOrReplaceChild("TorsoBack_r3", CubeListBuilder.create().texOffs(359, 287).addBox(-3.5F, -0.75F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5031F, 0.0F, -12.5021F, 0.2182F, 0.3927F, 0.0F));

		PartDefinition Head_r19 = RBackBody3.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(397, 371).addBox(-9.5616F, -3.6054F, 1.0073F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.5998F, -0.9527F, -0.4768F));

		PartDefinition Jaw_r8 = RBackBody3.addOrReplaceChild("Jaw_r8", CubeListBuilder.create().texOffs(331, 74).addBox(-4.0F, -5.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.7902F, 0.5575F, 0.0236F));

		PartDefinition Head_r20 = RBackBody3.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(398, 232).addBox(-4.0F, -5.0F, 1.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -5.0F, 0.5782F, 0.1836F, 0.1186F));

		PartDefinition RBackBody4 = Corpse.addOrReplaceChild("RBackBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.9276F, 3.6828F, -7.8452F, 0.0F, 0.5672F, 3.098F));

		PartDefinition Leg_r26 = RBackBody4.addOrReplaceChild("Leg_r26", CubeListBuilder.create().texOffs(0, 80).addBox(-2.6022F, -1.8667F, -8.3841F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5254F, 1.1393F, -5.7648F, -1.8469F, 0.9981F, 1.9562F));

		PartDefinition TorsoBack_r4 = RBackBody4.addOrReplaceChild("TorsoBack_r4", CubeListBuilder.create().texOffs(87, 84).addBox(-3.5F, -0.75F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.696F, 0.368F, -3.7654F, 0.2182F, 0.3927F, 0.0F));

		PartDefinition TorsoBottom_r11 = RBackBody4.addOrReplaceChild("TorsoBottom_r11", CubeListBuilder.create().texOffs(60, 359).addBox(-4.0F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1928F, 0.368F, 0.7367F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Head_r21 = RBackBody4.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(397, 14).addBox(-4.0F, -5.0F, 1.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1928F, 0.368F, 3.7367F, -0.7745F, 0.1836F, 0.1186F));

		PartDefinition RFrontBase = RBackBase.addOrReplaceChild("RFrontBase", CubeListBuilder.create().texOffs(295, 330).addBox(-5.3333F, 1.7414F, -18.4933F, 11.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0877F, -14.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bottomJawLeft_r2 = RFrontBase.addOrReplaceChild("bottomJawLeft_r2", CubeListBuilder.create().texOffs(300, 163).addBox(-2.5F, -1.5F, -10.5F, 11.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2993F, 0.9977F, -10.0033F, 0.0F, -0.3491F, 0.4363F));

		PartDefinition bottomJawRight_r2 = RFrontBase.addOrReplaceChild("bottomJawRight_r2", CubeListBuilder.create().texOffs(300, 163).addBox(-5.5F, -1.5F, -10.5F, 11.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5777F, 2.1891F, -8.9773F, 0.0F, -2.7053F, -0.4363F));

		PartDefinition RFrontBaseMouthCorpseDetails = RFrontBase.addOrReplaceChild("RFrontBaseMouthCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RMouthBody1 = RFrontBaseMouthCorpseDetails.addOrReplaceChild("RMouthBody1", CubeListBuilder.create().texOffs(56, 424).addBox(-3.9933F, -2.75F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -13.0F));

		PartDefinition Arm_r40 = RMouthBody1.addOrReplaceChild("Arm_r40", CubeListBuilder.create().texOffs(246, 430).addBox(-0.523F, -2.2197F, 0.0654F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3529F, -0.538F, 1.3928F, 0.4837F, 0.9191F, 0.1623F));

		PartDefinition Arm_r41 = RMouthBody1.addOrReplaceChild("Arm_r41", CubeListBuilder.create().texOffs(246, 430).addBox(-3.0F, -2.75F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.1401F, -0.7568F, 0.2538F));

		PartDefinition TorsoBase_r23 = RMouthBody1.addOrReplaceChild("TorsoBase_r23", CubeListBuilder.create().texOffs(440, 308).addBox(-4.5F, -2.25F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 8.0F, 0.354F, -0.1639F, -0.0602F));

		PartDefinition Jaw_r9 = RMouthBody1.addOrReplaceChild("Jaw_r9", CubeListBuilder.create().texOffs(329, 196).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9041F, -0.9679F, -0.5303F, -0.151F, 0.0879F));

		PartDefinition Head_r22 = RMouthBody1.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(394, 169).addBox(-4.0F, -4.75F, -9.25F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition RMouthBody2 = RFrontBaseMouthCorpseDetails.addOrReplaceChild("RMouthBody2", CubeListBuilder.create().texOffs(363, 414).addBox(-4.0F, -2.75F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1272F, -1.7823F, -5.5616F, -1.8457F, -0.886F, -1.2216F));

		PartDefinition Arm_r42 = RMouthBody2.addOrReplaceChild("Arm_r42", CubeListBuilder.create().texOffs(24, 433).addBox(-0.523F, -2.2197F, 0.0654F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3529F, -0.538F, 1.3928F, 2.7001F, 0.8498F, 2.567F));

		PartDefinition Arm_r43 = RMouthBody2.addOrReplaceChild("Arm_r43", CubeListBuilder.create().texOffs(330, 426).addBox(1.0F, -1.5F, -4.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0874F, 2.2564F, 9.3882F, 1.0368F, -1.4509F, -1.7805F));

		PartDefinition TorsoBase_r24 = RMouthBody2.addOrReplaceChild("TorsoBase_r24", CubeListBuilder.create().texOffs(442, 4).addBox(-4.5F, -2.25F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.75F, 8.0F, -0.3005F, -0.1639F, -0.0602F));

		PartDefinition Head_r23 = RMouthBody2.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(200, 146).addBox(-2.0F, -4.75F, -10.25F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2654F, 0.1719F, -0.4971F));

		PartDefinition RMouthBody3 = RFrontBaseMouthCorpseDetails.addOrReplaceChild("RMouthBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.1272F, -1.7823F, -5.5616F, -1.8457F, -0.886F, -1.2216F));

		PartDefinition Arm_r44 = RMouthBody3.addOrReplaceChild("Arm_r44", CubeListBuilder.create().texOffs(356, 454).addBox(-5.0345F, -2.5628F, -5.2147F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5612F, -0.8472F, -2.6327F, 2.5674F, -0.0676F, -1.9412F));

		PartDefinition Arm_r45 = RMouthBody3.addOrReplaceChild("Arm_r45", CubeListBuilder.create().texOffs(332, 455).addBox(-2.3874F, -0.9276F, -0.4988F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1892F, 5.9382F, 1.9855F, 1.9612F, -0.9447F, -0.884F));

		PartDefinition Torso_r2 = RMouthBody3.addOrReplaceChild("Torso_r2", CubeListBuilder.create().texOffs(311, 423).addBox(-5.0F, -1.0F, -1.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 3.0F, 0.0F, 0.836F, 0.2079F, -0.5007F));

		PartDefinition Teeth_r2 = RMouthBody3.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(92, 231).addBox(-4.0F, 1.0F, -4.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(145, 399).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 5.0F, 14.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition RMouthBody4 = RFrontBaseMouthCorpseDetails.addOrReplaceChild("RMouthBody4", CubeListBuilder.create().texOffs(301, 386).addBox(-2.8936F, -8.1061F, 8.1339F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.1272F, -1.7823F, -5.5616F, -1.8457F, -0.886F, -1.2216F));

		PartDefinition LeftJaw = Jaw.addOrReplaceChild("LeftJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 29.5F, 12.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition LBackBase = LeftJaw.addOrReplaceChild("LBackBase", CubeListBuilder.create().texOffs(329, 187).mirror().addBox(-5.3343F, 0.8291F, -16.9933F, 11.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.1667F, -2.3768F, -1.0168F, 0.2054F, -0.0741F, 0.3414F));

		PartDefinition bottomJawRight_r3 = LBackBase.addOrReplaceChild("bottomJawRight_r3", CubeListBuilder.create().texOffs(158, 323).mirror().addBox(-5.5F, -1.5F, -9.5F, 11.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.2993F, -0.9145F, -6.7533F, 0.0F, -3.1416F, 0.4363F));

		PartDefinition bottomJawLeft_r3 = LBackBase.addOrReplaceChild("bottomJawLeft_r3", CubeListBuilder.create().texOffs(158, 323).mirror().addBox(-8.25F, 5.5F, -3.51F, 11.0F, 3.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.6667F, -8.4209F, -12.7433F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LBackBaseDetails = LBackBase.addOrReplaceChild("LBackBaseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LBackTumoralDetails = LBackBaseDetails.addOrReplaceChild("LBackTumoralDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LBackMouthTumor1 = LBackTumoralDetails.addOrReplaceChild("LBackMouthTumor1", CubeListBuilder.create(), PartPose.offset(9.0F, -3.0F, -2.0F));

		PartDefinition Tumor_r1 = LBackMouthTumor1.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(228, 15).mirror().addBox(-4.0F, -3.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition LBackMouthTumor2 = LBackTumoralDetails.addOrReplaceChild("LBackMouthTumor2", CubeListBuilder.create(), PartPose.offset(9.0F, -3.0F, -2.0F));

		PartDefinition Tumor_r2 = LBackMouthTumor2.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(233, 17).mirror().addBox(-5.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.6975F, -1.0F, 0.8505F, 0.975F, -0.2926F, -1.3777F));

		PartDefinition LBackCorpseDetails = LBackBaseDetails.addOrReplaceChild("LBackCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LBackBody1 = LBackCorpseDetails.addOrReplaceChild("LBackBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r46 = LBackBody1.addOrReplaceChild("Arm_r46", CubeListBuilder.create().texOffs(422, 429).mirror().addBox(-1.204F, -2.0993F, -0.2718F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.9812F, -1.719F, -15.6447F, -0.7903F, -1.2439F, 0.7595F));

		PartDefinition TorsoBottom_r12 = LBackBody1.addOrReplaceChild("TorsoBottom_r12", CubeListBuilder.create().texOffs(423, 23).mirror().addBox(-1.0179F, -1.1632F, -4.5978F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -2.0F, -13.0F, 0.0F, -0.7854F, -0.5672F));

		PartDefinition TorsoBase_r25 = LBackBody1.addOrReplaceChild("TorsoBase_r25", CubeListBuilder.create().texOffs(442, 291).mirror().addBox(-2.638F, -2.4154F, -2.6218F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.6126F, 0.2776F, -8.0503F, 0.0F, -0.48F, -0.5672F));

		PartDefinition LBackBody2 = LBackCorpseDetails.addOrReplaceChild("LBackBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0282F, -3.4041F, -5.5235F, 0.0F, 2.8362F, 0.0F));

		PartDefinition LEg_r27 = LBackBody2.addOrReplaceChild("LEg_r27", CubeListBuilder.create().texOffs(246, 406).mirror().addBox(-7.6048F, -0.6834F, -0.9268F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.839F, 2.9378F, 4.4674F, -0.4259F, -1.3426F, 0.5227F));

		PartDefinition LEg_r28 = LBackBody2.addOrReplaceChild("LEg_r28", CubeListBuilder.create().texOffs(367, 443).mirror().addBox(-2.6048F, -1.1834F, -0.9268F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.839F, 2.9378F, 4.4674F, -0.1186F, -0.6609F, 0.1796F));

		PartDefinition Arm_r47 = LBackBody2.addOrReplaceChild("Arm_r47", CubeListBuilder.create().texOffs(75, 425).mirror().addBox(-1.2516F, -1.7387F, -1.3565F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6633F, -0.2136F, 4.0413F, -0.4899F, -0.7441F, 0.2139F));

		PartDefinition Arm_r48 = LBackBody2.addOrReplaceChild("Arm_r48", CubeListBuilder.create().texOffs(75, 425).mirror().addBox(-4.204F, -2.0993F, -2.2718F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1439F, 1.5519F, -3.193F, -0.7903F, -1.2439F, 0.7595F));

		PartDefinition Jaw_r10 = LBackBody2.addOrReplaceChild("Jaw_r10", CubeListBuilder.create().texOffs(331, 65).mirror().addBox(-4.5487F, -3.7688F, -0.444F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2593F, 1.1877F, -0.791F, 1.4927F, -1.1531F, -1.479F));

		PartDefinition Head_r24 = LBackBody2.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(395, 126).mirror().addBox(-4.5487F, -3.7688F, -7.694F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2593F, 1.1877F, -0.791F, 1.6145F, -1.1329F, -1.8995F));

		PartDefinition TorsoBottom_r13 = LBackBody2.addOrReplaceChild("TorsoBottom_r13", CubeListBuilder.create().texOffs(0, 423).mirror().addBox(-3.0179F, -1.1654F, -6.5978F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8373F, 1.2709F, -0.5484F, 0.0F, -1.3963F, -0.5672F));

		PartDefinition TorsoBase_r26 = LBackBody2.addOrReplaceChild("TorsoBase_r26", CubeListBuilder.create().texOffs(443, 224).mirror().addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5729F, 2.1363F, 1.2634F, -0.1671F, -1.3055F, -0.4059F));

		PartDefinition LBackBody3 = LBackCorpseDetails.addOrReplaceChild("LBackBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9718F, 4.6578F, -9.5235F, -0.1329F, -0.0531F, -0.1488F));

		PartDefinition LEg_r29 = LBackBody3.addOrReplaceChild("LEg_r29", CubeListBuilder.create().texOffs(220, 406).mirror().addBox(-7.6048F, -3.3166F, -0.9268F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.839F, -2.9378F, 4.4674F, 0.9059F, -1.3426F, -0.5227F));

		PartDefinition LEg_r30 = LBackBody3.addOrReplaceChild("LEg_r30", CubeListBuilder.create().texOffs(303, 443).mirror().addBox(-2.6048F, -2.8166F, -0.9268F, 4.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.839F, -2.9378F, 4.4674F, 0.4374F, -1.0064F, -0.2554F));

		PartDefinition Arm_r49 = LBackBody3.addOrReplaceChild("Arm_r49", CubeListBuilder.create().texOffs(425, 269).mirror().addBox(-1.2516F, -1.2613F, -1.3565F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.6633F, 0.2136F, 4.0413F, 2.3587F, 1.2115F, 1.8923F));

		PartDefinition Jaw_r11 = LBackBody3.addOrReplaceChild("Jaw_r11", CubeListBuilder.create().texOffs(158, 332).mirror().addBox(-4.5487F, -4.2312F, -0.444F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2593F, -1.1877F, -0.791F, 1.3001F, -1.0128F, 0.1701F));

		PartDefinition Head_r25 = LBackBody3.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(324, 395).mirror().addBox(-4.5487F, -4.2312F, -7.694F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2593F, -1.1877F, -0.791F, 1.848F, -1.0353F, -0.1641F));

		PartDefinition TorsoTop_r21 = LBackBody3.addOrReplaceChild("TorsoTop_r21", CubeListBuilder.create().texOffs(422, 390).mirror().addBox(-3.0179F, -2.8346F, -6.5978F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.8373F, -1.2709F, -0.5484F, 0.0F, -1.3963F, 0.5672F));

		PartDefinition TorsoBase_r27 = LBackBody3.addOrReplaceChild("TorsoBase_r27", CubeListBuilder.create().texOffs(244, 442).mirror().addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.5729F, -2.1363F, 1.2634F, 0.1671F, -1.3055F, 0.4059F));

		PartDefinition LFrontBase = LBackBase.addOrReplaceChild("LFrontBase", CubeListBuilder.create().texOffs(355, 299).mirror().addBox(-5.3333F, 1.7414F, -13.4933F, 11.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0877F, -14.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition bottomJawRight_r4 = LFrontBase.addOrReplaceChild("bottomJawRight_r4", CubeListBuilder.create().texOffs(343, 162).mirror().addBox(-5.5F, -1.5F, -7.0F, 11.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.465F, 1.216F, -5.1181F, 0.0F, 2.6616F, 0.4363F));

		PartDefinition bottomJawLeft_r4 = LFrontBase.addOrReplaceChild("bottomJawLeft_r4", CubeListBuilder.create().texOffs(343, 162).mirror().addBox(-7.5F, -2.5F, -7.0F, 11.0F, 3.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.1326F, 0.9977F, -6.5033F, 0.0F, 0.48F, -0.4363F));

		PartDefinition LFrontCorpseDetails = LFrontBase.addOrReplaceChild("LFrontCorpseDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HRToothies_r1 = LFrontCorpseDetails.addOrReplaceChild("HRToothies_r1", CubeListBuilder.create().texOffs(180, 206).mirror().addBox(-3.25F, -5.5F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(32, 379).mirror().addBox(-3.25F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0102F, -0.2364F, -11.6711F, 0.1804F, -0.2571F, -0.6212F));

		PartDefinition Corpsey = LFrontCorpseDetails.addOrReplaceChild("Corpsey", CubeListBuilder.create(), PartPose.offset(1.677F, 0.6243F, -11.0422F));

		PartDefinition Teeth_r3 = Corpsey.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(90, 16).mirror().addBox(-3.7455F, 2.224F, -1.1133F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 393).mirror().addBox(-3.7455F, -3.776F, -8.1133F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, -1.0516F, -0.1067F, 2.6274F));

		PartDefinition LEg_r31 = Corpsey.addOrReplaceChild("LEg_r31", CubeListBuilder.create().texOffs(231, 451).mirror().addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.1612F, -3.8029F, 5.7673F, -1.6349F, -0.0701F, -1.9007F));

		PartDefinition Arm_r50 = Corpsey.addOrReplaceChild("Arm_r50", CubeListBuilder.create().texOffs(451, 357).mirror().addBox(0.4641F, -1.7095F, -1.399F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3183F, 1.7423F, -1.5913F, -1.6589F, -0.085F, 2.5894F));

		PartDefinition CorpseTorsoBottom_r1 = Corpsey.addOrReplaceChild("CorpseTorsoBottom_r1", CubeListBuilder.create().texOffs(403, 141).mirror().addBox(-4.0F, -3.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2626F, -0.085F, 2.5894F));

		PartDefinition CorpseTorsoBase_r1 = Corpsey.addOrReplaceChild("CorpseTorsoBase_r1", CubeListBuilder.create().texOffs(0, 248).mirror().addBox(-3.0006F, -3.1487F, 0.1847F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3706F, -1.2554F, 2.6069F, 0.0233F, -0.3793F, 2.6735F));

		PartDefinition CorpseyToo = LFrontCorpseDetails.addOrReplaceChild("CorpseyToo", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.751F, -1.0503F, -2.6659F, 2.9234F, 1.5272F, 3.1416F));

		PartDefinition Head_r26 = CorpseyToo.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(135, 231).mirror().addBox(-3.1556F, -4.6765F, -6.4277F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.4514F, -0.3041F, 2.5323F));

		PartDefinition Arm_r51 = CorpseyToo.addOrReplaceChild("Arm_r51", CubeListBuilder.create().texOffs(391, 295).mirror().addBox(-1.7313F, -3.3989F, -9.3269F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3183F, 1.7423F, -1.5913F, -1.9643F, -0.085F, 2.5894F));

		PartDefinition CorpseTorsoBottom_r2 = CorpseyToo.addOrReplaceChild("CorpseTorsoBottom_r2", CubeListBuilder.create().texOffs(382, 402).mirror().addBox(-5.782F, -3.9041F, -3.0843F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2626F, -0.085F, 2.5894F));

		PartDefinition CorpseTorsoBase_r2 = CorpseyToo.addOrReplaceChild("CorpseTorsoBase_r2", CubeListBuilder.create().texOffs(135, 246).mirror().addBox(-4.5423F, -3.8205F, -1.337F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3706F, -1.2554F, 2.6069F, 0.0217F, 0.1005F, 2.6843F));

		PartDefinition CorpseyTree = LFrontCorpseDetails.addOrReplaceChild("CorpseyTree", CubeListBuilder.create(), PartPose.offsetAndRotation(3.249F, 4.9497F, -5.6659F, -0.1408F, 0.3065F, -2.9266F));

		PartDefinition Leg_r32 = CorpseyTree.addOrReplaceChild("Leg_r32", CubeListBuilder.create().texOffs(391, 184).mirror().addBox(-1.5545F, -1.3131F, -10.6858F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.3359F, -2.631F, 7.2922F, -2.6188F, -0.085F, 2.5894F));

		PartDefinition Arm_r52 = CorpseyTree.addOrReplaceChild("Arm_r52", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.3359F, -0.651F, -9.5231F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.3183F, 0.7423F, -0.0913F, 3.004F, 0.3043F, 2.5367F));

		PartDefinition CorpseTorsoBottom_r3 = CorpseyTree.addOrReplaceChild("CorpseTorsoBottom_r3", CubeListBuilder.create().texOffs(354, 402).mirror().addBox(-5.782F, -4.9041F, -3.0843F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4371F, -0.085F, 2.5894F));

		PartDefinition CorpseTorsoBase_r3 = CorpseyTree.addOrReplaceChild("CorpseTorsoBase_r3", CubeListBuilder.create().texOffs(180, 181).mirror().addBox(-4.5423F, -3.8205F, -1.337F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3706F, -1.2554F, 2.6069F, 0.0217F, 0.1005F, 2.6843F));

		PartDefinition Licker = Jaw.addOrReplaceChild("Licker", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4784F, 21.6004F, 12.0193F, -0.3022F, 0.0115F, 0.3902F));

		PartDefinition Tumors = Licker.addOrReplaceChild("Tumors", CubeListBuilder.create().texOffs(361, 269).addBox(-2.4835F, -1.0167F, -2.0773F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4835F, -1.9833F, -2.9227F));

		PartDefinition TumorBase3_r1 = Tumors.addOrReplaceChild("TumorBase3_r1", CubeListBuilder.create().texOffs(364, 272).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.467F, -2.4666F, -1.3454F, 1.2452F, 1.3339F, -0.4916F));

		PartDefinition TumorBase1_r1 = Tumors.addOrReplaceChild("TumorBase1_r1", CubeListBuilder.create().texOffs(359, 269).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9835F, -0.5167F, -0.5773F, 0.7209F, 0.544F, -0.5323F));

		PartDefinition LickerSeg2 = Licker.addOrReplaceChild("LickerSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3531F, -0.8512F, -6.663F, 0.5236F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r28 = LickerSeg2.addOrReplaceChild("TorsoBase_r28", CubeListBuilder.create().texOffs(236, 192).addBox(-2.5F, -1.5F, -5.0F, 5.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2371F, 0.171F, 0.4551F, -0.3054F, 0.0F, -0.5236F));

		PartDefinition LickerSeg3 = LickerSeg2.addOrReplaceChild("LickerSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0601F, -1.175F, -4.7707F, -0.3906F, 0.0338F, 0.1265F));

		PartDefinition TorsoTop_r22 = LickerSeg3.addOrReplaceChild("TorsoTop_r22", CubeListBuilder.create().texOffs(356, 424).addBox(-3.7511F, -2.2061F, -7.0017F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1646F, -0.2037F, 0.4476F, -0.2182F, 0.0F, -0.5236F));

		PartDefinition Tumor1 = LickerSeg3.addOrReplaceChild("Tumor1", CubeListBuilder.create().texOffs(371, 277).addBox(-1.2623F, -1.7544F, -0.4467F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2972F, -2.654F, -1.7743F));

		PartDefinition ToungeHead = LickerSeg3.addOrReplaceChild("ToungeHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadBase_r2 = ToungeHead.addOrReplaceChild("HeadBase_r2", CubeListBuilder.create().texOffs(355, 315).addBox(-3.5265F, 2.3034F, -3.1802F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(386, 261).addBox(-3.5265F, -3.6966F, -7.1802F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8953F, -1.6955F, -6.2221F, 0.0F, 0.0F, -0.5236F));

		PartDefinition JawRight = ToungeHead.addOrReplaceChild("JawRight", CubeListBuilder.create(), PartPose.offset(2.6647F, -0.0268F, -8.7908F));

		PartDefinition JawRight_r1 = JawRight.addOrReplaceChild("JawRight_r1", CubeListBuilder.create().texOffs(160, 20).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8908F, 0.5407F, -0.4599F, 0.4566F, 0.1556F, -0.9945F));

		PartDefinition JawLeft = ToungeHead.addOrReplaceChild("JawLeft", CubeListBuilder.create(), PartPose.offset(-0.0763F, 0.9327F, -8.2995F));

		PartDefinition JawLeft_r1 = JawLeft.addOrReplaceChild("JawLeft_r1", CubeListBuilder.create().texOffs(304, 433).addBox(-2.0F, -1.0F, -4.0F, 5.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4893F, 0.9959F, -1.1028F, 0.5543F, -0.2071F, 0.0084F));

		PartDefinition ToungeCorpseHeadTumor = ToungeHead.addOrReplaceChild("ToungeCorpseHeadTumor", CubeListBuilder.create(), PartPose.offset(-0.8953F, -1.6955F, -11.2221F));

		PartDefinition ToungeCorpseHeadTumor_r1 = ToungeCorpseHeadTumor.addOrReplaceChild("ToungeCorpseHeadTumor_r1", CubeListBuilder.create().texOffs(372, 274).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4393F, 0.0074F, -1.227F, 0.2856F, 0.5973F, -1.0896F));

		PartDefinition ToungeCorpseHeadTumor_r2 = ToungeCorpseHeadTumor.addOrReplaceChild("ToungeCorpseHeadTumor_r2", CubeListBuilder.create().texOffs(368, 269).addBox(-2.75F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0F, -1.0F, -2.0F, 0.5976F, 0.2849F, -0.3917F));

		PartDefinition LeftArm = LickerSeg3.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 279).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4854F, 0.8039F, -3.7358F, -0.7418F, 0.0F, -0.3054F));

		PartDefinition RightArm = LickerSeg3.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(162, 323).addBox(-1.0359F, -0.7439F, -1.0697F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5848F, -2.6479F, -4.2234F, -0.5236F, 0.0F, -0.9948F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create(), PartPose.offset(0.4624F, 4.1404F, 0.4303F));

		PartDefinition RightArmSeg2_r1 = RightArmSeg2.addOrReplaceChild("RightArmSeg2_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0018F, -0.1343F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition HeadFin = Head.addOrReplaceChild("HeadFin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r1 = HeadFin.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(108, 255).addBox(0.0F, -18.0F, -2.0F, 0.0F, 25.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -24.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = HeadFin.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(154, 278).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -27.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition CenterBaseGroup = FrontSeg1.addOrReplaceChild("CenterBaseGroup", CubeListBuilder.create().texOffs(92, 107).addBox(-12.0F, -4.2344F, -6.0F, 24.0F, 32.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.1727F, -11.5156F, 7.2967F));

		PartDefinition RightBottomBase_r3 = CenterBaseGroup.addOrReplaceChild("RightBottomBase_r3", CubeListBuilder.create().texOffs(48, 257).addBox(-4.0F, -8.5F, -11.0F, 8.0F, 17.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5804F, 18.3129F, 5.01F, 0.0F, 3.1416F, 0.4363F));

		PartDefinition RightTopBase_r3 = CenterBaseGroup.addOrReplaceChild("RightTopBase_r3", CubeListBuilder.create().texOffs(246, 74).addBox(-4.0F, -16.0F, -15.01F, 8.0F, 18.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.75F, 12.0156F, 9.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftBottomBase_r3 = CenterBaseGroup.addOrReplaceChild("LeftBottomBase_r3", CubeListBuilder.create().texOffs(246, 74).addBox(-4.0F, -1.0F, -14.99F, 8.0F, 17.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.75F, 11.5156F, 9.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftTopBase_r3 = CenterBaseGroup.addOrReplaceChild("LeftTopBase_r3", CubeListBuilder.create().texOffs(48, 257).addBox(-4.0F, -9.0F, -11.0F, 8.0F, 18.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.7917F, 5.6715F, 4.99F, 3.1416F, 0.0F, 0.4363F));

		PartDefinition TopRidge_r1 = CenterBaseGroup.addOrReplaceChild("TopRidge_r1", CubeListBuilder.create().texOffs(330, 219).addBox(-2.5F, -1.5F, -11.0F, 5.0F, 3.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.7344F, 5.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition CenterFin = CenterBaseGroup.addOrReplaceChild("CenterFin", CubeListBuilder.create(), PartPose.offset(14.75F, 11.5156F, 9.0F));

		PartDefinition FinsupportBack_r1 = CenterFin.addOrReplaceChild("FinsupportBack_r1", CubeListBuilder.create().texOffs(253, 453).addBox(-1.0F, -20.0F, -1.5F, 2.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.75F, -18.0F, 4.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition FinMemebrane4_r1 = CenterFin.addOrReplaceChild("FinMemebrane4_r1", CubeListBuilder.create().texOffs(244, 248).addBox(0.0F, -15.0F, -11.0F, 0.0F, 30.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.75F, -31.7055F, -2.2496F, -0.48F, 0.0F, 0.0F));

		PartDefinition FinsupportFront_r1 = CenterFin.addOrReplaceChild("FinsupportFront_r1", CubeListBuilder.create().texOffs(78, 129).addBox(-1.25F, -29.0F, -2.0F, 3.0F, 30.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -19.0F, -13.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition CenterFinTumor = CenterFin.addOrReplaceChild("CenterFinTumor", CubeListBuilder.create(), PartPose.offset(-15.6941F, -35.3885F, -9.5077F));

		PartDefinition Tumor2_r1 = CenterFinTumor.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(370, 277).addBox(-1.0F, -2.0F, -2.75F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.925F, -5.8469F, 1.8019F, -1.581F, -0.6458F, 1.0436F));

		PartDefinition Tumor1_r1 = CenterFinTumor.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(371, 277).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3059F, 7.3885F, -2.4923F, 0.0219F, -0.4253F, 0.1006F));

		PartDefinition CenterCorpseDetails = CenterBaseGroup.addOrReplaceChild("CenterCorpseDetails", CubeListBuilder.create(), PartPose.offset(14.75F, 11.5156F, 9.0F));

		PartDefinition CenterBody1 = CenterCorpseDetails.addOrReplaceChild("CenterBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg_r33 = CenterBody1.addOrReplaceChild("Leg_r33", CubeListBuilder.create().texOffs(265, 347).addBox(-1.5F, -4.75F, 0.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4423F, 0.867F, 2.4473F, 0.3488F, 0.0149F, -0.041F));

		PartDefinition Leg_r34 = CenterBody1.addOrReplaceChild("Leg_r34", CubeListBuilder.create().texOffs(329, 22).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5286F, -3.3013F, -1.75F, -0.218F, -0.0094F, -0.0426F));

		PartDefinition Arm_r53 = CenterBody1.addOrReplaceChild("Arm_r53", CubeListBuilder.create().texOffs(88, 359).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r27 = CenterBody1.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(245, 376).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r23 = CenterBody1.addOrReplaceChild("TorsoTop_r23", CubeListBuilder.create().texOffs(0, 323).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r29 = CenterBody1.addOrReplaceChild("TorsoBase_r29", CubeListBuilder.create().texOffs(451, 54).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition CenterBody2 = CenterCorpseDetails.addOrReplaceChild("CenterBody2", CubeListBuilder.create(), PartPose.offset(-24.0F, -16.0F, 0.0F));

		PartDefinition Arm_r54 = CenterBody2.addOrReplaceChild("Arm_r54", CubeListBuilder.create().texOffs(436, 444).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r55 = CenterBody2.addOrReplaceChild("Arm_r55", CubeListBuilder.create().texOffs(451, 23).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r14 = CenterBody2.addOrReplaceChild("TorsoBottom_r14", CubeListBuilder.create().texOffs(399, 430).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r15 = CenterBody2.addOrReplaceChild("TorsoBottom_r15", CubeListBuilder.create().texOffs(198, 439).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r24 = CenterBody2.addOrReplaceChild("TorsoTop_r24", CubeListBuilder.create().texOffs(418, 304).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody3 = CenterCorpseDetails.addOrReplaceChild("CenterBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(-32.5056F, -4.3398F, -3.3136F, 0.2154F, 0.6018F, 0.2843F));

		PartDefinition Leg_r35 = CenterBody3.addOrReplaceChild("Leg_r35", CubeListBuilder.create().texOffs(212, 347).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4032F, 4.788F, 2.3728F, -0.0397F, -0.0241F, -0.177F));

		PartDefinition Leg_r36 = CenterBody3.addOrReplaceChild("Leg_r36", CubeListBuilder.create().texOffs(256, 214).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.773F, 5.0385F, -2.4364F, -0.2132F, -0.0469F, -0.2132F));

		PartDefinition Arm_r56 = CenterBody3.addOrReplaceChild("Arm_r56", CubeListBuilder.create().texOffs(0, 358).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2343F, -6.4446F, 2.8873F, 2.007F, 0.9774F, 0.5593F));

		PartDefinition TorsoTop_r25 = CenterBody3.addOrReplaceChild("TorsoTop_r25", CubeListBuilder.create().texOffs(0, 323).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0056F, -0.6602F, -0.6864F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r30 = CenterBody3.addOrReplaceChild("TorsoBase_r30", CubeListBuilder.create().texOffs(382, 450).addBox(-1.75F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, 3.3398F, -0.1864F, 0.0411F, -0.3027F, 0.2555F));

		PartDefinition CenterBody4 = CenterCorpseDetails.addOrReplaceChild("CenterBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r31 = CenterBody4.addOrReplaceChild("TorsoBase_r31", CubeListBuilder.create().texOffs(198, 439).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r57 = CenterBody4.addOrReplaceChild("Arm_r57", CubeListBuilder.create().texOffs(446, 166).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r58 = CenterBody4.addOrReplaceChild("Arm_r58", CubeListBuilder.create().texOffs(318, 277).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r26 = CenterBody4.addOrReplaceChild("TorsoTop_r26", CubeListBuilder.create().texOffs(92, 420).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r28 = CenterBody4.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(365, 17).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterBody5 = CenterCorpseDetails.addOrReplaceChild("CenterBody5", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, 17.6707F, -1.6424F, -1.8521F, 1.4977F, -1.2895F));

		PartDefinition TorsoBase_r32 = CenterBody5.addOrReplaceChild("TorsoBase_r32", CubeListBuilder.create().texOffs(430, 183).addBox(-3.0F, -2.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -2.1988F, 3.3066F, 0.7795F, 0.461F, -0.0476F));

		PartDefinition Arm_r59 = CenterBody5.addOrReplaceChild("Arm_r59", CubeListBuilder.create().texOffs(409, 107).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.0611F, -0.2558F, -0.192F));

		PartDefinition Arm_r60 = CenterBody5.addOrReplaceChild("Arm_r60", CubeListBuilder.create().texOffs(284, 74).addBox(0.0019F, -1.9253F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.3089F, 0.9815F, 0.0943F));

		PartDefinition TorsoBottom_r16 = CenterBody5.addOrReplaceChild("TorsoBottom_r16", CubeListBuilder.create().texOffs(418, 0).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r29 = CenterBody5.addOrReplaceChild("Head_r29", CubeListBuilder.create().texOffs(362, 224).addBox(-3.5F, -3.25F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition CenterBody6 = CenterCorpseDetails.addOrReplaceChild("CenterBody6", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 9.5F, 3.0F, 0.4923F, 0.7566F, -0.2023F));

		PartDefinition Arm_r61 = CenterBody6.addOrReplaceChild("Arm_r61", CubeListBuilder.create().texOffs(0, 445).addBox(-2.6989F, -1.3885F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, 2.1266F, -2.0948F, -0.1321F, 0.6937F, -0.6672F));

		PartDefinition Arm_r62 = CenterBody6.addOrReplaceChild("Arm_r62", CubeListBuilder.create().texOffs(152, 413).addBox(-0.9834F, -1.2395F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, -0.0543F, -8.3035F, -2.845F, -0.717F, 2.6241F));

		PartDefinition TorsoTop_r27 = CenterBody6.addOrReplaceChild("TorsoTop_r27", CubeListBuilder.create().texOffs(446, 166).addBox(-3.6473F, -2.7889F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, -4.8781F, -1.2293F, -0.4207F, 1.4447F, -1.2856F));

		PartDefinition TorsoTop_r28 = CenterBody6.addOrReplaceChild("TorsoTop_r28", CubeListBuilder.create().texOffs(115, 425).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, -2.6983F, 0.7538F, 0.7071F, 0.6554F, -0.1855F));

		PartDefinition TorsoBottom_r17 = CenterBody6.addOrReplaceChild("TorsoBottom_r17", CubeListBuilder.create().texOffs(385, 419).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, 0.358F, 0.6554F, -0.1855F));

		PartDefinition BackSeg1 = CenterBaseGroup.addOrReplaceChild("BackSeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0773F, 11.9469F, 10.2033F, 0.0436F, 0.0F, 0.0F));

		PartDefinition BackSeg1BaseGroup = BackSeg1.addOrReplaceChild("BackSeg1BaseGroup", CubeListBuilder.create().texOffs(78, 161).addBox(-11.5F, -31.75F, -8.0F, 23.0F, 28.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(64, 335).addBox(-2.99F, -4.4572F, -6.0321F, 6.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.5687F, 2.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition RightBottomBase_r4 = BackSeg1BaseGroup.addOrReplaceChild("RightBottomBase_r4", CubeListBuilder.create().texOffs(296, 241).addBox(-3.0F, -7.5F, -10.0F, 6.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.003F, -11.109F, 2.01F, 0.0F, 0.0F, -2.7053F));

		PartDefinition RightTopBase_r4 = BackSeg1BaseGroup.addOrReplaceChild("RightTopBase_r4", CubeListBuilder.create().texOffs(296, 241).addBox(-3.0F, -15.0F, -15.01F, 6.0F, 16.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.75F, -16.5F, 7.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftBottomBase_r4 = BackSeg1BaseGroup.addOrReplaceChild("LeftBottomBase_r4", CubeListBuilder.create().texOffs(74, 297).addBox(-3.0F, -7.5F, -10.0F, 6.0F, 15.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.003F, -11.109F, 2.01F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftTopBase_r4 = BackSeg1BaseGroup.addOrReplaceChild("LeftTopBase_r4", CubeListBuilder.create().texOffs(74, 297).addBox(-3.0F, -15.0F, -15.01F, 6.0F, 16.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.75F, -16.5F, 7.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition BackSeg1Fin = BackSeg1BaseGroup.addOrReplaceChild("BackSeg1Fin", CubeListBuilder.create().texOffs(144, 161).addBox(-1.0F, -47.0F, 5.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinMemebrane5_r1 = BackSeg1Fin.addOrReplaceChild("FinMemebrane5_r1", CubeListBuilder.create().texOffs(48, 274).addBox(-0.01F, -9.0F, -10.0F, 0.0F, 20.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -44.0F, -3.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition FinMemebrane6_r1 = BackSeg1Fin.addOrReplaceChild("FinMemebrane6_r1", CubeListBuilder.create().texOffs(156, 41).addBox(0.0F, -1.0F, -3.0F, 0.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -40.0F, 10.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition BS1FTumor = BackSeg1Fin.addOrReplaceChild("BS1FTumor", CubeListBuilder.create(), PartPose.offset(-0.433F, -43.3595F, 6.6585F));

		PartDefinition Tumor_r3 = BS1FTumor.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(366, 278).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6459F, -0.5904F, -0.3972F));

		PartDefinition BS1CorpseDetials = BackSeg1BaseGroup.addOrReplaceChild("BS1CorpseDetials", CubeListBuilder.create(), PartPose.offset(-9.0F, -31.0F, 0.0F));

		PartDefinition BS1Body1 = BS1CorpseDetials.addOrReplaceChild("BS1Body1", CubeListBuilder.create().texOffs(423, 230).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg_r37 = BS1Body1.addOrReplaceChild("Leg_r37", CubeListBuilder.create().texOffs(365, 33).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r30 = BS1Body1.addOrReplaceChild("Head_r30", CubeListBuilder.create().texOffs(0, 378).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r63 = BS1Body1.addOrReplaceChild("Arm_r63", CubeListBuilder.create().texOffs(398, 429).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r29 = BS1Body1.addOrReplaceChild("TorsoTop_r29", CubeListBuilder.create().texOffs(421, 229).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition BS1Body2 = BS1CorpseDetials.addOrReplaceChild("BS1Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, 1.8293F, 0.3576F, 2.8959F, -1.018F, -1.3954F));

		PartDefinition Leg_r38 = BS1Body2.addOrReplaceChild("Leg_r38", CubeListBuilder.create().texOffs(120, 410).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.6994F, 0.3683F, -0.1703F));

		PartDefinition TorsoBase_r33 = BS1Body2.addOrReplaceChild("TorsoBase_r33", CubeListBuilder.create().texOffs(434, 71).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r64 = BS1Body2.addOrReplaceChild("Arm_r64", CubeListBuilder.create().texOffs(0, 445).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r65 = BS1Body2.addOrReplaceChild("Arm_r65", CubeListBuilder.create().texOffs(97, 419).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r30 = BS1Body2.addOrReplaceChild("TorsoTop_r30", CubeListBuilder.create().texOffs(418, 118).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r31 = BS1Body2.addOrReplaceChild("Head_r31", CubeListBuilder.create().texOffs(223, 391).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition BS1Body3 = BS1CorpseDetials.addOrReplaceChild("BS1Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, 20.8293F, 3.3576F, 0.6407F, -1.3191F, -2.0585F));

		PartDefinition TorsoBase_r34 = BS1Body3.addOrReplaceChild("TorsoBase_r34", CubeListBuilder.create().texOffs(386, 419).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r66 = BS1Body3.addOrReplaceChild("Arm_r66", CubeListBuilder.create().texOffs(97, 419).addBox(-1.359F, -1.0346F, -0.7294F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2454F, -2.6507F, -5.0053F, 2.8068F, 0.0334F, 3.07F));

		PartDefinition TorsoTop_r31 = BS1Body3.addOrReplaceChild("TorsoTop_r31", CubeListBuilder.create().texOffs(420, 365).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition BackSeg2 = BackSeg1.addOrReplaceChild("BackSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.5793F, 18.3576F, 0.0F, -0.0436F, 0.0F));

		PartDefinition BackSeg2BaseGroup = BackSeg2.addOrReplaceChild("BackSeg2BaseGroup", CubeListBuilder.create(), PartPose.offset(0.0F, -2.1813F, 7.5F));

		PartDefinition Base_r1 = BackSeg2BaseGroup.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(92, 38).addBox(-9.0F, -9.0F, -16.0F, 18.0F, 18.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Connectors = BackSeg2BaseGroup.addOrReplaceChild("Connectors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SconnectorSpinalRidge_r1 = Connectors.addOrReplaceChild("SconnectorSpinalRidge_r1", CubeListBuilder.create().texOffs(181, 345).addBox(-3.0F, -2.0F, -9.5F, 6.0F, 4.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.75F, -1.5F, 0.3491F, 0.0F, 0.0F));

		PartDefinition SWConnector_r1 = Connectors.addOrReplaceChild("SWConnector_r1", CubeListBuilder.create().texOffs(101, 348).addBox(-1.5F, -8.5F, -9.5F, 3.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7785F, 6.1071F, -2.7314F, 0.0F, 0.3491F, -0.7854F));

		PartDefinition SEConnector_r1 = Connectors.addOrReplaceChild("SEConnector_r1", CubeListBuilder.create().texOffs(101, 348).addBox(-1.5F, -8.7937F, -7.0F, 3.0F, 18.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3651F, 6.4009F, -4.4226F, 0.0F, -0.3491F, 0.7854F));

		PartDefinition Wconnector_r1 = Connectors.addOrReplaceChild("Wconnector_r1", CubeListBuilder.create().texOffs(211, 348).addBox(-1.0367F, -2.5F, -7.3082F, 3.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.3651F, -0.1509F, -1.9226F, 0.0F, 0.3142F, 0.0F));

		PartDefinition Econnector_r1 = Connectors.addOrReplaceChild("Econnector_r1", CubeListBuilder.create().texOffs(211, 348).addBox(-1.9633F, -2.5F, -7.3082F, 3.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.3651F, -0.1509F, -1.9226F, 0.0F, -0.3142F, 0.0F));

		PartDefinition NEConnector_r1 = Connectors.addOrReplaceChild("NEConnector_r1", CubeListBuilder.create().texOffs(261, 342).addBox(-0.5F, -8.0F, -9.0F, 3.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3651F, -6.4009F, -4.4226F, 0.0F, -0.3491F, -0.7854F));

		PartDefinition NconnectorSpinalRidge_r1 = Connectors.addOrReplaceChild("NconnectorSpinalRidge_r1", CubeListBuilder.create().texOffs(243, 211).addBox(-2.0F, -1.5F, -22.5F, 4.0F, 3.0F, 31.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.25F, -0.5F, -0.3491F, 0.0F, 0.0F));

		PartDefinition NWConnector_r1 = Connectors.addOrReplaceChild("NWConnector_r1", CubeListBuilder.create().texOffs(261, 342).addBox(-2.5F, -8.0F, -9.0F, 3.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.3651F, -6.4009F, -4.4226F, 0.0F, 0.3491F, 0.7854F));

		PartDefinition BackSeg2CorpseDetail = BackSeg2BaseGroup.addOrReplaceChild("BackSeg2CorpseDetail", CubeListBuilder.create(), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition BS2Body1 = BackSeg2CorpseDetail.addOrReplaceChild("BS2Body1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Leg_r39 = BS2Body1.addOrReplaceChild("Leg_r39", CubeListBuilder.create().texOffs(0, 410).addBox(-2.664F, -0.6064F, -2.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.9975F, 0.8001F, -0.5254F));

		PartDefinition TorsoBase_r35 = BS2Body1.addOrReplaceChild("TorsoBase_r35", CubeListBuilder.create().texOffs(420, 118).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r67 = BS2Body1.addOrReplaceChild("Arm_r67", CubeListBuilder.create().texOffs(0, 445).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r68 = BS2Body1.addOrReplaceChild("Arm_r68", CubeListBuilder.create().texOffs(318, 277).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3474F, 0.6507F, 0.0884F));

		PartDefinition TorsoTop_r32 = BS2Body1.addOrReplaceChild("TorsoTop_r32", CubeListBuilder.create().texOffs(421, 229).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r32 = BS2Body1.addOrReplaceChild("Head_r32", CubeListBuilder.create().texOffs(181, 368).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition BS2Body2 = BackSeg2CorpseDetail.addOrReplaceChild("BS2Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(11.0F, 8.0F, 0.0F, 0.0F, 0.9599F, 0.0F));

		PartDefinition Leg_r40 = BS2Body2.addOrReplaceChild("Leg_r40", CubeListBuilder.create().texOffs(321, 410).addBox(-1.0379F, -0.9393F, -1.027F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3206F, 5.5473F, 3.1334F, -2.647F, 0.492F, -0.7299F));

		PartDefinition TorsoBase_r36 = BS2Body2.addOrReplaceChild("TorsoBase_r36", CubeListBuilder.create().texOffs(420, 118).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r33 = BS2Body2.addOrReplaceChild("TorsoTop_r33", CubeListBuilder.create().texOffs(421, 51).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition BS2Body3 = BackSeg2CorpseDetail.addOrReplaceChild("BS2Body3", CubeListBuilder.create(), PartPose.offset(0.0F, 24.8414F, 0.0F));

		PartDefinition Leg_r41 = BS2Body3.addOrReplaceChild("Leg_r41", CubeListBuilder.create().texOffs(410, 285).addBox(-2.664F, -1.8936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -2.5592F, 4.5018F, 0.8843F, 0.9235F, -0.0354F));

		PartDefinition TorsoBase_r37 = BS2Body3.addOrReplaceChild("TorsoBase_r37", CubeListBuilder.create().texOffs(264, 436).addBox(-3.0F, -4.0F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -0.1988F, 4.3066F, 0.4485F, 0.4285F, -0.1972F));

		PartDefinition Arm_r69 = BS2Body3.addOrReplaceChild("Arm_r69", CubeListBuilder.create().texOffs(97, 419).addBox(-1.919F, -1.1697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.8807F, -0.4859F, -0.7511F));

		PartDefinition Arm_r70 = BS2Body3.addOrReplaceChild("Arm_r70", CubeListBuilder.create().texOffs(318, 277).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r18 = BS2Body3.addOrReplaceChild("TorsoBottom_r18", CubeListBuilder.create().texOffs(420, 365).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition BackSeg3 = BackSeg2.addOrReplaceChild("BackSeg3", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 19.0F));

		PartDefinition BackSeg3BaseGroup = BackSeg3.addOrReplaceChild("BackSeg3BaseGroup", CubeListBuilder.create().texOffs(356, 62).addBox(0.0F, -5.75F, -6.0F, 8.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 6.5F));

		PartDefinition BottomConnector_r1 = BackSeg3BaseGroup.addOrReplaceChild("BottomConnector_r1", CubeListBuilder.create().texOffs(31, 395).addBox(-3.0F, 1.2826F, -9.5307F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4894F, -0.5106F, -1.5555F, 0.4363F, 0.0F, 0.0F));

		PartDefinition TopConnector_r2 = BackSeg3BaseGroup.addOrReplaceChild("TopConnector_r2", CubeListBuilder.create().texOffs(30, 394).addBox(-3.0F, -5.2826F, -9.5307F, 7.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4894F, -0.5106F, -1.5555F, -0.4363F, 0.0F, 0.0F));

		PartDefinition LeftConnectorBone = BackSeg3BaseGroup.addOrReplaceChild("LeftConnectorBone", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LConnectorArm_r1 = LeftConnectorBone.addOrReplaceChild("LConnectorArm_r1", CubeListBuilder.create().texOffs(429, 327).addBox(-1.6797F, -3.5F, -1.4521F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8259F, -3.75F, -5.026F, 0.3491F, 0.6458F, 0.0F));

		PartDefinition LeftConnectorTorsoBase_r1 = LeftConnectorBone.addOrReplaceChild("LeftConnectorTorsoBase_r1", CubeListBuilder.create().texOffs(155, 451).addBox(-1.5F, -3.75F, -1.25F, 4.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(376, 429).addBox(-2.0F, -4.25F, -7.25F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2967F, 0.0F));

		PartDefinition RightConnectorBone = BackSeg3BaseGroup.addOrReplaceChild("RightConnectorBone", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, 0.0F));

		PartDefinition RightConnector_r1 = RightConnectorBone.addOrReplaceChild("RightConnector_r1", CubeListBuilder.create().texOffs(38, 355).addBox(-3.0F, -5.25F, -9.25F, 4.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2967F, 0.0F));

		PartDefinition Tail = BackSeg3.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftTail = Tail.addOrReplaceChild("LeftTail", CubeListBuilder.create().texOffs(244, 219).addBox(-0.5F, -13.0F, 2.0F, 0.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5929F, 10.6313F, 0.2618F, -0.7418F, 0.0F));

		PartDefinition BottomBase_r1 = LeftTail.addOrReplaceChild("BottomBase_r1", CubeListBuilder.create().texOffs(331, 330).addBox(-1.5F, -2.0F, -2.4142F, 2.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5718F, 1.3687F, -0.4363F, 0.0F, 0.0F));

		PartDefinition TopBase_r1 = LeftTail.addOrReplaceChild("TopBase_r1", CubeListBuilder.create().texOffs(0, 331).addBox(-1.5F, -0.7544F, -2.3927F, 2.0F, 3.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4071F, 1.3687F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LTailTumorTop = LeftTail.addOrReplaceChild("LTailTumorTop", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.29F, -9.7966F, 14.7654F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Tumor_r4 = LTailTumorTop.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(367, 274).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8478F, -0.7654F, -0.3927F, 0.0F, 0.0F));

		PartDefinition MiddleTail = Tail.addOrReplaceChild("MiddleTail", CubeListBuilder.create().texOffs(0, 90).addBox(0.0F, -29.0F, -1.0F, 0.0F, 53.0F, 39.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.9789F, 13.0F));

		PartDefinition BottomBaseSeg2_r1 = MiddleTail.addOrReplaceChild("BottomBaseSeg2_r1", CubeListBuilder.create().texOffs(326, 66).addBox(-1.5F, -2.0F, 10.5858F, 3.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition TopBaseSeg3TorsoTop_r1 = MiddleTail.addOrReplaceChild("TopBaseSeg3TorsoTop_r1", CubeListBuilder.create().texOffs(412, 74).addBox(-4.0F, -2.7544F, 28.6073F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(48, 434).addBox(-3.5F, -2.2706F, 22.6073F, 7.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(266, 164).addBox(-1.5F, -2.2606F, -2.3927F, 3.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.9789F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Arm = MiddleTail.addOrReplaceChild("Arm", CubeListBuilder.create().texOffs(253, 84).addBox(-3.0F, -2.25F, -1.5F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -26.9789F, 26.0F));

		PartDefinition Leg = MiddleTail.addOrReplaceChild("Leg", CubeListBuilder.create(), PartPose.offset(0.96F, -22.0022F, 20.2905F));

		PartDefinition Leg_r42 = Leg.addOrReplaceChild("Leg_r42", CubeListBuilder.create().texOffs(36, 279).addBox(-2.2352F, -0.5088F, -1.1808F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.04F, -0.9978F, -1.2905F, -0.5558F, -0.268F, -0.4031F));

		PartDefinition TopCorpseHead = MiddleTail.addOrReplaceChild("TopCorpseHead", CubeListBuilder.create(), PartPose.offset(0.0F, -26.7411F, 30.1925F));

		PartDefinition Jaw_r12 = TopCorpseHead.addOrReplaceChild("Jaw_r12", CubeListBuilder.create().texOffs(336, 330).addBox(-2.2916F, -6.7728F, -0.7892F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5176F, 0.2751F, -0.6502F));

		PartDefinition Head_r33 = TopCorpseHead.addOrReplaceChild("Head_r33", CubeListBuilder.create().texOffs(80, 396).addBox(-4.0F, -4.7367F, 1.1782F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.3431F, 0.2751F, -0.6502F));

		PartDefinition BottomCorpse = MiddleTail.addOrReplaceChild("BottomCorpse", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TorsoTop_r34 = BottomCorpse.addOrReplaceChild("TorsoTop_r34", CubeListBuilder.create().texOffs(424, 205).addBox(-3.99F, -2.0F, 4.5858F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(443, 45).addBox(-3.49F, -1.5F, -1.4142F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition BottomCorpseRightArm = BottomCorpse.addOrReplaceChild("BottomCorpseRightArm", CubeListBuilder.create(), PartPose.offset(3.76F, 6.7782F, 6.7782F));

		PartDefinition RightArm_r1 = BottomCorpseRightArm.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(330, 150).addBox(0.25F, -1.5F, -1.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -1.6581F, 0.0F, 0.0F));

		PartDefinition BottomHead = BottomCorpse.addOrReplaceChild("BottomHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.3904F, 10.0036F, 0.5236F, 0.0F, 0.0F));

		PartDefinition HeadBottom_r1 = BottomHead.addOrReplaceChild("HeadBottom_r1", CubeListBuilder.create().texOffs(383, 338).addBox(-4.0F, -3.7412F, 1.6199F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.1404F, -3.0036F, -0.7854F, 0.0F, 0.0F));

		PartDefinition JawBottom_r1 = BottomHead.addOrReplaceChild("JawBottom_r1", CubeListBuilder.create().texOffs(230, 146).addBox(-4.0F, 0.1666F, -1.1785F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.2587F, -3.3217F, -1.5272F, 0.0F, 0.0F));

		PartDefinition RightTail = Tail.addOrReplaceChild("RightTail", CubeListBuilder.create().texOffs(92, 190).addBox(0.5F, -11.0F, 2.0F, 0.0F, 22.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.5929F, 10.6313F, -0.2618F, 0.7418F, 0.0F));

		PartDefinition BottomBase_r2 = RightTail.addOrReplaceChild("BottomBase_r2", CubeListBuilder.create().texOffs(0, 358).addBox(-0.5F, -2.0F, -2.4142F, 2.0F, 3.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.5718F, 1.3687F, -0.4363F, 0.0F, 0.0F));

		PartDefinition TopBase_r2 = RightTail.addOrReplaceChild("TopBase_r2", CubeListBuilder.create().texOffs(294, 307).addBox(-0.5F, 0.2456F, -2.3927F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.4071F, 1.3687F, 0.4363F, 0.0F, 0.0F));

		PartDefinition RTailTumor = RightTail.addOrReplaceChild("RTailTumor", CubeListBuilder.create(), PartPose.offset(1.1121F, 8.4467F, 11.8977F));

		PartDefinition Tumor_r5 = RTailTumor.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(383, 281).addBox(-1.5F, -1.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1121F, 0.125F, 0.471F, -0.3383F, -0.0543F, 0.5776F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.Gazenbreacher.y = -0.2f;
		this.TopJaw.xRot = -0.2f + Mth.cos(ageInTicks/8)/10;
		this.RightJaw.xRot = Mth.sin(ageInTicks/7)/5;
		this.LeftJaw.xRot = Mth.sin(ageInTicks/7)/6;
		this.LeftFin.yRot = 0.75f+Mth.cos(ageInTicks/8)/10;
		this.RightFin.yRot = -0.75f+Mth.cos(ageInTicks/8)/10;

		this.BackLeftFin.xRot = Mth.cos(ageInTicks/5)/5;
		this.BackRightFin.xRot = -Mth.cos(ageInTicks/6)/6;

		this.Tumors.xScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tumors.zScale = 1f + Mth.sin(ageInTicks/8)/4;
		this.Tumors.yScale = 1f + Mth.sin(ageInTicks/8)/4;

		if (entity.getTongueHp() <= 0){
			this.Licker1.visible = false;
			this.Tumors.visible = false;
		}else{
			this.Tumors.visible = true;
			this.Licker1.visible = true;
			this.Licker1.yRot = Mth.sin(ageInTicks/7)/8;
			this.Licker2.xRot = Mth.sin(ageInTicks/9)/8;
			this.RightArm.xRot = Mth.cos(ageInTicks/5)/6;
			this.LeftArm.xRot = -Mth.cos(ageInTicks/6)/5;

			this.Head.zRot = Mth.sin(ageInTicks/8)/8;
		}


		if (entity.isInFluidType()){
			this.RightLeg.yRot =1.8f + Mth.cos(ageInTicks/6)/6;
			this.LeftLeg.yRot =-1.8f + Mth.cos(ageInTicks/6)/6;
			this.Segment2.yRot = Mth.cos(ageInTicks/8)/10;
			this.Segment3.yRot = Mth.cos(ageInTicks/8)/10;
		}

		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (entity.isInFluidType()){
				this.Segment2.yRot = Mth.cos(ageInTicks/6)/6;
				this.Segment3.yRot = Mth.cos(ageInTicks/6)/6;
			}
			else{
				this.RightLeg.xRot = Mth.cos(limbSwing * 0.2F) * -1F * limbSwingAmount;
				this.RightLeg.yRot = Mth.cos(limbSwing * 0.2F) * -0.2F * limbSwingAmount;


				this.LeftLeg.xRot = Mth.sin(limbSwing * 0.2F) * 0.8F * limbSwingAmount;
				this.LeftLeg.yRot = Mth.sin(limbSwing * 0.2F) * -0.4F * limbSwingAmount;


				this.SmolL1.yRot = Mth.sin(limbSwing * 0.2F) * -0.7F * limbSwingAmount;
				this.SmolL2.yRot = Mth.sin(limbSwing * 0.2F) * 0.8F * limbSwingAmount;
				this.SmolL3.yRot = Mth.sin(limbSwing * 0.2F) * -0.6F * limbSwingAmount;
				this.Segment2.yRot = Mth.cos(ageInTicks/8)/10;
				this.Segment3.yRot = Mth.cos(ageInTicks/8)/10;
			}
		}else if (!entity.isInFluidType()){
			this.Segment2.zRot = 0.35f;
			this.Segment3.zRot = 0.35f;
			this.Segment4.zRot = 0.35f;
			this.Segment4.xRot = Mth.cos(ageInTicks/8)/8;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Gazenbreacher.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.Gazenbreacher;
	}
}