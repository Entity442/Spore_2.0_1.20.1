package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import com.Harbinger.Spore.Sentities.Calamities.Verfalldrachen;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class IkDragonTail {
    protected final RandomSource randomSource = RandomSource.create();
    protected final Verfalldrachen owner;
    protected final Vec3[] entities;
    protected final Vec3 defaultBodyOffset;
    protected final Vec3 defaultLimbOffset;
    protected final float[] wiggleTimers;
    protected final float[] wiggleSpeeds;
    protected final float[] wiggleAmplitudes;
    protected final float[] wiggleOffsets;
    protected final Vec3[] segmentVelocities;
    protected final float[] targetYaws; // Store target yaw for each segment
    protected final float[] currentYaws; // Store current yaw for smooth rotation
    protected Vec3 sitPosition = null;
    protected Vec3 lastSitPosition = null;
    protected Vec3 lastOwnerPosition = Vec3.ZERO;
    protected Vec3 ownerMovementDelta = Vec3.ZERO;
    protected float lastYaw = 0;
    protected float yawDelta = 0;

    public IkDragonTail(Verfalldrachen owner, int amount, Vec3 defaultBodyOffset,
                        Vec3 defaultLimbOffset) {
        this.owner = owner;
        this.entities = new Vec3[amount];
        this.wiggleTimers = new float[amount];
        this.wiggleSpeeds = new float[amount];
        this.wiggleAmplitudes = new float[amount];
        this.wiggleOffsets = new float[amount];
        this.segmentVelocities = new Vec3[amount];
        this.targetYaws = new float[amount];
        this.currentYaws = new float[amount];

        for(int i = 0; i < amount; i++){
            entities[i] = new Vec3(0,0,0);
            wiggleSpeeds[i] = 0.5f + randomSource.nextFloat() * getWiggleSpeed();
            wiggleAmplitudes[i] = 0.02f + randomSource.nextFloat() * getWiggleAmplitude();
            wiggleOffsets[i] = randomSource.nextFloat() * (float)Math.PI * 2;
            wiggleTimers[i] = randomSource.nextFloat() * 100;
            segmentVelocities[i] = new Vec3(0, 0, 0);
            targetYaws[i] = 0;
            currentYaws[i] = 0;
        }
        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;
    }

    public float getWiggleSpeed(){
        return 0.25f;
    }

    public float getWiggleAmplitude(){
        return 0.03f;
    }

    protected void updateWiggleTimers() {
        for (int i = 0; i < wiggleTimers.length; i++) {
            wiggleTimers[i] += 0.05f * wiggleSpeeds[i];
            if (wiggleTimers[i] > 1000) wiggleTimers[i] -= 1000;
        }
    }

    public Vec3 getSitPosition() {
        return sitPosition;
    }

    protected void applyIdleWiggle() {
        RandomSource rand = this.randomSource;
        for (int i = 1; i < entities.length - 1; i++) {
            Vec3 current = entities[i];
            float time = wiggleTimers[i] + wiggleOffsets[i];
            float xWiggle = (float)Math.sin(time * 0.7f) * wiggleAmplitudes[i];
            float yWiggle = (float)Math.sin(time * 1.2f + 1.5f) * wiggleAmplitudes[i] * 0.8f;
            float zWiggle = (float)Math.sin(time * 0.9f + 2.0f) * wiggleAmplitudes[i] * 0.6f;

            if (rand.nextFloat() < 0.05f) {
                xWiggle += (rand.nextFloat() - 0.5f) * 0.02f;
                yWiggle += (rand.nextFloat() - 0.5f) * 0.01f;
                zWiggle += (rand.nextFloat() - 0.5f) * 0.02f;
            }

            entities[i] = current.add(xWiggle, yWiggle, zWiggle);
        }
    }

    public Vec3[] getEntities() {
        return entities;
    }

    public Vec3 getLastSitPosition() {
        return lastSitPosition;
    }

    public Vec3 applyYaw(Vec3 offset) {
        float yawRad = owner.getYRot() * Mth.DEG_TO_RAD;
        return offset.yRot(-yawRad - Mth.HALF_PI);
    }

    public Vec3 getHeadBasePos() {
        Vec3 pivot = owner.position();
        return pivot.add(applyYaw(defaultLimbOffset));
    }

    public Vec3 getBodyOffset() {
        Vec3 pivot = owner.position();
        return pivot.add(applyYaw(defaultBodyOffset));
    }

    protected void moveSegmentTowards(int index, Vec3 target, boolean far) {
        Vec3 currentPos = entities[index];
        Vec3 newPos = currentPos.lerp(target, 0.35f);
        entities[index] = (far ? target : newPos);
    }

    protected void moveTipTowards(Vec3 target) {
        int tip = entities.length - 1;
        Vec3 currentPos = entities[tip];
        entities[tip] = currentPos.lerp(target, 0.25f);
    }

    protected boolean isOwnerMoving(){
        return owner.getDeltaMovement().lengthSqr() > 0.005 || Math.abs(yawDelta) > 0.1f;
    }

    protected void updateOwnerMovementDelta() {
        Vec3 currentOwnerPos = owner.position();
        ownerMovementDelta = currentOwnerPos.subtract(lastOwnerPosition);
        lastOwnerPosition = currentOwnerPos;

        float currentYaw = owner.getYRot();
        yawDelta = Mth.wrapDegrees(currentYaw - lastYaw);
        lastYaw = currentYaw;
    }

    protected Vec3 rotateAroundYaw(Vec3 pos, Vec3 pivot, float degrees) {
        double rad = degrees * Mth.DEG_TO_RAD;
        Vec3 rel = pos.subtract(pivot);
        Vec3 rotated = rel.yRot((float)-rad);
        return pivot.add(rotated);
    }

    // Apply progressive rotational lag - farther segments lag more
    protected void applyBodySpin() {
        if (Math.abs(yawDelta) < 0.001f) {
            // Gradually return tail to neutral position when not spinning
            for (int i = 1; i < entities.length; i++) {
                float t = (float) i / (entities.length - 1);
                float returnSpeed = 0.05f * (1 - t * 0.5f); // Tip returns slower
                currentYaws[i] = currentYaws[i] * (1 - returnSpeed);
                targetYaws[i] = targetYaws[i] * (1 - returnSpeed);
            }
            return;
        }

        int lastSegment = entities.length - 1;

        // Update target yaws with progressive delay
        for (int i = 1; i < entities.length; i++) {
            // Calculate delay factor - farther segments have more delay
            float t = (float) i / lastSegment; // 0 = base, 1 = tip
            float delayFactor = t * t; // Quadratic increase for more dramatic lag at tip

            // Base segment follows owner almost instantly, tip lags significantly
            float followSpeed = 1.0f - (delayFactor * 0.9f);
            followSpeed = Math.max(0.1f, followSpeed);

            // Update target yaw with delay
            targetYaws[i] = targetYaws[i] * (1 - followSpeed) + yawDelta * followSpeed;

            // Clamp to prevent extreme angles
            float maxAngle = 45.0f * (1 + t); // Tip can bend more
            targetYaws[i] = Mth.clamp(targetYaws[i], -maxAngle, maxAngle);

            // Smoothly interpolate current yaw toward target
            float smoothSpeed = 0.3f - (t * 0.15f); // Tip moves slower
            currentYaws[i] = currentYaws[i] * (1 - smoothSpeed) + targetYaws[i] * smoothSpeed;
        }

        // Apply rotation to each segment with its own lag value
        for (int i = 1; i < entities.length; i++) {
            float t = (float) i / lastSegment;

            // Apply the delayed rotation to this segment
            if (Math.abs(currentYaws[i]) > 0.01f) {
                // Rotate around the previous segment's position for natural chain motion
                Vec3 rotationPivot = entities[i - 1];
                entities[i] = rotateAroundYaw(entities[i], rotationPivot, currentYaws[i]);

                // Add some velocity for fluid motion
                float tSquared = t * t;
                float rotationalInfluence = tSquared * 0.5f;
                Vec3 tangentialVel = calculateTangentialVelocity(entities[i], rotationPivot, currentYaws[i], rotationalInfluence);
                segmentVelocities[i] = segmentVelocities[i].add(tangentialVel);

                // Cap velocity for tip
                float maxVel = 0.8f + t;
                if (segmentVelocities[i].length() > maxVel) {
                    segmentVelocities[i] = segmentVelocities[i].normalize().scale(maxVel);
                }
            }
        }

        // Apply damping to velocities
        for (int i = 1; i < segmentVelocities.length; i++) {
            float t = (float) i / lastSegment;
            float damping = 0.92f - (t * 0.04f); // Tip has less damping for more swing
            segmentVelocities[i] = segmentVelocities[i].scale(damping);
            entities[i] = entities[i].add(segmentVelocities[i]);
        }

        // Apply rotation to sit positions with maximum lag
        if (sitPosition != null && entities.length > 0) {
            Vec3 basePivot = entities[0];
            float tipLag = 0.95f; // Maximum lag for sit position
            float delayedYaw = yawDelta * (1 - tipLag);
            sitPosition = rotateAroundYaw(sitPosition, basePivot, delayedYaw);
        }

        if (lastSitPosition != null && entities.length > 0) {
            Vec3 basePivot = entities[0];
            float tipLag = 0.95f;
            float delayedYaw = yawDelta * (1 - tipLag);
            lastSitPosition = rotateAroundYaw(lastSitPosition, basePivot, delayedYaw);
        }
    }

    // Helper to calculate tangential velocity from rotation
    protected Vec3 calculateTangentialVelocity(Vec3 pos, Vec3 pivot, float angularVelocity, float strength) {
        if (Math.abs(angularVelocity) < 0.01f) return Vec3.ZERO;

        Vec3 relativePos = pos.subtract(pivot);
        double rad = angularVelocity * Mth.DEG_TO_RAD;

        // Tangential velocity = angular velocity × radius
        Vec3 velocity = new Vec3(
                -rad * relativePos.z * strength,
                0,
                rad * relativePos.x * strength
        );

        return velocity;
    }

    public void applyIK() {
        updateOwnerMovementDelta();
        if (entities == null || entities.length == 0) return;

        Vec3 basePos = getBodyOffset();
        Vec3 defaultTipPos = sitPosition == null ? getHeadBasePos() : sitPosition;

        // Apply body spin with progressive lag FIRST
        applyBodySpin();

        if (!isOwnerMoving()){
            moveTipTowards(defaultTipPos);
        }else {
            moveTipTowards(entities[entities.length - 1].add(0,-0.01,0));
        }

        // Forward pass (root to tip) - maintain segment lengths
        for (int i = entities.length - 2; i >= 0; i--) {
            Vec3 nextPos = entities[i + 1];
            Vec3 dir = entities[i].subtract(nextPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = nextPos.add(dir);
            boolean forceSolve = entities[i+1].distanceTo(entities[i]) > segmentLength * 1.5f;
            moveSegmentTowards(i, solvedPos, forceSolve);
        }

        // Ensure root is at correct position
        entities[0] = basePos;

        // Backward pass (tip to root) - refine positions
        for (int i = 1; i < entities.length; i++) {
            Vec3 prevPos = entities[i - 1];
            Vec3 dir = entities[i].subtract(prevPos);

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            boolean forceSolve = entities[i-1].distanceTo(entities[i]) > segmentLength * 1.5f;
            moveSegmentTowards(i, solvedPos, forceSolve);
        }

        applyIdleWiggle();
        updateWiggleTimers();
    }
}