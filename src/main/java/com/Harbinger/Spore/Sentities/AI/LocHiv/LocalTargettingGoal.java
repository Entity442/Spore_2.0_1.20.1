package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class LocalTargettingGoal extends Goal {
    private final Infected mob;
    public LocalTargettingGoal(Infected mob){
        this.mob = mob;
    }
    @Override
    public boolean canUse() {
        return mob.getTarget() != null && mob.getLinked() && this.mob.getRandom().nextInt(0,10) == 7;
    }

    @Override
    public boolean canContinueToUse() {
        return mob.getTarget() != null && mob.getLinked();
    }

    @Override
    public void start() {
        super.start();
        this.Targeting(mob);
    }

    public void Targeting(Entity entity){
        double range;
        if (this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE) < 32){
            range = this.mob.getAttributeBaseValue(Attributes.FOLLOW_RANGE);
        }else{
            range = 32;
        }

        AABB boundingBox = entity.getBoundingBox().inflate(range);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity entity1 : entities) {
            if(entity1 instanceof Infected livingEntity) {
                if (livingEntity.getTarget() == null && this.mob.getTarget() != null && this.mob.getTarget().isAlive() && !this.mob.getTarget().isInvulnerable()){
                    livingEntity.setTarget(mob.getTarget());
                }
            }
        }
    }
}
