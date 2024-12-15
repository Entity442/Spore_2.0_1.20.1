package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.EvolvedInfected.Nuclealave;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class NuckelaveArmorModel<T extends Nuclealave> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "nuckelavearmormodel"), "main");
	public final ModelPart ChestPlate;

	public NuckelaveArmorModel(ModelPart root) {
		this.ChestPlate = root.getChild("ChestPlate");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition ChestPlate = partdefinition.addOrReplaceChild("ChestPlate", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition TorsoBase_r1 = ChestPlate.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(16, 16).addBox(-4.5F, -6.0F, -2.5F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.5F, -27.1452F, -10.5653F, 0.3054F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r2 = ChestPlate.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(17, 20).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, -22.8605F, -9.0898F, 0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2, float v3) {

	}
}