package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.Harbinger.Spore.Client.Animations.WendigoAnimations;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import com.Harbinger.Spore.Spore;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WendigoModel<T extends Wendigo> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "wendigo"), "main");
	private final ModelPart wendys;
	private final ModelPart Base;
	private final ModelPart Abdomen;
	private final ModelPart Head;
	private final ModelPart Jaw;
	private final ModelPart RightArm;
	private final ModelPart LeftArm;
	private final ModelPart RightForArm;
	private final ModelPart LeftForArm;
	private final ModelPart RightLeg;
	private final ModelPart LeftLeg;
	private final ModelPart Tumor1;

	public WendigoModel(ModelPart root) {
		this.wendys = root.getChild("wendys");
		this.Base = wendys.getChild("Base");
		this.Abdomen = Base.getChild("TorsoBase").getChild("TorsoMiddle");
		this.Head = Abdomen.getChild("TorsoTop").getChild("Head");
		this.Jaw = Head.getChild("Jaw");
		this.RightArm = Abdomen.getChild("TorsoTop").getChild("Arms").getChild("ArmRight");
		this.LeftArm = Abdomen.getChild("TorsoTop").getChild("Arms").getChild("ArmLeft");
		this.RightForArm = RightArm.getChild("ArmRightSeg2");
		this.LeftForArm = LeftArm.getChild("ArmLeftSeg2");
		this.RightLeg = Base.getChild("Legs").getChild("RightLeg");
		this.LeftLeg = Base.getChild("Legs").getChild("LeftLeg");
		this.Tumor1 = LeftLeg.getChild("LeftLegSeg1").getChild("LeftLegBase").getChild("LeftLegBaseTumor");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wendys = partdefinition.addOrReplaceChild("wendys", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 1.0F));

		PartDefinition Base = wendys.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(0.0F, -26.0F, 0.0F));

		PartDefinition TorsoBase = Base.addOrReplaceChild("TorsoBase", CubeListBuilder.create().texOffs(0, 29).addBox(-5.0F, -7.0F, -2.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition TorsoTumor = TorsoBase.addOrReplaceChild("TorsoTumor", CubeListBuilder.create(), PartPose.offset(-1.5F, 0.0F, 0.0F));

		PartDefinition Tumor_r1 = TorsoTumor.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(3, 45).addBox(-2.5F, -1.5F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0426F, 0.1874F, -0.683F, -0.9136F, -0.5484F, 0.2015F));

		PartDefinition Tumor_r2 = TorsoTumor.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(0, 43).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 1.0F, 0.5236F, 0.0F, -0.3927F));

		PartDefinition BaseSpine = TorsoBase.addOrReplaceChild("BaseSpine", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Spine_r1 = BaseSpine.addOrReplaceChild("Spine_r1", CubeListBuilder.create().texOffs(15, 33).addBox(-1.0F, -3.5F, -1.0F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -3.5F, 4.5F, -0.1309F, 0.0F, 0.1309F));

		PartDefinition TorsoMiddle = TorsoBase.addOrReplaceChild("TorsoMiddle", CubeListBuilder.create().texOffs(0, 15).addBox(-5.99F, -9.0F, -3.0F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -4.05F, 0.55F, 0.1745F, 0.0F, 0.0F));

		PartDefinition MiddleRibs = TorsoMiddle.addOrReplaceChild("MiddleRibs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.75F, 0.0F));

		PartDefinition Fungus_r1 = MiddleRibs.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(39, 0).addBox(-4.5F, -1.0F, -2.75F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -7.0F, 3.5F, 0.0F, 0.4363F, 0.4363F));

		PartDefinition Rib1 = MiddleRibs.addOrReplaceChild("Rib1", CubeListBuilder.create().texOffs(15, 16).addBox(-6.5F, -6.0F, -3.5F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(19, 23).addBox(-5.5F, -6.0F, -3.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(2, 25).addBox(-5.5F, -6.0F, 3.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition Rib2 = MiddleRibs.addOrReplaceChild("Rib2", CubeListBuilder.create().texOffs(1, 17).addBox(0.75F, -1.0F, -2.25F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(3, 25).addBox(-3.25F, -1.0F, -2.25F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 17).addBox(-3.25F, -1.0F, 4.75F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -5.0F, -1.25F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Rib3 = MiddleRibs.addOrReplaceChild("Rib3", CubeListBuilder.create().texOffs(3, 18).addBox(-2.5F, -1.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(10, 22).addBox(-1.5F, -1.0F, -4.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 24).addBox(-1.5F, -1.0F, 3.0F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.75F, -6.75F, 0.5F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Spine = MiddleRibs.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offset(0.0F, -7.0F, 4.0F));

		PartDefinition Spine_r2 = Spine.addOrReplaceChild("Spine_r2", CubeListBuilder.create().texOffs(14, 17).addBox(-0.75F, -4.0F, 0.0F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 1.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition TorsoTop = TorsoMiddle.addOrReplaceChild("TorsoTop", CubeListBuilder.create().texOffs(0, 0).addBox(-6.99F, -6.0F, -4.0F, 12.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -9.0F, 0.5F));

		PartDefinition TopRibs = TorsoTop.addOrReplaceChild("TopRibs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Rib4 = TopRibs.addOrReplaceChild("Rib4", CubeListBuilder.create().texOffs(5, 2).addBox(2.0F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(9, 5).addBox(-4.0F, -1.0F, -4.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 9).addBox(-3.0F, -1.0F, 3.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition Rib5 = TopRibs.addOrReplaceChild("Rib5", CubeListBuilder.create().texOffs(13, 3).addBox(2.0F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(17, 11).addBox(-4.0F, -1.0F, -4.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(11, 5).addBox(-4.0F, -1.0F, 3.5F, 6.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

		PartDefinition Rib6 = TopRibs.addOrReplaceChild("Rib6", CubeListBuilder.create().texOffs(7, 2).addBox(-3.0F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(13, 11).addBox(-2.0F, -1.0F, -4.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(6, 11).addBox(-2.0F, -1.0F, 3.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.35F, -1.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

		PartDefinition Rib7 = TopRibs.addOrReplaceChild("Rib7", CubeListBuilder.create().texOffs(13, 1).addBox(-3.0F, -1.0F, -4.5F, 1.0F, 2.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(14, 22).addBox(-2.0F, -1.0F, -4.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(19, 11).addBox(-2.0F, -1.0F, 3.5F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.35F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition SpineTop = TopRibs.addOrReplaceChild("SpineTop", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Spine_r3 = SpineTop.addOrReplaceChild("Spine_r3", CubeListBuilder.create().texOffs(23, 3).addBox(-1.0F, -3.5F, -0.5F, 2.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, -2.5F, 4.5F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Head = TorsoTop.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 21).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(74, 37).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, -3.0F));

		PartDefinition Face = Head.addOrReplaceChild("Face", CubeListBuilder.create(), PartPose.offset(-0.375F, -6.375F, -3.5F));

		PartDefinition Fangs = Face.addOrReplaceChild("Fangs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -0.25F));

		PartDefinition Fang3Seg2_r1 = Fangs.addOrReplaceChild("Fang3Seg2_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, 1.4881F, -0.8918F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.7095F, 4.4406F, 0.1251F, 0.0072F, -0.056F, -0.2559F));

		PartDefinition Fang3_r1 = Fangs.addOrReplaceChild("Fang3_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, -0.5119F, 0.1082F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, 4.4881F, -0.3582F, -0.3419F, -0.056F, -0.2559F));

		PartDefinition Fang2Seg2_r1 = Fangs.addOrReplaceChild("Fang2Seg2_r1", CubeListBuilder.create().texOffs(6, -1).addBox(-1.0F, 1.7322F, -0.6623F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7745F, 4.3601F, 1.5215F, 0.2706F, -0.235F, 0.0761F));

		PartDefinition Fang2_r1 = Fangs.addOrReplaceChild("Fang2_r1", CubeListBuilder.create().texOffs(6, -1).addBox(0.0F, -0.2678F, -0.6623F, 0.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, 4.4016F, 1.4309F, 0.1876F, -0.3049F, 0.3848F));

		PartDefinition Fang1Seg2_r1 = Fangs.addOrReplaceChild("Fang1Seg2_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, 1.5F, -1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 4.2497F, -0.0494F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Fang1_r1 = Fangs.addOrReplaceChild("Fang1_r1", CubeListBuilder.create().texOffs(6, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5F, 4.5F, -0.25F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Jaw = Head.addOrReplaceChild("Jaw", CubeListBuilder.create().texOffs(83, 20).addBox(0.0F, -1.0F, -4.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(85, 26).addBox(-4.0F, -1.0F, -4.0F, 4.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.7418F, 0.0F, 0.0F));

		PartDefinition Fang3_r2 = Jaw.addOrReplaceChild("Fang3_r2", CubeListBuilder.create().texOffs(6, 0).addBox(4.0F, -1.5F, 1.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.875F, -0.875F, -4.75F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Teeth_r1 = Jaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(6, 1).addBox(0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9031F, -2.4234F, -3.3529F, 0.1186F, 0.1836F, 0.5782F));

		PartDefinition Teeth_r2 = Jaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(1, 3).addBox(-0.25F, -0.5F, -1.5F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.9666F, -1.4541F, -2.3427F, 0.0573F, 0.2106F, 0.2679F));

		PartDefinition Teeth_r3 = Jaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(0, 2).addBox(-0.75F, -0.75F, -2.0F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0334F, -1.9541F, -2.5927F, -1.5879F, -1.2947F, 1.5886F));

		PartDefinition Teeth_r4 = Jaw.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(6, 0).addBox(0.0F, 0.0F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.8878F, -3.9554F, -3.5374F, 0.1074F, -0.2865F, -0.3646F));

		PartDefinition Teeth_r5 = Jaw.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(0, 2).addBox(0.25F, -2.0F, -1.75F, 0.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -1.0F, -2.0F, 0.0411F, -0.3027F, -0.1372F));

		PartDefinition Nose = Head.addOrReplaceChild("Nose", CubeListBuilder.create().texOffs(0, 79).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, -4.0F));

		PartDefinition Antlers = Head.addOrReplaceChild("Antlers", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition RightAntler = Antlers.addOrReplaceChild("RightAntler", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, -5.5F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition AntlerSeg5_r1 = RightAntler.addOrReplaceChild("AntlerSeg5_r1", CubeListBuilder.create().texOffs(95, 19).addBox(-4.1F, -0.75F, -0.9F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-10.3345F, -5.3329F, 0.0F, -0.2182F, 0.2618F, 0.6981F));

		PartDefinition AntlerSeg4_r1 = RightAntler.addOrReplaceChild("AntlerSeg4_r1", CubeListBuilder.create().texOffs(12, 97).addBox(-3.1F, -0.75F, -1.15F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-10.3345F, -5.3329F, 0.0F, 0.0F, -0.2618F, 0.0436F));

		PartDefinition AnterShootoff3_r1 = RightAntler.addOrReplaceChild("AnterShootoff3_r1", CubeListBuilder.create().texOffs(88, 32).addBox(-4.5F, -0.75F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.1624F, -3.8538F, 0.0F, -0.4737F, 0.0803F, 1.1151F));

		PartDefinition AntlerSeg3_r1 = RightAntler.addOrReplaceChild("AntlerSeg3_r1", CubeListBuilder.create().texOffs(12, 97).addBox(-3.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-7.1624F, -3.8538F, 0.0F, 0.0F, 0.0F, 0.4363F));

		PartDefinition AntlerSeg2_r1 = RightAntler.addOrReplaceChild("AntlerSeg2_r1", CubeListBuilder.create().texOffs(10, 79).addBox(-3.6619F, -1.0516F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.5344F, -1.3756F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition AntlerSeg1_r1 = RightAntler.addOrReplaceChild("AntlerSeg1_r1", CubeListBuilder.create().texOffs(85, 31).addBox(-5.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition RightAnlterTumorBase = RightAntler.addOrReplaceChild("RightAnlterTumorBase", CubeListBuilder.create(), PartPose.offset(0.5F, 0.0F, 0.0F));

		PartDefinition Tumor2_r1 = RightAnlterTumorBase.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(4, 43).addBox(-2.0F, 0.0F, -2.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.2372F, 1.3097F, -0.4293F, -1.4872F, 0.5929F, 0.5949F));

		PartDefinition Tumor2_r2 = RightAnlterTumorBase.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(3, 44).addBox(-1.75F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.5408F, -0.6323F, 1.028F, -0.0783F, -0.3539F, 1.4395F));

		PartDefinition Tumor1_r1 = RightAnlterTumorBase.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(1, 45).addBox(-0.75F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.5F, 0.5F, -0.3649F, 0.2448F, 0.5655F));

		PartDefinition RightShootoff1 = RightAntler.addOrReplaceChild("RightShootoff1", CubeListBuilder.create(), PartPose.offset(-3.7654F, -2.7278F, -2.4785F));

		PartDefinition AntlerShootoff2_r1 = RightShootoff1.addOrReplaceChild("AntlerShootoff2_r1", CubeListBuilder.create().texOffs(13, 80).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4419F, -0.4366F, 1.1468F));

		PartDefinition AntlerShootoff1Shootoff_r1 = RightShootoff1.addOrReplaceChild("AntlerShootoff1Shootoff_r1", CubeListBuilder.create().texOffs(98, 20).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5873F, 1.2809F, 0.8533F, -0.1002F, -1.2415F, 0.633F));

		PartDefinition AntlerShootoff1_r1 = RightShootoff1.addOrReplaceChild("AntlerShootoff1_r1", CubeListBuilder.create().texOffs(85, 31).addBox(-3.7812F, -1.0493F, -0.453F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.3435F, 1.9642F, 1.3108F, -0.2351F, -0.5692F, 0.7236F));

		PartDefinition RightShootoff2 = RightAntler.addOrReplaceChild("RightShootoff2", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.7654F, -1.9778F, 2.3785F, 0.0F, 0.0F, -0.5236F));

		PartDefinition AntlerShootoff3_r1 = RightShootoff2.addOrReplaceChild("AntlerShootoff3_r1", CubeListBuilder.create().texOffs(12, 99).addBox(-3.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4419F, 0.4366F, 1.1468F));

		PartDefinition AntlerShootoff1Shootoff_r2 = RightShootoff2.addOrReplaceChild("AntlerShootoff1Shootoff_r2", CubeListBuilder.create().texOffs(90, 32).addBox(-2.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5873F, 1.2809F, -0.8533F, 0.1002F, 1.2415F, 0.633F));

		PartDefinition AntlerShootoff2_r2 = RightShootoff2.addOrReplaceChild("AntlerShootoff2_r2", CubeListBuilder.create().texOffs(85, 31).addBox(-3.7812F, -1.0493F, -1.547F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.3435F, 1.9642F, -1.3108F, 0.2351F, 0.5692F, 0.7236F));

		PartDefinition LeftAntler = Antlers.addOrReplaceChild("LeftAntler", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, -6.5F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition AntlerSeg2_r2 = LeftAntler.addOrReplaceChild("AntlerSeg2_r2", CubeListBuilder.create().texOffs(85, 31).addBox(-1.0F, -1.0F, -1.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3054F));

		PartDefinition LeftAnlterTumorBase = LeftAntler.addOrReplaceChild("LeftAnlterTumorBase", CubeListBuilder.create(), PartPose.offset(-0.5F, 0.0F, 0.0F));

		PartDefinition Tumor3_r1 = LeftAnlterTumorBase.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(2, 45).addBox(0.0F, 0.0F, 0.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.2372F, 1.3097F, 0.3293F, 1.4872F, 0.5929F, -0.5949F));

		PartDefinition Tumor3_r2 = LeftAnlterTumorBase.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(2, 45).addBox(-1.25F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5408F, -0.6323F, -1.128F, 0.0783F, -0.3539F, -1.4395F));

		PartDefinition Tumor2_r3 = LeftAnlterTumorBase.addOrReplaceChild("Tumor2_r3", CubeListBuilder.create().texOffs(2, 44).addBox(-2.25F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.5F, -0.6F, 0.3649F, 0.2448F, -0.5655F));

		PartDefinition LeftShootoff = LeftAntler.addOrReplaceChild("LeftShootoff", CubeListBuilder.create(), PartPose.offsetAndRotation(4.8809F, -1.0094F, 0.1718F, -0.6545F, 0.0F, 0.5236F));

		PartDefinition AntlerShootoff4_r1 = LeftShootoff.addOrReplaceChild("AntlerShootoff4_r1", CubeListBuilder.create().texOffs(88, 32).addBox(0.0F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0139F, -2.281F, 2.2067F, 0.4419F, -0.4366F, -1.1468F));

		PartDefinition AntlerShootoff1Shootoff_r3 = LeftShootoff.addOrReplaceChild("AntlerShootoff1Shootoff_r3", CubeListBuilder.create().texOffs(98, 20).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4266F, -1.0001F, 1.3535F, 0.1002F, -1.2415F, -0.633F));

		PartDefinition AntlerShootoff3_r2 = LeftShootoff.addOrReplaceChild("AntlerShootoff3_r2", CubeListBuilder.create().texOffs(85, 31).addBox(-2.2188F, -1.0493F, -1.547F, 6.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.3296F, -0.3168F, 0.8959F, 0.2351F, -0.5692F, -0.7236F));

		PartDefinition Seg2 = LeftAntler.addOrReplaceChild("Seg2", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5263F, -1.5502F, 0.0601F, 0.0F, 0.0F, 0.8727F));

		PartDefinition AntlerSeg3_r2 = Seg2.addOrReplaceChild("AntlerSeg3_r2", CubeListBuilder.create().texOffs(10, 79).addBox(-0.3381F, -1.0516F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.0081F, 0.1746F, -0.0601F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Seg3 = Seg2.addOrReplaceChild("Seg3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.5754F, -2.066F, 0.015F, 0.0F, 0.0F, 0.3927F));

		PartDefinition AntlerSeg5_r2 = Seg3.addOrReplaceChild("AntlerSeg5_r2", CubeListBuilder.create().texOffs(97, 19).addBox(-0.9F, -0.75F, -0.85F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(2.9828F, -1.4668F, -0.1752F, 0.0F, -0.2618F, -0.0436F));

		PartDefinition AntlerSeg6_r1 = Seg3.addOrReplaceChild("AntlerSeg6_r1", CubeListBuilder.create().texOffs(86, 31).addBox(-0.9F, -0.75F, -1.1F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(2.9828F, -1.4668F, -0.1752F, 0.2182F, 0.2618F, -0.6981F));

		PartDefinition AnterShootoff4_r1 = Seg3.addOrReplaceChild("AnterShootoff4_r1", CubeListBuilder.create().texOffs(96, 20).addBox(-0.5F, -0.75F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1892F, 0.0124F, -0.0752F, -0.4137F, -0.2507F, -1.4743F));

		PartDefinition AntlerSeg4_r2 = Seg3.addOrReplaceChild("AntlerSeg4_r2", CubeListBuilder.create().texOffs(12, 97).addBox(-0.5F, -1.0F, -1.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.1892F, 0.0124F, -0.0752F, 0.0F, 0.0F, -0.4363F));

		PartDefinition TheEnfunganing = Head.addOrReplaceChild("TheEnfunganing", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Tumor_r3 = TheEnfunganing.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.3915F, -8.5893F, 1.9641F, -0.6474F, -0.9911F, 0.4301F));

		PartDefinition Tumor_r4 = TheEnfunganing.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.5585F, -9.5946F, 2.796F, -0.3162F, -1.1712F, 0.8429F));

		PartDefinition Tumor_r5 = TheEnfunganing.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(3, 44).addBox(0.25F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.75F, -10.5F, 3.25F, -0.3905F, -0.6599F, 0.2472F));

		PartDefinition Fungus_r2 = TheEnfunganing.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -6.0F, 0.5F, -0.3109F, -0.5133F, 0.0715F));

		PartDefinition Fungus_r3 = TheEnfunganing.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -3.9F, 0.5F, -0.3291F, 0.5187F, 0.0752F));

		PartDefinition Fungus_r4 = TheEnfunganing.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5F, -3.9F, 0.5F, 0.1509F, -0.5187F, -0.0752F));

		PartDefinition Fungus_r5 = TheEnfunganing.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -6.0F, -0.6F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r6 = TheEnfunganing.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -3.9F, -0.6F, 0.0821F, 0.4891F, -0.195F));

		PartDefinition Fungus_r7 = TheEnfunganing.addOrReplaceChild("Fungus_r7", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, -3.9F, -0.6F, -0.3979F, -0.4891F, 0.195F));

		PartDefinition Fungus_r8 = TheEnfunganing.addOrReplaceChild("Fungus_r8", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.9F, 3.4F, 0.0821F, 0.4891F, -0.195F));

		PartDefinition Fungus_r9 = TheEnfunganing.addOrReplaceChild("Fungus_r9", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -6.9F, 3.4F, -0.3979F, -0.4891F, 0.195F));

		PartDefinition Fungus_r10 = TheEnfunganing.addOrReplaceChild("Fungus_r10", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -6.9F, -3.5F, 0.3979F, 0.4891F, 0.8931F));

		PartDefinition Fungus_r11 = TheEnfunganing.addOrReplaceChild("Fungus_r11", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -6.9F, -3.5F, 0.1797F, -0.4891F, 0.5032F));

		PartDefinition Fungus_r12 = TheEnfunganing.addOrReplaceChild("Fungus_r12", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -9.0F, 3.4F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Fungus_r13 = TheEnfunganing.addOrReplaceChild("Fungus_r13", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -9.0F, 3.4F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r14 = TheEnfunganing.addOrReplaceChild("Fungus_r14", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -10.0F, -0.5F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r15 = TheEnfunganing.addOrReplaceChild("Fungus_r15", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -10.0F, -0.5F, -0.7227F, -0.2399F, 0.1871F));

		PartDefinition crown1 = Head.addOrReplaceChild("crown1", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9966F, -10.6308F, 1.5513F, -0.1309F, -0.1309F, -0.5236F));

		PartDefinition Petal4_r1 = crown1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(54, 0).addBox(-5.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r1 = crown1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(54, 0).addBox(-1.0F, -2.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r1 = crown1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(54, 1).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = crown1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(54, 1).addBox(-3.0F, 0.0F, -4.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Arms = TorsoTop.addOrReplaceChild("Arms", CubeListBuilder.create(), PartPose.offset(-1.0F, -2.95F, 0.95F));

		PartDefinition ArmLeft = Arms.addOrReplaceChild("ArmLeft", CubeListBuilder.create(), PartPose.offset(6.0F, -1.05F, -0.45F));

		PartDefinition ArmSeg1_r1 = ArmLeft.addOrReplaceChild("ArmSeg1_r1", CubeListBuilder.create().texOffs(0, 64).addBox(-2.5F, -5.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, 4.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition ArmLeftSeg2 = ArmLeft.addOrReplaceChild("ArmLeftSeg2", CubeListBuilder.create().texOffs(18, 80).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, 8.25F, 0.0F));

		PartDefinition LeftArmFungus = ArmLeftSeg2.addOrReplaceChild("LeftArmFungus", CubeListBuilder.create(), PartPose.offset(17.0F, 10.0F, 0.9F));

		PartDefinition Fungus_r16 = LeftArmFungus.addOrReplaceChild("Fungus_r16", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -7.25F, -0.9F, 0.3325F, 0.5154F, 0.0523F));

		PartDefinition Fungus_r17 = LeftArmFungus.addOrReplaceChild("Fungus_r17", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -7.25F, -0.9F, -0.1797F, -0.4891F, 0.195F));

		PartDefinition Fungus_r18 = LeftArmFungus.addOrReplaceChild("Fungus_r18", CubeListBuilder.create().texOffs(25, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -4.25F, -0.9F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r19 = LeftArmFungus.addOrReplaceChild("Fungus_r19", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.0F, -4.25F, -0.9F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition ArmLeftSeg3 = ArmLeftSeg2.addOrReplaceChild("ArmLeftSeg3", CubeListBuilder.create().texOffs(84, 3).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftHand = ArmLeftSeg3.addOrReplaceChild("LeftHand", CubeListBuilder.create().texOffs(111, 10).addBox(0.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, -0.1F));

		PartDefinition cube_r1 = LeftHand.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(111, 10).addBox(1.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r2 = LeftHand.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(111, 10).addBox(-1.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition ArmRight = Arms.addOrReplaceChild("ArmRight", CubeListBuilder.create().texOffs(0, 64).addBox(-5.0F, -1.0F, -2.5F, 5.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -1.05F, -0.55F));

		PartDefinition ArmRightFungus = ArmRight.addOrReplaceChild("ArmRightFungus", CubeListBuilder.create(), PartPose.offset(-2.4663F, 2.0501F, 0.9325F));

		PartDefinition Tumor_r6 = ArmRightFungus.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(3, 44).addBox(0.25F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7837F, -3.5501F, 1.1675F, -2.2198F, -0.3183F, 0.7016F));

		PartDefinition Tumor_r7 = ArmRightFungus.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(1, 45).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.9752F, -2.6447F, 0.7136F, -1.7131F, 0.0729F, 1.1776F));

		PartDefinition Tumor_r8 = ArmRightFungus.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(3, 44).addBox(-3.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8578F, -1.6395F, -0.1184F, -2.4069F, -0.1222F, 1.0027F));

		PartDefinition Fungus_r20 = ArmRightFungus.addOrReplaceChild("Fungus_r20", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 4.9499F, -0.8325F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Fungus_r21 = ArmRightFungus.addOrReplaceChild("Fungus_r21", CubeListBuilder.create().texOffs(25, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 4.9499F, -0.8325F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r22 = ArmRightFungus.addOrReplaceChild("Fungus_r22", CubeListBuilder.create().texOffs(53, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 0.9499F, 0.0675F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r23 = ArmRightFungus.addOrReplaceChild("Fungus_r23", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, -2.0501F, -1.8325F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r24 = ArmRightFungus.addOrReplaceChild("Fungus_r24", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, -2.0501F, -1.8325F, -0.7227F, -0.2399F, 0.1871F));

		PartDefinition Fungus_r25 = ArmRightFungus.addOrReplaceChild("Fungus_r25", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 0.9499F, 0.0675F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition ArmRightSeg2 = ArmRight.addOrReplaceChild("ArmRightSeg2", CubeListBuilder.create().texOffs(18, 80).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 8.25F, 0.0F));

		PartDefinition ArmRightSeg3 = ArmRightSeg2.addOrReplaceChild("ArmRightSeg3", CubeListBuilder.create().texOffs(84, 3).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.5F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Tumors = ArmRightSeg3.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(-0.5F, 5.5F, 0.5F));

		PartDefinition Tumor_r9 = Tumors.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(2, 46).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.9499F, 0.0187F, -0.5893F, -0.9741F, 1.3332F, -0.5797F));

		PartDefinition Tumor_r10 = Tumors.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(3, 46).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4035F, 0.8105F, 0.5249F));

		PartDefinition RightHand = ArmRightSeg3.addOrReplaceChild("RightHand", CubeListBuilder.create().texOffs(111, 10).addBox(0.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

		PartDefinition cube_r3 = RightHand.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(111, 10).addBox(1.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition cube_r4 = RightHand.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(111, 10).addBox(-1.0F, -1.0F, -4.0F, 0.0F, 11.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition crown2 = TorsoTop.addOrReplaceChild("crown2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0034F, -3.6308F, 5.5513F, -1.2332F, 0.268F, -0.4031F));

		PartDefinition Petal4_r2 = crown2.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(54, 0).addBox(-5.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8861F, -0.5245F, 0.0399F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r2 = crown2.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(54, 0).addBox(-1.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.6315F, 1.4073F, 0.0399F, -0.1734F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r2 = crown2.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(54, 1).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, -3.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = crown2.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(54, 1).addBox(-3.0F, 0.0F, -5.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1139F, -0.5245F, 4.0399F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Legs = Base.addOrReplaceChild("Legs", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, -1.0F));

		PartDefinition RightLeg = Legs.addOrReplaceChild("RightLeg", CubeListBuilder.create(), PartPose.offset(-2.75F, -18.0F, 1.0F));

		PartDefinition RightLegSeg1 = RightLeg.addOrReplaceChild("RightLegSeg1", CubeListBuilder.create().texOffs(40, 65).addBox(-2.0F, -3.0F, -2.5F, 4.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition RightLegBase = RightLegSeg1.addOrReplaceChild("RightLegBase", CubeListBuilder.create().texOffs(34, 82).addBox(-1.51F, -0.25F, -2.0F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LeftLeg = Legs.addOrReplaceChild("LeftLeg", CubeListBuilder.create(), PartPose.offset(2.75F, -18.0F, 1.0F));

		PartDefinition LeftLegSeg1 = LeftLeg.addOrReplaceChild("LeftLegSeg1", CubeListBuilder.create().texOffs(58, 63).addBox(-2.0F, 0.3027F, -2.4006F, 4.0F, 11.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.25F, 0.5F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftLegFungus = LeftLegSeg1.addOrReplaceChild("LeftLegFungus", CubeListBuilder.create(), PartPose.offset(12.0F, 23.3027F, -1.9006F));

		PartDefinition Fungus_r26 = LeftLegFungus.addOrReplaceChild("Fungus_r26", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -20.05F, 0.55F, 0.0392F, 0.5172F, 0.2531F));

		PartDefinition Fungus_r27 = LeftLegFungus.addOrReplaceChild("Fungus_r27", CubeListBuilder.create().texOffs(25, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -17.05F, 2.45F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Fungus_r28 = LeftLegFungus.addOrReplaceChild("Fungus_r28", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -17.05F, 2.45F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r29 = LeftLegFungus.addOrReplaceChild("Fungus_r29", CubeListBuilder.create().texOffs(53, 0).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.25F, -13.05F, 1.55F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r30 = LeftLegFungus.addOrReplaceChild("Fungus_r30", CubeListBuilder.create().texOffs(39, 0).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.25F, -13.05F, 1.55F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition LeftLegBase = LeftLegSeg1.addOrReplaceChild("LeftLegBase", CubeListBuilder.create().texOffs(54, 79).addBox(-1.49F, -1.25F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 11.3027F, 0.0994F, 0.5236F, 0.0F, 0.0F));

		PartDefinition LeftLegBaseTumor = LeftLegBase.addOrReplaceChild("LeftLegBaseTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 0.0F));

		PartDefinition Tumor_r11 = LeftLegBaseTumor.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(1, 44).addBox(-5.5F, -2.5F, 0.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F))
		.texOffs(3, 44).addBox(-3.5F, -2.5F, -2.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.5F, -0.5F, -1.5F, -0.8711F, 0.2975F, -1.0864F));

		PartDefinition Tumor_r12 = LeftLegBaseTumor.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(1, 44).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -0.5F, -1.5F, 0.0F, 0.3927F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}
	public void animateTumor(ModelPart part,float value){
		part.xScale = 1 + Mth.cos(value/6)/6;
		part.zScale = 1 + Mth.cos(value/6)/6;
		part.yScale = 1 - Mth.cos(value/6)/6;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.Head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.Head.xRot = headPitch /  ( 90F / (float) Math.PI);
		this.Jaw.xRot = 1f + Mth.cos(ageInTicks/6)/6;
		this.animateTumor(this.Tumor1,ageInTicks);
		this.LeftLeg.xRot = Mth.cos(limbSwing * 0.4F) * 0.8F * limbSwingAmount;
		this.RightLeg.xRot = Mth.cos(limbSwing * 0.4F) * -0.8F * limbSwingAmount;
		if (!(limbSwingAmount > -0.15F && limbSwingAmount < 0.15F)){
			this.RightArm.xRot = -0.5f +  Mth.cos(ageInTicks/6)/6;
			this.LeftArm.xRot = -0.5f -  Mth.cos(ageInTicks/6)/6;
			this.RightForArm.xRot = -0.5f +  Mth.cos(ageInTicks/8)/8;
			this.LeftForArm.xRot = -0.5f -  Mth.cos(ageInTicks/8)/8;
			if (entity.isSprinting()){
				this.Abdomen.yRot = Mth.cos(limbSwing * 0.2F) * -0.2F * limbSwingAmount;
			}
			if (entity.isStalking()){
				this.animateWalk(WendigoAnimations.CRAWL,limbSwing,limbSwingAmount,4,5f);
				this.Base.y = -15f;
				this.Base.xRot = 1.1f;
			}
		}else{
			this.RightArm.xRot =Mth.cos(ageInTicks/6)/8;
			this.LeftArm.xRot =-Mth.cos(ageInTicks/6)/8;
		}
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		wendys.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.wendys;
	}
}