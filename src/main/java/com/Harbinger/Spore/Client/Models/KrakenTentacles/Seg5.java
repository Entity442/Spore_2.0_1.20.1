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

public class Seg5<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg5"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart CalcifiedCorpses;
	private final ModelPart CalcifiedCorpse1;
	private final ModelPart CalcifiedCorpse2;

	public Seg5() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.CalcifiedCorpses = root.getChild("CalcifiedCorpses");
		this.CalcifiedCorpse1 = this.CalcifiedCorpses.getChild("CalcifiedCorpse1");
		this.CalcifiedCorpse2 = this.CalcifiedCorpses.getChild("CalcifiedCorpse2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpses = partdefinition.addOrReplaceChild("CalcifiedCorpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpse1 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse1", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0F, -8.2857F, -1.0714F, -1.0468F, -0.0378F, -1.4617F));

		PartDefinition Leg_r1 = CalcifiedCorpse1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -5.7143F, -18.2286F, -2.4342F, 0.6419F, -0.6109F));

		PartDefinition Leg_r2 = CalcifiedCorpse1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.7143F, -18.9286F, -2.1827F, -0.0991F, 0.3538F));

		PartDefinition Arm_r1 = CalcifiedCorpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -13.6143F, -11.2286F, -0.4451F, -0.4345F, 0.6254F));

		PartDefinition Arm_r2 = CalcifiedCorpse1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(40, 51).addBox(0.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -12.7143F, -13.9286F, -2.2153F, -0.28F, -0.3932F));

		PartDefinition TorsoBase_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -8.7143F, -13.9286F, -1.5708F, 0.5672F, -1.5708F));

		PartDefinition TorsoTop_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -12.2143F, -13.9286F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Head_r1 = CalcifiedCorpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -11.9143F, -18.2286F, -1.5037F, 0.9647F, -1.4632F));

		PartDefinition CalcifiedCorpse2 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse2", CubeListBuilder.create().texOffs(40, 51).addBox(3.3F, -5.6143F, -17.5286F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.0F, -8.2857F, -0.0714F, 1.5708F, -0.7418F, -1.5708F));

		PartDefinition Leg_r3 = CalcifiedCorpse2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4F, 5.6857F, -15.9286F, -1.3168F, 0.7765F, -2.0048F));

		PartDefinition Arm_r3 = CalcifiedCorpse2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6F, -5.1143F, -17.2286F, -1.7516F, 0.4252F, -0.6813F));

		PartDefinition TorsoBase_r2 = CalcifiedCorpse2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.6143F, -16.4286F, -2.7301F, 1.4787F, -2.3198F));

		PartDefinition TorsoTop_r2 = CalcifiedCorpse2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -3.1143F, -16.6286F, 1.3788F, 1.4835F, 1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		CalcifiedCorpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}