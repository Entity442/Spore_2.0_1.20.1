package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Client.Models.TentacledModel;
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
import net.minecraft.world.entity.Entity;

public class FinPart2Model<T extends Entity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "finpart2model"), "main");
	private final ModelPart body;
	private final ModelPart Body2;
	private final ModelPart Body3;
	private final ModelPart Body4;
	private final ModelPart Tumor;

	public FinPart2Model() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.body = root.getChild("body");
		this.Body2 = this.body.getChild("Body2");
		this.Body3 = this.body.getChild("Body3");
		this.Body4 = this.body.getChild("Body4");
		this.Tumor = this.body.getChild("Tumor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 95).addBox(-5.0F, -16.0F, -8.0F, 10.0F, 16.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition FinMembrane1_r1 = body.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(93, 12).addBox(-0.01F, -7.0F, -4.0F, 0.0F, 8.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -10.25F, 9.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = body.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(78, 15).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -14.75F, 9.0F, -1.4835F, 0.0F, 0.0F));

		PartDefinition FinSupport_r2 = body.addOrReplaceChild("FinSupport_r2", CubeListBuilder.create().texOffs(78, 15).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -1.25F, 9.0F, -1.6144F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 109).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.75F, -5.5F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Body2 = body.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0769F, -8.9175F, 3.2368F, -0.1074F, -1.1021F, 2.4676F));

		PartDefinition TorsoBase_r1 = Body2.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(52, 17).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r1 = Body2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(18, 69).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -0.1867F, -0.2161F, -0.1034F));

		PartDefinition Arm_r2 = Body2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(74, 6).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r1 = Body2.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(30, 59).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r1 = Body2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(48, 43).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Body3 = body.addOrReplaceChild("Body3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0769F, -15.9175F, -6.7632F, 1.7186F, 0.6393F, 0.3936F));

		PartDefinition TorsoBase_r2 = Body3.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(52, 17).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 4.1988F, 1.3066F, -1.434F, -0.461F, -0.0476F));

		PartDefinition Arm_r3 = Body3.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(18, 69).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.5393F, -0.2161F, -0.1034F));

		PartDefinition Arm_r4 = Body3.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(74, 6).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -1.007F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r2 = Body3.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(30, 59).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r2 = Body3.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(48, 43).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -0.9697F, -7.46F, -1.0541F, -0.9659F, 0.8253F));

		PartDefinition Body4 = body.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.9231F, -8.9175F, 2.2368F, 0.7225F, 1.4184F, 2.0505F));

		PartDefinition TorsoBase_r3 = Body4.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(52, 17).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, 2.6239F, -0.461F, -0.0476F));

		PartDefinition Arm_r5 = Body4.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(18, 69).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -0.1867F, -0.2161F, -0.1034F));

		PartDefinition Arm_r6 = Body4.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(74, 6).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r3 = Body4.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(30, 59).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r3 = Body4.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(48, 43).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, 1.0303F, -6.46F, 1.626F, 0.0972F, 0.2852F));

		PartDefinition Tumor = body.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -8.0F, -7.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(92, 110).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(92, 110).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Tumor, Mth.sin(ageInTicks/6)/6);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}