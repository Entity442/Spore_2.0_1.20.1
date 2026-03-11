package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Hyper.Grober;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class GroberfubOmniModel<T extends Grober> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "groberfubomnimodel"), "main");
	private final ModelPart Groberfub;
	private final ModelPart Torso;
	private final ModelPart Body;
	private final ModelPart UpperBody;
	private final ModelPart UpperSpine;
	private final ModelPart UpperBodyFoliage;
	private final ModelPart PetalCrown5;
	private final ModelPart LowerBody;
	private final ModelPart Ribs;
	private final ModelPart RightHinge;
	private final ModelPart RightRib1;
	private final ModelPart RightRib2;
	private final ModelPart LeftHinge;
	private final ModelPart LeftRib1;
	private final ModelPart LeftRib2;
	private final ModelPart LowerSpine;
	private final ModelPart LowerBodyFoliage;
	private final ModelPart Cape;
	private final ModelPart Head;
	private final ModelPart MainHead;
	private final ModelPart TopHeadPart;
	private final ModelPart UpperFangs;
	private final ModelPart Fang1;
	private final ModelPart Fang2;
	private final ModelPart Fang3;
	private final ModelPart Fang6;
	private final ModelPart HeadGrowths;
	private final ModelPart HeadFoliage;
	private final ModelPart PetalCrown1;
	private final ModelPart PetalCrown2;
	private final ModelPart PetalCrown3;
	private final ModelPart PetalCrown4;
	private final ModelPart MainLowerJaw;
	private final ModelPart LowerFangs;
	private final ModelPart Fang4;
	private final ModelPart Fang5;
	private final ModelPart SmallHead;
	private final ModelPart SmallLowerJaw;
	private final ModelPart Spine;
	private final ModelPart SpineMid;
	private final ModelPart SpineEnd;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart UpperRightLeg;
	private final ModelPart LowerRightLeg;
	private final ModelPart RightFoot;
	private final ModelPart LeftLeg;
	private final ModelPart UpperLeftLeg;
	private final ModelPart LowerLeftLeg;
	private final ModelPart LeftFoot;
	private final ModelPart Arms;
	private final ModelPart RightArm;
	private final ModelPart UpperRightArm;
	private final ModelPart Muscle4;
	private final ModelPart UpperRightArmFoliage;
	private final ModelPart PetalCrown6;
	private final ModelPart LowerRightArm;
	private final ModelPart RightClaws;
	private final ModelPart Muscle5;
	private final ModelPart Muscle6;
	private final ModelPart LowerRightArmFoliage;
	private final ModelPart LeftArm;
	private final ModelPart UpperLeftArm;
	private final ModelPart Muscle1;
	private final ModelPart UpperLeftArmFoliage;
	private final ModelPart LowerLeftArm;
	private final ModelPart LeftClaws;
	private final ModelPart Muscle2;
	private final ModelPart Muscle3;
	private final ModelPart LowerLeftArmFoliage;
	private final ModelPart PetalCrown7;

	public GroberfubOmniModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Groberfub = root.getChild("Groberfub");
		this.Torso = this.Groberfub.getChild("Torso");
		this.Body = this.Torso.getChild("Body");
		this.UpperBody = this.Body.getChild("UpperBody");
		this.UpperSpine = this.UpperBody.getChild("UpperSpine");
		this.UpperBodyFoliage = this.UpperBody.getChild("UpperBodyFoliage");
		this.PetalCrown5 = this.UpperBodyFoliage.getChild("PetalCrown5");
		this.LowerBody = this.Body.getChild("LowerBody");
		this.Ribs = this.LowerBody.getChild("Ribs");
		this.RightHinge = this.Ribs.getChild("RightHinge");
		this.RightRib1 = this.RightHinge.getChild("RightRib1");
		this.RightRib2 = this.RightHinge.getChild("RightRib2");
		this.LeftHinge = this.Ribs.getChild("LeftHinge");
		this.LeftRib1 = this.LeftHinge.getChild("LeftRib1");
		this.LeftRib2 = this.LeftHinge.getChild("LeftRib2");
		this.LowerSpine = this.LowerBody.getChild("LowerSpine");
		this.LowerBodyFoliage = this.LowerBody.getChild("LowerBodyFoliage");
		this.Cape = this.Body.getChild("Cape");
		this.Head = this.Torso.getChild("Head");
		this.MainHead = this.Head.getChild("MainHead");
		this.TopHeadPart = this.MainHead.getChild("TopHeadPart");
		this.UpperFangs = this.TopHeadPart.getChild("UpperFangs");
		this.Fang1 = this.UpperFangs.getChild("Fang1");
		this.Fang2 = this.UpperFangs.getChild("Fang2");
		this.Fang3 = this.UpperFangs.getChild("Fang3");
		this.Fang6 = this.UpperFangs.getChild("Fang6");
		this.HeadGrowths = this.TopHeadPart.getChild("HeadGrowths");
		this.HeadFoliage = this.TopHeadPart.getChild("HeadFoliage");
		this.PetalCrown1 = this.HeadFoliage.getChild("PetalCrown1");
		this.PetalCrown2 = this.HeadFoliage.getChild("PetalCrown2");
		this.PetalCrown3 = this.HeadFoliage.getChild("PetalCrown3");
		this.PetalCrown4 = this.HeadFoliage.getChild("PetalCrown4");
		this.MainLowerJaw = this.MainHead.getChild("MainLowerJaw");
		this.LowerFangs = this.MainLowerJaw.getChild("LowerFangs");
		this.Fang4 = this.LowerFangs.getChild("Fang4");
		this.Fang5 = this.LowerFangs.getChild("Fang5");
		this.SmallHead = this.Head.getChild("SmallHead");
		this.SmallLowerJaw = this.SmallHead.getChild("SmallLowerJaw");
		this.Spine = this.SmallHead.getChild("Spine");
		this.SpineMid = this.Spine.getChild("SpineMid");
		this.SpineEnd = this.SpineMid.getChild("SpineEnd");
		this.Legs = this.Torso.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.UpperRightLeg = this.RightLeg.getChild("UpperRightLeg");
		this.LowerRightLeg = this.RightLeg.getChild("LowerRightLeg");
		this.RightFoot = this.LowerRightLeg.getChild("RightFoot");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.UpperLeftLeg = this.LeftLeg.getChild("UpperLeftLeg");
		this.LowerLeftLeg = this.LeftLeg.getChild("LowerLeftLeg");
		this.LeftFoot = this.LowerLeftLeg.getChild("LeftFoot");
		this.Arms = this.Groberfub.getChild("Arms");
		this.RightArm = this.Arms.getChild("RightArm");
		this.UpperRightArm = this.RightArm.getChild("UpperRightArm");
		this.Muscle4 = this.UpperRightArm.getChild("Muscle4");
		this.UpperRightArmFoliage = this.UpperRightArm.getChild("UpperRightArmFoliage");
		this.PetalCrown6 = this.UpperRightArmFoliage.getChild("PetalCrown6");
		this.LowerRightArm = this.RightArm.getChild("LowerRightArm");
		this.RightClaws = this.LowerRightArm.getChild("RightClaws");
		this.Muscle5 = this.LowerRightArm.getChild("Muscle5");
		this.Muscle6 = this.LowerRightArm.getChild("Muscle6");
		this.LowerRightArmFoliage = this.LowerRightArm.getChild("LowerRightArmFoliage");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.UpperLeftArm = this.LeftArm.getChild("UpperLeftArm");
		this.Muscle1 = this.UpperLeftArm.getChild("Muscle1");
		this.UpperLeftArmFoliage = this.UpperLeftArm.getChild("UpperLeftArmFoliage");
		this.LowerLeftArm = this.LeftArm.getChild("LowerLeftArm");
		this.LeftClaws = this.LowerLeftArm.getChild("LeftClaws");
		this.Muscle2 = this.LowerLeftArm.getChild("Muscle2");
		this.Muscle3 = this.LowerLeftArm.getChild("Muscle3");
		this.LowerLeftArmFoliage = this.LowerLeftArm.getChild("LowerLeftArmFoliage");
		this.PetalCrown7 = this.LowerLeftArmFoliage.getChild("PetalCrown7");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Groberfub = partdefinition.addOrReplaceChild("Groberfub", CubeListBuilder.create(), PartPose.offset(0.0F, 22.6F, -0.4F));

		PartDefinition Torso = Groberfub.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.0F, -21.7F, -3.2F));

		PartDefinition Body = Torso.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 3.9784F, 2.4674F));

		PartDefinition UpperBody = Body.addOrReplaceChild("UpperBody", CubeListBuilder.create(), PartPose.offset(0.0F, -3.9784F, -1.9674F));

		PartDefinition LeftPec_r1 = UpperBody.addOrReplaceChild("LeftPec_r1", CubeListBuilder.create().texOffs(98, 44).addBox(-3.5F, -4.0F, -2.0F, 7.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4049F, 1.5597F, -3.5144F, 0.6592F, -0.1106F, -0.0853F));

		PartDefinition RightPec_r1 = UpperBody.addOrReplaceChild("RightPec_r1", CubeListBuilder.create().texOffs(74, 102).addBox(-3.5F, -4.0F, -2.0F, 7.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3951F, 1.5597F, -3.6144F, 0.6581F, 0.0968F, 0.0746F));

		PartDefinition LeftShoulder_r1 = UpperBody.addOrReplaceChild("LeftShoulder_r1", CubeListBuilder.create().texOffs(72, 33).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -1.4002F, -0.8725F, 0.6713F, 0.2068F, 0.1617F));

		PartDefinition Growth_r1 = UpperBody.addOrReplaceChild("Growth_r1", CubeListBuilder.create().texOffs(108, 134).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.4F)), PartPose.offsetAndRotation(-8.613F, -4.696F, -0.6839F, 0.5809F, -0.141F, -0.2445F));

		PartDefinition RightShoulder_r1 = UpperBody.addOrReplaceChild("RightShoulder_r1", CubeListBuilder.create().texOffs(0, 66).addBox(-2.5F, -4.0F, -4.0F, 5.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -1.4002F, -0.8725F, 0.6713F, -0.2068F, -0.1617F));

		PartDefinition Chest_r1 = UpperBody.addOrReplaceChild("Chest_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -5.0F, -4.5F, 14.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition UpperSpine = UpperBody.addOrReplaceChild("UpperSpine", CubeListBuilder.create(), PartPose.offset(0.0F, 23.1F, 3.1F));

		PartDefinition Rib_r1 = UpperSpine.addOrReplaceChild("Rib_r1", CubeListBuilder.create().texOffs(104, 99).addBox(-5.0F, -2.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5701F, -24.4398F, 1.5975F, 0.6608F, -0.1887F, 0.0306F));

		PartDefinition Rib_r2 = UpperSpine.addOrReplaceChild("Rib_r2", CubeListBuilder.create().texOffs(136, 51).addBox(1.0F, -1.0F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8701F, -24.4398F, 1.5975F, 0.6471F, 0.0126F, 0.1848F));

		PartDefinition Rib_r3 = UpperSpine.addOrReplaceChild("Rib_r3", CubeListBuilder.create().texOffs(30, 60).addBox(-4.0F, 1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4701F, -24.4398F, 1.5975F, 0.6664F, -0.223F, 0.0031F));

		PartDefinition Spine_r1 = UpperSpine.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(58, 116).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6701F, -24.4398F, 1.5975F, 0.6498F, -0.0848F, 0.111F));

		PartDefinition Rib_r4 = UpperSpine.addOrReplaceChild("Rib_r4", CubeListBuilder.create().texOffs(80, 9).addBox(-5.0F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3782F, -28.6006F, -1.6486F, 0.654F, -0.0374F, -0.0946F));

		PartDefinition Rib_r5 = UpperSpine.addOrReplaceChild("Rib_r5", CubeListBuilder.create().texOffs(92, 9).addBox(1.0F, 0.5F, -1.0F, 4.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5782F, -28.6006F, -1.6486F, 0.6574F, 0.1011F, 0.0118F));

		PartDefinition Spine_r2 = UpperSpine.addOrReplaceChild("Spine_r2", CubeListBuilder.create().texOffs(56, 139).addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4782F, -28.6006F, -1.6486F, 0.6538F, 0.0319F, -0.0416F));

		PartDefinition UpperBodyFoliage = UpperBody.addOrReplaceChild("UpperBodyFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 23.1F, 3.1F));

		PartDefinition PetalCrown5 = UpperBodyFoliage.addOrReplaceChild("PetalCrown5", CubeListBuilder.create(), PartPose.offsetAndRotation(8.2F, -26.4F, 0.35F, -0.9492F, 0.0391F, 0.2639F));

		PartDefinition LowerBody = Body.addOrReplaceChild("LowerBody", CubeListBuilder.create(), PartPose.offset(0.0F, 3.9784F, 1.9674F));

		PartDefinition LeftCheek_r1 = LowerBody.addOrReplaceChild("LeftCheek_r1", CubeListBuilder.create().texOffs(11, 41).addBox(1.0F, -1.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.8F))
		.texOffs(4, 41).addBox(-6.0F, -1.0F, 0.0F, 5.0F, 4.0F, 4.0F, new CubeDeformation(0.8F))
		.texOffs(216, 0).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 6.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 37).addBox(-6.0F, -3.0F, -4.0F, 12.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.4947F, 2.0007F, 0.2967F, 0.0F, 0.0F));

		PartDefinition Stomach_r1 = LowerBody.addOrReplaceChild("Stomach_r1", CubeListBuilder.create().texOffs(40, 19).addBox(-5.5F, -3.0F, -4.0F, 11.0F, 6.0F, 8.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -2.1749F, 0.3495F, 0.4974F, 0.0F, 0.0F));

		PartDefinition Ribs = LowerBody.addOrReplaceChild("Ribs", CubeListBuilder.create(), PartPose.offset(0.0932F, -0.4148F, -6.0732F));

		PartDefinition RightHinge = Ribs.addOrReplaceChild("RightHinge", CubeListBuilder.create(), PartPose.offset(-4.0F, -1.0F, 2.725F));

		PartDefinition RightRib1 = RightHinge.addOrReplaceChild("RightRib1", CubeListBuilder.create(), PartPose.offset(0.1F, 0.3F, -3.2F));

		PartDefinition Rib_r6 = RightRib1.addOrReplaceChild("Rib_r6", CubeListBuilder.create().texOffs(32, 118).addBox(0.0F, 0.0728F, -4.027F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.8932F, -0.6419F, 0.0134F, 0.4548F, -0.276F, -0.1325F));

		PartDefinition Rib_r7 = RightRib1.addOrReplaceChild("Rib_r7", CubeListBuilder.create().texOffs(136, 46).addBox(-1.0F, -0.9272F, -3.027F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1932F, -1.342F, 2.7134F, 0.4363F, 0.0F, 0.0F));

		PartDefinition RightRib2 = RightHinge.addOrReplaceChild("RightRib2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, 2.1F, -1.8F, 0.0F, 0.1571F, 0.0F));

		PartDefinition Rib_r8 = RightRib2.addOrReplaceChild("Rib_r8", CubeListBuilder.create().texOffs(130, 136).addBox(0.0F, 0.0728F, -4.027F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.8932F, -0.6419F, 0.0134F, 0.4548F, -0.276F, -0.1325F));

		PartDefinition Rib_r9 = RightRib2.addOrReplaceChild("Rib_r9", CubeListBuilder.create().texOffs(120, 136).addBox(-1.0F, -0.9272F, -3.027F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1932F, -1.342F, 2.7134F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LeftHinge = Ribs.addOrReplaceChild("LeftHinge", CubeListBuilder.create(), PartPose.offset(3.55F, -1.0F, 2.725F));

		PartDefinition LeftRib1 = LeftHinge.addOrReplaceChild("LeftRib1", CubeListBuilder.create(), PartPose.offset(0.55F, 0.3F, -3.2F));

		PartDefinition Rib_r10 = LeftRib1.addOrReplaceChild("Rib_r10", CubeListBuilder.create().texOffs(136, 41).addBox(0.0F, 0.0728F, -4.027F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.5932F, -0.6419F, 0.0134F, 0.4548F, 0.276F, 0.1325F));

		PartDefinition Rib_r11 = LeftRib1.addOrReplaceChild("Rib_r11", CubeListBuilder.create().texOffs(0, 138).addBox(-1.0F, -0.9272F, -3.027F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1932F, -1.342F, 2.7134F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LeftRib2 = LeftHinge.addOrReplaceChild("LeftRib2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.45F, 2.1F, -1.8F, 0.0F, -0.192F, 0.0F));

		PartDefinition Rib_r12 = LeftRib2.addOrReplaceChild("Rib_r12", CubeListBuilder.create().texOffs(80, 138).addBox(0.0F, 0.0728F, -4.027F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.4932F, -0.6419F, 0.0134F, 0.4548F, 0.276F, 0.1325F));

		PartDefinition Rib_r13 = LeftRib2.addOrReplaceChild("Rib_r13", CubeListBuilder.create().texOffs(138, 20).addBox(-1.0F, -0.9272F, -3.027F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1932F, -1.342F, 2.7134F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LowerSpine = LowerBody.addOrReplaceChild("LowerSpine", CubeListBuilder.create(), PartPose.offset(0.0F, 15.1433F, -0.8348F));

		PartDefinition Rib_r14 = LowerSpine.addOrReplaceChild("Rib_r14", CubeListBuilder.create().texOffs(140, 81).addBox(-3.0F, -3.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6323F, -15.4808F, 5.969F, 0.1156F, -0.4262F, 0.1111F));

		PartDefinition Rib_r15 = LowerSpine.addOrReplaceChild("Rib_r15", CubeListBuilder.create().texOffs(140, 87).addBox(1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1323F, -15.4808F, 5.869F, 0.1057F, 0.0944F, 0.169F));

		PartDefinition Rib_r16 = LowerSpine.addOrReplaceChild("Rib_r16", CubeListBuilder.create().texOffs(140, 84).addBox(-3.0F, 1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8323F, -16.2808F, 5.969F, 0.1176F, -0.0597F, -0.0232F));

		PartDefinition Spine_r3 = LowerSpine.addOrReplaceChild("Spine_r3", CubeListBuilder.create().texOffs(48, 134).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9323F, -15.4808F, 5.869F, 0.1053F, -0.0358F, 0.1553F));

		PartDefinition Rib_r17 = LowerSpine.addOrReplaceChild("Rib_r17", CubeListBuilder.create().texOffs(138, 25).addBox(1.5F, -2.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4789F, -19.6538F, 4.7786F, 0.5345F, 0.2319F, -0.0261F));

		PartDefinition Rib_r18 = LowerSpine.addOrReplaceChild("Rib_r18", CubeListBuilder.create().texOffs(140, 75).addBox(-3.5F, -1.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8789F, -19.6538F, 4.7786F, 0.5293F, -0.1914F, -0.2721F));

		PartDefinition Rib_r19 = LowerSpine.addOrReplaceChild("Rib_r19", CubeListBuilder.create().texOffs(140, 78).addBox(1.5F, 0.0F, -1.0F, 3.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5789F, -19.6538F, 4.7786F, 0.5414F, 0.2769F, 0.0017F));

		PartDefinition Spine_r4 = LowerSpine.addOrReplaceChild("Spine_r4", CubeListBuilder.create().texOffs(138, 99).addBox(-0.5F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1789F, -19.6538F, 4.7786F, 0.5199F, 0.0659F, -0.1236F));

		PartDefinition LowerBodyFoliage = LowerBody.addOrReplaceChild("LowerBodyFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 15.1433F, -0.8348F));

		PartDefinition Cape = Body.addOrReplaceChild("Cape", CubeListBuilder.create(), PartPose.offset(0.0F, 19.1216F, 1.1326F));

		PartDefinition CapeEnd_r1 = Cape.addOrReplaceChild("CapeEnd_r1", CubeListBuilder.create().texOffs(232, 9).addBox(-6.0F, -0.0593F, 0.0126F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -25.4658F, 3.8153F, 0.5498F, 0.0F, 0.0F));

		PartDefinition CapeTop_r1 = Cape.addOrReplaceChild("CapeTop_r1", CubeListBuilder.create().texOffs(232, 0).addBox(-6.0F, 0.0069F, 0.0279F, 12.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -30.0947F, -2.6193F, 0.9425F, 0.0F, 0.0F));

		PartDefinition Head = Torso.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(0.0F, -8.6F, -2.6F));

		PartDefinition MainHead = Head.addOrReplaceChild("MainHead", CubeListBuilder.create(), PartPose.offset(-0.1091F, 5.3052F, 1.5742F));

		PartDefinition TopHeadPart = MainHead.addOrReplaceChild("TopHeadPart", CubeListBuilder.create().texOffs(0, 19).addBox(-4.9588F, -10.983F, -7.9754F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(46, 0).addBox(-1.9588F, -12.983F, -7.9754F, 7.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(104, 20).addBox(-4.9588F, -12.983F, -3.9754F, 3.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(82, 63).addBox(-4.9588F, -2.983F, -7.9754F, 10.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(46, 12).addBox(-4.9588F, -2.983F, -1.9754F, 10.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0678F, 0.1778F, -0.0988F));

		PartDefinition Nose_r1 = TopHeadPart.addOrReplaceChild("Nose_r1", CubeListBuilder.create().texOffs(72, 124).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0412F, -4.883F, -7.3754F, -0.1475F, -0.0189F, -0.0852F));

		PartDefinition CheekSlope_r1 = TopHeadPart.addOrReplaceChild("CheekSlope_r1", CubeListBuilder.create().texOffs(126, 95).addBox(-3.0F, -1.5F, -1.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4585F, -4.4852F, -7.5537F, 0.0777F, 0.0471F, -0.0317F));

		PartDefinition EyebrowSlope_r1 = TopHeadPart.addOrReplaceChild("EyebrowSlope_r1", CubeListBuilder.create().texOffs(126, 15).addBox(-3.0F, -1.5F, -1.0F, 6.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4415F, -9.3852F, -7.9537F, 0.0776F, 0.0123F, -0.0344F));

		PartDefinition UpperFangs = TopHeadPart.addOrReplaceChild("UpperFangs", CubeListBuilder.create(), PartPose.offset(-2.379F, -1.4317F, -6.3965F));

		PartDefinition Fang1 = UpperFangs.addOrReplaceChild("Fang1", CubeListBuilder.create(), PartPose.offset(-0.4548F, -0.3345F, -1.6214F));

		PartDefinition Fang1Seg2_r1 = Fang1.addOrReplaceChild("Fang1Seg2_r1", CubeListBuilder.create().texOffs(26, 69).addBox(-0.5F, 1.5F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.6922F, 0.3931F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Fang1_r1 = Fang1.addOrReplaceChild("Fang1_r1", CubeListBuilder.create().texOffs(28, 66).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.4419F, 0.1925F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Fang2 = UpperFangs.addOrReplaceChild("Fang2", CubeListBuilder.create(), PartPose.offset(-3.0239F, -0.0936F, 1.384F));

		PartDefinition Fang2Seg2_r1 = Fang2.addOrReplaceChild("Fang2Seg2_r1", CubeListBuilder.create().texOffs(26, 71).addBox(-1.0F, 1.7322F, -0.6623F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9947F, -1.4226F, -0.0414F, 0.2706F, -0.235F, 0.0761F));

		PartDefinition Fang2_r1 = Fang2.addOrReplaceChild("Fang2_r1", CubeListBuilder.create().texOffs(26, 66).addBox(0.0F, -0.2678F, -0.6623F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5191F, -1.3811F, -0.132F, 0.1876F, -0.3049F, 0.3848F));

		PartDefinition Fang3 = UpperFangs.addOrReplaceChild("Fang3", CubeListBuilder.create(), PartPose.offset(5.1788F, 0.0281F, -1.9625F));

		PartDefinition Fang3Seg2_r1 = Fang3.addOrReplaceChild("Fang3Seg2_r1", CubeListBuilder.create().texOffs(28, 70).addBox(-0.5F, 1.4881F, -0.8918F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.424F, -1.4638F, 0.7087F, 0.0072F, -0.056F, -0.2559F));

		PartDefinition Fang3_r1 = Fang3.addOrReplaceChild("Fang3_r1", CubeListBuilder.create().texOffs(28, 68).addBox(-0.5F, -0.5118F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3836F, -1.4163F, 0.2254F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition Fang6 = UpperFangs.addOrReplaceChild("Fang6", CubeListBuilder.create(), PartPose.offsetAndRotation(6.7788F, 0.0281F, -1.9625F, -0.1571F, 0.0F, 0.3665F));

		PartDefinition Fang3Seg3_r1 = Fang6.addOrReplaceChild("Fang3Seg3_r1", CubeListBuilder.create().texOffs(28, 74).addBox(-0.5F, 1.4881F, -0.8918F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.424F, -1.4638F, 0.7087F, 0.0072F, -0.056F, -0.2559F));

		PartDefinition Fang4_r1 = Fang6.addOrReplaceChild("Fang4_r1", CubeListBuilder.create().texOffs(74, 16).addBox(-0.5F, -0.5118F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3836F, -1.4163F, 0.2254F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition HeadGrowths = TopHeadPart.addOrReplaceChild("HeadGrowths", CubeListBuilder.create(), PartPose.offset(0.0412F, 27.117F, 4.1246F));

		PartDefinition Growth_r2 = HeadGrowths.addOrReplaceChild("Growth_r2", CubeListBuilder.create().texOffs(130, 115).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3F, -30.8F, -2.8987F, -0.0355F, -0.0027F, 0.2617F));

		PartDefinition Growth_r3 = HeadGrowths.addOrReplaceChild("Growth_r3", CubeListBuilder.create().texOffs(130, 107).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -31.4F, -2.8F, -0.017F, 0.1885F, 0.0507F));

		PartDefinition Growth_r4 = HeadGrowths.addOrReplaceChild("Growth_r4", CubeListBuilder.create().texOffs(32, 125).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2F, -32.5F, -7.7F, 0.1219F, 0.0085F, 0.1052F));

		PartDefinition Growth_r5 = HeadGrowths.addOrReplaceChild("Growth_r5", CubeListBuilder.create().texOffs(20, 98).addBox(-2.0F, -1.0F, -4.5F, 4.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8433F, -39.6616F, -6.2371F, 0.0321F, 0.0136F, -0.4012F));

		PartDefinition Growth_r6 = HeadGrowths.addOrReplaceChild("Growth_r6", CubeListBuilder.create().texOffs(126, 9).addBox(-2.5F, -1.5F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3171F, -38.1401F, -3.3612F, 0.0301F, -0.0177F, 0.5321F));

		PartDefinition Growth_r7 = HeadGrowths.addOrReplaceChild("Growth_r7", CubeListBuilder.create().texOffs(78, 89).addBox(-2.0F, -2.0F, -4.5F, 4.0F, 4.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1884F, -34.3133F, -5.977F, 0.0299F, -0.018F, 0.5408F));

		PartDefinition Growth_r8 = HeadGrowths.addOrReplaceChild("Growth_r8", CubeListBuilder.create().texOffs(68, 114).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0279F, -39.2263F, -7.7228F, 0.0346F, 0.0043F, -0.1221F));

		PartDefinition Growth_r9 = HeadGrowths.addOrReplaceChild("Growth_r9", CubeListBuilder.create().texOffs(58, 132).addBox(-0.5F, -2.5F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2707F, -39.5533F, -2.9413F, 0.0343F, 0.0067F, -0.1919F));

		PartDefinition Growth_r10 = HeadGrowths.addOrReplaceChild("Growth_r10", CubeListBuilder.create().texOffs(126, 80).addBox(-2.0F, -2.5F, -1.5F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0657F, -38.4544F, -10.7624F, 0.0347F, 0.0036F, -0.1047F));

		PartDefinition Growth_r11 = HeadGrowths.addOrReplaceChild("Growth_r11", CubeListBuilder.create().texOffs(78, 12).addBox(-2.0F, -3.5F, -4.5F, 4.0F, 7.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6181F, -38.169F, -6.1675F, 0.0346F, 0.0043F, -0.1221F));

		PartDefinition Growth_r12 = HeadGrowths.addOrReplaceChild("Growth_r12", CubeListBuilder.create().texOffs(124, 54).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.5F, -38.6F, -9.7F, 0.0349F, 0.0012F, -0.0349F));

		PartDefinition Growth_r13 = HeadGrowths.addOrReplaceChild("Growth_r13", CubeListBuilder.create().texOffs(0, 133).addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1993F, -35.0261F, -2.3014F, -0.443F, -0.0336F, -1.6838F));

		PartDefinition Growth_r14 = HeadGrowths.addOrReplaceChild("Growth_r14", CubeListBuilder.create().texOffs(130, 121).addBox(-2.0F, -1.0F, -1.5F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4993F, -37.6261F, -1.9014F, -0.1921F, -0.0027F, 0.0523F));

		PartDefinition Growth_r15 = HeadGrowths.addOrReplaceChild("Growth_r15", CubeListBuilder.create().texOffs(84, 114).addBox(-1.5F, -2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -38.6F, -3.2F, 0.0523F, -0.0027F, 0.0523F));

		PartDefinition HeadFoliage = TopHeadPart.addOrReplaceChild("HeadFoliage", CubeListBuilder.create(), PartPose.offset(0.0412F, 26.217F, 4.7246F));

		PartDefinition Petal_r1 = HeadFoliage.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4F, -31.2F, -12.2F, 2.3761F, 1.267F, 2.2022F));

		PartDefinition Petal_r2 = HeadFoliage.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.8F, -40.5F, -3.3F, -2.4458F, 0.8738F, -2.3906F));

		PartDefinition Petal_r3 = HeadFoliage.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(-8, 155).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4F, -36.6F, -2.4F, -0.3164F, -0.4012F, 0.2202F));

		PartDefinition Petal_r4 = HeadFoliage.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(-8, 164).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, -31.2F, -10.2F, 0.1067F, -0.417F, 0.1658F));

		PartDefinition Petal_r5 = HeadFoliage.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, -35.1F, -12.5F, 0.3383F, -0.5274F, -0.2629F));

		PartDefinition Petal_r6 = HeadFoliage.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1F, -38.4F, -12.5F, 0.3778F, -0.0715F, 0.2287F));

		PartDefinition Petal_r7 = HeadFoliage.addOrReplaceChild("Petal_r7", CubeListBuilder.create().texOffs(-8, 155).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7F, -31.8F, -7.4F, -0.2079F, -0.5077F, -0.2351F));

		PartDefinition Petal_r8 = HeadFoliage.addOrReplaceChild("Petal_r8", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9F, -37.0F, -3.8F, -0.1919F, 0.0067F, 0.0343F));

		PartDefinition PetalCrown1 = HeadFoliage.addOrReplaceChild("PetalCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.2F, -39.3F, -9.15F, 0.0873F, 0.0F, -0.192F));

		PartDefinition Petal_r9 = PetalCrown1.addOrReplaceChild("Petal_r9", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 0.1F, -0.05F, 0.0114F, -0.0529F, 0.4352F));

		PartDefinition Petal_r10 = PetalCrown1.addOrReplaceChild("Petal_r10", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 0.1F, -0.05F, 0.045F, -0.0301F, -0.3331F));

		PartDefinition Petal_r11 = PetalCrown1.addOrReplaceChild("Petal_r11", CubeListBuilder.create().texOffs(-8, 165).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -3.15F, -1.5405F, 1.1485F, -1.524F));

		PartDefinition Petal_r12 = PetalCrown1.addOrReplaceChild("Petal_r12", CubeListBuilder.create().texOffs(-8, 155).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 3.25F, 1.5433F, 1.1027F, 1.5653F));

		PartDefinition PetalCrown2 = HeadFoliage.addOrReplaceChild("PetalCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(5.8F, -40.7F, -10.25F, 0.2349F, -0.0396F, 0.2777F));

		PartDefinition Petal_r13 = PetalCrown2.addOrReplaceChild("Petal_r13", CubeListBuilder.create().texOffs(-8, 155).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 0.1F, -0.05F, 0.0114F, -0.0529F, 0.4352F));

		PartDefinition Petal_r14 = PetalCrown2.addOrReplaceChild("Petal_r14", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 0.1F, -0.05F, 0.045F, -0.0301F, -0.3331F));

		PartDefinition Petal_r15 = PetalCrown2.addOrReplaceChild("Petal_r15", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -3.15F, -1.5405F, 1.1485F, -1.524F));

		PartDefinition Petal_r16 = PetalCrown2.addOrReplaceChild("Petal_r16", CubeListBuilder.create().texOffs(-8, 165).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 3.25F, 1.5433F, 1.1027F, 1.5653F));

		PartDefinition PetalCrown3 = HeadFoliage.addOrReplaceChild("PetalCrown3", CubeListBuilder.create(), PartPose.offsetAndRotation(7.7F, -37.2F, -6.65F, -0.134F, 0.3024F, 1.6262F));

		PartDefinition Petal_r17 = PetalCrown3.addOrReplaceChild("Petal_r17", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 0.1F, -0.05F, 0.0114F, -0.0529F, 0.4352F));

		PartDefinition Petal_r18 = PetalCrown3.addOrReplaceChild("Petal_r18", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 0.1F, -0.05F, 0.045F, -0.0301F, -0.3331F));

		PartDefinition Petal_r19 = PetalCrown3.addOrReplaceChild("Petal_r19", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -3.15F, -1.5405F, 1.1485F, -1.524F));

		PartDefinition Petal_r20 = PetalCrown3.addOrReplaceChild("Petal_r20", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 3.25F, 1.5433F, 1.1027F, 1.5653F));

		PartDefinition PetalCrown4 = HeadFoliage.addOrReplaceChild("PetalCrown4", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.7F, -33.7F, -3.15F, -2.6343F, -0.7529F, 1.3562F));

		PartDefinition Petal_r21 = PetalCrown4.addOrReplaceChild("Petal_r21", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2F, 0.1F, -0.05F, 0.0114F, -0.0529F, 0.4352F));

		PartDefinition Petal_r22 = PetalCrown4.addOrReplaceChild("Petal_r22", CubeListBuilder.create().texOffs(-8, 165).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, 0.1F, -0.05F, 0.045F, -0.0301F, -0.3331F));

		PartDefinition Petal_r23 = PetalCrown4.addOrReplaceChild("Petal_r23", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, -3.15F, -1.5405F, 1.1485F, -1.524F));

		PartDefinition Petal_r24 = PetalCrown4.addOrReplaceChild("Petal_r24", CubeListBuilder.create().texOffs(-8, 146).addBox(-4.0F, 0.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.1F, 3.25F, 1.5433F, 1.1027F, 1.5653F));

		PartDefinition MainLowerJaw = MainHead.addOrReplaceChild("MainLowerJaw", CubeListBuilder.create(), PartPose.offset(0.1265F, -0.832F, -1.8195F));

		PartDefinition LowerTeeth_r1 = MainLowerJaw.addOrReplaceChild("LowerTeeth_r1", CubeListBuilder.create().texOffs(80, 0).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(78, 81).addBox(-5.0F, -1.0F, -6.0F, 10.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0175F, 0.0268F, 0.1453F, 0.2181F, -0.0038F, 0.017F));

		PartDefinition Growth_r16 = MainLowerJaw.addOrReplaceChild("Growth_r16", CubeListBuilder.create().texOffs(136, 37).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-3.4256F, 1.3292F, -4.1531F, 0.2181F, -0.0038F, 0.017F));

		PartDefinition LowerFangs = MainLowerJaw.addOrReplaceChild("LowerFangs", CubeListBuilder.create(), PartPose.offset(-0.0175F, 28.1268F, 5.8453F));

		PartDefinition Fang4 = LowerFangs.addOrReplaceChild("Fang4", CubeListBuilder.create(), PartPose.offsetAndRotation(5.2586F, -29.3206F, -10.4836F, 1.5882F, 1.4399F, -1.5708F));

		PartDefinition Fang4Seg2_r1 = Fang4.addOrReplaceChild("Fang4Seg2_r1", CubeListBuilder.create().texOffs(26, 73).addBox(-0.5F, 1.4881F, -0.8918F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.424F, -1.4638F, 0.7087F, 0.0072F, -0.056F, -0.2559F));

		PartDefinition Fang4_r2 = Fang4.addOrReplaceChild("Fang4_r2", CubeListBuilder.create().texOffs(28, 72).addBox(-0.5F, -0.5119F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3836F, -1.4163F, 0.2254F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition Fang5 = LowerFangs.addOrReplaceChild("Fang5", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.7414F, -29.0206F, -12.2836F, -0.3626F, -0.2313F, -3.0843F));

		PartDefinition Fang5Seg2_r1 = Fang5.addOrReplaceChild("Fang5Seg2_r1", CubeListBuilder.create().texOffs(74, 14).addBox(-0.5F, 1.4881F, -0.8918F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.424F, -1.4638F, 0.7087F, 0.0072F, -0.056F, -0.2559F));

		PartDefinition Fang5_r1 = Fang5.addOrReplaceChild("Fang5_r1", CubeListBuilder.create().texOffs(74, 12).addBox(-0.5F, -0.5118F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3836F, -1.4163F, 0.2254F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition SmallHead = Head.addOrReplaceChild("SmallHead", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3423F, 1.8832F, 2.9071F, 3.0985F, 0.0068F, 3.124F));

		PartDefinition UpperTeeth_r1 = SmallHead.addOrReplaceChild("UpperTeeth_r1", CubeListBuilder.create().texOffs(82, 71).addBox(-3.5F, 3.0F, -3.5F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(96, 109).addBox(1.5F, -2.0F, -3.5F, 2.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(50, 94).addBox(-3.5F, -3.0F, -3.5F, 5.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0423F, -3.8832F, -2.0071F, -0.0436F, 0.0F, 0.0436F));

		PartDefinition Growth_r17 = SmallHead.addOrReplaceChild("Growth_r17", CubeListBuilder.create().texOffs(110, 71).addBox(-3.5F, -3.0F, -3.5F, 4.0F, 4.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.2577F, -3.8832F, -2.0071F, -0.0436F, 0.0F, 0.0436F));

		PartDefinition SmallLowerJaw = SmallHead.addOrReplaceChild("SmallLowerJaw", CubeListBuilder.create(), PartPose.offset(0.1024F, 0.1015F, 0.3171F));

		PartDefinition LowerTeeth_r2 = SmallLowerJaw.addOrReplaceChild("LowerTeeth_r2", CubeListBuilder.create().texOffs(96, 102).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(98, 56).addBox(-3.5F, -0.5F, -6.0F, 7.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2601F, -0.1847F, 0.0758F, 0.3008F, -0.087F, 0.0462F));

		PartDefinition Spine = SmallHead.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(-0.0725F, -0.552F, -1.5291F));

		PartDefinition Spine_r5 = Spine.addOrReplaceChild("Spine_r5", CubeListBuilder.create().texOffs(90, 139).addBox(-1.0647F, -0.1644F, -0.9713F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0366F, -0.0318F, 0.3733F, -1.4119F, -0.075F, 0.02F));

		PartDefinition SpineMid = Spine.addOrReplaceChild("SpineMid", CubeListBuilder.create(), PartPose.offset(0.2634F, 0.6318F, -4.0733F));

		PartDefinition Rib_r20 = SpineMid.addOrReplaceChild("Rib_r20", CubeListBuilder.create().texOffs(78, 31).addBox(-0.3136F, -0.4519F, -0.4934F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5429F, 0.3027F, -0.885F, -1.1935F, -0.2049F, 0.3284F));

		PartDefinition Rib_r21 = SpineMid.addOrReplaceChild("Rib_r21", CubeListBuilder.create().texOffs(86, 31).addBox(-2.7684F, -0.4994F, -0.4677F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0111F, 0.1665F, -0.7591F, -1.1491F, 0.0689F, -0.2983F));

		PartDefinition Rib_r22 = SpineMid.addOrReplaceChild("Rib_r22", CubeListBuilder.create().texOffs(82, 79).addBox(-2.8068F, -0.4585F, -0.4763F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0398F, 0.5612F, -1.9947F, -1.2247F, 0.2553F, -0.7568F));

		PartDefinition Spine_r6 = SpineMid.addOrReplaceChild("Spine_r6", CubeListBuilder.create().texOffs(140, 69).addBox(-1.0517F, -0.3773F, -1.0384F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0732F, 0.0364F, 0.1467F, -1.1501F, -0.075F, 0.02F));

		PartDefinition SpineEnd = SpineMid.addOrReplaceChild("SpineEnd", CubeListBuilder.create(), PartPose.offset(0.2848F, 1.1044F, -2.6113F));

		PartDefinition Rib_r23 = SpineEnd.addOrReplaceChild("Rib_r23", CubeListBuilder.create().texOffs(122, 107).addBox(-0.3776F, -0.5001F, -0.5171F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.2061F, 3.1548F, -1.3702F, -2.0235F, 0.0315F, 2.0145F));

		PartDefinition Rib_r24 = SpineEnd.addOrReplaceChild("Rib_r24", CubeListBuilder.create().texOffs(98, 79).addBox(-0.3776F, -0.5001F, -0.5171F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.0061F, 1.7548F, -0.8702F, -0.6115F, -0.3201F, 0.5749F));

		PartDefinition Rib_r25 = SpineEnd.addOrReplaceChild("Rib_r25", CubeListBuilder.create().texOffs(90, 79).addBox(-2.6224F, -0.4999F, -0.4829F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.3061F, 1.1548F, -0.6702F, -0.4338F, 0.0934F, -0.2448F));

		PartDefinition Spine_r7 = SpineEnd.addOrReplaceChild("Spine_r7", CubeListBuilder.create().texOffs(98, 139).addBox(-1.0517F, -0.3773F, -1.0384F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.0116F, -0.268F, 0.1579F, -0.4083F, -0.075F, 0.02F));

		PartDefinition Legs = Torso.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 21.4F, 6.4F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-3.0F, -11.0F, 0.0F));

		PartDefinition UpperRightLeg = RightLeg.addOrReplaceChild("UpperRightLeg", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition RightThighClothing_r1 = UpperRightLeg.addOrReplaceChild("RightThighClothing_r1", CubeListBuilder.create().texOffs(230, 16).addBox(-3.0F, -5.0F, -3.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.2F))
		.texOffs(30, 64).addBox(-3.0F, -5.0F, -3.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 1.7F, -3.5F, -1.2013F, 0.3272F, 0.1238F));

		PartDefinition LowerRightLeg = RightLeg.addOrReplaceChild("LowerRightLeg", CubeListBuilder.create(), PartPose.offset(-3.0F, 5.0F, -6.0F));

		PartDefinition RightLeg_r1 = LowerRightLeg.addOrReplaceChild("RightLeg_r1", CubeListBuilder.create().texOffs(40, 49).addBox(-3.0F, -2.5F, -4.5F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4846F, 1.2602F, 3.4131F, -0.1723F, 0.267F, 0.0023F));

		PartDefinition RightFoot = LowerRightLeg.addOrReplaceChild("RightFoot", CubeListBuilder.create(), PartPose.offset(2.5F, 4.2F, 8.2F));

		PartDefinition Claw_r1 = RightFoot.addOrReplaceChild("Claw_r1", CubeListBuilder.create().texOffs(128, 71).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1F, 2.1F, -5.0F, 0.0436F, 0.2618F, 0.0F));

		PartDefinition Claw_r2 = RightFoot.addOrReplaceChild("Claw_r2", CubeListBuilder.create().texOffs(128, 127).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7F, 2.1F, -5.5F, 0.0436F, 0.2618F, 0.0F));

		PartDefinition Claw_r3 = RightFoot.addOrReplaceChild("Claw_r3", CubeListBuilder.create().texOffs(46, 125).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 2.1F, -5.8F, 0.0436F, 0.2618F, 0.0F));

		PartDefinition RightFoot_r1 = RightFoot.addOrReplaceChild("RightFoot_r1", CubeListBuilder.create().texOffs(46, 107).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9018F, 1.8163F, -2.5669F, 0.1768F, 0.267F, 0.0023F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(3.0F, -11.0F, 0.0F));

		PartDefinition UpperLeftLeg = LeftLeg.addOrReplaceChild("UpperLeftLeg", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 0.0F));

		PartDefinition LeftThighClothing_r1 = UpperLeftLeg.addOrReplaceChild("LeftThighClothing_r1", CubeListBuilder.create().texOffs(230, 16).addBox(-3.0F, -5.0F, -3.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.2F))
		.texOffs(56, 64).addBox(-3.0F, -5.0F, -3.5F, 6.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, 2.2F, -3.5F, -1.1421F, -0.2293F, -0.0851F));

		PartDefinition LowerLeftLeg = LeftLeg.addOrReplaceChild("LowerLeftLeg", CubeListBuilder.create(), PartPose.offset(2.0F, 5.0F, -6.0F));

		PartDefinition LeftLeg_r1 = LowerLeftLeg.addOrReplaceChild("LeftLeg_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-3.0F, -2.5F, -4.5F, 5.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2154F, 1.2602F, 3.7131F, -0.1563F, -0.1857F, -0.0636F));

		PartDefinition LeftFoot = LowerLeftLeg.addOrReplaceChild("LeftFoot", CubeListBuilder.create(), PartPose.offset(-1.5F, 4.2F, 8.2F));

		PartDefinition Claw_r4 = LeftFoot.addOrReplaceChild("Claw_r4", CubeListBuilder.create().texOffs(130, 60).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7F, 2.1F, -5.1F, 0.0432F, -0.2177F, -0.0206F));

		PartDefinition Claw_r5 = LeftFoot.addOrReplaceChild("Claw_r5", CubeListBuilder.create().texOffs(84, 129).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 2.1F, -5.4F, 0.0432F, -0.2177F, -0.0206F));

		PartDefinition Claw_r6 = LeftFoot.addOrReplaceChild("Claw_r6", CubeListBuilder.create().texOffs(96, 130).addBox(0.0F, -1.5F, -5.5F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 2.1F, -5.6F, 0.0432F, -0.2177F, -0.0206F));

		PartDefinition LeftFoot_r1 = LeftFoot.addOrReplaceChild("LeftFoot_r1", CubeListBuilder.create().texOffs(20, 109).addBox(-2.5F, -1.5F, -3.0F, 5.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5982F, 1.8163F, -2.4669F, 0.1556F, -0.2202F, 0.0073F));

		PartDefinition Arms = Groberfub.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.3F, -3.2F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6F, -24.4F, -1.3F, 0.0F, -0.3054F, 0.0F));

		PartDefinition UpperRightArm = RightArm.addOrReplaceChild("UpperRightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0305F, -0.0056F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition UpperRightArm_r1 = UpperRightArm.addOrReplaceChild("UpperRightArm_r1", CubeListBuilder.create().texOffs(0, 98).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-1.9556F, 1.7178F, 0.0F, 0.0F, 0.0F, 0.2269F));

		PartDefinition RightShoulderMuscle_r1 = UpperRightArm.addOrReplaceChild("RightShoulderMuscle_r1", CubeListBuilder.create().texOffs(58, 124).addBox(-1.0F, -1.5F, -2.5F, 2.0F, 3.0F, 5.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-4.9668F, 6.6266F, 0.0F, 0.0F, 0.0F, -0.0349F));

		PartDefinition RightShoulder_r2 = UpperRightArm.addOrReplaceChild("RightShoulder_r2", CubeListBuilder.create().texOffs(104, 9).addBox(-2.5F, -3.0F, -2.5F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-2.6681F, 1.905F, 0.0F, 0.0F, 0.0F, 0.2269F));

		PartDefinition Muscle4 = UpperRightArm.addOrReplaceChild("Muscle4", CubeListBuilder.create(), PartPose.offset(-0.3338F, 5.3069F, 0.0F));

		PartDefinition Muscle_r1 = Muscle4.addOrReplaceChild("Muscle_r1", CubeListBuilder.create().texOffs(126, 88).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.6651F, -2.7513F, 0.0F, 0.0F, 0.0F, -0.1222F));

		PartDefinition Muscle_r2 = Muscle4.addOrReplaceChild("Muscle_r2", CubeListBuilder.create().texOffs(14, 127).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.6096F, 2.7693F, 0.0F, 0.0F, 0.0F, 0.576F));

		PartDefinition Muscle_r3 = Muscle4.addOrReplaceChild("Muscle_r3", CubeListBuilder.create().texOffs(100, 121).addBox(-0.5F, 0.5F, -1.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.0218F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition UpperRightArmFoliage = UpperRightArm.addOrReplaceChild("UpperRightArmFoliage", CubeListBuilder.create(), PartPose.offset(8.6305F, 25.5056F, 4.9F));

		PartDefinition PetalCrown6 = UpperRightArmFoliage.addOrReplaceChild("PetalCrown6", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.2F, -24.1F, -4.55F, -0.0104F, -1.2115F, -1.3225F));

		PartDefinition LowerRightArm = RightArm.addOrReplaceChild("LowerRightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.5582F, 10.0066F, -0.1F, 0.0F, 0.0F, -0.0524F));

		PartDefinition LowerRightHand_r1 = LowerRightArm.addOrReplaceChild("LowerRightHand_r1", CubeListBuilder.create().texOffs(70, 49).addBox(-3.5F, -0.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.0498F, 9.2355F, 0.0F, 0.0F, 0.0F, 0.0087F));

		PartDefinition LowerRightArm_r1 = LowerRightArm.addOrReplaceChild("LowerRightArm_r1", CubeListBuilder.create().texOffs(0, 82).addBox(-3.5F, -3.5F, -3.5F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6582F, 2.2934F, 0.5F, 0.0F, 0.0F, 0.0524F));

		PartDefinition RightClaws = LowerRightArm.addOrReplaceChild("RightClaws", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.5088F, 13.8285F, 0.1F, 3.1416F, 0.0F, -2.9322F));

		PartDefinition Claw_r7 = RightClaws.addOrReplaceChild("Claw_r7", CubeListBuilder.create().texOffs(134, 28).addBox(-0.4739F, -1.5176F, 0.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 134).addBox(-0.4739F, -1.5176F, 2.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 134).addBox(-0.4739F, -1.5176F, 4.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8672F, -3.0844F, -2.0F, 0.0F, 0.0F, 0.0524F));

		PartDefinition Muscle5 = LowerRightArm.addOrReplaceChild("Muscle5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0466F, 4.4825F, 0.8F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Muscle_r4 = Muscle5.addOrReplaceChild("Muscle_r4", CubeListBuilder.create().texOffs(42, 116).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0016F, 2.1487F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Muscle_r5 = Muscle5.addOrReplaceChild("Muscle_r5", CubeListBuilder.create().texOffs(0, 115).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0016F, -2.3513F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Muscle_r6 = Muscle5.addOrReplaceChild("Muscle_r6", CubeListBuilder.create().texOffs(84, 121).addBox(-0.5F, 1.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0884F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition Muscle6 = LowerRightArm.addOrReplaceChild("Muscle6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.3534F, 3.7825F, 0.8F, 3.1416F, 0.0F, -2.906F));

		PartDefinition Muscle_r7 = Muscle6.addOrReplaceChild("Muscle_r7", CubeListBuilder.create().texOffs(16, 118).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0016F, 2.1487F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Muscle_r8 = Muscle6.addOrReplaceChild("Muscle_r8", CubeListBuilder.create().texOffs(120, 37).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0016F, -2.3513F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Muscle_r9 = Muscle6.addOrReplaceChild("Muscle_r9", CubeListBuilder.create().texOffs(122, 20).addBox(-0.5F, 1.5F, -1.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0884F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition LowerRightArmFoliage = LowerRightArm.addOrReplaceChild("LowerRightArmFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offset(8.1F, -25.0F, -1.0F));

		PartDefinition UpperLeftArm = LeftArm.addOrReplaceChild("UpperLeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0195F, -0.0056F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition UpperLeftArm_r1 = UpperLeftArm.addOrReplaceChild("UpperLeftArm_r1", CubeListBuilder.create().texOffs(98, 28).addBox(-2.5F, -1.5F, -2.5F, 5.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9195F, 1.7056F, 0.0F, 0.0F, 0.0F, 0.2269F));

		PartDefinition LeftShoulderMuscle_r1 = UpperLeftArm.addOrReplaceChild("LeftShoulderMuscle_r1", CubeListBuilder.create().texOffs(114, 109).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 4.0F, 5.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.3311F, 6.5397F, 0.0F, 0.0F, 0.0F, 0.0175F));

		PartDefinition Growth_r18 = UpperLeftArm.addOrReplaceChild("Growth_r18", CubeListBuilder.create().texOffs(140, 54).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.7F)), PartPose.offsetAndRotation(-4.4939F, 1.1807F, 1.5F, 0.0523F, -0.0027F, 0.2792F));

		PartDefinition LeftShoulder_r2 = UpperLeftArm.addOrReplaceChild("LeftShoulder_r2", CubeListBuilder.create().texOffs(104, 89).addBox(-2.5F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-3.7444F, 2.38F, 0.0F, 0.0F, 0.0F, 0.2269F));

		PartDefinition Muscle1 = UpperLeftArm.addOrReplaceChild("Muscle1", CubeListBuilder.create(), PartPose.offset(-1.2311F, 5.2947F, 0.0F));

		PartDefinition Muscle_r10 = Muscle1.addOrReplaceChild("Muscle_r10", CubeListBuilder.create().texOffs(128, 0).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.6984F, -2.7513F, 0.0F, 0.0F, 0.0F, -0.1222F));

		PartDefinition Muscle_r11 = Muscle1.addOrReplaceChild("Muscle_r11", CubeListBuilder.create().texOffs(114, 127).addBox(-1.5F, -1.0F, -2.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.5762F, 2.7693F, 0.0F, 0.0F, 0.0F, 0.576F));

		PartDefinition Muscle_r12 = Muscle1.addOrReplaceChild("Muscle_r12", CubeListBuilder.create().texOffs(0, 124).addBox(-0.5F, 0.5F, -1.5F, 3.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0884F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition UpperLeftArmFoliage = UpperLeftArm.addOrReplaceChild("UpperLeftArmFoliage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LowerLeftArm = LeftArm.addOrReplaceChild("LowerLeftArm", CubeListBuilder.create(), PartPose.offset(4.6289F, 10.2292F, -0.1F));

		PartDefinition LowerLeftHand_r1 = LowerLeftArm.addOrReplaceChild("LowerLeftHand_r1", CubeListBuilder.create().texOffs(50, 81).addBox(-3.5131F, 0.0001F, -3.5F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0632F, 10.713F, 0.0F, 0.0F, 0.0F, 0.0087F));

		PartDefinition LowerLeftArm_r1 = LowerLeftArm.addOrReplaceChild("LowerLeftArm_r1", CubeListBuilder.create().texOffs(26, 81).addBox(-3.5F, -2.5F, -3.5F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6711F, 2.2708F, 0.5F, 0.0F, 0.0F, 0.0087F));

		PartDefinition LeftClaws = LowerLeftArm.addOrReplaceChild("LeftClaws", CubeListBuilder.create(), PartPose.offset(4.5042F, 16.306F, 0.0F));

		PartDefinition Claw_r8 = LeftClaws.addOrReplaceChild("Claw_r8", CubeListBuilder.create().texOffs(134, 28).addBox(-0.4739F, -1.5176F, 0.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(14, 134).addBox(-0.4739F, -1.5176F, 2.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(38, 134).addBox(-0.4739F, -1.5176F, 4.0F, 5.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8672F, -3.0844F, -2.0F, 0.0F, 0.0F, 0.0524F));

		PartDefinition Muscle2 = LowerLeftArm.addOrReplaceChild("Muscle2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1595F, 5.4599F, 0.5F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Muscle_r13 = Muscle2.addOrReplaceChild("Muscle_r13", CubeListBuilder.create().texOffs(114, 118).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0016F, 2.1487F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Muscle_r14 = Muscle2.addOrReplaceChild("Muscle_r14", CubeListBuilder.create().texOffs(118, 28).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0016F, -2.3513F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Muscle_r15 = Muscle2.addOrReplaceChild("Muscle_r15", CubeListBuilder.create().texOffs(114, 63).addBox(-0.5F, 1.5F, -2.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0884F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition Muscle3 = LowerLeftArm.addOrReplaceChild("Muscle3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.9405F, 5.8599F, 0.5F, 3.1416F, 0.0F, -2.906F));

		PartDefinition Muscle_r16 = Muscle3.addOrReplaceChild("Muscle_r16", CubeListBuilder.create().texOffs(112, 0).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.0016F, 2.1487F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Muscle_r17 = Muscle3.addOrReplaceChild("Muscle_r17", CubeListBuilder.create().texOffs(110, 80).addBox(-1.5F, -2.0F, -2.0F, 3.0F, 4.0F, 5.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-0.0016F, -2.3513F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition Muscle_r18 = Muscle3.addOrReplaceChild("Muscle_r18", CubeListBuilder.create().texOffs(120, 46).addBox(-0.5F, 1.5F, -1.5F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0884F, -3.0891F, -0.5F, 0.0F, 0.0F, 0.2269F));

		PartDefinition LowerLeftArmFoliage = LowerLeftArm.addOrReplaceChild("LowerLeftArmFoliage", CubeListBuilder.create(), PartPose.offset(0.4F, 0.0F, -1.1F));

		PartDefinition PetalCrown7 = LowerLeftArmFoliage.addOrReplaceChild("PetalCrown7", CubeListBuilder.create(), PartPose.offsetAndRotation(4.3711F, 4.6708F, 1.35F, -0.6461F, 1.0779F, 1.0113F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	public void moveY(ModelPart part, float val){
		if (val < -0.2){
			return;
		}
		part.y = part.getInitialPose().y+val;
	}
	public void moveZ(ModelPart part,float val){
		part.z = part.getInitialPose().z+val;
	}
	public void moveX(ModelPart part,float val){
		part.z = part.getInitialPose().z+val;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		root().getAllParts().forEach(ModelPart::resetPose);
		int rangedAttackAnimationTick = entity.getAttackAnimationTick();
		int ravageTicks = entity.getRavageTime();
		if (ravageTicks > 0){
			float val = Mth.cos(limbSwing * 0.5f) * limbSwingAmount;
			RightArm.xRot = -1.5f;
			LeftArm.xRot = -1.5f;
			moveZ(RightLeg,-val * 6f);
			moveZ(LeftLeg,val * 6f);
			RightLeg.xRot = val * 0.25f;
			LeftLeg.xRot = -val * 0.25f;
			LowerRightLeg.xRot = RightLeg.xRot > 0 ? -RightLeg.xRot : 0;
			LowerLeftLeg.xRot = LeftLeg.xRot > 0 ? -LeftLeg.xRot : 0;
		}else if (rangedAttackAnimationTick > 0) {
			float swing = -2.0F + 1.5F * Mth.triangleWave((float)rangedAttackAnimationTick, 20.0F);
			if (entity.getMeleeState() == Grober.MELEE_STATES.SMASH){
				RightArm.xRot = swing;
				LeftArm.xRot = swing;
			}else if (entity.getMeleeState() == Grober.MELEE_STATES.RIGHT_SLAP){
				RightArm.xRot = -1.5f;
				RightArm.yRot = swing * 0.85f;
			}else if (entity.getMeleeState() == Grober.MELEE_STATES.LEFT_SLAP){
				LeftArm.xRot = -1.5f;
				LeftArm.yRot = -swing * 0.85f;
			}
		} else {
			if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
				float val = Mth.cos(limbSwing * 0.5f) * limbSwingAmount;
				this.Body.yRot = val;
				moveY(RightArm,val* 4f);
				moveY(LeftArm,-val* 4f);
				moveX(RightArm,val * 3f);
				moveX(LeftArm,-val * 3f);
				moveZ(RightArm,val * 10f);
				moveZ(LeftArm,-val * 10f);
				RightArm.xRot = val * 0.75f;
				LeftArm.xRot = -val * 0.75f;
				moveZ(RightLeg,-val * 6f);
				moveZ(LeftLeg,val * 6f);
				RightLeg.xRot = val * 0.25f;
				LeftLeg.xRot = -val * 0.25f;
				LowerRightLeg.xRot = RightLeg.xRot > 0 ? -RightLeg.xRot : 0;
				LowerLeftLeg.xRot = LeftLeg.xRot > 0 ? -LeftLeg.xRot : 0;
			}
			this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
			this.Head.xRot = headPitch / (90F / (float) Math.PI);
		}
		if (entity.kickAnimation.isStarted()) {
			animate(entity.kickAnimation,kick,ageInTicks,1.25f);
		}
		float v = Mth.sin(ageInTicks/6)/6;
		this.LeftHinge.yRot = v;
		this.RightHinge.yRot = -v;
		this.MainLowerJaw.xRot = Mth.sin(ageInTicks/7)/8;
		this.SmallLowerJaw.xRot = Mth.cos(ageInTicks/6)/9;
		this.Spine.yRot = Mth.cos(ageInTicks/6)/9;
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Groberfub.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,alpha);
	}

	@Override
	public ModelPart root() {
		return Groberfub;
	}

	public static final AnimationDefinition kick = AnimationDefinition.Builder.withLength(0.5F)
			.addAnimation("Torso", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-60.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("Head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("RightArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("LeftArm", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(12.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("RightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(35.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("LeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(25.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("LowerRightLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-105.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("LowerLeftLeg", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(-107.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("LeftFoot", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(127.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.addAnimation("RightFoot", new AnimationChannel(AnimationChannel.Targets.ROTATION,
					new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.25F, KeyframeAnimations.degreeVec(117.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
					new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
			))
			.build();
}