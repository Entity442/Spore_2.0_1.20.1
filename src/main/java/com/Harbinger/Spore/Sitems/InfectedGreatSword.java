package com.Harbinger.Spore.Sitems;

import com.Harbinger.Spore.Core.*;
import com.Harbinger.Spore.Sitems.BaseWeapons.SporeSwordBase;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class InfectedGreatSword extends SporeSwordBase {
    public InfectedGreatSword() {
        super(SConfig.SERVER.greatsword_damage.get(), 3f, 3F, SConfig.SERVER.greatsword_durability.get());
    }

    @Override
    public boolean canDisableShield(ItemStack stack, ItemStack shield, LivingEntity entity, LivingEntity attacker) {
        return true;
    }



}
