package com.Harbinger.Spore.Sentities.AI.NeuralProcessing.ProtoAIs;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ProtoTargeting extends Goal {
    public Proto proto;
    public ProtoTargeting(Proto p){
        this.proto = p;
    }

    @Override
    public boolean canUse() {
        return proto.getTarget() != null  && this.proto.getRandom().nextInt(0,5) == 3;
    }

    @Override
    public boolean canContinueToUse() {
        return proto.getTarget() != null;
    }

    @Override
    public void start() {
        super.start();
        Targeting(proto);
    }

    public void Targeting(Entity entity){
        AABB boundingBox = entity.getBoundingBox().inflate(SConfig.SERVER.proto_range.get());
        List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity entity1 : entities) {
            if(entity1 instanceof Infected infected) {
                if (infected.getTarget() == null && this.proto.getTarget() != null && this.proto.getTarget().isAlive() && !this.proto.getTarget().isInvulnerable()){
                    infected.setTarget(proto.getTarget());
                }
            }
        }
    }
}