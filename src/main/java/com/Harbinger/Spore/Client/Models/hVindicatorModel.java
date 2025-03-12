package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.UmarmerExtraAnimations;
import com.Harbinger.Spore.Sentities.Hyper.Hvindicator;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class hVindicatorModel<T extends Hvindicator> extends HierarchicalModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "hvindicatormodel"), "main");
	private final ModelPart hindicator;
	private final ModelPart LeftLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart RightLeg;
	private final ModelPart RightForLeg;
	private final ModelPart RightArm;
	private final ModelPart RightSkull;
	private final ModelPart LeftArm;
	private final ModelPart LeftSkull;
	private final ModelPart LeftArmSegment;
	private final ModelPart Head;
	private final ModelPart Jaw;

	public hVindicatorModel(ModelPart root) {
		this.hindicator = root.getChild("hindicator");
		this.LeftLeg = hindicator.getChild("Legs").getChild("LeftLeg");
		this.LeftForLeg = LeftLeg.getChild("LeftLegSeg2");
		this.RightLeg = hindicator.getChild("Legs").getChild("RightLeg");
		this.RightForLeg = RightLeg.getChild("RightLegSeg2");
		this.RightArm = hindicator.getChild("LowerTorso").getChild("MiddleTorso").getChild("TopTorso").getChild("Arms").getChild("RightArm");
		this.RightSkull = RightArm.getChild("RightShoulderPad");
		this.LeftArm = hindicator.getChild("LowerTorso").getChild("MiddleTorso").getChild("TopTorso").getChild("Arms").getChild("LeftArm");
		this.LeftSkull = LeftArm.getChild("LeftShoulderPad");
		this.LeftArmSegment = LeftArm.getChild("LeftArmSeg2");
		this.Head = hindicator.getChild("LowerTorso").getChild("MiddleTorso").getChild("TopTorso").getChild("Neck").getChild("Head");
		this.Jaw = Head.getChild("Jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition hindicator = partdefinition.addOrReplaceChild("hindicator", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -1.0F));

		PartDefinition Legs = hindicator.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(106, 93).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -22.0F, 2.0F, -0.2171F, -0.017F, -0.1298F));

		PartDefinition LeftLegClothes_r1 = LeftLeg.addOrReplaceChild("LeftLegClothes_r1", CubeListBuilder.create().texOffs(106, 38).addBox(-2.5F, -6.0F, -2.5F, 5.0F, 13.0F, 5.0F, new CubeDeformation(0.75F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create().texOffs(0, 80).addBox(-3.5F, 0.0F, -2.5F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-1.0F, 5.5F, -3.0F, 4.0F, 7.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(0.0F, 8.25F, 0.0F, 3.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 11.0F, -0.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Plate_r1 = LeftLegSeg2.addOrReplaceChild("Plate_r1", CubeListBuilder.create().texOffs(0, 45).addBox(-1.0F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 4.5F, -1.75F, 0.0F, 0.0F, -0.1745F));

		PartDefinition LeftLegFungus = LeftLegSeg2.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offset(10.0F, 23.0527F, -0.9006F));

		PartDefinition Fungus_r1 = LeftLegFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -20.05F, 0.55F, 0.0392F, 0.5172F, 0.2531F));

		PartDefinition Fungus_r2 = LeftLegFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -17.05F, 2.45F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Fungus_r3 = LeftLegFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -17.05F, 2.45F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r4 = LeftLegFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 132).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -13.05F, 1.55F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r5 = LeftLegFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -13.05F, 1.55F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(106, 110).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -22.0F, 2.0F, -0.0859F, 0.0151F, 0.1739F));

		PartDefinition Plate_r2 = RightLeg.addOrReplaceChild("Plate_r2", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, -1.25F, -1.0F, 5.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5757F, 7.2653F, 2.0F, 0.0057F, -0.1308F, -0.1313F));

		PartDefinition Plate_r3 = RightLeg.addOrReplaceChild("Plate_r3", CubeListBuilder.create().texOffs(0, 43).addBox(-1.5F, -2.0F, -0.5F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5076F, 8.1743F, -2.5F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Plate_r4 = RightLeg.addOrReplaceChild("Plate_r4", CubeListBuilder.create().texOffs(0, 43).addBox(-2.5F, -6.0F, -1.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 8.0F, -2.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(92, 20).addBox(-2.5F, 0.0F, -2.5F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 98).addBox(-2.5F, 0.0F, -2.5F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.75F, 11.0F, -0.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RightLegFungus = RightLegSeg2.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(12.5F, 23.0527F, -0.9006F));

		PartDefinition Fungus_r6 = RightLegFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -17.05F, 2.45F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Fungus_r7 = RightLegFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -13.05F, 1.55F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LowerTorso = hindicator.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(52, 25).addBox(-7.0F, -5.5F, -3.5F, 13.0F, 7.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(92, 42).addBox(-7.0F, -5.5F, -3.5F, 13.0F, 9.0F, 7.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.0F, -22.5F, 1.75F, 0.0F, 0.0F, -0.1309F));

		PartDefinition LowerChestFungus = LowerTorso.addOrReplaceChild("LowerChestFungus", CubeListBuilder.create(), PartPose.offset(-2.0593F, -3.3392F, -6.4025F));

		PartDefinition Fungus_r8 = LowerChestFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 125).addBox(-1.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5593F, 2.2892F, 12.1025F, -0.3325F, 0.5154F, -0.0523F));

		PartDefinition Fungus_r9 = LowerChestFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4407F, 2.7892F, 13.2025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r10 = LowerChestFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 125).addBox(1.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2515F, 6.2607F, 13.0283F, -0.038F, 0.7157F, 0.187F));

		PartDefinition Fungus_r11 = LowerChestFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3702F, 4.2607F, 10.2766F, 0.038F, 0.7157F, -0.187F));

		PartDefinition Fungus_r12 = LowerChestFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 125).addBox(-1.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5593F, 0.2892F, 0.2025F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r13 = LowerChestFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 125).addBox(-1.5F, 1.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5593F, 2.7892F, 4.2025F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r14 = LowerChestFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 118).addBox(-1.5F, 2.0F, 0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2515F, 4.2607F, -0.7234F, 0.038F, -0.7157F, 0.187F));

		PartDefinition Fungus_r15 = LowerChestFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5593F, 3.7892F, 0.2025F, 0.1783F, 0.2977F, 0.0909F));

		PartDefinition Fungus_r16 = LowerChestFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 2.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.7108F, 1.1025F, -0.3325F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r17 = LowerChestFungus.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(-7, 125).addBox(-6.5F, 1.0F, 6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4407F, 0.7892F, -0.8975F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r18 = LowerChestFungus.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 2.2607F, 2.0283F, -0.038F, -0.7157F, -0.187F));

		PartDefinition Fungus_r19 = LowerChestFungus.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, 1.7892F, 3.1025F, -0.1783F, 0.2977F, -0.0909F));

		PartDefinition MiddleTorso = LowerTorso.addOrReplaceChild("MiddleTorso", CubeListBuilder.create().texOffs(28, 43).addBox(-8.0F, -6.0F, -5.0F, 15.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -5.0F, 1.0F, 0.0436F, 0.0F, 0.1309F));

		PartDefinition MiddleChestFungus = MiddleTorso.addOrReplaceChild("MiddleChestFungus", CubeListBuilder.create(), PartPose.offset(-2.3093F, -4.3392F, 4.9025F));

		PartDefinition Fungus_r20 = MiddleChestFungus.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(-7, 118).addBox(-1.5F, 2.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5593F, 0.2892F, -7.2025F, -0.3325F, 0.5154F, -0.0523F));

		PartDefinition Fungus_r21 = MiddleChestFungus.addOrReplaceChild("Fungus_r21", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3611F, 4.4542F, -4.6569F, 0.0453F, -0.8226F, 0.0868F));

		PartDefinition Fungus_r22 = MiddleChestFungus.addOrReplaceChild("Fungus_r22", CubeListBuilder.create().texOffs(-7, 118).addBox(2.5F, -3.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2515F, 4.2607F, -6.2766F, -0.038F, 0.7157F, 0.187F));

		PartDefinition Fungus_r23 = MiddleChestFungus.addOrReplaceChild("Fungus_r23", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5593F, 3.7892F, -7.2025F, -0.1783F, -0.2977F, 0.0909F));

		PartDefinition Fungus_r24 = MiddleChestFungus.addOrReplaceChild("Fungus_r24", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 2.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.7108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r25 = MiddleChestFungus.addOrReplaceChild("Fungus_r25", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4407F, 0.7892F, -6.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r26 = MiddleChestFungus.addOrReplaceChild("Fungus_r26", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 2.2607F, -2.0283F, -0.2217F, 0.6872F, -0.5863F));

		PartDefinition Fungus_r27 = MiddleChestFungus.addOrReplaceChild("Fungus_r27", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, 1.7892F, -10.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition TopTorso = MiddleTorso.addOrReplaceChild("TopTorso", CubeListBuilder.create().texOffs(0, 24).addBox(-8.0F, -9.0F, -5.0F, 16.0F, 9.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -9.0F, -6.0F, 16.0F, 13.0F, 11.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-0.5F, -4.0F, -1.0F, 0.2174F, 0.0189F, -0.0852F));

		PartDefinition Arms = TopTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(82, 93).addBox(-6.0F, -2.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -8.0F, 0.0F, -0.2241F, 0.0097F, 0.2591F));

		PartDefinition RightShoulderPad = RightArm.addOrReplaceChild("RightShoulderPad", CubeListBuilder.create().texOffs(82, 78).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(54, 20).addBox(-4.0F, 3.0F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, 0.0F, -0.1745F, 0.0F, -0.5672F));

		PartDefinition RightArmFungalArmor = RightArm.addOrReplaceChild("RightArmFungalArmor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition plane_r1 = RightArmFungalArmor.addOrReplaceChild("plane_r1", CubeListBuilder.create().texOffs(78, 179).addBox(-1.25F, -7.5F, 1.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.5F, -2.5F, 0.0742F, 0.0563F, -0.7299F));

		PartDefinition plane_r2 = RightArmFungalArmor.addOrReplaceChild("plane_r2", CubeListBuilder.create().texOffs(78, 179).addBox(-2.25F, -7.5F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -4.5F, 2.0F, -0.0479F, 0.2129F, -0.616F));

		PartDefinition plane_r3 = RightArmFungalArmor.addOrReplaceChild("plane_r3", CubeListBuilder.create().texOffs(78, 179).addBox(-3.0F, -7.5F, 0.0F, 6.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -4.5F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition plate_r5 = RightArmFungalArmor.addOrReplaceChild("plate_r5", CubeListBuilder.create().texOffs(0, 43).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1144F, 1.52F, -2.9224F, 0.1309F, 0.0F, -0.2618F));

		PartDefinition plate_r6 = RightArmFungalArmor.addOrReplaceChild("plate_r6", CubeListBuilder.create().texOffs(0, 43).addBox(-0.5F, 1.5F, -1.9776F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(-1.5F, -3.5F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1144F, 1.52F, -1.9224F, -0.2182F, -0.5236F, 0.1745F));

		PartDefinition plate_r7 = RightArmFungalArmor.addOrReplaceChild("plate_r7", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, 0.0F, -0.75F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(0.0F, -3.0F, -3.5F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8891F, -1.6351F, 1.5776F, 0.0F, 0.2182F, -0.829F));

		PartDefinition plate_r8 = RightArmFungalArmor.addOrReplaceChild("plate_r8", CubeListBuilder.create().texOffs(0, 43).addBox(2.0F, -6.5F, -2.5F, 2.0F, 9.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.5898F, 3.9535F, 1.5776F, 0.0F, 0.0F, 0.1745F));

		PartDefinition plate_r9 = RightArmFungalArmor.addOrReplaceChild("plate_r9", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, 0.0F, -3.25F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5898F, 3.4535F, 4.3276F, -0.2494F, -0.0098F, -0.0779F));

		PartDefinition plate_r10 = RightArmFungalArmor.addOrReplaceChild("plate_r10", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.25F, 0.5F, 3.25F, 0.0436F, -0.3054F, 0.0F));

		PartDefinition plate_r11 = RightArmFungalArmor.addOrReplaceChild("plate_r11", CubeListBuilder.create().texOffs(0, 43).addBox(-1.75F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 6.1491F, 1.8347F, -0.0961F, 0.2527F, -0.0692F));

		PartDefinition plate_r12 = RightArmFungalArmor.addOrReplaceChild("plate_r12", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 4.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(72, 111).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 9.0F, 0.0F, -0.2618F, 0.0F, -0.1745F));

		PartDefinition ArmRightFungus = RightArmSeg2.addOrReplaceChild("ArmRightFungus", CubeListBuilder.create(), PartPose.offset(0.7837F, 5.5001F, 2.6325F));

		PartDefinition Fungus_r28 = ArmRightFungus.addOrReplaceChild("Fungus_r28", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 4.9499F, -2.9325F, -0.1783F, -0.2977F, 0.0909F));

		PartDefinition Fungus_r29 = ArmRightFungus.addOrReplaceChild("Fungus_r29", CubeListBuilder.create().texOffs(-7, 132).addBox(-2.75F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 4.9499F, -2.9325F, -0.0333F, 0.6219F, -0.3593F));

		PartDefinition Fungus_r30 = ArmRightFungus.addOrReplaceChild("Fungus_r30", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 0.9499F, -3.8325F, -0.0602F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r31 = ArmRightFungus.addOrReplaceChild("Fungus_r31", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, -2.0501F, -1.9325F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r32 = ArmRightFungus.addOrReplaceChild("Fungus_r32", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, -2.0501F, -1.9325F, 0.7227F, -0.2399F, -0.1871F));

		PartDefinition Fungus_r33 = ArmRightFungus.addOrReplaceChild("Fungus_r33", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 0.9499F, -3.8325F, -0.3979F, 0.4891F, -0.195F));

		PartDefinition Fungus_r34 = ArmRightFungus.addOrReplaceChild("Fungus_r34", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 4.9499F, -0.8325F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Fungus_r35 = ArmRightFungus.addOrReplaceChild("Fungus_r35", CubeListBuilder.create().texOffs(-7, 118).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 4.9499F, -0.8325F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r36 = ArmRightFungus.addOrReplaceChild("Fungus_r36", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 0.9499F, 0.0675F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r37 = ArmRightFungus.addOrReplaceChild("Fungus_r37", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, -2.0501F, -1.8325F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r38 = ArmRightFungus.addOrReplaceChild("Fungus_r38", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, -2.0501F, -1.8325F, -0.7227F, -0.2399F, 0.1871F));

		PartDefinition Fungus_r39 = ArmRightFungus.addOrReplaceChild("Fungus_r39", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 0.9499F, 0.0675F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(68, 58).addBox(-3.0F, -4.0F, -4.0F, 8.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(74, 40).addBox(-3.0F, -4.0F, -4.0F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(9.0F, -8.0F, 1.0F, -0.4659F, -0.1198F, -0.2333F));

		PartDefinition LeftShoulderPad = LeftArm.addOrReplaceChild("LeftShoulderPad", CubeListBuilder.create().texOffs(50, 78).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 9.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.0F, -1.0F, 0.1309F, 0.0F, 0.5672F));

		PartDefinition Nose_r1 = LeftShoulderPad.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(84, 128).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -4.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition crown1 = LeftShoulderPad.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.8633F, -4.9688F, 2.5292F, -0.4029F, 0.0072F, 0.2962F));

		PartDefinition Petal4_r1 = crown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 125).addBox(-6.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = crown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 132).addBox(-2.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = crown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 118).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 132).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(94, 0).addBox(-2.5F, 0.0F, -4.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(1.0F, 0.0F, -5.0F, 3.0F, 8.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(1.25F, 3.0F, -3.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 7.0F, 0.25F, 0.2618F, 0.0F, 0.0F));

		PartDefinition LeftArmSeg3 = LeftArmSeg2.addOrReplaceChild("LeftArmSeg3", CubeListBuilder.create().texOffs(52, 105).addBox(-2.5F, 0.0F, -2.5F, 5.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 10.0F, -0.75F, -0.3011F, 0.0522F, 0.1666F));

		PartDefinition Beyblade = LeftArmSeg3.addOrReplaceChild("Beyblade", CubeListBuilder.create().texOffs(0, 43).addBox(-3.0F, 4.0F, -3.0F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Plate_r13 = Beyblade.addOrReplaceChild("Plate_r13", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.25F, -2.75F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1225F, 12.9094F, -0.1038F, -0.3235F, -0.0621F, 0.4239F));

		PartDefinition Plate_r14 = Beyblade.addOrReplaceChild("Plate_r14", CubeListBuilder.create().texOffs(0, 43).addBox(-0.25F, -1.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.74F, 8.6511F, 0.4508F, 0.6056F, -0.0543F, -0.1222F));

		PartDefinition Plate_r15 = Beyblade.addOrReplaceChild("Plate_r15", CubeListBuilder.create().texOffs(0, 43).addBox(-0.5F, -4.5F, -2.0F, 1.0F, 11.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.5907F, 7.0716F, 0.97F, 0.2711F, -0.2104F, -0.0439F));

		PartDefinition Plate_r16 = Beyblade.addOrReplaceChild("Plate_r16", CubeListBuilder.create().texOffs(0, 43).addBox(-4.25F, 3.5F, -5.75F, 1.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(-4.5F, -0.6F, -2.5F, 3.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 43).addBox(-2.0F, -1.6F, -1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 6.6F, 3.25F, 0.0F, 0.2182F, 0.0F));

		PartDefinition Plate_r17 = Beyblade.addOrReplaceChild("Plate_r17", CubeListBuilder.create().texOffs(0, 43).addBox(-0.25F, -1.5F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2509F, 3.5F, 2.5548F, 0.0F, 0.48F, 0.0F));

		PartDefinition Plate_r18 = Beyblade.addOrReplaceChild("Plate_r18", CubeListBuilder.create().texOffs(0, 43).addBox(-1.0F, -1.5F, -1.5F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.0F, 6.5F, -1.5F, 0.0F, 0.1309F, 0.0F));

		PartDefinition Plate_r19 = Beyblade.addOrReplaceChild("Plate_r19", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 8.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Plate_r20 = Beyblade.addOrReplaceChild("Plate_r20", CubeListBuilder.create().texOffs(0, 43).addBox(-3.0F, 0.0F, -1.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 12.6993F, -2.0463F, 0.3054F, 0.0F, 0.0F));

		PartDefinition FrontBlade = Beyblade.addOrReplaceChild("FrontBlade", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 7.9046F, 0.0875F, -0.1745F, 0.0F, 0.0F));

		PartDefinition bottomconnection_r1 = FrontBlade.addOrReplaceChild("bottomconnection_r1", CubeListBuilder.create().texOffs(114, 79).addBox(-0.5F, -1.0F, -11.0F, 1.0F, 2.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.3693F, 11.4654F, -0.3927F, 0.0F, 0.0F));

		PartDefinition bottomBrace_r1 = FrontBlade.addOrReplaceChild("bottomBrace_r1", CubeListBuilder.create().texOffs(71, 170).addBox(0.0F, 0.0F, -2.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.5F, -1.2899F, 14.3604F, -0.1745F, 0.0F, 0.0F));

		PartDefinition topconnection_r1 = FrontBlade.addOrReplaceChild("topconnection_r1", CubeListBuilder.create().texOffs(117, 82).addBox(-0.5F, -1.0F, -8.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.823F, 5.58F, 0.0436F, 0.0F, 0.0F));

		PartDefinition topBrace_r1 = FrontBlade.addOrReplaceChild("topBrace_r1", CubeListBuilder.create().texOffs(71, 170).addBox(-1.0F, -14.0F, -2.0F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.21F)), PartPose.offsetAndRotation(0.5F, -1.2899F, 14.3604F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Plane_r4 = FrontBlade.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(0, 43).addBox(1.0F, -12.0F, -7.0F, 0.0F, 23.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.6811F, 6.817F, 0.1745F, 0.0F, 0.0F));

		PartDefinition BackBlade = Beyblade.addOrReplaceChild("BackBlade", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.4951F, 3.1727F, 0.2999F, -0.0576F, 0.1214F));

		PartDefinition bottomconnection_r2 = BackBlade.addOrReplaceChild("bottomconnection_r2", CubeListBuilder.create().texOffs(117, 82).addBox(-1.0F, -1.0F, -0.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.5F, 7.6763F, -12.0394F, 0.3491F, 0.0F, 0.0F));

		PartDefinition bottomBrace_r2 = BackBlade.addOrReplaceChild("bottomBrace_r2", CubeListBuilder.create().texOffs(71, 170).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5F, 0.1196F, -14.1434F, 0.1745F, 0.0F, 0.0F));

		PartDefinition topconnection_r2 = BackBlade.addOrReplaceChild("topconnection_r2", CubeListBuilder.create().texOffs(118, 83).addBox(-1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.5F, -9.357F, -5.8392F, -0.0436F, 0.0F, 0.0F));

		PartDefinition topBrace_r2 = BackBlade.addOrReplaceChild("topBrace_r2", CubeListBuilder.create().texOffs(71, 170).addBox(-2.0F, -12.0F, 0.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.1196F, -14.1434F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Plane_r5 = BackBlade.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(28, 72).addBox(1.0F, -10.0F, -7.0F, 0.0F, 19.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.7284F, -6.6001F, -0.1745F, 0.0F, 0.0F));

		PartDefinition LeftArmFungus = LeftArmSeg2.addOrReplaceChild("LeftArmFungus", CubeListBuilder.create(), PartPose.offset(17.0F, 10.7F, 1.45F));

		PartDefinition Fungus_r40 = LeftArmFungus.addOrReplaceChild("Fungus_r40", CubeListBuilder.create().texOffs(-7, 118).addBox(-4.5F, 4.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -7.25F, -4.9F, -0.0464F, 0.5351F, -0.3512F));

		PartDefinition Fungus_r41 = LeftArmFungus.addOrReplaceChild("Fungus_r41", CubeListBuilder.create().texOffs(-7, 118).addBox(-2.5F, -4.5F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -4.25F, -4.9F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Fungus_r42 = LeftArmFungus.addOrReplaceChild("Fungus_r42", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -7.25F, -0.9F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r43 = LeftArmFungus.addOrReplaceChild("Fungus_r43", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -7.25F, -0.9F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r44 = LeftArmFungus.addOrReplaceChild("Fungus_r44", CubeListBuilder.create().texOffs(-7, 125).addBox(-4.25F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -4.25F, -0.9F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r45 = LeftArmFungus.addOrReplaceChild("Fungus_r45", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 3.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -4.25F, -0.9F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Neck = TopTorso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(50, 95).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.5F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(54, 0).addBox(-5.0F, -12.0F, -7.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(114, 72).addBox(-5.0F, -2.0F, -2.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.5F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(116, 18).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 2.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(116, 25).addBox(-5.0F, -4.0F, -5.0F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, -2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(178, 121).addBox(-1.5F, -46.5F, -10.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 41.5F, 0.0F));

		PartDefinition HeadFungus = Head.addOrReplaceChild("HeadFungus", CubeListBuilder.create(), PartPose.offset(-0.5181F, -2.515F, -0.5978F));

		PartDefinition Fungus_r46 = HeadFungus.addOrReplaceChild("Fungus_r46", CubeListBuilder.create().texOffs(-7, 125).addBox(-1.5F, -22.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5427F, 12.4366F, -0.5281F, 0.038F, -0.7157F, 0.187F));

		PartDefinition Fungus_r47 = HeadFungus.addOrReplaceChild("Fungus_r47", CubeListBuilder.create().texOffs(-7, 118).addBox(1.5F, -20.0F, 7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7319F, 15.465F, 1.3978F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition flower = HeadFungus.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4388F, -7.1924F, -3.4268F, 0.9599F, 0.0F, -1.0036F));

		PartDefinition cube_r1 = flower.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-7, 118).addBox(-7.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = flower.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-7, 118).addBox(0.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = flower.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.84F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = flower.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.84F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower2 = HeadFungus.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.2625F, -7.4277F, -3.7482F, 1.0704F, 0.5597F, -0.1547F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-7, 132).addBox(-7.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-7, 125).addBox(0.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.84F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.84F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = HeadFungus.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.2625F, -7.4277F, 1.2518F, -0.6318F, 1.152F, -1.4657F));

		PartDefinition cube_r9 = flower3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-7, 132).addBox(-7.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r10 = flower3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-7, 125).addBox(0.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.84F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.84F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = HeadFungus.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.2625F, -7.4277F, 1.2518F, -1.5916F, 0.9465F, -1.6158F));

		PartDefinition cube_r13 = flower4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-7, 132).addBox(-7.68F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r14 = flower4.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-7, 125).addBox(0.0F, 0.0F, -3.84F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r15 = flower4.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.84F, 0.0F, -7.68F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r16 = flower4.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.84F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition TopChestFungus = TopTorso.addOrReplaceChild("TopChestFungus", CubeListBuilder.create(), PartPose.offset(-1.8093F, -6.3392F, 6.9025F));

		PartDefinition Fungus_r48 = TopChestFungus.addOrReplaceChild("Fungus_r48", CubeListBuilder.create().texOffs(-7, 132).addBox(-1.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5593F, -0.7108F, -15.1025F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r49 = TopChestFungus.addOrReplaceChild("Fungus_r49", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 1.0F, 0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4407F, -0.2108F, -16.2025F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r50 = TopChestFungus.addOrReplaceChild("Fungus_r50", CubeListBuilder.create().texOffs(-7, 125).addBox(1.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2515F, 3.2607F, -16.0283F, 0.038F, -0.7157F, 0.187F));

		PartDefinition Fungus_r51 = TopChestFungus.addOrReplaceChild("Fungus_r51", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 1.2607F, -13.2766F, -0.038F, -0.7157F, -0.187F));

		PartDefinition Fungus_r52 = TopChestFungus.addOrReplaceChild("Fungus_r52", CubeListBuilder.create().texOffs(-7, 132).addBox(-1.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5593F, 0.2892F, -0.2025F, -0.3325F, 0.5154F, -0.0523F));

		PartDefinition Fungus_r53 = TopChestFungus.addOrReplaceChild("Fungus_r53", CubeListBuilder.create().texOffs(-7, 132).addBox(-1.5F, 1.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.5593F, 2.7892F, -4.2025F, 0.1797F, -0.4891F, -0.195F));

		PartDefinition Fungus_r54 = TopChestFungus.addOrReplaceChild("Fungus_r54", CubeListBuilder.create().texOffs(-7, 118).addBox(-1.5F, 2.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2515F, 4.2607F, 0.7234F, -0.038F, 0.7157F, 0.187F));

		PartDefinition Fungus_r55 = TopChestFungus.addOrReplaceChild("Fungus_r55", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5593F, 3.7892F, -0.2025F, -0.1783F, -0.2977F, 0.0909F));

		PartDefinition Fungus_r56 = TopChestFungus.addOrReplaceChild("Fungus_r56", CubeListBuilder.create().texOffs(-7, 118).addBox(-3.5F, 2.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.7108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r57 = TopChestFungus.addOrReplaceChild("Fungus_r57", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4407F, 0.7892F, 0.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r58 = TopChestFungus.addOrReplaceChild("Fungus_r58", CubeListBuilder.create().texOffs(-7, 132).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3702F, 2.2607F, -2.0283F, 0.038F, 0.7157F, -0.187F));

		PartDefinition Fungus_r59 = TopChestFungus.addOrReplaceChild("Fungus_r59", CubeListBuilder.create().texOffs(-7, 125).addBox(-3.5F, 2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, 1.7892F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition bone = TopChestFungus.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2593F, 7.7892F, -0.7025F, 0.0F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		animateTentacleX(LeftLeg,Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount);
		animateTentacleX(RightLeg,Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount);
		animateTentacleX(LeftForLeg,this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0);
		animateTentacleX(RightForLeg,this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0);
		animateTentacleX(Head,netHeadYaw / (180F / (float) Math.PI));
		animateTentacleY(Head,headPitch /  ( 90F / (float) Math.PI));
		this.RightSkull.visible = entity.hasRightSkull();
		this.LeftSkull.visible = entity.hasLeftSkull();
		animateTentacleX(Jaw,Mth.sin(ageInTicks/6)/6);
		if (entity.getRangedAttackAnimationTick() <= 0){
			animateTentacleX(RightArm,Mth.cos(ageInTicks/7)/4);
		}
		if (entity.getAttackAnimationTick() <= 0){
			animateTentacleX(LeftArm,Mth.sin(ageInTicks/7)/4);
			animateTentacleX(LeftArmSegment,Mth.sin(ageInTicks/7)/6);
		}
		this.animate(entity.block_attack, BLOCK_ATTACK,ageInTicks,1.0F);
		if (entity.hasAxe()){
			this.animate(entity.block_attack, BLOCK_RIGHT,ageInTicks,1.0F);
		}
	}
	@Override
	public void prepareMobModel(T entity, float value1, float value2, float value3) {
		super.prepareMobModel(entity, value1, value2, value3);
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			float swing = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick - value3, 20.0F);
			this.animateTentacleX(LeftArm,swing * 0.5f);
			this.animateTentacleX(LeftArmSegment,swing * 0.3f);
		}
		int rangedAttackAnimationTick = entity.getRangedAttackAnimationTick();
		if (rangedAttackAnimationTick > 0) {
			float swing = -2.0F + 1.5F * Mth.triangleWave((float)rangedAttackAnimationTick - value3, 20.0F);
			this.animateTentacleX(RightArm,swing * 0.5f);
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		hindicator.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return hindicator;
	}

	public ModelPart getHand(){return RightArm;}

	public static final AnimationDefinition BLOCK_ATTACK = AnimationDefinition.Builder.withLength(0.5F)
			.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-46.2935F, 9.4145F, -31.1646F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-46.2935F, 9.4145F, -31.1646F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.addAnimation("LeftArmSeg2", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-63.1152F, 2.7315F, 51.1379F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-63.1152F, 2.7315F, 51.1379F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();

	public static final AnimationDefinition BLOCK_RIGHT = AnimationDefinition.Builder.withLength(0.5F)
			.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.125F, KeyframeAnimations.degreeVec(-41.614F, -15.6841F, 12.5528F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-41.614F, -15.6841F, 12.5528F), AnimationChannel.Interpolations.CATMULLROM),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.CATMULLROM)
			))
			.build();
}