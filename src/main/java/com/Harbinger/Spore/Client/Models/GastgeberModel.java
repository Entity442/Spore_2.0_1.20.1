package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.GastGeber;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GastgeberModel<T extends GastGeber> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "gastgebermodel"), "main");
	private final ModelPart the_twat;
	private final ModelPart Roots;
	private final ModelPart Torso;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Tendril4;
	private final ModelPart Tendril5;
	private final ModelPart Tendril6;
	private final ModelPart Arm1;
	private final ModelPart Arm2;
	private final ModelPart TumorousMass;
	private final ModelPart Mound1;
	private final ModelPart Mound2;
	private final ModelPart Mound3;
	private final ModelPart Mound4;

	public GastgeberModel(ModelPart root) {
		this.the_twat = root.getChild("the_twat");
		this.Roots = the_twat.getChild("roots");
		this.Torso = the_twat.getChild("torso");
		this.RightLeg = the_twat.getChild("legs").getChild("rightleg");
		this.LeftLeg = the_twat.getChild("legs").getChild("leftleg");
		this.Tendril1 = LeftLeg.getChild("leftfoot").getChild("leftfoottendrils").getChild("tendriljoint1");
		this.Tendril2 = LeftLeg.getChild("leftfoot").getChild("leftfoottendrils").getChild("tendriljoint2");
		this.Tendril3 = LeftLeg.getChild("leftfoot").getChild("leftfoottendrils").getChild("tendriljoint3");
		this.Tendril4 = RightLeg.getChild("rightfoot").getChild("rightfoottendrils").getChild("tendriljoint4");
		this.Tendril5 = RightLeg.getChild("rightfoot").getChild("rightfoottendrils").getChild("tendriljoint5");
		this.Tendril6 = RightLeg.getChild("rightfoot").getChild("rightfoottendrils").getChild("tendriljoint6");
		this.Arm1 = Torso.getChild("arms").getChild("arm1");
		this.Arm2 = Torso.getChild("arms").getChild("arm2");
		this.TumorousMass = Torso.getChild("tumoralmass");
		this.Mound1 = Torso.getChild("torsomounds").getChild("mound1");
		this.Mound2 = Torso.getChild("torsomounds").getChild("mound2");
		this.Mound3 = Torso.getChild("torsomounds").getChild("mound3");
		this.Mound4 = Torso.getChild("torsomounds").getChild("mound4");

	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition the_twat = partdefinition.addOrReplaceChild("the_twat", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = the_twat.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftleg = legs.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(76, 10).addBox(-1.5F, -0.25F, -2.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(2.0F, -10.5F, -0.5F));

		PartDefinition leftfoot = leftleg.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(31, 7).addBox(-2.0F, -1.0F, -2.5F, 5.0F, 6.0F, 5.0F, new CubeDeformation(-0.5F)), PartPose.offset(0.0F, 6.0F, -0.5F));

		PartDefinition leftfoottendrils = leftfoot.addOrReplaceChild("leftfoottendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1148F, -3.8447F, -1.9415F, -3.0107F, 0.0F, 0.0F));

		PartDefinition tendriljoint1 = leftfoottendrils.addOrReplaceChild("tendriljoint1", CubeListBuilder.create(), PartPose.offset(-0.1441F, -3.0163F, -0.4005F));

		PartDefinition LT10 = tendriljoint1.addOrReplaceChild("LT10", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, -0.3054F, 0.0F));

		PartDefinition LT1_r1 = LT10.addOrReplaceChild("LT1_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg5 = LT10.addOrReplaceChild("LT1Seg5", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, 0.3491F, -0.3054F, 0.0F));

		PartDefinition tendriljoint2 = leftfoottendrils.addOrReplaceChild("tendriljoint2", CubeListBuilder.create(), PartPose.offset(2.0495F, -2.6719F, -0.809F));

		PartDefinition LT11 = tendriljoint2.addOrReplaceChild("LT11", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9829F, -1.3441F, 1.4801F));

		PartDefinition LT2Seg1_r1 = LT11.addOrReplaceChild("LT2Seg1_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg5 = LT11.addOrReplaceChild("LT2Seg5", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.5236F, -0.2618F, 0.0873F));

		PartDefinition tendriljoint3 = leftfoottendrils.addOrReplaceChild("tendriljoint3", CubeListBuilder.create(), PartPose.offset(1.0508F, -5.0764F, -3.2174F));

		PartDefinition LT12 = tendriljoint3.addOrReplaceChild("LT12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.1563F, -0.8313F, -2.3142F));

		PartDefinition LT3Seg1_r1 = LT12.addOrReplaceChild("LT3Seg1_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg5 = LT12.addOrReplaceChild("LT3Seg5", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.4363F, -0.4363F, 0.5236F));

		PartDefinition rightleg = legs.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(76, 10).addBox(-2.5F, 0.0F, -2.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.3F, -10.5F, 1.0F));

		PartDefinition rightfoot = rightleg.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(31, 7).addBox(-3.0F, -0.25F, -2.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.25F)), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition rightfoottendrils = rightfoot.addOrReplaceChild("rightfoottendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5852F, -4.1058F, -0.9586F, -3.0107F, 0.0F, 0.0F));

		PartDefinition tendriljoint4 = rightfoottendrils.addOrReplaceChild("tendriljoint4", CubeListBuilder.create(), PartPose.offset(-0.6163F, -3.7824F, 0.5133F));

		PartDefinition LT13 = tendriljoint4.addOrReplaceChild("LT13", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, 0.3054F, 0.0F));

		PartDefinition LT1_r2 = LT13.addOrReplaceChild("LT1_r2", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg6 = LT13.addOrReplaceChild("LT1Seg6", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0522F, -2.9848F, 0.1656F, 0.3491F, 0.3054F, 0.0F));

		PartDefinition tendriljoint5 = rightfoottendrils.addOrReplaceChild("tendriljoint5", CubeListBuilder.create(), PartPose.offset(-1.0508F, -5.0764F, -3.2174F));

		PartDefinition LT15 = tendriljoint5.addOrReplaceChild("LT15", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.1563F, 0.8313F, 2.3142F));

		PartDefinition LT3Seg1_r2 = LT15.addOrReplaceChild("LT3Seg1_r2", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg6 = LT15.addOrReplaceChild("LT3Seg6", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.1899F, -2.636F, -0.1056F, 0.4363F, 0.4363F, -0.5236F));

		PartDefinition tendriljoint6 = rightfoottendrils.addOrReplaceChild("tendriljoint6", CubeListBuilder.create(), PartPose.offset(-2.0495F, -2.6719F, -0.809F));

		PartDefinition LT14 = tendriljoint6.addOrReplaceChild("LT14", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.9829F, 1.3441F, -1.4801F));

		PartDefinition LT2Seg1_r2 = LT14.addOrReplaceChild("LT2Seg1_r2", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg6 = LT14.addOrReplaceChild("LT2Seg6", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0389F, -3.2663F, 0.0449F, -0.5236F, 0.2618F, -0.0873F));

		PartDefinition rightlegfungus = rightleg.addOrReplaceChild("rightlegfungus", CubeListBuilder.create(), PartPose.offset(-3.7593F, 2.6608F, 0.6525F));

		PartDefinition Fungus_r1 = rightlegfungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 56).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = rightlegfungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 49).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = rightlegfungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 56).addBox(-2.25F, -5.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = rightlegfungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 56).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition torso = the_twat.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -3.5F, -3.25F, 8.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition UpperTorso_r1 = torso.addOrReplaceChild("UpperTorso_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -2.75F, -5.0F, 10.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.104F, -0.5743F, 0.5633F, -0.0365F, -0.0317F));

		PartDefinition MiddleTorso_r1 = torso.addOrReplaceChild("MiddleTorso_r1", CubeListBuilder.create().texOffs(29, 5).addBox(-4.5F, -5.0F, -4.0F, 9.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.25F, 0.75F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tumoralmass = torso.addOrReplaceChild("tumoralmass", CubeListBuilder.create(), PartPose.offset(0.1605F, -7.3329F, -1.5276F));

		PartDefinition Tumor_r1 = tumoralmass.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(65, 41).addBox(0.7072F, -1.7842F, 0.7615F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.3659F, -0.7477F, -0.0885F));

		PartDefinition Tumor_r2 = tumoralmass.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(65, 41).addBox(-2.0476F, -5.7628F, -1.9327F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.1254F, -0.8771F, 0.4168F));

		PartDefinition Tumor_r3 = tumoralmass.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(65, 41).addBox(-0.4608F, 0.9304F, -0.8399F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.127F, 0.0864F, -0.9437F));

		PartDefinition Tumor_r4 = tumoralmass.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(63, 39).addBox(-2.6788F, -5.8733F, -7.623F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.2283F, 0.5139F, -0.3774F));

		PartDefinition Tumor_r5 = tumoralmass.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(65, 41).addBox(-0.1593F, -5.4716F, -1.0018F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.6066F, 0.0127F, -0.8625F));

		PartDefinition Tumor_r6 = tumoralmass.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(65, 41).addBox(2.4155F, -0.6845F, -4.4623F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.2439F, -0.212F, -0.7271F));

		PartDefinition Tumor_r7 = tumoralmass.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(65, 41).addBox(-5.7955F, -2.9911F, -2.8754F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.0659F, -2.0129F, -0.9472F, 2.1014F, -0.2084F, 0.5962F));

		PartDefinition Tumor_r8 = tumoralmass.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(65, 41).addBox(-3.0F, -3.0F, -4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.835F, 3.6041F, -1.3743F, 0.1407F, 0.6253F, -0.0552F));

		PartDefinition Tumor_r9 = tumoralmass.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(65, 41).addBox(0.0F, -1.0F, 1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1605F, 2.3329F, -3.4724F, 0.4116F, 0.2307F, 0.7223F));

		PartDefinition Tumor_r10 = tumoralmass.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(65, 41).addBox(0.75F, 1.0F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1991F, 1.9369F, -1.2531F, 0.569F, 0.5939F, 0.7878F));

		PartDefinition Tumor_r11 = tumoralmass.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(65, 41).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.1991F, -1.0631F, 4.3082F, -0.0359F, -0.8751F, 0.4223F));

		PartDefinition Tumor_r12 = tumoralmass.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(63, 39).addBox(-6.5F, -5.0F, 0.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.835F, 0.6041F, 4.4295F, 0.4201F, -0.5219F, -0.3656F));

		PartDefinition Tumor_r13 = tumoralmass.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(65, 41).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6419F, -0.7046F, 3.9295F, 0.4237F, -0.7665F, 0.444F));

		PartDefinition Tumor_r14 = tumoralmass.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(65, 41).addBox(0.0F, 0.0F, -5.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1605F, -0.6671F, 6.5276F, 0.0F, -0.5236F, 0.5672F));

		PartDefinition torsomounds = torso.addOrReplaceChild("torsomounds", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 0.0F));

		PartDefinition mound1 = torsomounds.addOrReplaceChild("mound1", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(62, 21).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.8529F, -20.8298F, 1.3822F, -0.5925F, 0.4432F, 0.2973F));

		PartDefinition LowerBase_r1 = mound1.addOrReplaceChild("LowerBase_r1", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound2 = torsomounds.addOrReplaceChild("mound2", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(62, 21).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.085F, -19.9783F, 1.4515F, -0.239F, 0.0F, -0.477F));

		PartDefinition LowerBase_r2 = mound2.addOrReplaceChild("LowerBase_r2", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound3 = torsomounds.addOrReplaceChild("mound3", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(62, 21).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.3558F, -19.0319F, 2.2612F, -1.2927F, 0.0F, -1.1851F));

		PartDefinition LowerBase_r3 = mound3.addOrReplaceChild("LowerBase_r3", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound4 = torsomounds.addOrReplaceChild("mound4", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F))
		.texOffs(62, 21).addBox(-1.5F, -7.25F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(3.0168F, -19.1976F, -1.2522F, -2.8125F, 0.0F, -1.1431F));

		PartDefinition LowerBase_r4 = mound4.addOrReplaceChild("LowerBase_r4", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, -10.2455F, -4.5108F, -1.1781F, 0.0F, 0.0F));

		PartDefinition upperhead = head.addOrReplaceChild("upperhead", CubeListBuilder.create().texOffs(24, 18).addBox(-4.0F, -3.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(28, 0).addBox(-4.0F, 3.0F, -8.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, -0.5F));

		PartDefinition upperflower1 = upperhead.addOrReplaceChild("upperflower1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.23F, -0.892F, -4.2732F, 0.6655F, -0.2266F, 0.3196F));

		PartDefinition cube_r1 = upperflower1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-7, 56).addBox(-2.86F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = upperflower1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-7, 49).addBox(1.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = upperflower1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 49).addBox(-2.86F, 0.0F, -8.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = upperflower1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 63).addBox(-7.0F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition upperflower2 = upperhead.addOrReplaceChild("upperflower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0827F, 0.9482F, -5.0427F, 1.0638F, 0.656F, -0.4065F));

		PartDefinition cube_r5 = upperflower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-7, 63).addBox(-3.14F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r6 = upperflower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-7, 49).addBox(-7.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r7 = upperflower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-7, 56).addBox(-3.14F, 0.0F, -8.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = upperflower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-7, 63).addBox(1.0F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition mound5 = head.addOrReplaceChild("mound5", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(62, 21).addBox(-1.5F, -7.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0367F, -0.824F, -1.85F, 2.3126F, 0.0F, 0.0F));

		PartDefinition LowerBase_r5 = mound5.addOrReplaceChild("LowerBase_r5", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound6 = head.addOrReplaceChild("mound6", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.4F))
		.texOffs(62, 21).addBox(-1.5F, -6.25F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.1857F, -0.7174F, -1.2555F, 0.8727F, 0.0F, 2.3562F));

		PartDefinition LowerBase_r6 = mound6.addOrReplaceChild("LowerBase_r6", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition mound7 = head.addOrReplaceChild("mound7", CubeListBuilder.create().texOffs(70, 21).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.4F))
		.texOffs(62, 21).addBox(-1.5F, -6.25F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.1857F, -1.4103F, -0.9685F, 0.6981F, 0.0F, -2.7925F));

		PartDefinition LowerBase_r7 = mound7.addOrReplaceChild("LowerBase_r7", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition lowerHeadJoint = head.addOrReplaceChild("lowerHeadJoint", CubeListBuilder.create(), PartPose.offset(0.0F, -0.7111F, 1.6677F));

		PartDefinition lowerhead = lowerHeadJoint.addOrReplaceChild("lowerhead", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -3.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = lowerhead.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(28, 0).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -6.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Tendrils = lowerhead.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.6148F, -0.7538F, -7.8047F, 1.6144F, 0.0F, 0.0F));

		PartDefinition LT1 = Tendrils.addOrReplaceChild("LT1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0815F, 1.2335F, -0.2848F, 0.0F, -0.3054F, 0.0F));

		PartDefinition LT1_r3 = LT1.addOrReplaceChild("LT1_r3", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg2 = LT1.addOrReplaceChild("LT1Seg2", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.5236F, -0.3054F, 0.0F));

		PartDefinition LT2 = Tendrils.addOrReplaceChild("LT2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1997F, 1.2933F, -0.1967F, 0.0F, 0.0F, 0.3054F));

		PartDefinition LT2Seg1_r3 = LT2.addOrReplaceChild("LT2Seg1_r3", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg2 = LT2.addOrReplaceChild("LT2Seg2", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.5236F, -0.2618F, 0.0F));

		PartDefinition LT3 = Tendrils.addOrReplaceChild("LT3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2603F, 0.8012F, -0.052F, -0.6981F, 0.0F, 0.0F));

		PartDefinition LT3Seg1_r3 = LT3.addOrReplaceChild("LT3Seg1_r3", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg2 = LT3.addOrReplaceChild("LT3Seg2", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.4363F, 0.0F, 0.5236F));

		PartDefinition lowerflower1 = lowerhead.addOrReplaceChild("lowerflower1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9212F, 0.8172F, -6.0314F, -0.3211F, -0.4898F, -0.18F));

		PartDefinition cube_r9 = lowerflower1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-7, 63).addBox(-2.86F, 0.0F, -8.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r10 = lowerflower1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-7, 56).addBox(1.28F, 0.0F, -3.86F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r11 = lowerflower1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-7, 63).addBox(-2.86F, 0.0F, 0.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = lowerflower1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-7, 49).addBox(-7.0F, 0.0F, -3.86F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 2.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition arms = torso.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -7.0F, -2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition arm1 = arms.addOrReplaceChild("arm1", CubeListBuilder.create().texOffs(54, 0).addBox(-2.75F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftForArm = arm1.addOrReplaceChild("LeftForArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.75F, 4.3071F, 0.287F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r13 = LeftForArm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition arm2 = arms.addOrReplaceChild("arm2", CubeListBuilder.create().texOffs(54, 0).addBox(-2.75F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4559F, 0.4057F, 0.091F, -0.542F, -0.276F, 0.0F));

		PartDefinition LeftForArm2 = arm2.addOrReplaceChild("LeftForArm2", CubeListBuilder.create(), PartPose.offset(-1.75F, 5.0F, 0.0F));

		PartDefinition cube_r14 = LeftForArm2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(66, 0).addBox(-1.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition dumpy = torso.addOrReplaceChild("dumpy", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -1.25F));

		PartDefinition Tumor_r15 = dumpy.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(63, 39).mirror().addBox(-2.75F, -2.4F, -2.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -3.0F, 4.0F, -0.5831F, -0.2201F, 0.143F));

		PartDefinition Tumor_r16 = dumpy.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(63, 39).addBox(-2.25F, -2.5F, -2.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.0F, 4.0F, -0.5831F, 0.2201F, -0.143F));

		PartDefinition backtendrils = torso.addOrReplaceChild("backtendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.3648F, -3.7712F, 3.3023F, -1.2654F, 0.0F, 0.0F));

		PartDefinition LT4 = backtendrils.addOrReplaceChild("LT4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0815F, 1.2335F, -0.2848F, -0.1745F, -0.3054F, 0.0F));

		PartDefinition LT1_r4 = LT4.addOrReplaceChild("LT1_r4", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg3 = LT4.addOrReplaceChild("LT1Seg3", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.5236F, -0.3054F, 0.0F));

		PartDefinition LT5 = backtendrils.addOrReplaceChild("LT5", CubeListBuilder.create(), PartPose.offset(1.1997F, 1.2933F, -0.1967F));

		PartDefinition LT2Seg1_r4 = LT5.addOrReplaceChild("LT2Seg1_r4", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg3 = LT5.addOrReplaceChild("LT2Seg3", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.5236F, -0.2618F, 0.0873F));

		PartDefinition LT6 = backtendrils.addOrReplaceChild("LT6", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2397F, 0.8012F, 0.948F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LT3Seg1_r4 = LT6.addOrReplaceChild("LT3Seg1_r4", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg3 = LT6.addOrReplaceChild("LT3Seg3", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.0F, -0.4363F, -0.5236F));

		PartDefinition LT7 = backtendrils.addOrReplaceChild("LT7", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3426F, 0.6727F, -1.0121F, 0.6669F, -0.5389F, 0.2857F));

		PartDefinition LT2_r1 = LT7.addOrReplaceChild("LT2_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT1Seg4 = LT7.addOrReplaceChild("LT1Seg4", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.2F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0522F, -2.9848F, 0.1656F, -0.5236F, -0.3054F, 0.0F));

		PartDefinition LT8 = backtendrils.addOrReplaceChild("LT8", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3097F, 0.3689F, -8.1035F, 0.0F, -0.7113F, 0.0F));

		PartDefinition LT2Seg2_r1 = LT8.addOrReplaceChild("LT2Seg2_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT2Seg4 = LT8.addOrReplaceChild("LT2Seg4", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.15F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(-0.0389F, -3.2663F, 0.0449F, -0.5236F, -0.2618F, 0.0873F));

		PartDefinition LT9 = backtendrils.addOrReplaceChild("LT9", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0304F, -1.6937F, -3.3029F, 0.0F, -0.4499F, -0.8727F));

		PartDefinition LT3Seg2_r1 = LT9.addOrReplaceChild("LT3Seg2_r1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1463F, -1.7324F, -0.075F, 0.0F, 0.0F, 0.0F));

		PartDefinition LT3Seg4 = LT9.addOrReplaceChild("LT3Seg4", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -4.3F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.1899F, -2.636F, -0.1056F, 0.4363F, -0.4363F, 0.5236F));

		PartDefinition largeroots = torso.addOrReplaceChild("largeroots", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition tentacle1 = largeroots.addOrReplaceChild("tentacle1", CubeListBuilder.create(), PartPose.offset(4.0F, -5.0F, -3.0F));

		PartDefinition root_1 = tentacle1.addOrReplaceChild("root_1", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5308F, -0.1796F, -0.7489F));

		PartDefinition r1seg2 = root_1.addOrReplaceChild("r1seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.007F, 4.6864F, 0.0145F, 0.3927F, 0.0F, 0.5236F));

		PartDefinition Seg2_r1 = r1seg2.addOrReplaceChild("Seg2_r1", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition r1seg3 = r1seg2.addOrReplaceChild("r1seg3", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0639F, 6.0281F, 0.0403F, 0.5236F, 0.0F, 0.0F));

		PartDefinition tentacle2 = largeroots.addOrReplaceChild("tentacle2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition root_2 = tentacle2.addOrReplaceChild("root_2", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3142F, -8.6487F, 3.4784F, -0.3927F, 0.0F, -1.7017F));

		PartDefinition r2seg3 = root_2.addOrReplaceChild("r2seg3", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.143F, -5.1864F, -0.0145F, 0.0F, 0.0F, -0.6545F));

		PartDefinition r2seg2 = r2seg3.addOrReplaceChild("r2seg2", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -6.25F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0453F, -5.5083F, -0.0017F, 0.0F, 0.0F, -0.5236F));

		PartDefinition tentacle3 = largeroots.addOrReplaceChild("tentacle3", CubeListBuilder.create(), PartPose.offset(4.3837F, -12.8057F, 1.7892F));

		PartDefinition root_3 = tentacle3.addOrReplaceChild("root_3", CubeListBuilder.create().texOffs(90, 47).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3444F, -0.1925F, 1.2117F));

		PartDefinition r3seg2 = root_3.addOrReplaceChild("r3seg2", CubeListBuilder.create().texOffs(60, 90).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition r3seg3 = r3seg2.addOrReplaceChild("r3seg3", CubeListBuilder.create().texOffs(0, 38).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition torsofungus = torso.addOrReplaceChild("torsofungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0593F, -4.8453F, -1.0976F, 0.6109F, 0.0F, 0.0F));

		PartDefinition Fungus_r5 = torsofungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 56).addBox(2.5F, -2.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 2.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = torsofungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 49).addBox(-5.5F, 0.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = torsofungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 49).addBox(-2.25F, -2.0F, 0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 2.8975F, -0.4493F, 0.54F, 0.1171F));

		PartDefinition Fungus_r8 = torsofungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 63).addBox(-4.5F, -1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition roots = the_twat.addOrReplaceChild("roots", CubeListBuilder.create().texOffs(56, 104).addBox(-12.0F, 0.0F, -12.0F, 24.0F, 0.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void animateTendril(ModelPart part,float value){
		part.xRot = Mth.sin(value/6)/7;
		part.zRot = Mth.sin(value/7)/6;
	}
	private void animateTumor(ModelPart part,float value){
		part.xScale = 1 + Mth.sin(value/8)/8;
		part.yScale = 1 + Mth.sin(value/8)/8;
		part.zScale = 1 + Mth.sin(value/8)/8;
	}
	private void animateMound(ModelPart part,float value){
		part.xScale =1+ Mth.cos(value/9)/6;
		part.yScale =1- Mth.cos(value/9)/6;
		part.zScale =1+ Mth.cos(value/9)/6;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Roots.visible = entity.isRooted();
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.Torso.xRot = Mth.sin(ageInTicks/8)/8;
		animateTendril(Tendril1,ageInTicks);
		animateTendril(Tendril2,-ageInTicks);
		animateTendril(Tendril3,ageInTicks/2);
		animateTendril(Tendril4,-ageInTicks);
		animateTendril(Tendril5,ageInTicks*2);
		animateTendril(Tendril6,ageInTicks);
		this.Arm1.xRot = Mth.sin(ageInTicks/7)/6;
		this.Arm1.yRot = Mth.sin(ageInTicks/7)/7;
		this.Arm2.zRot = Mth.sin(ageInTicks/6)/7;
		animateTumor(TumorousMass,ageInTicks);
		animateMound(Mound1,ageInTicks);
		animateMound(Mound2,ageInTicks/2);
		animateMound(Mound3,-ageInTicks);
		animateMound(Mound4,ageInTicks);
		Mound2.yRot = Mth.sin(ageInTicks/8)/7;
		Mound3.yRot = Mth.cos(ageInTicks/8)/6;
		Mound4.yRot = Mth.sin(ageInTicks/6)/8;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		the_twat.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}