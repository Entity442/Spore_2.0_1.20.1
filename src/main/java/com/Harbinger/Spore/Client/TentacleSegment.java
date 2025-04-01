package com.Harbinger.Spore.Client;

import net.minecraft.world.phys.Vec3;

public class TentacleSegment {
    public Vec3 position;
    public Vec3 prevPosition;
    public float rotation;
    public final float length;

    public TentacleSegment(Vec3 position, float length) {
        this.position = position;
        this.prevPosition = position;
        this.length = length;
    }

    public void smoothMove(Vec3 target,float time,int segmentIndex) {
        this.prevPosition = this.position;
        float frequency = 0.25f; // Controls speed of wave
        float amplitude = 0.1f; // Controls how much it wiggles

        float waveOffset = (float) Math.sin(time * frequency + segmentIndex * 0.5f) * amplitude;
        this.position = this.position.lerp(target, 0.2f).add(new Vec3(waveOffset, 0, waveOffset));
    }
}