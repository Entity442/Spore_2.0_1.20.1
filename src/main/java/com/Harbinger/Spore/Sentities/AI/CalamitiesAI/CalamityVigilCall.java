package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Calamity;
import com.Harbinger.Spore.Sentities.Organoids.Vigil;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.ai.goal.Goal;

public class CalamityVigilCall extends Goal {
    private final Calamity calamity;

    public CalamityVigilCall(Calamity calamity){
        this.calamity = calamity;
    }

    @Override
    public boolean canUse() {
        return this.calamity.isAlive() && calamity.getHealth() < calamity.getMaxHealth()/2 &&
                this.calamity.getRandom().nextInt(200) == 0 && this.calamity.getTarget() != null;
    }

    @Override
    public void start() {
        super.start();
        RandomSource randomSource = RandomSource.create();
        Vigil vigil = new Vigil(Sentities.VIGIL.get(),calamity.level());
        vigil.tickEmerging();
        vigil.randomTeleport(calamity.getX()+randomSource.nextInt(-20,20),calamity.getY(),calamity.getZ()+randomSource.nextInt(-20,20),false);
        calamity.level().addFreshEntity(vigil);
    }
}
