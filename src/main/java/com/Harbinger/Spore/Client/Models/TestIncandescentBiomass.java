package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.IncandescentCoreEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TestIncandescentBiomass<T extends IncandescentCoreEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "incandescent"), "main");
	private final ModelPart bone;

	public TestIncandescentBiomass() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.bone = root.getChild("bone");
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		this.bone.xScale = 1 + Mth.sin(ageInTicks/8)/6;
		this.bone.yScale = 1 + Mth.sin(ageInTicks/8)/6;
		this.bone.zScale = 1 + Mth.sin(ageInTicks/8)/6;
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

		PartDefinition TumorBase = bone.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-1.0F, 5.0F, 0.0F));

		PartDefinition Tumor_r1 = TumorBase.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(76, 91).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, -3.0F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r2 = TumorBase.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(86, 98).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7887F, 0.3719F, 9.2916F, 0.2065F, -0.2714F, 1.1548F));

		PartDefinition Tumor_r3 = TumorBase.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(81, 96).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7887F, -0.6281F, 2.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r4 = TumorBase.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(78, 92).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7887F, 0.6281F, -4.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r5 = TumorBase.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(74, 90).addBox(-10.0F, -10.0F, -5.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, 3.0F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition TumorBase2 = bone.addOrReplaceChild("TumorBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -6.0F, 0.0F, 0.0F, -0.2182F, -3.1416F));

		PartDefinition Tumor_r6 = TumorBase2.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(76, 91).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -4.0F, -3.0F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r7 = TumorBase2.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(86, 98).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.7887F, 0.3719F, 9.2916F, 0.2065F, -0.2714F, 1.1548F));

		PartDefinition Tumor_r8 = TumorBase2.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(81, 96).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7887F, -0.6281F, 2.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r9 = TumorBase2.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(78, 92).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7887F, 0.6281F, -4.2916F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r10 = TumorBase2.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(74, 90).addBox(-10.0F, -10.0F, -5.0F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 4.0F, 3.0F, 0.2359F, 0.422F, 0.5307F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}