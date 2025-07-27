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
        Vec3 target = new Vec3(wantedX, wantedY, wantedZ);
        if (target.equals(Vec3.ZERO)) return;

        Vec3 currentPos = mob.position();
        Vec3 direction = target.subtract(currentPos).normalize();
        double distance = target.distanceTo(currentPos);

        // Smooth acceleration/deceleration
        double speed = Mth.clamp(distance * 0.1, 0.02, 0.2); // Adjust speed dynamically
        Vec3 movement = direction.scale(speed);

        // Apply movement
        mob.setDeltaMovement(movement);
        mob.move(MoverType.SELF, movement);

        // Face movement direction smoothly
        float targetYaw = (float) (Mth.atan2(direction.z, direction.x) * (180F / Math.PI) - 90F);
        mob.setYRot(Mth.approachDegrees(mob.getYRot(), targetYaw, 10F));
        mob.setYHeadRot(mob.getYRot());
    }
}
