package com.Harbinger.Spore.Client;

import com.Harbinger.Spore.Client.Models.GazenbrecherModel;
import com.Harbinger.Spore.Client.Models.HindieModel;
import com.Harbinger.Spore.Client.Models.SiegerModel;
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
    public record Part(int id, List<ModelPart> parts,float x, float y,float z,float xRot, float yRot,float zRot, ResourceLocation location,ResourceLocation adapted_location){}

    public static final Part SIEGER_BODY = new Part(0,List.of(siegerModel.mainbody,siegerModel.mainbody2),0,0,0,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_JAW = new Part(1,List.of(siegerModel.jaw),-1f,-0.5f,0,-30,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_RIGHT_LEG = new Part(2,List.of(siegerModel.RightLegJointY),0,-0.5f,2f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_LEFT_LEG = new Part(3,List.of(siegerModel.LeftLegJointY),0,-0.5f,-2f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_BACK_RIGHT_LEG = new Part(4,List.of(siegerModel.BackRightLeg),4f,0,-1f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_BACK_LEFT_LEG = new Part(5,List.of(siegerModel.BackLeftLeg),4f,0,1f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_TAIL = new Part(6,List.of(siegerModel.tail),1.5f,-3f,0,-90,90,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));

    public static final Part GAZEN_TAIL = new Part(7,List.of(gazenModel.Segment4),2,0,1f,0,30,90,new ResourceLocation(Spore.MODID,"textures/entity/gazen.png"),new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png"));
    public static final Part GAZEN_HEAD = new Part(8,List.of(gazenModel.TopJaw,gazenModel.RightJaw,gazenModel.LeftJaw),1f,0.75f,0,-90,0,0,new ResourceLocation(Spore.MODID,"textures/entity/gazen.png"),new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png"));
    public static final Part GAZEN_RIGHT_LEG = new Part(9,List.of(gazenModel.RightLeg),0,0.25f,1.25f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/gazen.png"),new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png"));
    public static final Part GAZEN_LEFT_LEG = new Part(10,List.of(gazenModel.LeftLeg),0,0.75f,-1.25f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/gazen.png"),new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png"));
    public static final Part LICKER = new Part(11,List.of(gazenModel.Licker1),-1f,0,0,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/gazen.png"),new ResourceLocation(Spore.MODID,"textures/entity/burned_gazen.png"));

    public static final Part HINDEN_FRONT = new Part(12,List.of(hindieModel.FrontSection),-6f,-4f,0,45,0,0,new ResourceLocation(Spore.MODID,"textures/entity/hindie.png"),new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png"));
    public static final Part HINDEN_BACK = new Part(13,List.of(hindieModel.BackSectionSection),6f,-4f,0,-45,0,0,new ResourceLocation(Spore.MODID,"textures/entity/hindie.png"),new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png"));
    public static final Part MAW = new Part(14,List.of(hindieModel.Maw),0,-4,0,180,0,0,new ResourceLocation(Spore.MODID,"textures/entity/hindie.png"),new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png"));
    public static final Part RIGHT_CANNON = new Part(15,List.of(hindieModel.RightCannon),0,0,-1.5f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/hindie.png"),new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png"));
    public static final Part LEFT_CANNON = new Part(16,List.of(hindieModel.LeftCannon),0,0,1.5f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/hindie.png"),new ResourceLocation(Spore.MODID,"textures/entity/hindie_adapted.png"));


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
    }};
}
