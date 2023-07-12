package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CalamityInfectedCommand extends Goal {
    private final Calamity calamity;

    public CalamityInfectedCommand(Calamity calamity1){
        this.calamity = calamity1;
    }

    @Override
    public boolean canUse() {
        return this.calamity.getRandom().nextInt(100) == 0 && (this.calamity.getTarget() != null || this.calamity.getSearchArea() != BlockPos.ZERO);
    }


    @Override
    public void start() {
        Targeting(this.calamity);
        super.start();
    }

    public void Targeting(Entity entity){
        AABB boundingBox = entity.getBoundingBox().inflate(32);
        List<Entity> entities = entity.level().getEntities(entity, boundingBox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);

        for (Entity entity1 : entities) {
            if(entity1 instanceof Infected livingEntity) {
                if (livingEntity.getTarget() == null && this.calamity.getTarget() != null && this.calamity.getTarget().isAlive() && !this.calamity.getTarget().isInvulnerable()){
                    livingEntity.setTarget(calamity.getTarget());
                }

                if(livingEntity.getSearchPos() != null && calamity.getSearchArea() != BlockPos.ZERO){
                    livingEntity.setSearchPos(calamity.getSearchArea());
                }
            }
        }
    }

}
