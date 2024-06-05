package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class Verwa extends Organoid {
    public static final EntityDataAccessor<String> STORED_MOB = SynchedEntityData.defineId(Verwa.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Verwa.class, EntityDataSerializers.INT);
    public Verwa(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("timer",entityData.get(TIMER));
        tag.putString("stored_mob",entityData.get(STORED_MOB));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        entityData.set(TIMER, tag.getInt("timer"));
        entityData.set(STORED_MOB, tag.getString("stored_mob"));
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(TIMER,0);
        this.entityData.define(STORED_MOB,"spore:knight");
    }

    public Entity getStoredEntity(){
        ResourceLocation location = new ResourceLocation(this.entityData.get(STORED_MOB));
        EntityType<?> entityType = ForgeRegistries.ENTITY_TYPES.getValue(location);
        if (entityType != null){
            return entityType.create(this.level());
        }
        return null;
    }
    public void TickTimer(){
        this.entityData.set(TIMER,this.entityData.get(TIMER) +1);
        if (this.entityData.get(TIMER) > 60){
            this.entityData.set(TIMER ,-1);
            SummonStoredEntity();
            this.tickBurrowing();
        }
    }

    public void SummonStoredEntity(){
        Entity entity = this.getStoredEntity();
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.REGENERATION,100,1));
            if (living instanceof Infected infected){
                infected.setLinked(true);
            }
        }
        entity.moveTo(this.getX(),this.getY(),this.getZ());
        this.level().addFreshEntity(entity);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.isEmerging() && this.entityData.get(TIMER) >= 0){
            this.TickTimer();
        }
    }

    @Override
    public boolean hurt(DamageSource source, float p_21017_) {
        if (this.isEmerging()){
            return false;
        }
        return super.hurt(source, p_21017_);
    }

    @Override
    public int getEmerge_tick() {
        return 40;
    }

    @Override
    public int getBorrow_tick() {
        return 60;
    }

    @Override
    public void tickBurrowing(){
        int burrowing = this.entityData.get(BORROW);
        if (burrowing > this.getBorrow_tick()) {
            burrowing = -1;
            this.discard();
        }
        this.entityData.set(BORROW, burrowing + 1);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.reconstructor_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.reconstructor_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 16)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }
}
