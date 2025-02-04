package com.Harbinger.Spore.Client.Models;// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.Harbinger.Spore.Sentities.Organoids.BiomassReformator;
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
import net.minecraft.util.RandomSource;

public class WombModelStageIII<T extends BiomassReformator> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "wombmodelstageiii"), "main");
	private final ModelPart Womb;
	private final ModelPart BaseTumor1;
	private final ModelPart BaseTumor2;
	private final ModelPart BaseTumor3;
	private final ModelPart BaseTumor4;
	private final ModelPart WatcherNeck1;
	private final ModelPart WatcherNeck2;
	private final ModelPart WatcherNeck3;
	private final ModelPart WatcherNeck4;
	private final ModelPart WatcherTumor;
	private final ModelPart WatcherNeck21;
	private final ModelPart WatcherNeck22;
	private final ModelPart WatcherNeck23;
	private final ModelPart ChiefTumor;
	private final ModelPart ChiefSegment1;
	private final ModelPart ChiefSegment2;
	private final ModelPart ChiefSegment3;
	private final ModelPart ChiefSegment4;
	private final ModelPart Tendril1;
	private final ModelPart Tendril11;
	private final ModelPart Tendril111;
	private final ModelPart Tendril2;
	private final ModelPart Tendril21;
	private final ModelPart Tendril211;
	private final ModelPart Tendril3;
	private final ModelPart Tendril31;
	private final ModelPart Tendril311;
	private final ModelPart ProtoCalamity;
	private final ModelPart Maw;
	private final ModelPart RightJaw;
	private final ModelPart LeftJaw;
	private final ModelPart MiddleJaw;
	private final ModelPart Eye;
	private final ModelPart Brain1;
	private final ModelPart Brain2;
	private final ModelPart Brain3;
	private final ModelPart Brain4;
	private final ModelPart Brain5;
	private final ModelPart Brain6;
	private final ModelPart Brain7;
	private final ModelPart Brain8;
	private final ModelPart Brain9;
	private final ModelPart Brain10;
	private final ModelPart Brain11;
	public WombModelStageIII(ModelPart root) {
		this.Womb = root.getChild("Womb");
		this.BaseTumor1 = Womb.getChild("TumorBase").getChild("group1");
		this.BaseTumor2 = Womb.getChild("TumorBase").getChild("group2");
		this.BaseTumor3 = Womb.getChild("TumorBase").getChild("group3");
		this.BaseTumor4 = Womb.getChild("TumorBase").getChild("group4");
		this.WatcherNeck1 = Womb.getChild("WatchingTendril2");
		this.WatcherNeck2 = WatcherNeck1.getChild("Seg1WatchingTendril2");
		this.WatcherNeck3 = WatcherNeck2.getChild("Seg2WatchingTendril2");
		this.WatcherNeck4 = WatcherNeck3.getChild("BodyW22").getChild("HeadW2");
		this.WatcherTumor = WatcherNeck3.getChild("BodyW22").getChild("TumorsW3");
		this.ChiefTumor = Womb.getChild("Chef").getChild("BiomassBase");
		this.ChiefSegment1 = Womb.getChild("Chef").getChild("Body1");
		this.ChiefSegment2 = ChiefSegment1.getChild("Body2");
		this.ChiefSegment3 = ChiefSegment2.getChild("Body3");
		this.ChiefSegment4 = ChiefSegment3.getChild("Body4");
		this.WatcherNeck21 = Womb.getChild("WatchingTendril1");
		this.WatcherNeck22 = WatcherNeck21.getChild("Seg1WatchingTendril1");
		this.WatcherNeck23 = WatcherNeck22.getChild("Seg2WatchingTendril1");
		this.Tendril1 = Womb.getChild("Tendril");
		this.Tendril11 = Tendril1.getChild("Seg2Tendril");
		this.Tendril111 = Tendril11.getChild("Seg3Tendril");
		this.Tendril2 = Womb.getChild("Tendril2");
		this.Tendril21 = Tendril2.getChild("Seg2Tendril2");
		this.Tendril211 = Tendril21.getChild("Seg3Tendril2");
		this.Tendril3 = Womb.getChild("Tendril3");
		this.Tendril31 = Tendril3.getChild("Seg2Tendril3").getChild("Seg3Tendril3");
		this.Tendril311 = Tendril31.getChild("Seg4Tendril3");
		this.ProtoCalamity = Womb.getChild("IncompleteCalamity");
		this.Maw = Womb.getChild("Maw");
		this.RightJaw = Maw.getChild("BackMaw");
		this.LeftJaw = Maw.getChild("RightMaw");
		this.MiddleJaw = Maw.getChild("LeftMaw");
		this.Brain1 = ChiefSegment2.getChild("Body2Head").getChild("OBrain5");
		this.Brain2 = ChiefSegment2.getChild("Body2Head").getChild("OBrain6");
		this.Brain3 = ChiefSegment2.getChild("Body2Head").getChild("OBrain7");
		this.Brain4 = ChiefSegment4.getChild("OBrain4");
		this.Brain5 = ChiefSegment4.getChild("Body5").getChild("OBrain2");
		this.Brain6 = ChiefSegment4.getChild("Body5").getChild("Body6").getChild("Body6Heads").getChild("Body6Head1").getChild("OBrain3");
		this.Brain7 = ChiefSegment4.getChild("Body5").getChild("Body6").getChild("Body6Heads").getChild("Body6Head2").getChild("OBrain1");
		this.Brain8 = WatcherNeck21.getChild("BodyW1").getChild("Brain2");
		this.Brain9 = WatcherNeck23.getChild("BodyW12").getChild("HeadW1").getChild("Brain1");
		this.Brain10 = WatcherNeck1.getChild("BodyW2").getChild("Brain3");
		this.Brain11 = WatcherNeck4.getChild("Brain4");
		this.Eye = WatcherNeck4.getChild("Eye");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Womb = partdefinition.addOrReplaceChild("Womb", CubeListBuilder.create(), PartPose.offset(2.0F, 19.0F, 0.0F));

		PartDefinition TumorBase = Womb.addOrReplaceChild("TumorBase", CubeListBuilder.create(), PartPose.offset(-15.0F, -12.0F, 3.0F));

		PartDefinition group1 = TumorBase.addOrReplaceChild("group1", CubeListBuilder.create(), PartPose.offset(22.3195F, 8.5828F, -19.0F));

		PartDefinition tumor_r1 = group1.addOrReplaceChild("tumor_r1", CubeListBuilder.create().texOffs(17, 14).addBox(-8.61F, -6.9503F, -8.7662F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0951F, -0.9829F, -0.6062F));

		PartDefinition tumor_r2 = group1.addOrReplaceChild("tumor_r2", CubeListBuilder.create().texOffs(17, 14).addBox(2.7416F, -13.9028F, 8.2904F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.6485F, 1.2494F, 16.0827F, -0.3477F, -0.6765F, -0.4172F));

		PartDefinition tumor_r3 = group1.addOrReplaceChild("tumor_r3", CubeListBuilder.create().texOffs(17, 14).addBox(-0.866F, -13.8163F, -29.4235F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-53.6485F, 1.2494F, 18.0827F, 1.5918F, -1.3797F, -1.2929F));

		PartDefinition tumor_r4 = group1.addOrReplaceChild("tumor_r4", CubeListBuilder.create().texOffs(17, 14).addBox(-31.0229F, 5.0238F, -18.6942F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.6485F, 1.2494F, 39.0827F, -0.4021F, -0.4852F, 0.4572F));

		PartDefinition tumor_r5 = group1.addOrReplaceChild("tumor_r5", CubeListBuilder.create().texOffs(17, 14).addBox(-14.0F, -14.0F, -2.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(21.6805F, 13.4172F, 4.0F, 0.48F, -0.3927F, 0.3491F));

		PartDefinition group2 = TumorBase.addOrReplaceChild("group2", CubeListBuilder.create(), PartPose.offset(41.3166F, -0.5583F, -7.7639F));

		PartDefinition tumor_r6 = group2.addOrReplaceChild("tumor_r6", CubeListBuilder.create().texOffs(17, 14).addBox(-13.4002F, -9.7957F, -10.0475F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, -0.2182F, 0.0F));

		PartDefinition tumor_r7 = group2.addOrReplaceChild("tumor_r7", CubeListBuilder.create().texOffs(18, 24).addBox(-4.4559F, -4.4726F, -6.6063F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 12.0F, 5.0F, -0.4146F, -0.1754F, 0.4146F));

		PartDefinition tumor_r8 = group2.addOrReplaceChild("tumor_r8", CubeListBuilder.create().texOffs(17, 14).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.3558F, 12.5583F, 13.7639F, 0.0F, 0.3927F, 0.4363F));

		PartDefinition tumor_r9 = group2.addOrReplaceChild("tumor_r9", CubeListBuilder.create().texOffs(17, 14).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-21.3558F, 1.5583F, 28.7639F, -0.48F, -0.3927F, -0.3491F));

		PartDefinition tumor_r10 = group2.addOrReplaceChild("tumor_r10", CubeListBuilder.create().texOffs(7, 4).addBox(-31.7869F, -17.7216F, -13.2272F, 22.0F, 22.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9971F, 9.1411F, -0.2361F, 0.6953F, -0.2268F, -0.3303F));

		PartDefinition tumor_r11 = group2.addOrReplaceChild("tumor_r11", CubeListBuilder.create().texOffs(17, 14).addBox(-15.0128F, -2.6699F, -3.8276F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-50.9971F, 9.1411F, 1.7639F, -1.1081F, -0.5553F, 0.6291F));

		PartDefinition group3 = TumorBase.addOrReplaceChild("group3", CubeListBuilder.create(), PartPose.offset(37.3558F, -1.4417F, -3.2361F));

		PartDefinition tumor_r12 = group3.addOrReplaceChild("tumor_r12", CubeListBuilder.create().texOffs(17, 14).addBox(-1.8415F, -5.6637F, -7.81F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7574F, 1.1698F, 0.487F));

		PartDefinition tumor_r13 = group3.addOrReplaceChild("tumor_r13", CubeListBuilder.create().texOffs(25, 18).addBox(-10.0F, -12.0F, -14.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.3558F, 10.4417F, -23.7639F, -0.48F, 0.3927F, 0.3491F));

		PartDefinition tumor_r14 = group3.addOrReplaceChild("tumor_r14", CubeListBuilder.create().texOffs(17, 14).addBox(-6.0F, -6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3558F, 12.4417F, -23.7639F, 0.0F, -0.3927F, -0.4363F));

		PartDefinition tumor_r15 = group3.addOrReplaceChild("tumor_r15", CubeListBuilder.create().texOffs(17, 14).addBox(-13.4002F, -2.2043F, -1.9525F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.0472F, 0.2182F, 0.0F));

		PartDefinition tumor_r16 = group3.addOrReplaceChild("tumor_r16", CubeListBuilder.create().texOffs(17, 14).addBox(-14.0F, -2.0F, -14.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.605F, -0.5583F, 8.2361F, 0.48F, 0.3927F, -0.3491F));

		PartDefinition group4 = TumorBase.addOrReplaceChild("group4", CubeListBuilder.create(), PartPose.offset(4.7103F, 0.1678F, -24.0827F));

		PartDefinition tumor_r17 = group4.addOrReplaceChild("tumor_r17", CubeListBuilder.create().texOffs(17, 14).addBox(-30.0229F, -19.0238F, 4.6942F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4021F, 0.4852F, -0.4572F));

		PartDefinition tumor_r18 = group4.addOrReplaceChild("tumor_r18", CubeListBuilder.create().texOffs(17, 14).addBox(-0.866F, -4.1837F, 11.4235F, 18.0F, 18.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-34.0F, 0.0F, 19.0F, 1.5918F, 1.3797F, 1.2929F));

		PartDefinition tumor_r19 = group4.addOrReplaceChild("tumor_r19", CubeListBuilder.create().texOffs(17, 14).addBox(2.7416F, -2.0972F, -24.2904F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 0.0F, 21.0F, -0.3477F, 0.6765F, 0.4172F));

		PartDefinition tumor_r20 = group4.addOrReplaceChild("tumor_r20", CubeListBuilder.create().texOffs(17, 14).addBox(-8.61F, -9.0497F, -7.2338F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.6485F, 1.2494F, 37.0827F, -0.0951F, 0.9829F, 0.6062F));

		PartDefinition tumor_r21 = group4.addOrReplaceChild("tumor_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-35.7869F, -4.2784F, -12.7728F, 26.0F, 26.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.6485F, 1.2494F, 33.0827F, 0.6953F, 0.2268F, 0.3303F));

		PartDefinition WatchingTendril1 = Womb.addOrReplaceChild("WatchingTendril1", CubeListBuilder.create().texOffs(174, 277).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-24.208F, -11.4751F, 13.0F, -0.2618F, 0.0F, -0.2182F));

		PartDefinition BodyW1 = WatchingTendril1.addOrReplaceChild("BodyW1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.19F, -2.6555F, -4.1262F, -1.8212F, 1.2114F, 2.9066F));

		PartDefinition Leg_r1 = BodyW1.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(18, 78).addBox(-1.1032F, -1.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 3.0F, 0.8091F, 0.0688F, 2.3514F));

		PartDefinition Arm_r1 = BodyW1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(18, 78).addBox(-0.5219F, -0.4371F, -1.7124F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2366F, -0.5182F, 2.8999F, 0.037F, 1.1318F, 0.3131F));

		PartDefinition Arm_r2 = BodyW1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(18, 78).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -1.9185F, 9.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r1 = BodyW1.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(57, 72).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5912F, -0.28F, 3.724F, 0.3018F, 0.3762F, 0.9521F));

		PartDefinition TorsoTop_r1 = BodyW1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(86, 56).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0839F, 0.3706F, -0.4731F));

		PartDefinition Jaw_r1 = BodyW1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(106, 48).addBox(1.4654F, -4.935F, -4.4731F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.6913F, 3.8735F, 8.9017F, 0.1692F, 0.2135F, -1.5004F));

		PartDefinition Head_r1 = BodyW1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(32, 52).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8771F, 5.3869F, 9.6927F, -2.0508F, -1.0908F, -1.5708F));

		PartDefinition Brain2 = BodyW1.addOrReplaceChild("Brain2", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.8093F, -2.4635F, 11.388F, 2.2504F, -0.7499F, 0.3537F));

		PartDefinition Seg1WatchingTendril1 = WatchingTendril1.addOrReplaceChild("Seg1WatchingTendril1", CubeListBuilder.create().texOffs(188, 314).addBox(-1.5F, -20.0F, -1.5F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, -0.0138F, -0.3051F, -0.9142F));

		PartDefinition Seg2WatchingTendril1 = Seg1WatchingTendril1.addOrReplaceChild("Seg2WatchingTendril1", CubeListBuilder.create().texOffs(24, 327).addBox(-2.0F, -16.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -18.5F, -0.5F, 0.3927F, 0.0F, 0.6109F));

		PartDefinition BodyW12 = Seg2WatchingTendril1.addOrReplaceChild("BodyW12", CubeListBuilder.create().texOffs(23, 67).addBox(-3.3187F, -2.5107F, -4.2173F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1813F, -9.4893F, -0.7827F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Arm_r3 = BodyW12.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(50, 68).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1813F, -4.5107F, -0.2173F, 0.3361F, -0.2071F, 0.532F));

		PartDefinition Leg_r2 = BodyW12.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(48, 67).addBox(-2.0F, 1.0F, -3.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8187F, 1.4893F, -1.2173F, 0.4232F, 0.8238F, -0.2408F));

		PartDefinition TorsoTop_r2 = BodyW12.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(65, 52).addBox(-3.5F, -5.0F, -3.5F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3187F, -1.5107F, -1.2173F, -0.3054F, 0.0F, 0.0F));

		PartDefinition HeadW1 = BodyW12.addOrReplaceChild("HeadW1", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3187F, -7.5107F, -0.2173F, -1.3811F, 0.1084F, -0.5133F));

		PartDefinition Jaw = HeadW1.addOrReplaceChild("Jaw", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.0F, 4.0F, 0.8995F, 0.2068F, -0.1617F));

		PartDefinition Jaw_r2 = Jaw.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(33, 79).addBox(-4.0F, -2.0F, -7.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -0.75F, -1.0F, 0.1309F, 0.0F, 0.3927F));

		PartDefinition Brain1 = HeadW1.addOrReplaceChild("Brain1", CubeListBuilder.create().texOffs(78, 0).addBox(-2.6667F, -5.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.8333F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.6667F, -5.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.1973F, -2.8588F, -4.064F, -1.0555F, 0.7365F, 0.0835F));

		PartDefinition TumorsW2 = BodyW12.addOrReplaceChild("TumorsW2", CubeListBuilder.create(), PartPose.offset(0.1813F, -3.5107F, 2.7827F));

		PartDefinition Tumor4_r1 = TumorsW2.addOrReplaceChild("Tumor4_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.576F, -2.7394F, -1.2357F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor3_r1 = TumorsW2.addOrReplaceChild("Tumor3_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-2.828F, -0.5697F, -1.8499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor2_r1 = TumorsW2.addOrReplaceChild("Tumor2_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-2.641F, -3.7504F, -1.5356F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0909F, -0.0967F, -0.2541F));

		PartDefinition Tumor1_r1 = TumorsW2.addOrReplaceChild("Tumor1_r1", CubeListBuilder.create().texOffs(0, 42).addBox(-2.1541F, -4.1761F, -2.2588F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.4203F, 0.4928F, 0.2831F));

		PartDefinition WatchingTendril2 = Womb.addOrReplaceChild("WatchingTendril2", CubeListBuilder.create().texOffs(174, 277).addBox(-2.0F, -19.0F, -2.0F, 4.0F, 21.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.2141F, -18.8777F, -17.0F, 0.0F, -0.7418F, -0.4363F));

		PartDefinition BodyW2 = WatchingTendril2.addOrReplaceChild("BodyW2", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.19F, -2.6555F, -4.1262F, -1.8212F, 1.2114F, 2.9066F));

		PartDefinition Leg_r3 = BodyW2.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(18, 78).addBox(-1.1032F, -1.7548F, -1.27F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 3.0F, 0.8091F, 0.0688F, 2.3514F));

		PartDefinition Arm_r4 = BodyW2.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(18, 78).addBox(-0.5219F, -0.4371F, -1.7124F, 8.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.2366F, -0.5182F, 2.8999F, 0.037F, 1.1318F, 0.3131F));

		PartDefinition Arm_r5 = BodyW2.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(22, 78).addBox(-0.6481F, -1.3468F, -1.4118F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.7503F, -1.9185F, 9.3653F, 0.0163F, -0.2642F, 0.2753F));

		PartDefinition TorsoBase_r2 = BodyW2.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(57, 72).addBox(-3.25F, -1.0F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.5912F, -0.28F, 3.724F, 0.3018F, 0.3762F, 0.9521F));

		PartDefinition TorsoTop_r3 = BodyW2.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(86, 56).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.06F, -0.5945F, 5.1262F, 0.0839F, 0.3706F, -0.4731F));

		PartDefinition Brain3 = BodyW2.addOrReplaceChild("Brain3", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).mirror().addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)).mirror(false)
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-7.8093F, -2.4635F, 11.388F, 1.9906F, -0.8481F, 0.2294F));

		PartDefinition Seg1WatchingTendril2 = WatchingTendril2.addOrReplaceChild("Seg1WatchingTendril2", CubeListBuilder.create().texOffs(188, 314).addBox(-1.5F, -20.0F, -1.5F, 3.0F, 20.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, 0.0F, -0.3011F, -0.0522F, 0.4443F));

		PartDefinition Seg2WatchingTendril2 = Seg1WatchingTendril2.addOrReplaceChild("Seg2WatchingTendril2", CubeListBuilder.create().texOffs(24, 327).addBox(-2.0F, -16.0F, -1.0F, 3.0F, 16.0F, 3.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.5F, -18.5F, -0.5F, 0.829F, 0.0F, 0.6109F));

		PartDefinition BodyW22 = Seg2WatchingTendril2.addOrReplaceChild("BodyW22", CubeListBuilder.create().texOffs(24, 67).addBox(-4.3187F, -2.5107F, -4.2173F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1813F, -9.4893F, -0.7827F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Arm_r6 = BodyW22.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(50, 68).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.1813F, -4.5107F, -0.2173F, 0.3361F, -0.2071F, 0.532F));

		PartDefinition Leg_r4 = BodyW22.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(48, 67).addBox(-2.0F, 0.0F, -3.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8187F, 1.4893F, -1.2173F, 0.7764F, 0.5189F, 0.312F));

		PartDefinition TorsoTop_r4 = BodyW22.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(64, 52).addBox(-4.75F, -6.0F, -3.5F, 9.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3187F, -1.5107F, -1.2173F, -0.3054F, 0.0F, 0.0F));

		PartDefinition HeadW2 = BodyW22.addOrReplaceChild("HeadW2", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3187F, -7.5107F, -0.2173F, -1.3811F, 0.1084F, -0.5133F));

		PartDefinition Brain4 = HeadW2.addOrReplaceChild("Brain4", CubeListBuilder.create().texOffs(78, 0).addBox(-2.6667F, -2.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.8333F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.6667F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-1.1119F, -1.06F, -0.691F, -1.8641F, 0.0455F, 0.1909F));

		PartDefinition Eye = HeadW2.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(238, 244).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(-1.0F)), PartPose.offsetAndRotation(0.7121F, 2.0979F, -0.3096F, 1.2751F, -0.534F, -0.6401F));

		PartDefinition pupil = Eye.addOrReplaceChild("pupil", CubeListBuilder.create().texOffs(346, 323).addBox(-2.5F, -2.5F, -1.5F, 5.0F, 5.0F, 3.0F, new CubeDeformation(-1.0F)), PartPose.offset(-0.0171F, 0.0058F, -3.372F));

		PartDefinition TumorsW3 = BodyW22.addOrReplaceChild("TumorsW3", CubeListBuilder.create(), PartPose.offset(0.1813F, -3.5107F, 2.7827F));

		PartDefinition Tumor5_r1 = TumorsW3.addOrReplaceChild("Tumor5_r1", CubeListBuilder.create().texOffs(33, 0).addBox(-1.5F, -1.5F, -1.5F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.576F, -2.7394F, -1.2357F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor4_r2 = TumorsW3.addOrReplaceChild("Tumor4_r2", CubeListBuilder.create().texOffs(41, 25).addBox(-2.828F, -0.5697F, -1.8499F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0523F, -0.1219F, -0.6044F));

		PartDefinition Tumor3_r2 = TumorsW3.addOrReplaceChild("Tumor3_r2", CubeListBuilder.create().texOffs(44, 0).addBox(-2.641F, -3.7504F, -1.5356F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.0909F, -0.0967F, -0.2541F));

		PartDefinition Tumor2_r2 = TumorsW3.addOrReplaceChild("Tumor2_r2", CubeListBuilder.create().texOffs(84, 35).addBox(-2.1541F, -4.1761F, -2.2588F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1032F, 1.7896F, -0.1791F, -0.4203F, 0.4928F, 0.2831F));

		PartDefinition Tendril = Womb.addOrReplaceChild("Tendril", CubeListBuilder.create(), PartPose.offsetAndRotation(1.6297F, -13.4056F, 30.0F, -0.2618F, 0.7854F, 0.0F));

		PartDefinition RootSeg_r1 = Tendril.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(152, 290).addBox(-2.5F, -6.0F, -2.75F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril = Tendril.addOrReplaceChild("Seg2Tendril", CubeListBuilder.create().texOffs(0, 295).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.25F, 0.4232F, 0.1096F, -0.2382F));

		PartDefinition Seg3Tendril = Seg2Tendril.addOrReplaceChild("Seg3Tendril", CubeListBuilder.create().texOffs(26, 328).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.4185F, -0.1274F, 0.2783F));

		PartDefinition Seg4Tendril = Seg3Tendril.addOrReplaceChild("Seg4Tendril", CubeListBuilder.create().texOffs(38, 346).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Tendril2 = Womb.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(3.4261F, -19.2731F, -24.9355F, -0.231F, 1.0317F, -0.02F));

		PartDefinition RootSeg_r2 = Tendril2.addOrReplaceChild("RootSeg_r2", CubeListBuilder.create().texOffs(132, 290).addBox(-2.5F, -6.0F, -2.25F, 5.0F, 12.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(174, 228).addBox(-2.0F, -14.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.0F, -12.0F, -0.25F, 0.4566F, 0.0714F, 0.317F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(26, 328).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.4106F, -0.1274F, -0.2783F));

		PartDefinition Seg4Tendril2 = Seg3Tendril2.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(38, 346).addBox(-0.5F, -13.0F, -0.5F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.3927F, 0.0F, -0.5236F));

		PartDefinition Tendril3 = Womb.addOrReplaceChild("Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(20.3908F, -10.0F, -18.4218F, 1.1928F, -0.4767F, -0.4817F));

		PartDefinition RootSeg_r3 = Tendril3.addOrReplaceChild("RootSeg_r3", CubeListBuilder.create().texOffs(0, 277).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril3 = Tendril3.addOrReplaceChild("Seg2Tendril3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.4363F, 0.0F, 0.5236F));

		PartDefinition RootSeg_r4 = Seg2Tendril3.addOrReplaceChild("RootSeg_r4", CubeListBuilder.create().texOffs(172, 302).addBox(-2.0F, -8.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition Seg2Tendril3Fungus = Seg2Tendril3.addOrReplaceChild("Seg2Tendril3Fungus", CubeListBuilder.create(), PartPose.offset(0.1429F, -9.9999F, 0.8043F));

		PartDefinition Tumor_r22 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r22", CubeListBuilder.create().texOffs(69, 23).addBox(0.25F, -0.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7837F, -3.5501F, 1.1675F, -2.2198F, -0.3183F, 0.7016F));

		PartDefinition Tumor_r23 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r23", CubeListBuilder.create().texOffs(69, 23).addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.9752F, -2.6447F, 0.7136F, -1.7131F, 0.0729F, 1.1776F));

		PartDefinition Tumor_r24 = Seg2Tendril3Fungus.addOrReplaceChild("Tumor_r24", CubeListBuilder.create().texOffs(69, 23).addBox(-3.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(0.8578F, -1.6395F, -0.1184F, -2.4069F, -0.1222F, 1.0027F));

		PartDefinition Fungus_r1 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r1", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 7.9499F, -0.8325F, 0.1783F, -0.2977F, -0.0909F));

		PartDefinition Fungus_r2 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r2", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.25F, -1.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 7.9499F, -0.8325F, 0.0333F, 0.6219F, 0.3593F));

		PartDefinition Fungus_r3 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r3", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, 1.9499F, -0.9325F, 0.0602F, -0.5154F, 0.0523F));

		PartDefinition Fungus_r4 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r4", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0337F, -2.0501F, -1.8325F, -0.1797F, 0.4891F, -0.195F));

		PartDefinition Fungus_r5 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r5", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, -2.0501F, -1.8325F, -0.7227F, -0.2399F, 0.1871F));

		PartDefinition Fungus_r6 = Seg2Tendril3Fungus.addOrReplaceChild("Fungus_r6", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0337F, 3.9499F, 0.0675F, 0.3979F, 0.4891F, 0.195F));

		PartDefinition Seg3Tendril3 = Seg2Tendril3.addOrReplaceChild("Seg3Tendril3", CubeListBuilder.create().texOffs(26, 328).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 16.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -14.0F, 0.0F, 0.3655F, -0.147F, 0.3655F));

		PartDefinition Seg4Tendril3 = Seg3Tendril3.addOrReplaceChild("Seg4Tendril3", CubeListBuilder.create().texOffs(38, 346).addBox(-0.5F, -13.5F, -0.5F, 1.0F, 15.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, -14.5F, 0.0F, 0.546F, -0.1623F, 0.2599F));

		PartDefinition Maw = Womb.addOrReplaceChild("Maw", CubeListBuilder.create().texOffs(0, 104).addBox(-12.9571F, 1.2514F, -15.5653F, 31.0F, 2.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -15.0F, 0.0F, 0.0555F, 0.5648F, 0.1034F));

		PartDefinition BackMaw = Maw.addOrReplaceChild("BackMaw", CubeListBuilder.create().texOffs(192, 226).addBox(-9.0F, -16.0F, -2.0F, 18.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.9641F, 0.0F, 6.2058F, -0.5672F, -0.8727F, 0.0F));

		PartDefinition Teeth_r1 = BackMaw.addOrReplaceChild("Teeth_r1", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.7791F, -5.467F, -4.8761F, -0.2365F, 0.1422F, -0.2657F));

		PartDefinition Teeth_r2 = BackMaw.addOrReplaceChild("Teeth_r2", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.4637F, -4.4295F, -7.2351F, 0.0857F, 0.7702F, 0.1198F));

		PartDefinition Teeth_r3 = BackMaw.addOrReplaceChild("Teeth_r3", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.7571F, -6.6464F, -5.6111F, 0.3458F, -0.5257F, -0.7231F));

		PartDefinition Teeth_r4 = BackMaw.addOrReplaceChild("Teeth_r4", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.5F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4024F, -3.5905F, -3.8889F, -0.1848F, -1.1264F, 0.2041F));

		PartDefinition Teeth_r5 = BackMaw.addOrReplaceChild("Teeth_r5", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -5.5F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -10.0F, -2.5F, 0.0F, 0.4363F, -0.7854F));

		PartDefinition Teeth_r6 = BackMaw.addOrReplaceChild("Teeth_r6", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -8.0F, -3.0F, 0.0F, 0.0F, 0.3491F));

		PartDefinition Teeth_r7 = BackMaw.addOrReplaceChild("Teeth_r7", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -8.0F, -3.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition right_r1 = BackMaw.addOrReplaceChild("right_r1", CubeListBuilder.create().texOffs(242, 52).addBox(-13.0F, 0.0F, -4.0F, 12.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0718F, -15.25F, 2.0F, 0.3084F, -0.7245F, -0.5775F));

		PartDefinition left_r1 = BackMaw.addOrReplaceChild("left_r1", CubeListBuilder.create().texOffs(92, 228).addBox(0.0F, 0.0F, -4.0F, 18.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, -16.0F, 2.0F, 0.1553F, 0.456F, 0.3415F));

		PartDefinition BackMiddleMaw = BackMaw.addOrReplaceChild("BackMiddleMaw", CubeListBuilder.create().texOffs(190, 88).addBox(-8.0F, -15.0F, -1.0F, 21.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, -0.5F, 0.7145F, 0.1064F, 0.1636F));

		PartDefinition Teeth_r8 = BackMiddleMaw.addOrReplaceChild("Teeth_r8", CubeListBuilder.create().texOffs(0, -1).addBox(-1.0F, -9.0F, -1.25F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9283F, -7.1819F, -1.1798F, -0.0331F, -0.2395F, -0.4995F));

		PartDefinition Teeth_r9 = BackMiddleMaw.addOrReplaceChild("Teeth_r9", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.0F, -1.5F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.9283F, -7.1819F, -1.1798F, 0.0018F, -0.3607F, 0.3622F));

		PartDefinition Teeth_r10 = BackMiddleMaw.addOrReplaceChild("Teeth_r10", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -4.5F, -1.0F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7399F, -8.6351F, -1.9897F, -0.0555F, -0.3961F, 0.9728F));

		PartDefinition Teeth_r11 = BackMiddleMaw.addOrReplaceChild("Teeth_r11", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -4.5F, -1.0F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.7893F, -4.1584F, -3.2389F, 0.4611F, -0.5322F, -1.176F));

		PartDefinition rightConnector_r1 = BackMiddleMaw.addOrReplaceChild("rightConnector_r1", CubeListBuilder.create().texOffs(244, 108).addBox(-6.0F, -7.0F, 0.5F, 11.0F, 18.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8832F, -2.9839F, -3.0937F, 0.0902F, -0.7245F, -0.5775F));

		PartDefinition BackMiddleBody1 = BackMiddleMaw.addOrReplaceChild("BackMiddleBody1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.1936F, -5.5983F, -0.1471F, -1.4046F, -0.3499F, 0.234F));

		PartDefinition Leg_r5 = BackMiddleBody1.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(29, 319).addBox(-1.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9124F, 1.6027F, 0.3293F, 0.0606F, -0.9199F, 0.2282F));

		PartDefinition TorsoBase_r3 = BackMiddleBody1.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(80, 290).addBox(-4.25F, -2.5F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, -2.1044F, -0.2225F, 0.0827F, 0.3848F));

		PartDefinition TorsoTop_r5 = BackMiddleBody1.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(284, 258).addBox(-6.0F, -4.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition BackMiddleJaw = BackMiddleMaw.addOrReplaceChild("BackMiddleJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(-8.2552F, -10.2661F, -2.3141F, 0.2058F, -0.284F, -0.6404F));

		PartDefinition HeadRightTeeth_r1 = BackMiddleJaw.addOrReplaceChild("HeadRightTeeth_r1", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, 0.8F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(83, 68).addBox(-4.0F, -4.8F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(13.3639F, 16.4178F, -8.0504F, -0.2048F, 0.8354F, 1.3671F));

		PartDefinition HeadLeftTeeth_r1 = BackMiddleJaw.addOrReplaceChild("HeadLeftTeeth_r1", CubeListBuilder.create().texOffs(0, 15).addBox(-1.75F, 2.75F, -4.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.8773F, 0.186F, 0.5589F, -0.1852F, 0.195F, 0.1943F));

		PartDefinition HeadLeft_r1 = BackMiddleJaw.addOrReplaceChild("HeadLeft_r1", CubeListBuilder.create().texOffs(32, 52).addBox(-1.75F, -4.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.7874F, 0.569F, 0.4867F, -0.1852F, 0.195F, 0.1943F));

		PartDefinition HeadCenter_r1 = BackMiddleJaw.addOrReplaceChild("HeadCenter_r1", CubeListBuilder.create().texOffs(83, 68).addBox(-5.5F, -4.25F, -4.5F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.9922F, -0.6961F, 0.9824F, -0.2618F, 0.0F, 0.0436F));

		PartDefinition HeadRightTeeth_r2 = BackMiddleJaw.addOrReplaceChild("HeadRightTeeth_r2", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-5.3924F, 1.9669F, -3.5158F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition HeadRight_r1 = BackMiddleJaw.addOrReplaceChild("HeadRight_r1", CubeListBuilder.create().texOffs(32, 53).addBox(-3.9984F, -4.7998F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.057F, 0.1363F, -2.5114F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition BackMiddleJawFoliage1 = BackMiddleJaw.addOrReplaceChild("BackMiddleJawFoliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(2.563F, -4.839F, -0.0256F, -0.6707F, -0.445F, -2.4606F));

		PartDefinition Petal4_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal4_r1", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, 0.5245F, 0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal3_r1", CubeListBuilder.create().texOffs(-7, 116).addBox(-2.0F, -1.5F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1508F, -3.6313F, 5.0973F, 0.2764F, 0.3707F, -0.1094F));

		PartDefinition Petal2_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal2_r1", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8639F, 0.5245F, -2.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r1 = BackMiddleJawFoliage1.addOrReplaceChild("Petal1_r1", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.5245F, 3.0399F, -0.3838F, -0.2129F, -0.4821F));

		PartDefinition BackTopMaw = BackMiddleMaw.addOrReplaceChild("BackTopMaw", CubeListBuilder.create().texOffs(276, 166).addBox(-5.5F, -14.5F, -1.5F, 11.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3958F, -13.823F, 0.5F, 0.1309F, 0.0F, 0.3054F));

		PartDefinition Teeth_r12 = BackTopMaw.addOrReplaceChild("Teeth_r12", CubeListBuilder.create().texOffs(0, -2).addBox(-1.9968F, -7.3376F, -1.6481F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5245F, -5.2955F, -1.75F, -0.0851F, 0.25F, -0.5971F));

		PartDefinition Teeth_r13 = BackTopMaw.addOrReplaceChild("Teeth_r13", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -4.5F, -0.75F, 0.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0015F, -6.6939F, -2.3181F, -0.0465F, -0.292F, 0.4631F));

		PartDefinition BackTopHeads = BackTopMaw.addOrReplaceChild("BackTopHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9423F, -11.455F, -2.4105F, -0.2618F, 0.0F, 0.0F));

		PartDefinition HeadRight_r2 = BackTopHeads.addOrReplaceChild("HeadRight_r2", CubeListBuilder.create().texOffs(57, 82).addBox(-8.25F, -1.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.4503F, -1.9684F, 0.4994F, -0.0057F, 0.1205F, -1.0109F));

		PartDefinition HeadLeftTeeth_r2 = BackTopHeads.addOrReplaceChild("HeadLeftTeeth_r2", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.15F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.7314F, 0.4153F, -0.2442F, 0.1309F, 0.0F, -0.1309F));

		PartDefinition HeadLeft_r2 = BackTopHeads.addOrReplaceChild("HeadLeft_r2", CubeListBuilder.create().texOffs(83, 68).mirror().addBox(-4.0F, -6.75F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.7314F, 0.4153F, -0.2442F, 0.1309F, 0.0F, -0.1309F));

		PartDefinition BackTopJawFoliage1 = BackTopHeads.addOrReplaceChild("BackTopJawFoliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(3.5441F, -6.2851F, -1.4807F, -0.6707F, -0.445F, -2.4606F));

		PartDefinition Petal4_r2 = BackTopJawFoliage1.addOrReplaceChild("Petal4_r2", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, 0.5245F, 0.0399F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r2 = BackTopJawFoliage1.addOrReplaceChild("Petal3_r2", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3815F, -1.4073F, 0.0399F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal2_r2 = BackTopJawFoliage1.addOrReplaceChild("Petal2_r2", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8639F, 0.5245F, -2.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r2 = BackTopJawFoliage1.addOrReplaceChild("Petal1_r2", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.5245F, 3.0399F, -0.3838F, -0.2129F, -0.4821F));

		PartDefinition BackTopJawFoliage2 = BackTopHeads.addOrReplaceChild("BackTopJawFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.9327F, 4.5865F, 3.817F, -0.7502F, -0.7003F, -2.3362F));

		PartDefinition Petal4_r3 = BackTopJawFoliage2.addOrReplaceChild("Petal4_r3", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4313F, 7.8542F, 2.9562F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r3 = BackTopJawFoliage2.addOrReplaceChild("Petal3_r3", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9489F, 7.9224F, 2.9562F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal2_r3 = BackTopJawFoliage2.addOrReplaceChild("Petal2_r3", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4313F, 7.8542F, -1.0438F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r3 = BackTopJawFoliage2.addOrReplaceChild("Petal1_r3", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4313F, 7.8542F, 6.9562F, -0.3838F, -0.2129F, -0.4821F));

		PartDefinition BackTopJawFoliage3 = BackTopHeads.addOrReplaceChild("BackTopJawFoliage3", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.5179F, 2.4552F, 0.6503F, 0.8344F, -0.3318F, 1.6611F));

		PartDefinition Petal4_r4 = BackTopJawFoliage3.addOrReplaceChild("Petal4_r4", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, -0.2255F, -0.4601F, -0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r4 = BackTopJawFoliage3.addOrReplaceChild("Petal3_r4", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3815F, -1.1573F, -0.4601F, -0.263F, 0.1603F, -0.1693F));

		PartDefinition Petal2_r4 = BackTopJawFoliage3.addOrReplaceChild("Petal2_r4", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.7745F, -2.4601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r4 = BackTopJawFoliage3.addOrReplaceChild("Petal1_r4", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.7745F, 3.5399F, -0.3838F, -0.2129F, -0.4821F));

		PartDefinition BackTopBody1 = BackTopMaw.addOrReplaceChild("BackTopBody1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.642F, -5.0863F, 0.985F, -1.4046F, -0.3499F, 0.234F));

		PartDefinition Leg_r6 = BackTopBody1.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(29, 319).addBox(-1.0F, -2.0F, -2.0F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.9124F, 1.6027F, 4.3293F, -0.2402F, -0.7464F, 0.7027F));

		PartDefinition Arm_r7 = BackTopBody1.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(28, 319).addBox(-0.5219F, -0.6871F, -1.2876F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.0232F, -0.8265F, 0.2967F));

		PartDefinition Arm_r8 = BackTopBody1.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(29, 319).addBox(-0.6481F, -2.3468F, -1.5882F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0637F, -0.3413F, 0.4242F));

		PartDefinition TorsoBase_r4 = BackTopBody1.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(80, 290).addBox(-4.25F, -2.0F, -3.5F, 6.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.1286F, -0.4614F, 0.5318F));

		PartDefinition TorsoTop_r6 = BackTopBody1.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(284, 258).addBox(-6.0F, -4.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition RightMaw = Maw.addOrReplaceChild("RightMaw", CubeListBuilder.create(), PartPose.offset(0.0F, -5.0F, -26.0F));

		PartDefinition Teeth_r14 = RightMaw.addOrReplaceChild("Teeth_r14", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, 0.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.7577F, -0.467F, 5.6934F, -3.097F, -0.3319F, 2.2763F));

		PartDefinition Teeth_r15 = RightMaw.addOrReplaceChild("Teeth_r15", CubeListBuilder.create().texOffs(0, -2).addBox(-7.6985F, -9.516F, 6.462F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4356F, -1.5673F, 6.1498F, -2.8602F, 0.4594F, -2.4489F));

		PartDefinition Teeth_r16 = RightMaw.addOrReplaceChild("Teeth_r16", CubeListBuilder.create().texOffs(4, -2).addBox(1.0F, -9.5F, -3.25F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.2648F, 1.4095F, 3.0382F, 2.5879F, 0.5934F, 2.1912F));

		PartDefinition Teeth_r17 = RightMaw.addOrReplaceChild("Teeth_r17", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.5F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7221F, -3.8864F, 0.4609F, 2.6072F, -0.4655F, -2.3585F));

		PartDefinition Teeth_r18 = RightMaw.addOrReplaceChild("Teeth_r18", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.5F, 0.25F, 0.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6606F, -1.5905F, 3.1018F, 2.9388F, -0.0308F, 3.0485F));

		PartDefinition Teeth_r19 = RightMaw.addOrReplaceChild("Teeth_r19", CubeListBuilder.create().texOffs(0, -2).addBox(-12.0F, -11.0F, 5.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-18.9641F, -3.0F, 13.2058F, 2.9485F, -0.2926F, -2.764F));

		PartDefinition BaseRight_r1 = RightMaw.addOrReplaceChild("BaseRight_r1", CubeListBuilder.create().texOffs(238, 226).addBox(-11.5F, -4.5F, 5.0F, 17.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.6259F, -2.5F, -6.6589F, 0.2618F, 0.3054F, 0.0F));

		PartDefinition BaseLeft_r1 = RightMaw.addOrReplaceChild("BaseLeft_r1", CubeListBuilder.create().texOffs(240, 0).addBox(-6.0F, -4.0F, -3.0F, 17.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 0.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition RightHeads = RightMaw.addOrReplaceChild("RightHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0261F, -9.3007F, -1.5785F, 0.534F, -0.1886F, -0.1104F));

		PartDefinition HeadLeftTeeth_r3 = RightHeads.addOrReplaceChild("HeadLeftTeeth_r3", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(6.4428F, 7.4576F, 0.1666F, -2.8827F, -0.2359F, -3.078F));

		PartDefinition HeadLeft_r3 = RightHeads.addOrReplaceChild("HeadLeft_r3", CubeListBuilder.create().texOffs(83, 68).mirror().addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(6.4166F, 2.8432F, -1.1625F, -2.8827F, -0.2359F, -3.078F));

		PartDefinition HeadCenter_r2 = RightHeads.addOrReplaceChild("HeadCenter_r2", CubeListBuilder.create().texOffs(0, 52).addBox(-2.0F, -4.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.7521F, 1.4568F, -1.4549F, -0.1106F, 0.0702F, 0.607F));

		PartDefinition HeadRightTeeth_r3 = RightHeads.addOrReplaceChild("HeadRightTeeth_r3", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(-6.2692F, -1.4694F, 3.8778F, 2.8266F, -0.1264F, -2.1838F));

		PartDefinition HeadRight_r3 = RightHeads.addOrReplaceChild("HeadRight_r3", CubeListBuilder.create().texOffs(83, 69).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.3565F, -3.3533F, 0.4134F, 2.8266F, -0.1264F, -2.1838F));

		PartDefinition RightHeadFoliage = RightHeads.addOrReplaceChild("RightHeadFoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0074F, 1.7376F, -1.1069F, 0.0F, 0.0F, 0.3054F));

		PartDefinition Petal4_r5 = RightHeadFoliage.addOrReplaceChild("Petal4_r5", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -2.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, 0.5245F, 0.0399F, 0.0516F, -0.0522F, 0.1353F));

		PartDefinition Petal3_r5 = RightHeadFoliage.addOrReplaceChild("Petal3_r5", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4084F, -1.5736F, -0.1197F, -0.166F, 0.0408F, 0.3032F));

		PartDefinition Petal2_r5 = RightHeadFoliage.addOrReplaceChild("Petal2_r5", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8639F, 0.5245F, -2.9601F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r5 = RightHeadFoliage.addOrReplaceChild("Petal1_r5", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.5245F, 3.0399F, -0.3838F, -0.2129F, -0.4821F));

		PartDefinition RightMiddleMaw = RightMaw.addOrReplaceChild("RightMiddleMaw", CubeListBuilder.create().texOffs(240, 207).addBox(-8.0F, -13.0F, -1.0F, 14.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.3683F, -8.7071F, -1.1681F, 0.5842F, 0.3786F, 0.0504F));

		PartDefinition Teeth_r20 = RightMiddleMaw.addOrReplaceChild("Teeth_r20", CubeListBuilder.create().texOffs(0, -2).addBox(-1.4073F, -5.3677F, -0.8873F, 0.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6981F, -6.6327F, 1.7782F, -3.1352F, 0.1106F, -2.5279F));

		PartDefinition Teeth_r21 = RightMiddleMaw.addOrReplaceChild("Teeth_r21", CubeListBuilder.create().texOffs(4, -2).addBox(0.7514F, -4.8059F, -0.4294F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6981F, -6.6327F, 1.7782F, 3.0806F, 0.6082F, 3.0352F));

		PartDefinition Teeth_r22 = RightMiddleMaw.addOrReplaceChild("Teeth_r22", CubeListBuilder.create().texOffs(0, -2).addBox(1.4118F, -3.1658F, 0.5956F, 0.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.6981F, -6.6327F, 1.7782F, 3.0173F, -0.51F, -2.891F));

		PartDefinition RightTopMaw = RightMiddleMaw.addOrReplaceChild("RightTopMaw", CubeListBuilder.create().texOffs(54, 319).addBox(-4.0F, -9.5F, -1.0F, 9.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6053F, -9.7352F, 0.1486F, -0.3491F, 0.0F, 0.3927F));

		PartDefinition Teeth_r23 = RightTopMaw.addOrReplaceChild("Teeth_r23", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -5.0F, -1.25F, 0.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6559F, -5.7344F, 1.1477F, -3.0887F, -0.1527F, 2.4888F));

		PartDefinition FrontTopHeads = RightTopMaw.addOrReplaceChild("FrontTopHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3567F, -8.5331F, 1.4401F, 0.2618F, 0.0F, 0.0F));

		PartDefinition HeadRight_r4 = FrontTopHeads.addOrReplaceChild("HeadRight_r4", CubeListBuilder.create().texOffs(32, 52).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.1763F, 2.8696F, -0.9974F, -2.7523F, 0.1609F, 2.1473F));

		PartDefinition HeadLeftTeeth_r4 = FrontTopHeads.addOrReplaceChild("HeadLeftTeeth_r4", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(2.3424F, 0.4963F, 1.5031F, -3.0107F, 0.0F, 3.0107F));

		PartDefinition HeadLeft_r4 = FrontTopHeads.addOrReplaceChild("HeadLeft_r4", CubeListBuilder.create().texOffs(83, 68).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.8339F, -3.3659F, -0.5056F, -3.0107F, 0.0F, 3.0107F));

		PartDefinition FrontTopJawFoliage4 = FrontTopHeads.addOrReplaceChild("FrontTopJawFoliage4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1532F, -6.2184F, 1.4807F, 0.6707F, 0.445F, -2.4606F));

		PartDefinition Petal4_r6 = FrontTopJawFoliage4.addOrReplaceChild("Petal4_r6", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, 0.5245F, -0.0399F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r6 = FrontTopJawFoliage4.addOrReplaceChild("Petal3_r6", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3815F, -1.4073F, -0.0399F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r6 = FrontTopJawFoliage4.addOrReplaceChild("Petal2_r6", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8639F, 0.5245F, 2.9601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r6 = FrontTopJawFoliage4.addOrReplaceChild("Petal1_r6", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.5245F, -3.0399F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition FrontTopJawFoliage5 = FrontTopHeads.addOrReplaceChild("FrontTopJawFoliage5", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.3237F, 4.6532F, -3.817F, 0.7502F, 0.7003F, -2.3362F));

		PartDefinition Petal4_r7 = FrontTopJawFoliage5.addOrReplaceChild("Petal4_r7", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.4313F, 7.8542F, -2.9562F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r7 = FrontTopJawFoliage5.addOrReplaceChild("Petal3_r7", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.9489F, 7.9224F, -2.9562F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r7 = FrontTopJawFoliage5.addOrReplaceChild("Petal2_r7", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4313F, 7.8542F, 1.0438F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r7 = FrontTopJawFoliage5.addOrReplaceChild("Petal1_r7", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4313F, 7.8542F, -6.9562F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition FrontTopJawFoliage6 = FrontTopHeads.addOrReplaceChild("FrontTopJawFoliage6", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.9088F, 2.5219F, -0.6503F, -0.8344F, 0.3318F, 1.6611F));

		PartDefinition Petal4_r8 = FrontTopJawFoliage6.addOrReplaceChild("Petal4_r8", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.1361F, -0.2255F, 0.4601F, 0.1745F, 0.0F, 0.4363F));

		PartDefinition Petal3_r8 = FrontTopJawFoliage6.addOrReplaceChild("Petal3_r8", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3815F, -1.1573F, 0.4601F, 0.263F, -0.1603F, -0.1693F));

		PartDefinition Petal2_r8 = FrontTopJawFoliage6.addOrReplaceChild("Petal2_r8", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.7745F, 2.4601F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r8 = FrontTopJawFoliage6.addOrReplaceChild("Petal1_r8", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1361F, 0.7745F, -3.5399F, 0.3838F, 0.2129F, -0.4821F));

		PartDefinition RightMiddleHeads = RightMiddleMaw.addOrReplaceChild("RightMiddleHeads", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.8243F, -0.4845F, 2.1967F, 0.0F, 0.0F, 1.7017F));

		PartDefinition HeadRight_r5 = RightMiddleHeads.addOrReplaceChild("HeadRight_r5", CubeListBuilder.create().texOffs(57, 82).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.217F, -0.1544F, -0.7637F, -3.0725F, -0.099F, 0.3527F));

		PartDefinition HeadLeftTeeth_r5 = RightMiddleHeads.addOrReplaceChild("HeadLeftTeeth_r5", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.9423F, -1.7531F, 1.3862F, -3.0107F, 0.0F, -0.3491F));

		PartDefinition HeadLeft_r5 = RightMiddleHeads.addOrReplaceChild("HeadLeft_r5", CubeListBuilder.create().texOffs(32, 52).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.2747F, 1.9075F, -0.6225F, -3.0107F, 0.0F, -0.3491F));

		PartDefinition RightMiddleFoliage1 = RightMiddleHeads.addOrReplaceChild("RightMiddleFoliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(6.2299F, 1.4923F, 0.62F, -0.7854F, 0.0F, 1.9635F));

		PartDefinition Petal4_r9 = RightMiddleFoliage1.addOrReplaceChild("Petal4_r9", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, 1.161F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r9 = RightMiddleFoliage1.addOrReplaceChild("Petal3_r9", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.416F, 0.0992F, 1.161F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal2_r9 = RightMiddleFoliage1.addOrReplaceChild("Petal2_r9", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 4.161F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r9 = RightMiddleFoliage1.addOrReplaceChild("Petal1_r9", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8984F, -1.8326F, -1.839F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition RightMiddleFoliage2 = RightMiddleHeads.addOrReplaceChild("RightMiddleFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.7701F, 1.4923F, 0.62F, -0.7502F, 0.7003F, 2.3362F));

		PartDefinition Petal4_r10 = RightMiddleFoliage2.addOrReplaceChild("Petal4_r10", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, 1.161F, -0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r10 = RightMiddleFoliage2.addOrReplaceChild("Petal3_r10", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.416F, -1.9008F, 1.161F, -0.263F, -0.1603F, 0.1693F));

		PartDefinition Petal2_r10 = RightMiddleFoliage2.addOrReplaceChild("Petal2_r10", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 5.161F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r10 = RightMiddleFoliage2.addOrReplaceChild("Petal1_r10", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -2.839F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition LeftMaw = Maw.addOrReplaceChild("LeftMaw", CubeListBuilder.create().texOffs(182, 108).addBox(-13.0F, -15.0F, -2.0F, 26.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5134F, 1.1363F, -0.8061F, 1.9748F, -1.5314F, -1.296F));

		PartDefinition Teeth_r24 = LeftMaw.addOrReplaceChild("Teeth_r24", CubeListBuilder.create().texOffs(0, -2).addBox(-3.9904F, -7.6065F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.766F, -6.4316F, 2.3504F, -3.1227F, 0.0852F, -2.9226F));

		PartDefinition Teeth_r25 = LeftMaw.addOrReplaceChild("Teeth_r25", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.5F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.697F, -6.1966F, 2.7128F, -3.0884F, 0.0692F, -2.4853F));

		PartDefinition Teeth_r26 = LeftMaw.addOrReplaceChild("Teeth_r26", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -1.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5772F, -10.4839F, 2.0067F, 3.1416F, -0.4363F, -0.7854F));

		PartDefinition Teeth_r27 = LeftMaw.addOrReplaceChild("Teeth_r27", CubeListBuilder.create().texOffs(4, -2).addBox(4.0F, -9.25F, -0.75F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.8798F, -4.7268F, 2.4892F, 3.0886F, -0.1287F, -2.696F));

		PartDefinition Teeth_r28 = LeftMaw.addOrReplaceChild("Teeth_r28", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -2.0F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.8875F, -6.2481F, 1.6952F, -3.14F, -0.7702F, 0.1198F));

		PartDefinition LeftMawSeg2 = LeftMaw.addOrReplaceChild("LeftMawSeg2", CubeListBuilder.create().texOffs(240, 190).addBox(-6.0F, -12.5F, -2.0F, 14.0F, 13.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(340, 258).addBox(-14.0F, -6.5F, -1.0F, 8.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -14.5F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Teeth_r29 = LeftMawSeg2.addOrReplaceChild("Teeth_r29", CubeListBuilder.create().texOffs(0, -2).addBox(-2.0F, -6.0F, -2.5F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5772F, -6.9839F, 2.0067F, 3.1416F, -0.4363F, -0.7854F));

		PartDefinition Teeth_r30 = LeftMawSeg2.addOrReplaceChild("Teeth_r30", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -8.5F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.6632F, -3.4576F, 2.3773F, -3.0679F, 0.0468F, -2.1363F));

		PartDefinition HeadLeft_r6 = LeftMawSeg2.addOrReplaceChild("HeadLeft_r6", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, -4.8F, -5.25F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.6313F, -6.5405F, 2.2167F, -0.1309F, 0.0F, -0.8727F));

		PartDefinition HeadLeftTeeth_r6 = LeftMawSeg2.addOrReplaceChild("HeadLeftTeeth_r6", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-5.1392F, -5.2885F, 3.221F, -3.0107F, 0.0F, 2.2689F));

		PartDefinition LeftMawBody = LeftMawSeg2.addOrReplaceChild("LeftMawBody", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0375F, -4.7825F, -1.8254F, -2.0289F, -1.312F, 2.1655F));

		PartDefinition Arm_r9 = LeftMawBody.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(176, 343).addBox(-3.164F, -1.3941F, -1.1477F, 4.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8068F, -6.4923F, 2.9503F, 0.7828F, 0.0579F, -0.486F));

		PartDefinition TorsoTop_r7 = LeftMawBody.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(288, 284).addBox(-3.0F, -6.0F, -4.0F, 5.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4218F, -0.7079F, -0.6234F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r5 = LeftMawBody.addOrReplaceChild("TorsoBase_r5", CubeListBuilder.create().texOffs(234, 311).addBox(-1.5F, -4.0F, -3.75F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9218F, 3.2921F, -0.1234F, 0.0F, 0.0F, -0.3927F));

		PartDefinition LeftJaw = LeftMawSeg2.addOrReplaceChild("LeftJaw", CubeListBuilder.create(), PartPose.offsetAndRotation(10.9616F, -3.0221F, -2.1109F, 3.0151F, 0.1782F, 0.9486F));

		PartDefinition HeadRight_r6 = LeftJaw.addOrReplaceChild("HeadRight_r6", CubeListBuilder.create().texOffs(83, 68).addBox(-5.25F, -6.75F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.5847F, 3.8175F, -2.2745F, -0.1114F, 0.0465F, -0.2137F));

		PartDefinition HeadLeftTeeth_r7 = LeftJaw.addOrReplaceChild("HeadLeftTeeth_r7", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-4.0F, -1.0F, -1.5F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false), PartPose.offsetAndRotation(1.1618F, -2.9428F, -7.0216F, -0.3428F, -0.4722F, 3.0112F));

		PartDefinition HeadLeft_r7 = LeftJaw.addOrReplaceChild("HeadLeft_r7", CubeListBuilder.create().texOffs(32, 53).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.1008F, -0.6249F, -3.8472F, -0.3428F, -0.4722F, 3.0112F));

		PartDefinition LeftJawFoliage1 = LeftJaw.addOrReplaceChild("LeftJawFoliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1851F, -0.8143F, -1.8357F, -0.1289F, 0.0227F, 2.1366F));

		PartDefinition Petal4_r11 = LeftJawFoliage1.addOrReplaceChild("Petal4_r11", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r11 = LeftJawFoliage1.addOrReplaceChild("Petal3_r11", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r11 = LeftJawFoliage1.addOrReplaceChild("Petal2_r11", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -4.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r11 = LeftJawFoliage1.addOrReplaceChild("Petal1_r11", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8984F, -1.8326F, 1.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition LeftJawFoliage2 = LeftJaw.addOrReplaceChild("LeftJawFoliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.3703F, 2.7329F, -1.2132F, 0.2998F, -0.9767F, -3.0271F));

		PartDefinition Petal4_r12 = LeftJawFoliage2.addOrReplaceChild("Petal4_r12", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r12 = LeftJawFoliage2.addOrReplaceChild("Petal3_r12", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.416F, -1.9008F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r12 = LeftJawFoliage2.addOrReplaceChild("Petal2_r12", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -5.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r12 = LeftJawFoliage2.addOrReplaceChild("Petal1_r12", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -4.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition LeftMawSeg3 = LeftMawSeg2.addOrReplaceChild("LeftMawSeg3", CubeListBuilder.create().texOffs(324, 163).addBox(-4.0F, -5.769F, 0.1721F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -12.067F, -0.25F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Teeth_r31 = LeftMawSeg3.addOrReplaceChild("Teeth_r31", CubeListBuilder.create().texOffs(0, -2).addBox(-0.025F, -3.4643F, -1.4981F, 0.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.8762F, -1.7619F, 3.048F, 3.0641F, 0.3981F, 2.1533F));

		PartDefinition Head_r2 = LeftMawSeg3.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(57, 82).addBox(-4.0F, -3.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2439F, -5.0686F, 2.087F, 2.4853F, 0.0692F, -2.8894F));

		PartDefinition LeftMawFoliage = LeftMawSeg3.addOrReplaceChild("LeftMawFoliage", CubeListBuilder.create(), PartPose.offsetAndRotation(2.3891F, -5.0675F, 2.4694F, 0.7479F, -0.5522F, 0.6593F));

		PartDefinition Petal4_r13 = LeftMawFoliage.addOrReplaceChild("Petal4_r13", CubeListBuilder.create().texOffs(-7, 123).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r13 = LeftMawFoliage.addOrReplaceChild("Petal3_r13", CubeListBuilder.create().texOffs(5, 117).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r13 = LeftMawFoliage.addOrReplaceChild("Petal2_r13", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -2.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r13 = LeftMawFoliage.addOrReplaceChild("Petal1_r13", CubeListBuilder.create().texOffs(-7, 109).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition IncompleteCalamity = Womb.addOrReplaceChild("IncompleteCalamity", CubeListBuilder.create().texOffs(127, 0).addBox(-8.0F, -8.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5381F, -24.8947F, -4.891F, 0.0931F, 0.5231F, 0.0131F));

		PartDefinition Teeth_r32 = IncompleteCalamity.addOrReplaceChild("Teeth_r32", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -7.5F, 0.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.4711F, -1.983F, -3.3805F, 1.344F, -0.8707F, 1.9431F));

		PartDefinition Teeth_r33 = IncompleteCalamity.addOrReplaceChild("Teeth_r33", CubeListBuilder.create().texOffs(4, -2).addBox(0.0F, -11.5F, -1.0F, 0.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0876F, -4.4397F, -8.8493F, 0.0F, 0.0F, 2.6616F));

		PartDefinition Teeth_r34 = IncompleteCalamity.addOrReplaceChild("Teeth_r34", CubeListBuilder.create().texOffs(0, -2).addBox(0.0F, -6.0F, -0.25F, 0.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7618F, 1.2802F, 9.6014F, -2.8609F, 0.0852F, -2.9226F));

		PartDefinition tumor_r25 = IncompleteCalamity.addOrReplaceChild("tumor_r25", CubeListBuilder.create().texOffs(141, 10).addBox(-7.5F, -8.5F, -23.5F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(140, 12).addBox(-3.5F, -4.5F, -6.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.5079F, 4.8039F, 8.1044F, 0.3596F, 0.4257F, 0.6019F));

		PartDefinition tumor_r26 = IncompleteCalamity.addOrReplaceChild("tumor_r26", CubeListBuilder.create().texOffs(140, 12).addBox(-9.0F, 1.0F, 4.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(137, 8).addBox(-18.0F, 6.0F, -6.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(140, 12).addBox(-20.0F, -5.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.2955F, -0.2659F, -2.0864F, 0.6773F, -0.1099F, 0.4105F));

		PartDefinition tumor_r27 = IncompleteCalamity.addOrReplaceChild("tumor_r27", CubeListBuilder.create().texOffs(128, 1).addBox(-20.4002F, -21.2043F, 2.0475F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.2224F, 11.5735F, 3.4418F, 1.0472F, 0.2182F, 0.0F));

		PartDefinition CalamityBody = IncompleteCalamity.addOrReplaceChild("CalamityBody", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.1191F, -8.2568F, 4.3836F, 0.0F, -0.7854F, -0.2618F));

		PartDefinition Leg_r7 = CalamityBody.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(1, 90).mirror().addBox(0.0F, -2.5F, -1.5F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.5047F, 3.5354F, 2.994F, -0.7441F, -0.249F, 1.6658F));

		PartDefinition Arm_r10 = CalamityBody.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(0, 90).addBox(-0.5219F, -1.4371F, -1.2876F, 9.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7693F, -3.2271F, 2.7196F, -0.8604F, -0.255F, 1.1657F));

		PartDefinition Arm_r11 = CalamityBody.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(1, 90).addBox(-1.6481F, -2.0968F, -1.5882F, 8.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.283F, -0.6274F, -6.7458F, -0.0163F, 0.2642F, 0.2753F));

		PartDefinition TorsoBase_r6 = CalamityBody.addOrReplaceChild("TorsoBase_r6", CubeListBuilder.create().texOffs(1, 99).addBox(-3.25F, -0.25F, -3.5F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.376F, 1.0111F, 1.8956F, -0.3988F, -0.2706F, 1.2547F));

		PartDefinition TorsoTop_r8 = CalamityBody.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(104, 36).addBox(-6.0F, -3.5F, -4.0F, 6.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4072F, 1.6966F, 0.4934F, -0.0177F, -0.4775F, 0.2877F));

		PartDefinition Jaw_r3 = CalamityBody.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(106, 48).addBox(1.4654F, -4.935F, -3.5269F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.2241F, -3.8354F, -3.2821F, -0.1692F, -0.2135F, 1.074F));

		PartDefinition Head_r3 = CalamityBody.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(83, 68).addBox(-4.0F, -3.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4678F, -4.8662F, -4.5458F, 1.7044F, -1.2238F, -2.5565F));

		PartDefinition CcalamityBodyHeadGroup = IncompleteCalamity.addOrReplaceChild("CcalamityBodyHeadGroup", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0023F, -8.3044F, 0.0821F, -2.5477F, 1.2871F, -0.5738F));

		PartDefinition HeadLeftTeeth_r8 = CcalamityBodyHeadGroup.addOrReplaceChild("HeadLeftTeeth_r8", CubeListBuilder.create().texOffs(0, 19).mirror().addBox(-2.75F, 3.35F, -4.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).mirror(false)
		.texOffs(81, 89).addBox(-2.75F, -3.25F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.5847F, -2.8175F, -1.2745F, -0.1372F, -0.0042F, 0.4948F));

		PartDefinition HeadRightTeeth_r4 = CcalamityBodyHeadGroup.addOrReplaceChild("HeadRightTeeth_r4", CubeListBuilder.create().texOffs(0, 19).addBox(-4.0F, 0.6F, -2.75F, 8.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F))
		.texOffs(83, 68).addBox(-4.0F, -5.0F, -2.75F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.597F, -1.4339F, -2.0181F, 0.1309F, 0.0F, -0.3491F));

		PartDefinition Foliage1 = CcalamityBodyHeadGroup.addOrReplaceChild("Foliage1", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.8879F, -4.6786F, -3.5108F, 0.5672F, 0.0F, -0.6545F));

		PartDefinition Petal4_r14 = Foliage1.addOrReplaceChild("Petal4_r14", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r14 = Foliage1.addOrReplaceChild("Petal3_r14", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r14 = Foliage1.addOrReplaceChild("Petal2_r14", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -3.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r14 = Foliage1.addOrReplaceChild("Petal1_r14", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Foliage2 = CcalamityBodyHeadGroup.addOrReplaceChild("Foliage2", CubeListBuilder.create(), PartPose.offsetAndRotation(6.381F, -2.3176F, -2.9318F, 0.7479F, -0.5522F, 0.6593F));

		PartDefinition Petal4_r15 = Foliage2.addOrReplaceChild("Petal4_r15", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1016F, -1.8326F, -1.161F, 0.1745F, 0.0F, -0.4363F));

		PartDefinition Petal3_r15 = Foliage2.addOrReplaceChild("Petal3_r15", CubeListBuilder.create().texOffs(-7, 116).addBox(-3.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.416F, 0.0992F, -1.161F, 0.263F, 0.1603F, 0.1693F));

		PartDefinition Petal2_r15 = Foliage2.addOrReplaceChild("Petal2_r15", CubeListBuilder.create().texOffs(5, 117).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, -2.161F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Petal1_r15 = Foliage2.addOrReplaceChild("Petal1_r15", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.0F, 0.0F, -3.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8984F, -1.8326F, 2.839F, 0.3838F, -0.2129F, 0.4821F));

		PartDefinition Chef = Womb.addOrReplaceChild("Chef", CubeListBuilder.create(), PartPose.offsetAndRotation(17.2734F, 3.0F, 12.5639F, 0.0F, 1.1781F, 0.0F));

		PartDefinition BiomassBase = Chef.addOrReplaceChild("BiomassBase", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 2.0F, 8.0F, 0.0F, -0.6981F, 0.0F));

		PartDefinition Biomass_r1 = BiomassBase.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(44, 27).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.1551F, -1.9228F, 0.582F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = BiomassBase.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(44, 27).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.038F, -1.586F, 8.47F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = BiomassBase.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(44, 27).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3366F, -2.6455F, -0.5176F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Biomass_r4 = BiomassBase.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(44, 27).addBox(-11.0F, 6.0F, -4.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.1706F, -0.1996F, 0.7153F));

		PartDefinition Body1 = Chef.addOrReplaceChild("Body1", CubeListBuilder.create().texOffs(0, 66).addBox(-2.0802F, -5.1943F, -2.2372F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.9198F, -0.7679F, 5.3403F, -0.4331F, -0.0552F, -0.1188F));

		PartDefinition Arm_r12 = Body1.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(48, 67).addBox(-3.7909F, 0.5332F, 52.3101F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0802F, -2.1651F, -53.4788F, 0.1739F, -0.0151F, 0.0859F));

		PartDefinition TorsoTop_r9 = Body1.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(22, 67).addBox(-4.0F, -22.5388F, 49.9544F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4198F, 1.9847F, -54.7667F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Body1Head = Body1.addOrReplaceChild("Body1Head", CubeListBuilder.create().texOffs(0, 52).addBox(-3.9171F, -8.1097F, -2.6771F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3369F, -9.3126F, 1.3381F, 0.455F, 0.19F, -0.7676F));

		PartDefinition B2HFungus2 = Body1Head.addOrReplaceChild("B2HFungus2", CubeListBuilder.create(), PartPose.offset(0.0926F, -7.2169F, 3.9611F));

		PartDefinition Plane_r1 = B2HFungus2.addOrReplaceChild("Plane_r1", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8183F, -0.266F, -5.8336F, 0.7933F, -0.8795F, -0.2608F));

		PartDefinition Plane_r2 = B2HFungus2.addOrReplaceChild("Plane_r2", CubeListBuilder.create().texOffs(-7, 116).addBox(-1.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, -0.2747F, -0.158F, -0.4422F));

		PartDefinition Body2 = Body1.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.4231F, -9.7068F, -0.1365F, -0.1786F, -0.2173F, 0.7556F));

		PartDefinition TorsoTop_r10 = Body2.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(22, 67).addBox(-4.0F, -10.8006F, 50.6644F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0033F, -9.2486F, -55.0688F, -0.1745F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r7 = Body2.addOrReplaceChild("TorsoBase_r7", CubeListBuilder.create().texOffs(0, 66).addBox(-3.0F, 15.0476F, 49.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5033F, -0.2486F, -55.0688F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body2Head = Body2.addOrReplaceChild("Body2Head", CubeListBuilder.create().texOffs(0, 52).addBox(-55.5634F, -24.058F, 3.3813F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(3.0064F, -8.8227F, -55.5642F, -1.2064F, 1.2308F, -0.8812F));

		PartDefinition Head2Jaw = Body2Head.addOrReplaceChild("Head2Jaw", CubeListBuilder.create().texOffs(33, 79).addBox(-4.0F, -1.0F, 0.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-51.5634F, -17.3587F, 3.4276F, -0.4144F, 0.1153F, 0.3762F));

		PartDefinition B2HFungus = Body2Head.addOrReplaceChild("B2HFungus", CubeListBuilder.create(), PartPose.offset(-51.0F, -22.0F, 9.0F));

		PartDefinition Plane_r3 = B2HFungus.addOrReplaceChild("Plane_r3", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8183F, -0.266F, -5.8336F, 0.7933F, -0.8795F, -0.2608F));

		PartDefinition Plane_r4 = B2HFungus.addOrReplaceChild("Plane_r4", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.25F, 0.0F, -4.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0395F, -0.3111F, 1.1942F, -0.315F, -0.0878F, 0.032F));

		PartDefinition Plane_r5 = B2HFungus.addOrReplaceChild("Plane_r5", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3265F, -0.81F, -2.8293F, -0.6841F, -0.2209F, 0.1827F));

		PartDefinition Plane_r6 = B2HFungus.addOrReplaceChild("Plane_r6", CubeListBuilder.create().texOffs(-7, 123).addBox(-1.5F, 0.0F, -2.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, -0.5F, -0.2747F, -0.158F, -0.4422F));

		PartDefinition OBrain5 = Body2Head.addOrReplaceChild("OBrain5", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-48.7892F, -21.47F, 9.5191F, -1.5392F, 0.4623F, 0.1339F));

		PartDefinition OBrain6 = Body2Head.addOrReplaceChild("OBrain6", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-55.2278F, -22.6115F, 8.2744F, -0.5236F, 0.0F, -1.0036F));

		PartDefinition OBrain7 = Body2Head.addOrReplaceChild("OBrain7", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-50.4209F, -24.1588F, 5.1622F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Body3 = Body2.addOrReplaceChild("Body3", CubeListBuilder.create().texOffs(48, 67).addBox(-6.5025F, -9.8855F, -6.6117F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5008F, -9.3261F, -1.1432F, 0.0F, 0.0F, -1.0036F));

		PartDefinition TorsoTop_r11 = Body3.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(22, 67).addBox(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4975F, -6.95F, -3.7835F, 0.7418F, 0.0F, 0.0F));

		PartDefinition TorsoBase_r8 = Body3.addOrReplaceChild("TorsoBase_r8", CubeListBuilder.create().texOffs(0, 66).addBox(-3.0F, 18.0476F, 45.3134F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9975F, -3.9225F, -52.9256F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Body4 = Body3.addOrReplaceChild("Body4", CubeListBuilder.create(), PartPose.offsetAndRotation(1.3105F, -10.7891F, -7.9901F, 0.5528F, -0.82F, -0.4184F));

		PartDefinition Arm_r13 = Body4.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(48, 67).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 5.5F, 0.3048F, 0.0035F, 0.0457F));

		PartDefinition Arm_r14 = Body4.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(48, 67).addBox(-2.0F, -1.0F, -3.5F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1958F, -1.5128F, -3.0F, -0.0451F, -0.0227F, 0.1289F));

		PartDefinition TorsoBase_r9 = Body4.addOrReplaceChild("TorsoBase_r9", CubeListBuilder.create().texOffs(0, 76).addBox(-1.0F, -7.0F, -4.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.0F, 1.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition OBrain4 = Body4.addOrReplaceChild("OBrain4", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.2243F, 0.3724F, -0.6566F, 0.3037F, -0.6878F, -1.6803F));

		PartDefinition Body5 = Body4.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(0, 66).mirror().addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.6168F, 0.84F, 1.2362F));

		PartDefinition TorsoTop_r12 = Body5.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(22, 67).addBox(-4.0F, -5.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition OBrain2 = Body5.addOrReplaceChild("OBrain2", CubeListBuilder.create().texOffs(78, 0).addBox(-2.6667F, -2.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.8333F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.6667F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-4.9295F, -8.3953F, -3.1257F, 0.0F, 0.0F, -1.1781F));

		PartDefinition Body6 = Body5.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(0, 66).addBox(-3.8659F, -5.0472F, -2.6809F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1104F, -9.6658F, -2.0729F, 0.9596F, 0.2082F, -0.0004F));

		PartDefinition Arm_r15 = Body6.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(48, 67).addBox(-3.0F, -3.0F, -1.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3387F, -5.1019F, -0.9469F, -1.3011F, -0.1735F, 0.0101F));

		PartDefinition TorsoTop_r13 = Body6.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(22, 67).addBox(-1.0167F, -7.1827F, -2.8839F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3492F, -3.8644F, -0.297F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Body6Heads = Body6.addOrReplaceChild("Body6Heads", CubeListBuilder.create(), PartPose.offsetAndRotation(1.8896F, -9.8342F, -1.9271F, -1.2294F, -0.0741F, 0.2054F));

		PartDefinition Body6Head1 = Body6Heads.addOrReplaceChild("Body6Head1", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, -1.0F, 0.5F, 0.0F, -0.2182F, 0.6981F));

		PartDefinition HeadBase_r1 = Body6Head1.addOrReplaceChild("HeadBase_r1", CubeListBuilder.create().texOffs(0, 52).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(1.0F, -4.5F, -0.5F, 0.0F, 3.1416F, 0.0F));

		PartDefinition Body3Head1Nose = Body6Head1.addOrReplaceChild("Body3Head1Nose", CubeListBuilder.create(), PartPose.offsetAndRotation(1.7979F, -0.9947F, -4.8494F, 0.0F, 0.0F, -0.6109F));

		PartDefinition B6H1HeadFungus = Body6Head1.addOrReplaceChild("B6H1HeadFungus", CubeListBuilder.create(), PartPose.offset(2.0F, -5.0F, 0.0F));

		PartDefinition Plane_r7 = B6H1HeadFungus.addOrReplaceChild("Plane_r7", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.5F, 0.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7586F, -0.0708F, 0.5294F, -0.0927F, -0.6196F, 0.2394F));

		PartDefinition Plane_r8 = B6H1HeadFungus.addOrReplaceChild("Plane_r8", CubeListBuilder.create().texOffs(-7, 109).addBox(-3.5F, 0.0F, -5.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7435F, -0.1183F, -0.3166F, 0.3074F, 0.4585F, -0.1806F));

		PartDefinition Plane_r9 = B6H1HeadFungus.addOrReplaceChild("Plane_r9", CubeListBuilder.create().texOffs(-7, 123).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.3844F, 0.0F, 3.612F, 0.3257F, 0.5019F, 0.295F));

		PartDefinition OBrain3 = Body6Head1.addOrReplaceChild("OBrain3", CubeListBuilder.create().texOffs(78, 0).addBox(-2.8333F, -2.5F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.6667F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.8333F, -2.5F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(1.2371F, -4.4771F, -1.412F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Body6Head2 = Body6Heads.addOrReplaceChild("Body6Head2", CubeListBuilder.create().texOffs(32, 53).addBox(-3.0F, -6.5F, -4.5F, 8.0F, 6.0F, 8.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-3.0F, 1.0F, -2.5F, 0.2182F, 0.0F, -0.2618F));

		PartDefinition B6H2HeadFungus = Body6Head2.addOrReplaceChild("B6H2HeadFungus", CubeListBuilder.create(), PartPose.offset(2.0F, -7.0F, 0.0F));

		PartDefinition Plane_r10 = B6H2HeadFungus.addOrReplaceChild("Plane_r10", CubeListBuilder.create().texOffs(-7, 116).addBox(-4.5F, 0.0F, -6.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.7586F, -0.0708F, 0.5294F, -0.0927F, -0.6196F, 0.2394F));

		PartDefinition Plane_r11 = B6H2HeadFungus.addOrReplaceChild("Plane_r11", CubeListBuilder.create().texOffs(-7, 109).addBox(-9.5F, 0.0F, -9.5F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.7435F, -0.1183F, -0.3166F, 0.3074F, 0.4585F, -0.1806F));

		PartDefinition OBrain1 = Body6Head2.addOrReplaceChild("OBrain1", CubeListBuilder.create().texOffs(78, 0).addBox(-2.6667F, -2.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(105, 0).addBox(0.8333F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F))
		.texOffs(105, 0).addBox(-3.6667F, -2.0F, -4.0F, 3.0F, 5.0F, 8.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.3271F, -6.2252F, -1.9013F, 0.4839F, 0.3332F, -0.0647F));

		PartDefinition FusedJaw = Body6Heads.addOrReplaceChild("FusedJaw", CubeListBuilder.create(), PartPose.offset(-0.5F, 1.037F, 0.3139F));

		PartDefinition Head2Jaw2 = FusedJaw.addOrReplaceChild("Head2Jaw2", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1267F, -1.9707F, 0.5183F, 0.6202F, -0.3684F, 0.343F));

		PartDefinition Teeth_r35 = Head2Jaw2.addOrReplaceChild("Teeth_r35", CubeListBuilder.create().texOffs(0, -1).addBox(0.0F, -5.0F, -1.0F, 0.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0649F, 0.6222F, -5.392F, -0.4427F, 1.0066F, 0.7832F));

		PartDefinition Jaw_r4 = Head2Jaw2.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(240, 15).addBox(-6.7979F, -0.9053F, -8.6506F, 11.0F, 2.0F, 10.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.3045F, -0.1502F, 0.5665F, 0.3054F, 0.0F, -0.3491F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	private void animateBrain(ModelPart part,float value){
		part.xScale = 1 + value;
		part.yScale = 1 + value;
		part.zScale = 1 + value;
	}
	private void animateProtoCalamity(ModelPart part,float value){
		RandomSource source = RandomSource.create();
		part.xScale = 1 + Mth.sin(value/6)/6;
		part.yScale = 1 + Mth.cos(value/6)/6;
		part.zScale = 1 + Mth.sin(value/6)/6;
		part.x = part.getInitialPose().x + (source.nextFloat() - source.nextFloat());
		part.z = part.getInitialPose().z + (source.nextFloat() - source.nextFloat());
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

		this.animateTumor(BaseTumor1, Mth.sin(ageInTicks/7)/9);
		this.animateTumor(BaseTumor2, Mth.cos(ageInTicks/7)/8);
		this.animateTumor(BaseTumor3, -Mth.sin(ageInTicks/8)/8);
		this.animateTumor(BaseTumor4, -Mth.cos(ageInTicks/7)/9);
		this.animateTentacleX(WatcherNeck1,Mth.cos(ageInTicks/10)/4);
		this.animateTentacleZ(WatcherNeck2,Mth.cos(ageInTicks/8)/6);
		this.animateTentacleZ(WatcherNeck3,Mth.cos(ageInTicks/8)/6);
		this.animateTentacleX(WatcherNeck4,Mth.cos(ageInTicks/6)/4);
		this.animateTumor(WatcherTumor,Mth.sin(ageInTicks/6)/6);
		this.animateTumor(ChiefTumor,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleZ(ChiefSegment1,Mth.cos(ageInTicks/8)/6);
		this.animateTentacleZ(ChiefSegment2,Mth.cos(ageInTicks/8)/6);
		this.animateTentacleY(ChiefSegment3,Mth.sin(ageInTicks/7)/6);
		this.animateTentacleY(ChiefSegment4,Mth.cos(ageInTicks/6)/6);
		this.animateTentacleX(Tendril1,Mth.sin(ageInTicks/6)/4);
		this.animateTentacleX(Tendril11,Mth.sin(ageInTicks/6)/4);
		this.animateTentacleX(Tendril111,Mth.sin(ageInTicks/6)/5);
		this.animateTentacleX(Tendril2,Mth.sin(ageInTicks/6)/4);
		this.animateTentacleX(Tendril21,Mth.sin(ageInTicks/5)/5);
		this.animateTentacleZ(Tendril211,Mth.sin(ageInTicks/6)/4);
		this.animateTentacleY(Tendril3,Mth.cos(ageInTicks/6)/4);
		this.animateTentacleX(Tendril31,Mth.cos(ageInTicks/5)/4);
		this.animateTentacleZ(Tendril311,Mth.cos(ageInTicks/6)/4);
		this.animateProtoCalamity(ProtoCalamity,ageInTicks);
		this.animateTentacleY(Maw,Mth.cos(ageInTicks/7)/7);
		this.animateTentacleX(RightJaw,Mth.cos(ageInTicks/7)/7);
		this.animateTentacleX(LeftJaw,-Mth.cos(ageInTicks/7)/7);
		this.animateTentacleZ(MiddleJaw,Mth.cos(ageInTicks/7)/7);
		this.animateTentacleX(WatcherNeck21,Mth.cos(ageInTicks/5)/6);
		this.animateTentacleX(WatcherNeck22,Mth.cos(ageInTicks/5)/6);
		this.animateTentacleX(WatcherNeck23,Mth.cos(ageInTicks/5)/5);
		this.animateTentacleZ(Eye,Mth.sin(ageInTicks/8));
		this.animateBrain(Brain1,Mth.cos(ageInTicks/6)/6);
		this.animateBrain(Brain2,-Mth.sin(ageInTicks/7)/6);
		this.animateBrain(Brain3,Mth.cos(ageInTicks/6)/7);
		this.animateBrain(Brain4,-Mth.sin(ageInTicks/6)/6);
		this.animateBrain(Brain5,Mth.cos(ageInTicks/7)/6);
		this.animateBrain(Brain6,Mth.sin(ageInTicks/6)/6);
		this.animateBrain(Brain7,-Mth.cos(ageInTicks/6)/7);
		this.animateBrain(Brain8,Mth.sin(ageInTicks/6)/6);
		this.animateBrain(Brain9,-Mth.cos(ageInTicks/7)/6);
		this.animateBrain(Brain10,Mth.sin(ageInTicks/6)/6);
		this.animateBrain(Brain11,Mth.cos(ageInTicks/6)/6);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Womb.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}