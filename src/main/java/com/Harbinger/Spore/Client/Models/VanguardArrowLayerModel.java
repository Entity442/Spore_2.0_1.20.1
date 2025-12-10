package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Utility.Vanguard;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class VanguardArrowLayerModel<T extends Vanguard> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "vanguardarrowlayermodel"), "main");
	private final ModelPart arrowLayer;
	private final ModelPart arrow;
	private final ModelPart cross_2;
	private final ModelPart cross_1;
	private final ModelPart back;
	private final ModelPart arrow2;
	private final ModelPart cross_3;
	private final ModelPart cross_4;
	private final ModelPart back2;
	private final ModelPart arrow3;
	private final ModelPart cross_5;
	private final ModelPart cross_6;
	private final ModelPart back3;

	public VanguardArrowLayerModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.arrowLayer = root.getChild("arrowLayer");
		this.arrow = this.arrowLayer.getChild("arrow");
		this.cross_2 = this.arrow.getChild("cross_2");
		this.cross_1 = this.arrow.getChild("cross_1");
		this.back = this.arrow.getChild("back");
		this.arrow2 = this.arrowLayer.getChild("arrow2");
		this.cross_3 = this.arrow2.getChild("cross_3");
		this.cross_4 = this.arrow2.getChild("cross_4");
		this.back2 = this.arrow2.getChild("back2");
		this.arrow3 = this.arrowLayer.getChild("arrow3");
		this.cross_5 = this.arrow3.getChild("cross_5");
		this.cross_6 = this.arrow3.getChild("cross_6");
		this.back3 = this.arrow3.getChild("back3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition arrowLayer = partdefinition.addOrReplaceChild("arrowLayer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition arrow = arrowLayer.addOrReplaceChild("arrow", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -25.5F, -1.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cross_2 = arrow.addOrReplaceChild("cross_2", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.7854F, 1.5708F, 0.0F));

		PartDefinition cross_1 = arrow.addOrReplaceChild("cross_1", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -2.3562F, 1.5708F, 0.0F));

		PartDefinition back = arrow.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, -2.3562F, 1.5708F, 0.0F));

		PartDefinition arrow2 = arrowLayer.addOrReplaceChild("arrow2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -23.5F, 1.0F, -2.7489F, 0.0F, 0.0F));

		PartDefinition cross_3 = arrow2.addOrReplaceChild("cross_3", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.7854F, 1.5708F, 0.0F));

		PartDefinition cross_4 = arrow2.addOrReplaceChild("cross_4", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -2.3562F, 1.5708F, 0.0F));

		PartDefinition back2 = arrow2.addOrReplaceChild("back2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, -2.3562F, 1.5708F, 0.0F));

		PartDefinition arrow3 = arrowLayer.addOrReplaceChild("arrow3", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, -30.5F, -2.0F, 2.5481F, 0.7703F, -0.1719F));

		PartDefinition cross_5 = arrow3.addOrReplaceChild("cross_5", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -0.7854F, 1.5708F, 0.0F));

		PartDefinition cross_6 = arrow3.addOrReplaceChild("cross_6", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -2.5F, 0.0F, 16.0F, 5.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 4.0F, -2.3562F, 1.5708F, 0.0F));

		PartDefinition back3 = arrow3.addOrReplaceChild("back3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -2.5F, -2.5F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 15.0F, -2.3562F, 1.5708F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b , float alpha){
		arrowLayer.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}