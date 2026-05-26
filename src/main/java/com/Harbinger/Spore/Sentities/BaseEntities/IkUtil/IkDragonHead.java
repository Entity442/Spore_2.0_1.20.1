package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import com.Harbinger.Spore.Sentities.BaseEntities.CalamityMultipart;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class IkDragonHead {

    protected final RandomSource randomSource = RandomSource.create();

    protected final LivingEntity owner;
    protected final CalamityMultipart multipart;

    protected final Vec3[] entities;
    protected final Vec3[] renderPositions;
    protected final Vec3[] velocities;

    protected final float[] wiggleTimers;
    protected final float[] wiggleSpeeds;
    protected final float[] wiggleAmplitudes;
    protected final float[] wiggleOffsets;

    protected final Vec3 defaultBodyOffset;
    protected final Vec3 defaultLimbOffset;

    protected Vec3 sitPosition;
    protected Vec3 lastSitPosition;

    protected Vec3 lastOwnerPosition = Vec3.ZERO;
    protected Vec3 ownerMovementDelta = Vec3.ZERO;

    protected float lastYaw;
    protected float lastPitch;

    protected float yawDelta;
    protected float pitchDelta;

    protected final float segmentLength = 0.75f;

    public IkDragonHead(
            LivingEntity owner,
            CalamityMultipart multipart,
            int amount,
            Vec3 defaultBodyOffset,
            Vec3 defaultLimbOffset
    ) {
        this.owner = owner;
        this.multipart = multipart;

        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;

        this.entities = new Vec3[amount];
        this.renderPositions = new Vec3[amount];
        this.velocities = new Vec3[amount];

        this.wiggleTimers = new float[amount];
        this.wiggleSpeeds = new float[amount];
        this.wiggleAmplitudes = new float[amount];
        this.wiggleOffsets = new float[amount];

        Vec3 start = owner.position();

        for (int i = 0; i < amount; i++) {

            entities[i] = start;
            renderPositions[i] = start;
            velocities[i] = Vec3.ZERO;

            wiggleTimers[i] = randomSource.nextFloat() * 100f;
            wiggleSpeeds[i] = 0.5f + randomSource.nextFloat() * getWiggleSpeed();
            wiggleAmplitudes[i] = 0.01f + randomSource.nextFloat() * getWiggleAmplitude();
            wiggleOffsets[i] = randomSource.nextFloat() * Mth.TWO_PI;
        }

        lastOwnerPosition = owner.position();
        lastYaw = owner.getYRot();
        lastPitch = owner.getXRot();
    }

    public float getWiggleSpeed() {
        return 0.25f;
    }

    public float getWiggleAmplitude() {
        return 0.4f;
    }

    public Vec3[] getEntities() {
        return renderPositions;
    }

    public Vec3 getSitPosition() {
        return sitPosition;
    }

    public Vec3 getLastSitPosition() {
        return lastSitPosition;
    }

    public Vec3 applyYaw(Vec3 offset) {
        float yawRad = owner.getYRot() * Mth.DEG_TO_RAD;
        return offset.yRot(-yawRad - Mth.HALF_PI);
    }

    public Vec3 getBodyOffset() {
        Vec3 extra = isMoving() ? new Vec3(1, 0, 0) : Vec3.ZERO;
        return owner.position().add(applyYaw(defaultBodyOffset).add(extra));
    }

    public Vec3 getHeadBasePos() {
        Vec3 extra = isMoving() ? new Vec3(1, 0, 0) : Vec3.ZERO;
        return owner.position().add(applyYaw(defaultLimbOffset.add(extra)));
    }

    protected void updateOwnerMovement() {

        Vec3 currentPos = owner.position();

        ownerMovementDelta = currentPos.subtract(lastOwnerPosition);

        lastOwnerPosition = currentPos;

        float currentYaw = owner.getYRot();
        float currentPitch = owner.getXRot();

        yawDelta = Mth.wrapDegrees(currentYaw - lastYaw);
        pitchDelta = Mth.wrapDegrees(currentPitch - lastPitch);

        yawDelta = Mth.clamp(yawDelta, -8f, 8f);
        pitchDelta = Mth.clamp(pitchDelta, -6f, 6f);

        lastYaw = currentYaw;
        lastPitch = currentPitch;
    }

    protected boolean isMoving() {
        return ownerMovementDelta.lengthSqr() > 0.0001 || Math.abs(yawDelta) > 0.05f;
    }

    protected Vec3 calculateAngularVelocity(Vec3 pos, Vec3 pivot, float yaw, float pitch, float influence) {

        Vec3 rel = pos.subtract(pivot).scale(influence);

        double yawRad = yaw * Mth.DEG_TO_RAD;
        double pitchRad = pitch * Mth.DEG_TO_RAD;

        Vec3 yawVel = new Vec3(
                -yawRad * rel.z,
                0,
                yawRad * rel.x
        );

        Vec3 pitchVel = new Vec3(
                0,
                pitchRad * rel.z,
                -pitchRad * rel.y
        );

        return yawVel.add(pitchVel);
    }

    protected void applyMovement() {

        int last = entities.length - 1;

        Vec3 pivot = owner.position();

        for (int i = 0; i < entities.length; i++) {

            float t = (float)i / last;

            float followStrength = Mth.lerp(t, 0.15f, 0.65f);

            Vec3 translational = ownerMovementDelta.scale(followStrength);

            Vec3 rotational = calculateAngularVelocity(
                    entities[i],
                    pivot,
                    yawDelta * 0.25f,
                    pitchDelta * 0.25f,
                    t
            );

            Vec3 force = translational.add(rotational);

            velocities[i] = velocities[i]
                    .scale(0.82f)
                    .add(force);

            float maxVel = Mth.lerp(t, 0.2f, 0.9f);

            if (velocities[i].lengthSqr() > maxVel * maxVel) {
                velocities[i] = velocities[i].normalize().scale(maxVel);
            }

            entities[i] = entities[i].add(velocities[i]);
        }
    }

    protected void solveFABRIK(Vec3 root, Vec3 target) {

        int tip = entities.length - 1;

        entities[tip] = entities[tip].lerp(target, 0.2f);

        for (int i = tip - 1; i >= 0; i--) {

            Vec3 next = entities[i + 1];

            Vec3 dir = entities[i]
                    .subtract(next);

            if (dir.lengthSqr() < 0.0001f) {
                dir = new Vec3(segmentLength, 0, 0);
            }

            dir = dir.normalize().scale(segmentLength);

            Vec3 solved = next.add(dir);

            entities[i] = entities[i].lerp(solved, 0.45f);
        }

        entities[0] = root;

        for (int i = 1; i < entities.length; i++) {

            Vec3 prev = entities[i - 1];

            Vec3 dir = entities[i]
                    .subtract(prev);

            if (dir.lengthSqr() < 0.0001f) {
                dir = new Vec3(segmentLength, 0, 0);
            }

            dir = dir.normalize().scale(segmentLength);

            Vec3 solved = prev.add(dir);

            entities[i] = entities[i].lerp(solved, 0.45f);
        }
    }
    protected void validateChainDistance() {

        Vec3 root = getBodyOffset();

        for (int i = 0; i < entities.length; i++) {

            if (entities[i].distanceToSqr(root) > 125.0D) {

                Vec3 resetPos = root.add(0, 0.25 * i, 0);

                entities[i] = resetPos;
                renderPositions[i] = resetPos;
                velocities[i] = Vec3.ZERO;
            }
        }
    }

    protected void applyHeadTracking(Vec3 target) {

        int tip = entities.length - 1;

        Vec3 current = entities[tip];

        Vec3 error = target.subtract(current);

        velocities[tip] = velocities[tip]
                .scale(0.72f)
                .add(error.scale(0.12f));

        entities[tip] = current.add(velocities[tip]);
    }

    protected void updateWiggleTimers() {

        for (int i = 0; i < wiggleTimers.length; i++) {

            wiggleTimers[i] += 0.05f * wiggleSpeeds[i];

            if (wiggleTimers[i] > 1000f) {
                wiggleTimers[i] -= 1000f;
            }
        }
    }

    protected void applyIdleWiggle() {

        if (isMoving()) {
            return;
        }

        for (int i = 1; i < entities.length - 1; i++) {

            float time = wiggleTimers[i] + wiggleOffsets[i];

            float x =
                    Mth.sin(time * 0.7f)
                            * wiggleAmplitudes[i];

            float y =
                    Mth.sin(time * 1.1f)
                            * wiggleAmplitudes[i]
                            * 0.6f;

            float z =
                    Mth.sin(time * 0.9f)
                            * wiggleAmplitudes[i]
                            * 0.4f;

            Vec3 target = entities[i].add(x, y, z);

            entities[i] = entities[i].lerp(target, 0.1f);
        }
    }

    protected void dampVelocities() {

        for (int i = 0; i < velocities.length; i++) {
            velocities[i] = velocities[i].scale(0.88f);
        }
    }

    protected void updateRenderPositions() {

        for (int i = 0; i < renderPositions.length; i++) {
            renderPositions[i] = renderPositions[i].lerp(entities[i], 0.35f);
        }
    }

    public void applyIK() {
        if (entities.length == 0) {
            return;
        }

        validateChainDistance();

        updateOwnerMovement();

        Vec3 root = getBodyOffset();

        Vec3 target = sitPosition == null
                ? getHeadBasePos()
                : sitPosition;

        applyMovement();

        applyHeadTracking(target);

        solveFABRIK(root, target);

        applyIdleWiggle();

        dampVelocities();

        updateRenderPositions();

        updateWiggleTimers();

        setupPositionHitbox();

    }

    public void setupPositionHitbox() {

        Vec3 endSeg = renderPositions[renderPositions.length - 1];

        Vec3 prev = new Vec3(
                multipart.getX(),
                multipart.getY(),
                multipart.getZ()
        );

        multipart.setPos(
                endSeg.x,
                endSeg.y - 0.45,
                endSeg.z
        );

        multipart.xo = prev.x;
        multipart.yo = prev.y;
        multipart.zo = prev.z;

        multipart.xOld = prev.x;
        multipart.yOld = prev.y;
        multipart.zOld = prev.z;
    }
}