package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.AnimationTrackers.MistMakerSawAnimationTracker;
import com.Harbinger.Spore.Client.AnimationTrackers.MistMakerShootAnimationTracker;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.EntityModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class MistmakerModelArm<T extends LivingEntity> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "mistmaker"), "main");
	public final ModelPart gun;
	private final ModelPart tongue;
	private final ModelPart end;
	private final ModelPart head;
	private final ModelPart upperjaw;
	private final ModelPart u_j_hinge;
	private final ModelPart lowerjaw;
	private final ModelPart saw;
	private final ModelPart saw2;
	private final ModelPart Barrels;
	private final ModelPart Barrel_L;
	private final ModelPart B_L_end;
	private final ModelPart Barrel_R;
	private final ModelPart B_R_end;
	private final ModelPart Lungs;
	private final ModelPart Lungs_L;
	private final ModelPart Lungs_R;
	private final ModelPart Ribcage;
	private final ModelPart body;
	private final ModelPart trigger;
	private final ModelPart tumors;
	private final ModelPart tumor1;
	private final ModelPart tumor3;
	private final ModelPart tumor2;
	private final ModelPart tumor4;
	private final ModelPart tumor5;
	private final ModelPart flower;
	private boolean switchSaw = false;
	private int sawOut = 0;

	public MistmakerModelArm() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.gun = root.getChild("gun");
		this.tongue = this.gun.getChild("tongue");
		this.end = this.tongue.getChild("end");
		this.head = this.end.getChild("head");
		this.upperjaw = this.head.getChild("upperjaw");
		this.u_j_hinge = this.upperjaw.getChild("u_j_hinge");
		this.lowerjaw = this.head.getChild("lowerjaw");
		this.saw = this.head.getChild("saw");
		this.saw2 = this.head.getChild("saw2");
		this.Barrels = this.gun.getChild("Barrels");
		this.Barrel_L = this.Barrels.getChild("Barrel_L");
		this.B_L_end = this.Barrel_L.getChild("B_L_end");
		this.Barrel_R = this.Barrels.getChild("Barrel_R");
		this.B_R_end = this.Barrel_R.getChild("B_R_end");
		this.Lungs = this.gun.getChild("Lungs");
		this.Lungs_L = this.Lungs.getChild("Lungs_L");
		this.Lungs_R = this.Lungs.getChild("Lungs_R");
		this.Ribcage = this.gun.getChild("Ribcage");
		this.body = this.gun.getChild("body");
		this.trigger = this.body.getChild("trigger");
		this.tumors = this.gun.getChild("tumors");
		this.tumor1 = this.tumors.getChild("tumor1");
		this.tumor3 = this.tumors.getChild("tumor3");
		this.tumor2 = this.tumors.getChild("tumor2");
		this.tumor4 = this.tumors.getChild("tumor4");
		this.tumor5 = this.tumors.getChild("tumor5");
		this.flower = this.tumors.getChild("flower");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition gun = partdefinition.addOrReplaceChild("gun", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.5F, -0.5F, -18.75F, 1.5708F, 0.0F, 0.0F));

		PartDefinition tongue = gun.addOrReplaceChild("tongue", CubeListBuilder.create().texOffs(48, 87).addBox(-1.49F, -1.49F, -16.01F, 3.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 8.0F, 0.0F, 0.0F, -3.1416F));

		PartDefinition end = tongue.addOrReplaceChild("end", CubeListBuilder.create().texOffs(94, 108).addBox(-1.5F, -1.5F, -19.0F, 3.0F, 3.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -19.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition head = end.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.375F, -13.5F, 3.1416F, 0.0F, 0.0F));

		PartDefinition upperjaw = head.addOrReplaceChild("upperjaw", CubeListBuilder.create().texOffs(62, 52).addBox(-1.99F, -1.4F, -5.0F, 4.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.625F, 2.5F));

		PartDefinition u_j_hinge = upperjaw.addOrReplaceChild("u_j_hinge", CubeListBuilder.create().texOffs(48, 126).addBox(-2.0F, -1.5F, -7.5F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(116, 58).addBox(-1.5F, 0.0F, -7.0F, 3.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -3.5F));

		PartDefinition lowerjaw = head.addOrReplaceChild("lowerjaw", CubeListBuilder.create().texOffs(0, 126).addBox(-2.0F, -1.25F, -7.0F, 4.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(116, 78).addBox(-1.5F, -2.25F, -6.5F, 3.0F, 1.0F, 8.0F, new CubeDeformation(0.1F)), PartPose.offset(0.0F, 1.625F, -1.5F));

		PartDefinition saw = head.addOrReplaceChild("saw", CubeListBuilder.create().texOffs(0, 231).addBox(0.0F, -4.0F, -9.0F, 0.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -2.0F));

		PartDefinition saw2 = head.addOrReplaceChild("saw2", CubeListBuilder.create().texOffs(0, 225).addBox(-0.01F, -4.0F, -9.0F, 0.0F, 6.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, -2.0F));

		PartDefinition Barrels = gun.addOrReplaceChild("Barrels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Barrel_L = Barrels.addOrReplaceChild("Barrel_L", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = Barrel_L.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(114, 0).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition B_L_end = Barrel_L.addOrReplaceChild("B_L_end", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = B_L_end.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(62, 26).addBox(-2.0F, -1.0F, -14.0F, 3.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -2.75F, -12.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Barrel_R = Barrels.addOrReplaceChild("Barrel_R", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = Barrel_R.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 111).addBox(-2.0F, -2.0F, -10.0F, 4.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition B_R_end = Barrel_R.addOrReplaceChild("B_R_end", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r4 = B_R_end.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(62, 26).addBox(-2.0F, -1.0F, -14.0F, 3.0F, 3.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.75F, -12.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition Lungs = gun.addOrReplaceChild("Lungs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Lungs_L = Lungs.addOrReplaceChild("Lungs_L", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r5 = Lungs_L.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 60).addBox(-1.0F, -8.0F, -6.0F, 10.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition Lungs_R = Lungs.addOrReplaceChild("Lungs_R", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r6 = Lungs_R.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 60).addBox(-9.0F, -8.0F, -6.0F, 10.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 5.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Ribcage = gun.addOrReplaceChild("Ribcage", CubeListBuilder.create().texOffs(0, 87).addBox(-2.0F, -9.0F, -1.5F, 4.0F, 4.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Ribcage.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(134, 20).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(134, 28).addBox(-0.5F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.75F, 16.5F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r8 = Ribcage.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(134, 28).addBox(0.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 20).addBox(-0.5F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.75F, 12.5F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r9 = Ribcage.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(134, 28).addBox(0.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 20).addBox(-0.5F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.75F, 8.5F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r10 = Ribcage.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(134, 28).addBox(0.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 20).addBox(-0.5F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.75F, 4.5F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r11 = Ribcage.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(134, 28).addBox(0.0F, -4.0F, -2.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(134, 20).addBox(-0.5F, -2.0F, -2.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -7.75F, 0.5F, -1.0908F, 0.0F, 0.0F));

		PartDefinition cube_r12 = Ribcage.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 30).addBox(-10.0F, -9.0F, -6.0F, 11.0F, 10.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.5F, 4.5F, 0.0F, 0.0F, -0.4363F));

		PartDefinition cube_r13 = Ribcage.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -9.0F, -6.0F, 11.0F, 10.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, 4.5F, 0.0F, 0.0F, 0.4363F));

		PartDefinition body = gun.addOrReplaceChild("body", CubeListBuilder.create().texOffs(48, 110).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(84, 110).addBox(-1.0F, -8.0F, 17.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(36, 128).addBox(-1.0F, -8.0F, -2.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(96, 89).addBox(-1.0F, -6.0F, 0.0F, 2.0F, 2.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(30, 111).addBox(-2.0F, -9.0F, -2.0F, 5.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 5.25F, 22.25F, 1.0036F, 0.0F, 0.0F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(114, 15).addBox(-2.0F, -9.0F, -3.0F, 4.0F, 14.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 22.0F, 1.0036F, 0.0F, 0.0F));

		PartDefinition trigger = body.addOrReplaceChild("trigger", CubeListBuilder.create().texOffs(122, 127).addBox(0.0F, 0.0F, -5.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 12.0F));

		PartDefinition tumors = gun.addOrReplaceChild("tumors", CubeListBuilder.create().texOffs(234, 238).addBox(-5.0F, 2.0F, 0.0F, 0.0F, 7.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r16 = tumors.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(-7, 190).addBox(-1.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.0F, 0.0F, 0.3047F, 0.4032F, 0.1839F));

		PartDefinition cube_r17 = tumors.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(-7, 190).addBox(-1.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.0F, 0.0F, 0.1859F, 0.4672F, -0.0963F));

		PartDefinition cube_r18 = tumors.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(-7, 190).addBox(-1.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -5.0F, 0.0F, 0.0011F, 0.5002F, -0.4894F));

		PartDefinition tumor1 = tumors.addOrReplaceChild("tumor1", CubeListBuilder.create(), PartPose.offset(7.0F, -5.0F, 16.0F));

		PartDefinition cube_r19 = tumor1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(116, 68).addBox(-2.0F, -2.0F, -1.0F, 5.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.3927F, 0.0F, 0.3491F));

		PartDefinition tumor3 = tumors.addOrReplaceChild("tumor3", CubeListBuilder.create(), PartPose.offset(3.0F, -6.0F, 5.0F));

		PartDefinition cube_r20 = tumor3.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(22, 128).addBox(1.0F, -2.0F, -1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.5809F, 0.2993F, 0.5343F));

		PartDefinition cube_r21 = tumor3.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(96, 52).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4013F, 0.6102F, -0.3697F));

		PartDefinition tumor2 = tumors.addOrReplaceChild("tumor2", CubeListBuilder.create(), PartPose.offset(9.0F, 2.5F, 9.0F));

		PartDefinition cube_r22 = tumor2.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(106, 127).addBox(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2643F, -1.3235F, -0.1017F, 0.3208F, 0.2304F, -0.7908F));

		PartDefinition cube_r23 = tumor2.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(114, 35).addBox(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -4.0F, 0.1308F, -0.0057F, -0.1749F));

		PartDefinition tumor4 = tumors.addOrReplaceChild("tumor4", CubeListBuilder.create(), PartPose.offset(-10.0F, -4.0F, 2.0F));

		PartDefinition cube_r24 = tumor4.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(114, 47).addBox(-3.0F, -2.0F, -2.0F, 5.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, -0.5361F, -0.0801F, 0.0663F));

		PartDefinition cube_r25 = tumor4.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(80, 52).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -2.0F, -0.0698F, -0.504F, -0.3001F));

		PartDefinition tumor5 = tumors.addOrReplaceChild("tumor5", CubeListBuilder.create(), PartPose.offset(-10.0F, -2.25F, 11.0F));

		PartDefinition cube_r26 = tumor5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(132, 108).addBox(-2.0F, -4.0F, 1.0F, 5.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, -4.0F, -0.3491F, -0.1745F, -0.4363F));

		PartDefinition cube_r27 = tumor5.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(88, 127).addBox(-2.0F, -5.0F, -1.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 3.0F, 0.0F, -0.0691F, -0.2742F, -0.8049F));

		PartDefinition cube_r28 = tumor5.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(70, 126).addBox(-2.0F, -5.0F, -1.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, 0.0F, 0.1745F, -0.4363F));

		PartDefinition flower = tumors.addOrReplaceChild("flower", CubeListBuilder.create().texOffs(240, 71).addBox(-2.0F, -1.9898F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.75F, -5.5102F, 11.0F, -0.2166F, 0.1512F, -0.2806F));

		PartDefinition cube_r29 = flower.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(248, 37).addBox(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9898F, 0.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r30 = flower.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(248, 37).addBox(0.0F, -4.0F, -2.0F, 0.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.9898F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r31 = flower.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(236, 0).addBox(-6.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0102F, 2.0F, 1.5708F, 1.1345F, 1.5708F));

		PartDefinition cube_r32 = flower.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(236, 8).addBox(0.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0102F, -2.0F, -1.5708F, 1.1345F, -1.5708F));

		PartDefinition cube_r33 = flower.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(236, 0).addBox(-6.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0102F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition cube_r34 = flower.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(236, 8).addBox(0.0F, 0.0F, -4.0F, 6.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0102F, 0.0F, 0.0F, 0.0F, -0.4363F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}
	public void animateLung(ModelPart part,float val){
		part.xScale = 1 + val;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		gun.getAllParts().forEach(ModelPart::resetPose);
		float lungVal = Mth.sin(ageInTicks/7)/16;
		float tum1 = Mth.sin(ageInTicks/6)/7;
		float tum2 = Mth.sin(ageInTicks/7)/6;
		float tum3 = Mth.sin(ageInTicks/7)/8;
		float tum4 = Mth.sin(ageInTicks/8)/7;
		float tum5 = Mth.sin(ageInTicks/7)/7;
		animateLung(Lungs_L,lungVal);
		animateLung(Lungs_R,lungVal);
		animateTumor(tumor1,tum1);
		animateTumor(tumor2,tum2);
		animateTumor(tumor3,tum3);
		animateTumor(tumor4,tum4);
		animateTumor(tumor5,tum5);
		if (entity.tickCount % 10 == 0){
			switchSaw = !switchSaw;
		}

		if (entity instanceof Player player){
			float anim = MistMakerShootAnimationTracker.getProgress(player, 0);
			this.B_L_end.z = B_L_end.z + anim;
			this.B_R_end.z = B_R_end.z + anim;
			this.Barrel_R.z = Barrel_R.z + anim;
			this.Barrel_L.z = Barrel_L.z + anim;
			this.gun.z = gun.z + anim/2;
			float bite = MistMakerSawAnimationTracker.getProgress(player, 0);
			if (bite > 0){
				if (sawOut < 40){
					sawOut++;
				}
			}else {
				if (sawOut > 0){
					sawOut--;
				}
			}
		}
		float v = sawOut * 0.35f;
		tongue.z = tongue.z - v;
		upperjaw.xRot = upperjaw.xRot - sawOut * 0.025f;
		lowerjaw.xRot = lowerjaw.xRot + sawOut * 0.025f;
		saw.z = saw.z - v;
		saw2.z = saw2.z - v;

		saw.visible = switchSaw;
		saw2.visible = !switchSaw;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		gun.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}