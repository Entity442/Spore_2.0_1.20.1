package com.Harbinger.Spore.Client;

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
    public record Part(int id, List<ModelPart> parts,float x, float y,float z,float xRot, float yRot,float zRot, ResourceLocation location,ResourceLocation adapted_location){}

    public static final Part SIEGER_BODY = new Part(0,List.of(siegerModel.mainbody,siegerModel.mainbody2),0,0,0,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_JAW = new Part(1,List.of(siegerModel.jaw),-1f,-0.5f,0,-30,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_RIGHT_LEG = new Part(2,List.of(siegerModel.RightLegJointY),0,-0.5f,2f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_LEFT_LEG = new Part(3,List.of(siegerModel.LeftLegJointY),0,-0.5f,-2f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
   public static final Part SIEGER_BACK_RIGHT_LEG = new Part(4,List.of(siegerModel.BackRightLeg),4f,0,-1f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_BACK_LEFT_LEG = new Part(5,List.of(siegerModel.BackLeftLeg),4f,0,1f,0,0,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));
    public static final Part SIEGER_TAIL = new Part(6,List.of(siegerModel.tail),1.5f,-3f,0,-90,90,0,new ResourceLocation(Spore.MODID,"textures/entity/sieger.png"),new ResourceLocation(Spore.MODID,"textures/entity/war_sieger.png"));




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

    }};
}
