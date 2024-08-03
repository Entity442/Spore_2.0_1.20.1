package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Calamities.Howitzer;
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

public class HowitzerModel<T extends Howitzer> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "howitzer_model"), "main");
	private final ModelPart Howi;
	private final ModelPart Maw;
	private final ModelPart Jaw1;
	private final ModelPart Jaw2;
	private final ModelPart Jaw3;
	private final ModelPart Tongue;
	private final ModelPart Tongue2;
	private final ModelPart Tongue3;
	private final ModelPart Tongue4;
	private final ModelPart Tongue5;
	private final ModelPart Tongue6;
	private final ModelPart Tumor1;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Tumor5;
	private final ModelPart Tumor6;
	private final ModelPart Tumor7;
	private final ModelPart CononCluster1;
	private final ModelPart CononCluster2;
	private final ModelPart CononCluster3;
	private final ModelPart CononCluster4;
	private final ModelPart Cannon1;
	private final ModelPart Cannon2;
	private final ModelPart Cannon3;
	private final ModelPart Cannon4;
	private final ModelPart Cannon5;
	private final ModelPart Cannon6;
	private final ModelPart Cannon7;
	private final ModelPart Cannon8;
	private final ModelPart Cannon9;
	private final ModelPart CannonFlower;
	private final ModelPart CannonHead;
	private final ModelPart Tentacle1;
	private final ModelPart Tentacle2;
	private final ModelPart Tentacle3;
	private final ModelPart Tentacle4;
	private final ModelPart Tentacle5;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegTentacle;
	private final ModelPart RightLeg;
	private final ModelPart RightForLeg;
	private final ModelPart RightLegTentacle1;
	private final ModelPart RightLegTentacle2;
	private final ModelPart RightLegTentacle3;
	private final ModelPart RightLegTentacle4;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart RightForForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart LeftForForArm;
	private final ModelPart LeftArmTendril1;
	private final ModelPart LeftArmTendril2;
	private final ModelPart LeftArmTendril3;
	private final ModelPart LeftArmTendril4;

	public HowitzerModel(ModelPart root) {
		this.Howi = root.getChild("Howi");
		this.Maw = Howi.getChild("Maw");
		this.Jaw1 = Maw.getChild("jaw1");
		this.Jaw2 = Maw.getChild("jaw2");
		this.Jaw3 = Maw.getChild("jaw3");
		this.Tongue = Maw.getChild("Tongue");
		this.Tongue2 = Tongue.getChild("TongueSeg2");
		this.Tongue3 = Tongue2.getChild("TongueSeg3");
		this.Tongue4 = Tongue3.getChild("TongueSeg4");
		this.Tongue5 = Tongue4.getChild("TongueSplit1");
		this.Tongue6 = Tongue4.getChild("TongueSplit2");
		this.Tumor1 = Howi.getChild("BileSacs").getChild("BallSac1");
		this.Tumor2 = Howi.getChild("BileSacs").getChild("BallSac2");
		this.Tumor3 = Howi.getChild("BileSacs").getChild("BallSac3");
		this.Tumor4 = Howi.getChild("BileSacs").getChild("BallSac4");
		this.Tumor5 = Howi.getChild("BileSacs").getChild("BallSac5");
		this.Tumor6 = Howi.getChild("BileSacs").getChild("BallSac6");
		this.Tumor7 = Howi.getChild("BileSacs").getChild("MajorBallSack");
		this.CononCluster1 = Howi.getChild("CannonClusters").getChild("Cluster1");
		this.CononCluster2 = Howi.getChild("CannonClusters").getChild("Cluster2");
		this.CononCluster3 = Howi.getChild("CannonClusters").getChild("Cluster3");
		this.CononCluster4 = Howi.getChild("CannonClusters").getChild("FailedCannon");
		this.Cannon1 = this.CononCluster1.getChild("C1C1");
		this.Cannon2 = this.CononCluster1.getChild("C1C2");
		this.Cannon3 = this.CononCluster1.getChild("C1C3");
		this.Cannon4 = this.CononCluster2.getChild("C2C1");
		this.Cannon5 = this.CononCluster2.getChild("C2C2");
		this.Cannon6 = this.CononCluster2.getChild("C2C3");
		this.Cannon7 = this.CononCluster3.getChild("C3C1");
		this.Cannon8 = this.CononCluster3.getChild("C3C2");
		this.Cannon9 = this.CononCluster3.getChild("C3C3");
		this.CannonFlower = this.CononCluster4.getChild("FailedCannonFlower");
		this.CannonHead = Cannon7.getChild("C3C1Top").getChild("ThisIsSporeSlasher");
		this.Tentacle1 = Howi.getChild("BodyRoots").getChild("Root1");
		this.Tentacle2 = Howi.getChild("BodyRoots").getChild("Root2");
		this.Tentacle3 = Howi.getChild("BodyRoots").getChild("Root3");
		this.Tentacle4 = Howi.getChild("BodyRoots").getChild("Root4");
		this.Tentacle5 = Howi.getChild("BodyRoots").getChild("Root5");
		this.LeftLeg = Howi.getChild("Legs").getChild("LeftLegJoint");
		this.LeftLegTentacle = this.LeftLeg.getChild("LeftLeg").getChild("LeftLeg2").getChild("Tendril9");
		this.RightLeg = Howi.getChild("Legs").getChild("RightLegJoint");
		this.RightForLeg = RightLeg.getChild("RightLeg").getChild("RightLeg3");
		this.RightLegTentacle1 = RightLeg.getChild("RightLeg").getChild("Tendril8");
		this.RightLegTentacle2 = RightForLeg.getChild("RightLeg2").getChild("Tendril5");
		this.RightLegTentacle3 = RightForLeg.getChild("RightLeg2").getChild("Tendril6");
		this.RightLegTentacle4 = RightForLeg.getChild("RightLeg2").getChild("Tendril7");
		this.RightArm = Howi.getChild("Arms").getChild("RightArmJoint");
		this.RightForArm = RightArm.getChild("RightArm").getChild("RightArmSeg2");
		this.RightForForArm = RightForArm.getChild("RightArmSeg3");
		this.LeftArm = Howi.getChild("Arms").getChild("LeftArmJoint");
		this.LeftForArm = LeftArm.getChild("LeftArm").getChild("LeftArmSeg2");
		this.LeftForForArm = LeftForArm.getChild("LeftArmSeg3");
		this.LeftArmTendril1 = LeftForForArm.getChild("Tendril1");
		this.LeftArmTendril2 = LeftForForArm.getChild("Tendril2");
		this.LeftArmTendril3 = LeftForForArm.getChild("LeftArmSeg4").getChild("Tendril3");
		this.LeftArmTendril4 = LeftForForArm.getChild("LeftArmSeg4").getChild("Tendril4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Howi = partdefinition.addOrReplaceChild("Howi", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Chunk3_r1 = Howi.addOrReplaceChild("Chunk3_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-25.0031F, -34.8592F, -18.9042F, 64.0F, 64.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8101F, -44.8459F, 0.2709F, 0.1371F, 0.5435F, 0.4008F));

		PartDefinition Chunk2_r1 = Howi.addOrReplaceChild("Chunk2_r1", CubeListBuilder.create().texOffs(176, 192).addBox(-23.1263F, -28.114F, -34.5034F, 48.0F, 48.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8101F, -44.8459F, 0.2709F, 0.4245F, 0.5093F, 0.0762F));

		PartDefinition Chunk1_r1 = Howi.addOrReplaceChild("Chunk1_r1", CubeListBuilder.create().texOffs(0, 128).addBox(-37.4545F, -36.1745F, -24.3098F, 56.0F, 56.0F, 56.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8101F, -44.8459F, 0.2709F, -0.5245F, 0.5615F, -0.8099F));

		PartDefinition MainBodyBodies = Howi.addOrReplaceChild("MainBodyBodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body33 = MainBodyBodies.addOrReplaceChild("Body33", CubeListBuilder.create(), PartPose.offsetAndRotation(-30.2688F, -46.9627F, -27.0576F, 2.0015F, 1.0549F, 0.1054F));

		PartDefinition Leg_r1 = Body33.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.5852F));

		PartDefinition Arm_r1 = Body33.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r2 = Body33.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(257, 330).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r1 = Body33.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r1 = Body33.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(257, 330).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = Body33.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition Body34 = MainBodyBodies.addOrReplaceChild("Body34", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.391F, -24.0574F, -21.2077F, 0.0F, -1.1781F, -1.3963F));

		PartDefinition Leg_r2 = Body34.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(257, 330).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4096F, -3.5211F, -3.0704F, -0.1297F, -0.0298F, -0.082F));

		PartDefinition Leg_r3 = Body34.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(257, 330).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5286F, -3.3013F, 1.75F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r3 = Body34.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(257, 330).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, -3.5737F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r1 = Body34.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(257, 330).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.167F, -16.9397F, 2.5094F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r2 = Body34.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(257, 330).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition TorsoBase_r2 = Body34.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(257, 330).addBox(-2.5F, -4.0F, -3.25F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Body35 = MainBodyBodies.addOrReplaceChild("Body35", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0788F, -26.2941F, -33.6027F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Leg_r4 = Body35.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(257, 333).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r3 = Body35.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(257, 333).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r4 = Body35.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(257, 333).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r5 = Body35.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(257, 333).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r1 = Body35.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(257, 333).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = Body35.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(257, 333).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition Body36 = MainBodyBodies.addOrReplaceChild("Body36", CubeListBuilder.create().texOffs(257, 333).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.508F, -54.6701F, -36.0412F, 1.6691F, -0.478F, -0.0453F));

		PartDefinition Leg_r5 = Body36.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(257, 333).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r3 = Body36.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(257, 333).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r6 = Body36.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(257, 333).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r3 = Body36.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(257, 333).addBox(-3.75F, -1.25F, -2.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -1.1171F, 0.2698F, 0.4077F));

		PartDefinition Body37 = MainBodyBodies.addOrReplaceChild("Body37", CubeListBuilder.create(), PartPose.offsetAndRotation(-35.338F, -60.4715F, -18.4026F, 0.0F, 0.8727F, -0.5672F));

		PartDefinition TorsoBase_r4 = Body37.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(257, 328).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r4 = Body37.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(257, 328).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r5 = Body37.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(257, 328).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r4 = Body37.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(257, 328).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body38 = MainBodyBodies.addOrReplaceChild("Body38", CubeListBuilder.create(), PartPose.offsetAndRotation(-45.8448F, -57.0206F, 6.14F, -1.9783F, 0.5657F, -0.7654F));

		PartDefinition Leg_r6 = Body38.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(257, 331).addBox(-0.336F, -1.8936F, -8.7798F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8845F, -2.5592F, -4.5018F, -1.6261F, 0.9235F, 0.0354F));

		PartDefinition TorsoBase_r5 = Body38.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -4.0F, -2.75F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, -0.1988F, -4.3066F, -0.4485F, 0.4285F, 0.1972F));

		PartDefinition Arm_r7 = Body38.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(257, 331).addBox(-1.081F, -1.1697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r8 = Body38.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4172F, 4.1598F, -0.8274F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r2 = Body38.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body39 = MainBodyBodies.addOrReplaceChild("Body39", CubeListBuilder.create(), PartPose.offsetAndRotation(-49.7107F, -40.7942F, 15.0297F, -1.3129F, -0.6426F, -1.1705F));

		PartDefinition Leg_r7 = Body39.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0247F, 6.1193F, -5.0164F, 3.0361F, -0.9768F, -0.9976F));

		PartDefinition Leg_r8 = Body39.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -1.5F, -9.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6884F, 5.0875F, -1.3405F, 2.786F, -0.2264F, 0.1954F));

		PartDefinition TorsoBase_r6 = Body39.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 1.5115F, 0.4081F, -0.0114F));

		PartDefinition Arm_r9 = Body39.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(257, 331).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r10 = Body39.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(257, 331).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r6 = Body39.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r5 = Body39.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(257, 331).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition Body40 = MainBodyBodies.addOrReplaceChild("Body40", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.61F, -59.2429F, 48.1698F, 1.7017F, 0.0F, 0.0F));

		PartDefinition Arm_r11 = Body40.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(257, 331).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6669F, 0.097F, 0.3721F, 0.1774F, -0.5587F, -1.5066F));

		PartDefinition TorsoBase_r7 = Body40.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6248F, 3.8271F, -4.1274F, 0.4741F, 0.461F, -0.0476F));

		PartDefinition TorsoTop_r7 = Body40.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7901F, 1.0908F, 0.168F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r6 = Body40.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(257, 331).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3149F, -2.8789F, 5.628F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition Body41 = MainBodyBodies.addOrReplaceChild("Body41", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0199F, -32.3169F, 41.7919F, -0.0526F, -0.7082F, -2.1855F));

		PartDefinition Leg_r9 = Body41.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(257, 331).addBox(-2.664F, -8.6064F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -0.234F, -0.5178F, -1.4767F));

		PartDefinition Leg_r10 = Body41.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(257, 331).addBox(-2.664F, 0.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.4744F, -0.2937F, -1.281F));

		PartDefinition TorsoBase_r8 = Body41.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r12 = Body41.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r13 = Body41.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(257, 331).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r8 = Body41.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r7 = Body41.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition Body42 = MainBodyBodies.addOrReplaceChild("Body42", CubeListBuilder.create(), PartPose.offsetAndRotation(2.9686F, -11.8991F, 34.9421F, -1.4198F, -0.2046F, 0.2284F));

		PartDefinition Leg_r11 = Body42.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r9 = Body42.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r14 = Body42.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r15 = Body42.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(257, 331).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.9353F, 0.8543F, -0.1475F));

		PartDefinition TorsoTop_r9 = Body42.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body43 = MainBodyBodies.addOrReplaceChild("Body43", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.9334F, -17.7491F, 27.1803F, -1.8276F, -0.2542F, 0.572F));

		PartDefinition Leg_r12 = Body43.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(257, 331).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r10 = Body43.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r16 = Body43.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r10 = Body43.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(257, 331).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition Body44 = MainBodyBodies.addOrReplaceChild("Body44", CubeListBuilder.create(), PartPose.offsetAndRotation(27.2533F, -62.1291F, 36.8665F, 1.1839F, 0.627F, -1.4293F));

		PartDefinition TorsoBase_r11 = Body44.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(257, 331).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.274F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r3 = Body44.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(257, 331).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r4 = Body44.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(257, 331).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r8 = Body44.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition Body45 = MainBodyBodies.addOrReplaceChild("Body45", CubeListBuilder.create(), PartPose.offsetAndRotation(11.0F, -40.7111F, 46.8813F, 0.7295F, 0.4366F, -0.4419F));

		PartDefinition Leg_r13 = Body45.addOrReplaceChild("Leg_r13", CubeListBuilder.create().texOffs(257, 331).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r12 = Body45.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7363F, 2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r17 = Body45.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r5 = Body45.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(257, 331).addBox(-3.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition Body46 = MainBodyBodies.addOrReplaceChild("Body46", CubeListBuilder.create(), PartPose.offsetAndRotation(53.81F, -54.746F, 20.8976F, -1.6155F, 0.218F, -0.0097F));

		PartDefinition Leg_r14 = Body46.addOrReplaceChild("Leg_r14", CubeListBuilder.create().texOffs(257, 331).addBox(-1.1032F, -0.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1597F, 0.7638F, 0.5852F));

		PartDefinition Arm_r18 = Body46.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(257, 331).addBox(-0.5219F, -0.4371F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.2366F, -5.5182F, 2.8999F, 0.0232F, 0.8265F, 0.2967F));

		PartDefinition Arm_r19 = Body46.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(257, 331).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -2.9185F, 12.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r13 = Body46.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(257, 331).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0912F, -1.28F, 3.724F, 0.1286F, 0.4614F, 0.5318F));

		PartDefinition TorsoTop_r11 = Body46.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(257, 331).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(257, 331).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0177F, 0.4775F, 0.2877F));

		PartDefinition Jaw_r2 = Body46.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(257, 331).addBox(-0.752F, -4.9611F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1819F, -2.6742F, 8.0896F, 0.1692F, 0.2135F, 0.7249F));

		PartDefinition Body47 = MainBodyBodies.addOrReplaceChild("Body47", CubeListBuilder.create(), PartPose.offsetAndRotation(38.6058F, -7.0265F, 23.0951F, -0.4614F, -1.029F, 0.5258F));

		PartDefinition Leg_r15 = Body47.addOrReplaceChild("Leg_r15", CubeListBuilder.create().texOffs(257, 331).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4096F, -3.5211F, 3.0704F, 0.2978F, -0.1848F, 0.5394F));

		PartDefinition Leg_r16 = Body47.addOrReplaceChild("Leg_r16", CubeListBuilder.create().texOffs(257, 331).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5286F, -3.3013F, -1.75F, -0.211F, 0.056F, 0.2559F));

		PartDefinition Arm_r20 = Body47.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(257, 331).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r9 = Body47.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.167F, -16.9397F, -2.5094F, -1.8953F, -1.1912F, 2.0859F));

		PartDefinition TorsoTop_r12 = Body47.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(257, 331).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r14 = Body47.addOrReplaceChild("TorsoBase_r14", CubeListBuilder.create().texOffs(257, 331).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.5F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body48 = MainBodyBodies.addOrReplaceChild("Body48", CubeListBuilder.create(), PartPose.offsetAndRotation(54.3823F, -62.4885F, 6.952F, -2.7925F, 1.4399F, -3.1416F));

		PartDefinition Leg_r17 = Body48.addOrReplaceChild("Leg_r17", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r15 = Body48.addOrReplaceChild("TorsoBase_r15", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r21 = Body48.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r22 = Body48.addOrReplaceChild("Arm_r22", CubeListBuilder.create().texOffs(257, 331).addBox(-1.9496F, -0.9033F, -7.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoTop_r13 = Body48.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r10 = Body48.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(257, 331).addBox(-3.7022F, -0.41F, -3.6522F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.13F, -4.0992F, -2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition Body49 = MainBodyBodies.addOrReplaceChild("Body49", CubeListBuilder.create().texOffs(257, 331).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(25.5477F, -69.9177F, -21.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Leg_r18 = Body49.addOrReplaceChild("Leg_r18", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r11 = Body49.addOrReplaceChild("Head_r11", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r23 = Body49.addOrReplaceChild("Arm_r23", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r14 = Body49.addOrReplaceChild("TorsoTop_r14", CubeListBuilder.create().texOffs(257, 331).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition Body50 = MainBodyBodies.addOrReplaceChild("Body50", CubeListBuilder.create(), PartPose.offsetAndRotation(42.5179F, -59.7749F, -22.5747F, 0.7854F, 0.0F, 1.309F));

		PartDefinition TorsoBase_r16 = Body50.addOrReplaceChild("TorsoBase_r16", CubeListBuilder.create().texOffs(257, 331).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8836F, 8.6026F, 3.8552F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r15 = Body50.addOrReplaceChild("TorsoTop_r15", CubeListBuilder.create().texOffs(257, 331).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1991F, 4.1416F, 6.3927F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r16 = Body50.addOrReplaceChild("TorsoTop_r16", CubeListBuilder.create().texOffs(257, 331).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(257, 331).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Body51 = MainBodyBodies.addOrReplaceChild("Body51", CubeListBuilder.create(), PartPose.offsetAndRotation(21.3099F, -24.0013F, -28.5803F, -0.9762F, 0.3446F, -1.2993F));

		PartDefinition Leg_r19 = Body51.addOrReplaceChild("Leg_r19", CubeListBuilder.create().texOffs(257, 331).addBox(-2.664F, -1.8936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -2.5592F, 4.5018F, 0.8843F, 0.9235F, -0.0354F));

		PartDefinition TorsoBase_r17 = Body51.addOrReplaceChild("TorsoBase_r17", CubeListBuilder.create().texOffs(257, 331).addBox(-3.0F, -4.0F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -0.1988F, 4.3066F, 0.4485F, 0.4285F, -0.1972F));

		PartDefinition Arm_r24 = Body51.addOrReplaceChild("Arm_r24", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -1.1697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, -2.3868F, 0.3569F, -1.7879F));

		PartDefinition Arm_r25 = Body51.addOrReplaceChild("Arm_r25", CubeListBuilder.create().texOffs(257, 331).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r6 = Body51.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Body52 = MainBodyBodies.addOrReplaceChild("Body52", CubeListBuilder.create(), PartPose.offsetAndRotation(9.9501F, -77.6974F, -11.6194F, 0.546F, -0.1623F, 0.2599F));

		PartDefinition Arm_r26 = Body52.addOrReplaceChild("Arm_r26", CubeListBuilder.create().texOffs(257, 331).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6669F, 0.097F, -0.3721F, -1.6609F, -0.5587F, 1.5066F));

		PartDefinition TorsoBase_r18 = Body52.addOrReplaceChild("TorsoBase_r18", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6248F, 3.8271F, 4.1274F, -0.4741F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r17 = Body52.addOrReplaceChild("TorsoTop_r17", CubeListBuilder.create().texOffs(257, 331).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7901F, 1.0908F, -0.168F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r12 = Body52.addOrReplaceChild("Head_r12", CubeListBuilder.create().texOffs(257, 331).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3149F, -2.8789F, -5.628F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition Belly = Howi.addOrReplaceChild("Belly", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition BellyBase_r1 = Belly.addOrReplaceChild("BellyBase_r1", CubeListBuilder.create().texOffs(168, 128).addBox(-14.3F, -6.0F, -22.0F, 37.0F, 9.0F, 44.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 1.0F, 6.0F, -0.0536F, 0.7414F, -0.0178F));

		PartDefinition Legs = Howi.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, -9.0F, 0.0F));

		PartDefinition LeftLegJoint = Legs.addOrReplaceChild("LeftLegJoint", CubeListBuilder.create(), PartPose.offset(21.985F, -5.7341F, 0.0F));

		PartDefinition LeftLeg = LeftLegJoint.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1828F, 0.3006F, -0.6656F));

		PartDefinition LegSeg1_r1 = LeftLeg.addOrReplaceChild("LegSeg1_r1", CubeListBuilder.create().texOffs(280, 392).addBox(-10.0F, -8.0F, -9.0F, 20.0F, 21.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0775F, 0.0138F, -0.1041F));

		PartDefinition LeftLeg2 = LeftLeg.addOrReplaceChild("LeftLeg2", CubeListBuilder.create().texOffs(264, 431).addBox(-7.5F, -4.0F, -8.0F, 15.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7481F, 18.2909F, -0.5F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Body31 = LeftLeg2.addOrReplaceChild("Body31", CubeListBuilder.create(), PartPose.offsetAndRotation(8.1972F, 4.4458F, -0.5355F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Leg_r20 = Body31.addOrReplaceChild("Leg_r20", CubeListBuilder.create().texOffs(255, 326).addBox(-1.1032F, -2.2452F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, -2.2911F, -5.6196F, -0.6746F, 0.4201F, -1.4557F));

		PartDefinition Arm_r27 = Body31.addOrReplaceChild("Arm_r27", CubeListBuilder.create().texOffs(255, 326).addBox(-0.5219F, -2.5629F, -1.7124F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, 3.2271F, -2.7196F, -0.0232F, 0.8265F, -0.2967F));

		PartDefinition Arm_r28 = Body31.addOrReplaceChild("Arm_r28", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6481F, -1.6532F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, 0.6274F, 6.7458F, -0.0163F, -0.2642F, -0.2753F));

		PartDefinition TorsoBase_r19 = Body31.addOrReplaceChild("TorsoBase_r19", CubeListBuilder.create().texOffs(255, 326).addBox(-3.25F, -2.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, -1.0111F, -1.8956F, -0.1286F, 0.4614F, -0.5318F));

		PartDefinition TorsoBottom_r7 = Body31.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -0.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(255, 326).addBox(-14.0F, -2.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, -1.6966F, -0.4934F, -0.0177F, 0.4775F, -0.2877F));

		PartDefinition Jaw_r3 = Body31.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-0.752F, -3.0389F, -4.1134F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, 0.3831F, 2.47F, -0.1692F, 0.2135F, -0.7249F));

		PartDefinition Body32 = LeftLeg2.addOrReplaceChild("Body32", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7962F, 10.324F, -8.0544F, -1.6623F, 0.3042F, -0.0275F));

		PartDefinition Leg_r21 = Body32.addOrReplaceChild("Leg_r21", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r13 = Body32.addOrReplaceChild("Head_r13", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r29 = Body32.addOrReplaceChild("Arm_r29", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r18 = Body32.addOrReplaceChild("TorsoTop_r18", CubeListBuilder.create().texOffs(255, 326).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition Tendril9 = LeftLeg2.addOrReplaceChild("Tendril9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8966F, -10.9625F, 1.5F, 0.0F, -0.0594F, 0.2667F));

		PartDefinition RootSeg_r1 = Tendril9.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(10, 166).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril9 = Tendril9.addOrReplaceChild("Seg2Tendril9", CubeListBuilder.create().texOffs(340, 300).addBox(-2.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Seg3Tendril9 = Seg2Tendril9.addOrReplaceChild("Seg3Tendril9", CubeListBuilder.create().texOffs(322, 234).addBox(-2.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Seg4Tendril9 = Seg3Tendril9.addOrReplaceChild("Seg4Tendril9", CubeListBuilder.create().texOffs(324, 36).addBox(-1.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition LeftFoot = LeftLeg2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(344, 35).addBox(-8.5F, 0.0F, -10.0F, 17.0F, 5.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0109F, 18.2498F, 0.25F, -0.0436F, 0.0019F, 0.0872F));

		PartDefinition LeftToe1 = LeftFoot.addOrReplaceChild("LeftToe1", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.2605F, 5.5383F, -3.0642F, 0.3981F, 0.6442F, 0.1455F));

		PartDefinition Arm_r30 = LeftToe1.addOrReplaceChild("Arm_r30", CubeListBuilder.create().texOffs(422, 185).addBox(-0.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.4802F, -3.5F, -4.8385F, 0.0F, -0.5236F, 0.0F));

		PartDefinition Arm_r31 = LeftToe1.addOrReplaceChild("Arm_r31", CubeListBuilder.create().texOffs(422, 185).addBox(-2.0F, -1.0F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -4.0F, -6.0F, 0.0F, 0.5236F, 0.0F));

		PartDefinition TopTorso_r1 = LeftToe1.addOrReplaceChild("TopTorso_r1", CubeListBuilder.create().texOffs(422, 185).addBox(-3.5086F, -2.92F, -4.6766F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, -3.1576F, -5.0832F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftToe1Head = LeftToe1.addOrReplaceChild("LeftToe1Head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1736F, -2.5048F, -9.5663F, -0.0154F, -0.1739F, 0.0886F));

		PartDefinition Head_r14 = LeftToe1Head.addOrReplaceChild("Head_r14", CubeListBuilder.create().texOffs(422, 185).addBox(-4.0086F, -1.6093F, -11.4496F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, 0.3472F, 5.4679F, -0.9163F, 0.0F, 0.0F));

		PartDefinition Jaw_r4 = LeftToe1Head.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(422, 185).addBox(-4.0F, -0.5F, -8.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.7164F, -0.3655F, -0.2637F, 0.0617F, -0.0618F));

		PartDefinition LeftToe2 = LeftFoot.addOrReplaceChild("LeftToe2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4611F, 4.0219F, -3.8333F, 0.5082F, -0.8802F, -0.3037F));

		PartDefinition TopTorso_r2 = LeftToe2.addOrReplaceChild("TopTorso_r2", CubeListBuilder.create().texOffs(423, 184).addBox(-3.4914F, -2.92F, -4.6766F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0086F, -3.1576F, -5.0832F, -0.1309F, 0.0F, 0.0F));

		PartDefinition LeftToe2Head = LeftToe2.addOrReplaceChild("LeftToe2Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0592F, -2.473F, -9.8149F, 0.9688F, 0.3795F, 0.3126F));

		PartDefinition Head_r15 = LeftToe2Head.addOrReplaceChild("Head_r15", CubeListBuilder.create().texOffs(423, 184).addBox(-3.9914F, -1.6093F, -11.4496F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0086F, 2.0636F, 5.6384F, -0.9163F, 0.0F, 0.0F));

		PartDefinition LeftToe3 = LeftFoot.addOrReplaceChild("LeftToe3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.2282F, 3.8172F, 7.6139F, -0.3374F, -0.3588F, 0.0207F));

		PartDefinition Arm_r32 = LeftToe3.addOrReplaceChild("Arm_r32", CubeListBuilder.create().texOffs(422, 185).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.483F, -1.5233F, 0.6527F, 0.5973F, -0.5965F, -0.0566F));

		PartDefinition TopTorso_r3 = LeftToe3.addOrReplaceChild("TopTorso_r3", CubeListBuilder.create().texOffs(422, 185).addBox(-3.5086F, -2.92F, -1.3234F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4744F, -0.6809F, -0.2641F, 0.1309F, 0.0F, 0.0F));

		PartDefinition LeftToe3Head = LeftToe3.addOrReplaceChild("LeftToe3Head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5247F, -1.4356F, 4.2584F, -0.8137F, 0.1739F, 0.0886F));

		PartDefinition Head_r16 = LeftToe3Head.addOrReplaceChild("Head_r16", CubeListBuilder.create().texOffs(422, 185).addBox(-4.0086F, -1.6093F, 3.4496F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, 1.3472F, -4.4679F, 0.9163F, 0.0F, 0.0F));

		PartDefinition LeftToe4 = LeftFoot.addOrReplaceChild("LeftToe4", CubeListBuilder.create(), PartPose.offsetAndRotation(2.3311F, 2.0288F, 0.5899F, 0.4233F, 0.7109F, -0.0502F));

		PartDefinition Arm_r33 = LeftToe4.addOrReplaceChild("Arm_r33", CubeListBuilder.create().texOffs(422, 186).addBox(-0.5F, -1.5F, -3.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1858F, 3.8891F, 4.2087F, -0.2253F, -0.0659F, 0.1411F));

		PartDefinition Arm_r34 = LeftToe4.addOrReplaceChild("Arm_r34", CubeListBuilder.create().texOffs(422, 186).addBox(-1.5826F, -1.4473F, -0.8575F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 4.0F, 6.0F, -0.2499F, -0.4478F, 0.2361F));

		PartDefinition BottomTorso_r1 = LeftToe4.addOrReplaceChild("BottomTorso_r1", CubeListBuilder.create().texOffs(422, 186).addBox(-3.2184F, -1.5754F, -0.922F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, 3.1576F, 5.0832F, -0.3561F, 0.0617F, 0.1119F));

		PartDefinition LeftToe4Head = LeftToe4.addOrReplaceChild("LeftToe4Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.646F, 5.428F, 8.4064F, 0.4646F, 0.1739F, -0.0886F));

		PartDefinition Head_r17 = LeftToe4Head.addOrReplaceChild("Head_r17", CubeListBuilder.create().texOffs(422, 186).addBox(-3.8295F, -4.3428F, 4.132F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, -3.3472F, -4.4679F, -1.1639F, 0.0365F, 0.0727F));

		PartDefinition Jaw_r5 = LeftToe4Head.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(422, 186).addBox(-4.0F, -0.5F, -1.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1569F, -1.0654F, 1.6067F, -0.5083F, -0.0083F, 0.1477F));

		PartDefinition RightLegJoint = Legs.addOrReplaceChild("RightLegJoint", CubeListBuilder.create(), PartPose.offset(-26.0979F, -15.783F, 10.107F));

		PartDefinition RightLeg = RightLegJoint.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0567F, -0.108F, 0.9321F));

		PartDefinition LegSeg1_r2 = RightLeg.addOrReplaceChild("LegSeg1_r2", CubeListBuilder.create().texOffs(372, 374).addBox(-10.0F, -8.0F, -9.0F, 20.0F, 28.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0775F, -0.0138F, 0.1041F));

		PartDefinition Tendril8 = RightLeg.addOrReplaceChild("Tendril8", CubeListBuilder.create().texOffs(10, 166).addBox(-2.0F, -2.0F, -7.25F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3058F, 19.0455F, -5.9037F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Seg2Tendril8 = Tendril8.addOrReplaceChild("Seg2Tendril8", CubeListBuilder.create().texOffs(30, 51).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril8 = Seg2Tendril8.addOrReplaceChild("Seg3Tendril8", CubeListBuilder.create().texOffs(5, 37).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril3 = Seg3Tendril8.addOrReplaceChild("Seg4Tendril3", CubeListBuilder.create().texOffs(19, 39).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Body28 = RightLeg.addOrReplaceChild("Body28", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7876F, 14.7155F, 10.4834F, -1.403F, -0.1943F, -0.6289F));

		PartDefinition Leg_r22 = Body28.addOrReplaceChild("Leg_r22", CubeListBuilder.create().texOffs(255, 326).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6761F, 2.144F, 5.7616F, -0.6415F, -0.4735F, 1.3791F));

		PartDefinition Arm_r35 = Body28.addOrReplaceChild("Arm_r35", CubeListBuilder.create().texOffs(255, 326).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5604F, -3.3742F, 2.8616F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r36 = Body28.addOrReplaceChild("Arm_r36", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0742F, -0.7745F, -6.6038F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r20 = Body28.addOrReplaceChild("TorsoBase_r20", CubeListBuilder.create().texOffs(255, 326).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5849F, 0.864F, 2.0376F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r19 = Body28.addOrReplaceChild("TorsoTop_r19", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(255, 326).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6161F, 1.5495F, 0.6353F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r6 = Body28.addOrReplaceChild("Jaw_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5058F, -0.5302F, -2.3281F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition RightLeg3 = RightLeg.addOrReplaceChild("RightLeg3", CubeListBuilder.create().texOffs(0, 436).addBox(-7.5F, -3.5F, -8.0F, 15.0F, 19.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2726F, 22.3165F, 1.6595F, -0.0466F, -0.0432F, -0.6947F));

		PartDefinition Body29 = RightLeg3.addOrReplaceChild("Body29", CubeListBuilder.create(), PartPose.offset(-8.3794F, 18.2165F, -2.7664F));

		PartDefinition Leg_r23 = Body29.addOrReplaceChild("Leg_r23", CubeListBuilder.create().texOffs(255, 326).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4096F, -3.5211F, 3.0704F, 0.2978F, 0.1848F, -0.5394F));

		PartDefinition Leg_r24 = Body29.addOrReplaceChild("Leg_r24", CubeListBuilder.create().texOffs(255, 326).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5286F, -3.3013F, -1.75F, -0.211F, -0.056F, -0.2559F));

		PartDefinition Arm_r37 = Body29.addOrReplaceChild("Arm_r37", CubeListBuilder.create().texOffs(255, 326).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r18 = Body29.addOrReplaceChild("Head_r18", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.167F, -16.9397F, -2.5094F, -1.8953F, 1.1912F, -2.0859F));

		PartDefinition TorsoTop_r20 = Body29.addOrReplaceChild("TorsoTop_r20", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r21 = Body29.addOrReplaceChild("TorsoBase_r21", CubeListBuilder.create().texOffs(255, 326).addBox(-2.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

		PartDefinition RightLeg2 = RightLeg3.addOrReplaceChild("RightLeg2", CubeListBuilder.create().texOffs(396, 298).addBox(-8.5F, -7.5F, -9.0F, 17.0F, 26.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5932F, 18.5754F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Body30 = RightLeg2.addOrReplaceChild("Body30", CubeListBuilder.create(), PartPose.offsetAndRotation(5.9095F, 5.2078F, 8.4613F, -0.9615F, 0.1992F, -0.689F));

		PartDefinition Leg_r25 = Body30.addOrReplaceChild("Leg_r25", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -2.5112F, 0.2652F, -1.6509F));

		PartDefinition TorsoBase_r22 = Body30.addOrReplaceChild("TorsoBase_r22", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -1.3224F, 0.386F, -0.1363F));

		PartDefinition Arm_r38 = Body30.addOrReplaceChild("Arm_r38", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r39 = Body30.addOrReplaceChild("Arm_r39", CubeListBuilder.create().texOffs(255, 326).addBox(-1.9496F, -0.9033F, -7.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoTop_r21 = Body30.addOrReplaceChild("TorsoTop_r21", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r19 = Body30.addOrReplaceChild("Head_r19", CubeListBuilder.create().texOffs(255, 326).addBox(-3.7022F, -0.41F, -3.6522F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.13F, -4.0992F, -2.9916F, -2.2496F, 0.425F, -0.6146F));

		PartDefinition Tendril5 = RightLeg2.addOrReplaceChild("Tendril5", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -2.0F, -10.25F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9653F, -4.8465F, -6.1779F, 0.0F, 1.0908F, -0.7418F));

		PartDefinition Seg2Tendril5 = Tendril5.addOrReplaceChild("Seg2Tendril5", CubeListBuilder.create().texOffs(30, 51).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -10.0F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril5 = Seg2Tendril5.addOrReplaceChild("Seg3Tendril5", CubeListBuilder.create().texOffs(5, 37).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril2 = Seg3Tendril5.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(19, 39).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril6 = RightLeg2.addOrReplaceChild("Tendril6", CubeListBuilder.create().texOffs(10, 166).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(7.8532F, 3.2447F, -0.2639F, -1.0428F, 0.8917F, -0.2862F));

		PartDefinition Seg2Tendril6 = Tendril6.addOrReplaceChild("Seg2Tendril6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 7.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r1 = Seg2Tendril6.addOrReplaceChild("TendrilSeg_r1", CubeListBuilder.create().texOffs(31, 51).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril6 = Seg2Tendril6.addOrReplaceChild("Seg3Tendril6", CubeListBuilder.create().texOffs(11, 42).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition Tendril7 = RightLeg2.addOrReplaceChild("Tendril7", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.631F, -0.1622F, 7.4659F, -0.3023F, -0.6835F, -0.0705F));

		PartDefinition TendrilSeg_r2 = Tendril7.addOrReplaceChild("TendrilSeg_r2", CubeListBuilder.create().texOffs(1, 49).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril7 = Tendril7.addOrReplaceChild("Seg2Tendril7", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.8395F, 0.1886F, -0.1104F));

		PartDefinition Seg3Tendril7 = Seg2Tendril7.addOrReplaceChild("Seg3Tendril7", CubeListBuilder.create().texOffs(324, 36).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition RightFoot = RightLeg2.addOrReplaceChild("RightFoot", CubeListBuilder.create().texOffs(402, 180).addBox(-9.5F, 1.0F, -10.0F, 19.0F, 5.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0011F, 15.9227F, 0.7983F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightToe1 = RightFoot.addOrReplaceChild("RightToe1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5652F, 5.1991F, -4.8482F, 0.3981F, -0.6442F, -0.1455F));

		PartDefinition Arm_r40 = RightToe1.addOrReplaceChild("Arm_r40", CubeListBuilder.create().texOffs(424, 182).addBox(-2.5F, -1.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4802F, -3.5F, -4.8385F, -0.7854F, 0.5236F, 0.0F));

		PartDefinition TopTorso_r4 = RightToe1.addOrReplaceChild("TopTorso_r4", CubeListBuilder.create().texOffs(424, 182).addBox(-3.4914F, -2.92F, -4.6766F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0086F, -3.1576F, -5.0832F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightToe1Head = RightToe1.addOrReplaceChild("RightToe1Head", CubeListBuilder.create().texOffs(424, 182).addBox(-4.0F, -3.0F, -8.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1563F, -4.7583F, -8.5293F, -0.4178F, 0.2475F, 0.0732F));

		PartDefinition RightToe2 = RightFoot.addOrReplaceChild("RightToe2", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.6846F, 2.5091F, -5.9727F, 0.9555F, 1.1814F, 0.8164F));

		PartDefinition TopTorso_r5 = RightToe2.addOrReplaceChild("TopTorso_r5", CubeListBuilder.create().texOffs(422, 191).addBox(-3.5086F, -2.92F, -4.6766F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, 0.6352F, -0.3926F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightToe2Head = RightToe2.addOrReplaceChild("RightToe2Head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0592F, 1.3198F, -5.1242F, 0.5133F, 0.1084F, -0.1897F));

		PartDefinition Head_r20 = RightToe2Head.addOrReplaceChild("Head_r20", CubeListBuilder.create().texOffs(422, 191).addBox(-4.0086F, -1.6093F, -11.4496F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0086F, 2.0636F, 5.6384F, -0.9163F, 0.0F, 0.0F));

		PartDefinition RightToe3 = RightFoot.addOrReplaceChild("RightToe3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.2282F, 3.8172F, 7.6139F, -0.3374F, 0.3588F, -0.0207F));

		PartDefinition Arm_r41 = RightToe3.addOrReplaceChild("Arm_r41", CubeListBuilder.create().texOffs(425, 187).addBox(-2.5F, -1.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8009F, -1.9033F, 4.6549F, 0.5973F, -0.5965F, -0.0566F));

		PartDefinition TopTorso_r6 = RightToe3.addOrReplaceChild("TopTorso_r6", CubeListBuilder.create().texOffs(425, 187).addBox(-3.4914F, -2.92F, -1.3234F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4744F, -0.6809F, -0.2641F, 0.1309F, 0.0F, 0.0F));

		PartDefinition RightToe3Head = RightToe3.addOrReplaceChild("RightToe3Head", CubeListBuilder.create().texOffs(425, 187).addBox(-4.0F, -3.0F, 0.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5247F, -2.6976F, 3.2401F, 0.2618F, 0.0F, 0.0F));

		PartDefinition RightToe4 = RightFoot.addOrReplaceChild("RightToe4", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.7531F, 3.5382F, 8.4522F, 0.4233F, -0.7109F, 0.0502F));

		PartDefinition Arm_r42 = RightToe4.addOrReplaceChild("Arm_r42", CubeListBuilder.create().texOffs(424, 188).addBox(-2.5F, -1.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.958F, 0.7793F, 0.0537F, -0.5936F, -0.4014F, -0.0288F));

		PartDefinition Arm_r43 = RightToe4.addOrReplaceChild("Arm_r43", CubeListBuilder.create().texOffs(424, 188).addBox(-1.4174F, -1.4473F, -0.8575F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9154F, -0.5012F, 0.1226F, -0.2499F, 0.4478F, -0.2361F));

		PartDefinition BottomTorso_r2 = RightToe4.addOrReplaceChild("BottomTorso_r2", CubeListBuilder.create().texOffs(424, 188).addBox(-3.7816F, -1.5754F, -0.922F, 7.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0932F, -1.3436F, -0.7942F, -0.3561F, -0.0617F, -0.1119F));

		PartDefinition Arms = Howi.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightArmJoint = Arms.addOrReplaceChild("RightArmJoint", CubeListBuilder.create(), PartPose.offset(-24.8564F, -52.2784F, 27.0467F));

		PartDefinition RightArm = RightArmJoint.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(256, 83).addBox(-26.0F, -10.5F, -10.5F, 31.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2616F, 0.9503F, -0.4756F));

		PartDefinition Body18 = RightArm.addOrReplaceChild("Body18", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.6276F, -3.3115F, -11.2971F, 1.9668F, 1.2046F, 1.8979F));

		PartDefinition Leg_r26 = Body18.addOrReplaceChild("Leg_r26", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -4.75F, 0.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4366F, 9.2068F, 1.7609F, 0.3488F, 0.0149F, -0.041F));

		PartDefinition Leg_r27 = Body18.addOrReplaceChild("Leg_r27", CubeListBuilder.create().texOffs(255, 326).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.523F, 5.0385F, -2.4364F, -0.218F, -0.0094F, -0.0426F));

		PartDefinition Arm_r44 = Body18.addOrReplaceChild("Arm_r44", CubeListBuilder.create().texOffs(255, 326).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r21 = Body18.addOrReplaceChild("Head_r21", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9375F, -9.5286F, -3.4826F, 0.237F, 0.1945F, -0.1077F));

		PartDefinition TorsoTop_r22 = Body18.addOrReplaceChild("TorsoTop_r22", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r23 = Body18.addOrReplaceChild("TorsoBase_r23", CubeListBuilder.create().texOffs(255, 326).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body19 = RightArm.addOrReplaceChild("Body19", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.1852F, -0.1205F, 10.9369F, -1.0282F, 0.664F, 1.0672F));

		PartDefinition Arm_r45 = Body19.addOrReplaceChild("Arm_r45", CubeListBuilder.create().texOffs(255, 326).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.646F, -4.1312F, -0.386F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r46 = Body19.addOrReplaceChild("Arm_r46", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5131F, -1.9503F, -6.5947F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r8 = Body19.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(255, 326).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0681F, 2.8735F, 0.4794F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r9 = Body19.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7059F, 0.6936F, 2.4626F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r23 = Body19.addOrReplaceChild("TorsoTop_r23", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2725F, -2.0046F, -1.9926F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition Body20 = RightArm.addOrReplaceChild("Body20", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7273F, 11.8154F, -1.0636F, 0.0F, 0.0F, -1.8326F));

		PartDefinition Leg_r28 = Body20.addOrReplaceChild("Leg_r28", CubeListBuilder.create().texOffs(257, 331).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4032F, 4.788F, 2.3728F, -0.0397F, -0.0241F, -0.177F));

		PartDefinition Leg_r29 = Body20.addOrReplaceChild("Leg_r29", CubeListBuilder.create().texOffs(257, 331).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.773F, 5.0385F, -2.4364F, -0.2132F, -0.0469F, -0.2132F));

		PartDefinition Arm_r47 = Body20.addOrReplaceChild("Arm_r47", CubeListBuilder.create().texOffs(257, 331).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2343F, -6.4446F, 2.8873F, 1.8257F, 0.3567F, 0.2812F));

		PartDefinition TorsoTop_r24 = Body20.addOrReplaceChild("TorsoTop_r24", CubeListBuilder.create().texOffs(257, 331).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0056F, -0.6602F, -0.6864F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r24 = Body20.addOrReplaceChild("TorsoBase_r24", CubeListBuilder.create().texOffs(257, 331).addBox(-1.75F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, 3.3398F, -0.1864F, 0.0411F, -0.3027F, 0.2555F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(320, 0).addBox(-32.0F, -8.5F, -8.5F, 33.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.3267F, -0.4625F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Body21 = RightArmSeg2.addOrReplaceChild("Body21", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.4088F, -8.5442F, 4.7637F, -0.761F, -1.3001F, 1.3382F));

		PartDefinition TorsoBase_r25 = Body21.addOrReplaceChild("TorsoBase_r25", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r48 = Body21.addOrReplaceChild("Arm_r48", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r49 = Body21.addOrReplaceChild("Arm_r49", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r25 = Body21.addOrReplaceChild("TorsoTop_r25", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r22 = Body21.addOrReplaceChild("Head_r22", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition RightArmSeg3 = RightArmSeg2.addOrReplaceChild("RightArmSeg3", CubeListBuilder.create().texOffs(256, 42).addBox(-33.0F, -12.5F, -9.5F, 34.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4131F, 0.0034F, 0.0F, 0.0F, -0.0873F, -0.6109F));

		PartDefinition Body22 = RightArmSeg3.addOrReplaceChild("Body22", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.481F, -14.7584F, -4.3256F, 2.7489F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r26 = Body22.addOrReplaceChild("TorsoBase_r26", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -2.1988F, 3.3066F, 0.7795F, 0.461F, -0.0476F));

		PartDefinition Arm_r50 = Body22.addOrReplaceChild("Arm_r50", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.0611F, -0.2558F, -0.192F));

		PartDefinition Arm_r51 = Body22.addOrReplaceChild("Arm_r51", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.9253F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.3089F, 0.9815F, 0.0943F));

		PartDefinition TorsoBottom_r10 = Body22.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r23 = Body22.addOrReplaceChild("Head_r23", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.25F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition Body23 = RightArmSeg3.addOrReplaceChild("Body23", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.1787F, -7.7629F, 12.4295F, 1.5003F, -0.3931F, -0.3865F));

		PartDefinition Arm_r52 = Body23.addOrReplaceChild("Arm_r52", CubeListBuilder.create().texOffs(255, 326).addBox(-2.6989F, -1.3885F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, 2.1266F, -2.0948F, -0.1321F, 0.6937F, -0.6672F));

		PartDefinition Arm_r53 = Body23.addOrReplaceChild("Arm_r53", CubeListBuilder.create().texOffs(255, 326).addBox(-0.9834F, -1.2395F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, -0.0543F, -8.3035F, -2.845F, -0.717F, 2.6241F));

		PartDefinition TorsoTop_r26 = Body23.addOrReplaceChild("TorsoTop_r26", CubeListBuilder.create().texOffs(255, 326).addBox(-3.6473F, -2.7889F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, -4.8781F, -1.2293F, -0.4207F, 1.4447F, -1.2856F));

		PartDefinition TorsoTop_r27 = Body23.addOrReplaceChild("TorsoTop_r27", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, -2.6983F, 0.7538F, 0.7071F, 0.6554F, -0.1855F));

		PartDefinition TorsoBottom_r11 = Body23.addOrReplaceChild("TorsoBottom_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, 0.358F, 0.6554F, -0.1855F));

		PartDefinition Body24 = RightArmSeg3.addOrReplaceChild("Body24", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.7814F, -1.5827F, -9.2473F, 1.6602F, -0.2173F, -0.0193F));

		PartDefinition Leg_r30 = Body24.addOrReplaceChild("Leg_r30", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r24 = Body24.addOrReplaceChild("Head_r24", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r54 = Body24.addOrReplaceChild("Arm_r54", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r28 = Body24.addOrReplaceChild("TorsoTop_r28", CubeListBuilder.create().texOffs(255, 326).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition Body25 = RightArmSeg3.addOrReplaceChild("Body25", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.3754F, 9.3097F, 2.6929F, -2.5413F, 0.0082F, 0.2176F));

		PartDefinition TorsoBase_r27 = Body25.addOrReplaceChild("TorsoBase_r27", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r55 = Body25.addOrReplaceChild("Arm_r55", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r56 = Body25.addOrReplaceChild("Arm_r56", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r29 = Body25.addOrReplaceChild("TorsoTop_r29", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r25 = Body25.addOrReplaceChild("Head_r25", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition RightArmSeg4 = RightArmSeg3.addOrReplaceChild("RightArmSeg4", CubeListBuilder.create().texOffs(404, 145).addBox(-18.0F, -10.5F, -7.5F, 19.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.9791F, -0.0202F, -0.9794F, 0.0019F, -0.0436F, -0.0437F));

		PartDefinition RightHand = RightArmSeg4.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(40.7991F, -4.4407F, -1.7553F, -0.1309F, 0.0F, 0.0F));

		PartDefinition RightArmSeg_r1 = RightHand.addOrReplaceChild("RightArmSeg_r1", CubeListBuilder.create().texOffs(436, 54).addBox(-0.5F, -11.5F, -9.5F, 6.0F, 21.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-61.2991F, 3.4407F, 3.5053F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RightFinger1 = RightHand.addOrReplaceChild("RightFinger1", CubeListBuilder.create(), PartPose.offsetAndRotation(-58.6956F, 7.3648F, -5.1885F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Arm_r57 = RightFinger1.addOrReplaceChild("Arm_r57", CubeListBuilder.create().texOffs(437, 73).addBox(-1.5F, -2.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8882F, -3.5571F, -0.3321F, -0.5236F, -0.7854F, 0.0F));

		PartDefinition TopTorso_r7 = RightFinger1.addOrReplaceChild("TopTorso_r7", CubeListBuilder.create().texOffs(437, 73).addBox(-2.08F, -3.4914F, -4.6766F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2306F, -0.0855F, -0.5769F, 0.0F, -0.1309F, 0.0F));

		PartDefinition RightFingerHead1 = RightFinger1.addOrReplaceChild("RightFingerHead1", CubeListBuilder.create().texOffs(437, 73).addBox(-3.0F, -4.0F, -7.0F, 6.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3701F, 0.0794F, -5.0229F, 0.0F, 0.6109F, 0.0F));

		PartDefinition RightFinger2 = RightHand.addOrReplaceChild("RightFinger2", CubeListBuilder.create().texOffs(438, 76).addBox(-1.7741F, -4.0592F, -10.9355F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-58.4364F, -2.6986F, -3.4035F, -0.8309F, -0.0589F, 0.0644F));

		PartDefinition Arm_r58 = RightFinger2.addOrReplaceChild("Arm_r58", CubeListBuilder.create().texOffs(438, 76).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4617F, 3.7938F, -7.113F, 0.1603F, 0.2648F, -0.039F));

		PartDefinition Arm_r59 = RightFinger2.addOrReplaceChild("Arm_r59", CubeListBuilder.create().texOffs(438, 76).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, -8.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition Torso_r1 = RightFinger2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(438, 76).addBox(-2.08F, -3.5086F, -4.6766F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6352F, 0.0086F, -1.3926F, 0.0F, -0.1309F, 0.0F));

		PartDefinition RightFinger3 = RightHand.addOrReplaceChild("RightFinger3", CubeListBuilder.create(), PartPose.offsetAndRotation(-58.1666F, 6.859F, 11.1636F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Arm_r60 = RightFinger3.addOrReplaceChild("Arm_r60", CubeListBuilder.create().texOffs(439, 76).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.08F, -2.5551F, 2.5633F, 0.5965F, 0.5973F, -0.0566F));

		PartDefinition TopTorso_r8 = RightFinger3.addOrReplaceChild("TopTorso_r8", CubeListBuilder.create().texOffs(439, 76).addBox(-2.08F, -3.4914F, -1.3234F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3968F, -0.5818F, 0.943F, 0.0F, 0.1309F, 0.0F));

		PartDefinition RightFinger4 = RightHand.addOrReplaceChild("RightFinger4", CubeListBuilder.create(), PartPose.offsetAndRotation(-59.4774F, -5.2267F, 9.251F, 1.0942F, 0.3979F, 0.6439F));

		PartDefinition Arm_r61 = RightFinger4.addOrReplaceChild("Arm_r61", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0039F, -2.6746F, 2.1705F, 0.4014F, -0.5936F, -0.0288F));

		PartDefinition Arm_r62 = RightFinger4.addOrReplaceChild("Arm_r62", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5527F, -1.4174F, -0.8575F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2766F, 3.1988F, 2.2395F, -0.4478F, -0.2499F, -0.2361F));

		PartDefinition BottomTorso_r3 = RightFinger4.addOrReplaceChild("BottomTorso_r3", CubeListBuilder.create().texOffs(437, 75).addBox(-3.4246F, -3.7816F, -0.922F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.119F, 0.1903F, 1.3227F, 0.0617F, -0.3561F, -0.1119F));

		PartDefinition RightFingerHead4 = RightFinger4.addOrReplaceChild("RightFingerHead4", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5F, -4.0F, -0.25F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(437, 75).addBox(-2.5F, -4.0F, 4.75F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4019F, -1.0F, 3.884F, 0.0F, -1.0472F, 0.0F));

		PartDefinition Body26 = RightArmSeg4.addOrReplaceChild("Body26", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.2105F, -10.8969F, 7.3088F, -2.0944F, -0.829F, 1.5708F));

		PartDefinition TorsoBase_r28 = Body26.addOrReplaceChild("TorsoBase_r28", CubeListBuilder.create().texOffs(255, 326).addBox(-9.761F, -0.3912F, -3.9958F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(255, 326).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6977F, 0.1321F, -0.6429F));

		PartDefinition Jaw_r7 = Body26.addOrReplaceChild("Jaw_r7", CubeListBuilder.create().texOffs(255, 326).addBox(0.0412F, -4.0001F, -1.4988F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.15F, -0.3F, 1.4305F, -0.0998F, 0.3135F));

		PartDefinition Head_r26 = Body26.addOrReplaceChild("Head_r26", CubeListBuilder.create().texOffs(255, 326).addBox(0.0412F, -4.0001F, -0.4988F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.15F, -0.3F, 0.6014F, -0.0998F, 0.3135F));

		PartDefinition Body27 = RightArmSeg4.addOrReplaceChild("Body27", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0818F, -10.2854F, -6.6102F, 0.2978F, -0.8471F, -0.5335F));

		PartDefinition Arm_r63 = Body27.addOrReplaceChild("Arm_r63", CubeListBuilder.create().texOffs(255, 326).addBox(-7.0379F, -1.9918F, -0.722F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8245F, -2.6276F, 4.2411F, 0.4494F, 0.3479F, -0.6066F));

		PartDefinition TorsoBase_r29 = Body27.addOrReplaceChild("TorsoBase_r29", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0997F, 2.7397F, -0.652F, 0.761F, -0.0319F, -1.2425F));

		PartDefinition TorsoTop_r30 = Body27.addOrReplaceChild("TorsoTop_r30", CubeListBuilder.create().texOffs(255, 326).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6982F, -0.1364F, -0.8666F));

		PartDefinition LeftArmJoint = Arms.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create(), PartPose.offset(24.8564F, -52.2784F, -27.0467F));

		PartDefinition LeftArm = LeftArmJoint.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(93, 267).addBox(-5.0F, -10.5F, -10.5F, 31.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2616F, 0.9503F, 0.4756F));

		PartDefinition Body1 = LeftArm.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(9.4863F, -11.3822F, 1.9005F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Leg_r31 = Body1.addOrReplaceChild("Leg_r31", CubeListBuilder.create().texOffs(256, 326).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.5852F));

		PartDefinition Arm_r64 = Body1.addOrReplaceChild("Arm_r64", CubeListBuilder.create().texOffs(256, 326).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r65 = Body1.addOrReplaceChild("Arm_r65", CubeListBuilder.create().texOffs(256, 326).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r30 = Body1.addOrReplaceChild("TorsoBase_r30", CubeListBuilder.create().texOffs(256, 326).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r31 = Body1.addOrReplaceChild("TorsoTop_r31", CubeListBuilder.create().texOffs(256, 326).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(256, 326).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r8 = Body1.addOrReplaceChild("Jaw_r8", CubeListBuilder.create().texOffs(256, 326).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition Body2 = LeftArm.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(255, 326).addBox(-2.4218F, -0.7079F, -3.1266F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8154F, -0.2638F, 11.4233F, -1.0472F, 1.4835F, 0.0F));

		PartDefinition Leg_r32 = Body2.addOrReplaceChild("Leg_r32", CubeListBuilder.create().texOffs(255, 326).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5814F, 4.771F, -1.197F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r33 = Body2.addOrReplaceChild("Leg_r33", CubeListBuilder.create().texOffs(255, 326).addBox(0.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9505F, 4.9908F, 2.3734F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r66 = Body2.addOrReplaceChild("Arm_r66", CubeListBuilder.create().texOffs(255, 326).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8068F, -6.4923F, -2.9503F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r27 = Body2.addOrReplaceChild("Head_r27", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7451F, -8.6475F, 3.1328F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r32 = Body2.addOrReplaceChild("TorsoTop_r32", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4218F, -0.7079F, 0.6234F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Body3 = LeftArm.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0647F, 10.2217F, -2.4626F, 0.829F, 0.0F, 0.0F));

		PartDefinition Leg_r34 = Body3.addOrReplaceChild("Leg_r34", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r31 = Body3.addOrReplaceChild("TorsoBase_r31", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r67 = Body3.addOrReplaceChild("Arm_r67", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r68 = Body3.addOrReplaceChild("Arm_r68", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r12 = Body3.addOrReplaceChild("TorsoBottom_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r28 = Body3.addOrReplaceChild("Head_r28", CubeListBuilder.create().texOffs(255, 326).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition Body4 = LeftArm.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1895F, 3.3956F, -8.9835F, 1.7453F, 0.0F, 0.0F));

		PartDefinition Leg_r35 = Body4.addOrReplaceChild("Leg_r35", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r29 = Body4.addOrReplaceChild("Head_r29", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r69 = Body4.addOrReplaceChild("Arm_r69", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r33 = Body4.addOrReplaceChild("TorsoTop_r33", CubeListBuilder.create().texOffs(255, 326).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(320, 163).addBox(-1.0F, -8.5F, -9.5F, 33.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3267F, -0.4625F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Body5 = LeftArmSeg2.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(14.3803F, -9.8209F, -6.3205F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBase_r32 = Body5.addOrReplaceChild("TorsoBase_r32", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r34 = Body5.addOrReplaceChild("TorsoTop_r34", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r35 = Body5.addOrReplaceChild("TorsoTop_r35", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r30 = Body5.addOrReplaceChild("Head_r30", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body6 = LeftArmSeg2.addOrReplaceChild("Body6", CubeListBuilder.create(), PartPose.offset(15.8168F, 8.1616F, -8.3109F));

		PartDefinition Leg_r36 = Body6.addOrReplaceChild("Leg_r36", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8803F, -6.5243F, -1.2902F, -1.5761F, 0.989F, -0.4866F));

		PartDefinition TorsoBase_r33 = Body6.addOrReplaceChild("TorsoBase_r33", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4499F, -0.7882F, -0.449F, -1.4198F, 0.213F, 0.1614F));

		PartDefinition Arm_r70 = Body6.addOrReplaceChild("Arm_r70", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -1.1697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r71 = Body6.addOrReplaceChild("Arm_r71", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4172F, 4.1598F, 0.1325F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r13 = Body6.addOrReplaceChild("TorsoBottom_r13", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body7 = LeftArmSeg2.addOrReplaceChild("Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(17.2809F, 1.6118F, 9.4586F, -2.4165F, 0.4079F, 0.338F));

		PartDefinition TorsoBase_r34 = Body7.addOrReplaceChild("TorsoBase_r34", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r72 = Body7.addOrReplaceChild("Arm_r72", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r73 = Body7.addOrReplaceChild("Arm_r73", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r36 = Body7.addOrReplaceChild("TorsoTop_r36", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r31 = Body7.addOrReplaceChild("Head_r31", CubeListBuilder.create().texOffs(255, 326).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition LeftArmSeg3 = LeftArmSeg2.addOrReplaceChild("LeftArmSeg3", CubeListBuilder.create().texOffs(0, 345).addBox(-1.0F, -12.5F, -10.5F, 23.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.4131F, 0.0034F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition Body8 = LeftArmSeg3.addOrReplaceChild("Body8", CubeListBuilder.create(), PartPose.offset(12.7712F, -11.1648F, -10.5733F));

		PartDefinition Arm_r74 = Body8.addOrReplaceChild("Arm_r74", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 1.6609F, -0.5587F, -1.5066F));

		PartDefinition TorsoBase_r35 = Body8.addOrReplaceChild("TorsoBase_r35", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -0.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 1.5655F, 0.1556F, -0.0458F));

		PartDefinition TorsoTop_r37 = Body8.addOrReplaceChild("TorsoTop_r37", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r32 = Body8.addOrReplaceChild("Head_r32", CubeListBuilder.create().texOffs(255, 326).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition Body9 = LeftArmSeg3.addOrReplaceChild("Body9", CubeListBuilder.create(), PartPose.offset(9.4037F, 11.1582F, 7.4043F));

		PartDefinition Leg_r37 = Body9.addOrReplaceChild("Leg_r37", CubeListBuilder.create().texOffs(255, 326).addBox(-2.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2102F, -6.6181F, 3.1712F, -1.3444F, -1.2748F, 2.6415F));

		PartDefinition Leg_r38 = Body9.addOrReplaceChild("Leg_r38", CubeListBuilder.create().texOffs(255, 326).addBox(-2.664F, -3.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -4.5592F, 3.5018F, 1.4744F, -0.2937F, 1.281F));

		PartDefinition TorsoBase_r36 = Body9.addOrReplaceChild("TorsoBase_r36", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -3.7363F, 1.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r75 = Body9.addOrReplaceChild("Arm_r75", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r76 = Body9.addOrReplaceChild("Arm_r76", CubeListBuilder.create().texOffs(255, 326).addBox(1.0019F, -2.9253F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoBottom_r14 = Body9.addOrReplaceChild("TorsoBottom_r14", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r33 = Body9.addOrReplaceChild("Head_r33", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.25F, 0.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition LeftArmSeg4 = LeftArmSeg3.addOrReplaceChild("LeftArmSeg4", CubeListBuilder.create().texOffs(0, 279).addBox(-1.0F, -15.5F, -14.5F, 18.0F, 28.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -0.5F, 0.5F, -0.0019F, -0.0436F, 0.0437F));

		PartDefinition LeftArmSeg5 = LeftArmSeg4.addOrReplaceChild("LeftArmSeg5", CubeListBuilder.create().texOffs(168, 288).addBox(-1.0F, -18.5F, -14.25F, 13.0F, 31.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 1.0F, -2.0F));

		PartDefinition Body14 = LeftArmSeg5.addOrReplaceChild("Body14", CubeListBuilder.create(), PartPose.offset(4.4037F, -19.1832F, 12.9043F));

		PartDefinition Leg_r39 = Body14.addOrReplaceChild("Leg_r39", CubeListBuilder.create().texOffs(255, 326).addBox(-2.664F, -0.6064F, -2.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.8184F, 0.2977F, -0.3486F));

		PartDefinition TorsoBase_r37 = Body14.addOrReplaceChild("TorsoBase_r37", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -1.4073F, 0.16F, -0.0071F));

		PartDefinition Arm_r77 = Body14.addOrReplaceChild("Arm_r77", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r78 = Body14.addOrReplaceChild("Arm_r78", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3474F, 0.6507F, 0.0884F));

		PartDefinition TorsoTop_r38 = Body14.addOrReplaceChild("TorsoTop_r38", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r34 = Body14.addOrReplaceChild("Head_r34", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.75F, -2.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition Body15 = LeftArmSeg5.addOrReplaceChild("Body15", CubeListBuilder.create(), PartPose.offsetAndRotation(6.7844F, -18.1832F, -11.942F, 0.0F, 2.5307F, 0.0F));

		PartDefinition Leg_r40 = Body15.addOrReplaceChild("Leg_r40", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0379F, -0.9393F, -1.027F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3206F, 5.5473F, 3.1334F, -2.0798F, 0.492F, -0.7299F));

		PartDefinition TorsoBase_r38 = Body15.addOrReplaceChild("TorsoBase_r38", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r39 = Body15.addOrReplaceChild("TorsoTop_r39", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body16 = LeftArmSeg5.addOrReplaceChild("Body16", CubeListBuilder.create(), PartPose.offsetAndRotation(5.4037F, 8.0835F, -14.7591F, -1.5272F, 0.0F, 0.0F));

		PartDefinition Leg_r41 = Body16.addOrReplaceChild("Leg_r41", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7223F, -3.7805F, 4.6167F, 1.4972F, 0.6467F, -0.3166F));

		PartDefinition TorsoBase_r39 = Body16.addOrReplaceChild("TorsoBase_r39", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.435F, 0.0638F, 0.9725F, 0.8301F, 0.2351F, 0.1652F));

		PartDefinition Arm_r79 = Body16.addOrReplaceChild("Arm_r79", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -1.1697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.809F, 0.1479F, -0.9257F));

		PartDefinition Arm_r80 = Body16.addOrReplaceChild("Arm_r80", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r15 = Body16.addOrReplaceChild("TorsoBottom_r15", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Body17 = LeftArmSeg5.addOrReplaceChild("Body17", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3482F, 5.7928F, 14.6129F, -1.9014F, 0.9098F, 1.0058F));

		PartDefinition TorsoBase_r40 = Body17.addOrReplaceChild("TorsoBase_r40", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r40 = Body17.addOrReplaceChild("TorsoTop_r40", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r41 = Body17.addOrReplaceChild("TorsoTop_r41", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0282F, -0.0649F, -0.4222F));

		PartDefinition Head_r35 = Body17.addOrReplaceChild("Head_r35", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body10 = LeftArmSeg4.addOrReplaceChild("Body10", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0035F, -14.4841F, 6.6076F, 0.6037F, 0.0998F, -0.1434F));

		PartDefinition Leg_r42 = Body10.addOrReplaceChild("Leg_r42", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -5.0F, -2.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -1.1484F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r41 = Body10.addOrReplaceChild("TorsoBase_r41", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r81 = Body10.addOrReplaceChild("Arm_r81", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r82 = Body10.addOrReplaceChild("Arm_r82", CubeListBuilder.create().texOffs(255, 326).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.3921F, 0.7708F, -0.0005F));

		PartDefinition TorsoTop_r42 = Body10.addOrReplaceChild("TorsoTop_r42", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body11 = LeftArmSeg4.addOrReplaceChild("Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(10.4037F, -0.1193F, 13.7651F, -0.8727F, 0.0F, 0.0F));

		PartDefinition Leg_r43 = Body11.addOrReplaceChild("Leg_r43", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r42 = Body11.addOrReplaceChild("TorsoBase_r42", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r83 = Body11.addOrReplaceChild("Arm_r83", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r43 = Body11.addOrReplaceChild("TorsoTop_r43", CubeListBuilder.create().texOffs(255, 326).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition Body12 = LeftArmSeg4.addOrReplaceChild("Body12", CubeListBuilder.create(), PartPose.offset(1.2912F, 11.2153F, -5.9624F));

		PartDefinition TorsoBase_r43 = Body12.addOrReplaceChild("TorsoBase_r43", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.274F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r16 = Body12.addOrReplaceChild("TorsoBottom_r16", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r17 = Body12.addOrReplaceChild("TorsoBottom_r17", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r36 = Body12.addOrReplaceChild("Head_r36", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition Body13 = LeftArmSeg4.addOrReplaceChild("Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(9.5371F, -2.2403F, -15.5943F, -2.2253F, 0.0F, 0.0F));

		PartDefinition Leg_r44 = Body13.addOrReplaceChild("Leg_r44", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r44 = Body13.addOrReplaceChild("TorsoBase_r44", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7363F, 2.2954F, 0.9905F, 0.1921F, 0.1438F));

		PartDefinition Arm_r84 = Body13.addOrReplaceChild("Arm_r84", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r18 = Body13.addOrReplaceChild("TorsoBottom_r18", CubeListBuilder.create().texOffs(255, 326).addBox(-3.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition Tendril3 = LeftArmSeg4.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.4796F, -14.4088F, -6.9507F, 1.4689F, 0.4828F, 0.4724F));

		PartDefinition TendrilSeg_r3 = Tendril3.addOrReplaceChild("TendrilSeg_r3", CubeListBuilder.create().texOffs(4, 52).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 7.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r4 = Seg2Tendril3.addOrReplaceChild("TendrilSeg_r4", CubeListBuilder.create().texOffs(31, 51).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(11, 42).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition Tendril4 = LeftArmSeg4.addOrReplaceChild("Tendril4", CubeListBuilder.create(), PartPose.offsetAndRotation(6.4796F, 11.8838F, 6.0493F, -1.4689F, 0.4828F, -0.9088F));

		PartDefinition TendrilSeg_r5 = Tendril4.addOrReplaceChild("TendrilSeg_r5", CubeListBuilder.create().texOffs(1, 49).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(31, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0489F, 0.0111F, 7.2547F, 0.2725F, 0.6364F, 0.1646F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(6, 37).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.1409F, 0.0721F, 8.3902F, 0.3695F, -0.3272F, -0.1238F));

		PartDefinition Tendril1 = LeftArmSeg3.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -2.0F, -7.25F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 1.0F, -10.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(30, 51).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(5, 37).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril1 = Seg3Tendril1.addOrReplaceChild("Seg4Tendril1", CubeListBuilder.create().texOffs(19, 39).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril2 = LeftArmSeg3.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(11.9954F, -4.3157F, 8.2791F, 0.0F, 0.829F, -0.5672F));

		PartDefinition TendrilSeg_r6 = Tendril2.addOrReplaceChild("TendrilSeg_r6", CubeListBuilder.create().texOffs(1, 49).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(6, 37).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition FrontSeg2CorpseDetails = LeftArm.addOrReplaceChild("FrontSeg2CorpseDetails", CubeListBuilder.create(), PartPose.offset(-37.6064F, 29.0284F, -4.9533F));

		PartDefinition CannonClusters = Howi.addOrReplaceChild("CannonClusters", CubeListBuilder.create(), PartPose.offset(0.0F, -82.0F, 0.0F));

		PartDefinition Cluster1 = CannonClusters.addOrReplaceChild("Cluster1", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.5902F, 17.9314F, 20.9466F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition C1C1 = Cluster1.addOrReplaceChild("C1C1", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -1.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(74, 316).addBox(-9.0F, -27.5F, -9.0F, 18.0F, 26.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.838F, -2.4254F, -11.2635F, 0.1745F, -0.3491F, 0.0F));

		PartDefinition Top_r1 = C1C1.addOrReplaceChild("Top_r1", CubeListBuilder.create().texOffs(371, 95).addBox(-8.0F, -26.5F, -8.0F, 16.0F, 28.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition C1C1Top = C1C1.addOrReplaceChild("C1C1Top", CubeListBuilder.create(), PartPose.offsetAndRotation(8.7993F, -50.3615F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition West_r1 = C1C1Top.addOrReplaceChild("West_r1", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -6.1143F, -8.9683F, 16.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r1 = C1C1Top.addOrReplaceChild("East_r1", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -9.1143F, 6.9683F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r1 = C1C1Top.addOrReplaceChild("South_r1", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r1 = C1C1Top.addOrReplaceChild("North_r1", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth = C1C1Top.addOrReplaceChild("Teeth", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Teeth.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r2 = Teeth.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r3 = Teeth.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -9.0F, -6.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r4 = Teeth.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -12.0F, 5.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -12.0F, -6.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition CannonBody4 = C1C1.addOrReplaceChild("CannonBody4", CubeListBuilder.create().texOffs(367, 130).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5317F, -36.0502F, 4.3169F, 0.0F, 0.0F, -1.1345F));

		PartDefinition Leg_r45 = CannonBody4.addOrReplaceChild("Leg_r45", CubeListBuilder.create().texOffs(367, 130).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r37 = CannonBody4.addOrReplaceChild("Head_r37", CubeListBuilder.create().texOffs(367, 130).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r85 = CannonBody4.addOrReplaceChild("Arm_r85", CubeListBuilder.create().texOffs(367, 130).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r44 = CannonBody4.addOrReplaceChild("TorsoTop_r44", CubeListBuilder.create().texOffs(367, 130).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition CannonBody5 = C1C1.addOrReplaceChild("CannonBody5", CubeListBuilder.create(), PartPose.offsetAndRotation(9.9327F, -34.3132F, 3.7035F, 0.0F, 0.0F, 1.2217F));

		PartDefinition TorsoBase_r45 = CannonBody5.addOrReplaceChild("TorsoBase_r45", CubeListBuilder.create().texOffs(371, 129).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6797F, 3.274F, -1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r45 = CannonBody5.addOrReplaceChild("TorsoTop_r45", CubeListBuilder.create().texOffs(371, 129).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0048F, -1.187F, 1.0061F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r46 = CannonBody5.addOrReplaceChild("TorsoTop_r46", CubeListBuilder.create().texOffs(371, 129).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(371, 129).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2039F, -3.3286F, -2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition C1C2 = Cluster1.addOrReplaceChild("C1C2", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -2.8179F, -12.0283F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(74, 316).addBox(-9.0F, -21.8179F, -9.0283F, 18.0F, 19.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.162F, 0.5746F, 3.7365F, 0.0F, 2.0508F, 0.0F));

		PartDefinition Top_r2 = C1C2.addOrReplaceChild("Top_r2", CubeListBuilder.create().texOffs(371, 95).addBox(-8.0F, -18.0F, -8.0F, 16.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.8179F, -0.0283F, 0.6109F, 0.0F, 0.0F));

		PartDefinition C1C2Top = C1C2.addOrReplaceChild("C1C2Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -36.3962F, -10.1454F, 0.6109F, 0.0F, 0.0F));

		PartDefinition West_r2 = C1C2Top.addOrReplaceChild("West_r2", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -6.1143F, -8.9683F, 16.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r2 = C1C2Top.addOrReplaceChild("East_r2", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -9.1143F, 6.9683F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r2 = C1C2Top.addOrReplaceChild("South_r2", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r2 = C1C2Top.addOrReplaceChild("North_r2", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth2 = C1C2Top.addOrReplaceChild("Teeth2", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r5 = Teeth2.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r6 = Teeth2.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r7 = Teeth2.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -9.0F, -6.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r8 = Teeth2.addOrReplaceChild("Teeth_r8", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -12.0F, 5.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -12.0F, -6.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition CannonBady2 = C1C2.addOrReplaceChild("CannonBady2", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8155F, -24.473F, 5.7286F, -0.1449F, -0.2709F, -1.7F));

		PartDefinition TorsoBase_r46 = CannonBady2.addOrReplaceChild("TorsoBase_r46", CubeListBuilder.create().texOffs(367, 129).addBox(-3.0F, -2.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -2.1988F, 3.3066F, 1.3904F, 0.461F, -0.0476F));

		PartDefinition Arm_r86 = CannonBady2.addOrReplaceChild("Arm_r86", CubeListBuilder.create().texOffs(367, 129).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 0.5812F, -0.2558F, -0.192F));

		PartDefinition Arm_r87 = CannonBady2.addOrReplaceChild("Arm_r87", CubeListBuilder.create().texOffs(367, 129).addBox(0.0019F, -1.9253F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.3089F, 0.9815F, 0.0943F));

		PartDefinition TorsoBottom_r19 = CannonBady2.addOrReplaceChild("TorsoBottom_r19", CubeListBuilder.create().texOffs(367, 129).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r38 = CannonBady2.addOrReplaceChild("Head_r38", CubeListBuilder.create().texOffs(367, 129).addBox(-3.5F, -3.25F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition C1C3 = Cluster1.addOrReplaceChild("C1C3", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -2.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(82, 320).addBox(-7.0F, -21.5F, -7.0F, 14.0F, 19.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.8481F, 0.0427F, 6.4569F, 0.0F, -1.2217F, 0.3927F));

		PartDefinition Top_r3 = C1C3.addOrReplaceChild("Top_r3", CubeListBuilder.create().texOffs(0, 131).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -21.5F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition C1C3Top = C1C3.addOrReplaceChild("C1C3Top", CubeListBuilder.create(), PartPose.offsetAndRotation(9.835F, -36.7915F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition West_r3 = C1C3Top.addOrReplaceChild("West_r3", CubeListBuilder.create().texOffs(16, 0).addBox(-6.486F, -4.0743F, -8.1922F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r3 = C1C3Top.addOrReplaceChild("East_r3", CubeListBuilder.create().texOffs(16, 0).addBox(-5.9114F, -7.2091F, 5.801F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r3 = C1C3Top.addOrReplaceChild("South_r3", CubeListBuilder.create().texOffs(16, 0).addBox(-5.6405F, -5.2632F, -2.3617F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r3 = C1C3Top.addOrReplaceChild("North_r3", CubeListBuilder.create().texOffs(16, 0).addBox(-6.1313F, -4.8315F, -0.4703F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth3 = C1C3Top.addOrReplaceChild("Teeth3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r9 = Teeth3.addOrReplaceChild("Teeth_r9", CubeListBuilder.create().texOffs(22, 279).addBox(-4.4703F, -8.8315F, 3.1313F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-4.4703F, -8.8315F, -3.8687F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r10 = Teeth3.addOrReplaceChild("Teeth_r10", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, -4.3595F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, 3.6405F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r11 = Teeth3.addOrReplaceChild("Teeth_r11", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, -6.486F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, 0.514F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r12 = Teeth3.addOrReplaceChild("Teeth_r12", CubeListBuilder.create().texOffs(22, 279).addBox(-3.8327F, -10.0949F, 5.0886F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-3.8327F, -10.0949F, -1.9114F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Cluster2 = CannonClusters.addOrReplaceChild("Cluster2", CubeListBuilder.create(), PartPose.offsetAndRotation(22.5416F, 11.3301F, 14.5908F, -0.0761F, 0.7736F, 0.3473F));

		PartDefinition C2C1 = Cluster2.addOrReplaceChild("C2C1", CubeListBuilder.create().texOffs(252, 288).addBox(-12.0F, -1.5F, -14.0F, 26.0F, 10.0F, 26.0F, new CubeDeformation(0.0F))
		.texOffs(70, 314).addBox(-9.0F, -32.5F, -11.0F, 20.0F, 31.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9151F, 0.5291F, -10.0679F, 0.0F, -0.7317F, 0.0F));

		PartDefinition Top_r4 = C2C1.addOrReplaceChild("Top_r4", CubeListBuilder.create().texOffs(367, 93).addBox(-9.0F, -30.0F, -9.0F, 18.0F, 34.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -32.5F, -1.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition C2C1Top = C2C1.addOrReplaceChild("C2C1Top", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7389F, -60.0195F, 0.0F, 0.0F, 0.0F, -0.3491F));

		PartDefinition West_r4 = C2C1Top.addOrReplaceChild("West_r4", CubeListBuilder.create().texOffs(356, 310).addBox(-10.0F, -7.1143F, -9.9683F, 18.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.05F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r4 = C2C1Top.addOrReplaceChild("East_r4", CubeListBuilder.create().texOffs(356, 310).addBox(-10.0F, -11.1143F, 7.9683F, 18.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.05F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r4 = C2C1Top.addOrReplaceChild("South_r4", CubeListBuilder.create().texOffs(356, 310).addBox(-9.0F, -10.0F, -1.0F, 18.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r4 = C2C1Top.addOrReplaceChild("North_r4", CubeListBuilder.create().texOffs(356, 310).addBox(-9.0F, -9.0F, -3.0F, 18.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth4 = C2C1Top.addOrReplaceChild("Teeth4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r13 = Teeth4.addOrReplaceChild("Teeth_r13", CubeListBuilder.create().texOffs(22, 280).addBox(-1.0F, -3.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -3.4876F, -10.239F, 1.8326F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r14 = Teeth4.addOrReplaceChild("Teeth_r14", CubeListBuilder.create().texOffs(22, 281).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -2.6943F, -9.6302F, 1.4399F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r15 = Teeth4.addOrReplaceChild("Teeth_r15", CubeListBuilder.create().texOffs(22, 279).addBox(-1.0F, -5.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -3.9118F, 8.0435F, -1.1954F, 0.8779F, -1.37F));

		PartDefinition Teeth_r16 = Teeth4.addOrReplaceChild("Teeth_r16", CubeListBuilder.create().texOffs(22, 279).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.8264F, -4.6931F, 8.643F, -1.9053F, 0.8832F, -1.7747F));

		PartDefinition Teeth_r17 = Teeth4.addOrReplaceChild("Teeth_r17", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(-1.0F, -3.5F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.9237F, -2.113F, -4.0F, 0.1745F, 0.0F, 0.6545F));

		PartDefinition Teeth_r18 = Teeth4.addOrReplaceChild("Teeth_r18", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(-1.0F, -3.5F, 0.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.7254F, -2.2652F, 4.0F, -0.1309F, 0.0F, 0.6545F));

		PartDefinition Teeth_r19 = Teeth4.addOrReplaceChild("Teeth_r19", CubeListBuilder.create().texOffs(22, 279).addBox(-2.0F, -5.5F, 0.0F, 2.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3479F, -4.3085F, 5.0F, 0.1745F, 0.0F, -0.6545F));

		PartDefinition Teeth_r20 = Teeth4.addOrReplaceChild("Teeth_r20", CubeListBuilder.create().texOffs(22, 279).addBox(-1.0F, -4.0F, 0.0F, 2.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.4456F, -4.0964F, -7.0F, 2.9671F, 0.0F, -0.6545F));

		PartDefinition CannonBody1 = C2C1.addOrReplaceChild("CannonBody1", CubeListBuilder.create().texOffs(377, 130).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4564F, -38.8707F, 1.4772F, 0.0F, 0.0F, -1.5272F));

		PartDefinition Leg_r46 = CannonBody1.addOrReplaceChild("Leg_r46", CubeListBuilder.create().texOffs(377, 130).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r39 = CannonBody1.addOrReplaceChild("Head_r39", CubeListBuilder.create().texOffs(377, 130).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r88 = CannonBody1.addOrReplaceChild("Arm_r88", CubeListBuilder.create().texOffs(377, 130).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r47 = CannonBody1.addOrReplaceChild("TorsoTop_r47", CubeListBuilder.create().texOffs(377, 130).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition CannonBody2 = C2C1.addOrReplaceChild("CannonBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(7.3735F, -53.1092F, -1.5228F, 0.0F, 0.0F, 0.6981F));

		PartDefinition TorsoBase_r47 = CannonBody2.addOrReplaceChild("TorsoBase_r47", CubeListBuilder.create().texOffs(371, 128).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8836F, 8.6026F, 3.8552F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r48 = CannonBody2.addOrReplaceChild("TorsoTop_r48", CubeListBuilder.create().texOffs(371, 128).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1991F, 4.1416F, 6.3927F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r49 = CannonBody2.addOrReplaceChild("TorsoTop_r49", CubeListBuilder.create().texOffs(371, 128).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(371, 128).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition CannonBody7 = C2C1.addOrReplaceChild("CannonBody7", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3735F, -22.2799F, -11.1652F, 1.8978F, 0.0947F, 2.4905F));

		PartDefinition Arm_r89 = CannonBody7.addOrReplaceChild("Arm_r89", CubeListBuilder.create().texOffs(368, 129).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.6609F, -0.5587F, 1.5066F));

		PartDefinition TorsoBase_r48 = CannonBody7.addOrReplaceChild("TorsoBase_r48", CubeListBuilder.create().texOffs(368, 129).addBox(-3.5F, -2.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.4741F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r50 = CannonBody7.addOrReplaceChild("TorsoTop_r50", CubeListBuilder.create().texOffs(368, 129).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r40 = CannonBody7.addOrReplaceChild("Head_r40", CubeListBuilder.create().texOffs(368, 129).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition C2C2 = Cluster2.addOrReplaceChild("C2C2", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -9.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(74, 316).addBox(-9.0F, -28.5F, -9.0F, 18.0F, 19.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.838F, 0.5746F, 8.7365F, 0.0F, -1.4835F, 0.0F));

		PartDefinition Top_r5 = C2C2.addOrReplaceChild("Top_r5", CubeListBuilder.create().texOffs(372, 95).addBox(-8.0F, -18.0F, -8.0F, 16.0F, 22.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.5F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition CannonBody3 = C2C2.addOrReplaceChild("CannonBody3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.6204F, -36.4941F, 8.8506F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Leg_r47 = CannonBody3.addOrReplaceChild("Leg_r47", CubeListBuilder.create().texOffs(367, 132).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r49 = CannonBody3.addOrReplaceChild("TorsoBase_r49", CubeListBuilder.create().texOffs(367, 132).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r90 = CannonBody3.addOrReplaceChild("Arm_r90", CubeListBuilder.create().texOffs(367, 132).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r51 = CannonBody3.addOrReplaceChild("TorsoTop_r51", CubeListBuilder.create().texOffs(367, 132).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition C2C2Top = C2C2.addOrReplaceChild("C2C2Top", CubeListBuilder.create(), PartPose.offsetAndRotation(7.6733F, -43.9148F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition West_r5 = C2C2Top.addOrReplaceChild("West_r5", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -6.1143F, -8.9683F, 16.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r5 = C2C2Top.addOrReplaceChild("East_r5", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -9.1143F, 6.9683F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r5 = C2C2Top.addOrReplaceChild("South_r5", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r5 = C2C2Top.addOrReplaceChild("North_r5", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth5 = C2C2Top.addOrReplaceChild("Teeth5", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r21 = Teeth5.addOrReplaceChild("Teeth_r21", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r22 = Teeth5.addOrReplaceChild("Teeth_r22", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r23 = Teeth5.addOrReplaceChild("Teeth_r23", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -9.0F, -6.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r24 = Teeth5.addOrReplaceChild("Teeth_r24", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -12.0F, 5.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -12.0F, -6.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition C2C3 = Cluster2.addOrReplaceChild("C2C3", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -0.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(82, 320).addBox(-7.0F, -19.5F, -7.0F, 14.0F, 19.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.8309F, -2.4715F, -3.5541F, 0.0F, 1.2654F, 0.0F));

		PartDefinition Top_r6 = C2C3.addOrReplaceChild("Top_r6", CubeListBuilder.create().texOffs(0, 131).addBox(-6.0F, -18.0F, -6.0F, 12.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -19.5F, 0.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition C2C3Top = C2C3.addOrReplaceChild("C2C3Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -34.466F, 12.1674F, -0.6545F, 0.0F, 0.0F));

		PartDefinition West_r6 = C2C3Top.addOrReplaceChild("West_r6", CubeListBuilder.create().texOffs(16, 0).addBox(-6.486F, -4.0743F, -8.1922F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r6 = C2C3Top.addOrReplaceChild("East_r6", CubeListBuilder.create().texOffs(16, 0).addBox(-5.9114F, -7.2091F, 5.801F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r6 = C2C3Top.addOrReplaceChild("South_r6", CubeListBuilder.create().texOffs(16, 0).addBox(-5.6405F, -5.2632F, -2.3617F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r6 = C2C3Top.addOrReplaceChild("North_r6", CubeListBuilder.create().texOffs(16, 0).addBox(-6.1313F, -4.8315F, -0.4703F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth6 = C2C3Top.addOrReplaceChild("Teeth6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r25 = Teeth6.addOrReplaceChild("Teeth_r25", CubeListBuilder.create().texOffs(22, 279).addBox(-4.4703F, -8.8315F, 3.1313F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-4.4703F, -8.8315F, -3.8687F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r26 = Teeth6.addOrReplaceChild("Teeth_r26", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, -4.3595F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, 3.6405F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r27 = Teeth6.addOrReplaceChild("Teeth_r27", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, -6.486F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, 0.514F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r28 = Teeth6.addOrReplaceChild("Teeth_r28", CubeListBuilder.create().texOffs(22, 279).addBox(-3.8327F, -10.0949F, 5.0886F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-3.8327F, -10.0949F, -1.9114F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition Cluster3 = CannonClusters.addOrReplaceChild("Cluster3", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.8486F, 22.1205F, -18.5623F, 2.4402F, 1.2755F, 2.3687F));

		PartDefinition C3C1 = Cluster3.addOrReplaceChild("C3C1", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -1.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(74, 316).addBox(-9.0F, -27.5F, -9.0F, 18.0F, 26.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.838F, -2.4254F, -11.2635F, -0.0988F, -0.3591F, -0.0924F));

		PartDefinition Top_r7 = C3C1.addOrReplaceChild("Top_r7", CubeListBuilder.create().texOffs(371, 95).addBox(-8.0F, -24.5F, -8.0F, 16.0F, 25.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -28.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition C3C1Top = C3C1.addOrReplaceChild("C3C1Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -51.8483F, -6.2959F, 0.2618F, 0.0F, 0.0F));

		PartDefinition West_r7 = C3C1Top.addOrReplaceChild("West_r7", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -6.1143F, -8.9683F, 16.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r7 = C3C1Top.addOrReplaceChild("East_r7", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -9.1143F, 6.9683F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r7 = C3C1Top.addOrReplaceChild("South_r7", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r7 = C3C1Top.addOrReplaceChild("North_r7", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth7 = C3C1Top.addOrReplaceChild("Teeth7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r29 = Teeth7.addOrReplaceChild("Teeth_r29", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r30 = Teeth7.addOrReplaceChild("Teeth_r30", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r31 = Teeth7.addOrReplaceChild("Teeth_r31", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(3.0F, -9.0F, -6.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(3.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r32 = Teeth7.addOrReplaceChild("Teeth_r32", CubeListBuilder.create().texOffs(22, 279).addBox(-5.0F, -12.0F, 5.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-5.0F, -12.0F, -6.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition ThisIsSporeSlasher = C3C1Top.addOrReplaceChild("ThisIsSporeSlasher", CubeListBuilder.create().texOffs(551, 461).addBox(-2.5F, -1.0F, -3.5F, 5.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r91 = ThisIsSporeSlasher.addOrReplaceChild("Arm_r91", CubeListBuilder.create().texOffs(392, 214).addBox(-1.0F, -2.0F, -3.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0386F, -2.7272F, -4.2811F, 0.0F, 0.4363F, -0.6109F));

		PartDefinition Arm_r92 = ThisIsSporeSlasher.addOrReplaceChild("Arm_r92", CubeListBuilder.create().texOffs(366, 374).addBox(-1.0F, -2.0F, 0.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.0F, 4.0F, 0.0F, -0.4363F, -0.6109F));

		PartDefinition Jaw_r9 = ThisIsSporeSlasher.addOrReplaceChild("Jaw_r9", CubeListBuilder.create().texOffs(484, 188).addBox(0.0F, 0.5F, -6.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, 2.0F, 0.1713F, -0.0552F, 0.1188F));

		PartDefinition Head_r41 = ThisIsSporeSlasher.addOrReplaceChild("Head_r41", CubeListBuilder.create().texOffs(476, 197).addBox(0.0F, -6.5F, -6.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.5F, 2.0F, 0.4185F, 0.1274F, -0.2783F));

		PartDefinition UpperTorso_r1 = ThisIsSporeSlasher.addOrReplaceChild("UpperTorso_r1", CubeListBuilder.create().texOffs(495, 104).addBox(-3.0F, -6.0F, -4.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition CannonBody6 = C3C1.addOrReplaceChild("CannonBody6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.3488F, -32.568F, -11.049F, 1.8626F, 0.4136F, 1.8118F));

		PartDefinition TorsoBase_r50 = CannonBody6.addOrReplaceChild("TorsoBase_r50", CubeListBuilder.create().texOffs(367, 129).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8836F, 8.6026F, 3.8552F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoTop_r52 = CannonBody6.addOrReplaceChild("TorsoTop_r52", CubeListBuilder.create().texOffs(367, 129).addBox(-0.1415F, -2.3037F, 1.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1991F, 4.1416F, 6.3927F, -0.0148F, -0.4858F, 1.3101F));

		PartDefinition TorsoTop_r53 = CannonBody6.addOrReplaceChild("TorsoTop_r53", CubeListBuilder.create().texOffs(367, 129).addBox(4.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(367, 129).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.0F, 3.0F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition C3C2 = Cluster3.addOrReplaceChild("C3C2", CubeListBuilder.create().texOffs(256, 289).addBox(-12.0F, -3.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(74, 316).addBox(-9.0F, -22.5F, -9.0F, 18.0F, 19.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.6687F, 0.3489F, -1.2536F, 0.0F, -0.9079F, 0.637F));

		PartDefinition Top_r8 = C3C2.addOrReplaceChild("Top_r8", CubeListBuilder.create().texOffs(371, 95).addBox(-8.0F, -18.0F, -8.0F, 16.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -22.5F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition C3C2Top = C3C2.addOrReplaceChild("C3C2Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -38.0698F, 8.1712F, -0.48F, 0.0F, 0.0F));

		PartDefinition West_r8 = C3C2Top.addOrReplaceChild("West_r8", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -6.1143F, -8.9683F, 16.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r8 = C3C2Top.addOrReplaceChild("East_r8", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -9.1143F, 6.9683F, 16.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r8 = C3C2Top.addOrReplaceChild("South_r8", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r8 = C3C2Top.addOrReplaceChild("North_r8", CubeListBuilder.create().texOffs(356, 310).addBox(-8.0F, -7.0F, -1.0F, 16.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth8 = C3C2Top.addOrReplaceChild("Teeth8", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r33 = Teeth8.addOrReplaceChild("Teeth_r33", CubeListBuilder.create().texOffs(22, 280).addBox(-5.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 280).addBox(-5.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r34 = Teeth8.addOrReplaceChild("Teeth_r34", CubeListBuilder.create().texOffs(22, 280).mirror().addBox(3.0F, -11.0F, -6.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 280).mirror().addBox(3.0F, -11.0F, 5.0F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r35 = Teeth8.addOrReplaceChild("Teeth_r35", CubeListBuilder.create().texOffs(22, 280).mirror().addBox(3.0F, -9.0F, -6.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 280).mirror().addBox(3.0F, -9.0F, 5.0F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r36 = Teeth8.addOrReplaceChild("Teeth_r36", CubeListBuilder.create().texOffs(22, 280).addBox(-5.0F, -12.0F, 5.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 280).addBox(-5.0F, -12.0F, -6.0F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition CannonBody8 = C3C2.addOrReplaceChild("CannonBody8", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4991F, -31.1825F, -5.8739F, 1.5741F, 0.3118F, 0.6301F));

		PartDefinition Leg_r48 = CannonBody8.addOrReplaceChild("Leg_r48", CubeListBuilder.create().texOffs(385, 130).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2102F, 5.6181F, 4.1712F, -1.3908F, -1.3646F, -0.2071F));

		PartDefinition Leg_r49 = CannonBody8.addOrReplaceChild("Leg_r49", CubeListBuilder.create().texOffs(385, 130).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.6884F, 5.0875F, 1.3405F, -2.4208F, -0.1972F, -0.0649F));

		PartDefinition TorsoBase_r51 = CannonBody8.addOrReplaceChild("TorsoBase_r51", CubeListBuilder.create().texOffs(385, 130).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r93 = CannonBody8.addOrReplaceChild("Arm_r93", CubeListBuilder.create().texOffs(385, 130).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r94 = CannonBody8.addOrReplaceChild("Arm_r94", CubeListBuilder.create().texOffs(385, 130).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r54 = CannonBody8.addOrReplaceChild("TorsoTop_r54", CubeListBuilder.create().texOffs(385, 130).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r42 = CannonBody8.addOrReplaceChild("Head_r42", CubeListBuilder.create().texOffs(385, 130).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition C3C3 = Cluster3.addOrReplaceChild("C3C3", CubeListBuilder.create().texOffs(256, 290).addBox(-12.0F, -6.5F, -12.0F, 24.0F, 10.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(82, 320).addBox(-7.0F, -25.5F, -7.0F, 14.0F, 19.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.468F, -3.995F, 3.1119F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Top_r9 = C3C3.addOrReplaceChild("Top_r9", CubeListBuilder.create().texOffs(0, 131).addBox(-6.0F, -19.0F, -6.0F, 12.0F, 21.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -24.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition C3C3Top = C3C3.addOrReplaceChild("C3C3Top", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -42.6267F, 8.9715F, -0.4363F, 0.0F, 0.0F));

		PartDefinition West_r9 = C3C3Top.addOrReplaceChild("West_r9", CubeListBuilder.create().texOffs(16, 0).addBox(-6.486F, -4.0743F, -8.1922F, 12.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, 0.6545F));

		PartDefinition East_r9 = C3C3Top.addOrReplaceChild("East_r9", CubeListBuilder.create().texOffs(16, 0).addBox(-5.9114F, -7.2091F, 5.801F, 12.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9668F, 0.0F, 0.0F, -1.5708F, -0.6545F));

		PartDefinition South_r9 = C3C3Top.addOrReplaceChild("South_r9", CubeListBuilder.create().texOffs(16, 0).addBox(-5.6405F, -5.2632F, -2.3617F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition North_r9 = C3C3Top.addOrReplaceChild("North_r9", CubeListBuilder.create().texOffs(16, 0).addBox(-6.1313F, -4.8315F, -0.4703F, 12.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Teeth9 = C3C3Top.addOrReplaceChild("Teeth9", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Teeth_r37 = Teeth9.addOrReplaceChild("Teeth_r37", CubeListBuilder.create().texOffs(22, 279).addBox(-4.4703F, -8.8315F, 3.1313F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-4.4703F, -8.8315F, -3.8687F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.5708F, -0.9163F, -1.5708F));

		PartDefinition Teeth_r38 = Teeth9.addOrReplaceChild("Teeth_r38", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, -4.3595F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(1.6383F, -9.2632F, 3.6405F, 2.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, -0.9163F, 1.5708F));

		PartDefinition Teeth_r39 = Teeth9.addOrReplaceChild("Teeth_r39", CubeListBuilder.create().texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, -6.486F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(22, 279).mirror().addBox(2.2239F, -6.96F, 0.514F, 2.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Teeth_r40 = Teeth9.addOrReplaceChild("Teeth_r40", CubeListBuilder.create().texOffs(22, 279).addBox(-3.8327F, -10.0949F, 5.0886F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(22, 279).addBox(-3.8327F, -10.0949F, -1.9114F, 2.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -0.6545F));

		PartDefinition FailedCannon = CannonClusters.addOrReplaceChild("FailedCannon", CubeListBuilder.create().texOffs(264, 294).addBox(-10.0F, -0.75F, -10.0F, 20.0F, 6.0F, 20.0F, new CubeDeformation(0.0F))
		.texOffs(82, 320).addBox(-7.0F, -23.75F, -7.0F, 14.0F, 23.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(367, 126).addBox(-6.0F, -32.75F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.7701F, 5.1092F, 31.5228F, -0.5804F, 0.0F, 0.3288F));

		PartDefinition FailedCannonFlower = FailedCannon.addOrReplaceChild("FailedCannonFlower", CubeListBuilder.create().texOffs(6, 133).addBox(1.0F, -3.5F, -4.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6265F, -29.1357F, 0.6361F, 0.2502F, 0.0779F, -0.2956F));

		PartDefinition TumorBase = FailedCannonFlower.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(5.0F, -1.0F, 0.0F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(3, 16).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.5F, -0.5F, -4.5F, 0.189F, 0.3463F, 0.5131F));

		PartDefinition Tumor_r2 = TumorBase.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(2, 15).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, -5.0F, -0.5113F, 0.2171F, -0.5714F));

		PartDefinition Tumor_r3 = TumorBase.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(4, 15).addBox(-0.5F, -1.5F, -4.5F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -0.5F, -2.5F, -0.4363F, -0.5672F, 0.0F));

		PartDefinition Tumor_r4 = TumorBase.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(2, 14).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5F, 3.5F, 2.5F, -0.6545F, 0.3491F, 0.0F));

		PartDefinition Tumor_r5 = TumorBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(0, 13).addBox(-4.0F, -1.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, 5.0F, -0.5236F, 0.0F, -0.3927F));

		PartDefinition SouthTendril = TumorBase.addOrReplaceChild("SouthTendril", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -0.5F, 2.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition STendieSeg1_r1 = SouthTendril.addOrReplaceChild("STendieSeg1_r1", CubeListBuilder.create().texOffs(4, 53).addBox(-1.5F, -3.0F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.1745F, 0.0F));

		PartDefinition STendieSeg2 = SouthTendril.addOrReplaceChild("STendieSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.2594F, -2.1799F, 5.7941F, -1.0472F, 0.0F, 0.0F));

		PartDefinition STendieSeg2_r1 = STendieSeg2.addOrReplaceChild("STendieSeg2_r1", CubeListBuilder.create().texOffs(4, 53).addBox(-1.0F, -1.0F, -4.5F, 2.0F, 2.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition WestTendril = TumorBase.addOrReplaceChild("WestTendril", CubeListBuilder.create().texOffs(19, 171).addBox(-1.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5F, -2.0F, 2.0F, -0.0479F, -0.2129F, 0.0488F));

		PartDefinition WTendieSeg2 = WestTendril.addOrReplaceChild("WTendieSeg2", CubeListBuilder.create().texOffs(24, 173).addBox(-0.05F, -0.5F, -1.5F, 5.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -0.5F, 0.5F, 0.0F, 0.0F, 1.0036F));

		PartDefinition EastTendril = TumorBase.addOrReplaceChild("EastTendril", CubeListBuilder.create().texOffs(19, 171).addBox(-7.0F, -2.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -0.5F, -0.5F, 0.0097F, 0.218F, 0.0447F));

		PartDefinition ETendieSeg2 = EastTendril.addOrReplaceChild("ETendieSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition ETendieSeg2_r1 = ETendieSeg2.addOrReplaceChild("ETendieSeg2_r1", CubeListBuilder.create().texOffs(19, 171).addBox(-4.75F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition FlowerMaw = FailedCannonFlower.addOrReplaceChild("FlowerMaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition SouthMaw = FlowerMaw.addOrReplaceChild("SouthMaw", CubeListBuilder.create().texOffs(66, 33).addBox(-5.0F, -5.8061F, -0.7458F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -3.25F, 3.5F, -0.8262F, -0.1527F, 0.0374F));

		PartDefinition Tooth_r1 = SouthMaw.addOrReplaceChild("Tooth_r1", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -3.5F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4226F, -1.5F, -1.4063F, 3.1416F, -0.4363F, 0.0F));

		PartDefinition Tooth_r2 = SouthMaw.addOrReplaceChild("Tooth_r2", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4226F, -3.0F, -1.4063F, 3.1416F, 0.4363F, 0.0F));

		PartDefinition SMawSeg2 = SouthMaw.addOrReplaceChild("SMawSeg2", CubeListBuilder.create().texOffs(66, 33).addBox(-5.0F, -5.0736F, 0.8192F, 9.0F, 7.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -7.4256F, -0.7373F, -0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r3 = SMawSeg2.addOrReplaceChild("Tooth_r3", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8199F, -1.6259F, 0.3821F, 3.1416F, -0.3054F, -0.1309F));

		PartDefinition Tooth_r4 = SMawSeg2.addOrReplaceChild("Tooth_r4", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -3.0F, -1.0F, 0.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2981F, -2.0392F, 0.2963F, 3.1416F, 0.3054F, 0.1309F));

		PartDefinition SMawSeg3 = SMawSeg2.addOrReplaceChild("SMawSeg3", CubeListBuilder.create().texOffs(66, 33).addBox(-4.5F, -4.5F, -1.0F, 8.0F, 5.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.5F, -4.5736F, 1.8192F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r5 = SMawSeg3.addOrReplaceChild("Tooth_r5", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -1.5F, -1.0F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.25F, -0.75F, 3.1416F, -0.3491F, -0.2182F));

		PartDefinition Tooth_r6 = SMawSeg3.addOrReplaceChild("Tooth_r6", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -1.5F, -0.75F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.25F, -0.75F, 3.1416F, -0.2182F, 0.2182F));

		PartDefinition NWMaw = FlowerMaw.addOrReplaceChild("NWMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, -4.0F, -2.0F, 0.6109F, -0.9163F, 0.0F));

		PartDefinition Tooth_r7 = NWMaw.addOrReplaceChild("Tooth_r7", CubeListBuilder.create().texOffs(397, 33).addBox(-1.0F, -6.0F, -1.0F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -1.0F, 2.0F, 0.0F, 0.0F, -0.48F));

		PartDefinition NWMawSeg1_r1 = NWMaw.addOrReplaceChild("NWMawSeg1_r1", CubeListBuilder.create().texOffs(66, 33).addBox(-5.0F, -3.5F, -1.0F, 10.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NWMawSeg2 = NWMaw.addOrReplaceChild("NWMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Tooth_r8 = NWMawSeg2.addOrReplaceChild("Tooth_r8", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -2.0F, 0.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7208F, -2.8231F, 0.794F, 0.0F, -0.1745F, 0.3927F));

		PartDefinition Tooth_r9 = NWMawSeg2.addOrReplaceChild("Tooth_r9", CubeListBuilder.create().texOffs(397, 33).addBox(-1.0F, -2.5F, -1.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2792F, -3.3231F, 1.794F, 0.0535F, -0.2825F, -0.8119F));

		PartDefinition NWMawSeg2_r1 = NWMawSeg2.addOrReplaceChild("NWMawSeg2_r1", CubeListBuilder.create().texOffs(66, 33).addBox(-4.5F, -3.0F, -1.0F, 9.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.25F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMaw = FlowerMaw.addOrReplaceChild("NSMaw", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -3.0F, -3.0F, 0.8727F, 1.1345F, 0.0F));

		PartDefinition Tooth_r10 = NSMaw.addOrReplaceChild("Tooth_r10", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.5F, 1.0F, 0.0475F, -0.346F, -0.1392F));

		PartDefinition Tooth_r11 = NSMaw.addOrReplaceChild("Tooth_r11", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -2.5F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -2.5F, 1.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition NSMawSeg1_r1 = NSMaw.addOrReplaceChild("NSMawSeg1_r1", CubeListBuilder.create().texOffs(66, 33).addBox(-4.0F, -3.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.5F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg2 = NSMaw.addOrReplaceChild("NSMawSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -7.4768F, -1.1485F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Tooth_r12 = NSMawSeg2.addOrReplaceChild("Tooth_r12", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -2.0F, -1.0F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, -0.5236F, 0.0F));

		PartDefinition NSMawSeg2_r1 = NSMawSeg2.addOrReplaceChild("NSMawSeg2_r1", CubeListBuilder.create().texOffs(66, 33).addBox(-3.5F, -3.0F, -1.0F, 7.0F, 6.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.25F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition NSMawSeg3 = NSMawSeg2.addOrReplaceChild("NSMawSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.75F, -2.25F, 0.25F, 0.48F, 0.0F, 0.0F));

		PartDefinition Tooth_r13 = NSMawSeg3.addOrReplaceChild("Tooth_r13", CubeListBuilder.create().texOffs(397, 33).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.2182F, -0.2182F));

		PartDefinition Tooth_r14 = NSMawSeg3.addOrReplaceChild("Tooth_r14", CubeListBuilder.create().texOffs(397, 33).addBox(-0.5F, -5.0F, 0.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.2182F, 0.2618F));

		PartDefinition NSMawSeg3_r1 = NSMawSeg3.addOrReplaceChild("NSMawSeg3_r1", CubeListBuilder.create().texOffs(66, 33).addBox(-3.0F, -3.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -2.75F, -0.1015F, 0.0F, 3.1416F, 0.0F));

		PartDefinition BileSacs = Howi.addOrReplaceChild("BileSacs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BallSac1 = BileSacs.addOrReplaceChild("BallSac1", CubeListBuilder.create(), PartPose.offset(46.9749F, -35.0104F, 0.0F));

		PartDefinition Bile_r1 = BallSac1.addOrReplaceChild("Bile_r1", CubeListBuilder.create().texOffs(212, 129).addBox(-6.5F, -14.0F, -12.0F, 13.0F, 28.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3386F, -0.5545F, 0.3882F, -0.2618F, 0.2618F, 0.3927F));

		PartDefinition BallSac2 = BileSacs.addOrReplaceChild("BallSac2", CubeListBuilder.create(), PartPose.offsetAndRotation(25.9822F, -31.9347F, 34.6012F, 0.3052F, 0.2561F, 0.3102F));

		PartDefinition Bile_r2 = BallSac2.addOrReplaceChild("Bile_r2", CubeListBuilder.create().texOffs(218, 134).addBox(-9.0F, -14.0F, 3.0F, 25.0F, 28.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1128F, -3.8047F, -6.0917F, -0.2618F, 0.2618F, 0.3927F));

		PartDefinition BallSac3 = BileSacs.addOrReplaceChild("BallSac3", CubeListBuilder.create().texOffs(226, 142).addBox(-7.5F, -9.0F, -6.5F, 12.0F, 18.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9862F, -69.401F, 37.1219F, 0.5668F, 0.0218F, -0.0378F));

		PartDefinition BallSac4 = BileSacs.addOrReplaceChild("BallSac4", CubeListBuilder.create().texOffs(235, 151).addBox(-3.5F, -9.0F, 1.5F, 11.0F, 18.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.489F, -50.5962F, 41.8338F, 0.0981F, -0.5139F, 0.2424F));

		PartDefinition BallSac5 = BileSacs.addOrReplaceChild("BallSac5", CubeListBuilder.create().texOffs(228, 135).addBox(-7.5F, -9.0F, -2.0F, 15.0F, 29.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7958F, -39.8128F, -37.5917F, 0.566F, 0.0513F, 0.8202F));

		PartDefinition BallSac6 = BileSacs.addOrReplaceChild("BallSac6", CubeListBuilder.create().texOffs(229, 134).addBox(-3.0F, -11.5F, -8.0F, 6.0F, 23.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.3125F, -43.3128F, -4.3635F, -0.035F, -0.2595F, 0.1355F));

		PartDefinition MajorBallSack = BileSacs.addOrReplaceChild("MajorBallSack", CubeListBuilder.create().texOffs(192, 0).addBox(-16.0F, -1.5F, -20.0F, 32.0F, 10.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4846F, -9.5489F, -1.4748F, -0.221F, -0.2577F, 0.1806F));

		PartDefinition Bile_r3 = MajorBallSack.addOrReplaceChild("Bile_r3", CubeListBuilder.create().texOffs(211, 152).addBox(-10.0F, -5.0F, -9.5F, 20.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7889F, 0.1323F, 10.7466F, 0.5401F, -0.1197F, 0.0778F));

		PartDefinition Bile_r4 = MajorBallSack.addOrReplaceChild("Bile_r4", CubeListBuilder.create().texOffs(192, 142).addBox(-14.0F, -5.0F, -14.5F, 28.0F, 10.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.8771F, -2.5098F, 5.2757F, 0.3411F, -0.1584F, -0.3337F));

		PartDefinition Maw = Howi.addOrReplaceChild("Maw", CubeListBuilder.create(), PartPose.offset(-6.0F, -81.0F, 0.0F));

		PartDefinition Center_r1 = Maw.addOrReplaceChild("Center_r1", CubeListBuilder.create().texOffs(286, 125).addBox(-17.0F, -4.0F, -15.0F, 28.0F, 12.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 8.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition Tongue = Maw.addOrReplaceChild("Tongue", CubeListBuilder.create().texOffs(368, 245).addBox(-5.0F, -10.0F, -3.0F, 10.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 6.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TongueSeg2 = Tongue.addOrReplaceChild("TongueSeg2", CubeListBuilder.create().texOffs(456, 506).addBox(-4.0F, -8.0F, -2.0F, 9.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -10.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition TongueSeg3 = TongueSeg2.addOrReplaceChild("TongueSeg3", CubeListBuilder.create().texOffs(376, 505).addBox(-3.0F, -6.0F, -1.0F, 7.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, -0.5F, -0.5236F, 0.0F, 0.0F));

		PartDefinition TongueSeg4 = TongueSeg3.addOrReplaceChild("TongueSeg4", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -10.0F, 0.0F, 6.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -6.0F, -0.5F, -0.6109F, 0.0F, 0.0F));

		PartDefinition TongueSplit1 = TongueSeg4.addOrReplaceChild("TongueSplit1", CubeListBuilder.create().texOffs(16, 279).addBox(-0.5F, -7.5F, -0.5F, 2.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -9.5F, 0.75F, 0.5236F, 0.0F, 0.0F));

		PartDefinition TongueSplit2 = TongueSeg4.addOrReplaceChild("TongueSplit2", CubeListBuilder.create().texOffs(0, 279).addBox(-1.5F, -7.5F, -0.25F, 3.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.5F, 1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition MawInnerTeeth = Maw.addOrReplaceChild("MawInnerTeeth", CubeListBuilder.create(), PartPose.offset(0.0F, -2.0F, 8.0F));

		PartDefinition Teeth_r41 = MawInnerTeeth.addOrReplaceChild("Teeth_r41", CubeListBuilder.create().texOffs(256, 125).addBox(-12.2349F, -2.3113F, 1.1587F, 22.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7651F, -5.3192F, -0.8409F, 2.5307F, 1.0908F, 3.1416F));

		PartDefinition Teeth_r42 = MawInnerTeeth.addOrReplaceChild("Teeth_r42", CubeListBuilder.create().texOffs(262, 125).addBox(-8.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.3192F, -12.4264F, -0.6109F, 0.3491F, 0.0F));

		PartDefinition Teeth_r43 = MawInnerTeeth.addOrReplaceChild("Teeth_r43", CubeListBuilder.create().texOffs(256, 125).addBox(-9.7651F, -2.3113F, -1.1587F, 22.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.7651F, -5.3192F, -7.1591F, -2.5307F, 1.0908F, -3.1416F));

		PartDefinition Teeth_r44 = MawInnerTeeth.addOrReplaceChild("Teeth_r44", CubeListBuilder.create().texOffs(256, 125).addBox(-7.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -5.3192F, 6.4264F, 0.6109F, 0.3491F, 0.0F));

		PartDefinition Teeth_r45 = MawInnerTeeth.addOrReplaceChild("Teeth_r45", CubeListBuilder.create().texOffs(256, 125).addBox(-11.0F, -2.5F, 0.0F, 22.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 4.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition jaw1 = Maw.addOrReplaceChild("jaw1", CubeListBuilder.create(), PartPose.offset(0.0F, -1.25F, -5.0F));

		PartDefinition MawLip1 = jaw1.addOrReplaceChild("MawLip1", CubeListBuilder.create().texOffs(448, 288).addBox(-13.0F, -15.0F, -2.0F, 26.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.6675F, -0.4167F, 0.1881F));

		PartDefinition Teeth_r46 = MawLip1.addOrReplaceChild("Teeth_r46", CubeListBuilder.create().texOffs(253, 125).mirror().addBox(-13.0F, 0.0F, -1.75F, 21.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -9.75F, 3.0F, 0.48F, 0.0F, -0.1745F));

		PartDefinition Teeth_r47 = MawLip1.addOrReplaceChild("Teeth_r47", CubeListBuilder.create().texOffs(256, 125).addBox(-13.0F, -1.0F, -1.0F, 17.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.75F, 3.0F, 0.7854F, 0.0F, 0.1309F));

		PartDefinition MawLip1Seg2 = MawLip1.addOrReplaceChild("MawLip1Seg2", CubeListBuilder.create().texOffs(460, 291).addBox(-6.0F, -11.5F, -2.0F, 14.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(557, 433).addBox(-14.0F, -6.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.5F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Teeth_r48 = MawLip1Seg2.addOrReplaceChild("Teeth_r48", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -7.25F, 2.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Teeth_r49 = MawLip1Seg2.addOrReplaceChild("Teeth_r49", CubeListBuilder.create().texOffs(269, 126).addBox(-2.0F, 1.0F, -4.5F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, -3.25F, 5.0F, -0.4363F, 0.0F, -0.3491F));

		PartDefinition Teeth_r50 = MawLip1Seg2.addOrReplaceChild("Teeth_r50", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -5.5F, -2.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -5.75F, 4.0F, 0.0F, 0.1745F, -0.1309F));

		PartDefinition MawLip1Seg3 = MawLip1Seg2.addOrReplaceChild("MawLip1Seg3", CubeListBuilder.create().texOffs(556, 376).addBox(-4.0F, -6.0F, -1.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -11.5F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition jaw2 = Maw.addOrReplaceChild("jaw2", CubeListBuilder.create(), PartPose.offset(-10.0F, 1.0F, 2.0F));

		PartDefinition MawLip2 = jaw2.addOrReplaceChild("MawLip2", CubeListBuilder.create().texOffs(448, 288).addBox(-13.0F, -15.0F, -2.0F, 26.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.6735F, 1.2768F, -2.1184F));

		PartDefinition Teeth_r51 = MawLip2.addOrReplaceChild("Teeth_r51", CubeListBuilder.create().texOffs(254, 125).addBox(-13.0F, 0.0F, -2.0F, 24.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, 3.5F, 0.48F, 0.0F, 0.1745F));

		PartDefinition Teeth_r52 = MawLip2.addOrReplaceChild("Teeth_r52", CubeListBuilder.create().texOffs(258, 125).addBox(-4.0F, -1.0F, -1.0F, 17.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 3.5F, 0.7854F, 0.0F, -0.1309F));

		PartDefinition MawLip2Seg2 = MawLip2.addOrReplaceChild("MawLip2Seg2", CubeListBuilder.create().texOffs(460, 291).addBox(-6.0F, -10.5F, -2.0F, 14.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(557, 433).addBox(-14.0F, -8.5F, -1.0F, 8.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.5F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Teeth_r53 = MawLip2Seg2.addOrReplaceChild("Teeth_r53", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.5F, 1.75F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Teeth_r54 = MawLip2Seg2.addOrReplaceChild("Teeth_r54", CubeListBuilder.create().texOffs(269, 125).mirror().addBox(-3.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.1478F, -3.0825F, 1.835F, -2.7053F, 0.0F, 2.7925F));

		PartDefinition Teeth_r55 = MawLip2Seg2.addOrReplaceChild("Teeth_r55", CubeListBuilder.create().texOffs(397, 33).addBox(0.0F, -5.5F, -2.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.0F, 3.75F, 0.0F, -0.1745F, 0.1309F));

		PartDefinition MawLip2Seg3 = MawLip2Seg2.addOrReplaceChild("MawLip2Seg3", CubeListBuilder.create().texOffs(556, 376).addBox(-7.0F, -6.0F, -1.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -10.5F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition jaw3 = Maw.addOrReplaceChild("jaw3", CubeListBuilder.create(), PartPose.offset(7.0F, -1.0F, 9.0F));

		PartDefinition MawLip3 = jaw3.addOrReplaceChild("MawLip3", CubeListBuilder.create().texOffs(448, 288).addBox(-13.0F, -15.0F, -2.0F, 26.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.6545F, 0.0F));

		PartDefinition Teeth_r56 = MawLip3.addOrReplaceChild("Teeth_r56", CubeListBuilder.create().texOffs(258, 125).addBox(-8.5F, 0.0F, -1.0F, 17.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3692F, -12.2884F, -2.7071F, 2.3562F, 0.0F, 3.0107F));

		PartDefinition Teeth_r57 = MawLip3.addOrReplaceChild("Teeth_r57", CubeListBuilder.create().texOffs(254, 125).addBox(-12.0F, 0.0F, -1.0F, 24.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.065F, -9.7189F, -2.887F, 2.6616F, 0.0F, -2.9671F));

		PartDefinition MawLip3Seg2 = MawLip3.addOrReplaceChild("MawLip3Seg2", CubeListBuilder.create().texOffs(460, 291).addBox(-6.0F, -12.5F, -2.0F, 14.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(557, 433).addBox(-14.0F, -6.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.5F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Teeth_r58 = MawLip3Seg2.addOrReplaceChild("Teeth_r58", CubeListBuilder.create().texOffs(397, 33).mirror().addBox(-3.9139F, -5.5113F, -1.0076F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.9139F, -6.9887F, -2.9924F, -3.1416F, 0.0F, -3.1416F));

		PartDefinition Teeth_r59 = MawLip3Seg2.addOrReplaceChild("Teeth_r59", CubeListBuilder.create().texOffs(269, 125).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.1445F, -4.8971F, -1.9063F, -2.7053F, 0.0F, 2.7925F));

		PartDefinition Teeth_r60 = MawLip3Seg2.addOrReplaceChild("Teeth_r60", CubeListBuilder.create().texOffs(397, 33).mirror().addBox(0.0F, -5.5F, -1.0F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, -6.9773F, -3.0F, -3.1262F, 0.1739F, 0.2195F));

		PartDefinition MawLip3Seg3 = MawLip3Seg2.addOrReplaceChild("MawLip3Seg3", CubeListBuilder.create().texOffs(556, 376).addBox(-4.0F, -6.5F, -1.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -12.067F, 0.25F, 0.5236F, 0.0F, 0.0F));

		PartDefinition BodyRoots = Howi.addOrReplaceChild("BodyRoots", CubeListBuilder.create(), PartPose.offset(0.0F, -32.0F, 0.0F));

		PartDefinition Root1 = BodyRoots.addOrReplaceChild("Root1", CubeListBuilder.create().texOffs(1, 166).addBox(-18.0F, -3.5F, -3.5F, 20.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4123F, -28.6238F, 42.5608F, 0.0F, 1.309F, 0.0F));

		PartDefinition R1Seg2 = Root1.addOrReplaceChild("R1Seg2", CubeListBuilder.create().texOffs(332, 299).addBox(-20.0F, -2.5F, -2.5F, 22.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition R1Seg3 = R1Seg2.addOrReplaceChild("R1Seg3", CubeListBuilder.create().texOffs(323, 233).addBox(-12.0F, -1.5F, -1.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition R1Seg4 = R1Seg3.addOrReplaceChild("R1Seg4", CubeListBuilder.create().texOffs(324, 36).addBox(-13.5F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Root2 = BodyRoots.addOrReplaceChild("Root2", CubeListBuilder.create().texOffs(0, 165).addBox(-20.0F, -4.0F, -4.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.0F, 1.0F, -4.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition R2Seg1 = Root2.addOrReplaceChild("R2Seg1", CubeListBuilder.create().texOffs(330, 298).addBox(-20.0F, -3.0F, -3.0F, 23.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition R2Seg2 = R2Seg1.addOrReplaceChild("R2Seg2", CubeListBuilder.create().texOffs(320, 232).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition R2Seg3 = R2Seg2.addOrReplaceChild("R2Seg3", CubeListBuilder.create().texOffs(320, 35).addBox(-14.0F, -1.0F, -2.0F, 16.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Root3 = BodyRoots.addOrReplaceChild("Root3", CubeListBuilder.create().texOffs(10, 167).mirror().addBox(0.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(39.6297F, 14.5944F, 14.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition R3Seg1 = Root3.addOrReplaceChild("R3Seg1", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition RootSeg_r2 = R3Seg1.addOrReplaceChild("RootSeg_r2", CubeListBuilder.create().texOffs(332, 300).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg2 = R3Seg1.addOrReplaceChild("R3Seg2", CubeListBuilder.create().texOffs(322, 234).addBox(-2.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition R3Seg3 = R3Seg2.addOrReplaceChild("R3Seg3", CubeListBuilder.create().texOffs(324, 235).addBox(-1.0F, 0.0F, -1.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, -0.5F, 0.5F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Root4 = BodyRoots.addOrReplaceChild("Root4", CubeListBuilder.create().texOffs(1, 166).addBox(-2.0F, -3.5F, -3.5F, 20.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5877F, -3.6238F, -18.5608F, 0.0F, 0.1309F, -0.2182F));

		PartDefinition R4Seg1 = Root4.addOrReplaceChild("R4Seg1", CubeListBuilder.create(), PartPose.offsetAndRotation(18.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 1.309F));

		PartDefinition RootSeg_r3 = R4Seg1.addOrReplaceChild("RootSeg_r3", CubeListBuilder.create().texOffs(332, 299).addBox(-11.0F, -2.5F, -2.5F, 22.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R4Seg2 = R4Seg1.addOrReplaceChild("R4Seg2", CubeListBuilder.create().texOffs(325, 234).addBox(-2.0F, -1.5F, -1.5F, 14.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition R4Seg3 = R4Seg2.addOrReplaceChild("R4Seg3", CubeListBuilder.create().texOffs(320, 236).addBox(0.5F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Root5 = BodyRoots.addOrReplaceChild("Root5", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0419F, -17.0F, -27.9088F, 0.0F, 1.0624F, 0.0F));

		PartDefinition RootSeg_r4 = Root5.addOrReplaceChild("RootSeg_r4", CubeListBuilder.create().texOffs(10, 167).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg4 = Root5.addOrReplaceChild("R3Seg4", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition RootSeg_r5 = R3Seg4.addOrReplaceChild("RootSeg_r5", CubeListBuilder.create().texOffs(333, 302).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg5 = R3Seg4.addOrReplaceChild("R3Seg5", CubeListBuilder.create().texOffs(322, 234).addBox(-2.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition R3Seg6 = R3Seg5.addOrReplaceChild("R3Seg6", CubeListBuilder.create().texOffs(324, 235).addBox(-1.0F, 0.0F, -1.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, -0.5F, 0.5F, 0.0F, 0.0F, -0.7854F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}
	void animateTumor1(ModelPart part,float value){
		part.xScale = 1 + Mth.sin(value/5)/8;
		part.yScale = 1 + Mth.sin(value/6)/8;
		part.zScale = 1 + Mth.sin(value/7)/8;
	}
	void animateTumor2(ModelPart part,float value){
		part.xScale = 1 + Mth.sin(value/6)/8;
		part.yScale = 1 + Mth.cos(value/7)/8;
		part.zScale = 1 + Mth.sin(value/5)/8;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Maw.yRot = Mth.cos(ageInTicks/8)/8;
		this.Jaw1.xRot  = -Mth.sin(ageInTicks/6)/4;
		this.Jaw2.zRot  = Mth.sin(ageInTicks/6)/4;
		this.Jaw3.xRot  = Mth.sin(ageInTicks/6)/4;
		this.Tongue.xRot = Mth.cos(ageInTicks/8)/4;
		this.Tongue.zRot = Mth.cos(ageInTicks/8)/2;
		this.Tongue2.xRot = this.Tongue.xRot;
		this.Tongue2.yRot = Mth.cos(ageInTicks/6)/6;
		this.Tongue3.xRot = this.Tongue.xRot *2;
		this.Tongue3.zRot = -this.Tongue.zRot;
		this.Tongue4.xRot = this.Tongue.xRot;
		this.Tongue5.xRot = this.Tongue.xRot *2;
		this.Tongue6.xRot = -this.Tongue.xRot;
		animateTumor1(Tumor1,ageInTicks);
		animateTumor2(Tumor2,ageInTicks);
		animateTumor1(Tumor3,-ageInTicks);
		animateTumor2(Tumor3,-ageInTicks);
		animateTumor1(Tumor4,ageInTicks/2);
		animateTumor1(Tumor5,ageInTicks/2);
		animateTumor2(Tumor6,ageInTicks);
		animateTumor2(Tumor7,-ageInTicks);
		this.CononCluster1.yScale = 1+Mth.cos(ageInTicks/8)/10;
		this.CononCluster2.yScale = 1+Mth.sin(ageInTicks/8)/9;
		this.CononCluster3.yScale = 1+Mth.cos(ageInTicks/8)/9;
		this.CononCluster4.yRot = Mth.cos(ageInTicks/8)/6;
		this.CononCluster4.yScale = 1+Mth.sin(ageInTicks/8)/10;
		this.Cannon1.zRot = Mth.cos(ageInTicks/7)/8;
		this.Cannon2.xRot = Mth.cos(-ageInTicks/7)/7;
		this.Cannon3.xRot = Mth.cos(ageInTicks/8)/9;
		this.Cannon4.zRot = Mth.cos(-ageInTicks/7)/8;
		this.Cannon4.xRot = Mth.cos(ageInTicks/9)/8;
		this.Cannon5.zRot = Mth.cos(ageInTicks/9)/7;
		this.Cannon6.xRot = Mth.cos(ageInTicks/7)/7;
		this.Cannon7.zRot = Mth.cos(-ageInTicks/9)/6;
		this.Cannon8.xRot = Mth.cos(ageInTicks/7)/8;
		this.Cannon9.zRot = Mth.cos(ageInTicks/7)/5;
		this.CannonFlower.yRot = Mth.cos(ageInTicks/6)/5;
		this.CannonHead.zRot = headPitch /  ( 90F / (float) Math.PI);
		this.CannonHead.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.CannonHead.xRot = Mth.sin(ageInTicks/7)/8;
		this.Tentacle1.zRot = Mth.sin(ageInTicks/5)/5;
		this.Tentacle1.getChild("R1Seg2").zRot =-0.7f+Mth.cos(ageInTicks/6)/2;
		this.Tentacle1.getChild("R1Seg2").getChild("R1Seg3").zRot =-0.5f+Mth.cos(ageInTicks/4)/2;
		this.Tentacle2.zRot = Mth.cos(ageInTicks/5)/5;
		this.Tentacle2.getChild("R2Seg1").zRot =-0.5f+ Mth.cos(ageInTicks/5)/5;
		this.Tentacle2.getChild("R2Seg1").getChild("R2Seg2").zRot =-0.5f+ Mth.cos(ageInTicks/5)/5;
		this.Tentacle3.zRot = Mth.cos(ageInTicks/5)/5;
		this.Tentacle3.getChild("R3Seg1").zRot =-0.5f+ Mth.sin(ageInTicks/5)/4;
		this.Tentacle3.getChild("R3Seg1").getChild("R3Seg2").zRot =-0.5f+ Mth.cos(ageInTicks/6)/3;
		this.Tentacle4.zRot = -0.5f-Mth.cos(ageInTicks/5)/5;
		this.Tentacle4.getChild("R4Seg1").zRot =0.4f- Mth.cos(ageInTicks/6)/2;
		this.Tentacle4.getChild("R4Seg1").yRot =Mth.sin(ageInTicks/6)/2;
		this.Tentacle4.getChild("R4Seg1").getChild("R4Seg2").zRot =0.5f- Mth.cos(ageInTicks/5)/2;
		this.Tentacle5.zRot = Mth.cos(ageInTicks/5)/5;
		this.Tentacle5.getChild("R3Seg4").zRot =-0.4f+ Mth.cos(ageInTicks/6)/4;
		this.Tentacle5.getChild("R3Seg4").getChild("R3Seg5").zRot =-0.5f+ Mth.sin(ageInTicks/5)/3;
		this.Tentacle5.getChild("R3Seg4").getChild("R3Seg5").yRot =Mth.cos(ageInTicks/5)/3;
		this.LeftLegTentacle.yRot =Mth.sin(ageInTicks/6)/2;
		this.LeftLegTentacle.getChild("Seg2Tendril9").yRot = LeftLegTentacle.yRot;
		this.LeftLegTentacle.getChild("Seg2Tendril9").getChild("Seg3Tendril9").yRot = LeftLegTentacle.yRot;
		this.RightLegTentacle1.xRot = Mth.cos(ageInTicks/6)/2;
		this.RightLegTentacle1.getChild("Seg2Tendril8").getChild("Seg3Tendril8").xRot = Mth.cos(ageInTicks/6)/2;
		this.RightLegTentacle2.xRot = Mth.cos(ageInTicks/6)/3;
		this.RightLegTentacle2.getChild("Seg2Tendril5").getChild("Seg3Tendril5").xRot = Mth.cos(ageInTicks/6)/3;
		this.RightLegTentacle3.zRot = Mth.cos(ageInTicks/9)/2;
		this.RightLegTentacle3.getChild("Seg2Tendril6").zRot = Mth.cos(ageInTicks/7);
		this.RightLegTentacle4.zRot = Mth.sin(ageInTicks/6);
		this.RightLegTentacle4.getChild("Seg2Tendril7").zRot = Mth.sin(ageInTicks/8);
		this.LeftArmTendril1.zRot = Mth.sin(ageInTicks/8)/2;
		this.LeftArmTendril1.getChild("Seg2Tendril1").getChild("Seg3Tendril1").xRot = LeftArmTendril1.zRot;
		this.LeftArmTendril2.xRot = Mth.cos(ageInTicks/8);
		this.LeftArmTendril3.zRot = Mth.cos(ageInTicks/7);
		this.LeftArmTendril4.zRot = Mth.cos(ageInTicks/6)/2;
		RightArm.visible = entity.getRightArmHp()>0;
		LeftArm.visible = entity.getLeftArmHp()>0;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			float movementValue = Mth.cos(limbSwing * 0.8F) * 0.4F * limbSwingAmount;
			this.LeftLeg.xRot = movementValue;
			this.RightLeg.yRot = -movementValue*2;
			this.RightForLeg.xRot = -movementValue*1.5f;
			this.RightArm.yRot = movementValue*1.5f;
			this.RightForArm.xRot = movementValue*2;
			this.RightForForArm.yRot = movementValue*2;
			this.LeftArm.yRot = movementValue*1.2f;
			this.LeftForArm.yRot = movementValue*1.8f;
			this.LeftForArm.xRot = movementValue*0.4f;
			this.LeftForForArm.xRot = movementValue;
		}else{
			this.LeftLeg.xRot = 0;
			this.RightLeg.yRot = 0;
			this.RightForLeg.xRot = 0;
			this.RightArm.yRot = 0;
			this.RightForArm.xRot = 0;
			this.RightForForArm.yRot = 0;
			this.LeftArm.yRot = 0;
			this.LeftForArm.yRot = 0;
			this.LeftForArm.xRot = 0;
			this.LeftForForArm.xRot = 0;
		}

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Howi.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}