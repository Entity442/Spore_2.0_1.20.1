package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Senchantments;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class CorrosivePotency extends Enchantment {
    public CorrosivePotency(EquipmentSlot... slots) {
        super(Rarity.COMMON, Senchantments.FUNGAL_ITEMS, slots);
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int value) {
        super.doPostAttack(livingEntity, entity, value);
        if (entity instanceof LivingEntity livingEntity1){
            livingEntity1.addEffect(new MobEffectInstance(Seffects.CORROSION.get(),60,1));
        }
    }
}
