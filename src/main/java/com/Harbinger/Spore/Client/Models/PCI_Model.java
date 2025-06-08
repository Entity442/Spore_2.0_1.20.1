package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.4
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
import net.minecraft.world.entity.LivingEntity;

public class PCI_Model<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "pci_converted"), "main");
	public final ModelPart PCIBODY;
	private final ModelPart PCI;
	private final ModelPart body;
	private final ModelPart needle;
	private final ModelPart vial;
	private final ModelPart Main;
	private final ModelPart straps;

	public PCI_Model() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.PCIBODY = root.getChild("PCIBODY");
		this.PCI = this.PCIBODY.getChild("PCI");
		this.body = this.PCI.getChild("body");
		this.needle = this.PCI.getChild("needle");
		this.vial = this.PCI.getChild("vial");
		this.Main = this.vial.getChild("Main");
		this.straps = this.PCI.getChild("straps");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition PCIBODY = partdefinition.addOrReplaceChild("PCIBODY", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 1.0F));

		PartDefinition PCI = PCIBODY.addOrReplaceChild("PCI", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 10.0F, -1.0F, 0.0F, 1.5708F, -1.5708F));

		PartDefinition body = PCI.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, 1.0F, 4.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition needle = PCI.addOrReplaceChild("needle", CubeListBuilder.create().texOffs(0, 15).addBox(-1.0F, -2.5F, -24.0F, 0.0F, 2.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = needle.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(32, 0).addBox(-1.0F, 0.0F, -13.0F, 1.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -2.25F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition cube_r2 = needle.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(30, 15).addBox(-1.0F, -1.0F, -7.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.5F, 1.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition vial = PCI.addOrReplaceChild("vial", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = vial.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(16, 36).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0F, 10.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = vial.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(24, 35).addBox(-2.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.0F, 6.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r5 = vial.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 32).addBox(-2.0F, -2.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r6 = vial.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(24, 32).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.5F, 13.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition Main = vial.addOrReplaceChild("Main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Main.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 8).addBox(-2.0F, -8.0F, 0.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 2.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r8 = Main.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 36).addBox(-1.0F, -3.0F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -2.65F, 2.35F, -0.7854F, 0.0F, 0.0F));

		PartDefinition straps = PCI.addOrReplaceChild("straps", CubeListBuilder.create().texOffs(30, 25).addBox(-3.5F, -3.25F, 4.25F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-3.5F, -3.25F, 8.25F, 5.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		PCIBODY.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}