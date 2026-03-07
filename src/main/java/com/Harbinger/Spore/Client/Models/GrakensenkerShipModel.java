package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
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

public class GrakensenkerShipModel<T extends Grakensenker> extends EntityModel<T>  implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "grakensenkerboatmodel"), "main");
	private final ModelPart ship;
	private final ModelPart mast;
	private final ModelPart crownest;
	private final ModelPart whaling;
	private final ModelPart gunbase;
	private final ModelPart barrel;
	private final ModelPart harpoon;
	private final ModelPart gunner;
	private final ModelPart tumorBase;
	private final ModelPart gunnerhead;
	private final ModelPart smalltumor3;
	private final ModelPart smalltumor2;
	private final ModelPart smalltumor;
	private final ModelPart anchorPort;
	private final ModelPart anchorChain;
	private final ModelPart anchorChain2;
	private final ModelPart anchorChain3;
	private final ModelPart Anchor;
	private final ModelPart AnchorEye;
	private final ModelPart AnchorBlade;

	public GrakensenkerShipModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.ship = root.getChild("ship");
		this.mast = this.ship.getChild("mast");
		this.crownest = this.mast.getChild("crownest");
		this.whaling = this.ship.getChild("whaling");
		this.gunbase = this.whaling.getChild("gunbase");
		this.barrel = this.gunbase.getChild("barrel");
		this.harpoon = this.barrel.getChild("harpoon");
		this.gunner = this.gunbase.getChild("gunner");
		this.tumorBase = this.gunner.getChild("tumorBase");
		this.gunnerhead = this.gunner.getChild("gunnerhead");
		this.smalltumor3 = this.gunnerhead.getChild("smalltumor3");
		this.smalltumor2 = this.gunnerhead.getChild("smalltumor2");
		this.smalltumor = this.gunnerhead.getChild("smalltumor");
		this.anchorPort = this.ship.getChild("anchorPort");
		this.anchorChain = this.anchorPort.getChild("anchorChain");
		this.anchorChain2 = this.anchorChain.getChild("anchorChain2");
		this.anchorChain3 = this.anchorChain2.getChild("anchorChain3");
		this.Anchor = this.anchorChain3.getChild("Anchor");
		this.AnchorEye = this.Anchor.getChild("AnchorEye");
		this.AnchorBlade = this.Anchor.getChild("AnchorBlade");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ship = partdefinition.addOrReplaceChild("ship", CubeListBuilder.create().texOffs(880, 100).addBox(-35.2013F, -1.8783F, 1.947F, 3.0F, 13.0F, 23.0F, new CubeDeformation(0.0F))
		.texOffs(978, 10).addBox(-35.2013F, 6.1216F, -5.053F, 3.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(984, 0).addBox(-35.2013F, 1.1217F, -2.053F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(1008, 0).addBox(-35.2013F, -1.8783F, 24.947F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -5.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition plank7Weed_r1 = ship.addOrReplaceChild("plank7Weed_r1", CubeListBuilder.create().texOffs(934, 222).addBox(0.0F, -1.5F, -11.5F, 0.0F, 13.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-35.2013F, 10.6216F, 13.447F, -0.1304F, -0.0114F, -0.0865F));

		PartDefinition plank7RailingBeam_r1 = ship.addOrReplaceChild("plank7RailingBeam_r1", CubeListBuilder.create().texOffs(920, 140).addBox(-2.5F, -1.5F, -2.0F, 23.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-44.8743F, 6.4662F, 4.0F, 2.6665F, -1.2786F, 1.5601F));

		PartDefinition plan7RailingLeg_r1 = ship.addOrReplaceChild("plan7RailingLeg_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-1.5F, -7.5F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.5792F, 6.5382F, 21.236F, 0.143F, -0.2201F, -2.2411F));

		PartDefinition plan7RailingLeg_r2 = ship.addOrReplaceChild("plan7RailingLeg_r2", CubeListBuilder.create().texOffs(938, 0).addBox(-1.5F, -3.5F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-41.592F, 6.5233F, 4.7459F, 0.0F, -0.2618F, -1.6581F));

		PartDefinition plank6_r1 = ship.addOrReplaceChild("plank6_r1", CubeListBuilder.create().texOffs(942, 79).addBox(0.5F, -15.5F, -7.5F, 3.0F, 23.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.7013F, -11.3783F, 32.447F, 0.2098F, -0.0359F, 0.8562F));

		PartDefinition plank6_r2 = ship.addOrReplaceChild("plank6_r2", CubeListBuilder.create().texOffs(1002, 63).addBox(-0.5F, -11.5F, -4.5F, 4.0F, 23.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-25.6653F, -7.3744F, -11.1613F, -0.1855F, -0.3435F, 0.5867F));

		PartDefinition plan5RailingLeg_r1 = ship.addOrReplaceChild("plan5RailingLeg_r1", CubeListBuilder.create().texOffs(1011, 16).addBox(-1.5F, -11.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(938, 0).addBox(-1.5F, -8.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.5828F, -12.4821F, -7.2541F, 0.0F, 0.0F, -0.6109F));

		PartDefinition plan5RailingLeg_r2 = ship.addOrReplaceChild("plan5RailingLeg_r2", CubeListBuilder.create().texOffs(938, 0).addBox(-4.5F, -2.5F, -2.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-36.7478F, -6.9502F, -10.2541F, 0.0F, 0.0F, -1.1345F));

		PartDefinition plank5_r1 = ship.addOrReplaceChild("plank5_r1", CubeListBuilder.create().texOffs(884, 0).addBox(5.5F, -6.5F, -7.5F, 5.0F, 23.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.6454F, -14.3822F, -5.5F, -0.1772F, -0.1719F, 0.5542F));

		PartDefinition fragmenty_r1 = ship.addOrReplaceChild("fragmenty_r1", CubeListBuilder.create().texOffs(892, 96).addBox(0.0F, 0.0F, -20.0F, 3.0F, 3.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.9775F, -21.0928F, 7.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition plank4_r1 = ship.addOrReplaceChild("plank4_r1", CubeListBuilder.create().texOffs(938, 77).addBox(-3.5F, -19.0F, -20.0F, 5.0F, 19.0F, 40.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.6381F, -17.8592F, 7.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition plank4_r2 = ship.addOrReplaceChild("plank4_r2", CubeListBuilder.create().texOffs(1018, 63).addBox(1.4688F, -18.5F, 3.5431F, 1.0F, 37.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6209F, -17.9947F, 42.6198F, -0.0392F, -0.2593F, -0.8065F));

		PartDefinition barni_r1 = ship.addOrReplaceChild("barni_r1", CubeListBuilder.create().texOffs(917, 50).addBox(-0.5F, 0.5F, 7.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(917, 50).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.9412F, -18.4155F, 31.1415F, -0.3433F, 0.0459F, -0.8183F));

		PartDefinition barni_r2 = ship.addOrReplaceChild("barni_r2", CubeListBuilder.create().texOffs(917, 49).addBox(1.2891F, -4.5F, -5.8785F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(916, 48).addBox(1.2891F, -1.5F, -6.8785F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(904, 32).addBox(-1.7109F, -18.5F, -15.8785F, 3.0F, 37.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6209F, -17.9947F, 42.6198F, -0.0379F, 0.0459F, -0.8183F));

		PartDefinition barni_r3 = ship.addOrReplaceChild("barni_r3", CubeListBuilder.create().texOffs(916, 48).mirror().addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(25.2535F, -19.0556F, 40.1995F, 1.0529F, 0.0459F, -0.8183F));

		PartDefinition barni_r4 = ship.addOrReplaceChild("barni_r4", CubeListBuilder.create().texOffs(916, 48).mirror().addBox(-1.0F, -7.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(916, 48).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0886F, -17.3039F, 33.5803F, 0.2239F, 0.0459F, -0.8183F));

		PartDefinition plank3RailingBeam_r1 = ship.addOrReplaceChild("plank3RailingBeam_r1", CubeListBuilder.create().texOffs(920, 140).addBox(35.5F, -7.5F, -6.0F, 23.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(35.3655F, -13.4254F, -9.0F, 0.0F, -1.5708F, 0.5236F));

		PartDefinition plank3RailingLeg_r1 = ship.addOrReplaceChild("plank3RailingLeg_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-1.0F, -2.5F, 10.25F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(37.8006F, -12.0271F, 30.2929F, 0.2666F, 0.0317F, 0.4052F));

		PartDefinition plank3RailingLeg_r2 = ship.addOrReplaceChild("plank3RailingLeg_r2", CubeListBuilder.create().texOffs(938, 0).addBox(-4.5F, -23.5F, 33.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(38.2522F, -5.9502F, -8.2541F, -0.345F, -0.0376F, 0.6577F));

		PartDefinition fragment_r1 = ship.addOrReplaceChild("fragment_r1", CubeListBuilder.create().texOffs(951, 52).addBox(-1.25F, 3.75F, -12.0F, 2.0F, 5.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(930, 0).addBox(-1.25F, -16.25F, -12.0F, 3.0F, 20.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(39.0067F, 5.8424F, 16.1234F, -0.2185F, 0.2746F, -0.5104F));

		PartDefinition plank2_r1 = ship.addOrReplaceChild("plank2_r1", CubeListBuilder.create().texOffs(930, 0).addBox(-1.5F, -9.0F, -10.0F, 3.0F, 18.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.4105F, -24.3481F, 18.241F, 0.0738F, 0.3878F, -0.8855F));

		PartDefinition fragment_r2 = ship.addOrReplaceChild("fragment_r2", CubeListBuilder.create().texOffs(876, 67).addBox(0.5F, 18.0F, -20.0F, 3.0F, 3.0F, 22.0F, new CubeDeformation(0.0F))
		.texOffs(976, 0).addBox(-0.5F, -23.0F, -20.0F, 4.0F, 41.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3619F, -11.8592F, 7.0F, -0.1745F, 0.0873F, -0.829F));

		PartDefinition plank1RailingBeam_r1 = ship.addOrReplaceChild("plank1RailingBeam_r1", CubeListBuilder.create().texOffs(920, 140).addBox(-10.5F, 2.5F, -2.0F, 21.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.3655F, -17.4254F, -9.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition plank1RailingBeam_r2 = ship.addOrReplaceChild("plank1RailingBeam_r2", CubeListBuilder.create().texOffs(914, 139).addBox(-3.0F, -2.25F, -2.5F, 28.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.8042F, -39.5128F, -8.5F, 0.0F, 0.0F, 0.829F));

		PartDefinition plank1RailingLeg_r1 = ship.addOrReplaceChild("plank1RailingLeg_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-1.5F, -3.5F, -3.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(33.2522F, -9.9502F, -8.2541F, -0.345F, -0.0376F, 0.745F));

		PartDefinition plank1RailingLeg_r2 = ship.addOrReplaceChild("plank1RailingLeg_r2", CubeListBuilder.create().texOffs(938, 0).addBox(15.5F, -9.5F, -3.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3927F, -32.8289F, -7.5F, -0.1745F, 0.0F, 0.9599F));

		PartDefinition plank1RailingLeg_r3 = ship.addOrReplaceChild("plank1RailingLeg_r3", CubeListBuilder.create().texOffs(938, 0).addBox(25.5F, 47.0F, -24.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3042F, -93.5128F, 15.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition mast = ship.addOrReplaceChild("mast", CubeListBuilder.create().texOffs(980, 136).addBox(-6.0F, -54.0F, -6.0F, 12.0F, 62.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(998, 210).addBox(-6.0F, -84.0F, -6.0F, 5.0F, 30.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(1012, 13).addBox(-6.0F, -88.0F, -1.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(980, 236).addBox(-6.0F, -90.0F, -6.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(1012, 107).addBox(-6.0F, -96.0F, -6.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(974, 210).addBox(-1.0F, -74.0F, -6.0F, 6.0F, 20.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(956, 0).addBox(-1.0F, -59.0F, 0.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(956, 13).addBox(-1.0F, -78.0F, -6.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(916, 49).mirror().addBox(2.0886F, -35.3039F, -6.4197F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, -25.0F, 27.0F, 0.0631F, 0.3435F, 0.1855F));

		PartDefinition barni_r5 = mast.addOrReplaceChild("barni_r5", CubeListBuilder.create().texOffs(916, 49).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9685F, -27.0247F, -5.9197F, 0.0F, 0.0F, 2.7053F));

		PartDefinition barni_r6 = mast.addOrReplaceChild("barni_r6", CubeListBuilder.create().texOffs(916, 49).addBox(-7.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0886F, -34.3039F, -5.9197F, 0.0F, 0.0F, -0.2618F));

		PartDefinition barni_r7 = mast.addOrReplaceChild("barni_r7", CubeListBuilder.create().texOffs(916, 49).mirror().addBox(-7.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0886F, -34.3039F, -5.9197F, 0.0F, 0.0F, 0.5672F));

		PartDefinition barni_r8 = mast.addOrReplaceChild("barni_r8", CubeListBuilder.create().texOffs(917, 49).mirror().addBox(-1.5F, 5.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(917, 49).mirror().addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.5886F, -35.8039F, -5.9197F, 0.0F, 0.0F, -0.1309F));

		PartDefinition crownest = mast.addOrReplaceChild("crownest", CubeListBuilder.create().texOffs(868, 149).addBox(-14.0F, -2.0F, -14.0F, 28.0F, 2.0F, 28.0F, new CubeDeformation(0.0F))
		.texOffs(938, 0).addBox(10.0F, -16.0F, -13.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1958F, -52.5128F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition rimleftleg_r1 = crownest.addOrReplaceChild("rimleftleg_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.7769F, -12.1874F, 4.5206F, -0.0962F, 0.4252F, 0.4F));

		PartDefinition rimleft_r1 = crownest.addOrReplaceChild("rimleft_r1", CubeListBuilder.create().texOffs(852, 16).addBox(-2.5F, -1.0F, -1.75F, 5.0F, 4.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -19.0F, -9.0F, -0.2728F, 0.3435F, -0.0631F));

		PartDefinition rimbackleg2_r1 = crownest.addOrReplaceChild("rimbackleg2_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3957F, -16.7916F, 14.5167F, 0.0025F, -0.0297F, -0.1257F));

		PartDefinition rimbackleg1_r1 = crownest.addOrReplaceChild("rimbackleg1_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-13.0F, 0.0F, 0.0F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(914, 139).addBox(-14.0F, -4.0F, -1.0F, 28.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 12.6323F, -0.3478F, -0.0298F, -0.082F));

		PartDefinition rimFrontleg2_r1 = crownest.addOrReplaceChild("rimFrontleg2_r1", CubeListBuilder.create().texOffs(938, 0).addBox(-4.5F, 3.0F, -1.5F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -16.0F, -11.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition rimFront_r1 = crownest.addOrReplaceChild("rimFront_r1", CubeListBuilder.create().texOffs(952, 160).addBox(-5.5F, -0.25F, -1.0F, 7.0F, 13.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(12.1451F, -20.0564F, -13.0F, -0.2164F, 0.0283F, -0.3521F));

		PartDefinition rimFront_r2 = crownest.addOrReplaceChild("rimFront_r2", CubeListBuilder.create().texOffs(914, 139).addBox(-26.0F, -2.0F, -2.5F, 28.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -18.0F, -11.5F, 0.0F, 0.0F, -0.1745F));

		PartDefinition weed_r1 = crownest.addOrReplaceChild("weed_r1", CubeListBuilder.create().texOffs(918, 210).addBox(-14.0F, -2.5F, -0.01F, 28.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, -14.0F, -0.4363F, 0.0F, -0.2618F));

		PartDefinition base_r1 = crownest.addOrReplaceChild("base_r1", CubeListBuilder.create().texOffs(934, 209).addBox(0.0F, 1.0F, -14.0F, 0.0F, 16.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.2F, -2.0F, 0.0F, -0.1309F, 0.0F, -0.3927F));

		PartDefinition whaling = ship.addOrReplaceChild("whaling", CubeListBuilder.create().texOffs(988, 107).addBox(-5.0F, 2.0F, -7.0F, 10.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -30.0F, 0.0F, -0.48F, -0.0873F, 0.0F));

		PartDefinition right_r1 = whaling.addOrReplaceChild("right_r1", CubeListBuilder.create().texOffs(988, 94).addBox(-1.0F, 0.0F, -3.5F, 2.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 0.5F, -0.0115F, 0.1304F, -0.088F));

		PartDefinition platflat_r1 = whaling.addOrReplaceChild("platflat_r1", CubeListBuilder.create().texOffs(896, 179).addBox(-7.0F, -2.0F, -9.0F, 14.0F, 3.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition gunbase = whaling.addOrReplaceChild("gunbase", CubeListBuilder.create().texOffs(858, 20).addBox(-5.0F, -10.0F, -3.0F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(858, 20).addBox(3.0F, -12.0F, -3.0F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(946, 345).addBox(-6.0F, -1.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition barni_r9 = gunbase.addOrReplaceChild("barni_r9", CubeListBuilder.create().texOffs(916, 48).mirror().addBox(-0.5F, -1.0F, -2.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.1614F, -6.3039F, -0.4197F, 0.2618F, 0.0F, 0.0F));

		PartDefinition barrel = gunbase.addOrReplaceChild("barrel", CubeListBuilder.create().texOffs(988, 320).addBox(-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(978, 322).addBox(-3.5F, -3.0F, 5.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(996, 344).addBox(-2.0F, -3.0F, -19.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(960, 267).addBox(0.0F, -3.0F, -19.0F, 2.0F, 7.0F, 12.0F, new CubeDeformation(0.1F))
		.texOffs(952, 332).addBox(-1.0F, 1.5F, -17.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(964, 323).addBox(-2.0F, -3.0F, -24.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(962, 323).addBox(1.0F, -3.0F, -24.0F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(962, 323).addBox(-1.0F, -3.0F, -24.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(962, 323).addBox(-1.0F, 0.0F, -24.0F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(980, 316).addBox(0.0F, -7.0F, -16.0F, 0.0F, 4.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(952, 320).addBox(-0.5F, -8.0F, -16.0F, 1.0F, 1.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition harpoon = barrel.addOrReplaceChild("harpoon", CubeListBuilder.create().texOffs(975, 345).addBox(-0.5F, -1.5F, -26.0F, 1.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
		.texOffs(1009, 378).addBox(-1.0F, -2.0F, -33.0F, 2.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(1010, 364).addBox(0.0F, -5.0F, -33.0F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 364).addBox(-4.0F, -1.0F, -33.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 364).mirror().addBox(0.0F, -1.0F, -33.0F, 4.0F, 0.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plane_r1 = harpoon.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(1012, 377).addBox(-2.0F, 0.0F, -7.5F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -33.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Plane_r2 = harpoon.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(1000, 377).addBox(-2.0F, 0.0F, -7.5F, 4.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -33.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition backPlane_r1 = harpoon.addOrReplaceChild("backPlane_r1", CubeListBuilder.create().texOffs(1010, 364).addBox(0.0F, -2.0F, -4.5F, 0.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -28.5F, 0.0F, 0.0F, -3.1416F));

		PartDefinition gunner = gunbase.addOrReplaceChild("gunner", CubeListBuilder.create().texOffs(188, 210).addBox(-1.6217F, -11.1532F, 14.5106F, 7.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r1 = gunner.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(996, 280).addBox(-3.0F, -2.0F, -11.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4027F, -12.8805F, 15.972F, 0.2835F, 0.2275F, -0.0669F));

		PartDefinition Arm_r2 = gunner.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(996, 280).addBox(0.0F, -2.0F, -11.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8783F, -15.1532F, 16.0106F, 0.3497F, 0.331F, 0.1615F));

		PartDefinition UpperTorso_r1 = gunner.addOrReplaceChild("UpperTorso_r1", CubeListBuilder.create().texOffs(1000, 296).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8783F, -10.1532F, 17.0106F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tumorBase = gunner.addOrReplaceChild("tumorBase", CubeListBuilder.create(), PartPose.offset(1.2331F, -16.1174F, 15.6601F));

		PartDefinition Biomass_r1 = tumorBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(976, 257).addBox(-5.2164F, -5.3265F, -9.8044F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2296F, 12.7295F, 1.2208F, 0.0133F, 0.2392F, -0.3783F));

		PartDefinition Biomass_r2 = tumorBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(976, 258).addBox(-5.7062F, -9.7377F, -6.5161F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2296F, 12.7295F, 1.2208F, -0.0565F, 1.361F, -1.1111F));

		PartDefinition Biomass_r3 = tumorBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(988, 257).addBox(-4.3078F, -6.4093F, -0.1465F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2296F, 12.7295F, 1.2208F, -0.4032F, 0.4094F, -0.6728F));

		PartDefinition Biomass_r4 = tumorBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(984, 257).addBox(0.0739F, -5.51F, -6.8678F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2296F, 12.7295F, 1.2208F, -0.3039F, -0.5151F, 0.5625F));

		PartDefinition gunnerhead = gunner.addOrReplaceChild("gunnerhead", CubeListBuilder.create(), PartPose.offset(1.2331F, -16.1174F, 15.6601F));

		PartDefinition Head_r1 = gunnerhead.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(520, 431).addBox(-6.0F, -6.5F, -8.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6453F, -1.5359F, 1.3505F, -0.1474F, 0.1274F, -0.4185F));

		PartDefinition smalltumor3 = gunnerhead.addOrReplaceChild("smalltumor3", CubeListBuilder.create(), PartPose.offset(-3.3673F, -5.9864F, -1.3727F));

		PartDefinition tumor_r1 = smalltumor3.addOrReplaceChild("tumor_r1", CubeListBuilder.create().texOffs(991, 260).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.0F, 0.0F, -0.5516F, 0.5882F, -0.7691F));

		PartDefinition smalltumor2 = gunnerhead.addOrReplaceChild("smalltumor2", CubeListBuilder.create(), PartPose.offset(0.6327F, -5.9864F, -5.3727F));

		PartDefinition tumor_r2 = smalltumor2.addOrReplaceChild("tumor_r2", CubeListBuilder.create().texOffs(991, 260).addBox(-1.25F, 3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 5.0F, -0.5516F, 0.5882F, -0.7691F));

		PartDefinition smalltumor = gunnerhead.addOrReplaceChild("smalltumor", CubeListBuilder.create(), PartPose.offset(1.6327F, -6.9864F, -0.3727F));

		PartDefinition tumor_r3 = smalltumor.addOrReplaceChild("tumor_r3", CubeListBuilder.create().texOffs(991, 260).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3842F, 0.0868F, -0.4223F, -0.5762F, 1.0135F, -1.3305F));

		PartDefinition anchorPort = ship.addOrReplaceChild("anchorPort", CubeListBuilder.create().texOffs(946, 345).addBox(-6.0F, 2.3333F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(858, 20).addBox(-5.0F, -8.6667F, -3.0F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(879, 7).addBox(-3.0F, -7.6667F, -2.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(858, 20).addBox(3.0F, -8.6667F, -3.0F, 2.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(30.8867F, -9.9061F, 0.0F, 0.0F, -1.5708F, 0.7854F));

		PartDefinition anchorChain = anchorPort.addOrReplaceChild("anchorChain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -6.0F, -2.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition chainplane_r1 = anchorChain.addOrReplaceChild("chainplane_r1", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition chainplane_r2 = anchorChain.addOrReplaceChild("chainplane_r2", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition anchorChain2 = anchorChain.addOrReplaceChild("anchorChain2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, 0.6143F, 0.5759F, 0.1747F));

		PartDefinition chainplane_r3 = anchorChain2.addOrReplaceChild("chainplane_r3", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition chainplane_r4 = anchorChain2.addOrReplaceChild("chainplane_r4", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition anchorChain3 = anchorChain2.addOrReplaceChild("anchorChain3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -4.0F, -0.1932F, -0.0766F, 0.2135F));

		PartDefinition chainplane_r5 = anchorChain3.addOrReplaceChild("chainplane_r5", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition chainplane_r6 = anchorChain3.addOrReplaceChild("chainplane_r6", CubeListBuilder.create().texOffs(1018, 415).addBox(-1.5F, 0.0F, -4.0F, 3.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Anchor = anchorChain3.addOrReplaceChild("Anchor", CubeListBuilder.create().texOffs(1016, 391).addBox(-1.5F, 6.0F, -1.5F, 3.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(990, 389).addBox(-4.5F, 8.0F, -1.0F, 9.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0357F, 0.098F, -3.355F, -1.4834F, 0.0435F, 0.0038F));

		PartDefinition AnchorEye = Anchor.addOrReplaceChild("AnchorEye", CubeListBuilder.create().texOffs(1012, 387).mirror().addBox(-3.0F, 1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1020, 387).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1012, 387).addBox(1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1012, 387).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition AnchorBlade = Anchor.addOrReplaceChild("AnchorBlade", CubeListBuilder.create().texOffs(996, 398).addBox(-2.5F, 17.0F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition RightWingTip_r1 = AnchorBlade.addOrReplaceChild("RightWingTip_r1", CubeListBuilder.create().texOffs(998, 393).addBox(0.0F, -3.0F, -1.5F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.3605F, 18.8706F, 0.5F, 0.0F, 0.0F, -1.1345F));

		PartDefinition RightWing_r1 = AnchorBlade.addOrReplaceChild("RightWing_r1", CubeListBuilder.create().texOffs(1008, 408).addBox(-1.0F, -3.0F, -1.5F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 20.5F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LeftWingTip_r1 = AnchorBlade.addOrReplaceChild("LeftWingTip_r1", CubeListBuilder.create().texOffs(998, 393).addBox(-7.0F, -3.0F, -0.5F, 7.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3605F, 18.8706F, -0.5F, 0.0F, 0.0F, 1.1345F));

		PartDefinition LeftWing_r1 = AnchorBlade.addOrReplaceChild("LeftWing_r1", CubeListBuilder.create().texOffs(1008, 408).addBox(-6.0F, -3.0F, -0.5F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 20.5F, -1.0F, 0.0F, 0.0F, 0.4363F));

		return LayerDefinition.create(meshdefinition, 1028, 1028);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(tumorBase, Mth.sin(ageInTicks/8)/10);
		animateTumor(smalltumor, Mth.cos(ageInTicks/8)/7);
		animateTumor(smalltumor2, Mth.sin(ageInTicks/6)/8);
		animateTumor(smalltumor3, Mth.sin(ageInTicks/7)/7);
		harpoon.visible = entity.shotHook();
		gunner.visible = !entity.isInvisible();
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		ship.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}