package com.Harbinger.Spore.Sentities.Utility;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Ssounds;
import com.Harbinger.Spore.Sentities.AI.CustomMeleeAttackGoal;
import com.Harbinger.Spore.Sentities.AI.PullGoal;
import com.Harbinger.Spore.Sentities.BaseEntities.UtilityEntity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.level.Level;

import java.util.List;

public class InfEvoClaw extends UtilityEntity implements Enemy{
    public InfEvoClaw(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }
    @Override
    protected void registerGoals() {
        this.addTargettingGoals();

        this.goalSelector.addGoal(4,new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new CustomMeleeAttackGoal(this ,0 ,false){
            @Override
            protected double getAttackReachSqr(LivingEntity entity) {
                return 8.0 + entity.getBbWidth() * entity.getBbWidth();}});
        this.goalSelector.addGoal(2, new PullGoal(this, 64, 4));

        super.registerGoals();
    }
    @Override
    public List<? extends String> getDropList() {
        return SConfig.DATAGEN.inf_claw_loot.get();
    }
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, SConfig.SERVER.inf_claw_hp.get() * SConfig.SERVER.global_health.get())
                .add(Attributes.ATTACK_DAMAGE, SConfig.SERVER.inf_claw_damage.get() * SConfig.SERVER.global_damage.get())
                .add(Attributes.ARMOR, SConfig.SERVER.inf_claw_armor.get() * SConfig.SERVER.global_armor.get())
                .add(Attributes.FOLLOW_RANGE, 8)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1);

    }

    protected SoundEvent getHurtSound(DamageSource p_34327_) {
        return Ssounds.INF_DAMAGE.get();
    }

    protected SoundEvent getDeathSound() {
        return Ssounds.INF_DAMAGE.get();
    }


    public boolean doHurtTarget(Entity p_32257_) {
        if (super.doHurtTarget(p_32257_)) {
            if (p_32257_ instanceof LivingEntity) {
                ((LivingEntity)p_32257_).addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),  600, 0), this);
            }
            return true;
        } else {
            return false;
        }
    }

}
