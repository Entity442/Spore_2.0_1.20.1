package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Jagdhund;
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

public class JagdhundModel<T extends Jagdhund> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "jagdhundmodel"), "main");
	private final ModelPart Digger;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftForArm;
	private final ModelPart Tumor;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightJaw;
	private final ModelPart LeftJaw;
	private final ModelPart Tongue1;
	private final ModelPart Tongue2;
	private final ModelPart Tongue3;


	public JagdhundModel(ModelPart root) {
		this.Digger = root.getChild("Digger");
		this.RightLeg = Digger.getChild("Legs").getChild("RightLegJoint");
		this.LeftLeg = Digger.getChild("Legs").getChild("LeftLegJoint");
		this.RightArm = Digger.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("RightArmJoint");
		this.LeftArm = Digger.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("LeftArmJoint");
		this.RightForArm = RightArm.getChild("RightArm").getChild("RightArmSeg2");
		this.LeftForArm = LeftArm.getChild("LeftArm").getChild("LeftArmSeg2");
		this.Tumor = Digger.getChild("LowerTorso").getChild("ChestTumors");
		this.Neck1 = Digger.getChild("LowerTorso").getChild("UpperTorso").getChild("Neck");
		this.Neck2 = Neck1.getChild("NeckSeg2");
		this.Head = Neck2.getChild("Head");
		this.Jaw = Head.getChild("Jaw").getChild("TopJawJoint");
		this.RightJaw = Head.getChild("Jaw").getChild("RightJawJoint");
		this.LeftJaw = Head.getChild("Jaw").getChild("LeftJawJoint");
		this.Tongue1 = Head.getChild("Jaw").getChild("Tongue");
		this.Tongue2 = Tongue1.getChild("BTongue2");
		this.Tongue3 = Tongue2.getChild("BTongue3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Digger = partdefinition.addOrReplaceChild("Digger", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition LowerTorso = Digger.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(38, 47).addBox(-3.4286F, -0.7143F, -1.4643F, 7.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(57, 21).addBox(-3.4286F, -6.7143F, 1.5357F, 7.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(64, 43).addBox(-3.4286F, -6.7143F, -1.4643F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(65, 28).addBox(-3.4286F, -4.7143F, -1.4643F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 76).addBox(-2.4286F, -4.7143F, -1.2143F, 4.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(36, 70).addBox(2.5714F, -6.7143F, -1.4643F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(18, 75).addBox(-3.4286F, -6.7143F, -0.4643F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0714F, -4.1574F, 8.572F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LowerRibs = LowerTorso.addOrReplaceChild("LowerRibs", CubeListBuilder.create(), PartPose.offset(0.0714F, 12.2857F, 0.2857F));

		PartDefinition Spine_r1 = LowerRibs.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(8, 65).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2615F, -18.4886F, 2.0F, -0.0873F, 0.0F, -0.0873F));

		PartDefinition Rib1 = LowerRibs.addOrReplaceChild("Rib1", CubeListBuilder.create().texOffs(73, 0).addBox(-4.0F, -0.5F, -0.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(9, 61).addBox(-4.0F, -0.5F, -3.75F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(-4.0F, -0.5F, -4.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -18.0F, 2.5F));

		PartDefinition Rib2 = LowerRibs.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(73, 0).addBox(-3.0F, -0.5F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 62).addBox(-3.0F, -0.5F, -2.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -16.25F, 2.25F, 0.1265F, -0.0338F, -0.2203F));

		PartDefinition Rib3 = LowerRibs.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(73, 0).addBox(-4.0F, -0.5F, -0.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 62).addBox(-4.0F, -0.5F, -2.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(-4.0F, -0.5F, -3.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -13.5F, 2.5F, 0.1166F, -0.3303F, 0.0532F));

		PartDefinition Rib4 = LowerRibs.addOrReplaceChild("Rib4", CubeListBuilder.create().texOffs(73, 0).addBox(0.0F, -0.5F, -0.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 62).addBox(3.0F, -0.5F, -2.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -18.0F, 2.25F, 0.0F, 0.0F, 0.2182F));

		PartDefinition Rib5 = LowerRibs.addOrReplaceChild("Rib5", CubeListBuilder.create().texOffs(73, 0).addBox(0.0F, -0.5F, -0.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 62).addBox(2.0F, -0.5F, -2.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(0.0F, -0.5F, -3.75F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -15.5F, 2.25F, 0.11F, -0.2287F, -0.16F));

		PartDefinition Rib6 = LowerRibs.addOrReplaceChild("Rib6", CubeListBuilder.create().texOffs(73, 0).addBox(0.0F, -0.5F, -0.75F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(10, 62).addBox(3.0F, -0.5F, -2.75F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -13.5F, 2.5F, 0.06F, 0.3004F, 0.1956F));

		PartDefinition ChestTumors = LowerTorso.addOrReplaceChild("ChestTumors", CubeListBuilder.create(), PartPose.offset(0.0714F, -3.8426F, -1.572F));

		PartDefinition Tumor_r1 = ChestTumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(1, 82).addBox(-2.5F, -1.75F, -2.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6478F, 2.1829F, -0.4605F, -0.8238F, -0.625F, 1.2707F));

		PartDefinition Tumor_r2 = ChestTumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(6, 83).addBox(-0.25F, 0.0F, -2.25F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7078F, 0.7216F, 0.8331F, -0.1436F, -0.9803F, 0.3689F));

		PartDefinition Tumor_r3 = ChestTumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(0, 81).addBox(-1.0F, -2.75F, -1.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -0.5F, -0.7813F, -0.286F, 0.2729F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(31, 30).addBox(-4.5F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(49, 6).addBox(-4.5F, -7.0F, -2.5F, 8.0F, 7.0F, 1.0F, new CubeDeformation(-0.125F)), PartPose.offsetAndRotation(0.5714F, -6.7143F, 0.7857F, 0.5672F, 0.0F, 0.0F));

		PartDefinition UpperTorsoFungus = UpperTorso.addOrReplaceChild("UpperTorsoFungus", CubeListBuilder.create(), PartPose.offset(-3.5593F, -3.9676F, -0.0102F));

		PartDefinition Fungus_r1 = UpperTorsoFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 27).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4084F, -1.1675F, 2.8042F, 0.0288F, -0.519F, -0.1485F));

		PartDefinition Fungus_r2 = UpperTorsoFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 13).addBox(-5.0F, 1.0F, 1.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, -3.8975F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r3 = UpperTorsoFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 20).addBox(0.75F, -4.0F, -1.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, -2.8975F, -0.0333F, -0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = UpperTorsoFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 27).addBox(-3.5F, 1.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, 3.1025F, -0.1783F, 0.2977F, -0.0909F));

		PartDefinition UpperRibs = UpperTorso.addOrReplaceChild("UpperRibs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Spine_r2 = UpperRibs.addOrReplaceChild("Spine_r2", CubeListBuilder.create().texOffs(8, 65).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7416F, -0.2757F, 1.51F, 0.0436F, 0.0F, 0.1309F));

		PartDefinition TopRib1 = UpperRibs.addOrReplaceChild("TopRib1", CubeListBuilder.create().texOffs(73, 0).addBox(-2.8333F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 59).addBox(-3.8333F, -0.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(-2.8333F, -0.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9167F, -5.25F, 1.75F, 0.0F, 0.0F, -0.0873F));

		PartDefinition TopRib2 = UpperRibs.addOrReplaceChild("TopRib2", CubeListBuilder.create().texOffs(73, 0).addBox(-2.8333F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 59).addBox(-3.8333F, -0.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(-2.8333F, -0.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6667F, -2.25F, 1.25F, 0.0F, 0.2618F, 0.1745F));

		PartDefinition TopRib3 = UpperRibs.addOrReplaceChild("TopRib3", CubeListBuilder.create().texOffs(73, 0).addBox(-0.1667F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 58).addBox(2.8333F, -0.5F, -5.5F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(1.8333F, -0.5F, -5.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3333F, -6.0F, 1.75F, -0.1231F, -0.2316F, 0.3198F));

		PartDefinition TopRib4 = UpperRibs.addOrReplaceChild("TopRib4", CubeListBuilder.create().texOffs(73, 0).addBox(-0.1667F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 59).addBox(3.8333F, -0.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(0.8333F, -0.5F, -4.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3333F, -4.0F, 1.75F, 0.2191F, -0.0041F, 0.0192F));

		PartDefinition TopRib5 = UpperRibs.addOrReplaceChild("TopRib5", CubeListBuilder.create().texOffs(73, 0).addBox(-0.1667F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(7, 59).addBox(2.8333F, -0.5F, -4.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(73, 0).addBox(0.8333F, -0.5F, -4.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3333F, -1.0F, 1.75F, -0.1353F, -0.1293F, 0.1591F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-0.5F, -7.0F, 0.0F));

		PartDefinition LeftArmJoint = Arms.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(4.2113F, 1.9532F, 0.0F, 0.0F, -0.3054F, 0.0F));

		PartDefinition LeftArm = LeftArmJoint.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(40, 0).addBox(-1.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1683F, -0.4802F, -0.6538F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(22, 46).mirror().addBox(0.0F, -1.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftArm2 = LeftArmSeg2.addOrReplaceChild("LeftArm2", CubeListBuilder.create(), PartPose.offset(-1.2706F, 5.0793F, 1.2948F));

		PartDefinition Fungus_r5 = LeftArm2.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 13).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = LeftArm2.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 13).addBox(-3.5F, 6.0F, -8.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = LeftArm2.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 20).addBox(-1.5F, -1.0F, -6.25F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = LeftArm2.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 20).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition SharpElbows2 = LeftArmSeg2.addOrReplaceChild("SharpElbows2", CubeListBuilder.create().texOffs(26, 7).mirror().addBox(-2.0F, -4.5F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition LeftArmSeg3 = LeftArmSeg2.addOrReplaceChild("LeftArmSeg3", CubeListBuilder.create().texOffs(25, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.0F, 15.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition LeftClaw = LeftArmSeg3.addOrReplaceChild("LeftClaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0387F, 5.1685F, 0.1423F, 0.0F, 0.0F, 1.5708F));

		PartDefinition LeftClawPlane1 = LeftClaw.addOrReplaceChild("LeftClawPlane1", CubeListBuilder.create().texOffs(8, 74).mirror().addBox(-1.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, 0.3035F, -0.3185F));

		PartDefinition LeftClawPlane2 = LeftClaw.addOrReplaceChild("LeftClawPlane2", CubeListBuilder.create().texOffs(8, 74).mirror().addBox(-1.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2328F, -0.4301F, -0.1599F));

		PartDefinition LeftClawPlane3 = LeftClaw.addOrReplaceChild("LeftClawPlane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3576F, 0.1671F, 0.4268F));

		PartDefinition ClawPlane_r1 = LeftClawPlane3.addOrReplaceChild("ClawPlane_r1", CubeListBuilder.create().texOffs(8, 74).mirror().addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition RightArmJoint = Arms.addOrReplaceChild("RightArmJoint", CubeListBuilder.create(), PartPose.offset(-4.2113F, 1.9532F, 0.0F));

		PartDefinition RightArm = RightArmJoint.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 0).addBox(-7.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.1247F, 0.4802F, 0.6538F));

		PartDefinition RightArmFungus = RightArm.addOrReplaceChild("RightArmFungus", CubeListBuilder.create(), PartPose.offset(-2.848F, -2.9207F, 0.2948F));

		PartDefinition Fungus_r9 = RightArmFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(0, 20).addBox(-1.0F, -1.5F, -3.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2108F, 0.5593F, -2.1025F, -0.5154F, 0.3325F, 0.0523F));

		PartDefinition Fungus_r10 = RightArmFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -3.5F, -7.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7892F, -0.4407F, 3.8975F, 0.4891F, -0.1797F, 0.195F));

		PartDefinition Fungus_r11 = RightArmFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(0, 6).addBox(5.0F, -2.25F, -4.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7892F, 2.5593F, 2.8975F, -0.6219F, 0.0333F, 0.3593F));

		PartDefinition Fungus_r12 = RightArmFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(0, 13).addBox(-1.0F, -3.5F, -2.5F, 0.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2108F, 2.5593F, -3.1025F, 0.2977F, 0.1783F, -0.0909F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(22, 46).addBox(-2.0F, -1.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 0.0F, 0.0F));

		PartDefinition SharpElbows = RightArmSeg2.addOrReplaceChild("SharpElbows", CubeListBuilder.create().texOffs(26, 7).addBox(-2.0F, -4.5F, 0.0F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition RightArmSeg3 = RightArmSeg2.addOrReplaceChild("RightArmSeg3", CubeListBuilder.create().texOffs(25, 73).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.0F, 15.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition RightClaw = RightArmSeg3.addOrReplaceChild("RightClaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0387F, 5.1685F, 0.1423F, 0.0F, 0.0F, -1.5708F));

		PartDefinition RightClawPlane1 = RightClaw.addOrReplaceChild("RightClawPlane1", CubeListBuilder.create().texOffs(8, 74).addBox(-5.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7363F, -0.3035F, 0.3185F));

		PartDefinition RightClawPlane2 = RightClaw.addOrReplaceChild("RightClawPlane2", CubeListBuilder.create().texOffs(8, 74).addBox(-5.0F, -3.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.2328F, 0.4301F, 0.1599F));

		PartDefinition RightClawPlane3 = RightClaw.addOrReplaceChild("RightClawPlane3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3576F, -0.1671F, -0.4268F));

		PartDefinition ClawPlane_r2 = RightClawPlane3.addOrReplaceChild("ClawPlane_r2", CubeListBuilder.create().texOffs(8, 74).addBox(-3.0F, -1.5F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Neck = UpperTorso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(30, 52).addBox(-1.75F, -3.0F, -1.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.0578F, -0.556F, -0.5672F, 0.0F, 0.0F));

		PartDefinition SpineSeg_r1 = Neck.addOrReplaceChild("SpineSeg_r1", CubeListBuilder.create().texOffs(9, 66).addBox(-1.0F, -2.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, 2.5F, 0.0203F, -0.1509F, -0.2666F));

		PartDefinition NeckSeg2 = Neck.addOrReplaceChild("NeckSeg2", CubeListBuilder.create().texOffs(30, 52).addBox(-1.75F, -4.0F, -1.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.12F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition SpineSeg_r2 = NeckSeg2.addOrReplaceChild("SpineSeg_r2", CubeListBuilder.create().texOffs(0, 39).addBox(-1.0F, -5.5F, -0.5F, 2.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 1.0F, 2.25F, 0.0433F, -0.0184F, 0.0395F));

		PartDefinition Head = NeckSeg2.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -1.5F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.915F, 1.1484F, 2.3126F, 0.0F, 3.1416F));

		PartDefinition crown1 = Head.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3899F, -4.9881F, 3.3038F, 0.2182F, 0.0F, 0.3054F));

		PartDefinition Petal4_r1 = crown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(0, 13).addBox(-3.75F, -4.0F, 0.5F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, 0.0399F, 0.5245F, 0.1745F, -0.4363F, 0.0F));

		PartDefinition Petal3_r1 = crown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(0, 27).addBox(-3.5F, -3.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4625F, 0.3603F, 0.6159F, 0.3031F, 0.5483F, -0.0492F));

		PartDefinition Petal2_r1 = crown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(0, 20).addBox(-3.0F, -4.0F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -3.9601F, 0.5245F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(0, 27).addBox(-4.25F, -2.75F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3192F, 2.7861F, -0.336F, 0.9596F, 0.0395F, 0.0184F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 34).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -5.5F));

		PartDefinition LeftJawJoint = Jaw.addOrReplaceChild("LeftJawJoint", CubeListBuilder.create(), PartPose.offset(2.3591F, -0.4226F, 2.6409F));

		PartDefinition LeftJaw = LeftJawJoint.addOrReplaceChild("LeftJaw", CubeListBuilder.create().texOffs(1, 53).addBox(-2.0F, -7.0F, -1.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0036F, -0.7854F, 0.0F));

		PartDefinition Teeth_r1 = LeftJaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7022F, -3.5F, 0.5289F, 0.1543F, -0.8625F, -0.202F));

		PartDefinition Teeth_r2 = LeftJaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7022F, -3.5F, 0.5289F, -0.2041F, -0.8547F, 0.2677F));

		PartDefinition Teeth_r3 = LeftJaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4205F, -3.5F, 0.7789F, -0.2041F, 0.8547F, -0.2677F));

		PartDefinition Teeth_r4 = LeftJaw.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4205F, -3.5F, 0.7789F, 0.1543F, 0.8625F, 0.202F));

		PartDefinition Teeth_r5 = LeftJaw.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(41, 69).addBox(-2.5F, -0.75F, 0.0F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.3056F, 0.7923F, 0.6644F, -0.1932F, -0.102F));

		PartDefinition JawFront_r1 = LeftJaw.addOrReplaceChild("JawFront_r1", CubeListBuilder.create().texOffs(67, 18).addBox(-2.0F, -0.5F, 0.25F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.5F, -1.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition JawOuter_r1 = LeftJaw.addOrReplaceChild("JawOuter_r1", CubeListBuilder.create().texOffs(21, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6215F, -3.5F, 0.0547F, 0.0F, 2.4435F, 0.0F));

		PartDefinition JawInner_r1 = LeftJaw.addOrReplaceChild("JawInner_r1", CubeListBuilder.create().texOffs(21, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6428F, -3.5F, 0.266F, 0.0F, -2.3998F, 0.0F));

		PartDefinition RightJawJoint = Jaw.addOrReplaceChild("RightJawJoint", CubeListBuilder.create(), PartPose.offset(-2.3591F, -0.4226F, 2.6409F));

		PartDefinition RightJaw = RightJawJoint.addOrReplaceChild("RightJaw", CubeListBuilder.create().texOffs(1, 53).addBox(-1.0F, -7.0F, -1.0F, 3.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0036F, 0.7854F, 0.0F));

		PartDefinition Teeth_r6 = RightJaw.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7022F, -3.5F, 0.5289F, 0.1543F, 0.8625F, 0.202F));

		PartDefinition Teeth_r7 = RightJaw.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7022F, -3.5F, 0.5289F, -0.2041F, 0.8547F, -0.2677F));

		PartDefinition Teeth_r8 = RightJaw.addOrReplaceChild("Teeth_r8", CubeListBuilder.create().texOffs(44, 78).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4205F, -3.5F, 0.7789F, -0.2041F, -0.8547F, 0.2677F));

		PartDefinition Teeth_r9 = RightJaw.addOrReplaceChild("Teeth_r9", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.5F, 0.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4205F, -3.5F, 0.7789F, 0.1543F, -0.8625F, -0.202F));

		PartDefinition Teeth_r10 = RightJaw.addOrReplaceChild("Teeth_r10", CubeListBuilder.create().texOffs(41, 69).addBox(-2.5F, -0.75F, 0.25F, 5.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.3056F, 0.7923F, 0.6644F, 0.1932F, 0.102F));

		PartDefinition JawFront_r2 = RightJaw.addOrReplaceChild("JawFront_r2", CubeListBuilder.create().texOffs(67, 18).addBox(-3.0F, -0.5F, 0.25F, 5.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.5F, -1.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition JawOuter_r2 = RightJaw.addOrReplaceChild("JawOuter_r2", CubeListBuilder.create().texOffs(21, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6215F, -3.5F, 0.0547F, 0.0F, -2.5307F, 0.0F));

		PartDefinition JawInner_r2 = RightJaw.addOrReplaceChild("JawInner_r2", CubeListBuilder.create().texOffs(21, 64).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6428F, -3.5F, 0.266F, 0.0F, 2.4871F, 0.0F));

		PartDefinition TopJawJoint = Jaw.addOrReplaceChild("TopJawJoint", CubeListBuilder.create(), PartPose.offset(-0.3591F, -4.2273F, 5.702F));

		PartDefinition TopJaw = TopJawJoint.addOrReplaceChild("TopJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Teeth_r11 = TopJaw.addOrReplaceChild("Teeth_r11", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6844F, -6.4743F, -0.8718F, -2.8589F, 1.2041F, -2.7924F));

		PartDefinition Teeth_r12 = TopJaw.addOrReplaceChild("Teeth_r12", CubeListBuilder.create().texOffs(44, 74).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3628F, -5.4234F, -1.6736F, 3.0795F, 1.0022F, 3.0612F));

		PartDefinition Teeth_r13 = TopJaw.addOrReplaceChild("Teeth_r13", CubeListBuilder.create().texOffs(44, 76).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4587F, -6.0923F, -1.1885F, 2.8996F, -0.9824F, -2.8262F));

		PartDefinition Teeth_r14 = TopJaw.addOrReplaceChild("Teeth_r14", CubeListBuilder.create().texOffs(44, 74).mirror().addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.2413F, -6.1418F, -2.1211F, -2.9873F, -0.8625F, 2.9396F));

		PartDefinition Teeth_r15 = TopJaw.addOrReplaceChild("Teeth_r15", CubeListBuilder.create().texOffs(41, 69).addBox(-2.0F, -0.75F, -0.25F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.3056F, -0.7923F, -0.6596F, -0.1588F, 0.0748F));

		PartDefinition JawFront_r3 = TopJaw.addOrReplaceChild("JawFront_r3", CubeListBuilder.create().texOffs(59, 0).addBox(-3.0F, -0.5F, -2.25F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -8.5F, 1.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition JawRight_r1 = TopJaw.addOrReplaceChild("JawRight_r1", CubeListBuilder.create().texOffs(0, 65).addBox(-6.25F, -5.5F, 4.0F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7183F, -3.5F, 0.5F, 0.0F, -0.8727F, 0.0F));

		PartDefinition JawInner_r3 = TopJaw.addOrReplaceChild("JawInner_r3", CubeListBuilder.create().texOffs(0, 65).addBox(-0.25F, -5.5F, -0.5F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -3.5F, 0.5F, 0.0F, 0.8727F, 0.0F));

		PartDefinition JawBase_r1 = TopJaw.addOrReplaceChild("JawBase_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-2.5F, -4.5F, -0.5F, 5.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.5F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Tongue = Jaw.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(43, 22).addBox(-2.0F, -0.5F, -6.0F, 4.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -1.6499F, 4.9916F, -0.7691F, 0.0F, 0.0F));

		PartDefinition BTongue2 = Tongue.addOrReplaceChild("BTongue2", CubeListBuilder.create().texOffs(49, 14).addBox(-1.5F, -0.5F, -6.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition BTongue3 = BTongue2.addOrReplaceChild("BTongue3", CubeListBuilder.create().texOffs(55, 29).addBox(-1.0F, -0.5F, -6.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -6.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Legs = Digger.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 1.3526F, 0.0F, -3.1416F));

		PartDefinition LeftLegJoint = Legs.addOrReplaceChild("LeftLegJoint", CubeListBuilder.create(), PartPose.offset(1.9F, 0.1284F, 0.8577F));

		PartDefinition LeftLeg = LeftLegJoint.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(60, 47).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1796F, 0.1245F, -0.5996F));

		PartDefinition RightLegFungus = LeftLeg.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(-1.9593F, 3.0324F, 0.7948F));

		PartDefinition Fungus_r13 = RightLegFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 27).addBox(-3.5F, -1.25F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.84F, 1.7984F, -0.3489F, 0.0831F, 0.6168F, 0.1449F));

		PartDefinition Fungus_r14 = RightLegFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 27).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1611F, -0.8912F, -2.0111F, 0.0474F, -0.2977F, -0.0909F));

		PartDefinition LeftLegFoot = LeftLeg.addOrReplaceChild("LeftLegFoot", CubeListBuilder.create().texOffs(60, 47).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F))
		.texOffs(51, 29).addBox(-1.0F, 3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 1.309F, 0.0F, 0.0F));

		PartDefinition RightLegJoint = Legs.addOrReplaceChild("RightLegJoint", CubeListBuilder.create(), PartPose.offset(-1.9F, 0.1284F, 0.8577F));

		PartDefinition RightLeg = RightLegJoint.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(60, 47).mirror().addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(51, 29).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1184F, -0.1468F, 0.7298F));

		PartDefinition RightLegFoot = RightLeg.addOrReplaceChild("RightLegFoot", CubeListBuilder.create().texOffs(60, 47).mirror().addBox(-1.5F, 2.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(51, 29).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 1.309F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void animateTumor(ModelPart part, float age){
		part.xScale = 1+ Mth.sin(age/6)/6;
		part.yScale = 1+ Mth.sin(age/6)/6;
		part.zScale = 1+ Mth.sin(age/6)/6;
	}
	private void animateTongue(ModelPart part,float value){
		part.xRot = part.getInitialPose().xRot + Mth.sin(value/6)/5;
		part.zRot = Mth.sin(value/5)/5;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float moveValue  = Mth.cos(limbSwing * 0.3F) * 0.8F * limbSwingAmount;
		float neckMovement = netHeadYaw / (360F / (float) Math.PI)/3;
		RightLeg.yRot = moveValue * 0.6f;
		LeftLeg.yRot = -RightLeg.yRot;
		RightArm.yRot = moveValue *1.2f;
		RightForArm.zRot = RightArm.yRot * 0.6f;
		LeftArm.yRot = RightArm.yRot;
		LeftForArm.zRot = LeftArm.yRot * 0.6f;
		animateTumor(Tumor,ageInTicks);
		Neck1.zRot = neckMovement/3;
		Neck2.yRot = neckMovement/3;
		Head.yRot = -neckMovement/3;
		Jaw.xRot = Mth.cos(ageInTicks/6)/5;
		RightJaw.zRot = Mth.cos(ageInTicks/6)/5;
		LeftJaw.zRot = -RightJaw.zRot;
		animateTongue(Tongue1,ageInTicks);
		animateTongue(Tongue2,ageInTicks);
		animateTongue(Tongue3,ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Digger.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Digger;
	}
}