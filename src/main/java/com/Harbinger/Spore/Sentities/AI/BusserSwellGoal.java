package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.EvolvedInfected.Busser;
import com.Harbinger.Spore.Sentities.Variants.BusserVariants;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;

import javax.annotation.Nullable;
import java.util.EnumSet;

public class BusserSwellGoal extends Goal {
    private final Busser busser;
    @Nullable
    private LivingEntity target;

    public BusserSwellGoal(Busser busser1) {
        this.busser = busser1;
        this.setFlags(EnumSet.of(Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.busser.getTarget();
        return this.busser.getVariant() == BusserVariants.BOMBER && (this.busser.getSwellDir() > 0 || livingentity != null && this.busser.distanceToSqr(livingentity) < 9.0D
                && this.busser.getHealth() <= this.busser.getMaxHealth()/2);
    }

    public void start() {
        this.target = this.busser.getTarget();
    }

    public void stop() {
        this.target = null;
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        if (this.target == null) {
            this.busser.setSwellDir(-1);
        } else if (this.busser.distanceToSqr(this.target) > 49.0D) {
            this.busser.setSwellDir(-1);
        } else if (!this.busser.getSensing().hasLineOfSight(this.target)) {
            this.busser.setSwellDir(-1);
        } else {
            this.busser.setSwellDir(1);
        }

    }

}