package com.Harbinger.Spore.Sentities.BasicInfected;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class InfectedDiseasedVillager extends InfectedVillager{
    public InfectedDiseasedVillager(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        if (entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.POISON,200,0));
        }
        return super.doHurtTarget(entity);
    }
}
