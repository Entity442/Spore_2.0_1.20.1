package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

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
import net.minecraft.world.entity.LivingEntity;

public class LivingHorseArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "livinghorsearmormodel"), "main");
	public final ModelPart Body;
	private final ModelPart Body2;
	private final ModelPart leftLung;
	private final ModelPart rightLung;
	private final ModelPart heart;
	public final ModelPart Neck;
	private final ModelPart Head;
	private final ModelPart Neck2;
	private final ModelPart Head2;
	public final ModelPart FrontRightLeg;
	private final ModelPart Leg4A2;
	public final ModelPart FrontLeftLeg;
	private final ModelPart Leg3A2;
	public final ModelPart BackRightLeg;
	private final ModelPart Leg2A2;
	public final ModelPart BackLeftLeg;
	private final ModelPart Leg1A2;

	public LivingHorseArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Body = root.getChild("Body");
		this.Body2 = this.Body.getChild("Body2");
		this.leftLung = this.Body2.getChild("leftLung");
		this.rightLung = this.Body2.getChild("rightLung");
		this.heart = this.Body2.getChild("heart");
		this.Neck = root.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.Neck2 = this.Neck.getChild("Neck2");
		this.Head2 = this.Neck2.getChild("Head2");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
		this.Leg4A2 = this.FrontRightLeg.getChild("Leg4A2");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.Leg3A2 = this.FrontLeftLeg.getChild("Leg3A2");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.Leg2A2 = this.BackRightLeg.getChild("Leg2A2");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.Leg1A2 = this.BackLeftLeg.getChild("Leg1A2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.01F))
		.texOffs(-15, 32).addBox(5.0F, -6.0F, -13.0F, 3.0F, 0.0F, 15.0F, new CubeDeformation(0.01F))
		.texOffs(36, 32).addBox(5.0F, -7.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.01F))
		.texOffs(36, 32).addBox(5.0F, -5.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.01F))
		.texOffs(-6, 32).addBox(-8.0F, -6.0F, -13.0F, 3.0F, 0.0F, 15.0F, new CubeDeformation(0.01F))
		.texOffs(0, 32).addBox(-7.0F, -7.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.01F))
		.texOffs(0, 32).addBox(-7.0F, -5.0F, -14.0F, 2.0F, 0.0F, 16.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 11.0F, 9.0F));

		PartDefinition Body2 = Body.addOrReplaceChild("Body2", CubeListBuilder.create().texOffs(56, 47).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition leftLung = Body2.addOrReplaceChild("leftLung", CubeListBuilder.create().texOffs(120, 69).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.19F))
		.texOffs(120, 73).addBox(-0.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.15F, -1.75F, -20.0F, 0.0F, -0.1745F, -0.1745F));

		PartDefinition rightLung = Body2.addOrReplaceChild("rightLung", CubeListBuilder.create().texOffs(72, 98).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F))
		.texOffs(72, 102).addBox(-1.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.0F, -1.75F, -20.0F, 0.0F, 0.1745F, 0.1745F));

		PartDefinition heart = Body2.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, -1.45F, -19.05F, -0.0263F, -0.0832F, 0.3065F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(114, 84).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-0.0752F, -0.8348F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(108, 84).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r3 = heart.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(56, 55).addBox(-2.1619F, -2.9414F, -1.05F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-0.8252F, 0.4152F, -1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(64, 0).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.01F))
		.texOffs(92, 17).addBox(-3.0F, -11.0F, 2.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.01F))
		.texOffs(90, 17).addBox(0.0F, -11.0F, 2.0F, 3.0F, 8.0F, 0.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 7.0F, -8.0F));

		PartDefinition brainthing_r1 = Neck.addOrReplaceChild("brainthing_r1", CubeListBuilder.create().texOffs(83, 79).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 3.5F, 0.5585F, 0.3378F, 0.2042F));

		PartDefinition brainthing_r2 = Neck.addOrReplaceChild("brainthing_r2", CubeListBuilder.create().texOffs(83, 79).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 3.5F, 0.5585F, -0.3378F, -0.2042F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(64, 19).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.01F))
		.texOffs(44, 15).addBox(-2.0F, -6.0F, -6.0F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(86, 0).addBox(-1.0F, -7.0F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(86, 0).addBox(1.0F, -7.0F, -6.0F, 0.0F, 1.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(42, -5).addBox(0.0F, -8.0F, -6.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.01F))
		.texOffs(46, 3).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -11.0F, 3.0F));

		PartDefinition UMouth_r1 = Head.addOrReplaceChild("UMouth_r1", CubeListBuilder.create().texOffs(0, -9).addBox(0.0F, -9.0038F, -7.9128F, 0.0F, 11.0F, 9.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -4.0F, -10.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Neck2 = Neck.addOrReplaceChild("Neck2", CubeListBuilder.create().texOffs(56, 79).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Head2 = Neck2.addOrReplaceChild("Head2", CubeListBuilder.create().texOffs(78, 79).addBox(-3.0F, -5.0F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(110, 94).addBox(-2.0F, -5.0F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 3.0F));

		PartDefinition Head_r1 = Head2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(40, 47).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.5236F, -0.5236F, 0.0F));

		PartDefinition Head_r2 = Head2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(56, 47).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.5236F, 0.5236F, 0.0F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.01F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(-3.0F, 13.0F, -9.0F));

		PartDefinition Leg4A_r1 = FrontRightLeg.addOrReplaceChild("Leg4A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -5.9F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg4A_r2 = FrontRightLeg.addOrReplaceChild("Leg4A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -5.9F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition Leg4A2 = FrontRightLeg.addOrReplaceChild("Leg4A2", CubeListBuilder.create().texOffs(78, 91).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(99, 47).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.01F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(3.0F, 13.0F, -9.0F));

		PartDefinition Leg3A_r1 = FrontLeftLeg.addOrReplaceChild("Leg3A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg3A_r2 = FrontLeftLeg.addOrReplaceChild("Leg3A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition Leg3A2 = FrontLeftLeg.addOrReplaceChild("Leg3A2", CubeListBuilder.create().texOffs(94, 91).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(99, 47).addBox(2.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.01F)), PartPose.offset(-3.0F, 13.0F, 9.0F));

		PartDefinition Leg2A_r1 = BackRightLeg.addOrReplaceChild("Leg2A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, 0.0087F));

		PartDefinition Leg2A_r2 = BackRightLeg.addOrReplaceChild("Leg2A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, -1.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition Leg2A2 = BackRightLeg.addOrReplaceChild("Leg2A2", CubeListBuilder.create().texOffs(78, 91).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(99, 47).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(26, 34).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.01F))
		.texOffs(0, 15).addBox(-2.0F, 2.0F, -3.0F, 4.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(11, 16).addBox(-2.0F, 2.0F, 2.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(0.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(-1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F))
		.texOffs(6, 32).addBox(1.0F, 2.0F, -4.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.01F)), PartPose.offset(3.0F, 13.0F, 9.0F));

		PartDefinition Leg1A_r1 = BackLeftLeg.addOrReplaceChild("Leg1A_r1", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -6.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(1.0F, 9.0F, -1.0F, 0.0873F, -0.1309F, -0.0087F));

		PartDefinition Leg1A_r2 = BackLeftLeg.addOrReplaceChild("Leg1A_r2", CubeListBuilder.create().texOffs(10, 6).addBox(0.0F, -1.0F, -7.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-1.0F, 9.0F, 0.0F, 0.0873F, 0.1309F, -0.0087F));

		PartDefinition Leg1A2 = BackLeftLeg.addOrReplaceChild("Leg1A2", CubeListBuilder.create().texOffs(94, 91).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(99, 47).addBox(2.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void animateHeart(float age){
		float val = Mth.sin(age/6)/6;
		this.heart.xScale = 1 + val;
		this.heart.zScale = 1 + val;
		this.heart.yScale = 1 - val;
	}
	private void animateLung(ModelPart part, float age){
		float val = Mth.sin(age/8)/4;
		part.xScale = 1 + val;
		part.yScale = 1 - val;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateHeart(ageInTicks);
		animateLung(leftLung,ageInTicks);
		animateLung(rightLung,ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}