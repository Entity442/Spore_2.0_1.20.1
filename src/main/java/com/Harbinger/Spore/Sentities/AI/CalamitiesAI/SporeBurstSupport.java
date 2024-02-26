package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.world.entity.ai.goal.Goal;

public class SporeBurstSupport extends Goal {
    private final Calamity calamity;

    public SporeBurstSupport(Calamity calamity){
        this.calamity = calamity;
    }

    @Override
    public boolean canUse() {
        return this.calamity.isAlive() && this.calamity.getRandom().nextInt(300) == 0  && calamity.getTarget() != null && this.calamity.distanceToSqr(this.calamity.getTarget())<200.0D;
    }

    @Override
    public void start() {
        this.calamity.setStun(60);
        if (calamity instanceof TrueCalamity trueCalamity){
            trueCalamity.chemAttack();
        }
        super.start();
    }

}
