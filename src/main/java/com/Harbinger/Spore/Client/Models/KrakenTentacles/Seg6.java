package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.5
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

public class Seg6<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "seg6"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart Corpses;
	private final ModelPart Corpse1;

	public Seg6() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.Corpses = root.getChild("Corpses");
		this.Corpse1 = this.Corpses.getChild("Corpse1");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Corpses = partdefinition.addOrReplaceChild("Corpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Corpse1 = Corpses.addOrReplaceChild("Corpse1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.8F, -0.2857F, -2.3714F, 0.0F, -1.0559F, 0.0F));

		PartDefinition Arm_r1 = Corpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(42, 86).addBox(0.0F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.6F, -6.7143F, 0.0714F, 0.7743F, -0.2223F, -0.0735F));

		PartDefinition TorsoTop_r1 = Corpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(36, 81).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2143F, -0.4286F, 1.5359F, 1.5184F, 1.5708F));

		PartDefinition Head_r1 = Corpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 65).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.6143F, 0.5714F, -1.5708F, 1.3265F, -1.5708F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		Corpses.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}