package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.HiveSpawnBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ReconstructedMindModel<T extends HiveSpawnBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "reconstructedmindmodel"), "main");
	private final ModelPart ReconstructedMind;
	private final ModelPart Brains;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Eye;
	private final ModelPart Pupil;
	private final ModelPart Arms;
	private final ModelPart GrowingArm;
	private final ModelPart GrowingArm2;
	private final ModelPart Body;
	private final ModelPart Head;
	private final ModelPart Jaw;

	public ReconstructedMindModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.ReconstructedMind = root.getChild("ReconstructedMind");
		this.Brains = this.ReconstructedMind.getChild("Brains");
		this.Brain1 = this.Brains.getChild("Brain1");
		this.Brain2 = this.Brains.getChild("Brain2");
		this.Brain3 = this.Brains.getChild("Brain3");
		this.Eye = this.ReconstructedMind.getChild("Eye");
		this.Pupil = this.Eye.getChild("Pupil");
		this.Arms = this.ReconstructedMind.getChild("Arms");
		this.GrowingArm = this.Arms.getChild("GrowingArm");
		this.GrowingArm2 = this.Arms.getChild("GrowingArm2");
		this.Body = this.ReconstructedMind.getChild("Body");
		this.Head = this.Body.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ReconstructedMind = partdefinition.addOrReplaceChild("ReconstructedMind", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Brains = ReconstructedMind.addOrReplaceChild("Brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain1 = Brains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(70, 57).addBox(-2.1927F, -7.43F, -3.653F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(74, 28).addBox(1.3073F, -7.43F, -3.653F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(74, 14).addBox(-3.1927F, -7.43F, -3.653F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.0974F, -6.9588F, -0.864F, 0.1631F, -0.1095F, -0.1919F));

		PartDefinition Brain2 = Brains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(74, 0).addBox(-3.1538F, -7.4029F, -3.5112F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(75, 85).addBox(0.3462F, -7.4029F, -3.5112F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(52, 85).addBox(-4.1538F, -7.4029F, -3.5112F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.5027F, -6.2588F, -1.464F, 0.2438F, 0.2135F, 0.2007F));

		PartDefinition Brain3 = Brains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(70, 71).addBox(-2.3915F, -7.2383F, -5.079F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(29, 82).addBox(1.1085F, -7.2383F, -5.079F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 84).addBox(-3.3915F, -7.2383F, -5.079F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.5027F, -5.8588F, 3.436F, -0.4793F, 0.2653F, -0.1143F));

		PartDefinition Eye = ReconstructedMind.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(37, 57).addBox(-4.0F, -9.9151F, -3.607F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1076F, -4.6743F, -11.3F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Pupil = Eye.addOrReplaceChild("Pupil", CubeListBuilder.create().texOffs(98, 85).addBox(-2.5F, -8.4151F, -4.357F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = ReconstructedMind.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition GrowingArm = Arms.addOrReplaceChild("GrowingArm", CubeListBuilder.create().texOffs(63, 99).addBox(0.5422F, -2.4532F, -1.7374F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.8882F, -9.8196F, 1.7509F, -0.175F, 0.0688F, -0.6666F));

		PartDefinition Tumor_r1 = GrowingArm.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(74, 50).addBox(-2.6166F, -4.5324F, 2.0018F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1232F, 3.7744F, -2.7933F, -0.581F, -0.9591F, 1.6302F));

		PartDefinition Tumor_r2 = GrowingArm.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(0, 98).addBox(-0.4938F, -4.3771F, -0.641F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3768F, 1.9744F, -2.7933F, -0.7813F, -1.2323F, 1.8668F));

		PartDefinition Tumor_r3 = GrowingArm.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(97, 31).addBox(0.12F, -2.1033F, -1.7561F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.2663F, 0.0553F, 0.2067F));

		PartDefinition Tip2_r1 = GrowingArm.addOrReplaceChild("Tip2_r1", CubeListBuilder.create().texOffs(52, 99).addBox(1.3122F, -4.4205F, -1.7283F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.384F, 0.433F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition GrowingArm2 = Arms.addOrReplaceChild("GrowingArm2", CubeListBuilder.create().texOffs(99, 64).addBox(0.8032F, -1.9751F, -2.4069F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8118F, -7.4196F, -9.1491F, 2.8195F, 0.2147F, -2.3111F));

		PartDefinition Tumor_r4 = GrowingArm2.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(87, 50).addBox(-2.8995F, -4.3554F, 1.2058F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8232F, 4.2744F, -2.7933F, -0.581F, -0.9591F, 1.6302F));

		PartDefinition Tumor_r5 = GrowingArm2.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(98, 92).addBox(-1.1495F, -4.1054F, -1.7942F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1768F, 0.5744F, -2.7933F, -0.581F, -0.9591F, 1.6302F));

		PartDefinition Tumor_r6 = GrowingArm2.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(97, 22).addBox(0.51F, -1.5327F, -2.273F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, -0.2663F, 0.0553F, 0.2067F));

		PartDefinition Tip2_r2 = GrowingArm2.addOrReplaceChild("Tip2_r2", CubeListBuilder.create().texOffs(99, 57).addBox(1.2992F, -3.8759F, -2.3978F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.384F, 0.433F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition Body = ReconstructedMind.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Fungus_r1 = Body.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(97, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6F, -5.35F, -9.75F, 0.3918F, -0.5255F, -0.1877F));

		PartDefinition Fungus_r2 = Body.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(0, 76).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.7F, -7.75F, 2.75F, 0.1342F, -0.3194F, 0.0538F));

		PartDefinition Fungus_r3 = Body.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(74, 42).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, -7.05F, 9.95F, -0.1562F, -0.6232F, -0.1621F));

		PartDefinition Fungus_r4 = Body.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(23, 96).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.9F, -8.35F, 3.45F, 0.2381F, -0.1994F, -0.3087F));

		PartDefinition Fungus_r5 = Body.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(37, 74).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6F, -6.35F, -7.75F, 0.2409F, -0.2502F, -0.3215F));

		PartDefinition Biomass_r1 = Body.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(0, 19).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0591F, -6.8258F, 0.3608F, 0.7482F, -1.4737F, -0.8467F));

		PartDefinition Biomass_r2 = Body.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(37, 38).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1591F, -4.8258F, -8.8392F, 1.0736F, -1.2378F, -1.1751F));

		PartDefinition Biomass_r3 = Body.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(0, 57).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2591F, -4.8258F, 3.9608F, -0.4839F, -0.9572F, 0.5551F));

		PartDefinition Biomass_r4 = Body.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(0, 38).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0409F, -4.2258F, 1.8608F, -0.0488F, -0.9399F, 0.2699F));

		PartDefinition Biomass_r5 = Body.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6591F, -4.8258F, 0.0608F, 1.967F, -1.5225F, -1.6237F));

		PartDefinition Biomass_r6 = Body.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(37, 19).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3591F, -4.8258F, -4.4392F, 0.4155F, -1.0414F, -0.4748F));

		PartDefinition Biomass_r7 = Body.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(37, 0).addBox(-4.5F, -4.5F, -4.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5409F, -4.8258F, -4.3392F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Head = Body.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(-2.2192F, -6.7848F, 6.8833F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(97, 39).addBox(-5.5F, -3.0F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -2.047F, -0.4158F, -0.1332F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(4.414F, 2.0994F, -19.0278F));

		PartDefinition Jaw_r1 = Jaw.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(91, 70).addBox(-3.9704F, -0.109F, -5.0801F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, -0.2083F, -0.3534F, -0.3449F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		ReconstructedMind.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {

	}
}