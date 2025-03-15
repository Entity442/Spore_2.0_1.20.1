package com.Harbinger.Spore.Client.Models.NukeParts;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.Utility.NukeEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
public class FireDiskModel<T extends NukeEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "firediskmodel"), "main");
	private final ModelPart fire_disk;

	public FireDiskModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.fire_disk = root.getChild("fire_disk");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition fire_disk = partdefinition.addOrReplaceChild("fire_disk", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, 27.0F, -40.0F, 80.0F, 0.0F, 80.0F, new CubeDeformation(0.0F))
		.texOffs(0, 80).addBox(-24.0F, 1.0F, -24.0F, 48.0F, 0.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.fire_disk.yRot = ageInTicks * 0.01f;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		fire_disk.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}