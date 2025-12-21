package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
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
import net.minecraft.world.entity.Entity;

public class Seg11<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg11"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart CalcifiedCorpses;
	private final ModelPart CalcifiedCorpse1;

	public Seg11() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.CalcifiedCorpses = root.getChild("CalcifiedCorpses");
		this.CalcifiedCorpse1 = this.CalcifiedCorpses.getChild("CalcifiedCorpse1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpses = partdefinition.addOrReplaceChild("CalcifiedCorpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpse1 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse1", CubeListBuilder.create(), PartPose.offset(11.0F, -13.2857F, 21.9286F));

		PartDefinition Leg_r1 = CalcifiedCorpse1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 6.8857F, -20.0286F, -2.6201F, 0.1322F, -2.7581F));

		PartDefinition Leg_r2 = CalcifiedCorpse1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.5F, 3.6857F, -20.3286F, -1.1149F, 0.2839F, 0.1365F));

		PartDefinition Arm_r1 = CalcifiedCorpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, 7.2857F, -26.9286F, 0.022F, 0.3899F, -1.2878F));

		PartDefinition Arm_r2 = CalcifiedCorpse1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(40, 51).addBox(0.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.3F, -1.1143F, -17.9286F, -1.2732F, -0.1039F, 0.0412F));

		PartDefinition TorsoBase_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.7F, 6.4857F, -17.4286F, -1.5708F, 1.3439F, 3.0194F));

		PartDefinition TorsoTop_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.8F, 4.4857F, -18.9286F, 1.5189F, 0.8715F, 0.1503F));

		PartDefinition Head_r1 = CalcifiedCorpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 5.7857F, -23.0286F, 0.575F, 1.2573F, 0.598F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		CalcifiedCorpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}