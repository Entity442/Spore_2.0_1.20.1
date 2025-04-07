package com.Harbinger.Spore.Sentities.BaseEntities;

import net.minecraft.world.phys.Vec3;

public class HohlMultipart extends CalamityMultipart{
    private final Vec3 desiredLocation;
    private final float inflation;
    public HohlMultipart(Calamity parent, String name, float s, float s2, Vec3 desiredLocation, float inflation) {
        super(parent, name, s, s2);
        this.desiredLocation = desiredLocation;
        this.inflation = inflation;
        this.moveTo(parent.position());
    }

    public float getInflation(){return inflation;}
    public Vec3 calculatedLocation(Vec3 localOffset) {
        Vec3 vec3 = calculateSpinVector(localOffset);
        Vec3 vec4 = new Vec3(this.parentMob.getX() + vec3.x, this.parentMob.getY() + vec3.y, this.parentMob.getZ() + vec3.z);
        return this.position().lerp(vec4,0.1f);
    }
    public Vec3 calculateSpinVector(Vec3 spin){
        return (spin).yRot(-parentMob.getYRot() * ((float)Math.PI / 180F) - ((float)Math.PI / 2F));
    }

    public Vec3 getDesiredLocation() {
        return desiredLocation;
    }

    public void tickMovement(int time, int segmentIndex) {
        if (this.position().equals(Vec3.ZERO)) {
            this.moveTo(parentMob.position());
        }
        float frequency = 0.15f;
        float amplitude = 0.2f;
        float wave = (float)Math.sin((time * frequency) - (segmentIndex * 0.5f)) * amplitude;
        Vec3 waveOffset = new Vec3(wave, 0, wave);
        Vec3 targetPos = calculatedLocation(desiredLocation).add(waveOffset);
        float smoothFactor = 0.05f + (segmentIndex * 0.05f);
        Vec3 newPos = this.position().lerp(targetPos, smoothFactor);
        this.moveTo(newPos);
        Vec3 motion = targetPos.subtract(this.position());
        float yaw = (float)(Math.atan2(motion.z, motion.x) * (180F / Math.PI)) - 90F;
        this.setYRot(yaw);
    }
}
