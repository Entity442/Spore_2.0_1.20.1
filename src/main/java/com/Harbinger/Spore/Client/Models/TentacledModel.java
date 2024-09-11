package com.Harbinger.Spore.Client.Models;

import net.minecraft.client.model.geom.ModelPart;

public interface TentacledModel {
    default void animateTentacleX(ModelPart part, float value){
        part.xRot = part.getInitialPose().xRot + value;
    }
    default void animateTentacleY(ModelPart part,float value){
        part.yRot = part.getInitialPose().yRot + value;
    }
    default void animateTentacleZ(ModelPart part,float value){
        part.zRot = part.getInitialPose().zRot + value;
    }
    default void animateTumor(ModelPart part,float value){
        part.xScale = 1 + value;
        part.yScale = 1 + value;
        part.zScale = 1 + value;
    }
}
