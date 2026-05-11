package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Gorgon;
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

public class gorgonModel<T extends Gorgon> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "gorgonmodel"), "main");
	private final ModelPart groggon;
	private final ModelPart head;
	private final ModelPart hat;
	private final ModelPart hat2;
	private final ModelPart hat3;
	private final ModelPart hat4;
	private final ModelPart mouth;
	private final ModelPart facetumor;
	private final ModelPart facetumor2;
	private final ModelPart facetumor3;
	private final ModelPart facetumor4;
	private final ModelPart facetumor5;
	private final ModelPart facetumor6;
	private final ModelPart facetumor7;
	private final ModelPart facetumor8;
	private final ModelPart facetumor9;
	private final ModelPart facetentacles;
	private final ModelPart tentacle;
	private final ModelPart tentaclemiddle;
	private final ModelPart tentacle2;
	private final ModelPart tentaclemiddle2;
	private final ModelPart tentacle3;
	private final ModelPart tentaclemiddle3;
	private final ModelPart tentacle4;
	private final ModelPart tentaclemiddle4;
	private final ModelPart tentacle5;
	private final ModelPart tentaclemiddle5;
	private final ModelPart tentacle6;
	private final ModelPart tentaclemiddle6;
	private final ModelPart torso;
	private final ModelPart uppertorso;
	private final ModelPart booba;
	private final ModelPart arms;
	private final ModelPart leftarm;
	private final ModelPart lefthand;
	private final ModelPart leftclaws2;
	private final ModelPart rightarm;
	private final ModelPart righthand;
	private final ModelPart rightclaws;
	private final ModelPart backtentacles;
	private final ModelPart tentacle7;
	private final ModelPart tentaclemiddle7;
	private final ModelPart tentacletips7;
	private final ModelPart tentacle8;
	private final ModelPart tentaclemiddle8;
	private final ModelPart tentacletips8;
	private final ModelPart uppersack;
	private final ModelPart lowertorso;
	private final ModelPart lowersack;
	private final ModelPart tail;
	private final ModelPart tailseg1;
	private final ModelPart tailseg2;
	private final ModelPart tailseg3;
	private final ModelPart tailseg4;
	private final ModelPart tailseg5;
	private final ModelPart legs;
	private final ModelPart leftleg;
	private final ModelPart leftfoot;
	private final ModelPart rightleg;
	private final ModelPart rightfoot;

	public gorgonModel(ModelPart root) {
		this.groggon = root.getChild("groggon");
		this.head = this.groggon.getChild("head");
		this.hat = this.head.getChild("hat");
		this.hat2 = this.hat.getChild("hat2");
		this.hat3 = this.hat2.getChild("hat3");
		this.hat4 = this.hat3.getChild("hat4");
		this.mouth = this.head.getChild("mouth");
		this.facetumor = this.mouth.getChild("facetumor");
		this.facetumor2 = this.mouth.getChild("facetumor2");
		this.facetumor3 = this.mouth.getChild("facetumor3");
		this.facetumor4 = this.mouth.getChild("facetumor4");
		this.facetumor5 = this.mouth.getChild("facetumor5");
		this.facetumor6 = this.mouth.getChild("facetumor6");
		this.facetumor7 = this.mouth.getChild("facetumor7");
		this.facetumor8 = this.mouth.getChild("facetumor8");
		this.facetumor9 = this.mouth.getChild("facetumor9");
		this.facetentacles = this.head.getChild("facetentacles");
		this.tentacle = this.facetentacles.getChild("tentacle");
		this.tentaclemiddle = this.tentacle.getChild("tentaclemiddle");
		this.tentacle2 = this.facetentacles.getChild("tentacle2");
		this.tentaclemiddle2 = this.tentacle2.getChild("tentaclemiddle2");
		this.tentacle3 = this.facetentacles.getChild("tentacle3");
		this.tentaclemiddle3 = this.tentacle3.getChild("tentaclemiddle3");
		this.tentacle4 = this.facetentacles.getChild("tentacle4");
		this.tentaclemiddle4 = this.tentacle4.getChild("tentaclemiddle4");
		this.tentacle5 = this.facetentacles.getChild("tentacle5");
		this.tentaclemiddle5 = this.tentacle5.getChild("tentaclemiddle5");
		this.tentacle6 = this.facetentacles.getChild("tentacle6");
		this.tentaclemiddle6 = this.tentacle6.getChild("tentaclemiddle6");
		this.torso = this.groggon.getChild("torso");
		this.uppertorso = this.torso.getChild("uppertorso");
		this.booba = this.uppertorso.getChild("booba");
		this.arms = this.uppertorso.getChild("arms");
		this.leftarm = this.arms.getChild("leftarm");
		this.lefthand = this.leftarm.getChild("lefthand");
		this.leftclaws2 = this.lefthand.getChild("leftclaws2");
		this.rightarm = this.arms.getChild("rightarm");
		this.righthand = this.rightarm.getChild("righthand");
		this.rightclaws = this.righthand.getChild("rightclaws");
		this.backtentacles = this.uppertorso.getChild("backtentacles");
		this.tentacle7 = this.backtentacles.getChild("tentacle7");
		this.tentaclemiddle7 = this.tentacle7.getChild("tentaclemiddle7");
		this.tentacletips7 = this.tentaclemiddle7.getChild("tentacletips7");
		this.tentacle8 = this.backtentacles.getChild("tentacle8");
		this.tentaclemiddle8 = this.tentacle8.getChild("tentaclemiddle8");
		this.tentacletips8 = this.tentaclemiddle8.getChild("tentacletips8");
		this.uppersack = this.uppertorso.getChild("uppersack");
		this.lowertorso = this.torso.getChild("lowertorso");
		this.lowersack = this.lowertorso.getChild("lowersack");
		this.tail = this.lowertorso.getChild("tail");
		this.tailseg1 = this.tail.getChild("tailseg1");
		this.tailseg2 = this.tailseg1.getChild("tailseg2");
		this.tailseg3 = this.tailseg2.getChild("tailseg3");
		this.tailseg4 = this.tailseg3.getChild("tailseg4");
		this.tailseg5 = this.tailseg4.getChild("tailseg5");
		this.legs = this.groggon.getChild("legs");
		this.leftleg = this.legs.getChild("leftleg");
		this.leftfoot = this.leftleg.getChild("leftfoot");
		this.rightleg = this.legs.getChild("rightleg");
		this.rightfoot = this.rightleg.getChild("rightfoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition groggon = partdefinition.addOrReplaceChild("groggon", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, -1.0F));

		PartDefinition head = groggon.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-4.0F, -9.0F, -7.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.75F, -4.0F));

		PartDefinition foliage_r1 = head.addOrReplaceChild("foliage_r1", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -4.25F, -0.5F, 0.2041F, 0.1509F, 0.6033F));

		PartDefinition foliage_r2 = head.addOrReplaceChild("foliage_r2", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -7.25F, -3.5F, -1.516F, -0.2717F, 0.6733F));

		PartDefinition foliage_r3 = head.addOrReplaceChild("foliage_r3", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -4.25F, -1.5F, -0.2523F, -0.4171F, -0.3321F));

		PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(0, 0).addBox(-5.1942F, -1.1184F, -5.1835F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.425F, -8.1F, -0.45F, -0.692F, -0.203F, -0.0468F));

		PartDefinition hat2 = hat.addOrReplaceChild("hat2", CubeListBuilder.create().texOffs(40, 0).addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4442F, -5.1184F, -3.1835F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition foliage_r4 = hat2.addOrReplaceChild("foliage_r4", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.65F, 1.85F, 5.45F, -0.2857F, -0.1431F, -0.1798F));

		PartDefinition foliage_r5 = hat2.addOrReplaceChild("foliage_r5", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.15F, 1.85F, 1.45F, 0.1891F, -0.0331F, 0.1714F));

		PartDefinition hat3 = hat2.addOrReplaceChild("hat3", CubeListBuilder.create().texOffs(44, 76).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition foliage_r6 = hat3.addOrReplaceChild("foliage_r6", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 2.45F, 0.95F, 2.6409F, 1.1715F, 2.4614F));

		PartDefinition hat4 = hat3.addOrReplaceChild("hat4", CubeListBuilder.create().texOffs(26, 48).addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition mouth = head.addOrReplaceChild("mouth", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -5.0F));

		PartDefinition facetumor = mouth.addOrReplaceChild("facetumor", CubeListBuilder.create().texOffs(66, 34).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(58, 49).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -2.2F, -1.5F, 0.0F, -0.829F, 0.0F));

		PartDefinition facetumor2 = mouth.addOrReplaceChild("facetumor2", CubeListBuilder.create().texOffs(78, 34).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(62, 49).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.5F, -0.3202F, -0.7466F, -0.0406F));

		PartDefinition facetumor3 = mouth.addOrReplaceChild("facetumor3", CubeListBuilder.create().texOffs(84, 0).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(66, 49).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.5F, -1.5F, 0.4912F, -1.0819F, -0.1196F));

		PartDefinition facetumor4 = mouth.addOrReplaceChild("facetumor4", CubeListBuilder.create().texOffs(38, 84).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(70, 49).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 4.5F, -1.5F, -0.3002F, -1.4154F, 1.5461F));

		PartDefinition facetumor5 = mouth.addOrReplaceChild("facetumor5", CubeListBuilder.create().texOffs(84, 40).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(44, 73).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 4.0F, -1.5F, 3.098F, -1.5272F, -0.6109F));

		PartDefinition facetumor6 = mouth.addOrReplaceChild("facetumor6", CubeListBuilder.create().texOffs(10, 85).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(48, 73).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.5F, -1.5F, -2.8981F, -1.2318F, -2.8981F));

		PartDefinition facetumor7 = mouth.addOrReplaceChild("facetumor7", CubeListBuilder.create().texOffs(50, 85).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(74, 62).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -4.5F, -1.5F, -0.3909F, -1.0481F, -0.7405F));

		PartDefinition facetumor8 = mouth.addOrReplaceChild("facetumor8", CubeListBuilder.create().texOffs(62, 85).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(78, 62).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -0.5F, -1.5F, 2.9671F, -1.2654F, 3.1416F));

		PartDefinition facetumor9 = mouth.addOrReplaceChild("facetumor9", CubeListBuilder.create().texOffs(74, 85).addBox(-2.0F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(82, 19).addBox(-4.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.5F, -1.5F, -2.8845F, -1.185F, 3.0636F));

		PartDefinition facetentacles = head.addOrReplaceChild("facetentacles", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, -5.0F));

		PartDefinition tentacle = facetentacles.addOrReplaceChild("tentacle", CubeListBuilder.create().texOffs(87, 86).addBox(-0.4524F, -0.5262F, -3.0015F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.3F, 0.1F, -3.8F, -0.0262F, -0.5712F, -0.3031F));

		PartDefinition tentaclemiddle = tentacle.addOrReplaceChild("tentaclemiddle", CubeListBuilder.create().texOffs(90, 19).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0476F, -0.0262F, -2.7515F, 0.0F, -0.6545F, 0.0F));

		PartDefinition tentacle2 = facetentacles.addOrReplaceChild("tentacle2", CubeListBuilder.create().texOffs(91, 25).addBox(-0.4556F, -0.6294F, -3.0094F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.8F, 1.6F, -3.6F, -0.1299F, 0.8283F, -0.0114F));

		PartDefinition tentaclemiddle2 = tentacle2.addOrReplaceChild("tentaclemiddle2", CubeListBuilder.create().texOffs(90, 29).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2056F, -0.1294F, -2.5094F, -0.049F, 0.4003F, -0.0533F));

		PartDefinition tentacle3 = facetentacles.addOrReplaceChild("tentacle3", CubeListBuilder.create().texOffs(91, 35).addBox(-0.6307F, -0.6308F, -3.0173F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.2F, -3.0F, -3.7F, -0.1324F, -0.4361F, -0.0097F));

		PartDefinition tentaclemiddle3 = tentacle3.addOrReplaceChild("tentaclemiddle3", CubeListBuilder.create().texOffs(38, 90).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1307F, -0.1308F, -2.7673F, 0.2706F, -0.7945F, 0.0692F));

		PartDefinition tentacle4 = facetentacles.addOrReplaceChild("tentacle4", CubeListBuilder.create().texOffs(91, 47).addBox(-0.4072F, -0.3421F, -3.0169F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(3.7F, -2.3F, -3.5F, 0.1593F, 0.0816F, -0.4699F));

		PartDefinition tentaclemiddle4 = tentacle4.addOrReplaceChild("tentaclemiddle4", CubeListBuilder.create().texOffs(90, 51).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1572F, 0.1579F, -2.7669F, 0.0F, 1.309F, 0.0F));

		PartDefinition tentacle5 = facetentacles.addOrReplaceChild("tentacle5", CubeListBuilder.create().texOffs(87, 91).addBox(-0.4233F, -0.4406F, -3.0047F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.0F, 4.0F, -3.5F, 0.061F, 0.2281F, -0.3304F));

		PartDefinition tentaclemiddle5 = tentacle5.addOrReplaceChild("tentaclemiddle5", CubeListBuilder.create().texOffs(10, 91).addBox(-0.4F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1733F, 0.0594F, -2.5047F, 0.8997F, 1.1767F, 0.8605F));

		PartDefinition tentacle6 = facetentacles.addOrReplaceChild("tentacle6", CubeListBuilder.create().texOffs(21, 92).addBox(-0.4574F, -0.2836F, -3.0246F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-3.2F, 2.5F, -3.6F, 0.2317F, -0.3405F, -0.0786F));

		PartDefinition tentaclemiddle6 = tentacle6.addOrReplaceChild("tentaclemiddle6", CubeListBuilder.create().texOffs(48, 91).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0426F, 0.2164F, -2.7746F, 0.3824F, -0.8244F, -0.1705F));

		PartDefinition torso = groggon.addOrReplaceChild("torso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.5F, 2.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition uppertorso = torso.addOrReplaceChild("uppertorso", CubeListBuilder.create().texOffs(32, 12).addBox(-5.0F, -6.5F, -5.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(32, 26).addBox(-5.0F, -6.5F, -5.0F, 10.0F, 7.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition booba = uppertorso.addOrReplaceChild("booba", CubeListBuilder.create().texOffs(26, 52).addBox(-5.0F, -2.5102F, -9.1197F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 40).addBox(-5.0F, -2.5102F, -9.1197F, 9.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.5F, -0.4706F, 2.5933F, -0.3491F, 0.0F, 0.0F));

		PartDefinition foliage_r7 = booba.addOrReplaceChild("foliage_r7", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6F, 0.4706F, -7.6933F, -0.1198F, 0.1996F, -1.5474F));

		PartDefinition arms = uppertorso.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.1706F, -1.3067F, -0.6545F, 0.0F, 0.0F));

		PartDefinition leftarm = arms.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(66, 22).addBox(0.0F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(102, 0).addBox(0.0F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.5F, -1.8925F, -0.5873F, 0.0F, 0.0F, -0.0436F));

		PartDefinition lefthand = leftarm.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(14, 73).addBox(-1.5F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 8.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition foliage_r8 = lefthand.addOrReplaceChild("foliage_r8", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 3.6706F, -0.1933F, 0.1483F, 0.504F, 0.3001F));

		PartDefinition foliage_r9 = lefthand.addOrReplaceChild("foliage_r9", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.6706F, 0.8067F, 0.0739F, -0.4253F, 0.2399F));

		PartDefinition leftclaws2 = lefthand.addOrReplaceChild("leftclaws2", CubeListBuilder.create().texOffs(0, 97).addBox(5.0F, -13.3294F, -9.6933F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 97).addBox(5.0F, -13.3294F, -7.6933F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 97).addBox(5.0F, -13.8294F, -8.6933F, 5.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 19.0F, 9.0F));

		PartDefinition rightarm = arms.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(68, 65).addBox(-3.0F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(102, 12).addBox(-3.0F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.5F, -1.8924F, -0.5873F, 0.0F, 0.0F, 0.0436F));

		PartDefinition foliage_r10 = rightarm.addOrReplaceChild("foliage_r10", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.6706F, 0.8067F, -2.9444F, -0.8379F, -2.9678F));

		PartDefinition foliage_r11 = rightarm.addOrReplaceChild("foliage_r11", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.9706F, 0.8067F, -0.1309F, 0.7854F, -0.3054F));

		PartDefinition foliage_r12 = rightarm.addOrReplaceChild("foliage_r12", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 3.6706F, 0.8067F, 0.1309F, -0.4014F, 0.0436F));

		PartDefinition righthand = rightarm.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(0, 71).addBox(-1.5F, -0.3294F, -1.6933F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 8.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition rightclaws = righthand.addOrReplaceChild("rightclaws", CubeListBuilder.create().texOffs(2, 118).addBox(-11.0F, -13.3294F, -9.6933F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 118).addBox(-11.0F, -13.3294F, -7.6933F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(2, 118).addBox(-11.0F, -13.8294F, -8.6933F, 5.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(7.5F, 19.0F, 9.0F));

		PartDefinition backtentacles = uppertorso.addOrReplaceChild("backtentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tentacle7 = backtentacles.addOrReplaceChild("tentacle7", CubeListBuilder.create().texOffs(58, 91).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.5F, -3.75F, 1.0F, -2.693F, -0.5661F, -0.0367F));

		PartDefinition tentaclemiddle7 = tentacle7.addOrReplaceChild("tentaclemiddle7", CubeListBuilder.create().texOffs(68, 91).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.75F, 0.2728F, 0.3478F, 0.2116F));

		PartDefinition tentacletips7 = tentaclemiddle7.addOrReplaceChild("tentacletips7", CubeListBuilder.create().texOffs(92, 60).addBox(-0.5F, -0.75F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.5556F, -0.1737F, 0.2882F));

		PartDefinition tentacle8 = backtentacles.addOrReplaceChild("tentacle8", CubeListBuilder.create().texOffs(0, 92).addBox(-0.5F, -0.5F, -5.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.5F, -2.75F, 0.0F, -2.4211F, -0.0667F, 2.5242F));

		PartDefinition tentaclemiddle8 = tentacle8.addOrReplaceChild("tentaclemiddle8", CubeListBuilder.create().texOffs(92, 6).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.75F, 0.2728F, 0.3478F, 0.2116F));

		PartDefinition tentacletips8 = tentaclemiddle8.addOrReplaceChild("tentacletips8", CubeListBuilder.create().texOffs(92, 64).addBox(-0.5F, -0.75F, -2.5F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.5556F, -0.1737F, 0.2882F));

		PartDefinition uppersack = uppertorso.addOrReplaceChild("uppersack", CubeListBuilder.create().texOffs(0, 60).addBox(-0.8F, -3.75F, -2.25F, 5.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(68, 0).addBox(-3.7F, -1.75F, -2.25F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.2F, -2.25F, 3.25F));

		PartDefinition lowertorso = torso.addOrReplaceChild("lowertorso", CubeListBuilder.create().texOffs(32, 40).addBox(-4.0F, -6.5F, -3.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-4.0F, -6.5F, -3.5F, 8.0F, 7.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition foliage_r13 = lowertorso.addOrReplaceChild("foliage_r13", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.5F, -2.8F, 0.1309F, 0.9163F, 0.0F));

		PartDefinition lowersack = lowertorso.addOrReplaceChild("lowersack", CubeListBuilder.create().texOffs(52, 52).addBox(-3.0F, -4.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 3.5F));

		PartDefinition tail = lowertorso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0287F, -0.3919F, 1.7666F, -0.3316F, 0.0F, 0.0F));

		PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(118, 123).addBox(-1.0F, -1.0937F, -0.5774F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0287F, 1.6919F, 0.8334F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(120, 118).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4287F, 0.4919F, -0.8666F, -1.1152F, 0.0121F, -0.0214F));

		PartDefinition tailseg1 = tail.addOrReplaceChild("tailseg1", CubeListBuilder.create(), PartPose.offset(-0.0213F, 3.2099F, 3.1864F));

		PartDefinition cube_r3 = tailseg1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(112, 118).addBox(-1.0F, -0.6073F, -0.7544F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.45F, -0.418F, 0.147F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tailseg2 = tailseg1.addOrReplaceChild("tailseg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.05F, 2.0712F, 1.295F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r4 = tailseg2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(108, 123).addBox(-1.0F, -1.3843F, -0.212F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2892F, -0.7479F, -0.9076F, 0.0F, 0.0F));

		PartDefinition tailseg3 = tailseg2.addOrReplaceChild("tailseg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.05F, 1.462F, 1.8526F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r5 = tailseg3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(104, 118).addBox(-1.0F, -1.2014F, -0.3982F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.45F, -0.2511F, -0.6006F, -0.6458F, 0.0F, 0.0F));

		PartDefinition tailseg4 = tailseg3.addOrReplaceChild("tailseg4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.05F, 0.8579F, 1.2667F, -0.2269F, 0.0F, 0.0F));

		PartDefinition cube_r6 = tailseg4.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(97, 122).addBox(-1.0F, -1.0355F, 0.0343F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.091F, -0.2673F, -0.0349F, 0.0F, 0.0F));

		PartDefinition tailseg5 = tailseg4.addOrReplaceChild("tailseg5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.2963F, 1.2658F));

		PartDefinition cube_r7 = tailseg5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(116, 106).addBox(0.0F, -3.0F, -2.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.0174F, 2.0003F, 0.0F, 0.0349F, 1.5708F));

		PartDefinition cube_r8 = tailseg5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(116, 106).addBox(0.0F, -3.0F, -2.5F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1174F, 2.0003F, -0.0349F, 0.0F, 0.0F));

		PartDefinition legs = groggon.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 1.0F));

		PartDefinition leftleg = legs.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(36, 61).addBox(-1.9F, -0.75F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(28, 73).addBox(-1.9F, -0.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.1F, -0.25F, 0.0F, -0.1308F, -0.0057F, -0.0433F));

		PartDefinition foliage_r14 = leftleg.addOrReplaceChild("foliage_r14", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 5.25F, 1.2F, -0.1262F, 0.0871F, 0.5225F));

		PartDefinition leftfoot = leftleg.addOrReplaceChild("leftfoot", CubeListBuilder.create().texOffs(66, 11).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.1F, 7.75F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition rightleg = legs.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(20, 61).addBox(-2.075F, -0.75F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 49).addBox(-2.075F, -0.75F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.075F, -0.25F, 0.0F, -0.1308F, 0.0057F, 0.0433F));

		PartDefinition rightfoot = rightleg.addOrReplaceChild("rightfoot", CubeListBuilder.create().texOffs(52, 65).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.125F, 7.75F, 0.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition foliage_r15 = rightfoot.addOrReplaceChild("foliage_r15", CubeListBuilder.create().texOffs(76, 121).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 1.5F, -1.5F, 0.2182F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val1 = Mth.cos(ageInTicks/5)/9;
		float val2 = Mth.sin(ageInTicks/6)/11;
		float val3 = Mth.cos(ageInTicks/8)/12;
		float val4 = Mth.sin(ageInTicks/7)/10;
		float val5 = Mth.cos(ageInTicks/8)/13;
		int attackAN = entity.getAttackAnimationTick();
		int vomitAN = entity.getMouthAnimationTick();
		if (vomitAN > 0){
			this.rightarm.xRot = 0.75F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			this.leftarm.xRot = 0.75F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			this.rightarm.zRot = 0.2f;
			this.leftarm.zRot = -0.2f;
		}else if (attackAN > 0){
			this.rightarm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAN, 20.0F);
			this.leftarm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAN, 20.0F);
		} else if (!(limbSwingAmount > -0.05F && limbSwingAmount < 0.15F)){
			this.rightarm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.leftarm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.rightarm.zRot = 0;
			this.leftarm.zRot = 0;
			this.booba.y = booba.getInitialPose().y+ Mth.cos(limbSwing * 0.2F) * -0.2F * limbSwingAmount;
		}else {
			this.rightarm.xRot = Mth.sin(ageInTicks/8)/10;
			this.leftarm.xRot = -Mth.sin(ageInTicks/8)/10;
		}
		animateTentacleX(tentacle7,val1);
		animateTentacleX(tentaclemiddle7,val3);
		animateTentacleX(tentacletips7,val5);
		animateTentacleZ(tentacle8,val2);
		animateTentacleZ(tentaclemiddle8,val4);
		animateTentacleZ(tentacletips8,val2);

		animateTentacleY(tail,val2);
		animateTentacleY(tailseg1,val2);
		animateTentacleY(tailseg2,val2);
		animateTentacleY(tailseg3,val2);
		animateTentacleY(tailseg4,val2);
		animateTentacleY(tailseg5,val2);

		this.head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.leftleg.xRot = Mth.cos(limbSwing ) * limbSwingAmount;
		this.rightleg.xRot = -leftleg.xRot;
		this.leftfoot.xRot = leftleg.xRot < 0 ? -leftleg.xRot : 0;
		this.rightfoot.xRot = rightleg.xRot < 0 ? -rightleg.xRot : 0;

		if(vomitAN > 0){
			float val  = 1F - 0.75F * Mth.triangleWave((float)vomitAN, 20.0F);
			animateTentacleY(tentacle,val);
			animateTentacleY(tentaclemiddle,val);
			animateTentacleY(tentacle2,-val);
			animateTentacleY(tentaclemiddle2,-val);
			animateTentacleY(tentacle3,val);
			animateTentacleY(tentaclemiddle3,val);
			animateTentacleY(tentacle4,-val);
			animateTentacleY(tentaclemiddle4,-val);
			animateTentacleY(tentacle5,-val);
			animateTentacleY(tentaclemiddle5,-val);
			animateTentacleY(tentacle6,val);
			animateTentacleY(tentaclemiddle6,val);
		}else {
			animateTentacleY(tentacle,val1);
			animateTentacleY(tentaclemiddle,val1);
			animateTentacleY(tentacle2,val3);
			animateTentacleY(tentaclemiddle2,val3);
			animateTentacleY(tentacle3,val4);
			animateTentacleY(tentaclemiddle3,val4);
			animateTentacleY(tentacle4,val5);
			animateTentacleY(tentaclemiddle4,val5);
			animateTentacleY(tentacle5,-val1);
			animateTentacleY(tentaclemiddle5,-val1);
			animateTentacleY(tentacle6,-val2);
			animateTentacleY(tentaclemiddle7,-val2);
		}
		float val = 0.75f + (entity.getSpores() * 0.05f);
		tumor(uppersack,val);
		tumor(lowersack,val);
	}
	public void tumor(ModelPart part,float val){
		part.xScale = val;
		part.yScale = val;
		part.zScale = val;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		groggon.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}