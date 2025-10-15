package com.Harbinger.Spore.Sentities.Organoids;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;

public class TentaclePart extends PartEntity<Tentacle> {
    public final Tentacle parent;
    public final String name;
    protected final EntityDimensions size;
    public Vec3 position;
    public Vec3 prevPosition;
    public final float length;
    public TentaclePart(Tentacle parent, String name, EntityDimensions size, float length) {
        super(parent);
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.length = length;
        this.position = parent.position();
        this.prevPosition = this.position;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {

    }
    public boolean is(Entity entity) {
        return this == entity || this.parent == entity;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    public EntityDimensions getDimensions(Pose p_31023_) {
        return this.size;
    }

    public boolean shouldBeSaved() {
        return false;
    }

    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() == this.parent){
            return false;
        }
        return !this.isInvulnerableTo(source) && this.parent.hurt(this,source, amount);
    }

    public void smoothMove(Vec3 target,float time,int segmentIndex) {
        this.prevPosition = this.position;
        float frequency = 0.25f; // Controls speed of wave
        float amplitude = 0.1f; // Controls how much it wiggles

        float waveOffset = (float) Math.sin(time * frequency + segmentIndex * 0.5f) * amplitude;
        this.position = this.position.lerp(target, 0.2f).add(new Vec3(waveOffset, 0, waveOffset));
    }
}
