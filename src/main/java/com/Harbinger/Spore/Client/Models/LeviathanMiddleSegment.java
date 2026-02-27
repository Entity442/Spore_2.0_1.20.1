package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.BaseEntities.LeviathanMultipart;
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

public class LeviathanMiddleSegment<T extends LeviathanMultipart> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new  ResourceLocation(Spore.MODID, "leviathanmiddlesegment"), "main");
	public final ModelPart LeviathanAbdomen;
	private final ModelPart Base;
	private final ModelPart fin;
	private final ModelPart CenterCorpseDetails;
	private final ModelPart CenterBody1;
	private final ModelPart CenterBody2;
	private final ModelPart CenterBody4;
	private final ModelPart CenterCorpseDetails2;
	private final ModelPart CenterBody3;
	private final ModelPart CenterBody5;
	private final ModelPart CenterBody6;
	private final ModelPart CenterCorpseDetails4;
	private final ModelPart CenterBody13;
	private final ModelPart CenterBody14;
	private final ModelPart CenterBody15;
	private final ModelPart CenterBody16;
	private final ModelPart Tumors;
	private final ModelPart Tumor;
	private final ModelPart Tumor2;
	private final ModelPart Tumor3;
	private final ModelPart Tumor4;
	private final ModelPart Tumor5;
	private final ModelPart Tumor6;
	private final ModelPart Tumor7;
	private final ModelPart Tumor8;
	private final ModelPart Tumors2;
	private final ModelPart Tumor10;
	private final ModelPart Tumor12;
	private final ModelPart Tumor13;
	private final ModelPart Tumor14;
	private final ModelPart Tumor15;
	private final ModelPart ribcage;
	private final ModelPart rib;
	private final ModelPart rib2;
	private final ModelPart rib3;
	private final ModelPart rib4;
	private final ModelPart CenterBody7;
	private final ModelPart CenterBody8;
	private final ModelPart CenterBody9;

	public LeviathanMiddleSegment() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.LeviathanAbdomen = root.getChild("LeviathanAbdomen");
		this.Base = this.LeviathanAbdomen.getChild("Base");
		this.fin = this.Base.getChild("fin");
		this.CenterCorpseDetails = this.Base.getChild("CenterCorpseDetails");
		this.CenterBody1 = this.CenterCorpseDetails.getChild("CenterBody1");
		this.CenterBody2 = this.CenterCorpseDetails.getChild("CenterBody2");
		this.CenterBody4 = this.CenterCorpseDetails.getChild("CenterBody4");
		this.CenterCorpseDetails2 = this.Base.getChild("CenterCorpseDetails2");
		this.CenterBody3 = this.CenterCorpseDetails2.getChild("CenterBody3");
		this.CenterBody5 = this.CenterCorpseDetails2.getChild("CenterBody5");
		this.CenterBody6 = this.CenterCorpseDetails2.getChild("CenterBody6");
		this.CenterCorpseDetails4 = this.Base.getChild("CenterCorpseDetails4");
		this.CenterBody13 = this.CenterCorpseDetails4.getChild("CenterBody13");
		this.CenterBody14 = this.CenterCorpseDetails4.getChild("CenterBody14");
		this.CenterBody15 = this.CenterCorpseDetails4.getChild("CenterBody15");
		this.CenterBody16 = this.CenterCorpseDetails4.getChild("CenterBody16");
		this.Tumors = this.Base.getChild("Tumors");
		this.Tumor = this.Tumors.getChild("Tumor");
		this.Tumor2 = this.Tumors.getChild("Tumor2");
		this.Tumor3 = this.Tumors.getChild("Tumor3");
		this.Tumor4 = this.Tumors.getChild("Tumor4");
		this.Tumor5 = this.Tumors.getChild("Tumor5");
		this.Tumor6 = this.Tumors.getChild("Tumor6");
		this.Tumor7 = this.Tumors.getChild("Tumor7");
		this.Tumor8 = this.Tumors.getChild("Tumor8");
		this.Tumors2 = this.Base.getChild("Tumors2");
		this.Tumor10 = this.Tumors2.getChild("Tumor10");
		this.Tumor12 = this.Tumors2.getChild("Tumor12");
		this.Tumor13 = this.Tumors2.getChild("Tumor13");
		this.Tumor14 = this.Tumors2.getChild("Tumor14");
		this.Tumor15 = this.Tumors2.getChild("Tumor15");
		this.ribcage = this.Base.getChild("ribcage");
		this.rib = this.ribcage.getChild("rib");
		this.rib2 = this.ribcage.getChild("rib2");
		this.rib3 = this.ribcage.getChild("rib3");
		this.rib4 = this.ribcage.getChild("rib4");
		this.CenterBody7 = this.ribcage.getChild("CenterBody7");
		this.CenterBody8 = this.ribcage.getChild("CenterBody8");
		this.CenterBody9 = this.ribcage.getChild("CenterBody9");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition LeviathanAbdomen = partdefinition.addOrReplaceChild("LeviathanAbdomen", CubeListBuilder.create(), PartPose.offset(0.0F, 31.0F, 0.0F));

		PartDefinition Base = LeviathanAbdomen.addOrReplaceChild("Base", CubeListBuilder.create(), PartPose.offset(-8.0F, -50.0F, 1.0F));

		PartDefinition front_r1 = Base.addOrReplaceChild("front_r1", CubeListBuilder.create().texOffs(194, 322).addBox(-1.0F, 19.0F, -1.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.0F, 7.0F, 18.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r2 = Base.addOrReplaceChild("front_r2", CubeListBuilder.create().texOffs(160, 321).addBox(-1.0F, 19.0F, -1.0F, 5.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, 7.0F, -28.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r3 = Base.addOrReplaceChild("front_r3", CubeListBuilder.create().texOffs(306, 168).addBox(-1.0F, 13.0F, -1.0F, 17.0F, 20.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.0F, 18.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition front_r4 = Base.addOrReplaceChild("front_r4", CubeListBuilder.create().texOffs(308, 306).addBox(-1.0F, 13.0F, -1.0F, 17.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, -27.0F, 0.0436F, 0.0436F, 0.2182F));

		PartDefinition s_r1 = Base.addOrReplaceChild("s_r1", CubeListBuilder.create().texOffs(0, 54).addBox(-21.0F, 0.0F, -28.0F, 22.0F, 4.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.9653F, 14.7965F, -0.0603F, -0.1262F, 0.0715F, -1.36F));

		PartDefinition s_r2 = Base.addOrReplaceChild("s_r2", CubeListBuilder.create().texOffs(0, 107).addBox(-3.5114F, -27.7797F, -25.923F, 20.0F, 5.0F, 49.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0183F, 41.2622F, -0.9557F, 0.066F, 0.0418F, 0.1702F));

		PartDefinition s2_r1 = Base.addOrReplaceChild("s2_r1", CubeListBuilder.create().texOffs(214, 212).addBox(-0.5F, 4.0F, 0.0F, 17.0F, 4.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.4901F, 15.9404F, -4.5601F, -0.0528F, 0.0879F, 1.1755F));

		PartDefinition s1_r1 = Base.addOrReplaceChild("s1_r1", CubeListBuilder.create().texOffs(130, 212).addBox(0.5F, 0.0F, -2.0F, 16.0F, 4.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.9209F, 18.5215F, -28.1892F, 0.209F, 0.0442F, 1.1759F));

		PartDefinition s_r3 = Base.addOrReplaceChild("s_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-15.5525F, 24.9337F, -25.5293F, 24.0F, 4.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9817F, 11.2622F, -2.9557F, 0.0494F, 0.1308F, 0.044F));

		PartDefinition s_r4 = Base.addOrReplaceChild("s_r4", CubeListBuilder.create().texOffs(142, 54).addBox(-3.6818F, 21.2121F, -25.5293F, 11.0F, 4.0F, 48.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0183F, 19.2622F, -0.9557F, -0.0887F, 0.0964F, -0.746F));

		PartDefinition fin = Base.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offsetAndRotation(7.75F, 42.75F, -9.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r1 = fin.addOrReplaceChild("FinMembrane1_r1", CubeListBuilder.create().texOffs(256, 152).addBox(0.25F, -18.0F, -2.0F, 0.0F, 19.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -28.0F, -7.0F, 0.1833F, 0.0F, 0.0F));

		PartDefinition FinMembrane1_r2 = fin.addOrReplaceChild("FinMembrane1_r2", CubeListBuilder.create().texOffs(42, 270).addBox(-0.01F, -18.0F, -2.0F, 0.0F, 19.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -25.0F, 0.4887F, 0.0F, 0.0F));

		PartDefinition FinSupport_r1 = fin.addOrReplaceChild("FinSupport_r1", CubeListBuilder.create().texOffs(431, 67).addBox(-1.0F, -16.0F, -2.0F, 2.0F, 17.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -36.0F, 17.0F, 0.3578F, 0.0F, 0.0F));

		PartDefinition FinSupport_r2 = fin.addOrReplaceChild("FinSupport_r2", CubeListBuilder.create().texOffs(425, 64).addBox(-1.0F, -20.0F, -2.0F, 2.0F, 21.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -27.0F, -7.0F, 0.3578F, 0.0F, 0.0F));

		PartDefinition FinSupport_r3 = fin.addOrReplaceChild("FinSupport_r3", CubeListBuilder.create().texOffs(426, 69).addBox(-1.0F, -12.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -18.0F, -27.0F, 0.576F, 0.0F, 0.0F));

		PartDefinition CenterCorpseDetails = Base.addOrReplaceChild("CenterCorpseDetails", CubeListBuilder.create(), PartPose.offsetAndRotation(14.6727F, 20.75F, -12.7033F, 2.8158F, 1.368F, 1.5519F));

		PartDefinition CenterBody1 = CenterCorpseDetails.addOrReplaceChild("CenterBody1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r1 = CenterBody1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r1 = CenterBody1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r1 = CenterBody1.addOrReplaceChild("TorsoTop_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody2 = CenterCorpseDetails.addOrReplaceChild("CenterBody2", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.0F, -16.0F, 0.0F, -0.829F, 0.0F, 0.829F));

		PartDefinition Arm_r2 = CenterBody2.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r3 = CenterBody2.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r1 = CenterBody2.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r2 = CenterBody2.addOrReplaceChild("TorsoBottom_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r2 = CenterBody2.addOrReplaceChild("TorsoTop_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody4 = CenterCorpseDetails.addOrReplaceChild("CenterBody4", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r1 = CenterBody4.addOrReplaceChild("TorsoBase_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r4 = CenterBody4.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.4569F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r5 = CenterBody4.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(480, 5).addBox(0.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r3 = CenterBody4.addOrReplaceChild("TorsoTop_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r2 = CenterBody4.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails2 = Base.addOrReplaceChild("CenterCorpseDetails2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6727F, 15.75F, -27.7033F, -2.3329F, 1.6298F, 1.5519F));

		PartDefinition CenterBody3 = CenterCorpseDetails2.addOrReplaceChild("CenterBody3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Arm_r6 = CenterBody3.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2286F, -14.7844F, 3.5737F, 0.7665F, -0.1875F, -0.2367F));

		PartDefinition Head_r3 = CenterBody3.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.9319F, -17.8684F, -2.7962F, 0.2921F, 0.0905F, 0.2751F));

		PartDefinition TorsoTop_r4 = CenterBody3.addOrReplaceChild("TorsoTop_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition CenterBody5 = CenterCorpseDetails2.addOrReplaceChild("CenterBody5", CubeListBuilder.create(), PartPose.offsetAndRotation(-24.0F, -16.0F, 0.0F, -0.829F, 0.0F, 0.829F));

		PartDefinition Arm_r7 = CenterBody5.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r8 = CenterBody5.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r3 = CenterBody5.addOrReplaceChild("TorsoBottom_r3", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r4 = CenterBody5.addOrReplaceChild("TorsoBottom_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r5 = CenterBody5.addOrReplaceChild("TorsoTop_r5", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody6 = CenterCorpseDetails2.addOrReplaceChild("CenterBody6", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.75F, -19.1707F, -4.6424F, 0.6149F, 0.6324F, 0.0871F));

		PartDefinition TorsoBase_r2 = CenterBody6.addOrReplaceChild("TorsoBase_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8042F, 2.1988F, 3.3066F, -0.7795F, 0.461F, 0.0476F));

		PartDefinition Arm_r9 = CenterBody6.addOrReplaceChild("Arm_r9", CubeListBuilder.create().texOffs(480, 5).addBox(-1.919F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.457F, -0.9938F, -2.204F, -1.0611F, -0.2558F, 0.192F));

		PartDefinition Arm_r10 = CenterBody6.addOrReplaceChild("Arm_r10", CubeListBuilder.create().texOffs(480, 5).addBox(0.0019F, -1.0747F, -1.1123F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.2454F, -2.6507F, -4.0053F, -0.3089F, 0.9815F, -0.0943F));

		PartDefinition TorsoTop_r6 = CenterBody6.addOrReplaceChild("TorsoTop_r6", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, 0.27F, -0.1446F));

		PartDefinition Head_r4 = CenterBody6.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.1049F, -3.9697F, -7.4599F, -1.2101F, -0.0972F, -0.2852F));

		PartDefinition CenterCorpseDetails4 = Base.addOrReplaceChild("CenterCorpseDetails4", CubeListBuilder.create(), PartPose.offsetAndRotation(17.3273F, 17.75F, -7.7033F, 0.3681F, -1.3637F, 0.627F));

		PartDefinition CenterBody13 = CenterCorpseDetails4.addOrReplaceChild("CenterBody13", CubeListBuilder.create(), PartPose.offset(-16.1542F, 19.5031F, 2.5825F));

		PartDefinition Arm_r11 = CenterBody13.addOrReplaceChild("Arm_r11", CubeListBuilder.create().texOffs(480, 5).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r5 = CenterBody13.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r7 = CenterBody13.addOrReplaceChild("TorsoTop_r7", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody14 = CenterCorpseDetails4.addOrReplaceChild("CenterBody14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.8458F, -1.4968F, 2.5825F, 0.0F, 0.0F, -0.3054F));

		PartDefinition Arm_r12 = CenterBody14.addOrReplaceChild("Arm_r12", CubeListBuilder.create().texOffs(480, 5).addBox(-2.6989F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8291F, -2.1266F, -2.0948F, 0.1321F, 0.6937F, 0.6672F));

		PartDefinition Arm_r13 = CenterBody14.addOrReplaceChild("Arm_r13", CubeListBuilder.create().texOffs(480, 5).addBox(-0.9834F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.33F, 0.0543F, -8.3035F, -0.705F, 0.9349F, 0.0071F));

		PartDefinition TorsoBottom_r5 = CenterBody14.addOrReplaceChild("TorsoBottom_r5", CubeListBuilder.create().texOffs(480, 5).addBox(-3.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.885F, 4.8781F, -1.2293F, 0.4207F, 1.4447F, 1.2856F));

		PartDefinition TorsoBottom_r6 = CenterBody14.addOrReplaceChild("TorsoBottom_r6", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5228F, 2.6983F, 0.7538F, -0.7071F, 0.6554F, 0.1855F));

		PartDefinition TorsoTop_r8 = CenterBody14.addOrReplaceChild("TorsoTop_r8", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4556F, 0.0F, -3.7013F, -0.358F, 0.6554F, 0.1855F));

		PartDefinition CenterBody15 = CenterCorpseDetails4.addOrReplaceChild("CenterBody15", CubeListBuilder.create(), PartPose.offsetAndRotation(16.3514F, 2.1633F, -0.7311F, -0.3117F, -0.2063F, -1.1981F));

		PartDefinition Leg_r1 = CenterBody15.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(480, 5).addBox(-1.6379F, -0.8419F, -1.5864F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4032F, 4.7879F, 2.3728F, -0.0397F, 0.0241F, 0.177F));

		PartDefinition Leg_r2 = CenterBody15.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(480, 5).addBox(-1.7242F, -0.3457F, -1.5F, 3.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.773F, 5.0385F, -2.4364F, -0.2132F, 0.0469F, 0.2132F));

		PartDefinition Arm_r14 = CenterBody15.addOrReplaceChild("Arm_r14", CubeListBuilder.create().texOffs(480, 5).addBox(-2.164F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.2342F, -6.4446F, 2.8873F, 2.007F, -0.9774F, -0.5593F));

		PartDefinition TorsoTop_r9 = CenterBody15.addOrReplaceChild("TorsoTop_r9", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0056F, -0.6602F, -0.6864F, 0.2921F, 0.0905F, -0.2921F));

		PartDefinition TorsoBase_r3 = CenterBody15.addOrReplaceChild("TorsoBase_r3", CubeListBuilder.create().texOffs(480, 5).addBox(-1.25F, -4.0F, -3.75F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4944F, 3.3398F, -0.1864F, 0.0411F, 0.3027F, -0.2555F));

		PartDefinition CenterBody16 = CenterCorpseDetails4.addOrReplaceChild("CenterBody16", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.4042F, 0.3325F, -2.0599F, 0.6149F, -0.6324F, -0.0871F));

		PartDefinition TorsoBase_r4 = CenterBody16.addOrReplaceChild("TorsoBase_r4", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -0.5F, -3.25F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8042F, 2.1988F, 3.3066F, -0.7795F, -0.461F, -0.0476F));

		PartDefinition Arm_r15 = CenterBody16.addOrReplaceChild("Arm_r15", CubeListBuilder.create().texOffs(480, 5).addBox(-1.081F, -2.3302F, -0.9665F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.4569F, -0.9938F, -2.204F, -1.0611F, 0.2558F, -0.192F));

		PartDefinition Arm_r16 = CenterBody16.addOrReplaceChild("Arm_r16", CubeListBuilder.create().texOffs(480, 5).addBox(-3.0019F, -1.0747F, -1.1122F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.2454F, -2.6507F, -4.0053F, -0.3089F, -0.9815F, 0.0943F));

		PartDefinition TorsoTop_r10 = CenterBody16.addOrReplaceChild("TorsoTop_r10", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -3.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -2.0F, -0.4996F, -0.27F, 0.1446F));

		PartDefinition Head_r6 = CenterBody16.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(480, 5).addBox(-4.5F, -4.75F, -3.5F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1049F, -3.9697F, -7.46F, -1.2101F, 0.0972F, 0.2852F));

		PartDefinition Tumors = Base.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offset(8.0F, 43.0F, -39.0F));

		PartDefinition Tumor = Tumors.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -11.0F, 57.0F, 0.0F, 0.0F, -1.3963F));

		PartDefinition Biomass_r1 = Tumor.addOrReplaceChild("Biomass_r1", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r2 = Tumor.addOrReplaceChild("Biomass_r2", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r3 = Tumor.addOrReplaceChild("Biomass_r3", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r4 = Tumor.addOrReplaceChild("Biomass_r4", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor2 = Tumors.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -13.0F, 22.0F, 0.7209F, 0.544F, -0.4887F));

		PartDefinition Biomass_r5 = Tumor2.addOrReplaceChild("Biomass_r5", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r6 = Tumor2.addOrReplaceChild("Biomass_r6", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r7 = Tumor2.addOrReplaceChild("Biomass_r7", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r8 = Tumor2.addOrReplaceChild("Biomass_r8", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor3 = Tumors.addOrReplaceChild("Tumor3", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -9.0F, 41.0F, 0.0F, 0.0F, -1.6144F));

		PartDefinition Biomass_r9 = Tumor3.addOrReplaceChild("Biomass_r9", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r10 = Tumor3.addOrReplaceChild("Biomass_r10", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r11 = Tumor3.addOrReplaceChild("Biomass_r11", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r12 = Tumor3.addOrReplaceChild("Biomass_r12", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor4 = Tumors.addOrReplaceChild("Tumor4", CubeListBuilder.create(), PartPose.offset(2.0F, -14.0F, 24.0F));

		PartDefinition Biomass_r13 = Tumor4.addOrReplaceChild("Biomass_r13", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r14 = Tumor4.addOrReplaceChild("Biomass_r14", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r15 = Tumor4.addOrReplaceChild("Biomass_r15", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r16 = Tumor4.addOrReplaceChild("Biomass_r16", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor5 = Tumors.addOrReplaceChild("Tumor5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, -22.0F, 15.0F, 0.0F, 1.0472F, 0.0F));

		PartDefinition Biomass_r17 = Tumor5.addOrReplaceChild("Biomass_r17", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, -3.3655F, 0.2392F, 0.0133F, 0.3783F));

		PartDefinition Biomass_r18 = Tumor5.addOrReplaceChild("Biomass_r18", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, -1.4774F, 1.361F, -0.0565F, 1.1111F));

		PartDefinition Biomass_r19 = Tumor5.addOrReplaceChild("Biomass_r19", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, 5.4146F, 0.4094F, -0.4032F, 0.6728F));

		PartDefinition Biomass_r20 = Tumor5.addOrReplaceChild("Biomass_r20", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, -12.4651F, -0.5151F, -0.3039F, -0.5625F));

		PartDefinition Tumor6 = Tumors.addOrReplaceChild("Tumor6", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -25.0F, 15.0F, 0.6523F, -0.908F, -1.2913F));

		PartDefinition Biomass_r21 = Tumor6.addOrReplaceChild("Biomass_r21", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r22 = Tumor6.addOrReplaceChild("Biomass_r22", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r23 = Tumor6.addOrReplaceChild("Biomass_r23", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r24 = Tumor6.addOrReplaceChild("Biomass_r24", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor7 = Tumors.addOrReplaceChild("Tumor7", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.0F, -9.0F, 17.0F, -1.2217F, -0.9163F, 0.1745F));

		PartDefinition Biomass_r25 = Tumor7.addOrReplaceChild("Biomass_r25", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r26 = Tumor7.addOrReplaceChild("Biomass_r26", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r27 = Tumor7.addOrReplaceChild("Biomass_r27", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r28 = Tumor7.addOrReplaceChild("Biomass_r28", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumor8 = Tumors.addOrReplaceChild("Tumor8", CubeListBuilder.create(), PartPose.offsetAndRotation(-14.0F, -9.0F, 35.0F, 1.7453F, 0.0F, -1.6144F));

		PartDefinition Biomass_r29 = Tumor8.addOrReplaceChild("Biomass_r29", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, -6.3655F, 0.2392F, -0.0133F, -0.3783F));

		PartDefinition Biomass_r30 = Tumor8.addOrReplaceChild("Biomass_r30", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, -1.4774F, 1.361F, 0.0565F, -1.1111F));

		PartDefinition Biomass_r31 = Tumor8.addOrReplaceChild("Biomass_r31", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -5.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, 5.4146F, 0.4094F, 0.4032F, -0.6728F));

		PartDefinition Biomass_r32 = Tumor8.addOrReplaceChild("Biomass_r32", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, 7.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, -12.4651F, -0.5151F, 0.3039F, 0.5625F));

		PartDefinition Tumors2 = Base.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offsetAndRotation(8.0F, 29.0F, 34.0F, 0.3927F, -0.2182F, -2.3998F));

		PartDefinition Tumor10 = Tumors2.addOrReplaceChild("Tumor10", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -19.0F, -5.0F, -0.7209F, -0.544F, -0.4887F));

		PartDefinition Biomass_r33 = Tumor10.addOrReplaceChild("Biomass_r33", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, 6.3655F, -0.2392F, 0.0133F, -0.3783F));

		PartDefinition Biomass_r34 = Tumor10.addOrReplaceChild("Biomass_r34", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, 1.4774F, -1.361F, -0.0565F, -1.1111F));

		PartDefinition Biomass_r35 = Tumor10.addOrReplaceChild("Biomass_r35", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, -5.4146F, -0.4094F, -0.4032F, -0.6728F));

		PartDefinition Biomass_r36 = Tumor10.addOrReplaceChild("Biomass_r36", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, -16.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, 12.4651F, 0.5151F, -0.3039F, 0.5625F));

		PartDefinition Tumor12 = Tumors2.addOrReplaceChild("Tumor12", CubeListBuilder.create(), PartPose.offset(2.0F, -11.0F, -20.0F));

		PartDefinition Biomass_r37 = Tumor12.addOrReplaceChild("Biomass_r37", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, 3.3655F, -0.2392F, -0.0133F, 0.3783F));

		PartDefinition Biomass_r38 = Tumor12.addOrReplaceChild("Biomass_r38", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, 1.4774F, -1.361F, 0.0565F, 1.1111F));

		PartDefinition Biomass_r39 = Tumor12.addOrReplaceChild("Biomass_r39", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, -5.4146F, -0.4094F, 0.4032F, 0.6728F));

		PartDefinition Biomass_r40 = Tumor12.addOrReplaceChild("Biomass_r40", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, -16.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, 12.4651F, 0.5151F, 0.3039F, -0.5625F));

		PartDefinition Tumor13 = Tumors2.addOrReplaceChild("Tumor13", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, -22.0F, -15.0F, 0.0F, -1.0472F, 0.0F));

		PartDefinition Biomass_r41 = Tumor13.addOrReplaceChild("Biomass_r41", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8993F, 6.144F, 3.3655F, -0.2392F, -0.0133F, 0.3783F));

		PartDefinition Biomass_r42 = Tumor13.addOrReplaceChild("Biomass_r42", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0165F, 10.4807F, 1.4774F, -1.361F, 0.0565F, 1.1111F));

		PartDefinition Biomass_r43 = Tumor13.addOrReplaceChild("Biomass_r43", CubeListBuilder.create().texOffs(457, 32).addBox(-11.0F, -3.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.4747F, 7.9019F, -5.4146F, -0.4094F, 0.4032F, 0.6728F));

		PartDefinition Biomass_r44 = Tumor13.addOrReplaceChild("Biomass_r44", CubeListBuilder.create().texOffs(457, 32).addBox(-1.0F, -5.0F, -16.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.391F, -3.5788F, 12.4651F, 0.5151F, 0.3039F, -0.5625F));

		PartDefinition Tumor14 = Tumors2.addOrReplaceChild("Tumor14", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0F, -8.0F, -15.0F, -0.6523F, 0.908F, -1.2913F));

		PartDefinition Biomass_r45 = Tumor14.addOrReplaceChild("Biomass_r45", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, 6.3655F, -0.2392F, 0.0133F, -0.3783F));

		PartDefinition Biomass_r46 = Tumor14.addOrReplaceChild("Biomass_r46", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0165F, 10.4807F, 1.4774F, -1.361F, -0.0565F, -1.1111F));

		PartDefinition Biomass_r47 = Tumor14.addOrReplaceChild("Biomass_r47", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 7.9019F, -5.4146F, -0.4094F, -0.4032F, -0.6728F));

		PartDefinition Biomass_r48 = Tumor14.addOrReplaceChild("Biomass_r48", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, -16.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.391F, -3.5788F, 12.4651F, 0.5151F, -0.3039F, 0.5625F));

		PartDefinition Tumor15 = Tumors2.addOrReplaceChild("Tumor15", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -3.0F, -24.0F, 0.7418F, 0.9163F, 0.1745F));

		PartDefinition Biomass_r49 = Tumor15.addOrReplaceChild("Biomass_r49", CubeListBuilder.create().texOffs(457, 32).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.8993F, 6.144F, 6.3655F, -0.2392F, 0.0133F, -0.3783F));

		PartDefinition Biomass_r50 = Tumor15.addOrReplaceChild("Biomass_r50", CubeListBuilder.create().texOffs(457, 32).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9835F, 10.4807F, 1.4774F, -1.361F, -0.0565F, -1.1111F));

		PartDefinition Biomass_r51 = Tumor15.addOrReplaceChild("Biomass_r51", CubeListBuilder.create().texOffs(457, 32).addBox(3.0F, -3.0F, -3.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.4747F, 5.9019F, -5.4146F, -0.4094F, -0.4032F, -0.6728F));

		PartDefinition Biomass_r52 = Tumor15.addOrReplaceChild("Biomass_r52", CubeListBuilder.create().texOffs(457, 32).addBox(-8.0F, -5.0F, -16.0F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.391F, -3.5788F, 12.4651F, 0.5151F, -0.3039F, 0.5625F));

		PartDefinition ribcage = Base.addOrReplaceChild("ribcage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Base_r1 = ribcage.addOrReplaceChild("Base_r1", CubeListBuilder.create().texOffs(445, 76).addBox(-11.0F, -7.0F, -1.0F, 7.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.5F, 48.0F, -1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition Base_r2 = ribcage.addOrReplaceChild("Base_r2", CubeListBuilder.create().texOffs(444, 76).addBox(-12.0F, -7.0F, -1.0F, 8.0F, 7.0F, 26.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, 43.0F, -26.75F, -0.2182F, 0.0F, 0.0F));

		PartDefinition rib = ribcage.addOrReplaceChild("rib", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition plane_r1 = rib.addOrReplaceChild("plane_r1", CubeListBuilder.create().texOffs(487, 118).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(23.5F, 21.7783F, 8.4721F, 0.0F, 1.5708F, 0.4363F));

		PartDefinition rBase_r1 = rib.addOrReplaceChild("rBase_r1", CubeListBuilder.create().texOffs(432, 117).addBox(-0.1802F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2367F, 43.2172F, 8.9356F, 0.211F, 0.056F, -0.2559F));

		PartDefinition rBase_r2 = rib.addOrReplaceChild("rBase_r2", CubeListBuilder.create().texOffs(436, 121).addBox(-0.1802F, -2.3233F, -1.4297F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.7367F, 28.2172F, 7.9356F, -0.0279F, 0.0042F, -1.7837F));

		PartDefinition rBase_r3 = rib.addOrReplaceChild("rBase_r3", CubeListBuilder.create().texOffs(432, 117).addBox(-0.1802F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.2367F, 40.2172F, 7.9356F, -0.0196F, -0.067F, -1.1276F));

		PartDefinition rib2 = ribcage.addOrReplaceChild("rib2", CubeListBuilder.create(), PartPose.offset(-1.0F, 0.0F, -28.0F));

		PartDefinition plane_r2 = rib2.addOrReplaceChild("plane_r2", CubeListBuilder.create().texOffs(487, 118).addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(22.75F, 20.7783F, 7.4721F, -1.5708F, 1.2217F, -1.1345F));

		PartDefinition rBase_r4 = rib2.addOrReplaceChild("rBase_r4", CubeListBuilder.create().texOffs(432, 117).addBox(-0.1802F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.2367F, 43.2172F, 8.9356F, -0.3158F, 0.2488F, -0.2267F));

		PartDefinition rBase_r5 = rib2.addOrReplaceChild("rBase_r5", CubeListBuilder.create().texOffs(436, 121).addBox(-0.1802F, -2.3233F, -1.4297F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.7367F, 28.2172F, 5.9356F, 0.059F, -0.2575F, -1.7351F));

		PartDefinition rBase_r6 = rib2.addOrReplaceChild("rBase_r6", CubeListBuilder.create().texOffs(432, 117).addBox(-0.1802F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.2367F, 40.2172F, 6.9356F, -0.2378F, -0.067F, -1.1276F));

		PartDefinition rib3 = ribcage.addOrReplaceChild("rib3", CubeListBuilder.create(), PartPose.offset(11.0F, 0.0F, -4.0F));

		PartDefinition plane_r3 = rib3.addOrReplaceChild("plane_r3", CubeListBuilder.create().texOffs(487, 118).mirror().addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.75F, 19.7783F, 6.4721F, 1.1345F, -1.4835F, -1.5708F));

		PartDefinition rBase_r7 = rib3.addOrReplaceChild("rBase_r7", CubeListBuilder.create().texOffs(432, 117).mirror().addBox(-13.8198F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-7.2367F, 43.2172F, 8.9356F, 0.3419F, -0.056F, 0.2559F));

		PartDefinition rBase_r8 = rib3.addOrReplaceChild("rBase_r8", CubeListBuilder.create().texOffs(436, 121).mirror().addBox(-13.8198F, -2.3233F, -1.4297F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.7367F, 28.2172F, 6.4356F, -0.0463F, -0.0895F, 1.7845F));

		PartDefinition rBase_r9 = rib3.addOrReplaceChild("rBase_r9", CubeListBuilder.create().texOffs(432, 117).mirror().addBox(-13.8198F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.2367F, 40.2172F, 7.9356F, -0.0196F, -0.0639F, 1.1302F));

		PartDefinition rib4 = ribcage.addOrReplaceChild("rib4", CubeListBuilder.create(), PartPose.offset(11.0F, 0.0F, -31.0F));

		PartDefinition plane_r4 = rib4.addOrReplaceChild("plane_r4", CubeListBuilder.create().texOffs(487, 118).mirror().addBox(0.0F, -11.8474F, -5.4995F, 0.0F, 16.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-24.25F, 20.7783F, 8.2221F, 1.1345F, -1.4835F, -1.7017F));

		PartDefinition rBase_r10 = rib4.addOrReplaceChild("rBase_r10", CubeListBuilder.create().texOffs(432, 117).mirror().addBox(-13.8198F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.2367F, 41.9672F, 8.9356F, -0.3031F, -0.0958F, 0.1308F));

		PartDefinition rBase_r11 = rib4.addOrReplaceChild("rBase_r11", CubeListBuilder.create().texOffs(436, 121).mirror().addBox(-13.8198F, -2.3233F, -1.4297F, 14.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-26.2367F, 29.2172F, 8.1856F, -0.0463F, -0.0895F, 1.6536F));

		PartDefinition rBase_r12 = rib4.addOrReplaceChild("rBase_r12", CubeListBuilder.create().texOffs(432, 117).mirror().addBox(-13.8198F, -2.3233F, -4.4297F, 14.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-21.2367F, 40.2172F, 7.9356F, -0.1068F, 0.0667F, 1.139F));

		PartDefinition CenterBody7 = ribcage.addOrReplaceChild("CenterBody7", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1731F, 46.2531F, -13.1208F, 1.7402F, -0.2533F, -1.6739F));

		PartDefinition Arm_r17 = CenterBody7.addOrReplaceChild("Arm_r17", CubeListBuilder.create().texOffs(480, 5).addBox(-0.836F, -1.3941F, -1.1477F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.2286F, -14.7844F, 3.5737F, 0.7665F, 0.1875F, 0.2367F));

		PartDefinition Head_r7 = CenterBody7.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.9319F, -17.8684F, -2.7962F, 0.2921F, -0.0905F, -0.2751F));

		PartDefinition TorsoTop_r11 = CenterBody7.addOrReplaceChild("TorsoTop_r11", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0F, -6.0F, -4.0F, 4.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, 0.0F, 0.2921F, -0.0905F, 0.2921F));

		PartDefinition CenterBody8 = ribcage.addOrReplaceChild("CenterBody8", CubeListBuilder.create(), PartPose.offsetAndRotation(8.6727F, 46.75F, -12.7033F, 2.8779F, 0.8548F, -1.2853F));

		PartDefinition Arm_r18 = CenterBody8.addOrReplaceChild("Arm_r18", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r19 = CenterBody8.addOrReplaceChild("Arm_r19", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r7 = CenterBody8.addOrReplaceChild("TorsoBottom_r7", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, 0.4207F, -1.4447F, -1.2856F));

		PartDefinition TorsoBottom_r8 = CenterBody8.addOrReplaceChild("TorsoBottom_r8", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r12 = CenterBody8.addOrReplaceChild("TorsoTop_r12", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		PartDefinition CenterBody9 = ribcage.addOrReplaceChild("CenterBody9", CubeListBuilder.create(), PartPose.offsetAndRotation(4.6727F, 46.0F, 5.2967F, -0.5392F, -0.5798F, -2.0188F));

		PartDefinition Arm_r20 = CenterBody9.addOrReplaceChild("Arm_r20", CubeListBuilder.create().texOffs(480, 5).addBox(-0.3011F, -1.6115F, -0.7522F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.8291F, -2.1266F, -2.0948F, 0.1321F, -0.6937F, -0.6672F));

		PartDefinition Arm_r21 = CenterBody9.addOrReplaceChild("Arm_r21", CubeListBuilder.create().texOffs(480, 5).addBox(-2.0166F, -1.7605F, -0.99F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.33F, 0.0543F, -8.3035F, -0.705F, -0.9349F, -0.0071F));

		PartDefinition TorsoBottom_r9 = CenterBody9.addOrReplaceChild("TorsoBottom_r9", CubeListBuilder.create().texOffs(480, 5).addBox(0.6473F, -0.2111F, -1.0111F, 3.0F, 3.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.885F, 4.8781F, -1.2293F, -0.2736F, -0.2702F, -1.0498F));

		PartDefinition TorsoBottom_r10 = CenterBody9.addOrReplaceChild("TorsoBottom_r10", CubeListBuilder.create().texOffs(480, 5).addBox(-3.5F, -1.0F, -3.5F, 7.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5228F, 2.6983F, 0.7538F, -0.7071F, -0.6554F, -0.1855F));

		PartDefinition TorsoTop_r13 = CenterBody9.addOrReplaceChild("TorsoTop_r13", CubeListBuilder.create().texOffs(480, 5).addBox(-4.0F, -2.0F, -3.0F, 8.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4556F, 0.0F, -3.7013F, -0.358F, -0.6554F, -0.1855F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float tumorVal1 = Mth.sin(ageInTicks/6)/6;
		float tumorVal2 = Mth.cos(ageInTicks/6)/7;
		float tumorVal3 = Mth.sin(ageInTicks/6)/8;
		float tumorVal5 = Mth.sin(ageInTicks/8)/6;
		animateTumor(Tumor,tumorVal1);
		animateTumor(Tumor2,tumorVal3);
		animateTumor(Tumor3,tumorVal2);
		animateTumor(Tumor4,tumorVal5);
		animateTumor(Tumor8,tumorVal1);
		animateTumor(Tumor12,tumorVal5);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r, float g, float b, float alpha) {
		LeviathanAbdomen.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}
}