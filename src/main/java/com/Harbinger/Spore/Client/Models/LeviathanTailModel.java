package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.BaseEntities.LeviathanMultipart;
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

public class LeviathanTailModel<T extends LeviathanMultipart> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "leviathantail"), "main");
	private int stir = 0;
	public final ModelPart LeviathanAbdomen;
	private final ModelPart Base;
	private final ModelPart tail;
	private final ModelPart fin2;
	private final ModelPart tailFlipper;
	private final ModelPart rightTailFlipper;
	private final ModelPart CenterBody19;
	private final ModelPart CenterBody20;
	private final ModelPart CenterBody21;
	private final ModelPart Body10;
	private final ModelPart leftTailFlipper;
	private final ModelPart CenterBody22;
	private final ModelPart CenterBody23;
	private final ModelPart CenterCorpseDetails3;
	private final ModelPart CenterBody7;
	private final ModelPart CenterBody8;
	private final ModelPart CenterBody9;
	private final ModelPart CenterBody10;
	private final ModelPart CenterCorpseDetails5;
	private final ModelPart CenterBody11;
	private final ModelPart CenterBody12;
	private final ModelPart CenterBody17;
	private final ModelPart CenterBody18;
	private final ModelPart fin;
	private final ModelPart CenterCorpseDetails;
	private final ModelPart CenterBody1;
	private final ModelPart CenterBody2;
	private final ModelPart CenterBody4;
	private final ModelPart CenterCorpseDetails2;
	private final ModelPart CenterBody3;
	private final ModelPart CenterBody5;
	private final ModelPart CenterBody6;
	private final ModelPart CenterCorpseDetails4;
	private final ModelPart CenterBody13;
	private final ModelPart CenterBody14;
	private final ModelPart CenterBody15;
	private final ModelPart CenterBody16;
	private final ModelPart Tumors;
	private final ModelPart Tumor;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Tumor5;
	private final ModelPart Tumor6;
	private final ModelPart Tumor7;
	private final ModelPart Tumor8;

	public LeviathanTailModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.LeviathanAbdomen = root.getChild("LeviathanAbdomen");
		this.Base = this.LeviathanAbdomen.getChild("Base");
		this.tail = this.Base.getChild("tail");
		this.fin2 = this.tail.getChild("fin2");
		this.tailFlipper = this.tail.getChild("tailFlipper");
		this.rightTailFlipper = this.tailFlipper.getChild("rightTailFlipper");
		this.CenterBody19 = this.rightTailFlipper.getChild("CenterBody19");
		this.CenterBody20 = this.rightTailFlipper.getChild("CenterBody20");
		this.CenterBody21 = this.rightTailFlipper.getChild("CenterBody21");
		this.Body10 = this.rightTailFlipper.getChild("Body10");
		this.leftTailFlipper = this.tailFlipper.getChild("leftTailFlipper");
		this.CenterBody22 = this.leftTailFlipper.getChild("CenterBody22");
		this.CenterBody23 = this.leftTailFlipper.getChild("CenterBody23");
		this.CenterCorpseDetails3 = this.tail.getChild("CenterCorpseDetails3");
		this.CenterBody7 = this.CenterCorpseDetails3.getChild("CenterBody7");
		this.CenterBody8 = this.CenterCorpseDetails3.getChild("CenterBody8");
		this.CenterBody9 = this.CenterCorpseDetails3.getChild("CenterBody9");
		this.CenterBody10 = this.CenterCorpseDetails3.getChild("CenterBody10");
		this.CenterCorpseDetails5 = this.tail.getChild("CenterCorpseDetails5");
		this.CenterBody11 = this.CenterCorpseDetails5.getChild("CenterBody11");
		this.CenterBody12 = this.CenterCorpseDetails5.getChild("CenterBody12");
		this.CenterBody17 = this.CenterCorpseDetails5.getChild("CenterBody17");
		this.CenterBody18 = this.CenterCorpseDetails5.getChild("CenterBody18");
		this.fin = this.Base.getChild("fin");
		this.CenterCorpseDetails = this.Base.getChild("CenterCorpseDetails");
		this.CenterBody1 = this.CenterCorpseDetails.getChild("CenterBody1");
		this.CenterBody2 = this.CenterCorpseDetails.getChild("CenterBody2");
		this.CenterBody4 = this.CenterCorpseDetails.getChild("CenterBody4");
		this.CenterCorpseDetails2 = this.Base.getChild("CenterCorpseDetails2");
		this.CenterBody3 = this.CenterCorpseDetails2.getChild("CenterBody3");
		this.CenterBody5 = this.CenterCorpseDetails2.getChild("CenterBody5");
		this.CenterBody6 = this.CenterCorpseDetails2.getChild("CenterBody6");
		this.CenterCorpseDetails4 = this.Base.getChild("CenterCorpseDetails4");
		this.CenterBody13 = this.CenterCorpseDetails4.getChild("CenterBody13");
		this.CenterBody14 = this.CenterCorpseDetails4.getChild("CenterBody14");
		this.CenterBody15 = this.CenterCorpseDetails4.getChild("CenterBody15");
		this.CenterBody16 = this.CenterCorpseDetails4.getChild("CenterBody16");
		this.Tumors = this.Base.getChild("Tumors");
		this.Tumor = this.Tumors.getChild("Tumor");
		this.Tumor2 = this.Tumors.getChild("Tumor2");
		this.Tumor3 = this.Tumors.getChild("Tumor3");
		this.Tumor4 = this.Tumors.getChild("Tumor4");
		this.Tumor5 = this.Tumors.getChild("Tumor5");
		this.Tumor6 = this.Tumors.getChild("Tumor6");
		this.Tumor7 = this.Tumors.getChild("Tumor7");
		this.Tumor8 = this.Tumors.getChild("Tumor8");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeviathanAbdomen = partdefinition.addOrReplaceChild("LeviathanAbdomen", CubeListBuilder.create(), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition Base = LeviathanAbdomen.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.0F, -50.0F, 1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition front_r1 = Base.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(194, 322).addBox(-1.0F, 19.0F, -1.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 7.0F, 18.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r2 = Base.addOrReplaceChild("front_r2", CubeListBuilder.create().texOffs(160, 321).addBox(-1.0F, 19.0F, -1.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 7.0F, -28.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r3 = Base.addOrReplaceChild("front_r3", CubeListBuilder.create().texOffs(306, 168).addBox(-1.0F, 13.0F, -1.0F, 17.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, 18.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r4 = Base.addOrReplaceChild("front_r4", CubeListBuilder.create().texOffs(308, 306).addBox(-1.0F, 13.0F, -1.0F, 17.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -27.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition s_r1 = Base.addOrReplaceChild("s_r1", CubeListBuilder.create().texOffs(0, 54).addBox(-21.0F, 0.0F, -28.0F, 22.0F, 4.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9653F, 14.7965F, -0.0603F, -0.1262F, 0.0715F, -1.36F));

		PartDefinition s_r2 = Base.addOrReplaceChild("s_r2", CubeListBuilder.create().texOffs(0, 107).addBox(-3.5114F, -27.7797F, -25.923F, 20.0F, 5.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0183F, 41.2622F, -0.9557F, 0.066F, 0.0418F, 0.1702F));

		PartDefinition s2_r1 = Base.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(214, 212).addBox(-0.5F, 4.0F, 0.0F, 17.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.4901F, 15.9404F, -4.5601F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s1_r1 = Base.addOrReplaceChild("s1_r1", CubeListBuilder.create().texOffs(130, 212).addBox(0.5F, 0.0F, -2.0F, 16.0F, 4.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.9209F, 18.5215F, -28.1892F, 0.209F, 0.0442F, 1.1759F));

		PartDefinition s_r3 = Base.addOrReplaceChild("s_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5525F, 24.9337F, -25.5293F, 24.0F, 4.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9817F, 11.2622F, -2.9557F, 0.0494F, 0.1308F, 0.044F));

		PartDefinition s_r4 = Base.addOrReplaceChild("s_r4", CubeListBuilder.create().texOffs(142, 54).addBox(-3.6818F, 21.2121F, -25.5293F, 11.0F, 4.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 19.2622F, -0.9557F, -0.0887F, 0.0964F, -0.746F));

		PartDefinition tail = Base.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(148, 0).addBox(-9.3743F, 9.0553F, 0.4776F, 20.0F, 3.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4901F, 27.9404F, 15.4399F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(264, 102).addBox(-3.0F, -3.0F, -14.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -1.0F, 44.0F, -0.0106F, 0.1383F, 0.8079F));

		PartDefinition s_r5 = tail.addOrReplaceChild("s_r5", CubeListBuilder.create().texOffs(138, 107).addBox(-11.1878F, -0.0389F, -2.9181F, 23.0F, 5.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5084F, 1.3218F, 1.6044F, -0.1134F, 0.0524F, -1.0191F));

		PartDefinition s2_r2 = tail.addOrReplaceChild("s2_r2", CubeListBuilder.create().texOffs(138, 152).addBox(-7.5F, 0.0F, 0.0F, 19.0F, 4.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -2.0F, 0.0F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition fin2 = tail.addOrReplaceChild("fin2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2599F, 19.8096F, 22.5601F, -0.6109F, 0.1309F, 0.0F));

		PartDefinition FinMembrane1_r1 = fin2.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(272, 0).addBox(-0.01F, -13.0F, -2.0F, 0.0F, 14.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -24.0F, 0.4887F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = fin2.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(432, 65).addBox(-1.0F, -10.0F, -2.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -7.0F, 0.3578F, 0.0F, 0.0F));

		PartDefinition FinSupport_r2 = fin2.addOrReplaceChild("FinSupport_r2", CubeListBuilder.create().texOffs(429, 65).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, -26.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition tailFlipper = tail.addOrReplaceChild("tailFlipper", CubeListBuilder.create(), PartPose.offset(2.0F, 5.0F, 44.0F));

		PartDefinition rightTailFlipper = tailFlipper.addOrReplaceChild("rightTailFlipper", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FinMemebrane2_r1 = rightTailFlipper.addOrReplaceChild("FinMemebrane2_r1", CubeListBuilder.create().texOffs(162, 242).addBox(-0.1F, -28.0F, -6.0F, 0.0F, 33.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.4901F, 1.3096F, 21.5601F, -0.48F, 0.0F, -1.5708F));

		PartDefinition FinMemebrane2_r2 = rightTailFlipper.addOrReplaceChild("FinMemebrane2_r2", CubeListBuilder.create().texOffs(214, 240).addBox(-0.1F, -25.0F, -3.0F, 0.0F, 27.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-79.4901F, 1.3096F, 29.5601F, 0.3054F, 0.0F, -1.5708F));

		PartDefinition FinMemebrane2_r3 = rightTailFlipper.addOrReplaceChild("FinMemebrane2_r3", CubeListBuilder.create().texOffs(0, 213).addBox(0.0F, -28.0F, -3.0F, 0.0F, 30.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-54.4901F, 1.3096F, 27.5601F, -0.0436F, 0.0F, -1.5708F));

		PartDefinition FinMemebrane2_r4 = rightTailFlipper.addOrReplaceChild("FinMemebrane2_r4", CubeListBuilder.create().texOffs(268, 240).addBox(0.0F, -23.0F, -3.0F, 0.0F, 25.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4901F, 1.3096F, 7.5601F, -0.48F, 0.0F, -1.5708F));

		PartDefinition FinSupport_r3 = rightTailFlipper.addOrReplaceChild("FinSupport_r3", CubeListBuilder.create().texOffs(88, 270).addBox(-2.0F, -20.0F, -3.0F, 4.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-103.4901F, 2.5596F, 26.5601F, -1.5708F, -0.3491F, 0.0F));

		PartDefinition FinSupport_r4 = rightTailFlipper.addOrReplaceChild("FinSupport_r4", CubeListBuilder.create().texOffs(18, 316).addBox(-2.0F, -28.0F, -4.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.4901F, 2.5596F, 25.5601F, -1.5708F, -0.0873F, 0.0F));

		PartDefinition FinSupport_r5 = rightTailFlipper.addOrReplaceChild("FinSupport_r5", CubeListBuilder.create().texOffs(250, 294).addBox(-2.0F, -33.0F, -4.0F, 4.0F, 33.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-51.4901F, 2.5596F, 22.5601F, -1.5708F, 0.0436F, 0.0F));

		PartDefinition FinSupport_r6 = rightTailFlipper.addOrReplaceChild("FinSupport_r6", CubeListBuilder.create().texOffs(0, 316).addBox(-2.0F, -28.0F, -4.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.4901F, 2.5596F, 10.5601F, -1.5708F, 0.2182F, 0.0F));

		PartDefinition FinSupport_r7 = rightTailFlipper.addOrReplaceChild("FinSupport_r7", CubeListBuilder.create().texOffs(108, 213).addBox(-2.0F, -24.0F, -4.0F, 4.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.4901F, 2.5596F, 1.5601F, -1.5708F, 0.3054F, 0.0F));

		PartDefinition cube_r2 = rightTailFlipper.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(130, 196).addBox(-54.0F, -1.0F, -5.0F, 55.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-51.0F, -1.0F, 19.0F, 0.0F, 0.0873F, 0.0F));

		PartDefinition cube_r3 = rightTailFlipper.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 161).addBox(-54.0F, -3.0F, -5.0F, 55.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition CenterBody19 = rightTailFlipper.addOrReplaceChild("CenterBody19", CubeListBuilder.create(), PartPose.offsetAndRotation(-37.567F, -2.858F, 11.7969F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r1 = CenterBody19.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r1 = CenterBody19.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r2 = CenterBody19.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r1 = CenterBody19.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r1 = CenterBody19.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterBody20 = rightTailFlipper.addOrReplaceChild("CenterBody20", CubeListBuilder.create(), PartPose.offsetAndRotation(-89.8114F, -1.0271F, 19.1257F, -0.3903F, 0.6616F, -1.5115F));

		PartDefinition Leg_r1 = CenterBody20.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r2 = CenterBody20.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r3 = CenterBody20.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r2 = CenterBody20.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r2 = CenterBody20.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody21 = rightTailFlipper.addOrReplaceChild("CenterBody21", CubeListBuilder.create(), PartPose.offsetAndRotation(-96.8114F, -1.0271F, 24.1257F, -3.0648F, 0.4007F, -1.5367F));

		PartDefinition Leg_r3 = CenterBody21.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r4 = CenterBody21.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r4 = CenterBody21.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r3 = CenterBody21.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r3 = CenterBody21.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition Body10 = rightTailFlipper.addOrReplaceChild("Body10", CubeListBuilder.create().texOffs(480, 5).addBox(-5.0F, -4.0F, 3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-65.5735F, -0.6991F, 20.3034F, -2.6162F, -0.9874F, -0.8932F));

		PartDefinition Torso_r1 = Body10.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Arm_r5 = Body10.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(480, 5).addBox(0.0948F, -1.1342F, -1.0F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition leftTailFlipper = tailFlipper.addOrReplaceChild("leftTailFlipper", CubeListBuilder.create(), PartPose.offset(0.0197F, -0.5F, 0.0F));

		PartDefinition FinMemebrane2_r5 = leftTailFlipper.addOrReplaceChild("FinMemebrane2_r5", CubeListBuilder.create().texOffs(260, 45).addBox(0.1F, -28.0F, -6.0F, 0.0F, 33.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.4901F, 1.3096F, 21.5601F, -0.48F, 0.0F, 1.5708F));

		PartDefinition FinMemebrane2_r6 = leftTailFlipper.addOrReplaceChild("FinMemebrane2_r6", CubeListBuilder.create().texOffs(108, 242).addBox(0.1F, -25.0F, -3.0F, 0.0F, 27.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(79.4901F, 1.3096F, 29.5601F, 0.3054F, 0.0F, 1.5708F));

		PartDefinition FinMemebrane2_r7 = leftTailFlipper.addOrReplaceChild("FinMemebrane2_r7", CubeListBuilder.create().texOffs(54, 213).addBox(0.0F, -28.0F, -3.0F, 0.0F, 30.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(54.4901F, 1.3096F, 27.5601F, -0.0436F, 0.0F, 1.5708F));

		PartDefinition FinMemebrane2_r8 = leftTailFlipper.addOrReplaceChild("FinMemebrane2_r8", CubeListBuilder.create().texOffs(0, 270).addBox(0.0F, -23.0F, -3.0F, 0.0F, 25.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4901F, 1.3096F, 7.5601F, -0.48F, 0.0F, 1.5708F));

		PartDefinition FinSupport_r8 = leftTailFlipper.addOrReplaceChild("FinSupport_r8", CubeListBuilder.create().texOffs(194, 299).addBox(-2.0F, -20.0F, -3.0F, 4.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(103.4901F, 2.5596F, 26.5601F, -1.5708F, 0.3491F, 0.0F));

		PartDefinition FinSupport_r9 = leftTailFlipper.addOrReplaceChild("FinSupport_r9", CubeListBuilder.create().texOffs(78, 318).addBox(-2.0F, -28.0F, -4.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(80.4901F, 2.5596F, 25.5601F, -1.5708F, 0.0873F, 0.0F));

		PartDefinition FinSupport_r10 = leftTailFlipper.addOrReplaceChild("FinSupport_r10", CubeListBuilder.create().texOffs(176, 299).addBox(-2.0F, -33.0F, -4.0F, 4.0F, 33.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(51.4901F, 2.5596F, 22.5601F, -1.5708F, -0.0436F, 0.0F));

		PartDefinition FinSupport_r11 = leftTailFlipper.addOrReplaceChild("FinSupport_r11", CubeListBuilder.create().texOffs(318, 0).addBox(-2.0F, -28.0F, -4.0F, 4.0F, 28.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.4901F, 2.5596F, 10.5601F, -1.5708F, -0.2182F, 0.0F));

		PartDefinition FinSupport_r12 = leftTailFlipper.addOrReplaceChild("FinSupport_r12", CubeListBuilder.create().texOffs(282, 333).addBox(-2.0F, -24.0F, -4.0F, 4.0F, 24.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4901F, 2.5596F, 1.5601F, -1.5708F, -0.3054F, 0.0F));

		PartDefinition cube_r4 = leftTailFlipper.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 197).addBox(-1.0F, -1.0F, -5.0F, 55.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(51.0F, -1.0F, 19.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition cube_r5 = leftTailFlipper.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 179).addBox(-1.0F, -3.0F, -5.0F, 55.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition CenterBody22 = leftTailFlipper.addOrReplaceChild("CenterBody22", CubeListBuilder.create(), PartPose.offsetAndRotation(46.4132F, -1.358F, 12.7969F, 2.1773F, -1.0619F, -1.604F));

		PartDefinition TorsoBase_r4 = CenterBody22.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(436, 4).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r6 = CenterBody22.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(436, 4).addBox(-1.081F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r7 = CenterBody22.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(436, 4).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r4 = CenterBody22.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(436, 4).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r2 = CenterBody22.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(436, 4).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterBody23 = leftTailFlipper.addOrReplaceChild("CenterBody23", CubeListBuilder.create(), PartPose.offsetAndRotation(99.1688F, 0.4729F, 20.1257F, -0.8108F, 1.1438F, -2.0278F));

		PartDefinition Leg_r5 = CenterBody23.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(436, 4).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.788F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r6 = CenterBody23.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(436, 4).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, 0.2232F, 0.0469F, 0.2132F));

		PartDefinition Arm_r8 = CenterBody23.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(436, 4).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r5 = CenterBody23.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(436, 4).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r5 = CenterBody23.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(436, 4).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterCorpseDetails3 = tail.addOrReplaceChild("CenterCorpseDetails3", CubeListBuilder.create(), PartPose.offsetAndRotation(9.8371F, 0.8096F, 22.8568F, 0.3174F, 1.1474F, 1.5811F));

		PartDefinition CenterBody7 = CenterCorpseDetails3.addOrReplaceChild("CenterBody7", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r9 = CenterBody7.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(437, 5).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r3 = CenterBody7.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r6 = CenterBody7.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(437, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody8 = CenterCorpseDetails3.addOrReplaceChild("CenterBody8", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4969F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r10 = CenterBody8.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(437, 5).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r11 = CenterBody8.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(437, 5).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r1 = CenterBody8.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(437, 5).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r2 = CenterBody8.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(437, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r7 = CenterBody8.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody9 = CenterCorpseDetails3.addOrReplaceChild("CenterBody9", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, -1.8367F, 0.2689F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r7 = CenterBody9.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(437, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.7879F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r8 = CenterBody9.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(437, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r12 = CenterBody9.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(437, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r8 = CenterBody9.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(437, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r6 = CenterBody9.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(437, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody10 = CenterCorpseDetails3.addOrReplaceChild("CenterBody10", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3324F, -2.0599F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r7 = CenterBody10.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r13 = CenterBody10.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(437, 5).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r14 = CenterBody10.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(437, 5).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r9 = CenterBody10.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r4 = CenterBody10.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(437, 5).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition CenterCorpseDetails5 = tail.addOrReplaceChild("CenterCorpseDetails5", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.1629F, -0.1904F, 27.8568F, -3.0772F, 1.1644F, 2.1646F));

		PartDefinition CenterBody11 = CenterCorpseDetails5.addOrReplaceChild("CenterBody11", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r15 = CenterBody11.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(437, 5).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r5 = CenterBody11.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r10 = CenterBody11.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(437, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody12 = CenterCorpseDetails5.addOrReplaceChild("CenterBody12", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4968F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r16 = CenterBody12.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(437, 5).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r17 = CenterBody12.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(437, 5).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r3 = CenterBody12.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(437, 5).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r4 = CenterBody12.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(437, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r11 = CenterBody12.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody17 = CenterCorpseDetails5.addOrReplaceChild("CenterBody17", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, -1.8367F, 0.2689F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r9 = CenterBody17.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(437, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.7879F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r10 = CenterBody17.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(437, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r18 = CenterBody17.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(437, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r12 = CenterBody17.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(437, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r8 = CenterBody17.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(437, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody18 = CenterCorpseDetails5.addOrReplaceChild("CenterBody18", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3324F, -2.0599F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r9 = CenterBody18.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r19 = CenterBody18.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(437, 5).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r20 = CenterBody18.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(437, 5).addBox(-3.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r13 = CenterBody18.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(437, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r6 = CenterBody18.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(437, 5).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.4599F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition fin = Base.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offsetAndRotation(7.75F, 42.75F, -9.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r2 = fin.addOrReplaceChild("FinMembrane1_r2", CubeListBuilder.create().texOffs(256, 152).addBox(0.25F, -18.0F, -2.0F, 0.0F, 19.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -28.0F, -7.0F, 0.1833F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r3 = fin.addOrReplaceChild("FinMembrane1_r3", CubeListBuilder.create().texOffs(42, 270).addBox(-0.01F, -18.0F, -2.0F, 0.0F, 19.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -25.0F, 0.4887F, 0.0F, 0.0F));

		PartDefinition FinSupport_r13 = fin.addOrReplaceChild("FinSupport_r13", CubeListBuilder.create().texOffs(431, 67).addBox(-1.0F, -16.0F, -2.0F, 2.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 17.0F, 0.3578F, 0.0F, 0.0F));

		PartDefinition FinSupport_r14 = fin.addOrReplaceChild("FinSupport_r14", CubeListBuilder.create().texOffs(425, 64).addBox(-1.0F, -20.0F, -2.0F, 2.0F, 21.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -7.0F, 0.3578F, 0.0F, 0.0F));

		PartDefinition FinSupport_r15 = fin.addOrReplaceChild("FinSupport_r15", CubeListBuilder.create().texOffs(426, 69).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -27.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition CenterCorpseDetails = Base.addOrReplaceChild("CenterCorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(14.6727F, 20.75F, -12.7033F, 2.8158F, 1.368F, 1.5519F));

		PartDefinition CenterBody1 = CenterCorpseDetails.addOrReplaceChild("CenterBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r21 = CenterBody1.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r7 = CenterBody1.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r14 = CenterBody1.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody2 = CenterCorpseDetails.addOrReplaceChild("CenterBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.0F, -16.0F, 0.0F, -0.829F, 0.0F, 0.829F));

		PartDefinition Arm_r22 = CenterBody2.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r23 = CenterBody2.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r5 = CenterBody2.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r6 = CenterBody2.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r15 = CenterBody2.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody4 = CenterCorpseDetails.addOrReplaceChild("CenterBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r10 = CenterBody4.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r24 = CenterBody4.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(480, 5).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r25 = CenterBody4.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(480, 5).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r16 = CenterBody4.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r8 = CenterBody4.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails2 = Base.addOrReplaceChild("CenterCorpseDetails2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6727F, 15.75F, -27.7033F, -2.3329F, 1.6298F, 1.5519F));

		PartDefinition CenterBody3 = CenterCorpseDetails2.addOrReplaceChild("CenterBody3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r26 = CenterBody3.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r9 = CenterBody3.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r17 = CenterBody3.addOrReplaceChild("TorsoTop_r17", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody5 = CenterCorpseDetails2.addOrReplaceChild("CenterBody5", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.0F, -16.0F, 0.0F, -0.829F, 0.0F, 0.829F));

		PartDefinition Arm_r27 = CenterBody5.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r28 = CenterBody5.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r7 = CenterBody5.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r8 = CenterBody5.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r18 = CenterBody5.addOrReplaceChild("TorsoTop_r18", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody6 = CenterCorpseDetails2.addOrReplaceChild("CenterBody6", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r11 = CenterBody6.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r29 = CenterBody6.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(480, 5).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r30 = CenterBody6.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(480, 5).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r19 = CenterBody6.addOrReplaceChild("TorsoTop_r19", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r10 = CenterBody6.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails4 = Base.addOrReplaceChild("CenterCorpseDetails4", CubeListBuilder.create(), PartPose.offsetAndRotation(17.3273F, 17.75F, -7.7033F, 0.3681F, -1.3637F, 0.627F));

		PartDefinition CenterBody13 = CenterCorpseDetails4.addOrReplaceChild("CenterBody13", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r31 = CenterBody13.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(480, 5).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r11 = CenterBody13.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r20 = CenterBody13.addOrReplaceChild("TorsoTop_r20", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody14 = CenterCorpseDetails4.addOrReplaceChild("CenterBody14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4968F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r32 = CenterBody14.addOrReplaceChild("Arm_r32", CubeListBuilder.create().texOffs(480, 5).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r33 = CenterBody14.addOrReplaceChild("Arm_r33", CubeListBuilder.create().texOffs(480, 5).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r9 = CenterBody14.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(480, 5).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r10 = CenterBody14.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r21 = CenterBody14.addOrReplaceChild("TorsoTop_r21", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody15 = CenterCorpseDetails4.addOrReplaceChild("CenterBody15", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, 2.1633F, -0.7311F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r11 = CenterBody15.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(480, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.7879F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r12 = CenterBody15.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(480, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r34 = CenterBody15.addOrReplaceChild("Arm_r34", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r22 = CenterBody15.addOrReplaceChild("TorsoTop_r22", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r12 = CenterBody15.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(480, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody16 = CenterCorpseDetails4.addOrReplaceChild("CenterBody16", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3325F, -2.0599F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r13 = CenterBody16.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r35 = CenterBody16.addOrReplaceChild("Arm_r35", CubeListBuilder.create().texOffs(480, 5).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r36 = CenterBody16.addOrReplaceChild("Arm_r36", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r23 = CenterBody16.addOrReplaceChild("TorsoTop_r23", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r12 = CenterBody16.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(480, 5).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Tumors = Base.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(8.0F, 43.0F, -39.0F));

		PartDefinition Tumor = Tumors.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -11.0F, 57.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor2 = Tumors.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.0F, -9.0F, 22.0F, 0.7209F, 0.544F, -0.4887F));

		PartDefinition Biomass_r5 = Tumor2.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = Tumor2.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = Tumor2.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = Tumor2.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor3 = Tumors.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -9.0F, 41.0F, 0.0F, 0.0F, -1.6144F));

		PartDefinition Biomass_r9 = Tumor3.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r10 = Tumor3.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r11 = Tumor3.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r12 = Tumor3.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor4 = Tumors.addOrReplaceChild("Tumor4", CubeListBuilder.create(), PartPose.offset(2.0F, -11.0F, 20.0F));

		PartDefinition Biomass_r13 = Tumor4.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r14 = Tumor4.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r15 = Tumor4.addOrReplaceChild("Biomass_r15", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r16 = Tumor4.addOrReplaceChild("Biomass_r16", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor5 = Tumors.addOrReplaceChild("Tumor5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -22.0F, 15.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition Biomass_r17 = Tumor5.addOrReplaceChild("Biomass_r17", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r18 = Tumor5.addOrReplaceChild("Biomass_r18", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r19 = Tumor5.addOrReplaceChild("Biomass_r19", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r20 = Tumor5.addOrReplaceChild("Biomass_r20", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor6 = Tumors.addOrReplaceChild("Tumor6", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -25.0F, 15.0F, 0.6523F, -0.908F, -1.2913F));

		PartDefinition Biomass_r21 = Tumor6.addOrReplaceChild("Biomass_r21", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r22 = Tumor6.addOrReplaceChild("Biomass_r22", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r23 = Tumor6.addOrReplaceChild("Biomass_r23", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r24 = Tumor6.addOrReplaceChild("Biomass_r24", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor7 = Tumors.addOrReplaceChild("Tumor7", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -9.0F, 17.0F, -0.7418F, -0.9163F, 0.1745F));

		PartDefinition Biomass_r25 = Tumor7.addOrReplaceChild("Biomass_r25", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r26 = Tumor7.addOrReplaceChild("Biomass_r26", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r27 = Tumor7.addOrReplaceChild("Biomass_r27", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r28 = Tumor7.addOrReplaceChild("Biomass_r28", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor8 = Tumors.addOrReplaceChild("Tumor8", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -9.0F, 35.0F, 1.7453F, 0.0F, -1.6144F));

		PartDefinition Biomass_r29 = Tumor8.addOrReplaceChild("Biomass_r29", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r30 = Tumor8.addOrReplaceChild("Biomass_r30", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r31 = Tumor8.addOrReplaceChild("Biomass_r31", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r32 = Tumor8.addOrReplaceChild("Biomass_r32", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		LeviathanAbdomen.getAllParts().forEach(part -> {part.resetPose();});
		boolean water = entity.isInWater();
		float tumorVal3 = Mth.sin(ageInTicks/6)/8;
		float tumorVal4 = Mth.cos(ageInTicks/7)/6;
		float tumorVal5 = Mth.sin(ageInTicks/8)/6;
		float tumorVal6 = Mth.cos(ageInTicks/7)/7;
		if (water && stir > 0){
			stir--;
		}
		if (!water && stir < 40){
			stir++;
		}
		float rotationValue = stir * 0.035f;
		animateTentacleY(rightTailFlipper,rotationValue);
		animateTentacleY(leftTailFlipper,-rotationValue);
		animateTumor(Tumor,tumorVal4);
		animateTumor(Tumor2,tumorVal3);
		animateTumor(Tumor3,tumorVal6);
		animateTumor(Tumor8,tumorVal5);
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (entity.isInWater()){
				float upAndDown = Mth.cos(limbSwing * 0.25f) * 2;
				LeviathanAbdomen.y = LeviathanAbdomen.getInitialPose().y+upAndDown;
				float movement = Mth.cos(limbSwing * 0.25F) * 0.25F * limbSwingAmount;
				this.animateTentacleX(tail,movement);
				this.animateTentacleX(tailFlipper,movement);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r, float g, float b, float alpha) {
		LeviathanAbdomen.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}