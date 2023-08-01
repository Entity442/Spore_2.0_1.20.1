package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.7.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Griefer;
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

public class GrieferModel<T extends Griefer> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "griefermodel"), "main");
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart belly;
	private final ModelPart tumor;
	private final ModelPart tumor2;
	private final ModelPart tumor3;
	private final ModelPart tumor4;

	public GrieferModel(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.RightArm = root.getChild("RightArm");
		this.LeftArm = root.getChild("LeftArm");
		this.RightLeg = root.getChild("RightLeg");
		this.LeftLeg = root.getChild("LeftLeg");
		this.belly = root.getChild("belly");
		this.tumor = root.getChild("tumor");
		this.tumor2 = root.getChild("tumor2");
		this.tumor3 = root.getChild("tumor3");
		this.tumor4 = root.getChild("tumor4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 32).addBox(-4.5F, 10.0F, -2.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -5.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-8, 96).addBox(-6.0F, -22.0F, -4.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 29.0F, 0.0F, -0.1745F, 0.0F, -0.1309F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 18).addBox(-4.5F, -7.5F, -2.5F, 10.0F, 9.0F, 7.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 10.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -1.0F, 11.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -3.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 24).addBox(-4.0F, -4.0F, -9.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(48, 50).addBox(-4.0F, 2.0F, -5.0F, 8.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(60, 45).addBox(-4.0F, 2.0F, -9.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, -3.25F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -5.0F));

		PartDefinition cube_r4 = jaw.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 50).addBox(-3.75F, -1.0F, -3.5F, 7.5F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition flower2 = head.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -2.0F, -5.75F, 0.4361F, -0.0094F, 0.0426F));

		PartDefinition cube_r5 = flower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(102, 0).addBox(0.0F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r6 = flower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(102, 0).addBox(-7.68F, 0.0F, -3.84F, 7.68F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r7 = flower2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(102, 0).addBox(-5.12F, 0.0F, -7.68F, 8.96F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = flower2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(102, 0).addBox(-5.12F, 0.0F, 0.0F, 8.96F, 0.0F, 7.68F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.64F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = head.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -4.0F, -5.75F, 0.3035F, -0.0227F, 0.1731F));

		PartDefinition cube_r9 = flower3.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(74, 0).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r10 = flower3.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(74, 0).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r11 = flower3.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower3.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition RightArm = partdefinition.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(63, 64).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, -5.0F, -3.0F));

		PartDefinition RightForArm = RightArm.addOrReplaceChild("RightForArm", CubeListBuilder.create().texOffs(0, 69).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftArm = partdefinition.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(36, 64).addBox(-1.0F, -2.0F, -2.5F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(6.5F, -5.0F, -2.25F));

		PartDefinition LeftForArm = LeftArm.addOrReplaceChild("LeftForArm", CubeListBuilder.create().texOffs(68, 52).addBox(-1.0F, 0.0F, -2.5F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition RightLeg = partdefinition.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 57).addBox(-2.75F, -1.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.15F, 12.0F, 0.75F));

		PartDefinition rightForLeg = RightLeg.addOrReplaceChild("rightForLeg", CubeListBuilder.create().texOffs(18, 59).addBox(-2.75F, 0.0F, -2.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition LeftLeg = partdefinition.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(49, 56).addBox(-1.25F, -1.0F, -2.0F, 4.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.15F, 12.0F, 0.75F));

		PartDefinition leftForLeg = LeftLeg.addOrReplaceChild("leftForLeg", CubeListBuilder.create().texOffs(57, 19).addBox(-1.25F, 0.0F, -2.0F, 4.0F, 6.0F, 5.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition belly = partdefinition.addOrReplaceChild("belly", CubeListBuilder.create().texOffs(52, 0).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, -2.0F));

		PartDefinition cube_r13 = belly.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-8, 96).addBox(-7.0F, -24.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 18.0F, 2.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition tumor = partdefinition.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition cube_r14 = tumor.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-8, 96).addBox(-6.0F, -31.0F, -2.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 31.0F, 0.0F, -0.0436F, 0.0F, 0.2618F));

		PartDefinition cube_r15 = tumor.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(-8, 96).addBox(-7.0F, -33.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 31.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition cube_r16 = tumor.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-8, 96).addBox(-1.0F, -34.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 31.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r17 = tumor.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 80).addBox(-12.0F, -36.0F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 31.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition tumor2 = partdefinition.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-1.0F, -8.0F, -3.0F));

		PartDefinition cube_r18 = tumor2.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(-8, 96).addBox(-7.0F, -33.0F, -5.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 32.0F, 3.0F, 0.1739F, 0.0151F, -0.0859F));

		PartDefinition cube_r19 = tumor2.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, -34.0F, -12.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 32.0F, 3.0F, -0.2164F, -0.0283F, -0.1278F));

		PartDefinition cube_r20 = tumor2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 80).addBox(-2.0F, -36.0F, -15.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 32.0F, 3.0F, -0.1745F, 0.0F, -0.0873F));

		PartDefinition flower = tumor2.addOrReplaceChild("flower", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, -2.0F, 2.0F, -0.637F, -0.1678F, -0.374F));

		PartDefinition cube_r21 = flower.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(74, 0).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r22 = flower.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(74, 0).addBox(-6.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r23 = flower.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, -6.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r24 = flower.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(74, 0).addBox(-4.0F, 0.0F, 0.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition tumor3 = partdefinition.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 2.0F));

		PartDefinition cube_r25 = tumor3.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 80).addBox(-12.0F, -27.0F, -4.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.0873F, 0.0F, 0.3927F));

		PartDefinition cube_r26 = tumor3.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(-8, 96).addBox(-4.0F, -26.0F, -3.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r27 = tumor3.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 80).addBox(-1.0F, -21.0F, -25.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 28.0F, -2.0F, -0.9581F, -0.0283F, -0.1278F));

		PartDefinition tumor4 = partdefinition.addOrReplaceChild("tumor4", CubeListBuilder.create(), PartPose.offset(0.0F, 5.0F, -3.0F));

		PartDefinition cube_r28 = tumor4.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(-8, 96).addBox(-1.0F, -20.0F, -9.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition cube_r29 = tumor4.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 80).addBox(-4.0F, -24.0F, 0.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, 0.2597F, -0.0338F, 0.1265F));

		PartDefinition cube_r30 = tumor4.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 80).addBox(1.0F, -25.0F, -9.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 19.0F, 3.0F, -0.1309F, 0.0F, -0.2182F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		if (entity.isAggressive()){
			if (entity.swinging){
				this.RightArm.xRot = -89F;
				this.LeftArm.xRot = -89F;
			}
			else{
				this.RightArm.xRot = -89.5F - (Mth.sin(ageInTicks/4)/7);
				this.LeftArm.xRot = -89.5F + (Mth.sin(ageInTicks/4)/7);
			}

		}else if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
			this.LeftArm.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		} else{

			this.RightArm.xRot = Mth.sin(ageInTicks/8)/10;
			this.LeftArm.xRot = -Mth.sin(ageInTicks/8)/10;
			this.LeftLeg.xRot = 0;
			this.RightLeg.xRot = 0;
		}
		if (entity.grieferExplosion()){
			this.head.yRot = Mth.cos(ageInTicks/4)/4;
			this.tumor.xScale = this.tumor.xScale + (0.0005F * entity.getSwell());
			this.tumor.yScale = this.tumor.yScale + (0.0005F * entity.getSwell());
			this.tumor.zScale = this.tumor.zScale + (0.0005F * entity.getSwell());

			this.tumor2.xScale = this.tumor2.xScale + (0.0005F * entity.getSwell());
			this.tumor2.yScale = this.tumor2.yScale + (0.0005F * entity.getSwell());
			this.tumor2.zScale = this.tumor2.zScale + (0.0005F * entity.getSwell());

			this.tumor3.xScale = this.tumor3.xScale + (0.0005F * entity.getSwell());
			this.tumor3.yScale = this.tumor3.yScale + (0.0005F * entity.getSwell());
			this.tumor3.zScale = this.tumor3.zScale + (0.0005F * entity.getSwell());

		} else {
			this.tumor.xScale = 1 + Mth.sin(ageInTicks / 8) / 10;
			this.tumor.yScale = 1 - Mth.sin(ageInTicks / 8) / 10;
			this.tumor.zScale = 1 + Mth.sin(ageInTicks / 8) / 10;

			this.tumor2.xScale = 1 + Mth.sin(ageInTicks / 6) / 7;
			this.tumor2.yScale = 1 - Mth.sin(ageInTicks / 6) / 7;
			this.tumor2.zScale = 1 + Mth.sin(ageInTicks / 6) / 7;

			this.tumor3.xScale = 1 + Mth.sin(ageInTicks / 7) / 9;
			this.tumor3.yScale = 1 - Mth.sin(ageInTicks / 7) / 9;
			this.tumor3.zScale = 1 + Mth.sin(ageInTicks / 7) / 9;

			this.tumor4.xScale = 1 + Mth.sin(ageInTicks / 8) / 9;
			this.tumor4.yScale = 1 - Mth.sin(ageInTicks / 8) / 9;
			this.tumor4.zScale = 1 + Mth.sin(ageInTicks / 8) / 9;
		}


		this.head.xRot = headPitch / (90F / (float) Math.PI);

		this.head.getChild("jaw").xRot = Mth.sin(ageInTicks / 8) / 10;

		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.8F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.8F) * -0.8F * limbSwingAmount;

		if (LeftLeg.xRot < 0){
			this.LeftLeg.getChild("leftForLeg").xRot = -LeftLeg.xRot;}
		if (RightLeg.xRot < 0){
			this.RightLeg.getChild("rightForLeg").xRot = -RightLeg.xRot;}

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		belly.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tumor4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}