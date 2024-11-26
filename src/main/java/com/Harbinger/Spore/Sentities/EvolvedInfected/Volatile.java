package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.VolatileSwellGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Volatile extends EvolvedInfected {
    private static final EntityDataAccessor<Integer> DATA_SWELL_DIR = SynchedEntityData.defineId(Volatile.class, EntityDataSerializers.INT);
    public Volatile(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }
    private int swell;
    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1,new VolatileSwellGoal(this));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this, 1.5, false) {
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 6.0 + entity.getBbWidth() * entity.getBbWidth();}});

        this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));

        super.registerGoals();
    }

    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_volatile_loot.get();
    }
    public void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_SWELL_DIR, -1);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.vola_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.3)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.vola_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.vola_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        List<? extends String> ev = SConfig.SERVER.vola_buffs.get();
        int randomIndex = this.random.nextInt(ev.size());
        ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
        MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
        if (randomElement != null){
            this.addEffect(new MobEffectInstance(randomElement,600,0));
        }
        return super.hurt(source, amount);
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        List<? extends String> ev = SConfig.SERVER.vola_debuffs.get();
        int randomIndex = this.random.nextInt(ev.size());
        ResourceLocation randomElement1 = new ResourceLocation(ev.get(randomIndex));
        MobEffect randomElement = ForgeRegistries.MOB_EFFECTS.getValue(randomElement1);
        if (randomElement != null && entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(randomElement,600,0));
        }
        return super.doHurtTarget(entity);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ZOMBIE_STEP;
    }

    protected void playStepSound(BlockPos p_34316_, BlockState p_34317_) {
        this.playSound(this.getStepSound(), 0.15F, 1.0F);
    }


    public int getSwellDir() {
        return this.entityData.get(DATA_SWELL_DIR);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.isAlive()) {

            int i = this.getSwellDir();
            if (i > 0 && this.swell == 0) {
                this.playSound(SoundEvents.CREEPER_PRIMED, 1.0F, 0.5F);
                this.gameEvent(GameEvent.PRIME_FUSE);
            }

            this.swell += i;
            if (this.swell < 0) {
                this.swell = 0;
            }

            if (this.swell >= 40) {
                this.swell = 40;
                this.explodeVolatile();
            }
        }
    }

    private void explodeVolatile() {
        if (!this.level().isClientSide) {
            Level.ExplosionInteraction explosion$blockinteraction = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.level(), this) ? Level.ExplosionInteraction.MOB : Level.ExplosionInteraction.NONE;
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), SConfig.SERVER.volatile_explosion.get(), explosion$blockinteraction);
            discard();
                AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.level(), this.getX(), this.getY(), this.getZ());
                areaeffectcloud.setRadius(5.5F);
                areaeffectcloud.setRadiusOnUse(-0.5F);
                areaeffectcloud.setWaitTime(20);
                for (String string : SConfig.SERVER.vola_debuffs.get()){
                    MobEffect effect = ForgeRegistries.MOB_EFFECTS.getValue(new ResourceLocation(string));
                    if (effect != null){
                        areaeffectcloud.addEffect(new MobEffectInstance(effect,600,1));
                    }
                }
                areaeffectcloud.setDuration(areaeffectcloud.getDuration() / 2);
                areaeffectcloud.setRadiusPerTick(-areaeffectcloud.getRadius() / (float) areaeffectcloud.getDuration());
                this.level().addFreshEntity(areaeffectcloud);
        }
    }

    public void setSwellDir(int i) {
        this.entityData.set(DATA_SWELL_DIR,i);
    }
}
