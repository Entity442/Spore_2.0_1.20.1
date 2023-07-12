package com.Harbinger.Spore.Effect;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class Starvation extends MobEffect {
    public Starvation() {
        super(MobEffectCategory.HARMFUL, 34613);
    }

    public void applyEffectTick(LivingEntity entity, int intense) {
        if (entity instanceof Infected){
            if (this == Seffects.STARVATION.get()) {
                    entity.hurt(entity.damageSources().generic(), 1.0F);
                }
            }
    }


    public boolean isDurationEffectTick(int duration, int intensity) {
        if (this == Seffects.STARVATION.get()) {
            int i = 80 >> intensity;
            if (i > 0) {
                return duration % i == 0;
            } else {
                return true;
            }
        }
        return false;
    }
}
