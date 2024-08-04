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
import net.minecraft.util.Mth;

public class RightArmModel<T extends HowitzerArm> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "rightarmmodel"), "main");
	private final ModelPart RightArmJoint;
	private final ModelPart Joint;
	private final ModelPart Joint2;
	private final ModelPart Foot;

	public RightArmModel(ModelPart root) {
		this.RightArmJoint = root.getChild("RightArmJoint");
		this.Joint = RightArmJoint.getChild("RightArm").getChild("RightArmSeg2");
		this.Joint2 = Joint.getChild("RightArmSeg3");
		this.Foot = Joint2.getChild("RightArmSeg4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RightArmJoint = partdefinition.addOrReplaceChild("RightArmJoint", CubeListBuilder.create(), PartPose.offsetAndRotation(21.1436F, 14.7216F, 21.0467F, -1.5708F, 0.0F, 0.0F));

		PartDefinition RightArm = RightArmJoint.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(256, 83).addBox(-26.0F, -10.5F, -10.5F, 31.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Body18 = RightArm.addOrReplaceChild("Body18", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.6276F, -3.3115F, -11.2971F, 1.9668F, 1.2046F, 1.8979F));

		PartDefinition Leg_r1 = Body18.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -4.75F, 0.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4366F, 9.2068F, 1.7609F, 0.3488F, 0.0149F, -0.041F));

		PartDefinition Leg_r2 = Body18.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.523F, 5.0385F, -2.4364F, -0.218F, -0.0094F, -0.0426F));

		PartDefinition Arm_r1 = Body18.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2343F, -6.4446F, 2.8873F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r1 = Body18.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9375F, -9.5286F, -3.4826F, 0.237F, 0.1945F, -0.1077F));

		PartDefinition TorsoTop_r1 = Body18.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r1 = Body18.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(255, 326).addBox(-0.5F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Body19 = RightArm.addOrReplaceChild("Body19", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.1852F, -0.1205F, 10.9369F, -1.0282F, 0.664F, 1.0672F));

		PartDefinition Arm_r2 = Body19.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.646F, -4.1312F, -0.386F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r3 = Body19.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5131F, -1.9503F, -6.5947F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r1 = Body19.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(255, 326).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0681F, 2.8735F, 0.4794F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r2 = Body19.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7059F, 0.6936F, 2.4626F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r2 = Body19.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2725F, -2.0046F, -1.9926F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition Body20 = RightArm.addOrReplaceChild("Body20", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.7273F, 11.8154F, -1.0636F, 0.0F, 0.0F, -1.8326F));

		PartDefinition Leg_r3 = Body20.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(257, 331).addBox(-1.3621F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4032F, 4.788F, 2.3728F, -0.0397F, -0.0241F, -0.177F));

		PartDefinition Leg_r4 = Body20.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(257, 331).addBox(-1.2758F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.773F, 5.0385F, -2.4364F, -0.2132F, -0.0469F, -0.2132F));

		PartDefinition Arm_r4 = Body20.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(257, 331).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2343F, -6.4446F, 2.8873F, 1.8257F, 0.3567F, 0.2812F));

		PartDefinition TorsoTop_r3 = Body20.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(257, 331).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0056F, -0.6602F, -0.6864F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition TorsoBase_r2 = Body20.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(257, 331).addBox(-1.75F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4944F, 3.3398F, -0.1864F, 0.0411F, -0.3027F, 0.2555F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(320, 0).addBox(-32.0F, -8.5F, -8.5F, 33.0F, 17.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.3267F, -0.4625F, 0.0F, 0.0F, 0.0F, -1.0036F));

		PartDefinition Body21 = RightArmSeg2.addOrReplaceChild("Body21", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.4088F, -8.5442F, 4.7637F, -0.761F, -1.3001F, 1.3382F));

		PartDefinition TorsoBase_r3 = Body21.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r5 = Body21.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r6 = Body21.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r4 = Body21.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = Body21.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition RightArmSeg3 = RightArmSeg2.addOrReplaceChild("RightArmSeg3", CubeListBuilder.create().texOffs(256, 42).addBox(-33.0F, -12.5F, -9.5F, 34.0F, 21.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.4131F, 0.0034F, 0.0F, 0.0F, 0.0F, -1.2654F));

		PartDefinition Body22 = RightArmSeg3.addOrReplaceChild("Body22", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.481F, -14.7584F, -4.3256F, 2.7489F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r4 = Body22.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-3.0F, -2.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, -2.1988F, 3.3066F, 0.7795F, 0.461F, -0.0476F));

		PartDefinition Arm_r7 = Body22.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, 0.9938F, -2.204F, 1.0611F, -0.2558F, -0.192F));

		PartDefinition Arm_r8 = Body22.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.9253F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, 2.6507F, -4.0053F, 0.3089F, 0.9815F, 0.0943F));

		PartDefinition TorsoBottom_r3 = Body22.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, 0.4996F, 0.27F, 0.1446F));

		PartDefinition Head_r3 = Body22.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -3.25F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, 3.9697F, -7.46F, 1.2101F, -0.0972F, 0.2852F));

		PartDefinition Body23 = RightArmSeg3.addOrReplaceChild("Body23", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.1787F, -7.7629F, 12.4295F, 1.5003F, -0.3931F, -0.3865F));

		PartDefinition Arm_r9 = Body23.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-2.6989F, -1.3885F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, 2.1266F, -2.0948F, -0.1321F, 0.6937F, -0.6672F));

		PartDefinition Arm_r10 = Body23.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(255, 326).addBox(-0.9834F, -1.2395F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, -0.0543F, -8.3035F, -2.845F, -0.717F, 2.6241F));

		PartDefinition TorsoTop_r5 = Body23.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-3.6473F, -2.7889F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, -4.8781F, -1.2293F, -0.4207F, 1.4447F, -1.2856F));

		PartDefinition TorsoTop_r6 = Body23.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -2.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, -2.6983F, 0.7538F, 0.7071F, 0.6554F, -0.1855F));

		PartDefinition TorsoBottom_r4 = Body23.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, 0.358F, 0.6554F, -0.1855F));

		PartDefinition Body24 = RightArmSeg3.addOrReplaceChild("Body24", CubeListBuilder.create().texOffs(255, 326).addBox(-1.0F, -3.0F, -2.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.7814F, -1.5827F, -9.2473F, 1.6602F, -0.2173F, -0.0193F));

		PartDefinition Leg_r5 = Body24.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -1.5F, -1.5F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3241F, 0.8525F, 2.1658F, -0.0088F, 0.4082F, -0.6342F));

		PartDefinition Head_r4 = Body24.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.365F, 1.0059F, -4.1978F, 0.1344F, 0.0263F, -0.1684F));

		PartDefinition Arm_r11 = Body24.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(255, 326).addBox(-1.5F, -1.5F, -0.5F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6785F, -2.7301F, -5.7825F, 0.2187F, -0.6429F, -0.1325F));

		PartDefinition TorsoTop_r7 = Body24.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-4.25F, -1.25F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, -7.0F, 0.0699F, 0.2698F, -0.4077F));

		PartDefinition Body25 = RightArmSeg3.addOrReplaceChild("Body25", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.3754F, 9.3097F, 2.6929F, -2.5413F, 0.0082F, 0.2176F));

		PartDefinition TorsoBase_r5 = Body25.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -1.5F, -3.0F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8347F, 2.7363F, 2.2954F, -0.9443F, 0.4081F, 0.0114F));

		PartDefinition Arm_r12 = Body25.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(255, 326).addBox(-1.919F, -2.3303F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -0.4749F, -0.0861F, -0.0821F));

		PartDefinition Arm_r13 = Body25.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(255, 326).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.5679F, 0.5824F, 0.2421F));

		PartDefinition TorsoTop_r8 = Body25.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(255, 326).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r5 = Body25.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(255, 326).addBox(-3.5F, -4.75F, -2.5F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.46F, -1.4988F, 0.6701F, 0.0532F));

		PartDefinition RightArmSeg4 = RightArmSeg3.addOrReplaceChild("RightArmSeg4", CubeListBuilder.create().texOffs(404, 145).addBox(-18.0F, -10.5F, -7.5F, 19.0F, 18.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.9791F, -3.0202F, -0.9794F, 0.0019F, 0.0F, -0.8727F));

		PartDefinition RightHand = RightArmSeg4.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.2009F, 0.5593F, 0.2447F, 0.9163F, 0.0F, 0.0F));

		PartDefinition RightArmSeg_r1 = RightHand.addOrReplaceChild("RightArmSeg_r1", CubeListBuilder.create().texOffs(436, 54).addBox(-0.5F, -11.5F, -9.5F, 6.0F, 21.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2991F, -1.5593F, 1.5053F, 0.0F, 0.0F, -0.2182F));

		PartDefinition RightFinger1 = RightHand.addOrReplaceChild("RightFinger1", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6956F, 2.3648F, -7.1885F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Arm_r14 = RightFinger1.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(437, 73).addBox(-1.5F, -2.5F, -7.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8882F, -3.5571F, -0.3321F, -0.5236F, -0.7854F, 0.0F));

		PartDefinition TopTorso_r1 = RightFinger1.addOrReplaceChild("TopTorso_r1", CubeListBuilder.create().texOffs(437, 73).addBox(-2.08F, -3.4914F, -4.6766F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2306F, -0.0855F, -0.5769F, 0.0F, -0.1309F, 0.0F));

		PartDefinition RightFingerHead1 = RightFinger1.addOrReplaceChild("RightFingerHead1", CubeListBuilder.create().texOffs(437, 73).addBox(-3.0F, -4.0F, -7.0F, 6.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.3701F, 0.0794F, -5.0229F, 0.0F, 0.6109F, 0.0F));

		PartDefinition RightFinger2 = RightHand.addOrReplaceChild("RightFinger2", CubeListBuilder.create().texOffs(438, 76).addBox(-1.7741F, -4.0592F, -10.9355F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4364F, -7.6986F, -5.4035F, -0.8309F, -0.0589F, 0.0644F));

		PartDefinition Arm_r15 = RightFinger2.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(438, 76).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4617F, 3.7938F, -7.113F, 0.1603F, 0.2648F, -0.039F));

		PartDefinition Arm_r16 = RightFinger2.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(438, 76).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.0F, -8.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition Torso_r1 = RightFinger2.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(438, 76).addBox(-2.08F, -3.5086F, -4.6766F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6352F, 0.0086F, -1.3926F, 0.0F, -0.1309F, 0.0F));

		PartDefinition RightFinger3 = RightHand.addOrReplaceChild("RightFinger3", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.1666F, 1.859F, 9.1636F, -0.2618F, 0.0F, 0.0F));

		PartDefinition Arm_r17 = RightFinger3.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(439, 76).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.08F, -2.5551F, 2.5633F, 0.5965F, 0.5973F, -0.0566F));

		PartDefinition TopTorso_r2 = RightFinger3.addOrReplaceChild("TopTorso_r2", CubeListBuilder.create().texOffs(439, 76).addBox(-2.08F, -3.4914F, -1.3234F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3968F, -0.5818F, 0.943F, 0.0F, 0.1309F, 0.0F));

		PartDefinition RightFinger4 = RightHand.addOrReplaceChild("RightFinger4", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.4774F, -10.2267F, 7.251F, 1.0942F, 0.3979F, 0.6439F));

		PartDefinition Arm_r18 = RightFinger4.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5F, -2.5F, -1.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0039F, -2.6746F, 2.1705F, 0.4014F, -0.5936F, -0.0288F));

		PartDefinition Arm_r19 = RightFinger4.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5527F, -1.4174F, -0.8575F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2766F, 3.1988F, 2.2395F, -0.4478F, -0.2499F, -0.2361F));

		PartDefinition BottomTorso_r1 = RightFinger4.addOrReplaceChild("BottomTorso_r1", CubeListBuilder.create().texOffs(437, 75).addBox(-3.4246F, -3.7816F, -0.922F, 5.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.119F, 0.1903F, 1.3227F, 0.0617F, -0.3561F, -0.1119F));

		PartDefinition RightFingerHead4 = RightFinger4.addOrReplaceChild("RightFingerHead4", CubeListBuilder.create().texOffs(437, 75).addBox(-1.5F, -4.0F, -0.25F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(437, 75).addBox(-2.5F, -4.0F, 4.75F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4019F, -1.0F, 3.884F, 0.0F, -1.0472F, 0.0F));

		PartDefinition Body26 = RightArmSeg4.addOrReplaceChild("Body26", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.2105F, -10.8969F, 7.3088F, -2.0944F, -0.829F, 1.5708F));

		PartDefinition TorsoBase_r6 = Body26.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(255, 326).addBox(-9.761F, -0.3912F, -3.9958F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(255, 326).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6977F, 0.1321F, -0.6429F));

		PartDefinition Jaw_r1 = Body26.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(255, 326).addBox(0.0412F, -4.0001F, -1.4988F, 8.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.15F, -0.3F, 1.4305F, -0.0998F, 0.3135F));

		PartDefinition Head_r6 = Body26.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(255, 326).addBox(0.0412F, -4.0001F, -0.4988F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 2.15F, -0.3F, 0.6014F, -0.0998F, 0.3135F));

		PartDefinition Body27 = RightArmSeg4.addOrReplaceChild("Body27", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0818F, -10.2854F, -6.6102F, 0.2978F, -0.8471F, -0.5335F));

		PartDefinition Arm_r20 = Body27.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(255, 326).addBox(-7.0379F, -1.9918F, -0.722F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8245F, -2.6276F, 4.2411F, 0.4494F, 0.3479F, -0.6066F));

		PartDefinition TorsoBase_r7 = Body27.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(255, 326).addBox(-6.0F, -1.5F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0997F, 2.7397F, -0.652F, 0.761F, -0.0319F, -1.2425F));

		PartDefinition TorsoTop_r9 = Body27.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(255, 326).addBox(-3.761F, -1.1412F, -4.4958F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.6982F, -0.1364F, -0.8666F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Joint.zRot = -0.7f + Mth.sin(ageInTicks/10)/6;
		this.Joint2.xRot = Mth.sin(ageInTicks/9)/7;
		this.Foot.yRot = Mth.cos(ageInTicks/7)/6;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		RightArmJoint.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}