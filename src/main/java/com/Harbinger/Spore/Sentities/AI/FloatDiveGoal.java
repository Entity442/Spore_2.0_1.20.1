package com.Harbinger.Spore.Sentities.AI;

import com.Harbinger.Spore.Sentities.FlyingInfected;
import com.Harbinger.Spore.Sentities.WaterInfected;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

import java.util.EnumSet;

public class FloatDiveGoal extends Goal {
    private final Mob mob;

    public FloatDiveGoal(Mob mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Goal.Flag.JUMP));
        mob.getNavigation().setCanFloat(true);
    }

    public boolean canUse() {
        if (this.mob instanceof WaterInfected){
            return false;
        }else if (this.mob instanceof FlyingInfected){
            return false;
        }
        return this.mob.isInFluidType();
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }

    @Override
    public void tick() {
        if (this.mob.getRandom().nextFloat() < 0.4F) {
            this.mob.getJumpControl().jump();
        }
        super.tick();
    }

    @Override
    public void start() {
        if (this.mob.getTarget() != null) {
            LivingEntity target = this.mob.getTarget();
                Vec3 vec3 = this.mob.getDeltaMovement();
                Vec3 vec31 = new Vec3(target.getX() - this.mob.getX(), target.getY() - this.mob.getY(), target.getZ() - this.mob.getZ());
            if (vec31.lengthSqr() > 1.0E-7D) {
                vec31 = vec31.normalize().scale(0.5D).add(vec3.scale(0.3D));
            }
            this.mob.setDeltaMovement(vec31.x, vec31.y, vec31.z);
        }
        super.start();
    }


}
