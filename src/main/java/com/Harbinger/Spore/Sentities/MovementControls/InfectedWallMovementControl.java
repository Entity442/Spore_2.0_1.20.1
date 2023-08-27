package com.Harbinger.Spore.Sentities.MovementControls;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class InfectedWallMovementControl extends MoveControl {
    private final Mob mob;
    public InfectedWallMovementControl(Mob mob) {
        super(mob);
        this.mob = mob;
    }

    @Override
    public void tick() {
        super.tick();
        if (mob.getTarget() != null && mob.getTarget().getY() <= this.mob.getY()){
            return;
        }else {
            if (mob.horizontalCollision) {
                Vec3 initialVec = mob.getDeltaMovement();
                Vec3 climbVec = new Vec3(initialVec.x, 0.2D, initialVec.z);
                mob.setDeltaMovement(climbVec.x * 0.91D,
                        climbVec.y * 0.98D, climbVec.z * 0.91D);
            }
        }

    }
}
