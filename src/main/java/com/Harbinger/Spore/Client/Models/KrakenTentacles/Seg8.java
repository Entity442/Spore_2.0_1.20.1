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

public class Seg8<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg8"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Tumor;

	public Seg8() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Tumor = root.getChild("Tumor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Tumor = partdefinition.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(-0.75F, 16.625F, -0.25F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.75F, 6.375F, -3.25F, -0.2697F, -1.2535F, 0.065F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -7.125F, -3.25F, -1.2327F, 0.0886F, 0.2333F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 2.875F, 3.75F, 3.0543F, -0.5236F, -0.48F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -2.125F, 2.75F, -0.858F, -0.7626F, 1.0417F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Tumor,Mth.cos(ageInTicks/7)/8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Tumor.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}