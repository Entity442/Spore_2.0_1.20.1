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

public class Seg9<T extends Entity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg9"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Corpses;
	private final ModelPart Corpse2;
	private final ModelPart Tumor;
	private final ModelPart Tendrils;
	private final ModelPart Tendril1;
	private final ModelPart Seg2Tendril1;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Tendril3;
	private final ModelPart Seg2Tendril3;

	public Seg9() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Corpses = root.getChild("Corpses");
		this.Corpse2 = this.Corpses.getChild("Corpse2");
		this.Tumor = root.getChild("Tumor");
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

		PartDefinition Corpse2 = Corpses.addOrReplaceChild("Corpse2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1714F, -7.4F, -2.1714F, 1.6804F, 0.0886F, 1.5366F));

		PartDefinition Head_r1 = Corpse2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 65).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.6F, -1.5708F, 1.4835F, -1.5708F));

		PartDefinition Tumor = partdefinition.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(0.3F, 15.85F, 4.175F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(6, 53).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.6F, 5.05F, -0.975F, -0.2618F, 0.0F, -0.2182F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, 1.65F, 0.325F, -0.2722F, -0.1886F, 0.1104F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(4, 52).addBox(-2.5F, -2.5F, -2.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2F, -2.35F, 0.325F, 0.48F, -0.6545F, 0.48F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(0, 50).addBox(-3.5F, -3.5F, -3.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, -4.35F, 0.325F, 3.0536F, 0.1304F, -0.4914F));

		PartDefinition Tendrils = partdefinition.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4367F, 12.1758F, -1.0721F, 1.5708F, 0.0F, 0.0F));

		PartDefinition Tendril1 = Tendrils.addOrReplaceChild("Tendril1", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.1835F, 2.5289F, 1.4834F, -1.8149F, 1.043F, -0.0873F));

		PartDefinition TendrilSegment_r1 = Tendril1.addOrReplaceChild("TendrilSegment_r1", CubeListBuilder.create().texOffs(15, 3).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril1 = Tendril1.addOrReplaceChild("Seg2Tendril1", CubeListBuilder.create().texOffs(15, 8).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0815F, 4.3197F, 0.0142F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.3584F, 1.4597F, -0.0199F, -1.4848F, -0.6291F, 0.0675F));

		PartDefinition TendrilSegment_r2 = Tendril2.addOrReplaceChild("TendrilSegment_r2", CubeListBuilder.create().texOffs(18, 1).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(17, 7).mirror().addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.0816F, 5.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.825F, -3.9886F, -1.4635F, -2.0367F, -1.2964F, -0.7068F));

		PartDefinition TendrilSegment_r3 = Tendril3.addOrReplaceChild("TendrilSegment_r3", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create().texOffs(16, 8).addBox(-0.5F, -0.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0816F, 2.3197F, 0.0142F, 0.0F, 0.0F, 0.6981F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateTentacleZ(Tendril1,Mth.cos(ageInTicks/7)/6);
		animateTentacleZ(Tendril2,-Mth.cos(ageInTicks/5)/6);
		animateTentacleZ(Tendril2,Mth.sin(ageInTicks/6)/5);
		animateTumor(Tumor,Mth.sin(ageInTicks/6)/6);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Corpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		Tumor.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Tendrils.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}