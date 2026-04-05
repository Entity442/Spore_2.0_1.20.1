package com.Harbinger.Spore.Sentities.MovementControls;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.LookControl;

public class SmoothLookControl extends LookControl {

    private final Mob mob;

    // Max degrees the mob can rotate per tick
    private final float maxYawChange;
    private final float maxPitchChange;

    // How strong the smoothing is (0–1). Lower = heavier/slower
    private final float smoothing;

    public SmoothLookControl(Mob mob, float maxYawChange, float maxPitchChange, float smoothing) {
        super(mob);
        this.mob = mob;
        this.maxYawChange = maxYawChange;
        this.maxPitchChange = maxPitchChange;
        this.smoothing = smoothing;
    }

    @Override
    public void tick() {
        // Let vanilla calculate the desired look direction
        super.tick();

        float currentYaw = mob.getYRot();
        float currentPitch = mob.getXRot();

        float targetYaw = mob.yHeadRot;
        float targetPitch = mob.getXRot();

        float yawDelta = wrapDegrees(targetYaw - currentYaw);
        float pitchDelta = targetPitch - currentPitch;

        // Clamp max rotation speed per tick
        yawDelta = clamp(yawDelta, -maxYawChange, maxYawChange);
        pitchDelta = clamp(pitchDelta, -maxPitchChange, maxPitchChange);

        // Lerp toward target (adds inertia / weight)
        float newYaw = currentYaw + yawDelta * smoothing;
        float newPitch = currentPitch + pitchDelta * smoothing;

        applyRotation(newYaw, newPitch);
    }

    private void applyRotation(float yaw, float pitch) {
        mob.setYRot(yaw);
        mob.setYHeadRot(yaw);
        mob.setYBodyRot(yaw);
        mob.setXRot(pitch);

        mob.yRotO = yaw;
        mob.yHeadRotO = yaw;
        mob.yBodyRotO = yaw;
        mob.xRotO = pitch;
    }

    private float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    private float wrapDegrees(float degrees) {
        while (degrees > 180F) degrees -= 360F;
        while (degrees < -180F) degrees += 360F;
        return degrees;
    }
}