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

public class HowitzerArm extends FallenMultipartEntity {
    public static final EntityDataAccessor<Boolean> RIGHT = SynchedEntityData.defineId(HowitzerArm.class, EntityDataSerializers.BOOLEAN);
    public static final EntityDataAccessor<Boolean> NUCLEAR = SynchedEntityData.defineId(HowitzerArm.class, EntityDataSerializers.BOOLEAN);
    public HowitzerArm(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.howit_hp.get()/4) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.howit_armor.get()/4) * SConfig.SERVER.global_armor.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.howit_foot_loot.get();
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RIGHT, true);
        this.entityData.define(NUCLEAR, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("right", entityData.get(RIGHT));
        tag.putBoolean("nuclear", entityData.get(NUCLEAR));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(RIGHT, tag.getBoolean("right"));
        entityData.set(NUCLEAR, tag.getBoolean("nuclear"));
    }
    public boolean getRight(){
        return entityData.get(RIGHT);
    }
    public void setRight(boolean i){
        entityData.set(RIGHT,i);
    }
    public boolean getNuclear(){
        return entityData.get(NUCLEAR);
    }
    public void setNuclear(boolean i){
        entityData.set(NUCLEAR,i);
    }
}
