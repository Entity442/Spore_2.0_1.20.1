package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
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

public class VigilSignModel<T extends Vigil> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "vigilsignmodel"), "main");
	private final ModelPart Biomasses;
	private final ModelPart BiomassDetails;
	private final ModelPart FungalStalks;
	private final ModelPart FungalStalk1;
	private final ModelPart Roots;
	private final ModelPart Root1;
	private final ModelPart Root2;
	private final ModelPart Body;
	private final ModelPart Torso;
    private final ModelPart Limbs;
	private final ModelPart Arm;
	private final ModelPart LegLeft;
	private final ModelPart LegRight;
	private final ModelPart LegRightDetails;
	private final ModelPart HeadPivot;
	private final ModelPart Head;
	private final ModelPart TTSeg1;
	private final ModelPart TTSeg2;
	private final ModelPart TTSeg3;
    private final ModelPart Eye;
	private final ModelPart pupil;
	private final ModelPart RighHolder;
	private final ModelPart Torso2;
	private final ModelPart arms;
	private final ModelPart RightArm;
    private final ModelPart FungalStalk2;
	private final ModelPart FungalStalk3;

    public VigilSignModel(ModelPart root) {
		this.Biomasses = root.getChild("Biomasses");
		this.BiomassDetails = this.Biomasses.getChild("BiomassDetails");
		this.FungalStalks = this.BiomassDetails.getChild("FungalStalks");
		this.FungalStalk1 = this.FungalStalks.getChild("FungalStalk1");
		this.Roots = root.getChild("Roots");
		this.Root1 = this.Roots.getChild("Root1");
		this.Root2 = this.Roots.getChild("Root2");
		this.Body = root.getChild("Body");
		this.Torso = this.Body.getChild("Torso");
		this.Limbs = root.getChild("Limbs");
		this.Arm = this.Limbs.getChild("Arm");
		this.LegLeft = this.Limbs.getChild("LegLeft");
		this.LegRight = this.Limbs.getChild("LegRight");
		this.LegRightDetails = this.LegRight.getChild("LegRightDetails");
		this.HeadPivot = root.getChild("HeadPivot");
		this.Head = this.HeadPivot.getChild("Head");
		this.TTSeg1 = this.HeadPivot.getChild("TTSeg1");
		this.TTSeg2 = this.TTSeg1.getChild("TTSeg2");
		this.TTSeg3 = this.TTSeg2.getChild("TTSeg3");
		this.Eye = this.TTSeg3.getChild("Eye");
		this.pupil = this.Eye.getChild("pupil");
		this.RighHolder = root.getChild("RighHolder");
		this.Torso2 = this.RighHolder.getChild("Torso2");
		this.arms = this.Torso2.getChild("arms");
		this.RightArm = this.arms.getChild("RightArm");
        this.FungalStalk2 = this.Torso2.getChild("FungalStalk2");
		this.FungalStalk3 = this.Torso2.getChild("FungalStalk3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Biomasses = partdefinition.addOrReplaceChild("Biomasses", CubeListBuilder.create(), PartPose.offset(-2.507F, 18.9545F, -1.2225F));

		PartDefinition BiomassChunk2_r1 = Biomasses.addOrReplaceChild("BiomassChunk2_r1", CubeListBuilder.create().texOffs(8, 3).addBox(-3.0F, -4.0F, -4.5F, 6.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2185F, 2.1609F, 1.8344F, -3.1401F, -0.1289F, 2.9878F));

		PartDefinition BiomassChunk1_r1 = Biomasses.addOrReplaceChild("BiomassChunk1_r1", CubeListBuilder.create().texOffs(4, 13).addBox(-2.5F, -2.5F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3499F, 0.4454F, -3.527F, -0.1788F, 0.0199F, -0.1365F));

		PartDefinition Biomassbase_r1 = Biomasses.addOrReplaceChild("Biomassbase_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8685F, 0.3937F, 1.6926F, 0.177F, -0.1987F, 0.0898F));

		PartDefinition BiomassDetails = Biomasses.addOrReplaceChild("BiomassDetails", CubeListBuilder.create(), PartPose.offset(-3.1662F, -1.3733F, 6.0279F));

		PartDefinition FungalPlane_r1 = BiomassDetails.addOrReplaceChild("FungalPlane_r1", CubeListBuilder.create().texOffs(47, 34).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.6419F, 2.8014F, -3.4025F, 1.0859F, -1.2932F, -0.7993F));

		PartDefinition FungalPlane_r2 = BiomassDetails.addOrReplaceChild("FungalPlane_r2", CubeListBuilder.create().texOffs(47, 34).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9002F, -2.3465F, 1.1347F, 0.312F, 1.049F, 0.3968F));

		PartDefinition FungalPlane_r3 = BiomassDetails.addOrReplaceChild("FungalPlane_r3", CubeListBuilder.create().texOffs(47, 34).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.7417F, 2.545F, 2.2677F, -0.2817F, 0.6784F, -0.0488F));

		PartDefinition FungalStalks = BiomassDetails.addOrReplaceChild("FungalStalks", CubeListBuilder.create(), PartPose.offset(-4.0768F, -0.3312F, -4.3055F));

		PartDefinition FungalStalk1 = FungalStalks.addOrReplaceChild("FungalStalk1", CubeListBuilder.create().texOffs(16, 56).addBox(-1.6415F, -1.0005F, -1.613F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.7085F, -0.6646F, -2.387F, 0.0F, 0.0F, -0.5236F));

		PartDefinition FungalStalk1Seg3_r1 = FungalStalk1.addOrReplaceChild("FungalStalk1Seg3_r1", CubeListBuilder.create().texOffs(0, 22).addBox(-1.6123F, -1.7904F, -1.3487F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.5218F, -5.7954F, 0.5442F, 0.0873F, 0.4363F, -0.2182F));

		PartDefinition FungalStalk1Seg2_r1 = FungalStalk1.addOrReplaceChild("FungalStalk1Seg2_r1", CubeListBuilder.create().texOffs(81, 74).addBox(-1.6123F, -1.2248F, -0.8447F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(-0.0867F, -2.8381F, 0.0688F, -0.5672F, 0.4363F, -0.2182F));

		PartDefinition Roots = partdefinition.addOrReplaceChild("Roots", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition Root1 = Roots.addOrReplaceChild("Root1", CubeListBuilder.create(), PartPose.offset(2.1574F, -3.2594F, 4.5687F));

		PartDefinition Root1seg3_r1 = Root1.addOrReplaceChild("Root1seg3_r1", CubeListBuilder.create().texOffs(13, 66).addBox(15.9957F, 1.5408F, -0.0365F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.493F, -0.639F, 0.7333F));

		PartDefinition Root1seg2_r1 = Root1.addOrReplaceChild("Root1seg2_r1", CubeListBuilder.create().texOffs(62, 43).addBox(9.7816F, -6.4135F, -0.0365F, 7.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.7137F, -0.3614F, 1.1832F));

		PartDefinition Root1seg1_r1 = Root1.addOrReplaceChild("Root1seg1_r1", CubeListBuilder.create().texOffs(71, 0).addBox(6.6479F, 0.3371F, -0.1433F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7207F, -4.1158F, -4.7401F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition Root1Details = Root1.addOrReplaceChild("Root1Details", CubeListBuilder.create(), PartPose.offset(-3.6574F, 7.2594F, -5.3187F));

		PartDefinition Root1Detail1 = Root1Details.addOrReplaceChild("Root1Detail1", CubeListBuilder.create(), PartPose.offset(8.8192F, -3.0F, 8.4264F));

		PartDefinition Root1Detail1Seg4_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg4_r1", CubeListBuilder.create().texOffs(38, 79).addBox(-0.1242F, 14.9328F, -0.4826F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 1.9044F, 1.098F, 1.2567F));

		PartDefinition Root1Detail1Seg3_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg3_r1", CubeListBuilder.create().texOffs(38, 79).addBox(11.8541F, 9.4517F, 5.7334F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.5059F, 0.367F, 0.5088F));

		PartDefinition Root1Detail1Seg2_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg2_r1", CubeListBuilder.create().texOffs(38, 79).addBox(10.105F, 2.901F, 9.991F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.4923F, 0.3776F, 0.9686F));

		PartDefinition Root1Detail1Seg1_r1 = Root1Detail1.addOrReplaceChild("Root1Detail1Seg1_r1", CubeListBuilder.create().texOffs(79, 40).addBox(5.4867F, 5.8562F, 9.9498F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-7.8825F, -8.3752F, -7.8478F, 0.3598F, 0.5049F, 0.661F));

		PartDefinition Root1Detail2 = Root1Details.addOrReplaceChild("Root1Detail2", CubeListBuilder.create(), PartPose.offset(-1.0F, -1.75F, -0.5F));

		PartDefinition Root2Detail2Seg2_r1 = Root1Detail2.addOrReplaceChild("Root2Detail2Seg2_r1", CubeListBuilder.create().texOffs(38, 79).addBox(-12.1372F, 9.1704F, 5.2504F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.206F, 0.4076F, -0.9762F));

		PartDefinition Root1Detail2Seg1_r1 = Root1Detail2.addOrReplaceChild("Root1Detail2Seg1_r1", CubeListBuilder.create().texOffs(79, 40).addBox(-11.1641F, 9.1704F, 1.4283F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(1.9366F, -9.6252F, 1.0786F, 0.27F, 0.7897F, -0.8648F));

		PartDefinition Root1SmallDetails = Root1Details.addOrReplaceChild("Root1SmallDetails", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Root1DetailSmall2_r1 = Root1SmallDetails.addOrReplaceChild("Root1DetailSmall2_r1", CubeListBuilder.create().texOffs(38, 79).addBox(4.0438F, 7.0416F, -0.2856F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.9366F, -11.3752F, 0.5786F, 1.7F, 0.3469F, 0.9995F));

		PartDefinition Root1DetailSmall1_r1 = Root1SmallDetails.addOrReplaceChild("Root1DetailSmall1_r1", CubeListBuilder.create().texOffs(24, 28).addBox(13.2594F, 1.9374F, -4.6722F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.9366F, -11.3752F, 0.5786F, 1.5395F, -0.5514F, 0.4852F));

		PartDefinition Root2 = Roots.addOrReplaceChild("Root2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.8426F, -3.2594F, -4.4313F, 0.0F, 3.0107F, 0.0F));

		PartDefinition Root2seg3_r1 = Root2.addOrReplaceChild("Root2seg3_r1", CubeListBuilder.create().texOffs(13, 66).addBox(-2.4627F, -0.6566F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(7.6324F, 7.6551F, 6.6921F, -0.493F, -0.639F, 0.7333F));

		PartDefinition Root2seg2_r1 = Root2.addOrReplaceChild("Root2seg2_r1", CubeListBuilder.create().texOffs(62, 43).addBox(-2.634F, -1.0F, -1.5F, 7.0F, 3.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.164F, 3.9296F, 4.2236F, -0.7137F, -0.3614F, 1.1832F));

		PartDefinition Root2seg1_r1 = Root2.addOrReplaceChild("Root2seg1_r1", CubeListBuilder.create().texOffs(71, 0).addBox(-2.0774F, -0.5937F, -1.5F, 5.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8483F, 0.4153F, 1.7569F, -0.3999F, -0.6956F, 0.583F));

		PartDefinition Root2Details = Root2.addOrReplaceChild("Root2Details", CubeListBuilder.create(), PartPose.offset(2.8426F, 7.2594F, 4.4313F));

		PartDefinition Root2Detail1 = Root2Details.addOrReplaceChild("Root2Detail1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4199F, -6.8482F, -1.4222F, 2.864F, -0.1509F, 3.0251F));

		PartDefinition Root2Detail1Seg4_r1 = Root2Detail1.addOrReplaceChild("Root2Detail1Seg4_r1", CubeListBuilder.create().texOffs(78, 31).addBox(22.4779F, -8.7118F, -5.0278F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(11.827F, -12.2814F, 15.5416F, 2.27F, 0.6524F, 1.6452F));

		PartDefinition Root2Detail1Seg3_r1 = Root2Detail1.addOrReplaceChild("Root2Detail1Seg3_r1", CubeListBuilder.create().texOffs(79, 6).addBox(5.4077F, 8.298F, -23.7817F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(11.827F, -12.2814F, 15.5416F, 0.5059F, 0.367F, 0.5088F));

		PartDefinition Root2Detail1Seg2_r1 = Root2Detail1.addOrReplaceChild("Root2Detail1Seg2_r1", CubeListBuilder.create().texOffs(38, 79).addBox(14.5875F, 0.5025F, -19.8384F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(11.827F, -12.2814F, 15.5416F, 0.5996F, 0.1245F, 1.3912F));

		PartDefinition Root2Detail1Seg1_r1 = Root2Detail1.addOrReplaceChild("Root2Detail1Seg1_r1", CubeListBuilder.create().texOffs(79, 40).addBox(6.1436F, 10.645F, -19.8796F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(11.827F, -12.2814F, 15.5416F, 0.3598F, 0.5049F, 0.661F));

		PartDefinition Root2Detail2 = Root2Details.addOrReplaceChild("Root2Detail2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.8528F, 1.1231F, 2.3581F, -1.8776F, 0.9844F, -2.2956F));

		PartDefinition Root2Detail2Seg2_r2 = Root2Detail2.addOrReplaceChild("Root2Detail2Seg2_r2", CubeListBuilder.create().texOffs(74, 12).addBox(-28.2214F, -20.3397F, 2.6023F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.65F)), PartPose.offsetAndRotation(27.8021F, -6.3895F, -7.7042F, 0.206F, 0.4076F, -0.9762F));

		PartDefinition Root2Detail2Seg1_r1 = Root2Detail2.addOrReplaceChild("Root2Detail2Seg1_r1", CubeListBuilder.create().texOffs(62, 80).addBox(-25.0105F, -20.3397F, -7.1734F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(27.8021F, -6.3895F, -7.7042F, 0.27F, 0.7897F, -0.8648F));

		PartDefinition Root2SmallDetails = Root2Details.addOrReplaceChild("Root2SmallDetails", CubeListBuilder.create(), PartPose.offset(2.8595F, -3.7916F, -2.2931F));

		PartDefinition Root2DetailSmall2_r1 = Root2SmallDetails.addOrReplaceChild("Root2DetailSmall2_r1", CubeListBuilder.create().texOffs(12, 52).addBox(-0.2089F, -0.8361F, -1.5731F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-1.2173F, -2.7417F, -0.7964F, 1.7F, 0.3469F, 0.9995F));

		PartDefinition Root2DetailSmall1_r1 = Root2SmallDetails.addOrReplaceChild("Root2DetailSmall1_r1", CubeListBuilder.create().texOffs(24, 28).addBox(-0.0642F, -0.3487F, -1.1494F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.2173F, 2.4917F, 2.0464F, 1.6909F, 0.3921F, 0.8362F));

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Torso = Body.addOrReplaceChild("Torso", CubeListBuilder.create().texOffs(33, 0).addBox(-3.9332F, -5.2123F, -1.6595F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -2.0F, -1.0054F, -0.0561F, 0.0669F));

		PartDefinition TorsoBottom_r1 = Torso.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(44, 46).addBox(-3.4332F, -2.6816F, -1.4292F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3869F, 1.0756F, 0.3927F, 0.0F, 0.0F));

		PartDefinition TorsoDetails = Torso.addOrReplaceChild("TorsoDetails", CubeListBuilder.create(), PartPose.offset(0.8913F, 4.9163F, -1.8782F));

		PartDefinition FungalPlane_r4 = TorsoDetails.addOrReplaceChild("FungalPlane_r4", CubeListBuilder.create().texOffs(47, 34).addBox(-3.0747F, 0.974F, -3.2139F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4553F, -1.297F, -0.5638F, 1.9438F, -0.4775F, -1.9859F));

		PartDefinition FungalPlane_r5 = TorsoDetails.addOrReplaceChild("FungalPlane_r5", CubeListBuilder.create().texOffs(47, 34).addBox(-2.8293F, 0.9806F, -3.0964F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4553F, 1.297F, 0.5638F, 2.2186F, -0.3986F, -2.9485F));

		PartDefinition TorsoStalk1 = TorsoDetails.addOrReplaceChild("TorsoStalk1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8087F, -4.3122F, -0.2585F, 0.0746F, -0.2556F, -0.5702F));

		PartDefinition TorsoStalk1Seg2_r1 = TorsoStalk1.addOrReplaceChild("TorsoStalk1Seg2_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-0.0455F, -1.7506F, -1.0393F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-0.1189F, -0.1177F, -0.7685F, 1.7393F, -0.1282F, 0.6001F));

		PartDefinition TorsoStalk1Seg1_r1 = TorsoStalk1.addOrReplaceChild("TorsoStalk1Seg1_r1", CubeListBuilder.create().texOffs(7, 0).addBox(-0.4157F, -0.8586F, -0.9952F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 1.0F, 1.4779F, 0.1005F, 0.3357F));

		PartDefinition TorsoStalk2 = TorsoDetails.addOrReplaceChild("TorsoStalk2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.3913F, -3.3122F, -0.0585F, -0.1699F, 0.4747F, -1.1188F));

		PartDefinition TorsoStalk2Seg2_r1 = TorsoStalk2.addOrReplaceChild("TorsoStalk2Seg2_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-0.9355F, -1.6809F, -0.8735F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.6344F, -0.8463F, -1.5673F, 1.2604F, -0.1713F, 0.5927F));

		PartDefinition TorsoStalk2Seg1_r1 = TorsoStalk2.addOrReplaceChild("TorsoStalk2Seg1_r1", CubeListBuilder.create().texOffs(44, 34).addBox(-1.2337F, -1.6998F, -0.8987F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.7682F, -0.5603F, 0.5861F, 1.4779F, 0.1005F, 0.3357F));

		PartDefinition TorsoConnectors = TorsoDetails.addOrReplaceChild("TorsoConnectors", CubeListBuilder.create().texOffs(17, 13).addBox(2.3927F, -0.1702F, 0.0061F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.2172F, -9.2085F, 4.7127F));

		PartDefinition TorsoContector3_r1 = TorsoConnectors.addOrReplaceChild("TorsoContector3_r1", CubeListBuilder.create().texOffs(20, 16).addBox(-0.6605F, -0.6174F, -0.02F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-0.4779F, 0.1352F, -0.15F, 0.351F, -0.1685F, -2.6655F));

		PartDefinition TorsoContector2_r1 = TorsoConnectors.addOrReplaceChild("TorsoContector2_r1", CubeListBuilder.create().texOffs(28, 4).addBox(0.116F, -0.1487F, -0.2949F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-2.3481F, 0.0726F, -0.0156F, 0.0F, -0.2618F, 0.7418F));

		PartDefinition Limbs = partdefinition.addOrReplaceChild("Limbs", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Arm = Limbs.addOrReplaceChild("Arm", CubeListBuilder.create(), PartPose.offset(4.0F, -12.0F, 1.0F));

		PartDefinition ArmLeft = Arm.addOrReplaceChild("ArmLeft", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.2215F, -0.8255F, -0.2477F, 0.3054F, -1.2217F, -1.6144F));

		PartDefinition ArmLeftBottom_r1 = ArmLeft.addOrReplaceChild("ArmLeftBottom_r1", CubeListBuilder.create().texOffs(53, 71).addBox(-1.1748F, 1.0076F, -1.3947F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.4884F, 4.5717F, 0.6991F, 0.8284F, 0.0151F, -0.0859F));

		PartDefinition ArmLeftTop_r1 = ArmLeft.addOrReplaceChild("ArmLeftTop_r1", CubeListBuilder.create().texOffs(12, 72).addBox(-2.5112F, 3.2046F, -2.259F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1956F, -3.9336F, 0.2151F, 0.2611F, 0.0151F, -0.0859F));

		PartDefinition LegLeft = Limbs.addOrReplaceChild("LegLeft", CubeListBuilder.create().texOffs(40, 57).addBox(-2.4226F, -0.0937F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -7.5F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LegLeftDetails = LegLeft.addOrReplaceChild("LegLeftDetails", CubeListBuilder.create().texOffs(91, 0).addBox(-3.1167F, -4.872F, -1.4456F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offset(0.6941F, 4.7783F, -0.5544F));

		PartDefinition LLTumor_r1 = LegLeftDetails.addOrReplaceChild("LLTumor_r1", CubeListBuilder.create().texOffs(17, 10).addBox(-2.5969F, -3.8261F, -2.6063F, 6.0F, 6.0F, 6.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.6941F, -0.2217F, -0.5544F, 0.3054F, 0.3054F, -3.1416F));

		PartDefinition LegRight = Limbs.addOrReplaceChild("LegRight", CubeListBuilder.create(), PartPose.offset(-4.4083F, -8.06F, 2.6738F));

		PartDefinition LegRight_r1 = LegRight.addOrReplaceChild("LegRight_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 4.5F, 5.0F, 1.0979F, -0.5593F, -0.2142F));

		PartDefinition LegRightDetails = LegRight.addOrReplaceChild("LegRightDetails", CubeListBuilder.create(), PartPose.offset(-2.0F, 3.5F, 5.0F));

		PartDefinition LegRightClothDetail_r1 = LegRightDetails.addOrReplaceChild("LegRightClothDetail_r1", CubeListBuilder.create().texOffs(91, 0).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 1.0979F, -0.5593F, -0.2142F));

		PartDefinition LegRightDetail1 = LegRightDetails.addOrReplaceChild("LegRightDetail1", CubeListBuilder.create(), PartPose.offset(0.4083F, 0.56F, 2.3262F));

		PartDefinition LegRightDetail2Seg2_r1 = LegRightDetail1.addOrReplaceChild("LegRightDetail2Seg2_r1", CubeListBuilder.create().texOffs(65, 43).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(1.4512F, 2.3603F, 1.4512F, -1.0036F, 0.7854F, 0.0F));

		PartDefinition LegRightDetail1Seg1_r1 = LegRightDetail1.addOrReplaceChild("LegRightDetail1Seg1_r1", CubeListBuilder.create().texOffs(17, 66).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.6109F, 0.7854F, 0.0F));

		PartDefinition ArmRight = Limbs.addOrReplaceChild("ArmRight", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.3788F, -13.5169F, -2.3162F, 0.1309F, 0.0F, 0.0F));

		PartDefinition ArmRightCloth_r1 = ArmRight.addOrReplaceChild("ArmRightCloth_r1", CubeListBuilder.create().texOffs(1, 87).addBox(-0.9667F, -3.1642F, -1.3698F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.2F))
		.texOffs(28, 69).addBox(-0.9667F, -3.1642F, -1.3698F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.75F, 2.75F, 0.0F, -0.2259F, 0.133F, 0.5528F));

		PartDefinition HeadPivot = partdefinition.addOrReplaceChild("HeadPivot", CubeListBuilder.create(), PartPose.offset(0.0F, 9.0F, 0.0F));

		PartDefinition Head = HeadPivot.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(16, 61).addBox(-3.7156F, 0.102F, 0.5754F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, -3.7505F, -0.8641F, -1.6637F, 0.0F, 0.0331F));

		PartDefinition BottomJaw_r1 = Head.addOrReplaceChild("BottomJaw_r1", CubeListBuilder.create().texOffs(44, 28).addBox(-3.9705F, -0.109F, -5.0801F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2449F, 2.0651F, 1.3196F, 0.48F, 0.0F, 0.0F));

		PartDefinition HeadTop_r1 = Head.addOrReplaceChild("HeadTop_r1", CubeListBuilder.create().texOffs(36, 14).addBox(-3.9705F, -3.5292F, -3.152F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2449F, -2.3432F, -0.5714F, -0.48F, 0.0F, 0.0F));

		PartDefinition HeadDetails = Head.addOrReplaceChild("HeadDetails", CubeListBuilder.create(), PartPose.offset(0.2449F, -3.8206F, -4.2852F));

		PartDefinition TTSeg1 = HeadPivot.addOrReplaceChild("TTSeg1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4197F, -5.4008F, -1.5846F, -0.6545F, 0.0F, 0.0F));

		PartDefinition TTSeg1_r1 = TTSeg1.addOrReplaceChild("TTSeg1_r1", CubeListBuilder.create().texOffs(24, 46).addBox(-3.0F, -8.5937F, -1.5774F, 6.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition TTSeg1Details = TTSeg1.addOrReplaceChild("TTSeg1Details", CubeListBuilder.create(), PartPose.offset(0.5803F, 2.4008F, 0.3346F));

		PartDefinition TTSeg1Teeth2_r1 = TTSeg1Details.addOrReplaceChild("TTSeg1Teeth2_r1", CubeListBuilder.create().texOffs(44, 26).addBox(-0.9274F, -1.6148F, -1.3199F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8071F, -7.8007F, -3.8942F, 0.1988F, 0.0808F, -0.1629F));

		PartDefinition TTSeg1Teeth1_r1 = TTSeg1Details.addOrReplaceChild("TTSeg1Teeth1_r1", CubeListBuilder.create().texOffs(7, 3).addBox(-1.778F, -0.6892F, -0.3585F, 0.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2085F, -7.616F, -5.0597F, 0.0803F, -0.0184F, 0.269F));

		PartDefinition TTSeg2 = TTSeg1.addOrReplaceChild("TTSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0274F, -8.7911F, -2.3391F, 0.9599F, 0.0F, 0.0F));

		PartDefinition TTSeg2_r1 = TTSeg2.addOrReplaceChild("TTSeg2_r1", CubeListBuilder.create().texOffs(56, 57).addBox(-3.3F, -9.2509F, -1.7936F, 5.0F, 11.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.8F, -0.3472F, 1.0121F, -0.2618F, 0.0F, 0.0F));

		PartDefinition TTSeg2Details = TTSeg2.addOrReplaceChild("TTSeg2Details", CubeListBuilder.create(), PartPose.offset(0.2456F, -0.503F, 0.21F));

		PartDefinition TTSeg2Teeth3_r1 = TTSeg2Details.addOrReplaceChild("TTSeg2Teeth3_r1", CubeListBuilder.create().texOffs(0, 36).addBox(-1.125F, -3.7435F, 1.8669F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.82F, -4.8311F, 1.3656F, -0.2674F, -0.0687F, -0.111F));

		PartDefinition TTSeg2Teeth2_r1 = TTSeg2Details.addOrReplaceChild("TTSeg2Teeth2_r1", CubeListBuilder.create().texOffs(24, 70).addBox(-1.0748F, -4.5028F, -1.8071F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5469F, -5.1408F, 0.3583F, -0.2952F, -0.0566F, -0.0607F));

		PartDefinition TTSeg2Teeth1_r1 = TTSeg2Details.addOrReplaceChild("TTSeg2Teeth1_r1", CubeListBuilder.create().texOffs(0, 77).addBox(-0.9343F, -4.5027F, -1.0326F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.262F, -5.0733F, -1.1303F, -0.2674F, 0.3181F, -0.0313F));

		PartDefinition TTSeg3 = TTSeg2.addOrReplaceChild("TTSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1829F, -9.9223F, 3.6018F, 0.5672F, 0.0F, 0.0F));

		PartDefinition TTSeg3_r1 = TTSeg3.addOrReplaceChild("TTSeg3_r1", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -7.2882F, -2.637F, 4.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -0.9894F, 0.4357F, 0.2182F, 0.0F, 0.0F));

		PartDefinition TTSeg3Details = TTSeg3.addOrReplaceChild("TTSeg3Details", CubeListBuilder.create(), PartPose.offset(0.1044F, -0.3489F, 0.0084F));

		PartDefinition TTS3Teeth2_r1 = TTSeg3Details.addOrReplaceChild("TTS3Teeth2_r1", CubeListBuilder.create().texOffs(18, 36).addBox(0.2751F, -2.4901F, -2.1757F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.6603F, -3.9223F, -2.7452F, 0.3796F, -0.2079F, -0.3157F));

		PartDefinition TTS3Teeth1_r1 = TTSeg3Details.addOrReplaceChild("TTS3Teeth1_r1", CubeListBuilder.create().texOffs(65, 69).addBox(-0.75F, -2.0382F, -1.437F, 0.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5177F, -3.607F, -3.4521F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Connectors = TTSeg3.addOrReplaceChild("Connectors", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4248F, -7.3858F, -1.9281F, 0.48F, 0.0F, 0.0F));

		PartDefinition EyeConnector1 = Connectors.addOrReplaceChild("EyeConnector1", CubeListBuilder.create(), PartPose.offset(-1.9081F, -0.9207F, -0.4373F));

		PartDefinition Connector1Seg1_r1 = EyeConnector1.addOrReplaceChild("Connector1Seg1_r1", CubeListBuilder.create().texOffs(24, 46).addBox(-0.9893F, -1.4782F, -1.3719F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6745F, -1.062F, 0.0837F, 0.182F, -0.3968F, -0.5952F));

		PartDefinition Connector1Seg2_r1 = EyeConnector1.addOrReplaceChild("Connector1Seg2_r1", CubeListBuilder.create().texOffs(18, 43).addBox(-0.8144F, -0.6246F, -1.3719F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3255F, -2.9379F, -0.0837F, -0.1876F, -0.3943F, 0.3081F));

		PartDefinition EyeConnector2 = Connectors.addOrReplaceChild("EyeConnector2", CubeListBuilder.create(), PartPose.offset(1.5374F, -0.2275F, 0.5797F));

		PartDefinition Connector2Seg2_r1 = EyeConnector2.addOrReplaceChild("Connector2Seg2_r1", CubeListBuilder.create().texOffs(24, 46).addBox(-0.0046F, -1.5983F, -1.4952F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0866F, -1.2638F, -0.4902F, 0.2888F, -0.1119F, 0.5065F));

		PartDefinition Connector2Seg1_r1 = EyeConnector2.addOrReplaceChild("Connector2Seg1_r1", CubeListBuilder.create().texOffs(18, 43).addBox(1.0804F, -2.3067F, -1.4947F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0866F, -1.2638F, -0.4902F, 0.2529F, 0.1797F, -0.4579F));

		PartDefinition EyeConnector3 = Connectors.addOrReplaceChild("EyeConnector3", CubeListBuilder.create(), PartPose.offset(0.4534F, 0.0622F, 1.0592F));

		PartDefinition Connector3Seg1_r1 = EyeConnector3.addOrReplaceChild("Connector3Seg1_r1", CubeListBuilder.create().texOffs(24, 46).addBox(5.1019F, -12.4403F, -0.4798F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7264F, 4.4237F, -11.4828F, -1.2655F, -0.8825F, 1.3009F));

		PartDefinition Connector3Seg1_r2 = EyeConnector3.addOrReplaceChild("Connector3Seg1_r2", CubeListBuilder.create().texOffs(18, 43).addBox(12.9682F, -3.8253F, -0.4794F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7264F, 4.4237F, -11.4828F, 1.0407F, -1.1836F, -1.1048F));

		PartDefinition EyeConnector4 = Connectors.addOrReplaceChild("EyeConnector4", CubeListBuilder.create(), PartPose.offset(-1.1657F, -0.1095F, -0.7097F));

		PartDefinition Connector3Seg2_r1 = EyeConnector4.addOrReplaceChild("Connector3Seg2_r1", CubeListBuilder.create().texOffs(24, 46).addBox(0.5698F, -1.2454F, -0.5814F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0817F, -1.4844F, -1.2549F, 1.4324F, 0.5521F, 1.6544F));

		PartDefinition Connector3Seg2_r2 = EyeConnector4.addOrReplaceChild("Connector3Seg2_r2", CubeListBuilder.create().texOffs(18, 43).addBox(1.0819F, -1.6201F, -0.6406F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0817F, -1.4844F, -1.2549F, 0.0035F, 1.4376F, -0.0485F));

		PartDefinition Eye = TTSeg3.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(0, 22).addBox(-3.1924F, -6.0115F, -3.9335F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(-0.9479F, -11.51F, -7.4719F, -1.0036F, 0.0F, 0.0F));

		PartDefinition pupil = Eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(65, 34).addBox(-2.5F, -1.5086F, -1.3695F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)), PartPose.offset(0.7905F, -2.9971F, -3.436F));

		PartDefinition flower2 = HeadPivot.addOrReplaceChild("flower2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.75F, -5.75F, 4.0F, -1.5272F, 0.0F, 0.0F));

		PartDefinition cube_r1 = flower2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(104, 6).addBox(-5.9833F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r2 = flower2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(104, 6).addBox(-0.0167F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r3 = flower2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, 0.4226F, 0.9063F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r4 = flower2.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, -0.342F, -5.0603F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower3 = HeadPivot.addOrReplaceChild("flower3", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.25F, -5.75F, 4.0F, -1.5272F, -0.9163F, 0.0F));

		PartDefinition cube_r5 = flower3.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(104, 6).addBox(-5.9833F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r6 = flower3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(104, 6).addBox(-0.0167F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r7 = flower3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, 0.4226F, 0.9063F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r8 = flower3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, -0.342F, -5.0603F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition flower4 = HeadPivot.addOrReplaceChild("flower4", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.25F, -5.75F, 1.0F, -1.5272F, -1.0036F, 0.0F));

		PartDefinition cube_r9 = flower4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(104, 6).addBox(-5.9833F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r10 = flower4.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(104, 6).addBox(-0.0167F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r11 = flower4.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, 0.4226F, 0.9063F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r12 = flower4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, -0.342F, -5.0603F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition RighHolder = partdefinition.addOrReplaceChild("RighHolder", CubeListBuilder.create(), PartPose.offset(-6.0F, 14.0F, 2.0F));

		PartDefinition Torso2 = RighHolder.addOrReplaceChild("Torso2", CubeListBuilder.create().texOffs(33, 0).addBox(-3.9332F, -5.2123F, -1.6595F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -2.0F, 2.0F, -2.3056F, 1.1093F, -2.7458F));

		PartDefinition TorsoBottom_r2 = Torso2.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(44, 46).addBox(-3.4332F, -2.6816F, -1.4292F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.3869F, 1.0756F, 0.3927F, 0.0F, 0.0F));

		PartDefinition arms = Torso2.addOrReplaceChild("arms", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, 0.0F));

		PartDefinition LeftArm = arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(4.7785F, -0.8255F, 1.7523F, -2.3126F, 0.3054F, 3.1416F));

		PartDefinition cube_r13 = LeftArm.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(53, 71).addBox(-1.1748F, 1.0076F, -1.3947F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.4884F, 4.5717F, 0.6991F, 0.7506F, 0.3914F, -0.4603F));

		PartDefinition cube_r14 = LeftArm.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 72).addBox(-2.5112F, 3.2046F, -2.259F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1956F, -3.9336F, 0.2151F, 0.2611F, 0.0151F, -0.0859F));

		PartDefinition RightArm = arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.2215F, -0.8255F, 1.7523F, -2.2742F, 0.1035F, -2.9031F));

		PartDefinition cube_r15 = RightArm.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(53, 71).addBox(-1.1748F, 1.0076F, -1.3947F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.4884F, 4.5717F, 0.6991F, 0.8092F, -0.4544F, 0.3862F));

		PartDefinition cube_r16 = RightArm.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 72).addBox(-2.5112F, 3.2046F, -2.259F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1956F, -3.9336F, 0.2151F, 0.2611F, 0.0151F, -0.0859F));

		PartDefinition FungalStalk2 = Torso2.addOrReplaceChild("FungalStalk2", CubeListBuilder.create().texOffs(16, 56).addBox(-1.6415F, -1.0005F, -1.613F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offset(-0.0415F, -5.4146F, 2.113F));

		PartDefinition FungalStalk1Seg3_r2 = FungalStalk2.addOrReplaceChild("FungalStalk1Seg3_r2", CubeListBuilder.create().texOffs(0, 22).addBox(-1.6123F, -1.7904F, -1.3487F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.5218F, -5.7954F, 0.5442F, 0.0873F, 0.4363F, -0.2182F));

		PartDefinition FungalStalk1Seg2_r2 = FungalStalk2.addOrReplaceChild("FungalStalk1Seg2_r2", CubeListBuilder.create().texOffs(81, 74).addBox(-1.6123F, -1.2248F, -0.8447F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(-0.0867F, -2.8381F, 0.0688F, -0.5672F, 0.4363F, -0.2182F));

		PartDefinition FungalStalk3 = Torso2.addOrReplaceChild("FungalStalk3", CubeListBuilder.create().texOffs(16, 56).addBox(-1.6415F, -1.0005F, -1.613F, 2.0F, 3.0F, 2.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-0.0415F, -5.4146F, 0.113F, 2.0959F, -1.1243F, -2.0523F));

		PartDefinition FungalStalk1Seg3_r3 = FungalStalk3.addOrReplaceChild("FungalStalk1Seg3_r3", CubeListBuilder.create().texOffs(0, 22).addBox(-1.6123F, -1.7904F, -1.3487F, 2.0F, 5.0F, 2.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-0.5218F, -5.7954F, 0.5442F, 0.0873F, 0.4363F, -0.2182F));

		PartDefinition FungalStalk1Seg2_r3 = FungalStalk3.addOrReplaceChild("FungalStalk1Seg2_r3", CubeListBuilder.create().texOffs(81, 74).addBox(-1.6123F, -1.2248F, -0.8447F, 2.0F, 4.0F, 2.0F, new CubeDeformation(-0.45F)), PartPose.offsetAndRotation(-0.0867F, -2.8381F, 0.0688F, -0.5672F, 0.4363F, -0.2182F));

		PartDefinition flower5 = Torso2.addOrReplaceChild("flower5", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.25F, -5.25F, 0.0F, -0.2182F, 0.0F, 0.1745F));

		PartDefinition cube_r17 = flower5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(104, 6).addBox(-5.9833F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition cube_r18 = flower5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(104, 6).addBox(-0.0167F, 0.0403F, -2.001F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r19 = flower5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, 0.4226F, 0.9063F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r20 = flower5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(104, 0).addBox(-4.0F, -0.342F, -5.0603F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public List<ModelPart> getArms(){return new ArrayList<>(){{add(RighHolder);add(Torso2);add(arms);}};}
	@Override
	public void setupAnim(T vigil, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.Roots.xScale = 1 - Mth.cos(ageInTicks/10)/10;
		this.Roots.yScale = 1 - Mth.cos(ageInTicks/10)/10;
		this.Roots.zScale = 1 - Mth.cos(ageInTicks/10)/10;
		this.Biomasses.xScale = 1 + Mth.cos(ageInTicks/10)/11;
		this.Biomasses.yScale = 1 - Mth.cos(ageInTicks/11)/10;
		this.Biomasses.zScale = 1 + Mth.cos(ageInTicks/10)/9;
		this.FungalStalks.xRot = Mth.sin(ageInTicks/4)/6;
		this.FungalStalks.zRot = Mth.sin(ageInTicks/7)/6;
		this.Arm.yRot = Mth.sin(ageInTicks/8)/6;
		this.LegRight.yRot = Mth.sin(ageInTicks/7)/5;
		this.LegLeft.zRot = Mth.sin(ageInTicks/5)/9;
		this.HeadPivot.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.TTSeg1.xRot = -0.3f + Mth.sin(ageInTicks/7)/6;
		Entity entity = Minecraft.getInstance().getCameraEntity();
		if (entity != null) {
			Vec3 vec3 = entity.getEyePosition(0.0F);
			Vec3 vec31 = vigil.getEyePosition(0.0F);
			double d0 = vec3.y - vec31.y;
			if (d0 > 0.0D) {
				this.pupil.y = -3.0F;
			} else {
				this.pupil.y = -2.0F;
			}

			Vec3 vec32 = vigil.getViewVector(0.0F);
			vec32 = new Vec3(vec32.x, 0.0D, vec32.z);
			Vec3 vec33 = (new Vec3(vec31.x - vec3.x, 0.0D, vec31.z - vec3.z)).normalize().yRot(((float)Math.PI / 2F));
			double d1 = vec32.dot(vec33);
			this.pupil.x =1+ Mth.sqrt((float)Math.abs(d1)) * 1.5F * (float)Math.signum(d1);
		}
		this.RighHolder.xRot = Mth.sin(ageInTicks/7)/8;
		this.arms.xRot = Mth.cos(ageInTicks/6)/6;
		this.animateTentacleX(FungalStalk3,Mth.cos(ageInTicks/6)/5);
		this.animateTentacleZ(FungalStalk3,Mth.cos(ageInTicks/6)/4);
		this.animateTentacleX(FungalStalk2,-Mth.cos(ageInTicks/6)/6);
		this.animateTentacleZ(FungalStalk2,-Mth.cos(ageInTicks/5)/5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Biomasses.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Roots.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		Limbs.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		HeadPivot.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		RighHolder.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}