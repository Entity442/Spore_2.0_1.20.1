package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.ArrayList;
import java.util.List;

public class MutagenicReactant extends BaseSporeEnchantment {
    public MutagenicReactant(EquipmentSlot... slots) {
        super(Rarity.COMMON, Senchantments.FUNGAL_ITEMS, slots);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int value) {
        if (Math.random() < 0.1 && entity instanceof Infected infected && infected instanceof EvolvingInfected evolvedInfected){
            if (evolvedInfected instanceof EvolvedInfected evolved){
                evolved.setEvolution(SConfig.SERVER.evolution_age_human.get());
                evolved.setEvoPoints(evolved.getEvoPoints()+SConfig.SERVER.min_kills_hyper.get());
            }else{
                infected.setEvolution(SConfig.SERVER.evolution_age_human.get());
                infected.setEvoPoints(infected.getEvoPoints()+SConfig.SERVER.min_kills.get());
            }
            if(livingEntity instanceof Player player){
                player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel()/2);
            }
        }
        super.doPostAttack(livingEntity, entity, value);
    }

    @Override
    public void doPostHurt(LivingEntity livingEntity, Entity entity, int value) {
        if (Math.random() < 0.2){
            livingEntity.getArmorSlots().forEach(stack -> {
                if (stack.getEnchantmentLevel(this) > 0){
                    MobEffectInstance effect = badMutations().get(livingEntity.getRandom().nextInt(badMutations().size()));
                    livingEntity.addEffect(effect);
                }
            });
        }
        super.doPostAttack(livingEntity, entity, value);
    }

    public static List<MobEffectInstance> badMutations(){
        List<MobEffectInstance> values = new ArrayList<>();
        values.add(new MobEffectInstance(MobEffects.WEAKNESS,160,0));
        values.add(new MobEffectInstance(MobEffects.POISON,80,0));
        values.add(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,120,0));
        values.add(new MobEffectInstance(MobEffects.CONFUSION,200,0));
        return values;
    }
}
