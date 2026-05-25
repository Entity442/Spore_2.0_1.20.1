package com.Harbinger.Spore.Client.Models;
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
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

public class FungalDragonBodyModel<T extends Verfalldrachen> extends EntityModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "fungaldragonbodymodel"), "main");
	private final ModelPart Ribcage;
	private final ModelPart body;
	private final ModelPart rib6;
	private final ModelPart rib5;
	private final ModelPart body3;
	private final ModelPart TFHead;
	private final ModelPart TFJaw;
	private final ModelPart rib4;
	private final ModelPart rib3;
	private final ModelPart rib2;
	private final ModelPart rib;
	private final ModelPart Tumors10;
	private final ModelPart Tumors9;
	private final ModelPart Tumors8;
	private final ModelPart mass7;
	private final ModelPart mass8;
	private final ModelPart mass9;
	private final ModelPart Body1;
	private final ModelPart Body4;
	private final ModelPart Body5;
	private final ModelPart Body6;
	private final ModelPart Body7;
	private final ModelPart Tumors7;
	private final ModelPart Spine;
	private final ModelPart Segment;
	private final ModelPart Segment2;
	private final ModelPart Segment3;
	private final ModelPart Segment4;
	private final ModelPart body40;
	private final ModelPart head37;
	private final ModelPart RightArm39;
	private final ModelPart LeftArm38;
	private final ModelPart Segment5;
	private final ModelPart Segment6;
	private final ModelPart back;
	private final ModelPart rib12;
	private final ModelPart rib11;
	private final ModelPart rib10;
	private final ModelPart rib7;
	private final ModelPart rib8;
	private final ModelPart rib9;
	private final ModelPart MajoTarSack;
	private final ModelPart MajoTarSack2;
	private final ModelPart LeftBackLeg;
	private final ModelPart LeftBack;
	private final ModelPart flower14;
	private final ModelPart body17;
	private final ModelPart head12;
	private final ModelPart RightArm16;
	private final ModelPart RightForArm16;
	private final ModelPart LeftArm15;
	private final ModelPart LeftForArm15;
	private final ModelPart Left;
	private final ModelPart flower7;
	private final ModelPart flower2;
	private final ModelPart Left2;
	private final ModelPart LeftFoot;
	private final ModelPart Infectedarm95;
	private final ModelPart Infectedarm96;
	private final ModelPart Infectedarm11;
	private final ModelPart Infectedarm12;
	private final ModelPart Infectedarm9;
	private final ModelPart Infectedarm10;
	private final ModelPart Infectedbody43;
	private final ModelPart Infectedbody44;
	private final ModelPart Infectedbody45;
	private final ModelPart Infectedbody46;
	private final ModelPart Infectedbody47;
	private final ModelPart Infectedbody96;
	private final ModelPart Infectedbody97;
	private final ModelPart RightBackLeg;
	private final ModelPart RightBack;
	private final ModelPart Infectedbody2;
	private final ModelPart Infectedbody50;
	private final ModelPart Infectedbody54;
	private final ModelPart Right;
	private final ModelPart Infectedbody3;
	private final ModelPart Infectedbody4;
	private final ModelPart Right2;
	private final ModelPart body30;
	private final ModelPart head27;
	private final ModelPart RightArm29;
	private final ModelPart RightForArm29;
	private final ModelPart LeftArm28;
	private final ModelPart LeftForArm28;
	private final ModelPart Right3;
	private final ModelPart body2;
	private final ModelPart head2;
	private final ModelPart RightArm2;
	private final ModelPart RightForArm2;
	private final ModelPart LeftArm2;
	private final ModelPart LeftForArm2;
	private final ModelPart Tumors;
	private final ModelPart Tumors2;
	private final ModelPart Tumors3;
	private final ModelPart Tumors4;
	private final ModelPart Tumors5;
	private final ModelPart Tumors6;
	private final ModelPart RightWing;
	private final ModelPart RightWingSeg1;
	private final ModelPart WingThingie;
	private final ModelPart WingThingie2;
	private final ModelPart RightWingSeg2;
	private final ModelPart WingThingie3;
	private final ModelPart WingThingie4;
	private final ModelPart RightWingSeg3;
	private final ModelPart WingThingie5;
	private final ModelPart RightHand;
	private final ModelPart LowerRightfinger3;
	private final ModelPart Infectedarm223;
	private final ModelPart Infectedarm224;
	private final ModelPart Infectedarm225;
	private final ModelPart Infectedarm226;
	private final ModelPart LowerRightfinger2;
	private final ModelPart Infectedarm230;
	private final ModelPart Infectedarm93;
	private final ModelPart Infectedarm94;
	private final ModelPart Infectedarm92;
	private final ModelPart Infectedarm231;
	private final ModelPart Infectedarm232;
	private final ModelPart LowerRightfinger;
	private final ModelPart Infectedarm237;
	private final ModelPart Infectedarm238;
	private final ModelPart Infectedarm239;
	private final ModelPart Infectedarm240;
	private final ModelPart mass5;
	private final ModelPart Infectedarm37;
	private final ModelPart Infectedarm38;
	private final ModelPart Infectedarm39;
	private final ModelPart Infectedarm40;
	private final ModelPart bloom3;
	private final ModelPart Infectedarm33;
	private final ModelPart Infectedarm34;
	private final ModelPart Infectedarm36;
	private final ModelPart Infectedarm35;
	private final ModelPart bloom4;
	private final ModelPart Infectedarm41;
	private final ModelPart Infectedarm42;
	private final ModelPart Infectedarm43;
	private final ModelPart Infectedarm44;
	private final ModelPart tumor;
	private final ModelPart Evilhand;
	private final ModelPart mass3;
	private final ModelPart mass4;
	private final ModelPart LLimbSeg3;
	private final ModelPart patty;
	private final ModelPart LLimbJawJoint;
	private final ModelPart CalciumCorpseLLimb;
	private final ModelPart LeftWing;
	private final ModelPart RightWingSeg;
	private final ModelPart mass;
	private final ModelPart mass2;
	private final ModelPart WingThingie6;
	private final ModelPart WingThingie7;
	private final ModelPart LeftWingSeg2;
	private final ModelPart RLimbSeg2;
	private final ModelPart RLimbSeg2Seg2;
	private final ModelPart RLimbSeg3;
	private final ModelPart RLimbHeadJoint;
	private final ModelPart WingThingie8;
	private final ModelPart WingThingie9;
	private final ModelPart LeftWingSeg3;
	private final ModelPart WingThingie10;
	private final ModelPart LeftHand;
	private final ModelPart LowerLeftfinger4;
	private final ModelPart Infectedarm20;
	private final ModelPart Infectedarm21;
	private final ModelPart Infectedarm22;
	private final ModelPart Infectedarm23;
	private final ModelPart Infectedarm24;
	private final ModelPart Infectedarm25;
	private final ModelPart LowerLeftfinger5;
	private final ModelPart Infectedarm26;
	private final ModelPart Infectedarm27;
	private final ModelPart Infectedarm28;
	private final ModelPart Infectedarm29;
	private final ModelPart Infectedarm30;
	private final ModelPart Infectedarm31;

	public FungalDragonBodyModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.Ribcage = root.getChild("Ribcage");
		this.body = this.Ribcage.getChild("body");
		this.rib6 = this.body.getChild("rib6");
		this.rib5 = this.body.getChild("rib5");
		this.body3 = this.rib5.getChild("body3");
		this.TFHead = this.body3.getChild("TFHead");
		this.TFJaw = this.TFHead.getChild("TFJaw");
		this.rib4 = this.body.getChild("rib4");
		this.rib3 = this.body.getChild("rib3");
		this.rib2 = this.body.getChild("rib2");
		this.rib = this.body.getChild("rib");
		this.Tumors10 = this.body.getChild("Tumors10");
		this.Tumors9 = this.body.getChild("Tumors9");
		this.Tumors8 = this.body.getChild("Tumors8");
		this.mass7 = this.body.getChild("mass7");
		this.mass8 = this.mass7.getChild("mass8");
		this.mass9 = this.mass8.getChild("mass9");
		this.Body1 = this.mass9.getChild("Body1");
		this.Body4 = this.mass9.getChild("Body4");
		this.Body5 = this.mass7.getChild("Body5");
		this.Body6 = this.mass7.getChild("Body6");
		this.Body7 = this.mass7.getChild("Body7");
		this.Tumors7 = this.body.getChild("Tumors7");
		this.Spine = this.Ribcage.getChild("Spine");
		this.Segment = this.Spine.getChild("Segment");
		this.Segment2 = this.Spine.getChild("Segment2");
		this.Segment3 = this.Spine.getChild("Segment3");
		this.Segment4 = this.Spine.getChild("Segment4");
		this.body40 = this.Segment4.getChild("body40");
		this.head37 = this.body40.getChild("head37");
		this.RightArm39 = this.body40.getChild("RightArm39");
		this.LeftArm38 = this.body40.getChild("LeftArm38");
		this.Segment5 = this.Spine.getChild("Segment5");
		this.Segment6 = this.Spine.getChild("Segment6");
		this.back = this.Ribcage.getChild("back");
		this.rib12 = this.back.getChild("rib12");
		this.rib11 = this.back.getChild("rib11");
		this.rib10 = this.back.getChild("rib10");
		this.rib7 = this.back.getChild("rib7");
		this.rib8 = this.back.getChild("rib8");
		this.rib9 = this.back.getChild("rib9");
		this.MajoTarSack = this.Ribcage.getChild("MajoTarSack");
		this.MajoTarSack2 = this.Ribcage.getChild("MajoTarSack2");
		this.LeftBackLeg = this.Ribcage.getChild("LeftBackLeg");
		this.LeftBack = this.LeftBackLeg.getChild("LeftBack");
		this.flower14 = this.LeftBack.getChild("flower14");
		this.body17 = this.LeftBack.getChild("body17");
		this.head12 = this.body17.getChild("head12");
		this.RightArm16 = this.body17.getChild("RightArm16");
		this.RightForArm16 = this.RightArm16.getChild("RightForArm16");
		this.LeftArm15 = this.body17.getChild("LeftArm15");
		this.LeftForArm15 = this.LeftArm15.getChild("LeftForArm15");
		this.Left = this.LeftBack.getChild("Left");
		this.flower7 = this.Left.getChild("flower7");
		this.flower2 = this.Left.getChild("flower2");
		this.Left2 = this.Left.getChild("Left2");
		this.LeftFoot = this.Left2.getChild("LeftFoot");
		this.Infectedarm95 = this.LeftFoot.getChild("Infectedarm95");
		this.Infectedarm96 = this.Infectedarm95.getChild("Infectedarm96");
		this.Infectedarm11 = this.LeftFoot.getChild("Infectedarm11");
		this.Infectedarm12 = this.Infectedarm11.getChild("Infectedarm12");
		this.Infectedarm9 = this.LeftFoot.getChild("Infectedarm9");
		this.Infectedarm10 = this.Infectedarm9.getChild("Infectedarm10");
		this.Infectedbody43 = this.LeftFoot.getChild("Infectedbody43");
		this.Infectedbody44 = this.Infectedbody43.getChild("Infectedbody44");
		this.Infectedbody45 = this.Infectedbody44.getChild("Infectedbody45");
		this.Infectedbody46 = this.Infectedbody43.getChild("Infectedbody46");
		this.Infectedbody47 = this.Infectedbody46.getChild("Infectedbody47");
		this.Infectedbody96 = this.Infectedbody43.getChild("Infectedbody96");
		this.Infectedbody97 = this.Infectedbody96.getChild("Infectedbody97");
		this.RightBackLeg = this.Ribcage.getChild("RightBackLeg");
		this.RightBack = this.RightBackLeg.getChild("RightBack");
		this.Infectedbody2 = this.RightBack.getChild("Infectedbody2");
		this.Infectedbody50 = this.RightBack.getChild("Infectedbody50");
		this.Infectedbody54 = this.RightBack.getChild("Infectedbody54");
		this.Right = this.RightBack.getChild("Right");
		this.Infectedbody3 = this.Right.getChild("Infectedbody3");
		this.Infectedbody4 = this.Right.getChild("Infectedbody4");
		this.Right2 = this.Right.getChild("Right2");
		this.body30 = this.Right2.getChild("body30");
		this.head27 = this.body30.getChild("head27");
		this.RightArm29 = this.body30.getChild("RightArm29");
		this.RightForArm29 = this.RightArm29.getChild("RightForArm29");
		this.LeftArm28 = this.body30.getChild("LeftArm28");
		this.LeftForArm28 = this.LeftArm28.getChild("LeftForArm28");
		this.Right3 = this.Right.getChild("Right3");
		this.body2 = this.Right3.getChild("body2");
		this.head2 = this.body2.getChild("head2");
		this.RightArm2 = this.body2.getChild("RightArm2");
		this.RightForArm2 = this.RightArm2.getChild("RightForArm2");
		this.LeftArm2 = this.body2.getChild("LeftArm2");
		this.LeftForArm2 = this.LeftArm2.getChild("LeftForArm2");
		this.Tumors = this.Ribcage.getChild("Tumors");
		this.Tumors2 = this.Ribcage.getChild("Tumors2");
		this.Tumors3 = this.Ribcage.getChild("Tumors3");
		this.Tumors4 = this.Ribcage.getChild("Tumors4");
		this.Tumors5 = this.Ribcage.getChild("Tumors5");
		this.Tumors6 = this.Ribcage.getChild("Tumors6");
		this.RightWing = this.Ribcage.getChild("RightWing");
		this.RightWingSeg1 = this.RightWing.getChild("RightWingSeg1");
		this.WingThingie = this.RightWingSeg1.getChild("WingThingie");
		this.WingThingie2 = this.RightWingSeg1.getChild("WingThingie2");
		this.RightWingSeg2 = this.RightWingSeg1.getChild("RightWingSeg2");
		this.WingThingie3 = this.RightWingSeg2.getChild("WingThingie3");
		this.WingThingie4 = this.RightWingSeg2.getChild("WingThingie4");
		this.RightWingSeg3 = this.RightWingSeg2.getChild("RightWingSeg3");
		this.WingThingie5 = this.RightWingSeg3.getChild("WingThingie5");
		this.RightHand = this.RightWingSeg2.getChild("RightHand");
		this.LowerRightfinger3 = this.RightHand.getChild("LowerRightfinger3");
		this.Infectedarm223 = this.LowerRightfinger3.getChild("Infectedarm223");
		this.Infectedarm224 = this.Infectedarm223.getChild("Infectedarm224");
		this.Infectedarm225 = this.LowerRightfinger3.getChild("Infectedarm225");
		this.Infectedarm226 = this.Infectedarm225.getChild("Infectedarm226");
		this.LowerRightfinger2 = this.RightHand.getChild("LowerRightfinger2");
		this.Infectedarm230 = this.LowerRightfinger2.getChild("Infectedarm230");
		this.Infectedarm93 = this.Infectedarm230.getChild("Infectedarm93");
		this.Infectedarm94 = this.Infectedarm230.getChild("Infectedarm94");
		this.Infectedarm92 = this.Infectedarm230.getChild("Infectedarm92");
		this.Infectedarm231 = this.Infectedarm230.getChild("Infectedarm231");
		this.Infectedarm232 = this.Infectedarm230.getChild("Infectedarm232");
		this.LowerRightfinger = this.RightHand.getChild("LowerRightfinger");
		this.Infectedarm237 = this.LowerRightfinger.getChild("Infectedarm237");
		this.Infectedarm238 = this.Infectedarm237.getChild("Infectedarm238");
		this.Infectedarm239 = this.Infectedarm238.getChild("Infectedarm239");
		this.Infectedarm240 = this.Infectedarm238.getChild("Infectedarm240");
		this.mass5 = this.RightWingSeg2.getChild("mass5");
		this.Infectedarm37 = this.mass5.getChild("Infectedarm37");
		this.Infectedarm38 = this.Infectedarm37.getChild("Infectedarm38");
		this.Infectedarm39 = this.Infectedarm38.getChild("Infectedarm39");
		this.Infectedarm40 = this.Infectedarm38.getChild("Infectedarm40");
		this.bloom3 = this.mass5.getChild("bloom3");
		this.Infectedarm33 = this.mass5.getChild("Infectedarm33");
		this.Infectedarm34 = this.Infectedarm33.getChild("Infectedarm34");
		this.Infectedarm36 = this.Infectedarm34.getChild("Infectedarm36");
		this.Infectedarm35 = this.Infectedarm34.getChild("Infectedarm35");
		this.bloom4 = this.mass5.getChild("bloom4");
		this.Infectedarm41 = this.mass5.getChild("Infectedarm41");
		this.Infectedarm42 = this.Infectedarm41.getChild("Infectedarm42");
		this.Infectedarm43 = this.Infectedarm42.getChild("Infectedarm43");
		this.Infectedarm44 = this.Infectedarm42.getChild("Infectedarm44");
		this.tumor = this.mass5.getChild("tumor");
		this.Evilhand = this.mass5.getChild("Evilhand");
		this.mass3 = this.RightWingSeg1.getChild("mass3");
		this.mass4 = this.mass3.getChild("mass4");
		this.LLimbSeg3 = this.mass4.getChild("LLimbSeg3");
		this.patty = this.LLimbSeg3.getChild("patty");
		this.LLimbJawJoint = this.LLimbSeg3.getChild("LLimbJawJoint");
		this.CalciumCorpseLLimb = this.mass3.getChild("CalciumCorpseLLimb");
		this.LeftWing = this.Ribcage.getChild("LeftWing");
		this.RightWingSeg = this.LeftWing.getChild("RightWingSeg");
		this.mass = this.RightWingSeg.getChild("mass");
		this.mass2 = this.mass.getChild("mass2");
		this.WingThingie6 = this.RightWingSeg.getChild("WingThingie6");
		this.WingThingie7 = this.RightWingSeg.getChild("WingThingie7");
		this.LeftWingSeg2 = this.RightWingSeg.getChild("LeftWingSeg2");
		this.RLimbSeg2 = this.LeftWingSeg2.getChild("RLimbSeg2");
		this.RLimbSeg2Seg2 = this.RLimbSeg2.getChild("RLimbSeg2Seg2");
		this.RLimbSeg3 = this.RLimbSeg2Seg2.getChild("RLimbSeg3");
		this.RLimbHeadJoint = this.RLimbSeg3.getChild("RLimbHeadJoint");
		this.WingThingie8 = this.LeftWingSeg2.getChild("WingThingie8");
		this.WingThingie9 = this.LeftWingSeg2.getChild("WingThingie9");
		this.LeftWingSeg3 = this.LeftWingSeg2.getChild("LeftWingSeg3");
		this.WingThingie10 = this.LeftWingSeg3.getChild("WingThingie10");
		this.LeftHand = this.LeftWingSeg2.getChild("LeftHand");
		this.LowerLeftfinger4 = this.LeftHand.getChild("LowerLeftfinger4");
		this.Infectedarm20 = this.LowerLeftfinger4.getChild("Infectedarm20");
		this.Infectedarm21 = this.Infectedarm20.getChild("Infectedarm21");
		this.Infectedarm22 = this.Infectedarm20.getChild("Infectedarm22");
		this.Infectedarm23 = this.Infectedarm20.getChild("Infectedarm23");
		this.Infectedarm24 = this.Infectedarm20.getChild("Infectedarm24");
		this.Infectedarm25 = this.Infectedarm20.getChild("Infectedarm25");
		this.LowerLeftfinger5 = this.LeftHand.getChild("LowerLeftfinger5");
		this.Infectedarm26 = this.LowerLeftfinger5.getChild("Infectedarm26");
		this.Infectedarm27 = this.Infectedarm26.getChild("Infectedarm27");
		this.Infectedarm28 = this.Infectedarm26.getChild("Infectedarm28");
		this.Infectedarm29 = this.Infectedarm26.getChild("Infectedarm29");
		this.Infectedarm30 = this.Infectedarm26.getChild("Infectedarm30");
		this.Infectedarm31 = this.Infectedarm26.getChild("Infectedarm31");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Ribcage = partdefinition.addOrReplaceChild("Ribcage", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, -12.0F));

		PartDefinition body = Ribcage.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -17.0F, -30.0F));

		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(44, 519).addBox(-1.0F, -8.0F, -1.0F, 0.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -36.25F, 12.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(404, 423).addBox(-9.0F, -11.0F, 2.0F, 5.0F, 17.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -13.0F, 22.0F, -1.1378F, 0.1119F, 0.028F));

		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(354, 423).addBox(4.0F, -11.0F, 2.0F, 5.0F, 17.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.0F, -13.0F, 22.0F, -1.1378F, -0.1119F, -0.028F));

		PartDefinition cube_r4 = body.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 313).addBox(-1.0F, -11.0F, -5.0F, 10.0F, 17.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -18.0F, 7.0F, -0.6068F, -0.0749F, -0.1074F));

		PartDefinition cube_r5 = body.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(262, 292).addBox(-1.0F, -11.0F, -5.0F, 10.0F, 17.0F, 27.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-23.0F, -18.0F, 8.0F, -0.6068F, 0.0749F, 0.1074F));

		PartDefinition cube_r6 = body.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(458, 223).addBox(-14.0F, -4.0F, -14.0F, 29.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -20.0F, 19.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r7 = body.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(178, 275).addBox(-9.0F, 0.0F, -14.0F, 19.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(236, 372).addBox(-17.0F, -17.0F, -14.0F, 34.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 9.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r8 = body.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(286, 84).addBox(-15.0F, -5.0F, -11.0F, 31.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 16.0F, -0.8727F, 0.0F, 0.0F));

		PartDefinition cube_r9 = body.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(400, 0).addBox(-17.0F, -17.0F, -11.0F, 34.0F, 22.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 23.0F, -0.9599F, 0.0F, 0.0F));

		PartDefinition cube_r10 = body.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(350, 244).addBox(-26.0F, -3.0F, -15.0F, 25.0F, 0.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.25F, 27.25F, 25.75F, -0.8138F, 0.6997F, 0.1906F));

		PartDefinition cube_r11 = body.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(374, 372).addBox(-26.0F, -6.0F, -11.0F, 27.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.25F, 14.25F, 16.75F, -0.8195F, 0.5775F, 0.035F));

		PartDefinition cube_r12 = body.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(412, 306).addBox(3.0F, -4.0F, -11.0F, 18.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.25F, 27.5F, 21.75F, -0.9845F, -0.5481F, 0.0336F));

		PartDefinition cube_r13 = body.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(350, 263).addBox(-1.0F, -6.0F, -11.0F, 27.0F, 6.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.25F, 14.5F, 16.75F, -0.8195F, -0.5775F, -0.035F));

		PartDefinition cube_r14 = body.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(128, 236).addBox(-1.0F, -6.0F, -11.0F, 31.0F, 6.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.25F, 0.0F, -0.25F, -0.6931F, -0.2895F, -0.3311F));

		PartDefinition cube_r15 = body.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(256, 143).addBox(-2.0F, -6.0F, -11.0F, 23.0F, 6.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.75F, -26.0F, 17.25F, -0.5133F, 0.1084F, 0.1897F));

		PartDefinition cube_r16 = body.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(256, 104).addBox(-21.0F, -6.0F, -11.0F, 23.0F, 6.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -26.0F, 17.0F, -0.5133F, -0.1084F, -0.1897F));

		PartDefinition cube_r17 = body.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 236).addBox(-30.0F, -6.0F, -11.0F, 31.0F, 6.0F, 33.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 0.0F, -0.6931F, 0.2895F, 0.3311F));

		PartDefinition rib6 = body.addOrReplaceChild("rib6", CubeListBuilder.create(), PartPose.offsetAndRotation(18.0F, 10.5F, 28.0F, 0.8968F, -0.2261F, -2.2661F));

		PartDefinition MiddleRidgeRib1Tip_r1 = rib6.addOrReplaceChild("MiddleRidgeRib1Tip_r1", CubeListBuilder.create().texOffs(556, 323).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r1 = rib6.addOrReplaceChild("MiddleRidgeRib1_r1", CubeListBuilder.create().texOffs(546, 417).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib5 = body.addOrReplaceChild("rib5", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, 4.5F, 31.0F, 0.7953F, 0.518F, -2.8952F));

		PartDefinition MiddleRidgeRib1Tip_r2 = rib5.addOrReplaceChild("MiddleRidgeRib1Tip_r2", CubeListBuilder.create().texOffs(246, 555).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r2 = rib5.addOrReplaceChild("MiddleRidgeRib1_r2", CubeListBuilder.create().texOffs(546, 401).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition body3 = rib5.addOrReplaceChild("body3", CubeListBuilder.create().texOffs(146, 495).addBox(-2.75F, -5.0F, -4.5F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(164, 546).addBox(-3.25F, -11.0F, -5.0F, 5.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 0.25F, 12.0F, -1.5716F, -0.3034F, 0.0191F));

		PartDefinition TFHead = body3.addOrReplaceChild("TFHead", CubeListBuilder.create().texOffs(192, 544).addBox(-2.0F, -7.5F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, -10.5F, -1.0F, 0.2618F, 0.0F, 0.3054F));

		PartDefinition TFJaw = TFHead.addOrReplaceChild("TFJaw", CubeListBuilder.create().texOffs(418, 460).addBox(-1.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.2533F, -0.067F, 0.2969F));

		PartDefinition rib4 = body.addOrReplaceChild("rib4", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0F, 11.5F, 22.0F, 0.6377F, -0.295F, -1.9368F));

		PartDefinition MiddleRidgeRib1Tip_r3 = rib4.addOrReplaceChild("MiddleRidgeRib1Tip_r3", CubeListBuilder.create().texOffs(224, 555).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r3 = rib4.addOrReplaceChild("MiddleRidgeRib1_r3", CubeListBuilder.create().texOffs(28, 546).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib3 = body.addOrReplaceChild("rib3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 11.5F, 22.0F, -0.3379F, -0.3984F, -1.3899F));

		PartDefinition MiddleRidgeRib1Tip_r4 = rib3.addOrReplaceChild("MiddleRidgeRib1Tip_r4", CubeListBuilder.create().texOffs(400, 554).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r4 = rib3.addOrReplaceChild("MiddleRidgeRib1_r4", CubeListBuilder.create().texOffs(502, 545).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib2 = body.addOrReplaceChild("rib2", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0F, 0.0F, 30.0F, -0.2956F, 0.4998F, 0.3232F));

		PartDefinition MiddleRidgeRib1Tip_r5 = rib2.addOrReplaceChild("MiddleRidgeRib1Tip_r5", CubeListBuilder.create().texOffs(378, 554).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r5 = rib2.addOrReplaceChild("MiddleRidgeRib1_r5", CubeListBuilder.create().texOffs(544, 262).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib = body.addOrReplaceChild("rib", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.0F, 11.0F, 30.0F, -0.5597F, 0.1357F, -0.4689F));

		PartDefinition MiddleRidgeRib1Tip_r6 = rib.addOrReplaceChild("MiddleRidgeRib1Tip_r6", CubeListBuilder.create().texOffs(112, 552).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r6 = rib.addOrReplaceChild("MiddleRidgeRib1_r6", CubeListBuilder.create().texOffs(134, 544).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition Tumors10 = body.addOrReplaceChild("Tumors10", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9023F, -10.5239F, -3.0648F, -1.2975F, -0.7749F, -1.7638F));

		PartDefinition Tumor_r1 = Tumors10.addOrReplaceChild("Tumor_r1", CubeListBuilder.create().texOffs(256, 443).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2608F, -2.6408F, 0.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r2 = Tumors10.addOrReplaceChild("Tumor_r2", CubeListBuilder.create().texOffs(418, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4721F, 1.9873F, 1.5593F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumors9 = body.addOrReplaceChild("Tumors9", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.9023F, -25.5239F, 7.9352F, -1.9958F, 0.7149F, 1.1545F));

		PartDefinition Tumor_r3 = Tumors9.addOrReplaceChild("Tumor_r3", CubeListBuilder.create().texOffs(256, 443).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2608F, -2.6408F, 0.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r4 = Tumors9.addOrReplaceChild("Tumor_r4", CubeListBuilder.create().texOffs(418, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4721F, 1.9873F, 1.5593F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r5 = Tumors9.addOrReplaceChild("Tumor_r5", CubeListBuilder.create().texOffs(250, 518).addBox(-5.2774F, -3.6119F, -0.565F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2608F, -1.6408F, 3.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumors8 = body.addOrReplaceChild("Tumors8", CubeListBuilder.create(), PartPose.offsetAndRotation(-15.9023F, -17.5239F, 4.9352F, -2.3531F, 0.2458F, 0.4281F));

		PartDefinition Tumor_r6 = Tumors8.addOrReplaceChild("Tumor_r6", CubeListBuilder.create().texOffs(256, 443).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2608F, -2.6408F, 0.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r7 = Tumors8.addOrReplaceChild("Tumor_r7", CubeListBuilder.create().texOffs(418, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4721F, 1.9873F, 1.5593F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r8 = Tumors8.addOrReplaceChild("Tumor_r8", CubeListBuilder.create().texOffs(250, 518).addBox(-5.2774F, -3.6119F, -0.565F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2608F, -1.6408F, 3.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition mass7 = body.addOrReplaceChild("mass7", CubeListBuilder.create().texOffs(454, 358).addBox(-4.0F, -1.0F, -10.0F, 8.0F, 9.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(24.85F, -13.0F, 20.0F));

		PartDefinition mass8 = mass7.addOrReplaceChild("mass8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 6.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition LSJSSeg2_r1 = mass8.addOrReplaceChild("LSJSSeg2_r1", CubeListBuilder.create().texOffs(210, 496).addBox(-3.0F, 6.0F, -7.0F, 6.0F, 17.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition mass9 = mass8.addOrReplaceChild("mass9", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.8727F));

		PartDefinition Tumor_r9 = mass9.addOrReplaceChild("Tumor_r9", CubeListBuilder.create().texOffs(418, 236).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -1.0F, 7.0F, -0.2391F, -0.5194F, 0.4565F));

		PartDefinition Body1 = mass9.addOrReplaceChild("Body1", CubeListBuilder.create(), PartPose.offset(0.0F, 6.0F, 0.0F));

		PartDefinition Torso_r1 = Body1.addOrReplaceChild("Torso_r1", CubeListBuilder.create().texOffs(88, 552).addBox(0.0F, -2.0F, -3.99F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		PartDefinition Arm_r1 = Body1.addOrReplaceChild("Arm_r1", CubeListBuilder.create().texOffs(58, 573).addBox(-2.0F, 0.0963F, -1.5307F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.6263F, 4.9587F, 0.1888F, -0.2241F, -0.2567F));

		PartDefinition Arm_r2 = Body1.addOrReplaceChild("Arm_r2", CubeListBuilder.create().texOffs(572, 488).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -1.0F, -5.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition Jaw_r1 = Body1.addOrReplaceChild("Jaw_r1", CubeListBuilder.create().texOffs(398, 476).addBox(0.0F, -0.25F, -4.0F, 1.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.25F, 0.0F, 0.0F, 0.3054F, -0.0436F));

		PartDefinition Head_r1 = Body1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(552, 55).addBox(-7.0F, -0.25F, -4.0F, 7.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 2.25F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Body4 = mass9.addOrReplaceChild("Body4", CubeListBuilder.create().texOffs(552, 199).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(354, 412).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, 0.0F, 0.0F));

		PartDefinition Leg_r1 = Body4.addOrReplaceChild("Leg_r1", CubeListBuilder.create().texOffs(224, 573).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Leg_r2 = Body4.addOrReplaceChild("Leg_r2", CubeListBuilder.create().texOffs(114, 573).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Arm_r3 = Body4.addOrReplaceChild("Arm_r3", CubeListBuilder.create().texOffs(98, 573).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r2 = Body4.addOrReplaceChild("Jaw_r2", CubeListBuilder.create().texOffs(542, 506).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1358F, -0.206F, 0.1888F));

		PartDefinition Head_r2 = Body4.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(544, 232).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.3927F));

		PartDefinition Body5 = mass7.addOrReplaceChild("Body5", CubeListBuilder.create().texOffs(552, 212).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(438, 159).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.0F, -15.0F, 2.8035F, 0.0886F, 0.2467F));

		PartDefinition Leg_r3 = Body5.addOrReplaceChild("Leg_r3", CubeListBuilder.create().texOffs(460, 573).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Leg_r4 = Body5.addOrReplaceChild("Leg_r4", CubeListBuilder.create().texOffs(288, 573).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Arm_r4 = Body5.addOrReplaceChild("Arm_r4", CubeListBuilder.create().texOffs(272, 573).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r3 = Body5.addOrReplaceChild("Jaw_r3", CubeListBuilder.create().texOffs(352, 84).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1358F, -0.206F, 0.1888F));

		PartDefinition Head_r3 = Body5.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(370, 539).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.3927F));

		PartDefinition Body6 = mass7.addOrReplaceChild("Body6", CubeListBuilder.create().texOffs(552, 278).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(334, 563).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.0F, 2.0F, 0.0F, 0.0F, -2.8798F, 0.0F));

		PartDefinition Leg_r5 = Body6.addOrReplaceChild("Leg_r5", CubeListBuilder.create().texOffs(334, 574).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Leg_r6 = Body6.addOrReplaceChild("Leg_r6", CubeListBuilder.create().texOffs(574, 262).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.2921F, 0.0905F, 0.2921F));

		PartDefinition Arm_r5 = Body6.addOrReplaceChild("Arm_r5", CubeListBuilder.create().texOffs(574, 38).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r4 = Body6.addOrReplaceChild("Jaw_r4", CubeListBuilder.create().texOffs(546, 433).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1358F, -0.206F, 0.1888F));

		PartDefinition Head_r4 = Body6.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(544, 247).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0436F, 0.0F, -0.3927F));

		PartDefinition Body7 = mass7.addOrReplaceChild("Body7", CubeListBuilder.create().texOffs(552, 291).addBox(3.0F, 1.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(564, 551).addBox(3.5F, 6.0F, -3.5F, 3.0F, 4.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-45.0F, 2.0F, -17.0F, 1.88F, 0.6294F, 2.668F));

		PartDefinition Leg_r7 = Body7.addOrReplaceChild("Leg_r7", CubeListBuilder.create().texOffs(384, 82).addBox(-2.0F, -1.0F, -1.99F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.9599F));

		PartDefinition Leg_r8 = Body7.addOrReplaceChild("Leg_r8", CubeListBuilder.create().texOffs(574, 500).addBox(-2.0F, -0.25F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(5.0F, 10.0F, -2.0F, -0.1789F, 0.2489F, 0.9375F));

		PartDefinition Arm_r6 = Body7.addOrReplaceChild("Arm_r6", CubeListBuilder.create().texOffs(440, 574).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, -4.0F, -1.0133F, 0.9478F, -0.2256F));

		PartDefinition Jaw_r5 = Body7.addOrReplaceChild("Jaw_r5", CubeListBuilder.create().texOffs(376, 282).addBox(-4.0F, 0.0F, -3.99F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.1488F, -0.4652F, 0.1496F));

		PartDefinition Head_r5 = Body7.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(402, 539).addBox(-4.0F, -7.0F, -3.99F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0452F, 0.2615F, -0.381F));

		PartDefinition Tumors7 = body.addOrReplaceChild("Tumors7", CubeListBuilder.create(), PartPose.offsetAndRotation(9.0977F, -17.5239F, 4.9352F, -2.3321F, -0.3166F, -0.1279F));

		PartDefinition Tumor_r10 = Tumors7.addOrReplaceChild("Tumor_r10", CubeListBuilder.create().texOffs(256, 443).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2608F, -2.6408F, 0.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r11 = Tumors7.addOrReplaceChild("Tumor_r11", CubeListBuilder.create().texOffs(418, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4721F, 1.9873F, 1.5593F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r12 = Tumors7.addOrReplaceChild("Tumor_r12", CubeListBuilder.create().texOffs(250, 518).addBox(-5.2774F, -3.6119F, -0.565F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2608F, -1.6408F, 3.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Spine = Ribcage.addOrReplaceChild("Spine", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -34.25F, -4.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition Segment = Spine.addOrReplaceChild("Segment", CubeListBuilder.create().texOffs(348, 476).addBox(-6.5F, -10.0F, -1.0F, 12.0F, 12.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(518, 280).addBox(-0.6F, -18.0F, -4.0F, 0.0F, 10.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r18 = Segment.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(132, 418).addBox(-12.0F, -10.0F, -1.0F, 20.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5F, 10.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Segment2 = Spine.addOrReplaceChild("Segment2", CubeListBuilder.create().texOffs(50, 495).addBox(-6.0F, -10.0F, -1.0F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1007).addBox(-8.0F, -11.0F, 4.0F, 15.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(522, 465).addBox(-0.5F, -18.0F, -1.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 11.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Segment3 = Spine.addOrReplaceChild("Segment3", CubeListBuilder.create().texOffs(342, 523).addBox(-0.4F, -18.0F, -1.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 24.0F, -0.0436F, 0.0F, 0.0F));

		PartDefinition cube_r19 = Segment3.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 1007).addBox(-7.5F, -6.5F, -1.5F, 15.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(98, 495).addBox(-5.5F, -5.5F, -6.5F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -4.5F, 5.5F, 0.0F, -0.0175F, 0.0F));

		PartDefinition Segment4 = Spine.addOrReplaceChild("Segment4", CubeListBuilder.create().texOffs(398, 495).addBox(-6.0F, -10.0F, -1.0F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1007).addBox(-8.0F, -11.0F, 3.0F, 15.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(524, 68).addBox(-0.4F, -18.0F, -1.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, 2.0F, 37.0F, 0.1309F, 0.0F, 0.0F));

		PartDefinition body40 = Segment4.addOrReplaceChild("body40", CubeListBuilder.create().texOffs(22, 562).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-0.9F, -9.75F, 4.0F, -1.3427F, 0.1964F, -3.135F));

		PartDefinition cube_r20 = body40.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(558, 454).addBox(-4.0F, -2.5F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.4786F, -0.3263F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head37 = body40.addOrReplaceChild("head37", CubeListBuilder.create().texOffs(532, 551).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(570, 545).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(248, 571).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6546F, -0.0138F, 0.0106F));

		PartDefinition RightArm39 = body40.addOrReplaceChild("RightArm39", CubeListBuilder.create().texOffs(252, 577).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.5708F, 0.0F, 0.4363F));

		PartDefinition LeftArm38 = body40.addOrReplaceChild("LeftArm38", CubeListBuilder.create().texOffs(40, 578).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.3337F, 0.1313F, -0.3712F));

		PartDefinition Segment5 = Spine.addOrReplaceChild("Segment5", CubeListBuilder.create().texOffs(446, 495).addBox(-6.0F, -10.0F, -1.5F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1007).addBox(-8.0F, -11.0F, 3.5F, 15.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(524, 208).addBox(-0.4F, -18.0F, -1.0F, 0.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.3F, 0.0F, 50.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition Segment6 = Spine.addOrReplaceChild("Segment6", CubeListBuilder.create().texOffs(0, 477).addBox(-6.0F, -10.0F, -2.6F, 11.0F, 11.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 1007).addBox(-8.0F, -11.0F, 2.4F, 15.0F, 14.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(134, 519).addBox(-0.4F, -18.0F, -2.0F, 0.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 63.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition back = Ribcage.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 357).addBox(-10.0F, -8.0F, -9.0F, 20.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -21.0F, 75.0F));

		PartDefinition cube_r21 = back.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(266, 394).addBox(-1.0F, -8.0F, -2.0F, 0.0F, 26.0F, 23.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7F, -9.25F, -6.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition cube_r22 = back.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(314, 372).addBox(-4.0F, -13.0F, -10.0F, 9.0F, 19.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 3.0F, 0.0F, 0.0F, 0.1745F, 0.3927F));

		PartDefinition cube_r23 = back.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(142, 378).addBox(-4.0F, -13.0F, -10.0F, 8.0F, 19.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, 3.0F, 0.0F, 0.0F, -0.1745F, -0.3927F));

		PartDefinition cube_r24 = back.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(466, 72).addBox(-10.0F, -8.0F, -2.0F, 20.0F, 12.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 4.0F, 6.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition cube_r25 = back.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(496, 386).addBox(-10.0F, -8.0F, -2.0F, 20.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 6.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition rib12 = back.addOrReplaceChild("rib12", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, 4.5F, -7.5F, -1.8114F, 0.3771F, 0.7261F));

		PartDefinition MiddleRidgeRib1Tip_r7 = rib12.addOrReplaceChild("MiddleRidgeRib1Tip_r7", CubeListBuilder.create().texOffs(156, 560).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3376F, -0.5391F, 3.9254F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r7 = rib12.addOrReplaceChild("MiddleRidgeRib1_r7", CubeListBuilder.create().texOffs(550, 169).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.183F, -0.5391F, 17.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition rib11 = back.addOrReplaceChild("rib11", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, 6.5F, -0.75F, -1.6467F, -0.0527F, 0.9422F));

		PartDefinition MiddleRidgeRib1Tip_r8 = rib11.addOrReplaceChild("MiddleRidgeRib1Tip_r8", CubeListBuilder.create().texOffs(134, 560).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3376F, -0.5391F, 3.9254F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r8 = rib11.addOrReplaceChild("MiddleRidgeRib1_r8", CubeListBuilder.create().texOffs(550, 153).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.183F, -0.5391F, 17.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition rib10 = back.addOrReplaceChild("rib10", CubeListBuilder.create(), PartPose.offsetAndRotation(10.0F, 6.0F, 5.0F, -1.3249F, -0.7358F, 0.7096F));

		PartDefinition MiddleRidgeRib1Tip_r9 = rib10.addOrReplaceChild("MiddleRidgeRib1Tip_r9", CubeListBuilder.create().texOffs(560, 16).addBox(-2.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.3376F, -0.5391F, 3.9254F, 0.0F, 0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r9 = rib10.addOrReplaceChild("MiddleRidgeRib1_r9", CubeListBuilder.create().texOffs(550, 137).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.183F, -0.5391F, 17.5F, 0.0F, 0.3491F, 0.0F));

		PartDefinition rib7 = back.addOrReplaceChild("rib7", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 6.5F, 6.0F, -1.3249F, 0.7358F, -0.7096F));

		PartDefinition MiddleRidgeRib1Tip_r10 = rib7.addOrReplaceChild("MiddleRidgeRib1Tip_r10", CubeListBuilder.create().texOffs(422, 558).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r10 = rib7.addOrReplaceChild("MiddleRidgeRib1_r10", CubeListBuilder.create().texOffs(324, 547).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib8 = back.addOrReplaceChild("rib8", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 6.5F, 0.0F, -1.6467F, 0.0527F, -0.9422F));

		PartDefinition MiddleRidgeRib1Tip_r11 = rib8.addOrReplaceChild("MiddleRidgeRib1Tip_r11", CubeListBuilder.create().texOffs(558, 442).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r11 = rib8.addOrReplaceChild("MiddleRidgeRib1_r11", CubeListBuilder.create().texOffs(288, 548).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition rib9 = back.addOrReplaceChild("rib9", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 4.5F, -8.0F, -1.8114F, -0.3771F, -0.7261F));

		PartDefinition MiddleRidgeRib1Tip_r12 = rib9.addOrReplaceChild("MiddleRidgeRib1Tip_r12", CubeListBuilder.create().texOffs(190, 559).addBox(-0.5F, -2.01F, -5.25F, 3.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.3376F, -0.5391F, 3.9254F, 0.0F, -0.6981F, 0.0F));

		PartDefinition MiddleRidgeRib1_r12 = rib9.addOrReplaceChild("MiddleRidgeRib1_r12", CubeListBuilder.create().texOffs(548, 307).addBox(-1.5F, -2.0F, -12.0F, 3.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.183F, -0.5391F, 17.5F, 0.0F, -0.3491F, 0.0F));

		PartDefinition MajoTarSack = Ribcage.addOrReplaceChild("MajoTarSack", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4846F, -17.5489F, -12.4748F, 0.7724F, -0.2445F, 0.0461F));

		PartDefinition Tar_r1 = MajoTarSack.addOrReplaceChild("Tar_r1", CubeListBuilder.create().texOffs(74, 340).addBox(-10.0F, -5.0F, -9.5F, 20.0F, 10.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7889F, 0.1323F, 10.7466F, 0.4639F, -0.3106F, 0.4297F));

		PartDefinition Tar_r2 = MajoTarSack.addOrReplaceChild("Tar_r2", CubeListBuilder.create().texOffs(0, 275).addBox(-16.0F, -7.5F, -12.0F, 23.0F, 14.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 8.0F, 0.4313F, -0.3287F, -0.8731F));

		PartDefinition Tar_r3 = MajoTarSack.addOrReplaceChild("Tar_r3", CubeListBuilder.create().texOffs(412, 282).addBox(-12.0F, -3.5F, -2.0F, 21.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition MajoTarSack2 = Ribcage.addOrReplaceChild("MajoTarSack2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4846F, -7.5489F, -27.4748F, 1.0866F, -0.7201F, 0.7412F));

		PartDefinition Tar_r4 = MajoTarSack2.addOrReplaceChild("Tar_r4", CubeListBuilder.create().texOffs(286, 30).addBox(-12.0F, -5.0F, -9.5F, 22.0F, 10.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.7889F, 0.1323F, 7.7466F, -2.0747F, -0.4884F, -1.0331F));

		PartDefinition Tar_r5 = MajoTarSack2.addOrReplaceChild("Tar_r5", CubeListBuilder.create().texOffs(256, 244).addBox(-16.0F, -7.5F, -12.0F, 23.0F, 14.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -3.0F, 12.0F, 1.0858F, -0.3287F, -0.8731F));

		PartDefinition Tar_r6 = MajoTarSack2.addOrReplaceChild("Tar_r6", CubeListBuilder.create().texOffs(72, 369).addBox(-12.0F, -3.5F, -2.0F, 21.0F, 18.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition LeftBackLeg = Ribcage.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create(), PartPose.offset(11.0F, -21.0F, 73.0F));

		PartDefinition LeftBack = LeftBackLeg.addOrReplaceChild("LeftBack", CubeListBuilder.create().texOffs(312, 461).addBox(-6.1283F, -6.0811F, -3.9146F, 9.0F, 32.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.3435F, 0.2684F, -1.0F, -0.532F, -0.2071F, -0.7724F));

		PartDefinition flower14 = LeftBack.addOrReplaceChild("flower14", CubeListBuilder.create().texOffs(386, 24).addBox(-1.5F, -3.0F, -4.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(392, 236).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(224, 567).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.6565F, 9.2316F, -1.25F, 2.3998F, 1.4399F, 2.5744F));

		PartDefinition cube_r26 = flower14.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(554, 568).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -4.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition body17 = LeftBack.addOrReplaceChild("body17", CubeListBuilder.create().texOffs(504, 561).addBox(-3.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5935F, 26.7316F, -4.0F, 0.1745F, 0.0F, -3.098F));

		PartDefinition cube_r27 = body17.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 562).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 12.115F, -2.4241F, -0.2618F, -0.0045F, -0.0169F));

		PartDefinition cube_r28 = body17.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(556, 335).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head12 = body17.addOrReplaceChild("head12", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r29 = head12.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(570, 515).addBox(-2.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -4.0F, 0.0F, -0.3927F, 0.0F));

		PartDefinition cube_r30 = head12.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(416, 570).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 2.0F, -0.0524F, 0.0349F, 0.0F));

		PartDefinition Head_r6 = head12.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(550, 465).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5237F, -0.0151F, 0.0087F));

		PartDefinition RightArm16 = body17.addOrReplaceChild("RightArm16", CubeListBuilder.create().texOffs(576, 417).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition RightForArm16 = RightArm16.addOrReplaceChild("RightForArm16", CubeListBuilder.create().texOffs(428, 576).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, 0.6109F, 0.0F, 0.0F));

		PartDefinition LeftArm15 = body17.addOrReplaceChild("LeftArm15", CubeListBuilder.create().texOffs(206, 577).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.2616F, 0.0113F, -0.0421F));

		PartDefinition LeftForArm15 = LeftArm15.addOrReplaceChild("LeftForArm15", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition cube_r31 = LeftForArm15.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(240, 577).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Left = LeftBack.addOrReplaceChild("Left", CubeListBuilder.create().texOffs(482, 280).addBox(-5.0F, 0.0F, -4.5F, 9.0F, 29.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.1283F, 23.9189F, 2.5854F, 1.7567F, -0.4545F, 0.4118F));

		PartDefinition flower7 = Left.addOrReplaceChild("flower7", CubeListBuilder.create().texOffs(412, 24).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(64, 461).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(570, 521).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7848F, 12.3127F, 3.1646F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r32 = flower7.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(570, 527).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition flower2 = Left.addOrReplaceChild("flower2", CubeListBuilder.create().texOffs(472, 17).addBox(-3.5F, -3.0F, -2.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(552, 85).addBox(-3.5F, 3.0F, -3.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(570, 533).addBox(-7.0F, -1.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.7848F, 6.3127F, -3.8354F, 0.0F, 0.2618F, 0.0F));

		PartDefinition cube_r33 = flower2.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(570, 539).addBox(0.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.1745F, -0.2182F, 0.0F));

		PartDefinition Left2 = Left.addOrReplaceChild("Left2", CubeListBuilder.create().texOffs(168, 454).addBox(-4.8717F, -1.9189F, -4.0854F, 12.0F, 23.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 28.0F, 0.0F, -1.8326F, 0.0F, 0.0F));

		PartDefinition LeftFoot = Left2.addOrReplaceChild("LeftFoot", CubeListBuilder.create().texOffs(0, 421).addBox(-4.0F, -0.1922F, -10.388F, 13.0F, 21.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2152F, 14.0048F, 2.8026F, 0.7681F, -0.1841F, 0.1872F));

		PartDefinition cube_r34 = LeftFoot.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(400, 572).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 17.8078F, 3.612F, 1.7536F, 0.4567F, 1.4826F));

		PartDefinition Infectedarm95 = LeftFoot.addOrReplaceChild("Infectedarm95", CubeListBuilder.create().texOffs(576, 101).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.8078F, -3.388F, -1.3891F, 0.4631F, 0.2067F));

		PartDefinition Infectedarm96 = Infectedarm95.addOrReplaceChild("Infectedarm96", CubeListBuilder.create().texOffs(134, 572).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm11 = LeftFoot.addOrReplaceChild("Infectedarm11", CubeListBuilder.create().texOffs(384, 572).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.8078F, -4.388F, -2.4748F, 1.0296F, -2.4549F));

		PartDefinition Infectedarm12 = Infectedarm11.addOrReplaceChild("Infectedarm12", CubeListBuilder.create().texOffs(576, 221).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.0562F, -0.0668F, -0.8708F));

		PartDefinition Infectedarm9 = LeftFoot.addOrReplaceChild("Infectedarm9", CubeListBuilder.create().texOffs(576, 111).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 10.8078F, 1.612F, 0.5688F, -0.1532F, -1.4331F));

		PartDefinition Infectedarm10 = Infectedarm9.addOrReplaceChild("Infectedarm10", CubeListBuilder.create().texOffs(306, 564).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.0774F, 0.0403F, 0.4784F));

		PartDefinition Infectedbody43 = LeftFoot.addOrReplaceChild("Infectedbody43", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.8078F, -2.388F, 2.6207F, -0.2437F, -0.1625F));

		PartDefinition cube_r35 = Infectedbody43.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(292, 518).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, -0.7587F, 0.1457F, 0.4096F));

		PartDefinition cube_r36 = Infectedbody43.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(574, 479).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.2618F, 0.0F, -0.1309F));

		PartDefinition cube_r37 = Infectedbody43.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(0, 549).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -1.0348F, 0.1622F, 0.1147F));

		PartDefinition cube_r38 = Infectedbody43.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(552, 384).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.2164F, -0.0283F, 0.1278F));

		PartDefinition cube_r39 = Infectedbody43.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(560, 28).addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4702F, -0.1001F, -0.1942F));

		PartDefinition Infectedbody44 = Infectedbody43.addOrReplaceChild("Infectedbody44", CubeListBuilder.create().texOffs(576, 199).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -10.0F, 0.0F, -0.5672F, 0.0F, -0.3927F));

		PartDefinition Infectedbody45 = Infectedbody44.addOrReplaceChild("Infectedbody45", CubeListBuilder.create().texOffs(544, 581).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, -0.1278F, -0.5085F));

		PartDefinition Infectedbody46 = Infectedbody43.addOrReplaceChild("Infectedbody46", CubeListBuilder.create().texOffs(576, 232).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 2.0F, 0.6066F, -0.5618F, -2.1183F));

		PartDefinition Infectedbody47 = Infectedbody46.addOrReplaceChild("Infectedbody47", CubeListBuilder.create().texOffs(582, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, -0.1278F, -0.5085F));

		PartDefinition Infectedbody96 = Infectedbody43.addOrReplaceChild("Infectedbody96", CubeListBuilder.create().texOffs(576, 243).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -7.0F, -1.0F, 1.1493F, 0.4104F, 2.715F));

		PartDefinition Infectedbody97 = Infectedbody96.addOrReplaceChild("Infectedbody97", CubeListBuilder.create().texOffs(582, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, 0.1278F, 0.5085F));

		PartDefinition RightBackLeg = Ribcage.addOrReplaceChild("RightBackLeg", CubeListBuilder.create(), PartPose.offset(-11.0F, -21.0F, 73.0F));

		PartDefinition RightBack = RightBackLeg.addOrReplaceChild("RightBack", CubeListBuilder.create().texOffs(312, 412).addBox(-2.8717F, -10.0811F, -4.9146F, 9.0F, 37.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.3435F, 0.2684F, -1.0F, -0.532F, 0.2071F, 0.7724F));

		PartDefinition Infectedbody2 = RightBack.addOrReplaceChild("Infectedbody2", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.6565F, 23.7316F, 5.0F, 1.8373F, -0.1484F, -1.7675F));

		PartDefinition cube_r40 = Infectedbody2.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(354, 565).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.9079F, -0.0829F, -0.202F));

		PartDefinition cube_r41 = Infectedbody2.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(268, 555).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -10.0F, -6.0F, -0.1325F, 0.276F, 1.3342F));

		PartDefinition cube_r42 = Infectedbody2.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(538, 519).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, -1.1358F, -0.3686F, 0.0605F));

		PartDefinition cube_r43 = Infectedbody2.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(354, 554).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r44 = Infectedbody2.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(112, 564).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, -0.3054F));

		PartDefinition Infectedbody50 = RightBack.addOrReplaceChild("Infectedbody50", CubeListBuilder.create(), PartPose.offset(-1.6565F, 16.7316F, -3.0F));

		PartDefinition cube_r45 = Infectedbody50.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(386, 10).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -11.0F, 0.0F, -1.0982F, -0.1949F, -0.0026F));

		PartDefinition cube_r46 = Infectedbody50.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(236, 357).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -8.0F, 0.0F, 0.1309F, 0.0F, -0.5236F));

		PartDefinition cube_r47 = Infectedbody50.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(324, 531).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.324F, -0.007F, -0.261F));

		PartDefinition cube_r48 = Infectedbody50.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(368, 172).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.3381F, 0.0886F, -0.2467F));

		PartDefinition cube_r49 = Infectedbody50.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(90, 461).addBox(-3.5F, -4.0F, -2.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5033F, 0.1509F, 0.2666F));

		PartDefinition Infectedbody54 = RightBack.addOrReplaceChild("Infectedbody54", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.6565F, 12.7316F, 5.0F, 2.051F, -0.9719F, -2.1334F));

		PartDefinition cube_r50 = Infectedbody54.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(44, 562).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.9079F, -0.0829F, -0.202F));

		PartDefinition cube_r51 = Infectedbody54.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(28, 526).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -4.0F, -4.0F, -0.1325F, 0.276F, 1.3342F));

		PartDefinition cube_r52 = Infectedbody54.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(470, 537).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, -1.1358F, -0.3686F, 0.0605F));

		PartDefinition cube_r53 = Infectedbody54.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(464, 553).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r54 = Infectedbody54.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(564, 0).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, -0.3054F));

		PartDefinition Right = RightBack.addOrReplaceChild("Right", CubeListBuilder.create().texOffs(216, 454).addBox(-5.0F, -2.0F, -3.5F, 11.0F, 33.0F, 9.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.1283F, 23.9189F, 2.5854F, 1.7567F, 0.4545F, -0.4118F));

		PartDefinition Infectedbody3 = Right.addOrReplaceChild("Infectedbody3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.7848F, 23.8127F, 2.4146F, 2.051F, -0.9719F, -2.1334F));

		PartDefinition cube_r55 = Infectedbody3.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(526, 565).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.9079F, -0.0829F, -0.202F));

		PartDefinition cube_r56 = Infectedbody3.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(444, 558).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, -4.0F, -0.1325F, 0.276F, 1.3342F));

		PartDefinition cube_r57 = Infectedbody3.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(538, 535).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -15.0F, -14.0F, -1.1358F, -0.3686F, 0.0605F));

		PartDefinition cube_r58 = Infectedbody3.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(554, 359).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r59 = Infectedbody3.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(284, 564).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.1309F, 0.0F, -0.3054F));

		PartDefinition Infectedbody4 = Right.addOrReplaceChild("Infectedbody4", CubeListBuilder.create(), PartPose.offsetAndRotation(13.2152F, 14.8127F, 2.4146F, -0.8725F, -0.9719F, -2.1334F));

		PartDefinition cube_r60 = Infectedbody4.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(540, 565).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, -7.0F, -0.9079F, -0.0829F, -0.202F));

		PartDefinition cube_r61 = Infectedbody4.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(488, 561).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, -5.0F, -0.1325F, 0.276F, 1.3342F));

		PartDefinition cube_r62 = Infectedbody4.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(224, 539).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -15.0F, -14.0F, -1.1358F, -0.3686F, 0.0605F));

		PartDefinition cube_r63 = Infectedbody4.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(554, 370).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -13.0F, -8.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition cube_r64 = Infectedbody4.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(460, 564).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, -7.0F, 0.1309F, 0.0F, -0.3054F));

		PartDefinition Right2 = Right.addOrReplaceChild("Right2", CubeListBuilder.create().texOffs(78, 519).addBox(-3.2231F, -2.7847F, -4.1854F, 5.0F, 24.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 28.0F, 0.0F, -1.4814F, 0.2173F, 0.0193F));

		PartDefinition cube_r65 = Right2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(522, 183).addBox(-2.0F, 1.0F, -6.5F, 5.0F, 16.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.5231F, 17.2154F, 0.4146F, 0.5236F, 0.0F, 0.0F));

		PartDefinition body30 = Right2.addOrReplaceChild("body30", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.7848F, 27.8127F, 3.4146F, -1.2701F, 0.975F, 0.8673F));

		PartDefinition cube_r66 = body30.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(486, 40).addBox(-43.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(40.0F, -3.0F, 2.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition cube_r67 = body30.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(466, 93).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head27 = body30.addOrReplaceChild("head27", CubeListBuilder.create().texOffs(550, 185).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(88, 566).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(368, 566).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6378F, -0.1582F, -0.2095F));

		PartDefinition RightArm29 = body30.addOrReplaceChild("RightArm29", CubeListBuilder.create().texOffs(576, 274).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.3526F, 0.0F, 0.4363F));

		PartDefinition RightForArm29 = RightArm29.addOrReplaceChild("RightForArm29", CubeListBuilder.create().texOffs(576, 283).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm28 = body30.addOrReplaceChild("LeftArm28", CubeListBuilder.create().texOffs(576, 292).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, -1.4209F, 0.1313F, -0.3712F));

		PartDefinition LeftForArm28 = LeftArm28.addOrReplaceChild("LeftForArm28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r68 = LeftForArm28.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(576, 381).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Right3 = Right.addOrReplaceChild("Right3", CubeListBuilder.create().texOffs(106, 519).addBox(-1.1283F, -1.9189F, -4.0854F, 5.0F, 24.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 28.0F, 0.0F, -1.4805F, -0.2608F, -0.0233F));

		PartDefinition cube_r69 = Right3.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(0, 526).addBox(-3.0F, -2.0F, -6.5F, 5.0F, 14.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.6717F, 20.8311F, 3.1646F, 0.4363F, 0.0F, 0.0F));

		PartDefinition body2 = Right3.addOrReplaceChild("body2", CubeListBuilder.create(), PartPose.offsetAndRotation(2.9652F, 27.8127F, 3.4146F, -1.4653F, 1.0016F, 0.6339F));

		PartDefinition cube_r70 = body2.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(146, 508).addBox(-43.5F, 4.5F, -2.5F, 7.0F, 6.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(40.0F, -3.0F, 2.0F, 0.0F, -0.1309F, 0.0F));

		PartDefinition cube_r71 = body2.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(550, 479).addBox(-44.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(40.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		PartDefinition head2 = body2.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(550, 345).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(392, 566).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(58, 567).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, -0.75F, -0.6378F, -0.1582F, -0.2095F));

		PartDefinition RightArm2 = body2.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(576, 390).addBox(-2.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, -1.7858F, 0.0376F, -2.5348F));

		PartDefinition RightForArm2 = RightArm2.addOrReplaceChild("RightForArm2", CubeListBuilder.create().texOffs(576, 399).addBox(-2.0F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition LeftArm2 = body2.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(576, 408).addBox(-1.0F, -2.0F, -1.5F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 1.2151F, 0.0794F, 1.5089F));

		PartDefinition LeftForArm2 = LeftArm2.addOrReplaceChild("LeftForArm2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r72 = LeftForArm2.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(416, 576).addBox(-36.0F, 5.9772F, -0.9771F, 3.0F, 6.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(35.0F, -6.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		PartDefinition Tumors = Ribcage.addOrReplaceChild("Tumors", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9023F, -12.5239F, 45.9352F, -0.0698F, -0.4206F, 0.0809F));

		PartDefinition Tumor_r13 = Tumors.addOrReplaceChild("Tumor_r13", CubeListBuilder.create().texOffs(438, 103).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0977F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r14 = Tumors.addOrReplaceChild("Tumor_r14", CubeListBuilder.create().texOffs(502, 401).addBox(-5.5F, -5.5F, -5.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8864F, 0.152F, -5.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r15 = Tumors.addOrReplaceChild("Tumor_r15", CubeListBuilder.create().texOffs(348, 501).addBox(-9.0F, -10.0F, -5.0F, 12.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0977F, 2.5239F, 2.0648F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumors2 = Ribcage.addOrReplaceChild("Tumors2", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9023F, -19.5239F, 19.9352F, -2.9033F, -0.0583F, -3.0929F));

		PartDefinition Tumor_r16 = Tumors2.addOrReplaceChild("Tumor_r16", CubeListBuilder.create().texOffs(438, 131).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0977F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r17 = Tumors2.addOrReplaceChild("Tumor_r17", CubeListBuilder.create().texOffs(502, 423).addBox(-3.5F, -3.5F, -7.5F, 11.0F, 11.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.8864F, 0.152F, -0.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r18 = Tumors2.addOrReplaceChild("Tumor_r18", CubeListBuilder.create().texOffs(494, 495).addBox(-7.0F, -7.0F, -5.0F, 12.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0977F, -1.4761F, 2.0648F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumors3 = Ribcage.addOrReplaceChild("Tumors3", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.9023F, -18.5239F, 52.9352F, -2.7269F, -0.3111F, 2.6178F));

		PartDefinition Tumor_r19 = Tumors3.addOrReplaceChild("Tumor_r19", CubeListBuilder.create().texOffs(394, 519).addBox(0.0F, 0.0F, -10.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9023F, -6.4761F, 6.0648F, -0.1132F, 0.422F, 0.5307F));

		PartDefinition Tumor_r20 = Tumors3.addOrReplaceChild("Tumor_r20", CubeListBuilder.create().texOffs(438, 236).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0977F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r21 = Tumors3.addOrReplaceChild("Tumor_r21", CubeListBuilder.create().texOffs(64, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8864F, 0.152F, -5.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumors4 = Ribcage.addOrReplaceChild("Tumors4", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.9023F, -33.5239F, 12.9352F, -0.0698F, -0.4206F, 0.0809F));

		PartDefinition Tumor_r22 = Tumors4.addOrReplaceChild("Tumor_r22", CubeListBuilder.create().texOffs(440, 391).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0977F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r23 = Tumors4.addOrReplaceChild("Tumor_r23", CubeListBuilder.create().texOffs(470, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8864F, 0.152F, -5.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r24 = Tumors4.addOrReplaceChild("Tumor_r24", CubeListBuilder.create().texOffs(508, 346).addBox(-5.2774F, -3.6119F, -0.565F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0977F, -3.4761F, -2.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumors5 = Ribcage.addOrReplaceChild("Tumors5", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.9023F, -18.5239F, 22.9352F, 2.9031F, -0.3972F, 1.0866F));

		PartDefinition Tumor_r25 = Tumors5.addOrReplaceChild("Tumor_r25", CubeListBuilder.create().texOffs(112, 441).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0977F, -4.4761F, -5.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r26 = Tumors5.addOrReplaceChild("Tumor_r26", CubeListBuilder.create().texOffs(116, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.8864F, 0.152F, -5.2267F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r27 = Tumors5.addOrReplaceChild("Tumor_r27", CubeListBuilder.create().texOffs(518, 17).addBox(-5.2774F, -3.6119F, -0.5649F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0977F, -3.4761F, -2.9352F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumors6 = Ribcage.addOrReplaceChild("Tumors6", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0977F, -34.5239F, -1.0648F, 2.6475F, -0.4993F, 0.077F));

		PartDefinition Tumor_r28 = Tumors6.addOrReplaceChild("Tumor_r28", CubeListBuilder.create().texOffs(256, 443).addBox(-4.0F, -4.0F, -10.0F, 14.0F, 14.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.2608F, -2.6408F, 0.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition Tumor_r29 = Tumors6.addOrReplaceChild("Tumor_r29", CubeListBuilder.create().texOffs(418, 469).addBox(-5.5F, -5.5F, -7.5F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.4721F, 1.9873F, 1.5593F, -0.2384F, -0.1248F, 1.1897F));

		PartDefinition Tumor_r30 = Tumors6.addOrReplaceChild("Tumor_r30", CubeListBuilder.create().texOffs(250, 518).addBox(-5.2774F, -3.6119F, -0.5649F, 11.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.2608F, -1.6408F, 3.8509F, 0.2359F, 0.422F, 0.5307F));

		PartDefinition RightWing = Ribcage.addOrReplaceChild("RightWing", CubeListBuilder.create(), PartPose.offset(-18.0F, -40.0F, -13.0F));

		PartDefinition RightWingSeg1 = RightWing.addOrReplaceChild("RightWingSeg1", CubeListBuilder.create().texOffs(286, 10).addBox(-57.0F, -4.0F, -6.0F, 38.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(0, 94).addBox(-51.0F, 0.0F, 6.0F, 78.0F, 0.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.0F, 0.0F, -0.3491F, -0.3927F));

		PartDefinition cube_r73 = RightWingSeg1.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(256, 182).addBox(-30.0F, 0.0F, -4.0F, 60.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-29.0F, 0.0F, -9.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r74 = RightWingSeg1.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(174, 323).addBox(-18.0F, -15.0F, -11.0F, 19.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 4.0F, 2.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition WingThingie = RightWingSeg1.addOrReplaceChild("WingThingie", CubeListBuilder.create().texOffs(368, 104).addBox(-3.0F, -2.0F, -3.0F, 5.0F, 4.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, 0.0F, 5.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r75 = WingThingie.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(94, 275).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 3.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 1.75F, 25.0F, 0.0F, 0.48F, 0.0F));

		PartDefinition WingThingie2 = RightWingSeg1.addOrReplaceChild("WingThingie2", CubeListBuilder.create().texOffs(250, 336).addBox(-3.0F, -2.0F, -11.0F, 5.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-52.0F, 0.0F, 5.0F, 0.0F, 0.3491F, 0.0F));

		PartDefinition cube_r76 = WingThingie2.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(380, 50).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 3.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, 1.75F, 20.0F, 0.0F, -0.2618F, 0.0F));

		PartDefinition RightWingSeg2 = RightWingSeg1.addOrReplaceChild("RightWingSeg2", CubeListBuilder.create().texOffs(0, 194).addBox(-61.0F, 0.0F, 5.0F, 56.0F, 0.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-57.0F, 0.0F, 0.0F, -0.4668F, 0.7128F, -0.6565F));

		PartDefinition WingThingie3 = RightWingSeg2.addOrReplaceChild("WingThingie3", CubeListBuilder.create().texOffs(0, 389).addBox(-3.1221F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 3.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition cube_r77 = WingThingie3.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(198, 426).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 3.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1279F, 1.75F, 19.4705F, 0.0F, -0.2618F, 0.0F));

		PartDefinition WingThingie4 = RightWingSeg2.addOrReplaceChild("WingThingie4", CubeListBuilder.create().texOffs(374, 391).addBox(-3.1221F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-53.0F, 0.0F, 5.0F, 0.0F, -0.1745F, 0.0F));

		PartDefinition cube_r78 = WingThingie4.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(494, 93).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1279F, 1.75F, 19.4705F, 0.0F, 0.1745F, 0.0F));

		PartDefinition RightWingSeg3 = RightWingSeg2.addOrReplaceChild("RightWingSeg3", CubeListBuilder.create().texOffs(74, 316).addBox(-41.0F, -2.0F, -4.0F, 42.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-97.0F, 0.0F, 3.0F, 96.0F, 0.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-57.0F, -0.5F, 0.0F, 0.0F, 0.829F, 0.0F));

		PartDefinition cube_r79 = RightWingSeg3.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(262, 282).addBox(-23.5F, 0.0F, -5.0F, 47.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.5F, 0.0F, -5.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition WingThingie5 = RightWingSeg3.addOrReplaceChild("WingThingie5", CubeListBuilder.create().texOffs(392, 172).addBox(-3.1221F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-43.0F, 0.5F, 2.0F, 0.0F, -1.4399F, 0.0F));

		PartDefinition cube_r80 = WingThingie5.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(494, 117).addBox(-3.0F, -3.0F, 0.0F, 4.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1279F, 1.75F, 19.4705F, 0.0F, 0.1745F, 0.0F));

		PartDefinition RightHand = RightWingSeg2.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-51.4397F, -1.429F, -4.0424F, 1.4579F, -0.8932F, -0.6579F));

		PartDefinition cube_r81 = RightHand.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(542, 489).addBox(-9.9379F, -4.9472F, -4.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.039F, 4.809F, 7.0F, -0.2986F, -1.1295F, 0.2913F));

		PartDefinition cube_r82 = RightHand.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(434, 541).addBox(-9.9379F, -4.9472F, -4.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.961F, 1.609F, 6.0F, 0.3208F, -0.2425F, -0.2607F));

		PartDefinition cube_r83 = RightHand.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(192, 527).addBox(-10.9379F, -4.9472F, -4.0F, 9.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.961F, 1.609F, 2.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition LowerRightfinger3 = RightHand.addOrReplaceChild("LowerRightfinger3", CubeListBuilder.create(), PartPose.offsetAndRotation(2.961F, -1.391F, 3.0F, -0.0579F, 0.2555F, -0.2256F));

		PartDefinition cube_r84 = LowerRightfinger3.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(142, 369).addBox(-2.0F, -3.5F, 0.0F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-19.4182F, 4.0666F, -1.4639F, -3.0128F, -0.2476F, -2.7405F));

		PartDefinition cube_r85 = LowerRightfinger3.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(224, 275).addBox(-12.0F, -1.0F, -1.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 0.0F, -2.5F, -0.2214F, 0.1704F, -0.0381F));

		PartDefinition Infectedarm223 = LowerRightfinger3.addOrReplaceChild("Infectedarm223", CubeListBuilder.create().texOffs(446, 72).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5951F, -0.4173F, -7.6679F, -1.2987F, 0.1226F, 0.6206F));

		PartDefinition Infectedarm224 = Infectedarm223.addOrReplaceChild("Infectedarm224", CubeListBuilder.create().texOffs(190, 571).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm225 = LowerRightfinger3.addOrReplaceChild("Infectedarm225", CubeListBuilder.create().texOffs(576, 121).addBox(-2.5851F, 1.1079F, -3.2265F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, 1.9013F, 0.6693F, 3.1032F));

		PartDefinition Infectedarm226 = Infectedarm225.addOrReplaceChild("Infectedarm226", CubeListBuilder.create().texOffs(150, 572).addBox(-2.5851F, 0.1188F, -4.167F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LowerRightfinger2 = RightHand.addOrReplaceChild("LowerRightfinger2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.039F, -3.391F, -1.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r86 = LowerRightfinger2.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(398, 358).addBox(-10.9379F, -4.9472F, -3.0F, 13.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, 4.5F, 1.0F, 0.0F, 0.0F, -0.096F));

		PartDefinition Infectedarm230 = LowerRightfinger2.addOrReplaceChild("Infectedarm230", CubeListBuilder.create().texOffs(250, 323).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-12.0F, 6.0F, 0.0F, -2.4871F, 0.1309F, -2.3562F));

		PartDefinition Infectedarm_r1 = Infectedarm230.addOrReplaceChild("Infectedarm_r1", CubeListBuilder.create().texOffs(132, 401).addBox(-1.0132F, -0.4146F, -1.0916F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(50, 477).addBox(-1.4868F, -14.5854F, -1.4084F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(4.5986F, 11.2658F, -1.3036F, -0.218F, 0.0094F, -0.3501F));

		PartDefinition Infectedarm93 = Infectedarm230.addOrReplaceChild("Infectedarm93", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r2 = Infectedarm93.addOrReplaceChild("Infectedarm_r2", CubeListBuilder.create().texOffs(500, 346).addBox(-5.7183F, -3.9209F, 0.5211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1216F, 0.1353F, 0.321F));

		PartDefinition Infectedarm94 = Infectedarm230.addOrReplaceChild("Infectedarm94", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r3 = Infectedarm94.addOrReplaceChild("Infectedarm_r3", CubeListBuilder.create().texOffs(544, 55).addBox(-1.9683F, -0.4209F, 1.0211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0028F, 0.0693F, -0.1829F));

		PartDefinition Infectedarm92 = Infectedarm230.addOrReplaceChild("Infectedarm92", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r4 = Infectedarm92.addOrReplaceChild("Infectedarm_r4", CubeListBuilder.create().texOffs(74, 573).addBox(-2.9683F, -2.4209F, -0.9789F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4601F, 0.0971F, 0.033F));

		PartDefinition Infectedarm231 = Infectedarm230.addOrReplaceChild("Infectedarm231", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm_r5 = Infectedarm231.addOrReplaceChild("Infectedarm_r5", CubeListBuilder.create().texOffs(264, 577).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.8F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Infectedarm232 = Infectedarm230.addOrReplaceChild("Infectedarm232", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm_r6 = Infectedarm232.addOrReplaceChild("Infectedarm_r6", CubeListBuilder.create().texOffs(178, 578).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.9F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LowerRightfinger = RightHand.addOrReplaceChild("LowerRightfinger", CubeListBuilder.create().texOffs(336, 326).addBox(-17.0F, -1.0F, -1.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.039F, -1.391F, -4.0F, -0.0905F, -0.6505F, 0.7441F));

		PartDefinition Infectedarm237 = LowerRightfinger.addOrReplaceChild("Infectedarm237", CubeListBuilder.create().texOffs(554, 574).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 1.0F, 0.0F, 3.1416F, 0.0F, -1.3526F));

		PartDefinition Infectedarm238 = Infectedarm237.addOrReplaceChild("Infectedarm238", CubeListBuilder.create().texOffs(504, 571).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm239 = Infectedarm238.addOrReplaceChild("Infectedarm239", CubeListBuilder.create().texOffs(578, 301).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm240 = Infectedarm238.addOrReplaceChild("Infectedarm240", CubeListBuilder.create().texOffs(304, 578).addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition mass5 = RightWingSeg2.addOrReplaceChild("mass5", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 1.0F, 6.0F, 2.0646F, 0.2747F, -3.0379F));

		PartDefinition cube_r87 = mass5.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(58, 552).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r88 = mass5.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(494, 141).addBox(22.0F, -5.0F, -2.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 6.0F, -0.1276F, 0.1096F, 0.1206F));

		PartDefinition cube_r89 = mass5.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(400, 82).addBox(-22.0F, -7.0F, -5.0F, 23.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 3.0F, 0.0F, 0.7933F, -0.2241F, -0.1629F));

		PartDefinition cube_r90 = mass5.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(472, 0).addBox(-20.0F, -4.0F, -7.0F, 21.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 0.0F, 0.0F, -0.4557F, -0.2173F, 0.0894F));

		PartDefinition Infectedarm37 = mass5.addOrReplaceChild("Infectedarm37", CubeListBuilder.create().texOffs(570, 574).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -6.0F, -7.0F, -1.0007F, -0.6178F, -1.7502F));

		PartDefinition Infectedarm38 = Infectedarm37.addOrReplaceChild("Infectedarm38", CubeListBuilder.create().texOffs(0, 572).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm39 = Infectedarm38.addOrReplaceChild("Infectedarm39", CubeListBuilder.create().texOffs(580, 438).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm40 = Infectedarm38.addOrReplaceChild("Infectedarm40", CubeListBuilder.create().texOffs(350, 581).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1074F, 0.0749F, 0.6068F));

		PartDefinition bloom3 = mass5.addOrReplaceChild("bloom3", CubeListBuilder.create(), PartPose.offsetAndRotation(39.0F, 6.0F, -4.0F, 0.7418F, 0.0F, 2.9234F));

		PartDefinition cube_r91 = bloom3.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(164, 520).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r92 = bloom3.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(510, 519).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r93 = bloom3.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(458, 175).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r94 = bloom3.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(458, 159).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r95 = bloom3.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(454, 453).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r96 = bloom3.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(454, 24).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm33 = mass5.addOrReplaceChild("Infectedarm33", CubeListBuilder.create().texOffs(576, 71).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, 5.0F, -11.0F, -0.8771F, 0.573F, -0.5364F));

		PartDefinition Infectedarm34 = Infectedarm33.addOrReplaceChild("Infectedarm34", CubeListBuilder.create().texOffs(16, 572).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5144F, 0.2507F, -0.4137F));

		PartDefinition Infectedarm36 = Infectedarm34.addOrReplaceChild("Infectedarm36", CubeListBuilder.create().texOffs(358, 581).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm35 = Infectedarm34.addOrReplaceChild("Infectedarm35", CubeListBuilder.create().texOffs(520, 581).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1005F, -0.084F, -0.6939F));

		PartDefinition bloom4 = mass5.addOrReplaceChild("bloom4", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, -7.0F, 6.0F, -0.4702F, 0.1001F, 0.1942F));

		PartDefinition cube_r97 = bloom4.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(522, 157).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r98 = bloom4.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(520, 307).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r99 = bloom4.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(0, 461).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r100 = bloom4.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(354, 460).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r101 = bloom4.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(458, 207).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r102 = bloom4.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(458, 191).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm41 = mass5.addOrReplaceChild("Infectedarm41", CubeListBuilder.create().texOffs(576, 91).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 3.0F, 8.0F, 1.0649F, 0.3082F, -1.1264F));

		PartDefinition Infectedarm42 = Infectedarm41.addOrReplaceChild("Infectedarm42", CubeListBuilder.create().texOffs(82, 572).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition Infectedarm43 = Infectedarm42.addOrReplaceChild("Infectedarm43", CubeListBuilder.create().texOffs(528, 581).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Infectedarm44 = Infectedarm42.addOrReplaceChild("Infectedarm44", CubeListBuilder.create().texOffs(536, 581).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition tumor = mass5.addOrReplaceChild("tumor", CubeListBuilder.create().texOffs(374, 30).addBox(2.0F, -5.0F, -6.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 1.0F));

		PartDefinition cube_r103 = tumor.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(464, 322).addBox(9.0F, -9.0F, -6.0F, 18.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -2.0F, 3.0F, -0.1268F, 0.023F, 0.1317F));

		PartDefinition cube_r104 = tumor.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(446, 50).addBox(-1.9806F, -6.0397F, -3.6195F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.8698F, -0.0974F, 0.5018F));

		PartDefinition cube_r105 = tumor.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(494, 258).addBox(1.0F, -5.0F, -7.0F, 13.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -1.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r106 = tumor.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(256, 471).addBox(-1.0F, -6.0F, -7.0F, 15.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, -0.147F, -0.3503F, -0.1684F));

		PartDefinition Evilhand = mass5.addOrReplaceChild("Evilhand", CubeListBuilder.create(), PartPose.offsetAndRotation(41.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.829F));

		PartDefinition cube_r107 = Evilhand.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(0, 502).addBox(-2.0621F, -5.9472F, -6.0F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0036F));

		PartDefinition cube_r108 = Evilhand.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(508, 367).addBox(8.9379F, -4.9472F, -4.0F, 16.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -3.0F, 0.0F, 0.0F, 0.0F, 1.4399F));

		PartDefinition mass3 = RightWingSeg1.addOrReplaceChild("mass3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5842F, 0.4501F, 0.6536F, 0.4269F, 0.2101F, 2.271F));

		PartDefinition LLimbSeg1_r1 = mass3.addOrReplaceChild("LLimbSeg1_r1", CubeListBuilder.create().texOffs(454, 419).addBox(-10.9664F, -21.3458F, 0.5055F, 12.0F, 22.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(14.9039F, 9.8807F, -13.3639F, -0.3781F, -0.1031F, -0.6381F));

		PartDefinition mass4 = mass3.addOrReplaceChild("mass4", CubeListBuilder.create(), PartPose.offsetAndRotation(9.9803F, 13.3007F, -7.1461F, 0.829F, 0.0F, -0.1745F));

		PartDefinition Head_r7 = mass4.addOrReplaceChild("Head_r7", CubeListBuilder.create().texOffs(544, 122).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.6858F, 2.7248F, -6.2636F, 0.0F, -0.1745F, -0.6109F));

		PartDefinition LLimbSeg2_r1 = mass4.addOrReplaceChild("LLimbSeg2_r1", CubeListBuilder.create().texOffs(306, 502).addBox(-8.3135F, 3.2257F, -1.8553F, 9.0F, 20.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3179F, -3.7752F, 3.7364F, -0.9228F, -0.6321F, 0.0845F));

		PartDefinition LLimbSeg3 = mass4.addOrReplaceChild("LLimbSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(9.1415F, 11.5972F, -12.7934F, 0.0322F, 0.4573F, -0.1627F));

		PartDefinition LLimbSeg3_r1 = LLimbSeg3.addOrReplaceChild("LLimbSeg3_r1", CubeListBuilder.create().texOffs(552, 71).addBox(-2.6421F, 4.43F, -2.6093F, 4.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(434, 358).addBox(-2.1421F, -1.57F, -2.1093F, 3.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.7874F, 0.1064F, -1.2103F, 0.0F, 0.6109F, -1.0472F));

		PartDefinition Head1_r1 = LLimbSeg3.addOrReplaceChild("Head1_r1", CubeListBuilder.create().texOffs(544, 107).addBox(-8.7087F, -7.327F, -2.7458F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, 0.0F, 0.0F, -0.6109F));

		PartDefinition Torso1Arm_r1 = LLimbSeg3.addOrReplaceChild("Torso1Arm_r1", CubeListBuilder.create().texOffs(576, 210).addBox(-1.2087F, -1.327F, -3.2456F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -3.2103F, 0.3491F, 0.0F, -0.48F));

		PartDefinition LLimbSeg3_r2 = LLimbSeg3.addOrReplaceChild("LLimbSeg3_r2", CubeListBuilder.create().texOffs(370, 523).addBox(-1.7087F, -1.327F, -2.2558F, 4.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, 0.0F, 0.0F, -0.8727F));

		PartDefinition patty = LLimbSeg3.addOrReplaceChild("patty", CubeListBuilder.create(), PartPose.offset(2.7348F, 6.5929F, 0.2867F));

		PartDefinition LLimbSeg3_r3 = patty.addOrReplaceChild("LLimbSeg3_r3", CubeListBuilder.create().texOffs(200, 378).addBox(-3.0F, -5.0F, -4.0F, 8.0F, 3.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.1387F, 3.1F, 0.2574F, 0.3491F, 0.0F, -0.8727F));

		PartDefinition LLimbJawJoint = LLimbSeg3.addOrReplaceChild("LLimbJawJoint", CubeListBuilder.create().texOffs(454, 40).addBox(-8.7087F, -0.327F, -2.2456F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4898F, 3.0555F, -1.2103F, -0.2598F, 0.0506F, -0.8034F));

		PartDefinition CalciumCorpseLLimb = mass3.addOrReplaceChild("CalciumCorpseLLimb", CubeListBuilder.create(), PartPose.offset(5.7924F, 12.712F, -0.1819F));

		PartDefinition Head_r8 = CalciumCorpseLLimb.addOrReplaceChild("Head_r8", CubeListBuilder.create().texOffs(532, 0).addBox(-4.0F, -4.5F, -6.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.5057F, 5.7465F, 1.818F, 0.4331F, -0.0552F, 2.9113F));

		PartDefinition Arm_r7 = CalciumCorpseLLimb.addOrReplaceChild("Arm_r7", CubeListBuilder.create().texOffs(476, 573).addBox(-1.5F, -4.0F, -1.5F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4798F, 1.904F, -2.682F, 0.6429F, -0.1321F, 2.9666F));

		PartDefinition TorsoBottom_r1 = CalciumCorpseLLimb.addOrReplaceChild("TorsoBottom_r1", CubeListBuilder.create().texOffs(376, 326).addBox(-3.5F, 3.0F, -1.75F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(224, 527).addBox(-4.0F, -3.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1115F, -0.8313F, 1.318F, 0.0F, 0.0F, 2.7925F));

		PartDefinition LeftWing = Ribcage.addOrReplaceChild("LeftWing", CubeListBuilder.create(), PartPose.offset(18.0F, -40.0F, -13.0F));

		PartDefinition RightWingSeg = LeftWing.addOrReplaceChild("RightWingSeg", CubeListBuilder.create().texOffs(0, 144).addBox(-27.0F, 0.0F, 6.0F, 78.0F, 0.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.0F, 0.0F, 0.3491F, 0.3927F));

		PartDefinition cube_r109 = RightWingSeg.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(256, 236).addBox(-30.0F, 0.0F, -4.0F, 60.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(29.0F, 0.0F, -9.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition cube_r110 = RightWingSeg.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(336, 292).addBox(-1.0F, -15.0F, -11.0F, 19.0F, 15.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.6981F));

		PartDefinition mass = RightWingSeg.addOrReplaceChild("mass", CubeListBuilder.create(), PartPose.offset(16.0F, 4.0F, 2.0F));

		PartDefinition cube_r111 = mass.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(564, 562).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4764F, 2.1029F, -9.1662F, 1.3263F, -0.0851F, -1.792F));

		PartDefinition cube_r112 = mass.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(564, 9).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.4764F, 1.1029F, -2.1662F, 2.074F, -0.5851F, -2.0768F));

		PartDefinition cube_r113 = mass.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(552, 225).addBox(1.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.4764F, 4.1029F, -7.1662F, 1.442F, -0.7225F, -1.8833F));

		PartDefinition cube_r114 = mass.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(286, 62).addBox(-10.5F, 1.5F, -4.0F, 34.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0236F, 0.5778F, -0.1766F, -3.0127F, -0.0227F, -0.0015F));

		PartDefinition mass2 = mass.addOrReplaceChild("mass2", CubeListBuilder.create(), PartPose.offsetAndRotation(16.4764F, -1.9222F, -0.1766F, 0.2132F, -0.0469F, 0.2132F));

		PartDefinition cube_r115 = mass2.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(470, 519).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.9633F, 0.4933F, -1.8658F, 0.3155F, -0.2494F, -0.0804F));

		PartDefinition cube_r116 = mass2.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(168, 441).addBox(-7.0F, -11.0F, 0.0F, 15.0F, 10.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9633F, -7.5067F, -1.8658F, -0.8358F, 0.0651F, -0.2084F));

		PartDefinition cube_r117 = mass2.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(518, 445).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9633F, -0.5067F, -1.8658F, 0.2986F, 0.0651F, -0.2084F));

		PartDefinition cube_r118 = mass2.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(430, 264).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5367F, -0.5067F, -5.8658F, -0.8657F, -0.147F, -0.0945F));

		PartDefinition cube_r119 = mass2.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(152, 357).addBox(-4.0F, -5.0F, -5.0F, 27.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.9633F, -4.5067F, -4.8658F, 0.0F, -0.0873F, 0.0F));

		PartDefinition WingThingie6 = RightWingSeg.addOrReplaceChild("WingThingie6", CubeListBuilder.create().texOffs(368, 138).addBox(-2.0F, -2.0F, -3.0F, 5.0F, 4.0F, 30.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 0.0F, 5.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r120 = WingThingie6.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(178, 282).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 38.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 1.75F, 25.0F, 0.0F, -0.48F, 0.0F));

		PartDefinition WingThingie7 = RightWingSeg.addOrReplaceChild("WingThingie7", CubeListBuilder.create().texOffs(324, 336).addBox(-2.0F, -2.0F, -11.0F, 5.0F, 4.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(52.0F, 0.0F, 5.0F, 0.0F, -0.3491F, 0.0F));

		PartDefinition cube_r121 = WingThingie7.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(392, 204).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, 1.75F, 20.0F, 0.0F, 0.2618F, 0.0F));

		PartDefinition LeftWingSeg2 = RightWingSeg.addOrReplaceChild("LeftWingSeg2", CubeListBuilder.create().texOffs(196, 194).addBox(5.0F, 0.0F, 5.0F, 56.0F, 0.0F, 42.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(57.0F, 0.0F, 0.0F, -0.4668F, -0.7128F, 0.6565F));

		PartDefinition cube_r122 = LeftWingSeg2.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(256, 94).addBox(-31.0F, 0.0F, -5.0F, 62.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(28.0F, 0.0F, -8.0F, 3.1416F, 0.0F, 0.0F));

		PartDefinition RLimbSeg2 = LeftWingSeg2.addOrReplaceChild("RLimbSeg2", CubeListBuilder.create().texOffs(256, 539).addBox(-0.6223F, -2.0841F, -10.3419F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(51.7742F, -0.4365F, -1.8763F, -0.9163F, 1.1781F, 0.0F));

		PartDefinition Limb_r1 = RLimbSeg2.addOrReplaceChild("Limb_r1", CubeListBuilder.create().texOffs(318, 563).addBox(-1.9985F, -0.926F, -1.7191F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.3987F, 7.7672F, -4.9586F, -0.6167F, 0.2351F, 0.3175F));

		PartDefinition RLimbSeg2_r1 = RLimbSeg2.addOrReplaceChild("RLimbSeg2_r1", CubeListBuilder.create().texOffs(168, 489).addBox(-3.6865F, 3.2257F, -1.8553F, 12.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0036F, -3.5F, 3.0F, -0.9228F, 0.6321F, -0.0845F));

		PartDefinition RLimbSeg2Seg2 = RLimbSeg2.addOrReplaceChild("RLimbSeg2Seg2", CubeListBuilder.create(), PartPose.offset(-2.9792F, 14.1075F, -9.1735F));

		PartDefinition RLimbSeg2Seg2_r1 = RLimbSeg2Seg2.addOrReplaceChild("RLimbSeg2Seg2_r1", CubeListBuilder.create().texOffs(508, 40).addBox(-3.6865F, 11.2257F, -0.8553F, 11.0F, 21.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0245F, 0.3925F, -4.8265F, -0.7046F, 0.5448F, 0.0464F));

		PartDefinition RLimbSeg2Seg2_r2 = RLimbSeg2Seg2.addOrReplaceChild("RLimbSeg2Seg2_r2", CubeListBuilder.create().texOffs(434, 519).addBox(-3.6865F, 17.2257F, -0.8553F, 11.0F, 15.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0245F, -9.6075F, 10.1735F, -0.9228F, 0.5448F, 0.0464F));

		PartDefinition RLimbSeg3 = RLimbSeg2Seg2.addOrReplaceChild("RLimbSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.4704F, 8.301F, -7.6848F, 0.0322F, -0.4573F, 0.1627F));

		PartDefinition Arm_r8 = RLimbSeg3.addOrReplaceChild("Arm_r8", CubeListBuilder.create().texOffs(368, 572).addBox(-2.1777F, -0.2936F, -1.9698F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5581F, 5.6904F, -0.9F, 0.0F, 0.0F, 0.1309F));

		PartDefinition RLimbSeg3_r1 = RLimbSeg3.addOrReplaceChild("RLimbSeg3_r1", CubeListBuilder.create().texOffs(152, 340).addBox(1.3961F, -9.0599F, -3.5049F, 7.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.74F, 2.2474F, 0.618F, 0.0F, 0.0F, 0.829F));

		PartDefinition RLimbHeadJoint = RLimbSeg3.addOrReplaceChild("RLimbHeadJoint", CubeListBuilder.create().texOffs(544, 92).addBox(-4.0727F, -3.464F, -7.9992F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.7698F, 6.2004F, -1.9173F, 0.3491F, 0.0F, 0.829F));

		PartDefinition WingThingie8 = LeftWingSeg2.addOrReplaceChild("WingThingie8", CubeListBuilder.create().texOffs(200, 394).addBox(-1.8779F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 3.0F, 0.0F, 0.4363F, 0.0F));

		PartDefinition cube_r123 = WingThingie8.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(54, 433).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 25.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1279F, 1.75F, 19.4705F, 0.0F, 0.2618F, 0.0F));

		PartDefinition WingThingie9 = LeftWingSeg2.addOrReplaceChild("WingThingie9", CubeListBuilder.create().texOffs(398, 326).addBox(-1.8779F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(53.0F, 0.0F, 5.0F, 0.0F, 0.1745F, 0.0F));

		PartDefinition cube_r124 = WingThingie9.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(494, 234).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1279F, 1.75F, 19.4705F, 0.0F, -0.1745F, 0.0F));

		PartDefinition LeftWingSeg3 = LeftWingSeg2.addOrReplaceChild("LeftWingSeg3", CubeListBuilder.create().texOffs(74, 328).addBox(-1.0F, -2.0F, -4.0F, 42.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 47).addBox(1.0F, 0.0F, 3.0F, 96.0F, 0.0F, 47.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(57.0F, -0.5F, 0.0F, 0.0F, -0.829F, 0.0F));

		PartDefinition cube_r125 = LeftWingSeg3.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(286, 0).addBox(-23.5F, 0.0F, -5.0F, 47.0F, 0.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(20.5F, 0.0F, -5.0F, -3.1416F, 0.0F, 0.0F));

		PartDefinition WingThingie10 = LeftWingSeg3.addOrReplaceChild("WingThingie10", CubeListBuilder.create().texOffs(66, 401).addBox(-1.8779F, -2.0F, -6.5295F, 5.0F, 4.0F, 28.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(43.0F, 0.5F, 2.0F, 0.0F, 1.4399F, 0.0F));

		PartDefinition cube_r126 = WingThingie10.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(256, 494).addBox(-1.0F, -3.0F, 0.0F, 4.0F, 3.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1279F, 1.75F, 19.4705F, 0.0F, -0.1745F, 0.0F));

		PartDefinition LeftHand = LeftWingSeg2.addOrReplaceChild("LeftHand", CubeListBuilder.create(), PartPose.offsetAndRotation(54.4397F, -2.429F, -4.0424F, 0.0F, 1.4835F, -0.1309F));

		PartDefinition cube_r127 = LeftHand.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(544, 38).addBox(1.9379F, -4.9472F, -4.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.961F, 1.609F, 6.0F, 0.3208F, 0.2425F, 0.2607F));

		PartDefinition cube_r128 = LeftHand.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(292, 531).addBox(1.9379F, -4.9472F, -4.0F, 9.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.961F, 1.609F, 2.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition LowerLeftfinger4 = LeftHand.addOrReplaceChild("LowerLeftfinger4", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.961F, -3.391F, 3.0F, 0.0F, -0.829F, -0.3054F));

		PartDefinition cube_r129 = LowerLeftfinger4.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(464, 346).addBox(-2.0621F, -4.9472F, -3.0F, 13.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.35F, 4.5F, 1.0F, 0.0F, 0.0F, 0.096F));

		PartDefinition Infectedarm20 = LowerLeftfinger4.addOrReplaceChild("Infectedarm20", CubeListBuilder.create().texOffs(54, 421).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0F, 6.0F, 0.0F, -2.4871F, -0.1309F, 2.3562F));

		PartDefinition Infectedarm_r7 = Infectedarm20.addOrReplaceChild("Infectedarm_r7", CubeListBuilder.create().texOffs(256, 426).addBox(-0.9868F, -0.4146F, -1.0916F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(212, 559).addBox(-1.5132F, -14.5854F, -1.4084F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.5986F, 11.2658F, -1.3036F, -0.218F, -0.0094F, 0.3501F));

		PartDefinition Infectedarm21 = Infectedarm20.addOrReplaceChild("Infectedarm21", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r8 = Infectedarm21.addOrReplaceChild("Infectedarm_r8", CubeListBuilder.create().texOffs(312, 578).addBox(1.7183F, -3.9209F, 0.5211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1216F, -0.1353F, -0.321F));

		PartDefinition Infectedarm22 = Infectedarm20.addOrReplaceChild("Infectedarm22", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r9 = Infectedarm22.addOrReplaceChild("Infectedarm_r9", CubeListBuilder.create().texOffs(578, 313).addBox(-2.0317F, -0.4209F, 1.0211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0028F, -0.0693F, 0.1829F));

		PartDefinition Infectedarm23 = Infectedarm20.addOrReplaceChild("Infectedarm23", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r10 = Infectedarm23.addOrReplaceChild("Infectedarm_r10", CubeListBuilder.create().texOffs(320, 578).addBox(-1.0317F, -2.4209F, -0.9789F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4601F, -0.0971F, -0.033F));

		PartDefinition Infectedarm24 = Infectedarm20.addOrReplaceChild("Infectedarm24", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Infectedarm_r11 = Infectedarm24.addOrReplaceChild("Infectedarm_r11", CubeListBuilder.create().texOffs(578, 359).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.8F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Infectedarm25 = Infectedarm20.addOrReplaceChild("Infectedarm25", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition Infectedarm_r12 = Infectedarm25.addOrReplaceChild("Infectedarm_r12", CubeListBuilder.create().texOffs(578, 426).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.9F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LowerLeftfinger5 = LeftHand.addOrReplaceChild("LowerLeftfinger5", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.961F, -1.641F, -3.25F, 0.0F, 0.3927F, -0.3054F));

		PartDefinition cube_r130 = LowerLeftfinger5.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(520, 333).addBox(-2.0621F, -4.9472F, -3.0F, 13.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.35F, 4.5F, 1.0F, 0.0F, 0.0F, 0.096F));

		PartDefinition Infectedarm26 = LowerLeftfinger5.addOrReplaceChild("Infectedarm26", CubeListBuilder.create().texOffs(166, 572).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(12.0F, 6.0F, 2.0F, 3.0543F, -0.1309F, 2.3562F));

		PartDefinition Infectedarm_r13 = Infectedarm26.addOrReplaceChild("Infectedarm_r13", CubeListBuilder.create().texOffs(32, 572).addBox(-0.9868F, -0.4146F, -1.0916F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.1F))
		.texOffs(178, 560).addBox(-1.5132F, -14.5854F, -1.4084F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-4.5986F, 11.2658F, -1.3036F, -0.218F, -0.0094F, 0.3501F));

		PartDefinition Infectedarm27 = Infectedarm26.addOrReplaceChild("Infectedarm27", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r14 = Infectedarm27.addOrReplaceChild("Infectedarm_r14", CubeListBuilder.create().texOffs(580, 131).addBox(1.7183F, -3.9209F, 0.5211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1216F, -0.1353F, -0.321F));

		PartDefinition Infectedarm28 = Infectedarm26.addOrReplaceChild("Infectedarm28", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r15 = Infectedarm28.addOrReplaceChild("Infectedarm_r15", CubeListBuilder.create().texOffs(580, 143).addBox(-2.0317F, -0.4209F, 1.0211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0028F, -0.0693F, 0.1829F));

		PartDefinition Infectedarm29 = Infectedarm26.addOrReplaceChild("Infectedarm29", CubeListBuilder.create(), PartPose.offset(-8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r16 = Infectedarm29.addOrReplaceChild("Infectedarm_r16", CubeListBuilder.create().texOffs(580, 155).addBox(-1.0317F, -2.4209F, -0.9789F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4601F, -0.0971F, -0.033F));

		PartDefinition Infectedarm30 = Infectedarm26.addOrReplaceChild("Infectedarm30", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Infectedarm_r17 = Infectedarm30.addOrReplaceChild("Infectedarm_r17", CubeListBuilder.create().texOffs(580, 167).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.8F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Infectedarm31 = Infectedarm26.addOrReplaceChild("Infectedarm31", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition Infectedarm_r18 = Infectedarm31.addOrReplaceChild("Infectedarm_r18", CubeListBuilder.create().texOffs(580, 325).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.9F, -0.0873F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		float v1 = Mth.sin(ageInTicks/6)/6;
		float v2 = Mth.cos(ageInTicks/6)/7;
		float v3 = Mth.sin(ageInTicks/7)/8;
		float v4 = Mth.cos(ageInTicks/8)/9;
		float v5 = Mth.sin(ageInTicks/9)/6;

		animateTumor(Tumors,v1);
		animateTumor(Tumors2,v2);
		animateTumor(Tumors3,v3);
		animateTumor(Tumors4,v4);
		animateTumor(Tumors5,v5);
		animateTumor(Tumors6,v2);
		animateTumor(Tumors7,v3);
		animateTumor(Tumors8,v4);
		animateTumor(Tumors9,v5);
		animateTumor(Tumors10,v2);
		animateTentacleZ(LowerLeftfinger4,v3);
		animateTentacleZ(Infectedarm20,v3);
		animateTentacleZ(LowerLeftfinger5,v4);
		animateTentacleZ(Infectedarm26,v4);

		animateTentacleZ(Infectedarm37,v2);
		animateTentacleZ(Infectedarm33,v4);
		animateTentacleZ(Infectedarm41,v3);
		animateTentacleY(Infectedarm225,v5);
		animateTentacleX(Infectedarm223,-v5);
		animateTentacleZ(LowerRightfinger2,v2);
		animateTentacleZ(Infectedarm230,v4);
		animateTentacleZ(LowerRightfinger,v3);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Ribcage.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}