package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.Calamities.Gazenbrecher;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class GazenWaterLeapGoal extends Goal {
    private final Gazenbrecher gazenbrecher;
    private LivingEntity target;

    public GazenWaterLeapGoal(Gazenbrecher p_25492_) {
        this.gazenbrecher = p_25492_;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
    }

    public boolean canUse() {
        this.target = this.gazenbrecher.getTarget();
        if (this.target == null)
        {
            return false;
        } else if (this.gazenbrecher.isInFluidType() && target.onGround() && !target.isInFluidType())
        {
            double d0 = this.gazenbrecher.distanceToSqr(this.target);
            if (d0 > 32.0D) {
                return this.gazenbrecher.getRandom().nextInt(reducedTickDelay(50)) == 0;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean canContinueToUse() {
        return !this.gazenbrecher.isInFluidType();
    }

    @Override
    public void tick() {
        if (target != null){
            this.gazenbrecher.getLookControl().setLookAt(target, 10.0F, (float) this.gazenbrecher.getMaxHeadXRot());}
    }
    public void start() {
        Vec3 vec3 = this.gazenbrecher.getDeltaMovement();
        Vec3 vec31 = new Vec3(this.target.getX() - this.gazenbrecher.getX(), 0.0D, this.target.getZ() - this.gazenbrecher.getZ());
        if (vec31.lengthSqr() > 1.0E-7D) {
            vec31 = vec31.normalize().scale(2D).add(vec3.scale(2D));
        }

        this.gazenbrecher.setDeltaMovement(vec31.x, 1.3f, vec31.z);
    }
}
