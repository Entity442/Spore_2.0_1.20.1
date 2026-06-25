package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.AnimationTrackers.TerroriserReloadAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.TerroriserShootAnimationTracker;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class ToxicTerroriserModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "toxicterroriserarmmodel"), "main");
	public final ModelPart Terrorrizer;
	private final ModelPart barrel;
	private final ModelPart skull;
	private final ModelPart s_jaw;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart h_jaw;
	private final ModelPart vial;
	private final ModelPart LeftLung;
	private final ModelPart RightLung;
	private final ModelPart grip;
	private final ModelPart tumor;
	private final ModelPart tumorE3;
	private final ModelPart tumorE2;
	private final ModelPart tumorE1;

	public ToxicTerroriserModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Terrorrizer = root.getChild("Terrorrizer");
		this.barrel = this.Terrorrizer.getChild("barrel");
		this.skull = this.barrel.getChild("skull");
		this.s_jaw = this.skull.getChild("s_jaw");
		this.body = this.Terrorrizer.getChild("body");
		this.head = this.body.getChild("head");
		this.h_jaw = this.head.getChild("h_jaw");
		this.vial = this.head.getChild("vial");
		this.LeftLung = this.body.getChild("LeftLung");
		this.RightLung = this.body.getChild("RightLung");
		this.grip = this.Terrorrizer.getChild("grip");
		this.tumor = this.Terrorrizer.getChild("tumor");
		this.tumorE3 = this.tumor.getChild("tumorE3");
		this.tumorE2 = this.tumor.getChild("tumorE2");
		this.tumorE1 = this.tumor.getChild("tumorE1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Terrorrizer = partdefinition.addOrReplaceChild("Terrorrizer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition barrel = Terrorrizer.addOrReplaceChild("barrel", CubeListBuilder.create().texOffs(98, 105).addBox(0.0F, -8.0F, -11.0F, 0.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(0, 60).addBox(-1.0F, -12.0F, -19.0F, 2.0F, 1.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = barrel.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r2 = barrel.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, -6.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r3 = barrel.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, -10.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r4 = barrel.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -14.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r5 = barrel.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, -14.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r6 = barrel.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -14.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r7 = barrel.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -18.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r8 = barrel.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, -18.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r9 = barrel.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -18.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r10 = barrel.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -10.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r11 = barrel.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 1.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r12 = barrel.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -2.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r13 = barrel.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(128, 62).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -6.5F, -0.0812F, 0.1546F, 1.0845F));

		PartDefinition cube_r14 = barrel.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -10.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r15 = barrel.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -6.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r16 = barrel.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -2.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r17 = barrel.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(128, 66).addBox(0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 1.5F, -0.0812F, -0.1546F, -1.0845F));

		PartDefinition cube_r18 = barrel.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 126).addBox(0.0F, -2.0F, 0.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -12.0F, 1.5F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r19 = barrel.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(92, 77).addBox(-6.0F, 0.0F, -10.0F, 6.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -3.0F, 0.0F, 0.0F, -1.0472F));

		PartDefinition cube_r20 = barrel.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(92, 91).addBox(0.0F, 0.0F, -10.0F, 6.0F, 0.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.0F, -3.0F, 0.0F, 0.0F, 1.0472F));

		PartDefinition cube_r21 = barrel.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -21.0F, 3.0F, 3.0F, 27.0F, new CubeDeformation(0.0F))
				.texOffs(92, 59).addBox(-1.0F, -2.0F, -36.0F, 3.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.25F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r22 = barrel.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(120, 105).addBox(-2.0F, -2.0F, -8.0F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -33.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition skull = barrel.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(38, 97).addBox(-7.0F, -6.0F, -7.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 104).addBox(-6.5F, 0.0F, -6.5F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.0F, -20.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition s_jaw = skull.addOrReplaceChild("s_jaw", CubeListBuilder.create().texOffs(100, 28).addBox(-7.09F, 0.1391F, -8.122F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(70, 105).addBox(-6.59F, -2.8609F, -7.622F, 7.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -0.75F, 0.5F, 1.0472F, 0.0F, 0.0F));

		PartDefinition body = Terrorrizer.addOrReplaceChild("body", CubeListBuilder.create().texOffs(100, 38).addBox(-1.0F, -15.25F, 5.5F, 2.0F, 2.0F, 11.0F, new CubeDeformation(0.0F))
				.texOffs(54, 60).addBox(-2.0F, -13.4F, 5.65F, 4.0F, 4.0F, 15.0F, new CubeDeformation(-0.01F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(60, 21).addBox(0.0F, -3.0F, -8.0F, 7.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -15.25F, 12.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition cube_r24 = body.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(78, 115).addBox(-2.0F, -4.0F, -4.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 19.0F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r25 = body.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(28, 120).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -12.0F, 5.0F, 0.6634F, 0.203F, 0.5965F));

		PartDefinition cube_r26 = body.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(56, 115).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -12.0F, 5.0F, 0.6661F, -0.1726F, -0.6577F));

		PartDefinition cube_r27 = body.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(78, 125).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 18.0F, 0.1893F, -0.538F, -0.3578F));

		PartDefinition cube_r28 = body.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(124, 51).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 18.0F, 0.1893F, 0.538F, 0.3578F));

		PartDefinition cube_r29 = body.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(60, 40).addBox(-3.0F, -3.5F, -7.0F, 7.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3581F, -14.3083F, 11.0F, 0.0F, 0.0F, 2.6616F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(100, 14).addBox(-5.0F, -6.0F, -1.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(28, 111).addBox(-4.5F, -7.0F, -0.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -9.0F, 20.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition h_jaw = head.addOrReplaceChild("h_jaw", CubeListBuilder.create().texOffs(0, 114).addBox(-3.5F, -2.0F, -0.5F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(100, 51).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.0F, 0.0F, 2.0944F, 0.0F, 0.0F));

		PartDefinition vial = head.addOrReplaceChild("vial", CubeListBuilder.create().texOffs(160, 0).addBox(-7.0F, -12.0F, -1.0F, 16.0F, 16.0F, 0.0F, new CubeDeformation(-3.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 2.75F, -2.7486F, 0.0403F, -3.1249F));

		PartDefinition LeftLung = body.addOrReplaceChild("LeftLung", CubeListBuilder.create(), PartPose.offset(3.25F, -13.25F, 5.0F));

		PartDefinition cube_r30 = LeftLung.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(54, 79).addBox(0.0F, -3.0F, -8.0F, 6.0F, 5.0F, 13.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.75F, -1.25F, 7.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition RightLung = body.addOrReplaceChild("RightLung", CubeListBuilder.create(), PartPose.offset(-3.6081F, -13.5583F, 5.0F));

		PartDefinition cube_r31 = RightLung.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 86).addBox(-3.0F, -2.5F, -7.0F, 6.0F, 5.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 2.6616F));

		PartDefinition grip = Terrorrizer.addOrReplaceChild("grip", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, -9.5F, -16.0F, 2.0F, 2.0F, 28.0F, new CubeDeformation(0.0F))
				.texOffs(60, 0).addBox(-1.5F, -10.0F, 1.0F, 3.0F, 4.0F, 17.0F, new CubeDeformation(-0.01F))
				.texOffs(100, 0).addBox(-1.99F, -9.0F, 5.75F, 4.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(18, 123).addBox(0.0F, -7.0F, 10.0F, 0.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r32 = grip.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(28, 104).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 8.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r33 = grip.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(126, 45).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.25F, 2.85F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r34 = grip.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(126, 47).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.25F, 4.85F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r35 = grip.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(56, 113).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, 3.85F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r36 = grip.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(56, 111).addBox(-2.0F, -0.5F, -0.5F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.25F, 1.85F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r37 = grip.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(38, 86).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.75F, 17.75F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r38 = grip.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(120, 114).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.0F, 17.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition tumor = Terrorrizer.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tumorE3 = tumor.addOrReplaceChild("tumorE3", CubeListBuilder.create(), PartPose.offset(-5.0F, -14.0F, 8.0F));

		PartDefinition cube_r39 = tumorE3.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(96, 121).addBox(-4.0F, -2.0F, -1.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -1.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition tumorE2 = tumor.addOrReplaceChild("tumorE2", CubeListBuilder.create(), PartPose.offset(0.0F, -8.75F, 21.0F));

		PartDefinition cube_r40 = tumorE2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(126, 38).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r41 = tumorE2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(70, 97).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, 0.5F, 0.25F, -0.7954F, -0.638F, 0.546F));

		PartDefinition tumorE1 = tumor.addOrReplaceChild("tumorE1", CubeListBuilder.create(), PartPose.offset(5.0F, -11.0F, 13.75F));

		PartDefinition cube_r42 = tumorE1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 123).addBox(-4.0F, -2.0F, -3.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 1.0F, 0.3054F, -0.3927F, 0.1745F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Terrorrizer.getAllParts().forEach(ModelPart::resetPose);
		float lungVal = Mth.sin(ageInTicks/7)/16;
		float tum1 = Mth.sin(ageInTicks/6)/7;
		float tum2 = Mth.cos(ageInTicks/7)/6;
		float tum3 = Mth.sin(ageInTicks/7)/8;
		animateTumor(tumorE1,tum1);
		animateTumor(tumorE2,tum2);
		animateTumor(tumorE3,tum3);
		this.RightLung.xScale = 1 + lungVal;
		this.LeftLung.xScale = 1 + lungVal;
		animateTentacleX(h_jaw,Mth.sin(ageInTicks/6)/8);
		if (entity instanceof Player player){
			float anim = TerroriserShootAnimationTracker.getProgress(player, 0);
			this.Terrorrizer.zRot = -anim * 0.025f;
			this.barrel.z = barrel.z - anim * 2;
			this.animateTentacleX(this.s_jaw,anim * 0.025f);
			this.Terrorrizer.z = this.Terrorrizer.getInitialPose().z +(anim * 3);

			float reloadAnim = TerroriserReloadAnimationTracker.getProgress(player,0);
			this.Terrorrizer.xRot = reloadAnim * 0.25f;
			this.Terrorrizer.y = this.Terrorrizer.getInitialPose().y +(reloadAnim * 3f);

			if (reloadAnim > 0){
				animateTentacleX(h_jaw,Mth.sin(ageInTicks)/4);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Terrorrizer.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}