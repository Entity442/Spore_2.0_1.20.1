package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.EvolvedInfected.Braionmil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class BraionmilSwellGoal extends Goal {
    public final Braionmil braionmil;
    private final double speedModifier;
    public BraionmilSwellGoal(Braionmil braionmil, double speedModifier) {
        this.braionmil = braionmil;
        this.speedModifier = speedModifier;
        this.setFlags(EnumSet.of(Flag.MOVE));
    }

    public boolean canUse() {
        return this.braionmil.getTarget() != null && this.braionmil.distanceToSqr(braionmil.getTarget()) < 80.0D;
    }


    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {

        if (this.braionmil.getTarget() != null){
            this.braionmil.getLookControl().setLookAt(this.braionmil.getTarget(), 10.0F, (float) this.braionmil.getMaxHeadXRot());
            this.braionmil.getNavigation().moveTo(this.braionmil.getTarget(), this.speedModifier);
        if (this.braionmil.getTarget() == null) {
            this.braionmil.setSwellDir(-1);
        } else if (this.braionmil.distanceToSqr(this.braionmil.getTarget()) > 49.0D) {
            this.braionmil.setSwellDir(-1);
        } else if (!this.braionmil.getSensing().hasLineOfSight(this.braionmil.getTarget())) {
            this.braionmil.setSwellDir(-1);
        } else {
            this.braionmil.setSwellDir(1);
        }
        }
    }
}
