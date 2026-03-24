package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import com.Harbinger.Spore.Client.AnimationTrackers.BileBlasterShootAnimationTracker;

public class BileBlasterArmModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "bileblastermodelarm"), "main");
	public final ModelPart Bile_Blaster;
	private final ModelPart innards;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart stomach;
	private final ModelPart tumor3;
	private final ModelPart tumor;
	private final ModelPart tumor2;
	private final ModelPart barrel;
	private final ModelPart body;
	private final ModelPart underbarre_and_grip;
	private final ModelPart trigger;

	public BileBlasterArmModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Bile_Blaster = root.getChild("Bile_Blaster");
		this.innards = this.Bile_Blaster.getChild("innards");
		this.head = this.innards.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.stomach = this.innards.getChild("stomach");
		this.tumor3 = this.innards.getChild("tumor3");
		this.tumor = this.innards.getChild("tumor");
		this.tumor2 = this.innards.getChild("tumor2");
		this.barrel = this.Bile_Blaster.getChild("barrel");
		this.body = this.Bile_Blaster.getChild("body");
		this.underbarre_and_grip = this.Bile_Blaster.getChild("underbarre_and_grip");
		this.trigger = this.underbarre_and_grip.getChild("trigger");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Bile_Blaster = partdefinition.addOrReplaceChild("Bile_Blaster", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 26.0F, -27.0F, 1.5708F, -0.0436F, 1.5708F));

		PartDefinition innards = Bile_Blaster.addOrReplaceChild("innards", CubeListBuilder.create().texOffs(84, 46).addBox(-25.0F, -1.0F, -9.0F, 9.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 22.0F, -4.0F));

		PartDefinition cube_r1 = innards.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(120, 91).addBox(-5.0F, -2.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.75F, -0.75F, 4.75F, 0.0779F, -0.7545F, 0.7718F));

		PartDefinition cube_r2 = innards.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(84, 46).addBox(-5.0F, 0.0F, -6.5F, 9.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -1.0F, -2.5F, 0.6981F, 0.0F, 0.0F));

		PartDefinition cube_r3 = innards.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(84, 46).addBox(-5.0F, 0.0F, -6.5F, 9.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.0F, -1.0F, -2.5F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r4 = innards.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(86, 103).addBox(-1.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(-4.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(-7.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(-10.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(2.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(5.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(8.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(11.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(86, 103).addBox(14.0F, -2.5F, -3.5F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, -4.2929F, 0.5F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r5 = innards.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(102, 8).addBox(-13.0F, -2.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.5F, 7.25F, 9.0F, 0.3356F, -0.2598F, 0.6426F));

		PartDefinition cube_r6 = innards.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 99).addBox(-13.0F, -2.0F, -1.0F, 14.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 5.0F, 4.0F, -0.0855F, 0.4252F, -0.2855F));

		PartDefinition cube_r7 = innards.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 29).addBox(-13.0F, -1.0F, -1.0F, 24.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition head = innards.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r8 = head.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 85).addBox(-3.5838F, -5.4259F, 0.3329F, 7.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.4704F, -5.2582F, 0.343F, 2.7286F, 1.4512F, -0.2065F));

		PartDefinition cube_r9 = head.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(38, 78).addBox(-4.5838F, -5.4259F, 0.3329F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.9704F, -4.2582F, -0.157F, 2.7286F, 1.4512F, -0.2065F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(-30.0F, -5.0F, 0.0F));

		PartDefinition cube_r10 = jaw.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(94, 18).addBox(-3.6601F, 0.6423F, -0.2942F, 7.0F, 2.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0296F, 0.2582F, 0.157F, 1.856F, 1.4512F, -0.2065F));

		PartDefinition cube_r11 = jaw.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 103).addBox(-3.6601F, 0.6423F, -0.2942F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0296F, 0.2582F, -0.343F, 1.856F, 1.4512F, -0.2065F));

		PartDefinition stomach = innards.addOrReplaceChild("stomach", CubeListBuilder.create(), PartPose.offset(-0.5F, -0.25F, 0.5F));

		PartDefinition cube_r12 = stomach.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 56).addBox(-12.0F, -1.0F, -1.0F, 23.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition tumor3 = innards.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -2.0F));

		PartDefinition cube_r13 = tumor3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(50, 99).addBox(-1.0F, -3.0F, -1.0F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, -0.3054F));

		PartDefinition tumor = innards.addOrReplaceChild("tumor", CubeListBuilder.create(), PartPose.offset(1.0F, 0.0F, 4.0F));

		PartDefinition cube_r14 = tumor.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(114, 115).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, 2.0F, 1.6144F, 0.3491F, 0.0F));

		PartDefinition cube_r15 = tumor.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(114, 115).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, 2.0F, 1.1781F, 0.3491F, 0.0F));

		PartDefinition cube_r16 = tumor.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(114, 115).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, 2.0F, 0.2182F, 0.3491F, 0.0F));

		PartDefinition cube_r17 = tumor.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(114, 115).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 0.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, 2.0F, 0.7418F, 0.3491F, 0.0F));

		PartDefinition cube_r18 = tumor.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(70, 78).addBox(-7.0F, -4.0F, -2.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, -1.0F, -0.1468F, -0.1128F, 0.1306F));

		PartDefinition cube_r19 = tumor.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(60, 97).addBox(-3.0F, -4.0F, -4.0F, 7.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.5672F, 0.0F));

		PartDefinition tumor2 = innards.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(-5.0F, 0.0F, -2.0F));

		PartDefinition cube_r20 = tumor2.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(116, 27).addBox(-5.0F, -4.0F, -1.0F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3124F, 0.2079F, 0.0666F));

		PartDefinition barrel = Bile_Blaster.addOrReplaceChild("barrel", CubeListBuilder.create(), PartPose.offset(4.5F, 22.0F, -4.0F));

		PartDefinition cube_r21 = barrel.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(66, 66).addBox(-44.0F, -3.5F, -3.5F, 16.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(68.0F, -0.75F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r22 = barrel.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-44.0F, -1.5F, -1.5F, 58.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, -2.25F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition body = Bile_Blaster.addOrReplaceChild("body", CubeListBuilder.create().texOffs(120, 87).addBox(11.0F, -4.75F, -0.5F, 7.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 18).addBox(-30.0F, -5.0F, -2.0F, 42.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(0, 8).addBox(-33.0F, -4.0F, -1.5F, 47.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(32, 116).addBox(9.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(116, 46).addBox(6.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(118, 95).addBox(0.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(118, 104).addBox(3.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(114, 119).addBox(-8.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(120, 78).addBox(-2.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(46, 122).addBox(-11.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 56).addBox(-28.0F, -5.5F, -0.5F, 38.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 51).addBox(-28.5F, -5.25F, -1.5F, 38.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(0, 76).addBox(-28.5F, -2.5F, -2.5F, 13.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(66, 59).addBox(-26.5F, -4.5F, -2.5F, 29.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(122, 12).addBox(-5.5F, -2.5F, -2.5F, 1.0F, 3.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(70, 38).addBox(-12.0F, -2.5F, -0.5F, 20.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 22.0F, -4.0F));

		PartDefinition cube_r23 = body.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(70, 46).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, -5.0F, 0.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition underbarre_and_grip = Bile_Blaster.addOrReplaceChild("underbarre_and_grip", CubeListBuilder.create().texOffs(70, 29).addBox(-32.0F, -1.0F, -1.0F, 20.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(86, 97).addBox(-30.75F, 2.5F, -1.5F, 11.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(28, 85).addBox(-18.75F, 2.5F, -1.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(122, 21).addBox(-16.75F, 2.5F, -1.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(60, 122).addBox(-14.75F, 2.5F, -1.5F, 1.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 22.0F, -4.0F));

		PartDefinition cube_r24 = underbarre_and_grip.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(84, 53).addBox(-7.0F, -1.0F, -1.0F, 9.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, 8.45F, 0.4F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r25 = underbarre_and_grip.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(24, 103).addBox(-0.5F, -1.0F, -1.0F, 1.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.7F, 5.0F, 0.5F, 0.0F, 0.0F, 0.829F));

		PartDefinition cube_r26 = underbarre_and_grip.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(102, 78).addBox(-1.0F, -7.0F, -1.0F, 5.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-32.0F, 8.0F, -0.6F, 0.0F, 0.0F, 0.6981F));

		PartDefinition cube_r27 = underbarre_and_grip.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(32, 99).addBox(-2.0F, -7.0F, -1.0F, 6.0F, 14.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-31.25F, 7.75F, -0.1F, 0.0F, 0.0F, 0.6981F));

		PartDefinition trigger = underbarre_and_grip.addOrReplaceChild("trigger", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r28 = trigger.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(38, 76).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.85F, 6.55F, 0.9F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r29 = trigger.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(76, 46).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, 4.75F, 0.5F, 0.0F, 0.0F, -0.4363F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Bile_Blaster.getAllParts().forEach(ModelPart::resetPose);
		float lungVal = Mth.sin(ageInTicks/7)/16;
		float tum1 = Mth.sin(ageInTicks/6)/7;
		float tum2 = Mth.cos(ageInTicks/7)/6;
		float tum3 = Mth.sin(ageInTicks/7)/8;
		animateTumor(tumor,tum1);
		animateTumor(tumor2,tum2);
		animateTumor(tumor3,tum3);
		this.stomach.xScale = 1 + lungVal;
		animateTentacleZ(jaw,Mth.sin(ageInTicks/6)/8);
		if (entity instanceof Player player){
			float anim = BileBlasterShootAnimationTracker.getProgress(player, 0);
			this.barrel.x = barrel.x - anim * 4;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Bile_Blaster.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}