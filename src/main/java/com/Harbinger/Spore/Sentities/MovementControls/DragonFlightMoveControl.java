package com.Harbinger.Spore.Sentities.MovementControls;

import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class DragonFlightMoveControl extends MoveControl {

    protected final Verfalldrachen mob;
    protected int flapCooldown = 0;
    protected float speed = 0.1F;
    private final float entityWidth = 2.5F; // Half of 5x5 size for collision checks

    // Phantom-like movement parameters
    private static final float TURN_SPEED_NORMAL = 4.0F;
    private static final float TURN_SPEED_SLOW = 2.0F;
    private static final float SPEED_FAST = 1.8F;
    private static final float SPEED_SLOW = 0.2F;
    private static final float SPEED_APPROACH_RATE = 0.005F;
    private static final float SPEED_SLOW_APPROACH_RATE = 0.025F;
    private static final double MIN_DISTANCE = 0.00001;

    public DragonFlightMoveControl(Verfalldrachen mob) {
        super(mob);
        this.mob = mob;
    }

    @Override
    public void tick() {
        if (flapCooldown > 0) {
            flapCooldown--;
        }

        // Handle horizontal collisions like Phantom
        if (mob.horizontalCollision) {
            mob.setYRot(mob.getYRot() + 180.0F);
            this.speed = SPEED_SLOW;
        }

        if (this.operation != Operation.MOVE_TO) {
            // Idle flight behavior - maintain altitude with gentle gliding
            if (!mob.onGround()) {
                Vec3 vel = mob.getDeltaMovement();
                mob.setDeltaMovement(
                        vel.x * 0.98F,
                        vel.y - 0.02F,
                        vel.z * 0.98F
                );
                mob.setNoGravity(true);
            } else {
                mob.setNoGravity(false);
            }
            return;
        }

        this.operation = Operation.WAIT;

        Vec3 currentPos = mob.position();
        Vec3 target = new Vec3(wantedX, wantedY, wantedZ);

        // Calculate direction vectors
        double dx = target.x - currentPos.x;
        double dy = target.y - currentPos.y;
        double dz = target.z - currentPos.z;
        double horizontalDist = Math.sqrt(dx * dx + dz * dz);

        // Skip if too close (adjusted for entity size)
        if (Math.abs(horizontalDist) < MIN_DISTANCE) {
            return;
        }

        // Phantom's Y-axis adjustment - reduces horizontal movement when climbing
        double yInfluence = 1.0 - Math.abs(dy * 0.7) / horizontalDist;
        dx *= yInfluence;
        dz *= yInfluence;

        // Recalculate distances
        horizontalDist = Math.sqrt(dx * dx + dz * dz);
        double totalDist = Math.sqrt(dx * dx + dz * dz + dy * dy);

        // Calculate rotation (Yaw)
        float currentYaw = mob.getYRot();
        float targetYaw = (float) Mth.atan2(dz, dx);
        float targetYawDegrees = Mth.wrapDegrees(targetYaw * Mth.RAD_TO_DEG);
        float adjustedCurrentYaw = Mth.wrapDegrees(currentYaw + 90.0F);

        // Apply rotation with phantom-like turning rates
        mob.setYRot(
                Mth.approachDegrees(adjustedCurrentYaw, targetYawDegrees,
                        getTurnSpeed()) - 90.0F
        );
        mob.yBodyRot = mob.getYRot();

        // Adjust speed based on turn rate
        if (Mth.degreesDifferenceAbs(currentYaw, mob.getYRot()) < 3.0F) {
            this.speed = Mth.approach(this.speed, SPEED_FAST,
                    SPEED_APPROACH_RATE * (SPEED_FAST / this.speed));
        } else {
            this.speed = Mth.approach(this.speed, SPEED_SLOW, SPEED_SLOW_APPROACH_RATE);
        }

        // Calculate Pitch (X rotation) - critical for large entity
        float targetPitch = (float) (-(Mth.atan2(-dy, horizontalDist) * Mth.RAD_TO_DEG));

        // Clamp pitch to prevent excessive angles (important for 5x5 entity)
        targetPitch = Mth.clamp(targetPitch, -60.0F, 60.0F);
        mob.setXRot(targetPitch);

        // Calculate movement vector based on current rotation
        float yawRad = (mob.getYRot() + 90.0F) * Mth.DEG_TO_RAD;
        float pitchRad = mob.getXRot() * Mth.DEG_TO_RAD;

        // Scale movement components by distance ratio
        double moveX = speed * Mth.cos(yawRad) * Math.abs(dx / totalDist);
        double moveZ = speed * Mth.sin(yawRad) * Math.abs(dz / totalDist);
        double moveY = speed * Mth.sin(pitchRad) * Math.abs(dy / totalDist);

        // Apply movement with smoothing (20% of target movement per tick)
        Vec3 currentVel = mob.getDeltaMovement();
        Vec3 targetVel = new Vec3(moveX, moveY, moveZ);
        Vec3 newVel = currentVel.add(targetVel.subtract(currentVel).scale(0.2));

        // Handle flapping animation
        if (shouldFlap(dy, totalDist) && flapCooldown <= 0) {
            newVel = newVel.add(0, 0.75, 0);
            flapCooldown = 25;
            onFlap();
        }

        // Clamp speeds for large entity stability
        newVel = clampVelocity(newVel);

        mob.setDeltaMovement(newVel);
        mob.setNoGravity(true);
        mob.hasImpulse = true;

        // Prevent collision with ground for large entity
        preventGroundCollision();
    }

    private float getTurnSpeed() {
        return speed > SPEED_SLOW ? TURN_SPEED_NORMAL : TURN_SPEED_SLOW;
    }

    private boolean shouldFlap(double verticalDiff, double totalDist) {
        // Flap when climbing or when moving upward relative to target
        return (verticalDiff > 1.5F || (mob.getDeltaMovement().y < 0.1 && totalDist > 5.0));
    }

    private Vec3 clampVelocity(Vec3 vel) {
        // Speed limits appropriate for 5x5 entity
        double maxSpeed = 1.5;
        double currentSpeed = Math.sqrt(vel.x * vel.x + vel.y * vel.y + vel.z * vel.z);

        if (currentSpeed > maxSpeed) {
            vel = vel.scale(maxSpeed / currentSpeed);
        }

        // Limit vertical speed
        return new Vec3(
                vel.x,
                Mth.clamp(vel.y, -1.2, 1.2),
                vel.z
        );
    }

    private void preventGroundCollision() {
        BlockPos posBelow = mob.blockPosition().below((int)(entityWidth));

        if (!mob.level().isEmptyBlock(posBelow)) {
            Vec3 vel = mob.getDeltaMovement();
            if (vel.y < 0.2) {
                mob.setDeltaMovement(vel.x, 0.3, vel.z);
            }
        }
    }

    protected void onFlap() {
        mob.playSound(SoundEvents.ENDER_DRAGON_FLAP, 1.0F,
                0.8F + mob.getRandom().nextFloat() * 0.4F);
        mob.triggerFlap();
        mob.level().broadcastEntityEvent(mob, (byte)6);
    }

    public boolean isAtTarget() {
        if (operation != Operation.MOVE_TO) return true;
        Vec3 currentPos = mob.position();
        Vec3 target = new Vec3(wantedX, wantedY, wantedZ);
        return currentPos.distanceTo(target) < (entityWidth * 2);
    }
}