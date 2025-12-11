package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.EvolvedInfected.Stalker;
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

public class StalkerModel<T extends Stalker> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "stalkermodelnew"), "main");
	private final ModelPart head;
	private final ModelPart fungus;
	private final ModelPart nose;
	private final ModelPart jaw;
	private final ModelPart flower;
	private final ModelPart flower2;
	private final ModelPart LeftShootoff1;
	private final ModelPart Seg3;
	private final ModelPart Fangs;
	private final ModelPart body;
	private final ModelPart spine2;
	private final ModelPart RightArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightLeg;
	private final ModelPart rightForLeg;
	private final ModelPart LeftLeg;
	private final ModelPart leftForLeg;

	public StalkerModel(ModelPart root) {
		this.head = root.getChild("head");
		this.fungus = this.head.getChild("fungus");
		this.nose = this.head.getChild("nose");
		this.jaw = this.head.getChild("jaw");
		this.flower = this.head.getChild("flower");
		this.flower2 = this.flower.getChild("flower2");
		this.LeftShootoff1 = this.head.getChild("LeftShootoff1");
		this.Seg3 = this.head.getChild("Seg3");
		this.Fangs = this.head.getChild("Fangs");
		this.body = root.getChild("body");
		this.spine2 = this.body.getChild("spine2");
		this.RightArm = root.getChild("RightArm");
		this.RightForArm = this.RightArm.getChild("RightForArm");
		this.LeftArm = root.getChild("LeftArm");
		this.LeftForArm = this.LeftArm.getChild("LeftForArm");
		this.RightLeg = root.getChild("RightLeg");
		this.rightForLeg = this.RightLeg.getChild("rightForLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.leftForLeg = this.LeftLeg.getChild("leftForLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 21).mirror().addBox(-3.5392F, -1.7037F, -4.9741F, 7.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 15).mirror().addBox(-4.0392F, -9.7037F, -4.9741F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(0, 10).mirror().addBox(-1.0F, -9.7F, -5.0F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(4, 23).mirror().addBox(-1.0F, -10.7F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(61, 48).mirror().addBox(-4.0392F, -1.7037F, 1.0259F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(32, 17).mirror().addBox(3.9608F, -1.7037F, -4.9741F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(32, 19).mirror().addBox(-4.0392F, -1.7037F, -3.9741F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -3.5F, -0.75F));

		PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 7).mirror().addBox(2.0F, -37.0F, -5.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 26.3F, 4.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(26, 8).mirror().addBox(3.5F, -33.0F, -5.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 26.3F, 4.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition fungus = head.addOrReplaceChild("fungus", CubeListBuilder.create().texOffs(-6, 75).mirror().addBox(0.0F, -32.7F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 26.0F, 4.0F));

		PartDefinition cube_r3 = fungus.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-6, 75).mirror().addBox(-2.0F, -32.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r4 = fungus.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-6, 75).mirror().addBox(-2.0F, -34.0F, -2.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.2618F, 0.0F, -0.1745F));

		PartDefinition cube_r5 = fungus.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-6, 75).mirror().addBox(-11.75F, -30.75F, -3.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.3F, 0.0F, 0.228F, -0.1298F, 0.3342F));

		PartDefinition nose = head.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 15).mirror().addBox(-1.0392F, -0.7037F, -5.9741F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -2.0F, -1.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(24, 15).mirror().addBox(-4.0392F, -0.7037F, -5.9741F, 8.0F, 2.0F, 6.0F, new CubeDeformation(-0.05F)).mirror(false), PartPose.offset(0.0F, -1.0F, 1.0F));

		PartDefinition flower = head.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -7.0F, -3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r6 = flower.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(14, 85).mirror().addBox(-3.0521F, 0.273F, -5.8869F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -2.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r7 = flower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 93).mirror().addBox(-0.1612F, 0.253F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition flower2 = flower.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 1.0F, 2.0F, 0.2182F, 0.0F, 0.3927F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(70, 23).mirror().addBox(-3.8852F, 0.227F, -0.159F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r9 = flower2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(18, 71).mirror().addBox(-5.7904F, 0.2061F, -3.06F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r10 = flower2.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(88, 24).mirror().addBox(-3.8852F, 0.273F, -7.9519F, 9.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r11 = flower2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(88, 15).mirror().addBox(0.0025F, 0.2939F, -4.06F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r12 = flower2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(70, 15).mirror().addBox(-7.7904F, 0.2061F, -4.06F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition LeftShootoff1 = head.addOrReplaceChild("LeftShootoff1", CubeListBuilder.create(), PartPose.offsetAndRotation(5.7654F, -8.7778F, 0.3215F, 0.2618F, -0.6545F, 0.0F));

		PartDefinition AntlerShootoff2_r1 = LeftShootoff1.addOrReplaceChild("AntlerShootoff2_r1", CubeListBuilder.create().texOffs(120, 126).mirror().addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4419F, 0.4366F, -1.1468F));

		PartDefinition AntlerShootoff1Shootoff_r1 = LeftShootoff1.addOrReplaceChild("AntlerShootoff1Shootoff_r1", CubeListBuilder.create().texOffs(120, 126).mirror().addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-1.5873F, 1.2809F, 0.8533F, -0.1002F, 1.2415F, -0.633F));

		PartDefinition AntlerShootoff1_r1 = LeftShootoff1.addOrReplaceChild("AntlerShootoff1_r1", CubeListBuilder.create().texOffs(112, 124).mirror().addBox(-2.2188F, -1.0493F, -0.453F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-2.3435F, 1.9642F, 1.3108F, -0.2351F, 0.5692F, -0.7236F));

		PartDefinition Seg3 = head.addOrReplaceChild("Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.1017F, -7.6662F, -0.1249F, -0.2106F, -0.1177F, 0.0452F));

		PartDefinition AntlerSeg5_r1 = Seg3.addOrReplaceChild("AntlerSeg5_r1", CubeListBuilder.create().texOffs(112, 121).mirror().addBox(-3.1F, -0.75F, -0.85F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)).mirror(false), PartPose.offsetAndRotation(-2.9829F, -1.4668F, -0.1752F, 0.0F, 0.2618F, 0.0436F));

		PartDefinition AntlerSeg6_r1 = Seg3.addOrReplaceChild("AntlerSeg6_r1", CubeListBuilder.create().texOffs(106, 121).mirror().addBox(-4.1F, -0.75F, -1.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offsetAndRotation(-2.9829F, -1.4668F, -0.1752F, 0.2182F, -0.2618F, 0.6981F));

		PartDefinition AnterShootoff4_r1 = Seg3.addOrReplaceChild("AnterShootoff4_r1", CubeListBuilder.create().texOffs(116, 125).mirror().addBox(-4.5F, -0.75F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.1892F, 0.0124F, -0.0751F, -0.4137F, 0.2507F, 1.4743F));

		PartDefinition AntlerSeg4_r1 = Seg3.addOrReplaceChild("AntlerSeg4_r1", CubeListBuilder.create().texOffs(105, 123).mirror().addBox(-3.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.1892F, 0.0124F, -0.0751F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Fangs = head.addOrReplaceChild("Fangs", CubeListBuilder.create(), PartPose.offset(-0.375F, -5.925F, -4.95F));

		PartDefinition Fang3_r1 = Fangs.addOrReplaceChild("Fang3_r1", CubeListBuilder.create().texOffs(5, 0).addBox(-0.5F, -0.5118F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 4.4881F, -0.1082F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition Fang1_r1 = Fangs.addOrReplaceChild("Fang1_r1", CubeListBuilder.create().texOffs(5, 0).addBox(-0.5F, -0.5F, 0.1F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.5F, -0.25F, -0.4363F, 0.3491F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(29, 42).addBox(-4.25F, 10.05F, -1.5F, 8.5F, 3.0F, 4.75F, new CubeDeformation(0.0F))
				.texOffs(27, 25).addBox(-4.0F, 4.8F, -1.5F, 8.0F, 6.0F, 4.75F, new CubeDeformation(-0.1F))
				.texOffs(-6, 75).addBox(-3.0F, 8.3F, 0.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition spine2 = body.addOrReplaceChild("spine2", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.0F, -1.7F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(-6, 75).addBox(-1.0F, 0.3F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(-6, 75).addBox(-6.0F, 2.3F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(-6, 75).addBox(-3.0F, -3.7F, -4.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(-6, 75).addBox(-1.0F, 3.3F, -2.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 4.75F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r13 = spine2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-6, 75).addBox(1.75F, -21.75F, -1.5F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, 0.228F, 0.1298F, -0.3342F));

		PartDefinition cube_r14 = spine2.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-6, 75).addBox(-6.25F, -15.75F, 5.25F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, 0.5663F, -0.0226F, 0.2588F));

		PartDefinition cube_r15 = spine2.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(4, 18).addBox(-3.0F, -19.0F, -20.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.3F, -3.25F, -0.829F, 0.0F, 0.0F));

		PartDefinition cube_r16 = spine2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 2.75F, -9.25F, 10.0F, 8.0F, 7.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, -8.7F, -3.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(28, 38).addBox(-2.0F, -1.7F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.75F, -2.0F, 0.25F));

		PartDefinition cube_r17 = RightArm.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(26, 8).addBox(-2.0442F, -3.1954F, -1.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 1.3F, 0.25F, 0.5807F, 0.5704F, 0.3841F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(39, 2).addBox(-2.0F, 0.3F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F))
				.texOffs(1, 66).addBox(-4.0F, 4.0F, 1.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(1, 66).addBox(-4.0F, 4.0F, -1.0F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(28, 38).addBox(-1.0F, -1.7F, -2.5F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.75F, -2.0F, 0.75F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(46, 39).addBox(-1.0F, 0.3F, -2.75F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F))
				.texOffs(46, 63).addBox(-1.0F, 4.0F, -1.5F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(46, 63).addBox(-1.0F, 4.0F, 0.5F, 4.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(28, 37).addBox(-3.0F, -0.7F, -1.75F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4F, 11.75F, 0.75F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(1, 43).addBox(-3.0F, 0.3F, -1.75F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(44, 37).addBox(-1.25F, -0.7F, -1.75F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.4F, 11.75F, 0.75F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(60, 22).addBox(-1.25F, 0.3F, -1.75F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity.swinging){
			this.RightArm.xRot = -89.5f + (headPitch /  ( 90F / (float) Math.PI));
			this.LeftArm.xRot = this.RightArm.xRot;
		}
		else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)) {
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
			this.RightForArm.xRot = RightArm.xRot < 0 ? RightArm.xRot : 0;
			this.LeftForArm.xRot = LeftArm.xRot < 0 ? LeftArm.xRot : 0;
		} else {
			this.RightArm.xRot = Mth.sin(ageInTicks / 8) / 10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks / 8) / 10;
		}
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * -limbSwingAmount;
		this.rightForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		this.leftForLeg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;

		this.jaw.xRot = Mth.sin(ageInTicks / 8) / 10;
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (90F / (float) Math.PI);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}