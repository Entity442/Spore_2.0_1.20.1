package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.*;
import com.Harbinger.Spore.Spore;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class CalamityPartsHandeling {
    private static final SiegerModel<?> siegerModel = new SiegerModel<>();
    private static final GazenbrecherModel<?> gazenModel = new GazenbrecherModel<>();
    private static final HindieModel<?> hindieModel = new HindieModel<>();
    private static final HowitzerModel<?> howiModel = new HowitzerModel<>();
    private static final hohlfresserHeadModel<?> worm_headModel = new hohlfresserHeadModel<>();
    private static final HohlfresserSeg1Model<?> worm_seg1Model = new HohlfresserSeg1Model<>();
    private static final HohlfresserSeg2Model<?> worm_seg2Model = new HohlfresserSeg2Model<>();
    private static final HohlfresserSeg3Model<?> worm_seg3Model = new HohlfresserSeg3Model<>();
    private static final hohlfresserTailModel<?> worm_tailModel = new hohlfresserTailModel<>();
    private static final GrakensenkerModel<?> grakensenkerModel = new GrakensenkerModel<>();
    private static final ResourceLocation DEFAULT_SIEGER = new ResourceLocation(Spore.MODID,"textures/entity/sieger.png");
    private static final ResourceLocation ADAPTED_SIEGER = new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png");
    private static final ResourceLocation DEFAULT_GAZEN = new ResourceLocation(Spore.MODID,"textures/entity/gazen.png");
    private static final ResourceLocation ADAPTED_GAZEN = new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png");
    private static final ResourceLocation DEFAULT_HINDEN = new ResourceLocation(Spore.MODID,"textures/entity/hindie.png");
    private static final ResourceLocation ADAPTED_HINDEN = new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png");
    private static final ResourceLocation DEFAULT_HOWI = new ResourceLocation(Spore.MODID,"textures/entity/howitzer.png");
    private static final ResourceLocation ADAPTED_HOWI  = new ResourceLocation(Spore.MODID,"textures/entity/nuclear_howitzer.png");
    private static final ResourceLocation HOHLHEAD  = new ResourceLocation(Spore.MODID,"textures/entity/hohl_head.png");
    private static final ResourceLocation HOHL_SEG  = new ResourceLocation(Spore.MODID,"textures/entity/hohl/hohl_seg1.png");
    private static final ResourceLocation HOHL_SHARP_SEG  = new ResourceLocation(Spore.MODID,"textures/entity/hohl/hohl_seg2.png");
    private static final ResourceLocation HOHL_ORGAN_SEG  = new ResourceLocation(Spore.MODID,"textures/entity/hohl/hohl_seg3.png");
    private static final ResourceLocation GRAKEN  = new ResourceLocation(Spore.MODID,"textures/entity/graken.png");
    public record Part(int id, List<ModelPart> parts,float x, float y,float z,float xRot, float yRot,float zRot, ResourceLocation location,ResourceLocation adapted_location){}

    public static final Part SIEGER_BODY = new Part(0,List.of(siegerModel.mainbody,siegerModel.mainbody2),0,0,0,0,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_JAW = new Part(1,List.of(siegerModel.jaw),-1f,-0.5f,0,-30,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_RIGHT_LEG = new Part(2,List.of(siegerModel.RightLegJointY),0,-0.5f,2f,0,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_LEFT_LEG = new Part(3,List.of(siegerModel.LeftLegJointY),0,-0.5f,-2f,0,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_BACK_RIGHT_LEG = new Part(4,List.of(siegerModel.BackRightLeg),4f,0,-1f,0,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_BACK_LEFT_LEG = new Part(5,List.of(siegerModel.BackLeftLeg),4f,0,1f,0,0,0,DEFAULT_SIEGER,ADAPTED_SIEGER);
    public static final Part SIEGER_TAIL = new Part(6,List.of(siegerModel.tail),1.5f,-3f,0,-90,90,0,DEFAULT_SIEGER,ADAPTED_SIEGER);

    public static final Part GAZEN_TAIL = new Part(7,List.of(gazenModel.Segment4),2,0,1f,0,30,90,DEFAULT_GAZEN,ADAPTED_GAZEN);
    public static final Part GAZEN_HEAD = new Part(8,List.of(gazenModel.TopJaw,gazenModel.RightJaw,gazenModel.LeftJaw),1f,0.75f,0,-90,0,0,DEFAULT_GAZEN,ADAPTED_GAZEN);
    public static final Part GAZEN_RIGHT_LEG = new Part(9,List.of(gazenModel.RightLeg),0,0.25f,1.25f,0,0,0,DEFAULT_GAZEN,ADAPTED_GAZEN);
    public static final Part GAZEN_LEFT_LEG = new Part(10,List.of(gazenModel.LeftLeg),0,0.75f,-1.25f,0,0,0,DEFAULT_GAZEN,ADAPTED_GAZEN);
    public static final Part LICKER = new Part(11,List.of(gazenModel.Licker1),-1f,0,0,0,0,0,DEFAULT_GAZEN,ADAPTED_GAZEN);

    public static final Part HINDEN_FRONT = new Part(12,List.of(hindieModel.FrontSection),-3.5f,-4f,0,-45,0,0,DEFAULT_HINDEN,ADAPTED_HINDEN);
    public static final Part HINDEN_BACK = new Part(13,List.of(hindieModel.BackSectionSection),3.5f,-4f,0,45,0,0,DEFAULT_HINDEN,ADAPTED_HINDEN);
    public static final Part MAW = new Part(14,List.of(hindieModel.Maw),0,-4,0,180,0,0,DEFAULT_HINDEN,ADAPTED_HINDEN);
    public static final Part RIGHT_CANNON = new Part(15,List.of(hindieModel.RightCannon),0.3f,0,0f,0,0,0,DEFAULT_HINDEN,ADAPTED_HINDEN);
    public static final Part LEFT_CANNON = new Part(16,List.of(hindieModel.LeftCannon),0.3f,0,6f,0,0,0,DEFAULT_HINDEN,ADAPTED_HINDEN);

    public static final Part HOWI_CANNON1 = new Part(17,List.of(howiModel.CononCluster1),1.5f,0.8f,-1f,0,0,0,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_CANNON2 = new Part(18,List.of(howiModel.CononCluster2),0.75f,0.5f,1.75f,0,0,0,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_CANNON3 = new Part(19,List.of(howiModel.CononCluster3),-1.75f,1,-1,0,0,0,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_LEFT_LEG = new Part(20,List.of(howiModel.LeftLeg),0,1,1.5f,90,0,90,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_RIGHT_LEG = new Part(21,List.of(howiModel.RightLeg),0.5f,-0.5f,-2.5f,90,0,90,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_LEFT_ARM = new Part(22,List.of(howiModel.LeftArm),-3.5f,0,3.5f,0,0,90,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_RIGHT_ARM = new Part(23,List.of(howiModel.RightArm),3.5f,0,-2f,0,0,90,DEFAULT_HOWI,ADAPTED_HOWI);
    public static final Part HOWI_SACK = new Part(24,List.of(howiModel.Tumor7),0,0,0,0,0,0,DEFAULT_HOWI,ADAPTED_HOWI);

    public static final Part HOHL_JAW = new Part(25,List.of(worm_headModel.TrueHead),-3.5f,0,0,-90,0,0,HOHLHEAD,HOHLHEAD);
    public static final Part HOHL_HEAD = new Part(26,List.of(worm_headModel.Middle),2.25f,0,0,-90,0,0,HOHLHEAD,HOHLHEAD);
    public static final Part HOHL_SEG1 = new Part(27,List.of(worm_seg1Model.hohl_seg),0,0.5f,0,0,0,0,HOHL_SEG,HOHL_SEG);
    public static final Part HOHL_SEG2 = new Part(28,List.of(worm_seg2Model.hohl_seg),0,0.5f,0,0,0,0,HOHL_SHARP_SEG,HOHL_SHARP_SEG);
    public static final Part HOHL_SEG3 = new Part(29,List.of(worm_seg3Model.hohl_seg),0,0.5f,0,0,0,0,HOHL_ORGAN_SEG,HOHL_ORGAN_SEG);
    public static final Part HOHL_TAIL = new Part(30,List.of(worm_tailModel.tail),0,0,0.5f,0,0,0,HOHL_SEG,HOHL_SEG);

    public static final Part GRAKEN_BODY = new Part(31,List.of(grakensenkerModel.body2,grakensenkerModel.FrontSeg2CorpseDetails,grakensenkerModel.CenterCorpseDetails6,grakensenkerModel.CenterCorpseDetails3),3,2f,1.5f,0,0,0,GRAKEN,GRAKEN);
    public static final Part GRAKEN_BACK_MAW = new Part(32,List.of(grakensenkerModel.head),-1.5f,-2.5f,0,0,0,0,GRAKEN,GRAKEN);
    public static final Part GRAKEN_FRONT_MAW = new Part(33,List.of(grakensenkerModel.FrontJaw),-1,0,0,0,0,0,GRAKEN,GRAKEN);
    public static final Part GRAKEN_HINGE = new Part(34,List.of(grakensenkerModel.BackBodyMouthProtection),6,-6,0,0,0,0,GRAKEN,GRAKEN);
    public static Part getPart(int value){
        return getParts.stream().filter(p -> p.id == value).findFirst().orElse(SIEGER_BODY);
    }

    public static final List<Part> getParts = new ArrayList<>(){{
        add(SIEGER_BODY);
        add(SIEGER_JAW);
        add(SIEGER_RIGHT_LEG);
        add(SIEGER_LEFT_LEG);
        add(SIEGER_BACK_RIGHT_LEG);
        add(SIEGER_BACK_LEFT_LEG);
        add(SIEGER_TAIL);

        add(GAZEN_TAIL);
        add(GAZEN_HEAD);
        add(GAZEN_RIGHT_LEG);
        add(GAZEN_LEFT_LEG);
        add(LICKER);

        add(HINDEN_FRONT);
        add(HINDEN_BACK);
        add(MAW);
        add(RIGHT_CANNON);
        add(LEFT_CANNON);

        add(HOWI_CANNON1);
        add(HOWI_CANNON2);
        add(HOWI_CANNON3);
        add(HOWI_LEFT_LEG);
        add(HOWI_RIGHT_LEG);
        add(HOWI_LEFT_ARM);
        add(HOWI_RIGHT_ARM);
        add(HOWI_SACK);

        add(HOHL_JAW);
        add(HOHL_HEAD);
        add(HOHL_SEG1);
        add(HOHL_SEG2);
        add(HOHL_SEG3);
        add(HOHL_TAIL);

        add(GRAKEN_BODY);
        add(GRAKEN_BACK_MAW);
        add(GRAKEN_FRONT_MAW);
        add(GRAKEN_HINGE);
    }};
}
