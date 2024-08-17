package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Experiments.Lacerator;
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

public class LaceratorModel<T extends Lacerator> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "lacerator"), "main");
	private final ModelPart jason;
	private final ModelPart Torso;
	private final ModelPart Head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart RightForArm;
	private final ModelPart LeftSegment1;
	private final ModelPart LeftSegment2;
	private final ModelPart LeftSegment3;
	private final ModelPart RightForLeg;
	private final ModelPart LeftForLeg;
	private final ModelPart Saw;
	private final ModelPart Gear1;
	private final ModelPart Gear2;
	private final ModelPart Gear3;

	public LaceratorModel(ModelPart root) {
		this.jason = root.getChild("jason");
		this.Torso = jason.getChild("torso").getChild("uppertorso");
		this.Head = Torso.getChild("head");
		this.RightArm = Torso.getChild("arms").getChild("rightarm");
		this.LeftArm = Torso.getChild("arms").getChild("leftarm");
		this.RightLeg = jason.getChild("legs").getChild("rightleg");
		this.LeftLeg = jason.getChild("legs").getChild("leftleg");
		this.RightForArm = RightArm.getChild("rightarmseg2");
		this.LeftSegment1 = LeftArm.getChild("leftarmseg2").getChild("leftarmchainseg1");
		this.LeftSegment2 = LeftSegment1.getChild("leftarmchainseg2");
		this.LeftSegment3 = LeftSegment2.getChild("leftarmchainseg3");
		this.RightForLeg = RightLeg.getChild("rightlegseg2");
		this.LeftForLeg = LeftLeg.getChild("leftlegseg2");
		this.Saw = RightForArm.getChild("saw");
		this.Gear1 = Torso.getChild("Engine").getChild("Gears").getChild("Gear1");
		this.Gear2 = Torso.getChild("Engine").getChild("Gears").getChild("Gear2");
		this.Gear3 = Torso.getChild("Engine").getChild("Gears").getChild("Gear3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition jason = partdefinition.addOrReplaceChild("jason", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition legs = jason.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F));

		PartDefinition rightleg = legs.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(50, 56).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(52, 20).addBox(-2.25F, 2.0F, -2.25F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition rightlegseg2 = rightleg.addOrReplaceChild("rightlegseg2", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Seg2_r1 = rightlegseg2.addOrReplaceChild("Seg2_r1", CubeListBuilder.create().texOffs(50, 56).mirror().addBox(-1.5F, -3.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition leftleg = legs.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(48, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 0.0F));

		PartDefinition leftlegseg2 = leftleg.addOrReplaceChild("leftlegseg2", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0F, 3.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Seg2_r2 = leftlegseg2.addOrReplaceChild("Seg2_r2", CubeListBuilder.create().texOffs(48, 55).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition torso = jason.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(34, 3).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

		PartDefinition uppertorso = torso.addOrReplaceChild("uppertorso", CubeListBuilder.create().texOffs(0, 13).addBox(-4.5F, -6.0F, -2.0F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(1.0F, -4.4F, -0.5F));

		PartDefinition head = uppertorso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -7.9F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(40, 13).addBox(-4.0F, -2.9F, 0.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -5.35F, 0.5F));

		PartDefinition Jaw = head.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offset(0.0F, -0.9F, 0.0F));

		PartDefinition LowerHeadBase_r1 = Jaw.addOrReplaceChild("LowerHeadBase_r1", CubeListBuilder.create().texOffs(40, 14).mirror().addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.01F, 0.0F, -2.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition mask = head.addOrReplaceChild("mask", CubeListBuilder.create().texOffs(51, 37).addBox(-4.0F, -3.9F, -0.95F, 8.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(38, 0).addBox(-4.0F, 1.1F, -0.95F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 60).addBox(-4.0F, -0.9F, -0.95F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(32, 56).addBox(3.0F, -0.9F, -0.95F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(23, 29).addBox(-3.0F, -0.9F, -0.7F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(-4.01F, -1.9F, -0.95F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 42).addBox(4.01F, -1.9F, -0.95F, 0.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(1, 51).addBox(-3.99F, -1.9F, 8.06F, 8.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.1F, -4.05F));

		PartDefinition headsaw = head.addOrReplaceChild("headsaw", CubeListBuilder.create().texOffs(31, 27).addBox(-0.5F, -4.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(41, 20).addBox(-0.5F, -5.5F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.5F))
		.texOffs(0, 63).addBox(-0.5F, -4.5F, -5.5F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.75F, -5.0F, 2.5F, 0.0F, 0.6981F, 0.0F));

		PartDefinition BackTeeth_r1 = headsaw.addOrReplaceChild("BackTeeth_r1", CubeListBuilder.create().texOffs(0, 63).addBox(-0.5F, -4.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 3.1416F, 0.0F, 0.0F));

		PartDefinition BottomTeeth_r1 = headsaw.addOrReplaceChild("BottomTeeth_r1", CubeListBuilder.create().texOffs(41, 20).addBox(-0.5F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition headcrowns = head.addOrReplaceChild("headcrowns", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.407F, -8.112F, 0.3895F, -0.5827F, 0.2865F, -0.1074F));

		PartDefinition Petal5_r1 = headcrowns.addOrReplaceChild("Petal5_r1", CubeListBuilder.create().texOffs(61, 0).addBox(-6.5222F, 0.2686F, -3.9213F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.5369F, -2.5058F, 0.6866F, -0.0306F, 0.1719F, -0.6135F));

		PartDefinition Petal4_r1 = headcrowns.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(61, 7).addBox(-1.832F, 0.6867F, -2.9621F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1532F, -0.9239F, 0.2273F, -0.2186F, -0.1937F, 0.6378F));

		PartDefinition Petal3_r1 = headcrowns.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(60, 14).addBox(-5.1925F, -0.1689F, -4.0074F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2072F, 0.9316F, -1.7274F, -0.6545F, 0.0F, 0.0F));

		PartDefinition Petal2_r1 = headcrowns.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(61, 0).addBox(-3.1925F, 0.8311F, -3.0074F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2072F, -1.0684F, 3.2726F, 0.7448F, -0.165F, -0.2534F));

		PartDefinition arms = uppertorso.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(-0.75F, 18.0F, 0.0F));

		PartDefinition rightarm = arms.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(16, 53).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.75F, -23.1F, 0.5F));

		PartDefinition ShoulderPad_r1 = rightarm.addOrReplaceChild("ShoulderPad_r1", CubeListBuilder.create().texOffs(41, 46).addBox(-2.5F, -2.0F, -2.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.5F, 0.0F, 0.0F, 0.1309F, 0.0F));

		PartDefinition rightarmseg2 = rightarm.addOrReplaceChild("rightarmseg2", CubeListBuilder.create().texOffs(57, 42).addBox(-2.0F, 0.0F, -1.5F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 53).addBox(-2.5F, 4.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 5.0F, 0.0F));

		PartDefinition SawAttachment_r1 = rightarmseg2.addOrReplaceChild("SawAttachment_r1", CubeListBuilder.create().texOffs(0, 56).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.0F, 0.0F, 1.5708F, 0.0F, 0.0F));

		PartDefinition saw = rightarmseg2.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(31, 27).addBox(-0.5F, -4.0F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(41, 20).addBox(-0.5F, -5.5F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.5F))
		.texOffs(0, 63).addBox(-0.5F, -4.5F, -5.5F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offset(-1.5F, 9.0F, 0.0F));

		PartDefinition BackTeeth_r2 = saw.addOrReplaceChild("BackTeeth_r2", CubeListBuilder.create().texOffs(0, 63).addBox(-0.5F, -4.5F, -1.0F, 1.0F, 9.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.5F, 3.1416F, 0.0F, 0.0F));

		PartDefinition BottomTeeth_r2 = saw.addOrReplaceChild("BottomTeeth_r2", CubeListBuilder.create().texOffs(41, 20).addBox(-0.5F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 4.5F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition leftarm = arms.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(16, 53).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.5F, -22.1F, 0.5F));

		PartDefinition leftarmseg2 = leftarm.addOrReplaceChild("leftarmseg2", CubeListBuilder.create().texOffs(57, 45).addBox(-1.75F, 0.0F, -0.75F, 2.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 5.0F, -0.5F));

		PartDefinition leftarmchainseg1 = leftarmseg2.addOrReplaceChild("leftarmchainseg1", CubeListBuilder.create().texOffs(8, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 0.0F, 0.3054F, 0.0F));

		PartDefinition leftarmchainseg2 = leftarmchainseg1.addOrReplaceChild("leftarmchainseg2", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -0.6109F, 0.0F));

		PartDefinition leftarmchainseg3 = leftarmchainseg2.addOrReplaceChild("leftarmchainseg3", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 34).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.6109F, 0.0F));

		PartDefinition uppertorsochain = uppertorso.addOrReplaceChild("uppertorsochain", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.25F, -5.1F, -1.5F, -0.1745F, 0.1745F, -0.7854F));

		PartDefinition uppertorsochainseg2 = uppertorsochain.addOrReplaceChild("uppertorsochainseg2", CubeListBuilder.create().texOffs(8, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.1793F, -0.5872F, -0.3161F));

		PartDefinition uppertorsochainseg3 = uppertorsochainseg2.addOrReplaceChild("uppertorsochainseg3", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.121F, 0.6003F, 0.212F));

		PartDefinition uppertorsochainseg4 = uppertorsochainseg3.addOrReplaceChild("uppertorsochainseg4", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 34).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.2618F, -0.6109F, 0.0F));

		PartDefinition uppertorsochainseg5 = uppertorsochainseg4.addOrReplaceChild("uppertorsochainseg5", CubeListBuilder.create().texOffs(8, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(8, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 2.75F, -0.5F, 0.9259F, -0.5195F, -0.9108F));

		PartDefinition uppertorsochainseg6 = uppertorsochainseg5.addOrReplaceChild("uppertorsochainseg6", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 34).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -0.5F, 0.6564F, 0.959F, -0.4793F));

		PartDefinition uppertorsochainseg7 = uppertorsochainseg6.addOrReplaceChild("uppertorsochainseg7", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -0.2076F, -0.8957F, -0.3518F));

		PartDefinition uppertorsochainseg8 = uppertorsochainseg7.addOrReplaceChild("uppertorsochainseg8", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 34).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 1.1251F, 0.2955F, 0.3565F));

		PartDefinition uppertorsochainseg9 = uppertorsochainseg8.addOrReplaceChild("uppertorsochainseg9", CubeListBuilder.create().texOffs(0, 30).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, 0.6694F, 0.2719F, 0.4958F));

		PartDefinition uppertorsochainseg10 = uppertorsochainseg9.addOrReplaceChild("uppertorsochainseg10", CubeListBuilder.create().texOffs(0, 24).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.25F, 0.0F, 0.2065F, 0.7284F, -0.6005F));

		PartDefinition uppertorsochainseg11 = uppertorsochainseg10.addOrReplaceChild("uppertorsochainseg11", CubeListBuilder.create().texOffs(0, 32).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 34).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 34).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 38).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 1.1899F, 0.1481F, 0.4524F));

		PartDefinition uppertorsochainseg12 = uppertorsochainseg11.addOrReplaceChild("uppertorsochainseg12", CubeListBuilder.create().texOffs(0, 30).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(-1.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(4, 26).addBox(0.5F, 0.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-1.5F, 3.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, 0.0F, -0.2997F, -0.7752F, 0.175F));

		PartDefinition Engine = uppertorso.addOrReplaceChild("Engine", CubeListBuilder.create().texOffs(5, 37).addBox(-4.5F, -2.0F, 1.0F, 8.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

		PartDefinition Bottom_r1 = Engine.addOrReplaceChild("Bottom_r1", CubeListBuilder.create().texOffs(6, 38).mirror().addBox(-3.49F, -1.5F, -1.5F, 7.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.2769F, 1.8968F, -0.6757F, 0.0585F, 0.0606F));

		PartDefinition Thermostat = Engine.addOrReplaceChild("Thermostat", CubeListBuilder.create().texOffs(36, 13).addBox(-1.4724F, -1.4448F, -0.6631F, 3.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(11, 38).addBox(0.5276F, -1.4448F, -0.4631F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(11, 38).addBox(-1.4724F, -1.4448F, -0.4631F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(11, 38).addBox(-1.4734F, -1.4438F, -0.4621F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(11, 38).addBox(-1.4734F, 0.5562F, -0.4621F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(2.0724F, -0.7631F, 4.1948F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Needle_r1 = Thermostat.addOrReplaceChild("Needle_r1", CubeListBuilder.create().texOffs(124, 117).addBox(-0.5F, -0.5F, -0.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0276F, -0.7948F, 0.0269F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Wires = Engine.addOrReplaceChild("Wires", CubeListBuilder.create(), PartPose.offset(1.5F, -2.3604F, 0.7713F));

		PartDefinition Wires_r1 = Wires.addOrReplaceChild("Wires_r1", CubeListBuilder.create().texOffs(6, 41).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.9599F, 0.0F, 0.0F));

		PartDefinition Wires_r2 = Wires.addOrReplaceChild("Wires_r2", CubeListBuilder.create().texOffs(10, 40).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.6104F, 1.2287F, 0.9599F, 0.0F, 0.0F));

		PartDefinition Wires_r3 = Wires.addOrReplaceChild("Wires_r3", CubeListBuilder.create().texOffs(19, 41).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.3604F, 1.7287F, 0.9599F, 0.0F, 0.0F));

		PartDefinition Gears = Engine.addOrReplaceChild("Gears", CubeListBuilder.create(), PartPose.offset(-6.0F, -0.75F, 2.0F));

		PartDefinition Gear1 = Gears.addOrReplaceChild("Gear1", CubeListBuilder.create().texOffs(19, 41).addBox(-0.4991F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5001F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(20, 42).addBox(-0.5001F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.7501F, -1.0F, 1.75F, -0.3927F, 0.0F, 0.0F));

		PartDefinition Tooth_r1 = Gear1.addOrReplaceChild("Tooth_r1", CubeListBuilder.create().texOffs(20, 42).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r2 = Gear1.addOrReplaceChild("Tooth_r2", CubeListBuilder.create().texOffs(20, 42).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r3 = Gear1.addOrReplaceChild("Tooth_r3", CubeListBuilder.create().texOffs(14, 40).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Gear2 = Gears.addOrReplaceChild("Gear2", CubeListBuilder.create().texOffs(9, 39).addBox(-0.4991F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(14, 40).addBox(-0.5001F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(14, 40).addBox(-0.5001F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(4.7501F, 0.75F, 2.25F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Tooth_r4 = Gear2.addOrReplaceChild("Tooth_r4", CubeListBuilder.create().texOffs(6, 42).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(14, 40).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r5 = Gear2.addOrReplaceChild("Tooth_r5", CubeListBuilder.create().texOffs(14, 40).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(20, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r6 = Gear2.addOrReplaceChild("Tooth_r6", CubeListBuilder.create().texOffs(14, 40).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(20, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Gear3 = Gears.addOrReplaceChild("Gear3", CubeListBuilder.create().texOffs(14, 40).addBox(-0.4991F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5001F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(14, 40).addBox(-0.5001F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(3.2501F, 2.0F, 1.75F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Tooth_r7 = Gear3.addOrReplaceChild("Tooth_r7", CubeListBuilder.create().texOffs(14, 40).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(20, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, 2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r8 = Gear3.addOrReplaceChild("Tooth_r8", CubeListBuilder.create().texOffs(14, 40).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(9, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -2.3562F, 0.0F, 0.0F));

		PartDefinition Tooth_r9 = Gear3.addOrReplaceChild("Tooth_r9", CubeListBuilder.create().texOffs(9, 42).addBox(-0.5F, 0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F))
		.texOffs(20, 42).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0001F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition enginevents = Engine.addOrReplaceChild("enginevents", CubeListBuilder.create(), PartPose.offset(0.1F, 2.4F, 3.5F));

		PartDefinition event1 = enginevents.addOrReplaceChild("event1", CubeListBuilder.create().texOffs(5, 40).mirror().addBox(0.0296F, -5.7259F, -0.99F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)).mirror(false)
		.texOffs(10, 41).addBox(1.0296F, -7.2259F, -0.99F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(2.4194F, 0.5062F, -0.98F, 0.1068F, 0.3786F, 0.2823F));

		PartDefinition V1Seg1_r1 = event1.addOrReplaceChild("V1Seg1_r1", CubeListBuilder.create().texOffs(6, 39).addBox(-1.1071F, -3.0252F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.1909F, -0.5482F, -0.02F, 0.0F, 0.0F, 0.3491F));

		PartDefinition event2 = enginevents.addOrReplaceChild("event2", CubeListBuilder.create().texOffs(13, 40).addBox(0.5806F, -4.5997F, -1.3147F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.35F))
		.texOffs(13, 40).addBox(1.5816F, -5.8997F, -1.3147F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(2.1981F, -0.87F, -0.0731F, -0.0289F, -0.2163F, 0.134F));

		PartDefinition V2Seg2_r1 = event2.addOrReplaceChild("V2Seg2_r1", CubeListBuilder.create().texOffs(13, 40).addBox(-1.1071F, -3.0252F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(0.1919F, -0.122F, -0.3447F, 0.0F, 0.0F, 0.6545F));

		PartDefinition torsofungus = torso.addOrReplaceChild("torsofungus", CubeListBuilder.create(), PartPose.offset(1.9407F, -2.7892F, -0.3475F));

		PartDefinition Fungus_r1 = torsofungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(61, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -4.2108F, -0.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r2 = torsofungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(61, 14).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4407F, -1.2108F, -0.1025F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r3 = torsofungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(61, 7).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, 1.7892F, 1.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r4 = torsofungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(61, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 1.7892F, -1.1025F, 0.1783F, -0.2977F, -0.0909F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateLeftArm(ModelPart part, float value){
		part.xRot = Mth.sin(value/8)/10;
	}
	private void animateRightArm(ModelPart part,float value,T entity){
		if (entity.isAggressive()){
			part.xRot = -1.2f + Mth.cos(value/7)/9;
		}else{
			part.xRot = Mth.cos(value/7)/9;
		}
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.6F) * 0.6F * -limbSwingAmount;
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.LeftForLeg.xRot = this.LeftLeg.xRot < 0 ? -this.LeftLeg.xRot : 0;
		this.RightForLeg.xRot = this.RightLeg.xRot < 0 ? -this.RightLeg.xRot : 0;
		animateLeftArm(LeftArm,ageInTicks);
		animateRightArm(RightArm,ageInTicks,entity);
		if (entity.isAggressive()){
			RightForArm.xRot = -0.8f;
		}else{
			this.RightForArm.xRot = this.RightArm.xRot < 0 ? this.RightArm.xRot : 0;
		}
		animateLeftArm(LeftSegment1,ageInTicks);
		animateLeftArm(LeftSegment2,ageInTicks);
		animateLeftArm(LeftSegment3,ageInTicks);
		this.Saw.xRot = ageInTicks/2;
		this.Gear1.xRot = ageInTicks/2;
		this.Gear2.xRot = -ageInTicks/2;
		this.Gear3.xRot = ageInTicks;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		jason.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}