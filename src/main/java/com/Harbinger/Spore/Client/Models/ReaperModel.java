package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Models.TentacledModel;
import com.Harbinger.Spore.Sentities.Utility.Reaper;
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

public class ReaperModel<T extends Reaper> extends EntityModel<T> implements TentacledModel {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "reapermodel"), "main");
	private final ModelPart Reaper;
	private final ModelPart Body;
	private final ModelPart TorsoHead;
	private final ModelPart Torso;
	private final ModelPart Details;
	private final ModelPart BackLegs;
	private final ModelPart TumourousBackLeg;
	private final ModelPart BLTumours;
	private final ModelPart TumorClump2;
	private final ModelPart Tumor4;
	private final ModelPart BackLeg;
	private final ModelPart SecondaryBackLeg;
	private final ModelPart Tumor3;
	private final ModelPart WeakenedLimbs;
	private final ModelPart RightLimb;
	private final ModelPart LeftLimb;
	private final ModelPart Tendrils;
	private final ModelPart Tendril2;
	private final ModelPart T2;
	private final ModelPart Tendril3;
	private final ModelPart T3;
	private final ModelPart Tendril4;
	private final ModelPart T4;
	private final ModelPart Tendril5;
	private final ModelPart Tendril;
	private final ModelPart T;
	private final ModelPart Tumor2;
	private final ModelPart TumorClump;
	private final ModelPart Head;
	private final ModelPart HeadTop;
	private final ModelPart PetalCrown;
	private final ModelPart Nose;
	private final ModelPart Jaw;
	private final ModelPart Tumor5;
	private final ModelPart headwear;
	private final ModelPart Arms;
	private final ModelPart LeftArm;
	private final ModelPart LeftArmMidSeg;
	private final ModelPart Tumor6;
	private final ModelPart LeftSickle;
	private final ModelPart LeftSickleEndSeg;
	private final ModelPart RightArm;
	private final ModelPart TumorClump3;
	private final ModelPart RightArmMidSeg;
	private final ModelPart RightSickle;
	private final ModelPart RightSickleEndSeg;
	private final ModelPart Legs;
	private final ModelPart RightLeg;
	private final ModelPart RightLegMidSeg;
	private final ModelPart RightLegEndSeg;
	private final ModelPart Tumor;
	private final ModelPart LeftLeg;
	private final ModelPart LeftLegMidSeg;
	private final ModelPart LeftLegEndSeg;

	public ReaperModel(ModelPart root) {
		this.Reaper = root.getChild("Reaper");
		this.Body = this.Reaper.getChild("Body");
		this.TorsoHead = this.Body.getChild("TorsoHead");
		this.Torso = this.TorsoHead.getChild("Torso");
		this.Details = this.Torso.getChild("Details");
		this.BackLegs = this.Details.getChild("BackLegs");
		this.TumourousBackLeg = this.BackLegs.getChild("TumourousBackLeg");
		this.BLTumours = this.TumourousBackLeg.getChild("BLTumours");
		this.TumorClump2 = this.BLTumours.getChild("TumorClump2");
		this.Tumor4 = this.BLTumours.getChild("Tumor4");
		this.BackLeg = this.BackLegs.getChild("BackLeg");
		this.SecondaryBackLeg = this.BackLegs.getChild("SecondaryBackLeg");
		this.Tumor3 = this.SecondaryBackLeg.getChild("Tumor3");
		this.WeakenedLimbs = this.Details.getChild("WeakenedLimbs");
		this.RightLimb = this.WeakenedLimbs.getChild("RightLimb");
		this.LeftLimb = this.WeakenedLimbs.getChild("LeftLimb");
		this.Tendrils = this.Details.getChild("Tendrils");
		this.Tendril2 = this.Tendrils.getChild("Tendril2");
		this.T2 = this.Tendril2.getChild("T2");
		this.Tendril3 = this.Tendrils.getChild("Tendril3");
		this.T3 = this.Tendril3.getChild("T3");
		this.Tendril4 = this.Tendrils.getChild("Tendril4");
		this.T4 = this.Tendril4.getChild("T4");
		this.Tendril5 = this.Tendrils.getChild("Tendril5");
		this.Tendril = this.Tendrils.getChild("Tendril");
		this.T = this.Tendril.getChild("T");
		this.Tumor2 = this.Details.getChild("Tumor2");
		this.TumorClump = this.Details.getChild("TumorClump");
		this.Head = this.TorsoHead.getChild("Head");
		this.HeadTop = this.Head.getChild("HeadTop");
		this.PetalCrown = this.HeadTop.getChild("PetalCrown");
		this.Nose = this.Head.getChild("Nose");
		this.Jaw = this.Head.getChild("Jaw");
		this.Tumor5 = this.Head.getChild("Tumor5");
		this.headwear = this.Head.getChild("headwear");
		this.Arms = this.Body.getChild("Arms");
		this.LeftArm = this.Arms.getChild("LeftArm");
		this.LeftArmMidSeg = this.LeftArm.getChild("LeftArmMidSeg");
		this.Tumor6 = this.LeftArmMidSeg.getChild("Tumor6");
		this.LeftSickle = this.LeftArmMidSeg.getChild("LeftSickle");
		this.LeftSickleEndSeg = this.LeftSickle.getChild("LeftSickleEndSeg");
		this.RightArm = this.Arms.getChild("RightArm");
		this.TumorClump3 = this.RightArm.getChild("TumorClump3");
		this.RightArmMidSeg = this.RightArm.getChild("RightArmMidSeg");
		this.RightSickle = this.RightArmMidSeg.getChild("RightSickle");
		this.RightSickleEndSeg = this.RightSickle.getChild("RightSickleEndSeg");
		this.Legs = this.Reaper.getChild("Legs");
		this.RightLeg = this.Legs.getChild("RightLeg");
		this.RightLegMidSeg = this.RightLeg.getChild("RightLegMidSeg");
		this.RightLegEndSeg = this.RightLegMidSeg.getChild("RightLegEndSeg");
		this.Tumor = this.RightLegEndSeg.getChild("Tumor");
		this.LeftLeg = this.Legs.getChild("LeftLeg");
		this.LeftLegMidSeg = this.LeftLeg.getChild("LeftLegMidSeg");
		this.LeftLegEndSeg = this.LeftLegMidSeg.getChild("LeftLegEndSeg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Reaper = partdefinition.addOrReplaceChild("Reaper", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -2.0F));

		PartDefinition Body = Reaper.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offset(-1.0F, -22.3F, 8.1F));

		PartDefinition TorsoHead = Body.addOrReplaceChild("TorsoHead", CubeListBuilder.create(), PartPose.offset(0.0F, 0.9F, -1.4F));

		PartDefinition Torso = TorsoHead.addOrReplaceChild("Torso", CubeListBuilder.create(), PartPose.offset(0.2F, -9.2F, -7.4F));

		PartDefinition BackNeckLump_r1 = Torso.addOrReplaceChild("BackNeckLump_r1", CubeListBuilder.create().texOffs(38, 64).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -2.3F, 3.7F, -0.4016F, 0.0321F, -0.0136F));

		PartDefinition FrontNeckLump_r1 = Torso.addOrReplaceChild("FrontNeckLump_r1", CubeListBuilder.create().texOffs(38, 64).addBox(-2.0F, -4.0F, -1.0F, 6.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5F, -1.6F, 2.2F, 0.2267F, 0.0321F, -0.0136F));

		PartDefinition BodyBack_r1 = Torso.addOrReplaceChild("BodyBack_r1", CubeListBuilder.create().texOffs(0, 26).addBox(-4.0F, -0.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.5F, -3.6F, 3.2F, 0.6278F, 0.0238F, -0.0467F));

		PartDefinition BodyLeft_r1 = Torso.addOrReplaceChild("BodyLeft_r1", CubeListBuilder.create().texOffs(24, 10).addBox(-4.0F, -0.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(4.7F, -2.4F, 0.8F, 0.5487F, 0.0653F, 0.2505F));

		PartDefinition BodyRight_r1 = Torso.addOrReplaceChild("BodyRight_r1", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, -0.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.6F, -2.2F, 1.5F, 0.5485F, -0.1844F, -0.1756F));

		PartDefinition Details = Torso.addOrReplaceChild("Details", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Petal_r1 = Details.addOrReplaceChild("Petal_r1", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4F, 3.8F, 8.5F, 0.0952F, 0.1434F, -0.1936F));

		PartDefinition TornClothing_r1 = Details.addOrReplaceChild("TornClothing_r1", CubeListBuilder.create().texOffs(107, 34).addBox(1.0F, -2.0F, -6.0F, 0.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, -1.1F, 6.9F, 1.4593F, -0.9039F, -1.6028F));

		PartDefinition TornClothing_r2 = Details.addOrReplaceChild("TornClothing_r2", CubeListBuilder.create().texOffs(107, 34).addBox(1.0F, -2.0F, -6.0F, 0.0F, 14.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.6F, 0.2F, 4.0F, 0.2382F, 0.7767F, 0.116F));

		PartDefinition TornClothing_r3 = Details.addOrReplaceChild("TornClothing_r3", CubeListBuilder.create().texOffs(100, 59).addBox(-5.0F, -2.0F, -1.0F, 10.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.496F, 0.1724F, 0.085F));

		PartDefinition BackLegs = Details.addOrReplaceChild("BackLegs", CubeListBuilder.create(), PartPose.offset(-0.2F, 30.6F, 1.7F));

		PartDefinition TumourousBackLeg = BackLegs.addOrReplaceChild("TumourousBackLeg", CubeListBuilder.create(), PartPose.offset(-4.6F, -24.3F, 5.5F));

		PartDefinition LegSeg_r1 = TumourousBackLeg.addOrReplaceChild("LegSeg_r1", CubeListBuilder.create().texOffs(66, 51).addBox(-2.0F, -1.2781F, -1.2041F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1359F, 0.3958F, 0.3146F));

		PartDefinition BLTumours = TumourousBackLeg.addOrReplaceChild("BLTumours", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 3.3F, 0.5F, 0.4363F, 0.0F, 0.0F));

		PartDefinition LegSeg_r2 = BLTumours.addOrReplaceChild("LegSeg_r2", CubeListBuilder.create().texOffs(22, 83).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, 5.5F, 3.8F, -0.4368F, 0.0964F, -0.0664F));

		PartDefinition LegSeg_r3 = BLTumours.addOrReplaceChild("LegSeg_r3", CubeListBuilder.create().texOffs(0, 75).addBox(-1.0F, -2.0F, 1.0F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 4.2F, -2.7F, 0.1928F, -0.1034F, -0.0164F));

		PartDefinition TumorClump2 = BLTumours.addOrReplaceChild("TumorClump2", CubeListBuilder.create(), PartPose.offset(-2.4154F, -1.421F, 0.4334F));

		PartDefinition cube_r1 = TumorClump2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(1.3154F, 3.521F, -1.6334F, 0.0726F, -0.19F, 0.0372F));

		PartDefinition cube_r2 = TumorClump2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(2.4154F, 1.421F, -0.4334F, 0.1096F, -0.1016F, -0.1989F));

		PartDefinition Tumor4 = BLTumours.addOrReplaceChild("Tumor4", CubeListBuilder.create(), PartPose.offset(-1.5312F, 6.556F, 3.1432F));

		PartDefinition cube_r3 = Tumor4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(0.5312F, 1.544F, -2.8432F, -0.4364F, 0.5339F, -0.2936F));

		PartDefinition BackLeg = BackLegs.addOrReplaceChild("BackLeg", CubeListBuilder.create(), PartPose.offset(6.4F, -27.9F, 6.8F));

		PartDefinition LegSeg_r4 = BackLeg.addOrReplaceChild("LegSeg_r4", CubeListBuilder.create().texOffs(12, 83).addBox(-2.8902F, 0.121F, -1.7019F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 3.5F, 8.1F, -0.1321F, 0.0453F, -0.195F));

		PartDefinition cube_r4 = BackLeg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 4.7F, 5.9F, -0.1513F, 0.0969F, 0.2999F));

		PartDefinition cube_r5 = BackLeg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3F, 3.4F, 7.4F, -0.1156F, 0.0839F, 0.1305F));

		PartDefinition LegSeg_r5 = BackLeg.addOrReplaceChild("LegSeg_r5", CubeListBuilder.create().texOffs(72, 30).addBox(0.1258F, -1.358F, 0.8983F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, 7.3F, 1.7F, 0.6458F, 0.0F, -0.5236F));

		PartDefinition LegSeg_r6 = BackLeg.addOrReplaceChild("LegSeg_r6", CubeListBuilder.create().texOffs(58, 64).addBox(-2.8333F, 0.1015F, -2.5388F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4189F, 0.0F, -0.5236F));

		PartDefinition SecondaryBackLeg = BackLegs.addOrReplaceChild("SecondaryBackLeg", CubeListBuilder.create(), PartPose.offset(6.2F, -23.5F, 3.2F));

		PartDefinition LegSeg_r7 = SecondaryBackLeg.addOrReplaceChild("LegSeg_r7", CubeListBuilder.create().texOffs(56, 83).addBox(-2.0F, -0.612F, -1.098F, 3.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.6F, 3.8F, 3.4F, -0.2773F, 0.043F, -0.192F));

		PartDefinition LegSeg_r8 = SecondaryBackLeg.addOrReplaceChild("LegSeg_r8", CubeListBuilder.create().texOffs(56, 75).addBox(-1.0F, -1.819F, -1.0536F, 3.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3F, 5.8F, -0.3F, 0.2866F, 0.3418F, -0.8374F));

		PartDefinition LegSeg_r9 = SecondaryBackLeg.addOrReplaceChild("LegSeg_r9", CubeListBuilder.create().texOffs(66, 40).addBox(-2.0F, -0.5585F, -1.7353F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2466F, -0.3208F, -0.7105F));

		PartDefinition Tumor3 = SecondaryBackLeg.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offset(4.5833F, 2.7211F, -1.8464F));

		PartDefinition cube_r6 = Tumor3.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.1F)), PartPose.offsetAndRotation(-0.9833F, 2.9789F, -0.9536F, 0.5792F, 0.7619F, 0.6988F));

		PartDefinition WeakenedLimbs = Details.addOrReplaceChild("WeakenedLimbs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightLimb = WeakenedLimbs.addOrReplaceChild("RightLimb", CubeListBuilder.create(), PartPose.offset(-2.2523F, -0.9689F, 6.6685F));

		PartDefinition WeakenedLimb_r1 = RightLimb.addOrReplaceChild("WeakenedLimb_r1", CubeListBuilder.create().texOffs(44, 72).addBox(-1.7F, 0.4F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.1523F, -1.4311F, 0.4315F, 0.0518F, 0.2768F, 0.3995F));

		PartDefinition LeftLimb = WeakenedLimbs.addOrReplaceChild("LeftLimb", CubeListBuilder.create(), PartPose.offset(8.0351F, 0.3038F, 1.5757F));

		PartDefinition WeakenedLimb_r2 = LeftLimb.addOrReplaceChild("WeakenedLimb_r2", CubeListBuilder.create().texOffs(70, 0).addBox(-1.7F, 0.4F, -2.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.7649F, -0.8038F, 0.6243F, -0.1198F, 0.0722F, -0.0974F));

		PartDefinition Tendrils = Details.addOrReplaceChild("Tendrils", CubeListBuilder.create(), PartPose.offset(-0.2F, 30.6F, 1.7F));

		PartDefinition Tendril2 = Tendrils.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -26.3F, 8.7F, -0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r7 = Tendril2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(92, 0).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3478F, 0.0627F, -0.1341F));

		PartDefinition T2 = Tendril2.addOrReplaceChild("T2", CubeListBuilder.create().texOffs(28, 93).addBox(-0.5F, -6.0F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.65F, -5.45F, 1.95F));

		PartDefinition Tendril3 = Tendrils.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offset(2.0F, -28.7F, 6.2F));

		PartDefinition cube_r8 = Tendril3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(88, 29).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1675F, 0.178F, -0.1133F));

		PartDefinition T3 = Tendril3.addOrReplaceChild("T3", CubeListBuilder.create().texOffs(24, 93).addBox(-0.5F, -6.25F, -0.5F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6F, -5.75F, 1.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Tendril4 = Tendrils.addOrReplaceChild("Tendril4", CubeListBuilder.create(), PartPose.offset(-2.0F, -28.7F, 3.0F));

		PartDefinition cube_r9 = Tendril4.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(84, 86).addBox(-1.0F, -7.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.062F, 0.1356F, -0.3496F));

		PartDefinition T4 = Tendril4.addOrReplaceChild("T4", CubeListBuilder.create().texOffs(20, 93).addBox(-0.75F, -7.75F, -0.5F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -5.7F, 0.45F, 0.0F, 0.0F, -0.2618F));

		PartDefinition Tendril5 = Tendrils.addOrReplaceChild("Tendril5", CubeListBuilder.create(), PartPose.offset(6.6F, -31.3F, 0.9F));

		PartDefinition cube_r10 = Tendril5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 53).addBox(0.0F, -9.0F, -1.0F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4F, -7.4F, 1.9F, -0.1592F, -0.0697F, 0.6052F));

		PartDefinition cube_r11 = Tendril5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(66, 83).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2287F, -0.1282F, 0.0656F));

		PartDefinition Tendril = Tendrils.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offset(4.3F, -26.1F, 8.4F));

		PartDefinition cube_r12 = Tendril.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(74, 92).addBox(-1.0F, -6.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1596F, -0.1598F, 0.2197F));

		PartDefinition T = Tendril.addOrReplaceChild("T", CubeListBuilder.create().texOffs(32, 93).addBox(-0.5F, -4.75F, -1.0F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -5.65F, 1.3F, -0.3295F, 0.1172F, 0.3295F));

		PartDefinition Tumor2 = Details.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offset(5.2889F, -0.8425F, 6.6459F));

		PartDefinition Tumour_r1 = Tumor2.addOrReplaceChild("Tumour_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(0.8111F, 2.3425F, -2.1459F, -0.1428F, 0.2416F, 0.089F));

		PartDefinition TumorClump = Details.addOrReplaceChild("TumorClump", CubeListBuilder.create(), PartPose.offset(1.0367F, 6.8749F, 7.9167F));

		PartDefinition Tumor_r1 = TumorClump.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-2.7408F, -1.808F, -2.4918F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.4F)), PartPose.offsetAndRotation(-1.8367F, -1.2749F, 0.7833F, 1.0292F, -0.6017F, -0.6741F));

		PartDefinition Tumor_r2 = TumorClump.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(0, 53).addBox(-2.7408F, -1.808F, -2.4918F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.75F)), PartPose.offsetAndRotation(-0.8367F, -0.2749F, -1.2167F, 0.4738F, 0.5054F, -0.1271F));

		PartDefinition Tumor_r3 = TumorClump.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(0, 53).addBox(-2.9715F, -2.049F, -2.7982F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.2F)), PartPose.offsetAndRotation(3.1633F, -0.1749F, 0.0833F, -0.4676F, 0.1287F, -0.544F));

		PartDefinition Head = TorsoHead.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(1.6F, -10.8F, -7.6F));

		PartDefinition Petal_r2 = Head.addOrReplaceChild("Petal_r2", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.302F, -6.7281F, 1.8986F, -0.0873F, 0.0174F, -0.0015F));

		PartDefinition Petal_r3 = Head.addOrReplaceChild("Petal_r3", CubeListBuilder.create().texOffs(48, 34).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8764F, -5.5547F, -7.272F, 2.6033F, -1.0056F, -2.87F));

		PartDefinition Petal_r4 = Head.addOrReplaceChild("Petal_r4", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.498F, -8.1281F, -5.3014F, 0.1222F, 0.0F, -0.1047F));

		PartDefinition HeadTop = Head.addOrReplaceChild("HeadTop", CubeListBuilder.create().texOffs(0, 0).addBox(-5.05F, 2.249F, -5.3986F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(24, 26).addBox(-5.05F, -4.751F, -5.3986F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(16, 65).addBox(-1.05F, -4.751F, -1.3986F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(104, 79).addBox(-1.05F, -4.751F, -5.3986F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(80, 26).addBox(-5.05F, 4.055F, 0.7928F, 8.0F, 1.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offset(1.052F, -4.5771F, -2.6028F));

		PartDefinition PetalCrown = HeadTop.addOrReplaceChild("PetalCrown", CubeListBuilder.create(), PartPose.offset(3.25F, -4.051F, 3.8014F));

		PartDefinition Petal_r5 = PetalCrown.addOrReplaceChild("Petal_r5", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1F, -0.8F, 2.8F, 0.1462F, 0.0839F, 0.1305F));

		PartDefinition Petal_r6 = PetalCrown.addOrReplaceChild("Petal_r6", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.7F, 0.8F, -0.0785F, 0.1719F, 0.4931F));

		PartDefinition Petal_r7 = PetalCrown.addOrReplaceChild("Petal_r7", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7F, -0.9F, -2.2F, -0.5034F, 0.1451F, 0.0967F));

		PartDefinition Petal_r8 = PetalCrown.addOrReplaceChild("Petal_r8", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1324F, 0.0535F, -0.1125F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(60, 0).addBox(-1.4F, -0.5F, -1.9F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 7).addBox(-1.7F, 0.5F, -2.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.402F, -0.9281F, -7.4014F));

		PartDefinition NoseGrowth_r1 = Nose.addOrReplaceChild("NoseGrowth_r1", CubeListBuilder.create().texOffs(92, 86).addBox(-1.0F, 0.6F, -0.9F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 1.0F, -1.3F, 0.0138F, -0.1565F, -0.0883F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -0.5782F, -5.9578F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F))
		.texOffs(38, 41).addBox(-4.0F, -1.3782F, -5.9578F, 8.0F, 1.0F, 6.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.002F, -0.0781F, -1.1514F, 0.5411F, 0.0F, 0.0F));

		PartDefinition Tumor5 = Head.addOrReplaceChild("Tumor5", CubeListBuilder.create(), PartPose.offset(3.8005F, -1.6951F, 0.3153F));

		PartDefinition NeckTumour_r1 = Tumor5.addOrReplaceChild("NeckTumour_r1", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.9F)), PartPose.offsetAndRotation(1.1015F, 2.5671F, -1.7167F, 0.1109F, 0.4158F, -0.0842F));

		PartDefinition headwear = Head.addOrReplaceChild("headwear", CubeListBuilder.create().texOffs(93, 116).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.51F)), PartPose.offsetAndRotation(0.4F, -5.8F, -4.35F, -0.1304F, -0.0114F, -0.0865F));

		PartDefinition headwear2_r1 = headwear.addOrReplaceChild("headwear2_r1", CubeListBuilder.create().texOffs(59, 111).addBox(-8.0F, -32.0F, -6.0F, 16.0F, 16.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.5F, -24.0F, -1.5708F, 0.0F, 0.0F));

		PartDefinition Arms = Body.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(2.0F, -8.95F, -10.9F));

		PartDefinition LeftArm = Arms.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.2F, 0.15F, 1.1F, 0.0F, -0.192F, 0.0F));

		PartDefinition ElbowClaw_r1 = LeftArm.addOrReplaceChild("ElbowClaw_r1", CubeListBuilder.create().texOffs(32, 65).addBox(1.0F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0954F, 9.3F, -5.0542F, 1.3352F, 0.0F, 0.0F));

		PartDefinition Petal_r9 = LeftArm.addOrReplaceChild("Petal_r9", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5954F, 5.7F, -1.9542F, 0.0F, 0.0F, 0.2967F));

		PartDefinition Petal_r10 = LeftArm.addOrReplaceChild("Petal_r10", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4046F, 3.5F, -1.9542F, 0.1568F, 0.0408F, 0.112F));

		PartDefinition TornClothing_r4 = LeftArm.addOrReplaceChild("TornClothing_r4", CubeListBuilder.create().texOffs(104, 22).addBox(-2.0F, -4.5F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9673F, 3.5722F, -2.5809F, -2.7403F, 0.0102F, 3.1175F));

		PartDefinition ArmSeg_r1 = LeftArm.addOrReplaceChild("ArmSeg_r1", CubeListBuilder.create().texOffs(54, 48).addBox(-0.9F, 0.4F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5954F, -1.0F, -1.0542F, -0.4014F, 0.0F, 0.0F));

		PartDefinition LeftArmMidSeg = LeftArm.addOrReplaceChild("LeftArmMidSeg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8954F, 11.8F, -5.2542F, 0.0F, 0.0873F, 0.0F));

		PartDefinition ArmSpikes_r1 = LeftArmMidSeg.addOrReplaceChild("ArmSpikes_r1", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2F, -4.7F, -5.8F, -0.576F, 0.0F, 0.0F));

		PartDefinition TornClothing_r5 = LeftArmMidSeg.addOrReplaceChild("TornClothing_r5", CubeListBuilder.create().texOffs(102, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.4F, -1.6F, -3.9F, 0.1052F, -0.2536F, -0.1737F));

		PartDefinition TornClothing_r6 = LeftArmMidSeg.addOrReplaceChild("TornClothing_r6", CubeListBuilder.create().texOffs(102, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.2F, -0.1F, -3.5F, 0.0874F, -0.0363F, 0.0776F));

		PartDefinition ArmSeg_r2 = LeftArmMidSeg.addOrReplaceChild("ArmSeg_r2", CubeListBuilder.create().texOffs(32, 72).addBox(-0.9F, -1.6F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.3F, -1.3F, -1.0F, -2.1642F, 0.0F, 0.0F));

		PartDefinition ElbowClaw_r2 = LeftArmMidSeg.addOrReplaceChild("ElbowClaw_r2", CubeListBuilder.create().texOffs(6, 92).addBox(1.0F, -2.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8F, 0.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Tumor6 = LeftArmMidSeg.addOrReplaceChild("Tumor6", CubeListBuilder.create(), PartPose.offset(0.9161F, -1.9657F, -1.1123F));

		PartDefinition Tumor_r4 = Tumor6.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.2839F, 2.6657F, -1.8877F, 0.0212F, 0.366F, 0.2295F));

		PartDefinition LeftSickle = LeftArmMidSeg.addOrReplaceChild("LeftSickle", CubeListBuilder.create(), PartPose.offset(0.2F, -5.4F, -7.8F));

		PartDefinition ArmSeg_r3 = LeftSickle.addOrReplaceChild("ArmSeg_r3", CubeListBuilder.create().texOffs(74, 70).addBox(0.1F, 3.4F, -1.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-0.9F, -4.5F, 0.4F, -0.2793F, 0.0F, 0.0F));

		PartDefinition LeftSickleEndSeg = LeftSickle.addOrReplaceChild("LeftSickleEndSeg", CubeListBuilder.create(), PartPose.offset(0.2F, 8.3779F, -2.9949F));

		PartDefinition Blade_r1 = LeftSickleEndSeg.addOrReplaceChild("Blade_r1", CubeListBuilder.create().texOffs(24, 41).addBox(0.0F, -2.0F, -3.0F, 0.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.9779F, 2.4949F, 0.3142F, 0.0F, 0.0F));

		PartDefinition SickleSeg_r1 = LeftSickleEndSeg.addOrReplaceChild("SickleSeg_r1", CubeListBuilder.create().texOffs(44, 84).addBox(0.1F, -2.4397F, -1.7942F, 2.0F, 6.0F, 3.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.1F, 1.5221F, 0.8949F, 0.3665F, 0.0F, 0.0F));

		PartDefinition RightArm = Arms.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.2F, -0.15F, 1.3F, 0.0F, 0.192F, 0.0F));

		PartDefinition ElbowClaw_r3 = RightArm.addOrReplaceChild("ElbowClaw_r3", CubeListBuilder.create().texOffs(32, 65).addBox(1.0F, 0.0F, -1.0F, 0.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2011F, 9.6F, -5.2194F, 1.3352F, 0.0F, 0.0F));

		PartDefinition Petal_r11 = RightArm.addOrReplaceChild("Petal_r11", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.1011F, 9.5F, -3.1194F, 0.0039F, 0.1915F, -0.1409F));

		PartDefinition TornClothing_r7 = RightArm.addOrReplaceChild("TornClothing_r7", CubeListBuilder.create().texOffs(104, 22).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.2255F, 0.8F, -2.5506F, -0.4014F, 0.0068F, 0.0161F));

		PartDefinition ArmSeg_r4 = RightArm.addOrReplaceChild("ArmSeg_r4", CubeListBuilder.create().texOffs(54, 48).addBox(-0.9F, 0.4F, -1.0F, 3.0F, 13.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.7011F, -0.7F, -1.2194F, -0.4014F, 0.0F, 0.0F));

		PartDefinition TumorClump3 = RightArm.addOrReplaceChild("TumorClump3", CubeListBuilder.create(), PartPose.offset(-1.3479F, 1.1071F, -2.2451F));

		PartDefinition cube_r13 = TumorClump3.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.3F)), PartPose.offsetAndRotation(2.5468F, 2.8929F, -1.8743F, -0.017F, -0.0683F, -0.2065F));

		PartDefinition cube_r14 = TumorClump3.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-1.3F)), PartPose.offsetAndRotation(1.0468F, 1.7929F, -0.8743F, 0.2187F, 0.29F, -0.1285F));

		PartDefinition RightArmMidSeg = RightArm.addOrReplaceChild("RightArmMidSeg", CubeListBuilder.create(), PartPose.offset(-1.2011F, 11.8F, -5.9194F));

		PartDefinition ArmSpikes_r2 = RightArmMidSeg.addOrReplaceChild("ArmSpikes_r2", CubeListBuilder.create().texOffs(0, 83).addBox(-1.0F, -3.0F, -2.0F, 0.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -4.4F, -5.3F, -0.576F, 0.0F, 0.0F));

		PartDefinition TornClothing_r8 = RightArmMidSeg.addOrReplaceChild("TornClothing_r8", CubeListBuilder.create().texOffs(102, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8756F, -1.5F, -8.3312F, 0.0F, 0.0F, -0.1047F));

		PartDefinition TornClothing_r9 = RightArmMidSeg.addOrReplaceChild("TornClothing_r9", CubeListBuilder.create().texOffs(102, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3244F, -1.1F, -4.3312F, -0.0364F, -0.1348F, 0.2643F));

		PartDefinition TornClothing_r10 = RightArmMidSeg.addOrReplaceChild("TornClothing_r10", CubeListBuilder.create().texOffs(102, 40).addBox(-1.0F, -2.0F, -2.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4244F, 0.2F, -1.7312F, 0.1021F, -0.0235F, 0.2257F));

		PartDefinition ArmSeg_r5 = RightArmMidSeg.addOrReplaceChild("ArmSeg_r5", CubeListBuilder.create().texOffs(32, 72).addBox(-0.9F, -1.6F, -1.0F, 3.0F, 10.0F, 3.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-0.5F, -1.0F, -0.5F, -2.1642F, 0.0F, 0.0F));

		PartDefinition ElbowClaw_r4 = RightArmMidSeg.addOrReplaceChild("ElbowClaw_r4", CubeListBuilder.create().texOffs(6, 92).addBox(1.0F, -2.0F, -1.0F, 0.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.3F, 0.5F, 0.7418F, 0.0F, 0.0F));

		PartDefinition RightSickle = RightArmMidSeg.addOrReplaceChild("RightSickle", CubeListBuilder.create(), PartPose.offset(0.1F, -4.4F, -6.9F));

		PartDefinition ArmSeg_r6 = RightSickle.addOrReplaceChild("ArmSeg_r6", CubeListBuilder.create().texOffs(74, 70).addBox(0.1F, 3.4F, -1.0F, 2.0F, 11.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(-1.0F, -5.2F, 0.0F, -0.2793F, 0.0F, 0.0F));

		PartDefinition RightSickleEndSeg = RightSickle.addOrReplaceChild("RightSickleEndSeg", CubeListBuilder.create(), PartPose.offset(0.1F, 7.7779F, -3.3949F));

		PartDefinition Blade_r2 = RightSickleEndSeg.addOrReplaceChild("Blade_r2", CubeListBuilder.create().texOffs(24, 41).addBox(0.0F, -2.0F, -3.0F, 0.0F, 17.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0779F, 2.4949F, 0.3142F, 0.0F, 0.0F));

		PartDefinition SickleSeg_r2 = RightSickleEndSeg.addOrReplaceChild("SickleSeg_r2", CubeListBuilder.create().texOffs(44, 84).addBox(0.1F, -2.4397F, -1.7942F, 2.0F, 6.0F, 3.0F, new CubeDeformation(-0.7F)), PartPose.offsetAndRotation(-1.1F, 1.4221F, 0.8949F, 0.3665F, 0.0F, 0.0F));

		PartDefinition Legs = Reaper.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.2353F, -22.5072F, 4.9723F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-4.2F, 0.0F, -1.0F));

		PartDefinition Petal_r12 = RightLeg.addOrReplaceChild("Petal_r12", CubeListBuilder.create().texOffs(48, 34).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6277F, 9.5297F, -4.9146F, 0.5042F, -0.7563F, -0.5026F));

		PartDefinition Petal_r13 = RightLeg.addOrReplaceChild("Petal_r13", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.1353F, 7.5072F, -1.7723F, 0.2104F, 0.21F, -0.0605F));

		PartDefinition TornClothing_r11 = RightLeg.addOrReplaceChild("TornClothing_r11", CubeListBuilder.create().texOffs(90, 58).addBox(-3.472F, -4.1694F, 0.3497F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0353F, 11.7072F, -4.9723F, -0.1477F, 0.0535F, 0.3451F));

		PartDefinition TornClothing_r12 = RightLeg.addOrReplaceChild("TornClothing_r12", CubeListBuilder.create().texOffs(90, 13).addBox(2.7251F, -4.6601F, -0.0537F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0353F, 11.7072F, -4.9723F, -0.1552F, -0.0245F, -0.1552F));

		PartDefinition TornClothing_r13 = RightLeg.addOrReplaceChild("TornClothing_r13", CubeListBuilder.create().texOffs(0, 63).addBox(-2.0F, -12.5909F, -1.4688F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(48, 18).addBox(-2.0F, -12.5909F, -1.4688F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0353F, 11.7072F, -4.9723F, -0.4712F, 0.0F, 0.0F));

		PartDefinition RightLegMidSeg = RightLeg.addOrReplaceChild("RightLegMidSeg", CubeListBuilder.create(), PartPose.offset(0.0571F, 11.1873F, -3.7185F));

		PartDefinition KneeClaw_r1 = RightLegMidSeg.addOrReplaceChild("KneeClaw_r1", CubeListBuilder.create().texOffs(82, 38).addBox(-1.0F, -4.0F, -1.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2076F, 1.2199F, 7.6461F, 0.3665F, 0.0F, 0.0F));

		PartDefinition LegSeg_r10 = RightLegMidSeg.addOrReplaceChild("LegSeg_r10", CubeListBuilder.create().texOffs(0, 42).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5924F, 1.1199F, 0.8461F, 0.1571F, 0.0F, 0.0F));

		PartDefinition RightLegEndSeg = RightLegMidSeg.addOrReplaceChild("RightLegEndSeg", CubeListBuilder.create().texOffs(74, 84).addBox(0.8228F, 7.2691F, -6.314F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(84, 70).addBox(-0.7772F, 7.2691F, -6.314F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1152F, 1.0508F, 6.4601F));

		PartDefinition ToeClawdrool_r1 = RightLegEndSeg.addOrReplaceChild("ToeClawdrool_r1", CubeListBuilder.create().texOffs(92, 92).addBox(-1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5772F, 10.2691F, -2.314F, 0.0F, 0.3665F, 0.0F));

		PartDefinition Petal_r14 = RightLegEndSeg.addOrReplaceChild("Petal_r14", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9772F, 4.7691F, 0.886F, -0.2661F, -0.1144F, -0.1238F));

		PartDefinition LegSeg_r11 = RightLegEndSeg.addOrReplaceChild("LegSeg_r11", CubeListBuilder.create().texOffs(80, 13).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 11.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.5228F, 1.3691F, 0.886F, -0.1396F, 0.0F, 0.0F));

		PartDefinition Tumor = RightLegEndSeg.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(-0.3474F, 0.522F, 0.6112F));

		PartDefinition Tumor_r5 = Tumor.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(0, 53).addBox(-4.0F, -5.0F, -1.0F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(1.0701F, 1.6471F, -2.6252F, -0.2994F, 0.5042F, -0.4409F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(4.2F, 0.0F, 0.0F));

		PartDefinition Petal_r15 = LeftLeg.addOrReplaceChild("Petal_r15", CubeListBuilder.create().texOffs(48, 34).addBox(-1.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3353F, 7.8072F, -2.3723F, 0.0349F, 0.1222F, 0.192F));

		PartDefinition TornClothing_r14 = LeftLeg.addOrReplaceChild("TornClothing_r14", CubeListBuilder.create().texOffs(0, 92).addBox(0.8519F, -0.5668F, -1.3519F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2353F, 7.3072F, -3.5723F, -0.1604F, -0.2659F, 0.2191F));

		PartDefinition TornClothing_r15 = LeftLeg.addOrReplaceChild("TornClothing_r15", CubeListBuilder.create().texOffs(64, 18).addBox(-2.0F, -12.5909F, -1.4688F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.2F))
		.texOffs(38, 48).addBox(-2.0F, -12.5909F, -1.4688F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0353F, 11.7072F, -4.9723F, -0.4712F, 0.0F, 0.0F));

		PartDefinition LeftLegMidSeg = LeftLeg.addOrReplaceChild("LeftLegMidSeg", CubeListBuilder.create(), PartPose.offset(0.0686F, 11.1459F, -3.6964F));

		PartDefinition KneeClaw_r2 = LeftLegMidSeg.addOrReplaceChild("KneeClaw_r2", CubeListBuilder.create().texOffs(82, 48).addBox(-1.0F, -4.0F, -1.0F, 0.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1961F, 1.2613F, 7.6241F, 0.3665F, 0.0F, 0.0F));

		PartDefinition LegSeg_r12 = LeftLegMidSeg.addOrReplaceChild("LegSeg_r12", CubeListBuilder.create().texOffs(48, 7).addBox(-1.0F, -2.0F, -2.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6039F, 1.1613F, 0.8241F, 0.1571F, 0.0F, 0.0F));

		PartDefinition LeftLegEndSeg = LeftLegMidSeg.addOrReplaceChild("LeftLegEndSeg", CubeListBuilder.create().texOffs(84, 78).addBox(-0.8119F, 7.3933F, -6.3802F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(32, 85).addBox(0.7881F, 7.3933F, -6.3802F, 0.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.0921F, 0.968F, 6.5043F));

		PartDefinition ToeClawdrool_r2 = LeftLegEndSeg.addOrReplaceChild("ToeClawdrool_r2", CubeListBuilder.create().texOffs(12, 93).addBox(-1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1881F, 10.3933F, -2.2802F, 0.0F, -0.384F, 0.0F));

		PartDefinition LegSeg_r13 = LeftLegEndSeg.addOrReplaceChild("LegSeg_r13", CubeListBuilder.create().texOffs(82, 0).addBox(-2.0F, -2.0F, -2.0F, 3.0F, 11.0F, 2.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.4881F, 1.4933F, 0.8198F, -0.1396F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	public void moveZ(ModelPart part,float val){
		part.z = part.getInitialPose().z+val;
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float val = Mth.cos(limbSwing * 0.5f) * 0.5f * limbSwingAmount;
		float rangedAttackAnimationTick = entity.getAttackAnimationTick();
		float spitAttackAnimationTick = entity.getRangedAttackAnimationTick();
		float r1 = Mth.sin(ageInTicks/6)/8;
		float r2 = Mth.cos(ageInTicks/7)/6;
		float r3 = Mth.sin(ageInTicks/8)/5;
		float r4 = Mth.cos(ageInTicks/9)/4;
		float r5 = Mth.cos(ageInTicks/4)/5;
		float r6 = Mth.cos(ageInTicks/5)/7;
		float r7 = Mth.cos(ageInTicks/6)/5;
		float r8 = Mth.cos(ageInTicks/7)/4;
		animateTentacleX(RightLeg,val);
		animateTentacleX(LeftLeg,-val);
		animateTentacleX(RightLegMidSeg,val*1.5f);
		animateTentacleX(LeftLegMidSeg,-val*1.5f);
		animateTentacleX(RightLegEndSeg,RightLeg.xRot > 0 ? -RightLeg.xRot : 0);
		animateTentacleX(LeftLegEndSeg,LeftLeg.xRot > 0 ? -LeftLeg.xRot : 0);
		moveZ(RightLeg,-val * 3);
		moveZ(LeftLeg,val * 3);
		if (rangedAttackAnimationTick > 0){
			float swing = -2.0F + 1.5F * Mth.triangleWave(rangedAttackAnimationTick, 20.0F);
			animateTentacleX(LeftArm,swing);
			animateTentacleX(RightArm,swing);
			animateTentacleX(LeftArmMidSeg,-swing);
			animateTentacleX(RightArmMidSeg,-swing);
			animateTentacleX(LeftSickle,swing);
			animateTentacleX(RightSickle,swing);
		}else {
			animateTentacleX(LeftArm,r1);
			animateTentacleX(RightArm,r2);
			animateTentacleX(LeftArmMidSeg,r1);
			animateTentacleX(RightArmMidSeg,r3);
			animateTentacleX(LeftSickle,r2);
			animateTentacleX(RightSickle,r4);
		}
		if (spitAttackAnimationTick > 0){
			float swing = -2.0F + 1.5F * Mth.triangleWave(spitAttackAnimationTick, 20.0F);
			this.Head.xRot = swing/2;
			animateTentacleX(Jaw,-swing/2);
		}else {
			this.Head.xRot = headPitch / (90F / (float) Math.PI);
			animateTentacleX(Jaw,r2);
		}
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		animateTumor(Tumor,r4);
		animateTumor(Tumor2,r5);
		animateTumor(Tumor3,r4);
		animateTumor(Tumor4,r7);
		animateTumor(Tumor5,r8);
		animateTumor(Tumor6,r3);
		animateTumor(TumorClump,r2);
		animateTumor(TumorClump2,r8);
		animateTumor(TumorClump3,r7);
		animateTentacleX(TumourousBackLeg,r4);
		animateTentacleX(SecondaryBackLeg,r8);
		animateTentacleX(BackLeg,r1);
		animateTentacleZ(Tendril,r3);
		animateTentacleY(Tendril,r4);
		animateTentacleZ(T,r6);
		animateTentacleZ(Tendril2,r8);
		animateTentacleX(Tendril2,r7);
		animateTentacleZ(T2,r4);
		animateTentacleZ(Tendril3,r3);
		animateTentacleY(Tendril3,r5);
		animateTentacleZ(T3,r2);
		animateTentacleZ(Tendril4,r6);
		animateTentacleY(Tendril4,r7);
		animateTentacleZ(T4,r5);
		animateTentacleZ(Tendril5,r6);
		animateTentacleY(Tendril5,r7);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float r, float g, float b, float alpha) {
		Reaper.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}