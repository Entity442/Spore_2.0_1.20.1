package com.Harbinger.Spore.Sentities.MovementControls;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;

public class ExperimentalGroundMovementController extends MoveControl {
    private final Mob mob;
    private static final float MAX_TURN = 16.0F;
    public ExperimentalGroundMovementController(Mob mob) {
        super(mob);
        this.mob = mob;
    }
    @Override
    public void tick() {

        if (this.operation != Operation.MOVE_TO) {
            mob.setZza(0.0F);
            return;
        }

        this.operation = Operation.WAIT;

        double dx = this.wantedX - mob.getX();
        double dy = this.wantedY - mob.getY();
        double dz = this.wantedZ - mob.getZ();

        double distSqr = dx * dx + dy * dy + dz * dz;

        if (distSqr < 0.05D) {
            mob.setZza(0.0F);
            return;
        }

        // Desired yaw
        float targetYaw = (float)(Mth.atan2(dz, dx) * (180F / Math.PI)) - 90.0F;

        // Smooth turning
        mob.setYRot(rotlerp(mob.getYRot(), targetYaw, MAX_TURN));
        mob.yBodyRot = mob.getYRot();
        mob.yHeadRot = mob.getYRot();

        // Movement speed
        float speed = (float)(this.speedModifier * mob.getAttributeValue(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED));

        mob.setSpeed(speed);

        // Forward movement only
        mob.setZza(1.0F);

        // Step/jump handling
        if (dy > mob.maxUpStep() && dx * dx + dz * dz < Math.max(1.0F, mob.getBbWidth())) {
            mob.getJumpControl().jump();
        }
    }
    protected float rotlerp(float current, float target, float maxTurn) {
        float f = Mth.wrapDegrees(target - current);

        if (f > maxTurn) {
            f = maxTurn;
        }

        if (f < -maxTurn) {
            f = -maxTurn;
        }

        return current + f;
    }
}