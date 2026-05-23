package com.Harbinger.Spore.Client.Models.DragonBits;// Made with Blockbench 5.1.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class DragonTailPieceEndModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragontailpieceendmodel"), "main");
	private final ModelPart yuri;
	private final ModelPart grabber;
	private final ModelPart pincer;
	private final ModelPart pincer_end;
	private final ModelPart pincer2;
	private final ModelPart pincer_end2;
	private final ModelPart pincer3;
	private final ModelPart pincer_end3;
	private final ModelPart pincer4;
	private final ModelPart pincer_end4;

	public DragonTailPieceEndModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yuri = root.getChild("yuri");
		this.grabber = this.yuri.getChild("grabber");
		this.pincer = this.grabber.getChild("pincer");
		this.pincer_end = this.pincer.getChild("pincer_end");
		this.pincer2 = this.grabber.getChild("pincer2");
		this.pincer_end2 = this.pincer2.getChild("pincer_end2");
		this.pincer3 = this.grabber.getChild("pincer3");
		this.pincer_end3 = this.pincer3.getChild("pincer_end3");
		this.pincer4 = this.grabber.getChild("pincer4");
		this.pincer_end4 = this.pincer4.getChild("pincer_end4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yuri = partdefinition.addOrReplaceChild("yuri", CubeListBuilder.create().texOffs(117, 120).addBox(0.2F, -16.1F, -9.5F, 9.0F, 24.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(103, 0).addBox(-1.8F, -9.6F, -10.5F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(72, 52).addBox(1.5F, -16.0F, -11.0F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 79).addBox(4.5F, -16.0F, -19.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.7F, 24.0F, 5.5F));

		PartDefinition grabber = yuri.addOrReplaceChild("grabber", CubeListBuilder.create(), PartPose.offset(0.0F, -19.0401F, 0.0F));

		PartDefinition pincer = grabber.addOrReplaceChild("pincer", CubeListBuilder.create().texOffs(135, 134).addBox(-1.5F, 16.94F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.7F, 2.0F, -5.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition pincer_end = pincer.addOrReplaceChild("pincer_end", CubeListBuilder.create().texOffs(125, 15).addBox(-5.6F, 14.54F, 0.0F, 14.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 3.4F, 0.0F, 0.0F, 0.0436F, 0.0436F));

		PartDefinition pincer2 = grabber.addOrReplaceChild("pincer2", CubeListBuilder.create().texOffs(135, 134).addBox(-1.5F, 16.94F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 2.0F, -5.0F, 3.1416F, 0.0F, 3.0543F));

		PartDefinition pincer_end2 = pincer2.addOrReplaceChild("pincer_end2", CubeListBuilder.create().texOffs(125, 15).addBox(-5.6F, 14.54F, 0.0F, 14.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 3.4F, 0.0F, 0.0F, 0.0436F, 0.0436F));

		PartDefinition pincer3 = grabber.addOrReplaceChild("pincer3", CubeListBuilder.create().texOffs(135, 134).addBox(-1.5F, 16.94F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7F, 2.0F, -10.0F, 1.5708F, 1.4835F, 1.5708F));

		PartDefinition pincer_end3 = pincer3.addOrReplaceChild("pincer_end3", CubeListBuilder.create().texOffs(125, 15).addBox(-5.6F, 14.54F, 0.0F, 14.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 3.4F, 0.0F, 0.0F, -0.0436F, 0.0436F));

		PartDefinition pincer4 = grabber.addOrReplaceChild("pincer4", CubeListBuilder.create().texOffs(135, 134).addBox(-1.5F, 16.94F, -2.5F, 4.0F, 14.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7F, 2.0F, 0.0F, -1.5708F, -1.4835F, 1.5708F));

		PartDefinition pincer_end4 = pincer4.addOrReplaceChild("pincer_end4", CubeListBuilder.create().texOffs(125, 15).addBox(-5.6F, 14.54F, 0.0F, 14.0F, 26.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1F, 3.4F, 0.0F, 0.0F, -0.0436F, 0.0436F));

		return LayerDefinition.create(meshdefinition, 153, 153);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		yuri.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}