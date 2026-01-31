package com.Harbinger.Spore.Sentities.BaseEntities.IkUtil;

import com.Harbinger.Spore.Sentities.Calamities.Grakensenker;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;


public class IkKrakenLeg {
    protected final RandomSource randomSource = RandomSource.create();
    protected final Grakensenker owner;
    protected final Vec3[] entities;
    protected int[] segmentVar;
    protected final Vec3 defaultBodyOffset;
    protected final Vec3 defaultLimbOffset;
    protected final float maxDistance;
    protected final float[] wiggleTimers;
    protected final float[] wiggleSpeeds;
    protected final float[] wiggleAmplitudes;
    protected final float[] wiggleOffsets;
    protected final Vec3[] segmentVelocities;
    protected Vec3 sitPosition =  null;
    protected Vec3 lastSitPosition = null;
    protected int stepUpTicks = 0;
    protected Vec3 lastOwnerPosition = Vec3.ZERO;
    protected Vec3 ownerMovementDelta = Vec3.ZERO;
    public IkKrakenLeg(Grakensenker owner, int amount, Vec3 defaultBodyOffset,
                       Vec3 defaultLimbOffset,
                       float maxDistance) {
        this.owner = owner;
        this.entities = new Vec3[amount];
        this.segmentVar = new int[amount];
        this.wiggleTimers = new float[amount];
        this.wiggleSpeeds = new float[amount];
        this.wiggleAmplitudes = new float[amount];
        this.wiggleOffsets = new float[amount];
        this.segmentVelocities = new Vec3[amount];
        for(int i = 0;i<amount;i++){
            entities[i] = new Vec3(0,0,0);
            segmentVar[i] = randomSource.nextInt(12);
            wiggleSpeeds[i] = 0.5f + randomSource.nextFloat() * getWiggleSpeed();
            wiggleAmplitudes[i] = 0.02f + randomSource.nextFloat() * getWiggleAmplitude();
            wiggleOffsets[i] = randomSource.nextFloat() * (float)Math.PI * 2;
            wiggleTimers[i] = randomSource.nextFloat() * 100;
            segmentVelocities[i] = new Vec3(0, 0, 0);
        }
        this.defaultBodyOffset = defaultBodyOffset;
        this.defaultLimbOffset = defaultLimbOffset;
        this.maxDistance = maxDistance;
    }
    public float getWiggleSpeed(){
        return 0.75f;
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
    public int[] getSegmentVar(){
        return segmentVar;
    }
    public void writeVariants(CompoundTag tag,int ikN){
        tag.putIntArray("variants"+ikN,segmentVar);
    }
    public void readVariants(CompoundTag tag,int ikN){
        segmentVar = tag.getIntArray("variants"+ikN);
    }

    public Vec3 applyYaw(Vec3 offset) {
        float yawRad = owner.getYRot() * Mth.DEG_TO_RAD;
        float spinRad = owner.getWaterTicks() * 0.05f;

        return offset.yRot(-yawRad - Mth.HALF_PI + spinRad);
    }

    public Vec3 getLegBasePos() {
        Vec3 pivot = owner.position();
        return pivot.add(applyYaw(defaultLimbOffset));
    }

    public Vec3 getBodyOffset() {
        Vec3 pivot = owner.position().add(0, owner.getExtendedHeight(), 0);
        return pivot.add(applyYaw(defaultBodyOffset));
    }

    protected void moveSegmentTowards(int index, Vec3 target,boolean far) {
        Vec3 currentPos = entities[index];
        Vec3 newPos = currentPos.lerp(target,owner.isInDeepWater() ? 0.5f : 0.35f);
        entities[index] = (far ? target : newPos);
    }
    protected void moveTipTowards(Vec3 target) {
        int tip = entities.length - 1;
        Vec3 currentPos = entities[tip];
        entities[tip] = currentPos.lerp(target, 0.15f);
    }
    protected boolean isOwnerMoving(){
        return owner.getDeltaMovement().lengthSqr() > 0.005;
    }

    protected void updateOwnerMovementDelta() {
        Vec3 currentOwnerPos = owner.position();
        ownerMovementDelta = currentOwnerPos.subtract(lastOwnerPosition);
        lastOwnerPosition = currentOwnerPos;
    }

    protected void applyEntityMovementToLegs() {
        boolean inWater = owner.isInDeepWater();
        if (ownerMovementDelta.lengthSqr() < 0.00001){
            if (inWater){
                Vec3 defaultTipPos = getLegBasePos();
                int tip = entities.length - 1;
                Vec3 currentPos = entities[tip];
                entities[tip] = currentPos.lerp(defaultTipPos, 0.1f);
            }
            return;
        }

        int last = entities.length - 1;
        int val = inWater ? 0 : 1;

        for (int i = 0; i < entities.length-val; i++) {
            float t = (float) i / last;
            float followStrength = Mth.lerp(t, 0.5f, 0.05f);
            float drag = inWater
                    ? Mth.lerp(t, 0.90f, 0.65f)
                    : Mth.lerp(t, 0.90f, 0.1f);

            segmentVelocities[i] = segmentVelocities[i]
                    .add(ownerMovementDelta.scale(followStrength));

            segmentVelocities[i] = segmentVelocities[i].scale(drag);

            entities[i] = entities[i].add(segmentVelocities[i]);
        }

        if (sitPosition != null) sitPosition = sitPosition.add(ownerMovementDelta);
        if (lastSitPosition != null) lastSitPosition = lastSitPosition.add(ownerMovementDelta);
    }

    public void applyIK() {
        if (entities == null || entities.length == 0) return;

        Vec3 basePos = getBodyOffset();
        Vec3 defaultTipPos = sitPosition == null ? getLegBasePos() : sitPosition;
        updateOwnerMovementDelta();
        applyEntityMovementToLegs();
        if (!owner.isInDeepWater()){
            float jumpVal = 1.5f;
            boolean val = stepUpTicks > 0 && isOwnerMoving();
            if (val){
                for (int i = 1; i < entities.length; i++) {
                    Vec3 vec3 = entities[i];
                    entities[i] = vec3.lerp(vec3.add(0,jumpVal,0), 0.05f);
                }
            }else {
                moveTipTowards(defaultTipPos);
            }
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
        applyIdleWiggle();
        updateWiggleTimers();
        if (stepUpTicks > 0){
            stepUpTicks--;
        }
    }


    public void refreshLegStandingPoint(){
        if (owner.isInDeepWater()){
            return;
        }
        if (lastSitPosition != null && getLegBasePos().distanceTo(lastSitPosition) < maxDistance){
            return;
        }
        sitPosition = findStableFooting();
        if (!sitPosition.equals(lastSitPosition)){
            stepUpTicks = 10;
            lastSitPosition = sitPosition;
        }
    }

    protected Vec3 findStableFooting() {
        Level level = owner.level();

        if (level.isClientSide()) {
            return getLegBasePos();
        }

        Vec3 worldBasePos = getLegBasePos();
        int searchRadius = 6;
        int maxSearchDown = 12;
        int maxSearchUp = 6;

        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();

        for (int y = 0; y >= -maxSearchDown; y--) {
            checkPos.set(worldBasePos.x, worldBasePos.y + y, worldBasePos.z);

            if (isSolidGround(level, checkPos)) {
                return new Vec3(
                        checkPos.getX() + 0.5,
                        checkPos.getY() - 1.0,
                        checkPos.getZ() + 0.5
                );
            }
        }

        for (int x = -searchRadius; x <= searchRadius; x++) {
            for (int z = -searchRadius; z <= searchRadius; z++) {
                for (int y = maxSearchUp; y >= -maxSearchDown; y--) {
                    checkPos.set(
                            worldBasePos.x + x,
                            worldBasePos.y + y,
                            worldBasePos.z + z
                    );

                    if (isSolidGround(level, checkPos)) {
                        if (level.isEmptyBlock(checkPos.above())) {
                            return new Vec3(
                                    checkPos.getX() + 0.5,
                                    checkPos.getY() - 1.0,
                                    checkPos.getZ() + 0.5
                            );
                        }
                    }
                }
            }
        }
        return worldBasePos;
    }

    private boolean isSolidGround(Level level, BlockPos pos) {
        return level.getBlockState(pos).isSolid() ||
                !level.getBlockState(pos).getCollisionShape(level, pos).isEmpty();
    }

}
