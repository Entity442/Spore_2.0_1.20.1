package com.Harbinger.Spore.Sentities.AI;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class PullGoal extends Goal {
    private final Mob mob;
    private final double range;
    private final double range_min;

    public PullGoal(Mob mob, double range, double range_min) {
        this.mob = mob;
        this.range = range;
        this.range_min = range_min;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canUse() {
        if (this.mob.getTarget() != null) {
            double d0 = this.mob.distanceToSqr(this.mob.getTarget());
            if ((d0 < (mob.getBbWidth() + range)) && (d0 > (mob.getBbWidth() + range_min)) && this.mob.hasLineOfSight(this.mob.getTarget())) {
                if (!this.mob.getTarget().onGround()) {
                    return false;
                } else {
                    return this.mob.getTarget().getRandom().nextInt(reducedTickDelay(5)) == 0;
                }
            }
        }
        return false;
    }

    public boolean canContinueToUse() {
        if (this.mob.getTarget() != null){
        return !this.mob.getTarget().onGround();
        }
        return false;
    }

    @Override
    public void tick() {
        if (this.mob.getTarget() != null){
            this.mob.getLookControl().setLookAt(this.mob.getTarget(), 10.0F, (float) this.mob.getMaxHeadXRot());}
    }



    public void start() {
        if (this.mob.getTarget() != null){
        Vec3 vec3 = this.mob.getTarget().getDeltaMovement();
        Vec3 vec31 = new Vec3(this.mob.getX() - this.mob.getTarget().getX(), this.mob.getY() - this.mob.getTarget().getY(),this.mob.getZ() - this.mob.getTarget().getZ() );
        if (vec31.lengthSqr() > 1.0E-7D) {
            vec31 = vec31.normalize().scale(1.5D).add(vec3.scale(0.75D));
        }
        this.mob.swing(InteractionHand.MAIN_HAND);
            this.mob.getTarget().setDeltaMovement(vec31.x, vec31.y, vec31.z);
        if (this.mob.getTarget() instanceof Player){
            this.mob.getTarget().hurtMarked = true;}}
    }
}
