package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Hinderburg;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class HindenXmaslightsModel<T extends Hinderburg> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "xmaslights"), "main");
	private final ModelPart XmasLights;


	public HindenXmaslightsModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.XmasLights = root.getChild("XmasLights");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition XmasLights = partdefinition.addOrReplaceChild("XmasLights", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Wire1 = XmasLights.addOrReplaceChild("Wire1", CubeListBuilder.create(), PartPose.offset(30.2074F, -141.5162F, 67.0396F));

		PartDefinition Wire_r1 = Wire1.addOrReplaceChild("Wire_r1", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -30.5F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9505F, -1.0239F, 2.6703F));

		PartDefinition Wire_r2 = Wire1.addOrReplaceChild("Wire_r2", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -13.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5628F, 11.2477F, 4.6552F, 1.9187F, -1.18F, -2.3299F));

		PartDefinition Wire_r3 = Wire1.addOrReplaceChild("Wire_r3", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -37.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7364F, 36.5642F, 29.6455F, 1.7582F, -0.7998F, -2.1416F));

		PartDefinition Wire_r4 = Wire1.addOrReplaceChild("Wire_r4", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -9.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.9331F, 43.3223F, 36.2736F, 1.7515F, -0.7824F, -1.7061F));

		PartDefinition Wire_r5 = Wire1.addOrReplaceChild("Wire_r5", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -9.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4335F, 49.4425F, 35.1334F, -1.9498F, -1.434F, 2.7685F));

		PartDefinition Wire_r6 = Wire1.addOrReplaceChild("Wire_r6", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -37.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7764F, 76.9067F, 12.1991F, -1.9045F, -0.8433F, 2.2622F));

		PartDefinition Wire_r7 = Wire1.addOrReplaceChild("Wire_r7", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.4428F, 74.8129F, 9.9975F, -1.8338F, -1.4072F, -2.7232F));

		PartDefinition Wire_r8 = Wire1.addOrReplaceChild("Wire_r8", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -33.5F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.8398F, 83.4636F, -17.9052F, -1.7023F, -0.5732F, 2.8953F));

		PartDefinition Wire_r9 = Wire1.addOrReplaceChild("Wire_r9", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -33.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-63.047F, 84.4196F, -26.9299F, -0.3904F, -0.7529F, 1.8144F));

		PartDefinition Wire_r10 = Wire1.addOrReplaceChild("Wire_r10", CubeListBuilder.create().texOffs(1003, 0).addBox(-0.25F, -14.5F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-73.0542F, 80.0271F, -36.4889F, -0.7854F, -0.45F, 2.338F));

		PartDefinition Wire_r11 = Wire1.addOrReplaceChild("Wire_r11", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -53.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-94.3584F, 45.051F, -70.9135F, -0.7026F, -0.0919F, 2.6721F));

		PartDefinition Wire_r12 = Wire1.addOrReplaceChild("Wire_r12", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -8.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-95.662F, 37.8414F, -75.223F, -0.5327F, 0.0578F, 2.9287F));

		PartDefinition Wire_r13 = Wire1.addOrReplaceChild("Wire_r13", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -21.0F, -1.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-81.8473F, 23.2072F, -71.3188F, 0.1945F, -0.1722F, -2.4187F));

		PartDefinition Wire_r14 = Wire1.addOrReplaceChild("Wire_r14", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -36.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-66.0229F, -6.1519F, -84.8698F, -0.3897F, -0.1361F, -2.5916F));

		PartDefinition Wire_r15 = Wire1.addOrReplaceChild("Wire_r15", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -36.5F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.0443F, -8.1478F, -95.1051F, -0.2882F, 0.1647F, -1.6764F));

		PartDefinition Wire_r16 = Wire1.addOrReplaceChild("Wire_r16", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -38.5F, -1.0F, 2.0F, 39.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6825F, -4.1675F, -82.7863F, 0.3405F, 0.243F, -1.3748F));

		PartDefinition Wire_r17 = Wire1.addOrReplaceChild("Wire_r17", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -53.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(34.2926F, 37.5162F, -67.0396F, 0.2994F, 0.0662F, -0.5972F));

		PartDefinition Bulbs = Wire1.addOrReplaceChild("Bulbs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Bulb1 = Bulbs.addOrReplaceChild("Bulb1", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0322F, 27.5411F, -70.75F, 0.0F, 0.0F, 1.4835F));

		PartDefinition Bulb2 = Bulbs.addOrReplaceChild("Bulb2", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.6593F, 20.4649F, -73.9216F, 1.4149F, 0.1586F, 1.1712F));

		PartDefinition Bulb3 = Bulbs.addOrReplaceChild("Bulb3", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2102F, 7.9315F, -78.0174F, -1.0722F, 0.1586F, 1.1712F));

		PartDefinition Bulb4 = Bulbs.addOrReplaceChild("Bulb4", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3713F, -1.7982F, -81.7001F, 0.643F, 0.6594F, 0.7831F));

		PartDefinition Bulb5 = Bulbs.addOrReplaceChild("Bulb5", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.3339F, -6.5825F, -88.6611F, -0.6255F, -0.8786F, 0.3497F));

		PartDefinition Bulb6 = Bulbs.addOrReplaceChild("Bulb6", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.3142F, -8.1166F, -92.8002F, -0.6255F, -0.8786F, 0.3497F));

		PartDefinition Bulb7 = Bulbs.addOrReplaceChild("Bulb7", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-59.1329F, -6.7037F, -86.9836F, 1.9386F, -0.7167F, -1.974F));

		PartDefinition Bulb8 = Bulbs.addOrReplaceChild("Bulb8", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-71.4741F, 2.7231F, -80.7925F, -0.4727F, -0.8472F, -0.4934F));

		PartDefinition Bulb9 = Bulbs.addOrReplaceChild("Bulb9", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-78.1776F, 16.4219F, -75.0125F, 0.2785F, -0.4213F, -1.3988F));

		PartDefinition Bulb10 = Bulbs.addOrReplaceChild("Bulb10", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-91.9278F, 33.7056F, -73.9144F, -0.6515F, -0.4724F, -0.4248F));

		PartDefinition Bulb11 = Bulbs.addOrReplaceChild("Bulb11", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-88.012F, 55.7323F, -61.4048F, 0.6151F, -0.5216F, -2.4143F));

		PartDefinition Bulb12 = Bulbs.addOrReplaceChild("Bulb12", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-82.8521F, 63.4674F, -53.1863F, -1.541F, -0.7115F, -0.9309F));

		PartDefinition Bulb13 = Bulbs.addOrReplaceChild("Bulb13", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-70.9502F, 81.6844F, -33.7574F, -1.541F, -0.7115F, -0.9309F));

		PartDefinition Bulb14 = Bulbs.addOrReplaceChild("Bulb14", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.3095F, 84.0194F, -21.4649F, 0.7525F, -1.3814F, 2.3481F));

		PartDefinition Bulb15 = Bulbs.addOrReplaceChild("Bulb15", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.6367F, 81.8049F, -11.0327F, -1.186F, -1.196F, -1.9631F));

		PartDefinition Bulb16 = Bulbs.addOrReplaceChild("Bulb16", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.5764F, 74.5962F, 9.5028F, -1.8274F, -0.575F, -0.9591F));

		PartDefinition Bulb17 = Bulbs.addOrReplaceChild("Bulb17", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1961F, 75.3611F, 14.7812F, -2.8077F, -0.1255F, -0.7778F));

		PartDefinition Bulb18 = Bulbs.addOrReplaceChild("Bulb18", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4221F, 56.4147F, 29.1454F, -1.7093F, -1.064F, -1.4024F));

		PartDefinition Bulb19 = Bulbs.addOrReplaceChild("Bulb19", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.8558F, 41.8989F, 34.8168F, -3.1363F, -1.2396F, -2.3107F));

		PartDefinition Bulb20 = Bulbs.addOrReplaceChild("Bulb20", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.8019F, 30.5924F, 23.3254F, 0.4752F, -1.2038F, 0.8403F));

		PartDefinition Bulb21 = Bulbs.addOrReplaceChild("Bulb21", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4694F, 10.9694F, 4.0424F, -0.2532F, -0.5971F, 0.4012F));

		PartDefinition Bulb22 = Bulbs.addOrReplaceChild("Bulb22", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7871F, 0.3931F, -9.1222F, -0.995F, -0.5971F, 0.4012F));

		PartDefinition Wire2 = XmasLights.addOrReplaceChild("Wire2", CubeListBuilder.create(), PartPose.offset(-29.2074F, -59.9838F, -71.5396F));

		PartDefinition Wire_r18 = Wire2.addOrReplaceChild("Wire_r18", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.75F, 0.0F, 0.0F, 1.9505F, -1.0239F, 2.6703F));

		PartDefinition Wire_r19 = Wire2.addOrReplaceChild("Wire_r19", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1872F, -11.2477F, -4.6552F, 1.9187F, -1.18F, -2.3299F));

		PartDefinition Wire_r20 = Wire2.addOrReplaceChild("Wire_r20", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.9864F, -36.5642F, -29.6455F, 1.7582F, -0.7998F, -2.1416F));

		PartDefinition Wire_r21 = Wire2.addOrReplaceChild("Wire_r21", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.1831F, -43.3223F, -36.2736F, 1.7515F, -0.7824F, -1.7061F));

		PartDefinition Wire_r22 = Wire2.addOrReplaceChild("Wire_r22", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.3165F, -49.4425F, -35.1334F, -1.9498F, -1.434F, 2.7685F));

		PartDefinition Wire_r23 = Wire2.addOrReplaceChild("Wire_r23", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.5264F, -76.9067F, -12.1991F, -1.9045F, -0.8433F, 2.2622F));

		PartDefinition Wire_r24 = Wire2.addOrReplaceChild("Wire_r24", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.4428F, -74.8129F, -9.9975F, -1.8338F, -1.4072F, -2.7232F));

		PartDefinition Wire_r25 = Wire2.addOrReplaceChild("Wire_r25", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(31.8398F, -83.4636F, 17.9052F, -1.7023F, -0.5732F, 2.8953F));

		PartDefinition Wire_r26 = Wire2.addOrReplaceChild("Wire_r26", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(63.047F, -84.4196F, 26.9299F, -0.3904F, -0.7529F, 1.8144F));

		PartDefinition Wire_r27 = Wire2.addOrReplaceChild("Wire_r27", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.75F, -0.5F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(73.0542F, -80.0271F, 36.4889F, -0.7854F, -0.45F, 2.338F));

		PartDefinition Wire_r28 = Wire2.addOrReplaceChild("Wire_r28", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(94.3584F, -45.051F, 70.9135F, -0.7026F, -0.0919F, 2.6721F));

		PartDefinition Wire_r29 = Wire2.addOrReplaceChild("Wire_r29", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(95.662F, -37.8414F, 75.223F, -0.5327F, 0.0578F, 2.9287F));

		PartDefinition Wire_r30 = Wire2.addOrReplaceChild("Wire_r30", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(81.8473F, -23.2072F, 71.3188F, 0.1945F, -0.1722F, -2.4187F));

		PartDefinition Wire_r31 = Wire2.addOrReplaceChild("Wire_r31", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(66.0229F, 6.1519F, 84.8698F, -0.3897F, -0.1361F, -2.5916F));

		PartDefinition Wire_r32 = Wire2.addOrReplaceChild("Wire_r32", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(31.0443F, 8.1478F, 95.1051F, -0.2882F, 0.1647F, -1.6764F));

		PartDefinition Wire_r33 = Wire2.addOrReplaceChild("Wire_r33", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, -0.5F, -1.0F, 2.0F, 39.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.6825F, 4.1675F, 82.7863F, 0.3405F, 0.243F, -1.3748F));

		PartDefinition Wire_r34 = Wire2.addOrReplaceChild("Wire_r34", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-34.2926F, -37.5162F, 67.0396F, 0.2994F, 0.0662F, -0.5972F));

		PartDefinition Bulbs2 = Wire2.addOrReplaceChild("Bulbs2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Bulb23 = Bulbs2.addOrReplaceChild("Bulb23", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.0322F, -27.5411F, 70.75F, 0.0F, 0.0F, 1.4835F));

		PartDefinition Bulb24 = Bulbs2.addOrReplaceChild("Bulb24", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-21.6593F, -20.4649F, 73.9216F, 1.4149F, 0.1586F, 1.1712F));

		PartDefinition Bulb25 = Bulbs2.addOrReplaceChild("Bulb25", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.2102F, -7.9315F, 78.0174F, -1.0722F, 0.1586F, 1.1712F));

		PartDefinition Bulb26 = Bulbs2.addOrReplaceChild("Bulb26", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.3713F, 1.7982F, 81.7001F, 0.643F, 0.6594F, 0.7831F));

		PartDefinition Bulb27 = Bulbs2.addOrReplaceChild("Bulb27", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.3339F, 6.5825F, 88.6611F, -0.6255F, -0.8786F, 0.3497F));

		PartDefinition Bulb28 = Bulbs2.addOrReplaceChild("Bulb28", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(38.3142F, 8.1166F, 92.8002F, -0.6255F, -0.8786F, 0.3497F));

		PartDefinition Bulb29 = Bulbs2.addOrReplaceChild("Bulb29", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(59.1329F, 6.7037F, 86.9836F, 1.9386F, -0.7167F, -1.974F));

		PartDefinition Bulb30 = Bulbs2.addOrReplaceChild("Bulb30", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(71.4741F, -2.7231F, 80.7925F, -0.4727F, -0.8472F, -0.4934F));

		PartDefinition Bulb31 = Bulbs2.addOrReplaceChild("Bulb31", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(78.1776F, -16.4219F, 75.0125F, 0.2785F, -0.4213F, -1.3988F));

		PartDefinition Bulb32 = Bulbs2.addOrReplaceChild("Bulb32", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(91.9278F, -33.7056F, 73.9144F, -0.6515F, -0.4724F, -0.4248F));

		PartDefinition Bulb33 = Bulbs2.addOrReplaceChild("Bulb33", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(88.012F, -55.7323F, 61.4048F, 0.6151F, -0.5216F, -2.4143F));

		PartDefinition Bulb34 = Bulbs2.addOrReplaceChild("Bulb34", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(82.8521F, -63.4674F, 53.1863F, -1.541F, -0.7115F, -0.9309F));

		PartDefinition Bulb35 = Bulbs2.addOrReplaceChild("Bulb35", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(70.9502F, -81.6844F, 33.7574F, -1.541F, -0.7115F, -0.9309F));

		PartDefinition Bulb36 = Bulbs2.addOrReplaceChild("Bulb36", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(45.3095F, -84.0194F, 21.4649F, 0.7525F, -1.3814F, 2.3481F));

		PartDefinition Bulb37 = Bulbs2.addOrReplaceChild("Bulb37", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.6367F, -81.8049F, 11.0327F, -1.186F, -1.196F, -1.9631F));

		PartDefinition Bulb38 = Bulbs2.addOrReplaceChild("Bulb38", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.5764F, -74.5962F, -9.5028F, -1.8274F, -0.575F, -0.9591F));

		PartDefinition Bulb39 = Bulbs2.addOrReplaceChild("Bulb39", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.6215F, -71.2494F, -16.9047F, -2.8077F, -0.1255F, -0.7778F));

		PartDefinition Bulb40 = Bulbs2.addOrReplaceChild("Bulb40", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5577F, -56.1328F, -29.5474F, -1.7093F, -1.064F, -1.4024F));

		PartDefinition Bulb41 = Bulbs2.addOrReplaceChild("Bulb41", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.3536F, -41.7736F, -33.5093F, -3.1363F, -1.2396F, -2.3107F));

		PartDefinition Bulb42 = Bulbs2.addOrReplaceChild("Bulb42", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.1184F, -32.2439F, -24.3103F, 0.4752F, -1.2038F, 0.8403F));

		PartDefinition Bulb43 = Bulbs2.addOrReplaceChild("Bulb43", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.7839F, -20.1666F, -13.0674F, -0.2532F, -0.5971F, 0.4012F));

		PartDefinition Bulb44 = Bulbs2.addOrReplaceChild("Bulb44", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.7871F, -0.3931F, 9.1222F, -0.995F, -0.5971F, 0.4012F));

		PartDefinition Wire3 = XmasLights.addOrReplaceChild("Wire3", CubeListBuilder.create(), PartPose.offset(-30.2074F, -62.4838F, 61.0396F));

		PartDefinition Wire_r35 = Wire3.addOrReplaceChild("Wire_r35", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.9505F, 1.0239F, 2.6703F));

		PartDefinition Wire_r36 = Wire3.addOrReplaceChild("Wire_r36", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5628F, -11.2477F, 4.6552F, -1.9187F, 1.18F, -2.3299F));

		PartDefinition Wire_r37 = Wire3.addOrReplaceChild("Wire_r37", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.7364F, -36.5642F, 29.6455F, -1.7582F, 0.7998F, -2.1416F));

		PartDefinition Wire_r38 = Wire3.addOrReplaceChild("Wire_r38", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.9331F, -43.3223F, 36.2736F, -1.7515F, 0.7824F, -1.7061F));

		PartDefinition Wire_r39 = Wire3.addOrReplaceChild("Wire_r39", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.4335F, -49.4425F, 35.1334F, 1.9498F, 1.434F, 2.7685F));

		PartDefinition Wire_r40 = Wire3.addOrReplaceChild("Wire_r40", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.7764F, -76.9067F, 12.1991F, 1.9045F, 0.8433F, 2.2622F));

		PartDefinition Wire_r41 = Wire3.addOrReplaceChild("Wire_r41", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(15.4428F, -74.8129F, 9.9975F, 1.8338F, 1.4072F, -2.7232F));

		PartDefinition Wire_r42 = Wire3.addOrReplaceChild("Wire_r42", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(31.8398F, -83.4636F, -17.9052F, 1.7023F, 0.5732F, 2.8953F));

		PartDefinition Wire_r43 = Wire3.addOrReplaceChild("Wire_r43", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(63.047F, -84.4196F, -26.9299F, 0.3904F, 0.7529F, 1.8144F));

		PartDefinition Wire_r44 = Wire3.addOrReplaceChild("Wire_r44", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.75F, -0.5F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(73.0542F, -80.0271F, -36.4889F, 0.7854F, 0.45F, 2.338F));

		PartDefinition Wire_r45 = Wire3.addOrReplaceChild("Wire_r45", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(94.3584F, -45.051F, -70.9135F, 0.7026F, 0.0919F, 2.6721F));

		PartDefinition Wire_r46 = Wire3.addOrReplaceChild("Wire_r46", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(95.662F, -37.8414F, -75.223F, 0.5327F, -0.0578F, 2.9287F));

		PartDefinition Wire_r47 = Wire3.addOrReplaceChild("Wire_r47", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(81.8473F, -23.2072F, -71.3188F, -0.1945F, 0.1722F, -2.4187F));

		PartDefinition Wire_r48 = Wire3.addOrReplaceChild("Wire_r48", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(66.0229F, 6.1519F, -84.8698F, 0.3897F, 0.1361F, -2.5916F));

		PartDefinition Wire_r49 = Wire3.addOrReplaceChild("Wire_r49", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.5F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(31.0443F, 8.1478F, -95.1051F, 0.2882F, -0.1647F, -1.6764F));

		PartDefinition Wire_r50 = Wire3.addOrReplaceChild("Wire_r50", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, -0.5F, -1.0F, 2.0F, 39.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.6825F, 4.1675F, -82.7863F, -0.3405F, -0.243F, -1.3748F));

		PartDefinition Wire_r51 = Wire3.addOrReplaceChild("Wire_r51", CubeListBuilder.create().texOffs(1003, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-34.2926F, -37.5162F, -67.0396F, -0.2994F, -0.0662F, -0.5972F));

		PartDefinition Bulbs3 = Wire3.addOrReplaceChild("Bulbs3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Bulb45 = Bulbs3.addOrReplaceChild("Bulb45", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-27.0322F, -27.5411F, -70.75F, 0.0F, 0.0F, 1.4835F));

		PartDefinition Bulb46 = Bulbs3.addOrReplaceChild("Bulb46", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-21.6593F, -20.4649F, -73.9216F, -1.4149F, -0.1586F, 1.1712F));

		PartDefinition Bulb47 = Bulbs3.addOrReplaceChild("Bulb47", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.2102F, -7.9315F, -78.0174F, 1.0722F, -0.1586F, 1.1712F));

		PartDefinition Bulb48 = Bulbs3.addOrReplaceChild("Bulb48", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.3713F, 1.7982F, -81.7001F, -0.643F, -0.6594F, 0.7831F));

		PartDefinition Bulb49 = Bulbs3.addOrReplaceChild("Bulb49", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(13.3339F, 6.5825F, -88.6611F, 0.6255F, 0.8786F, 0.3497F));

		PartDefinition Bulb50 = Bulbs3.addOrReplaceChild("Bulb50", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(38.3142F, 8.1166F, -92.8002F, 0.6255F, 0.8786F, 0.3497F));

		PartDefinition Bulb51 = Bulbs3.addOrReplaceChild("Bulb51", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(59.1329F, 6.7037F, -86.9836F, -1.9386F, 0.7167F, -1.974F));

		PartDefinition Bulb52 = Bulbs3.addOrReplaceChild("Bulb52", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(71.4741F, -2.7231F, -80.7925F, 0.4727F, 0.8472F, -0.4934F));

		PartDefinition Bulb53 = Bulbs3.addOrReplaceChild("Bulb53", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(78.1776F, -16.4219F, -75.0125F, -0.2785F, 0.4213F, -1.3988F));

		PartDefinition Bulb54 = Bulbs3.addOrReplaceChild("Bulb54", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(91.9278F, -33.7056F, -73.9144F, 0.6515F, 0.4724F, -0.4248F));

		PartDefinition Bulb55 = Bulbs3.addOrReplaceChild("Bulb55", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(88.012F, -55.7323F, -61.4048F, -0.6151F, 0.5216F, -2.4143F));

		PartDefinition Bulb56 = Bulbs3.addOrReplaceChild("Bulb56", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(82.8521F, -63.4674F, -53.1863F, 1.541F, 0.7115F, -0.9309F));

		PartDefinition Bulb57 = Bulbs3.addOrReplaceChild("Bulb57", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(70.9502F, -81.6844F, -33.7574F, 1.541F, 0.7115F, -0.9309F));

		PartDefinition Bulb58 = Bulbs3.addOrReplaceChild("Bulb58", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(45.3095F, -84.0194F, -21.4649F, -0.7525F, 1.3814F, 2.3481F));

		PartDefinition Bulb59 = Bulbs3.addOrReplaceChild("Bulb59", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(27.6367F, -81.8049F, -11.0327F, 1.186F, 1.196F, -1.9631F));

		PartDefinition Bulb60 = Bulbs3.addOrReplaceChild("Bulb60", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.5764F, -74.5962F, 9.5028F, 1.8274F, 0.575F, -0.9591F));

		PartDefinition Bulb61 = Bulbs3.addOrReplaceChild("Bulb61", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.1961F, -75.3611F, 14.7812F, 2.8077F, 0.1255F, -0.7778F));

		PartDefinition Bulb62 = Bulbs3.addOrReplaceChild("Bulb62", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.4221F, -56.4147F, 29.1454F, 1.7093F, 1.064F, -1.4024F));

		PartDefinition Bulb63 = Bulbs3.addOrReplaceChild("Bulb63", CubeListBuilder.create().texOffs(1013, 13).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 12).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 13).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-11.8558F, -41.8989F, 34.8168F, 3.1363F, 1.2396F, -2.3107F));

		PartDefinition Bulb64 = Bulbs3.addOrReplaceChild("Bulb64", CubeListBuilder.create().texOffs(1013, 19).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 18).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 19).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.8019F, -30.5924F, 23.3254F, -0.4752F, 1.2038F, 0.8403F));

		PartDefinition Bulb65 = Bulbs3.addOrReplaceChild("Bulb65", CubeListBuilder.create().texOffs(1013, 1).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 0).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 1).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.4694F, -10.9694F, 4.0424F, 0.2532F, 0.5971F, 0.4012F));

		PartDefinition Bulb66 = Bulbs3.addOrReplaceChild("Bulb66", CubeListBuilder.create().texOffs(1013, 7).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1011, 6).mirror().addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1013, 7).mirror().addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.7871F, -0.3931F, -9.1222F, 0.995F, 0.5971F, 0.4012F));

		PartDefinition Wire4 = XmasLights.addOrReplaceChild("Wire4", CubeListBuilder.create(), PartPose.offset(30.2074F, -59.4838F, -58.0396F));

		PartDefinition Wire_r52 = Wire4.addOrReplaceChild("Wire_r52", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 30.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.9505F, 1.0239F, -2.6703F));

		PartDefinition Wire_r53 = Wire4.addOrReplaceChild("Wire_r53", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5628F, -11.2477F, -4.6552F, 1.9187F, 1.18F, 2.3299F));

		PartDefinition Wire_r54 = Wire4.addOrReplaceChild("Wire_r54", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7364F, -36.5642F, -29.6455F, 1.7582F, 0.7998F, 2.1416F));

		PartDefinition Wire_r55 = Wire4.addOrReplaceChild("Wire_r55", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.9331F, -43.3223F, -36.2736F, 1.7515F, 0.7824F, 1.7061F));

		PartDefinition Wire_r56 = Wire4.addOrReplaceChild("Wire_r56", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4335F, -49.4425F, -35.1334F, -1.9498F, 1.434F, -2.7685F));

		PartDefinition Wire_r57 = Wire4.addOrReplaceChild("Wire_r57", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 37.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7764F, -76.9067F, -12.1991F, -1.9045F, 0.8433F, -2.2622F));

		PartDefinition Wire_r58 = Wire4.addOrReplaceChild("Wire_r58", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.4428F, -74.8129F, -9.9975F, -1.8338F, 1.4072F, 2.7232F));

		PartDefinition Wire_r59 = Wire4.addOrReplaceChild("Wire_r59", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.8398F, -83.4636F, 17.9052F, -1.7023F, 0.5732F, -2.8953F));

		PartDefinition Wire_r60 = Wire4.addOrReplaceChild("Wire_r60", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 33.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-63.047F, -84.4196F, 26.9299F, -0.3904F, 0.7529F, -1.8144F));

		PartDefinition Wire_r61 = Wire4.addOrReplaceChild("Wire_r61", CubeListBuilder.create().texOffs(1003, 0).addBox(-0.25F, -0.5F, -1.0F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-73.0542F, -80.0271F, 36.4889F, -0.7854F, 0.45F, -2.338F));

		PartDefinition Wire_r62 = Wire4.addOrReplaceChild("Wire_r62", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-94.3584F, -45.051F, 70.9135F, -0.7026F, 0.0919F, -2.6721F));

		PartDefinition Wire_r63 = Wire4.addOrReplaceChild("Wire_r63", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-95.662F, -37.8414F, 75.223F, -0.5327F, -0.0578F, -2.9287F));

		PartDefinition Wire_r64 = Wire4.addOrReplaceChild("Wire_r64", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 21.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-81.8473F, -23.2072F, 71.3188F, 0.1945F, 0.1722F, 2.4187F));

		PartDefinition Wire_r65 = Wire4.addOrReplaceChild("Wire_r65", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-66.0229F, 6.1519F, 84.8698F, -0.3897F, 0.1361F, 2.5916F));

		PartDefinition Wire_r66 = Wire4.addOrReplaceChild("Wire_r66", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.5F, -1.0F, 2.0F, 36.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.0443F, 8.1478F, 95.1051F, -0.2882F, -0.1647F, 1.6764F));

		PartDefinition Wire_r67 = Wire4.addOrReplaceChild("Wire_r67", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 39.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6825F, 4.1675F, 82.7863F, 0.3405F, -0.243F, 1.3748F));

		PartDefinition Wire_r68 = Wire4.addOrReplaceChild("Wire_r68", CubeListBuilder.create().texOffs(1003, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 53.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(34.2926F, -37.5162F, 67.0396F, 0.2994F, -0.0662F, 0.5972F));

		PartDefinition Bulbs4 = Wire4.addOrReplaceChild("Bulbs4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Bulb67 = Bulbs4.addOrReplaceChild("Bulb67", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0322F, -27.5411F, 70.75F, 0.0F, 0.0F, -1.4835F));

		PartDefinition Bulb68 = Bulbs4.addOrReplaceChild("Bulb68", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.6593F, -20.4649F, 73.9216F, 1.4149F, -0.1586F, -1.1712F));

		PartDefinition Bulb69 = Bulbs4.addOrReplaceChild("Bulb69", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.2102F, -7.9315F, 78.0174F, -1.0722F, -0.1586F, -1.1712F));

		PartDefinition Bulb70 = Bulbs4.addOrReplaceChild("Bulb70", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3713F, 1.7982F, 81.7001F, 0.643F, -0.6594F, -0.7831F));

		PartDefinition Bulb71 = Bulbs4.addOrReplaceChild("Bulb71", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.3339F, 6.5825F, 88.6611F, -0.6255F, 0.8786F, -0.3497F));

		PartDefinition Bulb72 = Bulbs4.addOrReplaceChild("Bulb72", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-38.3142F, 8.1166F, 92.8002F, -0.6255F, 0.8786F, -0.3497F));

		PartDefinition Bulb73 = Bulbs4.addOrReplaceChild("Bulb73", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-59.1329F, 6.7037F, 86.9836F, 1.9386F, 0.7167F, 1.974F));

		PartDefinition Bulb74 = Bulbs4.addOrReplaceChild("Bulb74", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-71.4741F, -2.7231F, 80.7925F, -0.4727F, 0.8472F, 0.4934F));

		PartDefinition Bulb75 = Bulbs4.addOrReplaceChild("Bulb75", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-78.1776F, -16.4219F, 75.0125F, 0.2785F, 0.4213F, 1.3988F));

		PartDefinition Bulb76 = Bulbs4.addOrReplaceChild("Bulb76", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-91.9278F, -33.7056F, 73.9144F, -0.6515F, 0.4724F, 0.4248F));

		PartDefinition Bulb77 = Bulbs4.addOrReplaceChild("Bulb77", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-88.012F, -55.7323F, 61.4048F, 0.6151F, 0.5216F, 2.4143F));

		PartDefinition Bulb78 = Bulbs4.addOrReplaceChild("Bulb78", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-82.8521F, -63.4674F, 53.1863F, -1.541F, 0.7115F, 0.9309F));

		PartDefinition Bulb79 = Bulbs4.addOrReplaceChild("Bulb79", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-70.9502F, -81.6844F, 33.7574F, -1.541F, 0.7115F, 0.9309F));

		PartDefinition Bulb80 = Bulbs4.addOrReplaceChild("Bulb80", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.3095F, -84.0194F, 21.4649F, 0.7525F, 1.3814F, -2.3481F));

		PartDefinition Bulb81 = Bulbs4.addOrReplaceChild("Bulb81", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.6367F, -81.8049F, 11.0327F, -1.186F, 1.196F, 1.9631F));

		PartDefinition Bulb82 = Bulbs4.addOrReplaceChild("Bulb82", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.5764F, -74.5962F, -9.5028F, -1.8274F, 0.575F, 0.9591F));

		PartDefinition Bulb83 = Bulbs4.addOrReplaceChild("Bulb83", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1961F, -75.3611F, -14.7812F, -2.8077F, 0.1255F, 0.7778F));

		PartDefinition Bulb84 = Bulbs4.addOrReplaceChild("Bulb84", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4221F, -56.4147F, -29.1454F, -1.7093F, 1.064F, 1.4024F));

		PartDefinition Bulb85 = Bulbs4.addOrReplaceChild("Bulb85", CubeListBuilder.create().texOffs(1013, 13).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 12).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 13).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.8558F, -41.8989F, -34.8168F, -3.1363F, 1.2396F, 2.3107F));

		PartDefinition Bulb86 = Bulbs4.addOrReplaceChild("Bulb86", CubeListBuilder.create().texOffs(1013, 19).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 18).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 19).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.8019F, -30.5924F, -23.3254F, 0.4752F, 1.2038F, -0.8403F));

		PartDefinition Bulb87 = Bulbs4.addOrReplaceChild("Bulb87", CubeListBuilder.create().texOffs(1013, 1).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 0).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 1).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4694F, -10.9694F, -4.0424F, -0.2532F, 0.5971F, -0.4012F));

		PartDefinition Bulb88 = Bulbs4.addOrReplaceChild("Bulb88", CubeListBuilder.create().texOffs(1013, 7).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1011, 6).addBox(-1.5F, 1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(1013, 7).addBox(-1.0F, 4.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.7871F, -0.3931F, 9.1222F, -0.995F, 0.5971F, -0.4012F));

		PartDefinition Star = XmasLights.addOrReplaceChild("Star", CubeListBuilder.create().texOffs(1006, 55).addBox(-3.5F, -4.75F, -0.99F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -166.0F, 0.0F));

		PartDefinition Ah = Star.addOrReplaceChild("Ah", CubeListBuilder.create().texOffs(1006, 55).addBox(-3.0F, -2.0F, -1.01F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-2.0F, -4.0F, -1.01F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.5F, -6.0F, -1.01F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.0F, -8.0F, -1.01F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-0.5F, -10.0F, -1.01F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.75F, 0.0F));

		PartDefinition Ah2 = Star.addOrReplaceChild("Ah2", CubeListBuilder.create().texOffs(1006, 55).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-2.0F, -4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.5F, -6.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-0.5F, -10.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1915F, -2.6607F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition Ah3 = Star.addOrReplaceChild("Ah3", CubeListBuilder.create().texOffs(1006, 55).mirror().addBox(-3.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-2.0F, -4.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-1.5F, -6.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-1.0F, -8.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-0.5F, -10.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.2048F, -2.6434F, 0.0F, 0.0F, 0.0F, -0.9599F));

		PartDefinition Ah4 = Star.addOrReplaceChild("Ah4", CubeListBuilder.create().texOffs(1006, 55).mirror().addBox(-3.0F, 0.0F, -1.01F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-2.0F, 2.0F, -1.01F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-1.5F, 4.0F, -1.01F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-1.0F, 6.0F, -1.01F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(1006, 55).mirror().addBox(-0.5F, 8.0F, -1.01F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Ah5 = Star.addOrReplaceChild("Ah5", CubeListBuilder.create().texOffs(1006, 55).addBox(-3.0F, 0.0F, -1.01F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-2.0F, 2.0F, -1.01F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.5F, 4.0F, -1.01F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-1.0F, 6.0F, -1.01F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(1006, 55).addBox(-0.5F, 8.0F, -1.01F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.7418F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		XmasLights.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}