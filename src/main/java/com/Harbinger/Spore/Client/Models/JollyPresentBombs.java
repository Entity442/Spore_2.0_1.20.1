package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Projectile.FleshBomb;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class JollyPresentBombs<T extends FleshBomb> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "jollypresentbombs"), "main");
	private final ModelPart RegularPresent;

	public JollyPresentBombs() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.RegularPresent = root.getChild("RegularPresent");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition RegularPresent = partdefinition.addOrReplaceChild("RegularPresent", CubeListBuilder.create().texOffs(0, 32).addBox(-8.0F, -0.3349F, -9.2188F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 40).addBox(-2.0F, -2.3349F, -3.2188F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 8.3349F, 1.2188F));

		PartDefinition SmallRibbon_r1 = RegularPresent.addOrReplaceChild("SmallRibbon_r1", CubeListBuilder.create().texOffs(51, 37).addBox(-3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8349F, -0.2188F, -0.0436F, -0.3927F, 0.0F));

		PartDefinition SmallRibbon_r2 = RegularPresent.addOrReplaceChild("SmallRibbon_r2", CubeListBuilder.create().texOffs(44, 37).addBox(0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.8349F, -0.2188F, -0.0436F, 0.3927F, 0.0F));

		PartDefinition Ribbon_r1 = RegularPresent.addOrReplaceChild("Ribbon_r1", CubeListBuilder.create().texOffs(0, 18).addBox(-6.0F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.3349F, -1.2188F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Ribbon_r2 = RegularPresent.addOrReplaceChild("Ribbon_r2", CubeListBuilder.create().texOffs(0, 18).addBox(0.0F, -1.0F, -2.0F, 6.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.3349F, -1.2188F, 0.0F, 0.0F, -0.3927F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		RegularPresent.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}