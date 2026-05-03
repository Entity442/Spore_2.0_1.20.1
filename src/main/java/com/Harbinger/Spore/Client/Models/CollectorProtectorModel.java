package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Client.Special.ProtectorBits;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Protector;
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

import java.util.List;

public class CollectorProtectorModel<T extends Protector> extends EntityModel<T> implements TentacledModel, ProtectorBits {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "collectorprotectormodel"), "main");
	private final ModelPart Protector;
	private final ModelPart FullBody;
	private final ModelPart Body;
	private final ModelPart RibHeart;
	private final ModelPart RibCage1;
	private final ModelPart Heart;
	private final ModelPart RibCage2;
	private final ModelPart TumourSack;
	private final ModelPart Arms;
	private final ModelPart ShieldArm;
	private final ModelPart rightArm;
	private final ModelPart rightForArm;
	private final ModelPart shield;
	private final ModelPart ShieldFoliage3;
	private final ModelPart ShieldFoliage2;
	private final ModelPart ShieldFoliage;
	private final ModelPart tumors;
	private final ModelPart LeftArm;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart headWear;
	private final ModelPart HeadShell;
	private final ModelPart Legs;
	private final ModelPart LeftLeg;
	private final ModelPart LeftBoot;
	private final ModelPart RightLeg;
	private final ModelPart RightBoot;
	private final boolean armor;

	public CollectorProtectorModel(ModelPart root, boolean armor) {
		this.Protector = root.getChild("Protector");
        this.armor = armor;
        this.FullBody = this.Protector.getChild("FullBody");
		this.Body = this.FullBody.getChild("Body");
		this.RibHeart = this.Body.getChild("RibHeart");
		this.RibCage1 = this.RibHeart.getChild("RibCage1");
		this.Heart = this.RibHeart.getChild("Heart");
		this.RibCage2 = this.RibHeart.getChild("RibCage2");
		this.TumourSack = this.Body.getChild("TumourSack");
		this.Arms = this.FullBody.getChild("Arms");
		this.ShieldArm = this.Arms.getChild("ShieldArm");
		this.rightArm = this.ShieldArm.getChild("rightArm");
		this.rightForArm = this.rightArm.getChild("rightForArm");
		this.shield = this.rightForArm.getChild("shield");
		this.ShieldFoliage3 = this.shield.getChild("ShieldFoliage3");
		this.ShieldFoliage2 = this.shield.getChild("ShieldFoliage2");
		this.ShieldFoliage = this.shield.getChild("ShieldFoliage");
		this.tumors = this.shield.getChild("tumors");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.Head = this.FullBody.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.headWear = this.Head.getChild("headWear");
		this.HeadShell = this.Head.getChild("HeadShell");
		this.Legs = this.Protector.getChild("Legs");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftBoot = this.LeftLeg.getChild("LeftBoot");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightBoot = this.RightLeg.getChild("RightBoot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Protector = partdefinition.addOrReplaceChild("Protector", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition FullBody = Protector.addOrReplaceChild("FullBody", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body = FullBody.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 27).addBox(-3.6F, -5.0F, -2.2F, 8.0F, 9.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 15).addBox(-4.0F, 2.0F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.4F, -19.0F, -0.3F));

		PartDefinition CalciumChunk_r1 = Body.addOrReplaceChild("CalciumChunk_r1", CubeListBuilder.create().texOffs(21, 64).addBox(0.0F, -4.0F, -5.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.7F, 2.3F, -0.9791F, 0.4257F, -0.0399F));

		PartDefinition CalciumChunk_r2 = Body.addOrReplaceChild("CalciumChunk_r2", CubeListBuilder.create().texOffs(27, 27).addBox(-1.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8F, -1.5F, -0.3F, -1.0756F, -0.3435F, -0.0915F));

		PartDefinition CalciumArmor_r1 = Body.addOrReplaceChild("CalciumArmor_r1", CubeListBuilder.create().texOffs(65, 40).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -2.8F, 3.6F, 1.8459F, 0.1528F, -1.476F));

		PartDefinition Petal_r1 = Body.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(23, 56).addBox(-1.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -2.2F, 7.7F, -0.0698F, 0.6109F, 0.0F));

		PartDefinition Petal_r2 = Body.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(50, 48).addBox(-1.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8F, 2.4F, 3.5F, -0.1745F, -0.2967F, 0.0F));

		PartDefinition Petal_r3 = Body.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(56, 8).addBox(-1.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 3.9F, 5.0F, -0.1222F, 0.2793F, 0.0F));

		PartDefinition RibHeart = Body.addOrReplaceChild("RibHeart", CubeListBuilder.create(), PartPose.offset(2.9F, -2.0F, -3.3F));

		PartDefinition RibCage1 = RibHeart.addOrReplaceChild("RibCage1", CubeListBuilder.create(), PartPose.offset(-5.0F, 3.0F, 1.0F));

		PartDefinition Rib_r1 = RibCage1.addOrReplaceChild("Rib_r1", CubeListBuilder.create().texOffs(104, 35).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.25F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Rib_r2 = RibCage1.addOrReplaceChild("Rib_r2", CubeListBuilder.create().texOffs(104, 30).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 1.2741F, 0.0F));

		PartDefinition Heart = RibHeart.addOrReplaceChild("Heart", CubeListBuilder.create(), PartPose.offset(-2.8F, 0.0F, 1.3F));

		PartDefinition HeartTumor_r1 = Heart.addOrReplaceChild("HeartTumor_r1", CubeListBuilder.create().texOffs(91, 104).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.296F, 0.307F, 0.1599F));

		PartDefinition HeartTumor_r2 = Heart.addOrReplaceChild("HeartTumor_r2", CubeListBuilder.create().texOffs(101, 89).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 3.3F, -0.5F, 0.0185F, -0.2086F, -0.0892F));

		PartDefinition HeartTumor_r3 = Heart.addOrReplaceChild("HeartTumor_r3", CubeListBuilder.create().texOffs(67, 85).addBox(-1.0F, -4.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 2.3F, 1.4F, 0.0222F, 0.2083F, 0.107F));

		PartDefinition RibCage2 = RibHeart.addOrReplaceChild("RibCage2", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Rib_r3 = RibCage2.addOrReplaceChild("Rib_r3", CubeListBuilder.create().texOffs(104, 40).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.3265F, 0.0F));

		PartDefinition Rib_r4 = RibCage2.addOrReplaceChild("Rib_r4", CubeListBuilder.create().texOffs(104, 45).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, -0.5F, 0.0F, -1.3265F, 0.0F));

		PartDefinition TumourSack = Body.addOrReplaceChild("TumourSack", CubeListBuilder.create(), PartPose.offset(1.9F, 2.5F, 0.3F));

		PartDefinition cube_r1 = TumourSack.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.9F, 6.2F, -0.5259F, -0.4484F, 1.9453F));

		PartDefinition cube_r2 = TumourSack.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4F, -3.7F, 6.0F, -0.2974F, 0.0668F, -1.4342F));

		PartDefinition cube_r3 = TumourSack.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -6.2F, 6.6F, -0.5738F, 0.0592F, 0.0439F));

		PartDefinition cube_r4 = TumourSack.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, -7.6F, 5.4F, -0.2758F, 0.451F, 0.0293F));

		PartDefinition cube_r5 = TumourSack.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(111, 10).addBox(-6.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 3.4F, 0.7F, 0.0709F, -0.1741F, -0.1868F));

		PartDefinition cube_r6 = TumourSack.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(111, 10).addBox(-6.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.9F, 2.4F, -0.0424F, -0.2766F, 0.1605F));

		PartDefinition cube_r7 = TumourSack.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(111, 10).addBox(-6.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4F, -5.8F, 1.0F, -0.2609F, 0.1562F, -0.106F));

		PartDefinition cube_r8 = TumourSack.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(109, 8).addBox(-6.0F, -7.0F, -1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, -3.9F, -0.2F, 0.0825F, -0.0596F, 0.0825F));

		PartDefinition cube_r9 = TumourSack.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(109, 8).addBox(-6.0F, -7.0F, -1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 3.8F, -0.9F, -0.1552F, 0.0789F, 0.1643F));

		PartDefinition cube_r10 = TumourSack.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(109, 8).addBox(-6.0F, -7.0F, -1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -0.7F, -0.7F, -0.0657F, 0.3645F, -0.1944F));

		PartDefinition head_r1 = TumourSack.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(134, 2).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 1.4F, 4.6F, -0.7807F, -0.3264F, 0.0344F));

		PartDefinition head_r2 = TumourSack.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(121, 28).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 0.1F, 6.8F, 0.3712F, -0.2116F, 0.071F));

		PartDefinition cube_r11 = TumourSack.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(111, 10).addBox(-6.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.4F, 1.3F, -0.1557F, 0.2623F, -0.2298F));

		PartDefinition cube_r12 = TumourSack.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(109, 8).addBox(-6.0F, -7.0F, -1.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0401F, -0.278F, -0.15F));

		PartDefinition Arms = FullBody.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition ShieldArm = Arms.addOrReplaceChild("ShieldArm", CubeListBuilder.create(), PartPose.offset(-1.9F, -20.7F, 1.5F));

		PartDefinition rightArm = ShieldArm.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(85, 0).addBox(-2.5179F, -0.6818F, -2.5F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition rightForArm = rightArm.addOrReplaceChild("rightForArm", CubeListBuilder.create().texOffs(0, 57).addBox(-1.7F, 0.0F, -2.9F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1179F, 6.0182F, 0.0F, -0.4821F, -0.2129F, -0.3838F));

		PartDefinition shield = rightForArm.addOrReplaceChild("shield", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 2.0F, 3.0F, 1.4775F, 1.1324F, 1.4679F));

		PartDefinition ShieldBase_r1 = shield.addOrReplaceChild("ShieldBase_r1", CubeListBuilder.create().texOffs(27, 40).addBox(-1.0F, -7.0F, -1.0F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -2.4F, -1.1F, 0.0F, 0.4538F, 0.0F));

		PartDefinition ShieldBase_r2 = shield.addOrReplaceChild("ShieldBase_r2", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -7.0F, -1.0F, 8.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.9F, -1.9F, -0.0037F, -0.2094F, 0.0178F));

		PartDefinition ShieldBase_r3 = shield.addOrReplaceChild("ShieldBase_r3", CubeListBuilder.create().texOffs(52, 56).addBox(0.0F, -7.0F, -1.0F, 7.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, 6.5F, -2.2F, 0.1939F, 0.1732F, 0.0135F));

		PartDefinition ShieldBase_r4 = shield.addOrReplaceChild("ShieldBase_r4", CubeListBuilder.create().texOffs(65, 71).addBox(-1.0F, -7.0F, -1.0F, 6.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4F, 5.8F, -2.2F, 0.0646F, -0.3134F, 0.0734F));

		PartDefinition ShieldBase_r5 = shield.addOrReplaceChild("ShieldBase_r5", CubeListBuilder.create().texOffs(33, 0).addBox(-1.0F, -8.0F, -1.0F, 8.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 11.3F, -1.2F, 0.1047F, 0.0036F, -0.0347F));

		PartDefinition CalciumArmor_r2 = shield.addOrReplaceChild("CalciumArmor_r2", CubeListBuilder.create().texOffs(0, 99).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 4.9F, -3.2F, 1.4484F, -0.1195F, 0.1422F));

		PartDefinition CalciumArmor_r3 = shield.addOrReplaceChild("CalciumArmor_r3", CubeListBuilder.create().texOffs(98, 62).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -3.7F, -1.4F, 1.3049F, 0.6029F, -0.3666F));

		PartDefinition CalciumArmor_r4 = shield.addOrReplaceChild("CalciumArmor_r4", CubeListBuilder.create().texOffs(98, 54).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8F, -3.7F, -1.2F, 1.3865F, -0.0829F, 0.2202F));

		PartDefinition ShieldTumor_r1 = shield.addOrReplaceChild("ShieldTumor_r1", CubeListBuilder.create().texOffs(19, 99).addBox(-3.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4F, 3.7F, -1.3F, -0.1855F, -0.3435F, 0.0631F));

		PartDefinition ConnectiveBone_r1 = shield.addOrReplaceChild("ConnectiveBone_r1", CubeListBuilder.create().texOffs(60, 103).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.8F, -5.4F, 0.1F, 0.0F, 0.4887F, 0.0F));

		PartDefinition ConnectiveBone_r2 = shield.addOrReplaceChild("ConnectiveBone_r2", CubeListBuilder.create().texOffs(82, 104).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -2.0F, -1.0F, -0.429F, 0.048F, -0.3615F));

		PartDefinition ConnectiveBone_r3 = shield.addOrReplaceChild("ConnectiveBone_r3", CubeListBuilder.create().texOffs(71, 104).addBox(-1.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.3F, -3.1F, 0.5F, 0.0F, 0.4887F, 0.0F));

		PartDefinition ShieldFoliage3 = shield.addOrReplaceChild("ShieldFoliage3", CubeListBuilder.create(), PartPose.offsetAndRotation(8.8034F, -2.9808F, -4.6487F, 1.6836F, -0.614F, -0.73F));

		PartDefinition Petal4_r1 = ShieldFoliage3.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(79, 40).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6016F, 1.4674F, -1.161F, 0.2443F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = ShieldFoliage3.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(84, 70).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 2.4992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = ShieldFoliage3.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(79, 33).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, 1.6674F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = ShieldFoliage3.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(83, 23).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, 0.5674F, 2.839F, 0.4354F, 0.0295F, -0.0633F));

		PartDefinition ShieldFoliage2 = shield.addOrReplaceChild("ShieldFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4034F, 2.2192F, -6.7487F, 1.164F, 0.2572F, -0.4245F));

		PartDefinition Petal4_r2 = ShieldFoliage2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(60, 16).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6016F, 1.4674F, -1.161F, 0.2443F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = ShieldFoliage2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(0, 84).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 2.4992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r2 = ShieldFoliage2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(54, 33).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, 1.6674F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = ShieldFoliage2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(84, 77).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, 0.5674F, 2.839F, 0.4354F, 0.0295F, -0.0633F));

		PartDefinition ShieldFoliage = shield.addOrReplaceChild("ShieldFoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1034F, -9.5808F, -4.1487F, 1.1183F, -0.1441F, -0.6485F));

		PartDefinition Petal4_r3 = ShieldFoliage.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(73, 63).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6016F, -0.9326F, -1.161F, 0.2443F, 0.0F, -0.4363F));

		PartDefinition Petal3_r3 = ShieldFoliage.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(25, 84).addBox(-2.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r3 = ShieldFoliage.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(73, 56).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -0.7326F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = ShieldFoliage.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(79, 47).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -0.7326F, 1.539F, 0.4354F, 0.0295F, -0.0633F));

		PartDefinition tumors = shield.addOrReplaceChild("tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition ShieldTumor_r2 = tumors.addOrReplaceChild("ShieldTumor_r2", CubeListBuilder.create().texOffs(49, 103).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 7.3F, 2.5F, -0.1231F, 0.1213F, -0.015F));

		PartDefinition ShieldTumor_r3 = tumors.addOrReplaceChild("ShieldTumor_r3", CubeListBuilder.create().texOffs(36, 103).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.1F, -2.7F, 2.0F, -0.3204F, 0.0282F, -0.1378F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(84, 84).addBox(-0.4F, -0.6F, -1.6F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(102, 0).addBox(0.0F, 5.1F, -1.3F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.4F, -23.4F, -0.4F));

		PartDefinition CalciumArmor_r5 = LeftArm.addOrReplaceChild("CalciumArmor_r5", CubeListBuilder.create().texOffs(95, 96).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 0.8F, -0.1F, 0.0F, -0.1571F, 0.6283F));

		PartDefinition CalciumArmor_r6 = LeftArm.addOrReplaceChild("CalciumArmor_r6", CubeListBuilder.create().texOffs(76, 96).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.9F, -1.0F, 0.1482F, 0.243F, 0.1079F));

		PartDefinition CalciumArmor_r7 = LeftArm.addOrReplaceChild("CalciumArmor_r7", CubeListBuilder.create().texOffs(38, 95).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.3F, -0.1F, -0.0043F, -0.1221F, 0.0352F));

		PartDefinition Head = FullBody.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -6.5F, -5.6F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(101, 84).addBox(-4.0F, -0.7F, 0.4F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.0F, -2.2F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Petal_r4 = Head.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(54, 25).addBox(1.0613F, -2.8063F, 8.3742F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6F, -4.4F, -12.2F, -0.1571F, -0.2094F, 0.0F));

		PartDefinition Petal_r5 = Head.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(56, 0).addBox(-2.3672F, -1.4999F, 4.3265F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2F, -5.2F, -0.1396F, 0.2443F, 0.0F));

		PartDefinition CalciumArmor_r8 = Head.addOrReplaceChild("CalciumArmor_r8", CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -4.6F, -5.5F, 0.3233F, -0.0516F, -0.1748F));

		PartDefinition CalciumArmor_r9 = Head.addOrReplaceChild("CalciumArmor_r9", CubeListBuilder.create().texOffs(19, 91).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, -6.0F, -3.1F, -0.0873F, -0.0698F, 1.3439F));

		PartDefinition CalciumArmor_r10 = Head.addOrReplaceChild("CalciumArmor_r10", CubeListBuilder.create().texOffs(21, 75).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -3.0F, -6.3F, 0.291F, -0.4577F, -0.1036F));

		PartDefinition CalciumArmor_r11 = Head.addOrReplaceChild("CalciumArmor_r11", CubeListBuilder.create().texOffs(57, 95).addBox(-1.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, -1.4F, -6.3F, 0.0897F, -0.5546F, 0.1217F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(31, 16).addBox(-4.0F, -0.4128F, -5.0038F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 106).addBox(-4.0F, -1.4128F, -5.0038F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.4F, 0.1745F, 0.0F, 0.0F));

		PartDefinition headWear = Head.addOrReplaceChild("headWear", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -19.0F, -18.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(-11.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HeadShell = Head.addOrReplaceChild("HeadShell", CubeListBuilder.create(), PartPose.offset(-1.8F, -5.4F, -0.6F));

		PartDefinition cube_r13 = HeadShell.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 1.6F, 2.7F, -0.2342F, 0.1562F, 0.0517F));

		PartDefinition cube_r14 = HeadShell.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 3.0F, -0.5F, 0.0873F, -0.1222F, -1.7279F));

		PartDefinition cube_r15 = HeadShell.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 1.6F, 0.0F, -0.1527F, 0.1148F, -0.7014F));

		PartDefinition cube_r16 = HeadShell.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(144, 18).addBox(-1.0F, -3.0F, -4.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1176F, 0.5551F, 0.1233F));

		PartDefinition Legs = Protector.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(85, 12).addBox(-2.5F, 0.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(44, 71).addBox(-3.0F, 5.0F, -3.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(63, 111).addBox(-3.057F, 3.9154F, -3.0535F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offset(2.5F, -12.0F, 0.5F));

		PartDefinition Petal_r6 = LeftLeg.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(54, 25).addBox(-1.0F, 0.0F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, 2.9F, -1.3F, -0.1222F, -0.0524F, 0.0F));

		PartDefinition LeftBoot = LeftLeg.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(0, 88).addBox(-7.5F, 1.5F, -8.5F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.2F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(50, 85).addBox(-1.5F, 0.0F, -2.5F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 71).addBox(-2.0F, 5.0F, -3.0F, 5.0F, 7.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(98, 109).addBox(-1.957F, 3.9154F, -3.0535F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offset(-2.5F, -12.0F, 0.5F));

		PartDefinition RightBoot = RightLeg.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(0, 88).addBox(-7.5F, 1.5F, -8.5F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.21F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float moveValue = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.LeftLeg.xRot = moveValue;
		this.RightLeg.xRot = -this.LeftLeg.xRot;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			if (!entity.getShielded()){
				this.ShieldArm.yRot = 0;
				this.ShieldArm.xRot = moveValue/2;
			}
			this.LeftArm.xRot = -moveValue/2;
		} else {
			this.ShieldArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}
		if (entity.getShielded()){
			this.ShieldArm.xRot = 0;
			this.ShieldArm.yRot = -1.2f;
		}
		animateTentacleX(Jaw,Mth.sin(ageInTicks/7)/8);
		animateTumor(Heart,Mth.cos(ageInTicks/6)/6);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r,float g,float b,float alpha) {
		root().getAllParts().forEach(part -> {setDraw(part,armor);});
		Protector.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}

	@Override
	public List<ModelPart> EnderPearlArm() {
		return List.of(Protector,FullBody,Arms,LeftArm);
	}

	@Override
	public List<ModelPart> Helmet() {
		return List.of(headWear);
	}

	@Override
	public List<ModelPart> Feet() {
		return List.of(RightBoot,LeftBoot);
	}

	@Override
	public List<ModelPart> Armor() {
		return List.of(headWear,RightBoot,LeftBoot);
	}

	@Override
	public ModelPart root() {
		return Protector;
	}
}