package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.UmarmerAnimations;
import com.Harbinger.Spore.Sentities.Organoids.Umarmer;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class UmarmerModel<T extends Umarmer> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "umarmermodel"), "main");
	private final ModelPart Tendril_organoid1;

	public UmarmerModel(ModelPart root) {
		this.Tendril_organoid1 = root.getChild("Tendril_organoid1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Tendril_organoid1 = partdefinition.addOrReplaceChild("Tendril_organoid1", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Base = Tendril_organoid1.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass = Base.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition Biomass1 = Biomass.addOrReplaceChild("Biomass1", CubeListBuilder.create(), PartPose.offset(2.3542F, -0.2937F, 3.027F));

		PartDefinition Biomass1_r1 = Biomass1.addOrReplaceChild("Biomass1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition Biomass2 = Biomass.addOrReplaceChild("Biomass2", CubeListBuilder.create(), PartPose.offset(-3.1751F, 0.8348F, -5.0114F));

		PartDefinition Biomass2_r1 = Biomass2.addOrReplaceChild("Biomass2_r1", CubeListBuilder.create().texOffs(8, 3).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Biomass3 = Biomass.addOrReplaceChild("Biomass3", CubeListBuilder.create(), PartPose.offset(3.1001F, -0.1047F, -4.2458F));

		PartDefinition Biomass3_r1 = Biomass3.addOrReplaceChild("Biomass3_r1", CubeListBuilder.create().texOffs(2, 2).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Biomass4 = Biomass.addOrReplaceChild("Biomass4", CubeListBuilder.create(), PartPose.offset(-4.7827F, -0.213F, 1.9315F));

		PartDefinition Biomass4_r1 = Biomass4.addOrReplaceChild("Biomass4_r1", CubeListBuilder.create().texOffs(8, 4).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition BiomassCrown1 = Biomass.addOrReplaceChild("BiomassCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -4.0F, 6.0F, -0.7403F, 0.0368F, 0.0791F));

		PartDefinition Petal4_r1 = BiomassCrown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(66, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = BiomassCrown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(78, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4226F, -0.0937F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Petal2_r1 = BiomassCrown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5774F, -3.0937F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = BiomassCrown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(66, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9659F, -0.9774F, 3.7422F, 0.0903F, -0.2608F, -0.0233F));

		PartDefinition BiomassCrown2 = Biomass.addOrReplaceChild("BiomassCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, -2.0F, -7.0F, 0.5875F, -0.911F, 0.4753F));

		PartDefinition Petal5_r1 = BiomassCrown2.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(66, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Petal3_r2 = BiomassCrown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4226F, -0.0937F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition Petal2_r2 = BiomassCrown2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(78, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, -0.4349F, -0.0368F, -0.0791F));

		PartDefinition Petal1_r2 = BiomassCrown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(66, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3047F, -1.6687F, 2.8397F, 0.425F, -0.2381F, -0.1135F));

		PartDefinition tendril = Base.addOrReplaceChild("tendril", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tendrilbase = tendril.addOrReplaceChild("tendrilbase", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Human1 = tendrilbase.addOrReplaceChild("Human1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition H1Torso = Human1.addOrReplaceChild("H1Torso", CubeListBuilder.create().texOffs(11, 6).addBox(-3.5F, -0.0829F, -1.5297F, 7.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, -8.9171F, -0.4703F));

		PartDefinition H1TorsoTop_r1 = H1Torso.addOrReplaceChild("H1TorsoTop_r1", CubeListBuilder.create().texOffs(49, 65).addBox(-4.0F, -5.75F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.1671F, 0.4703F, 0.3491F, 0.0F, 0.0F));

		PartDefinition H1Head = H1Torso.addOrReplaceChild("H1Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.4934F, -2.7129F, 0.829F, 0.0F, 0.0F));

		PartDefinition H1HeadBase_r1 = H1Head.addOrReplaceChild("H1HeadBase_r1", CubeListBuilder.create().texOffs(24, 48).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, -1.5775F, -2.0328F, 1.7017F, 0.0F, 0.0F));

		PartDefinition H1Jaw = H1Head.addOrReplaceChild("H1Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -1.5386F, 1.5025F));

		PartDefinition H1Jaw_r1 = H1Jaw.addOrReplaceChild("H1Jaw_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-3.99F, -1.25F, -2.0F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition HeadDetials = H1Head.addOrReplaceChild("HeadDetials", CubeListBuilder.create(), PartPose.offset(0.1816F, -5.5966F, -2.8147F));

		PartDefinition fungalpetal_r1 = HeadDetials.addOrReplaceChild("fungalpetal_r1", CubeListBuilder.create().texOffs(72, 81).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7334F, -0.0381F, -1.7518F, 0.4001F, 0.344F, -0.4875F));

		PartDefinition fungalpetal_r2 = HeadDetials.addOrReplaceChild("fungalpetal_r2", CubeListBuilder.create().texOffs(84, 81).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9328F, -0.3511F, 1.1224F, 0.0031F, 0.2906F, -0.3617F));

		PartDefinition fungalpetal_r3 = HeadDetials.addOrReplaceChild("fungalpetal_r3", CubeListBuilder.create().texOffs(84, 81).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3934F, -0.1474F, -1.1853F, 0.1731F, -0.0227F, 0.478F));

		PartDefinition fungalpetal_r4 = HeadDetials.addOrReplaceChild("fungalpetal_r4", CubeListBuilder.create().texOffs(84, 81).addBox(-3.0F, -3.0F, 0.0F, 6.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2728F, 0.5366F, 1.8147F, -2.7137F, -0.7863F, -2.885F));

		PartDefinition H1Arms = Human1.addOrReplaceChild("H1Arms", CubeListBuilder.create(), PartPose.offset(4.0F, -13.25F, -1.25F));

		PartDefinition H1ArmLeft_r1 = H1Arms.addOrReplaceChild("H1ArmLeft_r1", CubeListBuilder.create().texOffs(105, 64).mirror().addBox(-0.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0869F, 0.0076F, -0.044F));

		PartDefinition Human2 = Human1.addOrReplaceChild("Human2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -14.0F, -3.1F, -0.5236F, 0.0F, 0.0F));

		PartDefinition H2Torso = Human2.addOrReplaceChild("H2Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

		PartDefinition H2TorsoBase_r1 = H2Torso.addOrReplaceChild("H2TorsoBase_r1", CubeListBuilder.create().texOffs(51, 66).addBox(-3.5F, -5.0F, -1.75F, 7.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition H2TorsoTop_r1 = H2Torso.addOrReplaceChild("H2TorsoTop_r1", CubeListBuilder.create().texOffs(23, 65).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -4.1127F, -0.1962F, -0.6545F, 0.0F, 0.0F));

		PartDefinition H2Details = H2Torso.addOrReplaceChild("H2Details", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0446F, 4.6529F));

		PartDefinition FleshBloodPlane_r1 = H2Details.addOrReplaceChild("FleshBloodPlane_r1", CubeListBuilder.create().texOffs(66, 41).addBox(-3.5F, 0.5F, -1.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9554F, -0.6529F, -1.0036F, 0.0F, 0.0F));

		PartDefinition H2Arms = Human2.addOrReplaceChild("H2Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.225F, -5.1738F, 3.4469F, 0.6545F, 0.0F, 0.0F));

		PartDefinition H2ArmLeft_r1 = H2Arms.addOrReplaceChild("H2ArmLeft_r1", CubeListBuilder.create().texOffs(105, 64).addBox(-1.5F, -0.75F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1961F, 0.7586F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Human3 = Human2.addOrReplaceChild("Human3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 3.5F, 3.098F, 0.0F, 3.1416F));

		PartDefinition H3Torso = Human3.addOrReplaceChild("H3Torso", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition H3TorsoBase_r1 = H3Torso.addOrReplaceChild("H3TorsoBase_r1", CubeListBuilder.create().texOffs(32, 76).addBox(-3.5F, -1.5F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.4013F, -0.6287F, 0.2182F, 0.0F, 0.0F));

		PartDefinition H3TorsoTop_r1 = H3Torso.addOrReplaceChild("H3TorsoTop_r1", CubeListBuilder.create().texOffs(23, 65).addBox(-4.0F, -4.5256F, -1.4318F, 8.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -6.1127F, -0.6962F, -0.6545F, 0.0F, 0.0F));

		PartDefinition TorsoDetials = H3Torso.addOrReplaceChild("TorsoDetials", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, -1.5F));

		PartDefinition Tumor_r1 = TorsoDetials.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(12, 4).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1344F, -2.3207F, -0.3019F, -1.5965F, 0.1594F, 2.6437F));

		PartDefinition Tumor_r2 = TorsoDetials.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(16, 15).addBox(-2.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4712F, -0.9115F, 3.7969F, -0.4273F, -0.8086F, 1.3876F));

		PartDefinition Tumor_r3 = TorsoDetials.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(12, 9).addBox(-3.0F, -3.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 3.0F, -0.3724F, -0.4353F, 0.3008F));

		PartDefinition H3Head = H3Torso.addOrReplaceChild("H3Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -9.4105F, 3.3168F, -2.0944F, 0.0F, 0.0F));

		PartDefinition H3HeadSide_r1 = H3Head.addOrReplaceChild("H3HeadSide_r1", CubeListBuilder.create().texOffs(67, 68).addBox(0.7849F, -1.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(-0.6F))
		.texOffs(52, 40).addBox(-4.0F, -2.5F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(3.9251F, -0.8991F, 1.1726F, 1.7475F, -0.734F, -0.119F));

		PartDefinition H3Jaw = H3Head.addOrReplaceChild("H3Jaw", CubeListBuilder.create(), PartPose.offset(1.7294F, 1.7624F, 3.9399F));

		PartDefinition H3Jaw_r1 = H3Jaw.addOrReplaceChild("H3Jaw_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-4.0F, -0.75F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.3984F, -0.734F, -0.119F));

		PartDefinition mouthtendrils = H3Head.addOrReplaceChild("mouthtendrils", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition mouthtendril1 = mouthtendrils.addOrReplaceChild("mouthtendril1", CubeListBuilder.create(), PartPose.offset(0.0F, 30.4105F, -1.8168F));

		PartDefinition MT1 = mouthtendril1.addOrReplaceChild("MT1", CubeListBuilder.create(), PartPose.offset(1.0F, -31.4105F, 4.8168F));

		PartDefinition MT1Seg1_r1 = MT1.addOrReplaceChild("MT1Seg1_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.9537F, -1.5F, -0.3007F, -0.1745F, -0.3054F, 0.0F));

		PartDefinition MT1Seg2 = MT1.addOrReplaceChild("MT1Seg2", CubeListBuilder.create(), PartPose.offset(-1.0059F, -2.4848F, -0.1351F));

		PartDefinition MT1Seg2_r1 = MT1Seg2.addOrReplaceChild("MT1Seg2_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -3.2F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5236F, -0.3054F, 0.0F));

		PartDefinition MT2 = mouthtendril1.addOrReplaceChild("MT2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1574F, -34.0524F, 5.2065F, 0.0F, -2.3126F, 0.0F));

		PartDefinition MT2Seg1_r1 = MT2.addOrReplaceChild("MT2Seg1_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1389F, 1.1419F, -0.4404F, -0.1745F, -0.3054F, 0.0F));

		PartDefinition MT2Seg2 = MT2.addOrReplaceChild("MT2Seg2", CubeListBuilder.create(), PartPose.offset(0.0867F, 0.1571F, -0.2748F));

		PartDefinition MT2Seg2_r1 = MT2Seg2.addOrReplaceChild("MT2Seg2_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -3.15F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5455F, -0.261F, 0.0782F));

		PartDefinition MT3 = mouthtendril1.addOrReplaceChild("MT3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4074F, -33.8024F, 6.7065F, 2.9543F, -0.8126F, -2.8863F));

		PartDefinition MT2Seg2_r2 = MT3.addOrReplaceChild("MT2Seg2_r2", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.1389F, 1.1419F, -0.4404F, -0.1745F, -0.3054F, 0.0F));

		PartDefinition MT3Seg3 = MT3.addOrReplaceChild("MT3Seg3", CubeListBuilder.create(), PartPose.offset(0.0867F, 0.1571F, -0.2748F));

		PartDefinition MT3Seg3_r1 = MT3Seg3.addOrReplaceChild("MT3Seg3_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.0F, -3.3F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4521F, -0.4435F, -0.5447F));

		PartDefinition H3Arms = Human3.addOrReplaceChild("H3Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -6.5582F, 1.211F, 0.5236F, 0.0F, 0.0F));

		PartDefinition H3ArmRight_r1 = H3Arms.addOrReplaceChild("H3ArmRight_r1", CubeListBuilder.create().texOffs(26, 103).addBox(-2.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition Human4 = Human3.addOrReplaceChild("Human4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, 2.5F, 3.0547F, 0.0076F, -3.0547F));

		PartDefinition H4Torso = Human4.addOrReplaceChild("H4Torso", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, 0.0F, 0.5F, 0.5087F, -0.1298F, 0.228F));

		PartDefinition H4TorsoBase_r1 = H4Torso.addOrReplaceChild("H4TorsoBase_r1", CubeListBuilder.create().texOffs(33, 76).addBox(-3.0F, -2.5F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.6415F, -1.4369F, -0.0765F, 0.48F, 0.0F, 0.0F));

		PartDefinition H4TorsoTop_r1 = H4Torso.addOrReplaceChild("H4TorsoTop_r1", CubeListBuilder.create().texOffs(75, 49).addBox(-3.6F, -6.5F, -2.0F, 7.0F, 6.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.7415F, -2.7851F, -0.8916F, 0.48F, 0.0F, 0.0F));

		PartDefinition H4Head = H4Torso.addOrReplaceChild("H4Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6634F, -1.8563F, 3.7133F, -1.7929F, 0.4361F, -0.8527F));

		PartDefinition H4HeadBase_r1 = H4Head.addOrReplaceChild("H4HeadBase_r1", CubeListBuilder.create().texOffs(0, 40).addBox(-4.1866F, -2.3462F, -1.8405F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(1.5118F, 2.3039F, -1.0821F, 1.7475F, -0.734F, -0.119F));

		PartDefinition H4Jaw = H4Head.addOrReplaceChild("H4Jaw", CubeListBuilder.create(), PartPose.offset(-0.9206F, 1.8007F, 1.2504F));

		PartDefinition H4Jaw_r1 = H4Jaw.addOrReplaceChild("H4Jaw_r1", CubeListBuilder.create().texOffs(48, 55).addBox(-3.9998F, -1.0F, -2.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0494F, -0.734F, -0.119F));

		PartDefinition Tumors = H4Head.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(-1.4497F, -0.9473F, 0.9794F));

		PartDefinition Tumor1 = Tumors.addOrReplaceChild("Tumor1", CubeListBuilder.create(), PartPose.offset(1.1899F, 0.4286F, 0.7286F));

		PartDefinition Tumor_r4 = Tumor1.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(18, 14).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0673F, -0.5569F, 0.0474F));

		PartDefinition Tumor2 = Tumors.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offset(-0.595F, 0.5068F, -1.3431F));

		PartDefinition Tumor_r5 = Tumor2.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(21, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3915F, -0.1004F, 1.1082F));

		PartDefinition Tumor3 = Tumors.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offset(-0.5949F, -0.9355F, 0.6145F));

		PartDefinition Tumor_r6 = Tumor3.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(14, 4).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5641F, 0.2032F, 0.5414F));

		PartDefinition H4Arms = Human4.addOrReplaceChild("H4Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0508F, -4.392F, -4.3234F, 0.5236F, 0.0F, 0.0F));

		PartDefinition H4ArmRight_r1 = H4Arms.addOrReplaceChild("H4ArmRight_r1", CubeListBuilder.create().texOffs(26, 103).addBox(-2.8F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.8952F, -1.4062F, 0.3473F, -0.1745F, 0.0F, 0.3491F));

		PartDefinition Human5NoPivot = Human4.addOrReplaceChild("Human5NoPivot", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -8.0F, -1.0F, 1.4137F, 0.3678F, 3.0009F));

		PartDefinition H5Torso = Human5NoPivot.addOrReplaceChild("H5Torso", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -5.25F, 2.25F, 0.5068F, 0.0993F, 0.355F));

		PartDefinition H5TorsoTop_r1 = H5Torso.addOrReplaceChild("H5TorsoTop_r1", CubeListBuilder.create().texOffs(68, 16).addBox(-4.0F, -4.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2415F, -6.9777F, -0.2043F, -0.2618F, 0.0F, 0.0F));

		PartDefinition H5TorsoBase_r1 = H5Torso.addOrReplaceChild("H5TorsoBase_r1", CubeListBuilder.create().texOffs(20, 95).addBox(-3.5F, -2.5F, -1.5F, 7.0F, 5.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2415F, -1.9685F, -0.4241F, 0.2182F, 0.0F, 0.0F));

		PartDefinition H5TorsoLeft = H5Torso.addOrReplaceChild("H5TorsoLeft", CubeListBuilder.create(), PartPose.offset(-3.2415F, -5.3389F, 2.0483F));

		PartDefinition H5TorsoLeft_r1 = H5TorsoLeft.addOrReplaceChild("H5TorsoLeft_r1", CubeListBuilder.create().texOffs(0, 88).addBox(-2.0F, -4.9111F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3076F, -1.1168F, 0.1634F));

		PartDefinition H5TorsoRight = H5Torso.addOrReplaceChild("H5TorsoRight", CubeListBuilder.create(), PartPose.offset(3.3626F, -5.4683F, 1.1165F));

		PartDefinition H5TorsoRight_r1 = H5TorsoRight.addOrReplaceChild("H5TorsoRight_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5288F, 1.1168F, -0.3453F));

		PartDefinition TorsoDetails = H5Torso.addOrReplaceChild("TorsoDetails", CubeListBuilder.create(), PartPose.offset(0.0F, -7.25F, 2.0F));

		PartDefinition tendril1 = TorsoDetails.addOrReplaceChild("tendril1", CubeListBuilder.create(), PartPose.offset(-1.1692F, -0.5473F, -0.1867F));

		PartDefinition Tendril1Seg1_r1 = tendril1.addOrReplaceChild("Tendril1Seg1_r1", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0653F, -0.6126F, -0.1785F, -0.1309F, 0.0F, 0.5672F));

		PartDefinition Tendril1Seg2 = tendril1.addOrReplaceChild("Tendril1Seg2", CubeListBuilder.create(), PartPose.offset(-0.0483F, -0.2535F, 1.8276F));

		PartDefinition Tendril1Seg2_r1 = Tendril1Seg2.addOrReplaceChild("Tendril1Seg2_r1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.1F, -1.1F, -0.95F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5642F, 0.1776F, 0.1189F));

		PartDefinition tendril2 = TorsoDetails.addOrReplaceChild("tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.964F, 2.4873F, -0.5694F, 0.0F, 0.0F, 1.3963F));

		PartDefinition Tendril2Seg1_r1 = tendril2.addOrReplaceChild("Tendril2Seg1_r1", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.2204F, -0.4159F, -0.2958F, -0.1309F, 0.0F, 0.5672F));

		PartDefinition Tendril2Seg2 = tendril2.addOrReplaceChild("Tendril2Seg2", CubeListBuilder.create(), PartPose.offset(-0.3339F, -0.0568F, 1.7103F));

		PartDefinition Tendril2Seg2_r1 = Tendril2Seg2.addOrReplaceChild("Tendril2Seg2_r1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.0F, -1.0F, -0.75F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.297F, 0.3091F, 1.3145F));

		PartDefinition tendril3 = TorsoDetails.addOrReplaceChild("tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7035F, -0.7048F, -0.5391F, 0.2704F, -0.4881F, 1.6075F));

		PartDefinition Tendril3Seg1_r1 = tendril3.addOrReplaceChild("Tendril3Seg1_r1", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.5486F, -0.0979F, -0.1867F, -0.1309F, 0.0F, 0.5672F));

		PartDefinition Tendril3Seg2 = tendril3.addOrReplaceChild("Tendril3Seg2", CubeListBuilder.create(), PartPose.offset(0.4351F, 0.2612F, 1.8193F));

		PartDefinition Tendril3Seg2_r1 = Tendril3Seg2.addOrReplaceChild("Tendril3Seg2_r1", CubeListBuilder.create().texOffs(27, 24).addBox(-1.25F, -1.0F, -0.75F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6867F, 0.1617F, 1.8025F));

		PartDefinition tendril4 = TorsoDetails.addOrReplaceChild("tendril4", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1418F, 2.1683F, -0.7908F, -0.0739F, 0.2976F, 0.6146F));

		PartDefinition Tendril3Seg2_r2 = tendril4.addOrReplaceChild("Tendril3Seg2_r2", CubeListBuilder.create().texOffs(69, 0).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.3078F, -0.2621F, -0.0837F, -0.1309F, 0.0F, 0.5672F));

		PartDefinition Tendril4Seg3 = tendril4.addOrReplaceChild("Tendril4Seg3", CubeListBuilder.create(), PartPose.offset(-0.2801F, -0.1624F, 1.7282F));

		PartDefinition Tendril3Seg3_r1 = Tendril4Seg3.addOrReplaceChild("Tendril3Seg3_r1", CubeListBuilder.create().texOffs(27, 24).addBox(-0.9F, -1.0F, -0.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1914F, 0.2726F, 1.8998F));

		PartDefinition H5Tumors = TorsoDetails.addOrReplaceChild("H5Tumors", CubeListBuilder.create(), PartPose.offset(-0.3923F, -0.2305F, -3.7224F));

		PartDefinition Tumor_r7 = H5Tumors.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(0, 12).addBox(-3.0F, -0.5F, -1.75F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3923F, -0.7695F, -0.2776F, 0.0928F, -0.3477F, -0.8171F));

		PartDefinition Tumor_r8 = H5Tumors.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(24, 8).addBox(-1.75F, -1.5F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7088F, -1.0852F, -0.3011F, 0.0379F, 0.3429F, -1.5276F));

		PartDefinition H5Petals = TorsoDetails.addOrReplaceChild("H5Petals", CubeListBuilder.create(), PartPose.offset(-0.2353F, -0.1943F, -4.6712F));

		PartDefinition Petal3_r3 = H5Petals.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(78, 81).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7672F, -1.8206F, 1.0918F, 1.0508F, 0.64F, 2.3037F));

		PartDefinition Petal2_r3 = H5Petals.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8515F, -0.954F, -0.2222F, 0.9873F, -0.3052F, -2.1708F));

		PartDefinition Petal1_r3 = H5Petals.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(66, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0843F, 2.7746F, -0.8696F, 0.3927F, 0.4363F, 0.0F));

		PartDefinition Rib = H5Torso.addOrReplaceChild("Rib", CubeListBuilder.create(), PartPose.offset(0.0F, -5.25F, 2.0F));

		PartDefinition Rib1 = Rib.addOrReplaceChild("Rib1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -3.5F, -0.5F, 0.1728F, 0.478F, -0.0983F));

		PartDefinition Rib1Seg1 = Rib1.addOrReplaceChild("Rib1Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib1Seg1_r1 = Rib1Seg1.addOrReplaceChild("Rib1Seg1_r1", CubeListBuilder.create().texOffs(21, 78).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Rib1Seg2 = Rib1Seg1.addOrReplaceChild("Rib1Seg2", CubeListBuilder.create(), PartPose.offset(2.55F, 0.0F, 4.4167F));

		PartDefinition Rib1Seg2_r1 = Rib1Seg2.addOrReplaceChild("Rib1Seg2_r1", CubeListBuilder.create().texOffs(2, 102).addBox(-1.0F, -1.01F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Rib1Seg3 = Rib1Seg2.addOrReplaceChild("Rib1Seg3", CubeListBuilder.create(), PartPose.offset(2.6517F, 0.0F, 2.6517F));

		PartDefinition Rib1Seg3_r1 = Rib1Seg3.addOrReplaceChild("Rib1Seg3_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -1.0F, -0.2F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Rib2 = Rib.addOrReplaceChild("Rib2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -1.5F, -0.5F, -0.0305F, 0.1934F, 0.2385F));

		PartDefinition Rib2Seg1 = Rib2.addOrReplaceChild("Rib2Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0981F));

		PartDefinition Rib2Seg1_r1 = Rib2Seg1.addOrReplaceChild("Rib2Seg1_r1", CubeListBuilder.create().texOffs(19, 76).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.0981F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Rib2Details = Rib2Seg1.addOrReplaceChild("Rib2Details", CubeListBuilder.create(), PartPose.offset(2.4945F, -0.3569F, 4.2241F));

		PartDefinition Tumor2_r1 = Rib2Details.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(15, 9).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.356F, 0.4453F, 1.2575F, 2.2919F, -0.7434F, -3.0193F));

		PartDefinition Tumor1_r1 = Rib2Details.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(18, 14).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.356F, -0.4453F, -1.2575F, 2.8593F, -0.3786F, 2.6375F));

		PartDefinition Rib2Seg2 = Rib2Seg1.addOrReplaceChild("Rib2Seg2", CubeListBuilder.create(), PartPose.offset(3.05F, 0.0F, 5.8187F));

		PartDefinition Rib2Seg2_r1 = Rib2Seg2.addOrReplaceChild("Rib2Seg2_r1", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -0.99F, 0.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2217F, 0.0F));

		PartDefinition Rib2Seg3 = Rib2Seg2.addOrReplaceChild("Rib2Seg3", CubeListBuilder.create(), PartPose.offset(5.1983F, -0.01F, 1.528F));

		PartDefinition Rib2Seg3_r1 = Rib2Seg3.addOrReplaceChild("Rib2Seg3_r1", CubeListBuilder.create().texOffs(73, 111).addBox(-0.966F, -1.0F, -0.2412F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.25F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Rib3 = Rib.addOrReplaceChild("Rib3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.5F, -0.5F, -0.1508F, 0.1416F, 0.0638F));

		PartDefinition Rib3Seg1 = Rib3.addOrReplaceChild("Rib3Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib3Seg1_r1 = Rib3Seg1.addOrReplaceChild("Rib3Seg1_r1", CubeListBuilder.create().texOffs(22, 79).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Rib3Seg2 = Rib3Seg1.addOrReplaceChild("Rib3Seg2", CubeListBuilder.create(), PartPose.offset(1.8547F, 0.01F, 3.3533F));

		PartDefinition Rib3Seg2_r1 = Rib3Seg2.addOrReplaceChild("Rib3Seg2_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.2217F, 0.0F));

		PartDefinition Rib3Seg3 = Rib3Seg2.addOrReplaceChild("Rib3Seg3", CubeListBuilder.create(), PartPose.offset(6.8331F, -0.02F, 2.9348F));

		PartDefinition Rib3Seg3_r1 = Rib3Seg3.addOrReplaceChild("Rib3Seg3_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Rib4 = Rib.addOrReplaceChild("Rib4", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -4.0F, -0.5F, 0.1745F, -0.7854F, 0.0F));

		PartDefinition Rib4Seg1 = Rib4.addOrReplaceChild("Rib4Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib4Seg1_r1 = Rib4Seg1.addOrReplaceChild("Rib4Seg1_r1", CubeListBuilder.create().texOffs(21, 78).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 7.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Rib4Seg2 = Rib4Seg1.addOrReplaceChild("Rib4Seg2", CubeListBuilder.create(), PartPose.offset(-2.55F, 0.0F, 4.4167F));

		PartDefinition Rib4Seg2_r1 = Rib4Seg2.addOrReplaceChild("Rib4Seg2_r1", CubeListBuilder.create().texOffs(2, 102).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0124F, 0.1392F, -0.011F));

		PartDefinition Rib4Seg3 = Rib4Seg2.addOrReplaceChild("Rib4Seg3", CubeListBuilder.create(), PartPose.offset(0.6153F, -0.01F, 3.9034F));

		PartDefinition Rib4Seg3_r1 = Rib4Seg3.addOrReplaceChild("Rib4Seg3_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -1.0F, -0.35F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0873F, 0.0F));

		PartDefinition Rib4Details = Rib4Seg3.addOrReplaceChild("Rib4Details", CubeListBuilder.create().texOffs(96, 80).addBox(-0.2229F, -2.0987F, -1.6774F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.314F, 0.1336F, 2.3573F, 0.0F, 0.0F, -0.5236F));

		PartDefinition FungalFan3_r1 = Rib4Details.addOrReplaceChild("FungalFan3_r1", CubeListBuilder.create().texOffs(96, 80).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(-0.7433F, 0.0152F, 1.558F, -0.4385F, 0.1739F, 1.3605F));

		PartDefinition FungalFan2_r1 = Rib4Details.addOrReplaceChild("FungalFan2_r1", CubeListBuilder.create().texOffs(96, 80).addBox(-1.5F, 0.25F, -2.25F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(1.2771F, -0.5987F, 0.8226F, 0.2622F, 0.2332F, 0.8599F));

		PartDefinition Rib5 = Rib.addOrReplaceChild("Rib5", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -2.25F, -0.5F, -0.0801F, -0.1789F, 0.0275F));

		PartDefinition Rib5Seg1 = Rib5.addOrReplaceChild("Rib5Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib5Seg1_r1 = Rib5Seg1.addOrReplaceChild("Rib5Seg1_r1", CubeListBuilder.create().texOffs(23, 80).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Rib5Seg2 = Rib5Seg1.addOrReplaceChild("Rib5Seg2", CubeListBuilder.create(), PartPose.offset(-1.6367F, 0.01F, 2.6992F));

		PartDefinition Rib5Seg2_r1 = Rib5Seg2.addOrReplaceChild("Rib5Seg2_r1", CubeListBuilder.create().texOffs(2, 92).addBox(-1.0F, -1.0F, -0.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5272F, 0.0F));

		PartDefinition Rib5Seg3 = Rib5Seg2.addOrReplaceChild("Rib5Seg3", CubeListBuilder.create(), PartPose.offset(-5.3529F, -0.02F, 0.5364F));

		PartDefinition Rib5Seg3_r1 = Rib5Seg3.addOrReplaceChild("Rib5Seg3_r1", CubeListBuilder.create().texOffs(0, 100).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition Rib5Seg4 = Rib5Seg3.addOrReplaceChild("Rib5Seg4", CubeListBuilder.create(), PartPose.offset(-0.8248F, 0.0F, 4.6778F));

		PartDefinition Rib5Seg4_r1 = Rib5Seg4.addOrReplaceChild("Rib5Seg4_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -0.99F, -0.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Rib6 = Rib.addOrReplaceChild("Rib6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -0.5F, -0.5F, -0.1508F, -0.1416F, -0.0638F));

		PartDefinition Rib6Seg1 = Rib6.addOrReplaceChild("Rib6Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib6Seg1_r1 = Rib6Seg1.addOrReplaceChild("Rib6Seg1_r1", CubeListBuilder.create().texOffs(22, 79).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Rib6Seg2 = Rib6Seg1.addOrReplaceChild("Rib6Seg2", CubeListBuilder.create(), PartPose.offset(-1.8547F, 0.01F, 3.3533F));

		PartDefinition Rib6Seg2_r1 = Rib6Seg2.addOrReplaceChild("Rib6Seg2_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));

		PartDefinition Rib6Seg3 = Rib6Seg2.addOrReplaceChild("Rib6Seg3", CubeListBuilder.create(), PartPose.offset(-6.8331F, -0.02F, 2.9348F));

		PartDefinition Rib6Seg3_r1 = Rib6Seg3.addOrReplaceChild("Rib6Seg3_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Rib7 = Rib.addOrReplaceChild("Rib7", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 1.5F, -0.5F, -0.1508F, -0.1416F, -0.0638F));

		PartDefinition Rib7Seg1 = Rib7.addOrReplaceChild("Rib7Seg1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib7Seg1_r1 = Rib7Seg1.addOrReplaceChild("Rib7Seg1_r1", CubeListBuilder.create().texOffs(19, 76).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Rib7Seg2 = Rib7Seg1.addOrReplaceChild("Rib7Seg2", CubeListBuilder.create(), PartPose.offset(-3.3547F, 0.01F, 5.8533F));

		PartDefinition Rib7Seg2_r1 = Rib7Seg2.addOrReplaceChild("Rib7Seg2_r1", CubeListBuilder.create().texOffs(0, 90).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5272F, 0.0F));

		PartDefinition Rib7Seg3 = Rib7Seg2.addOrReplaceChild("Rib7Seg3", CubeListBuilder.create(), PartPose.offset(-7.4228F, -0.02F, -0.0073F));

		PartDefinition Rib7Seg3_r1 = Rib7Seg3.addOrReplaceChild("Rib7Seg3_r1", CubeListBuilder.create().texOffs(50, 99).addBox(-3.0F, -1.0F, -2.25F, 2.0F, 2.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5898F, 0.0F, 2.9421F, 0.0F, -0.5672F, 0.0F));

		PartDefinition H5Head = H5Torso.addOrReplaceChild("H5Head", CubeListBuilder.create(), PartPose.offset(-0.8183F, -10.0311F, 0.5447F));

		PartDefinition HeadNoPivotPoint = H5Head.addOrReplaceChild("HeadNoPivotPoint", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -1.3129F, 0.4361F, -0.8527F));

		PartDefinition H5HeadBase_r1 = HeadNoPivotPoint.addOrReplaceChild("H5HeadBase_r1", CubeListBuilder.create().texOffs(36, 14).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.4206F, 0.1371F, 0.4856F, 1.7475F, -0.734F, -0.119F));

		PartDefinition H5Jaw = HeadNoPivotPoint.addOrReplaceChild("H5Jaw", CubeListBuilder.create(), PartPose.offset(-2.4366F, 2.7559F, 3.0494F));

		PartDefinition H5Jaw_r1 = H5Jaw.addOrReplaceChild("H5Jaw_r1", CubeListBuilder.create().texOffs(52, 29).addBox(-4.0001F, -1.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2675F, -0.734F, -0.119F));

		PartDefinition MouthDetails = HeadNoPivotPoint.addOrReplaceChild("MouthDetails", CubeListBuilder.create(), PartPose.offset(-2.4135F, -0.0614F, 2.8363F));

		PartDefinition BloodClot_r1 = MouthDetails.addOrReplaceChild("BloodClot_r1", CubeListBuilder.create().texOffs(44, 10).addBox(-3.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, -0.7418F, 0.0F));

		PartDefinition MouthGrowth1 = MouthDetails.addOrReplaceChild("MouthGrowth1", CubeListBuilder.create(), PartPose.offset(0.9843F, -0.5366F, 1.8285F));

		PartDefinition MG1Seg1_r1 = MouthGrowth1.addOrReplaceChild("MG1Seg1_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3316F, 0.2026F, -0.2782F, -0.2182F, -0.8727F, 0.0F));

		PartDefinition MG1Seg2 = MouthGrowth1.addOrReplaceChild("MG1Seg2", CubeListBuilder.create(), PartPose.offset(0.0F, -1.75F, 0.0F));

		PartDefinition MG1Seg2_r1 = MG1Seg2.addOrReplaceChild("MG1Seg2_r1", CubeListBuilder.create().texOffs(27, 22).addBox(-0.5F, -4.9F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3578F, -0.567F, 0.0426F));

		PartDefinition MouthGrowth2 = MouthDetails.addOrReplaceChild("MouthGrowth2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3264F, -0.3842F, 0.7779F, -2.6385F, -0.7471F, 2.4609F));

		PartDefinition MG2Seg1_r1 = MouthGrowth2.addOrReplaceChild("MG2Seg1_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2357F, -0.2354F, 0.1094F, -0.2182F, -0.8727F, 0.0F));

		PartDefinition MG2Seg2 = MouthGrowth2.addOrReplaceChild("MG2Seg2", CubeListBuilder.create(), PartPose.offset(-0.2379F, -2.4689F, 0.3815F));

		PartDefinition MG2Seg2_r1 = MG2Seg2.addOrReplaceChild("MG2Seg2_r1", CubeListBuilder.create().texOffs(27, 22).addBox(-0.5F, -4.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0723F, -0.947F, -0.6358F));

		PartDefinition MouthGrowth3 = MouthDetails.addOrReplaceChild("MouthGrowth3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1797F, -0.9369F, -0.4452F, -1.8526F, -1.1818F, 1.6438F));

		PartDefinition MG3Seg1_r1 = MouthGrowth3.addOrReplaceChild("MG3Seg1_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2038F, -0.2F, 0.0111F, -0.2182F, -0.8727F, 0.0F));

		PartDefinition MG3Seg2 = MouthGrowth3.addOrReplaceChild("MG3Seg2", CubeListBuilder.create(), PartPose.offset(-0.5354F, -2.1526F, 0.2893F));

		PartDefinition MG3Seg2_r1 = MG3Seg2.addOrReplaceChild("MG3Seg2_r1", CubeListBuilder.create().texOffs(0, 55).addBox(-0.5F, -3.9F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.333F, -1.0659F, -1.5124F));

		PartDefinition MouthGrowth4 = MouthDetails.addOrReplaceChild("MouthGrowth4", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4896F, 1.0207F, -1.181F, -2.9293F, -1.3837F, 2.5307F));

		PartDefinition MG4Seg1_r1 = MouthGrowth4.addOrReplaceChild("MG4Seg1_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, -0.2182F, -0.8727F, 0.0F));

		PartDefinition MG4Seg2 = MouthGrowth4.addOrReplaceChild("MG4Seg2", CubeListBuilder.create(), PartPose.offset(-0.8316F, -3.9526F, 0.2782F));

		PartDefinition MG4Seg2_r1 = MG4Seg2.addOrReplaceChild("MG4Seg2_r1", CubeListBuilder.create().texOffs(3, 59).addBox(-0.5F, -2.65F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3041F, -0.1588F, 0.3523F));

		PartDefinition crown1 = HeadNoPivotPoint.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0717F, -0.3997F, -1.0934F, 0.4185F, 0.1274F, 1.4234F));

		PartDefinition Petal4_r2 = crown1.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r4 = crown1.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(78, 81).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r4 = crown1.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r4 = crown1.addOrReplaceChild("Petal1_r4", CubeListBuilder.create().texOffs(66, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition crown2 = HeadNoPivotPoint.addOrReplaceChild("crown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4969F, -1.1858F, -1.5951F, 1.1341F, -0.0184F, 1.7412F));

		PartDefinition Petal5_r2 = crown2.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(66, 81).addBox(-3.0F, 0.0F, -4.75F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7577F, -0.3643F, 0.4078F, 0.0F, 0.4363F, -0.4363F));

		PartDefinition Petal4_r3 = crown2.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(66, 81).addBox(-1.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2423F, -0.3643F, 0.4078F, -0.1289F, 0.0227F, 0.6094F));

		PartDefinition Petal3_r5 = crown2.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, -0.3643F, -3.5922F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r5 = crown2.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(78, 87).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2423F, -0.3643F, 4.4078F, 0.4152F, -0.3215F, -0.1384F));

		PartDefinition HeadTumor1 = HeadNoPivotPoint.addOrReplaceChild("HeadTumor1", CubeListBuilder.create(), PartPose.offset(2.3307F, 0.4226F, -1.7762F));

		PartDefinition HeadTumor1_r1 = HeadTumor1.addOrReplaceChild("HeadTumor1_r1", CubeListBuilder.create().texOffs(11, 0).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3879F, 0.5355F, -0.0891F));

		PartDefinition HeadTumor2 = HeadNoPivotPoint.addOrReplaceChild("HeadTumor2", CubeListBuilder.create(), PartPose.offset(1.4625F, -0.5441F, -2.424F));

		PartDefinition HeadTumor2_r1 = HeadTumor2.addOrReplaceChild("HeadTumor2_r1", CubeListBuilder.create().texOffs(11, 1).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.333F, 0.2383F, -0.3319F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
			this.animate(entity.attackAnimationState,UmarmerAnimations.UMARMER_SLAM,ageInTicks,1.0F);
			this.animate(entity.idleAnimationState, UmarmerAnimations.UMARMER_IDLE, ageInTicks, 1.0F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Tendril_organoid1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Tendril_organoid1;
	}
}