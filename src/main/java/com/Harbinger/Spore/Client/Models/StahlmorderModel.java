package com.Harbinger.Spore.Client.Models;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
import com.Harbinger.Spore.Client.Animations.StahlmorderModelAnimation;
import com.Harbinger.Spore.Sentities.Calamities.Stahlmorder;
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

public class StahlmorderModel<T extends Stahlmorder> extends HierarchicalModel<T> implements TentacledModel{
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Spore.MODID, "stahlmordermodel"), "main");
	private final ModelPart panzer;
	public final ModelPart Leftleg;
	private final ModelPart leftLegTumor;
	private final ModelPart Infectedbody99;
	private final ModelPart Infectedbody53;
	private final ModelPart bloom;
	private final ModelPart Infectedbody54;
	private final ModelPart LeftForLeg;
	private final ModelPart Infectedbody51;
	private final ModelPart LowerLeftleg2;
	private final ModelPart Infectedarm21;
	private final ModelPart Infectedarm22;
	private final ModelPart Infectedarm15;
	private final ModelPart Infectedarm16;
	private final ModelPart Infectedbody52;
	public final ModelPart Rightleg;
	private final ModelPart Infectedbody50;
	private final ModelPart Infectedarm5;
	private final ModelPart Infectedarm6;
	private final ModelPart Infectedarm3;
	private final ModelPart Infectedarm4;
	private final ModelPart Infectedarm;
	private final ModelPart Infectedarm2;
	private final ModelPart rightLegTumor;
	private final ModelPart Infectedbody42;
	private final ModelPart RightForLeg;
	private final ModelPart Infectedbody48;
	private final ModelPart bloom6;
	private final ModelPart LowerRightleg2;
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
	private final ModelPart Hipsguh;
	private final ModelPart Lowerbody;
	private final ModelPart AssTumor;
	private final ModelPart Tendril2;
	private final ModelPart Seg2Tendril2;
	private final ModelPart Seg3Tendril2;
	private final ModelPart Seg4Tendril2;
	private final ModelPart Upperbody;
	public final ModelPart Mouth;
	private final ModelPart Upperjaw;
	private final ModelPart Infectedbody14;
	private final ModelPart Infectedbody15;
	private final ModelPart Infectedbody16;
	private final ModelPart Infectedbody17;
	private final ModelPart Infectedbody9;
	private final ModelPart Infectedbody10;
	private final ModelPart Infectedbody13;
	private final ModelPart Infectedbody11;
	private final ModelPart Infectedbody12;
	private final ModelPart Infectedbody2;
	private final ModelPart Infectedbody3;
	private final ModelPart Infectedbody4;
	private final ModelPart Infectedbody;
	private final ModelPart Infectedbody5;
	private final ModelPart Infectedbody8;
	private final ModelPart Infectedbody6;
	private final ModelPart Infectedbody18;
	private final ModelPart Infectedbody19;
	private final ModelPart Infectedbody20;
	private final ModelPart Infectedbody21;
	private final ModelPart Lowerjaw;
	private final ModelPart Infectedbody26;
	private final ModelPart Infectedbody27;
	private final ModelPart Infectedbody28;
	private final ModelPart Infectedbody29;
	private final ModelPart Infectedbody108;
	private final ModelPart Infectedbody30;
	private final ModelPart Infectedbody31;
	private final ModelPart Infectedbody32;
	private final ModelPart Infectedbody33;
	private final ModelPart Infectedbody34;
	private final ModelPart Infectedbody35;
	private final ModelPart Infectedbody36;
	private final ModelPart Infectedbody37;
	private final ModelPart Infectedbody38;
	private final ModelPart Tumor2;
	private final ModelPart Infectedbody39;
	private final ModelPart Infectedbody40;
	private final ModelPart Infectedbody41;
	private final ModelPart Infectedbody98;
	public final ModelPart Evilshoulder;
	private final ModelPart Leftarmmain;
	private final ModelPart bloom2;
	private final ModelPart Leftarm;
	private final ModelPart Root3;
	private final ModelPart R3Seg1;
	private final ModelPart R3Seg2;
	private final ModelPart R3Seg3;
	private final ModelPart RootSeg;
	private final ModelPart Root4;
	private final ModelPart R3Seg13;
	private final ModelPart R3Seg14;
	private final ModelPart R3Seg15;
	private final ModelPart RootSeg2;
	private final ModelPart Root5;
	private final ModelPart R3Seg16;
	private final ModelPart R3Seg17;
	private final ModelPart R3Seg18;
	private final ModelPart RootSeg3;
	private final ModelPart Lowersegleftarm;
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
	private final ModelPart BladeArmTumor;
	private final ModelPart Evilhand;
	private final ModelPart Bigahhblade;
	private final ModelPart Spitter;
	private final ModelPart Spitterneck;
	private final ModelPart Infectedbody87;
	private final ModelPart Infectedbody88;
	private final ModelPart Infectedbody89;
	private final ModelPart Infectedbody90;
	private final ModelPart Infectedbody91;
	private final ModelPart Spitterhead;
	private final ModelPart Spitterjawright;
	private final ModelPart Lowerspitterjawrigth;
	private final ModelPart Spitterjawleft;
	private final ModelPart Lowerspitterjawleft;
	private final ModelPart Spitterarmleft;
	private final ModelPart Spitterarmright;
	private final ModelPart Spitter2;
	private final ModelPart Spitterneck2;
	private final ModelPart Infectedbody67;
	private final ModelPart Infectedbody69;
	private final ModelPart Infectedbody101;
	private final ModelPart Infectedbody102;
	private final ModelPart Infectedbody103;
	private final ModelPart Spitterhead2;
	private final ModelPart Spitterjawright2;
	private final ModelPart Lowerspitterjawrigth2;
	private final ModelPart Spitterjawleft2;
	private final ModelPart Lowerspitterjawleft2;
	private final ModelPart Spitterarmleft2;
	private final ModelPart Spitterarmright2;
	private final ModelPart Infectedbody109;
	public final ModelPart UpperRightarm;
	private final ModelPart bloom5;
	private final ModelPart Infectedarm49;
	private final ModelPart Infectedarm50;
	private final ModelPart Infectedarm31;
	private final ModelPart Infectedarm32;
	private final ModelPart Infectedarm47;
	private final ModelPart Infectedarm48;
	private final ModelPart Infectedarm45;
	private final ModelPart Infectedarm46;
	private final ModelPart Infectedarm77;
	private final ModelPart Infectedarm78;
	private final ModelPart LowersegRightarm;
	private final ModelPart Infectedarm87;
	private final ModelPart Infectedarm88;
	private final ModelPart Infectedarm89;
	private final ModelPart Infectedarm90;
	private final ModelPart Infectedarm83;
	private final ModelPart Infectedarm84;
	private final ModelPart Infectedarm85;
	private final ModelPart Infectedarm86;
	private final ModelPart Infectedbody66;
	private final ModelPart Infectedarm79;
	private final ModelPart Infectedarm80;
	private final ModelPart Infectedarm81;
	private final ModelPart Infectedarm82;
	private final ModelPart Infectedbody68;
	private final ModelPart Infectedbody70;
	private final ModelPart Infectedarm27;
	private final ModelPart Infectedarm28;
	private final ModelPart Infectedarm25;
	private final ModelPart Infectedarm26;
	private final ModelPart Infectedarm23;
	private final ModelPart Infectedarm24;
	private final ModelPart Infectedbody65;
	private final ModelPart hand;
	private final ModelPart Infectedarm53;
	private final ModelPart Infectedarm54;
	private final ModelPart Infectedarm51;
	private final ModelPart Infectedarm52;
	private final ModelPart UpperRightfinger;
	private final ModelPart Infectedarm71;
	private final ModelPart Infectedarm72;
	private final ModelPart Infectedarm73;
	private final ModelPart Infectedarm74;
	private final ModelPart Infectedarm69;
	private final ModelPart Infectedarm70;
	private final ModelPart Infectedarm75;
	private final ModelPart Infectedarm76;
	private final ModelPart UpperRightfinger2;
	private final ModelPart Infectedarm67;
	private final ModelPart Infectedarm68;
	private final ModelPart Infectedarm59;
	private final ModelPart Infectedarm60;
	private final ModelPart Infectedarm61;
	private final ModelPart Infectedarm62;
	private final ModelPart UpperRightfinger1;
	private final ModelPart Infectedarm63;
	private final ModelPart Infectedarm64;
	private final ModelPart Infectedarm65;
	private final ModelPart Infectedarm66;
	private final ModelPart Infectedarm55;
	private final ModelPart Infectedarm56;
	private final ModelPart Infectedarm57;
	private final ModelPart Infectedarm58;
	public final ModelPart LowerRightarm;
	private final ModelPart LowerRightarmLowerSegmentButFreakyToo;
	private final ModelPart Infectedarm197;
	private final ModelPart Infectedarm198;
	private final ModelPart Infectedarm199;
	private final ModelPart Infectedarm200;
	private final ModelPart Infectedarm201;
	private final ModelPart Infectedarm202;
	private final ModelPart Infectedarm203;
	private final ModelPart Infectedarm204;
	private final ModelPart Infectedbody114;
	private final ModelPart Infectedarm205;
	private final ModelPart Infectedarm206;
	private final ModelPart Infectedarm207;
	private final ModelPart Infectedarm208;
	private final ModelPart Infectedarm209;
	private final ModelPart Infectedarm210;
	private final ModelPart Infectedarm211;
	private final ModelPart Infectedarm212;
	private final ModelPart Infectedarm213;
	private final ModelPart Infectedarm214;
	private final ModelPart hand2;
	private final ModelPart Infectedarm215;
	private final ModelPart Infectedarm216;
	private final ModelPart Infectedarm217;
	private final ModelPart Infectedarm218;
	private final ModelPart LowerRightfinger3;
	private final ModelPart Infectedarm219;
	private final ModelPart Infectedarm220;
	private final ModelPart Infectedarm221;
	private final ModelPart Infectedarm222;
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
	private final ModelPart Infectedarm233;
	private final ModelPart Infectedarm234;
	private final ModelPart Infectedarm235;
	private final ModelPart Infectedarm236;
	private final ModelPart Infectedarm237;
	private final ModelPart Infectedarm238;
	private final ModelPart Infectedarm239;
	private final ModelPart Infectedarm240;
	private final ModelPart bodies;
	private final ModelPart Infectedbody56;
	private final ModelPart Infectedbody57;
	private final ModelPart bone20;
	private final ModelPart Infectedbody55;
	private final ModelPart Infectedbody58;
	private final ModelPart Infectedbody59;
	private final ModelPart Infectedbody60;
	private final ModelPart Infectedbody100;
	private final ModelPart Infectedbody62;
	private final ModelPart Infectedbody63;
	private final ModelPart details;
	private final ModelPart Root2;
	private final ModelPart R3Seg10;
	private final ModelPart R3Seg11;
	private final ModelPart R3Seg12;
	private final ModelPart spike2;
	private final ModelPart spike;
	private final ModelPart bone57;
	private final ModelPart bone58;
	private final ModelPart R3Seg7;
	private final ModelPart R3Seg8;
	private final ModelPart R3Seg9;
	private final ModelPart shroom;
	private final ModelPart Tumor;
	private final ModelPart shroom3;
	private final ModelPart bone29;
	private final ModelPart bone30;

	public StahlmorderModel() {
		ModelPart root = createBodyLayer().bakeRoot();
		this.panzer = root.getChild("panzer");
		this.Leftleg = this.panzer.getChild("Leftleg");
		this.leftLegTumor = this.Leftleg.getChild("leftLegTumor");
		this.Infectedbody99 = this.Leftleg.getChild("Infectedbody99");
		this.Infectedbody53 = this.Leftleg.getChild("Infectedbody53");
		this.bloom = this.Leftleg.getChild("bloom");
		this.Infectedbody54 = this.Leftleg.getChild("Infectedbody54");
		this.LeftForLeg = this.Leftleg.getChild("LeftForLeg");
		this.Infectedbody51 = this.LeftForLeg.getChild("Infectedbody51");
		this.LowerLeftleg2 = this.LeftForLeg.getChild("LowerLeftleg2");
		this.Infectedarm21 = this.LowerLeftleg2.getChild("Infectedarm21");
		this.Infectedarm22 = this.Infectedarm21.getChild("Infectedarm22");
		this.Infectedarm15 = this.LowerLeftleg2.getChild("Infectedarm15");
		this.Infectedarm16 = this.Infectedarm15.getChild("Infectedarm16");
		this.Infectedbody52 = this.LowerLeftleg2.getChild("Infectedbody52");
		this.Rightleg = this.panzer.getChild("Rightleg");
		this.Infectedbody50 = this.Rightleg.getChild("Infectedbody50");
		this.Infectedarm5 = this.Rightleg.getChild("Infectedarm5");
		this.Infectedarm6 = this.Infectedarm5.getChild("Infectedarm6");
		this.Infectedarm3 = this.Rightleg.getChild("Infectedarm3");
		this.Infectedarm4 = this.Infectedarm3.getChild("Infectedarm4");
		this.Infectedarm = this.Rightleg.getChild("Infectedarm");
		this.Infectedarm2 = this.Infectedarm.getChild("Infectedarm2");
		this.rightLegTumor = this.Rightleg.getChild("rightLegTumor");
		this.Infectedbody42 = this.Rightleg.getChild("Infectedbody42");
		this.RightForLeg = this.Rightleg.getChild("RightForLeg");
		this.Infectedbody48 = this.RightForLeg.getChild("Infectedbody48");
		this.bloom6 = this.RightForLeg.getChild("bloom6");
		this.LowerRightleg2 = this.RightForLeg.getChild("LowerRightleg2");
		this.Infectedarm95 = this.LowerRightleg2.getChild("Infectedarm95");
		this.Infectedarm96 = this.Infectedarm95.getChild("Infectedarm96");
		this.Infectedarm11 = this.LowerRightleg2.getChild("Infectedarm11");
		this.Infectedarm12 = this.Infectedarm11.getChild("Infectedarm12");
		this.Infectedarm9 = this.LowerRightleg2.getChild("Infectedarm9");
		this.Infectedarm10 = this.Infectedarm9.getChild("Infectedarm10");
		this.Infectedbody43 = this.LowerRightleg2.getChild("Infectedbody43");
		this.Infectedbody44 = this.Infectedbody43.getChild("Infectedbody44");
		this.Infectedbody45 = this.Infectedbody44.getChild("Infectedbody45");
		this.Infectedbody46 = this.Infectedbody43.getChild("Infectedbody46");
		this.Infectedbody47 = this.Infectedbody46.getChild("Infectedbody47");
		this.Infectedbody96 = this.Infectedbody43.getChild("Infectedbody96");
		this.Infectedbody97 = this.Infectedbody96.getChild("Infectedbody97");
		this.Hipsguh = this.panzer.getChild("Hipsguh");
		this.Lowerbody = this.Hipsguh.getChild("Lowerbody");
		this.AssTumor = this.Lowerbody.getChild("AssTumor");
		this.Tendril2 = this.Lowerbody.getChild("Tendril2");
		this.Seg2Tendril2 = this.Tendril2.getChild("Seg2Tendril2");
		this.Seg3Tendril2 = this.Seg2Tendril2.getChild("Seg3Tendril2");
		this.Seg4Tendril2 = this.Seg3Tendril2.getChild("Seg4Tendril2");
		this.Upperbody = this.Lowerbody.getChild("Upperbody");
		this.Mouth = this.Upperbody.getChild("Mouth");
		this.Upperjaw = this.Mouth.getChild("Upperjaw");
		this.Infectedbody14 = this.Upperjaw.getChild("Infectedbody14");
		this.Infectedbody15 = this.Infectedbody14.getChild("Infectedbody15");
		this.Infectedbody16 = this.Infectedbody15.getChild("Infectedbody16");
		this.Infectedbody17 = this.Infectedbody16.getChild("Infectedbody17");
		this.Infectedbody9 = this.Upperjaw.getChild("Infectedbody9");
		this.Infectedbody10 = this.Infectedbody9.getChild("Infectedbody10");
		this.Infectedbody13 = this.Infectedbody10.getChild("Infectedbody13");
		this.Infectedbody11 = this.Infectedbody10.getChild("Infectedbody11");
		this.Infectedbody12 = this.Infectedbody11.getChild("Infectedbody12");
		this.Infectedbody2 = this.Upperjaw.getChild("Infectedbody2");
		this.Infectedbody3 = this.Infectedbody2.getChild("Infectedbody3");
		this.Infectedbody4 = this.Infectedbody3.getChild("Infectedbody4");
		this.Infectedbody = this.Infectedbody2.getChild("Infectedbody");
		this.Infectedbody5 = this.Upperjaw.getChild("Infectedbody5");
		this.Infectedbody8 = this.Infectedbody5.getChild("Infectedbody8");
		this.Infectedbody6 = this.Infectedbody8.getChild("Infectedbody6");
		this.Infectedbody18 = this.Upperjaw.getChild("Infectedbody18");
		this.Infectedbody19 = this.Infectedbody18.getChild("Infectedbody19");
		this.Infectedbody20 = this.Infectedbody19.getChild("Infectedbody20");
		this.Infectedbody21 = this.Infectedbody20.getChild("Infectedbody21");
		this.Lowerjaw = this.Mouth.getChild("Lowerjaw");
		this.Infectedbody26 = this.Lowerjaw.getChild("Infectedbody26");
		this.Infectedbody27 = this.Infectedbody26.getChild("Infectedbody27");
		this.Infectedbody28 = this.Infectedbody27.getChild("Infectedbody28");
		this.Infectedbody29 = this.Infectedbody27.getChild("Infectedbody29");
		this.Infectedbody108 = this.Infectedbody29.getChild("Infectedbody108");
		this.Infectedbody30 = this.Infectedbody29.getChild("Infectedbody30");
		this.Infectedbody31 = this.Lowerjaw.getChild("Infectedbody31");
		this.Infectedbody32 = this.Infectedbody31.getChild("Infectedbody32");
		this.Infectedbody33 = this.Infectedbody32.getChild("Infectedbody33");
		this.Infectedbody34 = this.Infectedbody31.getChild("Infectedbody34");
		this.Infectedbody35 = this.Lowerjaw.getChild("Infectedbody35");
		this.Infectedbody36 = this.Infectedbody35.getChild("Infectedbody36");
		this.Infectedbody37 = this.Infectedbody36.getChild("Infectedbody37");
		this.Infectedbody38 = this.Infectedbody37.getChild("Infectedbody38");
		this.Tumor2 = this.Infectedbody37.getChild("Tumor2");
		this.Infectedbody39 = this.Lowerjaw.getChild("Infectedbody39");
		this.Infectedbody40 = this.Infectedbody39.getChild("Infectedbody40");
		this.Infectedbody41 = this.Infectedbody40.getChild("Infectedbody41");
		this.Infectedbody98 = this.Infectedbody41.getChild("Infectedbody98");
		this.Evilshoulder = this.Upperbody.getChild("Evilshoulder");
		this.Leftarmmain = this.Evilshoulder.getChild("Leftarmmain");
		this.bloom2 = this.Leftarmmain.getChild("bloom2");
		this.Leftarm = this.Leftarmmain.getChild("Leftarm");
		this.Root3 = this.Leftarm.getChild("Root3");
		this.R3Seg1 = this.Root3.getChild("R3Seg1");
		this.R3Seg2 = this.R3Seg1.getChild("R3Seg2");
		this.R3Seg3 = this.R3Seg2.getChild("R3Seg3");
		this.RootSeg = this.R3Seg3.getChild("RootSeg");
		this.Root4 = this.Leftarm.getChild("Root4");
		this.R3Seg13 = this.Root4.getChild("R3Seg13");
		this.R3Seg14 = this.R3Seg13.getChild("R3Seg14");
		this.R3Seg15 = this.R3Seg14.getChild("R3Seg15");
		this.RootSeg2 = this.R3Seg15.getChild("RootSeg2");
		this.Root5 = this.Leftarm.getChild("Root5");
		this.R3Seg16 = this.Root5.getChild("R3Seg16");
		this.R3Seg17 = this.R3Seg16.getChild("R3Seg17");
		this.R3Seg18 = this.R3Seg17.getChild("R3Seg18");
		this.RootSeg3 = this.R3Seg18.getChild("RootSeg3");
		this.Lowersegleftarm = this.Leftarm.getChild("Lowersegleftarm");
		this.Infectedarm37 = this.Lowersegleftarm.getChild("Infectedarm37");
		this.Infectedarm38 = this.Infectedarm37.getChild("Infectedarm38");
		this.Infectedarm39 = this.Infectedarm38.getChild("Infectedarm39");
		this.Infectedarm40 = this.Infectedarm38.getChild("Infectedarm40");
		this.bloom3 = this.Lowersegleftarm.getChild("bloom3");
		this.Infectedarm33 = this.Lowersegleftarm.getChild("Infectedarm33");
		this.Infectedarm34 = this.Infectedarm33.getChild("Infectedarm34");
		this.Infectedarm36 = this.Infectedarm34.getChild("Infectedarm36");
		this.Infectedarm35 = this.Infectedarm34.getChild("Infectedarm35");
		this.bloom4 = this.Lowersegleftarm.getChild("bloom4");
		this.Infectedarm41 = this.Lowersegleftarm.getChild("Infectedarm41");
		this.Infectedarm42 = this.Infectedarm41.getChild("Infectedarm42");
		this.Infectedarm43 = this.Infectedarm42.getChild("Infectedarm43");
		this.Infectedarm44 = this.Infectedarm42.getChild("Infectedarm44");
		this.BladeArmTumor = this.Lowersegleftarm.getChild("BladeArmTumor");
		this.Evilhand = this.Lowersegleftarm.getChild("Evilhand");
		this.Bigahhblade = this.Evilhand.getChild("Bigahhblade");
		this.Spitter = this.Bigahhblade.getChild("Spitter");
		this.Spitterneck = this.Spitter.getChild("Spitterneck");
		this.Infectedbody87 = this.Spitterneck.getChild("Infectedbody87");
		this.Infectedbody88 = this.Infectedbody87.getChild("Infectedbody88");
		this.Infectedbody89 = this.Infectedbody88.getChild("Infectedbody89");
		this.Infectedbody90 = this.Infectedbody87.getChild("Infectedbody90");
		this.Infectedbody91 = this.Infectedbody90.getChild("Infectedbody91");
		this.Spitterhead = this.Spitterneck.getChild("Spitterhead");
		this.Spitterjawright = this.Spitterhead.getChild("Spitterjawright");
		this.Lowerspitterjawrigth = this.Spitterjawright.getChild("Lowerspitterjawrigth");
		this.Spitterjawleft = this.Spitterhead.getChild("Spitterjawleft");
		this.Lowerspitterjawleft = this.Spitterjawleft.getChild("Lowerspitterjawleft");
		this.Spitterarmleft = this.Spitter.getChild("Spitterarmleft");
		this.Spitterarmright = this.Spitter.getChild("Spitterarmright");
		this.Spitter2 = this.Bigahhblade.getChild("Spitter2");
		this.Spitterneck2 = this.Spitter2.getChild("Spitterneck2");
		this.Infectedbody67 = this.Spitterneck2.getChild("Infectedbody67");
		this.Infectedbody69 = this.Infectedbody67.getChild("Infectedbody69");
		this.Infectedbody101 = this.Infectedbody69.getChild("Infectedbody101");
		this.Infectedbody102 = this.Infectedbody67.getChild("Infectedbody102");
		this.Infectedbody103 = this.Infectedbody102.getChild("Infectedbody103");
		this.Spitterhead2 = this.Spitterneck2.getChild("Spitterhead2");
		this.Spitterjawright2 = this.Spitterhead2.getChild("Spitterjawright2");
		this.Lowerspitterjawrigth2 = this.Spitterjawright2.getChild("Lowerspitterjawrigth2");
		this.Spitterjawleft2 = this.Spitterhead2.getChild("Spitterjawleft2");
		this.Lowerspitterjawleft2 = this.Spitterjawleft2.getChild("Lowerspitterjawleft2");
		this.Spitterarmleft2 = this.Spitter2.getChild("Spitterarmleft2");
		this.Spitterarmright2 = this.Spitter2.getChild("Spitterarmright2");
		this.Infectedbody109 = this.Evilshoulder.getChild("Infectedbody109");
		this.UpperRightarm = this.Upperbody.getChild("UpperRightarm");
		this.bloom5 = this.UpperRightarm.getChild("bloom5");
		this.Infectedarm49 = this.UpperRightarm.getChild("Infectedarm49");
		this.Infectedarm50 = this.Infectedarm49.getChild("Infectedarm50");
		this.Infectedarm31 = this.UpperRightarm.getChild("Infectedarm31");
		this.Infectedarm32 = this.Infectedarm31.getChild("Infectedarm32");
		this.Infectedarm47 = this.UpperRightarm.getChild("Infectedarm47");
		this.Infectedarm48 = this.Infectedarm47.getChild("Infectedarm48");
		this.Infectedarm45 = this.UpperRightarm.getChild("Infectedarm45");
		this.Infectedarm46 = this.Infectedarm45.getChild("Infectedarm46");
		this.Infectedarm77 = this.UpperRightarm.getChild("Infectedarm77");
		this.Infectedarm78 = this.Infectedarm77.getChild("Infectedarm78");
		this.LowersegRightarm = this.UpperRightarm.getChild("LowersegRightarm");
		this.Infectedarm87 = this.LowersegRightarm.getChild("Infectedarm87");
		this.Infectedarm88 = this.Infectedarm87.getChild("Infectedarm88");
		this.Infectedarm89 = this.Infectedarm88.getChild("Infectedarm89");
		this.Infectedarm90 = this.Infectedarm88.getChild("Infectedarm90");
		this.Infectedarm83 = this.LowersegRightarm.getChild("Infectedarm83");
		this.Infectedarm84 = this.Infectedarm83.getChild("Infectedarm84");
		this.Infectedarm85 = this.Infectedarm84.getChild("Infectedarm85");
		this.Infectedarm86 = this.Infectedarm84.getChild("Infectedarm86");
		this.Infectedbody66 = this.LowersegRightarm.getChild("Infectedbody66");
		this.Infectedarm79 = this.Infectedbody66.getChild("Infectedarm79");
		this.Infectedarm80 = this.Infectedarm79.getChild("Infectedarm80");
		this.Infectedarm81 = this.Infectedarm80.getChild("Infectedarm81");
		this.Infectedarm82 = this.Infectedarm80.getChild("Infectedarm82");
		this.Infectedbody68 = this.Infectedbody66.getChild("Infectedbody68");
		this.Infectedbody70 = this.Infectedbody68.getChild("Infectedbody70");
		this.Infectedarm27 = this.LowersegRightarm.getChild("Infectedarm27");
		this.Infectedarm28 = this.Infectedarm27.getChild("Infectedarm28");
		this.Infectedarm25 = this.LowersegRightarm.getChild("Infectedarm25");
		this.Infectedarm26 = this.Infectedarm25.getChild("Infectedarm26");
		this.Infectedarm23 = this.LowersegRightarm.getChild("Infectedarm23");
		this.Infectedarm24 = this.Infectedarm23.getChild("Infectedarm24");
		this.Infectedbody65 = this.LowersegRightarm.getChild("Infectedbody65");
		this.hand = this.LowersegRightarm.getChild("hand");
		this.Infectedarm53 = this.hand.getChild("Infectedarm53");
		this.Infectedarm54 = this.Infectedarm53.getChild("Infectedarm54");
		this.Infectedarm51 = this.hand.getChild("Infectedarm51");
		this.Infectedarm52 = this.Infectedarm51.getChild("Infectedarm52");
		this.UpperRightfinger = this.hand.getChild("UpperRightfinger");
		this.Infectedarm71 = this.UpperRightfinger.getChild("Infectedarm71");
		this.Infectedarm72 = this.Infectedarm71.getChild("Infectedarm72");
		this.Infectedarm73 = this.Infectedarm72.getChild("Infectedarm73");
		this.Infectedarm74 = this.Infectedarm72.getChild("Infectedarm74");
		this.Infectedarm69 = this.UpperRightfinger.getChild("Infectedarm69");
		this.Infectedarm70 = this.Infectedarm69.getChild("Infectedarm70");
		this.Infectedarm75 = this.UpperRightfinger.getChild("Infectedarm75");
		this.Infectedarm76 = this.Infectedarm75.getChild("Infectedarm76");
		this.UpperRightfinger2 = this.hand.getChild("UpperRightfinger2");
		this.Infectedarm67 = this.UpperRightfinger2.getChild("Infectedarm67");
		this.Infectedarm68 = this.Infectedarm67.getChild("Infectedarm68");
		this.Infectedarm59 = this.UpperRightfinger2.getChild("Infectedarm59");
		this.Infectedarm60 = this.Infectedarm59.getChild("Infectedarm60");
		this.Infectedarm61 = this.Infectedarm60.getChild("Infectedarm61");
		this.Infectedarm62 = this.Infectedarm60.getChild("Infectedarm62");
		this.UpperRightfinger1 = this.hand.getChild("UpperRightfinger1");
		this.Infectedarm63 = this.UpperRightfinger1.getChild("Infectedarm63");
		this.Infectedarm64 = this.Infectedarm63.getChild("Infectedarm64");
		this.Infectedarm65 = this.Infectedarm64.getChild("Infectedarm65");
		this.Infectedarm66 = this.Infectedarm64.getChild("Infectedarm66");
		this.Infectedarm55 = this.UpperRightfinger1.getChild("Infectedarm55");
		this.Infectedarm56 = this.Infectedarm55.getChild("Infectedarm56");
		this.Infectedarm57 = this.Infectedarm56.getChild("Infectedarm57");
		this.Infectedarm58 = this.Infectedarm56.getChild("Infectedarm58");
		this.LowerRightarm = this.Upperbody.getChild("LowerRightarm");
		this.LowerRightarmLowerSegmentButFreakyToo = this.LowerRightarm.getChild("LowerRightarmLowerSegmentButFreakyToo");
		this.Infectedarm197 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedarm197");
		this.Infectedarm198 = this.Infectedarm197.getChild("Infectedarm198");
		this.Infectedarm199 = this.Infectedarm198.getChild("Infectedarm199");
		this.Infectedarm200 = this.Infectedarm198.getChild("Infectedarm200");
		this.Infectedarm201 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedarm201");
		this.Infectedarm202 = this.Infectedarm201.getChild("Infectedarm202");
		this.Infectedarm203 = this.Infectedarm202.getChild("Infectedarm203");
		this.Infectedarm204 = this.Infectedarm202.getChild("Infectedarm204");
		this.Infectedbody114 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedbody114");
		this.Infectedarm205 = this.Infectedbody114.getChild("Infectedarm205");
		this.Infectedarm206 = this.Infectedarm205.getChild("Infectedarm206");
		this.Infectedarm207 = this.Infectedarm206.getChild("Infectedarm207");
		this.Infectedarm208 = this.Infectedarm206.getChild("Infectedarm208");
		this.Infectedarm209 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedarm209");
		this.Infectedarm210 = this.Infectedarm209.getChild("Infectedarm210");
		this.Infectedarm211 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedarm211");
		this.Infectedarm212 = this.Infectedarm211.getChild("Infectedarm212");
		this.Infectedarm213 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("Infectedarm213");
		this.Infectedarm214 = this.Infectedarm213.getChild("Infectedarm214");
		this.hand2 = this.LowerRightarmLowerSegmentButFreakyToo.getChild("hand2");
		this.Infectedarm215 = this.hand2.getChild("Infectedarm215");
		this.Infectedarm216 = this.Infectedarm215.getChild("Infectedarm216");
		this.Infectedarm217 = this.hand2.getChild("Infectedarm217");
		this.Infectedarm218 = this.Infectedarm217.getChild("Infectedarm218");
		this.LowerRightfinger3 = this.hand2.getChild("LowerRightfinger3");
		this.Infectedarm219 = this.LowerRightfinger3.getChild("Infectedarm219");
		this.Infectedarm220 = this.Infectedarm219.getChild("Infectedarm220");
		this.Infectedarm221 = this.Infectedarm220.getChild("Infectedarm221");
		this.Infectedarm222 = this.Infectedarm220.getChild("Infectedarm222");
		this.Infectedarm223 = this.LowerRightfinger3.getChild("Infectedarm223");
		this.Infectedarm224 = this.Infectedarm223.getChild("Infectedarm224");
		this.Infectedarm225 = this.LowerRightfinger3.getChild("Infectedarm225");
		this.Infectedarm226 = this.Infectedarm225.getChild("Infectedarm226");
		this.LowerRightfinger2 = this.hand2.getChild("LowerRightfinger2");
		this.Infectedarm230 = this.LowerRightfinger2.getChild("Infectedarm230");
		this.Infectedarm93 = this.Infectedarm230.getChild("Infectedarm93");
		this.Infectedarm94 = this.Infectedarm230.getChild("Infectedarm94");
		this.Infectedarm92 = this.Infectedarm230.getChild("Infectedarm92");
		this.Infectedarm231 = this.Infectedarm230.getChild("Infectedarm231");
		this.Infectedarm232 = this.Infectedarm230.getChild("Infectedarm232");
		this.LowerRightfinger = this.hand2.getChild("LowerRightfinger");
		this.Infectedarm233 = this.LowerRightfinger.getChild("Infectedarm233");
		this.Infectedarm234 = this.Infectedarm233.getChild("Infectedarm234");
		this.Infectedarm235 = this.Infectedarm234.getChild("Infectedarm235");
		this.Infectedarm236 = this.Infectedarm234.getChild("Infectedarm236");
		this.Infectedarm237 = this.LowerRightfinger.getChild("Infectedarm237");
		this.Infectedarm238 = this.Infectedarm237.getChild("Infectedarm238");
		this.Infectedarm239 = this.Infectedarm238.getChild("Infectedarm239");
		this.Infectedarm240 = this.Infectedarm238.getChild("Infectedarm240");
		this.bodies = this.Upperbody.getChild("bodies");
		this.Infectedbody56 = this.bodies.getChild("Infectedbody56");
		this.Infectedbody57 = this.bodies.getChild("Infectedbody57");
		this.bone20 = this.Infectedbody57.getChild("bone20");
		this.Infectedbody55 = this.bodies.getChild("Infectedbody55");
		this.Infectedbody58 = this.bodies.getChild("Infectedbody58");
		this.Infectedbody59 = this.Infectedbody58.getChild("Infectedbody59");
		this.Infectedbody60 = this.Infectedbody59.getChild("Infectedbody60");
		this.Infectedbody100 = this.bodies.getChild("Infectedbody100");
		this.Infectedbody62 = this.bodies.getChild("Infectedbody62");
		this.Infectedbody63 = this.bodies.getChild("Infectedbody63");
		this.details = this.Upperbody.getChild("details");
		this.Root2 = this.details.getChild("Root2");
		this.R3Seg10 = this.Root2.getChild("R3Seg10");
		this.R3Seg11 = this.R3Seg10.getChild("R3Seg11");
		this.R3Seg12 = this.R3Seg11.getChild("R3Seg12");
		this.spike2 = this.details.getChild("spike2");
		this.spike = this.details.getChild("spike");
		this.bone57 = this.spike.getChild("bone57");
		this.bone58 = this.bone57.getChild("bone58");
		this.R3Seg7 = this.details.getChild("R3Seg7");
		this.R3Seg8 = this.R3Seg7.getChild("R3Seg8");
		this.R3Seg9 = this.R3Seg8.getChild("R3Seg9");
		this.shroom = this.details.getChild("shroom");
		this.Tumor = this.shroom.getChild("Tumor");
		this.shroom3 = this.details.getChild("shroom3");
		this.bone29 = this.shroom3.getChild("bone29");
		this.bone30 = this.bone29.getChild("bone30");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition panzer = partdefinition.addOrReplaceChild("panzer", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition Leftleg = panzer.addOrReplaceChild("Leftleg", CubeListBuilder.create().texOffs(150, 296).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 16.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(326, 53).addBox(-5.0F, 14.0F, -4.0F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(11.0F, -55.0F, 0.0F, 0.0F, 0.0F, -0.1745F));

		PartDefinition leftLegTumor = Leftleg.addOrReplaceChild("leftLegTumor", CubeListBuilder.create(), PartPose.offset(4.0F, -5.0F, 0.0F));

		PartDefinition Infectedbody_r1 = leftLegTumor.addOrReplaceChild("Infectedbody_r1", CubeListBuilder.create().texOffs(188, 246).addBox(-5.0F, -8.0F, -6.0F, 5.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 0.0F, -0.4529F, -0.1373F, -0.1278F));

		PartDefinition Infectedbody_r2 = leftLegTumor.addOrReplaceChild("Infectedbody_r2", CubeListBuilder.create().texOffs(364, 308).addBox(-4.0F, -5.0F, -4.0F, 4.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 3.0F, 0.0F, 1.0379F, 0.4347F, -0.1613F));

		PartDefinition Infectedbody_r3 = leftLegTumor.addOrReplaceChild("Infectedbody_r3", CubeListBuilder.create().texOffs(228, 330).addBox(-4.0F, -8.0F, -6.0F, 7.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 0.0F, 0.2943F, 0.4394F, -0.4983F));

		PartDefinition Infectedbody99 = Leftleg.addOrReplaceChild("Infectedbody99", CubeListBuilder.create(), PartPose.offsetAndRotation(4.0F, 20.0F, -6.0F, 0.0F, -1.1781F, 0.0F));

		PartDefinition Infectedbody_r4 = Infectedbody99.addOrReplaceChild("Infectedbody_r4", CubeListBuilder.create().texOffs(368, 400).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 0.0F, 1.9403F, 0.3272F, 0.1238F));

		PartDefinition Infectedbody_r5 = Infectedbody99.addOrReplaceChild("Infectedbody_r5", CubeListBuilder.create().texOffs(410, 245).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 1.1705F, 0.1284F, -0.1186F));

		PartDefinition Infectedbody_r6 = Infectedbody99.addOrReplaceChild("Infectedbody_r6", CubeListBuilder.create().texOffs(346, 108).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, 0.9163F, 0.0F, 0.3054F));

		PartDefinition Infectedbody_r7 = Infectedbody99.addOrReplaceChild("Infectedbody_r7", CubeListBuilder.create().texOffs(376, 188).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.1309F, 0.0F, -0.0873F));

		PartDefinition Infectedbody_r8 = Infectedbody99.addOrReplaceChild("Infectedbody_r8", CubeListBuilder.create().texOffs(388, 247).addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0412F, -0.0393F, 0.1249F));

		PartDefinition Infectedbody53 = Leftleg.addOrReplaceChild("Infectedbody53", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 6.0F, 0.0F, 2.9234F, -1.4399F, 3.1416F));

		PartDefinition Infectedbody_r9 = Infectedbody53.addOrReplaceChild("Infectedbody_r9", CubeListBuilder.create().texOffs(392, 345).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, 0.7153F, 0.1996F, 0.1706F));

		PartDefinition Infectedbody_r10 = Infectedbody53.addOrReplaceChild("Infectedbody_r10", CubeListBuilder.create().texOffs(112, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, 1.3822F, 0.3864F, -0.0718F));

		PartDefinition Infectedbody_r11 = Infectedbody53.addOrReplaceChild("Infectedbody_r11", CubeListBuilder.create().texOffs(308, 409).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.829F, 0.0F, -0.6545F));

		PartDefinition Infectedbody_r12 = Infectedbody53.addOrReplaceChild("Infectedbody_r12", CubeListBuilder.create().texOffs(94, 340).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -1.1075F, 0.1367F, 0.2128F));

		PartDefinition Infectedbody_r13 = Infectedbody53.addOrReplaceChild("Infectedbody_r13", CubeListBuilder.create().texOffs(0, 372).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.1745F, 0.0F, 0.1745F));

		PartDefinition Infectedbody_r14 = Infectedbody53.addOrReplaceChild("Infectedbody_r14", CubeListBuilder.create().texOffs(144, 379).addBox(-3.5F, -7.0F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, -0.2618F));

		PartDefinition bloom = Leftleg.addOrReplaceChild("bloom", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.0F, 19.0F, -5.0F, 1.3509F, 0.3034F, -0.1957F));

		PartDefinition cube_r1 = bloom.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(362, 58).addBox(-4.2F, -4.2F, -3.2F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.8F, -2.2F, 0.6F, 0.026F, -0.349F, 0.3987F));

		PartDefinition cube_r2 = bloom.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(362, 58).addBox(-4.2F, -4.2F, -3.2F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, -0.2F, -1.4F, 0.2835F, 0.1153F, -0.3762F));

		PartDefinition cube_r3 = bloom.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r4 = bloom.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition Infectedbody54 = Leftleg.addOrReplaceChild("Infectedbody54", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 30.0F, 9.0F, 0.5236F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r15 = Infectedbody54.addOrReplaceChild("Infectedbody_r15", CubeListBuilder.create().texOffs(196, 393).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.9079F, -0.0829F, -0.202F));

		PartDefinition Infectedbody_r16 = Infectedbody54.addOrReplaceChild("Infectedbody_r16", CubeListBuilder.create().texOffs(128, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, -0.3054F, 0.0F, 0.2182F));

		PartDefinition Infectedbody_r17 = Infectedbody54.addOrReplaceChild("Infectedbody_r17", CubeListBuilder.create().texOffs(126, 340).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -13.0F, 0.0F, -1.1358F, -0.3686F, 0.0605F));

		PartDefinition Infectedbody_r18 = Infectedbody54.addOrReplaceChild("Infectedbody_r18", CubeListBuilder.create().texOffs(372, 145).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Infectedbody_r19 = Infectedbody54.addOrReplaceChild("Infectedbody_r19", CubeListBuilder.create().texOffs(384, 199).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, -0.3054F));

		PartDefinition LeftForLeg = Leftleg.addOrReplaceChild("LeftForLeg", CubeListBuilder.create().texOffs(326, 34).addBox(-4.0F, 7.0F, -4.0F, 9.0F, 10.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(28, 319).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition Infectedbody51 = LeftForLeg.addOrReplaceChild("Infectedbody51", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0F, 15.0F, -1.0F, 0.5622F, -0.2895F, 0.3311F));

		PartDefinition Infectedbody_r20 = Infectedbody51.addOrReplaceChild("Infectedbody_r20", CubeListBuilder.create().texOffs(340, 411).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, 0.5672F, 0.0F, 0.3491F));

		PartDefinition Infectedbody_r21 = Infectedbody51.addOrReplaceChild("Infectedbody_r21", CubeListBuilder.create().texOffs(96, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, 0.5865F, -0.3093F, 0.4295F));

		PartDefinition Infectedbody_r22 = Infectedbody51.addOrReplaceChild("Infectedbody_r22", CubeListBuilder.create().texOffs(80, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.9224F, -0.2129F, -0.1945F));

		PartDefinition Infectedbody_r23 = Infectedbody51.addOrReplaceChild("Infectedbody_r23", CubeListBuilder.create().texOffs(64, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.6981F));

		PartDefinition Infectedbody_r24 = Infectedbody51.addOrReplaceChild("Infectedbody_r24", CubeListBuilder.create().texOffs(326, 338).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 1.0F, -0.8131F, -0.3615F, -0.9338F));

		PartDefinition Infectedbody_r25 = Infectedbody51.addOrReplaceChild("Infectedbody_r25", CubeListBuilder.create().texOffs(370, 166).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, -0.2986F, -0.0651F, -0.2084F));

		PartDefinition Infectedbody_r26 = Infectedbody51.addOrReplaceChild("Infectedbody_r26", CubeListBuilder.create().texOffs(378, 373).addBox(-3.5F, -7.0F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2559F, -0.056F, 0.211F));

		PartDefinition LowerLeftleg2 = LeftForLeg.addOrReplaceChild("LowerLeftleg2", CubeListBuilder.create().texOffs(88, 309).addBox(-4.0F, -2.1922F, -5.388F, 8.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 16.1922F, 0.388F, -0.5241F, -0.0596F, -0.016F));

		PartDefinition cube_r5 = LowerLeftleg2.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(166, 379).addBox(-3.0F, -2.0F, -5.0F, 3.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 10.8078F, -6.388F, -0.0812F, -0.4122F, -0.1145F));

		PartDefinition cube_r6 = LowerLeftleg2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(338, 380).addBox(-4.0F, -2.0F, -5.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 7.8078F, -0.388F, -0.9975F, -0.4122F, -0.1145F));

		PartDefinition cube_r7 = LowerLeftleg2.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(204, 375).addBox(-4.0F, -4.0F, -4.0F, 4.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 10.8078F, 5.612F, 0.3887F, 0.3734F, 0.0219F));

		PartDefinition cube_r8 = LowerLeftleg2.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(146, 180).addBox(-4.0F, -2.0F, -4.0F, 4.0F, 17.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 4.8078F, 6.612F, 0.48F, 0.0F, 0.3491F));

		PartDefinition cube_r9 = LowerLeftleg2.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(360, 362).addBox(-4.0F, -2.0F, -5.0F, 4.0F, 17.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.8078F, -0.388F, -0.5236F, 0.0F, 0.3491F));

		PartDefinition Infectedarm21 = LowerLeftleg2.addOrReplaceChild("Infectedarm21", CubeListBuilder.create().texOffs(64, 410).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 9.8078F, -4.388F, -0.6558F, -0.2743F, 1.5456F));

		PartDefinition Infectedarm22 = Infectedarm21.addOrReplaceChild("Infectedarm22", CubeListBuilder.create().texOffs(80, 410).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.0774F, -0.0403F, -0.4784F));

		PartDefinition Infectedarm15 = LowerLeftleg2.addOrReplaceChild("Infectedarm15", CubeListBuilder.create().texOffs(0, 407).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 12.8078F, -6.388F, -0.8825F, -0.7534F, -0.1754F));

		PartDefinition Infectedarm16 = Infectedarm15.addOrReplaceChild("Infectedarm16", CubeListBuilder.create().texOffs(188, 409).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody52 = LowerLeftleg2.addOrReplaceChild("Infectedbody52", CubeListBuilder.create().texOffs(380, 83).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 6.8078F, -0.388F, -0.7999F, -1.4329F, -2.8188F));

		PartDefinition Infectedbody_r27 = Infectedbody52.addOrReplaceChild("Infectedbody_r27", CubeListBuilder.create().texOffs(280, 391).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, 2.9222F, -0.2143F, -0.7617F));

		PartDefinition Infectedbody_r28 = Infectedbody52.addOrReplaceChild("Infectedbody_r28", CubeListBuilder.create().texOffs(406, 345).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -0.0231F, -0.1758F, 0.7245F));

		PartDefinition Infectedbody_r29 = Infectedbody52.addOrReplaceChild("Infectedbody_r29", CubeListBuilder.create().texOffs(64, 319).addBox(-3.0F, -6.0F, -3.0F, 6.0F, 10.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -14.0F, 2.0F, -0.6109F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r30 = Infectedbody52.addOrReplaceChild("Infectedbody_r30", CubeListBuilder.create().texOffs(370, 264).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Rightleg = panzer.addOrReplaceChild("Rightleg", CubeListBuilder.create().texOffs(284, 294).addBox(-5.0F, 4.0F, -5.0F, 10.0F, 19.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

		PartDefinition cube_r10 = Rightleg.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(296, 146).addBox(-5.0F, -2.0F, -7.0F, 10.0F, 9.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0873F, 0.0F, 0.2182F));

		PartDefinition Infectedbody50 = Rightleg.addOrReplaceChild("Infectedbody50", CubeListBuilder.create(), PartPose.offset(-1.0F, 15.0F, 6.0F));

		PartDefinition Infectedbody_r31 = Infectedbody50.addOrReplaceChild("Infectedbody_r31", CubeListBuilder.create().texOffs(266, 406).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -11.0F, 0.0F, -1.0982F, -0.1949F, -0.0026F));

		PartDefinition Infectedbody_r32 = Infectedbody50.addOrReplaceChild("Infectedbody_r32", CubeListBuilder.create().texOffs(144, 406).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -8.0F, 0.0F, 0.1309F, 0.0F, -0.5236F));

		PartDefinition Infectedbody_r33 = Infectedbody50.addOrReplaceChild("Infectedbody_r33", CubeListBuilder.create().texOffs(48, 381).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.324F, -0.007F, -0.261F));

		PartDefinition Infectedbody_r34 = Infectedbody50.addOrReplaceChild("Infectedbody_r34", CubeListBuilder.create().texOffs(378, 114).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.3381F, 0.0886F, -0.2467F));

		PartDefinition Infectedbody_r35 = Infectedbody50.addOrReplaceChild("Infectedbody_r35", CubeListBuilder.create().texOffs(390, 208).addBox(-3.5F, -4.0F, -2.0F, 7.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5033F, 0.1509F, 0.2666F));

		PartDefinition Infectedarm5 = Rightleg.addOrReplaceChild("Infectedarm5", CubeListBuilder.create().texOffs(402, 156).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 13.0F, -6.0F, -0.9098F, 0.3032F, 0.2774F));

		PartDefinition Infectedarm6 = Infectedarm5.addOrReplaceChild("Infectedarm6", CubeListBuilder.create().texOffs(396, 273).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm3 = Rightleg.addOrReplaceChild("Infectedarm3", CubeListBuilder.create().texOffs(402, 100).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 7.0F, -6.0F, -0.9493F, 0.1666F, -0.4245F));

		PartDefinition Infectedarm4 = Infectedarm3.addOrReplaceChild("Infectedarm4", CubeListBuilder.create().texOffs(402, 110).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedarm = Rightleg.addOrReplaceChild("Infectedarm", CubeListBuilder.create().texOffs(402, 81).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 7.0F, 0.0F, 0.2182F, 0.0F, 0.4363F));

		PartDefinition Infectedarm2 = Infectedarm.addOrReplaceChild("Infectedarm2", CubeListBuilder.create().texOffs(264, 309).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition rightLegTumor = Rightleg.addOrReplaceChild("rightLegTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 10.0F, 6.0F));

		PartDefinition cube_r11 = rightLegTumor.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(364, 0).addBox(1.0F, 7.0F, 3.0F, 7.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -4.0F, -0.1139F, 0.325F, 0.0041F));

		PartDefinition cube_r12 = rightLegTumor.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(360, 292).addBox(-4.0F, 7.0F, 3.0F, 10.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -10.0F, -6.0F, 0.1309F, 0.1745F, -0.1309F));

		PartDefinition Infectedbody42 = Rightleg.addOrReplaceChild("Infectedbody42", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 15.0F, -6.0F, 0.0F, 1.1781F, 0.0F));

		PartDefinition Infectedbody_r36 = Infectedbody42.addOrReplaceChild("Infectedbody_r36", CubeListBuilder.create().texOffs(400, 35).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, 0.9163F, 0.0F, 1.0472F));

		PartDefinition Infectedbody_r37 = Infectedbody42.addOrReplaceChild("Infectedbody_r37", CubeListBuilder.create().texOffs(400, 67).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -11.0F, 0.0F, 1.9248F, -0.1639F, -0.0602F));

		PartDefinition Infectedbody_r38 = Infectedbody42.addOrReplaceChild("Infectedbody_r38", CubeListBuilder.create().texOffs(322, 380).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.8214F, -0.1284F, 0.1186F));

		PartDefinition Infectedbody_r39 = Infectedbody42.addOrReplaceChild("Infectedbody_r39", CubeListBuilder.create().texOffs(262, 338).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -0.7418F, 0.0F, -0.3054F));

		PartDefinition Infectedbody_r40 = Infectedbody42.addOrReplaceChild("Infectedbody_r40", CubeListBuilder.create().texOffs(96, 370).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.1309F, 0.0F, 0.0873F));

		PartDefinition Infectedbody_r41 = Infectedbody42.addOrReplaceChild("Infectedbody_r41", CubeListBuilder.create().texOffs(262, 378).addBox(-3.5F, -7.0F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.303F, 0.0393F, -0.1249F));

		PartDefinition RightForLeg = Rightleg.addOrReplaceChild("RightForLeg", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 23.0F, 0.0F, 0.48F, 0.0F, 0.0F));

		PartDefinition cube_r13 = RightForLeg.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(224, 309).addBox(-5.0F, -2.0F, -5.0F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1309F, 0.0F, 0.1745F));

		PartDefinition cube_r14 = RightForLeg.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(324, 294).addBox(-5.0F, -9.0F, -4.0F, 10.0F, 11.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 15.0F, 0.0F, -0.1076F, -0.0227F, -0.1271F));

		PartDefinition Infectedbody48 = RightForLeg.addOrReplaceChild("Infectedbody48", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 12.0F, 1.0F, 1.4765F, 1.089F, -1.4362F));

		PartDefinition Infectedbody_r42 = Infectedbody48.addOrReplaceChild("Infectedbody_r42", CubeListBuilder.create().texOffs(144, 390).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -11.0F, 0.0F, -0.413F, 0.1451F, 0.3186F));

		PartDefinition Infectedbody_r43 = Infectedbody48.addOrReplaceChild("Infectedbody_r43", CubeListBuilder.create().texOffs(358, 222).addBox(-4.0F, -1.0F, -3.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -1.0F, -0.3416F, 0.7048F, -0.339F));

		PartDefinition Infectedbody_r44 = Infectedbody48.addOrReplaceChild("Infectedbody_r44", CubeListBuilder.create().texOffs(158, 352).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, -1.0F, 0.8812F, 0.3278F, -0.4491F));

		PartDefinition Infectedbody_r45 = Infectedbody48.addOrReplaceChild("Infectedbody_r45", CubeListBuilder.create().texOffs(120, 370).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.0F, -0.2182F, 0.1745F));

		PartDefinition Infectedbody_r46 = Infectedbody48.addOrReplaceChild("Infectedbody_r46", CubeListBuilder.create().texOffs(378, 362).addBox(-3.5F, -7.0F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1289F, 0.0227F, -0.1731F));

		PartDefinition bloom6 = RightForLeg.addOrReplaceChild("bloom6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 9.0F, 5.0F, -1.3856F, 0.0055F, -2.3148F));

		PartDefinition cube_r15 = bloom6.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r16 = bloom6.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r17 = bloom6.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(252, 256).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r18 = bloom6.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition cube_r19 = bloom6.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r20 = bloom6.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(226, 206).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.2575F, -3.3839F, -0.0076F, -0.1309F, 0.0F, 0.3927F));

		PartDefinition LowerRightleg2 = RightForLeg.addOrReplaceChild("LowerRightleg2", CubeListBuilder.create().texOffs(190, 296).addBox(-4.0F, -0.1922F, -4.388F, 9.0F, 22.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 14.1922F, 0.388F, -0.48F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r47 = LowerRightleg2.addOrReplaceChild("Infectedbody_r47", CubeListBuilder.create().texOffs(400, 175).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 17.8078F, 3.612F, 1.7536F, 0.4567F, 1.4826F));

		PartDefinition Infectedarm95 = LowerRightleg2.addOrReplaceChild("Infectedarm95", CubeListBuilder.create().texOffs(410, 321).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.8078F, -3.388F, -1.3891F, 0.4631F, 0.2067F));

		PartDefinition Infectedarm96 = Infectedarm95.addOrReplaceChild("Infectedarm96", CubeListBuilder.create().texOffs(128, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm11 = LowerRightleg2.addOrReplaceChild("Infectedarm11", CubeListBuilder.create().texOffs(400, 187).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 11.8078F, -4.388F, -2.4748F, 1.0296F, -2.4549F));

		PartDefinition Infectedarm12 = Infectedarm11.addOrReplaceChild("Infectedarm12", CubeListBuilder.create().texOffs(412, 265).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -0.0562F, -0.0668F, -0.8708F));

		PartDefinition Infectedarm9 = LowerRightleg2.addOrReplaceChild("Infectedarm9", CubeListBuilder.create().texOffs(32, 404).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 10.8078F, 1.612F, 0.5688F, -0.1532F, -1.4331F));

		PartDefinition Infectedarm10 = Infectedarm9.addOrReplaceChild("Infectedarm10", CubeListBuilder.create().texOffs(404, 231).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.0774F, 0.0403F, 0.4784F));

		PartDefinition Infectedbody43 = LowerRightleg2.addOrReplaceChild("Infectedbody43", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 6.8078F, -2.388F, 2.6207F, -0.2437F, -0.1625F));

		PartDefinition Infectedbody_r48 = Infectedbody43.addOrReplaceChild("Infectedbody_r48", CubeListBuilder.create().texOffs(402, 383).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, -0.7587F, 0.1457F, 0.4096F));

		PartDefinition Infectedbody_r49 = Infectedbody43.addOrReplaceChild("Infectedbody_r49", CubeListBuilder.create().texOffs(406, 199).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.2618F, 0.0F, -0.1309F));

		PartDefinition Infectedbody_r50 = Infectedbody43.addOrReplaceChild("Infectedbody_r50", CubeListBuilder.create().texOffs(124, 309).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -1.0348F, 0.1622F, 0.1147F));

		PartDefinition Infectedbody_r51 = Infectedbody43.addOrReplaceChild("Infectedbody_r51", CubeListBuilder.create().texOffs(156, 367).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.2164F, -0.0283F, 0.1278F));

		PartDefinition Infectedbody_r52 = Infectedbody43.addOrReplaceChild("Infectedbody_r52", CubeListBuilder.create().texOffs(380, 156).addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4702F, -0.1001F, -0.1942F));

		PartDefinition Infectedbody44 = Infectedbody43.addOrReplaceChild("Infectedbody44", CubeListBuilder.create().texOffs(410, 331).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -10.0F, 0.0F, -0.5672F, 0.0F, -0.3927F));

		PartDefinition Infectedbody45 = Infectedbody44.addOrReplaceChild("Infectedbody45", CubeListBuilder.create().texOffs(24, 372).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, -0.1278F, -0.5085F));

		PartDefinition Infectedbody46 = Infectedbody43.addOrReplaceChild("Infectedbody46", CubeListBuilder.create().texOffs(48, 358).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -7.0F, 2.0F, 0.6066F, -0.5618F, -2.1183F));

		PartDefinition Infectedbody47 = Infectedbody46.addOrReplaceChild("Infectedbody47", CubeListBuilder.create().texOffs(390, 412).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, -0.1278F, -0.5085F));

		PartDefinition Infectedbody96 = Infectedbody43.addOrReplaceChild("Infectedbody96", CubeListBuilder.create().texOffs(48, 358).mirror().addBox(-2.0F, -1.0F, -2.0F, 3.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-8.0F, -7.0F, -1.0F, 1.1493F, 0.4104F, 2.715F));

		PartDefinition Infectedbody97 = Infectedbody96.addOrReplaceChild("Infectedbody97", CubeListBuilder.create().texOffs(390, 412).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 7.0F, 0.0F, -1.3508F, 0.1278F, 0.5085F));

		PartDefinition Hipsguh = panzer.addOrReplaceChild("Hipsguh", CubeListBuilder.create().texOffs(0, 298).addBox(-7.0F, -5.0F, -6.0F, 9.0F, 7.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -56.0F, 0.0F));

		PartDefinition cube_r21 = Hipsguh.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(338, 167).addBox(-9.0F, -7.0F, -3.0F, 7.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r22 = Hipsguh.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(336, 265).addBox(-5.0F, -7.0F, -4.0F, 11.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 2.0F, 0.0F, -0.0607F, -0.116F, 0.4835F));

		PartDefinition cube_r23 = Hipsguh.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 274).addBox(-1.0F, -7.0F, -7.0F, 10.0F, 9.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 2.0F, 0.0F, 0.0285F, -0.1278F, -0.22F));

		PartDefinition Lowerbody = Hipsguh.addOrReplaceChild("Lowerbody", CubeListBuilder.create(), PartPose.offset(1.0F, -4.0F, 0.0F));

		PartDefinition cube_r24 = Lowerbody.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(180, 272).addBox(-5.0F, -4.0F, -5.0F, 14.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -7.0F, 1.0F, -0.2087F, 0.0201F, 0.0415F));

		PartDefinition cube_r25 = Lowerbody.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(238, 146).addBox(-7.0F, -3.0F, -5.0F, 17.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -14.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition AssTumor = Lowerbody.addOrReplaceChild("AssTumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r26 = AssTumor.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(264, 16).addBox(-5.8F, -7.2F, -6.2F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.2F, -9.2F, 7.6F, -0.0773F, 0.681F, 0.1885F));

		PartDefinition cube_r27 = AssTumor.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(206, 226).addBox(-6.8F, -8.2F, -7.2F, 15.0F, 15.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.8F, -7.2F, 9.6F, -0.1772F, -0.1719F, 0.0306F));

		PartDefinition Tendril2 = Lowerbody.addOrReplaceChild("Tendril2", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.6297F, -6.4056F, 5.0F, 0.0291F, 0.5092F, 0.0396F));

		PartDefinition RootSeg_r1 = Tendril2.addOrReplaceChild("RootSeg_r1", CubeListBuilder.create().texOffs(336, 280).addBox(-6.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition Seg2Tendril2 = Tendril2.addOrReplaceChild("Seg2Tendril2", CubeListBuilder.create().texOffs(344, 200).addBox(-14.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition Seg3Tendril2 = Seg2Tendril2.addOrReplaceChild("Seg3Tendril2", CubeListBuilder.create().texOffs(226, 222).addBox(-14.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6981F));

		PartDefinition Seg4Tendril2 = Seg3Tendril2.addOrReplaceChild("Seg4Tendril2", CubeListBuilder.create().texOffs(150, 294).addBox(-13.0F, -0.5F, -0.5F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6545F));

		PartDefinition Upperbody = Lowerbody.addOrReplaceChild("Upperbody", CubeListBuilder.create().texOffs(150, 87).addBox(-10.0F, -21.0F, -10.0F, 22.0F, 22.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -16.0F, 0.0F));

		PartDefinition cube_r28 = Upperbody.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(192, 330).addBox(-3.8F, -5.2F, -4.2F, 9.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-20.8F, -0.2F, -0.4F, 0.3521F, 0.4756F, -0.4137F));

		PartDefinition cube_r29 = Upperbody.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(128, 262).mirror().addBox(-5.8F, -7.2F, -6.2F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-22.8F, -5.2F, -3.4F, 0.354F, -0.1639F, -0.0602F));

		PartDefinition cube_r30 = Upperbody.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(76, 180).addBox(-9.0F, -1.0F, -5.0F, 19.0F, 20.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -17.0F, 1.0F, 0.4135F, 0.2978F, -0.6063F));

		PartDefinition cube_r31 = Upperbody.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(0, 130).addBox(-17.0F, -19.0F, -6.0F, 27.0F, 20.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -13.0F, -3.0F, -0.0952F, 0.0372F, -0.228F));

		PartDefinition cube_r32 = Upperbody.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(162, 170).addBox(-1.0F, -8.0F, -4.0F, 19.0F, 17.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(15.0F, -24.0F, 3.0F, -0.0345F, -0.3448F, 1.3808F));

		PartDefinition cube_r33 = Upperbody.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(108, 0).addBox(-10.0F, -19.0F, -7.0F, 26.0F, 27.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.48F));

		PartDefinition Mouth = Upperbody.addOrReplaceChild("Mouth", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, 0.0F, -0.4363F));

		PartDefinition Upperjaw = Mouth.addOrReplaceChild("Upperjaw", CubeListBuilder.create().texOffs(238, 125).addBox(-8.0F, -3.0F, -14.0F, 16.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -12.0F, -7.0F, -0.6545F, 0.0F, 0.0F));

		PartDefinition cube_r34 = Upperjaw.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(306, 323).addBox(-2.0F, -2.0F, -10.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0436F, -0.3491F, 0.5672F));

		PartDefinition cube_r35 = Upperjaw.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(264, 323).addBox(-8.0F, -2.0F, -10.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0436F, 0.3491F, -0.5672F));

		PartDefinition cube_r36 = Upperjaw.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, -6.0F, -0.2589F, 1.0659F, -0.2892F));

		PartDefinition cube_r37 = Upperjaw.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 2.0F, 0.1558F, -0.1175F, -0.3293F));

		PartDefinition cube_r38 = Upperjaw.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(64, 334).mirror().addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 5.0F, 0.0F, -0.1596F, 0.0044F, -0.5516F));

		PartDefinition cube_r39 = Upperjaw.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 5.0F, 0.0F, -0.1596F, -0.0044F, 0.5516F));

		PartDefinition cube_r40 = Upperjaw.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, 0.0F, 0.0692F, 0.2527F, 0.2706F));

		PartDefinition Infectedbody_r53 = Upperjaw.addOrReplaceChild("Infectedbody_r53", CubeListBuilder.create().texOffs(158, 397).addBox(2.0F, 4.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, -14.0F, 1.3167F, 0.0957F, -0.185F));

		PartDefinition Infectedbody14 = Upperjaw.addOrReplaceChild("Infectedbody14", CubeListBuilder.create().texOffs(400, 27).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -2.0F, -7.0F, 2.0304F, 0.5191F, 0.0605F));

		PartDefinition Infectedbody15 = Infectedbody14.addOrReplaceChild("Infectedbody15", CubeListBuilder.create().texOffs(72, 370).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Infectedbody16 = Infectedbody15.addOrReplaceChild("Infectedbody16", CubeListBuilder.create().texOffs(358, 16).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(400, 373).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 23).addBox(-3.75F, -2.5F, -4.5F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

		PartDefinition Infectedbody17 = Infectedbody16.addOrReplaceChild("Infectedbody17", CubeListBuilder.create().texOffs(0, 350).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Infectedbody9 = Upperjaw.addOrReplaceChild("Infectedbody9", CubeListBuilder.create().texOffs(0, 399).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 3.0F, -8.0F, 0.8454F, 1.1645F, -1.5805F));

		PartDefinition Infectedbody10 = Infectedbody9.addOrReplaceChild("Infectedbody10", CubeListBuilder.create().texOffs(334, 369).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody13 = Infectedbody10.addOrReplaceChild("Infectedbody13", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -3.0F, 1.0F, -2.9046F, 0.1945F, -0.6749F));

		PartDefinition Infectedbody11 = Infectedbody10.addOrReplaceChild("Infectedbody11", CubeListBuilder.create().texOffs(124, 356).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(398, 286).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 23).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3995F, -0.1586F, -0.4549F));

		PartDefinition Infectedbody12 = Infectedbody11.addOrReplaceChild("Infectedbody12", CubeListBuilder.create().texOffs(94, 334).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Infectedbody2 = Upperjaw.addOrReplaceChild("Infectedbody2", CubeListBuilder.create().texOffs(398, 92).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(286, 369).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -13.0F, 1.8724F, -0.1685F, 0.0456F));

		PartDefinition Infectedbody_r54 = Infectedbody2.addOrReplaceChild("Infectedbody_r54", CubeListBuilder.create().texOffs(158, 397).addBox(2.0F, 4.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -13.0F, -5.0F, 0.3804F, 0.3907F, -0.2669F));

		PartDefinition Infectedbody_r55 = Infectedbody2.addOrReplaceChild("Infectedbody_r55", CubeListBuilder.create().texOffs(340, 396).addBox(2.0F, 4.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -6.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Infectedbody3 = Infectedbody2.addOrReplaceChild("Infectedbody3", CubeListBuilder.create().texOffs(60, 355).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(450, 23).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(374, 140).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.1745F, 0.0F, 0.6981F));

		PartDefinition Infectedbody4 = Infectedbody3.addOrReplaceChild("Infectedbody4", CubeListBuilder.create().texOffs(150, 288).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3927F, 0.1745F, 0.0F));

		PartDefinition Infectedbody = Infectedbody2.addOrReplaceChild("Infectedbody", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -11.0F, 0.0F, -1.4527F, -0.7383F, -0.0797F));

		PartDefinition Infectedbody5 = Upperjaw.addOrReplaceChild("Infectedbody5", CubeListBuilder.create().texOffs(250, 398).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -13.0F, 2.0417F, 0.2397F, -0.2487F));

		PartDefinition Infectedbody8 = Infectedbody5.addOrReplaceChild("Infectedbody8", CubeListBuilder.create().texOffs(310, 369).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(412, 276).addBox(-3.0F, -7.0F, -5.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Infectedbody_r56 = Infectedbody8.addOrReplaceChild("Infectedbody_r56", CubeListBuilder.create().texOffs(158, 412).addBox(-4.0F, -7.0F, -8.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Infectedbody6 = Infectedbody8.addOrReplaceChild("Infectedbody6", CubeListBuilder.create().texOffs(92, 356).addBox(-4.0F, -6.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(390, 226).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 23).addBox(-3.75F, -0.25F, -4.0F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, -1.0F, -0.6834F, 0.26F, 0.0063F));

		PartDefinition Infectedbody18 = Upperjaw.addOrReplaceChild("Infectedbody18", CubeListBuilder.create().texOffs(394, 166).addBox(-3.5F, -5.0F, -1.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.0F, 2.0F, -6.0F, 1.332F, -0.9276F, -0.0876F));

		PartDefinition Infectedbody19 = Infectedbody18.addOrReplaceChild("Infectedbody19", CubeListBuilder.create().texOffs(262, 366).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, 0.7006F, -0.3897F, 0.7723F));

		PartDefinition Infectedbody20 = Infectedbody19.addOrReplaceChild("Infectedbody20", CubeListBuilder.create().texOffs(356, 245).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(442, 15).addBox(-4.0F, -2.0F, -5.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(400, 378).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3521F, -0.1776F, -0.4483F));

		PartDefinition Infectedbody21 = Infectedbody20.addOrReplaceChild("Infectedbody21", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Infectedbody_r57 = Infectedbody21.addOrReplaceChild("Infectedbody_r57", CubeListBuilder.create().texOffs(372, 286).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Lowerjaw = Mouth.addOrReplaceChild("Lowerjaw", CubeListBuilder.create().texOffs(238, 125).addBox(-8.0F, -3.0F, -14.0F, 16.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 9.0F, -8.0F, -0.5672F, 0.0F, -3.1416F));

		PartDefinition cube_r41 = Lowerjaw.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(306, 323).addBox(-2.0F, -2.0F, -10.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0436F, -0.3491F, 0.5672F));

		PartDefinition cube_r42 = Lowerjaw.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(264, 323).addBox(-8.0F, -2.0F, -10.0F, 10.0F, 4.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0436F, 0.3491F, -0.5672F));

		PartDefinition cube_r43 = Lowerjaw.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 5.0F, -6.0F, -0.2589F, 1.0659F, -0.2892F));

		PartDefinition cube_r44 = Lowerjaw.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 4.0F, 2.0F, 0.1558F, -0.1175F, -0.3293F));

		PartDefinition cube_r45 = Lowerjaw.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(64, 334).mirror().addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(8.0F, 5.0F, 0.0F, -0.1596F, 0.0044F, -0.5516F));

		PartDefinition cube_r46 = Lowerjaw.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 5.0F, 0.0F, -0.1596F, -0.0044F, 0.5516F));

		PartDefinition cube_r47 = Lowerjaw.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(64, 334).addBox(0.0F, -3.0F, -14.0F, 0.0F, 6.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 5.0F, 0.0F, 0.0692F, 0.2527F, 0.2706F));

		PartDefinition Infectedbody26 = Lowerjaw.addOrReplaceChild("Infectedbody26", CubeListBuilder.create().texOffs(0, 399).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, 3.0F, -8.0F, 2.016F, 0.621F, -0.6925F));

		PartDefinition Infectedbody27 = Infectedbody26.addOrReplaceChild("Infectedbody27", CubeListBuilder.create().texOffs(334, 369).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 0.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody28 = Infectedbody27.addOrReplaceChild("Infectedbody28", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, -3.0F, 1.0F, -2.9046F, 0.1945F, -0.6749F));

		PartDefinition Infectedbody29 = Infectedbody27.addOrReplaceChild("Infectedbody29", CubeListBuilder.create().texOffs(124, 356).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(398, 286).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3995F, -0.1586F, -0.4549F));

		PartDefinition Infectedbody_r58 = Infectedbody29.addOrReplaceChild("Infectedbody_r58", CubeListBuilder.create().texOffs(130, 356).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.1F, -4.7F, 0.1931F, 0.0703F, -0.0064F));

		PartDefinition Infectedbody_r59 = Infectedbody29.addOrReplaceChild("Infectedbody_r59", CubeListBuilder.create().texOffs(130, 356).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.3F, -1.2F, -4.7F, 0.2035F, 0.0271F, 0.2077F));

		PartDefinition Infectedbody108 = Infectedbody29.addOrReplaceChild("Infectedbody108", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.4F, -1.6859F, -4.9093F, 0.0018F, -0.0085F, -0.2094F));

		PartDefinition Infectedbody_r60 = Infectedbody108.addOrReplaceChild("Infectedbody_r60", CubeListBuilder.create().texOffs(130, 356).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0358F, 0.4593F, 0.6545F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r61 = Infectedbody108.addOrReplaceChild("Infectedbody_r61", CubeListBuilder.create().texOffs(130, 357).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0859F, 0.1093F, 0.1309F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r62 = Infectedbody108.addOrReplaceChild("Infectedbody_r62", CubeListBuilder.create().texOffs(130, 356).addBox(-0.5F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.7142F, 0.0093F, -0.1309F, 0.0F, 0.0F));

		PartDefinition Infectedbody30 = Infectedbody29.addOrReplaceChild("Infectedbody30", CubeListBuilder.create().texOffs(94, 334).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.829F, 0.0F, 0.0F));

		PartDefinition Infectedbody31 = Lowerjaw.addOrReplaceChild("Infectedbody31", CubeListBuilder.create().texOffs(398, 92).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(286, 369).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -13.0F, 2.0033F, -0.1685F, 0.0456F));

		PartDefinition Infectedbody_r63 = Infectedbody31.addOrReplaceChild("Infectedbody_r63", CubeListBuilder.create().texOffs(236, 398).addBox(2.0F, 4.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -13.0F, -5.0F, 0.3804F, 0.3907F, -0.2669F));

		PartDefinition Infectedbody_r64 = Infectedbody31.addOrReplaceChild("Infectedbody_r64", CubeListBuilder.create().texOffs(398, 123).addBox(2.0F, 4.0F, -4.0F, 0.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -15.0F, -6.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition Infectedbody32 = Infectedbody31.addOrReplaceChild("Infectedbody32", CubeListBuilder.create().texOffs(60, 355).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(374, 140).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(450, 23).addBox(-4.0F, -2.0F, -4.75F, 8.0F, 1.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -11.0F, 0.0F, 0.1745F, 0.0F, 0.6981F));

		PartDefinition Infectedbody33 = Infectedbody32.addOrReplaceChild("Infectedbody33", CubeListBuilder.create().texOffs(150, 288).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(0.0F, -1.0F, 0.0F, 0.3927F, 0.1745F, 0.0F));

		PartDefinition Infectedbody34 = Infectedbody31.addOrReplaceChild("Infectedbody34", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, -11.0F, 0.0F, -1.4527F, -0.7383F, -0.0797F));

		PartDefinition Infectedbody35 = Lowerjaw.addOrReplaceChild("Infectedbody35", CubeListBuilder.create().texOffs(250, 398).addBox(-3.5F, -4.0F, -1.0F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -13.0F, 2.1726F, 0.2397F, 0.1004F));

		PartDefinition Infectedbody36 = Infectedbody35.addOrReplaceChild("Infectedbody36", CubeListBuilder.create().texOffs(310, 369).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(24, 413).addBox(-3.0F, -7.0F, -5.0F, 0.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -4.0F, 0.0F));

		PartDefinition Infectedbody_r65 = Infectedbody36.addOrReplaceChild("Infectedbody_r65", CubeListBuilder.create().texOffs(170, 412).addBox(-4.0F, -7.0F, -8.0F, 0.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Infectedbody37 = Infectedbody36.addOrReplaceChild("Infectedbody37", CubeListBuilder.create().texOffs(92, 356).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(390, 226).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.6834F, 0.26F, 0.0063F));

		PartDefinition Infectedbody38 = Infectedbody37.addOrReplaceChild("Infectedbody38", CubeListBuilder.create().texOffs(316, 265).addBox(-2.0F, 0.0F, -5.0F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, -0.4363F, 0.0F));

		PartDefinition Tumor2 = Infectedbody37.addOrReplaceChild("Tumor2", CubeListBuilder.create(), PartPose.offset(1.872F, -6.4092F, -4.4066F));

		PartDefinition cube_r48 = Tumor2.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(390, 216).addBox(-3.2F, -3.2F, -2.2F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.072F, 0.2092F, 0.0066F, 0.1125F, 0.4551F, -0.1436F));

		PartDefinition cube_r49 = Tumor2.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(362, 58).addBox(-4.2F, -4.2F, -3.2F, 7.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.072F, -0.7908F, 1.0066F, 0.2309F, -0.0672F, 0.0717F));

		PartDefinition Infectedbody39 = Lowerjaw.addOrReplaceChild("Infectedbody39", CubeListBuilder.create(), PartPose.offsetAndRotation(12.0F, 3.0F, -5.0F, 1.332F, -0.9276F, -0.0876F));

		PartDefinition Infectedbody_r66 = Infectedbody39.addOrReplaceChild("Infectedbody_r66", CubeListBuilder.create().texOffs(394, 166).addBox(-3.5F, -6.0F, -1.0F, 7.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.0555F, 0.5648F, -0.1584F));

		PartDefinition Infectedbody40 = Infectedbody39.addOrReplaceChild("Infectedbody40", CubeListBuilder.create().texOffs(262, 366).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 1.3793F, 0.3885F, 0.3156F));

		PartDefinition Infectedbody41 = Infectedbody40.addOrReplaceChild("Infectedbody41", CubeListBuilder.create().texOffs(356, 245).addBox(-4.0F, -8.0F, -5.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(400, 378).addBox(-4.0F, -2.0F, 0.0F, 8.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.3521F, -0.1776F, -0.4483F));

		PartDefinition Infectedbody98 = Infectedbody41.addOrReplaceChild("Infectedbody98", CubeListBuilder.create().texOffs(372, 286).addBox(-4.0F, 0.0F, -5.0F, 8.0F, 1.0F, 5.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, -1.0F, 0.0F));

		PartDefinition Evilshoulder = Upperbody.addOrReplaceChild("Evilshoulder", CubeListBuilder.create(), PartPose.offsetAndRotation(22.0F, -13.0F, 7.0F, -0.3749F, 0.8869F, -0.124F));

		PartDefinition cube_r50 = Evilshoulder.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(88, 130).addBox(-10.364F, -27.8088F, -8.7859F, 18.0F, 31.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.7854F));

		PartDefinition cube_r51 = Evilshoulder.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1518F, -30.6552F, -3.3691F, 1.8467F, 0.1763F, 1.1818F));

		PartDefinition cube_r52 = Evilshoulder.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(438, 12).mirror().addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.1518F, -31.4052F, -1.3691F, 1.2776F, 0.1451F, -0.9586F));

		PartDefinition cube_r53 = Evilshoulder.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1518F, -31.4052F, -3.3691F, 1.2984F, 0.1817F, -0.8312F));

		PartDefinition Leftarmmain = Evilshoulder.addOrReplaceChild("Leftarmmain", CubeListBuilder.create().texOffs(0, 167).addBox(-7.4F, -3.4F, -9.6F, 19.0F, 19.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(16.0F, -24.0F, 1.0F, 0.0466F, -0.484F, -0.6003F));

		PartDefinition cube_r54 = Leftarmmain.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 205).addBox(0.4123F, -12.2379F, -13.5933F, 13.0F, 16.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.2817F, 0.4218F, 0.0621F));

		PartDefinition cube_r55 = Leftarmmain.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(162, 127).addBox(-4.5216F, -14.1399F, -6.7749F, 19.0F, 24.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.3556F, -0.263F, 0.0665F));

		PartDefinition cube_r56 = Leftarmmain.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(108, 45).addBox(-15.1646F, -10.8395F, -8.0167F, 21.0F, 21.0F, 21.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.8F, -0.2F, 1.6F, -0.0824F, 0.363F, 0.1389F));

		PartDefinition cube_r57 = Leftarmmain.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(211, 60).addBox(-7.5F, -4.5F, -10.5F, 8.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.1F, 4.1F, -1.1F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cube_r58 = Leftarmmain.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(196, 44).addBox(-6.5F, -4.5F, -9.5F, 11.0F, 11.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.1F, 4.1F, -1.1F, 0.0F, 0.0F, -0.6545F));

		PartDefinition cube_r59 = Leftarmmain.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(435, 12).addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.4018F, -15.4052F, 6.1309F, -0.2598F, -0.5328F, 0.1298F));

		PartDefinition cube_r60 = Leftarmmain.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(435, 12).addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.4018F, -14.6552F, 7.1309F, -0.2391F, -0.3636F, 0.082F));

		PartDefinition cube_r61 = Leftarmmain.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(435, 12).mirror().addBox(-9.0F, -1.5F, 0.0F, 15.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(7.4018F, -13.4052F, 11.1309F, -0.228F, 0.0419F, -0.1036F));

		PartDefinition cube_r62 = Leftarmmain.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1518F, -10.4052F, -12.7691F, 1.154F, 0.1855F, -0.41F));

		PartDefinition cube_r63 = Leftarmmain.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.1518F, -9.6552F, -12.7691F, 1.7352F, 0.4251F, 1.1485F));

		PartDefinition bloom2 = Leftarmmain.addOrReplaceChild("bloom2", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, -5.0F, -1.0F, 1.3035F, -0.6559F, -0.434F));

		PartDefinition cube_r64 = bloom2.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r65 = bloom2.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r66 = bloom2.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(264, 0).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r67 = bloom2.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r68 = bloom2.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r69 = bloom2.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Leftarm = Leftarmmain.addOrReplaceChild("Leftarm", CubeListBuilder.create().texOffs(230, 96).addBox(-7.0F, -8.0F, -7.0F, 14.0F, 15.0F, 14.0F, new CubeDeformation(0.0F))
				.texOffs(0, 239).addBox(5.0F, -4.0F, -2.0F, 22.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(13.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition cube_r70 = Leftarm.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(328, 0).addBox(20.0F, -4.0F, -14.0F, 8.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(232, 272).addBox(3.0F, -6.0F, -15.0F, 17.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -6.0F, 3.0F, 1.024F, -0.1218F, 0.006F));

		PartDefinition cube_r71 = Leftarm.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(62, 216).addBox(-7.0F, -18.0F, 2.0F, 37.0F, 20.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -1.25F, -1.0F, 0.5986F, -0.2469F, -0.0273F));

		PartDefinition cube_r72 = Leftarm.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(328, 354).addBox(1.0F, -13.0F, 2.0F, 10.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 4.0F, 0.7928F, -0.1657F, 0.0839F));

		PartDefinition cube_r73 = Leftarm.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(192, 45).addBox(-7.0F, -10.0F, -10.0F, 18.0F, 12.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, -3.0F, 0.0F, 0.8319F, -0.3161F, -0.079F));

		PartDefinition cube_r74 = Leftarm.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(296, 354).addBox(14.0F, -11.0F, -2.0F, 8.0F, 7.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(288, 272).mirror().addBox(-9.0F, -26.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
				.texOffs(298, 193).addBox(1.0F, -13.0F, -4.0F, 14.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, 2.0F, 4.0F, -0.0547F, 0.3006F, 0.1662F));

		PartDefinition cube_r75 = Leftarm.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(288, 272).addBox(-15.0F, 4.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(9.0F, 3.75F, 27.5F, -1.5628F, -0.3299F, 2.9318F));

		PartDefinition cube_r76 = Leftarm.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(288, 272).addBox(-12.0F, -11.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(19.7866F, -0.0621F, -3.7606F, 1.1231F, 0.1582F, 2.7962F));

		PartDefinition cube_r77 = Leftarm.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(288, 272).mirror().addBox(-15.0F, -26.0F, 0.0F, 24.0F, 22.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(9.0F, 6.25F, 6.25F, -0.6033F, -0.0627F, 0.2067F));

		PartDefinition cube_r78 = Leftarm.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(196, 0).addBox(-4.0F, -11.0F, -8.0F, 17.0F, 16.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 2.0F, 4.0F, 0.0F, -0.2618F, 0.3491F));

		PartDefinition Root3 = Leftarm.addOrReplaceChild("Root3", CubeListBuilder.create(), PartPose.offsetAndRotation(12.6297F, 5.5944F, -2.0F, -0.2132F, 0.3799F, 0.9216F));

		PartDefinition R3Seg1 = Root3.addOrReplaceChild("R3Seg1", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.4334F, 0.3528F, -0.4797F));

		PartDefinition RootSeg_r2 = R3Seg1.addOrReplaceChild("RootSeg_r2", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg2 = R3Seg1.addOrReplaceChild("R3Seg2", CubeListBuilder.create().texOffs(298, 253).addBox(-1.125F, -0.625F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition R3Seg3 = R3Seg2.addOrReplaceChild("R3Seg3", CubeListBuilder.create().texOffs(164, 322).addBox(-0.125F, -0.625F, -0.375F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg = R3Seg3.addOrReplaceChild("RootSeg", CubeListBuilder.create().texOffs(164, 324).addBox(0.125F, -0.4806F, -0.125F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Root4 = Leftarm.addOrReplaceChild("Root4", CubeListBuilder.create().texOffs(402, 60).addBox(0.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.6297F, 5.5944F, -2.0F, 0.6158F, 0.3799F, 0.9216F));

		PartDefinition R3Seg13 = Root4.addOrReplaceChild("R3Seg13", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, -0.6271F, 0.537F, -0.2089F));

		PartDefinition RootSeg_r3 = R3Seg13.addOrReplaceChild("RootSeg_r3", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, -3.1067F, -0.0217F, -3.1273F));

		PartDefinition R3Seg14 = R3Seg13.addOrReplaceChild("R3Seg14", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition RootSeg_r4 = R3Seg14.addOrReplaceChild("RootSeg_r4", CubeListBuilder.create().texOffs(298, 253).addBox(-1.625F, -1.125F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.5F, 0.5F, 0.0F, -0.041F, -0.0022F, 0.0147F));

		PartDefinition R3Seg15 = R3Seg14.addOrReplaceChild("R3Seg15", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg_r5 = R3Seg15.addOrReplaceChild("RootSeg_r5", CubeListBuilder.create().texOffs(164, 322).addBox(0.125F, 0.125F, -0.125F, 11.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -0.75F, -0.25F, -0.0366F, 0.0186F, 0.0144F));

		PartDefinition RootSeg2 = R3Seg15.addOrReplaceChild("RootSeg2", CubeListBuilder.create(), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Root5 = Leftarm.addOrReplaceChild("Root5", CubeListBuilder.create().texOffs(402, 60).addBox(0.0F, -1.5F, -1.5F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(10.1297F, 5.5944F, 8.0F, -1.27F, -0.1712F, -0.0025F));

		PartDefinition R3Seg16 = Root5.addOrReplaceChild("R3Seg16", CubeListBuilder.create(), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.4334F, 0.3528F, -0.4797F));

		PartDefinition RootSeg_r6 = R3Seg16.addOrReplaceChild("RootSeg_r6", CubeListBuilder.create().texOffs(364, 12).addBox(-4.0F, -1.0F, -1.0F, 8.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg17 = R3Seg16.addOrReplaceChild("R3Seg17", CubeListBuilder.create().texOffs(298, 253).addBox(-1.125F, -0.625F, -0.375F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(7.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition R3Seg18 = R3Seg17.addOrReplaceChild("R3Seg18", CubeListBuilder.create(), PartPose.offsetAndRotation(7.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.5236F));

		PartDefinition RootSeg3 = R3Seg18.addOrReplaceChild("RootSeg3", CubeListBuilder.create(), PartPose.offsetAndRotation(10.75F, -0.1444F, -0.25F, 0.0F, 0.1745F, 0.6981F));

		PartDefinition Lowersegleftarm = Leftarm.addOrReplaceChild("Lowersegleftarm", CubeListBuilder.create().texOffs(290, 206).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(27.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition cube_r79 = Lowersegleftarm.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(190, 360).addBox(-4.0F, -4.0F, -5.0F, 8.0F, 8.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, 0.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r80 = Lowersegleftarm.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(286, 96).addBox(22.0F, -5.0F, -2.0F, 20.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 6.0F, -0.1276F, 0.1096F, 0.1206F));

		PartDefinition cube_r81 = Lowersegleftarm.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(230, 75).addBox(-22.0F, -7.0F, -5.0F, 23.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 3.0F, 0.0F, 0.7933F, -0.2241F, -0.1629F));

		PartDefinition cube_r82 = Lowersegleftarm.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(264, 57).addBox(-20.0F, -4.0F, -7.0F, 21.0F, 8.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(42.0F, 0.0F, 0.0F, -0.4557F, -0.2173F, 0.0894F));

		PartDefinition Infectedarm37 = Lowersegleftarm.addOrReplaceChild("Infectedarm37", CubeListBuilder.create().texOffs(410, 291).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(31.0F, -6.0F, -7.0F, -1.0007F, -0.6178F, -1.7502F));

		PartDefinition Infectedarm38 = Infectedarm37.addOrReplaceChild("Infectedarm38", CubeListBuilder.create().texOffs(80, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm39 = Infectedarm38.addOrReplaceChild("Infectedarm39", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm40 = Infectedarm38.addOrReplaceChild("Infectedarm40", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1074F, 0.0749F, 0.6068F));

		PartDefinition bloom3 = Lowersegleftarm.addOrReplaceChild("bloom3", CubeListBuilder.create(), PartPose.offsetAndRotation(39.0F, 6.0F, -4.0F, 0.7418F, 0.0F, 2.9234F));

		PartDefinition cube_r83 = bloom3.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r84 = bloom3.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r85 = bloom3.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(264, 0).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r86 = bloom3.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(64, 262).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r87 = bloom3.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r88 = bloom3.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(0, 258).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm33 = Lowersegleftarm.addOrReplaceChild("Infectedarm33", CubeListBuilder.create().texOffs(410, 255).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(24.0F, 5.0F, -11.0F, -0.8771F, 0.573F, -0.5364F));

		PartDefinition Infectedarm34 = Infectedarm33.addOrReplaceChild("Infectedarm34", CubeListBuilder.create().texOffs(64, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5144F, 0.2507F, -0.4137F));

		PartDefinition Infectedarm36 = Infectedarm34.addOrReplaceChild("Infectedarm36", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition Infectedarm35 = Infectedarm34.addOrReplaceChild("Infectedarm35", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1005F, -0.084F, -0.6939F));

		PartDefinition bloom4 = Lowersegleftarm.addOrReplaceChild("bloom4", CubeListBuilder.create(), PartPose.offsetAndRotation(23.0F, -7.0F, 6.0F, -0.4702F, 0.1001F, 0.1942F));

		PartDefinition cube_r89 = bloom4.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r90 = bloom4.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r91 = bloom4.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(252, 256).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r92 = bloom4.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r93 = bloom4.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r94 = bloom4.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm41 = Lowersegleftarm.addOrReplaceChild("Infectedarm41", CubeListBuilder.create().texOffs(410, 301).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(26.0F, 3.0F, 8.0F, 1.0649F, 0.3082F, -1.1264F));

		PartDefinition Infectedarm42 = Infectedarm41.addOrReplaceChild("Infectedarm42", CubeListBuilder.create().texOffs(96, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.3838F, 0.2129F, 0.4821F));

		PartDefinition Infectedarm43 = Infectedarm42.addOrReplaceChild("Infectedarm43", CubeListBuilder.create().texOffs(382, 412).addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		PartDefinition Infectedarm44 = Infectedarm42.addOrReplaceChild("Infectedarm44", CubeListBuilder.create().texOffs(382, 412).addBox(-1.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 8.0F, -2.0F, -0.1278F, -0.0283F, -0.2164F));

		PartDefinition BladeArmTumor = Lowersegleftarm.addOrReplaceChild("BladeArmTumor", CubeListBuilder.create().texOffs(146, 206).addBox(2.0F, -5.0F, -6.0F, 30.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, 0.0F, 1.0F));

		PartDefinition cube_r95 = BladeArmTumor.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(238, 169).addBox(9.0F, -9.0F, -6.0F, 18.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -2.0F, 3.0F, -0.1268F, 0.023F, 0.1317F));

		PartDefinition cube_r96 = BladeArmTumor.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(62, 236).addBox(-1.9806F, -6.0397F, -3.6195F, 18.0F, 9.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, -0.8698F, -0.0974F, 0.5018F));

		PartDefinition cube_r97 = BladeArmTumor.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -6.9052F, 6.1309F, -2.2528F, 0.3503F, 2.9732F));

		PartDefinition cube_r98 = BladeArmTumor.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.3482F, -7.6552F, -0.8691F, 2.7144F, -0.1681F, 2.8989F));

		PartDefinition cube_r99 = BladeArmTumor.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -6.6552F, 2.1309F, -0.3145F, 1.1099F, -0.5027F));

		PartDefinition cube_r100 = BladeArmTumor.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(438, 12).addBox(-6.0F, -1.5F, 0.0F, 12.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.5982F, -7.4052F, 2.1309F, -0.147F, -0.3503F, -0.1684F));

		PartDefinition cube_r101 = BladeArmTumor.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(50, 278).addBox(1.0F, -5.0F, -7.0F, 13.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -1.0F, 0.0189F, 0.0852F, 0.219F));

		PartDefinition cube_r102 = BladeArmTumor.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(266, 222).addBox(-1.0F, -6.0F, -7.0F, 15.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, 0.0F, -0.147F, -0.3503F, -0.1684F));

		PartDefinition Evilhand = Lowersegleftarm.addOrReplaceChild("Evilhand", CubeListBuilder.create(), PartPose.offsetAndRotation(41.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.829F));

		PartDefinition cube_r103 = Evilhand.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(320, 231).addBox(-2.0621F, -1.9472F, -7.0F, 11.0F, 7.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.0F, -0.2182F, 0.1309F));

		PartDefinition cube_r104 = Evilhand.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(294, 169).addBox(-2.0621F, -5.9472F, -6.0F, 11.0F, 13.0F, 11.0F, new CubeDeformation(0.1F))
				.texOffs(300, 112).addBox(8.9379F, -4.9472F, -4.0F, 16.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition Bigahhblade = Evilhand.addOrReplaceChild("Bigahhblade", CubeListBuilder.create(), PartPose.offsetAndRotation(21.0F, -1.0F, -1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r105 = Bigahhblade.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(32, 358).addBox(8.9379F, -4.9472F, -2.0F, 6.0F, 28.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 56.0F, 1.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r106 = Bigahhblade.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(0, 0).addBox(-18.0621F, -31.9472F, 0.0F, 54.0F, 98.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(0, 318).addBox(8.9379F, -4.9472F, -2.0F, 10.0F, 28.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-11.0F, 39.0F, 0.0F, 0.0F, 0.0F, 0.5236F));

		PartDefinition cube_r107 = Bigahhblade.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(238, 193).addBox(0.9379F, -6.9472F, -2.0F, 28.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 20.0F, 1.0F, 0.0F, 0.0F, 1.7017F));

		PartDefinition cube_r108 = Bigahhblade.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(108, 87).addBox(15.0235F, -2.642F, -3.0F, 15.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(296, 74).addBox(-0.9765F, -3.642F, -4.0F, 16.0F, 10.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -6.0F, 0.0F, 0.0F, 0.0F, -1.7453F));

		PartDefinition cube_r109 = Bigahhblade.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(358, 208).addBox(-8.6418F, -3.9479F, -4.0F, 10.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -1.0F, 1.0F, 0.0F, 0.0F, 2.0071F));

		PartDefinition cube_r110 = Bigahhblade.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(236, 33).addBox(14.9379F, -6.9472F, -3.0F, 10.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition cube_r111 = Bigahhblade.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(0, 98).addBox(-41.355F, -36.7225F, 0.0F, 75.0F, 32.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -1.0F, 0.0F, -0.0436F, 1.309F));

		PartDefinition cube_r112 = Bigahhblade.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(316, 16).addBox(-1.355F, -5.7225F, -2.0F, 17.0F, 14.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.309F));

		PartDefinition Spitter = Bigahhblade.addOrReplaceChild("Spitter", CubeListBuilder.create().texOffs(362, 30).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0F, 10.0F, 0.0F, 0.1539F, -1.5148F, 2.641F));

		PartDefinition Infectedbody_r67 = Spitter.addOrReplaceChild("Infectedbody_r67", CubeListBuilder.create().texOffs(362, 44).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Spitterneck = Spitter.addOrReplaceChild("Spitterneck", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r68 = Spitterneck.addOrReplaceChild("Infectedbody_r68", CubeListBuilder.create().texOffs(48, 369).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r69 = Spitterneck.addOrReplaceChild("Infectedbody_r69", CubeListBuilder.create().texOffs(410, 148).addBox(-2.0F, -8.0F, 1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody87 = Spitterneck.addOrReplaceChild("Infectedbody87", CubeListBuilder.create().texOffs(210, 401).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Infectedbody88 = Infectedbody87.addOrReplaceChild("Infectedbody88", CubeListBuilder.create().texOffs(410, 216).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -5.0F, 0.3867F, 0.3189F, 0.2333F));

		PartDefinition Infectedbody89 = Infectedbody88.addOrReplaceChild("Infectedbody89", CubeListBuilder.create().texOffs(306, 245).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, 0.2549F, -0.2411F));

		PartDefinition Infectedbody90 = Infectedbody87.addOrReplaceChild("Infectedbody90", CubeListBuilder.create().texOffs(220, 410).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, 0.0F, -5.0F, 0.3867F, -0.3189F, -0.2333F));

		PartDefinition Infectedbody91 = Infectedbody90.addOrReplaceChild("Infectedbody91", CubeListBuilder.create().texOffs(316, 34).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, -0.2549F, 0.2411F));

		PartDefinition Spitterhead = Spitterneck.addOrReplaceChild("Spitterhead", CubeListBuilder.create().texOffs(344, 184).addBox(-4.0F, -9.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(100, 258).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Spitterjawright = Spitterhead.addOrReplaceChild("Spitterjawright", CubeListBuilder.create().texOffs(132, 236).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(158, 340).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, 0.4363F));

		PartDefinition Lowerspitterjawrigth = Spitterjawright.addOrReplaceChild("Lowerspitterjawrigth", CubeListBuilder.create().texOffs(124, 278).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(138, 410).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, -0.1468F, -0.162F));

		PartDefinition Spitterjawleft = Spitterhead.addOrReplaceChild("Spitterjawleft", CubeListBuilder.create().texOffs(280, 309).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(302, 411).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, -0.4363F));

		PartDefinition Lowerspitterjawleft = Spitterjawleft.addOrReplaceChild("Lowerspitterjawleft", CubeListBuilder.create().texOffs(60, 342).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(182, 412).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, 0.1468F, 0.162F));

		PartDefinition Spitterarmleft = Spitter.addOrReplaceChild("Spitterarmleft", CubeListBuilder.create().texOffs(412, 10).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(180, 262).addBox(1.0F, 5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -12.0F, 2.0F, -1.8762F, 0.0F, 0.0F));

		PartDefinition Spitterarmright = Spitter.addOrReplaceChild("Spitterarmright", CubeListBuilder.create().texOffs(412, 130).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(124, 236).addBox(-1.0F, 3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -12.0F, 2.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition Spitter2 = Bigahhblade.addOrReplaceChild("Spitter2", CubeListBuilder.create().texOffs(362, 30).addBox(-4.0F, -13.0F, -1.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 17.0F, 0.0F, 0.0754F, 1.5457F, -2.3237F));

		PartDefinition Infectedbody_r70 = Spitter2.addOrReplaceChild("Infectedbody_r70", CubeListBuilder.create().texOffs(362, 44).addBox(-4.0F, -8.0F, -3.0F, 8.0F, 8.0F, 6.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.0F, 1.0F, -1.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Spitterneck2 = Spitter2.addOrReplaceChild("Spitterneck2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -12.0F, 1.0F, -0.6981F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r71 = Spitterneck2.addOrReplaceChild("Infectedbody_r71", CubeListBuilder.create().texOffs(48, 369).addBox(-3.0F, -5.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r72 = Spitterneck2.addOrReplaceChild("Infectedbody_r72", CubeListBuilder.create().texOffs(410, 148).addBox(-2.0F, -8.0F, 1.0F, 4.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody67 = Spitterneck2.addOrReplaceChild("Infectedbody67", CubeListBuilder.create().texOffs(210, 401).addBox(-1.5F, -1.5F, -6.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, -1.5F, -3.0F, -0.5236F, 0.0F, 0.0F));

		PartDefinition Infectedbody69 = Infectedbody67.addOrReplaceChild("Infectedbody69", CubeListBuilder.create().texOffs(410, 216).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -5.0F, 0.3867F, 0.3189F, 0.2333F));

		PartDefinition Infectedbody101 = Infectedbody69.addOrReplaceChild("Infectedbody101", CubeListBuilder.create().texOffs(306, 245).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, 0.2549F, -0.2411F));

		PartDefinition Infectedbody102 = Infectedbody67.addOrReplaceChild("Infectedbody102", CubeListBuilder.create().texOffs(220, 410).addBox(-0.5F, -1.5F, -7.0F, 1.0F, 3.0F, 7.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.0F, 0.0F, -5.0F, 0.3867F, -0.3189F, -0.2333F));

		PartDefinition Infectedbody103 = Infectedbody102.addOrReplaceChild("Infectedbody103", CubeListBuilder.create().texOffs(316, 34).addBox(-0.5F, -1.5F, -4.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -7.0F, -0.7728F, -0.2549F, 0.2411F));

		PartDefinition Spitterhead2 = Spitterneck2.addOrReplaceChild("Spitterhead2", CubeListBuilder.create().texOffs(344, 184).addBox(-4.0F, -9.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(100, 258).addBox(-5.0F, -1.0F, -2.0F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -1.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition Spitterjawright2 = Spitterhead2.addOrReplaceChild("Spitterjawright2", CubeListBuilder.create().texOffs(132, 236).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(158, 340).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, 0.4363F));

		PartDefinition Lowerspitterjawrigth2 = Spitterjawright2.addOrReplaceChild("Lowerspitterjawrigth2", CubeListBuilder.create().texOffs(124, 278).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(138, 410).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, -0.1468F, -0.162F));

		PartDefinition Spitterjawleft2 = Spitterhead2.addOrReplaceChild("Spitterjawleft2", CubeListBuilder.create().texOffs(280, 309).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(302, 411).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 1.0F, -1.0F, -0.5236F, 0.0F, -0.4363F));

		PartDefinition Lowerspitterjawleft2 = Spitterjawleft2.addOrReplaceChild("Lowerspitterjawleft2", CubeListBuilder.create().texOffs(60, 342).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 9.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(182, 412).addBox(0.0F, 0.0F, -3.0F, 0.0F, 9.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, -0.7298F, 0.1468F, 0.162F));

		PartDefinition Spitterarmleft2 = Spitter2.addOrReplaceChild("Spitterarmleft2", CubeListBuilder.create().texOffs(412, 10).addBox(-1.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(180, 262).addBox(1.0F, 5.0F, -2.0F, 0.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -12.0F, 2.0F, -1.8762F, 0.0F, 0.0F));

		PartDefinition Spitterarmright2 = Spitter2.addOrReplaceChild("Spitterarmright2", CubeListBuilder.create().texOffs(412, 130).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(124, 236).addBox(-1.0F, 3.0F, -2.0F, 0.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -12.0F, 2.0F, -1.9635F, 0.0F, 0.0F));

		PartDefinition Infectedbody109 = Evilshoulder.addOrReplaceChild("Infectedbody109", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -7.0F, -9.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition Infectedbody_r73 = Infectedbody109.addOrReplaceChild("Infectedbody_r73", CubeListBuilder.create().texOffs(92, 410).mirror().addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(6.0F, -12.0F, 0.5F, -0.3527F, -0.2624F, -0.4149F));

		PartDefinition Infectedbody_r74 = Infectedbody109.addOrReplaceChild("Infectedbody_r74", CubeListBuilder.create().texOffs(220, 363).mirror().addBox(-4.0F, -5.0F, -2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.5305F, -0.3408F, 0.1556F));

		PartDefinition UpperRightarm = Upperbody.addOrReplaceChild("UpperRightarm", CubeListBuilder.create().texOffs(320, 211).addBox(-5.0F, -5.0F, -5.0F, 9.0F, 10.0F, 10.0F, new CubeDeformation(0.0F))
				.texOffs(264, 42).addBox(-28.0F, -3.0F, -4.0F, 23.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-26.0F, -26.0F, -5.0F, -0.9405F, -0.4347F, 0.231F));

		PartDefinition cube_r113 = UpperRightarm.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(358, 337).addBox(-15.0F, -8.0F, -7.0F, 9.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -6.0F, 3.0F, 1.024F, 0.1218F, -0.006F));

		PartDefinition cube_r114 = UpperRightarm.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(100, 288).addBox(-11.0F, -7.0F, -5.0F, 15.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, -3.0F, 1.0F, 0.8319F, 0.3161F, 0.079F));

		PartDefinition cube_r115 = UpperRightarm.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(44, 300).addBox(-8.0F, -5.0F, -5.0F, 12.0F, 9.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 2.0F, 4.0F, 0.0F, 0.2618F, -0.3491F));

		PartDefinition bloom5 = UpperRightarm.addOrReplaceChild("bloom5", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, -7.0F, 6.0F, -0.5672F, 0.0F, 0.0F));

		PartDefinition cube_r116 = bloom5.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r117 = bloom5.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r118 = bloom5.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(252, 256).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r119 = bloom5.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r120 = bloom5.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r121 = bloom5.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Infectedarm49 = UpperRightarm.addOrReplaceChild("Infectedarm49", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, -7.0F, 6.0F, 1.7244F, 1.183F, -1.7499F));

		PartDefinition Infectedarm_r1 = Infectedarm49.addOrReplaceChild("Infectedarm_r1", CubeListBuilder.create().texOffs(412, 120).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Infectedarm50 = Infectedarm49.addOrReplaceChild("Infectedarm50", CubeListBuilder.create().texOffs(16, 413).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 1.1781F, 0.0F, 0.0F));

		PartDefinition Infectedarm31 = UpperRightarm.addOrReplaceChild("Infectedarm31", CubeListBuilder.create().texOffs(204, 410).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, -6.0F, -5.0F, -1.0692F, 0.8388F, 0.9844F));

		PartDefinition Infectedarm32 = Infectedarm31.addOrReplaceChild("Infectedarm32", CubeListBuilder.create().texOffs(48, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm47 = UpperRightarm.addOrReplaceChild("Infectedarm47", CubeListBuilder.create().texOffs(410, 321).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -10.0F, 1.0F, -0.6255F, 1.3562F, 2.8143F));

		PartDefinition Infectedarm48 = Infectedarm47.addOrReplaceChild("Infectedarm48", CubeListBuilder.create().texOffs(128, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm45 = UpperRightarm.addOrReplaceChild("Infectedarm45", CubeListBuilder.create().texOffs(410, 311).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, -6.0F, -5.0F, -1.4429F, -0.3844F, 1.1311F));

		PartDefinition Infectedarm46 = Infectedarm45.addOrReplaceChild("Infectedarm46", CubeListBuilder.create().texOffs(112, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm77 = UpperRightarm.addOrReplaceChild("Infectedarm77", CubeListBuilder.create().texOffs(410, 138).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-30.0F, 1.0F, 5.0F, 2.2689F, 0.2166F, -3.1039F));

		PartDefinition Infectedarm78 = Infectedarm77.addOrReplaceChild("Infectedarm78", CubeListBuilder.create().texOffs(324, 396).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LowersegRightarm = UpperRightarm.addOrReplaceChild("LowersegRightarm", CubeListBuilder.create().texOffs(136, 226).addBox(-25.0F, -5.0F, -5.0F, 25.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-28.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.2217F));

		PartDefinition cube_r122 = LowersegRightarm.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(300, 129).addBox(-8.0F, -5.0F, -3.0F, 13.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-13.0F, -1.0F, 3.0F, -0.2883F, -0.1271F, 0.1929F));

		PartDefinition cube_r123 = LowersegRightarm.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(124, 322).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-10.0F, -2.0F, -2.0F, 0.3155F, 0.2494F, 0.0804F));

		PartDefinition cube_r124 = LowersegRightarm.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(290, 211).addBox(-8.0F, -11.0F, 0.0F, 15.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(316, 245).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -3.0F, -2.0F, 0.2986F, -0.0651F, 0.2084F));

		PartDefinition cube_r125 = LowersegRightarm.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, -3.0F, -2.0F, -2.7856F, 0.147F, 0.0945F));

		PartDefinition Infectedarm87 = LowersegRightarm.addOrReplaceChild("Infectedarm87", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-20.0F, 3.0F, -4.0F, -1.734F, 0.3266F, -0.9864F));

		PartDefinition Infectedarm88 = Infectedarm87.addOrReplaceChild("Infectedarm88", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm89 = Infectedarm88.addOrReplaceChild("Infectedarm89", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm90 = Infectedarm88.addOrReplaceChild("Infectedarm90", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm83 = LowersegRightarm.addOrReplaceChild("Infectedarm83", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-10.0F, 4.0F, -1.0F, 3.1416F, 0.0F, -2.4871F));

		PartDefinition Infectedarm84 = Infectedarm83.addOrReplaceChild("Infectedarm84", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm85 = Infectedarm84.addOrReplaceChild("Infectedarm85", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm86 = Infectedarm84.addOrReplaceChild("Infectedarm86", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedbody66 = LowersegRightarm.addOrReplaceChild("Infectedbody66", CubeListBuilder.create().texOffs(376, 177).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, 6.0F, 0.0F, -1.5708F, -1.4399F, 0.0F));

		PartDefinition Infectedbody_r75 = Infectedbody66.addOrReplaceChild("Infectedbody_r75", CubeListBuilder.create().texOffs(390, 9).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		PartDefinition Infectedarm79 = Infectedbody66.addOrReplaceChild("Infectedarm79", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, -8.0F, -1.0F, 2.6847F, 1.0749F, 0.9578F));

		PartDefinition Infectedarm80 = Infectedarm79.addOrReplaceChild("Infectedarm80", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm81 = Infectedarm80.addOrReplaceChild("Infectedarm81", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm82 = Infectedarm80.addOrReplaceChild("Infectedarm82", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedbody68 = Infectedbody66.addOrReplaceChild("Infectedbody68", CubeListBuilder.create().texOffs(358, 16).addBox(-4.0F, -8.0F, -2.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.679F, 0.038F, -0.2511F));

		PartDefinition Infectedbody_r76 = Infectedbody68.addOrReplaceChild("Infectedbody_r76", CubeListBuilder.create().texOffs(390, 18).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition Infectedbody70 = Infectedbody68.addOrReplaceChild("Infectedbody70", CubeListBuilder.create().texOffs(360, 352).addBox(-4.0F, 0.0F, -1.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, -1.0078F, 0.084F, -0.1005F));

		PartDefinition Infectedarm27 = LowersegRightarm.addOrReplaceChild("Infectedarm27", CubeListBuilder.create().texOffs(410, 138).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, -1.0F, 7.0F, 1.6746F, 0.6075F, -3.0633F));

		PartDefinition Infectedarm28 = Infectedarm27.addOrReplaceChild("Infectedarm28", CubeListBuilder.create().texOffs(324, 396).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm25 = LowersegRightarm.addOrReplaceChild("Infectedarm25", CubeListBuilder.create().texOffs(122, 410).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -4.0F, -6.0F, -1.4157F, 0.0269F, 0.5015F));

		PartDefinition Infectedarm26 = Infectedarm25.addOrReplaceChild("Infectedarm26", CubeListBuilder.create().texOffs(76, 167).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm23 = LowersegRightarm.addOrReplaceChild("Infectedarm23", CubeListBuilder.create().texOffs(106, 410).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.0F, 0.0F, -6.0F, -0.9098F, 0.3032F, 0.2774F));

		PartDefinition Infectedarm24 = Infectedarm23.addOrReplaceChild("Infectedarm24", CubeListBuilder.create().texOffs(308, 396).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedbody65 = LowersegRightarm.addOrReplaceChild("Infectedbody65", CubeListBuilder.create().texOffs(412, 395).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 1.0F, -3.0F, -0.4363F, 0.0F, 0.3491F));

		PartDefinition hand = LowersegRightarm.addOrReplaceChild("hand", CubeListBuilder.create(), PartPose.offsetAndRotation(-23.0F, -2.0F, 0.0F, 0.0F, 0.0F, -0.5236F));

		PartDefinition cube_r126 = hand.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(236, 295).addBox(-15.9379F, -0.9472F, -4.0F, 19.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4164F, -0.3766F, 0.4645F));

		PartDefinition cube_r127 = hand.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(232, 292).addBox(-16.9379F, -4.9472F, -4.0F, 19.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Infectedarm53 = hand.addOrReplaceChild("Infectedarm53", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 4.0F, -4.0F, -1.077F, 0.3216F, 0.4708F));

		PartDefinition Infectedarm54 = Infectedarm53.addOrReplaceChild("Infectedarm54", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm51 = hand.addOrReplaceChild("Infectedarm51", CubeListBuilder.create().texOffs(410, 321).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, 1.0F, 1.9649F, 1.2174F, -1.7566F));

		PartDefinition Infectedarm52 = Infectedarm51.addOrReplaceChild("Infectedarm52", CubeListBuilder.create().texOffs(128, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm_r2 = Infectedarm52.addOrReplaceChild("Infectedarm_r2", CubeListBuilder.create().texOffs(131, 399).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(1.5F, 1.5F, 0.0F, 0.2727F, 0.1393F, -0.4608F));

		PartDefinition Infectedarm_r3 = Infectedarm52.addOrReplaceChild("Infectedarm_r3", CubeListBuilder.create().texOffs(131, 399).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition UpperRightfinger = hand.addOrReplaceChild("UpperRightfinger", CubeListBuilder.create().texOffs(356, 259).addBox(-17.0F, -1.0F, -1.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, 0.0F, 3.0F, -0.0579F, 0.2555F, -0.2256F));

		PartDefinition Infectedarm71 = UpperRightfinger.addOrReplaceChild("Infectedarm71", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-13.0F, 2.0F, 1.0F, 2.1818F, 0.0758F, -1.3059F));

		PartDefinition Infectedarm72 = Infectedarm71.addOrReplaceChild("Infectedarm72", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm73 = Infectedarm72.addOrReplaceChild("Infectedarm73", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm74 = Infectedarm72.addOrReplaceChild("Infectedarm74", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm69 = UpperRightfinger.addOrReplaceChild("Infectedarm69", CubeListBuilder.create().texOffs(410, 311).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-16.0F, 1.0F, 0.0F, 3.0107F, 1.2217F, -1.9635F));

		PartDefinition Infectedarm70 = Infectedarm69.addOrReplaceChild("Infectedarm70", CubeListBuilder.create().texOffs(112, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm75 = UpperRightfinger.addOrReplaceChild("Infectedarm75", CubeListBuilder.create().texOffs(410, 311).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, 1.9013F, 0.6693F, 3.1032F));

		PartDefinition Infectedarm76 = Infectedarm75.addOrReplaceChild("Infectedarm76", CubeListBuilder.create().texOffs(112, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition UpperRightfinger2 = hand.addOrReplaceChild("UpperRightfinger2", CubeListBuilder.create().texOffs(346, 124).addBox(-17.0F, -1.0F, -1.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-17.0F, -2.0F, -1.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition Infectedarm67 = UpperRightfinger2.addOrReplaceChild("Infectedarm67", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 1.5708F, 1.2217F, -1.9635F));

		PartDefinition Infectedarm68 = Infectedarm67.addOrReplaceChild("Infectedarm68", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm59 = UpperRightfinger2.addOrReplaceChild("Infectedarm59", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-17.0F, 1.0F, 0.0F, 3.1416F, 0.0F, -1.789F));

		PartDefinition Infectedarm60 = Infectedarm59.addOrReplaceChild("Infectedarm60", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm61 = Infectedarm60.addOrReplaceChild("Infectedarm61", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm62 = Infectedarm60.addOrReplaceChild("Infectedarm62", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition UpperRightfinger1 = hand.addOrReplaceChild("UpperRightfinger1", CubeListBuilder.create().texOffs(340, 161).addBox(-17.0F, -1.0F, -1.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, -4.0F, 0.0F, -0.5672F, 0.0F));

		PartDefinition Infectedarm63 = UpperRightfinger1.addOrReplaceChild("Infectedarm63", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 1.0F, -1.0F, -1.9233F, 0.3013F, -1.78F));

		PartDefinition Infectedarm64 = Infectedarm63.addOrReplaceChild("Infectedarm64", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm65 = Infectedarm64.addOrReplaceChild("Infectedarm65", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm66 = Infectedarm64.addOrReplaceChild("Infectedarm66", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm55 = UpperRightfinger1.addOrReplaceChild("Infectedarm55", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, 1.0F, 0.0F, -1.0401F, 0.9346F, -0.2135F));

		PartDefinition Infectedarm56 = Infectedarm55.addOrReplaceChild("Infectedarm56", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm57 = Infectedarm56.addOrReplaceChild("Infectedarm57", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm58 = Infectedarm56.addOrReplaceChild("Infectedarm58", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition LowerRightarm = Upperbody.addOrReplaceChild("LowerRightarm", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.0F, 2.0F, 3.0F, -1.6446F, 0.2546F, -0.6313F));

		PartDefinition cube_r128 = LowerRightarm.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(446, 32).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.4764F, 4.1029F, -1.1662F, 1.7909F, 0.4917F, 1.896F));

		PartDefinition cube_r129 = LowerRightarm.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(446, 32).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4764F, 2.1029F, 1.8338F, 1.3263F, 0.0851F, 1.792F));

		PartDefinition cube_r130 = LowerRightarm.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(446, 32).addBox(-3.0F, 2.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4764F, 3.1029F, 0.8338F, 1.9701F, -0.7869F, 1.4773F));

		PartDefinition cube_r131 = LowerRightarm.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(446, 32).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4764F, 3.1029F, 0.8338F, 1.8499F, 0.0851F, 1.792F));

		PartDefinition cube_r132 = LowerRightarm.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(446, 32).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.4764F, 2.1029F, -2.1662F, 2.074F, 0.5851F, 2.0768F));

		PartDefinition cube_r133 = LowerRightarm.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(446, 32).addBox(-7.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.4764F, 4.1029F, -7.1662F, 1.442F, 0.7225F, 1.8833F));

		PartDefinition cube_r134 = LowerRightarm.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(446, 38).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.4764F, 4.1029F, -3.1662F, 1.6383F, 0.1134F, 1.8317F));

		PartDefinition cube_r135 = LowerRightarm.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(0, 424).addBox(-23.5F, -3.5F, -4.0F, 23.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.0236F, 0.5778F, -0.1766F, -3.0107F, 0.0F, 0.1745F));

		PartDefinition LowerRightarmLowerSegmentButFreakyToo = LowerRightarm.addOrReplaceChild("LowerRightarmLowerSegmentButFreakyToo", CubeListBuilder.create().texOffs(136, 226).addBox(-24.0F, -8.0F, -4.0F, 25.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.4764F, 2.0778F, -0.1766F, 0.1796F, 0.1245F, -0.5996F));

		PartDefinition cube_r136 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(300, 129).addBox(-8.0F, -5.0F, -3.0F, 13.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -4.0F, 4.0F, -0.2883F, -0.1271F, 0.1929F));

		PartDefinition cube_r137 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(124, 322).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.0F, -5.0F, -1.0F, 0.3155F, 0.2494F, 0.0804F));

		PartDefinition cube_r138 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("cube_r138", CubeListBuilder.create().texOffs(290, 211).addBox(-8.0F, -11.0F, 0.0F, 15.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
				.texOffs(316, 245).addBox(-5.0F, -5.0F, -5.0F, 10.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -6.0F, -1.0F, 0.2986F, -0.0651F, 0.2084F));

		PartDefinition cube_r139 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("cube_r139", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -6.0F, -1.0F, -2.7856F, 0.147F, 0.0945F));

		PartDefinition Infectedarm197 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedarm197", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-19.0F, 0.0F, -3.0F, -1.734F, 0.3266F, -0.9864F));

		PartDefinition Infectedarm198 = Infectedarm197.addOrReplaceChild("Infectedarm198", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.48F, 0.0F, 0.7418F));

		PartDefinition Infectedarm199 = Infectedarm198.addOrReplaceChild("Infectedarm199", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm200 = Infectedarm198.addOrReplaceChild("Infectedarm200", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm201 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedarm201", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-9.0F, 1.0F, 0.0F, -2.978F, 0.7709F, -2.827F));

		PartDefinition Infectedarm202 = Infectedarm201.addOrReplaceChild("Infectedarm202", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 2.2231F, -1.3762F, -2.6753F));

		PartDefinition Infectedarm203 = Infectedarm202.addOrReplaceChild("Infectedarm203", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm204 = Infectedarm202.addOrReplaceChild("Infectedarm204", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedbody114 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedbody114", CubeListBuilder.create(), PartPose.offsetAndRotation(-16.0F, 3.0F, 1.0F, -1.5708F, -1.4399F, 0.0F));

		PartDefinition Infectedbody_r77 = Infectedbody114.addOrReplaceChild("Infectedbody_r77", CubeListBuilder.create().texOffs(158, 229).addBox(-3.5F, -12.0F, -2.0F, 7.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm205 = Infectedbody114.addOrReplaceChild("Infectedarm205", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.8026F, 0.4297F, -2.1578F, 2.4112F, 0.1231F, 0.984F));

		PartDefinition Infectedarm206 = Infectedarm205.addOrReplaceChild("Infectedarm206", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm207 = Infectedarm206.addOrReplaceChild("Infectedarm207", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm208 = Infectedarm206.addOrReplaceChild("Infectedarm208", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm209 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedarm209", CubeListBuilder.create().texOffs(410, 138).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-15.0F, -4.0F, 8.0F, 1.6746F, 0.6075F, -3.0633F));

		PartDefinition Infectedarm210 = Infectedarm209.addOrReplaceChild("Infectedarm210", CubeListBuilder.create().texOffs(324, 396).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm211 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedarm211", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, -7.0F, -5.0F, -2.0702F, 0.0269F, 0.5015F));

		PartDefinition Infectedarm212 = Infectedarm211.addOrReplaceChild("Infectedarm212", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedarm213 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("Infectedarm213", CubeListBuilder.create().texOffs(106, 410).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -3.0F, -5.0F, -1.0483F, 0.5582F, 2.3293F));

		PartDefinition Infectedarm214 = Infectedarm213.addOrReplaceChild("Infectedarm214", CubeListBuilder.create().texOffs(308, 396).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition hand2 = LowerRightarmLowerSegmentButFreakyToo.addOrReplaceChild("hand2", CubeListBuilder.create(), PartPose.offsetAndRotation(-22.0F, -5.0F, 1.0F, 0.0F, 0.0F, -0.6109F));

		PartDefinition cube_r140 = hand2.addOrReplaceChild("cube_r140", CubeListBuilder.create().texOffs(239, 292).addBox(-9.9379F, -4.9472F, -4.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 6.2F, 7.0F, -0.2986F, -1.1295F, 0.2913F));

		PartDefinition cube_r141 = hand2.addOrReplaceChild("cube_r141", CubeListBuilder.create().texOffs(239, 292).addBox(-9.9379F, -4.9472F, -4.0F, 8.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.0F, 6.0F, 0.3208F, -0.2425F, -0.2607F));

		PartDefinition cube_r142 = hand2.addOrReplaceChild("cube_r142", CubeListBuilder.create().texOffs(238, 292).addBox(-10.9379F, -4.9472F, -4.0F, 9.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 3.0F, 2.0F, 0.0F, 0.0F, -0.0436F));

		PartDefinition cube_r143 = hand2.addOrReplaceChild("cube_r143", CubeListBuilder.create().texOffs(232, 292).addBox(-16.9379F, -4.9472F, -4.0F, 19.0F, 10.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

		PartDefinition Infectedarm215 = hand2.addOrReplaceChild("Infectedarm215", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.0F, 4.0F, -4.0F, -1.077F, 0.3216F, 0.4708F));

		PartDefinition Infectedarm216 = Infectedarm215.addOrReplaceChild("Infectedarm216", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm217 = hand2.addOrReplaceChild("Infectedarm217", CubeListBuilder.create().texOffs(410, 321).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -4.0F, 1.0F, 1.9649F, 1.2174F, -1.7566F));

		PartDefinition Infectedarm218 = Infectedarm217.addOrReplaceChild("Infectedarm218", CubeListBuilder.create().texOffs(128, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LowerRightfinger3 = hand2.addOrReplaceChild("LowerRightfinger3", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.0F, 0.0F, 3.0F, -0.0579F, 0.2555F, -0.2256F));

		PartDefinition cube_r144 = LowerRightfinger3.addOrReplaceChild("cube_r144", CubeListBuilder.create().texOffs(328, 272).addBox(7.5752F, -12.0982F, -0.25F, 4.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 0.0F, -2.5F, 0.1288F, -0.2476F, -2.7405F));

		PartDefinition cube_r145 = LowerRightfinger3.addOrReplaceChild("cube_r145", CubeListBuilder.create().texOffs(356, 259).addBox(-12.0F, -1.0F, -1.0F, 12.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.25F, 0.0F, -2.5F, -0.2214F, 0.1704F, -0.0381F));

		PartDefinition Infectedarm219 = LowerRightfinger3.addOrReplaceChild("Infectedarm219", CubeListBuilder.create().texOffs(145, 152).mirror().addBox(-2.0F, -2.3F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-12.1981F, 2.1726F, 1.572F, 2.1818F, 0.0758F, -1.3059F));

		PartDefinition Infectedarm220 = Infectedarm219.addOrReplaceChild("Infectedarm220", CubeListBuilder.create().texOffs(141, 158).mirror().addBox(-2.5131F, -1.4219F, -1.8631F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm221 = Infectedarm220.addOrReplaceChild("Infectedarm221", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm_r4 = Infectedarm221.addOrReplaceChild("Infectedarm_r4", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.6594F, -0.0802F, 0.1369F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -1.1F, 1.6F, 0.4287F, -0.4011F, -0.1766F));

		PartDefinition Infectedarm222 = Infectedarm220.addOrReplaceChild("Infectedarm222", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.5953F, -0.9148F, 0.9807F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm223 = LowerRightfinger3.addOrReplaceChild("Infectedarm223", CubeListBuilder.create().texOffs(126, 157).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-9.5951F, -0.4173F, -7.6679F, -1.2987F, 0.1226F, 0.6206F));

		PartDefinition Infectedarm224 = Infectedarm223.addOrReplaceChild("Infectedarm224", CubeListBuilder.create().texOffs(112, 397).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition Infectedarm225 = LowerRightfinger3.addOrReplaceChild("Infectedarm225", CubeListBuilder.create().texOffs(127, 149).addBox(-2.5851F, 1.1079F, -3.2265F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 0.0F, 1.9013F, 0.6693F, 3.1032F));

		PartDefinition Infectedarm226 = Infectedarm225.addOrReplaceChild("Infectedarm226", CubeListBuilder.create().texOffs(127, 150).addBox(-2.5851F, 0.1188F, -4.167F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.5672F, 0.0F, 0.0F));

		PartDefinition LowerRightfinger2 = hand2.addOrReplaceChild("LowerRightfinger2", CubeListBuilder.create(), PartPose.offsetAndRotation(-17.0F, -2.0F, -1.0F, 0.0F, 0.0F, 0.3054F));

		PartDefinition cube_r146 = LowerRightfinger2.addOrReplaceChild("cube_r146", CubeListBuilder.create().texOffs(240, 294).addBox(-10.9379F, -4.9472F, -3.0F, 13.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.35F, 4.5F, 1.0F, 0.0F, 0.0F, -0.096F));

		PartDefinition Infectedarm230 = LowerRightfinger2.addOrReplaceChild("Infectedarm230", CubeListBuilder.create().texOffs(397, 261).mirror().addBox(-1.0F, -1.0F, -2.0F, 3.0F, 9.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(-12.0F, 6.0F, 0.0F, -2.4871F, 0.1309F, -2.3562F));

		PartDefinition Infectedarm_r5 = Infectedarm230.addOrReplaceChild("Infectedarm_r5", CubeListBuilder.create().texOffs(255, 125).mirror().addBox(-1.0132F, -0.4146F, -1.0916F, 2.0F, 15.0F, 2.0F, new CubeDeformation(0.1F)).mirror(false)
				.texOffs(165, 227).mirror().addBox(-1.4868F, -14.5854F, -1.4084F, 3.0F, 15.0F, 3.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(4.5986F, 11.2658F, -1.3036F, -0.218F, 0.0094F, -0.3501F));

		PartDefinition Infectedarm93 = Infectedarm230.addOrReplaceChild("Infectedarm93", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r6 = Infectedarm93.addOrReplaceChild("Infectedarm_r6", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-5.7183F, -3.9209F, 0.5211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1216F, 0.1353F, 0.321F));

		PartDefinition Infectedarm94 = Infectedarm230.addOrReplaceChild("Infectedarm94", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r7 = Infectedarm94.addOrReplaceChild("Infectedarm_r7", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-1.9683F, -0.4209F, 1.0211F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0028F, 0.0693F, -0.1829F));

		PartDefinition Infectedarm92 = Infectedarm230.addOrReplaceChild("Infectedarm92", CubeListBuilder.create(), PartPose.offset(8.9671F, 23.5851F, -4.7922F));

		PartDefinition Infectedarm_r8 = Infectedarm92.addOrReplaceChild("Infectedarm_r8", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.9683F, -2.4209F, -0.9789F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4601F, 0.0971F, 0.033F));

		PartDefinition Infectedarm231 = Infectedarm230.addOrReplaceChild("Infectedarm231", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm_r9 = Infectedarm231.addOrReplaceChild("Infectedarm_r9", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.8F, 0.0873F, 0.0F, 0.0F));

		PartDefinition Infectedarm232 = Infectedarm230.addOrReplaceChild("Infectedarm232", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm_r10 = Infectedarm232.addOrReplaceChild("Infectedarm_r10", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.9F, -0.0873F, 0.0F, 0.0F));

		PartDefinition LowerRightfinger = hand2.addOrReplaceChild("LowerRightfinger", CubeListBuilder.create().texOffs(340, 161).addBox(-17.0F, -1.0F, -1.0F, 18.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-14.0F, 0.0F, -4.0F, -0.0905F, -0.6505F, 0.7441F));

		PartDefinition Infectedarm233 = LowerRightfinger.addOrReplaceChild("Infectedarm233", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 10.75F, -5.0F, -2.6293F, 0.6804F, -2.331F));

		PartDefinition Infectedarm234 = Infectedarm233.addOrReplaceChild("Infectedarm234", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm235 = Infectedarm234.addOrReplaceChild("Infectedarm235", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm236 = Infectedarm234.addOrReplaceChild("Infectedarm236", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition Infectedarm237 = LowerRightfinger.addOrReplaceChild("Infectedarm237", CubeListBuilder.create().texOffs(410, 301).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-16.0F, 1.0F, 0.0F, 3.1416F, 0.0F, -1.3526F));

		PartDefinition Infectedarm238 = Infectedarm237.addOrReplaceChild("Infectedarm238", CubeListBuilder.create().texOffs(96, 397).mirror().addBox(-2.0F, -1.0F, -2.0F, 4.0F, 9.0F, 4.0F, new CubeDeformation(0.1F)).mirror(false), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition Infectedarm239 = Infectedarm238.addOrReplaceChild("Infectedarm239", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-2.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition Infectedarm240 = Infectedarm238.addOrReplaceChild("Infectedarm240", CubeListBuilder.create().texOffs(382, 412).mirror().addBox(-3.0F, 0.0F, 0.0F, 4.0F, 12.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, 8.0F, -2.0F, -0.1278F, 0.0283F, 0.2164F));

		PartDefinition bodies = Upperbody.addOrReplaceChild("bodies", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Infectedbody56 = bodies.addOrReplaceChild("Infectedbody56", CubeListBuilder.create().texOffs(388, 327).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
				.texOffs(374, 92).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-22.0F, -30.0F, -3.0F, 2.8131F, -1.0175F, -1.51F));

		PartDefinition Infectedbody_r78 = Infectedbody56.addOrReplaceChild("Infectedbody_r78", CubeListBuilder.create().texOffs(396, 140).addBox(-2.0F, -1.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, -0.6027F, -0.2133F, 0.4608F));

		PartDefinition Infectedbody_r79 = Infectedbody56.addOrReplaceChild("Infectedbody_r79", CubeListBuilder.create().texOffs(370, 384).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, -0.7016F, 0.2878F, -0.7257F));

		PartDefinition Infectedbody_r80 = Infectedbody56.addOrReplaceChild("Infectedbody_r80", CubeListBuilder.create().texOffs(354, 384).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.2042F, 0.3378F, 0.5585F));

		PartDefinition Infectedbody_r81 = Infectedbody56.addOrReplaceChild("Infectedbody_r81", CubeListBuilder.create().texOffs(28, 342).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -0.6572F, 0.5484F, 0.5942F));

		PartDefinition Infectedbody57 = bodies.addOrReplaceChild("Infectedbody57", CubeListBuilder.create().texOffs(374, 129).addBox(-4.0F, -12.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-7.0F, -8.0F, 17.0F, 0.288F, -0.103F, 0.3341F));

		PartDefinition Infectedbody_r82 = Infectedbody57.addOrReplaceChild("Infectedbody_r82", CubeListBuilder.create().texOffs(180, 386).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, -11.0F, 0.0F, -0.1745F, 0.0F, 0.7854F));

		PartDefinition Infectedbody_r83 = Infectedbody57.addOrReplaceChild("Infectedbody_r83", CubeListBuilder.create().texOffs(220, 385).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -1.3526F, 0.0F, -0.3927F));

		PartDefinition Infectedbody_r84 = Infectedbody57.addOrReplaceChild("Infectedbody_r84", CubeListBuilder.create().texOffs(342, 92).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.3054F, 0.0F, -0.4363F));

		PartDefinition Infectedbody_r85 = Infectedbody57.addOrReplaceChild("Infectedbody_r85", CubeListBuilder.create().texOffs(388, 336).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));

		PartDefinition bone20 = Infectedbody57.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(88, 300).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(332, 92).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(390, 27).addBox(0.0F, -18.0F, -2.5F, 0.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(292, 411).addBox(-2.5F, -18.0F, 0.0F, 5.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, -17.0F, 1.0F, -0.2618F, 0.0F, -0.3054F));

		PartDefinition Infectedbody55 = bodies.addOrReplaceChild("Infectedbody55", CubeListBuilder.create().texOffs(388, 318).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-22.0F, -25.0F, 9.0F));

		PartDefinition Infectedbody_r86 = Infectedbody55.addOrReplaceChild("Infectedbody_r86", CubeListBuilder.create().texOffs(16, 383).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -4.0F, 0.0F, 0.1309F, 0.0F, -0.6981F));

		PartDefinition Infectedbody_r87 = Infectedbody55.addOrReplaceChild("Infectedbody_r87", CubeListBuilder.create().texOffs(0, 383).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.3054F));

		PartDefinition Infectedbody_r88 = Infectedbody55.addOrReplaceChild("Infectedbody_r88", CubeListBuilder.create().texOffs(340, 145).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -7.0F, -10.0F, -0.0547F, 0.3006F, -0.1828F));

		PartDefinition Infectedbody_r89 = Infectedbody55.addOrReplaceChild("Infectedbody_r89", CubeListBuilder.create().texOffs(372, 275).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, 1.1345F, 0.0F, 0.0F));

		PartDefinition Infectedbody58 = bodies.addOrReplaceChild("Infectedbody58", CubeListBuilder.create(), PartPose.offsetAndRotation(-29.0F, -9.0F, 0.0F, -1.2765F, -1.0288F, -2.9701F));

		PartDefinition Infectedbody59 = Infectedbody58.addOrReplaceChild("Infectedbody59", CubeListBuilder.create().texOffs(220, 374).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -5.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

		PartDefinition Infectedbody60 = Infectedbody59.addOrReplaceChild("Infectedbody60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, -0.2527F, 0.0175F, -0.2751F));

		PartDefinition Infectedbody_r90 = Infectedbody60.addOrReplaceChild("Infectedbody_r90", CubeListBuilder.create().texOffs(342, 129).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 1.2654F, 0.0F, 0.0F));

		PartDefinition Infectedbody100 = bodies.addOrReplaceChild("Infectedbody100", CubeListBuilder.create(), PartPose.offsetAndRotation(16.0F, -6.0F, 20.0F, -0.4085F, 0.1167F, -0.3534F));

		PartDefinition Infectedbody_r91 = Infectedbody100.addOrReplaceChild("Infectedbody_r91", CubeListBuilder.create().texOffs(398, 400).addBox(-5.0309F, -3.2655F, -2.1594F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4085F, -10.1324F, -2.6222F, -1.2409F, 0.4253F, 0.2004F));

		PartDefinition Infectedbody_r92 = Infectedbody100.addOrReplaceChild("Infectedbody_r92", CubeListBuilder.create().texOffs(402, 47).addBox(6.9938F, 0.3889F, -1.8328F, 3.0F, 9.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4085F, -10.1324F, -2.6222F, -0.2423F, -0.0241F, -0.1275F));

		PartDefinition Infectedbody_r93 = Infectedbody100.addOrReplaceChild("Infectedbody_r93", CubeListBuilder.create().texOffs(396, 257).addBox(-1.0F, 0.0F, -2.0F, 3.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, -0.7418F, 0.0F, 0.0F));

		PartDefinition Infectedbody_r94 = Infectedbody100.addOrReplaceChild("Infectedbody_r94", CubeListBuilder.create().texOffs(382, 400).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -1.2217F, 0.0F, 0.7854F));

		PartDefinition Infectedbody_r95 = Infectedbody100.addOrReplaceChild("Infectedbody_r95", CubeListBuilder.create().texOffs(228, 347).addBox(-1.9857F, -5.4778F, -1.6029F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4085F, -10.1324F, -2.6222F, 1.3176F, 0.462F, 0.0432F));

		PartDefinition Infectedbody_r96 = Infectedbody100.addOrReplaceChild("Infectedbody_r96", CubeListBuilder.create().texOffs(378, 103).addBox(-2.3779F, -2.1318F, 0.6222F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.4085F, -10.1324F, -2.6222F, 0.0826F, 0.251F, 0.2771F));

		PartDefinition Infectedbody_r97 = Infectedbody100.addOrReplaceChild("Infectedbody_r97", CubeListBuilder.create().texOffs(388, 308).addBox(-3.5F, -6.0F, -2.0F, 7.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2597F, 0.0338F, -0.1265F));

		PartDefinition Infectedbody62 = bodies.addOrReplaceChild("Infectedbody62", CubeListBuilder.create(), PartPose.offsetAndRotation(20.0F, 2.0F, 3.0F, -1.8593F, -1.2788F, 2.671F));

		PartDefinition Infectedbody_r98 = Infectedbody62.addOrReplaceChild("Infectedbody_r98", CubeListBuilder.create().texOffs(400, 361).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(5.0F, -11.0F, 0.0F, 0.9163F, 0.0F, -1.0472F));

		PartDefinition Infectedbody_r99 = Infectedbody62.addOrReplaceChild("Infectedbody_r99", CubeListBuilder.create().texOffs(354, 400).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -11.0F, 0.0F, 0.8806F, -0.3563F, 0.464F));

		PartDefinition Infectedbody_r100 = Infectedbody62.addOrReplaceChild("Infectedbody_r100", CubeListBuilder.create().texOffs(386, 384).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.8214F, 0.1284F, -0.1186F));

		PartDefinition Infectedbody_r101 = Infectedbody62.addOrReplaceChild("Infectedbody_r101", CubeListBuilder.create().texOffs(344, 72).addBox(-4.0F, -7.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -13.0F, 0.0F, -0.7245F, 0.1758F, 0.5005F));

		PartDefinition Infectedbody_r102 = Infectedbody62.addOrReplaceChild("Infectedbody_r102", CubeListBuilder.create().texOffs(180, 375).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.2182F, 0.0F, -0.0873F));

		PartDefinition Infectedbody_r103 = Infectedbody62.addOrReplaceChild("Infectedbody_r103", CubeListBuilder.create().texOffs(284, 380).addBox(-3.5F, -7.0F, -2.0F, 7.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3515F, -0.0393F, 0.1249F));

		PartDefinition Infectedbody63 = bodies.addOrReplaceChild("Infectedbody63", CubeListBuilder.create(), PartPose.offset(20.0F, -12.0F, -7.0F));

		PartDefinition Infectedbody_r104 = Infectedbody63.addOrReplaceChild("Infectedbody_r104", CubeListBuilder.create().texOffs(92, 410).addBox(-2.0F, 0.0F, -2.0F, 3.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, -12.0F, 0.0F, 0.3104F, -0.3526F, -0.1568F));

		PartDefinition Infectedbody_r105 = Infectedbody63.addOrReplaceChild("Infectedbody_r105", CubeListBuilder.create().texOffs(220, 363).addBox(-4.0F, -5.0F, -2.0F, 8.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -12.0F, 0.0F, 0.5305F, -0.3408F, 0.1556F));

		PartDefinition Infectedbody_r106 = Infectedbody63.addOrReplaceChild("Infectedbody_r106", CubeListBuilder.create().texOffs(103, 281).addBox(-1.0F, 5.0F, -4.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.9F, -16.0F, -6.0F, -0.3474F, -0.0435F, 0.1234F));

		PartDefinition Infectedbody_r107 = Infectedbody63.addOrReplaceChild("Infectedbody_r107", CubeListBuilder.create().texOffs(100, 278).addBox(-1.0F, 5.0F, -7.0F, 1.0F, 1.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, -0.2161F, -0.6543F, 0.1223F));

		PartDefinition Infectedbody_r108 = Infectedbody63.addOrReplaceChild("Infectedbody_r108", CubeListBuilder.create().texOffs(100, 278).addBox(-1.0F, 5.0F, -7.0F, 2.0F, 1.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(100, 278).addBox(-4.0F, 4.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -16.0F, 0.0F, 0.0016F, -0.0435F, 0.1234F));

		PartDefinition Infectedbody_r109 = Infectedbody63.addOrReplaceChild("Infectedbody_r109", CubeListBuilder.create().texOffs(258, 389).addBox(-3.5F, -5.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, -0.211F, -0.056F, -0.2559F));

		PartDefinition details = Upperbody.addOrReplaceChild("details", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Root2 = details.addOrReplaceChild("Root2", CubeListBuilder.create().texOffs(192, 348).addBox(-12.0F, -3.0F, -3.0F, 12.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-27.6297F, -23.4056F, 7.0F, -0.436F, 0.7413F, -0.9668F));

		PartDefinition R3Seg10 = Root2.addOrReplaceChild("R3Seg10", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7418F));

		PartDefinition RootSeg_r7 = R3Seg10.addOrReplaceChild("RootSeg_r7", CubeListBuilder.create().texOffs(348, 321).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-6.0F, 0.0F, 0.0F, 0.0F, -3.1416F, 0.0F));

		PartDefinition R3Seg11 = R3Seg10.addOrReplaceChild("R3Seg11", CubeListBuilder.create().texOffs(344, 88).addBox(-14.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6109F));

		PartDefinition R3Seg12 = R3Seg11.addOrReplaceChild("R3Seg12", CubeListBuilder.create().texOffs(0, 256).addBox(-14.0F, 0.0F, -1.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-14.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.7854F));

		PartDefinition spike2 = details.addOrReplaceChild("spike2", CubeListBuilder.create(), PartPose.offsetAndRotation(14.0F, -16.0F, 19.0F, -1.2774F, -0.4623F, -0.1339F));

		PartDefinition cube_r147 = spike2.addOrReplaceChild("cube_r147", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0083F, 0.8236F, 0.3002F));

		PartDefinition cube_r148 = spike2.addOrReplaceChild("cube_r148", CubeListBuilder.create().texOffs(164, 326).addBox(-1.0019F, -8.3787F, -6.166F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3432F, -3.6213F, 0.0737F, 0.0077F, -0.7472F, 0.2889F));

		PartDefinition cube_r149 = spike2.addOrReplaceChild("cube_r149", CubeListBuilder.create().texOffs(252, 256).addBox(-9.3432F, 3.3738F, -14.6823F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3432F, -3.6213F, 0.0737F, -0.387F, 0.0382F, 0.2943F));

		PartDefinition cube_r150 = spike2.addOrReplaceChild("cube_r150", CubeListBuilder.create().texOffs(188, 256).addBox(-9.3432F, 3.3174F, -1.4539F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3432F, -3.6213F, 0.0737F, 0.3984F, 0.0382F, 0.2943F));

		PartDefinition cube_r151 = spike2.addOrReplaceChild("cube_r151", CubeListBuilder.create().texOffs(124, 246).addBox(-2.6268F, 2.8316F, -8.0737F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3432F, -3.6213F, 0.0737F, -0.0094F, 0.0374F, -0.0987F));

		PartDefinition cube_r152 = spike2.addOrReplaceChild("cube_r152", CubeListBuilder.create().texOffs(226, 206).addBox(-15.8552F, 3.8597F, -8.0737F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.3432F, -3.6213F, 0.0737F, 0.0198F, 0.0331F, 0.6872F));

		PartDefinition spike = details.addOrReplaceChild("spike", CubeListBuilder.create().texOffs(390, 48).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(50, 274).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(88, 306).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 366).addBox(0.0F, -16.0F, -3.5F, 0.0F, 16.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(396, 292).addBox(-3.5F, -16.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -12.0F, 13.0F));

		PartDefinition bone57 = spike.addOrReplaceChild("bone57", CubeListBuilder.create().texOffs(390, 48).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(344, 208).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 363).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 366).addBox(0.0F, -16.0F, -3.5F, 0.0F, 16.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(396, 292).addBox(-3.5F, -16.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition bone58 = bone57.addOrReplaceChild("bone58", CubeListBuilder.create().texOffs(88, 300).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(144, 370).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(390, 27).addBox(0.0F, -18.0F, -2.5F, 0.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(292, 411).addBox(-2.5F, -18.0F, 0.0F, 5.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition R3Seg7 = details.addOrReplaceChild("R3Seg7", CubeListBuilder.create(), PartPose.offsetAndRotation(19.0419F, -1.0F, -5.9089F, 0.4066F, 0.4295F, 0.7785F));

		PartDefinition RootSeg_r8 = R3Seg7.addOrReplaceChild("RootSeg_r8", CubeListBuilder.create().texOffs(266, 245).addBox(-8.0F, -2.0F, -2.0F, 16.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

		PartDefinition R3Seg8 = R3Seg7.addOrReplaceChild("R3Seg8", CubeListBuilder.create().texOffs(296, 92).addBox(-2.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7418F));

		PartDefinition R3Seg9 = R3Seg8.addOrReplaceChild("R3Seg9", CubeListBuilder.create().texOffs(296, 167).addBox(-1.0F, 0.0F, -1.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(14.0F, -0.5F, 0.5F, 0.0F, 0.0F, -0.3491F));

		PartDefinition shroom = details.addOrReplaceChild("shroom", CubeListBuilder.create(), PartPose.offset(9.0F, -32.0F, 0.0F));

		PartDefinition cube_r153 = shroom.addOrReplaceChild("cube_r153", CubeListBuilder.create().texOffs(164, 326).addBox(-11.25F, -12.0F, -7.0F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition cube_r154 = shroom.addOrReplaceChild("cube_r154", CubeListBuilder.create().texOffs(164, 326).addBox(0.0F, -12.0F, 4.25F, 0.0F, 12.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, -0.7854F, 0.0F));

		PartDefinition cube_r155 = shroom.addOrReplaceChild("cube_r155", CubeListBuilder.create().texOffs(264, 0).addBox(-16.0F, 0.0F, -16.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r156 = shroom.addOrReplaceChild("cube_r156", CubeListBuilder.create().texOffs(188, 256).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(8.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));

		PartDefinition cube_r157 = shroom.addOrReplaceChild("cube_r157", CubeListBuilder.create().texOffs(124, 246).addBox(0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition cube_r158 = shroom.addOrReplaceChild("cube_r158", CubeListBuilder.create().texOffs(226, 206).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition Tumor = shroom.addOrReplaceChild("Tumor", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r159 = Tumor.addOrReplaceChild("cube_r159", CubeListBuilder.create().texOffs(128, 262).addBox(-7.2F, -0.2F, -8.2F, 13.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.8F, -3.2F, 3.6F, 0.0812F, 0.1546F, 0.4863F));

		PartDefinition shroom3 = details.addOrReplaceChild("shroom3", CubeListBuilder.create().texOffs(390, 48).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(50, 274).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(88, 306).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 366).addBox(0.0F, -16.0F, -3.5F, 0.0F, 16.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(396, 292).addBox(-3.5F, -16.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(14.0F, -16.0F, 18.0F));

		PartDefinition bone29 = shroom3.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(390, 48).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 16.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(344, 208).addBox(-1.5F, -16.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 363).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 0.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(248, 366).addBox(0.0F, -16.0F, -3.5F, 0.0F, 16.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(396, 292).addBox(-3.5F, -16.0F, 0.0F, 7.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		PartDefinition bone30 = bone29.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(88, 300).addBox(-1.5F, -3.0F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(144, 370).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(390, 27).addBox(0.0F, -18.0F, -2.5F, 0.0F, 16.0F, 5.0F, new CubeDeformation(0.0F))
				.texOffs(292, 411).addBox(-2.5F, -18.0F, 0.0F, 5.0F, 16.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -16.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}
	public void animateSpecialTumor(float value){
		BladeArmTumor.zScale = 1 + value;
		BladeArmTumor.yScale = 1 + value;
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		Evilshoulder.visible = entity.getSwordArmHp() > 0;
        float tendril1Val = Mth.cos(ageInTicks/7)/6;
        float tendril2Val = Mth.sin(ageInTicks/5)/6;
        float tendril3Val = -Mth.cos(ageInTicks/5)/6;
        float tendril4Val = Mth.sin(ageInTicks/5)/5;
        float tendril5Val = Mth.cos(ageInTicks/7)/4;
        float tendril6Val = Mth.sin(ageInTicks/6)/5;
        float tendril7Val = Mth.cos(ageInTicks/6)/2;
        float mawValue = Mth.sin(ageInTicks/6)/8;
        float shoulderIdleVal = Mth.cos(ageInTicks/8)/9;
        float shoulderIdleVal1 = Mth.sin(ageInTicks/8)/7;
        float shoulderIdleVal2 = Mth.cos(ageInTicks/7)/8;
        this.root().getAllParts().forEach(ModelPart::resetPose);
		boolean attacking = entity.animationState.isStarted();
		animateTentacleX(Leftleg, Mth.cos(limbSwing * 0.5F) * 0.4F * limbSwingAmount);
		animateTentacleX(Rightleg,Mth.cos(limbSwing * 0.5F) * 0.4F * -limbSwingAmount);
		animateTentacleX(LeftForLeg,this.Leftleg.xRot < 0 ? -this.Leftleg.xRot * 1.25f : 0);
		animateTentacleX(RightForLeg,this.Rightleg.xRot < 0 ? -this.Rightleg.xRot * 1.25f : 0);
		if (entity.getMeleeState() == Stahlmorder.MELEE_STATES.SLASH){
			this.animate(entity.animationState, StahlmorderModelAnimation.slash,ageInTicks,1.5F);
		}else if (entity.getMeleeState() == Stahlmorder.MELEE_STATES.SLAP){
			this.animate(entity.animationState, StahlmorderModelAnimation.slap,ageInTicks,1.25F);
		}else {
			this.animate(entity.animationState, StahlmorderModelAnimation.kick,ageInTicks,1.5F);
		}
        animateTumor(AssTumor,Mth.cos(ageInTicks/8)/7);
        animateTumor(leftLegTumor,Mth.sin(ageInTicks/6)/6);
        animateTumor(rightLegTumor,-Mth.sin(ageInTicks/7)/5);
        animateTumor(bloom,Mth.sin(ageInTicks/5)/7);
        animateTentacleY(Tendril2,tendril1Val);
        animateTentacleY(Seg2Tendril2,tendril1Val);
        animateTentacleY(Seg3Tendril2,tendril1Val);
        animateTentacleY(Seg4Tendril2,tendril1Val);
        animateSpecialTumor(Mth.sin(ageInTicks/7)/8);
        animateTentacleY(R3Seg1,tendril2Val);
        animateTentacleY(R3Seg2,tendril2Val);
        animateTentacleY(R3Seg3,tendril2Val);
        animateTentacleZ(R3Seg13,tendril3Val);
        animateTentacleZ(R3Seg14,tendril3Val);
        animateTentacleZ(R3Seg15,tendril3Val);
        animateTentacleX(Root5,tendril4Val);
        animateTentacleX(R3Seg16,tendril4Val);
        animateTentacleX(R3Seg17,tendril4Val);
        animateTentacleY(Root2,tendril5Val);
        animateTentacleY(R3Seg10,tendril5Val);
        animateTentacleY(R3Seg11,tendril5Val);
        animateTentacleZ(R3Seg7,tendril6Val);
        animateTentacleZ(R3Seg8,tendril6Val);
        animateTentacleZ(R3Seg9,tendril6Val);
        animateTentacleZ(Infectedarm219,tendril7Val);
        animateTentacleZ(Infectedarm31,tendril4Val);
        animateTentacleZ(Infectedarm45,tendril5Val);
        animateTentacleX(Infectedarm25,tendril6Val);
        animateTentacleX(Infectedarm23,tendril6Val);
        animateTentacleX(Infectedarm27,tendril4Val);
        animateTentacleZ(Infectedarm87,tendril4Val);
        animateTentacleZ(Infectedarm201,tendril3Val);
        animateTentacleY(Infectedarm213,tendril3Val);
        animateTentacleX(Infectedarm197,tendril3Val);
        animateTentacleZ(Infectedarm205,tendril3Val);
		if (attacking){
			return;
		}
		animateTentacleY(Upperbody,headPitch /  ( 90F / (float) Math.PI));
		animateTentacleX(Upperjaw,mawValue);
		animateTentacleX(Lowerjaw,mawValue);
		animateTentacleZ(Evilshoulder,shoulderIdleVal);
		animateTentacleZ(Leftarmmain,shoulderIdleVal1);
		animateTentacleZ(Leftarm,-shoulderIdleVal2);
		animateTentacleZ(Lowersegleftarm,-shoulderIdleVal1);
		animateTentacleZ(Evilhand,-shoulderIdleVal/2);
        animateTentacleZ(UpperRightarm,shoulderIdleVal1);
        animateTentacleZ(LowersegRightarm,shoulderIdleVal);
        animateTentacleY(hand,tendril5Val);
        animateTentacleZ(UpperRightfinger,tendril5Val);
        animateTentacleZ(UpperRightfinger2,tendril5Val);
        animateTentacleZ(UpperRightfinger1,tendril5Val);
		animateTentacleY(LowerRightarm,shoulderIdleVal);
		animateTentacleZ(LowerRightarmLowerSegmentButFreakyToo,shoulderIdleVal);
		animateTentacleZ(LowerRightfinger2,tendril7Val);
		animateTentacleZ(LowerRightfinger,tendril7Val);
	}
	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,float r,float g,float b,float alpha) {
		panzer.render(poseStack, vertexConsumer, packedLight, packedOverlay,r,g,b, alpha);
	}

	@Override
	public ModelPart root() {
		return panzer;
	}
}