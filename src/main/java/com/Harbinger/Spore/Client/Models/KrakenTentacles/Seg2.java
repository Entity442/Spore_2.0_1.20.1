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
public class Seg2<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg2"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Corpses;
	private final ModelPart Corpse1;
	private final ModelPart Corpse2;
	private final ModelPart Tendrils;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;

	public Seg2() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Corpses = root.getChild("Corpses");
		this.Corpse1 = this.Corpses.getChild("Corpse1");
		this.Corpse2 = this.Corpses.getChild("Corpse2");
		this.Tendrils = root.getChild("Tendrils");
		this.Tendril1 = this.Tendrils.getChild("Tendril1");
		this.Seg2Tendril1 = this.Tendril1.getChild("Seg2Tendril1");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.Seg2Tendril3 = this.Tendril3.getChild("Seg2Tendril3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Corpses = partdefinition.addOrReplaceChild("Corpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Corpse1 = Corpses.addOrReplaceChild("Corpse1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.6F, -0.2857F, 0.6286F, 0.0F, -1.7104F, 0.0F));

		PartDefinition Arm_r1 = Corpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(42, 86).addBox(0.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -6.7143F, 0.0714F, 0.7743F, -0.2223F, -0.0735F));

		PartDefinition TorsoTop_r1 = Corpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(36, 81).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2143F, -0.4286F, 1.5359F, 1.5184F, 1.5708F));

		PartDefinition Head_r1 = Corpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 65).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.9143F, 1.0714F, -1.5708F, 1.1694F, -1.5708F));

		PartDefinition Corpse2 = Corpses.addOrReplaceChild("Corpse2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1714F, -7.4F, -2.1714F, 1.6804F, 0.0886F, 1.5366F));

		PartDefinition Head_r2 = Corpse2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(32, 65).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.6F, -1.5708F, 1.4835F, -1.5708F));

		PartDefinition Tendrils = partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4367F, 12.1758F, -1.0721F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.1835F, 2.5289F, 1.4834F, -1.8149F, 1.043F, -0.0873F));

		PartDefinition TendrilSegment_r1 = Tendril1.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(15, 3).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3584F, 1.4597F, -2.5199F, -1.3586F, -1.2347F, -0.0825F));

		PartDefinition TendrilSegment_r2 = Tendril2.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(18, 1).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(17, 7).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0816F, 5.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.825F, -3.9886F, -1.4635F, -2.0367F, -1.2964F, -0.7068F));

		PartDefinition TendrilSegment_r3 = Tendril3.addOrReplaceChild("TendrilSegment_r3", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(16, 8).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0816F, 2.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.animateTentacleZ(Tendril1,Mth.sin(ageInTicks/6)/6);
		this.animateTentacleX(Tendril2,Mth.cos(ageInTicks/7)/7);
		this.animateTentacleY(Tendril3,Mth.sin(ageInTicks/9)/4);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Corpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,alpha);
		Tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
	}
}