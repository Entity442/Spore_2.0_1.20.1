package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeAxeItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class InfectedArmads extends SporeAxeItems {
    public InfectedArmads() {
        super(SConfig.SERVER.armads_damage.get(), 3.5, 3.2, SConfig.SERVER.armads_durability.get(), 3);
    }

    @Override
    public boolean canMultiBreak(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        return !living.isCrouching();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int val, boolean value) {
        super.inventoryTick(stack, level, entity, val, value);
        if (entity instanceof LivingEntity livingEntity && livingEntity.tickCount % 60 == 0 && livingEntity.getHealth() <= livingEntity.getMaxHealth()/2){
            if (livingEntity.getMainHandItem().getItem().equals(this)){
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,60,0));
            }
        }
    }
}
