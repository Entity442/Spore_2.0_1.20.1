package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Fluids.BileLiquid;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class GastricSpewage extends Enchantment {
    public GastricSpewage(EquipmentSlot... slots) {
        super(Rarity.VERY_RARE, Senchantments.FUNGAL_ITEMS, slots);
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int value) {
        super.doPostAttack(livingEntity, entity, value);
        if (entity instanceof LivingEntity livingEntity1){
            for (MobEffectInstance instance : BileLiquid.bileEffects()){
                livingEntity1.addEffect(instance);
            }
        }
    }
}
