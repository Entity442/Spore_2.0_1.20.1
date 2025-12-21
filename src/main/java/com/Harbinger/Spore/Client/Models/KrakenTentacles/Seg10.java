package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
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

public class Seg10<T extends Entity> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg10"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Tumor1;
	private final ModelPart Tumor2;

	public Seg10() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Tumor1 = root.getChild("Tumor1");
		this.Tumor2 = root.getChild("Tumor2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Tumor1 = partdefinition.addOrReplaceChild("Tumor1", CubeListBuilder.create(), PartPose.offset(-1.0F, 14.625F, -2.025F));

		PartDefinition Biomass_r1 = Tumor1.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 0.375F, -2.475F, -0.3053F, 0.1273F, 1.3936F));

		PartDefinition Biomass_r2 = Tumor1.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 2.875F, -0.575F, 0.4943F, -0.2316F, -0.1231F));

		PartDefinition Biomass_r3 = Tumor1.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -4.125F, -1.475F, -1.9837F, -0.3736F, 1.4469F));

		PartDefinition Biomass_r4 = Tumor1.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.875F, 4.525F, -0.4548F, -0.276F, 0.1325F));

		PartDefinition Tumor2 = partdefinition.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offset(4.175F, 20.375F, 1.15F));

		PartDefinition Biomass_r5 = Tumor2.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.675F, -8.375F, 2.95F, -3.0053F, -0.248F, 2.9338F));

		PartDefinition Biomass_r6 = Tumor2.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.975F, 0.125F, 2.35F, -0.6805F, 0.0719F, 0.2236F));

		PartDefinition Biomass_r7 = Tumor2.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.675F, -3.875F, -1.65F, 0.3208F, -0.9067F, -0.9856F));

		PartDefinition Biomass_r8 = Tumor2.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.675F, 0.125F, -3.65F, -0.5409F, 0.8934F, 0.914F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Tumor1, Mth.sin(ageInTicks/6)/7);
		animateTumor(Tumor2, Mth.cos(ageInTicks/7)/4);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Tumor1.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Tumor2.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}