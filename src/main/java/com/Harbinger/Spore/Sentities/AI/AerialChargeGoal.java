package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class AerialChargeGoal  extends Goal {
    private final Mob mob;
    public AerialChargeGoal(Mob p_25492_) {
        this.mob = p_25492_;
        this.setFlags(EnumSet.of( Goal.Flag.MOVE));
    }

    public boolean canUse() {
        LivingEntity livingentity = this.mob.getTarget();
        return livingentity != null && livingentity.isAlive();
    }

    public boolean canContinueToUse() {
        return !this.mob.onGround() && this.mob.getTarget() != null && this.mob.getTarget().isAlive();
    }

    @Override
    public void stop() {
        this.mob.setSprinting(false);
    }

    public void start() {
        Vec3 vec31 = this.mob.getDeltaMovement();
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity != null) {
            Vec3 vec3 = livingentity.getEyePosition();
            if (vec3.lengthSqr() > 1.0E-7D) {
                vec3 = vec3.normalize().scale(0.4D).add(vec31.scale(0.2D));
            }
            this.mob.setDeltaMovement(vec3.x, vec3.y,-vec3.z);
        }
    }


    public boolean requiresUpdateEveryTick() {
        return true;
    }

    public void tick() {
        LivingEntity livingentity = this.mob.getTarget();
        if (livingentity != null) {
            if (this.mob.getBoundingBox().intersects(livingentity.getBoundingBox())) {
                this.mob.doHurtTarget(livingentity);
            }
        }
    }
}