package com.Harbinger.Spore.Client.Models;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

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


    default void matchLegToTerrain(ModelPart bone, LivingEntity entity, float reachDistance) {
        Vec3 start = entity.position().add(0, entity.getBbHeight() * 0.5, 0);
        Vec3 end = start.subtract(0, reachDistance, 0);
        HitResult result = entity.level().clip(new ClipContext(start, end,
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity));

        if (result.getType() == HitResult.Type.BLOCK) {
            double distance = start.y - result.getLocation().y;
            bone.y =((float) -distance);
        }
    }
}
