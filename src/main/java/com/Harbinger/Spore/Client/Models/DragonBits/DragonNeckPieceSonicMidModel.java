package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
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


public class DragonNeckPieceSonicMidModel<T extends LivingEntity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragonneckpiecesonicmidmodel"), "main");
	private final ModelPart gay;
	private final ModelPart sculk;
	private final ModelPart tendril;
	private final ModelPart sculk2;
	private final ModelPart tendril2;

	public DragonNeckPieceSonicMidModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.gay = root.getChild("gay");
		this.sculk = this.gay.getChild("sculk");
		this.tendril = this.sculk.getChild("tendril");
		this.sculk2 = this.gay.getChild("sculk2");
		this.tendril2 = this.sculk2.getChild("tendril2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gay = partdefinition.addOrReplaceChild("gay", CubeListBuilder.create().texOffs(36, 0).addBox(-4.8333F, -8.6667F, -6.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1667F, 15.6667F, 0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r1 = gay.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 70).addBox(-4.5F, -2.0F, -1.5F, 5.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0342F, -3.1062F, -4.5428F, 0.09F, 0.3087F, -2.9817F));

		PartDefinition cube_r2 = gay.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(56, 25).addBox(-4.5F, -2.0F, -1.5F, 9.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0159F, -2.22F, -4.5352F, 0.7875F, -0.2611F, 1.3017F));

		PartDefinition cube_r3 = gay.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 50).addBox(-4.5F, -2.5F, -1.5F, 9.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 2.7F, -4.5F, 0.071F, 0.1191F, 1.3363F));

		PartDefinition cube_r4 = gay.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 58).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0969F, -4.6691F, 4.7F, 0.0F, 0.0F, -0.1047F));

		PartDefinition cube_r5 = gay.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(56, 32).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1667F, 3.3333F, 4.9F, 0.0F, 0.0F, 0.0698F));

		PartDefinition cube_r6 = gay.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 25).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6667F, 0.3333F, 1.0F, 0.0193F, 0.2173F, 0.0894F));

		PartDefinition cube_r7 = gay.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -8.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3333F, 0.3333F, 1.0F, 0.0154F, -0.1739F, -0.0886F));

		PartDefinition sculk = gay.addOrReplaceChild("sculk", CubeListBuilder.create(), PartPose.offset(-7.325F, -0.675F, 3.725F));

		PartDefinition cube_r8 = sculk.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(52, 66).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.225F, 1.675F, 0.575F, -0.9009F, 1.1193F, -0.8537F));

		PartDefinition cube_r9 = sculk.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(56, 56).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.275F, 1.675F, -1.325F, 0.0193F, -0.1559F, -0.1237F));

		PartDefinition cube_r10 = sculk.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(56, 46).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.275F, -1.725F, -0.025F, -0.1994F, 1.2517F, -0.1579F));

		PartDefinition tendril = sculk.addOrReplaceChild("tendril", CubeListBuilder.create().texOffs(36, 45).addBox(0.0F, -3.5F, -9.5F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.325F, -1.625F, 0.775F, 2.9087F, 0.5779F, -3.0334F));

		PartDefinition sculk2 = gay.addOrReplaceChild("sculk2", CubeListBuilder.create(), PartPose.offsetAndRotation(7.675F, 2.325F, 3.725F, 0.0F, 1.9635F, 0.0F));

		PartDefinition cube_r11 = sculk2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(16, 58).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.225F, 1.675F, 0.575F, -0.9009F, 1.1193F, -0.8537F));

		PartDefinition cube_r12 = sculk2.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(16, 68).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.275F, 1.675F, -1.325F, 0.0193F, -0.1559F, -0.1237F));

		PartDefinition cube_r13 = sculk2.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(34, 65).addBox(-2.0F, -2.5F, -2.5F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.275F, -1.725F, -0.025F, -0.1994F, 1.2517F, -0.1579F));

		PartDefinition tendril2 = sculk2.addOrReplaceChild("tendril2", CubeListBuilder.create().texOffs(36, 45).addBox(0.0F, -3.5F, -9.5F, 0.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.575F, -1.625F, -0.925F, 2.4153F, 1.1553F, 2.9156F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTentacleX(tendril, Mth.cos(ageInTicks/6)/7);
		animateTentacleX(tendril2, Mth.sin(ageInTicks/7)/8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		gay.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}