package com.Harbinger.Spore.Sentities.BaseEntities;

import com.Harbinger.Spore.Sentities.TrueCalamity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraftforge.entity.PartEntity;

public class CalamityMultipart extends PartEntity<Calamity> {
    public final Calamity parentMob;
    public final String name;
    protected final EntityDimensions size;
    public CalamityMultipart(Calamity parent, String name, float s , float s2) {
        super(parent);
        this.size = EntityDimensions.scalable(s, s2);
        this.refreshDimensions();
        this.parentMob = parent;
        this.name = name;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    public boolean isPickable() {
        return true;
    }

    public boolean is(Entity entity) {
        return this == entity || this.parentMob == entity;
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
        if (source.getEntity() == this.parentMob){
            return false;
        }
        if (this.parentMob instanceof TrueCalamity calamity){
            return !this.isInvulnerableTo(source) && calamity.hurt(this,source, amount);
        }
        return !this.isInvulnerableTo(source) && this.parentMob.hurt(source, amount);
    }
}
