package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvedInfected.InfectedEvoker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.goal.Goal;

public class BufferAI extends Goal {
    public Infected infected;
    public BufferAI(Infected infected1){
        this.infected = infected1;
    }
    @Override
    public boolean canUse() {
        return infected.isAlive() && infected.getKills() > SConfig.SERVER.min_kills.get() && infected.getRandom().nextInt(0,10) == 7;
    }

    @Override
    public void tick() {
        super.tick();
        if (infected.getHealth() < infected.getMaxHealth() && infected.getKills() > 1){
            if (!infected.hasEffect(MobEffects.REGENERATION)){
                infected.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200,0));
                infected.setKills(infected.getKills() - 1);
            }
        }
        if (infected.getLastDamageSource() == infected.damageSources().drown() && infected.getKills() > 1){
            if (!infected.hasEffect(MobEffects.WATER_BREATHING)){
                infected.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,100,0));
                infected.setKills(infected.getKills() - 1);
            }
        }
        if (infected instanceof EvolvedInfected evolved && evolved.getTarget() != null && infected.getRandom().nextInt(0,30) == 28){

            if (!evolved.hasEffect(MobEffects.MOVEMENT_SPEED) && evolved.getKills() >= 2 && evolved.isAggressive() && evolved.distanceToSqr(evolved.getTarget()) > 200){
                evolved.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200,1));
                evolved.setKills(evolved.getKills() - 2);
            }
            if (!evolved.hasEffect(MobEffects.DAMAGE_BOOST) && evolved.getKills() >= 2 && evolved.isAggressive() && evolved.distanceToSqr(evolved.getTarget()) < 60){
                evolved.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100,0));
                evolved.setKills(evolved.getKills() - 2);
            }
        }
        if (infected instanceof InfectedEvoker evoker && !evoker.hasArm() && evoker.getKills() >= 5 && infected.getRandom().nextInt(0,30) == 28){
            evoker.setArm(true);
            evoker.setKills(evoker.getKills() -5);
        }
    }
}
