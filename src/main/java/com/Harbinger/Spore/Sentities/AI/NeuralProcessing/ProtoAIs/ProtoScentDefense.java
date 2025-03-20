package com.Harbinger.Spore.Sentities.AI.NeuralProcessing.ProtoAIs;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.Organoids.Proto;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class ProtoScentDefense extends Goal {
    public Proto proto;
    public ProtoScentDefense(Proto proto1){
        this.proto = proto1;
    }

    @Override
    public boolean canUse() {
        Entity target = this.proto.getTarget();
        return this.proto.tickCount % 40 == 0  && target != null && checkForScent() ;
    }

    private boolean checkForScent() {
        AABB hitbox = this.proto.getBoundingBox().inflate(3);
        List<ScentEntity> entities = this.proto.level().getEntitiesOfClass(ScentEntity.class, hitbox);
        return entities.isEmpty();
    }

    @Override
    public void start() {
        SummonScent();
        super.start();
    }

    private void SummonScent() {
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(), this.proto.level());
        scent.setOvercharged(true);
        scent.moveTo(this.proto.getX(),this.proto.getY(),this.proto.getZ());
        this.proto.level().addFreshEntity(scent);
    }
}