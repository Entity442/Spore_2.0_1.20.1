package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class SummonScentInCombat extends Goal {
    private final Calamity calamity;

    public SummonScentInCombat(Calamity calamity){
        this.calamity = calamity;
    }
    @Override
    public boolean canUse() {
        return this.calamity.isAlive() && calamity.getRandom().nextInt(400) == 0 && calamity.isAggressive() && checkForScent();
    }

    @Override
    public void start() {
        SummonScent();
        this.calamity.setStun(80);
        super.start();
    }

    private void SummonScent(){
        ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),calamity.level());
        scent.moveTo(calamity.getX(),calamity.getY(),calamity.getZ());
        calamity.level().addFreshEntity(scent);
    }

    private boolean checkForScent() {
        AABB hitbox = this.calamity.getBoundingBox().inflate(8);
        List<Entity> entities = this.calamity.level().getEntities(this.calamity, hitbox , EntitySelector.NO_CREATIVE_OR_SPECTATOR);
        for (Entity en : entities) {
            if (en instanceof ScentEntity){
                return false;
            }
        }
        return true;
    }
}
