package com.Harbinger.Spore.Client.Models;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Inebriator;
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

public class InebriaterModel<T extends Inebriator> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "inebriater"), "main");
	private final ModelPart thecrackie;
	private final ModelPart theboogaloo;
	private final ModelPart RightLeg;
	private final ModelPart rigtForLeg;
	private final ModelPart LeftArm;
	private final ModelPart TheCard;
	private final ModelPart LeftLeg;
	private final ModelPart leftForleg;
	private final ModelPart Head;
	private final ModelPart Torso;
	private final ModelPart RightArm;
	private final ModelPart rightForArm;
	private final ModelPart tumor;
	private final ModelPart tumor2;
	private final ModelPart tumor3;
	public InebriaterModel(ModelPart root) {
		this.thecrackie = root.getChild("thecrackie");
		this.theboogaloo = this.thecrackie.getChild("theboogaloo");
		this.RightLeg = this.theboogaloo.getChild("RightLeg");
		this.rigtForLeg = this.RightLeg.getChild("rigtForLeg");
		this.LeftArm = this.theboogaloo.getChild("LeftArm");
		this.TheCard = this.theboogaloo.getChild("TheCard");
		this.LeftLeg = this.theboogaloo.getChild("LeftLeg");
		this.leftForleg = this.LeftLeg.getChild("leftForleg");
		this.Head = this.theboogaloo.getChild("Head");
		this.Torso = this.theboogaloo.getChild("Torso");
		this.RightArm = this.thecrackie.getChild("RightArm");
		this.rightForArm = this.RightArm.getChild("rightForArm");
		this.tumor = this.rightForArm.getChild("tumor");
		this.tumor2 = this.rightForArm.getChild("tumor2");
		this.tumor3 = this.rightForArm.getChild("tumor3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition thecrackie = partdefinition.addOrReplaceChild("thecrackie", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition theboogaloo = thecrackie.addOrReplaceChild("theboogaloo", CubeListBuilder.create(), PartPose.offset(-1.7F, -6.6F, 0.9F));

		PartDefinition RightLeg = theboogaloo.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(17, 83).addBox(-2.0F, 0.0F, -1.25F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(2.3F, -5.4F, -0.9F));

		PartDefinition Tumor_r1 = RightLeg.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(89, 76).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.5F, -0.5F, 0.0F, -0.3054F, -0.6545F));

		PartDefinition Tumor_r2 = RightLeg.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(92, 18).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5F, 5.5F, 0.5F, 0.0F, -0.3491F, 0.4363F));

		PartDefinition rigtForLeg = RightLeg.addOrReplaceChild("rigtForLeg", CubeListBuilder.create().texOffs(43, 94).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(83, 45).addBox(-1.25F, 2.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = theboogaloo.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(0, 82).addBox(-2.1F, -1.4F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(83, 0).addBox(-2.1F, 4.6F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 17).addBox(-2.0F, -1.8F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(10.4F, -16.0F, -0.9F));

		PartDefinition TheCard = theboogaloo.addOrReplaceChild("TheCard", CubeListBuilder.create().texOffs(26, 96).addBox(-1.5F, 4.5F, -0.51F, 3.0F, 4.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offset(4.2F, -17.4F, -2.95F));

		PartDefinition CordLeft_r1 = TheCard.addOrReplaceChild("CordLeft_r1", CubeListBuilder.create().texOffs(89, 97).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2182F));

		PartDefinition CordRight_r1 = TheCard.addOrReplaceChild("CordRight_r1", CubeListBuilder.create().texOffs(94, 97).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition LeftLeg = theboogaloo.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(55, 76).addBox(-2.0F, 0.5F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(71, 11).addBox(-2.0F, 0.4F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(6.3F, -5.9F, -0.9F));

		PartDefinition leftForleg = LeftLeg.addOrReplaceChild("leftForleg", CubeListBuilder.create().texOffs(38, 76).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.5F, 0.0F));

		PartDefinition Head = theboogaloo.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.95F, -7.75F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(71, 23).addBox(-3.95F, -2.75F, -5.0F, 8.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
				.texOffs(78, 94).addBox(4.1F, -1.5F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(96, 25).addBox(-4.0F, -1.5F, -4.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(4.25F, -17.65F, 0.1F));

		PartDefinition Tumor_r3 = Head.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(93, 90).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.55F, -7.15F, 1.7F, -0.0175F, 0.1649F, -0.7607F));

		PartDefinition Tumor_r4 = Head.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(0, 93).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.45F, -7.25F, 2.2F, 0.0F, -0.3054F, -0.6545F));

		PartDefinition Fungus_r1 = Head.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(29, 52).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.25F, -6.0981F, -2.5716F, 0.1996F, 0.0864F, 0.5132F));

		PartDefinition Fungus_r2 = Head.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(0, 36).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, -3.3981F, 1.7284F, -0.533F, 0.1744F, -0.0077F));

		PartDefinition Fungus_r3 = Head.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(29, 44).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.75F, -4.3981F, -3.7716F, 0.0944F, 0.1959F, -0.2018F));

		PartDefinition Fungus_r4 = Head.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(42, 16).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, -3.498F, -6.8716F, 0.4011F, 0.5301F, 0.024F));

		PartDefinition Fungus_r5 = Head.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(0, 44).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, -6.3981F, -6.5716F, 0.2255F, 0.3819F, 0.0214F));

		PartDefinition topthing_r1 = Head.addOrReplaceChild("topthing_r1", CubeListBuilder.create().texOffs(95, 65).addBox(0.0F, -0.5F, -1.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(67, 94).addBox(8.1F, -0.5F, -1.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.25F, -3.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Torso = theboogaloo.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(58, 37).addBox(-3.4F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(104, 0).addBox(-3.4F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(3.7F, -17.4F, -0.9F));

		PartDefinition Fungus_r6 = Torso.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(33, 0).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7F, 6.552F, 1.4284F, -0.5679F, 0.1744F, -0.0077F));

		PartDefinition Tumor_r5 = Torso.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(67, 87).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3F, 8.9F, -1.0F, 0.0F, -0.3054F, -0.6545F));

		PartDefinition Fungus_r7 = Torso.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(33, 8).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 4.3519F, 1.8284F, -0.0792F, 0.698F, -0.0077F));

		PartDefinition RightArm = thecrackie.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(79, 54).addBox(-2.6F, -1.4F, -2.001F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(21, 17).addBox(-2.8F, -2.0F, -2.1F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-2.9F, -22.4F, 0.0F));

		PartDefinition cube_r1 = RightArm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(98, 38).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 6.9F, -1.5F, -0.2653F, 0.9186F, 0.0838F));

		PartDefinition cube_r2 = RightArm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(45, 60).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, 6.9F, -2.0F, -0.3142F, -0.3665F, 0.0F));

		PartDefinition cube_r3 = RightArm.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(42, 60).addBox(-1.0F, -4.0F, -1.0F, 1.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, 6.9F, -2.5F, -0.4014F, 0.0349F, 0.0F));

		PartDefinition cube_r4 = RightArm.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(56, 87).addBox(-4.0F, -8.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r5 = RightArm.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(32, 87).addBox(-4.0F, -8.0F, 1.0F, 5.0F, 8.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, 2.0F, -1.3F, 0.0F, 0.0F, -0.6807F));

		PartDefinition rightForArm = RightArm.addOrReplaceChild("rightForArm", CubeListBuilder.create().texOffs(21, 71).addBox(-1.7F, -0.6F, -2.89F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.9F, 4.4F, 0.9F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r6 = rightForArm.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(96, 59).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 22.6F, -1.0F, -0.0349F, 0.0F, 0.0F));

		PartDefinition fungus_r8 = rightForArm.addOrReplaceChild("fungus_r8", CubeListBuilder.create().texOffs(0, 52).addBox(-3.5F, 1.25F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.816F, 5.111F, 2.6013F, -0.1244F, -0.411F, -0.0346F));

		PartDefinition fungus_r9 = rightForArm.addOrReplaceChild("fungus_r9", CubeListBuilder.create().texOffs(42, 24).addBox(-3.5F, 1.25F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.784F, 6.311F, -0.4987F, -0.0947F, -0.1141F, 0.1733F));

		PartDefinition fungus_r10 = rightForArm.addOrReplaceChild("fungus_r10", CubeListBuilder.create().texOffs(29, 36).addBox(-3.5F, 1.25F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.716F, 5.811F, -3.1987F, 0.4227F, -0.028F, -0.0616F));

		PartDefinition cube_r7 = rightForArm.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(59, 96).addBox(-2.0F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 6.6F, -5.0F, 0.1165F, 0.2153F, 0.5013F));

		PartDefinition cube_r8 = rightForArm.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(96, 52).addBox(-2.0F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2F, 5.2F, -0.9F, 0.0F, 0.0F, 0.3491F));

		PartDefinition cube_r9 = rightForArm.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(35, 96).addBox(-2.0F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, 1.4F, -1.3204F, 1.2114F, -1.3358F));

		PartDefinition cube_r10 = rightForArm.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(52, 96).addBox(-2.0F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 5.8F, -3.5F, 0.0695F, -0.1791F, -0.3728F));

		PartDefinition cube_r11 = rightForArm.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(96, 45).addBox(-2.0F, -6.0F, 1.0F, 3.0F, 6.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2F, 5.2F, -0.9F, -0.0514F, 0.2031F, -0.2496F));

		PartDefinition cube_r12 = rightForArm.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(96, 32).addBox(0.0F, -2.0F, -1.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 19.7F, -0.9F, -0.0349F, 0.0F, 0.0F));

		PartDefinition cube_r13 = rightForArm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(84, 65).addBox(0.0F, -7.0F, -2.0F, 2.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 17.4F, -0.1F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r14 = rightForArm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(83, 29).addBox(-1.0F, -5.0F, -2.0F, 3.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9F, 18.1F, -0.3F, -0.1571F, 0.0F, 0.0F));

		PartDefinition tumor = rightForArm.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(-1.2F, 3.3F, -0.9F));

		PartDefinition cube_r15 = tumor.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(63, 65).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3F, 2.7F, 3.5F, 0.1147F, 0.4038F, 0.2853F));

		PartDefinition cube_r16 = tumor.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(42, 65).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.9F, 3.8F, 0.0F, -0.1222F, 0.0873F, 0.0F));

		PartDefinition cube_r17 = tumor.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 71).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.2267F, -0.4137F, -0.1302F));

		PartDefinition tumor2 = rightForArm.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-0.9F, 8.0F, -0.6F));

		PartDefinition cube_r18 = tumor2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(62, 0).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1F, 1.1F, -0.3F, 0.4014F, -0.6981F, 0.0F));

		PartDefinition cube_r19 = tumor2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 60).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 2.0F, -0.0486F, -0.1677F, 0.2833F));

		PartDefinition cube_r20 = tumor2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(58, 54).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, -0.1896F, 0.3156F, -0.5539F));

		PartDefinition tumor3 = rightForArm.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(-1.4F, 12.5F, 0.1F));

		PartDefinition cube_r21 = tumor3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(21, 60).addBox(-1.0F, -5.0F, -4.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -0.4F, 1.7F, -0.2443F, 0.0F, 0.0F));

		PartDefinition cube_r22 = tumor3.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(43, 87).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, 2.5F, 0.9F, -0.2654F, -0.2604F, 0.304F));

		PartDefinition cube_r23 = tumor3.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(88, 11).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 1.7F, 0.9F, -0.4064F, 0.0268F, -0.0963F));

		PartDefinition cube_r24 = tumor3.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(80, 87).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 1.7F, -0.4F, 0.0F, -0.2793F, 0.2094F));

		PartDefinition cube_r25 = tumor3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(93, 83).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 0.5F, -1.6F, 0.3655F, 0.0503F, 0.1127F));

		PartDefinition cube_r26 = tumor3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(13, 93).addBox(-2.0F, -3.0F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.2269F, 0.2443F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			float v =(Mth.sin(ageInTicks/4)/7);
			this.LeftArm.xRot = v;
			this.TheCard.zRot = (Mth.sin(ageInTicks/7)/7);
		} else {
			float v = Mth.sin(ageInTicks/8)/10;
			this.TheCard.zRot = 0;
			this.LeftArm.xRot =-v;
		}
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;
		this.leftForleg.xRot = LeftLeg.xRot < 0 ? -LeftLeg.xRot : 0;
		this.rigtForLeg.xRot = RightLeg.xRot < 0 ? -RightLeg.xRot : 0;
		animateTumor(this.tumor,Mth.sin(ageInTicks/6)/10);
		animateTumor(this.tumor2,Mth.cos(ageInTicks/7)/10);
		animateTumor(this.tumor3,Mth.sin(ageInTicks/5)/10);
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		if (entity.getAttackAnimationTick() <= 0){
			animateTentacleX(RightArm,Mth.sin(ageInTicks/7)/7);
		}
	}
	@Override
	public void prepareMobModel(T entity, float value1, float value2, float value3) {
		super.prepareMobModel(entity, value1, value2, value3);
		int attackAnimationTick = entity.getAttackAnimationTick();
		if (attackAnimationTick > 0) {
			float swing = -2.0F + 1.5F * Mth.triangleWave((float)attackAnimationTick - value3, 10.0F);
			this.animateTentacleX(RightArm,swing * 0.5f);
			this.animateTentacleX(rightForArm,swing * 0.5f);
		}
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		thecrackie.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}