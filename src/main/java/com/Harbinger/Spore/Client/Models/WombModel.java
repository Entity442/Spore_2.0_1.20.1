package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Womb;
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

public class WombModel<T extends Womb> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "wombmodel"), "main");
	private final ModelPart SporePod;
	private final ModelPart TumorBase;
	private final ModelPart Base;
	private final ModelPart Body;
	private final ModelPart Brains;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Brain4;
	private final ModelPart Tendrils2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;
	private final ModelPart Seg3Tendril3;
	private final ModelPart Tendril4;
	private final ModelPart Seg2Tendril4;
	private final ModelPart Seg3Tendril4;
	private final ModelPart Jaw;
	private final ModelPart RightJaw;
	private final ModelPart LeftJaw;
	private final ModelPart Tendrils;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Seg3Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Seg3Tendril2;

	public WombModel(ModelPart root) {
		this.SporePod = root.getChild("SporePod");
		this.TumorBase = this.SporePod.getChild("TumorBase");
		this.Base = this.SporePod.getChild("Base");
		this.Body = this.Base.getChild("Body");
		this.Brains = this.Body.getChild("Brains");
		this.Brain1 = this.Brains.getChild("Brain1");
		this.Brain2 = this.Brains.getChild("Brain2");
		this.Brain3 = this.Brains.getChild("Brain3");
		this.Brain4 = this.Brains.getChild("Brain4");
		this.Tendrils2 = this.Body.getChild("Tendrils2");
		this.Tendril3 = this.Tendrils2.getChild("Tendril3");
		this.Seg2Tendril3 = this.Tendril3.getChild("Seg2Tendril3");
		this.Seg3Tendril3 = this.Seg2Tendril3.getChild("Seg3Tendril3");
		this.Tendril4 = this.Tendrils2.getChild("Tendril4");
		this.Seg2Tendril4 = this.Tendril4.getChild("Seg2Tendril4");
		this.Seg3Tendril4 = this.Seg2Tendril4.getChild("Seg3Tendril4");
		this.Jaw = this.Body.getChild("Jaw");
		this.RightJaw = this.Jaw.getChild("RightJaw");
		this.LeftJaw = this.Jaw.getChild("LeftJaw");
		this.Tendrils = this.SporePod.getChild("Tendrils");
		this.Tendril1 = this.Tendrils.getChild("Tendril1");
		this.Seg2Tendril1 = this.Tendril1.getChild("Seg2Tendril1");
		this.Seg3Tendril1 = this.Seg2Tendril1.getChild("Seg3Tendril1");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Seg3Tendril2 = this.Seg2Tendril2.getChild("Seg3Tendril2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SporePod = partdefinition.addOrReplaceChild("SporePod", CubeListBuilder.create(), PartPose.offset(-0.85F, 24.0F, -3.0F));

		PartDefinition TumorBase = SporePod.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(2.0062F, -1.7921F, 4.1882F));

		PartDefinition Biomass_r1 = TumorBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(2, 2).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = TumorBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(4, 3).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = TumorBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(5, 5).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = TumorBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(5, 4).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r5 = TumorBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7284F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition Base = SporePod.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = Base.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(2.0F, 0.0F, 6.0F));

		PartDefinition Segment = Body.addOrReplaceChild("Segment", CubeListBuilder.create(), PartPose.offset(1.0F, -6.0F, -2.0F));

		PartDefinition BodyBase_r1 = Segment.addOrReplaceChild("BodyBase_r1", CubeListBuilder.create().texOffs(0, 79).addBox(-2.0953F, -5.9221F, -6.6321F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8119F, 0.9631F, -0.9249F, 0.3054F, -0.8727F, -0.3054F));

		PartDefinition BodyBase_r2 = Segment.addOrReplaceChild("BodyBase_r2", CubeListBuilder.create().texOffs(2, 94).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5619F, -10.0369F, -1.6749F, -0.5245F, -0.7598F, 0.7223F));

		PartDefinition BodyBase_r3 = Segment.addOrReplaceChild("BodyBase_r3", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-7.3119F, -5.0369F, -2.9249F, -0.1745F, -0.8727F, 0.3491F));

		PartDefinition Segment2 = Body.addOrReplaceChild("Segment2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -5.0F, -2.0F, 0.0F, -1.0908F, 0.0F));

		PartDefinition BodyBase_r4 = Segment2.addOrReplaceChild("BodyBase_r4", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8119F, 0.9631F, -1.6749F, 0.3054F, -0.8727F, -0.3054F));

		PartDefinition BodyBase_r5 = Segment2.addOrReplaceChild("BodyBase_r5", CubeListBuilder.create().texOffs(2, 94).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5619F, -10.0369F, -1.6749F, -0.5245F, -0.7598F, 0.7223F));

		PartDefinition BodyBase_r6 = Segment2.addOrReplaceChild("BodyBase_r6", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-7.3119F, -5.0369F, -2.9249F, -0.1745F, -0.8727F, 0.3491F));

		PartDefinition Segment3 = Body.addOrReplaceChild("Segment3", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -5.0F, -2.0F, 0.0F, 1.0036F, 0.0F));

		PartDefinition BodyBase_r7 = Segment3.addOrReplaceChild("BodyBase_r7", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8119F, 0.9631F, -1.6749F, 0.3054F, -0.8727F, -0.3054F));

		PartDefinition BodyBase_r8 = Segment3.addOrReplaceChild("BodyBase_r8", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5619F, -10.0369F, -1.6749F, -0.5245F, -0.7598F, 0.7223F));

		PartDefinition BodyBase_r9 = Segment3.addOrReplaceChild("BodyBase_r9", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-7.3119F, -5.0369F, -2.9249F, -0.1745F, -0.8727F, 0.3491F));

		PartDefinition Segment4 = Body.addOrReplaceChild("Segment4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.0F, -2.2253F, 0.0F));

		PartDefinition BodyBase_r10 = Segment4.addOrReplaceChild("BodyBase_r10", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8119F, 0.9631F, -1.6749F, 0.3054F, -0.8727F, -0.3054F));

		PartDefinition BodyBase_r11 = Segment4.addOrReplaceChild("BodyBase_r11", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5619F, -10.0369F, -1.6749F, -0.5245F, -0.7598F, 0.7223F));

		PartDefinition BodyBase_r12 = Segment4.addOrReplaceChild("BodyBase_r12", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-7.3119F, -5.0369F, -2.9249F, -0.1745F, -0.8727F, 0.3491F));

		PartDefinition Segment5 = Body.addOrReplaceChild("Segment5", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -5.0F, -3.0F, 0.0F, 2.618F, 0.0F));

		PartDefinition BodyBase_r13 = Segment5.addOrReplaceChild("BodyBase_r13", CubeListBuilder.create().texOffs(32, 76).addBox(-2.0953F, -6.9221F, -6.6321F, 4.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8119F, 0.9631F, -1.6749F, 0.3054F, -0.8727F, -0.3054F));

		PartDefinition BodyBase_r14 = Segment5.addOrReplaceChild("BodyBase_r14", CubeListBuilder.create().texOffs(1, 79).addBox(-3.0953F, -5.9221F, -5.6321F, 5.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5619F, -10.0369F, -1.6749F, -0.5245F, -0.7598F, 0.7223F));

		PartDefinition BodyBase_r15 = Segment5.addOrReplaceChild("BodyBase_r15", CubeListBuilder.create().texOffs(0, 107).addBox(-2.0953F, -5.9221F, -5.6321F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-7.3119F, -5.0369F, -2.9249F, -0.1745F, -0.8727F, 0.3491F));

		PartDefinition Brains = Body.addOrReplaceChild("Brains", CubeListBuilder.create(), PartPose.offset(-2.0F, -7.0F, -6.0F));

		PartDefinition Brain1 = Brains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(80, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(57, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(57, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(6.6527F, -1.8588F, 9.436F, -1.0555F, 0.7365F, 0.0835F));

		PartDefinition Brain2 = Brains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(80, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(57, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(57, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(8.6527F, -0.8588F, -0.564F, 1.1795F, -0.9674F, 0.3275F));

		PartDefinition Brain3 = Brains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(80, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(57, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(57, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.3473F, -1.8588F, 8.436F, -1.2846F, -0.1742F, 0.2F));

		PartDefinition Brain4 = Brains.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(80, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(57, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(57, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.3473F, -3.8588F, 0.436F, 1.2904F, 0.5209F, 0.0568F));

		PartDefinition Tendrils2 = Body.addOrReplaceChild("Tendrils2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril3 = Tendrils2.addOrReplaceChild("Tendril3", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7663F, -10.8057F, -3.2108F, -2.962F, 0.208F, 2.0373F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, -0.3927F, 0.0F, -0.2182F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(16, 25).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.6094F, -0.2069F, 0.4361F));

		PartDefinition Tendril4 = Tendrils2.addOrReplaceChild("Tendril4", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2337F, -10.8057F, -10.2108F, 1.0178F, -0.4968F, 0.2861F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.5236F, 0.0F, -0.2182F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(16, 25).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, 0.9178F, 0.0F, 0.0F));

		PartDefinition Jaw = Body.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 40).addBox(-7.0F, -10.0F, -4.0F, 14.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1424F, -15.1743F, -6.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition RightJaw = Jaw.addOrReplaceChild("RightJaw", CubeListBuilder.create(), PartPose.offset(0.3838F, -6.8279F, -4.1379F));

		PartDefinition HeadLeftTeeth_r1 = RightJaw.addOrReplaceChild("HeadLeftTeeth_r1", CubeListBuilder.create().texOffs(60, 30).addBox(-2.75F, 3.35F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(20, 24).addBox(-2.75F, -3.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5847F, -2.8175F, -1.2745F, -0.1372F, -0.0042F, 0.4948F));

		PartDefinition HeadRightTeeth_r1 = RightJaw.addOrReplaceChild("HeadRightTeeth_r1", CubeListBuilder.create().texOffs(57, 30).addBox(-4.0F, 0.6F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(20, 24).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.597F, -1.4339F, -2.0181F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition RightJawFoliage = RightJaw.addOrReplaceChild("RightJawFoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8879F, -4.6786F, -3.5108F, 0.5672F, 0.0F, -0.6545F));

		PartDefinition Petal4_r1 = RightJawFoliage.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = RightJawFoliage.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = RightJawFoliage.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -3.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = RightJawFoliage.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition RightJawFoliage2 = RightJaw.addOrReplaceChild("RightJawFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8879F, -4.6786F, -3.5108F, 1.0036F, -0.7418F, -0.6545F));

		PartDefinition Petal4_r2 = RightJawFoliage2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = RightJawFoliage2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r2 = RightJawFoliage2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, 0.1674F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = RightJawFoliage2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition RightJawFoliage3 = RightJaw.addOrReplaceChild("RightJawFoliage3", CubeListBuilder.create(), PartPose.offsetAndRotation(7.1121F, -2.6786F, -3.5108F, 0.7479F, -0.5522F, 0.6593F));

		PartDefinition Petal4_r3 = RightJawFoliage3.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r3 = RightJawFoliage3.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r3 = RightJawFoliage3.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -2.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = RightJawFoliage3.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition LeftJaw = Jaw.addOrReplaceChild("LeftJaw", CubeListBuilder.create(), PartPose.offset(-0.3838F, -2.1721F, -4.1379F));

		PartDefinition HeadRight_r1 = LeftJaw.addOrReplaceChild("HeadRight_r1", CubeListBuilder.create().texOffs(49, 13).addBox(-5.25F, -3.75F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.5847F, 3.8175F, -2.2745F, -0.0555F, 0.1071F, 0.484F));

		PartDefinition HeadLeftTeeth_r2 = LeftJaw.addOrReplaceChild("HeadLeftTeeth_r2", CubeListBuilder.create().texOffs(59, 35).addBox(-4.0F, -0.85F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.597F, 1.4339F, -3.0181F, -0.1309F, 0.0F, -0.3491F));

		PartDefinition HeadLeft_r1 = LeftJaw.addOrReplaceChild("HeadLeft_r1", CubeListBuilder.create().texOffs(49, 13).addBox(-4.0F, 0.75F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.597F, 1.4339F, -3.0181F, -0.1309F, 0.0F, -0.3491F));

		PartDefinition RightJawFoliage4 = LeftJaw.addOrReplaceChild("RightJawFoliage4", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8796F, 4.6657F, -3.5108F, 0.7854F, 0.0F, 1.9635F));

		PartDefinition Petal4_r4 = RightJawFoliage4.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r4 = RightJawFoliage4.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r4 = RightJawFoliage4.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -4.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r4 = RightJawFoliage4.addOrReplaceChild("Petal1_r4", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8984F, -1.8326F, 1.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition RightJawFoliage5 = LeftJaw.addOrReplaceChild("RightJawFoliage5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1204F, 4.6657F, -3.5108F, 0.7502F, -0.7003F, 2.3362F));

		PartDefinition Petal4_r5 = RightJawFoliage5.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r5 = RightJawFoliage5.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.416F, -1.9008F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r5 = RightJawFoliage5.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r5 = RightJawFoliage5.addOrReplaceChild("Petal1_r5", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition RightJawFoliage6 = LeftJaw.addOrReplaceChild("RightJawFoliage6", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.1204F, 2.6657F, -2.5108F, -0.1146F, -0.6591F, -2.0642F));

		PartDefinition Petal4_r6 = RightJawFoliage6.addOrReplaceChild("Petal4_r6", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1016F, -0.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r6 = RightJawFoliage6.addOrReplaceChild("Petal3_r6", CubeListBuilder.create().texOffs(136, 0).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r6 = RightJawFoliage6.addOrReplaceChild("Petal2_r6", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -3.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r6 = RightJawFoliage6.addOrReplaceChild("Petal1_r6", CubeListBuilder.create().texOffs(136, 0).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition BodyFungus = Body.addOrReplaceChild("BodyFungus", CubeListBuilder.create(), PartPose.offset(6.7907F, -13.8392F, -6.3475F));

		PartDefinition Fungus_r1 = BodyFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = BodyFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4407F, -2.2108F, -2.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = BodyFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(108, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition BodyFungus2 = Body.addOrReplaceChild("BodyFungus2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7907F, -8.8392F, -11.3475F, 0.0F, 1.3963F, 0.0F));

		PartDefinition Fungus_r4 = BodyFungus2.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r5 = BodyFungus2.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4407F, -2.2108F, -2.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r6 = BodyFungus2.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(108, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r7 = BodyFungus2.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition BodyFungus3 = Body.addOrReplaceChild("BodyFungus3", CubeListBuilder.create(), PartPose.offset(-10.2093F, -8.8392F, -1.3475F));

		PartDefinition Fungus_r8 = BodyFungus3.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r9 = BodyFungus3.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5593F, -2.2108F, -3.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r10 = BodyFungus3.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(108, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r11 = BodyFungus3.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(108, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Tendrils = SporePod.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.2337F, -4.8057F, 4.7892F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(16, 25).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create().texOffs(0, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7663F, -4.8057F, 8.7892F, -2.3404F, -0.3931F, 1.9262F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(16, 25).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0421F, 0.0113F, 0.9161F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	private void animateBrain(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/7)/7;
		part.yScale = 1 + Mth.sin(value/7)/7;
		part.zScale = 1 + Mth.cos(value/7)/7;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTumor(TumorBase,Mth.sin(ageInTicks/7)/6);
		this.Base.yRot = Mth.cos(ageInTicks/10)/6;
		this.Base.xRot = Mth.cos(ageInTicks/10)/8;
		this.animateBrain(Brain1,-ageInTicks/2);
		this.animateBrain(Brain2,ageInTicks);
		this.animateBrain(Brain3,-ageInTicks);
		this.animateBrain(Brain4,ageInTicks/2);
		animateTentacleZ(Tendril1,Mth.sin(ageInTicks/6)/5);
		animateTentacleZ(Seg2Tendril1,Mth.sin(ageInTicks/7)/5);
		animateTentacleZ(Seg3Tendril1,Mth.sin(ageInTicks/6)/5);
		animateTentacleZ(Tendril2,Mth.cos(ageInTicks/6)/5);
		animateTentacleZ(Seg2Tendril2,Mth.cos(ageInTicks/7)/7);
		animateTentacleZ(Seg3Tendril2,Mth.cos(ageInTicks/6)/6);
		animateTentacleX(Tendril3,Mth.cos(ageInTicks/6)/5);
		animateTentacleX(Seg2Tendril3,Mth.cos(ageInTicks/7)/5);
		animateTentacleX(Seg3Tendril3,Mth.cos(ageInTicks/6)/5);
		animateTentacleY(Tendril4,Mth.sin(ageInTicks/6)/5);
		animateTentacleY(Seg2Tendril4,Mth.sin(ageInTicks/7)/5);
		animateTentacleY(Seg3Tendril4,Mth.sin(ageInTicks/6)/5);
		this.LeftJaw.xRot = Mth.cos(ageInTicks/6)/6;
		this.RightJaw.xRot = -this.LeftJaw.xRot;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		SporePod.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}