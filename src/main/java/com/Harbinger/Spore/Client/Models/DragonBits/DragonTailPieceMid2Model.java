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



public class DragonTailPieceMid2Model<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "dragontailpiecemid2model"), "main");
	private final ModelPart yuri;

	public DragonTailPieceMid2Model() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.yuri = root.getChild("yuri");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition yuri = partdefinition.addOrReplaceChild("yuri", CubeListBuilder.create().texOffs(72, 128).addBox(0.2F, -8.1F, -9.5F, 9.0F, 16.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(103, 0).addBox(-1.8F, -1.6F, -10.5F, 13.0F, 3.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(72, 52).addBox(1.5F, -8.0F, -11.0F, 6.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 79).addBox(4.5F, -8.0F, -19.0F, 0.0F, 16.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.7F, 16.0F, 5.5F));

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