package com.Harbinger.Spore.Sentities.FallenMultipart;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.FallenMultipartEntity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

import java.util.List;

public class SiegerTail extends FallenMultipartEntity {
    public static final EntityDataAccessor<Boolean> WAR = SynchedEntityData.defineId(SiegerTail.class, EntityDataSerializers.BOOLEAN);
    public SiegerTail(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.sieger_tail_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.sieger_hp.get()/4) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.sieger_armor.get()/4) * SConfig.SERVER.global_armor.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(WAR, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("war", entityData.get(WAR));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(WAR, tag.getBoolean("war"));
    }
    public boolean getWar(){
        return entityData.get(WAR);
    }
    public void setWar(boolean i){
        entityData.set(WAR,i);
    }
}
