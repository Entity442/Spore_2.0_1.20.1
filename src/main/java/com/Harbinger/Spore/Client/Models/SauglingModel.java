// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

package com.Harbinger.Spore.Client.Models;
import com.Harbinger.Spore.Sentities.Experiments.Saugling;
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

public class SauglingModel<T extends Saugling> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "saugling"), "main");
	private final ModelPart saugling;
	private final ModelPart body;
	private final ModelPart tumor;
	private final ModelPart leftLeg;
	private final ModelPart leftForleg;
	private final ModelPart rightLeg;
	private final ModelPart rightForleg;
	private final ModelPart head;
	private final ModelPart top;
	private final ModelPart tentacle2;
	private final ModelPart minit2;
	private final ModelPart tentacle1;
	private final ModelPart minit;
	private final ModelPart tentacle;
	private final ModelPart bone22;
	private final ModelPart tentacle3;
	private final ModelPart minit3;
	private final ModelPart brain;
	private final ModelPart tail;
	private final ModelPart tail2;
	private final ModelPart tail3;
	private final ModelPart tail4;
	private final ModelPart tail5;
	private final ModelPart tail6;
	private final ModelPart tail7;
	private final ModelPart tail8;
	private final ModelPart leftArm;
	private final ModelPart leftForArm;
	private final ModelPart leftTentacle;
	private final ModelPart rightArm;
	private final ModelPart leftFormArm;
	private final ModelPart leftTentacle2;
	private final ModelPart leftArm2;
	private final ModelPart leftForArm2;
	private final ModelPart leftTentacle3;
	private final ModelPart rightArm2;
	private final ModelPart leftFormArm2;
	private final ModelPart leftTentacle4;

	public SauglingModel(ModelPart root) {
		this.saugling = root.getChild("saugling");
		this.body = this.saugling.getChild("body");
		this.tumor = this.body.getChild("tumor");
		this.leftLeg = this.saugling.getChild("leftLeg");
		this.leftForleg = this.leftLeg.getChild("leftForleg");
		this.rightLeg = this.saugling.getChild("rightLeg");
		this.rightForleg = this.rightLeg.getChild("rightForleg");
		this.head = this.saugling.getChild("head");
		this.top = this.head.getChild("top");
		this.tentacle2 = this.head.getChild("tentacle2");
		this.minit2 = this.tentacle2.getChild("minit2");
		this.tentacle1 = this.head.getChild("tentacle1");
		this.minit = this.tentacle1.getChild("minit");
		this.tentacle = this.head.getChild("tentacle");
		this.bone22 = this.tentacle.getChild("bone22");
		this.tentacle3 = this.head.getChild("tentacle3");
		this.minit3 = this.tentacle3.getChild("minit3");
		this.brain = this.head.getChild("brain");
		this.tail = this.saugling.getChild("tail");
		this.tail2 = this.tail.getChild("tail2");
		this.tail3 = this.tail2.getChild("tail3");
		this.tail4 = this.tail3.getChild("tail4");
		this.tail5 = this.tail4.getChild("tail5");
		this.tail6 = this.tail5.getChild("tail6");
		this.tail7 = this.tail6.getChild("tail7");
		this.tail8 = this.tail7.getChild("tail8");
		this.leftArm = this.saugling.getChild("leftArm");
		this.leftForArm = this.leftArm.getChild("leftForArm");
		this.leftTentacle = this.leftForArm.getChild("leftTentacle");
		this.rightArm = this.saugling.getChild("rightArm");
		this.leftFormArm = this.rightArm.getChild("leftFormArm");
		this.leftTentacle2 = this.leftFormArm.getChild("leftTentacle2");
		this.leftArm2 = this.saugling.getChild("leftArm2");
		this.leftForArm2 = this.leftArm2.getChild("leftForArm2");
		this.leftTentacle3 = this.leftForArm2.getChild("leftTentacle3");
		this.rightArm2 = this.saugling.getChild("rightArm2");
		this.leftFormArm2 = this.rightArm2.getChild("leftFormArm2");
		this.leftTentacle4 = this.leftFormArm2.getChild("leftTentacle4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition saugling = partdefinition.addOrReplaceChild("saugling", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 15.35F, 4.85F, 0.829F, 0.0F, 0.0F));

		PartDefinition body = saugling.addOrReplaceChild("body", CubeListBuilder.create().texOffs(25, 34).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -3.35F, -3.85F));

		PartDefinition Fungus_r1 = body.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, 4.05F, -2.95F, 0.2641F, 0.2697F, 0.0094F));

		PartDefinition Fungus_r2 = body.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(29, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.05F, 1.85F, -0.1305F, 0.1003F, -0.1442F));

		PartDefinition Fungus_r3 = body.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(29, 8).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 3.35F, 1.85F, -0.126F, -0.4536F, -0.0704F));

		PartDefinition tumor = body.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(1.0404F, 0.6377F, -1.3935F));

		PartDefinition Tumor_r1 = tumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(68, 49).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2278F, -0.3461F, -1.1971F));

		PartDefinition Tumor_r2 = tumor.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(54, 24).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7904F, 1.0272F, -0.0778F, -0.2978F, -0.1848F, -0.5394F));

		PartDefinition Tumor_r3 = tumor.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(58, 69).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 1.4923F, -0.2995F, -1.0681F));

		PartDefinition leftLeg = saugling.addOrReplaceChild("leftLeg", CubeListBuilder.create().texOffs(17, 67).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 2.65F, -4.25F));

		PartDefinition leftForleg = leftLeg.addOrReplaceChild("leftForleg", CubeListBuilder.create().texOffs(63, 33).addBox(-1.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition rightLeg = saugling.addOrReplaceChild("rightLeg", CubeListBuilder.create().texOffs(63, 41).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 2.65F, -4.45F));

		PartDefinition rightForleg = rightLeg.addOrReplaceChild("rightForleg", CubeListBuilder.create().texOffs(58, 61).addBox(-2.0F, 0.0F, -1.0F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition head = saugling.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -7.05F, -3.55F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Fungus_r4 = head.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(0, 16).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, -4.35F, -2.25F, 0.2871F, -0.4824F, -0.1475F));

		PartDefinition Fungus_r5 = head.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(0, 24).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, -1.75F, 1.35F, 0.0749F, -0.3377F, 0.2372F));

		PartDefinition Fungus_r6 = head.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(0, 8).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2F, -3.05F, 1.85F, 0.3099F, -0.5758F, -0.5381F));

		PartDefinition Fungus_r7 = head.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(29, 16).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 0.45F, 3.65F, -0.0661F, -0.2977F, -0.0909F));

		PartDefinition head_r1 = head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(58, 18).addBox(-3.0F, 0.7F, 1.0F, 6.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(29, 24).addBox(-3.0F, -2.3F, -3.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3142F, 0.0F, 0.0F));

		PartDefinition top = head.addOrReplaceChild("top", CubeListBuilder.create(), PartPose.offset(0.0F, -0.8F, 3.2F));

		PartDefinition head_r2 = top.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(0, 32).addBox(-3.0F, -2.3256F, -5.7932F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition tentacle2 = head.addOrReplaceChild("tentacle2", CubeListBuilder.create(), PartPose.offset(-2.1F, 1.1F, 0.4F));

		PartDefinition cube_r1 = tentacle2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 34).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 0.9F, -0.3F, -0.0873F, 0.2618F, 0.0F));

		PartDefinition minit2 = tentacle2.addOrReplaceChild("minit2", CubeListBuilder.create(), PartPose.offset(-2.0F, 0.0F, -5.0F));

		PartDefinition cube_r2 = minit2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(51, 52).addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.384F, 0.5585F, 0.0F));

		PartDefinition tentacle1 = head.addOrReplaceChild("tentacle1", CubeListBuilder.create(), PartPose.offset(-1.7F, 1.3F, 0.3F));

		PartDefinition cube_r3 = tentacle1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(46, 43).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 0.7F, -0.2F, 0.3031F, 0.1481F, -0.0627F));

		PartDefinition minit = tentacle1.addOrReplaceChild("minit", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, -5.0F));

		PartDefinition cube_r4 = minit.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 59).addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.8573F, 0.0516F, 0.1229F));

		PartDefinition tentacle = head.addOrReplaceChild("tentacle", CubeListBuilder.create(), PartPose.offset(-0.4F, -0.5F, -1.6F));

		PartDefinition cube_r5 = tentacle.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 41).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 1.7F, 1.7F, -0.19F, 0.1508F, 0.1298F));

		PartDefinition bone22 = tentacle.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.6F));

		PartDefinition cube_r6 = bone22.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(58, 0).addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1396F, -0.3665F, 0.0F));

		PartDefinition tentacle3 = head.addOrReplaceChild("tentacle3", CubeListBuilder.create(), PartPose.offset(1.2F, 0.1F, 0.3F));

		PartDefinition cube_r7 = tentacle3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 50).addBox(-1.0F, -2.0F, -5.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 1.2F, -1.2F, 0.0873F, -0.3316F, 0.0F));

		PartDefinition minit3 = tentacle3.addOrReplaceChild("minit3", CubeListBuilder.create(), PartPose.offset(1.0F, 1.0F, -6.0F));

		PartDefinition cube_r8 = minit3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(58, 9).addBox(0.0F, -1.0F, -6.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4573F, 0.2299F, 0.1473F));

		PartDefinition brain = head.addOrReplaceChild("brain", CubeListBuilder.create(), PartPose.offset(-2.764F, -1.7588F, 2.836F));

		PartDefinition Right_r1 = brain.addOrReplaceChild("Right_r1", CubeListBuilder.create().texOffs(71, 22).addBox(1.0F, -1.0F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.2F))
				.texOffs(0, 68).addBox(2.0F, -1.0F, -4.0F, 2.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(30, 71).addBox(3.5F, -1.0F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3316F, 0.0F, 0.0F));

		PartDefinition tail = saugling.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 1.35F, -3.05F, -0.3491F, 0.0F, 0.0F));

		PartDefinition cube_r9 = tail.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(71, 56).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.7F, 1.5F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r10 = tail.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(75, 14).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, -0.5F, -0.2F, -1.1152F, 0.0121F, -0.0214F));

		PartDefinition tail2 = tail.addOrReplaceChild("tail2", CubeListBuilder.create(), PartPose.offset(0.0F, 1.5F, 3.0F));

		PartDefinition cube_r11 = tail2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 30).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 1.3F, 0.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create(), PartPose.offset(0.0F, 2.5F, 2.0F));

		PartDefinition cube_r12 = tail3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(75, 8).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.4F, -0.9076F, 0.0F, 0.0F));

		PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create(), PartPose.offset(0.0F, 2.0F, 1.5F));

		PartDefinition cube_r13 = tail4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 76).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 0.9F, 0.0F, -0.6458F, 0.0F, 0.0F));

		PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 1.75F));

		PartDefinition cube_r14 = tail5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(13, 75).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.3F, 0.55F, -0.2967F, 0.0F, 0.0F));

		PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 2.75F));

		PartDefinition cube_r15 = tail6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 36).addBox(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4F, 1.25F, 0.6F, -0.192F, 0.0F, 0.0F));

		PartDefinition tail7 = tail6.addOrReplaceChild("tail7", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 3.0F));

		PartDefinition cube_r16 = tail7.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(71, 62).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.9F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition tail8 = tail7.addOrReplaceChild("tail8", CubeListBuilder.create(), PartPose.offset(0.0F, -0.25F, 0.0F));

		PartDefinition cube_r17 = tail8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(17, 56).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.75F, 0.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition leftArm = saugling.addOrReplaceChild("leftArm", CubeListBuilder.create().texOffs(32, 61).addBox(-1.5F, -1.2F, -1.6F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5F, -4.15F, -3.25F, -1.1781F, 0.0F, 0.0F));

		PartDefinition leftForArm = leftArm.addOrReplaceChild("leftForArm", CubeListBuilder.create().texOffs(75, 0).addBox(-1.1F, -0.2F, -1.1F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leftTentacle = leftForArm.addOrReplaceChild("leftTentacle", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition cube_r18 = leftTentacle.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(41, 71).addBox(0.0F, -2.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 1.8675F, 0.0F, 0.0F));

		PartDefinition cube_r19 = leftTentacle.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(55, 76).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.8F, 0.8F, 0.4363F, 0.0F, 0.0F));

		PartDefinition rightArm = saugling.addOrReplaceChild("rightArm", CubeListBuilder.create().texOffs(45, 61).addBox(-1.5F, -1.2F, -1.6F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -4.15F, -3.25F, -1.1781F, 0.0F, 0.0F));

		PartDefinition leftFormArm = rightArm.addOrReplaceChild("leftFormArm", CubeListBuilder.create().texOffs(71, 68).addBox(-1.0F, -0.2F, -1.1F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition leftTentacle2 = leftFormArm.addOrReplaceChild("leftTentacle2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r20 = leftTentacle2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(48, 71).addBox(0.0F, -2.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 1.8675F, 0.0F, 0.0F));

		PartDefinition cube_r21 = leftTentacle2.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(76, 42).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.8F, 0.8F, 0.4363F, 0.0F, 0.0F));

		PartDefinition leftArm2 = saugling.addOrReplaceChild("leftArm2", CubeListBuilder.create().texOffs(32, 61).addBox(-1.5F, -1.2F, -1.6F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, 0.85F, -3.75F, -1.6064F, -0.6065F, 0.6821F));

		PartDefinition leftForArm2 = leftArm2.addOrReplaceChild("leftForArm2", CubeListBuilder.create().texOffs(75, 0).addBox(-1.1F, -0.2F, -1.1F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.9163F, 0.0F, 0.0F));

		PartDefinition leftTentacle3 = leftForArm2.addOrReplaceChild("leftTentacle3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -1.309F, 0.0F, 0.0F));

		PartDefinition cube_r22 = leftTentacle3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(41, 71).addBox(0.0F, -2.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 1.8675F, 0.0F, 0.0F));

		PartDefinition cube_r23 = leftTentacle3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(55, 76).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.8F, 0.8F, 0.4363F, 0.0F, 0.0F));

		PartDefinition rightArm2 = saugling.addOrReplaceChild("rightArm2", CubeListBuilder.create().texOffs(45, 61).addBox(-1.5F, -1.2F, -1.6F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.85F, -3.75F, -1.4867F, 0.5608F, -0.2404F));

		PartDefinition leftFormArm2 = rightArm2.addOrReplaceChild("leftFormArm2", CubeListBuilder.create().texOffs(71, 68).addBox(-1.0F, -0.2F, -1.1F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition leftTentacle4 = leftFormArm2.addOrReplaceChild("leftTentacle4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -1.309F, 0.0F, 0.0F));

		PartDefinition cube_r24 = leftTentacle4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(48, 71).addBox(0.0F, -2.0F, -1.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 3.0F, 1.8675F, 0.0F, 0.0F));

		PartDefinition cube_r25 = leftTentacle4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(76, 42).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.8F, 0.8F, 0.4363F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float tailMovement = (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) ? Mth.cos(ageInTicks/10)/10 : Mth.cos(ageInTicks/8)/8;
		this.animateTentacleY(tail,tailMovement);
		this.animateTentacleY(tail2,tailMovement);
		this.animateTentacleY(tail3,tailMovement);
		this.animateTentacleY(tail4,tailMovement);
		this.animateTentacleY(tail5,tailMovement);
		this.animateTentacleY(tail6,tailMovement);
		this.animateTentacleY(tail7,tailMovement);
		this.animateTentacleY(this.head,netHeadYaw / (180F / (float) Math.PI));
		float tentacles = Mth.sin(ageInTicks/5)/3;
		float tentacles1 = Mth.sin(ageInTicks/5)/3;
		animateTentacleY(tentacle2,tentacles);
		animateTentacleY(tentacle3,-tentacles);
		animateTentacleX(tentacle1,tentacles);
		animateTentacleX(tentacle,-tentacles);
		animateTentacleY(minit2,tentacles1);
		animateTentacleY(minit3,-tentacles1);
		animateTentacleX(minit,tentacles1);
		animateTentacleX(bone22,-tentacles1);
		float moveV = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		animateTentacleX(leftArm,moveV);
		animateTentacleX(rightArm,-moveV);
		animateTentacleY(leftArm2,moveV);
		animateTentacleY(rightArm2,-moveV);
		animateTentacleX(leftLeg,moveV/2);
		animateTentacleX(rightLeg,-moveV/2);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		saugling.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}