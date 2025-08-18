package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.Senchantments;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class VoraciousMaw extends BaseSporeEnchantment {
    public VoraciousMaw(EquipmentSlot... slots) {
        super(Rarity.COMMON, Senchantments.FUNGAL_ITEMS, slots);
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int value) {
        super.doPostAttack(livingEntity, entity, value);
        if (livingEntity.getItemBySlot(EquipmentSlot.HEAD).getEnchantmentLevel(this) > 0){
            if (Math.random() < 0.3f){
                livingEntity.playSound(SoundEvents.GENERIC_EAT);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.SATURATION,40,0));
            }
        }
    }
}
