package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.InfestedConstruct;
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

public class InfestedContructModel<T extends InfestedConstruct> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infestedcontructmodel"), "main");
	private final ModelPart Infgolem;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart LeftLegTumor;
	private final ModelPart RightLegTendril1;
	private final ModelPart RightLegTendril2;
	private final ModelPart RightLegTendril3;
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart RightArmBigTumor;
	private final ModelPart RightArmTendril1;
	private final ModelPart RightArmTendril2;
	private final ModelPart RightArmTendril3;
	private final ModelPart RightForArm;
	private final ModelPart RightArmTentacle;
	private final ModelPart RightArmTendril21;
	private final ModelPart RightArmTendril22;
	private final ModelPart RightArmTendril23;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart LeftForArm1;
	private final ModelPart LeftForTendril11;
	private final ModelPart LeftForTendril12;
	private final ModelPart LeftForTendril13;
	private final ModelPart LeftForTendril21;
	private final ModelPart LeftForTendril22;
	private final ModelPart LeftForTendril23;
	private final ModelPart BodyTumor1;
	private final ModelPart BodyTumor2;
	private final ModelPart BodyTendril11;
	private final ModelPart BodyTendril12;
	private final ModelPart BodyTendril13;
	private final ModelPart BodyTendril21;
	private final ModelPart BodyTendril22;
	private final ModelPart BodyTendril23;
	private final ModelPart BodyTentacle1;
	private final ModelPart BodyTentacle2;
	private final ModelPart BodyTentacle3;
	private final ModelPart PilotArm;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart Dispenser;

	public InfestedContructModel(ModelPart root) {
		this.Infgolem = root.getChild("Infgolem");this.RightLeg = Infgolem.getChild("Legs").getChild("RightLeg");
		this.LeftLeg = Infgolem.getChild("Legs").getChild("LeftLeg");
		this.RightForLeg = RightLeg.getChild("RightLegSeg2");
		this.LeftForLeg = LeftLeg.getChild("LeftLegSeg2");
		this.LeftLegTumor = LeftForLeg.getChild("RightLegTumors");
		this.RightLegTendril1 = RightLeg.getChild("RightLegTendril");
		this.RightLegTendril2 = RightLegTendril1.getChild("Seg2RightLegTendril");
		this.RightLegTendril3 = RightLegTendril2.getChild("Seg3RightLegTendril");
		this.Torso = Infgolem.getChild("Torso").getChild("UpperTorso");
		this.RightArm = Torso.getChild("Arms").getChild("RightArm");
		this.RightArmBigTumor = RightArm.getChild("RightArmTumors");
		this.RightArmTendril1 = RightArm.getChild("RightArmTendril");
		this.RightArmTendril2 = RightArmTendril1.getChild("Seg2RightArmTendril");
		this.RightArmTendril3 = RightArmTendril2.getChild("Seg3RightArmTendril");
		this.RightForArm = RightArm.getChild("RightArmSolo").getChild("RightArmMiddle");
		this.RightArmTentacle = RightForArm.getChild("RightArmTendril2");
		this.RightArmTendril21 = RightForArm.getChild("RightArmTendril1");
		this.RightArmTendril22 = RightArmTendril21.getChild("Seg2RightArmTendril1");
		this.RightArmTendril23 = RightArmTendril22.getChild("Seg3RightArmTendril1");
		this.LeftArm = Torso.getChild("Arms").getChild("LeftArm");
		this.LeftForArm = LeftArm.getChild("LeftArmJoint").getChild("LeftArmMiddle");
		this.LeftForArm1 = LeftForArm.getChild("LeftArmEnd");
		this.LeftForTendril11 = LeftArm.getChild("LeftArmJoint").getChild("LeftArmTendril");
		this.LeftForTendril12 = LeftForTendril11.getChild("Seg2LeftArmTendril");
		this.LeftForTendril13 = LeftForTendril12.getChild("Seg3LeftArmTendril");
		this.LeftForTendril21 = LeftForArm.getChild("LeftArmTendril2");
		this.LeftForTendril22 = LeftForTendril21.getChild("Seg2LeftArmTendril2");
		this.LeftForTendril23 = LeftForTendril22.getChild("Seg3LeftArmTendril2");
		this.BodyTumor1 = Torso.getChild("TorsoDetails").getChild("FrontTumors");
		this.BodyTumor2 = Torso.getChild("TorsoDetails").getChild("BackTumors");
		this.BodyTendril11 = Torso.getChild("TorsoDetails").getChild("TorsoTendrils").getChild("Tendril3");
		this.BodyTendril12 = BodyTendril11.getChild("Seg2Tendril3");
		this.BodyTendril13 = BodyTendril12.getChild("Seg3Tendril3");
		this.BodyTendril21 = Torso.getChild("TorsoDetails").getChild("TorsoTendrils").getChild("Tendril5");
		this.BodyTendril22 = BodyTendril21.getChild("Seg2Tendril5");
		this.BodyTendril23 = BodyTendril22.getChild("Seg3Tendril5");
		this.BodyTentacle1 = Torso.getChild("TorsoDetails").getChild("TorsoTendrils").getChild("Tendril1");
		this.BodyTentacle2 = Torso.getChild("TorsoDetails").getChild("TorsoTendrils").getChild("Tendril2");
		this.BodyTentacle3 = Torso.getChild("TorsoDetails").getChild("TorsoTendrils").getChild("Tendril4");
		this.PilotArm = Torso.getChild("Pilot").getChild("PilotArm");
		this.Head = Torso.getChild("Pilot").getChild("PilotHead");
		this.Jaw = Head.getChild("Jaw");
		this.Dispenser = Torso.getChild("Dispenser");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Infgolem = partdefinition.addOrReplaceChild("Infgolem", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Legs = Infgolem.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, 2.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(104, 21).addBox(-3.0F, 0.0F, -2.5F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(74, 134).addBox(-1.5F, 7.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, -16.0F, 0.5F));

		PartDefinition Wire_r1 = RightLeg.addOrReplaceChild("Wire_r1", CubeListBuilder.create().texOffs(36, 75).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 7.25F, -1.25F, -0.2614F, 0.082F, -0.0473F));

		PartDefinition Wire_r2 = RightLeg.addOrReplaceChild("Wire_r2", CubeListBuilder.create().texOffs(32, 75).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.25F, -0.25F, -0.0576F, 0.1463F, 0.2082F));

		PartDefinition Wire_r3 = RightLeg.addOrReplaceChild("Wire_r3", CubeListBuilder.create().texOffs(28, 75).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 7.25F, 1.75F, -0.1007F, 0.5214F, -0.0503F));

		PartDefinition RightLegFungus = RightLeg.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(-3.0593F, 3.1608F, 0.1525F));

		PartDefinition Fungus_r1 = RightLegFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 82).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = RightLegFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = RightLegFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 82).addBox(-2.25F, -5.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = RightLegFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 75).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightLegTendril = RightLeg.addOrReplaceChild("RightLegTendril", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0869F, 4.6128F, 0.7571F, 0.829F, 0.0F, 0.3927F));

		PartDefinition TendrilSegment_r1 = RightLegTendril.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2RightLegTendril = RightLegTendril.addOrReplaceChild("Seg2RightLegTendril", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0138F, 3.9634F, -0.0145F, -0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r2 = Seg2RightLegTendril.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg3RightLegTendril = Seg2RightLegTendril.addOrReplaceChild("Seg3RightLegTendril", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, 4.3197F, -0.0142F, -0.6109F, 0.0F, -0.6981F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(104, 79).addBox(-3.0F, 1.0F, -2.5F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(28, 107).addBox(-3.0F, 2.0F, -2.5F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(126, 20).addBox(-3.0F, 0.0F, -2.5F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -16.0F, 0.5F));

		PartDefinition LeftLegCrown = LeftLeg.addOrReplaceChild("LeftLegCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(1.6189F, 5.3984F, 2.1092F, -1.5708F, 0.48F, 0.0F));

		PartDefinition Petal6_r1 = LeftLegCrown.addOrReplaceChild("Petal6_r1", CubeListBuilder.create().texOffs(-7, 82).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal5_r1 = LeftLegCrown.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(-7, 82).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal4_r1 = LeftLegCrown.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal3_r1 = LeftLegCrown.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 75).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2969F, 0.3356F, 0.5792F, 0.4726F, -0.2047F, -0.1036F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create().texOffs(46, 123).addBox(-2.75F, 0.0F, -1.75F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(128, 117).addBox(-1.5F, 2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition Wires_r1 = LeftLegSeg2.addOrReplaceChild("Wires_r1", CubeListBuilder.create().texOffs(20, 69).addBox(-0.85F, -1.0F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 0.0F, -0.75F, 0.2172F, 0.0226F, 0.1775F));

		PartDefinition Wires_r2 = LeftLegSeg2.addOrReplaceChild("Wires_r2", CubeListBuilder.create().texOffs(24, 68).addBox(-0.15F, -1.0F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.2618F));

		PartDefinition RightLegTumors = LeftLegSeg2.addOrReplaceChild("RightLegTumors", CubeListBuilder.create(), PartPose.offset(0.0F, 6.5F, -1.0F));

		PartDefinition Tumor_r1 = RightLegTumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(66, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.25F, 0.75F, 1.0F, 0.5588F, -0.0108F, -0.1922F));

		PartDefinition Tumor_r2 = RightLegTumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(66, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.0F, -1.75F, 2.0F, -0.1393F, -0.0108F, -0.1922F));

		PartDefinition Tumor_r3 = RightLegTumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(66, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3054F, -0.6545F));

		PartDefinition Tumor_r4 = RightLegTumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(66, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.0F, 0.0F, 2.0F, 0.0F, -0.3491F, 0.4363F));

		PartDefinition Torso = Infgolem.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(28, 41).addBox(-3.5F, -4.5F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-0.5F, -16.5F, 2.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition UpperTorso = Torso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -11.0F, -5.5F, 5.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(36, 118).addBox(-4.0F, -11.0F, -4.5F, 3.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 23).addBox(6.0F, -11.0F, -5.5F, 3.0F, 12.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(112, 91).addBox(3.0F, -11.0F, 1.5F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(116, 117).addBox(3.0F, -11.0F, -5.5F, 3.0F, 12.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(102, 127).addBox(1.0F, -11.0F, -5.5F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(84, 21).addBox(-4.0F, -11.0F, 2.5F, 7.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1173F, -4.5233F, -0.1921F, 0.3043F, 0.0262F, -0.0832F));

		PartDefinition UpperChestFungus = UpperTorso.addOrReplaceChild("UpperChestFungus", CubeListBuilder.create(), PartPose.offset(1.6767F, -7.8159F, -3.1555F));

		PartDefinition Fungus_r5 = UpperChestFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 89).addBox(-10.5F, 1.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4407F, -1.7108F, -1.1025F, 0.3325F, -0.5154F, -0.0523F));

		PartDefinition Fungus_r6 = UpperChestFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.5F, 2.0F, -11.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4407F, 0.7892F, 2.8975F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r7 = UpperChestFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 82).addBox(-3.5F, 3.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3702F, 2.2607F, -2.0283F, -0.2675F, -0.7157F, 0.187F));

		PartDefinition Fungus_r8 = UpperChestFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 75).addBox(-5.5F, 5.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4407F, 1.7892F, -3.1025F, 0.1783F, 0.2977F, 0.0909F));

		PartDefinition UpperChestCrown1 = UpperChestFungus.addOrReplaceChild("UpperChestCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7601F, 7.8105F, 7.2808F, 0.5693F, 0.2057F, 1.3101F));

		PartDefinition Petal4_r2 = UpperChestCrown1.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(-7, 82).addBox(-2.0F, 1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, 0.5245F, 0.0399F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = UpperChestCrown1.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 89).addBox(-6.0F, 2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, -1.4073F, 0.0399F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = UpperChestCrown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 75).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, 0.5245F, -3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = UpperChestCrown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 82).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, -0.3356F, 0.5792F, -0.4726F, 0.2047F, -0.1036F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.5F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(-9.0F, 0.0F, 0.0F));

		PartDefinition LeftArmJoint = LeftArm.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create().texOffs(46, 52).addBox(-4.0F, -2.5F, -3.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6981F, 0.0F, 0.0873F));

		PartDefinition LeftArmTendril = LeftArmJoint.addOrReplaceChild("LeftArmTendril", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4131F, 6.4373F, -0.9347F, -0.3053F, -0.1719F, -0.2789F));

		PartDefinition Seg2LeftArmTendril = LeftArmTendril.addOrReplaceChild("Seg2LeftArmTendril", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0138F, 3.9634F, 0.0145F, -0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r3 = Seg2LeftArmTendril.addOrReplaceChild("TendrilSegment_r3", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg3LeftArmTendril = Seg2LeftArmTendril.addOrReplaceChild("Seg3LeftArmTendril", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, 0.7418F));

		PartDefinition LeftArmMiddle = LeftArmJoint.addOrReplaceChild("LeftArmMiddle", CubeListBuilder.create().texOffs(76, 108).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(108, 71).addBox(-1.75F, 8.0F, -3.0F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(126, 26).addBox(-1.25F, 1.0F, -2.25F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.5F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition Wire_r4 = LeftArmMiddle.addOrReplaceChild("Wire_r4", CubeListBuilder.create().texOffs(44, 75).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.191F, 0.8802F, 1.8687F, 0.0F, 0.5236F, 0.3054F));

		PartDefinition Wire_r5 = LeftArmMiddle.addOrReplaceChild("Wire_r5", CubeListBuilder.create().texOffs(56, 68).addBox(-1.5585F, -1.5571F, -1.1624F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.941F, 0.8802F, -1.6313F, -0.0252F, 0.5581F, -0.2336F));

		PartDefinition Wire_r6 = LeftArmMiddle.addOrReplaceChild("Wire_r6", CubeListBuilder.create().texOffs(52, 68).addBox(-1.0F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7095F, 0.954F, 0.5061F, 0.0255F, 0.2272F, 0.152F));

		PartDefinition LeftArmMiddleFungus = LeftArmMiddle.addOrReplaceChild("LeftArmMiddleFungus", CubeListBuilder.create(), PartPose.offset(0.0789F, 14.7903F, -1.8079F));

		PartDefinition Fungus_r9 = LeftArmMiddleFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 82).addBox(-2.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0384F, -10.817F, 2.05F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = LeftArmMiddleFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 75).addBox(-8.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0384F, -8.317F, 6.05F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition LeftArmTendril2 = LeftArmMiddle.addOrReplaceChild("LeftArmTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4131F, 9.1128F, 0.2571F, 0.0F, 0.0F, 0.3927F));

		PartDefinition TendrilSegment_r4 = LeftArmTendril2.addOrReplaceChild("TendrilSegment_r4", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2LeftArmTendril2 = LeftArmTendril2.addOrReplaceChild("Seg2LeftArmTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0138F, 3.9634F, -0.0145F, 0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r5 = Seg2LeftArmTendril2.addOrReplaceChild("TendrilSegment_r5", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg3LeftArmTendril2 = Seg2LeftArmTendril2.addOrReplaceChild("Seg3LeftArmTendril2", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, 4.3197F, -0.0142F, 0.0F, 0.0F, -1.0036F));

		PartDefinition LeftArmEnd = LeftArmMiddle.addOrReplaceChild("LeftArmEnd", CubeListBuilder.create().texOffs(20, 118).addBox(-1.6623F, 0.7322F, -2.25F, 3.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(56, 68).addBox(0.0877F, -1.0178F, -0.25F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0936F, 9.9281F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(9.0F, 0.6088F, 0.7934F));

		PartDefinition RightArmTumors = RightArm.addOrReplaceChild("RightArmTumors", CubeListBuilder.create(), PartPose.offset(0.0F, -0.6088F, -0.7934F));

		PartDefinition Tumor_r5 = RightArmTumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(61, 17).addBox(-4.6638F, -4.0277F, -0.5493F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.7643F, 1.0026F, 0.1921F, 0.7206F, 0.1622F, 0.9444F));

		PartDefinition Tumor_r6 = RightArmTumors.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(60, 15).addBox(-2.4663F, -1.6225F, -4.5801F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7643F, 1.0026F, 0.1921F, 0.6277F, 0.3549F, 0.3512F));

		PartDefinition Tumor_r7 = RightArmTumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(61, 17).addBox(-2.3599F, -5.1865F, -4.2611F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.7643F, 1.0026F, 0.1921F, 0.5472F, -0.1744F, -0.4631F));

		PartDefinition RightArmTendril = RightArm.addOrReplaceChild("RightArmTendril", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4612F, -2.9311F, -1.4863F, 0.4577F, 0.6314F, 0.7455F));

		PartDefinition Seg2RightArmTendril = RightArmTendril.addOrReplaceChild("Seg2RightArmTendril", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -4.9634F, -0.0145F, -0.829F, 0.0F, -0.3491F));

		PartDefinition Seg3RightArmTendril = Seg2RightArmTendril.addOrReplaceChild("Seg3RightArmTendril", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -7.25F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -4.3197F, -0.0142F, 0.8727F, 0.0F, 0.0F));

		PartDefinition RightArmSolo = RightArm.addOrReplaceChild("RightArmSolo", CubeListBuilder.create().texOffs(26, 52).addBox(-0.0304F, -1.8473F, -3.0F, 4.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4881F, -0.9304F, -0.0829F, -0.8608F, 0.1666F, 0.1415F));

		PartDefinition RightArmCrown = RightArmSolo.addOrReplaceChild("RightArmCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(2.2769F, -1.1389F, -1.173F, 0.1201F, -0.1898F, 0.7494F));

		PartDefinition Petal5_r2 = RightArmCrown.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(-7, 82).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r3 = RightArmCrown.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(-7, 89).addBox(-6.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, -0.0399F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal3_r3 = RightArmCrown.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(-7, 82).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r2 = RightArmCrown.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, -0.5792F, -0.4726F, -0.2047F, 0.1036F));

		PartDefinition RightArmMiddle = RightArmSolo.addOrReplaceChild("RightArmMiddle", CubeListBuilder.create().texOffs(84, 79).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 9.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 128).addBox(-2.0F, 11.0F, -2.25F, 3.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9696F, 8.2209F, -0.5176F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Wire_r7 = RightArmMiddle.addOrReplaceChild("Wire_r7", CubeListBuilder.create().texOffs(46, 118).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.7573F, 1.3023F, 0.968F, 0.0949F, 0.4011F, -0.1766F));

		PartDefinition Wire_r8 = RightArmMiddle.addOrReplaceChild("Wire_r8", CubeListBuilder.create().texOffs(40, 75).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.3582F, 1.5119F, -0.2105F, 0.4011F, -0.1766F));

		PartDefinition RightArmFungus = RightArmMiddle.addOrReplaceChild("RightArmFungus", CubeListBuilder.create(), PartPose.offset(-0.8998F, 4.2849F, -0.8483F));

		PartDefinition Fungus_r11 = RightArmFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.1475F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r12 = RightArmFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 75).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5593F, -0.2108F, 0.8975F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightArmTendril1 = RightArmMiddle.addOrReplaceChild("RightArmTendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.8586F, 0.284F, -0.2058F));

		PartDefinition Tendril_r1 = RightArmTendril1.addOrReplaceChild("Tendril_r1", CubeListBuilder.create().texOffs(46, 129).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2RightArmTendril1 = RightArmTendril1.addOrReplaceChild("Seg2RightArmTendril1", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 2.75F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Seg3RightArmTendril1 = Seg2RightArmTendril1.addOrReplaceChild("Seg3RightArmTendril1", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RightArmTendril2 = RightArmMiddle.addOrReplaceChild("RightArmTendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 0.0F, -1.0F, 1.4768F, -1.2107F, -2.1004F));

		PartDefinition Tendril_r2 = RightArmTendril2.addOrReplaceChild("Tendril_r2", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2RightArmTendril2 = RightArmTendril2.addOrReplaceChild("Seg2RightArmTendril2", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 2.75F, 0.0F, 0.5031F, 0.12F, -0.6295F));

		PartDefinition Seg3RightArmTendril2 = Seg2RightArmTendril2.addOrReplaceChild("Seg3RightArmTendril2", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, 1.5997F, -0.5305F, -0.5981F));

		PartDefinition Wires = UpperTorso.addOrReplaceChild("Wires", CubeListBuilder.create(), PartPose.offset(0.0F, -11.3766F, 3.3257F));

		PartDefinition Wire3_r1 = Wires.addOrReplaceChild("Wire3_r1", CubeListBuilder.create().texOffs(0, 57).addBox(-0.3931F, -0.9733F, -9.8705F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4007F, -2.4756F, 3.0242F, 0.6021F, -0.2059F, -0.5093F));

		PartDefinition Wire2_r1 = Wires.addOrReplaceChild("Wire2_r1", CubeListBuilder.create().texOffs(96, 118).addBox(-0.5F, -0.5F, -6.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -0.7117F, 1.137F, 0.5795F, 0.4366F, 0.4419F));

		PartDefinition Wire1_r1 = Wires.addOrReplaceChild("Wire1_r1", CubeListBuilder.create().texOffs(128, 126).addBox(-0.5F, -0.5F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.7117F, 1.137F, 0.4804F, -0.0322F, -0.0295F));

		PartDefinition Head = Wires.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(28, 23).addBox(-4.0F, -10.0F, -4.5F, 8.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 1.5F, -2.0508F, 0.0F, 0.0F));

		PartDefinition Nose_r1 = Head.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(138, 139).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -4.5F, 0.2182F, 0.0F, -0.48F));

		PartDefinition GolemHeadCrown = Head.addOrReplaceChild("GolemHeadCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(2.7191F, -9.004F, 0.9871F, -0.4522F, -0.0337F, 0.5294F));

		PartDefinition Petal4_r4 = GolemHeadCrown.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(-7, 75).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r4 = GolemHeadCrown.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(-7, 89).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r3 = GolemHeadCrown.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(-7, 75).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = GolemHeadCrown.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(-7, 89).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2969F, 0.3356F, 0.5792F, 0.4726F, -0.2047F, -0.0163F));

		PartDefinition TorsoDetails = UpperTorso.addOrReplaceChild("TorsoDetails", CubeListBuilder.create(), PartPose.offset(-0.8746F, -3.5678F, -2.8548F));

		PartDefinition FrontTumors = TorsoDetails.addOrReplaceChild("FrontTumors", CubeListBuilder.create(), PartPose.offset(-1.7515F, -1.7041F, 1.5805F));

		PartDefinition Tumor_r8 = FrontTumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(64, 18).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2365F, 1.3008F, 0.5037F));

		PartDefinition Tumor_r9 = FrontTumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(64, 18).addBox(-3.0F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6837F, 1.5787F, 0.7743F, -0.48F, 0.5672F, 0.0F));

		PartDefinition Tumor_r10 = FrontTumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(64, 18).addBox(-6.0F, -2.0F, -6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1837F, -4.4213F, -0.2257F, 0.4363F, 0.0F, 0.3927F));

		PartDefinition Tumor_r11 = FrontTumors.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(62, 16).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3487F, -2.795F, -1.1166F, -0.6921F, -0.5797F, 1.2857F));

		PartDefinition Tumor_r12 = FrontTumors.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(64, 18).addBox(-4.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1837F, 2.5787F, 0.7743F, 0.4363F, -0.3927F, 0.0F));

		PartDefinition Tumor_r13 = FrontTumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(60, 15).addBox(-6.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1837F, -0.4213F, -1.2257F, 0.5236F, -0.6545F, 0.0F));

		PartDefinition Tumor_r14 = FrontTumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(64, 18).addBox(-4.0F, 0.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1837F, 5.5787F, 0.7743F, -0.4363F, -0.3927F, 0.0F));

		PartDefinition Tumor_r15 = FrontTumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(60, 15).addBox(-6.0F, 0.0F, -6.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1837F, -1.4213F, 0.7743F, 0.0F, -0.6981F, -1.0472F));

		PartDefinition BackTumors = TorsoDetails.addOrReplaceChild("BackTumors", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9367F, 3.2804F, 6.3241F, -0.2182F, 0.0F, 0.0F));

		PartDefinition Tumor_r16 = BackTumors.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(63, 17).addBox(-7.0F, -2.0F, -7.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.5276F, -0.6263F, 0.4446F, 0.8727F, -0.3927F, 0.0F));

		PartDefinition Tumor_r17 = BackTumors.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(63, 17).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.3534F, 3.158F, -1.4572F, 0.934F, 1.1195F, 1.7324F));

		PartDefinition Tumor_r18 = BackTumors.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(63, 17).addBox(-4.0F, -1.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.3765F, 0.5166F, -1.5805F, -0.2365F, 1.3008F, 0.5037F));

		PartDefinition Tumor_r19 = BackTumors.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(63, 21).addBox(1.0F, -5.0F, 4.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3072F, -0.0621F, -2.3548F, -0.48F, 0.5672F, 0.0F));

		PartDefinition Tumor_r20 = BackTumors.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(63, 21).addBox(0.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8072F, 5.9379F, -1.3548F, 0.4363F, 0.0F, 0.3927F));

		PartDefinition Tumor_r21 = BackTumors.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(63, 17).addBox(0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8072F, 2.6879F, -4.3548F, -0.272F, -0.4531F, 1.5514F));

		PartDefinition Tumor_r22 = BackTumors.addOrReplaceChild("Tumor_r22", CubeListBuilder.create().texOffs(63, 17).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5276F, -4.6263F, 0.4446F, 0.8727F, -0.3927F, 0.0F));

		PartDefinition Tumor_r23 = BackTumors.addOrReplaceChild("Tumor_r23", CubeListBuilder.create().texOffs(63, 17).addBox(-1.0F, -5.0F, 1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8072F, 0.9379F, -0.3548F, 0.5236F, -0.6545F, 0.0F));

		PartDefinition Tumor_r24 = BackTumors.addOrReplaceChild("Tumor_r24", CubeListBuilder.create().texOffs(63, 17).addBox(-3.0F, -5.0F, 0.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8072F, -4.0621F, -2.3548F, -0.4363F, -0.3927F, 0.0F));

		PartDefinition Tumor_r25 = BackTumors.addOrReplaceChild("Tumor_r25", CubeListBuilder.create().texOffs(63, 17).addBox(-3.0F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2204F, 0.1177F, 1.8717F, 0.0F, -0.6981F, -1.0472F));

		PartDefinition TorsoTendrils = TorsoDetails.addOrReplaceChild("TorsoTendrils", CubeListBuilder.create(), PartPose.offset(1.3746F, 2.3178F, 6.8548F));

		PartDefinition Tendril1 = TorsoTendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5311F, -3.0316F, 0.5803F, -1.1291F, 0.2755F, 0.0963F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -8.9634F, -0.0145F, 0.3897F, 0.05F, -0.8192F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, 0.0235F, -0.0368F, -1.484F));

		PartDefinition Tendril2 = TorsoTendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.574F, -0.6538F, 1.3838F, 1.1378F, 0.0718F, 2.478F));

		PartDefinition TendrilSegment_r6 = Tendril2.addOrReplaceChild("TendrilSegment_r6", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 6.9634F, -0.0145F, 0.0F, 0.0F, 0.829F));

		PartDefinition TendrilSegment_r7 = Seg2Tendril2.addOrReplaceChild("TendrilSegment_r7", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 6.3197F, -0.0142F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Tendril3 = TorsoTendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.854F, -6.6074F, -9.2841F, -1.0434F, -0.1532F, 0.9486F));

		PartDefinition TendrilSegment_r8 = Tendril3.addOrReplaceChild("TendrilSegment_r8", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0138F, 3.9634F, 0.0145F, -0.5672F, 0.0F, 0.0F));

		PartDefinition TendrilSegment_r9 = Seg2Tendril3.addOrReplaceChild("TendrilSegment_r9", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril4 = TorsoTendrils.addOrReplaceChild("Tendril4", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.2763F, -8.4261F, -0.7129F, -0.9388F, -0.1924F, 0.4975F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0138F, -6.9634F, -0.0145F, 0.3463F, -0.0447F, 1.0394F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0815F, -8.3197F, -0.0142F, -0.0346F, 0.0266F, 1.3085F));

		PartDefinition Tendril5 = TorsoTendrils.addOrReplaceChild("Tendril5", CubeListBuilder.create().texOffs(46, 129).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9097F, 1.7182F, -4.656F, -2.4616F, -0.2175F, -0.9199F));

		PartDefinition Seg2Tendril5 = Tendril5.addOrReplaceChild("Seg2Tendril5", CubeListBuilder.create().texOffs(16, 129).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0138F, -8.9634F, -0.0145F, 0.0F, 0.0F, 1.0472F));

		PartDefinition Seg3Tendril5 = Seg2Tendril5.addOrReplaceChild("Seg3Tendril5", CubeListBuilder.create().texOffs(40, 138).addBox(-0.5F, -9.25F, -0.5F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0815F, -8.3197F, -0.0142F, -0.0435F, 0.0038F, -0.5673F));

		PartDefinition Pilot = UpperTorso.addOrReplaceChild("Pilot", CubeListBuilder.create().texOffs(0, 46).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1273F, -7.922F, 0.5052F, 0.2498F, 0.0457F, 0.3692F));

		PartDefinition PilotHead = Pilot.addOrReplaceChild("PilotHead", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(56, 0).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(37, 5).addBox(-4.0F, -1.0F, 1.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0366F, -6.2145F, -0.8769F, -0.8072F, -0.0593F, -0.2832F));

		PartDefinition Jaw = PilotHead.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(50, 107).addBox(-4.0F, -0.5F, -5.5F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 1.5F, 0.4363F, 0.0F, 0.0F));

		PartDefinition crown1 = PilotHead.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6513F, -8.1195F, 0.2008F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Petal4_r5 = crown1.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(-7, 75).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r5 = crown1.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(-7, 75).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r4 = crown1.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(-7, 75).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = crown1.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(-7, 82).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2969F, 0.3356F, 0.5792F, 0.4726F, -0.2047F, -0.1036F));

		PartDefinition PilotArm = Pilot.addOrReplaceChild("PilotArm", CubeListBuilder.create().texOffs(0, 120).addBox(-3.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8198F, -3.8094F, 0.3172F, -1.7316F, 0.4816F, -0.494F));

		PartDefinition PilotArmSeg2 = PilotArm.addOrReplaceChild("PilotArmSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 4.5F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Arm_r1 = PilotArmSeg2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(0, 120).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 3.1416F, -0.0436F, 0.0F));

		PartDefinition StuckArm = Pilot.addOrReplaceChild("StuckArm", CubeListBuilder.create().texOffs(0, 120).addBox(-1.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4849F, -6.2556F, 0.4466F, -0.2618F, 0.0F, -0.3927F));

		PartDefinition Dispenser = UpperTorso.addOrReplaceChild("Dispenser", CubeListBuilder.create(), PartPose.offset(6.0F, -10.0F, -2.0F));

		PartDefinition cube_r1 = Dispenser.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(192, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 0.0F, -0.6545F, 0.1309F, -0.1309F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float headX = headPitch /  ( 90F / (float) Math.PI);
		float headY = netHeadYaw / (180F / (float) Math.PI);
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.LeftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		animateTumor(LeftLegTumor,Mth.sin(ageInTicks/8)/9);
		animateTumor(RightArmBigTumor,Mth.sin(ageInTicks/6)/7);
		animateTumor(RightArmTentacle,Mth.cos(ageInTicks/7)/8);
		animateTumor(BodyTentacle1,Mth.cos(ageInTicks/7)/12);
		animateTumor(BodyTentacle2,Mth.sin(ageInTicks/7)/12);
		animateTumor(BodyTentacle3,Mth.cos(ageInTicks/6)/10);
		animateTumor(BodyTumor1,Mth.cos(ageInTicks/7)/10);
		animateTumor(BodyTumor2,Mth.sin(ageInTicks/6)/9);
		animateTentacleZ(RightLegTendril1,Mth.cos(ageInTicks/6)/4);
		animateTentacleZ(RightLegTendril2,Mth.cos(ageInTicks/5)/4);
		animateTentacleZ(RightLegTendril3,Mth.cos(ageInTicks/6)/3);
		animateTentacleX(LeftForTendril11,Mth.cos(ageInTicks/6)/4);
		animateTentacleX(LeftForTendril12,Mth.cos(ageInTicks/6)/4);
		animateTentacleZ(LeftForTendril13,Mth.cos(ageInTicks/6)/4);
		animateTentacleX(LeftForTendril21,Mth.cos(ageInTicks/5)/4);
		animateTentacleX(LeftForTendril22,Mth.cos(ageInTicks/5)/4);
		animateTentacleX(LeftForTendril23,Mth.cos(ageInTicks/5)/4);
		animateTentacleX(RightArmTendril1,Mth.sin(ageInTicks/5)/4);
		animateTentacleX(RightArmTendril2,Mth.sin(ageInTicks/5)/4);
		animateTentacleX(RightArmTendril3,Mth.sin(ageInTicks/5)/4);
		animateTentacleZ(RightArmTendril21,Mth.cos(ageInTicks/5)/4);
		animateTentacleZ(RightArmTendril22,Mth.cos(ageInTicks/5)/4);
		animateTentacleZ(RightArmTendril23,Mth.cos(ageInTicks/5)/4);
		animateTentacleX(BodyTendril11,Mth.cos(ageInTicks/4)/3);
		animateTentacleX(BodyTendril12,Mth.cos(ageInTicks/4)/3);
		animateTentacleZ(BodyTendril13,Mth.cos(ageInTicks/4)/3);
		animateTentacleZ(BodyTendril21,Mth.sin(ageInTicks/7)/2);
		animateTentacleZ(BodyTendril22,-Mth.sin(ageInTicks/7)/2);
		animateTentacleZ(BodyTendril23,-Mth.sin(ageInTicks/7)/2);
		this.PilotArm.yRot = PilotArm.getInitialPose().yRot + Mth.sin(ageInTicks/7)/4;
		this.Head.xRot = Head.getInitialPose().xRot + headX;
		this.Head.yRot = headY/2;
		this.Torso.yRot = headY/2;
		this.Jaw.xRot = Jaw.getInitialPose().xRot +Mth.cos(ageInTicks/6)/6;
		this.Dispenser.visible = entity.isDispenser();

		if (entity.getAttackAnimationTick() <= 0){
			this.LeftArm.xRot = Mth.cos(ageInTicks/6)/5;
			this.RightArm.xRot = -Mth.cos(ageInTicks/6)/7;
			this.LeftForArm.xRot = LeftArm.xRot;
			this.LeftForArm1.xRot = LeftForArm.xRot;
			this.RightForArm.xRot = RightArm.xRot;
		}
	}

	@Override
	public void prepareMobModel(T entity, float value1, float value2, float value3) {
		super.prepareMobModel(entity, value1, value2, value3);
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			this.LeftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick - value3, 10.0F);
			this.RightArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick - value3, 10.0F);
			this.LeftForArm.xRot = LeftArm.xRot/2;
			this.RightForArm.xRot = RightArm.xRot/2;
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Infgolem.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

}