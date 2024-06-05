package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.VerwaAnimations;
import com.Harbinger.Spore.Sentities.Organoids.Verwa;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class verwahrungModel<T extends Verwa> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "verwahrung"), "main");
	private final ModelPart SporePod;

	public verwahrungModel(ModelPart root) {
		this.SporePod = root.getChild("SporePod");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition SporePod = partdefinition.addOrReplaceChild("SporePod", CubeListBuilder.create(), PartPose.offset(-0.85F, 24.0F, -3.0F));

		PartDefinition TumorBase = SporePod.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(2.0062F, -1.7921F, 4.1882F));

		PartDefinition Biomass_r1 = TumorBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(2, 1).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = TumorBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(4, 2).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = TumorBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(8, 4).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = TumorBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(6, 3).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r5 = TumorBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7284F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition Base = SporePod.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Petals = Base.addOrReplaceChild("Petals", CubeListBuilder.create(), PartPose.offset(0.85F, -5.0F, 3.0F));

		PartDefinition Petal1 = Petals.addOrReplaceChild("Petal1", CubeListBuilder.create().texOffs(8, 114).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.15F, 0.0F, -5.5F, 0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r1 = Petal1.addOrReplaceChild("Membrane_r1", CubeListBuilder.create().texOffs(95, 92).addBox(1.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r2 = Petal1.addOrReplaceChild("Membrane_r2", CubeListBuilder.create().texOffs(98, 7).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal1Middle = Petal1.addOrReplaceChild("Petal1Middle", CubeListBuilder.create().texOffs(0, 113).addBox(-0.99F, -11.75F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0347F, 0.0245F, -0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r3 = Petal1Middle.addOrReplaceChild("Membrane_r3", CubeListBuilder.create().texOffs(100, 105).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9653F, -0.0245F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Membrane_r4 = Petal1Middle.addOrReplaceChild("Membrane_r4", CubeListBuilder.create().texOffs(14, 90).addBox(1.0F, -11.0F, 0.0F, 7.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.9653F, -0.0245F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Petal1Top = Petal1Middle.addOrReplaceChild("Petal1Top", CubeListBuilder.create().texOffs(32, 117).addBox(-1.0F, -11.5F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7413F, 0.0578F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Membrane_r5 = Petal1Top.addOrReplaceChild("Membrane_r5", CubeListBuilder.create().texOffs(110, 0).addBox(1.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.224F, -0.0823F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r6 = Petal1Top.addOrReplaceChild("Membrane_r6", CubeListBuilder.create().texOffs(111, 31).addBox(-7.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.224F, -0.0823F, 0.0F, 0.5236F, 0.0F));

		PartDefinition PetalTumor1 = Petal1Top.addOrReplaceChild("PetalTumor1", CubeListBuilder.create(), PartPose.offset(1.0F, -12.0F, 1.0F));

		PartDefinition Tumors_r1 = PetalTumor1.addOrReplaceChild("Tumors_r1", CubeListBuilder.create().texOffs(12, 12).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1237F, 0.6269F, 0.543F));

		PartDefinition Petal2 = Petals.addOrReplaceChild("Petal2", CubeListBuilder.create().texOffs(8, 114).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8563F, 0.0F, -0.8541F, 0.48F, -1.2566F, 0.0F));

		PartDefinition Membrane_r7 = Petal2.addOrReplaceChild("Membrane_r7", CubeListBuilder.create().texOffs(95, 92).addBox(1.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, 0.0F, -0.1459F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r8 = Petal2.addOrReplaceChild("Membrane_r8", CubeListBuilder.create().texOffs(98, 7).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, 0.0F, -0.1459F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal2Middle = Petal2.addOrReplaceChild("Petal2Middle", CubeListBuilder.create().texOffs(0, 113).addBox(-0.99F, -11.75F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0347F, 0.0245F, -0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r9 = Petal2Middle.addOrReplaceChild("Membrane_r9", CubeListBuilder.create().texOffs(14, 90).addBox(1.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, -0.9653F, -0.1704F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r10 = Petal2Middle.addOrReplaceChild("Membrane_r10", CubeListBuilder.create().texOffs(99, 105).addBox(-8.0F, -11.0F, 0.0F, 7.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, -0.9653F, -0.1704F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal2Top = Petal2Middle.addOrReplaceChild("Petal2Top", CubeListBuilder.create().texOffs(32, 117).addBox(-1.0F, -11.5F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7413F, 0.0578F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Membrane_r11 = Petal2Top.addOrReplaceChild("Membrane_r11", CubeListBuilder.create().texOffs(110, 0).addBox(1.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, -1.224F, -0.2282F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r12 = Petal2Top.addOrReplaceChild("Membrane_r12", CubeListBuilder.create().texOffs(111, 31).addBox(-7.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0437F, -1.224F, -0.2282F, 0.0F, 0.5236F, 0.0F));

		PartDefinition PetalTumor2 = Petal2Top.addOrReplaceChild("PetalTumor2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7063F, -12.0F, 0.3541F, 0.3054F, -0.48F, 0.0F));

		PartDefinition Tumors_r2 = PetalTumor2.addOrReplaceChild("Tumors_r2", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.102F, 0.1932F, 0.4899F));

		PartDefinition Petal2TopFungus = Petal2Top.addOrReplaceChild("Petal2TopFungus", CubeListBuilder.create(), PartPose.offset(1.0843F, -5.0632F, 0.4243F));

		PartDefinition Fungus_r1 = Petal2TopFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 31).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6907F, -2.2108F, -1.6025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = Petal2TopFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 24).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1907F, -0.2108F, -0.6025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = Petal2TopFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 38).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.0392F, -1.1025F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = Petal2TopFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 38).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.0392F, -1.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Petal3 = Petals.addOrReplaceChild("Petal3", CubeListBuilder.create().texOffs(8, 114).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6767F, 0.0F, 5.8541F, -2.6616F, -0.6283F, 3.1416F));

		PartDefinition Membrane_r13 = Petal3.addOrReplaceChild("Membrane_r13", CubeListBuilder.create().texOffs(95, 92).addBox(1.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0267F, 0.0F, -0.3541F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r14 = Petal3.addOrReplaceChild("Membrane_r14", CubeListBuilder.create().texOffs(98, 7).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0267F, 0.0F, -0.3541F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal3Middle = Petal3.addOrReplaceChild("Petal3Middle", CubeListBuilder.create().texOffs(0, 113).addBox(-0.99F, -11.75F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0347F, 0.0245F, -0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r15 = Petal3Middle.addOrReplaceChild("Membrane_r15", CubeListBuilder.create().texOffs(100, 105).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1233F, -0.9653F, -0.3786F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Membrane_r16 = Petal3Middle.addOrReplaceChild("Membrane_r16", CubeListBuilder.create().texOffs(14, 90).addBox(1.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1233F, -0.9653F, -0.3786F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Petal3Top = Petal3Middle.addOrReplaceChild("Petal3Top", CubeListBuilder.create().texOffs(32, 114).addBox(-1.0F, -11.5F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7413F, 0.0578F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Membrane_r17 = Petal3Top.addOrReplaceChild("Membrane_r17", CubeListBuilder.create().texOffs(110, 0).addBox(1.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0267F, -1.224F, -0.9364F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r18 = Petal3Top.addOrReplaceChild("Membrane_r18", CubeListBuilder.create().texOffs(111, 31).addBox(-7.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0267F, -1.224F, -0.9364F, 0.0F, 0.5236F, 0.0F));

		PartDefinition PetalTumor3 = Petal3Top.addOrReplaceChild("PetalTumor3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.703F, -11.1962F, 0.4198F, 0.4638F, -0.3305F, -0.3961F));

		PartDefinition Tumors_r3 = PetalTumor3.addOrReplaceChild("Tumors_r3", CubeListBuilder.create().texOffs(12, 12).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0994F, -0.6744F, 0.5342F, 0.102F, 0.1932F, 0.4899F));

		PartDefinition Petal4 = Petals.addOrReplaceChild("Petal4", CubeListBuilder.create().texOffs(8, 114).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3767F, 0.0F, 5.8541F, -2.6616F, 0.6283F, 3.1416F));

		PartDefinition Membrane_r19 = Petal4.addOrReplaceChild("Membrane_r19", CubeListBuilder.create().texOffs(95, 92).addBox(1.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, 0.0F, -0.3541F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r20 = Petal4.addOrReplaceChild("Membrane_r20", CubeListBuilder.create().texOffs(98, 7).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, 0.0F, -0.3541F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal4Middle = Petal4.addOrReplaceChild("Petal4Middle", CubeListBuilder.create().texOffs(0, 113).addBox(-0.99F, -11.75F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0347F, 0.0245F, -0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r21 = Petal4Middle.addOrReplaceChild("Membrane_r21", CubeListBuilder.create().texOffs(100, 105).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, -0.9653F, -0.6286F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Membrane_r22 = Petal4Middle.addOrReplaceChild("Membrane_r22", CubeListBuilder.create().texOffs(14, 90).addBox(1.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, -0.9653F, -0.6286F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Petal4Top = Petal4Middle.addOrReplaceChild("Petal4Top", CubeListBuilder.create().texOffs(32, 115).addBox(-1.0F, -11.5F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7413F, 0.0578F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Membrane_r23 = Petal4Top.addOrReplaceChild("Membrane_r23", CubeListBuilder.create().texOffs(110, 0).addBox(1.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, -0.974F, -0.9364F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r24 = Petal4Top.addOrReplaceChild("Membrane_r24", CubeListBuilder.create().texOffs(111, 31).addBox(-7.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0267F, -0.974F, -0.9364F, 0.0F, 0.5236F, 0.0F));

		PartDefinition PetalTumor4Sub1 = Petal4Top.addOrReplaceChild("PetalTumor4Sub1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7565F, -11.1962F, 0.4198F, 0.562F, -0.0231F, -0.935F));

		PartDefinition Tumors_r4 = PetalTumor4Sub1.addOrReplaceChild("Tumors_r4", CubeListBuilder.create().texOffs(12, 12).addBox(-1.0F, -1.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0994F, -0.6744F, 0.5342F, 0.102F, 0.1932F, 0.4899F));

		PartDefinition PetalTumor4Sub2 = Petal4Top.addOrReplaceChild("PetalTumor4Sub2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7467F, -11.3437F, 0.2392F, 0.7093F, 0.1835F, -1.2706F));

		PartDefinition Tumors_r5 = PetalTumor4Sub2.addOrReplaceChild("Tumors_r5", CubeListBuilder.create().texOffs(12, 12).addBox(0.0F, 0.0F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2981F, -2.0231F, 1.6025F, 0.102F, 0.1932F, 0.4899F));

		PartDefinition Petal4BaseFungus = Petal4.addOrReplaceChild("Petal4BaseFungus", CubeListBuilder.create(), PartPose.offset(0.8174F, -6.8392F, 0.7984F));

		PartDefinition Fungus_r5 = Petal4BaseFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 38).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6907F, -2.2108F, -1.6025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = Petal4BaseFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 24).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1907F, -0.2108F, -0.6025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r7 = Petal4BaseFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.0392F, -1.1025F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = Petal4BaseFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 31).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.0392F, -1.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Petal5 = Petals.addOrReplaceChild("Petal5", CubeListBuilder.create().texOffs(8, 114).addBox(-1.0F, -11.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5231F, 0.0F, -0.9534F, 0.48F, 1.2392F, 0.0F));

		PartDefinition Membrane_r25 = Petal5.addOrReplaceChild("Membrane_r25", CubeListBuilder.create().texOffs(98, 7).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1731F, 0.0F, -0.5466F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Membrane_r26 = Petal5.addOrReplaceChild("Membrane_r26", CubeListBuilder.create().texOffs(95, 92).addBox(1.0F, -11.0F, 0.0F, 6.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1731F, 0.0F, -0.5466F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Petal5Middle = Petal5.addOrReplaceChild("Petal5Middle", CubeListBuilder.create().texOffs(0, 113).addBox(-0.99F, -11.75F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0347F, 0.0245F, -0.48F, 0.0F, 0.0F));

		PartDefinition Membrane_r27 = Petal5Middle.addOrReplaceChild("Membrane_r27", CubeListBuilder.create().texOffs(14, 90).addBox(1.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0769F, -0.9653F, -0.8211F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r28 = Petal5Middle.addOrReplaceChild("Membrane_r28", CubeListBuilder.create().texOffs(100, 105).addBox(-7.0F, -11.0F, 0.0F, 6.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0769F, -0.9653F, -0.8211F, 0.0F, 0.5236F, 0.0F));

		PartDefinition Petal5Top = Petal5Middle.addOrReplaceChild("Petal5Top", CubeListBuilder.create().texOffs(32, 117).addBox(-1.0F, -11.5F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.7413F, 0.0578F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Membrane_r29 = Petal5Top.addOrReplaceChild("Membrane_r29", CubeListBuilder.create().texOffs(110, 0).addBox(1.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0269F, -0.974F, -1.1289F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Membrane_r30 = Petal5Top.addOrReplaceChild("Membrane_r30", CubeListBuilder.create().texOffs(111, 31).addBox(-7.0F, -10.0F, 0.0F, 6.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0269F, -0.974F, -1.1289F, 0.0F, 0.5236F, 0.0F));

		PartDefinition PetalTumor5 = Petal5Top.addOrReplaceChild("PetalTumor5", CubeListBuilder.create(), PartPose.offset(0.9029F, -13.1962F, 2.2273F));

		PartDefinition Tumors_r6 = PetalTumor5.addOrReplaceChild("Tumors_r6", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.0994F, 0.3256F, -0.4658F, 0.2451F, 0.6705F, 0.231F));

		PartDefinition Petal5MiddleFungus = Petal5Middle.addOrReplaceChild("Petal5MiddleFungus", CubeListBuilder.create(), PartPose.offset(0.4638F, -5.8045F, 0.5814F));

		PartDefinition Fungus_r9 = Petal5MiddleFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 31).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3093F, -4.2108F, -1.6025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = Petal5MiddleFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 24).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1907F, -1.2108F, -0.6025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r11 = Petal5MiddleFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 31).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.0392F, -1.1025F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r12 = Petal5MiddleFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 38).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.0392F, -1.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Jaw = Base.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(4.8576F, -5.1743F, 5.0F, 1.5708F, -1.4835F, -3.1416F));

		PartDefinition TopJawJoint = Jaw.addOrReplaceChild("TopJawJoint", CubeListBuilder.create(), PartPose.offset(0.0F, -11.0F, 3.0F));

		PartDefinition TopJaw = TopJawJoint.addOrReplaceChild("TopJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3838F, 1.1721F, 0.8621F, -0.829F, 0.0F, 0.0F));

		PartDefinition HeadLeftTeeth_r1 = TopJaw.addOrReplaceChild("HeadLeftTeeth_r1", CubeListBuilder.create().texOffs(71, 85).mirror().addBox(-2.75F, 3.35F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(56, 56).addBox(-2.75F, -3.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.5847F, 0.1825F, -6.2745F, -0.1372F, -0.0042F, 0.4948F));

		PartDefinition HeadCenter_r1 = TopJaw.addOrReplaceChild("HeadCenter_r1", CubeListBuilder.create().texOffs(0, 63).addBox(-5.5F, -3.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.7894F, -1.0826F, -5.7788F, 0.1309F, 0.0F, 0.0436F));

		PartDefinition HeadRightTeeth_r1 = TopJaw.addOrReplaceChild("HeadRightTeeth_r1", CubeListBuilder.create().texOffs(71, 85).addBox(-4.0F, 0.6F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(24, 71).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.597F, 1.5661F, -7.0181F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition BottomJawJoint = Jaw.addOrReplaceChild("BottomJawJoint", CubeListBuilder.create(), PartPose.offset(-1.6315F, 1.8279F, 2.8621F));

		PartDefinition BottomJaw = BottomJawJoint.addOrReplaceChild("BottomJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6906F, -0.1119F, 0.1343F));

		PartDefinition HeadLeft_r1 = BottomJaw.addOrReplaceChild("HeadLeft_r1", CubeListBuilder.create().texOffs(24, 56).addBox(-2.75F, -3.75F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(5.5847F, -0.1825F, -6.2745F, -0.0555F, -0.1071F, -0.484F));

		PartDefinition HeadCenter_r2 = BottomJaw.addOrReplaceChild("HeadCenter_r2", CubeListBuilder.create().texOffs(48, 0).addBox(-5.5F, -2.75F, -4.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.7894F, 1.0826F, -5.7788F, -0.1309F, 0.0F, -0.0436F));

		PartDefinition HeadRightTeeth_r2 = BottomJaw.addOrReplaceChild("HeadRightTeeth_r2", CubeListBuilder.create().texOffs(71, 85).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.5951F, -1.5804F, -8.277F, 0.1309F, 0.0F, -3.0107F));

		PartDefinition HeadRight_r1 = BottomJaw.addOrReplaceChild("HeadRight_r1", CubeListBuilder.create().texOffs(67, 25).addBox(-4.0F, 0.75F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.597F, -1.5661F, -7.0181F, -0.1309F, 0.0F, 0.1309F));

		PartDefinition InternalDetails = Base.addOrReplaceChild("InternalDetails", CubeListBuilder.create(), PartPose.offset(1.0F, -5.0F, 4.0F));

		PartDefinition Plane_r1 = InternalDetails.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(0, 131).addBox(-10.0F, -9.0F, 0.0F, 20.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.15F, -8.0F, 0.0F, -3.0107F, -1.0472F, 3.1416F));

		PartDefinition Plane_r2 = InternalDetails.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(0, 131).mirror().addBox(-10.0F, -9.0F, 0.0F, 20.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.15F, -8.0F, 0.0F, -0.0873F, -0.9599F, 0.0F));

		PartDefinition Plane_r3 = InternalDetails.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(0, 131).addBox(-10.0F, -9.0F, 0.0F, 20.0F, 18.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.15F, -8.0F, 0.0F, 0.1309F, 0.0F, -0.0873F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.ScaleModel(entity,this.SporePod);
		this.animate(entity.burst, VerwaAnimations.BURST, ageInTicks, 1.0F);
	}


	private void ScaleModel(T type,ModelPart part){
		Entity entity = type.getStoredEntity();
		if (entity.getBbWidth()>type.getBbWidth()){
			float w =entity.getBbWidth();
			part.xScale =w-0.3f;
			part.zScale =w-0.3f;
		}
		if (entity.getBbHeight()>type.getBbHeight()) {
			float h =entity.getBbHeight();
			part.yScale =h-0.3f;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		SporePod.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.SporePod;
	}
}