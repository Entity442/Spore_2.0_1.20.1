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

public class FootSeg<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "footseg"), "main");
	private final ModelPart BaseSegment;
	private final ModelPart CalcifiedCorpses;
	private final ModelPart CalcifiedCorpse1;
	private final ModelPart CalcifiedCorpse2;

	public FootSeg() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.BaseSegment = root.getChild("BaseSegment");
		this.CalcifiedCorpses = root.getChild("CalcifiedCorpses");
		this.CalcifiedCorpse1 = this.CalcifiedCorpses.getChild("CalcifiedCorpse1");
		this.CalcifiedCorpse2 = this.CalcifiedCorpses.getChild("CalcifiedCorpse2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition BaseSegment = partdefinition.addOrReplaceChild("BaseSegment", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -16.0F, -4.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpses = partdefinition.addOrReplaceChild("CalcifiedCorpses", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition CalcifiedCorpse1 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.2F, -13.2857F, -0.0714F, 0.0F, -1.5708F, 2.618F));

		PartDefinition Leg_r1 = CalcifiedCorpse1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2F, -4.1143F, -3.1286F, -0.5655F, -0.0468F, -0.0737F));

		PartDefinition Leg_r2 = CalcifiedCorpse1.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -7.1143F, -3.9286F, -1.4976F, -0.2599F, 1.0413F));

		PartDefinition Arm_r1 = CalcifiedCorpse1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.1143F, -0.6286F, -2.5744F, 0.0F, 0.0F));

		PartDefinition Arm_r2 = CalcifiedCorpse1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(40, 51).addBox(0.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -5.7143F, -0.7286F, -2.3603F, 0.0945F, 0.1711F));

		PartDefinition TorsoBase_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4143F, 0.9714F, -1.5708F, 0.7418F, -1.5708F));

		PartDefinition TorsoTop_r1 = CalcifiedCorpse1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2143F, -0.3286F, 1.5708F, 1.2217F, 1.5708F));

		PartDefinition Head_r1 = CalcifiedCorpse1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 49).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.7143F, -0.4286F, -1.7973F, -0.3459F, -1.5408F));

		PartDefinition CalcifiedCorpse2 = CalcifiedCorpses.addOrReplaceChild("CalcifiedCorpse2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.3F, -13.2857F, -0.0714F, 0.1714F, 1.4698F, -2.5343F));

		PartDefinition Leg_r3 = CalcifiedCorpse2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.2F, -3.1143F, -0.5286F, -0.5655F, -0.0468F, -0.0737F));

		PartDefinition Leg_r4 = CalcifiedCorpse2.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(40, 53).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.4143F, -5.0286F, -1.7784F, 0.535F, 1.3129F));

		PartDefinition Arm_r3 = CalcifiedCorpse2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(40, 51).addBox(-3.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -6.7143F, 0.0714F, -2.5744F, 0.0F, 0.0F));

		PartDefinition Arm_r4 = CalcifiedCorpse2.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(40, 51).addBox(0.0F, -1.0F, -1.5F, 3.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.7143F, 0.0714F, -2.6616F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r2 = CalcifiedCorpse2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(44, 51).addBox(-1.5F, 0.0F, -3.5F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.4143F, 0.9714F, -1.5708F, 0.7418F, -1.5708F));

		PartDefinition TorsoTop_r2 = CalcifiedCorpse2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(32, 46).addBox(-2.0F, -3.5F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.2143F, 0.0714F, 0.0F, 1.5708F, 0.0F));

		PartDefinition Head_r2 = CalcifiedCorpse2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(32, 49).addBox(-3.0F, -6.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.2143F, -1.6286F, -1.828F, 0.5902F, -1.7641F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		BaseSegment.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		CalcifiedCorpses.render(poseStack, vertexConsumer, packedLight, packedOverlay, r,g,b, alpha);
	}
}