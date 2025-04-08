package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Sentities.Calamities.Hohlfresser;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class HohlMultipart extends CalamityMultipart{
    private final Vec3 desiredLocation;
    private final float inflation;
    public HohlMultipart(Calamity parent, String name, float s, float s2, Vec3 desiredLocation, float inflation) {
        super(parent, name, s, s2);
        this.desiredLocation = desiredLocation;
        this.inflation = inflation;
        this.moveTo(parent.position());
    }
    public Vec3 calculateSpinVector(Vec3 spin) {
        float yaw = 0f;
        if (parentMob instanceof Hohlfresser f) {
            yaw = f.getBufferedYRot();
        } else {
            yaw = parentMob.getYRot();
        }
        return spin.yRot(-yaw * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
    }

    public float getInflation(){return inflation;}
    public Vec3 calculatedLocation(Vec3 localOffset) {
        Vec3 vec3 = calculateSpinVector(localOffset);
        return new Vec3(this.parentMob.getX() + vec3.x, this.parentMob.getY() + vec3.y, this.parentMob.getZ() + vec3.z);
    }

    public Vec3 getDesiredLocation() {
        return desiredLocation;
    }

    public void tickMovement(int time, int segmentIndex, @Nullable HohlMultipart previousSegment) {
        if (this.position().equals(Vec3.ZERO)) {
            this.moveTo(parentMob.position());
        }

        float frequency = 0.15f;
        float amplitude = 0.2f;
        float wave = (float)Math.sin((time * frequency) - (segmentIndex * 0.5f)) * amplitude;
        Vec3 waveOffset = new Vec3(0, wave, 0);

        Vec3 idealPos = calculatedLocation(desiredLocation).add(waveOffset);

        Vec3 targetPos;

        if (previousSegment != null) {
            float followStrength = 0.35f;
            targetPos = idealPos.lerp(previousSegment.position(), followStrength);
        } else {
            targetPos = idealPos;
        }

        double maxDistance = 2.5;
        if (this.position().distanceTo(targetPos) > maxDistance) {
            this.moveTo(targetPos);
        } else {
            float smoothFactor = 0.1f + (segmentIndex * 0.1f);
            this.moveTo(this.position().lerp(targetPos, smoothFactor));
        }
    }
}
