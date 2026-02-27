package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Projectile.DrownedFleshBomb;
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

public class EDBiomassModel<T extends DrownedFleshBomb> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "edbiomassmodel"), "main");
	private final ModelPart Body;

	public EDBiomassModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Body = root.getChild("Body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 30).addBox(-1.0F, 6.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 16.0F, 0.0F));

		PartDefinition cube_r1 = Body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 10.0F, 1.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r2 = Body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(16, 30).addBox(-1.0F, -2.0F, 0.0F, 4.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 10.0F, -0.75F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Biomass_r1 = Body.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -2.5F, -2.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1007F, 2.144F, -1.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r2 = Body.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(0, 16).addBox(-11.0F, -3.0F, -5.0F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.4747F, 6.9019F, 6.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r3 = Body.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(28, 28).addBox(-1.0F, -2.0F, 7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.359F, 11.4212F, -7.4651F, -0.0687F, 0.5699F, -1.0785F));

		PartDefinition Biomass_r4 = Body.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(28, 16).addBox(-1.0F, -2.0F, 7.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.609F, -0.5788F, -11.4651F, -0.5151F, -0.3039F, -0.5625F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTumor(Body, Mth.sin(ageInTicks/6)/8);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}