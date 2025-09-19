package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import net.minecraft.world.entity.LivingEntity;
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
public class lacedThornsModel<T extends LivingEntity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "lacedthornsmodel"), "main");
	public final ModelPart head;
	private final ModelPart shortThorn3;
	private final ModelPart shortThorn2;
	private final ModelPart shortThorn4;
	private final ModelPart shortThorn5;
	private final ModelPart thorn2;
	private final ModelPart thorn3;
	private final ModelPart thorn4;
	private final ModelPart thorn5;
	private final ModelPart thorn6;
	private final ModelPart thorn7;
	private final ModelPart thorn8;
	private final ModelPart thorn9;
	public final ModelPart rightDarm;
	private final ModelPart shortThorn6;
	private final ModelPart shortThorn7;
	private final ModelPart shortThorn8;
	private final ModelPart shortThorn9;
	private final ModelPart thorn10;
	private final ModelPart thorn11;
	private final ModelPart thorn12;
	private final ModelPart thorn13;
	public final ModelPart leftDarm;
	private final ModelPart shortThorn10;
	private final ModelPart shortThorn11;
	private final ModelPart shortThorn12;
	private final ModelPart shortThorn13;
	private final ModelPart thorn14;
	private final ModelPart thorn15;
	private final ModelPart thorn16;
	private final ModelPart thorn17;
	public final ModelPart rightDleg;
	private final ModelPart thorn18;
	private final ModelPart thorn19;
	public final ModelPart leftDleg;
	private final ModelPart thorn20;
	private final ModelPart thorn21;
	public final ModelPart rightDboot;
	private final ModelPart thorn22;
	private final ModelPart thorn23;
	private final ModelPart thorn24;
	private final ModelPart thorn25;
	public final ModelPart leftDboot;
	private final ModelPart thorn26;
	private final ModelPart thorn27;
	private final ModelPart thorn28;
	private final ModelPart thorn29;

	public lacedThornsModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.head = root.getChild("head");
		this.shortThorn3 = this.head.getChild("shortThorn3");
		this.shortThorn2 = this.head.getChild("shortThorn2");
		this.shortThorn4 = this.head.getChild("shortThorn4");
		this.shortThorn5 = this.head.getChild("shortThorn5");
		this.thorn2 = this.head.getChild("thorn2");
		this.thorn3 = this.head.getChild("thorn3");
		this.thorn4 = this.head.getChild("thorn4");
		this.thorn5 = this.head.getChild("thorn5");
		this.thorn6 = this.head.getChild("thorn6");
		this.thorn7 = this.head.getChild("thorn7");
		this.thorn8 = this.head.getChild("thorn8");
		this.thorn9 = this.head.getChild("thorn9");
		this.rightDarm = root.getChild("rightDarm");
		this.shortThorn6 = this.rightDarm.getChild("shortThorn6");
		this.shortThorn7 = this.rightDarm.getChild("shortThorn7");
		this.shortThorn8 = this.rightDarm.getChild("shortThorn8");
		this.shortThorn9 = this.rightDarm.getChild("shortThorn9");
		this.thorn10 = this.rightDarm.getChild("thorn10");
		this.thorn11 = this.rightDarm.getChild("thorn11");
		this.thorn12 = this.rightDarm.getChild("thorn12");
		this.thorn13 = this.rightDarm.getChild("thorn13");
		this.leftDarm = root.getChild("leftDarm");
		this.shortThorn10 = this.leftDarm.getChild("shortThorn10");
		this.shortThorn11 = this.leftDarm.getChild("shortThorn11");
		this.shortThorn12 = this.leftDarm.getChild("shortThorn12");
		this.shortThorn13 = this.leftDarm.getChild("shortThorn13");
		this.thorn14 = this.leftDarm.getChild("thorn14");
		this.thorn15 = this.leftDarm.getChild("thorn15");
		this.thorn16 = this.leftDarm.getChild("thorn16");
		this.thorn17 = this.leftDarm.getChild("thorn17");
		this.rightDleg = root.getChild("rightDleg");
		this.thorn18 = this.rightDleg.getChild("thorn18");
		this.thorn19 = this.rightDleg.getChild("thorn19");
		this.leftDleg = root.getChild("leftDleg");
		this.thorn20 = this.leftDleg.getChild("thorn20");
		this.thorn21 = this.leftDleg.getChild("thorn21");
		this.rightDboot = root.getChild("rightDboot");
		this.thorn22 = this.rightDboot.getChild("thorn22");
		this.thorn23 = this.rightDboot.getChild("thorn23");
		this.thorn24 = this.rightDboot.getChild("thorn24");
		this.thorn25 = this.rightDboot.getChild("thorn25");
		this.leftDboot = root.getChild("leftDboot");
		this.thorn26 = this.leftDboot.getChild("thorn26");
		this.thorn27 = this.leftDboot.getChild("thorn27");
		this.thorn28 = this.leftDboot.getChild("thorn28");
		this.thorn29 = this.leftDboot.getChild("thorn29");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition shortThorn3 = head.addOrReplaceChild("shortThorn3", CubeListBuilder.create().texOffs(4, 2).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5F, -8.5F, -5.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r1 = shortThorn3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 0).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn2 = head.addOrReplaceChild("shortThorn2", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -8.5F, -5.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r2 = shortThorn2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition shortThorn4 = head.addOrReplaceChild("shortThorn4", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -7.5F, -4.0F, 0.7854F, -1.0472F, 0.0F));

		PartDefinition cube_r3 = shortThorn4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn5 = head.addOrReplaceChild("shortThorn5", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-5.0F, -7.5F, -4.0F, 0.7854F, 1.0472F, 0.0F));

		PartDefinition cube_r4 = shortThorn5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn2 = head.addOrReplaceChild("thorn2", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -8.5F, 1.0F, -0.4363F, 0.0F, 0.4363F));

		PartDefinition cube_r5 = thorn2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn3 = head.addOrReplaceChild("thorn3", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -8.5F, -4.0F, -0.5236F, 0.0F, 0.3054F));

		PartDefinition cube_r6 = thorn3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn4 = head.addOrReplaceChild("thorn4", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, -7.0F, -1.5F, -0.4363F, 0.0F, 0.8727F));

		PartDefinition cube_r7 = thorn4.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn5 = head.addOrReplaceChild("thorn5", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -7.5F, 3.5F, -0.4363F, 0.0F, 0.6109F));

		PartDefinition cube_r8 = thorn5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn6 = head.addOrReplaceChild("thorn6", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -8.5F, -4.0F, -0.5236F, 0.0F, -0.3054F));

		PartDefinition cube_r9 = thorn6.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(2, 6).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn7 = head.addOrReplaceChild("thorn7", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -7.0F, -1.5F, -0.4363F, 0.0F, -0.8727F));

		PartDefinition cube_r10 = thorn7.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn8 = head.addOrReplaceChild("thorn8", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.75F, -7.5F, 3.5F, -0.4363F, 0.0F, -0.6109F));

		PartDefinition cube_r11 = thorn8.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn9 = head.addOrReplaceChild("thorn9", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, -8.5F, 1.0F, -0.4363F, 0.0F, -0.4363F));

		PartDefinition cube_r12 = thorn9.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(2, 6).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition rightDarm = partdefinition.addOrReplaceChild("rightDarm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));

		PartDefinition shortThorn6 = rightDarm.addOrReplaceChild("shortThorn6", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 9.75F, -2.5F, 0.6887F, 0.1589F, -1.8157F));

		PartDefinition cube_r13 = shortThorn6.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(4, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn7 = rightDarm.addOrReplaceChild("shortThorn7", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 8.75F, -2.5F, 0.6621F, -0.2594F, -1.3079F));

		PartDefinition cube_r14 = shortThorn7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(4, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn8 = rightDarm.addOrReplaceChild("shortThorn8", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 9.75F, 2.5F, -0.6887F, -0.1589F, -1.8157F));

		PartDefinition cube_r15 = shortThorn8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(4, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition shortThorn9 = rightDarm.addOrReplaceChild("shortThorn9", CubeListBuilder.create().texOffs(4, 0).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 8.75F, 2.5F, -0.6621F, 0.2594F, -1.3079F));

		PartDefinition cube_r16 = shortThorn9.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(6, 7).addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn10 = rightDarm.addOrReplaceChild("thorn10", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 1.5F, -2.5F, 0.6429F, 0.0779F, -0.2956F));

		PartDefinition cube_r17 = thorn10.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn11 = rightDarm.addOrReplaceChild("thorn11", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.5F, -2.5F, 0.6477F, 0.0721F, -0.2006F));

		PartDefinition cube_r18 = thorn11.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn12 = rightDarm.addOrReplaceChild("thorn12", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, 1.5F, 2.5F, -0.6429F, -0.0779F, -0.2956F));

		PartDefinition cube_r19 = thorn12.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn13 = rightDarm.addOrReplaceChild("thorn13", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -1.5F, 2.5F, -0.6477F, -0.0721F, -0.2006F));

		PartDefinition cube_r20 = thorn13.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition leftDarm = partdefinition.addOrReplaceChild("leftDarm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));

		PartDefinition shortThorn10 = leftDarm.addOrReplaceChild("shortThorn10", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 9.75F, -2.5F, 0.6887F, -0.1589F, 1.8157F));

		PartDefinition cube_r21 = shortThorn10.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(6, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn11 = leftDarm.addOrReplaceChild("shortThorn11", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 8.75F, -2.5F, 0.6621F, 0.2594F, 1.3079F));

		PartDefinition cube_r22 = shortThorn11.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(6, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn12 = leftDarm.addOrReplaceChild("shortThorn12", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 9.75F, 2.5F, -0.6887F, 0.1589F, 1.8157F));

		PartDefinition cube_r23 = shortThorn12.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(4, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition shortThorn13 = leftDarm.addOrReplaceChild("shortThorn13", CubeListBuilder.create().texOffs(4, 0).mirror().addBox(-0.5F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 8.75F, 2.5F, -0.6621F, -0.2594F, 1.3079F));

		PartDefinition cube_r24 = shortThorn13.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(4, 7).mirror().addBox(0.0F, -1.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn14 = leftDarm.addOrReplaceChild("thorn14", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 1.5F, -2.5F, 0.6429F, -0.0779F, 0.2956F));

		PartDefinition cube_r25 = thorn14.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(2, 6).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn15 = leftDarm.addOrReplaceChild("thorn15", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -1.5F, -2.5F, 0.6477F, -0.0721F, 0.2006F));

		PartDefinition cube_r26 = thorn15.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(2, 6).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn16 = leftDarm.addOrReplaceChild("thorn16", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, 1.5F, 2.5F, -0.6429F, 0.0779F, 0.2956F));

		PartDefinition cube_r27 = thorn16.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn17 = leftDarm.addOrReplaceChild("thorn17", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5F, -1.5F, 2.5F, -0.6477F, 0.0721F, 0.2006F));

		PartDefinition cube_r28 = thorn17.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(2, 6).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition rightDleg = partdefinition.addOrReplaceChild("rightDleg", CubeListBuilder.create(), PartPose.offset(-2.0F, 12.0F, 0.0F));

		PartDefinition thorn18 = rightDleg.addOrReplaceChild("thorn18", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 6.5F, -2.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r29 = thorn18.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn19 = rightDleg.addOrReplaceChild("thorn19", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 3.75F, -2.75F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r30 = thorn19.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leftDleg = partdefinition.addOrReplaceChild("leftDleg", CubeListBuilder.create(), PartPose.offset(2.0F, 12.0F, 0.0F));

		PartDefinition thorn20 = leftDleg.addOrReplaceChild("thorn20", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, -2.75F, 0.7854F, 0.0F, 0.0F));

		PartDefinition cube_r31 = thorn20.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn21 = leftDleg.addOrReplaceChild("thorn21", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.75F, -2.75F, 0.6109F, 0.0F, 0.0F));

		PartDefinition cube_r32 = thorn21.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition rightDboot = partdefinition.addOrReplaceChild("rightDboot", CubeListBuilder.create(), PartPose.offset(-2.1F, 12.0F, 0.0F));

		PartDefinition thorn22 = rightDboot.addOrReplaceChild("thorn22", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4F, 10.5F, -2.5F, 0.7854F, 0.5236F, 0.0F));

		PartDefinition cube_r33 = thorn22.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn23 = rightDboot.addOrReplaceChild("thorn23", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.4F, 7.5F, -1.5F, 0.6162F, 0.7222F, -0.2873F));

		PartDefinition cube_r34 = thorn23.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn24 = rightDboot.addOrReplaceChild("thorn24", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 10.5F, 2.5F, -0.8727F, 0.0F, -0.6109F));

		PartDefinition cube_r35 = thorn24.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn25 = rightDboot.addOrReplaceChild("thorn25", CubeListBuilder.create().texOffs(0, 3).mirror().addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.15F, 8.25F, 2.5F, -0.4363F, 0.0F, -0.7418F));

		PartDefinition cube_r36 = thorn25.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(6, 4).mirror().addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition leftDboot = partdefinition.addOrReplaceChild("leftDboot", CubeListBuilder.create(), PartPose.offset(2.1F, 12.0F, 0.0F));

		PartDefinition thorn26 = leftDboot.addOrReplaceChild("thorn26", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, 10.5F, -2.5F, 0.7854F, -0.5236F, 0.0F));

		PartDefinition cube_r37 = thorn26.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn27 = leftDboot.addOrReplaceChild("thorn27", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, 7.5F, -1.5F, 0.6162F, -0.7222F, 0.2873F));

		PartDefinition cube_r38 = thorn27.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition thorn28 = leftDboot.addOrReplaceChild("thorn28", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 10.5F, 2.5F, -0.8727F, 0.0F, 0.6109F));

		PartDefinition cube_r39 = thorn28.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(2, 6).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition thorn29 = leftDboot.addOrReplaceChild("thorn29", CubeListBuilder.create().texOffs(0, 3).addBox(-0.5F, -2.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.15F, 8.25F, 2.5F, -0.4363F, 0.0F, 0.7418F));

		PartDefinition cube_r40 = thorn29.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(6, 4).addBox(0.0F, -2.0F, -0.5F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 16, 16);
	}
	private void animateSpike(T entity,ModelPart part,float value){
		part.yScale =entity.hurtTime > 0 ? 2 : 1+value;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val1 = Mth.sin(ageInTicks/8)/8;
		float val2 = Mth.cos(ageInTicks/7)/8;
		float val3 = -Mth.sin(ageInTicks/7)/7;
		///8335
		animateSpike(entity,thorn2,val1);
		animateSpike(entity,thorn3,val2);
		animateSpike(entity,thorn4,val3);
		animateSpike(entity,thorn5,val1);
		animateSpike(entity,thorn6,val2);
		animateSpike(entity,thorn7,val3);
		animateSpike(entity,thorn8,val1);
		animateSpike(entity,thorn9,val2);
		animateSpike(entity,thorn10,val3);
		animateSpike(entity,thorn11,val1);
		animateSpike(entity,thorn12,val2);
		animateSpike(entity,thorn13,val3);
		animateSpike(entity,thorn14,val1);
		animateSpike(entity,thorn15,val2);
		animateSpike(entity,thorn16,val3);
		animateSpike(entity,thorn17,val1);
		animateSpike(entity,thorn18,val2);
		animateSpike(entity,thorn19,val3);
		animateSpike(entity,thorn20,val1);
		animateSpike(entity,thorn21,val2);
		animateSpike(entity,thorn22,val3);
		animateSpike(entity,thorn23,val1);
		animateSpike(entity,thorn24,val2);
		animateSpike(entity,thorn25,val3);
		animateSpike(entity,thorn26,val1);
		animateSpike(entity,thorn27,val2);
		animateSpike(entity,thorn28,val3);
		animateSpike(entity,thorn29,val1);
		animateSpike(entity,shortThorn2,val3);
		animateSpike(entity,shortThorn3,val1);
		animateSpike(entity,shortThorn4,val2);
		animateSpike(entity,shortThorn5,val3);
		animateSpike(entity,shortThorn6,val1);
		animateSpike(entity,shortThorn7,val2);
		animateSpike(entity,shortThorn8,val3);
		animateSpike(entity,shortThorn9,val1);
		animateSpike(entity,shortThorn10,val2);
		animateSpike(entity,shortThorn11,val3);
		animateSpike(entity,shortThorn12,val1);
		animateSpike(entity,shortThorn13,val2);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightDarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftDarm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightDleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftDleg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightDboot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leftDboot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}