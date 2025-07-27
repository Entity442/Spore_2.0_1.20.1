package com.Harbinger.Spore.Sentities.AI.CalamitiesAI;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;

public class UndergroundMovementControl extends MoveControl {
    public UndergroundMovementControl(Mob mob) {
        super(mob);
    }

    @Override
    public void tick() {
        if (this.mob instanceof Hohlfresser worm && worm.canGoUnderground()) {
            moveUnderground();
        } else {
            super.tick(); // Fall back to normal movement
        }
    }
    public void moveUnderground() {
        // Desired target position
        double targetX = this.getWantedX();
        double targetY = this.getWantedY();
        double targetZ = this.getWantedZ();
        // Current position
        double currentX = mob.getX();
        double currentY = mob.getY();
        double currentZ = mob.getZ();

        // Vector from current to target
        Vec3 toTarget = new Vec3(targetX - currentX, targetY - currentY, targetZ - currentZ);

        // If we're already close, don't move further
        if (toTarget.lengthSqr() < 0.001) {
            mob.setDeltaMovement(Vec3.ZERO);
            return;
        }

        // Normalize and scale for speed
        Vec3 direction = toTarget.normalize();
        double speed = 0.3; // Adjust to desired underground speed
        Vec3 movement = direction.scale(speed);

        // Apply motion directly
        mob.setDeltaMovement(movement);
        mob.move(MoverType.SELF, movement);

        // Optional: rotate to face direction of movement
        float yaw = (float)(Mth.atan2(direction.z, direction.x) * (180F / Math.PI)) - 90.0F;
        mob.setYRot(yaw);
        mob.setYHeadRot(yaw);
    }
}