package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.1.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Mephetic;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.util.Mth;

import java.util.List;

public class MephiticModel<T extends Mephetic> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "mephiticmodel"), "main");
	private final ModelPart MephiticRedo;
	private final ModelPart HipJoint;
	private final ModelPart Torso;
	private final ModelPart Tailbone;
	private final ModelPart LowerTorso;
	private final ModelPart StomachTumors;
	private final ModelPart BackTumors;
	private final ModelPart UpperTorso;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart RightShoulderBoneGrowth;
	private final ModelPart RightArmShoulderTumors;
	private final ModelPart RightForearm;
	private final ModelPart RightForearmBoneGrowth;
	private final ModelPart RightArmForearmTumors;
	private final ModelPart RightHand;
	private final ModelPart RightHandBoneGrowth;
	private final ModelPart RightFingers;
	private final ModelPart RightFinger1;
	private final ModelPart RightFinger2;
	private final ModelPart RightFinger3;
	private final ModelPart RightThumb;
	private final ModelPart LeftArm;
	private final ModelPart LeftShoulderTumor;
	private final ModelPart LeftForearm;
	private final ModelPart LeftHand;
	private final ModelPart LeftFingers;
	private final ModelPart LeftFinger1;
	private final ModelPart LeftFinger2;
	private final ModelPart LeftFinger3;
	private final ModelPart LeftThumb;
	private final ModelPart Head;
	private final ModelPart NeckTumors;
	private final ModelPart MouthPotion;
	private final ModelPart UpperHead;
	private final ModelPart HeadTumors;
	private final ModelPart Nose;
	private final ModelPart UpperFangs;
	private final ModelPart RightUpperFang;
	private final ModelPart LeftUpperFang;
	private final ModelPart JawConnectingTissue;
	private final ModelPart HatConnection;
	private final ModelPart HatConnectingTumors;
	private final ModelPart HatConnectingTissue;
	private final ModelPart Hat;
	private final ModelPart HatPotion;
	private final ModelPart Hat2;
	private final ModelPart Hat3;
	private final ModelPart Hat4;
	private final ModelPart Jaw;
	private final ModelPart LowerFangs;
	private final ModelPart RightLowerFang;
	private final ModelPart RightLowerFang2;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart RightKneeJoint;
	private final ModelPart LeftLeg;
	private final ModelPart LeftKneeJoint;
	public final List<ModelPart> armParts;
	public final List<ModelPart> OffarmParts;
	public MephiticModel(ModelPart root) {
		this.MephiticRedo = root.getChild("MephiticRedo");
		this.HipJoint = this.MephiticRedo.getChild("HipJoint");
		this.Torso = this.HipJoint.getChild("Torso");
		this.Tailbone = this.Torso.getChild("Tailbone");
		this.LowerTorso = this.Torso.getChild("LowerTorso");
		this.StomachTumors = this.LowerTorso.getChild("StomachTumors");
		this.BackTumors = this.LowerTorso.getChild("BackTumors");
		this.UpperTorso = this.LowerTorso.getChild("UpperTorso");
		this.Arms = this.UpperTorso.getChild("Arms");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightShoulderBoneGrowth = this.RightArm.getChild("RightShoulderBoneGrowth");
		this.RightArmShoulderTumors = this.RightArm.getChild("RightArmShoulderTumors");
		this.RightForearm = this.RightArm.getChild("RightForearm");
		this.RightForearmBoneGrowth = this.RightForearm.getChild("RightForearmBoneGrowth");
		this.RightArmForearmTumors = this.RightForearm.getChild("RightArmForearmTumors");
		this.RightHand = this.RightForearm.getChild("RightHand");
		this.RightHandBoneGrowth = this.RightHand.getChild("RightHandBoneGrowth");
		this.RightFingers = this.RightHand.getChild("RightFingers");
		this.RightFinger1 = this.RightFingers.getChild("RightFinger1");
		this.RightFinger2 = this.RightFingers.getChild("RightFinger2");
		this.RightFinger3 = this.RightFingers.getChild("RightFinger3");
		this.RightThumb = this.RightFingers.getChild("RightThumb");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftShoulderTumor = this.LeftArm.getChild("LeftShoulderTumor");
		this.LeftForearm = this.LeftArm.getChild("LeftForearm");
		this.LeftHand = this.LeftForearm.getChild("LeftHand");
		this.LeftFingers = this.LeftHand.getChild("LeftFingers");
		this.LeftFinger1 = this.LeftFingers.getChild("LeftFinger1");
		this.LeftFinger2 = this.LeftFingers.getChild("LeftFinger2");
		this.LeftFinger3 = this.LeftFingers.getChild("LeftFinger3");
		this.LeftThumb = this.LeftFingers.getChild("LeftThumb");
		this.Head = this.UpperTorso.getChild("Head");
		this.NeckTumors = this.Head.getChild("NeckTumors");
		this.MouthPotion = this.Head.getChild("MouthPotion");
		this.UpperHead = this.Head.getChild("UpperHead");
		this.HeadTumors = this.UpperHead.getChild("HeadTumors");
		this.Nose = this.UpperHead.getChild("Nose");
		this.UpperFangs = this.UpperHead.getChild("UpperFangs");
		this.RightUpperFang = this.UpperFangs.getChild("RightUpperFang");
		this.LeftUpperFang = this.UpperFangs.getChild("LeftUpperFang");
		this.JawConnectingTissue = this.UpperHead.getChild("JawConnectingTissue");
		this.HatConnection = this.UpperHead.getChild("HatConnection");
		this.HatConnectingTumors = this.HatConnection.getChild("HatConnectingTumors");
		this.HatConnectingTissue = this.HatConnection.getChild("HatConnectingTissue");
		this.Hat = this.HatConnection.getChild("Hat");
		this.HatPotion = this.Hat.getChild("HatPotion");
		this.Hat2 = this.Hat.getChild("Hat2");
		this.Hat3 = this.Hat2.getChild("Hat3");
		this.Hat4 = this.Hat3.getChild("Hat4");
		this.Jaw = this.Head.getChild("Jaw");
		this.LowerFangs = this.Jaw.getChild("LowerFangs");
		this.RightLowerFang = this.LowerFangs.getChild("RightLowerFang");
		this.RightLowerFang2 = this.LowerFangs.getChild("RightLowerFang2");
		this.Legs = this.HipJoint.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightKneeJoint = this.RightLeg.getChild("RightKneeJoint");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftKneeJoint = this.LeftLeg.getChild("LeftKneeJoint");
		armParts = List.of(MephiticRedo,HipJoint,Torso,LowerTorso,UpperTorso,Arms,RightArm,RightHand);
		OffarmParts = List.of(MephiticRedo,HipJoint,Torso,LowerTorso,UpperTorso,Arms,LeftArm);
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition MephiticRedo = partdefinition.addOrReplaceChild("MephiticRedo", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition HipJoint = MephiticRedo.addOrReplaceChild("HipJoint", CubeListBuilder.create(), PartPose.offset(-0.0125F, -16.4944F, -0.0028F));

		PartDefinition Torso = HipJoint.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(50, 40).addBox(-3.9875F, -1.0056F, -1.9972F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(-3.9875F, -1.0056F, -1.9972F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tailbone = Torso.addOrReplaceChild("Tailbone", CubeListBuilder.create().texOffs(122, 0).addBox(-1.0F, -1.0872F, -0.1978F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.1872F, 2.0978F, 0.1745F, 0.0F, 0.0F));

		PartDefinition TailSpine_r1 = Tailbone.addOrReplaceChild("TailSpine_r1", CubeListBuilder.create().texOffs(123, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0372F, 1.5477F, 0.8901F, 0.0F, 0.0F));

		PartDefinition TailSpine_r2 = Tailbone.addOrReplaceChild("TailSpine_r2", CubeListBuilder.create().texOffs(123, 4).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.9372F, 1.3477F, 0.0698F, 0.0F, 0.0F));

		PartDefinition Tail_r1 = Tailbone.addOrReplaceChild("Tail_r1", CubeListBuilder.create().texOffs(123, 4).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9128F, 0.8022F, 0.3142F, 0.0F, 0.0F));

		PartDefinition LowerTorso = Torso.addOrReplaceChild("LowerTorso", CubeListBuilder.create(), PartPose.offset(-0.0125F, -0.9944F, -0.0028F));

		PartDefinition Robe_r1 = LowerTorso.addOrReplaceChild("Robe_r1", CubeListBuilder.create().texOffs(28, 40).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(-0.1F))
		.texOffs(40, 0).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.025F, -3.0111F, -0.0944F, 0.0436F, 0.0F, 0.0F));

		PartDefinition StomachTumors = LowerTorso.addOrReplaceChild("StomachTumors", CubeListBuilder.create(), PartPose.offset(-0.6618F, -2.0249F, -1.6885F));

		PartDefinition SmallTumor_r1 = StomachTumors.addOrReplaceChild("SmallTumor_r1", CubeListBuilder.create().texOffs(92, 12).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4382F, 1.4249F, 0.5885F, 0.75F, 1.1569F, 0.2589F));

		PartDefinition SmallTumor_r2 = StomachTumors.addOrReplaceChild("SmallTumor_r2", CubeListBuilder.create().texOffs(92, 6).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9382F, 0.5249F, -0.4116F, 0.1866F, 0.1822F, -0.1429F));

		PartDefinition MediumTumor_r1 = StomachTumors.addOrReplaceChild("MediumTumor_r1", CubeListBuilder.create().texOffs(76, 10).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3764F, -1.9497F, -0.1769F, 0.1526F, -0.3283F, -0.1476F));

		PartDefinition BackTumors = LowerTorso.addOrReplaceChild("BackTumors", CubeListBuilder.create(), PartPose.offset(-0.2941F, -2.9174F, 1.8721F));

		PartDefinition SmallTumor_r3 = BackTumors.addOrReplaceChild("SmallTumor_r3", CubeListBuilder.create().texOffs(64, 92).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1638F, 2.6788F, 0.0533F, 0.2115F, 0.2552F, 0.1761F));

		PartDefinition SmallTumor_r4 = BackTumors.addOrReplaceChild("SmallTumor_r4", CubeListBuilder.create().texOffs(92, 48).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5362F, -0.6212F, -0.0467F, -0.1654F, 0.2722F, 0.027F));

		PartDefinition MediumTumor_r2 = BackTumors.addOrReplaceChild("MediumTumor_r2", CubeListBuilder.create().texOffs(32, 76).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3724F, -2.0575F, -0.0066F, 0.2967F, -0.1745F, -0.2967F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create(), PartPose.offset(-0.025F, -4.9889F, -0.2056F));

		PartDefinition Petal_r1 = UpperTorso.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -2.8638F, 2.7751F, -0.4127F, -0.4979F, 0.5105F));

		PartDefinition Robe_r2 = UpperTorso.addOrReplaceChild("Robe_r2", CubeListBuilder.create().texOffs(80, 73).addBox(-3.5F, -2.0F, -1.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(78, 0).addBox(-3.5F, -2.0F, -1.0F, 7.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.05F, -3.4783F, -2.68F, 0.0087F, 0.0F, 0.0F));

		PartDefinition Robe_r3 = UpperTorso.addOrReplaceChild("Robe_r3", CubeListBuilder.create().texOffs(28, 28).addBox(-8.0F, -7.0F, -1.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.1F))
		.texOffs(0, 28).addBox(-8.0F, -7.0F, -1.0F, 9.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.55F, 0.4778F, -1.4887F, 0.1484F, 0.0F, 0.0F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-0.1F, -4.2722F, -0.5887F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offset(-4.2F, 0.0F, 0.0F));

		PartDefinition Petal_r2 = RightArm.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.95F, 3.8085F, -2.0362F, 0.5293F, -0.3779F, -0.4054F));

		PartDefinition Shoulder_r1 = RightArm.addOrReplaceChild("Shoulder_r1", CubeListBuilder.create().texOffs(32, 57).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.95F, 1.25F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightShoulderBoneGrowth = RightArm.addOrReplaceChild("RightShoulderBoneGrowth", CubeListBuilder.create(), PartPose.offset(-5.0509F, 3.3985F, -0.55F));

		PartDefinition BoneGrowthSpine_r1 = RightShoulderBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r1", CubeListBuilder.create().texOffs(24, 47).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0062F, 0.5732F, -0.55F, -0.4836F, -0.0735F, 0.1229F));

		PartDefinition BoneGrowthStart_r1 = RightShoulderBoneGrowth.addOrReplaceChild("BoneGrowthStart_r1", CubeListBuilder.create().texOffs(84, 96).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0062F, -0.5732F, 0.55F, 0.0F, 0.0F, 0.2618F));

		PartDefinition RightArmShoulderTumors = RightArm.addOrReplaceChild("RightArmShoulderTumors", CubeListBuilder.create(), PartPose.offset(-2.2476F, 0.2696F, -0.1294F));

		PartDefinition SmallTumor_r5 = RightArmShoulderTumors.addOrReplaceChild("SmallTumor_r5", CubeListBuilder.create().texOffs(90, 36).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2514F, -1.2382F, 1.8423F, -2.4733F, -0.5237F, -1.6463F));

		PartDefinition SmallTumor_r6 = RightArmShoulderTumors.addOrReplaceChild("SmallTumor_r6", CubeListBuilder.create().texOffs(88, 90).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3486F, 3.4618F, 1.5423F, 1.9583F, 0.0272F, 3.0928F));

		PartDefinition SmallTumor_r7 = RightArmShoulderTumors.addOrReplaceChild("SmallTumor_r7", CubeListBuilder.create().texOffs(76, 90).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6514F, 2.1618F, -1.4577F, 2.5933F, 0.1141F, -2.2951F));

		PartDefinition SmallTumor_r8 = RightArmShoulderTumors.addOrReplaceChild("SmallTumor_r8", CubeListBuilder.create().texOffs(88, 30).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2514F, -0.6382F, -1.4577F, 2.5382F, -0.0008F, -1.8994F));

		PartDefinition SmallTumor_r9 = RightArmShoulderTumors.addOrReplaceChild("SmallTumor_r9", CubeListBuilder.create().texOffs(88, 24).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0486F, 0.7618F, -0.8577F, 1.5708F, 0.829F, -1.5708F));

		PartDefinition MediumTumor_r3 = RightArmShoulderTumors.addOrReplaceChild("MediumTumor_r3", CubeListBuilder.create().texOffs(72, 30).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2524F, -2.9696F, 0.7294F, 2.9687F, 0.6664F, 1.2732F));

		PartDefinition MediumTumor_r4 = RightArmShoulderTumors.addOrReplaceChild("MediumTumor_r4", CubeListBuilder.create().texOffs(72, 22).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7524F, 0.2304F, 1.3294F, 1.8505F, -0.5593F, -0.4878F));

		PartDefinition MediumTumor_r5 = RightArmShoulderTumors.addOrReplaceChild("MediumTumor_r5", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7524F, -1.7696F, -1.6706F, 1.2039F, -0.343F, -1.0398F));

		PartDefinition RightForearm = RightArm.addOrReplaceChild("RightForearm", CubeListBuilder.create(), PartPose.offset(-2.9002F, 3.6891F, 0.0F));

		PartDefinition Forearm_r1 = RightForearm.addOrReplaceChild("Forearm_r1", CubeListBuilder.create().texOffs(60, 11).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2498F, 3.7609F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition RightForearmBoneGrowth = RightForearm.addOrReplaceChild("RightForearmBoneGrowth", CubeListBuilder.create(), PartPose.offset(-2.4284F, 4.8227F, 0.323F));

		PartDefinition BoneGrowthSpine_r2 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r2", CubeListBuilder.create().texOffs(0, 101).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.0073F, 2.7374F, 0.8646F, 0.5007F, 0.0672F, -0.2706F));

		PartDefinition BoneGrowthSpine_r3 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r3", CubeListBuilder.create().texOffs(76, 85).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0073F, 1.6374F, -1.0354F, -0.4059F, -0.0591F, -0.0411F));

		PartDefinition BoneGrowthSpine_r4 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r4", CubeListBuilder.create().texOffs(12, 85).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0073F, 0.0374F, 0.9646F, 1.0138F, -0.0833F, -0.1252F));

		PartDefinition BoneGrowthSpine_r5 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r5", CubeListBuilder.create().texOffs(76, 81).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0927F, -1.3626F, -1.4354F, -0.7745F, -0.1476F, -0.0372F));

		PartDefinition BoneGrowthSpine_r6 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r6", CubeListBuilder.create().texOffs(52, 23).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0927F, -2.4626F, 0.8646F, 0.7412F, 0.1305F, -0.1238F));

		PartDefinition BoneGrowthMid_r1 = RightForearmBoneGrowth.addOrReplaceChild("BoneGrowthMid_r1", CubeListBuilder.create().texOffs(0, 91).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.1633F, -0.5869F, -0.223F, 0.0349F, 0.0F, 0.0175F));

		PartDefinition RightArmForearmTumors = RightForearm.addOrReplaceChild("RightArmForearmTumors", CubeListBuilder.create(), PartPose.offset(-0.0959F, 6.2423F, -0.1871F));

		PartDefinition SmallTumor_r10 = RightArmForearmTumors.addOrReplaceChild("SmallTumor_r10", CubeListBuilder.create().texOffs(88, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, 0.4F, 1.4F, 2.8277F, -0.291F, -1.3833F));

		PartDefinition SmallTumor_r11 = RightArmForearmTumors.addOrReplaceChild("SmallTumor_r11", CubeListBuilder.create().texOffs(0, 85).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, -0.4F, -1.4F, -3.1151F, 0.2856F, -1.8061F));

		PartDefinition RightHand = RightForearm.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offset(-0.0502F, 5.2391F, 0.0F));

		PartDefinition Hand_r1 = RightHand.addOrReplaceChild("Hand_r1", CubeListBuilder.create().texOffs(28, 84).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.7995F, 4.5218F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightHandBoneGrowth = RightHand.addOrReplaceChild("RightHandBoneGrowth", CubeListBuilder.create(), PartPose.offset(-2.2216F, 4.8473F, 0.0512F));

		PartDefinition BoneGrowthSpine_r7 = RightHandBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r7", CubeListBuilder.create().texOffs(36, 100).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.1361F, 1.0738F, 0.7364F, 0.3905F, 0.0754F, -0.1008F));

		PartDefinition BoneGrowthSpine_r8 = RightHandBoneGrowth.addOrReplaceChild("BoneGrowthSpine_r8", CubeListBuilder.create().texOffs(72, 98).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.1361F, -0.5262F, -0.8636F, -0.7703F, -0.1719F, -0.2269F));

		PartDefinition BoneGrowthEnd_r1 = RightHandBoneGrowth.addOrReplaceChild("BoneGrowthEnd_r1", CubeListBuilder.create().texOffs(76, 96).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0278F, -0.5475F, 0.1273F, -0.0521F, -0.0055F, -0.1395F));

		PartDefinition RightFingers = RightHand.addOrReplaceChild("RightFingers", CubeListBuilder.create(), PartPose.offset(-0.7082F, 8.0711F, -0.15F));

		PartDefinition RightFinger1 = RightFingers.addOrReplaceChild("RightFinger1", CubeListBuilder.create(), PartPose.offset(-0.6087F, 0.2F, -0.95F));

		PartDefinition Claw_r1 = RightFinger1.addOrReplaceChild("Claw_r1", CubeListBuilder.create().texOffs(92, 96).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r1 = RightFinger1.addOrReplaceChild("Finger_r1", CubeListBuilder.create().texOffs(100, 22).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightFinger2 = RightFingers.addOrReplaceChild("RightFinger2", CubeListBuilder.create(), PartPose.offset(-0.6087F, 0.0F, 0.15F));

		PartDefinition Claw_r2 = RightFinger2.addOrReplaceChild("Claw_r2", CubeListBuilder.create().texOffs(64, 98).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r2 = RightFinger2.addOrReplaceChild("Finger_r2", CubeListBuilder.create().texOffs(24, 100).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightFinger3 = RightFingers.addOrReplaceChild("RightFinger3", CubeListBuilder.create(), PartPose.offset(-0.6087F, 0.2F, 1.25F));

		PartDefinition Claw_r3 = RightFinger3.addOrReplaceChild("Claw_r3", CubeListBuilder.create().texOffs(98, 65).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r3 = RightFinger3.addOrReplaceChild("Finger_r3", CubeListBuilder.create().texOffs(100, 26).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition RightThumb = RightFingers.addOrReplaceChild("RightThumb", CubeListBuilder.create(), PartPose.offset(1.8259F, -0.4F, -0.45F));

		PartDefinition Claw_r4 = RightThumb.addOrReplaceChild("Claw_r4", CubeListBuilder.create().texOffs(98, 71).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Finger_r4 = RightThumb.addOrReplaceChild("Finger_r4", CubeListBuilder.create().texOffs(30, 100).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(4.2F, 0.0F, 0.0F));

		PartDefinition Robe_r4 = LeftArm.addOrReplaceChild("Robe_r4", CubeListBuilder.create().texOffs(66, 64).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(62, 0).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 1.25F, 0.0F, 0.0F, 0.0F, -0.2618F));

		PartDefinition LeftShoulderTumor = LeftArm.addOrReplaceChild("LeftShoulderTumor", CubeListBuilder.create(), PartPose.offset(4.5F, 2.7F, 0.2F));

		PartDefinition SmallTumor_r12 = LeftShoulderTumor.addOrReplaceChild("SmallTumor_r12", CubeListBuilder.create().texOffs(92, 42).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2297F, 0.2246F, 0.1432F));

		PartDefinition LeftForearm = LeftArm.addOrReplaceChild("LeftForearm", CubeListBuilder.create(), PartPose.offset(3.1998F, 3.7109F, 0.0F));

		PartDefinition Petal_r3 = LeftForearm.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3502F, 3.4976F, -1.0362F, 0.5144F, -0.5042F, -0.0802F));

		PartDefinition Forearm_r2 = LeftForearm.addOrReplaceChild("Forearm_r2", CubeListBuilder.create().texOffs(66, 54).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0498F, 2.7391F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftHand = LeftForearm.addOrReplaceChild("LeftHand", CubeListBuilder.create(), PartPose.offset(0.0498F, 5.2609F, 0.0F));

		PartDefinition Petal_r4 = LeftHand.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4005F, 1.8366F, 0.9638F, -0.341F, -0.5874F, 0.1397F));

		PartDefinition Hand_r2 = LeftHand.addOrReplaceChild("Hand_r2", CubeListBuilder.create().texOffs(40, 84).addBox(-1.0F, -3.0F, -2.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4995F, 2.4782F, 0.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LeftFingers = LeftHand.addOrReplaceChild("LeftFingers", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1918F, 4.8275F, 0.15F, 0.0F, 3.1416F, 0.0F));

		PartDefinition LeftFinger1 = LeftFingers.addOrReplaceChild("LeftFinger1", CubeListBuilder.create(), PartPose.offset(-0.6086F, 0.2F, -0.85F));

		PartDefinition Claw_r5 = LeftFinger1.addOrReplaceChild("Claw_r5", CubeListBuilder.create().texOffs(40, 99).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r5 = LeftFinger1.addOrReplaceChild("Finger_r5", CubeListBuilder.create().texOffs(100, 30).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftFinger2 = LeftFingers.addOrReplaceChild("LeftFinger2", CubeListBuilder.create(), PartPose.offset(-0.6086F, 0.0F, 0.15F));

		PartDefinition Claw_r6 = LeftFinger2.addOrReplaceChild("Claw_r6", CubeListBuilder.create().texOffs(48, 99).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r6 = LeftFinger2.addOrReplaceChild("Finger_r6", CubeListBuilder.create().texOffs(100, 90).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftFinger3 = LeftFingers.addOrReplaceChild("LeftFinger3", CubeListBuilder.create(), PartPose.offset(-0.6086F, 0.2F, 1.15F));

		PartDefinition Claw_r7 = LeftFinger3.addOrReplaceChild("Claw_r7", CubeListBuilder.create().texOffs(56, 99).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, -0.0436F));

		PartDefinition Finger_r7 = LeftFinger3.addOrReplaceChild("Finger_r7", CubeListBuilder.create().texOffs(100, 94).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LeftThumb = LeftFingers.addOrReplaceChild("LeftThumb", CubeListBuilder.create(), PartPose.offset(1.3259F, -0.4F, 0.65F));

		PartDefinition Claw_r8 = LeftThumb.addOrReplaceChild("Claw_r8", CubeListBuilder.create().texOffs(8, 100).addBox(-2.0F, -1.5F, -0.5F, 4.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2827F, 2.9507F, 0.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Finger_r8 = LeftThumb.addOrReplaceChild("Finger_r8", CubeListBuilder.create().texOffs(100, 98).addBox(-1.0F, -1.5F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.3827F, 0.9507F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Head = UpperTorso.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.05F, -6.5222F, 0.8765F));

		PartDefinition Neck_r1 = Head.addOrReplaceChild("Neck_r1", CubeListBuilder.create().texOffs(32, 23).addBox(-4.0F, -1.5F, -1.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -0.9872F, 0.1305F, -0.1309F, 0.0F, 0.0F));

		PartDefinition NeckTumors = Head.addOrReplaceChild("NeckTumors", CubeListBuilder.create(), PartPose.offset(-0.3812F, 0.6497F, 1.2972F));

		PartDefinition TinyTumor_r1 = NeckTumors.addOrReplaceChild("TinyTumor_r1", CubeListBuilder.create().texOffs(16, 100).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1624F, 0.6994F, -0.0751F, -0.1769F, 0.0512F, -0.0791F));

		PartDefinition SmallTumor_r13 = NeckTumors.addOrReplaceChild("SmallTumor_r13", CubeListBuilder.create().texOffs(40, 93).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5188F, -0.4497F, 0.0376F, -0.1595F, 0.0396F, 0.6546F));

		PartDefinition SmallTumor_r14 = NeckTumors.addOrReplaceChild("SmallTumor_r14", CubeListBuilder.create().texOffs(92, 79).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6812F, -0.2497F, 0.0376F, -0.0866F, 0.1217F, -0.2511F));

		PartDefinition MouthPotion = Head.addOrReplaceChild("MouthPotion", CubeListBuilder.create().texOffs(56, 34).addBox(-1.9293F, -1.3114F, -2.0268F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(82, 71).addBox(-0.4293F, -2.5614F, -0.5268F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(76, 18).addBox(-1.4293F, -3.8114F, -1.5268F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(8, 91).addBox(-0.9293F, -5.3114F, -1.0268F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0522F, 0.0393F, -1.1177F, 0.9164F, 0.0249F, -0.0139F));

		PartDefinition UpperHead = Head.addOrReplaceChild("UpperHead", CubeListBuilder.create(), PartPose.offset(0.0F, -2.2415F, 0.0986F));

		PartDefinition Petal_r5 = UpperHead.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4F, -1.8F, 1.0F, -0.0676F, 0.0931F, 0.125F));

		PartDefinition Petal_r6 = UpperHead.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, -6.6F, 1.4F, 1.1328F, -0.3702F, -1.3007F));

		PartDefinition Petal_r7 = UpperHead.addOrReplaceChild("Petal_r7", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, -8.0F, -2.7F, 0.5689F, -0.9422F, -0.622F));

		PartDefinition Petal_r8 = UpperHead.addOrReplaceChild("Petal_r8", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -6.3F, -4.6F, 0.4225F, -0.4168F, -0.4029F));

		PartDefinition UpperTeeth_r1 = UpperHead.addOrReplaceChild("UpperTeeth_r1", CubeListBuilder.create().texOffs(50, 48).addBox(-4.0F, 4.0F, -4.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2585F, -0.7638F, -0.3142F, 0.0F, 0.0F));

		PartDefinition HeadTumors = UpperHead.addOrReplaceChild("HeadTumors", CubeListBuilder.create(), PartPose.offset(2.0635F, -8.1996F, -1.4834F));

		PartDefinition SmallTumor_r15 = HeadTumors.addOrReplaceChild("SmallTumor_r15", CubeListBuilder.create().texOffs(28, 94).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8818F, 0.4294F, 2.7402F, -0.1142F, 0.4023F, 0.257F));

		PartDefinition SmallTumor_r16 = HeadTumors.addOrReplaceChild("SmallTumor_r16", CubeListBuilder.create().texOffs(52, 93).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9182F, -0.3706F, -1.5598F, -0.1783F, 0.1889F, 0.1991F));

		PartDefinition MediumTumor_r6 = HeadTumors.addOrReplaceChild("MediumTumor_r6", CubeListBuilder.create().texOffs(0, 77).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0365F, -0.0588F, -1.1804F, 0.1047F, -0.2967F, 0.2618F));

		PartDefinition Nose = UpperHead.addOrReplaceChild("Nose", CubeListBuilder.create(), PartPose.offset(0.0F, -2.7993F, -5.5552F));

		PartDefinition Wart_r1 = Nose.addOrReplaceChild("Wart_r1", CubeListBuilder.create().texOffs(86, 71).addBox(0.0F, 5.0F, -6.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -2.6591F, 4.3914F, -0.3142F, 0.0F, 0.0F));

		PartDefinition Nose_r1 = Nose.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(96, 0).addBox(-1.0F, 2.0F, -6.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4591F, 4.7914F, -0.3142F, 0.0F, 0.0F));

		PartDefinition UpperFangs = UpperHead.addOrReplaceChild("UpperFangs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightUpperFang = UpperFangs.addOrReplaceChild("RightUpperFang", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1F, -2.5049F, -5.1217F, 0.0F, 0.2618F, 0.0F));

		PartDefinition Fang_r1 = RightUpperFang.addOrReplaceChild("Fang_r1", CubeListBuilder.create().texOffs(80, 79).addBox(0.0F, -2.0F, -5.5F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 85).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -1.4F, -0.3142F, 0.0F, 0.0F));

		PartDefinition LeftUpperFang = UpperFangs.addOrReplaceChild("LeftUpperFang", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1F, -2.5049F, -5.1217F, 0.0F, -0.2618F, 0.0F));

		PartDefinition Fang_r2 = LeftUpperFang.addOrReplaceChild("Fang_r2", CubeListBuilder.create().texOffs(64, 81).addBox(0.0F, -2.0F, -5.5F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(94, 60).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -1.4F, -0.3142F, 0.0F, 0.0F));

		PartDefinition JawConnectingTissue = UpperHead.addOrReplaceChild("JawConnectingTissue", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tissue_r1 = JawConnectingTissue.addOrReplaceChild("Tissue_r1", CubeListBuilder.create().texOffs(84, 102).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, 0.4F, -3.0F, -3.1009F, 0.4886F, 3.1228F));

		PartDefinition Tissue_r2 = JawConnectingTissue.addOrReplaceChild("Tissue_r2", CubeListBuilder.create().texOffs(74, 102).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 0.4F, -1.8F, 3.1078F, -0.0695F, 3.1012F));

		PartDefinition Tissue_r3 = JawConnectingTissue.addOrReplaceChild("Tissue_r3", CubeListBuilder.create().texOffs(4, 101).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7F, 0.3F, -4.5F, -3.0167F, 0.1729F, 3.1314F));

		PartDefinition Tissue_r4 = JawConnectingTissue.addOrReplaceChild("Tissue_r4", CubeListBuilder.create().texOffs(72, 102).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6F, 0.3F, -3.9F, 0.1407F, -0.1727F, -0.0471F));

		PartDefinition Tissue_r5 = JawConnectingTissue.addOrReplaceChild("Tissue_r5", CubeListBuilder.create().texOffs(102, 34).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, 0.4F, -1.8F, -0.1226F, 0.0866F, -0.0107F));

		PartDefinition HatConnection = UpperHead.addOrReplaceChild("HatConnection", CubeListBuilder.create(), PartPose.offsetAndRotation(0.7204F, -2.8936F, 7.945F, -2.5661F, 0.0656F, 0.4162F));

		PartDefinition HatConnectingTumors = HatConnection.addOrReplaceChild("HatConnectingTumors", CubeListBuilder.create(), PartPose.offset(-1.1134F, 3.7723F, 2.876F));

		PartDefinition SmallTumor_r17 = HatConnectingTumors.addOrReplaceChild("SmallTumor_r17", CubeListBuilder.create().texOffs(94, 54).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8141F, -0.4255F, 0.2697F, 0.5127F, 0.0934F, 0.4713F));

		PartDefinition MediumTumor_r7 = HatConnectingTumors.addOrReplaceChild("MediumTumor_r7", CubeListBuilder.create().texOffs(48, 76).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.107F, 0.9628F, -0.2848F, 0.3446F, 0.3248F, -0.0695F));

		PartDefinition MediumTumor_r8 = HatConnectingTumors.addOrReplaceChild("MediumTumor_r8", CubeListBuilder.create().texOffs(76, 46).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.707F, -0.5372F, 0.0152F, 0.5721F, 0.2066F, 0.1314F));

		PartDefinition HatConnectingTissue = HatConnection.addOrReplaceChild("HatConnectingTissue", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tissue_r6 = HatConnectingTissue.addOrReplaceChild("Tissue_r6", CubeListBuilder.create().texOffs(6, 101).addBox(0.0F, -1.5F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9998F, 1.9016F, 1.3115F, -0.7938F, -0.0451F, -2.8748F));

		PartDefinition Tissue_r7 = HatConnectingTissue.addOrReplaceChild("Tissue_r7", CubeListBuilder.create().texOffs(48, 57).addBox(0.0F, -2.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7998F, 2.0016F, -0.4885F, -0.7723F, -0.2908F, -2.8759F));

		PartDefinition Tissue_r8 = HatConnectingTissue.addOrReplaceChild("Tissue_r8", CubeListBuilder.create().texOffs(64, 67).addBox(0.0F, -2.5F, -0.5F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2002F, 1.8016F, -0.6885F, 0.8093F, 0.1041F, 0.4532F));

		PartDefinition Tissue_r9 = HatConnectingTissue.addOrReplaceChild("Tissue_r9", CubeListBuilder.create().texOffs(86, 102).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.6F, 0.7F, 0.8966F, 0.1041F, 0.4532F));

		PartDefinition Tissue_r10 = HatConnectingTissue.addOrReplaceChild("Tissue_r10", CubeListBuilder.create().texOffs(102, 85).addBox(0.0F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.6F, 2.9F, 0.4603F, 0.1041F, 0.4532F));

		PartDefinition Hat = HatConnection.addOrReplaceChild("Hat", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -1.0F, -3.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition HatPotion = Hat.addOrReplaceChild("HatPotion", CubeListBuilder.create().texOffs(82, 65).addBox(-1.9293F, -1.3114F, -2.0268F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(12, 89).addBox(-0.4293F, -2.5614F, -0.5268F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.25F))
		.texOffs(78, 6).addBox(-1.4293F, -3.8114F, -1.5268F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(100, 18).addBox(-0.9293F, -5.3114F, -1.0268F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.1682F, 0.4744F, 0.8387F, 2.7461F, 0.0878F, 0.177F));

		PartDefinition Hat2 = Hat.addOrReplaceChild("Hat2", CubeListBuilder.create().texOffs(32, 12).addBox(-0.1047F, -3.8361F, -3.2052F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -1.0F, 2.0F, -0.0524F, 0.0F, 0.0262F));

		PartDefinition Petal_r9 = Hat2.addOrReplaceChild("Petal_r9", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.9296F, -3.7064F, -1.245F, 2.3086F, -0.9471F, 0.7583F));

		PartDefinition Petal_r10 = Hat2.addOrReplaceChild("Petal_r10", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4704F, -2.3064F, 0.455F, -0.0504F, -0.0741F, -1.5808F));

		PartDefinition Hat3 = Hat2.addOrReplaceChild("Hat3", CubeListBuilder.create().texOffs(32, 68).addBox(-0.3053F, -3.4694F, -3.5875F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.1047F, 0.0F, 0.0524F));

		PartDefinition Hat4 = Hat3.addOrReplaceChild("Hat4", CubeListBuilder.create().texOffs(102, 39).addBox(-0.6663F, -2.5979F, -4.2198F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, -0.2094F, 0.0F, 0.1047F));

		PartDefinition PotionLiquidDrip_r1 = Hat4.addOrReplaceChild("PotionLiquidDrip_r1", CubeListBuilder.create().texOffs(88, 102).addBox(-1.0F, -1.5F, 0.0F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1337F, -3.9979F, -3.6198F, -0.151F, 0.199F, 0.2352F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(0, 40).addBox(-4.0F, -0.5F, -5.5F, 8.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(24, 51).addBox(-4.0F, -1.5F, -5.5F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.2F, -0.4653F));

		PartDefinition AcidDripple_r1 = Jaw.addOrReplaceChild("AcidDripple_r1", CubeListBuilder.create().texOffs(0, 114).addBox(-3.0F, -1.0F, 0.0F, 6.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.5F, -5.6F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LowerFangs = Jaw.addOrReplaceChild("LowerFangs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLowerFang = LowerFangs.addOrReplaceChild("RightLowerFang", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.1F, 0.4536F, -4.5579F, 0.1869F, -0.0558F, 2.9695F));

		PartDefinition Fang_r3 = RightLowerFang.addOrReplaceChild("Fang_r3", CubeListBuilder.create().texOffs(82, 54).addBox(0.0F, -3.0F, -5.5F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(8, 95).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -1.4F, -0.3142F, 0.0F, 0.0F));

		PartDefinition RightLowerFang2 = LowerFangs.addOrReplaceChild("RightLowerFang2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1F, 0.3536F, -4.5579F, 0.1541F, 0.0617F, -2.9759F));

		PartDefinition Fang_r4 = RightLowerFang2.addOrReplaceChild("Fang_r4", CubeListBuilder.create().texOffs(16, 84).addBox(0.0F, -3.0F, -5.5F, 0.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 95).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.4F, -1.4F, -0.3142F, 0.0F, 0.0F));

		PartDefinition Legs = HipJoint.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0125F, 2.8444F, 0.0028F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(50, 54).addBox(-1.95F, -1.15F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(16, 68).addBox(-1.95F, -1.15F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(2.05F, 0.0F, 0.0F));

		PartDefinition RightKneeJoint = RightLeg.addOrReplaceChild("RightKneeJoint", CubeListBuilder.create().texOffs(56, 23).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(74, 38).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.05F, 7.15F, 0.0F));

		PartDefinition Petal_r11 = RightKneeJoint.addOrReplaceChild("Petal_r11", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.9585F, -0.7362F, 0.2613F, -0.5655F, 0.1483F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 56).addBox(-2.05F, -1.15F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(-0.2F))
		.texOffs(48, 67).addBox(-2.05F, -1.15F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offset(-2.05F, 0.0F, 0.0F));

		PartDefinition Petal_r12 = LeftLeg.addOrReplaceChild("Petal_r12", CubeListBuilder.create().texOffs(-8, 106).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 4.1085F, -0.7362F, 2.9472F, -0.3801F, -2.9832F));

		PartDefinition LeftKneeJoint = LeftLeg.addOrReplaceChild("LeftKneeJoint", CubeListBuilder.create().texOffs(16, 57).addBox(-2.0F, -0.5F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 73).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.1F))
		.texOffs(16, 77).addBox(-2.0F, 3.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(-0.05F, 7.15F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.LeftKneeJoint.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightKneeJoint.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Jaw.xRot = Mth.sin(ageInTicks / 8) / 10;
		animateTumor(RightArmForearmTumors,Mth.sin(ageInTicks/8)/8);
		animateTumor(StomachTumors,-Mth.sin(ageInTicks/8)/8);
		animateTumor(LeftShoulderTumor,-Mth.sin(-ageInTicks/7)/6);
		animateTumor(BackTumors,Mth.cos(ageInTicks/6)/7);
		animateTumor(RightArmShoulderTumors,Mth.sin(ageInTicks/7)/8);
		animateTumor(HeadTumors,Mth.cos(ageInTicks/7)/9);
		float armAn = Mth.sin(ageInTicks/6)/6;
		if (entity.getAttackAnimationTick() <= 0){
			this.animateTentacleX(this.LeftArm, entity.isAggressive()? -1.5f + armAn : armAn);
		}else{
			int attackAnimationTick = entity.getAttackAnimationTick();
			if (attackAnimationTick > 0) {
				this.LeftArm.xRot = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick, 20.0F);
			}
		}
		if (entity.getThrowAnimationTick() <= 0){
			this.animateTentacleX(this.RightArm, entity.isAggressive()? -1.5f - armAn : armAn);
		}else{
			int throwAnimationTick = entity.getThrowAnimationTick();
			if (throwAnimationTick > 0) {
				RightArm.xRot = 2.0F - 1.5F * Mth.triangleWave((float)throwAnimationTick, 20.0F);
			}
		}
		if (entity.getMouthAnimationTick() <= 0){
			this.animateTentacleX(this.UpperHead,-this.Jaw.xRot);
		}else{
			int throwAnimationTick = entity.getMouthAnimationTick();
			if (throwAnimationTick > 0) {
				UpperHead.xRot = 1.5F * Mth.triangleWave((float)throwAnimationTick, 20.0F);
			}
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		MephiticRedo.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}