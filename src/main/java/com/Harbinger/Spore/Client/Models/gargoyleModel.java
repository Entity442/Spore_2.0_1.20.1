package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.EvolvedInfected.Gargoyl;
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

public class gargoyleModel<T extends Gargoyl> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "gargoylemodel"), "main");
	public final ModelPart Gargoyle;
	private final ModelPart Torso;
	private final ModelPart Chest;
	private final ModelPart Tumor;
	private final ModelPart Stomach;
	private final ModelPart TumorCluster7;
	private final ModelPart TumorCluster8;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart MouthTendril1;
	private final ModelPart MouthTendril2;
	private final ModelPart TongueStart;
	private final ModelPart TongueEnd;
	private final ModelPart HeadFoliageCrown;
	private final ModelPart TumorCluster1;
	private final ModelPart TumorCluster2;
	public final ModelPart headWear;
	private final ModelPart LeftArm;
	private final ModelPart TopArmBase;
	private final ModelPart BottomArmBase;
	private final ModelPart TumorCluster6;
	private final ModelPart RightArm;
	private final ModelPart TopArmBase2;
	private final ModelPart TumorCluster5;
	private final ModelPart BottomArmBase2;
	private final ModelPart LeftLeg;
	private final ModelPart HangingFlesh1;
	private final ModelPart TumorCluster3;
	private final ModelPart RightLeg;
	private final ModelPart HangingFlesh2;
	private final ModelPart TumorCluster4;
	private final ModelPart TopWings;
	private final ModelPart LeftWing;
	private final ModelPart RightWing;
	private final ModelPart BottomWings;
	private final ModelPart RightWing2;
	private final ModelPart leftwing2;
	private final boolean armor;
	private int angle;

	public gargoyleModel(ModelPart root, boolean armor) {
		this.Gargoyle = root.getChild("Gargoyle");
        this.armor = armor;
        this.Torso = this.Gargoyle.getChild("Torso");
		this.Chest = this.Torso.getChild("Chest");
		this.Tumor = this.Torso.getChild("Tumor");
		this.Stomach = this.Torso.getChild("Stomach");
		this.TumorCluster7 = this.Stomach.getChild("TumorCluster7");
		this.TumorCluster8 = this.Stomach.getChild("TumorCluster8");
		this.Head = this.Gargoyle.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.MouthTendril1 = this.Jaw.getChild("MouthTendril1");
		this.MouthTendril2 = this.Jaw.getChild("MouthTendril2");
		this.TongueStart = this.Jaw.getChild("TongueStart");
		this.TongueEnd = this.TongueStart.getChild("TongueEnd");
		this.HeadFoliageCrown = this.Head.getChild("HeadFoliageCrown");
		this.TumorCluster1 = this.Head.getChild("TumorCluster1");
		this.TumorCluster2 = this.Head.getChild("TumorCluster2");
		this.headWear = this.Head.getChild("headWear");
		this.LeftArm = this.Gargoyle.getChild("LeftArm");
		this.TopArmBase = this.LeftArm.getChild("TopArmBase");
		this.BottomArmBase = this.LeftArm.getChild("BottomArmBase");
		this.TumorCluster6 = this.BottomArmBase.getChild("TumorCluster6");
		this.RightArm = this.Gargoyle.getChild("RightArm");
		this.TopArmBase2 = this.RightArm.getChild("TopArmBase2");
		this.TumorCluster5 = this.TopArmBase2.getChild("TumorCluster5");
		this.BottomArmBase2 = this.RightArm.getChild("BottomArmBase2");
		this.LeftLeg = this.Gargoyle.getChild("LeftLeg");
		this.HangingFlesh1 = this.LeftLeg.getChild("HangingFlesh1");
		this.TumorCluster3 = this.LeftLeg.getChild("TumorCluster3");
		this.RightLeg = this.Gargoyle.getChild("RightLeg");
		this.HangingFlesh2 = this.RightLeg.getChild("HangingFlesh2");
		this.TumorCluster4 = this.RightLeg.getChild("TumorCluster4");
		this.TopWings = this.Gargoyle.getChild("TopWings");
		this.LeftWing = this.TopWings.getChild("LeftWing");
		this.RightWing = this.TopWings.getChild("RightWing");
		this.BottomWings = this.Gargoyle.getChild("BottomWings");
		this.RightWing2 = this.BottomWings.getChild("RightWing2");
		this.leftwing2 = this.BottomWings.getChild("leftwing2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Gargoyle = partdefinition.addOrReplaceChild("Gargoyle", CubeListBuilder.create(), PartPose.offset(-0.5F, 12.25F, -0.5F));

		PartDefinition Torso = Gargoyle.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Foliage_r1 = Torso.addOrReplaceChild("Foliage_r1", CubeListBuilder.create().texOffs(-6, 95).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2789F, -13.9986F, 0.0F, 2.2279F, -1.4251F, -2.4531F));

		PartDefinition Foliage_r2 = Torso.addOrReplaceChild("Foliage_r2", CubeListBuilder.create().texOffs(-7, 113).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2789F, -11.9986F, 3.0F, 1.3839F, -1.099F, -1.6141F));

		PartDefinition Foliage_r3 = Torso.addOrReplaceChild("Foliage_r3", CubeListBuilder.create().texOffs(-7, 107).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2789F, -9.9986F, -3.0F, 2.082F, -1.099F, -1.6141F));

		PartDefinition Chest = Torso.addOrReplaceChild("Chest", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SpineConnection_r1 = Chest.addOrReplaceChild("SpineConnection_r1", CubeListBuilder.create().texOffs(95, 14).addBox(-0.5F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -8.0F, 4.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition SpineParts_r1 = Chest.addOrReplaceChild("SpineParts_r1", CubeListBuilder.create().texOffs(92, -7).addBox(0.5F, -1.0F, -5.0F, 0.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 3.0F, -1.0036F, 0.0F, 0.0F));

		PartDefinition ChestArmor_r1 = Chest.addOrReplaceChild("ChestArmor_r1", CubeListBuilder.create().texOffs(69, 49).addBox(-4.5F, -6.0F, -2.5F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.2F))
				.texOffs(94, 8).addBox(-0.5F, -6.0F, 5.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-4.5F, -6.0F, -2.5F, 10.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Tumor = Torso.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(2.3656F, -10.7959F, 2.2801F));

		PartDefinition Tumor_r1 = Tumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(52, 70).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.8588F, 0.103F, 0.2768F));

		PartDefinition Stomach = Torso.addOrReplaceChild("Stomach", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Foliage_r4 = Stomach.addOrReplaceChild("Foliage_r4", CubeListBuilder.create().texOffs(-6, 113).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2789F, -2.9986F, 5.0F, 3.0183F, -0.7131F, -3.0625F));

		PartDefinition Foliage_r5 = Stomach.addOrReplaceChild("Foliage_r5", CubeListBuilder.create().texOffs(-6, 107).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2789F, -8.9986F, 5.0F, 1.9661F, -1.4251F, -2.4531F));

		PartDefinition Foliage_r6 = Stomach.addOrReplaceChild("Foliage_r6", CubeListBuilder.create().texOffs(-6, 101).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7211F, -2.9986F, 6.0F, 2.4024F, -1.4251F, -2.4531F));

		PartDefinition Foliage_r7 = Stomach.addOrReplaceChild("Foliage_r7", CubeListBuilder.create().texOffs(-6, 101).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2789F, -2.9986F, -1.0F, 2.4024F, -1.4251F, -2.4531F));

		PartDefinition Foliage_r8 = Stomach.addOrReplaceChild("Foliage_r8", CubeListBuilder.create().texOffs(-6, 95).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7211F, -0.9986F, 0.0F, 2.2279F, -1.4251F, -2.4531F));

		PartDefinition SpineParts_r2 = Stomach.addOrReplaceChild("SpineParts_r2", CubeListBuilder.create().texOffs(111, 9).addBox(0.5F, -6.75F, -1.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 7.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Spine_r1 = Stomach.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(103, 9).addBox(-1.5F, -2.0F, 0.25F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -7.0F, 4.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition StomachArmor_r1 = Stomach.addOrReplaceChild("StomachArmor_r1", CubeListBuilder.create().texOffs(73, 19).addBox(-5.0F, -8.0F, -3.0F, 11.0F, 8.0F, 9.0F, new CubeDeformation(0.2F))
				.texOffs(0, 0).addBox(-5.0F, -8.0F, -3.0F, 11.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TumorCluster7 = Stomach.addOrReplaceChild("TumorCluster7", CubeListBuilder.create(), PartPose.offset(2.666F, -1.9303F, -2.8599F));

		PartDefinition Tumor_r2 = TumorCluster7.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(52, 70).addBox(-1.0F, -4.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.334F, -0.0697F, 2.8599F, 1.8588F, 0.103F, 0.2768F));

		PartDefinition Tumor_r3 = TumorCluster7.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(50, 68).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.666F, -0.0697F, -1.1401F, 0.0F, 0.0F, 0.6109F));

		PartDefinition TumorCluster8 = Stomach.addOrReplaceChild("TumorCluster8", CubeListBuilder.create(), PartPose.offset(-4.1325F, -4.5635F, 4.5941F));

		PartDefinition Tumor_r4 = TumorCluster8.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(52, 71).addBox(-1.0F, -4.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1325F, -0.4365F, 2.4059F, 1.163F, 0.7706F, -1.0506F));

		PartDefinition Tumor_r5 = TumorCluster8.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(54, 71).addBox(-1.0F, -4.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1325F, -3.4365F, 1.4059F, 0.8355F, -0.8479F, 2.5215F));

		PartDefinition Head = Gargoyle.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 33).addBox(-3.7906F, -6.9498F, -7.3404F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.2906F, -14.0502F, -2.6596F));

		PartDefinition Foliage4_r1 = Head.addOrReplaceChild("Foliage4_r1", CubeListBuilder.create().texOffs(-6, 101).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3376F, -5.9673F, -2.0211F, -0.3976F, 1.2235F, 0.0461F));

		PartDefinition Foliage3_r1 = Head.addOrReplaceChild("Foliage3_r1", CubeListBuilder.create().texOffs(-6, 107).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6624F, -4.9673F, -6.0211F, -1.4201F, 1.3088F, -1.5463F));

		PartDefinition Foliage2_r1 = Head.addOrReplaceChild("Foliage2_r1", CubeListBuilder.create().texOffs(-6, 113).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6624F, -3.9673F, -0.0211F, 1.395F, 1.3466F, 1.2782F));

		PartDefinition Foliage1_r1 = Head.addOrReplaceChild("Foliage1_r1", CubeListBuilder.create().texOffs(-6, 113).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6624F, -1.9673F, -0.0211F, -0.312F, -0.5845F, 0.0447F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(52, 39).addBox(-3.8333F, -1.3216F, 1.6614F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 66).addBox(-3.8333F, -1.3216F, -4.3386F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0427F, 0.3718F, -3.0018F));

		PartDefinition MouthTendril1 = Jaw.addOrReplaceChild("MouthTendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.2333F, -1.4216F, 1.3614F, 2.5307F, 0.0F, 0.0F));

		PartDefinition Tsegment2_r1 = MouthTendril1.addOrReplaceChild("Tsegment2_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-1.0F, -5.5F, -1.5F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.9F, -0.3481F, 0.0288F, -0.3491F, 0.0F, -0.3491F));

		PartDefinition Tsegment1_r1 = MouthTendril1.addOrReplaceChild("Tsegment1_r1", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.1F, 0.6519F, 1.0288F, 0.0F, 0.0F, 0.1745F));

		PartDefinition MouthTendril2 = Jaw.addOrReplaceChild("MouthTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7667F, -1.4216F, 1.4614F, 0.7805F, -0.6178F, 2.6208F));

		PartDefinition Tsegment3_r1 = MouthTendril2.addOrReplaceChild("Tsegment3_r1", CubeListBuilder.create().texOffs(0, 86).addBox(-1.5F, -5.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(1.0535F, -0.4054F, -0.0017F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Tsegment2_r2 = MouthTendril2.addOrReplaceChild("Tsegment2_r2", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -3.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0535F, 0.5946F, 0.9983F, 0.0F, 0.0F, -0.1745F));

		PartDefinition TongueStart = Jaw.addOrReplaceChild("TongueStart", CubeListBuilder.create(), PartPose.offset(0.0833F, -0.0876F, 1.5245F));

		PartDefinition TonguePiece_r1 = TongueStart.addOrReplaceChild("TonguePiece_r1", CubeListBuilder.create().texOffs(81, 72).addBox(-1.5F, -1.0F, -2.0F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5833F, 0.766F, -0.8631F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TongueEnd = TongueStart.addOrReplaceChild("TongueEnd", CubeListBuilder.create(), PartPose.offset(0.0833F, 0.799F, -2.8193F));

		PartDefinition TonguePiece_r2 = TongueEnd.addOrReplaceChild("TonguePiece_r2", CubeListBuilder.create().texOffs(70, 72).addBox(-1.5F, 0.0F, -2.2F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.5F, -0.133F, -0.8438F, 0.5236F, 0.0F, 0.0F));

		PartDefinition HeadFoliageCrown = Head.addOrReplaceChild("HeadFoliageCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1876F, -6.0423F, -6.4461F, -0.176F, -0.1289F, 0.0229F));

		PartDefinition HeadCrownPetal4_r1 = HeadFoliageCrown.addOrReplaceChild("HeadCrownPetal4_r1", CubeListBuilder.create().texOffs(-6, 113).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.65F, -0.025F, -1.775F, 0.5635F, 0.4364F, 1.3434F));

		PartDefinition HeadCrownPetal3_r1 = HeadFoliageCrown.addOrReplaceChild("HeadCrownPetal3_r1", CubeListBuilder.create().texOffs(-6, 95).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.35F, 1.975F, -0.975F, 2.4227F, 0.4746F, 3.029F));

		PartDefinition HeadCrownPetal2_r1 = HeadFoliageCrown.addOrReplaceChild("HeadCrownPetal2_r1", CubeListBuilder.create().texOffs(-6, 101).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.85F, -0.025F, 1.325F, 1.5078F, 0.4065F, 1.3905F));

		PartDefinition HeadCrownPetal1_r1 = HeadFoliageCrown.addOrReplaceChild("HeadCrownPetal1_r1", CubeListBuilder.create().texOffs(-6, 107).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.85F, -1.925F, 1.425F, 1.2151F, -0.5845F, 0.0447F));

		PartDefinition TumorCluster1 = Head.addOrReplaceChild("TumorCluster1", CubeListBuilder.create(), PartPose.offset(-2.1501F, -6.3123F, -1.3051F));

		PartDefinition Tumor3_r1 = TumorCluster1.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1405F, -0.6375F, 1.9648F, 2.0849F, 0.0772F, 0.7449F));

		PartDefinition Tumor2_r1 = TumorCluster1.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1405F, -0.6375F, -0.0352F, 2.1662F, -0.9149F, -0.4927F));

		PartDefinition Tumor1_r1 = TumorCluster1.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(35, 68).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8595F, 1.3625F, 1.9648F, 1.1345F, 0.0F, 0.0F));

		PartDefinition TumorCluster2 = Head.addOrReplaceChild("TumorCluster2", CubeListBuilder.create(), PartPose.offset(3.36F, -3.1982F, -0.322F));

		PartDefinition Tumor5_r1 = TumorCluster2.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3494F, 1.2483F, -2.0184F, -2.2837F, -0.2769F, 1.4428F));

		PartDefinition Tumor4_r1 = TumorCluster2.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3494F, -1.7517F, 0.9816F, 2.5196F, 0.2613F, 0.9926F));

		PartDefinition headWear = Head.addOrReplaceChild("headWear", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -19.0F, -18.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(-11.5F)), PartPose.offset(0.2094F, -0.1998F, -1.2904F));

		PartDefinition LeftArm = Gargoyle.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(5.0F, -11.0F, -4.0F));

		PartDefinition TopArmBase = LeftArm.addOrReplaceChild("TopArmBase", CubeListBuilder.create(), PartPose.offset(-5.0F, 11.0F, 4.0F));

		PartDefinition Foliage_r9 = TopArmBase.addOrReplaceChild("Foliage_r9", CubeListBuilder.create().texOffs(-6, 107).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7211F, -9.9986F, -4.0F, 2.7477F, 0.7821F, 2.7358F));

		PartDefinition Foliage_r10 = TopArmBase.addOrReplaceChild("Foliage_r10", CubeListBuilder.create().texOffs(-6, 113).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7211F, -7.9986F, 0.0F, 2.6259F, -1.1793F, -2.7677F));

		PartDefinition Armor_r1 = TopArmBase.addOrReplaceChild("Armor_r1", CubeListBuilder.create().texOffs(74, 9).addBox(-1.0F, -3.75F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F))
				.texOffs(18, 50).addBox(-1.0F, -3.75F, -3.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -3.0F, 0.0869F, -0.0076F, -0.0876F));

		PartDefinition BottomArmBase = LeftArm.addOrReplaceChild("BottomArmBase", CubeListBuilder.create(), PartPose.offset(-5.0F, 11.0F, 4.0F));

		PartDefinition Foliage_r11 = BottomArmBase.addOrReplaceChild("Foliage_r11", CubeListBuilder.create().texOffs(-7, 107).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.7211F, -2.9986F, -3.0F, 0.8173F, -0.9118F, -0.9529F));

		PartDefinition Claw_r1 = BottomArmBase.addOrReplaceChild("Claw_r1", CubeListBuilder.create().texOffs(22, 93).addBox(-3.2834F, -3.091F, 1.5F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(22, 93).addBox(-3.2834F, -3.091F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 4.0F, -2.0F, 3.1416F, 0.0F, 3.0543F));

		PartDefinition Claw_r2 = BottomArmBase.addOrReplaceChild("Claw_r2", CubeListBuilder.create().texOffs(22, 93).addBox(-3.2834F, -3.091F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 4.0F, -5.0F, 3.1416F, 0.0F, 3.0543F));

		PartDefinition BottomArm_r1 = BottomArmBase.addOrReplaceChild("BottomArm_r1", CubeListBuilder.create().texOffs(32, 39).addBox(-1.7F, -4.0F, -4.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition TumorCluster6 = BottomArmBase.addOrReplaceChild("TumorCluster6", CubeListBuilder.create(), PartPose.offset(7.6744F, -1.5953F, -1.6459F));

		PartDefinition Tumor_r6 = TumorCluster6.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0466F, -0.4033F, 0.6459F, -0.5533F, 0.2768F, -1.0254F));

		PartDefinition Tumor_r7 = TumorCluster6.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -3.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0466F, 1.5967F, 2.6459F, 0.8603F, 0.09F, 2.5534F));

		PartDefinition Tumor_r8 = TumorCluster6.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(35, 68).addBox(-2.0F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9534F, -0.4033F, 0.6459F, 1.7455F, -0.043F, -1.5784F));

		PartDefinition RightArm = Gargoyle.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -11.0F, -4.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition TopArmBase2 = RightArm.addOrReplaceChild("TopArmBase2", CubeListBuilder.create(), PartPose.offset(-8.6092F, 11.2197F, 4.0F));

		PartDefinition Foliage_r12 = TopArmBase2.addOrReplaceChild("Foliage_r12", CubeListBuilder.create().texOffs(-7, 101).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -1.0F, -3.0F, -0.1948F, 0.3292F, 0.3908F));

		PartDefinition Foliage_r13 = TopArmBase2.addOrReplaceChild("Foliage_r13", CubeListBuilder.create().texOffs(-7, 107).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -7.0F, -6.0F, 0.2427F, 0.0992F, -0.3806F));

		PartDefinition Armor_r2 = TopArmBase2.addOrReplaceChild("Armor_r2", CubeListBuilder.create().texOffs(73, 1).addBox(-1.0F, -3.75F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F))
				.texOffs(34, 50).addBox(-1.0F, -3.75F, -3.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -9.0F, -3.0F, 0.0869F, -0.0076F, -0.0876F));

		PartDefinition TumorCluster5 = TopArmBase2.addOrReplaceChild("TumorCluster5", CubeListBuilder.create().texOffs(35, 68).addBox(-1.061F, -2.1221F, -1.3505F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(6.061F, -7.8779F, -3.1495F));

		PartDefinition Tumor_r9 = TumorCluster5.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(37, 70).addBox(-3.0F, -2.0F, -2.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.939F, 0.8779F, 2.1495F, 0.0F, -0.5236F, -0.6109F));

		PartDefinition BottomArmBase2 = RightArm.addOrReplaceChild("BottomArmBase2", CubeListBuilder.create(), PartPose.offset(-8.6092F, 11.2197F, 4.0F));

		PartDefinition claw3_r1 = BottomArmBase2.addOrReplaceChild("claw3_r1", CubeListBuilder.create().texOffs(22, 93).addBox(-1.7F, -4.0F, 1.5F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(22, 93).addBox(-1.7F, -4.0F, 3.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(22, 93).addBox(-1.7F, -4.0F, 0.0F, 5.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 5.0F, -5.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition BottomArm_r2 = BottomArmBase2.addOrReplaceChild("BottomArm_r2", CubeListBuilder.create().texOffs(40, 0).addBox(-1.7F, -4.0F, -4.0F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition LeftLeg = Gargoyle.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 47).addBox(-2.0208F, -0.5755F, -2.4932F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0208F, -0.4245F, 1.4932F));

		PartDefinition foliage_r14 = LeftLeg.addOrReplaceChild("foliage_r14", CubeListBuilder.create().texOffs(-6, 113).addBox(-1.0F, 0.0F, -1.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0208F, 0.4245F, -0.4932F, -0.3491F, 0.0F, 0.0F));

		PartDefinition HangingFlesh1 = LeftLeg.addOrReplaceChild("HangingFlesh1", CubeListBuilder.create(), PartPose.offset(-3.0208F, 0.4245F, -1.4932F));

		PartDefinition HF2_r1 = HangingFlesh1.addOrReplaceChild("HF2_r1", CubeListBuilder.create().texOffs(10, 76).addBox(0.0F, -1.0F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 1.5F, 0.0F, -0.6109F, 0.0F));

		PartDefinition HF1_r1 = HangingFlesh1.addOrReplaceChild("HF1_r1", CubeListBuilder.create().texOffs(10, 76).addBox(0.0F, -1.0F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 6.0F, 1.5F, 0.0F, 0.7418F, 0.0F));

		PartDefinition TumorCluster3 = LeftLeg.addOrReplaceChild("TumorCluster3", CubeListBuilder.create(), PartPose.offset(-0.3378F, 4.0426F, 0.9003F));

		PartDefinition Tumor3_r2 = TumorCluster3.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.683F, 1.3819F, 1.6065F, 0.2249F, -0.7318F, 0.4321F));

		PartDefinition Tumor2_r2 = TumorCluster3.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.683F, -0.6181F, 1.6065F, 0.9667F, -0.7318F, 0.4321F));

		PartDefinition Tumor1_r2 = TumorCluster3.addOrReplaceChild("Tumor1_r2", CubeListBuilder.create().texOffs(35, 68).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.317F, 1.3819F, -1.3935F, 0.9667F, -0.7318F, 0.4321F));

		PartDefinition RightLeg = Gargoyle.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(36, 23).addBox(-2.028F, -0.5755F, -2.4932F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.972F, -0.4245F, 1.4932F));

		PartDefinition HangingFlesh2 = RightLeg.addOrReplaceChild("HangingFlesh2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.028F, 5.4245F, 0.0068F, 0.0F, 3.0543F, 0.0F));

		PartDefinition HF3_r1 = HangingFlesh2.addOrReplaceChild("HF3_r1", CubeListBuilder.create().texOffs(10, 76).addBox(0.0F, -1.0F, -2.5F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition HF2_r2 = HangingFlesh2.addOrReplaceChild("HF2_r2", CubeListBuilder.create().texOffs(10, 76).addBox(0.0F, -1.0F, -2.5F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition TumorCluster4 = RightLeg.addOrReplaceChild("TumorCluster4", CubeListBuilder.create(), PartPose.offset(-0.8441F, 2.0465F, -1.1534F));

		PartDefinition Tumor6_r1 = TumorCluster4.addOrReplaceChild("Tumor6_r1", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8161F, -0.622F, -0.3398F, 0.9189F, -0.7218F, -0.4978F));

		PartDefinition Tumor5_r2 = TumorCluster4.addOrReplaceChild("Tumor5_r2", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1839F, 0.378F, 0.6602F, 0.7432F, -0.3243F, 1.3099F));

		PartDefinition Tumor4_r2 = TumorCluster4.addOrReplaceChild("Tumor4_r2", CubeListBuilder.create().texOffs(37, 69).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1839F, 1.378F, 1.6602F, 0.5138F, -1.2265F, 0.0955F));

		PartDefinition TopWings = Gargoyle.addOrReplaceChild("TopWings", CubeListBuilder.create(), PartPose.offset(-3.5F, 9.75F, -5.5F));

		PartDefinition LeftWing = TopWings.addOrReplaceChild("LeftWing", CubeListBuilder.create().texOffs(60, 7).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(50, 59).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(98, 38).addBox(-16.0F, -5.0F, 0.0F, 15.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -20.0F, 8.0F, 0.0F, 2.0944F, 0.0F));

		PartDefinition Foliage_r15 = LeftWing.addOrReplaceChild("Foliage_r15", CubeListBuilder.create().texOffs(-6, 101).addBox(-5.0F, 0.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7789F, -4.7486F, 1.5F, 3.0183F, -0.7131F, -3.0625F));

		PartDefinition WingFrame3_r1 = LeftWing.addOrReplaceChild("WingFrame3_r1", CubeListBuilder.create().texOffs(52, 47).addBox(-5.0F, -1.0F, 0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-12.0F, -3.0F, -1.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Wingframe2_r1 = LeftWing.addOrReplaceChild("Wingframe2_r1", CubeListBuilder.create().texOffs(50, 55).addBox(-6.0F, -2.5F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-6.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition WingFrame1_r1 = LeftWing.addOrReplaceChild("WingFrame1_r1", CubeListBuilder.create().texOffs(54, 27).addBox(-6.0F, -2.5F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightWing = TopWings.addOrReplaceChild("RightWing", CubeListBuilder.create().texOffs(60, 0).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 58).addBox(-1.5F, -6.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(98, 38).addBox(-16.0F, -5.0F, 0.0F, 15.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 8.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition WingFrame3_r2 = RightWing.addOrReplaceChild("WingFrame3_r2", CubeListBuilder.create().texOffs(18, 47).addBox(-5.0F, -1.0F, 0.5F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.05F)), PartPose.offsetAndRotation(-12.0F, -3.0F, -1.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition WingFrame2_r2 = RightWing.addOrReplaceChild("WingFrame2_r2", CubeListBuilder.create().texOffs(54, 23).addBox(-6.0F, -2.5F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-6.0F, -4.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition WingFrame1_r2 = RightWing.addOrReplaceChild("WingFrame1_r2", CubeListBuilder.create().texOffs(52, 43).addBox(-6.0F, -2.5F, -1.0F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition BottomWings = Gargoyle.addOrReplaceChild("BottomWings", CubeListBuilder.create(), PartPose.offset(-3.5F, 12.75F, 5.5F));

		PartDefinition RightWing2 = BottomWings.addOrReplaceChild("RightWing2", CubeListBuilder.create().texOffs(62, 35).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
				.texOffs(12, 62).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(41, 17).addBox(-10.0F, -3.0F, 0.0F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -18.0F, -1.0F, 0.0F, 0.7418F, 0.0F));

		PartDefinition WingFrame3_r3 = RightWing2.addOrReplaceChild("WingFrame3_r3", CubeListBuilder.create().texOffs(12, 58).addBox(-1.0F, -1.7F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition WingFrame2_r3 = RightWing2.addOrReplaceChild("WingFrame2_r3", CubeListBuilder.create().texOffs(54, 31).addBox(-4.0F, -1.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition WingFrame1_r3 = RightWing2.addOrReplaceChild("WingFrame1_r3", CubeListBuilder.create().texOffs(20, 62).addBox(-3.0F, -1.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition leftwing2 = BottomWings.addOrReplaceChild("leftwing2", CubeListBuilder.create().texOffs(38, 62).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F))
				.texOffs(30, 62).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(41, 17).addBox(-10.0F, -3.0F, 0.0F, 10.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -18.0F, -1.0F, 0.0F, 2.3998F, 0.0F));

		PartDefinition WingFrame3_r4 = leftwing2.addOrReplaceChild("WingFrame3_r4", CubeListBuilder.create().texOffs(12, 60).addBox(-1.0F, -1.7F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition WingFrame2_r4 = leftwing2.addOrReplaceChild("WingFrame2_r4", CubeListBuilder.create().texOffs(60, 14).addBox(-4.0F, -1.0F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition WingFrame1_r4 = leftwing2.addOrReplaceChild("WingFrame1_r4", CubeListBuilder.create().texOffs(62, 33).addBox(-3.0F, -1.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}
	public void setDraw(ModelPart part){
		if (headWear.equals(part)){
			part.skipDraw = !armor;
		}else{
			part.skipDraw = armor;
		}
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float moveValue = Mth.cos(limbSwing * 0.2F) * 0.2F * limbSwingAmount;
		float upAndDown = Mth.sin(ageInTicks/10);
		float defVal = Mth.sin(ageInTicks/6)/6;
		float defValT1 = Mth.cos(ageInTicks/8)/5;
		float defValT2 = Mth.sin(ageInTicks/7)/6;
		float defValT3 = Mth.cos(ageInTicks/6)/7;
		float defValT4 = Mth.sin(ageInTicks/5)/8;
		float bodyAngle = angle * 0.025f;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI) -bodyAngle;
		float wingRotation = Mth.sin(ageInTicks)/2;
		animateTentacleY(LeftWing,wingRotation);
		animateTentacleY(RightWing,-wingRotation);
		animateTentacleY(leftwing2,-wingRotation);
		animateTentacleY(RightWing2,wingRotation);
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (angle < 40){
				angle++;
			}
		}else {
			if (angle > 0){
				angle--;
			}
		}
		animateTentacleX(Gargoyle,bodyAngle);
		animateTentacleX(RightArm,-bodyAngle + defVal);
		animateTentacleX(LeftArm,-bodyAngle + defVal);
		animateTentacleX(LeftLeg,-bodyAngle + moveValue);
		animateTentacleX(RightLeg,-bodyAngle - moveValue);
		animateTentacleZ(MouthTendril1, defValT2);
		animateTentacleZ(MouthTendril2,-defValT3);
		animateTentacleY(TongueStart,defValT4);
		animateTentacleY(TongueEnd,defValT4);
		animateTumor(Tumor,defValT1);
		animateTumor(TumorCluster1,defValT1);
		animateTumor(TumorCluster2,defValT2);
		animateTumor(TumorCluster3,defValT3);
		animateTumor(TumorCluster4,defValT4);
		animateTumor(TumorCluster5,-defValT1);
		animateTumor(TumorCluster6,-defValT2);
		animateTumor(TumorCluster7,-defValT3);
		animateTumor(TumorCluster8,-defValT4);
		Gargoyle.y = Gargoyle.getInitialPose().y+upAndDown;
		HangingFlesh1.y = HangingFlesh1.getInitialPose().y+upAndDown * 1.15f;
		HangingFlesh2.y = HangingFlesh2.getInitialPose().y+upAndDown * 1.25f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Gargoyle.getAllParts().forEach(this::setDraw);
		Gargoyle.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}