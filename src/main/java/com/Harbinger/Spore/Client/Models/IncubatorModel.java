package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.IncubatorBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class IncubatorModel<T extends IncubatorBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "incubator"), "main");
	private final ModelPart incubator;
	private final ModelPart Juice;
	private final ModelPart Hatch;
	private final ModelPart Piston;
	private final ModelPart Piston1;

	public IncubatorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.incubator = root.getChild("incubator");
		this.Juice = incubator.getChild("Juicy");
		this.Hatch  = incubator.getChild("Top").getChild("Hatch");
		this.Piston = incubator.getChild("Top").getChild("SideTubes").getChild("NorthTubes");
		this.Piston1 = incubator.getChild("Top").getChild("SideTubes").getChild("SouthTubes");
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		if (entity.isActive()){
			Juice.yScale = 1 + Mth.cos(ageInTicks/8)/8;
			Piston.yScale = 1 + Mth.cos(ageInTicks/6)/6;;
			Piston1.yScale = 1 - Mth.cos(ageInTicks/6)/6;;
		}else{
			Juice.yScale = 0.2f;
			Piston.yScale = 1;
			Piston1.yScale = 1;
		}
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition incubator = partdefinition.addOrReplaceChild("incubator", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, -11.0F, -8.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -11.0F, -8.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-8.0F, -11.0F, 6.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(6.0F, -11.0F, 6.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Glass = incubator.addOrReplaceChild("Glass", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -11.0F, -7.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-6.0F, -11.0F, 7.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition WestPane_r1 = Glass.addOrReplaceChild("WestPane_r1", CubeListBuilder.create().texOffs(48, 0).addBox(-6.0F, -5.0F, -7.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-6.0F, -5.0F, 7.0F, 12.0F, 9.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition Juicy = incubator.addOrReplaceChild("Juicy", CubeListBuilder.create().texOffs(0, 18).addBox(-6.5F, -9.01F, -6.5F, 13.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition Top = incubator.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(6, 6).addBox(-8.0F, -2.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(19, 6).addBox(5.0F, -2.0F, -5.0F, 3.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(13, 13).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(45, 27).addBox(6.0F, -3.0F, -5.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(45, 27).addBox(6.0F, -3.0F, 3.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, 0.0F));

		PartDefinition TopBase_r1 = Top.addOrReplaceChild("TopBase_r1", CubeListBuilder.create().texOffs(13, 13).mirror().addBox(-8.0F, -1.0F, -1.5F, 16.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 6.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Hatch = Top.addOrReplaceChild("Hatch", CubeListBuilder.create().texOffs(39, 18).addBox(-11.0F, -1.0F, -6.0F, 12.0F, 1.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -2.0F, 0.0F));

		PartDefinition Handle = Hatch.addOrReplaceChild("Handle", CubeListBuilder.create().texOffs(39, 18).addBox(-1.0F, -0.6667F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(-0.5F, -0.6667F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(-0.5F, -0.6667F, -4.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(-4.0F, -0.6667F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(1.0F, -0.6667F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, -2.0F, -0.3333F));

		PartDefinition HandleRod_r1 = Handle.addOrReplaceChild("HandleRod_r1", CubeListBuilder.create().texOffs(39, 18).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.8333F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Wheel = Handle.addOrReplaceChild("Wheel", CubeListBuilder.create().texOffs(39, 18).addBox(-1.5F, -8.6667F, -4.1833F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(39, 18).addBox(3.15F, -8.6667F, -8.8333F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.05F))
		.texOffs(39, 18).addBox(-1.5F, -8.6667F, -11.4833F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.05F))
		.texOffs(39, 18).addBox(-4.15F, -8.6667F, -8.8333F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.05F)), PartPose.offset(0.0F, 8.0F, 7.3333F));

		PartDefinition WheelCornerSE_r1 = Wheel.addOrReplaceChild("WheelCornerSE_r1", CubeListBuilder.create().texOffs(39, 18).addBox(2.75F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(-3.75F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0048F, -8.1567F, -7.3235F, 0.0F, 2.3562F, 0.0F));

		PartDefinition WheelCornerSE_r2 = Wheel.addOrReplaceChild("WheelCornerSE_r2", CubeListBuilder.create().texOffs(39, 18).addBox(-7.25F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(39, 18).addBox(-0.75F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4797F, -8.1567F, -9.7983F, 0.0F, 0.7854F, 0.0F));

		PartDefinition SideTubes = Top.addOrReplaceChild("SideTubes", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition NorthTubes = SideTubes.addOrReplaceChild("NorthTubes", CubeListBuilder.create().texOffs(0, 45).addBox(-3.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(1.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0607F, -5.9393F, 0.7854F, 0.0F, 0.0F));

		PartDefinition SouthTubes = SideTubes.addOrReplaceChild("SouthTubes", CubeListBuilder.create().texOffs(0, 45).addBox(-5.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(3.0F, -3.5F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0607F, 5.9393F, -0.7854F, 0.0F, 0.0F));

		PartDefinition Vial1 = SideTubes.addOrReplaceChild("Vial1", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
		.texOffs(15, 19).addBox(-1.5F, -4.5F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.5F, -4.0F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(0, 18).addBox(-2.0F, -5.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offset(-6.0F, 2.1F, -1.0F));

		PartDefinition Vial2 = SideTubes.addOrReplaceChild("Vial2", CubeListBuilder.create().texOffs(0, 18).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F))
		.texOffs(15, 19).addBox(-1.5F, -4.5F, -1.5F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(48, 0).addBox(-1.5F, -4.0F, -1.5F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(0, 18).mirror().addBox(-2.0F, -5.0F, -2.0F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.1F)).mirror(false), PartPose.offset(-5.5F, 3.1F, 3.0F));

		PartDefinition Display = incubator.addOrReplaceChild("Display", CubeListBuilder.create().texOffs(0, 11).addBox(-1.4997F, -0.3247F, -1.5003F, 3.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(16, 14).addBox(0.5003F, -0.5247F, -1.5003F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(16, 14).addBox(-1.4997F, -0.5247F, -1.5003F, 1.0F, 1.0F, 3.0F, new CubeDeformation(-0.4F))
		.texOffs(16, 16).addBox(-1.5007F, -0.5257F, -1.4993F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F))
		.texOffs(16, 16).addBox(-1.5007F, -0.5257F, 0.5007F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-7.0003F, -7.6753F, -8.1497F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Needle = Display.addOrReplaceChild("Needle", CubeListBuilder.create().texOffs(45, 27).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(0.0003F, 0.0853F, -0.8503F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}


	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		incubator.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}