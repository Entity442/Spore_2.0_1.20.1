package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;


public class IkLeviFin {
    protected final RandomSource randomSource = RandomSource.create();
    protected final LivingEntity owner;
    protected final Vec3[] entities;
    protected final Vec3 defaultBodyOffset;
    protected final Vec3 defaultLimbOffset;
    protected final float maxDistance;
    protected final Vec3[] segmentVelocities;
    protected Vec3 sitPosition =  null;
    protected Vec3 lastSitPosition = null;
    protected Vec3 lastOwnerPosition = Vec3.ZERO;
    protected Vec3 ownerMovementDelta = Vec3.ZERO;
    protected float lastYaw = 0;
    protected float yawDelta = 0;
    protected float swimAngle = 0f;
    protected float swimSpeed = 8f;
    public IkLeviFin(LivingEntity owner, int amount, Vec3 defaultBodyOffset,
                     Vec3 defaultLimbOffset,
                     float maxDistance) {
        this.owner = owner;
        this.entities = new Vec3[amount];
        this.segmentVelocities = new Vec3[amount];
        for(int i = 0;i<amount;i++){
            entities[i] = new Vec3(0,0,0);
            segmentVelocities[i] = new Vec3(0, 0, 0);
        }
        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;
        this.maxDistance = maxDistance;
    }
    public Vec3[] getEntities() {
        return entities;
    }

    public Vec3 applyYaw(Vec3 offset) {
        float yawRad = owner.getYRot() * Mth.DEG_TO_RAD;
        return offset.yRot(-yawRad - Mth.HALF_PI);
    }

    public Vec3 getLegBasePos() {
        Vec3 pivot = owner.position();
        Vec3 extend = isOwnerMoving() ? new Vec3(1,0,0) : Vec3.ZERO;
        return pivot.add(applyYaw(defaultLimbOffset.add(extend)));
    }

    public Vec3 getBodyOffset() {
        Vec3 pivot = owner.position();
        return pivot.add(applyYaw(defaultBodyOffset));
    }
    protected Vec3 applySwimCircle(Vec3 baseTipPos) {
        if (!isOwnerMoving()) return baseTipPos;
        swimAngle += swimSpeed;
        swimAngle = Mth.wrapDegrees(swimAngle);

        float rad = swimAngle * Mth.DEG_TO_RAD;
        if (owner.isInWater()){
            double x = Math.cos(rad) * 7;
            double y = Math.sin(rad) * 3.5f;
            Vec3 circularOffset = new Vec3(-x, y, 0);
            circularOffset = applyYaw(circularOffset);

            return baseTipPos.add(circularOffset);
        }
        double x = Math.cos(rad) * 3.5;
        Vec3 circularOffset = new Vec3(-x, 0, 0);
        circularOffset = applyYaw(circularOffset);
        return baseTipPos.add(circularOffset);
    }
    protected void moveSegmentTowards(int index, Vec3 target,boolean far) {
        Vec3 currentPos = entities[index];
        Vec3 newPos = currentPos.lerp(target, 0.5f);
        entities[index] = (far ? target : newPos);
    }
    protected void moveTipTowards(Vec3 target) {
        int tip = entities.length - 1;
        Vec3 currentPos = entities[tip];
        entities[tip] = currentPos.lerp(target, 0.35f);
    }
    protected boolean isOwnerMoving(){
        return owner.getDeltaMovement().lengthSqr() > 0.005;
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
    protected void applyBodySpin() {
        if (Math.abs(yawDelta) < 0.001f) return;
        Vec3 pivot = owner.position();

        for (int i = 0; i < entities.length; i++) {
            entities[i] = rotateAroundYaw(entities[i], pivot, yawDelta);
        }

        if (sitPosition != null) {
            sitPosition = rotateAroundYaw(sitPosition, pivot, yawDelta);
        }

        if (lastSitPosition != null) {
            lastSitPosition = rotateAroundYaw(lastSitPosition, pivot, yawDelta);
        }

        for (int i = 0; i < segmentVelocities.length; i++) {
            segmentVelocities[i] =
                    segmentVelocities[i].yRot((float)(-yawDelta * Mth.DEG_TO_RAD));
        }
    }

    protected void applyEntityMovementToLegs() {
        if (ownerMovementDelta.lengthSqr() < 0.00001){
            Vec3 defaultTipPos = getLegBasePos();
            int tip = entities.length - 1;
            Vec3 currentPos = entities[tip];
            entities[tip] = currentPos.lerp(defaultTipPos, 0.1f);
            return;
        }

        int last = entities.length - 1;

        for (int i = 0; i < entities.length; i++) {
            float t = (float) i / last;
            float followStrength = Mth.lerp(t, 0.5f, 0.05f);
            float drag = Mth.lerp(t, 0.90f, 0.65f);

            segmentVelocities[i] = segmentVelocities[i]
                    .add(ownerMovementDelta.scale(followStrength));

            segmentVelocities[i] = segmentVelocities[i].scale(drag);

            entities[i] = entities[i].add(segmentVelocities[i]);
        }

        if (sitPosition != null) sitPosition = sitPosition.add(ownerMovementDelta);
        if (lastSitPosition != null) lastSitPosition = lastSitPosition.add(ownerMovementDelta);
    }

    public void applyIK() {
        if (entities.length == 0) return;

        Vec3 basePos = getBodyOffset();
        Vec3 defaultTipPos = sitPosition == null ? getLegBasePos() : sitPosition;
        defaultTipPos = applySwimCircle(defaultTipPos);
        updateOwnerMovementDelta();
        applyEntityMovementToLegs();
        applyBodySpin();
        moveTipTowards(defaultTipPos);
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
            moveSegmentTowards(i, solvedPos, entities[i+1].distanceTo(entities[i]) > 5);
        }
        entities[0] = basePos;

        for (int i = 1; i < entities.length; i++) {
            Vec3 prevPos = entities[i - 1];
            Vec3 dir = entities[i].subtract(prevPos);

            float segmentLength = 2.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(i, solvedPos, entities[i-1].distanceTo(entities[i]) > 5);
        }
    }


}
