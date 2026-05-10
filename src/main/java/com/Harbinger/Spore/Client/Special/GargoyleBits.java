package com.Harbinger.Spore.Client.Special;

import net.minecraft.client.model.geom.ModelPart;

import java.util.List;

public interface GargoyleBits {
    List<ModelPart>  Helmet();
    List<ModelPart>  Armor();
    ModelPart root();

    default void setDraw(ModelPart part,boolean armor){
        if (Armor().contains(part)){
            part.skipDraw = !armor;
        }else{
            part.skipDraw = armor;
        }
    }
}
