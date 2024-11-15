package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Hyper.Ogre;
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

public class OgreModel<T extends Ogre> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "ogremodel"), "main");
	private final ModelPart H_brute;
	private final ModelPart TailSegment1;
	private final ModelPart TailSegment2;
	private final ModelPart TailSegment3;
	private final ModelPart TailSegment4;
	private final ModelPart TailTumor;
	private final ModelPart TailSpikes;
	private final ModelPart TailBody;
	private final ModelPart Spike1;
	private final ModelPart Spike2;
	private final ModelPart Spike3;
	private final ModelPart Spike4;
	private final ModelPart Spike5;
	private final ModelPart Spike6;
	private final ModelPart Spike7;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart Jaw3;
	private final ModelPart HeadY;
	private final ModelPart HeadX;
	private final ModelPart Legs;
	private final ModelPart RightBackLeg;
	private final ModelPart RightBackForLeg;
	private final ModelPart LeftBackLeg;
	private final ModelPart LeftBackForLeg;
	private final ModelPart RightFrontArm;
	private final ModelPart LeftFrontArm;
	private final ModelPart RightFrontForArm;
	private final ModelPart LeftFrontForArm;


	public OgreModel(ModelPart root) {
		this.H_brute = root.getChild("H_brute");
		this.TailSegment1 = H_brute.getChild("Tail");
		this.TailSegment2 = TailSegment1.getChild("TailSeg2");
		this.TailSegment3 = TailSegment2.getChild("TailSeg3");
		this.TailSegment4 = TailSegment3.getChild("TailSeg4");
		this.TailTumor = TailSegment4.getChild("TumorTip").getChild("Tumors");
		this.TailSpikes = TailSegment4.getChild("TumorTip").getChild("Thorns");
		this.TailBody = TailSegment4.getChild("TumorTip").getChild("Impaled");
		this.Spike1 = TailSpikes.getChild("Thorn1");
		this.Spike2 = TailSpikes.getChild("Thorn2");
		this.Spike3 = TailSpikes.getChild("Thorn3");
		this.Spike4 = TailSpikes.getChild("Thorn4");
		this.Spike5 = TailSpikes.getChild("Thorn5");
		this.Spike6 = TailSpikes.getChild("Thorn6");
		this.Spike7 = TailSpikes.getChild("Thorn7");
		this.Jaw1 = H_brute.getChild("LowerTorso").getChild("UpperTorso").getChild("Jaw");
		this.Jaw2 = Jaw1.getChild("TorsoMiddle").getChild("TorsoTop");
		this.Jaw3 = Jaw2.getChild("JawTip");
		this.HeadY = H_brute.getChild("LowerTorso").getChild("UpperTorso").getChild("Neck");
		this.HeadX = HeadY.getChild("Head");
		this.Legs = H_brute.getChild("Legs");
		this.RightBackLeg = Legs.getChild("RightLeg");
		this.RightBackForLeg = RightBackLeg.getChild("RightLegSeg2");
		this.LeftBackLeg = Legs.getChild("LeftLeg");
		this.LeftBackForLeg = LeftBackLeg.getChild("LeftLegSeg2");
		this.RightFrontArm = H_brute.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("RightArm");
		this.LeftFrontArm = H_brute.getChild("LowerTorso").getChild("UpperTorso").getChild("Arms").getChild("LeftArm");
		this.RightFrontForArm = RightFrontArm.getChild("RightArmSeg2");
		this.LeftFrontForArm = LeftFrontArm.getChild("LeftArmSeg2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition H_brute = partdefinition.addOrReplaceChild("H_brute", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 3.0F));

		PartDefinition LowerTorso = H_brute.addOrReplaceChild("LowerTorso", CubeListBuilder.create().texOffs(64, 34).addBox(-10.0F, -10.0F, -5.0F, 20.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 6.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition UpperTorso = LowerTorso.addOrReplaceChild("UpperTorso", CubeListBuilder.create().texOffs(0, 0).addBox(-14.0F, -23.0F, -3.0F, 28.0F, 23.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(24, 199).mirror().addBox(-14.0F, -11.0F, -8.0F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(24, 199).addBox(8.0F, -11.0F, -8.0F, 6.0F, 11.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 193).mirror().addBox(-14.0F, -23.0F, -8.0F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 193).addBox(7.0F, -23.0F, -8.0F, 7.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition RightShoulder_r1 = UpperTorso.addOrReplaceChild("RightShoulder_r1", CubeListBuilder.create().texOffs(48, 151).mirror().addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, -19.0F, 5.0F, 0.2618F, 0.0F, -0.48F));

		PartDefinition LeftShoulder_r1 = UpperTorso.addOrReplaceChild("LeftShoulder_r1", CubeListBuilder.create().texOffs(48, 151).addBox(-6.0F, -6.0F, -7.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -19.0F, 5.0F, 0.2618F, 0.0F, 0.48F));

		PartDefinition Arms = UpperTorso.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -13.6868F, -1.0746F, -1.0036F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(0, 34).addBox(-14.0F, -7.5F, -7.5F, 17.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0195F, -2.0F, 3.34F, 0.2546F, -0.4114F, -0.577F));

		PartDefinition ArmCrown1 = RightArm.addOrReplaceChild("ArmCrown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.6088F, -6.5266F, 7.0266F, -0.683F, -0.8025F, 0.4237F));

		PartDefinition Petal5_r1 = ArmCrown1.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(-7, 136).addBox(-2.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r1 = ArmCrown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 122).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, 0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal3_r1 = ArmCrown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 122).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r1 = ArmCrown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, 0.5792F, 0.4726F, 0.2047F, 0.1036F));

		PartDefinition ArmCrown2 = RightArm.addOrReplaceChild("ArmCrown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.6864F, -5.7593F, -7.111F, 1.4358F, -0.3455F, -2.2499F));

		PartDefinition Petal6_r1 = ArmCrown2.addOrReplaceChild("Petal6_r1", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal5_r2 = ArmCrown2.addOrReplaceChild("Petal5_r2", CubeListBuilder.create().texOffs(-7, 122).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, 0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal4_r2 = ArmCrown2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(-7, 129).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal3_r2 = ArmCrown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, 0.5792F, 0.4726F, 0.2047F, 0.1036F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(64, 58).addBox(-13.0F, -6.0F, -6.0F, 17.0F, 12.0F, 12.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(-13.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.829F));

		PartDefinition RightArmSeg3 = RightArmSeg2.addOrReplaceChild("RightArmSeg3", CubeListBuilder.create().texOffs(168, 112).addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition RightArmFist = RightArmSeg3.addOrReplaceChild("RightArmFist", CubeListBuilder.create().texOffs(0, 94).addBox(-16.0F, -7.0F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CrownFist = RightArmFist.addOrReplaceChild("CrownFist", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.2549F, -6.8517F, -3.2775F, 0.1262F, -0.1659F, 0.0297F));

		PartDefinition Petal5_r3 = CrownFist.addOrReplaceChild("Petal5_r3", CubeListBuilder.create().texOffs(-7, 136).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r3 = CrownFist.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6825F, -0.6481F, 1.3381F, -0.1019F, 0.1482F, -0.2567F));

		PartDefinition Petal3_r3 = CrownFist.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(-7, 136).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r2 = CrownFist.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, -0.5792F, -0.4726F, -0.2047F, 0.1036F));

		PartDefinition RightArmFungus = RightArmSeg2.addOrReplaceChild("RightArmFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.094F, -4.7859F, 4.9093F, 0.2618F, 0.0F, -1.7453F));

		PartDefinition Fungus_r1 = RightArmFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.75F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3069F, -11.0285F, -9.0354F, -2.0584F, 1.0432F, -2.2283F));

		PartDefinition Fungus_r2 = RightArmFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.6919F, 3.5973F, -4.9266F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0258F, -7.9789F, -9.5116F, -2.6021F, 0.2949F, 3.0982F));

		PartDefinition Fungus_r3 = RightArmFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.6759F, -6.7553F, -5.0483F, -2.8814F, 0.562F, 3.0473F));

		PartDefinition Fungus_r4 = RightArmFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 129).addBox(-4.4074F, -0.4938F, -1.9099F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0258F, -7.9789F, -9.5116F, -2.7416F, 0.3455F, -2.8459F));

		PartDefinition Fungus_r5 = RightArmFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 136).addBox(-1.5F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1221F, -2.9969F, 1.2752F, -0.3325F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = RightArmFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 1.0F, 0.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1221F, 2.0031F, -4.7248F, 0.1797F, 0.4891F, 0.195F));

		PartDefinition Fungus_r7 = RightArmFungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 136).addBox(-2.25F, -5.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1221F, 4.0031F, -3.7248F, -0.0333F, -0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = RightArmFungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1221F, -0.9969F, 2.2752F, -0.1783F, 0.2977F, -0.0909F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 34).mirror().addBox(-3.0F, -7.5F, -7.5F, 17.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(10.0195F, -2.0F, 3.34F, 0.2546F, 0.4114F, 0.577F));

		PartDefinition LeftShoulderFungus = LeftArm.addOrReplaceChild("LeftShoulderFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(10.067F, -5.6637F, 6.1784F, -0.6137F, -0.2264F, 0.2434F));

		PartDefinition Petal5_r4 = LeftShoulderFungus.addOrReplaceChild("Petal5_r4", CubeListBuilder.create().texOffs(-7, 136).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r4 = LeftShoulderFungus.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(-7, 136).addBox(-6.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, -0.0399F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal3_r4 = LeftShoulderFungus.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(-7, 129).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r3 = LeftShoulderFungus.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, -0.5792F, -0.4726F, -0.2047F, 0.1036F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(64, 58).mirror().addBox(-4.0F, -6.0F, -6.0F, 17.0F, 12.0F, 12.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offsetAndRotation(13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.829F));

		PartDefinition LeftArmFungus = LeftArmSeg2.addOrReplaceChild("LeftArmFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(7.9086F, -4.1524F, -3.0731F, -1.5708F, 1.3526F, -3.1416F));

		PartDefinition Fungus_r9 = LeftArmFungus.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5593F, -2.2108F, 1.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r10 = LeftArmFungus.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 122).addBox(0.5F, -5.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4407F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r11 = LeftArmFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.678F, 0.6324F, 2.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r12 = LeftArmFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 0.7892F, -3.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition LeftArmSeg3 = LeftArmSeg2.addOrReplaceChild("LeftArmSeg3", CubeListBuilder.create().texOffs(168, 112).mirror().addBox(-4.0F, -6.0F, -6.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition LeftArmFist = LeftArmSeg3.addOrReplaceChild("LeftArmFist", CubeListBuilder.create().texOffs(0, 94).mirror().addBox(4.0F, -7.0F, -7.0F, 12.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition CrownFist2 = LeftArmFist.addOrReplaceChild("CrownFist2", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0267F, 4.335F, 6.9435F, -1.829F, 0.1898F, 0.6841F));

		PartDefinition Petal5_r5 = CrownFist2.addOrReplaceChild("Petal5_r5", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r5 = CrownFist2.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(-7, 136).addBox(-6.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, -0.0399F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal3_r5 = CrownFist2.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(-7, 122).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r4 = CrownFist2.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, -0.5792F, -0.4726F, -0.2047F, 0.1036F));

		PartDefinition Neck = UpperTorso.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(64, 130).addBox(-8.0F, -4.5F, -11.0F, 16.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.0462F, 2.4881F, -1.2217F, 0.0F, 0.0F));

		PartDefinition NeckTeeth = Neck.addOrReplaceChild("NeckTeeth", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2964F, 4.0265F, -6.1846F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = NeckTeeth.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -3.5F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0916F, 0.5459F, 1.5601F, 3.0536F, 0.0461F, -2.7626F));

		PartDefinition Teeth_r2 = NeckTeeth.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(246, 171).addBox(0.0F, -3.5F, -2.0F, 0.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0067F, 1.585F, 1.938F, -3.0725F, 0.0559F, 0.3201F));

		PartDefinition Teeth_r3 = NeckTeeth.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(246, 169).addBox(1.75F, -5.0F, -4.25F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5172F, -0.556F, -0.3135F, 3.0944F, -0.1593F, 2.4556F));

		PartDefinition Teeth_r4 = NeckTeeth.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(247, 166).addBox(-2.25F, -5.5F, -2.75F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5864F, 1.6749F, -0.1998F, 3.032F, 0.1902F, -3.1102F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(136, 0).addBox(-6.0F, -9.0F, -10.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(106, 24).addBox(-2.0F, -1.0F, -14.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1451F, 0.5564F, -11.0F));

		PartDefinition FungalBloom = Head.addOrReplaceChild("FungalBloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8595F, -6.8603F, -6.562F, 0.3361F, 0.2071F, -0.532F));

		PartDefinition Plane2_r1 = FungalBloom.addOrReplaceChild("Plane2_r1", CubeListBuilder.create().texOffs(81, 181).addBox(-11.8501F, -13.8001F, -7.6583F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2533F, 1.5803F, -7.8924F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane1_r1 = FungalBloom.addOrReplaceChild("Plane1_r1", CubeListBuilder.create().texOffs(81, 181).mirror().addBox(-0.8501F, -13.8001F, 5.3417F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.2533F, 1.5803F, -7.8924F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Npetal_r1 = FungalBloom.addOrReplaceChild("Npetal_r1", CubeListBuilder.create().texOffs(124, 24).addBox(-16.8501F, -0.8001F, -17.6583F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 1.5803F, -0.3924F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Spetal_r1 = FungalBloom.addOrReplaceChild("Spetal_r1", CubeListBuilder.create().texOffs(64, 82).addBox(-16.8501F, -0.8001F, 2.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.5033F, 1.5803F, -0.3924F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Wpetal_r1 = FungalBloom.addOrReplaceChild("Wpetal_r1", CubeListBuilder.create().texOffs(124, 40).addBox(1.1499F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 1.5803F, -8.3924F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Epetal_r1 = FungalBloom.addOrReplaceChild("Epetal_r1", CubeListBuilder.create().texOffs(122, 58).addBox(-17.8501F, -0.8001F, 0.3417F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5033F, 1.5803F, -8.3924F, 0.0F, 0.0F, 0.3927F));

		PartDefinition crown1 = Head.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.372F, -6.7264F, -8.1261F, 0.3982F, 0.0864F, 0.9492F));

		PartDefinition Petal4_r6 = crown1.addOrReplaceChild("Petal4_r6", CubeListBuilder.create().texOffs(-7, 122).addBox(-2.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r6 = crown1.addOrReplaceChild("Petal3_r6", CubeListBuilder.create().texOffs(-7, 122).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, 0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r5 = crown1.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(-7, 136).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, 0.5792F, 0.4726F, 0.2047F, 0.1036F));

		PartDefinition HeadTeeth = Head.addOrReplaceChild("HeadTeeth", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1513F, 3.47F, -4.1846F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Teeth_r5 = HeadTeeth.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -3.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3143F, -2.1356F, -0.143F, 2.932F, 0.0607F, -2.5885F));

		PartDefinition Teeth_r6 = HeadTeeth.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(247, 172).addBox(1.0F, -3.5F, -1.75F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6309F, 1.5351F, 0.2817F, -3.0529F, -0.0054F, 1.0597F));

		PartDefinition Teeth_r7 = HeadTeeth.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(247, 170).addBox(1.75F, -5.0F, -2.25F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5172F, -0.556F, -0.3135F, 3.0944F, -0.1593F, 2.4556F));

		PartDefinition Teeth_r8 = HeadTeeth.addOrReplaceChild("Teeth_r8", CubeListBuilder.create().texOffs(247, 166).addBox(2.0F, -3.5F, -1.5F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5715F, 0.7438F, 0.0709F, 2.9259F, 0.0393F, 2.3066F));

		PartDefinition Jaw = UpperTorso.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(168, 136).addBox(-8.0F, -11.0F, -4.0F, 16.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition Teeth_r9 = Jaw.addOrReplaceChild("Teeth_r9", CubeListBuilder.create().texOffs(246, 162).addBox(0.0F, -6.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.684F, -5.0F, 1.8794F, 3.0363F, 0.2707F, 2.806F));

		PartDefinition Teeth_r10 = Jaw.addOrReplaceChild("Teeth_r10", CubeListBuilder.create().texOffs(246, 162).addBox(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5117F, -6.0619F, 0.8699F, -2.9884F, -0.459F, 2.8016F));

		PartDefinition Teeth_r11 = Jaw.addOrReplaceChild("Teeth_r11", CubeListBuilder.create().texOffs(246, 162).addBox(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9706F, -5.3617F, 1.0201F, -3.086F, 0.0964F, 2.8932F));

		PartDefinition Teeth_r12 = Jaw.addOrReplaceChild("Teeth_r12", CubeListBuilder.create().texOffs(246, 169).addBox(-1.0F, -5.0F, -1.5F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6994F, -5.7937F, 0.7501F, 3.0413F, 0.6461F, 3.025F));

		PartDefinition Teeth_r13 = Jaw.addOrReplaceChild("Teeth_r13", CubeListBuilder.create().texOffs(246, 162).addBox(0.0F, -5.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -5.0F, 0.0F, 0.0309F, 0.2629F, -0.074F));

		PartDefinition Teeth_r14 = Jaw.addOrReplaceChild("Teeth_r14", CubeListBuilder.create().texOffs(246, 163).addBox(0.0F, -6.0F, -2.0F, 0.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9706F, -5.3617F, 1.0201F, -3.0615F, 0.3829F, -2.9047F));

		PartDefinition TorsoMiddle = Jaw.addOrReplaceChild("TorsoMiddle", CubeListBuilder.create().texOffs(184, 0).addBox(-7.5F, -9.0F, -2.866F, 15.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, -0.634F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Teeth_r15 = TorsoMiddle.addOrReplaceChild("Teeth_r15", CubeListBuilder.create().texOffs(247, 170).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1033F, -5.0364F, 2.1385F, -3.0872F, 0.6074F, -2.9874F));

		PartDefinition Teeth_r16 = TorsoMiddle.addOrReplaceChild("Teeth_r16", CubeListBuilder.create().texOffs(247, 167).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6754F, -4.3451F, 2.2116F, -3.0861F, 0.0779F, -2.8836F));

		PartDefinition Teeth_r17 = TorsoMiddle.addOrReplaceChild("Teeth_r17", CubeListBuilder.create().texOffs(247, 169).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1189F, -4.0676F, 1.3443F, -2.9579F, 0.1771F, -3.0841F));

		PartDefinition Teeth_r18 = TorsoMiddle.addOrReplaceChild("Teeth_r18", CubeListBuilder.create().texOffs(247, 172).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7025F, -4.1358F, 2.4479F, -3.0656F, -0.2088F, 2.9189F));

		PartDefinition TorsoTop = TorsoMiddle.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(188, 13).addBox(-7.5F, -8.0F, -2.866F, 14.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -9.0F, 1.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Teeth_r19 = TorsoTop.addOrReplaceChild("Teeth_r19", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -3.0F, -1.5F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8967F, -4.5172F, 1.9775F, -3.1124F, -0.2587F, -2.8988F));

		PartDefinition Teeth_r20 = TorsoTop.addOrReplaceChild("Teeth_r20", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3417F, -2.9538F, 1.5414F, 3.051F, -0.4201F, -2.4319F));

		PartDefinition Teeth_r21 = TorsoTop.addOrReplaceChild("Teeth_r21", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -4.0F, -1.5F, 0.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6491F, -3.5487F, 1.9493F, -3.1416F, 0.3054F, 2.5307F));

		PartDefinition JawTip = TorsoTop.addOrReplaceChild("JawTip", CubeListBuilder.create().texOffs(190, 151).addBox(-6.4705F, -11.9542F, -1.7892F, 12.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition Teeth_r22 = JawTip.addOrReplaceChild("Teeth_r22", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -3.0F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1107F, -9.4053F, 1.7945F, 2.932F, 0.0607F, -2.5885F));

		PartDefinition Teeth_r23 = JawTip.addOrReplaceChild("Teeth_r23", CubeListBuilder.create().texOffs(247, 166).addBox(0.0F, -3.5F, -1.5F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8345F, -5.7346F, 2.2192F, 3.1133F, -0.0843F, 2.8937F));

		PartDefinition Teeth_r24 = JawTip.addOrReplaceChild("Teeth_r24", CubeListBuilder.create().texOffs(247, 170).addBox(0.0F, -5.4F, -1.5F, 0.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7208F, -7.8257F, 1.624F, -3.0578F, -0.1593F, 2.4556F));

		PartDefinition Teeth_r25 = JawTip.addOrReplaceChild("Teeth_r25", CubeListBuilder.create().texOffs(247, 166).addBox(0.0F, -4.5F, -1.5F, 0.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0558F, -7.4716F, 1.918F, 3.0471F, 0.2909F, -2.85F));

		PartDefinition crown2 = JawTip.addOrReplaceChild("crown2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.13F, -8.6143F, -2.3207F, 1.4835F, 0.0F, 0.0F));

		PartDefinition Petal4_r7 = crown2.addOrReplaceChild("Petal4_r7", CubeListBuilder.create().texOffs(-7, 136).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r7 = crown2.addOrReplaceChild("Petal3_r7", CubeListBuilder.create().texOffs(-7, 122).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r6 = crown2.addOrReplaceChild("Petal2_r6", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = crown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2969F, 0.3356F, 0.5792F, 0.4726F, -0.2047F, -0.1036F));

		PartDefinition TorsoTeeth = UpperTorso.addOrReplaceChild("TorsoTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r26 = TorsoTeeth.addOrReplaceChild("Teeth_r26", CubeListBuilder.create().texOffs(247, 162).addBox(3.0F, -3.0F, -0.75F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, -17.9413F, -4.1499F, -0.0027F, 0.2523F, -0.4726F));

		PartDefinition Teeth_r27 = TorsoTeeth.addOrReplaceChild("Teeth_r27", CubeListBuilder.create().texOffs(247, 162).addBox(-2.0F, -6.0F, 0.25F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5586F, -11.137F, -4.189F, 0.0026F, -0.3025F, 0.4382F));

		PartDefinition Teeth_r28 = TorsoTeeth.addOrReplaceChild("Teeth_r28", CubeListBuilder.create().texOffs(247, 162).addBox(0.0F, -4.0F, -1.5F, 0.0F, 12.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5835F, -8.474F, -3.1881F, -0.0381F, -0.3001F, 0.5752F));

		PartDefinition Teeth_r29 = TorsoTeeth.addOrReplaceChild("Teeth_r29", CubeListBuilder.create().texOffs(246, 161).addBox(0.0F, -9.0F, -1.5F, 0.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7317F, -12.2284F, -4.3483F, -0.0914F, -0.2912F, 0.1646F));

		PartDefinition Teeth_r30 = TorsoTeeth.addOrReplaceChild("Teeth_r30", CubeListBuilder.create().texOffs(246, 161).addBox(0.0F, -9.0F, -2.0F, 0.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3289F, -10.2357F, -4.1108F, -0.0503F, -0.3367F, -0.2458F));

		PartDefinition ChestFungus = UpperTorso.addOrReplaceChild("ChestFungus", CubeListBuilder.create(), PartPose.offset(-7.0593F, -4.8392F, 6.3475F));

		PartDefinition Fungus_r13 = ChestFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0807F, 3.4883F, -8.2795F, -0.8456F, -0.6546F, -0.4256F));

		PartDefinition Fungus_r14 = ChestFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 122).addBox(-4.241F, -0.3123F, -0.4428F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8713F, 0.588F, -1.62F, -0.5944F, 0.3348F, -0.4974F));

		PartDefinition Fungus_r15 = ChestFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5526F, 4.0227F, -6.0795F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8713F, -1.412F, -13.0751F, 0.4547F, 0.3998F, -0.6482F));

		PartDefinition Fungus_r16 = ChestFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.2856F, -0.0744F, -12.7007F, 0.1952F, -0.2126F, -0.3265F));

		PartDefinition Fungus_r17 = ChestFungus.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2841F, 3.3438F, -2.8038F, -0.3775F, -0.0885F, -0.4054F));

		PartDefinition Fungus_r18 = ChestFungus.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.8602F, -3.0523F, 0.2132F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.7662F, -15.3685F, 2.4507F, -1.6719F, -1.0825F, 1.2891F));

		PartDefinition Fungus_r19 = ChestFungus.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.7034F, 0.0733F, -2.5899F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.7662F, -15.3685F, 2.4507F, -0.9185F, -0.8459F, 0.634F));

		PartDefinition Fungus_r20 = ChestFungus.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(-7, 129).addBox(-0.0265F, 2.8663F, -5.2365F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.7662F, -15.3685F, 2.4507F, -1.2328F, -0.3271F, 0.3532F));

		PartDefinition Fungus_r21 = ChestFungus.addOrReplaceChild("Fungus_r21", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.1994F, 4.4883F, -8.2795F, -0.8456F, 0.6546F, 0.4256F));

		PartDefinition Fungus_r22 = ChestFungus.addOrReplaceChild("Fungus_r22", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.759F, -0.3123F, -0.4428F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.99F, 1.588F, -1.62F, -0.5944F, -0.3348F, 0.4974F));

		PartDefinition Fungus_r23 = ChestFungus.addOrReplaceChild("Fungus_r23", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.4474F, 4.0227F, -6.0795F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.99F, -0.412F, -13.0751F, 0.4547F, -0.3998F, 0.6482F));

		PartDefinition Fungus_r24 = ChestFungus.addOrReplaceChild("Fungus_r24", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.4043F, 0.9256F, -12.7007F, 0.1952F, 0.2126F, 0.3265F));

		PartDefinition Fungus_r25 = ChestFungus.addOrReplaceChild("Fungus_r25", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.4028F, 4.3438F, -2.8038F, -0.3775F, 0.0885F, 0.4054F));

		PartDefinition Fungus_r26 = ChestFungus.addOrReplaceChild("Fungus_r26", CubeListBuilder.create().texOffs(-7, 122).addBox(0.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5497F, -10.4561F, 3.3171F, 0.3717F, -0.2126F, -0.3261F));

		PartDefinition Fungus_r27 = ChestFungus.addOrReplaceChild("Fungus_r27", CubeListBuilder.create().texOffs(-7, 129).addBox(-7.5572F, -1.3123F, -4.241F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3318F, -11.412F, -13.2782F, 0.4974F, 0.3348F, -0.5944F));

		PartDefinition Fungus_r28 = ChestFungus.addOrReplaceChild("Fungus_r28", CubeListBuilder.create().texOffs(-7, 129).addBox(-0.9205F, 4.0227F, -3.4474F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7869F, -13.412F, 2.5831F, -0.6482F, -0.3998F, 0.4547F));

		PartDefinition Fungus_r29 = ChestFungus.addOrReplaceChild("Fungus_r29", CubeListBuilder.create().texOffs(-7, 122).addBox(0.5572F, -1.3123F, -4.241F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7869F, -13.412F, -13.2782F, 0.4974F, -0.3348F, 0.0708F));

		PartDefinition Fungus_r30 = ChestFungus.addOrReplaceChild("Fungus_r30", CubeListBuilder.create().texOffs(-7, 122).addBox(0.5572F, 1.3123F, -2.759F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.7869F, -0.9096F, -12.4169F, 0.4974F, 0.3348F, -0.5944F));

		PartDefinition Fungus_r31 = ChestFungus.addOrReplaceChild("Fungus_r31", CubeListBuilder.create().texOffs(-7, 122).addBox(-9.0795F, -4.0227F, -5.4474F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3318F, 1.0904F, -12.4169F, 0.6482F, 0.3998F, 0.4547F));

		PartDefinition Fungus_r32 = ChestFungus.addOrReplaceChild("Fungus_r32", CubeListBuilder.create().texOffs(-7, 136).addBox(-7.5572F, 1.3123F, -2.759F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3318F, 1.0904F, -12.4169F, 0.4974F, -0.3348F, 0.0708F));

		PartDefinition Bloom = ChestFungus.addOrReplaceChild("Bloom", CubeListBuilder.create().texOffs(188, 41).addBox(-4.0F, -2.0324F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0593F, -3.1608F, 4.6201F, -1.6939F, -0.0447F, -0.3463F));

		PartDefinition NPetal_r2 = Bloom.addOrReplaceChild("NPetal_r2", CubeListBuilder.create().texOffs(124, 24).addBox(-16.0F, 0.0F, -19.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.9676F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition SPetal_r2 = Bloom.addOrReplaceChild("SPetal_r2", CubeListBuilder.create().texOffs(64, 82).addBox(-16.0F, 0.0F, 3.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 3.9676F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition WPetal_r2 = Bloom.addOrReplaceChild("WPetal_r2", CubeListBuilder.create().texOffs(124, 40).addBox(3.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition EPetal_r2 = Bloom.addOrReplaceChild("EPetal_r2", CubeListBuilder.create().texOffs(122, 58).addBox(-19.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.9676F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightShoulderFungus = ChestFungus.addOrReplaceChild("RightShoulderFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.2009F, -17.9677F, 0.1562F, -0.7424F, 0.4783F, -0.803F));

		PartDefinition Petal5_r6 = RightShoulderFungus.addOrReplaceChild("Petal5_r6", CubeListBuilder.create().texOffs(-7, 136).mirror().addBox(-5.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal4_r8 = RightShoulderFungus.addOrReplaceChild("Petal4_r8", CubeListBuilder.create().texOffs(-7, 136).mirror().addBox(-1.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.6315F, 1.4073F, -0.0399F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal3_r8 = RightShoulderFungus.addOrReplaceChild("Petal3_r8", CubeListBuilder.create().texOffs(-7, 129).mirror().addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r7 = RightShoulderFungus.addOrReplaceChild("Petal2_r7", CubeListBuilder.create().texOffs(-7, 136).mirror().addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.2969F, 0.3356F, -0.5792F, -0.4726F, 0.2047F, -0.1036F));

		PartDefinition LowerTorsoFungus = LowerTorso.addOrReplaceChild("LowerTorsoFungus", CubeListBuilder.create(), PartPose.offset(-8.0593F, 28.1608F, -24.3475F));

		PartDefinition Fungus_r33 = LowerTorsoFungus.addOrReplaceChild("Fungus_r33", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -34.2108F, 29.8975F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r34 = LowerTorsoFungus.addOrReplaceChild("Fungus_r34", CubeListBuilder.create().texOffs(-7, 122).addBox(2.5F, -2.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4407F, -31.2108F, 26.8975F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r35 = LowerTorsoFungus.addOrReplaceChild("Fungus_r35", CubeListBuilder.create().texOffs(-7, 136).addBox(-1.5F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.678F, -28.3676F, 30.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r36 = LowerTorsoFungus.addOrReplaceChild("Fungus_r36", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, -26.2108F, 26.8975F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition crown3 = LowerTorsoFungus.addOrReplaceChild("crown3", CubeListBuilder.create(), PartPose.offsetAndRotation(17.2655F, -31.0592F, 28.9654F, -1.2502F, 0.6569F, 0.5029F));

		PartDefinition Petal5_r7 = crown3.addOrReplaceChild("Petal5_r7", CubeListBuilder.create().texOffs(-7, 122).addBox(-2.0F, -1.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, -0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r9 = crown3.addOrReplaceChild("Petal4_r9", CubeListBuilder.create().texOffs(-7, 122).addBox(-6.0F, -2.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, -0.0399F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal3_r9 = crown3.addOrReplaceChild("Petal3_r9", CubeListBuilder.create().texOffs(-7, 136).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, 3.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r8 = crown3.addOrReplaceChild("Petal2_r8", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, -0.5792F, -0.4726F, -0.2047F, 0.1036F));

		PartDefinition Legs = H_brute.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 9.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(0, 167).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.6981F, 0.3927F, 0.0F));

		PartDefinition LeftLegFungus = LeftLeg.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(1.9407F, 3.7902F, -4.5132F, -2.9671F, 0.0F, 0.0F));

		PartDefinition Fungus_r37 = LeftLegFungus.addOrReplaceChild("Fungus_r37", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.0932F, 1.3301F, -3.1862F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6515F, -2.9744F, -8.7382F, -0.7818F, -0.5816F, -0.0141F));

		PartDefinition Fungus_r38 = LeftLegFungus.addOrReplaceChild("Fungus_r38", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5053F, -1.4258F, -3.5113F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6515F, -2.9744F, -8.7382F, -0.3242F, -0.5581F, -0.4005F));

		PartDefinition Fungus_r39 = LeftLegFungus.addOrReplaceChild("Fungus_r39", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 1.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.1475F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r40 = LeftLegFungus.addOrReplaceChild("Fungus_r40", CubeListBuilder.create().texOffs(-7, 136).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5593F, -0.2108F, -2.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LeftLegSeg2 = LeftLeg.addOrReplaceChild("LeftLegSeg2", CubeListBuilder.create().texOffs(120, 130).addBox(-6.0F, -4.0F, -6.0F, 12.0F, 13.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition LeftLegCrown = LeftLegSeg2.addOrReplaceChild("LeftLegCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(6.7438F, 2.7633F, 2.2462F, -0.1376F, -0.7713F, 1.6938F));

		PartDefinition Petal6_r2 = LeftLegCrown.addOrReplaceChild("Petal6_r2", CubeListBuilder.create().texOffs(-7, 129).addBox(-5.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal5_r8 = LeftLegCrown.addOrReplaceChild("Petal5_r8", CubeListBuilder.create().texOffs(-7, 136).addBox(-1.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal4_r10 = LeftLegCrown.addOrReplaceChild("Petal4_r10", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal3_r10 = LeftLegCrown.addOrReplaceChild("Petal3_r10", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2969F, 0.3356F, 0.5792F, 0.4726F, -0.2047F, -0.1036F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 168).mirror().addBox(-5.0F, -3.0F, -5.0F, 10.0F, 13.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, 0.0F, 0.0F, 0.6981F, -0.3927F, 0.0F));

		PartDefinition RightLegCrown = RightLeg.addOrReplaceChild("RightLegCrown", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0946F, 7.3601F, 5.4695F, -1.4586F, -0.1369F, 0.6616F));

		PartDefinition Petal5_r9 = RightLegCrown.addOrReplaceChild("Petal5_r9", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.0F, -1.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal4_r11 = RightLegCrown.addOrReplaceChild("Petal4_r11", CubeListBuilder.create().texOffs(-7, 122).addBox(-6.0F, -2.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6315F, 1.4073F, 0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal3_r11 = RightLegCrown.addOrReplaceChild("Petal3_r11", CubeListBuilder.create().texOffs(-7, 129).addBox(-4.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal2_r9 = RightLegCrown.addOrReplaceChild("Petal2_r9", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2969F, 0.3356F, 0.5792F, 0.4726F, 0.2047F, 0.1036F));

		PartDefinition RightLegSeg2 = RightLeg.addOrReplaceChild("RightLegSeg2", CubeListBuilder.create().texOffs(120, 130).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Tail = H_brute.addOrReplaceChild("Tail", CubeListBuilder.create().texOffs(184, 180).addBox(-3.5F, -3.4769F, -0.6504F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 9.5F, -0.3054F, 0.0F, 0.0F));

		PartDefinition TailSeg2 = Tail.addOrReplaceChild("TailSeg2", CubeListBuilder.create().texOffs(144, 157).addBox(-3.5F, -3.5F, -2.0F, 7.0F, 7.0F, 16.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 9.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tail2Fungus = TailSeg2.addOrReplaceChild("Tail2Fungus", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0593F, -0.3601F, 2.948F, 1.3963F, 0.0F, 0.0F));

		PartDefinition Fungus_r41 = Tail2Fungus.addOrReplaceChild("Fungus_r41", CubeListBuilder.create().texOffs(-7, 129).addBox(-1.5F, 10.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r42 = Tail2Fungus.addOrReplaceChild("Fungus_r42", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 2.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r43 = Tail2Fungus.addOrReplaceChild("Fungus_r43", CubeListBuilder.create().texOffs(-7, 129).addBox(-2.25F, -4.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r44 = Tail2Fungus.addOrReplaceChild("Fungus_r44", CubeListBuilder.create().texOffs(-7, 122).addBox(-4.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition TailSeg3 = TailSeg2.addOrReplaceChild("TailSeg3", CubeListBuilder.create().texOffs(168, 90).addBox(-3.0F, -2.9619F, -0.8087F, 6.0F, 6.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 12.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Tail3Fungus = TailSeg3.addOrReplaceChild("Tail3Fungus", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0593F, -0.3505F, 9.8527F, -1.3963F, 0.0F, 0.0F));

		PartDefinition Fungus_r45 = Tail3Fungus.addOrReplaceChild("Fungus_r45", CubeListBuilder.create().texOffs(-7, 129).addBox(-5.5F, 10.0F, -1.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5593F, -2.2108F, 2.1025F, -0.3325F, 0.5154F, -0.0523F));

		PartDefinition Fungus_r46 = Tail3Fungus.addOrReplaceChild("Fungus_r46", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 2.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4407F, 2.7892F, -3.8975F, 0.1797F, -0.4891F, -0.195F));

		PartDefinition Fungus_r47 = Tail3Fungus.addOrReplaceChild("Fungus_r47", CubeListBuilder.create().texOffs(-7, 129).addBox(-4.75F, -4.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5593F, 4.7892F, -2.8975F, -0.0333F, 0.6219F, -0.3593F));

		PartDefinition Fungus_r48 = Tail3Fungus.addOrReplaceChild("Fungus_r48", CubeListBuilder.create().texOffs(-7, 122).addBox(-2.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5593F, -0.2108F, 3.1025F, -0.1783F, -0.2977F, 0.0909F));

		PartDefinition TailSeg4 = TailSeg3.addOrReplaceChild("TailSeg4", CubeListBuilder.create().texOffs(186, 56).addBox(-2.5F, -2.4995F, -1.0218F, 5.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 14.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition TumorTip = TailSeg4.addOrReplaceChild("TumorTip", CubeListBuilder.create(), PartPose.offset(0.0046F, -1.302F, 10.8573F));

		PartDefinition Tumors = TumorTip.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = Tumors.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(190, 27).addBox(-12.5F, -4.5F, -0.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0505F, -3.6208F, -2.2754F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Tumor_r2 = Tumors.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(190, 27).addBox(-8.0F, -8.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9334F, -3.2841F, 5.6127F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Tumor_r3 = Tumors.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(190, 27).addBox(-2.0F, 2.0F, 1.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5248F, -1.8629F, -7.4953F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Tumor_r4 = Tumors.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(193, 30).addBox(-1.0F, -3.0F, 13.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4412F, -7.3435F, -9.375F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor_r5 = Tumors.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(188, 25).addBox(3.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.937F, -2.7617F, -7.9204F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition Thorns = TumorTip.addOrReplaceChild("Thorns", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Thorn1 = Thorns.addOrReplaceChild("Thorn1", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2981F, -1.3398F, 0.4115F, 1.3865F, -1.0916F, 2.7498F));

		PartDefinition Plane_r1 = Thorn1.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r2 = Thorn1.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn2 = Thorns.addOrReplaceChild("Thorn2", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9744F, -0.8246F, 3.0539F, 1.629F, -0.2731F, 3.1152F));

		PartDefinition Plane_r3 = Thorn2.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r4 = Thorn2.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn3 = Thorns.addOrReplaceChild("Thorn3", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6094F, 0.7797F, 1.796F, 0.8865F, 0.5052F, 2.559F));

		PartDefinition Plane_r5 = Thorn3.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r6 = Thorn3.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn4 = Thorns.addOrReplaceChild("Thorn4", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -0.8333F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9294F, -3.5137F, -0.6748F, 0.0766F, 0.8535F, 2.5889F));

		PartDefinition Plane_r7 = Thorn4.addOrReplaceChild("Plane_r7", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition Plane_r8 = Thorn4.addOrReplaceChild("Plane_r8", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.1667F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Thorn5 = Thorns.addOrReplaceChild("Thorn5", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -4.1667F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6898F, 2.6578F, 1.2416F, -0.1748F, 0.8426F, -2.7199F));

		PartDefinition Plane_r9 = Thorn5.addOrReplaceChild("Plane_r9", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, 0.0F, 0.7854F, 3.1416F));

		PartDefinition Plane_r10 = Thorn5.addOrReplaceChild("Plane_r10", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, 0.0F, -0.7854F, 3.1416F));

		PartDefinition Thorn6 = Thorns.addOrReplaceChild("Thorn6", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -4.1667F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9078F, 2.0814F, -2.4799F, 1.5705F, 0.8426F, -2.7199F));

		PartDefinition Plane_r11 = Thorn6.addOrReplaceChild("Plane_r11", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, -3.1416F, -0.7854F, 0.0F));

		PartDefinition Plane_r12 = Thorn6.addOrReplaceChild("Plane_r12", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, -3.1416F, 0.7854F, 0.0F));

		PartDefinition Thorn7 = Thorns.addOrReplaceChild("Thorn7", CubeListBuilder.create().texOffs(48, 142).addBox(-1.0F, -4.1667F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.7308F, -1.2011F, -3.5711F, 2.1814F, -0.8426F, 2.7199F));

		PartDefinition Plane_r13 = Thorn7.addOrReplaceChild("Plane_r13", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, -3.1416F, 0.7854F, 0.0F));

		PartDefinition Plane_r14 = Thorn7.addOrReplaceChild("Plane_r14", CubeListBuilder.create().texOffs(0, -2).mirror().addBox(0.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -6.6667F, 0.0F, -3.1416F, -0.7854F, 0.0F));

		PartDefinition Impaled = TumorTip.addOrReplaceChild("Impaled", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 5.0F));

		PartDefinition Jaw_r1 = Impaled.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(48, 89).addBox(-4.0F, -0.5F, 0.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.9758F, -4.0093F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Head_r1 = Impaled.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(40, 74).addBox(-4.0F, -7.0F, 0.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.3136F, -4.378F, 2.0379F, -0.0767F, -0.1188F));

		PartDefinition Leg_r1 = Impaled.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(23, 66).addBox(-1.5F, -0.5F, -1.5F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.5F, 2.5F, 0.303F, 0.0393F, -0.1249F));

		PartDefinition Leg_r2 = Impaled.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(22, 65).addBox(-1.0F, -1.0F, -5.25F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, -1.0F, 0.4363F, 0.0F, -0.4363F));

		PartDefinition Leg_r3 = Impaled.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(22, 65).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 3.0F, -0.3927F, 0.0F, 0.3491F));

		PartDefinition LowerTorso_r1 = Impaled.addOrReplaceChild("LowerTorso_r1", CubeListBuilder.create().texOffs(0, 75).addBox(-4.0F, -6.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.3123F, 0.1895F, 0.7854F, 0.0F, 0.0F));

		PartDefinition LowerTorso_r2 = Impaled.addOrReplaceChild("LowerTorso_r2", CubeListBuilder.create().texOffs(0, 65).addBox(-4.0F, -2.0F, -3.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tail1Fungus = Tail.addOrReplaceChild("Tail1Fungus", CubeListBuilder.create(), PartPose.offsetAndRotation(0.9213F, -1.0139F, 4.4424F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Fungus_r49 = Tail1Fungus.addOrReplaceChild("Fungus_r49", CubeListBuilder.create().texOffs(-7, 122).addBox(-3.5F, 2.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5787F, -3.5475F, -3.4873F, 0.1797F, -0.4891F, -0.195F));

		PartDefinition Fungus_r50 = Tail1Fungus.addOrReplaceChild("Fungus_r50", CubeListBuilder.create().texOffs(-7, 129).addBox(-3.5F, 12.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5787F, -8.5475F, 2.5127F, -0.3325F, 0.5154F, -0.0523F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	public void animateSpike(ModelPart part,float value){
		part.yScale = 1 + value;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float tailSpin = Mth.sin(ageInTicks/8)/4;
		float spikeValue = Mth.cos(ageInTicks/8)/4;
		float walkingValue = Mth.cos(limbSwing * 0.2F) * 0.8F * limbSwingAmount;
		animateTentacleY(TailSegment1,tailSpin);
		animateTentacleY(TailSegment2,tailSpin);
		animateTentacleY(TailSegment3,tailSpin);
		animateTentacleY(TailSegment4,tailSpin);
		animateTumor(TailTumor,Mth.cos(ageInTicks/7)/6);
		animateSpike(Spike1,spikeValue);
		animateSpike(Spike2,-spikeValue);
		animateSpike(Spike3,spikeValue);
		animateSpike(Spike4,-spikeValue);
		animateSpike(Spike5,spikeValue);
		animateSpike(Spike6,-spikeValue);
		animateSpike(Spike7,spikeValue);
		TailBody.visible = entity.hasImpaledBody();
		this.Jaw1.xRot = entity.isAggressive() ? (float) (0.5 + Mth.sin(ageInTicks / 2) / 8) : 0;
		this.Jaw2.xRot =this.Jaw2.getInitialPose().xRot + Mth.sin(ageInTicks / 8) / 8;
		this.Jaw3.xRot = Mth.sin(ageInTicks / 8) / 8;
		this.HeadY.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.HeadX.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Legs.yRot = walkingValue * 0.3f;
		this.LeftBackLeg.xRot = this.LeftBackLeg.getInitialPose().xRot + walkingValue;
		this.LeftBackForLeg.xRot = this.LeftBackForLeg.getInitialPose().xRot - walkingValue;
		this.RightBackLeg.xRot = this.RightBackLeg.getInitialPose().xRot - walkingValue;
		this.RightBackForLeg.xRot = this.RightBackForLeg.getInitialPose().xRot + walkingValue;
		this.RightFrontArm.zRot = this.RightFrontArm.getInitialPose().zRot + walkingValue * 0.6f;
		this.LeftFrontArm.zRot = this.LeftFrontArm.getInitialPose().zRot +walkingValue * 0.6f;
		this.RightFrontForArm.zRot =this.RightFrontForArm.getInitialPose().zRot + walkingValue * 0.3f;
		this.LeftFrontForArm.zRot =this.LeftFrontForArm.getInitialPose().zRot + walkingValue * 0.3f;
		this.RightFrontArm.y = this.RightFrontArm.getInitialPose().y + walkingValue * 1.3f;
		this.LeftFrontArm.y = this.LeftFrontArm.getInitialPose().y - walkingValue * 1.3f;
	}
	@Override
	public void prepareMobModel(T entity, float value1, float value2, float value3) {
		super.prepareMobModel(entity, value1, value2, value3);
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			float spinValue = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick - value3, 10.0F);
			H_brute.yRot = spinValue * 2f;
			TailSegment1.yRot = spinValue;
			TailSegment2.yRot = spinValue/2;
			TailSegment3.yRot = spinValue/2;
			TailSegment4.yRot = spinValue/2;
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		H_brute.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}