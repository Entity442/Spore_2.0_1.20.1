package com.Harbinger.Spore.Sentities.Hyper;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.entity.PartEntity;

public class HevokerPart extends PartEntity<Hevoker> {
    public final Hevoker parentMob;
    public final String name;
    private final EntityDimensions size;

    public HevokerPart(Hevoker parent, String name,float s , float s2) {
        super(parent);
        this.parentMob = parent;
        this.name = name;
        this.size = EntityDimensions.scalable(s, s2);
        this.refreshDimensions();
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

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        return parentMob.interact(this,player,hand);
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
        return !this.isInvulnerableTo(source) && parentMob.hurt(this,source, amount);
    }
}
