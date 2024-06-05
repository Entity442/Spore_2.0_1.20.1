package com.Harbinger.Spore.Sentities.Organoids;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.BaseEntities.Organoid;
import com.Harbinger.Spore.Sentities.EvolvedInfected.Knight;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class Verwa extends Organoid {
    public static final EntityDataAccessor<String> STORED_MOB = SynchedEntityData.defineId(Verwa.class, EntityDataSerializers.STRING);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(Verwa.class, EntityDataSerializers.INT);
    public AnimationState burst = new AnimationState();
    private int burstTimeout = 0;
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
        return new Knight(Sentities.KNIGHT.get(),this.level());
    }
    public void TickTimer(){
        this.entityData.set(TIMER,this.entityData.get(TIMER) +1);
        if (this.entityData.get(TIMER) > 40 && this.level().isClientSide){
            this.ClientAnimation();
        }
        if (this.entityData.get(TIMER) > 80){
            this.entityData.set(TIMER ,-1);
            SummonStoredEntity();
            this.tickBurrowing();
        }
    }

    public void SummonStoredEntity(){
        Entity entity = this.getStoredEntity();
        if (entity instanceof LivingEntity living){
            for (String string : SConfig.SERVER.verwa_effect.get()){
                MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string));
                if (effect != null){
                    living.addEffect(new MobEffectInstance(effect,600,1));
                }
            }
            if (living instanceof Infected infected){
                infected.setLinked(true);
            }
        }
        entity.moveTo(this.getX(),this.getY(),this.getZ());
        this.level().addFreshEntity(entity);
    }
    public void ClientAnimation(){
        if (this.burstTimeout <= 0) {
            this.burstTimeout = 40;
            this.burst.start(this.tickCount);
        } else {
            --this.burstTimeout;
        }
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
        }else{
            tickBurrowing();
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
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.verwa_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ARMOR, SConfig.SERVER.verwa_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    @Nullable
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance p_33283_, MobSpawnType p_33284_, @Nullable SpawnGroupData p_33285_, @Nullable CompoundTag p_33286_) {
        int i = SConfig.SERVER.verwa_summons.get().size();
        this.entityData.set(STORED_MOB,SConfig.SERVER.verwa_summons.get().get(this.random.nextInt(i)));
        return super.finalizeSpawn(serverLevelAccessor, p_33283_, p_33284_, p_33285_, p_33286_);
    }
}
