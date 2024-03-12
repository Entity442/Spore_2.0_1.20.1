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
import net.minecraftforge.fluids.FluidType;

import java.util.List;

public class Licker extends FallenMultipartEntity {
    public static final EntityDataAccessor<Boolean> BURNED = SynchedEntityData.defineId(Licker.class, EntityDataSerializers.BOOLEAN);
    public Licker(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BURNED, false);
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("burned", entityData.get(BURNED));
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(BURNED, tag.getBoolean("burned"));
    }
    public boolean getBurned(){
        return entityData.get(BURNED);
    }
    public void setBurned(boolean i){
        entityData.set(BURNED,i);
    }

    @Override
    public boolean fireImmune() {
        return getBurned();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.gazen_tongue_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, (SConfig.SERVER.gazen_hp.get()/6) * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, (SConfig.SERVER.gazen_armor.get()/4) * SConfig.SERVER.global_armor.get())
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);
    }

    @Override
    public boolean canDrownInFluidType(FluidType type) {
        return false;
    }
}
