package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.FallenMultipart.HowitzerArm;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class LeftArmModel<T extends HowitzerArm> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "leftarmmodel"), "main");
	private final ModelPart LeftArmJoint;

	public LeftArmModel(ModelPart root) {
		this.LeftArmJoint = root.getChild("LeftArmJoint");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeftArmJoint = partdefinition.addOrReplaceChild("LeftArmJoint", CubeListBuilder.create(), PartPose.offset(-16.1436F, 14.7216F, 25.9533F));

		PartDefinition LeftArm = LeftArmJoint.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(93, 267).addBox(-5.0F, -10.5F, -10.5F, 31.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Body1 = LeftArm.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offsetAndRotation(9.4863F, -11.3822F, 1.9005F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Leg_r1 = Body1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(256, 326).addBox(-1.1032F, -0.7548F, -1.73F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4672F, 2.2911F, 5.6196F, -0.1597F, -0.7638F, 0.5852F));

		PartDefinition Arm_r1 = Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(256, 326).addBox(-0.5219F, -0.4371F, -1.2876F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r2 = Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(256, 326).addBox(-0.6481F, -1.3468F, -1.5882F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r1 = Body1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(256, 326).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r1 = Body1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(256, 326).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(256, 326).addBox(-14.0F, -5.5F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r1 = Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(256, 326).addBox(-0.752F, -4.9611F, -3.8866F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7147F, -0.3831F, -2.47F, -0.1692F, -0.2135F, 0.7249F));

		PartDefinition Body2 = LeftArm.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(255, 326).addBox(-2.4218F, -0.7079F, -3.1266F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8154F, -0.2638F, 11.4233F, -1.0472F, 1.4835F, 0.0F));

		PartDefinition Leg_r2 = Body2.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-1.3621F, -0.8419F, -1.4136F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5814F, 4.771F, -1.197F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Leg_r3 = Body2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(255, 326).addBox(0.7242F, -0.3457F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9505F, 4.9908F, 2.3734F, 0.211F, 0.056F, -0.2559F));

		PartDefinition Arm_r3 = Body2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-0.836F, -1.3941F, -1.8523F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8068F, -6.4923F, -2.9503F, -0.7665F, -0.1875F, 0.2367F));

		PartDefinition Head_r1 = Body2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7451F, -8.6475F, 3.1328F, 1.8953F, -1.1912F, -2.0859F));

		PartDefinition TorsoTop_r2 = Body2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4218F, -0.7079F, 0.6234F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Body3 = LeftArm.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0647F, 10.2217F, -2.4626F, 0.829F, 0.0F, 0.0F));

		PartDefinition Leg_r4 = Body3.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -2.0F, -5.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8159F, -2.3674F, 1.5033F, -2.5447F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r2 = Body3.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.96F, -1.6167F, -3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r4 = Body3.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -0.6697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3317F, 2.1134F, 1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r5 = Body3.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0504F, -2.0967F, -0.1748F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3079F, 3.3228F, 3.853F, -0.6895F, 0.5305F, 0.4982F));

		PartDefinition TorsoBottom_r1 = Body3.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8748F, 1.1196F, 0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = Body3.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-4.2978F, -7.59F, -3.3478F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.13F, 4.0992F, 2.9916F, -2.6335F, 0.6629F, -0.1841F));

		PartDefinition Body4 = LeftArm.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -3.0F, -4.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1895F, 3.3956F, -8.9835F, 1.7453F, 0.0F, 0.0F));

		PartDefinition Leg_r5 = Body4.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3241F, 0.8525F, -2.1658F, 0.0088F, 0.4082F, 0.6342F));

		PartDefinition Head_r3 = Body4.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.365F, 1.0059F, 4.1978F, -0.1344F, 0.0263F, 0.1684F));

		PartDefinition Arm_r6 = Body4.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -8.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.6785F, -2.7301F, 5.7825F, -0.2187F, -0.6429F, 0.1325F));

		PartDefinition TorsoTop_r3 = Body4.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-3.75F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 7.0F, -0.0699F, 0.2698F, 0.4077F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(320, 163).addBox(-1.0F, -8.5F, -9.5F, 33.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.3267F, -0.4625F, 0.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition Body5 = LeftArmSeg2.addOrReplaceChild("Body5", CubeListBuilder.create(), PartPose.offsetAndRotation(14.3803F, -9.8209F, -6.3205F, 0.0F, 0.0F, 0.3054F));

		PartDefinition TorsoBase_r3 = Body5.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r4 = Body5.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r5 = Body5.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0283F, -0.1085F, -0.4234F));

		PartDefinition Head_r4 = Body5.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body6 = LeftArmSeg2.addOrReplaceChild("Body6", CubeListBuilder.create(), PartPose.offset(15.8168F, 8.1616F, -8.3109F));

		PartDefinition Leg_r6 = Body6.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -8.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8803F, -6.5243F, -1.2902F, -1.5761F, 0.989F, -0.4866F));

		PartDefinition TorsoBase_r4 = Body6.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -6.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4499F, -0.7882F, -0.449F, -1.4198F, 0.213F, 0.1614F));

		PartDefinition Arm_r7 = Body6.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -1.1697F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, 0.9938F, 2.204F, 2.3868F, 0.3569F, 1.7879F));

		PartDefinition Arm_r8 = Body6.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7504F, -0.4172F, 4.1598F, 0.1325F, 0.6507F, 0.0884F));

		PartDefinition TorsoBottom_r2 = Body6.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body7 = LeftArmSeg2.addOrReplaceChild("Body7", CubeListBuilder.create(), PartPose.offsetAndRotation(17.2809F, 1.6118F, 9.4586F, -2.4165F, 0.4079F, 0.338F));

		PartDefinition TorsoBase_r5 = Body7.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r9 = Body7.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r10 = Body7.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0019F, -1.0747F, -6.8877F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, 4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoTop_r6 = Body7.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r5 = Body7.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition LeftArmSeg3 = LeftArmSeg2.addOrReplaceChild("LeftArmSeg3", CubeListBuilder.create().texOffs(0, 345).addBox(-1.0F, -12.5F, -10.5F, 23.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.4131F, 0.0034F, 0.0F, 0.0F, 0.0F, 0.9163F));

		PartDefinition Body8 = LeftArmSeg3.addOrReplaceChild("Body8", CubeListBuilder.create(), PartPose.offset(12.7712F, -11.1648F, -10.5733F));

		PartDefinition Arm_r11 = Body8.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-1.081F, -2.3303F, -7.0335F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.457F, -0.9938F, 2.204F, 1.6609F, -0.5587F, -1.5066F));

		PartDefinition TorsoBase_r6 = Body8.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -0.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8347F, 2.7363F, -2.2954F, 1.5655F, 0.1556F, -0.0458F));

		PartDefinition TorsoTop_r7 = Body8.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r6 = Body8.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-4.5F, -4.75F, -4.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, 7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition Body9 = LeftArmSeg3.addOrReplaceChild("Body9", CubeListBuilder.create(), PartPose.offset(9.4037F, 11.1582F, 7.4043F));

		PartDefinition Leg_r7 = Body9.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-2.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2102F, -6.6181F, 3.1712F, -1.3444F, -1.2748F, 2.6415F));

		PartDefinition Leg_r8 = Body9.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-2.664F, -3.3936F, -1.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, -4.5592F, 3.5018F, 1.4744F, -0.2937F, 1.281F));

		PartDefinition TorsoBase_r7 = Body9.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -3.7363F, 1.2954F, 0.9443F, 0.4081F, -0.0114F));

		PartDefinition Arm_r12 = Body9.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 0.4749F, -0.0861F, 0.0821F));

		PartDefinition Arm_r13 = Body9.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(255, 326).addBox(1.0019F, -2.9253F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.5679F, 0.5824F, -0.2421F));

		PartDefinition TorsoBottom_r3 = Body9.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r7 = Body9.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.25F, 0.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.4988F, 0.6701F, -0.0532F));

		PartDefinition LeftArmSeg4 = LeftArmSeg3.addOrReplaceChild("LeftArmSeg4", CubeListBuilder.create().texOffs(0, 279).addBox(-1.0F, -15.5F, -14.5F, 18.0F, 28.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.0F, -0.5F, 0.5F, 0.4344F, -0.1745F, 0.2618F));

		PartDefinition LeftArmSeg5 = LeftArmSeg4.addOrReplaceChild("LeftArmSeg5", CubeListBuilder.create().texOffs(168, 288).addBox(-1.0F, -18.5F, -14.25F, 13.0F, 31.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offset(18.0F, 1.0F, -2.0F));

		PartDefinition Body14 = LeftArmSeg5.addOrReplaceChild("Body14", CubeListBuilder.create(), PartPose.offset(4.4037F, -19.1832F, 12.9043F));

		PartDefinition Leg_r9 = Body14.addOrReplaceChild("Leg_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-2.664F, -0.6064F, -2.2202F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8845F, 4.5592F, 3.5018F, -1.8184F, 0.2977F, -0.3486F));

		PartDefinition TorsoBase_r8 = Body14.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -1.4073F, 0.16F, -0.0071F));

		PartDefinition Arm_r14 = Body14.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r15 = Body14.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3474F, 0.6507F, 0.0884F));

		PartDefinition TorsoTop_r8 = Body14.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r8 = Body14.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.75F, -2.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition Body15 = LeftArmSeg5.addOrReplaceChild("Body15", CubeListBuilder.create(), PartPose.offsetAndRotation(6.7844F, -18.1832F, -11.942F, 0.0F, 2.5307F, 0.0F));

		PartDefinition Leg_r10 = Body15.addOrReplaceChild("Leg_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0379F, -0.9393F, -1.027F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.3206F, 5.5473F, 3.1334F, -2.0798F, 0.492F, -0.7299F));

		PartDefinition TorsoBase_r9 = Body15.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition TorsoTop_r9 = Body15.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body16 = LeftArmSeg5.addOrReplaceChild("Body16", CubeListBuilder.create(), PartPose.offsetAndRotation(5.4037F, 8.0835F, -14.7591F, -1.5272F, 0.0F, 0.0F));

		PartDefinition Leg_r11 = Body16.addOrReplaceChild("Leg_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -1.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7223F, -3.7805F, 4.6167F, 1.4972F, 0.6467F, -0.3166F));

		PartDefinition TorsoBase_r10 = Body16.addOrReplaceChild("TorsoBase_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, 0.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.435F, 0.0638F, 0.9725F, 0.8301F, 0.2351F, 0.1652F));

		PartDefinition Arm_r16 = Body16.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -1.1697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.809F, 0.1479F, -0.9257F));

		PartDefinition Arm_r17 = Body16.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7504F, -0.4172F, -4.1598F, 0.8274F, 0.6507F, -0.0884F));

		PartDefinition TorsoBottom_r4 = Body16.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Body17 = LeftArmSeg5.addOrReplaceChild("Body17", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3482F, 5.7928F, 14.6129F, -1.9014F, 0.9098F, 1.0058F));

		PartDefinition TorsoBase_r11 = Body17.addOrReplaceChild("TorsoBase_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, 3.274F, 1.5314F, 0.2616F, 0.0113F, -1.0893F));

		PartDefinition TorsoTop_r10 = Body17.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -2.3037F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, -1.187F, -1.0061F, 1.1368F, -0.3406F, -2.4406F));

		PartDefinition TorsoTop_r11 = Body17.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.75F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.0282F, -0.0649F, -0.4222F));

		PartDefinition Head_r9 = Body17.addOrReplaceChild("Head_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, -3.3286F, 2.3866F, 0.6455F, 0.4072F, -0.0777F));

		PartDefinition Body10 = LeftArmSeg4.addOrReplaceChild("Body10", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0035F, -14.4841F, 6.6076F, 0.6037F, 0.0998F, -0.1434F));

		PartDefinition Leg_r12 = Body10.addOrReplaceChild("Leg_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -5.0F, -2.0F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8159F, 2.3674F, -1.5033F, -1.1484F, 0.613F, -1.6654F));

		PartDefinition TorsoBase_r12 = Body10.addOrReplaceChild("TorsoBase_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.96F, 1.6167F, 3.4316F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r18 = Body10.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3317F, -2.1134F, -1.0678F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r19 = Body10.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(255, 326).addBox(-4.9496F, -0.9033F, -8.8252F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3079F, -3.3228F, -3.853F, -0.3921F, 0.7708F, -0.0005F));

		PartDefinition TorsoTop_r12 = Body10.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8748F, -1.1196F, -0.8638F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Body11 = LeftArmSeg4.addOrReplaceChild("Body11", CubeListBuilder.create(), PartPose.offsetAndRotation(10.4037F, -0.1193F, 13.7651F, -0.8727F, 0.0F, 0.0F));

		PartDefinition Leg_r13 = Body11.addOrReplaceChild("Leg_r13", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6458F, -1.7975F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, 5.4707F, 4.3625F, -0.6333F, -0.2284F, 0.6041F));

		PartDefinition TorsoBase_r13 = Body11.addOrReplaceChild("TorsoBase_r13", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r20 = Body11.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.1287F, -0.1787F, -0.013F));

		PartDefinition TorsoTop_r13 = Body11.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(255, 326).addBox(-3.1785F, -2.7821F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4348F, -0.2187F, 0.0357F));

		PartDefinition Body12 = LeftArmSeg4.addOrReplaceChild("Body12", CubeListBuilder.create(), PartPose.offset(1.2912F, 11.2153F, -5.9624F));

		PartDefinition TorsoBase_r14 = Body12.addOrReplaceChild("TorsoBase_r14", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -4.0F, 6.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6797F, -3.274F, 1.5314F, -0.2616F, 0.0113F, 1.0893F));

		PartDefinition TorsoBottom_r5 = Body12.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-8.8585F, -0.6963F, -4.0213F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0048F, 1.187F, -1.0061F, -0.6379F, -1.0548F, 1.7291F));

		PartDefinition TorsoBottom_r6 = Body12.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-10.0F, -2.25F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.0283F, -0.1085F, 0.4234F));

		PartDefinition Head_r10 = Body12.addOrReplaceChild("Head_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.2039F, 3.3286F, 2.3866F, -0.6455F, 0.4072F, 0.0777F));

		PartDefinition Body13 = LeftArmSeg4.addOrReplaceChild("Body13", CubeListBuilder.create(), PartPose.offsetAndRotation(9.5371F, -2.2403F, -15.5943F, -2.2253F, 0.0F, 0.0F));

		PartDefinition Leg_r14 = Body13.addOrReplaceChild("Leg_r14", CubeListBuilder.create().texOffs(255, 326).addBox(-0.6458F, -1.2025F, -5.4265F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2884F, -5.4707F, 4.3625F, 0.6333F, -0.2284F, -0.6041F));

		PartDefinition TorsoBase_r15 = Body13.addOrReplaceChild("TorsoBase_r15", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, -2.7363F, 2.2954F, 0.9905F, 0.1921F, 0.1438F));

		PartDefinition Arm_r21 = Body13.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.1287F, -0.1787F, 0.013F));

		PartDefinition TorsoBottom_r7 = Body13.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-3.1785F, -1.2179F, -4.1303F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4348F, -0.2187F, -0.0357F));

		PartDefinition Tendril3 = LeftArmSeg4.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(6.4796F, -14.4088F, -6.9507F, 1.4689F, 0.4828F, 0.4724F));

		PartDefinition TendrilSeg_r1 = Tendril3.addOrReplaceChild("TendrilSeg_r1", CubeListBuilder.create().texOffs(4, 52).addBox(-1.5F, -1.5F, -4.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 3.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0489F, -0.0111F, 7.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition TendrilSeg_r2 = Seg2Tendril3.addOrReplaceChild("TendrilSeg_r2", CubeListBuilder.create().texOffs(31, 51).addBox(-1.0F, -1.0F, -5.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(11, 42).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		PartDefinition Tendril4 = LeftArmSeg4.addOrReplaceChild("Tendril4", CubeListBuilder.create(), PartPose.offsetAndRotation(6.4796F, 11.8838F, 6.0493F, -1.4689F, 0.4828F, -0.9088F));

		PartDefinition TendrilSeg_r3 = Tendril4.addOrReplaceChild("TendrilSeg_r3", CubeListBuilder.create().texOffs(1, 49).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril4 = Tendril4.addOrReplaceChild("Seg2Tendril4", CubeListBuilder.create().texOffs(31, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0489F, 0.0111F, 7.2547F, 0.2725F, 0.6364F, 0.1646F));

		PartDefinition Seg3Tendril4 = Seg2Tendril4.addOrReplaceChild("Seg3Tendril4", CubeListBuilder.create().texOffs(6, 37).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.1409F, 0.0721F, 8.3902F, 0.3695F, -0.3272F, -0.1238F));

		PartDefinition Tendril1 = LeftArmSeg3.addOrReplaceChild("Tendril1", CubeListBuilder.create().texOffs(0, 49).addBox(-2.0F, -2.0F, -7.25F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 1.0F, -10.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(30, 51).addBox(-1.5F, -1.5F, -9.25F, 3.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, 0.2725F, -0.6364F, -0.1646F));

		PartDefinition Seg3Tendril1 = Seg2Tendril1.addOrReplaceChild("Seg3Tendril1", CubeListBuilder.create().texOffs(5, 37).addBox(-1.0F, -1.0F, -9.5F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.75F, 0.3695F, 0.3272F, 0.1238F));

		PartDefinition Seg4Tendril1 = Seg3Tendril1.addOrReplaceChild("Seg4Tendril1", CubeListBuilder.create().texOffs(19, 39).addBox(-0.5F, -0.5F, -9.5F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -9.0F, -0.4565F, 0.5194F, -0.2391F));

		PartDefinition Tendril2 = LeftArmSeg3.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(11.9954F, -4.3157F, 8.2791F, 0.0F, 0.829F, -0.5672F));

		PartDefinition TendrilSeg_r4 = Tendril2.addOrReplaceChild("TendrilSeg_r4", CubeListBuilder.create().texOffs(1, 49).addBox(-1.5F, -1.5F, -5.5F, 3.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0489F, -0.0111F, 10.2547F, -0.2725F, 0.6364F, -0.1646F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(6, 37).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1409F, -0.0721F, 8.3902F, -0.3695F, -0.3272F, 0.1238F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		LeftArmJoint.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}