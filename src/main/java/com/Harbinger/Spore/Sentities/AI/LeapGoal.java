package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class LeapGoal extends Goal {
    private final Mob mob;
    private LivingEntity target;
    private final float yd;

    public LeapGoal(Mob p_25492_, float p_25493_) {
        this.mob = p_25492_;
        this.yd = p_25493_;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canUse() {
            this.target = this.mob.getTarget();
            if (this.target == null)
            {
                return false;
            } else if (this.mob.isInWater())
            {
                return false;
            } else
            {
                double d0 = this.mob.distanceToSqr(this.target);
                if (d0 > 32.0D) {
                    if (!this.mob.onGround()) {
                        return false;
                    } else {
                        return this.mob.getRandom().nextInt(reducedTickDelay(5)) == 0;
                    }
                } else {
                    return false;
                }
            }

    }

    public boolean canContinueToUse() {
        return !this.mob.onGround();
    }

    @Override
    public void tick() {
        if (this.mob.getTarget() != null){
        this.mob.getLookControl().setLookAt(this.mob.getTarget(), 10.0F, (float) this.mob.getMaxHeadXRot());}
    }

    public void start() {
        Vec3 vec3 = this.mob.getDeltaMovement();
        Vec3 vec31 = new Vec3(this.target.getX() - this.mob.getX(), 0.0D, this.target.getZ() - this.mob.getZ());
        if (vec31.lengthSqr() > 1.0E-7D) {
            vec31 = vec31.normalize().scale(2D).add(vec3.scale(1.5D));
        }

        this.mob.setDeltaMovement(vec31.x + yd, this.yd, vec31.z + yd);
    }

}
