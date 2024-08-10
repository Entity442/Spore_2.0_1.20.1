package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.SConfig;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Sentities.BaseEntities.EvolvedInfected;
import com.Harbinger.Spore.Sentities.BaseEntities.Infected;
import com.Harbinger.Spore.Sentities.EvolvingInfected;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class MutagenicReactant extends Enchantment {
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
        }
        super.doPostAttack(livingEntity, entity, value);
    }

    @Override
    public void doPostHurt(LivingEntity livingEntity, Entity entity, int value) {
        if (livingEntity instanceof ServerPlayer serverPlayer)
        livingEntity.getArmorSlots().forEach(stack -> {stack.hurt(50,livingEntity.getRandom(),serverPlayer);});
        super.doPostAttack(livingEntity, entity, value);
    }
}
