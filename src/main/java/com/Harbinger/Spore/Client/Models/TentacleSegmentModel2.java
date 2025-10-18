package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.2
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
import net.minecraft.world.entity.Entity;

public class TentacleSegmentModel2<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "tentaclesegmentmodel"), "main");
	private final ModelPart body;
	private final ModelPart Biomass;
	private final ModelPart Biomass2;

	public TentacleSegmentModel2() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.body = root.getChild("body");
		this.Biomass = root.getChild("Biomass");
		this.Biomass2 = root.getChild("Biomass2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 7).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Fungus_r1 = body.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, 1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -11.55F, -1.45F, 0.3325F, -0.5755F, 0.0523F));

		PartDefinition Biomass = partdefinition.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(-0.4597F, 21.9866F, -0.332F));

		PartDefinition Biomass4_r1 = Biomass.addOrReplaceChild("Biomass4_r1", CubeListBuilder.create().texOffs(12, 22).addBox(-3.5F, -1.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.677F, 1.8005F, 0.2635F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Biomass3_r1 = Biomass.addOrReplaceChild("Biomass3_r1", CubeListBuilder.create().texOffs(12, 22).addBox(-2.5F, -0.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5599F, -1.0913F, 0.0862F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Biomass2_r1 = Biomass.addOrReplaceChild("Biomass2_r1", CubeListBuilder.create().texOffs(8, 20).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2846F, -0.1518F, -0.6794F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Biomass2 = partdefinition.addOrReplaceChild("Biomass2", CubeListBuilder.create(), PartPose.offset(-1.4597F, 9.9866F, -0.082F));

		PartDefinition Biomass3_r2 = Biomass2.addOrReplaceChild("Biomass3_r2", CubeListBuilder.create().texOffs(12, 22).addBox(-2.5F, -0.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5599F, -4.0913F, -0.9138F, 0.3699F, -0.7124F, -0.2154F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Biomass, Mth.sin(ageInTicks/8)/6);
		animateTumor(Biomass2, Mth.cos(ageInTicks/8)/7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Biomass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Biomass2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}