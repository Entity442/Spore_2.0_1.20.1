package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
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
import net.minecraft.world.entity.LivingEntity;

public class DragonNeckPieceSonicModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragonneckpiecesonicmodel"), "main");
	private final ModelPart gay;

	public DragonNeckPieceSonicModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.gay = root.getChild("gay");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gay = partdefinition.addOrReplaceChild("gay", CubeListBuilder.create().texOffs(36, 0).addBox(-4.8333F, -8.6667F, -6.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1667F, 15.6667F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = gay.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(100, 118).addBox(-2.5F, -3.5F, -1.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1812F, -5.1523F, 5.6077F, -3.0412F, -0.0772F, 0.2374F));

		PartDefinition cube_r2 = gay.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(100, 118).addBox(-2.5F, -3.5F, -1.5F, 5.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5188F, -5.1523F, 6.1077F, -3.0194F, -0.033F, -0.1535F));

		PartDefinition cube_r3 = gay.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(97, 121).addBox(-4.5F, -2.0F, -1.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2034F, -5.7489F, -6.7766F, 3.1026F, 0.1847F, 1.4535F));

		PartDefinition cube_r4 = gay.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(97, 121).addBox(-4.5F, -2.0F, -1.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5966F, -9.6489F, 0.6234F, -1.4209F, -0.1821F, 2.5848F));

		PartDefinition cube_r5 = gay.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(92, 116).addBox(-3.5F, -2.0F, -4.0F, 7.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5674F, -8.2014F, -1.563F, 0.1751F, -0.2186F, 2.8943F));

		PartDefinition cube_r6 = gay.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(90, 114).addBox(-4.5F, -2.0F, -5.0F, 9.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.879F, -8.3126F, -0.018F, 0.09F, 0.3087F, -2.9817F));

		PartDefinition cube_r7 = gay.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 70).addBox(-4.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0342F, -3.1062F, -4.5428F, 0.09F, 0.3087F, -2.9817F));

		PartDefinition cube_r8 = gay.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(56, 25).addBox(-4.5F, -2.0F, -1.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0159F, -2.22F, -4.5352F, 0.7875F, -0.2611F, 1.3017F));

		PartDefinition cube_r9 = gay.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 50).addBox(-4.5F, -2.5F, -1.5F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.7F, -4.5F, 0.071F, 0.1191F, 1.3363F));

		PartDefinition cube_r10 = gay.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0969F, -4.6691F, 4.7F, 0.0F, 0.0F, -0.1047F));

		PartDefinition cube_r11 = gay.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(56, 32).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1667F, 3.3333F, 4.9F, 0.0F, 0.0F, 0.0698F));

		PartDefinition cube_r12 = gay.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6667F, 0.3333F, 1.0F, 0.0193F, 0.2173F, 0.0894F));

		PartDefinition cube_r13 = gay.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3333F, 0.3333F, 1.0F, 0.0154F, -0.1739F, -0.0886F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		gay.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}