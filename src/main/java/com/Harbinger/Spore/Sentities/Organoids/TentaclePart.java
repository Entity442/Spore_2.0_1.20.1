package com.Harbinger.Spore.Sentities.Organoids;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.entity.PartEntity;

public class TentaclePart extends PartEntity<Tentacle> {
    public final Tentacle parent;
    public final String name;
    protected final EntityDimensions size;
    public final float length;

    public TentaclePart(Tentacle parent, String name, EntityDimensions size, float length) {
        super(parent);
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.length = length;
        this.setPos(parent.getX(), parent.getY(), parent.getZ());
        this.refreshDimensions();
    }

    @Override
    protected void defineSynchedData() {
        // no synched data needed; position is updated by parent
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        // These parts do not persist between world loads
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        // No-op — tentacle parts are recreated by parent
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        return this.size;
    }

    @Override
    public boolean is(Entity entity) {
        return this == entity || this.parent == entity;
    }

    @Override
    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        // These parts are not added separately; the parent syncs them
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (source.getEntity() == this.parent) {
            return false;
        }
        return !this.isInvulnerableTo(source) && this.parent.hurt(this, source, amount);
    }
}
