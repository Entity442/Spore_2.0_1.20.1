package com.Harbinger.Spore.Sentities.AI.LocHiv;

import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
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
        return infected.isAlive() && infected.getKills() > 0 && infected.getRandom().nextInt(10) == 0;
    }

    @Override
    public void tick() {
        super.tick();
        if (infected.getKills() > 0){
            if (infected.getHealth() < infected.getMaxHealth()){
                if (!infected.hasEffect(MobEffects.REGENERATION)){
                    infected.addEffect(new MobEffectInstance(MobEffects.REGENERATION,200,0));
                    infected.setKills(infected.getKills() - 1);
                }
            }
            if (infected.getLastDamageSource() == infected.damageSources().drown()){
                if (!infected.hasEffect(MobEffects.WATER_BREATHING)){
                    infected.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING,100,0));
                    infected.setKills(infected.getKills() - 1);
                }
            }
            if (infected.getRandom().nextInt(40) == 0 && infected.getKills() > 2){
                if (!infected.hasEffect(MobEffects.MOVEMENT_SPEED) && infected.getTarget() != null && infected.distanceToSqr(infected.getTarget()) > 200){
                    infected.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200,1));
                    infected.setKills(infected.getKills() - 1);
                }
                if (!infected.hasEffect(MobEffects.DAMAGE_BOOST) && infected.getTarget() != null && infected.distanceToSqr(infected.getTarget()) < 60){
                    infected.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,100,0));
                    infected.setKills(infected.getKills() - 1);
                }
            }
        }
    }
}
