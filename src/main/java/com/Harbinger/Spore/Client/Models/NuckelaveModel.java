package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.NuckelaveAnimation;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Nuclealave;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;

import java.util.ArrayList;
import java.util.List;

public class NuckelaveModel<T extends Nuclealave> extends HierarchicalModel<T> implements TentacledModel, ArmedModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "nuckelavemodel"), "main");
	public final boolean showArmorBits;
	public final ModelPart Nuckelavee;
	private final ModelPart Front;
	private final ModelPart FrontBodyDetails;
	private final ModelPart FrontBodyTumor;
    private final ModelPart Human;
	private final ModelPart TorsoTop;
	private final ModelPart Head;
	private final ModelPart Jaw;
    public final ModelPart HeadWear;
	private final ModelPart Arms;
	private final ModelPart LeftArm;
	public final ModelPart LeftArmWear;
    private final ModelPart RightArm;
	public final ModelPart RightArmWear;
    private final ModelPart FrontLegs;
	private final ModelPart FrontLeft;
	private final ModelPart FrontLeft2;
    private final ModelPart FootTumor;
	public final ModelPart FrontRightLegWear;
	private final ModelPart FrontRight;
	private final ModelPart FRLegTumor;
    private final ModelPart FrontRight2;
	public final ModelPart FrontRightFootWear;
	private final ModelPart BodyBack;
	private final ModelPart BackBodyDetails;
	private final ModelPart BackBodyTumor;
    private final ModelPart BackLegs;
	private final ModelPart BackLeft;
    private final ModelPart BackLeft2;
	public final ModelPart BackLeftFootWear;
	private final ModelPart BackRight;
    private final ModelPart BRLegTumor;
	public final ModelPart BackRightLegWear;

	public NuckelaveModel(ModelPart root,boolean value) {
		this.showArmorBits = value;
		this.Nuckelavee = root.getChild("Nuckelavee");
		this.Front = this.Nuckelavee.getChild("Front");
		this.FrontBodyDetails = this.Front.getChild("FrontBodyDetails");
		this.FrontBodyTumor = this.FrontBodyDetails.getChild("FrontBodyTumor");
		this.Human = this.Front.getChild("Human");
		this.TorsoTop = this.Human.getChild("TorsoTop");
		this.Head = this.TorsoTop.getChild("Head");
		this.Jaw = this.Head.getChild("Jaw");
		this.HeadWear = this.Head.getChild("HeadWear");
		this.Arms = this.TorsoTop.getChild("Arms");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftArmWear = this.LeftArm.getChild("LeftArmWear");
		this.RightArm = this.Arms.getChild("RightArm");
		this.RightArmWear = this.RightArm.getChild("RightArmWear");
		this.FrontLegs = this.Front.getChild("FrontLegs");
		this.FrontLeft = this.FrontLegs.getChild("FrontLeft");
		this.FrontLeft2 = this.FrontLeft.getChild("FrontLeft2");
		this.FootTumor = this.FrontLeft2.getChild("FootTumor");
		this.FrontRightLegWear = this.FrontLeft.getChild("FrontRightLegWear");
		this.FrontRight = this.FrontLegs.getChild("FrontRight");
		this.FRLegTumor = this.FrontRight.getChild("FRLegTumor");
		this.FrontRight2 = this.FrontRight.getChild("FrontRight2");
		this.FrontRightFootWear = this.FrontRight2.getChild("FrontRightFootWear");
		this.BodyBack = this.Nuckelavee.getChild("BodyBack");
		this.BackBodyDetails = this.BodyBack.getChild("BackBodyDetails");
		this.BackBodyTumor = this.BackBodyDetails.getChild("BackBodyTumor");
		this.BackLegs = this.BodyBack.getChild("BackLegs");
		this.BackLeft = this.BackLegs.getChild("BackLeft");
		this.BackLeft2 = this.BackLeft.getChild("BackLeft2");
		this.BackLeftFootWear = this.BackLeft2.getChild("BackLeftFootWear");
		this.BackRight = this.BackLegs.getChild("BackRight");
		this.BRLegTumor = this.BackRight.getChild("BRLegTumor");
		this.BackRightLegWear = this.BackRight.getChild("BackRightLegWear");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Nuckelavee = partdefinition.addOrReplaceChild("Nuckelavee", CubeListBuilder.create(), PartPose.offset(0.0F, 0.25F, 2.0F));

		PartDefinition Front = Nuckelavee.addOrReplaceChild("Front", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BodyBase_r1 = Front.addOrReplaceChild("BodyBase_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-4.2276F, -2.5323F, -8.6148F, 9.0F, 7.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2724F, 1.0156F, -4.0719F, 0.2618F, 0.0F, 0.0F));

		PartDefinition FrontBodyDetails = Front.addOrReplaceChild("FrontBodyDetails", CubeListBuilder.create(), PartPose.offset(0.7013F, -1.1659F, -6.7915F));

		PartDefinition BodySpine_r1 = FrontBodyDetails.addOrReplaceChild("BodySpine_r1", CubeListBuilder.create().texOffs(114, 35).addBox(-0.3151F, -3.5323F, -1.4235F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9737F, 2.1815F, 2.7196F, 0.2706F, -0.2527F, -0.0692F));

		PartDefinition BodySpinePlane_r1 = FrontBodyDetails.addOrReplaceChild("BodySpinePlane_r1", CubeListBuilder.create().texOffs(0, 115).addBox(2.4188F, -5.9653F, -3.9464F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9737F, 2.1815F, 2.7196F, 0.1927F, 0.2809F, -0.2493F));

		PartDefinition BodySpine_r2 = FrontBodyDetails.addOrReplaceChild("BodySpine_r2", CubeListBuilder.create().texOffs(102, 35).addBox(0.2648F, -3.5323F, -4.4464F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9737F, 2.1815F, 2.7196F, 0.2679F, 0.2106F, 0.0573F));

		PartDefinition BodyArmor_r1 = FrontBodyDetails.addOrReplaceChild("BodyArmor_r1", CubeListBuilder.create().texOffs(0, 21).addBox(-4.2276F, -2.5323F, -8.6148F, 9.0F, 7.0F, 14.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.9737F, 2.1815F, 2.7196F, 0.2618F, 0.0F, 0.0F));

		PartDefinition BodySpinePlane_r2 = FrontBodyDetails.addOrReplaceChild("BodySpinePlane_r2", CubeListBuilder.create().texOffs(0, 115).addBox(-0.3174F, -6.0806F, -0.4235F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9737F, 2.1815F, 2.7196F, 0.196F, -0.3136F, 0.196F));

		PartDefinition FrontBodyTumor = FrontBodyDetails.addOrReplaceChild("FrontBodyTumor", CubeListBuilder.create(), PartPose.offset(2.3965F, -0.0941F, -3.2672F));

		PartDefinition Tumor_r1 = FrontBodyTumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(0, 60).addBox(0.5051F, -9.3225F, -2.655F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(-3.3703F, 2.2757F, 5.9867F, 1.0808F, 0.1925F, 0.3444F));

		PartDefinition LowerChestFungus = FrontBodyDetails.addOrReplaceChild("LowerChestFungus", CubeListBuilder.create(), PartPose.offsetAndRotation(0.358F, 3.3872F, 1.3443F, 1.5272F, 0.0F, 0.0F));

		PartDefinition Fungus_r1 = LowerChestFungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 76).addBox(-2.3818F, -3.0908F, -8.8339F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3318F, 1.3213F, 1.2645F, 0.182F, -0.5173F, 0.0221F));

		PartDefinition Fungus_r2 = LowerChestFungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 83).addBox(-4.1772F, -3.1553F, -9.3095F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3318F, 1.3213F, 1.2645F, -0.3231F, 0.4595F, -0.2605F));

		PartDefinition Fungus_r3 = LowerChestFungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 76).addBox(-8.5231F, 1.6729F, -3.5594F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3318F, 1.3213F, 1.2645F, -0.1283F, -0.6844F, 0.2943F));

		PartDefinition Fungus_r4 = LowerChestFungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 76).addBox(1.413F, 0.5786F, -5.534F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3318F, 1.3213F, 1.2645F, 0.0415F, 0.3069F, 0.0502F));

		PartDefinition Human = Front.addOrReplaceChild("Human", CubeListBuilder.create().texOffs(112, 80).addBox(-3.0F, -5.0F, -2.0F, 6.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(128, 51).addBox(-1.0F, -3.75F, 2.0F, 2.0F, 3.0F, 1.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, 0.8895F, -11.0898F, 0.3927F, 0.0F, 0.0F));

		PartDefinition TorsoTop = Human.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(52, 72).addBox(-4.0F, -6.0F, -1.75F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(104, 70).addBox(-3.5F, -6.0F, -2.25F, 7.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -4.2847F, -0.2255F, -0.3054F, 0.0F, 0.0F));

		PartDefinition SpinePlane_r1 = TorsoTop.addOrReplaceChild("SpinePlane_r1", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -1.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2255F, -3.3908F, 4.3592F, -1.4793F, -0.3042F, -0.0275F));

		PartDefinition Spine_r1 = TorsoTop.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(48, 97).addBox(-1.0F, -6.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.2309F, 2.6629F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Head = TorsoTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(40, 42).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(16, 80).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(0, 72).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, -2.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(76, 7).addBox(-4.0F, -0.5F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.5F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Fang3_r1 = Jaw.addOrReplaceChild("Fang3_r1", CubeListBuilder.create().texOffs(60, 69).addBox(-0.5F, -2.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.625F, -0.2005F, -4.2695F, 0.1745F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Jaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(128, 68).addBox(0.25F, -1.5F, -1.5F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9666F, -0.8589F, -2.9774F, 0.0573F, -0.2106F, -0.2679F));

		PartDefinition Teeth_r2 = Jaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(126, 35).addBox(0.75F, -0.75F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0334F, -1.3589F, -3.2274F, -1.5879F, 1.2947F, -1.5886F));

		PartDefinition Teeth_r3 = Jaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(104, 80).addBox(-0.25F, -1.0F, -1.75F, 0.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, -0.4048F, -2.6347F, 0.0411F, 0.3027F, 0.1372F));

		PartDefinition upperflower1 = Head.addOrReplaceChild("upperflower1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.11F, -6.3428F, -1.0024F, 0.428F, -0.1737F, 0.1974F));

		PartDefinition cube_r1 = upperflower1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(-7, 90).addBox(-2.86F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r2 = upperflower1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-7, 76).addBox(1.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = upperflower1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-7, 90).addBox(-2.86F, 0.0F, -8.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition upperflower2 = Head.addOrReplaceChild("upperflower2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.665F, -5.0956F, 0.9847F, -0.0643F, 0.4382F, -0.6103F));

		PartDefinition cube_r4 = upperflower2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-7, 83).addBox(-3.14F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r5 = upperflower2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-7, 83).addBox(-7.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = upperflower2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-7, 90).addBox(1.0F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition Horns = Head.addOrReplaceChild("Horns", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition LeftHorn = Horns.addOrReplaceChild("LeftHorn", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.0F, -8.0F, -3.0F, 0.2618F, 0.0F, 0.7418F));

		PartDefinition HornSeg_r1 = LeftHorn.addOrReplaceChild("HornSeg_r1", CubeListBuilder.create().texOffs(8, 0).addBox(-0.5F, -1.75F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.6119F, -4.5302F, 0.0F, 0.0F, 0.0F, -0.9163F));

		PartDefinition HornSeg_r2 = LeftHorn.addOrReplaceChild("HornSeg_r2", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -3.25F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition RightHorn = Horns.addOrReplaceChild("RightHorn", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-4.0149F, -7.3104F, 0.9717F, -0.0832F, -0.0262F, -1.0461F));

		PartDefinition HornSeg_r3 = RightHorn.addOrReplaceChild("HornSeg_r3", CubeListBuilder.create().texOffs(0, 21).addBox(-0.75F, -2.25F, -0.75F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -0.3054F, 0.0F, 0.5672F));

		PartDefinition HeadWear = Head.addOrReplaceChild("HeadWear", CubeListBuilder.create().texOffs(0, 0).addBox(-16.0F, -20.0F, -17.0F, 32.0F, 32.0F, 32.0F, new CubeDeformation(-11.5F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arms = TorsoTop.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(120, 55).addBox(0.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.5F, 1.0F, 0.0F));

		PartDefinition LeftArmWear = LeftArm.addOrReplaceChild("LeftArmWear", CubeListBuilder.create().texOffs(160, 64).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.7F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition LeftArmSeg2 = LeftArm.addOrReplaceChild("LeftArmSeg2", CubeListBuilder.create().texOffs(36, 107).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 4.0F, 0.0F));

		PartDefinition LeftArmFungus = LeftArmSeg2.addOrReplaceChild("LeftArmFungus", CubeListBuilder.create(), PartPose.offset(0.4407F, 0.4235F, 0.9769F));

		PartDefinition Fungus_r5 = LeftArmFungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 90).addBox(-2.5F, 3.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = LeftArmFungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 90).addBox(-3.5F, 0.0F, -8.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 3.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(36, 107).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(68, 111).addBox(-4.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offset(-3.5F, 1.0F, 0.0F));

		PartDefinition RightArmWear = RightArm.addOrReplaceChild("RightArmWear", CubeListBuilder.create().texOffs(160, 64).addBox(-9.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.7F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

		PartDefinition rightarmfungus = RightArm.addOrReplaceChild("rightarmfungus", CubeListBuilder.create(), PartPose.offset(-5.5593F, 1.4235F, 0.9769F));

		PartDefinition Fungus_r7 = rightarmfungus.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(-7, 83).addBox(-4.25F, -7.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r8 = rightarmfungus.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(-7, 76).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition RightArmSeg2 = RightArm.addOrReplaceChild("RightArmSeg2", CubeListBuilder.create().texOffs(120, 55).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 4.0F, 0.0F));

		PartDefinition FrontLegs = Front.addOrReplaceChild("FrontLegs", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, -9.0F));

		PartDefinition FrontLeft = FrontLegs.addOrReplaceChild("FrontLeft", CubeListBuilder.create().texOffs(88, 93).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9983F, 1.3912F, 0.5442F, -0.6221F, -0.2787F, -0.1438F));

		PartDefinition FrontLeft2 = FrontLeft.addOrReplaceChild("FrontLeft2", CubeListBuilder.create().texOffs(112, 89).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.4021F, -0.1846F, 0.6504F, -0.0795F, 0.1041F));

		PartDefinition LeftLegFungus2 = FrontLeft2.addOrReplaceChild("LeftLegFungus2", CubeListBuilder.create(), PartPose.offset(-0.3077F, 0.5196F, 0.1083F));

		PartDefinition Fungus_r9 = LeftLegFungus2.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(-7, 83).addBox(-3.5F, 2.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.1475F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r10 = LeftLegFungus2.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(-7, 76).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5593F, -0.2108F, -2.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition FootTumor = FrontLeft2.addOrReplaceChild("FootTumor", CubeListBuilder.create(), PartPose.offset(0.258F, 10.3999F, -0.2157F));

		PartDefinition Tumor_r2 = FootTumor.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(8, 64).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.2144F, -0.3734F, -0.866F, 1.2146F, -1.2592F, -0.8102F));

		PartDefinition Tumor_r3 = FootTumor.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(6, 65).addBox(-2.0F, -1.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1186F, -0.2582F, 0.0876F, 0.2546F, -1.2592F, -0.8102F));

		PartDefinition Tumor_r4 = FootTumor.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(5, 63).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.258F, 0.1001F, 1.2157F, -0.4919F, -0.7052F, 0.1935F));

		PartDefinition FrontRightLegWear = FrontLeft.addOrReplaceChild("FrontRightLegWear", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 24.0F, 16.0F, new CubeDeformation(-5.8F)), PartPose.offset(0.0033F, -2.661F, -0.1352F));

		PartDefinition FrontRight = FrontLegs.addOrReplaceChild("FrontRight", CubeListBuilder.create().texOffs(56, 93).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9983F, 1.3912F, 0.5442F, -0.6221F, 0.2787F, 0.1438F));

		PartDefinition FRLegTumor = FrontRight.addOrReplaceChild("FRLegTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 7.0F, 0.0F));

		PartDefinition Tumor_r5 = FRLegTumor.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(15, 68).addBox(-1.0F, -1.5F, -0.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.3662F, 1.7191F, -1.6176F, 0.1442F, -0.0629F, -0.1848F));

		PartDefinition Tumor_r6 = FRLegTumor.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(6, 63).addBox(-3.0F, -2.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0928F, 0.3477F, 0.4244F));

		PartDefinition RightLegFungus = FrontRight.addOrReplaceChild("RightLegFungus", CubeListBuilder.create(), PartPose.offset(-2.061F, 5.7696F, 1.1083F));

		PartDefinition Fungus_r11 = RightLegFungus.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(-7, 83).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -4.2108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r12 = RightLegFungus.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(-7, 76).addBox(-3.5F, -3.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -2.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition FrontRight2 = FrontRight.addOrReplaceChild("FrontRight2", CubeListBuilder.create().texOffs(112, 89).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(124, 89).addBox(-1.5F, 4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 9.4021F, -0.1846F, 0.6504F, 0.0795F, -0.1041F));

		PartDefinition FrontRightFootWear = FrontRight2.addOrReplaceChild("FrontRightFootWear", CubeListBuilder.create().texOffs(0, 88).addBox(-14.5F, -5.0F, -1.5F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.8F)), PartPose.offset(6.3414F, 7.372F, -6.4631F));

		PartDefinition BodyBack = Nuckelavee.addOrReplaceChild("BodyBack", CubeListBuilder.create().texOffs(0, 42).addBox(-4.0F, -5.0F, 2.0F, 8.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.6964F, 1.5393F, -0.48F, 0.0F, 0.0F));

		PartDefinition Middle_r1 = BodyBack.addOrReplaceChild("Middle_r1", CubeListBuilder.create().texOffs(46, 24).addBox(-4.0F, -4.025F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -0.1564F, 0.7591F, 0.3927F, 0.0F, 0.0F));

		PartDefinition BackBodyDetails = BodyBack.addOrReplaceChild("BackBodyDetails", CubeListBuilder.create().texOffs(46, 0).addBox(-5.9315F, 0.5F, -8.4541F, 8.0F, 6.0F, 7.0F, new CubeDeformation(0.2F)), PartPose.offset(1.9315F, -5.5F, 10.4541F));

		PartDefinition BodySpine_r3 = BackBodyDetails.addOrReplaceChild("BodySpine_r3", CubeListBuilder.create().texOffs(120, 65).addBox(-2.0F, -0.5F, -0.25F, 2.0F, 1.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, -0.2618F, 0.0F));

		PartDefinition BodySpinePlane_r3 = BackBodyDetails.addOrReplaceChild("BodySpinePlane_r3", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -2.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7947F, 0.0F, -2.0072F, 0.1371F, 0.5435F, 0.4008F));

		PartDefinition BodySpine_r4 = BackBodyDetails.addOrReplaceChild("BodySpine_r4", CubeListBuilder.create().texOffs(104, 0).addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-3.9315F, 0.0F, -4.9541F, 0.0F, 0.3491F, 0.0F));

		PartDefinition BodySpinePlane_r4 = BackBodyDetails.addOrReplaceChild("BodySpinePlane_r4", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -3.0F, 0.25F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(120, 0).addBox(-1.0F, -0.5F, -0.25F, 2.0F, 1.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.9315F, 0.0F, -8.2041F, 0.0F, -0.3054F, 0.0F));

		PartDefinition BodySpine_r5 = BackBodyDetails.addOrReplaceChild("BodySpine_r5", CubeListBuilder.create().texOffs(116, 112).addBox(-2.0F, 0.0F, -3.25F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.9026F, -0.5F, -8.1418F, 0.4798F, 0.1749F, 0.0421F));

		PartDefinition BodySpinePlane_r5 = BackBodyDetails.addOrReplaceChild("BodySpinePlane_r5", CubeListBuilder.create().texOffs(0, 115).addBox(0.0F, -2.5F, -1.5F, 0.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5056F, 0.5458F, -10.6466F, 0.3613F, 0.2119F, -0.2923F));

		PartDefinition BodySpine_r6 = BackBodyDetails.addOrReplaceChild("BodySpine_r6", CubeListBuilder.create().texOffs(121, 100).addBox(-1.0F, -0.5F, -5.0F, 2.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3533F, 1.6151F, -11.2758F, 0.3992F, -0.0469F, -0.1141F));

		PartDefinition MiddleArmor_r1 = BackBodyDetails.addOrReplaceChild("MiddleArmor_r1", CubeListBuilder.create().texOffs(46, 13).addBox(-4.0F, -4.025F, -3.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.19F)), PartPose.offsetAndRotation(-1.9315F, 5.3436F, -9.695F, 0.3927F, 0.0F, 0.0F));

		PartDefinition BackBodyTumor = BackBodyDetails.addOrReplaceChild("BackBodyTumor", CubeListBuilder.create(), PartPose.offset(1.4981F, 4.3545F, -0.381F));

		PartDefinition Tumor_r7 = BackBodyTumor.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(0, 60).mirror().addBox(-4.0F, -15.0F, -4.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-0.35F)).mirror(false), PartPose.offsetAndRotation(0.8852F, 3.649F, 11.4848F, 1.6572F, 0.1843F, 1.9044F));

		PartDefinition BackFlower = BackBodyDetails.addOrReplaceChild("BackFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.9112F, 2.7886F, 2.763F, -1.7048F, 0.2163F, -0.0289F));

		PartDefinition cube_r7 = BackFlower.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(-7, 90).addBox(-3.14F, 0.0F, 0.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = BackFlower.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(-7, 90).addBox(-7.28F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r9 = BackFlower.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-7, 76).addBox(-3.14F, 0.0F, -8.28F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r10 = BackFlower.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-7, 83).addBox(1.0F, 0.0F, -4.14F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.69F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition TorsoFlower = BackBodyDetails.addOrReplaceChild("TorsoFlower", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.6145F, 1.1779F, -11.1421F, 0.5253F, -0.3787F, -0.2127F));

		PartDefinition cube_r11 = TorsoFlower.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(-7, 90).addBox(-7.1204F, -3.3985F, 0.1738F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1893F, 3.1859F, -3.1738F, -0.1059F, 0.0476F, 0.4507F));

		PartDefinition cube_r12 = TorsoFlower.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-7, 83).addBox(2.318F, -2.4883F, -0.8262F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1893F, 3.1859F, -3.1738F, -0.1086F, -0.0411F, -0.33F));

		PartDefinition cube_r13 = TorsoFlower.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(-7, 76).addBox(-2.3107F, -1.7289F, 4.1514F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1893F, 3.1859F, -3.1738F, 0.2767F, 0.0035F, 0.0603F));

		PartDefinition cube_r14 = TorsoFlower.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(-7, 76).addBox(-2.3107F, -4.158F, -5.287F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.1893F, 3.1859F, -3.1738F, -0.5087F, 0.0035F, 0.0603F));

		PartDefinition BackLegs = BodyBack.addOrReplaceChild("BackLegs", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.3574F, 6.0755F, 0.48F, 0.0F, 0.0F));

		PartDefinition BackLeft = BackLegs.addOrReplaceChild("BackLeft", CubeListBuilder.create().texOffs(56, 93).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.7483F, 1.3912F, 0.5442F, 0.1981F, -0.2046F, -0.2284F));

		PartDefinition LeftLegFungus = BackLeft.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offset(-0.811F, 5.3462F, 0.1083F));

		PartDefinition Fungus_r13 = LeftLegFungus.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(-7, 90).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -4.2108F, -1.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r14 = LeftLegFungus.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(-7, 90).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, -0.2664F, -0.4504F, 0.3859F));

		PartDefinition Fungus_r15 = LeftLegFungus.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(-7, 76).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.322F, 0.6324F, 0.3074F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r16 = LeftLegFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(-7, 83).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 2.7892F, -2.1025F, 0.0037F, -0.2977F, -0.0909F));

		PartDefinition BackLeft2 = BackLeft.addOrReplaceChild("BackLeft2", CubeListBuilder.create().texOffs(0, 98).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(88, 108).addBox(-1.5F, 3.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.2053F, 11.4352F, 0.1876F, -0.3403F, 0.0514F, 0.2382F));

		PartDefinition BackLeftFootWear = BackLeft2.addOrReplaceChild("BackLeftFootWear", CubeListBuilder.create().texOffs(0, 88).addBox(-14.5F, -5.0F, -1.5F, 16.0F, 16.0F, 16.0F, new CubeDeformation(-5.8F)), PartPose.offset(6.3F, 6.0F, -6.7F));

		PartDefinition BackRight = BackLegs.addOrReplaceChild("BackRight", CubeListBuilder.create().texOffs(72, 93).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7483F, 1.3912F, 0.5442F, 0.1981F, 0.2046F, 0.2284F));

		PartDefinition BackRight2 = BackRight.addOrReplaceChild("BackRight2", CubeListBuilder.create().texOffs(24, 107).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1736F, 11.8927F, -0.145F, -0.3831F, -0.0603F, -0.2348F));

		PartDefinition RightLegFungus2 = BackRight2.addOrReplaceChild("RightLegFungus2", CubeListBuilder.create(), PartPose.offset(-2.4847F, 3.92F, -0.1104F));

		PartDefinition Fungus_r17 = RightLegFungus2.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(-7, 90).addBox(-2.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5593F, -2.2108F, -2.1025F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r18 = RightLegFungus2.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(-7, 83).addBox(-3.5F, 0.0F, -7.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4407F, 2.7892F, 3.8975F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r19 = RightLegFungus2.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(-7, 76).addBox(-1.25F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, 4.7892F, 2.8975F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r20 = RightLegFungus2.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(-7, 90).addBox(-3.5F, 1.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5593F, -0.2108F, -3.1025F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition BRLegTumor = BackRight.addOrReplaceChild("BRLegTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r8 = BRLegTumor.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(6, 63).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.2038F, 1.0873F, -1.8612F, -0.1271F, 0.252F, 0.4888F));

		PartDefinition Tumor_r9 = BRLegTumor.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(1, 62).addBox(-3.25F, -2.5F, -1.75F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5F, -0.5F, -2.5F, 0.0F, 0.48F, 0.0F));

		PartDefinition BackRightLegWear = BackRight.addOrReplaceChild("BackRightLegWear", CubeListBuilder.create().texOffs(0, 64).addBox(-8.0F, -5.0F, -8.0F, 16.0F, 24.0F, 16.0F, new CubeDeformation(-5.8F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 128);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateWalk(NuckelaveAnimation.WALK,limbSwing,limbSwingAmount,3,4f);
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.animateTumor(BRLegTumor, Mth.sin(ageInTicks/6)/6);
		this.animateTumor(FootTumor, Mth.cos(ageInTicks/6)/8);
		this.animateTumor(FRLegTumor, Mth.sin(ageInTicks/7)/7);
		this.animateTumor(BackBodyTumor, Mth.cos(ageInTicks/8)/4);
		this.animateTumor(FrontBodyTumor, Mth.sin(ageInTicks/7)/8);
		this.animateTentacleX(Jaw,Mth.sin(ageInTicks/6)/6);
		if (entity.isAggressive()){
			if (entity.canDoRangedAttacks()){
				animateBowUsage(RightArm,LeftArm,ageInTicks);
			}else{
				animateMeleeUsage(RightArm,LeftArm,entity,ageInTicks);
			}
		}else{
			this.RightArm.xRot = Mth.sin(ageInTicks/6)/6;
			this.LeftArm.xRot = RightArm.xRot;
		}
	}

	private List<ModelPart> armorParts(){
		List<ModelPart> values = new ArrayList<>();
		values.add(HeadWear);
		values.add(LeftArmWear);
		values.add(RightArmWear);
		values.add(FrontRightFootWear);
		values.add(BackLeftFootWear);
		values.add(BackRightLegWear);
		values.add(FrontRightLegWear);
		return values;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Nuckelavee.getAllParts().forEach(this::setDraw);
		Nuckelavee.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return Nuckelavee;
	}

	public void setDraw(ModelPart part){
		if (armorParts().contains(part)){
			part.skipDraw = !showArmorBits;
		}else{
			part.skipDraw = showArmorBits;
		}
	}
	private ModelPart getArm(HumanoidArm humanoidArm) {
		return humanoidArm == HumanoidArm.LEFT ? this.LeftArm : this.RightArm;
	}
	@Override
	public void translateToHand(HumanoidArm humanoidArm, PoseStack poseStack) {
		this.getArm(humanoidArm).translateAndRotate(poseStack);
	}

	public void animateBowUsage(ModelPart rightArm , ModelPart leftArm,float ageInTicks){
		float $$7 = Mth.sin(this.attackTime * 3.1415927F);
		float $$8 = Mth.sin((1.0F - (1.0F - this.attackTime) * (1.0F - this.attackTime)) * 3.1415927F);
		rightArm.zRot = 0.0F;
		leftArm.zRot = 0.0F;
		rightArm.yRot = -(0.1F - $$7 * 0.6F);
		leftArm.yRot = 0.1F - $$7 * 0.6F;
		rightArm.xRot = -1.5707964F;
		leftArm.xRot = -1.5707964F;
        rightArm.xRot -= $$7 * 1.2F - $$8 * 0.4F;
        rightArm.xRot -= $$7 * 1.2F - $$8 * 0.4F;
		AnimationUtils.bobArms(rightArm, leftArm, ageInTicks);
	}

	public void animateMeleeUsage(ModelPart rightArm , ModelPart leftArm,T entity,float ageInTicks){
		AnimationUtils.swingWeaponDown(rightArm,leftArm,entity,this.attackTime,ageInTicks);
	}
}