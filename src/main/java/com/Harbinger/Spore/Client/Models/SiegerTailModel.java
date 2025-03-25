package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.3
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.FallenMultipart.SiegerTail;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.GoatModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.fml.common.Mod;

public class SiegerTailModel<T extends SiegerTail> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "siegertailmodel"), "main");
	private final ModelPart gore;
	private final ModelPart tail5;
	private final ModelPart tail6;
	private final ModelPart tail7;
	private final ModelPart TumorBase3;
	private final ModelPart tail8;
	private final ModelPart tumor2;
	private final ModelPart TumorBase;
	private final ModelPart TumorBase2;

	public SiegerTailModel(ModelPart root) {
		this.gore = root.getChild("gore");
		this.tail5 = root.getChild("tail5");
		this.tail6 = this.tail5.getChild("tail6");
		this.tail7 = this.tail6.getChild("tail7");
		this.TumorBase3 = this.tail7.getChild("TumorBase3");
		this.tail8 = this.tail7.getChild("tail8");
		this.tumor2 = this.tail8.getChild("tumor2");
		this.TumorBase = this.tumor2.getChild("TumorBase");
		this.TumorBase2 = this.tumor2.getChild("TumorBase2");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gore = partdefinition.addOrReplaceChild("gore", CubeListBuilder.create().texOffs(0, 1).addBox(-1.0F, -2.0F, -15.0F, 2.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(2, 0).addBox(-4.0F, -3.0F, -14.0F, 3.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(11, 3).addBox(-1.0F, -5.0F, -13.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 6).addBox(-3.0F, -5.0F, -12.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(12, 4).addBox(-5.0F, -2.0F, -13.0F, 2.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 21.0F, -7.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition tail5 = partdefinition.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(97, 0).addBox(-5.0F, -4.2201F, -27.863F, 10.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.0F, 20.0F, 15.0F, 0.0F, 0.0F, 1.5708F));

		PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(119, 206).addBox(-4.5F, -5.9163F, -0.0826F, 9.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -2.0F, 1.0908F, 0.0F, 0.0F));

		PartDefinition flower27 = tail6.addOrReplaceChild("flower27", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.5F, 9.75F, 1.3687F, -0.9903F, -1.3305F));

		PartDefinition cube_r1 = flower27.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition tail7 = tail6.addOrReplaceChild("tail7", CubeListBuilder.create().texOffs(191, 206).addBox(-4.0F, -4.9388F, 0.2976F, 8.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 26.0F, 1.3963F, 0.0F, 0.0F));

		PartDefinition TumorBase3 = tail7.addOrReplaceChild("TumorBase3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8438F, -2.7921F, 4.1882F, 0.0F, 0.0F, 2.9671F));

		PartDefinition Biomass_r1 = TumorBase3.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9444F, -0.6516F, -4.1062F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = TumorBase3.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8273F, -0.3149F, 3.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = TumorBase3.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6309F, 1.1063F, 6.6738F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = TumorBase3.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5473F, -4.3744F, -11.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition tail8 = tail7.addOrReplaceChild("tail8", CubeListBuilder.create().texOffs(55, 225).addBox(-3.5F, -6.6187F, 0.0213F, 7.0F, 10.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 27.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition tumor2 = tail8.addOrReplaceChild("tumor2", CubeListBuilder.create().texOffs(123, 243).addBox(-8.0F, -9.6187F, 5.0213F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-6.0F, -8.6187F, -1.9787F, 12.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 26.0F, 1.4835F, 0.3491F, 0.0F));

		PartDefinition TumorBase = tumor2.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(2.1562F, 6.2079F, 8.1882F));

		PartDefinition Biomass_r5 = TumorBase.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = TumorBase.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = TumorBase.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = TumorBase.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r9 = TumorBase.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(132, 249).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7284F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition TumorBase2 = tumor2.addOrReplaceChild("TumorBase2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.1562F, -4.7921F, 5.1882F, 0.0F, 0.0F, 2.9671F));

		PartDefinition Biomass_r10 = TumorBase2.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(134, 251).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.8989F, -0.1307F, 0.8938F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r11 = TumorBase2.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(136, 252).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7817F, 0.206F, 8.7818F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r12 = TumorBase2.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(137, 254).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6765F, 1.6273F, -4.3262F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r13 = TumorBase2.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(137, 253).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5928F, -3.8534F, -6.2058F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r14 = TumorBase2.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(132, 249).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0887F, 0.7284F, -4.7513F, -0.329F, -1.0983F, 1.1961F));

		PartDefinition flower28 = tail7.addOrReplaceChild("flower28", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -3.5F, 9.75F, 1.3326F, -0.1096F, -0.4232F));

		PartDefinition cube_r2 = flower28.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower29 = tail7.addOrReplaceChild("flower29", CubeListBuilder.create().texOffs(152, 8).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(92, 141).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 206).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 5.5F, 14.75F, 1.3326F, -0.1096F, -0.4232F));

		PartDefinition cube_r3 = flower29.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(205, 143).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	void animateGore(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/10)/11;
		part.yScale = 1 - Mth.cos(value/12)/11;
		part.zScale = 1 + Mth.cos(value/11)/10;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		animateGore(gore,ageInTicks);
		animateTumor(TumorBase,Mth.sin(ageInTicks/7)/6);
		animateTumor(TumorBase2,Mth.cos(ageInTicks/6)/9);
		animateTumor(TumorBase3,-Mth.sin(ageInTicks/7)/8);
		animateTentacleX(tail6,Mth.sin(ageInTicks/15)/15);
		animateTentacleX(tail7,Mth.sin(ageInTicks/15)/15);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		gore.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}