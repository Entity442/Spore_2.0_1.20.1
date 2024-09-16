package com.Harbinger.Spore.Senchantments;

import com.Harbinger.Spore.Core.Seffects;
import com.Harbinger.Spore.Core.Senchantments;
import com.Harbinger.Spore.Core.Sentities;
import com.Harbinger.Spore.Sentities.Utility.ScentEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class UnwaveringNature extends Enchantment {
    public UnwaveringNature(EquipmentSlot... slots) {
        super(Rarity.VERY_RARE, Senchantments.FUNGAL_ITEMS, slots);
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public void doPostAttack(LivingEntity livingEntity, Entity entity, int value) {
        if (entity instanceof LivingEntity livingEntity1){
            livingEntity1.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,1));
        }
        super.doPostAttack(livingEntity, entity, value);
    }

    @Override
    public void doPostHurt(LivingEntity livingEntity, Entity entity, int value) {
        livingEntity.getArmorSlots().forEach(stack -> {
            if (stack.getEnchantmentLevel(this) > 0){
                if (!livingEntity.hasEffect(Seffects.MYCELIUM.get())){
                    livingEntity.addEffect(new MobEffectInstance(Seffects.MYCELIUM.get(),600,0));
                }
                if (Math.random() < 0.05){
                    ScentEntity scent = new ScentEntity(Sentities.SCENT.get(),livingEntity.level());
                    scent.moveTo(livingEntity.getX(),livingEntity.getY(),livingEntity.getZ());
                    livingEntity.level().addFreshEntity(scent);
                }
            }
        });
        super.doPostAttack(livingEntity, entity, value);
    }
}
