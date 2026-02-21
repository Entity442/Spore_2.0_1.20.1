package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.OvergrownSpawnerEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class InfestedSpawnerModel<T extends OvergrownSpawnerEntity> extends BlockEntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "infested_spawner"), "main");
	private final ModelPart InfestedSpawnerRemodel;
	private final ModelPart BiomassCore;
	private final ModelPart BiomassBase;
	private final ModelPart Hearts;
	private final ModelPart Heart;
	private final ModelPart Heart2;
	private final ModelPart Tendrils;
	private final ModelPart Tendril5;
	private final ModelPart TendrilTip5;
	private final ModelPart BigTendril;
	private final ModelPart TendrilMidCenter;
	private final ModelPart TendrilTip4;
	private final ModelPart Tendril3;
	private final ModelPart TendrilTip3;
	private final ModelPart Tendril2;
	private final ModelPart TendrilTip2;
	private final ModelPart Tendril;
	private final ModelPart TendrilTip;
	private final ModelPart MyceliumVeins;
	private final ModelPart InfestedSpawnerBase;
	private final ModelPart TumourGrowths;
	private final ModelPart Tumor;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart TumourGrowth3;
	private final ModelPart FungusFlower;
	private final ModelPart TumourGrowth2;
	private final ModelPart TumourGrowth;

	public InfestedSpawnerModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.InfestedSpawnerRemodel = root.getChild("InfestedSpawnerRemodel");
		this.BiomassCore = this.InfestedSpawnerRemodel.getChild("BiomassCore");
		this.BiomassBase = this.BiomassCore.getChild("BiomassBase");
		this.Hearts = this.BiomassCore.getChild("Hearts");
		this.Heart = this.Hearts.getChild("Heart");
		this.Heart2 = this.Hearts.getChild("Heart2");
		this.Tendrils = this.BiomassCore.getChild("Tendrils");
		this.Tendril5 = this.Tendrils.getChild("Tendril5");
		this.TendrilTip5 = this.Tendril5.getChild("TendrilTip5");
		this.BigTendril = this.Tendrils.getChild("BigTendril");
		this.TendrilMidCenter = this.BigTendril.getChild("TendrilMidCenter");
		this.TendrilTip4 = this.TendrilMidCenter.getChild("TendrilTip4");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.TendrilTip3 = this.Tendril3.getChild("TendrilTip3");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.TendrilTip2 = this.Tendril2.getChild("TendrilTip2");
		this.Tendril = this.Tendrils.getChild("Tendril");
		this.TendrilTip = this.Tendril.getChild("TendrilTip");
		this.MyceliumVeins = this.InfestedSpawnerRemodel.getChild("MyceliumVeins");
		this.InfestedSpawnerBase = this.InfestedSpawnerRemodel.getChild("InfestedSpawnerBase");
		this.TumourGrowths = this.InfestedSpawnerBase.getChild("TumourGrowths");
		this.Tumor = this.TumourGrowths.getChild("Tumor");
		this.Tumor2 = this.TumourGrowths.getChild("Tumor2");
		this.Tumor3 = this.TumourGrowths.getChild("Tumor3");
		this.TumourGrowth3 = this.TumourGrowths.getChild("TumourGrowth3");
		this.FungusFlower = this.TumourGrowth3.getChild("FungusFlower");
		this.TumourGrowth2 = this.TumourGrowths.getChild("TumourGrowth2");
		this.TumourGrowth = this.TumourGrowths.getChild("TumourGrowth");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition InfestedSpawnerRemodel = partdefinition.addOrReplaceChild("InfestedSpawnerRemodel", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition BiomassCore = InfestedSpawnerRemodel.addOrReplaceChild("BiomassCore", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BiomassBase = BiomassCore.addOrReplaceChild("BiomassBase", CubeListBuilder.create(), PartPose.offset(0.5F, -8.5F, -0.1F));

		PartDefinition cube_r1 = BiomassBase.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 1.5F, -0.0401F, 0.1382F, -0.0401F));

		PartDefinition cube_r2 = BiomassBase.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 3.5F, -0.6F, -0.1571F, 0.0873F, 0.1396F));

		PartDefinition cube_r3 = BiomassBase.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.5F, 0.5F, -0.1762F, -0.1375F, -0.1676F));

		PartDefinition cube_r4 = BiomassBase.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 1.0F, -0.3F, 0.0F, -0.0349F, -0.1222F));

		PartDefinition cube_r5 = BiomassBase.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.8F, -0.9F, 0.2956F, 0.3567F, -0.0392F));

		PartDefinition Hearts = BiomassCore.addOrReplaceChild("Hearts", CubeListBuilder.create(), PartPose.offset(0.0F, -9.2F, 0.0F));

		PartDefinition Heart = Hearts.addOrReplaceChild("Heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.8F, -0.8F, -0.3F, -0.4079F, -0.0883F, -0.1399F));

		PartDefinition cube_r6 = Heart.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(49, 47).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6099F, -0.615F, -0.1329F, -0.1582F, 0.1207F, -0.9268F));

		PartDefinition cube_r7 = Heart.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(5, 49).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9099F, -1.315F, -0.1329F, -0.2928F, 0.2828F, -0.4633F));

		PartDefinition cube_r8 = Heart.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(43, 40).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.1901F, 1.385F, 0.5671F, 0.0061F, -0.5331F, 0.3303F));

		PartDefinition cube_r9 = Heart.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(43, 33).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8099F, 1.085F, 0.1671F, 0.3617F, 0.1048F, 0.4491F));

		PartDefinition cube_r10 = Heart.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(13, 43).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8099F, -0.615F, 0.5671F, -0.1097F, 0.3252F, 0.6357F));

		PartDefinition cube_r11 = Heart.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.3099F, 0.685F, 0.3671F, 0.0984F, -0.2383F, -0.0797F));

		PartDefinition cube_r12 = Heart.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(30, 40).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8099F, 1.985F, 1.0671F, -0.024F, 0.0003F, 0.1715F));

		PartDefinition cube_r13 = Heart.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(30, 33).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.8099F, 2.585F, 0.8671F, 0.1407F, -0.121F, -0.3487F));

		PartDefinition Heart2 = Hearts.addOrReplaceChild("Heart2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5F, 0.8F, -2.5F, 0.1297F, 0.9569F, 0.9681F));

		PartDefinition cube_r14 = Heart2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(49, 47).addBox(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0259F, 0.0384F, -0.0253F, -0.1582F, 0.1207F, -0.9268F));

		PartDefinition cube_r15 = Heart2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(5, 49).addBox(0.0F, -3.0F, -1.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3258F, -0.6616F, -0.0253F, -0.2928F, 0.2828F, -0.4633F));

		PartDefinition cube_r16 = Heart2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(43, 40).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.2258F, 2.0384F, 0.6747F, 0.0061F, -0.5331F, 0.3303F));

		PartDefinition cube_r17 = Heart2.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(43, 33).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2258F, 1.7384F, 0.2747F, 0.3617F, 0.1048F, 0.4491F));

		PartDefinition cube_r18 = Heart2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(13, 43).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2258F, 0.0384F, 0.6747F, -0.1097F, 0.3252F, 0.6357F));

		PartDefinition cube_r19 = Heart2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.7259F, 1.3384F, 0.4747F, 0.0984F, -0.2383F, -0.0797F));

		PartDefinition cube_r20 = Heart2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(30, 40).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2258F, 2.6384F, 1.1747F, -0.024F, 0.0003F, 0.1715F));

		PartDefinition cube_r21 = Heart2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(30, 33).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.2258F, 3.2384F, 0.9747F, 0.1407F, -0.121F, -0.3487F));

		PartDefinition Tendrils = BiomassCore.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(0.0F, -8.6F, 0.0F));

		PartDefinition Tendril5 = Tendrils.addOrReplaceChild("Tendril5", CubeListBuilder.create(), PartPose.offset(2.2F, -0.9F, 2.2F));

		PartDefinition cube_r22 = Tendril5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(35, 47).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5621F, 0.4704F, -0.2606F));

		PartDefinition TendrilTip5 = Tendril5.addOrReplaceChild("TendrilTip5", CubeListBuilder.create(), PartPose.offset(-0.4F, -4.5F, 1.6F));

		PartDefinition cube_r23 = TendrilTip5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3554F, -0.3069F, 1.4029F));

		PartDefinition BigTendril = Tendrils.addOrReplaceChild("BigTendril", CubeListBuilder.create(), PartPose.offset(1.8F, 2.4F, -2.2F));

		PartDefinition cube_r24 = BigTendril.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(17, 33).addBox(-1.0F, -5.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4F, -1.2F, -0.4F, 2.7509F, -0.1968F, -0.2001F));

		PartDefinition TendrilMidCenter = BigTendril.addOrReplaceChild("TendrilMidCenter", CubeListBuilder.create(), PartPose.offset(0.0F, 3.1F, -2.2F));

		PartDefinition cube_r25 = TendrilMidCenter.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(26, 47).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.9218F, 0.0108F, 0.0508F));

		PartDefinition TendrilTip4 = TendrilMidCenter.addOrReplaceChild("TendrilTip4", CubeListBuilder.create(), PartPose.offset(-0.8F, 1.7F, 5.4F));

		PartDefinition cube_r26 = TendrilTip4.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(44, 47).addBox(0.0F, -7.0F, 0.0F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.7403F, 0.9F, -0.1795F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offset(-1.4F, 1.6F, 1.4F));

		PartDefinition cube_r27 = Tendril3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(35, 47).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.0246F, -0.6528F, 0.2131F));

		PartDefinition TendrilTip3 = Tendril3.addOrReplaceChild("TendrilTip3", CubeListBuilder.create(), PartPose.offset(-2.5F, -3.5F, 3.6F));

		PartDefinition cube_r28 = TendrilTip3.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.8801F, 1.0228F, -0.3725F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offset(1.2F, -0.9F, -2.2F));

		PartDefinition cube_r29 = Tendril2.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(35, 47).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3675F, 0.3109F, 0.5012F));

		PartDefinition TendrilTip2 = Tendril2.addOrReplaceChild("TendrilTip2", CubeListBuilder.create(), PartPose.offset(0.9F, -5.0F, -1.6F));

		PartDefinition cube_r30 = TendrilTip2.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7724F, 0.2212F, 1.6546F));

		PartDefinition Tendril = Tendrils.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offset(-0.6F, 1.0F, -2.2F));

		PartDefinition cube_r31 = Tendril.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(35, 47).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 2.7904F, 0.1942F, 0.3334F));

		PartDefinition TendrilTip = Tendril.addOrReplaceChild("TendrilTip", CubeListBuilder.create(), PartPose.offset(-1.7F, 3.3F, -1.9F));

		PartDefinition cube_r32 = TendrilTip.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(0, 49).addBox(0.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -2.1002F, 0.266F, 0.7246F));

		PartDefinition MyceliumVeins = InfestedSpawnerRemodel.addOrReplaceChild("MyceliumVeins", CubeListBuilder.create().texOffs(57, 34).addBox(3.3F, -9.0F, -4.2F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition MyceliumVein_r1 = MyceliumVeins.addOrReplaceChild("MyceliumVein_r1", CubeListBuilder.create().texOffs(57, 34).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 0.0F, 3.5F, 0.1745F, 0.0F, 0.0F));

		PartDefinition MyceliumVein_r2 = MyceliumVeins.addOrReplaceChild("MyceliumVein_r2", CubeListBuilder.create().texOffs(57, 34).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3F, 0.5F, 1.8F, 2.7751F, -1.2566F, 3.1416F));

		PartDefinition MyceliumVein_r3 = MyceliumVeins.addOrReplaceChild("MyceliumVein_r3", CubeListBuilder.create().texOffs(57, 34).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.2F, -4.1F, -0.1722F, 0.1904F, 0.0953F));

		PartDefinition MyceliumVein_r4 = MyceliumVeins.addOrReplaceChild("MyceliumVein_r4", CubeListBuilder.create().texOffs(57, 34).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8F, -0.3F, 4.6F, 0.3691F, -0.7029F, 0.1632F));

		PartDefinition MyceliumVein_r5 = MyceliumVeins.addOrReplaceChild("MyceliumVein_r5", CubeListBuilder.create().texOffs(57, 34).addBox(-1.0F, -9.0F, -1.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4F, 0.0F, -1.4F, -2.4823F, -1.43F, 2.5657F));

		PartDefinition InfestedSpawnerBase = InfestedSpawnerRemodel.addOrReplaceChild("InfestedSpawnerBase", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TumourGrowths = InfestedSpawnerBase.addOrReplaceChild("TumourGrowths", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor = TumourGrowths.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(6.2F, -4.2F, 7.5F));

		PartDefinition Tumour_r1 = Tumor.addOrReplaceChild("Tumour_r1", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0146F, -0.3637F, 0.2842F));

		PartDefinition Tumor2 = TumourGrowths.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offset(3.2F, -13.7F, 1.4F));

		PartDefinition Tumour_r2 = Tumor2.addOrReplaceChild("Tumour_r2", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4114F, 0.4904F, -0.0524F));

		PartDefinition Tumor3 = TumourGrowths.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offset(-7.1F, -2.4F, 1.1F));

		PartDefinition Fungus_r1 = Tumor3.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -2.9F, 2.3F, -0.0598F, 0.3105F, -0.3005F));

		PartDefinition Tumour_r3 = Tumor3.addOrReplaceChild("Tumour_r3", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.0349F, -0.1222F));

		PartDefinition TumourGrowth3 = TumourGrowths.addOrReplaceChild("TumourGrowth3", CubeListBuilder.create(), PartPose.offset(-6.4F, -14.9F, -5.0F));

		PartDefinition Tumour_r4 = TumourGrowth3.addOrReplaceChild("Tumour_r4", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 1.3F, 2.7F, -0.1486F, 0.1106F, -0.2137F));

		PartDefinition Tumour_r5 = TumourGrowth3.addOrReplaceChild("Tumour_r5", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 2.3F, 0.4F, 0.111F, -0.2613F, -0.2982F));

		PartDefinition Tumour_r6 = TumourGrowth3.addOrReplaceChild("Tumour_r6", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 1.6F, -0.6F, 0.1185F, 0.2258F, 0.1005F));

		PartDefinition FungusFlower = TumourGrowth3.addOrReplaceChild("FungusFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4F, -1.8F, 2.8F, 0.1932F, 0.0813F, -0.3935F));

		PartDefinition Fungus_r2 = FungusFlower.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6F, -1.6F, -0.3F, 0.0F, 0.0F, -0.3665F));

		PartDefinition Fungus_r3 = FungusFlower.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7F, -0.3F, -3.4F, -0.5411F, 0.0F, 0.0F));

		PartDefinition Fungus_r4 = FungusFlower.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -2.0F, 2.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Fungus_r5 = FungusFlower.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5061F));

		PartDefinition TumourGrowth2 = TumourGrowths.addOrReplaceChild("TumourGrowth2", CubeListBuilder.create(), PartPose.offset(7.1F, -10.4F, -6.8F));

		PartDefinition Tumour_r7 = TumourGrowth2.addOrReplaceChild("Tumour_r7", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.4F, 0.6F, 0.5F, 0.0F, -0.0349F, -0.1222F));

		PartDefinition Tumour_r8 = TumourGrowth2.addOrReplaceChild("Tumour_r8", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 2.5F, 0.1F, 0.2181F, 0.2803F, 0.1196F));

		PartDefinition TumourGrowth = TumourGrowths.addOrReplaceChild("TumourGrowth", CubeListBuilder.create(), PartPose.offset(-3.2F, -9.4F, 8.1F));

		PartDefinition Fungus_r6 = TumourGrowth.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.2F, 4.4F, -0.1555F, -0.2965F, -0.0107F));

		PartDefinition Fungus_r7 = TumourGrowth.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(6, 51).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7F, -1.3F, 4.2F, -0.0759F, 0.0972F, 0.1253F));

		PartDefinition Tumour_r9 = TumourGrowth.addOrReplaceChild("Tumour_r9", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.8F, 1.7F, -0.8F, -0.2538F, 0.5439F, -0.0536F));

		PartDefinition Tumour_r10 = TumourGrowth.addOrReplaceChild("Tumour_r10", CubeListBuilder.create().texOffs(0, 33).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, -0.4F, 0.0F, -0.3142F, -0.1222F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	public void animateHearts(ModelPart part,float val){
		part.xScale = 1 + val;
		part.yScale = 1 + val;
		part.zScale = 1 - val;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		InfestedSpawnerRemodel.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		animateHearts(Heart,Mth.sin(ageInTicks/6)/7);
		animateHearts(Heart2,Mth.cos(ageInTicks/6)/6);
		animateTumor(Tumor,Mth.sin(ageInTicks/7)/6);
		animateTumor(Tumor2,Mth.cos(ageInTicks/5)/8);
		animateTumor(Tumor3,Mth.sin(ageInTicks/7)/5);
		animateTumor(TumourGrowth,Mth.cos(ageInTicks/4)/7);
		animateTumor(TumourGrowth2,Mth.sin(ageInTicks/6)/6);
		animateTumor(TumourGrowth3,Mth.cos(ageInTicks/6)/5);
	}
}