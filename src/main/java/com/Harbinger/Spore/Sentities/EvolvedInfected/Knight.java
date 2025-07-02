package com.Harbinger.Spore.Sentities.EvolvedInfected;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Damage.SdamageTypes;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import com.Harbinger.Spore.Sentities.Hyper.Inquisitor;
import com.Harbinger.Spore.Sentities.Hyper.Wendigo;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collection;
import java.util.List;

public class Knight extends EvolvedInfected implements EvolvingInfected {
    public Knight(EntityType<? extends Monster> p_33002_, Level p_33003_) {
        super(p_33002_, p_33003_);
    }
    @Override
    protected void registerGoals() {

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
        return SConfig.DATAGEN.inf_knight_loot.get();
    }
    @Override
    public DamageSource getCustomDamage(LivingEntity entity) {
        if (Math.random() < 0.3){
            return SdamageTypes.knight_damage(this);
        }
        return super.getCustomDamage(entity);
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.knight_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.knight_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.knight_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 32)
                .add(Attributes.ATTACK_KNOCKBACK, 1);

    }

    @Override
    public void tick() {
        super.tick();
        this.tickHyperEvolution(this);
    }

    protected SoundEvent getAmbientSound() {
        return Ssounds.INF_GROWL.get();
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

    @Override
    public void HyperEvolve(LivingEntity living) {
        Inquisitor inquisitor = new Inquisitor(Sentities.INQUISITOR.get(),this.level());
        Collection<MobEffectInstance> collection = this.getActiveEffects();
        for(MobEffectInstance mobeffectinstance : collection) {
            inquisitor.addEffect(new MobEffectInstance(mobeffectinstance));
        }
        inquisitor.setKills(this.getKills());
        inquisitor.setEvoPoints(this.getEvoPoints()-SConfig.SERVER.min_kills_hyper.get());
        inquisitor.setCustomName(this.getCustomName());
        inquisitor.setPos(this.getX(),this.getY(),this.getZ());
        if (this.level() instanceof ServerLevel serverLevel)
            inquisitor.finalizeSpawn(serverLevel,serverLevel.getCurrentDifficultyAt(this.getOnPos()), MobSpawnType.CONVERSION,null,null);
        this.level().addFreshEntity(inquisitor);
        this.discard();
        EvolvingInfected.super.HyperEvolve(living);
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        AttributeInstance armor = this.getAttribute(Attributes.ARMOR);
        if (armor != null && this.getHealth() < this.getMaxHealth()){
            double new_armor = (this.getMaxHealth()-this.getHealth())/2 + (SConfig.SERVER.knight_armor.get() * SConfig.SERVER.global_armor.get());
            armor.setBaseValue(new_armor);
        }
        return super.hurt(source, amount);
    }
}
