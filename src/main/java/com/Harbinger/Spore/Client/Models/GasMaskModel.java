package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.8.3
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

public class GasMaskModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "gas_mask_half"), "main");
	public final ModelPart GasMask;

	public GasMaskModel(ModelPart root) {
		this.GasMask = root.getChild("GasMask");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition GasMask = partdefinition.addOrReplaceChild("GasMask", CubeListBuilder.create(), PartPose.offset(0.05F, 1.0F, 0.0F));

		PartDefinition Basefilter = GasMask.addOrReplaceChild("Basefilter", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base = Basefilter.addOrReplaceChild("Base", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -11.24F, 2.74F, 8.0F, 4.0F, 2.0F, new CubeDeformation(-0.75F))
		.texOffs(20, 0).addBox(-6.0F, -10.0F, 3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-4.0F, -11.0F, 4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-13.0F, -10.0F, 3.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 12).addBox(-13.0F, -11.0F, 4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 8.0F, -8.0F));

		PartDefinition baseLeftSmoohside_r1 = Base.addOrReplaceChild("baseLeftSmoohside_r1", CubeListBuilder.create().texOffs(20, 0).addBox(5.55F, 0.25F, 0.0F, 2.9F, 1.5F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(20, 0).addBox(-1.45F, 0.25F, 0.0F, 2.9F, 1.5F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.5F, -11.5F, 3.5F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Filter = Basefilter.addOrReplaceChild("Filter", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Filter1 = Filter.addOrReplaceChild("Filter1", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5196F, -1.55F, -5.8483F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Filter1Cap_r1 = Filter1.addOrReplaceChild("Filter1Cap_r1", CubeListBuilder.create().texOffs(7, 17).addBox(-2.5F, -0.05F, -1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 6).addBox(-2.0F, 0.45F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0196F, -0.45F, -0.1517F, 0.0F, 0.3927F, 0.0F));

		PartDefinition Filter2 = Filter.addOrReplaceChild("Filter2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4196F, -1.55F, -5.8483F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Filter1Cap_r2 = Filter2.addOrReplaceChild("Filter1Cap_r2", CubeListBuilder.create().texOffs(7, 17).addBox(-0.5F, -0.05F, -1.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(16, 6).addBox(0.0F, 0.45F, -0.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0196F, -0.45F, -0.1517F, 0.0F, -0.3927F, 0.0F));

		PartDefinition Straps = GasMask.addOrReplaceChild("Straps", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition TopStraps = Straps.addOrReplaceChild("TopStraps", CubeListBuilder.create(), PartPose.offset(4.5F, -2.5F, 1.5F));

		PartDefinition StrapRight_r1 = TopStraps.addOrReplaceChild("StrapRight_r1", CubeListBuilder.create().texOffs(0, 6).addBox(-4.5F, 0.5F, 0.0F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.55F, -2.5F, 2.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition StrapRight_r2 = TopStraps.addOrReplaceChild("StrapRight_r2", CubeListBuilder.create().texOffs(0, 1).addBox(-9.05F, -0.75F, -2.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(0.0F, -0.75F, -2.5F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition TopStraps2 = Straps.addOrReplaceChild("TopStraps2", CubeListBuilder.create().texOffs(0, 1).addBox(0.0F, 1.25F, -3.25F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1).addBox(-9.05F, 1.25F, -3.25F, 0.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 6).addBox(-9.05F, 1.25F, 2.75F, 9.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, -2.5F, 1.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		GasMask.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}