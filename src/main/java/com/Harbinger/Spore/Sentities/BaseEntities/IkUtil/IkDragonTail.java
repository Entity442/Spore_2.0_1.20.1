package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;


public class IkDragonTail {
    protected final RandomSource randomSource = RandomSource.create();
    protected final LivingEntity owner;
    protected final Vec3[] entities;
    protected final Vec3 defaultBodyOffset;
    protected final Vec3 defaultLimbOffset;
    protected final float[] wiggleTimers;
    protected final float[] wiggleSpeeds;
    protected final float[] wiggleAmplitudes;
    protected final float[] wiggleOffsets;
    protected final Vec3[] segmentVelocities;
    protected Vec3 sitPosition =  null;
    protected Vec3 lastSitPosition = null;
    protected Vec3 lastOwnerPosition = Vec3.ZERO;
    protected Vec3 ownerMovementDelta = Vec3.ZERO;
    protected float lastYaw = 0;
    protected float yawDelta = 0;
    public IkDragonTail(LivingEntity owner, int amount, Vec3 defaultBodyOffset,
                        Vec3 defaultLimbOffset) {
        this.owner = owner;
        this.entities = new Vec3[amount];
        this.wiggleTimers = new float[amount];
        this.wiggleSpeeds = new float[amount];
        this.wiggleAmplitudes = new float[amount];
        this.wiggleOffsets = new float[amount];
        this.segmentVelocities = new Vec3[amount];
        for(int i = 0;i<amount;i++){
            entities[i] = new Vec3(0,0,0);
            wiggleSpeeds[i] = 0.5f + randomSource.nextFloat() * getWiggleSpeed();
            wiggleAmplitudes[i] = 0.02f + randomSource.nextFloat() * getWiggleAmplitude();
            wiggleOffsets[i] = randomSource.nextFloat() * (float)Math.PI * 2;
            wiggleTimers[i] = randomSource.nextFloat() * 100;
            segmentVelocities[i] = new Vec3(0, 0, 0);
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

    protected void moveSegmentTowards(int index, Vec3 target,boolean far) {
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
        return owner.getDeltaMovement().lengthSqr() > 0.005;
    }


    public void applyIK() {
        updateOwnerMovementDelta();
        if (entities == null || entities.length == 0) return;
        Vec3 basePos = getBodyOffset();
        Vec3 defaultTipPos = sitPosition == null ?  getHeadBasePos() : sitPosition;
        if (!isOwnerMoving()){
            moveTipTowards(defaultTipPos);
        }
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

            float segmentLength = 1.0f;
            if (dir.lengthSqr() > 0.0001f) {
                dir = dir.normalize().scale(segmentLength);
            } else {
                dir = new Vec3(segmentLength, 0, 0);
            }

            Vec3 solvedPos = prevPos.add(dir);
            moveSegmentTowards(i, solvedPos, entities[i-1].distanceTo(entities[i]) > 5);
        }
        applyBodySpin();
        applyIdleWiggle();
        updateWiggleTimers();
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
}
