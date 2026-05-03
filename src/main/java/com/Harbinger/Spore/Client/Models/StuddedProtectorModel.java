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

public class StuddedProtectorModel<T extends Protector> extends EntityModel<T> implements TentacledModel, ProtectorBits {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "studdedprotectormodel"), "main");
	private final ModelPart ProtectorModel;
	private final ModelPart Protector;
	private final ModelPart Limbs;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegLower;
	private final ModelPart LeftBoot;
	private final ModelPart RightArm;
	private final ModelPart RightArmLower;
	private final ModelPart BoneShield;
	private final ModelPart Thorn1;
	private final ModelPart Thorn2;
	private final ModelPart Thorn3;
	private final ModelPart Thorn4;
	private final ModelPart Thorn5;
	private final ModelPart Thorn6;
	private final ModelPart Thorn7;
	private final ModelPart Thorn8;
	private final ModelPart Thorn9;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmLower;
	private final ModelPart LeftArmTumor;
	private final ModelPart RightLeg;
	private final ModelPart RightLegLower;
	private final ModelPart RightBoot;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart headWear;
	private final ModelPart Body;
	private final ModelPart TumorHeart;
	private final ModelPart BackTumors;
	private final boolean armor;
	public StuddedProtectorModel(ModelPart root, boolean armor) {
		this.ProtectorModel = root.getChild("ProtectorModel");
        this.armor = armor;
        this.Protector = this.ProtectorModel.getChild("Protector");
		this.Limbs = this.Protector.getChild("Limbs");
		this.LeftLeg = this.Limbs.getChild("LeftLeg");
		this.LeftLegLower = this.LeftLeg.getChild("LeftLegLower");
		this.LeftBoot = this.LeftLegLower.getChild("LeftBoot");
		this.RightArm = this.Limbs.getChild("RightArm");
		this.RightArmLower = this.RightArm.getChild("RightArmLower");
		this.BoneShield = this.RightArmLower.getChild("BoneShield");
		this.Thorn1 = this.BoneShield.getChild("Thorn1");
		this.Thorn2 = this.BoneShield.getChild("Thorn2");
		this.Thorn3 = this.BoneShield.getChild("Thorn3");
		this.Thorn4 = this.BoneShield.getChild("Thorn4");
		this.Thorn5 = this.BoneShield.getChild("Thorn5");
		this.Thorn6 = this.BoneShield.getChild("Thorn6");
		this.Thorn7 = this.BoneShield.getChild("Thorn7");
		this.Thorn8 = this.BoneShield.getChild("Thorn8");
		this.Thorn9 = this.BoneShield.getChild("Thorn9");
		this.LeftArm = this.Limbs.getChild("LeftArm");
		this.LeftArmLower = this.LeftArm.getChild("LeftArmLower");
		this.LeftArmTumor = this.LeftArmLower.getChild("LeftArmTumor");
		this.RightLeg = this.Limbs.getChild("RightLeg");
		this.RightLegLower = this.RightLeg.getChild("RightLegLower");
		this.RightBoot = this.RightLegLower.getChild("RightBoot");
		this.Head = this.Limbs.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.headWear = this.Head.getChild("headWear");
		this.Body = this.Protector.getChild("Body");
		this.TumorHeart = this.Body.getChild("TumorHeart");
		this.BackTumors = this.Body.getChild("BackTumors");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ProtectorModel = partdefinition.addOrReplaceChild("ProtectorModel", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Protector = ProtectorModel.addOrReplaceChild("Protector", CubeListBuilder.create(), PartPose.offset(0.0F, 25.0F, 0.0F));

		PartDefinition Limbs = Protector.addOrReplaceChild("Limbs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Limbs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(34, 90).addBox(-1.0F, -1.3F, 0.9F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(1.8F, -11.2F, -2.4F));

		PartDefinition Petal_r1 = LeftLeg.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(75, 36).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, 3.5F, 0.0F, 3.1379F, -0.5072F, -2.7263F));

		PartDefinition HindClaw_r1 = LeftLeg.addOrReplaceChild("HindClaw_r1", CubeListBuilder.create().texOffs(92, 83).addBox(0.0F, -2.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 3.7F, 4.4F, 0.8029F, 0.0F, 0.0F));

		PartDefinition LeftLegLower = LeftLeg.addOrReplaceChild("LeftLegLower", CubeListBuilder.create().texOffs(0, 80).addBox(-1.6F, 0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.4F))
				.texOffs(16, 111).addBox(-1.6F, 0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.2F, 4.2F, 2.4F));

		PartDefinition LeftBoot = LeftLegLower.addOrReplaceChild("LeftBoot", CubeListBuilder.create().texOffs(0, 88).addBox(-7.5F, 1.5F, -8.6F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.2F)), PartPose.offset(-0.5F, -5.0F, 0.5F));

		PartDefinition RightArm = Limbs.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-4.9F, -24.0F, -0.2F));

		PartDefinition right_arm_r1 = RightArm.addOrReplaceChild("right_arm_r1", CubeListBuilder.create().texOffs(77, 43).addBox(-1.7F, -0.2F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.4F, -0.8F, 0.5F, 1.0145F, 1.562F, 1.5134F));

		PartDefinition RightArmLower = RightArm.addOrReplaceChild("RightArmLower", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -4.0F));

		PartDefinition right_arm_r2 = RightArmLower.addOrReplaceChild("right_arm_r2", CubeListBuilder.create().texOffs(51, 81).addBox(-1.7F, -0.7F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, 1.7F, 3.7F, -0.2344F, -0.2044F, -0.108F));

		PartDefinition BoneShield = RightArmLower.addOrReplaceChild("BoneShield", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, 17.6F, 4.1F, 0.0012F, -0.1222F, -0.035F));

		PartDefinition ShieldTeeth_r1 = BoneShield.addOrReplaceChild("ShieldTeeth_r1", CubeListBuilder.create().texOffs(73, 91).addBox(-1.0919F, -4.2326F, 1.7687F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8579F, -4.126F, 0.1519F, 1.8155F, 0.1109F, -2.0472F));

		PartDefinition ShieldTeeth_r2 = BoneShield.addOrReplaceChild("ShieldTeeth_r2", CubeListBuilder.create().texOffs(73, 91).addBox(-1.0919F, -4.2326F, 1.7687F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6579F, -7.426F, -0.9481F, 1.7108F, 0.1109F, -2.0472F));

		PartDefinition ShieldTeeth_r3 = BoneShield.addOrReplaceChild("ShieldTeeth_r3", CubeListBuilder.create().texOffs(73, 91).addBox(-1.0919F, -4.2326F, 1.7687F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9579F, -9.426F, 0.3519F, 1.7535F, 0.1118F, -1.977F));

		PartDefinition ShieldTeeth_r4 = BoneShield.addOrReplaceChild("ShieldTeeth_r4", CubeListBuilder.create().texOffs(73, 91).addBox(-1.0919F, -4.2326F, 1.7687F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7579F, -5.526F, -1.1481F, 0.5473F, -1.4219F, -0.7471F));

		PartDefinition ShieldTeeth_r5 = BoneShield.addOrReplaceChild("ShieldTeeth_r5", CubeListBuilder.create().texOffs(26, 91).addBox(-1.0808F, -4.2411F, 1.8876F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7421F, -11.226F, 2.4519F, -1.6739F, -0.0129F, -1.9334F));

		PartDefinition ShieldTeeth_r6 = BoneShield.addOrReplaceChild("ShieldTeeth_r6", CubeListBuilder.create().texOffs(26, 91).addBox(-1.0808F, -4.2411F, 1.8876F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9421F, -22.426F, 1.4519F, -1.7081F, -0.0688F, -1.0785F));

		PartDefinition ShieldTeeth_r7 = BoneShield.addOrReplaceChild("ShieldTeeth_r7", CubeListBuilder.create().texOffs(26, 91).addBox(-1.0808F, -4.2411F, 1.8876F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5421F, -18.026F, 0.5519F, -1.5414F, 0.5119F, -1.4122F));

		PartDefinition ShieldTeeth_r8 = BoneShield.addOrReplaceChild("ShieldTeeth_r8", CubeListBuilder.create().texOffs(26, 91).addBox(-1.0808F, -4.2411F, 1.8875F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7421F, -14.926F, 1.1519F, -0.1173F, 1.2536F, -0.1782F));

		PartDefinition ShieldTeeth_r9 = BoneShield.addOrReplaceChild("ShieldTeeth_r9", CubeListBuilder.create().texOffs(78, 93).addBox(-1.1848F, -4.2364F, 1.9259F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1421F, -10.726F, -5.4481F, 1.238F, -0.0392F, 1.2615F));

		PartDefinition ShieldTeeth_r10 = BoneShield.addOrReplaceChild("ShieldTeeth_r10", CubeListBuilder.create().texOffs(78, 93).addBox(-1.1848F, -4.2364F, 1.9259F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9421F, -18.426F, -5.4481F, 1.6991F, 1.4151F, 1.684F));

		PartDefinition Petal_r2 = BoneShield.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(25, 66).addBox(-4.9409F, -0.4964F, -4.9914F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -14.6F, 1.0F, -0.0221F, -0.1039F, -0.1228F));

		PartDefinition Petal_r3 = BoneShield.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(71, 62).addBox(-4.9082F, -0.4913F, -5.0123F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1F, -7.6F, -1.7F, 0.205F, -0.7638F, -0.292F));

		PartDefinition Petal_r4 = BoneShield.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(56, 22).addBox(-4.92F, -0.4933F, -5.0173F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9F, -10.1F, 4.4F, 0.1581F, 0.1034F, -0.1579F));

		PartDefinition Petal_r5 = BoneShield.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(77, 0).addBox(-4.8906F, -0.4876F, -5.0172F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3F, -17.8F, -3.7F, -0.1F, -0.17F, -0.2303F));

		PartDefinition Petal_r6 = BoneShield.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(0, 59).addBox(-4.918F, -0.4929F, -5.0168F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -19.8F, 3.0F, 0.0498F, -0.2749F, -0.1814F));

		PartDefinition Petal_r7 = BoneShield.addOrReplaceChild("Petal_r7", CubeListBuilder.create().texOffs(0, 66).addBox(-4.9349F, -0.4955F, -5.0169F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, -17.8F, 6.1F, -0.0304F, 0.2425F, -0.1259F));

		PartDefinition BoneShieldPiece_r1 = BoneShield.addOrReplaceChild("BoneShieldPiece_r1", CubeListBuilder.create().texOffs(52, 55).addBox(1.9018F, -6.4887F, -5.0392F, 1.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0789F, -0.173F, 0.1947F));

		PartDefinition BoneShieldPiece_r2 = BoneShield.addOrReplaceChild("BoneShieldPiece_r2", CubeListBuilder.create().texOffs(23, 34).addBox(1.1055F, -6.4885F, -6.9841F, 2.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, -3.6F, 1.0F, 0.1112F, -0.1932F, -0.2238F));

		PartDefinition BoneShieldPiece_r3 = BoneShield.addOrReplaceChild("BoneShieldPiece_r3", CubeListBuilder.create().texOffs(0, 23).addBox(-0.006F, -13.4964F, -7.0599F, 3.0F, 13.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6F, -8.5F, -1.3F, -0.0873F, -0.3491F, 0.0F));

		PartDefinition BoneShieldPiece_r4 = BoneShield.addOrReplaceChild("BoneShieldPiece_r4", CubeListBuilder.create().texOffs(92, 53).addBox(-0.9895F, -14.4971F, -6.9476F, 4.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, -8.5F, 5.5F, 0.1378F, 0.1071F, -0.0174F));

		PartDefinition Thorn1 = BoneShield.addOrReplaceChild("Thorn1", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8803F, -18.4992F, -0.3568F, -0.0873F, 0.0F, 1.789F));

		PartDefinition Plane2_r1 = Thorn1.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = Thorn1.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn2 = BoneShield.addOrReplaceChild("Thorn2", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4803F, -16.4992F, 3.9432F, 0.2105F, -0.0085F, 1.6328F));

		PartDefinition Plane3_r1 = Thorn2.addOrReplaceChild("Plane3_r1", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane2_r2 = Thorn2.addOrReplaceChild("Plane2_r2", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn3 = BoneShield.addOrReplaceChild("Thorn3", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3803F, -12.9992F, 1.2432F, 0.0253F, 0.067F, 1.2739F));

		PartDefinition Plane4_r1 = Thorn3.addOrReplaceChild("Plane4_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane3_r2 = Thorn3.addOrReplaceChild("Plane3_r2", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn4 = BoneShield.addOrReplaceChild("Thorn4", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0803F, -9.9992F, 3.4432F, 0.3083F, 0.1158F, 1.1239F));

		PartDefinition Plane5_r1 = Thorn4.addOrReplaceChild("Plane5_r1", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane4_r2 = Thorn4.addOrReplaceChild("Plane4_r2", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn5 = BoneShield.addOrReplaceChild("Thorn5", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0197F, -15.5992F, -5.7568F, -0.3352F, 0.0862F, 1.0603F));

		PartDefinition Plane6_r1 = Thorn5.addOrReplaceChild("Plane6_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane5_r2 = Thorn5.addOrReplaceChild("Plane5_r2", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn6 = BoneShield.addOrReplaceChild("Thorn6", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7197F, -11.8992F, -4.0568F, 0.0578F, 0.0628F, 1.1806F));

		PartDefinition Plane7_r1 = Thorn6.addOrReplaceChild("Plane7_r1", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane6_r2 = Thorn6.addOrReplaceChild("Plane6_r2", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn7 = BoneShield.addOrReplaceChild("Thorn7", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0197F, -6.9992F, 0.8432F, -0.0786F, 0.2611F, 1.2528F));

		PartDefinition Plane8_r1 = Thorn7.addOrReplaceChild("Plane8_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane7_r2 = Thorn7.addOrReplaceChild("Plane7_r2", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn8 = BoneShield.addOrReplaceChild("Thorn8", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2197F, -5.4992F, -3.6568F, -0.1084F, -0.4758F, 1.5494F));

		PartDefinition Plane9_r1 = Thorn8.addOrReplaceChild("Plane9_r1", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane8_r2 = Thorn8.addOrReplaceChild("Plane8_r2", CubeListBuilder.create().texOffs(19, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn9 = BoneShield.addOrReplaceChild("Thorn9", CubeListBuilder.create().texOffs(16, 46).addBox(-0.5F, -3.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7197F, -3.5992F, -0.4568F, 0.0926F, -0.001F, 0.6303F));

		PartDefinition Plane10_r1 = Thorn9.addOrReplaceChild("Plane10_r1", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane9_r2 = Thorn9.addOrReplaceChild("Plane9_r2", CubeListBuilder.create().texOffs(15, 46).addBox(0.0F, 0.0F, -0.5F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition LeftArm = Limbs.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(77, 7).addBox(-1.4F, -0.5F, -2.5F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.4F, -24.0F, 0.5F));

		PartDefinition CalciumArmor_r1 = LeftArm.addOrReplaceChild("CalciumArmor_r1", CubeListBuilder.create().texOffs(102, 31).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, 0.1F, 2.7F, 1.7741F, 0.1727F, 2.0729F));

		PartDefinition CalciumArmor_r2 = LeftArm.addOrReplaceChild("CalciumArmor_r2", CubeListBuilder.create().texOffs(102, 31).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 1.3F, -0.4F, 1.6329F, 0.2588F, 1.435F));

		PartDefinition CalciumArmor_r3 = LeftArm.addOrReplaceChild("CalciumArmor_r3", CubeListBuilder.create().texOffs(101, 23).addBox(-4.0F, -3.0F, -1.0F, 5.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6F, 1.3F, -1.4F, -0.0841F, -0.0395F, 1.2082F));

		PartDefinition Petal_r8 = LeftArm.addOrReplaceChild("Petal_r8", CubeListBuilder.create().texOffs(0, 73).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 1.6F, -1.6F, -2.695F, 0.6061F, -2.6967F));

		PartDefinition LeftArmLower = LeftArm.addOrReplaceChild("LeftArmLower", CubeListBuilder.create().texOffs(0, 91).addBox(4.0F, -24.5F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 30.0F, 0.0F));

		PartDefinition LeftArmTumor = LeftArmLower.addOrReplaceChild("LeftArmTumor", CubeListBuilder.create(), PartPose.offset(5.0F, -22.0F, -0.2F));

		PartDefinition LeftArmTumor_r1 = LeftArmTumor.addOrReplaceChild("LeftArmTumor_r1", CubeListBuilder.create().texOffs(60, 91).addBox(-1.0F, -3.0F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, -0.8231F, 0.8745F, -0.5379F));

		PartDefinition RightLeg = Limbs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(79, 83).addBox(-1.8F, -0.5F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

		PartDefinition HindClaw_r2 = RightLeg.addOrReplaceChild("HindClaw_r2", CubeListBuilder.create().texOffs(92, 92).addBox(0.0F, -2.0F, -1.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 4.5F, 2.0F, 0.8029F, 0.0F, 0.0F));

		PartDefinition RightLegLower = RightLeg.addOrReplaceChild("RightLegLower", CubeListBuilder.create().texOffs(17, 80).addBox(-2.4F, 0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.4F))
				.texOffs(0, 111).addBox(-2.4F, 0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition RightBoot = RightLegLower.addOrReplaceChild("RightBoot", CubeListBuilder.create().texOffs(0, 88).addBox(-7.5F, 1.5F, -8.5F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.21F)), PartPose.offset(-0.5F, -5.0F, 0.5F));

		PartDefinition Head = Limbs.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -7.5F, -7.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(29, 55).addBox(-4.0F, -3.5F, -7.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -26.9F, -0.4F));

		PartDefinition head_r1 = Head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(29, 55).addBox(-4.0F, -1.0F, -4.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, -3.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition ConnectiveTissue_r1 = Head.addOrReplaceChild("ConnectiveTissue_r1", CubeListBuilder.create().texOffs(0, 45).addBox(1.0F, -2.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2F, -4.8F, -6.9F, -0.0597F, -0.219F, 0.2684F));

		PartDefinition ConnectiveTissue_r2 = Head.addOrReplaceChild("ConnectiveTissue_r2", CubeListBuilder.create().texOffs(3, 45).addBox(1.0F, -2.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1F, -4.8F, -6.7F, -0.8336F, -1.0144F, 0.8912F));

		PartDefinition ConnectiveTissue_r3 = Head.addOrReplaceChild("ConnectiveTissue_r3", CubeListBuilder.create().texOffs(25, 59).addBox(1.0F, -3.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8F, -4.8F, -6.9F, -0.4067F, -0.6017F, 0.8029F));

		PartDefinition Petal4_r1 = Head.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(48, 47).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5468F, -8.7493F, -6.8017F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal1_r1 = Head.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(25, 15).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1468F, -9.2493F, -2.8017F, 0.5405F, -0.0221F, 0.0475F));

		PartDefinition Petal_r9 = Head.addOrReplaceChild("Petal_r9", CubeListBuilder.create().texOffs(71, 55).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -8.6F, -5.0F, 0.1326F, 0.2743F, 0.379F));

		PartDefinition Petal3_r1 = Head.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8292F, -8.4175F, -8.5017F, -0.2083F, 0.1603F, 0.1693F));

		PartDefinition Petal_r10 = Head.addOrReplaceChild("Petal_r10", CubeListBuilder.create().texOffs(71, 69).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -3.4F, 1.2F, -0.0167F, 0.2081F, -0.1597F));

		PartDefinition Petal_r11 = Head.addOrReplaceChild("Petal_r11", CubeListBuilder.create().texOffs(75, 29).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -7.6F, 0.7F, -0.5653F, 1.1523F, -0.5305F));

		PartDefinition HeadBrainTumor_r1 = Head.addOrReplaceChild("HeadBrainTumor_r1", CubeListBuilder.create().texOffs(54, 11).addBox(0.0F, -4.0F, -5.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7F, -5.2F, 1.2F, 0.0652F, 0.1979F, -0.2809F));

		PartDefinition HeadBrainTumor_r2 = Head.addOrReplaceChild("HeadBrainTumor_r2", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2F, -2.5F, 0.7F, 0.0541F, -0.1475F, -0.3531F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -0.5F, -0.6F));

		PartDefinition head_r2 = Jaw.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(28, 101).addBox(-7.0F, 0.0F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.1F, -7.4F, 1.5708F, 1.4835F, 1.5708F));

		PartDefinition head_r3 = Jaw.addOrReplaceChild("head_r3", CubeListBuilder.create().texOffs(0, 101).addBox(-7.0F, 0.0F, -4.0F, 6.0F, 1.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, 0.7F, -7.4F, 1.5708F, 1.4835F, 1.5708F));

		PartDefinition headWear = Head.addOrReplaceChild("headWear", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -19.0F, -18.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(-11.5F)), PartPose.offset(0.0F, -1.1F, -0.8F));

		PartDefinition Body = Protector.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(52, 0).addBox(-3.8F, -7.5F, -2.3F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(50, 70).addBox(-3.3F, -0.6F, -1.8F, 7.0F, 7.0F, 3.0F, new CubeDeformation(1.0F)), PartPose.offset(-0.2F, -18.9F, 0.3F));

		PartDefinition CalciumArmor_r4 = Body.addOrReplaceChild("CalciumArmor_r4", CubeListBuilder.create().texOffs(98, 10).addBox(-5.0F, -5.0F, -1.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3F, -3.3F, 0.7F, -1.7654F, -0.5775F, 1.567F));

		PartDefinition CalciumArmor_r5 = Body.addOrReplaceChild("CalciumArmor_r5", CubeListBuilder.create().texOffs(99, 0).addBox(-4.0F, -4.0F, -1.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, -3.8F, 0.7F, -1.2477F, -0.6203F, 1.5774F));

		PartDefinition Rib4_r1 = Body.addOrReplaceChild("Rib4_r1", CubeListBuilder.create().texOffs(105, 46).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -0.5F, -3.9F, -0.1675F, 1.3221F, -0.3117F));

		PartDefinition Rib3_r1 = Body.addOrReplaceChild("Rib3_r1", CubeListBuilder.create().texOffs(105, 41).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -0.5F, -3.9F, -2.8003F, 1.2861F, -2.6753F));

		PartDefinition Rib2_r1 = Body.addOrReplaceChild("Rib2_r1", CubeListBuilder.create().texOffs(105, 46).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -3.5F, -3.9F, -2.8003F, 1.2861F, -2.6753F));

		PartDefinition Rib1_r1 = Body.addOrReplaceChild("Rib1_r1", CubeListBuilder.create().texOffs(105, 41).addBox(-2.0F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -3.5F, -3.9F, -0.1675F, 1.3221F, -0.3117F));

		PartDefinition Petal_r12 = Body.addOrReplaceChild("Petal_r12", CubeListBuilder.create().texOffs(71, 76).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 2.8F, -4.1F, 1.2712F, 1.0126F, 1.5139F));

		PartDefinition Petal_r13 = Body.addOrReplaceChild("Petal_r13", CubeListBuilder.create().texOffs(25, 73).addBox(-5.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, 1.9F, 1.2F, -0.5653F, 1.1523F, -0.5305F));

		PartDefinition TumorHeart = Body.addOrReplaceChild("TumorHeart", CubeListBuilder.create(), PartPose.offset(-0.6597F, -3.2624F, -1.7935F));

		PartDefinition Tumor_r1 = TumorHeart.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(13, 91).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.0F, -0.5F, 0.0F, 1.2278F, -0.3461F, -1.1971F));

		PartDefinition Tumor_r2 = TumorHeart.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(81, 18).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3096F, 0.5272F, -0.0778F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Tumor_r3 = TumorHeart.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(47, 91).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.8F, 2.5F, 0.0F, 1.4923F, -0.2995F, -1.0681F));

		PartDefinition BackTumors = Body.addOrReplaceChild("BackTumors", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition Tumor_r4 = BackTumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(64, 83).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.5F, -2.0F, -0.2603F, -0.4036F, -0.1378F));

		PartDefinition Tumor_r5 = BackTumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(34, 81).addBox(-1.0F, -4.0F, -1.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 1.5F, -2.4F, -0.1158F, 0.29F, -0.2187F));

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
				this.RightArm.yRot = 0;
				this.RightArm.xRot = moveValue/2;
			}
			this.LeftArm.xRot = -moveValue/2;
		} else {
			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
		}
		if (entity.getShielded()){
			this.RightArm.xRot = 0;
			this.RightArm.yRot = -1.2f;
		}
		animateTentacleX(Jaw,Mth.sin(ageInTicks/7)/8);
		animateTumor(TumorHeart,Mth.cos(ageInTicks/6)/6);
		animateTumor(LeftArmTumor,Mth.cos(ageInTicks/7)/8);
		animateTumor(BackTumors,Mth.sin(ageInTicks/7)/5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		root().getAllParts().forEach(part -> {setDraw(part,armor);});
		ProtectorModel.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,alpha);
	}

	@Override
	public List<ModelPart> EnderPearlArm() {
		return List.of(ProtectorModel,Protector,Limbs,LeftArm);
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
		return ProtectorModel;
	}
}