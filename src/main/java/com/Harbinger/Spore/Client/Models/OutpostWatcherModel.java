package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Special.BlockEntityModel;
import com.Harbinger.Spore.SBlockEntities.OutpostWatcherBlockEntity;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

import java.util.ArrayList;
import java.util.List;

public class OutpostWatcherModel<T extends OutpostWatcherBlockEntity> extends BlockEntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "outpost_watcher"), "main");
	private final List<ModelPart> segements = new ArrayList<>();
	private final ModelPart OutpostCore;
	private final ModelPart Biomass;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Brain4;
	private final ModelPart Neck1;
	private final ModelPart Neck2;
	private final ModelPart Neck3;
	private final ModelPart Neck4;
	private final ModelPart Neck5;
	private final ModelPart Pupil;
	private final ModelPart Rib1;
	private final ModelPart Rib2;
	private final ModelPart Rib3;
	private final ModelPart Rib4;

	public OutpostWatcherModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.OutpostCore = root.getChild("OutpostCore");
		this.Biomass = OutpostCore.getChild("Base").getChild("Biomass");
		this.Brain1 = OutpostCore.getChild("Base").getChild("Brains").getChild("Brain1");
		this.Brain2 = OutpostCore.getChild("Base").getChild("Brains").getChild("Brain2");
		this.Brain3 = OutpostCore.getChild("Base").getChild("Brains").getChild("Brain3");
		this.Brain4 = OutpostCore.getChild("Base").getChild("Brains").getChild("Brain4");
		this.Neck1 = OutpostCore.getChild("Stalk").getChild("Spine");
		this.Neck2 = Neck1.getChild("SpineSeg2");
		this.Neck3 = Neck2.getChild("SpineSeg3");
		this.Neck4 = Neck3.getChild("SpineSeg4");
		this.Neck5 = Neck4.getChild("SpineSeg5");
		this.Pupil = Neck5.getChild("Eye").getChild("Pupil");
		segements.add(Neck1);
		segements.add(Neck2);
		segements.add(Neck5);
		this.Rib1 = OutpostCore.getChild("Base").getChild("Ribs").getChild("Rib1");
		this.Rib2 = OutpostCore.getChild("Base").getChild("Ribs").getChild("Rib2");
		this.Rib3 = OutpostCore.getChild("Base").getChild("Ribs").getChild("Rib3");
		this.Rib4 = OutpostCore.getChild("Base").getChild("Ribs").getChild("Rib4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition OutpostCore = partdefinition.addOrReplaceChild("OutpostCore", CubeListBuilder.create(), PartPose.offset(-1.0F, 22.0F, 0.0F));

		PartDefinition Base = OutpostCore.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Biomass = Base.addOrReplaceChild("Biomass", CubeListBuilder.create(), PartPose.offset(-0.4597F, -1.0134F, -0.332F));

		PartDefinition Biomass4_r1 = Biomass.addOrReplaceChild("Biomass4_r1", CubeListBuilder.create().texOffs(4, 4).addBox(-3.5F, -1.5F, -1.5F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.323F, -2.1995F, 1.2635F, -0.1987F, 0.4755F, -0.1473F));

		PartDefinition Biomass3_r1 = Biomass.addOrReplaceChild("Biomass3_r1", CubeListBuilder.create().texOffs(2, 2).addBox(-4.5F, -2.5F, -2.5F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5599F, -1.0913F, -2.9138F, 0.3699F, -0.7124F, -0.2154F));

		PartDefinition Biomass2_r1 = Biomass.addOrReplaceChild("Biomass2_r1", CubeListBuilder.create().texOffs(3, 3).addBox(-4.0F, -2.0F, -2.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7154F, -0.1518F, -3.6794F, 0.0F, -0.5236F, -0.3491F));

		PartDefinition Biomass1_r1 = Biomass.addOrReplaceChild("Biomass1_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -3.5F, -3.5F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.814F, -1.2803F, 2.359F, -0.1801F, 0.3913F, -0.0164F));

		PartDefinition Brains = Base.addOrReplaceChild("Brains", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Brain1 = Brains.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(0, 34).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 60).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.1973F, -1.8588F, -3.564F, 0.3054F, 0.7854F, 0.0F));

		PartDefinition Brain2 = Brains.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(0, 34).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 60).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.6996F, -1.0907F, -2.6466F, 0.549F, -0.3252F, 0.4096F));

		PartDefinition Brain3 = Brains.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(0, 34).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 60).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(3.8157F, -2.9002F, 3.9551F, -0.549F, 0.3252F, 0.4096F));

		PartDefinition Brain4 = Brains.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(0, 34).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 60).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 60).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.7248F, -3.202F, 1.1037F, -0.9961F, -0.6061F, 0.0913F));

		PartDefinition Ribs = Base.addOrReplaceChild("Ribs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib1 = Ribs.addOrReplaceChild("Rib1", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2113F, -3.6046F, 7.1676F, -0.5633F, -0.0702F, -0.1106F));

		PartDefinition Rib1Seg = Rib1.addOrReplaceChild("Rib1Seg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Rib2 = Ribs.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.1144F, -2.2051F, -1.07F, -0.48F, -1.1345F, 0.0F));

		PartDefinition Rib2Seg = Rib2.addOrReplaceChild("Rib2Seg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Rib3 = Ribs.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2113F, -4.6886F, -3.4758F, 0.5899F, -0.3135F, 0.0025F));

		PartDefinition Rib3Seg = Rib3.addOrReplaceChild("Rib3Seg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Rib4 = Ribs.addOrReplaceChild("Rib4", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.5F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0942F, -1.4646F, -0.2558F, -0.6545F, 1.3963F, 0.0F));

		PartDefinition Rib4Seg = Rib4.addOrReplaceChild("Rib4Seg", CubeListBuilder.create().texOffs(0, 73).addBox(-1.0013F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Stalk = OutpostCore.addOrReplaceChild("Stalk", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Spine = Stalk.addOrReplaceChild("Spine", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-2.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).addBox(0.0F, -4.0F, 1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, -5.0F, 0.0F));

		PartDefinition SpineSeg2 = Spine.addOrReplaceChild("SpineSeg2", CubeListBuilder.create().texOffs(27, 0).addBox(-1.49F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-2.49F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.51F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).addBox(0.01F, -4.0F, 1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition SpineSeg3 = SpineSeg2.addOrReplaceChild("SpineSeg3", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-2.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).addBox(0.0F, -4.0F, 1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition SpineSeg4 = SpineSeg3.addOrReplaceChild("SpineSeg4", CubeListBuilder.create().texOffs(27, 0).addBox(-1.49F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.51F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-2.49F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).mirror().addBox(0.01F, -4.0F, 1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.6981F, 0.0F, 0.0F));

		PartDefinition SpineSeg5 = SpineSeg4.addOrReplaceChild("SpineSeg5", CubeListBuilder.create().texOffs(27, 0).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(1.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 18).addBox(-2.5F, -4.0F, -1.5F, 1.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 16).addBox(0.0F, -4.0F, 1.5F, 0.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Eye = SpineSeg5.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(0, 18).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0975F, 0.8978F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Pupil = Eye.addOrReplaceChild("Pupil", CubeListBuilder.create().texOffs(0, 47).addBox(-2.5F, -2.5F, -0.5F, 5.0F, 5.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offset(0.0F, 0.0F, -8.25F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	private void animateBiomass(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/6)/6;
		part.yScale = 1 + Mth.cos(value/6)/6;
		part.zScale = 1 + Mth.cos(value/6)/6;
	}
	private void animateBrain(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/8)/8;
		part.yScale = 1 - Mth.cos(value/8)/8;
		part.zScale = 1 + Mth.cos(value/8)/8;
	}
	private void RotateStalk(T thisEntity,Entity entity){
		if (entity != null){
			double d1 = entity.getX() - thisEntity.getBlockPos().getX();
			double d2 = entity.getZ() - thisEntity.getBlockPos().getZ();
			float value = -((float)Mth.atan2(-d1, -d2)) * (180F / (float)Math.PI);
			this.segements.forEach(part -> { part.yRot = (value / (180F / (float) Math.PI))/segements.size();});
		}
	}
	private void animatePupil(T block,Entity entity,ModelPart part){
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = new Vec3(block.getBlockPos().getX()-0.5,block.getBlockPos().getY()+0.75,block.getBlockPos().getZ()-0.5);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				part.y = -0.5F;
			} else {
				part.y = 0.5F;
			}
			Vec3 vec32 = vec31;
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			part.x = Mth.sqrt((float)Math.abs(d1)) * 0.1F * (float)Math.signum(d1);
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		OutpostCore.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public void setupAnim(T entity, float ageInTicks) {
		animateBiomass(Biomass,ageInTicks);
		animateBrain(Brain1,ageInTicks);
		animateBrain(Brain2,-ageInTicks);
		animateBrain(Brain3,ageInTicks);
		animateBrain(Brain4,-ageInTicks);
		RotateStalk(entity,Minecraft.getInstance().cameraEntity);
		animatePupil(entity,Minecraft.getInstance().cameraEntity,Pupil);
		this.Rib1.xRot = -0.6f + Mth.sin(ageInTicks/7)/5;
		this.Rib2.xRot = -0.6f + Mth.sin(ageInTicks/7)/5;
		this.Rib3.xRot = 0.6f + Mth.sin(ageInTicks/7)/5;
		this.Rib4.xRot = -0.6f + Mth.sin(ageInTicks/7)/5;
	}
}