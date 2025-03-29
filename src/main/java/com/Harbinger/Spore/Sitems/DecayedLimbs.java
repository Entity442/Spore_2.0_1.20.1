package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.Seffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class DecayedLimbs extends BaseItem{
    public DecayedLimbs(Properties properties) {
        super(properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (!world.isClientSide) {
            if (entity.hasEffect(Seffects.MADNESS.get())) {
                entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 300, 1));
            } else {
                entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 300, 0));
            }
        }
        return super.finishUsingItem(stack, world, entity);
    }
}
