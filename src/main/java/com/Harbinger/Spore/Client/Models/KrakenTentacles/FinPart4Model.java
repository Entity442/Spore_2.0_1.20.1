package com.Harbinger.Spore.Client.Models.KrakenTentacles;// Made with Blockbench 5.0.7
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

public class FinPart4Model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "finpart4model"), "main");
	private final ModelPart body;
	private final ModelPart CalciumCorpse;
	private final ModelPart Body2;

	public FinPart4Model() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.body = root.getChild("body");
		this.CalciumCorpse = this.body.getChild("CalciumCorpse");
		this.Body2 = this.body.getChild("Body2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, 0.0F, -8.0F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(30, 51).addBox(-1.25F, 18.25F, -6.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition FinMembrane1_r1 = body.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-0.01F, -1.0F, -2.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 19.75F, -3.0F, 0.0873F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r2 = body.addOrReplaceChild("FinMembrane1_r2", CubeListBuilder.create().texOffs(52, 0).addBox(0.0F, -1.0F, -2.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 16.25F, 3.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r3 = body.addOrReplaceChild("FinMembrane1_r3", CubeListBuilder.create().texOffs(52, 0).addBox(-0.01F, -1.0F, -2.0F, 0.0F, 6.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 10.25F, 8.0F, 1.4399F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = body.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(78, 15).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 1.25F, 8.0F, 1.5272F, 0.0F, 0.0F));

		PartDefinition FinSupport_r2 = body.addOrReplaceChild("FinSupport_r2", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 18.25F, 4.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition FinSupport_r3 = body.addOrReplaceChild("FinSupport_r3", CubeListBuilder.create().texOffs(30, 51).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 10.25F, 8.0F, 0.9163F, 0.0F, 0.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(48, 26).addBox(-5.0F, -5.0F, -2.0F, 8.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 17.0F, -4.25F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 26).addBox(-5.0F, -4.0F, -1.0F, 9.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 6.0F, -6.25F, -0.48F, 0.0F, 0.0F));

		PartDefinition CalciumCorpse = body.addOrReplaceChild("CalciumCorpse", CubeListBuilder.create(), PartPose.offsetAndRotation(2.9636F, 0.9705F, -2.7188F, 2.9616F, 0.3007F, 2.5906F));

		PartDefinition Jaw_r1 = CalciumCorpse.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(0, 67).addBox(-0.4113F, -3.5575F, -2.3292F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6781F, 7.4791F, 5.4634F, -0.6482F, -0.519F, 0.7629F));

		PartDefinition HeadBase_r1 = CalciumCorpse.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 51).addBox(-2.0F, -5.0F, -3.5F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.6413F, 9.2875F, 5.3779F, -0.3787F, 0.7826F, 0.127F));

		PartDefinition TorsoTop_r1 = CalciumCorpse.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(40, 72).addBox(-1.75F, -3.5F, -3.5F, 6.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.5187F, -0.6768F, 0.8409F));

		PartDefinition Arm2_r1 = CalciumCorpse.addOrReplaceChild("Arm2_r1", CubeListBuilder.create().texOffs(74, 0).addBox(-7.3902F, -2.3013F, -1.57F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0341F, 8.8319F, 4.3578F, 0.0F, -1.6144F, 0.0F));

		PartDefinition Arm1_r1 = CalciumCorpse.addOrReplaceChild("Arm1_r1", CubeListBuilder.create().texOffs(60, 72).addBox(-7.2686F, -2.364F, -2.0922F, 9.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0019F, 4.5889F, 4.534F, 0.3146F, -0.0424F, 1.5354F));

		PartDefinition TorsoBottom_r1 = CalciumCorpse.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(58, 59).addBox(4.25F, -4.0F, -4.0F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.3005F, -0.6768F, 0.8409F));

		PartDefinition Body2 = body.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0769F, 8.9175F, 3.2368F, 0.1074F, -1.1021F, -2.4676F));

		PartDefinition TorsoBase_r1 = Body2.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(52, 17).addBox(-4.0F, -2.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, -0.1988F, -0.6934F, 0.7795F, -0.461F, 0.0476F));

		PartDefinition Arm_r1 = Body2.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(18, 69).addBox(-1.081F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.543F, -2.0062F, 0.796F, 0.6441F, -0.3667F, -0.1205F));

		PartDefinition Arm_r2 = Body2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(18, 69).addBox(-1.081F, -0.6697F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, 3.9938F, -4.204F, 0.1867F, -0.2161F, 0.1034F));

		PartDefinition Arm_r3 = Body2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(74, 6).addBox(-3.0019F, -1.9253F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, 4.6507F, -7.0053F, 0.3089F, -0.9815F, -0.0943F));

		PartDefinition TorsoBottom_r2 = Body2.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(30, 59).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -6.0F, 0.4996F, -0.27F, -0.1446F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}