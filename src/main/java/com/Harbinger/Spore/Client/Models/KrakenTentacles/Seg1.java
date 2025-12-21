package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.client.model.EntityModel;
import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
public class Seg1<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation( new  ResourceLocation(Spore.MODID, "seg1"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Fin;
	private final ModelPart Tendrils;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;

	public Seg1() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Fin = root.getChild("Fin");
		this.Tendrils = root.getChild("Tendrils");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.Seg2Tendril3 = this.Tendril3.getChild("Seg2Tendril3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Fin = partdefinition.addOrReplaceChild("Fin", CubeListBuilder.create().texOffs(44, 4).addBox(-14.0F, -19.0F, 0.0F, 10.0F, 21.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition FinSupport2_r1 = Fin.addOrReplaceChild("FinSupport2_r1", CubeListBuilder.create().texOffs(38, 0).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition FinSupport1_r1 = Fin.addOrReplaceChild("FinSupport1_r1", CubeListBuilder.create().texOffs(38, 0).addBox(-11.0F, -1.0F, -1.0F, 11.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Tendrils = partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4367F, 12.1758F, -1.0721F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3584F, 1.4597F, -0.0199F, -1.4848F, -0.6291F, 0.0675F));

		PartDefinition TendrilSegment_r1 = Tendril2.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(18, 1).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(17, 7).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0816F, 5.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.825F, -3.9886F, -1.4635F, -2.0367F, -1.2964F, -0.7068F));

		PartDefinition TendrilSegment_r2 = Tendril3.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(16, 8).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0816F, 2.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTentacleY(Fin, Mth.cos(ageInTicks/7)/6);
		animateTentacleX(Tendril2, Mth.sin(ageInTicks/6)/6);
		animateTentacleY(Tendril3, Mth.cos(ageInTicks/8)/5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Fin.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}