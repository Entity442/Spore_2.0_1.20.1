package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
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
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class FleshHorseArmorModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "fleshhorsearmormodel"), "main");
	public final ModelPart Body;
	public final ModelPart leftLung;
	public final ModelPart rightLung;
	public final ModelPart heart;
	public final ModelPart Neck;
	public final ModelPart Head;
	public final ModelPart BackLeftLeg;
	public final ModelPart BackRightLeg;
	public final ModelPart FrontLeftLeg;
	public final ModelPart FrontRightLeg;

	public FleshHorseArmorModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Body = root.getChild("Body");
		this.leftLung = this.Body.getChild("leftLung");
		this.rightLung = this.Body.getChild("rightLung");
		this.heart = this.Body.getChild("heart");
		this.Neck = root.getChild("Neck");
		this.Head = this.Neck.getChild("Head");
		this.BackLeftLeg = root.getChild("BackLeftLeg");
		this.BackRightLeg = root.getChild("BackRightLeg");
		this.FrontLeftLeg = root.getChild("FrontLeftLeg");
		this.FrontRightLeg = root.getChild("FrontRightLeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -8.0F, -20.0F, 10.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 9.0F));

		PartDefinition leftLung = Body.addOrReplaceChild("leftLung", CubeListBuilder.create().texOffs(64, 22).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.19F))
				.texOffs(64, 26).addBox(-0.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.15F, -1.75F, -20.0F, 0.0F, -0.1745F, -0.1745F));

		PartDefinition rightLung = Body.addOrReplaceChild("rightLung", CubeListBuilder.create().texOffs(16, 51).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F))
				.texOffs(16, 55).addBox(-1.5F, 0.5F, -1.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.0F, -1.75F, -20.0F, 0.0F, 0.1745F, 0.1745F));

		PartDefinition heart = Body.addOrReplaceChild("heart", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.1F, -1.45F, -19.05F, -0.0263F, -0.0832F, 0.3065F));

		PartDefinition body_r1 = heart.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(58, 37).addBox(-0.8381F, -0.5587F, -0.95F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-0.0752F, -0.8348F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r2 = heart.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(52, 37).addBox(0.8381F, -0.9413F, -1.05F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-1.2273F, -0.5898F, -0.35F, 0.0F, 0.0F, 1.1781F));

		PartDefinition body_r3 = heart.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(0, 8).addBox(-2.1619F, -2.9414F, -1.05F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-0.8252F, 0.4152F, -1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition Neck = partdefinition.addOrReplaceChild("Neck", CubeListBuilder.create().texOffs(0, 32).addBox(-2.0F, -11.0F, -3.0F, 4.0F, 12.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, -8.0F));

		PartDefinition Head = Neck.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(22, 32).addBox(-3.0F, -4.8F, -6.0F, 6.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(54, 47).addBox(-2.0F, -4.8F, -11.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.25F, 3.0F));

		PartDefinition brainthing_r1 = Head.addOrReplaceChild("brainthing_r1", CubeListBuilder.create().texOffs(1, 14).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, 1.0F, 0.5585F, 0.3378F, 0.2042F));

		PartDefinition brainthing_r2 = Head.addOrReplaceChild("brainthing_r2", CubeListBuilder.create().texOffs(1, 14).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 1.0F, 0.5585F, -0.3378F, -0.2042F));

		PartDefinition Head_r1 = Head.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.5236F, -0.5236F, 0.0F));

		PartDefinition Head_r2 = Head.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 0.0F, 0.5236F, 0.5236F, 0.0F));

		PartDefinition BackLeftLeg = partdefinition.addOrReplaceChild("BackLeftLeg", CubeListBuilder.create().texOffs(38, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(43, 0).addBox(2.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, 9.0F));

		PartDefinition BackRightLeg = partdefinition.addOrReplaceChild("BackRightLeg", CubeListBuilder.create().texOffs(22, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(43, 0).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, 9.0F));

		PartDefinition FrontLeftLeg = partdefinition.addOrReplaceChild("FrontLeftLeg", CubeListBuilder.create().texOffs(38, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(43, 0).addBox(2.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 13.0F, -9.0F));

		PartDefinition FrontRightLeg = partdefinition.addOrReplaceChild("FrontRightLeg", CubeListBuilder.create().texOffs(22, 44).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(43, 0).addBox(-3.0F, 0.0F, 0.0F, 1.0F, 11.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -9.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	private void animateHeart(float age){
		float val = Mth.sin(age/6)/6;
		this.heart.xScale = 1 + val;
		this.heart.zScale = 1 + val;
		this.heart.yScale = 1 - val;
	}
	private void animateLung(ModelPart part, float age){
		float val = Mth.sin(age/8)/4;
		part.xScale = 1 + val;
		part.yScale = 1 - val;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateHeart(ageInTicks);
		animateLung(leftLung,ageInTicks);
		animateLung(rightLung,ageInTicks);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		Neck.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		BackLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
		BackRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		FrontLeftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b,  alpha);
		FrontRightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}